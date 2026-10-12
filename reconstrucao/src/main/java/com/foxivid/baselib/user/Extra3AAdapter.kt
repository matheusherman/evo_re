package com.foxivid.baselib.user

import com.foxivid.baselib.api.Api3AClient
import com.foxivid.baselib.api.ApiSubscriptionClient
import com.foxivid.baselib.heartbeat.HeartbeatManager
import com.foxivid.baselib.model.extra.ApiResponse
import com.foxivid.baselib.model.extra.ApiResponseBasic
import com.foxivid.baselib.model.extra.user.LoginRequest
import com.foxivid.baselib.model.extra.user.QueryMetaInfo
import com.foxivid.baselib.model.extra.user.QueryPropertiesInfo
import com.foxivid.baselib.model.feedback.FeedbackUploadResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.io.File
import com.skydoves.sandwich.ApiResponse as SandwichResponse

/**
 * Adapter de autenticação para o backend "Extra" (alternativo).
 *
 * Original: x1/f1/lb/user/c.java (Kotlin: Extra3AAdapter.kt)
 *
 * É instanciado em [AAAAdapterFactory] mas **não** é retornado por `getAdapter()` no código
 * decompilado — provavelmente legado ou usado por outra variante do app. Usa
 * `Api3AClient` (Original: x1/f1/lb/api/a.java) e `ApiSubscriptionClient` (x1/f1/lb/api/c.java),
 * com modelos de `z1/b1/lb/m/extra/...`. O par callApi (c$a/c$b) é idêntico ao de [PTV3AAdapter]
 * (mesma lógica Sandwich), por isso aqui só se documenta a delegação.
 */
class Extra3AAdapter : AccountAdapter<ApiResponse<*>> {

    /** Original: c.s(String) — MD5. */
    private fun md5(clear: String): String = TODO("util/n.n().o(clear)")

    /** Original: c.p(response) — igual a PTV3AAdapter.callApi(básico), com modelos extra. */
    private fun callApi(response: SandwichResponse<ApiResponseBasic>?): Flow<AuthResult> =
        TODO("mesma lógica de PTV3AAdapter.callApi(básico) (corrotina Extra3AAdapter\$callApi\$2)")

    /** Original: c.q(response, convertor) — igual a PTV3AAdapter.callApi(com conversor). */
    private fun <X> callApi(response: SandwichResponse<ApiResponse<X>>?, convertor: AAAAdapterFactory.Convertor<X, AuthResult>): Flow<AuthResult> =
        TODO("mesma lógica de PTV3AAdapter.callApi(com conversor) (corrotina Extra3AAdapter\$callApi\$3)")

    /** Original: c.r(LoginRequest) "login" — callback c$i -> SessionConverter.fromExtraLogin(username, password, data). */
    private suspend fun login(request: LoginRequest): Flow<AuthResult> = callApi(
        Api3AClient.login(request),
        AAAAdapterFactory.createSessionConvertor(true, false, { w ->
            SessionConverter.fromExtraLogin(request.username, request.password, w.x)
        }),
    )

    /** Original: c.a() — Api3AClient.f(). */
    override suspend fun logout() = callApi(Api3AClient.logout())

    /** Original: c.b(code) — login só com código (LoginRequest(code)). */
    override suspend fun loginByCode(code: String) = login(LoginRequest(code))

    /**
     * Original: c.c(...) "linkContact": sem username local -> registro (Api3AClient.k, callback c$d ->
     * SessionConverter.fromRegister); com username -> vínculo (Api3AClient.d, callback c$e ->
     * SessionConverter.fromExtraLogin). Senha sempre em MD5.
     */
    override suspend fun linkContact(
        contact: String, password: String, verificationCode: String,
        digitalCode: String, invitationCode: String,
    ): Flow<AuthResult> {
        val digest = md5(password)
        val username = UserManager.getLocalSessionInfo()?.username
        return if (username.isNullOrEmpty()) {
            callApi(
                Api3AClient.register(contact, digest, verificationCode),
                AAAAdapterFactory.createSessionConvertor(false, false, { w ->
                    SessionConverter.fromRegister(contact, digitalCode, digest, w.x)
                }),
            )
        } else {
            callApi(
                Api3AClient.linkContact(contact, digitalCode, digest, verificationCode),
                AAAAdapterFactory.createSessionConvertor(false, false, { w ->
                    SessionConverter.fromExtraLogin(contact, digest, w.x)
                }),
            )
        }
    }

    /** Original: c.d(refreshToken) — callback c$r -> SessionConverter.fromRefresh. */
    override suspend fun refresh(refreshToken: String) = callApi(
        Api3AClient.refresh(refreshToken),
        AAAAdapterFactory.createSessionConvertor(false, true, { w -> SessionConverter.fromRefresh(w.x) }, "", retFalseIfNull = true),
    )

    /** Original: c.e(...) — LoginRequest(user, passwordDigest, digitalCode). */
    override suspend fun login(userName: String, passwordDigest: String, digitalCode: String) =
        login(LoginRequest(userName, passwordDigest, digitalCode))

    /**
     * Original: c.f() + conversor c$n: aplica propriedades; se vier loginInfo, atualiza contato e
     * retorna `(false, -8, msg)` (força login com usuário); senão `(true, code, msg)`.
     */
    override suspend fun queryMetaInfo() = callApi(
        Api3AClient.queryMetaInfo(),
        object : AAAAdapterFactory.Convertor<QueryMetaInfo, AuthResult> {
            override fun describe() = "query meta info"
            override suspend fun convert(errCode: Int, errMsg: String?, data: QueryMetaInfo?): AuthResult? {
                val props = data?.properties ?: return null
                AAAAdapterFactory.applyProperties(props)
                val loginInfo = data.loginInfo ?: return Triple(true, errCode, errMsg)
                SessionConverter.updateContact(loginInfo)
                return Triple(false, -8, errMsg)
            }
        },
    )

    /** Original: c.g() — não suportado. */
    override suspend fun updateSession(token: String): Flow<AuthResult> = flowOf(Triple(false, -2, null))

    /** Original: c.h() — devolve resposta fixa de falha. */
    override suspend fun uploadFeedbackFile(feedbackFile: File) = FeedbackUploadResponse("-1", "", null)

    /** Original: c.i(...) — senha em MD5. */
    override suspend fun resetPassword(userName: String, digitalCode: String, password: String, captchaCode: String) =
        callApi(Api3AClient.resetPassword(userName, digitalCode, md5(password), captchaCode))

    /** Original: c.j() — guest login com accountId/accountName locais; callback c$g -> fromGuestLogin. */
    override suspend fun guestLogin(): Flow<AuthResult> {
        val s = UserManager.getLocalSessionInfo()
        return callApi(
            Api3AClient.guestLogin(s?.accountId, s?.accountName),
            AAAAdapterFactory.createSessionConvertor(true, false, { w -> SessionConverter.fromGuestLogin(w.x) }),
        )
    }

    /** Original: c.k() — não suportado. */
    override suspend fun getReferralSummary(): Flow<AuthResult> = flowOf(Triple(false, -2, null))

    /** Original: c.l(contact, digitalCode, actionType) — actionType ignorado. */
    override suspend fun sendCaptcha(contact: String, digitalCode: String, actionType: String) =
        callApi(Api3AClient.sendCaptcha(contact, digitalCode))

    /** Original: c.m() + conversor c$l: HeartbeatManager.applyProperties(properties); retorna null. */
    override suspend fun queryAppProperty() = callApi(
        Api3AClient.queryAppProperty(),
        object : AAAAdapterFactory.Convertor<QueryPropertiesInfo, AuthResult> {
            override fun describe() = "query app property"
            override suspend fun convert(errCode: Int, errMsg: String?, data: QueryPropertiesInfo?): AuthResult? {
                HeartbeatManager.applyProperties(data?.properties)
                return null
            }
        },
    )

    /** Original: c.n(code) — ApiSubscriptionClient.c(code); callback c$p -> fromRecharge. */
    override suspend fun recharge(code: String) = callApi(
        ApiSubscriptionClient.recharge(code),
        AAAAdapterFactory.createSessionConvertor(false, false, { w -> SessionConverter.fromRecharge(w.x) }),
    )
}
