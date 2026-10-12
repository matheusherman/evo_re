package com.live.evo.osd

import android.content.Context
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.live.evo.R

/**
 * Camada com número e nome do canal (`livenewa_ll_program_name_container`). Auto-esconde
 * 10 s após ser exibida (mensagem 4097 via Handler). Prioridade 3.
 * No modo STB aplica estilos de texto de TV via `util.t` (TextStyleUtils).
 *
 * Original: com/live/evo/osd/j.java
 */
class ProgramNameLayer(context: Context, root: View) : OsdLayer() {
    private val container: LinearLayout = root.findViewById(R.id.livenewa_ll_program_name_container)
    private val idText: TextView = root.findViewById(R.id.livenewa_tv_program_id)
    private val nameText: TextView = root.findViewById(R.id.livenewa_tv_program_name)
    private var programId: String = "1"

    private val handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            if (msg.what != 4097) return
            setVisibility(View.GONE)
        }
    }

    init {
        setPriority(3)
        idText.paint.apply { strokeWidth = 10.0f; style = android.graphics.Paint.Style.FILL; isFakeBoldText = false }
        // Original: LoginConfig.get().flagA() ? estilos de um tema : de outro (util.t.a/b/c = TextStyleUtils) — detalhes de fonte omitidos.
    }

    override fun visibility(): Int = container.visibility

    /** Mostra e agenda auto-ocultação em 10 s. Original: d(int) */
    override fun setVisibility(visibility: Int) {
        container.visibility = visibility
        if (visibility == View.GONE) return
        handler.removeMessages(4097)
        handler.sendEmptyMessageDelayed(4097, 10_000L)
    }

    /** Original: e() */
    fun idText(): String = idText.text.toString()

    /** Número do canal como Int (0 se inválido). Original: f() */
    fun idNumber(): Int = try { programId.toInt() } catch (e: Exception) { 0 }
}
