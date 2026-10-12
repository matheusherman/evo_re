package com.live.evo.osd

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager

/**
 * LinearLayoutManager que evita perder o foco ao navegar com D-pad no fim da lista:
 * calcula a próxima posição (UP=33 → -1, DOWN=130 → +1), rola até ela se estiver além do último
 * item visível, e devolve a própria view se a posição sair do intervalo [0, itemCount].
 *
 * Original: com/live/evo/osd/recyclerviewadapter/FocusFixedLinearLayoutManager.java
 */
class FocusFixedLinearLayoutManager : LinearLayoutManager {
    constructor(context: Context, orientation: Int, reverse: Boolean) : super(context, orientation, reverse)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) :
        super(context, attrs, defStyleAttr, defStyleRes)

    override fun onInterceptFocusSearch(focused: View, direction: Int): View? {
        var position = getPosition(getFocusedChild()!!)
        val itemCount = itemCount
        val lastVisible = findLastVisibleItemPosition()
        if (direction != 33) {
            if (direction == 130) position++
        } else {
            position--
        }
        if (position in 0..itemCount) {
            if (position > lastVisible) scrollToPosition(position)
            return super.onInterceptFocusSearch(focused, direction)
        }
        return focused
    }
}
