package com.foxivid.baselib.metric.monitor

import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.media.TrialRepository
import com.foxivid.baselib.metric.MetricReporter
import com.foxivid.baselib.metric.model.PlayType
import com.foxivid.baselib.metric.model.PlayerZappingStat
import com.foxivid.baselib.metric.model.StartupMetric
import com.foxivid.baselib.metric.model.StartupStat
import com.foxivid.baselib.metric.model.ZappingTimeMetric
import com.foxivid.baselib.user.UserManager
import com.foxivid.baselib.util.Clock
import com.foxivid.baselib.util.LoggerFactory
import tv.danmaku.ijk.media.player.IMediaPlayer
import java.util.Locale

/**
 * Monitor de startup do app e de zapping (troca de canal até o 1º frame).
 *
 * Original: x1/f1/lb/metric/monitor/h.java
 */
object ZappingMonitor {
    private val logger = LoggerFactory.getLogger(ZappingMonitor::class.java)
    /** Original: h.PLAY_EVENT_SEQ */ private var playEventSeq = 0
    /** Original: h.RETRY — zerado quando um zapping conclui */ private var retry = 0
    private var startupStat: StartupStat? = null
    private var playerZappingStat: PlayerZappingStat? = null

    /**
     * Calcula as durações de cada etapa (fim − início; se o início for 0 usa o fim da etapa anterior
     * mais próxima). zappingTime = max(etapas).
     *
     * Etapas (fim, início): 0 zapping (playerPrepared, start); 1 (start, 0); 2 stopEngine
     * (stopEnginePlay, start); 3 startEngine (playUrlReadyFromEngine, stopEnginePlay); 4 stopPlayer
     * (stopPlayer, start); 5 injectUrl (playUrlInjectIntoPlayer, max(stopPlayer, playUrlReady));
     * 6 1º req. playlist; 7 1ª resp. playlist; 8 1º req. TS; 9 1ª resp. TS;
     * 10 (lastTSRequestFromPlayer, lastTSResponseToPlayer) (sic); 11 render desde 1º TS;
     * 12 render desde último TS.
     *
     * Original: h.f(tf.d)
     */
    private fun toMetric(z: PlayerZappingStat): ZappingTimeMetric {
        val pairs = arrayOf(
            z.playerPrepared to z.start, z.start to 0L, z.stopEnginePlay to z.start,
            z.playUrlReadyFromEngine to z.stopEnginePlay, z.stopPlayer to z.start,
            z.playUrlInjectIntoPlayer to maxOf(z.stopPlayer, z.playUrlReadyFromEngine),
            z.firstM3u8RequestFromPlayer to z.playUrlInjectIntoPlayer,
            z.firstM3U8ResponseToPlayer to z.firstM3u8RequestFromPlayer,
            z.firstTSRequestFromPlayer to z.firstM3U8ResponseToPlayer,
            z.firstTSResponseToPlayer to z.firstTSRequestFromPlayer,
            z.lastTSRequestFromPlayer to z.lastTSResponseToPlayer,
            z.playerPrepared to z.firstTSResponseToPlayer,
            z.playerPrepared to z.lastTSResponseToPlayer,
        )
        val d = LongArray(13)
        for (i in 0 until 13) {
            val (end, begin) = pairs[i]
            if (end > 0 && begin > 0) d[i] = end - begin
            else if (end > 0) {
                for (j in i - 1 downTo 0) if (pairs[j].second > 0) { d[i] = end - pairs[j].second; break }
            }
        }
        var max = d[0]
        for (i in 1 until 13) { if (d[i] < 0) d[i] = 0; if (max < d[i]) max = d[i] }
        if (max > d[0]) d[0] = max
        return ZappingTimeMetric(
            z.loginSession, z.channel, z.route, z.streamId, z.playType.name, z.seq, z.session, z.mediaPlayMode, z.retryCnt,
            d[0], d[2], d[3], d[4], d[5], d[6], d[7], d[8], d[9],
            z.firstTSBytes, z.firstTSDuration, z.isFirstTSFromLocalCache, z.firstTSIndex,
            d[10], z.requestTSCntDuringPreparing, d[11], d[12], z.streamMap, z.monitorStat?.streamEvent ?: emptyMap(),
        )
    }

    /**
     * Texto multi-linha de diagnóstico do zapping (mostrado no OSD de debug).
     *
     * Original: h.h(tf.d). Nota: no jadx o laço incrementa o índice duas vezes nas linhas ≥1
     * (pularia linhas alternadas); tratado aqui como artefato de duplicação de bloco do decompilador
     * e reconstruído como laço simples.
     */
    fun buildZappingText(z: PlayerZappingStat): String {
        val m = toMetric(z)
        val rows = listOf(
            Triple(z.playerPrepared, m.zappingTimeMs, "zapping time"),
            Triple(z.start, 0L, "start"),
            Triple(z.stopEnginePlay, m.stopEnginePlayMs, "engine stop play time"),
            Triple(z.playUrlReadyFromEngine, m.startEnginePlayMs, "engine start play time"),
            Triple(z.stopPlayer, m.stopPlayerMs, "stop player time"),
            Triple(z.playUrlInjectIntoPlayer, m.injectUrlMs, "player url injection time"),
            Triple(z.firstM3u8RequestFromPlayer, m.firstPlaylistRequestMs, "first index request time, request cnt [ ${z.firstM3U8RequestCnt} ]"),
            Triple(z.firstM3U8ResponseToPlayer, m.firstPlaylistResponseMs, "first index response time"),
            Triple(z.firstTSRequestFromPlayer, m.firstBlockRequestMs, "first ts request time, request cnt [ ${z.firstTSRequestCnt} ], request at index [ ${z.firstTSIndex} ]"),
            Triple(z.firstTSResponseToPlayer, m.firstBlockResponseMs, "first ts response time"),
            Triple(z.lastTSRequestFromPlayer, m.lastBlockResponseMs, "last ts response time, request ts qty [ ${z.requestTSCntDuringPreparing} ]  during player preparation"),
            Triple(z.playerPrepared, m.renderMs, "render time since 1 TS ready"),
            Triple(z.playerPrepared, m.renderAfterAllMs, "render time since ${z.requestTSCntDuringPreparing} TS ready"),
        )
        val sb = StringBuilder("session[ ").append(z.sessionFromPlayerRequest)
        if (m.seq > 0) sb.append(" ] play_seq[ ").append(m.seq)
        if (m.retry > 0) sb.append(" ] retry[ ").append(m.retry)
        if (!z.error.isNullOrEmpty()) sb.append(" ] err[ ").append(z.error)
        sb.append(" ]\n")
        sb.append("--------------------------------------------------------------------------------------------------------------------\n")
        rows.forEachIndexed { i, (at, ms, desc) ->
            if (i == 0) {
                val mode = when (z.mediaPlayMode) { 0 -> "normal"; 1 -> "adult"; 2 -> "normal, free"; 3 -> "adult, free"; else -> "unknown play mode" }
                val plan = if (UserManager.isTrial()) "trial(" + TrialRepository.watchedOf(z.streamId) + " / " + UserManager.trialLimit() + ")}" else "plan"
                sb.append(desc).append(" [ ").append(ms).append(" ms ]").append("[ ")
                if (BaseLibConfig.isDebug) sb.append(z.route).append(", ")
                sb.append(z.streamId).append(", ").append(z.playType.toString()).append(", ").append(mode)
                    .append(" ] [ ").append(plan).append(" ]\n")
            } else if (at != 0L) {
                sb.append("complete@[ ").append(at).append(" ] [ ").append(String.format(Locale.ENGLISH, "% 6d", ms))
                    .append(" ms ] --> ").append(desc).append("\n")
            }
        }
        return sb.toString()
    }

    /**
     * Início de um zapping. Se o zapping anterior não terminou (playerPrepared == 0), reporta-o como
     * "liveChannelAbnormal"; se terminou, fecha a métrica de fim de reprodução do PlayerMonitor.
     *
     * Original: h.a(v6.c, String, String, String, long, int)
     */
    fun startZapping(playType: PlayType, channelName: String, streamId: String, route: String, session: Long, mediaPlayMode: Int): PlayerZappingStat {
        val prev = playerZappingStat
        if (prev == null || prev.playerPrepared > 0) {
            PlayerMonitor.finishPlay()
        } else {
            val ms = prev.monitorStat
            if (ms != null && ms.isReported.compareAndSet(false, true)) {
                MetricReporter.reportAbnormal(toMetric(prev), prev.errorType, prev.errorCode, prev.error)
            }
        }
        val z = PlayerZappingStat().apply {
            this.playType = playType
            this.mediaPlayMode = mediaPlayMode
            loginSession = UserManager.loginSession()
            channel = channelName
            this.route = route
            this.streamId = streamId
            seq = playEventSeq++
            retryCnt = retry++
            this.session = session
        }
        playerZappingStat = z
        PlayerMonitor.startMonitor(z)
        PlayerMonitor.setZappingStat(z)
        return z
    }

    /** Original: h.b() */
    fun newStartupStat(): StartupStat = StartupStat().also { startupStat = it }

    /** Original: h.c() */
    fun currentZappingStat(): PlayerZappingStat? = playerZappingStat

    /** Original: h.d() */
    fun startupMetric(): StartupMetric? {
        val s = startupStat ?: return null
        return StartupMetric(s.startTime, s.loginEndTime - s.startTime, s.loginFailure,
            s.loadChannelEndTime - s.loginEndTime, s.loadChannelFailure, s.engineEndTime - s.engineStartTime, s.engineStartupFailure)
    }

    /** Original: h.e() */
    fun getStartupStat(): StartupStat? = startupStat

    /** 1º frame renderizado: fecha o zapping e reporta. Original: h.g(IMediaPlayer) */
    fun onPlayerPrepared(mediaPlayer: IMediaPlayer?) {
        val z = playerZappingStat ?: return
        z.playerPrepared = Clock.elapsed()
        z.player = mediaPlayer?.javaClass?.simpleName ?: ""
        PlayerMonitor.setZappingStat(z)
        MetricReporter.reportZappingTime(toMetric(z))
        retry = 0
        playerZappingStat = null
    }
}
