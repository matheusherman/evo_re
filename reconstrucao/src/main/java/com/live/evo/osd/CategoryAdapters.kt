package com.live.evo.osd

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.live.evo.R
import com.live.evo.model.CategoryBean
import com.live.evo.model.QuestionBean

/**
 * Adapter das categorias de programas (`program_classify_item`): ícone (url `normal`/`focus`)
 * ou, se não houver imagem, o nome textual. Quando o item selecionado tem as duas imagens, usa a de foco.
 * Original: com/live/evo/osd/m.java
 */
class ProgramClassifyAdapter(private val context: Context) : BaseAdapter() {
    private val ids: MutableList<String> = mutableListOf()
    private val categories: MutableMap<String, CategoryBean> = HashMap()
    var selectedIndex = 0
    var disabled = false

    /** Original: a(List) */
    fun setIds(list: List<String>?) { ids.clear(); if (list != null) ids.addAll(list) }

    override fun getCount() = ids.size
    override fun getItem(position: Int): Any? = null
    override fun getItemId(position: Int) = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.program_classify_item, parent, false)
        val img = view.findViewById<ImageView>(R.id.programclassifyitem_iv_img)
        val name = view.findViewById<TextView>(R.id.programclassifyitem_tv_name)
        (name.parent as View).isEnabled = !disabled && selectedIndex == position
        val c = categories[ids[position]]
        name.text = c?.name ?: "null"
        // sem imagens -> mostra nome; com imagem -> mostra ícone (foco usa a imagem alternativa)
        return view
    }
}

/**
 * Adapter de perguntas frequentes (FAQ): número, pergunta e resposta (`question_item`).
 * Original: com/live/evo/osd/n.java
 */
class QuestionAdapter(private val context: Context) : BaseAdapter() {
    private val items: MutableList<QuestionBean> = mutableListOf()
    fun setData(list: List<QuestionBean>?) { if (list != null) { items.clear(); items.addAll(list) }; notifyDataSetChanged() }
    override fun getCount() = items.size
    override fun getItem(position: Int): Any? = null
    override fun getItemId(position: Int) = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val v = convertView ?: LayoutInflater.from(context).inflate(R.layout.question_item, parent, false)
        v.findViewById<TextView>(R.id.tv_numbers).text = "${position + 1}"
        v.findViewById<TextView>(R.id.tv_question).text = items[position].question
        v.findViewById<TextView>(R.id.tv_answer).text = items[position].answer
        return v
    }
}
