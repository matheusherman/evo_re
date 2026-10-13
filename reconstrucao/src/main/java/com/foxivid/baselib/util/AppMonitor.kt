package com.foxivid.baselib.util

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Process
import android.util.Printer
import android.view.Choreographer
import android.view.View
import android.view.ViewGroup
import com.foxivid.baselib.bot.TelegramBot
import com.foxivid.baselib.metric.monitor.PlayerMonitor
import com.foxivid.baselib.player.PlayerManager
import com.google.firebase.analytics.FirebaseAnalytics
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.ref.SoftReference
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong

/**
 * Monitor global do app: activity atual (SoftReference), estado resumed, provider do Firebase,
 * reinício do app, detecção de travamento do main thread (Looper Printer) e de queda de frames
 * (Choreographer), e um "loop protegido" no main looper.
 * Original: x1/f1/lb/util/c.java (+ c$a lifecycle callbacks, c$b Printer, c$c FrameCallback, lambda b).
 */
object AppMonitor {
    private val logger: Logger = LoggerFactory.getLogger(AppMonitor::class.java)

    private var callback: Application.ActivityLifecycleCallbacks? = null
    private var currentActivity: SoftReference<Activity>? = null
    private var currentIFirebaseAnalyticsProvider: FirebaseEvents.FirebaseAnalyticsProvider? = null

    /** Limite para logar tarefa lenta no main thread (ms). Padrão 300. */
    private var gtMainThreadBlockIntervalMilliSecondsLog = 300

    /** Limite de frames perdidos para logar. Padrão 10. */
    private var gtDroppedFramesLog = 10
    private var isActivityResumed = false

    /**
     * Callbacks de ciclo de vida. Destaque: `onActivityCreated` com `savedInstanceState != null`
     * (processo recriado pelo sistema) dispara [restartApp]. Original: c$a.
     */
    private class LifecycleCallbacks : Application.ActivityLifecycleCallbacks {
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            if (savedInstanceState != null) restartApp(activity)
        }

        override fun onActivityDestroyed(activity: Activity) {
            if (currentActivity?.get() == activity) currentActivity?.clear()
        }

        override fun onActivityPaused(activity: Activity) = setActivityResumed(false)

        override fun onActivityResumed(activity: Activity) {
            currentActivity = SoftReference(activity)
            setActivityResumed(true)
            if (activity is FirebaseEvents.FirebaseAnalyticsProvider) currentIFirebaseAnalyticsProvider = activity
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
        override fun onActivityStarted(activity: Activity) {}
        override fun onActivityStopped(activity: Activity) {}
    }

    /**
     * Mede o tempo entre ">>>>> Dispatching to Handler" e "<<<<< Finished to Handler" das mensagens
     * do main looper; loga (nível info) se > limite, no máximo 1x a cada 2 s. Original: c$b.
     */
    private class BlockPrinter(private val lastLog: AtomicLong) : Printer {
        var startWorkMillis = 0L
        override fun println(x: String) {
            if (x.startsWith(">>>>> Dispatching to Handler")) {
                startWorkMillis = ServerTime.elapsedNow()
                return
            }
            if (startWorkMillis <= 0 || !x.startsWith("<<<<< Finished to Handler")) return
            val now = ServerTime.elapsedNow()
            val cost = ServerTime.elapsedNow() - startWorkMillis
            if (cost <= gtMainThreadBlockIntervalMilliSecondsLog || now - lastLog.get() <= 2000) return
            lastLog.set(now)
            logger.info(String.format("main thread execution time is too long: [{} ms] task: %s", x), cost)
        }
    }

    /**
     * Calcula frames perdidos entre callbacks (frame ideal = 16 ms) e, se > limite (no máx. 1x/2 s),
     * loga activity, view com foco, view "do topo", se há player ativo e dados do stream atual.
     * Original: c$c.
     */
    private class FrameDropCallback(private val lastLog: AtomicLong) : Choreographer.FrameCallback {
        private var lastFrameTimeNanos = 0L
        private val idealFrameDurationNanos = TimeUnit.MILLISECONDS.toNanos(16)

        override fun doFrame(frameTimeNanos: Long) {
            if (lastFrameTimeNanos != 0L) {
                val now = ServerTime.elapsedNow()
                if (now - lastLog.get() > 2000) {
                    lastLog.set(now)
                    val dropped = ((frameTimeNanos - lastFrameTimeNanos - idealFrameDurationNanos) / idealFrameDurationNanos) - 1
                    if (dropped > gtDroppedFramesLog) {
                        val act = currentActivity?.get()
                        val canonicalName = act?.javaClass?.canonicalName
                        val focusView = describeView(act?.currentFocus)
                        val topView = describeView(findTopVisibleView(act?.window?.decorView))
                        // Original: widget/videoview/k.g() = getPlayer("main_player") (≠ null ⇒ tocando);
                        // metric/monitor/f.i() = zapping stat atual (tf.d); f.h() = monitor stat atual (tf.c).
                        val playing = PlayerManager.mainPlayer() != null
                        val zapping = PlayerMonitor.currentZappingStat()
                        val streamName = if (zapping != null) runCatching { zapping.playType.name }.getOrDefault("") else ""
                        val streamId = zapping?.streamId ?: ""
                        val monitor = PlayerMonitor.currentMonitorStat()
                        val blockIdx = monitor?.blockIndexCounter ?: -1 // tf.c.d()
                        val lastBlock = monitor?.lastBlockName ?: ""    // tf.c.j()
                        logger.warn(
                            "FrameDropMonitor Dropped frames[$dropped] [$playing][$streamName/$streamId/$lastBlock($blockIdx)] [$canonicalName] tv[$topView] fv[$focusView]",
                        )
                    }
                }
            }
            lastFrameTimeNanos = frameTimeNanos
            Choreographer.getInstance().postFrameCallback(this)
        }
    }

    /**
     * Reinicia o app: abre o launch intent com NEW_TASK|CLEAR_TASK (268468224), `finishAffinity` e
     * mata o processo. Original: `c.p(Context)`.
     */
    fun restartApp(context: Context?) {
        if (context == null) return
        logger.info("restartApp triggered by: " + context.javaClass.simpleName)
        val intent = context.packageManager.getLaunchIntentForPackage(context.packageName) ?: return
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)
        if (context is Activity) context.finishAffinity()
        Process.killProcess(Process.myPid())
    }

    /** Instala os monitores. Original: `c.t()`. */
    private fun startMonitors() {
        val lastLog = AtomicLong(0L)
        Looper.getMainLooper().setMessageLogging(BlockPrinter(lastLog))
        Handler(Looper.getMainLooper()).post { protectedMainLoop() }
        Choreographer.getInstance().postFrameCallback(FrameDropCallback(lastLog))
    }

    /** Sobe a cadeia de ContextWrapper até achar uma Activity. Original: `c.i(Context)`. */
    fun findActivity(context: Context?): Activity? {
        var ctx = context
        if (ctx is Activity) return ctx
        while (ctx is ContextWrapper) {
            if (ctx is Activity) return ctx
            ctx = ctx.baseContext
        }
        return null
    }

    /** Original: `c.j()`. */
    fun currentActivity(): Activity? = currentActivity?.get()

    /** Original: `c.k()`. */
    fun firebaseAnalytics(): FirebaseAnalytics? = currentIFirebaseAnalyticsProvider?.get()

    /** Última view folha visível (busca de trás para frente). Original: `c.l(View)`. */
    fun findTopVisibleView(view: View?): View? {
        if (view == null || view.visibility != View.VISIBLE) return null
        if (view is ViewGroup) {
            for (i in view.childCount - 1 downTo 0) {
                findTopVisibleView(view.getChildAt(i))?.let { return it }
            }
            return null
        }
        return view
    }

    /** "pacote.Classe#idName". Original: `c.m(View)`. */
    fun describeView(view: View?): String {
        if (view == null) return ""
        var s = ""
        try {
            s = view.javaClass.canonicalName ?: ""
            val entry = view.resources.getResourceEntryName(view.id)
            if (entry.isNotEmpty()) return "$s#$entry"
        } catch (_: Exception) {
        }
        return s
    }

    /** Registra os callbacks e inicia os monitores. Original: `c.n(Application)`. */
    fun init(application: Application) {
        val cb = LifecycleCallbacks()
        callback = cb
        application.registerActivityLifecycleCallbacks(cb)
        startMonitors()
    }

    /** Original: `c.o()`. */ fun isActivityResumed(): Boolean = isActivityResumed
    /** Original: `c.q(boolean)`. */ fun setActivityResumed(b: Boolean) { isActivityResumed = b }
    /** Original: `c.r(int)`. */ fun setDroppedFramesLogThreshold(frames: Int) { gtDroppedFramesLog = frames }
    /** Original: `c.s(int)`. */ fun setMainThreadBlockLogThreshold(milliSeconds: Int) { gtMainThreadBlockIntervalMilliSecondsLog = milliSeconds }

    /**
     * Executa `Looper.loop()` indefinidamente no main thread — "engole" exceções do main thread e continua.
     * Original: `c.u()` (confirmado no fallback do jadx). A cada `Throwable`: loga "main thread encounters
     * error:<stack>", envia ao bot ("UI thread failure\n<stack>" — `bot.a.o` = feedback), mostra toast longo
     * ("UI thread failure\n<message>") e, se a mensagem contém "Unable to start activity", mata o processo e sai.
     */
    private fun protectedMainLoop() {
        while (true) {
            try {
                Looper.loop()
            } catch (t: Throwable) {
                val stack = StackTraceUtils.toString(t) // util/q.d
                logger.error(String.format("main thread encounters error:%s", stack))
                TelegramBot.sendFeedback(String.format("UI thread failure\n%s", stack))
                ToastUtils.showLong(String.format("UI thread failure\n%s", t.message))
                if (t.message?.contains("Unable to start activity") == true) {
                    Process.killProcess(Process.myPid())
                    return
                }
            }
        }
    }
}
