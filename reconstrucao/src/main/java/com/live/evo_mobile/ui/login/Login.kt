package com.live.evo_mobile.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.BaseAdapter
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.foxivid.ui.mobile.base.BaseDataBindActivity
import com.live.evo_mobile.ui.MainViewActivity

/**
 * Activity de login/cadastro da versão mobile: [NoScrollViewPager] com 4 páginas
 * (0 = escolha do tipo de login [LoginEntryFragment], 1 = [LoginAccountFragment] (e-mail/telefone),
 * 2 = [CreateAccountFragment], 3 = [ResetPasswordFragment]). Extra `loginFrom`:
 * LOGIN_FROM_START (0, vindo da Splash), LOGIN_FROM_ACCOUNT (1), LOGIN_FROM_ME_ICON (2, Perfil), LOGIN_FROM_PLAYER (3).
 * Navegação por pilha `stepRecord` ([goToPage]/[onBackStep]); Back no início (`LOGIN_FROM_START`) pergunta `quit_tip` e sai;
 * em outros casos `finish()`. [onLoginDone] (Y): se veio da Splash abre [MainViewActivity]; sempre finish.
 * Esconde o teclado ao tocar fora de um EditText ([dispatchTouchEvent]/[shouldHideKeyboard] = U(v, event)).
 * `onCreate` é `native` (Jiagu) — inferência: infla `z4.a`, monta o adapter `t0`, lê `loginFrom`, registra `stepRecord = [0]`.
 *
 * Original: com/live/evo_mobile/ui/login/LoginTypeActivity.java
 */
class LoginTypeActivity : BaseDataBindActivity() {
    private val LOGIN_FROM_START = 0
    private val LOGIN_FROM_ACCOUNT = 1
    private val LOGIN_FROM_ME_ICON = 2
    private val LOGIN_FROM_PLAYER = 3
    private var loginFrom = -1
    private var currentPage = 0
    private val stepRecord = ArrayList<Int>()
    private var email: String? = null; private var phone: String? = null; private var preCode: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // INFERIDO (onCreate nativo): origem da tela (extra `loginFrom`, padrão LOGIN_FROM_START) e pilha de passos começando na
        // página 0; o DataBinding `z4.a` e o adapter de páginas `t0` não estão reconstruídos (ver KDoc da classe).
        loginFrom = intent.getIntExtra("loginFrom", LOGIN_FROM_START)
        stepRecord.clear()
        stepRecord.add(0)
    }

    /** Original: Z(int index, boolean skipRecord) */
    private fun goToPage(index: Int, skipRecord: Boolean = false) {
        if (!skipRecord) { if (index == 0) stepRecord.clear(); stepRecord.add(index) }
        currentPage = index
        // binding.viewPager.setCurrentItem(index, false)
    }
    /** Original: X() — volta um passo da pilha. */
    fun onBackStep() {
        if (stepRecord.isEmpty() || stepRecord.size == 1) { onFinishRequested(); return }
        stepRecord.removeAt(stepRecord.size - 1)
        goToPage(stepRecord.last(), true)
    }
    /** Original: W() */
    fun onFinishRequested() { if (loginFrom == LOGIN_FROM_START) confirmQuit() else finish() }
    /** Original: Y() */
    fun onLoginDone() { if (loginFrom == LOGIN_FROM_START) startActivity(Intent(this, MainViewActivity::class.java)); finish() }
    /** Original: T() */ fun isFromStart() = loginFrom == LOGIN_FROM_START
    /** Original: c0() */ fun toLoginType() = goToPage(0)
    /** Original: d0() — vai para LoginAccount no modo "código". */ fun toCodeLogin() { goToPage(1) }
    /** Original: b0() — vai para LoginAccount no modo "scan". */ fun toScanLogin() { goToPage(1) }
    /** Original: toCreateAccount(View) */ fun toCreateAccount(@Suppress("UNUSED_PARAMETER") v: android.view.View?) { goToPage(2) }
    /** Original: e0(String email) / f0(String phone, String preCode) — passam o identificador para a tela de reset. */
    fun toResetPassword(email: String?) { this.email = email; goToPage(3) }
    fun toResetPassword(phone: String, preCode: String) { this.phone = phone; this.preCode = preCode; goToPage(3) }
    /** Original: I() — diálogo de saída (`quit_tip`) */
    private fun confirmQuit() { /* v7.c(getString(quit_tip)) { finishAffinity() } */ }
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean = super.dispatchTouchEvent(ev)
    override fun dispatchKeyEvent(event: KeyEvent): Boolean = super.dispatchKeyEvent(event)
}

/** ViewPager que ignora gestos de swipe. Original: com/live/evo_mobile/ui/login/NoScrollViewPager.java */
class NoScrollViewPager @JvmOverloads constructor(context: android.content.Context, attrs: android.util.AttributeSet? = null) : ViewPager(context, attrs) {
    override fun onInterceptTouchEvent(ev: MotionEvent?) = false
    override fun onTouchEvent(ev: MotionEvent?) = false
}

/** Adapter de páginas do [LoginTypeActivity] (`com.tvc.lib.mobile.ui.base.f`). Original: com/live/evo_mobile/ui/login/t0.java */
class LoginViewPagerAdapter(val fragments: List<Fragment>)

/**
 * Página 0: escolha do tipo de login (botões: e-mail/telefone, código de renovação, escanear, criar conta...).
 * Original: com/live/evo_mobile/ui/login/s0.java (z4.q0; 5 click listeners f0..j0 chamam os métodos `toXxx` da Activity)
 */
class LoginEntryFragment

/**
 * Login por conta com abas TAB_EMAIL/TAB_PHONE (`currentTab`), mostrar/ocultar senha por aba (`pwdShowForEmail`),
 * dicas `email_login_tip2`/`phone_login_tip2`, erro `login_failed`. Chama `MediaRepository` (login com senha) →
 * `LoginTypeActivity.onLoginDone()`. `U0()`/`T0()`: modos código/scan usados por `LoginTypeActivity.d0()/b0()`.
 * Original: com/live/evo_mobile/ui/login/k0.java (LoginAccountFragment.kt)
 */
class LoginAccountFragment

/**
 * Criar conta (e-mail ou telefone, abas TAB_EMAIL/TAB_PHONE): botão `send_code`, textos `email_normal_register_remind`/
 * `phone_normal_register_remind`, valida código e registra → `onLoginDone`. Original: com/live/evo_mobile/ui/login/u.java (CreateAccountFragment.kt)
 */
class CreateAccountFragment

/**
 * Redefinir senha (e-mail/telefone, `preCode`): `send_code`, `account_empty`, `user_no_correct`. Após sucesso volta ao login.
 * Original: com/live/evo_mobile/ui/login/g1.java (ResetPasswordFragment.kt)
 */
class ResetPasswordFragment

/** Modelo de conta digitada (accountStr, emailStr, phoneStr, phonePreCode). Original: com/live/evo_mobile/ui/login/a.java */
data class LoginAccountInput(val accountStr: String?, val emailStr: String?, val phoneStr: String?, val phonePreCode: String?)

/** Código de país (phonePreCode, countryCode, countryShowName). Original: com/live/evo_mobile/ui/login/c.java */
data class CountryCode(val phonePreCode: String, val countryCode: String, val countryShowName: String)

/**
 * Adapter da lista de países (spinner): cada item mostra `phonePreCode(countryShowName)` no TextView `area_code` (layouts
 * `account_area_item_select` e, no dropdown, `account_area_item_select_drop`), com ViewHolder guardado em `tag`.
 * Original: com/live/evo_mobile/ui/login/b.java (nome real AreaSpinnerAdapter, com ViewHolder interno `a`)
 */
class CountryCodeAdapter(private val ctx: android.content.Context, private val dataList: List<CountryCode>) : BaseAdapter() {
    private val li: android.view.LayoutInflater = android.view.LayoutInflater.from(ctx)

    /** Original: b.a */
    inner class ViewHolder(view: android.view.View) {
        val areaCode: android.widget.TextView = view.findViewById(com.live.evo.R.id.area_code)
        init { view.setTag(this) }
    }

    override fun getCount() = dataList.size
    override fun getItem(position: Int) = dataList[position]
    override fun getItemId(position: Int) = position.toLong()

    private fun bind(layoutId: Int, position: Int, convertView: android.view.View?): android.view.View {
        val view = convertView ?: android.view.View.inflate(ctx, layoutId, null).also { ViewHolder(it) }
        (view.tag as ViewHolder).areaCode.text = getItem(position).phonePreCode + "(" + getItem(position).countryShowName + ")"
        return view
    }

    override fun getDropDownView(position: Int, convertView: android.view.View?, parent: android.view.ViewGroup?): android.view.View =
        bind(com.live.evo.R.layout.account_area_item_select_drop, position, convertView)

    override fun getView(position: Int, convertView: android.view.View?, parent: android.view.ViewGroup?): android.view.View =
        bind(com.live.evo.R.layout.account_area_item_select, position, convertView)
}
