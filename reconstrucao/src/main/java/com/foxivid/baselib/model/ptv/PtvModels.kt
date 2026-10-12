package com.foxivid.baselib.model.ptv

import com.foxivid.baselib.config.UserManagerRef
import com.foxivid.baselib.model.common.BaseModel
import com.foxivid.baselib.model.extra.IApiResponse
import org.apache.commons.lang3.StringUtils
import org.greenrobot.eventbus.EventBus

/**
 * Resposta do protocolo PTV (errCode textual).
 * Original: z1/b1/lb/m/ptv/ApiResponseBasic.java.
 */
open class ApiResponseBasic : BaseModel(), IApiResponse {
    private var errCode: String? = null
    private var errMessage: String? = null
    var serverTime: Long = 0
    private var success: Boolean = false

    /** Código textual cru. Original: c(). */
    fun rawErrCode(): String? = errCode
    fun getErrMessage(): String? = errMessage
    override fun getErrMsg(): String? = errMessage
    override fun isSuccess(): Boolean = success

    /**
     * Traduz o código textual para os códigos numéricos do protocolo "extra".
     * Em "401"/"500" publica no EventBus o evento nf.u(-9, "api") (sessão inválida/kick-out),
     * a menos que um logout já esteja em andamento (UserManager.P0()), e retorna -9.
     * Original: getErrCode().
     */
    override fun getErrCode(): Int {
        if (isSuccess()) return 0
        val c = errCode
        return when {
            StringUtils.equals(c, "B_USER_usernameRepeat") -> 10100033
            StringUtils.equals(c, "B_USER_undefined") -> 10100002
            StringUtils.equals(c, "B_USER_cardUnavailable") -> 10100011
            StringUtils.equals(c, "B_USER_passwordError") -> 10100027
            StringUtils.equals(c, "B_USER_incorrectVerificationCode") -> 10100030
            StringUtils.equals(c, "B_USER_emailAlreadyBound") || StringUtils.equals(c, "B_USER_mobileAlreadyBound") -> 10100033
            StringUtils.equals(c, "B_USER_countryCodeEmpty") -> 10100005
            StringUtils.equals(c, "B_CHARGE_codeUndefined") -> 10100007
            StringUtils.equals(c, "B_CHARGE_codeUnavailable") -> 10100011
            !StringUtils.equals(c, "401") && !StringUtils.equals(c, "500") ->
                if (StringUtils.equals(c, "B_USER_alreadyBind")) -8 else -1
            else -> {
                if (!UserManagerRef.isInLogout()) EventBus.getDefault().post(SessionErrorEventRef(-9, "api"))
                -9
            }
        }
    }
}

/** Original: z1/b1/lb/m/ptv/ApiResponse.java. */
open class ApiResponse<T> : ApiResponseBasic() {
    var data: T? = null
}

/**
 * Evento de erro de sessão publicado no EventBus. Original: nf/u.java (outro módulo).
 * Quirk: o construtor original ignora o 2º argumento (`who` nunca é atribuído).
 */
class SessionErrorEventRef(val errCode: Int, @Suppress("UNUSED_PARAMETER") who: String) : BaseModel() {
    val who: String? = null
}
