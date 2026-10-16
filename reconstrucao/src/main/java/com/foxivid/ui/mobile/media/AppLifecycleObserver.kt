package com.foxivid.ui.mobile.media

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.foxivid.baselib.config.InteractionUtils
import org.greenrobot.eventbus.EventBus
import org.slf4j.LoggerFactory

/**
 * Observer do ciclo de vida do processo: em onStop, se o modo família estiver ativo
 * (`InteractionUtils.e0()`), executa `I0()` e posta um evento sticky `nf/d(true, "", "enter family")`.
 *
 * Original: com/tvc/lib/mobile/media/AppLifecycleObserver.java
 */
class AppLifecycleObserver : DefaultLifecycleObserver {
    private val logger = LoggerFactory.getLogger(AppLifecycleObserver::class.java)

    override fun onStart(owner: LifecycleOwner) {
        logger.debug("AppLifecycle on start")
    }

    override fun onStop(owner: LifecycleOwner) {
        logger.debug("AppLifecycle on onStop")
        // InteractionUtils = t/v/c/i/a (módulo baselib.config): e0() = modo adulto ativo; I0() = desliga o modo adulto
        if (InteractionUtils.e0()) {
            InteractionUtils.I0()
            EventBus.getDefault().postSticky(com.foxivid.baselib.media.ChannelListEvent(true, "", "enter family"))   // nf/d
        }
    }
}
