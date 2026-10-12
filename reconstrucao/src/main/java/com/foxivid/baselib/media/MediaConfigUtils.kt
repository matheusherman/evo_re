package com.foxivid.baselib.media

import com.foxivid.baselib.util.Preferences
import com.foxivid.baselib.streaming.engine.PlayType as EnginePlayType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import java.util.LinkedHashMap
import java.util.concurrent.atomic.AtomicInteger

/** Original: nf/c — evento "PIN adulto mudou de usuário" (postado em [MediaConfigUtils.initUserData]). */
class AdultPinUserChangedEvent

/**
 * Original: x1/f1/lb/media/d.java ("MediaConfigUtils.kt") (+ d$a..d$b)
 *
 * Preferências de reprodução da mídia (idioma de áudio/legenda, tamanho da legenda, aspecto de tela live/VOD),
 * PIN de conteúdo adulto e senha da coluna adulta (ambos por usuário), contagem de cliques por item de menu
 * e títulos do menu de configuração do player.
 *
 * Chaves de preferência: `MediaCfgVoDSourceAudioLang`, `MediaCfgVoDSubtitleFontSize` (padrão 20 sp),
 * `MediaCfgVoDSubtitleLang`, `MediaCfgVoDSubtitleSwitch` (padrão 1), `adult_pin` (legado, global),
 * `MediaCfgLivePlayerScreenKey`, `MediaCfgVoDPlayerScreenKey`; por usuário: `adult_pin<uid>` e
 * `adult_column_lock_password_key<uid>`.
 */
object MediaConfigUtils {
    private var sourceAudioLang = ""
    private var subtitleFontSizeInSP = 20
    private var subtitleLang = ""
    private var subtitleSwitch = 1
    private var adultPin = ""
    private var oldAdultPin = ""
    private var lastAdultPinUid = ""
    private var personalAdultPinKey = ""
    private var liveScreenAspectType = 0
    private var vodScreenAspectType = 0
    private var userClickCountMap: MutableMap<String, AtomicInteger> = LinkedHashMap()
    private var adultColumnPassword = ""
    private var personalAdultColumnPasswordKey = ""
    private val playCfgTitle = HashMap<String, String>()

    /**
     * Original: d.t(appContext) ("initData") — coleta (em IO) cada preferência uma vez e preenche os títulos do menu
     * (`MediaCfgNameResolution/Audio/Screen/Subtitle/Player` = strings full_screen_menu_*; recebidas por parâmetro).
     * A decompilação mostra `Preferences.get(key, default)` coletado em sequência: audioLang, fontSize,
     * subtitleLang (padrão = `HeartbeatManager.M0()`), subtitleSwitch, adult_pin (legado), live/vod aspecto.
     */
    fun initData(menuTitles: Map<String, String>, defaultSubtitleLang: String) {
        CoroutineScope(SupervisorJob() + Dispatchers.IO).launch {
            sourceAudioLang = Preferences.get("MediaCfgVoDSourceAudioLang", sourceAudioLang).first()
            subtitleFontSizeInSP = Preferences.get("MediaCfgVoDSubtitleFontSize", subtitleFontSizeInSP).first()
            subtitleLang = Preferences.get("MediaCfgVoDSubtitleLang", defaultSubtitleLang).first()
            subtitleSwitch = Preferences.get("MediaCfgVoDSubtitleSwitch", subtitleSwitch).first()
            oldAdultPin = Preferences.get("adult_pin", oldAdultPin).first()
            liveScreenAspectType = Preferences.get("MediaCfgLivePlayerScreenKey", liveScreenAspectType).first()
            vodScreenAspectType = Preferences.get("MediaCfgVoDPlayerScreenKey", vodScreenAspectType).first()
        }
        playCfgTitle.putAll(menuTitles)
    }

    /**
     * Original: d.u(uid) ("initUserData") — carrega o PIN adulto do usuário (`adult_pin<uid>`); se vazio e há PIN legado
     * (`adult_pin`), migra o legado para a chave do usuário. Carrega a senha da coluna adulta. Se o uid mudou
     * desde a última vez: `ChannelManager.disableAdultMode()` e posta [AdultPinUserChangedEvent].
     */
    suspend fun initUserData(uid: String) {
        personalAdultPinKey = "adult_pin$uid"
        val pin = Preferences.getString(personalAdultPinKey, "")
        if (pin.isEmpty() && oldAdultPin.isNotEmpty()) {
            Preferences.putString(personalAdultPinKey, oldAdultPin)
            Preferences.putString("adult_pin", "")
            oldAdultPin = ""
        } else {
            adultPin = pin
        }
        personalAdultColumnPasswordKey = "adult_column_lock_password_key$uid"
        adultColumnPassword = Preferences.getString(personalAdultColumnPasswordKey, "")
        if (lastAdultPinUid.isNotEmpty() && lastAdultPinUid != uid) {
            ChannelManager.disableAdultMode() // Original: a.e0()
            EventBus.getDefault().post(AdultPinUserChangedEvent())
        }
        lastAdultPinUid = uid
    }

    /** Original: d.p() — devolve e zera o mapa de contagem de cliques (usado pela telemetria). */
    @Synchronized
    fun takeClickCounts(): Map<String, AtomicInteger> { val m = userClickCountMap; userClickCountMap = LinkedHashMap(); return m }

    fun adultColumnPassword() = adultColumnPassword                 // n()
    fun adultPin() = adultPin                                       // o()
    fun hasAdultPin() = adultPin.isNotEmpty()                       // v()
    fun subtitleFontSize() = subtitleFontSizeInSP                   // r()
    fun subtitleLang() = subtitleLang                               // s()
    /** Original: d.q(type) — VOD usa o aspecto de VOD; os demais o de live. */
    fun aspectType(type: EnginePlayType) = if (type == EnginePlayType.VOD) vodScreenAspectType else liveScreenAspectType

    /** Original: d.w(password) */
    fun setAdultColumnPassword(password: String) { adultColumnPassword = password; Preferences.putString(personalAdultColumnPasswordKey, password) }
    /** Original: d.x(pin) */
    fun setAdultPin(pin: String) { adultPin = pin; Preferences.putString(personalAdultPinKey, pin) }
    /** Original: d.y(type, aspectType) — só em memória (não persiste). */
    fun setAspectType(type: EnginePlayType, aspectType: Int) { if (type == EnginePlayType.VOD) vodScreenAspectType = aspectType else liveScreenAspectType = aspectType }
    /** Original: d.z(fontSize) */
    fun setSubtitleFontSize(fontSize: Int) { subtitleFontSizeInSP = fontSize; Preferences.putInt("MediaCfgVoDSubtitleFontSize", fontSize) }
}
