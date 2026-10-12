package com.foxivid.ui.mobile.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.NetworkInfo
import android.util.Log

/**
 * Receiver de RSSI/estado do Wi-Fi. No original o ramo RSSI_CHANGED registra o log e termina com
 * `throw null` (NullPointerException intencional/resíduo de remoção de código pelo R8); o ramo
 * STATE_CHANGE só avalia se o estado é CONNECTED e descarta o resultado.
 *
 * Original: com/tvc/lib/mobile/broadcastReceiver/WifiBroadcastReceiver.java
 */
open class WifiBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        if ("android.net.wifi.RSSI_CHANGED" != action) {
            if ("android.net.wifi.STATE_CHANGE" == action) {
                @Suppress("DEPRECATION")
                (intent.getParcelableExtra<NetworkInfo>("networkInfo"))!!.state == NetworkInfo.State.CONNECTED
            }
        } else {
            val rssi = intent.getIntExtra("newRssi", 0)
            Log.i(WifiBroadcastReceiver::class.java.name, "Wifi Singal changed: rssi -= $rssi")
            throw NullPointerException() // sic: "throw null" no original
        }
    }
}
