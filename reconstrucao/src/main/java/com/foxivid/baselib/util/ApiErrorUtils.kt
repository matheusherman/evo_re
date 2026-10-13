package com.foxivid.baselib.util

import com.foxivid.baselib.event.ApiAuthErrorEvent
import com.foxivid.baselib.user.UserManager
import org.greenrobot.eventbus.EventBus
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import z1.b1.lb.m.ApiResponseBasic
import z1.b1.lb.m.IApiResponse

/**
 * Tratamento de códigos de erro das respostas da API.
 * Original: x1/f1/lb/util/e.java
 */
object ApiErrorUtils {
    private val logger: Logger = LoggerFactory.getLogger(ApiErrorUtils::class.java)

    /**
     * Retorna a mensagem de erro de uma resposta ("" quando `errCode == 0`).
     *
     * Efeitos colaterais:
     *  - 9000010: posta `nf.u(code, "api")` e chama `UserManager.markSessionExpired()` (user/f.x1()) (provavelmente logout/sessão expirada);
     *  - 9000042: posta `nf.u(code, "api")` e chama `UserManager.onKickedOut("API", 1)` (user/f.Z0).
     *
     * Embora mapeie o código para um recurso de string ([codeToStringRes]), o original sempre devolve o
     * `errMsg` do servidor (ambos os ramos retornam `errMsg`).
     * Original: `e.a(IApiResponse)`.
     */
    fun getErrorMessage(response: IApiResponse): String {
        val errCode = response.errCode
        val errMsg = response.errMsg
        if (errCode == 9000010) {
            EventBus.getDefault().post(ApiAuthErrorEvent(errCode, "api"))
            UserManager.markSessionExpired() // Original: user/f.x1()
        } else if (errCode == 9000042) {
            EventBus.getDefault().post(ApiAuthErrorEvent(errCode, "api"))
            UserManager.onKickedOut("API", 1) // Original: user/f.Z0(String,int)
        }
        val res = codeToStringRes(errCode)
        if (res == 0) return ""
        val desc = if (response is ApiResponseBasic) "a[${response.c()}:$errMsg]" else "b[$errCode:$errMsg]"
        logger.error("api_failure: $desc")
        return errMsg!!
    }

    /** Resultado de falha local padrão: (false, -3, errorMsg). Original: `e.c(String)` (r8.u = Triple). */
    fun localFailure(errorMsg: String?): Triple<Boolean, Int, String?> = Triple(false, -3, errorMsg)

    /** Original: `e.b(int)`. */
    private fun codeToStringRes(code: Int): Int = when (code) {
        0 -> 0
        10100001 -> R.string.password_is_incorrect
        10100003 -> R.string.account_is_locked
        10100007 -> R.string.recharge_code_error
        10100008 -> R.string.recharge_code_used
        10100009 -> R.string.recharge_code_locked
        10100010 -> R.string.recharge_code_forbidden
        10100011 -> R.string.recharge_code_invalid
        10100027 -> R.string.account_or_password_error
        10100028 -> R.string.account_or_verification_code_incorrect
        10100030 -> R.string.verification_code_incorrect
        10100033 -> R.string.contact_already_exists
        10100037 -> R.string.unlink_failure
        10100039 -> R.string.unlink_not_allow
        else -> R.string.unknown_error_code
    }
}
