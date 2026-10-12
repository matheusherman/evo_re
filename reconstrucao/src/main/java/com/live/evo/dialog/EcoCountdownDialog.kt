package com.live.evo.dialog

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.live.evo.AppUserManager
import com.live.evo.R
import com.live.evo.util.DateFormatFactory
import com.live.evo.util.SecondTicker
import com.live.evo.util.SkinConfig
import com.live.evo.widget.BaseDialog
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import org.slf4j.LoggerFactory
import java.util.Date

/**
 * Diálogo "modo ECO / ainda está assistindo?" (layout `countdown_layout_d`): contagem regressiva `mm:ss`
 * (duração: propriedade remota `remind_time_continue` ou padrão de AppConfig; 10 s se flag de debug) com os
 * textos remotos `start_remind_word`/`stop_remind_word`. Ao zerar: callback(3), anima o papel de parede do skin
 * (fade 2 s) e mostra botões. Botões: OK → callback(0) + fecha; cancelar → callback(1) + cancel;
 * qualquer tecla antes de zerar → callback(4) + fecha. Back só vale após zerar.
 *
 * Original: com/live/evo/dialog/c.java (usa [SecondTicker] = util.m1)
 */
class EcoCountdownDialog(private val ctx: Context, theme: Int = R.style.RechargeAlertialog2) : BaseDialog(ctx, theme), View.OnClickListener {
    /** Original: c.c — a(int): 0 = continuar, 1 = cancelar, 3 = tempo esgotado, 4 = tecla pressionada */
    interface Callback { fun onResult(code: Int) }

    private val logger = LoggerFactory.getLogger(EcoCountdownDialog::class.java)
    private var callback: Callback? = null
    private var counting = true
    private var ticker: Disposable? = null
    private val fmt = DateFormatFactory.create("mm:ss")
    private lateinit var timeText: TextView; private lateinit var sure: Button; private lateinit var cancelBtn: Button
    private lateinit var btnParent: LinearLayout; private lateinit var wallpaper: ImageView
    private lateinit var stopText: TextView; private lateinit var startText: TextView; private lateinit var line: View

    fun setCallback(c: Callback?) { callback = c }  // e(c)

    /** Mostra mm:ss. Original: g(long seconds) */
    fun showTime(seconds: Long) { timeText.text = fmt.format(Date(seconds * 1000)) }

    /** Contagem terminou. Original: f() */
    fun onFinished() {
        ticker?.takeIf { !it.isDisposed }?.dispose()
        counting = false
        callback?.onResult(3)
        stopText.visibility = View.VISIBLE; btnParent.visibility = View.VISIBLE; line.visibility = View.VISIBLE
        SkinConfig.get()  // wallpaper.background = SkinConfig.n()
        wallpaper.visibility = View.VISIBLE
        sure.requestFocus()
        AnimatorSet().apply { playTogether(ObjectAnimator.ofFloat(wallpaper, "alpha", 0f, 1f), ObjectAnimator.ofFloat(stopText, "alpha", 0f, 1f)); duration = 2000L }.start()
        AnimatorSet().apply { duration = 500L; playTogether(ObjectAnimator.ofFloat(startText, "alpha", 1f, 0f), ObjectAnimator.ofFloat(timeText, "alpha", 1f, 0f)) }.start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.countdown_layout_d)
        timeText = findViewById(R.id.countdownl_tv_time_countdown); sure = findViewById(R.id.countdownl_btn_sure)
        cancelBtn = findViewById(R.id.countdownl_btn_cancel); btnParent = findViewById(R.id.countdownl_ll_btn_parent)
        wallpaper = findViewById(R.id.countdownl_iv_wallpapers); stopText = findViewById(R.id.countdownl_tv_remind_stop)
        startText = findViewById(R.id.countdownl_tv_remind_start); line = findViewById(R.id.countdownl_view_line)
        sure.setOnClickListener(this); cancelBtn.setOnClickListener(this)
        val um = AppUserManager.get()
        startText.text = um.getString("start_remind_word", ctx.getString(R.string.tv_start_remind).replace("\\n", "\n"))
        var ms = com.live.evo.AppConstants.MIN10   // a.f5191k (k = 10 min)
        val remote = um.getLong("remind_time_continue", ms)
        if (remote > 0) ms = remote
        // if (y4.a.f22397a) ms = 10000   // flag de debug do SDK
        val left = intArrayOf((ms / 1000).toInt())
        ticker = SecondTicker.subscribe(
            { left[0]--; try { showTime(left[0].toLong()) } catch (e: Exception) { logger.error("eoc failure", e) }; if (left[0] < 0) onFinished() },
            { logger.error("eco count down failure", it) }, AndroidSchedulers.mainThread())
        stopText.text = um.getString("stop_remind_word", ctx.getString(R.string.tv_stop_remind))
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.countdownl_btn_cancel -> { callback?.onResult(1); cancel() }
            R.id.countdownl_btn_sure -> { ticker?.takeIf { !it.isDisposed }?.dispose(); callback?.onResult(0); dismiss() }
        }
    }
    override fun onBackPressed() { if (counting) super.onBackPressed() }
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (counting) { ticker?.takeIf { !it.isDisposed }?.dispose(); callback?.onResult(4); dismiss() }
        return super.onKeyDown(keyCode, event)
    }
}
