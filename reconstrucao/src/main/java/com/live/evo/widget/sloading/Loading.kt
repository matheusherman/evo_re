package com.live.evo.widget.sloading

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 * Estilos de animação do [SLoadingView] (cada um mapeia para uma classe de renderização em `s5.*`/`widget.*`).
 * Original: com/live/evo/widget/sloading/c.java (enum; nome sugerido LoadingStyle)
 */
enum class LoadingStyle {
    CIRCLE, CIRCLE_CLOCK, STAR_LOADING, LEAF_ROTATE, DOUBLE_CIRCLE, PAC_MAN, ELASTIC_BALL, INFECTION_BALL, INTERTWINE,
    TEXT, SEARCH_PATH, ROTATE_CIRCLE, SINGLE_CIRCLE, SNAKE_CIRCLE, TRANSLATE_CIRCLE, FADING_CIRCLE, ROTATE_SAMECIRCLE
}

/**
 * View de loading animada: usa um Drawable animado (`sloading/b.java`, com `sloading/a.java` como controlador de
 * ValueAnimator) escolhido via [setLoadingBuilder]; opcionalmente exibe texto ([setShowTextView]).
 * Original: com/live/evo/widget/sloading/SLoadingView.java (+ a.java, b.java, anim/SLoadingTextView.java)
 */
class SLoadingView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : FrameLayout(context, attrs, defStyle) {
    fun setLoadingBuilder(style: LoadingStyle) { /* TODO("instancia a classe do estilo e inicia o ValueAnimator (ver sloading/b.java)") */ }
    fun setColorExtra(color: Int) {}
    fun setShowTextView(text: String?) {}
    fun setTextVisiable(visible: Boolean) {}
}
