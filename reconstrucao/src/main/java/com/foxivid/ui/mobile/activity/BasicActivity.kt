package com.foxivid.ui.mobile.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.foxivid.ui.mobile.ext.MessageEventData
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * Contrato de uma activity com layout (t7/a.java): `f()` = initView, `g()` = layout id; os hooks
 * `a`/`b` (corpo vazio) são o initData/observers.
 *
 * Original: t7/a.java
 */
interface ContentView {
    fun initView()
    @LayoutRes fun layoutId(): Int
    fun initData() {}
    fun initObservers() {}
}

/**
 * Activity base com template: setContentView(layoutId) -> (EventBus opcional) -> initView ->
 * initData -> initObservers. Recebe [MessageEventData] no thread principal e delega a [onMessage].
 *
 * Original: com/tvc/lib/mobile/activity/BasicActivity.java (método l = onMessage, n = useEventBus,
 * o/q = registrar/remover EventBus, p = initData, m = initObservers)
 */
abstract class BasicActivity : BaseActivity(), ContentView {
    private var leftWithFocus = false

    /** Se true, registra a activity no EventBus. Original: n() */
    open fun useEventBus(): Boolean = false

    /** Original: l(MessageEventData) */
    open fun onMessage(event: MessageEventData) {}

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEventData) = onMessage(event)

    private fun init() {
        setContentView(layoutId())
        if (useEventBus()) registerEventBus()
        initView()
        initData()
        initObservers()
    }

    override fun initObservers() {}

    fun registerEventBus() {
        if (!EventBus.getDefault().isRegistered(this)) EventBus.getDefault().register(this)
    }

    fun unregisterEventBus() {
        if (EventBus.getDefault().isRegistered(this)) EventBus.getDefault().unregister(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onDestroy() {
        unregisterEventBus()
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        if (leftWithFocus) {
            logger.debug("activity on resume[${hashCode()}@${javaClass}], leftWithFocus[$leftWithFocus]")
            EventBus.getDefault().post(AppEnterForegroundEvent())
            leftWithFocus = false
        }
    }

    override fun onStop() {
        super.onStop()
        val hasFocus = hasWindowFocus()
        logger.debug("activity on stop[${hashCode()}@${javaClass}], hasFocus[$hasFocus]")
        if (hasFocus) {
            EventBus.getDefault().post(AppEnterBackgroundEvent())
            leftWithFocus = true
        }
    }
}
