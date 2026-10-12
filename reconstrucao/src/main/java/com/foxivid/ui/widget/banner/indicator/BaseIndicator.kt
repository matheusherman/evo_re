package com.foxivid.ui.widget.banner.indicator

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.youth.banner.config.IndicatorConfig

/**
 * View base dos indicadores (cópia do `BaseIndicator` do youth banner).
 * Acessores de [IndicatorConfig] no código ofuscado (bg/b.java): a=currentPosition, b=gravity,
 * c=height, d=indicatorSize, e=indicatorSpace, f=margins, g=normalColor, h=normalWidth,
 * i=radius, j=selectedColor, k=selectedWidth, l=attachToBanner.
 *
 * Original: t/v/c/widget/banner/indicator/BaseIndicator.java
 */
open class BaseIndicator : View, Indicator {

    protected val config = IndicatorConfig()
    protected val paint = Paint()
    private var offset = 0f

    constructor(context: Context) : super(context) { initPaint() }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { initPaint() }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) { initPaint() }

    private fun initPaint() {
        paint.isAntiAlias = true
        paint.color = 0
        paint.color = config.normalColor
    }

    override val indicatorConfig: IndicatorConfig get() = config

    /** Aplica gravity/margens ao layout params quando o indicador está anexado ao banner. */
    open fun getIndicatorView(): View {
        if (config.isAttachToBanner) {
            val lp = FrameLayout.LayoutParams(-2, -2)
            when (config.gravity) {
                0 -> lp.gravity = 8388691  // START | BOTTOM
                1 -> lp.gravity = 81       // CENTER_HORIZONTAL | BOTTOM
                2 -> lp.gravity = 8388693  // END | BOTTOM
            }
            lp.leftMargin = config.margins.leftMargin
            lp.rightMargin = config.margins.rightMargin
            lp.topMargin = config.margins.topMargin
            lp.bottomMargin = config.margins.bottomMargin
            layoutParams = lp
        }
        return this
    }

    override fun onPageChanged(count: Int, currentPosition: Int) {
        config.indicatorSize = count
        config.currentPosition = currentPosition
        requestLayout()
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        offset = positionOffset
        invalidate()
    }

    override fun onPageSelected(position: Int) {
        config.currentPosition = position
        invalidate()
    }

    override fun onPageScrollStateChanged(state: Int) {}
}
