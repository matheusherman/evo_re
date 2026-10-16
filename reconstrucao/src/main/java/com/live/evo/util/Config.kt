package com.live.evo.util

import com.live.evo.MyApplication
import com.live.evo.event.SavePlayHistoryEvent
import com.google.gson.reflect.TypeToken

/**
 * Configuração de login/UI (singleton com flags padrão). Contém a regex de e-mail
 * `^[A-Za-z\d]+([A-Za-z\d-_.][A-Za-z\d-_]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$`,
 * idioma padrão "en" e vários booleanos (nomes `a()..g()` abaixo).
 * Original: com/live/evo/util/e.java
 */
class LoginConfig private constructor() {
    val emailRegex = "^[A-Za-z\\d]+([A-Za-z\\d-_.][A-Za-z\\d-_]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$"
    private var flagA = true     // f7202f  (a())
    private var flagC = false    // f7205i  (c()) — "aviso adulto obrigatório" em AppUserManager.needAdultWarning
    private var flagD = false    // f7206j  (d())
    private var intE = 1         // f7211o  (e())
    private var flagF = false    // f7201e  (f())
    private var flagG = true     // f7203g  (g())
    private var defaultLanguage = "en"  // f7209m
    fun flagA() = flagA; fun flagC() = flagC; fun flagD() = flagD; fun intE() = intE; fun flagF() = flagF; fun flagG() = flagG
    companion object {
        private val instance = LoginConfig()
        /** Original: b() */ fun get() = instance
    }
}

/**
 * "Skin": recursos de abertura/UI configuráveis remotamente — chaves de propriedade remota
 * `key_load_video_end`, `key_load_ecomode`, `key_load_play_icon`, `key_load_favorite_img`,
 * `key_load_curtain`, `key_boot_media`, `loading_view_color`, `epg_current_progress_color`,
 * `playback_seekbar_progress_color`. Se não houver mp4 baixado usa `android.resource://<pkg>/R.raw.bootvideo`.
 * Original: com/live/evo/util/o0.java
 */
class SkinConfig private constructor() {
    private val context = MyApplication.get()
    private val gson = GsonFactory.gson()

    /** Info de operação (arquivo de skin baixado): só a URL/caminho (`url`) é usada. Original: i5/n.java (AppOperateInfo) */
    class AppOperateInfo { var values: String? = null; var checksum = ""; var url = ""; var suffix = ""; var type = 0 }

    private var videoEndPath: String? = null        // f7306c  key_load_video_end
    private var ecoModePath: String? = null         // f7307d  key_load_ecomode
    private var playIconPath: String? = null        // f7308e  key_load_play_icon
    private var favoriteImgPath: String? = null     // f7309f  key_load_favorite_img
    private var curtainPath: String? = null         // f7310g  key_load_curtain
    private var loadType = 0                        // f7311h  key_load_type
    private var bootMediaPath: String? = null       // f7312i  key_boot_media
    private var loadingColor: String? = null        // f7313j  loading_view_color
    private var epgProgressColor: String? = null    // f7314k  epg_current_progress_color
    private var seekProgressColor: String? = null   // f7315l  playback_seekbar_progress_color
    private var seekThumbColor: String? = null      // f7316m  playback_seekbar_thumb_color

    /** Assina a chave de propriedade (JSON AppOperateInfo) e repassa só a `url`. Original: r(String, w0.a) + h(...) */
    private fun watchFile(key: String, onPath: (String) -> Unit) {
        com.foxivid.baselib.util.Preferences.getString(key, { json ->
            val info = try { gson.fromJson(json, AppOperateInfo::class.java) } catch (_: Throwable) { null }
            if (info != null) onPath(info.url)
        }, "")
    }

    init {
        watchFile("key_load_video_end") { videoEndPath = it }
        watchFile("key_load_ecomode") { ecoModePath = it }
        watchFile("key_load_play_icon") { playIconPath = it }
        watchFile("key_load_favorite_img") { favoriteImgPath = it }
        watchFile("key_load_curtain") { curtainPath = it }
        watchFile("key_boot_media") { bootMediaPath = it }
        val prefs = com.foxivid.baselib.util.Preferences
        prefs.getString("loading_view_color", { loadingColor = it }, "")
        prefs.getString("epg_current_progress_color", { epgProgressColor = it }, "")
        prefs.getString("playback_seekbar_progress_color", { seekProgressColor = it }, "")
        prefs.getString("playback_seekbar_thumb_color", { seekThumbColor = it }, "")
        prefs.getString("key_load_type", { v ->
            val t = if (v.isEmpty()) 0 else v.toInt()
            loadType = if (bootMediaPath.isNullOrEmpty()) 0 else t   // só vale se há mídia de boot
        }, "")
    }

    /** Há mídia de abertura habilitada (`key_load_type` == 1 com mídia)? Original: z() */
    fun hasBootVideo(): Boolean = loadType == 1
    /** URI do vídeo de abertura: o mp4 baixado (se existe) ou o `R.raw.bootvideo` embutido. Original: x() */
    fun bootVideoUri(): String {
        val path = bootMediaPath
        if (!path.isNullOrEmpty()) {
            val f = java.io.File(path)
            if (f.exists() && f.name.endsWith(".mp4")) return path
        }
        return "android.resource://" + context.packageName + "/" + com.live.evo.R.raw.bootvideo
    }
    /** Cor(es) do loading, "#RRGGBB[,#RRGGBB]". Original: q() */ fun loadingViewColor(): String? = loadingColor
    /** Alias de [loadingViewColor] usado por LiveNewActivity. */ fun loadingColors(): String? = loadingColor
    /** Cor da barra de progresso "atual" da EPG. Original: m() */ fun epgCurrentProgressColor(): String? = epgProgressColor
    /** Caminho da imagem de favorito. Original: o() */ fun favoriteImagePath(): String? = favoriteImgPath
    /** Caminho do ícone de play. Original: s() */ fun playIconPath(): String? = playIconPath
    /** Cor do progresso da barra de playback. Original: t() */ fun seekbarProgressColor(): String? = seekProgressColor
    /** Cor do thumb da barra de playback. Original: u() */ fun seekbarThumbColor(): String? = seekThumbColor
    /** Imagem de standby/eco (baixada ou `stopplay`). Original: n() */
    fun ecoModeDrawable(): android.graphics.drawable.Drawable? = try {
        if (java.io.File(ecoModePath).exists()) android.graphics.drawable.Drawable.createFromPath(ecoModePath)
        else CommonUtils.drawable(com.live.evo.R.drawable.stopplay)
    } catch (_: Exception) { CommonUtils.drawable(com.live.evo.R.drawable.stopplay) }
    /** Cortina de abertura: `load_bg`. Original: v() */ fun bootCurtainDrawable(): android.graphics.drawable.Drawable? = CommonUtils.drawable(com.live.evo.R.drawable.load_bg)
    /** Fundo ao fim da abertura: `load_bg`. Original: w() */ fun bootEndDrawable(): android.graphics.drawable.Drawable? = CommonUtils.drawable(com.live.evo.R.drawable.load_bg)

    companion object {
        private var instance: SkinConfig? = null
        /** Original: p() / y() */ fun get(): SkinConfig = instance ?: synchronized(this) { instance ?: SkinConfig().also { instance = it } }
    }
}

/**
 * Armazém de propriedades remotas "app_properties_bean_key" (mapa grupo -> chave -> valor) carregado do
 * KvStore e serializado em JSON. Original: com/live/evo/util/b1.java
 */
object AppPropertiesStore {
    private val loaded = java.util.concurrent.atomic.AtomicBoolean(false)
    private var map: MutableMap<String, MutableMap<String, String>> = HashMap()
    private val type = object : TypeToken<Map<String, Map<String, String>>>() {}.type

    /** Lista as propriedades de um grupo como `AppProperty` (i5.a0: id, grupo, chave, valor). Original: c(String) */
    fun group(name: String): List<Map.Entry<String, String>> = map[name]?.entries?.toList() ?: emptyList()
    /** Lista com 0 ou 1 [AppProperty] (id=0, grupo, chave, valor). Original: d(String, String) */
    fun get(group: String, key: String): List<com.live.evo.model.AppProperty> =
        map[group]?.get(key)?.let { listOf(com.live.evo.model.AppProperty(0L, group, key, it)) } ?: emptyList()
    /** Original: e(String, String, String) */
    @Synchronized fun put(group: String, key: String, value: String) { map.getOrPut(group) { HashMap() }[key] = value }
}

/**
 * Sequência secreta de teclas numéricas ("5188") para ativar modo oculto. Cada dígito 0-9 mapeia para
 * KEYCODE_0..9 (7..16). Janela de 2000 ms entre teclas. `onKey` retorna sempre false nesta versão.
 * Original: com/live/evo/util/c.java (SecretKeySequence)
 */
class SecretKeySequence protected constructor(key: String?) : android.view.View.OnKeyListener, java.io.Closeable {
    private val codes: IntArray
    private val windowMs = 2000L
    private var lastTime = 0L
    private var index = 0

    init {
        require(!key.isNullOrEmpty()) { "Empty key" }
        codes = IntArray(key.length)
        key.forEachIndexed { i, ch ->
            val d = ch - '0'
            require(d in 0..9) { "Invalid key[$key], only number[0...9] is accepted" }
            codes[i] = KEYCODES[d]
        }
    }
    override fun onKey(v: android.view.View?, keyCode: Int, event: android.view.KeyEvent?): Boolean = false
    fun isActivated(): Boolean = activated
    override fun close() {}

    companion object {
        private val KEYCODES = intArrayOf(7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
        private var activated = false
        private var instance: SecretKeySequence? = null
        /** Original: a() */ fun get(): SecretKeySequence = instance ?: synchronized(this) { instance ?: SecretKeySequence("5188").also { instance = it } }
    }
}
