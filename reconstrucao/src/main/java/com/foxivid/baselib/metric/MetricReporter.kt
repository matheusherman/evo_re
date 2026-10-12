package com.foxivid.baselib.metric

import com.foxivid.baselib.bot.TelegramBot
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.device.DeviceInfoCollector
import com.foxivid.baselib.heartbeat.HeartbeatManager
import com.foxivid.baselib.host.ServerProviderUtils
import com.foxivid.baselib.media.ClickCounter
import com.foxivid.baselib.metric.model.BlockStabilityMetric
import com.foxivid.baselib.metric.model.PlayEndMetric
import com.foxivid.baselib.metric.model.StreamEndStabilityMetric
import com.foxivid.baselib.metric.model.ZappingTimeMetric
import com.foxivid.baselib.metric.monitor.AppUsageMonitor
import com.foxivid.baselib.metric.monitor.NetworkMonitor
import com.foxivid.baselib.metric.monitor.PlayerMonitor
import com.foxivid.baselib.metric.monitor.ZappingMonitor
import com.foxivid.baselib.metric.monitor.UpgradeMonitor
import com.foxivid.baselib.user.UserManager
import com.foxivid.baselib.util.AppAttrUtils
import com.foxivid.baselib.util.Clock
import com.foxivid.baselib.util.DateFormats
import com.foxivid.baselib.util.LoggerFactory

/**
 * Monta e envia os eventos de métrica (via [MetricAgent] obtido do provedor de servidores de métrica,
 * `host/b.i()`).
 *
 * Original: uf/c.java
 *
 * Eventos enviados (nome → método):
 * | evento | método |
 * |---|---|
 * | liveChannelEndStability | [reportPlayEnd] |
 * | liveHeartbeat | [reportLiveHeartbeat] / interno [sendLiveHeartbeat] |
 * | userClickCount | [reportClickCount] |
 * | liveChannelAbnormal | [reportAbnormal] |
 * | liveChannelZappingTime | [reportZappingTime] |
 * | liveUserStartup | [reportUserStartup] |
 * | liveStreamEndStability | [reportStreamEndStability] |
 * | streamingEvent | [reportStreamingEvent] |
 * | liveUpgrade | [reportUpgrade] |
 *
 * Todo evento leva os campos base: appStartupUid, did, sn, appId, appDistributionChannel, tenantId,
 * appVer, brandId, loginSession (cacheados na 1ª vez) + isMobile, uid, gateWay, Ip/Mask,
 * networkDesc e reportTime.
 * Se `is_report_client_detail_log` estiver ligado o map também é logado em info (→ RemoteLogger).
 */
object MetricReporter {
    private val logger = LoggerFactory.getLogger(MetricReporter::class.java)
    /** Original: uf.c.serverProvider = host/b.f20720a.i() */
    private val serverProvider = ServerProviderUtils.metricServerProvider()
    private var heartBeatBeginMap: MutableMap<String, Any?>? = null
    private var heartBeatMap: MutableMap<String, Any?>? = null
    private var streamMap: MutableMap<String, Int>? = null
    private var isStartupReported = false
    private var isClickCountReportedBefore = false
    /** Original: uf.c.zappingTimeBotWhenGT (ms, default 8000) */
    private var zappingTimeBotWhenGT = 8000
    private val baseMap = HashMap<String, Any?>()
    private const val STREAM_LOCK = "stream"

    private fun agent(): MetricAgent? = serverProvider.get()

    private fun logMetric(name: String, map: Map<String, Any?>) {
        if (HeartbeatManager.isReportClientDetail) logger.info("metricReport: $name[{}]", map)
        else if (BaseLibConfig.isDebug) logger.debug("metricReport: $name[{}]", map)
    }

    /** Original: uf.c.d() */
    private fun baseFields(): HashMap<String, Any?> {
        if (baseMap.isEmpty()) {
            baseMap["appStartupUid"] = AppAttrUtils.startupUid()
            baseMap["did"] = AppAttrUtils.did()
            baseMap["sn"] = AppAttrUtils.serialNumber()
            baseMap["appId"] = AppAttrUtils.appId()
            baseMap["appDistributionChannel"] = AppAttrUtils.distributionChannel()
            baseMap["tenantId"] = AppAttrUtils.tenantId()
            baseMap["appVer"] = AppAttrUtils.appVersion()
            baseMap["brandId"] = AppAttrUtils.brandId()
            baseMap["loginSession"] = UserManager.loginSession()
        }
        return baseMap
    }

    /** Original: uf.c.c() */
    private fun commonFields(): MutableMap<String, Any?> {
        val map = HashMap<String, Any?>(baseFields())
        map["isMobile"] = DeviceInfoCollector.isMobileLike()
        map["uid"] = AppAttrUtils.startupUid()
        DeviceInfoCollector.gateways().takeIf { it.isNotEmpty() }?.let { map["gateWay"] = it }
        DeviceInfoCollector.ipMasks().takeIf { it.isNotEmpty() }?.let { map["Ip/Mask"] = it }
        map["networkDesc"] = NetworkMonitor.describe()
        map["reportTime"] = Clock.now()
        return map
    }

    /** Original: uf.c.l(vf.a) */
    fun reportPlayEnd(m: PlayEndMetric) {
        val map = commonFields()
        map["channel"] = m.channel
        map["streamId"] = m.streamId
        map["route"] = m.route
        map["session"] = m.session
        map["eventTime"] = m.session
        map["reportTime"] = Clock.elapsed()
        map["playType"] = m.playType
        map["mediaPlayMode"] = m.mediaPlayMode
        map["isEcoMode"] = m.isEcoMode
        map["playSq"] = m.playSq
        map["playMs"] = m.playMs
        map["bufferingCnt"] = m.bufferingCnt
        map["bufferingMs"] = m.bufferingMs
        map["minBufferingMs"] = if (m.minBufferingMs == Long.MAX_VALUE) 0L else m.minBufferingMs
        map["maxBufferingMs"] = if (m.maxBufferingMs != Long.MIN_VALUE) m.maxBufferingMs else 0L
        map["nullBlockCnt"] = m.nullBlockCnt
        map["skipBlockCnt"] = m.skipBlockCnt
        map["requestPlaylistCnt"] = m.requestPlaylistCnt
        map["playlistBlockCnt"] = m.playlistBlockCnt
        map["requestBlockCnt"] = m.requestBlockCnt
        map["requestIndexDistribution"] = m.requestIndexDistribution
        map["bufferingDistribution"] = m.bufferingDistribution
        map["noSignalCnt"] = m.noSignalCnt
        map["restartPlayerCnt"] = m.restartPlayerCnt
        map["restartPlayerDisorderTSSeqCnt"] = m.restartPlayerDisorderTSSeqCnt
        map["restartPlayerBufferingTooLongCnt"] = m.restartPlayerBufferingTooLongCnt
        map["restartPlayerNoListRequestTooLongCnt"] = m.restartPlayerNoListRequestTooLongCnt
        map["restartPlayerNoListResponseTooLongCnt"] = m.restartPlayerNoListResponseTooLongCnt
        map["restartPlayerNoListUpdateTooLongCnt"] = m.restartPlayerNoListUpdateTooLongCnt
        map["restartPlayerNoBlockResponseTooLongCnt"] = m.restartPlayerNoBlockResponseTooLongCnt
        map["restartPlayerNoBlockRequestTooLongCnt"] = m.restartPlayerNoBlockRequestTooLongCnt
        map["restartPlayerNoBlockUpdateTooLongCnt"] = m.restartPlayerNoBlockUpdateTooLongCnt
        map["videoHeight"] = m.videoHeight
        map["videoWidth"] = m.videoWidth
        map["resolutionType"] = m.resolutionType
        map["videoCodec"] = m.videoCodec
        map["audioCodec"] = m.audioCodec
        map["bps"] = m.bps; map["minBps"] = m.minBps; map["maxBps"] = m.maxBps; map["avgBps"] = m.avgBps
        map["rtt"] = m.rtt; map["minRtt"] = m.minRtt; map["maxRtt"] = m.maxRtt; map["avgRtt"] = m.avgRtt
        for ((k, v) in m.streamEvent) map[k] = v.get()
        logMetric("liveChannelEndStability", map)
        AppUsageMonitor.logPlayEnd(m)
        agent()?.report("liveChannelEndStability", map)
    }

    /** Original: uf.c.b(Map, vf.f) */
    private fun putZapping(map: MutableMap<String, Any?>, m: ZappingTimeMetric?) {
        if (m == null) return
        map["zappingTimeMs"] = m.zappingTimeMs
        map["stopPlayerMs"] = m.stopPlayerMs
        map["stopEnginePlayMs"] = m.stopEnginePlayMs
        map["startEnginePlayMs"] = m.startEnginePlayMs
        map["injectUrlMs"] = m.injectUrlMs
        map["firstPlaylistRequestMs"] = m.firstPlaylistRequestMs
        map["firstPlaylistResponseMs"] = m.firstPlaylistResponseMs
        map["firstBlockRequestMs"] = m.firstBlockRequestMs
        map["firstBlockResponseMs"] = m.firstBlockResponseMs
        map["firstBlockIndexInPlaylist"] = m.firstBlockIndexInPlaylist
        map["lastBlockResponseMs"] = m.lastBlockResponseMs
        map["blockCnt"] = m.blockCnt
        map["renderMs"] = m.renderMs
        map.putAll(m.streamMap)
        for ((k, v) in m.streamEvent) map[k] = v.get()
    }

    /** Original: uf.c.e(Map) */
    private fun networkDesc(map: Map<String, Any?>): String = map["networkDesc"]?.toString() ?: ""

    /**
     * Fecha o agregado de stream (média de tempo, kbps, taxa de reenvio/perda) e envia "liveHeartbeat".
     * Original: uf.c.t(Map)
     */
    private fun sendLiveHeartbeat(map0: MutableMap<String, Any?>?) {
        val map = map0 ?: commonFields()
        val sm = streamMap
        if (sm != null) {
            synchronized(STREAM_LOCK) {
                streamMap = null
                val resend = sm["totalResendPktCnt"] ?: 0
                if (resend > 0) {
                    val blocks = sm["blockCnt"] ?: 0
                    val timeMs = sm["totalTimeMs"] ?: 0
                    val size = sm["totalSize"] ?: 0
                    if (blocks > 0) sm["avgTimeMs"] = timeMs / blocks
                    if (timeMs > 0) sm["avgKbps"] = (size shl 3) / timeMs
                    val pkts = sm["totalPktCnt"] ?: 0
                    if (pkts > 0) {
                        sm["avgResendRate"] = resend * 100 / pkts
                        sm["avgAvgLossRate"] = (sm["totalLossPktCnt"] ?: 0) * 100 / pkts
                    }
                    map.putAll(sm)
                }
            }
        }
        logMetric("liveHeartbeat", map)
        agent()?.report("liveHeartbeat", map)
    }

    /** Original: uf.c.u(...) — acumula estatísticas de um bloco; devolve kbps do bloco. */
    private fun accumulate(map: MutableMap<String, Int>, blockSize: Int, timeMs: Long, resendCount: Int, resendRate: Int,
                           avgLossRate: Int, rtt: Int, minRtt: Int, maxRtt: Int, avgRtt: Int): Int {
        add(map, "blockCnt", 1)
        add(map, "totalSize", blockSize)
        min(map, "minBlockSize", blockSize)
        max(map, "maxBlockSize", blockSize)
        val t = timeMs.toInt()
        add(map, "totalTimeMs", t)
        min(map, "minTimeMs", t)
        max(map, "maxTimeMs", t)
        var kbps = 0
        if (t > 0) {
            kbps = (blockSize shl 3) / t
            min(map, "minKbps", kbps)
            max(map, "maxKbps", kbps)
        }
        if (resendCount > 0 && resendRate > 0) {
            add(map, "totalResendPktCnt", resendCount)
            val total = resendCount * 100 / resendRate
            add(map, "totalPktCnt", total)
            min(map, "minResendRate", resendRate)
            max(map, "maxResendRate", resendRate)
            add(map, "totalLossPktCnt", total * avgLossRate / 100)
            min(map, "minAvgLossRate", avgLossRate)
            max(map, "maxAvgLossRate", avgLossRate)
        }
        map["rtt"] = rtt
        map["minRTT"] = minRtt
        map["maxRTT"] = maxRtt
        map["avgRtt"] = avgRtt
        return kbps
    }

    /** Original: uf.c.f() — chamado pelo heartbeat a cada METRIC_HEART_BEAT_INTERVAL. */
    fun reportLiveHeartbeat() {
        val map = heartBeatMap ?: return
        sendLiveHeartbeat(map)
        heartBeatMap = null
    }

    /** Original: uf.c.g() */
    fun isStartupReported() = isStartupReported

    /** Original: uf.c.j(String) — contadores de clique (media/d.p()); a 1ª vez envia mesmo vazio. */
    fun reportClickCount(from: String) {
        val counts = ClickCounter.snapshot()
        if (isClickCountReportedBefore && counts.isEmpty()) return
        if (!isClickCountReportedBefore) isClickCountReportedBefore = true
        val map = commonFields()
        map["report_from"] = from
        map.putAll(counts)
        logger.info("metricReport: userClickCount[{}]", map)
        agent()?.report("userClickCount", map)
    }

    /** Original: uf.c.k(vf.f, int, int, String) */
    fun reportAbnormal(m: ZappingTimeMetric, errorType: Int, errorCode: Int, error: String) {
        val map = commonFields()
        val now = Clock.elapsed()
        map["channel"] = m.channel
        map["streamId"] = m.streamId
        map["route"] = m.route
        map["playSession"] = m.session
        map["eventTime"] = m.session
        map["reportTime"] = now
        map["playSq"] = m.seq
        map["playType"] = m.playType
        map["mediaPlayMode"] = m.mediaPlayMode
        map["errorType"] = errorType
        map["errorCode"] = errorCode
        map["errorMsg"] = error
        map["durationMs"] = now - m.session
        putZapping(map, m)
        logMetric("liveChannelAbnormal", map)
        AppUsageMonitor.logAbnormal(map)
        agent()?.report("liveChannelAbnormal", map)
    }

    /**
     * Zapping time; se > `zappingTimeBotWhenGT`, monta mensagem `[zapping time]` para o bot (warn).
     * Original: uf.c.m(vf.f)
     */
    fun reportZappingTime(m: ZappingTimeMetric) {
        val map = commonFields()
        map["channel"] = m.channel
        map["streamId"] = m.streamId
        map["route"] = m.route
        map["playSession"] = m.session
        map["eventTime"] = m.session
        map["reportTime"] = Clock.elapsed()
        map["playSq"] = m.seq
        map["playType"] = m.playType
        map["mediaPlayMode"] = m.mediaPlayMode
        putZapping(map, m)
        val stat = PlayerMonitor.currentMonitorStat()
        if (m.zappingTimeMs > zappingTimeBotWhenGT) {
            val sb = StringBuilder()
            sb.append("[zapping time]\n")
            sb.append("[").append(m.playType).append("]")
            sb.append("[").append(m.channel).append("(").append(m.streamId).append(")] ")
            sb.append(DateFormats.durationText(m.zappingTimeMs)).append("\n")
            sb.append("start from: blk ").append(m.firstBlockIndexInPlaylist)
            if (m.isFirstTSFromLocalCache) sb.append("(hit)")
            sb.append(", blk cnt: ").append(m.blockCnt)
            if (stat != null) {
                sb.append("\nloss rate: ").append(stat.lossRate)
                sb.append(", resend rate: ").append(stat.resendRate)
                sb.append(", resend cnt: ").append(stat.resendCnt)
                sb.append(", rtt: ").append(stat.rtt)
            }
            sb.append("\n")
            sb.append("1st idx: rq ").append(m.firstPlaylistRequestMs).append(" ms, rp ").append(m.firstPlaylistResponseMs).append(" ms\n")
            sb.append("1st blk: rq ").append(m.firstBlockRequestMs).append(" ms, rp ").append(m.firstBlockResponseMs).append(" ms")
            TelegramBot.sendSysWarn(sb.toString())
        }
        logger.info("stream[${m.streamId}] zappingTime[${m.zappingTimeMs}] network[${networkDesc(map)}]")
        logMetric("liveChannelZappingTime", map)
        AppUsageMonitor.onZappingTime(m)
        agent()?.report("liveChannelZappingTime", map)
    }

    /**
     * Callback de estatística de bloco vindo do TS proxy (via StreamingMonitor). Acumula no
     * `streamMap` global e no `streamMap` do zapping atual.
     * Original: uf.c.n(...)
     */
    fun onBlockStats(blockSize: Int, resendCount: Int, resendRate: Int, timeMs: Long, avgLossRate: Int,
                     rtt: Int, minRtt: Int, maxRtt: Int, avgRtt: Int): Int {
        val kbps: Int
        synchronized(STREAM_LOCK) {
            val map = streamMap ?: HashMap()
            kbps = accumulate(map, blockSize, timeMs, resendCount, resendRate, avgLossRate, rtt, minRtt, maxRtt, avgRtt)
            streamMap = map
        }
        ZappingMonitor.currentZappingStat()?.streamMap?.let {
            accumulate(it, blockSize, timeMs, resendCount, resendRate, avgLossRate, rtt, minRtt, maxRtt, avgRtt)
        }
        return kbps
    }

    /**
     * Acumula deltas (buffering, noSignal, skip, null) por sessão de reprodução para o próximo
     * "liveHeartbeat"; ao trocar de stream/sessão envia o agregado anterior.
     *
     * Original: uf.c.o(vf.a, vf.b)
     *
     * Nota de fidelidade: quando `heartBeatBeginMap == null` o original monta um map local e retorna
     * **sem** atribuí-lo a `heartBeatBeginMap` — então essa função nunca passa do primeiro ramo e
     * `heartBeatMap` nunca é preenchido por aqui (o "liveHeartbeat" fica efetivamente inativo).
     */
    @Synchronized
    fun onBlockPlayed(play: PlayEndMetric?, block: BlockStabilityMetric) {
        if (play == null) return
        val begin = heartBeatBeginMap
        if (begin == null) {
            val m = commonFields()
            m["streamId"] = play.streamId; m["route"] = play.route; m["playSession"] = play.session
            m["playSeq"] = play.playSq; m["mediaPlayMode"] = play.mediaPlayMode; m["playType"] = play.playType
            m["bufferingCnt"] = play.bufferingCnt; m["noSignalCnt"] = play.noSignalCnt
            m["skipBlockCnt"] = play.skipBlockCnt; m["nullBlockCnt"] = play.nullBlockCnt
            return // (sic)
        }
        var hb = heartBeatMap
        if (begin["streamId"] == play.streamId && begin["route"] == play.route && begin["playSession"] == play.session) {
            if (hb == null) {
                hb = commonFields()
                hb["streamId"] = play.streamId; hb["route"] = play.route; hb["playSession"] = play.session
                hb["playSeq"] = play.playSq; hb["mediaPlayMode"] = play.mediaPlayMode; hb["playType"] = play.playType
            }
            hb["bufferingCnt"] = (play.bufferingCnt - (begin["bufferingCnt"] as Int)).coerceAtLeast(0)
            hb["noSignalCnt"] = (play.noSignalCnt - (begin["noSignalCnt"] as Int)).coerceAtLeast(0)
            hb["skipBlockCnt"] = (play.skipBlockCnt - (begin["skipBlockCnt"] as Int)).coerceAtLeast(0)
            hb["nullBlockCnt"] = (play.nullBlockCnt - (begin["nullBlockCnt"] as Int)).coerceAtLeast(0)
            val buf = block.bufferingMs
            hb["maxBufferDuration"] = maxOf(hb["maxBufferDuration"] as Long? ?: buf, buf)
            hb["minBufferDuration"] = minOf(hb["minBufferDuration"] as Long? ?: buf, buf)
            hb["totalBufferDuration"] = (hb["totalBufferDuration"] as Long? ?: 0L) + buf
            heartBeatBeginMap = begin
            heartBeatMap = hb
            return
        }
        if (hb != null) sendLiveHeartbeat(hb)
        begin["streamId"] = play.streamId; begin["route"] = play.route; begin["playSession"] = play.session
        begin["playSeq"] = play.playSq; begin["mediaPlayMode"] = play.mediaPlayMode; begin["playType"] = play.playType
        begin["bufferingCnt"] = play.bufferingCnt; begin["noSignalCnt"] = play.noSignalCnt
        begin["skipBlockCnt"] = play.skipBlockCnt; begin["nullBlockCnt"] = play.nullBlockCnt
        heartBeatMap = null
    }

    /** Original: uf.c.p() */
    fun reportUserStartup() {
        val s = ZappingMonitor.startupMetric() ?: return
        val map = commonFields()
        map["eventTime"] = s.eventTime
        map["reportTime"] = Clock.elapsed()
        map["loginMs"] = s.loginMs
        map["loadChannelMs"] = s.loadChannelMs
        map["startupEngineMs"] = s.startupEngineMs
        map["loginFailure"] = s.loginFailure
        map["loadChannelFailure"] = s.loadChannelFailure
        map["engineStartupFailure"] = s.engineStartupFailure
        map.putAll(DeviceInfoCollector.deviceInfo())
        logMetric("liveUserStartup", map)
        AppUsageMonitor.setSystemInfo(DeviceInfoCollector.systemInfo(), UserManager.loginSession())
        agent()?.report("liveUserStartup", map)
        if (!isStartupReported) isStartupReported = true
    }

    /** Original: uf.c.q(vf.d) */
    fun reportStreamEndStability(m: StreamEndStabilityMetric) {
        val map = commonFields()
        map["streamId"] = m.streamId; map["route"] = m.route; map["playType"] = m.playType
        map["mediaPlayMode"] = m.mediaPlayMode; map["playSession"] = m.session; map["eventTime"] = m.session
        map["reportTime"] = Clock.elapsed()
        map["blockCnt"] = m.blockCnt
        map["maxBlockSize"] = m.maxBlockSize; map["avgBlockSize"] = m.avgBlockSize.toInt(); map["minBlockSize"] = m.minBlockSize
        map["maxTime"] = m.maxTime; map["avgTime"] = m.avgTime.toInt(); map["minTime"] = m.minTime
        map["maxResendCnt"] = m.maxResendCnt; map["avgResendCnt"] = m.avgResendCnt.toInt(); map["minResendCnt"] = m.minResendCnt
        map["maxResendRate"] = m.maxResendRate; map["avgResendRate"] = m.avgResendRate.toInt(); map["minResendRate"] = m.minResendRate
        map["maxAvgLossRate"] = m.maxAvgLossRate; map["avgAvgLossRate"] = m.avgAvgLossRate.toInt(); map["minAvgLossRate"] = m.minAvgLossRate
        map["resendCntDistribution"] = m.resendCntDistributionMap
        map["resendRateDistribution"] = m.resendRateDistributionMap
        map["avgLossRateDistribution"] = m.avgLossRateDistributionMap
        map["timeDistribution"] = m.timeDistribution
        map["blockSizeDistribution"] = m.sizeDistributionMap
        logMetric("liveStreamEndStability", map)
        agent()?.report("liveStreamEndStability", map)
    }

    /** Original: uf.c.r(long, String, int) — evento de streaming de VOD. */
    fun reportStreamingEvent(playSession: Long, videoName: String, eventCode: Int) {
        val map = commonFields()
        map["videoName"] = videoName
        map["playSession"] = playSession
        map["reportTime"] = Clock.elapsed()
        map["eventCode"] = eventCode
        logMetric("streamingEventMetric", map)
        agent()?.report("streamingEvent", map)
    }

    /** Original: uf.c.s() */
    fun reportUpgrade() {
        val u = UpgradeMonitor.upgradeMetric() ?: return
        val map = commonFields()
        map["eventTime"] = u.eventTime
        map["reportTime"] = Clock.elapsed()
        map["infoCompleteOverhead"] = u.infoCompleteOverhead
        map["infoFailureMsg"] = u.infoFailureMsg
        map["apkDownloadOverhead"] = u.apkDownloadOverhead
        map["apkDownloadFailureMsg"] = u.apkDownloadFailureMsg
        map["apkInstallStartTime"] = u.apkInstallStartTime
        map["apkInstallFailureMsg"] = u.apkInstallFailureMsg
        logMetric("liveUpgrade", map)
        AppUsageMonitor.logUpgrade(u)
        agent()?.report("liveUpgrade", map)
    }

    /** Original: uf.c.v(int) */
    fun setZappingTimeBotWhenGT(seconds: Int) { zappingTimeBotWhenGT = seconds * 1000 }

    /** Original: uf.c.a */
    private fun add(m: MutableMap<String, Int>, k: String, v: Int) { m[k] = (m[k] ?: 0) + v }
    /** Original: uf.c.h */
    private fun max(m: MutableMap<String, Int>, k: String, v: Int) { val c = m[k]; if (c == null || c < v) m[k] = v }
    /** Original: uf.c.i */
    private fun min(m: MutableMap<String, Int>, k: String, v: Int) { val c = m[k]; if (c == null || c > v) m[k] = v }
}
