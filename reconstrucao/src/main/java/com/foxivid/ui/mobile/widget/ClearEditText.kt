package com.foxivid.ui.mobile.widget

import com.foxivid.ui.mobile.R

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

/**
 * EditText com ícone "limpar" (mipmap `delete_input`, bounds deslocados 20px para a esquerda)
 * à direita, visível quando há foco e texto.
 *
 * Original: com/tvc/lib/mobile/ui/widget/ClearEditText.java
 */
class ClearEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatEditText(context, attrs, defStyle), View.OnTouchListener, View.OnFocusChangeListener, TextWatcher {

    private var clearIcon: Drawable? = null
    private var externalTouchListener: View.OnTouchListener? = null
    private var externalFocusListener: View.OnFocusChangeListener? = null

    init {
        val d = DrawableCompat.wrap(ContextCompat.getDrawable(context, R.mipmap.delete_input)!!)
        clearIcon = d
        d.setBounds(-20, 0, d.intrinsicWidth - 20, d.intrinsicHeight)
        setClearIconVisible(false)
        super.setOnTouchListener(this)
        super.setOnFocusChangeListener(this)
        super.addTextChangedListener(this)
    }

    private fun setClearIconVisible(visible: Boolean) {
        val icon = clearIcon
        if (icon == null || icon.isVisible != visible) {
            icon?.setVisible(visible, false)
            val c = compoundDrawables
            setCompoundDrawables(c[0], c[1], if (visible) clearIcon else null, c[3])
        }
    }

    override fun onFocusChange(v: View, hasFocus: Boolean) {
        if (!hasFocus || text == null) setClearIconVisible(false)
        else setClearIconVisible(text!!.length > 0)
        externalFocusListener?.onFocusChange(v, hasFocus)
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        val x = event.x.toInt()
        val icon = clearIcon
        if (icon != null && icon.isVisible) {
            if (x > (width - paddingRight) - icon.intrinsicWidth) {
                if (event.action == 1) setText("")
                return true
            }
        }
        return externalTouchListener?.onTouch(v, event) ?: false
    }

    override fun setOnFocusChangeListener(l: View.OnFocusChangeListener?) { externalFocusListener = l }
    override fun setOnTouchListener(l: View.OnTouchListener?) { externalTouchListener = l }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (isFocused) setClearIconVisible((s?.length ?: 0) > 0)
    }

    override fun afterTextChanged(s: Editable?) {}
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
}
