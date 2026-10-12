package com.foxivid.baselib.model.local

import com.foxivid.baselib.model.common.BaseModel
import com.foxivid.baselib.model.extra.user.AccountSubscription
import com.foxivid.baselib.model.user.ServerResponse

/**
 * Sessão do usuário persistida localmente (tokens, servidores de stream, estado de kick-out...).
 *
 * Original: z1/b1/lb/m/local/LocalSessionInfo.java. (A tabela de CONVENCOES.md cita
 * `LocalSessionInfo` no pacote `user`; o arquivo original está em z1/b1/lb/m/local.)
 *
 * O construtor de cópia copia todos os campos, na mesma ordem do original.
 */
class LocalSessionInfo() : BaseModel() {
    var accessToken: String? = null
    var accessTokenExpiresTS: Long? = null
    var accountId: Long = 0
    var accountName: String? = null
    var accountSubscriptionList: List<AccountSubscription>? = null
    var accountType: String? = null
    var businessType: String? = null
    var code: String? = null
    var digitalCode: String? = null
    var email: String? = null
    var freeTimeMs: Long = 0
    var hasPassword: Boolean? = null
    var isKickedOut: Boolean = false
    var isLoginByUsernameFailure: Boolean = false
    var isLogout: Boolean = false
    var isRefreshAccessTokenFailure: Boolean = false
    var kickedOutBy: String = ""
    var kickedOutReason: Int = 0
    var lastUsername: String? = null
    var latestLocalLoadTime: Long? = null
    var latestLoginResponseTime: Long? = null
    var latestTokenUpdateTime: Long? = null
    var loginFailurePassword: String = ""
    var loginFailureUsername: String = ""
    var memberShipUrl: String? = null
    var passwordDigest: String? = null
    var phone: String? = null
    var phoneNumber: String? = null
    var planLeftDays: String = ""
    var randomName: String? = null
    var refreshToken: String? = null
    var refreshTokenExpiresTS: Long? = null
    var streamServers: List<ServerResponse>? = null
    var streamToken: String? = null
    var username: String? = null

    /** Construtor de cópia (no-op se `other` for nulo). Original: LocalSessionInfo(LocalSessionInfo). */
    constructor(other: LocalSessionInfo?) : this() {
        if (other == null) return
        accountId = other.accountId
        accountName = other.accountName
        accountType = other.accountType
        businessType = other.businessType
        username = other.username
        lastUsername = other.lastUsername
        phoneNumber = other.phoneNumber
        digitalCode = other.digitalCode
        phone = other.phone
        email = other.email
        code = other.code
        passwordDigest = other.passwordDigest
        randomName = other.randomName
        freeTimeMs = other.freeTimeMs
        accessToken = other.accessToken
        streamToken = other.streamToken
        refreshToken = other.refreshToken
        streamServers = other.streamServers
        accountSubscriptionList = other.accountSubscriptionList
        accessTokenExpiresTS = other.accessTokenExpiresTS
        refreshTokenExpiresTS = other.refreshTokenExpiresTS
        isRefreshAccessTokenFailure = other.isRefreshAccessTokenFailure
        isLoginByUsernameFailure = other.isLoginByUsernameFailure
        loginFailureUsername = other.loginFailureUsername
        loginFailurePassword = other.loginFailurePassword
        memberShipUrl = other.memberShipUrl
        hasPassword = other.hasPassword
        isLogout = other.isLogout
        isKickedOut = other.isKickedOut
        kickedOutReason = other.kickedOutReason
        latestLoginResponseTime = other.latestLoginResponseTime
        latestLocalLoadTime = other.latestLocalLoadTime
        latestTokenUpdateTime = other.latestTokenUpdateTime
        kickedOutBy = other.kickedOutBy
        planLeftDays = other.planLeftDays
    }
}
