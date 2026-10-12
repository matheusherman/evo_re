package com.foxivid.baselib.streaming.server

import com.foxivid.baselib.cache.BaseCache
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.CountDownLatch

/**
 * Original: x1/f1/lb/streaming/server/q.java ("SignatureCache.kt")
 *
 * Cache em disco (DiskLru via [BaseCache]) da "assinatura" que o tracker entrega por (uid, mediaId)
 * (callback `x6.d.d`). Na próxima vez que o canal for aberto a assinatura é reenviada ao PR em
 * `x6.c.v(..., signature)`, provavelmente para acelerar a autorização. Chave: "<uid>.<mediaId>".
 */
object SignatureCache {
    private var baseCache: BaseCache<String>? = null

    private fun key(uid: String, mediaId: String) = "$uid.$mediaId"

    /** Original: q.d(dir, appVersion, maxSize) */
    fun init(cacheDirectory: String, appVersion: Int, maxSize: Long) {
        baseCache = BaseCache(cacheDirectory, object : TypeToken<String>() {}.type, appVersion, maxSize)
    }

    /** Original: q.b(uid, mediaId) — leitura bloqueante (CountDownLatch) do cache; "" se ausente. */
    fun get(uid: String, mediaId: String): String {
        val latch = CountDownLatch(1)
        val out = arrayOfNulls<String>(1)
        CoroutineScope(Dispatchers.IO).launch {
            try { out[0] = baseCache?.get(key(uid, mediaId)) } catch (_: Throwable) {}
            latch.countDown()
        }
        latch.await()
        return out[0] ?: ""
    }

    /** Original: q.e(uid, mediaId, signature) */
    fun put(uid: String, mediaId: String, signature: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try { baseCache?.put(key(uid, mediaId), signature) } catch (_: Throwable) {}
        }
    }
}
