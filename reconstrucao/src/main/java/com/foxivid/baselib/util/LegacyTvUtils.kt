package com.foxivid.baselib.util

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import com.foxivid.baselib.config.BaseLibConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.TrustManager

/**
 * Helper legado herdado do antigo app "SuperTV": formatação de datas por código, acesso ao
 * SharedPreferences "config", MD5 e campos HTTP/SQLite que não são mais usados aqui.
 *
 * Usado principalmente por [Preferences] para ofuscar as chaves (MD5 hex) e por
 * [PlayStatsRecorder] para formatar timestamps.
 *
 * Original: x1/f1/lb/util/n.java
 */
class LegacyTvUtils private constructor() {

    private val logger: Logger = LoggerFactory.getLogger(LegacyTvUtils::class.java)

    /** Flag para limpar "vod_playlist_cache" uma única vez em debug. Original: campo `j`. */
    private var vodCacheCleared = false

    /** Original: campo `d` (sempre null). */
    private val unused: String? = null

    /** Original: campo `f` (nunca inicializado). */
    private val database: SQLiteDatabase? = null

    /** Nome da lib nativa legada. Original: campo `g`. */
    private val nativeLibName = "libsupertv.so"

    /** Original: campo `c` (não usado neste arquivo). */
    private val stringMap: MutableMap<String, String> = HashMap()

    /** Original: campo `h` (não usado neste arquivo). */
    private val intMap: MutableMap<Int, Int> = HashMap()

    /** Original: campo `i`. */
    val trustManagers: Array<TrustManager> = arrayOf(TrustAllX509TrustManager())

    /** Original: campo `b`. */
    val hostnameVerifier: HostnameVerifier = TrustAllHostnameVerifier()

    /** Contexto da aplicação obtido por reflexão. Original: campo `e`. */
    var context: Context? = currentApplicationContext()

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var instance: LegacyTvUtils? = null

        /** Original: campo estático `l`. */
        @JvmField
        val EXECUTOR: ExecutorService = Executors.newCachedThreadPool()

        /** User-Agent legado. Original: campo estático `m`. */
        @JvmField
        var USER_AGENT = "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)"

        /** Original: n.n() — singleton preguiçoso (não thread-safe, como no original). */
        @JvmStatic
        fun getInstance(): LegacyTvUtils {
            if (instance == null) instance = LegacyTvUtils()
            return instance!!
        }

        /**
         * Obtém o Application atual via `ActivityThread.currentApplication()` (reflexão).
         * O original passava o resultado por `StubApp.getOrigApplicationContext` (shell Jiagu);
         * aqui usamos o applicationContext direto.
         * Original: n.f()
         */
        @JvmStatic
        fun currentApplicationContext(): Context? = try {
            val app = Class.forName("android.app.ActivityThread")
                .getDeclaredMethod("currentApplication")
                .invoke(null) as Application
            app.applicationContext
        } catch (th: Throwable) {
            UncaughtLogger.log(th)
            null
        }
    }

    /**
     * Formata [millis] segundo um código de formato.
     * Original: n.h()
     */
    fun formatTime(type: Int, millis: Long): String {
        val pattern = when (type) {
            1 -> "HH:mm"
            2 -> "yyyyMMdd"
            3 -> "yyyy-MM-dd"
            4 -> "yyyy/MM/dd"
            5 -> "HH:mm:ss"
            6 -> "HHmmss"
            7 -> "HH"
            8 -> "yyyyMMddHHmmss"
            9 -> "yyyy-MM-dd-HH"
            10 -> "yyyy-MM-dd HH:mm:ss"
            11 -> "yyyyMMddHHmm"
            12 -> "HHmm"
            13 -> "yyyyMMddHH"
            14 -> "yyyy-MM-dd HH:mm"
            15 -> "MMM / d / yyyy"
            16 -> "MM/dd-HH:mm:ss"
            17 -> "MMM / d"
            else -> "yyyy/MM/dd HH:mm:ss"
        }
        return format(pattern, millis)
    }

    /** Bytes -> hex minúsculo. Original: n.a() */
    fun toHex(bytes: ByteArray): String {
        val sb = StringBuilder()
        for (b in bytes) {
            val hex = Integer.toHexString(b.toInt() and 0xFF)
            if (hex.length == 1) sb.append('0')
            sb.append(hex)
        }
        return sb.toString()
    }

    /** Original: n.c() */
    fun format(pattern: String, millis: Long): String {
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(Date(millis))
    }

    /** Converte texto em epoch millis; 0 em caso de erro. Original: n.d() */
    fun parse(text: String, pattern: String): Long = try {
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        sdf.parse(text)!!.time
    } catch (e: Exception) {
        UncaughtLogger.log(e)
        0L
    }

    /** Original: n.e() — delega a DensityAdapter (a0.b()). */
    fun dpToPx(context: Context, value: Float): Float = DensityAdapter.dpToPx(context, value)

    /** SharedPreferences "config". Original: n.k() */
    fun configPrefs(): SharedPreferences = prefs("config")

    /**
     * Abre um SharedPreferences com modo 4 (MODE_MULTI_PROCESS). Em debug remove
     * "vod_playlist_cache" uma vez por processo.
     * Original: n.l()
     */
    @Suppress("DEPRECATION")
    fun prefs(name: String): SharedPreferences {
        val sp = context!!.getSharedPreferences(name, Context.MODE_MULTI_PROCESS)
        if (BaseLibConfig.isDebug && !vodCacheCleared) {
            sp.edit().remove("vod_playlist_cache").apply()
            vodCacheCleared = true
        }
        return sp
    }

    /** MD5 hex de bytes; "" em caso de erro. Original: n.p() */
    fun md5Hex(bytes: ByteArray): String = try {
        val md = MessageDigest.getInstance("MD5")
        md.update(bytes)
        toHex(md.digest())
    } catch (th: Throwable) {
        UncaughtLogger.log(th)
        ""
    }

    /** MD5 hex da string (charset padrão). Usado para ofuscar chaves. Original: n.o() */
    fun md5Hex(text: String): String? = md5Hex(text.toByteArray())

    /** Original: n.s() — logger.a() (provavelmente info/trace no SLF4J). */
    fun putString(key: String, value: String): Boolean {
        if (BaseLibConfig.isDebug) {
            logger.info("sp_string_put[{}], size[{}]", key, value.length)
        }
        return configPrefs().edit().putString(key, value).commit()
    }

    /** Hora do servidor. Original: n.b() */
    fun now(): Long = ServerTime.serverNow()

    /** Original: n.g() */
    fun formatNow(type: Int): String = formatTime(type, now())

    /** Original: n.i() */
    fun getInt(key: String, dft: Int): Int = configPrefs().getInt(key, dft)

    /** Original: n.j() */
    fun getLong(key: String, dft: Long): Long = configPrefs().getLong(key, dft)

    /** Original: n.m() */
    fun getString(key: String, dft: String?): String {
        val value = configPrefs().getString(key, dft)!!
        if (BaseLibConfig.isDebug) {
            logger.info("sp_string_get[{}], size[{}]", key, value.length)
        }
        return value
    }

    /** Original: n.q() */
    fun putInt(key: String, value: Int): Boolean = configPrefs().edit().putInt(key, value).commit()

    /** Original: n.r() */
    fun putLong(key: String, value: Long): Boolean = configPrefs().edit().putLong(key, value).commit()
}
