package com.live.evo.fragment

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
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
    override fun onKey(dialog: android.content.DialogInterface?, keyCode: Int, event: KeyEvent?): Boolean = TODO("l1.onKey")
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
    /** Seleciona e foca a entrada [menuFirst]. Original: y0(String) */
    fun focusEntry(menuFirst: String) { TODO("k0.y0") }
    /** Mostra o fragment da entrada. Original: z0(String) / A0(tag) */
    fun showEntry(menuFirst: String) { TODO("k0.z0") }
}

/** Adapter da lista de funções (ícone + nome; seleção destacada). Original: com/live/evo/fragment/w0.java */
class FunctionMenuAdapter : android.widget.BaseAdapter() {
    override fun getCount() = 0
    override fun getItem(position: Int): Any? = null
    override fun getItemId(position: Int) = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: android.view.ViewGroup?): View = TODO("function_menu_item")
    fun select(position: Int, focused: Boolean) {}   // a(int, boolean)
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
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean = TODO("n0.onKey")
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
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean = TODO("g2.onKey")
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
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean = TODO("k2.onKey")
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
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean = TODO("u0.onKey")
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
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean = TODO("r0.onKey")
}

/** Mensagens do servidor (layout `newmessage_fragment`; log "Message"). Original: com/live/evo/fragment/m1.java */
class MessageFragment : LazyMenuFragment(), View.OnKeyListener {
    override fun layoutId() = com.live.evo.R.layout.newmessage_fragment
    override fun initData(savedInstanceState: Bundle?) {}
    override fun bindViews(root: View) {}
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean = TODO("m1.onKey")
}

/** Aba de mensagens (layout `tab_message_fragment`; log "TabFunctionMessageFragment"): lista + detalhe. Original: com/live/evo/fragment/p2.java */
class TabFunctionMessageFragment : LazyMenuFragment(), View.OnKeyListener {
    override fun layoutId() = com.live.evo.R.layout.tab_message_fragment
    override fun initData(savedInstanceState: Bundle?) {}
    override fun bindViews(root: View) {}
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean = TODO("p2.onKey")
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
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean = TODO("r2.onKey")
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
class FeedbackItemAdapter : android.widget.BaseAdapter() {
    override fun getCount() = 0
    override fun getItem(position: Int): Any? = null
    override fun getItemId(position: Int) = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: android.view.ViewGroup?): View = TODO("feedback_item")
}
