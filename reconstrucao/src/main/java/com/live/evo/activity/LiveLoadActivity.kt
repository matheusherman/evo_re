package com.live.evo.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import com.foxivid.baselib.ad.AdManager
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.config.InteractionUtils
import com.foxivid.baselib.model.extra.upgrade.UpgradeInfo
import com.foxivid.baselib.network.AppParams
import com.foxivid.baselib.player.VideoView
import com.foxivid.baselib.util.AppInfo
import com.foxivid.baselib.util.EventBusHelper
import com.foxivid.baselib.util.KvStore
import com.foxivid.baselib.util.ToastHelper
import com.foxivid.ui.LoadingViewController
import com.foxivid.ui.mobile.ui.widget.LoadingView
import com.live.evo.AppUserManager
import com.live.evo.BuildConfig
import com.live.evo.MyApplication
import com.live.evo.R
import com.live.evo.activity.base.LoginBaseActivity
import com.live.evo.ad.BootAdViewManager
import com.live.evo.ad.SplashAdRepository
import com.live.evo.boot.AsyncExecutor
import com.live.evo.boot.BootManager
import com.live.evo.dialog.ConfirmDialog
import com.live.evo.dialog.ExitDialog
import com.live.evo.dialog.NoticeAlertDialog
import com.live.evo.dialog.UpgradePromptDialog
import com.live.evo.event.ChannelUpdateEvent
import com.live.evo.event.NoticeEvent
import com.live.evo.fragment.NetworkStatusDialogFragment
import com.live.evo.fragment.login.AdultWarningFragment
import com.live.evo.fragment.login.LoginFinishFragment
import com.live.evo.fragment.login.LoginNavigator
import com.live.evo.fragment.login.RechargeDialogFragment
import com.live.evo.fragment.login.RenewCodeLoginSupportFragment
import com.live.evo.fragment.login.WelcomeFragment
import com.live.evo.fragment.subject.SubjectDataHelper
import com.live.evo.model.AccountBean
import com.live.evo.osd.OsdControlListener
import com.live.evo.upgrade.UpgradeInstaller
import com.live.evo.util.AppDirs
import com.live.evo.util.AppPropertiesStore
import com.live.evo.util.CommonUtils
import com.live.evo.util.DateUtils
import com.live.evo.util.EpgRepository
import com.live.evo.util.KeyboardUtils
import com.live.evo.util.LoadingTimer
import com.live.evo.util.PermissionUtils
import com.live.evo.util.PlaybackPrefs
import com.live.evo.util.SerialExecutor
import com.live.evo.util.ServerClock
import com.live.evo.util.SkinConfig
import com.live.evo.util.TimeZoneHelper
import com.live.evo.widget.SpeedTextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.slf4j.LoggerFactory
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Tela de carregamento/login da versão STB (TV). Aberta por [com.live.load.InitActivity] quando appType == "stb"
 * e também reaberta por [LiveNewActivity] com `startType=1` + `message` (logout forçado / erro).
 *
 * Original: com/live/evo/activity/LiveLoadActivity.java
 *
 * É uma máquina de estados dirigida por mensagens de um [Handler] (constantes `MSG_*`, valores reais do original):
 * ```
 * onCreate(nativo) → startLoad (C1)
 *   startType==1 → mostra login com a mensagem recebida
 *   senão        → MSG_REQUEST_PERMISSION → MSG_INIT_RUNTIME_ENV (rede ok?) → MSG_NETWORK_OK
 *                  → checkUpdate(silencioso) + MSG_QUERY_LOGIN
 * MSG_QUERY_LOGIN (l1): logout forçado? (versão não suportada → diálogo de upgrade | senão login manual)
 *                       senão → boas-vindas/aviso adulto/login automático
 * MSG_LOGIN (E1): fluxo de login do SDK → ok → MSG_REMIND (expiração/recarga) → MSG_FIX_DST
 * MSG_FIX_DST (y1): ajuste de fuso horário → carregar canais → [LiveNewActivity]
 * ```
 */
class LiveLoadActivity : LoginBaseActivity(), View.OnKeyListener {

    private val logger = LoggerFactory.getLogger(LiveLoadActivity::class.java)

    private var mAdSkipTip: TextView? = null
    private var adNewViewManager: BootAdViewManager? = null   // v4.d
    private var startType: Int? = null
    private var isOnSavedState = false
    private var upgradeInfo: UpgradeInfo? = null
    private var lastProgress = 0
    private var loadingView: LoadingView? = null              // com.tvc.lib.mobile.ui.widget.b
    private var mFm: FragmentManager? = null
    private var mNetworkTester: NetworkStatusDialogFragment.NetworkTester? = null
    private var mExitDialog: ExitDialog? = null
    private var mNoticeView: SpeedTextView? = null
    private var mBackPressedAgain = false
    private var mVideoView: VideoView? = null
    private var mVersion: TextView? = null
    private var mImageVideoCurtain: ImageView? = null
    private var mCurtainDrawable: Drawable? = null
    private var mMainRoot: ViewGroup? = null
    private var mRoot: View? = null
    private var mBootWithVideo = false
    private var mBootVideoUri: String? = null
    private var noticeAlertDialog: NoticeAlertDialog? = null
    private var mHasStartLive = false
    private var mAdSkipLayout: LinearLayout? = null
    private var mAdIv: ImageButton? = null

    /** activity-alias de launcher: ícone "free trial" vs normal. */
    private val iconFreeTrial = "com.live.evo.freetrial"
    private val iconNormal = "com.live.evo.normal"

    private val isInChecking = AtomicBoolean(false)
    private var apkFile: String = ""
    private var lastVersion: String = ""

    /** Original: LiveLoadActivity$f */
    @SuppressLint("HandlerLeak")
    val mHandler: Handler = object : Handler() {
        private var isFirstLogin = false
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                MSG_NETWORK_OK -> { checkUpdate(true); sendEmptyMessage(MSG_QUERY_LOGIN) }
                MSG_ACTIVATE -> { LoadingTimer.mark("liveLoadActivate"); onActivated() }
                MSG_REMIND -> {
                    LoadingTimer.mark("liveLoadRemind")
                    if (!isFirstLogin) showExpiryRemind() else sendEmptyMessage(MSG_FIX_DST)
                }
                MSG_574 -> onMsg574()
                MSG_WAIT_APP_READY -> if (!MyApplication.get().isMainProcess()) {
                    sendEmptyMessageDelayed(MSG_WAIT_APP_READY, 50L)
                } else {
                    showLoading(R.string.init_env)
                    LoadingTimer.mark("liveLoadReqPermisson")
                    requestPermissions()
                }
                MSG_INIT_RUNTIME_ENV -> { LoadingTimer.mark("liveLoadInitRuntimeEnv"); initRuntimeEnv() }
                MSG_QUERY_LOGIN -> { LoadingTimer.mark("liveLoadQueryLogin"); queryLogin() }
                MSG_LOGIN -> { LoadingTimer.mark("liveLoadLogin"); showLoading(R.string.account_login_title); login() }
                MSG_FIX_DST -> { LoadingTimer.mark("liveLoadFixDst"); showLoading(R.string.loading_data); fixDstThenLoad() }
                MSG_SHOW_WELCOME -> { LoadingTimer.mark("liveLoadShowWelcom"); isFirstLogin = true; showWelcome() }
                MSG_ADULT_WARNING -> showAdultWarning()
                MSG_INIT_DATA -> initData()
                MSG_RESET_BACK -> mBackPressedAgain = false
                MSG_START_CORE -> startCoreProcess()
                MSG_SHOW_AD_OR_VIDEO -> showBootAdOrVideo()
                MSG_START_LIVE -> startLive()
            }
        }
    }

    /**
     * Inferência: corpo `native` (Jiagu). Pelos métodos existentes, provavelmente chama
     * [setupViews] (d1: setContentView(activity_load), views, versão, loading) e em seguida
     * dispara [initSplashAds] (corrotina `g`: configura BaseLibConfig e carrega anúncios → MSG_SHOW_AD_OR_VIDEO)
     * e [startLoad] (C1).
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TODO("nativo/não decompilado: LiveLoadActivity.onCreate — provável setupViews() + initSplashAds() + startLoad()")
    }

    /** Inferência: `native`; provavelmente encaminha para BaseActivity e, se concedido, MSG_INIT_RUNTIME_ENV. */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        TODO("nativo/não decompilado: LiveLoadActivity.onRequestPermissionsResult")
    }

    /** Monta a UI. Original: d1() */
    fun setupViews() {
        startType = intent.getIntExtra("startType", 0)
        mBootWithVideo = startType != 1 && SkinConfig.get().hasBootVideo()
        if (mBootWithVideo) {
            mBootVideoUri = SkinConfig.get().bootVideoUri()
            mCurtainDrawable = SkinConfig.get().bootCurtainDrawable()
        }
        setContentView(R.layout.activity_load)
        mMainRoot = findViewById(R.id.loada_rl_parent)
        mRoot = findViewById(R.id.root)
        mNoticeView = findViewById(R.id.loada_tv_notice)
        mVideoView = findViewById(R.id.loada_video_view)
        mVersion = findViewById(R.id.loada_tv_version)
        mImageVideoCurtain = findViewById(R.id.loada_iv_video_curtain)
        mAdSkipLayout = findViewById(R.id.loada_ad_canskip)
        mAdIv = findViewById(R.id.loada_iv_ad)
        mAdSkipTip = findViewById(R.id.loada_ad_canskip_tv2)
        mVideoView?.setOnKeyListener(this)
        mAdIv?.setOnKeyListener(this)
        // Qual activity-alias abriu o app define o modo "free trial" (muda nome/ícone exibidos).
        when (intent?.component?.className) {
            iconFreeTrial -> CommonUtils.setFreeTrialMode(true)
            iconNormal -> CommonUtils.setFreeTrialMode(false)
        }
        findViewById<TextView>(R.id.versionTextView).text = String.format("%s %s", getText(R.string.version), AppInfo.versionName())
        loadingView = LoadingViewController.create(R.id.loading_layout, R.color.color_focused, window.decorView.rootView).also { it.show() }
    }

    /**
     * Corrotina `LiveLoadActivity$g`: configura o SDK (protocolo UDP de métricas, flag por modo de login "code")
     * e carrega anúncios de abertura; ao terminar → MSG_SHOW_AD_OR_VIDEO.
     * Original: g.invokeSuspend() + V0()
     */
    fun initSplashAds() = lifecycleScope.launch {
        BaseLibConfig.setMetricTransport(BaseLibConfig.Transport.UDP)       // L(v6.d.UDP)
        BaseLibConfig.setFlagZ(AppParams.loginMode() != "code")              // z(!(of.a.f()=="code"))
        BaseLibConfig.setFlagC(true)
        SplashAdRepository.get().load { mHandler.sendEmptyMessage(MSG_SHOW_AD_OR_VIDEO) }   // v4.b.o().v(...)
    }

    /** Exibe anúncio de boot, ou vídeo de boot, ou segue direto para initData. Original: w1() */
    private fun showBootAdOrVideo() {
        if (SplashAdRepository.get().hasAd() && startType != 1 && !InteractionUtils.isForcedLogout()) {
            adNewViewManager = BootAdViewManager.create(this)
            LoadingTimer.mark("liveLoadShowAd")
            adNewViewManager?.show()
            return
        }
        if (mBootWithVideo && !InteractionUtils.isForcedLogout()) {
            mVideoView?.visibility = View.VISIBLE
            mImageVideoCurtain?.visibility = View.VISIBLE
            mImageVideoCurtain?.background = mCurtainDrawable
            playBootVideo()
            return
        }
        mVideoView?.visibility = View.GONE
        mImageVideoCurtain?.visibility = View.GONE
        initData()
    }

    /** Toca o vídeo de boot (VOD) com listeners de info/erro/fim. Original: Y0(), Z0(), a1(), b1(), c1() */
    private fun playBootVideo() {
        val handler = mVideoView?.videoViewHandler ?: return
        handler.setOnInfoListener { _, _, _, _ ->
            if (mImageVideoCurtain?.visibility == View.GONE) return@setOnInfoListener true
            mHandler.postDelayed({
                if (mImageVideoCurtain?.visibility != View.GONE) {
                    mImageVideoCurtain?.visibility = View.GONE
                    mVersion?.visibility = View.VISIBLE
                    mVersion?.text = String.format("%s %s", getText(R.string.version), AppInfo.versionName())
                }
            }, 200L)
            true
        }
        handler.setOnErrorListener { _, _, _ -> hideBootVideo(true); mImageVideoCurtain?.visibility = View.GONE; true }
        handler.setOnCompletionListener {
            hideBootVideo(true)
            SkinConfig.get().bootEndDrawable()?.let { d -> mRoot?.background = d }
        }
        handler.play("", mBootVideoUri, null, BaseLibConfig.StreamType.VOD, DateUtils.now())
        mVideoView?.requestFocus()
        handler.start()
    }

    /** Original: L1(boolean) / M1() */
    private fun hideBootVideo(hideVideoView: Boolean) = mHandler.post {
        mVideoView?.videoViewHandler?.takeIf { it.isPlaying() }?.release(true)
        if (hideVideoView) {
            mVersion?.visibility = View.GONE
            mVideoView?.visibility = View.GONE
            mImageVideoCurtain?.visibility = View.GONE
        }
    }

    /** Pausa/para o vídeo de boot se tocando. Original: T0() */
    private fun stopBootVideo() {
        mVideoView?.videoViewHandler?.takeIf { it.isPlaying() }?.stop()
    }

    /**
     * Início da sequência. Com startType==1 (vindo de LiveNewActivity após logout) mostra o login diretamente
     * com a mensagem recebida. Original: C1()
     */
    fun startLoad() {
        LoadingTimer.mark("liveLoadStartLoad")
        val type = intent.getIntExtra("startType", 0)
        val message = intent.getStringExtra("message")
        KeyboardUtils.hide()
        if (type != 1) {
            mHandler.sendEmptyMessage(MSG_WAIT_APP_READY)
            return
        }
        intent.removeExtra("startType")
        intent.removeExtra("message")
        showLogin(message ?: "", false, 0)
    }

    /** Original: n1() — permissão de armazenamento (PermissionUtils.STORAGE). */
    private fun requestPermissions() {
        if (PermissionUtils.has(this, PermissionUtils.STORAGE)) {
            LoadingTimer.set("hasPermission", 1L)
            mHandler.sendEmptyMessage(MSG_INIT_RUNTIME_ENV)
        } else {
            LoadingTimer.set("hasPermission", 0L)
            PermissionUtils.request(this, PermissionUtils.STORAGE, 0)
        }
    }

    /**
     * Corrotina `LiveLoadActivity$d`: lê channelId do intent (deep-link), libera checkpoint de boot 4,
     * limpa diretórios e testa a rede (mostra NetworkStatusDialogFragment se falhar).
     * Original: X0() / d.invokeSuspend()
     */
    private fun initRuntimeEnv() = GlobalScope.launch(Dispatchers.IO) {
        com.foxivid.baselib.metric.NetworkMonitor.get()?.refresh()           // zf.f.e().u()
        val extraChannelId = getIntentChannelId()
        intent.removeExtra("channelId")
        logger.info("extraChannelId = $extraChannelId")
        AsyncExecutor.execute { BootManager.release(4) }
        AppDirs.cleanup()
        if (com.foxivid.baselib.metric.NetworkMonitor.get()?.isConnected() == true) {
            LoadingTimer.set("showNetworkDlg", 0L)
            mHandler.sendEmptyMessage(MSG_NETWORK_OK)
        } else {
            SerialExecutor.post {
                LoadingTimer.set("showNetworkDlg", 1L)
                NetworkStatusDialogFragment.show(this@LiveLoadActivity, mNetworkTester) { ok ->
                    if (ok) mHandler.sendEmptyMessage(MSG_NETWORK_OK)
                    else showError(CommonUtils.string(R.string.network_not_connect))
                }
            }
        }
    }

    /**
     * Verifica atualização (fluxo do SDK com callback de progresso de download).
     * Se não silencioso: toast "nova versão", progresso no loading, ao terminar mostra prompt de instalação.
     * Original: M0(boolean) + LiveLoadActivity$b (checkUpdate$1)
     */
    fun checkUpdate(silenced: Boolean = false) {
        if (!isInChecking.compareAndSet(false, true)) return
        showLoading(R.string.checking)
        CoroutineScope(Dispatchers.IO).launch {
            InteractionUtils.checkUpgrade(lifecycle) { version: String?, progress: Int?, apkPath: String?, error: com.foxivid.baselib.upgrade.UpgradeError? ->
                mHandler.post { onUpgradeProgress(silenced, version, progress, apkPath, error) }
            }.catch { t ->
                launch(Dispatchers.Main) { ToastHelper.show(getString(R.string.check_failed) + ":" + t.message) }
                logger.error("check upgrade failure", t)
            }.collect { info ->
                upgradeInfo = info
                isInChecking.set(false)
                if (isDestroyed) return@collect
                if (!silenced) {
                    if (info == null) welcomeOrLogin() else showDataText(upgradeInfo?.versionName ?: "")
                }
            }
        }
    }

    /** Original: LiveLoadActivity$b$a.run() */
    private fun onUpgradeProgress(silenced: Boolean, version: String?, progress: Int?, apkPath: String?, error: com.foxivid.baselib.upgrade.UpgradeError?) {
        if (isDestroyed) {
            val info = upgradeInfo
            if (info != null && !apkPath.isNullOrEmpty()) org.greenrobot.eventbus.EventBus.getDefault().postSticky(com.live.evo.event.UpgradeReadyEvent(info, apkPath))
            return
        }
        if (lastVersion != version && !version.isNullOrEmpty()) {
            lastVersion = version
            if (!silenced) ToastHelper.show(String.format("%s:%s", getString(R.string.new_version), version))
        }
        val changed = progress == null || lastProgress != progress
        if (progress != null && changed) {
            if (BuildConfig.IS_DEBUG) logger.debug("upgrade download $progress $lastProgress $changed%")
            lastProgress = progress
            if (!silenced) setLoadingText("${upgradeInfo?.versionName} " + getString(R.string.downloading, progress.toString()))
        }
        if (!apkPath.isNullOrEmpty()) {
            if (BuildConfig.IS_DEBUG) logger.debug("upgrade ready $apkPath")
            apkFile = apkPath
            if (!silenced) { setLoadingText(getString(R.string.new_version_ready)); showInstallPrompt() }
        }
        if (error != null && !silenced) ToastHelper.show(error.errMsg)
        isInChecking.set(false)
    }

    /** Mostra o diálogo de instalação; "sair" encerra o app. Original: e1() / f1() / e */
    private fun showInstallPrompt() {
        val path = apkFile
        val info = upgradeInfo ?: return
        runOnUiThread {
            UpgradeInstaller.prompt(this, path, info, object : UpgradePromptDialog.Listener() {
                override fun onExit() = exitApp()
            })
        }
    }

    /**
     * Decide entre login manual e automático. Original: l1()
     * - Se o SDK indica logout forçado (`o0()`): motivo 2 = versão não suportada → compara a versão salva
     *   em [KEY_TIP_NOT_SUPPORT_VERSION] e, na primeira vez, mostra diálogo "Check Update"/"Exit";
     *   outro motivo → tela de login.
     * - Caso contrário → [welcomeOrLogin].
     */
    private fun queryLogin() {
        KeyboardUtils.hide()
        initSplashAdCache()
        if (InteractionUtils.isForcedLogout()) {
            if (InteractionUtils.forcedLogoutReason() == 2) {
                val current = AppInfo.versionName()
                KvStore.get(KEY_TIP_NOT_SUPPORT_VERSION, KvStore.Callback<String> { saved ->
                    runOnUiThread { onUnsupportedVersion(saved, current) }
                }, "")
            } else {
                showLogin("", false, 0)
            }
            return
        }
        welcomeOrLogin()
    }

    /** Original: LiveLoadActivity$h.f() */
    private fun onUnsupportedVersion(saved: String, current: String) {
        if (saved.isNotEmpty() && saved != current) { welcomeOrLogin(); return }
        if (saved.isEmpty()) KvStore.put(KEY_TIP_NOT_SUPPORT_VERSION, current)
        val msg = getString(R.string.force_logout_not_support_version, InteractionUtils.minSupportedVersion())
        ConfirmDialog.show(this, msg, getString(R.string.check_update), getString(R.string.exit),
            { if (apkFile.isNotEmpty()) showInstallPrompt() else checkUpdate(false) },
            { exitApp() })
    }

    /**
     * Original: K1() — aviso adulto (se habilitado em AppUserManager), boas-vindas (primeira execução e
     * modo 1) ou login automático.
     */
    private fun welcomeOrLogin() {
        if (AppUserManager.get().needAdultWarning()) { mHandler.sendEmptyMessage(MSG_ADULT_WARNING); return }
        if (AppUserManager.get().welcomeMode() == 1 && PlaybackPrefs.isFirstLaunch(this)) {
            LoadingTimer.set("showWelcomeDlg", 1L)
            mHandler.sendEmptyMessage(MSG_SHOW_WELCOME)
        } else {
            LoadingTimer.set("showWelcomeDlg", 0L)
            mHandler.sendEmptyMessage(MSG_LOGIN)
        }
    }

    /** Original: V1() / W1() */
    private fun showWelcome() {
        hideBootVideo(true)
        WelcomeFragment.show(fragmentManager(), R.id.root) {
            loadingView?.hide()
            PlaybackPrefs.setFirstLaunch(this, false)
            mHandler.sendEmptyMessage(MSG_LOGIN)
        }
    }

    /** Original: N1() + LiveLoadActivity$k */
    private fun showAdultWarning() {
        AdultWarningFragment.show(fragmentManager(), R.id.root, object : AdultWarningFragment.Listener {
            override fun onExit() { hideFragment(null); exitApp() }
            override fun next() { hideFragment(null); mHandler.sendEmptyMessage(MSG_LOGIN) }
        })
    }

    /**
     * Login automático com a sessão/dispositivo (fluxo `x0()` do SDK, Triple<ok, código, msg>).
     * ok → MSG_REMIND; código -3 (rede) → diálogo de rede e nova tentativa; outros → tela de login.
     * Original: E1() + LiveLoadActivity$i
     */
    private fun login() = CoroutineScope(Dispatchers.IO).launch {
        withContext(Dispatchers.Main) { showLoading(R.string.login) }
        InteractionUtils.loginFlow().flowOn(Dispatchers.IO)
            .catch { t ->
                logger.error("loginFlow error", t)
                showError(t.message ?: getString(R.string.unknown_error_code))
            }
            .collect { (ok, code, _) ->
                if (ok) {
                    withContext(Dispatchers.Main) { mHandler.sendEmptyMessage(MSG_REMIND) }
                } else if (code != -3) {
                    onLoginFailed(InteractionUtils.renewCode())
                    logger.error("loginFlow error:{}", Triple(ok, code, null))
                } else {
                    NetworkStatusDialogFragment.show(this@LiveLoadActivity, mNetworkTester) { netOk ->
                        if (netOk) { logger.info("network is resume try login again"); mHandler.sendEmptyMessage(MSG_LOGIN) }
                        else showErrorRes(R.string.network_not_connect)
                    }
                }
            }
    }

    /** Original: k1(String) — ignora o nome e mostra o login. */
    private fun onLoginFailed(@Suppress("UNUSED_PARAMETER") username: String) = showLogin("", false, 0)

    /**
     * Calcula o tipo de lembrete de expiração e mostra [com.live.evo.fragment.login.RechargeRemindFragment].
     * Tipos: -1 nenhum (segue), 1 expirado/expira em N horas, 10 expirado sem renew code, 5 → cadastro/recarga.
     * Original: I1() + LiveLoadActivity$j
     */
    private fun showExpiryRemind() {
        InteractionUtils.refreshAccountInfo()                         // U()
        val expiry = InteractionUtils.expiryTimeMillis()              // I()
        val now = ServerClock.get().now()
        PlaybackPrefs.lastRechargeRemindTime(this)
        DateUtils.resetCache()                                        // q1.h()
        var type = if (InteractionUtils.isExpired()) { if (InteractionUtils.renewCode().isEmpty()) 10 else 1 } else -1
        var text = ""
        if (type == -1 && InteractionUtils.isNearExpiry()) {
            val hours = DateUtils.hoursBetween(now, expiry)
            text = "$hours " + CommonUtils.string(if (hours <= 1) R.string.hour else R.string.hours)
            type = 1
        }
        LoadingTimer.set("remindType", type.toLong())
        when (type) {
            -1 -> mHandler.sendEmptyMessage(MSG_FIX_DST)
            5 -> showRegister(null, false, 0)
            else -> LoginNavigator.showRechargeRemind(fragmentManager(), window, R.id.root, type, text, 30,
                object : LoginNavigator.RechargeRemindCallback {
                    override fun onSkip(f: Fragment) { hideFragment(f); mHandler.sendEmptyMessage(MSG_FIX_DST) }
                    override fun onRechargeNow(f: Fragment) = showScanRecharge(f)
                    override fun onLogin(f: Fragment, showTab: Int) {
                        fragmentManager().beginTransaction().hide(f).commitAllowingStateLoss()
                        showLogin("", true, showTab, f)
                    }
                })
        }
    }

    /** Original: A1() */
    private fun onActivated() = mHandler.sendEmptyMessage(MSG_FIX_DST)

    /**
     * Ajuste de fuso horário (TimeZoneHelper): pode pedir confirmação ao usuário antes de prosseguir.
     * Original: y1() / z1()
     */
    private fun fixDstThenLoad() {
        val (applySilently, askUser) = TimeZoneHelper.get().check()
        if (askUser) { TimeZoneHelper.get().askAndApply(this) { loadChannels() }; return }
        if (applySilently) TimeZoneHelper.get().apply(this)
        loadChannels()
    }

    /** Original: D1() — pré-carrega EPG, subjects (esportes), anúncios e inicia o live. */
    private fun loadChannels() {
        LoadingTimer.mark("liveLoadLoadChannel")
        prepareStartLive()
        com.live.evo.ad.AdConfig.get()?.takeIf { it.isEnabled() }?.refresh()     // v4.g.e()
        SubjectDataHelper.get().refresh()
        SplashAdRepository.get().preload()
        AdManager.preload()
    }

    /** Original: B1() — marca "start_live"=2 nas prefs "load_startLive". */
    private fun prepareStartLive() {
        LoadingTimer.mark("liveLoadStartLive")
        EpgRepository.prefetch()
        getSharedPreferences(PREFS_START_LIVE, 0)?.edit()?.putInt(KEY_START_LIVE, 2)?.apply()
        startLive()
    }

    /**
     * Abre [LiveNewActivity] assim que houver canais (senão tenta de novo a cada 1 s) e finaliza 1 s depois.
     * Original: F1() / G1() / H1()
     */
    private fun startLive() = runOnUiThread {
        if (InteractionUtils.getChannels().isEmpty()) {
            mHandler.sendEmptyMessageDelayed(MSG_START_LIVE, 1000L)
            return@runOnUiThread
        }
        mHasStartLive = true
        startActivity(Intent(this, LiveNewActivity::class.java))
        mHandler.postDelayed({ finish() }, 1000L)
    }

    /**
     * Mostra [com.live.evo.fragment.login.AccountUserLoginFragment] (via LoginNavigator) com callbacks:
     * a = voltar, b = login ok → ativar, c = renew code → RenewCodeLoginSupport (tipo 40),
     * d = cadastro (com recarga, tipo 2), e = reset de senha.
     * Original: P1()/Q1() + LiveLoadActivity$m
     */
    fun showLogin(errorMessage: String, showBack: Boolean, showTab: Int, originView: Fragment? = null) {
        LoadingTimer.mark("liveLoadShowLogin")
        hideBootVideo(true)
        stopBootVideo()
        LoginNavigator.showAccountLogin(fragmentManager(), window, R.id.root, showBack, errorMessage, showTab,
            object : LoginNavigator.AccountLoginCallback {
                override fun onBack(f: Fragment) {
                    fragmentManager().beginTransaction().hide(f).commitAllowingStateLoss()
                    if (originView != null) fragmentManager().beginTransaction().show(originView).commitAllowingStateLoss()
                }
                override fun onLoginSuccess(f: Fragment) {
                    showDataText(CommonUtils.string(R.string.loading_data)); hideFragment(f); mHandler.sendEmptyMessage(MSG_ACTIVATE)
                }
                override fun onRenewCodeLogin(f: Fragment) {
                    mFm?.beginTransaction()?.hide(f)?.commitAllowingStateLoss()
                    showRenewCodeLogin(40, InteractionUtils.renewCodeForBind())
                }
                override fun onRegister(f: Fragment) = showRegister(f, true, 2)
                override fun onResetPassword(f: Fragment, account: AccountBean) = showResetPassword(f, account)
            })
    }

    /**
     * Tela de recarga escaneada (QR). Ao concluir mostra LoginFinishFragment (tipo 9 sem renew code, 0 com).
     * Original: R1() + LiveLoadActivity$n
     */
    private fun showScanRecharge(fragment: Fragment) {
        mFm?.beginTransaction()?.hide(fragment)?.commitAllowingStateLoss()
        LoginNavigator.showScanedRecharge(fragmentManager(), window, R.id.root, object : LoginNavigator.FragmentNavigator {
            override fun back(f: Fragment) {
                val remind = fragmentManager().findFragmentByTag("RechargeRemindFragment")
                fragmentManager().beginTransaction().hide(f).commitAllowingStateLoss()
                if (remind == null) showLogin("", false, 0)
                else fragmentManager().beginTransaction().show(remind).commitAllowingStateLoss()
            }
            override fun next(f: Fragment) {
                mFm?.beginTransaction()?.hide(f)?.commitAllowingStateLoss()
                LoginFinishFragment.show(fragmentManager(), R.id.root, if (InteractionUtils.renewCode().isEmpty()) 9 else 0) {
                    hideFragment(it); mHandler.sendEmptyMessage(MSG_FIX_DST)
                }
            }
        })
    }

    /**
     * Login por renew code (tipo 40/42). Tipo 42 com propriedade `user_properties/code_bind_remind_status`=="1"
     * pula direto para ativação. Original: T1() + LiveLoadActivity$p
     */
    private fun showRenewCodeLogin(type: Int, code: String) {
        LoadingTimer.mark("liveLoadToRechargeFragment")
        hideBootVideo(true)
        stopBootVideo()
        if (type == 42) {
            val props = AppPropertiesStore.get("user_properties", "code_bind_remind_status")
            if (props.isNotEmpty() && props[0].value == "1") {
                mHandler.sendEmptyMessage(MSG_ACTIVATE)
                showDataText(CommonUtils.string(R.string.loading_data))
                hideFragment(null)
                return
            }
        }
        RenewCodeLoginSupportFragment.show(fragmentManager(), R.id.root, code, type, object : RenewCodeLoginSupportFragment.Listener {
            override fun exit(f: Fragment) { mFm?.beginTransaction()?.hide(f)?.commitAllowingStateLoss(); showLogin("", false, 3) }
            override fun rechargeLater(f: Fragment) {
                RechargeDialogFragment.show(mFm, 25, object : OsdControlListener {
                    override fun c() { showDataText(CommonUtils.string(R.string.loading_data)); hideFragment(f); mHandler.sendEmptyMessage(MSG_ACTIVATE) }
                    override fun e() = c()
                    override fun a() {}
                    override fun b() {}
                })
            }
            override fun loginSuccess(f: Fragment) { showDataText(CommonUtils.string(R.string.loading_data)); hideFragment(f); mHandler.sendEmptyMessage(MSG_ACTIVATE) }
        })
    }

    /**
     * Cadastro por e-mail/telefone ([com.live.evo.fragment.login.RegisterEmailFragment]).
     * Sucesso → LoginFinishFragment tipo 10 (sem trial ou já usado), 7 (com recarga) ou 3.
     * Original: S1() + LiveLoadActivity$o
     */
    private fun showRegister(fragment: Fragment?, toRecharge: Boolean, registerType: Int) {
        stopBootVideo()
        if (fragment != null) mFm?.beginTransaction()?.hide(fragment)?.commitAllowingStateLoss()
        LoginNavigator.showRegister(fragmentManager(), window, R.id.root, registerType, false, false, null, object : LoginNavigator.FragmentNavigator {
            override fun back(f: Fragment) {
                if (fragment == null) { showLogin("", false, 0); return }
                mFm?.beginTransaction()?.hide(f)?.show(fragment)?.commitAllowingStateLoss()
            }
            override fun next(f: Fragment) {
                mFm?.beginTransaction()?.hide(f)?.commitAllowingStateLoss()
                when {
                    !InteractionUtils.hasFreeTrial() || InteractionUtils.isTrialUsed() -> showLoginFinish(10)
                    toRecharge -> showLoginFinish(7)
                    else -> showLoginFinish(3)
                }
            }
        })
    }

    /** Reset de senha; sucesso → LoginFinishFragment tipo 6. Original: U1() + LiveLoadActivity$q */
    private fun showResetPassword(fragment: Fragment?, account: AccountBean) {
        if (fragment != null) mFm?.beginTransaction()?.hide(fragment)?.commitAllowingStateLoss()
        LoginNavigator.showResetPassword(fragmentManager(), window, R.id.root, account, false, object : LoginNavigator.FragmentNavigator {
            override fun back(f: Fragment) {
                if (fragment == null) { showLogin("", false, 0); return }
                mFm?.beginTransaction()?.hide(f)?.show(fragment)?.commitAllowingStateLoss()
            }
            override fun next(f: Fragment) { mFm?.beginTransaction()?.hide(f)?.commitAllowingStateLoss(); showLoginFinish(6) }
        })
    }

    /** Original: O1(int) + LiveLoadActivity$l — "Watch now" → ativação. */
    private fun showLoginFinish(remindType: Int) =
        LoginFinishFragment.show(fragmentManager(), R.id.root, remindType) { hideFragment(it); mHandler.sendEmptyMessage(MSG_ACTIVATE) }

    /**
     * Corrotina `LiveLoadActivity$c` (initData): cria o testador de rede, o ExitDialog e guarda o FragmentManager;
     * em seguida envia `620908586` (MSG_FIX_DST), exatamente como no original. A ordem relativa a
     * MSG_WAIT_APP_READY/MSG_QUERY_LOGIN depende do onCreate nativo e não pôde ser confirmada.
     * Original: W0() / c.invokeSuspend()
     */
    private fun initData() = GlobalScope.launch(Dispatchers.Main) {
        if (isFinishing || isDestroyed || isOnSavedState) return@launch
        try {
            LoadingTimer.mark("liveLoadInitData")
            mNetworkTester = NetworkStatusDialogFragment.createTester(this@LiveLoadActivity)
            mExitDialog = ExitDialog(this@LiveLoadActivity)
            val fm = supportFragmentManager
            if (!fm.isDestroyed) mFm = fm
            mHandler.sendEmptyMessage(MSG_FIX_DST)
        } catch (t: Throwable) {
            logger.error("init failure", t)
        }
    }

    /** Original: x1()/R0() */
    private fun startCoreProcess() { LoadingTimer.mark("liveLoadStartCoreProcess"); mHandler.sendEmptyMessage(MSG_QUERY_LOGIN) }

    /** Original: J1() — corpo vazio. */
    private fun onMsg574() {}

    /** Original: U0() — inicializa cache de anúncios (v4.g.g(context)). */
    private fun initSplashAdCache() = com.live.evo.ad.AdConfig.init(applicationContext)

    /** FragmentManager atual (esconde o loading). Original: K0() */
    fun fragmentManager(): FragmentManager { loadingView?.hide(); return mFm ?: supportFragmentManager }

    /** Esconde o fragment anterior e o loading. Original: o1(Fragment) */
    private fun hideFragment(prev: Fragment?) {
        val tx = mFm?.beginTransaction() ?: return
        if (prev != null) tx.hide(prev)
        loadingView?.hide()
        tx.commitAllowingStateLoss()
    }

    /** Original: p1(int) */
    private fun showLoading(resId: Int) = showDataText(getString(resId))

    /** Original: q1(String) — texto vazio vira "Loading". */
    private fun showDataText(text: String) {
        loadingView?.setText(text.ifEmpty { getString(R.string.loading) })
        loadingView?.show()
    }

    /** Original: X1(String) */
    private fun setLoadingText(text: String) { if (text.isNotEmpty()) loadingView?.setText(text) }

    /** Original: s1(String)/u1()/v1()/j1() — mostra erro, esconde vídeo e tenta prompt de instalação. */
    private fun showError(message: String?) {
        LoadingTimer.error(-1, message)
        runOnUiThread { if (message != null) showDataText(message); hideBootVideo(true) }
        runOnUiThread { showInstallPrompt() }
    }

    /** Original: r1(int)/t1() */
    private fun showErrorRes(resId: Int) = runOnUiThread { showError(MyApplication.get().getString(resId)) }

    /** Encerra o processo após 500 ms. Original: O0()/P0() */
    private fun exitApp() = mHandler.postDelayed({ finish(); System.exit(0) }, 500L)

    /**
     * channelId vindo por extra ou por deep-link `livetvcontent://...?channelId=` (Android TV home channels).
     * Original: Q0()
     */
    private fun getIntentChannelId(): String? {
        val stringExtra = intent.getStringExtra("channelId")
        logger.info("getIntentChannelId channelid=$stringExtra")
        logger.info("getIntentChannelId action=${intent.action}")
        if (intent.scheme == "livetvcontent") intent.data?.let { return it.getQueryParameter("channelId") }
        return stringExtra
    }

    /** Back: fragments de login consomem primeiro; senão ExitDialog. Original: onBackPressed() */
    override fun onBackPressed() {
        val fm = mFm ?: return
        if (LoginNavigator.dispatchBackPressed(fm)) return
        val dlg = mExitDialog ?: return
        if (dlg.isShowing()) dlg.dismiss() else { dlg.setOnExitListener { exitApp() }; dlg.show() }
    }

    /** Falha ao carregar canais: diálogo "Retry" (recarrega via SDK) / "Exit". Original: onChannelUpdateEvent(nf.d) */
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onChannelUpdateEvent(event: ChannelUpdateEvent?) {
        if (event == null || event.isSuccess) return
        ConfirmDialog.show(this, getString(R.string.load_fail) + ":\n" + event.message + "(" + event.code + ")",
            getString(R.string.retry), getString(R.string.exit),
            { InteractionUtils.reloadChannels(false, true) },   // u0(false, true)
            { finish() })
    }

    /** Aviso do servidor. Original: onNotice(i5.x) → L0() (apenas cria o NoticeAlertDialog). */
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onNotice(noticeItem: NoticeEvent) { if (noticeAlertDialog == null) noticeAlertDialog = NoticeAlertDialog(this) }

    /** DPAD_RIGHT no vídeo/anúncio pula o anúncio, se permitido. Original: onKey() */
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        if (CommonUtils.isFastClick(300L)) return true
        if ((v.id != R.id.loada_video_view && v.id != R.id.loada_iv_ad) || event.action != KeyEvent.ACTION_DOWN ||
            keyCode != KeyEvent.KEYCODE_DPAD_RIGHT || !SplashAdRepository.get().hasAd() || adNewViewManager == null ||
            !SplashAdRepository.get().canSkip()) return false
        adNewViewManager?.skip()
        return true
    }

    override fun onDestroy() {
        mHandler.removeCallbacksAndMessages(null)
        releaseResources()
        SplashAdRepository.get().release()
        super.onDestroy()
    }

    /** Original: m1() — corpo vazio. */
    private fun releaseResources() {}

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mFm = supportFragmentManager
        isOnSavedState = false
    }

    override fun onSaveInstanceState(outState: Bundle) { super.onSaveInstanceState(outState); isOnSavedState = true }

    /** Marca start_live=1 se o live ainda não foi iniciado. Original: onStop() */
    override fun onStop() {
        noticeAlertDialog?.takeIf { it.isShowing() }?.dismiss()
        getSharedPreferences(PREFS_START_LIVE, 0)?.let { sp ->
            if (sp.getInt(KEY_START_LIVE, 0) != 2) sp.edit().putInt(KEY_START_LIVE, 1).apply()
        }
        super.onStop()
    }

    override fun onPause() { super.onPause(); EventBusHelper.unregister(this) }
    override fun onResume() { super.onResume(); EventBusHelper.register(this) }

    companion object {
        const val TAG = "LiveLoadActivity"
        const val PREFS_START_LIVE = "load_startLive"
        const val KEY_START_LIVE = "start_live"
        const val KEY_UPGRADE_CHECK_STATE = "upgrade_check_state"
        const val KEY_TIP_NOT_SUPPORT_VERSION = "tip_not_support_version"

        // Mensagens do Handler (valores reais).
        const val MSG_NETWORK_OK = 620908546
        const val MSG_ACTIVATE = 620908561
        const val MSG_REMIND = 620908570
        const val MSG_574 = 620908574
        const val MSG_WAIT_APP_READY = 620908577
        const val MSG_INIT_RUNTIME_ENV = 620908582
        const val MSG_QUERY_LOGIN = 620908583
        const val MSG_LOGIN = 620908584
        const val MSG_FIX_DST = 620908586
        const val MSG_SHOW_WELCOME = 620908588
        const val MSG_ADULT_WARNING = 620908589
        const val MSG_INIT_DATA = 620908590
        const val MSG_RESET_BACK = 620908591
        const val MSG_START_CORE = 620908593
        const val MSG_SHOW_AD_OR_VIDEO = 620908597
        const val MSG_START_LIVE = 620908602
    }
}
