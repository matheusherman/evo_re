package com.live.evo

import android.app.Application
import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.foxivid.baselib.network.TrustAllCerts
import com.foxivid.baselib.util.AppLifecycleTracker
import com.hjq.toast.Toaster
import com.live.evo.activity.base.BaseActivity
import com.live.evo.util.LogInit
import com.taobao.sophix.SophixManager
import com.tencent.bugly.crashreport.CrashReport
import org.slf4j.LoggerFactory
import java.io.InputStream

/**
 * Application real do app (no APK, o manifest declara `com.stub.StubApp` do packer 360 Jiagu,
 * que carrega esta classe; o [SophixStubApplication] também aponta para ela via @SophixEntry).
 *
 * Original: com/live/evo/MyApplication.java
 */
open class MyApplication : Application() {

    /** Activities vivas (registradas por BaseActivity). Original: campo `a`. */
    private val activities = mutableListOf<BaseActivity>()

    /** Conjunto genérico de objetos retidos. Original: campo `b`. */
    private val retained = HashSet<Any>()

    /** Original: d() — sempre true. */
    open fun isMainProcess(): Boolean = true

    /** Original: b(BaseActivity) */
    fun addActivity(activity: BaseActivity) { activities.add(activity) }

    /** Original: c(Object) */
    fun retain(obj: Any) { retained.add(obj) }

    /** Original: e(BaseActivity) */
    fun removeActivity(activity: BaseActivity) { activities.remove(activity) }

    /**
     * Original: MyApplication.onCreate()
     * - Glide usa OkHttp com o cliente "trust-all" do SDK (of.e.e()).
     * - LogInit (util/y0), AppUserManager.init (evo/l.B), Toaster, Sophix (busca patch), Bugly (app id "b1897f2807"),
     *   e AppLifecycleTracker do SDK (x1.f1.lb.util.c.n).
     */
    override fun onCreate() {
        super.onCreate()
        appContext = this
        instance = this
        try {
            Glide.get(this).registry.replace(
                GlideUrl::class.java, InputStream::class.java,
                OkHttpUrlLoader.Factory(TrustAllCerts.unsafeOkHttpClient()),
            )
        } catch (e: Exception) {
            logger.error("glide https url loader setup failure", e)
        }
        LogInit.init(this)
        AppUserManager.init(this)
        Toaster.init(this)
        SophixManager.getInstance().queryAndLoadNewPatch()
        CrashReport.initCrashReport(this, "b1897f2807", true)
        AppLifecycleTracker.register(this)
    }

    /** Original: onTerminate() — encerra o processo. */
    override fun onTerminate() {
        super.onTerminate()
        System.exit(0)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(MyApplication::class.java)

        /** Contexto global (substituído em InitActivity pelo contexto "original" do Jiagu). Original: `d`. */
        @JvmStatic lateinit var appContext: Context

        /** Original: `e` / a() */
        @JvmStatic lateinit var instance: MyApplication
            private set

        @JvmStatic fun get(): MyApplication = instance
    }
}
