package com.foxivid.baselib.player

import android.content.Context
import android.net.Uri
import android.os.Handler
import android.os.Looper
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.streaming.engine.PlayType
import com.foxivid.baselib.streaming.server.StreamingKeys
import com.google.gson.Gson
import org.slf4j.LoggerFactory
import tv.danmaku.ijk.media.player.IMediaPlayer
import java.util.concurrent.atomic.AtomicLong

/**
 * Original: x1/f1/lb/widget/videoview/z0.java ("VideoViewHandler.kt") — ~4.500 linhas.
 *
 * RECONSTRUÇÃO PARCIAL: só o caminho "URL → IMediaPlayer → superfície" e os mecanismos de recuperação
 * relevantes para o pipeline. Ficaram de fora o tratamento detalhado de renderização/aspect-ratio, legendas,
 * pausa/seek de VoD, posição persistida, eventos de servidor de stream e métricas.
 *
 * Fluxo principal:
 * 1. [setVideoPath] (z0.F2): guarda URL/sessão/tipo; timeout de gateway = 90 s (catch-up) ou 30 s;
 *    agenda o watchdog e dispara a abertura.
 * 2. [openVideo] (z0.Y1): `PlayerManager.create(url, decodeMode, hwFlag, playerArgs, type, session)`, liga
 *    listeners e, no callback do PlayerInfo (z0$l → bloco em ~linha 1200 do jadx), [bindAndPrepare].
 * 3. [bindAndPrepare]: acrescenta `&<playerKey>=<player.hashCode()>` à URL (o proxy valida esse id),
 *    `setDataSource(context, uri)` + `prepareAsync()` (com reset/retry em IllegalStateException).
 *    Falha ⇒ onError(player, 1, 405).
 */
class VideoViewHandler(private var mContext: Context?) : com.foxivid.baselib.metric.monitor.PlayerMonitorListener {

    private val logger = LoggerFactory.getLogger(VideoViewHandler::class.java)

    /** Original: z0.mSession */
    val mSession = AtomicLong(0)
    private var mPlayUri: String? = null
    private var mVideoName: String? = null
    private var mPlayType: PlayType = PlayType.LIVE
    private var mPlayerArgs: String? = null
    private var mHardwareDecodeFlag: Long = 1
    private var mGatewayTimeoutMillis: Long = 30000L
    private var mPlayerInfo: PlayerInfo? = null
    private var mBufferPercent = 0
    private var mVideoWidth = 0
    private var mVideoHeight = 0
    private var mIsForceStop = false
    private var mIsCompleted = false
    private var mMediaBufferingBeginTime: Long = 0
    private var lastSentBufferingRestartEventTime: Long = 0
    private var sendRestartCnt = 0
    private var isRenderRetryFailed = false
    private var mHandler: Handler? = null
    private var mOnErrorListener: IMediaPlayer.OnErrorListener? = null

    /** Original: z0.F2(videoName, url, playerArgs, playType, session) */
    fun setVideoPath(videoName: String?, url: String?, playerArgs: String?, playType: PlayType, session: Long): Boolean {
        if (url == null) return false
        // Original: S2(url, session) — se é a mesma URL/sessão já tocando, ignora
        if (mSession.get() != session || mVideoName != videoName) {
            mSession.set(session)
            // Original: mostra "connecting" (R.string.connecting)
        }
        mGatewayTimeoutMillis = if (playType == PlayType.CATCHUP) 90000L else 30000L
        mPlayUri = url
        mPlayType = playType
        mIsForceStop = false
        mVideoName = videoName
        mPlayerArgs = playerArgs
        // Original: remove e re-agenda mGatewayTimeoutHandler (postDelayed mGatewayTimeoutMillis);
        //  se mIsCompleted ⇒ seek 0 e reabre; senão abre em coroutine IO (z0$o).
        openVideo(url, PlayerManager.decodeMode())
        return true
    }

    /** Original: z0.Y1(z0, decodeMode, url, ...) — cria o player e liga listeners. */
    @Synchronized
    private fun openVideo(url: String, decodeMode: Int) {
        if (BaseLibConfig.isDebug) logger.debug("decoder_setting: $decodeMode, ${if (decodeMode == 1) 0 else 1}, $mHardwareDecodeFlag")
        val info = PlayerManager.create(url, decodeMode, mHardwareDecodeFlag, mPlayerArgs, mPlayType, mSession.get())
        mPlayerInfo = info
        // Original: C1/r1/u1 — listeners (prepared, info, error, completion, seek, size changed, buffering)
        info.withPlayer { bindAndPrepare(it, info, url) }
    }

    /** Original: bloco z0$l.a(IMediaPlayer) (~linha 1200 do jadx limpo) */
    private fun bindAndPrepare(player: IMediaPlayer, info: PlayerInfo, playUrl: String?) {
        if (playUrl == null) { logger.error("play url is empty"); return }
        val playerId = player.hashCode()
        val status = info.status
        if (status == 0 || status == 5) {
            info.status = 1
            mBufferPercent = 0
            try {
                val url = if (playUrl.contains("?")) "$playUrl&${StreamingKeys.playerKey}=$playerId"
                          else "$playUrl?${StreamingKeys.playerKey}=$playerId"
                mVideoWidth = 0; mVideoHeight = 0
                val uri = Uri.parse(url)
                try {
                    player.setDataSource(mContext, uri)
                    if (BaseLibConfig.isDebug) logger.debug("zapping_time_opt set_url_to_player player[{}]", player.hashCode())
                } catch (_: IllegalStateException) {
                    player.reset(); player.setDataSource(mContext, uri)
                }
                try { player.prepareAsync() } catch (_: IllegalStateException) {
                    player.reset(); player.setDataSource(mContext, uri); player.prepareAsync()
                }
                logger.info("set media_player [$mPlayType][$mVideoName] session[${mSession.get()}] [$url]")
            } catch (t: Throwable) {
                logger.error("start player failure [{}] [{}] session[{}], player[ {} ], uri[ {} ]", mPlayType, mVideoName, mSession.get(), playerId, playUrl, t)
                mOnErrorListener?.onError(player, 1, 405)
            }
            return
        }
        // status 1..4: o player já foi iniciado
        val current = mPlayerInfo
        if (info !== current) {
            // o PlayerInfo ficou obsoleto (outro player assumiu): só registra e sai
            logger.warn("player@{}/{} [{}][{}] session[{}] init failure, player@{}/{} status={}", infoText(player), info.hashCode(), mPlayType, mVideoName, mSession.get(),
                infoText(current?.mediaPlayer), current?.hashCode(), current?.status)
            return
        }
        logger.warn("player@{} [{}][{}] session[{}] init failure, player status={}", infoText(player), mPlayType, mVideoName, mSession.get(), status)
    }

    /** "<classe>[<hash>]" do player para logs ("null" se nulo). Original: i1(IMediaPlayer) */
    private fun infoText(player: IMediaPlayer?): String = if (player == null) "null" else String.format(java.util.Locale.ENGLISH, "%s[%d]", player.javaClass.simpleName, player.hashCode())

    /**
     * Original: z0$?.f() — vídeo tocando com dimensões 0x0: reabre o player dobrando "probesize"
     * (até o limite "enlargeprobesize", padrão 5.600.000) via playerArgs JSON alterado.
     */
    private fun retryMissingDimensions() {
        val url = mPlayUri ?: return
        val probe = PlayerManager.probeSize()
        val doubled = probe shl 1
        val limit = PlayerManager.enlargeProbeSize()
        if (isRenderRetryFailed) { if (doubled > limit) return else isRenderRetryFailed = false }
        if (doubled > limit) {
            logger.error("[$mPlayType][$mVideoName] session[${mSession.get()}] render handle_missing_dimensions, Failed to detect dimensions even after retry.")
            isRenderRetryFailed = true; return
        }
        logger.warn("[$mPlayType][$mVideoName] session[${mSession.get()}] render handle_missing_dimensions, Video dimensions [0 x 0] while playing. Retrying probesize[$probe -> $doubled]...")
        val args = LinkedHashMap(PlayerManager.playerArgs()).apply { put("probesize", doubled.toString()) }
        mPlayerArgs = Gson().toJson(args)
        // Original: N2(false) e reabre o mesmo URL no mHandler
        openVideo(url, PlayerManager.decodeMode())
    }

    /** Original: z0.v2(OnErrorListener) */
    fun setOnErrorListener(l: IMediaPlayer.OnErrorListener) { mOnErrorListener = l }

    /**
     * Retoma/inicia o player atual: `player.start()` (só se a view está visível — ver [startPlayer]); se deu certo marca o status 3
     * (tocando). Original: z0.H2() + classe `z0$p`
     */
    fun start(): Boolean {
        mIsPaused = false
        val caller = com.foxivid.baselib.util.StackTraceUtils.callerName(3)
        val info = mPlayerInfo ?: return false
        var ok = false
        info.withPlayer { player ->
            ok = startPlayer(player, caller, false)   // z0.J2 -> I2(player, from, isForce)
            if (ok) info.status = 3
        }
        return ok
    }

    /** Dá `start()` no player se a view está visível (ou [force]). Original: I2(IMediaPlayer, String, boolean) */
    fun startPlayer(player: IMediaPlayer, from: String, force: Boolean): Boolean {
        if (force || isViewShown()) {
            try { player.start(); mIsPaused = false; return true }
            catch (e: Exception) { logger.error("pause player failure", e); return false }
        }
        logger.warn("[{}][{}][{}] from[{}] video view is not shown, ignored start play {}", mPlayType, mVideoName, mSession.get(), from, infoText(player))
        return false
    }

    /** Pausa o player atual (só com player preparado); status passa a 4 e some o loading. Original: U1(String) */
    fun pause(from: String): Boolean {
        val info = mPlayerInfo
        val player = currentPlayer(null)
        if (info != null && player != null && preparedTime > 0) {
            try {
                player.pause()
                mIsPaused = true
                info.status = 4
                unregisterFromEventBus()
                hideLoading()
                logger.debug("[{}][{}] session[{}] player paused[{}]", mPlayType, mVideoName, mSession.get(), from)
                return true
            } catch (_: Throwable) {}
        }
        return false
    }

    // ------------------------------------------------------------------ estado de reprodução (campos de z0 usados pelos monitores)
    var mIsPaused = false
    var lastSeekCompletePosition = 0L
    var preparedTime = 0L
    var renderTime = 0L
    private val startPlayInitTime = AtomicLong(0)
    private var isLoading = false
    private var lastTipMsg: String? = null
    private var latestPlayPosition = 0L
    private var lastSavedPosition = 0L
    private var mVideoDuration = 0L
    private var downloadThousand = 0
    private var isPlayPositionKeepMoving = false
    private var lastSession = 0L
    var loadingListener: ((Boolean, String) -> Unit)? = null     // z0.h1 (setLoadingListener)
    var noSignalListener: ((Int, String) -> Unit)? = null        // z0.j1
    var playCompleteListener: (() -> Unit)? = null               // z0.q1
    private var mOnRenderCompleteListener: Runnable? = null
    private var mOnMediaBufferPlayHandler: Runnable? = null
    private var mOnMediaBufferAnimationHandler: Runnable? = null
    private var mGatewayTimeoutHandler: Runnable? = null
    private var mPlayerMeter: PlayerMeter? = null
    private var checkPlayingHandler: CheckPlaying? = null

    /** A view hospedeira está visível? Original: L1() */
    private fun isViewShown(): Boolean = mVideoView?.isShown() == true

    /** Player atual se o PlayerInfo informado (ou o corrente) está ativo (status 2..4). Original: Y0(j) + J1(j) */
    private fun currentPlayer(info: PlayerInfo?): IMediaPlayer? {
        val cur = mPlayerInfo
        if (info != null && cur != null && info.playerId != cur.playerId) { logger.debug("player_changed"); return null }
        val target = info ?: cur ?: return null
        return if (target.status == 2 || target.status == 3 || target.status == 4) target.mediaPlayer else null
    }

    /** Preparado e tocando (`isPlaying`). Original: I1() */
    private fun isPlayingNow(): Boolean {
        val p = currentPlayer(null) ?: return false
        return try { preparedTime > 0 && p.isPlaying } catch (_: Throwable) { false }
    }

    /** Em buffering prolongado (tocando mas com `mMediaBufferingBeginTime` > 0). Original: G1() */
    private fun isBuffering(): Boolean = isPlayingNow() && mMediaBufferingBeginTime > 0

    /** Posição atual do player (-1 se indisponível). Original: N0() */
    fun currentPosition(): Long {
        val p = currentPlayer(null)
        if (p == null || preparedTime <= 0) return -1L
        return try { p.currentPosition } catch (_: Throwable) { -1L }
    }

    /** Duração (cacheada em [mVideoDuration]; senão a do player se status 3). Original: T0(IMediaPlayer) */
    private fun durationOf(player: IMediaPlayer?): Long {
        if (player == null) return 0L
        return try {
            if (mVideoDuration > 0) mVideoDuration
            else if (mPlayerInfo?.status != 3) 0L else player.duration
        } catch (_: Throwable) { 0L }
    }

    /** Esconde o loading (listener ou `videoView.stopAnimation`) na main thread. Original: Q2() + R2(z0) */
    private fun hideLoading() {
        if (!isLoading) return
        mHandler?.post {
            isLoading = false
            val l = loadingListener
            if (l != null) l(false, "") else mVideoView?.stopAnimation()
        }
    }

    /** Mostra o loading com [msg] (vazio → "loading"), na main thread; evita repetir a mesma mensagem. Original: K2(String) + M2 */
    fun showLoading(msg: String = "") {
        if (mIsCompleted || mIsForceStop) return
        if (lastTipMsg == msg && isLoading) return
        lastTipMsg = msg
        isLoading = true
        mHandler?.post {
            var text = msg
            if (text.isEmpty()) text = mContext?.getString(com.live.evo.R.string.loading) ?: ""
            val l = loadingListener
            if (l != null) { l(true, text); return@post }
            if (mVideoView?.k(text) == true) mPlayerMeter?.resetTraffic()
        }
    }

    /** Esconde o "sem sinal"/tip. Original: l1() */
    private fun hideNoSignal() {
        val l = noSignalListener
        if (l != null) l(-1, "") else mVideoView?.e()
    }

    /** Esconde loading e tip. Original: k1() */
    private fun hideLoadingAndTip() {
        loadingListener?.invoke(false, "")
        mVideoView?.f()
    }

    /** Zera o início do buffering. Original: F0(PlayerInfo) */
    private fun clearBuffering() { mMediaBufferingBeginTime = 0L }

    /** Remove as mensagens pendentes [what] do player de [info] no [mHandler]. Original: b2(PlayerInfo, int) */
    private fun cancelMessage(info: PlayerInfo?, what: Int) {
        if (info == null) return
        mHandler?.removeMessages(what, info.playerId)
    }

    /** Agenda a mensagem [what] (com o id do player) após [delayMillis]. Original: k2(PlayerInfo, int, long) */
    private fun scheduleMessage(info: PlayerInfo?, what: Int, delayMillis: Long) {
        val h = mHandler ?: return
        if (info != null) h.sendMessageDelayed(h.obtainMessage(what, info.playerId), delayMillis)
    }

    /** Cancela os agendamentos do watchdog/medidor. Original: c2() */
    private fun cancelAllScheduled() {
        cancelMessage(mPlayerInfo, 10002)
        cancelMessage(mPlayerInfo, 701)           // IMediaPlayer.MEDIA_INFO_VIDEO_DECODED_START? (constante usada no original)
        cancelMessage(mPlayerInfo, 10003)
        cancelMessage(mPlayerInfo, 10001)
    }

    /** Parar de ouvir eventos do EventBus (`util.e0.b(this)`). Original: T2() */
    private fun unregisterFromEventBus() { org.greenrobot.eventbus.EventBus.getDefault().unregister(this) }

    /** Salva a posição de VoD/catch-up (se mudou) em IO. Original: i2(long) */
    private fun savePosition(position: Long) {
        if (mPlayType == PlayType.LIVE || position == lastSavedPosition) return
        logger.debug("play_position saved. [{}][{}] session[{}] player[{} position[{}] lastSaved[{}]", mPlayType, mVideoName, mSession.get(),
            infoText(mPlayerInfo?.mediaPlayer), position, lastSavedPosition)
        lastSavedPosition = position
    }

    /** Duração do buffering atual em ms. Original: C0() */
    private fun bufferingMillis(): Long = if (mMediaBufferingBeginTime <= 0) 0L else com.foxivid.baselib.util.ServerTime.elapsedNow() - mMediaBufferingBeginTime

    private var mVideoView: VideoViewContract? = null
    private var mRenderView: RenderView? = null

    /**
     * Original: z0.m1(context, videoView, renderView) — reinicia todo o estado (taxa, decoder por hardware=1, listeners,
     * buffer=-1, seek=-1, dimensões 0, aspecto 0), guarda context/videoView e cria os Runnables de buffering/animação
     * e o `OnBufferingUpdateListener`. Depois: q1(), A1(), E1(), B1() (inicializações de handler/listeners —
     * não reconstruídas) e D1(renderView) (registra o [RenderCallback] na [RenderView]).
     */
    fun attach(context: Context, videoView: VideoViewContract, renderView: RenderView) {
        mContext = context
        mVideoView = videoView
        mRenderView = renderView
        mHardwareDecodeFlag = 1
        mPlayerInfo = null
        mBufferPercent = -1
        mVideoWidth = 0
        mVideoHeight = 0
        mHandler = MainHandler(Looper.getMainLooper())                    // q1()
        mOnMediaBufferPlayHandler = Runnable { checkBufferingRestart() }  // z0.n1 -> l2()
        mOnMediaBufferAnimationHandler = Runnable { showLoading() }       // z0.o1 -> L2(null)
        mPlayerMeter = PlayerMeter()                                       // A1()
        mGatewayTimeoutHandler = Runnable {                                // E1() -> F1(z0)
            val info = mPlayerInfo
            if (isViewShown() && info != null) info.withPlayer { mOnErrorListener?.onError(it, 1, 404) }   // z0$j: onError(player, 1, TYPE_PERCENT_HEIGHT=404)
        }
        com.foxivid.baselib.metric.monitor.PlayerMonitor.setMonitor(this)  // B1(): f.s(this)
        checkPlayingHandler = CheckPlaying()
        // D1(renderView): mRenderView já foi atribuído acima
    }

    /** Buffering prolongado: usa [bufferingMillis] como argumento para [checkBufferingRestart] e reagenda o handler. Original: l2() */
    private fun checkBufferingRestart() {
        if (mMediaBufferingBeginTime <= 0) return
        val now = com.foxivid.baselib.util.ServerTime.elapsedNow()
        val last = lastSentBufferingRestartEventTime
        if (last <= 0) { lastSentBufferingRestartEventTime = now; return }
        if (now - last < mGatewayTimeoutMillis) return
        val millis = bufferingMillis()
        if (millis < mGatewayTimeoutMillis) return
        sendRestartCnt++
        val ev = PlayerRestartEvent(mSession.get(), 1, sendRestartCnt, "buffering")
        logger.warn("player buffering [ {} ms ], [{}][{}] send player restart event@{} cnt[{}]", millis, mPlayType, mVideoName, ev.hashCode(), sendRestartCnt)
        lastSentBufferingRestartEventTime = now
        org.greenrobot.eventbus.EventBus.getDefault().postSticky(ev)   // xe.c.c().o(...)
        mOnMediaBufferPlayHandler?.let { mHandler?.removeCallbacks(it); mHandler?.postDelayed(it, mGatewayTimeoutMillis) }
    }

    /**
     * Handler da main thread (classe `z0$f`): 10000 = código de evento do motor (limitado a 1 por código a cada 2 s);
     * 10001 = watchdog [CheckPlaying]; 10002 = [PlayerMeter]; 10003 = animação de buffering. Mensagens carregam o id do player e só rodam
     * se ele ainda é o atual e a reprodução não terminou/foi forçada a parar.
     */
    private inner class MainHandler(looper: Looper) : Handler(looper) {
        private val lastMsgTime = java.util.concurrent.ConcurrentHashMap<Int, Long>()

        private fun runIfCurrent(task: Runnable?, playerId: Any?) {
            synchronized(this@VideoViewHandler) {
                if (!mIsCompleted && !mIsForceStop) {
                    if (mPlayerInfo?.playerId == playerId) task?.run()
                }
            }
        }

        override fun handleMessage(msg: android.os.Message) {
            when (msg.what) {
                10000 -> try {
                    val code = msg.obj as Int
                    val playerId = msg.arg1
                    synchronized(this@VideoViewHandler) {
                        val info = mPlayerInfo
                        if (info == null || playerId == info.playerId) {
                            if (isThrottled(code)) return
                            onStreamingEvent(mPlayerInfo, code)
                        }
                    }
                } catch (t: Throwable) {
                    logger.warn("[{}][{}] session[{}] invalid stream event: {}", mPlayType, mVideoName, mSession.get(), t.message)
                }
                10001 -> runIfCurrent(checkPlayingHandler, msg.obj)
                10002 -> runIfCurrent(mPlayerMeter, msg.obj)
                10003 -> runIfCurrent(mOnMediaBufferAnimationHandler, msg.obj)
            }
        }

        /** Mesmo código em menos de 2 s é ignorado. Original: b(int) */
        private fun isThrottled(code: Int): Boolean {
            val now = com.foxivid.baselib.util.ServerTime.elapsedNow()
            val last = lastMsgTime[code]
            if (last != null && now - last < 2000) return true
            lastMsgTime[code] = now
            return false
        }
    }

    /**
     * Código de evento do streaming recebido do motor (-4000 timeout PRT, 4101, 4003, ...). Original: g1(PlayerInfo, int) — corpo longo; aqui
     * apenas o essencial: registra a métrica, e para -4000 sem player preparado dispara o timeout do gateway. Os demais códigos
     * (4003/4004/1000..1004/4101...) viram avisos de "sem sinal" via [noSignalListener] com os motivos descritos em LiveNewActivity.onNoSignal.
     */
    private fun onStreamingEvent(info: PlayerInfo?, code: Int) {
        com.foxivid.baselib.metric.monitor.PlayerMonitor.onStreamEvent(code)
        when (code) {
            -4000 -> {
                if (preparedTime == 0L) {
                    mGatewayTimeoutHandler?.let { mHandler?.removeCallbacks(it); mHandler?.post(it) }
                } else logger.error("[{}][{}] session[{}] prt connection is timeout in playing", mPlayType, mVideoName, mSession.get())
            }
            -1000 -> {}
            4101 -> noSignalListener?.invoke(4, mContext?.getString(com.live.evo.R.string.session_logout) ?: "")
            4003, 4004 -> noSignalListener?.invoke(6, "")
            1000 -> noSignalListener?.invoke(1, mContext?.getString(com.live.evo.R.string.no_stream_notice_message_no_free) ?: "")
            1001 -> noSignalListener?.invoke(2, mContext?.getString(com.live.evo.R.string.no_stream_notice_message_no_server) ?: "")
            1002 -> noSignalListener?.invoke(3, mContext?.getString(com.live.evo.R.string.no_stream_notice_message_out_of_limit) ?: "")
            1003 -> noSignalListener?.invoke(5, mContext?.getString(com.live.evo.R.string.no_stream_app_version_not_support) ?: "")
            else -> {}
        }
    }

    /**
     * Medidor de rede do player (classe `z0$g`): a cada 800 ms lê do [StreamingMonitor] bps/reenvio/perda/RTT, guarda mínimos e máximos de
     * bps (> 10 kbps) e atualiza o [com.foxivid.baselib.metric.monitor.PlayerMonitor]; também troca o texto de loading com a velocidade e
     * acompanha a posição (render completo, duração, posição salva a cada 3 s).
     */
    private inner class PlayerMeter : Runnable {
        private var readBps = 0
        private var bps = 0L
        private var resendCount = 0
        private var resendRate = 0
        private var lossRate = 0
        private var rtt = 0; private var minRtt = 0; private var maxRtt = 0; private var avgRtt = 0
        private var lastBps = 0L; private var minBps = 0L; private var maxBps = 0L
        private var videoWidth = 0; private var videoHeight = 0
        private val connecting: String? = mContext?.getString(com.live.evo.R.string.loading)
        private val meterInterval = 800L
        private var vCodec = ""; private var aCodec = ""

        /** Zera dimensões/codecs. Original: i() */
        fun resetVideoInfo() { videoWidth = 0; videoHeight = 0; vCodec = ""; aCodec = "" }

        /** Zera estatísticas de tráfego e mostra "connecting". Original: l() / y() */
        fun resetTraffic() {
            bps = 0L; lastBps = 0L; minBps = 0L; maxBps = 0L; rtt = 0; minRtt = 0; maxRtt = 0; avgRtt = 0
            showLoading(mContext?.getString(com.live.evo.R.string.connecting) ?: "")
        }

        private fun positionOf(player: IMediaPlayer?): Long {
            if (player == null) return 0L
            return try { player.currentPosition } catch (_: Throwable) { 0L }
        }

        /** Lê dimensões e codecs de vídeo/áudio do player. Original: d(IMediaPlayer) */
        private fun readStreamInfo(player: IMediaPlayer) {
            try {
                videoWidth = player.videoWidth
                videoHeight = player.videoHeight
                val info = player.mediaInfo
                vCodec = info?.mMeta?.mVideoStream?.mCodecName.orEmpty()
                aCodec = info?.mMeta?.mAudioStream?.mCodecName.orEmpty()
            } catch (_: Throwable) {}
        }

        /** Mostra a velocidade no loading (se carregando). Original: j() */
        fun updateLoadingSpeed() {
            if (!isLoading || mIsForceStop) return
            try {
                val text = if (bps <= 0 || lastBps <= 0) (connecting ?: "") else com.foxivid.baselib.util.BitrateFormatter.format(bps)
                showLoading(text)
            } finally { lastBps = bps }
        }

        /** Posição/render: ao ter posição > 0 lê codecs, marca render completo (1ª vez), acompanha duração e salva posição. Original: h(IMediaPlayer) */
        fun onPositionTick(player: IMediaPlayer) {
            val pos = positionOf(player)
            if (pos <= 0) return
            latestPlayPosition = pos
            if (videoWidth == 0) {
                readStreamInfo(player)
                if (pos > 3000 && videoWidth == 0) { retryMissingDimensions(); return }
                renderTime = com.foxivid.baselib.util.ServerTime.elapsedNow()
                val session = mSession.get()
                com.foxivid.baselib.util.StartStatUtil.addStep(session, "$session.render_complete", true)
                mOnRenderCompleteListener?.run()
            }
            if (mPlayType == PlayType.VOD || mPlayType == PlayType.CATCHUP) {
                if (mVideoDuration == 0L) {
                    val d = durationOf(player)
                    if (pos < d) mVideoDuration = d
                }
                if (pos - lastSavedPosition > 3000) savePosition(pos)
            }
        }

        override fun run() {
            val info = mPlayerInfo
            val s = com.foxivid.baselib.metric.monitor.StreamingMonitor
            val b = s.bps()
            if (readBps == b) bps = 0 else { readBps = b; bps = b.toLong() }
            resendCount = s.resendCount(); lossRate = s.lossRate(); resendRate = s.resendRate()
            rtt = s.rtt(); minRtt = s.minRtt(); maxRtt = s.maxRtt(); avgRtt = s.avgRtt()
            info?.withPlayer { player ->   // `j.a(playerCheckCallback)`
                if (isBuffering() || preparedTime == 0L) {
                    if (mIsCompleted || mIsForceStop) return@withPlayer
                    showLoading()
                    updateLoadingSpeed()
                    return@withPlayer
                }
                if (isPlayingNow()) {
                    hideLoading()
                    hideLoadingAndTip()
                    cancelMessage(info, 10003)
                    onPositionTick(player)
                }
            }
            if (minBps != 0L) { if (bps in 10001 until minBps) minBps = bps } else minBps = bps
            if (maxBps == 0L || maxBps < bps) maxBps = bps
            com.foxivid.baselib.metric.monitor.PlayerMonitor.updatePlayStats(bps, s.avgBps(), minBps, maxBps, rtt, minRtt, maxRtt, avgRtt,
                resendCount, lossRate, resendRate, videoWidth, videoHeight, vCodec, aCodec)
            scheduleMessage(info, 10002, meterInterval)
        }
    }

    /**
     * Watchdog do player (classe `z0$h`), a cada 1 s (mensagem 10001): view invisível → pausa; status 4 → retoma; sem preparar após o
     * timeout do gateway → "player startup timeout"; sem avanço de posição → procura a etapa que parou (playlist/bloco, pelo
     * [StreamingMonitor]) e publica [PlayerRestartEvent] (no máx. 1 por timeout, contando repetições do mesmo código).
     */
    private inner class CheckPlaying : Runnable {
        private var now = 0L
        private var playerLastPlayingTime = 0L
        private var lastForceCallBufferHandlerTime = 0L
        private var lastCode: Int? = null
        private var codeCnt = 0
        private var lastSendRestartEventTime = 0L
        private var lastPlayPosition = 0L
        private var lastUpdateToPlayerTime = 0L

        /** Posição avançou desde a última checagem (e está tocando)? Original: g() */
        private fun isProgressing(): Boolean {
            if (!isPlayingNow()) return false
            val pos = currentPosition()
            isPlayPositionKeepMoving = lastPlayPosition != pos
            lastPlayPosition = pos
            return isPlayPositionKeepMoving
        }

        /** ms desde que o player foi visto tocando pela última vez. Original: j() */
        private fun idleMillis() = now - playerLastPlayingTime

        /** [time] mais antigo que o timeout do gateway? (loga "event timeout") Original: h(Long) */
        private fun isTimedOut(time: Long?): Boolean {
            if (time == null) return false
            val elapsed = now - time
            if (elapsed <= mGatewayTimeoutMillis) return false
            logger.warn("event timeout: [{}][{}] session[{}] [{} > {}]", mPlayType, mVideoName, mSession.get(), elapsed, mGatewayTimeoutMillis)
            return true
        }

        /** Original: z0$h$a (playingCheckCallback) */
        private fun checkPlayer(info: PlayerInfo?) {
            try {
                if (isProgressing()) {
                    playerLastPlayingTime = now
                    if (info != null) {
                        if (mMediaBufferingBeginTime > 0) {          // P1(info): fim do buffering
                            clearBuffering(); mPlayerMeter?.resetTraffic(); start()
                            org.greenrobot.eventbus.EventBus.getDefault().postSticky(BufferingEndEvent())
                            org.greenrobot.eventbus.EventBus.getDefault().postSticky(PlayerResumedEvent())
                        }
                        cancelMessage(info, 10003); hideLoading()   // H0(info)
                    }
                    if (lastSeekCompletePosition > 0) lastSeekCompletePosition = 0L
                    hideLoadingAndTip(); hideNoSignal()
                    return
                }
                val idle = idleMillis()
                if (idle <= 6000 || mMediaBufferingBeginTime != 0L) {
                    if (idle <= mGatewayTimeoutMillis || now - lastForceCallBufferHandlerTime <= mGatewayTimeoutMillis) return
                    lastForceCallBufferHandlerTime = now
                    mOnMediaBufferPlayHandler?.run()
                    return
                }
                if (info != null) {                                   // Q1(info) + T1(info): início do buffering
                    clearBuffering(); mMediaBufferingBeginTime = com.foxivid.baselib.util.ServerTime.elapsedNow(); sendRestartCnt = 0
                    org.greenrobot.eventbus.EventBus.getDefault().postSticky(BufferingStartEvent())
                    cancelMessage(info, 10003); scheduleMessage(info, 10003, 1000L)
                }
                logger.warn("[{}][{}] session[{}] player is not playing for {} ms, buffering", mPlayType, mVideoName, mSession.get(), idle)
            } catch (t: Throwable) {
                logger.error("start player failure", t)
            }
        }

        override fun run() {
            val info = mPlayerInfo
            try {
                if (!mIsPaused || lastSeekCompletePosition > 0) {
                    if (!mIsCompleted && !mIsForceStop) {
                        if (!isViewShown()) {
                            if (mSession.get() > 0) {
                                val paused = pause("2")
                                val ctx = mContext
                                if (!paused && ctx != null) {
                                    logger.debug("{}@{}: video view@{} [{}][{}] session[{}] is not shown, stop player", ctx.javaClass.simpleName, ctx.hashCode(), hashCode(), mPlayType, mVideoName, mSession.get())
                                    stopForHiddenView()
                                }
                            }
                            return
                        }
                        if (info != null && info.status == 4) {
                            val resumed = start()
                            logger.debug("video view@{} [{}][{}] session[{}] is shown, resume player[{}]", hashCode(), mPlayType, mVideoName, mSession.get(), resumed)
                        }
                        val playerId = info?.playerId ?: 0
                        now = com.foxivid.baselib.util.ServerTime.elapsedNow()
                        val timeout = mGatewayTimeoutMillis
                        var code: Int? = null
                        var reason = ""
                        if (preparedTime == 0L) {
                            if (startPlayInitTime.get() == 0L || now - startPlayInitTime.get() > mGatewayTimeoutMillis) {
                                startPlayInitTime.set(now)
                                reason = "player startup timeout"
                                code = -1
                            }
                            showLoading()
                        } else {
                            if (playerLastPlayingTime == 0L) playerLastPlayingTime = now
                            else info?.withPlayer { checkPlayer(info) }
                        }
                        downloadThousand = com.foxivid.baselib.metric.monitor.StreamingMonitor.downloadThousand(mSession.get(), playerId)
                        if (code == null && !isPlayPositionKeepMoving) {
                            val m = com.foxivid.baselib.metric.monitor.StreamingMonitor
                            val sess = mSession.get()
                            if (mPlayType != PlayType.LIVE) {
                                if (!mIsCompleted) {
                                    if (m.isLastBlock(sess, playerId)) {
                                        logger.debug("[{}][{}][{}] the last block download completed", mPlayType, mVideoName, sess)
                                    } else if (isTimedOut(m.lastBlockRequestTime(sess, playerId))) { code = 3; reason = "player no block request" }
                                    else if (isTimedOut(m.lastBlockResponseTime(sess, playerId))) { code = 6; reason = "streaming no block response" }
                                    else if (isTimedOut(m.lastBlockUpdateTime(sess, playerId))) { code = 7; reason = "streaming no block update" }
                                }
                                if (lastSeekCompletePosition > 0) {
                                    if (!isPlayPositionKeepMoving || lastPlayPosition <= lastSeekCompletePosition) {
                                        val updated = m.lastBlockUpdateTime(sess, playerId) ?: 0L
                                        if (lastUpdateToPlayerTime in 1 until updated) {
                                            logger.debug("[{}][{}][{}][{}] player seek complete but no data, start again", mPlayType, mVideoName, sess, playerId)
                                            start()
                                        }
                                        lastUpdateToPlayerTime = updated
                                    } else { lastSeekCompletePosition = 0L; lastUpdateToPlayerTime = 0L }
                                }
                            } else if (com.foxivid.baselib.config.BaseLibConfig.proxyType == "HLS") {
                                if (isTimedOut(m.lastPlaylistRequestTime(sess, playerId))) { code = 2; reason = "player no playlist request" }
                                else if (isTimedOut(m.lastPlaylistResponseTime(sess, playerId))) { code = 4; reason = "streaming no playlist response" }
                                else if (isTimedOut(m.lastPlaylistUpdateTime(sess, playerId))) { code = 5; reason = "streaming no playlist update" }
                                else if (isTimedOut(m.lastBlockRequestTime(sess, playerId))) { code = 3; reason = "player no block request" }
                                else if (isTimedOut(m.lastBlockResponseTime(sess, playerId))) { code = 6; reason = "streaming no block response" }
                                else if (isTimedOut(m.lastBlockUpdateTime(sess, playerId))) { code = 7; reason = "streaming no block update" }
                            }
                        }
                        if (code != null) {
                            val since = now - lastSendRestartEventTime
                            if (since < timeout) {
                                logger.warn("[{}][{}] session[{}] wait not enough time to restart player, [{}/{}] [{}({})] [{}] player[{}]",
                                    mPlayType, mVideoName, mSession.get(), since, timeout, reason, code, codeCnt, mPlayerInfo?.playerId)
                            } else {
                                if (lastCode == code) codeCnt++ else codeCnt = 1
                                lastCode = code
                                lastSendRestartEventTime = now
                                logger.warn("player monitor: [{}][{}] session[{}] {} [ {} ms ] [{}]", mPlayType, mVideoName, mSession.get(), reason, timeout, codeCnt)
                                showLoading()
                                org.greenrobot.eventbus.EventBus.getDefault().postSticky(PlayerRestartEvent(mSession.get(), code, codeCnt, reason))
                            }
                        }
                    }
                }
            } finally {
                // sempre reagenda (ou, se terminou, avisa o término)
                if (!mIsForceStop) {
                    if (!mIsCompleted) scheduleMessage(info, 10001, 1000L)
                    else playCompleteListener?.invoke() ?: noSignalListener?.invoke(0, mContext?.getString(com.live.evo.R.string.vod_play_complete) ?: "")
                }
            }
        }

        /** View escondida e não deu para pausar: para o player sem encerrar a sessão (N2(false)). */
        private fun stopForHiddenView() { stopPlayer(false) }
    }

    // listeners do player (`z0.x2/w2/y2/u2/z2`; `v2` = [setOnErrorListener])
    private var mOnPreparedListener: IMediaPlayer.OnPreparedListener? = null
    private var mOnInfoListener: IMediaPlayer.OnInfoListener? = null
    private var mOnCompletionListener: IMediaPlayer.OnCompletionListener? = null
    private var mOnSeekCompleteListener: IMediaPlayer.OnSeekCompleteListener? = null
    /** Original: x2 */ fun setOnPreparedListener(l: IMediaPlayer.OnPreparedListener?) { mOnPreparedListener = l }
    /** Original: w2 */ fun setOnInfoListener(l: IMediaPlayer.OnInfoListener?) { mOnInfoListener = l }
    /** Original: y2 — roda quando a 1ª imagem foi renderizada. */ fun setOnRenderCompleteListener(r: Runnable?) { mOnRenderCompleteListener = r }
    /** Original: u2 */ fun setOnCompletionListener(l: IMediaPlayer.OnCompletionListener?) { mOnCompletionListener = l }
    /** Original: z2 */ fun setOnSeekCompleteListener(l: IMediaPlayer.OnSeekCompleteListener?) { mOnSeekCompleteListener = l }

    // ------------------------------------------------------------------ consultas/comandos usados por PlayerView/PlayerViewHandler
    /** Tipo de aspecto escolhido (0 = FIT_PARENT...). Original: getMAspectRatioType() */
    var aspectRatioType = 0
    private var mSeekPosition = -1L
    var trackInfo: Array<tv.danmaku.ijk.media.player.misc.ITrackInfo>? = null
    /** Original: getMVideoWidth() */ fun videoWidth() = mVideoWidth
    /** Original: getMVideoHeight() */ fun videoHeight() = mVideoHeight
    /** Original: getDownloadThousand() */ fun downloadThousand() = downloadThousand
    /** Modo de decodificação do player atual. Original: Q0() */ fun decodeMode(): Int? = mPlayerInfo?.decodeMode
    /** Duração do player atual (ms). Original: S0() */ fun duration(): Long = durationOf(currentPlayer(null))
    /** Tocando e com a posição avançando? Original: K1() */ fun isPlaying(): Boolean = isPlayingNow() && isPlayPositionKeepMoving

    /**
     * Seek (ms) com a view visível. Perto do fim (últimos 2 s ou > 98 %) recua para `duração - 2 s`. Guarda a posição como última
     * posição conhecida/salva (exceto 0 repetido). Retorna false se a view não está visível. Original: j2(long)
     */
    fun seekTo(position: Long): Boolean {
        val player = mPlayerInfo?.mediaPlayer
        if (!isViewShown()) {
            logger.warn("{}: [{}][{}] session[{}] video view is not shown, ignored seek {}", VideoViewHandler::class.java.simpleName, mPlayType, mVideoName, mSession.get(), position)
            return false
        }
        if (player == null) return true
        try {
            mIsPaused = false
            val duration = player.duration
            val limit = duration - 2000
            val target = if (position < limit && position.toDouble() / duration <= 0.98) position else maxOf(0L, limit)
            if (target == position) logger.debug("[{}][{}] session[{}] play_position seek_to[{}] duration[{}]", mPlayType, mVideoName, mSession.get(), position, duration)
            else logger.debug("[{}][{}] session[{}] play_position try seek_to[{}] but real seek_to[{}] duration[{}]", mPlayType, mVideoName, mSession.get(), position, target, duration)
            if (!(target == 0L && target == mSeekPosition)) {
                latestPlayPosition = target
                savePosition(target)
            }
            player.seekTo(target)
            mSeekPosition = target
        } catch (_: Throwable) {}
        return true
    }

    /**
     * Para o player atual: cancela agendamentos, esconde loading/tip, (isTerminate=false) pausa; salva posição de VoD; zera URL,
     * sessão e [PlayerInfo]. Devolve a sessão encerrada. Original: N2(boolean) (+ O2 no término)
     */
    @Synchronized
    fun stopPlayer(isTerminate: Boolean): Long {
        unregisterFromEventBus()
        mPlayerInfo?.let { clearBuffering() }
        loadingListener?.invoke(false, "")
        mVideoView?.e()
        val session = mSession.get()
        try {
            if (isTerminate) { /* O2(session): encerra a sessão no proxy em IO (classe z0$q) */ } else pause("3")
            if (mPlayType == PlayType.VOD || mPlayType == PlayType.CATCHUP) {
                if (latestPlayPosition > lastSavedPosition) savePosition(latestPlayPosition)
            }
            cancelAllScheduled()
            mPlayUri = null
            preparedTime = 0L
            mPlayerInfo = null
            lastSession = session
            mSession.set(0L)
            logger.debug("[{}][{}] session[{}] player stop({})", mPlayType, mVideoName, session, isTerminate)
        } catch (e: Exception) {
            logger.error("[{}][{}] session[{}] stop player failure", mPlayType, mVideoName, session, e)
        }
        return session
    }
}
