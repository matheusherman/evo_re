package com.foxivid.baselib.media

import com.foxivid.baselib.cache.BaseCache
import com.foxivid.baselib.model.meta.PlaylistResponse
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.sync.Mutex

/**
 * Original: x1/f1/lb/media/f.java (+ f$a, f$b) — "PlaylistCache"
 *
 * Só inicialização: dois [BaseCache] (resposta de playlist VOD e checksum string) no mesmo diretório, mais um
 * [Mutex] e o idioma (`lang`, padrão "pt", depois `HeaderInterceptor.language()`). O resto da classe é vazio no jadx
 * (os acessores foram removidos pelo R8).
 */
object PlaylistCache {
    private var cache: BaseCache<PlaylistResponse>? = null
    private var checksumCache: BaseCache<String>? = null
    private val mutex = Mutex()
    private var lang = "pt"

    /** Original: f.a(cacheDirectory, appVersion, maxSize) */
    fun init(cacheDirectory: String, appVersion: Int, maxSize: Long, language: String) {
        lang = language
        cache = BaseCache(cacheDirectory, object : TypeToken<PlaylistResponse>() {}.type, appVersion, maxSize)
        checksumCache = BaseCache(cacheDirectory, object : TypeToken<String>() {}.type, appVersion, maxSize)
    }
}
