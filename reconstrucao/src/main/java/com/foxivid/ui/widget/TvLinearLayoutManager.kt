package com.foxivid.ui.widget

import android.content.Context
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView

/**
 * LinearLayoutManager para navegação por D-pad: ao procurar foco além do último item visível,
 * rola até a posição; o smooth scroll foca o item alvo ao terminar.
 * Original: t/v/c/widget/TvLinearLayoutManager.java (+ $a scroller base, $b scroller concreto)
 */
class TvLinearLayoutManager(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) :
    LinearLayoutManager(context, attrs, defStyleAttr, defStyleRes) {

    /** Scroller que pede foco no alvo em onStop (chama super.onStop duas vezes, fiel). Original: $a. */
    abstract class FocusSmoothScroller(context: Context) : LinearSmoothScroller(context) {
        override fun onStop() {
            super.onStop()
            findViewByPosition(targetPosition)?.requestFocus()
            super.onStop()
        }
    }

    override fun onFocusSearchFailed(focused: View, focusDirection: Int, recycler: RecyclerView.Recycler, state: RecyclerView.State): View? =
        super.onFocusSearchFailed(focused, focusDirection, recycler, state)

    override fun onInterceptFocusSearch(focused: View, direction: Int): View? {
        val itemCount = itemCount
        var position = getPosition(focused)
        val lastVisible = findLastVisibleItemPosition()
        when (direction) {
            View.FOCUS_LEFT -> if (orientation == HORIZONTAL) position--
            View.FOCUS_UP -> if (orientation == VERTICAL) position--
            View.FOCUS_RIGHT -> if (orientation == HORIZONTAL) position++
            View.FOCUS_DOWN -> if (orientation == VERTICAL) position++
        }
        if (position in 0 until itemCount && position > lastVisible) scrollToPosition(position)
        return super.onInterceptFocusSearch(focused, direction)
    }

    override fun smoothScrollToPosition(recyclerView: RecyclerView, state: RecyclerView.State?, position: Int) {
        val s = object : FocusSmoothScroller(recyclerView.context) { // Original: $b
            override fun computeScrollVectorForPosition(targetPosition: Int): PointF? = superVector(targetPosition)
        }
        s.targetPosition = position
        startSmoothScroll(s)
    }

    /** Original: `m(int)`. */
    fun superVector(targetPosition: Int): PointF? = super.computeScrollVectorForPosition(targetPosition)
}
