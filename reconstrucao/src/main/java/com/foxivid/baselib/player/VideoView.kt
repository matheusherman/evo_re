package com.foxivid.baselib.player

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import org.slf4j.LoggerFactory

/**
 * Original: t/v/c/widget/videoview/VideoView.java
 *
 * FrameLayout que hospeda o [SurfaceRenderView] e as views de loading/mensagem. No construtor cria o
 * [VideoViewHandler] (z0), um [SurfaceRenderView] (com `setVideoView(this)`) e chama
 * `handler.attach(context, this, renderView)`. É focável (touch inclusive) e pede foco.
 * As views de tip/loading são injetadas depois por [setTipViews] (Original: `r(...)`), normalmente pelo PlayerView.
 *
 * Implementa [VideoViewContract] (videoview/e.java), que o [VideoViewHandler] usa para mostrar loading e erros.
 */
class VideoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @Suppress("UNUSED_PARAMETER") defStyleAttr: Int = 0,
) : FrameLayout(context, attrs), VideoViewContract {

    private val logger = LoggerFactory.getLogger(VideoView::class.java)
    private var mLoadingImageView: ImageView? = null
    private var mTipTextView: TextView? = null
    private var mLoadingTxtView: TextView? = null
    private var mTipLinearLayout: LinearLayout? = null
    private val mHandler = Handler(Looper.getMainLooper())

    /** Original: getVideoViewHandler() */
    lateinit var videoViewHandler: VideoViewHandler
        private set

    init {
        // Original: q(context)
        val handler = VideoViewHandler(context)
        val renderView = SurfaceRenderView(context)
        renderView.setVideoView(this)
        handler.attach(context, this, renderView)
        videoViewHandler = handler
        isFocusable = true
        isFocusableInTouchMode = true
        requestFocus()
    }

    /** Original: r(tipLayout, tipTextview, loadingTextView, loadingImageview) — sem tip text usa o texto do loading. */
    fun setTipViews(tipLayout: LinearLayout?, tipTextView: TextView?, loadingTextView: TextView, loadingImageView: ImageView) {
        mLoadingImageView = loadingImageView
        loadingImageView.visibility = View.GONE
        mTipTextView = tipTextView ?: loadingTextView
        mLoadingTxtView = loadingTextView
        mTipLinearLayout = tipLayout
    }

    /**
     * Original: d(tip, videoName, errorCode) — mostra mensagem de erro/aviso: prefixa "videoName: " e sufixa
     * "[errorCode]"; esconde o spinner e o texto de loading (se distinto); mostra o layout e o texto.
     */
    override fun d(tip: String, videoName: String, errorCode: Int?) {
        val tv = mTipTextView
        if (tv == null) { logger.warn(tip); return }
        var text = tip
        if (!TextUtils.isEmpty(videoName) && tip.isNotEmpty()) {
            text = if (errorCode == null) "$videoName: $tip" else "$videoName: $tip[$errorCode]"
        }
        mLoadingImageView?.let { if (it.visibility != View.GONE) { it.clearAnimation(); it.visibility = View.GONE } }
        if (mLoadingTxtView !== tv) mLoadingTxtView?.visibility = View.GONE
        mTipLinearLayout?.let { if (it.visibility != View.VISIBLE) it.visibility = View.VISIBLE }
        tv.text = text
        if (tv.visibility != View.VISIBLE) tv.visibility = View.VISIBLE
    }

    /** Original: e() — esconde textos de loading e de tip. */
    override fun e() {
        if (mTipTextView !== mLoadingTxtView) mLoadingTxtView?.let { if (it.visibility != View.GONE) it.visibility = View.GONE }
        mTipTextView?.let { if (it.visibility != View.GONE) it.visibility = View.GONE }
    }

    /** Original: f() — esconde o layout de tip (post no main looper). */
    override fun f() {
        val l = mTipLinearLayout
        if (l == null || l.visibility != View.GONE) mHandler.post { mTipLinearLayout?.visibility = View.GONE }
    }

    /** Original: j(view) */
    override fun j(view: View) = addView(view)

    /**
     * Original: k(msg) — mostra o loading (texto + spinner animado por `util.d.a`) se ainda não visível;
     * devolve `true` se começou a mostrar.
     */
    override fun k(msg: String): Boolean {
        val img = mLoadingImageView
        if (img == null || img.visibility == View.VISIBLE) return false
        mLoadingTxtView?.let { it.text = msg; it.visibility = View.VISIBLE }
        img.visibility = View.VISIBLE
        mTipLinearLayout?.let { if (it.visibility != View.VISIBLE) it.visibility = View.VISIBLE }
        // Original: util.d.a(imageView) — inicia animação de rotação (outro módulo)
        return true
    }

    /** Original: n() — esconde só o texto de loading (se distinto do tip). */
    override fun n() {
        val t = mLoadingTxtView ?: return
        if (t !== mTipTextView) t.visibility = View.GONE
    }

    /** Original: stopAnimation() */
    override fun stopAnimation() {
        val img = mLoadingImageView
        if (img == null || img.visibility != View.VISIBLE) return
        img.clearAnimation()
        img.visibility = View.GONE
        mTipLinearLayout?.visibility = View.GONE
    }

    /** Original: h() */ override fun h(): Int = measuredWidth
    /** Original: m() */ override fun m(): Int = measuredHeight
}
