package com.foxivid.baselib.network

import android.content.Context
import com.foxivid.baselib.config.BaseLibConfig
import com.koushikdutta.async.http.AsyncHttpClient
import java.security.KeyStore
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.KeyManagerFactory
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory

/**
 * Configura TLS mútuo no AsyncHttpClient (AndroidAsync/koushikdutta) usado pelo streaming.
 *
 * Original: x1/f1/lb/streaming/client/d.java (`SSLHttpClient.kt`) + client/c (HostnameVerifier).
 *
 * O keystore BKS `res/raw/server` (senha "123456") serve ao mesmo tempo de KeyStore
 * (certificado de cliente) e TrustStore. O HostnameVerifier aceita qualquer host (em debug só loga).
 */
object SSLHttpClient {

    private val logger = LoggerFactory.getLogger(SSLHttpClient::class.java)

    /** Original: `asyncHttpClient` (c). */
    private var asyncHttpClient: AsyncHttpClient? = null

    /** Senha do keystore embutido. */
    private const val KEYSTORE_PASSWORD = "123456"

    /** Original: d.d(context) — dispara em Dispatchers.IO (corrotina `SSLHttpClient$init$1`). */
    fun init(context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val kmf = KeyManagerFactory.getInstance("X509")
                val keyStore = KeyStore.getInstance("BKS")
                keyStore.load(context.resources.openRawResource(R_raw_server), KEYSTORE_PASSWORD.toCharArray())
                kmf.init(keyStore, KEYSTORE_PASSWORD.toCharArray())

                val tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
                val trustStore = KeyStore.getInstance(KeyStore.getDefaultType())
                trustStore.load(context.resources.openRawResource(R_raw_server), KEYSTORE_PASSWORD.toCharArray())
                tmf.init(trustStore)

                val sslContext = SSLContext.getInstance("TLS")
                sslContext.init(kmf.keyManagers, tmf.trustManagers, null)

                if (asyncHttpClient == null) asyncHttpClient = AsyncHttpClient.getDefaultInstance()
                val ssl = AsyncHttpClient.getDefaultInstance().sslSocketMiddleware
                ssl.setSSLContext(sslContext)
                ssl.setTrustManagers(tmf.trustManagers)
                ssl.setHostnameVerifier(HostnameVerifier { host, _ ->
                    if (BaseLibConfig.isDebug) logger.debug("verify: $host")
                    true
                })
            } catch (e: Exception) {
                logger.error("init ssl http client failure", e)
            }
        }
    }

    /** x.l1.b2.R$raw.server (res/raw/server, keystore BKS). */
    private const val R_raw_server: Int = 2131886088
}
