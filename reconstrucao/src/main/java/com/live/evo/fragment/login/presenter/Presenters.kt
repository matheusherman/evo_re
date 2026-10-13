package com.live.evo.fragment.login.presenter

import android.content.Context
import android.text.TextUtils
import com.foxivid.baselib.user.AuthResult
import com.foxivid.baselib.user.UserManager
import com.live.evo.model.AccountBean
import com.live.evo.util.CommonUtils
import com.live.evo.util.ModelHelper
import com.live.evo.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory

// Resultado padrão dos fluxos de autenticação do SDK: Triple(sucesso, código, mensagem) = `AuthResult` de com.foxivid.baselib.user.

/**
 * Presenter de login. Fluxo de [login]: view.showLoading(); coleta `UserManager.login(userId, password)` (Flow<AuthResult>):
 * - erro → loga "Auth error" e na main mostra `auth_fail_title[<msg>]` via view.showError;
 * - resultado → hideLoading; sucesso → onLoginSuccess; código -3 → onNetworkError; senão showError("<msg>(<code>)").
 * [loginByRenewalCode]: coleta `UserManager.loginByCode(code)` e, se sucesso, `view.P()` quando `isRenewCodeFirstLogin(code)` senão `view.c()`;
 * mesmas regras de erro.
 *
 * Original: com/live/evo/fragment/login/presenter/e.java (nome real: LoginPresenter)
 */
class LoginPresenter : LoginPresenterContract {
    private val logger = LoggerFactory.getLogger(LoginPresenter::class.java)
    private var view: LoginView? = null
    private val io = CoroutineScope(Dispatchers.IO)

    override fun attach(view: LoginView) { this.view = view }
    override fun detach() { view = null }

    override fun login(userId: String, password: String, accountLoginType: Int, phonePreCode: String, countryCode: String) {
        val v = view ?: return
        v.showLoading()
        io.launch {
            UserManager.login(userId, password)   // InteractionUtils.y0 -> f.g1(userID, password)
                .catch { e -> logger.error("Auth error", e); withContext(Dispatchers.Main) { view?.showError(CommonUtils.string(R.string.auth_fail_title) + "[" + e.message + "]") } }
                .collect { r ->
                    withContext(Dispatchers.Main) {
                        view?.hideLoading()
                        if (r.first) view?.onLoginSuccess()
                        else if (r.second == -3) view?.onNetworkError()
                        else view?.showError("${r.third}(${r.second})")
                    }
                }
        }
    }

    override fun loadSavedAccount() { view?.onSavedAccount(ModelHelper.savedAccount()) } // s0.p()

    /**
     * Original: s(Context, String) — corrotina `LoginPresenter$loginByRenewalCode$1`.
     * `InteractionUtils.w0(code)` = `UserManager.loginByCode`; sucesso → se `InteractionUtils.r0(code)` (= `UserManager.isRenewCodeFirstLogin`)
     * chama `view.P()` (primeiro login com esse código) senão `view.c()`; -3 → `d()`; senão `J("<msg>(<code>)")`.
     */
    override fun loginByRenewalCode(context: Context, code: String) {
        val v = view ?: return
        v.showLoading()
        io.launch {
            UserManager.loginByCode(code)
                .catch { e -> v.hideLoading(); logger.error("Auth error", e); withContext(Dispatchers.Main) { view?.showError(CommonUtils.string(R.string.auth_fail_title) + "[" + e.message + "]") } }
                .collect { r ->
                    withContext(Dispatchers.Main) {
                        v.hideLoading()
                        if (r.first) { if (UserManager.isRenewCodeFirstLogin(code)) v.onP() else v.onLoginSuccess() }
                        else if (r.second == -3) view?.onNetworkError()
                        else view?.showError("${r.third}(${r.second})")
                    }
                }
        }
    }
}

/**
 * Presenter de recarga completa: [loginWithCode] chama `ModelHelper.loginWithRenewCode(code, isCreateAccount)`;
 * callback: hideLoading; sucesso → [RechargeView.onCreateAccountSuccess] (ou onLoginSuccess em A()); falha →
 * mensagem do servidor, `recharge_fail` se sem mensagem/exceção, `recharge_connect_failure` se código -3
 * (exibe via showCreateError se isCreateAccount, senão showError).
 * Original: fragment/login/presenter/g.java
 */
class RechargePresenter : BasePresenter<RechargeView> {
    private var view: RechargeView? = null
    override fun attach(view: RechargeView) { this.view = view }
    override fun detach() { view = null }

    /** Original: s(Context, String) → z(code, false) */
    fun login(context: Context, code: String) { if (view != null) loginWithCode(code, false) }

    /** Original: z(String, boolean) */
    fun loginWithCode(code: String, isCreateAccount: Boolean) {
        val v = view ?: return
        v.showLoading()
        ModelHelper.loginWithRenewCode(code, isCreateAccount) { ok, num, msg, th ->
            val vv = view ?: return@loginWithRenewCode
            vv.hideLoading()
            if (ok) { vv.onCreateAccountSuccess(); return@loginWithRenewCode }
            val text = if (th != null || num == null || TextUtils.isEmpty(msg)) CommonUtils.string(R.string.recharge_fail)
                       else if (num == -3) CommonUtils.string(R.string.recharge_connect_failure) else msg!!
            if (isCreateAccount) vv.showCreateError(text, "") else vv.showError(text, "")
        }
    }

    /** Original: A(String password, int accountLoginType) → ModelHelper.U */
    fun loginWithAccount(password: String, accountLoginType: Int) {
        view!!.showLoading()
        ModelHelper.loginWithAccount(password, accountLoginType) { ok, num, msg, th ->
            val vv = view ?: return@loginWithAccount
            vv.hideLoading()
            if (ok) { vv.onLoginSuccess(); return@loginWithAccount }
            val text = if (th != null || num == null || TextUtils.isEmpty(msg)) CommonUtils.string(R.string.recharge_fail)
                       else if (num == -3) CommonUtils.string(R.string.recharge_connect_failure) else msg!!
            vv.showError(text, "")
        }
    }
}

/**
 * Presenter da recarga "mini": mesmo [loginWithAccount] mas com mensagem de falha
 * `recharge_fail + "\n" + msg` quando não há mensagem limpa; [loadRenewCode] devolve `UserManager.getUsername()` (f.D0()) ou `lastUsername` (L())
 * (ou `L()` se vazio) à view.
 * Original: fragment/login/presenter/i.java
 */
class RechargeMiniPresenter : BasePresenter<RechargeMiniView> {
    private var view: RechargeMiniView? = null
    override fun attach(view: RechargeMiniView) { this.view = view }
    override fun detach() { view = null }
    fun loginWithAccount(password: String, accountLoginType: Int) {
        view!!.showLoading()
        ModelHelper.loginWithAccount(password, accountLoginType) { ok, num, msg, th ->
            val vv = view ?: return@loginWithAccount
            vv.hideLoading()
            if (ok) { vv.onLoginSuccess(); return@loginWithAccount }
            if (num == -3) vv.showError(CommonUtils.string(R.string.recharge_connect_failure), "")
            else if (th == null && !TextUtils.isEmpty(msg)) vv.showError(msg!!, "")
            else vv.showError(CommonUtils.string(R.string.recharge_fail) + "\n" + msg, "")
        }
    }
    /** Original: z() */
    fun loadRenewCode() { view?.onRenewCode(UserManager.getUsername().ifEmpty { UserManager.getLocalSessionInfo()?.lastUsername ?: "" }) }
}

/**
 * Presenter de cadastro por e-mail. [requestVerifyCode] (corrotina `RegisterEmailPresenter$verify$1`, l.b):
 * se accountLoginType == 1 → `sendCaptcha(contact = email, digitalCode = account.d(), "REGISTER")` (InteractionUtils.t(ddi, email, tipo)),
 * senão `sendCaptcha(email, "", "REGISTER")` (InteractionUtils.s). Resultado: hideLoading; sucesso → onCodeSent (`h()`); -3 → onNetworkError;
 * senão showError(msg, code). Exceção → hideLoading + showError(msg, "").
 * [register] (`RegisterEmailPresenter$register$1`, l.a): `linkContact(email, password, verifyCode, "", "")` (InteractionUtils.t0 → s0 → f.b1);
 * sucesso → onRegistered (`c()`); -3 → onNetworkError; senão onCodeError(msg, code) (`A()`).
 * Nota: os nomes dos callbacks `c()`/`h()` no original são onRegistered/onCodeSent respectivamente.
 * Original: fragment/login/presenter/l.java
 */
class RegisterEmailPresenter : RegisterEmailPresenterContract {
    private var view: RegisterEmailView? = null
    private val io = CoroutineScope(Dispatchers.IO)
    override fun attach(view: RegisterEmailView) { this.view = view }
    override fun detach() { view = null }

    override fun requestVerifyCode(email: String, accountLoginType: Int, account: AccountBean?) {
        io.launch {
            val flow = if (accountLoginType == 1) UserManager.sendCaptcha(email, account?.d() ?: "", "REGISTER")
                       else UserManager.sendCaptcha(email, "", "REGISTER")
            flow.catch { e -> withContext(Dispatchers.Main) { view?.hideLoading(); view?.showError(e.message ?: "", "") } }
                .collect { r ->
                    withContext(Dispatchers.Main) {
                        view?.hideLoading()
                        if (r.first) view?.onCodeSent()
                        else if (r.second == -3) view?.onNetworkError()
                        else view?.showError(r.third ?: "", r.second?.toString() ?: "")
                    }
                }
        }
    }

    override fun register(email: String, accountLoginType: Int, verifyCode: String, password: String, account: AccountBean?) {
        io.launch {
            UserManager.linkContact(email, password, verifyCode, "", "")
                .catch { e -> withContext(Dispatchers.Main) { view?.hideLoading(); view?.showError(e.message ?: "", "") } }
                .collect { r ->
                    withContext(Dispatchers.Main) {
                        view?.hideLoading()
                        if (r.first) view?.onRegistered()
                        else if (r.second == -3) view?.onNetworkError()
                        else view?.onCodeError(r.third ?: "", r.second?.toString() ?: "")
                    }
                }
        }
    }
}

/**
 * Presenter de reset de senha: mesma estrutura do cadastro, com tipo "FORGET" no pedido de código (`ResetPasswordPresenter$verify$1`)
 * e `UserManager.resetPassword(email, "", password, verifyCode)` (InteractionUtils.F0) em `ResetPasswordPresenter$reset$1`;
 * sucesso → onResetSuccess (`G()`); erros do servidor → showError(msg, code).
 * Original: fragment/login/presenter/r.java
 */
class ResetPasswordPresenter : ResetPasswordPresenterContract {
    private var view: ResetPasswordView? = null
    private val io = CoroutineScope(Dispatchers.IO)
    override fun attach(view: ResetPasswordView) { this.view = view }
    override fun detach() { view = null }

    override fun requestVerifyCode(email: String, accountLoginType: Int, account: AccountBean?) {
        io.launch {
            val flow = if (accountLoginType == 1) UserManager.sendCaptcha(email, account?.d() ?: "", "FORGET")
                       else UserManager.sendCaptcha(email, "", "FORGET")
            flow.catch { e -> withContext(Dispatchers.Main) { view?.hideLoading(); view?.showError(e.message ?: "", "") } }
                .collect { r ->
                    withContext(Dispatchers.Main) {
                        view?.hideLoading()
                        if (r.first) view?.onCodeSent()
                        else if (r.second == -3) view?.onNetworkError()
                        else view?.showError(r.third ?: "", r.second?.toString() ?: "")
                    }
                }
        }
    }

    override fun resetPassword(verifyCode: String, email: String, password: String, accountLoginType: Int, phonePreCode: String, countryCode: String) {
        io.launch {
            UserManager.resetPassword(email, "", password, verifyCode)
                .catch { e -> withContext(Dispatchers.Main) { view?.hideLoading(); view?.showError(e.message ?: "", "") } }
                .collect { r ->
                    withContext(Dispatchers.Main) {
                        view?.hideLoading()
                        if (r.first) view?.onResetSuccess()
                        else if (r.second == -3) view?.onNetworkError()
                        else view?.showError(r.third ?: "", r.second?.toString() ?: "")
                    }
                }
        }
    }
}
