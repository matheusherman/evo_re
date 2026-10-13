package com.live.evo.widget.nicespinner

import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.util.AttributeSet
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListPopupWindow
import androidx.appcompat.widget.AppCompatTextView

/** Formata o item para exibição (lista e texto selecionado). Original: r5/d.java (padrão r5/c: `toString()`). */
fun interface SpinnerTextFormatter<T> { fun format(item: T): Spannable }

/** Callback de seleção. Original: r5/b.java (`a(NiceSpinner, View, position, id)`). */
fun interface OnSpinnerItemSelectedListener { fun onItemSelected(spinner: NiceSpinner, view: View?, position: Int, id: Long) }

/**
 * Cópia da lib "NiceSpinner" (arbogast): TextView que abre um dropdown (`ListPopupWindow`) com a lista de itens.
 * Versão enxuta: mantém o comportamento usado pelo app (anexar lista, formatadores de texto, índice selecionado,
 * altura do popup, listener de seleção). Os adapters `a`/`b`/`c`, o enum `d` de alinhamento e a animação da seta
 * do original não são reproduzidos (biblioteca de terceiros).
 *
 * Original: com/live/evo/widget/nicespinner/NiceSpinner.java (+ a.java, b.java, c.java, d.java)
 */
class NiceSpinner @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : AppCompatTextView(context, attrs, defStyle) {
    private var items: List<Any?> = emptyList()
    var selectedIndex: Int = 0
        private set
    private var popup: ListPopupWindow? = null
    private var popupHeight = 0
    @Suppress("UNCHECKED_CAST") private var spinnerFormatter: SpinnerTextFormatter<Any?> = SpinnerTextFormatter { SpannableString(it.toString()) }
    @Suppress("UNCHECKED_CAST") private var selectedFormatter: SpinnerTextFormatter<Any?> = SpinnerTextFormatter { SpannableString(it.toString()) }
    private var selectionListener: OnSpinnerItemSelectedListener? = null

    init { setOnClickListener { if (popup?.isShowing == true) popup?.dismiss() else showPopup() } }

    /** Original: l(List) — anexa os dados e seleciona o índice 0. */
    fun <T> attachDataSource(list: List<T>) { items = list; selectedIndex = 0; if (list.isNotEmpty()) text = selectedFormatter.format(list[0]) }
    /** Original: getSelectedItem() */ fun getSelectedItem(): Any? = items.getOrNull(selectedIndex)
    /** Original: setSelectedIndex(int) / q(int, boolean) — atualiza texto; [notify] dispara o listener. */
    fun setSelectedIndex(index: Int, notify: Boolean = false) {
        if (index !in items.indices) return
        selectedIndex = index; text = selectedFormatter.format(items[index])
        if (notify) selectionListener?.onItemSelected(this, null, index, index.toLong())
    }
    /** Original: setHeight(int) — altura máxima do popup em px. */ fun setHeight(px: Int) { popupHeight = px }
    @Suppress("UNCHECKED_CAST") fun <T> setSpinnerTextFormatter(f: SpinnerTextFormatter<T>) { spinnerFormatter = f as SpinnerTextFormatter<Any?> }
    @Suppress("UNCHECKED_CAST") fun <T> setSelectedTextFormatter(f: SpinnerTextFormatter<T>) { selectedFormatter = f as SpinnerTextFormatter<Any?> }
    fun setOnSpinnerItemSelectedListener(l: OnSpinnerItemSelectedListener?) { selectionListener = l }

    private fun showPopup() {
        val p = ListPopupWindow(context)
        p.anchorView = this
        p.setAdapter(object : ArrayAdapter<CharSequence>(context, android.R.layout.simple_list_item_1, items.map { spinnerFormatter.format(it) }) {})
        p.width = width
        if (popupHeight > 0) p.height = popupHeight
        p.isModal = true
        p.setOnItemClickListener { _, v, position, id ->
            setSelectedIndex(position, false)
            selectionListener?.onItemSelected(this, v, position, id)
            p.dismiss()
        }
        popup = p
        p.show()
    }
}
