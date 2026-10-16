package com.foxivid.baselib.streaming

import com.foxivid.baselib.metric.model.PlayerZappingStat
import com.foxivid.baselib.metric.monitor.ZappingMonitor
import com.foxivid.baselib.util.ServerTime
import com.foxivid.baselib.util.StartStatUtil
import com.foxivid.baselib.util.TextCipher

import android.util.Base64
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.model.meta.ChannelStreamResponse
import com.foxivid.baselib.media.EpgManager
import com.foxivid.baselib.streaming.client.EngineHelper
import com.foxivid.baselib.streaming.engine.PlayType
import com.foxivid.baselib.streaming.server.StreamingKeys
import com.foxivid.baselib.user.UserManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.slf4j.LoggerFactory
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger

/**
 * Original: nf/r.java — evento "URL de play pronta" (emitido pelo fluxo de [StreamHelper]).
 * `url` é a URL local (127.0.0.1) que o player deve abrir; `session` = timestamp de criação da sessão.
 */
data class PlayUrlReadyEvent(
    val mediaId: String?,
    val routeId: String?,
    val mediaMode: Int,
    val playType: PlayType,
    val url: String,
    val session: Long,
) {
    var videoName: String? = null
    var playPositionPersistenceKey: String? = null
}

/**
 * Original: x1/f1/lb/streaming/a.java ("StreamHelper.kt") (+ a$a..a$p)
 *
 * Orquestra uma "sessão de play" sobre o [EngineHelper]:
 * 1. ([checkAndStartPlayFlow]) sob mutex: se uid/tipo/mediaId/route/mediaMode iguais ao último e o motor diz
 *    "isConnected", reaproveita o último [PlayUrlReadyEvent].
 * 2. Senão cria `session = d1.c()` (relógio monotônico/ms da lib), registra métrica de zapping e:
 *    - se mudou de usuário ou de tipo (LIVE/VOD/CATCHUP) ⇒ para a sessão anterior e **reinicia o motor**
 *      ([restartEngine] → `UserManager.J1(playType)` → `EngineHelper.create(streamServers, streamToken, ...)`);
 *    - senão ([prepareFlow]) para a sessão anterior (se houver), verifica `isConnected` e, se preciso, reinicia.
 * 3. [startPlay]: `EngineHelper.startPlay(mediaId, session, type, "<session>=<id>&<params>=<cifra(mediaId,routeId,mediaMode)>")`.
 *
 * Parâmetros sensíveis vão sempre cifrados: AES/ECB/ZeroBytePadding com chave **aleatória por processo**
 * (x1.f1.lb.util.a, chave fixa alternativa "PrI8TBSHDuybYmKSdaBBYg" não usada aqui) + Base64 URL_SAFE|NO_WRAP.
 */
object StreamHelper {

    private val logger = LoggerFactory.getLogger(StreamHelper::class.java)

    private var lastPlaySession: Long? = null
    private var engineRestartCnt = 0
    private var lastMetaId: String? = null
    private var lastRouteId: String? = null
    private var lastMediaMode: Int? = null
    private var lastUid: String? = null
    private var lastUrlReadyEvent: PlayUrlReadyEvent? = null
    private var lastPlayType: PlayType = PlayType.LIVE
    private val mutex = Mutex()
    private val count = AtomicInteger(0)

    /** Original: a.w(String) — cifra (util.a.c com chave aleatória) + Base64 flags 10 (URL_SAFE|NO_WRAP). */
    fun encodeParams(params: String): String =
        Base64.encodeToString(ParamCipher.encrypt(params).toByteArray(Charsets.UTF_8), Base64.URL_SAFE or Base64.NO_WRAP)

    /** Original: a.v(String) — inverso de [encodeParams]. */
    fun decodeParams(params: String): String =
        ParamCipher.decrypt(String(Base64.decode(params, Base64.URL_SAFE or Base64.NO_WRAP), Charsets.UTF_8))

    /** Original: a.x(mediaId, routeId, mediaMode) */
    private fun playParams(mediaId: String?, routeId: String?, mediaMode: Int): String =
        StreamingKeys.paramsKey + "=" + encodeParams("mediaId=$mediaId&routeId=$routeId&mediaMode=$mediaMode")

    /** Original: a.t(ChannelStreamResponse, AtomicBoolean) — ao vivo: streamName/streamId/route/type. */
    suspend fun createLivePlayFlow(channel: ChannelStreamResponse, forceToStart: AtomicBoolean): Flow<PlayUrlReadyEvent> =
        checkAndStartPlayFlow(PlayType.LIVE, channel.streamName, channel.streamId, channel.route, channel.type, forceToStart.get())

    /**
     * Original: a.q(...) ("checkAndStartPlayFlow")
     * @param videoName nome exibido; @param mediaId streamId; @param routeId rota; @param mediaMode "type" do canal.
     */
    suspend fun checkAndStartPlayFlow(playType: PlayType, videoName: String?, mediaId: String?, routeId: String?,
                                      mediaMode: Int, isForce: Boolean): Flow<PlayUrlReadyEvent> {
        val uid = UserManager.uid() // Original: user.f.B0()
        mutex.withLock {
            val last = lastUrlReadyEvent
            if (!isForce && lastUid == uid && playType == lastPlayType && mediaId == lastMetaId &&
                lastMediaMode != null && mediaMode == lastMediaMode && routeId == lastRouteId && last != null) {
                if (EngineHelper.isConnected(playType)) {
                    logger.info("create_session[${last.session}] $isForce, $videoName, $mediaId, in lock")
                    return flowOf(last)
                }
            }
            val seq = count.incrementAndGet()
            lastUrlReadyEvent = null; lastMetaId = null; lastMediaMode = null; lastRouteId = null
            val session = SessionClock.now() // Original: d1.c()
            // h.a(playType, videoName, mediaId, routeId, session, mediaMode): abre a métrica de zapping (fecha/relata a anterior)
            val zappingStat: ZappingStat = ZappingStatAdapter(
                ZappingMonitor.startZapping(playType, videoName ?: "", mediaId ?: "", routeId ?: "", session, mediaMode))
            zappingStat.setStart(SessionClock.now())
            StartStatUtil.addStep(session, "$mediaId.create_session")   // Original: a1.h(session, "<mediaId>.create_session")

            val playFlow: Flow<PlayUrlReadyEvent> =
                // Nota: o jadx mostra `if (m.a(lastUid, uid) || type != lastPlayType)` mas as duas ramificações
                // são idênticas e o log diz "will restart engine to change from…"; a intenção é reiniciar
                // quando uid OU tipo mudam. Ver discussão em docs/pipeline_streaming.md.
                if (lastUid != uid || playType != lastPlayType) {
                    logger.info("will restart engine to change from [$lastUid, $lastPlayType] to [$uid, $playType]")
                    val prev = lastPlaySession
                    if (prev != null) {
                        lastPlaySession = null
                        EngineHelper.stopPlay(prev, "check and start").flatMapConcat {
                            lastPlaySession = null
                            restartEngine(playType).flatMapConcat { prepareFlow(session, zappingStat, playType, mediaId, routeId, mediaMode) }
                        }
                    } else {
                        restartEngine(playType).flatMapConcat { prepareFlow(session, zappingStat, playType, mediaId, routeId, mediaMode) }
                    }
                } else {
                    prepareFlow(session, zappingStat, playType, mediaId, routeId, mediaMode)
                }

            // Coleta dentro do lock para serializar a criação de sessões; erro é relançado num novo flow.
            val errors = ArrayList<Throwable>()
            val events = ArrayList<PlayUrlReadyEvent>()
            val dec = count.decrementAndGet()
            playFlow.catch { errors.add(it) }.collect {
                logger.info("create_session[${it.session}] $isForce, $videoName, $mediaId, $seq -> $dec")
                lastUid = uid
                events.add(it)
            }
            return flow {
                when {
                    events.isNotEmpty() -> emit(events[0])
                    errors.isNotEmpty() -> throw errors[0]
                    else -> throw Exception("unknown error")
                }
            }
        }
    }

    /**
     * Original: a.y(...) ("prepareFlow") — para a sessão anterior (se houver); se o motor está conectado
     * para o tipo, toca; senão reinicia o motor e toca ("restart engine failure" se falhar).
     */
    private suspend fun prepareFlow(session: Long, zappingStat: ZappingStat, playType: PlayType, mediaId: String?,
                                    routeId: String?, mediaMode: Int): Flow<PlayUrlReadyEvent> {
        val prev = lastPlaySession
        if (prev != null) {
            return EngineHelper.stopPlay(prev, "prepare $session").flatMapConcat { stopped ->
                lastPlaySession = null
                val connected = if (stopped) EngineHelper.isConnected(playType) else false
                if (stopped && connected) startPlay(session, mediaId, routeId, mediaMode, playType, zappingStat)
                else restartEngine(playType).flatMapConcat { ok ->
                    if (ok) startPlay(session, mediaId, routeId, mediaMode, playType, zappingStat)
                    else throw Exception("restart engine failure")
                }
            }
        }
        if (EngineHelper.isConnected(playType)) return startPlay(session, mediaId, routeId, mediaMode, playType, zappingStat)
        return restartEngine(playType).flatMapConcat { ok ->
            if (ok) startPlay(session, mediaId, routeId, mediaMode, playType, zappingStat)
            else throw Exception("restart engine failure")
        }
    }

    /**
     * Original: a.u(...) — `EngineHelper.startPlay(mediaId, session, type, "<session>=<id>&<params>=...")`;
     * ao receber a URL: libera o EPG ([EpgManager.allowStart]) e publica [PlayUrlReadyEvent].
     */
    private fun startPlay(session: Long, mediaId: String?, routeId: String?, mediaMode: Int, playType: PlayType,
                          zappingStat: ZappingStat): Flow<PlayUrlReadyEvent> {
        zappingStat.markEngineStart(SessionClock.now()) // tf.d.e0
        if (BaseLibConfig.isDebug) logger.debug("engine start play")
        val params = StreamingKeys.sessionKey + "=" + session + "&" + playParams(mediaId, routeId, mediaMode)
        return EngineHelper.startPlay(mediaId ?: "", session, playType, params)
            .catch { t ->
                zappingStat.setFailure(1, -1, t.message ?: t.javaClass.simpleName) // tf.d.G/F/E
                logger.error("start play failure[$session][$playType][$mediaId]", t)
                throw t
            }
            .map { (url, s) ->
                lastPlaySession = s
                zappingStat.markUrlReady(SessionClock.now()) // tf.d.X
                EpgManager.allowStart()                      // media.c.P()
                val ev = PlayUrlReadyEvent(mediaId, routeId, mediaMode, lastPlayType, url, s)
                lastMetaId = mediaId; lastMediaMode = mediaMode; lastRouteId = routeId
                lastUrlReadyEvent = ev
                ev
            }
    }

    /**
     * Original: a.s(...) ("createPlayFlow" catch-up)
     * params cifrados: streamId, catchupStreamId, route(catchupRoute), start, stop (ms) ⇒
     * `EngineHelper.startCatchup(session, "<session>=..&<params>=...")`.
     */
    fun createCatchupPlayFlow(channel: ChannelStreamResponse, videoName: String?, start: Long, stop: Long,
                              mediaMode: Int, forceToStart: AtomicBoolean): Flow<PlayUrlReadyEvent> {
        if (!channel.isCatchup) throw Exception("catchup unavailable")
        val streamId = channel.streamId
        val catchupStreamId = channel.catchupStreamId
        val catchupRoute = channel.catchupRoute
        val session = SessionClock.now()
        val enc = encodeParams("streamId=$streamId&catchupStreamId=$catchupStreamId&route=$catchupRoute&start=$start&stop=$stop")
        val params = StreamingKeys.sessionKey + "=" + session + "&" + StreamingKeys.paramsKey + "=" + enc
        // Original: metric.monitor.h.a(CATCHUP, streamName, catchupStreamId, catchupRoute, session, mediaMode).setStart(...)
        return EngineHelper.startCatchup(session, params)
            .catch { t -> logger.error("start play failure[$session][${PlayType.CATCHUP}][$streamId][$catchupStreamId]", t); throw t }
            .map { (url, s) ->
                lastPlaySession = s
                val ev = PlayUrlReadyEvent(videoName, catchupRoute, mediaMode, PlayType.CATCHUP, url, s)
                lastMetaId = videoName; lastMediaMode = mediaMode; lastRouteId = catchupRoute
                lastUrlReadyEvent = ev
                lastPlayType = PlayType.CATCHUP
                ev
            }
    }

    /**
     * Original: a.z(PlayType?) ("restartEngine") — `UserManager.J1(type)` (que chama
     * `EngineHelper.create(json(streamServers), streamToken, uid, did, tenantId, deviceType, type)`).
     * Em sucesso zera o contador, guarda uid e tipo.
     */
    suspend fun restartEngine(type: PlayType? = null): Flow<Boolean> {
        engineRestartCnt++
        val t = type ?: lastPlayType
        return UserManager.startEngine(t).map { ok ->
            if (ok) {
                engineRestartCnt = 0
                lastUid = UserManager.uid()
                if (type != null) lastPlayType = t
            }
            ok
        }
    }

    /** Original: a.r(session) ("clearPlaySession") */
    fun clearPlaySession(session: Long) {
        CoroutineScope(Dispatchers.IO).launch {
            mutex.withLock {
                if (lastPlaySession == session) lastPlaySession = null
                if (lastUrlReadyEvent?.session == session) lastUrlReadyEvent = null
                EngineHelper.stopPlay(session, "clean session").catch { }.collect { }
            }
        }
    }
}

/** Original: x1.f1.lb.util.a (chamado com isRandomKey = true) — outro módulo (util). */
internal object ParamCipher {
    fun encrypt(s: String): String = TextCipher.encrypt(s, true)   // util.a.c(text, randomKey): AES/ECB/ZeroBytePadding
    fun decrypt(s: String): String = TextCipher.decrypt(s, true)   // util.a.a(text, randomKey)
}

/** Original: x1.f1.lb.util.d1.c() — relógio de sessão da lib (outro módulo). */
internal object SessionClock { fun now(): Long = ServerTime.elapsedNow() }   // d1.c(): início do processo + tempo decorrido

/** Adaptador de [PlayerZappingStat] (tf.d): `setStart` = start, `markEngineStart` = startEnginePlay (e0), `markUrlReady` = playUrlReadyFromEngine (X), falha = (errorType, errorCode, error). */
private class ZappingStatAdapter(private val s: PlayerZappingStat) : ZappingStat {
    override fun setStart(t: Long) { s.start = t }
    override fun markEngineStart(t: Long) { s.startEnginePlay = t }
    override fun markUrlReady(t: Long) { s.playUrlReadyFromEngine = t }
    override fun setFailure(stage: Int, code: Int, msg: String) { s.errorType = stage; s.errorCode = code; s.error = msg }
}

/** Original: tf.d — estatística de zapping (módulo metric). Só os métodos usados aqui. */
interface ZappingStat {
    fun setStart(t: Long)
    fun markEngineStart(t: Long)
    fun markUrlReady(t: Long)
    fun setFailure(stage: Int, code: Int, msg: String)
}
