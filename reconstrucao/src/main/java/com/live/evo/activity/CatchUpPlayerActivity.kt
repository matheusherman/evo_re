package com.live.evo.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.SystemClock
import android.view.KeyEvent
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.blankj.utilcode.util.Utils
import com.foxivid.baselib.config.InteractionUtils
import com.foxivid.baselib.network.AppParams
import com.google.gson.reflect.TypeToken
import com.live.evo.R
import com.live.evo.ad.CatchUpAdManager
import com.live.evo.catchup.player.CatchUpMediaController
import com.live.evo.catchup.CatchUpPlayInfo
import com.live.evo.dialog.ConfirmDialog
import com.live.evo.dialog.NoticeAlertDialog
import com.live.evo.dialog.SubscribePopup
import com.live.evo.event.NoticeEvent
import com.live.evo.event.SubscribeRemindEvent
import com.live.evo.event.SubscribeTimeEvent
import com.live.evo.osd.SubscribeManager
import com.live.evo.util.CommonUtils
import com.live.evo.util.DateFormatFactory
import com.live.evo.util.DateUtils
import com.live.evo.util.EpgRepository
import com.live.evo.util.GsonFactory
import com.live.evo.util.ServerClock
import com.live.evo.util.SkinConfig
import com.live.evo.widget.LiveCatchUpVideoView
import com.live.evo.widget.SpeedTextView
import com.live.evo.widget.sloading.LoadingStyle
import com.live.evo.widget.sloading.SLoadingView
import com.youth.banner.Banner
import com.youth.banner.listener.OnPageChangeListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.slf4j.LoggerFactory
import java.util.Date
import java.util.regex.Pattern

/**
 * Player de catch-up (programas passados). Recebe os parâmetros por um "holder" estático ([Source]) porque
 * [CatchUpPlayInfo] e a função de "próximo programa" não são Parcelable.
 * Aberto com startActivityForResult(requestCode [REQUEST_CODE]=3); o resultado `pos + 1` pede a
 * [LiveNewActivity] que troque para o canal `pos` (vindo do popup de agendamento).
 *
 * Original: com/live/evo/activity/CatchUpPlayerActivity.java
 */
class CatchUpPlayerActivity : FontBaseActivity() {

    private val logger = LoggerFactory.getLogger(CatchUpPlayerActivity::class.java)
    private var mPlayType: String = "normal"
    private var mPlayInfo: CatchUpPlayInfo? = null
    private var mNextPlayInfoFunc: Utils.Func1<Flow<CatchUpPlayInfo>, CatchUpPlayInfo>? = null
    private var mChannelId: String? = null
    private val mPlayerType = -1

    private var mVideoView: LiveCatchUpVideoView? = null
    private var mMediaController: CatchUpMediaController? = null
    private var mLoadingView: SLoadingView? = null
    private var mBgFinishedIv: ImageView? = null
    private var mNoticeView: SpeedTextView? = null
    private var mBanner: Banner<*, *>? = null
    private var mAdIv: ImageView? = null
    private var mAdRl: RelativeLayout? = null
    private var mAdTv: TextView? = null
    private var mConfirmDialog: ConfirmDialog? = null
    private var noticeAlertDialog: NoticeAlertDialog? = null
    private var subscribeDialog: SubscribePopup? = null

    /** Código do diálogo atual: 1 sair, 2 erro de play, 3 fim, 4 erro de prepare. Original: mCurrentCC */
    private var mCurrentCC = 0
    private var mLastStopPosition = 0
    private var mInitFromOnCreate = false
    private var mShowBanner = false
    private var curBannerItem = 0
    private var browseCount = 0; private var clickCount = 0; private var browseDuration = 0L

    // métricas de buffering/seek
    private var isPrepare = false; private var hasFirstPrepareBuffering = false
    private var hasSeeking = false; private var isManualSeeking = false; private var isBufferingBySeek = false
    private var seekCompleteTime = 0L; private var seekFirstBuffingTime = 0L
    private var prepareTime = 0L; private var prepareFirstBufferingTime = 0L
    private var startBufferingPosition = -1L
    private var bufferingStartTime = 0L; private var bufferingEndTime = 0L
    private var bufferingTime = 0L; private var bufferingTotalTime = 0L; private var bufferingCount = 0

    /**
     * Inferência: `native`. Provavelmente: setContentView(layout do catch-up), [readArguments] (Y), [initViews] (x0)
     * e início da reprodução (getAndPlay).
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TODO("nativo/não decompilado: CatchUpPlayerActivity.onCreate — provável readArguments() + initViews()")
    }

    /** Lê e limpa o holder estático; restaura posição/playInfo do bundle. Original: Y(Bundle) */
    protected fun readArguments(savedInstanceState: Bundle?) {
        mPlayType = Source.catchUpType ?: "normal"
        mPlayInfo = Source.catchUpPlayInfo
        mNextPlayInfoFunc = Source.nextPlayInfoFunc
        mChannelId = Source.channelId
        Source.catchUpPlayInfo = null; Source.nextPlayInfoFunc = null; Source.channelId = null
        if (savedInstanceState != null) {
            mLastStopPosition = savedInstanceState.getInt("key_last_position", 0)
            val json = savedInstanceState.getString("key_play_info", "")
            try {
                if (mPlayInfo == null && !json.isNullOrEmpty()) mPlayInfo = GsonFactory.gson().fromJson(json, object : TypeToken<CatchUpPlayInfo>() {}.type)
            } catch (_: Exception) { }
        }
        mInitFromOnCreate = true
    }

    /** Liga views, media controller, anúncio, cores do loading (SkinConfig "cor1,cor2"), listeners. Original: x0() */
    private fun initViews() {
        mVideoView = findViewById(R.id.catchupplayera_vv_video_view)
        mVideoView?.setPlayInfoProvider(playInfoFlow())
        mBgFinishedIv = findViewById(R.id.catchupplayera_iv_finished)
        mNoticeView = findViewById(R.id.catchupplayera_iv_notice)
        mBanner = findViewById(R.id.catchupplayera_bn_banner)
        mMediaController = CatchUpMediaController(this).also { mVideoView?.setMediaController(it) }
        mLoadingView = mVideoView?.findViewById(R.id.loading_icon)
        mAdIv = findViewById(R.id.catchupplayera_ad_iv)
        mAdRl = findViewById(R.id.catchupplayera_ad_rl)
        mAdTv = findViewById(R.id.catchupplayera_ad_tv)
        CatchUpAdManager.get().bind(mAdIv, mAdRl, mAdTv, this)
        mLoadingView?.setLoadingBuilder(LoadingStyle.TRANSLATE_CIRCLE)
        val colors = SkinConfig.get().loadingViewColor()
        if (!colors.isNullOrEmpty()) {
            val parts = colors.split(",").dropLastWhile { it.isEmpty() }
            val hex = Pattern.compile("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})$")
            if (parts.size == 2) {
                if (parts[0].isNotEmpty() && hex.matcher(parts[0]).matches()) mLoadingView?.setColorFilter(Color.parseColor(parts[0]))
                if (parts[1].isNotEmpty() && hex.matcher(parts[1]).matches()) mLoadingView?.setColorExtra(Color.parseColor(parts[1]))
            } else if (parts.size == 1 && parts[0].isNotEmpty() && hex.matcher(parts[0]).matches()) {
                mLoadingView?.setColorFilter(Color.parseColor(parts[0]))
            }
        }
        mVideoView?.setPlayStatusListener(object : LiveCatchUpVideoView.PlayStatusListener {
            override fun onFocus(focus: Boolean) {}
            override fun onPlayStateChanged(playing: Boolean) {
                CatchUpAdManager.get().setVisible(!playing)
                if (mShowBanner) toggleBanner(if (playing) 1 else 0)
            }
        })
        mConfirmDialog = ConfirmDialog.Builder(this).cancelable(false).build()
        mVideoView?.setPlayEventListener(playEventListener)
        mBanner?.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageSelected(position: Int) { curBannerItem = position }
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
        })
    }

    /** Eventos do player: métricas de buffering (701/702), erros, fim e prepared. Original: CatchUpPlayerActivity$h */
    private val playEventListener = object : com.live.evo.widget.CatchUpVideoView.PlayEventListener {
        override fun onInfo(what: Int, extra: Int, position: Long): Boolean {
            if (what == 701) {
                if (isPrepare && !hasFirstPrepareBuffering) {
                    hasFirstPrepareBuffering = true
                    prepareFirstBufferingTime = SystemClock.elapsedRealtime() - prepareTime
                }
                if (hasSeeking) { hasSeeking = false; seekFirstBuffingTime = SystemClock.elapsedRealtime() - seekCompleteTime }
                startBufferingPosition = position
                bufferingStartTime = SystemClock.elapsedRealtime()
                isBufferingBySeek = isManualSeeking
                bufferingCount++
            } else if (what == 702) {
                bufferingEndTime = SystemClock.elapsedRealtime()
                bufferingTime = bufferingEndTime - bufferingStartTime
                bufferingTotalTime += bufferingTime
            }
            return false
        }

        /** Erro de reprodução: mensagem com "%d - %d", device id (of.a.k()), canal e horário (MM/dd-HH:mm). */
        override fun onError(what: Int, extra: Int, info: String?): Boolean {
            mBgFinishedIv?.visibility = android.view.View.GONE
            val fmt = DateFormatFactory.get("MM/dd-HH:mm")
            val head = "\n    ${CommonUtils.string(R.string.catchup_play_error)}\n    ${CommonUtils.string(R.string.error_message)}${String.format("%d - %d", what, extra)}\n    \n    ".trimIndent()
            val time = if (mPlayInfo == null) "null" else fmt.format(Date(mPlayInfo?.startTime ?: 0L))
            val tail = String.format("%s: %s[%s] %s", AppParams.deviceId(), mPlayInfo?.channelName, time, info)
            showConfirm(2, head + tail, CommonUtils.string(R.string.retry), CommonUtils.string(R.string.cancel),
                { replay(); mBgFinishedIv?.visibility = android.view.View.GONE }, { close() }, true, true, false)
            return true
        }

        override fun onPrepareError(t: Throwable) {
            mBgFinishedIv?.visibility = android.view.View.GONE
            val msg = "\n${CommonUtils.string(R.string.catchup_prepare_error)}\n${CommonUtils.string(R.string.error_message)}${t.message}".trimIndent()
            showConfirm(4, msg, CommonUtils.string(R.string.retry), CommonUtils.string(R.string.catchupcancel_ok),
                { replay() }, { close() }, false, true, false)
        }

        override fun onCompletion() = onPlayFinished()

        override fun onPrepared() {
            if (!isPrepare) prepareTime = SystemClock.elapsedRealtime()
            isPrepare = true
            mBgFinishedIv?.visibility = android.view.View.GONE
            mMediaController?.setPlayInfo(mPlayInfo)
        }
    }

    /** Fim do programa: "Continue"/"OK". Original: g0() */
    private fun onPlayFinished() {
        mBgFinishedIv?.visibility = android.view.View.VISIBLE
        showConfirm(3, CommonUtils.string(R.string.catchup_finished_hint), CommonUtils.string(R.string.tv_continue),
            CommonUtils.string(R.string.ok), { /* h0: vazio */ }, { mCurrentCC = 0; mBgFinishedIv?.visibility = android.view.View.GONE; close() },
            false, true, false)
    }

    /** Mostra o ConfirmDialog (um por vez; nunca sobre o diálogo de fim, cc 3). Original: y0(...) */
    fun showConfirm(cc: Int, message: String, okText: String, cancelText: String, ok: Runnable, cancel: Runnable,
                    showOk: Boolean, showCancel: Boolean, cancelable: Boolean) {
        if (mConfirmDialog?.isShowing == true || isFinishing || isDestroyed || mCurrentCC == 3) return
        mCurrentCC = cc
        mConfirmDialog?.show(message, okText, cancelText, ok, cancel, showOk, showCancel, cancelable)
    }

    /** Original: A0() */
    fun replay() { mVideoView?.getAndPlay() }

    /** Para o player e finaliza. Original: L() */
    fun close() { mVideoView?.stopPlayback(); finish() }

    /** Original: M() + J() (identidade) */
    private fun playInfoFlow(): Flow<CatchUpPlayInfo?> = flowOf(mPlayInfo)

    /** Original: z0(int) — 0 mostra o banner (inicia contagem), 1 esconde. */
    fun toggleBanner(what: Int) {
        val banner = mBanner ?: return
        if (what == 0) {
            if (banner.visibility != android.view.View.VISIBLE) {
                browseCount = 0; clickCount = 0; browseDuration = 0L
                browseCount++
                browseDuration = DateUtils.now()
                banner.visibility = android.view.View.VISIBLE
                banner.start()
            }
        } else if (what == 1 && banner.visibility == android.view.View.VISIBLE) {
            banner.visibility = android.view.View.GONE
            banner.start()
            browseDuration = ServerClock.get().now() - browseDuration
        }
    }

    /** Back: confirmação "sair do catch-up". Original: onBackPressed() / d0() */
    override fun onBackPressed() {
        showConfirm(1, CommonUtils.string(R.string.catchup_exit_hint), CommonUtils.string(R.string.catchupexit_ok),
            CommonUtils.string(R.string.cancel),
            { if (mShowBanner) toggleBanner(1); CatchUpAdManager.get().release(); close() }, { }, true, true, true)
    }

    /**
     * Teclas: BACK/ESC → onBackPressed; OK com banner focado conta clique; DOWN tira foco do banner;
     * outras escondem o banner; tudo é repassado ao LiveCatchUpVideoView. Original: onKeyDown()
     */
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        val banner = mBanner
        when (keyCode) {
            KeyEvent.KEYCODE_BACK -> if (event.repeatCount == 0) { onBackPressed(); return true }
            KeyEvent.KEYCODE_DPAD_CENTER, KeyEvent.KEYCODE_ENTER ->
                if (event.repeatCount == 0 && !isPlaying() && banner?.visibility == android.view.View.VISIBLE && banner.isFocused) { clickCount++; return true }
            KeyEvent.KEYCODE_ESCAPE -> if (event.repeatCount == 0) { onBackPressed(); return true }
            KeyEvent.KEYCODE_DPAD_UP -> Unit
            KeyEvent.KEYCODE_DPAD_DOWN -> if (event.repeatCount == 0 && banner?.visibility == android.view.View.VISIBLE) { banner.clearFocus(); banner.isFocusable = false }
            else -> if (banner?.visibility == android.view.View.VISIBLE) { banner.visibility = android.view.View.GONE; banner.stop() }
        }
        return mVideoView?.onKeyDown(keyCode, event) ?: super.onKeyDown(keyCode, event)
    }

    /** Original: b0() */
    fun isPlaying(): Boolean = try { mVideoView?.isPlaying == true } catch (_: Throwable) { false }

    /**
     * Agendamento a partir do EPG (nf.m): busca o programa seguinte no SDK (`G(epgId, start+1)`) e mostra o popup.
     * Original: onEvent(nf.m) + corrotina e
     */
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onEvent(event: SubscribeTimeEvent) {
        EventBus.getDefault().removeStickyEvent(event)
        if (subscribeDialog == null) subscribeDialog = SubscribePopup(this, subscribeListener(false))
        val channel = InteractionUtils.getChannelStream(event.key) ?: return
        CoroutineScope(Dispatchers.IO).launch {
            val programme = InteractionUtils.getProgramme(channel.epgId, event.start + 1) ?: return@launch
            val bean = EpgRepository.toSubscribeBean(0, EpgRepository.toEpgBean(programme), channel)
            withContext(Dispatchers.Main) { subscribeDialog?.setData(bean); subscribeDialog?.show() }
        }
    }

    /** Lembrete de agendamento. Original: onSubscribe(b5.k) */
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onSubscribe(event: SubscribeRemindEvent) {
        EventBus.getDefault().removeStickyEvent(event)
        if (subscribeDialog == null) subscribeDialog = SubscribePopup(this, subscribeListener(true))
        subscribeDialog?.setData(event.subscribe)
        subscribeDialog?.show()
    }

    /** Original: CatchUpPlayerActivity$d / $f — "assistir" devolve pos+1 ao LiveNewActivity. */
    private fun subscribeListener(hideBanner: Boolean) = object : SubscribePopup.Listener {
        override fun onCancel() = SubscribeManager.cancelCurrent()
        override fun onWatch(pos: Int) {
            if (hideBanner && mShowBanner) toggleBanner(1)
            setResult(pos + 1)
            close()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onNotice(item: NoticeEvent) = ensureNoticeDialog()

    /** Original: K() */
    private fun ensureNoticeDialog() { if (noticeAlertDialog == null) noticeAlertDialog = NoticeAlertDialog(this) }

    /** Original: j0() — guarda posição atual (ou -1). */
    private fun saveStopPosition() {
        try {
            mLastStopPosition = if (mVideoView?.isPlaying == true) mVideoView!!.currentPosition else -1
        } catch (_: Exception) { }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saveStopPosition()
        outState.putInt("key_last_position", mLastStopPosition)
    }

    override fun onPause() { super.onPause(); logger.info("onPause") }

    override fun onStart() {
        super.onStart()
        if (mInitFromOnCreate) mInitFromOnCreate = false else mVideoView?.start()
        ensureNoticeDialog()
    }

    override fun onStop() {
        super.onStop()
        saveStopPosition()
        mVideoView?.stopPlayback()
        noticeAlertDialog?.takeIf { it.isShowing() }?.dismiss()
    }

    /**
     * Holder estático de parâmetros. Original: CatchUpPlayerActivity$a.
     * `catchUpType` também diz a [LiveNewActivity.returnFromCatchUp] de onde o catch-up foi aberto
     * ("channel", "bigEpg", "subjectMatch", "normal").
     */
    object Source {
        var catchUpType: String? = null
        var catchUpPlayInfo: CatchUpPlayInfo? = null
        var nextPlayInfoFunc: Utils.Func1<Flow<CatchUpPlayInfo>, CatchUpPlayInfo>? = null
        var channelId: String? = null
        fun current(): String? = catchUpType
    }

    companion object {
        const val REQUEST_CODE = 3

        /** Original: CatchUpPlayerActivity$Companion.a(...) */
        fun start(context: Context, channelId: String?, catchUpType: String, playInfo: CatchUpPlayInfo?,
                  nextPlayInfoFunc: Utils.Func1<Flow<CatchUpPlayInfo>, CatchUpPlayInfo>?) {
            val intent = Intent(context, CatchUpPlayerActivity::class.java)
            Source.catchUpType = catchUpType
            Source.catchUpPlayInfo = playInfo
            Source.nextPlayInfoFunc = nextPlayInfoFunc
            Source.channelId = channelId
            (context as Activity).startActivityForResult(intent, REQUEST_CODE)
        }
    }
}
