package com.live.evo.activity.base

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.util.EventBusHelper
import com.foxivid.baselib.util.FirebaseHelper
import com.google.firebase.analytics.FirebaseAnalytics
import com.live.evo.event.WindowFocusLostEvent
import com.live.evo.event.WindowFocusRegainedEvent
import me.jessyan.autosize.AutoSizeCompat
import org.greenrobot.eventbus.EventBus
import org.slf4j.LoggerFactory

/**
 * Base comum de todas as Activities do app (TV).
 * - cria FirebaseAnalytics e o expõe ao SDK ([FirebaseHelper.Provider], x1.f1.lb.util.j0.a);
 * - registra/desregistra no EventBus em onResume/onPause;
 * - publica eventos de perda/recuperação de foco da janela (b5.k / b5.j);
 * - trata resultado da permissão de armazenamento (requestCode 1).
 *
 * Original: com/live/evo/activity/base/BaseActivity.java
 */
open class BaseActivity : MonitorableActivity(), FirebaseHelper.Provider {

    private val logger = LoggerFactory.getLogger(BaseActivity::class.java)
    lateinit var firebaseAnalytics: FirebaseAnalytics
    private var leftWithFocus = false
    private var loadingView: View? = null
    private var loadingTextView: TextView? = null

    /** Id da view de loading (subclasses sobrescrevem). Original: n() */
    @IdRes open fun loadingViewId(): Int? = null

    /** Id do texto de loading. Original: o() */
    @IdRes open fun loadingTextViewId(): Int? = null

    /** Original: a() (j0.a) */
    override fun firebaseAnalytics(): FirebaseAnalytics = firebaseAnalytics

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (BaseLibConfig.isDebug()) {
            val o = when (newConfig.orientation) { 1 -> "portrait"; 2 -> "landscape"; else -> "unknown" }
            logger.debug("onConfigurationChanged orientation[$o], densityDpi[${newConfig.densityDpi}")
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        // Original: StubApp.interface22(...) — hook do Jiagu, ignorado.
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.isEmpty() || grantResults[0] != 0) {
            if (requestCode == REQUEST_STORAGE) onStoragePermissionDenied()
        } else if (requestCode == REQUEST_STORAGE) {
            onStoragePermissionGranted()
        }
    }

    /** Original: p() */
    open fun onStoragePermissionDenied() = logger.warn("user denied external storage permission")

    /** Original: q() */
    open fun onStoragePermissionGranted() = logger.info("user granted external storage permission")

    override fun getResources(): Resources {
        val r = super.getResources()
        if (Looper.myLooper() == Looper.getMainLooper()) AutoSizeCompat.autoConvertDensityOfGlobal(r)
        return r
    }

    /** Resolve as views de loading após setContentView. Original: onContentChanged() */
    override fun onContentChanged() {
        super.onContentChanged()
        loadingViewId()?.let { loadingView = findViewById(it) }
        loadingTextViewId()?.let { loadingTextView = findViewById(it) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
    }

    override fun onPause() {
        super.onPause()
        if (hasWindowFocus()) {
            EventBus.getDefault().post(WindowFocusLostEvent())
            leftWithFocus = true
        }
        EventBusHelper.unregister(this)
    }

    override fun onResume() {
        super.onResume()
        EventBusHelper.register(this)
        if (leftWithFocus) {
            logger.info("activity on resume[${hashCode()}@$javaClass], leftWithFocus[$leftWithFocus]")
            EventBus.getDefault().post(WindowFocusRegainedEvent())
            leftWithFocus = false
        }
    }

    companion object {
        /** Original: f5410g */
        private const val REQUEST_STORAGE = 1
    }
}
