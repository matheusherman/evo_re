package com.live.evo_mobile.ui

import android.content.Intent
import com.live.evo.R
import com.live.evo_mobile.ui.favorite.FavoriteListActivity
import com.live.evo_mobile.ui.login.LoginTypeActivity

/*
 * Fragments da MainViewActivity (mobile). Todos estendem as bases do módulo de UI compartilhada
 * (com.tvc.lib.mobile.ui.base → com.foxivid.ui.mobile.base.*: d = BaseDataBindFragment, a = LazyBase, e = ListBase) e usam DataBinding `z4.*`.
 */

/**
 * "TV" do mobile: player (PlayerView) + lista de canais/histórico/favoritos sobrepostos; gestos
 * (GestureDetector: volume/brilho via AudioManager; duplo toque), `rb_channel`/`rb_favorite` (abas), `container`.
 * Reproduz com o mesmo pipeline do SDK (MediaRepository + TsProxyServer). Mensagens: `no_stream_notice_title_free_trial_out`,
 * `force_logout_remind`, `error_desc`, `is_playing`. Busca → [SearchLiveActivity] (jumpForResult).
 * Original: com/live/evo_mobile/ui/d1.java (nome real MainTVFragment.kt, 1526 linhas) — resumo.
 */
class MainTVFragment {
    /** `mCurrFragment`: aba/fragment atual (ChannelListFragment, SubscribeListFragment ou EpgListFragment). */
    var currentFragment: Any? = null
    /** `mChannelListFragment` (aba "canais"). */
    var channelListFragment: ChannelListFragment? = null
    /** `T().f22994g` (mainRl: cabeçalho da guia/EPG) e `T().f22993f` (RadioGroup `rb_channel`/`rb_favorite`) do binding. */
    var mainRl: android.view.View? = null
    var tabGroup: android.widget.RadioGroup? = null
    /** Id de `R.id.rb_channel`. */
    var rbChannelId: Int = 0

    /**
     * Mostra a aba de canais (se ainda não está nela) e seleciona/reproduz o canal [streamId] na lista.
     * Original: Q0(String streamId)
     *  - fora da aba de canais: se `mainRl` visível, esconde-o, mostra o RadioGroup e chama `q1(0)`; senão marca `rb_channel`;
     *  - com streamId: delega a [ChannelListFragment.selectStream] (n.z0).
     */
    fun playChannel(streamId: String?) {
        if (currentFragment !is ChannelListFragment) {
            if (mainRl?.visibility == android.view.View.VISIBLE) {
                mainRl?.visibility = android.view.View.GONE
                tabGroup?.visibility = android.view.View.VISIBLE
                showTab(0)
            } else {
                tabGroup?.check(rbChannelId)
            }
        }
        if (streamId != null) channelListFragment!!.selectStream(streamId)
    }

    /**
     * Troca de aba (índice 0 = canais, 1 = lembretes, 2 = EPG). Original: q1(int) + w1(from, to, tag).
     * NÃO RECUPERÁVEL: a transação de fragment e os títulos em negrito dependem do binding `z4.*` (layout `fragment_main_tv`)
     * e dos fragments mobile, não reconstruídos; aqui só se registra a aba atual (e, para a EPG, a visibilidade de `mainRl`).
     */
    fun showTab(index: Int) {
        when (index) {
            0 -> currentFragment = channelListFragment
            2 -> { mainRl?.visibility = android.view.View.VISIBLE; tabGroup?.visibility = android.view.View.INVISIBLE }
        }
    }
}

/**
 * Lista de canais por categoria (`ChannelTitleData` à esquerda + `StoryListData`/canais à direita), carregada via
 * `channelListLoader` e atualizada por Handler. Original: com/live/evo_mobile/ui/n.java (base LazyBase `z4.y`).
 */
class ChannelListFragment {
    /**
     * Seleciona na lista o canal [channelId] (rola até ele e dispara a reprodução). Original: n.z0(String)
     * NÃO RECUPERÁVEL: depende do RecyclerView/adapters (`z4.y`, `t0()`/`s0()`) e do carregamento por categoria do fragment `n`,
     * não reconstruídos; comportamento original: procura o `StoryListData` com o streamId na lista atual, rola (r0) e envia a
     * mensagem 2 ao handler; se não achar, escolhe a categoria (adulta ou "todos") e recarrega a lista (coverStoryList).
     */
    fun selectStream(channelId: String) {}
}

/**
 * Guia de programação ("tv_guide_today"/"tv_guide_none"): seletor de data ([com.live.evo_mobile.adapter.DatePickAdapter]) +
 * lista de programas ([EpgListAdapter]: subscribe/unsubscribe/catch-up). Atualiza por EventBus (`onMessageEvent`).
 * Original: com/live/evo_mobile/ui/t.java (EpgListFragment.kt)
 */
class EpgListFragment

/** Lista de lembretes (agendamentos): remove/ativa; guarda `lastRemindItemList`. Original: com/live/evo_mobile/ui/n2.java (SubscribeListFragment.kt) */
class SubscribeListFragment

/**
 * Perfil/"Minha conta": entradas de menu — settings (`profile_menu_settings`), adulto (`menu_adult` switch),
 * atendimento (`customer_service`), compartilhar ([ShareActivity]), conta (sem conta → [LoginTypeActivity] com `loginFrom = 2`,
 * com conta → [AccountManageActivity]), renovação (sem conta → login `loginFrom = 2`, senão [MainViewActivity.openRenew]),
 * favoritos ([FavoriteListActivity]) e histórico ([HistoryListActivity]) — ambos por `jumpForResult`.
 * Original: com/live/evo_mobile/ui/k0.java
 */
class ProfileFragment {
    fun onMenuClick(entry: ProfileEntry, hasAccount: Boolean, activity: android.app.Activity) {
        when (entry) {
            ProfileEntry.SHARE -> activity.startActivity(Intent(activity, ShareActivity::class.java))
            ProfileEntry.ACCOUNT ->
                if (!hasAccount) activity.startActivity(Intent(activity, LoginTypeActivity::class.java).putExtra("loginFrom", 2))
                else activity.startActivity(Intent(activity, AccountManageActivity::class.java))
            ProfileEntry.RENEW ->
                if (!hasAccount) activity.startActivity(Intent(activity, LoginTypeActivity::class.java).putExtra("loginFrom", 2))
                else (activity as MainViewActivity).openRenew()
            ProfileEntry.FAVORITES -> activity.startActivity(Intent(activity, FavoriteListActivity::class.java))
            ProfileEntry.HISTORY -> activity.startActivity(Intent(activity, HistoryListActivity::class.java))
        }
    }
    enum class ProfileEntry { SHARE, ACCOUNT, RENEW, FAVORITES, HISTORY }
}

/** Histórico de canais (modo seleção para apagar; `select_history_toast`). Original: com/live/evo_mobile/ui/d0.java (HistoryLiveFragment.kt) */
class HistoryLiveFragment
