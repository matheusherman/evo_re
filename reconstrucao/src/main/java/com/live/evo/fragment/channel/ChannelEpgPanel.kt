package com.live.evo.fragment.channel

import android.view.View
import androidx.lifecycle.lifecycleScope
import com.live.evo.R
import com.live.evo.UiFunctionConfig
import com.live.evo.dialog.SubscribeSwitchDialog
import com.live.evo.model.ProgramBean
import com.live.evo.osd.OnUpdateListener
import com.live.evo.util.CommonUtils
import com.live.evo.util.DateUtils
import com.live.evo.util.RxUtils
import com.live.evo.util.ToastUtils
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit

/**
 * Coluna 3 do painel de canais: a EPG do canal em foco — lista de datas (`programviewl_lv_epg_date`), lista de
 * programas do dia (`programviewl_lv_epg_listview`) e o detalhe (horário, nome, descrição).
 *
 * Fluxo: ao parar sobre um canal, [scheduleEpgRequest] (debounce 100 ms) → [requestEpg] pede ao presenter
 * `onTagIndex`/`q(...)` a EPG; o presenter devolve [onEpgReceived] (`showEpgList` da view OSD) com a lista completa
 * (vários dias). [loadDay] filtra o dia selecionado em `tempEpgList` e acha o programa que está no ar
 * (`nowPlayingIndex`). Confirmar um programa passado toca em catch-up; futuro agenda um lembrete.
 *
 * Original: com/live/evo/fragment/x.java — `L2`, `U1`, `c3`, `d3`, `T1`, `L`, `q`, `g3`, `Q2`, listeners `x$g`/`x$h`
 */
class ChannelEpgPanel(private val ctx: ChannelMenuContext) {
    private val logger = LoggerFactory.getLogger(ChannelEpgPanel::class.java)
    private val views get() = ctx.views
    private val state get() = ctx.state

    /** Reagendado pelo callback `v` do SubscribeManager: redesenha a lista de programas (x.Z2/a3 → UI thread). */
    val subscribeUpdateListener = object : OnUpdateListener {
        override fun onUpdate() {
            RxUtils.runOnUiThread { ctx.epgAdapter?.notifyDataSetChanged() }
        }
    }

    // ------------------------------------------------------------------ dia selecionado

    /**
     * Monta `tempEpgList` com os programas do dia da posição [position] da lista de datas e devolve o índice do
     * programa no ar (ou 0 se há programas mas nenhum "agora"; -1 se vazio).
     *
     * Regras: no dia de hoje entram também programas que começaram antes da meia-noite mas ainda não terminaram
     * (`start + 1 <= diaInicio < end`); nos outros, os que começam dentro do dia. Atualiza mês, mensagem "sem dados"
     * e o adapter.
     * Original: `L2(int)` (synchronized)
     */
    @Synchronized
    fun loadDay(position: Int): Int {
        state.tempEpgList.clear()
        val todayIndex = ctx.epgDateAdapter?.todayIndex() ?: 0
        val calendar = ChannelDateShims.calendarAtOffset(DateUtils.today(), position - todayIndex)
        val dayStart = calendar.timeInMillis
        views.tvMonth?.text = ctx.context?.resources?.getTextArray(R.array.month)?.get(calendar.get(java.util.Calendar.MONTH))
        val dayEnd = ChannelDateShims.dayStartAtOffset(dayStart, 1)
        val now = DateUtils.now()
        var nowIndex = -1
        var minStart = Long.MAX_VALUE   // LocationRequestCompat.PASSIVE_INTERVAL
        var maxEnd = 0L
        for (program in state.curChannelEpgList) {
            val start = program.f()
            val end = program.g()
            if (start < minStart) minStart = start
            if (end > maxEnd) maxEnd = end
            if (position == todayIndex && start + 1 <= dayStart && dayStart < end) {
                state.tempEpgList.add(program)
            } else if (start >= dayStart && start < dayEnd) {
                state.tempEpgList.add(program)
            }
            if (state.tempEpgList.isNotEmpty() && nowIndex < 0 && start <= now && now <= end) {
                nowIndex = state.tempEpgList.size - 1
            }
        }
        if (state.tempEpgList.isNotEmpty() && nowIndex < 0) nowIndex = 0
        if (state.tempEpgList.size > 0) {
            views.tvNotData?.visibility = View.GONE
        } else {
            views.epgDuration?.text = ""
            views.epgProgram?.text = ""
            views.epgDescription?.text = CommonUtils.string(R.string.epg_description)
            views.tvNotData?.visibility = View.VISIBLE
        }
        ctx.epgAdapter?.setData(state.tempEpgList, state.curChannelId)
        return nowIndex
    }

    /**
     * Quantos programas existem no dia da posição [position] (e hoje em diante) — usado para saber se dá para
     * avançar para o dia seguinte com BAIXO. Original: `U1(int)`
     */
    fun countProgramsOfDay(position: Int): Int {
        val list = state.curChannelEpgList
        var count = 0
        val todayIndex = ctx.epgDateAdapter?.todayIndex() ?: 0
        val dayStart = DateUtils.today() + TimeUnit.DAYS.toMillis((position - todayIndex).toLong())
        val dayEnd = TimeUnit.DAYS.toMillis(1L) + dayStart
        val now = DateUtils.now()
        val limitEnd = TimeUnit.DAYS.toMillis(1L) + now
        val limitStart = now + TimeUnit.DAYS.toMillis(0 - todayIndex.toLong())
        for (program in list) {
            val start = program.f()
            if (start >= dayStart && start < dayEnd && start >= limitStart && start < limitEnd) count++
        }
        return count
    }

    // ------------------------------------------------------------------ pedir EPG

    /** Debounce de 100 ms para pedir a EPG (mensagem 8194). Original: `T1()` */
    fun scheduleEpgRequest() {
        ctx.handler.removeMessages(ChannelHandler.MSG_EPG)
        ctx.handler.sendEmptyMessageDelayed(ChannelHandler.MSG_EPG, 100L)
    }

    /**
     * Pede ao presenter a EPG do canal selecionado. Antes disso mostra "catchup_init_remind" se a EPG ainda não
     * carregou. O número de dias passados (`ModelHelper.B`) ajusta o tamanho da lista de datas.
     * Original: `c3()`
     */
    fun requestEpg() {
        val names = ChannelMenuData.visibleCategories
        if (names.size <= state.categorySelect) return
        if (ChannelSdkBridge.isEpgNotReady()) {
            views.tvNotData?.visibility = View.VISIBLE
            views.tvNotData?.text = CommonUtils.string(R.string.catchup_init_remind)
            return
        }
        views.tvNotData?.visibility = View.GONE
        val channels = ChannelMenuData.channelsByCategory!![names[state.categorySelect]]
        if (channels != null && channels.size > state.programSelect) {
            val channel = channels[state.programSelect]
            views.epgChannel?.text = channel.name
            ChannelModelShims.getEpgPastDays(channel.epgId) { pastDays -> onPastDaysLoaded(channel.epgId, pastDays, channel.channelId) }
            state.epgShowFirst = true
        }
    }

    /**
     * Callback do `getEpgPastDays`: pede a EPG ao presenter (`presenter.q(epgId, diasPassados, channelId)`,
     * = `OSDListProgramPresenter.getEpgList`), que responde em [onEpgReceived] ou [onEpgError].
     * Original: `d3(ChannelData, int)`
     */
    private fun onPastDaysLoaded(epgId: String?, pastDays: Int, channelId: String?) {
        val presenter = ChannelMenuData.presenter as? com.live.evo.osd.presenter.OSDListProgramPresenter ?: return
        presenter.getEpgList(epgId ?: return, pastDays, channelId ?: "", ctx.fragment.lifecycleScope)
    }

    // ------------------------------------------------------------------ resposta do presenter

    /**
     * EPG do canal chegou (view OSD `showEpgList`): guarda, monta o dia de hoje, seleciona o programa no ar e
     * decide o foco. Se o dia está vazio e o usuário ainda não "entrou" na EPG, foca a lista de datas.
     * Original: `L(List<p>, String)`
     */
    fun onEpgReceived(epg: List<ProgramBean>, channelId: String) {
        state.curChannelId = channelId
        logger.debug("fetchEpgData query epgBean = {}", epg.size)
        state.curChannelEpgList.clear()
        state.curChannelEpgList.addAll(epg)
        state.nowPlayingIndex = loadDay(ctx.epgDateAdapter?.todayIndex() ?: 0)
        ctx.epgDateAdapter?.let { it.select(it.todayIndex(), views.lvEpgDate?.isFocused == true) }
        if (state.tempEpgList.size <= 0) {
            if (!state.epgShowFirst) {
                views.lvEpgDate?.requestFocus()
                views.lvEpgDate?.setSelection(ctx.epgDateAdapter?.todayIndex() ?: 0)
            }
            ctx.epgAdapter?.notifyDataSetChanged()
            return
        }
        val index = if (state.nowPlayingIndex >= 0) state.nowPlayingIndex else 0
        views.epgListView?.setSelection(index)
        if (state.epgShowFirst) return
        views.epgListView?.requestFocus()
        ctx.epgAdapter?.setSelected(index)
    }

    /** Falha ao buscar a EPG: mostra "not_data" e foca o texto. Original: `q(Throwable, String)` */
    fun onEpgError(error: Throwable, channelId: String) {
        logger.error("get tdoac epg data for channel failed:$channelId", error)
        views.tvNotData?.setText(R.string.not_data)
        views.tvNotData?.requestFocus()
    }

    // ------------------------------------------------------------------ detalhe do programa

    /** "HH:mm - HH:mm", nome e descrição do programa nos TextViews. Trecho comum dos listeners `x$g`/`x$h`. */
    fun showProgramDetail(program: ProgramBean) {
        val pattern = CommonUtils.string(R.string.HHmm)
        val start = DateUtils.format(program.f(), pattern)
        val end = DateUtils.format(program.g(), pattern)
        views.epgDuration?.text = String.format("%s - %s", start, end)
        views.epgProgram?.text = String.format("%s", program.e())
        views.epgDescription?.text = CommonUtils.string(R.string.epg_description) + String.format("\t%s", program.description)
    }

    /** Limpa o detalhe (sem programa). */
    fun clearProgramDetail() {
        views.epgDuration?.text = ""
        views.epgProgram?.text = ""
        views.epgDescription?.text = ""
    }

    // ------------------------------------------------------------------ confirmar um programa

    /**
     * ENTER/OK na lista de programas. Passado → catch-up (se suportado); futuro → lembrete.
     * Retorna sem fazer nada se clicou há menos de 500 ms. Original: trecho duplicado em `onKey` (case 23 / 66),
     * a única diferença é que no case 23 exige também `!M1()` (canal não-adulto) para agendar.
     *
     * @param requireNonAdult true no DPAD_CENTER (23): só agenda se o canal selecionado não for adulto
     */
    fun onProgramConfirmed(requireNonAdult: Boolean) {
        if (CommonUtils.isFastClick(500L)) return
        var selected = views.epgListView?.selectedItemPosition ?: 0
        if (selected < 0) selected = 0
        if (selected >= state.tempEpgList.size) return
        val now = DateUtils.now()
        val program = state.tempEpgList[selected]
        val start = program.f()
        if (start > now) {
            // programa futuro: lembrete (UiFunctionConfig.n() = recurso de agendamento ligado)
            if (UiFunctionConfig.get().subscribeEnabled() && (!requireNonAdult || !ctx.categories.isSelectedChannelLockedOrMissing())) {
                val status = if (!ChannelSdkBridge.isSubscribed(program, state.curChannelId)) 1 else 0
                handleSubscribe(program, status)
            }
        } else if (ChannelSdkBridge.isCatchUpAvailable(program.b(), state.curChannelId, start)) {
            if (program.g() < now) ToastUtils.show(ctx.context!!, CommonUtils.string(R.string.not_supported_playback))
        } else {
            ChannelMenuData.presenter?.onCatchUp("channel", program, state.curChannelId)
            state.isCatchUp = true
        }
    }

    /**
     * Agenda (status 1) ou cancela (status 0) o lembrete; se já existe outro lembrete no mesmo horário, pergunta
     * se quer trocar (`SubscribeSwitchDialog`). Original: `g3(ProgramBean, int)`
     */
    private fun handleSubscribe(program: ProgramBean, status: Int) {
        if (status <= 0) {
            subscribe(program)
            return
        }
        val old = ChannelModelShims.getSubscribeBean(program, state.curChannelId)
        if (old != null) {
            ChannelSubscribeShims.showSwitchDialog(program, old, object : SubscribeSwitchDialog.Listener {
                override fun b() {   // confirmar: cancela o antigo e agenda o novo
                    ChannelModelShims.updateSubscribe(old)
                    subscribe(program)
                }
                override fun a() {}
            })
        } else {
            subscribe(program)
        }
    }

    /** Chama o SubscribeManager para o canal selecionado. Original: `Q2(ProgramBean)` */
    fun subscribe(program: ProgramBean) {
        val channel = ChannelMenuData.channelsByCategory!![ChannelMenuData.visibleCategories[state.categorySelect]]!![state.programSelect]
        ChannelSubscribeShims.subscribe(channel.name, channel.iconUrl, channel.number, program, state.curChannelId, subscribeUpdateListener)
    }
}
