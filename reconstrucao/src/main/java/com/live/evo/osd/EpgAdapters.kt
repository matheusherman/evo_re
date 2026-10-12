package com.live.evo.osd

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.live.evo.model.ProgramBean
import com.live.evo.util.DateUtils
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.concurrent.TimeUnit

/**
 * Adapter ListView da EPG simples do OSD: linha "HH:mm - HH:mm", nome e rótulo de reprodução
 * (`playback`/`cancel` conforme o programa esteja passado/gravado). Layout `epg_item`.
 * Original: com/live/evo/osd/b.java
 */
class EpgListAdapter(private val context: Context) : BaseAdapter() {
    private var items: MutableList<ProgramBean> = mutableListOf()
    private var channelId: String? = null
    private var selected = -1

    /** Original: a(List, String) */
    fun setData(list: List<ProgramBean>?, channelId: String?) {
        items.clear()
        if (list != null) items.addAll(list)
        this.channelId = channelId
        if (items.size > 0) notifyDataSetChanged()
    }

    /** Original: b(int) */
    fun setSelected(position: Int) {
        if (selected == position) return
        selected = position
        notifyDataSetChanged()
    }

    override fun getCount() = items.size
    override fun getItem(position: Int): Any? = null
    override fun getItemId(position: Int) = 0L

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // TODO("parcial: preenchimento de cores/estado de reprodução (q1.b/q1.f) — ver osd/b.getView")
        val p = items[position]
        val fmt = "%s - %s"
        val text = String.format(fmt, DateUtils.format(p.startTime, "HH:mm"), DateUtils.format(p.endTime, "HH:mm"))
        return convertView ?: View(context).also { it.tag = text }
    }
}

/**
 * Adapter RecyclerView de um dia da EPG (itens filhos `epg_item_child`): nome, horário,
 * ícone de playback (`menu_playback_focus_icon`/`menu_playback_icon`). Ao focar um item,
 * guarda a posição e destaca as cores (`epgitemchild_tv_*_select_tc/focus_tc/normal_tc`).
 * Original: com/live/evo/osd/d.java
 */
class EpgChildAdapter(
    private val context: Context,
    private val programs: List<ProgramBean>,
    private val listener: EpgItemListener?,
) : RecyclerView.Adapter<EpgChildAdapter.Holder>() {
    private var focusedPosition = -1
    private var playingPosition = -1
    /** Meia-noite do dia exibido. Original: k(long) */
    var dayStart: Long = 0

    /** Marca o programa em exibição. Original: l(int) */
    fun setPlaying(position: Int) { playingPosition = position }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView? = null
        val time: TextView? = null
        val playback: ImageView? = null
    }

    override fun getItemCount() = programs.size
    override fun getItemId(position: Int) = position.toLong()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        TODO("inflar R.layout.epg_item_child — layout, ver osd/d.onCreateViewHolder")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        // TODO("parcial: bind (horário HH:mm, nome, ícones) — ver osd/d.onBindViewHolder")
    }
}

/**
 * Adapter externo da "grande EPG" em forma de diálogo: um item por dia (14 dias, centrado em hoje,
 * 7 antes e 7 depois). Agrupa programas por data ("ddMMyyyy"), incluindo programas que cruzam a meia-noite
 * nos dois dias. Cada item exibe dia da semana, data ("today" para hoje), uma `VerticalGridView`
 * com um [EpgChildAdapter] e "sem dados" se vazio.
 * Original: com/live/evo/osd/f.java
 */
class EpgDayAdapter(
    private val context: Context,
    private val listener: EpgItemListener?,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val byDay: MutableMap<String, MutableList<ProgramBean>> = HashMap()
    private var dayCount = 14
    private var centerIndex = 14 / 2
    private var currentIndex = 0
    private val dayMillis = TimeUnit.DAYS.toMillis(1)
    private val dateFormat = SimpleDateFormat("ddMMyyyy")

    /** Agrupa por dia; se houver 1..14 dias usa-os, senão 14. Original: b(List)/d(List) */
    fun setData(list: List<ProgramBean>?) {
        byDay.clear()
        if (list == null) return
        for (p in list) {
            val start = dateFormat.format(Date(p.startTime))
            byDay.getOrPut(start) { mutableListOf() }.add(p)
            val end = dateFormat.format(Date(p.endTime))
            if (start != end && DateUtils.dayStart(end) != p.endTime) byDay.getOrPut(end) { mutableListOf() }.add(p)
        }
        if (byDay.size <= 0 || byDay.size > 14) { dayCount = 14 } else { dayCount = byDay.size; centerIndex = dayCount / 2 }
        notifyDataSetChanged()
    }

    /** Original: c() */ fun centerIndex() = centerIndex
    override fun getItemCount() = dayCount
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        TODO("inflar R.layout.epg_dialog_parent")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // Original: dia = agora + (position - centerIndex) * 1 dia; lista = byDay[fmt(dia)];
        // exibe weekday (Calendar.DAY_OF_WEEK), "today" ou data; cor `epgdlgparent_tv_date_focus_tc` se position==0;
        // define EpgChildAdapter(context, lista, listener) e marca o programa em curso se for hoje.
        val cal = Calendar.getInstance()
        cal.time = Date(System.currentTimeMillis() + (position - centerIndex) * dayMillis)
    }
}
