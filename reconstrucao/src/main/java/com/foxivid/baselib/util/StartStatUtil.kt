package com.foxivid.baselib.util

import com.foxivid.baselib.config.BaseLibConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentSkipListMap

/**
 * Cronometragem de etapas (apenas em debug): tempo de inicialização do app ("AppStartTimeStat")
 * e tempo de zapping/início de reprodução por sessão ("PlayZappingTimeStat[sessão]").
 * Cada etapa é registrada com [ServerTime.elapsedNow]; na etapa final a tabela é logada e limpa.
 * Original: x1/f1/lb/util/a1.java (nome Kotlin original `StartStatUtil`).
 */
object StartStatUtil {
    private val logger: Logger = LoggerFactory.getLogger(StartStatUtil::class.java)
    private val statMap = ConcurrentHashMap<String, ConcurrentSkipListMap<Long, String>>()
    private val playMap = ConcurrentHashMap<Long, ConcurrentSkipListMap<Long, String>>()
    private val mutex = Mutex()

    /**
     * Loga a tabela: "%06d" acumulado e "% 4d" delta (ambos /1000), horário e nome da etapa.
     * Original: `a1.k(String, ConcurrentSkipListMap)`.
     */
    fun dump(statKey: String, map: ConcurrentSkipListMap<Long, String>) {
        if (!BaseLibConfig.isDebug) return
        val sb = StringBuilder()
        var last = 0L
        var total = 0L
        for ((ts, step) in map) {
            val delta = if (last > 0) (ts - last).also { total += it } else 0L
            sb.append(String.format("%06d ", total / 1000))
            sb.append(String.format("% 4d", delta / 1000))
            sb.append(": (@").append(LegacyTvUtils.getInstance().formatTime(10, ts)).append(") ")
            sb.append(step).append("\n")
            last = ts
        }
        logger.debug("$statKey:\n{}", sb.toString())
    }

    /** Etapa de zapping de uma sessão de reprodução. Original: `a1.e(long, String, boolean)` (`StartStatUtil$addStep$1`). */
    fun addStep(session: Long, step: String, isFinal: Boolean = false) {
        if (!BaseLibConfig.isDebug) return
        CoroutineScope(Dispatchers.IO).launch {
            val map = playMap[session] ?: mutex.withLock {
                playMap[session] ?: ConcurrentSkipListMap<Long, String>().also { playMap[session] = it }
            }
            map[ServerTime.elapsedNow()] = step
            if (isFinal) {
                dump("PlayZappingTimeStat[$session]", map)
                map.clear()
            }
        }
    }

    /** Etapa da inicialização do app. Original: `a1.f(String)`. */
    fun addStep(step: String) = addStep("AppStartTimeStat", step, false)

    /** Etapa numa estatística nomeada. Original: `a1.g(String, String, boolean)` (`StartStatUtil$addStep$2`). */
    fun addStep(statKey: String, step: String, isFinal: Boolean = false) {
        if (!BaseLibConfig.isDebug) return
        CoroutineScope(Dispatchers.IO).launch {
            val map = statMap[statKey] ?: mutex.withLock {
                statMap[statKey] ?: ConcurrentSkipListMap<Long, String>().also { statMap[statKey] = it }
            }
            map[ServerTime.elapsedNow()] = step
            if (isFinal) {
                dump(statKey, map)
                map.clear()
            }
        }
    }

    /** Remove e loga uma sessão inacabada. Original: `a1.j(long)`. */
    fun clearSession(session: Long) {
        val m = playMap.remove(session)
        if (m == null || m.isEmpty()) return
        dump("PlayZappingTimeStat(clear)[$session]", m)
    }
}
