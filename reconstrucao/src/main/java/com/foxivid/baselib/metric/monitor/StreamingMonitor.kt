package com.foxivid.baselib.metric.monitor

import android.text.TextUtils
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.metric.MetricReporter
import com.foxivid.baselib.metric.model.PlayType
import com.foxivid.baselib.metric.model.PlayerZappingStat
import com.foxivid.baselib.streaming.BlockHandler
import com.foxivid.baselib.streaming.PlaylistHandler
import com.foxivid.baselib.streaming.TsProxyStatsListener
import com.foxivid.baselib.util.LoggerFactory
import java.util.Collections

/**
 * Ponte entre o TS proxy local (streaming/server) e os monitores: para cada sessão de reprodução
 * registra um handler de playlist e um de bloco, que carimbam os tempos no [PlayerZappingStat] e
 * alimentam o [PlayerMonitor]. Também recebe estatísticas de rede por bloco (bps, reenvio, perda, RTT).
 *
 * Original: x1/f1/lb/metric/monitor/g.java (implementa monitor/b, monitor/d e streaming/server/b$c)
 *
 * Interfaces do streaming (outro módulo): PlaylistHandler = streaming/server/o, BlockHandler =
 * streaming/server/n, TsProxyStatsListener = streaming/server/b$c.
 */
object StreamingMonitor : BlockTimingQuery, StreamNetStatsQuery, TsProxyStatsListener {
    private val logger = LoggerFactory.getLogger(StreamingMonitor::class.java)
    private val playListHandlers: MutableMap<Long, PlaylistHandler> = Collections.synchronizedMap(HashMap())
    private val blockHandlers: MutableMap<Long, BlockHandler> = Collections.synchronizedMap(HashMap())
    private var bps = 0
    private var resendCount = 0L
    private var resendRate = 0
    private var lossRate = 0
    private var avgBps = 0L
    private var rtt = 0
    private var minRtt = 0
    private var maxRtt = 0
    private var avgRtt = 0

    /** Zapping atual se for desta sessão. Original: g.w(long) */
    private fun zappingOf(session: Long): PlayerZappingStat? =
        ZappingMonitor.currentZappingStat()?.takeIf { it.session == session }

    /** Handler de playlist por sessão. Original: g$a */
    class PlaylistHandlerImpl(private val session: Long) : PlaylistHandler {
        private var firstM3u8RequestCnt = 0
        private var isFirstM3u8 = true
        private var lastRequestPlayer = 0
        private var lastResponseToPlayer = 0
        private var lastRequestTime: Long? = null
        private var lastResponseTime: Long? = null
        private var lastUpdateToPlayer = 0
        private var lastUpdateTime: Long? = null
        private var endBlock: String? = null
        private var list: List<String>? = null
        private var lastIndex = 0

        /** Resposta de playlist entregue ao player. Original: g$a.c */
        @Synchronized override fun onPlaylistResponse(player: Int, time: Long, millis: Long, bytes: Int, playlist: List<String>) {
            lastResponseToPlayer = player
            lastResponseTime = time
            val z = zappingOf(session)
            if (isFirstM3u8 && z != null) z.firstM3U8RequestCnt = firstM3u8RequestCnt
            if (playlist.isEmpty()) {
                PlayerMonitor.onPlaylist(playlist, millis)
                logger.warn("play list is empty [{}] [{}ms]", session, millis)
            } else {
                lastUpdateToPlayer = player
                lastUpdateTime = time
                isFirstM3u8 = false
                PlayerMonitor.onPlaylist(playlist, millis)
                if (z != null && z.firstM3U8ResponseToPlayer == 0L) z.firstM3U8ResponseToPlayer = time
                if (PlayerMonitor.currentMonitorStat()?.playType != PlayType.LIVE) {
                    endBlock = playlist.lastOrNull()
                    list = playlist
                }
            }
        }

        /** Original: g$a.e */
        @Synchronized override fun onPlaylistRequest(player: Int, time: Long) {
            lastRequestPlayer = player
            lastRequestTime = time
            val z = zappingOf(session)
            if (z != null && z.firstM3u8RequestFromPlayer == 0L) {
                z.firstM3u8RequestFromPlayer = time
                z.sessionFromPlayerRequest = session.toString()
            }
            if (isFirstM3u8) firstM3u8RequestCnt++
        }

        /** Posição do bloco na playlist (VOD) em milésimos. Original: g$a.b */
        override fun blockPosition(player: Int, blockName: String): Int {
            val l = list
            if (player != lastRequestPlayer || l == null) return 0
            var i = lastIndex
            while (i < l.size && !l[i].contains(blockName)) i++ // ac.g.a = StringUtils.contains
            if (i == l.size && l[i - 1] != blockName) {
                var j = 0
                while (j < lastIndex && !l[j].contains(blockName)) j++
                i = j
            }
            lastIndex = i
            return i * 1000 / l.size
        }

        override fun lastRequestTime(player: Int): Long? = if (player == lastRequestPlayer) lastRequestTime else null    // g$a.d
        override fun endBlock(player: Int): String? = if (player == lastRequestPlayer) endBlock else null                // g$a.f
        override fun lastUpdateTime(player: Int): Long? = if (player == lastUpdateToPlayer) lastUpdateTime else null     // g$a.h
        override fun lastResponseTime(player: Int): Long? = if (player == lastResponseToPlayer) lastResponseTime else null // g$a.j
    }

    /** Handler de blocos por sessão. Original: g$b */
    class BlockHandlerImpl(private val session: Long) : BlockHandler {
        private var lastRequestPlayer = 0
        private var lastRequestTime: Long? = null
        private var lastResponseToPlayer = 0
        private var lastResponseTime: Long? = null
        private var lastUpdateToPlayer = 0
        private var lastUpdateTime: Long? = null
        private var downloadThousand = 0
        private var isFirstBlock = true
        private var lastBlock = ""

        /** Original: g$b.a */
        @Synchronized override fun onBlockResponse(player: Int, time: Long, millis: Long, blockName: String, bytes: Int, duration: Double?, isFromCache: Boolean?) {
            lastResponseToPlayer = player
            lastResponseTime = time
            if (bytes > 0) {
                isFirstBlock = false
                lastUpdateToPlayer = player
                lastUpdateTime = time
            }
            if (TextUtils.isEmpty(blockName)) return
            if (lastBlock != blockName) downloadThousand = playListHandlers[session]?.blockPosition(player, blockName) ?: 0
            lastBlock = blockName
            val z = zappingOf(session)
            val b = PlayerMonitor.blockStat(blockName)
            b?.responseTime = time
            if (bytes > 0) {
                if (z != null) {
                    if (z.firstTSResponseToPlayer == 0L) {
                        z.firstTSResponseToPlayer = time
                        z.firstTSBytes = bytes
                        z.firstTSDuration = duration ?: 0.0
                        z.isFirstTSFromLocalCache = isFromCache ?: false
                    }
                    z.requestTSCntDuringPreparing = z.requestTSCntDuringPreparing + 1
                    z.lastTSResponseToPlayer = time
                }
                b?.isNull = false
            }
            if (b != null) b.responseCount = b.responseCount + 1
            if (PlayerMonitor.currentMonitorStat()?.playType != PlayType.LIVE) PlayerMonitor.onBlockRemoved(blockName)
            if (duration != null) logger.info("play block[{}] [{}/{}/{}] [{}ms]", blockName, bytes, duration, isFromCache, millis)
            else if (BaseLibConfig.isDebug) logger.debug("play block[{}] [{}] [{}ms]", blockName, bytes, millis)
        }

        /** Original: g$b.i */
        @Synchronized override fun onBlockRequest(player: Int, time: Long, blockName: String) {
            lastRequestPlayer = player
            lastRequestTime = time
            val b = PlayerMonitor.onBlockRequested(blockName)
            val z = zappingOf(session) ?: return
            if (isFirstBlock) {
                z.firstTSRequestCnt = z.firstTSRequestCnt + 1
                if (z.firstTSRequestFromPlayer == 0L) {
                    z.firstTSRequestFromPlayer = time
                    z.firstTSIndex = b.lastRequestPos
                }
            }
            b.playType = z.playType.name
            b.mediaPlayMode = z.mediaPlayMode
            z.lastTSRequestFromPlayer = time
        }

        override fun lastRequestTime(player: Int): Long? = if (player == lastRequestPlayer) lastRequestTime else null   // g$b.d
        /** Bloco atual é o último da playlist (VOD). Original: g$b.g */
        override fun isLastBlock(player: Int): Boolean {
            val end = playListHandlers[session]?.endBlock(player)
            return player == lastUpdateToPlayer && end != null && end.contains(lastBlock) && lastBlock.isNotEmpty()
        }
        override fun lastUpdateTime(player: Int): Long? = if (player == lastUpdateToPlayer) lastUpdateTime else null    // g$b.h
        override fun lastResponseTime(player: Int): Long? = if (player == lastResponseToPlayer) lastResponseTime else null // g$b.j
        override fun downloadThousand(player: Int): Int = if (player == lastUpdateToPlayer) downloadThousand else 0      // g$b.k
    }

    override fun lastBlockUpdateTime(session: Long, player: Int) = blockHandlers[session]?.lastUpdateTime(player)          // g.a
    override fun lastPlaylistRequestTime(session: Long, player: Int) = playListHandlers[session]?.lastRequestTime(player)  // g.b
    override fun minRtt() = minRtt                                                                                         // g.c
    override fun avgRtt() = avgRtt                                                                                         // g.d
    override fun lastPlaylistUpdateTime(session: Long, player: Int) = playListHandlers[session]?.lastUpdateTime(player)    // g.e
    override fun lastBlockResponseTime(session: Long, player: Int) = blockHandlers[session]?.lastResponseTime(player)      // g.f
    override fun maxRtt() = maxRtt                                                                                         // g.g
    override fun rtt() = rtt                                                                                               // g.h
    override fun isLastBlock(session: Long, player: Int) = blockHandlers[session]?.isLastBlock(player) ?: false           // g.i
    override fun downloadThousand(session: Long, player: Int) = blockHandlers[session]?.downloadThousand(player) ?: 0     // g.j
    override fun avgBps() = avgBps                                                                                         // g.k
    override fun bps() = bps                                                                                               // g.l
    override fun resendCount() = resendCount.toInt()                                                                       // g.m
    override fun resendRate() = resendRate                                                                                 // g.o
    override fun lossRate() = lossRate                                                                                     // g.p
    override fun lastBlockRequestTime(session: Long, player: Int) = blockHandlers[session]?.lastRequestTime(player)        // g.q
    override fun lastPlaylistResponseTime(session: Long, player: Int) = playListHandlers[session]?.lastResponseTime(player) // g.r

    /** Estatística de um bloco vinda do proxy. bps = kbps×1000. Original: g.n(...) */
    override fun onBlockNetStats(blockSize: Long, resendCount: Long, resendRate: Int, timeMs: Long, avgLossRate: Int,
                                 avgBps: Long, rtt: Int, minRtt: Int, maxRtt: Int, avgRtt: Int) {
        bps = MetricReporter.onBlockStats(blockSize.toInt(), resendCount.toInt(), resendRate, timeMs, avgLossRate, rtt, minRtt, maxRtt, avgRtt) * 1000
        this.resendCount = resendCount
        lossRate = avgLossRate
        this.resendRate = resendRate
        this.avgBps = avgBps
        this.rtt = rtt; this.minRtt = minRtt; this.maxRtt = maxRtt; this.avgRtt = avgRtt
    }

    /** Original: g.v */ fun blockHandler(session: Long): BlockHandler? = blockHandlers[session]
    /** Original: g.x */ fun playlistHandler(session: Long): PlaylistHandler? = playListHandlers[session]

    /** Original: g.y(long) */
    fun registerSession(session: Long) {
        playListHandlers[session] = PlaylistHandlerImpl(session)
        blockHandlers[session] = BlockHandlerImpl(session)
    }

    /** Original: g.z(long) */
    fun unregisterSession(session: Long) {
        playListHandlers.remove(session)
        blockHandlers.remove(session)
    }
}
