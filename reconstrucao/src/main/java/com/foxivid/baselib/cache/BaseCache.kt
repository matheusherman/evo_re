package com.foxivid.baselib.cache

import android.util.LruCache
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.util.TimeUtils
import com.google.gson.Gson
import com.jakewharton.disklrucache.DiskLruCache
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory
import java.io.File
import java.io.IOException
import java.lang.reflect.Type

/**
 * Cache genérico em dois níveis: [LruCache] em memória + DiskLruCache em disco, valores em JSON (Gson).
 *
 * Original: x1/f1/lb/cache/a.java (Kotlin: BaseCache.kt)
 *
 * As demais classes do pacote original são uma cópia embutida (renomeada pelo R8) da biblioteca
 * **com.jakewharton:disklrucache** — por convenção usamos a API real em vez de reconstruí-las:
 *  - x1/f1/lb/cache/b.java  = DiskLruCache (journal "libcore.io.DiskLruCache", CLEAN/DIRTY/REMOVE/READ)
 *    métodos usados: v()=open, t()=get, r()=edit, A()=remove, flush(), size(); b$c=Editor (f()=newOutputStream, e()=commit),
 *    b$e=Snapshot (a()=getInputStream)
 *  - x1/f1/lb/cache/d.java  = StrictLineReader
 *  - x1/f1/lb/cache/e.java  = Util (US_ASCII/UTF_8, closeQuietly, deleteContents)
 *  - x1/f1/lb/cache/c.java  = classe sintética vazia
 *
 * Formato no disco (índice 0 da entrada): 4 bytes big-endian com o tamanho + bytes UTF-8 do JSON.
 * Instâncias de DiskLruCache são compartilhadas por diretório (mapa estático `f20595g`).
 */
open class BaseCache<T>(
    private val cacheDirectory: String,
    private val type: Type,
    appVersion: Int,
    maxSize: Long,
    /** Itens no LruCache em memória (0 = sem cache em memória). Default 100. */
    memCacheSize: Int = 100,
) {
    private val logger = LoggerFactory.getLogger(javaClass)
    private var lruCache: LruCache<String, T>? = null

    companion object {
        private val gson = Gson()
        /** Original: campo estático `f20595g` (diretório -> DiskLruCache). */
        private val diskCaches: MutableMap<String, DiskLruCache> = LinkedHashMap()
    }

    init {
        try {
            if (diskCaches[cacheDirectory] == null) {
                synchronized(diskCaches) {
                    val dir = File(cacheDirectory)
                    if (!dir.exists()) dir.mkdirs()
                    val disk = DiskLruCache.open(File(cacheDirectory), appVersion, 1, maxSize)
                    // NOTA: o LruCache só é criado na 1ª instância de cada diretório (fiel ao original).
                    if (memCacheSize > 0) lruCache = LruCache(memCacheSize)
                    diskCaches[cacheDirectory] = disk
                }
            }
        } catch (t: Throwable) {
            logger.error("create cache[$cacheDirectory] failure", t)
        }
    }

    /** Original: a.e(). */
    private fun diskCache(): DiskLruCache? = synchronized(diskCaches) {
        diskCaches[cacheDirectory].also { if (it == null) logger.error("no cache found[$cacheDirectory]") }
    }

    /** Original: a.c(key) "get" — memória, depois disco (+ desserialização Gson). */
    suspend fun get(key: String): T? {
        var json: String? = null
        return try {
            lruCache?.get(key)?.let { return it }
            val bytes = getArray(key) ?: return null
            json = String(bytes, Charsets.UTF_8)
            @Suppress("UNCHECKED_CAST")
            val obj = gson.fromJson<Any>(json, type) as T
            lruCache?.put(key, obj)
            obj
        } catch (t: Throwable) {
            logger.error("parse cache failure[$json]->[$type]", t)
            null
        }
    }

    /** Original: a.f(key, value) "put" — String vai crua, demais objetos como JSON. */
    suspend fun put(key: String, value: T): Boolean = try {
        lruCache?.put(key, value)
        if (diskCache() == null) false else {
            val bytes = if (value is String) value.toByteArray(Charsets.UTF_8) else gson.toJson(value).toByteArray(Charsets.UTF_8)
            putArray(key, bytes)
        }
    } catch (t: Throwable) {
        logger.error("put cache failure", t); false
    }

    /** Original: a.d(key) + corrotina "BaseCache\$getArray\$2" (Dispatchers.IO). */
    suspend fun getArray(key: String): ByteArray? = withContext(Dispatchers.IO) {
        val disk = diskCache() ?: return@withContext null
        synchronized(key) {
            val snapshot = disk.get(key)
            if (snapshot == null) {
                if (BaseLibConfig.isDebug) logger.debug("load [$key] no cache")
                return@withContext null
            }
            val start = TimeUtils.now()
            val input = snapshot.getInputStream(0)
            try {
                val size = ((input.read() and 255) shl 24) or ((input.read() and 255) shl 16) or
                    ((input.read() and 255) shl 8) or (input.read() and 255)
                if (size <= 0) {
                    logger.warn("load case invalid[$key] size[$size]")
                    disk.remove(key)
                    return@withContext null
                }
                val bytes = ByteArray(size)
                input.read(bytes, 0, size) // (sic) leitura única, sem laço
                logSlow("load cache[$key]->[$size]", TimeUtils.now() - start)
                bytes
            } catch (e: IOException) {
                logger.error("load cache failure[$key]", e); null
            } finally {
                runCatching { input.close() }
            }
        }
    }

    /** Original: a.g(key, bytes) + corrotina "BaseCache\$putArray\$2". */
    suspend fun putArray(key: String, content: ByteArray): Boolean = withContext(Dispatchers.IO) {
        val disk = diskCache() ?: return@withContext false
        synchronized(key) {
            val editor = disk.edit(key) ?: return@withContext false
            val out = editor.newOutputStream(0) ?: return@withContext false
            try {
                val start = TimeUtils.now()
                val n = content.size
                out.write((n ushr 24) and 255); out.write((n ushr 16) and 255)
                out.write((n ushr 8) and 255); out.write(n and 255)
                out.write(content)
                editor.commit()
                disk.flush()
                val dt = TimeUtils.now() - start
                if (BaseLibConfig.isDebug) logger.debug("put cache[$key]->[${content.size}]") else logSlow("put cache[$key]->[${content.size}]", dt)
                true
            } catch (e: IOException) {
                false
            } finally {
                runCatching { out.close() }
            }
        }
    }

    /** Log de lentidão: >=100 ms info, >=200 ms warn (em debug, sempre debug). */
    private fun logSlow(msg: String, dt: Long) {
        if (BaseLibConfig.isDebug) { logger.debug("$msg time[$dt ms]"); return }
        if (dt >= 200) logger.warn("$msg time[$dt ms]") else if (dt >= 100) logger.info("$msg time[$dt ms]")
    }

    /** Original: a.h() — tamanho em disco (-1 sem cache). */
    fun size(): Long = diskCache()?.size() ?: -1L
}
