package com.live.evo.fragment

import android.text.TextUtils
import android.view.View
import android.widget.TextView
import com.live.evo.AppConfig
import com.live.evo.AppUserManager
import com.live.evo.dialog.RemindAlertDialog
import com.live.evo.util.CommonUtils
import com.live.evo.util.ModelHelper
import com.live.evo.util.RxUtils
import com.live.evo.util.ServerClock
import com.live.evo.util.TextStyleUtils
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

    // --- views (ids `rechargeremindf_*`, `renew_*`, `rv_plan_list`) ---
    private var rootView: View? = null
    private var mRemind: TextView? = null
    private var mRenewNow: TextView? = null
    private var mBindUser: TextView? = null
    private var mRenewLayout: View? = null
    private var mGapLine: View? = null
    private var mScanedRenewLayout: View? = null
    private var mScanQRTitle: TextView? = null
    private var mScanQRRemind: TextView? = null
    private var mScanQRPic: android.widget.ImageView? = null
    private var mRefreshQR: TextView? = null
    private var mCheckPayment: TextView? = null
    private var mRechargeCodeLayout: View? = null
    private var mRechargeTitle: TextView? = null
    private var mRechargeRemind: TextView? = null
    private var mRechargeEdit: com.live.evo.widget.RechargeEditText? = null
    private var mRechargeConfirm: TextView? = null
    private var mScanWebPlanLayout: View? = null
    private var mScanPlanQRTitle: TextView? = null
    private var mScanPlanQRRemind: TextView? = null
    private var mScanPlanQRPic: android.widget.ImageView? = null
    private var mRefreshPlanQR: TextView? = null
    private var mCheckPlanPayment: TextView? = null
    private var recyclerViewPlan: androidx.leanback.widget.VerticalGridView? = null
    private var mRechargeHint: TextView? = null
    private var mRemindBottom: TextView? = null
    private var loadingView: com.live.evo.widget.sloading.SLoadingDialog? = null    // t5.a (SINGLE_CIRCLE, cor `sloading_color`)
    var keyboardView: com.foxivid.ui.keyboard.KeyboardContainer? = null
        private set
    private var mActionExecute = false
    private var mAccountCallback: com.live.evo.osd.OsdControlListenerEx? = null

    /** Liga views, teclado virtual e o estado de exibição. Original: f0(View) = {view = mRoot; t1(); m1(); s1()} */
    override fun bindViews(root: View) {
        rootView = root
        bindWidgets()
        buildKeyboard()
        updateRenewLayout()
    }

    /** findViewById de todos os widgets + estilos de texto + loading + espaçamento da lista de planos. Original: t1() */
    private fun bindWidgets() {
        val v = requireView()
        val id = com.live.evo.R.id
        mRemind = v.findViewById(id.rechargeremindf_tv_remind)
        mRenewNow = v.findViewById(id.rechargeremindf_tv_how_to_recharge)
        mBindUser = v.findViewById(id.rechargeremindf_tv_binduser)
        mRenewLayout = v.findViewById(id.rechargeremindf_ll_recharge)
        mGapLine = v.findViewById(id.renew_view_line)
        mScanedRenewLayout = v.findViewById(id.renew_scaned_layout)
        mScanQRTitle = v.findViewById(id.renew_qrcode_title)
        mScanQRRemind = v.findViewById(id.renew_qrcode_remind)
        mScanQRPic = v.findViewById(id.renew_qrcode_pic)
        mRefreshQR = v.findViewById(id.renew_qrcode_refresh)
        mCheckPayment = v.findViewById(id.renew_check_payment)
        mRechargeCodeLayout = v.findViewById(id.renew_recharge_layout)
        mRechargeTitle = v.findViewById(id.renew_rechargecode_title)
        mRechargeRemind = v.findViewById(id.renew_rechargecode_remind)
        mRechargeEdit = v.findViewById(id.renew_et_rechargecode)
        mRechargeConfirm = v.findViewById(id.renew_rechargecode_confirm)
        mScanWebPlanLayout = v.findViewById(id.layout_scan_plan_content)
        mScanPlanQRTitle = v.findViewById(id.renew_plan_qrcode_title)
        mScanPlanQRRemind = v.findViewById(id.renew_plan_qrcode_remind)
        mScanPlanQRPic = v.findViewById(id.renew_plan_qrcode_pic)
        mRefreshPlanQR = v.findViewById(id.renew_plan_qrcode_refresh)
        mCheckPlanPayment = v.findViewById(id.renew_plan_check_payment)
        recyclerViewPlan = v.findViewById(id.rv_plan_list)
        mRechargeHint = v.findViewById(id.rechargeremindf_ltv_remind_hint)
        mRemindBottom = v.findViewById(id.rechargeremindf_tv_remind_bottom)
        TextStyleUtils.c(mRemind); TextStyleUtils.b(mRemindBottom); TextStyleUtils.b(mRechargeHint)
        TextStyleUtils.a(mScanQRTitle); TextStyleUtils.a(mScanQRRemind); TextStyleUtils.a(mRechargeTitle)
        TextStyleUtils.a(mRechargeRemind); TextStyleUtils.a(mRefreshQR); TextStyleUtils.a(mCheckPayment)
        TextStyleUtils.d(mRechargeConfirm)
        loadingView = com.live.evo.widget.sloading.SLoadingDialog(requireActivity()).also {
            it.setType(com.live.evo.widget.sloading.SLoadingType.SINGLE_CIRCLE)
            it.setColor(com.live.evo.R.color.sloading_color)
        }
        recyclerViewPlan?.addItemDecoration(com.live.evo.widget.SpaceItemDecoration(6))
    }

    /** Recria o teclado virtual ligado ao campo de código. Original: m1() */
    fun buildKeyboard() {
        try {
            keyboardView?.destroy()    // W()
            keyboardView = com.foxivid.ui.keyboard.KeyUtils.create(window, context, rootView, lifecycle, false, false)   // KeyUtils.u(...)
            val kb = keyboardView
            if (kb == null || mRechargeEdit == null) return
            kb.addEditText(mRechargeEdit!!)     // l(EditText); setKeyboardListener(null) não tem efeito
        } catch (_: Exception) {}
    }

    /** Escolhe o layout conforme o modo de recarga (plano x código). Original: s1() */
    private fun updateRenewLayout() {
        if (AppUserManager.get().isPlanRecharge) layoutForPlanMode() else layoutForCodeMode()
    }

    /** Plano de recarga vencido ou sem validade? Original: u1() */
    private fun isExpired(): Boolean = AppUserManager.get().expiryTime() <= ServerClock.get().now()

    /** Modo plano + pagamento + web. Original: Y1() */
    fun isPlanWebMode(): Boolean {
        val u = AppUserManager.get()
        return u.isPlanRecharge && u.isPaymentEnabled() && u.isPlanWebRecharge
    }

    /**
     * Visibilidade dos blocos no modo "plano" (QR de plano / QR / código). Se `a.f5188h` (flag de build) nada é feito. Se a conta
     * não expirou e o tipo é 3, só mostra o botão de vincular usuário. Original: b1()
     */
    private fun layoutForPlanMode() {
        if (AppConfig.f5188h) return
        if (!isExpired() && ModelHelper.welcomeMode() == 3) { mRenewLayout!!.visibility = View.GONE; mBindUser!!.visibility = View.VISIBLE; return }
        mBindUser!!.visibility = View.GONE
        mRenewLayout!!.visibility = View.VISIBLE
        if (isPlanWebMode()) {
            mScanWebPlanLayout!!.visibility = View.VISIBLE
            mScanedRenewLayout!!.visibility = View.GONE
            mRechargeCodeLayout!!.visibility = View.GONE
            mGapLine!!.visibility = View.GONE
            mRemind!!.gravity = android.view.Gravity.CENTER
            return
        }
        mScanWebPlanLayout!!.visibility = View.GONE
        val payment = AppUserManager.get().isPaymentEnabled()
        val codeAllowed = AppUserManager.get().isRechargeCodeAllowed
        mScanedRenewLayout!!.visibility = View.VISIBLE
        mGapLine!!.visibility = View.VISIBLE
        mRechargeCodeLayout!!.visibility = View.VISIBLE
        var hideLayout = false
        if (payment) {
            if (!codeAllowed) { mRechargeCodeLayout!!.visibility = View.GONE; mGapLine!!.visibility = View.GONE }
        } else {
            mScanedRenewLayout!!.visibility = View.GONE
            mGapLine!!.visibility = View.GONE
            hideLayout = true
        }
        setRenewLayoutWidth(hideLayout)
    }

    /**
     * Visibilidade dos blocos fora do modo plano, conforme o tipo (`mAccountRenewType`: 1 só QR, 2 só código) e a propriedade
     * `recharge_code_ctrl` (0 = esconde código, 1 = mostra). Original: Y0()
     */
    private fun layoutForCodeMode() {
        if (AppConfig.f5188h) return
        if (!isExpired() && ModelHelper.welcomeMode() == 3) { mRenewLayout!!.visibility = View.GONE; mBindUser!!.visibility = View.VISIBLE; return }
        mBindUser!!.visibility = View.GONE
        mRenewLayout!!.visibility = View.VISIBLE
        rechargeCodeState = AppUserManager.get().getInt("recharge_code_ctrl", -1)
        var payment = AppUserManager.get().isPaymentEnabled()
        mScanedRenewLayout!!.visibility = View.VISIBLE
        mGapLine!!.visibility = View.VISIBLE
        mRechargeCodeLayout!!.visibility = View.VISIBLE
        var onlyOneBlock = false           // z10
        if (accountRenewType == 1) {
            mRechargeCodeLayout!!.visibility = View.GONE; mGapLine!!.visibility = View.GONE
            onlyOneBlock = true
        } else if (accountRenewType == 2) {
            mScanedRenewLayout!!.visibility = View.GONE; mGapLine!!.visibility = View.GONE
            payment = false
        }
        if (!payment) { mScanedRenewLayout!!.visibility = View.GONE; onlyOneBlock = true }
        var layoutHide = true              // z11 (começa true; só vira [onlyOneBlock] nos casos abaixo)
        when (rechargeCodeState) {
            0 -> { mRechargeCodeLayout!!.visibility = View.GONE; mGapLine!!.visibility = View.GONE }
            1 -> {
                mRechargeCodeLayout!!.visibility = View.VISIBLE
                if (mScanedRenewLayout!!.visibility == View.GONE) mGapLine!!.visibility = View.GONE
                else { mGapLine!!.visibility = View.VISIBLE; layoutHide = onlyOneBlock }
            }
            else -> layoutHide = onlyOneBlock
        }
        setRenewLayoutWidth(layoutHide)
    }

    /** Largura do bloco de recarga: 700 dp centralizado se [hide] (só um bloco), senão MATCH_PARENT alinhado à esquerda. Original: Q1(boolean) */
    private fun setRenewLayoutWidth(hide: Boolean) {
        val lp = mRenewLayout!!.layoutParams as android.widget.RelativeLayout.LayoutParams
        if (hide) { lp.width = CommonUtils.dp(700.0f); mRemind!!.gravity = android.view.Gravity.CENTER }
        else { lp.width = -1; mRemind!!.gravity = android.view.Gravity.START or android.view.Gravity.CENTER_VERTICAL }
        mRenewLayout!!.layoutParams = lp
    }

    /** Foco inicial a partir da barra de abas (BAIXO): vincular usuário, QR, plano ou campo de código. Original: C1() */
    fun focusContent() {
        if (mRefreshQR == null) return
        if (mBindUser!!.visibility == View.VISIBLE) mBindUser!!.requestFocus()
        else if (!AppUserManager.get().isPlanRecharge) {
            val type = AppUserManager.get().accountRenewType
            if (type == 0 || type == 1) {
                if (AppUserManager.get().isPaymentEnabled()) { if (mScanedRenewLayout!!.visibility == View.VISIBLE) mRefreshQR!!.requestFocus() }
                else focusRechargeEdit()
            } else if (type == 2) focusRechargeEdit()
        } else if (!AppUserManager.get().isPaymentEnabled()) focusRechargeEdit()
        else if (AppUserManager.get().isPlanWebRecharge) mRefreshPlanQR!!.requestFocus()
        else mRefreshQR!!.requestFocus()
        if (AppConfig.f5188h) mRenewNow!!.requestFocus()
    }

    /** Foca o campo de código e leva o cursor ao fim. Original: M1() */
    private fun focusRechargeEdit() {
        if (mRechargeCodeLayout!!.visibility == View.VISIBLE) {
            mRechargeEdit!!.requestFocus()
            if (TextUtils.isEmpty(mRechargeEdit!!.text)) return
            mRechargeEdit!!.setSelection(mRechargeEdit!!.text!!.length)
        }
    }

    /** Diálogo de erro (título, mensagem e código) na main thread; [rightRun] roda ao confirmar. Original: A1(...) + B1 */
    fun showErrorDialog(title: String, message: String, errorCode: String, rightRun: Runnable?) {
        try {
            RxUtils.runOnUiThread {
                val dlg = RemindAlertDialog(activity!!, object : RemindAlertDialog.Listener {
                    override fun a() {}
                    override fun b() { rightRun?.run() }
                })
                dlg.setTitle(title)
                val code = if (TextUtils.isEmpty(errorCode)) "" else CommonUtils.string(com.live.evo.R.string.error_code) + errorCode
                dlg.setMessage(message, code)
                dlg.show()
            }
        } catch (t: Throwable) { t.printStackTrace() }
    }

    // RechargeView
    /** Falha ao criar a conta: diálogo "close"/"continue" sem código; continuar = sair do app com processo. Original: C(String, String) */
    override fun showCreateError(msg: String, sub: String) {
        val dlg = RemindAlertDialog(activity!!, object : RemindAlertDialog.Listener {
            override fun a() {}
            override fun b() {
                val intent = android.content.Intent("com.bb.action.EXIT")
                intent.putExtra("withProcess", true)
                context!!.sendBroadcast(intent)
            }
        })
        dlg.setReturnText(CommonUtils.string(com.live.evo.R.string.close))
        dlg.hideImage()
        dlg.setRightText(CommonUtils.string(com.live.evo.R.string.tv_continue))
        dlg.setMessage(msg, "")
        dlg.show()
    }
    /** Esconde o loading. Original: a() = U0() */
    override fun hideLoading() { loadingView?.hide() }
    /** Mostra o loading na UI thread. Original: b() = W1() + X1() */
    override fun showLoading() {
        if (loadingView == null) return
        activity?.runOnUiThread { loadingView!!.show() }
    }
    /**
     * Recarga concluída: avisa o menu pai (`y1.c()`), abre o diálogo de sucesso (tipo 49) e, se é popup, notifica o callback
     * (`e()`); reinicia estado do usuário (`v0.b().e()`) e, com renew type 2, a rotina `a.a().d()`. Original: e()
     */
    override fun onLoginSuccess() {
        onEventListener?.c()
        com.live.evo.fragment.login.RechargeDialogFragment.show(childFragmentManager, 49, mAccountCallback)
        if (isPopup) mAccountCallback?.onDismiss()
        MessageCenter.get().refresh()           // v0.b().e()
        if (AppUserManager.get().accountRenewType == 2) BffRequestScheduler.get().reschedule()   // a.a().d()
    }
    /** Erro de recarga: diálogo "recharge_fail" com mensagem e código. Original: i(String, String) */
    override fun showError(msg: String, sub: String) {
        showErrorDialog(CommonUtils.string(com.live.evo.R.string.recharge_fail), msg, sub, Runnable { /* N1(): vazio */ })
    }
    /**
     * Conta criada com sucesso: avisa o pai (`y1.c()`), atualiza o tempo de expiração na [LiveNewActivity] (`L3()`) e
     * reinicia estados (`v0.b().e()`, `a.a().d()` se tipo 2); depois refaz a tela ([refreshAfterLogin], `l()`). Original: z()
     */
    override fun onCreateAccountSuccess() {
        onEventListener?.c()
        (activity as com.live.evo.activity.LiveNewActivity).onExpiryRenewed()    // L3()
        MessageCenter.get().refresh()
        if (AppUserManager.get().accountRenewType == 2) BffRequestScheduler.get().reschedule()
        refreshAfterLogin()
    }

    /** Reaplica o layout do modo atual e agenda o refresh periódico (`V()` segundos). Original: l() */
    fun refreshAfterLogin() {
        if (AppUserManager.get().isPlanRecharge) layoutForPlanMode() else layoutForCodeMode()
        refreshHandler.removeMessages(1)
        refreshHandler.sendEmptyMessageDelayed(1, 1000L * com.foxivid.baselib.heartbeat.HeartbeatManager.renewRefreshSeconds())
    }
    private val refreshHandler = android.os.Handler(android.os.Looper.getMainLooper())

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
