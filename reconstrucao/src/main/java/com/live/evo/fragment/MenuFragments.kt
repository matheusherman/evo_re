package com.live.evo.fragment

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.Window
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
 * Favoritos (layout `newfavorite_fragment`, ids `favf_*`): lista de canais favoritos; broadcast
 * `com.bb.action.FAVORITE` (extras channelId/channelName/channelFavorite) quando o usuário marca/desmarca;
 * `n0()`/`u0(ChannelData)`/`v0(int)`/`w0(int)` carregam e removem; respeita `pip_on_channel`.
 * Original: com/live/evo/fragment/a0.java (log "FavoriteFragment"; factory `t0(String tag, presenter)`)
 */
class FavoriteFragment : LazyMenuFragment(), View.OnKeyListener {
    override fun layoutId() = com.live.evo.R.layout.newfavorite_fragment
    override fun initData(savedInstanceState: Bundle?) {}
    override fun bindViews(root: View) {}
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean = TODO("a0.onKey")
}

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
 * Configuração do PIP (layout `newpipsetting_fragment`): ligar/desligar PIP, posição e tamanho
 * (adapter [PipSettingsAdapter] `pipsettings_list_item`, ids `pip_*`); grava via AppUserManager (`pip_info` = "J,L,M").
 * Original: com/live/evo/fragment/b2.java (factory `d0(String, presenter)`); adapter d2.java
 */
class PipSettingFragment : LazyMenuFragment(), View.OnKeyListener {
    override fun layoutId() = com.live.evo.R.layout.newpipsetting_fragment
    override fun initData(savedInstanceState: Bundle?) {}
    override fun bindViews(root: View) {}
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean = TODO("b2.onKey")
}
/** Original: com/live/evo/fragment/d2.java */
class PipSettingsAdapter : android.widget.BaseAdapter() {
    override fun getCount() = 0
    override fun getItem(position: Int): Any? = null
    override fun getItemId(position: Int) = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: android.view.ViewGroup?): View = TODO("pipsettings_list_item")
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
 * Login por telefone na TV (layout `newphone_login_fragment`, `phoneloginf_*`): opções remotas `phone_login_option_one/two`,
 * `phone_login_attention`, intervalo de pedido de código `request_phone_code_interval`; "refresh" do QR.
 * Original: com/live/evo/fragment/c2.java
 */
class PhoneLoginFragment : LazyMenuFragment(), View.OnClickListener, View.OnKeyListener {
    override fun layoutId() = com.live.evo.R.layout.newphone_login_fragment
    override fun initData(savedInstanceState: Bundle?) {}
    override fun bindViews(root: View) {}
    override fun onClick(v: View) {}
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean = TODO("c2.onKey")
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
