package com.foxivid.ui.widget.ratingbar

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.View
import android.widget.RatingBar

/**
 * RatingBar com estrelas customizáveis (cores, drawable, espaçamento, escala e modo direita-para-esquerda).
 * O drawable de progresso é `jf.e` (LayerDrawable de estrelas) montado com `jf.c` (fábrica de
 * drawables de estrela) — classes de terceiros/utilitárias fora deste módulo, referenciadas como
 * [StarProgressDrawable] / [StarDrawableFactory].
 *
 * Original: t/v/c/widget/ratingbar/MyRatingBar.java
 */
@SuppressLint("AppCompatCustomView")
open class MyRatingBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : RatingBar(context, attrs, defStyle), RatingBar.OnRatingBarChangeListener {

    private var starColor: ColorStateList? = null       // f18812a
    private var subStarColor: ColorStateList? = null    // f18813b
    private var bgColor: ColorStateList? = null         // f18814c
    private var starDrawableRes = 0                     // f18815d
    private var bgDrawableRes = 0                       // f18816e
    private var keepOriginColor = false                 // f18817f
    private var scaleFactor = 1.0f                      // f18818g
    private var starSpacing = 0f                        // f18819h
    private var right2Left = false                      // f18820i
    private var progressDrawable: StarProgressDrawable? = null // f18821j
    private var lastRating = 0f                         // f18822k

    interface OnRatingChangeListener

    init {
        val a = context.obtainStyledAttributes(attrs, com.foxivid.ui.R.styleable.MyRatingBar, defStyle, 0)
        right2Left = a.getBoolean(com.foxivid.ui.R.styleable.MyRatingBar_right2Left, false)
        if (a.hasValue(com.foxivid.ui.R.styleable.MyRatingBar_starColor)) {
            val c = a.getColorStateList(com.foxivid.ui.R.styleable.MyRatingBar_starColor)
            if (right2Left) bgColor = c else starColor = c
        }
        if (a.hasValue(com.foxivid.ui.R.styleable.MyRatingBar_subStarColor) && !right2Left) {
            subStarColor = a.getColorStateList(com.foxivid.ui.R.styleable.MyRatingBar_subStarColor)
        }
        if (a.hasValue(com.foxivid.ui.R.styleable.MyRatingBar_bgColor)) {
            val c = a.getColorStateList(com.foxivid.ui.R.styleable.MyRatingBar_bgColor)
            if (right2Left) starColor = c else bgColor = c
        }
        keepOriginColor = a.getBoolean(com.foxivid.ui.R.styleable.MyRatingBar_keepOriginColor, false)
        scaleFactor = a.getFloat(com.foxivid.ui.R.styleable.MyRatingBar_scaleFactor, 1.0f)
        starSpacing = a.getDimension(com.foxivid.ui.R.styleable.MyRatingBar_starSpacing, 0f)
        val defaultStar = com.foxivid.ui.R.drawable.ic_rating_star_solid
        starDrawableRes = a.getResourceId(com.foxivid.ui.R.styleable.MyRatingBar_starDrawable, defaultStar)
        bgDrawableRes = if (a.hasValue(com.foxivid.ui.R.styleable.MyRatingBar_bgDrawable))
            a.getResourceId(com.foxivid.ui.R.styleable.MyRatingBar_bgDrawable, defaultStar)
        else starDrawableRes
        a.recycle()
        val factory = StarDrawableFactory(context, numStars, bgDrawableRes, starDrawableRes, bgColor, subStarColor, starColor, keepOriginColor)
        progressDrawable = StarProgressDrawable(factory)
        setProgressDrawable(progressDrawable as android.graphics.drawable.Drawable)
    }

    @Synchronized
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val h = measuredHeight
        setMeasuredDimension(
            View.resolveSizeAndState(
                Math.round(h * progressDrawable!!.tileRatio() * numStars * scaleFactor) + ((numStars - 1) * starSpacing).toInt(),
                widthMeasureSpec, 0
            ),
            h
        )
    }

    override fun onRatingChanged(ratingBar: RatingBar, rating: Float, fromUser: Boolean) { lastRating = rating }

    fun setScaleFactor(f: Float) { scaleFactor = f; requestLayout() }

    fun setStarSpacing(f: Float) { starSpacing = f; requestLayout() }

    override fun setNumStars(numStars: Int) {
        super.setNumStars(numStars)
        progressDrawable?.setNumStars(numStars)
    }

    /** O listener passado é ignorado: o próprio RatingBar é registrado. */
    fun setOnRatingChangeListener(listener: OnRatingChangeListener?) { onRatingBarChangeListener = this }

    override fun setRating(rating: Float) {
        super.setRating(rating)
        if (right2Left) super.setRating(numStars - getRating())
    }
}

/** Referência a `jf.e` (drawable de progresso com tiles de estrelas). Não reconstruído (fora do módulo). */
open class StarProgressDrawable(factory: StarDrawableFactory) : android.graphics.drawable.LayerDrawable(arrayOf()) {
    /** Original: jf.e.b() */
    open fun tileRatio(): Float = TODO("jf.e (drawable de progresso) fora do módulo")
    /** Original: jf.e.d(int) */
    open fun setNumStars(n: Int): Unit = TODO("jf.e (drawable de progresso) fora do módulo")
}

/** Referência a `jf.c` (fábrica de drawables das estrelas). Não reconstruído (fora do módulo). */
class StarDrawableFactory(
    val context: Context, val numStars: Int, val bgDrawable: Int, val starDrawable: Int,
    val bgColor: ColorStateList?, val subStarColor: ColorStateList?, val starColor: ColorStateList?,
    val keepOriginColor: Boolean
)
