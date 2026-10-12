package com.foxivid.baselib.streaming.server

/** Original: x1/f1/lb/streaming/server/p.java — consulta de métricas por player (id do player = porta/instância). */
interface PlayerMetricQuery {
    fun d(player: Int): Long?
    fun h(player: Int): Long?
    fun j(player: Int): Long?
}

/**
 * Original: x1/f1/lb/streaming/server/n.java — métricas de blocos de mídia (TS) por player: bloco baixado
 * (tempo, ms, bytes, duração, veio do cache?), pergunta se o player está ativo e contagem/registro de bloco.
 */
interface BlockMetricListener : PlayerMetricQuery {
    fun a(player: Int, time: Long, millis: Long, blockName: String, bytes: Int, duration: Double?, isFromCache: Boolean?)
    fun g(player: Int): Boolean
    fun i(player: Int, time: Long, blockName: String)
    fun k(player: Int): Int
}

/**
 * Original: x1/f1/lb/streaming/server/o.java — métricas de índice/playlist (m3u8) por player: pedido de índice
 * (tempo, ms, bytes, lista de blocos), último evento e consulta do nome do bloco.
 */
interface IndexMetricListener : PlayerMetricQuery {
    fun b(player: Int, blockName: String): Int
    fun c(player: Int, time: Long, millis: Long, bytes: Int, playlist: List<String>)
    fun e(player: Int, time: Long)
    fun f(player: Int): String?
}
