package com.foxivid.baselib.util

import android.app.Activity
import android.app.Application
import android.content.ComponentCallbacks
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import androidx.core.view.ViewCompat
import com.foxivid.baselib.config.BaseLibConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Adaptação de densidade de tela (técnica "今日头条"): força `density = 1.6875` (≈ 270 dpi)
 * na Application e na Activity, para o layout ter a mesma escala em qualquer TV.
 * Só atua se `BaseLibConfig.isSetCustomDensity`.
 * Original: x1/f1/lb/util/a0.java
 */
object DensityAdapter {
    private val logger: Logger = LoggerFactory.getLogger(DensityAdapter::class.java)

    private var sNonCompatDensity = 0f
    private var sNonCompatScaledDensity = 0f
    private var sNonCompatDensityDpi = 0
    private var heightPixels = 0
    private var widthPixels = 0
    private var density = 0f
    private var densityDpi = 0

    /** dp → px com arredondamento (+0.5). Original: `a0.b(Context, float)`. */
    fun dp2px(context: Context, dp: Float): Float = getDensity(context) * dp + 0.5f

    /**
     * Altura da barra inferior (insets do sistema); se 0, cai para `status_bar_height`.
     * Original: `a0.c(Activity)`.
     */
    fun getNavBarHeight(activity: Activity): Int {
        val bottom = if (Build.VERSION.SDK_INT >= 30) {
            @Suppress("DEPRECATION")
            ViewCompat.getRootWindowInsets(activity.window.decorView)?.systemWindowInsetBottom ?: 0
        } else {
            @Suppress("DEPRECATION")
            activity.window.decorView.rootWindowInsets?.systemWindowInsetBottom ?: 0
        }
        if (bottom > 0) return bottom
        return try {
            val id = activity.resources.getIdentifier("status_bar_height", "dimen", "android")
            if (id > 0) activity.resources.getDimensionPixelSize(id) else 0
        } catch (t: Throwable) {
            logger.error("get nav bar height failure", t)
            0
        }
    }

    /** Original: `a0.d(Context)` → [ScreenUtils.getDensity]. */
    fun getDensity(context: Context): Float = ScreenUtils.getDensity(context)

    /** Original: `a0.e(Context)` — resolve a activity do contexto e aplica [setCustomDensity]. */
    fun setCustomDensity(context: Context?) {
        if (!BaseLibConfig.isSetCustomDensity) return
        val activity = AppMonitor.findActivity(context)
        if (activity == null) {
            logger.error("activity is null in setCustomDensity()", Exception())
        } else {
            setCustomDensity(activity)
        }
    }

    /**
     * Aplica densidade fixa 1.6875. `scaledDensity` é escalado pela razão altura/largura
     * relativa a 16:9 (0.5625) e pelo fontScale original. Original: `a0.f(Activity)`.
     */
    fun setCustomDensity(activity: Activity) {
        if (!BaseLibConfig.isSetCustomDensity) return
        val application: Application = activity.application
        val appDm = application.resources.displayMetrics
        if (sNonCompatDensity == 0f) {
            sNonCompatDensity = appDm.density
            sNonCompatScaledDensity = appDm.scaledDensity
            sNonCompatDensityDpi = appDm.densityDpi
            application.registerComponentCallbacks(object : ComponentCallbacks {
                override fun onConfigurationChanged(newConfig: Configuration) {
                    if (newConfig.fontScale > 0f) {
                        sNonCompatScaledDensity = application.resources.displayMetrics.scaledDensity
                    }
                }

                override fun onLowMemory() {}
            })
        }
        heightPixels = appDm.heightPixels
        widthPixels = appDm.heightPixels // fiel ao original (usa heightPixels)
        val ratio = appDm.heightPixels * 1.0f / appDm.widthPixels
        val ratioTo169 = ratio / 0.5625f
        val targetScaledDensity = ratioTo169 * 1.6875f * (sNonCompatScaledDensity / sNonCompatDensity)
        val targetDpi = sNonCompatDensityDpi
        val actDm = activity.resources.displayMetrics
        if (BaseLibConfig.isDebug) {
            logger.debug(
                "{}\nsetCustomDensity Activity[{}]\nScreen:\n    Width x Height[{} x {}], Ratio[{} x {} -> {}]\nApp:\n    Density[{} -> {}], ScaleDensity[{} -> {}], DensityDpi[{} -> {}]\nActivity:\n    Density[{} -> {}], ScaleDensity[{} -> {}], DensityDpi[{} -> {}]",
                StackTraceUtils.caller(), activity.javaClass.simpleName, appDm.widthPixels, appDm.heightPixels,
                ratio, ratioTo169, 0.5625f, appDm.density, 1.6875f, appDm.scaledDensity, targetScaledDensity,
                appDm.densityDpi, targetDpi, actDm.density, 1.6875f, actDm.scaledDensity, targetScaledDensity,
                actDm.densityDpi, targetDpi,
            )
        }
        appDm.density = 1.6875f
        appDm.scaledDensity = targetScaledDensity
        appDm.densityDpi = targetDpi
        actDm.density = 1.6875f
        actDm.scaledDensity = targetScaledDensity
        actDm.densityDpi = targetDpi
        density = 1.6875f
        densityDpi = targetDpi
    }
}
