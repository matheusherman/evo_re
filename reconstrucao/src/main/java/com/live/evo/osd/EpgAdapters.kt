package com.live.evo.osd

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.live.evo.model.ProgramBean
import com.live.evo.R
import com.live.evo.UiFunctionConfig
import com.live.evo.util.CommonUtils
import com.live.evo.util.DateUtils
import com.live.evo.util.LoginConfig
import com.live.evo.util.ModelHelper
import com.live.evo.util.TextStyleUtils
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

    private class Holder(view: View) {
        val time: TextView = view.findViewById(R.id.epgitem_tv_time)
        val name: TextView = view.findViewById(R.id.epgitem_tv_name)
        val play: TextView = view.findViewById(R.id.epgitem_tv_play)
        var statusSelected = false   // f7059d: o fundo "statusfly" já foi aplicado
        init {
            if (LoginConfig.get().flagA()) { TextStyleUtils.b(time); TextStyleUtils.b(name); TextStyleUtils.b(play) }
            else { TextStyleUtils.a(time); TextStyleUtils.b(name); TextStyleUtils.d(play) }
        }
    }
    private val inflater = LayoutInflater.from(context)

    /**
     * Linha da EPG: "HH:mm - HH:mm" + nome + rótulo à direita — passado: `playback` (se catch-up disponível) ou oculto; no ar: `is_playing`;
     * futuro até amanhã e com agendamento habilitado: `cancel` (já agendado) / `epg_subscribe`; senão oculto. A linha selecionada usa o fundo
     * `epg_statusfly_bg`; as demais voltam a `epg_playstatus_bg` (se tinham o outro). Original: getView(int, View, ViewGroup)
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val h: Holder
        if (convertView == null) {
            view = inflater.inflate(R.layout.epg_item, parent, false)
            h = Holder(view); view.tag = h
        } else { view = convertView; h = convertView.tag as Holder }
        val p = items[position]
        val start = p.f()
        val end = p.g()
        val now = DateUtils.now()
        val tomorrow = DateUtils.plusDays(now, 1)
        h.time.text = String.format("%s - %s", DateUtils.format(start, CommonUtils.string(R.string.HHmm)), DateUtils.format(end, CommonUtils.string(R.string.HHmm)))
        h.name.text = p.e()
        h.play.visibility = View.VISIBLE
        if (end < now) {
            if (ModelHelper.isCatchUpAvailable(p.b(), channelId, start)) h.play.text = CommonUtils.string(R.string.playback)
            else h.play.visibility = View.INVISIBLE
        } else if (start <= now) {
            h.play.text = CommonUtils.string(R.string.is_playing)
        } else if (!UiFunctionConfig.get().subscribeEnabled() || start > tomorrow) {
            h.play.visibility = View.INVISIBLE
        } else if (ModelHelper.isSubscribed(p, channelId)) {
            h.play.text = CommonUtils.string(R.string.cancel)
        } else {
            h.play.text = CommonUtils.string(R.string.epg_subscribe)
        }
        if (selected == position) {
            h.statusSelected = true
            h.play.setBackgroundResource(R.drawable.epg_statusfly_bg)
            return view
        }
        if (h.statusSelected) h.play.setBackgroundResource(R.drawable.epg_playstatus_bg)
        h.statusSelected = false
        return view
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

    /** Holder: foco troca cores e ícone de playback; clique dispara [EpgItemListener.onProgramSelected]. Original: osd/d$a */
    inner class Holder(view: View) : RecyclerView.ViewHolder(view), View.OnFocusChangeListener {
        val name: TextView = view.findViewById(R.id.epgitemchild_tv_name)
        val time: TextView = view.findViewById(R.id.epgitemchild_tv_time)
        val previousLeft: TextView = view.findViewById(R.id.epgitemchild_tv_previous_left)
        val previousRight: TextView = view.findViewById(R.id.epgitemchild_tv_previous_right)
        val playIcon: View = view.findViewById(R.id.epgitemchild_iv_play)
        val playback: ImageView = view.findViewById(R.id.iv_playback)
        var isCurrent = false      // f7077f (programa atual)
        init {
            if (LoginConfig.get().flagA()) { TextStyleUtils.b(time); TextStyleUtils.b(name) }
            else { TextStyleUtils.d(time); TextStyleUtils.b(name) }
            view.isFocusable = true
            view.isFocusableInTouchMode = true
            view.onFocusChangeListener = this
        }
        /** Ícone de playback com/sem destaque. Original: f(boolean) */
        fun setPlaybackFocus(focused: Boolean) {
            playback.setImageDrawable(context.resources.getDrawable(if (focused) R.drawable.menu_playback_focus_icon else R.drawable.menu_playback_icon))
        }
        override fun onFocusChange(v: View, hasFocus: Boolean) {
            val timeColor: Int; val nameColor: Int
            if (hasFocus) {
                itemView.isSelected = true
                if (adapterPosition == -1) return
                focusedPosition = adapterPosition
                notifyFocused(this, focusedPosition)
                timeColor = R.color.epgitemchild_tv_time_select_tc
                nameColor = R.color.epgitemchild_tv_name_select_tc
            } else {
                if (isCurrent) { timeColor = R.color.epgitemchild_tv_time_focus_tc; nameColor = R.color.epgitemchild_tv_name_focus_tc }
                else { timeColor = R.color.epgitemchild_tv_time_normal_tc; nameColor = R.color.epgitemchild_tv_name_normal_tc }
                itemView.isSelected = false
            }
            previousRight.setTextColor(CommonUtils.color(timeColor))
            previousLeft.setTextColor(CommonUtils.color(timeColor))
            time.setTextColor(CommonUtils.color(timeColor))
            name.setTextColor(CommonUtils.color(nameColor))
            setPlaybackFocus(hasFocus)
        }
    }

    private var clickBusy = false     // f7071j
    private val inflater = LayoutInflater.from(context)
    init { setHasStableIds(true) }

    /** Avisa o listener que o item ganhou foco: (horário, nome, `ProgramBean.a()`). Original: e(a, int) */
    private fun notifyFocused(holder: Holder, position: Int) {
        try { listener?.onCatchUp(holder.time.text.toString(), holder.name.text.toString(), programAt(position)!!.a()!!) }
        catch (e: Exception) { logger.error("focus changed error", e) }
    }
    private val logger = org.slf4j.LoggerFactory.getLogger(EpgChildAdapter::class.java)

    /** Programa na posição (null fora do intervalo). Original: f(int) */
    fun programAt(position: Int): ProgramBean? = if (position < 0 || position >= programs.size) null else programs[position]
    /** Posição do programa em exibição. Original: g() */ fun playingPosition() = playingPosition

    override fun getItemCount() = programs.size
    override fun getItemId(position: Int): Long = programs.getOrNull(position)?.id ?: position.toLong()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(inflater.inflate(R.layout.epg_item_child, parent, false))

    /**
     * Nome, horário "HH:mm - HH:mm", marcador de "em exibição" ([playingPosition]), setas "anterior" (programa começou antes do dia) /
     * "seguinte" (termina depois do dia), ícone de playback (se o listener diz que há catch-up) e clique que seleciona o programa
     * (evita reentrada). Original: onBindViewHolder(a, int)
     */
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val p = programs[position]
        holder.name.text = p.e()
        val start = p.f(); val end = p.g()
        val fmt = java.text.SimpleDateFormat(CommonUtils.string(R.string.HHmm))
        holder.time.text = String.format("%s - %s", fmt.format(java.util.Date(start)), fmt.format(java.util.Date(end)))
        holder.playIcon.visibility = if (playingPosition == position) View.VISIBLE else View.GONE
        holder.isCurrent = playingPosition == position
        val day = dayStart
        if (start < day) { holder.previousLeft.visibility = View.VISIBLE; holder.previousRight.visibility = View.GONE }
        else if (end > day + TimeUnit.DAYS.toMillis(1L)) { holder.previousRight.visibility = View.VISIBLE; holder.previousLeft.visibility = View.GONE }
        else { holder.previousLeft.visibility = View.GONE; holder.previousRight.visibility = View.GONE }
        holder.playback.visibility = if (listener != null && listener.isCatchUpAvailable(p)) View.VISIBLE else View.GONE
        holder.setPlaybackFocus(holder.itemView.hasFocus())
        holder.itemView.isClickable = true
        holder.itemView.setOnClickListener {
            if (clickBusy) return@setOnClickListener
            clickBusy = true
            programAt(position)?.let { listener?.onProgramSelected(it) }
            clickBusy = false
        }
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
    /** Item de um dia: dia da semana, data, grade de programas e "sem dados". Original: osd/f$a */
    inner class DayHolder(view: View) : RecyclerView.ViewHolder(view) {
        val week: TextView = view.findViewById(R.id.epgdlgparent_tv_week)
        val date: TextView = view.findViewById(R.id.epgdlgparent_tv_date)
        val grid: androidx.leanback.widget.VerticalGridView = view.findViewById(R.id.epgdlgparent_gv_epg)
        val noData: TextView = view.findViewById(R.id.epgdlgparent_tv_not_data)
        init {
            if (LoginConfig.get().flagA()) { TextStyleUtils.c(week); TextStyleUtils.b(date); TextStyleUtils.b(noData) }
            else { TextStyleUtils.a(week); TextStyleUtils.d(date); TextStyleUtils.b(noData) }
            grid.setNumColumns(1)
            grid.setWindowAlignment(1)
            noData.setOnFocusChangeListener { _, focused -> listener?.onFocusChanged(focused) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        DayHolder(LayoutInflater.from(context).inflate(R.layout.epg_dialog_parent, parent, false))

    /**
     * Dia = agora + (posição - centro) dias; lista = programas do dia (ou vazia). Mostra dia da semana e "hoje"/data; sem programas
     * mostra "sem dados"; cor de foco `epgdlgparent_tv_date_focus_tc` só no item 0. Define o [EpgChildAdapter] e, se for hoje, marca
     * o programa em exibição. Original: onBindViewHolder(RecyclerView.ViewHolder, int)
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val h = holder as DayHolder
        h.itemView.tag = (position + 1).toString()
        val now = DateUtils.now()
        val todayKey = dateFormat.format(Date(now))
        val dayTime = now + (position - centerIndex) * dayMillis
        val cal = Calendar.getInstance()
        val date = Date(dayTime)
        cal.time = date
        val key = dateFormat.format(date)
        val list = byDay[key] ?: mutableListOf()
        h.week.text = DateUtils.weekdayName(cal.get(Calendar.DAY_OF_WEEK))
        h.date.text = if (key == todayKey) context.getString(R.string.today) else key
        if (list.isEmpty()) { h.grid.visibility = View.GONE; h.noData.visibility = View.VISIBLE }
        else { h.grid.visibility = View.VISIBLE; h.noData.visibility = View.GONE }
        val color = if (position == 0) R.color.epgdlgparent_tv_date_focus_tc else R.color.epgdlgparent_tv_date_normal_tc
        h.week.setTextColor(CommonUtils.color(color))
        h.date.setTextColor(CommonUtils.color(color))
        val child = EpgChildAdapter(context, list, listener)
        child.dayStart = DateUtils.startOfDay(dayTime)
        if (key == todayKey && list.isNotEmpty()) {
            for (i in list.indices) {
                val p = list[i]
                if (dayTime >= p.f() && dayTime < p.g()) { currentIndex = i; child.setPlaying(i); break }
            }
        }
        h.grid.adapter = child
    }
}
