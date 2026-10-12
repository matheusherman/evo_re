package com.foxivid.baselib.media

import com.foxivid.baselib.cache.BaseCache
import com.foxivid.baselib.media.model.SubscribeItem

/**
 * Original: x1/f1/lb/media/k.java ("SubscribeCache") (+ k$a, TypeToken de [SubscribeItem])
 *
 * Cache em disco ([BaseCache], DiskLruCache + Gson) dos lembretes de esportes. Diretório = `AppPaths.subscribeCachePath()`.
 */
object SubscribeCache {
    private var cache: BaseCache<SubscribeItem>? = null

    /** Original: k.b(cacheDirectory, appVersion, maxSize) */
    fun init(cacheDirectory: String, appVersion: Int, maxSize: Long) {
        cache = BaseCache(cacheDirectory, SubscribeItem::class.java, appVersion, maxSize)
    }

    /** Original: k.a(key) — `null` se o cache não foi iniciado. */
    suspend fun get(key: String): SubscribeItem? = cache?.get(key)

    /** Original: k.c(key, item) */
    suspend fun put(key: String, item: SubscribeItem) { cache?.put(key, item) }
}
