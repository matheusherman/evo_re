package com.foxivid.baselib.util

import android.os.Build
import android.os.Bundle
import com.foxivid.baselib.network.HeaderInterceptor
import com.foxivid.baselib.user.UserManager
import com.google.firebase.analytics.FirebaseAnalytics

/**
 * Eventos customizados do Firebase Analytics.
 * Original: x1/f1/lb/util/j0.java (+ j0$a provider, lambdas h0/i0).
 */
object FirebaseEvents {

    /** Fornece a instância do FirebaseAnalytics (injetada pelo app). Original: j0$a. */
    fun interface FirebaseAnalyticsProvider {
        fun get(): FirebaseAnalytics
    }

    /**
     * Evento `user_add_plan` quando a data de expiração da assinatura muda (comparada com
     * a preferência `user_last_expire_ts.<accountId>`). Ignorado para convidados/não logados
     * (`UserManager.O0()`).
     * Original: `j0.c()` + `j0.d(...)`.
     */
    fun reportPlanChange() {
        val fa = AppMonitor.firebaseAnalytics() ?: return
        if (UserManager.O0()) return // TODO: nome real (original user/f.O0(): convidado/sem sessão)
        val expireTs = UserManager.m0() // TODO: nome real (original user/f.m0(): expiração da assinatura)
        val key = "user_last_expire_ts." + HeaderInterceptor.accountId()
        Preferences.getLong(key, { last -> onLastExpire(expireTs, fa, key, last) }, 0L)
    }

    /**
     * Original: `j0.d(long, FirebaseAnalytics, String, long)`.
     * Faixas "1w".."2y+" enviadas em `plan`. Nota de fidelidade: as faixas comparam o timestamp
     * absoluto `expireTs` (e não a diferença para agora) com 13/20/40/... dias, então na prática
     * o resultado é sempre "2y+" — bug do original preservado.
     */
    private fun onLastExpire(expireTs: Long, fa: FirebaseAnalytics, key: String, last: Long) {
        if (last == expireTs) return
        if (expireTs - ServerTime.now() > 604_800_000L) { // > 7 dias de validade restante
            val d = java.util.concurrent.TimeUnit.DAYS
            val plan = when {
                expireTs < d.toMillis(13) -> "1w"
                expireTs < d.toMillis(20) -> "2w"
                expireTs < d.toMillis(40) -> "1m"
                expireTs < d.toMillis(100) -> "3m"
                expireTs < d.toMillis(200) -> "6m"
                expireTs < d.toMillis(400) -> "1y"
                expireTs < d.toMillis(800) -> "2y"
                else -> "2y+"
            }
            val b = Bundle()
            b.putString("plan", plan)
            b.putString("app_type", AppAttrUtils.appType())
            b.putString("channel", AppAttrUtils.distributionChannel()) // jadx exibiu a constante como MessageOriginChannel.MESSAGE_ORIGIN_TYPE
            fa.logEvent("user_add_plan", b)
        }
        Preferences.putLong(key, expireTs)
    }

    /**
     * Evento `user_version` quando o versionName difere do salvo em `user_version_name.<accountId>`.
     * Nota: o original não grava a nova versão aqui.
     * Original: `j0.e()` + `j0.f(...)`.
     */
    fun reportVersion() {
        val fa = AppMonitor.firebaseAnalytics() ?: return
        val versionName = AppAttrUtils.appVersionName()
        Preferences.getString("user_version_name." + HeaderInterceptor.accountId(), { saved ->
            if (saved == versionName) return@getString
            val b = Bundle()
            b.putString("ver_name", AppAttrUtils.appVersionName())
            b.putString("sdk_int", Build.VERSION.SDK_INT.toString())
            b.putString("ver_code", AppAttrUtils.appVersion().toString())
            b.putString("app_type", AppAttrUtils.appType())
            b.putString("channel", AppAttrUtils.distributionChannel())
            fa.logEvent("user_version", b)
        }, "")
    }
}
