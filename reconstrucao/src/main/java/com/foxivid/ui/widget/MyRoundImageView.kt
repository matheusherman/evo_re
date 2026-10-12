package com.foxivid.ui.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

/**
 * ImageView com cantos arredondados independentes via clipPath (curvas quadráticas).
 * Atributos `MyRoundCornerImageView`: radius, left_top_radius, right_top_radius,
 * right_bottom_radius, left_bottom_radius (cantos não informados herdam `radius`).
 * Original: t/v/c/widget/MyRoundImageView.java
 */
open class MyRoundImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : AppCompatImageView(context, attrs, defStyleAttr) {
    private var viewWidth = 0f
    private var viewHeight = 0f
    private val defaultRadius = 0
    private var radius = 0
    private var leftTopRadius = 0
    private var rightTopRadius = 0
    private var rightBottomRadius = 0
    private var leftBottomRadius = 0

    init { init(context, attrs) } // o original chama init mais de uma vez pela cadeia de construtores

    private fun init(context: Context, attrs: AttributeSet?) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.MyRoundCornerImageView)
        radius = ta.getDimensionPixelOffset(R.styleable.MyRoundCornerImageView_radius, defaultRadius)
        leftTopRadius = ta.getDimensionPixelOffset(R.styleable.MyRoundCornerImageView_left_top_radius, defaultRadius)
        rightTopRadius = ta.getDimensionPixelOffset(R.styleable.MyRoundCornerImageView_right_top_radius, defaultRadius)
        rightBottomRadius = ta.getDimensionPixelOffset(R.styleable.MyRoundCornerImageView_right_bottom_radius, defaultRadius)
        leftBottomRadius = ta.getDimensionPixelOffset(R.styleable.MyRoundCornerImageView_left_bottom_radius, defaultRadius)
        if (defaultRadius == leftTopRadius) leftTopRadius = radius
        if (defaultRadius == rightTopRadius) rightTopRadius = radius
        if (defaultRadius == rightBottomRadius) rightBottomRadius = radius
        if (defaultRadius == leftBottomRadius) leftBottomRadius = radius
        ta.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        val minW = maxOf(leftTopRadius, leftBottomRadius) + maxOf(rightTopRadius, rightBottomRadius)
        val minH = maxOf(leftTopRadius, rightTopRadius) + maxOf(leftBottomRadius, rightBottomRadius)
        if (viewWidth >= minW && viewHeight > minH) {
            val w = viewWidth; val h = viewHeight
            val p = Path()
            p.moveTo(leftTopRadius.toFloat(), 0f)
            p.lineTo(w - rightTopRadius, 0f)
            p.quadTo(w, 0f, w, rightTopRadius.toFloat())
            p.lineTo(w, h - rightBottomRadius)
            p.quadTo(w, h, w - rightBottomRadius, h)
            p.lineTo(leftBottomRadius.toFloat(), h)
            p.quadTo(0f, h, 0f, h - leftBottomRadius)
            p.lineTo(0f, leftTopRadius.toFloat())
            p.quadTo(0f, 0f, leftTopRadius.toFloat(), 0f)
            canvas.clipPath(p)
        }
        super.onDraw(canvas)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        viewWidth = width.toFloat()
        viewHeight = height.toFloat()
    }
}
