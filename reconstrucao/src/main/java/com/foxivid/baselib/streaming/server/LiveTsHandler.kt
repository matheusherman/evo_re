package com.foxivid.baselib.streaming.server

import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.user.UserManager
import io.netty.channel.ChannelFutureListener
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.handler.codec.http.DefaultHttpResponse
import io.netty.handler.codec.http.HttpChunkedInput
import io.netty.handler.codec.http.HttpHeaderNames
import io.netty.handler.codec.http.HttpHeaderValues
import io.netty.handler.codec.http.HttpRequest
import io.netty.handler.codec.http.HttpResponseStatus
import io.netty.handler.codec.http.HttpVersion
import io.netty.handler.stream.ChunkedStream
import org.slf4j.LoggerFactory
import java.io.InputStream
import java.net.URI
import java.net.URLDecoder

/**
 * Original: x1/f1/lb/streaming/server/k.java (+ lambda server/j)
 *
 * Handler Netty do stream TS ao vivo. Atende `GET /<liveTs>/<mediaId>.ts?<session>=<id>&<params>=<cifrado>`:
 *
 * 1. Só aceita caminhos terminados em `.ts`; recusa (404) se o usuário fez logout / foi expulso.
 * 2. Decodifica `params` (Base64 + AES, ver [StreamingKeys.parseParams]) → `mediaId=..&routeId=..&mediaMode=..`.
 * 3. Compara o parâmetro de sessão com a sessão de play ativa em [HttpServiceWrapper] (via [NioHttpServer]);
 *    divergência ⇒ 404.
 * 4. Pede ao motor de streaming (`x6.c.p(mediaId)`) o `InputStream` contínuo do canal (um PipedInputStream
 *    alimentado pelos blocos que chegam via UDP do servidor PR) e devolve com
 *    `Transfer-Encoding: chunked`, `Content-Type: video/mp2ts`, `Connection: keep-alive`.
 *
 * Só existe **um** stream ativo por processo: um novo pedido fecha o InputStream anterior.
 */
class LiveTsHandler : SimpleChannelInboundHandler<HttpRequest>() {

    private val logger = LoggerFactory.getLogger(LiveTsHandler::class.java)

    companion object {
        /** Original: k.c — stream atualmente entregue. */
        private var currentStream: InputStream? = null
        /** Original: k.d — último mediaId servido. */
        private var lastMediaId: String = ""
    }

    /** Original: k.d(ChannelHandlerContext) — responde 404 com Content-Length 0 e fecha. */
    private fun notFound(ctx: ChannelHandlerContext) {
        val rsp = DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NOT_FOUND)
        rsp.headers().set(HttpHeaderNames.CONTENT_LENGTH, 0)
        ctx.writeAndFlush(rsp).addListener(ChannelFutureListener.CLOSE)
    }

    /** Original: k.e(URI) — parse da query string com URL-decode. */
    private fun parseQuery(url: URI): Map<String, String> {
        val map = LinkedHashMap<String, String>()
        try {
            for (s in url.query!!.split("&").dropLastWhile { it.isEmpty() }) {
                val idx = s.indexOf("=")
                map[URLDecoder.decode(s.substring(0, idx), "UTF-8")] = URLDecoder.decode(s.substring(idx + 1), "UTF-8")
            }
        } catch (t: Throwable) {
            logger.error("[${hashCode()}] live_server parse query param failure [$url]", t)
        }
        return map
    }

    /** Original: k.b(ChannelHandlerContext, HttpRequest) (channelRead0) */
    override fun channelRead0(ctx: ChannelHandlerContext, request: HttpRequest) {
        val engine = NioHttpServer.engine()
        if (engine == null) {
            logger.warn("[${hashCode()}] live_server enginMgr is null [${request.uri()}]")
            notFound(ctx); return
        }
        try {
            val uri = URI(request.uri())
            logger.info("[${hashCode()}] live_server on request[${request.headers()?.get("User-Agent")}][$uri]")
            if (!uri.path!!.endsWith(".ts")) { notFound(ctx); return }
            if (UserManager.isLogoutOrKickedOut()) { notFound(ctx); return } // Original: user.f.T0()
            val query = parseQuery(uri)
            val params = StreamingKeys.parseParams(query[StreamingKeys.paramsKey] ?: "")
            if (params.isEmpty()) {
                logger.error("[${hashCode()}] live_server without params [${request.uri()}]")
                notFound(ctx); return
            }
            val mediaId = params["mediaId"]
            val session = query[StreamingKeys.sessionKey] ?: "0"
            val activeSession = NioHttpServer.playSession()
            if (session.toLong() != activeSession) {
                logger.error("[${hashCode()}] live_server mismatch [$mediaId] [$session vs. $activeSession] [${request.uri()}]")
                notFound(ctx); return
            }
            synchronized(LiveTsHandler::class.java) {
                currentStream?.let {
                    logger.warn("[${hashCode()}] live_server close last stream [${it.hashCode()}]")
                    it.closeQuietly()
                }
                val stream = engine.p(mediaId) // x6.c.p(): PipedInputStream do bloco atual (y6.a.k())
                currentStream = stream
                if (stream == null) {
                    logger.error("[${hashCode()}] live_server get stream [null] [$mediaId] [$session vs. $activeSession] [${request.uri()}]")
                    notFound(ctx); return
                }
                if (mediaId != null) lastMediaId = mediaId
                val rsp = DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK)
                rsp.headers().set(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED)
                rsp.headers().set(HttpHeaderNames.CONTENT_TYPE, "video/mp2ts")
                rsp.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE)
                ctx.writeAndFlush(rsp)
                ctx.writeAndFlush(HttpChunkedInput(ChunkedStream(InputStreamWrapper(stream))))
                    .addListener { future ->
                        synchronized(LiveTsHandler::class.java) {
                            logger.info("[${hashCode()}] live_server on stream_complete [${future.isSuccess}] [${future.isDone}], inputStream[${stream.hashCode()}]")
                            stream.closeQuietly()
                            currentStream = null
                        }
                    }
            }
        } catch (t: Throwable) {
            logger.error("[${hashCode()}] live_server failure [${request.uri()}}]", t)
            notFound(ctx)
        }
    }
}

/**
 * Original: x1/f1/lb/streaming/server/g.java
 * Wrapper transparente de InputStream; só registra (em debug) quem fechou o stream.
 */
class InputStreamWrapper(private val inputStream: InputStream) : InputStream() {
    private val logger = LoggerFactory.getLogger(InputStreamWrapper::class.java)
    override fun read(): Int = inputStream.read()
    override fun read(b: ByteArray): Int = inputStream.read(b)
    override fun read(b: ByteArray, off: Int, len: Int): Int = inputStream.read(b, off, len)
    override fun available(): Int = inputStream.available()
    override fun skip(n: Long): Long = inputStream.skip(n)
    override fun mark(readlimit: Int) = inputStream.mark(readlimit)
    override fun markSupported(): Boolean = inputStream.markSupported()
    override fun reset() = inputStream.reset()
    override fun close() {
        if (BaseLibConfig.isDebug) logger.debug("InputStreamWrapper[{}] close", inputStream.hashCode(), Exception())
        inputStream.close()
    }
    override fun equals(other: Any?): Boolean = inputStream == other
    override fun hashCode(): Int = inputStream.hashCode()
    override fun toString(): String = inputStream.toString()
}

/** Original: hb.d.m(Closeable) — fecha ignorando exceções. */
internal fun InputStream.closeQuietly() = try { close() } catch (_: Throwable) {}
