package com.foxivid.ui.widget

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Espaçamento entre itens de RecyclerView linear: horizontal → left/top/bottom (+ right no último);
 * vertical → top/left/right (+ bottom no último).
 * Original: t/v/c/widget/a.java
 */
class SpaceItemDecoration(private val leftRight: Int, private val topBottom: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val lm = parent.layoutManager as? LinearLayoutManager ?: return
        val isLast = parent.getChildAdapterPosition(view) == lm.itemCount - 1
        when (lm.orientation) {
            RecyclerView.HORIZONTAL -> {
                if (isLast) outRect.right = leftRight
                outRect.top = topBottom; outRect.left = leftRight; outRect.bottom = topBottom
            }
            RecyclerView.VERTICAL -> {
                if (isLast) outRect.bottom = topBottom
                outRect.top = topBottom; outRect.left = leftRight; outRect.right = leftRight
            }
        }
    }
}
