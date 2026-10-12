package com.live.evo

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.os.Handler
import android.os.HandlerThread
import androidx.appcompat.app.AppCompatActivity
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.config.InteractionUtils
import com.foxivid.baselib.user.AccountInfo
import com.foxivid.baselib.util.UserActionTracker
import com.live.evo.dialog.AdultKeyNewDialogFragment
import com.live.evo.event.ServiceExpiredEvent
import com.live.evo.model.ChannelBean
import com.live.evo.util.CommonUtils
import com.live.evo.util.DateUtils
import com.live.evo.util.DebugPropsParser
import com.live.evo.util.EpgRepository
import com.live.evo.util.LogInit
import com.live.evo.util.LoginConfig
import com.live.evo.util.QrBitmapHelper
import com.live.evo.util.SecretKeySequence
import com.live.evo.util.ServerClock
import com.live.evo.util.WorkHandler
import org.greenrobot.eventbus.EventBus
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit

/**
 * Estado do usuário no nível do app (TAG/HandlerThread "UserManager"; não confundir com
 * com.foxivid.baselib.user.UserManager do SDK): senha adulto/lock, autorização adulto temporária,
 * configuração de PiP, agendamento do evento de expiração e propriedades de debug.
 *
 * Original: com/live/evo/l.java
 */
class AppUserManager private constructor() {

    private val logger = LoggerFactory.getLogger(AppUserManager::class.java)
    private var adultPwdDurMillis = -1           // b
    private var adultKey: String? = null          // c
    private var lockKey: String? = null           // d
    private var isActivated = false               // e
    private var isServiceTokenValid = true        // f
    private var isAdultAuth = false               // i
    private var adultAuthTime = 0L                // j
    private var seed = 0L                         // k
    private var group: String? = null             // l
    private var debugProps: Map<String, String>? = null  // m
    private var userPlayStatus = 0                // n
    private var accountInfo: AccountInfo? = null  // o
    private var playGraceUsed = false             // s
    private var isForceLogout = false             // t
    private var isLogout = false                  // u
    private var mSessionId = ""                   // v
    private var lastChannelId: String? = null     // y
    private var showPipFlag = 0                   // J
    private var pipPosition = 0                   // L
    private var pipSize = 0                       // M
    private var pipInfo = "0,0,0"                 // I
    private var handler: Handler? = null          // S
    private val qrHelper = QrBitmapHelper(this)   // r

    /** Original: runnable T → [scheduleExpiredCheck] */
    private val scheduleRunnable = Runnable { scheduleExpiredCheck() }
    /** Original: runnable U → [rescheduleExpiredGrace] */
    private val graceRunnable = Runnable { rescheduleExpiredGrace() }
    /** Original: runnable V — posta [ServiceExpiredEvent] (b5.i) como sticky. */
    private val expiredRunnable = Runnable { EventBus.getDefault().postSticky(ServiceExpiredEvent()) }

    /**
     * Lê propriedade de debug ([DebugPropsParser]) convertendo para o tipo do valor padrão.
     * Original: k(String, T, T) e wrappers g()/h()/i()/j()
     */
    @Suppress("UNCHECKED_CAST")
    private fun <T : Any> prop(key: String, sample: T, def: T?): T? {
        if (def == null) return null
        return try {
            if (debugProps == null) debugProps = DebugPropsParser.parse()
            val raw = debugProps?.get(key) ?: return def
            val v: Any? = try {
                when (sample) {
                    is String -> raw
                    is Int -> raw.toInt()
                    is Boolean -> raw.toBoolean()
                    is Double -> raw.toDouble()
                    is Short -> raw.toShort()
                    is Byte -> raw.toByte()
                    is Float -> raw.toFloat()
                    is Long -> raw.toLong()
                    is Char -> raw[0]
                    else -> null
                }
            } catch (_: Throwable) { null }
            (v ?: def) as T
        } catch (_: Throwable) { def }
    }
    fun getInt(key: String, def: Int): Int = prop(key, 0, def)!!
    fun getLong(key: String, def: Long): Long = prop(key, 0L, def)!!
    fun getString(key: String, def: String): String = prop(key, "", def)!!
    fun getBoolean(key: String, def: Boolean): Boolean = prop(key, true, def)!!

    /** Persiste "pip_info" = "J,L,M". Original: L() */
    private fun savePipInfo() {
        pipInfo = "$showPipFlag,$pipPosition,$pipSize"
        LogInit.put("pip_info", pipInfo)
    }

    /** Original: A() */
    fun isUserIdle(): Boolean = UserActionTracker.isIdle()

    /**
     * Autorização adulto válida? Vale por `adult_pwd_dur_min` (padrão 60 min). Se o relógio pulou mais de 1 ano,
     * reinicia a contagem. Original: D()
     */
    fun isAdultUnlocked(): Boolean {
        if (adultAuthTime == 0L) return false
        if (adultPwdDurMillis < 0) {
            val d = getInt("adult_pwd_dur_min", 60) * 60000
            adultPwdDurMillis = if (d < 0) 3_600_000 else d
        }
        val diff = Math.abs(System.currentTimeMillis() - adultAuthTime)
        if (diff < adultPwdDurMillis) return isAdultAuth
        if (diff <= 31_536_000_000L) return false
        adultAuthTime = System.currentTimeMillis()
        return isAdultAuth
    }

    /** Original: F() → SDK.k0() */
    fun sdkFlagK0(): Boolean = InteractionUtils.flagK0()
    /** Original: G() */
    fun isPipEnabled(): Boolean = showPipFlag > 0
    /** Original: H() */
    fun isPipPosition1(): Boolean = pipPosition == 1
    /** Original: J() — sem plano válido. Usado em LiveNewActivity.changeChannel. */
    fun blockWhenExpired(): Boolean = !InteractionUtils.hasValidPlan()

    /**
     * Agenda o evento de expiração: se faltam >= `expired_schedule_threshold` (6 h) reagenda a verificação,
     * senão posta [expiredRunnable] no tempo restante. Original: M()
     */
    fun scheduleExpiredCheck() {
        if (handler == null) handler = Handler(HandlerThread("UserManager").apply { start() }.looper)
        handler?.removeCallbacks(expiredRunnable)
        handler?.removeCallbacks(scheduleRunnable)
        val now = ServerClock.get().now()
        val threshold = getLong("expired_schedule_threshold", TimeUnit.HOURS.toMillis(6L))
        var remaining = expiryTime() - now
        if (remaining >= threshold) { handler?.postDelayed(scheduleRunnable, threshold); return }
        if (remaining < 0) remaining = 0
        handler?.postDelayed(expiredRunnable, remaining)
    }

    /**
     * Variante com [WorkHandler]: dentro de `expired_schedule_threshold_int` (24 h) posta o evento após
     * max(restante, `expired_play_grace_time` = 15 min). Original: c()
     */
    fun rescheduleExpiredGrace() {
        val remaining = expiryTime() - ServerClock.get().now()
        val threshold = getLong("expired_schedule_threshold_int", TimeUnit.HOURS.toMillis(24L))
        if (remaining <= threshold) {
            WorkHandler.get().remove(expiredRunnable)
            WorkHandler.get().postDelayed(expiredRunnable, maxOf(remaining, getLong("expired_play_grace_time", TimeUnit.MINUTES.toMillis(15L))))
        } else {
            WorkHandler.get().remove(graceRunnable)
            WorkHandler.get().postDelayed(graceRunnable, threshold)
        }
    }

    /** Registra autorização adulto e informa o SDK (H0/I0). Original: N(boolean) */
    fun setAdultAuth(auth: Boolean) {
        isAdultAuth = auth
        adultAuthTime = System.currentTimeMillis()
        if (auth) InteractionUtils.setAdultUnlocked() else InteractionUtils.resetAdultUnlock()
    }

    /** Original: O(String) → SDK.G0 */
    fun setAdultKey(key: String) { adultKey = key; InteractionUtils.setAdultKey(key) }
    /** Original: P(String) */
    fun setLastChannelId(id: String) { lastChannelId = id }
    /** Original: Q(String) */
    fun setLockKey(key: String) { lockKey = key }
    /** Original: R(boolean) */
    fun setPipEnabled(on: Boolean) { showPipFlag = if (on) 1 else 0; savePipInfo() }
    /** Original: S(int) */
    fun setUserPlayStatus(s: Int) { userPlayStatus = s }

    /** Abre o diálogo de senha adulto (tag "AdultKeyNewDialogFragment_TAG"). Original: T(Activity, a.c, ChannelBean) */
    fun showAdultKeyDialog(activity: Activity, cb: AdultKeyNewDialogFragment.Callback, channel: ChannelBean?) {
        val fm = (activity as AppCompatActivity).supportFragmentManager
        val tx = fm.beginTransaction()
        fm.findFragmentByTag(ADULT_TAG)?.let { tx.hide(it); tx.remove(it) }
        tx.addToBackStack(null)
        tx.commitAllowingStateLoss()
        AdultKeyNewDialogFragment.newInstance(cb, channel).show(fm.beginTransaction(), ADULT_TAG)
    }

    /** Fecha o diálogo de senha adulto se existir. Original: b(Activity) */
    fun attach(activity: Activity) {
        val fm = (activity as AppCompatActivity).supportFragmentManager
        val f = fm.findFragmentByTag(ADULT_TAG) ?: return
        try {
            fm.beginTransaction().hide(f).commitAllowingStateLoss()
            fm.beginTransaction().remove(f).commitAllowingStateLoss()
        } catch (_: Throwable) { }
    }

    /** Original: d() → renew code */ fun renewCode(): String = InteractionUtils.renewCode()
    /** Original: l() → SDK.I() */ fun expiryTime(): Long = InteractionUtils.expiryTimeMillis()
    /** Original: m() → validade formatada "ddMMyyyy" */ fun expiryText(): String = DateUtils.format(InteractionUtils.expiryTimeMillis(), CommonUtils.string(R.string.ddMMyyyy))
    /** Original: o() */ fun lockKey(): String? = lockKey
    /** Original: q() → EpgRepository.D() (modo de boas-vindas) */ fun welcomeMode(): Int = EpgRepository.welcomeMode()
    /** Original: s() */ fun pipSize(): Int = pipSize
    /** Original: t(String) — QR code em bitmap. */ fun qrBitmap(text: String): Bitmap? = qrHelper.create(text)
    /** Original: v() */ fun isDebug(): Boolean = BaseLibConfig.isDebug()
    /** Original: w() — session id se "show_sessionid" (padrão true). */ fun sessionIdForDisplay(): String = if (getBoolean("show_sessionid", true)) mSessionId else ""
    /** Original: y() → SDK.q0() */ fun sdkFlagQ0(): Boolean = InteractionUtils.flagQ0()
    /** Original: z() */ fun hasLockKey(): Boolean = !lockKey.isNullOrEmpty()
    /** Original: C() — sequência secreta "5188" ativa. */ fun isSecretModeOn(): Boolean = SecretKeySequence.get().isActivated()
    /** Original: E() — aviso adulto obrigatório (LoginConfig). */ fun needAdultWarning(): Boolean = LoginConfig.get().flagC()
    /** Original: K(boolean) — vazio. */ fun setLoggedIn(@Suppress("UNUSED_PARAMETER") v: Boolean) {}

    override fun toString(): String = "UserManager{adultPwdDurMillis=$adultPwdDurMillis, adultKey='$adultKey', lockKey='$lockKey', " +
        "isActivated=$isActivated, isServiceTokenValid=$isServiceTokenValid, isAdultAuth=$isAdultAuth, adultAuthTime=$adultAuthTime, " +
        "seed=$seed, group='$group', userPlayStatus=$userPlayStatus, accountInfo=$accountInfo, playGraceUsed=$playGraceUsed, " +
        "isForceLogout=$isForceLogout, isLogout=$isLogout, mSessionId='$mSessionId'}"

    companion object {
        private const val ADULT_TAG = "AdultKeyNewDialogFragment_TAG"
        @Volatile private var instance: AppUserManager? = null
        /** Original: B(Context) */
        fun init(@Suppress("UNUSED_PARAMETER") context: Context) { instance = AppUserManager() }
        /** Original: n() */
        fun get(): AppUserManager = instance ?: synchronized(this) { instance ?: AppUserManager().also { instance = it } }
    }
}
