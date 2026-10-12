package com.foxivid.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.PopupWindow
import org.slf4j.LoggerFactory

/**
 * PopupWindow que engole exceções ao exibir (ex.: BadTokenException quando a activity morreu),
 * logando "popup window failure".
 * Original: t/v/c/widget/MyPopupWindow.java
 */
open class MyPopupWindow : PopupWindow {
    /** Campo público `a` do original: marcado true ao exibir (nunca é zerado aqui). */
    @JvmField var shown: Boolean = true

    constructor() : super()
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private inline fun guard(block: () -> Unit) = try { block(); shown = true } catch (t: Throwable) { logger.warn("popup window failure", t) }

    override fun showAsDropDown(anchor: View) = guard { super.showAsDropDown(anchor) }
    override fun showAsDropDown(anchor: View, xoff: Int, yoff: Int) = guard { super.showAsDropDown(anchor, xoff, yoff) }
    override fun showAsDropDown(anchor: View, xoff: Int, yoff: Int, gravity: Int) = guard { super.showAsDropDown(anchor, xoff, yoff, gravity) }
    override fun showAtLocation(parent: View, gravity: Int, x: Int, y: Int) = guard { super.showAtLocation(parent, gravity, x, y) }

    private companion object { val logger = LoggerFactory.getLogger(MyPopupWindow::class.java) }
}
