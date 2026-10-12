package com.foxivid.ui.widget

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.graphics.Shader
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.appcompat.widget.AppCompatImageView

/**
 * ImageView com três modos (atributo `type`): 0 = círculo, 1 = retângulo com cantos arredondados
 * (padrão), 2 = oval. Suporta borda e raio por canto. Desenha via BitmapShader.
 *
 * Original: t/v/c/widget/RoundImageView.java
 */
class RoundImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatImageView(context, attrs, defStyle) {

    private var type: Int
    private var borderColor: Int
    private var borderWidth: Float
    private var cornerRadius: Float
    private var leftTopCornerRadius: Float
    private var rightTopCornerRadius: Float
    private var leftBottomCornerRadius: Float
    private var rightBottomCornerRadius: Float
    private var bitmapPaint = Paint().apply { isAntiAlias = true }
    private var borderPaint = Paint().apply { isAntiAlias = true; style = Paint.Style.STROKE }
    private var radius = 0f
    private val matrix = Matrix()
    private var bitmapShader: BitmapShader? = null
    private var viewWidth = 0
    private val roundRect = RectF()
    private val roundPath = Path()
    private var useUnitDip = true

    init {
        val a = context.obtainStyledAttributes(attrs, com.foxivid.ui.R.styleable.RoundImageView, defStyle, 0)
        type = a.getInt(com.foxivid.ui.R.styleable.RoundImageView_type, 1)
        borderColor = a.getColor(com.foxivid.ui.R.styleable.RoundImageView_border_color, -1)
        borderWidth = a.getDimension(com.foxivid.ui.R.styleable.RoundImageView_border_width, 0f)
        cornerRadius = a.getDimension(com.foxivid.ui.R.styleable.RoundImageView_corner_radius, toPx(10).toFloat())
        leftTopCornerRadius = a.getDimension(com.foxivid.ui.R.styleable.RoundImageView_leftTop_corner_radius, 0f)
        leftBottomCornerRadius = a.getDimension(com.foxivid.ui.R.styleable.RoundImageView_leftBottom_corner_radius, 0f)
        rightTopCornerRadius = a.getDimension(com.foxivid.ui.R.styleable.RoundImageView_rightTop_corner_radius, 0f)
        rightBottomCornerRadius = a.getDimension(com.foxivid.ui.R.styleable.RoundImageView_rightBottom_corner_radius, 0f)
        a.recycle()
        borderPaint.color = borderColor
        borderPaint.strokeWidth = borderWidth
    }

    fun setUseUnitDip(useUnitDip: Boolean) { this.useUnitDip = useUnitDip }

    /** dp -> px quando [useUnitDip]. Original: a(int) */
    private fun toPx(dp: Int): Int =
        if (!useUnitDip) dp
        else TypedValue.applyDimension(1, dp.toFloat(), resources.displayMetrics).toInt()

    /** Converte qualquer Drawable em Bitmap (null em OOM). Original: b(Drawable) */
    private fun toBitmap(drawable: Drawable): Bitmap? {
        if (drawable is BitmapDrawable) return drawable.bitmap
        val w = drawable.intrinsicWidth
        val h = drawable.intrinsicHeight
        return try {
            val bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bmp)
            drawable.setBounds(0, 0, w, h)
            drawable.draw(canvas)
            bmp
        } catch (e: OutOfMemoryError) {
            null
        }
    }

    /** Monta o path com raios por canto (ou o raio único). Original: d() */
    private fun buildRoundPath() {
        roundPath.reset()
        if (leftTopCornerRadius == 0f && leftBottomCornerRadius == 0f &&
            rightTopCornerRadius == 0f && rightBottomCornerRadius == 0f
        ) {
            val r = cornerRadius
            roundPath.addRoundRect(roundRect, floatArrayOf(r, r, r, r, r, r, r, r), Path.Direction.CW)
            return
        }
        val lt = leftTopCornerRadius
        val rt = rightTopCornerRadius
        val rb = rightBottomCornerRadius
        val lb = leftBottomCornerRadius
        roundPath.addRoundRect(roundRect, floatArrayOf(lt, lt, rt, rt, rb, rb, lb, lb), Path.Direction.CW)
    }

    /** Prepara o shader do bitmap (escala/centro conforme o tipo). Original: e() */
    private fun setupShader() {
        val drawable = drawable ?: return
        val bitmap = toBitmap(drawable) ?: return
        bitmapShader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        matrix.setTranslate(0f, 0f)
        var scale = 1.0f
        if (type != 0) {
            if ((type == 1 || type == 2) && (bitmap.width != width || bitmap.height != height)) {
                scale = Math.max(width * 1.0f / bitmap.width, height * 1.0f / bitmap.height)
                val dx = (bitmap.width * scale - width) / 2
                val dy = (bitmap.height * scale - height) / 2
                matrix.setTranslate(-dx, -dy)
            }
        } else if (bitmap.width != width || bitmap.height != height) {
            scale = viewWidth * 1.0f / Math.min(bitmap.width, bitmap.height)
            val dx = (bitmap.width * scale - viewWidth) / 2
            val dy = (bitmap.height * scale - viewWidth) / 2
            matrix.setTranslate(-dx, -dy)
        }
        matrix.preScale(scale, scale)
        bitmapShader?.setLocalMatrix(matrix)
        bitmapPaint.shader = bitmapShader
    }

    override fun onDraw(canvas: Canvas) {
        if (drawable == null) return
        setupShader()
        when (type) {
            0 -> {
                val c = borderWidth / 2 + radius
                canvas.drawCircle(c, c, radius, bitmapPaint)
                if (borderWidth > 0f) canvas.drawCircle(c, c, radius, borderPaint)
            }
            1 -> {
                buildRoundPath()
                canvas.drawPath(roundPath, bitmapPaint)
                if (borderWidth > 0f) canvas.drawPath(roundPath, borderPaint)
            }
            else -> {
                canvas.drawOval(roundRect, bitmapPaint)
                if (borderWidth > 0f) canvas.drawOval(roundRect, borderPaint)
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (type == 0) {
            val size = Math.min(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec))
            viewWidth = size
            radius = (size / 2) - (borderWidth / 2)
            setMeasuredDimension(size, size)
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (type != 1 && type != 2) return
        val half = borderWidth / 2
        roundRect.set(half, half, w - half, h - half)
    }
}
