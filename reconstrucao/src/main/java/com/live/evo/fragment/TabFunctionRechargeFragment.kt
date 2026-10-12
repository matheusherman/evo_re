package com.live.evo.fragment

import android.view.View
import android.view.Window
import androidx.fragment.app.FragmentManager
import com.live.evo.fragment.login.presenter.RechargePresenter
import com.live.evo.fragment.login.presenter.RechargeView
import java.lang.ref.SoftReference

/**
 * Aba "Recarga" do menu de funções (layout `tabfunction_recharge_fragment`, ids `renew_*`/`rechargeremindf_*`).
 * Mostra, conforme o tipo de conta (`mAccountRenewType`):
 * - QR de pagamento (`lastQRUrl`, atualizado a cada `interval`, botão refresh/"check payment" =
 *   `scaned_remind_checkpayment`) para recarga por QR e por plano (`recyclerViewPlan`: lista `item_plan_info` via PlanItemView);
 * - campo de código de recarga ([com.live.evo.widget.RechargeEditText] + teclado virtual `ziyi.kit.keyboard`) com
 *   confirmação → [RechargePresenter.loginWithCode]; erros em diálogo com título/mensagem/código (`error_code`);
 * - tempo de expiração (`bMessage`, `nowExpireTs`/`responseExpiredTS`), "como recarregar", vínculo de usuário (`binduser`).
 * Reage a `b5.m` (UserTokenChangedEvent) refazendo a consulta (`mQuryUserRun`).
 * Aberta como popup ([isPopup]) pelo menu (companion `show`) ou embutida na aba "FUNCTION" do menu.
 * Implementa [RechargeView].
 *
 * Original: com/live/evo/fragment/l3.java (nome real TabFunctionRechargeFragment; tag "TabFunctionRechargeFragment")
 */
class TabFunctionRechargeFragment : LazyFragment(), RechargeView {
    var window: Window? = null
    var onEventListener: OnTabEventListener? = null
    var isPopup = false
    private var presenter: RechargePresenter? = null
    private var lastQrUrl: String? = null
    private var accountRenewType = 0
    private var rechargeCodeState = 0

    override fun layoutId(): Int = com.live.evo.R.layout.tabfunction_recharge_fragment
    override fun initData(savedInstanceState: android.os.Bundle?) { presenter = RechargePresenter().also { it.attach(this) } }
    override fun bindViews(root: View) { TODO("ver l3.f0: liga views e teclado virtual") }

    // RechargeView
    override fun showCreateError(msg: String, sub: String) { TODO("A1(title, message, errorCode, rightRun)") }
    override fun hideLoading() { TODO() }
    override fun showLoading() { TODO() }
    override fun onLoginSuccess() { TODO("atualiza expiração e fecha/avisa listener") }
    override fun showError(msg: String, sub: String) { TODO() }
    override fun onCreateAccountSuccess() { TODO() }
    override fun setPresenter(presenter: Any?) {}

    companion object {
        private var instanceRef: SoftReference<TabFunctionRechargeFragment>? = null
        private var tabViewRef: SoftReference<View>? = null

        /** True se a instância atual está visível. Original: Companion.b() */
        fun isShowing(): Boolean = instanceRef?.get()?.isVisible == true

        /** Singleton (SoftReference) usado como aba. Original: Companion.c(y1, View, Window) */
        fun obtain(listener: OnTabEventListener?, tabView: View?, window: Window?): TabFunctionRechargeFragment {
            if (tabView != null) tabViewRef = SoftReference(tabView)
            instanceRef?.get()?.let { it.window = window; it.onEventListener = listener; return it }
            synchronized(this) {
                instanceRef?.get()?.let { return it }
                return TabFunctionRechargeFragment().also { instanceRef = SoftReference(it); it.window = window; it.onEventListener = listener }
            }
        }

        /** Abre como popup; se já visível apenas chama `listener.b()`. Original: Companion.f(fm, window, containerId, y1) */
        @Synchronized fun show(fm: FragmentManager, window: Window?, containerId: Int, listener: OnTabEventListener?) {
            if (isShowing()) { /* listener.b() */ return }
            val existing = fm.findFragmentByTag("TabFunctionRechargeFragment")
            val tx = fm.beginTransaction()
            if (existing == null) {
                val f = TabFunctionRechargeFragment().also { it.window = window; it.onEventListener = listener; it.isPopup = true }
                tx.add(containerId, f, "TabFunctionRechargeFragment").commitAllowingStateLoss()
            } else tx.show(existing).commitAllowingStateLoss()
        }
    }
}
