package com.foxivid.baselib.metric.monitor

import com.foxivid.baselib.bot.TelegramBot
import com.foxivid.baselib.metric.model.AccountInfo
import com.foxivid.baselib.metric.model.PlayEndMetric
import com.foxivid.baselib.metric.model.SystemInfo
import com.foxivid.baselib.metric.model.UpgradeMetric
import com.foxivid.baselib.metric.model.ZappingTimeMetric
import com.foxivid.baselib.user.UserManager
import com.foxivid.baselib.util.AppInfo
import com.foxivid.baselib.util.Clock
import com.foxivid.baselib.util.DateFormats
import com.foxivid.baselib.util.LoggerFactory
import com.foxivid.baselib.util.Preferences
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import java.util.Locale
import kotlin.math.abs

/**
 * Log de uso do app ("app_use_info, ...") e detecção de cliente novo / troca de conta, com
 * mensagens para o [TelegramBot] (que no APK não envia nada).
 *
 * Original: x1/f1/lb/metric/monitor/a.java (nome Kotlin original `AppUsageMonitor.kt`)
 *
 * Persistência em prefs: "app_usage_system_info" (SystemInfo JSON) e "account_info" (AccountInfo JSON).
 */
object AppUsageMonitor {
    private val logger = LoggerFactory.getLogger(AppUsageMonitor::class.java)
    private var lastSystemInfo: SystemInfo? = null
    private var lastAccountInfo: AccountInfo? = null
    private var lastLogSystemInfo: SystemInfo? = null
    private var lastLogAccountInfo: AccountInfo? = null
    private var session = 0L
    private var zappingSession = 0L
    private var zappingTime = 0L

    /** Inicializa o bot e carrega o último SystemInfo/AccountInfo salvos. Original: a.h() + a$a */
    fun init() {
        CoroutineScope(Dispatchers.IO).launch {
            TelegramBot.init()
            val gson = Gson()
            Preferences.get("app_usage_system_info", "")
                .catch { logger.error("load system info failure", it) }
                .collect {
                    if (it.isEmpty()) return@collect
                    try { lastSystemInfo = gson.fromJson(it, SystemInfo::class.java) } catch (t: Throwable) { logger.error("parse system info failure", t) }
                }
            Preferences.get("account_info", "")
                .catch { logger.error("load account info failure", it) }
                .collect {
                    if (it.isEmpty()) return@collect
                    try { lastAccountInfo = gson.fromJson(it, AccountInfo::class.java) } catch (t: Throwable) { logger.error("parse account info failure", t) }
                }
        }
    }

    /** Original: a.g — compara strings com trim, null = "". */
    private fun sameText(a: String?, b: String?) = (a ?: "").trim() == (b ?: "").trim()

    /** Original: a.i — compara planos ignorando caixa; "" e "expired" são considerados iguais. */
    private fun samePlan(p1: String?, p2: String?): Boolean {
        val a = (p1 ?: "").trim().lowercase(Locale.ROOT)
        val b = (p2 ?: "").trim().lowercase(Locale.ROOT)
        if (a == b) return true
        return (a.isEmpty() && b == "expired") || (a == "expired" && b.isEmpty())
    }

    /** Original: a.k */
    private fun leftText(expireTS: Long, leftDur: Long): String = if (expireTS <= 0) "" else DateFormats.durationText(abs(leftDur))
    /** Original: a.l */
    private fun planName(plan: String?) = if (plan.isNullOrEmpty()) "none" else plan.trim()
    /** Original: a.j */
    private fun planDesc(expireTS: Long, planName: String, leftDur: Long): String {
        val t = leftText(expireTS, leftDur)
        return when {
            t.isEmpty() -> "[$planName]"
            leftDur < 0 -> "[$planName($t expired)]"
            else -> "[$planName($t left)]"
        }
    }

    /** Original: a.e / a.f (remark default "") — linha "desc: old -> new(remark)\n" */
    fun appendChange(builder: StringBuilder, desc: String, old: Any?, new: Any?, remark: String = "") {
        builder.append(desc).append(": ").append(old).append(" -> ").append(new)
        if (remark.isNotEmpty()) builder.append("(").append(remark).append(")")
        builder.append("\n")
    }

    /**
     * Login de conta: registra mudanças campo a campo e manda mensagem `[client first login]`,
     * `[client account change]`, `[client first account login]` ou `[client switch account]`.
     *
     * Original: a.p(AccountInfo, String)
     */
    fun setAccountInfo(accountInfo: AccountInfo, remainDays: String) {
        synchronized("account_info") {
            val prev = lastAccountInfo
            if (accountInfo == prev) {
                if (lastLogAccountInfo == null) {
                    logger.info("app_use_info, account login: remainDays[$remainDays] ${Gson().toJson(accountInfo)}")
                    lastLogAccountInfo = accountInfo
                }
                return
            }
            val gson = Gson()
            val json = gson.toJson(accountInfo)
            val sb = StringBuilder()
            if (prev == null) {
                logger.info("app_use_info, new account login: remainDays[$remainDays] $json")
            } else {
                if (!sameText(accountInfo.appChannel, prev.appChannel)) appendChange(sb, "chanel", prev.appChannel, accountInfo.appChannel)
                if (!sameText(accountInfo.accountType, prev.accountType)) appendChange(sb, "acctType", prev.accountType, accountInfo.accountType)
                if (accountInfo.accountId != prev.accountId) appendChange(sb, "account", "${prev.username}(${prev.accountId})", "${accountInfo.username}(${accountInfo.accountId})")
                if (!samePlan(accountInfo.plan, prev.plan)) appendChange(sb, "plan", prev.plan, accountInfo.plan)
                if (!sameText(accountInfo.email, prev.email)) appendChange(sb, "email", prev.email, accountInfo.email)
                if (!sameText(accountInfo.phone, prev.phone)) appendChange(sb, "phone", prev.phone, accountInfo.phone)
                if (!sameText(accountInfo.code, prev.code)) appendChange(sb, "code", prev.code, accountInfo.code)
                if (accountInfo.expireTS != prev.expireTS) {
                    val now = Clock.now()
                    val oldTs = prev.expireTS ?: 0L
                    val newTs = accountInfo.expireTS ?: 0L
                    appendChange(sb, "expireTS", prev.expireTS, accountInfo.expireTS,
                        planDesc(oldTs, planName(prev.plan), oldTs - now) + " -> " + planDesc(newTs, planName(accountInfo.plan), newTs - now))
                }
                if (!sameText(accountInfo.did, prev.did)) appendChange(sb, "did", prev.did, accountInfo.did)
                if (!sameText(accountInfo.androidId, prev.androidId)) appendChange(sb, "androidId", prev.androidId, accountInfo.androidId)
                if (sb.isNotEmpty()) logger.info("app_use_info, account login, but changed: remainDays[$remainDays] ${gson.toJson(prev)} -> $json")
            }
            try {
                if (prev == null) {
                    val acc: Any? = if (accountInfo.username.isNullOrEmpty()) accountInfo.accountId else "${accountInfo.username}(${accountInfo.accountId})"
                    TelegramBot.sendBiz("[client first login]\naccount: $acc\ntype: ${accountInfo.accountType}\nplan: ${accountInfo.plan}\nremain: $remainDays")
                } else if (prev.username == accountInfo.username || accountInfo.username.isNullOrEmpty()) {
                    if (sb.isNotEmpty()) TelegramBot.sendBiz("[client account change]\n$sb\nremain: $remainDays days")
                } else if (prev.username.isNullOrEmpty()) {
                    TelegramBot.sendBiz("[client first account login]\naccount: ${accountInfo.username}(${accountInfo.accountId})\ntype: ${accountInfo.accountType}\nplan: ${accountInfo.plan}\nremain: $remainDays days")
                } else {
                    val sep = if (prev.plan.isNullOrEmpty()) "" else ", "
                    TelegramBot.sendBiz("[client switch account]\nfrom: ${prev.username}(${prev.accountId}), ${prev.accountType}$sep${prev.plan}" +
                        "\nto: ${accountInfo.username}(${accountInfo.accountId})type: ${UserManager.getAccountType()}\nplan: ${accountInfo.plan}\nremain: $remainDays days")
                }
                lastAccountInfo = accountInfo
                lastLogAccountInfo = accountInfo
                Preferences.putString("account_info", json)
            } catch (t: Throwable) {
                logger.error("set account info failure", t)
            }
        }
    }

    /** Original: a.d(vf.e) */
    fun logUpgrade(m: UpgradeMetric) {
        try { logger.info("app_use_info, app upgrade, " + Gson().toJson(m)) } catch (t: Throwable) { logger.error("app upgrade log failure", t) }
    }

    /** Original: a.m(Map) */
    fun logAbnormal(map: Map<String, Any?>) { logger.info("app_use_info, session[$session] play abnormal: $map") }

    /** Original: a.n(vf.f) */
    fun onZappingTime(m: ZappingTimeMetric) { zappingSession = m.session; zappingTime = m.zappingTimeMs }

    /** Original: a.o(vf.a) */
    fun logPlayEnd(m: PlayEndMetric) {
        val dur = DateFormats.durationText(Clock.elapsed() - m.session)
        val zt = if (m.session == zappingSession) zappingTime else -1L
        logger.info("app_use_info, session[$session] play end[${m.playType}][${m.channel}][${m.streamId}] start at[${m.session}] zt[$zt] dur[$dur] " +
            "rtt[${m.minRtt}, ${m.avgRtt}, ${m.maxRtt}] buffering[${DateFormats.durationText(m.bufferingMs)}] noSignal[${m.noSignalCnt}] restart[${m.restartPlayerCnt}]")
    }

    /**
     * Início do cliente: detecta aparelho novo (`[new client]` para o bot) ou alterado.
     * Original: a.q(SystemInfo, long)
     */
    fun setSystemInfo(systemInfo: SystemInfo, session: Long) {
        synchronized("system_info") {
            try {
                val prev = lastSystemInfo
                val pkg = AppInfo.packageName()
                this.session = session
                if (systemInfo == prev) {
                    if (lastLogSystemInfo == null) {
                        logger.info("app_use_info, client start: [$pkg] session[$session] ${Gson().toJson(systemInfo)}")
                        lastLogSystemInfo = systemInfo
                    }
                    return
                }
                val gson = Gson()
                val json = gson.toJson(systemInfo)
                if (prev == null) {
                    logger.info("app_use_info, new client created: [$pkg] session[$session]  $json")
                    val mac = systemInfo.etherMac?.let { if (it.isEmpty()) systemInfo.wifiMac else it }
                    TelegramBot.sendBiz("[new client]\nmanufacture: ${systemInfo.manufacturer}, brand: ${systemInfo.brand}, model: ${systemInfo.model}\nmac: $mac\n${systemInfo.fingerprint}")
                } else {
                    logger.info("app_use_info, client start, but changed: [$pkg] session[$session] ${gson.toJson(prev)} -> $json")
                }
                lastSystemInfo = systemInfo
                lastLogSystemInfo = systemInfo
                Preferences.putString("app_usage_system_info", json)
            } catch (t: Throwable) {
                logger.error("set system info failure", t)
            }
        }
    }
}
