package com.live.evo.fragment.channel

import android.os.Handler
import android.view.View
import com.live.evo.fragment.ChannelFragment
import com.live.evo.osd.EpgListAdapter
import com.live.evo.osd.ProgramClassifyAdapter
import com.live.evo.osd.presenter.OSDListProgramPresenterContract
import androidx.fragment.app.FragmentActivity

/**
 * Contexto compartilhado pelos controladores do painel de canais: fragment, views, estado, adapters, animações
 * e o foco "lembrado". No original tudo isso são campos do próprio `fragment/x`; aqui ficam num objeto único para
 * que [ChannelKeyHandler], [ChannelCategoryController], [ChannelEpgPanel], [ChannelAdultLock] e
 * [ChannelBannerController] não precisem de um ponteiro gigante para o fragment.
 *
 * Original: com/live/evo/fragment/x.java (campos de instância)
 */
class ChannelMenuContext(
    val fragment: ChannelFragment,
    val views: ChannelViews,
    val state: ChannelMenuState,
) {
    /** Adapters das 4 listas. Original: `mCategoryAdapter` (osd.m), `mProgramAdapter` (n5.o), `mEpgAdapter` (osd.b), `epgDateAdapter` (n5.b). */
    var categoryAdapter: ProgramClassifyAdapter? = null
    var programAdapter: ChannelListAdapter? = null
    var epgAdapter: EpgListAdapter? = null
    var epgDateAdapter: EpgDateAdapter? = null

    /** Animações das colunas. Original: `categoryAnim*`, `epgAnim*`. */
    lateinit var animator: ChannelPanelAnimator

    /** Handler da thread principal com as mensagens 1 / 8194 / 8195 ([ChannelHandler]). Original: `mHandler`. */
    lateinit var handler: Handler

    /** Runnable que alterna o texto da dica de PIP a cada 10 s ([ChannelHandler.PipTipRunnable]). Original: `mPipTipRunnable` (x$j). */
    lateinit var pipTipRunnable: Runnable

    /** View que deve receber o foco quando o menu volta a aparecer (`M2(View)`/`D2()`/`t()`). Original: `focusView`. */
    var focusView: View? = null

    /** Retorna o presenter OSD compartilhado. Original: `Q2` (estático). */
    val presenter: OSDListProgramPresenterContract? get() = ChannelMenuData.presenter

    val activity: FragmentActivity? get() = fragment.activity
    val context get() = fragment.context

    // controladores (ligados em ChannelFragment.bindViews/initData)
    lateinit var categories: ChannelCategoryController
    lateinit var epg: ChannelEpgPanel
    lateinit var adult: ChannelAdultLock
    lateinit var banners: ChannelBannerController
    lateinit var keys: ChannelKeyHandler

    /** Original: `M2(View)` — só guarda o último foco. */
    fun rememberFocus(view: View?) { focusView = view }
}
