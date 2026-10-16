package com.foxivid.ui.mobile.widget.sloading

import android.app.Dialog
import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import com.foxivid.ui.mobile.base.LoadingViewDialog
import java.lang.ref.WeakReference

/**
 * Diálogo de loading com um [SLoadingView] (layout `s_loading_dialog_tvc_lib`; ids `sloadingdlg_slv` e
 * `sloadingdlg_tv_custom_text`). Guarda o Context por WeakReference; o estilo padrão é `alert_dialog`.
 * Original: y7/a.java
 */
class SLoadingDialog @JvmOverloads constructor(
    context: Context,
    private val styleRes: Int = 0,
) : LoadingViewDialog {
    private val contextRef = WeakReference(context)
    private var type: SLoadingType? = null     // c
    private var color = 0                      // d
    private var text: String? = null           // e (texto personalizado)
    private var textSize = -1.0f               // f
    private var textColor = -1                 // g
    private var cancelable = true              // h
    private var canceledOnTouchOutside = true  // i
    private var dialog: Dialog? = null         // j

    private fun contextOrThrow(): Context = contextRef.get() ?: throw RuntimeException("Context is null...")

    private fun res(name: String, kind: String): Int = contextOrThrow().let { it.resources.getIdentifier(name, kind, it.packageName) }

    /** Original: a.a() — cancela e descarta. */
    fun cancel() { dialog?.cancel(); dialog = null }

    /** Original: a.d() */
    override fun dismiss() { dialog?.dismiss(); dialog = null }

    /** Original: a.f(c) */ fun setType(type: SLoadingType): SLoadingDialog { this.type = type; return this }
    /** Original: a.g(int) */ fun setColor(color: Int): SLoadingDialog { this.color = color; return this }

    /** Original: a.h() */
    override fun show() { (dialog ?: build()).show() }

    /** Constrói o diálogo (recria se já existia). Original: a.b() */
    fun build(): Dialog {
        val ctx = contextOrThrow()
        if (dialog != null) cancel()
        val d = Dialog(ctx, if (styleRes != 0) styleRes else res("alert_dialog", "style"))
        dialog = d
        val view = View.inflate(ctx, res("s_loading_dialog_tvc_lib", "layout"), null)
        val slv = view.findViewById<SLoadingView>(res("sloadingdlg_slv", "id"))
        val tv = view.findViewById<TextView>(res("sloadingdlg_tv_custom_text", "id"))
        if (textSize > 0.0f && !TextUtils.isEmpty(text)) {
            tv.visibility = View.VISIBLE
            tv.text = text
            tv.textSize = textSize
            tv.setTextColor(if (textColor == -1) color else textColor)
        }
        slv.setLoadingBuilder(type!!)
        slv.setColorFilter(color)
        d.setContentView(view)
        d.setCancelable(cancelable)
        d.setCanceledOnTouchOutside(canceledOnTouchOutside)
        return d
    }
}
