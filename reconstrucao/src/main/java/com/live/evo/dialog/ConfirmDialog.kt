package com.live.evo.dialog

import android.app.Dialog
import android.content.Context
import android.text.Html
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import com.live.evo.R

/**
 * Diálogo de confirmação (layout `dialog_confirm`: mensagem `confirmdlg_tv_msg`, botões esquerdo/central/OK).
 * Uso: [ConfirmDialog.show] (2 botões) / [ConfirmDialog.showThree] (3 botões) ou via [Builder]
 * (`d(boolean)` cancelável, `f(Runnable)` ação positiva, `g(String)` mensagem).
 * A mensagem pode conter HTML ([Html.fromHtml]).
 *
 * Original: com/live/evo/dialog/b.java (+ b$e = Builder)
 */
class ConfirmDialog(context: Context) : Dialog(context) {
    private lateinit var message: TextView
    private lateinit var leftButton: Button
    private lateinit var okButton: Button

    /** Original: h(msg, positiveLabel, negativeLabel, onPositive, onNegative, cancelable, ..., ...) */
    fun configure(msg: String?, positive: String?, negative: String?, onPositive: Runnable?, onNegative: Runnable?,
                  cancelable: Boolean, flag1: Boolean, flag2: Boolean) {
        message.text = if (TextUtils.isEmpty(msg)) "" else Html.fromHtml(msg)
        okButton.text = positive; leftButton.text = negative
        okButton.setOnClickListener { dismiss(); onPositive?.run() }
        leftButton.setOnClickListener { dismiss(); onNegative?.run() }
        setCancelable(cancelable)
    }

    /** Original: b.e */
    class Builder(private val context: Context) {
        private var cancelable = true; private var action: Runnable? = null; private var msg: String? = null
        fun cancelable(v: Boolean) = apply { cancelable = v }
        fun onPositive(r: Runnable) = apply { action = r }
        fun message(m: String) = apply { msg = m }
        fun build(): ConfirmDialog = TODO("ver dialog/b.e.c()/i() — monta o diálogo e chama show()")
    }

    companion object {
        /** Original: i(Context, String, String, String, Runnable, Runnable) */
        fun show(context: Context, msg: String?, positive: String?, negative: String?, onPositive: Runnable?, onNegative: Runnable?) {
            TODO("cria ConfirmDialog(context).configure(...).show() — ver dialog/b.i")
        }
        /** Original: j(..., Runnable, Runnable, Runnable) — variante de 3 ações. */
        fun showThree(context: Context, msg: String?, a: String?, b: String?, r1: Runnable?, r2: Runnable?, r3: Runnable?) {
            TODO("ver dialog/b.j")
        }
    }
}
