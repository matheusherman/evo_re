package com.live.evo.util

import com.foxivid.baselib.config.InteractionUtils
import com.foxivid.baselib.heartbeat.HeartbeatManager
import com.foxivid.baselib.media.ChannelManager
import com.foxivid.baselib.media.EpgManager
import com.foxivid.baselib.user.UserManager
import com.live.evo.model.AccountBean
import com.live.evo.model.SubscribeBean
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.foxivid.baselib.model.meta.ChannelStreamResponse
import com.foxivid.baselib.model.meta.EPGProgramme
import com.live.evo.model.ChannelData
import com.live.evo.model.ProgramBean
import kotlinx.coroutines.flow.Flow
import org.slf4j.LoggerFactory

/**
 * Camada de tradução entre os modelos do SDK (`ChannelStreamResponse`, `EPGProgramme`) e os modelos
 * da UI ([ChannelData] = i5.h, [ProgramBean] = i5.p, SubscribeBean = i5.c0, CategoryBean = i5.i...).
 * Também é "fachada" de várias consultas à baselib (`t.v.c.i.a` = InteractionUtils no original, que só delega a UserManager/ChannelManager/EpgManager).
 * Nome real (metadata Kotlin): ModelHelper.
 *
 * Original: com/live/evo/util/s0.java  (anteriormente referenciado como `EpgRepository` em outras classes)
 */
object ModelHelper {
    private val logger = LoggerFactory.getLogger(ModelHelper::class.java)

    /**
     * Modo de boas-vindas / tipo de conta: se `UserManager.getUsername()` (InteractionUtils.Z) vazio → (isGuestOrLoggedOut ? 1 : 3);
     * e-mail ([AccountValidators.isEmail], o5.c.a) → 2; telefone ([AccountValidators.isPhoneWithPlus], o5.c.b) → 6; senão -1. Original: D() (também r())
     */
    fun welcomeMode(): Int {
        val username = UserManager.getUsername()
        if (username.isEmpty()) return if (UserManager.isGuestOrLoggedOut()) 1 else 3
        if (AccountValidators.isEmail(username)) return 2
        return if (AccountValidators.isPhoneWithPlus(username)) 6 else -1
    }
    fun accountMode(): Int = welcomeMode()

    /** Alias `D()` (modo de boas-vindas) usado por AppUserManager. Original: D() */
    fun D(): Int = welcomeMode()
    /** Canal por id (ChannelData). Original: s(String) */
    fun findChannel(channelId: String?): ChannelData? {
        if (channelId == null) return null
        return try { ChannelManager.channel(channelId.toInt())?.let { toChannel(it) } }
        catch (t: Throwable) { logger.error("get channel by id[$channelId] failure", t); null }
    }
    /** Pré-carrega imagens dos canais (corrotina). Original: y(channels, imageCache, resources, callback) */
    fun prefetch(channels: List<ChannelData>, cache: ImageCache, resources: android.content.res.Resources, callback: () -> Unit): Unit = TODO("s0.y corrotina c")
    /** Original: l(EPGProgramme) */
    fun toEpgBean(p: EPGProgramme): ProgramBean = toProgram(p)
    /** (seq, epgBean, channel) -> SubscribeBean. Original: e(int, p, ChannelStreamResponse) */
    fun toSubscribeBean(seq: Int, epg: ProgramBean, channel: ChannelStreamResponse): SubscribeBean =
        SubscribeBean(seq.toLong(), epg.b(), epg.e(), channelIndex(channel) ?: 0, channel.streamName, channel.key.toString(), epg.f()).also {
            it.endTimeMs = epg.g(); it.iconUrl = channel.iconUrl
        }

    /** Original: R() → !InteractionUtils.j0() = !EpgManager.isUpdateComplete() (c.F()) */
    fun isEpgNotReady(): Boolean = !EpgManager.isUpdateComplete()

    /** Número do canal (índice) = Integer(ChannelManager.channelNumber(channel)) - 1 (InteractionUtils.b), null em erro. Original: P(ChannelStreamResponse) */
    fun channelIndex(channel: ChannelStreamResponse): Int? = try {
        ChannelManager.channelNumber(channel).toInt() - 1
    } catch (t: Throwable) { logger.error("convert channel num failure", t); null }

    /**
     * Existe catch-up para o programa? Canal precisa ter `isCatchup()` e (startTime == null ou startTime > agora).
     * Original: M(String epgId, String channelId, Long startTime)
     */
    fun isCatchUpAvailable(epgId: String?, channelId: String?, startTime: Long?): Boolean {
        if (channelId == null) return false
        return try {
            val ch = ChannelManager.channel(channelId.toInt())
            if (ch == null || !ch.catchup) false else startTime == null || startTime > ServerClock.get().now()
        } catch (e: NumberFormatException) { logger.error("parse channel id failure", e); false }
    }

    /** SDK EPGProgramme -> [ProgramBean] (id=start, canal, start, título, ...). Original: l(EPGProgramme) */
    fun toProgram(p: EPGProgramme): ProgramBean =
        ProgramBean(id = p.start, channel = p.channel, startTime = p.start, title = p.title, endTime = p.stop, epgId = "", description = p.desc)

    /** ChannelStreamResponse -> [ChannelData]: key, número, nome, ícone, epgId, catchup, adulto, playerArgs. Original: h() */
    fun toChannel(channel: ChannelStreamResponse): ChannelData {
        val idx = channelIndex(channel) ?: 0
        return ChannelData().also {
            it.channelId = channel.key.toString()
            it.isAdult = channel.isTypeOneOrThree()        // s(channel.c())
            it.isFavorite = if (ChannelManager.isFavorite(channel.key)) 1 else 0   // C(m0(key))
            it.isCatchup = channel.catchup
            it.iconUrl = channel.iconUrl
            it.name = channel.streamName
            it.epgId = channel.epgId
            it.number = idx
            it.numberOneBased = idx + 1
            it.playerArgs = channel.playerArgs
        }
    }

    /** Original: i(List, boolean) — filtra adulto se não incluído. */
    fun toChannels(list: List<ChannelStreamResponse>, includeAdult: Boolean): List<ChannelData> =
        list.filter { !it.isTypeOneOrThree() || includeAdult }.map { toChannel(it) }

    /** Original: x(String column, boolean) / w() */
    fun channelsOfColumn(column: String, includeAdult: Boolean): List<ChannelData> =
        ChannelManager.channelsOf(column, includeAdult).map { toChannel(it) }

    /** EPG do canal como Flow (atual + próxima, `EpgBeanDaoUtils.getTwoEpg`). Original: A(String channelId, String epgId) */
    fun epgFlow(channelId: String, epgId: String): Flow<List<ProgramBean>> = EpgBeanDaoUtils.getTwoEpg(epgId)

    /**
     * Conteúdo do QR do site de membros: `UserManager.getMembershipQrUrl()` + "&c=" + ("1" sem username, "2#plan" com).
     * Original: InteractionUtils.P() (t/v/c/i/a)
     */
    fun membershipQrContent(): String {
        val q = UserManager.getMembershipQrUrl()
        if (q.isEmpty()) return ""
        return q + "&c=" + (if (UserManager.getUsername().isEmpty()) "1" else "2#plan")
    }

    /** Texto de suporte (e-mail do suporte do SDK, ou string `R.string.us` se vazio). Original: z() */
    fun supportText(): String =
        HeartbeatManager.customerServiceEmail.ifEmpty { CommonUtils.string(com.live.evo.R.string.us) }

    /** Original: N() → x1.f1.lb.config.b.j() (campo `hasSubject`) */
    fun isConfigFlagN(): Boolean = com.foxivid.baselib.config.BaseLibConfig.hasSubject

    /** Placeholder sem lógica (retorna 0). Original: L() */ fun l(): Int = 0
    /** Original: F() */ fun notices(): List<Any> = emptyList()

    /** Carrega tipos de subject (esportes) do SDK com callback. Original: I(callback) */
    fun loadSubjectTypes(callback: (Any?) -> Unit): Unit = TODO("MediaRepository subject types (j5.h)")
    /** Última conta salva (AccountBean). Original: p() */
    fun savedAccount(): AccountBean? {
        val name = UserManager.getUsername().ifEmpty { UserManager.getLocalSessionInfo()?.lastUsername ?: "" }   // InteractionUtils.i()
        if (name.isEmpty()) return null
        val a = AccountBean()
        if (AccountValidators.isPhone(name, "")) {
            a.accountName = name.replace("+55", ""); a.type = 1; a.phonePreCode = "+55"; a.countryCode = "BR"
        } else {
            a.type = 0; a.accountName = name
        }
        a.password = ""
        return a
    }

    // Operações assíncronas (corrotinas) – corpos resumidos:
    /** Login com renew code (corrotina IO). Original: T(renewCode, isCreateAccount, callback(ok, code, msg, throwable)) */
    fun loginWithRenewCode(renewCode: String, isCreateAccount: Boolean, callback: (Boolean, Int?, String?, Throwable?) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            UserManager.loginByCode(renewCode)            // InteractionUtils.w0 → f.e1
                .catch { th -> withContext(Dispatchers.Main) { callback(false, null, null, th) } }
                .collect { r -> withContext(Dispatchers.Main) { callback(r.first, r.second, r.third, null) } }
        }
    }
    /** Login com conta/senha (accountLoginType). Original: U(ccPassword, accountLoginType, callback) */
    fun loginWithAccount(password: String, accountLoginType: Int, callback: (Boolean, Int?, String?, Throwable?) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            UserManager.recharge(password)                 // InteractionUtils.B0 → f.s1 (`ModelHelper$recharge$1`)
                .catch { th -> withContext(Dispatchers.Main) { callback(false, null, null, th) } }
                .collect { r -> withContext(Dispatchers.Main) { callback(r.first, r.second, r.third, null) } }
        }
    }
    /**
     * Agenda/cancela lembrete de um programa (corrotina `ModelHelper$updateSubscribe$1`): reaproveita o [SubscribeBean] existente
     * (marcando `k(1)`) ou cria um novo, chama `ChannelManager.toggleSubscribe` (InteractionUtils.J0 → a.g0) e devolve o bean na Main.
     * Original: W(channelName, icon, inAllPos, bean, channelId, subscribeType, callback, subscribeItem)
     */
    fun subscribeProgram(channelName: String, icon: String, inAllPos: Int, bean: ProgramBean, channelId: String, subscribeType: String,
                         callback: (SubscribeBean) -> Unit, item: com.foxivid.baselib.media.model.SubscribeItem?) {
        CoroutineScope(Dispatchers.IO).launch {
            val existing = subscribeBeanFor(bean, channelId)
            val sb = existing ?: SubscribeBean(0L, bean.b(), bean.e(), inAllPos, channelName, channelId, bean.f()).also { it.endTimeMs = bean.g(); it.iconUrl = icon }
            ChannelManager.toggleSubscribe(channelId.toInt(), bean.f(), bean.b() ?: "", item)
            withContext(Dispatchers.Main) { callback(sb) }
        }
    }

    /** Original: J(epgBean, channelId) — só se o programa já estiver agendado ([isSubscribed]). */
    fun subscribeBeanFor(epgBean: ProgramBean, channelId: String?): SubscribeBean? {
        if (channelId == null || !isSubscribed(epgBean, channelId)) return null
        val ch = ChannelManager.channel(channelId.toInt()) ?: return null
        return toSubscribeBean(0, epgBean, ch)
    }

    /** Original: O(epgBean, channelId) → InteractionUtils.h0 = ChannelManager.isSubscribed */
    fun isSubscribed(epgBean: ProgramBean, channelId: String?): Boolean {
        if (channelId.isNullOrEmpty()) return false
        return try { ChannelManager.isSubscribed(channelId.toInt(), epgBean.f(), epgBean.b() ?: "") }
        catch (e: NumberFormatException) { logger.error("parse channel id failure", e); false }
    }

    /** Atualiza a lista de lembretes (corrotina `updateSubscribeList$1`). Original: X(bean, subscribeItem) */
    fun updateSubscribeList(bean: SubscribeBean, item: com.foxivid.baselib.media.model.SubscribeItem?) {
        CoroutineScope(Dispatchers.IO).launch {
            ChannelManager.toggleSubscribe(bean.channelId!!.toInt(), bean.h(), bean.d() ?: "", item)
        }
    }
}

/** Alias de compatibilidade: outras classes citam `EpgRepository`. */
typealias EpgRepository = ModelHelper

/**
 * Consulta dois programas de EPG (atual e próximo) a partir do relógio do servidor:
 * `EpgManager.getTwoProgrammesAt(epgId, now)` retorna par (atual, próximo) e converte com [ModelHelper.toProgram].
 * Original: com/live/evo/util/p.java (nome real EpgBeanDaoUtils; função `getTwoEpg`)
 */
object EpgBeanDaoUtils {
    fun getTwoEpg(epgId: String): Flow<List<ProgramBean>> = kotlinx.coroutines.flow.flow {
        val list = ArrayList<ProgramBean>()
        val now = ServerClock.get().now()
        val (current, next) = EpgManager.getTwoProgrammesAt(epgId, now)   // InteractionUtils.X → c.D
        current?.let { list.add(ModelHelper.toProgram(it)) }
        next?.let { list.add(ModelHelper.toProgram(it)) }
        emit(list)   // uma única emissão: [atual, próximo]
    }
}
