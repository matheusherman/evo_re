package com.live.evo.util

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.processors.BehaviorProcessor
import io.reactivex.rxjava3.processors.FlowableProcessor
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit

/**
 * Barramento de eventos global (EventBus sobre RxJava3). `post` empurra qualquer objeto;
 * `observe(Class)` filtra pelo tipo.
 * Original: com/live/evo/util/j1.java
 */
class RxBus private constructor() {
    private val subject: FlowableProcessor<Any> = BehaviorProcessor.create<Any>().toSerialized()

    /** Original: b(Object) */
    fun post(event: Any) = subject.onNext(event)

    /** Original: c(Class) */
    fun <T : Any> observe(type: Class<T>): Flowable<T> = subject.ofType(type)

    companion object {
        @Volatile private var instance: RxBus? = null
        /** Original: a() */
        fun get(): RxBus = instance ?: synchronized(this) { instance ?: RxBus().also { instance = it } }
    }
}

/**
 * Helpers de execução em thread IO/UI via corrotinas (originalmente "RxUtils.kt").
 * Original: com/live/evo/util/k1.java
 */
object RxUtils {
    private val logger = LoggerFactory.getLogger(RxUtils::class.java)
    private val ioScope = CoroutineScope(Dispatchers.IO)

    /** Roda [action] em Dispatchers.IO. Original: b(Runnable) */
    fun runOnIOThread(action: Runnable) {
        ioScope.launch { try { action.run() } catch (t: Throwable) { logger.error("run on io error", t) } }
    }

    /** Roda no main (direto se já na main thread). Original: c(Runnable) */
    fun runOnUiThread(action: Runnable) = runOnUiThread(action, false)

    /** Se [forcePost] ou fora da main thread, posta em Dispatchers.Main. Original: d(Runnable, boolean) */
    fun runOnUiThread(action: Runnable, forcePost: Boolean) {
        if (Looper.myLooper() != Looper.getMainLooper() || forcePost) {
            CoroutineScope(Dispatchers.Main).launch { try { action.run() } catch (t: Throwable) { logger.error("run on ui failure", t) } }
        } else {
            action.run()
        }
    }
}

/**
 * Ticker de 1 segundo compartilhado (`interval(1,1,SECONDS)` publicado e "refcount").
 * Original: com/live/evo/util/m1.java
 */
object SecondTicker {
    private var shared: Flowable<Long>? = null

    /** Assina o ticker no scheduler [observeOn]. Original: b(Consumer, Consumer, Scheduler) */
    @Synchronized
    fun subscribe(onTick: Consumer<Long>, onError: Consumer<Throwable>, observeOn: io.reactivex.rxjava3.core.Scheduler): Disposable {
        if (shared == null) shared = Flowable.interval(1L, 1L, TimeUnit.SECONDS).publish().refCount()
        return shared!!.observeOn(observeOn).subscribe(onTick, onError)
    }
}

/**
 * Timer de "gatilho" com debounce: um Flowable de inteiros com timeout (ms) disparado por [trigger].
 * Original: com/live/evo/util/i1.java (nome sugerido RxTrigger)
 */
class RxTrigger(timeoutMs: Int) {
    private var emitter: io.reactivex.rxjava3.core.FlowableEmitter<Int>? = null
    private var disposable: Disposable? = null
    private val source: Flowable<Int> = Flowable.create<Int>({ emitter = it }, io.reactivex.rxjava3.core.BackpressureStrategy.BUFFER)
        .subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).debounce(timeoutMs.toLong(), TimeUnit.MILLISECONDS)

    /** Original: c() */ fun trigger() { emitter?.onNext(1) }
    /** Original: d(Consumer) */ fun subscribe(consumer: Consumer<Int>) { disposable = source.subscribe(consumer) }
    /** Original: e() */ fun dispose() { disposable?.dispose() }
}

/**
 * Executor em thread única ("tortoise work thread #0") para trabalho agendado.
 * Original: com/live/evo/util/t1.java (nome sugerido WorkHandler)
 */
class WorkHandler private constructor() {
    private val threads = arrayOf(HandlerThread("tortoise work thread #0"))
    private val handlers = arrayOfNulls<Handler>(1)

    init {
        threads[0].start()
        handlers[0] = Handler(threads[0].looper)
    }

    /** Original: b(Runnable, int trace, long delay) */
    fun postDelayed(r: Runnable, trace: Int, delay: Long): Boolean {
        if (trace < 1) return handlers[trace]!!.postDelayed(r, delay)
        throw RuntimeException("trace not exists")
    }
    /** Original: c(Runnable, long) */ fun postDelayed(r: Runnable, delay: Long) = postDelayed(r, 0, delay)
    /** Original: d(Runnable) */ fun remove(r: Runnable) = remove(r, 0)
    /** Original: e(Runnable, int) */
    fun remove(r: Runnable, trace: Int) {
        if (trace >= 1) throw RuntimeException("trace not exists")
        handlers[trace]!!.removeCallbacks(r)
    }

    companion object {
        @Volatile private var instance: WorkHandler? = null
        /** Original: a() */
        fun get(): WorkHandler = instance ?: synchronized(this) { instance ?: WorkHandler().also { instance = it } }
    }
}
