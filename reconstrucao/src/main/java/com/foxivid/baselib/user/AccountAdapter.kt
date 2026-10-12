package com.foxivid.baselib.user

import com.foxivid.baselib.model.feedback.FeedbackUploadResponse
import kotlinx.coroutines.flow.Flow
import java.io.File

/**
 * Resultado padrão das operações de autenticação: (sucesso, código, mensagem).
 * Original: r8.u<Boolean, Integer, String> (kotlin.Triple ofuscado).
 *
 * Códigos internos observados (além dos códigos de erro do servidor):
 *  - `0`  ok
 *  - `-1` resposta nula
 *  - `-2` "api not support" (operação não suportada pelo adapter)
 *  - `-3` exceção de rede/chamada (util/e.c())
 *  - `-8` precisa de interação do usuário (ex.: login com usuário/senha; mensagem = username)
 *  - `-9` (logout) tratado como sucesso
 *  - `-10` "limit continuing renew"
 *  - `-11` "auto login failure" (não tentar de novo)
 */
typealias AuthResult = Triple<Boolean, Int?, String?>

/**
 * Contrato de um backend de autenticação ("3A" = AAA: authentication/authorization/accounting).
 *
 * Original: x1/f1/lb/user/a.java (interface genérica `a<T>`)
 * Implementações: [PTV3AAdapter] (user/d, a usada) e [Extra3AAdapter] (user/c).
 * Nomes dos métodos inferidos pelos nomes de corrotina ("login", "refresh", ...) nas implementações.
 */
interface AccountAdapter<T> {
    /** Original: a.a() — logout. */
    suspend fun logout(): Flow<AuthResult>

    /** Original: a.b(String) — login por código de recarga/renovação. */
    suspend fun loginByCode(code: String): Flow<AuthResult>

    /** Original: a.c(...) — vincular contato/registrar (linkContact). */
    suspend fun linkContact(
        contact: String, password: String, verificationCode: String,
        digitalCode: String = "", invitationCode: String = "",
    ): Flow<AuthResult>

    /** Original: a.d(String) — renovar access token com refresh token. */
    suspend fun refresh(refreshToken: String): Flow<AuthResult>

    /** Original: a.e(String, String, String) — login por usuário + MD5 da senha + DDI. */
    suspend fun login(userName: String, passwordDigest: String, digitalCode: String): Flow<AuthResult>

    /** Original: a.f() — consulta meta-info (propriedades) antes do login. */
    suspend fun queryMetaInfo(): Flow<AuthResult>

    /** Original: a.g(String) — atualizar sessão / login por token. */
    suspend fun updateSession(token: String): Flow<AuthResult>

    /** Original: a.h(File). */
    suspend fun uploadFeedbackFile(feedbackFile: File): FeedbackUploadResponse

    /** Original: a.i(...) — reset de senha. */
    suspend fun resetPassword(userName: String, digitalCode: String, password: String, captchaCode: String): Flow<AuthResult>

    /** Original: a.j() — login de convidado (guest / por dispositivo). */
    suspend fun guestLogin(): Flow<AuthResult>

    /** Original: a.k() — resumo de indicações (referral). */
    suspend fun getReferralSummary(): Flow<AuthResult>

    /** Original: a.l(...) — enviar captcha/código de verificação. */
    suspend fun sendCaptcha(contact: String, digitalCode: String, actionType: String): Flow<AuthResult>

    /** Original: a.m() — consultar propriedades do app. */
    suspend fun queryAppProperty(): Flow<AuthResult>

    /** Original: a.n(String) — recarga por código. */
    suspend fun recharge(code: String): Flow<AuthResult>
}

/**
 * Embrulho da resposta de login passado ao callback de atualização de sessão.
 * Original: x1/f1/lb/user/e.java (`e<X>`)
 */
class SessionWrapper<X>(
    /** Original: campo `x` (getter e()). */
    val x: X,
    val isRefreshAccessToken: Boolean,
    /** Identificador curto de quem chamou ("1", "2", "3", "4", "8.1", "8.2", "c"...). */
    val callFrom: String?,
    val code: String?,
    val username: String?,
    val passwordDigest: String?,
)
