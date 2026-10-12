package com.live.evo.util

import com.foxivid.baselib.config.InteractionUtils
import com.foxivid.baselib.media.MediaRepository
import com.foxivid.baselib.model.meta.ChannelStreamResponse
import com.foxivid.baselib.model.meta.EPGProgramme
import com.live.evo.model.ChannelData
import com.live.evo.model.ProgramBean
import kotlinx.coroutines.flow.Flow
import org.slf4j.LoggerFactory

/**
 * Camada de tradução entre os modelos do SDK (`ChannelStreamResponse`, `EPGProgramme`) e os modelos
 * da UI ([ChannelData] = i5.h, [ProgramBean] = i5.p, SubscribeBean = i5.c0, CategoryBean = i5.i...).
 * Também é "fachada" de várias consultas do [MediaRepository] (`t.v.c.i.a` no original).
 * Nome real (metadata Kotlin): ModelHelper.
 *
 * Original: com/live/evo/util/s0.java  (anteriormente referenciado como `EpgRepository` em outras classes)
 */
object ModelHelper {
    private val logger = LoggerFactory.getLogger(ModelHelper::class.java)

    /**
     * Modo de boas-vindas / tipo de conta: se [MediaRepository.Z] vazio → (isLocal ? 1 : 3);
     * "o5.c.a" → 2; "o5.c.b" → 6; senão -1. Original: D() (também r())
     */
    fun welcomeMode(): Int = TODO("depende de MediaRepository.Z()/l0() e o5.c.a/b (outro módulo)")
    fun accountMode(): Int = welcomeMode()

    /** Alias `D()` (modo de boas-vindas) usado por AppUserManager. Original: D() */
    fun D(): Int = welcomeMode()
    /** Canal por id (ChannelData). Original: s(String) */
    fun findChannel(channelId: String): ChannelData? = TODO("MediaRepository.j(id) -> toChannel")
    /** Pré-carrega imagens dos canais (corrotina). Original: y(channels, imageCache, resources, callback) */
    fun prefetch(channels: List<ChannelData>, cache: ImageCache, resources: android.content.res.Resources, callback: () -> Unit): Unit = TODO("s0.y corrotina c")
    /** Original: l(EPGProgramme) */
    fun toEpgBean(p: EPGProgramme): ProgramBean = toProgram(p)
    /** (seq, epgBean, channel) -> SubscribeBean. Original: e(int, p, ChannelStreamResponse) */
    fun toSubscribeBean(seq: Int, epg: ProgramBean, channel: ChannelStreamResponse): com.live.evo.model.SubscribeBean = TODO("new i5.c0(seq, epg.d(), epg.e(), idx, nome, key, ...)")

    /** Original: R() → !MediaRepository.j0() */
    fun isEpgNotReady(): Boolean = TODO("!MediaRepository.j0()")

    /** Número do canal (índice) = Integer(MediaRepository.b(channel)) - 1, null em erro. Original: P(ChannelStreamResponse) */
    fun channelIndex(channel: ChannelStreamResponse): Int? = try {
        TODO("MediaRepository.b(channel).toInt() - 1")
    } catch (t: Throwable) { logger.error("convert channel num failure", t); null }

    /**
     * Existe catch-up para o programa? Canal precisa ter `isCatchup()` e (startTime == null ou startTime > agora).
     * Original: M(String epgId, String channelId, Long startTime)
     */
    fun isCatchUpAvailable(epgId: String?, channelId: String?, startTime: Long?): Boolean {
        if (channelId == null) return false
        return try {
            val ch = TODO("MediaRepository.j(channelId.toInt())") as ChannelStreamResponse?
            if (ch == null || !ch.isCatchup()) false else startTime == null || startTime > DateUtils.now()
        } catch (e: NumberFormatException) { logger.error("parse channel id failure", e); false }
    }

    /** SDK EPGProgramme -> [ProgramBean] (id=start, canal, start, título, ...). Original: l(EPGProgramme) */
    fun toProgram(p: EPGProgramme): ProgramBean = TODO("new i5.p(start, channel, start, title, start, stop, ...) — ver s0.l")

    /** ChannelStreamResponse -> [ChannelData]: key, número, nome, ícone, epgId, catchup, adulto, playerArgs. Original: h() */
    fun toChannel(channel: ChannelStreamResponse): ChannelData = TODO("ver s0.h — setters v/s/y/C/t/A/w/u/z/B/x/D")

    /** Original: i(List, boolean) — filtra adulto se não incluído. */
    fun toChannels(list: List<ChannelStreamResponse>, includeAdult: Boolean): List<ChannelData> =
        list.filter { !it.isAdult() || includeAdult }.map { toChannel(it) }

    /** Original: x(String column, boolean) / w() */
    fun channelsOfColumn(column: String, includeAdult: Boolean): List<ChannelData> = TODO("MediaRepository.n(column, includeAdult).map(::toChannel)")

    /** EPG do canal como Flow (atual + próxima, `EpgBeanDaoUtils.getTwoEpg`). Original: A(String channelId, String epgId) */
    fun epgFlow(channelId: String, epgId: String): Flow<List<ProgramBean>> = EpgBeanDaoUtils.getTwoEpg(epgId)

    /** Texto de suporte (e-mail do suporte do SDK, ou string `R.string.us` se vazio). Original: z() */
    fun supportText(): String = TODO("MediaRepository.v() ou u0.b(R.string.us)")

    /** Original: N() → x1.f1.lb.config.b.j() */
    fun isConfigFlagN(): Boolean = TODO("baselib config flag j()")

    /** Placeholder sem lógica (retorna 0). Original: L() */ fun l(): Int = 0
    /** Original: F() */ fun notices(): List<Any> = emptyList()

    /** Carrega tipos de subject (esportes) do SDK com callback. Original: I(callback) */
    fun loadSubjectTypes(callback: (Any?) -> Unit): Unit = TODO("MediaRepository subject types (j5.h)")
    /** Última conta salva (AccountBean). Original: p() */
    fun savedAccount(): com.live.evo.model.AccountBean? = TODO("s0.p(): MediaRepository.i() + o5.a.c().h(...)")

    // Operações assíncronas (corrotinas) – corpos resumidos:
    /** Login com renew code (corrotina IO). Original: T(renewCode, isCreateAccount, callback(ok, code, msg, throwable)) */
    fun loginWithRenewCode(renewCode: String, isCreateAccount: Boolean, callback: (Boolean, Int, String?, Throwable?) -> Unit): Unit =
        TODO("corrotina s0.j → MediaRepository/UserManager (ver docs/fluxo_autenticacao.md)")
    /** Login com conta/senha (accountLoginType). Original: U(ccPassword, accountLoginType, callback) */
    fun loginWithAccount(password: String, accountLoginType: Int, callback: (Boolean, Int, String?, Throwable?) -> Unit): Unit =
        TODO("corrotina s0.k")
    /** Agenda lembrete (assinatura de programa). Original: W(...)/X(...) */
    fun subscribeProgram(): Unit = TODO("corrotinas s0.l / s0.m")
}

/** Alias de compatibilidade: outras classes citam `EpgRepository`. */
typealias EpgRepository = ModelHelper

/**
 * Consulta dois programas de EPG (atual e próximo) a partir do relógio do servidor:
 * `MediaRepository.X(epgId, now)` retorna par (atual, próximo) e converte com [ModelHelper.toProgram].
 * Original: com/live/evo/util/p.java (nome real EpgBeanDaoUtils; função `getTwoEpg`)
 */
object EpgBeanDaoUtils {
    fun getTwoEpg(epgId: String): Flow<List<ProgramBean>> = kotlinx.coroutines.flow.flow {
        val list = ArrayList<ProgramBean>()
        val now = ServerClock.get().now()
        // val (current, next) = MediaRepository.X(epgId, now)   // r8.p<EPGProgramme?, EPGProgramme?>
        // current?.let { list.add(ModelHelper.toProgram(it)) }; next?.let { ... }
        TODO("decompilação incorreta em p.a.invokeSuspend (2 emissões: lista com atual, depois com próximo)")
    }
}
