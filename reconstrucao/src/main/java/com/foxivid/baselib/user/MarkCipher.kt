package com.foxivid.baselib.user

import org.bouncycastle.jce.provider.BouncyCastleProvider
import org.slf4j.LoggerFactory
import java.security.SecureRandom
import java.security.Security
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.SecretKeySpec

/**
 * Cifra usada para gerar o campo "mark" do [UserManager].
 *
 * Original: w6/a.java (cifra) + w6/b.java (hex)
 *
 * Algoritmo identificado: **AES-128 em modo ECB com ZeroBytePadding** (provider BouncyCastle
 * 1.72, registrado no bloco estático: `Security.addProvider(new dd.a())`), saída em hex MAIÚSCULO.
 *
 * Derivação da chave ([generateKey]): `KeyGenerator("AES", 128)` inicializado com
 * `SecureRandom.getInstance("SHA1PRNG")` semeado com a string — o truque clássico (e quebrado)
 * de "senha -> chave AES". Observação: na JVM da Sun/Oracle isso é determinístico, mas no Android
 * 7+ o provider "Crypto" (SHA1PRNG determinístico) foi removido e `setSeed` apenas complementa a
 * entropia do OpenSSL — portanto, em aparelhos modernos, a chave (e o "mark") provavelmente
 * muda a cada processo. (Inferência; o comportamento depende do runtime, não do app.)
 *
 * w6/c.java (XOR repetido com chave "log") não pertence a este fluxo; não reconstruída aqui.
 */
object MarkCipher {

    private val logger = LoggerFactory.getLogger(MarkCipher::class.java)

    init {
        Security.addProvider(BouncyCastleProvider())
    }

    /** Original: w6.a.d(String) — "generateKey": semente -> chave AES em hex maiúsculo ("" em erro). */
    fun generateKeyHex(seed: String): String = try {
        HexUtils.toHex(generateKey(seed), upperCase = true)
    } catch (e: Exception) {
        logger.error("generateKey failed.", e); ""
    }

    /** Original: w6.a.a(byte[], byte[]) — AES/ECB/ZeroBytePadding, modo ENCRYPT (null em erro). */
    fun encrypt(data: ByteArray, key: ByteArray): ByteArray? = try {
        val cipher = Cipher.getInstance("AES/ECB/ZeroBytePadding")
        cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(key, "AES"))
        cipher.doFinal(data)
    } catch (e: Exception) {
        e.printStackTrace(); null
    }

    /** Original: w6.a.b(String, String) — cifra texto UTF-8 com chave em hex e devolve hex maiúsculo. */
    fun encryptToHex(plain: String, keyHex: String): String =
        HexUtils.toHex(encrypt(plain.toByteArray(Charsets.UTF_8), keyFromHex(keyHex))!!, upperCase = true)

    /** Original: w6.a.e(String). */
    fun generateKey(seed: String): ByteArray {
        val kg = KeyGenerator.getInstance("AES")
        val sr = SecureRandom.getInstance("SHA1PRNG")
        sr.setSeed(seed.toByteArray(Charsets.UTF_8))
        kg.init(128, sr)
        return kg.generateKey().encoded
    }

    /** Original: w6.a.c(String). */
    fun keyFromHex(hex: String): ByteArray = try {
        HexUtils.fromHex(hex)
    } catch (e: Exception) {
        logger.error("generateKey failed.", e); ByteArray(0)
    }
}

/** Original: w6/b.java — conversão hex simples. */
object HexUtils {
    /** Original: w6.b.a(byte[], boolean). */
    fun toHex(bytes: ByteArray, upperCase: Boolean): String {
        val s = bytes.joinToString("") { "%02x".format(it.toInt() and 0xFF) }
        return if (upperCase) s.uppercase() else s.lowercase()
    }

    /** Original: w6.b.b(String). */
    fun fromHex(str: String?): ByteArray {
        require(!str.isNullOrEmpty()) { "content is empty" }
        require(str.length % 2 == 0)
        return ByteArray(str.length / 2) { i -> str.substring(i * 2, i * 2 + 2).toInt(16).toByte() }
    }
}
