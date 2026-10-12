package com.foxivid.baselib.api

import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.host.ServerProviderUtils
import com.foxivid.baselib.model.common.ApiResult
import com.foxivid.baselib.model.extra.ApiRequestBasic
import com.foxivid.baselib.model.extra.ApiResponseBasic
import com.foxivid.baselib.model.extra.LogoutRequest
import com.foxivid.baselib.model.extra.QueryPropertyRequest
import com.foxivid.baselib.model.extra.subscription.RechargeInfo
import com.foxivid.baselib.model.extra.subscription.RechargeRequest
import com.foxivid.baselib.model.extra.user.GuestLoginInfo
import com.foxivid.baselib.model.extra.user.GuestLoginRequest
import com.foxivid.baselib.model.extra.user.LinkRequest
import com.foxivid.baselib.model.extra.user.LoginInfo
import com.foxivid.baselib.model.extra.user.LoginRequest
import com.foxivid.baselib.model.extra.user.QueryMetaInfo
import com.foxivid.baselib.model.extra.user.QueryPropertiesInfo
import com.foxivid.baselib.model.extra.user.RefreshInfo
import com.foxivid.baselib.model.extra.user.RefreshTokenRequest
import com.foxivid.baselib.model.extra.user.RegisterInfo
import com.foxivid.baselib.model.extra.user.RegisterRequest
import com.foxivid.baselib.model.extra.user.ResetPasswordRequest
import com.foxivid.baselib.model.extra.user.VerificationCodeRequest
import com.foxivid.baselib.model.meta.CatchupPlayRequest
import com.foxivid.baselib.model.meta.CatchupPlayResponse
import com.foxivid.baselib.model.meta.ChannelListResponse
import com.foxivid.baselib.model.meta.MetaDetailResponse
import com.skydoves.sandwich.ApiResponse as NetResult
import com.skydoves.sandwich.retry.RetryPolicy
import com.skydoves.sandwich.retry.runAndRetry
import org.slf4j.LoggerFactory
import com.foxivid.baselib.model.extra.ApiResponse as ExtraResponse

/**
 * Política de retry idêntica em todos os clientes: até 3 tentativas (attempt <= 3), 3000 ms entre elas.
 * Original: api/a$a, api/b$a, api/c$a, api/i$u, api/k$i (classes idênticas).
 */
internal object DefaultRetryPolicy : RetryPolicy {
    override fun shouldRetry(attempt: Int, message: String?): Boolean = attempt <= 3
    override fun retryTimeout(attempt: Int, message: String?): Int = 3000
}

/**
 * Cliente da API de conta "extra" (AccountApi). Cada chamada roda em `runAndRetry` e pede ao
 * ServerProvider a interface correspondente ao nº da tentativa (failover a partir da 2ª).
 * Se a interface vier nula, lança NullPointerException("<nome> api service is null").
 *
 * Original: x1/f1/lb/api/a.java (`Api3AClient.kt`); lambdas `Api3AClient$<metodo>$2` = a$b..a$k.
 */
object Api3AClient {
    private val logger = LoggerFactory.getLogger(Api3AClient::class.java)

    private val authServerProvider = ServerProviderUtils.accountApi()
    private val heartbeatServerProvider = ServerProviderUtils.accountAuxApi() // não usado
    private val upgradeServerProvider = ServerProviderUtils.upgradeApi()      // não usado
    private val noticeServerProvider = ServerProviderUtils.messageApi()       // não usado
    private val feedbackServerProvider = ServerProviderUtils.feedbackApi()    // não usado

    private suspend fun <T> call(
        logName: String, npeName: String, block: suspend (AccountApi) -> NetResult<T>,
    ): NetResult<T> = runAndRetry(DefaultRetryPolicy) { attempt, reason ->
        if (BaseLibConfig.isDebug) logger.debug("$logName, request[ {}, {} ]", attempt, reason)
        val api = authServerProvider.get(attempt) ?: throw NullPointerException("$npeName api service is null")
        block(api)
    }

    /** Original: a.h(). */
    suspend fun queryMetaInfo(): NetResult<ExtraResponse<QueryMetaInfo>> =
        call("query meta info", "queryMetaInfo") { it.queryMetaInfo(ApiRequestBasic()) }

    /** Original: a.c(accountId, accountName). */
    suspend fun guestLogin(accountId: Long?, accountName: String?): NetResult<ExtraResponse<GuestLoginInfo>> =
        call("guest login", "guestLogin") { it.guestLogin(GuestLoginRequest(accountId, accountName)) }

    /** Original: a.e(loginRequest). */
    suspend fun loginExtra(loginRequest: LoginRequest): NetResult<ExtraResponse<LoginInfo>> =
        call("login extra", "loginExtra") { it.login(loginRequest) }

    /** Original: a.g(). */
    suspend fun queryAppProperty(): NetResult<ExtraResponse<QueryPropertiesInfo>> =
        call("query app property", "queryAppProperty") { it.queryAppProperty(QueryPropertyRequest()) }

    /** Original: a.i(refreshToken). */
    suspend fun refreshToken(refreshToken: String): NetResult<ExtraResponse<RefreshInfo>> =
        call("refresh token", "refreshToken") { it.refreshToken(RefreshTokenRequest(refreshToken)) }

    /** emailType fixo "". Original: a.m(contact, digitalCode). */
    suspend fun sendVerificationCode(contact: String, digitalCode: String): NetResult<ExtraResponse<String>> =
        call("sendVerificationCode", "sendVerificationCode") { it.sendVerificationCode(VerificationCodeRequest(contact, digitalCode, "")) }

    /** Original: a.j(...) (+ a.k com invitationCode = "" por padrão). */
    suspend fun register(
        username: String, password: String, verificationCode: String, invitationCode: String = "",
    ): NetResult<ExtraResponse<RegisterInfo>> =
        call("register", "register") { it.register(RegisterRequest(username, password, verificationCode, invitationCode)) }

    /** Original: a.l(...). */
    suspend fun resetPassword(
        username: String, digitalCode: String, newPassword: String, captchaCode: String,
    ): NetResult<ExtraResponse<String>> =
        call("resetPassword", "resetPassword") { it.resetPassword(ResetPasswordRequest(username, digitalCode, newPassword, captchaCode)) }

    /** Original: a.f(). */
    suspend fun logout(): NetResult<ApiResponseBasic> =
        call("logout", "user extra") { it.logout(LogoutRequest()) }

    /** Original: a.d(contact, digitalCode, password, verificationCode). */
    suspend fun linkContact(
        contact: String, digitalCode: String, password: String, verificationCode: String,
    ): NetResult<ExtraResponse<LoginInfo>> =
        call("linkContact", "linkContact") { it.linkContact(LinkRequest(contact, digitalCode, password, verificationCode)) }
}

/**
 * Cliente de metadados de streaming (StreamMetaApi).
 * Original: x1/f1/lb/api/b.java (`ApiStreamMetaClient.kt`).
 */
object ApiStreamMetaClient {
    private val logger = LoggerFactory.getLogger(ApiStreamMetaClient::class.java)
    private val streamMetaApiServerProvider = ServerProviderUtils.streamMetaApi()

    private fun api(attempt: Int, npe: String): StreamMetaApi =
        streamMetaApiServerProvider.get(attempt) ?: throw NullPointerException("$npe api service is null")

    /** Variante "meta" (antiga). Original: b.d(...) / lambda b$b (`getChannelList$2`). */
    suspend fun getChannelList(
        did: String, uid: String, appId: String, appVer: Long, requestTime: Long,
        token: String, checksum: String, pageId: Int, pageSize: Int,
    ): NetResult<ApiResult<ChannelListResponse>> = runAndRetry(DefaultRetryPolicy) { attempt, reason ->
        if (BaseLibConfig.isDebug) logger.debug("get channel list request[{},{}]", attempt, reason)
        api(attempt, "channel").getMetaChannelList(did, uid, appId, appVer, requestTime, token, pageId, pageSize, checksum)
    }

    /** Lista de canais ao vivo. Original: b.c(...) / lambda b$c (`getChannelList$4`). */
    suspend fun getChannelList(
        tenantId: String, appId: String, appVer: Long, checksum: String, did: String, language: String,
        pageId: Int, pageSize: Int, requestTime: Long, token: String, uid: String,
    ): NetResult<ApiResult<ChannelListResponse>> = runAndRetry(DefaultRetryPolicy) { attempt, reason ->
        if (BaseLibConfig.isDebug) logger.debug("get channel list request[{},{}]", attempt, reason)
        api(attempt, "channel").getLiveChannelList(tenantId, appId, appVer, checksum, did, language, pageId, pageSize, requestTime, token, uid)
    }

    /** URL de catch-up. Original: b.e(...) / lambda b$d (`getPlayUrl$2`). */
    suspend fun getPlayUrl(
        tenantId: String, appId: String, appVer: Long, checksum: String, did: String, language: String,
        pageId: Int, pageSize: Int, requestTime: Long, token: String, uid: String, request: CatchupPlayRequest,
    ): NetResult<ApiResult<CatchupPlayResponse>> = runAndRetry(DefaultRetryPolicy) { attempt, reason ->
        if (BaseLibConfig.isDebug) logger.debug("get play url request[{},{}]", attempt, reason)
        api(attempt, "channel").getCatchupPlayUrl(
            tenantId, appId, appVer, checksum, did, language, pageId, pageSize, requestTime, token, uid,
            request.streamId!!, request.catchupRoute!!, request.catchupStreamId!!,
            request.startTimestamp, request.endTimestamp,
        )
    }

    /** Detalhe de VOD. Original: b.f(...) / lambda b$e (`getVideoDetail$2`). */
    suspend fun getVideoDetail(
        tenantId: String, appId: String, appVer: Long, did: String, language: String, metaId: String,
        pageId: Int, pageSize: Int, requestTime: Long, token: String, uid: String,
    ): NetResult<ApiResult<MetaDetailResponse>> = runAndRetry(DefaultRetryPolicy) { attempt, reason ->
        if (BaseLibConfig.isDebug) logger.debug("vod_api get vod detail request[$attempt,$reason]")
        api(attempt, "vod detail").getVideoDetail(tenantId, appId, appVer, did, language, metaId, pageId, pageSize, requestTime, token, uid)
    }
}

/**
 * Recarga por código (protocolo extra). Original: x1/f1/lb/api/c.java (`ApiSubscriptionClient.kt`).
 */
object ApiSubscriptionClient {
    private val logger = LoggerFactory.getLogger(ApiSubscriptionClient::class.java)
    private val rechargeApiServerProvider = ServerProviderUtils.rechargeApi()

    /** Original: c.c(code). */
    suspend fun recharge(code: String): NetResult<ExtraResponse<RechargeInfo>> =
        runAndRetry(DefaultRetryPolicy) { attempt, reason ->
            if (BaseLibConfig.isDebug) logger.debug("recharge, request[ {}, {} ]", attempt, reason)
            val api = rechargeApiServerProvider.get(attempt) ?: throw NullPointerException("recharge api service is null")
            api.recharge(RechargeRequest(code))
        }
}
