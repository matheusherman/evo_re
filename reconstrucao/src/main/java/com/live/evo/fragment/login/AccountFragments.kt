package com.live.evo.fragment.login

import android.graphics.Paint
import android.os.CountDownTimer
import com.live.evo.MyApplication
import com.live.evo.dialog.RemindAlertDialog
import java.util.concurrent.TimeUnit
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.Html
import android.text.TextUtils
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.foxivid.baselib.user.UserManager
import com.google.android.material.tabs.TabLayout
import com.live.evo.AppConfig
import com.live.evo.AppConstants
import com.live.evo.AppUserManager
import com.live.evo.R
import com.live.evo.dialog.ConfirmDialog
import com.live.evo.dialog.UserListDialog
import com.live.evo.fragment.BaseFragment
import com.live.evo.fragment.NetworkStatusDialogFragment
import com.live.evo.fragment.login.presenter.*
import com.live.evo.model.AccountBean
import com.live.evo.util.AccountValidators
import com.live.evo.util.AnimUtils
import com.live.evo.util.CommonUtils
import com.live.evo.util.ContactTemplate
import com.live.evo.util.LoginConfig
import com.live.evo.util.ModelHelper
import com.live.evo.util.PhoneInputHelper
import com.live.evo.util.TextStyleUtils
import com.live.evo.util.ToastUtils
import com.live.evo.widget.EmailAutoCompleteTextView
import com.live.evo.widget.RechargeEditText
import com.live.evo.widget.RemoveKeyCodeEnterEditText

/**
 * Tela de login principal (layout `accountuser_login_fragment`, ids `loginf_*`) com TabLayout:
 * - aba 1 = login por e-mail/usuário (`loginf_et_username`, [EmailAutoCompleteTextView]), aba 2 = telefone (`lly_phone`: spinner de DDI
 *   `spinner_phonecode` + `et_phonenumber`, via [PhoneInputHelper]), aba 3 = renewal code (`loginf_ret_renewcode`, [RechargeEditText] + checkbox
 *   `cb_checkbox` "li e aceito" obrigatório). Ordem/abas visíveis vêm da propriedade remota `login_tab_rule` (CSV de 0..3, padrão "1,2").
 * - Aba inicial: argumento `showTab`; se 0 usa o modo de conta do SDK ([ModelHelper.welcomeMode]): 6 → aba 2, 2 → aba 1; senão a última
 *   conta salva ([onSavedAccount], K0). A aba 2 liga [AppConstants.flagG] (a.f5187g).
 * - Botão login ([login], A0): aba usuário → `presenter.login(user, pwd, 0, "", "")`; telefone → `login(phone normalizado, pwd, tipo, DDI, país)`;
 *   renew code (sem espaços; "********" é substituído pelo código salvo se prefixo/sufixo casam, senão `invalid_code`) →
 *   `presenter.loginByRenewalCode`. Validação ([validate], m0): conta vazia → `account_empty`; senha vazia → `password_no_empty`;
 *   tipo inválido → `user_no_correct`. Código vazio → `renewal_empty`; sem checkbox → `code_bind_checkbox_tips` (balança view).
 * - "Esqueci a senha" → `callback.onResetPassword(this, account)`; "Registrar" → `callback.onRegister(this)`; renew code ok → `callback.onRenewCodeLogin`
 *   (via [onP]); sucesso → `callback.onLoginSuccess(this)`; voltar → `callback.onBack`. Erro "-3" → [NetworkStatusDialogFragment] e retry.
 * - Erros: [showError]/[showErrorText] — "10101100" → `code_is_block`; "chr(:)" separa um sufixo mostrado num [ConfirmDialog] que, ao fechar,
 *   preenche o campo com a conta indicada; "N:msg" vira "msg(N)".
 * - E-mail com autocompletar: domínios remotos `email_domains` (padrão gmail/hotmail/outlook/yahoo/yahoo.com.br).
 * Implementa [LoginView] (retornos do [LoginPresenter]) e [LoginNavigator.BackHandler] (H()).
 *
 * Original: com/live/evo/fragment/login/b.java (tag Y = "AccountUserLoginFragment"; F0 = show)
 */
class AccountUserLoginFragment : BaseFragment(), LoginView, View.OnClickListener, View.OnFocusChangeListener, LoginNavigator.BackHandler {
    /** Aba (posição no TabLayout, tipo 0..3, título, Tab, View do tab). Original: classe interna `j` */
    private class TabItem(val position: Int, val type: Int, val title: String, val tab: TabLayout.Tab, val view: View?)

    private var root: View? = null
    private var window: Window? = null
    private var presenter: LoginPresenterContract? = null
    private var callback: LoginNavigator.AccountLoginCallback? = null
    private var showBack = false
    private var errorMessage: String? = ""
    private var showTab = 0                  // H: aba pedida
    private var tabRule = ""                 // N: `login_tab_rule`
    private var emailTip = ""; private var phoneTip = ""; private var renewTip = ""   // O, P, Q
    private var accountType = 0              // I: tipo da conta validada
    private var savedRenewAccount: AccountBean? = null   // E
    private var lastFocusedForKeyboard: View? = null     // T
    private var tabs: MutableList<TabItem> = ArrayList()  // R

    private var ivBack: ImageView? = null; private var tvWelcome: TextView? = null; private var etPwd: EditText? = null
    private var etPhone: RemoveKeyCodeEnterEditText? = null; private var tvLogin: TextView? = null; private var tvRegister: TextView? = null
    private var tvError: TextView? = null; private var tvForget: TextView? = null; private var ivMoreUser: ImageView? = null
    private var tvRemind: TextView? = null; private var ivTitle: ImageView? = null; private var llSwitch: View? = null
    private var llEmailLogin: LinearLayout? = null; private var llCodeLogin: LinearLayout? = null; private var tvAccountTip: TextView? = null
    private var tvRenewalTip: TextView? = null; private var etUsername: EmailAutoCompleteTextView? = null; private var llPhone: LinearLayout? = null
    private var etRenew: RechargeEditText? = null; private var ivMoreCode: ImageView? = null; private var tabLayout: TabLayout? = null
    private var llChangePhone: LinearLayout? = null; private var cbCheckbox: CheckBox? = null; private var cbParent: View? = null; private var tvCbTip: TextView? = null
    private var phoneInput: PhoneInputHelper? = null
    private var loading: com.live.evo.widget.sloading.SLoadingDialog? = null
    private var keyboard: com.foxivid.ui.keyboard.KeyboardContainer? = null
    private var accountListDialog: UserListDialog? = null
    private var networkTester: NetworkStatusDialogFragment.NetworkTester? = null
    private val ui = Handler(Looper.getMainLooper())

    override fun setPresenter(presenter: LoginPresenterContract) { this.presenter = presenter }

    // ---------------------------------------------------------------- LoginView
    /** Mostra o erro do servidor (já formatado). Original: J(String) */
    override fun showError(message: String) { tvError!!.visibility = View.VISIBLE; showServerError("", message) }
    /** Preenche o formulário com a conta salva e escolhe a aba. Original: k(AccountBean) */
    override fun onSavedAccount(account: AccountBean?) {
        val tabFromAccount = tabForAccount(account)
        if (account != null) {
            val phone = AccountValidators.isPhone(account.phonePreCode + account.accountName, "") || account.type == 1
            AppConstants.flagG = phone
            fillAccount(account)
            val pwd = account.password
            if (!TextUtils.isEmpty(pwd) && ((AppConstants.flagG && account.type == 1) || (!AppConstants.flagG && account.type == 0))) {
                etPwd!!.setText(pwd); etPwd!!.setSelection(pwd!!.length)
            }
        }
        val code = UserManager.getCode()   // InteractionUtils.r()
        if (!TextUtils.isEmpty(code)) {
            savedRenewAccount = AccountBean(2, "", "", "", code)
            val masked = CommonUtils.maskEdges(code, 4, 8, "********")
            if (!TextUtils.isEmpty(masked)) { etRenew!!.setText(masked); etRenew!!.setSelection(etRenew!!.text.length) }
        }
        showTab = tabFromAccount
        applyInitialTab()
    }
    /** Primeiro login com renew code → fluxo de renew. Original: P() */
    override fun onP() { callback?.onRenewCodeLogin(this) }
    override fun hideLoading() { loading?.dismiss() }
    override fun showLoading() { loading?.show() }
    override fun onLoginSuccess() { callback?.onLoginSuccess(this) }
    /** Falha de rede: diálogo de diagnóstico e, se voltar online, refaz o login. Original: d() */
    override fun onNetworkError() {
        val act = activity as? AppCompatActivity ?: return
        NetworkStatusDialogFragment.show(act, networkTester) { online -> if (online) login() }
    }

    // ---------------------------------------------------------------- Back
    /** Fecha o teclado se aberto; botão voltar visível → `callback.onBack`; senão deixa o Navigator tratar. Original: H() */
    override fun handleBack(): Boolean {
        val kb = keyboard
        if (kb != null && kb.visibility == View.VISIBLE) { kb.hideOrDismissPopup(); return true }
        val b = ivBack
        if (b == null || b.visibility != View.VISIBLE) return LoginNavigator.dispatchBackPressed(this)
        callback?.onBack(this)
        return true
    }

    // ---------------------------------------------------------------- tabs
    private fun tabTitle(type: Int): String = when (type) {
        1 -> CommonUtils.string(R.string.user_email)
        2 -> CommonUtils.string(R.string.user_phone)
        3 -> CommonUtils.string(R.string.user_renewcode)
        else -> ""
    }

    /** Monta as abas a partir de `login_tab_rule` (CSV; padrão "1,2"; só 0..3 são aceitos). Original: k0(String) */
    private fun buildTabs(rule: String?) {
        var r = rule ?: ""
        if (r.isEmpty()) r = "1,2"
        try {
            tabs.clear()
            var pos = 0
            for (part in r.split(",")) {
                try {
                    val t = Integer.valueOf(part).toInt()
                    if (t in 0..3) {
                        val tab = tabLayout?.getTabAt(pos) ?: continue
                        tab.text = tabTitle(t)
                        tabs.add(pos, TabItem(pos, t, tabTitle(t), tab, (tabLayout!!.getChildAt(0) as? ViewGroup)?.takeIf { it.childCount > pos }?.getChildAt(pos)))
                        pos++
                    }
                } catch (_: Throwable) {}
            }
            var idx = tabLayout!!.tabCount - 1
            var extra = tabLayout!!.tabCount - tabs.size
            while (extra > 0) { tabLayout!!.removeTabAt(idx); idx--; extra-- }
        } catch (_: Throwable) {}
    }

    /** Tipo da aba (0 se não encontrada). Original: q0(Tab) */
    private fun typeOf(tab: TabLayout.Tab?): Int = tabs.firstOrNull { it.tab == tab }?.type ?: 0

    private fun selectedType(): Int = typeOf(tabLayout!!.getTabAt(tabLayout!!.selectedTabPosition))

    /** Aba para uma conta salva (3 se modo renew; 6/telefone → 2; demais → 1). Original: K0(AccountBean) */
    private fun tabForAccount(account: AccountBean?): Int {
        var mode = ModelHelper.welcomeMode()
        if (account != null) mode = if (account.type != 1) { if (AccountValidators.isPhone(account.phonePreCode + account.accountName, "")) 6 else 2 } else 6
        return if (mode == 3) 3 else if (mode != 6) 1 else 2
    }

    /** Seleciona a aba pedida (ou a primeira) e foca o campo apropriado. Original: L0() */
    private fun applyInitialTab() {
        if (tabs.isEmpty()) return
        if (showTab == 0 || tabs.none { it.type == showTab }) showTab = tabs[0].type
        val pending = tabLayout!!.tag as? Int
        if (pending != null) { switchTab(pending); tabLayout!!.tag = null } else switchTab(showTab)
        showTab = 0
    }

    /** Seleciona a aba [type] no TabLayout (sem mexer no foco). Original: D0(int) */
    private fun selectTabOnly(type: Int) { tabs.firstOrNull { it.type == type }?.tab?.select() }

    /** Seleciona a aba e leva o foco ao primeiro campo vazio. Original: w0(int) */
    fun switchTab(type: Int) {
        selectTabOnly(type); showPanel(type)
        when (type) {
            1 -> etUsername?.let { if (it.text.toString().trim().isEmpty()) { it.requestFocus(); AnimUtils.d(it); return } else etPwd?.let { p -> p.requestFocus(); AnimUtils.d(p); return } }
            2 -> if (phoneInput?.editText != null) {
                if (TextUtils.isEmpty(phoneInput!!.number())) { phoneInput!!.editText!!.requestFocus(); return }
                etPwd?.let { it.requestFocus(); AnimUtils.d(it); return }
            }
            3 -> etRenew?.let { if (it.text.toString().trim().isEmpty()) { it.requestFocus(); AnimUtils.d(it); return } }
        }
        tvLogin?.let { it.requestFocus(); AnimUtils.d(it) }
    }

    /** Mostra os campos da aba [type] e registra os EditTexts no teclado virtual. Original: l0(int) */
    fun showPanel(type: Int) {
        try {
            AppConstants.flagG = type == 2
            val kb = keyboard
            when (type) {
                1, 2 -> {
                    tvLogin!!.nextFocusDownId = R.id.loginf_tv_login; tvLogin!!.nextFocusUpId = -1
                    cbParent!!.visibility = View.GONE
                    if (llEmailLogin!!.visibility != View.VISIBLE) llEmailLogin!!.visibility = View.VISIBLE
                    if (llCodeLogin!!.visibility == View.VISIBLE) llCodeLogin!!.visibility = View.GONE
                    if (type == 1) {
                        tvAccountTip!!.text = Html.fromHtml(emailTip)
                        etPwd!!.nextFocusUpId = R.id.loginf_et_username
                        etUsername!!.visibility = View.VISIBLE; llPhone!!.visibility = View.GONE
                    } else {
                        tvAccountTip!!.text = Html.fromHtml(phoneTip)
                        etPwd!!.nextFocusUpId = R.id.et_phonenumber
                        etUsername!!.visibility = View.GONE; llPhone!!.visibility = View.VISIBLE
                    }
                    if (kb != null && kb.getTabTag() != type) {
                        kb.clearEditTexts(); kb.setTabTag(type)
                        if (type == 1) kb.addEditText(etUsername) else kb.addEditText(etPhone)
                        kb.addEditText(etPwd)
                    }
                }
                3 -> {
                    cbParent!!.visibility = View.VISIBLE
                    tvLogin!!.nextFocusDownId = R.id.cb_code_login_tip_parent; tvLogin!!.nextFocusUpId = R.id.loginf_ret_renewcode
                    if (llCodeLogin!!.visibility != View.VISIBLE) llCodeLogin!!.visibility = View.VISIBLE
                    if (llEmailLogin!!.visibility == View.VISIBLE) llEmailLogin!!.visibility = View.GONE
                    if (kb != null && kb.getTabTag() != 3) { kb.clearEditTexts(); kb.setTabTag(3); kb.addEditText(etRenew) }
                }
            }
        } catch (_: Throwable) {}
    }

    // ---------------------------------------------------------------- ações
    /** Valida conta/senha; define [accountType]. Original: m0(String, String) */
    private fun validate(account: String, password: String): Boolean {
        if (TextUtils.isEmpty(account)) {
            val target: View = if (AppConstants.flagG) phoneInput!!.editText!! else etUsername!!
            target.requestFocus(); shake(target)
            showFieldError(getString(R.string.account_empty))
            return false
        }
        if (TextUtils.isEmpty(password)) {
            showFieldError(CommonUtils.string(R.string.password_no_empty)); etPwd!!.requestFocus(); shake(etPwd!!)
            return false
        }
        accountType = AccountValidators.accountType(account)
        if (accountType >= 0) return true
        tvError!!.setText(R.string.user_no_correct)
        ToastUtils.showIfOffscreen(tvError, requireActivity(), R.string.user_no_correct, 1)
        return false
    }

    /** Dispara o login conforme a aba atual. Original: A0() */
    fun login() {
        when (selectedType()) {
            1 -> {
                val user = etUsername!!.text.toString().trim(); val pwd = etPwd!!.text.toString().trim()
                if (validate(user, pwd)) presenter?.login(user, pwd, 0, "", "")
            }
            2 -> {
                val full = phoneInput!!.fullNumber(); val pwd = etPwd!!.text.toString().trim()
                if (validate(full, pwd)) {
                    val normalized = AccountValidators.normalizePhone(full); val c = phoneInput!!.selectedCountry()
                    presenter?.login(normalized, pwd, accountType, c.preCode, c.code)
                }
            }
            3 -> {
                var code = etRenew!!.text.toString().trim().replace(" ", "")
                if (TextUtils.isEmpty(code)) { etRenew!!.requestFocus(); showFieldError(CommonUtils.string(R.string.renewal_empty)); shake(etRenew!!); return }
                val saved = savedRenewAccount
                if (code.contains("********") && saved != null && saved.accountName!!.startsWith(code.substring(0, 3)) && saved.accountName!!.endsWith(code.substring(code.length - 4))) code = saved.accountName!!
                else if (code.contains("*")) { etRenew!!.requestFocus(); showFieldError(CommonUtils.string(R.string.invalid_code)); shake(etRenew!!); return }
                if (cbCheckbox!!.isChecked) { presenter?.loginByRenewalCode(requireContext(), code); return }
                showFieldError(CommonUtils.string(R.string.code_bind_checkbox_tips)); shake(cbCheckbox!!); shake(cbParent!!); cbParent!!.requestFocus()
            }
        }
    }

    /** Esqueci a senha: guarda a aba atual e chama o callback com a conta (salva ou digitada). Original: B0() */
    private fun forgotPassword() {
        val typed = if (AppConstants.flagG) phoneInput!!.fullNumber() else etUsername!!.text.toString().trim()
        var account = ModelHelper.savedAccount()
        if (account == null) {
            account = AccountBean()
            if (AppConstants.flagG) { account.type = 1; account.accountName = phoneInput!!.number(); val c = phoneInput!!.selectedCountry(); account.countryCode = c.code; account.phonePreCode = c.preCode }
            else { account.type = 0; account.accountName = typed }
        }
        callback?.onResetPassword(this, account)
    }

    /** Escolhe conta da lista (tipo 3 = renew code). Original: J0(int) */
    private fun showAccountList(mode: Int) {
        val d = UserListDialog(requireActivity(), mode, object : UserListDialog.Listener {
            override fun onAccountSelected(account: AccountBean) {
                accountListDialog?.hide()
                if (mode == 3) { savedRenewAccount = account; etRenew!!.setText(CommonUtils.maskEdges(account.accountName, 4, 8, "********")) }
                else { fillAccount(account); etPwd!!.setText(if (TextUtils.isEmpty(account.password)) "" else account.password) }
            }
        })
        accountListDialog = d
        if (d.hasAccounts()) d.show()
    }

    /** Preenche usuário/telefone de uma conta salva. Original: t0(AccountBean) */
    private fun fillAccount(account: AccountBean) {
        if (AppConstants.flagG || account.type == 1) { phoneInput!!.setAccount(account); return }
        val name = account.accountName
        if (name != null && AccountValidators.isEmail(name)) {
            etUsername!!.setText(name)
            if (name.isNotEmpty()) etUsername!!.setSelection(name.length)
        }
    }

    // ---------------------------------------------------------------- erros
    private fun shake(v: View) { v.startAnimation(AnimationUtils.loadAnimation(context, R.anim.arrow_shake)) }

    /** Original: G0(String) — erro de campo (também em toast se fora da tela). */
    private fun showFieldError(msg: String) {
        tvError!!.visibility = View.VISIBLE; tvError!!.text = msg
        ToastUtils.showIfOffscreen(tvError, requireActivity(), msg, 1)
    }

    /** Erro do servidor. "10101100" = código bloqueado; "...chr(:)<conta>" mostra diálogo que preenche o campo. Original: H0(String, String) */
    private fun showServerError(prefix: String, error: String?) {
        if (error != null && error.contains("10101100")) { tvError!!.text = CommonUtils.string(R.string.code_is_block); return }
        val parts = (error ?: "").split(Regex("chr[(]:[)]"))
        val suffix = if (parts.size > 1) parts[1] else ""
        var text = parts[0]
        if (text.isNotEmpty() && text.contains(":")) {
            val p = text.split(":")
            if (p.size > 1) text = p[1] + "(" + p[0] + ")"
        }
        val msg = String.format("%s%s", prefix, text)
        tvError!!.text = msg
        if (suffix.isEmpty()) ToastUtils.showIfOffscreen(tvError, requireActivity(), msg, 1)
        else showAccountHintDialog(suffix, msg)
    }

    /** Diálogo "essa conta já existe": ao fechar preenche o campo com [account] e foca. Original: I0(String, String) */
    private fun showAccountHintDialog(account: String, msg: String) {
        val fill = Runnable {
            etPwd!!.setText("")
            var target: EditText = etUsername!!
            if (AccountValidators.isPhone(account, "")) {
                phoneInput!!.setFullNumber(account); target = phoneInput!!.editText!!; switchTab(2)
            } else {
                val v = if (AccountValidators.isEmail(account)) account else ""
                target.setText(v); if (v.isNotEmpty()) target.setSelection(v.length); switchTab(1)
            }
            target.requestFocus()
        }
        ConfirmDialog(requireActivity()).show(msg, getString(R.string.log_in), getString(R.string.close), fill, null, true, true, true)
    }

    // ---------------------------------------------------------------- views
    private fun bindViews() {
        val v = root!!
        ivBack = v.findViewById(R.id.loginf_iv_back); tvWelcome = v.findViewById(R.id.loginf_tv_welcome); etPwd = v.findViewById(R.id.et_pwd)
        etPhone = v.findViewById(R.id.et_phonenumber); tvLogin = v.findViewById(R.id.loginf_tv_login); tvRegister = v.findViewById(R.id.loginf_tv_register)
        tvError = v.findViewById(R.id.loginf_tv_error); tvForget = v.findViewById(R.id.loginf_tv_forget_pwd); ivMoreUser = v.findViewById(R.id.loginf_iv_more_user)
        tvRemind = v.findViewById(R.id.loginf_tv_remind)
        ivTitle = v.findViewById(R.id.loginf_iv_title)
        ivTitle!!.setImageDrawable(ResourcesCompat.getDrawable(resources, AppConfig.launcherIcon, null))
        llSwitch = v.findViewById(R.id.loginf_ll_switch); llEmailLogin = v.findViewById(R.id.loginf_ll_email_login); llCodeLogin = v.findViewById(R.id.loginf_ll_code_login)
        tvAccountTip = v.findViewById(R.id.loginf_tv_account_tip); tvRenewalTip = v.findViewById(R.id.loginf_tv_renewal_tip)
        etUsername = v.findViewById(R.id.loginf_et_username); llPhone = v.findViewById(R.id.lly_phone); etRenew = v.findViewById(R.id.loginf_ret_renewcode)
        ivMoreCode = v.findViewById(R.id.loginf_iv_more_code); tabLayout = v.findViewById(R.id.loginf_tl_tab_layout); llChangePhone = v.findViewById(R.id.lly_changephone)
        cbCheckbox = v.findViewById(R.id.cb_checkbox); cbParent = v.findViewById(R.id.cb_code_login_tip_parent); tvCbTip = v.findViewById(R.id.cb_code_login_tip)
        phoneInput = PhoneInputHelper(requireContext(), v)
        llSwitch!!.visibility = if (LoginConfig.get().intE() == 1) View.VISIBLE else View.GONE
        loading = com.live.evo.widget.sloading.SLoadingDialog(requireActivity()).setStyle(com.live.evo.widget.sloading.LoadingStyle.TRANSLATE_CIRCLE).setColor(CommonUtils.color(R.color.color_focused))
        tvRegister!!.paint.flags = Paint.UNDERLINE_TEXT_FLAG; tvForget!!.paint.flags = Paint.UNDERLINE_TEXT_FLAG
        tvRegister!!.paint.isAntiAlias = true; tvForget!!.paint.isAntiAlias = true
        TextStyleUtils.c(etUsername); TextStyleUtils.c(etPwd); TextStyleUtils.b(tvRegister); TextStyleUtils.b(tvForget)
        TextStyleUtils.d(tvLogin); TextStyleUtils.d(tvError); TextStyleUtils.c(etRenew)
        tvRegister!!.text = resources.getString(R.string.create_a_new_account); tvForget!!.text = resources.getString(R.string.forget_password)
        cbCheckbox!!.nextFocusRightId = R.id.cb_checkbox
        if (AppUserManager.get().needAdultWarning()) {
            tvRegister!!.visibility = View.GONE; tvWelcome!!.visibility = View.GONE; tvForget!!.visibility = View.INVISIBLE
            etPwd!!.nextFocusDownId = R.id.loginf_tv_login; tvRemind!!.visibility = View.VISIBLE; ivTitle!!.visibility = View.GONE
        } else { tvForget!!.visibility = View.VISIBLE; ivTitle!!.visibility = View.VISIBLE; tvRemind!!.visibility = View.GONE }
        if (LoginConfig.get().flagD()) { tvRegister!!.visibility = View.GONE; tvForget!!.visibility = View.GONE }
        keyboard?.let { it.addEditText(etUsername); it.addEditText(etPwd); it.setTabTag(1) }
    }

    /** Textos remotos e abas. Original: l() */
    private fun refreshTexts() {
        if (showBack) ivBack!!.visibility = View.VISIBLE
        tvRemind!!.text = ContactTemplate.a("adult_login_remind", CommonUtils.string(R.string.adult_login_remind))
        tvError!!.visibility = View.INVISIBLE
        if (!TextUtils.isEmpty(errorMessage)) showServerError("", errorMessage)
        tvWelcome!!.text = Html.fromHtml(ContactTemplate.a("login_account_title", CommonUtils.string(R.string.login_title)))
        emailTip = ContactTemplate.a("login_by_email_remind", CommonUtils.string(R.string.login_email))
        phoneTip = ContactTemplate.a("login_by_phone_remind", CommonUtils.string(R.string.login_phone))
        renewTip = ContactTemplate.a("login_by_renewal_remind", CommonUtils.string(R.string.renewal_login_tip))
        tvRenewalTip!!.text = Html.fromHtml(renewTip)
        tvCbTip!!.text = Html.fromHtml(ContactTemplate.a("login_by_renewal_code_check_remind", CommonUtils.string(R.string.code_login_tip)))
        etUsername!!.setDomains(AppUserManager.get().getString("email_domains", "gmail.com,hotmail.com,outlook.com,yahoo.com,yahoo.com.br"), false)
        buildTabs(tabRule)
        tabLayout!!.visibility = if (tabs.size > 1) View.VISIBLE else View.GONE
        if (tabs.isNotEmpty()) {
            val ll = tabLayout!!.getChildAt(0) as LinearLayout
            ll.showDividers = 2; ll.dividerDrawable = CommonUtils.drawable(R.drawable.login_tab_divider)
        }
        applyInitialTab()
    }

    private fun bindListeners() {
        // D-pad: setas entre campos/abas ficam nas views do layout (nextFocus*); aqui só os cliques/foco.
        cbCheckbox!!.setOnFocusChangeListener { _, f -> if (f) cbParent!!.setBackgroundResource(R.drawable.checkbox_focus) else cbParent!!.setBackgroundColor(CommonUtils.color(2131102158)) }
        for (b in listOf<View?>(ivBack, tvLogin, tvRegister, tvForget, ivMoreUser, ivMoreCode)) b?.setOnClickListener(this)
        for (f in listOf<View?>(tvLogin, ivMoreUser, etUsername, etPwd, etRenew, ivMoreCode)) f?.onFocusChangeListener = this
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) { tvError!!.text = ""; showPanel(typeOf(tab)) }
            override fun onTabReselected(tab: TabLayout.Tab) {}
            override fun onTabUnselected(tab: TabLayout.Tab) {}
        })
        for (t in tabs) t.view?.setOnFocusChangeListener { v, hasFocus -> if (hasFocus && v != null) { t.tab.select(); showPanel(t.type) } }
        val clearError = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) { tvError!!.text = "" }
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
        }
        etPwd!!.addTextChangedListener(clearError); etRenew!!.addTextChangedListener(clearError)
        tvError!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(e: Editable?) { tvError!!.visibility = if (TextUtils.isEmpty(e)) View.INVISIBLE else View.VISIBLE }
            override fun beforeTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
            override fun onTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
        })
        // OK/ENTER nos campos de texto abre/fecha o teclado virtual de TV; CIMA salta para a aba correspondente.
        val keys = View.OnKeyListener { view, keyCode, event ->
            val kb = keyboard
            val textField = view.id == R.id.et_phonenumber || view.id == R.id.et_pwd || view.id == R.id.loginf_et_username || view.id == R.id.loginf_ret_renewcode
            val ok = keyCode == 23 || keyCode == 66
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == 19 && (kb == null || kb.visibility != View.VISIBLE)) {
                when (view.id) {
                    R.id.et_phonenumber, R.id.spinner_phonecode -> { focusTab(2); true }
                    R.id.loginf_et_username -> { focusTab(1); true }
                    R.id.loginf_iv_more_code, R.id.loginf_ret_renewcode -> { focusTab(3); true }
                    R.id.loginf_iv_more_user -> { focusTab(if (AppConstants.flagG) 2 else 1); true }
                    else -> false
                }
            } else if (kb != null && event.action == KeyEvent.ACTION_DOWN && ok) {
                if (textField) { kb.toggle(); if (view.id != R.id.et_phonenumber) lastFocusedForKeyboard = view; true } else false
            } else if (kb != null && event.action == KeyEvent.ACTION_UP && ok) textField
            else if (kb != null && event.action == KeyEvent.ACTION_UP && (keyCode == 4 || keyCode == 111)) {
                if (textField) { lastFocusedForKeyboard?.onFocusChangeListener = this; if (kb.visibility == View.VISIBLE) { kb.hideOrDismissPopup(); true } else false } else false
            } else if (event.action == KeyEvent.ACTION_DOWN && keyCode == 20 && view.id == R.id.loginf_tv_login) { tvRegister!!.requestFocus(); true }
            else false
        }
        for (v in listOf<View?>(etUsername, ivMoreUser, phoneInput!!.spinner, phoneInput!!.editText, etRenew, ivMoreCode, etPwd, tvLogin)) v?.setOnKeyListener(keys)
    }

    private fun focusTab(type: Int) { tabs.firstOrNull { it.type == type }?.let { it.tab.select(); it.view?.requestFocus() } }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.loginf_iv_back -> callback?.onBack(this)
            R.id.loginf_iv_more_code -> showAccountList(3)
            R.id.loginf_iv_more_user -> showAccountList(if (AppConstants.flagG) 6 else 2)
            R.id.loginf_tv_forget_pwd -> { tabLayout!!.tag = selectedType(); forgotPassword() }
            R.id.loginf_tv_login -> login()
            R.id.loginf_tv_register -> callback?.let { tabLayout!!.tag = selectedType(); it.onRegister(this) }
        }
    }

    override fun onFocusChange(view: View, hasFocus: Boolean) {
        if (!hasFocus) { AnimUtils.g(view); return }
        AnimUtils.d(view)
        if (view.id == R.id.et_pwd) { val t = etPwd!!.text.toString(); if (t.isNotEmpty()) etPwd!!.setSelection(t.length) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        root = inflater.inflate(R.layout.accountuser_login_fragment, container, false)
        keyboard = com.foxivid.ui.keyboard.KeyUtils.create(window, requireContext(), root, lifecycle, false)
        presenter = LoginPresenter().also { it.attach(this) }
        tabRule = AppUserManager.get().getString("login_tab_rule", "")
        networkTester = NetworkStatusDialogFragment.createTester(requireActivity())
        bindViews(); refreshTexts(); bindListeners()
        return root!!
    }
    override fun onHiddenChanged(hidden: Boolean) { super.onHiddenChanged(hidden); if (!hidden) refreshTexts() }
    override fun onResume() { super.onResume(); presenter?.attach(this); presenter?.loadSavedAccount() }
    override fun onPause() { presenter?.detach(); super.onPause() }
    override fun onDestroy() { instance = null; super.onDestroy() }

    /** Fecha o teclado virtual ao reexibir (z0 via `Handler.post`). Original: s0() / z0() */
    private fun scheduleCloseKeyboard() {
        ui.post {
            lastFocusedForKeyboard?.onFocusChangeListener = this
            keyboard?.let { if (it.visibility == View.VISIBLE) it.hideOrDismissPopup() }
        }
    }

    companion object {
        private const val TAG = "AccountUserLoginFragment"
        private var instance: AccountUserLoginFragment? = null
        /** Original: n0() */ private fun create(): AccountUserLoginFragment = AccountUserLoginFragment().also { instance = it }

        /**
         * Reutiliza o fragment existente (re-exibe) ou cria; se `showTab == 0` deriva do modo da conta (6 → aba 2, 2 → aba 1).
         * Se o existente perdeu o callback é substituído. Original: F0(FragmentManager, Window, int, boolean, String, int, e5.c)
         */
        @Synchronized fun show(fm: FragmentManager, window: Window, containerId: Int, showBack: Boolean, errorMessage: String?, showTab: Int, cb: LoginNavigator.AccountLoginCallback) {
            var t = showTab
            if (t == 0) { val m = ModelHelper.welcomeMode(); if (m == 6) t = 2 else if (m == 2) t = 1 }
            val existing = fm.findFragmentByTag(TAG) as AccountUserLoginFragment?
            if (existing == null || existing.callback == null) {
                val f = create().also { it.window = window; it.callback = cb; it.showBack = showBack; it.errorMessage = errorMessage; it.showTab = t }
                existing?.let { fm.beginTransaction().remove(it).commitAllowingStateLoss() }
                fm.beginTransaction().add(containerId, f, TAG).commitAllowingStateLoss()
                f.scheduleCloseKeyboard()
            } else {
                existing.window = window; existing.callback = cb; existing.showBack = showBack
                existing.presenter?.loadSavedAccount()
                existing.errorMessage = errorMessage; existing.showTab = t
                existing.tabLayout?.tag = null
                fm.beginTransaction().show(existing).commitAllowingStateLoss()
                existing.scheduleCloseKeyboard()
            }
        }
    }
}

/**
 * Verificação de conta (layout `checkaccount_fragment`): mostra o código/username atual mascarado (`tv_checkaccount_code`, [CommonUtils.maskMiddle] com "*")
 * e pede e-mail (aba 1, [EmailAutoCompleteTextView]) ou telefone (aba 2, [PhoneInputHelper], só se `hasPhone`) para vincular a conta
 * (TabLayout `tab_layout`; textos `bind_remind_email`/`bind_remind_phone` e exemplos `enter_email`/`enter_phone`; tags do teclado 8/9).
 * OK: valida (vazio → `account_empty`; formato → `user_no_correct`), mostra loading, monta [AccountBean] (tipo 0 e-mail / 1 telefone)
 * e chama [CheckAccountPresenter.check] (corpo vazio no original), desabilitando o clique. Cancelar/Back: limpa e chama `Listener.a`.
 * [AppConstants.flagG] guarda se a aba de telefone está ativa. Singleton reutilizado (campo estático `z`), tag "CheckAccountFragment".
 * Original: com/live/evo/fragment/login/g.java (g0 = show; f = Listener)
 */
class CheckAccountFragment : BaseFragment(), CheckAccountView, View.OnClickListener, View.OnFocusChangeListener, LoginNavigator.BackHandler {
    private var root: View? = null
    private var tabLayout: TabLayout? = null
    private var tvRemind: TextView? = null; private var tvCode: TextView? = null; private var tvEg: TextView? = null; private var tvError: TextView? = null
    private var etUser: EmailAutoCompleteTextView? = null; private var llPhone: LinearLayout? = null
    private var btnOk: Button? = null; private var btnCancel: Button? = null
    private var etPhone: RemoveKeyCodeEnterEditText? = null
    private var phoneInput: PhoneInputHelper? = null
    private var presenter: CheckAccountPresenter? = null
    private var listener: Listener? = null
    private var currentCode: String? = null
    private var window: Window? = null
    private var hasPhone = false
    private var emailRemind = ""; private var phoneRemind = ""; private var emailEg = ""; private var phoneEg = ""
    private var loading: com.live.evo.widget.sloading.SLoadingDialog? = null
    private var keyboard: com.foxivid.ui.keyboard.KeyboardContainer? = null

    interface Listener { fun a(f: Fragment) }

    override fun setPresenter(presenter: Any?) {}

    /** Esconde o teclado, se aberto; senão cancela. Original: H() */
    override fun handleBack(): Boolean {
        val kb = keyboard
        if (kb == null || kb.visibility != View.VISIBLE) { cancel(); return true }
        kb.hideOrDismissPopup(); return true
    }

    /** Alterna entre e-mail (false) e telefone (true). Original: X(boolean) */
    fun switchMode(phone: Boolean) {
        AppConstants.flagG = phone
        val upId = if (phone) R.id.et_phonenumber else R.id.et_checkaccount_userid
        btnOk!!.nextFocusUpId = upId; btnCancel!!.nextFocusUpId = upId
        tvRemind!!.text = if (phone) phoneRemind else emailRemind
        tvEg!!.text = if (phone) phoneEg else emailEg
        val kb = keyboard; val tag = if (phone) 9 else 8
        if (kb != null && kb.getTabTag() != tag) { kb.clearEditTexts(); kb.setTabTag(tag); kb.addEditText(if (phone) etPhone else etUser) }
        etUser!!.visibility = if (!phone) View.VISIBLE else View.GONE
        llPhone!!.visibility = if (phone) View.VISIBLE else View.GONE
    }

    /** Valida e dispara a verificação. Original: Y() */
    private fun submit() {
        var id = if (AppConstants.flagG) phoneInput!!.fullNumber() else etUser!!.text.toString().trim()
        if (TextUtils.isEmpty(id)) { showError(CommonUtils.string(R.string.account_empty)); return }
        val valid = if (AppConstants.flagG) AccountValidators.isPhone(id, "") else AccountValidators.isEmail(id)
        if (!valid) { showError(CommonUtils.string(R.string.user_no_correct)); return }
        loading?.show()
        val type: Int
        if (AppConstants.flagG) { id = AccountValidators.normalizePhone(id); type = 1 } else type = 0
        val account = AccountBean()
        if (AppConstants.flagG) {
            val c = phoneInput!!.selectedCountry()
            account.phonePreCode = c.preCode; account.countryCode = c.code; account.accountName = phoneInput!!.number(); account.type = 1
        } else { account.type = 0; account.accountName = id }
        presenter?.check(id, type, account)
        btnOk!!.isClickable = false
    }

    private fun showError(msg: String) { tvError!!.visibility = View.VISIBLE; tvError!!.text = msg }

    /** Limpa os campos e devolve ao chamador. Original: e0() */
    private fun cancel() {
        tvError!!.visibility = View.INVISIBLE
        loading?.dismiss()
        etUser!!.setText(""); phoneInput!!.setNumber(""); phoneInput!!.selectIndex(0, true)
        listener?.a(this)
    }

    private fun bindViews() {
        val v = root!!
        tabLayout = v.findViewById(R.id.tab_layout)
        tvRemind = v.findViewById(R.id.tv_checkaccount_remind); tvCode = v.findViewById(R.id.tv_checkaccount_code)
        tvEg = v.findViewById(R.id.tv_checkaccount_eg); tvError = v.findViewById(R.id.tv_checkaccount_error)
        etUser = v.findViewById(R.id.et_checkaccount_userid); etPhone = v.findViewById(R.id.et_phonenumber)
        llPhone = v.findViewById(R.id.lly_phone); btnOk = v.findViewById(R.id.btn_checkaccount_ok); btnCancel = v.findViewById(R.id.btn_checkaccount_cancel)
        phoneInput = PhoneInputHelper(requireContext(), v)
        loading = com.live.evo.widget.sloading.SLoadingDialog(requireActivity()).setStyle(com.live.evo.widget.sloading.LoadingStyle.TRANSLATE_CIRCLE).setColor(R.color.sloading_color)
        if (!hasPhone) tabLayout!!.removeTabAt(1)
        TextStyleUtils.b(tvRemind); TextStyleUtils.d(tvCode); TextStyleUtils.b(tvEg); TextStyleUtils.b(tvError); TextStyleUtils.b(etUser)
        TextStyleUtils.d(btnOk); TextStyleUtils.d(btnCancel)
        etUser!!.requestFocus()
        emailRemind = CommonUtils.string(R.string.bind_remind_email); phoneRemind = CommonUtils.string(R.string.bind_remind_phone)
        emailEg = CommonUtils.string(R.string.enter_email); phoneEg = CommonUtils.string(R.string.enter_phone)
        keyboard?.let { it.addEditText(etUser); it.setTabTag(8) }
    }

    private fun bindListeners() {
        etUser!!.nextFocusRightId = R.id.et_checkaccount_userid
        phoneInput!!.editText!!.nextFocusRightId = R.id.et_phonenumber; phoneInput!!.editText!!.nextFocusDownId = R.id.btn_checkaccount_ok
        btnOk!!.nextFocusLeftId = R.id.btn_checkaccount_ok; btnCancel!!.nextFocusRightId = R.id.btn_checkaccount_cancel
        btnOk!!.setOnClickListener(this); btnCancel!!.setOnClickListener(this)
        etUser!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) { tvError!!.visibility = View.INVISIBLE }
            override fun afterTextChanged(e: Editable?) {}
            override fun onTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
        })
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) { switchMode(TextUtils.equals(tab.text, CommonUtils.string(R.string.bind_phone))) }
            override fun onTabReselected(tab: TabLayout.Tab) {}
            override fun onTabUnselected(tab: TabLayout.Tab) {}
        })
        if (tabLayout!!.tabCount >= 2) {
            val strip = tabLayout!!.getChildAt(0) as? ViewGroup
            if (strip != null && strip.childCount >= 2) { tabFocus(strip.getChildAt(0), 0); tabFocus(strip.getChildAt(1), 1) }
            val keys = View.OnKeyListener { view, keyCode, event ->
                val kb = keyboard
                val tab0 = tabLayout!!.getTabAt(0); val tab1 = tabLayout!!.getTabAt(1)
                val s = tabLayout!!.getChildAt(0) as? ViewGroup
                val v0 = if (s != null && s.childCount >= 2) s.getChildAt(0) else null
                val v1 = if (s != null && s.childCount >= 2) s.getChildAt(1) else null
                val ok = keyCode == 23 || keyCode == 66
                val field = view.id == R.id.et_checkaccount_userid || view.id == R.id.et_phonenumber
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == 19) {
                    if (kb == null || kb.visibility != View.VISIBLE) when (view.id) {
                        R.id.et_checkaccount_userid -> { tab0?.select(); v0?.requestFocus(); true }
                        R.id.et_phonenumber, R.id.spinner_phonecode -> { tabLayout!!.requestFocus(); tab1?.select(); v1?.requestFocus(); true }
                        R.id.tab_layout -> { if (tab0?.isSelected == true) etUser!!.requestFocus() else phoneInput!!.editText!!.requestFocus(); true }
                        else -> false
                    } else false
                } else if (kb != null && event.action == KeyEvent.ACTION_DOWN && ok) { if (field) { kb.toggle(); true } else false }
                else if (kb != null && event.action == KeyEvent.ACTION_UP && ok) field
                else if (kb != null && event.action == KeyEvent.ACTION_UP && (keyCode == 4 || keyCode == 111) && field && kb.visibility == View.VISIBLE) { kb.hideOrDismissPopup(); true }
                else false
            }
            etUser!!.setOnKeyListener(keys)
            if (strip != null && strip.childCount >= 2) { strip.getChildAt(0).nextFocusDownId = R.id.et_checkaccount_userid; strip.getChildAt(1).nextFocusDownId = R.id.et_phonenumber }
            phoneInput!!.spinner!!.setOnKeyListener(keys); phoneInput!!.editText!!.setOnKeyListener(keys)
        }
    }

    private fun tabFocus(view: View?, index: Int) {
        view?.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus && v != null) {
                val isPhone = TextUtils.equals(tabLayout!!.getTabAt(index)!!.text, CommonUtils.string(R.string.bind_phone))
                tabLayout!!.getTabAt(index)!!.select(); switchMode(isPhone)
            }
        }
    }

    /** Reinicia o formulário (ao reexibir). Original: l() */
    private fun reset() {
        tvCode!!.text = CommonUtils.maskMiddle(currentCode ?: "", "*")
        tvRemind!!.text = Html.fromHtml(emailRemind); tvEg!!.text = Html.fromHtml(emailEg)
        etUser!!.setText(""); etUser!!.requestFocus()
        etUser!!.setDomains("gmail.com,hotmail.com,outlook.com,yahoo.com,yahoo.com.br", false)
        phoneInput!!.selectIndex(0, true); phoneInput!!.setNumber("")
        switchMode(false)
    }

    /** Devolve o foco ao botão OK (chamado ao voltar de outra tela). Original: f0() */
    fun onShownAgain() { btnOk?.requestFocus() }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_checkaccount_cancel -> cancel()
            R.id.btn_checkaccount_ok -> { tvError!!.visibility = View.INVISIBLE; submit() }
        }
    }
    override fun onFocusChange(v: View, hasFocus: Boolean) { if (hasFocus) AnimUtils.d(v) else AnimUtils.g(v) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        root = inflater.inflate(R.layout.checkaccount_fragment, container, false)
        keyboard = com.foxivid.ui.keyboard.KeyUtils.create(window, requireContext(), root, lifecycle, false)
        presenter = CheckAccountPresenter().also { it.attach(this) }
        hasPhone = true
        bindViews(); reset(); bindListeners()
        return root!!
    }
    override fun onDestroy() { presenter?.detach(); super.onDestroy() }

    companion object {
        private var instance: CheckAccountFragment? = null
        private fun get(): CheckAccountFragment = instance ?: CheckAccountFragment().also { instance = it }
        /** Original: g0(String code, Window, FragmentManager, int container, f) */
        @Synchronized fun show(renewCode: String?, window: Window, fm: FragmentManager, containerId: Int, l: Listener) {
            val f = get().also { it.listener = l; it.currentCode = renewCode; it.window = window }
            val existing = fm.findFragmentByTag("CheckAccountFragment")
            val tx = fm.beginTransaction()
            if (existing == null) tx.add(containerId, f, "CheckAccountFragment").commitAllowingStateLoss()
            else { f.reset(); tx.show(existing).commitAllowingStateLoss() }
        }
    }
}

/**
 * Cadastro por e-mail/telefone (layout `register_email`, ids `registeremail_*`): abas e-mail (`register_email`) / telefone (`register_phone`),
 * campo de código de verificação com botões "enviar código" (`tv_verify` / `tv_verify_phone`, contagem regressiva de 120 s com
 * `send` + segundos e texto final `send_code`) e senha (`et_pwd`, 6 a 16 caracteres; escondida no tipo 0). Fluxo:
 * [RegisterEmailPresenter.requestVerifyCode] → [RegisterEmailView.onCodeSent] → [RegisterEmailPresenter.register] →
 * [RegisterEmailView.onRegistered] → `nav.next(this)`.
 * Tipos de registro (`registerType`): 0 = vincular e-mail (`register_bindemail_remind`; mostra "User ID: <username>"), 1/2 = cadastro normal
 * (`normal_register_remind` + texto de suporte), 3 = vincular renew code (`register_by_bind_renew_code`; mostra o código mascarado). Tipos 0 e 3
 * mostram o toast `not_supported_yet` ao enviar. [lockAccount] (flagB) bloqueia os campos de conta e usa o modo da aba global
 * ([AppConstants.flagG]); [showReturn] (flagA) mostra o botão voltar (`registeremail_tv_button_return`).
 * Erro 10101059 (conta já existe) → [ConfirmDialog] (fechar / `login`) que volta ao login (`nav.back`).
 * Singleton (campo estático `I`), tag "RegisterEmailFragment".
 * Original: com/live/evo/fragment/login/p.java (q0 = show)
 */
class RegisterEmailFragment : BaseFragment(), RegisterEmailView, View.OnClickListener, View.OnFocusChangeListener, LoginNavigator.BackHandler, android.text.TextWatcher {
    private var presenter: RegisterEmailPresenterContract? = null
    private var nav: LoginNavigator.FragmentNavigator? = null
    private var root: View? = null
    private var window: Window? = null
    private var hasTabs = false                    // A
    private var account: AccountBean? = null       // B
    private var registerType = 1                   // b
    private var showReturn = false                 // c
    private var lockAccount = false                // d
    private var tabLayout: TabLayout? = null; private var llSwitch: View? = null
    private var etEmail: EmailAutoCompleteTextView? = null; private var llPhone: LinearLayout? = null
    private var tvVerify: TextView? = null; private var tvVerifyPhone: TextView? = null
    private var etCode: EditText? = null; private var etPwd: EditText? = null; private var tvError: TextView? = null
    private var tvSubmit: TextView? = null; private var tvRemind: TextView? = null; private var tvReturn: TextView? = null; private var tvAccount: TextView? = null
    private var phoneInput: PhoneInputHelper? = null
    private var loading: com.live.evo.widget.sloading.SLoadingDialog? = null
    private var keyboard: com.foxivid.ui.keyboard.KeyboardContainer? = null
    private var emailTimer: CountDownTimer? = null; private var phoneTimer: CountDownTimer? = null
    private var lastFocusedField: View? = null
    private var networkTester: NetworkStatusDialogFragment.NetworkTester? = null

    override fun setPresenter(presenter: RegisterEmailPresenterContract) { this.presenter = presenter }

    // ---------------------------------------------------------------- RegisterEmailView
    /** Erro do servidor ao registrar. 10101059 = conta existente. Original: A(String, String) */
    override fun onCodeError(msg: String, code: String) {
        hideLoading()
        if (code.contains("10101059")) { showExistingAccountDialog(msg, resetTimers, goBack); return }
        val d = RemindAlertDialog(requireActivity(), object : RemindAlertDialog.Listener {
            override fun a() {}
            override fun b() { tvError!!.text = ""; resetVerifyButton() }
        })
        d.setTitle(CommonUtils.string(R.string.sign_up_fail)); d.setMessage(msg, CommonUtils.string(R.string.error_code) + code); d.show()
    }
    override fun hideLoading() { loading?.dismiss() }
    /** Código enviado: só esconde o loading (a contagem já começou). Original: h() */
    override fun onCodeSent() { hideLoading() }
    override fun onNetworkError() {
        val act = activity as? AppCompatActivity ?: return
        NetworkStatusDialogFragment.show(act, networkTester) { _ -> }
    }
    /** Registro concluído: zera timers e avança (`h.b`). Original: c() */
    override fun onRegistered() {
        hideLoading(); resetTimersAndButtons(); loading?.dismiss(); nav?.next(this)
    }
    /** Erro ao pedir o código (exceção ou servidor). Original: j(String, String) */
    override fun showError(msg: String, sub: String) {
        loading?.dismiss()
        if (sub == "10101059") { showExistingAccountDialog(msg, resetTimers, goBack); return }
        val d = RemindAlertDialog(requireActivity(), object : RemindAlertDialog.Listener {
            override fun a() {}
            override fun b() { resetVerifyButton() }
        })
        d.setTitle(CommonUtils.string(R.string.verify_fail)); d.setMessage(msg, CommonUtils.string(R.string.error_code) + sub); d.show()
        showFieldError("", msg)
    }

    // ---------------------------------------------------------------- helpers
    /** Runnable "fechar" (F do original): restaura os botões de código. */
    private val resetTimers = Runnable {
        tvVerify!!.isClickable = true; tvVerify!!.text = MyApplication.get().getString(R.string.send_code); emailTimer?.cancel()
        tvVerifyPhone!!.isClickable = true; tvVerifyPhone!!.text = MyApplication.get().getString(R.string.send_code); phoneTimer?.cancel()
    }
    /** Runnable "login" (G): volta ao login. */
    private val goBack = Runnable { goBackToLogin() }

    /** `b.e(activity).c().h(msg, close, login, onClose, onLogin, true, true, true)`. Original: s0(String, Runnable, Runnable) */
    private fun showExistingAccountDialog(msg: String, onClose: Runnable, onLogin: Runnable) {
        ConfirmDialog(requireActivity()).show(msg, getString(R.string.close), getString(R.string.login), onClose, onLogin, true, true, true)
    }

    private fun resetVerifyButton() {
        val phone = if (lockAccount) AppConstants.flagG else TextUtils.equals(tabLayout!!.getTabAt(tabLayout!!.selectedTabPosition)!!.text, CommonUtils.string(R.string.register_phone))
        if (phone) { tvVerifyPhone!!.isClickable = true; tvVerifyPhone!!.text = CommonUtils.string(R.string.send_code); phoneTimer?.cancel() }
        else { tvVerify!!.isClickable = true; tvVerify!!.text = CommonUtils.string(R.string.send_code); emailTimer?.cancel() }
    }
    private fun resetTimersAndButtons() {
        tvVerify!!.text = CommonUtils.string(R.string.send_code); tvVerify!!.isClickable = true
        tvVerifyPhone!!.text = CommonUtils.string(R.string.send_code); tvVerifyPhone!!.isClickable = true
        emailTimer?.cancel(); phoneTimer?.cancel()
    }

    /** Volta (`nav.back`) cancelando timers e reabilitando campos. Original: n0() */
    fun goBackToLogin() {
        nav?.back(this)
        emailTimer?.cancel(); phoneTimer?.cancel()
        if (lockAccount) { etEmail!!.isEnabled = true; phoneInput!!.spinner!!.isEnabled = true; phoneInput!!.editText!!.isEnabled = true }
        tvVerify!!.text = MyApplication.get().getString(R.string.send_code); tvVerify!!.isClickable = true
        tvVerifyPhone!!.text = MyApplication.get().getString(R.string.send_code); tvVerifyPhone!!.isClickable = true
        tvError!!.text = ""
    }

    /** Original: r0(prefix, message) — "N:msg" → "msg(N)"; mostra também em toast. */
    private fun showFieldError(prefix: String, message: String?) {
        var m = if (TextUtils.isEmpty(message)) "" else message!!
        if (!TextUtils.isEmpty(message) && message!!.contains(":")) { val p = message.split(":"); if (p.size > 1) m = p[1] + "(" + p[0] + ")" }
        val text = String.format("%s %s", prefix, m)
        tvError!!.text = text; ToastUtils.showLong(text)
    }
    private fun fieldError(resId: Int) { tvError!!.setText(resId); ToastUtils.showLong(getString(resId)) }

    // ---------------------------------------------------------------- ações
    /** Alterna campos e-mail/telefone e registra os EditTexts no teclado (tags 4 e 5). Original: h0(boolean) */
    fun switchMode(phone: Boolean) {
        val kb = keyboard
        if (phone) {
            if (kb != null && kb.getTabTag() != 5) { kb.clearEditTexts(); kb.setTabTag(5); kb.addEditText(phoneInput!!.editText); kb.addEditText(etCode); kb.addEditText(etPwd) }
            tvVerifyPhone!!.nextFocusUpId = R.id.et_phonenumber; etCode!!.nextFocusRightId = R.id.tv_verify_phone; etPwd!!.nextFocusUpId = R.id.tv_verify_phone
        } else {
            if (kb != null && kb.getTabTag() != 4) { kb.clearEditTexts(); kb.setTabTag(4); kb.addEditText(etEmail); kb.addEditText(etCode); kb.addEditText(etPwd) }
            tvVerify!!.nextFocusUpId = R.id.registeremail_et_email; etCode!!.nextFocusRightId = R.id.tv_verify; etPwd!!.nextFocusUpId = R.id.tv_verify
        }
        tvVerify!!.visibility = if (!phone) View.VISIBLE else View.GONE; tvVerifyPhone!!.visibility = if (phone) View.VISIBLE else View.GONE
        etEmail!!.visibility = if (!phone) View.VISIBLE else View.GONE; llPhone!!.visibility = if (phone) View.VISIBLE else View.GONE
    }

    /** Aplica o mapeamento de abas conforme o modo (e foca o primeiro campo). Original: t0() */
    private fun applyTabState() {
        if (lockAccount && llSwitch != null) { llSwitch!!.visibility = View.GONE; switchMode(AppConstants.flagG); return }
        val tl = tabLayout
        if (tl == null || tl.tabCount <= 1) return
        llSwitch!!.visibility = View.VISIBLE
        tl.getTabAt(if (AppConstants.flagG) 1 else 0)!!.select()
        switchMode(AppConstants.flagG)
        if (AppConstants.flagG) { phoneInput!!.editText!!.requestFocus(); return }
        etEmail!!.requestFocus(); lastFocusedField = etEmail; AnimUtils.d(etEmail)
    }

    /** Pré-preenche campos com a conta recebida. Original: j0(AccountBean) */
    private fun prefill(a: AccountBean?) {
        if (a == null) return
        if (AppConstants.flagG) {
            phoneInput!!.setAccount(a)
            if (TextUtils.isEmpty(a.accountName)) phoneInput!!.editText!!.requestFocus()
            phoneInput!!.selectCountry(a)
        } else {
            etEmail!!.setText(a.accountName)
            if (TextUtils.isEmpty(a.accountName)) { etEmail!!.requestFocus(); AnimUtils.d(etEmail) } else etEmail!!.setSelection(a.accountName!!.length)
        }
        if (TextUtils.isEmpty(a.accountName)) return
        if (AppConstants.flagG) tvVerifyPhone!!.requestFocus() else tvVerify!!.requestFocus()
    }

    /** Textos por tipo de registro e estado dos campos. Original: l() */
    private fun refreshTexts() {
        prefill(account)
        val remind: String
        when (registerType) {
            0 -> {
                remind = ContactTemplate.a("register_bindemail_remind", CommonUtils.string(R.string.register_by_bind))
                tvReturn!!.visibility = View.GONE; tvAccount!!.visibility = View.VISIBLE
                tvAccount!!.text = String.format("%s%s", CommonUtils.string(R.string.user_id), UserManager.getUsername())
            }
            1, 2 -> {
                remind = CommonUtils.string(R.string.normal_register_remind) + " " + ModelHelper.supportText()
                tvAccount!!.visibility = View.GONE; tvReturn!!.visibility = View.VISIBLE
            }
            3 -> {
                remind = CommonUtils.string(R.string.register_by_bind_renew_code)
                tvReturn!!.visibility = View.GONE; tvAccount!!.visibility = View.VISIBLE
                val code = UserManager.getCode()
                val shown = if (code.isEmpty()) CommonUtils.string(R.string.user_device) else CommonUtils.maskMiddle(code, "*")
                tvAccount!!.text = String.format("%s: %s", CommonUtils.string(R.string.renewal_code), shown)
            }
            else -> remind = ""
        }
        if (registerType == 0) etPwd!!.visibility = View.GONE else { etPwd!!.setText(""); etCode!!.setText(""); etPwd!!.visibility = View.VISIBLE }
        tvRemind!!.text = Html.fromHtml(remind)
        if (showReturn) tvReturn!!.visibility = View.VISIBLE
        applyTabState()
        if (!lockAccount) { etEmail!!.isEnabled = true; phoneInput!!.spinner!!.isEnabled = true; phoneInput!!.editText!!.isEnabled = true }
        else {
            etEmail!!.isEnabled = false; phoneInput!!.spinner!!.isEnabled = false; phoneInput!!.editText!!.isEnabled = false
            tvVerify!!.requestFocus(); lastFocusedField = tvVerify
        }
    }

    /** Pede o código de verificação e inicia a contagem de 120 s. Original: w0() */
    private fun requestCode() {
        tvError!!.text = ""
        var email = TextUtils.equals(tabLayout!!.getTabAt(tabLayout!!.selectedTabPosition)!!.text, CommonUtils.string(R.string.register_email))
        if (lockAccount) email = !AppConstants.flagG
        var id = if (email) etEmail!!.text.toString().trim() else phoneInput!!.fullNumber()
        if (TextUtils.isEmpty(id)) { fieldError(R.string.account_empty); return }
        if (!(if (email) AccountValidators.isEmail(id) else AccountValidators.isPhone(id, ""))) { fieldError(R.string.user_no_correct); return }
        loading?.show()
        val type: Int
        val a = AccountBean()
        if (email) { a.type = 0; a.accountName = id; type = 0 }
        else {
            id = AccountValidators.normalizePhone(id)
            val c = phoneInput!!.selectedCountry()
            a.type = 1; a.accountName = phoneInput!!.number(); a.phonePreCode = c.preCode; a.countryCode = c.code; type = 1
        }
        presenter?.requestVerifyCode(id, type, a)
        if (email) {
            emailTimer?.cancel()
            emailTimer = object : CountDownTimer(120000L, 1000L) {
                override fun onFinish() { try { tvVerify!!.text = CommonUtils.string(R.string.send_code); tvVerify!!.isClickable = true } catch (_: Exception) {} }
                override fun onTick(ms: Long) { try { tvVerify!!.text = CommonUtils.string(R.string.send) + TimeUnit.MILLISECONDS.toSeconds(ms) + "s)" } catch (_: Exception) {} }
            }.also { it.start() }
            tvVerify!!.isClickable = false
            return
        }
        phoneTimer?.cancel()
        phoneTimer = object : CountDownTimer(120000L, 1000L) {
            override fun onFinish() { try { tvVerifyPhone!!.text = CommonUtils.string(R.string.send_code); tvVerifyPhone!!.isClickable = true } catch (_: Exception) {} }
            override fun onTick(ms: Long) { try { tvVerifyPhone!!.text = CommonUtils.string(R.string.send) + TimeUnit.MILLISECONDS.toSeconds(ms) + "s)" } catch (_: Exception) {} }
        }.also { it.start() }
        tvVerifyPhone!!.isClickable = false
    }

    /** Valida tudo e envia o cadastro. Original: o0() */
    private fun submit() {
        var email = TextUtils.equals(tabLayout!!.getTabAt(tabLayout!!.selectedTabPosition)!!.text, CommonUtils.string(R.string.register_email))
        if (lockAccount) email = !AppConstants.flagG
        var id = if (email) etEmail!!.text.toString().trim() else phoneInput!!.fullNumber()
        if (TextUtils.isEmpty(id)) { fieldError(R.string.account_empty); return }
        if (!(if (email) AccountValidators.isEmail(id) else AccountValidators.isPhone(id, ""))) { fieldError(R.string.user_no_correct); return }
        val code = etCode!!.text.toString().trim()
        if (TextUtils.isEmpty(code)) { fieldError(R.string.verification_code_empty); return }
        var pwd = ""
        if (registerType != 0) {
            pwd = etPwd!!.text.toString().trim()
            if (TextUtils.isEmpty(pwd)) { fieldError(R.string.pwd_empty); return }
            if (pwd.length < 6 || pwd.length > 16) { showFieldError(CommonUtils.string(R.string.pwd_length_error), ""); return }
        }
        loading?.show()
        val type: Int
        val a = AccountBean()
        if (email) { a.type = 0; a.accountName = id; a.password = pwd; type = 0 }
        else {
            id = AccountValidators.normalizePhone(id)
            val c = phoneInput!!.selectedCountry()
            a.type = 1; a.accountName = phoneInput!!.number(); a.phonePreCode = c.preCode; a.countryCode = c.code; a.password = pwd; type = 1
        }
        if (registerType == 3 || registerType == 0) ToastUtils.showLong(getString(R.string.not_supported_yet))
        else presenter?.register(id, type, code, pwd, a)
    }

    override fun handleBack(): Boolean {
        val kb = keyboard
        if (kb != null && kb.visibility == View.VISIBLE) { kb.hideOrDismissPopup(); return true }
        val r = tvReturn
        if (r == null || r.visibility != View.VISIBLE) return LoginNavigator.dispatchBackPressed(this)
        goBackToLogin(); return true
    }

    private fun bindViews() {
        val v = root!!
        v.findViewById<ImageView>(R.id.registeremail_iv_title).setImageDrawable(ResourcesCompat.getDrawable(resources, AppConfig.launcherIcon, null))
        llSwitch = v.findViewById(R.id.lly_login_switch); tabLayout = v.findViewById(R.id.tab_layout)
        etEmail = v.findViewById(R.id.registeremail_et_email); llPhone = v.findViewById(R.id.lly_phone)
        tvVerify = v.findViewById(R.id.tv_verify); tvVerifyPhone = v.findViewById(R.id.tv_verify_phone)
        etCode = v.findViewById(R.id.registeremail_et_verify_code); etPwd = v.findViewById(R.id.et_pwd)
        tvError = v.findViewById(R.id.registeremail_tv_error); tvSubmit = v.findViewById(R.id.registeremail_tv_submit)
        tvRemind = v.findViewById(R.id.registeremail_ltv_remind); tvReturn = v.findViewById(R.id.registeremail_tv_button_return); tvAccount = v.findViewById(R.id.registeremail_tv_account)
        val trial = v.findViewById<TextView>(R.id.tv_trial_tip)
        if (!hasTabs) tabLayout!!.visibility = View.GONE
        phoneInput = PhoneInputHelper(requireContext(), v)
        loading = com.live.evo.widget.sloading.SLoadingDialog(requireContext()).setStyle(com.live.evo.widget.sloading.LoadingStyle.TRANSLATE_CIRCLE).setColor(android.graphics.Color.BLACK)
        for (t in listOf<TextView?>(etEmail, tvVerify, tvVerifyPhone, etCode, etPwd, tvError)) TextStyleUtils.c(t)
        TextStyleUtils.b(tvAccount); TextStyleUtils.d(tvSubmit); TextStyleUtils.d(tvReturn)
        trial.text = Html.fromHtml(requireActivity().getString(R.string.free_trial_tip, com.foxivid.baselib.heartbeat.HeartbeatManager.promotionTrialDays))
        etEmail!!.setDomains("gmail.com,hotmail.com,outlook.com,yahoo.com,yahoo.com.br", false)
        keyboard?.let { it.addEditText(etEmail); it.addEditText(etCode); it.addEditText(etPwd); it.setTabTag(4) }
    }

    private fun bindListeners() {
        phoneInput!!.spinner!!.nextFocusDownId = R.id.et_phonenumber
        phoneInput!!.editText!!.nextFocusDownId = R.id.tv_verify_phone; phoneInput!!.editText!!.nextFocusRightId = R.id.tv_verify_phone
        etEmail!!.nextFocusDownId = R.id.tv_verify
        tvVerify!!.nextFocusDownId = R.id.et_pwd; tvVerify!!.nextFocusLeftId = R.id.registeremail_et_verify_code; tvVerify!!.nextFocusRightId = R.id.tv_verify
        tvVerifyPhone!!.nextFocusDownId = R.id.et_pwd; tvVerifyPhone!!.nextFocusLeftId = R.id.registeremail_et_verify_code; tvVerifyPhone!!.nextFocusRightId = R.id.tv_verify_phone
        etCode!!.nextFocusRightId = R.id.tv_verify; etCode!!.nextFocusUpId = R.id.registeremail_et_email; etCode!!.nextFocusDownId = R.id.et_pwd; etCode!!.nextFocusLeftId = R.id.registeremail_et_verify_code
        etPwd!!.nextFocusDownId = R.id.registeremail_tv_submit; etPwd!!.nextFocusUpId = R.id.tv_verify; etPwd!!.nextFocusRightId = R.id.et_pwd
        tvSubmit!!.nextFocusRightId = if (tvReturn!!.visibility == View.VISIBLE) R.id.registeremail_tv_button_return else R.id.registeremail_tv_submit
        tvSubmit!!.nextFocusUpId = R.id.et_pwd; tvSubmit!!.nextFocusLeftId = R.id.registeremail_tv_submit
        tvReturn!!.nextFocusLeftId = R.id.registeremail_tv_submit; tvReturn!!.nextFocusUpId = R.id.et_pwd; tvReturn!!.nextFocusRightId = R.id.registeremail_tv_button_return
        for (c in listOf<View?>(tvVerify, tvVerifyPhone, tvSubmit, tvReturn)) c?.setOnClickListener(this)
        for (f in listOf<View?>(tvVerify, tvVerifyPhone, etPwd, tvSubmit, etEmail, etCode, tvReturn)) f?.onFocusChangeListener = this
        etCode!!.addTextChangedListener(this); etPwd!!.addTextChangedListener(this)
        etEmail!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) { tvError!!.text = "" }
            override fun afterTextChanged(e: Editable?) {}
            override fun onTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
        })
        tvError!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(e: Editable?) { tvError!!.visibility = if (TextUtils.isEmpty(e)) View.INVISIBLE else View.VISIBLE }
            override fun beforeTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
            override fun onTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
        })
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) { tvError!!.text = ""; switchMode(TextUtils.equals(tab.text, CommonUtils.string(R.string.register_phone))) }
            override fun onTabReselected(tab: TabLayout.Tab) {}
            override fun onTabUnselected(tab: TabLayout.Tab) {}
        })
        val strip = tabLayout!!.getChildAt(0) as? ViewGroup
        if (tabLayout!!.tabCount >= 2 && strip != null && strip.childCount >= 2) {
            for (i in 0..1) strip.getChildAt(i)?.setOnFocusChangeListener { v, hasFocus ->
                if (hasFocus && v != null) {
                    val phone = TextUtils.equals(tabLayout!!.getTabAt(i)!!.text, CommonUtils.string(R.string.register_phone))
                    tabLayout!!.getTabAt(i)!!.select(); switchMode(phone)
                }
            }
        }
        // OK abre/fecha o teclado virtual; CIMA salta entre a aba e o campo (como em AccountUserLoginFragment).
        val keys = View.OnKeyListener { view, keyCode, event ->
            val kb = keyboard
            val field = view.id == R.id.et_phonenumber || view.id == R.id.et_pwd || view.id == R.id.registeremail_et_email || view.id == R.id.registeremail_et_verify_code
            val ok = keyCode == 23 || keyCode == 66
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == 19) {
                if (kb == null || kb.visibility != View.VISIBLE) {
                    val s = tabLayout!!.getChildAt(0) as? ViewGroup
                    val has = s != null && s.childCount >= 2
                    if (view.id != R.id.et_phonenumber) {
                        if (view.id == R.id.registeremail_et_email) {
                            if (llSwitch!!.visibility != View.VISIBLE) return@OnKeyListener true
                            tabLayout!!.getTabAt(0)!!.select(); if (has) s!!.getChildAt(0).requestFocus(); return@OnKeyListener true
                        }
                    } else {
                        if (llSwitch!!.visibility != View.VISIBLE) return@OnKeyListener true
                        tabLayout!!.requestFocus(); tabLayout!!.getTabAt(1)!!.select(); if (has) s!!.getChildAt(1).requestFocus(); return@OnKeyListener true
                    }
                }
                false
            } else if (kb != null && event.action == KeyEvent.ACTION_DOWN && ok) { if (field) { kb.toggle(); if (view.id != R.id.et_phonenumber) lastFocusedField = view; true } else false }
            else if (kb != null && event.action == KeyEvent.ACTION_UP && ok) field
            else if (kb != null && event.action == KeyEvent.ACTION_UP && (keyCode == 4 || keyCode == 111) && field) {
                lastFocusedField?.onFocusChangeListener = this
                if (kb.visibility == View.VISIBLE) { kb.hideOrDismissPopup(); true } else false
            } else false
        }
        for (v in listOf<View?>(etEmail, phoneInput!!.spinner, phoneInput!!.editText, etCode, etPwd)) v?.setOnKeyListener(keys)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.registeremail_tv_button_return -> goBackToLogin()
            R.id.registeremail_tv_submit -> submit()
            R.id.tv_verify, R.id.tv_verify_phone -> requestCode()
        }
    }
    override fun onFocusChange(v: View, hasFocus: Boolean) { if (hasFocus) AnimUtils.d(v) else AnimUtils.g(v) }

    // TextWatcher (código e senha): limpa o erro ao editar
    override fun beforeTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) { tvError!!.text = "" }
    override fun onTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
    override fun afterTextChanged(s: Editable?) {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        root = inflater.inflate(R.layout.register_email, container, false)
        presenter = RegisterEmailPresenter().also { it.attach(this) }
        networkTester = NetworkStatusDialogFragment.createTester(requireActivity())
        keyboard = com.foxivid.ui.keyboard.KeyUtils.create(window, requireContext(), root, lifecycle, false)
        bindViews(); refreshTexts(); bindListeners()
        return root!!
    }
    override fun onResume() { super.onResume(); presenter?.attach(this) }
    override fun onPause() { presenter?.detach(); super.onPause() }
    override fun onStop() {
        super.onStop()
        emailTimer?.let { it.cancel(); tvVerify!!.isClickable = true; tvVerify!!.text = CommonUtils.string(R.string.send_code) }
        phoneTimer?.let { it.cancel(); tvVerifyPhone!!.isClickable = true; tvVerifyPhone!!.text = CommonUtils.string(R.string.send_code) }
    }
    override fun onDestroy() { instance = null; super.onDestroy() }

    companion object {
        private const val TAG = "RegisterEmailFragment"
        private var instance: RegisterEmailFragment? = null
        private fun get(): RegisterEmailFragment = instance ?: RegisterEmailFragment().also { instance = it }
        /** Original: q0(FragmentManager, Window, int container, int registerType, boolean showReturn, boolean lockAccount, AccountBean, h nav) */
        @Synchronized fun show(fm: FragmentManager, window: Window, containerId: Int, registerType: Int, showReturn: Boolean, lockAccount: Boolean, account: AccountBean?, nav: LoginNavigator.FragmentNavigator) {
            try {
                val f = get().also {
                    it.hasTabs = true; it.registerType = registerType; it.showReturn = showReturn; it.lockAccount = lockAccount
                    it.nav = nav; it.window = window; it.account = account
                }
                val existing = fm.findFragmentByTag(TAG)
                val tx = fm.beginTransaction()
                if (existing != null || f.isAdded) { f.refreshTexts(); tx.show(existing!!).commitAllowingStateLoss() }
                else { tx.add(containerId, f, TAG).commitAllowingStateLoss(); fm.executePendingTransactions() }
            } catch (_: Exception) {}
        }
    }
}

/**
 * Redefinição de senha (layout `reset_account_password`, `resetpwd_*`): abas e-mail (posição 0) / telefone (posição 1) — a aba de telefone só
 * existe se `hasPhoneFeature` = propriedade remota `contain_phone_account` (padrão true) — e os mesmos domínios `email_domains`.
 * Argumentos: `hasPhoneFeature`, `accountBean`, `onlyChange` (true = conta fixa: campos de conta desabilitados). Sem recurso de telefone a conta
 * também fica fixa. Fluxo: pedir código ([ResetPasswordPresenter.requestVerifyCode], contagem de 120 s no botão `tv_verify`) → digitar código e nova
 * senha (6 a 16 caracteres) → [ResetPasswordPresenter.resetPassword] → [onResetSuccess] → `nav.next` (e5.j.b).
 * Textos remotos: `reset_account_title`, `reset_account_title_below`, `RESET_REMIND` (+ e-mail de suporte), `reset_remind_phone`.
 * Erro do servidor → [RemindAlertDialog] (`verify_fail`) e texto no campo de erro. Teclado virtual com tags 6 (e-mail) e 7 (telefone).
 * Singleton (estático `I`) e navegador estático `H`. Tag "ResetAccountPasswordFragment" (G).
 * Original: com/live/evo/fragment/login/s.java (j0 = show)
 */
class ResetAccountPasswordFragment : BaseFragment(), ResetPasswordView, View.OnClickListener, View.OnFocusChangeListener, LoginNavigator.BackHandler {
    private var presenter: ResetPasswordPresenterContract? = null
    private var root: View? = null
    private var window: Window? = null
    private var llSwitch: View? = null
    private var tvTitle: TextView? = null; private var tvBelow: TextView? = null; private var tabLayout: TabLayout? = null
    private var llPhone: LinearLayout? = null; private var etEmail: EmailAutoCompleteTextView? = null; private var etPhone: RemoveKeyCodeEnterEditText? = null
    private var tvVerify: TextView? = null; private var etCode: EditText? = null; private var etPwd: EditText? = null
    private var tvSubmit: TextView? = null; private var tvReturn: TextView? = null; private var tvRemind: TextView? = null; private var tvError: TextView? = null
    private var phoneInput: PhoneInputHelper? = null
    private var loading: com.live.evo.widget.sloading.SLoadingDialog? = null
    private var keyboard: com.foxivid.ui.keyboard.KeyboardContainer? = null
    private var timer: CountDownTimer? = null
    private var account: AccountBean? = null
    private var hasPhoneFeature = true
    private var accountLocked = false
    private var emailRemind = ""; private var phoneRemind = ""
    private var lastFocusedField: View? = null
    private var networkTester: NetworkStatusDialogFragment.NetworkTester? = null

    override fun setPresenter(presenter: ResetPasswordPresenterContract) { this.presenter = presenter }

    // ---------------------------------------------------------------- ResetPasswordView
    /** Senha redefinida: reabilita o e-mail e avança (e5.j.b). Original: G() */
    override fun onResetSuccess() {
        hideLoading(); etEmail!!.isEnabled = true
        if (accountLocked) timer?.cancel()
        navigator?.next(this)
    }
    override fun hideLoading() { loading?.dismiss() }
    override fun onNetworkError() {
        val act = activity as? AppCompatActivity ?: return
        NetworkStatusDialogFragment.show(act, networkTester) { _ -> }
    }
    /** Código enviado: esconde o loading. Original: h() */
    override fun onCodeSent() { hideLoading() }
    /** Erro do servidor: diálogo `verify_fail` + texto no campo de erro. Original: j(String, String) */
    override fun showError(msg: String, sub: String) {
        loading?.dismiss()
        val d = RemindAlertDialog(requireActivity(), object : RemindAlertDialog.Listener {
            override fun a() {}
            override fun b() { tvError!!.text = ""; tvVerify!!.isClickable = true; tvVerify!!.text = CommonUtils.string(R.string.send_code); timer?.cancel() }
        })
        d.setTitle(CommonUtils.string(R.string.verify_fail)); d.setMessage(msg, CommonUtils.string(R.string.error_code) + sub); d.show()
        showFieldError("", msg)
    }

    // ---------------------------------------------------------------- helpers
    /** Original: k0(prefix, message) — "N:msg" → "msg(N)". */
    private fun showFieldError(prefix: String, message: String?) {
        var m = if (TextUtils.isEmpty(message)) "" else message!!
        if (!TextUtils.isEmpty(message) && message!!.contains(":")) { val p = message.split(":"); if (p.size > 1) m = p[1] + "(" + p[0] + ")" }
        val text = String.format("%s%s", prefix, m)
        tvError!!.text = text; ToastUtils.showIfOffscreen(tvError, requireActivity(), text, 1)
    }
    private fun fieldError(resId: Int) { tvError!!.text = CommonUtils.string(resId); ToastUtils.showIfOffscreen(tvError, requireActivity(), CommonUtils.string(resId), 1) }

    /** Alterna e-mail/telefone e registra EditTexts no teclado (tags 6 e 7). Original: b0(boolean) */
    fun switchMode(phone: Boolean) {
        val kb = keyboard
        if (phone) {
            if (kb != null && kb.getTabTag() != 7) { kb.clearEditTexts(); kb.setTabTag(7); kb.addEditText(etPhone); kb.addEditText(etCode); kb.addEditText(etPwd) }
            tvRemind!!.text = Html.fromHtml(phoneRemind)
        } else {
            if (kb != null && kb.getTabTag() != 6) { kb.clearEditTexts(); kb.setTabTag(6); kb.addEditText(etEmail); kb.addEditText(etCode); kb.addEditText(etPwd) }
            tvRemind!!.text = Html.fromHtml(emailRemind)
        }
        etEmail!!.visibility = if (!phone) View.VISIBLE else View.GONE
        llPhone!!.visibility = if (phone) View.VISIBLE else View.GONE
    }

    /** Pré-preenche com a conta recebida. Original: e0(AccountBean) */
    private fun prefill(a: AccountBean?) {
        if (a == null) return
        if (AppConstants.flagG) {
            phoneInput!!.setAccount(a)
            if (TextUtils.isEmpty(a.accountName)) phoneInput!!.editText!!.requestFocus()
            phoneInput!!.selectCountry(a)
        } else {
            etEmail!!.setText(a.accountName)
            if (TextUtils.isEmpty(a.accountName)) { etEmail!!.requestFocus(); AnimUtils.d(etEmail) } else etEmail!!.setSelection(a.accountName!!.length)
        }
        if (!TextUtils.isEmpty(a.accountName)) tvVerify!!.requestFocus()
        switchMode(AppConstants.flagG)
    }

    /** Lê os argumentos (accountBean/onlyChange/hasPhoneFeature). Original: c0() */
    private fun readArguments() {
        val args = arguments ?: return
        val onlyChange = args.getBoolean("onlyChange")
        hasPhoneFeature = args.getBoolean("hasPhoneFeature")
        account = args.getSerializable("accountBean") as AccountBean?
        accountLocked = if (hasPhoneFeature) onlyChange else true
    }

    /** Textos remotos e estado dos campos. Original: l() */
    private fun refreshTexts() {
        tvTitle!!.text = Html.fromHtml(ContactTemplate.a("reset_account_title", getString(R.string.reset_account_title)))
        tvBelow!!.text = Html.fromHtml(ContactTemplate.a("reset_account_title_below", getString(R.string.reset_account_title_below)))
        emailRemind = ContactTemplate.a("RESET_REMIND", getString(R.string.reset_password_remind)) + " " + com.foxivid.baselib.heartbeat.HeartbeatManager.customerServiceEmail
        phoneRemind = ContactTemplate.a("reset_remind_phone", getString(R.string.reset_password_remind_phone))
        tvRemind!!.text = Html.fromHtml(emailRemind)
        readArguments()
        prefill(account)
        phoneInput!!.editText!!.isEnabled = !accountLocked; etEmail!!.isEnabled = !accountLocked
        applyTabState()
    }

    private fun applyTabState() {
        val tl = tabLayout
        if (tl == null || tl.tabCount <= 1) return
        llSwitch!!.visibility = View.VISIBLE
        tl.getTabAt(if (AppConstants.flagG) 1 else 0)!!.select()
        switchMode(AppConstants.flagG)
        if (AppConstants.flagG) { phoneInput!!.editText!!.requestFocus(); return }
        lastFocusedField = etEmail; etEmail!!.requestFocus(); AnimUtils.d(etEmail)
    }

    /** Pede o código. Original: onClick(tv_verify) */
    private fun requestCode() {
        var id = if (AppConstants.flagG) phoneInput!!.fullNumber() else etEmail!!.text.toString().trim()
        if (TextUtils.isEmpty(id)) { fieldError(R.string.email_empty); return }
        if (!(if (AppConstants.flagG) AccountValidators.isPhone(id, "") else AccountValidators.isEmail(id))) { fieldError(R.string.user_no_correct); return }
        loading?.show()
        val a = AccountBean()
        val type: Int
        if (AppConstants.flagG) {
            id = AccountValidators.normalizePhone(id)
            val c = phoneInput!!.selectedCountry()
            a.type = 1; a.accountName = phoneInput!!.number(); a.phonePreCode = c.preCode; a.countryCode = c.code; type = 1
        } else { a.type = 0; a.accountName = id; type = 0 }
        presenter?.requestVerifyCode(id, type, a)
        timer?.cancel()
        timer = object : CountDownTimer(120000L, 1000L) {
            override fun onFinish() { try { tvVerify!!.text = CommonUtils.string(R.string.send_code); tvVerify!!.isClickable = true } catch (_: Exception) {} }
            override fun onTick(ms: Long) { try { tvVerify!!.text = CommonUtils.string(R.string.send) + TimeUnit.MILLISECONDS.toSeconds(ms) + "s)" } catch (_: Exception) {} }
        }.also { it.start() }
        tvVerify!!.isClickable = false
    }

    /** Valida e dispara a redefinição. Original: l0() */
    private fun submit() {
        val country = phoneInput!!.selectedCountry()
        var id = if (AppConstants.flagG) phoneInput!!.fullNumber() else etEmail!!.text.toString().trim()
        if (TextUtils.isEmpty(id)) { fieldError(R.string.email_empty); return }
        if (!(if (AppConstants.flagG) AccountValidators.isPhone(id, "") else AccountValidators.isEmail(id))) { fieldError(R.string.user_no_correct); return }
        val code = etCode!!.text.toString().trim()
        if (TextUtils.isEmpty(code)) { showFieldError(CommonUtils.string(R.string.verification_code_empty), null); return }
        val pwd = etPwd!!.text.toString().trim()
        if (TextUtils.isEmpty(pwd)) { showFieldError(CommonUtils.string(R.string.pwd_empty), null); return }
        if (pwd.length < 6 || pwd.length > 16) { showFieldError(CommonUtils.string(R.string.pwd_length_error), null); return }
        loading?.show()
        val type: Int
        if (AppConstants.flagG) { id = AccountValidators.normalizePhone(id); type = 1 } else type = 0
        presenter?.resetPassword(code, id, pwd, type, country.preCode, country.code)
    }

    /** Volta (e5.j.a) cancelando timer e reabilitando campos. Original: i0() */
    fun goBackToLogin() {
        navigator?.back(this); timer?.cancel()
        phoneInput!!.editText!!.isEnabled = true; etEmail!!.isEnabled = true
        tvVerify!!.text = resources.getString(R.string.send_code); tvVerify!!.isClickable = true; tvError!!.text = ""
    }

    override fun handleBack(): Boolean {
        val kb = keyboard
        if (kb != null && kb.visibility == View.VISIBLE) { lastFocusedField?.onFocusChangeListener = this; kb.hideOrDismissPopup(); return true }
        val r = tvReturn
        if (r == null || r.visibility != View.VISIBLE) return LoginNavigator.dispatchBackPressed(this)
        goBackToLogin(); return true
    }

    private fun bindViews() {
        val v = root!!
        llSwitch = v.findViewById(R.id.resetpwd_lly_switch); tvTitle = v.findViewById(R.id.resetpwd_tv_title); tvBelow = v.findViewById(R.id.resetpwd_tv_redmind)
        tabLayout = v.findViewById(R.id.resetpwd_tab_layout); etEmail = v.findViewById(R.id.resetpwd_et_email); etPhone = v.findViewById(R.id.et_phonenumber)
        llPhone = v.findViewById(R.id.lly_phone); tvVerify = v.findViewById(R.id.tv_verify); etCode = v.findViewById(R.id.resetpwd_et_verify_code); etPwd = v.findViewById(R.id.et_pwd)
        tvSubmit = v.findViewById(R.id.resetpwd_tv_submit); tvReturn = v.findViewById(R.id.resetpwd_tv_return); tvRemind = v.findViewById(R.id.resetpwd_tv_remind)
        tvError = v.findViewById(R.id.resetpwd_tv_error)
        v.findViewById<ImageView>(R.id.resetpwd_iv_title).apply { setImageDrawable(ResourcesCompat.getDrawable(resources, AppConfig.launcherIcon, null)); visibility = View.VISIBLE }
        loading = com.live.evo.widget.sloading.SLoadingDialog(requireContext()).setStyle(com.live.evo.widget.sloading.LoadingStyle.TRANSLATE_CIRCLE).setColor(android.graphics.Color.BLACK)
        TextStyleUtils.b(tvRemind); TextStyleUtils.c(etEmail); TextStyleUtils.c(tvVerify); TextStyleUtils.c(etCode); TextStyleUtils.d(tvSubmit); TextStyleUtils.d(tvReturn)
        keyboard?.let { it.addEditText(etEmail); it.addEditText(etCode); it.addEditText(etPwd); it.setTabTag(6) }
        phoneInput = PhoneInputHelper(requireContext(), v)
        etEmail!!.setDomains(AppUserManager.get().getString("email_domains", "gmail.com,hotmail.com,outlook.com,yahoo.com,yahoo.com.br"), false)
    }

    private fun bindListeners() {
        for (c in listOf<View?>(tvVerify, tvSubmit, tvReturn)) c?.setOnClickListener(this)
        for (f in listOf<View?>(etEmail, tvVerify, etCode, etPwd, tvSubmit, tvReturn)) f?.onFocusChangeListener = this
        etEmail!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {
                tvError!!.text = ""
                if (timer != null) { timer!!.cancel(); tvVerify!!.text = CommonUtils.string(R.string.send_code); tvVerify!!.isClickable = true }
            }
            override fun afterTextChanged(e: Editable?) {}
            override fun onTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
        })
        etPwd!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) { tvError!!.text = "" }
            override fun afterTextChanged(e: Editable?) {}
            override fun onTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
        })
        tvError!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(e: Editable?) { tvError!!.visibility = if (TextUtils.isEmpty(e)) View.INVISIBLE else View.VISIBLE }
            override fun beforeTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
            override fun onTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
        })
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) { tvError!!.text = ""; val phone = tab.position > 0; AppConstants.flagG = phone; switchMode(phone) }
            override fun onTabReselected(tab: TabLayout.Tab) {}
            override fun onTabUnselected(tab: TabLayout.Tab) {}
        })
        val strip = tabLayout!!.getChildAt(0) as? ViewGroup
        if (tabLayout!!.tabCount >= 2 && strip != null && strip.childCount >= 2) {
            for (i in 0..1) strip.getChildAt(i)?.setOnFocusChangeListener { v, hasFocus ->
                if (hasFocus && v != null) { tabLayout!!.getTabAt(i)!!.select(); switchMode(i > 0) }
            }
            if (LoginConfig.get().intE() == 1) {
                val keys = View.OnKeyListener { view, keyCode, event ->
                    val kb = keyboard
                    val field = view.id == R.id.et_phonenumber || view.id == R.id.et_pwd || view.id == R.id.resetpwd_et_email || view.id == R.id.resetpwd_et_verify_code
                    val ok = keyCode == 23 || keyCode == 66
                    if (event.action == KeyEvent.ACTION_DOWN && keyCode == 19) {
                        if (kb == null || kb.visibility != View.VISIBLE) {
                            if (view.id != R.id.et_phonenumber) {
                                if (view.id == R.id.resetpwd_et_email) { if (llSwitch!!.visibility != View.VISIBLE) return@OnKeyListener true; tabLayout!!.getTabAt(0)!!.select(); strip.getChildAt(0).requestFocus(); return@OnKeyListener true }
                            } else { if (llSwitch!!.visibility != View.VISIBLE) return@OnKeyListener true; tabLayout!!.requestFocus(); tabLayout!!.getTabAt(1)!!.select(); strip.getChildAt(1).requestFocus(); return@OnKeyListener true }
                        }
                        false
                    } else if (kb != null && event.action == KeyEvent.ACTION_DOWN && ok) { if (field) { kb.toggle(); if (view.id != R.id.et_phonenumber) lastFocusedField = view; true } else false }
                    else if (kb != null && event.action == KeyEvent.ACTION_UP && ok) field
                    else if (kb != null && event.action == KeyEvent.ACTION_UP && (keyCode == 4 || keyCode == 111) && field) {
                        lastFocusedField?.onFocusChangeListener = this
                        if (kb.visibility == View.VISIBLE) { kb.hideOrDismissPopup(); true } else false
                    } else false
                }
                for (v in listOf<View?>(etEmail, etPhone, etCode, etPwd, phoneInput!!.spinner, phoneInput!!.editText)) v?.setOnKeyListener(keys)
            }
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.resetpwd_tv_return -> goBackToLogin()
            R.id.resetpwd_tv_submit -> submit()
            R.id.tv_verify -> requestCode()
        }
    }
    override fun onFocusChange(v: View, hasFocus: Boolean) { if (hasFocus) AnimUtils.d(v) else AnimUtils.g(v) }

    override fun onAttach(context: android.content.Context) { super.onAttach(context); readArguments() }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        root = inflater.inflate(R.layout.reset_account_password, container, false)
        keyboard = com.foxivid.ui.keyboard.KeyUtils.create(window, requireContext(), root, lifecycle, false)
        presenter = ResetPasswordPresenter().also { it.attach(this) }
        networkTester = NetworkStatusDialogFragment.createTester(requireActivity())
        bindViews(); refreshTexts(); bindListeners()
        return root!!
    }
    override fun onResume() { super.onResume(); presenter?.attach(this) }
    override fun onPause() { presenter?.detach(); super.onPause() }
    override fun onStop() { super.onStop(); timer?.let { it.cancel(); tvVerify!!.isClickable = true; tvVerify!!.text = CommonUtils.string(R.string.send_code) } }
    override fun onDestroy() { super.onDestroy(); instance = null }

    private val navigator: LoginNavigator.FragmentNavigator? get() = staticNavigator

    companion object {
        private const val TAG = "ResetAccountPasswordFragment"
        private var instance: ResetAccountPasswordFragment? = null
        private var staticNavigator: LoginNavigator.FragmentNavigator? = null   // H
        private fun get(): ResetAccountPasswordFragment = instance ?: ResetAccountPasswordFragment().also { instance = it }
        /** Original: j0(FragmentManager, Window, int container, AccountBean, boolean onlyChange, e5.j) */
        @Synchronized fun show(fm: FragmentManager, window: Window, containerId: Int, account: AccountBean?, onlyChange: Boolean, nav: LoginNavigator.FragmentNavigator) {
            val f = get()
            staticNavigator = nav
            f.arguments = Bundle().apply {
                putBoolean("hasPhoneFeature", AppUserManager.get().getBoolean("contain_phone_account", true))
                putSerializable("accountBean", account); putBoolean("onlyChange", onlyChange)
            }
            f.window = window
            val existing = fm.findFragmentByTag(TAG)
            val tx = fm.beginTransaction()
            if (existing == null) tx.add(containerId, f, TAG).commitAllowingStateLoss()
            else { f.refreshTexts(); tx.show(existing).commitAllowingStateLoss() }
        }
    }
}
