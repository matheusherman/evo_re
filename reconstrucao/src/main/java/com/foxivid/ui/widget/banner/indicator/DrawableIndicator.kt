package com.foxivid.ui.widget.banner.indicator

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet

/**
 * Indicador baseado em bitmaps (atributos `normal_drawable` / `selected_drawable`).
 * Original: t/v/c/widget/banner/indicator/DrawableIndicator.java
 */
class DrawableIndicator : BaseIndicator {
    private var normalBitmap: Bitmap? = null
    private var selectedBitmap: Bitmap? = null

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { readAttrs(context, attrs) }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) { readAttrs(context, attrs) }

    private fun readAttrs(context: Context, attrs: AttributeSet) {
        val a = context.obtainStyledAttributes(attrs, com.foxivid.ui.R.styleable.DrawableIndicator)
        val normal = a.getDrawable(com.foxivid.ui.R.styleable.DrawableIndicator_normal_drawable) as BitmapDrawable?
        val selected = a.getDrawable(com.foxivid.ui.R.styleable.DrawableIndicator_selected_drawable) as BitmapDrawable?
        normalBitmap = normal?.bitmap
        selectedBitmap = selected?.bitmap
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val count = config.indicatorSize
        val normal = normalBitmap
        val selected = selectedBitmap
        if (count <= 1 || normal == null || selected == null) return
        var x = 0f
        for (i in 0 until count) {
            val bitmap = if (config.currentPosition == i) selected else normal
            canvas.drawBitmap(bitmap, x, 0f, paint)
            x += normal.width + config.indicatorSpace
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val count = config.indicatorSize
        if (count <= 1) return
        val n = count - 1
        val width = selectedBitmap!!.width * n + selectedBitmap!!.width + config.indicatorSpace * n
        setMeasuredDimension(width, Math.max(normalBitmap!!.height, selectedBitmap!!.height))
    }
}
