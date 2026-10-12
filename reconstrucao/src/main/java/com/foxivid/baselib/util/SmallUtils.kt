@file:Suppress("unused")

package com.foxivid.baselib.util

import android.content.Context
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.host.ServerProviderUtils
import org.greenrobot.eventbus.EventBus
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext

/*
 * Utilitários pequenos do baselib agrupados num único arquivo.
 * Log: o original usa a fachada interna `q6` (estilo SLF4J); aqui representada pela API SLF4J.
 */

/**
 * Callback genérico de valor único.
 * Original: x1/f1/lb/util/m.java (`a(V)`).
 */
fun interface Callback<V> {
    fun onResult(value: V)
}

/**
 * Callback com caminho de falha.
 * Original: x1/f1/lb/util/g0.java (`b(Throwable)`; herda `a(V)` de [Callback]).
 */
interface ResultCallback<V> : Callback<V> {
    fun onFailure(throwable: Throwable)
}

/**
 * Relógio monotônico (ms decorridos). Original: x1/f1/lb/util/k0.java (`b()`).
 */
fun interface ElapsedClock {
    fun elapsed(): Long
}

/**
 * Formata taxa de bits.
 * Original: x1/f1/lb/util/z0.java
 */
object BitrateFormatter {
    /** Original: `z0.a(long)` — divide por 1024; acima de 1023 Kb/s mostra "%.2fMb/s". */
    fun format(bps: Long): String {
        val kb = bps / 1024.0
        return if (kb > 1023.0) String.format("%.2fMb/s", kb / 1024.0)
        else String.format("%dKb/s", kb.toInt())
    }
}

/**
 * Mascara o miolo de um código com '*'.
 * Original: x1/f1/lb/util/l.java
 */
object MaskUtils {
    /**
     * Original: `l.a(String)`. Mascara os índices `[len/4 - 1, len/2)`.
     * Nota de fidelidade: o original retorna `Character[].toString()` (o "toString" do array,
     * algo como `[Ljava.lang.Character;@1a2b3c`), ou seja, é um bug — reproduzido aqui.
     */
    fun mask(code: String?): String {
        if (code == null) return ""
        val q = code.length / 4
        if (q <= 0) return code
        val start = q - 1
        val end = q shl 1
        val chars = arrayOfNulls<Char>(code.length)
        for (i in code.indices) {
            chars[i] = if (i < start || i >= end) code[i] else '*'
        }
        return chars.toString() // bug original preservado
    }
}

/**
 * Monta URLs de imagens a partir dos servidores `IMG_SERVERS`.
 * Original: x1/f1/lb/util/l0.java
 */
object ImageUrlBuilder {
    /** Original: `l0.a(String)` — prefixa o primeiro servidor de imagem ao caminho (trim). */
    fun build(path: String?): String {
        val p = path?.trim() ?: ""
        val servers = imageServers()
        if (servers.isEmpty()) return p
        return if (p.startsWith("/")) servers[0] + p else servers[0] + "/" + p
    }

    /** Original: `l0.b()` — lista `IMG_SERVERS` do [ServerProviderUtils]. */
    fun imageServers(): List<String> = ServerProviderUtils.getServers("IMG_SERVERS") ?: ArrayList()
}

/**
 * Animações utilitárias. Original: x1/f1/lb/util/d.java
 */
object AnimUtils {
    /** Gira a view 360° continuamente (1280 ms por volta, linear). Original: `d.a(View)`. */
    fun startRotate(iv: View) {
        val anim = RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        anim.duration = 1280L
        anim.interpolator = LinearInterpolator()
        anim.repeatCount = -1
        iv.startAnimation(anim)
    }
}

/**
 * Registro seguro no EventBus (greenrobot, ofuscado como `xe.c`).
 * Original: x1/f1/lb/util/e0.java
 */
object EventBusUtils {
    private val logger: Logger = LoggerFactory.getLogger(EventBusUtils::class.java)

    /** Original: `e0.a(Object)`. */
    fun register(subscriber: Any) {
        if (EventBus.getDefault().isRegistered(subscriber)) return
        try {
            EventBus.getDefault().register(subscriber)
        } catch (t: Throwable) {
            logger.error("register event bus failure", t)
        }
    }

    /** Original: `e0.b(Object)`. */
    fun unregister(subscriber: Any) {
        if (EventBus.getDefault().isRegistered(subscriber)) {
            try {
                EventBus.getDefault().unregister(subscriber)
            } catch (t: Throwable) {
                logger.error("unregister event bus failure", t)
            }
        }
    }
}

/**
 * Loga exceções não tratadas (usado como handler de corrotinas/threads).
 * Original: x1/f1/lb/util/f0.java (classe Java)
 */
object UncaughtLogger {
    private val logger: Logger = LoggerFactory.getLogger(UncaughtLogger::class.java)

    /** Original: `f0.a(Throwable)`. */
    @JvmStatic
    fun log(t: Throwable) = log(null, t)

    /** Original: `f0.b(CoroutineContext, Throwable)`. */
    @JvmStatic
    fun log(context: CoroutineContext?, t: Throwable) {
        logger.error("uncaught exception, context[{}]", context, t)
    }
}

/**
 * Leitura segura de strings de recurso. Original: x1/f1/lb/util/u0.java
 */
object ResStrings {
    private val logger: Logger = LoggerFactory.getLogger(ResStrings::class.java)

    /** Original: `u0.a(int, String)`. */
    fun get(resId: Int, dft: String = ""): String = try {
        BaseLibConfig.appContext?.getString(resId) ?: dft
    } catch (t: Throwable) {
        logger.error("getString failure", t)
        dft
    }
}

/**
 * Janela de DVR (catch-up) e títulos de dias da semana.
 * Original: x1/f1/lb/util/c0.java
 */
object DvrUtils {
    private var lastDvrDays = 0
    private var dvrKeepMillis = 0L

    /**
     * Títulos curtos dos dias. Nota de fidelidade: a 5ª posição (quinta-feira) usa
     * `R.string.tuesday` no original (bug), e não `thursday`.
     */
    val WEEKDAY_TITLE = intArrayOf(
        R.string.sunday, R.string.monday, R.string.tuesday, R.string.wednesday,
        R.string.tuesday, R.string.friday, R.string.saturday,
    )

    /** Títulos longos (`*_f`), com o mesmo bug na quinta-feira. */
    val WEEKDAY_TITLE_F = intArrayOf(
        R.string.sunday_f, R.string.monday_f, R.string.tuesday_f, R.string.wednesday_f,
        R.string.tuesday_f, R.string.friday_f, R.string.saturday_f,
    )

    /**
     * Instante mais antigo disponível no catch-up: agora (servidor) − `catchupDvrDays` dias.
     * Original: `c0.a()`.
     */
    fun earliestDvrTime(): Long {
        val now = ServerTime.now()
        if (dvrKeepMillis == 0L || BaseLibConfig.catchupDvrDays != lastDvrDays) {
            dvrKeepMillis = TimeUnit.DAYS.toMillis(BaseLibConfig.catchupDvrDays.toLong())
            lastDvrDays = BaseLibConfig.catchupDvrDays
        }
        return now - dvrKeepMillis
    }
}

/**
 * Utilitários de stack trace. Original: x1/f1/lb/util/q.java
 */
object StackTraceUtils {
    /** Original: `q.a(StackTraceElement[], StringBuilder)` — "Classe.metodo(Arquivo:linha)\n". */
    fun append(stackTraceElements: Array<StackTraceElement>, builder: StringBuilder) {
        for (e in stackTraceElements) {
            builder.append(e.className).append(".").append(e.methodName).append("(")
                .append(e.fileName).append(":").append(e.lineNumber).append(")\n")
        }
    }

    /** Descreve o chamador no índice [idx] da pilha (padrão 2). Original: `q.b(int)`. */
    fun caller(idx: Int = 2): String {
        val st = Exception().stackTrace
        if (st.size <= idx + 1) return ""
        val e = st[idx]
        return "${e.className}.${e.methodName}()@${e.lineNumber}:${e.fileName}"
    }

    /** Original: `q.d(Throwable)`. */
    fun toString(t: Throwable): String {
        val sb = StringBuilder()
        sb.append(t.javaClass.canonicalName).append(":").append(t.message).append("\n")
        append(t.stackTrace, sb)
        return sb.toString()
    }
}
