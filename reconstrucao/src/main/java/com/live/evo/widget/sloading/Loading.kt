package com.live.evo.widget.sloading

import android.content.Context
import android.util.AttributeSet
import android.app.Dialog
import android.text.TextUtils
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.live.evo.R
import com.live.evo.widget.BaseDialog
import java.lang.ref.WeakReference

/**
 * Estilos de animação do [SLoadingView] (cada um mapeia para uma classe de renderização em `s5.*`/`widget.*`).
 * Original: com/live/evo/widget/sloading/c.java (enum; nome sugerido LoadingStyle)
 */
enum class LoadingStyle {
    CIRCLE, CIRCLE_CLOCK, STAR_LOADING, LEAF_ROTATE, DOUBLE_CIRCLE, PAC_MAN, ELASTIC_BALL, INFECTION_BALL, INTERTWINE,
    TEXT, SEARCH_PATH, ROTATE_CIRCLE, SINGLE_CIRCLE, SNAKE_CIRCLE, TRANSLATE_CIRCLE, FADING_CIRCLE, ROTATE_SAMECIRCLE
}

/**
 * View de loading animada: usa um Drawable animado (`sloading/b.java`, com `sloading/a.java` como controlador de
 * ValueAnimator) escolhido via [setLoadingBuilder]; opcionalmente exibe texto ([setShowTextView]).
 * Original: com/live/evo/widget/sloading/SLoadingView.java (+ a.java, b.java, anim/SLoadingTextView.java)
 */
class SLoadingView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : FrameLayout(context, attrs, defStyle) {
    fun setLoadingBuilder(style: LoadingStyle) { /* TODO("instancia a classe do estilo e inicia o ValueAnimator (ver sloading/b.java)") */ }
    fun setColorExtra(color: Int) {}
    fun setShowTextView(text: String?) {}
    fun setTextVisiable(visible: Boolean) {}
}

/**
 * Construtor do diálogo de loading (layout `s_loading_dialog`: `sloadingdlg_slv`, `sloadingdlg_tv_text`,
 * `sloadingdlg_tv_custom_text`). Usado como `t5.a(context).f(style).g(color)` + `h()` (show) / `d()` (dismiss) / `a()` (cancel).
 * Texto customizado só aparece se definido; com tamanho > 0 usa o TextView customizado, senão o texto animado.
 * Nota: o original usa `SLoadingTextView` (anim/) para o texto animado; aqui é tratado como TextView simples.
 *
 * Original: t5/a.java (SLoadingDialog.Builder)
 */
class SLoadingDialog @JvmOverloads constructor(context: Context, private val style: Int = R.style.alert_dialog) {
    private val contextRef = WeakReference(context)
    private var loadingStyle: LoadingStyle? = null
    private var color = 0
    private var text: String? = null
    private var textSize = -1.0f
    private var textColor = -1
    private var cancelable = true
    private var canceledOnTouchOutside = true
    private var dialog: Dialog? = null

    /** Original: f(c) */ fun setStyle(s: LoadingStyle): SLoadingDialog { loadingStyle = s; return this }
    /** Original: g(int) */ fun setColor(c: Int): SLoadingDialog { color = c; return this }
    /** Original: d() */ fun dismiss() { dialog?.dismiss(); dialog = null }
    /** Original: a() */ fun cancel() { dialog?.cancel(); dialog = null }
    /** Original: h() — mostra o diálogo existente ou cria um novo. */
    fun show() { (dialog ?: build()).show() }

    /** Original: b() */
    fun build(): Dialog {
        val ctx = contextRef.get() ?: throw RuntimeException("Context is null...")
        if (dialog != null) cancel()
        val d = BaseDialog(ctx, style)
        val v = View.inflate(ctx, R.layout.s_loading_dialog, null)
        val slv = v.findViewById<SLoadingView>(R.id.sloadingdlg_slv)
        val animText = v.findViewById<TextView>(R.id.sloadingdlg_tv_text)
        val custom = v.findViewById<TextView>(R.id.sloadingdlg_tv_custom_text)
        if (textSize > 0f && !TextUtils.isEmpty(text)) {
            custom.visibility = View.VISIBLE; custom.text = text; custom.textSize = textSize
            custom.setTextColor(if (textColor == -1) color else textColor)
        } else if (!TextUtils.isEmpty(text)) {
            animText.visibility = View.VISIBLE; animText.text = text
            animText.setTextColor(if (textColor == -1) color else textColor)
        }
        loadingStyle?.let { slv.setLoadingBuilder(it) }
        slv.setColorExtra(color)
        d.setContentView(v)
        d.setCancelable(cancelable)
        d.setCanceledOnTouchOutside(canceledOnTouchOutside)
        dialog = d
        return d
    }
}
