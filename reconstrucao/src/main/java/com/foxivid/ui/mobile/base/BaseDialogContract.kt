package com.foxivid.ui.mobile.base

import android.view.View
import androidx.annotation.GravityInt
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import android.graphics.Rect
import androidx.core.view.ViewCompat

/**
 * Contrato dos diálogos/fragments base: initView (f), layout (g), initData (l), initObservers (y);
 * largura/altura padrão WRAP_CONTENT (-2) e gravity CENTER (17).
 *
 * Original: com/tvc/lib/mobile/ui/base/h.java (métodos default em h$a)
 */
interface BaseDialogContract {
    fun initView()                      // f()
    @LayoutRes fun layoutId(): Int      // g()
    fun initData()                      // l()
    fun initObservers()                 // y()
    fun dialogWidth(): Int = -2         // h.a.a
    fun dialogHeight(): Int = -2        // h.a.b
    @GravityInt fun dialogGravity(): Int = 17 // h.a.c
}

/**
 * Espaçamento à direita (esquerda em RTL) entre itens de uma lista horizontal, exceto no último.
 * Original: com/tvc/lib/mobile/ui/base/i.java
 */
class LastItemSpaceDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val lastIndex = parent.adapter!!.itemCount - 1
        if (ViewCompat.getLayoutDirection(parent) == 1) {
            if (parent.getChildLayoutPosition(view) == lastIndex) {
                outRect.left = 0
                return
            } else {
                outRect.left = space
                return
            }
        }
        if (parent.getChildLayoutPosition(view) == lastIndex) outRect.right = 0 else outRect.right = space
    }
}
