package com.foxivid.ui.widget

import android.content.Context
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.AttributeSet
import android.util.Pair
import android.util.TypedValue
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.appcompat.widget.AppCompatTextView
import com.foxivid.baselib.util.ScreenUtils

/**
 * Lógica comum (no original, duplicada em cada classe) dos widgets de texto com auto-layout:
 * tamanho de texto, padding, drawable padding, line spacing, max/min width/height e o primeiro
 * LayoutParams/padding são escalados de 1280x720 para a tela via [ScreenUtils]. O padding do XML é
 * reaplicado no construtor para ser escalado.
 */
internal object AutoLayoutText {

    /** Original: método privado a()/b(Context, AttributeSet) de cada widget. */
    fun applyInitial(v: android.widget.TextView) {
        v.setTextSize(v.textSize)
        v.setPadding(v.paddingLeft, v.paddingTop, v.paddingRight, v.paddingBottom)
    }

    fun maxWidth(v: android.widget.TextView, px: Int): Int =
        if (px != -1 && px != Int.MAX_VALUE) ScreenUtils.scale(v.context, px) else px

    fun applyGradient(v: android.widget.TextView, pairs: Array<Pair<Int, Float>>?) {
        if (pairs == null || pairs.isEmpty()) return
        if (pairs.size == 1) { v.setTextColor(pairs[0].first); return }
        val colors = IntArray(pairs.size) { pairs[it].first }
        val pos = FloatArray(pairs.size) { pairs[it].second }
        v.paint.shader = LinearGradient(0f, 0f, v.paint.textSize * v.text.length, 0f, colors, pos, Shader.TileMode.CLAMP)
        v.invalidate()
    }
}

/**
 * AppCompatTextView com auto-layout de texto (ver [AutoLayoutText]).
 * Original: t/v/c/widget/TextView.java
 */
open class TextView : AppCompatTextView {
    // Ints (não objeto): o construtor da superclasse já chama setPadding/setLayoutParams.
    private var paddingSetCount = 0
    private var layoutParamsSetCount = 0

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) { AutoLayoutText.applyInitial(this) }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) { AutoLayoutText.applyInitial(this) }

    override fun setMaxWidth(maxPixels: Int) = super.setMaxWidth(AutoLayoutText.maxWidth(this, maxPixels))
    override fun setTextSize(size: Float) = setTextSize(TypedValue.COMPLEX_UNIT_PX, ScreenUtils.scaleX(this, size.toInt()).toFloat())
    /** Qualquer unidade é tratada como px (o valor já vem escalado). */
    override fun setTextSize(unit: Int, size: Float) = super.setTextSize(TypedValue.COMPLEX_UNIT_PX, size)
    override fun setCompoundDrawablePadding(pad: Int) = super.setCompoundDrawablePadding(ScreenUtils.scaleX(this, pad))
    override fun setLineSpacing(add: Float, mult: Float) = super.setLineSpacing(ScreenUtils.scaleY(context, add.toInt()).toFloat(), mult)
    override fun setMinimumHeight(minHeight: Int) = super.setMinimumHeight(ScreenUtils.scaleY(this, minHeight))
    override fun setMinimumWidth(minWidth: Int) = super.setMinimumWidth(ScreenUtils.scale(this, minWidth))
    override fun setLayoutParams(params: ViewGroup.LayoutParams) =
        super.setLayoutParams(if (layoutParamsSetCount++ == 0) ScreenUtils.scaleLayoutParams(this, params) else params)
    override fun setPadding(left: Int, top: Int, right: Int, bottom: Int) {
        if (paddingSetCount++ != 0) return super.setPadding(left, top, right, bottom)
        super.setPadding(ScreenUtils.scale(this, left), ScreenUtils.scaleY(this, top), ScreenUtils.scale(this, right), ScreenUtils.scaleY(this, bottom))
    }

    /** Texto em gradiente horizontal (cores/posições); 1 cor = cor sólida. Original: setTextViewGradientStyle(Pair[]). */
    fun setTextViewGradientStyle(pairs: Array<Pair<Int, Float>>?) = AutoLayoutText.applyGradient(this, pairs)
}

/**
 * AppCompatButton com auto-layout de texto (ver [AutoLayoutText]).
 * Original: t/v/c/widget/MyButton.java
 */
open class MyButton : AppCompatButton {
    // Ints (não objeto): o construtor da superclasse já chama setPadding/setLayoutParams.
    private var paddingSetCount = 0
    private var layoutParamsSetCount = 0

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) { AutoLayoutText.applyInitial(this) }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) { AutoLayoutText.applyInitial(this) }

    override fun setMaxWidth(maxPixels: Int) = super.setMaxWidth(AutoLayoutText.maxWidth(this, maxPixels))
    override fun setTextSize(size: Float) = setTextSize(TypedValue.COMPLEX_UNIT_PX, ScreenUtils.scaleX(this, size.toInt()).toFloat())
    /** Qualquer unidade é tratada como px (o valor já vem escalado). */
    override fun setTextSize(unit: Int, size: Float) = super.setTextSize(TypedValue.COMPLEX_UNIT_PX, size)
    override fun setCompoundDrawablePadding(pad: Int) = super.setCompoundDrawablePadding(ScreenUtils.scaleX(this, pad))
    override fun setLineSpacing(add: Float, mult: Float) = super.setLineSpacing(ScreenUtils.scaleY(context, add.toInt()).toFloat(), mult)
    override fun setMinimumHeight(minHeight: Int) = super.setMinimumHeight(ScreenUtils.scaleY(this, minHeight))
    override fun setMinimumWidth(minWidth: Int) = super.setMinimumWidth(ScreenUtils.scale(this, minWidth))
    override fun setLayoutParams(params: ViewGroup.LayoutParams) =
        super.setLayoutParams(if (layoutParamsSetCount++ == 0) ScreenUtils.scaleLayoutParams(this, params) else params)
    override fun setPadding(left: Int, top: Int, right: Int, bottom: Int) {
        if (paddingSetCount++ != 0) return super.setPadding(left, top, right, bottom)
        super.setPadding(ScreenUtils.scale(this, left), ScreenUtils.scaleY(this, top), ScreenUtils.scale(this, right), ScreenUtils.scaleY(this, bottom))
    }
}

/**
 * AppCompatRadioButton com auto-layout de texto (ver [AutoLayoutText]).
 * Original: t/v/c/widget/MyRadiobutton.java
 */
open class MyRadiobutton : AppCompatRadioButton {
    // Ints (não objeto): o construtor da superclasse já chama setPadding/setLayoutParams.
    private var paddingSetCount = 0
    private var layoutParamsSetCount = 0

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) { AutoLayoutText.applyInitial(this) }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) { AutoLayoutText.applyInitial(this) }

    override fun setMaxWidth(maxPixels: Int) = super.setMaxWidth(AutoLayoutText.maxWidth(this, maxPixels))
    override fun setTextSize(size: Float) = setTextSize(TypedValue.COMPLEX_UNIT_PX, ScreenUtils.scaleX(this, size.toInt()).toFloat())
    /** Qualquer unidade é tratada como px (o valor já vem escalado). */
    override fun setTextSize(unit: Int, size: Float) = super.setTextSize(TypedValue.COMPLEX_UNIT_PX, size)
    override fun setCompoundDrawablePadding(pad: Int) = super.setCompoundDrawablePadding(ScreenUtils.scaleX(this, pad))
    override fun setLineSpacing(add: Float, mult: Float) = super.setLineSpacing(ScreenUtils.scaleY(context, add.toInt()).toFloat(), mult)
    override fun setMinimumHeight(minHeight: Int) = super.setMinimumHeight(ScreenUtils.scaleY(this, minHeight))
    override fun setMinimumWidth(minWidth: Int) = super.setMinimumWidth(ScreenUtils.scale(this, minWidth))
    override fun setLayoutParams(params: ViewGroup.LayoutParams) =
        super.setLayoutParams(if (layoutParamsSetCount++ == 0) ScreenUtils.scaleLayoutParams(this, params) else params)
    override fun setPadding(left: Int, top: Int, right: Int, bottom: Int) {
        if (paddingSetCount++ != 0) return super.setPadding(left, top, right, bottom)
        super.setPadding(ScreenUtils.scale(this, left), ScreenUtils.scaleY(this, top), ScreenUtils.scale(this, right), ScreenUtils.scaleY(this, bottom))
    }
}

/**
 * AppCompatEditText com auto-layout de texto (ver [AutoLayoutText]).
 * Original: t/v/c/widget/MyEditText.java
 */
open class MyEditText : AppCompatEditText {
    // Ints (não objeto): o construtor da superclasse já chama setPadding/setLayoutParams.
    private var paddingSetCount = 0
    private var layoutParamsSetCount = 0

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) { AutoLayoutText.applyInitial(this) }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) { AutoLayoutText.applyInitial(this) }

    override fun setMaxWidth(maxPixels: Int) = super.setMaxWidth(AutoLayoutText.maxWidth(this, maxPixels))
    override fun setTextSize(size: Float) = setTextSize(TypedValue.COMPLEX_UNIT_PX, ScreenUtils.scaleX(this, size.toInt()).toFloat())
    /** Qualquer unidade é tratada como px (o valor já vem escalado). */
    override fun setTextSize(unit: Int, size: Float) = super.setTextSize(TypedValue.COMPLEX_UNIT_PX, size)
    override fun setCompoundDrawablePadding(pad: Int) = super.setCompoundDrawablePadding(ScreenUtils.scaleX(this, pad))
    override fun setLineSpacing(add: Float, mult: Float) = super.setLineSpacing(ScreenUtils.scaleY(context, add.toInt()).toFloat(), mult)
    override fun setMinimumHeight(minHeight: Int) = super.setMinimumHeight(ScreenUtils.scaleY(this, minHeight))
    override fun setMinimumWidth(minWidth: Int) = super.setMinimumWidth(ScreenUtils.scale(this, minWidth))
    override fun setLayoutParams(params: ViewGroup.LayoutParams) =
        super.setLayoutParams(if (layoutParamsSetCount++ == 0) ScreenUtils.scaleLayoutParams(this, params) else params)
    override fun setPadding(left: Int, top: Int, right: Int, bottom: Int) {
        if (paddingSetCount++ != 0) return super.setPadding(left, top, right, bottom)
        super.setPadding(ScreenUtils.scale(this, left), ScreenUtils.scaleY(this, top), ScreenUtils.scale(this, right), ScreenUtils.scaleY(this, bottom))
    }

    /** Texto em gradiente horizontal (cores/posições); 1 cor = cor sólida. Original: setTextViewGradientStyle(Pair[]). */
    fun setTextViewGradientStyle(pairs: Array<Pair<Int, Float>>?) = AutoLayoutText.applyGradient(this, pairs)
}
