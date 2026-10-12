package com.foxivid.baselib.host

import com.foxivid.baselib.api.AccountApi
import com.foxivid.baselib.api.AccountAuxApi
import com.foxivid.baselib.api.FeedbackApi
import com.foxivid.baselib.api.MessageApi
import com.foxivid.baselib.api.PtvAccountApi
import com.foxivid.baselib.api.RechargeApi
import com.foxivid.baselib.api.SportsApi
import com.foxivid.baselib.api.StreamMetaApi
import com.foxivid.baselib.api.UpgradeApi
import com.foxivid.baselib.cache.BaseCache
import com.foxivid.baselib.config.BaseLibConfig
import com.google.gson.reflect.TypeToken
import java.io.File
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.apache.commons.lang3.StringUtils
import org.slf4j.LoggerFactory

/**
 * Pools de servidores. A chave (string) é usada no mapa de servidores, no cache em disco e nas
 * propriedades remotas (app property) que podem atualizar as listas.
 *
 * Não existe enum no original: as chaves são literais em host/b.g() e of/a.n().
 */
enum class ServerPool(val key: String) {
    ACCOUNT("ACCOUNT_SERVERS"),
    AD("AD_SERVERS"),
    CHANNEL("CHANNEL_SERVERS"),
    FEEDBACK("FEEDBACK_SERVERS"),
    UPGRADE("UPGRADE_SERVERS"),
    MESSAGE_CENTER("MESSAGE_CENTER_SERVERS"),
    APP_METRIC("APP_METRIC_SERVERS"),
    STREAM_META("STREAM_META_SERVERS"),
    IMG("IMG_SERVERS"),
    SPORTS("SPORTS_SERVERS"),
}

/**
 * Registro dos servidores de cada pool (com failover) e fábrica de [ServerProvider].
 *
 * Original: x1/f1/lb/host/b.java (`ServerProviderUtils.kt`).
 *
 * Cada pool começa com o endpoint passado em [init] (pode ser lista separada por vírgula),
 * mesclado com o valor salvo no cache em disco; propriedades remotas ([updateServers]) podem
 * acrescentar servidores na frente da lista.
 */
object ServerProviderUtils {

    private val logger = LoggerFactory.getLogger(ServerProviderUtils::class.java)

    /** Cache em disco "<hostsCachePath>/cache" (BaseCache<String>). Original: `hostsCache` (c). */
    private var hostsCache: BaseCache<String>? = null

    /** pool -> lista ordenada de servidores. Original: `servers` (d). */
    private val servers = HashMap<String, List<String>>()

    /** servidor (URL base) -> pools que o usam. Original: `endpoints` (e). */
    private val endpoints = HashMap<String, HashSet<String>>()

    /**
     * Inicializa os pools.
     *
     * Original: host/b.g(...) — o jadx NÃO descompilou este método ("Regions count limit");
     * a lógica abaixo foi reconstruída a partir do dump em modo fallback (`jadx -m fallback`),
     * instrução por instrução:
     *  1. cria `BaseCache(hostsCachePath + File.separator + "cache", TypeToken<String>, appVersion, 10240)`;
     *  2. monta o mapa pool -> endpoint (ordem abaixo, via `mapOf`);
     *  3. para cada pool: se o endpoint não é nulo, `servers[pool] = parse(pool, endpoint)`;
     *     depois lê o cache (`hostsCache.get(pool)`, suspend) e, se houver valor salvo,
     *     `servers[pool] = parse(pool, cached, servers[pool])` (cache vai na frente).
     */
    suspend fun init(
        hostsCachePath: String,
        appVersion: Int,
        authEndPoint: String?,
        adEndPoint: String?,
        channelEndPoint: String?,
        feedbackEndPoint: String?,
        upgradeEndPoint: String?,
        messageEndPoint: String?,
        metricEndPoint: String?,
        streamMediaEndPoint: String?,
        imgEndPoint: String?,
        sportsEndPoint: String?,
    ) {
        val cache = BaseCache<String>(
            hostsCachePath + File.separator + "cache",
            object : TypeToken<String>() {}.type, // Original: host/b$b (f3.a<String>)
            appVersion,
            10240L,
        )
        hostsCache = cache
        val map = mapOf(
            ServerPool.ACCOUNT.key to authEndPoint,
            ServerPool.AD.key to adEndPoint,
            ServerPool.CHANNEL.key to channelEndPoint,
            ServerPool.FEEDBACK.key to feedbackEndPoint,
            ServerPool.UPGRADE.key to upgradeEndPoint,
            ServerPool.MESSAGE_CENTER.key to messageEndPoint,
            ServerPool.APP_METRIC.key to metricEndPoint,
            ServerPool.STREAM_META.key to streamMediaEndPoint,
            ServerPool.IMG.key to imgEndPoint,
            ServerPool.SPORTS.key to sportsEndPoint,
        )
        for (key in map.keys) {
            map[key]?.let { servers[key] = parseServers(key, it) }
            val cached = cache.get(key)
            if (cached != null) servers[key] = parseServers(key, cached, servers[key])
        }
    }

    /**
     * Converte "a, b, c" em lista (trim em cada item), anexa os servidores antigos que não
     * estiverem na nova lista e registra cada servidor em [endpoints].
     *
     * Original: host/b.n(key, line, old) (+ o(...) com old=null por padrão).
     * Quirk preservado: se `StringUtils.split` devolver vazio, o original faz `list.set(0, ...)`
     * numa lista vazia (lançaria IndexOutOfBoundsException).
     */
    private fun parseServers(key: String, line: String?, old: List<String>? = null): List<String> {
        if (line.isNullOrEmpty()) return old ?: ArrayList()
        val list = ArrayList<String>()
        val parts = StringUtils.split(line, ",")
        if (parts.isEmpty()) {
            list[0] = StringUtils.trim(line)
        } else {
            for (p in parts) list.add(StringUtils.trim(p))
        }
        old?.forEach { if (!list.contains(it)) list.add(it) }
        for (server in list) {
            endpoints.getOrPut(server) { HashSet() }.add(key)
        }
        return list
    }

    /** Lista atual de servidores de um pool. Original: host/b.e(key). */
    fun getServers(key: String): List<String>? = servers[key]

    /**
     * Pools aos quais a URL pertence (primeiro servidor que seja prefixo da URL).
     * Original: host/b.d(url).
     */
    fun getPoolsForUrl(url: String): Set<String> {
        for (server in endpoints.keys) {
            if (url.startsWith(server)) return endpoints[server] ?: HashSet()
        }
        return HashSet()
    }

    /**
     * Atualiza pools a partir das propriedades remotas (chave = nome do pool).
     *
     * Original: host/b.p(properties). Quirk preservado: quando a nova lista é igual à anterior,
     * o original faz `break` (não `continue`), interrompendo a varredura dos demais pools.
     * As mudanças são persistidas no cache em background (Original: host/b$c — `updateServer$1`,
     * não descompilado; reconstruído do bytecode no comentário do jadx).
     */
    fun updateServers(properties: Map<*, *>?) {
        if (properties == null) return
        val changed = LinkedHashMap<String, String>()
        for (key in servers.keys) {
            val value = properties[key] ?: continue
            val line = value.toString()
            val old = servers[key]
            val updated = parseServers(key, line, old)
            if (updated == old) break
            changed[key] = line
            servers[key] = updated
            if (BaseLibConfig.isDebug) logger.debug("update $key server:$old -> $updated")
        }
        if (changed.isEmpty()) return
        CoroutineScope(Dispatchers.IO).launch {
            for (key in changed.keys) {
                val value = properties[key] ?: continue
                if (hostsCache?.get(key) == value) continue
                hostsCache?.put(key, value.toString())
            }
        }
    }

    // ---- Fábricas de provider (Original: host/b.b/c/f/h/i/j/k/l/m/q) ----

    /** Original: b(). */ fun accountApi() = ServerProvider(ServerPool.ACCOUNT.key, AccountApi::class.java)
    /** Original: c(). */ fun feedbackApi() = ServerProvider(ServerPool.FEEDBACK.key, FeedbackApi::class.java)
    /** Original: f(). */ fun accountAuxApi() = ServerProvider(ServerPool.ACCOUNT.key, AccountAuxApi::class.java)
    /** Original: h(). */ fun messageApi() = ServerProvider(ServerPool.MESSAGE_CENTER.key, MessageApi::class.java)
    /** Original: i() — cliente de métricas uf/b (módulo metric). */
    fun metricClient() = ServerProvider(ServerPool.APP_METRIC.key, MetricClientRef::class.java)
    /** Original: j(). */ fun ptvAccountApi() = ServerProvider(ServerPool.ACCOUNT.key, PtvAccountApi::class.java)
    /** Original: k(). */ fun rechargeApi() = ServerProvider(ServerPool.ACCOUNT.key, RechargeApi::class.java)
    /** Original: l(). */ fun sportsApi() = ServerProvider(ServerPool.SPORTS.key, SportsApi::class.java)
    /** Original: m(). */ fun streamMetaApi() = ServerProvider(ServerPool.STREAM_META.key, StreamMetaApi::class.java)
    /** Original: q(). */ fun upgradeApi() = ServerProvider(ServerPool.UPGRADE.key, UpgradeApi::class.java)
}

/**
 * Marcador do cliente de métricas uf/b (pertence ao módulo `com.foxivid.baselib.metric`).
 * Construtor original: `uf.b(String[] servers, OkHttpClient client)`; método `g()` = fechar.
 */
abstract class MetricClientRef(val servers: Array<String>, val client: okhttp3.OkHttpClient) {
    /** Original: uf/b.g(). */
    abstract fun close()
}
