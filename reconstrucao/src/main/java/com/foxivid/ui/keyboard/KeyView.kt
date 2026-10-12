package com.foxivid.ui.keyboard

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes

/**
 * Uma tecla na tela: FrameLayout (layout `key_key_view`) com um TextView (`tv_key`) e um
 * ImageView (`iv_key`); mostra o ícone se [KeyBean.iconRes] != -1, senão o rótulo.
 *
 * Original: ziyi/kit/keyboard/KeyView.java
 */
class KeyView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    val textKeyView: TextView
    val imageKeyView: ImageView
    var bean: KeyBean? = null
        private set

    init {
        View.inflate(context, R.layout.key_key_view, this)
        textKeyView = findViewById(R.id.tv_key)
        imageKeyView = findViewById(R.id.iv_key)
        isFocusable = true
        isClickable = true
    }

    /** Troca o ícone da tecla. Original: KeyView.a(int) */
    fun setIcon(@DrawableRes res: Int) {
        bean?.let {
            it.iconRes = res
            imageKeyView.setImageResource(res)
        }
    }

    /** Troca o rótulo da tecla. Original: KeyView.b(CharSequence) */
    fun setLabel(text: CharSequence) {
        bean?.let {
            it.label = text
            textKeyView.text = text
        }
    }

    /** Alterna maiúsculas/minúsculas do rótulo e do texto de entrada. Original: KeyView.c(boolean) */
    fun setUpperCase(upper: Boolean) {
        val b = bean ?: return
        if (upper) {
            b.label = b.label.toString().uppercase()
            b.input = b.input.toString().uppercase()
        } else {
            b.label = b.label.toString().lowercase()
            b.input = b.input.toString().lowercase()
        }
        textKeyView.text = b.label
    }

    fun setBean(bean: KeyBean) {
        this.bean = bean
        if (bean.iconRes != -1) {
            imageKeyView.visibility = View.VISIBLE
            textKeyView.visibility = View.INVISIBLE
            imageKeyView.setImageResource(bean.iconRes)
            textKeyView.text = ""
        } else {
            imageKeyView.visibility = View.INVISIBLE
            textKeyView.visibility = View.VISIBLE
            imageKeyView.setImageDrawable(null)
            textKeyView.text = bean.label
        }
    }

    fun setTypeface(typeface: Typeface?) {
        textKeyView.typeface = typeface ?: Typeface.DEFAULT
    }
}
