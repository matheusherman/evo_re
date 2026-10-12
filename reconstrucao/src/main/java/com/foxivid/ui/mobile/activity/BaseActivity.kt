package com.foxivid.ui.mobile.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Activity base: registra no log o ciclo onStop/onResume e emite eventos de "app saiu para segundo
 * plano com foco" (nf/k) e "app voltou" (nf/j) via EventBus.
 *
 * Eventos: [AppEnterForegroundEvent] = nf.j,
 * [AppEnterBackgroundEvent] = nf.k.
 *
 * Original: com/tvc/lib/mobile/activity/BaseActivity.java
 */
open class BaseActivity : AppCompatActivity() {

    protected val logger: Logger = LoggerFactory.getLogger(javaClass)
    private val handler = Handler(Looper.getMainLooper())
    private var leftWithFocus = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
