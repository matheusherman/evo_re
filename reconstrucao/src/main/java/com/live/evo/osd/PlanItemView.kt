package com.live.evo.osd

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.TextView
import com.live.evo.R

/**
 * Item de plano de assinatura (layout `item_plan_info`: nome, preço de venda, preço original, descrição).
 * Original: com/live/evo/osd/PlanListPresenter$PlanItem.java
 */
class PlanItemView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
    RelativeLayout(context, attrs, defStyle) {
    val planName: TextView
    val salePrice: TextView
    val originPrice: TextView
    val describe: TextView

    init {
        val v = LayoutInflater.from(context).inflate(R.layout.item_plan_info, this, true)
        isFocusable = false
        planName = v.findViewById(R.id.tv_plan_name)
        salePrice = v.findViewById(R.id.tv_plan_sale_price)
        originPrice = v.findViewById(R.id.tv_plan_origin_price)
        describe = v.findViewById(R.id.tv_plan_describe)
    }
}
