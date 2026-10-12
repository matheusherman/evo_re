package com.live.evo.osd

import android.content.Context
import android.view.View
import android.widget.TextView
import com.live.evo.R

/**
 * Camada de texto "otimizando programa" (`livenewa_tv_program_optimizing`), prioridade 3.
 * Só reporta/altera visibilidade se o texto atual for o texto da camada ([text]).
 * Original: com/live/evo/osd/k.java
 */
class OptimizingLayer(context: Context, root: View, textRes: Int) : OsdLayer() {
    private val text: String = context.getString(textRes)
    private val textView: TextView = root.findViewById(R.id.livenewa_tv_program_optimizing)

    init { setPriority(3) }

    override fun visibility(): Int =
        if (textView.text == text) textView.visibility else View.GONE

    override fun setVisibility(visibility: Int) {
        if (visibility == View.VISIBLE) {
            textView.text = text
        } else if (textView.text != text) {
            return
        }
        textView.visibility = visibility
    }
}
