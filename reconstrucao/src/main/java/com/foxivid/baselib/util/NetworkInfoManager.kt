package com.foxivid.baselib.util

import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import android.os.Build
import android.telephony.TelephonyManager
import android.text.TextUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.FileInputStream
import java.lang.ref.SoftReference
import java.net.Inet4Address
import java.net.NetworkInterface

/**
 * Gerenciador de informação de rede (singleton): MAC de `wlan0`, `eth0` e Bluetooth, IPs IPv4, SSID/RSSI do Wi-Fi e tipo de
 * conexão. Os MACs são lidos de `NetworkInterface` e, quando vazios, do arquivo `/sys/class/net/eth0/address` (ethernet) ou de
 * `WifiInfo.getMacAddress()`; o último valor bom é guardado em [Preferences] (`ethernet_mac`, `wifi_mac`, `bluetooth_mac`) e
 * reaproveitado se a leitura falhar. A atualização é limitada a uma vez a cada 10 s.
 *
 * Original: zf/f.java
 */
class NetworkInfoManager private constructor(context: Context) {
    private val contextRef = SoftReference(context)
    private val wifiManager: WifiManager = context.getSystemService("wifi") as WifiManager             // f23268n
    private val connectivity: ConnectivityManager = context.getSystemService("connectivity") as ConnectivityManager // f23267m
    private val telephony: TelephonyManager? = context.getSystemService("phone") as? TelephonyManager  // f23269o (não usado aqui)
    private var bluetoothAdapter: BluetoothAdapter? = null                                              // f23270p
    private val prefs: SharedPreferences = context.getSharedPreferences("network", 0)                  // f23255a (não usado aqui)

    private var wifiMac: String? = null          // f23257c
    private var wifiSsid: String? = null         // f23258d
    private var wifiRssi: Int? = null            // f23259e
    private var ethernetMac: String? = null      // f23260f
    private var bluetoothMac: String? = null     // f23261g
    private var wifiIp: String? = null           // f23262h
    private var ethernetIp: String? = null       // f23263i
    private var savedEthernetMac: String? = null // f23264j (valor persistido)
    private var savedWifiMac: String? = null     // f23265k
    private var savedBluetoothMac: String? = null // f23266l
    private var ethernetFileReadable = true      // f23271q
    private var interfacesReadable = true        // f23272r
    private var bluetoothReadable = true         // f23273s
    private var lastRefresh = 0L                 // f23275u

    init {
        try { bluetoothAdapter = BluetoothAdapter.getDefaultAdapter() } catch (e: Exception) { logger.debug("get bluetooth failure", e) }
        Preferences.getString("ethernet_mac", { savedEthernetMac = it }, "")
        Preferences.getString("wifi_mac", { savedWifiMac = it }, "")
        Preferences.getString("bluetooth_mac", { savedBluetoothMac = it }, "")
        refresh()
    }

    /** Tipo de conexão: 0 sem rede, 1 Wi-Fi, 2 celular, 3 ethernet, 4 outro/erro. Original: i() */
    fun networkType(): Int {
        return try {
            val info = connectivity.activeNetworkInfo
            if (info == null || !info.isConnected) return 0
            when (info.type) { 1 -> 1; 0 -> 2; 9 -> 3; else -> 4 }
        } catch (t: Throwable) {
            logger.debug("get network type exception " + t.message)
            4
        }
    }

    /** Lê o MAC de eth0 em `/sys/class/net/eth0/address` (17 bytes, '-' vira ':'). Original: g() */
    private fun readEthernetMacFromFile(): String {
        if (!ethernetFileReadable) return ""
        var input: FileInputStream? = null
        return try {
            input = FileInputStream("/sys/class/net/eth0/address")
            val buf = ByteArray(17)
            input.read(buf, 0, 17)
            var str = String(buf)
            if (str.contains("-")) str = str.replace("-", ":").trim()
            if (str.isNotEmpty()) str.lowercase() else { logger.debug("getMac by file return empty!"); "" }
        } catch (t: Throwable) {
            logger.debug("getMac by file error: [{}->{}]", t.javaClass.name, t.message)
            ethernetFileReadable = false
            ""
        } finally {
            try { input?.close() } catch (_: Throwable) {}
        }
    }

    /** Primeiro IPv4 não-loopback da interface. Original: h(NetworkInterface) */
    private fun firstIpv4(ni: NetworkInterface?): String {
        if (ni == null) return ""
        return try {
            val addrs = ni.inetAddresses
            while (addrs.hasMoreElements()) {
                val a = addrs.nextElement()
                if (!a.isLoopbackAddress && a is Inet4Address) return a.hostAddress ?: ""
            }
            ""
        } catch (e: Exception) { "" }
    }

    /** Byte -> "xx:" (dois dígitos hex). Original: s(byte) */
    private fun hexByte(b: Byte): String {
        val str = "00" + Integer.toHexString(b.toInt()) + ":"
        return str.substring(str.length - 3)
    }

    /** MAC "aa:bb:cc:dd:ee:ff"; null se [bytes] nulo. Original: t(byte[]) */
    private fun macToString(bytes: ByteArray?): String? {
        if (bytes == null) return null
        val sb = StringBuilder()
        for (b in bytes) sb.append(hexByte(b))
        return sb.substring(0, sb.length - 1)
    }

    /** SSID e RSSI do Wi-Fi atual (Q+: via NetworkCapabilities.transportInfo). Original: v(ConnectivityManager) */
    private fun readWifiSignal(cm: ConnectivityManager) {
        try {
            val info: WifiInfo? = if (Build.VERSION.SDK_INT >= 29) {
                val caps = cm.getNetworkCapabilities(cm.activeNetwork)
                caps?.transportInfo as? WifiInfo
            } else wifiManager.connectionInfo
            if (info == null) return
            wifiSsid = info.ssid
            wifiRssi = info.rssi
        } catch (t: Throwable) {
            logger.debug("get Wifi signal failure: [{}->{}]", t.javaClass.name, t.message)
        }
    }

    /** MAC ethernet em minúsculas e sem ':' ("" se desconhecido). Original: d() */
    fun ethernetMac(): String = ethernetMac?.replace(":", "")?.lowercase() ?: ""
    /** MAC Wi-Fi em minúsculas e sem ':' ("" se desconhecido). Original: j() */
    fun wifiMac(): String = wifiMac?.replace(":", "")?.lowercase() ?: ""
    /** Original: k() */ fun wifiRssi(): Int? = wifiRssi
    /** Original: l() */ fun wifiSsid(): String? = wifiSsid
    /** Há rede ativa conectada? Original: n() */
    fun isConnected(): Boolean { val i = connectivity.activeNetworkInfo; return i != null && i.isConnected }
    /** Rede ativa é Wi-Fi? (atualiza SSID/RSSI como efeito colateral). Original: o() */
    fun isWifi(): Boolean {
        if (contextRef.get() == null) return false
        val info = connectivity.activeNetworkInfo
        if (info == null || info.type != 1) return false
        readWifiSignal(connectivity)
        return true
    }

    /**
     * Atualiza MACs/IPs (no máx. 1x/10 s). Percorre as interfaces: `wlan0` -> wifiMac/wifiIp; `eth0` -> ethernetMac/ethernetIp;
     * completa o Wi-Fi por `WifiInfo.getMacAddress()` (ignora "02:00:00:00:00:00") e a ethernet pelo arquivo sysfs; persiste valores
     * novos em [Preferences] ou recupera os guardados. Depois o endereço Bluetooth (mesma regra). Original: u()
     */
    fun refresh() {
        val now = ServerTime.now()
        if (now - lastRefresh < 10_000) return
        lastRefresh = now
        if (interfacesReadable && (savedWifiMac == null || savedEthernetMac == null || TextUtils.isEmpty(wifiMac) || TextUtils.isEmpty(ethernetMac))) {
            try {
                val ifaces = NetworkInterface.getNetworkInterfaces()
                while (ifaces.hasMoreElements()) {
                    val ni = ifaces.nextElement()
                    if ("wlan0" == ni.displayName) { wifiMac = macToString(ni.hardwareAddress); wifiIp = firstIpv4(ni) }
                    else if ("eth0" == ni.displayName) { ethernetMac = macToString(ni.hardwareAddress); ethernetIp = firstIpv4(ni) }
                }
                if (TextUtils.isEmpty(wifiMac)) {
                    val mac = wifiManager.connectionInfo.macAddress
                    if (!TextUtils.isEmpty(mac) && "020000000000" != mac && "02:00:00:00:00:00" != mac) wifiMac = mac
                }
                if (TextUtils.isEmpty(ethernetMac)) ethernetMac = readEthernetMacFromFile()
                if (!TextUtils.isEmpty(wifiMac)) {
                    if (wifiMac != savedWifiMac) { savedWifiMac = wifiMac; Preferences.putString("wifi_mac", wifiMac!!) }
                } else wifiMac = savedWifiMac ?: ""
                if (!TextUtils.isEmpty(ethernetMac)) {
                    if (ethernetMac != savedEthernetMac) { savedEthernetMac = ethernetMac; Preferences.putString("ethernet_mac", ethernetMac!!) }
                } else ethernetMac = savedEthernetMac ?: ""
            } catch (t: Throwable) {
                interfacesReadable = false
                logger.debug("refreshNetworkInfo ethernet/wifi failed: [{}->{}]", t.javaClass.name, t.message)
            }
        }
        if (bluetoothReadable && (savedBluetoothMac == null || TextUtils.isEmpty(bluetoothMac))) {
            try {
                val adapter = bluetoothAdapter
                if (adapter != null) {
                    val address = adapter.address
                    if (!TextUtils.isEmpty(address) && "020000000000" != address && "02:00:00:00:00:00" != address) bluetoothMac = address
                }
                if (!TextUtils.isEmpty(bluetoothMac)) {
                    if (bluetoothMac != savedBluetoothMac) { savedBluetoothMac = bluetoothMac; Preferences.putString("bluetooth_mac", bluetoothMac!!) }
                } else bluetoothMac = savedBluetoothMac ?: ""
            } catch (t: Throwable) {
                bluetoothReadable = false
                logger.debug("refreshNetworkInfo bluetooth failed: [{}->{}]", t.javaClass.name, t.message)
            }
        }
        if (interfacesReadable || bluetoothReadable) logger.debug("ethernetMac[{}], wifiMac[{}], bluetoothMac[{}]", ethernetMac, wifiMac, bluetoothMac)
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(NetworkInfoManager::class.java)
        private var instance: NetworkInfoManager? = null

        /** Instância atual (pode ser null antes de [init]). Original: e() */
        fun current(): NetworkInfoManager? = instance

        /** Cria (se preciso) e atualiza o singleton. Original: m(Context) */
        fun init(context: Context) {
            try {
                val i = instance
                if (i == null || i.contextRef.get() == null) instance = NetworkInfoManager(context)
                instance!!.refresh()
            } catch (t: Throwable) {
                logger.debug("init network manager failure", t)
            }
        }

        /** Original: f(Context) */
        fun get(context: Context): NetworkInfoManager { init(context); return instance!! }
    }
}
