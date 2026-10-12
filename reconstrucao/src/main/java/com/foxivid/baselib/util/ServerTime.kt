package com.foxivid.baselib.util

import android.content.Context
import com.foxivid.baselib.config.BaseLibConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.Locale

/**
 * Relógio do app: diferença para o horário do servidor + relógio monotônico.
 * Original: x1/f1/lb/util/d1.java (classe Java) + d1$a (relógio padrão) + lambda c1.
 */
object ServerTime {
    private val logger: Logger = LoggerFactory.getLogger(ServerTime::class.java)

    /** `System.currentTimeMillis()` no carregamento da classe. Original: `f21378b`. */
    private val processStartTime = System.currentTimeMillis()

    /** servidor − local (ms). Original: `f21379c`, persistido em `server-time-diff`. */
    @Volatile
    private var serverTimeDiff = 0L

    /** Relógio monotônico; padrão: ms desde a criação (baseado em currentTimeMillis). Original: d1$a. */
    private var clock: ElapsedClock = object : ElapsedClock {
        val start = System.currentTimeMillis()
        override fun elapsed(): Long = System.currentTimeMillis() - start
    }
    private var clockBase = clock.elapsed()

    /**
     * Duração legível com sinal: "%.1f s/m/h/d" (unidades de `R.string.dur_*` se houver contexto).
     * Original: `d1.b(long, Context)`.
     */
    @JvmStatic
    fun formatDuration(millis: Long, context: Context?): String {
        var ms = millis
        var sign = ""
        if (ms < 0) { ms = -ms; sign = "-" }
        val s = ms / 1000f
        if (s < 60f) return String.format(Locale.getDefault(), "%s%.1f %s", sign, s, context?.getString(R.string.dur_seconds) ?: "s")
        val m = s / 60f
        if (m < 60f) return String.format(Locale.getDefault(), "%s%.1f %s", sign, m, context?.getString(R.string.dur_minutes) ?: "m")
        val h = m / 60f
        if (h < 24f) return String.format(Locale.getDefault(), "%s%.1f %s", sign, h, context?.getString(R.string.dur_hours) ?: "h")
        return String.format(Locale.getDefault(), "%s%.1f %s", sign, h / 24f, context?.getString(R.string.dur_days) ?: "d")
    }

    /** Hora local monotônica: início do processo + tempo decorrido no [clock]. Original: `d1.c()`. */
    @JvmStatic
    fun elapsedNow(): Long = processStartTime + (clock.elapsed() - clockBase)

    /**
     * Instala um relógio monotônico (ex.: `SystemClock.elapsedRealtime`) e carrega a diferença salva
     * (`server-time-diff`) das preferências. Original: `d1.e(k0)`.
     */
    @JvmStatic
    fun init(newClock: ElapsedClock?) {
        if (newClock != null) {
            clock = newClock
            clockBase = newClock.elapsed()
        }
        Preferences.getLong("server-time-diff", { v -> serverTimeDiff = v }, 0L)
    }

    /**
     * Sincroniza com o horário de resposta do servidor (estilo NTP simplificado):
     * `diff = serverTime − (requestTime + rtt/2)`. Ignora rtt negativo e serverTime ≤ 0.
     * (A diferença não é persistida aqui.) Original: `d1.f(String, long now, long requestTime, long serverTime)`.
     */
    @JvmStatic
    fun sync(tag: String, now: Long, requestTime: Long, serverTime: Long) {
        val rtt = now - requestTime
        if (rtt < 0) {
            logger.warn(
                "{} server time sync, invalid round trip delay[{}], ignored, requestTime[{}], responseTime[{}], now[{}]",
                tag, rtt, requestTime, serverTime, now,
            )
            return
        }
        if (serverTime <= 0) {
            logger.error("{} server time sync, invalid server response time", tag, serverTime)
            return
        }
        val diff = serverTime - (requestTime + (rtt shr 1))
        serverTimeDiff = diff
        if (BaseLibConfig.isDebug) {
            logger.debug(
                "{} server time sync, requestTime[{}], responseTime[{}], now[{}], roundTripDelay[{}], timeDiff[{}]",
                tag, requestTime, serverTime, now, rtt, diff,
            )
        }
    }

    /** Hora atual estimada do servidor. Original: `d1.d()`. */
    @JvmStatic
    fun now(): Long = System.currentTimeMillis() + serverTimeDiff
}
