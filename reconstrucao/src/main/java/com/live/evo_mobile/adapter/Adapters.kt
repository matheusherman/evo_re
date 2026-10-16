package com.live.evo_mobile.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView

/*
 * Adapters de listas do app mobile (base: com.tvc.lib.mobile `r7.e`/`r7.c`/`r7.a` = BaseRecyclerAdapter da UI lib compartilhada).
 * Puro boilerplate de bind; resumido.
 */

/** Títulos de categorias de canal (ChannelTitleData). Original: com/live/evo_mobile/adapter/a.java */
class ChannelTitleAdapter
/** Datas da EPG (EpgDateData). Original: com/live/evo_mobile/adapter/b.java */
class EpgDateAdapter
/**
 * Itens de EPG (EpgData): botões `tv_guide_subscribe`/`tv_guide_unsubscribe`/`tv_guide_catchup` conforme o estado do
 * programa (futuro → agendar/cancelar; passado com catch-up → assistir). Original: com/live/evo_mobile/adapter/d.java (EpgListAdapter.kt)
 */
class EpgListAdapter
/** Histórico de canais com modo de seleção (`isSelected`). Original: com/live/evo_mobile/adapter/f.java (HistoryLiveListData) */
class HistoryLiveListAdapter
/** Resultado da busca de canais (LiveSearchListData). Original: com/live/evo_mobile/adapter/g.java */
class LiveSearchAdapter
/**
 * Lista de strings (histórico de busca, layout `item_search_history`, TextView `search_hisotry_item_tv`) com listener de clique;
 * [setData] troca a lista e notifica. Original: com/live/evo_mobile/adapter/i.java (+ i$a listener, i$b ViewHolder)
 */
class StringListAdapter(private var dataList: List<String>, private val inflater: LayoutInflater, private val listener: (String) -> Unit) : RecyclerView.Adapter<StringListAdapter.ViewHolder>() {
    /** Original: i.b */
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: android.widget.TextView = itemView.findViewById(com.live.evo.R.id.search_hisotry_item_tv)
    }

    override fun getItemCount() = dataList.size
    override fun getItemId(position: Int) = position.toLong()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(inflater.inflate(com.live.evo.R.layout.item_search_history, parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.textView.text = item
        holder.itemView.setOnClickListener { listener(item) }
    }

    /** Original: e(List) */
    fun setData(data: List<String>) { dataList = data; notifyDataSetChanged() }
}
/** Itens de configuração (MainSettingData). Original: com/live/evo_mobile/adapter/k.java */
class MainSettingAdapter
/** Seletor de data (ArrayAdapter<String> com `selectedId` destacado). Original: com/live/evo_mobile/adapter/l.java (DatePickAdapter) */
class DatePickAdapter(context: Context, resource: Int, private val data: List<String>, private val listView: ListView) : ArrayAdapter<String>(context, resource, data) {
    private var selectedId = 0
    fun select(id: Int) { selectedId = id; notifyDataSetChanged() }
    override fun getCount() = data.size
}
/** Histórias/categorias (StoryListData). Original: com/live/evo_mobile/adapter/n.java */
class StoryListAdapter
/** Itens de lembrete (u7.j) com ação "tv_guide_unsubscribe". Original: com/live/evo_mobile/adapter/p.java */
class SubscribeItemAdapter
