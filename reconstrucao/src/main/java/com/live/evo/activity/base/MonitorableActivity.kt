package com.live.evo.activity.base

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * Base que apenas loga (tag "monitor_activity") cada callback de ciclo de vida com orientação e largura.
 *
 * Original: com/live/evo/activity/base/MonitorableActivity.java
 */
open class MonitorableActivity : AppCompatActivity() {

    /** Original: k() */
    private fun orientationLabel(): String = when (resources.configuration.orientation) {
        Configuration.ORIENTATION_PORTRAIT -> "ORIENTATION_PORTRAIT--"
        Configuration.ORIENTATION_LANDSCAPE -> "ORIENTATION_LANDSCAPE--"
        else -> "-------"
    }

    /** Original: l() */
    @Suppress("DEPRECATION")
    private fun screenWidth(): Int = windowManager.defaultDisplay.width

    private fun log(cb: String) =
        Log.d("monitor_activity", "---$cb()--orientation = ${orientationLabel()}width = ${screenWidth()}")

    override fun onConfigurationChanged(newConfig: Configuration) {
        Log.d("monitor_activity", "---onConfigurationChanged()--width = ${screenWidth()}")
        super.onConfigurationChanged(newConfig)
    }
    override fun onSaveInstanceState(outState: Bundle) { log("onSaveInstanceState"); super.onSaveInstanceState(outState) }
    override fun onCreate(savedInstanceState: Bundle?) { log("onCreate"); super.onCreate(savedInstanceState) }
    override fun onDestroy() { log("onDestroy"); super.onDestroy() }
    override fun onPause() { log("onPause"); super.onPause() }
    override fun onRestart() { log("onRestart"); super.onRestart() }
    override fun onResume() { log("onResume"); super.onResume() }
    override fun onStart() { log("onStart"); super.onStart() }
    override fun onStop() { log("onStop"); super.onStop() }
}
