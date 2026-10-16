package com.foxivid.baselib.media

import com.foxivid.baselib.api.ApiStreamMetaClient
import com.foxivid.baselib.bot.TelegramBot
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.media.model.SubscribeItem
import com.foxivid.baselib.model.common.ApiResult
import com.foxivid.baselib.model.meta.ChannelListResponse
import com.foxivid.baselib.model.meta.ChannelStreamResponse
import com.foxivid.baselib.model.meta.EPGProgramme
import com.foxivid.baselib.network.HeaderInterceptor
import com.foxivid.baselib.util.AppAttrUtils
import com.foxivid.baselib.util.SandwichErrors
import com.skydoves.sandwich.StatusCode
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnFailure
import com.skydoves.sandwich.suspendOnSuccess
import com.foxivid.baselib.user.UserManager
import com.foxivid.baselib.util.Preferences
import com.foxivid.baselib.util.ServerTime
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import org.greenrobot.eventbus.EventBus
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import java.util.Locale
import java.util.Objects
import java.util.TreeMap
import java.util.concurrent.ConcurrentSkipListMap
import java.util.concurrent.atomic.AtomicBoolean

/** Original: nf/m — evento de EventBus "lembrete de programa vai começar" (postado por [ChannelManager.executeSubscribe]). */
class SubscribeNoticeEvent(
    val key: Int, val epgId: String?, val startTime: Long, val stopTime: Long,
    val channelName: String?, val programmeTitle: String?, val desc: String?,
)

/** Original: nf/d — evento de EventBus "lista de canais carregada/falhou" (`isOK`, `code`, `msg`). */
class ChannelListEvent(val isOK: Boolean = true, val code: String? = null, val msg: String? = null)

/**
 * Original: x1/f1/lb/media/a.java ("ChannelManager.kt") (+ a$a..a$t)
 *
 * Lista de canais ao vivo, colunas/categorias, numeração, favoritos, histórico e lembretes ("subscribe").
 *
 * Carga ([loadChannelList]):
 * - Requer stream token (`UserManager.A0()`); sem token não carrega.
 * - Respeita `nextUpdateTime` (12 h após sucesso; 5 min após falha já inicializado; 15 s antes da 1ª carga),
 *   salvo `isForce`.
 * - `GET /api/live/channel/list/v1` (ApiStreamMetaClient, **pageId=1, pageSize=2000**, `checksum` = checksum da
 *   última resposta). Se a resposta for HTTP 404 ⇒ "new api not found try old api" ⇒ `GET /api/meta/channel/list/v1`.
 * - Sucesso ([onLoadChannelSuccess]): guarda o checksum de `ApiResult.checkSum`; se `data == null` e já
 *   inicializado e checksum igual ⇒ nada mudou (próxima checagem em 12 h). Com dados ⇒ [buildChannels], posta
 *   nf.d no EventBus e entrega `channelEPGIndexResponse` ao [EpgManager.update].
 * - Falha ([onLoadChannelFailure]): "invalid token" ⇒ re-login (UserManager.g1) e recarrega; senão avisa o bot
 *   "[load channel list]\nfailure:..." e reagenda (retry 15 s se `isRetryAfterFailure`).
 *
 * Modos (`playMode`): 0 = sem canais adultos (type 1 ou 3), 1 = com adultos. Tudo é indexado nas duas versões.
 * Chave de canal = `Objects.hash(streamId, route)`.
 */
object ChannelManager {

    private val logger = LoggerFactory.getLogger(ChannelManager::class.java)
    private val puckScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    private var favoritesMap: MutableMap<Int, Pair<String, Long>> = HashMap()
    private var playHistoryMap: MutableMap<Int, Pair<String, Long>> = HashMap()
    private val isInLoading = AtomicBoolean(false)
    private var isInitComplete = false
    private var isAdultExists = false
    private var playMode = 0
    private var nextUpdateTime: Long? = null
    private var botFailureTime = 0L
    /** Original: a.y (f20779y) — instante da última execução de [executeSubscribe] com lembretes pendentes. */
    private var lastExecuteSubscribeTime = 0L
    private var lastInSubscribedChangeTime = System.currentTimeMillis()
    private var lastInSubscribedSaveTime = lastInSubscribedChangeTime

    private var channelsByColumns: Map<Int, Map<String, List<ChannelStreamResponse>>> = HashMap()
    private var channelPositionsByColumns: Map<Int, Map<String, Map<Int, Int>>> = HashMap()
    private var channels: Map<Int, List<ChannelStreamResponse>> = HashMap()
    private var channelsMap: Map<Int, Map<Int, ChannelStreamResponse>> = HashMap()
    /** streamId → (route → key) */
    private var streamsMap: Map<String, Map<String, Int>> = HashMap()
    /** modo → (key → (índice, número formatado com zeros)) */
    private var channelNum: Map<Int, Map<Int, Pair<Int, String>>> = HashMap()
    /** modo → (número → key) */
    private var numChannel: Map<Int, Map<Int, Int>> = HashMap()
    private var columnNames: Map<Int, List<String>> = HashMap()

    private var checksumInChannelList = ""
    private var columnAll = "ALL"
    private var columnPlayHistory = "PLAY HISTORY"
    private var columnFavorites = "FAVORITES"
    private var columnCatchup = "REPLAY"
    private var columnSubscribes = ""
    private var lastColumnKey = "ALL"
    private var checksumInUpdateNotice = ""
    private val gson = Gson()
    /** epgId → (startTime → (lembrar?, streamIds)) — persistido em "subscribed_channels". */
    private var inSubscribedMap: MutableMap<String, ConcurrentSkipListMap<Long, Pair<Boolean, Set<String>>>> = HashMap()

    /** Original: a.F(...) — nomes (traduzidos) das colunas fixas e carrega lembretes (a$k). */
    fun setColumnNames(all: String, history: String, favorites: String, catchup: String) {
        columnAll = all; columnPlayHistory = history; columnFavorites = favorites; columnCatchup = catchup
        loadSubscribedChannel()
    }

    /** Original: a.N(now, isRetryAfterFailure, isForce) */
    fun loadChannelList(now: Long, isRetryAfterFailure: Boolean = false, isForce: Boolean = false) {
        if (!isInLoading.compareAndSet(false, true)) { logger.warn("channel is in loading"); return }
        val token = UserManager.getStreamToken() // user.f.A0()
        if (token.isNullOrEmpty()) {
            logger.warn("stream token is empty, channel list not load")
            isInLoading.set(false); return
        }
        val next = nextUpdateTime
        if (isInitComplete && !isForce && next != null && next > now) { isInLoading.set(false); return }
        puckScope.launch { fetch(isRetryAfterFailure, token) }
    }

    /** Original: a.O(isRetry, isForce) */
    fun reload(isRetryAfterFailure: Boolean = false, isForce: Boolean = false) =
        loadChannelList(System.currentTimeMillis() /* d1.c() */, isRetryAfterFailure, isForce)

    /** Original: a$h.invokeSuspend ("loadChannelList$1") */
    private suspend fun fetch(isRetryAfterFailure: Boolean, token: String) {
        // Original: métrica tf.e.x(now)
        val h = HeaderInterceptor
        val rsp = ApiStreamMetaClient.getChannelList(h.tenantId().toString(), h.appId().toString(), h.appVersion(),
            checksumInChannelList, h.deviceId(), h.language(), 1, 2000, System.currentTimeMillis(), h.streamToken(), h.accountId())
        // Original: a$h.invokeSuspend — encadeamento de handlers do sandwich (suspendOnSuccess / suspendOnFailure /
        // suspendOnError / suspendOnException). Atenção: no original TODA falha passa primeiro por
        // `onLoadChannelFailure(v0.c(...))` (mensagem genérica) e só depois pelo tratamento específico.
        rsp.suspendOnSuccess { onLoadChannelSuccess(data, isRetryAfterFailure, token) }
        rsp.suspendOnFailure { onLoadChannelFailure(SandwichErrors.describe(this), isRetryAfterFailure, token) }
        rsp.suspendOnError {
            if (statusCode == StatusCode.NotFound) {
                logger.warn("load channel: new api not found try old api")
                val u = UserManager
                val old = ApiStreamMetaClient.getChannelList(u.getDid(), u.getAccountIdString(), u.getAppId(),
                    AppAttrUtils.appVersion(), System.currentTimeMillis(), u.getStreamToken(), checksumInChannelList, 1, 2000)
                old.suspendOnSuccess { onLoadChannelSuccess(data, isRetryAfterFailure, token) }
                old.suspendOnFailure { onLoadChannelFailure(SandwichErrors.describe(this), isRetryAfterFailure, token) }
                old.suspendOnError { onLoadChannelFailure(SandwichErrors.describe(this), isRetryAfterFailure, token) }
                old.suspendOnException { onLoadChannelFailure(SandwichErrors.describe(this), isRetryAfterFailure, token) }
            } else {
                onLoadChannelFailure(SandwichErrors.describe(this), isRetryAfterFailure, token)
            }
        }
        rsp.suspendOnException { onLoadChannelFailure(SandwichErrors.describe(this), isRetryAfterFailure, token) }
    }

    /** Original: a.U(ApiResult, isRetry, token) ("onLoadChannelSuccess") */
    private suspend fun onLoadChannelSuccess(result: ApiResult<ChannelListResponse>, isRetryAfterFailure: Boolean, token: String) {
        val checksum = result.checkSum ?: ""
        checksumInUpdateNotice = ""
        isInLoading.set(false)
        val data = result.data
        if (BaseLibConfig.isDebug) logger.debug("fetch channel list data[{}]", data)
        val ok = data != null
        if (!isInitComplete) isInitComplete = ok
        val now = System.currentTimeMillis()
        if (ok) {
            checksumInChannelList = checksum
            nextUpdateTime = now + 43200000 // 12 h
            // Original: métrica tf.e.u(now) + uf.c.p() na primeira carga
            buildChannels(data!!.channelStreams, data.categorySorts)
            EventBus.getDefault().removeStickyEvent(ChannelListEvent::class.java) // nf.d
            EventBus.getDefault().post(ChannelListEvent())
            EpgManager.update(data.channelEPGIndexResponse)
        } else if (!isInitComplete) {
            onLoadChannelFailure("got list response, but data is null, msg: ${result.msg}, code: ${result.code}", isRetryAfterFailure, token)
        } else if (checksum == checksumInChannelList) {
            nextUpdateTime = now + 43200000
        } else {
            nextUpdateTime = now + 300000
        }
    }

    /** Original: a.T(msg, isRetry, token) ("onLoadChannelFailure") */
    private suspend fun onLoadChannelFailure(msg: String, isRetryAfterFailure: Boolean, token: String) {
        isInLoading.set(false)
        val current = HeaderInterceptor.streamToken() // of.a.g()
        if (token.isNotEmpty() && token != current) { reload(isRetryAfterFailure); return } // token mudou no meio
        // Original: M(msg) — métrica de falha
        if (msg.lowercase(Locale.ROOT).contains("invalid token")) {
            // Original: UserManager.g1(null, null, false) ("login") coletado em a$n; erros do fluxo em a$m.
            val retryAfter = isRetryAfterFailure
            UserManager.login()
                .catch { e ->
                    logger.error("fetch channel list failure $msg, re-login failure", e)
                    EventBus.getDefault().post(ChannelListEvent(false, "", msg))
                    nextUpdateTime = System.currentTimeMillis() + if (isInitComplete) 300000L else 15000L
                }
                .collect { (ok, code, message) ->
                    if (ok) {
                        if (!isInitComplete && !isInLoading.get()) {
                            logger.debug("re-login complete[cause by: $msg], reload channel list")
                            reload(retryAfter)
                        }
                    } else {
                        logger.error("re-login failure[cause by: $msg], [$message($code)]")
                        EventBus.getDefault().post(ChannelListEvent(false, "", msg))
                        nextUpdateTime = System.currentTimeMillis() + if (isInitComplete) 300000L else 15000L
                    }
                }
        } else {
            TelegramBot.sendSysError("[load channel list]\nfailure:$msg") // bot.a.l
            botFailureTime = System.currentTimeMillis()
            logger.error("fetch channel list failure $msg and keep retry?$isRetryAfterFailure")
            if (isRetryAfterFailure) {
                delay(15000L)
                reload(true)
            } else if (isInitComplete) {
                logger.error("fetch channel list failure $msg, retry after 300000 ms")
                nextUpdateTime = System.currentTimeMillis() + 300000
            } else {
                nextUpdateTime = System.currentTimeMillis() + 15000
            }
        }
    }

    /**
     * Original: a.V(list, categorySorts) — indexação:
     * - colunas fixas (ALL, FAVORITES, subscribes, PLAY HISTORY, REPLAY) + categorias de `categories` ("a;b;c");
     * - canais adultos (type 1/3) só entram no modo 1; REPLAY recebe canais com `catchup`;
     * - ordenação por `displaySeq`; numeração 1..N com zeros à esquerda (largura = dígitos de N).
     * Ao final recalcula favoritos/histórico ([refreshLocalColumns]).
     */
    private suspend fun buildChannels(list: List<ChannelStreamResponse>?, categorySorts: List<String>?) {
        if (list.isNullOrEmpty()) return
        if (botFailureTime > 0) {
            TelegramBot.sendSysInfo("[load channel list]\nrecover in ${System.currentTimeMillis() - botFailureTime}")
            botFailureTime = 0
        }
        val byColumns = hashMapOf<Int, HashMap<String, MutableList<ChannelStreamResponse>>>(0 to HashMap(), 1 to HashMap())
        val positions = hashMapOf<Int, HashMap<String, MutableMap<Int, Int>>>(0 to HashMap(), 1 to HashMap())
        val normalColumns = HashSet<String>()
        val allColumns = HashSet<String>()
        val fixed = ArrayList<String>()
        val sorts = if (categorySorts.isNullOrEmpty()) ArrayList() else ArrayList(categorySorts)
        for (c in arrayOf(columnAll, columnFavorites, columnSubscribes, columnPlayHistory, columnCatchup)) {
            if (c.isNotEmpty()) { normalColumns.add(c); allColumns.add(c); fixed.add(c) }
        }
        val byKey = hashMapOf<Int, HashMap<Int, ChannelStreamResponse>>(0 to HashMap(), 1 to HashMap())
        val normalList = ArrayList<ChannelStreamResponse>()
        val streams = HashMap<String, HashMap<String, Int>>()
        var adult = false
        for (ch in list) {
            ch.key = Objects.hash(ch.streamId, ch.route) // a.L()
            streams.getOrPut(ch.streamId) { HashMap() }[ch.route] = ch.key
            val isAdult = ch.type == 1 || ch.type == 3
            byKey[1]!![ch.key] = ch
            if (!isAdult) { byKey[0]!![ch.key] = ch; normalList.add(ch) } else adult = true
            if (ch.isCatchup) {
                byColumns[1]!!.getOrPut(columnCatchup) { ArrayList() }.add(ch)
                if (!isAdult) byColumns[0]!!.getOrPut(columnCatchup) { ArrayList() }.add(ch)
            }
            val cols = arrayListOf(columnAll)
            if (!ch.categories.isNullOrEmpty()) {
                for (cat in ch.categories.split(";")) if (cat.isNotEmpty()) {
                    cols.add(cat); allColumns.add(cat); if (!isAdult) normalColumns.add(cat)
                }
            }
            for (col in cols) {
                byColumns[1]!!.getOrPut(col) { ArrayList() }.add(ch)
                if (!isAdult && normalColumns.contains(col)) byColumns[0]!!.getOrPut(col) { ArrayList() }.add(ch)
            }
        }
        isAdultExists = adult
        channelsMap = byKey
        streamsMap = streams
        for (c in allColumns.sorted()) if (!sorts.contains(c)) sorts.add(c)
        val names0 = ArrayList(fixed).apply { for (c in sorts.sorted()) if (!fixed.contains(c) && normalColumns.contains(c)) add(c) }
        val names1 = ArrayList(names0).apply { for (c in sorts.sorted()) if (!names0.contains(c) && allColumns.contains(c)) add(c) }
        // Nota: o original itera `r.I0(arrayList2)` (lista ordenada) — a ordem de categorySorts do servidor
        // só vale para as categorias novas; ver jadx a.V().
        columnNames = mapOf(0 to names0, 1 to names1)
        for (mode in 0..1) {
            for ((col, l) in byColumns[mode]!!) {
                if (l.size > 1) l.sortBy { it.displaySeq }
                val pos = positions[mode]!!.getOrPut(col) { HashMap() }
                l.forEachIndexed { i, ch -> pos[ch.key] = i }
            }
        }
        channelsByColumns = byColumns
        channelPositionsByColumns = positions
        val ordered = mapOf(0 to normalList.sortedBy { it.displaySeq }, 1 to list.sortedBy { it.displaySeq })
        channels = ordered
        val width = Math.log10(list.size.toDouble()).toInt() + 1
        val num = HashMap<Int, HashMap<Int, Pair<Int, String>>>()
        val rev = HashMap<Int, HashMap<Int, Int>>()
        for (mode in 0..1) {
            val sb = StringBuilder()
            ordered[mode]!!.forEachIndexed { i, ch ->
                val n = i + 1
                num.getOrPut(mode) { HashMap() }[ch.key] = i to formatNumber(n, sb, width)
                rev.getOrPut(mode) { HashMap() }[n] = ch.key
            }
        }
        channelNum = num
        numChannel = rev
        refreshLocalColumns()
    }

    /** Original: a.r(idx, sb, numCnt) — número com zeros à esquerda. */
    private fun formatNumber(idx: Int, sb: StringBuilder, numCnt: Int): String {
        sb.setLength(0)
        var digits = Math.log10(idx.toDouble()).toInt() + 1
        while (digits < numCnt) { sb.append("0"); digits++ }
        sb.append(idx)
        return sb.toString()
    }

    /**
     * Original: a.W() ("refreshLocalColumns") — chama [loadLocalColumns] e reconstrói favoritos/histórico
     * re-mapeando streamId → key atual (as keys mudam se a rota mudar).
     */
    private suspend fun refreshLocalColumns() {
        loadLocalColumns()
        for (type in arrayOf("favorites", "play_history")) {
            val src = if (type == "favorites") favoritesMap else playHistoryMap
            val all = channelsByColumns[playMode]?.get(columnAll) ?: continue
            val byStream = HashMap<String, Long>()
            for ((_, v) in src) byStream[v.first] = v.second
            val tree = TreeMap<Long, ChannelStreamResponse>()
            val rebuilt = HashMap<Int, Pair<String, Long>>()
            for (ch in all) {
                val t = byStream[ch.streamId] ?: continue
                tree[t] = ch
                rebuilt[ch.key] = ch.streamId to t
            }
            if (type == "favorites") favoritesMap = rebuilt else playHistoryMap = rebuilt
        }
    }

    /**
     * Original: a.R() ("loadLocalColumns") + a$i/a$j — para `play_history` e `favorites` lê o JSON
     * `Map<Int, Pair<String, Long>>` (key → (streamId, timestamp)) das preferências e atribui a
     * [playHistoryMap] / [favoritesMap]. Erros: logados ("load local [chave] failure") e segue para a próxima chave.
     */
    private suspend fun loadLocalColumns() {
        for (type in arrayOf("play_history", "favorites")) {
            try {
                val json = Preferences.getString(type, "")
                if (json.isBlank()) continue
                val map: MutableMap<Int, Pair<String, Long>> =
                    gson.fromJson(json, object : TypeToken<MutableMap<Int, Pair<String, Long>>>() {}.type)
                if (type == "play_history") playHistoryMap = map else if (type == "favorites") favoritesMap = map
            } catch (t: Throwable) {
                logger.error("load local [$type] failure", t)
            }
        }
    }

    /** Original: a.B(columnKey, mode) — favoritos (ordem displaySeq) ou histórico (ordem de acesso). */
    private fun localColumn(columnKey: String, mode: Int): List<ChannelStreamResponse> {
        val map = when (columnKey) { columnFavorites -> favoritesMap; columnPlayHistory -> playHistoryMap; else -> return ArrayList() }
        val all = channelsByColumns[mode]?.get(columnAll) ?: return ArrayList()
        val byStream = HashMap<String, Long>()
        synchronized(map) { for ((_, v) in map) byStream[v.first] = v.second }
        val out = ArrayList<ChannelStreamResponse>()
        if (columnKey != columnFavorites) {
            for (ch in all) if (byStream[ch.streamId] != null) out.add(ch)
            return out.sortedBy { byStream[it.streamId] }.reversed() // r.D0(J0(...)) = ordenar e inverter
        }
        for (ch in all) if (byStream[ch.streamId] != null) { byStream[ch.streamId] = ch.displaySeq.toLong(); out.add(ch) }
        return out.sortedBy { byStream[it.streamId] }
    }

    /** Original: a.b0(type, key, opType) — 0 remove, 1 adiciona (timestamp atual); persiste JSON. */
    private fun save(type: String, key: Int, opType: Int) {
        val streamId = channel(key)?.streamId ?: return
        val map = when (type) { "play_history" -> playHistoryMap; "favorites" -> favoritesMap; else -> return }
        synchronized(map) {
            when (opType) {
                0 -> map.remove(key)
                1 -> map[key] = streamId to System.currentTimeMillis()
                else -> return
            }
            Preferences.putString(type, gson.toJson(map))
        }
    }

    /** Original: a.Z(type, keys) */
    private fun removeAll(type: String, keys: List<Int>) {
        val map = when (type) { "play_history" -> playHistoryMap; "favorites" -> favoritesMap; else -> return }
        synchronized(map) {
            keys.forEach { map.remove(it) }
            Preferences.putString(type, gson.toJson(map))
        }
    }

    /** Original: a.n(key) */
    fun addPlayHistory(key: Int) = save("play_history", key, 1)
    /** Original: a.h0(key) — alterna favorito; devolve novo estado. */
    fun toggleFavorite(key: Int): Boolean { val f = isFavorite(key); save("favorites", key, if (!f) 1 else 0); return !f }
    /** Original: a.Y(keys) */
    fun removeFavorites(keys: List<Int>) = removeAll("favorites", keys)
    /** Original: a.a0(keys) */
    fun removePlayHistory(keys: List<Int>) = removeAll("play_history", keys)
    /** Original: a.J(key) */
    fun isFavorite(key: Int) = favoritesMap.containsKey(key)
    /** Original: a.z() */
    fun favorites() = localColumn(columnFavorites, 0)
    /** Original: a.D() */
    fun playHistory() = localColumn(columnPlayHistory, 0)

    /** Original: a.w(columnKey, isIncludeAdult) */
    fun channelsOf(columnKey: String, isIncludeAdult: Boolean?): List<ChannelStreamResponse> {
        lastColumnKey = columnKey
        val mode = if (isIncludeAdult == null) playMode else if (isIncludeAdult) 1 else 0
        if (columnKey == columnFavorites || columnKey == columnPlayHistory) return localColumn(columnKey, mode)
        return channelsByColumns[mode]?.get(columnKey) ?: ArrayList()
    }

    /** Original: a.x(isIncludeAdult) */
    fun columns(isIncludeAdult: Boolean?): List<String> {
        val mode = if (isIncludeAdult == null) playMode else if (isIncludeAdult) 1 else 0
        return columnNames[mode] ?: ArrayList()
    }

    /** Original: a.G(columnKey) — coluna só existe no modo adulto. */
    fun isAdultColumn(columnKey: String): Boolean =
        columnNames[1]?.contains(columnKey) == true && columnNames[0]?.contains(columnKey) != true

    /** Original: a.t(key) */
    fun channel(key: Int): ChannelStreamResponse? = channelsMap[playMode]?.get(key)
    /** Original: a.u(key) — sempre no modo 1 (inclui adultos). */
    fun channelAnyMode(key: Int): ChannelStreamResponse? = channelsMap[1]?.get(key)
    /** Original: a.v(streamId, routeId) */
    fun keyOf(streamId: String, routeId: String?): Int? {
        val m = streamsMap[streamId]
        if (m.isNullOrEmpty()) return null
        return if (routeId.isNullOrEmpty()) m.values.first() else m[routeId]
    }
    /** Original: a.p(response) — número exibido ("NA" se ausente). */
    fun channelNumber(response: ChannelStreamResponse): String = channelNum[1]?.get(response.key)?.second ?: "NA"

    /** Original: a.d0() / a.e0() — liga/desliga modo adulto e posta nf.n. */
    fun enableAdultMode() { if (playMode == 1) return; playMode = 1 /* EventBus nf.n(true) */ }
    fun disableAdultMode() { if (playMode == 0) return; playMode = 0 /* EventBus nf.n(false) */ }
    /** Original: a.H() */
    fun isAdultMode() = playMode == 1
    /** Original: a.K() */
    fun isLoading() = isInLoading.get()
    /** Original: a.y() / a.E() */
    fun columnAll() = columnAll
    fun columnPlayHistory() = columnPlayHistory

    // ------------------------------------------------------------------ lembretes (subscribe)

    /** Original: a.f0(epgId, streamId, start) — chave do [SubscribeCache]. */
    private fun subscribeKey(epgId: String, streamId: String, startTime: Long) = "$epgId.$streamId.$startTime"

    /** Original: a.I(key, startTime, epgId) */
    fun isSubscribed(key: Int, startTime: Long, epgId: String): Boolean {
        val streamId = channelsMap[playMode]?.get(key)?.streamId ?: return false
        return inSubscribedMap[epgId]?.get(startTime)?.second?.contains(streamId) == true
    }

    /** Original: a.o(...) ("changeChannelRemindFlag") */
    suspend fun changeRemindFlag(key: Int, startTime: Long, epgId: String, sportId: String, available: Boolean) {
        val ch = channelsMap[playMode]?.get(key) ?: return
        val k = subscribeKey(epgId, ch.streamId!!, startTime)
        val item = SubscribeCache.get(k)
        if (item != null && item.sportId == sportId && item.isAvailable != available) {
            item.isAvailable = available
            SubscribeCache.put(k, item)
        }
    }

    /** Original: a.X() — remove lembretes com início há mais de 3 dias. */
    private fun removeExpiredSubscribes() {
        val now = System.currentTimeMillis()
        val empty = HashSet<String>()
        for ((epgId, m) in inSubscribedMap) {
            while (m.isNotEmpty()) {
                val first = m.firstKey()
                if (first >= now - 259200000) break
                lastInSubscribedChangeTime = now
                val removed = m.remove(first)
                if (BaseLibConfig.isDebug) logger.debug("SubscribeIO remove expired epgId[{}] time[{}] subscribe[{}]", epgId, first, removed)
            }
            if (m.isEmpty()) empty.add(epgId)
        }
        for (e in empty) { inSubscribedMap.remove(e); if (BaseLibConfig.isDebug) logger.debug("SubscribeIO remove expired epgId[{}]", e) }
    }

    /** Original: a.c0() */
    private fun saveSubscribes() {
        if (lastInSubscribedChangeTime < lastInSubscribedSaveTime) return
        try {
            if (BaseLibConfig.isDebug) logger.debug("SubscribeIO save subscribes[{}]", inSubscribedMap)
            Preferences.putString("subscribed_channels", gson.toJson(inSubscribedMap))
            lastInSubscribedSaveTime = System.currentTimeMillis()
        } catch (e: Exception) { logger.error("save subscribed channels failure", e) }
    }

    /**
     * Original: a.S() / a$k ("loadSubscribedChannel") — lê "subscribed_channels"
     * (`Map<epgId, ConcurrentSkipListMap<início, Pair<lembrar?, Set<streamId>>>>`, tipo a$k$a). Vazio ⇒ mantém o mapa
     * atual; erro ⇒ loga "load subscribed failure" e mantém.
     */
    private fun loadSubscribedChannel() {
        puckScope.launch {
            try {
                val json = Preferences.getString("subscribed_channels", "")
                if (json.isNotBlank()) {
                    inSubscribedMap = gson.fromJson(json,
                        object : TypeToken<MutableMap<String, ConcurrentSkipListMap<Long, Pair<Boolean, Set<String>>>>>() {}.type)
                }
            } catch (t: Throwable) { logger.error("load subscribed failure", t) }
        }
    }

    /**
     * Original: a.q(now) ("executeSubscribe") + a$b — chamado pelo heartbeat. Dispara os avisos ("notice") dos
     * lembretes que estão para começar:
     * 1. janela = `remindMillisSecondsBeforeTheProgrammeStart` se entre 5001 e 599999 ms, senão 5000 ms;
     * 2. para cada epgId/início de [inSubscribedMap] com `início <= now + janela` e flag `false` (ainda não avisado):
     *    marca o flag como `true`, guarda `lastExecuteSubscribeTime = now` e resolve o programa por streamId:
     *    com `epgId` vazio a partir do [SubscribeItem] em cache (ou programa vazio); senão por
     *    [EpgManager.getProgrammeAt] (`início + 1`) — sem programa ou programa já terminado só gera warn
     *    ("no program found" / "already expired, don't send notice"); itens do cache marcados indisponíveis são pulados;
     * 3. epgIds cujas entradas estão todas dentro da janela (nada futuro) são removidos;
     * 4. para cada canal da coluna de lembretes do modo atual com programa resolvido posta [SubscribeNoticeEvent]
     *    (nf.m); por fim [removeExpiredSubscribes] e [saveSubscribes].
     * (Reconstruído do fallback do jadx; a leitura de `epgId` vazio é a mais provável dado o registrador reutilizado.)
     */
    suspend fun executeSubscribe(now: Long) {
        val serverNow = ServerTime.now() // util/d1.d()
        val found = HashMap<String, EPGProgramme>()
        val doneEpgIds = ArrayList<String>()
        var window = 5000L
        val cfg = BaseLibConfig.remindMillisSecondsBeforeTheProgrammeStart
        if (cfg in 5001 until 600000) window = cfg
        for ((epgId, times) in inSubscribedMap) {
            var allWithinWindow = true
            for (start in ArrayList(times.keys)) {
                if (start > now + window) { allWithinWindow = false; continue }
                val entry = times[start] ?: continue
                if (BaseLibConfig.isDebug) logger.debug("SubscribeIO exec get a subscribe: [{}]->[{}]", start, entry)
                if (entry.first) continue
                times[start] = Pair(true, entry.second)
                lastExecuteSubscribeTime = now
                if (epgId.isEmpty()) {
                    for (streamId in entry.second) {
                        val item = SubscribeCache.get(subscribeKey(epgId, streamId, start))
                        if (item != null && !item.isAvailable) continue
                        found[streamId] = EPGProgramme().apply {
                            channel = epgId
                            if (item != null) { this.start = item.start; end = item.stop; title = item.title; desc = item.desc }
                            else { this.start = start; title = ""; desc = "" }
                        }
                    }
                } else {
                    val programme = EpgManager.getProgrammeAt(epgId, start + 1)
                    if (programme == null) {
                        logger.warn("SubscribeIO exec no program found for subscribed, epgId[{}], startTime[{}]", epgId, start)
                        continue
                    }
                    if (programme.end <= serverNow) {
                        logger.warn("SubscribeIO exec subscribed program is already expired, don't send notice, epgId[{}], startTime[{}], [{} - {}]",
                            epgId, start, programme.start, programme.end)
                        continue
                    }
                    for (streamId in entry.second) {
                        val item = SubscribeCache.get(subscribeKey(epgId, streamId, start))
                        if (item != null && !item.isAvailable) continue
                        found[streamId] = programme
                    }
                }
            }
            if (allWithinWindow) doneEpgIds.add(epgId)
        }
        for (epgId in doneEpgIds) {
            inSubscribedMap.remove(epgId)
            if (BaseLibConfig.isDebug) logger.debug("SubscribeIO exec remove from subscribed, epgId[{}]", epgId)
        }
        val subscribedChannels = channelsByColumns[playMode]?.get(columnSubscribes) ?: ArrayList()
        for (ch in subscribedChannels) {
            val p = found[ch.streamId] ?: continue
            if (BaseLibConfig.isDebug) logger.debug("SubscribeIO notice:[{}]", p)
            EventBus.getDefault().post(SubscribeNoticeEvent(ch.key, p.channel, p.start, p.end, ch.streamName, p.title, p.desc))
        }
        removeExpiredSubscribes()
        saveSubscribes()
    }

    /**
     * Original: a.s(String) ("generateSubscribeList") + a$c — monta a lista de lembretes como
     * `Triple(key do canal, início, programa)`. `key` = `"subscribed_channels"` (flag `false`) ou
     * `"expired_subscribed_channels"` (flag `true`); outro valor ⇒ lista vazia. Passos:
     * 1. inverte [inSubscribedMap] (epgId → início → (flag, {streamId})) em `streamId → (início → epgId)` considerando
     *    só as entradas com `pair.first == flag`;
     * 2. para cada canal do modo atual cujo `streamId` está nesse índice e para cada início: lê o [SubscribeItem] do
     *    [SubscribeCache] (chave `epgId.streamId.início`); item existente mas indisponível é ignorado; com item monta
     *    o [EPGProgramme] a partir dele (canal=epgId, stop/título/descrição do item); sem item usa
     *    [EpgManager.getProgrammeAt] e, se não houver, um programa vazio com canal e início.
     */
    suspend fun generateSubscribeList(key: String): List<Triple<Int, Long, EPGProgramme>> {
        val flag = when (key) {
            "subscribed_channels" -> false
            "expired_subscribed_channels" -> true
            else -> return ArrayList()
        }
        val result = ArrayList<Triple<Int, Long, EPGProgramme>>()
        val channelsOfMode = channelsMap[playMode] ?: return result
        val byStream = HashMap<String, TreeMap<Long, String>>()
        for ((epgId, times) in inSubscribedMap) {
            for ((start, pair) in times) {
                if (pair.first != flag) continue
                for (streamId in pair.second) byStream.getOrPut(streamId) { TreeMap() }[start] = epgId
            }
        }
        for ((channelKey, channel) in channelsOfMode) {
            val streamId = channel.streamId
            val times = byStream[streamId] ?: continue
            for ((start, epgId) in times) {
                val item = SubscribeCache.get(subscribeKey(epgId, streamId!!, start))
                if (item != null && !item.isAvailable) continue
                val programme: EPGProgramme = if (item != null) {
                    EPGProgramme().apply {
                        this.channel = epgId; this.start = start; this.end = item.stop
                        title = item.title; desc = item.desc; category = ""
                    }
                } else {
                    EpgManager.getProgrammeAt(epgId, start) ?: EPGProgramme().apply {
                        this.channel = epgId; this.start = start; title = ""; desc = ""; category = ""
                    }
                }
                result.add(Triple(channelKey, start, programme))
            }
        }
        if (BaseLibConfig.isDebug) logger.debug("SubscribeIO generate[$key], from[{}] -> to[{}], result[{}]", inSubscribedMap, byStream, result)
        return result
    }

    /** Original: a.A() ("getInSubscribedProgrammes") — `generateSubscribeList("subscribed_channels")` ordenado por tempo. */
    suspend fun inSubscribedProgrammes(): List<Triple<Int, Long, EPGProgramme>> =
        generateSubscribeList("subscribed_channels").sortedBy { it.second }

    /**
     * Original: a.g0(key, startTime, epgId, item) ("toggleChannelSubscribe") — alterna o lembrete do programa
     * (`epgId`, `startTime`) para o canal [key] do modo atual. Já inscrito ⇒ remove o `streamId` (apagando as
     * entradas que ficarem vazias) e devolve `false`; senão adiciona (gravando [item] no [SubscribeCache] quando
     * informado) e devolve `true`. Canal inexistente ⇒ `false`. Persiste via [saveSubscribes].
     * (Inferência: o jadx perdeu a atribuição de `lastInSubscribedChangeTime = now` antes de `c0()`.)
     */
    suspend fun toggleSubscribe(key: Int, startTime: Long, epgId: String, item: SubscribeItem?): Boolean {
        val channel = channelsMap[playMode]?.get(key) ?: return false
        val streamId = channel.streamId!!
        var times = inSubscribedMap[epgId]
        val entry = times?.get(startTime)
        val subscribed: Boolean
        if (entry != null) {
            val streams = entry.second as MutableSet<String>
            if (streams.contains(streamId)) {
                streams.remove(streamId)
                if (BaseLibConfig.isDebug) logger.debug("SubscribeIO toggle remove from subscribed mode[{}], epgId[{}], time[{}], streamId[{}]", playMode, epgId, startTime, streamId)
                if (streams.isEmpty()) {
                    times?.remove(startTime)
                    if (BaseLibConfig.isDebug) logger.debug("SubscribeIO toggle remove mode[{}], epgId[{}], startTime[{}]", playMode, epgId, startTime)
                    if (times != null && times.isEmpty()) {
                        inSubscribedMap.remove(epgId)
                        if (BaseLibConfig.isDebug) logger.debug("SubscribeIO toggle remove mode[{}], epgId[{}]", playMode, epgId)
                    }
                }
                subscribed = false
            } else {
                streams.add(streamId)
                if (item != null) SubscribeCache.put(subscribeKey(epgId, streamId, startTime), item)
                if (BaseLibConfig.isDebug) logger.debug("SubscribeIO toggle add to subscribed mode[{}], epgId[{}], time[{}], streamId[{}]", playMode, epgId, startTime, streamId)
                subscribed = true
            }
        } else {
            if (times == null) {
                times = ConcurrentSkipListMap()
                inSubscribedMap[epgId] = times
            }
            val created = times[startTime] ?: Pair<Boolean, Set<String>>(false, HashSet()).also { times[startTime] = it }
            (created.second as MutableSet<String>).add(streamId)
            if (item != null) SubscribeCache.put(subscribeKey(epgId, streamId, startTime), item)
            if (BaseLibConfig.isDebug) logger.debug("SubscribeIO toggle add to subscribed mode[{}], epgId[{}], time[{}], streamId[{}]", playMode, epgId, startTime, streamId)
            subscribed = true
        }
        lastInSubscribedChangeTime = System.currentTimeMillis()
        saveSubscribes()
        return subscribed
    }
}
