package com.foxivid.baselib.streaming.server

import com.foxivid.baselib.bot.TelegramBot
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.network.HeaderInterceptor
import com.foxivid.baselib.streaming.engine.DeviceType
import com.foxivid.baselib.event.StreamingEvent
import com.foxivid.baselib.event.StreamingNoticeEvent
import com.foxivid.baselib.metric.MetricReporter
import com.foxivid.baselib.metric.model.StreamEndStabilityMetric
import com.foxivid.baselib.streaming.engine.EngineException
import com.foxivid.baselib.streaming.engine.EngineListener
import com.foxivid.baselib.streaming.engine.StreamEngineFactory
import org.greenrobot.eventbus.EventBus
import com.foxivid.baselib.streaming.engine.EngineOptions
import com.foxivid.baselib.streaming.engine.MediaType
import com.foxivid.baselib.streaming.engine.PlayType
import com.foxivid.baselib.streaming.engine.StreamEngine
import com.foxivid.baselib.streaming.engine.TrackerAddress
import com.foxivid.baselib.user.UserManager
import com.foxivid.baselib.util.Preferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.slf4j.LoggerFactory
import java.util.Locale
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicLong

/**
 * Original: x1/f1/lb/streaming/server/b.java (+ b$a, b$b "listener", b$c, lambda server/a)
 *
 * Ponte entre o [HttpServiceWrapper] e o motor proprietário ([StreamEngine] = x6.c). Mantém a sessão de play,
 * repassa start/stop, lê playlist/blocos com retentativa e trata os eventos do motor:
 *
 * - **"tracker logout"** ([EngineListener.onTrackerLogout]): o tracker expulsou o cliente. Na 1ª vez marca
 *   `kickedOut` e avisa o [UserManager] com motivo ("streaming", 1=sessão fora (1002), 2=versão não suportada (1003),
 *   3=token expirado (1004), 5=outros). Também publica evento nf.v no EventBus.
 * - **"tracker event"** ([EngineListener.onTrackerEvent] / [EngineListener.onTrackerTimeout]): erros do tracker
 *   (ex.: -1000 timeout, 4008 mídia gratuita inválida...). Publica nf.v.
 * - "peer server event" / "prt logout": idem para o servidor PR.
 * - Envia ao bot (Telegram) mensagens "[streaming][code] ..." no máximo uma vez por código até recuperar;
 *   ao receber blocos de novo após ≥ 60 s envia "recovered".
 * - Métricas por bloco (tamanho, tempo, reenvios, perda, RTT, velocidade) → listener [MetricListener].
 */
class EngineService(private val metricListener: MetricListener) {

    private val logger = LoggerFactory.getLogger(EngineService::class.java)

    /** Original: b$c */
    interface MetricListener {
        fun n(bytes: Long, resendCount: Long, resendRate: Int, costMillis: Long, avgLossRate: Int, avgSpeedBps: Long,
              rtt: Int, minRtt: Int, maxRtt: Int, avgRtt: Int)
    }

    private var engine: StreamEngine? = null
    /** Original: b.f21022b = Long.toString(of.a.i()) — versão do app (appVersion), 5º argumento do motor. */
    private val peerId: String = HeaderInterceptor.appVersion().toString()
    private var playSession: Long = 0
    private var player: Int = 0
    private var lastStopSession: Long = 0
    private var uid = ""
    private var routeId = ""
    private var mediaId = ""
    private var playType: PlayType = PlayType.LIVE
    private var mediaMode = 0
    private var isFirstPlay = true
    private val kickedOut = AtomicBoolean(false)
    private var botEventTimes: MutableMap<Int, Long> = HashMap()
    private val lastBotTime = AtomicLong(0)
    private var trackerReady = false
    private var options: EngineOptions? = null

    init {
        // Original: restaura "sp_streaming_event_bot_time_in_ces" (Map<Int,Long>) das preferências
        Preferences.getString("sp_streaming_event_bot_time_in_ces", Preferences.Callback { json ->
            if (json.isNotEmpty()) try {
                botEventTimes = Gson().fromJson(json, object : TypeToken<HashMap<Int, Long>>() {}.type)
            } catch (_: Throwable) {}
        }, "")
    }

    /** Original: b$b — callbacks do motor. */
    private val listener = object : EngineListener {
        override fun onTrackerRtt(a: Long, b: Long, rtt: Long) { /* d1.f("trk", rtt, a, b) — métrica */ }
        override fun onSignature(uid: String, mediaId: String, signature: String) = SignatureCache.put(uid, mediaId, signature)
        override fun onPeerServerEvent(mediaId: String, code: Int, msg: String) {
            if (code == 4101) trackerReady = false
            if (kickedOut.compareAndSet(false, true)) postStreamingEvent(mediaId, code, msg)
            if (BaseLibConfig.isDebug) logger.info("[Listener]On peer server event [{}][{}][{}]", peerId, code, msg)
            botStreamingEvent(mediaId, code)
        }
        override fun onTrackerLogout(mediaId: String, code: Int, msg: String) {
            if (BaseLibConfig.isDebug) logger.warn("[Listener]On tracker logout[{}, {}, {}, {}, {}, {}]", playSession, mediaId, playType, mediaMode, code, msg)
            if (kickedOut.compareAndSet(false, true)) {
                val reason = when (code) { 1003 -> 2; 1002 -> 1; 1004 -> 3; else -> 5 }
                UserManager.onKickedOut("streaming", reason) // Original: user.f.Z0("streaming", reason)
                botStreamingEvent(mediaId, code)
            }
            postStreamingEvent(mediaId, code, msg)
        }
        override fun onPrtLogout(mediaId: String, code: Int, msg: String) {
            if (BaseLibConfig.isDebug) logger.warn("[Listener]On prt logout[{}, {}, {}, {}, {}, {}]", playSession, mediaId, playType, mediaMode, code, msg)
            postStreamingEvent(mediaId, code, msg, sticky = true)
            botStreamingEvent(mediaId, code)
        }
        override fun onNotice(code: Int, msg: String) {
            EventBus.getDefault().postSticky(StreamingNoticeEvent(playSession, player, code, msg))   // xe.c.c().o(new nf.t(...))
            if (BaseLibConfig.isDebug) logger.info("[Listener]On notice [{}][{}]", code, msg)
        }
        override fun onTrackerTimeout() {
            postStreamingEvent(mediaId, -1000, "") // NotificationManagerCompat.IMPORTANCE_UNSPECIFIED = -1000
            if (BaseLibConfig.isDebug) logger.info("[Listener]On tracker event [{}][{}][{}]", peerId, -1000, "")
            botStreamingEvent(mediaId, -1000)
        }
        override fun onPrtTimeout(mediaId: String) {
            postStreamingEvent(mediaId, -4000, "")
            if (BaseLibConfig.isDebug) logger.info("[Listener]On prt event [{}][{}][{}]", peerId, -4000, "")
            botStreamingEvent(mediaId, -4000)
        }
        override fun onTrackerEvent(mediaId: String, code: Int, msg: String) {
            postStreamingEvent(mediaId, code, msg)
            if (BaseLibConfig.isDebug) logger.info("[Listener]On tracker event [{}][{}][{}]", peerId, code, msg)
            botStreamingEvent(mediaId, code)
        }
        override fun onBlockMetric(mediaId: String, blockId: Int, blockSize: Int, resendCount: Int, resendRate: Int,
                                   costMillis: Long, avgLossRate: Int, rtt: Long) {
            val last = lastBotTime.get()
            val now = System.currentTimeMillis()
            if (last > 0 && last + 60000 /* FileWatchdog.DEFAULT_DELAY */ < now && lastBotTime.compareAndSet(last, 0)) {
                val map = botEventTimes
                botEventTimes = HashMap()
                Preferences.putString("sp_streaming_event_bot_time_in_ces", "")
                Preferences.putLong("sp_streaming_last_bot_time_in_ces", 0L)
                val sb = StringBuilder("[streaming]")
                if (map.containsKey(4004) || map.containsKey(4003)) sb.append("[source]")
                sb.append("\nrecovered\nmediaId:").append(mediaId).append(", and ").append(now - last).append(" back to normal\n")
                for ((k, v) in map) sb.append(k).append(": ").append(now - v).append(" back to normal").append("\n")
                TelegramBot.sendSysInfo(sb.toString()) // Original: bot.a.m(...)
            }
            // Agregação da sessão (vf.d = StreamEndStabilityMetric): min/max/média incremental e distribuições por faixa.
            var stat = sessionStat
            if (stat == null) {
                stat = StreamEndStabilityMetric().also {
                    it.route = routeId; it.streamId = mediaId; it.loginSession = UserManager.getLoginSession(); it.session = playSession
                    it.playType = playType.name; it.mediaPlayMode = mediaMode
                }
                sessionBytes = 0L
                sessionMillis = 0L
                sessionStat = stat
            }
            sessionBytes += blockSize.toLong()
            sessionMillis += costMillis
            val n = ++stat.blockCnt
            if (stat.minBlockSize > blockSize) stat.minBlockSize = blockSize else if (stat.maxBlockSize < blockSize) stat.maxBlockSize = blockSize
            stat.avgBlockSize += (blockSize - stat.avgBlockSize) / n
            val sizeUnit = Math.pow(10.0, Math.log10(blockSize.toDouble()).toInt().toDouble()).toInt()
            increment(stat.sizeDistributionMap, if (sizeUnit <= 0) 0 else (blockSize / sizeUnit) * sizeUnit)
            if (stat.minTime > costMillis) stat.minTime = costMillis else if (stat.maxTime < costMillis) stat.maxTime = costMillis
            stat.avgTime += (costMillis - stat.avgTime) / n
            val timeUnit = Math.pow(10.0, Math.log10(costMillis.toDouble()).toInt().toDouble()).toLong()
            increment(stat.timeDistribution, if (timeUnit <= 0L) 0L else timeUnit * (costMillis / timeUnit))
            if (stat.minResendCnt > resendCount) stat.minResendCnt = resendCount else if (stat.maxResendCnt < resendCount) stat.maxResendCnt = resendCount
            stat.avgResendCnt += (resendCount - stat.avgResendCnt) / n
            increment(stat.resendCntDistributionMap, resendCount)
            if (stat.minResendRate > resendRate) stat.minResendRate = resendRate else if (stat.maxResendRate < resendRate) stat.maxResendRate = resendRate
            stat.avgResendRate += (resendRate - stat.avgResendRate) / n
            increment(stat.resendRateDistributionMap, if (resendRate < 10) resendRate else (resendRate / 10) * 10)
            if (stat.minAvgLossRate > avgLossRate) stat.minAvgLossRate = avgLossRate else if (stat.maxAvgLossRate < avgLossRate) stat.maxAvgLossRate = avgLossRate
            stat.avgAvgLossRate += (avgLossRate - stat.avgAvgLossRate) / n
            increment(stat.avgLossRateDistributionMap, if (avgLossRate < 10) avgLossRate else (avgLossRate / 10) * 10)
            val speedBps = if (sessionMillis > 0L) (sessionBytes * 8000) / sessionMillis else 0L   // bits/s acumulado da sessão
            val rttInt = rtt.toInt()
            if (stat.minRTT > rtt) stat.minRTT = rttInt else if (stat.maxRTT < rtt) stat.maxRTT = rttInt
            stat.avgRTT += (rtt - stat.avgRTT) / n
            metricListener.n(blockSize.toLong(), resendCount.toLong(), resendRate, costMillis, avgLossRate, speedBps, rttInt, stat.minRTT, stat.maxRTT, stat.avgRTT.toInt())
            if (BaseLibConfig.isDebug) logger.debug("onBlockMetric mediaId[{}], blockId[{}], blockSize[{}], resendCount[{}], resendRate[{}], avgLossRate[{}], avgSpeed[{}]",
                mediaId, blockId, blockSize, resendCount, resendRate, avgLossRate, speedBps)
        }
    }

    /** Original: b$b.k(String, int) — monta texto para o bot; cada código só é enviado uma vez até recuperar. */
    @Synchronized
    private fun botStreamingEvent(mediaId: String, code: Int) {
        try {
            if (botEventTimes[code] != null && code != -1000 && code != -4000) return
            val l = Locale.ENGLISH
            val warn = when (code) {
                -4000 -> String.format(l, "[streaming][%d]\nconnect prt timeout\nmediaId:%s", code, mediaId)
                -1000 -> String.format(l, "[streaming][%d]\nconnect trk timeout\nmediaId:%s", code, mediaId)
                4008 -> String.format(l, "[streaming][%d]\nfree media invalid\nmediaId:%s", code, mediaId)
                4101 -> String.format(l, "[streaming][%d]\nstart play failure tr stopped\nmediaId:%s", code, mediaId)
                1000 -> String.format(l, "[streaming][%d]\nallocate free media invalid\nmediaId:%s", code, mediaId)
                1001 -> String.format(l, "[streaming][%d]\nallocate server invalid\nmediaId:%s", code, mediaId)
                4003 -> String.format(l, "[streaming][source][%d]\ninvalid stream\n[%s] mediaId:%s", code, playType, mediaId)
                4004 -> String.format(l, "[streaming][source][%d]\ninvalid stream id\n[%s] mediaId:%s", code, playType, mediaId)
                else -> ""
            }
            val error = when (code) {
                4006, 1004 -> String.format(l, "[streaming][%d]\nexpired token\nmediaId:%s", code, mediaId)
                4007, 1003 -> String.format(l, "[streaming][%d]\napp version not support\nmediaId:%s", code, mediaId)
                1002 -> String.format(l, "[streaming][%d]\nclient session out\nmediaId:%s", code, mediaId)
                else -> ""
            }
            if (error.isEmpty() && warn.isEmpty()) return
            if (error.isEmpty()) TelegramBot.sendSysError(warn) else TelegramBot.sendSysWarn(error) // bot.a.l / bot.a.n (nomes como no original)
            val now = System.currentTimeMillis()
            lastBotTime.set(now)
            botEventTimes[code] = now
            Preferences.putString("sp_streaming_event_bot_time_in_ces", Gson().toJson(botEventTimes))
            Preferences.putLong("sp_streaming_last_bot_time_in_ces", now)
        } catch (t: Throwable) {
            logger.error("bot streaming event failure", t)
        }
    }

    /** Original: EventBus.post(new nf.v(mediaId, session, player, code, msg)) — evento de outro módulo. */
    private fun postStreamingEvent(mediaId: String, code: Int, msg: String, sticky: Boolean = false) {
        val event = StreamingEvent(mediaId, playSession, player, code, msg)
        if (sticky) EventBus.getDefault().postSticky(event) else EventBus.getDefault().post(event)   // xe.c.c().o(...) / .l(...)
    }

    /**
     * Original: b.K(uid, did, token, tenantId, deviceType, trackers, playType)
     * Cria o motor `x6.c(uid, did, token, tenantId, peerId, DeviceType, PlayType, EngineOptions, listener)`
     * e inicia o cliente do tracker. Se já existe motor do mesmo tipo, nada faz; tipo diferente ⇒ para e recria.
     */
    @Synchronized
    fun startEngine(uid: String?, did: String?, token: String?, tenantId: String?, deviceType: Int,
                    trackers: List<TrackerAddress>, type: PlayType): Boolean {
        isFirstPlay = true
        if (engine != null) {
            if (playType == type) { logger.warn("start Engine[{}], but engine is already started.", type); return true }
            logger.error("restart Engine[{}->{}], but engine is already started.", playType, type)
            stopEngine()
        }
        if (options == null) {
            options = EngineOptions().also { it.blockCache = VodLocalDiskCacheManager }
            applyConfig()
        }
        this.uid = uid ?: ""
        // NÃO RECUPERÁVEL: `new x6.c(uid, did, token, tenantId, peerId, DeviceType.of(deviceType), type, options, listener)` instancia o motor P2P
        // proprietário (pacotes x6/y6/c7/e7/g7/h7/a7, ~3,7 mil linhas) que não faz parte do SDK x1/f1/lb e não foi reconstruído.
        // Comportamento aproximado: a fábrica [StreamEngineFactory] falha com UnsupportedOperationException (sem motor não há streaming).
        val e: StreamEngine = StreamEngineFactory.create(uid ?: "", did, token, tenantId, peerId, DeviceType.of(deviceType), type, options!!, listener)
        e.startTracker(trackers)
        playType = type
        if (BaseLibConfig.isDebug) logger.debug("start_engin_with [{}, {}, {}, {}, {}, {}, {}]", uid, did, playSession, deviceType, type, mediaId, token)
        kickedOut.set(false)
        engine = e
        trackerReady = true
        logger.info("engine is started")
        return true
    }

    /** Original: b.L(mediaId, routeId, mediaMode, session) */
    @Synchronized
    fun startPlay(mediaId: String?, routeId: String?, mediaMode: Int, session: Long): Boolean {
        val e = engine
        if (e == null) {
            if (kickedOut.get()) logger.warn("start play, [{}] [{}] [{}], but kicked out", mediaId, routeId, mediaMode)
            else logger.error("start play, but engine is not start")
            return false
        }
        flushMetric()
        if (BaseLibConfig.isDebug) logger.debug("startPlay@[{}], play_session[{}], playType[{}], requestSession[{}], mediaId[{}], playMode[{}]", hashCode(), playSession, playType, session, mediaId, mediaMode)
        playSession = session
        this.routeId = routeId ?: ""
        this.mediaId = mediaId ?: ""
        this.mediaMode = mediaMode
        applyConfig()
        // Original: f21041u = new wf.a() — monitor de fluxo TS (outro módulo)
        val signature = SignatureCache.get(uid, this.mediaId)
        if (BaseLibConfig.isDebug) logger.debug("get_signature uid[{}], mediaId[{}], signature[{}]", uid, mediaId, signature)
        e.startPlay(mediaId, routeId, mediaMode, signature)
        if (isFirstPlay) isFirstPlay = false
        return true
    }

    /** Original: b.N(Long) */
    @Synchronized
    fun stopPlay(session: Long): Boolean {
        val e = engine ?: run { logger.error("stop Play, but engine is null"); return false }
        if (BaseLibConfig.isDebug) logger.debug("stopPlay@[{}], requestSession[{}], play_session[{}], playType[{}], mediaId[{}], playMode[{}]", hashCode(), session, playSession, playType, mediaId, mediaMode)
        flushMetric()
        e.stopPlay()
        lastStopSession = session
        playSession = 0
        return true
    }

    /** Original: b.M() */
    @Synchronized
    fun stopEngine(): Boolean {
        val e = engine ?: run { logger.error("stop Engine, but it is null"); return false }
        if (BaseLibConfig.isDebug) logger.debug("stopEngine@[{}], session[{}], playType[{}], mediaId[{}], playMode[{}]", hashCode(), playSession, playType, mediaId, mediaMode)
        engine = null
        e.stop()
        logger.info("stop engine [{}] completed", playSession)
        playSession = 0
        return true
    }

    /**
     * Original: b.A(session, mediaId, name, timeoutMs) / b.z(session, mediaId, name) (timeout 60000)
     * Lê `playlist.m3u8`, `<bloco>.ts` ou `<LANG>.srt` do motor. Se ainda não há dados, tenta
     * `timeout/10` vezes com sleep de 10 ms. Erros b7.a com código 2001/1001 retornam null; outros relançam
     * (exceto se o PR não está conectado ⇒ null).
     */
    fun getData(session: Long, mediaId: String?, name: String, timeoutMs: Int = 60000): ByteArray? {
        val e = engine
        if (e == null) {
            if (!kickedOut.get()) throw RuntimeException("engine is not init")
            logger.warn("get data [{}] [{}], but kicked out", mediaId, name); return null
        }
        if (session != playSession || mediaId != this.mediaId) {
            logger.warn("get data mismatch, request play_session[{}] mediaId[{}], but now session[{}] mediaId[{}]", session, mediaId, playSession, this.mediaId)
            return null
        }
        try {
            val type = MediaType.ofExtension(name.substringAfterLast('.')) ?: throw RuntimeException("Unknown extension")
            var data = e.q(type, mediaId, name)
            var tries = 0
            val max = maxOf(timeoutMs / 10, 1)
            while (data == null && tries < max) {
                data = e.q(type, mediaId, name)
                if (data == null) { Thread.sleep(10); tries++ }
            }
            // Original (debug): log "zapping_time_opt client_service_get_data_ts" e alimenta wf.a com os bytes
            return data
        } catch (t: Throwable) {
            if (!e.isPrConnected()) return null
            val state = if (lastStopSession >= session) "closed" else "active"
            var msg = ""
            if (t is EngineException) {   // b7.a: exceção do motor (código + mensagem)
                msg = String.format(Locale.ENGLISH, "get data failure, [%d/%s] [%s/%s], %d:%s", session, state, mediaId, name, t.code, t.msg)
                if (t.code == 2001 || t.code == 1001) { logger.warn(msg); return null }
            }
            if (msg.isEmpty()) {
                var localized = t.localizedMessage
                if (localized.isNullOrEmpty()) localized = t.message
                if (localized.isNullOrEmpty()) localized = "get data failure,"
                msg = String.format(Locale.ENGLISH, "%s [%d/%s] [%s/%s]", localized, session, state, mediaId, name)
            }
            logger.error("get data failure", t)
            throw RuntimeException(msg, t)
        }
    }

    /** Original: b.I() — aplica ts_push_mode e maxDownloadingBlockCnt vindos do heartbeat. */
    private fun applyConfig() {
        val opt = options ?: return
        BaseLibConfig.tsPushMode?.let { mode ->
            val it = com.foxivid.baselib.streaming.engine.PushMode.of(mode.value) ?: return@let   // v6.d -> mesmo valor numérico
            if (it != opt.pushMode) { logger.info("set push mode [{} -> {}]", opt.pushMode, it); opt.pushMode = it }
        }
        BaseLibConfig.maxDownloadingBlockCnt?.let {
            if (it != opt.maxDownloadingBlockCnt) { logger.info("set max downloading block cnt [{} -> {}]", opt.maxDownloadingBlockCnt, it); opt.maxDownloadingBlockCnt = it }
        }
    }

    /** Original: b.H() — envia a métrica de sessão acumulada (vf.d → uf.c.q). */
    private fun flushMetric() {
        val stat = sessionStat ?: return
        sessionStat = null
        MetricReporter.reportStreamEndStability(stat)   // uf.c.q(vf.d)
    }

    // Acumuladores da sessão corrente (campos f21023c/f21034n/f21035o do original)
    private var sessionStat: StreamEndStabilityMetric? = null
    private var sessionMillis = 0L
    private var sessionBytes = 0L

    /** Incrementa o contador da faixa [key] (cria com 1). Original: b.y(Map, K) */
    private fun <K> increment(map: MutableMap<K, java.util.concurrent.atomic.AtomicInteger>, key: K) {
        val c = map[key]
        if (c == null) map[key] = java.util.concurrent.atomic.AtomicInteger(1) else c.incrementAndGet()
    }

    /** Original: b.C(String) — "isConnected": motor existe, tracker pronto e tipo igual. */
    fun isConnected(type: String): Boolean {
        if (engine == null || !trackerReady || playType.name != type) return false
        return if (isFirstPlay) true else isEngineRunning()
    }

    /** Original: b.D() */
    fun isEngineRunning(): Boolean = engine != null

    /** Original: b.F(String) */
    fun refreshToken(token: String) {
        val e = engine
        if (e != null) e.refreshToken(token)
        else {
            if (!kickedOut.get()) throw RuntimeException("engine is not init")
            logger.error("refresh token [{}], but kicked out", token)
        }
    }

    /** Original: b.J(long, int) */
    fun setPlayer(session: Long, p: Int) { if (playSession == session) player = p }
    /** Original: b.G(long) */
    fun clearPlayer(session: Long) { if (playSession == session) player = 0 }
    /** Original: b.x() */
    fun onPlayerRestart() { engine?.onPlayerRestart() }
    /** Original: b.B() */
    fun engine(): StreamEngine? = engine
}
