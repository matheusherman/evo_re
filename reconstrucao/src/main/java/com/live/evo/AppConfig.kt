package com.live.evo

import android.os.Environment
import java.util.concurrent.TimeUnit

/**
 * Constantes globais do app.
 *
 * Original: com/live/evo/a.java (+ a$a)
 */
object AppConstants {
    @JvmField var flagA = true                                   // a
    @JvmField val MODEL: String = android.os.Build.MODEL         // b
    @JvmField var mapC: MutableMap<String, String> = HashMap()   // c
    @JvmField var mapD: MutableMap<String, String> = HashMap()   // d
    @JvmField var flagE = false; @JvmField var intF = 0; @JvmField var flagG = false; @JvmField var flagH = false
    val H4: Long = TimeUnit.HOURS.toMillis(4L)                   // i
    val HALF_HOUR: Long = TimeUnit.HOURS.toMillis(1L) / 2        // j
    val MIN10: Long = TimeUnit.MINUTES.toMillis(10L)             // k
    val H24_L: Long = TimeUnit.HOURS.toMillis(24L)               // l, m, n, o (todos 24 h)
    val H72: Long = TimeUnit.HOURS.toMillis(72L)                 // p
    val MIN5: Long = TimeUnit.MINUTES.toMillis(5L)               // q
    @JvmField var launcherIcon = R.mipmap.ic_launcher            // r
    @JvmField var appNameRes = R.string.freetrial_app_name       // s (trocado pelo modo free-trial)
    val H12: Long = TimeUnit.HOURS.toMillis(12L)                 // t
    val H24_U: Long = TimeUnit.HOURS.toMillis(24L)               // u
    @JvmField var configLists = ConfigLists()                    // v
    /** "/data" + /data + "/com.live.evo/". Original: w */
    val DATA_DIR: String = "/data" + Environment.getDataDirectory().absolutePath + "/com.live.evo/"

    /** 17 listas de strings sem uso identificado. Original: a$a */
    class ConfigLists { val lists: List<MutableList<String>> = List(17) { ArrayList() } }
}

/**
 * Feature flags do produto. O mapa remoto (`f6970a`) nunca é atribuído nesta versão, portanto valem os padrões:
 * PIP=false, FAV=true, CHANNEL_LOCK=false, SUBSCRIBE=true, SEARCH=true, EPG=true, FEEDBACK=true, INFO=true,
 * HISTORY=true, NOTIFICATION=true, SUBJECT=false, KIDSMODE=true, TOPX=true, VOD=false.
 *
 * Original: com/live/evo/h.java
 */
class ProductFeatureManager private constructor() {
    enum class ProductFeature(val id: String) {
        PRODUCT_FEATURE_SEARCH("1"), PRODUCT_FEATURE_FAV("2"), PRODUCT_FEATURE_SUBSCRIBE("3"), PRODUCT_FEATURE_INFO("4"),
        PRODUCT_FEATURE_FEEDBACK("5"), PRODUCT_FEATURE_CHANNEL_LOCK("6"), PRODUCT_FEATURE_EPG_FEATURE("7"), PRODUCT_FEATURE_PIP("8"),
        PRODUCT_FEATURE_HISTORY("9"), PRODUCT_FEATURE_NOTIFICATION("10"), PRODUCT_FEATURE_SUBJECT("11"), PRODUCT_FEATURE_KIDSMODE("12"),
        PRODUCT_FEATURE_VOD("13"), PRODUCT_FEATURE_TOPX("15")
    }

    private var remote: Map<String, Boolean>? = null
    private fun flag(f: ProductFeature, def: Boolean) = remote?.takeIf { it.isNotEmpty() }?.get(f.id) ?: def

    val pip = flag(ProductFeature.PRODUCT_FEATURE_PIP, false)
    val fav = flag(ProductFeature.PRODUCT_FEATURE_FAV, true)
    val channelLock = flag(ProductFeature.PRODUCT_FEATURE_CHANNEL_LOCK, false)
    val subscribe = flag(ProductFeature.PRODUCT_FEATURE_SUBSCRIBE, true)
    val search = flag(ProductFeature.PRODUCT_FEATURE_SEARCH, true)
    private val epg = flag(ProductFeature.PRODUCT_FEATURE_EPG_FEATURE, true)
    val feedback = flag(ProductFeature.PRODUCT_FEATURE_FEEDBACK, true)
    val info = flag(ProductFeature.PRODUCT_FEATURE_INFO, true)
    val history = flag(ProductFeature.PRODUCT_FEATURE_HISTORY, true)
    val notification = flag(ProductFeature.PRODUCT_FEATURE_NOTIFICATION, true)
    val subject = flag(ProductFeature.PRODUCT_FEATURE_SUBJECT, false)
    val kidsMode = flag(ProductFeature.PRODUCT_FEATURE_KIDSMODE, true)
    val topX = flag(ProductFeature.PRODUCT_FEATURE_TOPX, true)
    val vod = flag(ProductFeature.PRODUCT_FEATURE_VOD, false)

    /** Único getter público. Original: d() */
    fun epgEnabled(): Boolean = epg

    companion object {
        @Volatile private var instance: ProductFeatureManager? = null
        /** Original: b() */
        fun get(): ProductFeatureManager = instance ?: synchronized(this) { instance ?: ProductFeatureManager().also { instance = it } }
    }
}

/**
 * Toggles de UI (valores fixos; `q()` de recarga é vazio).
 * Original: com/live/evo/k.java — getters a()..p() mapeados abaixo.
 */
class UiFunctionConfig private constructor() {
    private val f7001a = true; private val f7002b = true; private val f7003c = true; private val f7004d = true
    private val f7005e = true; private val f7006f = true; private val f7007g = false; private val f7008h = true
    private val f7009i = false; private val f7010j = false; private val f7011k = false
    private val f7012l = true; private val f7013m = true
    private val maxSize = 200; private val f7015o = 30; private val favoriteGroup = 1; private val f7017q = "1"

    /** a() — índice da categoria "favoritos". */ fun favoriteGroupIndex() = favoriteGroup
    /** d() */ fun favoriteEnabled() = f7004d
    /** e() */ fun e() = f7009i
    /** f() */ fun f() = f7003c
    /** g() */ fun g() = f7006f
    /** h() */ fun h() = f7008h
    /** i() */ fun i() = f7011k
    /** j() */ fun j() = f7001a
    /** k() */ fun k() = f7007g
    /** l() — bloquear MENU em canal adulto. */ fun blockMenuOnAdult() = f7010j
    /** m() — tecla SEARCH habilitada. */ fun searchEnabled() = f7002b
    /** n() — agendamentos habilitados. */ fun subscribeEnabled() = f7005e
    /** o() */ fun o() = f7012l
    /** p() */ fun p() = f7013m
    /** q() — vazio no original. */ fun reload() {}

    companion object {
        private var instance: UiFunctionConfig? = null
        /** Original: b()/c() */
        fun get(): UiFunctionConfig = instance ?: synchronized(this) { UiFunctionConfig().also { instance = it } }
    }
}
