package com.live.evo.widget

import android.app.Activity
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Message
import android.view.LayoutInflater
import android.view.MotionEvent
import android.widget.ImageButton
import android.widget.PopupWindow
import android.widget.SeekBar
import android.os.Looper
import com.foxivid.baselib.config.InteractionUtils
import com.foxivid.baselib.model.meta.EPGProgramme
import com.foxivid.baselib.player.PlayerView
import com.live.evo.catchup.CatchUpPlayInfo
import com.live.evo.util.DurationFormatter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
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
open class IjkMediaController : FrameLayout, IMediaController {
    private val logger = LoggerFactory.getLogger(IjkMediaController::class.java)
    private var player: MediaController.MediaPlayerControl? = null          // f7577b
    private var mContext: Context? = null                                    // f7578c
    private var popup: PopupWindow? = null                                   // f7579d
    private var animationStyle = 0                                           // f7580e
    private var anchor: View? = null                                         // f7581f
    private var root: View? = null                                           // f7582g
    private var seekBar: SeekBar? = null                                     // f7583h
    private var totalTime: TextView? = null                                  // f7584i
    private var currentTime: TextView? = null                                // f7585j
    private var fileNameView: TextView? = null                               // f7586k
    private var infoView: TextView? = null                                   // f7587l
    private var fileName: String? = null                                     // f7588m
    private var duration = 0L                                                // f7589n
    private var showing = false                                              // f7590o
    private var dragging = false                                             // f7591p
    private var useLayoutAsRoot = false                                      // f7592q: true no construtor com AttributeSet (inflado por XML)
    private var playPause: ImageButton? = null                               // f7593r

    /** Mensagens: 1 = esconder; 2 = atualizar progresso (a cada ~1 s). Original: classe interna `a` (Handler) */
    @SuppressLint("HandlerLeak")
    private val handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                1 -> hide()
                2 -> {
                    val pos = updateProgress()
                    if (dragging || !showing) return
                    sendMessageDelayed(obtainMessage(2), 1000 - (pos % 1000))
                    updatePlayPauseIcon()
                }
            }
        }
    }

    /** Clique no play/pause: alterna e reagenda auto-ocultação em 3 s. Original: ViewOnClickListenerC0117b */
    private val playPauseClick = OnClickListener { togglePlayPause(); showFor(3000) }

    /** Original: classe interna `c` (SeekBar.OnSeekBarChangeListener) */
    private val seekListener = object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
            if (fromUser || dragging) {
                if (duration <= 0) duration = player!!.duration.toLong()
                val text = DurationFormatter.format(duration * progress.toLong() / 1000)
                infoView?.text = text
                currentTime?.text = text
            }
        }
        override fun onStartTrackingTouch(seekBar: SeekBar) {
            dragging = true
            a()   // mostra sem auto-ocultar
            handler.removeMessages(2)
            infoView?.let { it.text = ""; it.visibility = View.VISIBLE }
        }
        override fun onStopTrackingTouch(seekBar: SeekBar) {
            val target = player!!.duration.toLong() * seekBar.progress.toLong() / 1000
            logger.debug("onStopTrackingTouch seekTo[{}] bar pos[{}] duration[{}]", target, seekBar.progress, player!!.duration)
            player!!.seekTo(target.toInt())
            // `b.k(this)` é um acessor sintético que devolve null: o OnSeekListener (a.d) nunca é notificado.
            infoView?.let { it.text = ""; it.visibility = View.GONE }
            showFor(3000)
            handler.removeMessages(2)
            dragging = false
            handler.sendEmptyMessageDelayed(2, 1000L)
        }
    }

    /** Construtor de inflação XML: o próprio FrameLayout é o controle (sem PopupWindow). */
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        root = this
        useLayoutAsRoot = true
        mContext = context
    }

    /** Construtor programático: usa PopupWindow ([initPopup]). */
    constructor(context: Context) : super(context) {
        if (!useLayoutAsRoot) { mContext = context; initPopup() }
    }

    /** Ícone play/pause conforme o estado do player. Original: A() */
    fun updatePlayPauseIcon() {
        if (root == null || playPause == null) return
        if (player!!.isPlaying) playPause!!.setImageDrawable(getPauseIconDrawable()) else playPause!!.setImageDrawable(getPlayIconDrawable())
    }

    /** Original: s() */
    fun togglePlayPause() {
        if (player!!.isPlaying) player!!.pause() else player!!.start()
        updatePlayPauseIcon()
    }

    private fun initPopup() {   // Original: v()
        popup = PopupWindow(mContext).apply { isFocusable = false; setBackgroundDrawable(null); isOutsideTouchable = true }
        animationStyle = android.R.style.Animation
    }

    /** Atualiza barra/tempos e devolve a posição atual (ms). Original: x() */
    fun updateProgress(): Long {
        val p = player ?: return 0L
        if (dragging) return seekBar!!.progress.toLong()
        val position = p.currentPosition.toLong()
        val dur = p.duration.toLong()
        seekBar?.let {
            if (dur > 0) it.progress = (1000 * position / dur).toInt()
            it.secondaryProgress = p.bufferPercentage * 10
        }
        duration = dur
        totalTime?.text = DurationFormatter.format(dur)
        currentTime?.text = DurationFormatter.format(position)
        return position
    }

    /** Original: b() — está arrastando a barra? */
    override fun b(): Boolean = dragging
    /** Termina o arraste (como soltar a barra). Original: c() */
    override fun c() { seekListener.onStopTrackingTouch(seekBar!!) }
    /** Inicia o arraste (como tocar a barra). Original: d() */
    override fun d() { seekListener.onStartTrackingTouch(seekBar!!) }
    /** Mostra sem auto-ocultar (timeout = Int.MAX_VALUE). Original: a() */
    override fun a() { showFor(Int.MAX_VALUE) }

    override fun hide() {
        if (anchor != null && showing) {
            try {
                handler.removeMessages(2)
                if (useLayoutAsRoot) visibility = View.GONE else popup!!.dismiss()
            } catch (e: IllegalArgumentException) {
                logger.debug("MediaController already removed", e)
            }
            showing = false
        }
    }

    override fun isShowing(): Boolean = showing

    override fun onTouchEvent(event: MotionEvent): Boolean { showFor(3000); return true }
    override fun onTrackballEvent(event: MotionEvent): Boolean { showFor(3000); return false }

    override fun setAnchorView(view: View?) {
        anchor = view
        if (!useLayoutAsRoot) {
            removeAllViews()
            root = makeControllerView()
            popup!!.contentView = root
            popup!!.width = -1
            popup!!.height = -1
        }
        initControllerView(root!!)
    }

    fun setAnimationStyle(style: Int) { animationStyle = style }

    override fun setEnabled(enabled: Boolean) {
        playPause?.isEnabled = enabled
        seekBar?.isEnabled = enabled
        super.setEnabled(enabled)
    }

    fun setFileName(name: String?) { fileName = name; fileNameView?.text = name }
    fun setInfoView(view: TextView?) { infoView = view }

    override fun setMediaPlayer(player: MediaController.MediaPlayerControl?) { this.player = player; updatePlayPauseIcon() }
    override fun setTrackingProgress(progress: Int) { seekBar!!.progress = progress }
    override fun show() { showFor(3000) }

    protected open fun makeControllerView(): View =
        (mContext!!.getSystemService("layout_inflater") as LayoutInflater).inflate(getLayoutId(), this)

    /** Layout system-ui + tipo de janela HELP (1004) do popup via reflexão. Original: y() */
    @TargetApi(16)
    fun applyWindowLayoutType() {
        try {
            anchor!!.systemUiVisibility = 512
            PopupWindow::class.java.getMethod("setWindowLayoutType", Int::class.javaPrimitiveType).invoke(popup, 1004)   // PointerIconCompat.TYPE_HELP
        } catch (e: Exception) { logger.error("setWindowLayoutType", e) }
    }

    /** Mostra o controle (se ancorado e com janela) e agenda ocultação em [timeout] ms (0 = não agenda). Original: z(int) */
    fun showFor(timeout: Int) {
        if (!showing && anchor != null && anchor!!.windowToken != null) {
            playPause?.requestFocus()
            if (useLayoutAsRoot) {
                visibility = View.VISIBLE
            } else {
                val loc = IntArray(2)
                anchor!!.getLocationOnScreen(loc)
                val rect = Rect(loc[0], loc[1], loc[0] + anchor!!.width, loc[1] + anchor!!.height)
                popup!!.animationStyle = animationStyle
                applyWindowLayoutType()
                popup!!.showAtLocation(anchor, 51, rect.left, rect.bottom)   // 51 = TOP|LEFT
            }
            showing = true
        }
        updatePlayPauseIcon()
        handler.sendEmptyMessage(2)
        if (timeout != 0) {
            handler.removeMessages(1)
            handler.sendMessageDelayed(handler.obtainMessage(1), timeout.toLong())
        }
    }

    protected open fun getLayoutId(): Int = R.layout.view_pure_player_mediacontroller
    protected open fun getPauseIconDrawable(): Drawable =
        context.resources.getDrawable(resources.getIdentifier("mediacontroller_pause", "drawable", mContext!!.packageName))
    protected open fun getPauseIconId(): Int = resources.getIdentifier("mediacontroller_pause", "drawable", mContext!!.packageName)
    protected open fun getPlayIconDrawable(): Drawable =
        context.resources.getDrawable(resources.getIdentifier("mediacontroller_play", "drawable", mContext!!.packageName))
    protected open fun getPlayIconId(): Int = resources.getIdentifier("mediacontroller_play", "drawable", mContext!!.packageName)

    public override fun onFinishInflate() {
        super.onFinishInflate()
        root?.let { initControllerView(it) }
    }

    /** Liga os widgets por id (`mediacontroller_*`, resolvidos por nome no pacote). Original: u(View) */
    protected open fun initControllerView(view: View) {
        val pkg = mContext!!.packageName
        playPause = view.findViewById(resources.getIdentifier("mediacontroller_play_pause", "id", pkg))
        playPause?.let { it.requestFocus(); it.setOnClickListener(playPauseClick) }
        seekBar = view.findViewById(resources.getIdentifier("mediacontroller_seekbar", "id", pkg))
        seekBar?.let { it.setOnSeekBarChangeListener(seekListener); it.max = 1000 }
        totalTime = view.findViewById(resources.getIdentifier("mediacontroller_time_total", "id", pkg))
        currentTime = view.findViewById(resources.getIdentifier("mediacontroller_time_current", "id", pkg))
        fileNameView = view.findViewById(resources.getIdentifier("mediacontroller_file_name", "id", pkg))
        fileNameView?.text = fileName
    }

    // Setters de listeners (a.InterfaceC0116a / b / c / d / e): corpos vazios no original.
    fun setOnHiddenListener(l: Any?) {}
    fun setOnPauseListener(l: Any?) {}
    fun setOnResumeListener(l: Any?) {}
    fun setOnSeekListener(l: Any?) {}
    fun setOnShownListener(l: Any?) {}
}

/**
 * Base do vídeo de catch-up (FrameLayout com PlayerView + loading + debug + MediaController).
 * `getAndPlay()` coleta o Flow de [CatchUpPlayInfo] (x4.c) e prepara o player; em erro mostra
 * "prepare error,<msg>" ou "no catchup play info provider!". Listeners ijk: onInfo (lag/bandwidth), onError,
 * onCompletion, onPrepared. `MRT_RETRY_LIMIT` = limite de retentativas (100). Seek por forward/rewind via teclas.
 *
 * Original: com/live/evo/widget/k.java (nome real: CatchUpVideoView)
 */
open class CatchUpVideoView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    FrameLayout(context, attrs), MediaController.MediaPlayerControl {
    protected val logger = LoggerFactory.getLogger(CatchUpVideoView::class.java)
    protected var mContext: Activity? = null
    protected var mMRT_RETRY_LIMIT = 100
    private var mVideoView: PlayerView? = null
    private var mLoadingIcon: View? = null
    private var mLoadingHint: ViewGroup? = null
    private var mLoadingMsg: TextView? = null
    private var mLoadingSpeed: TextView? = null
    private var mDebugInfo: TextView? = null
    private var mediaController: IMediaController? = null
    private var playEventListener: PlayEventListener? = null
    private var mIsDebugViewVisible = false
    private var mIsLoadingViewVisible = false
    private var mInLowLevelBuffering = false
    private var mOnLowLevelBufferingEndAction: Runnable? = null
    private var mForwardRewindPosition = 0L

    /** Mensagens 701/702 (início/fim de buffering do ijk) tratadas na main thread. Original: mHandler (Handler.Callback `f`/z) */
    private val mHandler = Handler(Looper.getMainLooper()) { msg ->
        when (msg.what) {
            701 -> onLowLevelBufferingStart()
            702 -> onLowLevelBufferingEnd()
        }
        false
    }

    private val mOnPreparedListener = IMediaPlayer.OnPreparedListener { playEventListener?.onPrepared(it) }
    private val mOnCompletionListener = IMediaPlayer.OnCompletionListener { playEventListener?.onCompletion(it) }
    private val mOnErrorListener = IMediaPlayer.OnErrorListener { mp, what, extra -> playEventListener?.b(mp, what, extra, "") ?: true }
    private val mOnSeekCompleteListener = IMediaPlayer.OnSeekCompleteListener { /* E(): vazio no original */ }

    /** Original: C(k, IMediaPlayer, what, extra, info) — 700/703 só logam; 701/702 vão para o handler. */
    private val mOnInfoListener = IMediaPlayer.OnInfoListener { mp, what, extra, _ ->
        if (what != 3) {
            when (what) {
                700 -> logger.debug("OnInfoListener MEDIA_INFO_VIDEO_TRACK_LAGGING [{}]", extra)
                701, 702 -> mHandler.sendEmptyMessage(what)
                703 -> logger.debug("OnInfoListener MEDIA_INFO_NETWORK_BANDWIDTH [{}]", extra)
                else -> logger.debug("onPlayerInfo: what[{}] extra[{}]", what, extra)
            }
        }
        playEventListener?.a(mp, what, extra) ?: true
    }

    /** Eventos de reprodução. Original: k$b */
    interface PlayEventListener {
        /** onInfo (a) */ fun a(player: IMediaPlayer?, what: Int, extra: Int): Boolean
        /** onError (b) */ fun b(player: IMediaPlayer?, what: Int, extra: Int, msg: String): Boolean
        /** erro de preparação (c) */ fun c(t: Throwable)
        fun onCompletion(player: IMediaPlayer?)
        fun onPrepared(player: IMediaPlayer?)
    }

    init {
        // Original: v(Context) — exige Activity; infla o layout e liga listeners do PlayerView
        mContext = context as Activity
        View.inflate(context, getLayoutId(), this)
        isFocusable = true
        isFocusableInTouchMode = true
        mVideoView = findViewById(R.id.video_view)
        mLoadingIcon = findViewById(R.id.loading_icon)
        mLoadingHint = findViewById(R.id.loading_hint)
        mLoadingMsg = findViewById(R.id.loading_msg)
        mLoadingSpeed = findViewById(R.id.loading_speed)
        mDebugInfo = findViewById(R.id.debug_info)
        mVideoView?.apply {
            setOnPreparedListener(mOnPreparedListener)
            setOnInfoListener(mOnInfoListener)
            setOnCompletionListener(mOnCompletionListener)
            setOnErrorListener(mOnErrorListener)
            setOnSeekCompleteListener(mOnSeekCompleteListener)
            setLoadingListener { loading, _ -> if (loading) showLoading(getLoadingMsg()) else hideLoading() }
            setNoSignalListener { code, _ ->
                // código 1 = serviço expirado: avisa o EventBus (ServiceExpiredEvent.code = 1) e fecha a tela
                if (code == 1) post {
                    org.greenrobot.eventbus.EventBus.getDefault().post(com.live.evo.event.ServiceExpiredEvent().also { it.code = 1 })
                    mContext?.finish()   // c5.a.a(view): Activity do contexto
                }
            }
        }
    }

    open fun getConnectingMsg(): String = "Connecting..."
    open fun getLoadingMsg(): String = "Loading..."
    protected open fun getLayoutId(): Int = R.layout.catch_up_video_view
    protected open fun getCatchUpPlayInfo(): Flow<Any>? = null
    protected open fun getUidRxBytes(): Long = 0L
    /** Original: o() — o gesto "tecla 9 repetida 5x" alterna a visão de debug quando permitido. */
    protected open fun isDebugEnabled(): Boolean = true
    /** Original: I(Context, String) — vazio na base. */
    protected open fun showMessage(context: Context?, message: String?) {}
    fun setMediaController(c: IMediaController) { mediaController = c; bindMediaController() }
    fun setPlayEventListener(l: PlayEventListener?) { playEventListener = l }

    /** Liga o controle ao player (anchor = pai ou a própria view) e habilita se estiver tocando. Original: n() */
    private fun bindMediaController() {
        val c = mediaController ?: return
        c.setMediaPlayer(this)
        c.setAnchorView(if (parent is View) parent as View else this)
        c.setEnabled(mVideoView?.isPlaying() == true)
    }

    /** Mostra o loading com [message]. Original: H(String) */
    protected fun showLoading(message: String) {
        mLoadingIcon!!.visibility = View.VISIBLE
        mLoadingHint!!.visibility = View.VISIBLE
        mIsLoadingViewVisible = true
        mLoadingMsg!!.text = message
    }

    /** Esconde o loading. Original: u() */
    protected fun hideLoading() {
        mLoadingMsg!!.text = ""
        mLoadingIcon!!.visibility = View.GONE
        mLoadingHint!!.visibility = View.GONE
        mIsLoadingViewVisible = false
    }

    private fun onLowLevelBufferingStart() { showLoading(""); mInLowLevelBuffering = true }   // G()
    private fun onLowLevelBufferingEnd() {                                                      // F()
        mInLowLevelBuffering = false
        mOnLowLevelBufferingEndAction?.let { it.run(); mOnLowLevelBufferingEndAction = null }
    }

    /** Alterna o TextView de debug. Original: J() */
    private fun toggleDebugView() {
        val d = mDebugInfo!!
        if (d.visibility == View.VISIBLE) { d.visibility = View.GONE; mIsDebugViewVisible = false }
        else { d.visibility = View.VISIBLE; mIsDebugViewVisible = true }
    }

    /** Segundos de dados já baixados à frente da posição atual. Original: getBufferedLeading() */
    private fun getBufferedLeading(): Long {
        val v = mVideoView!!
        return v.downloadThousand.toLong() * v.duration / 1000 - v.position
    }

    /** Para o player, ignorando exceções. Original: p() */
    fun stopPlayer() { try { mVideoView?.stop(true) } catch (_: Exception) {} }

    /** Coleta `getCatchUpPlayInfo()` e prepara. Original: getAndPlay() (corrotina `CatchUpVideoView$getAndPlay$1`, classe `k$c`) */
    fun getAndPlay() {
        val flow = getCatchUpPlayInfo()
        if (flow == null) {
            showMessage(mContext, "no catchup play info provider!")
            val l = playEventListener
            if (l != null) l.c(RuntimeException("No play info provider!"))
            else showMessage(mContext, "Prepare error,no play info provider!")
            return
        }
        showLoading(getConnectingMsg())
        CoroutineScope(Dispatchers.IO).launch {
            flow.catch { t ->
                logger.error("prepare error", t)
                val l = playEventListener
                if (l != null) l.c(t) else showMessage(mContext, "prepare error," + t.message)
            }.collect { info ->
                val pi = info as? CatchUpPlayInfo
                if (pi == null) {
                    showMessage(mContext, mContext?.getString(R.string.catchup_no_next_program))
                    return@collect
                }
                try {
                    val response = InteractionUtils.getChannelStream(pi.channelId!!.toInt())
                    val programme = EPGProgramme().apply {
                        setStart(pi.startTime); setStop(pi.endTime); setChannel(pi.channelName)
                        setTitle(pi.title); setDesc(pi.description)
                    }
                    // O Flow<Long> de progresso do player é coletado até o fim com um coletor que ignora os valores (k$c$b$a).
                    mVideoView?.startCatchup(response!!, programme)?.collect { }
                } catch (t: Throwable) {
                    showMessage(mContext, "prepare error," + t.message)
                }
            }
        }
    }

    // MediaPlayerControl (delegam ao PlayerView interno)
    override fun start() { mVideoView!!.start() }
    override fun pause() { mVideoView!!.pause() }
    override fun getDuration(): Int = mVideoView!!.duration.toInt()
    override fun getCurrentPosition(): Int = mVideoView!!.position.toInt()
    override fun seekTo(pos: Int) { mVideoView!!.seekTo(pos.toLong()) }
    override fun isPlaying(): Boolean = mVideoView!!.isPlaying()
    override fun getBufferPercentage(): Int = mVideoView!!.downloadThousand / 10
    override fun canPause(): Boolean = mVideoView!!.canPause()
    override fun canSeekBackward(): Boolean = mVideoView!!.canSeekBackward()
    override fun canSeekForward(): Boolean = mVideoView!!.canSeekForward()
    override fun getAudioSessionId(): Int = 0

    /**
     * Teclas: dígito 9 (KEYCODE_9=16) repetido 5x → debug; BAIXO (20) com player tocando → mostra controle; MEDIA_NEXT/PREVIOUS (87/88)
     * repassados; ENTER/PLAY_PAUSE (66/79/85) → [togglePlayPause]; STOP (86) pausa; REWIND (89)/FAST_FORWARD (90) → [seekByKey];
     * PLAY (126) inicia; PAUSE (127) → ver abaixo. Teclas de sistema (voltar, volume, menu, call/endcall) seguem o fluxo padrão.
     */
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        val handled = !(keyCode == 4 || keyCode == 24 || keyCode == 25 || keyCode == 164 || keyCode == 82 || keyCode == 5 || keyCode == 6)
        if (keyCode == 16 && event.repeatCount == 5) {
            if (isDebugEnabled()) { toggleDebugView(); return true }
        } else if (keyCode == 20 && event.repeatCount == 0) {
            if (mVideoView!!.isPlaying() && mediaController != null) { mediaController!!.show(); return true }
        } else if ((keyCode != 87 || event.repeatCount != 0) && (keyCode != 88 || event.repeatCount != 0) && handled && mediaController != null) {
            if (keyCode != 66 && keyCode != 79 && keyCode != 85) {
                if (keyCode != 86) {
                    if (keyCode != 89) {
                        if (keyCode != 90) {
                            if (keyCode == 126) {
                                if (!isPlaying) { start(); mediaController!!.hide() }
                                return true
                            }
                            if (keyCode != 127) {
                                // switch (keyCode) {} vazio no original (jadx perdeu os cases): o fluxo cai no super.onKeyDown
                            }
                        }
                        return seekByKey(event, true)
                    }
                    return seekByKey(event, false)
                }
                if (isPlaying) { pause(); mediaController!!.show() }
                return true
            }
            return if (event.repeatCount == 0) togglePlayPause() else false
        }
        return super.onKeyDown(keyCode, event)
    }

    /** Soltar a tecla durante o arraste: confirma o seek em 500 ms. Original: onKeyUp + r() + s() */
    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == 24 || keyCode == 25 || keyCode == 82 || keyCode == 5 || keyCode == 6 || mediaController == null || event.action != KeyEvent.ACTION_UP) return false
        if (mediaController!!.b()) {
            mHandler.postDelayed({
                if (mediaController!!.b()) { mediaController!!.c(); mHandler.sendEmptyMessage(701) }
            }, 500L)
            return true
        }
        return false
    }

    /** Avanço/retrocesso por tecla: passo = duração/240 (mín. 1 s; dobra após 10 repetições). Original: q(KeyEvent, boolean) */
    private fun seekByKey(event: KeyEvent, forward: Boolean): Boolean {
        val c = mediaController!!
        if (!c.isShowing()) c.show()
        if (!c.b()) { c.d(); mForwardRewindPosition = currentPosition.toLong() }
        val duration = duration.toLong()
        var step = duration / 240
        if (step < 1000) step = 1000
        if (event.repeatCount > 10) step *= 2
        if (duration <= 0) return true
        val pos = if (forward) minOf(duration, mForwardRewindPosition + step) else maxOf(0.0, (mForwardRewindPosition - step).toDouble()).toLong()
        mForwardRewindPosition = pos
        c.setTrackingProgress((pos * 1000 / duration).toInt())
        return true
    }

    /** Play/pause pelo OK: pausar mostra o controle fixo e esconde loading; retomar atualiza o controle. Original: t() */
    private fun togglePlayPause(): Boolean {
        if (isPlaying) {
            pause(); mediaController!!.a(); hideLoading()
            return true
        }
        start()
        if (mediaController!!.isShowing()) mediaController!!.show()
        getBufferedLeading()   // resultado descartado no original
        return true
    }
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
