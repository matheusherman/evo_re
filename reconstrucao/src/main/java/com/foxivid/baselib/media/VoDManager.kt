package com.foxivid.baselib.media

import com.foxivid.baselib.api.ApiStreamMetaClient
import com.foxivid.baselib.heartbeat.HeartbeatManager
import com.foxivid.baselib.model.common.ApiResult
import com.foxivid.baselib.util.ApiCodeException
import com.foxivid.baselib.util.HttpStatusException
import com.foxivid.baselib.util.SandwichErrors
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOf
import java.util.concurrent.CountDownLatch
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
     * Original: l.l(apiCaller) + l$c — transforma uma chamada `ApiResponse<ApiResult<T>>` em `Flow<T>`:
     * - Success: se `body.code == "0"` emite `body.data` (antes chama `apiCaller.b(checksum)` quando o corpo traz
     *   `checkSum`; em VOD é no-op); senão lança [ApiCodeException] (`sf.b(code, msg)`).
     * - Failure.Error ⇒ [HttpStatusException] (`sf.a(statusCode, v0.a(...))`); Failure.Exception ⇒
     *   `Exception(v0.b(...), cause)`; demais Failure ⇒ `Exception(v0.c(...))`.
     */
    private fun <T> apiFlow(call: suspend () -> ApiResponse<ApiResult<T>>): Flow<T> = flow {
        val rsp = call()
        when (rsp) {
            is ApiResponse.Success -> {
                val body: ApiResult<T> = rsp.data
                if (body.code != "0") throw ApiCodeException(body.code, body.msg ?: "")
                @Suppress("UNCHECKED_CAST")
                emit(body.data as T)
            }
            is ApiResponse.Failure.Error -> throw HttpStatusException(rsp.statusCode.code, SandwichErrors.describe(rsp))
            is ApiResponse.Failure.Exception -> throw Exception(SandwichErrors.describe(rsp), rsp.exception)
            is ApiResponse.Failure -> throw Exception(SandwichErrors.describe(rsp))
        }
    }

    /**
     * Original: l.m(metaId, pageId, pageSize) + l$e ("getVideoDetail$flow$1") + l$d.
     * Rede: `ApiStreamMetaClient.getVideoDetail(tenantId, appId, appVer, did, language, metaId, pageId, pageSize,
     * requestTime = ServerTime.now(), token = streamToken, uid = accountId)`; o detalhe recebido (`data`) é gravado
     * no cache (l$e.a) a cada chamada.
     *
     * Com detalhe em cache: se `now - detailCacheUpdateTime[metaId+pageId+pageSize] < metaUpdateMinIntervalMs`
     * emite só o cache; senão (l$d, `callbackFlow`) emite o cache e depois consulta a rede: ao chegar resposta, grava o
     * carimbo de tempo e, **se o detalhe mudou** (`!=` do cache), loga "got [..] video detail update", atualiza o cache e
     * emite; em seguida fecha. Falha de rede ⇒ loga "reload [..] video detail failure" e fecha (sem propagar).
     */
    fun getVideoDetail(metaId: String, pageId: Int, pageSize: Int): Flow<MetaDetailResponse> {
        val network: Flow<MetaDetailResponse> = apiFlow {
            val h = HeaderInterceptor
            val rsp = ApiStreamMetaClient.getVideoDetail(h.tenantId().toString(), h.appId().toString(), h.appVersion(),
                h.deviceId(), h.language(), metaId, pageId, pageSize, ServerTime.now(), h.streamToken(), h.accountId())
            // Original: l$e.a — grava o detalhe no cache
            if (rsp is ApiResponse.Success) rsp.data.data?.let { cacheDetail(it) }
            rsp
        }
        val cached = cachedDetail(metaId) ?: return network
        val key = metaId + pageId + pageSize
        val stamp = ServerTime.now()
        val age = stamp - (detailCacheUpdateTime[key] ?: 0L)
        return if (age < HeartbeatManager.metaUpdateMinIntervalMs) flowOf(cached) else flow {
            emit(cached)
            try {
                network.collect { fresh ->
                    detailCacheUpdateTime[key] = stamp
                    if (cached != fresh) {
                        logger.debug("got [${cached.title}(${cached.metaId})] video detail update")
                        cacheDetail(fresh)
                        emit(fresh)
                    }
                }
            } catch (t: Throwable) {
                logger.error("reload [${cached.title}(${cached.metaId})] video detail failure", t)
            }
        }
    }

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

    /**
     * Original: l.p() ("loadLocalPlaylist") + l$i/l$j/l$k/l$l. Para `vod_favorites` e `vod_play_history`:
     * lê o JSON `LinkedHashMap<metaId, timestamp>`; resolve cada id no cache de detalhes ([cachedDetail]) e, para os
     * que faltam, busca na rede (`getVideoDetail(id, 1, 10)`) esperando todos via `CountDownLatch`
     * (o carimbo é o salvo, ou `now` se ausente). Ao final atribui [favoritesMap] / [historyMap]. Erros: logados
     * ("load local [chave] failure") e passa à próxima chave.
     */
    suspend fun loadLocalPlaylist() {
        for (typeKey in arrayOf("vod_favorites", "vod_play_history")) {
            try {
                val json = Preferences.getString(typeKey, "")
                if (json.isBlank()) continue
                val saved: LinkedHashMap<String, Long> = gson.fromJson(json, object : TypeToken<LinkedHashMap<String, Long>>() {}.type)
                val result = HashMap<String, Pair<Long, MetaDetailResponse>>()
                val missing = ArrayList<String>()
                for ((metaId, ts) in saved) {
                    val detail = cachedDetail(metaId)
                    if (detail != null) result[metaId] = Pair(ts, detail) else missing.add(metaId)
                }
                if (missing.isNotEmpty()) {
                    val latch = CountDownLatch(missing.size)
                    for (metaId in missing) {
                        getVideoDetail(metaId, 1, 10)
                            .catch { e -> latch.countDown(); logger.error("load $typeKey $metaId failure", e) } // l$j
                            .collect { detail -> // l$k
                                latch.countDown()
                                result[detail.metaId] = Pair(saved[detail.metaId] ?: ServerTime.now(), detail)
                            }
                    }
                    latch.await()
                }
                if (typeKey == "vod_play_history") historyMap = result else favoritesMap = result
            } catch (t: Throwable) {
                logger.error("load local [$typeKey] failure", t)
            }
        }
    }

    /** Original: l.n() — recarrega playlists/episódios locais (`initLocalPlayList$1`); chamado em UserManager no logout/login. */
    fun reset() { scope.launch { loadLocalPlayEpisodes() } }

    /** Original: l.q() — grava `vod_detail_cache` (timestamp `ServerTime.elapsedNow()` embrulhado em l$m). */
    fun saveDetailCacheStamp() = Preferences.putLong("vod_detail_cache", ServerTime.elapsedNow())
}
