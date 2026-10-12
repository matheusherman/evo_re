package com.live.evo.osd

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.live.evo.R
import com.live.evo.widget.LoadView
import com.live.evo.widget.sloading.LoadingStyle
import com.live.evo.widget.sloading.SLoadingView

/**
 * Camada de "carregando" (`livenewa_ll_loading`): texto + [SLoadingView] (estilo TRANSLATE_CIRCLE)
 * e um [LoadView] separado. Prioridade 3.
 *
 * Original: com/live/evo/osd/l.java
 */
class LoadingLayer(context: Context, root: View, textRes: Int, private val flag: Boolean = false) : OsdLayer() {
    private var text: String = context.getString(textRes)
    private val container: LinearLayout = root.findViewById(R.id.livenewa_ll_loading)
    private val promptText: TextView = root.findViewById(R.id.livenewa_tv_program_prompt)
    private val spinner: SLoadingView = root.findViewById(R.id.livenewa_slv)
    private val loadView: LoadView = root.findViewById(R.id.livenewa_lv_program_loadview)
    private var textShown = false
    private var loadViewShown = false

    init {
        setPriority(3)
        spinner.setLoadingBuilder(LoadingStyle.TRANSLATE_CIRCLE)
    }

    /** Original: f() — esconde texto + spinner. */
    fun hideSpinner() { textShown = false; promptText.visibility = View.GONE; spinner.visibility = View.GONE }
    /** Original: g() — esconde o LoadView. */
    fun hideLoadView() { loadViewShown = false; loadView.visibility = View.GONE }
    /** Original: j() — mostra texto + spinner. */
    fun showSpinner() { textShown = true; promptText.visibility = View.VISIBLE; promptText.text = text; spinner.visibility = View.VISIBLE }
    /** Original: k() — mostra o LoadView. */
    fun showLoadView() { loadViewShown = true; loadView.visibility = View.VISIBLE }

    override fun visibility(): Int =
        if (promptText.text == text) promptText.visibility else View.GONE

    override fun setVisibility(visibility: Int) {
        if (visibility == View.VISIBLE) {
            promptText.text = text
        } else if (promptText.text != text) {
            return
        }
        promptText.visibility = visibility
        if (flag) {
            container.visibility = visibility
            spinner.visibility = visibility
        } else {
            container.visibility = View.GONE
            spinner.visibility = View.GONE
        }
    }

    /** Original: e() */
    fun isLoadViewShown(): Boolean = loadViewShown

    /** Troca o texto do prompt. Original: h(String) */
    fun setPromptText(value: String) { text = value }

    /** Texto do [LoadView]. Original: i(String) */
    fun setLoadViewText(value: String) { loadView.setText(value) }
}
