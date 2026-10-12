package com.foxivid.baselib.player

import android.content.Context
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import tv.danmaku.ijk.media.player.IMediaPlayer
import tv.danmaku.ijk.media.player.ISurfaceTextureHolder
import java.lang.ref.WeakReference
import java.util.concurrent.ConcurrentHashMap

/** Medidor de aspecto do ijk-example (`ag.a` = MeasureHelper): a/b = measure, c/b = tamanho medido, d = aspecto, e = rotação, f = SAR, g = tamanho do vídeo. */
interface MeasureHelper {
    fun doMeasure(widthSpec: Int, heightSpec: Int)    // a
    fun measuredHeight(): Int                          // b
    fun measuredWidth(): Int                           // c
    fun setAspectRatio(type: Int)                      // d
    fun setVideoRotation(degree: Int)                  // e
    fun setVideoSampleAspectRatio(num: Int, den: Int)  // f
    fun setVideoSize(w: Int, h: Int)                   // g
}

/** Original: ag/a.java (MeasureHelper do ijk-example, terceiros) — implementação padrão não reconstruída. */
class IjkMeasureHelper(@Suppress("unused") private val view: View) : MeasureHelper {
    override fun doMeasure(widthSpec: Int, heightSpec: Int) = TODO("ag.a.a — MeasureHelper do ijk-example")
    override fun measuredHeight(): Int = TODO("ag.a.b")
    override fun measuredWidth(): Int = TODO("ag.a.c")
    override fun setAspectRatio(type: Int) = TODO("ag.a.d")
    override fun setVideoRotation(degree: Int) = TODO("ag.a.e")
    override fun setVideoSampleAspectRatio(num: Int, den: Int) = TODO("ag.a.f")
    override fun setVideoSize(w: Int, h: Int) = TODO("ag.a.g")
}

/**
 * Original: t/v/c/widget/videoview/SurfaceRenderView.java (+ $a = holder wrapper, $b = SurfaceHolder.Callback)
 *
 * SurfaceView com medição de aspecto (ijk-example `SurfaceRenderView`). Implementa [RenderView]; despacha eventos
 * de superfície para os [RenderCallback] registrados. Ao vincular um player (`bindToMediaPlayer`), limpa
 * `SurfaceTexture` se o player for `ISurfaceTextureHolder`, força `setZOrderOnTop(true)` +
 * `setZOrderMediaOverlay(true)` e faz `player.setDisplay(holder)`.
 */
class SurfaceRenderView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
    SurfaceView(context, attrs, defStyle), RenderView {

    private lateinit var measureHelper: MeasureHelper   // Original: ag.a (MeasureHelper do ijk-example)
    private lateinit var surfaceCallback: SurfaceCallback
    private var videoView: View? = null

    init {
        // Original: e(context)
        measureHelper = IjkMeasureHelper(this)
        surfaceCallback = SurfaceCallback(this)
        holder.addCallback(surfaceCallback)
    }

    /** Original: SurfaceRenderView$a */
    inner class InternalSurfaceHolder(private val owner: SurfaceRenderView?, private val surfaceHolder: SurfaceHolder?) : SurfaceHolderWrapper {
        override fun renderView(): RenderView = owner!!
        override fun bindToMediaPlayer(mp: IMediaPlayer) {
            if (surfaceHolder == null) return
            if (mp is ISurfaceTextureHolder) mp.setSurfaceTexture(null)
            this@SurfaceRenderView.setZOrderOnTop(true)
            this@SurfaceRenderView.setZOrderMediaOverlay(true)
            mp.setDisplay(surfaceHolder)
        }
        override fun surfaceHolder(): SurfaceHolder? = surfaceHolder
    }

    /** Original: SurfaceRenderView$b */
    class SurfaceCallback(view: SurfaceRenderView) : SurfaceHolder.Callback {
        private var holderRef: SurfaceHolder? = null
        private var isFormatChanged = false
        private var format = 0
        private var width = 0
        private var height = 0
        private val ref = WeakReference(view)
        private val callbacks = ConcurrentHashMap<RenderCallback, RenderCallback>()

        private fun wrapper() = ref.get()?.let { it.InternalSurfaceHolder(it, holderRef) }

        fun add(cb: RenderCallback) {
            callbacks[cb] = cb
            var w: SurfaceHolderWrapper? = null
            if (holderRef != null) { w = wrapper()!!; cb.onSurfaceCreated(w, width, height) }
            if (isFormatChanged) { w = w ?: wrapper()!!; cb.onSurfaceChanged(w, format, width, height) }
        }
        fun remove(cb: RenderCallback) { callbacks.remove(cb) }

        override fun surfaceCreated(h: SurfaceHolder) {
            holderRef = h; isFormatChanged = false; format = 0; width = 0; height = 0
            val w = wrapper()!!; callbacks.keys.forEach { it.onSurfaceCreated(w, 0, 0) }
        }
        override fun surfaceChanged(h: SurfaceHolder, format: Int, width: Int, height: Int) {
            holderRef = h; isFormatChanged = true; this.format = format; this.width = width; this.height = height
            val w = wrapper()!!; callbacks.keys.forEach { it.onSurfaceChanged(w, format, width, height) }
        }
        override fun surfaceDestroyed(h: SurfaceHolder) {
            holderRef = null; isFormatChanged = false; format = 0; width = 0; height = 0
            val w = wrapper()!!; callbacks.keys.forEach { it.onSurfaceDestroyed(w) }
        }
    }

    /** Original: a(w,h) — só se > 0: `setVideoSize` no helper, `holder.setFixedSize(w,h)`, relayout. */
    override fun setVideoSize(w: Int, h: Int) {
        if (w <= 0 || h <= 0) return
        measureHelper.setVideoSize(w, h)
        holder.setFixedSize(w, h)
        requestLayout(); invalidate()
    }
    /** Original: b(num, den) */
    override fun setVideoSampleAspectRatio(n: Int, d: Int) {
        if (n <= 0 || d <= 0) return
        measureHelper.setVideoSampleAspectRatio(n, d)
        requestLayout()
    }
    override fun addRenderCallback(cb: RenderCallback) = surfaceCallback.add(cb)         // Original: d(cb)
    override fun removeRenderCallback(cb: RenderCallback) = surfaceCallback.remove(cb)   // Original: c(cb)
    override fun getView(): View = this

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        measureHelper.doMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(measureHelper.measuredWidth(), measureHelper.measuredHeight())
    }
    override fun setAspectRatio(type: Int) { measureHelper.setAspectRatio(type); requestLayout(); invalidate() }
    fun setVideoRotation(degree: Int) { measureHelper.setVideoRotation(degree); requestLayout() }
    fun setVideoView(view: View) { videoView = view }

    override fun onInitializeAccessibilityEvent(event: AccessibilityEvent) {
        super.onInitializeAccessibilityEvent(event); event.className = SurfaceRenderView::class.java.name
    }
    override fun onInitializeAccessibilityNodeInfo(info: AccessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(info); info.className = SurfaceRenderView::class.java.name
    }
}
