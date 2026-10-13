package com.foxivid.baselib.user

import com.foxivid.baselib.bot.TelegramBot
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.device.DeviceInfoCollector
import com.foxivid.baselib.device.Installation
import com.foxivid.baselib.event.AutoLoginFailureEvent
import com.foxivid.baselib.event.LoginCompleteEvent
import com.foxivid.baselib.event.NoStreamServerEvent
import com.foxivid.baselib.event.ReplayEvent
import com.foxivid.baselib.event.SessionTerminateEvent
import com.foxivid.baselib.heartbeat.HeartbeatManager
import com.foxivid.baselib.log.RemoteLogger
import com.foxivid.baselib.media.ChannelManager
import com.foxivid.baselib.media.MediaConfigUtils
import com.foxivid.baselib.media.VoDManager
import com.foxivid.baselib.metric.MetricMonitors
import com.foxivid.baselib.model.feedback.FeedbackUploadResponse
import com.foxivid.baselib.model.local.LocalSessionInfo
import com.foxivid.baselib.model.ptv.ApiResponse
import com.foxivid.baselib.model.ptv.referral.ReferralSummary
import com.foxivid.baselib.model.user.ServerResponse
import com.foxivid.baselib.network.HeaderInterceptor
import com.foxivid.baselib.streaming.EngineHelper
import com.foxivid.baselib.streaming.StreamHelper
import com.foxivid.baselib.streaming.PlayType
import com.foxivid.baselib.util.AppAttrUtils
import com.foxivid.baselib.util.CommonHelper
import com.foxivid.baselib.util.FirebaseUserProps
import com.foxivid.baselib.util.Preferences
import com.foxivid.baselib.util.ResUtils
import com.foxivid.baselib.util.TimeUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.greenrobot.eventbus.EventBus
import org.slf4j.LoggerFactory
import x.l1.b2.R
import java.io.File
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Gerenciador central de usuário/sessão: login (usuário, convidado, token, código de renovação),
 * refresh de token, logout, persistência da sessão, expiração/kick, partida do engine de streaming,
 * lembretes de plano, "mark" do dispositivo e URL de QR de assinatura.
 *
 * Original: x1/f1/lb/user/f.java (Kotlin: UserManager.kt). Nomes de métodos vindos das corrotinas
 * (`UserManager$login$4`, `execLoginFlow`, `guestLogin`, `loginByToken`, `logout`, `refreshToken`,
 * `loginExtra`, `startEngine`, `fireLoginComplete`, `updateSession`, `isInitComplete`,
 * `loadLocalSessionInfo`, `setLocalSessionInfo`, `queryProperty`, `resetPassword`,
 * `getReferralSummary`, `uploadFeedbackFile`, `launch`); os demais foram inferidos.
 *
 * Diagrama de estados e sequência: ver `docs/fluxo_autenticacao.md`.
 *
 * Colaboradores (outros módulos), por nome reconstruído -> original:
 *  - HeartbeatManager -> x1/f1/lb/heartbeat/f (HeartbeatUpgradeManager.kt): a0() autoLoginBeforeTokenExpired,
 *    b0() autoRefreshAccessTokenInterval, k0() loginRetryIntervalMs, z0() limitContinuingRenewDays,
 *    q0() promptRenewMillis, h0() echoModeTime
 *  - EngineHelper -> x1/f1/lb/streaming/client/a; StreamHelper -> x1/f1/lb/streaming/a
 *  - Preferences -> x1/f1/lb/util/w0 (SPUtils; SharedPreferences "config", chaves gravadas como MD5 da chave lógica)
 *  - TimeUtils -> x1/f1/lb/util/d1 (now()=d(), elapsed()=c()); AppAttrUtils -> util/k; CommonHelper -> util/n
 *  - RequestParams -> of/a (tenantId=h(), language=l(), ...); TelegramBot -> x1/f1/lb/bot/a
 *  - Eventos (nf/*): SessionTerminateEvent=nf.u, NoStreamServerEvent=nf.l, LoginCompleteEvent=nf.g,
 *    AutoLoginFailureEvent=nf.h, ReplayEvent=nf.q. EventBus = xe/c (greenrobot): l()=post, o()=postSticky.
 */
object UserManager {

    // ---------------------------------------------------------------- estado

    private var logger = LoggerFactory.getLogger(UserManager::class.java)

    /** Original: puckScope = CoroutineScope(SupervisorJob() + Dispatchers.IO). */
    private val puckScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    /** Original: loginSession = d1.c() no carregamento da classe (id da sessão de execução). */
    private val loginSession: Long = TimeUtils.elapsed()

    private var did = ""
    private var markKey = ""
    private var mark = ""

    /** Liberado quando há sessão local válida (access token não expirado) ou após o 1º login. */
    private val localSessionCreatingCountDownLatch = CountDownLatch(1)

    private var lastInitServerList: List<ServerResponse> = ArrayList()
    private val isKickedOut = AtomicBoolean(false)
    private val isSessionExpired = AtomicBoolean(false)

    /** Original: aaaAdapter = AAAAdapterFactory.d() — sempre o PTV3AAdapter. */
    private val aaaAdapter: AccountAdapter<ApiResponse<*>> = AAAAdapterFactory.getAdapter()

    private val isEngineInStarting = AtomicBoolean(false)
    private var lastStartEngineUId = ""
    private var isRenewCodeFirstLogin = true
    private var isRemindAfterExpired = 1
    private var isRemindPlanNotBindUsername = 1
    private var planWillExpireRemind = 24

    private var latestLoginRenewCode: String? = null
    private var remindAfterExpiredLastRemindTime = 0L
    private var planWillExpireLastRemindTime = 0L
    private var planWillExpireRemindTimeInStartup = 0L
    private var referralSummary: ReferralSummary? = null
    private var lastQueryReferralSummaryTime = 0L
    private var inStart: Boolean? = null
    private var reLoginCnt = 0
    private var isInLogin = false
    private var lastTryLoginTime = 0L
    private var isAuthRetSuccess = false
    private var isUpdateSessionFailed = false
    private var localSessionInfo: LocalSessionInfo? = null
    private var isInLogout = false
    private var isLocalSessionLoaded = false
    private var lastStreamTokenExpireTime = 0L
    private var lastEPlayType: PlayType? = null
    private var lastEngineStartTime = 0L

    // ---------------------------------------------------------------- inicialização

    /**
     * Ponto de entrada: inicializa did, mark, preferências de lembrete e carrega a sessão local.
     * Original: f.a1(File) (synchronized) + corrotina `UserManager$launch$1`.
     */
    @Synchronized
    fun launch(fileInstallDir: File) {
        if (inStart == true) {
            logger.warn("Puck is during PHASE SHIFT")
            return
        }
        inStart = true
        puckScope.launch {
            MetricMonitors.current()?.setLoginSession(loginSession) // h.b()?.y(loginSession)
            did = Installation.id(fileInstallDir)
            DeviceInfoCollector.putDid(did)
            if (BaseLibConfig.isDebug) logger.debug("did[{}]", did)
            getMark()
            latestLoginRenewCode = Preferences.getString("latest_login_renew_code_in_um", "")
            isRemindAfterExpired = Preferences.getInt("um_is_remind_after_plan_expired", isRemindAfterExpired)
            remindAfterExpiredLastRemindTime = Preferences.getLong("um_plan_last_remind_time", remindAfterExpiredLastRemindTime)
            isRemindPlanNotBindUsername = Preferences.getInt("um_is_remind_plan_not_bind_username", isRemindPlanNotBindUsername)
            planWillExpireRemind = Preferences.getInt("um_plan_will_expire_remind", planWillExpireRemind)
            planWillExpireRemindTimeInStartup = Preferences.getLong("um_plan_will_expire_last_remind_time", planWillExpireLastRemindTime)
            if (planWillExpireRemind > 1) planWillExpireLastRemindTime = planWillExpireRemindTimeInStartup
            loadLocalSessionInfo()
        }
    }

    /**
     * Carrega a sessão salva (JSON Gson) da chave "local_session".
     * Original: f.c1() "loadLocalSessionInfo".
     */
    private suspend fun loadLocalSessionInfo() {
        try {
            val json = Preferences.getString("local_session", "")
            if (json.isNotEmpty()) {
                val info: LocalSessionInfo = Gson().fromJson(json, object : TypeToken<LocalSessionInfo>() {}.type)
                localSessionInfo = info
                info.latestLocalLoadTime = TimeUtils.now()
                if (!isAccessTokenExpired()) localSessionCreatingCountDownLatch.countDown()
            }
            logger.info("[$did], load local session[$json]")
        } catch (t: Throwable) {
            try {
                logger.error("[$did], load local session failure", t)
            } finally {
                isLocalSessionLoaded = true
            }
        }
        // NOTA de fidelidade: no bytecode, isLocalSessionLoaded só é setado no caminho de exceção
        // (try/catch/finally aninhado). Pode ser artefato do jadx; mantido como está.
    }

    /**
     * Espera a sessão local ficar pronta (latch, 15 s por tentativa) até `timeoutMS`.
     * Original: f.Q0(Long) "isInitComplete" (+ f$i/f$j) — confirmado contra o fallback do jadx: cada espera é `latch.await(15, SECONDS)` em Dispatchers.IO.
     */
    suspend fun isInitComplete(timeoutMS: Long? = null): Boolean {
        val start = TimeUtils.elapsed()
        while ((inStart == null || inStart == true) && !isLocalSessionLoaded) {
            logger.info("wait for the session creating complete")
            withContext(Dispatchers.IO) { localSessionCreatingCountDownLatch.await(15L, TimeUnit.SECONDS) }
            if (timeoutMS != null && timeoutMS > 0 && TimeUtils.elapsed() - start > timeoutMS) return false
        }
        return true
    }

    /** Original: f.H0() — "init user", chamado no fim do fireLoginComplete. */
    fun initUser() {
        if (BaseLibConfig.isDebug) logger.debug("init user")
        inStart = false
        isInLogin = false
        isAuthRetSuccess = true
        resetKickState()
        ChannelManager.reload(false, false)   // media/a.Q(false,false)
        VoDManager.reset()                  // media/l.n()
    }

    // ---------------------------------------------------------------- persistência

    /** Original: f.p0(). */
    fun getLocalSessionInfo(): LocalSessionInfo? = localSessionInfo

    /** Original: f.w1() — grava JSON em "local_session". */
    private fun saveLocalSession() {
        val s = localSessionInfo ?: return
        Preferences.putString("local_session", Gson().toJson(s))
    }

    /**
     * Troca a sessão em memória, reinicia o engine se o usuário mudou (ou estava deslogado),
     * ou apenas empurra o novo stream token; depois persiste.
     * Original: f.y1(LocalSessionInfo) "setLocalSessionInfo" (+ corrotina y: StreamHelper.A()).
     */
    fun setLocalSessionInfo(newLocalSessionInfo: LocalSessionInfo) {
        val sameStreamToken = newLocalSessionInfo.streamToken == localSessionInfo?.streamToken
        val old = localSessionInfo
        val userChanged = old == null || newLocalSessionInfo.accountId != old.accountId || isLogoutOrKickedOut()
        try {
            if (localSessionInfo?.accountType != newLocalSessionInfo.accountType && sameStreamToken) {
                logger.warn("accountType changed[${localSessionInfo?.accountType}] ->[${newLocalSessionInfo.accountType}], but streamToken no change[${newLocalSessionInfo.streamToken}]")
            }
            localSessionInfo = newLocalSessionInfo
            if (hasValidPlan()) {
                remindAfterExpiredLastRemindTime = 0L
                Preferences.putLong("um_plan_last_remind_time", 0L)
                if (isRemindAfterExpired == 0) {
                    isRemindAfterExpired = 1
                    Preferences.putInt("um_is_remind_after_plan_expired", 1)
                }
            }
            if (userChanged) {
                CoroutineScope(Dispatchers.IO).launch {
                    StreamHelper.restartEngine()
                        .catch { logger.error("restart engine failure", it) }
                        .collect { ok ->
                            if (ok) EventBus.getDefault().postSticky(ReplayEvent(0L, 8, 1, "restart_engine_um"))
                            else logger.error("restart engine failure")
                        }
                }
            } else if (EngineHelper.isEngineStarted()) {
                EngineHelper.refreshToken(newLocalSessionInfo.streamToken)
            } else {
                logger.info("try refresh stream token, but engine is not running")
            }
            RemoteLogger.setIdentity(HeaderInterceptor.distributionChannel(), HeaderInterceptor.accountId(), HeaderInterceptor.deviceId()) // log/a.l(...)
            saveLocalSession()
        } catch (t: Throwable) {
            try {
                logger.warn("refresh stream token failure", t)
            } finally {
                saveLocalSession()
            }
        }
    }

    // ---------------------------------------------------------------- login

    /**
     * Login principal (usuário digitado, auto-login ou convidado).
     * Original: f.f1(usernameParam, passwordParam, loginAsGuest) -> corrotina `UserManager$login$4`
     * (+ map `login$$inlined$map$2` que zera isUpdateSessionFailed no sucesso).
     *
     * 1. espera [isInitComplete];
     * 2. resolve username (param -> username salvo -> lastUsername) e MD5 da senha (param -> salva);
     * 3. decide se precisa chamar o servidor:
     *    - usuário digitou ou loginAsGuest: sempre;
     *    - auto-login com sessão válida e auth ok e fora da janela de retry: devolve `(true, 0)` sem rede;
     *    - se refresh já falhou e o par usuário/senha já falhou antes: `(false, -11, "auto login failure")`;
     * 4. chama `queryMetaInfo()` e trata o resultado em [handleMetaInfoResult].
     */
    fun login(usernameParam: String? = null, passwordParam: String? = null, loginAsGuest: Boolean = false): Flow<AuthResult> = flow {
        isInitComplete()
        val isLoginByUser = !usernameParam.isNullOrEmpty()
        var passwordDigest = passwordParam?.let { md5(it) } ?: ""
        var username = usernameParam ?: getUsername()
        if (username.isEmpty()) username = localSessionInfo?.lastUsername ?: ""
        if (passwordDigest.isEmpty()) passwordDigest = localSessionInfo?.passwordDigest ?: ""

        if (!isLoginByUser && !loginAsGuest) {
            if (localSessionInfo != null && isAuthRetSuccess && !tryAcquireLogin()) {
                isInLogin = false
                emit(Triple(true, 0, null))
                return@flow
            }
            val s = localSessionInfo
            if (s != null && s.isTriedRefreshAccessTokenFailure && username.isNotEmpty() &&
                username == s.loginFailureUsername && passwordDigest == s.loginFailurePassword &&
                s.isTriedLoginByUsernameFailure
            ) {
                isInLogin = false
                val reason = if (s.isTriedRefreshAccessTokenFailure) "refresh token is expired" else ""
                val who = "user[$username] " + (if (passwordDigest.isEmpty()) "password empty " else "") + "already failure"
                logger.error("auto login failure, $reason $who, should not retry")
                emit(Triple(false, -11, "auto login failure"))
                return@flow
            }
        }
        aaaAdapter.queryMetaInfo().collect {
            handleMetaInfoResult(it, loginAsGuest, isLoginByUser, username, passwordDigest)
        }
    }.map { r ->
        if (r.first) isUpdateSessionFailed = false
        r
    }

    /**
     * Decisão após o meta-info. Original: corrotina `UserManager$login$4$1`.emit.
     */
    private suspend fun FlowCollector<AuthResult>.handleMetaInfoResult(
        r: AuthResult, loginAsGuest: Boolean, isLoginByUser: Boolean, username: String, password: String,
    ) {
        when {
            r.second == -8 -> { isInLogin = false; emit(r) }
            r.second != 0 -> { isInLogin = false; emit(r) }
            loginAsGuest -> {
                localSessionInfo?.lastUsername = ""
                guestLogin(this)
            }
            localSessionInfo == null -> guestLogin(this)
            isLoginByUser -> execLoginFlow(false, loginByUsername(username, password), username, password, true, this)
            else -> {
                val refreshExpired = isRefreshTokenExpired()
                val reason = getKickedOutReason()
                // sessão encerrada por motivo que NÃO seja expiração de stream token (3/5)
                val loggedOut = isLogoutOrKickedOut() && reason != 3 && reason != 5
                if (refreshExpired || loggedOut) {
                    val why = if (loggedOut) "logout(${logoutReasonText(reason)})" else "refresh token is expired"
                    when {
                        username.isEmpty() -> {
                            logger.error("system auto login, username empty, $why, try guest login")
                            guestLogin(this)
                        }
                        loggedOut || password.isEmpty() -> {
                            isInLogin = false
                            logger.error("no system auto login, user[$username], " + (if (password.isEmpty()) "password empty, " else "") + "$why, return to UI")
                            emit(Triple(false, -8, username))
                        }
                        else -> execLoginFlow(false, loginByUsername(username, password), username, password, false, this)
                    }
                } else {
                    execLoginFlow(true, loginByToken(), username, password, false, this)
                }
            }
        }
    }

    /**
     * Coleta um fluxo de login e trata falhas com fallback.
     * Original: f.Z(isLoginByToken, flow, username, password, isLoginByUser, collector) + classe f$a
     * (corrotina `UserManager$execLoginFlow$2`).
     *
     * - sucesso: zera reLoginCnt se plano válido; repassa.
     * - código -3 (exceção de rede): repassa; se login do usuário, só loga; se automático, espera
     *   `loginRetryIntervalMs` e dispara [loginExtra]. NOTA: o jadx produziu dois ramos com a
     *   condição invertida (case 0 vs case 2); escolhida a variante coerente (auto => retry).
     * - login por usuário falhou: marca triedLoginByUsernameFailure/credenciais e repassa.
     * - login por token falhou: sem username -> convidado; sem senha -> `(false,-8,username)`;
     *   com senha -> tenta usuário/senha (recursivo, isLoginByToken=false).
     */
    private suspend fun execLoginFlow(
        isLoginByToken: Boolean, flow: Flow<AuthResult>, username: String, password: String?,
        isLoginByUser: Boolean, collector: FlowCollector<AuthResult>,
    ) {
        flow.collect { r ->
            if (r.first) {
                if (hasValidPlan()) reLoginCnt = 0
                collector.emit(r)
                return@collect
            }
            val desc = (if (isLoginByUser) "user" else "auto") + " login " + (if (isLoginByToken) "by token" else "by user[$username]")
            when {
                r.second == -3 -> {
                    isInLogin = false
                    reportLoginFailureMetric(r.third ?: "Unknown")
                    collector.emit(r)
                    if (!isLoginByUser) {
                        val wait = HeartbeatManager.loginRetryIntervalMs
                        logger.error("$desc failure, call api exception, will retry after $wait ms")
                        delay(wait)
                        loginExtra()
                    } else {
                        logger.error("$desc failure, call api exception")
                        // Original (fallback do jadx, label 3): emite NOVAMENTE o mesmo resultado `r` (2ª emissão).
                        collector.emit(r)
                    }
                }
                !isLoginByToken -> {
                    isInLogin = false
                    logger.error("$desc failure, " + (if (password.isNullOrEmpty()) "password empty, " else "") + "api ret[${r.third}]")
                    localSessionInfo?.isTriedLoginByUsernameFailure = true
                    localSessionInfo?.loginFailureUsername = username
                    localSessionInfo?.loginFailurePassword = password
                    collector.emit(r)
                }
                username.isEmpty() -> {
                    logger.error("$desc failure, api ret[${r.third}], username empty, try guest login")
                    guestLogin(collector)
                }
                password.isNullOrEmpty() -> {
                    isInLogin = false
                    logger.error("$desc failure, api ret[${r.third}], password empty, return to UI")
                    collector.emit(Triple(false, -8, username))
                }
                else -> {
                    logger.error("$desc failure, api ret[${r.third}], try login by[$username]")
                    execLoginFlow(false, loginByUsername(username, password), username, password, isLoginByUser, collector)
                }
            }
        }
    }

    /**
     * Original: f.i1(username, passwordDigest) — usa o DDI salvo só se o username for o telefone salvo.
     */
    private suspend fun loginByUsername(username: String, passwordDigest: String): Flow<AuthResult> {
        val digitalCode = if (username == localSessionInfo?.phone) localSessionInfo?.digitalCode else ""
        return aaaAdapter.login(username, passwordDigest, digitalCode ?: "")
    }

    /**
     * Login com usuário + senha em claro + DDI (UI). Original: f.d1(username, digitalCode, password).
     */
    suspend fun loginByPassword(username: String, digitalCode: String, password: String): Flow<AuthResult> =
        aaaAdapter.login(username, md5(password), digitalCode)

    /**
     * Login por token. Original: f.h1() -> corrotina `UserManager$loginByToken$1`.
     * - access token expirado ou último updateSession falhou: refresh(refreshToken) -> se ok,
     *   updateSession(accessToken); se falhar, marca triedRefreshAccessTokenFailure.
     * - senão: updateSession(accessToken); se falhar, faz o mesmo caminho de refresh ("re-login").
     */
    private fun loginByToken(): Flow<AuthResult> = flow {
        if (isAccessTokenExpired() || isUpdateSessionFailed) {
            emitAll(refreshThenUpdate("login"))
        } else {
            val token = getAccessToken()
            updateSession().collect { r ->
                if (r.first) {
                    emit(r)
                } else {
                    logger.error("login by token[$token] failure, api ret[${r.third}]")
                    emitAll(refreshThenUpdate("re-login"))
                }
            }
        }
    }

    /** Trecho comum de loginByToken (classes r$a e r$b$a). */
    private fun refreshThenUpdate(what: String): Flow<AuthResult> = flow {
        aaaAdapter.refresh(getRefreshToken()).collect { r ->
            if (r.first) {
                val token = getAccessToken()
                updateSession().collect { u ->
                    if (!u.first) {
                        val label = if (what == "login") "login" else "re-login"
                        logger.error("$label by token[$token] failure, api ret[${u.third}]")
                    }
                    emit(u)
                }
            } else {
                logger.error("refresh token failure before $what, api ret[${r.third}]")
                localSessionInfo?.isTriedRefreshAccessTokenFailure = true
                emit(r)
            }
        }
    }

    /**
     * Valida a sessão no servidor com o access token. Se falhar, marca auth como falho e dispara
     * um login automático completo, emitindo o primeiro resultado dele.
     * Original: f.M1() "updateSession" (+ map c0 `updateSession$$inlined$map$1`).
     */
    suspend fun updateSession(): Flow<AuthResult> {
        val token = localSessionInfo?.accessToken ?: return flowOf(Triple(false, null, "access token is empty"))
        return aaaAdapter.updateSession(token).map { r ->
            if (r.first) {
                isUpdateSessionFailed = false
                r
            } else {
                isAuthRetSuccess = false
                isUpdateSessionFailed = true
                login().first()
            }
        }
    }

    /**
     * Login como convidado (por dispositivo). Original: f.F0(collector) "guestLogin" (+ f$g, f$h).
     */
    private suspend fun guestLogin(collector: FlowCollector<AuthResult>?) {
        aaaAdapter.guestLogin()
            .catch { isInLogin = false; throw it }
            .collect { r ->
                isInLogin = false
                if (r.second == -3) {
                    val msg = r.third ?: "Unknown"
                    reportLoginFailureMetric(msg)
                    logger.error("Guest login failure: $msg")
                }
                collector?.emit(r)
            }
    }

    /**
     * Login por código de renovação/recarga. Original: f.e1(code) "login" (+ map n).
     * Bloqueia se dias restantes > limitContinuingRenewDays (exceto convidado): `(false,-10)`.
     * Se já houve username: `(false,-8,lastUsername)`. No PTV o adapter devolve -2 (não suportado).
     * Sucesso: grava "latest_login_renew_code_in_um" e calcula isRenewCodeFirstLogin.
     */
    suspend fun loginByCode(code: String): Flow<AuthResult> {
        if (getPlanLeftDays() > HeartbeatManager.limitContinuingRenewDays && !isGuestOrLoggedOut()) {
            return flowOf(Triple(false, -10, "limit continuing renew"))
        }
        val last = localSessionInfo?.lastUsername ?: ""
        if (last.isNotEmpty()) return flowOf(Triple(false, -8, last))
        return aaaAdapter.loginByCode(code).map { r ->
            if (r.first) {
                isRenewCodeFirstLogin = if (latestLoginRenewCode == code) false else {
                    Preferences.putString("latest_login_renew_code_in_um", code)
                    latestLoginRenewCode = code
                    true
                }
            }
            r
        }
    }

    /**
     * Pós-login: zera referral se trocou de usuário e recarrega, inicializa dados de mídia,
     * Firebase, consulta propriedades, libera o latch e posta LoginCompleteEvent (sticky).
     * Original: f.a0(oldUid) "fireLoginComplete".
     */
    suspend fun fireLoginComplete(oldUid: String) {
        val uid = getAccountIdString()
        if (oldUid != uid || referralSummary == null) {
            referralSummary = null
            getReferralSummary(true).catch { logger.info("init referral summary failure", it) }.collect { }
        }
        MediaConfigUtils.initUserData(uid) // Original: media/d.u(B0()) — B0() = accountId da conta (confirmado no fallback)
        if (!BaseLibConfig.isDebug && !BaseLibConfig.isDevEnv) {
            FirebaseUserProps.updateUserType()      // util/j0.c()
            FirebaseUserProps.updateVersionName()   // util/j0.e()
        }
        queryProperty()
        localSessionCreatingCountDownLatch.countDown()
        EventBus.getDefault().postSticky(LoginCompleteEvent())
        initUser()
    }

    /** Original: f.r1() "queryProperty" — no PTV devolve -2; resultado ignorado. */
    private fun queryProperty() {
        puckScope.launch {
            aaaAdapter.queryAppProperty().catch { logger.error("query property failure", it) }.collect { }
        }
    }

    /**
     * Login automático em background; em falha posta AutoLoginFailureEvent.
     * Original: f.j1(callback) "loginExtra" (k1 = sem callback).
     */
    private fun loginExtra(callback: ((Boolean) -> Unit)? = null) {
        puckScope.launch {
            login().catch { logger.error("login error", it) }.collect { r ->
                if (!r.first) {
                    logger.error("auto login failure [${r.third}] [${r.second}]")
                    EventBus.getDefault().post(AutoLoginFailureEvent(r.second ?: -1, r.third ?: "Unknown"))
                }
                callback?.invoke(r.first)
            }
        }
    }

    // ---------------------------------------------------------------- tokens

    /**
     * Tick periódico (chamado pelo heartbeat): decide se renova o token.
     * Original: f.W().
     */
    fun checkTokenAndRefresh() {
        val s = localSessionInfo
        if (s != null && s.isRefreshAccessTokenFailure && hasUsername() && s.isTriedLoginByUsernameFailure) return
        if (isOutOfService()) {
            val by = s?.kickedOutBy
            logger.warn("session is out of service, kicked out[${s?.isKickedOut}]" + (if (by.isNullOrEmpty()) "" else " by $by") + ", expired[$isSessionExpired")
            return
        }
        if (isInLogin) return
        if (shouldRefreshToken(s?.accessTokenExpiresTS)) {
            if (!isRefreshTokenExpired()) {
                logger.warn("time to refresh token, now[ ${TimeUtils.now()} ] last[ ${s?.latestTokenUpdateTime} ], access token expire[ ${s?.accessTokenExpiresTS} ]")
                refreshToken()
            } else {
                logger.warn("refresh token is expired, now[ ${TimeUtils.now()} ], access token[${s?.accessToken}] access token expire[ ${s?.accessTokenExpiresTS} ] refresh token[${s?.refreshToken}] refresh token expire[ ${s?.refreshTokenExpiresTS}]")
                loginExtra()
            }
        }
    }

    /**
     * Original: f.X0(ts) — true se: sem expiração; ou faltam menos de autoLoginBeforeTokenExpired;
     * ou o último update de token foi há mais de autoRefreshAccessTokenInterval.
     */
    private fun shouldRefreshToken(ts: Long?): Boolean {
        val exp = ts ?: 0L
        if (exp == 0L) return true
        val now = TimeUtils.now()
        val last = localSessionInfo?.latestTokenUpdateTime ?: 0L
        if (HeartbeatManager.autoLoginBeforeTokenExpired + now <= exp) {
            return last > 0 && now - last > HeartbeatManager.autoRefreshAccessTokenInterval
        }
        return true
    }

    /**
     * Original: f.t1() + corrotina `UserManager$refreshToken$1`. Sessão encerrada -> login completo.
     * Falha no refresh -> marca triedRefreshAccessTokenFailure e faz [loginExtra].
     */
    private fun refreshToken() {
        if (isLogoutOrKickedOut()) { loginExtra(); return }
        val rt = localSessionInfo?.refreshToken ?: return
        puckScope.launch {
            aaaAdapter.refresh(rt)
                .catch {
                    localSessionInfo?.isTriedRefreshAccessTokenFailure = true
                    logger.error("refresh failure", it)
                }
                .collect { r ->
                    if (!r.first) {
                        logger.error("refresh token failure:[${r.third}(${r.second})]")
                        loginExtra()
                    }
                }
        }
    }

    /**
     * Evento "stream token expirado" vindo do engine: re-login com throttle (loginRetryIntervalMs);
     * em sucesso posta ReplayEvent("token_expire_re_login"). Original: f.o1() (+ f$u).
     */
    fun onStreamTokenExpired() {
        val now = TimeUtils.now()
        val diff = now - lastStreamTokenExpireTime
        if (diff > HeartbeatManager.loginRetryIntervalMs) {
            loginExtra { ok -> if (ok) EventBus.getDefault().post(ReplayEvent(0L, 10, 1, "token_expire_re_login")) }
            lastStreamTokenExpireTime = now
            return
        }
        logger.info("stream token expired event is too frequent, not reach the re-login interval[$diff < ${HeartbeatManager.loginRetryIntervalMs}]")
    }

    /** Original: f.D1() — entra em "isInLogin" se fora da janela de retry. */
    private fun tryAcquireLogin(): Boolean {
        val now = TimeUtils.elapsed()
        if (!isInLogin && now - lastTryLoginTime >= HeartbeatManager.loginRetryIntervalMs) {
            isInLogin = true
            lastTryLoginTime = now
            return true
        }
        return false
    }

    /** Original: f.g0(url) — token de auth para o HeaderInterceptor (mesmo valor em ambos ramos). */
    fun getAuthToken(url: String): String {
        val token = if (url.contains("account/token/refresh")) localSessionInfo?.accessToken else localSessionInfo?.accessToken
        if (BaseLibConfig.isDebug) logger.debug("getAuthToken: [{}]->[{}]", url, token)
        return token ?: ""
    }

    // ---------------------------------------------------------------- logout / kick / expiração

    /**
     * Logout. Original: f.m1(from) -> corrotina `UserManager$logout$1` (+ t$b "logout$1$2").
     * Sucesso: limpa tokens e contatos (guarda lastUsername), persiste, entra em login e faz
     * guest login imediatamente; depois zera referral e emite o resultado do logout.
     */
    fun logout(from: String): Flow<AuthResult> = flow {
        logger.info("logout[{}]", from)
        isInLogout = true
        aaaAdapter.logout().catch { isInLogout = false; throw it }.collect { r ->
            try {
                if (!r.first) {
                    isInLogout = false
                    emit(r)
                    return@collect
                }
                val username = getUsername()
                localSessionInfo?.apply {
                    isLogout = true
                    accessToken = null
                    refreshToken = null
                    streamToken = null
                    email = ""
                    phone = ""
                    phoneNumber = ""
                    code = ""
                    lastUsername = username
                    this.username = ""
                    digitalCode = null
                    passwordDigest = null
                }
                saveLocalSession()
                tryAcquireLogin()
                guestLogin(this)
                if (BaseLibConfig.isDebug) logger.debug("logout success: ${r.third}")
                referralSummary = null
                isInLogout = false
                emit(r)
            } catch (t: Throwable) {
                isInLogout = false
                throw t
            }
        }
    }

    /** Original: f.Z0(who, reasonCode) — chamado com ("API",1) no erro 9000042. */
    fun onKickedOut(who: String, reasonCode: Int) {
        if (isKickedOut.compareAndSet(false, true)) {
            localSessionInfo?.kickedOutBy = who
            localSessionInfo?.kickedOutReason = reasonCode
            localSessionInfo?.isKickedOut = true
            saveLocalSession()
            notifyKickedOut()
        }
    }

    /** Original: f.x1() — chamado no erro 9000010. */
    fun markSessionExpired() {
        if (isSessionExpired.compareAndSet(false, true)) notifySessionExpired()
    }

    /** Original: f.X() — string de aviso pendente (kick/expiração), notificando de novo. */
    fun checkSessionState(): Int? {
        if (localSessionInfo?.isKickedOut == true) {
            notifyKickedOut(); return R.string.session_kicked_out
        }
        if (!isSessionExpired.get()) return null
        notifySessionExpired()
        return R.string.session_expired
    }

    /** Original: f.E1(). */
    private fun notifyKickedOut() {
        postSessionTerminate(9000042, localSessionInfo?.kickedOutBy ?: "")
        showSessionDialog(R.string.session_kicked_out, "You are kicked out, please login")
    }

    /** Original: f.I1(). */
    private fun notifySessionExpired() {
        postSessionTerminate(9000010, "api")
        showSessionDialog(R.string.session_expired, "Your session is expired, please login")
    }

    /**
     * Original: f.F1 -> H1 -> G1(digitalCode, contact, reason, callback, onCancel, onDismiss).
     * O corpo de G1 está VAZIO no binário (diálogo removido nesta build); só resolve a string.
     */
    private fun showSessionDialog(reasonResId: Int, dft: String) {
        ResUtils.getString(reasonResId, dft) // u0.a(); resultado descartado por G1 vazio
    }

    /** Original: f.q1(errCode, who) — post de SessionTerminateEvent. */
    private fun postSessionTerminate(errCode: Int, who: String) {
        logger.error("session terminate event, errCode[$errCode], by[$who]")
        EventBus.getDefault().post(SessionTerminateEvent(errCode, who))
    }

    /** Original: f.v1() — limpa o estado de kick/expiração. */
    private fun resetKickState() {
        if (localSessionInfo?.isKickedOut == true) {
            isKickedOut.set(false)
            localSessionInfo?.isKickedOut = false
            localSessionInfo?.kickedOutReason = 0
            localSessionInfo?.kickedOutBy = ""
            saveLocalSession()
        }
        isSessionExpired.set(false)
    }

    /** Original: f.n1(reason). */
    private fun logoutReasonText(reason: Int): String = when (reason) {
        0 -> "normal logout"
        1 -> "kick by other " + (localSessionInfo?.kickedOutBy ?: "") + " session"
        2 -> "version not support"
        3 -> "stream token expired"
        4 -> "auth token expired"
        5 -> "stream tmp logout"
        else -> "unknown"
    }

    // ---------------------------------------------------------------- engine de streaming

    /**
     * Inicia o engine P2P/streaming com a lista de servidores da sessão.
     * Original: f.J1(playType) "startEngine" (+ a0, b0).
     * - sem servidores: bot "[no_stream_server]", posta NoStreamServerEvent (sticky), login automático e erro;
     * - mesmo playType já iniciado: true;
     * - mesmo uid há < 30 s e engine rodando: true ("too frequent");
     * - senão: EngineHelper.prepare() e, em seguida, EngineHelper.init(json(servers), streamToken, uid,
     *   did, tenantId, deviceType(1=mobile), playType).
     */
    suspend fun startEngine(playType: PlayType): Flow<Boolean> {
        val list = getStreamServers()
        if (list.isEmpty()) {
            if (isAuthRetSuccess) TelegramBot.send("[no_stream_server]\nauth complete, but no stream server return")
            EventBus.getDefault().postSticky(NoStreamServerEvent())
            return flow { loginExtra(); throw Exception("stream server list is empty") }
        }
        while (!isEngineInStarting.compareAndSet(false, true)) {
            // NOTA: o laço de espera (delay(100) — "kotlinx.coroutines.v0.a(100)") foi reconstruído
            // a partir do comentário "code lost" do jadx.
            delay(100)
            if (lastEPlayType == playType) {
                if (BaseLibConfig.isDebug) logger.debug("Already start engine[$playType]")
                isEngineInStarting.set(false)
                return flowOf(true)
            }
        }
        val uid = getAccountIdString()
        if (lastEPlayType != playType && lastStartEngineUId == uid &&
            TimeUtils.elapsed() - lastEngineStartTime < 30000 && EngineHelper.isEngineStarted()
        ) {
            if (BaseLibConfig.isDebug) logger.debug("Already start engine[$playType], too frequent to start engine")
            isEngineInStarting.set(false)
            return flowOf(true)
        }
        if (BaseLibConfig.isDebug) logger.debug("Start engine[$playType]...")
        val deviceType = if (DeviceInfoCollector.isMobile()) 1 else 0
        lastEPlayType = null
        return EngineHelper.destroy().flatMapConcat {
            MetricMonitors.current()?.setEngineInitStart(TimeUtils.elapsed())
            EngineHelper.create(
                Gson().toJson(list), getStreamToken(), uid, getDid(), HeaderInterceptor.tenantId().toString(), deviceType, playType,
            ).catch { t ->
                try {
                    reportEngineFailureMetric(t)
                    logger.error("init stream service failure playType[$playType]", t)
                    throw t
                } finally {
                    isEngineInStarting.set(false)
                }
            }.map { started ->
                try {
                    if (started) {
                        lastEngineStartTime = TimeUtils.elapsed()
                        lastEPlayType = playType
                        lastStartEngineUId = uid
                        lastInitServerList = list
                        MetricMonitors.current()?.setEngineStarted(TimeUtils.elapsed())
                        logger.info("init stream service complete, engine is started, playType[$playType]")
                    } else {
                        logger.warn("init stream service complete, engine is not started, playType[$playType]")
                    }
                    started
                } finally {
                    isEngineInStarting.set(false)
                }
            }
        }
    }

    // ---------------------------------------------------------------- operações delegadas

    /** Original: f.E0(contact, digitalCode, actionType). */
    suspend fun sendCaptcha(contact: String, digitalCode: String, actionType: String) =
        aaaAdapter.sendCaptcha(contact, digitalCode, actionType)

    /** Original: f.b1(...). */
    suspend fun linkContact(contact: String, password: String, verificationCode: String, digitalCode: String, invitationCode: String) =
        aaaAdapter.linkContact(contact, password, verificationCode, digitalCode, invitationCode)

    /** Original: f.s1(code). */
    suspend fun recharge(code: String) = aaaAdapter.recharge(code)

    /**
     * Original: f.u1(...) -> corrotina `UserManager$resetPassword$1`.
     * Username vazio -> usa DDI e username salvos. Sucesso: grava MD5 da nova senha; se for
     * convidado/deslogado faz login com a nova senha, senão só repassa.
     */
    fun resetPassword(username: String, digitalCode: String, newPassword: String, captchaCode: String): Flow<AuthResult> = flow {
        var dc = digitalCode
        var user = username
        if (user.isEmpty()) {
            localSessionInfo?.digitalCode?.let { dc = it }
            user = getUsername()
        }
        aaaAdapter.resetPassword(user, dc, newPassword, captchaCode).collect { r ->
            if (!r.first) { emit(r); return@collect }
            val digest = md5(newPassword)
            localSessionInfo?.passwordDigest = digest
            saveLocalSession()
            if (isGuestOrLoggedOut()) emitAll(aaaAdapter.login(user, digest, dc)) else emit(r)
        }
    }

    /** Original: f.N1(file) "uploadFeedbackFile". */
    fun uploadFeedbackFile(feedbackFile: File): Flow<FeedbackUploadResponse> = flow {
        emit(aaaAdapter.uploadFeedbackFile(feedbackFile))
    }

    /** Original: f.x0(isForce) "getReferralSummary" — cache 10 min (30 s se forçado). */
    fun getReferralSummary(isForce: Boolean): Flow<ReferralSummary?> {
        if (!BaseLibConfig.hasReferralSummary || !BaseLibConfig.displayMemberSite || getUsername().isEmpty()) {
            return flowOf(null) // Original: config.b.i() && config.b.f()
        }
        val age = TimeUtils.now() - lastQueryReferralSummaryTime
        val cached = referralSummary
        if (cached != null && !(isForce && age > 30000) && age <= 600000) return flowOf(cached)
        return flow {
            aaaAdapter.getReferralSummary().collect { r ->
                when {
                    r.first -> emit(referralSummary)
                    !isForce && referralSummary != null -> emit(referralSummary)
                    else -> throw Exception(r.third)
                }
            }
        }
    }

    /** Original: f.A1(ReferralSummary). */
    fun setReferralSummary(summary: ReferralSummary) {
        referralSummary = summary
        lastQueryReferralSummaryTime = TimeUtils.now()
    }

    // ---------------------------------------------------------------- mark / URLs

    /**
     * "mark" do dispositivo (calculado uma vez, no launch):
     * `AES-128/ECB/ZeroBytePadding( "tenantId:brandId:canal:appType:appId:accountId:did:appVersion",
     *  chave = AES-KeyGen(SHA1PRNG seed "*(^*&65Gikljio") )` em hex maiúsculo.
     * Original: f.s0(). Nenhum consumidor encontrado no código decompilado.
     */
    fun getMark(): String {
        if (mark == "") {
            val accountId = getAccountIdString()
            var key = markKey
            if (key == "") {
                key = MarkCipher.generateKeyHex("*(^*&65Gikljio")
                markKey = key
            }
            val plain = "${AppAttrUtils.tenantId}:${AppAttrUtils.brandId}:${AppAttrUtils.appDistributionChannel}:" +
                "${AppAttrUtils.appType}:${AppAttrUtils.appId}:$accountId:$did:${AppAttrUtils.appVersion}"
            mark = MarkCipher.encryptToHex(plain, key)
        }
        return mark
    }

    /** Original: f.t0(). */
    fun getMembershipUrl(): String = localSessionInfo?.memberShipUrl ?: ""

    /**
     * URL do QR code de assinatura: `memberShipUrl?t=<tenantId>&a=<accessToken>&d=<did>&l=<idioma>`.
     * Original: f.u0(). (Atenção: o access token vai em claro na URL do QR.)
     */
    fun getMembershipQrUrl(): String {
        val url = localSessionInfo?.memberShipUrl ?: return ""
        return url + "?t=" + HeaderInterceptor.tenantId() + "&a=" + localSessionInfo?.accessToken + "&d=" + getDid() + "&l=" + HeaderInterceptor.language()
    }

    // ---------------------------------------------------------------- lembretes de plano

    /** Original: f.B1(flag). */
    fun setRemindAfterExpired(remindFlag: Int) {
        isRemindAfterExpired = remindFlag
        Preferences.putInt("um_is_remind_after_plan_expired", remindFlag)
    }

    /** Original: f.C1(flag). */
    fun setRemindPlanNotBindUsername(remindFlag: Int) {
        isRemindPlanNotBindUsername = remindFlag
        Preferences.putInt("um_is_remind_plan_not_bind_username", remindFlag)
    }

    /** Original: f.z1(flag) — 1 = uma vez; >1 = a cada N horas. */
    fun setPlanWillExpireRemind(remindFlag: Int) {
        planWillExpireRemind = remindFlag
        if (remindFlag == 1) planWillExpireLastRemindTime = 0L
        else if (remindFlag > 1) planWillExpireLastRemindTime = planWillExpireRemindTimeInStartup
        Preferences.putInt("um_plan_will_expire_remind", remindFlag)
    }

    /** Original: f.d0() — deve avisar "plano expirado"? */
    fun shouldRemindAfterExpired(): Boolean {
        if (hasValidPlan()) return false
        val flag = isRemindAfterExpired
        if (flag == 1) {
            if (remindAfterExpiredLastRemindTime != 0L) return false
            isRemindAfterExpired = 0
            Preferences.putInt("um_is_remind_after_plan_expired", 0)
            val now = TimeUtils.now()
            remindAfterExpiredLastRemindTime = now
            Preferences.putLong("um_plan_last_remind_time", now)
            return true
        }
        return flag > 1
    }

    /** Original: f.e0() — deve avisar "plano vai expirar" (janela promptRenewMillis)? */
    fun shouldRemindPlanWillExpire(): Boolean {
        val now = TimeUtils.now()
        val exp = getExpireTs()
        if (HeartbeatManager.promptRenewMillis + now >= exp && now < exp) {
            val flag = planWillExpireRemind
            if (flag == 1) {
                if (planWillExpireLastRemindTime != 0L) return false
                planWillExpireLastRemindTime = now
                Preferences.putLong("um_plan_will_expire_last_remind_time", now)
                return true
            }
            if (flag > 1) {
                val diff = now - planWillExpireLastRemindTime
                if (diff > flag.toLong() * 3600000) {
                    planWillExpireLastRemindTime = now
                    Preferences.putLong("um_plan_will_expire_last_remind_time", now)
                    return true
                }
                if (diff < 0) {
                    planWillExpireLastRemindTime = 0L
                    Preferences.putLong("um_plan_will_expire_last_remind_time", 0L)
                }
            }
        }
        return false
    }

    // ---------------------------------------------------------------- consultas simples

    /** Original: f.z0(). */
    private fun getStreamServers(): List<ServerResponse> = localSessionInfo?.streamServers ?: ArrayList()

    /** Original: f.A0(). */
    fun getStreamToken(): String = localSessionInfo?.streamToken ?: ""

    /** Original: f.B0() (e C0(), idêntico). */
    fun getAccountIdString(): String = localSessionInfo?.accountId?.toString() ?: ""

    /** Original: f.b0(). */
    fun getAccessToken(): String = localSessionInfo?.accessToken ?: ""

    /** Original: f.y0(). */
    fun getRefreshToken(): String = localSessionInfo?.refreshToken ?: ""

    /** Original: f.i0(). */
    fun getCode(): String = localSessionInfo?.code ?: ""

    /** Original: f.j0(). */
    fun getDid(): String = did

    /** Original: f.k0(). */
    fun getEmail(): String = localSessionInfo?.email ?: ""

    /** Original: f.v0(). */
    fun getPhone(): String = localSessionInfo?.phone ?: ""

    /** Original: f.f0(). */
    fun getAppId(): String = AppAttrUtils.appId.toString()

    /** Original: f.D0() — username, senão email, senão telefone; "" se deslogado. */
    fun getUsername(): String {
        if (isLogoutOrKickedOut()) return ""
        val u = localSessionInfo?.username ?: ""
        if (u.isNotEmpty()) return u
        return getEmail().ifEmpty { getPhone() }
    }

    /** Original: f.c0(). */
    fun getAccountType(): String = if (localSessionInfo?.accountType == "normal") "normal" else "guest"

    /** Original: f.h0(). */
    private fun getPlanType(): String = if (hasValidPlan()) "plan" else "free"

    /** Original: f.m0() — maior expireTs das assinaturas. */
    fun getExpireTs(): Long {
        val list = localSessionInfo?.accountSubscriptionList ?: ArrayList()
        var max = 0L
        for (s in list) if (s.expireTs > max) max = s.expireTs
        if (!isGuestOrLoggedOut() && max == 0L) {
            val s = localSessionInfo
            logger.warn(
                "get user expired ts, atp[{}] ssz[{}] lgt[{}] ldt[{}] tut[{}] tk_exp[{}] tk[{}]",
                getAccountType(), list.size, s?.latestLoginResponseTime, s?.latestLocalLoadTime,
                s?.latestTokenUpdateTime, s?.accessTokenExpiresTS, s?.accessToken,
            )
        }
        return max
    }

    /** Original: f.l0() — data de expiração formatada (util/n.h(15, ts)). */
    fun getExpireDateString(): String = try {
        val ts = getExpireTs()
        if (ts == 0L) "" else CommonHelper.formatDate(15, ts)
    } catch (t: Throwable) { "" }

    /** Original: f.w0() — planLeftDays do servidor, senão calculado pelo expireTs. */
    fun getPlanLeftDays(): Int = try {
        val days = localSessionInfo?.planLeftDays?.let { runCatching { it.toInt() }.getOrDefault(-1) } ?: -1
        if (days != -1) days else {
            val now = TimeUtils.now()
            val exp = getExpireTs()
            if (exp != 0L && now <= exp) ((exp - now) / 86400000L).toInt() else 0
        }
    } catch (t: Throwable) { 0 }

    /** Original: f.n0() — ms restantes (plano + tempo grátis). */
    fun getRemainingMs(): Long {
        val left = (getExpireTs() - TimeUtils.now()).coerceAtLeast(0)
        return (localSessionInfo?.freeTimeMs ?: 0L) + left
    }

    /** Original: f.o0(). */
    fun getLatestLoginResponseTime(): Long = localSessionInfo?.latestLoginResponseTime ?: 0L

    /** Original: f.q0(). */
    fun getLoginSession(): Long = loginSession

    /** Original: f.r0(). */
    fun getKickedOutReason(): Int = localSessionInfo?.kickedOutReason ?: 0

    /** Original: f.Y() — 20 min em debug, senão HeartbeatManager.echoModeTime. */
    fun getEchoModeTime(): Long = if (BaseLibConfig.isDebug) 1200000L else HeartbeatManager.echoModeTime

    /** Original: f.Y0(ts). */
    private fun isExpired(ts: Long?): Boolean = ts != null && TimeUtils.now() > ts

    /** Original: f.I0() — sem access token ou expirado. */
    fun isAccessTokenExpired(): Boolean = getAccessToken().isEmpty() || isExpired(localSessionInfo?.accessTokenExpiresTS)

    /** Original: f.U0() — sem refresh token ou expirado. */
    private fun isRefreshTokenExpired(): Boolean = getRefreshToken().isEmpty() || isExpired(localSessionInfo?.refreshTokenExpiresTS)

    /** Original: f.G0(). */
    fun hasValidPlan(): Boolean = !(isLogoutOrKickedOut() || TimeUtils.now() > getExpireTs())

    /** Original: f.K0(). */
    fun hasUsername(): Boolean = getUsername().isNotEmpty()

    /** Original: f.M0(). */
    fun isGuestOrNoPlan(): Boolean = isGuestOrLoggedOut() || !hasValidPlan()

    /** Original: f.N0(). */
    fun isGuestOrFree(): Boolean = getAccountType() == "guest" || getPlanType() == "free"

    /** Original: f.O0(). */
    fun isGuestOrLoggedOut(): Boolean = isLogoutOrKickedOut() || getAccountType() == "guest"

    /** Original: f.S0(). */
    fun isAuthOk(): Boolean = !isLogoutOrKickedOut() && isAuthRetSuccess

    /** Original: f.T0(). */
    fun isLogoutOrKickedOut(): Boolean = localSessionInfo?.isLogout == true || localSessionInfo?.isKickedOut == true

    /** Original: f.W0(). */
    private fun isOutOfService(): Boolean = localSessionInfo?.isKickedOut == true || isSessionExpired.get()

    /** Original: f.J0(). */
    fun isAuthRetSuccess(): Boolean = isAuthRetSuccess

    /** Original: f.P0(). */
    fun isInLogout(): Boolean = isInLogout

    /** Original: f.V0(code). */
    fun isRenewCodeFirstLogin(code: String): Boolean = code == latestLoginRenewCode && isRenewCodeFirstLogin

    /** Original: f.L0(password) — confere senha local (MD5). */
    fun checkPassword(password: String): Boolean = md5(password) == localSessionInfo?.passwordDigest

    /** Original: f.p1(clearPassword) — util/n.o() = MD5 hex. */
    private fun md5(clearPassword: String): String = CommonHelper.md5(clearPassword)

    // ---------------------------------------------------------------- métricas

    /** Original: f.l1(msg) — monitor h.e(): s(now), t(msg), w(cnt+1). */
    private fun reportLoginFailureMetric(msg: String?) {
        MetricMonitors.current()?.recordLoginFailure(TimeUtils.now(), msg ?: "Unknown")
    }

    /** Original: f.L1(t) -> K1(msg) — monitor h.e(): p(msg), o(now), m(cnt+1). */
    private fun reportEngineFailureMetric(e: Throwable?) {
        val msg = e?.message ?: e?.cause?.message ?: e?.javaClass?.name ?: "Unknown Error"
        MetricMonitors.current()?.recordEngineFailure(TimeUtils.now(), msg)
    }
}
