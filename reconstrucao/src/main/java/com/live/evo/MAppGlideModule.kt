package com.live.evo

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import java.io.InputStream

/**
 * Módulo Glide do app: registra `OkHttpUrlLoader` usando o OkHttpClient do SDK (`of.e.f16588a.e()` =
 * `HttpClientFactory` do baselib), de modo que imagens usem o mesmo client/DNS/certificados do app.
 * Manifest parsing desligado. (As classes `c`, `d`, `e` do pacote são o código gerado pelo Glide:
 * GlideOptions, GlideRequest, GlideRequests — não reconstruídas.)
 *
 * Original: com/live/evo/MAppGlideModule.java (+ c.java GlideOptions, d.java GlideRequest, e.java GlideRequests)
 */
@GlideModule
class MAppGlideModule : AppGlideModule() {
    override fun isManifestParsingEnabled() = false
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.replace(GlideUrl::class.java, InputStream::class.java,
            OkHttpUrlLoader.Factory(com.foxivid.baselib.network.HttpClientFactory.client()))
    }
}
