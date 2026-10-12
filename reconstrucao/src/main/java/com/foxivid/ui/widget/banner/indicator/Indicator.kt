package com.foxivid.ui.widget.banner.indicator

import com.youth.banner.config.IndicatorConfig
import com.youth.banner.listener.OnPageChangeListener

/**
 * Contrato dos indicadores do banner (youth banner `Indicator`).
 * `IndicatorConfig` = bg/b.java, `OnPageChangeListener` = cg/a.java (biblioteca youth banner).
 *
 * Original: t/v/c/widget/banner/indicator/a.java
 */
interface Indicator : OnPageChangeListener {
    val indicatorConfig: IndicatorConfig

    /** Chamado quando a quantidade de itens/posição atual muda. Original: onPageChanged(count, currentPosition) */
    fun onPageChanged(count: Int, currentPosition: Int)
}
