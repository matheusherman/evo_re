package com.foxivid.baselib.streaming.server

import android.text.TextUtils
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.streaming.engine.StreamEngine
import com.koushikdutta.async.AsyncServer
import com.koushikdutta.async.AsyncServerSocket
import com.koushikdutta.async.AsyncSocket
import com.koushikdutta.async.callback.ListenCallback
import com.koushikdutta.async.http.Multimap
import com.koushikdutta.async.http.body.AsyncHttpRequestBody
import com.koushikdutta.async.http.server.AsyncHttpServer
import com.koushikdutta.async.http.server.AsyncHttpServerRequest
import com.koushikdutta.async.http.server.AsyncHttpServerResponse
import com.koushikdutta.async.http.server.HttpServerRequestCallback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import java.net.InetSocketAddress
import java.util.Locale
import java.util.concurrent.ExecutorService

/**
 * Original: x1/f1/lb/streaming/server/i.java ("NIOHttpServer.kt") (+ i$a, i$b, i$c, i$d, lambda server/h)
 *
 * Servidor HTTP **AndroidAsync** (koushikdutta) ligado em `127.0.0.1:<porta aleatória>`.
 * É o "painel de controle" do motor e o servidor de **HLS local** (playlist + blocos) para:
 * - ao vivo quando `player_proxy_type = HLS`;
 * - VoD e catch-up (sempre).
 *
 * Todas as rotas (OPTIONS/HEAD/GET/POST, regex `[\d\D]*`) caem em [onRequest], que despacha num
 * executor para [HttpServiceWrapper.handle].
 *
 * Sobre "keystore": o parâmetro `KeyStoreProvider` (i$a) é uma interface **vazia** e nunca é usado;
 * o servidor é HTTP puro. O TLS com o keystore BKS `R.raw.server` (senha "123456") fica no cliente
 * [com.foxivid.baselib.streaming.client.SslHttpClient], que configura o AsyncHttpClient global.
 */
object NioHttpServer : HttpServerRequestCallback, LocalHttpServer {

    private val logger = LoggerFactory.getLogger(NioHttpServer::class.java)

    /** Original: i.c = x1.f1.lb.util.n.f21413l (executor compartilhado da lib). */
    private val service: ExecutorService = com.foxivid.baselib.util.LegacyTvUtils.EXECUTOR

    private var server: AsyncHttpServer? = null
    private val httpServiceWrapper = HttpServiceWrapper()

    /** Original: i.f */
    private var listenPort: Int = StreamingKeys.randomPort()

    /** Original: i$a — interface vazia (provedor de keystore nunca implementado). */
    interface KeyStoreProvider

    /** Original: i$b — status HTTP de resposta (descrições em chinês no original). */
    enum class RequestStatus(val requestStatus: Int, val description: String) {
        REQUEST_OK(200, "请求成功"),
        REQUEST_NO_CONTENT(204, "No Content"),
        REQUEST_ERROR(500, "Internal Server Error"),
        // valores vieram de constantes androidx TypedValues.PositionType inlinadas pelo R8
        REQUEST_ERROR_API(501, "无效的请求接口"),
        REQUEST_ERROR_CMD(502, "无效命令"),
        REQUEST_ERROR_DEVICE_ID(503, "不匹配的设备ID"),
        REQUEST_ERROR_ENV(504, "不匹配的服务环境");
    }

    /** Original: i.n(KeyStoreProvider) / i$d — (re)cria o servidor e escuta em 127.0.0.1. */
    fun startServer(keyStoreProvider: KeyStoreProvider?) {
        CoroutineScope(Dispatchers.IO).launch {
            if (BaseLibConfig.isDebug) logger.debug("try to start local http server on port[$listenPort]")
            httpServiceWrapper.attach(this@NioHttpServer)
            server?.stop()
            val s = AsyncHttpServer()
            server = s
            s.addAction("OPTIONS", "[\\d\\D]*", this@NioHttpServer)
            s.addAction("HEAD", "[\\d\\D]*", this@NioHttpServer)
            s.get("[\\d\\D]*", this@NioHttpServer)
            s.post("[\\d\\D]*", this@NioHttpServer)
            val address = InetSocketAddress("127.0.0.1", listenPort)
            val delegate = s.listenCallback
            AsyncServer.getDefault().listen(address.address, address.port, object : ListenCallback {
                /** Ao terminar/falhar (ex.: porta ocupada) tenta a próxima porta. */
                override fun onCompleted(ex: Exception?) {
                    if (BaseLibConfig.isDebug) logger.debug("local https server on complete, port[$listenPort]", ex)
                    listenPort++
                    startServer(keyStoreProvider)
                }
                override fun onAccepted(socket: AsyncSocket?) {
                    if (BaseLibConfig.isDebug) logger.debug("local https server on accept")
                    delegate?.onAccepted(socket)
                }
                override fun onListening(socket: AsyncServerSocket?) {
                    if (BaseLibConfig.isDebug) logger.debug("local https server on listening")
                    delegate?.onListening(socket)
                }
            })
        }
    }

    /** Original: i.a(c, e) — despacha para o executor. */
    override fun onRequest(request: AsyncHttpServerRequest, response: AsyncHttpServerResponse) {
        service.execute { handle(request, response) }
    }

    /** Original: i.m(c, e) */
    private fun handle(request: AsyncHttpServerRequest, response: AsyncHttpServerResponse) {
        val path = request.path
        val query = request.query
        val start = System.currentTimeMillis() // d1.d()
        var status: Int? = null
        try {
            if (TextUtils.isEmpty(path)) throw RuntimeException("request uri is empty")
            if ("OPTIONS".lowercase(Locale.getDefault()) == request.method.lowercase(Locale.getDefault())) return
            @Suppress("UNCHECKED_CAST")
            val body = (request.body as AsyncHttpRequestBody<Multimap?>).get() ?: request.query
            if (BaseLibConfig.isDebug) logger.info("nio_proxy rqt[{}][{}][{}][{}]", request.method, path, query, body)
            httpServiceWrapper.handle(path, body, object : HttpServiceWrapper.Callback<Multimap?> {
                override fun respond(statusCode: Int, content: ByteArray, contentType: String) {
                    status = statusCode
                    if (BaseLibConfig.isDebug) logger.info("nio_proxy rsp[{}][{}][{}][{} ms]", request.method, path, statusCode, System.currentTimeMillis() - start)
                    if ("HEAD".equals(request.method, ignoreCase = true)) {
                        response.code(statusCode).send("")
                        return
                    }
                    response.code(statusCode).send(contentType, content.copyOf())
                }
                override fun param(params: Multimap?, key: String): String =
                    (params?.get(key)?.get(0) ?: "").toString()
            })
        } catch (t: Throwable) {
            logger.error("http server on response failure[$path]", t)
            val s = RequestStatus.REQUEST_ERROR
            response.code(s.requestStatus).send(s.description)
        } finally {
            val cost = System.currentTimeMillis() - start
            if (cost > 2000) logger.info("proxy[$start][$path] response[$status] more than[$cost ms]")
        }
    }

    /** Original: i.b() */
    override fun port(): Int = listenPort

    /** Original: i.c() — repassa "restart do player" ao motor (x6.c.t()). */
    override fun onPlayerRestart() = httpServiceWrapper.onPlayerRestart()

    /** Original: i.k() */
    fun engine(): StreamEngine? = httpServiceWrapper.engine()

    /** Original: i.l() */
    fun playSession(): Long = httpServiceWrapper.playSession()
}

/** Original: x1/f1/lb/streaming/server/f.java — abstração do servidor local usada pelo cliente. */
interface LocalHttpServer {
    fun port(): Int          // b()
    fun onPlayerRestart()    // c()
}
