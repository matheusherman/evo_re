package com.foxivid.ui.widget.banner

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 * Observer de ciclo de vida do banner (youth `addBannerLifecycleObserver`): inicia o auto-loop em
 * onStart, para em onStop e libera callbacks em onDestroy.
 *
 * Original: t/v/c/widget/banner/Banner$addBannerLifecycleObserver$1.java
 */
class BannerLifecycleObserver(private val banner: Banner<*, *>) : DefaultLifecycleObserver {
    override fun onDestroy(owner: LifecycleOwner) { banner.destroy() }
    override fun onStart(owner: LifecycleOwner) { banner.startLoop() }
    override fun onStop(owner: LifecycleOwner) { banner.stopLoop() }
}
