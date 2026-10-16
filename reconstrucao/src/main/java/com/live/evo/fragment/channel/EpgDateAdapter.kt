package com.live.evo.fragment.channel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.RelativeLayout
import android.widget.TextView
import com.live.evo.R
import com.live.evo.util.CommonUtils
import com.live.evo.util.LoginConfig
import com.live.evo.util.TextStyleUtils

/**
 * Adapter da lista de datas da EPG (`programviewl_lv_epg_date`; item `epg_date_item`): dia da semana + número do dia,
 * com o dia selecionado destacado e uma seta (`iv_arrow`). O dia "de hoje" fica no índice [todayIndex]
 * (inicialmente 7: a lista mostra 7 dias passados e `count - 7` futuros).
 *
 * Original: n5/b.java (nome reconstruído: o de `epgDateAdapter` no `ChannelFragment`)
 */
class EpgDateAdapter(private val context: Context) : BaseAdapter() {
    /** Posição atualmente selecionada (`b()`). Original: `f15962b`. */
    private var selectedIndex = 7
    /** Índice do dia de hoje (`c()`). Original: `f15963c`. */
    private var todayIndex = 7
    /** Quantidade de dias (`a()`). Original: `f15964d`. */
    private var dayCount = 14
    /** Posição "com foco" (destacada com `list_focus_bg`). Original: `f15965e`. */
    private var focusedIndex = 0

    private class Holder(view: View) {
        val week: TextView = view.findViewById(R.id.tv_week)
        val date: TextView = view.findViewById(R.id.tv_date)
        val parent: View = view.findViewById(R.id.ll_parent)
        val arrow: View = view.findViewById(R.id.iv_arrow)
        val circle: RelativeLayout = view.findViewById(R.id.rl_cir)
        var focused = false   // f(boolean)

        init {
            if (LoginConfig.get().flagA()) {
                TextStyleUtils.b(date); TextStyleUtils.b(week)
            } else {
                TextStyleUtils.d(date); TextStyleUtils.b(week)
            }
        }
    }

    override fun getItem(position: Int): Any? = null
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getCount(): Int = dayCount

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: Holder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.epg_date_item, parent, false)
            holder = Holder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as Holder
        }
        val calendar = ChannelDateShims.calendarAtOffset(com.live.evo.util.DateUtils.today(), position - todayIndex)
        if (position == focusedIndex) {
            holder.parent.isEnabled = false
            holder.focused = true
            holder.parent.setBackgroundResource(R.drawable.list_focus_bg)
        } else {
            holder.parent.isEnabled = (selectedIndex == position)
            holder.focused = false
            holder.parent.setBackgroundResource(R.drawable.icon_transport)
        }
        if (position == selectedIndex) {
            holder.circle.isEnabled = true
            // R.color.black (cor usada quando o item está com foco) / color_focused
            val color = if (position == focusedIndex) CommonUtils.color(R.color.black) else CommonUtils.color(R.color.color_focused)
            holder.date.setTextColor(color)
            holder.week.setTextColor(color)
            holder.arrow.visibility = View.VISIBLE
        } else {
            holder.circle.isEnabled = false
            val color = CommonUtils.color(R.color.color_eeeeee)
            holder.date.setTextColor(color)
            holder.week.setTextColor(color)
            holder.arrow.visibility = View.GONE
        }
        holder.week.text = ChannelDateShims.weekdayName(calendar.get(java.util.Calendar.DAY_OF_WEEK))
        if (position == todayIndex && LoginConfig.get().flagG()) {
            holder.date.text = CommonUtils.string(R.string.today)
            return view
        }
        holder.date.text = calendar.get(java.util.Calendar.DAY_OF_MONTH).toString()
        return view
    }

    /** Quantidade de dias. Original: a() */
    fun dayCount(): Int = dayCount
    /** Posição selecionada. Original: b() */
    fun selectedIndex(): Int = selectedIndex
    /** Índice de hoje. Original: c() */
    fun todayIndex(): Int = todayIndex

    /** Seleciona [position]; se [focused], também a marca como item com foco. Original: d(int, boolean) */
    fun select(position: Int, focused: Boolean) {
        selectedIndex = position
        if (focused) focusedIndex = position
        notifyDataSetChanged()
    }

    /** Define o total de dias; `hoje = total - 7` (ou 0 se total < 7). Original: e(int) */
    fun setDayCount(count: Int) {
        dayCount = count
        todayIndex = if (count >= 7) count - 7 else 0
        notifyDataSetChanged()
    }

    /** Define só o item com foco (-1 = nenhum). Original: f(int) */
    fun setFocusedIndex(position: Int) {
        focusedIndex = position
        notifyDataSetChanged()
    }
}
