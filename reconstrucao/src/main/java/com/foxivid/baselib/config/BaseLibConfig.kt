package com.foxivid.baselib.config

import android.content.Context
import android.os.Build
import android.os.LocaleList
import android.os.SystemClock
import android.util.Base64
import android.util.Log
import androidx.annotation.IntegerRes
import com.foxivid.baselib.crypto.ApiCrypto
import com.foxivid.baselib.device.DeviceInfoCollector
import com.foxivid.baselib.heartbeat.HeartbeatManager
import com.foxivid.baselib.heartbeat.TsPushMode
import com.foxivid.baselib.log.RemoteLogger
import com.foxivid.baselib.util.CrashHandler
import com.foxivid.baselib.media.ChannelManager
import com.foxivid.baselib.user.UserManager
import com.foxivid.baselib.util.AesEcbCipher
import com.foxivid.baselib.util.AppAttrUtils
import com.foxivid.baselib.util.AppPaths
import com.foxivid.baselib.util.ElapsedClock
import com.foxivid.baselib.util.LocaleManager
import com.foxivid.baselib.util.ServerTime
import com.foxivid.baselib.util.StartStatUtil
import com.foxivid.baselib.util.TextCipher
import com.foxivid.baselib.host.ServerProviderUtils
import com.foxivid.baselib.network.HeaderInterceptor
import com.foxivid.baselib.network.HeaderParamsProvider
import com.foxivid.baselib.network.SSLHttpClient
import java.lang.ref.SoftReference
import java.util.Locale

/**
 * Configuração global da baselib e ponto de inicialização do SDK.
 *
 * Original: x1/f1/lb/config/b.java (Kotlin: `x1.f1.lb.config.Config`, arquivo `Config.kt`)
 * Original: x1/f1/lb/config/a.java (classe sintética vazia gerada pelo compilador — sem conteúdo)
 *
 * Guarda flags de comportamento (proxy, catch-up, métricas, idioma...) definidas pelo app
 * e executa a sequência de boot em [init], que é chamada por `InteractionUtils.b0()`
 * (ver [InteractionUtils.initSdk]).
 *
 * Referências a outros módulos usam os nomes da tabela de CONVENCOES.md; quando o módulo
 * não tem nome definido, o nome ofuscado aparece em comentário `Original:`.
 */
object BaseLibConfig {

    /** Ambiente (ex.: `"prod_"`). Original: campo `env` (b). */
    var env: String = ""
        private set

    /** Modo debug: habilita logs em logcat e o `HttpLoggingInterceptor`. Original: `isDebug` (c), getter `t()`. */
    var isDebug: Boolean = false
        private set

    /** applicationId do app hospedeiro (ex.: `"com.live.evo"`). Original: `applicationId` (d). */
    var applicationId: String = ""
        private set

    /** Tipo de proxy local de streaming. Original: `proxyType` (e) = "TS". */
    var proxyType: String = "TS"

    /** Modo de push do proxy TS (enum v6.d; padrão UDP). Original: `tsPushMode` (f). */
    var tsPushMode: TsPushMode? = TsPushMode.UDP

    /** Original: `maxDownloadingBlockCnt` (g). */
    var maxDownloadingBlockCnt: Int? = null

    /** Original: `displayMemberSite` (h). */
    var displayMemberSite: Boolean = true

    /** Original: `isReportMetric` (i). */
    var isReportMetric: Boolean = false

    /** Original: `isVerifyDistributionChannelBeforeUpgradeInstall` (j). */
    var isVerifyDistributionChannelBeforeUpgradeInstall: Boolean = false

    /** Original: `isSetCustomDensity` (k). */
    var isSetCustomDensity: Boolean = false

    /** Original: `hasSubject` (l). */
    var hasSubject: Boolean = false

    /** Original: `shareAppInfo` (m). */
    var shareAppInfo: String = ""

    /** Original: `shareAppTip` (n). */
    var shareAppTip: String = ""

    /** Original: `hasReferralSummary` (o). */
    var hasReferralSummary: Boolean = false

    /** Antecedência do lembrete de programa (ms). Original: (p) = FileWatchdog.DEFAULT_DELAY = 60000. */
    var remindMillisSecondsBeforeTheProgrammeStart: Long = 60_000L

    /** Original: `refreshSportsEventInterval` (q). */
    var refreshSportsEventInterval: Long = 0L

    /** Original: `catchupDvrDays` (r) = 3. */
    var catchupDvrDays: Int = 3

    /** Original: `hasCatchup` (s). */
    var hasCatchup: Boolean = true

    /** Original: `mobileTabSwitchFilterMills` (t) = 3500. */
    var mobileTabSwitchFilterMills: Long = 3500L

    /** Original: `isRenewAutoRefresh` (u). */
    var isRenewAutoRefresh: Boolean = true

    /** Idioma do sistema. Original: `sysLang` (v). */
    private var sysLang: String = "en"

    /** Idioma escolhido no app. Original: `appLang` (w). */
    private var appLang: String = ""

    /** Original: `appContextRef` (x). */
    private var appContextRef: SoftReference<Context>? = null

    /** `true` se o ambiente contém "dev". Original: b.u(). */
    val isDevEnv: Boolean
        get() = env.lowercase(Locale.ROOT).contains("dev")

    /** Original: b.a(). */
    val appContext: Context?
        get() = appContextRef?.get()

    /**
     * Sequência de boot da baselib.
     *
     * Original: b.r(...) (suspend `Config.init`).
     *
     * A ordem e as mensagens de [StartStat] foram mantidas como no original. A primeira parte roda
     * sob `synchronized(this)` e retorna cedo se o mesmo Context já foi inicializado.
     *
     * Parâmetros recebidos de `InitActivity` (com.live.load.InitActivity.w) — ver [InteractionUtils].
     */
    suspend fun init(
        appContext: Context,
        env: String,
        applicationId: String,
        isDebug: Boolean,
        authEndPoint: String,
        adEndPoint: String,
        channelEndPoint: String,
        feedbackEndPoint: String,
        upgradeEndPoint: String,
        messageEndPoint: String,
        metricEndPoint: String,
        streamMediaEndPoint: String,
        loggerEndPoint: String,
        imgEndPoint: String,
        clientSecret: String,
        serverPublicKeyPem: String,
        sportsEndPoint: String,
        historyName: String,
        favoritesName: String,
        allName: String,
    ) {
        synchronized(this) {
            if (appContext == appContextRef?.get()) return
            appContextRef = SoftReference(appContext)
            this.isDebug = isDebug
            this.env = env
            sysLang = updateSystemLanguage()
            appLang = getAppLanguage(appContext)
            this.applicationId = applicationId

            // Chaves do protocolo de criptografia das APIs (clientSecret + chave pública RSA do servidor)
            ApiCrypto.init(clientSecret, serverPublicKeyPem)

            // Relógio monotônico usado por util/d1 (TimeUtils): SystemClock.elapsedRealtime()
            // Original: d1.e(new b$b()) — b$b implementa util/k0 retornando elapsedRealtime().
            TimeUtilsRef.setMonotonicClock { SystemClock.elapsedRealtime() }

            // Codec Base64 (URL_SAFE|NO_WRAP|NO_PADDING = 11) para util/o0. Original: b$c.
            Base64CodecRef.install(
                encode = { bytes -> Base64.encodeToString(bytes, 11) },
                decode = { str -> Base64.decode(str, 11) },
            )

            StartStat.addStep("0.App onCreate Begin@" + UserManagerRef.loginSession())
            StartStat.addStep("0.1.App onCreate initLogger")
            initLogger()
            // Original: Thread.setDefaultUncaughtExceptionHandler(new util.q0())
            Thread.setDefaultUncaughtExceptionHandler(CrashHandler())
            /*
             * Restante do bloco sincronizado (Original, em ordem):
             *  - util/b1.m(filesDir)                       -> inicializa diretórios de cache (PathUtils)
             *  - util/w0.q(new b$d())                       -> SPUtils com backend util/n (SharedPreferences helper)
             *  - metric/monitor/a.h()                       -> AppUsageMonitor.init
             *  - util/d0.m()                                -> EcoModeHelper.load
             *  - media/d.t(context)                         -> MediaConfigUtils.initData
             *  - zf.f.m(context)
             *  - ServerProviderUtils.init(b1.k(), 1001, auth, ad, channel, feedback, upgrade,
             *                             message, metric, streamMedia, img, sports)   (suspende)
             */
        }
        // Original: código após o primeiro ponto de suspensão
        ServerProviderUtils.init(
            hostsCachePath = PathUtilsRef.hostsCacheDir(), // Original: util/b1.k()
            appVersion = 1001,                            // Original: PointerIconCompat.TYPE_CONTEXT_MENU = 1001
            authEndPoint = authEndPoint,
            adEndPoint = adEndPoint,
            channelEndPoint = channelEndPoint,
            feedbackEndPoint = feedbackEndPoint,
            upgradeEndPoint = upgradeEndPoint,
            messageEndPoint = messageEndPoint,
            metricEndPoint = metricEndPoint,
            streamMediaEndPoint = streamMediaEndPoint,
            imgEndPoint = imgEndPoint,
            sportsEndPoint = sportsEndPoint,
        )
        HeaderInterceptor.setParamsProvider(DefaultHeaderParamsProvider)
        // Original: log/a.m(new String[]{loggerEndPoint}) -> RemoteLogger usa o endpoint UDP "ulog...:51000"
        RemoteLoggerRef.setServers(arrayOf(loggerEndPoint))
        /*
         * Original (em ordem), inicialização de caches em disco com versão 1001:
         *  media/c.E(new rf.a())                                    -> EpgManager.setListener
         *  streaming/server/s.i(b1.s(), b1.t(), 1001, 500MB, 1000MB)  -> VoDLocalDiskCacheManage
         *  widget/videoview/g.e(b1.n(), 1001, 163840)                -> PlayPositionCache
         *  media/f.a(b1.u(), 1001, 262144)
         *  streaming/server/q.d(b1.o(), 1001, 102400)                -> SignatureCache
         *  media/k.b(b1.r(), 1001, 524288)
         *  media/j.C(b1.p(), 1001)                                   -> SportsManager
         *  StartStat "0.2.App onCreate init Buggly"
         *  util/k.w(context)  (suspende)                             -> AppAttrUtils.init
         *  StartStat "0.3.App onCreate init App Attr"
         *  streaming/client/a.s(NIOHttpServer); NIOHttpServer.n(new b$f(context))
         *  streaming/server/m.c()                                    "0.4.App onCreate start NIO Server"
         *  SSLHttpClient.init(context)                               "0.5.App onCreate init ssl client"
         *  metric/monitor/f.t()                                      "0.6.App onCreate init play stat"
         *  UserManager.a1(filesDir)                                  "0.7.App onCreate launch user"
         *  ChannelManager.F(all, history, favorites, "")             "0.8.App onCreate launch channel"
         *  StartStat "0.9.App onCreate init eco mode"; HeartbeatUpgradeManager.L0()
         */
        SSLHttpClient.init(appContext)
        val all = allName.ifEmpty { appContext.getString(R_string_channel_column_all) }
        val history = historyName.ifEmpty { appContext.getString(R_string_channel_column_history) }
        val favorites = favoritesName.ifEmpty { appContext.getString(R_string_channel_column_favorites) }
        ChannelManager.setColumnNames(all, history, favorites, "") // Original: media/a.F(all, history, favorites, "")
        HeartbeatManager.start()                                   // Original: heartbeat/f.L0()
    }

    /**
     * Instala o backend de log q6.a (logger próprio do SDK).
     * Original: b.s() -> q6.c.e(new b$g()).
     */
    private fun initLogger() {
        // q6.c.e(...) registra o backend; aqui apenas instanciamos a implementação.
        LoggerBackendRef.install(SdkLogBackend)
    }

    /**
     * Lê o idioma do sistema e o memoriza em [sysLang].
     * Original: b.N().
     */
    fun updateSystemLanguage(): String {
        val language = (if (Build.VERSION.SDK_INT >= 24) LocaleList.getDefault()[0] else Locale.getDefault()).language
        sysLang = language
        return language
    }

    /**
     * Idioma do app. Sem Context disponível, cai para o idioma do sistema.
     * Original: b.b(Context) / b.c(...) (variante com default).
     */
    fun getAppLanguage(context: Context? = null): String {
        val ctx = context ?: appContext
        if (ctx == null) {
            if (appLang.isEmpty()) appLang = updateSystemLanguage()
            return appLang
        }
        // Original: util/n0.d(context) (LanguageUtils)
        val lang = LanguageUtilsRef.getLanguage(ctx)
        appLang = lang
        return lang
    }

    /**
     * Lê uma string de recurso usando o Context guardado, com valor padrão.
     * Original: b.p(int, String).
     */
    fun getString(@IntegerRes resId: Int, dft: String): String =
        appContextRef?.get()?.getString(resId) ?: dft

    // IDs de recurso (x.l1.b2.R$string) — valores reais do R gerado.
    private const val R_string_channel_column_all = 2131951852
    private const val R_string_channel_column_favorites = 2131951853
    private const val R_string_channel_column_history = 2131951854
}

/**
 * Fornecedor padrão dos parâmetros de cabeçalho HTTP (X-Foxivid-*).
 *
 * Original: x1/f1/lb/config/b$e (implementa of/b).
 */
object DefaultHeaderParamsProvider : HeaderParamsProvider {
    /** Original: k.f21398a.q() — AppAttrUtils.appId. */
    override fun appId(): Int = AppAttrUtilsRef.appId()
    /** Original: user/f.B0() — accountId do usuário logado. */
    override fun accountId(): String = UserManagerRef.accountId()
    /** Original: AppAttrUtils.appType ("stb"/"mobile"...). */
    override fun appType(): String = AppAttrUtilsRef.appType()
    /** Original: AppAttrUtils.brandId. */
    override fun brandId(): Int = AppAttrUtilsRef.brandId()
    /** Original: util/z.o() — MAC (DeviceInfoCollector). */
    override fun mac(): String = DeviceInfoRef.mac()
    /** Original: AppAttrUtils.appDistributionChannel. */
    override fun distributionChannel(): String = AppAttrUtilsRef.distributionChannel()
    /** Original: user/f.A0() — streamToken. */
    override fun streamToken(): String = UserManagerRef.streamToken()
    /** Original: AppAttrUtils.tenantId. */
    override fun tenantId(): Int = AppAttrUtilsRef.tenantId()
    /** Original: AppAttrUtils.appVersion. */
    override fun appVersion(): Long = AppAttrUtilsRef.appVersion()
    /** Original: util/z.s() — número de série. */
    override fun serialNumber(): String = DeviceInfoRef.serialNumber()
    /** Original: user/f.j0() — did (Installation id). */
    override fun deviceId(): String = UserManagerRef.did()
    /** Original: BaseLibConfig.getAppLanguage(). */
    override fun language(): String = BaseLibConfig.getAppLanguage()
    /** Original: user/f.g0(url) — accessToken (o mesmo para refresh e demais URLs). */
    override fun authToken(url: String): String = UserManagerRef.authToken(url)
}

/**
 * Backend de log do SDK (q6.a): logcat só em debug; níveis I/W/E também vão para o RemoteLogger.
 * Em release, a mensagem enviada ao logcat é cifrada por util/a.c(msg, false).
 *
 * Original: x1/f1/lb/config/b$g.
 */
object SdkLogBackend {
    /** Original: b$g.debug — só logcat, só debug. */
    fun debug(tag: String, msg: String) { if (BaseLibConfig.isDebug) Log.d(tag, msg) }

    /** Original: b$g.f — debug com throwable. */
    fun debug(tag: String, msg: String, t: Throwable) { if (BaseLibConfig.isDebug) Log.d(tag, msg, t) }

    /** Original: b$g.g. */
    fun info(tag: String, msg: String) {
        if (BaseLibConfig.isDebug) Log.i(tag, format(msg, null))
        RemoteLoggerRef.log("I", tag, msg, null)
    }

    /** Original: b$g.e. */
    fun info(tag: String, msg: String, t: Throwable) {
        if (BaseLibConfig.isDebug) Log.i(tag, format(msg, stack(t)))
        RemoteLoggerRef.log("I", tag, msg, stack(t))
    }

    /** Original: b$g.c. */
    fun warn(tag: String, msg: String) {
        if (BaseLibConfig.isDebug) Log.w(tag, format(msg, null))
        RemoteLoggerRef.log("W", tag, msg, null)
    }

    /** Original: b$g.a. */
    fun warn(tag: String, msg: String, t: Throwable) {
        val st = stack(t)
        if (BaseLibConfig.isDebug) Log.w(tag, format(msg, st))
        RemoteLoggerRef.log("W", tag, msg, st)
    }

    /** Original: b$g.b. */
    fun error(tag: String, msg: String) {
        if (BaseLibConfig.isDebug) Log.e(tag, format(msg, null))
        RemoteLoggerRef.log("E", tag, msg, null)
    }

    /** Original: b$g.d. */
    fun error(tag: String, msg: String, t: Throwable) {
        val st = stack(t)
        if (BaseLibConfig.isDebug) Log.e(tag, format(msg, st))
        RemoteLoggerRef.log("E", tag, msg, st)
    }

    /**
     * Junta mensagem + stacktrace; fora do debug, cifra o texto (util/a.c(msg, false) com chave fixa).
     * Original: b$g.h().
     */
    fun format(msg: String, stackTrace: String?): String {
        val full = if (!stackTrace.isNullOrEmpty()) "$msg\n$stackTrace" else msg
        return if (BaseLibConfig.isDebug) full else LogCipherRef.encrypt(full, false)
    }

    /** Original: b$g.j() -> cc.a.a(throwable) (ExceptionUtils.getStackTrace). */
    private fun stack(t: Throwable?): String? = t?.let { android.util.Log.getStackTraceString(it) }
}

/**
 * Indicador de carregamento usado durante o boot (InitActivity).
 *
 * Original: x1/f1/lb/config/c.java. Os nomes de [start]/[stop] foram inferidos da implementação
 * em z7/j$b (b() torna o container visível, a() o esconde).
 */
interface LoadingIndicator {
    /** Original: c.a() — esconde o container. */
    fun stop()
    /** Original: c.b() — mostra o container. */
    fun start()
    /** Original: c.c(text). */
    fun setText(text: String)
}

/*
 * ---------------------------------------------------------------------------------------------
 * Pontes para classes de outros módulos (apenas assinaturas usadas aqui; implementação em outro
 * agente). Mantidas como `internal object` para o arquivo ficar autocontido e legível.
 * ---------------------------------------------------------------------------------------------
 */

/** Original: x1/f1/lb/util/d1 (relógio com offset do servidor) — delegado a [ServerTime]. */
internal object TimeUtilsRef {
    fun setMonotonicClock(clock: () -> Long) = ServerTime.init(ElapsedClock { clock() }) // d1.e(k0)
    /** Original: d1.c() — tempo monotônico (elapsedRealtime ajustado). */
    fun elapsed(): Long = ServerTime.elapsedNow()
    /** Original: d1.d() — System.currentTimeMillis() + offset do servidor. */
    fun now(): Long = ServerTime.now()
}

/** Original: x1/f1/lb/util/o0 (codec Base64 plugável) — delegado a [AesEcbCipher]. */
internal object Base64CodecRef {
    fun install(encode: (ByteArray) -> String, decode: (String) -> ByteArray) =
        AesEcbCipher.setBase64(object : AesEcbCipher.Base64Codec {
            override fun encode(byteArray: ByteArray?): String = encode(byteArray ?: ByteArray(0))
            override fun decode(string: String): ByteArray = decode(string)
        }) // o0.f()
}

/** Original: x1/f1/lb/util/a1 (StartStatUtil). */
internal object StartStat {
    fun addStep(step: String) = StartStatUtil.addStep(step) // a1.f()
}

/** Original: x1/f1/lb/util/b1 (diretórios). */
internal object PathUtilsRef {
    fun hostsCacheDir(): String = AppPaths.hostsCachePath() // b1.k()
}

/** Original: x1/f1/lb/util/n0. */
internal object LanguageUtilsRef {
    fun getLanguage(context: Context): String = LocaleManager.getLanguage(context) // n0.d()
}

/** Original: x1/f1/lb/util/a (cifra de logs). */
internal object LogCipherRef {
    fun encrypt(text: String, randomKey: Boolean): String = TextCipher.encrypt(text, randomKey) // a.c()
}

/** Original: q6.c.e(q6.a). */
internal object LoggerBackendRef {
    /** Backend ativo; Original: q6.c.b (campo estático, `null` => usa o backend padrão que imprime em stdout). */
    @Volatile var backend: Any? = null
        private set

    /** Original: q6.c.e(q6.a) — apenas troca o backend de log global. */
    fun install(backend: Any) { this.backend = backend }
}

/** Original: x1/f1/lb/log/a (RemoteLogger). */
internal object RemoteLoggerRef {
    fun setServers(servers: Array<String>) = RemoteLogger.setUdpLoggerServer(servers) // a.m()
    fun log(level: String, tag: String, msg: String, stack: String?) = RemoteLogger.log(level, tag, msg, stack) // a.h()
}

/** Original: x1/f1/lb/util/k (AppAttrUtils). */
internal object AppAttrUtilsRef {
    fun appId(): Int = AppAttrUtils.appId()
    fun appType(): String = AppAttrUtils.appType()
    fun appVersion(): Long = AppAttrUtils.appVersion()
    fun brandId(): Int = AppAttrUtils.brandId()
    fun distributionChannel(): String = AppAttrUtils.distributionChannel()
    fun tenantId(): Int = AppAttrUtils.tenantId()
}

/** Original: x1/f1/lb/util/z (DeviceInfoCollector). */
internal object DeviceInfoRef {
    fun mac(): String = DeviceInfoCollector.getMac()                        // z.o()
    fun serialNumber(): String = DeviceInfoCollector.getCpuSerialOrMac()    // z.s() (inferido)
    fun deviceInfo(): Map<String, String> = DeviceInfoCollector.getDeviceProperties() // z.i() (inferido)
}

/** Original: x1/f1/lb/user/f (UserManager). */
internal object UserManagerRef {
    fun accountId(): String = UserManager.getAccountIdString() // f.B0()
    fun streamToken(): String = UserManager.getStreamToken()   // f.A0()
    fun accessToken(): String = UserManager.getAccessToken()   // f.b0()
    fun refreshToken(): String = UserManager.getRefreshToken() // f.y0()
    fun did(): String = UserManager.getDid()                   // f.j0()
    fun authToken(url: String): String = UserManager.getAuthToken(url) // f.g0(url)
    fun loginSession(): Long = UserManager.getLoginSession()   // f.q0()
    fun isInLogout(): Boolean = UserManager.isInLogout()       // f.P0()
}
