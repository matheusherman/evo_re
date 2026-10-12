package com.foxivid.ui.mobile.widget

import com.foxivid.ui.mobile.R

import android.content.Context
import android.graphics.Rect
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * ItemDecoration com margens fixas (esquerda/topo/direita/baixo). A condição
 * `childLayoutPosition != childCount` do original é quase sempre verdadeira; mantida por fidelidade.
 * Original: com/tvc/lib/mobile/ui/widget/q.java
 */
class RectItemDecoration(
    private val left: Int,
    private val top: Int,
    private val right: Int,
    private val bottom: Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(rect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        rect.left = left
        val childCount = parent.childCount
        if (parent.getChildLayoutPosition(view) != childCount) rect.right = right
        if (parent.getChildLayoutPosition(view) != childCount) rect.bottom = bottom
        rect.top = top
    }
}

/**
 * Adapter de sugestões de e-mail do [AutoCompleteEditText]: dado um prefixo (texto antes do "@") e
 * uma lista de domínios, `getItem(i)` devolve prefixo+domínio. O Filter retorna sempre a lista inteira.
 * Layout `spinner_edit_text` (id `list_item`, gravity esquerda).
 *
 * Original: com/tvc/lib/mobile/ui/widget/r.java
 */
class EmailSuggestionAdapter(private val context: Context) : BaseAdapter(), Filterable {
    private val items = ArrayList<String>()
    private val inflater = context.getSystemService("layout_inflater") as LayoutInflater
    private var prefix: String? = null

    private class Holder { lateinit var text: TextView }

    /** Original: r.c(String, List<String>) */
    fun setData(prefix: String?, list: List<String>) {
        items.clear()
        if (!TextUtils.isEmpty(prefix)) {
            this.prefix = prefix
            items.addAll(list)
        }
        notifyDataSetChanged()
    }

    override fun getCount(): Int = items.size
    override fun getItem(position: Int): String = prefix + items[position]
    override fun getItemId(position: Int): Long = 0L

    override fun getFilter(): Filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val r = FilterResults()
            r.values = items
            r.count = items.size
            return r
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults) {
            if (results.count > 0) notifyDataSetChanged() else notifyDataSetInvalidated()
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: Holder
        if (convertView == null) {
            view = inflater.inflate(R.layout.spinner_edit_text, null as ViewGroup?)
            holder = Holder()
            holder.text = view.findViewById(R.id.list_item)
            holder.text.gravity = 3
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as Holder
        }
        holder.text.text = getItem(position)
        return view
    }
}
