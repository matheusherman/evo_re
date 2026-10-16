package com.foxivid.baselib.feedback

import com.foxivid.baselib.network.HeaderInterceptor
import android.os.Process
import android.text.TextUtils
import com.foxivid.baselib.user.UserManager
import com.foxivid.baselib.util.AppAttrUtils
import com.foxivid.baselib.util.Clock
import com.foxivid.baselib.util.LoggerFactory
import com.foxivid.baselib.util.StoragePaths
import com.foxivid.baselib.model.feedback.FeedbackUploadResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.io.DataOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.zip.GZIPOutputStream

/**
 * Captura de logcat do próprio processo + empacotamento gzip + upload de feedback.
 *
 * Original: x1/f1/lb/feedback/c.java (nome Kotlin original `LogCatHelper.kt`)
 *
 * Disparado pelo usuário (tela de feedback) ou remotamente pela propriedade `feedback_exe_did`
 * (ver [com.foxivid.baselib.heartbeat.AppPropertyHandlers]).
 *
 * Upload: `UserManager.uploadFeedback(file)` (user/f.N1) → `PTVApi3AClient.p` →
 * `FeedbackApi` POST multipart `/api/feedback/upload/v1` com partes `tenantId`, `uid`, `did`,
 * `requestTime` e o arquivo.
 *
 * Códigos devolvidos ao callback: "-2" sem arquivo de log, "-3" falha ao gerar .gz,
 * "-4" resposta nula, "-5" exceção no upload; senão o `code` da resposta (`data == true` = sucesso).
 */
object LogCatHelper {
    private val logger = LoggerFactory.getLogger(LogCatHelper::class.java)

    /** Original: c.dirPath */
    private var dirPath: String? = null

    /** Original: c.h() — diretório de logs (StoragePaths.logDir, fallback cacheDir). */
    private fun ensureDir() {
        if (dirPath == null) {
            var p = StoragePaths.logDir() + File.separator
            val f = File(p)
            if (!f.exists() && !f.mkdirs()) p = StoragePaths.cacheDir() + File.separator
            dirPath = p
        }
    }

    /**
     * Captura o logcat para arquivo.
     *
     * Comandos enviados ao shell (`su` ou `sh`):
     * ```
     * logcat -P '<pid>'                                  # põe o pid na whitelist de prune do logd
     * logcat -v threadtime [-d] > <arquivo> [&]          # -d (dump e sai) se executeTime <= 0
     * # se executeTime > 0: espera executeTime s e mata os logcat:
     * ps|grep logcat|awk -F' ' {'print "kill "$2'}|sh
     * ps -ef|grep logcat|awk -F' ' {'print "kill "$2'}|sh
     * chmod 777 <arquivo>
     * logcat -P ''                                       # limpa a whitelist
     * exit
     * ```
     * Nome padrão: `logcat-<appDistributionChannel?>-<brandId>-<timestamp>.log` (of.a.e()/of.a.d()).
     *
     * Original: c.k(boolean, int, String)
     */
    fun captureLogcat(withSu: Boolean, executeTime: Int, fileName: String?): File? {
        var out: DataOutputStream? = null
        try {
            ensureDir()
            val pidCmd = String.format("logcat -P '%s'", Process.myPid())
            var logcatCmd = "logcat -v threadtime"
            var dumpOnly = false
            if (executeTime <= 0) {
                logcatCmd = "logcat -v threadtime -d"
                dumpOnly = true
            }
            val path = if (TextUtils.isEmpty(fileName))
                dirPath + "logcat-" + HeaderInterceptor.mac() + "-" + HeaderInterceptor.brandId() + "-" + Clock.now() + ".log"
            else fileName!!
            val process = (if (withSu) ProcessBuilder("su") else ProcessBuilder("sh")).redirectErrorStream(true).start()
            out = DataOutputStream(process.outputStream)
            out.writeBytes(pidCmd); out.writeBytes("\n")
            out.writeBytes(logcatCmd + " > " + path + (if (dumpOnly) "" else " &")); out.writeBytes("\n")
            out.flush()
            if (executeTime > 0) {
                CountDownLatch(1).await(executeTime.toLong(), TimeUnit.SECONDS)
                out.writeBytes("ps|grep logcat|awk -F' ' {'print \"kill \"\$2'}|sh\n")
                out.writeBytes("ps -ef|grep logcat|awk -F' ' {'print \"kill \"\$2'}|sh\n")
            }
            out.writeBytes("chmod 777 $path"); out.writeBytes("\n")
            out.writeBytes("logcat -P ''"); out.writeBytes("\n")
            out.writeBytes("exit\n")
            out.flush()
            out.close()
            process.waitFor()
            return File(path)
        } catch (e: Exception) {
            logger.error(e.message, e)
            return null
        } finally {
            try { out?.close() } catch (e: Exception) { e.printStackTrace() }
        }
    }

    /** Original: c.l(int) + c$a */
    fun startLog(executeTime: Int): Flow<File?> = flow { emit(captureLogcat(false, executeTime, null)) }

    /**
     * Captura (sem su) e envia. Após o upload apaga o .log, o .gz e todos os *.log da pasta.
     *
     * Original: c.m(int, c9.p) + c$b
     */
    fun startLogAndUpload(executeTime: Int, callback: (Boolean, String?) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val logFile = startLog(executeTime).firstOrNull()
            if (logFile == null || !logFile.exists()) { callback(false, "-2"); return@launch }
            val gz = gzipLogs(File(StoragePaths.logDir()), logFile, true)
            if (gz == null || !gz.exists()) { logFile.delete(); callback(false, "-3"); return@launch }
            try {
                val resp: FeedbackUploadResponse? = UserManager.uploadFeedbackFile(gz).firstOrNull()
                logger.info("upload response {$resp}")
                when {
                    resp == null -> callback(false, "-4")
                    resp.data == true -> callback(true, resp.code)
                    else -> callback(false, resp.code)
                }
            } catch (e: Exception) {
                logger.error("upload file error $e")
                callback(false, "-5")
            }
            logFile.delete()
            gz.delete()
            deleteLogs(File(StoragePaths.logDir()))
        }
    }

    /**
     * Concatena num único `<logcat>.gz`: todos os outros `*.log` da pasta, depois o logcat atual e,
     * se legível, `/data/anr/traces.txt` (ANR traces).
     *
     * Original: c.f(File, File, boolean) (+ filtro c.g)
     */
    private fun gzipLogs(folder: File, logcatFile: File, withTraceFile: Boolean): File? {
        if (!folder.exists() || !folder.isDirectory) return null
        val others = folder.listFiles { f -> f.isFile && f.name.endsWith(".log", true) && f.name != logcatFile.name } ?: emptyArray()
        val gz = File(logcatFile.parent, logcatFile.name + ".gz")
        try {
            FileOutputStream(gz).use { fos ->
                GZIPOutputStream(fos).use { zos ->
                    val buf = ByteArray(4096)
                    fun copy(f: File) = FileInputStream(f).use { ins ->
                        while (true) { val n = ins.read(buf); if (n == -1) break; zos.write(buf, 0, n) }
                    }
                    others.forEach { copy(it) }
                    copy(logcatFile)
                    if (withTraceFile) {
                        val traces = File("/data/anr/traces.txt")
                        if (traces.exists() && traces.canRead()) copy(traces)
                    }
                }
            }
            return gz
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    /** Original: c.i(File) (+ filtro c.j) — apaga todos os *.log. */
    private fun deleteLogs(folder: File) {
        try {
            (folder.listFiles { f -> f.isFile && f.name.endsWith(".log", true) } ?: emptyArray()).forEach { it.delete() }
        } catch (e: Exception) { e.printStackTrace() }
    }
}
