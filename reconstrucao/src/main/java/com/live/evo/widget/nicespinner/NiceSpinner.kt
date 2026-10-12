package com.live.evo.widget.nicespinner

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

/**
 * Cópia da lib "NiceSpinner" (arbogast): dropdown com lista (`ListView` em PopupWindow), adapters `a`/`b`
 * (ObjectAdapter / ArrayAdapter, base `c` = BaseAdapter) e enum `d` de alinhamento (PopUpTextAlignment).
 * Interface de seleção: `r5.b`. Biblioteca de terceiros — não reconstruída linha a linha.
 *
 * Original: com/live/evo/widget/nicespinner/NiceSpinner.java (+ a.java, b.java, c.java, d.java)
 */
class NiceSpinner @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : AppCompatTextView(context, attrs, defStyle) {
    var selectedIndex: Int = 0
    fun <T> attachDataSource(list: List<T>) { TODO("biblioteca NiceSpinner: l(List)") }
}
