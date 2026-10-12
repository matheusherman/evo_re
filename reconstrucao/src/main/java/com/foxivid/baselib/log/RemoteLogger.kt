package com.foxivid.baselib.log

import com.foxivid.baselib.device.DeviceInfoCollector
import com.foxivid.baselib.media.PlayerState
import com.foxivid.baselib.util.AppAttrUtils
import com.foxivid.baselib.util.AppInfo
import com.foxivid.baselib.util.EcoModeManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicLong

/**
 * Logger remoto: formata cada linha de log do SDK e a envia via [UdpLogSender].
 *
 * Original: x1/f1/lb/log/a.java (nome Kotlin original `RemoteLogger.kt`)
 *
 * ### Ligação com o logger q6 (documentação apenas)
 * Em `x1/f1/lb/config/b.java` (~linhas 295-400, classe interna `b$g implements q6.a`, instalada por
 * `b.s()` → `q6.c.e(new g())`) cada nível do logger q6 vai para:
 * - `debug`/`f` (debug c/ throwable): apenas `Log.d`, se `isDebug` — **não** vai para o remoto;
 * - `g`/`e` (info): `Log.i` (se debug) + `RemoteLogger.log("I", ...)`;
 * - `c`/`a` (warn): `Log.w` (se debug) + `RemoteLogger.log("W", ...)`;
 * - `b`/`d` (error): `Log.e` (se debug) + `RemoteLogger.log("E", ...)`.
 * Em release, a mensagem logada localmente é cifrada com `util/a.c(msg, false)` (chave fixa);
 * a stack trace vem de `cc.a.a(throwable)`. Já no Kotlin reconstruído ver `SdkLogBackend` em
 * `config/BaseLibConfig.kt`.
 *
 * Linhas ficam numa fila (`toSendLog`) até existir sender **e** uid (após login, [setIdentity]).
 */
object RemoteLogger {
    /** Original: a.tag */ private val tag: String = RemoteLogger::class.java.simpleName
    /** Original: a.udpLogger */ private var udpLogger: UdpLogSender? = null
    /** Original: a.dns (mf.b — resolvedor DNS próprio do SDK) */ private val dns = com.foxivid.baselib.network.SdkDns()
    /** Original: a.originalServers */ private var originalServers: Array<String>? = null
    /** Original: a.logSeq */ private val logSeq = AtomicLong(1L)
    /** Original: a.lastSentLogTxt — suprime linhas idênticas consecutivas */ private var lastSentLogTxt: String? = null
    /** Original: a.uid */ private var uid = ""
    /** Original: a.toSendLog — texto → (seq, tag) */ private val toSendLog = LinkedHashMap<String, Pair<Long, String>>()

    /**
     * Formata uma linha:
     * ` [tenantId.brandId.<s|m>.appVer][appVersionName] msbkta[<mobile><sim><battery><k><l><v>] [seq] [L] tag: msg\nstack`
     * - `s` se appType == "stb", senão `m`;
     * - msbkta = flags mobileFlag/simFlag/batteryFlag (util/z, "?" se null) + 3 booleanos (0/1):
     *   util/d0.k(), util/d0.l() (estado do modo eco) e media/d.v() (estado do player).
     *
     * Original: a.e(long, String, String, String, String)
     */
    private fun format(seq: Long, tag: String, level: String, msg: String, stackTrace: String?): String? = try {
        val t = if (AppInfo.appType() == "stb") "s" else "m"
        val mobile: Any = DeviceInfoCollector.mobileFlag() ?: "?"
        val sim: Any = DeviceInfoCollector.simFlag() ?: "?"
        val battery: Any = DeviceInfoCollector.batteryFlag() ?: "?"
        val k = if (EcoModeManager.flagK()) 1 else 0
        val l = if (EcoModeManager.flagL()) 1 else 0
        val v = if (PlayerState.flagV()) 1 else 0
        val st = if (stackTrace != null) "\n$stackTrace" else ""
        " [${AppInfo.tenantId()}.${AppInfo.brandId()}.$t.${AppAttrUtils.appVersion()}][${AppInfo.appVersionName()}] " +
            "msbkta[$mobile$sim$battery$k$l$v] [$seq] [$level] $tag: $msg$st"
    } catch (_: Throwable) {
        null
    }

    /**
     * Envia de fato (corrotina IO). No primeiro log da execução (seq == 1) envia antes uma linha
     * `app_start brand[..] model[..] mac[..]`.
     *
     * Original: a.k(long, String, String) + a$a
     */
    private fun sendLog(seq: Long, tag: String, text: String) {
        val sender = udpLogger ?: return
        CoroutineScope(Dispatchers.IO).launch {
            if (seq == 1L) {
                try {
                    sender.send(format(0L, tag, "I",
                        "app_start brand[${DeviceInfoCollector.brand()}] model[${DeviceInfoCollector.model()}] mac[${DeviceInfoCollector.mac()}]", null)!!)
                } catch (_: Throwable) {}
            }
            try { sender.send(text) } catch (_: Throwable) {}
        }
    }

    /**
     * Stub vazio no original: as mensagens do [com.foxivid.baselib.bot.TelegramBot] terminam aqui e
     * são descartadas.
     *
     * Original: a.g(String)
     */
    @Suppress("UNUSED_PARAMETER")
    fun botMessage(msg: String) {
        // vazio no original
    }

    /** Original: a.h(String, String, String, String) / a.i (stackTrace default null) */
    fun log(logLevel: String, tag: String, msg: String, stackTrace: String? = null) {
        val seq = logSeq.getAndIncrement()
        val text = format(seq, tag, logLevel, msg, stackTrace)
        if (text == null || text == lastSentLogTxt) return
        lastSentLogTxt = text
        if (udpLogger == null || uid.isEmpty()) {
            synchronized(toSendLog) { toSendLog[text] = Pair(seq, tag) }
            return
        }
        sendLog(seq, tag, text)
    }

    /**
     * Define o prefixo `[channel][uid][did]` e despeja a fila pendente.
     *
     * Original: a.l(String, String, String)
     */
    fun setIdentity(channelId: String, uid: String, did: String) {
        udpLogger?.setIdentity(channelId, uid, did)
        this.uid = uid
        if (toSendLog.isEmpty()) return
        synchronized(toSendLog) {
            for ((text, v) in toSendLog) sendLog(v.first, v.second, text)
            toSendLog.clear()
        }
    }

    /**
     * Define os servidores UDP ("host:porta"). Cada host é resolvido via DNS próprio e expandido em
     * "ip:porta"; se a resolução falhar, mantém a entrada original. Cria o sender na primeira vez
     * com (distributionChannel, of.a.b() [uid de startup], did).
     *
     * Original: a.m(String[]) + a$b + a.j(String[])
     */
    fun setUdpLoggerServer(servers: Array<String>) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val resolved = resolve(servers)
                originalServers = servers
                val s = udpLogger
                if (s == null) udpLogger = UdpLogSender(resolved, AppAttrUtils.distributionChannel(), AppAttrUtils.startupUid(), AppAttrUtils.did())
                else s.setServers(resolved)
            } catch (_: Throwable) {}
        }
    }

    /** Original: a.j(String[]) */
    private fun resolve(servers: Array<String>): Array<String> {
        val set = HashSet<String>()
        for (server in servers) {
            val parts = server.split(":").dropLastWhile { it.isEmpty() }
            if (parts.size == 2) {
                try {
                    for (addr in dns.lookup(parts[0])) addr.hostAddress?.let { set.add(it + ":" + parts[1]) }
                } catch (_: Throwable) {
                    set.add(server)
                }
            }
        }
        return set.toTypedArray()
    }
}
