package com.foxivid.ui.keyboard

import androidx.lifecycle.DefaultLifecycleObserver

/**
 * DefaultLifecycleObserver que carrega o id do teclado a que pertence (sobrescrito em [KeyUtils]
 * com onDestroy/onPause/onResume).
 *
 * Original: ziyi/kit/keyboard/MyLifecycleObserver.java
 */
open class MyLifecycleObserver : DefaultLifecycleObserver {
    /** Original: a()/b(int) */
    var id: Int = 0
}
