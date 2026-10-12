package com.foxivid.baselib.util

import android.content.Context
import android.os.Build
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.event.CrashLogEvent
import org.greenrobot.eventbus.EventBus
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.io.FileOutputStream
import java.io.PrintWriter
import java.io.StringWriter

/**
 * Handler global de exceções não tratadas: grava `crash_<horaServidor>.log` em
 * [AppPaths.crashLogPath] com versão do app + todos os campos de `android.os.Build` + stack
 * trace (com causas), posta `nf.y(path)` no EventBus e então delega ao handler padrão anterior.
 * Original: x1/f1/lb/util/q0.java (+ q0$a callback, lambda p0).
 */
open class CrashHandler : Thread.UncaughtExceptionHandler {
    private val defaultHandler: Thread.UncaughtExceptionHandler? = Thread.getDefaultUncaughtExceptionHandler()
    private val infos: MutableMap<String, String> = HashMap()

    /** Original: q0$a. */
    private fun interface DoneCallback {
        fun onDone(saved: Boolean)
    }

    override fun uncaughtException(thread: Thread, ex: Throwable) {
        handle({ _ -> defaultHandler?.uncaughtException(thread, ex) }, ex)
    }

    /** Original: `q0.d(a, Throwable)`. */
    private fun handle(cb: DoneCallback, ex: Throwable?) {
        logger.error("uncaught error", ex)
        if (ex == null) {
            cb.onDone(false)
            return
        }
        val dir = File(AppPaths.crashLogPath())
        if (!dir.isDirectory && !dir.mkdirs()) {
            logger.error("create directory failure:{}", dir.absolutePath, ex)
        }
        val file = File(dir, "crash_" + ServerTime.now() + ".log")
        EventBus.getDefault().post(CrashLogEvent(file.absolutePath))
        collectDeviceInfo(BaseLibConfig.appContext)
        writeReport(cb, ex, file)
    }

    /** Original: `q0.e(a, Throwable, File)`. */
    private fun writeReport(cb: DoneCallback, ex: Throwable, file: File) {
        val sb = StringBuilder()
        for ((k, v) in infos) sb.append(k).append("=").append(v).append("\n")
        val sw = StringWriter()
        val pw = PrintWriter(sw)
        ex.printStackTrace(pw)
        var cause = ex.cause
        while (cause != null) {
            cause.printStackTrace(pw)
            cause = cause.cause
        }
        pw.close()
        sb.append(sw)
        cb.onDone(saveToFile(file, sb.toString()))
    }

    /** versionName/versionCode + campos estáticos de Build ("null" se nulos). Original: `q0.b(Context)`. */
    fun collectDeviceInfo(context: Context?) {
        try {
            @Suppress("DEPRECATION")
            val pi = context!!.packageManager.getPackageInfo(context.packageName, 1)
            if (pi != null) {
                infos["versionName"] = pi.versionName ?: "null"
                @Suppress("DEPRECATION")
                infos["versionCode"] = pi.versionCode.toString()
            }
        } catch (_: Throwable) {
        }
        for (field in Build::class.java.declaredFields) {
            try {
                field.isAccessible = true
                infos[field.name] = field.get(null)?.toString() ?: "null"
            } catch (_: Throwable) {
            }
        }
    }

    /** Sobrescreve o arquivo e o deixa rwx. Original: `q0.f(File, String)`. */
    private fun saveToFile(file: File, content: String): Boolean {
        if (file.exists()) file.delete()
        return try {
            val out = FileOutputStream(file)
            out.write(content.toByteArray())
            if (file.isFile) {
                file.setReadable(true)
                file.setWritable(true)
                file.setExecutable(true)
            }
            try { out.close() } catch (_: Exception) {}
            true
        } catch (_: Exception) {
            false
        }
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(CrashHandler::class.java)
    }
}
