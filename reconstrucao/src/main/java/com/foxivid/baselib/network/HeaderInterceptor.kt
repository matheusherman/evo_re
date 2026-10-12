package com.foxivid.baselib.network

import com.foxivid.baselib.host.ServerPool
import com.foxivid.baselib.host.ServerProviderUtils
import okhttp3.Request
import org.slf4j.LoggerFactory

/**
 * Fonte dos valores dos cabeçalhos X-Foxivid-*.
 *
 * Original: of/b.java (interface). Os nomes vêm do papel de cada método na implementação
 * `config/b$e` (ver [com.foxivid.baselib.config.DefaultHeaderParamsProvider]).
 */
interface HeaderParamsProvider {
    /** Original: a(). */ fun appId(): Int
    /** Original: b(). */ fun accountId(): String
    /** Original: c(). */ fun appType(): String
    /** Original: d(). */ fun brandId(): Int
    /** Original: e(). */ fun mac(): String
    /** Original: f(). */ fun distributionChannel(): String
    /** Original: g(). */ fun streamToken(): String
    /** Original: h(). */ fun tenantId(): Int
    /** Original: i(). */ fun appVersion(): Long
    /** Original: j(). */ fun serialNumber(): String
    /** Original: k(). */ fun deviceId(): String
    /** Original: l(). */ fun language(): String
    /** Original: m(url). */ fun authToken(url: String): String
}

/**
 * Singleton que delega para o [HeaderParamsProvider] instalado e preenche os cabeçalhos comuns.
 * Também é usado diretamente por modelos (ApiRequestBasic) e clientes de API.
 *
 * Original: of/a.java. Valores padrão quando não há provider: 0 / "" / appType "stb" /
 * canal "0" / idioma "en".
 *
 * Apesar do nome, não é um `okhttp3.Interceptor`: [fillHeaders] é chamado pelo
 * [com.foxivid.baselib.crypto.CryptoRequestInterceptor].
 */
object HeaderInterceptor : HeaderParamsProvider {

    private val logger = LoggerFactory.getLogger(HeaderInterceptor::class.java)

    /** Original: campo `paramsProvider` (c). */
    private var paramsProvider: HeaderParamsProvider? = null

    /** Original: of/a.o(). */
    fun setParamsProvider(provider: HeaderParamsProvider) { paramsProvider = provider }

    override fun appId(): Int = paramsProvider?.appId() ?: 0
    override fun accountId(): String = paramsProvider?.accountId() ?: ""
    override fun appType(): String = paramsProvider?.appType() ?: "stb"
    override fun brandId(): Int = paramsProvider?.brandId() ?: 0
    override fun mac(): String = paramsProvider?.mac() ?: ""
    override fun distributionChannel(): String = paramsProvider?.distributionChannel() ?: "0"
    override fun streamToken(): String = paramsProvider?.streamToken() ?: ""
    override fun tenantId(): Int = paramsProvider?.tenantId() ?: 0
    override fun appVersion(): Long = paramsProvider?.appVersion() ?: 0L
    override fun serialNumber(): String = paramsProvider?.serialNumber() ?: ""
    override fun deviceId(): String = paramsProvider?.deviceId() ?: ""
    override fun language(): String = paramsProvider?.language() ?: "en"
    override fun authToken(url: String): String = paramsProvider?.authToken(url) ?: ""

    /** Pools cujas URLs recebem os cabeçalhos (IMG e STREAM_META ficam de fora). */
    private val POOLS_WITH_HEADERS = setOf(
        ServerPool.AD, ServerPool.UPGRADE, ServerPool.APP_METRIC, ServerPool.MESSAGE_CENTER,
        ServerPool.SPORTS, ServerPool.CHANNEL, ServerPool.ACCOUNT, ServerPool.FEEDBACK,
    ).map { it.key }.toSet()

    /**
     * Se a URL pertence a algum dos pools acima (descoberto por prefixo em
     * [ServerProviderUtils.getPoolsForUrl]), adiciona uma vez:
     * `X-Foxivid-Authorization` (accessToken), `X-Foxivid-App-Id`, `X-Foxivid-App-Version`,
     * `X-Foxivid-Brand-Id`, `X-Foxivid-Language`, `X-Foxivid-Mac`, `X-Foxivid-Uuid` (did),
     * `X-Foxivid-Tenant-Id`, `X-Distribution-Channel`, `X-App-Type`.
     *
     * Original: of/a.n(url, builder) — no descompilado é um `switch` por hashCode cujos cases
     * caem todos no mesmo bloco seguido de `return`.
     */
    fun fillHeaders(url: String, requestBuilder: Request.Builder) {
        for (pool in ServerProviderUtils.getPoolsForUrl(url)) {
            if (pool !in POOLS_WITH_HEADERS) continue
            requestBuilder.addHeader("X-Foxivid-Authorization", authToken(url))
            requestBuilder.addHeader("X-Foxivid-App-Id", appId().toString())
            requestBuilder.addHeader("X-Foxivid-App-Version", appVersion().toString())
            requestBuilder.addHeader("X-Foxivid-Brand-Id", brandId().toString())
            requestBuilder.addHeader("X-Foxivid-Language", language())
            requestBuilder.addHeader("X-Foxivid-Mac", mac())
            try {
                requestBuilder.addHeader("X-Foxivid-Uuid", deviceId())
            } catch (th: Throwable) {
                logger.error("fill X-Foxivid-Uuid failure", th)
            }
            requestBuilder.addHeader("X-Foxivid-Tenant-Id", tenantId().toString())
            requestBuilder.addHeader("X-Distribution-Channel", distributionChannel())
            requestBuilder.addHeader("X-App-Type", appType())
            return
        }
    }
}
