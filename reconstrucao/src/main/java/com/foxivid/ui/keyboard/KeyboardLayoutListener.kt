package com.foxivid.ui.keyboard

import android.view.ViewTreeObserver

/**
 * Base dos listeners de layout global da janela: guarda o id (view id do teclado) e se o teclado
 * estava visível na última medição.
 *
 * Original: ziyi/kit/keyboard/c.java
 */
open class KeyboardLayoutListener : ViewTreeObserver.OnGlobalLayoutListener {
    /** Original: c.a()/b(int) */
    var id: Int = 0
    /** Original: c.b */
    @JvmField var keyboardShown: Boolean = false

    override fun onGlobalLayout() {}
}
