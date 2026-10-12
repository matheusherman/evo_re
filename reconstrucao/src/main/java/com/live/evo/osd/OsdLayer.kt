package com.live.evo.osd

/**
 * Camada (layer) do OSD de [com.live.evo.activity.LiveNewActivity]: um elemento sobreposto ao vídeo
 * com prioridade. O [OsdLayerManager] garante que só a camada de maior prioridade fique visível.
 *
 * Original: com/live/evo/osd/g.java
 */
abstract class OsdLayer {
    /** Prioridade (padrão 2; cada subclasse define a sua via [setPriority]). Original: f7097a */
    var priority: Int = 2
        private set

    /** Retorna a visibilidade atual (View.VISIBLE/GONE). Original: b() */
    abstract fun visibility(): Int

    /** Define a visibilidade. Original: d(int) */
    abstract fun setVisibility(visibility: Int)

    /** Original: c(int) */
    fun setPriority(value: Int) {
        priority = value
    }
}
