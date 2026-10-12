package com.foxivid.baselib.player.ijkmedia

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Message
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.PopupWindow
import android.widget.SeekBar
import android.widget.TextView
import org.slf4j.LoggerFactory

/**
 * Original: com/live/evo/widget/ijkmedia/a.java
 * Contrato de um "media controller" (barra play/pause + seek) para o player VoD/catch-up.
 * As interfaces aninhadas (listeners de hidden/pause/resume/seek/shown) são vazias no original.
 */
interface MediaControllerContract {
    interface OnHiddenListener
    interface OnPauseListener
    interface OnResumeListener
    interface OnSeekListener
    interface OnShownListener

    fun showForever()                 // a()
    fun isTracking(): Boolean         // b()
    fun stopTracking()                // c()
    fun startTracking()               // d()
    fun hide()
    fun isShowing(): Boolean
    fun setAnchorView(view: View)
    fun setEnabled(enabled: Boolean)
    fun setMediaPlayer(player: MediaController.MediaPlayerControl)
    fun setTrackingProgress(progress: Int)
    fun show()
}

/**
 * Original: com/live/evo/widget/ijkmedia/b.java (+ b$a, b$b, b$c)
 *
 * Implementação clássica (derivada do MediaController do ijkplayer-example): seekbar de 0..1000,
 * atualização a cada segundo (msg 2), auto-esconder após 3000 ms (msg 1). Layout
 * `R.layout.view_pure_player_mediacontroller`; ids procurados por nome:
 * mediacontroller_play_pause, mediacontroller_seekbar, mediacontroller_time_total,
 * mediacontroller_time_current, mediacontroller_file_name; ícones mediacontroller_play/pause.
 *
 * Construtor com AttributeSet ⇒ modo "embutido" (`fromXml = true`, mostra/esconde via visibility);
 * construtor simples ⇒ modo PopupWindow.
 */
open class PureMediaController : FrameLayout, MediaControllerContract {

    private val logger = LoggerFactory.getLogger(PureMediaController::class.java)
    private var player: MediaController.MediaPlayerControl? = null
    private var ctx: Context? = null
    private var window: PopupWindow? = null
    private var animStyle = 0
    private var anchor: View? = null
    private var root: View? = null
    private var progress: SeekBar? = null
    private var endTime: TextView? = null
    private var currentTime: TextView? = null
    private var fileNameView: TextView? = null
    private var infoView: TextView? = null
    private var fileName: String? = null
    private var duration: Long = 0
    private var showing = false
    private var dragging = false
    private var fromXml = false
    private var pauseButton: ImageButton? = null

    /** Original: b$a */
    @SuppressLint("HandlerLeak")
    private val handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                FADE_OUT -> hide()
                SHOW_PROGRESS -> {
                    val pos = setProgress()
                    if (dragging || !showing) return
                    sendMessageDelayed(obtainMessage(SHOW_PROGRESS), 1000 - (pos % 1000))
                    updatePausePlay()
                }
            }
        }
    }

    /** Original: b$b */
    private val pauseListener = OnClickListener { doPauseResume(); show(3000) }

    /** Original: b$c */
    private val seekListener = object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(bar: SeekBar, progress: Int, fromUser: Boolean) {
            if (fromUser || dragging) {
                if (duration <= 0) duration = player!!.duration.toLong()
                val text = formatTime(duration * progress / 1000)
                infoView?.text = text
                currentTime?.text = text
            }
        }
        override fun onStartTrackingTouch(bar: SeekBar) {
            dragging = true
            showForever()
            handler.removeMessages(SHOW_PROGRESS)
            infoView?.let { it.text = ""; it.visibility = VISIBLE }
        }
        override fun onStopTrackingTouch(bar: SeekBar) {
            val pos = player!!.duration.toLong() * bar.progress / 1000
            logger.info("onStopTrackingTouch seekTo[{}] bar pos[{}] duration[{}]", pos, bar.progress, duration)
            player!!.seekTo(pos.toInt())
            // Original: b.k(this) devolve sempre null (listener de seek nunca configurado)
            infoView?.let { it.text = ""; it.visibility = GONE }
            show(3000)
            handler.removeMessages(SHOW_PROGRESS)
            dragging = false
            handler.sendEmptyMessageDelayed(SHOW_PROGRESS, 1000L)
        }
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        root = this
        fromXml = true
        ctx = context
    }

    constructor(context: Context) : super(context) {
        ctx = context
        if (!fromXml) initFloatingWindow()
    }

    /** Original: b.v() */
    private fun initFloatingWindow() {
        window = PopupWindow(ctx).apply {
            isFocusable = false
            setBackgroundDrawable(null)
            isOutsideTouchable = true
        }
        animStyle = android.R.style.Animation
    }

    /** Original: b.A() */
    fun updatePausePlay() {
        val b = pauseButton ?: return
        if (root == null) return
        b.setImageDrawable(if (player!!.isPlaying) pauseIconDrawable else playIconDrawable)
    }

    /** Original: b.s() */
    fun doPauseResume() {
        if (player!!.isPlaying) player!!.pause() else player!!.start()
        updatePausePlay()
    }

    /** Original: b.x() */
    fun setProgress(): Long {
        val p = player ?: return 0
        if (dragging) return progress!!.progress.toLong()
        val position = p.currentPosition.toLong()
        val dur = p.duration.toLong()
        progress?.let {
            if (dur > 0) it.progress = (1000 * position / dur).toInt()
            it.secondaryProgress = p.bufferPercentage * 10
        }
        duration = dur
        endTime?.text = formatTime(dur)
        currentTime?.text = formatTime(position)
        return position
    }

    override fun isTracking() = dragging
    override fun stopTracking() = seekListener.onStopTrackingTouch(progress!!)
    override fun startTracking() = seekListener.onStartTrackingTouch(progress!!)

    override fun hide() {
        if (anchor != null && showing) {
            try {
                handler.removeMessages(SHOW_PROGRESS)
                if (fromXml) visibility = GONE else window!!.dismiss()
            } catch (e: IllegalArgumentException) {
                logger.debug("MediaController already removed", e)
            }
            showing = false
        }
    }

    override fun isShowing() = showing
    override fun onTouchEvent(event: MotionEvent): Boolean { show(3000); return true }
    override fun onTrackballEvent(event: MotionEvent): Boolean { show(3000); return false }

    override fun setAnchorView(view: View) {
        anchor = view
        if (!fromXml) {
            removeAllViews()
            root = makeControllerView()
            window!!.contentView = root
            window!!.width = -1
            window!!.height = -1
        }
        initControllerView(root!!)
    }

    fun setAnimationStyle(style: Int) { animStyle = style }

    override fun setEnabled(enabled: Boolean) {
        pauseButton?.isEnabled = enabled
        progress?.isEnabled = enabled
        super.setEnabled(enabled)
    }

    fun setFileName(name: String?) { fileName = name; fileNameView?.text = name }
    fun setInfoView(v: TextView?) { infoView = v }
    override fun setMediaPlayer(player: MediaController.MediaPlayerControl) { this.player = player; updatePausePlay() }
    override fun setTrackingProgress(progress: Int) { this.progress!!.progress = progress }
    override fun show() = show(3000)

    /** Original: b.w() */
    protected open fun makeControllerView(): View =
        (ctx!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(layoutId, this)

    /** Original: b.y() — systemUiVisibility 512 e tipo de janela 1003 via reflexão. */
    @TargetApi(16)
    fun setWindowLayoutType() {
        try {
            anchor!!.systemUiVisibility = 512
            PopupWindow::class.java.getMethod("setWindowLayoutType", Integer.TYPE).invoke(window, 1003)
        } catch (e: Exception) { logger.error("setWindowLayoutType", e) }
    }

    /** Original: b.z(int) */
    fun show(timeout: Int) {
        val a = anchor
        if (!showing && a != null && a.windowToken != null) {
            pauseButton?.requestFocus()
            if (fromXml) visibility = VISIBLE
            else {
                val loc = IntArray(2)
                a.getLocationOnScreen(loc)
                val r = Rect(loc[0], loc[1], loc[0] + a.width, loc[1] + a.height)
                window!!.animationStyle = animStyle
                setWindowLayoutType()
                window!!.showAtLocation(a, 51 /* TOP|LEFT */, r.left, r.bottom)
            }
            showing = true
        }
        updatePausePlay()
        handler.sendEmptyMessage(SHOW_PROGRESS)
        if (timeout != 0) {
            handler.removeMessages(FADE_OUT)
            handler.sendMessageDelayed(handler.obtainMessage(FADE_OUT), timeout.toLong())
        }
    }

    override fun showForever() = show(Int.MAX_VALUE)

    protected open val layoutId: Int get() = TODO("R.layout.view_pure_player_mediacontroller (recurso do app)")
    protected open val pauseIconDrawable: Drawable get() = context.resources.getDrawable(resources.getIdentifier("mediacontroller_pause", "drawable", ctx!!.packageName))
    protected open val playIconDrawable: Drawable get() = context.resources.getDrawable(resources.getIdentifier("mediacontroller_play", "drawable", ctx!!.packageName))

    override fun onFinishInflate() {
        super.onFinishInflate()
        root?.let { initControllerView(it) }
    }

    /** Original: b.u(View) */
    protected open fun initControllerView(v: View) {
        fun id(name: String) = resources.getIdentifier(name, "id", ctx!!.packageName)
        pauseButton = v.findViewById<ImageButton>(id("mediacontroller_play_pause"))?.also {
            it.requestFocus(); it.setOnClickListener(pauseListener)
        }
        progress = v.findViewById<SeekBar>(id("mediacontroller_seekbar"))?.also {
            it.setOnSeekBarChangeListener(seekListener); it.max = 1000
        }
        endTime = v.findViewById(id("mediacontroller_time_total"))
        currentTime = v.findViewById(id("mediacontroller_time_current"))
        fileNameView = v.findViewById<TextView>(id("mediacontroller_file_name"))?.also { it.text = fileName }
    }

    // Original: setters de listeners vazios (sem efeito)
    fun setOnHiddenListener(l: MediaControllerContract.OnHiddenListener?) {}
    fun setOnPauseListener(l: MediaControllerContract.OnPauseListener?) {}
    fun setOnResumeListener(l: MediaControllerContract.OnResumeListener?) {}
    fun setOnSeekListener(l: MediaControllerContract.OnSeekListener?) {}
    fun setOnShownListener(l: MediaControllerContract.OnShownListener?) {}

    /** Original: x1.f1.lb.util.c1.a(long) — formata ms em hh:mm:ss (módulo util). */
    private fun formatTime(ms: Long): String = TODO("x1.f1.lb.util.c1.a — util")

    private companion object {
        const val FADE_OUT = 1
        const val SHOW_PROGRESS = 2
    }
}
