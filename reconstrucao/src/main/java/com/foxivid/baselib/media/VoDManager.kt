package com.foxivid.baselib.media

import com.foxivid.baselib.api.ApiStreamMetaClient
import com.foxivid.baselib.model.meta.MetaDetailResponse
import com.foxivid.baselib.model.meta.PlaylistResponse
import com.foxivid.baselib.network.HeaderInterceptor
import com.foxivid.baselib.util.Preferences
import com.foxivid.baselib.util.ServerTime
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import java.util.concurrent.ConcurrentHashMap

/**
 * Original: x1/f1/lb/media/l.java ("VoDManager.kt") (+ l$a..l$m)
 *
 * Gerenciador de VOD (filmes/séries): detalhe de vídeo (`GET /api/vod/videoDetail/get/v1`) com cache em memória
 * (LRU de 128 itens, `u4.d`) + cache em disco, favoritos, histórico e histórico de episódios assistidos
 * (`vod_episode_history`, Map metaId -> (temporada, episódio)).
 *
 * [getVideoDetail]: se há detalhe em cache e ele é mais novo que `HeartbeatManager.n0()` (TTL vindo das propriedades
 * remotas) emite só o cache; caso contrário emite o cache **e depois** o resultado da rede (atualizando o cache).
 * A chave de TTL é `metaId + pageId + pageSize`.
 *
 * Erros do `ApiResponse` (sandwich) viram exceções: HTTP error ⇒ `sf.a(code, msg)`; exceção ⇒ `Exception(msg, cause)`;
 * falha ⇒ `Exception(msg)` (mensagens montadas por `util.v0`).
 */
object VoDManager {
    private val logger = LoggerFactory.getLogger(VoDManager::class.java)
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val gson = Gson()

    private const val CHECKSUM_CACHE_KEY = "vod_check_sum_cache" // Original: l$a.checksumCacheKey

    private val metaQueryExpressionPlayList = HashMap<String, PlaylistResponse>()
    /** Original: `u4.d<String, MetaDetailResponse>(128)` — LRU. */
    private val metaDetailResponseCache = object : LinkedHashMap<String, MetaDetailResponse>(128, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<String, MetaDetailResponse>?) = size > 128
    }
    private var favoritesMap: MutableMap<String, Pair<Long, MetaDetailResponse>> = LinkedHashMap()
    private var playEpisodeHist: MutableMap<String, Pair<Int, Int>> = LinkedHashMap()
    private var historyMap: MutableMap<String, Pair<Long, MetaDetailResponse>> = LinkedHashMap()
    private val playlistCacheUpdateTime = ConcurrentHashMap<String, Long>()
    private val detailCacheUpdateTime = ConcurrentHashMap<String, Long>()
    private var isCacheLoaded = true

    /** Original: l.k(detail) */
    @Synchronized fun cacheDetail(detail: MetaDetailResponse) { metaDetailResponseCache[detail.metaId] = detail }
    @Synchronized private fun cachedDetail(metaId: String) = metaDetailResponseCache[metaId]

    /**
     * Original: l.m(metaId, pageId, pageSize) + l$e ("getVideoDetail$flow$1") + l$d.
     * Rede: `ApiStreamMetaClient.getVideoDetail(tenantId, appId, appVer, did, language, metaId, pageId, pageSize,
     * requestTime = ServerTime.now(), token = streamToken, uid = accountId)`; sucesso grava no cache.
     */
    fun getVideoDetail(metaId: String, pageId: Int, pageSize: Int): Flow<MetaDetailResponse> {
        val network: Flow<MetaDetailResponse> = flow {
            val h = HeaderInterceptor
            val rsp = ApiStreamMetaClient.getVideoDetail(h.tenantId().toString(), h.appId().toString(), h.appVersion(),
                h.deviceId(), h.language(), metaId, pageId, pageSize, ServerTime.now(), h.streamToken(), h.accountId())
            // TODO(sandwich): despachar NetResult → Success ⇒ cacheDetail(data) + emit; Error/Failure ⇒ exceção (ver KDoc)
            TODO("despacho de ApiResponse ($rsp) — l\$c.invokeSuspend")
        }
        val cached = cachedDetail(metaId) ?: return network
        val key = metaId + pageId + pageSize
        val age = ServerTime.now() - (detailCacheUpdateTime[key] ?: 0L)
        // Original: age < HeartbeatManager.n0() ? flowOf(cached) : callbackFlow { emit(cached); coleta rede (l$d) }
        return if (age < detailCacheTtlMs()) flow { emit(cached) } else flow { emit(cached); network.collect { emit(it) } }
    }

    private fun detailCacheTtlMs(): Long = TODO("x1.f1.lb.heartbeat.f.n0() — propriedade remota (ver docs/propriedades_remotas.md)")

    /** Original: l.o() ("loadLocalPlayEpisodes") — lê `vod_episode_history` (JSON). */
    suspend fun loadLocalPlayEpisodes() {
        try {
            val json = Preferences.getString("vod_episode_history", "")
            if (json.isEmpty()) return
            playEpisodeHist = gson.fromJson(json, object : TypeToken<LinkedHashMap<String, Pair<Int, Int>>>() {}.type)
        } catch (t: Throwable) {
            logger.error("load local play episodes history failure", t)
        }
    }

    /** Original: l.p() ("loadLocalPlaylist") — NÃO decompilado (JadxOverflowException). */
    suspend fun loadLocalPlaylist(): Unit = TODO("nativo/não decompilado: x1.f1.lb.media.l.p()")

    /** Original: l.n() — recarrega playlists/episódios locais (`initLocalPlayList$1`); chamado em UserManager no logout/login. */
    fun reset() { scope.launch { loadLocalPlayEpisodes() } }

    /** Original: l.q() — grava `vod_detail_cache` (timestamp `ServerTime.elapsedNow()` embrulhado em l$m). */
    fun saveDetailCacheStamp() = Preferences.putLong("vod_detail_cache", ServerTime.elapsedNow())
}
