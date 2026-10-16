package com.live.evo.fragment.subject

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.live.evo.fragment.BaseMenuFragment
import com.live.evo.fragment.LazyMenuFragment
import com.live.evo.fragment.OnTabEventListener
import com.live.evo.osd.presenter.OSDListProgramPresenterContract
import com.live.evo.UiFunctionConfig
import com.live.evo.util.CommonUtils
import com.live.evo.util.DateUtils
import java.util.concurrent.TimeUnit

/*
 * "Subject" = seção de esportes/partidas (ex.: futebol). Pacote original `fragment/subjuect` (typo).
 */

/**
 * Container da aba de um tipo de Subject (layout `menu_fragment_subject`): hospeda [SubjectMatchFragment] e, em
 * cima, os filtros (classificação/data). Atualiza a lista a cada `update_dualmeet_list_int` (propriedade remota) ou
 * `subject_refresh_time` (padrão 2 h); reage a `b5.j` (SubjectUpdateEvent) e a `b5.b` (ChangeChannelEvent com tag
 * "subject_channel" → abre a partida). Argumento `position` identifica a aba ("SUBJECT_<position>").
 * Original: com/live/evo/fragment/subjuect/c0.java (nome real SubjectTabMenuFragment, ctor (presenter, y1, b5.b)); y.java = variante
 */
class SubjectTabMenuFragment(
    private val presenter: OSDListProgramPresenterContract?,
    private val listener: OnTabEventListener?,
    private val event: Any?,
) : BaseMenuFragment() {
    private val refreshMs = TimeUnit.HOURS.toMillis(2L)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(com.live.evo.R.layout.menu_fragment_subject, container, false)
    /** Evento sticky na main thread; o corpo é vazio no original (a atualização real vem do timer `mRequestDataRunnable`). */
    @org.greenrobot.eventbus.Subscribe(sticky = true, threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    fun onSubjectUpdateEvent(event: Any?) { /* corpo vazio no original */ }
}

/** Variante da aba de subject (usa o argumento `position`). Original: com/live/evo/fragment/subjuect/y.java */
class SubjectFragment : BaseMenuFragment() {
    private var refreshTask: java.util.TimerTask? = null      // f6778p
    private val timer = java.util.Timer()                      // f6779q
    private var refreshDelayMs = TimeUnit.HOURS.toMillis(2L)   // f6780r (propriedade `update_dualmeet_list_int`)
    private var matchFragment: SubjectMatchFragment? = null    // f6770h

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(com.live.evo.R.layout.menu_fragment_subject, container, false)

    /** Reagenda a tarefa periódica de atualização das partidas (cancela a anterior). Original: e0() */
    fun restartHideTimer() {
        refreshTask?.cancel()
        refreshTask = object : java.util.TimerTask() {   // classe `y$b`
            override fun run() { matchFragment?.refreshMatchStates() }
        }
        timer.schedule(refreshTask, refreshDelayMs)
    }
}

/**
 * Lista de partidas de um tipo (layout `subject_match_fragment`): cabeçalhos de liga/dia, botão "back to top"
 * (texto remoto `dualmeet_back_top_button`, padrão `back_to_top`). Clique numa partida (`f1(position)`):
 * partida passada com catch-up → `catchupListener.a("subjectMatch", programa, canalId, cb)` (toast `not_supported_playback`
 * se não suportado); partida ao vivo → troca de canal (`presenter.onSelection(0, i, i, "subjectMatch")`), toast `is_playing`
 * se já está tocando. Kotlin ("SubjectMatchFragment.kt"). Strings: `loading_data`.
 * Original: com/live/evo/fragment/subjuect/w.java
 */
class SubjectMatchFragment : BaseMenuFragment(), View.OnKeyListener {
    private var subject_date_listview: androidx.leanback.widget.VerticalGridView? = null
    private var subject_classification_listview: androidx.leanback.widget.HorizontalGridView? = null
    private var subject_match_listview: androidx.leanback.widget.VerticalGridView? = null
    private var subject_matchback_layout: android.widget.Button? = null
    private var subjectMatchAdapter: MatchAdapter? = null
    private val subjectMatchInfos = ArrayList<com.live.evo.model.SubjectMatch>()
    private val datesHasData = ArrayList<String>()
    private val mListClassification = ArrayList<com.live.evo.model.SubjectClassification>()
    private var curFocusView: View? = null
    private var matchPosition = 0
    private var classificationPos = 0
    private var mStartShowTime = 0L          // SystemClock.elapsedRealtime() do início da exibição
    private var mClassifyStartTime = 0L      // hora do servidor ao iniciar a exibição da classificação

    /** Foca [view]; se for a lista de partidas, marca o item atual como focado no adapter. Original: w1(View) */
    private fun focusList(view: View?) {
        curFocusView = view
        if (view == subject_match_listview) subjectMatchAdapter?.setSelected(subject_match_listview!!, matchPosition, true)
        view?.requestFocus()
    }

    /**
     * Teclas (ACTION_DOWN apenas; avisa o fragment pai [SubjectFragment] para reiniciar o timer de ocultar via `e0()`).
     * CIMA é sempre consumido; ESQUERDA a partir do botão "back to top" foca a lista de partidas (se há partidas) ou a de datas
     * (se há datas com dados). Original: onKey(View,int,KeyEvent)
     */
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        if (event.action != KeyEvent.ACTION_DOWN) return false
        try { (parentFragment as SubjectFragment).restartHideTimer() } catch (_: Exception) {}
        if (event.keyCode != KeyEvent.KEYCODE_DPAD_UP) {
            if (event.keyCode != KeyEvent.KEYCODE_DPAD_LEFT || v != subject_matchback_layout) return false
            if (subjectMatchInfos.size > 0) { focusList(subject_match_listview); return true }
            if (datesHasData.size > 0) focusList(subject_date_listview)
        }
        return true
    }

    /** Renotifica o adapter de partidas (estado AO VIVO/playback muda com o tempo), na main thread. Original: U0() + V0() */
    fun refreshMatchStates() {
        if (subjectMatchInfos.size == 0) return
        com.live.evo.util.RxUtils.runOnUiThread { subjectMatchAdapter!!.notifyDataSetChanged() }
    }

    /**
     * Marca o início/fim da exibição de uma classificação para métrica: com [start] zera o relógio local e guarda a hora do
     * servidor; sem [start], se passaram >= 2 s, atualiza a hora de início. (O resultado não é enviado a lugar algum neste build.)
     * Original: h1(boolean)
     */
    @Synchronized fun refresh(start: Boolean) {
        val list = subject_classification_listview ?: return
        if (list.childCount > 0 && classificationPos < mListClassification.size) {
            com.live.evo.util.ServerClock.get().now()
            val elapsed: Long
            if (start) {
                mStartShowTime = android.os.SystemClock.elapsedRealtime()
                mClassifyStartTime = com.live.evo.util.ServerClock.get().now()
                elapsed = 0
            } else {
                elapsed = android.os.SystemClock.elapsedRealtime() - mStartShowTime
            }
            if (elapsed >= 2000) mClassifyStartTime = com.live.evo.util.ServerClock.get().now()
        }
    }
}

/**
 * Adapter de partidas (`subject_match_item`; `playback`/`cancel`, ícone "no_icon"). Mostra "NNN  nome do canal", times e placar
 * ("?" se sem placar), horário "HH:mm - HH:mm" e o estado: lembrar/cancelar (futuro, com agendamento ligado), AO VIVO,
 * playback (catch-up disponível) ou vazio.
 * Original: com/live/evo/fragment/subjuect/c.java
 */
class MatchAdapter(private val context: android.content.Context, list: List<com.live.evo.model.SubjectMatch>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = ArrayList<com.live.evo.model.SubjectMatch>().also { it.addAll(list) }
    private var selected = 0               // f6652d
    private var focused = false            // f6653e
    private var channels: Map<String, com.live.evo.model.ChannelData> = com.live.evo.util.ModelHelper.channelsById()   // f6654f

    class MatchHolder(view: View) : RecyclerView.ViewHolder(view) {
        val id: android.widget.TextView = view.findViewById(com.live.evo.R.id.subject_id_tv)
        val state: android.widget.TextView = view.findViewById(com.live.evo.R.id.subject_state_tv)
        val programIcon: android.widget.ImageView = view.findViewById(com.live.evo.R.id.subject_program_iv)
        val title: android.widget.TextView = view.findViewById(com.live.evo.R.id.subject_title_tv)
        val time: android.widget.TextView = view.findViewById(com.live.evo.R.id.subject_time_tv)
        val score1: android.widget.TextView = view.findViewById(com.live.evo.R.id.subject_score_tv)
        val scoreVs: android.widget.TextView = view.findViewById(com.live.evo.R.id.tv_subject_score_vs)
        val score2: android.widget.TextView = view.findViewById(com.live.evo.R.id.subject_score_tv2)
        val team1: android.widget.TextView = view.findViewById(com.live.evo.R.id.subject_match_tv1)
        val team2: android.widget.TextView = view.findViewById(com.live.evo.R.id.subject_match_tv2)
        val teamIcon1: android.widget.ImageView = view.findViewById(com.live.evo.R.id.subject_match_iv1)
        val teamIcon2: android.widget.ImageView = view.findViewById(com.live.evo.R.id.subject_match_iv2)
        val layout: android.widget.LinearLayout = view.findViewById(com.live.evo.R.id.subject_item_layout)
    }

    /** Substitui a lista (preservando a seleção se válida) e rola até ela. Original: b(RecyclerView, Integer, List) */
    fun setData(list: RecyclerView, position: Int?, matches: List<com.live.evo.model.SubjectMatch>) {
        val pos = position ?: selected
        items.clear(); items.addAll(matches)
        if (pos < itemCount) selected = pos
        list.post { notifyDataSetChanged(); list.post { if (pos < itemCount) list.scrollToPosition(pos) } }
    }

    /** Seleciona [position] (ignora fora do intervalo), marca foco e recarrega o mapa de canais. Original: c(RecyclerView, Integer, Boolean) */
    fun setSelected(list: RecyclerView, position: Int?, hasFocus: Boolean?) {
        var pos = selected
        if (position != null) { if (position >= itemCount) return else pos = position }
        if (hasFocus != null) focused = hasFocus
        channels = com.live.evo.util.ModelHelper.channelsById()
        val old = selected
        if (pos != old) { selected = pos; list.scrollToPosition(pos) }
        list.post {
            val cur = selected
            if (cur < itemCount) { if (old != cur) notifyItemChanged(old); notifyItemChanged(cur) }
        }
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MatchHolder(android.view.LayoutInflater.from(context).inflate(com.live.evo.R.layout.subject_match_item, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val h = holder as MatchHolder
        val m = items[position]
        val noChannel = m.channelId.isNullOrEmpty()
        var icon: String
        if (noChannel) {
            h.id.setText(com.live.evo.R.string.no_channel); icon = "no_icon"
        } else {
            val ch = channels[m.channelId]
            val number: Int; val name: String
            if (ch != null) { icon = ch.iconUrl ?: "no_icon"; number = ch.number + 1; name = ch.name ?: "" }
            else { number = position; name = ""; icon = "no_icon" }
            h.id.text = (if (number < 10) "00" else if (number < 100) "0" else "") + number + "  " + name
        }
        val ui = com.live.evo.util.GlideImageLoader
        if (icon == "no_icon") ui.load(context, com.live.evo.R.drawable.menu_tv_icon, android.R.color.transparent, h.programIcon)
        else ui.load(context, icon, android.R.color.transparent, h.programIcon)
        h.title.text = m.title
        h.time.text = String.format("%s - %s", DateUtils.format(m.startTime, CommonUtils.string(com.live.evo.R.string.HHmm)), DateUtils.format(m.endTime, CommonUtils.string(com.live.evo.R.string.HHmm)))
        val teams = m.teams
        var icon1: String? = ""; var icon2: String? = ""
        if (teams.isNullOrEmpty()) { h.team1.text = "——"; h.team2.text = "——" }
        else {
            icon1 = teams[0].icon; h.team1.text = teams[0].name
            if (teams.size == 1) h.team2.text = "——" else { icon2 = teams[1].icon; h.team2.text = teams[1].name }
        }
        ui.load(context, icon1, android.R.color.transparent, h.teamIcon1)
        ui.load(context, icon2, android.R.color.transparent, h.teamIcon2)
        h.score1.text = m.homeScore ?: "?"
        h.scoreVs.text = ":"; h.scoreVs.visibility = View.VISIBLE
        h.score2.text = m.awayScore ?: "?"; h.score2.visibility = View.VISIBLE
        if (noChannel) {
            h.state.text = ""; h.state.background = androidx.core.content.ContextCompat.getDrawable(context, android.R.color.transparent)
        } else {
            val now = DateUtils.now()
            fun style(textRes: Int, colorRes: Int, bgRes: Int) {
                h.state.text = CommonUtils.string(textRes)
                h.state.setTextColor(androidx.core.content.ContextCompat.getColor(context, colorRes))
                h.state.background = androidx.core.content.ContextCompat.getDrawable(context, bgRes)
            }
            fun clear() { h.state.text = ""; h.state.background = androidx.core.content.ContextCompat.getDrawable(context, android.R.color.transparent) }
            if (m.startTime > now) {
                if (UiFunctionConfig.get().subscribeEnabled()) {
                    val bean = com.live.evo.model.ProgramBean(null, m.epgId, m.startTime, m.title, m.endTime, m.channelId + m.startTime, m.matchId)
                    if (com.live.evo.util.ModelHelper.isSubscribed(bean, m.channelId))
                        style(com.live.evo.R.string.cancel, com.live.evo.R.color.subject_match_subsriblecancel, com.live.evo.R.drawable.subject_match_subcribecancel)
                    else style(com.live.evo.R.string.epg_subscribe, com.live.evo.R.color.subject_match_subsrible, com.live.evo.R.drawable.subject_match_subcribe)
                } else clear()
            } else if (m.endTime >= now) {
                style(com.live.evo.R.string.live, com.live.evo.R.color.subject_match_live, com.live.evo.R.drawable.subject_match_live)
            } else if (com.live.evo.util.ModelHelper.isCatchUpAvailable(m.epgId, m.channelId, m.startTime)) {
                style(com.live.evo.R.string.playback, com.live.evo.R.color.subject_match_live, com.live.evo.R.drawable.subject_match_live)
            } else clear()
        }
        if (selected != position) h.layout.setBackgroundResource(android.R.color.transparent)
        else if (focused) h.layout.setBackgroundResource(com.live.evo.R.drawable.subject_match_select)
        else h.layout.setBackgroundResource(com.live.evo.R.drawable.subject_match_select_not_focus)
    }
}

/**
 * Adapter de classificação/ligas (`subject_matchclassification_item`): nome, ícone opcional; item selecionado fica
 * maior (22 sp) e destacado (preto se a lista tem o foco, senão `color_focused` + fundo `subject_date_bg_focus`).
 * Original: com/live/evo/fragment/subjuect/d.java
 */
class MatchClassificationAdapter(private val context: android.content.Context, list: List<com.live.evo.model.SubjectClassification>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = ArrayList<com.live.evo.model.SubjectClassification>().also { if (!list.isNullOrEmpty()) it.addAll(list) }
    private var selected = 0
    private var focused = false

    class ClassHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: android.widget.TextView = view.findViewById(com.live.evo.R.id.subject_classification_tv)
        val layout: android.widget.LinearLayout = view.findViewById(com.live.evo.R.id.subject_classification_layout)
        val layout2: android.widget.LinearLayout = view.findViewById(com.live.evo.R.id.subject_classification_layout2)
        val icon: android.widget.ImageView = view.findViewById(com.live.evo.R.id.subject_classification_iv)
    }

    /** Troca a lista e a posição selecionada (na main thread via post). Original: c(RecyclerView, List, int) */
    fun setData(list: RecyclerView, data: List<com.live.evo.model.SubjectClassification>?, position: Int) {
        list.post {
            items.clear()
            if (!data.isNullOrEmpty()) items.addAll(data)
            selected = position
            notifyDataSetChanged()
        }
    }

    /** Seleciona [position] e define se a lista tem foco. Original: d(RecyclerView, int, boolean) */
    fun setSelected(list: RecyclerView, position: Int, hasFocus: Boolean) {
        if (position != selected) list.scrollToPosition(position)
        selected = position
        focused = hasFocus
        list.post { notifyDataSetChanged() }
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ClassHolder(android.view.LayoutInflater.from(context).inflate(com.live.evo.R.layout.subject_matchclassification_item, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val h = holder as ClassHolder
        h.name.text = items[position].name
        val isSel = selected == position
        h.layout.isEnabled = isSel; h.layout.isSelected = focused && isSel
        h.layout2.isEnabled = isSel; h.layout2.isSelected = focused && isSel
        h.name.isEnabled = isSel; h.name.isSelected = focused && isSel
        h.name.setBackgroundResource(android.R.color.transparent)
        if (isSel) {
            h.name.setTextSize(android.util.TypedValue.COMPLEX_UNIT_SP, 22.0f)
            if (focused) h.name.setTextColor(CommonUtils.color(android.R.color.black))
            else {
                h.name.setTextColor(CommonUtils.color(com.live.evo.R.color.color_focused))
                h.name.setBackgroundResource(com.live.evo.R.drawable.subject_date_bg_focus)
            }
        } else {
            h.name.setTextSize(android.util.TypedValue.COMPLEX_UNIT_SP, 18.0f)
            h.name.setTextColor(CommonUtils.color(com.live.evo.R.color.subject_classificationtext_list))
        }
        val icon = items[position].icon
        if (icon.isNullOrEmpty()) h.icon.visibility = View.GONE
        else { h.icon.visibility = View.VISIBLE; com.live.evo.util.GlideImageLoader.load(context, icon, android.R.color.transparent, h.icon) }
        h.itemView.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) { h.name.setBackgroundResource(android.R.color.transparent); h.name.setTextColor(CommonUtils.color(android.R.color.black)) }
        }
    }
}

/**
 * Adapter de datas (`subject_matchdate_item`): rótulo "mês dia" (ou "hoje"); datas sem partidas ficam cinza
 * (`subject_date_unenble`); selecionada com foco 20 sp sobre `color_focused`.
 * Original: com/live/evo/fragment/subjuect/e.java
 */
class MatchDateAdapter(private val context: android.content.Context, dates: List<String>?, datesWithData: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val dates = ArrayList<String>().also { if (!dates.isNullOrEmpty()) it.addAll(dates) }          // f6712c
    private val datesWithData = ArrayList<String>().also { it.addAll(datesWithData) }                       // f6713d
    private var selected = 0
    private var focused = false

    class DateHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text: android.widget.TextView = view.findViewById(com.live.evo.R.id.subject_date_tv)
        val layout: android.widget.LinearLayout = view.findViewById(com.live.evo.R.id.subject_date_layout)
    }

    /** Troca datas/datas com dados e a posição selecionada. Original: b(RecyclerView, List, int, List) */
    fun setData(list: RecyclerView, newDates: List<String>?, position: Int, withData: List<String>) {
        dates.clear(); datesWithData.clear(); datesWithData.addAll(withData)
        if (!newDates.isNullOrEmpty()) dates.addAll(newDates)
        if (position < itemCount) selected = position
        list.post { notifyDataSetChanged(); list.post { if (position < itemCount) list.scrollToPosition(position) } }
    }

    /** Seleciona [position]; ignora fora do intervalo. Original: c(RecyclerView, int, boolean) */
    fun setSelected(list: RecyclerView, position: Int, hasFocus: Boolean) {
        if (position < 0 || position >= itemCount) return
        val old = selected
        selected = position
        focused = hasFocus
        list.scrollToPosition(position)
        list.post {
            val cur = selected
            if (cur < itemCount) { if (old != cur) notifyItemChanged(old); notifyItemChanged(cur) }
        }
    }

    override fun getItemCount() = dates.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        DateHolder(android.view.LayoutInflater.from(context).inflate(com.live.evo.R.layout.subject_matchdate_item, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val h = holder as DateHolder
        var label = DateUtils.monthAndDay(dates[position])
        if (dates[position] == DateUtils.todayString()) label = CommonUtils.string(com.live.evo.R.string.today)
        h.text.text = label
        if (focused && selected == position) {
            h.text.setTextSize(android.util.TypedValue.COMPLEX_UNIT_SP, 20.0f)
            h.layout.setBackgroundResource(com.live.evo.R.color.color_focused)
        } else {
            h.text.setTextSize(android.util.TypedValue.COMPLEX_UNIT_SP, 16.0f)
            h.layout.background = null
        }
        if (datesWithData.isEmpty() || !datesWithData.contains(dates[position])) {
            h.text.setTextColor(CommonUtils.color(com.live.evo.R.color.subject_date_unenble))
            h.text.setBackgroundResource(android.R.color.transparent)
            return
        }
        if (selected == position && focused) {
            h.text.setTextColor(CommonUtils.color(com.live.evo.R.color.subject_datetext_list_select))
            h.text.setBackgroundResource(android.R.color.transparent)
        } else if (selected == position) {
            h.text.setTextColor(CommonUtils.color(com.live.evo.R.color.color_focused))
            h.text.setBackgroundResource(com.live.evo.R.drawable.subject_date_bg_focus)
        } else {
            h.text.setTextColor(CommonUtils.color(com.live.evo.R.color.subject_datetext_list))
            h.text.setBackgroundResource(android.R.color.transparent)
        }
    }
}
