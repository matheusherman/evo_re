package com.foxivid.baselib.api

import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.config.TimeUtilsRef
import com.foxivid.baselib.config.UserManagerRef
import com.foxivid.baselib.host.ServerProviderUtils
import com.foxivid.baselib.model.extra.upgrade.UpgradeInfo
import com.foxivid.baselib.model.extra.user.LoginRequest
import com.foxivid.baselib.model.extra.user.ResetPasswordRequest
import com.foxivid.baselib.model.extra.user.VerificationCodeRequest
import com.foxivid.baselib.model.feedback.FeedbackUploadResponse
import com.foxivid.baselib.model.ptv.ApiResponse
import com.foxivid.baselib.model.ptv.referral.ReferralSummary
import com.foxivid.baselib.model.ptv.subscription.ChargeCodeRechargeRequest
import com.foxivid.baselib.model.ptv.user.PTVLoginInfo
import com.foxivid.baselib.model.ptv.user.RegisterRequest
import com.foxivid.baselib.model.sports.DataVersion
import com.foxivid.baselib.model.sports.Matches
import com.foxivid.baselib.model.sports.Sports
import com.foxivid.baselib.model.sports.Tournaments
import com.foxivid.baselib.network.HeaderInterceptor
import com.skydoves.sandwich.ApiResponse as NetResult
import com.skydoves.sandwich.retry.runAndRetry
import java.io.File
import java.util.concurrent.atomic.AtomicInteger
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.slf4j.LoggerFactory

/**
 * Cliente da API de conta PTV (a efetivamente usada pelo app via PTV3AAdapter).
 *
 * Original: x1/f1/lb/api/i.java (`PTVApi3AClient.kt`); lambdas `PTVApi3AClient$<m>$response$1`.
 *
 * Diferenças para [Api3AClient]: todo erro (inclusive o NPE de "service is null") é capturado
 * e convertido em `ApiResponse.Failure.Exception` (Original: `com.skydoves.sandwich.a.INSTANCE.a(th)`);
 * login/logout/refresh registram tempo, nº de sequência e tokens atuais em log (info).
 */
object PTVApi3AClient {
    private val logger = LoggerFactory.getLogger(PTVApi3AClient::class.java)

    private val authServerProvider = ServerProviderUtils.ptvAccountApi()
    private val heartbeatServerProvider = ServerProviderUtils.accountAuxApi() // não usado
    private val upgradeServerProvider = ServerProviderUtils.upgradeApi()      // não usado
    private val noticeServerProvider = ServerProviderUtils.messageApi()       // não usado
    private val feedbackServerProvider = ServerProviderUtils.feedbackApi()

    /** Contador de logins (só para log). Original: `loginSeq`. */
    private val loginSeq = AtomicInteger(0)

    /** Texto de estado da conexão (mostrado em telas de diagnóstico). Original: `state` (getState/setState). */
    var state: String? = null

    private suspend fun <T> retry(
        logName: String, npe: String = "user", block: suspend (PtvAccountApi) -> NetResult<T>,
    ): NetResult<T> = runAndRetry(DefaultRetryPolicy) { attempt, reason ->
        if (BaseLibConfig.isDebug) logger.debug("$logName, request[ {}, {} ]", attempt, reason)
        val api = authServerProvider.get(attempt) ?: throw NullPointerException("$npe api service is null")
        block(api)
    }

    private fun tokens() = arrayOf(UserManagerRef.accessToken(), UserManagerRef.refreshToken(), UserManagerRef.streamToken())

    /**
     * Consulta GET /api/info/{tenantId} e atualiza [state] ("Connected"/"Disconnected" + duração).
     * Original: i.h(). Obs.: o formato de log tem 6 `{}` e só 5 argumentos (como no original).
     */
    suspend fun queryMetaInfo(): NetResult<ApiResponse<Any>> {
        val begin = TimeUtilsRef.elapsed()
        return try {
            val result = retry("query meta info") { it.queryInfo(HeaderInterceptor.tenantId().toString()) }
            val (act, rft, stt) = tokens()
            logger.info("api:query meta info[{}ms] seq[{}] act[{}] rft[{}] stt[{}], ret[{}]",
                TimeUtilsRef.elapsed() - begin, loginSeq.get(), act, rft, stt)
            state = ResRef.string("pass", "Connected") + " (" + ResRef.duration(TimeUtilsRef.elapsed() - begin) + ")"
            result
        } catch (th: Throwable) {
            val cost = TimeUtilsRef.elapsed() - begin
            state = (ResRef.string("fail", "Disconnected") + " (" + th.javaClass.simpleName + ")") +
                " (" + ResRef.duration(cost) + ")"
            NetResult.exception(th)
        }
    }

    /** Original: i.d(). */
    suspend fun guestLogin(): NetResult<ApiResponse<PTVLoginInfo>> = try {
        val begin = TimeUtilsRef.elapsed()
        runAndRetry(DefaultRetryPolicy) { attempt, reason ->
            if (BaseLibConfig.isDebug) logger.debug("guestLogin, request[ {}, {} ]", attempt, reason)
            val api = authServerProvider.get(attempt) ?: throw NullPointerException("user api service is null")
            val r = api.guestLogin()
            val (act, rft, stt) = tokens()
            logger.info("api: guest login [{}ms] seq[{}] act[{}] rft[{}] stt[{}]",
                TimeUtilsRef.elapsed() - begin, loginSeq.getAndIncrement(), act, rft, stt)
            r
        }
    } catch (th: Throwable) { NetResult.exception(th) }

    /** Login por token. Original: i.f(token). */
    suspend fun login(token: String): NetResult<ApiResponse<PTVLoginInfo>> = try {
        val begin = TimeUtilsRef.elapsed()
        runAndRetry(DefaultRetryPolicy) { attempt, reason ->
            if (BaseLibConfig.isDebug) logger.debug("login[{}], request[ {}, {} ]", token, attempt, reason)
            val api = authServerProvider.get(attempt) ?: throw NullPointerException("user api service is null")
            val r = api.loginByToken(token)
            val (act, rft, stt) = tokens()
            logger.info("api:login by token[{}ms] seq[{}] token[{}] act[{}] rft[{}] stt[{}]",
                TimeUtilsRef.elapsed() - begin, loginSeq.getAndIncrement(), token, act, rft, stt)
            r
        }
    } catch (th: Throwable) { NetResult.exception(th) }

    /** Login por usuário/senha (senha já em digest). Original: i.e(username, passwordDigest, digitalCode). */
    suspend fun login(username: String, passwordDigest: String, digitalCode: String): NetResult<ApiResponse<PTVLoginInfo>> = try {
        val begin = TimeUtilsRef.elapsed()
        val r = runAndRetry(DefaultRetryPolicy) { attempt, reason ->
            if (BaseLibConfig.isDebug) logger.debug("login[{}], request[ {}, {} ]", username, attempt, reason)
            val api = authServerProvider.get(attempt) ?: throw NullPointerException("user api service is null")
            api.login(LoginRequest(username, passwordDigest, digitalCode))
        }
        val (act, rft, stt) = tokens()
        logger.info("api:login by username[{}ms] username[{}] seq[{}] act[{}] rft[{}] stt[{}]",
            TimeUtilsRef.elapsed() - begin, username, loginSeq.getAndIncrement(), act, rft, stt)
        r
    } catch (th: Throwable) { NetResult.exception(th) }

    /** Original: i.l(registerRequest). */
    suspend fun register(registerRequest: RegisterRequest): NetResult<ApiResponse<PTVLoginInfo>> = try {
        runAndRetry(DefaultRetryPolicy) { attempt, reason ->
            if (BaseLibConfig.isDebug) logger.debug("register[{}], request[ {}, {} ]", registerRequest, attempt, reason)
            val api = authServerProvider.get(attempt) ?: throw NullPointerException("user api service is null")
            api.register(registerRequest)
        }
    } catch (th: Throwable) { NetResult.exception(th) }

    /** Original: i.m(userName, digitalCode, newPassword, captchaCode). */
    suspend fun resetPassword(userName: String, digitalCode: String, newPassword: String, captchaCode: String): NetResult<ApiResponse<Any>> = try {
        retry("reset password") { it.resetPassword(ResetPasswordRequest(userName, digitalCode, newPassword, captchaCode)) }
    } catch (th: Throwable) { NetResult.exception(th) }

    /** actionType vai no campo `emailType`. Original: i.n(contact, digitalCode, actionType). */
    suspend fun sendCaptcha(contact: String, digitalCode: String, actionType: String): NetResult<ApiResponse<Any>> = try {
        retry("send captcha") { it.sendCaptcha(VerificationCodeRequest(contact, digitalCode, actionType)) }
    } catch (th: Throwable) { NetResult.exception(th) }

    /** Original: i.i(code). */
    suspend fun recharge(code: String): NetResult<ApiResponse<PTVLoginInfo>> = try {
        retry("recharge") { it.recharge(ChargeCodeRechargeRequest(code)) }
    } catch (th: Throwable) { NetResult.exception(th) }

    /** Original: i.o(). */
    suspend fun upgrade(): NetResult<ApiResponse<UpgradeInfo>> = try {
        retry("upgrade", npe = "upgrade") { it.upgradeConfig() }
    } catch (th: Throwable) { NetResult.exception(th) }

    /**
     * Original: i.k(token). Obs.: argumentos do log fora de ordem em relação ao formato (como no original).
     */
    suspend fun refresh(token: String): NetResult<ApiResponse<PTVLoginInfo>> = try {
        val begin = TimeUtilsRef.elapsed()
        val r = retry("refresh") { it.refreshToken(token) }
        val (act, rft, stt) = tokens()
        logger.info("api:refresh[{}ms] seq[{}], token[{}] act[{}] rft[{}], stt[{}]",
            TimeUtilsRef.elapsed() - begin, token, loginSeq.get(), act, rft, stt)
        r
    } catch (th: Throwable) { NetResult.exception(th) }

    /** Original: i.g(). */
    suspend fun logout(): NetResult<ApiResponse<Any>> = try {
        val begin = TimeUtilsRef.elapsed()
        val r = retry("logout") { it.logout() }
        val (act, rft, stt) = tokens()
        logger.info("api:logout[{}ms] seq[{}], act[{}], rft[{}], stt[{}]",
            TimeUtilsRef.elapsed() - begin, loginSeq.get(), act, rft, stt)
        r
    } catch (th: Throwable) { NetResult.exception(th) }

    /** Original: i.j(). */
    suspend fun referralSummary(): NetResult<ApiResponse<ReferralSummary>> = try {
        retry("referral summary", npe = "referral summary") { it.referralSummary() }
    } catch (th: Throwable) { NetResult.exception(th) }

    /**
     * Envia o logcat compactado. Arquivo: "<tenantId>_<accountId>_<did>_<now>_logcat.gz";
     * campos de texto `text/plain`, arquivo `application/gzip`, cliente SEM criptografia,
     * failover forçado (getPlain(1)). Sem serviço/resposta nula -> FeedbackUploadResponse("-1", "", null).
     * Original: i.p(feedbackFile).
     */
    suspend fun uploadFeedbackFile(feedbackFile: File): FeedbackUploadResponse {
        val tenantId = HeaderInterceptor.tenantId().toString()
        val uid = HeaderInterceptor.accountId()
        val did = HeaderInterceptor.deviceId()
        val requestTime = TimeUtilsRef.now().toString()
        val fileName = tenantId + "_" + uid + "_" + did + "_" + requestTime + "_logcat.gz"
        val text = "text/plain".toMediaType() // ContentTypes.DOC_MIME_TYPE
        val part = MultipartBody.Part.createFormData("file", fileName, feedbackFile.asRequestBody("application/gzip".toMediaType()))
        val api = feedbackServerProvider.getPlain(1)
        val resp = api?.upload(tenantId.toRequestBody(text), uid.toRequestBody(text), did.toRequestBody(text),
            requestTime.toRequestBody(text), part)
        return resp ?: FeedbackUploadResponse("-1", "", null)
    }
}

/**
 * Cliente da agenda esportiva. Erros -> `ApiResponse.Failure.Exception`.
 * Original: x1/f1/lb/api/k.java (`SportsApiClient.kt`).
 */
object SportsApiClient {
    private val logger = LoggerFactory.getLogger(SportsApiClient::class.java)
    private val sportsServerProvider = ServerProviderUtils.sportsApi()

    private suspend fun <T> retry(logLine: (Int, String?) -> Unit, block: suspend (SportsApi) -> NetResult<T>) =
        runAndRetry(DefaultRetryPolicy) { attempt, reason ->
            if (BaseLibConfig.isDebug) logLine(attempt, reason)
            val api = sportsServerProvider.get(attempt) ?: throw NullPointerException("sports api service is null")
            block(api)
        }

    /** Original: k.c(lastVersion). Log de duração só em debug. */
    suspend fun queryDataVersion(lastVersion: String): NetResult<DataVersion> = try {
        val begin = TimeUtilsRef.elapsed()
        val r = retry({ a, r -> logger.debug("query data version, request[ {}, {} ]", a, r) }) { it.dataVersion(lastVersion) }
        if (BaseLibConfig.isDebug) logger.debug("api:query data version [{}ms]", TimeUtilsRef.elapsed() - begin)
        r
    } catch (th: Throwable) { NetResult.exception(th) }

    /** Original: k.e(). */
    suspend fun querySports(): NetResult<Sports> = try {
        val begin = TimeUtilsRef.elapsed()
        val r = retry({ a, r -> logger.debug("query sports, request[ {}, {} ]", a, r) }) { it.sportsHome() }
        logger.info("api:query sports [{}ms]", TimeUtilsRef.elapsed() - begin)
        r
    } catch (th: Throwable) { NetResult.exception(th) }

    /** Original: k.f(sportId). */
    suspend fun queryTournaments(sportId: String): NetResult<Tournaments> = try {
        val begin = TimeUtilsRef.elapsed()
        val r = retry({ a, r -> logger.debug("query tournament, request[ {}, {}, {} ]", a, r, sportId) }) { it.tournaments(sportId) }
        logger.info("api:query tournament [{}ms]", TimeUtilsRef.elapsed() - begin)
        r
    } catch (th: Throwable) { NetResult.exception(th) }

    /** Original: k.d(tournamentId, date). */
    suspend fun queryMatches(tournamentId: String, date: String): NetResult<Matches> = try {
        val begin = TimeUtilsRef.elapsed()
        val r = retry({ a, r -> logger.debug("query matches, request[ {}, {} ]", a, r) }) { it.matches(tournamentId, date) }
        logger.info("api:query matches [{}ms]", TimeUtilsRef.elapsed() - begin)
        r
    } catch (th: Throwable) { NetResult.exception(th) }
}

/** Pontes para util/u0 (strings de recurso com fallback) e util/d1.b (formatar duração). */
internal object ResRef {
    /** Original: u0.a(R.string.<name>, dft). */
    fun string(resName: String, dft: String): String = TODO("outro módulo: util/u0.a(R.string.$resName, \"$dft\")")
    /** Original: d1.b(ms, null). */
    fun duration(ms: Long): String = TODO("outro módulo: util/d1.b(ms, null)")
}
