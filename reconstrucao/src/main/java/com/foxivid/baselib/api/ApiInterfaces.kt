package com.foxivid.baselib.api

import com.foxivid.baselib.model.common.ApiResult
import com.foxivid.baselib.model.extra.ApiRequestBasic
import com.foxivid.baselib.model.extra.ApiResponseBasic
import com.foxivid.baselib.model.extra.LogoutRequest
import com.foxivid.baselib.model.extra.QueryPropertyRequest
import com.foxivid.baselib.model.extra.subscription.RechargeInfo
import com.foxivid.baselib.model.extra.subscription.RechargeRequest
import com.foxivid.baselib.model.extra.upgrade.UpgradeInfo
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
import com.foxivid.baselib.model.feedback.FeedbackUploadResponse
import com.foxivid.baselib.model.meta.CatchupPlayResponse
import com.foxivid.baselib.model.meta.ChannelListResponse
import com.foxivid.baselib.model.meta.MetaDetailResponse
import com.foxivid.baselib.model.ptv.referral.ReferralSummary
import com.foxivid.baselib.model.ptv.subscription.ChargeCodeRechargeRequest
import com.foxivid.baselib.model.ptv.user.PTVLoginInfo
import com.skydoves.sandwich.ApiResponse as NetResult
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query
import com.foxivid.baselib.model.extra.ApiResponse as ExtraResponse
import com.foxivid.baselib.model.ptv.ApiResponse as PtvResponse
import com.foxivid.baselib.model.ptv.user.RegisterRequest as PtvRegisterRequest
import com.foxivid.baselib.model.sports.DataVersion
import com.foxivid.baselib.model.sports.Matches
import com.foxivid.baselib.model.sports.Sports
import com.foxivid.baselib.model.sports.Tournaments

/*
 * Interfaces Retrofit. Mapeamento das anotações ofuscadas no descompilado:
 *   gf.o = @POST, gf.f = @GET, gf.k = @Headers, gf.a = @Body, gf.t = @Query, gf.s = @Path,
 *   gf.l = @Multipart, gf.q = @Part.
 * Retorno `com.skydoves.sandwich.a` = `com.skydoves.sandwich.ApiResponse` (aqui `NetResult`).
 * Todas as interfaces são servidas pelo cliente CIFRADO (ServerProvider.get), exceto
 * FeedbackApi, que usa o cliente simples (ServerProvider.getPlain).
 */

private const val JSON = "Content-Type: application/json;charset=UTF-8"

/**
 * API de conta "extra" (protocolo errCode numérico — model.extra).
 * Pool ACCOUNT_SERVERS. Original: x1/f1/lb/api/d.java.
 */
interface AccountApi {
    /** Original: d.c(). */
    @Headers(JSON) @POST("/api/v1/account/reset-password")
    suspend fun resetPassword(@Body request: ResetPasswordRequest): NetResult<ExtraResponse<String>>

    /** Original: d.d(). */
    @Headers(JSON) @POST("/api/v1/account/guest/login")
    suspend fun guestLogin(@Body request: GuestLoginRequest): NetResult<ExtraResponse<GuestLoginInfo>>

    /** Original: d.e(). */
    @Headers(JSON) @POST("/api/v1/account/app/property/query")
    suspend fun queryAppProperty(@Body request: QueryPropertyRequest): NetResult<ExtraResponse<QueryPropertiesInfo>>

    /** Original: d.f(). */
    @Headers(JSON) @POST("/api/v1/account/login")
    suspend fun login(@Body request: LoginRequest): NetResult<ExtraResponse<LoginInfo>>

    /** Original: d.g(). */
    @Headers(JSON) @POST("/api/v1/account/captcha/send")
    suspend fun sendVerificationCode(@Body request: VerificationCodeRequest): NetResult<ExtraResponse<String>>

    /** Original: d.h(). */
    @Headers(JSON) @POST("/api/v1/account/contact/link")
    suspend fun linkContact(@Body request: LinkRequest): NetResult<ExtraResponse<LoginInfo>>

    /** Original: d.i(). */
    @Headers(JSON) @POST("/api/v1/account/token/refresh")
    suspend fun refreshToken(@Body request: RefreshTokenRequest): NetResult<ExtraResponse<RefreshInfo>>

    /** Original: d.j(). */
    @Headers(JSON) @POST("/api/v1/account/logout")
    suspend fun logout(@Body request: LogoutRequest): NetResult<ApiResponseBasic>

    /** Original: d.k(). */
    @Headers(JSON) @POST("/api/v1/account/meta/info/query")
    suspend fun queryMetaInfo(@Body request: ApiRequestBasic): NetResult<ExtraResponse<QueryMetaInfo>>

    /** Original: d.l(). */
    @Headers(JSON) @POST("/api/v1/account/register")
    suspend fun register(@Body request: RegisterRequest): NetResult<ExtraResponse<RegisterInfo>>
}

/**
 * API de conta "PTV" (protocolo errCode string — model.ptv). É a usada pelo app (PTV3AAdapter).
 * Pool ACCOUNT_SERVERS. Original: x1/f1/lb/api/h.java.
 * Note que vários GETs carregam tokens em query — com a criptografia ligada eles viram X-Data.
 */
interface PtvAccountApi {
    /** Original: h.a(). */
    @Headers(JSON) @GET("/api/v1/account/logout")
    suspend fun logout(): NetResult<PtvResponse<Any>>

    /** Original: h.b(). */
    @Headers(JSON) @GET("/api/v1/account/loginByToken")
    suspend fun loginByToken(@Query("token") token: String): NetResult<PtvResponse<PTVLoginInfo>>

    /** Original: h.c(). */
    @Headers(JSON) @POST("/api/v1/account/reset-password")
    suspend fun resetPassword(@Body request: ResetPasswordRequest): NetResult<PtvResponse<Any>>

    /** Original: h.d(). */
    @Headers(JSON) @GET("/api/v1/account/token/refresh")
    suspend fun refreshToken(@Query("refreshToken") refreshToken: String): NetResult<PtvResponse<PTVLoginInfo>>

    /** Original: h.e() — POST sem corpo. */
    @Headers(JSON) @POST("/api/v1/account/guest/login")
    suspend fun guestLogin(): NetResult<PtvResponse<PTVLoginInfo>>

    /** Original: h.f() — id = tenantId (ver PTVApi3AClient.queryMetaInfo). */
    @Headers(JSON) @GET("/api/info/{id}")
    suspend fun queryInfo(@Path("id") id: String): NetResult<PtvResponse<Any>>

    /** Original: h.g(). */
    @Headers(JSON) @POST("/api/v1/account/register")
    suspend fun register(@Body request: PtvRegisterRequest): NetResult<PtvResponse<PTVLoginInfo>>

    /** Original: h.h(). */
    @Headers(JSON) @GET("/api/v1/referral/summary")
    suspend fun referralSummary(): NetResult<PtvResponse<ReferralSummary>>

    /** Original: h.i(). */
    @Headers(JSON) @POST("/api/v1/account/recharge")
    suspend fun recharge(@Body request: ChargeCodeRechargeRequest): NetResult<PtvResponse<PTVLoginInfo>>

    /** Original: h.j(). */
    @Headers(JSON) @POST("/api/v1/account/captcha/send")
    suspend fun sendCaptcha(@Body request: VerificationCodeRequest): NetResult<PtvResponse<Any>>

    /** Original: h.k(). */
    @Headers(JSON) @GET("/api/v1/upgrade/config")
    suspend fun upgradeConfig(): NetResult<PtvResponse<UpgradeInfo>>

    /** Original: h.l(). */
    @Headers(JSON) @POST("/api/v1/account/login")
    suspend fun login(@Body request: LoginRequest): NetResult<PtvResponse<PTVLoginInfo>>
}

/**
 * Recarga por código (protocolo extra). Pool ACCOUNT_SERVERS. Original: x1/f1/lb/api/m.java.
 */
interface RechargeApi {
    /** Original: m.a(). */
    @Headers(JSON) @POST("/api/v1/account/code/recharge")
    suspend fun recharge(@Body request: RechargeRequest): NetResult<ExtraResponse<RechargeInfo>>
}

/**
 * Upload de feedback (logcat .gz) — multipart, cliente sem criptografia.
 * Pool FEEDBACK_SERVERS. Original: x1/f1/lb/api/e.java.
 */
interface FeedbackApi {
    /** Original: e.a(). */
    @Multipart @POST("/api/feedback/upload/v1")
    suspend fun upload(
        @Part("tenantId") tenantId: RequestBody,
        @Part("uid") uid: RequestBody,
        @Part("did") did: RequestBody,
        @Part("requestTime") requestTime: RequestBody,
        @Part file: MultipartBody.Part,
    ): FeedbackUploadResponse
}

/**
 * Metadados de streaming (canais ao vivo, VOD, catch-up). Autenticação por query (token/checksum),
 * sem cabeçalhos X-Foxivid-*. Pool STREAM_META_SERVERS. Original: x1/f1/lb/api/l.java.
 */
interface StreamMetaApi {
    /** Original: l.a() — variante antiga da lista de canais. */
    @GET("/api/meta/channel/list/v1")
    suspend fun getMetaChannelList(
        @Query("did") did: String, @Query("uid") uid: String, @Query("appId") appId: String,
        @Query("appVer") appVer: Long, @Query("requestTime") requestTime: Long,
        @Query("token") token: String, @Query("pageId") pageId: Int, @Query("pageSize") pageSize: Int,
        @Query("checksum") checksum: String,
    ): NetResult<ApiResult<ChannelListResponse>>

    /** Original: l.b(). */
    @GET("/api/vod/videoDetail/get/v1")
    suspend fun getVideoDetail(
        @Query("tenantId") tenantId: String, @Query("appId") appId: String, @Query("appVer") appVer: Long,
        @Query("did") did: String, @Query("language") language: String, @Query("metaId") metaId: String,
        @Query("pageId") pageId: Int, @Query("pageSize") pageSize: Int, @Query("requestTime") requestTime: Long,
        @Query("token") token: String, @Query("uid") uid: String,
    ): NetResult<ApiResult<MetaDetailResponse>>

    /** Original: l.c(). */
    @GET("/api/live/channel/list/v1")
    suspend fun getLiveChannelList(
        @Query("tenantId") tenantId: String, @Query("appId") appId: String, @Query("appVer") appVer: Long,
        @Query("checksum") checksum: String, @Query("did") did: String, @Query("language") language: String,
        @Query("pageId") pageId: Int, @Query("pageSize") pageSize: Int, @Query("requestTime") requestTime: Long,
        @Query("token") token: String, @Query("uid") uid: String,
    ): NetResult<ApiResult<ChannelListResponse>>

    /** Original: l.d(). */
    @GET("/api/catchup/getPlayUrl/v1")
    suspend fun getCatchupPlayUrl(
        @Query("tenantId") tenantId: String, @Query("appId") appId: String, @Query("appVer") appVer: Long,
        @Query("checksum") checksum: String, @Query("did") did: String, @Query("language") language: String,
        @Query("pageId") pageId: Int, @Query("pageSize") pageSize: Int, @Query("requestTime") requestTime: Long,
        @Query("token") token: String, @Query("uid") uid: String,
        @Query("streamId") streamId: String, @Query("catchupRoute") catchupRoute: String,
        @Query("catchupStreamId") catchupStreamId: String,
        @Query("startTimestamp") startTimestamp: Long, @Query("endTimestamp") endTimestamp: Long,
    ): NetResult<ApiResult<CatchupPlayResponse>>
}

/** Agenda esportiva. Pool SPORTS_SERVERS. Original: x1/f1/lb/api/j.java. */
interface SportsApi {
    /** Original: j.a(). */
    @Headers(JSON) @GET("/api/v1/sports/home")
    suspend fun sportsHome(): NetResult<Sports>

    /** Original: j.b(). */
    @Headers(JSON) @GET("/api/v1/tournaments/{tournamentId}/matches")
    suspend fun matches(@Path("tournamentId") tournamentId: String, @Query("date") date: String): NetResult<Matches>

    /** Original: j.c(). */
    @Headers(JSON) @GET("/api/v1/data/version")
    suspend fun dataVersion(@Query("lastVersion") lastVersion: String): NetResult<DataVersion>

    /** Original: j.d(). */
    @Headers(JSON) @GET("/api/v1/sports/{sportId}/tournaments")
    suspend fun tournaments(@Path("sportId") sportId: String): NetResult<Tournaments>
}

/**
 * Interface VAZIA no APK (métodos removidos pelo R8). Usada como "heartbeatServerProvider"
 * (pool ACCOUNT_SERVERS) em Api3AClient/PTVApi3AClient. Nome inventado. Original: x1/f1/lb/api/f.java.
 */
interface AccountAuxApi

/** Interface VAZIA no APK; "noticeServerProvider", pool MESSAGE_CENTER_SERVERS. Original: x1/f1/lb/api/g.java. */
interface MessageApi

/** Interface VAZIA no APK; "upgradeServerProvider", pool UPGRADE_SERVERS. Original: x1/f1/lb/api/n.java. */
interface UpgradeApi
