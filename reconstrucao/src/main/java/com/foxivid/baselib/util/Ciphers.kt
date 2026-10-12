package com.foxivid.baselib.util

import org.apache.commons.codec.binary.Base64
import org.bouncycastle.jce.provider.BouncyCastleProvider
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.SecureRandom
import java.security.Security
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.SecretKeySpec

/**
 * AES/ECB/ZeroBytePadding com chaves e saída em Base64 URL-safe.
 * Registra o provider BouncyCastle (ofuscado `dd.a`) para suportar ZeroBytePadding.
 *
 * Original: x1/f1/lb/util/o0.java (+ o0$a interface Base64, o0$b implementação com
 * commons-codec, ofuscado `wb.a`). Curiosidade: o logger é criado com a classe `util.a`.
 */
object AesEcbCipher {
    private val logger: Logger = LoggerFactory.getLogger(TextCipher::class.java)

    /** Codificador Base64 plugável. Original: o0$a (`a(byte[])` encode, `b(String)` decode). */
    interface Base64Codec {
        fun encode(byteArray: ByteArray?): String
        fun decode(string: String): ByteArray
    }

    /** Padrão: commons-codec `encodeBase64URLSafeString` / `decodeBase64`. Original: o0$b. */
    private var base64: Base64Codec = object : Base64Codec {
        override fun encode(byteArray: ByteArray?): String = Base64.encodeBase64URLSafeString(byteArray)
        override fun decode(string: String): ByteArray = Base64.decodeBase64(string)
    }

    init {
        Security.addProvider(BouncyCastleProvider())
    }

    /** Original: `o0.b(byte[], byte[])`. */
    private fun decryptBytes(data: ByteArray, key: ByteArray): String? = try {
        val cipher = Cipher.getInstance("AES/ECB/ZeroBytePadding")
        cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(key, "AES"))
        String(cipher.doFinal(data), StandardCharsets.UTF_8)
    } catch (e: Exception) {
        logger.error("decrypt failure", e)
        null
    }

    /** Original: `o0.d(byte[], byte[])`. */
    private fun encryptBytes(data: ByteArray, key: ByteArray): ByteArray? = try {
        val cipher = Cipher.getInstance("AES/ECB/ZeroBytePadding")
        cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(key, "AES"))
        cipher.doFinal(data)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }

    /** Decifra `data` (Base64) com `key` (Base64). Original: `o0.a(String, String)`. */
    fun decrypt(data: String, key: String): String? = decryptBytes(base64.decode(data), base64.decode(key))

    /** Cifra texto UTF-8 e devolve Base64 URL-safe. Original: `o0.c(String, String)`. */
    fun encrypt(data: String, key: String): String? = try {
        base64.encode(encryptBytes(data.toByteArray(Charsets.UTF_8), base64.decode(key)))
    } catch (e: Exception) {
        logger.error("encrypt failure", e)
        null
    }

    /** Gera chave AES-128 derivada da semente e a devolve em Base64. Original: `o0.e(String)`. */
    fun generateKey(keyString: String): String = try {
        base64.encode(deriveKey(keyString))
    } catch (e: Exception) {
        logger.error("generateKey failed.", e)
        ""
    }

    /** Troca o codec Base64 (o app injeta um na inicialização). Original: `o0.f(o0$a)`. */
    fun setBase64(codec: Base64Codec) {
        base64 = codec
    }

    /**
     * KeyGenerator AES 128 com `SecureRandom("SHA1PRNG")` semeado pela string.
     * (Em Android moderno o SHA1PRNG semeado não é determinístico como era no passado.)
     * Original: `o0.g(String)`.
     */
    fun deriveKey(keyString: String): ByteArray {
        val kg = KeyGenerator.getInstance("AES")
        val sr = SecureRandom.getInstance("SHA1PRNG")
        sr.setSeed(keyString.toByteArray(Charsets.UTF_8))
        kg.init(128, sr)
        return kg.generateKey().encoded
    }
}

/**
 * Cifra de texto de alto nível com chave aleatória (por processo) ou fixa.
 * Original: x1/f1/lb/util/a.java
 */
object TextCipher {
    /** Chave fixa real do original (usada pelas preferências). */
    private const val FIXED_KEY = "PrI8TBSHDuybYmKSdaBBYg"

    /**
     * Chave aleatória gerada uma vez por processo. Nota: o original passa
     * `SecretKey.toString()` (não os bytes!) como semente para [AesEcbCipher.generateKey].
     * Original: `a.e()`.
     */
    private val randomKey: String = run {
        val kg = KeyGenerator.getInstance("AES")
        kg.init(256, SecureRandom())
        AesEcbCipher.generateKey(kg.generateKey().toString())
    }

    /** Decifra. Original: `a.a(String, boolean)` (default isRandomKey = true). */
    fun decrypt(text: String, isRandomKey: Boolean = true): String =
        AesEcbCipher.decrypt(text, if (isRandomKey) randomKey else FIXED_KEY) ?: ""

    /** Cifra. Original: `a.c(String, boolean)` (default isRandomKey = true). */
    fun encrypt(text: String, isRandomKey: Boolean = true): String =
        AesEcbCipher.encrypt(text, if (isRandomKey) randomKey else FIXED_KEY) ?: ""
}

/**
 * Codificação hexadecimal e chave MD5 composta.
 * Original: x1/f1/lb/util/o.java
 */
object HexUtils {
    private val DIGITS_LOWER = "0123456789abcdef".toCharArray()
    private val DIGITS_UPPER = "0123456789ABCDEF".toCharArray()

    /** Original: `o.d(byte[], char[])`. */
    private fun encode(data: ByteArray, toDigits: CharArray): CharArray {
        val out = CharArray(data.size shl 1)
        var i = 0
        for (b in data) {
            out[i++] = toDigits[(b.toInt() and 0xF0) ushr 4]
            out[i++] = toDigits[b.toInt() and 0x0F]
        }
        return out
    }

    /** Original: `o.a(byte[])`. */
    private fun toHexString(bytes: ByteArray): String {
        val sb = StringBuilder()
        for (b in bytes) {
            val h = Integer.toHexString(b.toInt() and 255)
            if (h.length == 1) sb.append('0')
            sb.append(h)
        }
        return sb.toString()
    }

    /** Original: `o.b(byte[])`. */
    fun encodeHex(data: ByteArray): CharArray = encodeHex(data, true)

    /** Original: `o.c(byte[], boolean)`. */
    fun encodeHex(data: ByteArray, toLowerCase: Boolean): CharArray =
        encode(data, if (toLowerCase) DIGITS_LOWER else DIGITS_UPPER)

    /**
     * Junta as chaves como "k1.k2.null." e devolve o MD5 hex (fallback: hashCode decimal).
     * Original: `o.e(Object...)`.
     */
    fun md5Key(vararg keys: Any?): String {
        val sb = StringBuilder()
        for (k in keys) {
            if (k == null) sb.append("null.") else sb.append(k).append(".")
        }
        val s = sb.toString()
        return try {
            val md = MessageDigest.getInstance("MD5")
            md.update(s.toByteArray(Charsets.UTF_8))
            toHexString(md.digest())
        } catch (_: Throwable) {
            s.hashCode().toString()
        }
    }
}
