package com.foxivid.baselib.streaming.engine

import java.io.InputStream

/*
 * Enums e fachada do motor de streaming proprietário embutido no APK (pacotes ofuscados x6, y6, c7, e7, g7, h7,
 * a7, v6, s6, t6). Esse motor NÃO faz parte de x1/f1/lb, portanto não foi reconstruído por inteiro aqui;
 * só os enums (triviais) e a interface usada pelo módulo de streaming. Resumo do que ele faz está em
 * docs/pipeline_streaming.md.
 */

/** Original: v6/c.java — tipo de reprodução (byte enviado ao motor). */
enum class PlayType(val value: Byte) {
    VOD(0), LIVE(1), CATCHUP(2);
    companion object { fun of(b: Byte) = values().firstOrNull { it.value == b } }
}

/** Original: v6/b.java — tipo de mídia pedido ao motor (extensão do recurso). */
enum class MediaType(val mediaType: Short, val extension: String) {
    INDEX(0, "m3u8"), BLOCK(1, "ts"), SUBTITLE(2, "srt");
    companion object { fun ofExtension(ext: String) = values().firstOrNull { it.extension == ext } }
}

/**
 * Original: v6/d.java — "ts_push_mode": como o motor escreve os blocos recebidos no PipedOutputStream
 * do stream ao vivo (y6/o.w()). UDP = escreve fatia a fatia conforme chegam (k.u()),
 * TS e GOP = escreve o bloco inteiro (k.t()). Padrão em BaseLibConfig = UDP; o valor do a7.a interno é TS.
 */
enum class PushMode(val value: Int) {
    UDP(0), GOP(1), TS(2);
    companion object { fun of(v: Int) = values().firstOrNull { it.value == v } }
}

/** Original: v6/a.java — tipo de dispositivo informado ao tracker. */
enum class DeviceType(val value: Int) {
    TV(0), MOBILE(1);
    companion object { fun of(v: Int) = values().firstOrNull { it.value == v } }
}

/**
 * Original: a7/a.java — configuração mutável do motor (cache de blocos, push mode, nº máx. de blocos em download).
 */
class EngineOptions {
    /** Original: a7.a.f144a — cache em disco de blocos VoD ([com.foxivid.baselib.streaming.server.VodLocalDiskCacheManager]). */
    var blockCache: BlockCache? = null
    var maxDownloadingBlockCnt: Int = 1
    var pushMode: PushMode = PushMode.TS
}

/** Original: y6/l.java — interface do cache de blocos usada pelo motor. */
interface BlockCache {
    fun get(mediaType: MediaType, mediaHash: Int, blockId: Int, blockName: String): ByteArray?
    fun put(mediaType: MediaType, mediaHash: Int, blockId: Int, blockName: String, data: ByteArray?)
    fun start()
    fun stop()
}

/** Original: x6/d.java — callbacks do motor para a camada x1 ([com.foxivid.baselib.streaming.server.EngineService]). */
interface EngineListener {
    fun onNotice(code: Int, msg: String)                                   // a
    fun onTrackerTimeout()                                                  // b
    fun onTrackerRtt(a: Long, b: Long, rtt: Long)                           // c
    fun onSignature(uid: String, mediaId: String, signature: String)        // d
    fun onPeerServerEvent(mediaId: String, code: Int, msg: String)          // e
    fun onTrackerLogout(mediaId: String, code: Int, msg: String)            // f
    fun onPrtTimeout(mediaId: String)                                       // g
    fun onTrackerEvent(mediaId: String, code: Int, msg: String)             // h
    fun onPrtLogout(mediaId: String, code: Int, msg: String)                // i
    fun onBlockMetric(mediaId: String, blockId: Int, blockSize: Int, resendCount: Int, resendRate: Int,
                      costMillis: Long, avgLossRate: Int, rtt: Long)        // j
}

/** Original: e7/b.java — endereço de um servidor tracker (TR). */
class TrackerAddress {
    var serverId: String? = null
    var address: java.net.InetSocketAddress? = null
}

/**
 * Original: x6/c.java — fachada do motor. Só a assinatura usada pela camada x1.
 *
 * Funcionamento (resumo, ver doc):
 * - thread "socket-thread": lê datagramas UDP; mensagens com tipo < 20000 vão ao cliente TR (h7.a, tracker),
 *   20000..29999 ao cliente PR (g7.c, servidor de relay/"peer server"), ≥ 40000 desconhecidas.
 * - thread "engine-schedule": tick de 10 ms dos clientes TR e PR (heartbeat, retransmissão, troca de tracker).
 * - TR autentica (token/uid/did/tenant), devolve qual PR usar (`Refresh connect to PR`) e, opcionalmente,
 *   um endereço HTTP de fallback (c7.c, baixa `index.m3u8` e blocos por OkHttp).
 * - Blocos recebidos vão para y6.o (LIVE), y6.v (VOD) ou y6.j (CATCHUP), que montam playlist/blocos e o
 *   PipedInputStream do ao vivo.
 */
interface StreamEngine {
    /** Original: c.w(List) — inicia o cliente do tracker com a lista de servidores. */
    fun startTracker(trackers: List<TrackerAddress>)
    /** Original: c.v(mediaId, routeId, mediaMode, signature) — começa a tocar um canal (cria cliente PR). */
    fun startPlay(mediaId: String?, routeId: String?, mediaMode: Int, signature: String)
    /** Original: c.y() — para o PR atual. */
    fun stopPlay()
    /** Original: c.x() — para tudo. */
    fun stop()
    /** Original: c.p(mediaId) — stream TS contínuo (ao vivo). */
    fun p(mediaId: String?): InputStream?
    /** Original: c.q(type, mediaId, name) — playlist / bloco / legenda. */
    fun q(type: MediaType, mediaId: String?, name: String): ByteArray?
    /** Original: c.r() — PR conectado? */
    fun isPrConnected(): Boolean
    /** Original: c.s(token) — envia novo token ao tracker ("TKN"). */
    fun refreshToken(token: String)
    /** Original: c.t() */
    fun onPlayerRestart()
}

/** Exceção do motor com código de erro e mensagem (2001/1001 = erros "esperados" ao ler dados). Original: b7/a.java */
class EngineException(val code: Int, val msg: String?) : Exception(msg)

/**
 * Fábrica do motor de streaming (equivale a `new x6.c(uid, did, token, tenantId, peerId, deviceType, playType, options, listener)`).
 * NÃO RECUPERÁVEL neste projeto: x6.c e seus componentes (x6/y6/c7/e7/g7/h7 — cliente de tracker, cliente PR, cache de blocos
 * em disco, protocolo UDP/P2P) formam um motor proprietário que não foi reconstruído. Em lugar de um stub silencioso, a fábrica falha
 * explicitamente.
 */
object StreamEngineFactory {
    fun create(uid: String, did: String?, token: String?, tenantId: String?, peerId: String, deviceType: DeviceType?, playType: PlayType,
               options: EngineOptions, listener: EngineListener): StreamEngine =
        throw UnsupportedOperationException("motor de streaming proprietário (x6.c) não reconstruído — ver docs/pendencias_finais.md")
}
