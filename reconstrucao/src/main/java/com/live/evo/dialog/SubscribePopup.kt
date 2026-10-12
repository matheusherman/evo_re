package com.live.evo.dialog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.live.evo.R
import com.live.evo.model.SubscribeBean
import com.live.evo.util.CommonUtils
import com.live.evo.util.DateUtils
import com.live.evo.util.GlideImageLoader
import com.live.evo.widget.BaseButton
import com.live.evo.widget.BaseDialog
import java.util.Timer
import java.util.TimerTask

/**
 * Popup "programa agendado vai começar" (layout `popup_subscribe`): ícone, "HH:mm--HH:mm", nome do programa,
 * botões "assistir" / "ignorar" e contagem regressiva até o fim do programa (se já passou, 20 s).
 * - Assistir: fecha e `listener.onWatch(channelIndex)` ([Listener.b]);
 * - Ignorar ou fim da contagem: `listener.onIgnore()` ([Listener.a]).
 * Contagem atualizada por Timer a cada 1 s; texto `mm:ss` (ou `hh:mm:ss` >= 1 h).
 *
 * Original: com/live/evo/dialog/u.java
 */
class SubscribePopup(private val context: Context, private val listener: Listener?) {
    /** Original: u.a */
    interface Listener { /** a() */ fun onIgnore(); /** b(int) */ fun onWatch(channelIndex: Int) }

    private val view: View = LayoutInflater.from(context).inflate(R.layout.popup_subscribe, null)
    private val dialog = BaseDialog(context, R.style.RechargeAlertialog)
    private val icon: ImageView = view.findViewById(R.id.popupsubscribe_iv_icon)
    private val timeText: TextView = view.findViewById(R.id.popupsubscribe_tv_time)
    private val programText: TextView = view.findViewById(R.id.popupsubscribe_mtv_program)
    private val watchButton: BaseButton = view.findViewById(R.id.popupsubscribe_btn_watch)
    private val ignoreButton: BaseButton = view.findViewById(R.id.popupsubscribe_btn_ignore)
    private val countText: TextView = view.findViewById(R.id.popupsubscribe_tv_timecount)
    private var channelIndex = 0
    private var handled = false
    private var secondsLeft = -1
    private var timer: Timer? = null
    private var task: TimerTask? = null

    init {
        dialog.setContentView(view)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        countText.visibility = View.INVISIBLE
        watchButton.setOnClickListener { handled = true; if (dialog.isShowing) dialog.dismiss(); listener?.onWatch(channelIndex) }  // n(View)
        ignoreButton.setOnClickListener { handled = true; if (dialog.isShowing) dialog.dismiss(); listener?.onIgnore() }             // o(View)
    }

    /** Preenche com a assinatura. Original: p(i5.c0) */
    fun setSubscribe(bean: SubscribeBean) {
        handled = false
        channelIndex = bean.channelIndex
        val start = DateUtils.format(bean.startTime, "HH:mm")
        val stop = DateUtils.format(bean.endTime(), "HH:mm")
        GlideImageLoader.load(context, bean.channelIcon(), icon)
        programText.text = bean.title.takeUnless { it.isNullOrEmpty() } ?: CommonUtils.string(R.string.epg_none)
        timeText.text = "$start--$stop"
        secondsLeft = ((bean.endTime() - DateUtils.now()) / 1000).toInt()
        if (secondsLeft <= 0) secondsLeft = 20
        countText.text = countdownText()
    }

    /** Alias. Original: p(i5.c0) */
    fun setData(bean: SubscribeBean) = setSubscribe(bean)

    /** Original: k() */
    fun countdownText(): String {
        val s = secondsLeft
        return if (s > 0) {
            if (s < 3600) String.format("%1$02d:%2$02d", s / 60, s % 60)
            else String.format("%1$02d:%2$02d:%3$02d", s / 3600, (s % 3600) / 60, s % 60)
        } else "00:00"
    }

    /** Original: q() — mostra e inicia contagem. */
    fun show() { if (!dialog.isShowing) dialog.show(); startTimer() }
    /** Original: j() — se não houve ação e está aberto, fecha. */
    fun dismiss() { stopTimer(); if (handled && dialog.isShowing) dialog.dismiss() }
    fun isShowing() = dialog.isShowing

    private fun startTimer() {
        stopTimer()
        timer = Timer()
        task = object : TimerTask() {
            override fun run() {
                secondsLeft--
                // (original atualiza o TextView; fora da UI thread no código decompilado)
                if (secondsLeft <= 0) { handled = true; dialog.dismiss(); listener?.onIgnore() }
            }
        }
        timer!!.schedule(task, 0L, 1000L)
    }
    private fun stopTimer() { timer?.cancel(); timer = null; task?.cancel(); task = null }
}
