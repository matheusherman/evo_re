package com.foxivid.ui.mobile.widget

import androidx.annotation.DrawableRes

/**
 * Configuração da barra de abas ([TabBarView]): cores, estilo de borda e itens.
 * Original: com/tvc/lib/mobile/ui/widget/TabBarBean.java (data class; ItemBean = TabBarBean$ItemBean)
 */
data class TabBarBean(
    val color: Int,
    val selectedColor: Int,
    val backgroundColor: Int,
    val borderStyle: String,
    val items: ArrayList<ItemBean>
) {
    /** Original: TabBarBean$ItemBean */
    data class ItemBean(
        val id: String,
        val isCdn: Boolean,
        val text: String,
        val iconPath: String?,
        val selectedIconPath: String?,
        @DrawableRes val iconId: Int,
        @DrawableRes val selectedIconId: Int
    )
}
