package com.foxivid.baselib.api.cache

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.security.MessageDigest
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutorService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory

/**
 * Cache de arquivos baixados por URL (ex.: imagens de propaganda/marquee), agrupados por `cacheKey`.
 *
 * Original: x1/f1/lb/api/cache/b.java (`FileDiskCacheUtil.kt`) + api/cache/a (Runnable de download).
 *
 * Persistência do mapeamento cacheKey -> {urls} em SharedPreferences (SPUtils, chave
 * "file_disk_cache_mapping", JSON via Gson). Nome do arquivo = MD5(url) em hex (fallback: hashCode).
 *
 * Observação de fidelidade: no carregamento inicial, quando o JSON salvo NÃO é vazio e é lido com
 * sucesso, o `CountDownLatch` não é liberado (o original só faz countDown com string vazia ou erro),
 * o que faria [get] esperar indefinidamente. Comportamento mantido como no descompilado.
 */
object FileDiskCacheUtil {

    private val logger = LoggerFactory.getLogger(FileDiskCacheUtil::class.java)

    /** Original: util/n.f21413l (executor compartilhado). */
    private val executorService: ExecutorService get() = TODO("outro módulo: util/n.f21413l")

    /** Original: `fileCacheKey`. */
    private var fileCacheKey = HashMap<String, HashSet<String>>()

    /** Original: `initCountDownLatch`. */
    private val initCountDownLatch = CountDownLatch(1)

    private val gson = Gson()

    init {
        // Original: bloco static -> corrotina `FileDiskCacheUtil$1` em Dispatchers.IO
        CoroutineScope(Dispatchers.IO).launch {
            SpRef.getString("file_disk_cache_mapping", "")
                .catch { th ->
                    logger.error("load file_disk_cache_mapping failure", th)
                    initCountDownLatch.countDown()
                }
                .collect { str ->
                    try {
                        if (str.isNotEmpty()) {
                            fileCacheKey = gson.fromJson(str, object : TypeToken<HashMap<String, HashSet<String>>>() {}.type)
                            return@collect // (sem countDown — ver KDoc da classe)
                        }
                        initCountDownLatch.countDown()
                    } catch (th: Throwable) {
                        try { logger.error("parse file_disk_cache_mapping failure", th) } finally { initCountDownLatch.countDown() }
                    }
                }
        }
    }

    /**
     * Devolve os arquivos já baixados para [urls]; dispara download dos que faltam (no executor,
     * 2 tentativas) e apaga arquivos de URLs que saíram da lista daquele [cacheKey].
     * Original: b.h(cacheKey, urls).
     */
    suspend fun get(cacheKey: String, urls: List<String>): Map<String, File> {
        val result = LinkedHashMap<String, File>()
        if (urls.isEmpty()) return result
        try {
            withContext(Dispatchers.IO) { initCountDownLatch.await() } // `FileDiskCacheUtil$get$2`
        } catch (th: Throwable) {
            logger.error("wait for cache mapping ready failure", th)
            return result
        }
        val keys = fileCacheKey[cacheKey] ?: HashSet()
        for (old in keys) if (!urls.contains(old)) deleteCached(old)
        var changed = false
        for (url in urls) {
            if (url.isEmpty()) continue
            val task = downloadTask(url)
            val file = task.file
            task.tryTimes.set(2)
            if (file.exists()) result[url] = file
            else executorService.submit { DownloadRef.download(task) } // Original: api/cache/a -> b.i(task)
            if (!keys.contains(url)) { keys.add(url); changed = true }
        }
        if (!changed) return result
        try {
            fileCacheKey[cacheKey] = keys
            SpRef.putString("file_disk_cache_mapping", gson.toJson(fileCacheKey))
        } catch (th: Throwable) {
            logger.error("save file_disk_cache_mapping failure", th)
        }
        return result
    }

    /** Original: b.k(url). */
    private fun deleteCached(url: String): Boolean {
        val file = downloadTask(url).file
        return if (file.exists()) file.delete() else false
    }

    /**
     * Tarefa de download (DownloadUtils.Task) com verificação sempre `true` e listener que só loga falhas.
     * Original: b.g(url) + b$b (b0.c) + b$c (b0.f).
     */
    private fun downloadTask(url: String): DownloadRef.Task =
        DownloadRef.newTask(url, DownloadRef.cacheDir(), md5Hex(url)) { e -> logger.error("download failure [$url]", e) }

    /** Original: b.j(url) + b.f(bytes). */
    private fun md5Hex(url: String): String = try {
        val md = MessageDigest.getInstance("MD5")
        md.update(url.toByteArray(Charsets.UTF_8))
        md.digest().joinToString("") { b -> Integer.toHexString(b.toInt() and 0xff).padStart(2, '0') }
    } catch (_: Throwable) {
        url.hashCode().toString()
    }
}

/** Pontes para util/w0 (SPUtils) e util/b0 (DownloadUtils), de outros módulos. */
internal object SpRef {
    fun getString(key: String, dft: String): kotlinx.coroutines.flow.Flow<String> = TODO("util/w0.g()")
    fun putString(key: String, value: String): Unit = TODO("util/w0.t()")
}

internal object DownloadRef {
    interface Task { val file: File; val tryTimes: java.util.concurrent.atomic.AtomicInteger }
    fun newTask(url: String, dir: String, name: String, onError: (Throwable) -> Unit): Task = TODO("util/b0.c")
    fun cacheDir(): String = TODO("util/b1.i()")
    fun download(task: Task): Unit = TODO("util/b0.h(task)")
}
