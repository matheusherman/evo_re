package com.foxivid.baselib.crypto

import java.security.KeyPairGenerator
import java.security.MessageDigest
import java.security.PrivateKey
import java.security.PublicKey
import java.security.SecureRandom
import java.util.Base64
import java.util.UUID
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

/**
 * Demonstração autônoma (JVM puro, só javax.crypto) do protocolo de [ApiCrypto] e dos
 * interceptores pf/a + pf/b. NÃO existe no app original — é material didático.
 *
 * Como a chave privada do servidor não está no APK, o "servidor" aqui gera o próprio par RSA;
 * os segredos de assinatura são os reais do app:
 *  - cliente -> servidor: sha256hex(cipher + ts + nonce + "myQeN2Ql7NNL7I14DG2rGZ7dvR6TGNK2")
 *  - servidor -> cliente: sha256hex(cipher + ts + nonce + "MDYcfn10w0SRglN87LkxGC3E13xLMgKN")
 *
 * Executar: `kotlinc ApiCryptoDemo.kt -include-runtime -d demo.jar && java -cp demo.jar com.foxivid.baselib.crypto.ApiCryptoDemoKt`
 * (em JVM puro "AES/CBC/PKCS5Padding" e "RSA/ECB/PKCS1Padding" existem no provider SunJCE.)
 */
object ApiCryptoDemo {
    const val CLIENT_SECRET = "myQeN2Ql7NNL7I14DG2rGZ7dvR6TGNK2"
    const val SERVER_SECRET = "MDYcfn10w0SRglN87LkxGC3E13xLMgKN"

    private val b64e = Base64.getEncoder()   // equivale a android Base64.NO_WRAP
    private val b64d = Base64.getDecoder()

    fun sha256Hex(s: String) = MessageDigest.getInstance("SHA-256")
        .digest(s.toByteArray(Charsets.UTF_8)).joinToString("") { "%02x".format(it) }

    fun aes(mode: Int, key: ByteArray, iv: ByteArray, data: ByteArray): ByteArray =
        Cipher.getInstance("AES/CBC/PKCS5Padding").run {
            init(mode, SecretKeySpec(key, "AES"), IvParameterSpec(iv)); doFinal(data)
        }

    /** Cabeçalhos/corpo que o cliente envia (lado pf/a + lf/b.d). */
    data class ClientRequest(val headers: Map<String, String>, val body: String, val key: ByteArray, val iv: ByteArray)

    fun clientEncrypt(json: String, serverPub: PublicKey): ClientRequest {
        val key = ByteArray(16).also { SecureRandom().nextBytes(it) }
        val iv = ByteArray(16).also { SecureRandom().nextBytes(it) }
        val cipherText = b64e.encodeToString(aes(Cipher.ENCRYPT_MODE, key, iv, json.toByteArray()))
        val xKey = Cipher.getInstance("RSA/ECB/PKCS1Padding").run {
            init(Cipher.ENCRYPT_MODE, serverPub); b64e.encodeToString(doFinal(key))
        }
        val ts = System.currentTimeMillis().toString()
        val nonce = UUID.randomUUID().toString()
        val headers = mapOf(
            "X-Version" to "1001",
            "X-Key" to xKey,
            "X-V" to b64e.encodeToString(iv),
            "X-Timestamp" to ts,
            "X-Nonce" to nonce,
            "X-Sign" to sha256Hex(cipherText + ts + nonce + CLIENT_SECRET),
        )
        // POST: cipherText vai no corpo (application/octet-stream); GET: vai no cabeçalho X-Data.
        return ClientRequest(headers, cipherText, key, iv)
    }

    /** Simulação do servidor: valida, decifra, responde cifrando com a MESMA chave/IV. */
    fun serverHandle(req: ClientRequest, serverPriv: PrivateKey): Pair<Map<String, String>, String> {
        val h = req.headers
        require(sha256Hex(req.body + h["X-Timestamp"] + h["X-Nonce"] + CLIENT_SECRET) == h["X-Sign"]) { "bad sign" }
        val key = Cipher.getInstance("RSA/ECB/PKCS1Padding").run {
            init(Cipher.DECRYPT_MODE, serverPriv); doFinal(b64d.decode(h["X-Key"]))
        }
        val iv = b64d.decode(h["X-V"])
        val plain = String(aes(Cipher.DECRYPT_MODE, key, iv, b64d.decode(req.body)))
        println("servidor recebeu: $plain")
        val respJson = """{"errCode":0,"errMsg":"ok","data":{"echo":$plain}}"""
        val respCipher = b64e.encodeToString(aes(Cipher.ENCRYPT_MODE, key, iv, respJson.toByteArray()))
        val ts = System.currentTimeMillis().toString()
        val nonce = UUID.randomUUID().toString()
        val headers = mapOf("X-Timestamp" to ts, "X-Nonce" to nonce,
            "X-Sign" to sha256Hex(respCipher + ts + nonce + SERVER_SECRET))
        return headers to "\"$respCipher\"" // corpo como string JSON (pf/b remove as aspas)
    }

    /** Lado pf/b + lf/b.e. */
    fun clientDecrypt(headers: Map<String, String>, body: String, key: ByteArray, iv: ByteArray): String {
        val cipher = body.replace("\"", "")
        val ts = headers.getValue("X-Timestamp"); val nonce = headers.getValue("X-Nonce")
        require(sha256Hex(cipher + ts + nonce + SERVER_SECRET) == headers["X-Sign"]) { "response signature mismatch" }
        return String(aes(Cipher.DECRYPT_MODE, key, iv, b64d.decode(cipher)), Charsets.UTF_8)
    }
}

fun main() {
    val serverKeys = KeyPairGenerator.getInstance("RSA").apply { initialize(2048) }.generateKeyPair()
    val req = ApiCryptoDemo.clientEncrypt("""{"username":"demo","password":"x"}""", serverKeys.public)
    println("requisição: ${req.headers}\ncorpo: ${req.body}")
    val (respHeaders, respBody) = ApiCryptoDemo.serverHandle(req, serverKeys.private)
    println("resposta decifrada: " + ApiCryptoDemo.clientDecrypt(respHeaders, respBody, req.key, req.iv))
}
