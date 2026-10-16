package com.live.evo.catchup.player

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ClipDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import com.live.evo.R
import com.live.evo.catchup.CatchUpPlayInfo
import com.live.evo.util.GlideImageLoader
import com.live.evo.util.LoginConfig
import com.live.evo.util.SkinConfig
import com.live.evo.util.TextStyleUtils
import com.live.evo.widget.IjkMediaController
import java.io.File
import java.util.regex.Pattern

/**
 * Controlador de mídia do catch-up (layout `live_catch_up_media_controller`): mostra canal/número/ícone, programa atual e próximo,
 * tempos, SeekBar e dicas das teclas (`catchup_*`); aplica estilos de texto conforme o modo (LoginConfig.flagA), ícones de
 * play/pause (play pode vir do skin `key_load_play_icon`) e cores da barra (`playback_seekbar_*_color` do skin).
 * [setPlayInfo] (original `C(x4.c)`) preenche logo, nome, programa atual e próximo.
 * Original: com/live/evo/catchup/player/a.java
 */
class CatchUpMediaController : IjkMediaController {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    private val appContext: Context = context
    private var channelLogo: ImageView? = null           // f5634v
    private var channelProgramPos: TextView? = null      // f5635w
    private var channelName: TextView? = null            // f5636x
    private var currentProgram: TextView? = null         // f5637y
    private var nextProgram: TextView? = null            // f5638z
    private var timeCurrent: TextView? = null            // A
    private var timeTotal: TextView? = null              // B
    private var catchupCurrent: TextView? = null         // C
    private var catchupNext: TextView? = null            // D
    private var catchupRewind: TextView? = null          // E
    private var catchupPause: TextView? = null           // F
    private var catchupForward: TextView? = null         // G
    private var catchupInfo: TextView? = null            // H
    private var catchupBack: TextView? = null            // I
    private var catchupSessionId: TextView? = null       // J
    private var seekBarView: SeekBar? = null             // K
    /** Botão play/pause. Original: getPauseButton() */
    var pauseButton: ImageButton? = null                 // M
        private set

    /** Estilos de texto: com `flagA` (tema 1) o tempo e o canal usam estilo c/b diferente do tema padrão. Original: B() */
    private fun applyTextStyles() {
        if (LoginConfig.get().flagA()) {
            TextStyleUtils.c(channelProgramPos); TextStyleUtils.c(channelName)
            TextStyleUtils.b(timeCurrent); TextStyleUtils.b(timeTotal); TextStyleUtils.b(catchupCurrent)
            TextStyleUtils.b(currentProgram); TextStyleUtils.b(catchupNext); TextStyleUtils.b(nextProgram)
        } else {
            TextStyleUtils.b(channelProgramPos); TextStyleUtils.c(channelName)
            TextStyleUtils.c(timeCurrent); TextStyleUtils.c(timeTotal); TextStyleUtils.b(catchupCurrent)
            TextStyleUtils.b(currentProgram); TextStyleUtils.b(catchupNext); TextStyleUtils.b(nextProgram)
        }
        TextStyleUtils.c(catchupRewind); TextStyleUtils.c(catchupPause); TextStyleUtils.c(catchupForward)
        TextStyleUtils.c(catchupInfo); TextStyleUtils.c(catchupBack); TextStyleUtils.b(catchupSessionId)
    }

    /**
     * Preenche logo do canal, nome, programa atual e o "próximo". Original: C(x4.c)
     * Atenção ao mapeamento real dos campos de [CatchUpPlayInfo] (x4.c): `i()` (setter `t`) é a URL do ícone do canal — guardada em
     * [CatchUpPlayInfo.catchupType] — e `c()` (setter `n`, 2ª chamada com `ChannelData.e()`) é o nome do canal — [CatchUpPlayInfo.channelIcon].
     * O campo `j()` (próximo programa) nunca é atribuído no app: o texto fica nulo.
     */
    fun setPlayInfo(info: CatchUpPlayInfo) {
        GlideImageLoader.load(context, info.catchupType, channelLogo!!)
        (info.channelNumber + 1).toString()    // valor calculado e descartado no original
        channelName!!.text = info.channelIcon
        currentProgram!!.text = info.title
        nextProgram!!.text = null
    }

    override fun getLayoutId(): Int = R.layout.live_catch_up_media_controller
    override fun getPauseIconDrawable(): Drawable = context.resources.getDrawable(R.drawable.play_pause_none)
    override fun getPauseIconId(): Int = R.drawable.play_pause_none

    /** Ícone de play: o do skin (`key_load_play_icon`) se existir no disco, senão `play_icon`. Original: getPlayIconDrawable() */
    override fun getPlayIconDrawable(): Drawable {
        val path = SkinConfig.get().playIconPath()
        var d: Drawable? = null
        if (!path.isNullOrEmpty() && File(path).exists()) d = Drawable.createFromPath(path)
        return d ?: context.resources.getDrawable(R.drawable.play_icon)
    }
    override fun getPlayIconId(): Int = R.drawable.play_icon

    /** Liga os widgets e aplica as cores do skin à SeekBar (progresso `#RRGGBB[AA]` sem vírgulas, thumb). Original: u(View) */
    override fun initControllerView(view: View) {
        super.initControllerView(view)
        channelLogo = view.findViewById(R.id.channel_logo)
        channelProgramPos = view.findViewById(R.id.channel_programpos)
        channelName = view.findViewById(R.id.channel_name)
        currentProgram = view.findViewById(R.id.current_program)
        nextProgram = view.findViewById(R.id.next_program)
        timeCurrent = view.findViewById(R.id.mediacontroller_time_current)
        timeTotal = view.findViewById(R.id.mediacontroller_time_total)
        seekBarView = view.findViewById(R.id.mediacontroller_seekbar)
        catchupCurrent = view.findViewById(R.id.catchup_current)
        catchupNext = view.findViewById(R.id.catchup_next)
        catchupRewind = view.findViewById(R.id.catchup_rewind)
        catchupPause = view.findViewById(R.id.catchup_pause)
        catchupForward = view.findViewById(R.id.catchup_forward)
        catchupInfo = view.findViewById(R.id.catchup_info)
        catchupBack = view.findViewById(R.id.catchup_back)
        catchupSessionId = view.findViewById(R.id.catchup_sessionid)
        pauseButton = view.findViewById(R.id.mediacontroller_play_pause)
        val hex = Pattern.compile("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})$")
        val progress = SkinConfig.get().seekbarProgressColor()
        if (!TextUtils.isEmpty(progress)) {
            val c = progress!!.replace(",", "")
            if (hex.matcher(c).matches()) {
                seekBarView!!.progressDrawable = ClipDrawable(ColorDrawable(Color.parseColor(c)), 19, 1)
                seekBarView!!.setBackgroundColor(appContext.resources.getColor(R.color.progressbar_playback_background))
            }
        }
        val thumb = SkinConfig.get().seekbarThumbColor()
        if (!TextUtils.isEmpty(thumb) && hex.matcher(thumb!!).matches()) {
            val g = seekBarView!!.thumb as GradientDrawable
            g.setColor(Color.parseColor(thumb))
            seekBarView!!.thumb = g
        }
        applyTextStyles()
    }
}

/** Adapter de banner (youth.banner) com URLs de imagem (anúncios do catch-up), via Glide. Original: com/live/evo/catchup/player/b.java */
class CatchUpBannerAdapter(private val context: Context, data: List<String>) :
    com.youth.banner.adapter.BannerAdapter<String, CatchUpBannerAdapter.ImageHolder>(data) {
    /** Original: b$a — holder de uma ImageView. */
    class ImageHolder(val imageView: ImageView) : androidx.recyclerview.widget.RecyclerView.ViewHolder(imageView)

    /** ImageView MATCH_PARENT com CENTER_CROP. */
    override fun onCreateHolder(parent: android.view.ViewGroup, viewType: Int): ImageHolder {
        val iv = ImageView(parent.context)
        iv.layoutParams = android.view.ViewGroup.LayoutParams(-1, -1)
        iv.scaleType = ImageView.ScaleType.CENTER_CROP
        return ImageHolder(iv)
    }

    /** Carrega [data] com Glide (sem cache de disco; erros ignorados). */
    override fun onBindView(holder: ImageHolder, data: String, position: Int, size: Int) {
        try {
            com.bumptech.glide.Glide.with(context).load(data).diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.NONE).into(holder.imageView)
        } catch (_: Exception) {}
    }
}
