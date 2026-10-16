package com.foxivid.ui.widget.ratingbar

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.ClipDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.os.Build
import androidx.appcompat.content.res.AppCompatResources

/**
 * Drawable base com tint próprio (ColorFilter/ColorStateList/PorterDuff) que desenha em coordenadas locais ao bounds.
 * Original: jf/a.java (+ jf/a$a ConstantState que devolve a própria instância)
 */
abstract class TintedDrawable : Drawable() {
    private var colorFilterValue: ColorFilter? = null          // b
    private var tintList: ColorStateList? = null               // c
    private var tintModeValue: PorterDuff.Mode? = PorterDuff.Mode.SRC_IN   // d
    private var tintFilter: PorterDuffColorFilter? = null      // e
    protected var alphaValue = 255                             // a
    private val constantState = object : ConstantState() {
        override fun getChangingConfigurations(): Int = 0
        override fun newDrawable(): Drawable = this@TintedDrawable
    }

    /** Original: jf.a.b(canvas, largura, altura) */
    protected abstract fun drawContent(canvas: Canvas, width: Int, height: Int)

    @Deprecated("Deprecated in Java")
    override fun getOpacity(): Int = -3

    /** Recalcula o filtro de tint; true se mudou. Original: jf.a.c() */
    private fun updateTint(): Boolean {
        val list = tintList
        val mode = tintModeValue
        if (list != null && mode != null) {
            tintFilter = PorterDuffColorFilter(list.getColorForState(state, 0), mode)
            return true
        }
        val had = tintFilter != null
        tintFilter = null
        return had
    }

    /** Filtro efetivo: o explícito ou, na falta, o do tint. Original: jf.a.a() */
    protected fun effectiveFilter(): ColorFilter? = colorFilterValue ?: tintFilter

    override fun getAlpha(): Int = alphaValue
    override fun getColorFilter(): ColorFilter? = colorFilterValue
    override fun getConstantState(): ConstantState = constantState
    override fun isStateful(): Boolean = tintList?.isStateful == true
    override fun setAlpha(alpha: Int) { if (alphaValue != alpha) { alphaValue = alpha; invalidateSelf() } }
    override fun setColorFilter(filter: ColorFilter?) { colorFilterValue = filter; invalidateSelf() }
    override fun setTintList(tint: ColorStateList?) { tintList = tint; if (updateTint()) invalidateSelf() }
    override fun setTintMode(mode: PorterDuff.Mode?) { tintModeValue = mode; if (updateTint()) invalidateSelf() }
    override fun setTint(tintColor: Int) = setTintList(ColorStateList.valueOf(tintColor))
    override fun onStateChange(state: IntArray): Boolean = updateTint()

    override fun draw(canvas: Canvas) {
        val b = bounds
        if (b.width() != 0 && b.height() != 0) {
            val save = canvas.save()
            canvas.translate(b.left.toFloat(), b.top.toFloat())
            drawContent(canvas, b.width(), b.height())
            canvas.restoreToCount(save)
        }
    }
}

/**
 * Desenha o drawable da estrela repetido: com `tileCount < 0` ladrilha pela largura intrínseca; com `tileCount >= 0` distribui
 * exatamente essa quantidade de estrelas centradas em fatias iguais.
 * Original: jf/f.java
 */
class TiledStarDrawable(private var star: Drawable) : TintedDrawable() {
    private var tileCount = -1          // h

    override fun drawContent(canvas: Canvas, width: Int, height: Int) {
        star.alpha = alphaValue
        effectiveFilter()?.let { star.colorFilter = it }
        val ih = star.intrinsicHeight
        val scale = height.toFloat() / ih
        canvas.scale(scale, scale)
        val w = width / scale
        if (tileCount < 0) {
            val iw = star.intrinsicWidth
            var x = 0
            while (x < w) {
                val next = x + iw
                star.setBounds(x, 0, next, ih)
                star.draw(canvas)
                x = next
            }
            return
        }
        val slice = w / tileCount
        for (i in 0 until tileCount) {
            val center = (i + 0.5f) * slice
            val half = star.intrinsicWidth / 2.0f
            star.setBounds(Math.round(center - half), 0, Math.round(center + half), ih)
            star.draw(canvas)
        }
    }

    /** Original: jf.f.d() */ fun getStar(): Drawable = star
    /** Original: jf.f.e(int) */ fun setTileCount(n: Int) { tileCount = n; invalidateSelf() }
    override fun mutate(): Drawable { star = star.mutate(); return this }
}

/**
 * Fábrica das três camadas (fundo, secundária, progresso) com as estrelas e cores de tint configuradas.
 * Original: jf/c.java
 */
class StarDrawableFactory(
    val context: Context, val numStars: Int, val bgDrawable: Int, val starDrawable: Int,
    val bgColor: ColorStateList?, val subStarColor: ColorStateList?, val starColor: ColorStateList?,
    val keepOriginColor: Boolean
) {
    /** Original: jf.c.a — ClipDrawable(c(...), Gravity.LEFT=3, HORIZONTAL=1) */
    @SuppressLint("RtlHardcoded")
    private fun clipped(res: Int, attr: Int, keep: Boolean): Drawable = ClipDrawable(layer(res, attr, keep), 3, 1)

    /** Original: jf.c.b */
    @SuppressLint("RtlHardcoded")
    private fun clipped(res: Int, color: Int): Drawable = ClipDrawable(layer(res, color), 3, 1)

    /** Original: jf.c.c — se `keep`, não tinge (-1); senão usa a cor do atributo de tema. */
    private fun layer(res: Int, attr: Int, keep: Boolean): Drawable = layer(res, if (!keep) themeColor(attr) else -1)

    /** Original: jf.c.d */
    private fun layer(res: Int, color: Int): Drawable {
        val d = TiledStarDrawable(AppCompatResources.getDrawable(context, res)!!)
        d.mutate()
        if (color != -1) d.setTint(color)
        return d
    }

    /** Original: jf.c.f */
    private fun themeColor(attr: Int): Int {
        val a = context.obtainStyledAttributes(intArrayOf(attr))
        try { return a.getColor(0, 0) } finally { a.recycle() }
    }

    /** Original: jf.c.g — [fundo (colorControlHighlight), secundária (cor 0, transparente), progresso (colorControlActivated)]. */
    fun layers(): Array<Drawable> = arrayOf(
        layer(bgDrawable, androidx.appcompat.R.attr.colorControlHighlight, keepOriginColor),
        clipped(starDrawable, 0),
        clipped(starDrawable, androidx.appcompat.R.attr.colorControlActivated, keepOriginColor),
    )
}

/**
 * LayerDrawable com as camadas background / secondaryProgress / progress de [TiledStarDrawable]; aplica contagem de estrelas e
 * tints (bgColor → fundo, subStarColor → secundária, starColor → progresso).
 * Original: jf/e.java
 */
class StarProgressDrawable(factory: StarDrawableFactory) : LayerDrawable(factory.layers()) {
    init {
        setId(0, android.R.id.background)
        setId(1, android.R.id.secondaryProgress)
        setId(2, android.R.id.progress)
        val bg = tile(android.R.id.background); val sec = tile(android.R.id.secondaryProgress); val pro = tile(android.R.id.progress)
        bg.setTileCount(factory.numStars); sec.setTileCount(factory.numStars); pro.setTileCount(factory.numStars)
        factory.bgColor?.let { bg.setTintList(it) }
        factory.subStarColor?.let { sec.setTintList(it) }
        factory.starColor?.let { pro.setTintList(it) }
    }

    /** Original: jf.e.d(int) */
    fun setNumStars(n: Int) {
        tile(android.R.id.background).setTileCount(n)
        tile(android.R.id.secondaryProgress).setTileCount(n)
        tile(android.R.id.progress).setTileCount(n)
    }

    /** Proporção largura/altura de uma estrela. Original: jf.e.b() */
    fun tileRatio(): Float {
        val d = tile(android.R.id.progress).getStar()
        return d.intrinsicWidth.toFloat() / d.intrinsicHeight
    }

    /** Localiza o [TiledStarDrawable] da camada, atravessando o ClipDrawable (por reflexão antes da API 23). Original: jf.e.a(int) */
    @SuppressLint("NewApi")
    private fun tile(id: Int): TiledStarDrawable {
        val layer = findDrawableByLayerId(id)
        if (id == android.R.id.background) return layer as TiledStarDrawable
        if (id == android.R.id.progress || id == android.R.id.secondaryProgress) {
            val clip = layer as ClipDrawable
            if (Build.VERSION.SDK_INT >= 23) return clip.drawable as TiledStarDrawable
            val stateField = if (Build.VERSION.SDK_INT >= 22) "mState" else "mClipState"
            try {
                val f = clip.javaClass.getDeclaredField(stateField); f.isAccessible = true
                val state = f.get(clip)
                val f2 = state!!.javaClass.getDeclaredField("mDrawable"); f2.isAccessible = true
                return f2.get(state) as TiledStarDrawable
            } catch (e: Exception) { e.printStackTrace() }
        }
        throw RuntimeException()
    }
}
