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
    fun hasBootVideo(): Boolean = TODO("ver util/o0.z(): existe mp4 em diretório de skin")
    fun bootVideoUri(): String = "android.resource://" + context.packageName + "/" + com.live.evo.R.raw.bootvideo
    companion object {
        private var instance: SkinConfig? = null
        /** Original: p() */ fun get(): SkinConfig = instance ?: SkinConfig().also { instance = it }
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
