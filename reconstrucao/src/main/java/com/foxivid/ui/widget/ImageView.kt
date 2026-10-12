package com.foxivid.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import com.foxivid.baselib.util.ScreenUtils

/**
 * ImageView (AppCompat) com auto-layout.
 * Mesmo padrão de auto-layout de [FrameLayout]: primeiro setLayoutParams/setPadding escalados
 * via [ScreenUtils], setMinimumWidth/Height sempre escalados.
 *
 * Original: t/v/c/widget/ImageView.java
 */
open class ImageView : AppCompatImageView {

    private var paddingSetCount = 0
    private var layoutParamsSetCount = 0

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        applyInitialPadding()
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        applyInitialPadding()
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

    /**
     * Reaplica o padding vindo do XML para que seja escalado (é o primeiro setPadding).
     * Original: ImageView.a(Context, AttributeSet)
     */
    private fun applyInitialPadding() {
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom)
    }
}
