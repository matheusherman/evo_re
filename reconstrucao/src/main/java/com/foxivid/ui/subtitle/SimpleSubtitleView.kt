package com.foxivid.ui.subtitle

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import com.foxivid.ui.widget.TextView

/**
 * TextView que serve de destino de legendas. Cria um `SubtitleViewHandler` (classe yf/a.java da
 * biblioteca de legendas do player) cujo `c(CharSequence)` apenas faz setText; destrói o handler
 * ao desanexar. Os campos EMPTY_TEXT/mStrokeWidth(3.0)/mStrokeColor(#000000) existem no original
 * mas não são usados na parte decompilada (contorno do texto não é desenhado aqui).
 *
 * Original: t/v/c/s/widget/SimpleSubtitleView.java
 */
class SimpleSubtitleView : TextView {
    private val emptyText = ""
    private val strokeWidth = 3.0f
    private val strokeColor = Color.parseColor("#000000")
    private lateinit var subtitleViewHandler: SubtitleViewHandler

    constructor(context: Context) : super(context) { init() }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) { init() }
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) { init() }

    private fun init() {
        subtitleViewHandler = object : SubtitleViewHandler() {
            override fun onSubtitleText(text: CharSequence) { setText(text) }
        }
    }

    fun getSubtitleHandler(): SubtitleViewHandler = subtitleViewHandler

    override fun onDetachedFromWindow() {
        subtitleViewHandler.destroy()
        super.onDetachedFromWindow()
    }
}

/**
 * Stub de referência da classe `yf.a` (handler de legendas fora do escopo deste módulo).
 * Original: yf/a.java (método c(CharSequence) = onSubtitleText)
 */
abstract class SubtitleViewHandler {
    abstract fun onSubtitleText(text: CharSequence)
    open fun destroy() {}
}
