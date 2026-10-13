package com.live.evo.fragment.login.presenter

import android.content.Context
import com.live.evo.model.AccountBean

/*
 * Contratos MVP das telas de login/recarga. Original: pacote com/live/evo/fragment/login/presenter/ + interfaces k5.a / k5.b.
 * k5.a<V> = Presenter (r(view) anexa, u() desanexa); k5.b<P> = View (K(presenter) recebe o presenter).
 */

/** Presenter base. Original: k5/a.java */
interface BasePresenter<V> { fun attach(view: V); fun detach() }
/** View base. Original: k5/b.java */
interface BaseView<P> { fun setPresenter(presenter: P) }

// --- Login (usuário/senha ou renew code) ---------------------------------------------------------------
/** Original: presenter/c.java */
interface LoginPresenterContract : BasePresenter<LoginView> {
    /** l(userID, password, accountLoginType, phonePreCode, countryCode) */
    fun login(userId: String, password: String, accountLoginType: Int, phonePreCode: String, countryCode: String)
    /** p() — pede o último AccountBean salvo à View (view.k(s0.p())) */
    fun loadSavedAccount()
    /** s(Context, code) — login por renewal code */
    fun loginByRenewalCode(context: Context, code: String)
}
/** Original: presenter/d.java */
interface LoginView : BaseView<LoginPresenterContract> {
    fun showError(message: String)       // J(String)
    fun onSavedAccount(account: AccountBean?) // k(i5.a)
    fun onP()                            // P()
    fun hideLoading()                    // a()
    fun showLoading()                    // b()
    fun onLoginSuccess()                 // c()
    fun onNetworkError()                 // d()
}

// --- Verificação de conta (CheckAccountFragment) --------------------------------------------------------
/** Original: presenter/a.java (View vazia) e presenter/b.java (presenter com método vazio `y(String,int,AccountBean)`) */
interface CheckAccountView : BaseView<Any?>
class CheckAccountPresenter : BasePresenter<CheckAccountView> {
    private var view: CheckAccountView? = null
    override fun attach(view: CheckAccountView) { this.view = view }
    override fun detach() { view = null }
    fun check(email: String, type: Int, account: AccountBean?) {}   // y(...) — vazio
}

// --- Recarga / renew code ------------------------------------------------------------------------------
/** View de recarga completa (Tab/MyAccount). Original: presenter/f.java */
interface RechargeView : BaseView<Any?> {
    fun showCreateError(msg: String, sub: String)  // C(String,String)
    fun hideLoading()                              // a()
    fun showLoading()                              // b()
    fun onLoginSuccess()                           // e()
    fun showError(msg: String, sub: String)        // i(String,String)
    fun onCreateAccountSuccess()                   // z()
}
/** View de recarga "mini". Original: presenter/h.java */
interface RechargeMiniView : BaseView<Any?> {
    fun hideLoading(); fun showLoading(); fun onLoginSuccess(); fun showError(msg: String, sub: String)
    fun onRenewCode(code: String)                  // n(String)
}

// --- Cadastro por e-mail -------------------------------------------------------------------------------
/** Original: presenter/j.java */
interface RegisterEmailPresenterContract : BasePresenter<RegisterEmailView> {
    /** j(email, accountLoginType, accountBean) — pede código de verificação */
    fun requestVerifyCode(email: String, accountLoginType: Int, account: AccountBean?)
    /** t(email, accountLoginType, verifyCode, password, accountBean) — registra */
    fun register(email: String, accountLoginType: Int, verifyCode: String, password: String, account: AccountBean?)
}
/** Original: presenter/k.java */
interface RegisterEmailView : BaseView<RegisterEmailPresenterContract> {
    fun onCodeError(msg: String, code: String)  // A(String,String) — erro do servidor
    fun hideLoading()                           // a()
    fun onCodeSent()                            // h()
    fun onNetworkError()                        // d()
    fun onRegistered()                          // c()
    fun showError(msg: String, sub: String)     // j(String,String) — exceção
}

// --- Reset de senha ------------------------------------------------------------------------------------
/** Original: presenter/p.java */
interface ResetPasswordPresenterContract : BasePresenter<ResetPasswordView> {
    fun requestVerifyCode(email: String, accountLoginType: Int, account: AccountBean?) // j(...)
    /** x(verifyCode, email, password, accountLoginType, phonePreCode, countryCode) */
    fun resetPassword(verifyCode: String, email: String, password: String, accountLoginType: Int, phonePreCode: String, countryCode: String)
}
/** Original: presenter/q.java */
interface ResetPasswordView : BaseView<ResetPasswordPresenterContract> {
    fun onResetSuccess()                       // G()
    fun hideLoading()                          // a()
    fun onNetworkError()                       // d()
    fun onCodeSent()                           // h()
    fun showError(msg: String, sub: String)    // j(String,String)
}

// --- Login por código de suporte (deprecated) ------------------------------------------------------------
/** Original: presenter/m.java (`n(Context,String,String)` @Deprecated) */
interface CodeLoginPresenterContract : BasePresenter<CodeLoginView> { @Deprecated("sem efeito") fun n(context: Context, a: String, b: String) }
/** Original: presenter/n.java */
interface CodeLoginView : BaseView<CodeLoginPresenterContract> { fun b() }
/** Implementação trivial: apenas chama `view.b()`. Original: presenter/o.java */
class CodeLoginPresenter : CodeLoginPresenterContract {
    private var view: CodeLoginView? = null
    override fun attach(view: CodeLoginView) { this.view = view }
    override fun detach() { view = null }
    @Deprecated("sem efeito") override fun n(context: Context, a: String, b: String) { view?.b() }
}
