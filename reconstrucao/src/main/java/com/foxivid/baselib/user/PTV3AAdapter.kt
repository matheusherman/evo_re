package com.foxivid.baselib.user

import com.foxivid.baselib.api.PTVApi3AClient
import com.foxivid.baselib.model.extra.IApiResponse
import com.foxivid.baselib.network.HeaderInterceptor
import com.foxivid.baselib.util.ApiErrorUtils
import com.foxivid.baselib.util.LegacyTvUtils
import com.foxivid.baselib.util.SandwichErrors
import com.foxivid.baselib.util.ServerTime
import com.foxivid.baselib.util.StackTraceUtils
import com.foxivid.baselib.model.feedback.FeedbackUploadResponse
import com.foxivid.baselib.model.ptv.ApiResponse
import com.foxivid.baselib.model.ptv.ApiResponseBasic
import com.foxivid.baselib.model.ptv.referral.ReferralSummary
import com.foxivid.baselib.model.ptv.user.PTVLoginInfo
import com.foxivid.baselib.model.ptv.user.RegisterRequest
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnFailure
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import java.io.File
import com.skydoves.sandwich.ApiResponse as SandwichResponse

/**
 * Adapter de autenticação para o backend "PTV" (o adapter efetivamente usado).
 *
 * Original: x1/f1/lb/user/d.java (Kotlin: PTV3AAdapter.kt)
 *
 * Cada operação chama o [PTVApi3AClient] (Original: x1/f1/lb/api/i.java, PTVApi3AClient.kt — outro
 * módulo) e converte a resposta Sandwich em `Flow<AuthResult>`. Assinaturas usadas do cliente
 * (todas `suspend`, retornando `com.skydoves.sandwich.ApiResponse<...>`, com retry e rotação de
 * servidor via `authServerProvider`):
 *
 * | Original | Nome real (corrotina) | Retorno |
 * |---|---|---|
 * | i.d() | guestLogin() | ApiResponse<PTVLoginInfo> |
 * | i.e(username, passwordDigest, digitalCode) | login(...) — usa LoginRequest | ApiResponse<PTVLoginInfo> |
 * | i.f(token) | login(token) — "login by token" | ApiResponse<PTVLoginInfo> |
 * | i.g() | logout() | ApiResponse<Object> |
 * | i.h() | queryMetaInfo() | ApiResponse<Object> |
 * | i.i(code) | recharge(code) — ChargeCodeRechargeRequest | ApiResponse<PTVLoginInfo> |
 * | i.j() | referralSummary() | ApiResponse<ReferralSummary> |
 * | i.k(refreshToken) | refresh(refreshToken) | ApiResponse<PTVLoginInfo> |
 * | i.l(RegisterRequest) | register(...) | ApiResponse<PTVLoginInfo> |
 * | i.m(userName, digitalCode, newPassword, captchaCode) | resetPassword — ResetPasswordRequest | ApiResponseBasic |
 * | i.n(contact, digitalCode, actionType) | sendCaptcha — VerificationCodeRequest | ApiResponseBasic |
 * | i.o() | upgrade() | ApiResponse<UpgradeInfo> |
 * | i.p(File) | uploadFeedbackFile (multipart "file", application/gzip) | FeedbackUploadResponse |
 *
 * `callFrom` passado ao conversor: "1"=login, "2"=refresh, "3"=recharge, "4"=updateSession,
 * "8.1"/"8.2"=guestLogin (com/sem sessão encerrada), "c"=linkContact.
 */
class PTV3AAdapter : AccountAdapter<ApiResponse<*>> {

    /** Original: campo `updateSessionCallback` (classe interna d$p) -> SessionConverter.fromPtvLogin. */
    private val updateSessionCallback: (SessionWrapper<PTVLoginInfo>) -> Unit = { SessionConverter.fromPtvLogin(it) }

    /** Original: d.u(contact, digitalCode) — remove o DDI do início do contato. */
    private fun stripDigitalCode(contact: String, digitalCode: String): String =
        if (contact.startsWith(digitalCode)) contact.replace(digitalCode, "") else contact

    /** Original: d.t(String) — MD5 da senha (util/n.o()). */
    private fun md5(clearPassword: String): String = LegacyTvUtils.getInstance().md5Hex(clearPassword) ?: ""   // util/n.n().o(str)

    /** Original: util/q.b(3) — "Classe.metodo()@linha:arquivo" do chamador, usado nas mensagens ao bot. */
    private fun callerName(): String = StackTraceUtils.callerName(3)   // util/q.b(3)

    /**
     * Converte resposta "básica" (sem payload).
     * Original: d.r(response) + corrotina "PTV3AAdapter\$callApi\$1"
     */
    private fun callApi(response: SandwichResponse<ApiResponseBasic>?): Flow<AuthResult> {
        if (response == null) return flowOf(Triple(false, -1, "response is null"))
        val caller = callerName()
        return flow {
            response.suspendOnSuccess {
                val body = data
                // util/e.a(): traduz errCode; 9000010 -> sessão expirada, 9000042 -> derrubado (kick)
                emit(AAAAdapterFactory.reportIfFailure(caller, Triple(body.isSuccess, body.errCode, apiErrorMessage(body))))
            }
            emitFailures(response, caller)
        }
    }

    /**
     * Converte resposta com payload usando um [AAAAdapterFactory.Convertor].
     * Original: d.s(response, convertor) + corrotina "PTV3AAdapter\$callApi\$2"
     *
     * No sucesso HTTP: sincroniza relógio com `serverTime*1000` (util/d1.f("api", ...)); se
     * `isSuccess`, chama o conversor; conversor null ou `!isSuccess` -> `(false, errCode, msg)` + bot.
     */
    private fun <X> callApi(
        response: SandwichResponse<ApiResponse<X>>?,
        convertor: AAAAdapterFactory.Convertor<X, AuthResult>,
    ): Flow<AuthResult> {
        val caller = callerName()
        if (response == null) {
            return flowOf(AAAAdapterFactory.reportIfFailure(caller, Triple(false, -1, "response is null")))
        }
        val clientRequestTimestamp: Long = ServerTime.elapsedNow()   // util/d1.c(): relógio monotônico (ms) = início do processo + tempo decorrido
        return flow {
            response.suspendOnSuccess {
                val api = data
                val serverTime = 1000L * api.serverTime
                if (serverTime > 0) ServerTime.sync("api", ServerTime.elapsedNow(), clientRequestTimestamp, serverTime)   // util/d1.f: ajuste de relógio
                val failure = { AAAAdapterFactory.reportIfFailure(caller, Triple(false, api.errCode, apiErrorMessage(api)), convertor.describe()) }
                if (api.isSuccess) {
                    emit(convertor.convert(api.errCode, api.errMsg, api.data) ?: failure())
                } else {
                    emit(failure())
                }
            }
            emitFailures(response, caller)
        }
    }

    /**
     * Emissões de falha, na ordem do original: Failure genérico, depois Exception e Error.
     * NOTA de fidelidade: como um Failure.Error/Exception também é Failure, o original emite DOIS
     * resultados para uma mesma falha (labels 2 e 3/4 da state machine). Mantido.
     * Mapeamento C0151a=Error / C0152b=Exception é inferido da ordem de declaração no Sandwich.
     */
    private suspend fun <T> FlowCollector<AuthResult>.emitFailures(response: SandwichResponse<T>, caller: String) {
        response.suspendOnFailure {
            emit(AAAAdapterFactory.reportIfFailure(caller, networkError(SandwichErrors.describe(this))))
        }
        response.suspendOnException {
            emit(AAAAdapterFactory.reportIfFailure(caller, networkError(SandwichErrors.describe(this))))
        }
        response.suspendOnError {
            emit(AAAAdapterFactory.reportIfFailure(caller, networkError(SandwichErrors.describe(this))))
        }
    }

    /** Original: util/e.c(msg) = Triple(false, -3, msg). */
    private fun networkError(msg: String): AuthResult = Triple(false, -3, msg)

    /** Original: util/e.a(IApiResponse) — mensagem de erro + efeitos colaterais de sessão. */
    private fun apiErrorMessage(response: IApiResponse): String = ApiErrorUtils.getErrorMessage(response)   // trata 9000010 (sessão expirada) e 9000042 (kicked out)

    /** Original: d.a() — logout; código -9 é convertido em sucesso `(true, null, "")`. */
    override suspend fun logout(): Flow<AuthResult> = flow {
        callApi(PTVApi3AClient.logout()).collect { r ->
            emit(if (r.second == -9) Triple(true, null, "") else r)
        }
    }

    /** Original: d.b() — não suportado no PTV. */
    override suspend fun loginByCode(code: String): Flow<AuthResult> = flowOf(Triple(false, -2, "api not support"))

    /** Original: d.c(...) "linkContact" — registro via RegisterRequest(tenantOuUid, accessToken, ...). */
    override suspend fun linkContact(
        contact: String, password: String, verificationCode: String,
        digitalCode: String, invitationCode: String,
    ): Flow<AuthResult> {
        // Original: new RegisterRequest(of.a.b() /* accountId */, UserManager.b0() /* accessToken */, str, str2, str3, str5)
        val request = RegisterRequest(
            HeaderInterceptor.accountId()   // of/a.b(): accountId do provider de parâmetros, UserManager.getAccessToken(),
            contact, password, verificationCode, invitationCode,
        )
        return callApi(
            PTVApi3AClient.register(request),
            AAAAdapterFactory.createSessionConvertor(true, false, updateSessionCallback, "c", contact, md5(password)),
        )
        // NOTA: digitalCode (4º parâmetro) é ignorado pelo backend PTV.
    }

    /** Original: d.d(refreshToken) "refresh". */
    override suspend fun refresh(refreshToken: String): Flow<AuthResult> = callApi(
        PTVApi3AClient.refresh(refreshToken),
        AAAAdapterFactory.createSessionConvertor(false, true, updateSessionCallback, "2", retFalseIfNull = true),
    )

    /** Original: d.e(...) "login". */
    override suspend fun login(userName: String, passwordDigest: String, digitalCode: String): Flow<AuthResult> = callApi(
        PTVApi3AClient.login(userName, passwordDigest, digitalCode),
        AAAAdapterFactory.createSessionConvertor(true, false, updateSessionCallback, "1", userName, passwordDigest),
    )

    /** Original: d.f() "queryMetaInfo" — payload Map vai para AAAAdapterFactory.applyProperties. */
    override suspend fun queryMetaInfo(): Flow<AuthResult> = callApi(
        PTVApi3AClient.queryMetaInfo(),
        object : AAAAdapterFactory.Convertor<Any, AuthResult> {
            override fun describe() = "query meta info"
            override suspend fun convert(errCode: Int, errMsg: String?, data: Any?): AuthResult? {
                if (data == null) return null
                if (data is Map<*, *>) AAAAdapterFactory.applyProperties(data)
                return Triple(true, errCode, errMsg)
            }
        },
    )

    /**
     * Original: d.g(token) "updateSession" (corrotina d$o). `isLogin` = sessão encerrada ou último
     * auth falhou (`T0() || !J0()`).
     */
    override suspend fun updateSession(token: String): Flow<AuthResult> = flow {
        val isLogin = UserManager.isLogoutOrKickedOut() || !UserManager.isAuthRetSuccess()
        emitAll(
            callApi(
                PTVApi3AClient.loginByToken(token),
                AAAAdapterFactory.createSessionConvertor(isLogin, false, updateSessionCallback, "4"),
            ),
        )
    }

    /** Original: d.h(File). */
    override suspend fun uploadFeedbackFile(feedbackFile: File): FeedbackUploadResponse =
        PTVApi3AClient.uploadFeedbackFile(feedbackFile)

    /** Original: d.i(...) "resetPassword". */
    override suspend fun resetPassword(userName: String, digitalCode: String, password: String, captchaCode: String) =
        callApi(PTVApi3AClient.resetPassword(userName, digitalCode, password, captchaCode))

    /**
     * Original: d.j() — guest login (corrotina "PTV3AAdapter\$login\$2").
     * Se a sessão foi encerrada (logout/kick), passa username/senha/código vazios ("8.1") para
     * limpar as credenciais locais; senão mantém (null) ("8.2").
     */
    override suspend fun guestLogin(): Flow<AuthResult> = flow {
        val response = PTVApi3AClient.guestLogin()
        val convertor = if (UserManager.isLogoutOrKickedOut()) {
            AAAAdapterFactory.createSessionConvertor(true, false, updateSessionCallback, "8.1", "", "", "")
        } else {
            AAAAdapterFactory.createSessionConvertor(true, false, updateSessionCallback, "8.2")
        }
        emitAll(callApi(response, convertor))
    }

    /** Original: d.k() "getReferralSummary" — guarda em UserManager.setReferralSummary. */
    override suspend fun getReferralSummary(): Flow<AuthResult> = callApi(
        PTVApi3AClient.referralSummary(),
        object : AAAAdapterFactory.Convertor<ReferralSummary, AuthResult> {
            override fun describe() = "get referral summary"
            override suspend fun convert(errCode: Int, errMsg: String?, data: ReferralSummary?): AuthResult {
                if (data == null) return Triple(false, errCode, errMsg)
                UserManager.setReferralSummary(data)
                return Triple(true, errCode, errMsg)
            }
        },
    )

    /** Original: d.l(...) "sendCaptcha" — contato sem DDI. */
    override suspend fun sendCaptcha(contact: String, digitalCode: String, actionType: String) =
        callApi(PTVApi3AClient.sendCaptcha(stripDigitalCode(contact, digitalCode), digitalCode, actionType))

    /** Original: d.m() — não suportado no PTV. */
    override suspend fun queryAppProperty(): Flow<AuthResult> = flowOf(Triple(false, -2, "api not support"))

    /** Original: d.n(code) "recharge". */
    override suspend fun recharge(code: String): Flow<AuthResult> = callApi(
        PTVApi3AClient.recharge(code),
        AAAAdapterFactory.createSessionConvertor(false, false, updateSessionCallback, "3"),
    )
}
