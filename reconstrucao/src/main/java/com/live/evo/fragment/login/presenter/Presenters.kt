package com.live.evo.fragment.login.presenter

import android.content.Context
import android.text.TextUtils
import com.foxivid.baselib.media.MediaRepository
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

/** Resultado padrão dos fluxos de autenticação do SDK: (sucesso, código, mensagem). Original: `u<Boolean,Integer,String>` (kotlin.Triple-like). */
data class AuthResult(val success: Boolean, val code: Int?, val message: String?)

/**
 * Presenter de login. Fluxo de [login]: view.showLoading(); coleta `MediaRepository.y0(userId, password)` (Flow<AuthResult>):
 * - erro → loga "Auth error" e na main mostra `auth_fail_title[<msg>]` via view.showError;
 * - resultado → hideLoading; sucesso → onLoginSuccess; código -3 → onNetworkError; senão showError("<msg>(<code>)").
 * [loginByRenewalCode]: coleta `MediaRepository.w0(code)` e, se sucesso + `MediaRepository.r0(code)` (ver TODO), trata como sucesso;
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
            MediaRepository.loginWithPassword(userId, password)   // y0(userID, password)
                .catch { e -> logger.error("Auth error", e); withContext(Dispatchers.Main) { view?.showError(CommonUtils.string(R.string.auth_fail_title) + "[" + e.message + "]") } }
                .collect { r ->
                    withContext(Dispatchers.Main) {
                        view?.hideLoading()
                        if (r.success) view?.onLoginSuccess()
                        else if (r.code == -3) view?.onNetworkError()
                        else view?.showError("${r.message}(${r.code})")
                    }
                }
        }
    }

    override fun loadSavedAccount() { view?.onSavedAccount(ModelHelper.savedAccount()) } // s0.p()

    override fun loginByRenewalCode(context: Context, code: String) {
        val v = view ?: return
        v.showLoading()
        io.launch {
            // obj = MediaRepository.w0(code)  (suspend → Flow<AuthResult>)
            // sucesso: if (MediaRepository.r0(code)) { ... }   (corpo exato com decompilação incorreta — TODO)
            TODO("decompilação incorreta em LoginPresenter\$loginByRenewalCode\$1.invokeSuspend: ver presenter/e.java")
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
 * `recharge_fail + "\n" + msg` quando não há mensagem limpa; [loadRenewCode] devolve `MediaRepository.Z()`
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
    fun loadRenewCode() { view?.onRenewCode(MediaRepository.renewCodeOrDefault()) }
}

/**
 * Presenter de cadastro por e-mail (RegisterEmailPresenter.kt). [requestVerifyCode]: se accountLoginType == 1 →
 * `MediaRepository.t(account.d(), email, "REGISTER")` (pelo telefone), senão `MediaRepository.s(email, "REGISTER")`;
 * resultado: hideLoading; sucesso → onCodeSent; -3 → onNetworkError; senão onCodeError(msg, code|""). Exceção → showError(msg, "").
 * [register]: segue o mesmo padrão com onRegistered no sucesso.
 * Original: fragment/login/presenter/l.java
 */
class RegisterEmailPresenter : RegisterEmailPresenterContract {
    private var view: RegisterEmailView? = null
    override fun attach(view: RegisterEmailView) { this.view = view }
    override fun detach() { view = null }
    override fun requestVerifyCode(email: String, accountLoginType: Int, account: AccountBean?) {
        TODO("corrotina RegisterEmailPresenter\$sendVerifyCode (presenter/l.java b): MediaRepository.t/s(...REGISTER...)")
    }
    override fun register(email: String, accountLoginType: Int, verifyCode: String, password: String, account: AccountBean?) {
        TODO("corrotina RegisterEmailPresenter\$register (presenter/l.java a): MediaRepository.register(email, password, verifyCode)")
    }
}

/**
 * Presenter de reset de senha (ResetPasswordPresenter.kt): mesma estrutura do cadastro, com tipo "FORGET"
 * no pedido de código e [ResetPasswordView.onResetSuccess] ao concluir.
 * Original: fragment/login/presenter/r.java
 */
class ResetPasswordPresenter : ResetPasswordPresenterContract {
    private var view: ResetPasswordView? = null
    override fun attach(view: ResetPasswordView) { this.view = view }
    override fun detach() { view = null }
    override fun requestVerifyCode(email: String, accountLoginType: Int, account: AccountBean?) {
        TODO("MediaRepository.t/s(..., \"FORGET\")")
    }
    override fun resetPassword(verifyCode: String, email: String, password: String, accountLoginType: Int, phonePreCode: String, countryCode: String) {
        TODO("MediaRepository.resetPassword(verifyCode, email, password) — presenter/r.java a")
    }
}
