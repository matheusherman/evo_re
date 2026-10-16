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

/**
 * Original: ag/a.java — cópia do `MeasureHelper` do ijk-example (terceiros), com um log de debug em [setVideoSize].
 * Tipos de aspecto: 0 FIT_PARENT, 1 FILL_PARENT, 2 WRAP_CONTENT, 3 MATCH_PARENT, 4 16:9 FIT_PARENT, 5 4:3 FIT_PARENT.
 */
class IjkMeasureHelper(view: View) : MeasureHelper {
    private val logger = org.slf4j.LoggerFactory.getLogger(IjkMeasureHelper::class.java)
    private val viewRef = WeakReference(view)       // f287b
    private var videoWidth = 0                       // f288c
    private var videoHeight = 0                      // f289d
    private var videoSarNum = 0                      // f290e
    private var videoSarDen = 0                      // f291f
    private var videoRotationDegree = 0              // f292g
    private var measuredW = 0                        // f293h
    private var measuredH = 0                        // f294i
    private var currentAspectRatio = 0               // f295j

    /** Calcula [measuredW]/[measuredH] a partir das specs e do tamanho/SAR/rotação do vídeo. Original: a(int, int) */
    override fun doMeasure(widthSpec: Int, heightSpec: Int) {
        var wSpec = widthSpec
        var hSpec = heightSpec
        if (videoRotationDegree == 90 || videoRotationDegree == 270) { val t = wSpec; wSpec = hSpec; hSpec = t }
        var width = View.getDefaultSize(videoWidth, wSpec)
        var height = View.getDefaultSize(videoHeight, hSpec)
        if (currentAspectRatio == 3) {
            // MATCH_PARENT: o original devolve as próprias specs (já trocadas pela rotação) como "tamanho" medido
            measuredW = wSpec
            measuredH = hSpec
            return
        }
        run {
            if (videoWidth > 0 && videoHeight > 0) {
                val widthMode = View.MeasureSpec.getMode(wSpec)
                val widthSize = View.MeasureSpec.getSize(wSpec)
                val heightMode = View.MeasureSpec.getMode(hSpec)
                val heightSize = View.MeasureSpec.getSize(hSpec)
                if (widthMode == View.MeasureSpec.AT_MOST && heightMode == View.MeasureSpec.AT_MOST) {
                    val specAspect = widthSize.toFloat() / heightSize.toFloat()
                    var displayAspect: Float
                    when (currentAspectRatio) {
                        1 -> {
                            displayAspect = width.toFloat() / height
                            if (videoRotationDegree == 90 || videoRotationDegree == 270) displayAspect = 1.0f / displayAspect
                        }
                        4 -> displayAspect = if (videoRotationDegree == 90 || videoRotationDegree == 270) 0.5625f else 1.7777778f
                        5 -> displayAspect = if (videoRotationDegree == 90 || videoRotationDegree == 270) 0.75f else 1.3333334f
                        else -> {
                            displayAspect = videoWidth.toFloat() / videoHeight
                            if (videoSarNum > 0 && videoSarDen > 0) displayAspect = displayAspect * videoSarNum / videoSarDen
                        }
                    }
                    val shouldBeWider = displayAspect > specAspect
                    when (currentAspectRatio) {
                        0, 4, 5 -> {
                            if (shouldBeWider) { width = widthSize; height = (widthSize / displayAspect).toInt() }
                            else { height = heightSize; width = (heightSize * displayAspect).toInt() }
                        }
                        1 -> {
                            if (shouldBeWider) { height = heightSize; width = (heightSize * displayAspect).toInt() }
                            else { width = widthSize; height = (widthSize / displayAspect).toInt() }
                        }
                        else -> {
                            if (shouldBeWider) { width = Math.min(videoWidth, widthSize); height = (width / displayAspect).toInt() }
                            else { height = Math.min(videoHeight, heightSize); width = (height * displayAspect).toInt() }
                        }
                    }
                } else if (widthMode == View.MeasureSpec.EXACTLY && heightMode == View.MeasureSpec.EXACTLY) {
                    width = widthSize; height = heightSize
                    if (videoWidth * height < width * videoHeight) width = height * videoWidth / videoHeight
                    else if (videoWidth * height > width * videoHeight) height = width * videoHeight / videoWidth
                } else if (widthMode == View.MeasureSpec.EXACTLY) {
                    width = widthSize
                    height = width * videoHeight / videoWidth
                    if (heightMode == View.MeasureSpec.AT_MOST && height > heightSize) height = heightSize
                } else if (heightMode == View.MeasureSpec.EXACTLY) {
                    height = heightSize
                    width = height * videoWidth / videoHeight
                    if (widthMode == View.MeasureSpec.AT_MOST && width > widthSize) width = widthSize
                } else {
                    width = videoWidth; height = videoHeight
                    if (heightMode == View.MeasureSpec.AT_MOST && height > heightSize) { height = heightSize; width = height * videoWidth / videoHeight }
                    if (widthMode == View.MeasureSpec.AT_MOST && width > widthSize) { width = widthSize; height = width * videoHeight / videoWidth }
                }
            }
            // sem tamanho de vídeo: usa os tamanhos padrão (View.getDefaultSize) calculados acima
        }
        measuredW = width
        measuredH = height
    }

    override fun measuredHeight(): Int = measuredH      // b()
    override fun measuredWidth(): Int = measuredW       // c()
    override fun setAspectRatio(type: Int) { currentAspectRatio = type }          // d(int)
    override fun setVideoRotation(degree: Int) { videoRotationDegree = degree }   // e(int)
    override fun setVideoSampleAspectRatio(num: Int, den: Int) { videoSarNum = num; videoSarDen = den }   // f(int,int)
    override fun setVideoSize(w: Int, h: Int) {                                    // g(int,int)
        if (com.foxivid.baselib.config.BaseLibConfig.isDebug) logger.debug("@@@@: setVideoSize[$videoWidth, $videoHeight]")
        videoWidth = w
        videoHeight = h
    }
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
