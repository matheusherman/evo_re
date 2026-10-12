package com.foxivid.ui.widget.banner.indicator

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet

/**
 * Indicador de bolinhas (raio = largura/2, selecionado maior).
 * Original: t/v/c/widget/banner/indicator/CircleIndicator.java
 */
class CircleIndicator : BaseIndicator {
    private var normalRadius = 0
    private var selectedRadius = 0
    private var maxRadius = 0

    constructor(context: Context) : super(context) { initRadius() }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { initRadius() }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) { initRadius() }

    private fun initRadius() {
        normalRadius = config.normalWidth / 2
        selectedRadius = config.selectedWidth / 2
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val count = config.indicatorSize
        if (count <= 1) return
        var x = 0f
        for (i in 0 until count) {
            val selected = config.currentPosition == i
            paint.color = if (selected) config.selectedColor else config.normalColor
            val width = if (selected) config.selectedWidth else config.normalWidth
            val radius = (if (selected) selectedRadius else normalRadius).toFloat()
            canvas.drawCircle(x + radius, maxRadius.toFloat(), radius, paint)
            x += width + config.indicatorSpace
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val count = config.indicatorSize
        if (count <= 1) return
        normalRadius = config.normalWidth / 2
        selectedRadius = config.selectedWidth / 2
        maxRadius = Math.max(selectedRadius, normalRadius)
        val n = count - 1
        setMeasuredDimension(
            config.indicatorSpace * n + config.selectedWidth + config.normalWidth * n,
            Math.max(config.normalWidth, config.selectedWidth)
        )
    }
}
