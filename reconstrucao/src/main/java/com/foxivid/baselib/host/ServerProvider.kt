package com.foxivid.baselib.host

import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.network.RetrofitFactory
import org.slf4j.LoggerFactory

/**
 * Fornece a interface Retrofit [T] apontando para o servidor atual de um pool, com rodízio
 * (round-robin) a partir da 2ª nova tentativa.
 *
 * Original: x1/f1/lb/host/a.java.
 *
 * Regras:
 *  - `retryCnt < 2`: usa o servidor do índice atual (fora do intervalo -> o primeiro);
 *  - `retryCnt >= 2`: avança o índice (volta a 0 no fim) e usa o novo servidor;
 *  - caso especial para o cliente de métricas (uf/b): não usa Retrofit; cria `uf.b(servers, client)`
 *    e só recria (fechando o anterior) quando a lista de servidores muda.
 */
class ServerProvider<T>(private val key: String, private val clazz: Class<T>) {

    private val logger = LoggerFactory.getLogger(ServerProvider::class.java)

    /** Original: `index` (b). */
    private var index = 0

    /** Original: `oldServers` (e). */
    private var oldServers: List<String> = ArrayList()

    /** Original: `api` (f) — só usado no caso uf/b. */
    private var api: T? = null

    /** Original: a.e(). */
    private fun currentServer(): String {
        val list = ServerProviderUtils.getServers(key)
        if (list.isNullOrEmpty()) return ""
        val i = index
        return if (i >= list.size || i < 0) list[0] else list[i]
    }

    /** Original: a.d(retryCnt). */
    private fun nextServer(retryCnt: Int): String = synchronized(this) {
        val from = index
        var to = from + 1
        val list = ServerProviderUtils.getServers(key) ?: return ""
        if (to >= list.size) to = 0
        if (BaseLibConfig.isDebug) {
            logger.info("retry[$retryCnt] next $key server $from -> $to : ${list[to]}")
        } else {
            logger.info("retry[$retryCnt] next $key server $from -> $to")
        }
        index = to
        currentServer()
    }

    /**
     * Interface sobre o cliente CIFRADO (ou o cliente de métricas).
     * Original: a.a(retryCnt) (+ a.b(...) com retryCnt=0 por padrão).
     */
    @Suppress("UNCHECKED_CAST")
    fun get(retryCnt: Int = 0): T? {
        if (clazz != MetricClientRef::class.java) {
            val endpoint = if (retryCnt < 2) currentServer() else nextServer(retryCnt)
            return RetrofitFactory.cryptoRetrofit(endpoint).create(clazz)
        }
        val list = ServerProviderUtils.getServers(key) ?: return null
        var result: T? = null
        if (oldServers == list) {
            result = api
        } else {
            (api as MetricClientRef?)?.close()
            api = null
        }
        if (result == null) {
            // Original: new uf.b(list.toTypedArray(), RetrofitFactory.okHttpClient)
            result = TODO("módulo metric: uf/b(servers, RetrofitFactory.okHttpClient)") as T
            api = result
        }
        if (oldServers != list) oldServers = list
        return result
    }

    /** Interface sobre o cliente SEM criptografia. Original: a.c(retryCnt). */
    fun getPlain(retryCnt: Int): T? {
        val endpoint = if (retryCnt < 2) currentServer() else nextServer(retryCnt)
        return RetrofitFactory.plainRetrofit(endpoint).create(clazz)
    }
}
