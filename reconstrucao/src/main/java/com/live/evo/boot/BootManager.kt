package com.live.evo.boot

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

/**
 * Sincronização de etapas do boot: 7 checkpoints (0..6) começam "pendentes"; ações registradas ([WaitingMan])
 * executam quando todos os checkpoints de que dependem foram liberados.
 * Uso conhecido: LiveLoadActivity libera o checkpoint 4 em initRuntimeEnv.
 *
 * Original: com/live/evo/boot/b.java (nome real BootManager, do metadata de corrotina BootManager.kt)
 */
object BootManager {
    private val mCheckpoints: MutableMap<Int, Boolean> = HashMap<Int, Boolean>().apply { (0..6).forEach { put(it, false) } }
    private val mWaitingManList: MutableList<WaitingMan> = ArrayList()
    private val mLock = Any()

    /** Ação aguardando condições. Original: BootManager$a */
    class WaitingMan(val conditions: Set<Int>?, val action: Runnable?, val threadMode: ThreadMode?)

    /** true se nenhum checkpoint (>=0) da lista estiver pendente. Original: b(Set) */
    fun checkpoints(checkpoints: Set<Int>?): Boolean {
        if (checkpoints == null) return false
        for (cp in checkpoints) {
            val v = mCheckpoints[cp]
            if (cp >= 0 && v != null && !v) return false
        }
        return true
    }

    /**
     * Executa (e remove) os WaitingMan que dependem de [what] e estão satisfeitos.
     * MAIN/MAIN_ORDERED → main; ASYNC/BACKGROUND → Dispatchers.IO; null/POSTING → inline. Original: c(int)
     */
    private fun dispatch(what: Int) {
        for (i in mWaitingManList.indices.reversed()) {
            val man = mWaitingManList[i]
            if (man.conditions!!.contains(what) && checkpoints(man.conditions)) {
                mWaitingManList.removeAt(i)
                when (man.threadMode) {
                    ThreadMode.MAIN, ThreadMode.MAIN_ORDERED -> MainScope().launch { man.action?.run() }
                    ThreadMode.ASYNC, ThreadMode.BACKGROUND -> CoroutineScope(Dispatchers.IO).launch { man.action?.run() }
                    else -> man.action?.run()
                }
            }
        }
    }

    /** Libera o checkpoint. Original: a(int) */
    fun release(what: Int) = synchronized(mLock) {
        mCheckpoints[what] = true
        dispatch(what)
    }
}

/**
 * Pool "AsyncExecutor #N": core = max(2, min(cpus-1, 4)), máx = 2*cpus+1, keep-alive 30 s, fila 128,
 * CallerRunsPolicy; exceções das tarefas são engolidas.
 *
 * Original: com/live/evo/boot/a.java
 */
object AsyncExecutor {
    private val cpus = Runtime.getRuntime().availableProcessors()
    private val threadFactory = object : ThreadFactory {
        private val count = AtomicInteger(1)
        override fun newThread(r: Runnable) = Thread(r, "AsyncExecutor #" + count.getAndIncrement())
    }
    val executor: ThreadPoolExecutor = ThreadPoolExecutor(
        maxOf(2, minOf(cpus - 1, 4)), cpus * 2 + 1, 30L, TimeUnit.SECONDS,
        LinkedBlockingQueue(128), threadFactory, ThreadPoolExecutor.CallerRunsPolicy(),
    ).apply { allowCoreThreadTimeOut(true) }

    /** Original: a(Runnable) */
    fun execute(r: Runnable) = executor.execute { try { r.run() } catch (_: Exception) { } }
}
