package com.live.evo.osd

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.live.evo.R

/**
 * Camada "aviso de rede" (`livenewa_ll_osd_network_prompt`), prioridade 3.
 * Original: com/live/evo/osd/i.java
 */
class NetworkPromptLayer(context: Context, root: View) : OsdLayer() {
    private val container: LinearLayout = root.findViewById(R.id.livenewa_ll_osd_network_prompt)

    init { setPriority(3) }

    override fun visibility(): Int = container.visibility
    override fun setVisibility(visibility: Int) { container.visibility = visibility }
}
