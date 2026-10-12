package com.foxivid.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * RecyclerView de TV sobre [MyRecyclerView]: sem overscroll/clip, foco habilitado, debounce de
 * teclas (ignora onKeyDown a menos de 150 ms do anterior) e helpers de foco por posição.
 * Original: t/v/c/widget/TVRecyclerView.java
 */
open class TVRecyclerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : MyRecyclerView(context, attrs, defStyleAttr) {
    private var focusedItemPosition = -1
    private val decors = ArrayList<RecyclerView.ItemDecoration>()
    private var mLastKeyDownTime = 0L

    init { initView() }

    /** Original: `b()`. Nota: no construtor o layoutManager ainda é null, então a decoração não é registrada. */
    private fun initView() {
        setWillNotDraw(true)
        overScrollMode = OVER_SCROLL_NEVER
        isChildrenDrawingOrderEnabled = true
        clipChildren = false
        clipToPadding = false
        isClickable = false
        isFocusable = true
        isFocusableInTouchMode = true
        itemAnimator = null
        if (layoutManager is LinearLayoutManager) registerItemDecoration()
    }

    override fun getBaseline(): Int = -1

    /** Original: `c(int,int)` / `d(...)` com defaults 20/20. */
    private fun registerItemDecoration(leftRight: Int = 20, topBottom: Int = 20) {
        val d = SpaceItemDecoration(leftRight, topBottom)
        decors.add(d)
        addItemDecoration(d)
    }

    private fun getFocusedItemPosition(): Int = focusedChild?.let { getChildAdapterPosition(it) } ?: -1

    fun getFirstVisiblePosition(): Int = if (childCount == 0) 0 else getChildAdapterPosition(getChildAt(0))
    fun getLastVisiblePosition(): Int = if (childCount == 0) 0 else getChildAdapterPosition(getChildAt(childCount - 1))

    override fun isInTouchMode(): Boolean = super.isInTouchMode()

    /** Só repassa se houver layoutManager (evita NPE). */
    override fun onDetachedFromWindow() {
        if (layoutManager != null) super.onDetachedFromWindow()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val now = System.currentTimeMillis()
        if (now - mLastKeyDownTime < 150) return true
        val r = super.onKeyDown(keyCode, event)
        mLastKeyDownTime = now
        return r
    }

    fun setClearFocusByPosition(position: Int) { findViewHolderForAdapterPosition(position)?.itemView?.clearFocus() }

    override fun setLayoutManager(layout: LayoutManager?) {
        super.setLayoutManager(layout)
        setHasFixedSize(true)
    }

    fun setRequestFocusByPosition(position: Int) { findViewHolderForAdapterPosition(position)?.itemView?.requestFocus() }

    fun setSelectedPosition(pos: Int) = smoothScrollToPosition(pos)
}
