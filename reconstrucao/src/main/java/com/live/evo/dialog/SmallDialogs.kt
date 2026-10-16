package com.live.evo.dialog

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.live.evo.R
import com.live.evo.util.NoticeActionHandler
import com.live.evo.util.TextStyleUtils
import com.live.evo.widget.BaseButton
import com.live.evo.widget.BaseDialog

/** Callbacks de [ExitDialog]. Original: dialog/n.java (interface vazia; callback `a()` é chamado no confirmar) */
interface OnDialogActionListener { fun onConfirm() }

/**
 * Diálogo "Sair?" (layout `exit_dialog`: `exitdlg_tv_exit`, `exitdlg_btn_sure`, `exitdlg_btn_cancel`).
 * Confirmar: fecha e chama `listener.onConfirm()`; cancelar só fecha.
 * Original: com/live/evo/dialog/m.java
 */
class ExitDialog(private val context: Context) {
    private val dialog = BaseDialog(context, R.style.RechargeAlertialog)
    private val view: View = LayoutInflater.from(context).inflate(R.layout.exit_dialog, null, false)
    private var listener: OnDialogActionListener? = null
    init {
        dialog.setContentView(view)
        view.findViewById<Button>(R.id.exitdlg_btn_sure).setOnClickListener { if (dialog.isShowing) dialog.dismiss(); listener?.onConfirm() }
        view.findViewById<Button>(R.id.exitdlg_btn_cancel).setOnClickListener { if (dialog.isShowing) dialog.dismiss() }
    }
    /** Original: h(n) */ fun setListener(l: OnDialogActionListener?) { listener = l }
    /** Versão lambda usada por LiveLoadActivity. */ fun setOnExitListener(block: () -> Unit) { listener = object : OnDialogActionListener { override fun onConfirm() = block() } }
    /** Original: g() */ fun isShowing() = dialog.isShowing
    /** Original: c()/d() */ fun dismiss() { if (dialog.isShowing) dialog.dismiss() }
    /** Original: i() */ fun show() { if (!dialog.isShowing) dialog.show() }
}

/**
 * Aviso/notificação (layout `notice_alert_dialog`: título, botão OK, botão "direct" (ir para), ícone).
 * Original: com/live/evo/dialog/q.java
 */
class NoticeAlertDialog(private val context: Context) {
    private val dialog = BaseDialog(context, R.style.RechargeAlertialog)
    private val view: View = LayoutInflater.from(context).inflate(R.layout.notice_alert_dialog, null, false)
    private val title: TextView = view.findViewById(R.id.noticealertdlg_tv_title)
    private val okButton: BaseButton = view.findViewById(R.id.noticealertdlg_btn_ok)
    private val directButton: BaseButton = view.findViewById(R.id.noticealertdlg_btn_direct)
    private val textLayout: LinearLayout = view.findViewById(R.id.noticealertdlg_tv_layout)
    private val icon: ImageView = view.findViewById(R.id.noticealertdlg_iv)
    init {
        dialog.setContentView(view)
        TextStyleUtils.c(title)
        TextStyleUtils.d(okButton)
        // Original: d() — OK fecha; "direct" chama NoticeActionHandler.d(activity, null) (corpo vazio no APK) e fecha
        okButton.setOnClickListener { if (dialog.isShowing) dialog.dismiss() }
        directButton.setOnClickListener {
            if (context is android.app.Activity) NoticeActionHandler.onNotice(context, null)
            if (dialog.isShowing) dialog.dismiss()
        }
    }
    /** Original: c() — fecha. */ fun dismiss() { dialog.dismiss() }
    /** Original: f() */ fun isShowing() = dialog.isShowing
}

/**
 * Aviso de "lembrete de recarga" (layout `remind_alert_dialog`: imagem, título, texto, botão e botão secundário);
 * callback [Listener] `a()` = positivo / `b()` = negativo, ambos fecham.
 * Original: com/live/evo/dialog/r.java
 */
class RemindAlertDialog(private val context: Context, private val listener: Listener?) {
    /** Original: r.c — `a()` = botão secundário (return), `b()` = botão principal (right). */
    interface Listener { fun a(); fun b() }
    private val view: View = LayoutInflater.from(context).inflate(R.layout.remind_alert_dialog, null, false)
    private val image: ImageView = view.findViewById(R.id.remindalertdlg_iv_recharge_img)
    private val title: TextView = view.findViewById(R.id.remindalertdlg_tv_title)
    private val reason: TextView = view.findViewById(R.id.remindalertdlg_tv_reason)
    private val btnRight: android.widget.Button = view.findViewById(R.id.remindalertdlg_btn_right)
    private val btnReturn: android.widget.Button = view.findViewById(R.id.remindalertdlg_btn_return)
    private val code: TextView = view.findViewById(R.id.remindalertdlg_tv_code)
    private val dialog = BaseDialog(context, R.style.RechargeAlertialog).also { it.setContentView(view) }
    init {
        com.live.evo.util.TextStyleUtils.d(title); com.live.evo.util.TextStyleUtils.c(reason)
        com.live.evo.util.TextStyleUtils.c(code); com.live.evo.util.TextStyleUtils.d(btnRight)
        btnRight.setOnClickListener { if (listener != null) { listener.b(); dialog.dismiss() } }
        btnReturn.setOnClickListener { if (listener != null) { listener.a(); dialog.dismiss() } }
    }
    /** Esconde a imagem. Original: c() */ fun hideImage() { image.visibility = View.GONE }
    /** Texto do botão secundário (e o mostra). Original: g(String) */
    fun setReturnText(s: String) { btnReturn.visibility = View.VISIBLE; btnReturn.text = s }
    /** Texto do botão principal (e o mostra). Original: h(String) */
    fun setRightText(s: String) { btnRight.visibility = View.VISIBLE; btnRight.text = s }
    /** Imagem de fundo (resId > 0). Original: i(int) */
    fun setImage(resId: Int) { if (resId > 0) { image.visibility = View.VISIBLE; image.setBackgroundResource(resId) } }
    /** Motivo (`reason`) e código de erro (`code`); ignorado se o motivo for vazio. Original: j(String, String) */
    fun setMessage(msg: String?, errorCode: String?) {
        if (!android.text.TextUtils.isEmpty(msg)) { reason.text = msg; if (errorCode != null) code.text = errorCode }
    }
    /** Título (ignora vazio). Original: k(String) */
    fun setTitle(s: String?) { if (!android.text.TextUtils.isEmpty(s)) title.text = s }
    fun show() { dialog.show() }                         // l()
    fun dismiss() { dialog.dismiss() }
}

/**
 * Pergunta "trocar de lembrete?" (layout `subscribeswitch_dialog`): texto com
 * `subscribe_switch` (nome antigo, horário HH:mm e nome novo), confirmar/cancelar; BACK = cancelar.
 * Original: com/live/evo/dialog/w.java (+ x.java listener `a()` cancelar / `b()` confirmar)
 */
class SubscribeSwitchDialog(private val context: Context) {
    /** Original: dialog/x.java */ interface Listener { fun a(); fun b() }
    private val view: View = LayoutInflater.from(context).inflate(R.layout.subscribeswitch_dialog, null, false)
    private val dialog = BaseDialog(context, R.style.RechargeAlertialog).also { it.setContentView(view) }
    private var listener: Listener? = null
    private val tips: TextView = view.findViewById(R.id.subscribeswitchdlg_tv_switch_tips)
    private val sure: BaseButton = view.findViewById(R.id.subscribeswitchdlg_btn_sure)
    private val cancel: BaseButton = view.findViewById(R.id.subscribeswitchdlg_btn_cancel)
    init {
        sure.setOnClickListener { if (dialog.isShowing) dialog.dismiss(); listener?.b() }
        cancel.setOnClickListener { if (dialog.isShowing) dialog.dismiss(); listener?.a() }
        dialog.setOnKeyListener { _, _, _ -> listener?.a(); false } // original: onKey → a()
        TextStyleUtils.c(tips); TextStyleUtils.d(sure); TextStyleUtils.d(cancel)
    }
    /** Original: f(x) */ fun setListener(l: Listener?) { listener = l }
    /** Original: e() */ fun isShowing() = dialog.isShowing
    /** Original: h() — mostra e foca o botão OK. */ fun show() { if (!dialog.isShowing) dialog.show(); sure.requestFocus() }
    /** Original: g(i5.p newProgram, i5.c0 oldSub) — monta o texto de aviso. */
    fun setPrograms(newProgram: com.live.evo.model.ProgramBean, old: com.live.evo.model.SubscribeBean) {
        tips.text = String.format(context.getString(R.string.subscribe_switch), old.title, com.live.evo.util.DateUtils.format(newProgram.startTime, "HH:mm"), newProgram.title)
    }
}
