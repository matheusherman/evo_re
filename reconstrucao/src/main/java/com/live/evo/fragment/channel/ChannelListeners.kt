package com.live.evo.fragment.channel

import android.view.View
import android.widget.AdapterView
import com.live.evo.R
import com.live.evo.util.CommonUtils
import com.live.evo.util.LoginConfig
import com.live.evo.util.ToastUtils
import org.slf4j.LoggerFactory

/**
 * Listeners de seleção, foco e clique das quatro listas (categorias, canais, programas da EPG, datas da EPG).
 *
 * Original: com/live/evo/fragment/x.java — `x$f` (categoria), `x$g` (programa EPG), `x$h` (data EPG), `x$k` (canal),
 * `mProgramItemClickListener` (`v2`), e os `OnFocusChangeListener` `m2`..`p2`.
 */
class ChannelListeners(private val ctx: ChannelMenuContext) {
    private val logger = LoggerFactory.getLogger(ChannelListeners::class.java)
    private val views get() = ctx.views
    private val state get() = ctx.state

    /**
     * Seleção na lista de categorias (`x$f`): ignora a 1ª chamada (inicialização). Ao navegar por uma categoria
     * garante que a coluna de categorias está aberta (e a EPG fechada), guarda a posição e agenda o carregamento
     * dos canais (150 ms) e o banner.
     */
    val categorySelected = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            if (state.isFirst) {
                state.isFirst = false
                return
            }
            if (view == null) return
            if (views.categoryParent == null || views.categoryParent!!.visibility != View.VISIBLE) {
                views.categoryParent?.visibility = View.VISIBLE
                if (!state.isCategoryOpen) {
                    ctx.animator.categoryAnimOpen!!.start()
                    state.isCategoryOpen = true
                }
                state.isInitOpen = false
                ctx.animator.epgAnimClose!!.start()
            }
            state.categorySelect = position
            ctx.handler.removeMessages(ChannelHandler.MSG_CATEGORY)                         // X2()
            ctx.handler.sendEmptyMessageDelayed(ChannelHandler.MSG_CATEGORY, 150L)
            ctx.banners.updateCategoryBanner()
        }
        override fun onNothingSelected(parent: AdapterView<*>?) {}
    }

    /** Seleção na lista de programas da EPG (`x$g`): atualiza adapter e detalhe (horário, nome, descrição). */
    val epgItemSelected = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val list = state.tempEpgList
            if (position < list.size) {
                if (views.epgListView?.isFocused == true) ctx.epgAdapter?.setSelected(position)
                ctx.epg.showProgramDetail(list[position])
            }
        }
        override fun onNothingSelected(parent: AdapterView<*>?) {}
    }

    /**
     * Seleção na lista de datas da EPG (`x$h`): recarrega a lista de programas do dia escolhido e decide qual item
     * selecionar. Se a EPG não está pronta mostra `catchup_init_remind`. `isKeyCodeUp` (veio de CIMA do primeiro
     * programa) seleciona o último programa do novo dia; `isKeyCodeDown` seleciona o primeiro; se é o dia de hoje
     * seleciona o programa no ar.
     */
    val epgDateSelected = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            if (state.isInitEpgData) {
                state.isInitEpgData = false
                return
            }
            if (com.live.evo.fragment.channel.ChannelSdkBridge.isEpgNotReady()) {
                views.tvNotData?.visibility = View.VISIBLE
                views.tvNotData?.text = CommonUtils.string(R.string.catchup_init_remind)
                return
            }
            views.tvNotData?.text = CommonUtils.string(R.string.not_data)
            if (view == null) return
            ctx.epgDateAdapter?.select(position, views.lvEpgDate?.isFocused == true)
            var index = ctx.epg.loadDay(position)
            if (state.isKeyCodeUp) {
                index = state.tempEpgList.size - 1
                if (index < 0) {
                    views.lvEpgDate?.requestFocus()
                    ctx.epgAdapter?.notifyDataSetChanged()
                } else {
                    views.epgListView?.setSelection(index)
                }
                state.isKeyCodeUp = false
            } else {
                if (state.tempEpgList.isEmpty()) {
                    if ((ctx.epgAdapter?.count ?: 0) <= 0) {
                        views.lvEpgDate?.requestFocus()
                        ctx.epgAdapter?.notifyDataSetChanged()
                    }
                }
                if ((ctx.epgAdapter?.count ?: 0) <= 0) {
                    index = 0
                } else if (position - (ctx.epgDateAdapter?.todayIndex() ?: 0) != 0 || state.isKeyCodeDown) {
                    views.epgListView?.setSelection(0)
                    state.isKeyCodeDown = false
                    index = 0
                } else {
                    if (index < 0) index = 0
                    views.epgListView?.setSelection(index)
                }
            }
            val size = state.tempEpgList.size
            if (size <= 0 || index >= size || index < 0) {
                ctx.epg.clearProgramDetail()
                return
            }
            ctx.epg.showProgramDetail(state.tempEpgList[index])
        }
        override fun onNothingSelected(parent: AdapterView<*>?) {}
    }

    /**
     * Seleção na lista de canais (`x$k`): guarda "posição,offsetY" da categoria, atualiza contadores e
     * (com a coluna de categorias fechada) agenda a EPG e o preview; pede ao ModelHelper o número de dias passados
     * (para ajustar o tamanho da lista de datas: `max(dias, 7) + 7`).
     */
    val channelSelected = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            if (view == null) return
            val list = state.channelsInCategory!!
            if (position >= list.size) return
            val offsetY = view.y.toInt()
            state.scrollHistory!![ChannelMenuData.visibleCategories[state.categorySelect]] = "$position,$offsetY"
            val oneBased = position + 1
            views.textCurrentPos?.text = oneBased.toString()
            views.textPosition?.text = oneBased.toString()
            views.textProgramTotal?.text = "/" + list.size
            logger.debug("onItemSelected: itemPosition==$position")
            state.programSelect = position
            if (!state.isCategoryOpen) ctx.epg.scheduleEpgRequest()
            val epgId = list[position].epgId
            if (!epgId.isNullOrEmpty() && !state.isCategoryOpen) {
                ChannelModelShims.getEpgPastDays(epgId) { days ->
                    val count = if (days <= 0) 7 else days
                    ctx.epgDateAdapter?.setDayCount(count + 7)
                }
            }
            if (views.programListView?.isFocused != true) return
            if ((ctx.programAdapter?.count ?: 0) > position) ctx.categories.schedulePreview()
        }
        override fun onNothingSelected(parent: AdapterView<*>?) {}
    }

    /**
     * Clique/OK num canal (`mProgramItemClickListener` = `v2`): se já está tocando, toast `is_playing`; senão
     * troca de canal via `presenter.onSelection(...)`, atualiza o índice tocando e fecha o menu.
     */
    val channelClicked = AdapterView.OnItemClickListener { _, _, position, _ ->
        try {
            val channel = state.channelsInCategory!![position]
            val number = channel.number
            val presenter = ChannelMenuData.presenter!!
            if (presenter.currentValue() == number) {
                ToastUtils.show(ctx.activity!!, R.string.is_playing, 0)
                return@OnItemClickListener
            }
            state.programSelect = position
            state.playCategory = state.categorySelect
            presenter.onSelection(state.categorySelect, state.programSelect, number, "channel")
            ctx.fragment.setInAllProgramPos(number)
            state.isChangeChannel = true
            if (ctx.categories.isHistoryCategory()) state.isChannelHistoryLive = true
            presenter.hide()
        } catch (e: Exception) {
            logger.error("Change channel err", e)
        }
    }

    // ------------------------------------------------------------------ foco

    /** Foco na lista de categorias (`m2`). */
    val categoryFocusChange = View.OnFocusChangeListener { _, hasFocus ->
        if (hasFocus) ctx.programAdapter?.setItemUnfocused(views.programListView?.selectedView, hasFocus)
        ctx.categoryAdapter?.select(views.categoryListView?.selectedItemPosition ?: 0, hasFocus)
        ctx.banners.updateCategoryBanner()
    }

    /** Foco na lista de canais (`n2`): ao ganhar foco agenda o preview. */
    val channelFocusChange = View.OnFocusChangeListener { _, hasFocus ->
        val selected = views.programListView?.selectedView ?: return@OnFocusChangeListener
        if (!state.isChannelHistoryLive) ctx.programAdapter?.setItemUnfocused(selected, hasFocus)
        if (hasFocus && LoginConfig.get().flagF()) {
            state.channelsInCategory!!.size   // (leitura sem efeito no original)
        }
        if (hasFocus) ctx.categories.schedulePreview()
    }

    /** Foco na lista de programas da EPG (`o2`): ao perder foco limpa a seleção do adapter. */
    val epgListFocusChange = View.OnFocusChangeListener { _, hasFocus ->
        if (!hasFocus) ctx.epgAdapter?.setSelected(-1)
    }

    /** Foco na lista de datas (`p2`): ganhou → destaca a data selecionada; perdeu → nenhum destaque. */
    val epgDateFocusChange = View.OnFocusChangeListener { _, hasFocus ->
        val adapter = ctx.epgDateAdapter ?: return@OnFocusChangeListener
        if (hasFocus) adapter.setFocusedIndex(adapter.selectedIndex()) else adapter.setFocusedIndex(-1)
    }
}
