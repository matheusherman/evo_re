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
    fun onSubjectUpdateEvent(event: Any) { TODO("c0.onSubjectUpdateEvent(b5.j)") }
}

/** Variante da aba de subject (usa o argumento `position`). Original: com/live/evo/fragment/subjuect/y.java */
class SubjectFragment : BaseMenuFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(com.live.evo.R.layout.menu_fragment_subject, container, false)
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
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean = TODO("w.onKey")
    /** Busca/atualiza as partidas. Original: h1(boolean) */
    @Synchronized fun refresh(start: Boolean) { TODO("w.h1") }
}

/** Adapter de partidas (`subject_match_item`; `playback`/`cancel`, ícone "no_icon"). Original: com/live/evo/fragment/subjuect/c.java */
class MatchAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = TODO("subject_match_item")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) { TODO() }
    override fun getItemCount() = 0
}
/** Adapter de classificação/ligas (`subject_matchclassification_item`). Original: com/live/evo/fragment/subjuect/d.java */
class MatchClassificationAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = TODO("subject_matchclassification_item")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) { TODO() }
    override fun getItemCount() = 0
}
/** Adapter de datas (`subject_matchdate_item`). Original: com/live/evo/fragment/subjuect/e.java */
class MatchDateAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = TODO("subject_matchdate_item")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) { TODO() }
    override fun getItemCount() = 0
}
