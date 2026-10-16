package com.live.evo.fragment.login

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.text.Editable
import android.text.Html
import android.text.TextUtils
import android.text.TextWatcher
import com.foxivid.baselib.config.BaseLibConfig
import com.live.evo.dialog.RemindAlertDialog
import com.live.evo.AppUserManager
import com.foxivid.baselib.util.ToastUtils
import com.live.evo.util.AccountValidators
import com.live.evo.util.AnimUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.live.evo.util.AppPropertiesStore
import com.live.evo.util.ContactTemplate
import com.live.evo.util.GlideImageLoader
import com.live.evo.util.ModelHelper
import com.live.evo.util.TextStyleUtils
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.foxivid.baselib.heartbeat.HeartbeatManager
import com.foxivid.baselib.user.UserManager
import com.foxivid.baselib.util.Preferences
import com.live.evo.fragment.OnTabEventListener
import com.live.evo.model.AccountBean
import com.live.evo.util.CommonUtils
import com.live.evo.util.ServerClock
import com.live.evo.AppConstants
import com.live.evo.R
import com.live.evo.fragment.BaseFragment
import com.live.evo.fragment.TabFunctionRechargeFragment
import com.live.evo.fragment.login.presenter.*
import com.live.evo.osd.OsdControlListener
import com.live.evo.util.DateUtils
import org.slf4j.LoggerFactory

/**
 * Diálogo de tela cheia que HOSPEDA todo o fluxo de recarga/login dentro da live (childFragmentManager,
 * container `rechargedlg_rl_parent`). O `type` recebido em [show] escolhe a tela inicial (método `l()`):
 *
 * | type | tela inicial |
 * |---|---|
 * | 21 | [RechargeMiniFragment] se não há username (`UserManager.getUsername()` = InteractionUtils.Z() vazio), senão [LoginFinishMiniFragment] |
 * | 22 | login por conta ([LoginNavigator.showAccountLogin], aba 0, com botão voltar) |
 * | 23 | [RechargeMiniFragment] |
 * | 24 | lembrete de expiração calculado (`n0()`): compara validade (I = `UserManager.getExpireTs`) com agora e janela de aviso (U = `HeartbeatManager`); tipos -1 (nada → `listener.e()`), 5, 4 ou 1 (+ "N hour(s)"); usa a flag estática [showing] para não reabrir |
 * | 25 | [CheckAccountFragment] |
 * | 26 | [BindAccountTipFragment] (só se `AppConstants.flagH` é falso; senão dismiss) |
 * | 40/41/42 | [RenewCodeLoginSupportFragment] com o renew code (`UserManager.getCode()` = InteractionUtils.r()) |
 * | 49 | [LoginFinishMiniFragment] |
 * | 50/51 | [BffInfoFragment] |
 * | 52 | `l0()` — corpo vazio no original |
 * | 53 | [ShareCodeInfoFragment] |
 * | 54 | [TabFunctionRechargeFragment] (l3.INSTANCE.f) |
 *
 * Back: `KeyUtils.j()` (long-press) é engolido; se não cancelável mostra [ExitDialog]; senão [LoginNavigator.dispatchBackPressed]
 * ou dismiss + `listener.a()`. `cancelable` (flag `f6227g`) padrão = `validade > agora`. Marca [showing] = false ao fechar.
 * Se a activity é `LiveNewActivity`, avisa `T3(true/false)` (fluxo em andamento).
 * Janela sem moldura, fundo transparente, SOFT_INPUT 32.
 *
 * Original: com/live/evo/fragment/login/j.java (nome real RechargeDialogFragment)
 */
class RechargeDialogFragment : DialogFragment(), DialogInterface.OnKeyListener {
    private var listener: OsdControlListener? = null
    private var type = -1
    private var cancelableFlag: Boolean? = null
    private var root: View? = null
    private lateinit var parent: RelativeLayout
    private var exitDialog: com.live.evo.dialog.ExitDialog? = null
    private var keyLongPressHandled = false

    private fun childFm(): FragmentManager = childFragmentManager
    private fun win(): Window = dialog!!.window!!
    /** `osd.a.c()` — só existe na variante estendida. */
    private fun listenerExtra() { (listener as? com.live.evo.osd.OsdControlListenerEx)?.onExtra() }
    private fun hide(f: Fragment?) { if (f != null) childFm().beginTransaction().hide(f).commitAllowingStateLoss() }

    /** Original: d0() — padrão: ainda há validade. */
    private fun isDlgCancelable(): Boolean = cancelableFlag ?: (UserManager.getExpireTs() > ServerClock.get().now())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        dialog!!.requestWindowFeature(1)
        val w = win()
        w.setBackgroundDrawable(android.graphics.drawable.ColorDrawable(0))
        w.setSoftInputMode(32)
        w.decorView.setPadding(0, 0, 0, 0)
        w.attributes = w.attributes.also { it.width = -1; it.height = -1; it.gravity = 17 }
        val v = inflater.inflate(R.layout.recharge_dialog_fragment, container, false)
        root = v
        dialog!!.setOnKeyListener(this)
        (activity as? com.live.evo.activity.LiveNewActivity)?.isPopupLoginOrRenewFragment = true   // T3(true)
        parent = v.findViewById(R.id.rechargedlg_rl_parent)
        dispatchInitialScreen()
        return v
    }

    override fun onDismiss(dialog: DialogInterface) {
        (activity as? com.live.evo.activity.LiveNewActivity)?.isPopupLoginOrRenewFragment = false  // T3(false)
        super.onDismiss(dialog)
    }

    override fun onPause() { dismiss(); showing = false; super.onPause() }

    /** Escolhe a tela inicial pelo [type]. Original: l() */
    private fun dispatchInitialScreen() {
        isCancelable = isDlgCancelable()
        when (type) {
            24 -> reminderOrClose()
            21 -> if (UserManager.getUsername().isEmpty()) showAccountDefault() else showRechargeMini()
            22 -> showAccountLogin(true, 0, null)
            23 -> showRechargeMini()
            25 -> showCheckAccount(null)
            40, 41, 42 -> showRenewCodeLogin(type, UserManager.getCode())
            49 -> showLoginFinishMini()
            26 -> showBindAccountTip()
            50, 51 -> showBffInfo(type)
            52 -> {}                       // l0(): vazio
            53 -> showShareCode()
            54 -> showTabRecharge()
        }
    }

    /** Original: y0() → x0(null, 1, false, false, null) — cadastro por e-mail/telefone (tipo 1). */
    private fun showAccountDefault() = showRegister(null, 1, false, false, null)

    /** Original: n0() — decide o tipo de lembrete de expiração. */
    private fun reminderOrClose() {
        val warnWindow = HeartbeatManager.promptRenewMillis   // InteractionUtils.U() = heartbeat.q0()
        val expire = UserManager.getExpireTs()                            // I()
        val now = ServerClock.get().now()
        val isGuestNoPlan = UserManager.hasValidPlan() && !UserManager.isGuestOrLoggedOut() && UserManager.getUsername().isEmpty()  // a0() && !l0() && Z().isEmpty()
        val left = expire - now
        var remindType: Int
        var text = ""
        if (left > warnWindow && expire > now) {
            remindType = if (isGuestNoPlan) 5 else -1
        } else if (expire <= now || left > warnWindow) {
            remindType = 4
        } else {
            val hours = DateUtils.hoursBetween(now, expire)    // q1.j(jA, jI)
            text = hours.toString() + " " + CommonUtils.string(if (hours <= 1) R.string.hour else R.string.hours)
            remindType = 1
        }
        if (remindType == -1) { dismiss(); listener?.onDismiss(); return }
        if (showing) { dismiss(); return }
        showing = true
        showRemind(remindType, text)
    }

    /** Original: i0(type, text) — lembrete (e5.e.a(..., 31, l)). */
    private fun showRemind(remindType: Int, text: String) =
        LoginNavigator.showRechargeRemind(childFm(), win(), R.id.rechargedlg_rl_parent, remindType, text, 31, object : LoginNavigator.RechargeRemindCallback {
            override fun onSkip(f: Fragment) { showing = false; listener?.onNegative(); dismiss() }                    // a
            override fun onRechargeNow(f: Fragment) {                                                                  // b
                if (!AppConstants.flagH) { showing = false; hide(f); showScaned(f) }
                else { hide(f); listener?.onPositive() }
            }
            override fun onLogin(f: Fragment, showTab: Int) { showing = false; hide(f); showAccountLogin(true, showTab, f) }   // c
        })

    private fun showScaned(from: Fragment) =
        LoginNavigator.showScanedRecharge(childFm(), win(), R.id.rechargedlg_rl_parent, object : LoginNavigator.FragmentNavigator {
            override fun back(f: Fragment) { childFm().beginTransaction().show(from).hide(f).commitAllowingStateLoss() }   // k.a
            override fun next(f: Fragment) { showRegister(null, 0, false, false, null) }                                    // k.b → r0(0)
        })

    private fun showRechargeMini() = RechargeMiniFragment.show(childFm(), win(), R.id.rechargedlg_rl_parent, object : LoginNavigator.FragmentNavigator {
        override fun back(f: Fragment) {}
        override fun next(f: Fragment) { hide(f); showLoginFinishMini() }
    })

    private fun showLoginFinishMini() = LoginFinishMiniFragment.show(childFm(), R.id.rechargedlg_rl_parent) { f -> hide(f); dismiss(); listener?.onDismiss() }

    /** Original: r0(int) → h.X(...) (LoginFinishFragment); ao concluir: listener.e() + dismiss. */
    private fun showLoginFinish(remindType: Int) = LoginFinishFragment.show(childFm(), R.id.rechargedlg_rl_parent, remindType) { listener?.onDismiss(); dismiss() }

    private fun showBffInfo(t: Int) = BffInfoFragment.show(childFm(), R.id.rechargedlg_rl_parent, t) { f -> hide(f); dismiss() }
    private fun showShareCode() = ShareCodeInfoFragment.show(childFm(), R.id.rechargedlg_rl_parent) { f -> hide(f); dismiss() }
    private fun showTabRecharge() = TabFunctionRechargeFragment.show(childFm(), win(), R.id.rechargedlg_rl_parent, object : OnTabEventListener {
        override fun b() { dismissAllowingStateLoss() }
        override fun c() { dismissAllowingStateLoss() }
    })

    private fun showBindAccountTip() {
        if (AppConstants.flagH) { dismiss(); return }
        BindAccountTipFragment.show(childFm(), R.id.rechargedlg_rl_parent, object : BindAccountTipFragment.Listener {
            override fun a(f: Fragment, choice: Int) {
                if (choice == 0) { listenerExtra(); return }
                if (choice == 2) Preferences.putString("deviceuser_no_tip_bind", "true")
                hide(f); dismiss()
            }
        })
    }

    /** Original: t0(isBack, tab, from) / s0 → e5.b.a (login por conta). */
    private fun showAccountLogin(showBack: Boolean, tab: Int, from: Fragment?) {
        if (AppConstants.flagH) { dismiss(); return }
        LoginNavigator.showAccountLogin(childFm(), win(), R.id.rechargedlg_rl_parent, showBack, "", tab, object : LoginNavigator.AccountLoginCallback {
            override fun onBack(f: Fragment) { hide(f); if (from != null) childFm().beginTransaction().show(from).commitAllowingStateLoss() else dismiss() }
            override fun onLoginSuccess(f: Fragment) {
                if (UserManager.getCode().isNotEmpty() && UserManager.getUsername().isEmpty()) {
                    hide(f); showRenewCodeLogin(42, UserManager.getCode())
                } else { dismiss(); listenerExtra() }
            }
            override fun onRenewCodeLogin(f: Fragment) { hide(f); showRenewCodeLogin(40, UserManager.getCode()) }
            override fun onRegister(f: Fragment) { showRegister(f, if (!UserManager.isGuestOrLoggedOut()) 1 else 2, false, false, null) }   // d → x0(f, l0() ? 2 : 1 ...)
            override fun onResetPassword(f: Fragment, account: AccountBean) { showResetPassword(f, account) }
        })
    }

    /** Original: x0(from, type, flagA, flagB, account) → e5.g.a. */
    private fun showRegister(from: Fragment?, registerType: Int, flagA: Boolean, flagB: Boolean, account: AccountBean?) {
        hide(from)
        LoginNavigator.showRegister(childFm(), win(), R.id.rechargedlg_rl_parent, registerType, flagA, flagB, account, object : LoginNavigator.FragmentNavigator {
            override fun back(f: Fragment) {
                if (from == null) { dismiss(); return }
                childFm().beginTransaction().hide(f).show(from).commitAllowingStateLoss()
                (from as? CheckAccountFragment)?.onShownAgain()
            }
            override fun next(f: Fragment) {
                hide(f)
                if (registerType != 3) { showLoginFinish(3) }
                else { hide(from); showLoginFinish(8) }
            }
        })
    }

    /** Original: B0(from, account) → e5.i.a. */
    private fun showResetPassword(from: Fragment?, account: AccountBean?) {
        hide(from)
        LoginNavigator.showResetPassword(childFm(), win(), R.id.rechargedlg_rl_parent, account, false, object : LoginNavigator.FragmentNavigator {
            override fun back(f: Fragment) { hide(f); showAccountLogin(false, 0, null) }
            override fun next(f: Fragment) { hide(f); showLoginFinish(6) }
        })
    }

    /** Original: q0(from) → g.g0(Z(), window, fm, container, d) */
    private fun showCheckAccount(from: Fragment?) =
        CheckAccountFragment.show(UserManager.getUsername(), win(), childFm(), R.id.rechargedlg_rl_parent, object : CheckAccountFragment.Listener {
            override fun a(f: Fragment) {
                if (from != null) childFm().beginTransaction().hide(f).show(from).commitAllowingStateLoss()
                else { childFm().beginTransaction().remove(f).commitAllowingStateLoss(); dismiss() }
            }
        })

    /** Original: A0(type, code) → r.b0(...). Callbacks de [RenewCodeLoginSupportFragment.Listener] = r.c (a, b, c). */
    private fun showRenewCodeLogin(t: Int, code: String) =
        RenewCodeLoginSupportFragment.show(childFm(), R.id.rechargedlg_rl_parent, code, t, object : RenewCodeLoginSupportFragment.Listener {
            override fun exit(f: Fragment) { hide(f); showAccountLogin(false, 3, null) }          // C0079j.a
            override fun bindNow(f: Fragment) { showCheckAccount(f) }                              // C0079j.b → q0(f)
            override fun loginSuccess(f: Fragment) { dismiss(); listenerExtra() }                    // C0079j.c
        })

    override fun onKey(d: DialogInterface?, keyCode: Int, event: KeyEvent): Boolean {
        if (event.action == KeyEvent.ACTION_DOWN && (keyCode == 4 || keyCode == 111)) {
            if (event.repeatCount > 0) { keyLongPressHandled = true; return true }       // KeyUtils.j() (inferido: tecla repetida)
        } else if (event.action == KeyEvent.ACTION_UP && (keyCode == 4 || keyCode == 111) && keyLongPressHandled) {
            keyLongPressHandled = false; return false
        }
        if (keyCode != 4 && keyCode != 111) return false
        if (!isCancelable) {
            if (exitDialog == null) exitDialog = com.live.evo.dialog.ExitDialog(requireActivity()).also {
                it.setOnExitListener { listener?.onPositive(); showing = false }
            }
            exitDialog!!.show()
        } else {
            showing = false
            if (event.action == KeyEvent.ACTION_DOWN) {
                if (!LoginNavigator.dispatchBackPressed(this)) dismiss()
                listener?.onPositive()
            }
        }
        return true
    }

    companion object {
        /** Evita abrir dois lembretes de recarga. Original: j.f6220j */
        @JvmField var showing = false
        private var current: RechargeDialogFragment? = null

        /** Original: e0() — fecha a instância anterior e cria outra. */
        private fun newInstance(): RechargeDialogFragment {
            current?.let { if (it.dialog != null && it.dialog!!.isShowing) it.dismiss() }
            return RechargeDialogFragment().also { current = it }
        }
        /** Original: g0(FragmentManager, int, osd.a) → h0(fm, type, true, l) */
        fun show(fm: FragmentManager?, type: Int, l: OsdControlListener?) = show(fm, type, true, l)
        /** Original: h0(FragmentManager, int, Boolean, osd.a) — tag "recharge" */
        fun show(fm: FragmentManager?, type: Int, cancelable: Boolean?, l: OsdControlListener?) {
            try {
                val f = newInstance().also { it.listener = l; it.type = type; it.cancelableFlag = cancelable }
                val d: Dialog? = f.dialog
                if (d != null && !d.isShowing) d.show() else if (d == null) f.show(fm!!, "recharge")
            } catch (e: Exception) { LoggerFactory.getLogger(RechargeDialogFragment::class.java).error(e.message, e) }
        }
    }
}

/**
 * Recarga "mini" (layout `recharge_mini_fragment`): digitar renew code (`rechargeminif_ret_cardnum`) e confirmar
 * (`rechargeminif_tv_confirm`, só habilitado com >= 19 caracteres). Singleton reutilizado (campo estático `o`), tag "RechargeMiniFragment".
 * Presenter [RechargeMiniPresenter]; mostra username (`UserManager.getUsername()`), QR oculto, texto de ajuda conforme
 * `displayMemberSite` (como renovar vs. como comprar) com `${MS}`/`${RS}` = URL do site de membros e `${CS}` = e-mail de suporte.
 * Nota: no original `onClick` do botão confirmar só lê o texto (`getText().toString().getClass()`) — a chamada ao presenter
 * foi removida do binário; reproduzido como no-op. Erro → [RemindAlertDialog] com título `recharge_fail`. Sucesso → `nav.next` (k.b).
 * Teclado virtual de TV via [KeyUtils.create]; ENTER/OK no campo alterna o teclado, BACK o fecha.
 * Original: com/live/evo/fragment/login/l.java (Y = show)
 */
class RechargeMiniFragment : BaseFragment(), RechargeMiniView, View.OnClickListener, View.OnFocusChangeListener {
    private var root: View? = null
    private var tvRemind: TextView? = null
    private var tvConfirm: TextView? = null
    private var tvUsername: TextView? = null
    private var etCardNum: EditText? = null
    private var tvRemindBottom: TextView? = null
    private var tvHowTo: TextView? = null
    private var tvRemindHint: TextView? = null
    private var ivQr: ImageView? = null
    private var presenter: RechargeMiniPresenter? = null
    private var nav: LoginNavigator.FragmentNavigator? = null
    private var loading: com.live.evo.widget.sloading.SLoadingDialog? = null
    private var keyboard: com.foxivid.ui.keyboard.KeyboardContainer? = null
    private var window: Window? = null

    override fun setPresenter(presenter: Any?) {}

    private fun bindViews() {
        val v = root!!
        tvRemind = v.findViewById(R.id.rechargeminif_tv_remind)
        tvConfirm = v.findViewById(R.id.rechargeminif_tv_confirm)
        tvUsername = v.findViewById(R.id.rechargeminif_tv_username)
        etCardNum = v.findViewById(R.id.rechargeminif_ret_cardnum)
        tvRemindBottom = v.findViewById(R.id.rechargeminif_tv_remind_bottom)
        tvHowTo = v.findViewById(R.id.rechargeminif_tv_how_to_recharge)
        tvRemindHint = v.findViewById(R.id.rechargeminif_tv_remind_hint)
        ivQr = v.findViewById(R.id.rechargeminif_iv_qr_membersite)
        loading = com.live.evo.widget.sloading.SLoadingDialog(requireActivity()).setStyle(com.live.evo.widget.sloading.LoadingStyle.TRANSLATE_CIRCLE).setColor(R.color.sloading_color)
        TextStyleUtils.b(tvRemind); TextStyleUtils.d(tvConfirm); TextStyleUtils.b(tvUsername)
        TextStyleUtils.d(etCardNum); TextStyleUtils.b(tvRemindBottom); TextStyleUtils.b(tvHowTo)
        keyboard?.addEditText(etCardNum)
    }

    private fun bindListeners() {
        tvConfirm!!.onFocusChangeListener = this
        tvConfirm!!.setOnClickListener(this)
        tvHowTo!!.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) AnimUtils.h(tvRemindBottom) else { AnimUtils.i(tvRemindBottom); tvRemindBottom!!.visibility = View.VISIBLE }
        }
        etCardNum!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(e: Editable?) {
                val et = etCardNum!!; val ok = !TextUtils.isEmpty(e) && e!!.length >= 19
                if (ok) { et.background = CommonUtils.drawable(R.drawable.recharge_mini_full); et.setTextColor(CommonUtils.color(R.color.recharge_fill_text_color)) }
                else { et.setTextColor(CommonUtils.color(R.color.text_color_et_selector_focus)); et.background = CommonUtils.drawable(R.drawable.load_et_selector) }
                tvConfirm!!.isEnabled = ok; tvConfirm!!.isFocusable = ok
            }
            override fun beforeTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
            override fun onTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
        })
        etCardNum!!.setOnKeyListener { view, keyCode, event ->
            val kb = keyboard
            val okKey = keyCode == 23 || keyCode == 66
            when {
                kb != null && event.action == KeyEvent.ACTION_DOWN && okKey -> { if (view.id != R.id.rechargeminif_ret_cardnum) false else { kb.toggle(); true } }
                kb != null && event.action == KeyEvent.ACTION_UP && okKey -> view.id == R.id.rechargeminif_ret_cardnum
                kb == null || event.action != KeyEvent.ACTION_UP -> false
                (keyCode != 4 && keyCode != 111) || view.id != R.id.rechargeminif_ret_cardnum || kb.visibility != View.VISIBLE -> false
                else -> { kb.hideOrDismissPopup(); true }
            }
        }
    }

    /** Textos de ajuda conforme `displayMemberSite`. Original: l() */
    private fun refreshTexts() {
        val u = UserManager
        val memberSite = u.getMembershipUrl()   // InteractionUtils.N() = f.t0()
        val support = HeartbeatManager.customerServiceEmail   // InteractionUtils.v()
        val howTo: String
        val guide: String
        if (BaseLibConfig.displayMemberSite) {
            howTo = CommonUtils.string(R.string.how_to_renew); guide = CommonUtils.string(R.string.recharge_guide)
        } else {
            howTo = CommonUtils.string(R.string.how_to_buy_play); guide = CommonUtils.string(R.string.payment_guide_rechargecode)
        }
        tvRemindHint!!.text = Html.fromHtml(howTo)
        tvRemind!!.text = Html.fromHtml(CommonUtils.string(R.string.recharge_code_remind))
        tvRemindBottom!!.text = Html.fromHtml(guide.replace("\${MS}", memberSite).replace("\${RS}", memberSite).replace("\${CS}", support))
        tvHowTo!!.text = Html.fromHtml(howTo)
        presenter?.loadRenewCode()
        tvUsername!!.text = UserManager.getUsername()
        ivQr!!.visibility = View.INVISIBLE
    }

    override fun hideLoading() { loading?.dismiss() }
    override fun showLoading() { loading?.show() }
    /** Sucesso: limpa o campo e avança (k.b). Original: e() */
    override fun onLoginSuccess() { etCardNum?.setText(""); nav?.next(this) }
    /** Original: i(msg, code) — dialog de falha; ao fechar devolve o foco ao campo. */
    override fun showError(msg: String, sub: String) {
        val d = RemindAlertDialog(requireActivity(), object : RemindAlertDialog.Listener {
            override fun a() {}
            override fun b() { etCardNum?.requestFocus(); etCardNum?.setSelection(etCardNum?.text?.length ?: 0) }
        })
        d.setTitle(CommonUtils.string(R.string.recharge_fail))
        d.setMessage(msg, if (TextUtils.isEmpty(sub)) "" else CommonUtils.string(R.string.error_code) + sub)
        d.show()
    }
    /** Original: n(String) */
    override fun onRenewCode(code: String) { tvUsername?.text = code }

    override fun onClick(v: View) {
        if (v.id == R.id.rechargeminif_tv_confirm && tvConfirm!!.isEnabled) { etCardNum!!.text.toString() }   // no-op no original (ver KDoc)
    }
    override fun onFocusChange(v: View, hasFocus: Boolean) { if (hasFocus) AnimUtils.d(v) else AnimUtils.g(v) }
    override fun onDestroy() { presenter?.detach(); super.onDestroy() }
    override fun onStop() { etCardNum?.setText(""); super.onStop() }
    override fun onResume() { super.onResume(); refreshTexts() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.recharge_mini_fragment, container, false)
        root = v
        keyboard = com.foxivid.ui.keyboard.KeyUtils.create(window, requireContext(), v, lifecycle, false)
        presenter = RechargeMiniPresenter().also { it.attach(this) }
        bindViews(); refreshTexts(); bindListeners()
        return v
    }

    companion object {
        private var instance: RechargeMiniFragment? = null
        /** Original: X() */
        private fun get(): RechargeMiniFragment = instance ?: RechargeMiniFragment().also { instance = it }
        /** Original: Y(FragmentManager, Window, int, k) */
        @Synchronized fun show(fm: FragmentManager, window: Window, containerId: Int, nav: LoginNavigator.FragmentNavigator) {
            val f = get().also { it.nav = nav; it.window = window }
            val existing = fm.findFragmentByTag("RechargeMiniFragment")
            val tx = fm.beginTransaction()
            if (existing == null) tx.add(containerId, f, "RechargeMiniFragment").commitAllowingStateLoss()
            else tx.show(existing).commitAllowingStateLoss()
        }
    }
}

/**
 * Lembrete de recarga/expiração (layout `recharge_remind_fragment`; tag "RechargeRemindFragment"). Texto depende do tipo
 * (arg 1 = perto de expirar; 2/4/10 = expirou) e do modo de conta `iQ` ([ModelHelper.welcomeMode]) e de
 * `UserManager.isGuestOrFree`-like `K0()` (aqui: [hasUsername], `f0()` = username não vazio):
 * 1 = trial → botão `input_renewal_code`, texto `remind_expired_by_trial`/`trial_near_expired_remind`; 3 = renew code →
 * `remind_expired_by_renewcode`/`renew_code_near_expired_remind`; 0 = MAC → `remind_expired_mac`; demais → `remind_expired` /
 * `normal_near_expired_remind`. Os textos vêm de propriedades remotas via [ContactTemplate.a] (com fallback em strings locais).
 * Botões: agora (`now`), depois (`later`), registrar depois, "how to recharge" (`onLogin(this, 1)`). Mostra QR do site de
 * membros se a propriedade `member_qr_display` (padrão false) e há bitmap. `${ValidTime}` = [expiryDuration].
 * Cliques: later/register_later → `onSkip`; now → modo 3 e validade passou → `onLogin(this, 3)`; senão `onRechargeNow`.
 * Original: com/live/evo/fragment/login/m.java (T = newInstance, U = show)
 */
class RechargeRemindFragment : BaseFragment(), View.OnClickListener, View.OnFocusChangeListener {
    private var cb: LoginNavigator.RechargeRemindCallback? = null
    private var root: View? = null
    private var tvRemind: TextView? = null
    private var tvNow: TextView? = null
    private var tvLater: TextView? = null
    private var tvBottom: TextView? = null
    private var tvHowTo: TextView? = null
    private var tvRegisterLater: TextView? = null
    private var tvHint: TextView? = null
    private var ivQr: ImageView? = null

    override fun onDestroy() { instance = null; super.onDestroy() }

    private fun bindViews() {
        val v = root!!
        tvRemind = v.findViewById(R.id.rechargeremindf_tv_remind)
        tvNow = v.findViewById(R.id.rechargeremindf_tv_now)
        tvLater = v.findViewById(R.id.rechargeremindf_tv_later)
        tvBottom = v.findViewById(R.id.rechargeremindf_tv_remind_bottom)
        tvHowTo = v.findViewById(R.id.rechargeremindf_tv_how_to_recharge)
        tvRegisterLater = v.findViewById(R.id.rechargeremindf_tv_register_later)
        tvHint = v.findViewById(R.id.rechargeremindf_ltv_remind_hint)
        ivQr = v.findViewById(R.id.iv_qr_membersite)
        TextStyleUtils.c(tvRemind); TextStyleUtils.b(tvBottom); TextStyleUtils.b(tvHint); TextStyleUtils.d(tvNow); TextStyleUtils.d(tvLater)
        tvNow!!.requestFocus()
    }
    private fun bindListeners() {
        tvNow!!.setOnClickListener(this); tvLater!!.setOnClickListener(this)
        tvLater!!.onFocusChangeListener = this; tvNow!!.onFocusChangeListener = this
        tvHowTo!!.setOnClickListener(this); tvRegisterLater!!.setOnClickListener(this)
    }

    override fun onFocusChange(v: View, hasFocus: Boolean) { if (hasFocus) AnimUtils.d(v) else AnimUtils.g(v) }

    /** Original: V() */ private fun skip() { cb?.onSkip(this) }

    /** Botão principal. Original: W() */
    private fun onNowClicked() {
        val mode = AppUserManager.get().welcomeMode()
        val c = cb ?: return
        if (mode == 1) { c.onRechargeNow(this); return }
        if (mode == 3) {
            if (AppUserManager.get().expiryTime() < DateUtils.now()) { AppUserManager.get().setLoggedIn(false); c.onLogin(this, 3) }
            else c.onSkip(this)
            return
        }
        c.onRechargeNow(this)
    }

    /** Preenche textos/botões conforme tipo e modo. Original: l() */
    private fun refresh() {
        tvHint!!.text = Html.fromHtml(ContactTemplate.a("how_to_new_title", CommonUtils.string(R.string.how_to_renew)))
        var message = ""
        val remindType: Int; val validTime: String
        if (arguments == null) { remindType = 1; validTime = "" }
        else { remindType = arguments!!.getInt(ARG_TYPE); validTime = arguments!!.getString(ARG_EXPIRY) ?: "" }
        val hasUser = UserManager.getUsername().isNotEmpty()      // InteractionUtils.f0 = f.K0
        val mode = AppUserManager.get().welcomeMode()
        if (remindType != 1) {
            if (remindType == 2 || remindType == 4 || remindType == 10) {
                tvNow!!.visibility = View.VISIBLE
                if (mode == 1 && hasUser) { tvNow!!.text = CommonUtils.string(R.string.input_renewal_code); message = ContactTemplate.a("remind_expired_by_trial", CommonUtils.string(R.string.remind_expired_by_trial)) }
                else if (mode == 3 && hasUser) { message = ContactTemplate.a("remind_expired_by_renewcode", CommonUtils.string(R.string.remind_expired_by_renew_code)); tvNow!!.text = CommonUtils.string(R.string.login) }
                else if (mode == 0 && hasUser) { tvNow!!.text = CommonUtils.string(R.string.recharge_now); message = ContactTemplate.a("remind_expired_mac", CommonUtils.string(R.string.remind_expired_mac)) }
                else if (hasUser) { tvNow!!.text = CommonUtils.string(R.string.recharge_now); message = ContactTemplate.a("remind_expired", CommonUtils.string(R.string.remind_expired)) }
                else { tvNow!!.visibility = View.GONE; tvRegisterLater!!.visibility = View.VISIBLE }
                tvLater!!.visibility = View.GONE
            }
        } else if (mode == 3 && hasUser) {
            message = ContactTemplate.a("renew_code_near_expired_remind", CommonUtils.string(R.string.recharge_remind_in_time_by_renew_code))
            tvNow!!.text = CommonUtils.string(R.string.ok); tvLater!!.visibility = View.GONE; tvNow!!.visibility = View.VISIBLE
        } else if (mode == 1 && hasUser) {
            message = ContactTemplate.a("trial_near_expired_remind", CommonUtils.string(R.string.recharge_remind_in_time_by_trial))
            tvNow!!.text = CommonUtils.string(R.string.input_renewal_code); tvNow!!.visibility = View.VISIBLE
            tvLater!!.visibility = View.VISIBLE; tvLater!!.text = CommonUtils.string(R.string.skip)
        } else if (hasUser) {
            message = ContactTemplate.a("normal_near_expired_remind", CommonUtils.string(R.string.recharge_remind_in_time))
            tvNow!!.text = CommonUtils.string(R.string.recharge_now); tvNow!!.visibility = View.VISIBLE
            tvLater!!.visibility = View.VISIBLE; tvLater!!.text = CommonUtils.string(R.string.recharge_later)
        } else { tvNow!!.visibility = View.GONE; tvRegisterLater!!.visibility = View.VISIBLE }
        if (mode == 0) tvNow!!.visibility = View.GONE
        if (mode == -2 || mode == 2 || mode == 6) tvHowTo!!.visibility = View.GONE
        tvRemind!!.text = Html.fromHtml(message.replace("\${ValidTime}", validTime))
        val site = UserManager.getMembershipUrl()
        val guide = if (site.isNotEmpty() && BaseLibConfig.displayMemberSite)
            ContactTemplate.a("recharge_guide", CommonUtils.string(R.string.recharge_guide)).replace("\${MS}", site).replace("\${RS}", site).replace("\${CS}", HeartbeatManager.customerServiceEmail)
        else ContactTemplate.a("recharge_guide", CommonUtils.string(R.string.renew_rehargecode_tip))
        tvBottom!!.text = Html.fromHtml(guide)
        tvHowTo!!.text = Html.fromHtml("<u>" + CommonUtils.string(R.string.to_login) + "</u>")
        if (AppUserManager.get().getBoolean("member_qr_display", false)) {
            ivQr!!.visibility = View.VISIBLE
            AppUserManager.get().qrBitmap(ModelHelper.membershipQrContent())?.let { GlideImageLoader.load(requireContext(), it, R.drawable.qr_placehodler, ivQr!!) }
        } else ivQr!!.visibility = View.INVISIBLE
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.rechargeremindf_tv_how_to_recharge -> cb?.let { AppUserManager.get().setLoggedIn(false); it.onLogin(this, 1) }
            R.id.rechargeremindf_tv_later -> skip()
            R.id.rechargeremindf_tv_now -> onNowClicked()
            R.id.rechargeremindf_tv_register_later -> skip()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        root = inflater.inflate(R.layout.recharge_remind_fragment, container, false)
        bindViews(); refresh(); bindListeners()
        return root!!
    }
    override fun onResume() { super.onResume(); refresh() }

    companion object {
        private const val ARG_TYPE = "arg_remind_type"
        private const val ARG_EXPIRY = "arg_expiry_duration"
        private var instance: RechargeRemindFragment? = null
        /** Original: T(int, String) */
        fun newInstance(type: Int, expiryDuration: String?): RechargeRemindFragment =
            RechargeRemindFragment().apply { arguments = Bundle().apply { putInt(ARG_TYPE, type); putString(ARG_EXPIRY, expiryDuration) } }.also { instance = it }
        /** Original: U(FragmentManager, int container, int type, String expiryDuration, e5.f) */
        @Synchronized fun show(fm: FragmentManager, containerId: Int, type: Int, expiryDuration: String?, cb: LoginNavigator.RechargeRemindCallback) {
            val f = newInstance(type, expiryDuration).also { it.cb = cb }
            val existing = fm.findFragmentByTag("RechargeRemindFragment")
            val tx = fm.beginTransaction()
            if (existing != null) tx.remove(existing)
            tx.add(containerId, f, "RechargeRemindFragment").commitAllowingStateLoss()
        }
    }
}

/**
 * Login por renew code (suporte): `type` 40/41/42. Layout `code_login_support_fragment` com três painéis:
 * - 40: "primeiro login com sucesso" (`code_first_login_success_parent`: `recharge_id`, `btn_bind`, `tv_watch_now`); grava
 *   `user_properties/code_bind_remind_status` = "0";
 * - 41: "confirmar código" (`code_confirm_*`: campo, OK, fechar; título `fill_out_key`). OK com campo vazio → erro `recharge_key_empty`;
 *   senão `presenter.n(context, renewCode, texto)` (presenter [CodeLoginPresenter], sem efeito);
 * - 42: "vincular" (`code_bind_*`: checkbox `code_bind_tip` que persiste `code_bind_remind_status`, bind now/later).
 * Erros "N:msg" são exibidos como `msg(N)` em `tv_error`. Listener = r.c: `a` = fechar (exit), `b` = bind/continuar, `c` = concluído
 * (login/recarga ok, mais tarde ou assistir agora; o `osd.a` interno `f6368y` também chama `c`).
 * Original: com/live/evo/fragment/login/r.java (b0 = show, Z = newInstance)
 */
class RenewCodeLoginSupportFragment : BaseFragment(), CodeLoginView, View.OnClickListener {
    /** Original: r.c — a = exit, b = bindNow, c = loginSuccess/watchNow. */
    interface Listener { fun exit(f: Fragment); fun bindNow(f: Fragment); fun loginSuccess(f: Fragment) }
    private val logger = org.slf4j.LoggerFactory.getLogger(RenewCodeLoginSupportFragment::class.java)
    private var listener: Listener? = null
    private var presenter: CodeLoginPresenterContract? = null
    private var loading: com.live.evo.widget.sloading.SLoadingDialog? = null
    private var root: View? = null
    private var firstLoginParent: View? = null
    private var tvRechargeId: TextView? = null
    private var tvFirstLoginRemind: TextView? = null
    private var btnBind: View? = null
    private var tvWatchNow: TextView? = null
    private var tvError: TextView? = null
    private var bindTitle: TextView? = null
    private var bindRemind: TextView? = null
    private var bindLater: TextView? = null
    private var bindNow: TextView? = null
    private var bindCheckbox: android.widget.CheckBox? = null
    private var bindParent: View? = null
    private var confirmParent: View? = null
    private var confirmTitle: TextView? = null
    private var confirmEt: android.widget.EditText? = null
    private var confirmOk: View? = null
    private var confirmClose: View? = null
    private var pendingError: String? = null

    override fun setPresenter(presenter: CodeLoginPresenterContract) { this.presenter = presenter }
    /** Original: b() — mostra o loading. */
    override fun b() { loading?.show() }

    private fun bindViews() {
        val v = root!!
        loading = com.live.evo.widget.sloading.SLoadingDialog(requireContext()).setStyle(com.live.evo.widget.sloading.LoadingStyle.TRANSLATE_CIRCLE).setColor(R.color.sloading_color)
        firstLoginParent = v.findViewById(R.id.code_first_login_success_parent)
        tvRechargeId = v.findViewById(R.id.recharge_id)
        tvFirstLoginRemind = v.findViewById(R.id.tv_first_login_success_remind)
        btnBind = v.findViewById(R.id.btn_bind)
        tvWatchNow = v.findViewById(R.id.tv_watch_now)
        tvError = v.findViewById(R.id.tv_error)
        tvWatchNow!!.paintFlags = android.graphics.Paint.UNDERLINE_TEXT_FLAG
        tvWatchNow!!.paint.isAntiAlias = true
        TextStyleUtils.b(tvFirstLoginRemind)
        bindTitle = v.findViewById(R.id.code_bind_title)
        bindRemind = v.findViewById(R.id.code_bind_remind)
        bindLater = v.findViewById(R.id.code_bind_later)
        bindNow = v.findViewById(R.id.code_bind_now)
        bindCheckbox = v.findViewById(R.id.code_bind_checkbox)
        bindParent = v.findViewById(R.id.code_bind_parent)
        confirmParent = v.findViewById(R.id.code_confirm_parent)
        confirmTitle = v.findViewById(R.id.code_confirm_title)
        confirmEt = v.findViewById(R.id.code_confirm_et)
        confirmOk = v.findViewById(R.id.code_confirm_ok)
        confirmClose = v.findViewById(R.id.code_confirm_close)
    }

    private fun bindListeners() {
        btnBind!!.setOnClickListener(this); tvWatchNow!!.setOnClickListener(this)
        bindNow!!.setOnClickListener(this); bindLater!!.setOnClickListener(this)
        confirmOk!!.setOnClickListener(this); confirmClose!!.setOnClickListener(this)
        bindCheckbox!!.setOnCheckedChangeListener { _, checked -> AppPropertiesStore.put("user_properties", "code_bind_remind_status", (if (checked) 1 else 0).toString()) }
        tvError!!.addTextChangedListener(object : android.text.TextWatcher {
            override fun afterTextChanged(e: android.text.Editable?) { tvError!!.visibility = if (android.text.TextUtils.isEmpty(e)) View.INVISIBLE else View.VISIBLE }
            override fun beforeTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
            override fun onTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
        })
    }

    /** Mostra erro pendente, se houver. Original: l() */
    private fun showPendingError() {
        tvError!!.visibility = View.INVISIBLE
        if (android.text.TextUtils.isEmpty(pendingError)) return
        tvError!!.visibility = View.VISIBLE
        tvError!!.text = pendingError
        pendingError = ""
    }

    /** Original: c0(String prefix, String msg) — "N:msg" → "msg(N)". */
    private fun showError(prefix: String, message: String) {
        var m = message
        if (m.isNotEmpty() && m.contains(":")) { val parts = m.split(":"); if (parts.size > 1) m = parts[1] + "(" + parts[0] + ")" }
        tvError!!.text = String.format("%s%s", prefix, m)
    }

    /** Escolhe o painel conforme `arg_remind_type`. Original: a0() */
    private fun showPanel() {
        when (arguments!!.getInt(ARG_TYPE)) {
            40 -> { AppPropertiesStore.put("user_properties", "code_bind_remind_status", "0"); showBindPanel() }
            41 -> {
                firstLoginParent!!.visibility = View.GONE; bindParent!!.visibility = View.GONE; confirmParent!!.visibility = View.VISIBLE
                confirmOk!!.requestFocus(); confirmTitle!!.text = Html.fromHtml(CommonUtils.string(R.string.fill_out_key))
            }
            42 -> showBindPanel()
        }
    }
    private fun showBindPanel() {
        firstLoginParent!!.visibility = View.GONE; bindParent!!.visibility = View.VISIBLE; confirmParent!!.visibility = View.GONE
        bindNow!!.requestFocus()
        bindRemind!!.text = Html.fromHtml(CommonUtils.string(R.string.code_bind_remind))
        val saved = AppPropertiesStore.get("user_properties", "code_bind_remind_status")
        bindCheckbox!!.isChecked = saved.isNotEmpty() && saved[0].value == "1"
        bindCheckbox!!.text = Html.fromHtml(CommonUtils.string(R.string.code_bind_tip))
        bindTitle!!.text = Html.fromHtml(CommonUtils.string(R.string.code_bind_title))
    }

    /** OK do painel de confirmação. Original: W() */
    private fun confirmCode() {
        val p = presenter ?: run { logger.error("RenewCodeLoginSupportPresenter is null"); return }
        val text = confirmEt!!.text.toString()
        if (android.text.TextUtils.isEmpty(text)) showError("", CommonUtils.string(R.string.recharge_key_empty))
        else p.n(requireContext(), arguments!!.getString(ARG_CODE) ?: "", text)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_bind, R.id.code_bind_now -> listener?.bindNow(this)
            R.id.code_bind_later, R.id.tv_watch_now -> listener?.loginSuccess(this)
            R.id.code_confirm_close -> listener?.exit(this)
            R.id.code_confirm_ok -> confirmCode()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        root = inflater.inflate(R.layout.code_login_support_fragment, container, false)
        presenter = CodeLoginPresenter()
        bindViews(); showPendingError(); bindListeners()
        return root!!
    }
    override fun onResume() { super.onResume(); presenter?.attach(this); showPanel() }
    override fun onPause() { presenter?.detach(); super.onPause() }
    override fun onDestroy() { super.onDestroy(); instance = null }

    companion object {
        private const val TAG = "RenewCodeLoginSupportFragment"
        private const val ARG_TYPE = "arg_remind_type"
        private const val ARG_CODE = "arg_renew_code"
        private var instance: RenewCodeLoginSupportFragment? = null
        /** Original: Z(int, String) */
        fun newInstance(type: Int, code: String): RenewCodeLoginSupportFragment =
            RenewCodeLoginSupportFragment().apply { arguments = Bundle().apply { putInt(ARG_TYPE, type); putString(ARG_CODE, code) } }.also { instance = it }
        /** Original: b0(FragmentManager, int container, String code, int type, r.c) */
        @Synchronized fun show(fm: FragmentManager, containerId: Int, code: String, type: Int, l: Listener) {
            val f = newInstance(type, code).also { it.listener = l }
            val existing = fm.findFragmentByTag(TAG)
            val tx = fm.beginTransaction()
            if (existing == null) tx.add(containerId, f, TAG).commitAllowingStateLoss() else tx.show(existing).commitAllowingStateLoss()
        }
    }
}

/**
 * Recarga por QR "escaneado" (layout `recharge_fragment`, ids `rechargef_*`; Kotlin com Companion): mostra QR do site de
 * membros (`member_qr_display` padrão true; título `how_to_new_title` / `how_to_buy_play`) e checa o pagamento: botão "check payment"
 * e um [Handler] (what = 1) que a cada `qrcodeRefreshIntervalSeconds` do SDK chama [checkPayment] em background.
 * [checkPayment] roda `UserManager.updateSession()` (InteractionUtils.M0): sucesso e validade mudou → toast
 * `remind_recharge_successfully` + dias/validade e `nav.next` (k.b); sem mudança e em primeiro plano → toast `user_not_available`;
 * falha em primeiro plano → toast "msg(code)". Também permite digitar o código (19+ chars) como em [RechargeMiniFragment]
 * ([RechargeMiniPresenter.loginWithAccount] com `AccountValidators.accountType` da conta). Back: botão voltar visível → `nav.back`.
 * Singleton via `SoftReference`. Tag "ScanedRechargeFragment".
 * Original: com/live/evo/fragment/login/u.java
 */
class ScanedRechargeFragment : BaseFragment(), RechargeMiniView, View.OnClickListener, View.OnFocusChangeListener, LoginNavigator.BackHandler {
    private var root: View? = null
    private var tvRemind: TextView? = null
    private var tvConfirm: TextView? = null
    private var presenter: RechargeMiniPresenter? = null
    private var etCardNum: EditText? = null
    private var tvUserName: TextView? = null
    private var tvRemindBottom: TextView? = null
    private var nav: LoginNavigator.FragmentNavigator? = null
    private var tvToLogin: TextView? = null
    private var loading: com.live.evo.widget.sloading.SLoadingDialog? = null
    private var ivBack: ImageView? = null
    private var tvHint: TextView? = null
    private var ivQr: ImageView? = null
    private var tvRefreshQr: TextView? = null
    private var tvCheckPayment: TextView? = null
    private var ivIcon: ImageView? = null
    private var keyboard: com.foxivid.ui.keyboard.KeyboardContainer? = null
    private var window: Window? = null
    private var lastQrUrl = ""

    /** Handler do auto-check (what = 1), reagendado pelo intervalo de refresh do QR. */
    private val handler = object : android.os.Handler(android.os.Looper.getMainLooper()) {
        override fun handleMessage(msg: android.os.Message) {
            super.handleMessage(msg)
            if (msg.what == 1) { checkPayment(true); sendEmptyMessageDelayed(1, HeartbeatManager.qrcodeRefreshIntervalSeconds.toLong() * 1000) }
        }
    }

    /** Foco/navegação entre campo, botões e teclado virtual. Original: g0(View, int, KeyEvent) */
    private val focusKeyListener = View.OnKeyListener { view, keyCode, event ->
        val kb = keyboard
        val okKey = keyCode == 23 || keyCode == 66
        if (kb != null && event.action == KeyEvent.ACTION_DOWN && okKey) {
            if (view.id == R.id.rechargef_et_card_num) { kb.toggle(); true } else false
        } else if (kb != null && event.action == KeyEvent.ACTION_UP && okKey) view.id == R.id.rechargef_et_card_num
        else if (kb != null && event.action == KeyEvent.ACTION_UP && (keyCode == 4 || keyCode == 111)) {
            if (view.id == R.id.rechargef_et_card_num && kb.visibility == View.VISIBLE) { kb.hideOrDismissPopup(); true } else false
        } else if ((view.id == R.id.rechargef_qrcode_refresh || view.id == R.id.rechargef_check_payment) && keyCode == 22) {
            if (event.action == KeyEvent.ACTION_UP) etCardNum?.requestFocus(); true
        } else if (view.id == R.id.rechargef_qrcode_refresh && keyCode == 19) {
            if (event.action == KeyEvent.ACTION_UP) ivBack?.requestFocus(); true
        } else if (view.id == R.id.rechargef_et_card_num && keyCode == 20) {
            if (tvConfirm!!.isEnabled) { if (event.action == KeyEvent.ACTION_UP) tvConfirm!!.requestFocus(); true } else false
        } else false
    }

    override fun setPresenter(presenter: Any?) {}

    /** Voltar: se o botão voltar está visível → `nav.back`, senão deixa o Navigator tratar. Original: H() */
    override fun handleBack(): Boolean {
        val b = ivBack
        if (b == null || b.visibility != View.VISIBLE) return LoginNavigator.dispatchBackPressed(this)
        nav?.back(this)
        return true
    }

    override fun hideLoading() { loading?.dismiss() }
    override fun showLoading() { loading?.show() }
    override fun onLoginSuccess() { etCardNum?.setText(""); nav?.next(this) }
    override fun showError(msg: String, sub: String) {
        val d = RemindAlertDialog(requireActivity(), object : RemindAlertDialog.Listener {
            override fun a() {}
            override fun b() { etCardNum?.requestFocus(); etCardNum?.setSelection(etCardNum?.text?.length ?: 0) }
        })
        d.setTitle(CommonUtils.string(R.string.recharge_fail))
        d.setMessage(msg, if (TextUtils.isEmpty(sub)) "" else CommonUtils.string(R.string.error_code) + sub)
        d.show()
    }
    /** Mostra "email_id_2 <valor>" só nos modos 2 (e-mail) e 6 (telefone). Original: n(String) */
    override fun onRenewCode(code: String) {
        val mode = AppUserManager.get().welcomeMode()
        if (mode != 2 && mode != 6) { tvUserName?.visibility = View.INVISIBLE; return }
        tvUserName?.visibility = View.VISIBLE
        tvUserName?.text = String.format("%s %s", CommonUtils.string(R.string.email_id_2), code)
    }

    private fun bindViews() {
        val v = root!!
        ivIcon = v.findViewById(R.id.rechargef_iv_icon)
        ivIcon?.setImageDrawable(androidx.core.content.res.ResourcesCompat.getDrawable(resources, com.live.evo.AppConfig.launcherIcon, null))
        tvRemind = v.findViewById(R.id.rechargef_tv_remind)
        tvConfirm = v.findViewById(R.id.rechargef_tv_confirm)
        tvUserName = v.findViewById(R.id.rechargef_tv_username)
        etCardNum = v.findViewById(R.id.rechargef_et_card_num)
        tvRemindBottom = v.findViewById(R.id.rechargef_tv_remind_bottom)
        tvToLogin = v.findViewById(R.id.rechargef_tv_how_to_recharge)
        ivBack = v.findViewById(R.id.rechargef_iv_back)
        tvHint = v.findViewById(R.id.rechargef_tv_remind_hint)
        ivQr = v.findViewById(R.id.rechargef_iv_qr_membersite)
        tvRefreshQr = v.findViewById(R.id.rechargef_qrcode_refresh)
        tvCheckPayment = v.findViewById(R.id.rechargef_check_payment)
        val scanLayout = v.findViewById<android.widget.LinearLayout>(R.id.ll_scan_qr_code)
        if (!BaseLibConfig.displayMemberSite) scanLayout?.visibility = View.GONE
        loading = com.live.evo.widget.sloading.SLoadingDialog(requireActivity()).setStyle(com.live.evo.widget.sloading.LoadingStyle.TRANSLATE_CIRCLE).setColor(R.color.sloading_color)
        TextStyleUtils.b(tvRemind); TextStyleUtils.d(tvConfirm); TextStyleUtils.b(tvUserName); TextStyleUtils.d(etCardNum); TextStyleUtils.b(tvRemindBottom)
        keyboard?.addEditText(etCardNum)
        etCardNum?.requestFocus()
    }

    private fun bindListeners() {
        etCardNum!!.onFocusChangeListener = this
        tvConfirm!!.onFocusChangeListener = this
        ivBack!!.setOnClickListener(this); tvConfirm!!.setOnClickListener(this); tvToLogin!!.setOnClickListener(this)
        tvRefreshQr?.setOnClickListener(this); tvCheckPayment?.setOnClickListener(this)
        etCardNum!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val et = etCardNum!!
                if (TextUtils.isEmpty(s) || s!!.length < 19) {
                    et.setTextColor(CommonUtils.color(R.color.text_color_et_selector_focus)); et.background = CommonUtils.drawable(R.drawable.load_et_selector)
                    tvConfirm!!.isEnabled = false; tvConfirm!!.isFocusable = false
                } else {
                    et.background = CommonUtils.drawable(R.drawable.recharge_mini_full); et.setTextColor(CommonUtils.color(R.color.recharge_fill_text_color))
                    tvConfirm!!.isEnabled = true; tvConfirm!!.isFocusable = true
                }
            }
            override fun beforeTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
            override fun onTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
        })
        etCardNum!!.setOnKeyListener(focusKeyListener)
        tvRefreshQr!!.setOnKeyListener(focusKeyListener)
        tvCheckPayment!!.setOnKeyListener(focusKeyListener)
    }

    /**
     * Verifica se o pagamento caiu: atualiza a sessão e compara a validade. [inBackground] = chamado pelo timer (sem toasts de falha).
     * Original: c0(boolean) — corrotina `ScanedRechargeFragment$checkPayment$1`.
     */
    fun checkPayment(inBackground: Boolean = false) {
        val oldExpire = AppUserManager.get().expiryTime()
        val checking = CommonUtils.string(R.string.checking)
        if (tvCheckPayment?.text == checking) return
        tvCheckPayment?.text = checking
        val idle = CommonUtils.string(R.string.scaned_remind_checkpayment)
        CoroutineScope(Dispatchers.IO).launch {
            UserManager.updateSession()
                .catch { e -> withContext(Dispatchers.Main) {
                    if (isAdded) { tvCheckPayment?.text = idle; if (!inBackground) e.message?.let { ToastUtils.showLong(it) } }
                } }
                .collect { r -> withContext(Dispatchers.Main) {
                    if (!isAdded) return@withContext
                    tvCheckPayment?.text = idle
                    if (r.first) {
                        refreshQr()
                        if (oldExpire != AppUserManager.get().expiryTime()) {
                            ToastUtils.showLong(CommonUtils.string(R.string.remind_recharge_successfully) + "\n" + UserManager.getPlanLeftDays() + " " + getString(R.string.days) + " / " + UserManager.getExpireDateString())
                            nav?.next(this@ScanedRechargeFragment)
                        } else if (!inBackground) ToastUtils.showLong(CommonUtils.string(R.string.user_not_available))
                    } else if (!inBackground) {
                        val code = r.second?.toString() ?: ""
                        r.third?.let { ToastUtils.showLong("$it($code)") }
                    }
                } }
        }
    }

    /** Gera/atualiza o QR do site de membros (só se mudou). Original: h0() */
    fun refreshQr() {
        if (AppUserManager.get().getBoolean("member_qr_display", true)) {
            val content = ModelHelper.membershipQrContent()
            if (content != lastQrUrl) {
                if (content.isNotEmpty()) AppUserManager.get().qrBitmap(content)?.let { GlideImageLoader.load(requireContext(), it, R.drawable.qr_placehodler, ivQr!!) }
                lastQrUrl = content
            }
        } else ivQr?.visibility = View.INVISIBLE
    }

    private fun refreshTexts() {
        val site = UserManager.getMembershipUrl(); val support = HeartbeatManager.customerServiceEmail
        if (BaseLibConfig.displayMemberSite) {
            handler.removeMessages(1)
            handler.sendEmptyMessageDelayed(1, HeartbeatManager.qrcodeRefreshIntervalSeconds.toLong() * 1000)
            tvHint!!.text = Html.fromHtml(ContactTemplate.a("how_to_new_title", CommonUtils.string(R.string.how_to_renew)))
            tvRemind!!.text = Html.fromHtml(CommonUtils.string(R.string.recharge_code_scan_remind))
            tvRemindBottom!!.text = Html.fromHtml(ContactTemplate.a("recharge_guide", CommonUtils.string(R.string.recharge_guide)).replace("\${MS}", site).replace("\${RS}", site).replace("\${CS}", support))
        } else {
            tvHint!!.text = Html.fromHtml(AppUserManager.get().getString("how_to_new_title", CommonUtils.string(R.string.how_to_buy_play)))
            tvRemind!!.text = Html.fromHtml(CommonUtils.string(R.string.recharge_code_remind))
            tvRemindBottom!!.text = Html.fromHtml(ContactTemplate.a("recharge_guide", CommonUtils.string(R.string.payment_guide_rechargecode)).replace("\${MS}", site).replace("\${RS}", site).replace("\${CS}", support))
        }
        tvToLogin!!.text = Html.fromHtml("<u>" + CommonUtils.string(R.string.to_login) + "</u>")
        presenter?.loadRenewCode()
        etCardNum!!.setText("")
        val mode = AppUserManager.get().welcomeMode()
        if (mode != 2 && mode != 6) tvUserName!!.visibility = View.INVISIBLE
        else { tvUserName!!.visibility = View.VISIBLE; tvUserName!!.text = UserManager.getUsername() }
        refreshQr()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.rechargef_check_payment -> checkPayment(false)
            R.id.rechargef_iv_back -> nav?.back(this)
            R.id.rechargef_qrcode_refresh -> refreshQr()
            R.id.rechargef_tv_confirm -> if (tvConfirm?.isEnabled == true) {
                val code = etCardNum?.text.toString().trim()
                AppUserManager.get().welcomeMode()
                val accountType = AccountValidators.accountType(AppUserManager.get().renewCode())   // o5.a.a(l.n().d())
                presenter?.loginWithAccount(code.replace(" ", ""), accountType)
            }
        }
    }
    override fun onFocusChange(v: View, hasFocus: Boolean) { if (hasFocus) AnimUtils.d(v) else AnimUtils.g(v) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        root = inflater.inflate(R.layout.recharge_fragment, container, false)
        keyboard = com.foxivid.ui.keyboard.KeyUtils.create(window, requireContext(), root, lifecycle, false)
        presenter = RechargeMiniPresenter().also { it.attach(this) }
        bindViews(); refreshTexts(); bindListeners()
        return root!!
    }
    override fun onPause() { presenter?.detach(); super.onPause() }
    override fun onDestroy() { super.onDestroy(); instanceRef = null }
    override fun onHiddenChanged(hidden: Boolean) { super.onHiddenChanged(hidden); if (!hidden) refreshTexts() else handler.removeMessages(1) }
    override fun onResume() { super.onResume(); presenter?.attach(this); refreshTexts() }

    companion object {
        private var instanceRef: java.lang.ref.SoftReference<ScanedRechargeFragment>? = null
        /** Cria uma nova instância (soft reference). Original: Companion.a() */
        private fun create(): ScanedRechargeFragment? { instanceRef = java.lang.ref.SoftReference(ScanedRechargeFragment()); return instanceRef?.get() }
        /** Original: Companion.b(FragmentManager, Window, int, k) */
        @Synchronized fun show(fm: FragmentManager, window: Window, containerId: Int, nav: LoginNavigator.FragmentNavigator) {
            val f = create() ?: return
            f.nav = nav; f.window = window
            val existing = fm.findFragmentByTag("ScanedRechargeFragment")
            val tx = fm.beginTransaction()
            if (existing == null) tx.add(containerId, f, "ScanedRechargeFragment").commitAllowingStateLoss() else tx.show(existing).commitAllowingStateLoss()
        }
    }
}
