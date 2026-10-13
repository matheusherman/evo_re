package com.live.evo.fragment.channel

import android.text.TextUtils
import android.view.View
import android.widget.EditText
import com.live.evo.AppUserManager
import com.live.evo.ProductFeatureManager
import com.live.evo.UiFunctionConfig
import com.live.evo.event.ChannelUpdateEvent
import com.live.evo.model.ChannelData
import com.live.evo.osd.EpgListAdapter
import com.live.evo.osd.ProgramClassifyAdapter
import com.live.evo.util.AppPropertiesStore
import com.live.evo.util.PlaybackPrefs
import org.greenrobot.eventbus.EventBus
import org.slf4j.LoggerFactory
import java.util.Locale

/**
 * Categorias (coluna 1) e lista de canais (coluna 2) do painel "Channel List".
 *
 * Responsabilidades:
 * - montar a lista de categorias visíveis ([rebuildVisibleCategories], [filterPrivateGroups]);
 * - carregar os canais da categoria selecionada ([loadCategory]), incluindo as categorias especiais
 *   "favoritos" (posição 1) e "histórico" (posição 2), e esconder canais adultos quando o grupo está bloqueado;
 * - manter contadores ("3/120"), posição salva por categoria ("posição,offsetY") e foco;
 * - alternar entre painel de canais e painel de senha adulta ([onCategoryChanged]).
 *
 * Original: com/live/evo/fragment/x.java — `E2/k2/G2`, `K1`, `J2`, `H2`, `K2`, `R2`, `L1`, `W1`, `Q1`, `I2`, `e3`,
 * `S2`, `b3`, `B2`, `D2`, `T2`, `C2`, `P2`, `c0` (dados)
 */
class ChannelCategoryController(private val ctx: ChannelMenuContext) {
    private val logger = LoggerFactory.getLogger(ChannelCategoryController::class.java)
    private val views get() = ctx.views
    private val state get() = ctx.state

    // ------------------------------------------------------------------ categorias visíveis

    /** Limpa e recria a lista visível. Original: `k2()` */
    fun rebuildVisibleCategories() {
        ChannelMenuData.visibleCategories.clear()
        if (ChannelMenuData.allCategories.isNotEmpty()) filterPrivateGroups()
    }

    /**
     * Copia todas as categorias; se `UiFunctionConfig.h()` está ligado, remove as que a propriedade remota
     * `private_group` marca com valor "1" (grupo privado oculto). Original: `E2()`
     */
    fun filterPrivateGroups() {
        val visible = ChannelMenuData.visibleCategories
        visible.clear()
        if (!UiFunctionConfig.get().h()) {
            visible.addAll(ChannelMenuData.allCategories)
            return
        }
        visible.addAll(ChannelMenuData.allCategories)
        for ((key, value) in AppPropertiesStore.group("private_group")) {
            if (ChannelMenuData.allCategories.contains(key) && value == "1") visible.remove(key)
        }
    }

    /** Garante que há categorias visíveis (recria se vazio). Original: `G2()` */
    fun ensureVisibleCategories() {
        rebuildVisibleCategories()
        if (ChannelMenuData.visibleCategories.size <= 0) {
            ChannelMenuData.visibleCategories.addAll(ChannelSdkBridge.columns(true))
        }
    }

    /** Há grupo privado oculto que cobre a lista (usado por [loadCategory]). */
    private fun hasHiddenPrivateGroup(): Boolean {
        for ((key, value) in AppPropertiesStore.group("private_group")) {
            if (ChannelMenuData.allCategories.contains(key) && value == "1") return true
        }
        return false
    }

    /** A categoria selecionada é a de "history" (e o recurso de histórico está ligado)? Original: `Q1()` */
    fun isHistoryCategory(): Boolean {
        val names = ChannelMenuData.visibleCategories
        val name = (if (state.categorySelect < names.size) names[state.categorySelect] else names[0]).lowercase(Locale.getDefault())
        return UiFunctionConfig.get().f() && name.equals("history", ignoreCase = true)
    }

    /**
     * O canal selecionado é adulto (`ChannelData.p()`) — ou não existe? Retorna **true** quando não há categorias,
     * dados ou item selecionado (tratado como "bloqueado"). Original: `M1()`
     */
    fun isSelectedChannelLockedOrMissing(): Boolean {
        val names = ChannelMenuData.visibleCategories
        val map = ChannelMenuData.channelsByCategory
        if (names.isNotEmpty() && !map.isNullOrEmpty()) {
            val list = map[names[state.categorySelect]]
            if (list != null && list.size > state.programSelect) {
                val channel = list[state.programSelect]
                return channel != null && channel.isAdult
            }
        }
        return true
    }

    /** O recurso EPG (coluna 3) está habilitado? Original: `U2()` (`ProductFeatureManager.d()` nos dois ramos). */
    fun isEpgEnabled(): Boolean = ProductFeatureManager.get().epgEnabled()

    // ------------------------------------------------------------------ carregamento de canais

    /**
     * Carrega a lista de canais da categoria na posição [position] e atualiza adapters/contadores/título.
     *
     * - posição 1 = favoritos, posição 2 = histórico (recarregados do SDK; o histórico também posta
     *   `ChannelUpdateEvent(2)`);
     * - demais: lista de `ChannelMenuData.channelsByCategory`; canais adultos são ocultados se existe grupo privado
     *   oculto **ou** a categoria não é uma coluna adulta.
     *
     * Original: `K1(int)`
     */
    fun loadCategory(position: Int) {
        val names = ChannelMenuData.visibleCategories
        if (ctx.programAdapter == null) return
        if (names.size <= position) return
        ctx.programAdapter?.setItemUnfocused(views.programListView?.selectedView, true)
        val key = names[position]
        if (position == 1) {
            val favorites = ChannelSdkBridge.favoriteChannels()
            ChannelMenuData.channelsByCategory!![key] = favorites
            state.channelsInCategory = favorites
            setChannelList(favorites)
        } else if (position != 2) {
            var list = ChannelMenuData.channelsByCategory!![key] ?: emptyList()
            val hiddenPrivate = hasHiddenPrivateGroup()
            val info = (ChannelMenuData.categoryInfo ?: ChannelSdkBridge.categoryInfo())[key]
            val isAdultColumn = info != null && info.isAdultColumn == 1
            if (hiddenPrivate || !isAdultColumn) list = list.filter { !it.isAdult }
            state.channelsInCategory = list
            setChannelList(list)
        } else {
            val history = ChannelSdkBridge.historyChannels()
            ChannelMenuData.channelsByCategory!![key] = history
            state.channelsInCategory = history
            setChannelList(history)
            EventBus.getDefault().post(ChannelUpdateEvent(2))
        }
        ctx.categoryAdapter?.select(position, views.categoryListView?.isFocused == true)
        updateCounters()
        setCategoryTitle(key)
    }

    /** Passa a lista ao adapter de canais junto do índice tocando. Original: `e3(List)` */
    fun setChannelList(list: List<ChannelData>?) {
        ctx.programAdapter?.setItems(list, state.playAllPos)
    }

    /** Título da categoria (`i5.i.h()`). Original: `K2(String)` */
    fun setCategoryTitle(key: String) {
        try {
            views.categoryNameLabel?.text = ChannelMenuData.categoryInfo!![key]!!.name
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /** Título da categoria selecionada + atualização do adapter de categorias. Original: `H2()` */
    fun refreshCategoryAdapter() {
        val names = ChannelMenuData.visibleCategories
        if (names.size > 0) {
            try {
                views.categoryNameLabel?.text = ChannelMenuData.categoryInfo!![names[state.categorySelect]]!!.name
            } catch (_: Exception) {
            }
        }
        ctx.categoryAdapter?.setCategories(names)
    }

    /** Escreve "/total" e a posição "1"/"0" nos contadores. Original: `R2()` */
    fun updateCounters() {
        val list = state.channelsInCategory
        val size: Int
        val position: String
        if (list != null && list.isNotEmpty()) {
            size = list.size
            position = "1"
        } else {
            size = 0
            position = "0"
        }
        views.totalProgramsLabel?.text = "/$size"
        views.textPosition?.text = position
        views.textProgramTotal?.text = "/$size"
    }

    /** Índice, na lista da categoria, do canal tocando (`playAllPos == ChannelData.number`), ou -1. Original: `W1()` */
    fun indexOfPlayingChannel(): Int {
        val list = ChannelMenuData.channelsByCategory?.get(ChannelMenuData.visibleCategories[state.categorySelect]) ?: return -1
        for (i in list.indices) {
            if (state.playAllPos == list[i].number) return i
        }
        return -1
    }

    // ------------------------------------------------------------------ posição salva por categoria

    /** Lê "posição,offsetY" salvo para a categoria; cai para 0 em qualquer erro de parse (como no original). */
    fun savedScroll(categoryName: String): Pair<Int, Int> {
        val saved = state.scrollHistory?.get(categoryName)
        val parts = saved?.split(",")?.dropLastWhile { it.isEmpty() }?.toTypedArray()
        var position = 0
        var offset = 0
        try {
            position = parts!![0].toInt()
            try { offset = parts[1].toInt() } catch (_: Exception) { offset = 0 }
        } catch (_: Exception) {
            position = 0
        }
        return position to offset
    }

    /** Número do item atual para o contador "posição/total". */
    private fun showCurrentNumber(categoryName: String) {
        val saved = state.scrollHistory!![categoryName]!!
        var head = "0"
        try {
            val sub = saved.substring(0, saved.indexOf(','))
            if (!TextUtils.isEmpty(sub)) head = sub
        } catch (e: Exception) {
            e.printStackTrace()
        }
        views.textCurrentPos?.text = (head.toInt() + 1).toString()
    }

    // ------------------------------------------------------------------ mostrar/ocultar painéis

    /** Mostra a lista de canais (e esconde o painel de senha). Trecho comum de `J2()` e `b3()`. */
    private fun showChannelPanel() {
        if (views.adultKeyParent?.visibility == View.VISIBLE) views.adultKeyParent.visibility = View.GONE
        if (views.channelParent?.visibility != View.VISIBLE) views.channelParent?.visibility = View.VISIBLE
        if (views.textPipTip != null && views.textPipTip.visibility != View.VISIBLE) views.textPipTip.visibility = View.VISIBLE
    }

    /** Seta de "ir para EPG" e a lista, conforme a categoria tem canais. Trecho comum de `J2()` e `b3()`. */
    private fun updateListVisibility() {
        val list = state.channelsInCategory
        if (list != null) {
            if (list.isNotEmpty()) {
                views.ivRight?.visibility = if (ctx.adult.isSelectedCategoryAdult()) View.GONE else View.VISIBLE
                views.programListView?.visibility = View.VISIBLE
            } else {
                views.programListView?.visibility = View.GONE
                views.ivRight?.visibility = View.GONE
            }
        } else {
            views.programListView?.visibility = View.GONE
            views.ivRight?.visibility = View.GONE
        }
    }

    /**
     * Atualiza tudo depois que a lista de canais da categoria [classifyName] mudou (usado por `onChannelUpdateEvent`).
     * Original: `J2(String)`
     */
    fun showChannelsOfCategory(classifyName: String) {
        ctx.programAdapter?.setItemUnfocused(views.programListView?.selectedView, true)
        setChannelList(state.channelsInCategory)
        ctx.categoryAdapter?.select(state.categorySelect, views.categoryListView?.isFocused == true)
        updateCounters()
        setCategoryTitle(classifyName)
        val previewWasVisible = views.previewContainer?.visibility == View.VISIBLE
        updatePreviewVisibility()
        if (!previewWasVisible && views.previewContainer != null) {
            if (views.previewContainer.visibility == View.VISIBLE && !AppUserManager.get().isPipAtPosition1()) schedulePreview()
        }
        showChannelPanel()
        updateListVisibility()
        ctx.banners.updateCategoryBanner()
    }

    /**
     * Tratador (adiado 150 ms) da seleção de categoria: carrega os canais; se a categoria exige PIN mostra o painel
     * de senha, senão mostra a lista, ajusta contadores e restaura a posição salva (ou posiciona no canal tocando).
     * Original: `b3()` (mensagem 8195 do [ChannelHandler])
     */
    fun onCategoryChanged() {
        views.ivRight?.parent?.let { (it as View).visibility = View.VISIBLE }
        loadCategory(state.categorySelect)
        if (ctx.adult.needsAdultKey()) {
            views.ivRight?.visibility = View.GONE
            views.channelParent?.visibility = View.GONE
            views.adultKeyParent?.visibility = View.VISIBLE
            ctx.adult.showLockScreen()
            if (views.textPipTip?.visibility == View.VISIBLE) views.textPipTip.visibility = View.GONE
            if (UiFunctionConfig.get().l() && !AppUserManager.get().isPipAtPosition1()) views.previewContainer?.visibility = View.GONE
        } else {
            val previewWasVisible = views.previewContainer?.visibility == View.VISIBLE
            updatePreviewVisibility()
            if (!previewWasVisible && views.previewContainer != null) {
                if (views.previewContainer.visibility == View.VISIBLE && !AppUserManager.get().isPipAtPosition1()) schedulePreview()
            }
            showChannelPanel()
            updateListVisibility()
            val list = state.channelsInCategory
            if (list != null) {
                if (list.isEmpty()) {
                    views.textPosition?.text = "0"
                    views.textProgramTotal?.text = "/0"
                    views.programListView?.visibility = View.GONE
                } else {
                    if (views.programListView?.visibility != View.VISIBLE) views.programListView?.visibility = View.VISIBLE
                    views.textPosition?.text = "1"
                    views.textProgramTotal?.text = "/" + list.size
                }
            } else {
                views.textPosition?.text = "0"
                views.textProgramTotal?.text = "/0"
                views.programListView?.visibility = View.GONE
            }
            val name = ChannelMenuData.visibleCategories[state.categorySelect]
            val (position, offset) = savedScroll(name)
            val playingIdx = indexOfPlayingChannel()
            if (playingIdx < 0 || !(state.hasChangeCategory || state.isChangeChannel)) {
                views.programListView?.setSelectionFromTop(position, offset)
            } else {
                views.programListView?.setSelection(playingIdx)
                state.scrollHistory!![name] = "$playingIdx,0"
            }
            showCurrentNumber(name)
        }
        ctx.adult.bindGoButton()
    }

    /** Mostra/oculta o preview PIP conforme a categoria (adulta esconde) e o PIP do usuário. Original: `L1()` */
    fun updatePreviewVisibility() {
        val preview = views.previewContainer ?: return
        if (ctx.adult.isSelectedCategoryAdult() && !AppUserManager.get().isPipAtPosition1()) {
            preview.visibility = View.GONE
        } else if (UiFunctionConfig.get().l()) {
            preview.visibility = if (AppUserManager.get().isPipOn()) View.VISIBLE else View.GONE
        }
        if (!AppUserManager.get().isPipOn() || ChannelMenuData.presenter == null) return
        logger.debug("ChannelFragment changePipView:{}", ctx.fragment)
        ChannelMenuData.presenter!!.onTag("ChannelFragment")
    }

    /** Agenda (mensagem 1) o preview do canal selecionado no PIP. Original: `P2()` */
    fun schedulePreview() {
        if (UiFunctionConfig.get().l() && AppUserManager.get().isPipOn()) {
            ctx.handler.removeMessages(ChannelHandler.MSG_PREVIEW)
            ctx.handler.sendEmptyMessageDelayed(ChannelHandler.MSG_PREVIEW, AppUserManager.get().pipPreviewDelayMs())
        }
    }

    // ------------------------------------------------------------------ foco e visibilidade

    /** Dá o foco à lista de canais (se há canais) ou à de categorias e atualiza painéis. Original: `C2()` */
    fun onMenuShown() {
        state.postMetricFromCategory = false
        val channels = state.channelsInCategory
        if (views.programListView == null || channels == null) {
            views.categoryListView?.requestFocus()
        } else if (channels.isNotEmpty()) {
            views.programListView.requestFocus()
        } else {
            views.categoryListView?.requestFocus()
        }
        loadCategory(state.categorySelect)
        if (ctx.adult.needsAdultKey()) {
            views.ivRight?.visibility = View.GONE
            views.channelParent?.visibility = View.GONE
            views.adultKeyParent?.visibility = View.VISIBLE
            ctx.adult.showLockScreen()
            views.categoryListView?.requestFocus()
        }
        updatePreviewVisibility()
        schedulePreview()
        state.isChannelHistoryLive = false
    }

    /** Foca o primeiro item da coluna aberta (categorias ou canais). Original: `B2()` */
    fun focusFirstItem() {
        val categories = views.categoryListView
        if (categories == null || !state.isCategoryOpen) {
            val channels = state.channelsInCategory
            if (views.programListView == null || channels == null) return
            if (channels.isEmpty()) return
            views.programListView.requestFocus()
            views.programListView.setSelection(0)
            state.programSelect = 0
            ctx.rememberFocus(views.programListView)
            return
        }
        if (ChannelMenuData.visibleCategories.isEmpty()) return
        categories.requestFocus()
        categories.setSelection(0)
        state.categorySelect = 0
        ctx.rememberFocus(categories)
    }

    /** Devolve o foco à última lista usada. Original: `D2()` */
    fun restoreFocus() {
        val focus = ctx.focusView ?: return
        when {
            focus === views.categoryListView -> views.categoryListView?.requestFocus()
            focus === views.programListView -> views.programListView?.requestFocus()
            focus === views.lvEpgDate -> views.lvEpgDate?.requestFocus()
            focus === views.epgListView -> views.epgListView?.requestFocus()
            views.categoryListView == null || !state.isCategoryOpen -> views.programListView?.requestFocus()
            else -> views.categoryListView?.requestFocus()
        }
        state.isChannelHistoryLive = false
    }

    /** Reabre a coluna de categorias (e fecha a EPG) se estiver fechada. Original: `T2()` */
    fun openCategoryColumn() {
        if (state.isCategoryOpen) return
        ctx.animator.categoryAnimOpen?.start()
        state.isCategoryOpen = true
        views.epgParent?.visibility = View.GONE
        if (views.categoryParent?.visibility != View.VISIBLE) views.categoryParent?.visibility = View.VISIBLE
        if (views.categoryListView?.visibility != View.VISIBLE) views.categoryListView?.visibility = View.VISIBLE
        views.ivRightLayout?.visibility = if (ctx.adult.isSelectedCategoryAdult()) View.GONE else View.VISIBLE
    }

    /** Se está na categoria "history", recarrega a lista com o que já existe em memória. Original: `I2()` */
    fun refreshHistoryCategory() {
        if (!UiFunctionConfig.get().f() || !isHistoryCategory()) return
        val names = ChannelMenuData.visibleCategories
        if (names.size > state.categorySelect && ctx.programAdapter != null) {
            ctx.programAdapter?.setItemUnfocused(views.programListView?.selectedView, true)
            val name = names[state.categorySelect]
            val list = ChannelMenuData.channelsByCategory!![name]
            state.channelsInCategory = list
            setChannelList(list)
            updateCounters()
            setCategoryTitle(name)
            views.programListView?.requestFocus()
        }
    }

    /**
     * Prepara adapters, seleção e histórico de rolagem ao reexibir o menu (`onHiddenChanged(false)` / `h0(false)`).
     * Original: `S2()`
     */
    fun refreshOnShow() {
        UiFunctionConfig.get().h()
        if (views.categoryNameLabel == null) return
        rebuildVisibleCategories()
        val names = ChannelMenuData.visibleCategories
        val size = names.size
        if (size <= 0) return
        if (state.categorySelect >= size) state.categorySelect = 0
        val current = ChannelMenuData.channelsByCategory!![names[state.categorySelect]]
        if (current == null || state.programSelect >= current.size) state.programSelect = 0
        for (i in 0 until size) {
            val selectedPos = if (state.categorySelect == i) state.programSelect else 0
            if (TextUtils.isEmpty(state.scrollHistory!![names[i]])) state.scrollHistory!![names[i]] = "$selectedPos,0"
        }
        val list = state.channelsInCategory
        if (list != null) {
            if (list.isEmpty()) state.channelsInCategory = ChannelMenuData.channelsByCategory!![names[0]]
        } else {
            state.channelsInCategory = ChannelMenuData.channelsByCategory!![names[0]]
        }
        if (ctx.categoryAdapter == null) {
            ctx.categoryAdapter = ProgramClassifyAdapter(ctx.activity!!).also {
                it.setCategories(names)
                views.categoryListView?.adapter = it
            }
        } else {
            ctx.categoryAdapter?.setCategories(names)
        }
        views.categoryListView?.let {
            it.clearFocus()
            it.setSelection(state.categorySelect)
            ctx.categoryAdapter?.select(state.categorySelect, it.isFocused)
        }
    }

    // ------------------------------------------------------------------ inicialização (x.c0)

    /**
     * Carga inicial de dados: lê a última posição tocada ("categoria,canal,posição"), monta categorias, adapters
     * (categorias, canais, EPG, datas), posiciona a seleção e dispara banners e textos de PIP.
     * Original: `c0(Bundle)`
     */
    fun initialize() {
        val activity = ctx.activity ?: return
        if (ChannelMenuData.presenter == null) {
            // presenter ausente (fragment recriado sem o menu): `LiveNewActivity.r2(true)` = exit(withProcess = true),
            // que libera tudo e mata o processo. O restante de c0 continua depois da chamada (como no original).
            (activity as com.live.evo.activity.LiveNewActivity).exit(true)
        }
        ChannelMenuData.presenter?.start()
        state.categoryWidth = activity.resources.getDimension(com.live.evo.R.dimen.classify_width_2).toInt()
        if (state.previousPlayData == null) {
            val last = PlaybackPrefs.lastPosition()
            state.previousPlayData = last
            val parts = last.split(",").dropLastWhile { it.isEmpty() }
            state.playCategory = parts[0].toInt()
            state.playChannel = parts[1].toInt()
            state.playAllPos = parts[2].toInt()
        }
        if (state.scrollHistory == null) state.scrollHistory = HashMap()
        rebuildVisibleCategories()
        val names = ChannelMenuData.visibleCategories
        val size = names.size
        if (size <= 0) names.addAll(ChannelSdkBridge.columns(true))
        state.categorySelect = state.playCategory
        if (state.categorySelect >= names.size) state.categorySelect = 0
        if (names.size > 0) {
            val info = ChannelMenuData.categoryInfo!![names[state.categorySelect]]
            if (info != null) views.categoryNameLabel?.text = info.name
        }
        state.programSelect = state.playChannel
        val current = ChannelMenuData.channelsByCategory!![names[state.categorySelect]]
        if (current == null || state.programSelect >= current.size) state.programSelect = 0
        for (i in 0 until size) {
            val selectedPos = if (state.categorySelect == i) state.programSelect else 0
            state.scrollHistory!![names[i]] = "$selectedPos,0"
        }
        state.channelsInCategory = ChannelMenuData.channelsByCategory!![names[0]]
        if (ctx.categoryAdapter == null) {
            ctx.categoryAdapter = ProgramClassifyAdapter(activity).also { it.setCategories(names) }
        } else {
            ctx.categoryAdapter?.setCategories(names)
        }
        views.categoryListView?.adapter = ctx.categoryAdapter
        if (ctx.programAdapter == null) ctx.programAdapter = ChannelListAdapter(activity, state.channelsInCategory)
        views.programListView?.adapter = ctx.programAdapter
        ctx.programAdapter?.setItems(ChannelMenuData.channelsByCategory!![names[state.categorySelect]], state.playAllPos)
        loadCategory(state.categorySelect)
        views.categoryListView?.setSelection(state.playCategory)
        views.categoryListView?.post {
            // x.l2: reaplica a seleção do adapter relativa ao primeiro item visível
            var first = views.categoryListView.firstVisiblePosition
            if (first < 0) first = 0
            var pos = state.playCategory
            if (pos - first >= 0) pos -= first
            ctx.categoryAdapter?.select(pos, views.categoryListView.isFocused)
        }
        if (ctx.epgAdapter == null) ctx.epgAdapter = EpgListAdapter(ctx.context!!)
        views.epgListView?.adapter = ctx.epgAdapter
        if (ctx.epgDateAdapter == null) ctx.epgDateAdapter = EpgDateAdapter(ctx.context!!)
        views.lvEpgDate?.adapter = ctx.epgDateAdapter
        state.isInitEpgData = true
        views.lvEpgDate?.setSelectionFromTop(ctx.epgDateAdapter?.todayIndex() ?: 0, 0)
        state.tempEpgList = ArrayList()
        state.curChannelEpgList = ArrayList()
        ctx.animator.build()
        if (views.channelParent?.visibility == View.VISIBLE) {
            views.programListView?.requestFocus()
            ctx.rememberFocus(views.programListView)
        }
        val playingIdx = indexOfPlayingChannel()
        val list = state.channelsInCategory
        if (playingIdx > 0 && list != null && playingIdx < list.size) {
            views.programListView?.setSelection(playingIdx)
        } else {
            views.programListView?.setSelection(state.programSelect)
        }
        updateCounters()
        views.sessionId?.text = AppUserManager.get().sessionIdForDisplay()
        ctx.banners.loadChannelBanner()
        // r2(): vazio no original
        ctx.banners.updateCategoryBanner()
        loadPipTips()
        updatePreviewVisibility()
    }

    /** Textos das dicas de PIP (propriedades remotas com padrão em strings). Original: `t2()` */
    fun loadPipTips() {
        val user = AppUserManager.get()
        state.tipSwitch = user.getString("pip_menu_tipwatch", com.live.evo.util.CommonUtils.string(com.live.evo.R.string.pip_menu_tipwatch))
        state.tipOpenPip = user.getString("pip_menu_tipopen", com.live.evo.util.CommonUtils.string(com.live.evo.R.string.pip_menu_tipopen))
        state.tipClosePip = user.getString("pip_menu_tipclose", com.live.evo.util.CommonUtils.string(com.live.evo.R.string.pip_menu_tipclose))
    }

    /** Limpa a dica de PIP e inicia o rodízio de textos (6 s). Original: `W2()` */
    fun startPipTip() {
        val tip = views.textPipTip ?: return
        tip.text = ""
        if (tip.visibility != View.VISIBLE) tip.visibility = View.VISIBLE
        if (views.textCurrentPos?.visibility == View.VISIBLE) views.textCurrentPos.visibility = View.GONE
        if (views.totalProgramsLabel?.visibility == View.VISIBLE) views.totalProgramsLabel.visibility = View.GONE
        if (UiFunctionConfig.get().l()) {
            ctx.handler.removeCallbacks(ctx.pipTipRunnable)
            ctx.handler.postDelayed(ctx.pipTipRunnable, 6000L)
        }
    }

    /** Evita referência morta ao teclado (`EditText` do campo de senha). */
    @Suppress("unused") private fun passwordField(): EditText? = views.etPassword
}
