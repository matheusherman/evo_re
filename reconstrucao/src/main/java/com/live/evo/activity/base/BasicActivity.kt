package com.live.evo.activity.base

import android.os.Bundle
import com.foxivid.baselib.util.EventBusHelper
import com.live.evo.event.MessageEvent
import com.live.evo.mvp.ActivityInitContract
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * Base "template method": setContentView(layoutId) → registro opcional no EventBus → initView/initData...
 * Não há subclasses concretas no APK analisado.
 *
 * Original: com/live/evo/activity/base/BasicActivity.java (implementa g5.a, aqui [ActivityInitContract])
 */
abstract class BasicActivity : LoginBaseActivity(), ActivityInitContract {

    /** Original: u() */
    open fun useEventBus(): Boolean = false

    /** Original: onMessageEvent(b5.f) → s() */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEvent) = handleMessageEvent(event)

    open fun handleMessageEvent(event: MessageEvent) {}

    /** Original: init() — g()=layoutId, f()=initView, w()/t()=métodos default de g5.a. */
    private fun init() {
        setContentView(layoutId())
        if (useEventBus()) EventBusHelper.register(this)
        initView()
        initListener()
        initData()
    }

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState); init() }
    override fun onDestroy() { EventBusHelper.unregister(this); super.onDestroy() }
}
