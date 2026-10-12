package com.foxivid.baselib.util

import android.content.Context
import android.content.pm.PackageManager
import android.content.pm.Signature
import java.security.MessageDigest

/**
 * Leitura da assinatura de um APK instalado (MD5 hex do primeiro certificado).
 * Original: x1/f1/lb/util/y0.java
 */
object SignatureUtils {
    /** Campo presente no original, sem uso observado. */
    private var mySignature = ""

    /** Original: `y0.b(Context, String)` — `GET_SIGNATURES` (64). */
    private fun getSignatures(context: Context, packageName: String?): Array<Signature>? {
        if (packageName.isNullOrEmpty()) return null
        return try {
            @Suppress("DEPRECATION")
            context.packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)?.signatures
        } catch (_: PackageManager.NameNotFoundException) {
            null
        }
    }

    /** MD5 em hex minúsculo. Original: `y0.a(byte[])`. */
    fun md5Hex(bytes: ByteArray): String = try {
        val digits = "0123456789abcdef".toCharArray()
        val d = MessageDigest.getInstance("MD5").apply { update(bytes) }.digest()
        val out = CharArray(d.size * 2)
        var i = 0
        for (b in d) {
            out[i++] = digits[(b.toInt() ushr 4) and 15]
            out[i++] = digits[b.toInt() and 15]
        }
        String(out)
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }

    /** MD5 da assinatura do pacote, ou "" se indisponível. Original: `y0.c(Context, String)`. */
    fun getSignatureMd5(context: Context, packageName: String?): String {
        val sigs = getSignatures(context, packageName)
        if (sigs.isNullOrEmpty()) return ""
        return md5Hex(sigs[0].toByteArray())
    }
}
