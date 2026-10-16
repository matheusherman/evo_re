package com.live.evo.fragment.channel

import android.view.Window
import com.live.evo.fragment.ChannelFragment
import com.live.evo.fragment.OnTabEventListener
import com.live.evo.model.CategoryBean
import com.live.evo.model.ChannelData
import com.live.evo.model.ProgramBean
import com.live.evo.osd.presenter.OSDListProgramPresenterContract
import java.lang.ref.SoftReference

/**
 * Dados "estáticos" do painel de canais — no original são campos `static` de `fragment/x`
 * (`M2`, `N2`, `O2`, `P2`, `Q2`, `R2`, `S2`, `T2`) acessados pelo `Companion` (`x.INSTANCE.a()/b()/c()/d()`).
 * Sobrevivem à recriação do fragment (o fragment fica numa [SoftReference]).
 *
 * Original: com/live/evo/fragment/x.java (campos estáticos e `x$Companion`)
 */
object ChannelMenuData {
    /** Nomes das categorias visíveis no momento (já sem as de grupo privado bloqueadas). Original: `M2`. */
    @JvmField var visibleCategories: MutableList<String> = ArrayList()

    /** Todos os nomes de categoria vindos do SDK (`t.v.c.i.a.u(true)`). Original: `N2`. */
    @JvmField var allCategories: List<String> = ArrayList()

    /** Canais por categoria (`s0.C()`). Original: `O2`. */
    @JvmField var channelsByCategory: HashMap<String, List<ChannelData>>? = null

    /** Metadados por categoria (`s0.t()`). Original: `P2`. */
    @JvmField var categoryInfo: Map<String, CategoryBean>? = null

    /** Presenter do menu OSD (`com.live.evo.osd.persenter.a`). Original: `Q2`. */
    @JvmField var presenter: OSDListProgramPresenterContract? = null

    /** Listener de eventos do menu pai (`y1`). Original: `R2`. */
    @JvmField var eventListener: OnTabEventListener? = null

    /** Referência fraca à instância única do fragment. Original: `S2`. */
    @JvmField var instanceRef: SoftReference<ChannelFragment>? = null

    /** Janela usada para ancorar o teclado virtual. Original: `T2`. */
    @JvmField var window: Window? = null
}

/**
 * Estado mutável da instância do painel de canais (campos não estáticos de `fragment/x`).
 * Agrupado aqui para que os controladores ([ChannelKeyHandler], [ChannelPanelAnimator], [ChannelEpgPanel],
 * [ChannelAdultLock], [ChannelBannerController]) compartilhem os mesmos valores.
 *
 * Original: com/live/evo/fragment/x.java (campos de instância)
 */
class ChannelMenuState {
    /** Posição do canal selecionado na lista de canais. Original: `mProgramSelect`. */
    var programSelect = 0
    /** Posição da categoria selecionada. Original: `mCategorySelect`. */
    var categorySelect = 0
    /** Índice (na lista da categoria) do programa de EPG que está no ar agora. Original: `mNowPlayingIndex` (-1 = nenhum). */
    var nowPlayingIndex = -1

    /** Canais da categoria atual (a lista exibida). Original: `mListVodVideo`. */
    var channelsInCategory: List<ChannelData>? = null

    /** Por categoria: "posição,offsetY" do último item selecionado. Original: `mHistoryMap`. */
    var scrollHistory: MutableMap<String, String>? = null

    /** EPG completa do canal atual / do dia exibido. Original: `curChannelEpgList` / `tempEpgList`. */
    var curChannelEpgList: MutableList<ProgramBean> = ArrayList()
    var tempEpgList: MutableList<ProgramBean> = ArrayList()

    /** Id do canal cuja EPG está na tela. Original: `curChannelId`. */
    var curChannelId: String = ""

    /** Categoria / canal / posição global do que está tocando (vem de `SavePlayHistoryEvent`). */
    var playCategory = 0     // playCategory
    var playChannel = 0      // playChannel
    var playAllPos = 0       // playAllPos

    /** Último "categoria,canal,posição" salvo (PlaybackPrefs.lastPosition). Original: `mPreviousPlayData`. */
    var previousPlayData: String? = null

    var isChangeChannel = false          // isChangeChannel
    var hasChangeCategory = false        // hasChangeCategory
    var isKeyCodeUp = false              // isKeyCodeUp  (CIMA na lista de EPG mudou de dia)
    var isKeyCodeDown = false            // isKeyCodeDown
    var epgShowFirst = false             // mEpgShowFirst
    var isCatchUp = false                // mIsCatchUp
    var showBanner = false               // mShowBanner
    var postMetricFromCategory = false   // postMetricisFromCategory (sem uso além de ser gravado)
    var isChannelHistoryLive = false     // isChannelHistoryLive
    var isChannelUpdateByKids = false    // isChannelUpdateByKids (nunca é setado no original)

    /** Coluna de categorias aberta (visível) / animação inicial / primeira seleção / dados de EPG iniciais. */
    var isCategoryOpen = true            // mIsCategoryOpen
    var isFirst = true                   // isFist (ignora o 1º onItemSelected da categoria)
    var isInitOpen = true                // isInitOpen
    var isInitEpgData = true             // isInitEpgData (ignora o 1º onItemSelected da data)
    var focusable = true                 // mFocusable
    var isOnKeyLeft = true               // mIsOnKeyLeft

    /** Largura da coluna de categorias (dimen `classify_width_2`). Original: `mCategoryWidth`. */
    var categoryWidth = 0

    /** Contadores de métrica de navegação (zerados em `a2()`). Original: `browseCount/clickCount/browseDuration`. */
    var browseCount = 0
    var clickCount = 0
    var browseDuration = 0L

    /** Textos das dicas de PIP (`pip_menu_tipwatch/tipopen/tipclose`). Original: `mTipSwitch/mTipOpenPip/mTipClosePip`. */
    var tipSwitch: String? = null
    var tipOpenPip: String? = null
    var tipClosePip: String? = null

    /** Tamanho mínimo do PIN adulto (4 dígitos). Original: `LENGTH`. */
    val pinLength = 4
}
