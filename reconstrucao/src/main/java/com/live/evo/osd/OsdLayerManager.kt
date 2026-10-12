package com.live.evo.osd

import android.view.View

/**
 * Gerente de camadas do OSD. Registro estático (`HashMap` companion) por nome de camada.
 * Ao mostrar uma camada, esconde (GONE) as demais de prioridade menor ou igual.
 *
 * Original: com/live/evo/osd/h.java
 */
class OsdLayerManager {

    /** Registra a camada [layer] sob [name]. Original: a(String, g) */
    fun register(name: String, layer: OsdLayer) {
        layers[name] = layer
    }

    /** Esconde a camada. Original: b(g) */
    fun hide(layer: OsdLayer) {
        layer.setVisibility(View.GONE)
    }

    /**
     * Alterna a camada: esconde toda camada registrada cuja prioridade seja >= à da [layer]
     * (a própria camada não é escondida aqui) e inverte a visibilidade de [layer].
     * Original: c(g)
     */
    fun toggle(layer: OsdLayer) {
        for (key in layers.keys) {
            val other = layers[key] ?: continue
            if (other != layer) {
                // Original: `if (gVar.a() <= gVar2.a()) gVar2 = gVar;` — esconde a de menor prioridade.
                val target = if (layer.priority <= other.priority) layer else other
                target.setVisibility(View.GONE)
            }
        }
        layer.setVisibility(if (layer.visibility() != View.VISIBLE) View.VISIBLE else View.GONE)
    }

    private companion object {
        val layers: MutableMap<String, OsdLayer> = HashMap()
    }
}
