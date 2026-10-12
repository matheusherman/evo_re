package com.foxivid.ui.widget.banner.indicator

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet

/**
 * Indicador de linha contínua com um trecho (selectedWidth) destacado.
 * Original: t/v/c/widget/banner/indicator/RoundLinesIndicator.java
 */
class RoundLinesIndicator : BaseIndicator {
    private val rectF = RectF()

    constructor(context: Context) : super(context) { paint.style = Paint.Style.FILL }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { paint.style = Paint.Style.FILL }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) { paint.style = Paint.Style.FILL }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (config.indicatorSize <= 1) return
        paint.color = config.normalColor
        rectF.set(0f, 0f, canvas.width.toFloat(), config.height.toFloat())
        canvas.drawRoundRect(rectF, config.radius.toFloat(), config.radius.toFloat(), paint)
        paint.color = config.selectedColor
        val left = config.currentPosition * config.selectedWidth
        rectF.set(left.toFloat(), 0f, (left + config.selectedWidth).toFloat(), config.height.toFloat())
        canvas.drawRoundRect(rectF, config.radius.toFloat(), config.radius.toFloat(), paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val count = config.indicatorSize
        if (count <= 1) return
        setMeasuredDimension(config.selectedWidth * count, config.height)
    }
}
