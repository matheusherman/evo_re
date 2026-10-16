package com.live.evo.activity

import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Build
import android.text.Html
import android.util.Log
import android.view.ViewStub
import com.live.evo.model.CategoryBean
import com.live.evo.util.AppPropertiesStore
import com.live.evo.util.ModelHelper
import com.live.evo.util.PlaybackPrefs
import com.live.evo.util.RxUtils
import com.live.evo.util.SkinConfig
import tv.danmaku.ijk.media.player.IMediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.os.SystemClock
import android.view.KeyEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.foxivid.baselib.config.InteractionUtils
import com.foxivid.baselib.model.meta.ChannelStreamResponse
import com.foxivid.baselib.model.meta.EPGProgramme
import com.foxivid.baselib.player.PlayerView
import com.foxivid.baselib.util.ToastHelper
import com.foxivid.baselib.util.UserActionTracker
import com.live.evo.AppUserManager
import com.live.evo.LivePopupController
import com.live.evo.ProductFeatureManager
import com.live.evo.R
import com.live.evo.UiFunctionConfig
import com.live.evo.activity.base.BaseActivity
import com.live.evo.catchup.CatchUpClickListener
import com.live.evo.catchup.LiveCatchUpClickHandler
import com.live.evo.dialog.ConfirmDialog
import com.live.evo.dialog.NoticeAlertDialog
import com.live.evo.dialog.SubscribePopup
import com.live.evo.event.ChangeChannelEvent
import com.live.evo.event.ForceLogoutEvent
import com.live.evo.event.ServiceExpiredEvent
import com.live.evo.event.SubscribeRemindEvent
import com.live.evo.fragment.FeedbackDialogFragment
import com.live.evo.fragment.NetworkStatusDialogFragment
import com.live.evo.fragment.TabFunctionRechargeFragment
import com.live.evo.fragment.login.RechargeDialogFragment
import com.live.evo.fragment.subject.SubjectDataHelper
import com.live.evo.model.ChannelBean
import com.live.evo.osd.LoadingLayer
import com.live.evo.osd.NetworkPromptLayer
import com.live.evo.osd.OptimizingLayer
import com.live.evo.osd.OsdControlListener
import com.live.evo.osd.OsdLayerManager
import com.live.evo.osd.ProgramNameLayer
import com.live.evo.osd.SubscribeManager
import com.live.evo.osd.presenter.OSDListProgramPresenter
import com.live.evo.util.CommonUtils
import com.live.evo.util.DateUtils
import com.live.evo.util.EpgRepository
import com.live.evo.util.TextStyleUtils
import com.live.evo.util.FontUtils
import com.live.evo.util.LoginConfig
import com.live.evo.util.NetworkUtils
import com.live.evo.util.RxTrigger
import com.live.evo.util.ServerClock
import com.live.evo.util.ToastUtils
import com.live.evo.widget.SpeedTextView
import com.live.evo.widget.sloading.SLoadingView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.slf4j.LoggerFactory
import java.util.Timer
import java.util.TimerTask
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Tela principal de TV ao vivo (STB): player em tela cheia + OSD + menus/EPG sobrepostos.
 * Aberta por [LiveLoadActivity] quando os canais estão carregados.
 *
 * Original: com/live/evo/activity/LiveNewActivity.java (5,5 mil linhas; arquivo Kotlin LiveNewActivity.kt)
 *
 * Esta reconstrução cobre: inicialização de views/listeners do player, troca de canal (D-pad, PAGE_UP/DOWN,
 * números, deep-link/evento), reprodução (`startPlay`), OSD, estados de logout/expiração (`toLogoutProcess`,
 * `onServiceExpired`, `accountLogout`), upgrade e ciclo de vida. Métodos de baixo nível que só ajustam
 * views/estatísticas foram resumidos (ver seção "Não detalhado" no fim do arquivo).
 *
 * Navegação a partir daqui:
 * - Menu (KEYCODE_MENU) → [LivePopupController.showMenu] (PopupMenuC lateral; dele saem EPG, favoritos, update, etc.).
 * - ENTER/OK → lista de canais (`OSDListProgramPresenter.M(fm, "Channel List")`), SEARCH → "Search".
 * - DPAD_LEFT → banner/canal atual (`W3` → LivePopupController.r), DPAD_RIGHT e demais → EpgDialog (`B4`).
 * - Catch-up → [CatchUpPlayerActivity] (startActivityForResult requestCode 3; resultCode-1 = índice de canal).
 * - Logout forçado (evento) → [LiveLoadActivity] e finish().
 * - Sessão expirada / login → [RechargeDialogFragment] (tipo 22 = login, 54 = recarga).
 */
class LiveNewActivity : BaseActivity(), View.OnKeyListener {

    private val logger = LoggerFactory.getLogger(LiveNewActivity::class.java)

    // --- OSD ---
    private var mOsdManager: OsdLayerManager? = null
    private var mOsdNetwork: NetworkPromptLayer? = null
    private var mOsdProgramNum: ProgramNameLayer? = null
    private var mOsdProgramPromptOptimizing: OptimizingLayer? = null
    private var mOsdProgramPromptSignalPoor: LoadingLayer? = null
    private var mOsdProgramPromptLoading: LoadingLayer? = null
    private var mOsdProgramPromptRetrying: LoadingLayer? = null
    private var mOSDListProgramPresenter: OSDListProgramPresenter? = null
    private var mUiManager: LivePopupController? = null

    // --- views ---
    private var mContainer: RelativeLayout? = null
    var mVideoView: PlayerView? = null
        private set
    private var player_stat_container: View? = null
    private var mPlayerStatInfoView: TextView? = null
    private var mPrtStatInfoView: TextView? = null
    private var mLoadingView: SLoadingView? = null
    private var mNoticeView: SpeedTextView? = null
    private var mNoSignal: View? = null
    private var mNoSignalIv: ImageView? = null
    private var mMosaicView: FrameLayout? = null

    // --- estado de reprodução / navegação ---
    private var playGroupIdx = 0          // índice da categoria
    private var playInGroupIdx = 0        // índice dentro da categoria
    private var playInAllIdx = 0          // índice na lista global
    private var mListLiveDataAll: List<ChannelBean>? = null
    private var mCategoryIdList: List<String>? = null
    private var mMapCategoryPrograms: HashMap<String, List<ChannelBean>>? = null
    private var isPlayFavoriteList = false
    private var isRemoveFavorite = false
    private var isInputProgramNum = false
    private var canClickUpDown = true
    private var lookBackInfo: String? = null   // "grupo,posGrupo,posGlobal" do canal anterior (tecla voltar/DEL)
    private var lastPlayedLiveChannel: ChannelBean? = null
    private var lastStartLiveChannel: ChannelBean? = null
    private var lastPlayTime = 0L
    private var mVideoPath: String? = null
    private var mIsAdult = false
    private var isChangeChannel = true
    private var mLiveErrorCount = 0
    private var mLiveLastError = ""

    // --- buffering / estatística ---
    private var mBufferingStartTime = 0L
    private var mBufferingStartChannel = -1
    private var mBufferingTimes = 0
    private var mBufferingDuration = 0L
    private var mTrafficOldBytes = 0L; private var mTrafficBytes = 0L
    private var mTrafficOldBytesRx = 0L; private var mTrafficBytesRx = 0L
    private var mTrafficOldBytesTx = 0L; private var mTrafficBytesTx = 0L
    private val mTimer = Timer()
    private var trafficTask: TimerTask? = null

    // --- logout / expiração / upgrade ---
    private var isInLogout = false
    var isPopupLoginOrRenewFragment = false
    private val isLogoutDlgShow = AtomicBoolean(false)
    private var mExpiredStatus = -1
    private var isFirstStart = true
    private var mBackpressedAgain = false
    private var upgradeEvent: com.live.evo.event.UpgradeReadyEvent? = null
    private var lastUpgradeEventTime = 0L
    private var mIsAppUpdateDialogShowing = false
    private val isInChecking = AtomicBoolean(false)
    private var apkFile = ""
    private var lastVersion = ""
    private var resumeFrom: Int? = null

    private var noticeAlertDialog: NoticeAlertDialog? = null
    private var subscribeDialog: SubscribePopup? = null
    private var feedbackDialogFragment: FeedbackDialogFragment? = null
    var networkTester: NetworkStatusDialogFragment.NetworkTester? = null
        private set
    private var livePlayHandler: ChannelSwitchHelper? = null

    /** Repetição de troca de canal: 100 ms (setas) e 2000 ms (números). Original: mKeyUpDownRepeatHandler / mInputCodeRepeatHandler */
    private val mKeyUpDownRepeatHandler = RxTrigger(100)
    private val mInputCodeRepeatHandler = RxTrigger(2000)

    /** Listener de clique de catch-up (x4.d). Original: catchUpClickListener */
    val catchUpClickListener: CatchUpClickListener = LiveCatchUpClickHandler(this)

    /** Original: LiveNewActivity$l */
    val mHandler: Handler = object : Handler(Looper.getMainLooper()) {
        private var isNetworkConnected = true

        private fun onNetworkTest(ok: Boolean) {
            if (ok) {
                isNetworkConnected = true
                val cur = currentChannel()
                if ((cur == null || !cur.isLocked()) && mVideoView?.isPlaying() == false) startPlay(currentChannel())
                refreshNetworkState()
                checkExpiredByClock()
            } else if (!isNetworkAvailable()) {
                mOsdManager?.show(mOsdNetwork)
            }
        }

        override fun handleMessage(msg: Message) {
            when (msg.what) {
                MSG_NETWORK_LOST -> {
                    isNetworkConnected = false
                    refreshNetworkState()
                    if (mVideoView?.isPlaying() != true) {
                        isNetworkConnected = isNetworkAvailable(); refreshNetworkState()
                    } else {
                        sendEmptyMessageDelayed(MSG_NETWORK_RECHECK, 2000L)
                    }
                    NetworkStatusDialogFragment.show(this@LiveNewActivity, networkTester) { onNetworkTest(it) }
                }
                MSG_NETWORK_OK -> {
                    isNetworkConnected = true
                    refreshNetworkState()
                    if (!UserActionTracker.isIdle()) { onLoadDataSuccess(); startEcoTimer() }
                }
                MSG_CHECK_UPGRADE -> checkUpgrade()
                MSG_NETWORK_RECHECK -> {
                    refreshNetworkState()
                    if (!UserActionTracker.isIdle() && !isNetworkConnected) {
                        if (mVideoView?.isPlaying() == true) { sendEmptyMessageDelayed(MSG_NETWORK_RECHECK, 2000L); return }
                        isNetworkConnected = isNetworkAvailable(); refreshNetworkState()
                        if (!isNetworkConnected) NetworkStatusDialogFragment.show(this@LiveNewActivity, networkTester) { onNetworkTest(it) }
                    }
                }
                MSG_RESET_BACK -> mBackpressedAgain = false
                MSG_UNLOCK_CHANNEL -> channelAt(msg.arg1)?.let { if (!it.isAdult()) it.isLocked() }
                MSG_SHOW_CURRENT -> showChannelBanner(currentChannel())
            }
        }
    }

    /**
     * Inferência: corpo `native` (Jiagu). Pelo restante da classe deve: setContentView (layout da tela live),
     * [initViews] (T2), criar OSD (OsdLayerManager + camadas i/j/k/l), [OSDListProgramPresenter], ChannelSwitchHelper (n2),
     * testador de rede, registrar o BroadcastReceiver `mMsgReceiver` (ações `com.bb.action.*`, p.ex. EXIT com
     * extra `withProcess`), carregar listas de canais (P2) e tratar channelId do intent (u2).
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // INFERIDO (onCreate nativo): ordem deduzida dos helpers que sobreviveram no dex (T2/J2/N2) e do layout `activity_live_new`.
        setContentView(R.layout.activity_live_new)
        initViews()                 // T2(): findViewById + listeners do player + LivePopupController + SubscribeManager
        initServices()              // J2(): listas (S2), status de expiração (M2), testador de rede, OSD (Q2), eco/recarga, ChannelSwitchHelper
        consumeIntentChannel(intent)    // N2(intent): u2() lê o channelId (extra ou deep-link `livetvcontent`) e remove o extra
        // O registro no EventBus e a primeira carga de canais (q3 -> onLoadDataSuccess) acontecem via BaseActivity/onStart/onResume
        // (MSG_NETWORK_OK em onStart agenda onLoadDataSuccess + eco).
    }

    /** Lê e descarta o extra `channelId` da intent. Original: N2(Intent) */
    private fun consumeIntentChannel(intent: Intent?) {
        extractChannelId(intent)
        intent?.removeExtra("channelId")
    }

    /** channelId do deep-link `livetvcontent://...?channelId=` ou do extra `channelId`. Original: u2(Intent) */
    private fun extractChannelId(intent: Intent?): String? {
        if (intent == null) return null
        val data = intent.data
        return if (intent.scheme != null && "livetvcontent" == intent.scheme && data != null) data.getQueryParameter("channelId")
        else intent.getStringExtra("channelId")
    }

    /** Liga views e listeners do player. Original: T2() */
    private fun initViews() {
        mContainer = findViewById(R.id.livenewa_rl_parent)
        mVideoView = findViewById(R.id.livenewa_ijk_main_videoview)
        player_stat_container = findViewById(R.id.livenewa_ll_player_stat_container)
        mPlayerStatInfoView = findViewById(R.id.livenewa_tv_player_stat_info)
        mPrtStatInfoView = findViewById(R.id.livenewa_tv_prt_stat_info)
        mLoadingView = findViewById(R.id.livenewa_slv)
        mNoticeView = findViewById(R.id.livenewa_tv_notice)
        mNoSignal = findViewById(R.id.livenewa_rl_rly_no_signal_parent)
        mNoSignalIv = findViewById(R.id.livenewa_iv_no_signal)
        mVideoView?.apply {
            setOnPreparedListener(mVideoPrepareListener)
            setOnErrorListener(mVideoOnErrorListener)
            setOnInfoListener(mVideoOnInfoListener)
            setOnCompletionListener(mVideoOnCompletionListener)
            setOnKeyListener(this@LiveNewActivity)
            setLoadingListener { loading, text -> onPlayerLoading(loading, text) }
            setNoSignalListener { code, desc -> onNoSignal(code, desc) }
            setPlayCompleteListener { onPlayComplete() }
        }
        mUiManager = LivePopupController.create(this, mHandler, LiveCatchUpClickHandler(this))
        SubscribeManager.init(this, mHandler, mSubscribeListener)
        TextStyleUtils.b(mNoticeView)
        TextStyleUtils.c(mPlayerStatInfoView)
        mMosaicView = findViewById(R.id.livenewa_mosaic_view)
    }

    // ---------------------------------------------------------------- teclas

    /** Todas as teclas passam primeiro por [onKey] do player. Original: dispatchKeyEvent() */
    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        if (mVideoView != null && onKey(mVideoView!!, event.keyCode, event)) return true
        UserActionTracker.onKey(event)
        return super.dispatchKeyEvent(event)
    }

    /**
     * Mapa de teclas do controle remoto. Original: onKey(View, int, KeyEvent)
     * - 82 MENU: abre menu (bloqueado para canal travado / adulto se configurado).
     * - 284 (tecla "favorito" de STB): alterna favorito do canal atual (SDK `L0(id)`), toast add/cancel.
     * - 21 LEFT: banner/canal atual; 22 RIGHT (e outras não mapeadas): EpgDialog.
     * - 93 PAGE_DOWN / 92 PAGE_UP: próximo/anterior na categoria (ou navega na lista se aberta).
     * - 84 SEARCH: busca; 7..16 dígitos: entrada de número de canal (até 3 dígitos); 67 DEL: apaga/volta ao anterior.
     * - 66 ENTER: lista de canais (ou toast "Loading" durante logout).
     */
    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        UserActionTracker.onKey(event)
        if (event.action != KeyEvent.ACTION_DOWN || v !== mVideoView) return false
        resetIdleTimer()   // K3()
        when (keyCode) {
            KeyEvent.KEYCODE_ENTER -> return onEnterKey()
            KeyEvent.KEYCODE_MENU -> {
                val cur = currentChannel()
                if (cur != null && cur.isLocked()) return true
                if (UiFunctionConfig.get().blockMenuOnAdult() && cur != null && cur.isAdult()) return true
                mUiManager?.prepareMenu(currentChannel())
                mUiManager?.showMenu()
                return true
            }
            KEYCODE_STB_FAVORITE -> {
                val ch = channelAt(playInAllIdx)
                val fav = ch?.favorite ?: 0
                if ((ch == null || !ch.isAdult()) && UiFunctionConfig.get().favoriteEnabled()) {
                    val newFav = if (fav == 0) 1 else 0
                    if (playGroupIdx == UiFunctionConfig.get().favoriteGroupIndex() && newFav == 0) isRemoveFavorite = true
                    if ((mCategoryIdList?.size ?: 0) > 1 && mMapCategoryPrograms != null) {
                        ch?.favorite = newFav
                        updateFavoriteLists(newFav, ch)
                        ch?.channelId?.let {
                            try { InteractionUtils.toggleFavorite(it.toInt()) } catch (t: Throwable) { logger.error("add favorites failure", t) }
                        }
                        ToastUtils.show(this, CommonUtils.string(if (newFav > 0) R.string.add_to_favorite else R.string.cancel_to_favorite), 1)
                        return true
                    }
                }
            }
            KeyEvent.KEYCODE_PAGE_DOWN -> {
                if (!canClickUpDown) return true
                val p = mOSDListProgramPresenter
                if (p != null && p.isShowing()) { p.next(); p.hide(); return true }
                if (!isRemoveFavorite) playInGroupIdx++
                isRemoveFavorite = false
                changeChannelInGroup(true)
                return true
            }
            KeyEvent.KEYCODE_PAGE_UP -> {
                if (!canClickUpDown) return true
                val p = mOSDListProgramPresenter
                if (p != null && p.isShowing()) { p.previous(); p.hide(); return true }
                isRemoveFavorite = false
                playInGroupIdx--
                changeChannelInGroup(false)
                return true
            }
            KeyEvent.KEYCODE_SEARCH -> if (UiFunctionConfig.get().searchEnabled()) mOSDListProgramPresenter?.show(supportFragmentManager, "Search")
            KeyEvent.KEYCODE_DPAD_LEFT -> { if (ProductFeatureManager.get().epgEnabled()) showChannelBanner(currentChannel()); return true }
            KeyEvent.KEYCODE_DPAD_RIGHT -> {
                if (!AppUserManager.get().needAdultWarning() && ProductFeatureManager.get().epgEnabled()) showEpgDialog()
                return true
            }
            // Nota: o fluxo de controle decompilado aqui é ambíguo (jadx reestruturou os ifs aninhados);
            // interpretação adotada: demais teclas (exceto dígitos/DEL) abrem o EpgDialog se a feature EPG estiver ativa.
            else -> if (keyCode !in KeyEvent.KEYCODE_0..KeyEvent.KEYCODE_9 &&
                keyCode != KeyEvent.KEYCODE_DEL && ProductFeatureManager.get().epgEnabled() && !LoginConfig.get().flagC()) {
                showEpgDialog(); return true
            }
        }
        if (keyCode in KeyEvent.KEYCODE_0..KeyEvent.KEYCODE_9) {
            val digit = keyCode - KeyEvent.KEYCODE_0
            mOsdProgramNum?.setVisibility(View.VISIBLE)
            val code = if (isInputProgramNum) {
                val typed = mOsdProgramNum?.typedNumber() ?: ""
                if (typed.length >= 3 || typed == "0") "$digit" else typed + digit
            } else { isInputProgramNum = true; "$digit" }
            onInputChannelNumber(code)
            return true
        }
        if (keyCode == KeyEvent.KEYCODE_DEL) {
            if (isInputProgramNum) {
                val typed = mOsdProgramNum?.typedNumber() ?: ""
                if (typed.length > 1) onInputChannelNumber(typed.substring(0, typed.length - 1))
                return true
            }
            return goBackToPreviousChannel()
        }
        return false
    }

    /** ENTER: lista de canais posicionada no canal atual. Original: trecho final de onKey() */
    private fun onEnterKey(): Boolean {
        if (isInLogout) { ToastHelper.showShort(getString(R.string.loading)); return true }
        val p = mOSDListProgramPresenter ?: return true
        p.hide()
        currentChannel()?.let { p.selectInGroup(it.index) }
        p.show(supportFragmentManager, "Channel List")
        return true
    }

    /** DEL sem número digitado: volta ao canal de [lookBackInfo]. Original: trecho de onKey() */
    private fun goBackToPreviousChannel(): Boolean {
        val info = lookBackInfo ?: return false
        if (!info.contains(",")) return false
        val parts = info.split(",").dropLastWhile { it.isEmpty() }
        if (parts.size <= 2) return true
        val g = parts[0].toInt(); val ig = parts[1].toInt(); val all = parts[2].toInt()
        if (g == playGroupIdx && ig == playInGroupIdx && all == playInAllIdx) return false
        if (all >= (mListLiveDataAll?.size ?: 0) || all < 0) return false
        var target = 0
        if (mListLiveDataAll?.get(all)?.isAdult() != true) {
            playGroupIdx = g; playInGroupIdx = ig; target = all
        } else if (playGroupIdx != 0 && playInGroupIdx != 0) {
            playGroupIdx = 0; playInGroupIdx = 0; return true
        }
        trackAction("keycode_del")
        changeChannel(target)
        return true
    }

    /**
     * Troca para o número digitado (1-based) — com "modo número lógico" (a5.b) usa o mapa de números.
     * Original: c2(String)
     */
    private fun onInputChannelNumber(newCode: String) {
        // replayTask?.cancel()
        setNoSignalVisibility(View.GONE)
        val idx = newCode.toInt() - 1
        mOsdProgramNum?.show(idx.toString(), channelNameAt(idx))
        trackAction(newCode)
        mInputCodeRepeatHandler.trigger()
        val logicalNumbers = com.live.evo.config.ChannelNumberMode.get().isEnabled()
        val list = mListLiveDataAll
        if (idx >= 0 && idx < (list?.size ?: 0) && !logicalNumbers) {
            val ch = list?.get(idx) ?: return
            if (!ch.isAdult()) showChannelBanner(ch)
            return
        }
        // Com numeração lógica o original consulta um mapa vazio (kotlin.collections.n0.i()) — resultado: sempre X3(null, idx).
        jumpToChannelNumber(null, idx)
    }

    /**
     * Próximo/anterior dentro da categoria atual (favoritos, "history" ignorado sem numeração lógica).
     * Ao esgotar a categoria, volta à categoria 0 e reposiciona. Original: d2(boolean)
     */
    private fun changeChannelInGroup(down: Boolean) {
        if (mCategoryIdList.isNullOrEmpty()) mCategoryIdList = InteractionUtils.getCategoryIds(true)
        val cats = mCategoryIdList ?: return
        if (cats.isEmpty() || cats.size <= playGroupIdx) return
        val list: List<ChannelBean>?; val skipHistory: Boolean
        if (isPlayFavoriteList) { list = favoriteChannels(); skipHistory = false } else {
            val id = cats[playGroupIdx].lowercase()
            skipHistory = id.equals("history", true) && !com.live.evo.config.ChannelNumberMode.get().isEnabled()
            list = mMapCategoryPrograms?.get(cats[playGroupIdx])
        }
        if (list.isNullOrEmpty() || skipHistory) {
            isPlayFavoriteList = false
            if (playGroupIdx == 0) { playInGroupIdx = 0; return }
            playGroupIdx = 0
            val idx = mMapCategoryPrograms?.get(cats[0])?.indexOf(currentChannel()) ?: 0
            playInGroupIdx = if (down) idx + 1 else idx - 1
            changeChannelInGroup(down)
            return
        }
        if (playInGroupIdx < 0) playInGroupIdx = list.size - 1 else if (playInGroupIdx >= list.size) playInGroupIdx = 0
        val target = list[playInGroupIdx]
        val cur = currentChannel()
        if (cur == null || cur == target) return
        updateOsdIndex(target.index)
        showChannelBanner(target)
        trackAction("keydown:$down")
        mKeyUpDownRepeatHandler.trigger()
    }

    // ---------------------------------------------------------------- reprodução

    /**
     * Troca de canal por índice global. Bloqueia se expirado (status 2 e flag do AppUserManager).
     * Original: b2(int)
     */
    fun changeChannel(position: Int) {
        if (AppUserManager.get().blockWhenExpired() && mExpiredStatus == 2) { logger.error("changeChannel is Expired."); return }
        val list = mListLiveDataAll
        if (list != null && list.isEmpty()) { logger.error("ListLiveData is empty, please check server."); return }
        val ch = list?.get(position)
        playInAllIdx = position
        mOSDListProgramPresenter?.let {
            if (!isPlayFavoriteList) { it.selectGroup(playGroupIdx); it.selectInGroup(playInGroupIdx) }
            it.selectInAll(playInAllIdx)
        }
        isChangeChannel = true
        mBufferingTimes = 0; mBufferingDuration = 0L; mBufferingStartTime = 0L
        startPlay(ch)
        if ((ch == null || !ch.isProtected() || AppUserManager.get().isAdultUnlocked()) && !isPlayFavoriteList) {
            saveLastPosition(playGroupIdx, playInGroupIdx, playInAllIdx)
        }
        if (UiFunctionConfig.get().subscribeEnabled()) SubscribeManager.onChannelChanged(playInAllIdx)
    }

    /**
     * Prepara a reprodução: se logout forçado → [toLogoutProcess]; senão OSD de loading, verificação de
     * canal adulto/travado, notícia por canal e dispara `preparePlayAction`. Original: y3(ChannelBean)
     */
    fun startPlay(liveData: ChannelBean?) {
        if (InteractionUtils.isForcedLogout()) { toLogoutProcess(); return }
        hideNoSignal()       // f4()
        mOsdProgramPromptLoading?.showLoadView()
        if (!needsBanner()) return      // j2(): sem canais na categoria (mesmo após recarregar) nada é tocado
        try {
            if (window.decorView.windowToken != null) showChannelBanner(liveData)
            else mHandler.postDelayed({ try { if (window.decorView.windowToken != null) showChannelBanner(liveData) } catch (e: Exception) { logger.error(e.message, e) } }, 200L)
        } catch (e: Exception) { logger.error(e.message, e) }
        updateOsdIndex(playInAllIdx)
        mLiveErrorCount = 0
        mLiveLastError = ""
        val url = liveData?.streamUrl ?: ""
        if (liveData == null || !liveData.isAdult()) {
            if (liveData == null || playInAllIdx != liveData.index) InteractionUtils.resetAdultUnlock()   // I0()
        } else if (!InteractionUtils.isAdultUnlocked()) {
            showAdultLock(liveData)   // U3
            hideOsd(true)
            return
        }
        if (mOsdProgramPromptSignalPoor?.visibility() == View.VISIBLE) mOsdProgramPromptSignalPoor?.setVisibility(View.GONE)
        mVideoPath = url
        mIsAdult = liveData != null && liveData.isAdult()
        mMosaicView?.visibility = View.GONE
        mHandler.removeCallbacks(preparePlayAction)
        preparePlayAction.run()
        if (liveData?.type != 1) {
            mHandler.removeCallbacks(mOsdPromptRunnable)
            mOsdPromptRunnable.repeatCnt = 0
            mHandler.postDelayed(mOsdPromptRunnable, 2000L)
        }
        showNoticeFor(liveData?.channelId ?: "")
    }

    /**
     * Inicia o stream: obtém ChannelStreamResponse do SDK (`j(channelNumber)`) e coleta o fluxo do PlayerView.
     * Se o canal mudou enquanto iniciava, reinicia no canal atual. Original: i4() + corrotina startPlay$1 (z)
     */
    fun playStream(channelData: ChannelBean, headers: Map<String, String>, proxiedUrl: String) {
        if (isSameAsPlaying(channelData)) return
        val response: ChannelStreamResponse = InteractionUtils.getChannelStream(channelData.channelNumber.toInt())
            ?: run { ToastHelper.show(channelData.name + " " + getString(R.string.channel_not_found)); return }
        resetPlayerState()   // E2()
        CoroutineScope(Dispatchers.IO).launch {
            if (lastStartLiveChannel != channelData) { lastStartLiveChannel = channelData; lastPlayTime = DateUtils.now() }
            mVideoView?.play(response)
                ?.catch { t -> onPlayError(channelData, t) }
                ?.collect {
                    val cur = currentChannel() ?: return@collect
                    if (cur.channelId != channelData.channelId) {
                        logger.info("start_play_channel was changed[${channelData.id} -> ${cur.id}], start channel[${cur.id}]")
                        playStream(cur, emptyMap(), "")
                    }
                }
        }
    }

    /** Original: r3(ChannelBean, Throwable) */
    private fun onPlayError(channelData: ChannelBean, t: Throwable) {
        logger.error("Error in toPlay", t)
        ToastHelper.show(getString(R.string.play_unknown_err))
        if (isSameAsPlaying(channelData)) return
        retryPlay()   // s2()
    }

    /** Ação executada a cada troca: mostra o player e delega ao ChannelSwitchHelper. Original: C3() (preparePlayAction) */
    private val preparePlayAction = Runnable {
        if (InteractionUtils.isForcedLogout()) { toLogoutProcess(); return@Runnable }
        try {
            val cur = currentChannel()
            mVideoView?.let { if (it.visibility != View.VISIBLE) { it.visibility = View.VISIBLE; it.requestFocus() } }
            setNoSignalVisibility(View.GONE)
            lastPlayedLiveChannel = cur
            if (mOsdProgramPromptRetrying?.visibility() != View.VISIBLE) { mOsdManager?.show(mOsdProgramPromptLoading); mOsdProgramPromptLoading?.showLoadView() }
            cur?.let { livePlayHandler?.switchTo(it) }
            stopReplayTimer(false)
            if (mOsdProgramPromptRetrying?.visibility() != View.VISIBLE) { mOsdManager?.show(mOsdProgramPromptLoading); mOsdProgramPromptLoading?.showLoadView() }
        } catch (e: Exception) {
            ToastHelper.show(getString(R.string.play_unknown_err))
            logger.error("Error in preparePlay", e)
        }
    }

    /** Início de buffering (evento 701). Original: p3() */
    private fun onBufferingStart() {
        mBufferingStartTime = SystemClock.elapsedRealtime()
        mBufferingStartChannel = playInAllIdx
        val id = channelAt(playInAllIdx)?.channelId ?: ""
        mBufferingTimes++
        reportBuffering(id, 701, mBufferingTimes, mBufferingDuration)
    }

    /** Fim de buffering (evento 702), acumula duração se mesmo canal e < 24 h. Original: o3() */
    private fun onBufferingEnd() {
        if (mBufferingStartTime <= 0) return
        val elapsed = SystemClock.elapsedRealtime() - mBufferingStartTime
        mBufferingStartTime = 0L
        if (elapsed in 0..86_400_000 && mBufferingStartChannel != -1 && mBufferingStartChannel == playInAllIdx) mBufferingDuration += elapsed
        reportBuffering(channelAt(mBufferingStartChannel)?.channelId ?: "", 702, mBufferingTimes, mBufferingDuration)
    }

    /** Carga de canais concluída: toca o último canal e inicia monitor de tráfego. Original: q3() */
    private fun onLoadDataSuccess() {
        loadChannelLists()   // P2()
        if (shouldResumePlayback()) { trackAction("onLoadDataSuccess"); changeChannel(playInAllIdx) }
        mOSDListProgramPresenter?.let { val c = it.currentIndex(); it.setNumber((c + 1).toString()); it.selectInGroup(c) }
        try { startTrafficMonitor() } catch (e: Exception) { logger.error(e.toString(), e) }
    }

    /** Timer de 1 s que mede bytes rx/tx (CommonUtils.totalRxBytes/totalTxBytes). Original: M3() + LiveNewActivity$e */
    private fun startTrafficMonitor() {
        trafficTask?.cancel(); mTimer.purge()
        trafficTask = object : TimerTask() {
            override fun run() {
                if (mTrafficOldBytes == 0L) mTrafficOldBytes = CommonUtils.totalRxBytes()
                val rx = CommonUtils.totalRxBytes(); mTrafficBytes = rx - mTrafficOldBytes; mTrafficOldBytes = rx
                if (mTrafficOldBytesRx == 0L) mTrafficOldBytesRx = CommonUtils.totalRxBytes()
                val rx2 = CommonUtils.totalRxBytes(); mTrafficBytesRx = rx2 - mTrafficOldBytesRx; mTrafficOldBytesRx = rx2
                if (mTrafficOldBytesTx == 0L) mTrafficOldBytesTx = CommonUtils.totalTxBytes()
                val tx = CommonUtils.totalTxBytes(); mTrafficBytesTx = tx - mTrafficOldBytesTx; mTrafficOldBytesTx = tx
                mTrafficHandler.sendEmptyMessage(0)
            }
        }.also { mTimer.schedule(it, 1000L, 1000L) }
    }

    /** Reinicia a reprodução do canal atual na main thread. Original: N3()/O3() */
    fun restartPlay() = mHandler.post { startPlay(currentChannel()) }

    // ---------------------------------------------------------------- logout / expiração

    /**
     * Trata o motivo de logout do SDK (`M()`). Original: p4() (`toLogoutProcess`)
     * - 1: conta logada em outro dispositivo → diálogo "session_kicked_out" (Log In / Cancel) → login.
     * - 2: versão não suportada → diálogo "Check Update"/"Exit" (instala APK baixado, verifica, ou sai).
     * - 3: token de stream expirado → re-login silencioso (`x0()`), depois [restartPlay].
     * - outros: diálogo "log_out" (Log In / Cancel).
     */
    fun toLogoutProcess() {
        val reason = InteractionUtils.forcedLogoutReason()
        when (reason) {
            1 -> {
                if (isPopupLoginOrRenewFragment) { logger.warn("there is a popup window, ignored $reason"); return }
                if (isLogoutDlgShow.compareAndSet(false, true)) {
                    isPopupLoginOrRenewFragment = true
                    ConfirmDialog.show3(this, getString(R.string.session_kicked_out), getString(R.string.log_in), getString(R.string.cancel),
                        { showLoginPopup(); isLogoutDlgShow.set(false) },
                        { isLogoutDlgShow.set(false); isPopupLoginOrRenewFragment = false },
                        { isLogoutDlgShow.set(false); isPopupLoginOrRenewFragment = false })
                    mOSDListProgramPresenter?.hide()
                }
            }
            2 -> if (isLogoutDlgShow.compareAndSet(false, true)) {
                ConfirmDialog.show3(this, getString(R.string.force_logout_not_support_version, InteractionUtils.minSupportedVersion()),
                    getString(R.string.check_update), getString(R.string.exit),
                    { if (apkFile.isEmpty()) checkUpgrade() else installDownloadedApk(); isLogoutDlgShow.set(false) },
                    { isLogoutDlgShow.set(false); exit(true) },
                    { isLogoutDlgShow.set(false) })
            }
            3 -> {
                mOsdProgramPromptLoading?.showSpinner()
                CoroutineScope(Dispatchers.IO).launch {
                    InteractionUtils.loginFlow()
                        .catch { t ->
                            mHandler.post { mOsdProgramPromptLoading?.hideLoadView() }
                            logger.error("stream token expired, login failure", t)
                        }
                        .collect { (ok, code, msg) ->
                            mHandler.post {
                                mOsdProgramPromptLoading?.hideLoadView()
                                if (!ok) logger.error("stream token expired, login failure[$msg($code)")
                                else restartPlay()
                            }
                        }
                }
            }
            else -> if (!isPopupLoginOrRenewFragment) {
                if (isLogoutDlgShow.compareAndSet(false, true)) {
                    isPopupLoginOrRenewFragment = true
                    ConfirmDialog.show3(this, getString(R.string.log_out), getString(R.string.log_in), getString(R.string.cancel),
                        { showLoginPopup(); isLogoutDlgShow.set(false) },
                        { isLogoutDlgShow.set(false); isPopupLoginOrRenewFragment = false },
                        { isLogoutDlgShow.set(false); isPopupLoginOrRenewFragment = false })
                }
            } else logger.warn("there is a popup window, ignored $reason")
        }
    }

    /** Popup de login (RechargeDialogFragment tipo 22). Original: o4() + LiveNewActivity$a0 */
    private fun showLoginPopup() {
        com.live.evo.util.LoadingTimer.mark("liveLoadShowLogin")
        mVideoView?.stop(true)
        isPopupLoginOrRenewFragment = true
        RechargeDialogFragment.show(supportFragmentManager, 22, true, object : OsdControlListener {
            override fun a() { isPopupLoginOrRenewFragment = false }
            override fun b() { isPopupLoginOrRenewFragment = false }
            override fun c() { isPopupLoginOrRenewFragment = false }
            override fun e() { isPopupLoginOrRenewFragment = false; restartPlay() }
        })
    }

    /** Popup de recarga (RechargeDialogFragment tipo 54). Original: z4(Fragment) + LiveNewActivity$c0 */
    private fun showRechargePopup(fragment: Fragment? = null) {
        if (fragment != null) supportFragmentManager.beginTransaction().hide(fragment).commitAllowingStateLoss()
        isPopupLoginOrRenewFragment = true
        RechargeDialogFragment.show(supportFragmentManager, 54, true, object : OsdControlListener {
            override fun a() { isPopupLoginOrRenewFragment = false }
            override fun b() { isPopupLoginOrRenewFragment = false }
            override fun c() { isPopupLoginOrRenewFragment = false }
            override fun e() { isPopupLoginOrRenewFragment = false; restartPlay() }
        })
    }

    /**
     * Plano expirado. Ignora se já há popup, se há plano válido (`a0()`) ou se a aba de recarga está visível.
     * Com renew code: "End of trial…" (Recharge / Cancel); sem: mesmo texto + free_trial_tip(dias) (Log In / Cancel).
     * Ao fechar, se `event.type == 1` volta à tela de origem do catch-up ([returnFromCatchUp]).
     * Original: onServiceExpired(b5.i)
     */
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onServiceExpired(event: ServiceExpiredEvent) {
        if (isPopupLoginOrRenewFragment) { logger.warn("there is a popup window, ignore ServiceExpiredEvent"); return }
        if (InteractionUtils.hasValidPlan()) { logger.info("has valid plan, ignore ServiceExpiredEvent"); return }
        isPopupLoginOrRenewFragment = true
        val onClose = { isPopupLoginOrRenewFragment = false; if (event.type == 1) returnFromCatchUp() }
        if (InteractionUtils.renewCode().isNotEmpty()) {
            if (TabFunctionRechargeFragment.isShowing()) {
                isPopupLoginOrRenewFragment = false
                logger.info("tab is visible, ignore ServiceExpiredEvent")
                return
            }
            ConfirmDialog.show3(this, getString(R.string.media_not_free), getString(R.string.recharge), getString(R.string.cancel),
                { showRechargePopup() }, onClose, onClose)
            return
        }
        ConfirmDialog.show3(this, getString(R.string.media_not_free) + "<br/>" + getString(R.string.free_trial_tip, InteractionUtils.trialDays()),
            getString(R.string.login), getString(R.string.cancel), { showLoginPopup() }, onClose, onClose)
    }

    /** Dispara expiração se o relógio do servidor passou da validade. Original: l2() */
    private fun checkExpiredByClock() {
        if (InteractionUtils.expiryTimeMillis() > ServerClock.get().now() || mExpiredStatus >= 2) return
        onServiceExpired(ServiceExpiredEvent())
    }

    /**
     * Volta ao contexto que abriu o catch-up (`CatchUpPlayerActivity.Source`: "channel" → reabre lista,
     * "subjectMatch" → evento para SubjectMatchFragment, "bigEpg" sem ação) e reinicia o live.
     * Original: J3()
     */
    fun returnFromCatchUp() {
        when (CatchUpPlayerActivity.Source.current()) {
            "channel" -> mOSDListProgramPresenter?.reopen()
            "subjectMatch" -> EventBus.getDefault().post(com.live.evo.event.ReopenFragmentEvent(javaClass.name, com.live.evo.fragment.subject.SubjectMatchFragment::class.java.name))
            "bigEpg" -> Unit
        }
        restartPlay()
    }

    /** Logout manual de conta (`A0("main_activity")`). Original: X1(String) + corrotina accountLogout$1 (f) */
    fun accountLogout(message: String) {
        // Original: X1(String) — o parâmetro [message] não é usado no corpo.
        isInLogout = true
        hideOsd(true)
        mVideoView?.stop(true)
        livePlayHandler?.reset()
        releaseReceivers()
        mOsdProgramPromptLoading?.showSpinner()
        CoroutineScope(Dispatchers.IO).launch {
            InteractionUtils.logout("main_activity")
                .catch { t ->
                    isInLogout = false
                    mHandler.post { mOsdProgramPromptLoading?.hideLoadView() }
                    ToastHelper.show(getString(R.string.log_out_fail) + ":" + t.message)
                }
                .collect { (ok, _, msg) ->
                    mHandler.post {
                        mOsdProgramPromptLoading?.hideLoadView()
                        if (!ok) { ToastHelper.show(getString(R.string.log_out_fail) + ":" + msg); return@post }
                        ToastHelper.show(getString(R.string.log_out))
                        mVideoView?.requestFocus()
                        restartPlay()
                    }
                    isInLogout = false
                }
        }
    }

    /** Logout forçado (evento): volta para [LiveLoadActivity]. Original: onForceLogoutEvent(b5.e) */
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onForceLogoutEvent(event: ForceLogoutEvent) {
        hideOsd(true)
        mVideoView?.stop(true)
        AppUserManager.get().setLoggedIn(false)
        startActivity(Intent(this, LiveLoadActivity::class.java))
        finish()
    }

    // ---------------------------------------------------------------- eventos

    /**
     * Pedido externo de troca de canal (deep-link/onNewIntent, busca, favoritos...). Verifica canal atual,
     * existência (EpgRepository.findChannel), bloqueio de categoria adulta. Original: onChangeChannelEvent(b5.b)
     */
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onChangeChannelEvent(event: ChangeChannelEvent) {
        val channelId = event.channelId
        EventBus.getDefault().removeStickyEvent(event)
        if (channelId.isNullOrEmpty()) { ToastUtils.show(this, "channel is not null"); return }
        val cur = currentChannel()
        if (channelId == cur?.channelId) { ToastUtils.show(this, R.string.channel_playing_now); return }
        val target = EpgRepository.findChannel(channelId) ?: run { ToastUtils.show(this, R.string.channel_doesnot_exist); return }
        val (g, ig, all) = Triple(playGroupIdx, playInGroupIdx, playInAllIdx)
        playGroupIdx = 0; playInGroupIdx = target.index; playInAllIdx = target.index
        val adult = target.isAdult()
        if (adult && cur != null && !cur.isAdult()) {
            val (locked, category) = isAdultCategoryLocked(channelId)
            if (locked) {
                playGroupIdx = g; playInGroupIdx = ig; playInAllIdx = all
                ToastUtils.show(this, String.format(CommonUtils.string(R.string.unlock_adult_category), category))
                return
            }
        }
        AppUserManager.get().attach(this)
        AppUserManager.get().setLastChannelId(channelId)
        if (!adult || cur == null || !cur.isAdult() || AppUserManager.get().isAdultUnlocked()) {
            if (mVideoView?.visibility == View.VISIBLE) changeChannel(playInAllIdx)
        }
    }

    /** Novo intent (singleTask): channelId do extra/deep-link `livetvcontent`. Original: onNewIntent() + u2() */
    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        val id = if (intent.scheme == "livetvcontent") intent.data?.getQueryParameter("channelId") else intent.getStringExtra("channelId")
        if (id.isNullOrEmpty()) return
        EventBus.getDefault().postSticky(ChangeChannelEvent(id))
    }

    /** Lembrete de agendamento: mostra SubscribePopup. Original: onSubscribe(b5.k) */
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onSubscribe(event: SubscribeRemindEvent) {
        EventBus.getDefault().removeStickyEvent(event)
        mOSDListProgramPresenter?.hide()
        if (subscribeDialog == null) subscribeDialog = SubscribePopup(this, subscribePopupListener)
        subscribeDialog?.setData(event.subscribe)
        subscribeDialog?.show()
    }

    /**
     * Evento de upgrade (nf.z): com `delayTime` e não-manual adia o diálogo; senão mostra já.
     * Original: OnEvent(nf.z) / A3(boolean)
     */
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onUpgradeEvent(event: com.live.evo.event.UpgradeReadyEvent) {
        EventBus.getDefault().removeStickyEvent(event)
        mHandler.removeMessages(MSG_CHECK_UPGRADE)
        val delayMs = if (event.info.delayTime > 0) event.info.delayTime * 1000 else 0
        if (!event.isManual && delayMs != 0) {
            upgradeEvent = event
            mHandler.postDelayed({ popupUpgradeDlg(false) }, event.info.delayTime * 1000L)
            return
        }
        popupUpgradeDlg(event.isManual)
    }

    /** Original: A3(boolean) */
    private fun popupUpgradeDlg(isManual: Boolean = false) {
        val ev = upgradeEvent ?: return
        val now = DateUtils.now()
        if (!isManual && lastUpgradeEventTime > 0 && now - lastUpgradeEventTime < ev.info.delayTime * 1000L) return
        lastUpgradeEventTime = now
        if (mIsAppUpdateDialogShowing) return
        mIsAppUpdateDialogShowing = true
        com.live.evo.upgrade.UpgradeInstaller.prompt(this, ev.apkPath, ev.info, object : com.live.evo.dialog.UpgradePromptDialog.Listener() {})
    }

    /** Instala APK já baixado (ou reabre evento pendente). Original: a3() — SDK.E0(..., strings 2131953117..19, ícone, path) */
    private fun installDownloadedApk() {
        upgradeEvent?.let { onUpgradeEvent(it); return }
        InteractionUtils.installApk(this, R.string.upgrade_permission_dlg_title, R.string.upgrade_permission_dlg_desc,
            R.string.upgrade_permission_dlg_btn, R.drawable.ic_launcher_foreground, apkFile)
    }

    /** Verificação de upgrade (corrotina checkUpgrade$1 — análoga à de LiveLoadActivity). Original: o2() + i */
    private fun checkUpgrade() {
        if (isInChecking.compareAndSet(false, true)) {
            // Corrotina LiveNewActivity$i (checkUpgrade$1): igual a LiveLoadActivity.checkUpdate, mas sem loading de tela.
            CoroutineScope(Dispatchers.IO).launch {
                InteractionUtils.checkUpgrade(lifecycle) { version: String?, _: Int?, apkPath: String?, error: com.foxivid.baselib.upgrade.UpgradeError? ->
                    mHandler.post {
                        if (lastVersion != version && !version.isNullOrEmpty()) {
                            lastVersion = version
                            ToastHelper.show("${getString(R.string.new_version)}:$version")
                        }
                        if (!apkPath.isNullOrEmpty()) {
                            apkFile = apkPath
                            upgradeInfo?.let { onUpgradeEvent(com.live.evo.event.UpgradeReadyEvent(it, apkPath, false)) }
                        }
                        if (error != null) ToastHelper.show(error.message)
                        isInChecking.set(false)
                    }
                }.catch { t ->
                    runOnUiThread { ToastHelper.show(getString(R.string.check_failed) + ":" + t.message) }
                    logger.error("check upgrade failure", t)
                }.collect { info ->
                    upgradeInfo = info
                    isInChecking.set(false)
                    if ((info?.upgradeStatus ?: 0) != 0) ToastHelper.show(getString(R.string.update_msg))
                }
            }
        }
    }

    // ---------------------------------------------------------------- back / ciclo de vida

    /**
     * Back: (1) se veio de subject → reabre "subject"; (2) sem recomendação ativa → diálogo de saída (Y3);
     * (3) senão reabre "recommend". Original: onBackPressed()
     */
    override fun onBackPressed() {
        if (SubjectDataHelper.returnToSubject) {
            mOSDListProgramPresenter?.let { it.hide(); it.show(supportFragmentManager, "subject") }
            SubjectDataHelper.returnToSubject = false
            return
        }
        if (!com.live.evo.config.RecommendConfig.get().isEnabled()) {
            if (mUiManager == null || mUiManager?.isAnyPopupShowing() != true) showExitDialog()
            return
        }
        mOSDListProgramPresenter?.hide()
        mOSDListProgramPresenter?.show(supportFragmentManager, "recommend")
    }

    /**
     * Diálogo de saída; ao confirmar: se o SDK ainda está ocupado (`n0()`), mostra "exiting" e espera
     * em passos de 200 ms antes de [exit]. Original: Y3() + LiveNewActivity$x (showExitDialog$1$onExit$1)
     */
    private fun showExitDialog() {
        if (isFinishing || isDestroyed) { mHandler.postDelayed({ System.exit(0) }, 500L); return }
        mUiManager?.showExitDialog {
            if (!InteractionUtils.isBusy()) { exit(true); return@showExitDialog }
            mOsdProgramPromptLoading?.setPromptText(getString(R.string.exiting))
            mOsdProgramPromptLoading?.showSpinner()
            CoroutineScope(Dispatchers.IO).launch {
                while (InteractionUtils.isBusy()) delay(200L)
                withContext(Dispatchers.Main) { mOsdProgramPromptLoading?.hideLoadView(); exit(true) }
            }
        }
    }

    /**
     * Libera tudo; com `withProcess` também para métricas/SDK e mata o processo. Original: r2(boolean)
     */
    fun exit(withProcess: Boolean) {
        try {
            hideOsd(true); stopTimers(); stopReplayTimer(true)
            mOSDListProgramPresenter?.let { it.hide(); it.detach() }
            mOSDListProgramPresenter = null
            mUiManager?.release()
            livePlayHandler?.release()
            if (withProcess) {
                com.foxivid.baselib.metric.MetricMonitor.stop()
                UserActionTracker.stop()
                com.foxivid.baselib.metric.MetricReporter.flush("onDestroy")
                UserActionTracker.reset(null)
                finish()
                System.exit(0)
            }
        } catch (e: Exception) {
            logger.error("LiveNewActivity exit error, withProcess: {}", withProcess, e)
        }
    }

    /** Resultado do catch-up (requestCode 3): resultCode-1 = canal escolhido. Original: onActivityResult() */
    @Deprecated("API antiga mantida por fidelidade")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CatchUpPlayerActivity.REQUEST_CODE) {
            resumeFrom = 3
            if (resultCode > 0) {
                val idx = resultCode - 1
                if (playInAllIdx != idx) {
                    mOSDListProgramPresenter?.hide()
                    playGroupIdx = 0; playInGroupIdx = idx; playInAllIdx = idx
                    changeChannel(idx)
                    return
                }
                mHandler.postDelayed({ /* m3: reabre OSD do canal atual */ }, 200L)
                return
            }
            mHandler.postDelayed({ /* n3 */ }, 200L)
        }
    }

    override fun onStart() {
        super.onStart()
        if (isFirstStart) mHandler.sendEmptyMessageDelayed(MSG_NETWORK_OK, 300L)
    }

    /**
     * Original: onResume() — registra repetidores de tecla; se há canais: retoma o último canal;
     * se expirado (status 2) re-emite ServiceExpiredEvent; agenda MSG_CHECK_UPGRADE após FileWatchdog.DEFAULT_DELAY (60 s).
     */
    override fun onResume() {
        prepareResume()                    // H2()
        super.onResume()
        setupExpiredLayout()               // L2()
        registerReceivers()                // F3()
        refreshChannels()                  // S2()
        mKeyUpDownRepeatHandler.subscribe { changeChannelByKeyUpDown() }
        mInputCodeRepeatHandler.subscribe { changeChannelByInputCode() }
        if (shouldResumePlayback()) {
            startEcoTimer()
            mVideoView?.let { if (it.visibility != View.VISIBLE) it.visibility = View.VISIBLE; mOsdProgramPromptLoading?.showLoadView(); resumeLastChannel() }
        } else if (!isFirstStart && mExpiredStatus == 2) {
            onServiceExpired(ServiceExpiredEvent())
        }
        startTrafficMonitor()
        if (isFirstStart) isFirstStart = false
        currentChannel()?.let { if (mNoticeView != null) showNoticeFor(it.channelId) }
        mHandler.sendMessageDelayed(mHandler.obtainMessage(MSG_CHECK_UPGRADE), 60_000L)
    }

    /** Original: onPause() — esconde player adulto, solta receivers, zera estado de upgrade. */
    override fun onPause() {
        super.onPause()
        mKeyUpDownRepeatHandler.dispose(); mInputCodeRepeatHandler.dispose()
        if (mIsAdult) mVideoView?.visibility = View.GONE
        unregisterReceivers()
        if (mIsAdult) loadChannelLists()
        lastVersion = ""; apkFile = ""; lastPlayedLiveChannel = null; lastUpgradeEventTime = 0L; upgradeEvent = null
    }

    /** Original: onStop() — para OSD, timers e player; fecha avisos/agendamentos. */
    override fun onStop() {
        super.onStop()
        hideOsd(true)
        livePlayHandler?.release()
        stopTimers(); stopReplayTimer(false)
        releaseTimers()     // a2()
        mVideoView?.stop(true)
        noticeAlertDialog?.dismiss()
        subscribeDialog?.dismiss()
    }

    override fun onDestroy() {
        super.onDestroy()
        releaseReceivers(); releaseTimers(); releaseNotice()
        mHandler.removeCallbacksAndMessages(null)
        exit(true)
    }

    override fun onSaveInstanceState(outState: Bundle) { super.onSaveInstanceState(outState) /* remove rechargeAction */ }

    // ---------------------------------------------------------------- helpers usados acima

    /** Canal atual (lista global, playInAllIdx; se o índice estourou a lista volta ao 0). Original: A2() */
    fun currentChannel(): ChannelBean? {
        return try {
            val list = mListLiveDataAll
            val size = list?.size ?: 0
            if (size == 0) return null
            var i = playInAllIdx
            if (i >= size) i = 0
            list?.get(i)
        } catch (e: Exception) { logger.error("Error in getProgramData()", e); null }
    }

    /** Original: B2(int) — índice fora da lista cai em 0. */
    fun channelAt(index: Int): ChannelBean? {
        return try {
            val list = mListLiveDataAll
            val i = if (index >= (list?.size ?: 0)) 0 else index
            list?.get(i)
        } catch (e: Exception) { logger.error("Error in getProgramData() index = $index", e); null }
    }

    // --- diálogo de plano expirado (ViewStub `livenewa_vs_expired`) ---
    private var mExpiredLayout: ViewStub? = null
    private var mExpiredTitle: TextView? = null
    private var mTVCountdownTime: TextView? = null
    private var mRechargeGuide: TextView? = null
    private var mMemberQR: ImageView? = null
    private var mExpiredParent: RelativeLayout? = null
    private var mRechargeHint: TextView? = null
    private var expiredExperienceTimes = 0L

    // --- outros campos de estado (declarados no original, sem uso fora dos trechos abaixo) ---
    private var mGroupsList: Map<String, CategoryBean>? = null
    private var tipNoNetworkTime = 0L
    private var replayTask: TimerTask? = null
    private var mPlayType = ""
    private var mPlayerInfoWhat = 0
    private var mBufferingAllocateByPosition = false
    private var mTrafficCount = 0
    private var lastKeyTime = 0L
    private var isOnKeyAfterFocusLost = false
    private var upgradeInfo: com.foxivid.baselib.model.extra.upgrade.UpgradeInfo? = null
    /** Runnable de "modo eco" (diálogo de standby; classe `LiveNewActivity$b`). */
    private var ecoModeAction: Runnable? = null
    /** Lembrete de recarga a cada 12 h (classe `LiveNewActivity$d`). */
    private var rechargeAction: Runnable? = null

    /**
     * Receiver das ações `com.bb.action.*` (broadcasts de launchers/apps parceiros). Original: mMsgReceiver
     * - EPG → [showEpgDialog]; CONNECTIVITY_CHANGE → sem rede e sem eco: MSG_NETWORK_LOST; com rede: reconecta o tracker (`zf.f.e().u()`).
     * - FAVORITE (`channelFavorite`, `channelId`, `channelName`) → atualiza favoritos ([updateFavoriteByEvent]/[updateFavoriteForCurrent]).
     * - EXIT (`withProcess`) → [exit]; feedback → [showFeedbackDialog]; PIP (AddPIP/switchpip/closepip) → só toast quando PIP ligado.
     * - popupmenuview → menu lateral; showprogram (`showType` 1 = busca) → lista de canais; update → [checkUpgrade].
     * - switchprogram (`playindex`, `playGroupindex`) → posiciona grupo/índice sem trocar de canal.
     */
    private val mMsgReceiver = object : android.content.BroadcastReceiver() {
        override fun onReceive(context: android.content.Context, intent: Intent) {
            when (intent.action) {
                "com.bb.action.EPG" -> { showEpgDialog(); return }
                "android.net.conn.CONNECTIVITY_CHANGE" -> {
                    if (!isNetworkAvailable()) {
                        if (com.foxivid.baselib.util.EcoModeHelper.isInEcoMode()) return   // d0.j()
                        mHandler.sendEmptyMessage(MSG_NETWORK_LOST)
                    } else {
                        com.live.evo.util.TrackerConnection.get()?.reconnect()      // zf.f.e().u()
                    }
                    return
                }
                "com.bb.action.FAVORITE" -> {
                    val fav = intent.getIntExtra("channelFavorite", 0)
                    val id = intent.getStringExtra("channelId")
                    val name = intent.getStringExtra("channelName")
                    var idx = playInAllIdx
                    if (id.isNullOrEmpty()) updateFavoriteForCurrent(fav) else idx = updateFavoriteByEvent(id, name, fav)
                    if (UiFunctionConfig.get().favoriteEnabled() && playGroupIdx == UiFunctionConfig.get().favoriteGroupIndex() && fav == 0) isRemoveFavorite = true
                    if (UiFunctionConfig.get().favoriteEnabled() && fav == 0 && currentChannel()?.index == idx) {
                        isRemoveFavorite = true; isPlayFavoriteList = false; playGroupIdx = 0; playInGroupIdx = idx
                    }
                    return
                }
                "com.bb.action.EXIT" -> { exit(intent.getBooleanExtra("withProcess", false)); return }
                "com.bb.action.feedback" -> { showFeedbackDialog(); return }
                "com.bb.action.AddPIP" -> { if (UiFunctionConfig.get().pipEnabled()) ToastUtils.show(CommonUtils.string(R.string.no_signal)); return }
                "com.bb.action.switchpip" -> { if (UiFunctionConfig.get().pipEnabled()) ToastUtils.show(CommonUtils.string(R.string.pip_not_open)); return }
                "com.bb.action.closepip" -> return
                "com.bb.action.popupmenuview" -> {
                    mUiManager?.showMenu()   // a4() e t() chamam o mesmo LivePopupController.t()
                    return
                }
                "com.bb.action.showprogram" -> {
                    mOSDListProgramPresenter?.show(supportFragmentManager, if (intent.getIntExtra("showType", 0) == 1) "Search" else "Channel List")
                    mUiManager?.isAnyPopupShowing()   // G2(): LivePopupController.h() fecha o banner
                    return
                }
                "com.bb.action.update" -> { checkUpgrade(); return }
                "com.bb.action.switchprogram" -> {
                    val playIndex = intent.getIntExtra("playindex", 0)
                    val groupIndex = intent.getIntExtra("playGroupindex", 0)
                    if (mCategoryIdList.isNullOrEmpty()) mCategoryIdList = InteractionUtils.getCategoryIds(true)
                    val cats = mCategoryIdList
                    if (cats.isNullOrEmpty()) return
                    val list = mMapCategoryPrograms?.get(cats[groupIndex])
                    if (list.isNullOrEmpty()) return
                    var pos = 0
                    if (playIndex < 0) pos = list.size - 1 else if (playIndex < list.size) pos = playIndex
                    if (currentChannel() == list[pos]) mKeyUpDownRepeatHandler.trigger()
                    playInGroupIdx = pos
                    playGroupIdx = groupIndex
                }
            }
        }
    }

    /** Original: W3(ChannelBean) — LivePopupController.r(canal, posGrupo, grupo, 0). */
    fun showChannelBanner(ch: ChannelBean?) { mUiManager?.showChannelInfo(ch, playInGroupIdx, playGroupIdx, 0) }
    /** Original: B4() — LivePopupController.s(canal atual) → EpgDialog. */
    fun showEpgDialog() { mUiManager?.showEpgDialog(currentChannel()) }
    /** Original: m2() */
    fun isNetworkAvailable(): Boolean = NetworkUtils.isConnected(applicationContext)
    /** Original: v2() — canais favoritos (favorite>0) da categoria 0. */
    private fun favoriteChannels(): List<ChannelBean> = mCategoryIdList?.firstOrNull()?.let { mMapCategoryPrograms?.get(it) }?.filter { it.favorite > 0 } ?: emptyList()
    /** Original: p2() — limpa "history" (onClearHistory). */
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onClearHistory(event: com.live.evo.event.ClearHistoryEvent) { mMapCategoryPrograms?.put("history", emptyList()) }

    /** O player está tocando e com a posição avançando? Original: d3() */
    fun isLivePlaying(): Boolean = try { mVideoView?.isPlaying() == true } catch (_: Throwable) { false }

    /** Mantém o foco no player a cada segundo enquanto `isOnKeyAfterFocusLost` é falso. Original: classe `LiveNewActivity$v` */
    private val keepFocusRunnable = object : Runnable {
        override fun run() {
            if (isOnKeyAfterFocusLost) return
            mVideoView?.requestFocus()
            mHandler.postDelayed(this, 1000L)
        }
    }

    /** Diálogo de teste de rede fechou: volta a retomar o foco do player. Original: Q3() */
    fun onNetworkDialogClosed() {
        isOnKeyAfterFocusLost = false
        runOnUiThread(keepFocusRunnable)
    }

    /** Recarga concluída: se ainda vencido reabre o aviso de expiração; senão esconde o aviso e retoma a reprodução. Original: L3() */
    fun onExpiryRenewed() {
        if (AppUserManager.get().expiryTime() <= ServerClock.get().now()) { onServiceExpired(ServiceExpiredEvent()); return }
        expiredRemindTimeTask?.cancel()
        mExpiredParent?.visibility = View.GONE
        releaseReceivers()
        restartPlay()
    }
    private var expiredRemindTimeTask: TimerTask? = null

    // ---------------------------------------------------------------- estado de rede / timers

    /**
     * Original: `LiveNewActivity.K0(this)` — acessor sintético que devolve `null` (o campo `p5.a` foi removido do APK);
     * as chamadas no original são só `K0(this);` sem efeito.
     */
    private fun refreshNetworkState() {
        // NÃO RECUPERÁVEL: a classe p5.a (provável monitor de rede/publicidade) não existe no APK; no original a chamada é um no-op.
    }

    /** Original: G3() — corpo vazio no APK (ponto de extensão do "modo eco"/standby; o diálogo `$b` só é criado por [ecoModeAction]). */
    private fun startEcoTimer() { /* no-op no original */ }

    /** Registra o tempo da última tecla; se passou de 60 s sem tecla, reinicia o eco. Original: K3() */
    private fun resetIdleTimer() {
        val now = SystemClock.elapsedRealtime()
        val diff = now - lastKeyTime
        lastKeyTime = now
        if (diff > 60_000L) startEcoTimer()   // FileWatchdog.DEFAULT_DELAY = 60000
    }

    /** Cancela o timer de tráfego. Original: l4() */
    private fun stopTimers() {
        try { trafficTask?.cancel(); mTimer.purge() } catch (_: Exception) {}
    }

    /** Original: m4(boolean) — corpo vazio no APK. */
    private fun stopReplayTimer(exitThread: Boolean) { /* no-op no original */ }

    /** Original: a2() — remove o runnable do modo eco. */
    private fun releaseTimers() { ecoModeAction?.let { mHandler.removeCallbacks(it) } }
    /** Original: n4() — corpo vazio no APK. */
    private fun releaseReceivers() { /* no-op no original */ }
    /** Original: Z1() — remove o lembrete de recarga. */
    private fun releaseNotice() { rechargeAction?.let { mHandler.removeCallbacks(it) } }
    /** Original: h4(String) — "telemetria de ação"; corpo vazio no APK. */
    private fun trackAction(action: String) { /* no-op no original */ }
    /** Original: n2(String) — aviso por canal; corpo vazio no APK. */
    private fun showNoticeFor(channelId: String) { /* no-op no original */ }
    /** Original: j4(long) — corpo vazio no APK (chamado com 1500 ms ao preparar). */
    private fun onPreparedDelay(delay: Long) { /* no-op no original */ }

    // ---------------------------------------------------------------- favoritos

    /** Comparador por número lógico do canal. Original: F4(i5.h, i5.h) */
    private fun compareByIndex(a: ChannelBean?, b: ChannelBean?): Int = (a?.index ?: 0).compareTo(b?.index ?: 0)

    /**
     * Mantém a lista da categoria de favoritos: adiciona (sem repetir, ordenado por número) ou remove.
     * Original: E4(int, ChannelBean)
     */
    private fun updateFavoriteLists(fav: Int, ch: ChannelBean?) {
        if (ch == null) return
        var cat = UiFunctionConfig.get().favoriteGroupIndex()
        if (com.live.evo.config.ChannelNumberMode.get().isEnabled()) cat = 0   // a5.b.a().b()
        val key = mCategoryIdList?.getOrNull(cat) ?: return
        val current = mMapCategoryPrograms?.get(key) ?: return
        val list = ArrayList(current)
        if (fav > 0) {
            list.add(ch)
            val dedup = LinkedHashSet(list)   // HashSet no original; ordem restabelecida pelo sort abaixo
            list.clear(); list.addAll(dedup)
            if (list.isNotEmpty()) list.sortWith { a, b -> compareByIndex(a, b) }
        } else {
            list.remove(ch)
        }
        mMapCategoryPrograms?.put(key, list)
    }

    /** Favorito vindo do broadcast sem channelId: aplica ao canal atual. Original: i2(int) */
    private fun updateFavoriteForCurrent(favorite: Int) {
        val ch = currentChannel()
        ch?.favorite = favorite
        updateFavoriteLists(favorite, ch)
    }

    /** Favorito vindo do broadcast com channelId/nome; devolve o índice global do canal. Original: h2(String,String,int) */
    private fun updateFavoriteByEvent(channelId: String, channelName: String?, favorite: Int): Int {
        val list = mListLiveDataAll ?: return playInAllIdx
        val idx = list.indexOfFirst { it.channelId == channelId }
        if (idx < 0) return playInAllIdx
        val ch = list[idx]
        ch.favorite = favorite
        updateFavoriteLists(favorite, ch)
        return ch.index
    }

    // ---------------------------------------------------------------- OSD / número do canal

    /** Nome exibido no OSD para o índice digitado; fora da lista ou canal adulto → "no_program". Original: D2(int) */
    private fun channelNameAt(idx: Int): String? {
        val logical = com.live.evo.config.ChannelNumberMode.get().isEnabled()   // a5.b.a().b()
        val list = mListLiveDataAll
        val noProgram = getText(R.string.no_program).toString()
        if ((list?.size ?: 0) > idx && idx >= 0) {
            val ch = list?.get(idx)
            // As duas ramos (com/sem numeração lógica) fazem o mesmo no original: nome do canal se não for adulto.
            if (ch != null && !ch.isAdult()) return ch.name ?: noProgram
            if (logical && ch != null && !ch.isAdult()) return ch.name ?: noProgram
        }
        return noProgram
    }

    /** Atualiza o OSD com número/nome do canal [inAllPos] na main thread. Original: b4(int) + c4(int, LiveNewActivity) */
    private fun updateOsdIndex(inAllPos: Int) {
        RxUtils.runOnUiThread {
            var i = if (inAllPos <= 0) 0 else if (inAllPos >= (mListLiveDataAll?.size ?: 0)) 0 else inAllPos
            var number = inAllPos
            if (com.live.evo.config.ChannelNumberMode.get().isEnabled()) number = mListLiveDataAll?.getOrNull(i)?.index ?: 0
            mOsdProgramNum?.show(number.toString(), mListLiveDataAll?.getOrNull(i)?.name)
            mOsdProgramNum?.setVisibility(View.VISIBLE)
        }
    }

    /** Original: X3(ChannelBean, int) — LivePopupController.r(canal, posGrupo, grupo, código digitado). */
    private fun jumpToChannelNumber(ch: ChannelBean?, inputCode: Int) {
        mUiManager?.showChannelInfo(ch, playInGroupIdx, playGroupIdx, inputCode)
    }

    private fun setNoSignalVisibility(v: Int) {   // Original: R3(int)
        mNoSignal?.visibility = v
        mNoSignalIv?.visibility = v
    }

    /** Mostra a imagem de "sem sinal" (padrão `no_signal`) e esconde o vídeo. Original: S3(Integer) + j3(Integer) */
    private fun showNoSignalImage(resId: Int?) {
        val iv = mNoSignalIv ?: return
        mVideoView?.stop(true)
        try {
            iv.setImageDrawable(null)
            setNoSignalVisibility(View.VISIBLE)
            com.live.evo.util.GlideImageLoader.load(this, resId ?: R.drawable.no_signal, 0, iv)
        } catch (_: Exception) {}
    }

    /** Agenda (500 ms) a atualização do estado do popup de trial no [LivePopupController]. Original: f4() + g4(...) */
    private fun hideNoSignal() {
        val flag = InteractionUtils.flagK0()
        mHandler.postDelayed({
            if (window.decorView.windowToken != null) mUiManager?.showTrial(flag)
        }, 500L)
    }

    /**
     * Há canais na categoria atual? Se a lista está vazia recarrega do SDK ([refreshChannels]) e testa de novo.
     * Original: j2()
     */
    private fun needsBanner(): Boolean {
        fun current(): List<ChannelBean>? =
            if (isPlayFavoriteList) favoriteChannels() else mMapCategoryPrograms?.get(mCategoryIdList?.getOrNull(playGroupIdx) ?: "")
        if (!current().isNullOrEmpty()) return true
        refreshChannels()
        return !current().isNullOrEmpty()
    }

    /** Senha de canal adulto: fecha popups e abre [com.live.evo.dialog.AdultKeyDialog]. Original: U3(ChannelBean) + LiveNewActivity$w */
    private fun showAdultLock(ch: ChannelBean) {
        mUiManager?.dismissExitDialog()   // com.live.evo.g.g()
        AppUserManager.get().showAdultKeyDialog(this, object : com.live.evo.dialog.AdultKeyNewDialogFragment.Callback {
            override fun onUnlocked(channel: ChannelBean?) {
                mOSDListProgramPresenter?.hide()
                startPlay(channel)
                if (!isPlayFavoriteList) saveLastPosition(playGroupIdx, playInGroupIdx, playInAllIdx)
            }
            override fun onCancelled() { resumeLastChannel() }   // w2()
        }, ch)
    }

    /**
     * Esconde OSD e (opcionalmente) para o player. Com canal já em reprodução e a propriedade `stop_prev_play_imm`
     * (padrão true) o player é parado; com [closeOsd] esconde as camadas de prompt. Sem canal anterior, só pára o
     * player se ele estiver tocando. Sempre avisa o [livePlayHandler]. Original: k4(boolean)
     */
    fun hideOsd(closeOsd: Boolean) {
        if (lastPlayedLiveChannel != null) {
            try {
                if (AppUserManager.get().getBoolean("stop_prev_play_imm", true)) mVideoView?.stop(true)
                if (closeOsd) {
                    mOsdProgramPromptSignalPoor?.let { mOsdManager?.hide(it) }
                    mOsdProgramPromptLoading?.let { mOsdManager?.hide(it) }
                    mOsdProgramPromptOptimizing?.let { mOsdManager?.hide(it) }
                    mOsdProgramPromptRetrying?.let { mOsdManager?.hide(it) }
                }
            } catch (_: Throwable) {}
        } else if (mVideoView?.isPlaying() == true) {
            mVideoView?.stop(true)
        }
        livePlayHandler?.release()
    }

    /** O canal é o mesmo que está tocando (compara channelId)? Original: c3(ChannelBean) — note: devolve true quando DIFERENTE. */
    private fun isSameAsPlaying(ch: ChannelBean): Boolean {
        val cur = currentChannel() ?: return true
        return ch.channelId != cur.channelId
    }

    /** Original: E2() — esconde o layout de plano expirado (título, guia, dica, QR). */
    private fun resetPlayerState() {
        mExpiredParent?.visibility = View.GONE
        mExpiredTitle?.visibility = View.GONE
        mRechargeGuide?.visibility = View.GONE
        mRechargeHint?.visibility = View.GONE
        mMemberQR?.visibility = View.GONE
    }

    /** Pára o player (Original: s2()). */
    private fun retryPlay() { mVideoView?.stop(true) }

    /** Métrica de buffering enviada ao [livePlayHandler]. Original: k3(String,int,int,long) */
    private fun reportBuffering(id: String, ev: Int, times: Int, dur: Long) {
        val h = livePlayHandler ?: return
        h.report(ev, hashMapOf<String, Any?>("channel_id" to id, "times" to times, "duration" to dur))
    }

    // ---------------------------------------------------------------- posição / listas

    /**
     * Restaura a última posição ("grupo,posGrupo,posGlobal" de [PlaybackPrefs]) validando contra as listas atuais;
     * canal travado/adulto cai em 0,0,0 (ou 1 se já era 0,0,0). Persiste o resultado. Original: P2()
     */
    private fun loadChannelLists() {
        val saved = PlaybackPrefs.lastPosition()
        lookBackInfo = "-1,-1,-1"
        val parts = saved.split(",").dropLastWhile { it.isEmpty() }
        playGroupIdx = parts[0].toInt(); playInGroupIdx = parts[1].toInt(); playInAllIdx = parts[2].toInt()
        val g0 = playGroupIdx; val ig0 = playInGroupIdx; val all0 = playInAllIdx
        val cats = ArrayList(mCategoryIdList!!)
        if (UiFunctionConfig.get().hasPrivateGroups()) {   // com.live.evo.k.b().h()
            for (p in AppPropertiesStore.group("private_group")) {
                if (mCategoryIdList?.contains(p.key) == true && p.value == "1") cats.remove(p.key)
            }
        }
        try {
            val key = cats[playGroupIdx]
            val list = mMapCategoryPrograms?.get(key)
            val ch = list?.get(playInGroupIdx)
            val group = ModelHelper.groups()[key]
            if (playInAllIdx >= 0 && playInAllIdx < (mListLiveDataAll?.size ?: 0) && playGroupIdx < cats.size &&
                !list.isNullOrEmpty() && playInGroupIdx < list.size && ch != null && !ch.isLocked() && group != null && group.type != 1) {
                val inAll = mListLiveDataAll?.get(playInAllIdx)
                if ((inAll != null && inAll.isAdult()) || InteractionUtils.isAdultMode()) {
                    playGroupIdx = 0; playInGroupIdx = 0; playInAllIdx = 0
                    if (g0 == 0 && ig0 == 0 && all0 == 0) playInAllIdx = 1
                }
            } else {
                playGroupIdx = 0; playInGroupIdx = 0; playInAllIdx = 0
            }
        } catch (t: Throwable) {
            playGroupIdx = 0; playInGroupIdx = 0; playInAllIdx = 0
        }
        saveLastPosition(playGroupIdx, playInGroupIdx, playInAllIdx)
    }

    /** Guarda a posição anterior em [lookBackInfo] e grava a nova em [PlaybackPrefs]. Original: P3(int,int,int) */
    private fun saveLastPosition(g: Int, ig: Int, all: Int) {
        lookBackInfo = PlaybackPrefs.lastPosition()
        PlaybackPrefs.save(g.toString(), ig.toString(), all.toLong())
    }

    /**
     * Pode retomar a reprodução? Se voltou do catch-up (resumeFrom == 3) não; senão se há plano válido ou (plano vencido
     * mas status de expiração 0/1 e sem popup de login/recarga). Original: b3()
     */
    private fun shouldResumePlayback(): Boolean {
        if (resumeFrom == 3) { resumeFrom = null; return false }
        val expiry = InteractionUtils.expiryTimeMillis()
        val now = ServerClock.get().now()
        return expiry > now || (expiry < now && (mExpiredStatus == 0 || mExpiredStatus == 1) && !isPopupLoginOrRenewFragment)
    }

    private fun resumeLastChannel() { loadChannelLists(); trackAction("getLastLookAndPlay"); changeChannel(playInAllIdx) } // w2()

    /**
     * Procura [channelId] nos grupos privados (`private_group`) presentes nas categorias; posiciona
     * playGroupIdx/playInGroupIdx e devolve (grupo é "1"/travado, id do último grupo privado). Original: k2(String)
     */
    private fun isAdultCategoryLocked(channelId: String): Pair<Boolean, String> {
        val props = AppPropertiesStore.group("private_group")
        val cats = InteractionUtils.getCategoryIds(true)
        var groupId = ""
        var locked = false
        for (p in props) {
            if (cats.contains(p.key)) {
                groupId = p.key
                val list = ModelHelper.channelsByCategory()[p.key]
                if (list != null) {
                    var i = 0
                    for (c in list) {
                        if (channelId == c?.channelId) {
                            playGroupIdx = cats.indexOf(p.key); playInGroupIdx = i
                            locked = p.value == "1"
                            break
                        }
                        i++
                    }
                }
            }
        }
        return Pair(locked, groupId)
    }

    // ---------------------------------------------------------------- callbacks do player

    /** Callback de "loading" do player: mostra/oculta o prompt de carregamento. Original: U2() = U2(boolean,String) + V2/W2 */
    private fun onPlayerLoading(loading: Boolean, text: String?) {
        if (loading) {
            if (mOsdProgramPromptLoading?.visibility() != View.VISIBLE) {
                mHandler.post {
                    mOsdProgramPromptLoading?.showLoadView()
                    mOsdProgramPromptLoading?.let { mOsdManager?.show(it) }
                }
            }
        } else {
            mHandler.post {
                mOsdProgramPromptLoading?.let { mOsdManager?.hide(it) }
                mOsdProgramPromptLoading?.hideLoadView()
            }
        }
    }

    /**
     * Callback de "sem sinal" do player (código, descrição), executado na main thread. Original: X2() + Y2(int,LiveNewActivity,String)
     * -1 esconde; 0/8 timeout (+ MSG_NETWORK_LOST se passou de [tipNoNetworkTime]); 1 serviço expirado; 2 toast
     * `no_stream_notice_message_no_server`; 3/4 logout forçado; 5 upgrade; 6 sem sinal; 7 canal não encontrado.
     */
    private fun onNoSignal(code: Int, desc: String?) {
        mHandler.post {
            when (code) {
                -1 -> { setNoSignalVisibility(View.GONE); mNoticeView?.visibility = View.GONE }
                0, 8 -> {
                    setNoSignalVisibility(View.VISIBLE); mNoticeView?.visibility = View.VISIBLE
                    showNoSignalImage(R.drawable.requesttimeout)
                    if (isPopupLoginOrRenewFragment) { logger.warn("there is a popup window, ignore $code"); return@post }
                    else if (lastPlayTime >= tipNoNetworkTime) {
                        tipNoNetworkTime = DateUtils.now()
                        mHandler.sendMessage(mHandler.obtainMessage(MSG_NETWORK_LOST))
                    }
                }
                1 -> onServiceExpired(ServiceExpiredEvent())
                2 -> ToastHelper.show(getString(R.string.no_stream_notice_message_no_server))
                3, 4 -> {
                    if (isPopupLoginOrRenewFragment) { logger.warn("there is a popup window, ignore $code"); return@post }
                    toLogoutProcess()
                }
                5 -> if (apkFile.isNotEmpty()) installDownloadedApk() else checkUpgrade()
                6 -> { setNoSignalVisibility(View.VISIBLE); mNoticeView?.visibility = View.VISIBLE; showNoSignalImage(R.drawable.no_signal) }
                7 -> ToastHelper.show(getString(R.string.channel_not_found))
            }
            mNoticeView?.text = desc
        }
    }

    /** Fim de reprodução: toast `vod_play_complete`. Original: Z2() */
    private fun onPlayComplete() { ToastHelper.show(getString(R.string.vod_play_complete)) }

    /** Se a lista de canais não está visível, garante (após 100 ms) que ela esteja escondida. Original: H2() + I2(presenter) */
    private fun prepareResume() {
        val p = mOSDListProgramPresenter ?: return
        if (p.isShowing()) return
        mHandler.postDelayed({ p.hide() }, 100L)
    }

    /** Layout de plano vencido (ViewStub `livenewa_vs_expired`): textos de recarga com ${MS}/${RS}/${CS}. Original: L2() */
    private fun setupExpiredLayout() {
        if (InteractionUtils.expiryTimeMillis() > ServerClock.get().now() || mExpiredLayout != null) return
        mExpiredLayout = findViewById<ViewStub>(R.id.livenewa_vs_expired)
        mExpiredLayout?.inflate()
        mExpiredTitle = findViewById(R.id.tv_expired_remind_title)
        mExpiredParent = findViewById(R.id.expired_remind_parent)
        mTVCountdownTime = findViewById(R.id.tv_free_experience_countdown_time)
        mRechargeGuide = findViewById(R.id.tv_recharge_guide)
        mMemberQR = findViewById(R.id.iv_qr_membersite)
        mRechargeHint = findViewById(R.id.tv_remind_hint)
        val guide = CommonUtils.string(R.string.recharge_guide)
        val title = String.format(CommonUtils.string(R.string.expired_remind_for_live), 10)
        val hint = CommonUtils.string(R.string.how_to_renew)
        val site = InteractionUtils.memberSite()
        val g = guide.replace("\${MS}", site).replace("\${RS}", site).replace("\${CS}", InteractionUtils.customerService())
        mRechargeGuide?.text = Html.fromHtml(g)
        mExpiredTitle?.text = Html.fromHtml(title)
        mRechargeHint?.text = Html.fromHtml(hint)
        mExpiredParent?.visibility = View.GONE
    }

    /** Registra [mMsgReceiver] (API >= 26, flag RECEIVER_EXPORTED=2|... — o original passa 4). Original: F3() */
    private fun registerReceivers() {
        val f = IntentFilter().apply {
            listOf("com.bb.action.EPG", "com.bb.action.feedback", "android.net.conn.CONNECTIVITY_CHANGE", "com.bb.action.FAVORITE",
                "com.bb.action.EXIT", "com.bb.action.AddPIP", "com.bb.action.switchpip", "com.bb.action.closepip",
                "com.bb.action.switchprogram", "com.bb.action.popupmenuview", "com.bb.action.showprogram", "com.bb.action.update").forEach(::addAction)
        }
        if (Build.VERSION.SDK_INT >= 26) {
            try { registerReceiver(mMsgReceiver, f, 4) } catch (t: Throwable) { logger.error("register receiver failure", t) }
        }
    }

    private fun unregisterReceivers() {
        if (Build.VERSION.SDK_INT >= 26) {
            try { unregisterReceiver(mMsgReceiver) } catch (t: Throwable) { logger.error("unregister receiver failure", t) }
        }
    }

    /** Recarrega listas/categorias do SDK (`ModelHelper`). Original: S2() */
    private fun refreshChannels() {
        mListLiveDataAll = ModelHelper.allChannels()
        mCategoryIdList = InteractionUtils.getCategoryIds(true)
        mMapCategoryPrograms = ModelHelper.channelsByCategory()
        mGroupsList = ModelHelper.groups()
    }

    /**
     * Status de expiração: -1 plano válido; 0 vencido (sem registro de experiência); 1 vencido com < 600 s de
     * experiência; 2 com >= 600 s (guarda [expiredExperienceTimes]). Original: M2()
     * Nota: a string de controle lida no original é um literal vazio (`""`), logo na prática o status vencido é sempre 0.
     */
    private fun initExpiredStatus() {
        if (InteractionUtils.expiryTimeMillis() > ServerClock.get().now()) { mExpiredStatus = -1; return }
        val stored = ""   // literal vazio no original (valor persistido removido do build)
        if (stored.isEmpty()) { mExpiredStatus = 0; return }
        val parts = stored.split(",").dropLastWhile { it.isEmpty() }
        if (parts.size != 2 || parts[0] != DateUtils.today().toString()) { mExpiredStatus = 0; return }
        val t = parts[1].toInt()
        if (600 > t) { mExpiredStatus = 1; return }
        mExpiredStatus = 2
        expiredExperienceTimes = t.toLong()
    }

    /**
     * Cria as camadas do OSD e o apresentador de lista; aplica as cores do skin (`SkinConfig`, "cor1,cor2" ou "cor") ao
     * spinner de loading. Original: Q2()
     */
    private fun initOsd() {
        mOsdManager = OsdLayerManager()
        mOSDListProgramPresenter = OSDListProgramPresenter(supportFragmentManager, osdControlListener)
        val ctx = applicationContext
        mOsdProgramNum = ProgramNameLayer(ctx, mContainer!!)
        mOsdNetwork = NetworkPromptLayer(ctx, mContainer!!)
        mOsdProgramPromptSignalPoor = LoadingLayer(ctx, mContainer!!, R.string.signal_poor)
        mOsdProgramPromptLoading = LoadingLayer(ctx, mContainer!!, R.string.video_loading, true)
        mOsdProgramPromptRetrying = LoadingLayer(ctx, mContainer!!, R.string.video_retrying, true)
        mOsdProgramPromptOptimizing = OptimizingLayer(ctx, mContainer!!, R.string.video_optimizing)
        mOsdManager?.register("com.mm.droid.livetv.programnum", mOsdProgramNum!!)
        mOsdManager?.register("com.mm.droid.livetv.networkprompt", mOsdNetwork!!)
        mOsdManager?.register("com.mm.droid.livetv.program_prompt", mOsdProgramPromptSignalPoor!!)
        val skin = SkinConfig.get().loadingColors() ?: ""
        if (skin.isEmpty()) return
        val hex = Regex("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})$")
        val parts = skin.split(",").dropLastWhile { it.isEmpty() }
        if (parts.size != 2) {
            if (parts.size == 1 && parts[0].isNotEmpty() && hex.matches(parts[0])) mLoadingView?.setColorFilter(Color.parseColor(parts[0]))
            return
        }
        if (parts[0].isNotEmpty() && hex.matches(parts[0])) mLoadingView?.setColorFilter(Color.parseColor(parts[0]))
        if (parts[1].isNotEmpty() && hex.matches(parts[1])) mLoadingView?.setColorExtra(Color.parseColor(parts[1]))
    }

    /**
     * Callback do presenter da lista (interface `persenter/c$a`, classe `LiveNewActivity$k`). Os métodos `a`, `e`, `h`, `d`, `f`
     * têm corpo vazio no original (`q2`, `g2`, `Y1`); `m` só consulta `AppUserManager.C()` sem efeito.
     */
    private val osdControlListener = object : OsdPresenterCallback {
        override fun onTypeIndex(type: Int, index: Int) { /* q2: vazio no original */ }
        override fun onCatchUp(catchupType: String, bean: com.live.evo.model.ProgramBean, channelId: String) {
            catchUpClickListener.onCatchUpClick(catchupType, bean, channelId) { ok -> if (ok) hideOsd(true) }
        }
        /** f2(tag, index): com PIP ativo agenda MSG_UNLOCK_CHANNEL(arg1 = index, obj = tag). */
        override fun onTagIndex(tag: String, index: Int) {
            if (UiFunctionConfig.get().pipEnabled()) {
                mHandler.removeMessages(MSG_UNLOCK_CHANNEL)
                val m = Message(); m.what = MSG_UNLOCK_CHANNEL; m.arg1 = index; m.obj = tag
                mHandler.sendMessage(m)
            }
        }
        override fun onTag(tag: String) { /* g2: vazio no original */ }
        /** C2(): número lógico do canal atual (ou 0). */
        override fun currentValue(): Int = currentChannel()?.index ?: 0
        override fun onContainer(tag: String, container: View) { /* Y1: vazio no original */ }
        override fun channelData(): ChannelBean? = currentChannel()
        override fun onSelection(categorySelect: Int, programSelect: Int, inAllProgramPos: Int, playType: String?) {
            trackAction(playType ?: "")
            isPlayFavoriteList = false
            playGroupIdx = categorySelect
            playInGroupIdx = programSelect
            mPlayType = playType ?: ""
            changeChannel(inAllProgramPos)
            mPlayType = ""
        }
        override fun onStatsToggle() { livePlayHandler?.onPlayerStatsToggle() }   // V3()
        /** C4(): alterna o painel de estatísticas do player (`player_stat_container`) por 10 s. */
        override fun onToggleStats() {
            val box = player_stat_container
            val shown = box != null && box.visibility == View.VISIBLE
            if (!AppUserManager.get().isStatsEnabled()) {
                if (shown) { livePlayHandler?.setStatsEnabled(false, 10000); box?.visibility = View.INVISIBLE }
                return
            }
            if (shown) { livePlayHandler?.setStatsEnabled(false, 10000); box?.visibility = View.INVISIBLE; return }
            box?.visibility = View.VISIBLE
            livePlayHandler?.setStatsEnabled(true, 10000)
        }
        override fun onItemSelected(position: Int) { /* e2: só consulta AppUserManager.C(), sem efeito */ }
    }

    /**
     * Sequência de inicialização chamada pelo onCreate. Original: J2()
     * (callback do EcoModeHelper é vazio no original; recarga a cada 12 h só se faltam menos de [RECHARGE_REMIND_DAYS] dias).
     */
    private fun initServices() {
        com.foxivid.baselib.util.EcoModeHelper.start { /* callback vazio no original (K2) */ }   // d0.i(cb)
        // O2() — corpo vazio no APK
        refreshChannels()
        initExpiredStatus()
        networkTester = NetworkStatusDialogFragment.createTester(this)
        initOsd()
        ecoModeAction = EcoModeAction(this)
        if (InteractionUtils.expiryTimeMillis() < ServerClock.get().now() + InteractionUtils.reminderWindowMillis()) {   // U() (heartbeat q0)
            rechargeAction = Runnable { showRechargeReminder(24); scheduleRechargeReminder() }   // classe `LiveNewActivity$d`
            scheduleRechargeReminder()
        }
        livePlayHandler = ChannelSwitchHelper(this) { channel, headers, url ->
            runOnUiThread { logger.info("-----onPlay: $channel"); playStream(channel, headers, url) }
        }
    }

    /** Reagenda o lembrete de recarga (12 h) se faltam menos de [RECHARGE_REMIND_WINDOW_MS]. Original: E3() */
    private fun scheduleRechargeReminder() {
        try {
            val r = rechargeAction ?: return
            mHandler.removeCallbacks(r)
            if (InteractionUtils.expiryTimeMillis() < ServerClock.get().now() + RECHARGE_REMIND_WINDOW_MS) mHandler.postDelayed(r, 43_200_000L)
        } catch (_: Throwable) {}
    }

    /** Abre o popup de recarga/login com o tipo [showType]. Original: d4(int) + LiveNewActivity$y */
    private fun showRechargeReminder(showType: Int) {
        RechargeDialogFragment.show(supportFragmentManager, showType, object : OsdControlListener {
            override fun onPositive() { isPopupLoginOrRenewFragment = false }
            override fun onNegative() { isPopupLoginOrRenewFragment = false }
            override fun onDismiss() { isPopupLoginOrRenewFragment = false }
        })
    }

    /** Abre o diálogo de feedback (tag "feedback"), reaproveitando a instância. Original: e4() */
    private fun showFeedbackDialog() {
        val dlg = feedbackDialogFragment ?: FeedbackDialogFragment().also { feedbackDialogFragment = it }
        try {
            dlg.setChannelName(currentChannel()?.name)
            dlg.setChannelId(currentChannel()?.channelId)
            val fm = supportFragmentManager
            if (fm.findFragmentByTag("feedback") == null) dlg.show(fm, "feedback")
            else fm.beginTransaction().show(dlg).commitAllowingStateLoss()
        } catch (e: Exception) { logger.error("open feedback error", e) }
    }

    /** Agenda reinício da reprodução (timer de replay), mostrando toast opcional. Original: I3(boolean,int,boolean,boolean) / H3 */
    private fun scheduleReplay(resetErrCount: Boolean, delay: Int, showToast: Boolean = false, blockShowEpg: Boolean = false) {
        if (resetErrCount) mLiveErrorCount = 0
        val player = mVideoView ?: return
        player.stop(true)
        livePlayHandler?.cancel()
        replayTask?.cancel()
        replayTask = object : TimerTask() {   // classe `LiveNewActivity$u`
            override fun run() {
                mHandler.post {
                    if (showToast) ToastUtils.show(this@LiveNewActivity, R.string.source_stream_change_restart_player)
                    sendReplayMetric()
                    if (blockShowEpg) mHandler.post { preparePlayAction.run() } else startPlay(currentChannel())
                }
            }
        }
        mTimer.schedule(replayTask, delay.toLong())
    }

    /** Métrica 101 (replay) com o channel_id atual. Original: l3() */
    private fun sendReplayMetric() {
        try { livePlayHandler?.report(101, hashMapOf<String, Any?>("channel_id" to currentChannel()?.channelId)) } catch (_: Exception) {}
    }

    // ---------------------------------------------------------------- repetição de troca de canal (RxTrigger)

    /** Efetiva a troca por setas após 100 ms: toca o canal do grupo atual (ou o atual, se lista de favoritos). Original: LiveNewActivity$h (j8.c) */
    private fun changeChannelByKeyUpDown() {
        runOnUiThread {
            try {
                if (!isPlayFavoriteList) {
                    val idx = mMapCategoryPrograms?.get(mCategoryIdList?.getOrNull(playGroupIdx) ?: "")?.getOrNull(playInGroupIdx)?.index ?: 0
                    changeChannel(idx)
                } else changeChannel(playInAllIdx)
            } catch (e: Exception) { logger.error("repeater handler pulse", e) }
        }
    }

    /**
     * Efetiva o número digitado após 2 s: se é o canal atual mostra "is_playing"; se é adulto restaura o número
     * anterior; senão troca para o canal. Original: LiveNewActivity$g (j8.c) — com mapa de números lógicos sempre vazio.
     */
    private fun changeChannelByInputCode() {
        runOnUiThread {
            isPlayFavoriteList = false; canClickUpDown = true; isInputProgramNum = false
            val typed = mOsdProgramNum?.idNumber() ?: 0
            if (typed == playInAllIdx) { mOsdProgramNum?.show(typed.toString(), CommonUtils.string(R.string.is_playing)); return@runOnUiThread }
            if (typed >= 0 && typed < (mListLiveDataAll?.size ?: 0)) {
                val ch = mListLiveDataAll?.get(typed) ?: return@runOnUiThread
                if (ch.isAdult()) { mOsdProgramNum?.setProgramId(playInAllIdx.toString()); return@runOnUiThread }
                // com numeração lógica o original consulta mapas vazios (n0.i()) e não faz nada
                if (!com.live.evo.config.ChannelNumberMode.get().isEnabled()) {
                    playGroupIdx = 0; playInGroupIdx = typed
                    changeChannel(typed)
                }
            }
        }
    }

    // ---------------------------------------------------------------- listeners do player

    /** Player preparado: registra [lastPlayTime], esconde o loading se não há "optimizing" e marca troca concluída. Original: i3(...) */
    private val mVideoPrepareListener = IMediaPlayer.OnPreparedListener {
        lastPlayTime = DateUtils.now()
        if (mOsdProgramPromptLoading?.isLoadViewShown() == true && mOsdProgramPromptOptimizing?.visibility() != View.VISIBLE) {
            mOsdProgramPromptLoading?.hideLoadView()
        }
        isChangeChannel = false
        onPreparedDelay(1500L)
    }

    /**
     * Erro do player: conta erros; > 2 → esconde o aviso "signal poor"; 1 (UNKNOWN) → re-tenta em 5 s sem zerar contador;
     * qualquer outro (exceto -38) → re-tenta em 5 s zerando. Sempre devolve false. Original: g3(...)
     */
    private val mVideoOnErrorListener = IMediaPlayer.OnErrorListener { _, what, extra ->
        mLiveErrorCount++
        Log.e("LiveNewActivity", "-----player onError: what[$what] extra[$extra] err count[$mLiveErrorCount]")
        mLiveLastError = "w[$what] ex[$extra]"
        if (mLiveErrorCount > 2) {
            runOnUiThread { mOsdProgramPromptSignalPoor?.let { mOsdManager?.show(it) } }
            return@OnErrorListener false
        }
        if (what == 1) scheduleReplay(false, 5000) else if (what != -38) scheduleReplay(true, 5000)
        false
    }

    /** Buffering 701/702 (se não atribuído por posição). Original: LiveNewActivity$p */
    private val mVideoOnInfoListener = object : IMediaPlayer.OnInfoListener {
        override fun onInfo(mp: IMediaPlayer, what: Int, extra: Int, info: String?): Boolean {
            if (mPlayerInfoWhat != what) mPlayerInfoWhat = what
            if (what == 701) { if (!mBufferingAllocateByPosition) onBufferingStart(); return false }
            if (what == 702 && !mBufferingAllocateByPosition) onBufferingEnd()
            return false
        }
    }

    /** Original: f3(IMediaPlayer) — corpo vazio no APK. */
    private val mVideoOnCompletionListener = IMediaPlayer.OnCompletionListener { /* no-op no original */ }
    /** Original: e3(IMediaPlayer, int) — corpo vazio no APK (atualização de buffering). */
    private val mVideoOnBufferingUpdateListener = IMediaPlayer.OnBufferingUpdateListener { _, _ -> /* no-op no original */ }

    /**
     * A cada segundo (mensagem do [trafficTask]): mostra a velocidade rx no loading; mantém contador de ticks sem
     * tráfego (<= 10 B/s por 5 ticks); se há rede some o aviso e, se o player parou, reexecuta [preparePlayAction];
     * sem rede mostra o aviso de rede. Original: LiveNewActivity$o
     */
    private val mTrafficHandler: Handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            if (AppUserManager.get().isUserIdle()) return
            val rx = mTrafficBytesRx
            mOsdProgramPromptLoading?.setLoadViewText(rx.toString())
            if (rx <= 10 && mTrafficCount < 5) mTrafficCount++
            var net: Boolean
            if (rx <= 0 || mTrafficCount >= 5) {
                net = isNetworkAvailable()
                if (net) mTrafficCount = 0
            } else net = true
            if (!net) {
                if (mOsdNetwork?.visibility() == View.VISIBLE) return
                mOsdNetwork?.let { mOsdManager?.show(it) }
                return
            }
            if (mOsdNetwork?.visibility() == View.VISIBLE) {
                if (mVideoView?.isPlaying() != true) post(preparePlayAction)
                refreshNetworkState()
            }
            mOsdNetwork?.let { mOsdManager?.hide(it) }
            mVideoView?.requestFocus()
        }
    }

    /** Original: LiveNewActivity$m — implementação vazia de `SubscribeManager.Listener`. */
    private val mSubscribeListener: SubscribeManager.Listener = object : SubscribeManager.Listener {}

    /** Original: LiveNewActivity$s / $q — ambos: ao fechar chama `SubscribeManager.p()`; ao selecionar vai ao canal (grupo 0). */
    private val subscribePopupListener: SubscribePopup.Listener = object : SubscribePopup.Listener {
        override fun onClosed() { SubscribeManager.onPopupClosed() }
        override fun onChannelSelected(pos: Int) {
            if (playInAllIdx != pos) { playGroupIdx = 0; playInGroupIdx = pos; changeChannel(pos) }
        }
    }

    /**
     * Original: LiveNewActivity$c — runnable de prompt de OSD; o `run()` é vazio no APK
     * (só guarda [repeatCnt] por `a(int)`).
     */
    private val mOsdPromptRunnable = object : Runnable { var repeatCnt = 0; override fun run() { /* corpo vazio no original */ } }

    /** Original: LiveNewActivity$b — runnable do "modo eco": abre [com.live.evo.dialog.EcoModeDialog] e trata status. */
    private class EcoModeAction(private val activity: LiveNewActivity) : Runnable {
        override fun run() {
            val dlg = com.live.evo.dialog.EcoModeDialog(activity)
            dlg.show()
            dlg.setOnStatusListener { status ->
                when (status) {
                    0 -> {   // continuar assistindo
                        com.foxivid.baselib.util.EcoModeHelper.onUserActivity()   // d0.n()
                        AppUserManager.get().setUserPlayStatus(0)
                        if (activity.shouldResumePlayback()) {
                            activity.mOSDListProgramPresenter?.show(activity.supportFragmentManager, "Channel List")
                            activity.startPlay(activity.currentChannel())
                        }
                        dlg.cancel(); activity.startEcoTimer(); activity.startTrafficMonitor()
                    }
                    1 -> { dlg.dismiss(); activity.exit(true) }
                    3 -> {
                        com.foxivid.baselib.util.EcoModeHelper.enterEcoMode()   // d0.h()
                        activity.mVideoView?.stop(true)
                        AppUserManager.get().setUserPlayStatus(2)
                    }
                    4 -> { activity.ecoModeAction?.let { activity.mHandler.removeCallbacks(it) }; com.foxivid.baselib.util.EcoModeHelper.onUserActivity() }
                }
            }
        }
    }

    companion object {
        const val TAG = "LiveNewActivity"
        /** Tecla de favorito de alguns controles STB. */
        const val KEYCODE_STB_FAVORITE = 284
        const val MSG_NETWORK_LOST = 620908545
        const val MSG_NETWORK_OK = 620908546
        const val MSG_CHECK_UPGRADE = 620908574
        const val MSG_NETWORK_RECHECK = 620908578
        const val MSG_RESET_BACK = 620908591
        const val MSG_UNLOCK_CHANNEL = 620908595
        const val MSG_SHOW_CURRENT = 620908596
        /** Janela de lembrete de recarga: `com.live.evo.a.f5196p` = 72 h (TimeUnit.HOURS.toMillis(72)). */
        const val RECHARGE_REMIND_WINDOW_MS = 72L * 60 * 60 * 1000
    }
}

/**
 * Callback do [OSDListProgramPresenter] (interface `com.live.evo.osd.persenter.c$a`) implementado por [LiveNewActivity].
 * Nomes legíveis; letras originais entre parênteses.
 */
interface OsdPresenterCallback {
    fun onTypeIndex(type: Int, index: Int)                                                              // a
    fun onCatchUp(catchupType: String, bean: com.live.evo.model.ProgramBean, channelId: String)         // b
    fun onTagIndex(tag: String, index: Int)                                                             // c
    fun onTag(tag: String)                                                                              // e
    fun currentValue(): Int                                                                             // g
    fun onContainer(tag: String, container: View)                                                       // h
    fun channelData(): ChannelBean?                                                                     // i
    fun onSelection(categorySelect: Int, programSelect: Int, inAllProgramPos: Int, playType: String?)   // j
    fun onStatsToggle()                                                                                 // k
    fun onToggleStats()                                                                                 // l
    fun onItemSelected(position: Int)                                                                   // m
    fun onUnused1() {}                                                                                  // d (vazio)
    fun onUnused2() {}                                                                                  // f (vazio)
}
