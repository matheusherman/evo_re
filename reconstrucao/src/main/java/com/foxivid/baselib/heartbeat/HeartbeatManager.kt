package com.foxivid.baselib.heartbeat

import com.foxivid.baselib.media.EpgManager
import com.foxivid.baselib.media.ChannelManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.text.TextUtils
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import com.foxivid.baselib.api.PTVApi3AClient
import com.foxivid.baselib.bot.TelegramBot
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.device.DeviceInfoCollector
import com.foxivid.baselib.marquee.MarqueeManager
import com.foxivid.baselib.media.SportsRepository
import com.foxivid.baselib.metric.MetricReporter
import com.foxivid.baselib.metric.monitor.NetworkMonitor
import com.foxivid.baselib.metric.monitor.ZappingMonitor
import com.foxivid.baselib.metric.monitor.UpgradeMonitor
import com.foxivid.baselib.model.extra.upgrade.UpgradeInfo
import com.foxivid.baselib.upgrade.ApkInstaller
import com.foxivid.baselib.user.UserManager
import com.foxivid.baselib.util.AppAttrUtils
import com.foxivid.baselib.util.Clock
import com.foxivid.baselib.util.FileDownloader
import com.foxivid.baselib.util.StoragePaths
import com.foxivid.baselib.util.Toasts
import com.foxivid.baselib.util.Logger
import com.foxivid.baselib.util.LoggerFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import java.io.File
import java.util.Timer
import java.util.TimerTask
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicBoolean
import x.l1.b2.R

/**
 * Heartbeat periódico do SDK + gerenciador de upgrade + depósito das "propriedades remotas".
 *
 * Original: x1/f1/lb/heartbeat/f.java (nome Kotlin original: `HeartbeatUpgradeManager.kt`, visto nos
 * `@DebugMetadata` das corrotinas).
 *
 * Funcionamento:
 * - No `static {}` cria `Timer("heartbeat", daemon=true)` que roda [tick] a cada 5 s (DEFAULT_TIMEOUT
 *   do androidx = 5000 ms) com atraso inicial de 5 s. Se o Timer não puder ser criado, cai num loop
 *   infinito `tick(); sleep(5000)` num executor (`f.f()`).
 * - [tick] só faz algo depois de [start] (flag `isRun`). Cada tick: atualiza marquee, reporta métrica
 *   de startup atrasada, assina canais, recarrega lista de canais, EPG e esportes; e, conforme
 *   intervalos configuráveis, checa upgrade, envia heartbeat de métricas e faz o "heartbeat" de
 *   login (auto login / refresh de token).
 * - [applyProperties] recebe o map de parâmetros do servidor e despacha para os handlers de
 *   [AppPropertyHandlers] (ver tabela completa lá e em `docs/propriedades_remotas.md`).
 * - Upgrade: consulta `/api/v1/upgrade/config` (PTVApi3AClient.o), baixa o APK ("upgrade.apk"),
 *   verifica checksum/md5/sha e meta-dados (canal/tipo de app) e entrega o caminho via callback
 *   ou evento EventBus para a UI pedir instalação ([requestInstall]).
 */
object HeartbeatManager {

    /** Original: f.logger (q6.b) */
    internal val logger: Logger = LoggerFactory.getLogger(HeartbeatManager::class.java)

    // ---------------------------------------------------------------- propriedades (valores default reais)
    /** Original: f.c */ var autoLoginBeforeTokenExpired: Long = 300000; internal set
    /** Original: f.d (12 h) */ var autoRefreshAccessTokenInterval: Long = 43200000; internal set
    /** Original: f.e (2 min) */ internal var heartbeatInterval: Long = 120000
    /** Original: f.f (2 h) */ internal var upgradeCheckingInterval: Long = 7200000
    /** Original: f.g (2 min) */ internal var metricHeartbeatInterval: Long = 120000
    /** Original: f.h — tempo do modo eco (nome original "echoModeTime"), 2 h */ var echoModeTime: Long = 7200000; internal set
    /** Original: f.i */ var customerServiceEmail = ""; internal set
    /** Original: f.j */ var customerServiceQrCodeImg = ""; internal set
    /** Original: f.k */ var mobileAppQrCodeImg = ""; internal set
    /** Original: f.l */ var customerServiceGroupWhatsappLink = ""; internal set
    /** Original: f.m */ var customerServiceFacebook = ""; internal set
    /** Original: f.n */ var customerServiceWhatsapp = ""; internal set
    /** Original: f.o */ internal var customerServiceTelegram = ""
    /** Original: f.p */ internal var reLoginMaxCntAfterExpired = -1
    /** Original: f.q */ internal var how2order = ""
    /** Original: f.r — se true, métricas são logadas em nível info (vão para o RemoteLogger) */ var isReportClientDetail = false; internal set
    /** Original: f.s (FileWatchdog.DEFAULT_DELAY = 60000) */ var loginRetryIntervalMs: Long = 60000; internal set
    /** Original: f.t */ var promotionTrialDays = 7; internal set
    /** Original: f.u (3 dias) */ var promptRenewMillis: Long = 259200000; internal set
    /** Original: f.v */ internal var limitContinuingRenewDays: Int? = null
    /** Original: f.w */ var qrcodeRefreshIntervalSeconds = 15; internal set
    /** Original: f.x (30 min) */ var metaUpdateMinIntervalMs: Long = 1800000; internal set
    /** Original: f.G */ internal var emailBeBlockedHosts = HashSet<String>()
    /** Original: f.H */ internal var blockEmailHostTip = ""
    /** Original: f.I */ internal var startUpCountNum = 6
    /** Original: f.J */ var guestTrialEndTipText = ""; internal set
    /** Original: f.K */ var guestTrialEndImgUrl = ""; internal set
    /** Original: f.L */ var memberTrialEndTipText = ""; internal set
    /** Original: f.M */ var memberTrialEndImgUrl = ""; internal set
    /** Original: f.N */ internal var isShowRegisterFistForNewUser = false
    /** Original: f.O */ var subtitleDftLang = "PT"; internal set
    /** Original: f.P */ var subtitleLanguageList: List<String> = listOf("EN", "PT"); internal set
    /** Original: f.R */ internal var isFree: Boolean? = null
    /** Original: f.S */ internal var planHtml = ""
    /** Original: f.T — segundos de captura de logcat no feedback silencioso */ internal var feedbackLogcatExecuteDuration = 3
    /** Original: f.Y (3 dias) */ var expireRemindSeconds = 259200
    /** Original: f.Z */ var dailyRemindTimes = 10

    // ---------------------------------------------------------------- estado interno
    /** Original: f.y "puckScope" = CoroutineScope(SupervisorJob() + Dispatchers.IO) */
    private val puckScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    /** Original: f.z */
    private val propertiesHandlers = ConcurrentHashMap<String, ValueCallback<String>>()
    /** Original: f.A */ private var isRun = false
    /** Original: f.B */ private var activityResult: ActivityResultLauncher<Intent>? = null
    /** Original: f.C */ private var activityAction: Runnable? = null
    /** Original: f.D/E/F */
    private var lastUpgradeCheckTime = Clock.elapsed()
    private var lastHeartbeatTime = Clock.elapsed()
    private var lastMetricHeartbeatTime = Clock.elapsed()
    /** Original: f.Q */ private var lastUpgradeData: UpgradeInfo? = null
    /** Original: f.U */ private var timer: Timer? = null
    /** Original: f.V */ private val initCountDownLatch = CountDownLatch(1)
    /** Original: f.a0 */ private val isOnUpgrade = AtomicBoolean(false)
    /** Original: f.c0 — callback (versionName, progress, apkPath, failEvent) */
    private var mOnProgress: ((String, Int, String?, UpgradeFailureEvent?) -> Unit)? = null
    /** Original: f.d0 */ private var mLifecycle: Lifecycle? = null

    /**
     * Original: f$y1 — assina/atualiza canais (MediaRepository.q(10000)) evitando execuções paralelas.
     */
    private val subscribeExecRunnable = object : Runnable {
        private val isInRunning = AtomicBoolean(false)
        override fun run() {
            if (!isInRunning.compareAndSet(false, true)) {
                logger.warn("execute subscribe is in running, ignored")
                return
            }
            try {
                CoroutineScope(Dispatchers.IO).launch { ChannelManager.executeSubscribe(10000L) }
            } catch (t: Throwable) {
                logger.error("execute subscribe in heartbeat failure", t)
            } finally {
                isInRunning.set(false)
            }
        }
    }

    /** Original: f.b0 / lambda f.O0() — dispara a checagem de upgrade em background. */
    private val upgradeAction = Runnable { puckScope.launch { upgradeCheck(Clock.elapsed()) } }

    init {
        AppPropertyHandlers.register(propertiesHandlers)
        try {
            val t = try { Timer("heartbeat", true) } catch (e: Throwable) {
                try { Timer() } catch (e2: Throwable) { logger.error("init timer failure", e2); null }
            }
            if (t != null) {
                timer = t
                // Original: f$o1 (TimerTask) — delay e período = 5000 ms
                t.schedule(object : TimerTask() {
                    override fun run() {
                        try { tick() } catch (th: Throwable) { logger.error("heartbeat failure", th) }
                    }
                }, 5000, 5000)
            } else {
                // Original: f.f() — loop infinito
                com.foxivid.baselib.util.Executors.default.execute {
                    while (true) {
                        try { tick(); Thread.sleep(5000) } catch (th: Throwable) { logger.error("heartbeat failure", th) }
                    }
                }
            }
        } catch (th: Throwable) {
            logger.warn("heartbeat failure", th)
        }
        initCountDownLatch.countDown()
    }

    /** Original: f.y0(now, last, interval) — também dispara se o relógio voltou (delta < 0). */
    private fun isExpired(now: Long, lastTime: Long, interval: Long): Boolean {
        val d = now - lastTime
        return d < 0 || d > interval
    }

    /**
     * Um tick do heartbeat (a cada 5 s).
     *
     * Original: f.s0()
     */
    private fun tick() {
        if (!isRun) return
        val now = Clock.elapsed()
        MarqueeManager.checkAndUpdate(now)
        try {
            // Se ainda não reportou startup e já se passaram 60 s do início, força o report.
            if (!MetricReporter.isStartupReported()) {
                val start = ZappingMonitor.getStartupStat()?.startTime ?: 0L
                if (start > 0 && now - start > 60000) MetricReporter.reportUserStartup()
            }
        } catch (t: Throwable) {
            logger.error("report startup metric in heartbeat failure", t)
        }
        subscribeExecRunnable.run()
        // Original: f$u1 — recarrega lista de canais se logado
        puckScope.launch {
            try {
                if (UserManager.isAuthOk()) ChannelManager.loadChannelList(now, false, false) // user/f.S0(); media/a.P(now,false,false)
            } catch (t: Throwable) { logger.error("load channel list in heartbeat failure", t) }
        }
        try { EpgManager.checkUpdate(now) /* media/c.q(now) */ } catch (t: Throwable) { logger.error("check and update epg in heartbeat failure", t) }
        try { SportsRepository.checkAndUpdate() } catch (t: Throwable) { logger.error("check and update sports failure", t) }
        if (isExpired(now, lastUpgradeCheckTime, upgradeCheckingInterval)) {
            upgradeAction.run()
            lastUpgradeCheckTime = now
        }
        if (isExpired(now, lastMetricHeartbeatTime, metricHeartbeatInterval)) {
            lastMetricHeartbeatTime = now
            MetricReporter.reportLiveHeartbeat()
        }
        NetworkMonitor.refresh()
        if (isExpired(now, lastHeartbeatTime, heartbeatInterval)) {
            doHeartbeatRequest()
            lastHeartbeatTime = now
        }
    }

    /**
     * "Heartbeat" de sessão: tenta auto-login/refresh de token. Não há request HTTP de heartbeat
     * dedicado neste método.
     *
     * Original: f.Z() + f$t1
     */
    private fun doHeartbeatRequest() {
        puckScope.launch {
            try { UserManager.checkTokenAndRefresh() /* user/f.W() */ } catch (t: Throwable) { logger.error("auto login failure", t) }
            val uid = UserManager.getAccountIdString()
            val token = UserManager.getAccessToken()
            if ((uid == "" || token == "") && BaseLibConfig.isDebug) {
                logger.debug("heartbeat not ready uid[{}] accessToken[{}]", uid, token)
            }
        }
    }

    /** Original: f.L0() */
    fun start() {
        if (isRun) logger.warn("heartbeat already started") else isRun = true
    }

    /**
     * Aplica as propriedades remotas.
     *
     * Original: f.K0(Map)
     */
    fun applyProperties(properties: Map<*, *>?) {
        try {
            logger.info("set_param begin[has_subject:${BaseLibConfig.hasSubject}]")
            if (properties == null) return
            initCountDownLatch.await()
            val total = properties.size
            val handlerCount = propertiesHandlers.size
            val applied = LinkedHashMap<String, Any>()
            var ok = 0
            for ((key, handler) in propertiesHandlers) {
                val prefixed = AppAttrUtils.appType() + "_" + key
                var usedKey = prefixed
                var value = properties[prefixed]
                if (value == null) { value = properties[key]; usedKey = key }
                if (value == null) {
                    if (properties.containsKey(prefixed)) logger.warn("set_param got [$key] but value is null")
                    if (properties.containsKey(key)) logger.warn("set_param got [$key] but value is null")
                } else {
                    try {
                        handler.onValue(value.toString())
                        applied[usedKey] = value
                        ok++
                    } catch (t: Throwable) {
                        logger.error("set_param [$key -> $value] failure", t)
                    }
                }
            }
            val ignored = properties.filterKeys { !applied.containsKey(it) }
            if (ignored.isNotEmpty()) logger.info("set_param ignoredProperties${ignored.keys}")
            logger.info("set_param complete[$ok->${applied.size}/$total][$handlerCount][$properties]")
        } catch (t: Throwable) {
            logger.error("set_param failure", t)
        }
    }

    // ---------------------------------------------------------------- upgrade

    /**
     * Fluxo de checagem de upgrade disparado pela UI (com callback de progresso).
     * Lança exceção se a API falhar ou errCode != 0.
     *
     * Original: f.Y(Lifecycle, c9.r) + f$s1 / f$s1$a (o invokeSuspend de f$s1$a não decompilou;
     * reconstruído a partir do dump de instruções que o jadx deixou em comentário).
     */
    fun checkUpgrade(
        lifecycle: Lifecycle?,
        onProgress: ((String, Int, String?, UpgradeFailureEvent?) -> Unit)?,
    ): Flow<UpgradeInfo?> = flow {
        val resp = PTVApi3AClient.getUpgradeConfig() // GET /api/v1/upgrade/config (sandwich ApiResponse)
        // Original: falha de rede/HTTP vira Exception(v0.a/b/c(...)); errCode != 0 → Exception(util/e.a(resp))
        val body = resp.getOrThrow()
        if (body.errCode != 0) throw Exception(com.foxivid.baselib.util.ApiErrors.describe(body))
        body.data?.let {
            lastUpgradeData = it
            onUpgrade(Clock.elapsed(), it, lifecycle, onProgress)
        }
        emit(body.data)
    }

    /**
     * Checagem automática (timer). Erros só são registrados em [UpgradeMonitor].
     *
     * Original: f$z1 / f$z1$a
     */
    private suspend fun upgradeCheck(startTime: Long) {
        val resp = PTVApi3AClient.getUpgradeConfig()
        val body = resp.getOrNull()
        if (body == null) {
            onUpgradeCheckFailure(resp.errorMessage())
            return
        }
        if (body.errCode != 0) return // Original: devolve util/e.a(resp) sem tratar
        try {
            lastUpgradeData = body.data
            onUpgrade(startTime, body.data, null, null)
        } catch (t: Throwable) {
            logger.error("on upgrade failure", t)
        }
    }

    /**
     * Baixa e verifica o APK de upgrade; notifica via callback (se a UI ainda está viva) ou por
     * EventBus (`UpgradeReadyEvent` = nf.z / `UpgradeFailureEvent` = nf.a0).
     *
     * Códigos de falha (variável local `b0Var2`): 0 = sem espaço, 2 = checksum, 3 = tamanho,
     * 4 = canal de distribuição diferente, 5 = tipo de app diferente, outro/null = desconhecido(1).
     *
     * Original: f.A0(long, UpgradeInfo, Lifecycle, c9.r)
     */
    private fun onUpgrade(
        startTime: Long,
        upgradeInfo: UpgradeInfo?,
        lifecycle: Lifecycle?,
        onProgress: ((String, Int, String?, UpgradeFailureEvent?) -> Unit)?,
    ) {
        if (BaseLibConfig.isDebug) logger.debug("apiExtra upgrade[ {} ]", upgradeInfo)
        if (upgradeInfo == null || upgradeInfo.upgradeStatus == 0) return
        if (onProgress != null) {
            mOnProgress = onProgress
            mLifecycle = lifecycle
        }
        if (!isOnUpgrade.compareAndSet(false, true)) return
        try {
            val stat = UpgradeMonitor.newUpgradeStat()
            stat.versionName = upgradeInfo.versionName
            stat.eventTime = startTime
            stat.infoCompleteTime = Clock.elapsed() - startTime // (sic) grava uma duração num campo de instante
            val freeKb = DeviceInfoCollector.availableStorageKb()
            var error: Throwable? = null
            var failCode: Int? = null
            var apkMetaValue = ""

            val task = object : FileDownloader.Task(upgradeInfo.url, StoragePaths.cacheDir(), "upgrade.apk", false,
                object : FileDownloader.Listener {
                    override fun onError(e: Throwable) { error = e }
                    override fun onSaved(savedPath: String) {}
                    override fun onProgress(progress: Int) { mOnProgress?.invoke(upgradeInfo.versionName, progress, null, null) }
                }) {
                /** Original: f$w1.k — escolhe algoritmo pelo digestAlgorithm ("md5" ou outro → sha). */
                private fun verifyDigest(file: File): Boolean = when (upgradeInfo.digestAlgorithm) {
                    "md5" -> FileDownloader.verifyMd5(file, upgradeInfo.checksum, upgradeInfo.size)
                    null -> {
                        logger.warn("upgrade: unknown digest algorithm[{}], will verify checksum with md5", upgradeInfo.digestAlgorithm)
                        FileDownloader.verifyMd5(file, upgradeInfo.checksum, upgradeInfo.size)
                    }
                    // hashCode 113836 = "sha"; qualquer outro valor também cai em verifySha (código idêntico nos dois ramos)
                    else -> FileDownloader.verifySha(file, upgradeInfo.checksum, upgradeInfo.size)
                }

                /** Original: f$w1.l */
                private fun verify(file: File): Boolean {
                    if (verifyDigest(file)) {
                        ApkInstaller.verifyApkMeta(file)?.let { (code, value) ->
                            failCode = code
                            apkMetaValue = value ?: ""
                        }
                        return true // (sic) mesmo com meta-dado divergente devolve true; o código fica em failCode
                    }
                    if (file.length() == upgradeInfo.size) {
                        tryTimes.set(0)
                        failCode = 2
                    } else {
                        failCode = 3
                    }
                    return false
                }

                override fun isFileValid(file: File) = verify(file)
                override fun isDownloadedValid(file: File) = verify(file)
            }
            task.tryTimes.set(2)
            val apkPath = task.file.absolutePath

            if (FileDownloader.download(task) && failCode == null) {
                // Observação: no bytecode a comparação é `b0Var2.element == 0` com Integer nulo → tratado como "sem falha".
                stat.apkDownloadCompleteTime = Clock.elapsed()
                val cb = mOnProgress
                if (cb == null || mLifecycle?.currentState == Lifecycle.State.DESTROYED) {
                    EventBus.getDefault().post(UpgradeReadyEvent(upgradeInfo, apkPath))
                } else {
                    cb(upgradeInfo.versionName, 100, apkPath, null)
                }
            } else {
                stat.apkDownloadFailTime = Clock.elapsed()
                val sizeKb = upgradeInfo.size / 1024
                if (failCode == null && sizeKb > freeKb) failCode = 0
                stat.apkDownloadFailTime = Clock.elapsed()
                if (TextUtils.isEmpty(stat.apkDownloadFailureMsg)) {
                    stat.apkDownloadFailureMsg = when (failCode) {
                        0 -> BaseLibConfig.getString(R.string.not_enough_space_to_upgrade, "not enough rom")
                        3 -> BaseLibConfig.getString(R.string.upgrade_file_mismatch, "file size mismatched")
                        2 -> BaseLibConfig.getString(R.string.file_checksum_mismatch, "checksum mismatched")
                        4 -> BaseLibConfig.getString(R.string.file_channel_mismatch,
                            "app channel mismatched, expect[${AppAttrUtils.distributionChannel()}] but[$apkMetaValue]")
                        5 -> BaseLibConfig.getString(R.string.file_app_type_mismatch,
                            "app type mismatched, expect[${AppAttrUtils.appType()}] but[$apkMetaValue]")
                        else -> BaseLibConfig.getString(R.string.upgrade_unknown_failure, "unknown error")
                    }
                }
                val evt = UpgradeFailureEvent(mOnProgress != null, upgradeInfo, failCode ?: 1, stat.apkDownloadFailureMsg, error)
                val cb = mOnProgress
                if (cb == null || mLifecycle?.currentState == Lifecycle.State.DESTROYED) {
                    EventBus.getDefault().post(evt)
                } else {
                    cb(upgradeInfo.versionName, 100, null, evt)
                }
                val reason = if (sizeKb > freeKb)
                    "no space to upgrade app, required[${sizeKb}KB] but free[${DeviceInfoCollector.availableStorageKb()}KB]"
                else stat.apkDownloadFailureMsg
                if (error == null) logger.error("upgrade apk to [{}] failure [{}]", upgradeInfo.versionName, reason)
                else logger.error("upgrade apk to [{}] failure [{}]", upgradeInfo.versionName, reason, error)
                TelegramBot.sendSysError("[upgrade failure]\n$reason")
                MetricReporter.reportUpgrade()
            }
        } finally {
            isOnUpgrade.set(false)
        }
    }

    /** Original: f.C0(String) */
    private fun onUpgradeCheckFailure(errMessage: String) {
        val stat = UpgradeMonitor.newUpgradeStat()
        stat.infoFailTime = Clock.elapsed()
        stat.infoFailureMsg = errMessage
        logger.error("upgrade failure $errMessage")
    }

    /** Reenvia o último upgrade conhecido. Original: f.H0(String) */
    fun resendUpgrade(from: String) {
        logger.info("send upgrade version[${lastUpgradeData?.versionName}] to user, trigger from[$from]")
        lastUpgradeData?.let {
            try { onUpgrade(Clock.elapsed(), it, null, null) } catch (t: Throwable) { logger.error("on upgrade failure", t) }
        }
    }

    /**
     * Registra o launcher de resultado (tela de permissão "fontes desconhecidas") e já dispara checagem.
     *
     * Original: f.t0(AppCompatActivity) + lambda f.u0
     */
    fun registerActivity(activity: AppCompatActivity) {
        activityResult = activity.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { r ->
            if (BaseLibConfig.isDebug) logger.debug("register_activity_action: activity[{}], data[{}], resultCode[{}]",
                activity.javaClass.canonicalName, r.data, r.resultCode)
            activityAction?.run()
        }
        if (BaseLibConfig.isDebug) logger.debug("register_activity_action: activity[{}]", activity.javaClass.canonicalName)
        upgradeAction.run()
    }

    /** Original: f.G0() */
    fun runPendingActivityAction() { activityAction?.run() }

    /**
     * Pede a instalação do APK. Em API >= 26 sem `canRequestPackageInstalls()` mostra diálogo que abre
     * `MANAGE_UNKNOWN_APP_SOURCES`; ao voltar, instala.
     *
     * Original: f.D0(...) + f.E0 + f.F0
     */
    fun requestInstall(context: Context, titleRes: Int, descRes: Int, btnRes: Int, logoRes: Int, apkFile: String) {
        if (Build.VERSION.SDK_INT < 26 || context.packageManager.canRequestPackageInstalls()) {
            installApk(context, apkFile); return
        }
        AlertDialog.Builder(context)
            .setTitle(titleRes)
            .setMessage(descRes)
            .setPositiveButton(btnRes) { _, _ ->
                val intent = Intent().apply {
                    data = Uri.parse("package:" + context.packageName)
                    action = if (Build.VERSION.SDK_INT >= 26) "android.settings.MANAGE_UNKNOWN_APP_SOURCES" else "android.settings.SECURITY_SETTINGS"
                }
                activityAction = Runnable { installApk(context, apkFile) }
                try {
                    activityResult?.launch(intent)
                } catch (t: Throwable) {
                    val stat = UpgradeMonitor.currentUpgradeStat() ?: UpgradeMonitor.newUpgradeStat()
                    stat.apkInstallFailureMsg = t.stackTraceToString()
                    Toasts.show("request install permission failure:\n" + t.message)
                    logger.error("request install permission failure", t)
                }
            }
            .setCancelable(false)
            .setIcon(logoRes)
            .create().show()
    }

    /** Original: f.v0 + f$v1 */
    private fun installApk(context: Context, apkFile: String) {
        puckScope.launch {
            val ok = ApkInstaller.install(context, apkFile)
            if (BaseLibConfig.isDebug) logger.debug("installApk [{} -> {}]", apkFile, ok)
        }
    }

    // ---------------------------------------------------------------- getters públicos
    /** Original: f.w0() — se o servidor não disse, usa heurística de aparelho (util/z.z) */
    fun isFreeDevice(): Boolean = isFree ?: DeviceInfoCollector.isMobileLike()
    /** Original: f.z0() */
    fun limitContinuingRenewDays(): Int = limitContinuingRenewDays ?: promotionTrialDays
}

/** Evento: APK baixado e pronto. Original: nf/z.java (EventBus) */
data class UpgradeReadyEvent(val upgradeInfo: UpgradeInfo, val apkPath: String)

/** Evento: falha no upgrade. Original: nf/a0.java (EventBus) */
data class UpgradeFailureEvent(
    val fromUser: Boolean,
    val upgradeInfo: UpgradeInfo,
    val failCode: Int,
    val message: String?,
    val error: Throwable?,
)
