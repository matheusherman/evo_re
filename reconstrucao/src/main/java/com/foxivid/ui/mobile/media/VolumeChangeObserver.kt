package com.foxivid.ui.mobile.media

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioManager
import android.os.Build

/**
 * Observador do volume de mídia do sistema: registra um `BroadcastReceiver` de `android.media.VOLUME_CHANGED_ACTION` e avisa o
 * listener com o novo volume do stream de música (tipo 3). Em API >= 34 registra com RECEIVER_NOT_EXPORTED (flag 2).
 * Original: w7/a.java
 */
class VolumeChangeObserver(private val context: Context) {
    /** Listener de mudança de volume. Original: w7.a.c */
    fun interface Listener { fun onVolumeChanged(volume: Int) }

    private var volumeListener: Listener? = null                       // mVolumeChangeListener
    private var receiver: VolumeReceiver? = null                       // mVolumeBroadcastReceiver
    private val audioManager: AudioManager =
        context.applicationContext.getSystemService("audio") as AudioManager   // (original usa StubApp.getOrigApplicationContext)
    private var registered = false                                     // mRegistered

    /** Receiver (classe `w7.a.b`): só considera stream de música (3) e repassa o volume atual. */
    private class VolumeReceiver(private val observer: VolumeChangeObserver) : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if ("android.media.VOLUME_CHANGED_ACTION" != intent.action ||
                intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) != 3) return
            observer.volumeListener?.onVolumeChanged(observer.currentVolume())
        }
    }

    /** Volume atual do stream de música (-1 se indisponível). Original: b() */
    fun currentVolume(): Int = audioManager.getStreamVolume(3)

    /** Registra o receiver (uma vez). Original: c() */
    fun register() {
        if (registered) return
        receiver = VolumeReceiver(this)
        val filter = IntentFilter().apply { addAction("android.media.VOLUME_CHANGED_ACTION") }
        registerReceiver(context, receiver!!, filter)
        registered = true
    }

    /** Original: d(Context, BroadcastReceiver, IntentFilter) */
    fun registerReceiver(context: Context, receiver: BroadcastReceiver, filter: IntentFilter) {
        if (Build.VERSION.SDK_INT >= 34) context.registerReceiver(receiver, filter, 2) else context.registerReceiver(receiver, filter)
    }

    /** Define o listener. Original: e(c) */
    fun setListener(listener: Listener) { volumeListener = listener }
}
