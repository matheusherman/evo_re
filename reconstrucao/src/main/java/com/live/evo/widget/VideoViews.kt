package com.live.evo.widget

import android.app.Activity
import android.content.Context
import android.net.TrafficStats
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.MediaController
import android.widget.TextView
import com.live.evo.MyApplication
import com.live.evo.R
import com.live.evo.util.CommonUtils
import kotlinx.coroutines.flow.Flow
import org.slf4j.LoggerFactory
import tv.danmaku.ijk.media.player.IMediaPlayer

/**
 * Controlador de mídia (barra de progresso + tempos + play/pause) ancorado em um PopupWindow.
 * Contrato da interface: show/hide/isShowing/setAnchorView/setEnabled/setMediaPlayer/setTrackingProgress + callbacks a/b/c/d.
 * Original: com/live/evo/widget/ijkmedia/a.java (interface IMediaController)
 */
interface IMediaController {
    fun a(); fun b(): Boolean; fun c(); fun d()
    fun hide(); fun isShowing(): Boolean; fun setAnchorView(view: View?); fun setEnabled(enabled: Boolean)
    fun setMediaPlayer(player: MediaController.MediaPlayerControl?); fun setTrackingProgress(progress: Int); fun show()
}

/**
 * Implementação visual do [IMediaController]: SeekBar, textos de posição/duração, botão play/pause e
 * atualização via Handler. Chama "MediaController already removed" quando a janela some.
 * Original: com/live/evo/widget/ijkmedia/b.java
 */
open class IjkMediaController(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs), IMediaController {
    override fun a() { TODO("não detalhado: ver ijkmedia/b.java (498 linhas, layout puro)") }
    override fun b(): Boolean = TODO("ijkmedia/b.b()")
    override fun c() { TODO("ijkmedia/b.c()") }
    override fun d() { TODO("ijkmedia/b.d()") }
    override fun hide() { TODO("ijkmedia/b.hide()") }
    override fun isShowing(): Boolean = TODO("ijkmedia/b.isShowing()")
    override fun setAnchorView(view: View?) { TODO("ijkmedia/b.setAnchorView()") }
    override fun setMediaPlayer(player: MediaController.MediaPlayerControl?) { TODO("ijkmedia/b.setMediaPlayer()") }
    override fun setTrackingProgress(progress: Int) { TODO("ijkmedia/b.setTrackingProgress()") }
    override fun show() { TODO("ijkmedia/b.show()") }
}

/**
 * Base do vídeo de catch-up (FrameLayout com PlayerView + loading + debug + MediaController).
 * `getAndPlay()` coleta o Flow de [CatchUpPlayInfo] (x4.c) e prepara o player; em erro mostra
 * "prepare error,<msg>" ou "no catchup play info provider!". Listeners ijk: onInfo (lag/bandwidth), onError,
 * onCompletion, onPrepared. `MRT_RETRY_LIMIT` = limite de retentativas. Seek por forward/rewind via teclas.
 *
 * Original: com/live/evo/widget/k.java (nome real: CatchUpVideoView)
 */
open class CatchUpVideoView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    FrameLayout(context, attrs), MediaController.MediaPlayerControl {
    protected val logger = LoggerFactory.getLogger(CatchUpVideoView::class.java)
    protected var mContext: Activity? = null
    protected var mMRT_RETRY_LIMIT = 3  // TODO("valor inicial não verificado")
    private var mediaController: IMediaController? = null
    private var playEventListener: PlayEventListener? = null

    /** Eventos de reprodução. Original: k$b */
    interface PlayEventListener {
        fun a(); fun b(player: IMediaPlayer?, what: Int, extra: Int, msg: String): Boolean; fun c(t: Throwable)
    }

    open fun getConnectingMsg(): String = "Connecting..."
    open fun getLoadingMsg(): String = "Loading..."
    protected open fun getLayoutId(): Int = TODO("subclasses fornecem")
    protected open fun getCatchUpPlayInfo(): Flow<Any>? = null
    protected open fun getUidRxBytes(): Long = 0L
    protected open fun showMessage(context: Context, message: String?) {}
    fun setMediaController(c: IMediaController) { mediaController = c }
    fun setPlayEventListener(l: PlayEventListener?) { playEventListener = l }

    /** Coleta `getCatchUpPlayInfo()` e prepara. Original: getAndPlay() (corrotina `CatchUpVideoView$getAndPlay$1`) */
    fun getAndPlay() { TODO("coletar Flow<CatchUpPlayInfo> e chamar PlayerView.setVideoPath — ver widget/k.getAndPlay") }

    // MediaPlayerControl (delegam ao PlayerView interno)
    override fun start() { TODO("PlayerView.start()") }
    override fun pause() { TODO("PlayerView.pause()") }
    override fun getDuration(): Int = TODO("PlayerView.getDuration()")
    override fun getCurrentPosition(): Int = TODO("PlayerView.getCurrentPosition()")
    override fun seekTo(pos: Int) { TODO("PlayerView.seekTo(pos)") }
    override fun isPlaying(): Boolean = TODO("PlayerView.isPlaying()")
    override fun getBufferPercentage(): Int = TODO("PlayerView.getBufferPercentage()")
    override fun canPause(): Boolean = true
    override fun canSeekBackward(): Boolean = true
    override fun canSeekForward(): Boolean = true
    override fun getAudioSessionId(): Int = 0
}

/**
 * Vídeo da live em modo catch-up: teclas ESQ/DIR (21/22) → `a(true)`; OK/ENTER (23/66) → `a(!isPlaying)`;
 * CIMA (19) com player parado → `b(true)` e consome. Mensagens vão para ToastHelper; bytes vêm de
 * [TrafficStats.getUidRxBytes] (fallback total RX). O flow de PlayInfo é injetado por [setPlayInfoProvider].
 *
 * Original: com/live/evo/widget/LiveCatchUpVideoView.java
 */
class LiveCatchUpVideoView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : CatchUpVideoView(context, attrs) {
    private var playInfoProvider: Flow<Any>? = null
    private var keyListener: PlayStatusListener? = null
    private val applicationInfo = MyApplication.get().applicationInfo

    interface PlayStatusListener { fun a(play: Boolean); fun b(focus: Boolean) }

    fun setPlayInfoProvider(flow: Flow<Any>) { playInfoProvider = flow }
    fun setPlayStatusListener(l: PlayStatusListener?) { keyListener = l }
    fun setMrtRetryLimit(limit: Int) { mMRT_RETRY_LIMIT = limit }
    override fun getCatchUpPlayInfo(): Flow<Any>? = playInfoProvider
    override fun getLayoutId(): Int = R.layout.live_catch_up_vv
    override fun getConnectingMsg(): String = CommonUtils.string(2131951929)

    override fun getUidRxBytes(): Long = try {
        val b = TrafficStats.getUidRxBytes(applicationInfo.uid)
        if (b == -1L) Math.max(0.0, TrafficStats.getTotalRxBytes().toDouble()).toLong() else b
    } catch (e: Exception) { logger.error("getUidRxBytes", e); 0L }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode != 19) {
            if (keyCode != 66) {
                when (keyCode) {
                    21, 22 -> if (event.repeatCount == 0) keyListener?.a(true)
                    23 -> if (event.repeatCount == 0) keyListener?.a(!isPlaying)
                }
            } else if (event.repeatCount == 0) keyListener?.a(!isPlaying)
        } else if (!isPlaying) {
            keyListener?.b(true)
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
