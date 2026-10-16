package com.foxivid.baselib.device

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.os.BatteryManager
import android.os.Build
import android.os.Environment
import android.os.StatFs
import android.provider.Settings
import android.telephony.TelephonyManager
import android.text.TextUtils
import android.util.Log
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.metric.model.SystemInfo
import com.foxivid.baselib.upgrade.ApkInstaller
import com.foxivid.baselib.util.AppAttrUtils
import com.foxivid.baselib.util.NetworkInfoManager
import com.foxivid.baselib.util.SignatureUtils
import org.slf4j.LoggerFactory
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.io.LineNumberReader
import java.io.StringReader
import java.net.Inet4Address
import java.net.NetworkInterface

/**
 * Coleta de impressão digital do dispositivo (fingerprint de hardware).
 *
 * Original: x1/f1/lb/util/z.java
 *
 * Monta um mapa `_devProp` (chave -> valor) com:
 *  - campos de `android.os.Build` (brand, model, device, product, ..., fingerprint, SOC_* em API 31+);
 *  - MACs de `eth0` e `wlan0` (sem ":" e em minúsculas — via helper de rede zf/f);
 *  - `Settings.Secure.ANDROID_ID`;
 *  - CID do eMMC (`/sys/block/mmcblk0/device/cid`);
 *  - serial/hardware da CPU (`/proc/cpuinfo`, `/sys/class/sunxi_info/sys_info` (Allwinner), `/proc/cpu_chipid`);
 *  - "st": USID das unifykeys Amlogic (escreve "usid" em `/sys/class/unifykeys/name` e lê `/sys/class/unifykeys/read`);
 *  - assinatura do pacote de sistema `com.android.providers.settings` (detecta firmware/ROM);
 *  - flags de app de sistema, app id, versão, pacote;
 *  - "did" (inserido por [putDid] após [Installation.id]).
 *
 * Também expõe gateway (`ip route list table 0` com fallback para LinkProperties) e IPs/máscara.
 * A heurística [isMobile] = "sem eth_mac, com SIM e com bateria".
 */
object DeviceInfoCollector {

    private val logger = LoggerFactory.getLogger(DeviceInfoCollector::class.java)

    private var ETHERNET_INTERFACE = "eth0"
    private const val WIFI_INTERFACE = "wlan0"

    private var ethernetMac = ""
    private var wifiMac = ""
    private var cpuSerial = ""
    private var cpuHardware = ""

    private val _devProp = HashMap<String, String>()
    private var _devInfoJson = ""

    private var simFlag: Int? = null
    private var batteryFlag: Int? = null
    private var mobileFlag: Int? = null

    /** Original: z.d() — capacidade da bateria (%), -1 se indisponível. */
    fun getBatteryCapacity(): Int = try {
        val ctx = BaseLibConfig.appContext
        val bm = ctx?.getSystemService("batterymanager") as? BatteryManager
        if (bm == null) -1 else {
            val cap = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
            logger.info("mobile_batteryCapacity[$cap %]")
            cap
        }
    } catch (t: Throwable) {
        logger.error("get battery capacity failure", t); -1
    }

    /** Original: z.C(String) — lê um nó do sysfs/procfs inteiro como texto. */
    private fun readNode(node: String): String = try {
        FileInputStream(File(node)).use { it.readBytes().toString(Charsets.UTF_8) }
    } catch (t: Throwable) {
        logger.debug("read from node error", t); ""
    }

    /** Original: z.a(short) — converte prefixo (/24) em máscara pontuada. */
    private fun prefixToMask(length: Short): String {
        val mask = (-1) shl (32 - length)
        val parts = IntArray(4) { 0 }
        for (i in 0 until 4) parts[3 - i] = (mask shr (i * 8)) and 255
        return parts.joinToString(".")
    }

    /** Original: z.g() — tenta 3 fontes para o serial da CPU. */
    private fun loadCpuInfo() {
        parseCpuInfo("/proc/cpuinfo", "Serial", "Hardware")
        if (cpuSerial.isEmpty()) parseCpuInfo("/sys/class/sunxi_info/sys_info", "sunxi_serial", "Hardware")
        if (cpuSerial.isEmpty()) parseCpuInfo("/proc/cpu_chipid", "Serial", "Hardware")
    }

    /** Original: z.h(node, cpu, hardware) — linhas "chave : valor". */
    private fun parseCpuInfo(node: String, cpu: String, hardware: String) {
        if (!File(node).exists()) return
        try {
            val reader = LineNumberReader(StringReader(readNode(node)))
            while (true) {
                val line = reader.readLine() ?: return
                val parts = line.split(":").dropLastWhile { it.isEmpty() }
                if (parts.isEmpty()) return // Original: break ao achar linha sem ":" útil
                if (parts.size == 2) {
                    val k = parts[0].trim()
                    val v = parts[1].trim()
                    if (cpu.equals(k, ignoreCase = true)) cpuSerial = v
                    else if (hardware.equals(k, ignoreCase = true)) cpuHardware = v
                }
            }
        } catch (t: Throwable) {
            logger.debug("getCpuInfo error", t)
        }
    }

    /** Original: z.j() — CID do eMMC. */
    private fun getEmmcId(): String = readNode("/sys/block/mmcblk0/device/cid").trim()

    /**
     * Original: z.k(Context, boolean) — MAC Ethernet (double-checked locking).
     * Valor vem de [NetworkInfoManager] (zf/f.f(context).d()).
     */
    private fun getEthernetMac(context: Context, printLog: Boolean): String {
        if (TextUtils.isEmpty(ethernetMac)) synchronized(this) {
            if (TextUtils.isEmpty(ethernetMac)) {
                try {
                    ethernetMac = NetworkInfoManager.get(context).ethernetMac()   // zf/f.f(context).d(): MAC de eth0 sem ':' em minúsculas
                } catch (t: Throwable) {
                    if (printLog) logger.warn("getEthernetMac error", t)
                }
            }
        }
        if (printLog) logger.info("ethernetMac:$ethernetMac")
        return ethernetMac
    }

    /**
     * Original: z.t() — USID das "unifykeys" (SoCs Amlogic): seleciona a chave escrevendo "usid"
     * no nó `name` e lê o valor em `read`.
     */
    private fun getAmlogicUsid(): String {
        val file = File("/sys/class/unifykeys/name")
        if (!file.exists()) return ""
        return try {
            FileOutputStream(file).use { it.write("usid".toByteArray(Charsets.UTF_8)) }
            readNode("/sys/class/unifykeys/read")
        } catch (t: Throwable) {
            logger.debug("read st error", t); ""
        }
    }

    /** Original: z.A() — possui telefonia (phoneType != NONE). */
    fun hasSim(): Boolean {
        val ctx = BaseLibConfig.appContext ?: return false
        val tm = ctx.getSystemService("phone") as TelephonyManager
        return try {
            val r = tm.phoneType != 0
            logger.info("mobile_phoneType[$r]"); r
        } catch (t: Throwable) {
            logger.error("get phone type failure", t); false
        }
    }

    /** Original: z.B(String) — insere o did no mapa. */
    fun putDid(did: String) {
        getDeviceProperties()["did"] = did
    }

    /** Original: z.b(Context). */
    @SuppressLint("HardwareIds")
    fun getAndroidId(context: Context): String = try {
        Settings.Secure.getString(context.contentResolver, "android_id")!!
    } catch (t: Throwable) { "" }

    /** Original: z.e(). */
    fun getBatteryFlag(): Int? = batteryFlag

    /**
     * Monta (uma vez) e retorna o mapa de propriedades do dispositivo.
     * Original: z.i()
     */
    fun getDeviceProperties(): HashMap<String, String> {
        val ctx = BaseLibConfig.appContext ?: return _devProp
        val map = _devProp
        if (map.isNotEmpty()) {
            if (TextUtils.isEmpty(map["wifi_mac"])) map["wifi_mac"] = getWifiMac(ctx, false)
            if (TextUtils.isEmpty(map["has_sim"])) { map["has_sim"] = hasSim().toString(); hasSimFlag() }
            if (TextUtils.isEmpty(map["has_battery_capacity"])) {
                map["has_battery_capacity"] = (getBatteryCapacity() > 0).toString(); hasBatteryFlag()
            }
            return map
        }
        map["brand"] = Build.BRAND
        map["model"] = Build.MODEL
        map["device"] = Build.DEVICE
        map["product"] = Build.PRODUCT
        map["build_id"] = Build.ID
        map["display"] = Build.DISPLAY
        map["board"] = Build.BOARD
        map["manufacturer"] = Build.MANUFACTURER
        map["bootloader"] = Build.BOOTLOADER
        val sdk = Build.VERSION.SDK_INT
        if (sdk >= 31) {
            map["soc_manufacturer"] = Build.SOC_MANUFACTURER
            map["soc_model"] = Build.SOC_MODEL
            map["sku"] = Build.SKU
            map["odm_sku"] = Build.ODM_SKU
            map["media_performance_class"] = Build.VERSION.MEDIA_PERFORMANCE_CLASS.toString()
        }
        map["hardware"] = Build.HARDWARE
        map["supported_abis"] = java.util.Arrays.deepToString(Build.SUPPORTED_ABIS)
        map["incremental"] = Build.VERSION.INCREMENTAL
        if (sdk >= 23) {
            map["base_os"] = Build.VERSION.BASE_OS
            map["security_patch"] = Build.VERSION.SECURITY_PATCH
            map["preview_sdk_int"] = Build.VERSION.PREVIEW_SDK_INT.toString()
        }
        map["sdk_int"] = sdk.toString()
        map["codename"] = Build.VERSION.CODENAME.toString()
        // Nota: o original grava Build.USER em "build_serial" (não Build.SERIAL).
        map["build_serial"] = Build.USER
        map["build_host"] = Build.HOST
        map["build_user"] = Build.USER
        map["fingerprint"] = Build.FINGERPRINT
        map["eth_mac"] = getEthernetMac(ctx, true)
        map["wifi_mac"] = getWifiMac(ctx, true)
        map["android_id"] = getAndroidId(ctx)
        // Original: x1/f1/lb/util/k (AppAttrUtils): x(), q(), s(), t()
        map["package_name"] = AppAttrUtils.packageName()
        map["app_id"] = AppAttrUtils.appId().toString()
        map["app_ver_code"] = AppAttrUtils.appVersion().toString()
        map["app_ver_name"] = AppAttrUtils.appVersionName()
        map["system_app_flag"] = ApkInstaller.isSelfSystemApp(ctx).toString()   // m0.a(context)
        map["emmc_id"] = getEmmcId()
        map["system_sign"] = SignatureUtils.getSignatureMd5(ctx, "com.android.providers.settings")   // y0.c
        loadCpuInfo()
        map["cpu_hadrware"] = cpuHardware // (sic) typo da chave no original
        map["cpu_serial"] = cpuSerial
        map["st"] = getAmlogicUsid()
        return map
    }

    /** Original: z.l() — espaço livre do armazenamento externo em KiB. */
    fun getFreeStorageKb(): Long = try {
        val path = Environment.getExternalStorageDirectory().path
        if (File(path).exists()) StatFs(path).availableBytes / 1024L else 0L
    } catch (e: Exception) {
        Log.e("[DeviceMonitor]", "getRomRate failed $e"); 0L
    }

    /**
     * Original: z.m() — gateways. Executa `ip route list table 0` e pega o 3º campo
     * da primeira linha que for IP válido (f2/a.f); se vazio, usa LinkProperties.routes.
     */
    fun getGateways(): List<String> {
        val list = ArrayList<String>()
        val ctx = BaseLibConfig.appContext ?: return list
        try {
            val p = Runtime.getRuntime().exec("ip route list table 0")
            val br = BufferedReader(InputStreamReader(p.inputStream))
            while (true) {
                val line = br.readLine() ?: break
                val f = line.split(Regex("\\s+"))
                if (f.size >= 3 && com.google.common.net.InetAddresses.isInetAddress(f[2])   // f2/a.f = Guava InetAddresses.isInetAddress) {
                    list.add(f[2]); break
                }
            }
            br.close(); p.waitFor()
        } catch (t: Throwable) {
            logger.debug("getGateway error", t)
        }
        if (list.isEmpty() && Build.VERSION.SDK_INT >= 23) {
            try {
                val cm = ctx.getSystemService("connectivity") as ConnectivityManager
                cm.getLinkProperties(cm.activeNetwork)?.routes?.forEach { r ->
                    val h = r.gateway?.hostAddress
                    if (h != null && h != "::" && h != "0.0.0.0") list.add(h)
                }
            } catch (_: Throwable) {
            }
        }
        return list
    }

    /** Original: z.n() — "ip/mascara" de todas interfaces IPv4 ativas (exceto 127.0.0.1). */
    fun getIpAndMasks(): List<String> {
        val list = ArrayList<String>()
        try {
            val e = NetworkInterface.getNetworkInterfaces()
            while (e.hasMoreElements()) {
                val ni = e.nextElement()
                if (!ni.isUp) continue
                for (ia in ni.interfaceAddresses) {
                    if (ia.address is Inet4Address) {
                        val host = ia.address.hostAddress!!
                        if (host != "127.0.0.1") list.add(host + "/" + prefixToMask(ia.networkPrefixLength))
                    }
                }
            }
        } catch (t: Throwable) {
            logger.debug("getIP and Mask error", t)
        }
        return list
    }

    /** Original: z.p(). */
    fun getMobileFlag(): Int? = mobileFlag

    /** Original: z.r(). */
    fun getSimFlag(): Int? = simFlag

    /**
     * Original: z.u() — monta tf/SystemInfo (modelo de métricas) com did, cpu_serial, macs,
     * android_id, manufacturer, hardware, display, brand, model, abis, build_user, build_host, fingerprint.
     */
    fun getSystemInfo(): SystemInfo {
        val p = getDeviceProperties()
        fun v(key: String) = p[key] ?: ""
        return SystemInfo(v("did"), v("cpu_serial"), v("eth_mac"), v("wifi_mac"), v("android_id"), v("manufacturer"), v("hardware"),
            v("display"), v("brand"), v("model"), v("supported_abis"), v("build_user"), v("build_host"), v("fingerprint"), 0)
    }

    /** Original: z.v(Context, boolean) — MAC Wi-Fi via zf/f.f(context).j(). */
    @SuppressLint("HardwareIds")
    fun getWifiMac(context: Context, printLog: Boolean = false): String {
        if (TextUtils.isEmpty(wifiMac)) synchronized(this) {
            if (TextUtils.isEmpty(wifiMac)) {
                try {
                    wifiMac = NetworkInfoManager.get(context).wifiMac()   // zf/f.f(context).j(): MAC de wlan0 sem ':' em minúsculas
                } catch (t: Throwable) {
                    if (printLog) logger.error("getWifiMac error", t)
                }
            }
        }
        if (printLog) logger.info("wifiMac:$wifiMac")
        return wifiMac
    }

    /** Original: z.c(). */
    fun getAndroidId(): String = getDeviceProperties()["android_id"] ?: ""

    /** Original: z.f(). */
    fun getBrand(): String = getDeviceProperties()["brand"] ?: "Unknown"

    /** Original: z.o() — eth_mac, ou wifi_mac se vazio. */
    fun getMac(): String {
        var s = getDeviceProperties()["eth_mac"]
        if (s.isNullOrEmpty()) s = getDeviceProperties()["wifi_mac"]
        return s ?: ""
    }

    /** Original: z.q(). */
    fun getModel(): String = getDeviceProperties()["model"] ?: "Unknown"

    /** Original: z.s() — cpu_serial, ou [getMac] se vazio. */
    fun getCpuSerialOrMac(): String {
        val s = getDeviceProperties()["cpu_serial"] ?: ""
        return if (s.isEmpty()) getMac() else s
    }

    /** Original: z.x(). */
    fun hasBatteryFlag(): Boolean {
        val v = getDeviceProperties()["has_battery_capacity"].toBoolean()
        if (batteryFlag == null) batteryFlag = if (v) 1 else 0
        return v
    }

    /** Original: z.y(). */
    fun hasSimFlag(): Boolean {
        val v = getDeviceProperties()["has_sim"].toBoolean()
        if (simFlag == null) simFlag = if (v) 1 else 0
        return v
    }

    /** Original: z.z() — "é celular": sem Ethernet, com SIM e com bateria. */
    fun isMobile(): Boolean {
        val eth = getDeviceProperties()["eth_mac"]
        val r = !(eth != null && eth.isNotEmpty()) && hasSimFlag() && hasBatteryFlag()
        if (mobileFlag == null) mobileFlag = if (r) 1 else 0
        return r
    }
}
