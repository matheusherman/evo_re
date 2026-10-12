package com.foxivid.ui.mobile.widget

import com.foxivid.ui.mobile.R

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

/**
 * AutoCompleteTextView para e-mail: sugere domínios (gmail.com, hotmail.com, outlook.com,
 * yahoo.com.br, yahoo.com) depois de um "@" (e não "@@") e mostra um ícone de limpar (mipmap
 * `delete_input`) à direita quando focado e com texto.
 *
 * Original: com/tvc/lib/mobile/ui/widget/AutoCompleteEditText.java
 */
class AutoCompleteEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = androidx.appcompat.R.attr.autoCompleteTextViewStyle
) : AppCompatAutoCompleteTextView(context, attrs, defStyle),
    View.OnTouchListener, View.OnFocusChangeListener, TextWatcher {

    private lateinit var clearIcon: Drawable
    private var externalTouchListener: View.OnTouchListener? = null
    private var externalFocusListener: View.OnFocusChangeListener? = null
    private lateinit var adapter: EmailSuggestionAdapter
    private lateinit var domains: List<String>
    private var currentText: String? = null

    init {
        clearIcon = DrawableCompat.wrap(ContextCompat.getDrawable(context, R.mipmap.delete_input)!!)
        clearIcon.setBounds(0, 0, clearIcon.intrinsicWidth, clearIcon.intrinsicHeight)
        setClearIconVisible(false)
        super.setOnTouchListener(this)
        super.setOnFocusChangeListener(this)
        super.addTextChangedListener(this)
        domains = listOf("gmail.com", "hotmail.com", "outlook.com", "yahoo.com.br", "yahoo.com")
        adapter = EmailSuggestionAdapter(context)
        setAdapter(adapter)
        threshold = 1
    }

    override fun onFocusChange(v: View, hasFocus: Boolean) {
        if (!hasFocus || text == null) setClearIconVisible(false)
        else setClearIconVisible(text.length > 0)
        externalFocusListener?.onFocusChange(v, hasFocus)
    }

    private fun setClearIconVisible(visible: Boolean) {
        if (clearIcon.isVisible == visible) return
        clearIcon.setVisible(visible, false)
        val d = compoundDrawables
        setCompoundDrawables(d[0], d[1], if (visible) clearIcon else null, d[3])
    }

    /** Só filtra quando o texto termina em "@" (mas não "@@"). */
    override fun enoughToFilter(): Boolean {
        val s = currentText
        return !(s == null || !s.endsWith("@") || s.endsWith("@@"))
    }

    override fun setOnFocusChangeListener(l: View.OnFocusChangeListener?) { externalFocusListener = l }
    override fun setOnTouchListener(l: View.OnTouchListener?) { externalTouchListener = l }

    override fun onTextChanged(text: CharSequence, start: Int, lengthBefore: Int, lengthAfter: Int) {
        if (isFocused) {
            setClearIconVisible(text.isNotEmpty())
            currentText = text.toString()
            adapter.setData(text.toString(), domains)
        }
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        val x = event.x.toInt()
        if (clearIcon.isVisible && x > (width - paddingRight) - clearIcon.intrinsicWidth) {
            if (event.action == 1) setText("")
            return true
        }
        val l = externalTouchListener
        return l != null && l.onTouch(v, event)
    }

    override fun afterTextChanged(s: Editable) {}
    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
}
