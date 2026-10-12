package com.foxivid.baselib.metric.monitor

import com.foxivid.baselib.metric.model.UpgradeMetric
import com.foxivid.baselib.metric.model.UpgradeStat
import com.foxivid.baselib.util.LoggerFactory
import com.foxivid.baselib.util.ResStrings
import java.util.concurrent.LinkedBlockingQueue
import kotlin.math.pow
import kotlin.math.sqrt
import x.l1.b2.R

/**
 * Consultas de tempos de playlist/bloco por sessão e player (usado pelo player para detectar
 * travamentos). Original: x1/f1/lb/metric/monitor/b.java
 */
interface BlockTimingQuery {
    /** Original: b.b — último request de playlist */ fun lastPlaylistRequestTime(session: Long, player: Int): Long?
    /** Original: b.i — bloco atual é o último da playlist (VOD terminou?) */ fun isLastBlock(session: Long, player: Int): Boolean
    /** Original: b.j — progresso de download em milésimos */ fun downloadThousand(session: Long, player: Int): Int
    /** Original: b.q — último request de bloco */ fun lastBlockRequestTime(session: Long, player: Int): Long?
}

/** Interface marcador vazia. Original: x1/f1/lb/metric/monitor/c.java (implementada por quem registra em PlayerMonitor.setMonitor) */
interface PlayerMonitorListener

/** Estatísticas de rede do TS proxy. Original: x1/f1/lb/metric/monitor/d.java */
interface StreamNetStatsQuery {
    /** d.a */ fun lastBlockUpdateTime(session: Long, player: Int): Long?
    /** d.c */ fun minRtt(): Int
    /** d.d */ fun avgRtt(): Int
    /** d.e */ fun lastPlaylistUpdateTime(session: Long, player: Int): Long?
    /** d.f */ fun lastBlockResponseTime(session: Long, player: Int): Long?
    /** d.g */ fun maxRtt(): Int
    /** d.h */ fun rtt(): Int
    /** d.k */ fun avgBps(): Long
    /** d.l */ fun bps(): Int
    /** d.m */ fun resendCount(): Int
    /** d.o */ fun resendRate(): Int
    /** d.p */ fun lossRate(): Int
    /** d.r */ fun lastPlaylistResponseTime(session: Long, player: Int): Long?
}

/**
 * Guarda a estatística do upgrade atual.
 * Original: x1/f1/lb/metric/monitor/i.java
 */
object UpgradeMonitor {
    private var upgradeStat: UpgradeStat? = null

    /** Original: i.a() */
    fun newUpgradeStat(): UpgradeStat = UpgradeStat().also { upgradeStat = it }

    /**
     * Original: i.b() — overheads calculados como diferenças entre campos:
     * infoCompleteOverhead = infoCompleteTime - eventTime; apkDownloadOverhead = apkDownloadCompleteTime - infoCompleteTime.
     */
    fun upgradeMetric(): UpgradeMetric? {
        val s = upgradeStat ?: return null
        return UpgradeMetric(s.eventTime, s.infoCompleteTime - s.eventTime, s.infoFailureMsg,
            s.apkDownloadCompleteTime - s.infoCompleteTime, s.apkDownloadFailureMsg, s.apkInstallStartTime, s.apkInstallFailureMsg)
    }

    /** Original: i.c() */
    fun currentUpgradeStat(): UpgradeStat? = upgradeStat
}

/**
 * Monitor de Wi-Fi: SSID, RSSI atual/min/max, média e desvio-padrão das últimas 60 amostras
 * (uma por tick do heartbeat, ~5 s). Fonte: `zf.f` (singleton de estado de rede).
 *
 * Original: x1/f1/lb/metric/monitor/e.java
 */
object NetworkMonitor {
    private val logger = LoggerFactory.getLogger(NetworkMonitor::class.java)
    private var wifiSSID: String? = null
    private var wifiRssi: Int? = null
    private var minWifiRssi: Int? = null
    private var maxWifiRssi: Int? = null
    private var wifiRssiStdDev: Double? = null
    private var wifiRssiMean: Double? = null
    private val wifiRssiSample = LinkedBlockingQueue<Double>(60)

    /** Original: e.d(Double[]) — média e desvio-padrão populacional. */
    private fun computeStats(array: Array<Double>) {
        if (array.isEmpty()) return
        val mean = array.sum() / array.size
        wifiRssiMean = mean
        wifiRssiStdDev = sqrt(array.sumOf { (it - mean).pow(2.0) } / array.size)
    }

    /** Original: e.b() — chamado a cada tick do HeartbeatManager. */
    fun refresh() {
        try {
            val st = com.foxivid.baselib.util.NetState.get()
            if (st == null || !st.isWifiConnected()) return
            val ssid = com.foxivid.baselib.util.NetState.get()?.ssid()
            val rssi = com.foxivid.baselib.util.NetState.get()?.rssi()
            if (ssid != wifiSSID && ssid != null && rssi != null) resetFor(ssid, rssi)
            if (rssi != null) addSample(rssi)
        } catch (t: Throwable) {
            logger.error("wifi refresh failure", t)
        }
    }

    /** Original: e.c(String, int) */
    private fun resetFor(ssid: String, rssi: Int) {
        wifiSSID = ssid; wifiRssi = rssi; minWifiRssi = rssi; maxWifiRssi = rssi
        wifiRssiStdDev = 0.0
        wifiRssiSample.clear()
        wifiRssiSample.add(rssi.toDouble())
    }

    /** Original: e.e(int) */
    private fun addSample(rssi: Int) {
        wifiRssi = rssi
        minWifiRssi?.let { if (it > rssi) minWifiRssi = rssi }
        maxWifiRssi?.let { if (it < rssi) maxWifiRssi = rssi }
        val d = rssi.toDouble()
        try {
            try {
                if (wifiRssiSample.remainingCapacity() == 0) wifiRssiSample.remove()
                wifiRssiSample.add(d)
            } catch (t: Throwable) {
                logger.error("network monitor add rssi failure", t)
            }
        } catch (_: Throwable) {
            wifiRssiSample.remove(); wifiRssiSample.add(d)
        }
        computeStats(wifiRssiSample.toTypedArray())
    }

    /** Original: e.f() — nível 0..4: < -100, < -87, < -76, < -54, resto. */
    fun signalLevel(): Int {
        val r = wifiRssi ?: -1
        return when {
            r < -100 -> 0
            r < -87 -> 1
            r < -76 -> 2
            r < -54 -> 3
            else -> 4
        }
    }

    /** Original: e.g() */
    fun signalLevelText(): String = when (signalLevel()) {
        0 -> ResStrings.get(R.string.wifi_signal_0, "weakest")
        1 -> ResStrings.get(R.string.wifi_signal_1, "weaker")
        2 -> ResStrings.get(R.string.wifi_signal_2, "median")
        3 -> ResStrings.get(R.string.wifi_signal_3, "stronger")
        4 -> ResStrings.get(R.string.wifi_signal_4, "strongest")
        else -> ResStrings.get(R.string.wifi_signal_unknown, "unknown")
    }

    /**
     * Texto "networkDesc" incluído em toda métrica. Tipo (zf.f.i()): 1=WiFi, 2=Mobile, 3=Ethernet, 0=sem rede.
     * Original: e.a()
     */
    fun describe(): String {
        val type = com.foxivid.baselib.util.NetState.get()?.type() ?: return "Network[ Unknown ]"
        return when (type) {
            1 -> {
                val r = wifiRssi
                val std = wifiRssiStdDev?.let { String.format("%.2f", it) }
                val mean = wifiRssiMean?.let { String.format("%.2f", it) }
                "Network[ WiFi($wifiSSID) ][ ${signalLevelText()} ][ stdDev=$std, rssi=$r, min=${minWifiRssi ?: r}, mean=$mean, max=${maxWifiRssi ?: r} ]"
            }
            3 -> "Network[ Ethernet ]"
            2 -> "Network[ Mobile ]"
            0 -> "Network[ No ]"
            else -> "Network[ Unknown ]"
        }
    }
}
