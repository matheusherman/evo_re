package com.foxivid.baselib.model.ptv.user

import com.foxivid.baselib.model.extra.ApiRequestBasic
import com.foxivid.baselib.model.extra.user.GuestLoginInfo

/** Original: z1/b1/lb/m/ptv/user/ChangePasswordRequest.java. */
class ChangePasswordRequest : ApiRequestBasic() {
    var newPassword: String? = null
    var oldPassword: String? = null
    var username: String? = null
}

/** Resultado de login/refresh/recharge PTV. Original: z1/b1/lb/m/ptv/user/PTVLoginInfo.java. */
class PTVLoginInfo : GuestLoginInfo() {
    var planName: String = ""
    var expireTime: Long = 0
    var memberShipUrl: String = ""
    var email: String = ""
    var loginName: String = ""
    var loginType: String = "0"
    var remainingDays: String = ""
}

/**
 * Original: z1/b1/lb/m/ptv/user/RegisterRequest.java.
 * Quirk: o construtor de 6 argumentos IGNORA `accountId` e `token` (ficam nulos; só há setters).
 */
class RegisterRequest(
    @Suppress("UNUSED_PARAMETER") accountIdArg: String?,
    @Suppress("UNUSED_PARAMETER") tokenArg: String?,
    var username: String?,
    var password: String?,
    var verificationCode: String?,
    var invitationCode: String?,
) : ApiRequestBasic() {
    var accountId: String? = null
    var token: String? = null

    override fun toString(): String =
        "RegisterRequest{accountId='$accountId', token='$token', username='$username', password='$password', " +
            "verificationCode='$verificationCode', invitationCode='$invitationCode'}"
}
