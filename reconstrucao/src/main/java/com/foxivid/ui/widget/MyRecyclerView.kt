package com.foxivid.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.foxivid.baselib.util.ScreenUtils

/**
 * RecyclerView para TV: lembra o último filho focado e, ao receber foco de fora, devolve o foco a
 * ele (via [addFocusables]); sem animação de itens; auto-layout de padding/LayoutParams.
 * Original: t/v/c/widget/MyRecyclerView.java
 */
open class MyRecyclerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : RecyclerView(context, attrs, defStyleAttr) {
    private var paddingSetCount = 0
    private var layoutParamsSetCount = 0
    private var lastFocusedView: View? = null
    private var lastFocusedPosition = 0

    init { setup() }

    /** FOCUS_AFTER_DESCENDANTS (262144), ordem de desenho customizada. Original: `a()`. */
    fun setup() {
        itemAnimator = null
        descendantFocusability = FOCUS_AFTER_DESCENDANTS
        isChildrenDrawingOrderEnabled = true
        isFocusable = true
    }

    override fun requestChildFocus(child: View?, focused: View?) {
        if (child != null) {
            super.requestChildFocus(child, focused)
            lastFocusedView = focused
            lastFocusedPosition = getChildViewHolder(child).absoluteAdapterPosition
        }
    }

    override fun addFocusables(views: ArrayList<View>, direction: Int, focusableMode: Int) {
        if (!hasFocus() && lastFocusedView != null) {
            views.add(layoutManager!!.findViewByPosition(lastFocusedPosition)!!) // fiel: pode adicionar null no original
        } else {
            super.addFocusables(views, direction, focusableMode)
        }
    }

    override fun setLayoutParams(params: ViewGroup.LayoutParams) =
        super.setLayoutParams(if (layoutParamsSetCount++ == 0) ScreenUtils.scaleLayoutParams(this, params) else params)
    override fun setMinimumHeight(minHeight: Int) = super.setMinimumHeight(ScreenUtils.scaleY(this, minHeight))
    override fun setMinimumWidth(minWidth: Int) = super.setMinimumWidth(ScreenUtils.scale(this, minWidth))
    override fun setPadding(left: Int, top: Int, right: Int, bottom: Int) {
        if (paddingSetCount++ != 0) return super.setPadding(left, top, right, bottom)
        super.setPadding(ScreenUtils.scale(this, left), ScreenUtils.scaleY(this, top), ScreenUtils.scale(this, right), ScreenUtils.scaleY(this, bottom))
    }
}
