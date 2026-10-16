package com.foxivid.ui.mobile.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.media.AudioManager
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.player.PlayerView
import com.foxivid.baselib.util.Callback
import com.foxivid.baselib.util.EcoModeHelper
import com.foxivid.baselib.util.ServerTime
import com.foxivid.ui.mobile.media.VolumeChangeObserver
import com.foxivid.ui.mobile.R
import com.foxivid.ui.mobile.ext.setVisible
import com.foxivid.ui.widget.MyButton
import com.foxivid.ui.widget.MyRelativelayout
import com.foxivid.ui.widget.MyRoundImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import tv.danmaku.ijk.media.player.IMediaPlayer
import java.util.Locale

/**
 * Player embutido do app mobile: envolve um [PlayerView] (ijkplayer) com controles (barra de
 * progresso/tempo para catch-up "playback" e VOD, botão play/pause, volume/mute, fullscreen, voltar,
 * lista de canais, mensagens de erro "sem sinal"/"sem rede"), gestos (volume/brilho/avanço) e
 * observação do volume do sistema.
 *
 * Mensagens do [Handler]: 36864 (+0) UPDATE_PROGRESS, +1 UPDATE_PLAYBACK_UI, +2 HIDE_CENTER_BOX,
 * +3 UPDATE_VOD_UI, +4 HIDE_CTRL, +5 NO_NETWORK, +6 NO_SIGNAL. Estados: IDLE -1, PLAYING 1,
 * PLAY_COMPLETED 2, SEEK 3.
 *
 * Nota de reconstrução: o código original tem um binding `p7.g` (layout `layout_my_video_view`) e
 * dezenas de trechos repetitivos de "if (binding == null) ...". Aqui está resumido; partes não
 * relevantes (visibilidade fina da barra inferior/topo em fullscreen: `I()`) estão marcadas.
 *
 * Métodos do `PlayerView` usados aqui com nomes legíveis (no original ofuscados): restart(tag,pos)=C, seekTo(pos)=E,
 * reload()=D(view,null,null,3,null), resume()=G, pause()=B, isPlayingState()=z, setStopped(true)=J(true).
 *
 * Original: com/tvc/lib/mobile/ui/widget/MyVideoView.java (b = SeekListener, c = corrotina de motivo de
 * "no signal", d = Handler, e = VolumeListener, f = resetTipMsg)
 */
class MyVideoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    /** Menu de VOD (interface vazia `a` no original). */
    interface OnVodMenuClickListener

    /** Stub do binding gerado `p7.g` (layout_my_video_view) com os nomes dos campos obfuscados. */
    abstract class VideoBinding : ViewDataBinding(null, null, 0) {
        abstract val bottomCtrl: View                       // f17382a
        abstract val retryButton: MyButton                  // f17383b
        abstract val centerView: MyRelativelayout           // f17384c
        abstract val videoView: PlayerView                  // f17385d
        abstract val loadingContainer: View                 // f17387f
        abstract val endTime: TextView                      // f17388g
        abstract val rootContainer: View                    // f17389h
        abstract val ivBack: AppCompatImageView             // f17390i
        abstract val ivFullScreen: AppCompatImageView       // f17391j
        abstract val ivVideoLove: AppCompatImageView        // f17392k
        abstract val ivVideoSound: AppCompatImageView       // f17393l
        abstract val vodMenu: View                          // f17394m
        abstract val ivNoSignal: ImageView                  // f17395n
        abstract val playPause: MyRoundImageView            // f17397p
        abstract val progressPlayback: SeekBar              // f17398q
        abstract val channelList: RecyclerView              // f17399r
        abstract val startTime: TextView                    // f17400s
        abstract val tipText: TextView                      // f17401t
        abstract val topView: View                          // f17402u
        abstract val titleText: TextView                    // f17405x
    }

    private val logger = LoggerFactory.getLogger(MyVideoView::class.java)

    private val stateIdle = -1
    private val statePlaying = 1
    private val statePlayCompleted = 2
    private val stateSeek = 3
    private var playState = -1

    private val messageBase = 36864
    val messageUpdateProgress = 36864
    val updatePlayBackUi = messageBase + 1
    val messageHideCenterBox = messageBase + 2
    val updateVodUi = messageBase + 3
    val hideCtrl = messageBase + 4
    val noNetwork = messageBase + 5
    val noSignal = messageBase + 6

    private var seekBarPosition = -1L
    private var pausePosition: Long? = 0L
    /** CoroutineLiveDataKt.DEFAULT_TIMEOUT = 5000 ms. */
    private val exitMenuTime = 5000L
    private var lastPosition: Long? = null
    private var lastDuration = 0L
    private var lastTime = 0L
    var isSlide = false
        private set
    private var volume = -1
    private var maxVolume = 0
    private var brightness = -1f
    private val speedList = listOf(1.0f, 1.5f, 2.0f)
    private var speedIndex = 0
    private var noSignalListener: Callback<Int>? = null
    private var loading: LoadingController? = null
    private var lastPlayTime = 0L
    private var tipNoSignalOrNoNetworkTime = 0L
    private var onErrorListener: IMediaPlayer.OnErrorListener? = null
    private var onCompletionListener: IMediaPlayer.OnCompletionListener? = null
    private var lastVolume: Int? = -1
    private val handler: Handler = VideoHandler(Looper.getMainLooper())
    private var window: Window? = null
    private var audioManager: AudioManager? = null
    var isPlayBack = false
        private set
    private var isVod = false
    private var startTime: TextView? = null
    private var endTime: TextView? = null
    private lateinit var videoView: PlayerView
    private var progressBar: SeekBar? = null
    private var binding: VideoBinding? = null
    private var isFullScreen = false
    private var isPlayBackInit = false
    private var isVodInit = false
    private var isPause = false
    private val hideCtrlTask = Runnable { hideBottomAndCenter(); hideTopView() }

    /** Controlador do indicador de loading (`com.tvc.lib.mobile.ui.widget.b` = interface do módulo; a()=hide, b()=show). */
    interface LoadingController {
        fun hide()   // a()
        fun show()   // b()
    }

    init {
        try {
            binding = DataBindingUtil.inflate<ViewDataBinding>(
                LayoutInflater.from(context), R.layout.layout_my_video_view, this, true
            ) as VideoBinding
        } catch (t: Throwable) {
            logger.error("inflater failure", t)
        }
        videoView = binding!!.videoView
        // original: z7.j.i(jVar, R.id.loading_layout_tvc_lib, R.color.white, binding.loadingContainer, 0, 8, null)
        loading = LoadingOverlay(binding!!.loadingContainer, R.id.loading_layout_tvc_lib, R.color.white, 0)   // z7.j.i(j, id, cor, container, 0, 8, null)
        val am = getContext().getSystemService("audio") as AudioManager
        audioManager = am
        maxVolume = am.getStreamMaxVolume(3)
        initVolumeButton()
        initVolumeObserver()
        initStreaming()
    }

    // --------------------------------------------------------------- listeners internos

    /** SeekBar: arrastar atualiza o tempo e, ao soltar, faz seek ou reinicia (se terminou). Original: MyVideoView$b */
    private inner class SeekListener : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
            if (fromUser && (playState == statePlaying || playState == statePlayCompleted)) {
                handler.removeMessages(messageUpdateProgress)
                seekBarPosition = progress.toLong() * getVideoDuration() / 1000L
                startTime?.text = formatTime(seekBarPosition)
            }
        }

        override fun onStartTrackingTouch(seekBar: SeekBar) { seekBarPosition = -1L }

        override fun onStopTrackingTouch(seekBar: SeekBar) {
            if (seekBarPosition != -1L) {
                if (playState == statePlayCompleted) {
                    // PlayerView.C("seek_to_<pos>", pos)
                    videoView.restart("seek_to_$seekBarPosition", seekBarPosition)
                    return
                }
                if (seekBarPosition >= getVideoDuration()) {
                    setPlayCompleted(null)
                    return
                }
                if (seekBarPosition == 0L) seekBarPosition = 1L
                videoView.seekTo(seekBarPosition) // PlayerView.E(long)
                handler.sendEmptyMessage(messageUpdateProgress)
            }
        }
    }

    /** Handler de mensagens da UI. Original: MyVideoView$d */
    private inner class VideoHandler(looper: Looper) : Handler(looper) {
        private var isNetworkConnected = true
        private var lastRvChannelItemPosition: Int? = null

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val what = msg.what
            val b = binding!!
            when (what) {
                messageUpdateProgress -> {
                    // reagenda para o próximo segundo cheio
                    sendMessageDelayed(obtainMessage(messageUpdateProgress), 1000L - (updateProgress() % 1000L))
                }
                updatePlayBackUi -> {
                    b.progressPlayback.setVisible(isPlayBack)
                    b.startTime.setVisible(isPlayBack)
                    b.endTime.setVisible(isPlayBack)
                    b.ivVideoSound.setVisible(true)
                    b.centerView.setVisible(isPlayBack)
                    b.ivVideoLove.setVisible(!isPlayBack)
                }
                updateVodUi -> {
                    b.progressPlayback.setVisible(isVod)
                    b.startTime.setVisible(isVod)
                    b.endTime.setVisible(isVod)
                    b.ivVideoSound.setVisible(!isVod)
                    b.centerView.setVisible(isVod)
                    b.ivVideoLove.setVisible(!isVod)
                    b.ivBack.setVisible(isVod)
                }
                messageHideCenterBox -> {
                    isSlide = false
                    findInRoot(R.id.app_video_volume_box).visibility = View.GONE
                    findInRoot(R.id.app_video_brightness_box).visibility = View.GONE
                    findInRoot(R.id.app_video_fastForward_box).visibility = View.GONE
                }
                hideCtrl -> {
                    if (b.channelList.visibility == View.VISIBLE) {
                        val lm = b.channelList.layoutManager as? LinearLayoutManager
                        if (lm != null) {
                            val first = lm.findFirstVisibleItemPosition()
                            if (lastRvChannelItemPosition == null || first != lastRvChannelItemPosition) {
                                lastRvChannelItemPosition = first
                                resetHideCtrlTimer()
                                return
                            }
                        }
                    }
                    setCtrlVisibility(8)
                }
                noNetwork, noSignal -> {
                    if (what == noNetwork) isNetworkConnected = false
                    if (videoView.isPlayingState()) { // PlayerView.z()
                        sendEmptyMessageDelayed(noNetwork, 2000L)
                        return
                    }
                    // d0.f21360a.j(): EcoModeHelper/estado do app -> retorna sem mostrar o botão
                    if (appIsInBackgroundOrEco()) return
                    b.retryButton.visibility = View.VISIBLE
                    b.retryButton.setOnClickListener {
                        videoView.reload() // PlayerView.D(this, null, null, 3, null)
                        resetNoSignal()
                        b.retryButton.visibility = View.GONE
                    }
                }
            }
        }
    }

    /** Observa o volume do sistema: troca o ícone mute/voz e mostra os controles. Original: MyVideoView$e */
    private val volumeListener = object : VolumeChangeListener {
        override fun onVolumeChanged(volume: Int) {
            val b = binding!!
            if (volume == 0) b.ivVideoSound.setImageResource(R.mipmap.voice_close)
            else if (volume > 0) b.ivVideoSound.setImageResource(R.mipmap.voice_open)
            resetHideCtrlTimer()
        }
    }

    /** Referência a `w7.a.c`. Original: w7/a$c */
    interface VolumeChangeListener { fun onVolumeChanged(volume: Int) }

    // --------------------------------------------------------------- init

    /** Zera volume/brilho do gesto e agenda o ocultamento do overlay central em 500 ms. Original: J() */
    private fun onGestureEnd() {
        volume = -1
        brightness = -1.0f
        handler.removeMessages(messageHideCenterBox)
        handler.sendEmptyMessageDelayed(messageHideCenterBox, 500L)
    }

    private fun initVolumeButton() {
        val vol = audioManager?.getStreamVolume(3)
        if (vol != null && vol <= 0) binding!!.ivVideoSound.setImageResource(R.mipmap.voice_close)
        binding!!.ivVideoSound.setOnClickListener {
            val current = audioManager?.getStreamVolume(3)
            if (current == null || current > 0) {
                // muta guardando o volume atual
                lastVolume = audioManager?.getStreamVolume(3)
                audioManager?.setStreamVolume(3, 0, 0)
                binding!!.ivVideoSound.setImageResource(R.mipmap.voice_close)
            } else {
                // sem volume: restaura o último (ou 50% do máximo), limitado a [0, max]
                var target = (maxVolume * 0.5).toInt()
                if (lastVolume!! > 0) target = lastVolume!!
                if (target > maxVolume) target = maxVolume else if (target < 0) target = 0
                audioManager?.setStreamVolume(3, target, 0)
                binding!!.ivVideoSound.setImageResource(R.mipmap.voice_open)
            }
        }
    }

    /** Registra o observador de volume do sistema (w7.a). Original: a0() */
    private fun initVolumeObserver() {
        val observer = VolumeChangeObserver(context)
        volumeObserver = observer
        observer.setListener { volume -> volumeListener.onVolumeChanged(volume) }
        if (!volumeObserverRegistered) {
            observer.register()
            volumeObserverRegistered = true
        }
    }

    /** Liga os listeners do PlayerView (info/prepared/error/completion), barra e play/pause. Original: R() */
    private fun initPlaybackControls() {
        progressBar = binding!!.progressPlayback
        startTime = binding!!.startTime
        endTime = binding!!.endTime
        progressBar?.max = 1000
        videoView.setOnInfoListener { _, what, _, _ -> onInfo(what) }
        videoView.setOnPreparedListener {
            hideTip()
            if (isPlayBack || isVod) handler.sendEmptyMessage(messageUpdateProgress)
            lastPlayTime = ServerTime.now()
        }
        videoView.setOnErrorListener { mp, what, extra -> onErrorListener?.onError(mp, what, extra); true }
        videoView.setOnCompletionListener { mp -> setPlayCompleted(mp) }
        progressBar?.setOnSeekBarChangeListener(SeekListener())
        binding!!.playPause.setOnClickListener { togglePlayPause() }
    }

    /** Eventos de info do player: 3 (rendering start), 701 (buffering start), 904 (rendering after seek)... Original: V(...) */
    private fun onInfo(what: Int): Boolean {
        if (what == 3 || what == 904) {
            playState = statePlaying
            if (isPlayBack || isVod) {
                handler.removeMessages(messageUpdateProgress)
                handler.sendEmptyMessage(messageUpdateProgress)
            }
            if (isVod) binding!!.vodMenu.visibility = View.VISIBLE
            showBottomAndCenter()
            handler.removeCallbacks(hideCtrlTask)
            handler.postDelayed(hideCtrlTask, exitMenuTime)
        } else if (what == 701) {
            if (playState != statePlaying && playState != stateIdle) {
                playState = statePlaying
                if (isPlayBack || isVod) {
                    handler.removeMessages(messageUpdateProgress)
                    handler.sendEmptyMessage(messageUpdateProgress)
                }
                showBottomAndCenter()
                handler.removeCallbacks(hideCtrlTask)
                handler.postDelayed(hideCtrlTask, exitMenuTime)
            }
        }
        else if (what == 10008 && (isPlayBack || isVod)) {
            // MEDIA_INFO_VIDEO_SEEK_RENDERING_START: atualiza o progresso
            handler.removeMessages(messageUpdateProgress)
            handler.sendEmptyMessage(messageUpdateProgress)
        }
        return false
    }

    /** Clique em play/pause (só em PLAYING/COMPLETED). Original: U(...) */
    private fun togglePlayPause() {
        if (playState == statePlaying || playState == statePlayCompleted) {
            val b = binding!!
            if (isPause) {
                b.playPause.background = resources.getDrawable(R.mipmap.playback_pause_icon)
                if (playState == statePlayCompleted) {
                    videoView.reload() // PlayerView.D(view, "update view <state>", null, 2, null)
                } else {
                    videoView.resume() // PlayerView.G()
                    handler.sendEmptyMessage(messageUpdateProgress)
                }
            } else {
                b.playPause.background = resources.getDrawable(R.mipmap.playback_play_icon)
                videoView.pause() // PlayerView.B()
                pausePosition = videoView.getPosition()
            }
            isPause = !isPause
        }
    }

    /** Loading e "no signal" vindos do PlayerView. Original: X() */
    private fun initStreaming() {
        videoView.setLoadingListener { show, _ ->
            if (show) { loading?.hide(); loading?.show() } // sic: b() e a() chamados em sequência no original
        }
        videoView.setNoSignalListener { reason, _ ->
            CoroutineScope(Dispatchers.Main).launch { handleNoSignalReason(reason) }
        }
    }

    /**
     * Mapeia o motivo ("reason") do PlayerView para mensagem/UI. Original: MyVideoView$c.invokeSuspend
     *  -1: reseta no-signal e tip; 0/8: timeout (imagem requesttimeout, agenda NO_NETWORK);
     *  1: media_not_free; 2: no_stream_server; 3/4: kick_out_tip; 5: update_latest_version_to_continue;
     *  6: sem sinal (imagem no_signal, agenda NO_SIGNAL); 7: no_channel_to_switch_in_list.
     */
    private fun handleNoSignalReason(reason: Int) {
        noSignalListener?.onResult(reason)
        val b = binding!!
        fun tip(res: Int) { b.tipText.visibility = View.VISIBLE; b.tipText.text = context.getString(res) }
        when (reason) {
            -1 -> { resetNoSignal(); hideTip() }
            0, 8 -> {
                loading?.hide()
                showNoSignal(R.drawable.requesttimeout)
                if (lastPlayTime >= tipNoSignalOrNoNetworkTime) {
                    tipNoSignalOrNoNetworkTime = ServerTime.now()
                    handler.sendMessage(handler.obtainMessage(noNetwork))
                }
            }
            1 -> { tip(R.string.media_not_free); loading?.hide() }
            2 -> { loading?.hide(); tip(R.string.no_stream_server) }
            3, 4 -> { tip(R.string.kick_out_tip); loading?.hide() }
            5 -> { loading?.hide(); tip(R.string.update_latest_version_to_continue) }
            6 -> {
                loading?.hide()
                showNoSignal(R.drawable.no_signal)
                if (lastPlayTime >= tipNoSignalOrNoNetworkTime) {
                    tipNoSignalOrNoNetworkTime = ServerTime.now()
                    handler.sendMessage(handler.obtainMessage(noSignal))
                }
            }
            7 -> { loading?.hide(); tip(R.string.no_channel_to_switch_in_list) }
        }
    }

    // --------------------------------------------------------------- estado / UI

    private fun setPlayCompleted(mediaPlayer: IMediaPlayer?) {
        isPause = true
        handler.removeMessages(messageUpdateProgress)
        videoView.stop(true)
        playState = statePlayCompleted
        // a barra mostra o tempo total como tempo atual
        startTime?.let { st -> endTime?.let { et -> st.text = et.text } }
        binding!!.tipText.visibility = View.VISIBLE
        binding!!.tipText.text = context.getString(R.string.vod_play_complete)
        post { onCompletionListener?.onCompletion(mediaPlayer) }
    }

    /** mm:ss ou hh:mm:ss (Locale.ENGLISH). Original: K(long) */
    fun formatTime(timeMs: Long): String {
        val s = timeMs / 1000
        val sec = s % 60
        val min = (s / 60) % 60
        val hour = s / 3600
        return if (hour > 0) String.format(Locale.ENGLISH, "%02d:%02d:%02d", hour, min, sec)
        else String.format(Locale.ENGLISH, "%02d:%02d", min, sec)
    }

    private fun hideBottomAndCenter() {              // L()
        binding!!.centerView.visibility = View.GONE
        binding!!.bottomCtrl.visibility = View.GONE
        // original continua com I() (ajuste de visibilidade da barra inferior em fullscreen; sem efeito visível)
    }

    private fun hideTopView() {                      // M()
        binding!!.topView.visibility = View.GONE
        if (BaseLibConfig.isDebug) logger.debug("player_ctrl hideTopView")
    }

    private fun showTopView() {                      // n0()
        binding!!.topView.visibility = View.VISIBLE
        if (BaseLibConfig.isDebug) logger.debug("player_ctrl showTopView")
    }

    private fun showBottomAndCenter() {              // m0()
        if (isPlayBack || isVod) binding!!.centerView.visibility = View.VISIBLE
        binding!!.bottomCtrl.visibility = View.VISIBLE
    }

    /** Procura uma view dentro do container raiz. Original: N(int) */
    fun findInRoot(resId: Int): View = binding!!.rootContainer.findViewById(resId)

    /** Mostra/oculta os controles conforme modo (fullscreen/playback). Original: setCtrlVisibility(int) */
    fun setCtrlVisibility(visibility: Int) {
        if (BaseLibConfig.isDebug) {
            logger.debug(if (visibility == 0) "player_ctrl showCtrlView" else "player_ctrl hideCtrlView")
        }
        if (visibility == 0) {
            showTopView(); showBottomAndCenter()
        } else {
            hideTopView(); hideBottomAndCenter()
        }
        val b = binding!!
        if (!isFullScreen) {
            b.channelList.visibility = View.GONE
            if (isPlayBack) b.playPause.visibility = visibility
            return
        }
        if (!isPlayBack) {
            if (visibility == 8) b.channelList.visibility = visibility
            return
        }
        b.channelList.visibility = View.GONE
        b.playPause.visibility = visibility
    }

    private fun showNoSignal(resId: Int?) {          // f0 + setNoSignalImage
        videoView.setStopped(true) // PlayerView.J(true)
        try {
            binding!!.ivNoSignal.setImageResource(resId ?: R.drawable.no_signal)
            binding!!.ivNoSignal.visibility = View.VISIBLE
        } catch (e: Exception) {
        }
    }

    /** Esconde a imagem de sem sinal e o botão de retry e marca lastPlayTime. Original: g0() */
    fun resetNoSignal() {
        val b = binding!!
        if (b.ivNoSignal.visibility != View.INVISIBLE) b.ivNoSignal.visibility = View.INVISIBLE
        if (b.retryButton.visibility == View.VISIBLE) b.retryButton.visibility = View.GONE
        lastPlayTime = ServerTime.now()
    }

    /** Limpa a mensagem de dica (tipText) no Main. Original: h0() / MyVideoView$f */
    fun hideTip() {
        if (binding!!.tipText.visibility != View.GONE) {
            CoroutineScope(Dispatchers.Main).launch {
                binding!!.tipText.visibility = View.GONE
                binding!!.tipText.text = ""
            }
        }
    }

    /** Reagenda (8 s) o ocultamento dos controles. Original: q0() */
    fun resetHideCtrlTimer() {
        handler.removeMessages(hideCtrl)
        handler.sendMessageDelayed(handler.obtainMessage(hideCtrl), 8000L)
    }

    /** Alterna a visibilidade dos controles. Original: r0() */
    fun toggleCtrl() {
        resetHideCtrlTimer()
        setCtrlVisibility(if (binding!!.topView.visibility == View.VISIBLE) 8 else 0)
    }

    /** Chamado ao trocar de programa/canal. Original: o0(boolean isProgrammeChanged) */
    fun onProgrammeSwitch(isProgrammeChanged: Boolean) {
        resetNoSignal()
        setCtrlVisibility(0)
        resetHideCtrlTimer()
        hideTip()
        if (isProgrammeChanged) {
            progressBar?.progress = 0
            startTime?.text = "00:00"
            endTime?.text = "--:--"
            lastDuration = 0L
            lastPosition = 0L
        }
        binding!!.retryButton.visibility = View.GONE
    }

    /**
     * Atualiza barra/tempos a cada segundo; detecta retomada após pausa (se a posição avançou).
     * Retorna a posição atual. Original: d0()
     */
    fun updateProgress(): Long {
        val position = getVideoCurrentPosition()
        val last = lastPosition
        if (last != null && position > last && ServerTime.now() - lastTime <= 2000 && isPause && (isPlayBack || isVod)) {
            binding!!.playPause.background = resources.getDrawable(R.mipmap.playback_pause_icon)
            isPause = !isPause
        }
        val duration = getVideoDuration()
        if (duration > 0 && position > 0) {
            val progress = (1000 * position) / duration
            progressBar?.progress = progress.toInt()
            startTime?.text = formatTime(position)
            endTime?.text = formatTime(duration)
            if (lastDuration != duration) lastDuration = duration
            if (lastPosition == null || lastPosition != position) {
                lastPosition = position
                hideTip()
            }
        }
        lastTime = ServerTime.now()
        return position
    }

    private fun getVideoCurrentPosition(): Long = videoView.getPosition()

    /** Duração (ou a última conhecida se 0). Original: getVideoDuration() */
    fun getVideoDuration(): Long {
        val d = videoView.getDuration()
        return if (d == 0L) lastDuration else d
    }

    fun isPlayCompleted(): Boolean = playState == statePlayCompleted // c0()

    // --------------------------------------------------------------- API pública

    fun setFullScreenModel(fullScreen: Boolean) {
        isFullScreen = fullScreen
        val b = binding!!
        b.ivBack.setVisible(isFullScreen)
        b.ivFullScreen.setImageResource(if (isFullScreen) R.drawable.player_exit_full_screen else R.drawable.player_enter_full_screen)
        // Em fullscreen o título "A\nB" vira "A - B"; ao sair, volta
        val text = b.titleText.text.toString()
        b.titleText.text = if (isFullScreen) text.replace("\n", " - ") else text.replace(" - ", "\n")
    }

    /** Gestos (volume/brilho/avanço) sobre o container de loading. Original: setGestureListener(OnGestureListener) */
    fun setGestureListener(listener: GestureDetector.OnGestureListener) {
        val detector = GestureDetector(context, listener)
        binding!!.loadingContainer.isClickable = true
        binding!!.loadingContainer.setOnTouchListener { _, event ->
            if ((event.action and 255) == 0) {
                handler.removeCallbacks(hideCtrlTask)
                handler.postDelayed(hideCtrlTask, exitMenuTime)
            }
            if ((event.action and 255) == 1) onGestureEnd()
            detector.onTouchEvent(event)
        }
    }

    fun setNoSignalListener(listener: Callback<Int>) { noSignalListener = listener }
    fun setOnCompletionListener(listener: IMediaPlayer.OnCompletionListener) { onCompletionListener = listener }
    fun setOnErrorListener(listener: IMediaPlayer.OnErrorListener) { onErrorListener = listener }
    fun setOnMenuClickListener(listener: OnVodMenuClickListener) {}
    fun setWindow(window: Window) { this.window = window }
    fun setTrialImg(@DrawableRes imgResId: Int) { videoView.setTrialImg(imgResId) }

    /** Modo catch-up/playback: mostra barra de progresso e inicializa os controles uma vez. Original: setPlayBackMode */
    fun setPlayBackMode(isPlayBack: Boolean) {
        this.isPlayBack = isPlayBack
        handler.sendEmptyMessage(updatePlayBackUi)
        if (!isPlayBack) {
            handler.removeMessages(messageUpdateProgress)
            return
        }
        playState = stateIdle
        lastPosition = null
        lastTime = 0L
        handler.removeMessages(messageUpdateProgress)
        handler.sendEmptyMessage(messageUpdateProgress)
        if (isPlayBackInit) return
        initPlaybackControls()
        isPlayBackInit = true
    }

    /** Modo VOD. Original: setVodMode */
    fun setVodMode(isVod: Boolean) {
        this.isVod = isVod
        if (isVod) {
            playState = stateIdle
            lastPosition = null
            lastTime = 0L
            handler.removeMessages(messageUpdateProgress)
            handler.sendEmptyMessage(messageUpdateProgress)
            if (!isVodInit) {
                initPlaybackControls()
                binding!!.vodMenu.setOnClickListener { /* l0: sem corpo (getClass()) */ }
                isVodInit = true
            }
        } else {
            handler.removeMessages(messageUpdateProgress)
        }
        handler.sendEmptyMessage(updateVodUi)
    }

    fun getVideoView(): PlayerView = videoView
    fun getViewBinding(): VideoBinding = binding!!

    // --------------------------------------------------------------- dependências fora do módulo

    /** `d0.f21360a.j()` = [EcoModeHelper.isInEcoMode]: no modo eco não se mostra o botão de repetir. */
    private fun appIsInBackgroundOrEco(): Boolean = EcoModeHelper.isInEcoMode()

    private var volumeObserver: VolumeChangeObserver? = null          // mVolumeChangeObserver (w7.a)
    private var volumeObserverRegistered = false                       // mVolumeChangeRegister
}
