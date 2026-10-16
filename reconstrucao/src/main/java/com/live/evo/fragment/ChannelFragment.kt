package com.live.evo.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.fragment.app.FragmentManager
import com.foxivid.baselib.media.ChannelListEvent
import com.foxivid.baselib.util.EventBusUtils
import com.live.evo.AppConstants
import com.live.evo.AppUserManager
import com.live.evo.R
import com.live.evo.activity.LiveNewActivity
import com.live.evo.activity.SpeedTestActivity
import com.live.evo.dialog.ConfirmDialog
import com.live.evo.event.SavePlayHistoryEvent
import com.live.evo.fragment.channel.ChannelAdultLock
import com.live.evo.fragment.channel.ChannelBannerController
import com.live.evo.fragment.channel.ChannelCategoryController
import com.live.evo.fragment.channel.ChannelEpgPanel
import com.live.evo.fragment.channel.ChannelHandler
import com.live.evo.fragment.channel.ChannelKeyHandler
import com.live.evo.fragment.channel.ChannelListeners
import com.live.evo.fragment.channel.ChannelMenuContext
import com.live.evo.fragment.channel.ChannelMenuData
import com.live.evo.fragment.channel.ChannelMenuState
import com.live.evo.fragment.channel.ChannelPanelAnimator
import com.live.evo.fragment.channel.ChannelSdkBridge
import com.live.evo.fragment.channel.ChannelViews
import com.live.evo.fragment.channel.select
import com.live.evo.model.ProgramBean
import com.live.evo.osd.presenter.OSDListProgramPresenterContract
import com.live.evo.osd.presenter.OSDListProgramView
import com.live.evo.util.LoginConfig
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.slf4j.LoggerFactory
import java.lang.ref.SoftReference

/**
 * Painel de canais do menu da live ("Channel List"): 3 colunas — categorias (`mCategoryListView`,
 * [com.live.evo.osd.ProgramClassifyAdapter]), canais da categoria (`mProgramListView`,
 * [com.live.evo.fragment.channel.ChannelListAdapter]) e EPG do canal em foco (datas `mLvEpgDate` +
 * programas `mEpgListView`, [com.live.evo.osd.EpgListAdapter]). Layout `program_view_layout3`.
 *
 * O original é um fragment de ~5 mil linhas; aqui ele é apenas a "cola" do ciclo de vida e da interface
 * [OSDListProgramView] (chamada pelo `OSDListProgramPresenter`). A lógica foi dividida em
 * (pacote [com.live.evo.fragment.channel]):
 *
 * | Classe | Conteúdo | Métodos originais (`x`) |
 * |---|---|---|
 * | [ChannelMenuData] / [ChannelMenuState] | dados estáticos e estado de instância | campos `M2..T2` e flags |
 * | [ChannelViews] | `findViewById`, foco D-pad entre colunas, fontes | `f0`, `d2` |
 * | [ChannelCategoryController] | categorias, lista de canais, favoritos/histórico, foco | `E2 K1 J2 b3 S2 c0 ...` |
 * | [ChannelEpgPanel] | EPG (datas, programas, catch-up, lembrete) | `L2 U1 c3 L g3 Q2` |
 * | [ChannelAdultLock] | PIN adulto (4 dígitos) e teclado virtual | `N1 R1 x2 y2 q2` |
 * | [ChannelBannerController] | banners de canais/categoria | `j2 V2 Y1` |
 * | [ChannelPanelAnimator] | animações de largura das colunas | `e2 f2..i2`, `x$b..x$e` |
 * | [ChannelListeners] / [ChannelHandler] | seleção/foco/clique, mensagens e dica PIP | `x$f..x$k`, `x$i`, `x$j` |
 * | [ChannelKeyHandler] | `onKey` (teclas do controle remoto) | `onKey` |
 *
 * Comportamento resumido:
 * - ESQ/DIR com debounce de 100 ms; as colunas de categorias e EPG abrem/fecham por animação;
 * - tecla MENU sobre um canal abre o PIP (se `UiFunctionConfig.l()` e PIP ligado), senão toast `pip_not_open`;
 * - categorias especiais: posição 1 = favoritos, 2 = histórico; "private_group" (grupo privado, remoto) some da
 *   lista; categorias adultas exigem o PIN ([ChannelAdultLock]);
 * - seleção de canal → `presenter.onSelection(categoria, posição, número, "channel")`.
 *
 * Original: com/live/evo/fragment/x.java (5083 linhas; nome real ChannelFragment — log "ChannelFragment")
 */
class ChannelFragment : LazyFragment(), OSDListProgramView {
    private val logger = LoggerFactory.getLogger(ChannelFragment::class.java)

    private val state = ChannelMenuState()
    private var views: ChannelViews? = null
    private var ctx: ChannelMenuContext? = null
    private lateinit var listeners: ChannelListeners

    /** Teclado virtual da senha adulta. Original: `getKeyboardView()` */
    val keyboardView get() = ctx?.adult?.keyboardView

    /** Índice da categoria selecionada (original `mCategorySelect`). */
    var mCategorySelect: Int
        get() = state.categorySelect
        set(value) { state.categorySelect = value }

    /** Índice do canal selecionado (original `mProgramSelect`; `getMProgramSelect()` = `programSelect` da interface). */
    var mProgramSelect: Int
        get() = state.programSelect
        set(value) { state.programSelect = value }

    // ------------------------------------------------------------------ LazyFragment

    /** Original: `b0()` */
    override fun layoutId(): Int = R.layout.program_view_layout3

    /**
     * Liga as views e cria os controladores. Original: `f0(View)` (+ `d2`, `s2`).
     * Ordem: findViewById → visibilidade da coluna de categorias → foco D-pad entre colunas → fontes → seletor
     * "adulto" (se `AppUserManager.E()`) → setas de data (`epgdate_arrowup_show`) → painel de senha → PIP → OnKeyListener.
     */
    override fun bindViews(root: View) {
        val v = ChannelViews(root)
        views = v
        val c = ChannelMenuContext(this, v, state)
        ctx = c
        c.handler = ChannelHandler(c)
        c.pipTipRunnable = (c.handler as ChannelHandler).PipTipRunnable()
        c.animator = ChannelPanelAnimator(context, v, state)
        c.categories = ChannelCategoryController(c)
        c.epg = ChannelEpgPanel(c)
        c.adult = ChannelAdultLock(c)
        c.banners = ChannelBannerController(c)
        c.keys = ChannelKeyHandler(c)
        listeners = ChannelListeners(c)

        AppUserManager.get().getInt("category_ad_interval", 3000)   // valor lido e descartado no original

        v.applyCategoryColumnVisibility(AppConstants.flagA)
        if (!c.categories.isEpgEnabled()) v.ivRightLayout?.visibility = View.GONE
        v.wireNextFocus()
        v.applyFonts(LoginConfig.get().flagA())
        if (AppUserManager.get().needAdultWarning()) {
            v.categoryListView?.setSelector(R.drawable.program_adult_selector)
            v.programListView?.setSelector(R.drawable.program_adult_selector)
        }
        val arrowVisibility = if (com.live.evo.util.CommonUtils.string(R.string.epgdate_arrowup_show) == "show") View.VISIBLE else View.GONE
        v.ivUp?.visibility = arrowVisibility
        v.ivDown?.visibility = arrowVisibility

        c.adult.bind(activity)       // d2(mRoot)
        bindPreviewContainer()       // s2()
        v.categoryListView?.setOnKeyListener(c.keys)
        v.programListView?.setOnKeyListener(c.keys)
    }

    /** Registra o container de preview PIP no presenter. Original: `s2()` */
    private fun bindPreviewContainer() {
        val c = ctx ?: return
        val presenter = ChannelMenuData.presenter
        if (presenter != null && com.live.evo.UiFunctionConfig.get().l() && c.views.previewContainer != null) {
            presenter.onContainer("ChannelFragment", c.views.previewContainer!!)
        }
    }

    /** Carga inicial de dados. Original: `c0(Bundle)` */
    override fun initData(savedInstanceState: Bundle?) {
        ctx?.categories?.initialize()
    }

    /**
     * Liga os listeners das listas e o teclado virtual depois da carga inicial. Original: `d0()`
     * A coluna de EPG começa com largura 0 (e a de categorias também se `AppConstants.flagA` é falso).
     */
    override fun afterInit() {
        val c = ctx ?: return
        val v = c.views
        if (!AppConstants.flagA) {
            v.categoryParent?.layoutParams?.width = 0
            v.categoryParent?.requestLayout()
        }
        v.epgParent?.layoutParams?.width = 0
        v.programListView?.onItemClickListener = listeners.channelClicked
        v.programListView?.onItemSelectedListener = listeners.channelSelected
        v.programListView?.setOnKeyListener(c.keys)
        v.categoryListView?.setOnKeyListener(c.keys)
        v.tvNotData?.setOnKeyListener(c.keys)
        v.epgListView?.setOnKeyListener(c.keys)
        v.lvEpgDate?.setOnKeyListener(c.keys)
        v.etPassword?.setOnKeyListener(c.keys)
        v.categoryListView?.onItemSelectedListener = listeners.categorySelected
        v.categoryListView?.onFocusChangeListener = listeners.categoryFocusChange
        v.programListView?.onFocusChangeListener = listeners.channelFocusChange
        v.epgListView?.onFocusChangeListener = listeners.epgListFocusChange
        v.epgListView?.onItemSelectedListener = listeners.epgItemSelected
        v.lvEpgDate?.onFocusChangeListener = listeners.epgDateFocusChange
        v.lvEpgDate?.onItemSelectedListener = listeners.epgDateSelected
        c.adult.initKeyboard()      // q2()
    }

    /**
     * Visibilidade do fragment (chamado pelo `LazyFragment`; no original `h0(boolean hidden)`).
     * - `!hidden` (vai aparecer): esconde a EPG, mostra painel de canais e categorias, reabre a coluna de categorias,
     *   zera `epgShowFirst`, redesenha canais e esconde o IME.
     * - `hidden` e `!isChannelUpdateByKids`: recarrega categorias, lista e preview.
     * Em ambos `mIsCatchUp = false`.
     */
    override fun onVisibleChanged(hidden: Boolean) {
        val c = ctx ?: return
        val v = c.views
        logger.debug("onFragmentVisibleChange = {}", hidden)
        if (!hidden) {
            v.epgParent?.visibility = View.GONE
            if (v.channelParent != null && v.channelParent.visibility != View.VISIBLE) v.channelParent.visibility = View.VISIBLE
            if (v.categoryParent != null && v.categoryParent.visibility != View.VISIBLE) v.categoryParent.visibility = View.VISIBLE
            if (v.categoryListView != null && v.categoryListView.visibility != View.VISIBLE) v.categoryListView.visibility = View.VISIBLE
            if (!state.isCategoryOpen && c.animator.categoryAnimOpen != null) {
                c.animator.categoryAnimOpen!!.start()
                state.isCategoryOpen = true
            }
            state.epgShowFirst = false
            c.programAdapter?.notifyDataSetChanged()
            c.adult.hideSoftInput()
        } else if (!state.isChannelUpdateByKids) {
            c.categories.refreshOnShow()
            c.categories.loadCategory(state.categorySelect)
            c.categories.updatePreviewVisibility()
            c.categories.schedulePreview()
        }
        state.isCatchUp = false
    }

    // ------------------------------------------------------------------ ciclo de vida do Fragment

    override fun onAttach(context: Context) {
        super.onAttach(context)
        EventBusUtils.register(this)
    }

    /**
     * Ao esconder (`hidden`): fecha a EPG, reabre categorias, para o banner e esconde o IME.
     * Ao mostrar: refaz tudo (categorias, histórico/favoritos, seleção inicial, banner de canal, preview).
     * Original: `onHiddenChanged(boolean)`
     */
    override fun onHiddenChanged(hidden: Boolean) {
        val c = ctx
        if (c == null) { super.onHiddenChanged(hidden); return }
        val v = c.views
        logger.debug("onHiddenChanged = {}", hidden)
        if (hidden) {
            v.epgParent?.visibility = View.GONE
            if (v.categoryParent?.visibility != View.VISIBLE) v.categoryParent?.visibility = View.VISIBLE
            if (v.categoryListView?.visibility != View.VISIBLE) v.categoryListView?.visibility = View.VISIBLE
            if (!state.isCategoryOpen) {
                c.animator.categoryAnimOpen?.start()
                state.isCategoryOpen = true
            }
            if (c.banners.isChannelBannerActive()) v.banner?.stop()
            if (v.layoutBanner?.visibility == View.VISIBLE) v.layoutBanner.visibility = View.GONE
            c.adult.hideSoftInput()
        } else {
            c.categories.refreshOnShow()
            val name = ChannelMenuData.visibleCategories[state.categorySelect].lowercase(java.util.Locale.getDefault())
            if (name == "favorite" || name == "history") {
                c.categories.loadCategory(state.categorySelect)
                val list = state.channelsInCategory
                if (list != null && list.isNotEmpty()) v.programListView?.visibility = View.VISIBLE
            }
            if (state.focusable) {
                // dispara manualmente o onItemSelected da categoria atual
                val child = v.categoryListView?.getChildAt(state.categorySelect)
                if (v.categoryListView != null && child != null) {
                    v.categoryListView.onItemSelectedListener?.onItemSelected(v.categoryListView, child, state.categorySelect, child.id.toLong())
                }
            }
            if (c.banners.isChannelBannerActive() && v.banner != null) {
                if (v.layoutBanner != null && v.layoutBanner.visibility != View.VISIBLE) v.layoutBanner.visibility = View.VISIBLE
                c.banners.resetBrowseMetrics()
                v.banner.start()
            } else {
                if (v.layoutBanner?.visibility == View.VISIBLE) v.layoutBanner.visibility = View.GONE
                v.banner?.stop()
            }
            c.categories.updatePreviewVisibility()
        }
        state.epgShowFirst = false
    }

    override fun onResume() {
        super.onResume()
        EventBusUtils.register(this)
        ctx?.categories?.startPipTip()      // W2()
    }

    override fun onDestroy() {
        super.onDestroy()
        ChannelMenuData.instanceRef = null
    }

    override fun onDetach() {
        super.onDetach()
        EventBusUtils.unregister(this)
    }

    // ------------------------------------------------------------------ EventBus

    /**
     * Resultado do carregamento da lista de canais (evento sticky `nf.d`).
     *
     * Observação: o original testa `event.d()` (campo `isOK`) **ao contrário do que o nome sugere**: quando `true`
     * e ainda não há dados, mostra o diálogo "load_fail" (com `retry` = recarregar, `exit` = fechar a Live); quando
     * `false`, recarrega categorias/canais e atualiza a tela. Mantido como está (possível inversão no original).
     */
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onChannelUpdateEvent(event: ChannelListEvent?) {
        val c = ctx
        if (event == null) return
        if (event.isOK) {
            val data = ChannelMenuData.channelsByCategory
            if ((data == null || data.isEmpty()) && isAdded && context != null) {
                val message = getString(R.string.load_fail) + ":\n" + event.msg + "(" + event.code + ")"
                ConfirmDialog.show(
                    requireContext(), message, getString(R.string.retry), getString(R.string.exit),
                    { ChannelSdkBridge.reloadChannels() },                       // z2()
                    { (activity as? LiveNewActivity)?.finish() },                // A2(): fecha a Live
                )
            }
            return
        }
        ChannelMenuData.channelsByCategory = ChannelSdkBridge.channelsByCategory()
        ChannelMenuData.allCategories = ChannelSdkBridge.columns(true)
        ChannelMenuData.categoryInfo = ChannelSdkBridge.categoryInfo()
        if (ChannelMenuData.allCategories.isEmpty() || c == null) return
        c.categories.openCategoryColumn()           // T2()
        c.categories.ensureVisibleCategories()      // G2()
        if (state.categorySelect >= ChannelMenuData.visibleCategories.size) state.categorySelect = 0
        c.categories.refreshCategoryAdapter()       // H2()
        val name = ChannelMenuData.visibleCategories[state.categorySelect]
        state.channelsInCategory = ChannelMenuData.channelsByCategory!![name]
        if (state.channelsInCategory == null) return
        c.categories.showChannelsOfCategory(name)   // J2(name)
        val v = c.views
        if (v.categoryListView?.isFocused == true) { v.categoryListView.requestFocus(); return }
        val list = state.channelsInCategory
        if (v.programListView != null && list != null && list.isNotEmpty() && v.programListView.isFocused) {
            v.programListView.requestFocus()
            return
        }
        if ((v.epgListView?.isFocused == true || v.lvEpgDate?.isFocused == true)) v.categoryListView?.requestFocus()
    }

    // ------------------------------------------------------------------ OSDListProgramView

    /** Original: `E()` + `onDestroyView()` — cancela a animação do adapter, desregistra o EventBus e solta o adapter. */
    override fun onDestroyView() {
        ctx?.programAdapter?.cancelAnimation()      // E()
        super.onDestroyView()
        EventBusUtils.unregister(this)
        ctx?.programAdapter = null
    }

    /** Guarda categoria/canal/posição global tocando e avisa o adapter. Original: `F(b5.h)` */
    override fun onHistorySaved(event: SavePlayHistoryEvent) {
        state.playCategory = event.category
        state.playChannel = event.channel
        state.playAllPos = event.allPosition
        ctx?.programAdapter?.setPlayingIndex(state.playAllPos)
        logger.debug(" RxBusPlayHistory: {},{},{}", state.playCategory, state.playChannel, state.playAllPos)
    }

    /**
     * Fecha o menu: restaura a largura da coluna de categorias (`categoryWidth` se `flagA`, senão 0), esconde a
     * coluna de EPG e manda o presenter esconder o menu (na thread de UI). Original: `I()` + `X1`
     */
    override fun hideView() {
        com.live.evo.util.RxUtils.runOnUiThread {
            val v = views ?: return@runOnUiThread
            if (v.categoryListView != null) {
                val width = if (AppConstants.flagA) state.categoryWidth else 0
                v.categoryParent?.layoutParams?.width = width
                v.categoryParent?.requestLayout()
                v.categoryParent?.visibility = View.VISIBLE
                if (ctx?.categories?.isEpgEnabled() == true) {
                    v.epgParent?.layoutParams?.width = 0
                    v.epgParent?.requestLayout()
                }
            }
            ChannelMenuData.presenter?.hide()
        }
    }

    /** EPG do canal chegou do presenter. Original: `L(List<p>, String)` */
    override fun showEpgList(list: List<ProgramBean>, channelId: String) {
        ctx?.epg?.onEpgReceived(list, channelId)
    }

    /** Escreve o texto do contador "posição atual". Original: `M(String)` */
    override fun onId(id: String) {
        ctx?.views?.textCurrentPos?.text = id
    }

    /** Original: `N(FragmentManager, String)` — vazio. */
    override fun show(fragmentManager: FragmentManager, menuTag: String) {}

    /** Original: `getIsShow()` — sempre false. */
    override val isShowing: Boolean get() = false

    /**
     * Seleciona o canal **anterior** (com volta ao fim). Original: `m()` — o contrato chama de `resetFocus`
     * (nome vindo de `persenter/b.m()`); o corpo é navegação para cima na lista de canais.
     */
    override fun resetFocus() {
        val c = ctx ?: return
        val list = c.views.programListView ?: return
        c.programAdapter?.let {
            it.setItemUnfocused(list.selectedView, true)
            it.setItemUnfocused(list.getChildAt(state.programSelect), true)
        }
        val selected = list.selectedItemPosition
        if (selected == 0) list.setSelection(state.channelsInCategory!!.size - 1) else list.setSelection(selected - 1)
        c.rememberFocus(list)
    }

    override val programSelect: Int get() = state.programSelect

    /** Marca o canal tocando (índice global) no adapter. Original: `p(int)` */
    override fun setInAllProgramPos(pos: Int) {
        val c = ctx ?: return
        val list = c.views.programListView ?: return
        val adapter = c.programAdapter ?: return
        adapter.setItemUnfocused(list.selectedView, true)
        adapter.setItemUnfocused(list.getChildAt(state.programSelect), true)
        adapter.setPlayingIndex(pos)
    }

    /** Falha ao carregar a EPG. Original: `q(Throwable, String)` */
    override fun onEpgError(error: Throwable, channelId: String) {
        ctx?.epg?.onEpgError(error, channelId)
    }

    /** Seleciona o canal na posição [pos] da lista. Original: `r(int)` */
    override fun setInListSelectPos(pos: Int) {
        val c = ctx ?: return
        val list = c.views.programListView ?: return
        c.programAdapter?.let {
            it.setItemUnfocused(list.selectedView, true)
            it.setItemUnfocused(list.getChildAt(state.programSelect), true)
        }
        state.programSelect = pos
        val adapter = c.programAdapter ?: return
        if (adapter.count <= pos) return
        list.setSelection(state.programSelect)
    }

    /** Seleciona o canal **seguinte** (com volta ao início). Original: `s()` (contrato: `onS`). */
    override fun onS() {
        val c = ctx ?: return
        val list = c.views.programListView ?: return
        c.programAdapter?.let {
            it.setItemUnfocused(list.selectedView, true)
            it.setItemUnfocused(list.getChildAt(state.programSelect), true)
        }
        val selected = list.selectedItemPosition
        if (selected == state.channelsInCategory!!.size - 1) list.setSelection(0) else list.setSelection(selected + 1)
        c.rememberFocus(list)
    }

    /** Devolve o foco à última view usada. Original: `t()` (contrato: `onT`). */
    override fun onT() {
        ctx?.focusView?.requestFocus()
    }

    /** Muda a categoria selecionada (e a posição na lista de categorias). Original: `u(int)` */
    override fun setProgramPosition(position: Int) {
        val c = ctx ?: return
        val list = c.views.categoryListView ?: return
        if (state.categorySelect == position) return
        state.categorySelect = position
        list.setSelection(position)
        c.categoryAdapter?.select(position, list.isFocused)
    }

    /** Original: `K(presenter)` — vazio (o presenter é entregue por [setChannelPresenter]). */
    override fun setPresenter(presenter: OSDListProgramPresenterContract) {}

    // ------------------------------------------------------------------ API pública usada pelo menu pai

    /** Define o presenter estático. Original: `f3(presenter)` */
    fun setChannelPresenter(presenter: OSDListProgramPresenterContract) { ChannelMenuData.presenter = presenter }

    /** Foca o item certo ao abrir o menu. Original: `C2()` */
    fun onMenuShown() { ctx?.categories?.onMenuShown() }

    /** Foca o primeiro item. Original: `B2()` */
    fun focusFirstItem() { ctx?.categories?.focusFirstItem() }

    /** Devolve o foco ao último item. Original: `D2()` */
    fun restoreFocus() { ctx?.categories?.restoreFocus() }

    /** Recarrega a lista do histórico. Original: `I2()` */
    fun refreshHistory() { ctx?.categories?.refreshHistoryCategory() }

    /** Reabre a coluna de categorias. Original: `T2()` */
    fun openCategoryColumn() { ctx?.categories?.openCategoryColumn() }

    /** Abre o teste de velocidade (tecla 7 mantida). Original: `Y2()` */
    fun startSpeedTest() { context?.let { SpeedTestActivity.start(it) } }

    /** Anima a seta de "tremor" (`R.anim.arrow_shake`) em [view]. Original: `i0(View)` (LazyFragment) */
    fun shakeView(view: View?) = shake(view)

    companion object {
        /** Lista de categorias visíveis. Original: `Companion.a()` */
        val visibleCategories get() = ChannelMenuData.visibleCategories

        /** Referência fraca à instância. Original: `Companion.b()` */
        val instanceRef get() = ChannelMenuData.instanceRef

        /** Canais por categoria. Original: `Companion.c()` */
        val channelsByCategory get() = ChannelMenuData.channelsByCategory

        /**
         * Fábrica/singleton do fragment. Guarda presenter, listener e janela nos campos estáticos, recarrega os dados
         * do SDK e devolve a instância existente (SoftReference) ou cria uma nova. Original: `Companion.d(presenter, listener, window)`
         */
        fun newInstance(presenter: OSDListProgramPresenterContract, listener: OnTabEventListener, window: Window?): ChannelFragment {
            ChannelMenuData.presenter = presenter
            ChannelMenuData.eventListener = listener
            ChannelMenuData.window = window
            ChannelMenuData.channelsByCategory = ChannelSdkBridge.channelsByCategory()
            ChannelMenuData.allCategories = ChannelSdkBridge.columns(true)
            ChannelMenuData.categoryInfo = ChannelSdkBridge.categoryInfo()
            val existing = ChannelMenuData.instanceRef?.get()
            if (existing == null) {
                val fragment = ChannelFragment()
                ChannelMenuData.instanceRef = SoftReference(fragment)
                return fragment
            }
            return existing
        }
    }
}
