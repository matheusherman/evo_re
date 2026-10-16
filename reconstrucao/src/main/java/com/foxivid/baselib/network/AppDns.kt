package com.foxivid.baselib.network

import com.foxivid.baselib.util.ResStrings
import com.foxivid.baselib.util.ServerTime
import com.google.common.net.InetAddresses
import io.netty.bootstrap.Bootstrap
import io.netty.buffer.ByteBufUtil
import io.netty.channel.Channel
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInitializer
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioDatagramChannel
import io.netty.handler.codec.dns.DatagramDnsQuery
import io.netty.handler.codec.dns.DatagramDnsQueryEncoder
import io.netty.handler.codec.dns.DatagramDnsResponse
import io.netty.handler.codec.dns.DatagramDnsResponseDecoder
import io.netty.handler.codec.dns.DefaultDnsQuestion
import io.netty.handler.codec.dns.DnsQuestion
import io.netty.handler.codec.dns.DnsQuery
import io.netty.handler.codec.dns.DnsRawRecord
import io.netty.handler.codec.dns.DnsRecordType
import io.netty.handler.codec.dns.DnsSection
import io.netty.util.NetUtil
import okhttp3.Dns
import org.slf4j.LoggerFactory
import java.net.InetAddress
import java.net.InetSocketAddress
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

/**
 * DNS do app: resolve primeiro com o cliente DNS próprio (UDP, [DnsClient]) e, se falhar ou estourar 30 s, cai para o DNS do
 * sistema. IP literal é devolvido direto. Guarda o texto de diagnóstico da última resolução (resolving/pass (app)/pass (sys)/fail)
 * e o tempo gasto, usados pela tela de diagnóstico.
 *
 * Original: mf/b.java (+ lambda mf/a)
 */
class AppDns : Dns {
    private val logger = LoggerFactory.getLogger(AppDns::class.java)
    private val timeoutSeconds = 30L

    /** Original: mf.b.c(response, list) */
    private fun collect(response: DnsResponse?, list: ArrayList<InetAddress>): List<InetAddress> {
        if (response == null || response.answers.isEmpty()) return ArrayList()
        response.answers.forEach { list.add(InetAddresses.forString(it)) }   // f2.a.c = InetAddresses.forString
        return list
    }

    override fun lookup(hostname: String): List<InetAddress> {
        var failed = false
        try {
            startTime = ServerTime.now()
            endTime = 0L
            if (InetAddresses.isInetAddress(hostname)) {
                val sys = Dns.SYSTEM.lookup(hostname)
                return sys.ifEmpty { arrayListOf(InetAddresses.forString(hostname)) }
            }
            val latch = CountDownLatch(1)
            val list = ArrayList<InetAddress>()
            DnsClient.resolve(hostname) { _, response -> collect(response, list); latch.countDown() }
            if (!latch.await(timeoutSeconds, TimeUnit.SECONDS) || list.isEmpty()) {
                try {
                    state = res("resolving")
                    val sys = Dns.SYSTEM.lookup(hostname)
                    state = res("pass") + " (sys)"
                    return sys
                } catch (e: Exception) {
                    failed = true
                    logger.error("DNS resolver failure, will try system dns", e)
                    state = res("fail") + " (" + e.javaClass.simpleName + ")"
                    return emptyList()
                }
            }
            state = res("pass") + " (app)"
            return list
        } catch (e: Exception) {
            logger.error("DNS resolver failure, will try system dns", e)
            state = res("fail") + " (" + e.javaClass.simpleName + ")"
            return if (failed) emptyList() else Dns.SYSTEM.lookup(hostname)
        } finally {
            endTime = ServerTime.now()
        }
    }

    companion object {
        /** Original: mf.b.f (texto do último resultado). */
        @Volatile var state: String = ""
        /** Original: mf.b.g / h (início e fim da última resolução, ms). */
        @Volatile var startTime: Long = 0L
        @Volatile var endTime: Long = 0L

        /** `u0.b(R.string.x, "")`: texto do recurso (ids gerados em x.l1.b2.R; aqui resolvidos pelo nome). */
        private fun res(name: String): String {
            val ctx = com.foxivid.baselib.config.BaseLibConfig.appContext ?: return ""
            return ResStrings.get(ctx.resources.getIdentifier(name, "string", ctx.packageName))
        }
    }
}

/** Resposta DNS resumida. Original: o6/c.java (code, nome consultado, IPs do tipo A, instante). */
class DnsResponse {
    var code: Int = 0
    var name: String? = null
    var type: DnsRecordType? = null
    val answers: MutableList<String> = ArrayList()
    val time: Long = System.currentTimeMillis()
}

/** Consulta pendente. Original: o6/a.java */
internal class DnsTask {
    var id = 0
    var name: String = ""
    var timeoutMs = 0L
    val createdAt: Long = System.currentTimeMillis()
    var lastSentAt: Long = System.currentTimeMillis()
    var callback: ((Int, DnsResponse) -> Unit)? = null
}

/**
 * Cliente DNS UDP (netty) com cache e retransmissão: servidores 1.1.1.1/1.0.0.1/8.8.8.8/8.8.4.4/9.9.9.9/9.9.9.10; reenvia a
 * cada 3 s e dá timeout em `timeoutMs`. Respostas com code 0 entram no cache (validade informada pelo chamador, 5 min).
 *
 * Original: o6/b.java (fachada: `c(host, cb)` usa `CoroutineLiveDataKt.DEFAULT_TIMEOUT` = 5000 ms e cache de 300000 ms),
 * o6/i.java (fila/loop), o6/k.java (socket), o6/d.java (decoder), o6/e.java (callback).
 */
object DnsClient {
    private val logger = LoggerFactory.getLogger(DnsClient::class.java)
    private const val DEFAULT_TIMEOUT = 5000L
    private const val CACHE_TTL = 300000L

    private val servers = listOf("1.1.1.1", "1.0.0.1", "8.8.8.8", "8.8.4.4", "9.9.9.9", "9.9.9.10").map { InetSocketAddress(it, 53) }
    private val queue = ArrayBlockingQueue<DnsTask>(100)
    private val pending = ConcurrentHashMap<Int, DnsTask>()
    private val cache = ConcurrentHashMap<String, DnsResponse>()
    private val nextId = AtomicInteger((10000..20000).random())   // ac.f.a(10000, 20000)

    private val onResponse: (Int, DnsResponse) -> Unit = { id, response ->
        pending.remove(id)?.let { task ->
            if (response.code == 0) response.name?.let { cache[it] = response }
            task.callback?.invoke(id, response)
        }
    }

    @Volatile private var ready = false
    private var channel: Channel? = null
    private val group = NioEventLoopGroup()

    init {
        Thread({ openSocket() }).start()                              // o6.k.e
        Thread({ executeLoop() }, "dns-execute-thread").start()       // o6.i.d
        Thread({ taskLoop() }, "dns-task-thread").start()             // o6.i.f
    }

    /** Original: o6.b.c(host, cb) / b(host, t, cb) / a(host, timeout, cacheTtl, cb) */
    fun resolve(host: String, timeoutMs: Long = DEFAULT_TIMEOUT, cacheTtlMs: Long = CACHE_TTL, callback: (Int, DnsResponse?) -> Unit) {
        val cached = cache[host]
        if (cached != null && System.currentTimeMillis() - cached.time < cacheTtlMs) {
            callback(-1, cached)
            return
        }
        val task = DnsTask().apply { id = nextId.incrementAndGet(); name = host; this.timeoutMs = timeoutMs; this.callback = callback }
        pending[task.id] = task
        queue.offer(task)
    }

    /** Original: o6.k.e — abre o socket UDP e bloqueia até fechar. */
    private fun openSocket() {
        try {
            val bootstrap = Bootstrap().group(group).channel(NioDatagramChannel::class.java).handler(object : ChannelInitializer<NioDatagramChannel>() {
                override fun initChannel(ch: NioDatagramChannel) {
                    ch.pipeline().addLast(DatagramDnsQueryEncoder())
                    ch.pipeline().addLast(DatagramDnsResponseDecoder())
                    ch.pipeline().addLast(ResponseHandler())
                    logger.debug("[DNS]DNS UDP ChannelHandler initChannel ok")
                }
            })
            val future = bootstrap.bind(0).sync()
            channel = future.channel()
            ready = true
            future.channel().closeFuture().sync()
        } catch (e: Exception) {
            logger.error("[DNS]Socket error.", e)
        } finally {
            group.shutdownGracefully()
            logger.warn("[DNS]Socket stop")
        }
    }

    /** Original: o6.i.d — consome a fila e envia a pergunta A a todos os servidores. */
    private fun executeLoop() {
        while (true) {
            try {
                if (ready) {
                    val task = queue.take()
                    val cached = cache[task.name]
                    if (cached != null) {
                        task.callback?.invoke(-1, cached)
                        pending.remove(task.id)
                    } else {
                        for (server in servers) {
                            val query = DatagramDnsQuery(null, server, task.id).setRecord(DnsSection.QUESTION, DefaultDnsQuestion(task.name, DnsRecordType.A))
                            query.setRecursionDesired(true)
                            channel?.writeAndFlush(query as DnsQuery)
                        }
                    }
                } else Thread.sleep(1000L)
            } catch (e: Exception) { logger.error("[DNS]DNS Execute error", e) }
        }
    }

    /** Original: o6.i.f — expira consultas (timeout => code -1) e marca retransmissão a cada 3 s. */
    private fun taskLoop() {
        while (true) {
            try {
                val now = System.currentTimeMillis()
                val it = pending.entries.iterator()
                while (it.hasNext()) {
                    val task = it.next().value
                    if (now - task.createdAt > task.timeoutMs) {
                        it.remove()
                        val r = DnsResponse().apply { code = -1; name = task.name }
                        task.callback?.invoke(task.id, r)
                    } else if (now - task.lastSentAt > 3000) {
                        pending[task.id] = task
                        task.lastSentAt = now
                    }
                }
                Thread.sleep(1000L)
            } catch (e: Exception) { logger.error("[DNS] task error.", e) }
        }
    }

    /** Original: o6/d.java — converte DatagramDnsResponse em [DnsResponse] (só registros A) e notifica com o id da resposta. */
    private class ResponseHandler : SimpleChannelInboundHandler<DatagramDnsResponse>() {
        override fun channelRead0(ctx: ChannelHandlerContext, msg: DatagramDnsResponse) {
            try {
                val r = DnsResponse()
                r.code = msg.code().intValue()
                if (msg.count(DnsSection.QUESTION) > 0) {
                    var name = (msg.recordAt<DnsQuestion>(DnsSection.QUESTION, 0)).name()
                    val dot = name.lastIndexOf(".")
                    if (dot != -1) name = name.substring(0, dot)
                    r.name = name
                }
                for (i in 0 until msg.count(DnsSection.ANSWER)) {
                    val rec = msg.recordAt<io.netty.handler.codec.dns.DnsRecord>(DnsSection.ANSWER, i)
                    r.type = rec.type()
                    if (rec.type() == DnsRecordType.A) r.answers.add(NetUtil.bytesToIpAddress(ByteBufUtil.getBytes((rec as DnsRawRecord).content())))
                }
                onResponse(msg.id(), r)
            } catch (e: Exception) { logger.error("[DNS] Handler dns response error.", e) }
        }
    }
}
