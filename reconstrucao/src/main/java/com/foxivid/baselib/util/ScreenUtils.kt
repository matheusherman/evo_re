package com.foxivid.baselib.util

import android.content.Context
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.foxivid.baselib.config.BaseLibConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.math.BigDecimal
import java.math.RoundingMode

/**
 * Escala de layout baseada num desenho de referência 1280x720.
 * Original: x1/f1/lb/util/x0.java
 */
object ScreenUtils {
    private val logger: Logger = LoggerFactory.getLogger(ScreenUtils::class.java)

    private var density = 0f
    private var widthPixels = 0
    private var heightPixels = 0
    private var ratioX = 0f
    private var ratioY = 0f
    private var ratio = 0f
    private var verticalMode = false
    private var measureWidth = 1280f
    private var measureHeight = 720f

    /** Lê a resolução uma vez. Original: `x0.b(Context, boolean)`. */
    @Suppress("DEPRECATION")
    private fun readPixels(context: Context, height: Boolean): Int {
        if (widthPixels * heightPixels == 0) {
            val dm = DisplayMetrics()
            (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getMetrics(dm)
            widthPixels = dm.widthPixels
            heightPixels = dm.heightPixels
            if (BaseLibConfig.isDebug) {
                logger.debug(
                    "display[resolution={}x{},density={},densityDpi={},scaledDensity={}]",
                    widthPixels, heightPixels, dm.density, dm.densityDpi, dm.scaledDensity,
                )
            }
        }
        return if (height) heightPixels else widthPixels
    }

    /** min(ratioX, ratioY). Original: `x0.i(Context)`. */
    private fun ratio(context: Context): Float {
        if (ratio == 0f) synchronized(this) {
            if (ratio == 0f) ratio = minOf(ratioX(context), ratioY(context))
        }
        return ratio
    }

    /** Lado maior / 1280 (ou menor / 720 no modo vertical). Original: `x0.j(Context)`. */
    private fun ratioX(context: Context): Float {
        if (ratioX == 0f) synchronized(this) {
            if (ratioX == 0f) {
                ratioX = if (verticalMode) minOf(getScreenWidth(context), getScreenHeight(context)) / measureHeight
                else maxOf(getScreenWidth(context), getScreenHeight(context)) / measureWidth
            }
        }
        return ratioX
    }

    /** Lado menor / 720 (ou maior / 1280 no modo vertical). Original: `x0.k(Context)`. */
    private fun ratioY(context: Context): Float {
        if (ratioY == 0f) synchronized(this) {
            if (ratioY == 0f) {
                ratioY = if (verticalMode) maxOf(getScreenWidth(context), getScreenHeight(context)) / measureWidth
                else minOf(getScreenWidth(context), getScreenHeight(context)) / measureHeight
            }
        }
        return ratioY
    }

    /** Densidade real da tela (cacheada). Original: `x0.a(Context)`. */
    @Suppress("DEPRECATION")
    fun getDensity(context: Context): Float {
        if (density == 0f) synchronized(this) {
            if (density == 0f) {
                val dm = DisplayMetrics()
                (context.applicationContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager)
                    .defaultDisplay.getMetrics(dm)
                density = dm.density
            }
        }
        if (BaseLibConfig.isDebug) logger.debug("ScreenDensity [$density]")
        return density
    }

    /** Escala vertical (usa ratioY se |ratioX−ratioY| < 0.15). Original: `x0.c(Context,int)`. */
    fun scaleY(context: Context, value: Int): Int {
        var r = ratio(context)
        if (Math.abs(ratioX(context) - ratioY(context)) < 0.15) r = ratioY(context)
        return BigDecimal((r * value).toDouble()).setScale(0, RoundingMode.HALF_UP).toInt()
    }

    /** Original: `x0.d(View,int)`. */
    fun scaleY(view: View, value: Int): Int = scaleY(view.context, value)

    /** Escala horizontal (usa ratioX se |ratioX−ratioY| < 0.15). Original: `x0.e(Context,int)`. */
    fun scaleX(context: Context, value: Int): Int {
        var r = ratio(context)
        if (Math.abs(ratioX(context) - ratioY(context)) < 0.15) r = ratioX(context)
        return BigDecimal((r * value).toDouble()).setScale(0, RoundingMode.HALF_UP).toInt()
    }

    /** Original: `x0.f(View,int)`. */
    fun scaleX(view: View, value: Int): Int = scaleX(view.context, value)

    /** Alias. Original: `x0.g(Context,int)`. */
    fun scale(context: Context, value: Int): Int = scaleX(context, value)

    /** Alias. Original: `x0.h(View,int)`. */
    fun scale(view: View, value: Int): Int = scaleX(view, value)

    /**
     * Escala margens e tamanho de LayoutParams (quadrados — width == height — usam escala X
     * nas duas dimensões). Original: `x0.l(View, LayoutParams)`.
     */
    fun scaleLayoutParams(view: View, lp: ViewGroup.LayoutParams): ViewGroup.LayoutParams {
        if (lp is ViewGroup.MarginLayoutParams) {
            lp.leftMargin = scale(view, lp.leftMargin)
            lp.rightMargin = scale(view, lp.rightMargin)
            lp.topMargin = scaleY(view, lp.topMargin)
            lp.bottomMargin = scaleY(view, lp.bottomMargin)
        }
        var square = false
        val w = lp.width
        if (w != ViewGroup.LayoutParams.WRAP_CONTENT && w != ViewGroup.LayoutParams.MATCH_PARENT) {
            square = w == lp.height
            lp.width = scale(view, w)
        }
        val h = lp.height
        if (h != ViewGroup.LayoutParams.WRAP_CONTENT && h != ViewGroup.LayoutParams.MATCH_PARENT) {
            lp.height = if (square) scale(view, h) else scaleY(view, h)
        }
        return lp
    }

    /** Original: `x0.m(Context)`. */
    fun getScreenHeight(context: Context): Int =
        if (heightPixels == 0) synchronized(this) { if (heightPixels == 0) readPixels(context, true) else heightPixels }
        else heightPixels

    /** Original: `x0.n(Context)`. */
    fun getScreenWidth(context: Context): Int =
        if (widthPixels == 0) synchronized(this) { if (widthPixels == 0) readPixels(context, false) else widthPixels }
        else widthPixels
}
