package com.foxivid.ui.widget.banner.indicator

import android.content.Context
import android.graphics.Canvas
import android.graphics.RectF
import android.util.AttributeSet

/**
 * Indicador de retângulos arredondados (um por página).
 * Original: t/v/c/widget/banner/indicator/RectangleIndicator.java
 */
class RectangleIndicator : BaseIndicator {
    private val rectF = RectF()

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val count = config.indicatorSize
        if (count <= 1) return
        var x = 0f
        for (i in 0 until count) {
            val selected = config.currentPosition == i
            paint.color = if (selected) config.selectedColor else config.normalColor
            val width = if (selected) config.selectedWidth else config.normalWidth
            rectF.set(x, 0f, width + x, config.height.toFloat())
            x += width + config.indicatorSpace
            canvas.drawRoundRect(rectF, config.radius.toFloat(), config.radius.toFloat(), paint)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val count = config.indicatorSize
        if (count <= 1) return
        val n = count - 1
        setMeasuredDimension(config.indicatorSpace * n + config.normalWidth * n + config.selectedWidth, config.height)
    }
}
