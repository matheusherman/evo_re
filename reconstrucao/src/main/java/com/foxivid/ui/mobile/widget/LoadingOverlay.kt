package com.foxivid.ui.mobile.widget

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.foxivid.ui.mobile.widget.sloading.SLoadingView
import com.foxivid.ui.mobile.widget.sloading.SLoadingType
import org.slf4j.LoggerFactory

/**
 * Indicador de loading sobre um contêiner existente (layout `loading_layout_tvc_lib`): spinner `sloadingdlg_slv` (estilo
 * TRANSLATE_CIRCLE, cor [colorRes]) e texto opcional `sloadingdlg_tv_custom_text`. Mostrar/esconder passa pelo Handler da main
 * thread. Começa escondido.
 *
 * Original: z7/j.java (classe interna `a`, criada por `z7.j.i(...)`)
 */
class LoadingOverlay(parent: View?, containerId: Int, colorRes: Int, textRes: Int) : MyVideoView.LoadingController {
    private val logger = LoggerFactory.getLogger(LoadingOverlay::class.java)
    private val handler = Handler(Looper.getMainLooper())
    private var loadingContainer: View? = null
    private var textView: TextView? = null
    private var loadingImgView: SLoadingView? = null

    init {
        try {
            loadingContainer = parent?.findViewById(containerId)
            loadingImgView = loadingContainer!!.findViewById(com.foxivid.ui.R.id.sloadingdlg_slv)
            loadingImgView?.setLoadingBuilder(SLoadingType.TRANSLATE_CIRCLE)
            loadingImgView?.setColorFilter(ContextCompat.getColor(loadingContainer!!.context, colorRes))
            textView = loadingContainer!!.findViewById(com.foxivid.ui.R.id.sloadingdlg_tv_custom_text)
            if (textRes == 0) textView?.visibility = View.GONE
            else if (textRes > 0) {
                textView?.visibility = View.VISIBLE
                textView?.text = loadingContainer!!.context.getString(textRes)
            }
            hide()
        } catch (t: Throwable) {
            logger.error("failure to init loading util", t)
        }
    }

    /** Mostra o loading (posta na main thread se ainda não visível). Original: b() */
    override fun show() {
        val c = loadingContainer
        if (c == null || c.visibility != View.VISIBLE) handler.post {
            try { loadingContainer?.visibility = View.VISIBLE } catch (t: Throwable) { logger.error("start loading animation failure", t) }
        }
    }

    /** Mostra [text] no TextView (direto na main thread, senão posta). Original: c(String) */
    fun setText(text: String) {
        if (Thread.currentThread() != Looper.getMainLooper().thread) {
            handler.post { textView?.visibility = View.VISIBLE; textView?.text = text }
            return
        }
        textView?.visibility = View.VISIBLE
        textView?.text = text
    }

    /** Esconde o loading. Original: a() */
    override fun hide() {
        handler.post {
            try { loadingContainer?.visibility = View.GONE } catch (t: Throwable) { logger.error("stop loading animation failure", t) }
        }
    }
}
