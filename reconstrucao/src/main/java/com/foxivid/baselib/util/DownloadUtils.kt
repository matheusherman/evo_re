package com.foxivid.baselib.util

import android.annotation.SuppressLint
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.network.HttpClientFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.internal.closeQuietly
import org.apache.commons.io.FileUtils
import org.apache.commons.io.IOUtils
import org.apache.commons.lang3.StringUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.security.MessageDigest
import java.util.concurrent.atomic.AtomicInteger
import java.util.zip.GZIPInputStream
import javax.crypto.Cipher
import javax.crypto.CipherInputStream
import javax.crypto.spec.SecretKeySpec

/**
 * Downloads via OkHttp (cliente "plain" do [HttpClientFactory]) com verificação, retentativa,
 * descompressão gzip e decifragem AES opcional do arquivo baixado.
 * Bibliotecas ofuscadas usadas: `hb.d.m` = okhttp `closeQuietly`; `ac.g` = commons-lang3
 * StringUtils; `yb.c`/`yb.e` = commons-io FileUtils/IOUtils.
 * Original: x1/f1/lb/util/b0.java (nome Kotlin original `DownloadUtils`).
 */
object DownloadUtils {
    private val logger: Logger = LoggerFactory.getLogger(DownloadUtils::class.java)
    private val okHttpClient: OkHttpClient = HttpClientFactory.plainClient()

    /** Contexto de um download. Original: b0$d. */
    interface DownloadContext {
        val fileName: String
        val url: String
        val listener: Listener?
        /** Chave AES do arquivo (null/vazio = sem cifra). Original: `d()`. */
        fun aesKey(): String?
        val file: File
        /** Se o arquivo existente ainda é válido (não baixar). Original: `f(File)`. */
        fun isExistingValid(file: File): Boolean
        /** Validação após baixar. Original: `g(File)`. */
        fun verify(file: File): Boolean
        val isZip: Boolean
        val dir: String
        /** Tentativas restantes (começa em 1). */
        val tryTimes: AtomicInteger
    }

    /** Base com campos. Original: b0$a. */
    abstract class BaseDownloadContext(
        override val url: String,
        override val dir: String,
        override val fileName: String,
        override val isZip: Boolean,
        override val listener: Listener?,
    ) : DownloadContext {
        override val file: File = File(dir, fileName)
        override val tryTimes: AtomicInteger = AtomicInteger(1)
    }

    /** Variante sem cifra (aesKey = null). Original: b0$c. */
    abstract class PlainDownloadContext(
        url: String, dir: String, fileName: String, isZip: Boolean = false, listener: Listener? = null,
    ) : BaseDownloadContext(url, dir, fileName, isZip, listener) {
        override fun aesKey(): String? = null
    }

    /** Calculadora de checksum. Original: b0$b. */
    fun interface ChecksumCalculator { fun calc(file: File): String? }

    /** Callback antes de sobrescrever um arquivo existente. Original: b0$e. */
    fun interface BeforeOverwrite { fun onBeforeOverwrite(file: File) }

    /** Listener de download. Original: b0$f (`a` erro, `b` salvo, `c` progresso). */
    interface Listener {
        fun onError(e: Throwable)
        fun onSaved(savedPath: String)
        fun onProgress(progress: Int)
    }

    /** HEAD na URL; emite `response.isSuccessful`. Original: `b0.c(String)` (`DownloadUtils$checkExists$1`). */
    fun checkExists(url: String): Flow<Boolean> = flow {
        var resp: Response? = null
        try {
            resp = okHttpClient.newCall(Request.Builder().url(url).head().build()).execute()
            emit(resp.isSuccessful)
        } finally {
            resp?.closeQuietly()
        }
    }

    /** Decifra um arquivo com AES/ECB/PKCS5Padding (chave = bytes UTF-8). Original: `b0.d(String,String,String)`. */
    @SuppressLint("GetInstance")
    fun decryptFile(inputFilePath: String, outputFilePath: String, key: String) {
        val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(key.toByteArray(Charsets.UTF_8), "AES"))
        val fis = FileInputStream(inputFilePath)
        val cis = CipherInputStream(fis, cipher)
        val fos = FileOutputStream(outputFilePath)
        val buf = ByteArray(1024)
        while (true) {
            val n = cis.read(buf)
            if (n == -1) break
            fos.write(buf, 0, n)
        }
        fos.flush(); cis.close(); fis.close(); fos.close()
    }

    /**
     * Baixa para [savePath] (síncrono ou assíncrono), reportando progresso em %.
     * Original: `b0.e(String,String,boolean,b0$f)` + callback b0$h.
     */
    private fun download(url: String, savePath: String, async: Boolean, listener: Listener?) {
        val request = Request.Builder().url(url).build()
        val callback = object : okhttp3.Callback {
            override fun onFailure(call: Call, e: IOException) {
                listener?.onError(e)
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body ?: return
                val file = File(savePath)
                var input: InputStream? = null
                var out: FileOutputStream? = null
                try {
                    input = body.byteStream()
                    val total = body.contentLength()
                    if (file.exists()) file.delete()
                    out = FileOutputStream(file)
                    val buf = ByteArray(2048)
                    var done = 0L
                    while (true) {
                        val n = input.read(buf)
                        if (n == -1) break
                        out.write(buf, 0, n)
                        done += n
                        if (total > 0) listener?.onProgress(((done * 1.0f / total) * 100).toInt())
                    }
                    out.flush()
                    listener?.onSaved(file.absolutePath)
                } catch (e: Exception) {
                    listener?.onError(e)
                } finally {
                    response.closeQuietly(); body.closeQuietly()
                    input?.closeQuietly(); out?.closeQuietly()
                }
            }
        }
        val call = okHttpClient.newCall(request)
        if (async) {
            call.enqueue(callback)
            return
        }
        try {
            callback.onResponse(call, call.execute())
        } catch (e: IOException) {
            callback.onFailure(call, e)
        }
    }

    /**
     * GET síncrono entregando o InputStream (null se HTTP != 200, logando headers/corpo).
     * Em exceção: chama [failure], ou `callback(null)` + log se não houver.
     * Original: `b0.f(String, m<InputStream>, m<Throwable>)`.
     */
    fun download(url: String, callback: Callback<InputStream?>, failure: Callback<Throwable>?) {
        var resp: Response? = null
        var body: okhttp3.ResponseBody? = null
        var input: InputStream? = null
        try {
            val req = Request.Builder().url(url).build()
            resp = okHttpClient.newCall(req).execute()
            val code = resp.code
            if (code == 200) { // com.skydoves.sandwich.StatusCode.OK
                body = resp.body
                input = body?.byteStream()
            } else {
                val text = resp.body?.byteStream()?.let { IOUtils.toString(it, Charsets.UTF_8) } ?: ""
                logger.error("download error, url[$url] request headers[${req.headers}] response code[$code] response headers[${resp.headers}] body[$text]")
            }
            callback.onResult(input)
        } catch (t: Throwable) {
            if (failure != null) failure.onResult(t)
            else {
                callback.onResult(null)
                logger.error("download [$url] failure", t)
            }
        } finally {
            resp?.closeQuietly(); body?.closeQuietly(); input?.closeQuietly()
        }
    }

    /**
     * Download completo com verificação:
     *  1. se o arquivo existe e `isExistingValid` → retorna [whatRetIfExists];
     *  2. baixa para `tmp/<md5(url + "}")>` (sic: sufixo "}");
     *  3. se há chave AES → decifra para o destino; senão se `isZip` → gunzip; senão copia;
     *  4. valida com `verify`; em falha, repete enquanto houver tentativas.
     * Original: `b0.g(b0$d, boolean, b0$e)` + listener b0$i.
     */
    fun download(context: DownloadContext, whatRetIfExists: Boolean = true, loaderBeforeOverwrite: BeforeOverwrite? = null): Boolean {
        var saved = false
        val file = context.file
        if (file.exists()) {
            if (context.isExistingValid(file)) return whatRetIfExists
            loaderBeforeOverwrite?.onBeforeOverwrite(file)
        }
        context.tryTimes.decrementAndGet()
        val tmpPath = AppPaths.join(AppPaths.tmpCachePath(), md5(context.url + "}"))
        if (BaseLibConfig.isDebug) {
            logger.debug(
                "download url[{}], saveDir[{}], fileName[{}], file[{}], tmpPath[{}]",
                context.url, context.dir, context.fileName, context.file.absolutePath, tmpPath,
            )
        }
        download(context.url, tmpPath, false, object : Listener {
            override fun onError(e: Throwable) {
                logger.warn("Download failure", e)
                context.listener?.onError(e)
            }

            override fun onSaved(savedPath: String) {
                saved = true
                context.listener?.onSaved(savedPath)
            }

            override fun onProgress(progress: Int) {
                context.listener?.onProgress(progress)
            }
        })
        val tmp = File(tmpPath)
        val target = context.file.absolutePath
        if (!saved || !tmp.exists()) {
            return if (context.tryTimes.get() > 0) download(context, false, null) else false
        }
        val key = context.aesKey() ?: ""
        if (!StringUtils.isEmpty(key)) {
            decryptFile(tmpPath, target, key)
            tmp.delete()
        } else if (context.isZip) {
            FileUtils.copyInputStreamToFile(GZIPInputStream(FileInputStream(tmp)), file)
            if (file.exists()) tmp.delete()
            else {
                logger.warn("unzip failure[{}]->[{}]", tmp.absolutePath, file.absolutePath)
                if (!BaseLibConfig.isDebug) tmp.delete()
            }
        } else {
            FileUtils.copyFile(tmp, context.file, true) // yb.c.c = copyFile(src, dst, preserveDate=true)
        }
        if (!file.exists()) {
            // Fiel ao original: o resultado da retentativa é ignorado aqui.
            if (context.tryTimes.get() > 0) download(context, false, null)
            return false
        }
        if (context.verify(file)) return true
        file.delete()
        return if (context.tryTimes.get() > 0) download(context, false, null) else false
    }

    /** Hash hex de arquivo (buffer 16 KiB), null se não existir/erro. Original: `b0.i(File, String)`. */
    private fun digest(file: File, algorithm: String): String? {
        if (!file.exists() || !file.isFile) {
            if (BaseLibConfig.isDebug) logger.debug("file not exits algorithm[{}] file[{}]", algorithm, file.absolutePath)
            return null
        }
        return try {
            val md = MessageDigest.getInstance(algorithm)
            val buf = ByteArray(16384)
            FileInputStream(file).use { fis ->
                while (true) {
                    val n = fis.read(buf, 0, 16384)
                    if (n == -1) break
                    md.update(buf, 0, n)
                }
            }
            String(HexUtils.encodeHex(md.digest()))
        } catch (e: Exception) {
            logger.error("digest [{}] failure", algorithm, e)
            null
        }
    }

    /** Original: `b0.j(File)`. */ fun md5(file: File): String? = digest(file, "MD5")
    /** Original: `b0.k(File)`. */ fun sha1(file: File): String? = digest(file, "SHA-1")

    /** Tamanho (se > 0) e checksum (se não vazio, comparação exata). Original: `b0.l(...)`. */
    private fun check(file: File, checksum: String?, calc: ChecksumCalculator, size: Long): Boolean {
        if (size > 0 && file.length() != size) return false
        if (checksum.isNullOrEmpty()) return true
        return StringUtils.equals(calc.calc(file), checksum)
    }

    /** Original: `b0.m(File, String, long)` (MD5, calculadora b0$j). */
    fun checkMd5(file: File, checksum: String?, size: Long = 0): Boolean = check(file, checksum, { md5(it) }, size)

    /** Original: `b0.o(File, String, long)` (SHA-1, calculadora b0$k). */
    fun checkSha1(file: File, checksum: String?, size: Long): Boolean = check(file, checksum, { sha1(it) }, size)

    /** MD5 hex de string. Original: `b0.p(String)`. */
    private fun md5(input: String): String =
        MessageDigest.getInstance("MD5").digest(input.toByteArray(Charsets.UTF_8)).joinToString("") { String.format("%02x", it) }
}
