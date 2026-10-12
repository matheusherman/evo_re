package com.foxivid.baselib.metric.monitor

import android.text.TextUtils
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.metric.MetricReporter
import com.foxivid.baselib.metric.model.BlockStabilityMetric
import com.foxivid.baselib.metric.model.BlockStabilityStat
import com.foxivid.baselib.metric.model.PlayType
import com.foxivid.baselib.metric.model.PlayerMonitorStat
import com.foxivid.baselib.metric.model.PlayerZappingStat
import com.foxivid.baselib.streaming.StreamingClient
import com.foxivid.baselib.util.Clock
import com.foxivid.baselib.util.EventBusHelper
import com.foxivid.baselib.util.LoggerFactory
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.log10
import kotlin.math.pow

/**
 * Monitor de estabilidade da reprodução: acompanha playlist (m3u8), blocos TS, buffering, eventos
 * de restart do player, bitrate/RTT, e ao final gera o "liveChannelEndStability".
 *
 * Original: x1/f1/lb/metric/monitor/f.java (registrado no EventBus via [register]/[unregister])
 */
object PlayerMonitor {
    private val logger = LoggerFactory.getLogger(PlayerMonitor::class.java)
    private var playerZappingStat: PlayerZappingStat? = null
    private var lastPlayStabilityStat: BlockStabilityStat? = null
    private var bufferingStartTime = 0L
    private var playerMonitorStat: PlayerMonitorStat? = null
    private var playerMonitor: PlayerMonitorListener? = null
    /** Original: f.playerZappingMetricTxt — texto de [ZappingMonitor.buildZappingText] */
    var playerZappingMetricTxt = ""; private set
    private var latestRequestTsIndex = -1
    /** Original: f.latestPlayerFirstRequestBlkPosInIndexList (default 2) */
    private var latestPlayerFirstRequestBlkPosInIndexList = 2

    /** Fim de buffering: soma a duração ao bloco ativo e ao total. Original: f.k() */
    @Synchronized private fun onBufferingEnd() {
        if (bufferingStartTime == 0L) return
        val dur = Clock.elapsed() - bufferingStartTime
        logger.debug("buffering end duration[{}]", dur)
        val stat = playerMonitorStat!!
        // Percorre os blocos em ordem reversa e credita ao primeiro criado antes do início do buffering
        for (b in stat.blockStats.values.reversed()) {
            if (b.createTime < bufferingStartTime) { b.bufferingMs = b.bufferingMs + dur; break }
        }
        stat.bufferingMs = stat.bufferingMs + dur
        bufferingStartTime = 0L
    }

    /** Original: f.l() */
    @Synchronized private fun onBufferingStart() {
        val stat = playerMonitorStat!!
        stat.bufferingCnt = stat.bufferingCnt + 1
        bufferingStartTime = Clock.elapsed()
    }

    /** Extrai a sequência numérica do nome do TS: `..._<seq>.ts` ou o nome inteiro. Original: f.w(String) */
    private fun parseTsSeq(tsUrl: String): Long? = try {
        var end = tsUrl.indexOf(".ts")
        if (end <= 0) end = tsUrl.length
        val us = tsUrl.lastIndexOf('_', end)
        if (us >= 0 && end > us) tsUrl.substring(us + 1, end).toLong()
        else try { tsUrl.toLong() } catch (_: Throwable) { logger.warn("no tsSeq found in [{}]", tsUrl); null }
    } catch (t: Throwable) {
        logger.error("parse ts last seq failure", t); null
    }

    /** Evento de início de buffering (nf.p). Original: f.OnEvent(nf.p) */
    @Subscribe(sticky = true, threadMode = ThreadMode.ASYNC)
    fun onBufferingStartEvent(event: com.foxivid.baselib.player.BufferingStartEvent) {
        if (BaseLibConfig.isDebug) logger.debug("buffering on start event")
        StreamingClient.onBufferingStart()
        onBufferingStart()
        EventBus.getDefault().removeStickyEvent(event)
    }

    /** Evento de fim de buffering (nf.o). Original: f.OnEvent(nf.o) */
    @Subscribe(sticky = true, threadMode = ThreadMode.ASYNC)
    fun onBufferingEndEvent(event: com.foxivid.baselib.player.BufferingEndEvent) {
        if (BaseLibConfig.isDebug) logger.debug("buffering on stop event")
        onBufferingEnd()
        EventBus.getDefault().removeStickyEvent(event)
    }

    /** Modo eco ligado (nf.f) → marca isEcoMode = 1. Original: f.onEvent(nf.f) */
    @Subscribe(sticky = true, threadMode = ThreadMode.ASYNC)
    fun onEcoModeEvent(event: com.foxivid.baselib.player.EcoModeEvent) {
        playerMonitorStat?.playEndMetric?.isEcoMode = 1
    }

    /** Estatísticas do player/proxy (ignora bps < 1000). Original: f.y(...) */
    fun updatePlayStats(bps: Long, avgBps: Long, minBps: Long, maxBps: Long, rtt: Int, minRtt: Int, maxRtt: Int, avgRtt: Int,
                        resendCnt: Int, lossRate: Int, resendRate: Int, videoWidth: Int, videoHeight: Int, vCodec: String, aCodec: String) {
        val s = playerMonitorStat ?: return
        if (bps < 1000) return
        s.bps = bps; s.avgBps = avgBps; s.minBps = minBps; s.maxBps = maxBps
        s.rtt = rtt; s.minRtt = minRtt; s.maxRtt = maxRtt; s.avgRtt = avgRtt
        s.resendCnt = resendCnt; s.lossRate = lossRate; s.resendRate = resendRate
        s.videoHeight = videoHeight; s.videoWidth = videoWidth; s.videoCodec = vCodec; s.audioCodec = aCodec
    }

    /** Novo bloco apareceu na playlist. Original: f.a(String, long) */
    private fun addBlock(blockName: String, now: Long) {
        val s = playerMonitorStat ?: return
        val seq = parseTsSeq(blockName)
        val idx = s.blockIndexCounter
        s.blockIndexCounter = idx + 1
        s.blockStats[blockName] = BlockStabilityStat(blockName, seq, idx)
        s.tsSeqList.add(seq?.toString() ?: blockName)
        s.lastBlockName = blockName
        s.lastBlockAddTime = now
    }

    /** Original: f.e(tf.b) */
    private fun toMetric(b: BlockStabilityStat) = BlockStabilityMetric(
        b.desc, b.requestSeq, b.playType, b.mediaPlayMode, b.isNull, b.lastRequestPos, b.responseCount,
        b.responseTime - b.firstRequestTime, b.bufferingMs, b.unknownH)

    /** Pede restart do player por sequência TS fora de ordem (nf.q). Original: f.q(long) */
    private fun sendRestart(session: Long) {
        if (BaseLibConfig.isDebug) logger.debug("send-player-restart-event")
        EventBus.getDefault().post(com.foxivid.baselib.player.PlayerRestartEvent(session, 0, 1, "ts seq check"))
    }

    /**
     * Agrega um bloco que saiu da playlist no PlayEndMetric: null/skip, buffering (histograma por
     * ordem de grandeza: 10^floor(log10(ms))), distribuição de índice de request, duração.
     * Original: f.x(vf.b)
     */
    private fun aggregate(m: BlockStabilityMetric) {
        val p = playerMonitorStat?.playEndMetric ?: return
        if (m.isNull) p.nullBlockCnt = p.nullBlockCnt + 1
        if (TextUtils.isEmpty(m.requestSeq)) p.skipBlockCnt = p.skipBlockCnt + 1
        if (m.bufferingMs > 0) {
            p.bufferingCnt = p.bufferingCnt + 1
            val b = m.bufferingMs
            if (p.minBufferingMs > b) p.minBufferingMs = b
            if (p.maxBufferingMs < b) p.maxBufferingMs = b
            val pow = 10.0.pow(log10(b.toDouble()).toLong().toDouble()).toLong()
            val bucket = (b / pow) * pow
            p.bufferingDistribution.getOrPut(bucket) { AtomicInteger(0) }.incrementAndGet()
        }
        p.requestIndexDistribution.getOrPut(m.lastRequestPos) { AtomicInteger(0) }.incrementAndGet()
        p.playMs = Clock.elapsed() - p.session
    }

    /** Novo monitor para o zapping. Original: f.c(tf.d) */
    fun startMonitor(z: PlayerZappingStat) {
        val s = PlayerMonitorStat()
        s.mediaPlayMode = z.mediaPlayMode
        s.playType = z.playType
        playerMonitorStat = s
        z.monitorStat = s
        s.playEndMetric.apply {
            channel = z.channel; route = z.route; streamId = z.streamId; loginSession = z.loginSession /* vf.a.Z → campo d */
            session = z.session; playSq = z.seq; mediaPlayMode = z.mediaPlayMode; playType = z.playType.name
        }
    }

    /**
     * Bloco saiu da playlist (ou terminou em VOD): agrega e alimenta o heartbeat. Em LIVE mantém no
     * máx. 18 blocos no mapa (remove o primeiro).
     * Original: f.d(String)
     */
    fun onBlockRemoved(blockName: String) {
        val b = playerMonitorStat?.blockStats?.get(blockName)
        if (b != null) {
            val m = toMetric(b)
            aggregate(m)
            MetricReporter.onBlockPlayed(playerMonitorStat?.playEndMetric, m)
        }
        val s = playerMonitorStat
        if (s?.playType == PlayType.LIVE) {
            if (s.blockStats.size <= 18) return
            s.blockStats.remove(s.blockStats.firstKey())
        }
    }

    /** Original: f.f() */ fun latestFirstRequestBlockPos() = latestPlayerFirstRequestBlkPosInIndexList
    /** Original: f.g(String) */ fun blockStat(blockName: String): BlockStabilityStat? = playerMonitorStat?.blockStats?.get(blockName)
    /** Original: f.h() */ fun currentMonitorStat(): PlayerMonitorStat? = playerMonitorStat
    /** Original: f.i() */ fun currentZappingStat(): PlayerZappingStat? = playerZappingStat

    /**
     * Nova playlist recebida. Detecta blocos novos/removidos, maior tamanho, ordem da sequência
     * (LIVE) e, se a playlist voltou à ordem depois de um "disorder", pede restart do player.
     * Original: f.m(List, long)
     */
    fun onPlaylist(playList: List<String>, millis: Long) {
        val s = playerMonitorStat ?: return
        val now = Clock.elapsed()
        s.requestPlaylistCnt = s.requestPlaylistCnt + 1
        s.playlistResponseCost = now - millis
        s.lastPlaylistResponseTime = now
        val old = s.currentPlaylist
        val cur = LinkedHashSet<String>()
        s.tsSeqList.clear()
        for (item in playList) {
            val i = item.indexOf(".ts")
            if (i > 0) {
                val name = item.substring(0, i)
                cur.add(name)
                if (!old.contains(name)) addBlock(name, now)
            }
        }
        for (name in old) if (!cur.contains(name)) onBlockRemoved(name)
        s.currentPlaylist = cur
        s.lastPlaylistMillis = millis
        if (cur.size > s.maxPlaylistSize) s.maxPlaylistSize = cur.size
        if (s.playType == PlayType.LIVE && cur.isNotEmpty()) checkSeqOrder(cur)
        if (s.disorderSeq.isNotEmpty()) {
            if (containsDisorderSeq(cur)) {
                logger.warn("playlist seq reset and out of order, disorderSeq[{}]", s.disorderSeq)
                return
            }
            sendRestart(s.playEndMetric.session)
            logger.warn("playlist become in order, send player restart event, disorderSeq[{}]", s.disorderSeq)
            s.disorderSeq = ""
        }
    }

    /** Copia os contadores para o PlayEndMetric e reporta (uma vez). Original: f.n() */
    fun finishPlay() {
        val s = playerMonitorStat ?: return
        val p = s.playEndMetric
        if (!s.isReported.compareAndSet(false, true)) return
        p.requestPlaylistCnt = s.requestPlaylistCnt
        p.requestBlockCnt = s.requestBlockCnt
        p.bufferingMs = s.bufferingMs
        p.noSignalCnt = s.noSignalCnt
        p.restartPlayerCnt = s.restartCnt
        p.restartPlayerDisorderTSSeqCnt = s.restartDisorderTsSeq
        p.restartPlayerBufferingTooLongCnt = s.restartBufferingTooLong
        p.restartPlayerNoListRequestTooLongCnt = s.restartNoListRequestTooLong
        p.restartPlayerNoListResponseTooLongCnt = s.restartNoListResponseTooLong
        p.restartPlayerNoListUpdateTooLongCnt = s.restartNoListUpdateTooLong
        p.restartPlayerNoBlockResponseTooLongCnt = s.restartNoBlockResponseTooLong
        p.restartPlayerNoBlockRequestTooLongCnt = s.restartNoBlockRequestTooLong
        p.restartPlayerNoBlockUpdateTooLongCnt = s.restartNoBlockUpdateTooLong
        p.videoWidth = s.videoWidth
        p.videoHeight = s.videoHeight
        p.resolutionType = s.resolutionType
        p.videoCodec = s.videoCodec
        p.audioCodec = s.audioCodec
        p.bps = s.bps.toInt(); p.avgBps = s.avgBps.toInt(); p.minBps = s.minBps.toInt(); p.maxBps = s.maxBps.toInt()
        p.rtt = s.rtt; p.minRtt = s.minRtt; p.maxRtt = s.maxRtt; p.avgRtt = s.avgRtt
        p.tsSeqGapCnt = s.tsSeqGapCnt
        p.streamEvent = s.streamEvent
        MetricReporter.reportPlayEnd(p)
    }

    /**
     * Evento de restart do player por motivo. Códigos: 0 TS fora de ordem, 1 buffering longo,
     * 2 sem request de playlist, 3 sem request de bloco, 4 sem resposta de playlist,
     * 5 sem atualização de playlist, 6 sem resposta de bloco, 7 sem atualização de bloco.
     * Original: f.o(int)
     */
    fun onRestartEvent(eventCode: Int) {
        val s = playerMonitorStat ?: return
        s.restartCnt = s.restartCnt + 1
        when (eventCode) {
            0 -> s.restartDisorderTsSeq++
            1 -> s.restartBufferingTooLong++
            2 -> s.restartNoListRequestTooLong++
            3 -> s.restartNoBlockRequestTooLong++
            4 -> s.restartNoListResponseTooLong++
            5 -> s.restartNoListUpdateTooLong++
            6 -> s.restartNoBlockResponseTooLong++
            7 -> s.restartNoBlockUpdateTooLong++
        }
    }

    /** Player pediu um bloco TS. Original: f.p(String) */
    fun onBlockRequested(blockName: String): BlockStabilityStat {
        var b = playerMonitorStat?.blockStats?.get(blockName)
        if (b == null) {
            val s = playerMonitorStat!!
            val idx = s.blockIndexCounter
            s.blockIndexCounter = idx + 1
            b = BlockStabilityStat(blockName, parseTsSeq(blockName), idx)
            if (BaseLibConfig.isDebug) logger.debug("null stability stat on ts request\n{},{}", playerMonitorStat?.blockStats?.keys, blockName)
        }
        val now = Clock.elapsed()
        playerMonitorStat?.lastBlockRequestTime = now
        val pos = playerMonitorStat!!.currentPlaylist.indexOf(blockName)
        if (b.firstRequestPos == -1) {
            b.firstRequestPos = pos
            latestPlayerFirstRequestBlkPosInIndexList = pos
        }
        b.lastRequestPos = pos
        if (b.firstRequestTime == 0L) b.firstRequestTime = now
        latestRequestTsIndex = pos
        val s = playerMonitorStat!!
        val n = s.requestBlockCnt
        s.requestBlockCnt = n + 1
        b.requestSeq = n.toString()
        lastPlayStabilityStat = b
        return b
    }

    /** Original: f.r(tf.d) */
    fun setZappingStat(z: PlayerZappingStat?) {
        playerZappingStat = z
        if (z != null) playerZappingMetricTxt = ZappingMonitor.buildZappingText(z)
    }

    /** Original: f.s(c) */ fun setMonitor(monitor: PlayerMonitorListener) { playerMonitor = monitor }
    /** Original: f.t() — util/e0.a(this) = EventBus.register */ fun register() = EventBusHelper.register(this)
    /** Original: f.v() */ fun unregister() = EventBusHelper.unregister(this)

    /** Conta eventos do stream `e_<code>`; 4003 = sem sinal. Original: f.u(int) */
    fun onStreamEvent(code: Int) {
        val s = playerMonitorStat ?: return
        if (code == 4003) s.noSignalCnt = s.noSignalCnt + 1
        s.streamEvent.getOrPut("e_$code") { AtomicInteger(0) }.incrementAndGet()
    }

    /**
     * Verifica a sequência do último TS da nova playlist contra a anterior: voltou → disorder;
     * saltou → conta lacunas.
     * Original: f.b(LinkedHashSet)
     */
    private fun checkSeqOrder(list: LinkedHashSet<String>) {
        val last = parseTsSeq(list.last()) ?: return
        val s = playerMonitorStat ?: return
        if (s.lastTsSeq > last) {
            s.disorderCnt = s.disorderCnt + 1
            s.disorderSeq = "${s.lastTsSeq}.ts"
        } else if (s.lastTsSeq >= 0 && s.lastTsSeq + 1 < last) {
            var expected = s.lastTsSeq + 1
            for (name in list) {
                val seq = parseTsSeq(name) ?: break
                if (seq > expected) { s.tsSeqGapCnt = s.tsSeqGapCnt + 1; expected = seq + 1 } else expected++
            }
        }
        s.lastTsSeq = last
    }

    /** Original: f.j(Collection) */
    private fun containsDisorderSeq(list: Collection<String>): Boolean =
        list.any { it.endsWith(playerMonitorStat!!.disorderSeq) }
}
