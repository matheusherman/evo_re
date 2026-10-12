package com.foxivid.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import com.foxivid.baselib.util.ScreenUtils

/**
 * RadioGroup com auto-layout (escala para a resolução da tela).
 * Mesmo padrão de auto-layout de [FrameLayout]: primeiro setLayoutParams/setPadding escalados
 * via [ScreenUtils], setMinimumWidth/Height sempre escalados.
 *
 * Original: t/v/c/widget/MyRadiogroup.java
 */
open class MyRadiogroup : android.widget.RadioGroup {

    private var paddingSetCount = 0
    private var layoutParamsSetCount = 0

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    /** Força o escalonamento dos layout params (e marca como já escalado). */
    fun setAutoLayoutParams(params: ViewGroup.LayoutParams) {
        layoutParamsSetCount = 1
        super.setLayoutParams(ScreenUtils.scaleLayoutParams(this, params))
    }

    override fun setLayoutParams(params: ViewGroup.LayoutParams) {
        if (layoutParamsSetCount != 0) {
            super.setLayoutParams(params)
        } else {
            super.setLayoutParams(ScreenUtils.scaleLayoutParams(this, params))
            layoutParamsSetCount++
        }
    }

    override fun setMinimumHeight(minHeight: Int) =
        super.setMinimumHeight(ScreenUtils.scaleY(this, minHeight))

    override fun setMinimumWidth(minWidth: Int) =
        super.setMinimumWidth(ScreenUtils.scale(this, minWidth))

    override fun setPadding(left: Int, top: Int, right: Int, bottom: Int) {
        if (paddingSetCount != 0) {
            super.setPadding(left, top, right, bottom)
            return
        }
        super.setPadding(
            ScreenUtils.scale(this, left), ScreenUtils.scaleY(this, top),
            ScreenUtils.scale(this, right), ScreenUtils.scaleY(this, bottom)
        )
        paddingSetCount++
    }
}
