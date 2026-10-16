package com.foxivid.baselib.util

import android.view.KeyEvent
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.event.EcoModeEvent
import com.foxivid.baselib.metric.MetricReporter
import com.foxivid.baselib.user.UserManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.Timer
import java.util.TimerTask

/**
 * Modo econômico (protetor de tela/"eco mode") por inatividade do controle remoto.
 * Um Timer verifica a cada 30 s; se não houve tecla há mais que `UserManager.getEchoModeTime()` (user/f.Y()) ms, posta
 * `nf.f()` (entrar no eco mode) e registra a métrica "enterEcoMode". Qualquer tecla sai do modo
 * (`nf.f(false)`). Também contabiliza teclas/toques persistidos para decidir se o aparelho é
 * STB (só controle) ou touch.
 * Original: x1/f1/lb/util/d0.java (nome Kotlin original `EcoModeHelper`) + d0$a (TimerTask) + d0$b (load).
 */
object EcoModeHelper {
    private val logger: Logger = LoggerFactory.getLogger(EcoModeHelper::class.java)

    private var timer: Timer? = null
    private var lastKeyPress: Long = ServerTime.elapsedNow()
    private var lastEvent: EcoModeEvent? = null

    /** Imagens do eco mode (definidas pelo app; em debug, 3 imagens de teste do jianshu.io). */
    var ecoModePics: List<String> = emptyList()
        private set

    private var oldKeyPressCnt = 0
    private var oldTouchCnt = 0
    private var keyPressCnt = 0

    /** Nunca incrementado nesta classe (fiel ao original). */
    private var touchCnt = 0
    private var isTipStb = 0

    /** Guardado mas não usado nesta classe. */
    private var onTip: ((Boolean) -> Unit)? = null
    private val saveFlag = HashSet<String>()
    private var isInEcoMode = false

    /** Original: d0$a. */
    private class IdleCheckTask : TimerTask() {
        override fun run() {
            if (lastEvent == null && ServerTime.elapsedNow() - lastKeyPress > UserManager.getEchoModeTime()) { // user/f.Y() — timeout do eco mode
                val e = EcoModeEvent()
                EventBus.getDefault().post(e)
                lastEvent = e
                MetricReporter.reportClickCount("enterEcoMode") // Original: uf/c.j(String)
            }
        }
    }

    /** Marca como em eco mode. Original: `d0.h()`. */
    fun enterEcoMode() {
        isInEcoMode = true
    }

    /** Inicia o monitor de teclas (Timer "Key monitor", 30 s/30 s). Original: `d0.i(Function1)`. */
    fun start(onTip: (Boolean) -> Unit) {
        timer?.let { it.cancel(); it.purge() }
        this.onTip = onTip
        timer = Timer("Key monitor").also { it.schedule(IdleCheckTask(), 30_000L, 30_000L) }
        if (BaseLibConfig.isDebug) {
            ecoModePics = listOf(
                "https://upload-images.jianshu.io/upload_images/5809200-7fe8c323e533f656.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240",
                "https://upload-images.jianshu.io/upload_images/5809200-736bc3917fe92142.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240",
                "https://upload-images.jianshu.io/upload_images/5809200-a99419bb94924e6d.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240",
            )
        }
        logger.info("key service onCreate")
    }

    /** Original: `d0.j()`. */
    fun isInEcoMode(): Boolean = isInEcoMode

    /** Usa só controle remoto (teclas e nenhum toque). Original: `d0.k()`. */
    fun isKeyOnlyDevice(): Boolean = (keyPressCnt > 0 || oldKeyPressCnt > 0) && oldTouchCnt == 0 && touchCnt == 0

    /** Já houve toque. Original: `d0.l()`. */
    fun hasTouch(): Boolean = oldTouchCnt > 0 || touchCnt > 0

    /**
     * Carrega os contadores persistidos (`key_press_cnt_key`, `touch_cnt_key`, `is_tip_stb_key`).
     * Original: `d0.m()` (corrotina `EcoModeHelper$load$1`, parcialmente mal descompilada; as três
     * coletas sequenciais são inequívocas).
     */
    fun load() {
        CoroutineScope(Dispatchers.IO).launch {
            Preferences.get("key_press_cnt_key", 0)
                .catch { logger.error("get [key_press_cnt_key] failure", it) }
                .collect { oldKeyPressCnt = it }
            Preferences.get("touch_cnt_key", 0)
                .catch { logger.error("get [touch_cnt_key] failure", it) }
                .collect { oldTouchCnt = it }
            Preferences.get("is_tip_stb_key", 0)
                .catch { logger.error("get [is_tip_stb_key] failure", it) }
                .collect { isTipStb = it }
        }
    }

    /** Registra atividade; se estava em eco mode, sai e posta `nf.f(false)`. Original: `d0.n()`. */
    fun onUserActivity(): Boolean {
        lastKeyPress = ServerTime.elapsedNow()
        if (!isInEcoMode && lastEvent == null) return false
        logger.debug("eco-exit onclick engine")
        isInEcoMode = false
        lastEvent = null
        EventBus.getDefault().post(EcoModeEvent(false))
        return true
    }

    /** Para o Timer. Original: `d0.o()`. */
    fun stop() {
        timer?.let { timer = null; it.cancel() }
    }

    /** Conta tecla, salva e trata saída do eco mode. Original: `d0.p(KeyEvent)`. */
    fun onKeyEvent(keyEvent: KeyEvent?): Boolean {
        if (BaseLibConfig.isDebug) {
            logger.debug("key service onKeyEvent, keyCode[{}], action[{}]", keyEvent?.keyCode, keyEvent?.action)
        }
        keyPressCnt++
        save()
        return onUserActivity()
    }

    /**
     * Persiste contadores. Com chave específica, contadores só são gravados uma vez por sessão
     * (saveFlag) e se cresceram. Nota de fidelidade: com `key == null` (o uso de [onKeyEvent]) grava
     * os três a cada tecla. Original: `d0.q(String)`.
     */
    fun save(key: String? = null) {
        when (key) {
            "is_tip_stb_key" -> { Preferences.putInt("is_tip_stb_key", isTipStb); return }
            "touch_cnt_key" -> {
                if (touchCnt <= oldTouchCnt || saveFlag.contains(key)) return
                saveFlag.add(key); Preferences.putInt("touch_cnt_key", touchCnt); return
            }
            "key_press_cnt_key" -> {
                if (keyPressCnt <= oldKeyPressCnt || saveFlag.contains(key)) return
                saveFlag.add(key); Preferences.putInt("key_press_cnt_key", keyPressCnt); return
            }
        }
        Preferences.putInt("key_press_cnt_key", keyPressCnt)
        Preferences.putInt("touch_cnt_key", touchCnt)
        Preferences.putInt("is_tip_stb_key", isTipStb)
    }

    /** Original: `d0.s(List)`. */
    fun setEcoModePics(list: List<String>) {
        ecoModePics = list
    }
}
