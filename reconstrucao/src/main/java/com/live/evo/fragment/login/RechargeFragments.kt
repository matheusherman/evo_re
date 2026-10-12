package com.live.evo.fragment.login

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.RelativeLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.foxivid.baselib.media.MediaRepository
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
 * | 21 | RechargeMini se não há renew code (`MediaRepository.Z()` vazio) |
 * | 22 | login por conta ([LoginNavigator.showAccountLogin], aba 0) |
 * | 23 | [RechargeMiniFragment] |
 * | 24 | lembrete de expiração calculado (`n0()`): compara validade (I) com agora e janela de aviso (U); tipos -1 (nada → `listener.e()`), 5, 4 ou 1 (+ "N hour(s)"); usa a flag estática [showing] para não reabrir |
 * | 25 | [CheckAccountFragment] |
 * | 26 | [BindAccountTipFragment] (só se `AppConstants.flagH`) |
 * | 40/41/42 | [RenewCodeLoginSupportFragment] com o renew code (`MediaRepository.r()`) |
 * | 49 | [LoginFinishMiniFragment] |
 * | 50/51 | [BffInfoFragment] |
 * | 52 | (l0 — não detalhado) |
 * | 53 | [ShareCodeInfoFragment] |
 * | 54 | [TabFunctionRechargeFragment] via companion |
 *
 * Fechar (Back) chama o `osd.a` listener. Janela sem moldura, fundo transparente, SOFT_INPUT 32.
 * Dois fábricas estáticas: `show(fm, type, listener)` (= `show(fm, type, true, listener)`) e a de 4 args com `cancelable`.
 *
 * Original: com/live/evo/fragment/login/j.java (nome real RechargeDialogFragment)
 */
class RechargeDialogFragment : DialogFragment(), DialogInterface.OnKeyListener {
    private val logger = LoggerFactory.getLogger(RechargeDialogFragment::class.java)
    private var listener: OsdControlListener? = null
    private var type = 0
    private var cancelableFlag: Boolean = true
    private var root: View? = null
    private lateinit var parent: RelativeLayout

    private fun childFm(): FragmentManager = childFragmentManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        dialog!!.requestWindowFeature(1)
        val w = dialog!!.window!!
        w.setBackgroundDrawable(android.graphics.drawable.ColorDrawable(0))
        w.setSoftInputMode(32)
        w.decorView.setPadding(0, 0, 0, 0)
        w.attributes = w.attributes.also { it.width = -1; it.height = -1; it.gravity = 17 }
        val v = inflater.inflate(R.layout.recharge_dialog_fragment, container, false)
        root = v
        parent = v.findViewById(R.id.rechargedlg_rl_parent)
        dialog!!.setOnKeyListener(this)
        // original: se activity é LiveNewActivity, registra callback de fechamento na activity
        isCancelable = cancelableFlag
        dispatchInitialScreen()
        return v
    }

    /** Escolhe a tela inicial pelo [type]. Original: l() */
    private fun dispatchInitialScreen() {
        when (type) {
            24 -> reminderOrClose()
            21 -> if (MediaRepository.renewCodeOrEmpty().isEmpty()) showRechargeMini()
            22 -> showAccountLogin(true, 0, null)
            23 -> showRechargeMini()
            25 -> showCheckAccount(null)
            40, 41, 42 -> showRenewCodeLogin(type, MediaRepository.renewCodeOrEmpty())
            49 -> LoginFinishMiniFragment.show(childFm(), R.id.rechargedlg_rl_parent) { dismiss() }
            26 -> if (AppConstants.flagH) { dismiss(); BindAccountTipFragment.show(childFm(), R.id.rechargedlg_rl_parent, object : BindAccountTipFragment.Listener { override fun a(f: Fragment, choice: Int) {} }) }
            50, 51 -> BffInfoFragment.show(childFm(), R.id.rechargedlg_rl_parent, type) { dismiss() }
            52 -> TODO("não detalhado: j.l0()")
            53 -> ShareCodeInfoFragment.show(childFm(), R.id.rechargedlg_rl_parent) { dismiss() }
            54 -> TabFunctionRechargeFragment.show(childFm(), dialog!!.window!!, R.id.rechargedlg_rl_parent, null)
        }
    }

    /** Original: n0() — decide o tipo de lembrete de expiração. */
    private fun reminderOrClose() {
        TODO("calcula type via MediaRepository.I()/U()/a0()/l0()/Z(); -1 → dismiss + listener.e(); senão RechargeRemindFragment")
    }

    private fun showRechargeMini() = RechargeMiniFragment.show(childFm(), dialog!!.window!!, R.id.rechargedlg_rl_parent, object : MiniNav {})
    private fun showAccountLogin(showBack: Boolean, tab: Int, from: Fragment?) =
        LoginNavigator.showAccountLogin(childFm(), dialog!!.window!!, R.id.rechargedlg_rl_parent, showBack, "", tab, object : LoginNavigator.AccountLoginCallback {
            override fun onBack(f: Fragment) { childFm().beginTransaction().hide(f).commitAllowingStateLoss(); from?.let { childFm().beginTransaction().show(it).commitAllowingStateLoss() } ?: dismiss() }
            override fun onLoginSuccess(f: Fragment) { dismiss(); listener?.onDismiss() }
            override fun onRenewCodeLogin(f: Fragment) { childFm().beginTransaction().hide(f).commitAllowingStateLoss(); showRenewCodeLogin(40, MediaRepository.renewCodeOrEmpty()) }
            override fun onRegister(f: Fragment) { childFm().beginTransaction().hide(f).commitAllowingStateLoss(); TODO("RegisterEmailFragment via LoginNavigator.showRegister") }
            override fun onResetPassword(f: Fragment, account: com.live.evo.model.AccountBean) { TODO("LoginNavigator.showResetPassword") }
        })
    private fun showCheckAccount(from: Fragment?) =
        CheckAccountFragment.show(MediaRepository.renewCodeOrEmpty(), dialog!!.window!!, childFm(), R.id.rechargedlg_rl_parent, object : CheckAccountFragment.Listener { override fun a(f: Fragment) { dismiss() } })
    private fun showRenewCodeLogin(t: Int, code: String) =
        RenewCodeLoginSupportFragment.show(childFm(), R.id.rechargedlg_rl_parent, code, t, object : RenewCodeLoginSupportFragment.Listener {
            override fun exit(f: Fragment) { dismiss() }
            override fun rechargeLater(f: Fragment) { dismiss() }
            override fun loginSuccess(f: Fragment) { dismiss() }
        })

    override fun onKey(d: DialogInterface?, keyCode: Int, event: KeyEvent): Boolean =
        TODO("login/j.onKey: Back → LoginNavigator.dispatchBackPressed(childFm) senão dismiss + listener")

    private interface MiniNav : LoginNavigator.FragmentNavigator { override fun back(f: Fragment) {}; override fun next(f: Fragment) {} }

    companion object {
        /** Evita abrir dois lembretes de recarga. Original: j.f6220j */
        @JvmField var showing = false
        private var current: RechargeDialogFragment? = null

        private fun newInstance(): RechargeDialogFragment {
            current?.let { if (it.dialog != null && it.dialog!!.isShowing) it.dismiss() }
            return RechargeDialogFragment().also { current = it }
        }
        /** Original: g0(FragmentManager, int, osd.a) → h0(fm, type, true, l) */
        fun show(fm: FragmentManager?, type: Int, l: OsdControlListener?) = show(fm, type, true, l)
        /** Original: h0(FragmentManager, int, Boolean, osd.a) — tag "recharge" */
        fun show(fm: FragmentManager?, type: Int, cancelable: Boolean?, l: OsdControlListener?) {
            try {
                val f = newInstance().also { it.listener = l; it.type = type; it.cancelableFlag = cancelable ?: true }
                val d: Dialog? = f.dialog
                if (d != null && !d.isShowing) d.show() else if (d == null) f.show(fm!!, "recharge")
            } catch (e: Exception) { LoggerFactory.getLogger(RechargeDialogFragment::class.java).error(e.message, e) }
        }
    }
}

/**
 * Recarga "mini" (layout `recharge_mini_fragment`): digitar renew code (`RechargeEditText`) e confirmar.
 * Presenter [RechargeMiniPresenter]; sucesso → próximo passo (LoginFinishMini). Tag "RechargeMiniFragment".
 * Original: com/live/evo/fragment/login/l.java (Y = show)
 */
class RechargeMiniFragment : BaseFragment(), RechargeMiniView {
    private var presenter: RechargeMiniPresenter? = null
    override fun setPresenter(presenter: Any?) {}
    override fun hideLoading() { TODO() }
    override fun showLoading() { TODO() }
    override fun onLoginSuccess() { TODO("listener.b(this)") }
    override fun showError(msg: String, sub: String) { TODO() }
    override fun onRenewCode(code: String) { TODO("preenche o campo com o renew code atual") }
    companion object {
        @Synchronized fun show(fm: FragmentManager, window: Window, containerId: Int, nav: Any) {
            val existing = fm.findFragmentByTag("RechargeMiniFragment")
            if (existing == null) fm.beginTransaction().add(containerId, RechargeMiniFragment(), "RechargeMiniFragment").commitAllowingStateLoss()
            else fm.beginTransaction().show(existing).commitAllowingStateLoss()
        }
    }
}

/**
 * Lembrete de recarga/expiração (layout `rechargeremind_fragment`; tag "RechargeRemindFragment"). Texto depende do tipo
 * (arg 1 = perto de expirar; 2/4/10 = expirou) e do modo de conta `iQ` ([com.live.evo.util.ModelHelper.welcomeMode]):
 * 1 = trial → botão `input_renewal_code`, texto `remind_expired_by_trial`/`trial_near_expired_remind`; 3 = renew code →
 * `remind_expired_by_renewcode`/`renew_code_near_expired_remind`; 0 = MAC → `remind_expired_mac`; demais → `remind_expired` /
 * `normal_near_expired_remind`. Botões: recarregar agora/inserir código (callback `onRechargeNow`), pular/mais tarde
 * (`onSkip`), "how to recharge" abre guia. Mostra QR da recarga se a propriedade `member_qr_display` (padrão false) e
 * há bitmap. Se modo 3 e validade (`l()`) passou → `onLogin(this, 3)`.
 * Original: com/live/evo/fragment/login/m.java (U = show)
 */
class RechargeRemindFragment : BaseFragment() {
    private var cb: LoginNavigator.RechargeRemindCallback? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = TODO("ver login/m.onCreateView")
    companion object {
        /** Original: U(FragmentManager, int container, int type, String expiryDuration, e5.f) */
        fun show(fm: FragmentManager, containerId: Int, type: Int, expiryDuration: String?, cb: LoginNavigator.RechargeRemindCallback) {
            val existing = fm.findFragmentByTag("RechargeRemindFragment")
            val tx = fm.beginTransaction()
            if (existing != null) tx.remove(existing)
            val f = RechargeRemindFragment().apply { arguments = Bundle().apply { putInt("arg_remind_type", type); putString("arg_expiry_duration", expiryDuration) }; this.cb = cb }
            tx.add(containerId, f, "RechargeRemindFragment").commitAllowingStateLoss()
        }
    }
}

/**
 * Login por renew code (suporte): `type` 40/41/42 (42 = "bind remind"). Layouts: `code_login_support_fragment` com
 * painéis "primeiro login com sucesso" (`recharge_id`, bind/assistir), "vincular" (`code_bind_*`: checkbox
 * `code_bind_checkbox_tips`, bind now/later) e "confirmar código" (`code_confirm_*`). Marca a propriedade
 * `user_properties/code_bind_remind_status` ("1"/"0") ao decidir. Código vazio → `recharge_key_empty`.
 * Presenter [CodeLoginPresenter] (sem efeito); view callbacks a/b/c/e.
 * Original: com/live/evo/fragment/login/r.java (b0 = show; Listener = r.c: a=exit, b=rechargeLater, c=loginSuccess)
 */
class RenewCodeLoginSupportFragment : BaseFragment(), CodeLoginView {
    interface Listener { fun exit(f: Fragment); fun rechargeLater(f: Fragment); fun loginSuccess(f: Fragment) }
    private var listener: Listener? = null
    override fun setPresenter(presenter: CodeLoginPresenterContract) {}
    override fun b() { TODO("view.b(): mostra painel conforme tipo") }
    companion object {
        @Synchronized fun show(fm: FragmentManager, containerId: Int, code: String, type: Int, l: Listener) {
            val existing = fm.findFragmentByTag("RenewCodeLoginSupportFragment")
            if (existing == null) {
                val f = RenewCodeLoginSupportFragment().apply { listener = l; arguments = Bundle().apply { putString("arg_renew_code", code); putInt("arg_type", type) } }
                fm.beginTransaction().add(containerId, f, "RenewCodeLoginSupportFragment").commitAllowingStateLoss()
            } else fm.beginTransaction().show(existing).commitAllowingStateLoss()
        }
    }
}

/**
 * Recarga por QR "escaneado" (layout `recharge_fragment`, ids `rechargef_*`; Kotlin com Companion): mostra QR para pagar
 * (`member_qr_display` padrão true; título `how_to_new_title` / `how_to_buy_play`), checa pagamento
 * periodicamente e implementa [RechargeMiniView] ([RechargeMiniPresenter]). Back tratado. Tag "ScanedRechargeFragment".
 * Original: com/live/evo/fragment/login/u.java
 */
class ScanedRechargeFragment : BaseFragment(), RechargeMiniView, LoginNavigator.BackHandler {
    override fun setPresenter(presenter: Any?) {}
    override fun hideLoading() { TODO() }
    override fun showLoading() { TODO() }
    override fun onLoginSuccess() { TODO("nav.next(this)") }
    override fun showError(msg: String, sub: String) { TODO() }
    override fun onRenewCode(code: String) { TODO() }
    override fun handleBack(): Boolean = TODO("login/u.H()")
    companion object {
        @Synchronized fun show(fm: FragmentManager, window: Window, containerId: Int, nav: LoginNavigator.FragmentNavigator) {
            val existing = fm.findFragmentByTag("ScanedRechargeFragment")
            if (existing == null) fm.beginTransaction().add(containerId, ScanedRechargeFragment(), "ScanedRechargeFragment").commitAllowingStateLoss()
            else fm.beginTransaction().show(existing).commitAllowingStateLoss()
        }
    }
}
