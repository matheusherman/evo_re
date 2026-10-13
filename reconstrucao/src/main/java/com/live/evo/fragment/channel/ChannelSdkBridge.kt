package com.live.evo.fragment.channel

import com.foxivid.baselib.media.ChannelManager
import com.foxivid.baselib.media.MediaConfigUtils
import com.live.evo.AppUserManager
import com.live.evo.model.CategoryBean
import com.live.evo.model.ChannelData
import com.live.evo.model.ProgramBean
import com.live.evo.util.ModelHelper

/**
 * "Ponte" entre o menu de canais ([com.live.evo.fragment.ChannelFragment]) e o SDK/camada de modelos.
 *
 * O original chama diretamente `t.v.c.i.a.f18646a.X(...)` (InteractionUtils), `com.live.evo.util.s0.f7342a.X(...)`
 * (ModelHelper) e `com.live.evo.l.n().X()` (AppUserManager). Aqui cada chamada vira uma função com nome legível
 * e a indicação do método original, para o restante do fragment ficar legível. Nada aqui é lógica nova:
 * são delegações de uma linha para [ChannelManager], [MediaConfigUtils], [ModelHelper] e [AppUserManager].
 *
 * Original: chamadas espalhadas em com/live/evo/fragment/x.java (nome real ChannelFragment).
 */
internal object ChannelSdkBridge {

    /** Original: `t.v.c.i.a.u(Boolean.TRUE)` → `media.a.x(true)`: nomes das colunas (categorias) incluindo adulto. */
    fun columns(includeAdult: Boolean = true): List<String> = ChannelManager.columns(includeAdult)

    /**
     * Original: `s0.C()` — mapa coluna → canais; cada coluna é carregada com `x(coluna, d0(coluna))`
     * (`d0` = `media.a.G` = coluna adulta, repassada como `isIncludeAdult`).
     */
    fun channelsByCategory(): HashMap<String, List<ChannelData>> {
        val map = HashMap<String, List<ChannelData>>()
        for (column in columns(true)) {
            map[column] = ModelHelper.channelsOfColumn(column, ChannelManager.isAdultColumn(column))
        }
        return map
    }

    /**
     * Original: `s0.t()` + `s0.o(seq, coluna)` — metadados de cada coluna. `seq` começa em `size` e decrementa;
     * `i5.i(seq, coluna, coluna, coluna, 0, <lista de canais>, mapa vazio, adulta ? 1 : 0)`.
     */
    fun categoryInfo(): Map<String, CategoryBean> {
        val names = columns(true)
        var seq = names.size
        val map = HashMap<String, CategoryBean>()
        for (column in names) {
            map[column] = CategoryBean(seq, column, column, if (ChannelManager.isAdultColumn(column)) 1 else 0)
            seq--
        }
        return map
    }

    /** Original: `t.v.c.i.a.J()` → `media.a.z()` (favoritos) convertido por `s0.j(lista, false)` = `s0.i(lista, false)`. */
    fun favoriteChannels(): List<ChannelData> = ModelHelper.toChannels(ChannelManager.favorites(), false)

    /** Original: `t.v.c.i.a.S()` → `media.a.D()` (histórico) convertido por `s0.i(lista, false)`. */
    fun historyChannels(): List<ChannelData> = ModelHelper.toChannels(ChannelManager.playHistory(), false)

    /** Original: `t.v.c.i.a.m0(key)` → `media.a.J(key)`. */
    fun isFavorite(channelKey: Int): Boolean = ChannelManager.isFavorite(channelKey)

    /** Original: `s0.R()` = `!j0()` — EPG ainda não carregada. */
    fun isEpgNotReady(): Boolean = ModelHelper.isEpgNotReady()

    /** Original: `t.v.c.i.a.p0(pin)` = `m.a(d.f20812a.o(), pin)` — compara com o PIN adulto salvo (MediaConfigUtils.o()). */
    fun isAdultPinValid(pin: String): Boolean = MediaConfigUtils.adultPin() == pin

    /** Original: `l.n().y()` → `t.v.c.i.a.q0()`: já existe um PIN adulto salvo. */
    fun hasAdultPin(): Boolean = MediaConfigUtils.hasAdultPin()

    /** Original: `t.v.c.i.a.u0(false, true)` → `media.a.O(false, true)`: recarrega a lista de canais (forçado). */
    fun reloadChannels() = ChannelManager.reload(isRetryAfterFailure = false, isForce = true)

    /** Original: `s0.M(epgId, channelId, startTime)`. */
    fun isCatchUpAvailable(epgId: String?, channelId: String?, startTime: Long?): Boolean =
        ModelHelper.isCatchUpAvailable(epgId, channelId, startTime)

    /** Original: `s0.O(programa, channelId)` → `t.v.c.i.a.h0(...)`: o programa já tem lembrete? (`media.a.isSubscribed`). */
    fun isSubscribed(program: ProgramBean, channelId: String?): Boolean {
        if (channelId.isNullOrEmpty()) return false
        return try {
            ChannelManager.isSubscribed(channelId.toInt(), program.f(), program.b() ?: "")
        } catch (e: NumberFormatException) { false }
    }
}

// ---------------------------------------------------------------------------------------------
// Acessores que o original usa em i5.h / i5.i mas que o modelo reconstruído (Models.kt) não carrega.
// ---------------------------------------------------------------------------------------------

/**
 * Original: `i5.h.q()` = `f11125o && f11126p != null && f11126p.size() > 0` — "canal com sub-fontes".
 * O modelo reconstruído não carrega esses campos (`h.k()` e `h.m()` também retornam null no original), logo é sempre falso.
 */
internal val ChannelData.hasSubSources: Boolean get() = false

/** Original: `i5.i.f()` (f11137h) — URL da imagem frontal do banner da categoria. Não carregado pelo modelo reconstruído. */
internal val CategoryBean.bannerFrontUrl: String? get() = null

/** Original: `i5.i.e()` (f11138i) — descrição do banner da categoria. Não carregado pelo modelo reconstruído. */
internal val CategoryBean.bannerDescription: String? get() = null

/** Original: `i5.i.a()` (f11139j) — URLs do banner rotativo da categoria. Não carregado pelo modelo reconstruído. */
internal val CategoryBean.bannerImages: List<String> get() = emptyList()

/** Original: `l.n().G()` = `J > 0` — PIP ligado. */
internal fun AppUserManager.isPipOn(): Boolean = isPipEnabled()

/** Original: `l.n().H()` = `L == 1` — PIP na posição 1 (inferido a partir de `pipPosition`). */
internal fun AppUserManager.isPipAtPosition1(): Boolean = isPipPosition1()

/** Original: `l.n().r()` = campo `N`, inicializado com 100 (atraso, em ms, para abrir o preview PIP ao mudar de canal). */
internal fun AppUserManager.pipPreviewDelayMs(): Long = 100L

/**
 * Funções de data de `com.live.evo.util.q1` (DateUtils) que o reconstruído deixou como TODO parcial em Time.kt.
 * Original: com/live/evo/util/q1.java — `c(long,int)`, `d(long,int)`, `o(int)`.
 */
internal object ChannelDateShims {
    /** Original: `q1.c(millis, dias)` — Calendar em 00:00:00 de (dia de [millis] + [days]). */
    fun calendarAtOffset(millis: Long, days: Int): java.util.Calendar {
        val c = java.util.Calendar.getInstance()   // g.a()
        c.timeInMillis = millis
        c.set(c.get(1), c.get(2), c.get(5) + days, 0, 0, 0)
        return c
    }

    /** Original: `q1.d(millis, dias)` — mesmo cálculo, devolve millis. */
    fun dayStartAtOffset(millis: Long, days: Int): Long = calendarAtOffset(millis, days).timeInMillis

    /** Original: `q1.o(diaDaSemana)` — nome curto (`R.string.sun`..`sat`); `Calendar.SUNDAY`=1. */
    fun weekdayName(dayOfWeek: Int): String {
        val names = intArrayOf(
            com.live.evo.R.string.sun, com.live.evo.R.string.mon, com.live.evo.R.string.tue, com.live.evo.R.string.wed,
            com.live.evo.R.string.the, com.live.evo.R.string.fri, com.live.evo.R.string.sat,
        )
        val i = (dayOfWeek - 1).coerceAtLeast(0)
        return com.live.evo.util.CommonUtils.string(names[i])
    }
}

/**
 * Funções de `ModelHelper` (s0) / `SkinConfig` (o0) chamadas pelo painel de canais e ainda não reconstruídas
 * nesses objetos. Mantêm o nome real (da anotação Kotlin `ModelHelper$getXxx$1`) e apontam o método ofuscado.
 */
internal object ChannelModelShims {
    /**
     * Original: `s0.v(epgId, tempo, callback)` = `ModelHelper.getChannelProgramName`: busca o programa em exibição
     * (`t.v.c.i.a.G(epgId, tempo)`) em IO e devolve na thread principal; `epgId == null` → callback(null).
     */
    fun getChannelProgramName(epgId: String?, time: Long, callback: (com.foxivid.baselib.model.meta.EPGProgramme?) -> Unit) {
        if (epgId == null) { callback(null); return }
        TODO("depende de t.v.c.i.a.G(epgId, tempo) = EpgManager (programa no ar) — corrotina s0\$b")
    }

    /**
     * Original: `s0.B(epgId, callback)` = `ModelHelper.getEpgPastDays`: pega as datas disponíveis da EPG
     * (`t.v.c.i.a.B(epgId)`, lista de strings de dia) e conta quantas vêm antes do dia de hoje
     * (`x1.f1.lb.util.n.n().g(2)`); devolve a contagem ao callback.
     */
    fun getEpgPastDays(epgId: String?, callback: (Int) -> Unit): Unit =
        TODO("depende de t.v.c.i.a.B(epgId) (lista de dias da EPG) — corrotina s0\$e")

    /** Original: `s0.J(programa, channelId)` — `SubscribeBean` do programa se ele já estiver agendado, senão null. */
    fun getSubscribeBean(program: com.live.evo.model.ProgramBean, channelId: String?): com.live.evo.model.SubscribeBean? {
        if (!ChannelSdkBridge.isSubscribed(program, channelId) || channelId == null) return null
        return com.live.evo.util.ModelHelper.toSubscribeBean(0, program, ChannelManagerLookup.channel(channelId.toInt()))
    }

    /** Original: `s0.Y(s0, SubscribeBean, null)` = `s0.X(bean, null)` = `ModelHelper.updateSubscribe` (cancela o lembrete). */
    fun updateSubscribe(bean: com.live.evo.model.SubscribeBean): Unit = TODO("corrotina s0.updateSubscribe — ver ModelHelper.subscribeProgram()")

    /** Original: `o0.p().o()` — caminho do arquivo da imagem de favorito (skin `key_load_favorite_img`), ou vazio. */
    fun favoriteImagePath(): String? = null
}

/** Original: `t.v.c.i.a.j(int)` → `media.a.j`/`ChannelManager.channel(key)` (canal do SDK por chave). */
internal object ChannelManagerLookup {
    fun channel(key: Int) = com.foxivid.baselib.media.ChannelManager.channel(key)
        ?: throw IllegalStateException("canal $key inexistente")
}

// ---------------------------------------------------------------------------------------------
// Adaptadores das categorias e da EPG: nomes originais (`osd.m.a/b`) sobre as classes já reconstruídas.
// ---------------------------------------------------------------------------------------------

/** Original: `osd.m.a(List<String>)` — substitui os nomes das categorias. */
internal fun com.live.evo.osd.ProgramClassifyAdapter.setCategories(names: List<String>?) = setIds(names)

/**
 * Original: `osd.m.b(int, boolean)` — guarda a posição selecionada e o flag `f7124f` (aqui `disabled`:
 * o item só fica "enabled" quando `!f7124f && selected == i`) e redesenha.
 */
internal fun com.live.evo.osd.ProgramClassifyAdapter.select(position: Int, focused: Boolean) {
    selectedIndex = position
    disabled = focused
    notifyDataSetChanged()
}

// ---------------------------------------------------------------------------------------------
// Anúncios de banner do menu (v4/g.java, i5/f.java, i5/d.java) — classes ainda não reconstruídas.
// ---------------------------------------------------------------------------------------------

/** Original: `i5.d` — criativo de banner: `d()` URL da imagem, `f()` largura, `c()` altura. */
internal class AdCreative(val imageUrl: String?, val width: Int, val height: Int)

/** Original: `i5.f` — "slot" de anúncio (`b()` id, `a()` criativos). */
internal class AdSlot(val id: String?, val creatives: List<AdCreative>)

/**
 * Original: `v4.g.e()` (singleton do gerenciador de banners do app): `f(id)` devolve o slot, `c()` diz se o
 * banner está habilitado (`f19659b == 1`, ou `== 2`/`== 3` conforme `InteractionUtils.k0()`).
 * Não reconstruído (fora do escopo do menu): aqui nunca há slot, então nenhum banner é exibido.
 */
internal object ChannelBannerAds {
    fun slot(id: String): AdSlot? = null
    fun isEnabled(): Boolean = false
}

/**
 * Chamadas ao `com.live.evo.osd.SubscribeManager` (osd/u.java), cujo corpo ainda não foi reconstruído em Kotlin.
 * Original: `osd.u.f7147a.s(...)` (agendar lembrete) e `osd.u.f7147a.o(...)` (diálogo de troca de lembrete).
 */
internal object ChannelSubscribeShims {
    /**
     * Original: `u.s(nomeCanal, icone, posGlobal, programa, channelId, "channel", listener, null)` — agenda/cancela o
     * lembrete do programa (`ModelHelper.W(...)`, que atualiza o banco e chama o [listener] com o `SubscribeBean`).
     */
    fun subscribe(channelName: String?, icon: String?, inAllPos: Int, program: com.live.evo.model.ProgramBean,
                  channelId: String?, listener: com.live.evo.osd.OnUpdateListener): Unit =
        TODO("osd/u.s -> s0.W(...): ainda não reconstruído (SubscribeManager)")

    /**
     * Original: `u.o(novo, antigo, listener)` — mostra o `SubscribeSwitchDialog` ("trocar lembrete") se ainda não
     * estiver visível e a activity estiver viva (`com.live.evo.util.b.b(activity)`).
     */
    fun showSwitchDialog(newProgram: com.live.evo.model.ProgramBean, oldBean: com.live.evo.model.SubscribeBean,
                         listener: com.live.evo.dialog.SubscribeSwitchDialog.Listener): Unit =
        TODO("osd/u.o: ainda não reconstruído (SubscribeManager)")
}

/**
 * Original: `y1.a(int)` (implementado em `l1.f`): leva o foco para a barra de abas do menu (`MenuTabLayout`).
 * A interface `OnTabEventListener` reconstruída ainda não declara seus métodos (`a(int)`, `b()`, `c()`).
 */
internal fun com.live.evo.fragment.OnTabEventListener.focusTabs(position: Int): Unit =
    TODO("y1.a(int) — declarar em OnTabEventListener e implementar em MenuParent (l1.f.a: tabLayout.requestFocus())")

/**
 * Estratégia de tecla numérica (zapping por número). Interface com um método `a(keyCode, event)`.
 * No original a lista `numberStrategies` do fragment nunca é preenchida.
 * Original: com/live/evo/util/x.java
 */
fun interface NumberKeyStrategy {
    fun onNumberKey(keyCode: Int, event: android.view.KeyEvent): Boolean
}

/**
 * Mais funções de `q1` (DateUtils) usadas pelas grades de EPG desenhadas em Canvas.
 * Original: com/live/evo/util/q1.java — `e`, `f`, `g`, `l`
 */
internal object EpgDateShims {
    /** Original: `q1.g(millis)` / `q1.i(millis)` — meia-noite do dia (via formato `ddMMyyyy`). */
    fun startOfDay(millis: Long): Long = com.live.evo.util.DateUtils.startOfDay(millis)

    /** Original: `q1.e(millis, dias)` — Calendar no fuso do `TimeZoneHelper`, 00:00:00 do dia + [days]. */
    fun calendarInZone(millis: Long, days: Int): java.util.Calendar {
        val c = java.util.Calendar.getInstance()
        c.timeZone = com.live.evo.util.TimeZoneHelper.get().timeZone()
        c.timeInMillis = millis
        c.set(c.get(1), c.get(2), c.get(5) + days, 0, 0, 0)
        return c
    }

    /** Original: `q1.f(millis, dias)` — soma [days] dias mantendo a hora (sem zerar). */
    fun addDays(millis: Long, days: Int): Long {
        val c = java.util.Calendar.getInstance()
        c.timeInMillis = millis
        c.set(c.get(1), c.get(2), c.get(5) + days)
        return c.timeInMillis
    }

    /** Original: `q1.l(millis)` — nome curto do dia da semana. */
    fun weekdayName(millis: Long): String {
        val c = java.util.Calendar.getInstance()
        c.time = java.util.Date(millis)
        return ChannelDateShims.weekdayName(c.get(7))
    }
}
