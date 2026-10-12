package com.foxivid.baselib.crypto

import androidx.annotation.RequiresApi
import com.foxivid.baselib.network.HeaderInterceptor
import com.google.gson.Gson
import java.nio.charset.Charset
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer
import org.slf4j.LoggerFactory

/**
 * Cifra o corpo/parâmetros de cada requisição e injeta os cabeçalhos X-Foxivid-* + X-Key/X-V/...
 *
 * Original: pf/a.java.
 *
 * - Criptografia desligada ([ApiCrypto.isEnabled] = false): só adiciona os cabeçalhos X-Foxivid-*.
 * - GET: remove a query string da URL, serializa os parâmetros num mapa JSON (Gson), cifra e envia
 *   o texto cifrado no cabeçalho **X-Data** (com `Content-Type: application/octet-stream`).
 * - POST: cifra o corpo (charset do Content-Type, padrão UTF-8) e o substitui por
 *   `application/octet-stream` contendo o Base64 cifrado.
 * - Outros métodos: só cabeçalhos X-Foxivid-*.
 * - Qualquer exceção vira uma resposta sintética HTTP 400 "failure in request interceptor".
 *
 * Cabeçalhos comuns adicionados: `X-Version: 1001`, `X-Key`, `X-V`, `X-Timestamp`, `X-Nonce`, `X-Sign`.
 */
class CryptoRequestInterceptor : Interceptor {

    private val logger = LoggerFactory.getLogger(CryptoRequestInterceptor::class.java) // Original: q6.c.d(a.class)

    /** Original: pf/a.a(chain). */
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        try {
            if (!ApiCrypto.isEnabled) {
                val builder = request.newBuilder()
                HeaderInterceptor.fillHeaders(request.url.toString(), builder)
                return chain.proceed(builder.build())
            }
            when (request.method) {
                "GET" -> {
                    val url = request.url.newBuilder().build()
                    // Original: url.replace(query, "").replace("?", "")
                    val urlWithoutQuery = url.toString()
                        .replace(url.encodedQuery ?: "", "")
                        .replace("?", "")
                    val builder = request.newBuilder().url(urlWithoutQuery)
                    HeaderInterceptor.fillHeaders(urlWithoutQuery, builder)
                    val params = HashMap<String, String>()
                    for (name in url.queryParameterNames) {
                        url.queryParameter(name)?.let { params[name] = it }
                    }
                    val payload = ApiCrypto.encrypt(Gson().toJson(params))
                    builder.addHeader("X-Version", "1001")
                        .addHeader("Content-Type", "application/octet-stream")
                        .addHeader("X-Key", payload.aesKeyEncrypted)
                        .addHeader("X-V", payload.iv)
                        .addHeader("X-Timestamp", payload.timestamp)
                        .addHeader("X-Nonce", payload.nonce)
                        .addHeader("X-Sign", payload.sign)
                        .addHeader("X-Data", payload.cipherText)
                    val newRequest = builder.build()
                    CryptoRegistry.cryptoMap[newRequest] = payload
                    return chain.proceed(newRequest)
                }
                "POST" -> {
                    val buffer = Buffer()
                    val body = request.body
                    body?.writeTo(buffer)
                    var charset: Charset = Charset.forName("UTF-8")
                    body?.contentType()?.let { charset = it.charset(charset)!! }
                    val payload = ApiCrypto.encrypt(buffer.readString(charset))
                    val newBody = payload.cipherText.toRequestBody("application/octet-stream".toMediaTypeOrNull())
                    val builder = request.newBuilder()
                    HeaderInterceptor.fillHeaders(request.url.toString(), builder)
                    builder.post(newBody)
                        .addHeader("X-Version", "1001")
                        .addHeader("X-Key", payload.aesKeyEncrypted)
                        .addHeader("X-V", payload.iv)
                        .addHeader("X-Timestamp", payload.timestamp)
                        .addHeader("X-Nonce", payload.nonce)
                        .addHeader("X-Sign", payload.sign)
                    val newRequest = builder.build()
                    CryptoRegistry.cryptoMap[newRequest] = payload
                    return chain.proceed(newRequest)
                }
                else -> {
                    val builder = request.newBuilder()
                    HeaderInterceptor.fillHeaders(request.url.toString(), builder)
                    return chain.proceed(builder.build())
                }
            }
        } catch (th: Throwable) {
            logger.error("request failure[" + request.url + "]", th)
            return Response.Builder()
                .protocol(chain.connection()?.protocol() ?: Protocol.HTTP_1_1)
                .request(request)
                .code(400)
                .message("failure in request interceptor")
                .body("".toResponseBody(null))
                .build()
        }
    }
}

/**
 * Verifica e decifra as respostas das requisições cifradas por [CryptoRequestInterceptor].
 *
 * Original: pf/b.java (anotado com `@RequiresApi(30)` no original).
 *
 * Só atua se a criptografia está ligada e existe envelope para o Request em [CryptoRegistry].
 * Exige `X-Timestamp`, `X-Nonce` e `X-Sign` na resposta; o corpo é lido como string e as aspas
 * `"` são removidas (o servidor manda o Base64 como string JSON). O novo corpo é
 * `application/json` com o texto decifrado. Sem os cabeçalhos, loga erro e devolve a resposta crua.
 */
class CryptoResponseInterceptor : Interceptor {

    private val logger = LoggerFactory.getLogger(CryptoResponseInterceptor::class.java)

    /** Original: pf/b.a(chain). */
    @RequiresApi(30)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        if (!ApiCrypto.isEnabled) return response
        val payload = CryptoRegistry.cryptoMap[request] ?: return response

        val builder = response.newBuilder()
        val timestamp = response.header("X-Timestamp")
        val nonce = response.header("X-Nonce")
        val sign = response.header("X-Sign")
        if (!timestamp.isNullOrEmpty() && !nonce.isNullOrEmpty() && !sign.isNullOrEmpty()) {
            val cipherText = response.body?.string()?.replace("\"", "") ?: ""
            val plain = ApiCrypto.decryptResponse(
                cipherText, timestamp, nonce, sign, payload.aesKey, payload.ivRaw, ApiCrypto.SERVER_SECRET,
            )
            builder.body(plain.toResponseBody("application/json".toMediaType()))
            return builder.build()
        }
        logger.error("response header invalid, url[" + chain.request().url + "] request headers[" + request.headers + "]")
        logger.error("response header invalid, url[" + chain.request().url + "] response [" + response.code + "] headers[" + response.headers + "]")
        return response
    }
}
