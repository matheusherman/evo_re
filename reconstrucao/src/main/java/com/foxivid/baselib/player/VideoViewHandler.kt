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
 * relevantes para o pipeline. Ficaram de fora (TODO) o tratamento de renderização/aspect-ratio, monitores de
 * playlist/bloco (diagnóstico "player no playlist request", "streaming no playlist update"...), legendas,
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
class VideoViewHandler(private var mContext: Context?) {

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
        // TODO: ramo "player já preparado" (status 1..3) — religa surface e dá start; não reconstruído.
    }

    /**
     * Original: z0.l2() — buffering prolongado: se bufferizando há ≥ timeout de gateway e o último pedido de
     * restart foi há ≥ esse tempo, publica evento de restart (nf.q(session, 1, cnt, "buffering")) que o
     * [PlayerViewHandler.onRestartEvent] trata.
     */
    private fun checkBufferingRestart(now: Long, bufferingMillis: Long) {
        if (mMediaBufferingBeginTime <= 0) return
        if (lastSentBufferingRestartEventTime <= 0) { lastSentBufferingRestartEventTime = now; return }
        if (now - lastSentBufferingRestartEventTime < mGatewayTimeoutMillis) return
        if (bufferingMillis < mGatewayTimeoutMillis) return
        sendRestartCnt++
        logger.warn("player buffering [ {} ms ], [$mPlayType][$mVideoName] send player restart event cnt[{}]", bufferingMillis, sendRestartCnt)
        lastSentBufferingRestartEventTime = now
        // Original: EventBus.post(nf.q(mSession, 1, sendRestartCnt, "buffering"))
    }

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

    /** Original: z0.H2() — retomar/iniciar. TODO: não reconstruído (UI/estado). */
    fun start(): Boolean = TODO("z0.H2 — retomada de reprodução (não reconstruído)")

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
        mHandler = Handler(Looper.getMainLooper())
        // TODO("z0.q1/A1/E1/B1/D1 — corpos de inicialização não reconstruídos")
    }
}
