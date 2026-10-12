package com.foxivid.baselib.crypto

import android.os.Build
import android.util.Base64
import com.foxivid.baselib.config.TimeUtilsRef
import java.security.KeyFactory
import java.security.MessageDigest
import java.security.PublicKey
import java.security.SecureRandom
import java.security.Security
import java.security.spec.X509EncodedKeySpec
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import okhttp3.Request
import org.bouncycastle.jce.provider.BouncyCastleProvider

/**
 * Protocolo de criptografia das APIs (envelope híbrido RSA + AES).
 *
 * Original: lf/b.java (+ lf/a.java: lambda de formatação hex "%02x").
 *
 * Requisição:
 *  1. gera chave AES-128 e IV aleatórios (16 bytes cada, SecureRandom);
 *  2. `cipherText` = Base64(AES/CBC/PKCS5Padding(json));
 *  3. `X-Key` = Base64(RSA/ECB/PKCS1Padding(chaveAES)) com a chave pública do servidor;
 *  4. `X-V` = Base64(IV);  `X-Timestamp` = d1.d() (ms, relógio ajustado ao servidor);
 *     `X-Nonce` = UUID aleatório;
 *  5. `X-Sign` = sha256hex(cipherText + timestamp + nonce + clientSecret).
 *
 * Resposta: o servidor devolve corpo cifrado + `X-Timestamp`/`X-Nonce`/`X-Sign`; a assinatura é
 * conferida com o segredo do servidor [SERVER_SECRET] e o corpo decifrado com a MESMA chave/IV
 * da requisição (o cliente nunca recebe chave nova).
 *
 * Todos os Base64 usam a flag 2 (NO_WRAP). Provider "BC" (BouncyCastle, registrado no init estático).
 */
object ApiCrypto {

    /** Segredo usado para verificar a assinatura das respostas. Original: literal em pf/b.a(). */
    const val SERVER_SECRET = "MDYcfn10w0SRglN87LkxGC3E13xLMgKN"

    /** Original: campo `clientSecret` (b). */
    private var clientSecret = ""

    /** Chave pública X.509 em Base64, já sem cabeçalhos PEM e espaços. Original: `serverPublicKeyPem` (c). */
    private var serverPublicKeyPem = ""

    init {
        // Original: bloco static — registra BouncyCastle (dd.a) se ainda não houver provider "BC".
        if (Security.getProvider("BC") == null) Security.addProvider(BouncyCastleProvider())
    }

    /**
     * Envelope cifrado de uma requisição; guarda a chave/IV crus para decifrar a resposta.
     * Original: lf/b$a (data class `EncryptedPayload`).
     */
    data class EncryptedPayload(
        val cipherText: String,
        val aesKeyEncrypted: String,
        val iv: String,
        val timestamp: String,
        val nonce: String,
        val sign: String,
        val aesKey: ByteArray,
        val ivRaw: ByteArray,
    )

    /**
     * Configura segredos; remove "-----BEGIN/END PUBLIC KEY-----" e todo espaço em branco.
     * Original: lf/b.f(clientSecret, serverPublicKeyPem).
     */
    fun init(clientSecret: String, serverPublicKeyPem: String) {
        this.clientSecret = clientSecret
        this.serverPublicKeyPem = serverPublicKeyPem
            .replace("-----BEGIN PUBLIC KEY-----", "")
            .replace("-----END PUBLIC KEY-----", "")
            .replace(Regex("\\s"), "")
    }

    /** Criptografia ativa somente se ambos os segredos foram configurados. Original: lf/b.g(). */
    val isEnabled: Boolean
        get() = clientSecret.isNotEmpty() && serverPublicKeyPem.isNotEmpty()

    /** Original: lf/b.d(json). */
    fun encrypt(json: String): EncryptedPayload {
        val key = ByteArray(16).also { SecureRandom().nextBytes(it) }
        val iv = ByteArray(16).also { SecureRandom().nextBytes(it) }
        val cipherText = aesEncrypt(json, key, iv)
        val encryptedKey = rsaEncrypt(key)
        val timestamp = TimeUtilsRef.now().toString()
        val nonce = UUID.randomUUID().toString()
        val sign = sha256Hex(cipherText + timestamp + nonce + clientSecret)
        return EncryptedPayload(
            cipherText, encryptedKey, Base64.encodeToString(iv, Base64.NO_WRAP),
            timestamp, nonce, sign, key, iv,
        )
    }

    /**
     * Verifica a assinatura da resposta e decifra o corpo.
     * @throws IllegalArgumentException "response signature mismatch"
     * Original: lf/b.e(...).
     */
    fun decryptResponse(
        cipherText: String, timestamp: String, nonce: String, sign: String,
        aesKey: ByteArray, iv: ByteArray, serverSecret: String,
    ): String {
        if (sha256Hex(cipherText + timestamp + nonce + serverSecret) == sign) {
            return aesDecrypt(cipherText, aesKey, iv)
        }
        throw IllegalArgumentException("response signature mismatch")
    }

    /** Original: lf/b.c(). */
    private fun aesEncrypt(plainText: String, key: ByteArray, iv: ByteArray): String {
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC")
        cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(key, "AES"), IvParameterSpec(iv))
        return Base64.encodeToString(cipher.doFinal(plainText.toByteArray(Charsets.UTF_8)), Base64.NO_WRAP)
    }

    /** Original: lf/b.b(). */
    private fun aesDecrypt(cipherText: String, key: ByteArray, iv: ByteArray): String {
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC")
        cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(key, "AES"), IvParameterSpec(iv))
        return String(cipher.doFinal(Base64.decode(cipherText, Base64.NO_WRAP)), Charsets.UTF_8)
    }

    /** A partir do Android P usa o provider padrão para KeyFactory; antes, "BC". Original: lf/b.h(). */
    private fun serverPublicKey(): PublicKey {
        val factory = if (Build.VERSION.SDK_INT >= 28) KeyFactory.getInstance("RSA")
        else KeyFactory.getInstance("RSA", "BC")
        return factory.generatePublic(X509EncodedKeySpec(Base64.decode(serverPublicKeyPem, Base64.NO_WRAP)))
    }

    /** Original: lf/b.i(). */
    private fun rsaEncrypt(keyBytes: ByteArray): String {
        val cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC")
        cipher.init(Cipher.ENCRYPT_MODE, serverPublicKey())
        return Base64.encodeToString(cipher.doFinal(keyBytes), Base64.NO_WRAP)
    }

    /** SHA-256 em hex minúsculo. Original: lf/b.j() + lf/a (String.format("%02x")). */
    private fun sha256Hex(payload: String): String =
        MessageDigest.getInstance("SHA-256").digest(payload.toByteArray(Charsets.UTF_8))
            .joinToString("") { String.format("%02x", it) }
}

/**
 * Mapa Request -> envelope, para o interceptor de resposta achar a chave/IV da requisição.
 *
 * Original: pf/c.java (`cryptoMap`).
 *
 * Observação: a chave é o objeto `okhttp3.Request` (igualdade por identidade) e nenhuma
 * entrada é removida em lugar algum do código — o mapa cresce indefinidamente.
 */
object CryptoRegistry {
    val cryptoMap: ConcurrentHashMap<Request, ApiCrypto.EncryptedPayload> = ConcurrentHashMap()
}
