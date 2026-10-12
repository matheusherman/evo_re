package com.foxivid.baselib.user

import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.bot.TelegramBot
import com.foxivid.baselib.model.extra.subscription.RechargeInfo
import com.foxivid.baselib.model.extra.user.AccountSubscription
import com.foxivid.baselib.model.extra.user.GuestLoginInfo
import com.foxivid.baselib.model.extra.user.LoginInfo
import com.foxivid.baselib.model.extra.user.RefreshInfo
import com.foxivid.baselib.model.extra.user.RegisterInfo
import com.foxivid.baselib.model.local.LocalSessionInfo
import com.foxivid.baselib.model.ptv.user.PTVLoginInfo
import org.slf4j.LoggerFactory

/**
 * Converte respostas de login/refresh/registro do servidor em [LocalSessionInfo] e persiste
 * via [UserManager.setLocalSessionInfo] (que grava em SharedPreferences, chave "local_session").
 *
 * Original: x1/f1/lb/user/g.java (sem nome Kotlin preservado; nome inferido)
 *
 * `TimeUtils.now()` = x1/f1/lb/util/d1.d() (tempo corrigido pelo servidor, ms).
 */
object SessionConverter {

    private val logger = LoggerFactory.getLogger(SessionConverter::class.java)

    private fun now(): Long = TODO("util/d1.d(): timestamp atual (ms), corrigido pela hora do servidor")

    /**
     * Resposta do backend PTV (login, refresh, updateSession) -> sessão local.
     * Original: g.d(e<PTVLoginInfo>)
     */
    fun fromPtvLogin(sessionWrapper: SessionWrapper<PTVLoginInfo>): LocalSessionInfo {
        val info = sessionWrapper.x
        val callFrom = sessionWrapper.callFrom
        if (BaseLibConfig.isDebug) logger.debug("apiExtra from[{}] loginInfo[ {} ]", callFrom, info)
        // Original: new LocalSessionInfo(fVar.p0()) — construtor de cópia
        val s = LocalSessionInfo(UserManager.getLocalSessionInfo())

        if (sessionWrapper.isRefreshAccessToken) {
            if (info.accountId == null || info.accountId != s.accountId) {
                TelegramBot.send("[auth] refresh access token failure\n[${s.accountId}] != [${info.accountId}]")
                return s
            }
            applyTokens(s, info, callFrom, " rf_at response")
            if (info.streamToken.isNullOrEmpty()) {
                logger.error("get st[${info.streamToken}] from $callFrom rf_at response")
            } else if (s.streamToken == info.streamToken) {
                logger.warn(" get st[${info.streamToken}] but no update from $callFrom rf_at response")
            } else {
                s.streamToken = info.streamToken
            }
            if (info.streamServers.isNullOrEmpty()) {
                logger.warn("get ss[${info.streamServers}] from $callFrom rf_at response")
            } else {
                s.streamServers = info.streamServers
            }
            s.latestTokenUpdateTime = now()
            s.isTriedRefreshAccessTokenFailure = false
            UserManager.setLocalSessionInfo(s)
            return s
        }

        s.latestTokenUpdateTime = now()
        s.latestLoginResponseTime = now()
        val oldAccountId = s.accountId
        s.accountId = info.accountId!!
        if (info.accountId == oldAccountId) {
            // Mesmo usuário: só atualiza campos não vazios.
            if (!s.accountName.isNullOrEmpty()) s.accountName = info.accountName // (sic) condição sobre o valor local
            if (!sessionWrapper.passwordDigest.isNullOrEmpty()) s.passwordDigest = sessionWrapper.passwordDigest
            if (!sessionWrapper.username.isNullOrEmpty()) {
                s.username = sessionWrapper.username
                s.lastUsername = sessionWrapper.username
            }
            if (!sessionWrapper.code.isNullOrEmpty()) s.code = sessionWrapper.code
            if (info.email.isNullOrEmpty()) {
                if (!info.loginName.isNullOrEmpty()) s.phone = info.loginName
            } else {
                s.email = info.email
            }
            s.digitalCode = ""
            s.phoneNumber = ""
        } else {
            // Outro usuário: sobrescreve.
            s.accountName = info.accountName
            s.passwordDigest = sessionWrapper.passwordDigest
            s.username = sessionWrapper.username
            if (!sessionWrapper.username.isNullOrEmpty()) s.lastUsername = sessionWrapper.username
            s.code = sessionWrapper.code
            s.email = info.email
            s.digitalCode = ""
            s.phoneNumber = ""
            s.phone = if (!info.email.isNullOrEmpty() || info.loginName.isNullOrEmpty()) "" else info.loginName
        }
        if (!info.accountType.isNullOrEmpty()) {
            // Original: ac.g.c(a, b) (comparação de strings, provavelmente ignore-case)
            s.accountType = if (info.accountType.equals("normal", ignoreCase = true)) "normal" else "guest"
        }
        if (info.streamToken.isNullOrEmpty()) {
            logger.error("get st[${info.streamToken} from $callFrom response")
        } else {
            s.streamToken = info.streamToken
        }
        applyTokens(s, info, callFrom, " rf_at response")
        s.accountSubscriptionList = buildSubscriptions(info)
        if (info.streamServers.isNullOrEmpty()) {
            logger.error("get ss[${info.streamServers}] from $callFrom response")
        } else {
            s.streamServers = info.streamServers
        }
        if (!info.memberShipUrl.isNullOrEmpty()) s.memberShipUrl = info.memberShipUrl
        s.isLogout = false
        info.freeTime?.let { s.freeTimeMs = if (it > 0) it * 60000L else 0L } // FileWatchdog.DEFAULT_DELAY = 60000
        s.isTriedRefreshAccessTokenFailure = false
        s.isTriedLoginByUsernameFailure = false
        s.loginFailurePassword = ""
        s.loginFailureUsername = ""
        s.planLeftDays = info.remainingDays
        UserManager.setLocalSessionInfo(s)
        val username = UserManager.getUsername()
        if (s.lastUsername.isNullOrEmpty() && username.isNotEmpty()) s.lastUsername = username
        if (BaseLibConfig.isDebug) logger.debug("convert session to local [{}] -> [{}}", info, s)
        // Original: monta tf.AccountInfo(tenant?, android_id, canal, appType, accountId, accountType,
        // username, email, phone, code, planName, expireTime) e chama
        // x1.f1.lb.metric.monitor.a (AppUsageMonitor).p(accountInfo, remainingDays ?: "0").
        TODO("AppUsageMonitor.p(AccountInfo(...), remainingDays) — métricas, outro módulo")
    }

    /** Trecho repetido de g.d(): access/refresh token e expirações (só aumenta a expiração). */
    private fun applyTokens(s: LocalSessionInfo, info: PTVLoginInfo, callFrom: String?, suffix: String) {
        if (info.accessToken.isNullOrEmpty()) {
            logger.error("get at[${info.accessToken}] from $callFrom$suffix")
        } else {
            s.accessToken = info.accessToken
            if ((info.accessTokenExpiresIn ?: 0L) > (s.accessTokenExpiresTS ?: 0L)) {
                s.accessTokenExpiresTS = info.accessTokenExpiresIn
            } else {
                logger.warn("get at_exp_t[${info.accessTokenExpiresIn}] but no update from $callFrom$suffix")
            }
        }
        if (info.refreshToken.isNullOrEmpty()) {
            logger.error("get rt[${info.refreshToken}] from $callFrom$suffix")
        } else {
            s.refreshToken = info.refreshToken
            if ((info.refreshTokenExpiresIn ?: 0L) > (s.refreshTokenExpiresTS ?: 0L)) {
                s.refreshTokenExpiresTS = info.refreshTokenExpiresIn
            } else {
                logger.warn("get rt_exp_t[${info.refreshTokenExpiresIn}] but no update from $callFrom$suffix")
            }
        }
    }

    /** Original: g.a(PTVLoginInfo) — se não vier lista, cria uma assinatura sintética com planName/expireTime. */
    private fun buildSubscriptions(data: PTVLoginInfo): List<AccountSubscription> {
        val list = data.accountSubscriptionList ?: ArrayList()
        if (list.isEmpty() && (!data.planName.isNullOrEmpty() || data.expireTime > 0)) {
            return listOf(AccountSubscription().apply {
                productName = data.planName
                expireTs = data.expireTime
            })
        }
        return list
    }

    /** Backend Extra: registro. Original: g.b(contact, digitalCode, passwordDigest, RegisterInfo). */
    fun fromRegister(contact: String, digitalCode: String?, passwordDigest: String, data: RegisterInfo): LocalSessionInfo {
        val s = UserManager.getLocalSessionInfo() ?: LocalSessionInfo()
        s.accountId = data.accountId!!
        s.accountName = data.accountName
        s.accountType = data.accountType
        s.businessType = data.businessType
        s.passwordDigest = passwordDigest
        s.username = contact
        if (digitalCode.isNullOrEmpty()) {
            s.email = contact
        } else {
            s.digitalCode = digitalCode
            if (contact.contains(digitalCode)) {
                s.phoneNumber = contact.replace(digitalCode, "")
                s.phone = contact
            }
        }
        if (s.streamToken != data.streamToken && !data.streamToken.isNullOrEmpty()) s.streamToken = data.streamToken
        UserManager.setLocalSessionInfo(s)
        return s
    }

    /** Backend Extra: login por usuário. Original: g.c(username, passwordDigit, LoginInfo). */
    fun fromExtraLogin(username: String, passwordDigit: String, data: LoginInfo): LocalSessionInfo {
        if (BaseLibConfig.isDebug) logger.debug("apiExtra loginInfo[ {} ]", data)
        val s = UserManager.getLocalSessionInfo() ?: LocalSessionInfo()
        s.accountId = data.accountId!!
        s.accountName = data.accountName
        s.accountType = data.accountType
        s.businessType = data.businessType
        s.passwordDigest = passwordDigit
        s.username = username
        s.streamToken = data.streamToken
        s.accessToken = data.accessToken
        s.refreshToken = data.refreshToken
        s.accessTokenExpiresTS = data.accessTokenExpiresIn
        s.refreshTokenExpiresTS = data.refreshTokenExpiresIn
        s.accountSubscriptionList = data.accountSubscriptionList
        s.streamServers = data.streamServers
        s.code = data.code
        s.email = data.email
        s.digitalCode = data.digitalCode
        s.hasPassword = data.hasPassword
        s.isLogout = false
        val phone = data.phone
        s.phoneNumber = when {
            phone.isNullOrEmpty() -> ""
            // Original: ac.g.n (startsWith) / ac.g.p (substring a partir do tamanho do DDI)
            data.digitalCode.isNullOrEmpty() || !phone.startsWith(data.digitalCode) -> phone
            else -> phone.substring(data.digitalCode.length)
        }
        s.phone = if (s.phoneNumber.isNullOrEmpty()) "" else if (!username.endsWith(s.phoneNumber)) s.digitalCode + s.phoneNumber else username
        data.freeTime?.let { s.freeTimeMs = if (it > 0) 60000L * it else 0L }
        s.latestLoginResponseTime = now()
        if (BaseLibConfig.isDebug) logger.debug("convert session to local [{}] -> [{}}", data, s)
        UserManager.setLocalSessionInfo(s)
        return s
    }

    /** Original: g.e(RechargeInfo). */
    fun fromRecharge(data: RechargeInfo): LocalSessionInfo {
        val s = UserManager.getLocalSessionInfo() ?: LocalSessionInfo()
        s.accountId = data.accountId
        s.accountSubscriptionList = data.accountSubscriptionList
        s.isLogout = false
        s.latestLoginResponseTime = now()
        UserManager.setLocalSessionInfo(s)
        return s
    }

    /** Backend Extra: convidado. Original: g.f(GuestLoginInfo) — zera usuário/senha/contatos. */
    fun fromGuestLogin(data: GuestLoginInfo): LocalSessionInfo {
        if (BaseLibConfig.isDebug) logger.debug("apiExtra loginInfo[ {} ]", data)
        val s = UserManager.getLocalSessionInfo() ?: LocalSessionInfo()
        s.accountId = data.accountId!!
        s.accountName = data.accountName
        s.accountType = data.accountType
        s.businessType = data.businessType
        s.passwordDigest = ""
        s.username = ""
        s.streamToken = data.streamToken
        s.accessToken = data.accessToken
        s.refreshToken = data.refreshToken
        s.accessTokenExpiresTS = data.accessTokenExpiresIn
        s.refreshTokenExpiresTS = data.refreshTokenExpiresIn
        s.accountSubscriptionList = data.accountSubscriptionList
        s.streamServers = data.streamServers
        s.code = ""; s.email = ""; s.digitalCode = ""; s.phoneNumber = ""; s.phone = ""
        s.isLogout = false
        data.freeTime?.let { s.freeTimeMs = if (it > 0) 60000L * it else 0L }
        s.latestLoginResponseTime = now()
        if (BaseLibConfig.isDebug) logger.debug("convert session to local [{}] -> [{}}", data, s)
        UserManager.setLocalSessionInfo(s)
        return s
    }

    /**
     * Backend Extra: refresh. Original: g.g(RefreshInfo).
     * Nota: NÃO chama setLocalSessionInfo; atualiza o objeto e empurra o stream token ao engine.
     */
    fun fromRefresh(data: RefreshInfo): LocalSessionInfo {
        val s = UserManager.getLocalSessionInfo() ?: LocalSessionInfo()
        s.refreshToken = data.refreshToken
        s.accessToken = data.accessToken
        s.refreshTokenExpiresTS = data.refreshTokenExpiresIn
        s.accessTokenExpiresTS = data.accessTokenExpiresIn
        s.streamToken = data.streamToken
        if (!data.accountSubscriptionList.isNullOrEmpty()) s.accountSubscriptionList = data.accountSubscriptionList
        s.accountId = data.accountId!!
        s.businessType = data.businessType
        s.latestTokenUpdateTime = now()
        try {
            TODO("streaming/client/a (EngineHelper).p(data.streamToken): refreshToken do engine")
        } catch (t: Throwable) {
            logger.warn("refresh stream token failure", t)
        }
        return s
    }

    /** Original: g.h(LoginInfo) — atualiza só contatos (usado no código 10100035 e meta-info Extra). */
    fun updateContact(data: LoginInfo): LocalSessionInfo {
        val s = UserManager.getLocalSessionInfo() ?: LocalSessionInfo()
        s.email = data.email
        s.phone = data.phone
        s.digitalCode = data.digitalCode
        s.randomName = data.randomName
        s.hasPassword = data.hasPassword
        s.isLogout = false
        s.latestLoginResponseTime = now()
        UserManager.setLocalSessionInfo(s)
        return s
    }
}
