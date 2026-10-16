package com.live.evo.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.text.Html
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.live.evo.R
import com.live.evo.util.LoginConfig
import com.live.evo.util.TextStyleUtils

/**
 * Diálogo de confirmação (layout `dialog_confirm`, estilo `ConfirmDialog`: mensagem `confirmdlg_tv_msg`, botão OK
 * `confirmdlg_btn_ok` (positivo) e `confirmdlg_btn_cancel` (negativo)).
 * Uso: [ConfirmDialog.show] (2 botões, não cancelável) / [ConfirmDialog.showThree] (com ação ao fechar) ou via [Builder].
 * A mensagem pode conter HTML ([Html.fromHtml]). Foco inicial: OK (modo [FOCUS_POSITIVE]) ou cancelar ([FOCUS_NEGATIVE]).
 * `dismiss()` executa o Runnable "on dismiss" (`f5663g`).
 *
 * Original: com/live/evo/dialog/b.java (+ b$e = Builder)
 */
class ConfirmDialog(private val ctx: Context) : Dialog(ctx, R.style.ConfirmDialog) {
    private val message: TextView
    private val okButton: Button
    private val cancelButton: Button
    private var focusMode = FOCUS_POSITIVE
    private var onDismiss: Runnable? = null

    init {
        setContentView(R.layout.dialog_confirm)
        message = findViewById(R.id.confirmdlg_tv_msg)
        okButton = findViewById(R.id.confirmdlg_btn_ok)
        cancelButton = findViewById(R.id.confirmdlg_btn_cancel)
        if (LoginConfig.get().flagA()) {   // com.live.evo.util.e.b().a()
            TextStyleUtils.c(message); TextStyleUtils.b(okButton); TextStyleUtils.b(cancelButton)
        } else {
            TextStyleUtils.c(message); TextStyleUtils.d(okButton); TextStyleUtils.d(cancelButton)
        }
    }

    /**
     * Configura e mostra. [showPositive]/[showNegative] controlam a visibilidade dos botões; [cancelable] vale para BACK/toque fora.
     * Original: g(msg, positive, negative, onPositive, onNegative, onDismiss, showPositive, showNegative, cancelable) / h(...)
     */
    fun configure(msg: String?, positive: String?, negative: String?, onPositive: Runnable?, onNegative: Runnable?,
                  showPositive: Boolean, showNegative: Boolean, cancelable: Boolean, onDismiss: Runnable? = null) {
        setCancelable(cancelable)
        this.onDismiss = onDismiss
        message.text = msg
        okButton.text = positive; cancelButton.text = negative
        okButton.setOnClickListener { dismiss(); onPositive?.run() }
        cancelButton.setOnClickListener { dismiss(); onNegative?.run() }
        okButton.visibility = if (showPositive) View.VISIBLE else View.GONE
        cancelButton.visibility = if (showNegative) View.VISIBLE else View.GONE
        show()
        (if (focusMode == FOCUS_POSITIVE) okButton else cancelButton).requestFocus()
    }

    /** Original: h(msg, positive, negative, onPositive, onNegative, showPositive, showNegative, cancelable) → g(..., null, ...) */
    fun show(msg: String?, positive: String?, negative: String?, onPositive: Runnable?, onNegative: Runnable?,
             showPositive: Boolean, showNegative: Boolean, cancelable: Boolean) =
        configure(msg, positive, negative, onPositive, onNegative, showPositive, showNegative, cancelable, null)

    override fun show() {
        super.show()
        (if (focusMode == FOCUS_POSITIVE) okButton else cancelButton).requestFocus()
    }
    override fun dismiss() { super.dismiss(); onDismiss?.run() }

    /** Original: b.e — botão 1 (OK) = `positive`, botão 2 (cancel) = `negative`. */
    class Builder(private val context: Context) {
        private var positiveLabel: String? = null
        private var negativeLabel: String? = null
        private var msg: String? = null
        private var positiveListener: DialogInterface.OnClickListener? = null
        private var negativeListener: DialogInterface.OnClickListener? = null
        private var onDismiss: Runnable? = null
        private var showPositive = true
        private var showNegative = true
        private var cancelable = true
        private var focus = FOCUS_POSITIVE
        /** Original: h(String, OnClickListener) */ fun positive(label: String?, l: DialogInterface.OnClickListener?) = apply { positiveLabel = label; positiveListener = l }
        /** Original: e(String, OnClickListener) */ fun negative(label: String?, l: DialogInterface.OnClickListener?) = apply { negativeLabel = label; negativeListener = l }
        /** Original: d(boolean) */ fun cancelable(v: Boolean) = apply { cancelable = v }
        /** Original: f(Runnable) — executado ao fechar. */ fun onDismiss(r: Runnable?) = apply { onDismiss = r }
        /** Original: g(String) */ fun message(m: String?) = apply { msg = m }
        /** Cria o diálogo sem mostrar. Original: c() */
        fun build(): ConfirmDialog {
            val d = ConfirmDialog(context)
            d.onDismiss = onDismiss
            d.message.text = if (TextUtils.isEmpty(msg)) "" else Html.fromHtml(msg)
            if (showPositive) { d.okButton.text = positiveLabel; d.okButton.setOnClickListener { positiveListener?.onClick(d, FOCUS_POSITIVE) } }
            else d.okButton.visibility = View.GONE
            if (showNegative) { d.cancelButton.text = negativeLabel; d.cancelButton.setOnClickListener { negativeListener?.onClick(d, FOCUS_NEGATIVE) } }
            else d.cancelButton.visibility = View.GONE
            d.focusMode = focus
            return d
        }
        /** Cria e mostra. Original: i() */ fun show(): ConfirmDialog = build().also { it.show() }
    }

    companion object {
        const val FOCUS_POSITIVE = 0   // b.f5655h
        const val FOCUS_NEGATIVE = 1   // b.f5656i

        /** Original: i(Context, msg, positive, negative, onPositive, onNegative) → j(..., null) */
        fun show(context: Context, msg: String?, positive: String?, negative: String?, onPositive: Runnable?, onNegative: Runnable?) =
            showThree(context, msg, positive, negative, onPositive, onNegative, null)

        /**
         * Original: j(Context, msg, positive, negative, onPositive, onNegative, onDismiss) — não cancelável; cada botão
         * fecha o diálogo e depois roda a ação.
         */
        fun showThree(context: Context, msg: String?, positive: String?, negative: String?, onPositive: Runnable?, onNegative: Runnable?, onDismiss: Runnable?) {
            Builder(context)
                .positive(positive) { d, _ -> d.dismiss(); onPositive?.run() }
                .negative(negative) { d, _ -> d.dismiss(); onNegative?.run() }
                .onDismiss(onDismiss).message(msg).cancelable(false).show()
        }
    }
}
