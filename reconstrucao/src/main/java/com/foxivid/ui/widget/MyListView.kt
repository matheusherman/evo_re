package com.foxivid.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.util.ScreenUtils
import org.slf4j.LoggerFactory

/**
 * ListView para TV que mantém o item selecionado centralizado (ou no topo/base) e escala
 * padding/LayoutParams/divider (auto-layout).
 * Original: t/v/c/widget/MyListView.java
 */
open class MyListView : ListView {
    private var paddingSetCount = 0
    private var layoutParamsSetCount = 0

    /** Direção de seleção quando não centraliza; 20 = alinhar o item na base. Original: campo c. */
    private var selectionDirection = 0

    /** Original: campo d (padrão true). */
    private var isKeepCenterPosition = true

    /** Altura de item cacheada. Original: campo e. */
    private var itemHeight = 0

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    /**
     * Seleciona com deslocamento: centralizado → `altura/2 − 0.67 × alturaItem`; direção 20 →
     * `altura − alturaItem`; senão 0 (topo).
     */
    override fun setSelection(position: Int) {
        var y: Int
        var child: View? = null
        try {
            val height = height
            child = getChildAt(position)
            var visible = lastVisiblePosition - firstVisiblePosition + 1
            if (visible <= 0) visible = count
            var h = itemHeight
            if (h == 0) {
                if (child != null) { h = child.height; itemHeight = h } else h = if (visible > 0) height / visible else 0
            }
            if (isKeepCenterPosition) {
                y = height shr 1
                if (h > 0) y = (y - h * 0.67).toInt()
            } else {
                y = if (selectionDirection != 20) 0 else height - h
            }
            try {
                if (BaseLibConfig.isDebug) logger.debug("my_list_view[{}][{}][{}][{}][{}]", height, visible, child?.height ?: 0, if (visible > 0) height / visible else 0, y)
            } catch (_: Exception) {}
        } catch (_: Exception) {
            y = 0
        }
        if (BaseLibConfig.isDebug) logger.debug("setSelection position[{}] y[{}] view is null[{}]", position, y, child == null)
        setSelectionFromTop(position, y)
    }

    override fun setDividerHeight(height: Int) = super.setDividerHeight(ScreenUtils.scaleY(this, height))
    fun setIsKeepCenterPosition(keep: Boolean) { isKeepCenterPosition = keep }
    fun setSelectionDirection(direction: Int) { selectionDirection = direction }

    override fun setLayoutParams(params: ViewGroup.LayoutParams) =
        super.setLayoutParams(if (layoutParamsSetCount++ == 0) ScreenUtils.scaleLayoutParams(this, params) else params)
    override fun setMinimumHeight(minHeight: Int) = super.setMinimumHeight(ScreenUtils.scaleY(this, minHeight))
    override fun setMinimumWidth(minWidth: Int) = super.setMinimumWidth(ScreenUtils.scale(this, minWidth))
    override fun setPadding(left: Int, top: Int, right: Int, bottom: Int) {
        if (paddingSetCount++ != 0) return super.setPadding(left, top, right, bottom)
        super.setPadding(ScreenUtils.scale(this, left), ScreenUtils.scaleY(this, top), ScreenUtils.scale(this, right), ScreenUtils.scaleY(this, bottom))
    }

    private companion object { val logger = LoggerFactory.getLogger(MyListView::class.java) }
}
