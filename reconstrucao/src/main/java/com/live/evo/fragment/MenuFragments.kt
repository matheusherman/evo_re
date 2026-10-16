package com.live.evo.fragment

import android.os.Bundle
import com.live.evo.R
import android.view.KeyEvent
import android.view.View
import android.widget.TextView
import android.text.TextUtils
import android.view.Window
import com.live.evo.AppUserManager
import com.foxivid.baselib.media.ChannelManager
import com.live.evo.util.CommonUtils
import com.live.evo.util.ModelHelper
import com.live.evo.util.ToastUtils
import com.live.evo.util.ContactTemplate
import com.live.evo.util.LoginConfig
import com.live.evo.util.TextStyleUtils
import androidx.fragment.app.Fragment
import com.live.evo.UiFunctionConfig
import com.live.evo.fragment.login.presenter.RechargeView
import com.live.evo.osd.presenter.OSDListProgramPresenterContract

/*
 * Fragments do menu principal da live (tecla MENU / OK). Hierarquia:
 *   ProgramMenuDialogFragment (l1)  — diálogo "program_menu" com TabLayout + ViewPager:
 *     ├─ "HOME"/"RECOMMEND" (recomendados), "FUNCTION" ([FunctionMenuFragment]), "CHANNEL" ([ChannelFragment]),
 *     │  "SUBJECT_<n>" (esportes), "PHONESCAN" ([TabFunctionPhoneScanFragment]), "Message" ([TabFunctionMessageFragment]),
 *     │  "My Account" ([TabFunctionMyAccountFragment]), "Renew" ([TabFunctionRechargeFragment]), "Setting".
 *   FunctionMenuFragment (k0) — lista lateral de funções: Favorite, History, Search, Message, Info, Pip, Lock, phone_login...
 */

/** Callback do presenter do menu chamado a cada tecla (interface `osd.persenter.a`, método f()). */
fun interface MenuUserActivityListener { fun onUserActivity() }

/**
 * Diálogo do menu principal. `menu_first` define a aba inicial: "Channel List" (padrão) → CHANNEL, "recommend" → RECOMMEND,
 * "subject" → SUBJECT_n, "My Account"/"Renew"/"Message"/outros → FUNCTION (para "Renew" só se a validade < `expire_show_ms`
 * (padrão AppConfig.f5196p); senão FUNCTION). Rótulos vêm de propriedades remotas (`menu_home`, `menu_function`,
 * `menu_channel`) e `show_tablayout_text`/`show_subject_icon`; tabs de esportes derivam de `SubjectDataHelper`.
 * Fecha automaticamente por `hideTask` (timer) e salva/restaura posição. Mantém referências (`mChannelFragment`,
 * `mTabMyAccountFragment`, `mTabNotificationFragment`...).
 *
 * Original: com/live/evo/fragment/l1.java (2778 linhas; subclasse de `fragment.b` = [BaseDialogFragment])
 */
class ProgramMenuDialogFragment : BaseDialogFragment(), android.content.DialogInterface.OnKeyListener {
    // (no original implementa também `osd.persenter.b` = OSDListProgramView, delegando ao ChannelFragment; omitido aqui)
    private var menuFirst = "Channel List"
    private val tabMenuList = ArrayList<String>()
    private var curPosition = 0

    // Referências da UI/abas usadas pelo tratamento de teclas (o restante do fragment — tabs dinâmicas, ViewPager — está resumido).
    private var viewPager: androidx.viewpager.widget.ViewPager? = null
    private var tabLayout: com.live.evo.widget.MenuTabLayout? = null
    private var fragmentList: List<androidx.fragment.app.Fragment>? = null
    private var mTabMyAccount: android.widget.TextView? = null
    private var mTabRenew: android.widget.TextView? = null
    private var mTabNotification: android.widget.RelativeLayout? = null
    private var mTabMyAccountFragment: TabFunctionMyAccountFragment? = null
    private var mTabRechargeFragment: TabFunctionRechargeFragment? = null
    private var mTabNotificationFragment: TabFunctionMessageFragment? = null
    private var myaccountPosition = -1
    private var rechargePosition = -1
    private var notificationPosition = -1
    private var mTabBtnCheck = false
    private var isShow = false

    private fun View?.isShownAndFocused() = this != null && visibility == View.VISIBLE && isFocused
    private fun View?.isTabVisible() = this != null && visibility == View.VISIBLE

    /** Foca a aba de texto [tab] e seleciona sua página no ViewPager (se o índice for válido). */
    private fun focusTabAndPage(tab: View, position: Int) {
        tab.requestFocus()
        val size = fragmentList?.size ?: 0
        if (position <= size - 1 && position >= 0) viewPager!!.currentItem = position
    }

    /** Foca o [tabLayout] na última aba. */
    private fun focusLastMenuTab() {
        tabLayout!!.requestFocus()
        tabLayout!!.setSelectTabView(tabMenuList.size - 1)
    }

    /**
     * Navegação por D-pad entre as abas "My Account" / "Renew" / "Notification" e o conteúdo. Original: onKey(DialogInterface,int,KeyEvent)
     * - só ACTION_DOWN; qualquer tecla reinicia o timer de auto-fechamento (`f1()`, 60 s) e avisa o presenter (`mPresenter.f()`).
     * - BACK: fecha primeiro teclados virtuais abertos (global, do ChannelFragment e da aba de recarga); senão fecha o menu (`N0()`).
     * - DOWN (20): da aba focada vai para o conteúdo da própria aba (`a1()` / `C1()` / `u0()`); marca `mTabBtnCheck`.
     * - LEFT (21) / RIGHT (22): move o foco entre as abas visíveis (só se `UiFunctionConfig.o()`), sincronizando o ViewPager.
     */
    override fun onKey(dialog: android.content.DialogInterface?, keyCode: Int, event: KeyEvent?): Boolean {
        if (event!!.action != KeyEvent.ACTION_DOWN) return false
        mPresenter?.onUserActivity()
        resetHideTimer()
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            com.foxivid.ui.keyboard.KeyUtils.getCurrentKeyboard()?.let { if (it.visibility == View.VISIBLE) { it.dismiss(); return true } }
            mChannelFragment?.keyboardView?.let { if (it.visibility == View.VISIBLE) { it.dismiss(); return true } }
            mTabRechargeFragment?.keyboardView?.let { if (it.visibility == View.VISIBLE) { it.dismiss(); return true } }
            dismissMenu()
            return true
        }
        when (keyCode) {
            KeyEvent.KEYCODE_DPAD_DOWN -> {
                if (mTabMyAccount.isShownAndFocused()) { mTabMyAccountFragment?.let { mTabBtnCheck = true; it.focusContent() }; return true }
                if (mTabRenew.isShownAndFocused()) { mTabRechargeFragment?.let { mTabBtnCheck = true; it.focusContent() }; return true }
                if (mTabNotification.isShownAndFocused()) { mTabNotificationFragment?.let { mTabBtnCheck = true; it.focusContent() }; return true }
                return false
            }
            KeyEvent.KEYCODE_DPAD_LEFT -> {
                if (mTabNotification.isShownAndFocused()) {
                    // da notificação: volta para My Account, senão Renew, senão a última aba do tabLayout
                    when {
                        mTabMyAccount.isTabVisible() -> focusTabAndPage(mTabMyAccount!!, myaccountPosition)
                        mTabRenew.isTabVisible() -> focusTabAndPage(mTabRenew!!, rechargePosition)
                        else -> focusLastMenuTab()
                    }
                    return true
                }
                if (!UiFunctionConfig.get().o()) return false
                if (mTabMyAccount.isShownAndFocused()) {
                    if (mTabRenew.isTabVisible()) {
                        focusTabAndPage(mTabRenew!!, rechargePosition)
                        mTabRechargeFragment?.let { if (!it.isVisible) childFragmentManager.beginTransaction().show(it).commitAllowingStateLoss() }
                    } else focusLastMenuTab()
                    return true
                }
                if (!mTabRenew.isShownAndFocused()) return false
                focusLastMenuTab()
                return true
            }
            KeyEvent.KEYCODE_DPAD_RIGHT -> {
                if (tabLayout!!.tabCount == tabLayout!!.selectedTabPosition + 1) {
                    mTabMyAccountFragment?.let { if (!it.isVisible) childFragmentManager.beginTransaction().show(it).commitAllowingStateLoss() }
                }
                if (!UiFunctionConfig.get().o()) return false
                if (tabLayout!!.isFocused) return false
                if (mTabRenew.isShownAndFocused()) {
                    // de Renew: avança para My Account, senão Notification
                    when {
                        mTabMyAccount.isTabVisible() -> focusTabAndPage(mTabMyAccount!!, myaccountPosition)
                        mTabNotification.isTabVisible() -> focusTabAndPage(mTabNotification!!, notificationPosition)
                    }
                    return true
                }
                if (!mTabMyAccount.isShownAndFocused()) return false
                if (mTabNotification.isTabVisible()) focusTabAndPage(mTabNotification!!, notificationPosition)
                return true
            }
        }
        return false
    }

    /** Reinicia o timer de auto-fechamento (60 s). Original: f1() */
    private fun resetHideTimer() {
        hideTask?.cancel()
        hideTask = object : java.util.TimerTask() { override fun run() { /* classe `l1$g`: fecha o menu na main thread */ activity?.runOnUiThread { dismissMenu() } } }
        if (mTimerMenu == null) mTimerMenu = java.util.Timer()
        mTimerMenu?.schedule(hideTask, 60_000L)
    }

    private var hideTask: java.util.TimerTask? = null
    private var mTimerMenu: java.util.Timer? = null
    private var mPresenter: MenuUserActivityListener? = null
    private var mChannelFragment: com.live.evo.fragment.channel.ChannelFragment? = null

    /** Fecha o menu e volta à aba CHANNEL (esconde o diálogo, cancela timers). Original: N0() */
    protected fun dismissMenu() {
        isShow = false
        tabLayout?.setTabIsSelected(true)
        dialog?.let { if (it.isShowing) it.hide() }
        hideTask?.cancel(); hideTask = null
        mTimerMenu?.cancel(); mTimerMenu = null
    }
    /** Posição da aba pelo tag ("CHANNEL","FUNCTION",...). Original: M0(String) */
    fun tabIndexOf(menuTag: String): Int = tabMenuList.indexOf(menuTag)
}

/**
 * Menu lateral de funções (`menu_fragment_function`): ListView (`FunctionMenuAdapter`) à esquerda e fragment
 * filho à direita (Favorite/History/Search/Message/Info/Pip/Lock...). Navega com `y0/z0/A0(tag)`; recebe
 * `NotificationEvent` (b5.g) para marcar mensagens novas. Strings: menu_favorite, menu_history.
 * Original: com/live/evo/fragment/k0.java (nome real FunctionMenuFragment)
 */
class FunctionMenuFragment : BaseMenuFragment(), OnMenuCallback {
    /** Item de menu (tag, fragment). Original: k0.b */
    class MenuEntry(val fragmentTag: String, val fragment: LazyMenuFragment)
    private val fragmentList = ArrayList<MenuEntry>()
    private var position = 0
    private var mMenuListView: android.widget.ListView? = null
    private var menuAdapter: FunctionMenuAdapter? = null
    private var mBaseFragment: LazyMenuFragment? = null
    private val logger = org.slf4j.LoggerFactory.getLogger(FunctionMenuFragment::class.java)

    /** Posição da entrada cujo tag é [menuFirst] (ignora caixa); 0 se não achar. Original: o0(String) */
    private fun positionOf(menuFirst: String): Int {
        if (menuFirst.isNotEmpty()) {
            for (i in fragmentList.indices) {
                if (menuFirst.equals(fragmentList[i].fragmentTag, true)) return i
            }
        }
        return 0
    }

    /** Seleciona e foca a entrada [menuFirst] na lista lateral. Original: y0(String) */
    fun focusEntry(menuFirst: String) {
        position = positionOf(menuFirst)
        val list = mMenuListView!!
        list.requestFocus()
        if (list.count > position) list.setSelection(position)
        val adapter = menuAdapter!!
        if (adapter.count > position) adapter.select(position, true)
    }

    /**
     * Mostra o fragment da entrada [menuFirst] (sem focar a lista, exceto fora de "Channel List") e avisa o fragment
     * se deve tratar como visível (`X(tag != "Search")`). Original: z0(String)
     */
    fun showEntry(menuFirst: String) {
        if (mMenuListView == null || menuAdapter == null) return
        position = positionOf(menuFirst)
        switchFragment(fragmentList[position].fragmentTag)
        menuAdapter!!.select(position, false)
        if (mMenuListView!!.count > position && !"Channel List".equals(menuFirst, true)) mMenuListView!!.setSelection(position)
        if (fragmentList.size > position) {
            try {
                val visible = fragmentList[position].fragmentTag != "Search"
                fragmentList[position].fragment.onVisibilityChanged(visible)
            } catch (_: Exception) {}
        }
    }

    /**
     * Troca o fragment filho (`R.id.child_fragemnt`) pelo do [tag]: reaproveita instância existente (escondendo a anterior);
     * senão adiciona a do [fragmentList]. Original: A0(String)
     */
    fun switchFragment(tag: String) {
        if (fragmentList.isEmpty() || tag.isEmpty() || !isAdded) return
        try {
            val existing = childFragmentManager.findFragmentByTag(tag)
            if (existing != null) {
                if (existing.isHidden) {
                    val tx = childFragmentManager.beginTransaction()
                    mBaseFragment?.let { tx.hide(it) }
                    tx.show(existing).commitAllowingStateLoss()
                    mBaseFragment = existing as LazyMenuFragment
                }
                return
            }
            for (entry in fragmentList) {
                if (tag == entry.fragmentTag) {
                    val fragment = entry.fragment
                    if (fragment != mBaseFragment) {
                        val fm = childFragmentManager
                        val tx = fm.beginTransaction()
                        if (fm.findFragmentByTag(tag) == null || !fragment.isAdded) {
                            try { tx.add(R.id.child_fragemnt, fragment, tag) } catch (_: Exception) {}
                        }
                        mBaseFragment?.let { tx.hide(it) }
                        tx.show(fragment)
                        tx.commitAllowingStateLoss()
                        mBaseFragment = fragment
                        fragment.setMenuCallback(this)
                    }
                    return
                }
            }
        } catch (e: Exception) {
            logger.error("switchFragment {} error {}", tag, e.toString())
        }
    }
}

/** Item da lista lateral de funções (`i5.l`): nome, ícone, se mostra contador e o contador. */
class FunctionMenuItem(val name: String, val iconRes: Int, val showsBadge: Boolean, val badgeCount: Int)

/**
 * Adapter da lista de funções (ícone + nome; seleção destacada). Item selecionado com foco fica "selected";
 * sem foco fica "enabled" + negrito + fundo `menu_function_bg_unfocus`. Badge de novas mensagens limitado a 99.
 * Original: com/live/evo/fragment/w0.java
 */
class FunctionMenuAdapter(private val context: android.content.Context, private val items: List<FunctionMenuItem>) : android.widget.BaseAdapter() {
    private var selectedPos = 0           // f6855b
    private var focused = true            // f6856c
    private val inflater = android.view.LayoutInflater.from(context)

    private class Holder(view: View) {
        val icon: android.widget.ImageView = view.findViewById(R.id.leftmenulistitem_iv_icons)
        val name: com.live.evo.widget.MarqueeTextView = view.findViewById(R.id.leftmenulistitem_mtv_item_name)
        val flag: android.widget.TextView = view.findViewById(R.id.leftmenu_tv_flag)
        init { icon.isEnabled = false }
    }

    override fun getCount() = items.size
    override fun getItem(position: Int): Any? = items[position]
    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: android.view.ViewGroup?): View {
        val view: View; val h: Holder
        if (convertView == null) {
            view = inflater.inflate(R.layout.function_menu_item, null)
            h = Holder(view); view.tag = h
        } else { view = convertView; h = view.tag as Holder }
        (h.name.parent as View).isSelected = focused && selectedPos == position
        (h.name.parent as View).isEnabled = !focused && selectedPos == position
        val item = items[position]
        h.name.text = item.name
        h.icon.setBackgroundResource(item.iconRes)
        h.flag.visibility = if (!item.showsBadge || item.badgeCount <= 0) View.GONE else View.VISIBLE
        if (item.showsBadge) h.flag.text = "" + (if (item.badgeCount <= 99) item.badgeCount else 99)
        if (focused || selectedPos != position) {
            h.name.typeface = android.graphics.Typeface.DEFAULT
            view.setBackgroundResource(R.color.transparent)
            return view
        }
        h.name.typeface = android.graphics.Typeface.DEFAULT_BOLD
        androidx.core.view.ViewCompat.setBackground(view, androidx.appcompat.content.res.AppCompatResources.getDrawable(context, R.drawable.menu_function_bg_unfocus))
        return view
    }

    /** Define o item selecionado e se a lista tem foco. Original: a(int, boolean) */
    fun select(position: Int, focused: Boolean) { selectedPos = position; this.focused = focused; notifyDataSetChanged() }
}

/** Adapter de página (FragmentPagerAdapter) das abas. Original: com/live/evo/fragment/c0.java */
class MenuPagerAdapter(fm: androidx.fragment.app.FragmentManager) : androidx.fragment.app.FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val fragments = ArrayList<Fragment>()
    override fun getItem(position: Int) = fragments[position]
    override fun getCount() = fragments.size
}

/**
 * Favoritos (layout `newfavorite_fragment`, ids `favf_*`): lista (`favf_lv_favor`) dos canais favoritos da coluna "all"
 * (`ModelHelper.channelsOfColumn` do 1º nome de coluna). OK alterna o favorito do canal, manda broadcast `com.bb.action.FAVORITE`
 * (extras channelFavorite/channelId/channelName) e `ChannelManager.toggleFavorite`. Selecionar item atualiza "n / total" e, com PIP ligado,
 * agenda (atraso `AppUserManager.pipDelay`) a prévia (`presenter.c("FavoriteFragment", pos)`). BAIXO no último volta ao primeiro, CIMA no
 * primeiro vai ao último, ESQUERDA devolve o foco ao menu, DIREITA balança a view, MENU (82) abre a prévia em PIP (ou avisa `pip_not_open`).
 * Respeita `pip_on_channel`. Mensagens: 262145 = recarrega lista, 262146 = pede prévia. Singleton (estático `B`).
 * Nota: `ChannelData.p()/q()` (marcadores de item especial) são tratados como falsos; o adapter `n5.c` é substituído por [ChannelNameAdapter].
 * Original: com/live/evo/fragment/a0.java (log "FavoriteFragment"; factory `t0(String tag, presenter)`)
 */
class FavoriteFragment : LazyMenuFragment(), View.OnKeyListener {
    private var list: com.live.evo.widget.ProgramListView? = null
    private var noData: android.widget.TextView? = null
    private var previewContainer: android.widget.RelativeLayout? = null
    private var tvClassify: android.widget.TextView? = null; private var tvCurrent: android.widget.TextView? = null; private var tvAll: android.widget.TextView? = null
    private var adapter: ChannelNameAdapter? = null
    private var reloadTask: java.util.TimerTask? = null
    private val timer = java.util.Timer()
    private var selected = 0
    private var focused = false
    private val handler = object : android.os.Handler(android.os.Looper.getMainLooper()) {
        override fun handleMessage(msg: android.os.Message) { when (msg.what) { 262145 -> reload(); 262146 -> requestPreview(msg.arg1) } }
    }

    override fun layoutId() = com.live.evo.R.layout.newfavorite_fragment

    override fun bindViews(root: View) {
        val R = com.live.evo.R.id
        if (AppUserManager.get().getBoolean("pip_on_channel", true)) previewContainer = root.findViewById(R.favf_preview_container)
        tvClassify = root.findViewById(R.favf_tv_favorite_clssify_name); tvCurrent = root.findViewById(R.favf_tv_favorite_program_current)
        tvAll = root.findViewById(R.favf_tv_favorite_program_all); list = root.findViewById(R.favf_lv_favor); noData = root.findViewById(R.favf_tv_no_data)
        TextStyleUtils.d(tvClassify); TextStyleUtils.a(tvCurrent); TextStyleUtils.b(tvAll); TextStyleUtils.d(noData)
    }

    override fun initData(savedInstanceState: Bundle?) { loadSource(); schedule() }

    override fun afterInit() {
        list!!.onItemClickListener = android.widget.AdapterView.OnItemClickListener { _, _, pos, _ ->
            val ch = data[pos]
            ch.isFavorite = if (ch.isFavorite == 0) 1 else 0
            adapter?.notifyDataSetChanged()
            broadcastFavorite(ch)
        }
        list!!.onItemSelectedListener = object : android.widget.AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p: android.widget.AdapterView<*>?, v: View?, pos: Int, id: Long) {
                tvCurrent!!.text = (pos + 1).toString()
                if (focused) schedulePreview(pos)
            }
            override fun onNothingSelected(p: android.widget.AdapterView<*>?) {}
        }
        list!!.onFocusChangeListener = View.OnFocusChangeListener { _, has -> if (has && focused) schedulePreview(list!!.selectedItemPosition) }
        list!!.setOnKeyListener(this)
    }

    private fun loadSource() {
        source = ModelHelper.toChannels(ChannelManager.channelsOf(ChannelManager.columns(true)[0], true), true)
    }
    private fun schedule() { reloadTask?.cancel(); reloadTask = object : java.util.TimerTask() { override fun run() { handler.sendEmptyMessage(262145) } }; timer.schedule(reloadTask, 100L) }

    /** Original: n0()/p0() — refaz a lista exibida a partir da fonte. */
    private fun reload() {
        tvClassify!!.text = CommonUtils.string(com.live.evo.R.string.all)
        data.clear(); data.addAll(source)
        if (data.isEmpty()) { list!!.visibility = View.INVISIBLE; noData!!.visibility = View.VISIBLE; tvCurrent!!.text = "0"; tvAll!!.text = "/0"; return }
        list!!.visibility = View.VISIBLE; noData!!.visibility = View.INVISIBLE
        if (adapter == null) { adapter = ChannelNameAdapter(requireContext(), data); list!!.adapter = adapter } else adapter!!.notifyDataSetChanged()
        tvCurrent!!.text = "1"; tvAll!!.text = "/" + data.size; list!!.setSelection(0)
    }

    private fun broadcastFavorite(ch: com.live.evo.model.ChannelData) {
        val intent = android.content.Intent("com.bb.action.FAVORITE")
        intent.putExtra("channelFavorite", ch.isFavorite); intent.putExtra("channelId", ch.channelId); intent.putExtra("channelName", ch.name)
        ChannelManager.toggleFavorite(Integer.parseInt(ch.channelId!!))
        context?.sendBroadcast(intent)
    }

    private fun schedulePreview(pos: Int) {
        if (!AppUserManager.get().isPipEnabled()) return
        handler.removeMessages(262146); selected = pos
        handler.sendMessageDelayed(android.os.Message().also { it.what = 262146; it.arg1 = pos }, 300L)
    }
    private fun requestPreview(pos: Int) { presenter?.onTag("FavoriteFragment"); presenter?.onTagIndex("FavoriteFragment", pos) }

    override fun onFocusChanged(hasFocus: Boolean) { focused = true; list?.requestFocus() }
    override fun onVisibilityChanged(isVisible: Boolean) {
        if (!isVisible) { focused = false; reloadTask?.cancel(); try { presenter?.onTypeIndex(3, 1) } catch (e: Exception) { e.printStackTrace() }; return }
        loadSource(); schedule()
    }

    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        val l = list ?: return true
        if (event.action != KeyEvent.ACTION_DOWN) return false
        when (keyCode) {
            20 -> if (l.count > 0 && l.selectedItemPosition == l.count - 1) { l.setSelection(0); return true }
            19 -> if (l.count > 0 && l.selectedItemPosition == 0) { l.setSelection(l.count - 1); return true }
            21 -> menuCallback?.D(this)
            22 -> { shake(view); return true }
            82 -> if (l.isFocused) {
                if (data.isEmpty()) return true
                if (!AppUserManager.get().isPipEnabled()) ToastUtils.show(requireActivity(), com.live.evo.R.string.pip_not_open, 1)
                else if (selected >= 0 && data.size > selected) presenter?.onTypeIndex(1, data[selected].channelId?.toIntOrNull() ?: 0)
                return true
            }
        }
        return false
    }

    override fun onDestroy() { super.onDestroy(); instance = null }

    companion object {
        private var instance: FavoriteFragment? = null
        private var source: List<com.live.evo.model.ChannelData> = ArrayList()   // C
        private val data = ArrayList<com.live.evo.model.ChannelData>()             // D
        private var presenter: OSDListProgramPresenterContract? = null
        /** Original: t0(String, presenter) */
        fun create(tag: String, p: OSDListProgramPresenterContract?): FavoriteFragment {
            if (instance == null) { instance = FavoriteFragment().apply { arguments = Bundle().apply { putString("tag", tag) } }; presenter = p }
            return instance!!
        }
    }
}

/** Adapter simples (nome do canal) usado no lugar do `n5.c` (não reconstruído). */
class ChannelNameAdapter(context: android.content.Context, items: List<com.live.evo.model.ChannelData>) :
    android.widget.ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, items.map { (it.number + 1).toString() + " " + (it.name ?: "") })

/**
 * Histórico (layout `history_delete_fragment`): lista de canais assistidos com opção de apagar; `z0(index)`/`A0(position)`.
 * Strings `menu_history`; respeita `pip_on_channel`.
 * Original: com/live/evo/fragment/n0.java (log "HistoryDeleteFragment")
 */
class HistoryDeleteFragment : LazyMenuFragment(), View.OnKeyListener {
    override fun layoutId() = com.live.evo.R.layout.history_delete_fragment
    override fun initData(savedInstanceState: Bundle?) {}
    override fun bindViews(root: View) {}
    private var mLvHistory: com.live.evo.widget.ProgramListView? = null    // lista de histórico
    private var mSelect = -1                                                 // posição selecionada
    private var presenter: OSDListProgramPresenterContract? = null           // campo estático `D`

    /**
     * Teclas da lista de histórico. Original: onKey(View,int,KeyEvent) (só ACTION_DOWN; sem lista devolve true)
     * - CIMA no primeiro item vai ao último e BAIXO no último volta ao primeiro (rolagem circular).
     * - ESQUERDA devolve o foco ao menu (`menuCallback.D`); DIREITA balança a seta ([shake]) e consome.
     * - MENU com PIP ligado e lista focada: adiciona o canal selecionado do histórico ao PIP (`onTypeIndex(1, número)`),
     *   exceto canal já marcado (`c()`); sem PIP ativo mostra toast `pip_not_open`.
     */
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        val list = mLvHistory ?: return true
        if (event.action == KeyEvent.ACTION_DOWN) {
            if (keyCode != KeyEvent.KEYCODE_MENU) {
                when (keyCode) {
                    KeyEvent.KEYCODE_DPAD_UP -> if (list.count > 0 && list.selectedItemPosition == 0) { list.setSelection(list.count - 1); return true }
                    KeyEvent.KEYCODE_DPAD_DOWN -> if (list.count > 0 && list.selectedItemPosition == list.count - 1) { list.setSelection(0); return true }
                    KeyEvent.KEYCODE_DPAD_LEFT -> menuCallback?.D(this)
                    KeyEvent.KEYCODE_DPAD_RIGHT -> { shake(view); return true }
                }
            } else if (UiFunctionConfig.get().pipEnabled() && list.isFocused) {
                val channels = historyChannels
                if (channels.isEmpty()) return true
                if (!AppUserManager.get().isPipEnabled()) {
                    ToastUtils.show(requireActivity(), CommonUtils.string(com.live.evo.R.string.pip_not_open), 1)
                } else if (mSelect >= 0 && channels.size > mSelect) {
                    val ch = channels[mSelect]
                    if (presenter != null && !ch.isMarked()) presenter!!.onTypeIndex(1, com.foxivid.baselib.config.InteractionUtils.channelNumberOf(ch).toInt())
                }
                return true
            }
        }
        return false
    }

    /** Lista estática `C` (ChannelStreamResponse) com o histórico atual. */
    private val historyChannels: List<com.foxivid.baselib.model.meta.ChannelStreamResponse> get() = emptyList()
}

/**
 * Busca de canais (layout `newsearch_channel_fragment`, ids `searchchannelf_*`): teclado virtual próprio ("ABCDEF..." A-Z),
 * campo `searchchannelf_et_showkey`, botões limpar/apagar e lista de resultados (`search_result`, adapter `l5/c`
 * `searchresultitem_*`: número com 3 dígitos, ícone, favorito). Filtra por nome/número. Log "SearchFragment".
 * Original: com/live/evo/fragment/g2.java (factory `p0(String, presenter, y1)`)
 */
class SearchFragment : LazyMenuFragment(), View.OnKeyListener {
    override fun layoutId() = com.live.evo.R.layout.newsearch_channel_fragment
    override fun initData(savedInstanceState: Bundle?) {}
    override fun bindViews(root: View) {}

    // Views/estado (nomes dedutivos a partir dos ids; campos `f5953k..f5968z` no original)
    private var viewForU: TextView? = null                       // f5953k: tecla alvo ao descer da coluna U
    private var viewForWX: TextView? = null                      // f5954l: idem para W/X
    private var viewForST: android.widget.ImageView? = null      // f5955m: idem para S/T
    private var keyboardRv: androidx.recyclerview.widget.RecyclerView? = null   // f5956n: teclado virtual
    private var showKeyEt: android.widget.EditText? = null       // f5957o (`searchchannelf_et_showkey`)
    private var inputTv: TextView? = null                        // f5958p: texto digitado
    private var resultLayout: android.widget.LinearLayout? = null // f5959q
    private var resultTitle: TextView? = null                    // f5960r ("search_result  N")
    private var resultRv: androidx.recyclerview.widget.RecyclerView? = null     // f5961s: resultados
    private var noResultTv: TextView? = null                     // f5964v
    private var resultAdapter: SearchResultAdapter? = null       // f5962t (l5.c)
    private var sourceChannels: List<com.live.evo.model.ChannelData> = emptyList()   // f5949g (todos os canais)
    private val results = ArrayList<com.live.evo.model.ChannelData>()                // f5951i
    private var lastKeyPos = 0                                   // f5965w
    private var selectedResult = 0                               // f5968z
    private var searchPerformed = false                          // f5967y

    /** Adapter dos resultados (`l5/c`): só `setData` e `notifyDataSetChanged` são usados aqui. */
    interface SearchResultAdapter { fun setData(list: List<com.live.evo.model.ChannelData>?); fun notifyDataSetChanged() }

    /** Texto do botão/tecla (TextView direto ou `keyitem_tv_name` dentro do item). Original: m0(View) */
    private fun keyLabel(view: View?): String {
        if (view == null) return ""
        if (view is TextView) return view.text.toString()
        return view.findViewById<TextView>(com.live.evo.R.id.keyitem_tv_name)?.text?.toString() ?: ""
    }

    /** Filtra [sourceChannels] por nome (sem espaços, maiúsculas): primeiro os que começam com o texto, depois os que contêm. Original: o0() */
    fun runSearch() {
        searchPerformed = true
        results.clear()
        val starts = ArrayList<com.live.evo.model.ChannelData>()
        val contains = ArrayList<com.live.evo.model.ChannelData>()
        val query = inputTv!!.text.toString().trim()
        if (sourceChannels.isEmpty()) {
            resultAdapter?.setData(null); noResultTv!!.visibility = View.VISIBLE; resultLayout!!.visibility = View.INVISIBLE; return
        }
        if (query.isEmpty()) {
            resultAdapter?.setData(null); noResultTv!!.visibility = View.INVISIBLE; resultLayout!!.visibility = View.INVISIBLE; return
        }
        for (ch in sourceChannels) {
            if (!ch.isAdult) {
                val name = (ch.name ?: "").replace(" ", "").uppercase()
                if (name.startsWith(query)) starts.add(ch) else if (name.contains(query)) contains.add(ch)
            }
        }
        results.addAll(starts); results.addAll(contains)
        if (results.isEmpty()) {
            resultAdapter?.setData(null); noResultTv!!.visibility = View.VISIBLE; resultLayout!!.visibility = View.INVISIBLE; return
        }
        noResultTv!!.visibility = View.INVISIBLE
        resultLayout!!.visibility = View.VISIBLE
        resultAdapter?.setData(results)
        resultAdapter?.notifyDataSetChanged()
        resultTitle!!.text = CommonUtils.string(com.live.evo.R.string.search_result) + "  " + results.size
        resultRv?.findViewHolderForAdapterPosition(0)?.itemView?.requestFocus()
        resultRv?.scrollToPosition(0)
    }

    private fun setInput(text: CharSequence) { inputTv!!.text = text; showKeyEt!!.text = android.text.SpannableStringBuilder(text) }

    /** Teclado físico: letras A-Z (29..54 -> 'A'..'Z'), dígitos (7..16 e keypad 144..153) anexados ao texto na tecla solta. Original: k0(int, KeyEvent) */
    private fun appendFromHardwareKey(keyCode: Int, event: KeyEvent) {
        if (event.action != KeyEvent.ACTION_UP) return
        val sb = StringBuffer(inputTv!!.text)
        if (keyCode in 29..54) { sb.append((keyCode + 36).toChar()); setInput(sb); runSearch() }
        else if (keyCode in 7..16) { sb.append(keyCode - 7); setInput(sb); runSearch() }
        else if (keyCode in 144..153) { sb.append(keyCode - 144); setInput(sb); runSearch() }
    }

    /**
     * Teclas do teclado virtual e da lista de resultados. Original: onKey(View, int, KeyEvent)
     * - CIMA no campo de texto é engolido.
     * - ENTER/OK solto (ACTION_UP) em limpar/apagar/Y/Z executa a ação e refaz a busca; outras teclas físicas digitam ([appendFromHardwareKey]).
     * - ACTION_DOWN: DEL apaga o último caractere; MENU (82) com PIP ligado adiciona o canal selecionado ao PIP (ou toast `pip_not_open`);
     *   CIMA/BAIXO/ESQ/DIR fazem a navegação circular entre teclado, botões e resultados (wrap-around).
     */
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        var leftReturnsToMenu = true
        if (keyCode == KeyEvent.KEYCODE_DPAD_UP && v.id == com.live.evo.R.id.searchchannelf_et_showkey) return true
        if (event.action == KeyEvent.ACTION_UP) {
            if (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
                when (v.id) {
                    com.live.evo.R.id.searchchannelf_tv_clear -> { showKeyEt!!.setText(""); inputTv!!.text = ""; runSearch() }
                    com.live.evo.R.id.searchchannelf_tv_delete -> {
                        val text = inputTv!!.text
                        if (text != null && text.isNotEmpty()) setInput(text.subSequence(0, text.length - 1))
                        runSearch()
                    }
                    com.live.evo.R.id.searchchannelf_tv_y -> { setInput(String.format("%sY", inputTv!!.text)); runSearch() }
                    com.live.evo.R.id.searchchannelf_tv_z -> { setInput(String.format("%sZ", inputTv!!.text)); runSearch() }
                }
            } else appendFromHardwareKey(keyCode, event)
        }
        if (event.action == KeyEvent.ACTION_DOWN) {
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                val str = inputTv!!.text.toString()
                if (str.isNotEmpty()) { setInput(str.subSequence(0, str.length - 1)); runSearch() }
            } else if (keyCode != KeyEvent.KEYCODE_MENU) {
                when (keyCode) {
                    KeyEvent.KEYCODE_DPAD_UP -> {
                        if (v.id == com.live.evo.R.id.keyitem_tv_name || v.id == com.live.evo.R.id.keyitem_ll_parent) {
                            if ("ABCDEF".contains(keyLabel(v))) return true      // primeira linha do teclado: não sai
                        } else if (v.id == com.live.evo.R.id.searchchannelf_rv_channel || v.id == com.live.evo.R.id.searchresultitem_ll_parent) {
                            val size = results.size
                            if (size <= 1) return true
                            if (resultRv!!.findViewHolderForAdapterPosition(0)?.itemView?.isFocused == true) {
                                resultRv!!.postDelayed({ resultRv!!.findViewHolderForAdapterPosition(size - 1)?.itemView?.requestFocus() }, 0L)   // g2$h
                                return true
                            }
                        } else if ((v.id == com.live.evo.R.id.searchchannelf_tv_delete || v.id == com.live.evo.R.id.searchchannelf_tv_y || v.id == com.live.evo.R.id.searchchannelf_tv_z) &&
                            keyboardRv!!.findViewHolderForAdapterPosition(lastKeyPos) != null) {
                            keyboardRv!!.findViewHolderForAdapterPosition(lastKeyPos)!!.itemView.requestFocus()
                            return true
                        }
                    }
                    KeyEvent.KEYCODE_DPAD_DOWN -> {
                        if (v.id == com.live.evo.R.id.searchchannelf_tv_delete || v.id == com.live.evo.R.id.searchchannelf_tv_y ||
                            v.id == com.live.evo.R.id.searchchannelf_tv_z || v.id == com.live.evo.R.id.searchchannelf_tv_clear) {
                            v.requestFocus(); v.isFocusable = true
                            return true
                        }
                        if (v.id == com.live.evo.R.id.keyitem_tv_name || v.id == com.live.evo.R.id.keyitem_ll_parent) {
                            val label = keyLabel(v)
                            if ("ST".contains(label)) { viewForST!!.requestFocus(); viewForST!!.isFocusable = true; return true }
                            if ("WX".contains(label)) { viewForWX!!.requestFocus(); viewForWX!!.isFocusable = true; return true }
                            if ("U".contains(label)) { viewForU!!.requestFocus(); viewForU!!.isFocusable = true; return true }
                        } else if (v.id == com.live.evo.R.id.searchchannelf_rv_channel || v.id == com.live.evo.R.id.searchresultitem_ll_parent) {
                            val size = results.size
                            if (size <= 1) return true
                            if (resultRv!!.findViewHolderForAdapterPosition(size - 1)?.itemView?.isFocused == true) {
                                resultRv!!.postDelayed({ resultRv!!.findViewHolderForAdapterPosition(0)?.itemView?.requestFocus() }, 0L)   // g2$g
                                return true
                            }
                        }
                    }
                    KeyEvent.KEYCODE_DPAD_LEFT -> {
                        if (v.id == com.live.evo.R.id.keyitem_tv_name || v.id == com.live.evo.R.id.keyitem_ll_parent) {
                            leftReturnsToMenu = "AGMS".contains(keyLabel(v))     // primeira coluna: devolve o foco ao menu
                        } else if (v.id != com.live.evo.R.id.searchchannelf_tv_delete) {
                            if (v.id == com.live.evo.R.id.searchchannelf_rv_channel || v.id == com.live.evo.R.id.searchresultitem_ll_parent) {
                                val holder = keyboardRv!!.findViewHolderForAdapterPosition(lastKeyPos)
                                if (holder != null) holder.itemView.requestFocus()
                                else { viewForWX!!.requestFocus(); viewForWX!!.isFocusable = true }
                                return true
                            }
                            leftReturnsToMenu = false
                        }
                        if (leftReturnsToMenu) menuCallback?.D(this)
                    }
                    KeyEvent.KEYCODE_DPAD_RIGHT -> {
                        if (v.id == com.live.evo.R.id.searchchannelf_rv_channel || v.id == com.live.evo.R.id.searchresultitem_ll_parent) {
                            shake(resultLayout)
                        } else if (v.id == com.live.evo.R.id.searchchannelf_tv_clear) {
                            if (TextUtils.isEmpty(showKeyEt!!.text)) { viewForWX!!.requestFocus(); return true }
                            resultRv!!.requestFocus()
                            return true
                        }
                    }
                    else -> if (v.id == com.live.evo.R.id.searchchannelf_tv_clear) lastKeyPos = 100
                }
            } else if ((UiFunctionConfig.get().pipEnabled() && v.id == com.live.evo.R.id.searchchannelf_rv_channel) || v.id == com.live.evo.R.id.searchresultitem_ll_parent) {
                if (results.isEmpty()) return true
                if (AppUserManager.get().isPipEnabled()) {
                    val ch = results[selectedResult]
                    if (presenter != null && !ch.isAdult) presenter!!.onTypeIndex(1, ch.number)
                } else ToastUtils.show(requireActivity(), CommonUtils.string(com.live.evo.R.string.pip_not_open), 1)
                return true
            }
        }
        return false
    }

    private var presenter: OSDListProgramPresenterContract? = null   // campo estático `E` no original
}

/**
 * Lembretes de programação (layout `newfragment_subscribe`, ids `subscribef_*`): lista de [com.live.evo.model.SubscribeBean]
 * com data (`subject_date`); remover/ir ao canal. Kotlin ("SubscribeFragment.kt").
 * Original: com/live/evo/fragment/k2.java
 */
class SubscribeFragment : LazyMenuFragment(), View.OnKeyListener {
    override fun layoutId() = com.live.evo.R.layout.newfragment_subscribe
    override fun initData(savedInstanceState: Bundle?) {}
    override fun bindViews(root: View) {}
    private var mSubscribeRecyclerView: androidx.recyclerview.widget.RecyclerView? = null
    private var mList: List<com.live.evo.model.SubscribeBean>? = null
    private var mEpgDescParent: View? = null

    /**
     * CIMA/BAIXO são sempre consumidos (a lista não sai por cima/baixo; o `requestFocus` do original só reafirma o foco do
     * item extremo). ESQUERDA (ACTION_DOWN) fecha o painel de descrição do EPG se aberto e devolve o foco ao menu; DIREITA
     * balança a seta. Retorna false nos demais casos. Original: onKey(View,int,KeyEvent)
     */
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
            val items = mList
            if (items != null && items.isNotEmpty()) {
                val itemView = mSubscribeRecyclerView!!.findViewHolderForAdapterPosition(items.size - 1)?.itemView
                if (itemView != null && itemView.isFocused) itemView.requestFocus()
            }
            return true
        }
        if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
            val items = mList
            if (items != null && items.isNotEmpty()) {
                val itemView = mSubscribeRecyclerView!!.findViewHolderForAdapterPosition(0)?.itemView
                if (itemView != null && itemView.isFocused) itemView.requestFocus()
            }
            return true
        }
        if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT && event.action == KeyEvent.ACTION_DOWN) {
            if (menuCallback != null) {
                mEpgDescParent?.let { if (it.visibility == View.VISIBLE) it.visibility = View.GONE }
                menuCallback!!.D(this)
            }
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT && event.action == KeyEvent.ACTION_DOWN) {
            shake(view)
        }
        return false
    }
}

/**
 * Configuração do PIP (layout `newpipsetting_fragment`, `lly_pipsetting`, `pip_setting_list`, `tv_choosepip_tip`): lista de 2 itens "ON"/"OFF"
 * (maiúsculas se a propriedade remota `category_is_upcase`, padrão true). Clicar liga/desliga o PIP ([AppUserManager.setPipEnabled]); ao
 * DESLIGAR avisa o presenter (`a(2, 0)` = onTypeIndex) . Teclas: BAIXO no 2º item e CIMA no 1º são consumidas (não saem da lista);
 * ESQUERDA com a lista focada devolve o foco ao menu (`menuCallback.D(this)`); DIREITA foca a lista.
 * Singleton (campo estático `k`), argumento `tag`. Persistência em AppUserManager (`pip_info`).
 * Original: com/live/evo/fragment/b2.java (factory `d0(String, presenter)`); adapter d2.java
 */
class PipSettingFragment : LazyMenuFragment(), View.OnKeyListener {
    private var container: android.widget.RelativeLayout? = null
    private var list: com.live.evo.widget.ProgramListView? = null
    private var tip: android.widget.TextView? = null
    private var upperCase = true

    override fun layoutId() = com.live.evo.R.layout.newpipsetting_fragment
    override fun initData(savedInstanceState: Bundle?) {}

    override fun bindViews(root: View) {
        container = root.findViewById(com.live.evo.R.id.lly_pipsetting)
        list = root.findViewById(com.live.evo.R.id.pip_setting_list)
        tip = root.findViewById(com.live.evo.R.id.tv_choosepip_tip)
        upperCase = AppUserManager.get().getBoolean("category_is_upcase", true)
        fillList()
    }

    /** Original: c0() — ON/OFF. */
    private fun fillList() {
        val items = ArrayList<String>()
        items.add(0, if (upperCase) CommonUtils.string(com.live.evo.R.string.on).uppercase() else CommonUtils.string(com.live.evo.R.string.on))
        items.add(1, if (upperCase) CommonUtils.string(com.live.evo.R.string.off).uppercase() else CommonUtils.string(com.live.evo.R.string.off))
        list!!.adapter = PipSettingsAdapter(requireContext(), items)
    }

    override fun afterInit() {
        list!!.onItemClickListener = android.widget.AdapterView.OnItemClickListener { _, _, position, _ ->
            val l = list ?: return@OnItemClickListener
            if (l.count < position) return@OnItemClickListener
            val adapter = l.adapter ?: return@OnItemClickListener
            val on = TextUtils.equals((adapter.getItem(position) as String).lowercase(), CommonUtils.string(com.live.evo.R.string.on).lowercase())
            if (AppUserManager.get().isPipEnabled() == on) return@OnItemClickListener
            AppUserManager.get().setPipEnabled(on)
            (adapter as PipSettingsAdapter).notifyDataSetChanged()
            if (presenter == null || on) return@OnItemClickListener
            presenter!!.onTypeIndex(2, if (on) 1 else 0)
        }
        list!!.setOnKeyListener(this)
    }

    override fun onFocusChanged(hasFocus: Boolean) { list?.requestFocus() }
    override fun onVisibilityChanged(isVisible: Boolean) { if (isVisible) (list?.adapter as? PipSettingsAdapter)?.notifyDataSetChanged() }

    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        val l = list
        if (keyCode == 20 && event.action == KeyEvent.ACTION_DOWN) return l != null && l.isFocused && l.selectedItemPosition == 1
        if (keyCode == 19 && event.action == KeyEvent.ACTION_DOWN) return l != null && l.isFocused && l.selectedItemPosition == 0
        if (keyCode == 21 && event.action == KeyEvent.ACTION_DOWN) {
            if (l == null || !l.isFocused || menuCallback == null) return false
            menuCallback!!.D(this); return true
        }
        if (keyCode == 22 && event.action == KeyEvent.ACTION_DOWN && l != null) { l.requestFocus(); return false }
        return false
    }

    override fun onDestroy() { super.onDestroy(); instance = null }

    companion object {
        private var instance: PipSettingFragment? = null
        private var presenter: OSDListProgramPresenterContract? = null
        /** Original: d0(String tag, presenter) */
        fun create(tag: String, p: OSDListProgramPresenterContract?): PipSettingFragment {
            if (instance == null) { instance = PipSettingFragment().apply { arguments = Bundle().apply { putString("tag", tag) } }; presenter = p }
            return instance!!
        }
    }
}
/**
 * Adapter do PIP: linhas `pipsettings_list_item` com nome (`pip_item_name`) e um ícone (`pip_item_image`) de "selecionado" visível só
 * no item que corresponde ao estado atual do PIP (ON se ligado, OFF se desligado).
 * Original: com/live/evo/fragment/d2.java
 */
class PipSettingsAdapter(private val context: android.content.Context, items: List<String>) : android.widget.BaseAdapter() {
    private val names = ArrayList<String>().also { it.addAll(items) }
    private val inflater = android.view.LayoutInflater.from(context)
    private class Holder(val image: android.widget.ImageView, val name: android.widget.TextView)
    override fun getCount() = names.size
    override fun getItem(position: Int): Any? = names.getOrNull(position)
    override fun getItemId(position: Int) = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: android.view.ViewGroup?): View {
        val v: View; val h: Holder
        if (convertView == null) {
            v = inflater.inflate(com.live.evo.R.layout.pipsettings_list_item, null)
            h = Holder(v.findViewById(com.live.evo.R.id.pip_item_image), v.findViewById(com.live.evo.R.id.pip_item_name)); v.tag = h
        } else { v = convertView; h = convertView.tag as Holder }
        h.name.text = names[position]
        val on = AppUserManager.get().isPipEnabled()
        val onLabel = CommonUtils.string(com.live.evo.R.string.on).lowercase(); val offLabel = CommonUtils.string(com.live.evo.R.string.off).lowercase()
        val selected = (on && TextUtils.equals(names[position].lowercase(), onLabel)) || (!on && TextUtils.equals(names[position].lowercase(), offLabel))
        h.image.visibility = if (selected) View.VISIBLE else View.GONE
        return v
    }
}

/**
 * Bloqueio infantil/grupo privado (layout `fragment_lock`, ids `adultkeyl_*`/`duo_*`): pede a senha
 * ("private_group", "kids_lock_tip") e libera o grupo; usa AppUserManager.setAdultAuth.
 * Original: com/live/evo/fragment/u0.java (factory `p0(String, presenter, Window)`)
 */
class LockFragment : LazyMenuFragment(), View.OnKeyListener {
    override fun layoutId() = com.live.evo.R.layout.fragment_lock
    override fun initData(savedInstanceState: Bundle?) {}
    override fun bindViews(root: View) {}
    private var keyboardView: com.foxivid.ui.keyboard.KeyboardContainer? = null  // f6839x (ziyi.kit.keyboard.b)
    private var groupListLayout: android.widget.RelativeLayout? = null          // f6832q
    private var groupList: com.live.evo.widget.ProgramListView? = null          // f6822g
    private var pwdEdit: android.widget.EditText? = null                        // f6835t (RemoveKeyCodeEnterEditText)

    /**
     * Teclas da tela de senha/grupos privados. Original: onKey(View,int,KeyEvent)
     * - OK/ENTER (DOWN) sobre `adultkeyl_et_pwd` com o teclado virtual oculto: mostra o teclado (`m0()`); OK/ENTER solto no campo é consumido.
     * - CIMA/BAIXO (DOWN) com a lista de grupos visível: rolagem circular.
     * - ESQUERDA (DOWN): devolve o foco ao menu, a menos que o cursor do campo não esteja no início.
     * - DIREITA (DOWN): consome se o campo está sem foco, vazio ou com o cursor no fim (deixa mover o cursor caso contrário).
     */
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        val kb = keyboardView
        val confirm = keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER
        if (kb != null && event.action == KeyEvent.ACTION_DOWN && confirm) {
            if (v.id == com.live.evo.R.id.adultkeyl_et_pwd && kb.visibility != View.VISIBLE) { kb.show(); return true }
        } else if (kb != null && event.action == KeyEvent.ACTION_UP && confirm) {
            if (v.id == com.live.evo.R.id.adultkeyl_et_pwd) return true
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN && event.action == KeyEvent.ACTION_DOWN) {
            val list = groupList!!
            if (groupListLayout!!.visibility == View.VISIBLE && list.count > 0 && list.selectedItemPosition == list.count - 1) { list.setSelection(0); return true }
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_UP && event.action == KeyEvent.ACTION_DOWN) {
            val list = groupList!!
            if (groupListLayout!!.visibility == View.VISIBLE && list.count > 0 && list.selectedItemPosition == 0) { list.setSelection(list.count - 1); return true }
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT && event.action == KeyEvent.ACTION_DOWN) {
            val et = pwdEdit!!
            if (!(et.hasFocus() && et.selectionStart > 0)) menuCallback?.D(this)
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT && event.action == KeyEvent.ACTION_DOWN) {
            val et = pwdEdit!!
            return !et.hasFocus() || TextUtils.isEmpty(et.text) || et.selectionStart >= et.text.length
        }
        return false
    }
}

/**
 * Info/Contato (layout `newfragment_contact`): versão do app (`R.string.version` + `k.t()`), MAC/ID do dispositivo,
 * botão "check update" (checa/baixa/instala via UpgradeManager: estados "checking", "new_version", "downloading N", "install",
 * "up_to_date", "check_failed"), botão feedback (broadcast `com.bb.action.feedback` → abre [FeedbackDialogFragment]),
 * banner `AD_INFO_BANNER_KEY` (AdBannerView) e QR do atendimento (`customer_service_qrcode`). Kotlin ("InfoFragment.kt").
 * Original: com/live/evo/fragment/r0.java
 */
class InfoFragment : LazyMenuFragment(), View.OnKeyListener {
    override fun layoutId() = com.live.evo.R.layout.newfragment_contact
    override fun initData(savedInstanceState: Bundle?) {}
    override fun bindViews(root: View) {}
    private var mBtnUpdate: com.live.evo.widget.BaseButton? = null
    private var mBtnFeedback: com.live.evo.widget.BaseButton? = null
    private var mProxyType: com.live.evo.widget.BaseButton? = null
    private var mLayoutBanner: android.widget.LinearLayout? = null
    private var mBanner: com.youth.banner.Banner<String, *>? = null
    private var ad_banner: com.live.evo.widget.AdBannerView? = null
    private val newAdImages = ArrayList<String>()

    /** Banner de anúncio disponível? (`r0()` do original && `v4.g.e().d()`). Original: q0() */
    private fun isBannerAvailable(): Boolean = adBannerEnabled() && com.live.evo.ad.BootAdManager.get().isReady()
    private fun adBannerEnabled(): Boolean = true   // r0(): corpo não relevante para o foco (flag de layout)

    /**
     * Foco entre os botões Update / Feedback / Proxy e o banner. Original: onKey(View,int,KeyEvent) (sem botões => true)
     * - BAIXO: de Update vai para Feedback (se `UiFunctionConfig.e()`), senão para Proxy (se visível); sempre consome.
     * - CIMA: de Feedback vai para Update; de Proxy vai para Feedback (se `e()`) ou Update; sempre consome.
     * - ESQUERDA (DOWN): devolve o foco ao menu; consome.
     * - DIREITA (DOWN): sem banner: dos botões/Feedback balança a seta; com banner: foca o banner a partir dos botões, balança se já está nele;
     *   com imagens de anúncio mas banner invisível retorna false.
     */
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        val update = mBtnUpdate
        val feedback = mBtnFeedback
        if (update == null || feedback == null) return true
        if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
            if (update.isFocused) {
                if (UiFunctionConfig.get().e()) { feedback.requestFocus(); feedback.isFocusable = true }
                else if (mProxyType != null && mProxyType!!.visibility == View.VISIBLE) { mProxyType!!.requestFocus(); mProxyType!!.isFocusable = true }
            }
            return true
        }
        if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
            if (feedback.isFocused) { update.requestFocus(); update.isFocusable = true }
            else if (mProxyType != null && mProxyType!!.isFocused) {
                if (UiFunctionConfig.get().e()) { feedback.requestFocus(); feedback.isFocusable = true }
                else { update.requestFocus(); update.isFocusable = true }
            }
            return true
        }
        if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT && event.action == KeyEvent.ACTION_DOWN) {
            menuCallback?.D(this)
            return true
        }
        if (keyCode != KeyEvent.KEYCODE_DPAD_RIGHT || event.action != KeyEvent.ACTION_DOWN) return false
        val onButtons = update.isFocused || feedback.isFocused
        if (!isBannerAvailable() && onButtons) { shake(view); return true }
        if (isBannerAvailable() && (mLayoutBanner!!.isFocused || mBanner!!.isFocused)) { shake(view); return true }
        if (isBannerAvailable() && onButtons) { mBanner!!.requestFocus(); return true }
        if (newAdImages.size > 0 && ad_banner != null) {
            if (ad_banner!!.visibility != View.VISIBLE) return false
            shake(view)
            return true
        }
        return false
    }
}

/** Mensagens do servidor (layout `newmessage_fragment`; log "Message"). Original: com/live/evo/fragment/m1.java */
class MessageFragment : LazyMenuFragment(), View.OnKeyListener {
    override fun layoutId() = com.live.evo.R.layout.newmessage_fragment
    override fun initData(savedInstanceState: Bundle?) {}
    override fun bindViews(root: View) {}
    private var mList: List<com.live.evo.model.ServerMessage>? = null   // f6466s (i5.v)

    /**
     * CIMA/BAIXO só são consumidos quando a lista está vazia/nula; ESQUERDA devolve o foco ao menu (retorna false);
     * DIREITA não faz nada. Original: onKey(View,int,KeyEvent)
     */
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN && event.action == KeyEvent.ACTION_DOWN) return mList == null || mList!!.isEmpty()
        if (keyCode == KeyEvent.KEYCODE_DPAD_UP && event.action == KeyEvent.ACTION_DOWN) return mList == null || mList!!.isEmpty()
        if (keyCode != KeyEvent.KEYCODE_DPAD_LEFT || event.action != KeyEvent.ACTION_DOWN) return false
        menuCallback?.D(this)
        return false
    }
}

/** Aba de mensagens (layout `tab_message_fragment`; log "TabFunctionMessageFragment"): lista + detalhe. Original: com/live/evo/fragment/p2.java */
class TabFunctionMessageFragment : LazyMenuFragment(), View.OnKeyListener {
    override fun layoutId() = com.live.evo.R.layout.tab_message_fragment
    override fun initData(savedInstanceState: Bundle?) {}
    override fun bindViews(root: View) {}
    private var mList: List<com.live.evo.model.ServerMessage>? = null
    private var mLvMessage: com.live.evo.widget.ProgramListView? = null
    private var mBtnWatch: com.live.evo.widget.BaseButton? = null
    private var mFocus = false

    /** Foca a lista de mensagens (vinda da barra de abas ao apertar BAIXO). Original: u0() */
    fun focusContent() {
        val list = mLvMessage
        if (mList!!.isEmpty() || list == null) return
        if (list.isFocused) return
        mFocus = true
        list.requestFocus()
        list.setSelection(0)
    }

    /**
     * Teclas da aba de mensagens. Original: onKey(View,int,KeyEvent)
     * - BAIXO: consumido quando não há mensagens (com mensagens deixa o foco descer).
     * - CIMA: com mensagens e botão "watch" focado volta para a lista; no 1º item da lista foca a view estática `F` (aba) e consome.
     * - ESQUERDA (DOWN): se o botão watch está visível e focado volta à lista; senão devolve o foco ao menu.
     * - DIREITA (DOWN): da lista vai para o botão watch (se visível); sempre consome.
     */
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        val down = event.action == KeyEvent.ACTION_DOWN
        if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN && down) return mList == null || mList!!.isEmpty()
        if (keyCode == KeyEvent.KEYCODE_DPAD_UP && down) {
            val items = mList
            if (items != null && items.isNotEmpty()) {
                val watch = mBtnWatch
                if (watch != null && watch.visibility == View.VISIBLE && watch.isFocused) { mLvMessage!!.requestFocus(); return false }
                if (mLvMessage!!.selectedItemPosition != 0 || tabAnchor == null) return false
                tabAnchor!!.requestFocus()
            }
            return true
        }
        if (keyCode != KeyEvent.KEYCODE_DPAD_LEFT || !down) {
            if (keyCode != KeyEvent.KEYCODE_DPAD_RIGHT || !down) return false
            if (mLvMessage!!.isFocused) {
                mBtnWatch?.let { if (it.visibility == View.VISIBLE) it.requestFocus() }
            } else {
                mBtnWatch?.let { if (it.visibility == View.VISIBLE && it.isFocused) it.requestFocus() }
            }
            return true
        }
        val watch = mBtnWatch
        if (watch != null && watch.visibility == View.VISIBLE && watch.isFocused) {
            val items = mList
            if (items != null && items.isNotEmpty()) mLvMessage!!.requestFocus()
            else if (!mLvMessage!!.isFocused) tabAnchor?.requestFocus()
        }
        return true
    }

    private var tabAnchor: View? = null   // campo estático `F`
}

/**
 * Aba "Minha conta" (layout `tabfunction_fragment_myaccount`, ids `myaccountf_*`): mostra tipo de conta
 * (`user_renewcode`/`user_email`/`user_phone`/`user_device`/`user_free`), validade (`expired`), botão logout (`log_out`),
 * recarregar (`recharge_now`), vincular e-mail (`bind_email`, `phone_account_add_email`, `phone_account_profile_show_email`),
 * "compartilhar código" (`share_code_show`/`share_code_remind`), BFF (`bff_show*`), banner e dica `myaccount_bottom_tip`.
 * Logout chama o SDK e dispara ForceLogout/ReopenFragment. Implementa [RechargeView].
 * Original: com/live/evo/fragment/r2.java (factory `Y0(String, View, presenter, y1)`)
 */
class TabFunctionMyAccountFragment : LazyFragment(), View.OnKeyListener, RechargeView {
    override fun layoutId() = com.live.evo.R.layout.tabfunction_fragment_myaccount
    override fun initData(savedInstanceState: Bundle?) {}
    override fun bindViews(root: View) {}
    private var btnPrimary: android.widget.Button? = null            // f6599s (primeiro botão da aba, p.ex. logout/recarregar)
    private var btnSecondary: android.widget.Button? = null          // f6600t
    private var tvAccount: TextView? = null                          // D
    private var bannerLayout: android.widget.LinearLayout? = null    // f6605y (contêiner do banner "youth")
    private var banner: com.youth.banner.Banner<*, *>? = null        // f6606z
    private var adBanner: com.live.evo.widget.AdBannerView? = null   // E1
    private val adImages = ArrayList<String>()                       // F1
    private var adIndex = 0                                          // H1
    private var adFocused = false                                    // I1
    private var showBanner = false                                   // B
    private var tabAnchor: View? = null                              // campo estático V1 (aba "My Account" da barra)

    /** Banner "youth" disponível e habilitado? Original: M0() */
    private fun isBannerEnabled(): Boolean = com.live.evo.ad.BootAdManager.get().isEnabledFlagC() && showBanner
    /** Banner disponível e pronto? Original: L0() */
    private fun isBannerReady(): Boolean = isBannerEnabled() && com.live.evo.ad.BootAdManager.get().isReady()

    /** Foca o primeiro controle visível da aba (vindo da barra de abas ao apertar BAIXO). Original: a1() */
    fun focusContent() {
        val b1 = btnPrimary
        if (b1 != null && b1.visibility == View.VISIBLE) { b1.requestFocus(); return }
        val b2 = btnSecondary
        if (b2 != null && b2.visibility == View.VISIBLE) { b2.requestFocus(); return }
        tvAccount?.requestFocus()
    }

    /**
     * Teclas (só ACTION_DOWN; sem botão primário retorna true). Original: onKey(View,int,KeyEvent)
     * - ESQUERDA no botão: mostra o banner (se habilitado); consome.
     * - DIREITA no botão: vai ao banner "youth" se pronto, senão ao [adBanner] (parando o auto-loop), senão balança a seta.
     * - DIREITA no banner/youth: balança a seta; no [adBanner] avança o item (throttle 200 ms) ou balança se for o último.
     */
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        if (event.action != KeyEvent.ACTION_DOWN) return false
        val button = btnPrimary ?: return true
        if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
            if (button.isFocused) {
                if (bannerLayout != null && isBannerEnabled()) bannerLayout!!.visibility = View.VISIBLE
                return true
            }
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            if (button.isFocused) {
                if (bannerLayout != null && bannerLayout!!.visibility == View.VISIBLE) {
                    if (isBannerReady()) banner!!.requestFocus() else shake(view)
                } else if (adImages.size > 0 && adBanner != null && adBanner!!.visibility == View.VISIBLE) {
                    adBanner!!.requestFocus()
                    adFocused = true
                    adBanner!!.isAutoLoop(false)
                    adBanner!!.stop()
                } else shake(view)
                return true
            }
            if (bannerLayout != null && isBannerReady() && (bannerLayout!!.isFocused || banner!!.isFocused) && bannerLayout!!.visibility == View.VISIBLE) {
                shake(view); return true
            }
            if (adImages.size > 0 && adBanner != null && adBanner!!.visibility == View.VISIBLE && adBanner!!.isFocused) {
                if (CommonUtils.isFastClick(200L)) return true
                if (adImages.size <= 1 || adIndex == adImages.size - 1) shake(view)
                else adBanner!!.currentItem = (adBanner!!.currentItem + 1) % adBanner!!.itemCount
                return true
            }
        }
        return false
    }
    override fun showCreateError(msg: String, sub: String) {}
    override fun hideLoading() {}
    override fun showLoading() {}
    override fun onLoginSuccess() {}
    override fun showError(msg: String, sub: String) {}
    override fun onCreateAccountSuccess() {}
    override fun setPresenter(presenter: Any?) {}
}

/** Aba "PHONESCAN": mostra QR/dica para escanear com o celular (`qrcodeView`, `tipsView`). Original: com/live/evo/fragment/s2.java */
class TabFunctionPhoneScanFragment : LazyFragment() {
    override fun layoutId() = com.live.evo.R.layout.tabfunction_phonescan_fragment
    override fun initData(savedInstanceState: Bundle?) {}
    override fun bindViews(root: View) {}
}

/**
 * Login por telefone na TV (layout `newphone_login_fragment`, `phoneloginf_*`): textos remotos `phone_login_option_one/two`,
 * `phone_login_attention` (com fallback em strings locais), QR de login (`phoneloginf_iv_qrcode`), URL de download, código de login
 * (só visível no modo 0 = MAC) e botão "refresh" (`phoneloginf_ll_refresh`, que limpa o QR para o placeholder e pede de novo).
 * Ao ficar visível agenda um [Timer] (100 ms) que posta `what = 262145` ao Handler → [requestLoginCode]; ao esconder cancela.
 * Pedido só se `lastRequestTime + interval < agora` (intervalo = propriedade `request_phone_code_interval`, padrão 0) e sem outro em andamento.
 * ESQUERDA devolve o foco ao menu (`menuCallback.D(this)`). Singleton por `SoftReference`.
 * Original: com/live/evo/fragment/c2.java (Kotlin "PhoneLoginFragment.kt"; companion `a(tag)`)
 */
class PhoneLoginFragment : LazyMenuFragment(), View.OnClickListener, View.OnKeyListener {
    private var remind1: android.widget.TextView? = null
    private var remind2: android.widget.TextView? = null
    private var qrCode: android.widget.ImageView? = null
    private var attention: android.widget.TextView? = null
    private var lastRequestTime = 0L
    private var downloadUrl: android.widget.TextView? = null
    private var refresh: View? = null
    private var tvRefresh: android.widget.TextView? = null
    private var interval = 0L
    private var onRequest = false
    private var loginCode: android.widget.TextView? = null
    private var timer: java.util.Timer? = null
    private var lastQrCode = ""
    private val handler = object : android.os.Handler(android.os.Looper.getMainLooper()) {
        override fun handleMessage(msg: android.os.Message) { if (msg.what == 262145) requestLoginCode() }
    }

    override fun layoutId() = com.live.evo.R.layout.newphone_login_fragment

    override fun bindViews(root: View) {
        val R = com.live.evo.R.id
        remind1 = root.findViewById(R.phoneloginf_tv_remind); remind2 = root.findViewById(R.phoneloginf_tv_web_remind)
        attention = root.findViewById(R.phoneloginf_tv_attention); qrCode = root.findViewById(R.phoneloginf_iv_qrcode)
        downloadUrl = root.findViewById(R.phoneloginf_tv_download_url); refresh = root.findViewById(R.phoneloginf_ll_refresh)
        tvRefresh = root.findViewById(R.phoneloginf_tv_refresh); loginCode = root.findViewById(R.phoneloginf_tv_code)
        loginCode?.visibility = if (AppUserManager.get().welcomeMode() == 0) View.VISIBLE else View.GONE
        if (LoginConfig.get().flagA()) {
            TextStyleUtils.b(remind1); TextStyleUtils.b(remind2); TextStyleUtils.b(attention)
            TextStyleUtils.c(tvRefresh); TextStyleUtils.b(downloadUrl); TextStyleUtils.b(loginCode)
        }
    }

    override fun initData(savedInstanceState: Bundle?) {
        interval = AppUserManager.get().getLong("request_phone_code_interval", java.util.concurrent.TimeUnit.MINUTES.toMillis(0L))
        remind1!!.text = android.text.Html.fromHtml(ContactTemplate.a("phone_login_option_one", CommonUtils.string(com.live.evo.R.string.phone_login_remind1)))
        remind2!!.text = android.text.Html.fromHtml(ContactTemplate.a("phone_login_option_two", CommonUtils.string(com.live.evo.R.string.tv_phone_login_remind_2)))
        attention!!.text = android.text.Html.fromHtml(ContactTemplate.a("phone_login_attention", CommonUtils.string(com.live.evo.R.string.phone_login_attention)))
        requestLoginCode()
    }

    override fun afterInit() {
        refresh!!.nextFocusDownId = com.live.evo.R.id.phoneloginf_ll_refresh
        refresh!!.nextFocusUpId = com.live.evo.R.id.phoneloginf_ll_refresh
        refresh!!.setOnClickListener(this); refresh!!.setOnKeyListener(this)
    }

    /** Agenda um pedido em 100 ms (cancelando o anterior). Original: e0() */
    private fun scheduleRequest() {
        timer?.cancel()
        timer = java.util.Timer().also { t -> t.schedule(object : java.util.TimerTask() { override fun run() { handler.sendEmptyMessage(262145) } }, 100L) }
    }

    /** Pede o código/QR se o intervalo mínimo passou. Original: f0() */
    fun requestLoginCode() {
        if (lastRequestTime + interval >= com.live.evo.util.ServerClock.get().now() || onRequest) return
        onRequest = true
        AppUserManager.get().requestLoginCode(null)
    }

    override fun onFocusChanged(hasFocus: Boolean) { refresh?.requestFocus() }
    override fun onVisibilityChanged(isVisible: Boolean) { if (isVisible) scheduleRequest() else timer?.cancel() }

    override fun onClick(v: View) {
        if (v.id == com.live.evo.R.id.phoneloginf_ll_refresh) {
            lastQrCode = ""
            com.bumptech.glide.Glide.with(requireContext()).load(com.live.evo.R.drawable.qr_placehodler).into(qrCode!!)
            requestLoginCode()
        }
    }

    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode != 21 || event.action != KeyEvent.ACTION_DOWN || menuCallback == null) return false
        menuCallback!!.D(this); return false
    }
    override fun onDestroy() { super.onDestroy(); instance = null }
    override fun onStop() { super.onStop(); timer?.cancel() }

    companion object {
        private var instance: java.lang.ref.SoftReference<PhoneLoginFragment>? = null
        /** Original: Companion.a(String tag) */
        @Synchronized fun create(tag: String): PhoneLoginFragment =
            instance?.get() ?: PhoneLoginFragment().also { it.arguments = Bundle().apply { putString("tag", tag) }; instance = java.lang.ref.SoftReference(it) }
    }
}

/**
 * Diálogo de feedback (layout `feedback_layout`, ViewPager com 3 abas: "feedback_userfeedback_title_1" (envio),
 * "feedback_faq_title_1" ([QuestionFragment]) e "feedback_contactus_title_1" ([ContactFragment]); evento `onFeedback(i5.s)`).
 * Original: com/live/evo/fragment/b0.java (nome real FeedbackDialogFragment; adapter de itens d0.java layout `feedback_item`)
 */
class FeedbackDialogFragment : androidx.appcompat.app.AppCompatDialogFragment() {
    fun setTitles(a: String?, b: String?) {}   // W/X(String)
}
/** Envio do feedback do usuário (`feedback_fragment`, ids `feedbackf_*`; `rc_update_time`). Original: com/live/evo/fragment/m3.java */
class FeedbackFragment : BaseMenuFragment()
/** FAQ (`question_fragment`; título `feedback_faq_title`; adapter [com.live.evo.osd.QuestionAdapter]). Original: com/live/evo/fragment/f2.java */
class QuestionFragment : BaseMenuFragment()
/** Contato (`contact_fragment`; whatsapp/website/facebook/twitter/phone via ContactTemplate). Original: com/live/evo/fragment/z.java */
class ContactFragment : BaseMenuFragment()
/** Item do adapter de feedback (`feedback_item`, ids `feedbackitem_*`). Original: com/live/evo/fragment/d0.java */
class FeedbackItemAdapter(private val context: android.content.Context) : android.widget.BaseAdapter() {
    private val items = ArrayList<com.live.evo.model.QuestionBean>()   // i5.t: `a()` = texto da pergunta

    private class Holder(view: View) {
        val question: TextView = view.findViewById(com.live.evo.R.id.feedbackitem_tv_question)
        val number: TextView = view.findViewById(com.live.evo.R.id.feedbackitem_tv_numbers)
    }

    /** Substitui os itens (se não nulo) e notifica. Original: a(List) */
    fun setItems(list: List<com.live.evo.model.QuestionBean>?) {
        if (list != null) { items.clear(); items.addAll(list) }
        notifyDataSetChanged()
    }

    override fun getCount() = items.size
    override fun getItem(position: Int): Any? = null
    override fun getItemId(position: Int) = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: android.view.ViewGroup?): View {
        val view: View; val h: Holder
        if (convertView == null) {
            view = android.view.LayoutInflater.from(context).inflate(com.live.evo.R.layout.feedback_item, parent, false)
            h = Holder(view); view.tag = h
        } else { view = convertView; h = view.tag as Holder }
        h.number.text = (position + 1).toString()
        h.question.text = items[position].question
        TextStyleUtils.c(h.number)
        TextStyleUtils.c(h.question)
        return view
    }
}
