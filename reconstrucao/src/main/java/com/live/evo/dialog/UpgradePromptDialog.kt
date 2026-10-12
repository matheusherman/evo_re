package com.live.evo.dialog

import android.app.Dialog
import android.content.Context
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.live.evo.R

/**
 * Diálogo de atualização do app (layout `layout_upgrade_prompt_a`): texto, botões OK/Cancelar, barra de download
 * (`pb_downloading`, `tv_progress`), seleção "update_select" e mensagem. Tela cheia, não cancelável.
 * BACK/ESC solto: se o listener está em modo `type == MANDATORY(1)` (f5804n), abre [ExitDialog] ("deseja sair?");
 * se `type == OPTIONAL(0)` (f5803m) fecha e chama `listener.c(this)`.
 *
 * Original: com/live/evo/dialog/y.java
 */
class UpgradePromptDialog(private val ctx: Context, theme: Int) : Dialog(ctx, theme), View.OnKeyListener {
    /** Original: y.e (interface); y.d = implementação base com `d()` = MANDATORY. */
    interface ListenerContract { fun a(); fun b(d: UpgradePromptDialog); fun c(d: UpgradePromptDialog); fun d(): Int }
    /** Original: y.d */
    open class Listener : ListenerContract {
        override fun a() {}
        override fun b(d: UpgradePromptDialog) {}
        override fun c(d: UpgradePromptDialog) {}
        override fun d(): Int = MANDATORY
    }

    private var listener: ListenerContract? = null
    private val view: View = LayoutInflater.from(ctx).inflate(R.layout.layout_upgrade_prompt_a, null)
    private val text: TextView = view.findViewById(R.id.upgrade_text)
    private val okButton: Button = view.findViewById(R.id.btn_ok)
    private val cancelButton: Button = view.findViewById(R.id.btn_cancel)
    private val select: TextView = view.findViewById(R.id.tv_update_select)

    init {
        window!!.attributes = window!!.attributes.also { it.gravity = 55; it.width = -1; it.height = -1 }
        window!!.decorView.setPadding(0, 0, 0, 0)
        setCancelable(false); setCanceledOnTouchOutside(false)
        setContentView(view)
        okButton.requestFocus()
        okButton.setOnKeyListener(this); cancelButton.setOnKeyListener(this)
        okButton.setOnClickListener { listener?.b(this) }
        cancelButton.setOnClickListener { listener?.c(this); hide() }
        view.findViewById<View>(R.id.pb_parents).visibility = View.GONE
    }

    /** Define visibilidade e textos dos botões e do seletor. Original: d(int,int,int,String,String,String) */
    fun setButtons(okVisibility: Int, cancelVisibility: Int, selectVisibility: Int, okText: String?, cancelText: String?, selectText: String?) {
        okButton.visibility = okVisibility; cancelButton.visibility = cancelVisibility; select.visibility = selectVisibility
        okButton.text = okText; cancelButton.text = cancelText; select.text = selectText
    }
    /** Original: e(e) */ fun setListener(l: ListenerContract?) { listener = l }
    /** Original: f(CharSequence) */ fun setMessage(m: CharSequence) { text.text = m }

    override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {
        if (event.action == KeyEvent.ACTION_UP && (keyCode == 4 || keyCode == 111)) {
            val l = listener
            if (l != null && l.d() != MANDATORY) {
                if (l.d() == OPTIONAL) { dismiss(); l.c(this) }
                return false
            }
            val exit = ExitDialog(ctx)
            exit.setListener(object : OnDialogActionListener { override fun onConfirm() { listener?.a() } })
            exit.show()
        }
        return false
    }

    companion object { const val OPTIONAL = 0; const val MANDATORY = 1 }
}
