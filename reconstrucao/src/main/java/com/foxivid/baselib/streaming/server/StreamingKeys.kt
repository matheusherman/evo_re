package com.foxivid.baselib.streaming.server

import com.foxivid.baselib.streaming.StreamHelper
import org.slf4j.LoggerFactory

/**
 * Original: x1/f1/lb/streaming/server/r.java
 *
 * Tabela de nomes de rotas e de parâmetros usados entre o "cliente" ([com.foxivid.baselib.streaming.client.EngineHelper])
 * e os servidores HTTP locais ([NioHttpServer] / [NettyHttpServer]).
 *
 * Detalhe importante: **todos os nomes são aleatórios e gerados a cada execução** do processo
 * (ofuscação em tempo de execução). Ex.: a rota "startEngine" pode virar `/k` numa execução e `/q` em outra;
 * o parâmetro de sessão pode ser `?a=...`. Só o próprio processo conhece o mapeamento, o que impede
 * outro app/ferramenta de chamar o proxy local sem saber os nomes.
 *
 * O comprimento de cada nome é fixo (1..11 caracteres para rotas, 1..3 para rotas de mídia, 1..8 para chaves);
 * o 1º caractere é letra minúscula, os demais letra ou dígito.
 */
object StreamingKeys {

    private val logger = LoggerFactory.getLogger(StreamingKeys::class.java)

    // --- rotas de controle (GET http://127.0.0.1:<porta>/<rota>) ---
    val startEngine: String = randomName(1)
    val stopEngine: String = randomName(2)
    val startPlay: String = randomName(3)
    val stopPlay: String = randomName(4)
    val addPlayer: String = randomName(5)
    val removePlayer: String = randomName(6)
    val isConnected: String = randomName(7)
    val refreshToken: String = randomName(8)
    val getSubtitle: String = randomName(9)
    val isEngineRunning: String = randomName(10)
    val startCatchup: String = randomName(11)

    // --- rotas de mídia ---
    /** Prefixo dos segmentos de catch-up reescritos (`<catchupTs>_<n>.ts`). */
    val catchupTs: String = randomName(1)
    /** Nome da playlist HLS local (`/<liveM3u8>.m3u8`). */
    val liveM3u8: String = randomName(2)
    /** Prefixo do stream TS contínuo servido pelo Netty (`/<liveTs>/<mediaId>.ts`). */
    val liveTs: String = randomName(3)

    // --- chaves de query string ---
    val sessionKey: String = randomName(1)
    val paramsKey: String = randomName(2)
    val playerKey: String = randomName(3)
    val typeKey: String = randomName(4)
    val tokenKey: String = randomName(5)
    val mediaIdKey: String = randomName(6)
    val langKey: String = randomName(7)
    val catchupParamKey: String = randomName(8)

    /** Original: r.y(int) — gera um identificador aleatório de [len] caracteres. */
    private fun randomName(len: Int): String {
        val sb = StringBuilder()
        sb.append(((Math.random() * 25).toInt() + 'a'.code).toChar())
        for (i in 1 until len) {
            if (Math.random() > 0.5) sb.append(((Math.random() * 25).toInt() + 'a'.code).toChar())
            else sb.append(('0'.code + (Math.random() * 9).toInt()).toChar())
        }
        return sb.toString()
    }

    /**
     * Original: r.x() — porta aleatória para os servidores locais.
     * `Priority.FATAL_INT` do log4j = 50000 ⇒ intervalo [1024, 51023].
     */
    fun randomPort(): Int = (Math.random() * 50000).toInt() + 1024

    /**
     * Original: r.a(String)
     * Decodifica o valor do parâmetro `params` (Base64 URL-safe + cifra de [StreamHelper.decodeParams])
     * e o transforma em mapa `chave=valor` separado por `&`.
     */
    fun parseParams(params: String): Map<String, String> {
        if (params.isEmpty()) return emptyMap()
        val decoded = StreamHelper.decodeParams(params)
        val parts = decoded.split("&").dropLastWhile { it.isEmpty() }
        val map = HashMap<String, String>()
        for (p in parts) {
            try {
                val kv = p.split("=")
                map[kv[0]] = kv[1]
            } catch (t: Throwable) {
                logger.error("split failure: \"$parts\" of \"$decoded\"", t)
            }
        }
        return map
    }
}
