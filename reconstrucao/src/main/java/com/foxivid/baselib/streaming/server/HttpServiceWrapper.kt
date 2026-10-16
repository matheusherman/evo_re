package com.foxivid.baselib.streaming.server

import android.util.LruCache
import com.foxivid.baselib.api.ApiStreamMetaClient
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.event.StreamingEvent
import com.foxivid.baselib.metric.monitor.StreamingMonitor
import com.foxivid.baselib.util.DownloadUtils
import com.foxivid.baselib.util.StartStatUtil
import com.skydoves.sandwich.getOrThrow
import com.foxivid.baselib.network.HeaderInterceptor
import com.foxivid.baselib.model.meta.CatchupPlayRequest
import com.foxivid.baselib.model.meta.CatchupPlayResponse
import com.foxivid.baselib.model.user.ServerResponse
import com.foxivid.baselib.streaming.StreamHelper
import com.foxivid.baselib.streaming.engine.PlayType
import com.foxivid.baselib.streaming.engine.StreamEngine
import com.foxivid.baselib.streaming.engine.TrackerAddress
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.InetSocketAddress
import java.util.Locale
import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicLong

/**
 * Original: x1/f1/lb/streaming/server/d.java ("HttpServiceWrapper.kt") (+ d$a, d$CatchupCacheItem, d$c..d$k)
 *
 * Roteador das requisições recebidas por [NioHttpServer]. Rotas (nomes aleatórios de [StreamingKeys]):
 *
 * | rota | ação |
 * |---|---|
 * | `/`, `/ping`, `/test` | "Http server is running" |
 * | `/<startEngine>?<params>` | [startEngine]: cria o motor com a lista de trackers |
 * | `/<isEngineRunning>` | motor existe? |
 * | `/<stopEngine>` | [stopEngine] |
 * | `/<startPlay>?<session>&<params>` | [startPlay]: manda o motor tocar mediaId/routeId |
 * | `/<stopPlay>?<session>` | [stopPlay] |
 * | `/<addPlayer>` / `/<removePlayer>` | registra/remove id do IMediaPlayer válido para a sessão |
 * | `/<refreshToken>?<token>` | repassa token novo ao tracker |
 * | `/<isConnected>?<type>` | PR conectado para o tipo? |
 * | `/<getSubtitle>?<mediaId>&<lang>` | legenda `<LANG>.srt` vinda do motor |
 * | `/<startCatchup>.m3u8` | [onCatchupStartPlayRequest]: pede URL de catch-up à API e reescreve a playlist |
 * | `/<catchupTs>_N.ts` | [onCatchupTsRequest]: baixa o segmento do CDN de catch-up (proxy HTTP) |
 * | qualquer outro (`/<liveM3u8>.m3u8`, `*.ts`) | [onPlayRequest]: HLS servido pelo motor |
 *
 * Respostas de controle são o texto "true"/"false".
 */
class HttpServiceWrapper {

    private val logger = LoggerFactory.getLogger(HttpServiceWrapper::class.java)

    private var clientEngineService: EngineService? = null
    private var lastIndex: ByteArray? = null
    private var httpServer: LocalHttpServer? = null
    private var playListRequestCnt = 0
    private var playBlockResponseCnt = 0
    private var blockCacheHitMap: HashMap<String, Boolean>? = null
    private var lastPlaySession: Long = 0
    private var playType: PlayType = PlayType.LIVE
    private val validPlayer = HashMap<Long, HashSet<Int>>()
    private val playSession = AtomicLong(0)
    private var blockDurations = HashMap<String, Double>()
    private val catchupPlayResponseCache = LruCache<Long, CatchupCacheItem>(10)

    /** Original: d$a — adaptador de resposta/parâmetros (implementado por NioHttpServer). */
    interface Callback<T> {
        fun respond(statusCode: Int, content: ByteArray, contentType: String) // a
        fun param(params: T, key: String): String                              // b
    }

    /** Original: d$CatchupCacheItem — resposta de /api/catchup/getPlayUrl/v1 em cache por sessão. */
    data class CatchupCacheItem(
        val urlPrefix: String,
        val request: CatchupPlayRequest,
        val response: CatchupPlayResponse,
        val tokenExpiredTime: Long,
        var listSize: Int = 0,
    )

    /** Original: d.t(f) */
    fun attach(server: LocalHttpServer) {
        httpServer = server
        if (clientEngineService == null) {
            clientEngineService = EngineService(object : EngineService.MetricListener {   // StreamingMonitor (g) implementa b$c
                override fun n(bytes: Long, resendCount: Long, resendRate: Int, costMillis: Long, avgLossRate: Int, avgSpeedBps: Long,
                               rtt: Int, minRtt: Int, maxRtt: Int, avgRtt: Int) =
                    StreamingMonitor.onBlockNetStats(bytes, resendCount, resendRate, costMillis, avgLossRate, avgSpeedBps, rtt, minRtt, maxRtt, avgRtt)
            })
        } else {
            logger.info("local client engine service already started")
        }
        VodLocalDiskCacheManager.setListener(object : VodLocalDiskCacheManager.Listener {})
    }

    /** Original: d.z(String, T, a) — roteamento. */
    fun <T> handle(uri: String, params: T, cb: Callback<T>) {
        if (BaseLibConfig.isDebug) logger.debug("proxy_request handle[$uri]")
        val k = StreamingKeys
        fun ok(v: Any) = cb.respond(200, v.toString().toByteArray(), TEXT)
        when {
            uri == "/" || uri == "/ping" || uri == "/test" -> ok("Http server is running")
            uri == "/${k.startEngine}" -> ok(startEngine(cb.param(params, k.paramsKey)))
            uri == "/${k.isEngineRunning}" -> ok(clientEngineService?.isEngineRunning() == true)
            uri == "/${k.stopEngine}" -> ok(stopEngine())
            uri == "/${k.startPlay}" -> ok(startPlay(cb.param(params, k.sessionKey), cb.param(params, k.paramsKey)))
            uri == "/${k.stopPlay}" -> ok(stopPlay(cb.param(params, k.sessionKey)))
            uri == "/${k.addPlayer}" -> ok(addPlayer(cb.param(params, k.sessionKey), cb.param(params, k.playerKey)))
            uri == "/${k.removePlayer}" -> ok(removePlayer(cb.param(params, k.sessionKey), cb.param(params, k.playerKey)))
            uri == "/${k.refreshToken}" -> ok(refreshToken(cb.param(params, k.tokenKey)))
            uri == "/${k.isConnected}" -> {
                val type = StreamHelper.decodeParams(cb.param(params, k.typeKey))
                ok(clientEngineService?.isConnected(type) ?: false)
            }
            uri == "/${k.getSubtitle}" -> onSubtitleRequest(params, cb)
            uri == "/${k.startCatchup}.m3u8" -> onCatchupStartPlayRequest(params, cb)
            uri.startsWith("/${k.catchupTs}") -> onCatchupTsRequest(uri, params, cb)
            else -> onPlayRequest(uri, params, cb)
        }
    }

    /**
     * Original: d.I(String)
     * Parâmetros decifrados: addressList (JSON de [ServerResponse] = "streamServers" do login),
     * token, uid, did, tenantId, deviceType, type (PlayType).
     * Cada `serverAddress` "host:porta" vira um [TrackerAddress] (UDP).
     */
    private fun startEngine(params: String?): Boolean {
        if (params.isNullOrEmpty()) {
            logger.error("empty parameter to start engine"); return false
        }
        val map = StreamingKeys.parseParams(params)
        val deviceType = map["deviceType"]?.toInt() ?: 0
        map["type"]?.toByte()?.let { playType = PlayType.of(it)!! }
        return try {
            val servers: List<ServerResponse> = Gson().fromJson(map["addressList"], object : TypeToken<List<ServerResponse>>() {}.type)
            val trackers = servers.map { sr ->
                val parts = sr.serverAddress?.split(":")?.dropLastWhile { it.isEmpty() }
                TrackerAddress().apply {
                    serverId = sr.serverId
                    address = InetSocketAddress(parts?.get(0) ?: "", parts?.get(1)?.toInt() ?: 0)
                }
            }
            val started = clientEngineService?.startEngine(map["uid"], map["did"], map["token"], map["tenantId"], deviceType, trackers, playType) ?: false
            if (BaseLibConfig.isDebug && !started) logger.debug("start play failure, params{}", map)
            started
        } catch (t: Throwable) {
            logger.error("start engine failure in proxy", t); false
        }
    }

    /** Original: d.K() */
    private fun stopEngine(): Boolean {
        val old = playSession.getAndSet(0)
        synchronized(validPlayer) { validPlayer.remove(old) }
        return clientEngineService?.stopEngine() ?: false
    }

    /** Original: d.J(String, String) — params: mediaId, routeId, mediaMode. */
    private fun startPlay(sessionStr: String?, params: String?): Boolean {
        if (params.isNullOrEmpty()) { logger.error("empty parameter to start play"); return false }
        lastIndex = null
        val map = StreamingKeys.parseParams(params)
        val mediaId = map["mediaId"]; val routeId = map["routeId"]
        val mediaMode = map["mediaMode"]?.toInt() ?: 0
        val session = sessionStr?.toLong() ?: 0L
        if (BaseLibConfig.isDebug) logger.debug("start play [$mediaId, $mediaMode, $session]")
        try {
            val ok = clientEngineService?.startPlay(mediaId, routeId, mediaMode, session) ?: false
            if (!ok) {
                if (BaseLibConfig.isDebug) logger.debug("start play failure, params{}", map)
                else logger.debug("start play failure, session{}", session)
                return false
            }
            if (BaseLibConfig.isDebug) logger.debug("set play_session[$session]")
            playSession.set(session)
            playListRequestCnt = 0; playBlockResponseCnt = 0
            blockDurations = HashMap(); blockCacheHitMap = HashMap()
            StreamingMonitor.registerSession(session)   // x1.f1.lb.metric.monitor.g.y(session)
            return true
        } catch (t: Throwable) {
            throw RuntimeException("${t.localizedMessage ?: t.message} [$mediaId, $mediaMode]", t)
        }
    }

    /** Original: d.L(String) */
    private fun stopPlay(session: String): Boolean {
        val req = session.toLong()
        val cur = playSession.get()
        if (BaseLibConfig.isDebug) logger.debug("clean play_session request[$req] -> current[$cur]")
        if (!playSession.compareAndSet(req, 0L)) {
            if (cur == 0L) return true
            logger.warn("stop play failure, request session[$session] is not match current session[${playSession.get()}]")
            return false
        }
        // Original: metric.monitor.g.z(req)
        lastIndex = null
        synchronized(validPlayer) { validPlayer.remove(req) }
        lastPlaySession = req
        return clientEngineService?.stopPlay(req) ?: false
    }

    /** Original: d.j(String, String) */
    private fun addPlayer(session: String, player: String): Boolean {
        val s = session.toLong(); val p = player.toInt()
        synchronized(validPlayer) {
            validPlayer.getOrPut(s) { HashSet() }.add(p)
            clientEngineService?.setPlayer(s, p)
        }
        return true
    }

    /** Original: d.G(String, String) */
    private fun removePlayer(session: String, player: String): Boolean {
        val s = session.toLong(); val p = player.toInt()
        synchronized(validPlayer) {
            clientEngineService?.clearPlayer(s)
            return validPlayer[s]?.remove(p) == true
        }
    }

    /** Original: d.F(String) */
    private fun refreshToken(encoded: String): String {
        val token = StreamHelper.decodeParams(encoded)
        val svc = clientEngineService ?: return "false"
        svc.refreshToken(token)
        return "true"
    }

    /** Original: d.A(T, a) */
    private fun <T> onSubtitleRequest(params: T, cb: Callback<T>) {
        val data = try {
            val lang = cb.param(params, StreamingKeys.langKey)
            clientEngineService?.getData(playSession.get(), cb.param(params, StreamingKeys.mediaIdKey),
                lang.uppercase(Locale.ROOT) + ".srt", 30000 /* Priority.WARN_INT */)
        } catch (e: Exception) { logger.error("load failure", e); null }
        if (data != null) cb.respond(200, data, TEXT) else cb.respond(404, "Not found".toByteArray(), TEXT)
    }

    /**
     * Original: d.y(String, T, a)
     * Playlist (`/<liveM3u8>.m3u8?<session>&<player>&<params>`) ou bloco (`*.ts?<params>` com
     * `play_session`, `player`, `media_id` cifrados). Valida sessão e player e delega.
     */
    private fun <T> onPlayRequest(uri: String, params: T, cb: Callback<T>) {
        val isPlaylist = uri.startsWith("/${StreamingKeys.liveM3u8}.m3u8")
        val isTs = uri.endsWith(".ts")
        val tsParams = if (isTs) StreamingKeys.parseParams(cb.param(params, StreamingKeys.paramsKey)) else null
        var session = 0L
        try {
            session = when {
                isPlaylist -> cb.param(params, StreamingKeys.sessionKey).toLong()
                isTs -> (tsParams?.get("play_session") ?: "0").toLong()
                else -> 0
            }
        } catch (_: Throwable) {}
        val start = System.currentTimeMillis()
        val cur = playSession.get()
        if (BaseLibConfig.isDebug) {
            if (isPlaylist) logger.debug("playlist request play_session request[$session] -> cur[$cur]")
            else if (isTs) logger.debug("ts request play_session request[$session] -> cur[$cur]")
        }
        if (cur != session) {
            when {
                cur == 0L -> logger.warn("$uri, session in request[ $session ], but no active session in server, last session[ $lastPlaySession ]")
                lastPlaySession == session -> logger.warn("$uri, session is closed in request[ $session ], current session in server[ $cur ]")
                else -> logger.warn("$uri, invalid session in request[ $session ], current session in server[ $cur ]")
            }
            cb.respond(404, "request session is not available".toByteArray(), TEXT); return
        }
        var player = 0
        try {
            player = when {
                isPlaylist -> cb.param(params, StreamingKeys.playerKey).toInt()
                isTs -> (tsParams?.get("player") ?: "0").toInt()
                else -> 0
            }
        } catch (_: Throwable) {}
        if (!isValidPlayer(session, player)) {
            logger.warn("invalid player, inRequest[ $session , $player ], inServer[ $validPlayer ]  $uri")
            cb.respond(404, "player is invalid".toByteArray(), TEXT); return
        }
        if (isPlaylist) {
            val size = onPlaylistRequest(params, session, player, cb)
            if (BaseLibConfig.isDebug) logger.debug("playlist response size[$size][${System.currentTimeMillis() - start}] play_session[$session]->[$cur]")
            return
        }
        if (!isTs) { cb.respond(404, ByteArray(0), TEXT); return }
        val size = onBlockRequest(player, uri, session, tsParams?.get("media_id") ?: "", cb)
        if (BaseLibConfig.isDebug) logger.debug("ts response size[$size][${System.currentTimeMillis() - start}] play_session[$session]->[$cur]")
    }

    /**
     * Original: d.D(T, long, int, a)
     * Lê `playlist.m3u8` do motor e reescreve cada URI de segmento acrescentando
     * `<params>=<cifra("play_session=..&player=..&media_id=..")>` ([rewritePlaylist]).
     * Content-Type `application/vnd.apple.mpegurl`; 404 "Page Not found" se o motor não tem índice.
     */
    private fun <T> onPlaylistRequest(params: T, session: Long, player: Int, cb: Callback<T>): Int {
        val map = StreamingKeys.parseParams(cb.param(params, StreamingKeys.paramsKey))
        val mediaId = map["mediaId"] ?: ""
        val mediaMode = map["mediaMode"]?.toByte() ?: 2
        // 1ª requisição de playlist da sessão: registra a etapa "<mediaId>.receive_player_request" (x1.f1.lb.util.a1.h)
        if (playListRequestCnt++ == 0) StartStatUtil.addStep(session, "$mediaId.receive_player_request")
        try {
            val index = clientEngineService?.getData(session, mediaId, "playlist.m3u8")
            val lines = splitLines(index)
            if (BaseLibConfig.isDebug) logger.debug("play_list [{}]\n{}", session, lines)
            return if (index != null) {
                val (_, body) = rewritePlaylist(lines, session, player, mediaId)
                cb.respond(200, body, "application/vnd.apple.mpegurl")
                index.size
            } else {
                cb.respond(404, "Page Not found".toByteArray(), TEXT)
                0
            }
        } catch (t: Throwable) {
            val msg = t.localizedMessage ?: t.message ?: "playlist failure"
            cb.respond(500, "Server Interval Error".toByteArray(), TEXT)
            throw RuntimeException("$msg inRequest[mediaId=$mediaId, mediaMode=$mediaMode, session=$session], playType[$playType]", t)
        }
    }

    /** Original: d.B(List, long, int, String) */
    private fun rewritePlaylist(m3u8: List<String>, session: Long, player: Int, mediaId: String): Pair<List<String>, ByteArray> {
        val blocks = ArrayList<String>()
        val sb = StringBuilder()
        val durations = ArrayList<Double>()
        val enc = StreamHelper.encodeParams("play_session=$session&player=$player&media_id=$mediaId")
        for (raw in m3u8) {
            val line = raw.trim()
            if (line.startsWith("#")) {
                sb.append(line).append("\n")
                if (line.startsWith("#EXTINF:") && blockDurations.size < 3) {
                    try { durations.add(line.substring(8).trimEnd(',').toDouble()) } catch (t: Throwable) { logger.error("parse ext-info failure", t) }
                }
            } else {
                sb.append(line).append(if (line.contains("?")) "&" else "?")
                sb.append("${StreamingKeys.paramsKey}=$enc\n")
                blocks.add(line)
                if (durations.size >= blocks.size && blockDurations.size < 3) blockDurations[line] = durations[blocks.size - 1]
            }
        }
        return blocks to sb.toString().toByteArray()
    }

    /** Original: d.C(int, String, long, String, a) — bloco `<nome>.ts` do motor; `video/m2ts`. */
    private fun <T> onBlockRequest(player: Int, uri: String, session: Long, mediaId: String, cb: Callback<T>): Int {
        val path = if (uri.first() == '/') uri.substring(1) else uri // ua.n.T0 = first()
        val blockName = path.substringBefore(".ts")
        val data = if (blockName.isEmpty()) null else clientEngineService?.getData(session, mediaId, "$blockName.ts")
        // Original: registra métricas de bloco (metric.monitor.n.i/a) com duração e cache-hit
        return if (data != null) {
            playBlockResponseCnt++
            cb.respond(200, data, "video/m2ts"); data.size
        } else {
            cb.respond(404, "Page Not found".toByteArray(), TEXT); 0
        }
    }

    /** Original: d.u(long, int) — espera até 1 s (passos de 500 ms) o player ser registrado via addPlayer. */
    private fun isValidPlayer(session: Long, player: Int): Boolean {
        val start = System.currentTimeMillis()
        synchronized(validPlayer) {
            while (true) {
                val set = validPlayer[session]
                val ok = set == null || set.isEmpty() || set.contains(player)
                if (ok || System.currentTimeMillis() - start > 1000) return ok
                Thread.sleep(500)
            }
        }
        @Suppress("UNREACHABLE_CODE") return false
    }

    // ---------------------------------------------------------------- catch-up

    /**
     * Original: d.x(T, a) — `/<startCatchup>.m3u8?<session>&<player>&<params>`;
     * params cifrados: streamId, catchupStreamId, route, start, stop (ms).
     */
    private fun <T> onCatchupStartPlayRequest(params: T, cb: Callback<T>) {
        val sessionStr = cb.param(params, StreamingKeys.sessionKey)
        val player = cb.param(params, StreamingKeys.playerKey)
        val map = StreamingKeys.parseParams(cb.param(params, StreamingKeys.paramsKey))
        val streamId = map["streamId"] ?: ""
        val catchupStreamId = map["catchupStreamId"] ?: ""
        val route = map["route"] ?: ""
        val start = map["start"]?.toLong() ?: 0L
        val stop = map["stop"]?.toLong() ?: 0L
        try {
            val session = sessionStr.toLong()
            logger.info("session[$sessionStr] catchup playlist request, streamId[$streamId] route[$route]")
            CoroutineScope(Dispatchers.IO).launch {
                val playlist = getCatchupPlaylist(session, player, streamId, catchupStreamId, route, start, stop)
                if (playlist.isNotEmpty()) {
                    logger.info("session[$sessionStr] catchup playlist response, streamId[$streamId] route[$route] content-length[${playlist.length}]")
                    cb.respond(200, playlist.toByteArray(), TEXT)
                } else {
                    logger.error("session[$sessionStr] catchup playlist response empty, streamId[$streamId] route[$route] content-length[0]")
                    cb.respond(404, "Not found".toByteArray(), TEXT)
                }
            }
            playSession.set(session)
            playListRequestCnt = 0; playBlockResponseCnt = 0
            blockDurations = HashMap()
            lastPlaySession = session
        } catch (t: Throwable) {
            cb.respond(404, "Invalid session".toByteArray(), TEXT)
            logger.error("session[$sessionStr] is invalid", t)
        }
    }

    /**
     * Original: d.p(...) ("getCatchupPlaylist")
     * 1. GET /api/catchup/getPlayUrl/v1 ([getCatchupPlayUrl]) → playUrl + token + validTime.
     * 2. Baixa a playlist em `playUrl?token` (seguindo sub-playlists .m3u8) e reescreve cada `.ts` como
     *    `<catchupTs>_<n>.ts?<session>=..&<player>=..&<catchupParamKey>=<cifra(nome original)>`.
     * 3. Guarda [CatchupCacheItem] (urlPrefix = playUrl até a última "/").
     */
    private suspend fun getCatchupPlaylist(session: Long, player: String, streamId: String, catchupStreamId: String,
                                           route: String, startMs: Long, stopMs: Long): String {
        val request = CatchupPlayRequest().apply {
            this.streamId = streamId
            catchupRoute = route
            startTimestamp = startMs / 1000
            endTimestamp = stopMs / 1000
            this.catchupStreamId = catchupStreamId
        }
        try {
            val response = getCatchupPlayUrl(session, player, request, "get catchup url") ?: return ""
            val playUrl = response.playUrl!!
            val token = response.token
            val urlPrefix = playUrl.substring(0, playUrl.lastIndexOf("/"))
            val url = if (token.isNullOrEmpty()) playUrl else if (playUrl.endsWith("?")) playUrl + token else "$playUrl?$token"
            val t0 = System.currentTimeMillis()
            val (blocks, body) = downloadCatchupPlaylist(session, player, urlPrefix, token, url)
            val item = cacheCatchup(session, urlPrefix, request, response)
            val cost = System.currentTimeMillis() - t0
            item.listSize = blocks.size
            if (blocks.isEmpty()) logger.error("session[$session] get catchup playlist complete size[0][$cost ms][$playUrl][$body]")
            else logger.info("session[$session] get catchup playlist complete size[${blocks.size}][$cost ms][$playUrl]")
            return body.toString()
        } catch (t: Throwable) {
            logger.error("session[$session] get catchup url failure [$streamId][$catchupStreamId][$route][$startMs][$stopMs]", t)
            return ""
        }
    }

    /**
     * Original: d.o(...) ("getCatchupPlayUrl") — `ApiStreamMetaClient.e(...)` = GET /api/catchup/getPlayUrl/v1
     * (pageId=1, pageSize=2000). Código "200-3" ⇒ catch-up "not free": publica evento de streaming 1000.
     */
    private suspend fun getCatchupPlayUrl(session: Long, player: String, request: CatchupPlayRequest, from: String): CatchupPlayResponse? {
        val start = System.currentTimeMillis()
        val h = HeaderInterceptor
        val net = ApiStreamMetaClient.getPlayUrl(h.tenantId().toString(), h.appId().toString(), h.appVersion(), "",
            h.deviceId(), h.language(), 1, 2000, System.currentTimeMillis(), h.streamToken(), h.accountId(), request)
        // Original: com.skydoves.sandwich.b.b(...) — extrai o corpo (n6.b) mesmo em erro
        val rsp: com.foxivid.baselib.model.common.ApiResult<CatchupPlayResponse> = net.getOrThrow()   // com.skydoves.sandwich.b.b(...) = getOrThrow (lança se falha de rede/HTTP)
        val cost = System.currentTimeMillis() - start
        val data = rsp.data
        if (data != null) {
            logger.info("$from complete [$session][${request.streamId}][${request.catchupStreamId}][${request.startTimestamp}][${request.endTimestamp}][$cost ms]")
            return data
        }
        if (rsp.code == "200-3") {
            val p = try { player.toInt() } catch (t: Throwable) { logger.error("invalid player id[$player]", t); 0 }
            // Original: EventBus.post(nf.v(catchupStreamId, session, p, 1000, msg ?: "not free"))  [xe.c.c().o(...) = postSticky]
            org.greenrobot.eventbus.EventBus.getDefault().postSticky(StreamingEvent(request.catchupStreamId, session, p, 1000, rsp.msg ?: "not free"))
        }
        logger.error("$from failure [$session][${request.streamId}][${request.catchupStreamId}][${request.startTimestamp}][${request.endTimestamp}][$cost ms]: [${rsp.code}][${rsp.msg}]")
        return null
    }

    /** Original: d.E(...) — validTime em segundos. */
    private fun cacheCatchup(session: Long, urlPrefix: String, request: CatchupPlayRequest, response: CatchupPlayResponse): CatchupCacheItem {
        val item = CatchupCacheItem(urlPrefix, request, response, response.validTime * 1000 + System.currentTimeMillis())
        catchupPlayResponseCache.put(session, item)
        return item
    }

    /** Original: d.n(...) + d$e/d$f — download síncrono (CountDownLatch) da playlist e reescrita. */
    private fun downloadCatchupPlaylist(session: Long, player: String, urlPrefix: String, token: String?, url: String): Pair<List<String>, StringBuilder> {
        val latch = CountDownLatch(1)
        var sb = StringBuilder()
        val blocks = ArrayList<String>()
        val durations = ArrayList<Double>()
        HttpDownloader.get(url, onSuccess = { input: InputStream? ->
            try {
                if (input != null) {
                    var n = 0
                    BufferedReader(InputStreamReader(input)).forEachLine { line ->
                        when {
                            line.endsWith(".m3u8") -> {
                                val sub = if (token.isNullOrEmpty()) "$urlPrefix/$line" else "$urlPrefix/$line?$token"
                                val (b, s) = downloadCatchupPlaylist(session, player, urlPrefix, token, sub)
                                sb = s; blocks.addAll(b)
                            }
                            line.endsWith(".ts") -> {
                                val enc = StreamHelper.encodeParams(line)
                                val name = "${StreamingKeys.catchupTs}_${n++}.ts"
                                sb.append(name).append("?").append(StreamingKeys.sessionKey).append("=").append(session)
                                    .append("&").append(StreamingKeys.playerKey).append("=").append(player)
                                    .append("&").append(StreamingKeys.catchupParamKey).append("=").append(enc)
                                blocks.add(name)
                                if (durations.size >= blocks.size && blockDurations.size < 3) blockDurations[name] = durations[blocks.size - 1]
                            }
                            else -> {
                                if (line.startsWith("#EXTINF:") && blockDurations.size < 3) {
                                    try { durations.add(line.substring(8).trimEnd(',').toDouble()) } catch (t: Throwable) { logger.error("session[$session] parse ext-info failure", t) }
                                }
                                sb.append(line)
                            }
                        }
                        sb.append("\n")
                    }
                }
            } catch (t: Throwable) {
                logger.error("session[$session] download catchup playlist failure[$url]", t)
            } finally { latch.countDown() }
        }, onFailure = { t -> logger.error("session[$session] download catchup playlist failure[$url]", t); latch.countDown() })
        latch.await()
        return blocks to sb
    }

    /**
     * Original: d.w(String, T, a) — segmento de catch-up. Se o token expirou, renova chamando a API
     * de novo ("renew catchup token", d$i) antes de baixar.
     */
    private fun <T> onCatchupTsRequest(uri: String, params: T, cb: Callback<T>) {
        try {
            val session = cb.param(params, StreamingKeys.sessionKey).toLong()
            val player = cb.param(params, StreamingKeys.playerKey)
            if (session != lastPlaySession) {
                cb.respond(404, "session mismatch".toByteArray(), TEXT)
                logger.error("session mismatch[$session vs $lastPlaySession] on catchup ts request"); return
            }
            val item = catchupPlayResponseCache.get(session)
            if (item == null) {
                cb.respond(404, "context lost".toByteArray(), TEXT)
                logger.error("context lost[$session] on catchup ts request"); return
            }
            if (item.tokenExpiredTime < System.currentTimeMillis()) {
                CoroutineScope(Dispatchers.IO).launch {
                    withContext(Dispatchers.IO) {
                        try {
                            val cached = catchupPlayResponseCache.get(session)
                            if (cached != null && cached.tokenExpiredTime > System.currentTimeMillis()) {
                                proxyCatchupBlock(uri, session, player.toInt(), cached.urlPrefix, cached.response.token, params, cb)
                                return@withContext
                            }
                            val renewed = getCatchupPlayUrl(session, player, item.request, "renew catchup token")
                            if (renewed != null) {
                                cacheCatchup(session, item.urlPrefix, item.request, renewed).listSize = item.listSize
                                proxyCatchupBlock(uri, session, player.toInt(), item.urlPrefix, renewed.token, params, cb)
                            } else cb.respond(404, "renew catchup token failed".toByteArray(), TEXT)
                        } catch (t: Throwable) {
                            cb.respond(404, "renew catchup token failed".toByteArray(), TEXT)
                            logger.error("renew catchup token failure[$session][${item.request.streamId}][${item.request.catchupStreamId}][${item.request.startTimestamp}][${item.request.endTimestamp}]", t)
                        }
                    }
                }
                return
            }
            proxyCatchupBlock(uri, session, player.toInt(), item.urlPrefix, item.response.token, params, cb)
        } catch (t: Throwable) {
            cb.respond(404, "invalid session".toByteArray(), TEXT)
            logger.error("invalid session on catchup ts request", t)
        }
    }

    /**
     * Original: d.m(...) + d$c/d$d — baixa `urlPrefix/<nome original decifrado>?token` do CDN
     * e devolve 200 `video/m2ts` (404 em erro). Loga kbps.
     */
    private fun <T> proxyCatchupBlock(uri: String, session: Long, player: Int, urlPrefix: String, token: String?, params: T, cb: Callback<T>) {
        val original = StreamHelper.decodeParams(cb.param(params, StreamingKeys.catchupParamKey))
        val url = if (token.isNullOrEmpty()) "$urlPrefix/$original" else "$urlPrefix/$original?$token"
        val start = System.currentTimeMillis()
        val desc = "$original -> ${uri.replace("/", "")} | ${catchupPlayResponseCache.get(session)?.listSize}"
        logger.info("session[$session] downloading catchup block[$desc]")
        HttpDownloader.get(url, onSuccess = { input ->
            val cost = System.currentTimeMillis() - start
            if (input == null) {
                cb.respond(404, ByteArray(0), TEXT)
                logger.error("session[$session] download catchup[$cost ms][$url] got null")
            } else try {
                val bytes = input.readBytes()
                cb.respond(200, bytes, "video/m2ts")
                val kbps = bytes.size * 8L / (System.currentTimeMillis() - start)
                logger.info("session[$session] download catchup block[$desc] complete [$cost ms] [${bytes.size}] -> [$kbps kbps]")
            } catch (t: Throwable) {
                logger.error("session[$session] download catchup block[$desc] failure[$cost ms] [$url]", t)
                cb.respond(404, ByteArray(0), TEXT)
            }
        }, onFailure = { t ->
            logger.error("session[$session] download catchup block[$desc] failure[${System.currentTimeMillis() - start} ms] [$url]", t)
            cb.respond(404, ByteArray(0), TEXT)
        })
    }

    // ---------------------------------------------------------------- utilidades

    /** Original: d.v(byte[]) */
    private fun splitLines(index: ByteArray?): List<String> =
        if (index == null) ArrayList() else String(index).split("\n").dropLastWhile { it.isEmpty() }.toMutableList()

    /** Original: d.H() */
    fun onPlayerRestart() { clientEngineService?.onPlayerRestart() }

    /** Original: d.q() */
    fun engine(): StreamEngine? = clientEngineService?.engine()

    /** Original: d.r() */
    fun playSession(): Long = playSession.get()

    private companion object {
        /** Original: ContentTypes.DOC_MIME_TYPE ("text/plain"). */
        const val TEXT = "text/plain"
    }
}

/**
 * Original: x1.f1.lb.util.b0.f(url, onSuccess, onFailure) — download HTTP assíncrono da lib (outro módulo).
 * Declarado aqui apenas como ponto de referência.
 */
internal object HttpDownloader {
    /** Delegação a [DownloadUtils.get] (util/b0.f): GET HTTP; 200 → [onSuccess] com o corpo; falha → [onFailure] (ou [onSuccess](null) + log). */
    fun get(url: String, onSuccess: (InputStream?) -> Unit, onFailure: (Throwable) -> Unit) =
        DownloadUtils.download(url, com.foxivid.baselib.util.Callback { onSuccess(it) }, com.foxivid.baselib.util.Callback { onFailure(it) })
}
