package com.live.evo.activity

import android.content.Intent
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
    private var isPopupLoginOrRenewFragment = false
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
        TODO("nativo/não decompilado: LiveNewActivity.onCreate")
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
        FontUtils.applyMedium(mNoticeView)
        FontUtils.applyRegular(mPlayerStatInfoView)
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
        mInputCodeRepeatHandler.fire()
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
        mKeyUpDownRepeatHandler.fire()
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
        mOsdProgramPromptLoading?.showLoading()
        if (needsBanner()) {     // j2()
            try {
                if (window.decorView.windowToken != null) showChannelBanner(liveData)
                else mHandler.postDelayed({ try { if (window.decorView.windowToken != null) showChannelBanner(liveData) } catch (e: Exception) { logger.error(e.message, e) } }, 200L)
            } catch (e: Exception) { logger.error(e.message, e) }
        }
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
        if (mOsdProgramPromptSignalPoor?.getVisibility() == View.VISIBLE) mOsdProgramPromptSignalPoor?.setVisibility(View.GONE)
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
            if (mOsdProgramPromptRetrying?.getVisibility() != View.VISIBLE) { mOsdManager?.show(mOsdProgramPromptLoading); mOsdProgramPromptLoading?.showLoading() }
            livePlayHandler?.play(cur)
            stopReplayTimer(false)
            if (mOsdProgramPromptRetrying?.getVisibility() != View.VISIBLE) { mOsdManager?.show(mOsdProgramPromptLoading); mOsdProgramPromptLoading?.showLoading() }
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
        if (hasChannels()) { trackAction("onLoadDataSuccess"); changeChannel(playInAllIdx) }
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
                mOsdProgramPromptLoading?.showProgress()
                CoroutineScope(Dispatchers.IO).launch {
                    InteractionUtils.loginFlow()
                        .catch { t ->
                            mHandler.post { mOsdProgramPromptLoading?.hideAll() }
                            logger.error("stream token expired, login failure", t)
                        }
                        .collect { (ok, code, msg) ->
                            mHandler.post {
                                mOsdProgramPromptLoading?.hideAll()
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
        // TODO("parcial: X1() exibe a mensagem antes de lançar a corrotina — corpo exato não detalhado")
        CoroutineScope(Dispatchers.IO).launch {
            InteractionUtils.logout("main_activity")
                .catch { t ->
                    isInLogout = false
                    mHandler.post { mOsdProgramPromptLoading?.hideAll() }
                    ToastHelper.show(getString(R.string.log_out_fail) + ":" + t.message)
                }
                .collect { (ok, _, msg) ->
                    mHandler.post {
                        mOsdProgramPromptLoading?.hideAll()
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
            TODO("não detalhado: corrotina LiveNewActivity\$checkUpgrade\$1 (classe i) — mesmo padrão de LiveLoadActivity.checkUpdate")
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
            mOsdProgramPromptLoading?.setText(getString(R.string.exiting))
            mOsdProgramPromptLoading?.showProgress()
            CoroutineScope(Dispatchers.IO).launch {
                while (InteractionUtils.isBusy()) delay(200L)
                withContext(Dispatchers.Main) { mOsdProgramPromptLoading?.hideAll(); exit(true) }
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
        registerReceivers()                // L2()
        refreshUserState()                 // F3()
        refreshChannels()                  // S2()
        mKeyUpDownRepeatHandler.subscribe { changeChannelByKeyUpDown() }
        mInputCodeRepeatHandler.subscribe { changeChannelByInputCode() }
        if (hasChannels()) {
            startEcoTimer()
            mVideoView?.let { if (it.visibility != View.VISIBLE) it.visibility = View.VISIBLE; mOsdProgramPromptLoading?.showLoading(); resumeLastChannel() }
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
    // Os métodos abaixo existem no original; corpos não detalhados (ajustes de view/estado/telemetria).

    /** Canal atual (lista global, playInAllIdx). Original: A2() */
    fun currentChannel(): ChannelBean? = channelAt(playInAllIdx)
    /** Original: B2(int) */
    fun channelAt(index: Int): ChannelBean? = mListLiveDataAll?.getOrNull(index)
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

    private fun refreshNetworkState(): Unit = TODO("não detalhado: K0() (p5.a, estado de rede do OSD)")
    private fun startEcoTimer(): Unit = TODO("não detalhado: G3() (modo eco/standby)")
    private fun resetIdleTimer(): Unit = TODO("não detalhado: K3()")
    private fun updateFavoriteLists(fav: Int, ch: ChannelBean?): Unit = TODO("não detalhado: E4(int, ChannelBean)")
    private fun channelNameAt(idx: Int): String? = TODO("não detalhado: D2(int)")
    private fun trackAction(action: String): Unit = TODO("não detalhado: h4(String) — telemetria de ação")
    private fun jumpToChannelNumber(ch: ChannelBean?, inputCode: Int): Unit = TODO("não detalhado: X3(ChannelBean, int)")
    private fun updateOsdIndex(inAllPos: Int): Unit = TODO("não detalhado: b4(int)/c4() — OSD número/nome")
    private fun setNoSignalVisibility(v: Int): Unit = TODO("não detalhado: R3(int)")
    private fun hideNoSignal(): Unit = TODO("não detalhado: f4()")
    private fun needsBanner(): Boolean = TODO("não detalhado: j2()")
    private fun showAdultLock(ch: ChannelBean): Unit = TODO("não detalhado: U3(ChannelBean) — senha adulto")
    fun hideOsd(closeOsd: Boolean): Unit = TODO("não detalhado: k4(boolean)")
    private fun showNoticeFor(channelId: String): Unit = TODO("não detalhado: n2(String)")
    private fun isSameAsPlaying(ch: ChannelBean): Boolean = TODO("não detalhado: c3(ChannelBean)")
    private fun resetPlayerState(): Unit = TODO("não detalhado: E2()")
    private fun retryPlay(): Unit = TODO("não detalhado: s2()")
    private fun stopReplayTimer(exitThread: Boolean): Unit = TODO("não detalhado: m4(boolean)")
    private fun stopTimers(): Unit = TODO("não detalhado: l4()")
    private fun reportBuffering(id: String, ev: Int, times: Int, dur: Long): Unit = TODO("não detalhado: k3() — métrica de buffering")
    private fun loadChannelLists(): Unit = TODO("não detalhado: P2() — monta mListLiveDataAll/mCategoryIdList/mMapCategoryPrograms a partir do SDK")
    private fun hasChannels(): Boolean = TODO("não detalhado: b3()")
    private fun saveLastPosition(g: Int, ig: Int, all: Int): Unit = TODO("não detalhado: P3() — salva posição (lookBackInfo)")
    private fun resumeLastChannel() { loadChannelLists(); trackAction("getLastLookAndPlay"); changeChannel(playInAllIdx) } // w2()
    private fun isAdultCategoryLocked(channelId: String): Pair<Boolean, String> = TODO("não detalhado: k2(String)")
    private fun onPlayerLoading(loading: Boolean, text: String?): Unit = TODO("não detalhado: U2()")
    private fun onNoSignal(code: Int, desc: String?): Unit = TODO("não detalhado: X2()/Y2()")
    private fun onPlayComplete(): Unit = TODO("não detalhado: Z2()")
    private fun prepareResume(): Unit = TODO("não detalhado: H2()")
    private fun registerReceivers(): Unit = TODO("não detalhado: L2()")
    private fun unregisterReceivers(): Unit = TODO("não detalhado: unregisterReceiver(mMsgReceiver) (API>=26)")
    private fun refreshUserState(): Unit = TODO("não detalhado: F3()")
    private fun refreshChannels(): Unit = TODO("não detalhado: S2()")
    private fun releaseTimers(): Unit = TODO("não detalhado: a2()")
    private fun releaseReceivers(): Unit = TODO("não detalhado: n4()")
    private fun releaseNotice(): Unit = TODO("não detalhado: Z1()")
    private fun changeChannelByKeyUpDown(): Unit = TODO("não detalhado: LiveNewActivity\$h (j8.c) — efetiva troca após 100 ms")
    private fun changeChannelByInputCode(): Unit = TODO("não detalhado: LiveNewActivity\$g (j8.c) — efetiva troca após 2 s")

    private val mVideoPrepareListener: Any get() = TODO("não detalhado: listener de prepared")
    private val mVideoOnErrorListener: Any get() = TODO("não detalhado: listener de erro")
    private val mVideoOnInfoListener: Any get() = TODO("não detalhado: LiveNewActivity\$p — 701/702 → onBufferingStart/onBufferingEnd")
    private val mVideoOnCompletionListener: Any get() = TODO("não detalhado")
    private val mTrafficHandler: Handler get() = TODO("não detalhado: LiveNewActivity\$o — atualiza mPlayerStatInfoView com velocidade")
    private val mSubscribeListener: SubscribeManager.Listener get() = TODO("não detalhado: LiveNewActivity\$m")
    private val subscribePopupListener: SubscribePopup.Listener get() = TODO("não detalhado: LiveNewActivity\$s/\$q")
    /** Original: LiveNewActivity$c — reexibe prompt de OSD (repeatCnt). */
    private val mOsdPromptRunnable = object : Runnable { var repeatCnt = 0; override fun run() { TODO("não detalhado: LiveNewActivity\$c.run") } }

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
    }
}
