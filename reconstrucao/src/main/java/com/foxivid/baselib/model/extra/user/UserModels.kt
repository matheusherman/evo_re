package com.foxivid.baselib.model.extra.user

import com.foxivid.baselib.model.common.BaseModel
import com.foxivid.baselib.model.extra.ApiRequestBasic
import com.foxivid.baselib.model.user.ServerResponse
import com.google.gson.annotations.SerializedName

/* Modelos de conta do protocolo "extra" (e reutilizados pela API PTV). Pacote original: z1/b1/lb/m/extra/user. */

/** Original: AccountSubscription.java. */
class AccountSubscription : BaseModel() {
    var expireTs: Long = 0
    var productId: Long = 0
    var productName: String? = null
}

/** Original: ChangePasswordRequest.java. */
class ChangePasswordRequest : ApiRequestBasic() {
    var newPassword: String? = null
    var oldPassword: String? = null
}

/** Original: ContactCheckInfo.java. */
class ContactCheckInfo : BaseModel() {
    var hasPassword: Boolean = false
}

/**
 * Resultado do login de convidado; base de PTVLoginInfo.
 * Original: GuestLoginInfo.java (setters extras aceitam `long` primitivo).
 */
open class GuestLoginInfo : BaseModel() {
    var accessToken: String? = null
    var accessTokenExpiresIn: Long? = null
    var accountId: Long? = null
    var accountName: String? = null
    var accountSubscriptionList: List<AccountSubscription>? = null
    var accountType: String? = null
    var businessType: String? = null
    var freeTime: Long? = null
    var refreshToken: String? = null
    var refreshTokenExpiresIn: Long? = null
    var streamServers: List<ServerResponse>? = null
    var streamToken: String? = null
}

/** Original: GuestLoginRequest.java. getAccountId() original faz `accountId.longValue()` (NPE se nulo). */
class GuestLoginRequest(var accountId: Long?, var accountName: String?) : ApiRequestBasic()

/** Original: LinkRequest.java. */
class LinkRequest(
    var contact: String?, var digitalCode: String?, var password: String?, var verificationCode: String?,
) : ApiRequestBasic()

/** Original: LoginInfo.java. */
class LoginInfo : BaseModel() {
    var accessToken: String? = null
    var accessTokenExpiresIn: Long? = null
    var accountId: Long? = null
    var accountName: String? = null
    var accountSubscriptionList: List<AccountSubscription>? = null
    var accountType: String? = null
    var businessType: String? = null
    var code: String? = null
    var digitalCode: String? = null
    var email: String? = null
    var freeTime: Long? = null
    var hasPassword: Boolean? = null
    var phone: String? = null
    var randomName: String? = null
    var refreshToken: String? = null
    var refreshTokenExpiresIn: Long? = null
    var streamServers: List<ServerResponse>? = null
    var streamToken: String? = null
}

/**
 * Original: LoginRequest.java. `password` é o digest da senha (ver PTVApi3AClient.login).
 * Construtor de 1 argumento: password = "" e digitalCode = "".
 */
class LoginRequest(var username: String?, var password: String?, var digitalCode: String?) : ApiRequestBasic() {
    constructor(username: String) : this(username, "", "")
}

/** Original: QueryMetaInfo.java (campos ofuscados -> chaves JSON "a"/"b"). */
class QueryMetaInfo {
    @SerializedName("a") var properties: Map<*, *>? = null
    @SerializedName("b") var loginInfo: LoginInfo? = null
}

/** Original: QueryPropertiesInfo.java (campo ofuscado). */
class QueryPropertiesInfo {
    @SerializedName("a") var properties: Map<*, *>? = null
}

/** Original: RefreshInfo.java. */
class RefreshInfo : BaseModel() {
    var accessToken: String? = null
    var accessTokenExpiresIn: Long? = null
    var accountId: Long? = null
    var accountSubscriptionList: List<AccountSubscription>? = null
    var businessType: String? = null
    var refreshToken: String? = null
    var refreshTokenExpiresIn: Long? = null
    var streamToken: String? = null
}

/** Original: RefreshTokenRequest.java. */
class RefreshTokenRequest(var refreshToken: String) : ApiRequestBasic()

/** Original: RegisterInfo.java. */
class RegisterInfo : BaseModel() {
    var accessToken: String? = null
    var accessTokenExpiresIn: Long? = null
    var accountId: Long? = null
    var accountName: String? = null
    var accountSubscriptionList: List<AccountSubscription>? = null
    var accountType: String? = null
    var businessType: String? = null
    var refreshToken: String? = null
    var refreshTokenExpiresIn: Long? = null
    var streamServers: List<ServerResponse>? = null
    var streamToken: String? = null
}

/** Original: RegisterRequest.java (extra). */
class RegisterRequest(
    var username: String?, var password: String?, var verificationCode: String?, var invitationCode: String?,
) : ApiRequestBasic()

/** Original: ResetPasswordRequest.java. */
class ResetPasswordRequest(
    var username: String?, var digitalCode: String?, var newPassword: String?, var captchaCode: String?,
) : ApiRequestBasic()

/** Original: SupportedCountry.java. */
class SupportedCountry : BaseModel() {
    var code: String? = null
    var digitalCode: String? = null
    var flagUrl: String? = null
    var name: String? = null
}

/** Original: UnlinkRequest.java. */
class UnlinkRequest : ApiRequestBasic() {
    var contact: String? = null
    var password: String? = null
}

/** Original: VerificationCodeRequest.java. `emailType` recebe o "actionType" na API PTV. */
class VerificationCodeRequest(var contact: String?, var digitalCode: String?, var emailType: String?) : ApiRequestBasic()
