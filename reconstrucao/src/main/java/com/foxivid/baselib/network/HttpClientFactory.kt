package com.foxivid.baselib.network

import android.util.Log
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.crypto.CryptoRequestInterceptor
import com.foxivid.baselib.crypto.CryptoResponseInterceptor
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import okhttp3.ConnectionPool
import okhttp3.Dns
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.slf4j.LoggerFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * TrustManager que aceita qualquer certificado (cliente e servidor).
 * Original: of/e$a.
 */
object TrustAllCerts : X509TrustManager {
    override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
    override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {}
    override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {}
}

/**
 * Fábrica dos dois OkHttpClient do SDK.
 *
 * Original: of/e.java (+ of/c: lambda do logger HTTP; of/d: HostnameVerifier que retorna true).
 *
 * Ambos os clientes: SSLContext("SSL") com [TrustAllCerts], HostnameVerifier que aceita tudo,
 * `System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,SSLv3")`, ConnectionPool(10, 2 min),
 * connect 15 s, read 15 s, ping 30 s, retryOnConnectionFailure, followRedirects=false e DNS
 * próprio (mf/b — resolvedor assíncrono com fallback para o DNS do sistema, outro módulo).
 */
object HttpClientFactory {

    /** Original: `cryptoClient` (b). */
    @Volatile private var cryptoClient: OkHttpClient? = null

    /** Original: `plainClient` (c). */
    @Volatile private var plainClient: OkHttpClient? = null

    /**
     * HttpLoggingInterceptor nível BODY; só é adicionado em debug e trunca em 1000 chars.
     * Original: of/e (static) + of/e.i(String).
     */
    private val logInterceptor = HttpLoggingInterceptor { message ->
        val log = LoggerFactory.getLogger(HttpLoggingInterceptor::class.java)
        if (BaseLibConfig.isDebug) {
            try {
                if (message.length > 1000) log.debug("http[{}]", message.subSequence(0, 1000))
                else log.debug("http[{}]", message)
            } catch (e: Exception) {
                e.printStackTrace()
                try { Log.i("OkHttpUtils", "http[{$message}]") } catch (e2: Exception) { e2.printStackTrace() }
            }
        }
    }.apply { level = HttpLoggingInterceptor.Level.BODY }

    /** Original: of/e.g(). Em caso de erro retorna o contexto parcialmente inicializado (ou null). */
    private fun trustAllSslContext(): SSLContext? {
        var ctx: SSLContext? = null
        try {
            ctx = SSLContext.getInstance("SSL")
            ctx.init(null, arrayOf<TrustManager>(TrustAllCerts), SecureRandom())
        } catch (e: KeyManagementException) {
            e.printStackTrace()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return ctx
    }

    /** Original: of/e.c(). */
    private fun baseBuilder(): OkHttpClient.Builder {
        val builder = OkHttpClient.Builder()
        trustAllSslContext()?.let { ctx ->
            builder.sslSocketFactory(ctx.socketFactory, TrustAllCerts)
            System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,SSLv3")
            builder.hostnameVerifier(HostnameVerifier { _, _ -> true })
        }
        return builder
    }

    private fun commonBuilder(): OkHttpClient.Builder = baseBuilder()
        .connectionPool(ConnectionPool(10, 2L, TimeUnit.MINUTES))
        .connectTimeout(15L, TimeUnit.SECONDS)
        .readTimeout(15L, TimeUnit.SECONDS)
        .pingInterval(30L, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .dns(customDns())
        .followRedirects(false)

    /** Cliente sem criptografia (usado p.ex. pelo upload de feedback). Original: of/e.e(). */
    fun plainClient(): OkHttpClient {
        plainClient?.let { return it }
        synchronized(this) {
            val b = commonBuilder()
            if (BaseLibConfig.isDebug) b.addInterceptor(logInterceptor)
            return b.build().also { plainClient = it }
        }
    }

    /**
     * Cliente com o protocolo cifrado: CryptoRequestInterceptor -> (log, se debug) -> CryptoResponseInterceptor.
     * Original: of/e.f().
     */
    fun cryptoClient(): OkHttpClient {
        cryptoClient?.let { return it }
        synchronized(this) {
            val b = commonBuilder().addInterceptor(CryptoRequestInterceptor())
            if (BaseLibConfig.isDebug) b.addInterceptor(logInterceptor)
            b.addInterceptor(CryptoResponseInterceptor())
            return b.build().also { cryptoClient = it }
        }
    }

    /** Original: `new mf.b()`. */
    private fun customDns(): Dns = TODO("outro módulo: mf/b (DNS assíncrono com fallback para Dns.SYSTEM)")
}

/**
 * Cache de instâncias Retrofit por endpoint (Gson + call adapter do Sandwich).
 *
 * Original: of/f.java.
 *
 * Observação: os dois métodos compartilham o MESMO HashMap `clients`; a primeira variante a criar
 * o Retrofit para um endpoint "vence" (o cliente cifrado e o simples não coexistem por endpoint).
 */
object RetrofitFactory {

    /** Original: `okHttpClient` (b). */
    val okHttpClient: OkHttpClient by lazy { HttpClientFactory.cryptoClient() }

    /** Original: `clients` (c). */
    private val clients = HashMap<String, Retrofit>()

    /** Retrofit sobre o cliente cifrado. Original: of/f.b(endPoint). */
    @Synchronized
    fun cryptoRetrofit(endPoint: String): Retrofit = clients.getOrPut(endPoint) {
        Retrofit.Builder()
            .baseUrl(endPoint)
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create()) // k6.a
            .addConverterFactory(GsonConverterFactory.create())            // ff.a.f()
            .client(okHttpClient)
            .build()
    }

    /** Retrofit sobre o cliente sem criptografia. Original: of/f.c(endPoint). */
    @Synchronized
    fun plainRetrofit(endPoint: String): Retrofit = clients.getOrPut(endPoint) {
        Retrofit.Builder()
            .baseUrl(endPoint)
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(HttpClientFactory.plainClient())
            .build()
    }
}
