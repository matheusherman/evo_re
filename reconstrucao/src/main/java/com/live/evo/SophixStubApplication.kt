package com.live.evo

import android.content.Context
import androidx.annotation.Keep
import com.taobao.sophix.SophixApplication
import com.taobao.sophix.SophixEntry
import com.taobao.sophix.SophixManager
import com.taobao.sophix.listener.PatchLoadStatusListener

/**
 * Stub do hotfix Alibaba Sophix: inicializa o SophixManager antes da Application real ([MyApplication]).
 * Segredos do Sophix ficam no manifest (com.taobao.android.hotfix.IDSECRET/APPSECRET/RSASECRET).
 *
 * Original: com/live/evo/SophixStubApplication.java
 */
class SophixStubApplication : SophixApplication() {

    private val tag = "SophixStubApplication"

    /** Original: a() — versão do app, tag "Gray", enhance ligado, debug desligado, log completo. */
    private fun initSophix() {
        val version = try {
            packageManager.getPackageInfo(packageName, 0).versionName
        } catch (e: Exception) {
            "0.0.0"
        }
        SophixManager.getInstance().setContext(this)
            .setUsingEnhance(true)
            .setAppVersion(version)
            .setSecretMetaData(null, null, null)
            .setEnableDebug(false)
            .setEnableFullLog()
            .setTags(listOf("Gray"))
            .setPatchLoadStatusStub(PatchLoadStatusListener { _, _, _, _ -> /* vazio no original */ })
            .initialize()
    }

    /** Aponta o Sophix para a Application real. Original: SophixStubApplication$RealApplicationStub */
    @Keep
    @SophixEntry(MyApplication::class)
    internal class RealApplicationStub

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        initSophix()
    }

    override fun onCreate() {
        try { super.onCreate() } catch (_: Throwable) { }
    }
}
