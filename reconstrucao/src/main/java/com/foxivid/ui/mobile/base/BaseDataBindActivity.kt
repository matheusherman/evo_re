package com.foxivid.ui.mobile.base

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PersistableBundle
import android.text.TextUtils
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.foxivid.baselib.heartbeat.UpgradeReadyEvent
import com.foxivid.baselib.model.extra.upgrade.UpgradeInfo
import com.foxivid.baselib.util.FirebaseEvents
import com.foxivid.baselib.util.LocaleManager
import com.foxivid.baselib.util.ToastUtils
import com.foxivid.ui.mobile.R
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.greenrobot.eventbus.EventBus
import org.slf4j.LoggerFactory
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Activity base com DataBinding para o app mobile: define o layout, trava em retrato (se
 * [lockPortrait]), inicializa o Firebase Analytics, reaplica o locale (attachBaseContext, onResume,
 * onConfigurationChanged), implementa a verificação de atualização (checkUpgrade) e o compartilhamento
 * por pacote/seletor.
 *
 * Original: com/tvc/lib/mobile/ui/base/BaseDataBindActivity.java (implements j0.a =
 * FirebaseEvents.FirebaseAnalyticsProvider; corrotina interna b = checkUpgrade)
 */
abstract class BaseDataBindActivity<DB : ViewDataBinding> : AppCompatActivity(),
    FirebaseEvents.FirebaseAnalyticsProvider {

    protected val logger = LoggerFactory.getLogger(javaClass)
    lateinit var mActivity: AppCompatActivity
    lateinit var mDataBinding: DB
    lateinit var firebaseAnalytics: FirebaseAnalytics
    protected open val handler = Handler(Looper.getMainLooper())
    private val isInChecking = AtomicBoolean(false)
    protected var apkFile: String? = null
        private set
    var latestNewVersion: String? = null
    protected var upgradeInfo: UpgradeInfo? = null

    abstract fun initView()                   // v()
    open fun lockPortrait(): Boolean = true   // w()
    @LayoutRes abstract fun layoutId(): Int   // x()

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase?.let { LocaleManager.attach(it, null) })
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
        mDataBinding = DataBindingUtil.setContentView(this, layoutId())
        mDataBinding.lifecycleOwner = this
        if (lockPortrait()) requestedOrientation = 1
        initView()
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
    }

    /**
     * Compartilha [message] por texto simples: sem pacotes -> seletor do sistema; com lista de
     * pacotes separada por vírgula -> tenta cada um até um abrir; se nenhum, toast "app_not_installed".
     * Original: F(String packageNames, String message)
     */
    fun share(packageNames: String, message: String) {
        if (packageNames.isEmpty()) {
            val intent = Intent("android.intent.action.SEND")
            intent.type = "text/plain"
            intent.putExtra("android.intent.extra.TEXT", message)
            logger.debug("share via more")
            startActivity(Intent.createChooser(intent, getString(R.string.share_via)))
            return
        }
        for (pkg in packageNames.split(",")) {
            val intent = Intent("android.intent.action.SEND")
            intent.type = "text/plain"
            intent.setPackage(pkg)
            intent.putExtra("android.intent.extra.TEXT", message)
            try {
                startActivity(intent)
                logger.debug("share via $pkg")
                return
            } catch (e: ActivityNotFoundException) {
                logger.error("share via $pkg", e)
            }
        }
        ToastUtils.showShort(getString(R.string.app_not_installed))
    }

    /**
     * Verifica atualização (uma de cada vez). Chama `InteractionUtils.c(lifecycle, callback)` (t/v/c/i/a)
     * que devolve um Flow<UpgradeInfo?>; o callback (versão, progresso, apk, erro) é repassado ao Main:
     * mostra a versão, progresso, e quando há apk posta [UpgradeReadyEvent]; erros viram toast.
     * Original: l(p onProgress) — corrotina BaseDataBindActivity$checkUpgrade$1
     */
    fun checkUpgrade(onProgress: ((Int?, Any? /* a0: ApiError com errMsg */) -> Unit)? = null) {
        if (isInChecking.compareAndSet(false, true)) {
            CoroutineScope(Dispatchers.Default).launch {
                // t.v.c.i.a.c(lifecycle, callback) -> Flow<UpgradeInfo?> (classe fora deste módulo)
                TODO("InteractionUtils.checkUpgradeFlow(lifecycle, (version, progress, apkPath, error) -> ...)")
            }
        }
    }

    /** Callback de progresso postado no Main. Original: BaseDataBindActivity$b.g(...) */
    private fun onUpgradeProgress(
        version: String?, onProgress: ((Int?, Any?) -> Unit)?, progress: Int?, error: Any?, apkPath: String?, errMsg: String?
    ) {
        if (latestNewVersion != version && !TextUtils.isEmpty(version)) {
            latestNewVersion = version
            if (onProgress == null) ToastUtils.showShort(String.format("%s:%s", getString(R.string.version), version))
        }
        onProgress?.invoke(progress, error)
        if (!TextUtils.isEmpty(apkPath)) {
            apkFile = apkPath
            upgradeInfo?.let { EventBus.getDefault().postSticky(UpgradeReadyEvent(it, apkPath!!)) } // nf/z(info, path, false)
        }
        if (error != null && onProgress == null && errMsg != null) ToastUtils.showShort(errMsg)
        isInChecking.set(false)
    }

    /** Emissão do flow: guarda UpgradeInfo, libera o lock e avisa se não há update. Original: BaseDataBindActivity$b$b.emit */
    private fun onUpgradeInfo(info: UpgradeInfo?, onProgress: ((Int?, Any?) -> Unit)?) {
        upgradeInfo = info
        isInChecking.set(false)
        if ((info?.upgradeStatus ?: 0) == 0) {
            ToastUtils.showShort(getString(R.string.no_version_update))
        } else if (onProgress == null) {
            ToastUtils.showShort(getString(R.string.update_msg))
        }
    }

    /** Versão do app (versionName) ou "". Original: y() */
    fun getVersionName(): String = try {
        packageManager.getPackageInfo(packageName, 0).versionName ?: ""
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        ""
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 100 && resultCode == -1) {
            // x1/f1/lb/heartbeat/f.G0() — reinicia o heartbeat após retorno bem-sucedido
            TODO("HeartbeatManager.G0() (x1/f1/lb/heartbeat/f) — outro módulo")
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleManager.attach(baseContext, null)
    }

    override fun onResume() {
        LocaleManager.attach(baseContext, null)
        super.onResume()
    }

    /** Implementação de FirebaseAnalyticsProvider. Original: a() -> o() */
    override fun get(): FirebaseAnalytics = firebaseAnalytics
}
