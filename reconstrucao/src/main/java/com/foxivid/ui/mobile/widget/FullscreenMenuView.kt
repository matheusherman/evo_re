package com.foxivid.ui.mobile.widget

import com.foxivid.ui.mobile.R

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.StringRes

/**
 * Item de menu do player em tela cheia (ícone + nome), inflado de `layout_fullscreen_menu`
 * (ids `name`, `icon`, `item_layout`).
 *
 * Original: com/tvc/lib/mobile/ui/widget/FullscreenMenuView.java
 */
class FullscreenMenuView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private lateinit var title: TextView
    private lateinit var icon: ImageView
    private lateinit var itemLayout: LinearLayout
    private var isStillShow = false

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_fullscreen_menu, this, true)
        title = findViewById(R.id.name)
        icon = findViewById(R.id.icon)
        itemLayout = findViewById(R.id.item_layout)
        if (isStillShow) title.visibility = View.VISIBLE
    }

    /** Original: setHideOrVisibility(boolean) — GONE se hide, senão VISIBLE. */
    fun setHideOrVisibility(hide: Boolean) {
        itemLayout.visibility = if (hide) View.GONE else View.VISIBLE
    }

    fun setTitle(@StringRes titleId: Int) { title.text = context.getString(titleId) }

    fun setStillShow(show: Boolean) {
        isStillShow = show
        if (show) title.visibility = View.VISIBLE
    }

    fun setTitle(title: String?) {
        if (TextUtils.isEmpty(title)) return
        this.title.text = title
    }

    fun setViewOnClickListener(onClick: (View) -> Unit) {
        itemLayout.setOnClickListener { onClick(it) }
    }
}
