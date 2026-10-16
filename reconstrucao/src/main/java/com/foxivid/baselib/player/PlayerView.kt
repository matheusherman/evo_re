package com.foxivid.baselib.player

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.foxivid.baselib.config.InteractionUtils
import com.foxivid.baselib.streaming.engine.PlayType
import com.live.evo.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.View
import android.widget.FrameLayout
import com.foxivid.baselib.model.meta.ChannelStreamResponse
import com.foxivid.baselib.model.meta.EPGProgramme
import com.foxivid.baselib.streaming.client.EngineHelper
import kotlinx.coroutines.flow.Flow
import tv.danmaku.ijk.media.player.IMediaPlayer

/**
 * Original: t/v/c/widget/videoview/PlayerView.java (+ PlayerView$b, PlayerView$c, Companion)
 *
 * View pública usada pelas telas (TV/mobile). É uma fachada fina: infla `player_view` (VideoView + camadas de "sem sinal", capa padrão,
 * legenda e canto de teste), cria o `PlayerView$b` ([PlayerViewHandler] concreto, que mostra/esconde essas camadas) e delega quase tudo
 * a ele (`H(channel)` → startLive, `I(channel, programme)` → startCatchup, `J(isTerminate)` → stop, `C(from, pos)` → restart...).
 * Também observa (PlayerView$c) um flow de InteractionUtils.O0() que chama `u1()` do handler a cada emissão.
 *
 * Implementa [PlayerViewContract] (videoview/a.java): `c(mediaId, lang)` devolve `EngineHelper.subtitleUrl(mediaId, lang)`.
 */
class PlayerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    FrameLayout(context, attrs), PlayerViewContract {

    private lateinit var videoView: VideoView
    private lateinit var playerViewHandler: PlayerViewHandler
    private lateinit var subtitleView: com.foxivid.ui.subtitle.SimpleSubtitleView
    private var playerTrialCorner: FrameLayout? = null
    private var noSignalView: FrameLayout? = null
    private var noSignalImg: ImageView? = null
    private var dftCoverView: ImageView? = null
    private var trialBgImg: ImageView? = null

    /** Subclasse concreta do handler: aplica visibilidade/imagens nas camadas desta view. Original: PlayerView$b */
    private inner class ViewHandler(private val ctx: Context) : PlayerViewHandler() {
        override fun g1(visibility: Int) { dftCoverView?.visibility = visibility }
        override fun k1(visibility: Int) { noSignalView?.visibility = visibility }
        override fun r0(): Int? = noSignalView?.visibility
        override fun v1(visibility: Int) { playerTrialCorner?.visibility = visibility }
        /** Imagem de "só VIP" (URL remota, com `vip_only` como placeholder). */
        override fun x1(url: String?) {
            if (url.isNullOrEmpty()) { noSignalImg?.setImageResource(R.drawable.vip_only); return }
            noSignalImg?.let { Glide.with(ctx).load(url).placeholder(R.drawable.vip_only).into(it) }
        }
        /** Imagem de "sem sinal". */
        override fun y1() { noSignalImg?.setImageResource(R.drawable.no_signal) }
        /** Imagem de "membro" (URL remota, com `member` como placeholder). */
        override fun z1(url: String?) {
            if (url.isNullOrEmpty()) { noSignalImg?.setImageResource(R.drawable.member); return }
            noSignalImg?.let { Glide.with(ctx).load(url).placeholder(R.drawable.member).into(it) }
        }
    }

    init {
        if (adaptDensity) com.foxivid.baselib.util.DensityAdapter.setCustomDensity(context)   // a0.f21295a.e(context) quando f18824m
        LayoutInflater.from(context).inflate(R.layout.player_view, this)
        var trialText: TextView? = null
        var trialDrawable: Drawable? = null
        if (attrs != null) {
            val ta = context.obtainStyledAttributes(attrs, R.styleable.PlayerView)
            try {
                val text = ta.getText(R.styleable.PlayerView_trial_corner_text)
                if (!text.isNullOrEmpty()) {
                    playerTrialCorner = findViewById(R.id.player_trial_corner)
                    trialBgImg = findViewById(R.id.trial_corner_bg)
                    trialDrawable = ta.getDrawable(R.styleable.PlayerView_trial_corner_drawable)
                    trialText = findViewById(R.id.trail_corner_txt)
                    trialText?.text = text
                }
            } finally { ta.recycle() }
        }
        videoView = findViewById(R.id.base_lib_player_video_view)
        noSignalView = findViewById(R.id.base_lib_player_no_signal_img)
        noSignalImg = findViewById(R.id.no_signal_img)
        dftCoverView = findViewById(R.id.base_lib_player_dft_cover_img)
        subtitleView = findViewById(R.id.base_lib_subtitle_view)
        val tipLayout = findViewById<LinearLayout>(R.id.base_lib_player_tip_layout)
        val loadingImg = findViewById<ImageView>(R.id.base_lib_player_loading_img)
        val loadingTxt = findViewById<TextView>(R.id.base_lib_player_loading_txt)
        val tipTxt = findViewById<TextView>(R.id.base_lib_player_tip_txt)
        videoView.setTipViews(tipLayout, tipTxt, loadingTxt, loadingImg)
        val handler = ViewHandler(context)
        playerViewHandler = handler
        handler.attach(context, this, videoView.videoViewHandler, subtitleView.getSubtitleHandler())
        // PlayerView$c: a cada emissão de InteractionUtils.O0() chama handler.u1()
        CoroutineScope(Dispatchers.IO).launch {
            InteractionUtils.stateFlow().catch { }.collect { playerViewHandler.onAppStateChanged() }
        }
    }

    /** Pode pausar (já preparou)? Original: A() */ fun canPause(): Boolean = playerViewHandler.canPause()
    /** Original: B() */ fun pause(): Boolean = playerViewHandler.pause()
    /** Reinicia a reprodução ("restart" por padrão), opcionalmente numa posição. Original: C(String, Long) */
    fun restart(from: String = "restart", position: Long? = null): Boolean = playerViewHandler.restart(from, position)
    /** Original: E(long) */ fun seekTo(position: Long) = playerViewHandler.seekTo(position)
    /** Original: G() */ fun start(): Boolean = playerViewHandler.start()
    /** Original: H(ChannelStreamResponse) */ fun startLive(response: ChannelStreamResponse): Flow<Long> = playerViewHandler.startLive(response)
    /** Original: I(ChannelStreamResponse, EPGProgramme) */
    fun startCatchup(response: ChannelStreamResponse, programme: EPGProgramme): Flow<Long> = playerViewHandler.startCatchup(response, programme, 0)
    /** Original: J(boolean) */ fun stop(isTerminate: Boolean) = playerViewHandler.stop(isTerminate)
    /** Original: v() */ fun canSeekBackward(): Boolean = playerViewHandler.canSeekBackward()
    /** Original: w() */ fun canSeekForward(): Boolean = playerViewHandler.canSeekForward()
    /** Original: z() */ fun isPlaying(): Boolean = playerViewHandler.isPlaying()

    var aspectRatioType: Int
        get() = playerViewHandler.aspectRatioType()
        set(value) = playerViewHandler.setAspectRatioType(value)
    val decodeMode: Int? get() = playerViewHandler.decodeMode()
    val downloadThousand: Int get() = playerViewHandler.downloadThousand()
    val duration: Long get() = playerViewHandler.duration()
    val playType: PlayType? get() = playerViewHandler.playType()
    val position: Long get() = playerViewHandler.position()
    val session: Long get() = playerViewHandler.session()
    val subtitleLang: String get() = playerViewHandler.subtitleLang()
    val subtitles: List<String>? get() = playerViewHandler.subtitles()
    val trackInfo get() = playerViewHandler.trackInfo()
    val videoHeight: Int get() = playerViewHandler.videoHeight()
    val videoName: String get() = playerViewHandler.videoName()
    val videoWidth: Int get() = playerViewHandler.videoWidth()
    val onCompletionListener: IMediaPlayer.OnCompletionListener? get() = playerViewHandler.onCompletionListener()

    /** Só repassa ao handler mudanças de estado; filtra repetições consecutivas (lista `[null]` no original). Original: setLoadingListener(p) + F(...) */
    fun setLoadingListener(listener: (Boolean, String) -> Unit) {
        var last: Boolean? = null
        playerViewHandler.setLoadingListener { loading, text ->
            if (loading != last) { last = loading; listener(loading, text) }
        }
    }
    fun setNoSignalListener(listener: (Int, String) -> Unit) = playerViewHandler.setNoSignalListener(listener)
    fun setOnCompletionListener(l: IMediaPlayer.OnCompletionListener?) = playerViewHandler.setOnCompletionListener(l)
    fun setOnErrorListener(l: IMediaPlayer.OnErrorListener?) = playerViewHandler.setOnErrorListener(l)
    fun setOnInfoListener(l: IMediaPlayer.OnInfoListener?) = playerViewHandler.setOnInfoListener(l)
    fun setOnPreparedListener(l: IMediaPlayer.OnPreparedListener?) = playerViewHandler.setOnPreparedListener(l)
    fun setOnSeekCompleteListener(l: IMediaPlayer.OnSeekCompleteListener?) = playerViewHandler.setOnSeekCompleteListener(l)
    fun setPlayCompleteListener(l: () -> Unit) = playerViewHandler.setPlayCompleteListener(l)
    fun setSubtitle(lang: String?) = playerViewHandler.setSubtitle(lang)
    /** Tamanho da legenda em sp. Original: setSubtitleFontSize(int) → handler.s1 */
    fun setSubtitleFontSize(sizeInSp: Int) { subtitleView.setTextSize(android.util.TypedValue.COMPLEX_UNIT_SP, sizeInSp.toFloat()) }
    /** Imagem de fundo do canto de teste. Original: setTrialImg(int) */
    fun setTrialImg(@androidx.annotation.DrawableRes imgResId: Int) { trialBgImg?.setImageResource(imgResId) }
    fun setZOrderOnTop(onTop: Boolean) = playerViewHandler.setZOrderOnTop(onTop)

    override fun c(mediaId: String, lang: String): String = EngineHelper.subtitleUrl(mediaId, lang)
    /** Altura da view. Original: a() */
    override fun a(): Int = height
    /** Posição do canto de teste (x,y). Original: b(float, float) */
    override fun b(x: Float, y: Float) { playerTrialCorner?.x = x; playerTrialCorner?.y = y }
    /** Tamanho da legenda (tipo de dimensão, valor). Original: g(int, float) */
    override fun g(dimensionType: Int, size: Float) { subtitleView.setTextSize(dimensionType, size) }
    /** Original: i() */ override fun i(): Float = x
    /** Original: l() */ override fun l(): Float = y

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) { super.onSizeChanged(w, h, oldw, oldh) }

    companion object {
        private var adaptDensity = true
        /** Liga/desliga o ajuste de densidade no construtor. Original: Companion.a(boolean) */
        fun enableDensityAdapter(enabled: Boolean) { adaptDensity = enabled }
    }
}

/** Original: x1/f1/lb/widget/videoview/a.java */
interface PlayerViewContract {
    fun a(): Int
    fun b(x: Float, y: Float)
    fun c(mediaId: String, lang: String): String
    fun g(dimensionType: Int, size: Float)
    fun i(): Float
    fun isShown(): Boolean
    fun l(): Float
}

/** Original: x1/f1/lb/widget/videoview/b.java — callback de superfície (IRenderView.IRenderCallback do ijk-example). */
interface RenderCallback {
    fun onSurfaceChanged(holder: SurfaceHolderWrapper, format: Int, width: Int, height: Int) // a
    fun onSurfaceCreated(holder: SurfaceHolderWrapper, width: Int, height: Int)             // b
    fun onSurfaceDestroyed(holder: SurfaceHolderWrapper)                                    // c
}

/**
 * Original: x1/f1/lb/widget/videoview/c.java — IRenderView (implementado por
 * t/v/c/widget/videoview/SurfaceRenderView.java, um SurfaceView com MeasureHelper de aspect ratio).
 */
interface RenderView {
    fun setVideoSize(w: Int, h: Int)          // a
    fun setVideoSampleAspectRatio(n: Int, d: Int) // b
    fun addRenderCallback(cb: RenderCallback)    // d (c = remove no original)
    fun removeRenderCallback(cb: RenderCallback) // c
    fun getView(): View
    fun setAspectRatio(type: Int)
    fun setZOrderOnTop(onTop: Boolean)
}

/** Original: x1/f1/lb/widget/videoview/d.java — ISurfaceHolder: `b(IMediaPlayer)` faz `player.setDisplay(holder)`. */
interface SurfaceHolderWrapper {
    fun renderView(): RenderView              // a
    fun bindToMediaPlayer(mp: IMediaPlayer)   // b
    fun surfaceHolder(): SurfaceHolder?       // c
}

/**
 * Original: x1/f1/lb/widget/videoview/e.java — contrato do t/v/c/widget/videoview/VideoView.java
 * (FrameLayout com render view, textos de tip/loading e animação).
 */
interface VideoViewContract {
    fun d(tip: String, videoName: String, errorCode: Int?)
    fun e()
    fun f()
    fun h(): Int
    fun invalidate()
    fun isShown(): Boolean
    fun j(view: View)
    fun k(msg: String): Boolean
    fun m(): Int
    fun n()
    fun removeView(view: View)
    fun stopAnimation()
}
