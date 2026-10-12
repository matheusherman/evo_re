package com.foxivid.baselib.streaming.client

import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.streaming.StreamHelper
import com.foxivid.baselib.streaming.engine.PlayType
import com.foxivid.baselib.streaming.server.LocalHttpServer
import com.foxivid.baselib.streaming.server.NettyHttpServer
import com.foxivid.baselib.streaming.server.StreamingKeys
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Original: x1/f1/lb/streaming/client/a.java ("EngineHelper.kt") (+ a$a..a$l)
 *
 * Lado "cliente" do proxy local: fala com o [com.foxivid.baselib.streaming.server.NioHttpServer] por HTTP GET
 * em `http://127.0.0.1:<porta>/<rota aleatória>?...` (ver [StreamingKeys]) e devolve as URLs que o
 * player deve abrir. A resposta de cada rota de controle é "true"/"false".
 */
object EngineHelper {

    private val logger = LoggerFactory.getLogger(EngineHelper::class.java)
    private var isEngineStart = false
    private val stopEngineLock = AtomicBoolean(false)

    /** Original: a.httpServer — começa com um dummy (porta 0) até [setHttpServer]. */
    private var httpServer: LocalHttpServer = object : LocalHttpServer {
        override fun port() = 0
        override fun onPlayerRestart() {}
    }

    /** Original: a.j() — base do servidor Netty (TS contínuo). */
    private fun nettyBase() = "http://127.0.0.1:" + NettyHttpServer.port

    /** Original: a.l() — base do servidor AndroidAsync (controle + HLS). */
    private fun nioBase() = "http://127.0.0.1:" + httpServer.port()

    /**
     * Original: a.k(mediaId, playType) — **URL final entregue ao player**:
     * - VOD/CATCHUP ou `proxyType == "HLS"`: `http://127.0.0.1:<nioPort>/<liveM3u8>.m3u8`
     * - LIVE com `proxyType == "TS"` (padrão): `http://127.0.0.1:<nettyPort>/<liveTs>/<mediaId>.ts`
     * (a query `?<session>=..&<params>=..` é acrescentada em [startPlay]).
     */
    private fun playUrlBase(mediaId: String, playType: PlayType): String {
        if (playType != PlayType.LIVE) return nioBase() + "/" + StreamingKeys.liveM3u8 + ".m3u8"
        if (BaseLibConfig.proxyType == "HLS") return nioBase() + "/" + StreamingKeys.liveM3u8 + ".m3u8"
        return nettyBase() + "/" + StreamingKeys.liveTs + "/" + mediaId + ".ts"
    }

    /**
     * Original: a.h(addressList, token, uid, did, tenantId, deviceType, playType) / a$b ("create")
     * GET `/<startEngine>?<params>=cifra("addressList=<json streamServers>&token=..&uid=..&did=..&tenantId=..&type=<byte>&deviceType=..")`.
     */
    fun create(addressList: String, token: String, uid: String, did: String, tenantId: String, deviceType: Int, playType: PlayType): Flow<Boolean> = flow {
        val enc = StreamHelper.encodeParams("addressList=$addressList&token=$token&uid=$uid&did=$did&tenantId=$tenantId&type=${playType.value.toInt()}&deviceType=$deviceType")
        val url = nioBase() + "/" + StreamingKeys.startEngine + "?" + StreamingKeys.paramsKey + "=" + enc
        if (BaseLibConfig.isDebug) logger.debug("streamingUrl[{}]", url)
        val result = String(SimpleHttpGet.get(url))
        if (BaseLibConfig.isDebug) logger.debug("streamingEngine[{}] complete: result[{}]", url, result)
        val started = result.toBoolean()
        if (started) logger.info("engine is started on create") else logger.warn("engine is not started on create")
        isEngineStart = started
        emit(started)
    }

    /**
     * Original: a.i() ("destroy") — método não decompilado pelo jadx (JadxOverflowException); reconstruído a partir
     * do dump de instruções que o jadx deixou no comentário: se o motor não está iniciado ⇒ true;
     * se outro destroy está em curso ⇒ espera em passos de 100 ms até `isEngineStart == false` e devolve true;
     * senão GET `/<stopEngine>`.
     */
    suspend fun destroy(): Flow<Boolean> {
        if (!isEngineStart) {
            logger.info("engine is not started in destroy")
            return flowOf(true)
        }
        while (!stopEngineLock.compareAndSet(false, true)) {
            delay(100)
            if (!isEngineStart) { stopEngineLock.set(false); return flowOf(true) }
        }
        return flow {
            try {
                val url = nioBase() + "/" + StreamingKeys.stopEngine
                if (BaseLibConfig.isDebug) logger.debug("streamingUrl[{}]", url)
                val result = String(SimpleHttpGet.get(url))
                if (BaseLibConfig.isDebug) logger.debug("streamingEngine[{}] complete: result[{}]", url, result)
                val ok = result.toBoolean()
                if (ok) { logger.info("engine is stopped on destroy"); isEngineStart = false }
                stopEngineLock.set(false)
                emit(ok)
            } catch (t: Throwable) { stopEngineLock.set(false); throw t }
        }
    }

    /**
     * Original: a.u(mediaId, session, playType, params) / a$j ("startPlay")
     * GET `/<startPlay>?<params>`; se "true", emite (`<playUrlBase>?<params>`, session).
     * Recusa em "eco mode" (x1.f1.lb.util.d0.j()).
     */
    fun startPlay(mediaId: String, session: Long, playType: PlayType, params: String): Flow<Pair<String, Long>> {
        if (isInEcoMode()) throw Exception("startPlayer(): in eco mode")
        if (!isEngineStart) throw Exception("startPlay(): engine not start")
        val url = nioBase() + "/" + StreamingKeys.startPlay + "?" + params
        if (BaseLibConfig.isDebug) logger.debug("streamingUrl[{}]", url)
        return flow {
            logger.info("start play begin, session[$session] [$mediaId]")
            val result = String(SimpleHttpGet.get(url))
            if (BaseLibConfig.isDebug) logger.debug("streamingEngine[{}] complete: result[{}]", url, result)
            if (!result.toBoolean()) throw Exception("start play failure, session[$session][$playType][$params]")
            if (!isEngineStart) { logger.info("engine is started on start play [ $session ]"); isEngineStart = true }
            val playUrl = String.format("%s?%s", playUrlBase(mediaId, playType), params)
            logger.info("start play complete, session[$session][$playUrl]")
            emit(playUrl to session)
        }
    }

    /**
     * Original: a.t(session, params) / a$i ("startCatchup")
     * Não chama nada: apenas emite `http://127.0.0.1:<nioPort>/<startCatchup>.m3u8?<params>`; o trabalho
     * (chamar a API de catch-up e reescrever a playlist) acontece quando o player pede essa URL.
     */
    fun startCatchup(session: Long, params: String): Flow<Pair<String, Long>> {
        if (isInEcoMode()) throw Exception("startCatchup(): in eco mode")
        val url = nioBase() + "/" + StreamingKeys.startCatchup + ".m3u8?" + params
        if (BaseLibConfig.isDebug) logger.debug("streamingUrl[{}]", url)
        return flowOf(url to session)
    }

    /** Original: a.v(session, from) / a$l + a$k ("stopPlay") */
    fun stopPlay(session: Long, from: String): Flow<Boolean> {
        // Original: x1.f1.lb.util.a1.j(session) — fecha o rastreio de zapping (util)
        return flow {
            logger.info("stop play begin, session[$session] from[$from]")
            if (!isEngineStart) { emit(false); return@flow }
            val start = System.currentTimeMillis()
            try {
                val url = nioBase() + "/" + StreamingKeys.stopPlay + "?" + StreamingKeys.sessionKey + "=" + session
                if (BaseLibConfig.isDebug) logger.debug("streamingUrl[{}]", url)
                val result = String(SimpleHttpGet.get(url))
                if (BaseLibConfig.isDebug) logger.debug("streamingEngine[{}] complete: result[{}]", url, result)
                if (!isEngineStart) { logger.info("engine is started on stop play [ $session ][$from]"); isEngineStart = true }
                emit(true)
            } catch (t: Throwable) {
                logger.error("stop engine play error[$session][$from][${System.currentTimeMillis() - start} ms]", t)
                emit(false)
            }
        }.map { ok -> logger.info("stop play complete[$ok], session[$session] from[$from]"); ok }
    }

    /** Original: a.n(type) / a$f ("isConnected") */
    suspend fun isConnected(type: PlayType): Boolean = withContext(Dispatchers.IO) {
        try {
            if (!isEngineStart) { logger.info("engine is not started in isConnected"); return@withContext false }
            val url = nioBase() + "/" + StreamingKeys.isConnected + "?" + StreamingKeys.typeKey + "=" + StreamHelper.encodeParams(type.name)
            if (BaseLibConfig.isDebug) logger.debug("streamingUrl[{}]", url)
            val result = String(SimpleHttpGet.get(url))
            if (BaseLibConfig.isDebug) logger.debug("streamingEngine[{}] complete: result[{}]", url, result)
            result.toBoolean()
        } catch (_: Throwable) { false }
    }

    /** Original: a.g(session, player) / a$a ("addPlayer") — registra o hashCode do IMediaPlayer. */
    fun addPlayer(session: Long, player: Int) = fireAndForget("addPlayer", StreamingKeys.addPlayer, session, player)

    /** Original: a.q(session, player) / a$h ("removePlayer") */
    fun removePlayer(session: Long, player: Int) = fireAndForget("removePlayer", StreamingKeys.removePlayer, session, player)

    private fun fireAndForget(name: String, route: String, session: Long, player: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                if (!isEngineStart) throw Exception("$name(): engine not start")
                val url = nioBase() + "/" + route + "?" + StreamingKeys.sessionKey + "=" + session + "&" + StreamingKeys.playerKey + "=" + player
                if (BaseLibConfig.isDebug) logger.debug("streamingUrl[{}]", url)
                val result = String(SimpleHttpGet.get(url))
                if (BaseLibConfig.isDebug) logger.debug("streamingEngine[{}] complete: result[{}]", url, result)
            } catch (_: Throwable) {}
        }
    }

    /** Original: a.p(token) / a$g ("refreshToken") */
    fun refreshToken(token: String) {
        if (!isEngineStart) throw Exception("refreshToken(): engine not start")
        val url = nioBase() + "/" + StreamingKeys.refreshToken + "?" + StreamingKeys.tokenKey + "=" + StreamHelper.encodeParams(token)
        if (BaseLibConfig.isDebug) logger.debug("streamingUrl[{}]", url)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val result = String(SimpleHttpGet.get(url))
                if (BaseLibConfig.isDebug) logger.debug("streamingEngine[{}] complete: result[{}]", url, result)
            } catch (_: Throwable) { logger.error("refresh token failure[$url]") }
        }
    }

    /** Original: a.m(mediaId, lang) — URL da legenda servida pelo motor. */
    fun subtitleUrl(mediaId: String, lang: String): String =
        nioBase() + "/" + StreamingKeys.getSubtitle + "?" + StreamingKeys.mediaIdKey + "=" + mediaId + "&" + StreamingKeys.langKey + "=" + lang

    /** Original: a.o() */
    fun isEngineStarted(): Boolean = isEngineStart
    /** Original: a.r() */
    fun onPlayerRestart() = httpServer.onPlayerRestart()
    /** Original: a.s(f) */
    fun setHttpServer(server: LocalHttpServer) { httpServer = server }

    /** Original: x1.f1.lb.util.d0.f21360a.j() — "eco mode" (economia de energia, módulo util). */
    private fun isInEcoMode(): Boolean = TODO("x1.f1.lb.util.d0.j() — módulo util")
}

/**
 * Original: x1/f1/lb/streaming/client/b.java
 * GET síncrono com HttpURLConnection (timeouts de 60 s); status ≠ 200 ⇒ RuntimeException("Request failure").
 */
object SimpleHttpGet {
    fun get(url: String): ByteArray {
        val conn = URL(url).openConnection() as HttpURLConnection
        conn.connectTimeout = 60000
        conn.readTimeout = 60000
        conn.requestMethod = "GET"
        if (conn.responseCode != 200) throw RuntimeException("Request failure")
        val input = conn.inputStream
        val bytes = readAll(input)
        input.close()
        return bytes
    }

    private fun readAll(input: InputStream): ByteArray {
        val out = ByteArrayOutputStream()
        val buf = ByteArray(1024)
        while (true) {
            val n = input.read(buf)
            if (n == -1) { input.close(); return out.toByteArray() }
            out.write(buf, 0, n)
        }
    }
}
