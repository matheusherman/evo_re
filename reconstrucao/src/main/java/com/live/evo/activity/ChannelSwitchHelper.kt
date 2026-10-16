package com.live.evo.activity

import android.app.Activity
import android.os.Handler
import com.live.evo.model.ChannelData
import org.slf4j.LoggerFactory

/**
 * Auxiliar de troca de canal da live: encapsula um [Listener] (a Activity) e, em [switchTo], apenas chama
 * `listener.onChannelSwitch(channel, emptyMap, "")`. Os demais métodos (`b`, `c`, `e`, `f`, `a`, `g`/`h`/`i`) são
 * corpos vazios nesta build (restos de um fluxo de preview/lista de programas removido).
 *
 * Original: com/live/evo/activity/n2.java
 */
class ChannelSwitchHelper(private val activity: Activity, private val listener: Listener) {
    private val logger = LoggerFactory.getLogger(ChannelSwitchHelper::class.java)
    private val handler = Handler()

    /** Original: n2.a */
    fun interface Listener { fun onChannelSwitch(channel: ChannelData, params: Map<String, String>, extra: String) }

    /** Original: d(i5.h) */
    fun switchTo(channel: ChannelData) = listener.onChannelSwitch(channel, HashMap(), "")

    /** Original: g() = i(); h() — ambos vazios. */ fun release() { stop(); reset() }
    /** Original: i() — vazio. */ fun stop() {}
    /** Original: h() — vazio. */ fun reset() {}
    /** Original: b() — vazio (cancela preview). */ fun cancel() {}
    /** Original: f() — vazio. */ fun onPlayerStatsToggle() {}
    /** Original: e(boolean,int) — vazio (liga/desliga estatísticas por [intervalMs]). */ fun setStatsEnabled(enabled: Boolean, intervalMs: Int) {}
    /** Original: a(int,Map) — vazio (envio de métrica de evento: 101 replay, 701/702 buffering). */ fun report(eventType: Int, data: Map<String, Any?>) {}
    /** Original: c(b5.l TokenChangeEvent) — vazio. */
    fun onTokenChange(event: com.live.evo.event.TokenChangeEvent) {}
}
