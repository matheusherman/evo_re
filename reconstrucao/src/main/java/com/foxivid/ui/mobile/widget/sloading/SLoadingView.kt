package com.foxivid.ui.mobile.widget.sloading

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.foxivid.ui.mobile.R

/**
 * ImageView que exibe uma animação de loading ([SLoadingType], atributos `s_type`, `s_color`,
 * `s_color_extra`). Inicia/para a animação ao anexar/desanexar e conforme a visibilidade.
 *
 * Original: com/tvc/lib/mobile/ui/widget/sloading/SLoadingView.java
 */
open class SLoadingView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = -1
) : AppCompatImageView(context, attrs, defStyle) {

    private var drawable: SLoadingDrawable? = null
    protected var builder: SLoadingBuilder? = null
    private var extraColor = 0

    init {
        try {
            val a = context.obtainStyledAttributes(attrs, R.styleable.SLoadingView)
            val type = a.getInt(R.styleable.SLoadingView_s_type, 0)
            val color = a.getColor(R.styleable.SLoadingView_s_color, -16777216) // preto
            extraColor = a.getColor(R.styleable.SLoadingView_s_color_extra, -7829368) // cinza
            a.recycle()
            setLoadingBuilder(SLoadingType.values()[type])
            setColorFilter(color)
            setColorExtra(extraColor)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun startAnim() { drawable?.start() }
    private fun stopAnim() { drawable?.stop() }

    fun setColorExtra(color: Int) { builder!!.setExtraColor(color) }
    fun setShowTextView(text: String?) { builder!!.setText(text) }
    fun setTextVisiable(visible: Boolean) { builder!!.setTextVisible(visible) }

    override fun onAttachedToWindow() { super.onAttachedToWindow(); startAnim() }
    override fun onDetachedFromWindow() { super.onDetachedFromWindow(); stopAnim() }

    override fun onVisibilityChanged(changedView: View, visibility: Int) {
        super.onVisibilityChanged(changedView, visibility)
        if (visibility == 0 && getVisibility() == 0) startAnim() else stopAnim()
    }

    open fun setLoadingBuilder(type: SLoadingType) {
        builder = type.createBuilder()
        drawable = SLoadingDrawable(builder!!).also {
            it.init(context, extraColor)
            setImageDrawable(it)
        }
    }
}
