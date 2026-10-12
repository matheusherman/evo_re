package com.live.evo.catchup.player

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageButton
import com.live.evo.catchup.CatchUpPlayInfo
import com.live.evo.widget.IjkMediaController

/**
 * Controlador de mídia do catch-up (layout próprio): mostra canal/número/ícone, título e horários (início/fim)
 * do programa, SeekBar, botão play/pause; aplica estilos de texto conforme o modo (LoginConfig.flagA).
 * [setPlayInfo] (original `C(x4.c)`) preenche os textos.
 * Original: com/live/evo/catchup/player/a.java
 */
class CatchUpMediaController : IjkMediaController {
    constructor(context: Context) : super(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    lateinit var pauseButton: ImageButton
    fun setPlayInfo(info: CatchUpPlayInfo) { TODO("preencher TextViews (ver catchup/player/a.C)") }
    protected fun getLayoutId(): Int = TODO("R.layout do controlador de catch-up")
}

/** Adapter de banner (youth.banner) com URLs de imagem (anúncios do catch-up). Original: com/live/evo/catchup/player/b.java */
class CatchUpBannerAdapter(data: List<String>) : com.youth.banner.adapter.BannerAdapter<String, androidx.recyclerview.widget.RecyclerView.ViewHolder>(data) {
    override fun onCreateHolder(parent: android.view.ViewGroup, viewType: Int) = TODO("ImageView holder")
    override fun onBindView(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, data: String, position: Int, size: Int) { TODO("Glide.load(data)") }
}
