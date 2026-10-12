package com.foxivid.baselib.streaming.server

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.codec.http.HttpContentCompressor
import io.netty.handler.codec.http.HttpServerCodec
import io.netty.handler.stream.ChunkedWriteHandler
import org.slf4j.LoggerFactory
import java.net.BindException
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Original: x1/f1/lb/streaming/server/m.java (+ m$a, lambda server/l)
 *
 * Servidor HTTP Netty que entrega o **stream TS ao vivo contínuo** ao player (modo `player_proxy_type = TS`,
 * o padrão). Pipeline: HttpServerCodec → HttpContentCompressor → ChunkedWriteHandler → [LiveTsHandler].
 *
 * Atenção: `ServerBootstrap.bind(port)` sem endereço ⇒ escuta em **todas as interfaces (0.0.0.0)**,
 * não só em 127.0.0.1 (diferente de [NioHttpServer]). Qualquer dispositivo da LAN que adivinhe a porta
 * e os nomes aleatórios de [StreamingKeys] poderia pedir o stream; a validação de sessão em [LiveTsHandler]
 * é a única barreira.
 *
 * Porta inicial: [StreamingKeys.randomPort] (1024..51023); em `BindException` incrementa e tenta de novo.
 */
object NettyHttpServer {

    private val logger = LoggerFactory.getLogger(NettyHttpServer::class.java)
    private var bossGroup: EventLoopGroup? = null
    private var workerGroup: EventLoopGroup? = null
    private var channelFuture: ChannelFuture? = null
    private val isInInitializing = AtomicBoolean(false)

    /** Original: m.b() */
    var port: Int = StreamingKeys.randomPort()
        private set

    /** Original: m$a — inicializador do pipeline. */
    private class Initializer : ChannelInitializer<SocketChannel>() {
        override fun initChannel(ch: SocketChannel) {
            ch.pipeline().addLast(HttpServerCodec())
            ch.pipeline().addLast(HttpContentCompressor())
            ch.pipeline().addLast(ChunkedWriteHandler())
            ch.pipeline().addLast(LiveTsHandler())
        }
    }

    /** Original: m.c() — sobe o servidor numa thread própria (bloqueia em closeFuture). */
    fun start() {
        Thread { run() }.start()
    }

    /** Original: m.e() */
    private fun run() {
        if (!isInInitializing.compareAndSet(false, true)) {
            logger.warn("HTTP Server another thread in initializing")
            return
        }
        stop()
        bossGroup = NioEventLoopGroup(1)
        workerGroup = NioEventLoopGroup()
        try {
            val bootstrap = ServerBootstrap()
            bootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel::class.java)
                .childHandler(Initializer())
                .childOption(ChannelOption.SO_KEEPALIVE, true)
            while (true) {
                try {
                    channelFuture = bootstrap.bind(port).sync()
                    logger.info("HTTP Server started and listening on port :{}", port)
                    isInInitializing.set(false)
                    channelFuture?.channel()?.closeFuture()?.sync()
                    break
                } catch (e: BindException) {
                    logger.warn("HTTP Server try to bind port[$port], but already in use", e)
                    port += 1
                }
            }
        } catch (e: Exception) {
            if (e !is InterruptedException) logger.error("NettyHttpServer run error", e)
        } finally {
            workerGroup?.shutdownGracefully()
            bossGroup?.shutdownGracefully()
            isInInitializing.set(false)
        }
    }

    /** Original: m.f() */
    @Synchronized
    fun stop() {
        val future = channelFuture ?: return
        try {
            future.channel()?.close()
            logger.info("HTTP Server stop listening on port :{}", port)
            channelFuture = null
        } catch (t: Throwable) {
            logger.error("HTTP Server stop listening on port :$port", t)
        }
    }
}
