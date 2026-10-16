package com.foxivid.ui.mobile.widget.sloading

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.drawable.Drawable
import android.view.animation.LinearInterpolator
import androidx.annotation.FloatRange

/**
 * Base dos "loading builders" do SLoading (biblioteca de spinners): controla um ValueAnimator
 * infinito (0f..1f, duração 1333 ms, atraso inicial 333 ms) e delega o desenho às subclasses.
 * As subclasses concretas (x7/b, x7/c, p, i, d, j, e, g, h, q, m, k, n, o, r, f, l) ficam fora deste
 * módulo; veja [SLoadingType].
 *
 * Original: com/tvc/lib/mobile/ui/widget/sloading/a.java
 */
abstract class SLoadingBuilder : ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {

    /** Original: a.d() — tamanho de traço base (18dp). */
    protected var strokeSize = 0f
        private set
    private var width = 0f
    private var height = 0f
    private var callback: Drawable.Callback? = null
    private var animator: ValueAnimator? = null
    private var duration = 0L
    protected var text: String? = null
        private set
    protected var textVisible = false
        private set

    private fun createAnimator() {
        animator = ValueAnimator.ofFloat(0.0f, 1.0f).apply {
            repeatCount = -1
            setDuration(this@SLoadingBuilder.duration)
            startDelay = 333L
            interpolator = LinearInterpolator()
        }
    }

    protected abstract fun onAnimationFrame(animator: ValueAnimator, @FloatRange(from = 0.0, to = 1.0) fraction: Float) // a
    abstract fun initParams(context: Context, color: Int)  // k
    protected abstract fun draw(canvas: Canvas)             // n
    protected abstract fun onStop()                         // o
    protected abstract fun onStart(animator: ValueAnimator) // p
    abstract fun setAlpha(alpha: Int)                       // q
    abstract fun setColorFilter(filter: ColorFilter?)       // t
    open fun setExtraColor(color: Int) {}                   // s

    private fun invalidate() { callback?.invalidateDrawable(null) }

    protected open fun getHeight(): Float = height   // e()
    protected open fun getWidth(): Float = width     // f()
    /** Acesso público a e()/f() para o drawable. */
    fun getHeightPx(): Float = getHeight()
    fun getWidthPx(): Float = getWidth()

    protected fun centerX(): Float = getWidth() * 0.5f   // g()
    protected fun centerY(): Float = getHeight() * 0.5f  // h()

    /** Tamanhos padrão: traço 18dp, área 56x56dp, ciclo de 1333 ms. Original: a.i(Context) */
    fun init(context: Context) {
        strokeSize = dp(context, 18.0f)
        width = dp(context, 56.0f)
        height = dp(context, 56.0f)
        duration = 1333L
        createAnimator()
    }

    fun isRunning(): Boolean = animator!!.isRunning                 // m()
    fun setCallback(callback: Drawable.Callback) { this.callback = callback } // r()
    open fun setText(text: String?) { this.text = text }           // u()
    open fun setTextVisible(visible: Boolean) { textVisible = visible } // v()

    /** Original: a.w() */
    fun start() {
        val a = animator!!
        if (a.isStarted) return
        a.addUpdateListener(this)
        a.addListener(this)
        a.repeatCount = -1
        a.duration = duration
        onStart(a)
        a.start()
    }

    /** Original: a.x() */
    fun stop() {
        val a = animator!!
        a.removeAllUpdateListeners()
        a.removeAllListeners()
        a.repeatCount = 0
        a.duration = 0L
        onStop()
        a.end()
    }

    fun drawTo(canvas: Canvas) = draw(canvas) // c()

    override fun onAnimationUpdate(animation: ValueAnimator) {
        onAnimationFrame(animation, animation.animatedValue as Float)
        invalidate()
    }

    override fun onAnimationCancel(animation: Animator) {}
    override fun onAnimationEnd(animation: Animator) {}
    override fun onAnimationRepeat(animation: Animator) {}
    override fun onAnimationStart(animation: Animator) {}

    companion object {
        /** dp -> px. Original: a.b(Context, float) */
        @JvmStatic
        protected fun dp(context: Context, value: Float): Float = value * context.resources.displayMetrics.density
    }
}
