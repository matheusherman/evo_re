package com.live.evo.boot

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

/**
 * Pool de threads de uso geral ("AsyncExecutor #N"): core = max(2, min(CPUs-1, 4)), max = 2*CPUs+1,
 * keep-alive 30 s com timeout de core, fila de 128. Tarefas engolem exceções.
 * Original: com/live/evo/boot/a.java
 */
object AsyncExecutor {
    private val cpus = Runtime.getRuntime().availableProcessors()
    private val core = Math.max(2, Math.min(cpus - 1, 4))
    private val maxPool = cpus * 2 + 1
    private val factory = object : ThreadFactory {
        private val n = AtomicInteger(1)
        override fun newThread(r: Runnable) = Thread(r, "AsyncExecutor #" + n.getAndIncrement())
    }
    val executor: ThreadPoolExecutor = ThreadPoolExecutor(core, maxPool, 30L, TimeUnit.SECONDS, LinkedBlockingQueue(128), factory).apply { allowCoreThreadTimeOut(true) }

    /** Original: a(Runnable) */
    fun execute(r: Runnable) { executor.execute { try { r.run() } catch (_: Exception) {} } }
}
