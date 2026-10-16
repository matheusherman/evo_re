package com.foxivid.baselib.streaming.server

import com.foxivid.baselib.cache.BaseCache
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.streaming.engine.BlockCache
import com.foxivid.baselib.streaming.engine.MediaType
import com.foxivid.baselib.util.Preferences
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import java.security.MessageDigest
import java.util.concurrent.CountDownLatch

/**
 * Original: x1/f1/lb/streaming/server/s.java ("VoDLocalDiskCacheManage.kt") (+ s$a, s$b, s$c)
 *
 * Cache de blocos em disco usado pelo motor ([BlockCache] = y6.l). Dois caches:
 * - "quick start": índice/legendas e os **primeiros 30 blocos** (blockId ≤ 30) — partida rápida de VoD;
 * - "full data": blocos com blockId > 30.
 * Chave = MD5 hex de "<mediaType>.<mediaHash>.<blockId>.<blockName>".
 * Tamanho real ajustado ao espaço livre (se o livre não basta, usa (livre − 1 GiB) quando livre > 1 GiB (IjkMediaMeta.AV_CH_STEREO_RIGHT = BasicMeasure.EXACTLY = 0x40000000)).
 * Tamanhos acumulados persistidos em "sp_quick_start_cache_size" / "sp_full_date_cache_size".
 */
object VodLocalDiskCacheManager : BlockCache {

    private val logger = LoggerFactory.getLogger(VodLocalDiskCacheManager::class.java)
    private var quickStartCache: BaseCache<ByteArray>? = null
    private var fullDataCache: BaseCache<ByteArray>? = null
    private var listener: Listener? = null

    /** Original: server/e.java — interface vazia (listener de gestão de cache). */
    interface Listener

    fun setListener(l: Listener) { listener = l }

    /** Original: s.h(...) */
    private fun cacheKey(mediaType: MediaType, mediaHash: Int, blockId: Int, blockName: String): String {
        val s = "$mediaType.$mediaHash.$blockId.$blockName"
        return try {
            MessageDigest.getInstance("MD5").digest(s.toByteArray()).joinToString("") { "%02x".format(it.toInt() and 0xff) }
        } catch (_: Throwable) { s.hashCode().toString() }
    }

    private fun pick(mediaType: MediaType, blockId: Int): Pair<BaseCache<ByteArray>, String>? {
        val q = quickStartCache ?: return null
        if (mediaType == MediaType.BLOCK && blockId > 30) {
            val f = fullDataCache ?: return null
            return f to "sp_full_date_cache_size"
        }
        return q to "sp_quick_start_cache_size"
    }

    /** Original: s.a(...) — leitura bloqueante. */
    override fun get(mediaType: MediaType, mediaHash: Int, blockId: Int, blockName: String): ByteArray? {
        val (cache, _) = pick(mediaType, blockId) ?: return null
        val latch = CountDownLatch(1)
        val out = arrayOfNulls<ByteArray>(1)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val key = cacheKey(mediaType, mediaHash, blockId, blockName)
                out[0] = cache.getBytes(key)
                if (BaseLibConfig.isDebug) logger.debug("vod_cache get[$mediaType-$mediaHash-$blockId-$blockName]->[$key]")
            } catch (t: Throwable) {
                logger.error("load cache failure[$mediaType.$mediaHash.$blockId.$blockName]", t)
            } finally { latch.countDown() }
        }
        latch.await()
        return out[0]
    }

    /** Original: s.b(...) */
    override fun put(mediaType: MediaType, mediaHash: Int, blockId: Int, blockName: String, data: ByteArray?) {
        val (cache, sizeKey) = pick(mediaType, blockId) ?: return
        if (data == null) return
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val key = cacheKey(mediaType, mediaHash, blockId, blockName)
                if (BaseLibConfig.isDebug) logger.debug("vod_cache put[$mediaType-$mediaHash-$blockId-$blockName]->[$key]")
                if (cache.putBytes(key, data)) Preferences.putLong(sizeKey, cache.size())
            } catch (t: Throwable) { logger.error("vod cache failure", t) }
        }
    }

    /**
     * Original: s.i(cacheDir, fullDataDir, appVersion, maxSize, fullDataMaxSize) (+ s$b, s$b$b)
     * Cálculo: alocação = esperado − histórico; se o livre < alocação ⇒ (livre > 1 GiB ? livre − 1 GiB : 0).
     */
    fun init(cacheDirectory: String, fullDataDirectory: String, appVersion: Int, maxSize: Long, fullDataMaxSize: Long) {
        val free: Long = com.foxivid.baselib.util.AppPaths.freeStorage()
        val total: Long = com.foxivid.baselib.util.AppPaths.totalStorage()
        Preferences.getLong("sp_quick_start_cache_size", 0L) { history ->
            var alloc = maxSize - history
            if (free < alloc) alloc = if (free > 1073741824L) free - 1073741824L else 0L
            val real = history + alloc
            if (real == 0L) {
                logger.warn("vod_cache local storage is not enough for vod cache, totalStorage[$total] freeStorage[$free]")
                return@getLong
            }
            quickStartCache = BaseCache(cacheDirectory, object : TypeToken<ByteArray>() {}.type, appVersion, real)
            logger.info("vod_cache local storage init for video quick start cache, totalStorage[$total] freeStorage[$free expectCacheSize[$maxSize] realCacheSize[$real]")
            val free2 = free - alloc
            Preferences.getLong("sp_full_date_cache_size", 0L) { hist2 ->
                var a2 = fullDataMaxSize - hist2
                if (free2 < a2) a2 = if (free2 > 1073741824L) free2 - 1073741824L else 0L
                val r2 = hist2 + a2
                if (r2 == 0L) {
                    logger.warn("vod_cache local storage is not enough for vod full cache, totalStorage[$total] freeStorage[$free2]")
                    return@getLong
                }
                fullDataCache = BaseCache(fullDataDirectory, object : TypeToken<ByteArray>() {}.type, appVersion, r2)
                logger.info("vod_cache local storage init for full video cache, totalStorage[$total] freeStorage[$free2] expectCacheSize[$fullDataMaxSize] historyCacheSize[$hist2]+allocateCacheSize[$a2]=realCacheSize[$r2]")
            }
        }
    }

    override fun start() {}
    override fun stop() {}
}
