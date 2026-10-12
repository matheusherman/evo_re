package com.foxivid.baselib.log

import com.foxivid.baselib.util.LoggerFactory
import java.io.IOException
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.channels.DatagramChannel
import java.util.concurrent.LinkedBlockingQueue

/**
 * Socket UDP não bloqueante usado pelo logger remoto.
 *
 * Original: d7/a.java (SO_TIMEOUT = a7.b.f148b = 500 ms, SNDBUF = a7.b.f150d = 24576)
 */
class UdpChannel @Throws(IOException::class) constructor() {
    private val channel: DatagramChannel
    private var closed = true

    init {
        val ch = DatagramChannel.open()
        ch.configureBlocking(false)
        ch.socket().soTimeout = 500
        ch.socket().sendBufferSize = 24576
        channel = ch
        closed = false
    }

    /** Original: d7.a.a(ByteBuffer, InetSocketAddress) */
    fun send(buffer: ByteBuffer, address: InetSocketAddress?) {
        if (closed) return
        try { channel.send(buffer, address) } catch (e: Exception) { logger.error("socket Send error.", e) }
    }

    companion object { private val logger = LoggerFactory.getLogger(UdpChannel::class.java) }
}

/**
 * Pacote de log binário.
 *
 * Original: r6/a.java (pacote), r6/b.java (cabeçalho), r6/c.java (serializador), w6/c.java (XOR)
 *
 * Formato (big-endian):
 * ```
 * int32 magic   = -182581299 (0xF51E07CD)
 * int32 type    = 10003 (log de texto)
 * int32 length  = String.length do texto (em chars, não bytes!)
 * bytes payload = UTF-8(texto) XOR "log" (chave repetida)
 * ```
 */
object LogPacketCodec {
    const val MAGIC = -182581299
    const val TYPE_LOG = 10003
    /** Original: w6.c.f20090a */
    private val XOR_KEY = "log".toByteArray(Charsets.UTF_8)

    /** Original: w6.c.a(byte[], byte[]) */
    fun xor(data: ByteArray?, key: ByteArray? = XOR_KEY): ByteArray? {
        if (data == null || key == null || key.isEmpty()) return data
        return ByteArray(data.size) { i -> (data[i].toInt() xor key[i % key.size].toInt()).toByte() }
    }

    /** Original: r6.c.a(r6.a, ByteBuffer) — escreve no buffer SEM clear()/flip() (ver [UdpLogSender]). */
    fun write(type: Int, length: Int, payload: ByteArray, buffer: ByteBuffer): ByteBuffer {
        buffer.putInt(MAGIC)
        buffer.putInt(type)
        buffer.putInt(length)
        if (length > 0) buffer.put(xor(payload)!!)
        return buffer
    }
}

/**
 * Envio assíncrono de linhas de log por UDP. Cada mensagem recebe o prefixo
 * `[channel][uid][did]` e é truncada em 1300 caracteres.
 *
 * Original: d7/c.java (thread "log-thread", fila de 10000)
 *
 * O servidor é escolhido por `servers[uid.hashCode() % servers.size]` (pode dar índice negativo
 * se o hash for negativo → exceção não tratada em [setServers]).
 *
 * **Bug confirmado no bytecode** (verificado com `jadx -m fallback`): o mesmo `ByteBuffer` de
 * 1400 bytes é reutilizado sem `clear()`/`flip()`. Assim o primeiro `send()` transmite os bytes
 * *depois* do conteúdo escrito (zeros até o limite) e avança a posição até 1400; a partir daí todo
 * `putInt` lança BufferOverflowException, capturada com `"send log error."`. Na prática o log
 * remoto UDP não entrega conteúdo útil.
 */
class UdpLogSender(servers: Array<String>, channelId: String, uid: String, did: String) {
    /** Original: d7.c.f9652b */ private var address: InetSocketAddress? = null
    /** Original: d7.c.f9654d */ private val servers: Array<String> = servers
    /** Original: d7.c.f9655e — prefixo "[channel][uid][did]" */ private var prefix = ""
    private var channelId = ""
    private var uid = ""
    private var did = ""
    private val queue = LinkedBlockingQueue<Item>(10000)
    private val udp = UdpChannel()

    private class Item(val type: Int, val text: String)

    init {
        setIdentity(channelId, uid, did)
        setServers(servers)
        Thread({ loop() }, "log-thread").start()
    }

    /** Original: d7.c.c(int, String) — descarta se sem servidor ou texto vazio (ac.g.f = isEmpty). */
    private fun enqueue(type: Int, text: String?) {
        if (address == null || text.isNullOrEmpty()) return
        queue.offer(Item(type, text))
    }

    /** Original: d7.c.f() */
    private fun loop() {
        val buffer = ByteBuffer.allocate(1400).order(ByteOrder.BIG_ENDIAN)
        while (true) {
            try {
                val item = queue.take() ?: continue
                if (item.text.isEmpty()) continue
                var s = prefix + item.text
                if (s.length > 1300) s = s.substring(0, 1300)
                LogPacketCodec.write(item.type, s.length, s.toByteArray(Charsets.UTF_8), buffer)
                // (sic) sem buffer.flip() — ver KDoc da classe
                udp.send(buffer, address)
            } catch (_: Exception) {
                println("send log error.")
            }
        }
    }

    /** Original: d7.c.b(String) */
    fun send(text: String) = enqueue(LogPacketCodec.TYPE_LOG, text)

    /** Original: d7.c.d(String[]) */
    fun setServers(servers: Array<String>?) {
        if (servers == null || servers.isEmpty()) return
        val parts = servers[uid.hashCode() % servers.size].split(":")
        if (parts.size != 2) return
        address = InetSocketAddress(parts[0], parts[1].toInt())
    }

    /** Original: d7.c.e(String, String, String) */
    fun setIdentity(channelId: String, uid: String, did: String) {
        this.channelId = channelId
        this.uid = uid
        this.did = did
        prefix = String.format("[%s][%s][%s]", channelId, uid, did)
    }
}
