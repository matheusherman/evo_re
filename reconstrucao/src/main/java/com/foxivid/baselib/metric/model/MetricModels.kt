package com.foxivid.baselib.metric.model

import com.foxivid.baselib.util.Clock
import com.google.gson.annotations.SerializedName
import java.util.concurrent.ConcurrentSkipListMap
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger

/*
 * Modelos de estatística/métrica. No APK são POJOs Java R8-ofuscados (tf/*, vf/*, p6/c).
 * Os nomes de propriedade abaixo foram deduzidos das chaves usadas em uf/c (MetricReporter) e dos
 * pares getter/setter; a letra original do getter vem no comentário. Campos cujo uso não aparece
 * no módulo ficaram como `unknownX` (TODO).
 */

/**
 * Evento enviado no batch de métricas. Gson serializa `{"name":..., "values":{...}}`
 * (os campos `a`/`b` ficam nulos e são omitidos).
 *
 * Original: p6/c.java
 */
class MetricEvent {
    var a: String? = null
    var b: Map<String, Any>? = null
    var name: String? = null
    var values: Map<String, Any?>? = null
}

/** Tipo de reprodução. Original: v6/c.java (só LIVE é referenciado neste módulo) */
enum class PlayType { LIVE, CATCHUP, VOD /* TODO: demais valores de v6.c não verificados */ }

/**
 * Info do aparelho persistida em prefs "app_usage_system_info". Os nomes JSON são as letras
 * R8 (a..o) porque o Gson usa o nome do campo no dex.
 *
 * Original: tf/SystemInfo.java (data class Kotlin)
 */
data class SystemInfo(
    @SerializedName("a") val did: String?,
    @SerializedName("b") val cpuSN: String?,
    @SerializedName("c") val etherMac: String?,
    @SerializedName("d") val wifiMac: String?,
    @SerializedName("e") val androidId: String?,
    @SerializedName("f") val manufacturer: String?,
    @SerializedName("g") val hardware: String?,
    @SerializedName("h") val display: String?,
    @SerializedName("i") val brand: String?,
    @SerializedName("j") val model: String?,
    @SerializedName("k") val supportedAbis: String?,
    @SerializedName("l") val buildUser: String?,
    @SerializedName("m") val buildHost: String?,
    @SerializedName("n") val fingerprint: String?,
    @SerializedName("o") val sdkInt: Int,
)

/** Original: tf/AccountInfo.java (data class Kotlin; JSON com letras a..l) */
data class AccountInfo(
    @SerializedName("a") val did: String?,
    @SerializedName("b") val androidId: String?,
    @SerializedName("c") val appChannel: String?,
    @SerializedName("d") val appType: String?,
    @SerializedName("e") val accountId: Long?,
    @SerializedName("f") val accountType: String?,
    @SerializedName("g") val username: String?,
    @SerializedName("h") val email: String?,
    @SerializedName("i") val phone: String?,
    @SerializedName("j") val code: String?,
    @SerializedName("k") val plan: String?,
    @SerializedName("l") val expireTS: Long?,
)

/**
 * Cronometragem do upgrade.
 * Original: tf/g.java — getters a()=f, b()=h, c()=a, d()=i, e()=j, f()=c, g()=e.
 */
class UpgradeStat {
    /** a (setter k) */ var eventTime = 0L
    /** b (setter n) */ var versionName: String? = null
    /** c (setter o) — no uso recebe uma *duração* (now - start) */ var infoCompleteTime = 0L
    /** d (setter q) */ var infoFailTime = 0L
    /** e (setter p) */ var infoFailureMsg = ""
    /** f (setter h) */ var apkDownloadCompleteTime = 0L
    /** g (setter j) */ var apkDownloadFailTime = 0L
    /** h (setter i) */ var apkDownloadFailureMsg = ""
    /** i (setter l) */ var apkInstallStartTime = 0L
    /** j (setter m) */ var apkInstallFailureMsg = ""
}

/** Original: vf/e.java — métrica "liveUpgrade". */
data class UpgradeMetric(
    val eventTime: Long, val infoCompleteOverhead: Long, val infoFailureMsg: String?,
    val apkDownloadOverhead: Long, val apkDownloadFailureMsg: String?,
    val apkInstallStartTime: Long, val apkInstallFailureMsg: String?,
)

/**
 * Cronometragem do startup.
 * Original: tf/e.java — getters k()=a, j()=e, f()=d, g()=f, e()=i, c()=j, a()=n, d()=m.
 */
class StartupStat {
    /** a */ var startTime = 0L
    /** e */ var loginEndTime = 0L
    /** d */ var loginFailure = ""
    /** f */ var loadChannelEndTime = 0L
    /** i */ var loadChannelFailure = ""
    /** j */ var engineStartTime = 0L
    /** n */ var engineEndTime = 0L
    /** m */ var engineStartupFailure = ""
    // TODO: campos b, c, g, h, k, l, o de tf.e não são usados neste módulo.
}

/** Original: vf/c.java — métrica "liveUserStartup". */
data class StartupMetric(
    val eventTime: Long, val loginMs: Long, val loginFailure: String?,
    val loadChannelMs: Long, val loadChannelFailure: String?,
    val startupEngineMs: Long, val engineStartupFailure: String?,
)

/**
 * Estatística de um bloco TS (segmento).
 * Original: tf/b.java — ctor(blockName, seq: Long?, index): desc = "%d" ou "%d-%d"(index, seq).
 */
class BlockStabilityStat(val blockName: String, seq: Long?, val index: Int) {
    /** d */ val desc: String = if (seq == null) String.format("%d", index) else String.format("%d-%d", index, seq)
    /** f */ val seq: Long = seq ?: index.toLong()
    /** a (setter p) */ var playType = ""
    /** b (setter n) */ var mediaPlayMode = 0
    /** g (setter s) */ var requestSeq = ""
    /** h — nunca escrito neste módulo */ var unknownH = ""
    /** i (getter a) */ val createTime: Long = Clock.elapsed()
    /** j (setter u) */ var firstRequestTime = 0L
    /** k (setter w) */ var responseTime = 0L
    /** l (setter t) */ var firstRequestPos = -1
    /** m (setter v) */ var lastRequestPos = -1
    /** n (setter r) */ var responseCount = 0
    /** o (setter o) — true até chegar resposta com bytes */ var isNull = true
    /** p (setter q) */ var bufferingMs = 0L
}

/** Original: vf/b.java (getters a()=bufferingMs, b()=requestSeq, c()=lastRequestPos, d()=isNull) */
data class BlockStabilityMetric(
    val desc: String, val requestSeq: String, val playType: String, val mediaPlayMode: Int,
    val isNull: Boolean, val lastRequestPos: Int, val responseCount: Int,
    val downloadMs: Long, val bufferingMs: Long, val unknownH: String,
)

/**
 * Agregado de fim de reprodução ("liveChannelEndStability"). Nomes = chaves do map em uf/c.l.
 * Original: vf/a.java
 */
class PlayEndMetric {
    var channel = ""; var route = ""; var streamId = ""; /** d (setter Z) */ var loginSession = 0L; var session = 0L; var playType = ""
    var mediaPlayMode = 0; var isEcoMode = 0; var playSq = 0; var playMs = 0L
    var bufferingCnt = 0; var bufferingMs = 0L
    var minBufferingMs = Long.MAX_VALUE; var maxBufferingMs = Long.MIN_VALUE
    var nullBlockCnt = 0; var skipBlockCnt = 0; var requestPlaylistCnt = 0; var playlistBlockCnt = 0; var requestBlockCnt = 0
    val requestIndexDistribution: MutableMap<Int, AtomicInteger> = HashMap()
    val bufferingDistribution: MutableMap<Long, AtomicInteger> = HashMap()
    var noSignalCnt = 0
    var restartPlayerCnt = 0; var restartPlayerDisorderTSSeqCnt = 0; var restartPlayerBufferingTooLongCnt = 0
    var restartPlayerNoListRequestTooLongCnt = 0; var restartPlayerNoListResponseTooLongCnt = 0
    var restartPlayerNoListUpdateTooLongCnt = 0; var restartPlayerNoBlockResponseTooLongCnt = 0
    var restartPlayerNoBlockRequestTooLongCnt = 0; var restartPlayerNoBlockUpdateTooLongCnt = 0
    var videoHeight = 0; var videoWidth = 0; var resolutionType = ""; var videoCodec = ""; var audioCodec = ""
    var bps = 0; var minBps = 0; var maxBps = 0; var avgBps = 0
    var rtt = 0; var minRtt = 0; var maxRtt = 0; var avgRtt = 0
    /** campo F (setter F0) — saltos de sequência TS */ var tsSeqGapCnt = 0
    var streamEvent: MutableMap<String, AtomicInteger> = HashMap()
}

/**
 * Estado do monitor do player durante uma reprodução.
 * Original: tf/c.java (mapa getter→campo deduzido em f.n()/f.y())
 */
class PlayerMonitorStat {
    /** a */ val isReported = AtomicBoolean(false)
    /** b */ var playType: PlayType? = null
    /** c */ var mediaPlayMode = 0
    /** d */ var currentPlaylist: Set<String> = LinkedHashSet()
    /** e */ var lastPlaylistMillis = 0L
    /** f */ val blockStats = ConcurrentSkipListMap<String, BlockStabilityStat>()
    /** g */ var requestBlockCnt = 0
    /** h */ var requestPlaylistCnt = 0
    /** i */ var bufferingCnt = 0
    /** j */ var bufferingMs = 0L
    /** k */ var maxPlaylistSize = 0
    /** l */ var disorderCnt = 0
    /** m */ var restartCnt = 0
    /** n */ var blockIndexCounter = 0
    /** o */ var lastTsSeq = -1L
    /** p */ var disorderSeq = ""
    /** q */ val tsSeqList: MutableList<String> = java.util.Collections.synchronizedList(ArrayList())
    /** r */ var lastBlockName = ""
    /** s */ var lastBlockAddTime = 0L
    /** t */ var playlistResponseCost = 0L
    /** u */ var lastPlaylistResponseTime = 0L
    /** v */ var lastBlockRequestTime = 0L
    /** w */ val playEndMetric = PlayEndMetric()
    /** x */ var noSignalCnt = 0
    /** y..F: contadores de restart (ver PlayerMonitor.onRestartEvent) */
    var restartDisorderTsSeq = 0; var restartBufferingTooLong = 0; var restartNoBlockRequestTooLong = 0
    var restartNoListRequestTooLong = 0; var restartNoBlockResponseTooLong = 0; var restartNoListResponseTooLong = 0
    var restartNoBlockUpdateTooLong = 0; var restartNoListUpdateTooLong = 0
    /** G */ var tsSeqGapCnt = 0
    /** H..O */ var bps = 0L; var maxBps = 0L; var minBps = 0L; var avgBps = 0L
    var rtt = 0; var maxRtt = 0; var minRtt = 0; var avgRtt = 0
    /** P, Q, R */ var resendCnt = 0; var lossRate = 0; var resendRate = 0
    /** S, T */ var videoWidth = 0; var videoHeight = 0
    /** U, V, W */ var resolutionType = "Unknown"; var videoCodec = ""; var audioCodec = ""
    /** X */ val streamEvent: MutableMap<String, AtomicInteger> = HashMap()
}

/**
 * Cronometragem de zapping (troca de canal). Nomes reais preservados no dex.
 * Original: tf/d.java (extends n6.a — toString por reflexão)
 */
class PlayerZappingStat {
    var errorCode = 0; var errorType = 0
    var firstM3U8RequestCnt = 0; var firstM3U8ResponseToPlayer = 0L; var firstM3u8RequestFromPlayer = 0L
    var firstTSBytes = 0; var firstTSDuration = 0.0; var firstTSIndex = 0; var firstTSRequestCnt = 0
    var firstTSRequestFromPlayer = 0L; var firstTSResponseToPlayer = 0L
    var lastTSRequestFromPlayer = 0L; var lastTSResponseToPlayer = 0L
    var loginSession = 0L; var mediaPlayMode = 0
    var playUrlInjectIntoPlayer = 0L; var playUrlReadyFromEngine = 0L
    var requestTSCntDuringPreparing = 0; var retryCnt = 0; var seq = 0; var session = 0L; var start = 0L
    var stopEnginePlay = 0L; var stopPlayer = 0L
    var monitorStat: PlayerMonitorStat? = null
    var player = ""; var channel = ""; var streamId = ""; var route = ""
    var sessionFromPlayerRequest = ""; var error = ""
    var isFirstTSFromLocalCache = false
    var playerPrepared = 0L
    var minRTT = 0; var avgRTT = 0; var maxRTT = 0; var lossRate = 0
    var streamMap: MutableMap<String, Int> = HashMap()
    lateinit var playType: PlayType
}

/** Métrica de zapping. Original: vf/f.java (campos na ordem do construtor) */
data class ZappingTimeMetric(
    val loginSession: Long, val channel: String, val route: String, val streamId: String, val playType: String,
    val seq: Int, val session: Long, val mediaPlayMode: Int, val retry: Int,
    val zappingTimeMs: Long, val stopEnginePlayMs: Long, val startEnginePlayMs: Long, val stopPlayerMs: Long,
    val injectUrlMs: Long, val firstPlaylistRequestMs: Long, val firstPlaylistResponseMs: Long,
    val firstBlockRequestMs: Long, val firstBlockResponseMs: Long,
    val firstTSBytes: Int, val firstTSDuration: Double, val isFirstTSFromLocalCache: Boolean, val firstBlockIndexInPlaylist: Int,
    val lastBlockResponseMs: Long, val blockCnt: Int, val renderMs: Long, val renderAfterAllMs: Long,
    val streamMap: Map<String, Int>, val streamEvent: Map<String, AtomicInteger>,
)

/** Métrica de estabilidade do stream (campos públicos com nomes reais). Original: vf/d.java */
class StreamEndStabilityMetric {
    var loginSession = 0L; var mediaPlayMode = 0; var route: String? = null; var session = 0L; var streamId: String? = null
    var playType = ""
    var maxBlockSize = 0; var minBlockSize = Int.MAX_VALUE; var avgBlockSize = 0.0
    var maxResendCnt = Int.MIN_VALUE; var minResendCnt = Int.MAX_VALUE; var avgResendCnt = 0.0
    var minResendRate = 100; var maxResendRate = 0; var avgResendRate = 0.0
    var minAvgLossRate = 100; var maxAvgLossRate = 0; var avgAvgLossRate = 0.0
    var minRTT = Int.MAX_VALUE; var maxRTT = Int.MIN_VALUE; var avgRTT = 0.0
    var minTime = Long.MAX_VALUE; var maxTime = 0L; var avgTime = 0.0
    var blockCnt = 0
    var sizeDistributionMap: MutableMap<Int, AtomicInteger> = HashMap()
    var resendCntDistributionMap: MutableMap<Int, AtomicInteger> = HashMap()
    var resendRateDistributionMap: MutableMap<Int, AtomicInteger> = HashMap()
    var avgLossRateDistributionMap: MutableMap<Int, AtomicInteger> = HashMap()
    var timeDistribution: MutableMap<Long, AtomicInteger> = HashMap()
}
