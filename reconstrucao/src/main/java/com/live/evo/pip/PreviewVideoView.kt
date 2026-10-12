package com.live.evo.pip

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.VideoView
import com.live.evo.R
import com.live.evo.util.CommonUtils
import com.live.evo.util.GlideImageLoader
import com.live.evo.util.ScreenUtils
import com.live.evo.widget.sloading.SLoadingView

/**
 * Janela PIP/preview do canal (1/4 da largura da tela, proporção 16:9): VideoView, texto de loading,
 * spinner, cadeado, nome do canal e imagem "no signal" (`pip_no_signal_en` se idioma "en", senão `_pt`;
 * ou imagem do canal via [GlideImageLoader]).
 *
 * Original: com/live/evo/pip/PreviewVideoView.java
 */
class PreviewVideoView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
    RelativeLayout(context, attrs, defStyle) {
    private lateinit var root: View
    private var parentView: View? = null
    private lateinit var loadingText: TextView
    private lateinit var loading: SLoadingView
    private lateinit var lock: TextView
    private lateinit var channelName: TextView
    private lateinit var noSignal: ImageView
    lateinit var previewVideo: VideoView; private set

    /** Liga as views e dimensiona o container pai a 1/4 da largura (16:9). Original: a(Context, View, String) */
    fun bind(context: Context, view: View, noSignalUrl: String?) {
        root = view
        parentView = view.parent as View
        loadingText = view.findViewById(R.id.preview_text_loading)
        loading = view.findViewById(R.id.preview_loading)
        lock = view.findViewById(R.id.preview_lock)
        channelName = view.findViewById(R.id.preview_channel)
        noSignal = view.findViewById(R.id.preview_nosignal)
        previewVideo = view.findViewById(R.id.preview_videoview)
        val w = ScreenUtils.width() / 4
        val h = w * 9 / 16
        parentView?.let { it.layoutParams.width = w; it.layoutParams.height = h; it.requestLayout() }
        layoutParams = LayoutParams(w, h)
        val fallback = if ("en".equals(CommonUtils.language(), true)) R.drawable.pip_no_signal_en else R.drawable.pip_no_signal_pt
        noSignal.background = null
        if (noSignalUrl.isNullOrEmpty()) noSignal.background = context.resources.getDrawable(fallback)
        else GlideImageLoader.load(context, noSignalUrl, noSignal)
    }

    fun setLoadingText(text: String?) { loadingText.text = text }
    fun setLoadingTextVisible(v: Int) {
        loadingText.visibility = v
        if (v != 0) loadingText.text = ""
        if (loading.visibility != v) loading.visibility = v
    }
    fun setNoSignalVisible(v: Int) { noSignal.visibility = v }
    fun setPreviewVideoVisible(v: Int) { parentView?.visibility = v }
    fun setTextLockVisible(v: Int) { lock.visibility = v }
    override fun getVisibility(): Int = loading.visibility
    override fun setVisibility(v: Int) { parentView?.visibility = v }
}
