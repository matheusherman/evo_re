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
    /** Original: Q0(String channelId) */
    fun playChannel(channelId: String) { TODO("d1.Q0: seleciona canal e inicia reprodução") }
}

/**
 * Lista de canais por categoria (`ChannelTitleData` à esquerda + `StoryListData`/canais à direita), carregada via
 * `channelListLoader` e atualizada por Handler. Original: com/live/evo_mobile/ui/n.java (base LazyBase `z4.y`).
 */
class ChannelListFragment

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
