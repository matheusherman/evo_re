package com.foxivid.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import com.foxivid.baselib.util.ScreenUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * FrameLayout com "auto-layout": na primeira chamada a [setLayoutParams] e [setPadding] os valores
 * (pensados para a resolução de design) são escalados para a tela real via [ScreenUtils].
 * Também engole exceções em [onMeasure] (apenas loga).
 *
 * Padrão repetido em todos os widgets `My*`/`TextView`/`ImageView` deste pacote:
 * - contador `paddingSetCount` (orig. campo b): só o PRIMEIRO setPadding é escalado;
 * - contador `layoutParamsSetCount` (orig. campo c): só o PRIMEIRO setLayoutParams é escalado;
 * - setMinimumWidth/Height sempre escalados.
 *
 * Original: t/v/c/widget/FrameLayout.java
 */
open class FrameLayout : android.widget.FrameLayout {

    private val logger: Logger = LoggerFactory.getLogger(FrameLayout::class.java)
    private var paddingSetCount = 0
    private var layoutParamsSetCount = 0

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

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

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        try {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        } catch (e: Exception) {
            logger.error("onMeasure failure", e)
        }
    }
}
