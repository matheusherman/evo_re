package com.foxivid.baselib.util

import android.annotation.SuppressLint
import java.security.cert.X509Certificate
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSession
import javax.net.ssl.X509TrustManager

/**
 * TrustManager que aceita qualquer certificado (sem validação TLS). Usado por [LegacyTvUtils].
 * Original: x1/f1/lb/util/r0.java
 */
@SuppressLint("CustomX509TrustManager", "TrustAllX509TrustManager")
class TrustAllX509TrustManager : X509TrustManager {
    override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
    override fun checkClientTrusted(chain: Array<X509Certificate>?, authType: String?) {}
    override fun checkServerTrusted(chain: Array<X509Certificate>?, authType: String?) {}
}

/**
 * HostnameVerifier que aceita qualquer host.
 * Original: x1/f1/lb/util/h1.java
 */
class TrustAllHostnameVerifier : HostnameVerifier {
    override fun verify(hostname: String?, session: SSLSession?): Boolean = true
}
