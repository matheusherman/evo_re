package com.live.evo.fragment.login

import android.view.Window
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.live.evo.model.AccountBean

/**
 * Fachada de navegação do fluxo de login/recarga. No original é o pacote `e5` (e5/b, d, e, g, i = funções estáticas
 * que apenas chamam `Fragment.show(...)`; e5/a = tratamento de Back; e5/c, f, h, j + login/k = callbacks).
 *
 * Original: e5/a.java (dispatchBackPressed), e5/b.java (showAccountLogin → login/b.F0), e5/d.java (showScanedRecharge →
 * login/u.Companion.b), e5/e.java (showRechargeRemind → login/m.U), e5/g.java (showRegister → login/p.q0),
 * e5/i.java (showResetPassword → login/s.j0)
 */
object LoginNavigator {

    /** Fragment que quer tratar o Back antes do sistema. Original: e5/a.InterfaceC0175a (H()) */
    interface BackHandler { fun handleBack(): Boolean }

    /**
     * Despacha Back para os fragments filhos de trás para frente; se nenhum tratou e há back stack, faz pop.
     * Um fragment só recebe se `isVisible && userVisibleHint && is BackHandler`. Original: e5/a.b(FragmentManager)
     */
    fun dispatchBackPressed(fm: FragmentManager): Boolean {
        val fragments = fm.fragments
        for (i in fragments.size - 1 downTo 0) if (handled(fragments[i])) return true
        if (fm.backStackEntryCount <= 0) return false
        fm.popBackStack()
        return true
    }
    /** Original: e5/a.c(Fragment) */
    fun handled(f: Fragment?): Boolean = f != null && f.isVisible && f.userVisibleHint && f is BackHandler && f.handleBack()
    /** Original: e5/a.a(Fragment) */
    fun dispatchBackPressed(f: Fragment): Boolean = dispatchBackPressed(f.childFragmentManager)

    /** Original: e5/c */
    interface AccountLoginCallback {
        fun onBack(f: Fragment)              // a
        fun onLoginSuccess(f: Fragment)      // b
        fun onRenewCodeLogin(f: Fragment)    // c
        fun onRegister(f: Fragment)          // d
        fun onResetPassword(f: Fragment, account: AccountBean) // e
    }
    /** Original: e5/f */
    interface RechargeRemindCallback {
        fun onSkip(f: Fragment)              // a
        fun onRechargeNow(f: Fragment)       // b
        fun onLogin(f: Fragment, showTab: Int) // c
    }
    /** Original: e5/h, e5/j (a = back, b = next) */
    interface FragmentNavigator { fun back(f: Fragment); fun next(f: Fragment) }

    /** Original: e5/b.a → login/b.F0 (AccountUserLoginFragment) */
    fun showAccountLogin(fm: FragmentManager, window: Window, containerId: Int, showBack: Boolean, errorMessage: String?, showTab: Int, cb: AccountLoginCallback) =
        AccountUserLoginFragment.show(fm, window, containerId, showBack, errorMessage, showTab, cb)

    /** Original: e5/d.a → ScanedRechargeFragment.Companion.b */
    fun showScanedRecharge(fm: FragmentManager, window: Window, containerId: Int, nav: FragmentNavigator) =
        ScanedRechargeFragment.show(fm, window, containerId, nav)

    /** Original: e5/e.a → RechargeRemindFragment.U(fm, containerId, type, text, nav). O parâmetro `31/30` (int) é ignorado. */
    fun showRechargeRemind(fm: FragmentManager, window: Window, containerId: Int, type: Int, text: String?, unused: Int, cb: RechargeRemindCallback) =
        RechargeRemindFragment.show(fm, containerId, type, text, cb)

    /** Original: e5/g.a → login/p.q0 (RegisterEmailFragment) */
    fun showRegister(fm: FragmentManager, window: Window, containerId: Int, registerType: Int, flagA: Boolean, flagB: Boolean, account: AccountBean?, nav: FragmentNavigator) =
        RegisterEmailFragment.show(fm, window, containerId, registerType, flagA, flagB, account, nav)

    /** Original: e5/i.a → login/s.j0 (ResetAccountPasswordFragment) */
    fun showResetPassword(fm: FragmentManager, window: Window, containerId: Int, account: AccountBean?, flag: Boolean, nav: FragmentNavigator) =
        ResetAccountPasswordFragment.show(fm, window, containerId, account, flag, nav)
}
