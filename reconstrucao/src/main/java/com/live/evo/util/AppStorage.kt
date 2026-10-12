package com.live.evo.util

import android.content.Context
import android.content.SharedPreferences
import android.os.Environment
import androidx.core.content.ContextCompat
import com.live.evo.MyApplication
import com.live.evo.event.SavePlayHistoryEvent
import java.io.File

/**
 * Posição de reprodução e flags simples em SharedPreferences.
 * - "vod_history"/"play_pos" = "categoria,canal,posicaoGlobal" (padrão "0,0,0");
 *   ao salvar, publica [SavePlayHistoryEvent] (b5.h) no [RxBus].
 * - "recharge"/"last_recharge_remind_time" e "first_time_key"/"first_time".
 *
 * Original: com/live/evo/util/b2.java (nome sugerido: PlaybackPrefs)
 */
object PlaybackPrefs {
    private val prefs: SharedPreferences = MyApplication.get().getSharedPreferences("vod_history", 0)
    private var playPos: String = prefs.getString("play_pos", "")!!.ifEmpty { "0,0,0" }.let {
        if (!it.contains(",")) "0,0,$it" else it
    }

    /** Salva "[category],[channel],[position]" (ignora posição < 0) e avisa observers. Original: a(String,String,long) */
    fun save(category: String, channel: String, position: Long) {
        if (position < 0) return
        playPos = "$category,$channel,$position"
        prefs.edit().putString("play_pos", playPos).apply()
        RxBus.get().post(SavePlayHistoryEvent(category.toInt(), channel.toInt(), position.toInt()))
    }

    /** Original: b() */
    fun lastPosition(): String {
        if (playPos.isNotEmpty()) return playPos
        playPos = prefs.getString("play_pos", "0,0,0")!!
        if (!playPos.contains(",")) playPos = "0,0,$playPos"
        return playPos
    }

    /** Original: c(Context) */
    fun lastRechargeRemindTime(context: Context): Long =
        context.getSharedPreferences("recharge", 0).getLong("last_recharge_remind_time", 0L)

    /** Original: d(Context) */
    fun isFirstTime(context: Context): Boolean =
        context.getSharedPreferences("first_time_key", 0).getBoolean("first_time", true)

    /** Alias usado por LiveLoadActivity. Original: d(Context) */
    fun isFirstLaunch(context: Context): Boolean = isFirstTime(context)

    /** Alias usado por LiveLoadActivity. Original: e(Context, Boolean) */
    fun setFirstLaunch(context: Context, value: Boolean) = setFirstTime(context, value)

    /** Original: e(Context, Boolean) */
    fun setFirstTime(context: Context, value: Boolean) {
        context.getSharedPreferences("first_time_key", 0).edit().putBoolean("first_time", value).commit()
    }
}

/**
 * Diretórios do app (armazenamento externo e interno).
 * Original: com/live/evo/util/n1.java
 */
object AppDirs {
    private const val ROOT_NAME = "tv_cinema"
    private val externalRoot = Environment.getExternalStorageDirectory().absolutePath + File.separator
    val sdcardAppDir = externalRoot + ROOT_NAME + File.separator                          // c
    val hiddenDir = externalRoot + ".Rxst" + File.separator                                // d
    val hiddenAppDir = hiddenDir + "com.live.evo" + File.separator                         // e
    val hiddenAppFile = hiddenAppDir + "com.live.evo"                                      // f
    val internalDir = ContextCompat.getDataDir(MyApplication.get())!!.absolutePath + File.separator + ROOT_NAME + File.separator // g
    val logDir = internalDir + "log" + File.separator
    val plogDir = internalDir + "plog" + File.separator
    val crashDir = internalDir + "crash" + File.separator
    val debuglyDir = internalDir + "debugly" + File.separator
    val rdnsDir = internalDir + "rdns" + File.separator

    /** Alias. Original: a() */
    fun cleanup() = clearLogs()

    /** Apaga plog e debugly (usa org.apache.commons.io `yb.c.k`). Original: a() */
    fun clearLogs() {
        try { File(plogDir).deleteRecursively(); File(debuglyDir).deleteRecursively() } catch (_: Exception) {}
    }

    /** Cache externo se montado, senão interno. Original: b() */
    fun cacheDir(): File? =
        if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) MyApplication.get().externalCacheDir
        else MyApplication.get().cacheDir
}

/** Remoção recursiva de arquivos/diretórios. Original: com/live/evo/util/r.java (a=delete, b=deleteDir, c=deleteFile) */
object FileUtils {
    fun delete(path: String): Boolean {
        val f = File(path)
        return if (f.exists()) (if (f.isFile) deleteFile(path) else deleteDir(path)) else false
    }
    fun deleteDir(path: String): Boolean {
        val p = if (path.endsWith(File.separator)) path else path + File.separator
        val dir = File(p)
        if (!dir.exists() || !dir.isDirectory) return false
        var ok = true
        for (f in dir.listFiles().orEmpty()) {
            ok = if (f.isFile) deleteFile(f.absolutePath) else if (f.isDirectory) deleteDir(f.absolutePath) else ok
            if (!ok) break
        }
        return ok && dir.delete()
    }
    fun deleteFile(path: String): Boolean {
        if (path.isEmpty()) return false
        val f = File(path)
        return f.exists() && f.isFile && f.delete()
    }
}
