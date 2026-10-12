package com.foxivid.baselib.player

import android.content.Context
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
 * View pública usada pelas telas (TV/mobile). É uma fachada fina: infla o layout com
 * [VideoView] (SurfaceRenderView + loading/tip/trial), cria o `PlayerView$b` (subclasse concreta de
 * [PlayerViewHandler] que implementa g1/k1/v1/x1/y1/z1 mostrando/escondendo views) e delega:
 * `H(channel)` → [PlayerViewHandler.startLive], `I(channel, programme)` → [PlayerViewHandler.startCatchup],
 * `J(isTerminate)` → stop, `C(from, pos)` → restart, getters de sessão/duração/posição/tracks.
 * Também observa (PlayerView$c) um flow de t/v/c/i/a (InteractionUtils) para reagir a mudanças de estado da app.
 *
 * Implementa [PlayerViewContract] (videoview/a.java): `c(mediaId, lang)` devolve
 * `EngineHelper.subtitleUrl(mediaId, lang)`.
 * TODO: corpo de UI (layout, atributos XML, listeners de loading/no-signal) não reconstruído.
 */
class PlayerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    FrameLayout(context, attrs), PlayerViewContract {

    private lateinit var handler: PlayerViewHandler

    fun startLive(response: ChannelStreamResponse): Flow<Long> = handler.startLive(response)              // H
    fun startCatchup(response: ChannelStreamResponse, programme: EPGProgramme, mediaMode: Int): Flow<Long> =
        handler.startCatchup(response, programme, mediaMode)                                            // I
    fun stop(isTerminate: Boolean) = handler.stop(isTerminate)                                          // J

    override fun c(mediaId: String, lang: String): String = EngineHelper.subtitleUrl(mediaId, lang)
    override fun a(): Int = TODO("PlayerView.a — UI")
    override fun b(x: Float, y: Float) = TODO("PlayerView.b — posição da legenda (UI)")
    override fun g(dimensionType: Int, size: Float) = TODO("PlayerView.g — tamanho da legenda (UI)")
    override fun i(): Float = TODO("UI")
    override fun l(): Float = TODO("UI")
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
