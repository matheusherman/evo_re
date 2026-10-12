package com.live.evo.fragment.login

import android.os.Bundle
import android.os.CountDownTimer
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.foxivid.baselib.media.MediaRepository
import com.live.evo.AppUserManager
import com.live.evo.R
import com.live.evo.util.CommonUtils
import java.util.concurrent.TimeUnit

/**
 * Tela de boas-vindas (primeira abertura): logo, texto `welcome_remind` (com N dias de teste do SDK) e
 * `welcome_to_tvexpress` (com ${AppName}); botão pisca (AlphaAnimation 0.5→1.0, 1,5 s, reverso/infinito).
 * Clique → `callback(this)`. Tag "WelcomeFragment".
 * Original: com/live/evo/fragment/login/w.java
 */
class WelcomeFragment : Fragment(), View.OnClickListener {
    private var callback: ((Fragment) -> Unit)? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.welcome_fragment, container, false)
        // l(): welcome_remind(trialDays) e welcome_to_tvexpress.replace("${AppName}", app_name)
        v.findViewById<Button>(R.id.welcomef_btn_watch)?.apply {
            requestFocus(); setOnClickListener(this@WelcomeFragment)
            animation = AlphaAnimation(0.5f, 1.0f).apply { repeatMode = 2; repeatCount = -1; duration = 1500L }
        }
        return v
    }
    override fun onClick(v: View) { callback?.invoke(this) }
    companion object {
        private const val TAG = "WelcomeFragment"
        /** Original: U(FragmentManager, int, i) */
        fun show(fm: FragmentManager, containerId: Int, onDone: (Fragment) -> Unit) {
            fm.beginTransaction().add(containerId, WelcomeFragment().also { it.callback = onDone }, TAG).commitAllowingStateLoss()
        }
    }
}

/**
 * Aviso de conteúdo adulto: textos remotos `attention_remind_one` (os dois campos usam a mesma chave no original —
 * possível bug) com fallbacks `attention_remind_1/2`; botões Entrar (esconde e `next()`) e Sair (esconde e `onExit()`).
 * Original: com/live/evo/fragment/login/d.java
 */
class AdultWarningFragment : Fragment(), View.OnClickListener {
    interface Listener { fun onExit(); fun next() }
    private var listener: Listener? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.adult_warning_fragment, container, false)
        v.findViewById<TextView>(R.id.adultwarningf_tv_remind1).text = Html.fromHtml(AppUserManager.get().getString("attention_remind_one", CommonUtils.string(R.string.attention_remind_1)))
        v.findViewById<TextView>(R.id.adultwarningf_tv_remind2).text = Html.fromHtml(AppUserManager.get().getString("attention_remind_one", CommonUtils.string(R.string.attention_remind_2)))
        v.findViewById<Button>(R.id.adultwarningf_btn_enter).apply { requestFocus(); setOnClickListener(this@AdultWarningFragment) }
        v.findViewById<Button>(R.id.adultwarningf_btn_exit).setOnClickListener(this)
        return v
    }
    override fun onClick(v: View) {
        when (v.id) {
            R.id.adultwarningf_btn_enter -> if (listener != null) { parentFragmentManager.beginTransaction().hide(this).commitAllowingStateLoss(); listener!!.next() }
            R.id.adultwarningf_btn_exit -> if (listener != null) { parentFragmentManager.beginTransaction().hide(this).commitAllowingStateLoss(); listener!!.onExit() }
        }
    }
    companion object {
        /** Original: U(FragmentManager, int, a) — tag = nome simples da classe */
        fun show(fm: FragmentManager, containerId: Int, l: Listener) {
            val f = AdultWarningFragment().also { it.listener = l }
            fm.beginTransaction().add(containerId, f, f.javaClass.simpleName).commitAllowingStateLoss()
        }
    }
}

/**
 * Tela de conclusão de login/cadastro/recarga. Argumento `arg_remind_type`:
 * 0 recarga ok (`recharge_success` + validade `l.n().m()`), 3/5 cadastro (`register_success`, `remind_register`),
 * 6 reset de senha (`reset_pwd`), 7/10 cadastro com recarga (mostra contagem regressiva `to_recharge (Ns)`, 120 s, via
 * [CountDownTimer] que ao final dispara o callback), 8 bind de código (`renew_code_bind_success`), 9 primeiro login com
 * renewal code (mostra o código + `renewal_code_first_time_login_remind1/2`). Botão "watch_now" → callback(this).
 * Tag "LoginFinishFragment_TAG".
 * Original: com/live/evo/fragment/login/h.java
 */
class LoginFinishFragment : Fragment(), View.OnClickListener {
    private var callback: ((Fragment) -> Unit)? = null
    private var timer: CountDownTimer? = null
    private lateinit var button: Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.login_finish_fragment, container, false)
        button = v.findViewById(R.id.loginfinishf_btn_watch)
        button.requestFocus()
        button.setOnClickListener(this)
        // W(): switch(arg_remind_type) preenche textos (ver KDoc)
        return v
    }
    override fun onClick(v: View) { callback?.invoke(this) }
    private fun startCountdown(ms: Long) {
        timer = object : CountDownTimer(ms, 1000L) {
            override fun onFinish() { callback?.invoke(this@LoginFinishFragment) }
            override fun onTick(left: Long) { button.text = CommonUtils.string(R.string.to_recharge) + "(" + TimeUnit.MILLISECONDS.toSeconds(left) + "s)" }
        }.also { it.start() }
    }
    override fun onStop() { super.onStop(); timer?.cancel() }
    companion object {
        /** Original: X(FragmentManager, int container, int remindType, b) */
        fun show(fm: FragmentManager, containerId: Int, remindType: Int, onDone: (Fragment) -> Unit) {
            val f = LoginFinishFragment().apply { arguments = Bundle().apply { putInt("arg_remind_type", remindType) }; callback = onDone }
            fm.beginTransaction().add(containerId, f, "LoginFinishFragment_TAG").commitAllowingStateLoss()
        }
    }
}

/**
 * Conclusão "mini" da recarga (layout `login_finish_fragment_mini`): "remind_recharge_successfully" + validade
 * `MediaRepository.H()` formatada com `valid_until`. Tag "RechargeSuccessminiFragment".
 * Original: com/live/evo/fragment/login/n.java
 */
class LoginFinishMiniFragment : Fragment(), View.OnClickListener {
    private var callback: ((Fragment) -> Unit)? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.login_finish_fragment_mini, container, false).also { it.findViewById<Button>(R.id.loginfinishminif_btn_ok)?.apply { requestFocus(); setOnClickListener(this@LoginFinishMiniFragment) } }
    override fun onClick(v: View) { callback?.invoke(this) }
    companion object {
        fun show(fm: FragmentManager, containerId: Int, onDone: (Fragment) -> Unit) {
            fm.beginTransaction().add(containerId, LoginFinishMiniFragment().also { it.callback = onDone }, "RechargeSuccessminiFragment").commitAllowingStateLoss()
        }
    }
}

/**
 * Tela "compartilhe seu código" (layout `sharecode_info_fragment`): gera QR com URL
 * `https://share-code-h5-tvebr.tomatoto.xyz?sh=<test>&a=<MediaRepository.Y()>&r=evo` (+ idioma pt/en/es),
 * textos `share_code_tip_title`/`share_code_remind`. Tag "ShareCodeInfoFragment".
 * Original: com/live/evo/fragment/login/v.java (base BaseFragment `fragment.c`)
 */
class ShareCodeInfoFragment : com.live.evo.fragment.BaseFragment(), View.OnClickListener {
    private var callback: ((Fragment) -> Unit)? = null
    /** Monta a query do QR. Original: b0(String url, String share) */
    fun buildShareUrl(url: String, share: String): String {
        if (url.isEmpty() || share.isEmpty()) return ""
        val base = if (url.endsWith("?")) url else "$url?"
        return base + "sh=" + share + "&a=" + java.net.URLEncoder.encode(MediaRepository.appId(), "utf-8") + "&r=" + java.net.URLEncoder.encode("evo", "utf-8")
    }
    override fun onClick(v: View) { callback?.invoke(this) }
    companion object {
        fun show(fm: FragmentManager, containerId: Int, onDone: (Fragment) -> Unit) {
            fm.beginTransaction().add(containerId, ShareCodeInfoFragment().also { it.callback = onDone }, "ShareCodeInfoFragment").commitAllowingStateLoss()
        }
    }
}

/** Tela de informação BFF (`bffinfo_fragment`; `bff_request_time`). Tag "BffInfoFragment". Original: com/live/evo/fragment/login/e.java */
class BffInfoFragment : com.live.evo.fragment.BaseFragment(), View.OnClickListener {
    private var callback: ((Fragment) -> Unit)? = null
    override fun onClick(v: View) { callback?.invoke(this) }
    companion object {
        fun show(fm: FragmentManager, containerId: Int, type: Int, onDone: (Fragment) -> Unit) {
            fm.beginTransaction().add(containerId, BffInfoFragment().also { it.callback = onDone }, "BffInfoFragment").commitAllowingStateLoss()
        }
    }
}

/**
 * Dica para vincular conta (`fragment_bindaccount_tip`): botões que chamam `listener.a(fragment, escolha)`;
 * Back tratado ([LoginNavigator.BackHandler]). Tag "BindAccountTipFragment". Original: com/live/evo/fragment/login/f.java
 */
class BindAccountTipFragment : com.live.evo.fragment.BaseFragment(), View.OnClickListener, LoginNavigator.BackHandler {
    interface Listener { fun a(f: Fragment, choice: Int) }
    private var listener: Listener? = null
    override fun handleBack(): Boolean = TODO("ver login/f.H()")
    override fun onClick(v: View) { TODO("ver login/f.onClick: listener.a(this, 0|1)") }
    companion object {
        fun show(fm: FragmentManager, containerId: Int, l: Listener) {
            val f = BindAccountTipFragment().also { it.listener = l }
            val existing = fm.findFragmentByTag("BindAccountTipFragment")
            if (existing == null) fm.beginTransaction().add(containerId, f, "BindAccountTipFragment").commitAllowingStateLoss()
            else fm.beginTransaction().show(existing).commitAllowingStateLoss()
        }
    }
}
