package com.foxivid.baselib.player

import com.foxivid.baselib.media.MediaPlayManager
import com.foxivid.baselib.media.ChannelManager
import com.foxivid.baselib.model.meta.ChannelStreamResponse
import com.foxivid.baselib.model.meta.EPGProgramme
import com.foxivid.baselib.streaming.PlayUrlReadyEvent
import com.foxivid.baselib.streaming.StreamHelper
import com.foxivid.baselib.streaming.client.EngineHelper
import com.foxivid.baselib.streaming.engine.PlayType
import com.foxivid.baselib.user.UserManager
import com.foxivid.baselib.util.StackTraceUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.slf4j.LoggerFactory
import tv.danmaku.ijk.media.player.IMediaPlayer
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicLong

/**
 * Original: x1/f1/lb/widget/videoview/c0.java ("PlayerViewHandler.kt", abstrata) — ~4.600 linhas.
 * Subclasse concreta: PlayerView$b (t/v/c/widget/videoview/PlayerView.java).
 *
 * RECONSTRUÇÃO PARCIAL do caminho de reprodução:
 * - [startLive] (c0.G1 / c0$c0): registra o canal no histórico, monta [PlayContext] com
 *   flowCreator = `StreamHelper.createLivePlayFlow(channel)` e chama [start].
 * - [startCatchup] (c0.H1 / c0$d0): exige usuário logado (não convidado) com tempo de assinatura
 *   restante ≥ duração do programa; senão emite nf.x e mostra "no_stream_notice_message_no_free".
 *   videoName = "<streamName>/<título>", mediaId = "<catchupRoute>#<streamId>#<startSeg>#<durSeg>".
 * - [start] (c0.B1) sob mutex: reaproveita o contexto se uid/loginTime/tipo/mediaId/route/mode iguais.
 * - [startWithContext] (c0.C1): checa trial (ao vivo sem tempo de teste ⇒ aborta), e então coleta o
 *   flow de [PlayUrlReadyEvent]; cada evento é salvo em [PlaySessionCache] e repassado a
 *   [VideoViewHandler.setVideoPath] (c0$b0). Se não for forçado, primeiro tenta reaproveitar a
 *   sessão ([verifySession], c0.K1: mesma sessão em cache + `EngineHelper.isConnected`).
 * - [onPlayerError] (c0.P0): 404/404 ⇒ "no signal"; extra 405/406/407/504 ou what −10000 em ao vivo
 *   ⇒ reinicia o player (exceto eco mode / sem trial).
 * - [onRestartEvent] (c0.OnEvent(nf.q)): restart pedido pelo VideoViewHandler (buffering) — ignora se
 *   a sessão mudou ou se a sessão tem < 15 s.
 * A parte visual (loading, tip, "sem sinal", cobertura padrão, canto de teste) é feita pela subclasse concreta (`PlayerView$b`) através dos
 * métodos abstratos `g1/k1/r0/v1/x1/y1/z1`; legendas e contadores de tempo de teste ficam no VideoViewHandler/ SubtitleViewHandler.
 */
abstract class PlayerViewHandler {

    private val logger = LoggerFactory.getLogger(javaClass)
    private val mutex = Mutex()
    private val lastStartPlayTime = AtomicLong(0)
    private val isPlayerInStarting = AtomicBoolean(false)
    private var playingContext: PlayContext? = null
    private var lastPlayContext: PlayContext? = null
    /** `private final long invalidSession` sem atribuição no construtor: vale 0 (zero = sem sessão). */
    private val invalidSession = 0L
    protected lateinit var videoViewHandler: VideoViewHandler

    /** Original: c0.G1(ChannelStreamResponse) */
    fun startLive(channel: ChannelStreamResponse): Flow<Long> {
        ChannelManager.addPlayHistory(channel.key) // media.a.n(key)
        return flow {
            val creator = PlayContext.FlowCreator { force -> StreamHelper.createLivePlayFlow(channel, force) }
            start(channel.streamName, PlayType.LIVE, "", channel.streamId, channel.route, channel.type, channel.playerArgs, creator)
                .collect { emit(it) }
        }.flowOn(Dispatchers.IO)
    }

    /** Original: c0.H1(ChannelStreamResponse, EPGProgramme) */
    fun startCatchup(channel: ChannelStreamResponse, programme: EPGProgramme, mediaMode: Int): Flow<Long> = flow {
        val name = channel.streamName + "/" + programme.title
        val positionKey = programme.channel + "." + programme.start
        val startSec = programme.start / 1000
        val durSec = (programme.stop - programme.start) / 1000
        if (durSec <= 0) throw Exception("catchup duration <0")
        val mediaId = channel.catchupRoute + "#" + channel.streamId + "#" + startSec + "#" + durSec
        val needUntil = System.currentTimeMillis() + (programme.stop - programme.start)
        if (!UserManager.hasUsername() || UserManager.getExpireTs() < needUntil) { // user.f.K0(), m0()
            // Original: EventBus nf.x(name, CATCHUP, 0); noSignalListener(1, R.string.no_stream_notice_message_no_free)
            logger.info("[${PlayType.CATCHUP}][$name][$mediaId] start, but ${if (UserManager.hasUsername()) "not enough time left" else "guest"}")
            stop(true)
            emit(0L); return@flow
        }
        logger.info("[${PlayType.CATCHUP}][$name][$mediaId] start")
        val creator = PlayContext.FlowCreator { force ->
            StreamHelper.createCatchupPlayFlow(channel, mediaId, programme.start, programme.stop, mediaMode, force)
        }
        start(name, PlayType.CATCHUP, positionKey, mediaId, channel.route, mediaMode, channel.playerArgs, creator).collect { emit(it) }
    }.flowOn(Dispatchers.IO)

    /** Original: c0.B1(...) */
    private suspend fun start(videoName: String, type: PlayType, positionKey: String, mediaId: String, routeId: String,
                              mediaMode: Int, playerArgs: String?, creator: PlayContext.FlowCreator, subtitleMediaId: String = ""): Flow<Long> {
        val ctx = mutex.withLock {
            val uid = UserManager.getAccountIdString(); val loginTime = UserManager.getLatestLoginResponseTime() // user.f.B0(), o0()
            val cur = playingContext
            if (cur == null || cur.uid != uid || cur.loginTime != loginTime || cur.playType != type ||
                cur.mediaId != mediaId || cur.routeId != routeId || cur.mediaMode != mediaMode) {
                val isFree = MediaPlayManager.trialOf(mediaId, mediaMode) == TrialStatus.FREE
                PlayContext(uid, loginTime, videoName, type, positionKey, playerArgs, mediaId, routeId, mediaMode, isFree,
                    subtitleMediaId, AtomicBoolean(false), creator)
                // Original: b0(true), videoViewHandler.s2(false)/r2(null); se tipo/mediaId mudou ⇒ I1(true)
            } else cur
        }
        return startWithContext(ctx)
    }

    /** Original: c0.C1(PlayContext) */
    private suspend fun startWithContext(ctx: PlayContext): Flow<Long> {
        val trial = MediaPlayManager.trialOf(ctx.mediaId, ctx.mediaMode)
        if (ctx.playType == PlayType.LIVE && trial == TrialStatus.NO_FREE_NO_TRIAL_TIME) {
            // Original: Z0(ctx) — mostra overlay de trial, para e publica nf.x
            return flowOf(0L)
        }
        // Original: i0() — verificações de UI; play-time accumulator
        if (!ctx.forceToStart.get()) {
            val s = verifySession(ctx)
            if (s != invalidSession) return flowOf(s)
        }
        if (!isPlayerInStarting.compareAndSet(false, true)) {
            logger.warn("start_play ${ctx.videoName}(${ctx.mediaId}), ignored, another start play event is in processing")
            return flow { } // Original: c0$a0
        }
        try {
            lastPlayContext = playingContext ?: ctx
            playingContext = null
            var session = 0L
            ctx.flowCreator.create(ctx.forceToStart).collect { ev: PlayUrlReadyEvent ->
                // Original: c0$x/c0$y — preenche videoName/positionKey, guarda PlaySession e liga o player
                ev.videoName = ctx.videoName
                ev.playPositionPersistenceKey = ctx.playPositionPersistenceKey
                ctx.session = ev.session
                playingContext = ctx
                PlaySessionCache.put(PlaySession(ev, ctx.subtitleMediaId, ""))
                session = startPlayer(PlaySession(ev, ctx.subtitleMediaId, ""), "start")
            }
            return flowOf(session)
        } finally {
            isPlayerInStarting.set(false)
        }
    }

    /** Original: c0.K1(PlayContext) — reaproveita sessão já criada se ainda conectada. */
    private suspend fun verifySession(ctx: PlayContext): Long {
        val cached = PlaySessionCache.get(videoViewHandler.mSession.get()) ?: return invalidSession
        val ev = cached.event
        if (ev.playType != ctx.playType || ev.playPositionPersistenceKey != ctx.playPositionPersistenceKey ||
            ev.mediaId != ctx.mediaId || ev.routeId != ctx.routeId || ev.mediaMode != ctx.mediaMode) return invalidSession
        if (ctx.playType != PlayType.CATCHUP && !EngineHelper.isConnected(ctx.playType)) return invalidSession
        return startPlayer(cached, "verify session")
    }

    /** Original: c0.A1(PlaySession, from) + c0$b0 — evita reinícios < 3 s e entrega a URL ao VideoViewHandler. */
    private fun startPlayer(session: PlaySession, from: String): Long {
        val ev = session.event
        val cur = videoViewHandler.mSession.get()
        val now = System.currentTimeMillis()
        val last = lastStartPlayTime.get()
        if (!lastStartPlayTime.compareAndSet(last, now)) { logger.warn("start_play: a play event is in start"); return ev.session }
        if (now - last < 3000 && cur == ev.session) return ev.session
        if (videoViewHandler.setVideoPath(ev.videoName, ev.url, playingContext?.playerArgs, ev.playType, ev.session)) {
            // Original: V0() (UI) e, ao vivo, a1.h(session, "<mediaId>.set_video_path")
        }
        return ev.session
    }

    /** Original: c0.P0(c0, player, what, extra) */
    protected fun onPlayerError(player: IMediaPlayer?, what: Int, extra: Int): Boolean {
        if (isPlayerInStarting.get()) return true
        if (what == 404 && extra == 404) {
            // Original: X(8) — "no_signal 404"
            return true
        }
        logger.error("[${playingContext?.playType}][${playingContext?.videoName}][${playingContext?.mediaId}] play error[player[${player?.hashCode()}]-what[$what]-extra[$extra]]")
        if (extra == 405 || extra == 406 || extra == 407 || extra == 504 || what == -10000) {
            val ctx = playingContext
            if (ctx != null && ctx.playType == PlayType.LIVE) {
                if (MediaPlayManager.trialOf(ctx.mediaId, ctx.mediaMode) == TrialStatus.NO_FREE_NO_TRIAL_TIME) {
                    // Original: Z0(ctx)
                } else {
                    logger.warn("restart player")
                    // Original: d1(...) → c1(): reinicia com o último contexto (força nova sessão)
                    return true
                }
            }
        }
        return true
    }

    /** Original: c0.I1(boolean) — para o player (e esquece o contexto se terminar). */
    fun stop(isTerminate: Boolean) {
        if (playingContext == null) return
        if (isTerminate) playingContext = null
        videoViewHandler.stopPlayer(isTerminate)   // Original: c0$e0 → VideoViewHandler.N2(isTerminate) (+ encerra a sessão no proxy)
    }

    private var mContext: android.content.Context? = null
    private var playerView: PlayerViewContract? = null
    private var subtitleViewHandler: com.foxivid.ui.subtitle.SubtitleViewHandler? = null

    /**
     * Liga o handler à view: guarda contexto/handlers, o idioma de legenda padrão e registra os callbacks do [VideoViewHandler]:
     * prepared (K0: avisa o listener e o monitor), info (L0), render completo (M0), completion (N0), seek complete (O0: dá start se
     * parado) e erro (P0 = [onPlayerError]). O OnPreDrawListener que posiciona o canto de teste/tip (`c0$k`, ~400 linhas em
     * x1/f1/lb/widget/videoview/k.java) não foi reconstruído. Original: J0(...)
     */
    fun attach(context: android.content.Context, playerView: PlayerViewContract, videoViewHandler: VideoViewHandler,
               subtitleViewHandler: com.foxivid.ui.subtitle.SubtitleViewHandler) {
        mContext = context
        this.playerView = playerView
        this.videoViewHandler = videoViewHandler
        this.subtitleViewHandler = subtitleViewHandler
        subtitleLang = com.foxivid.baselib.heartbeat.HeartbeatManager.subtitleDftLang
        videoViewHandler.setOnPreparedListener { mp ->
            onPreparedListener?.onPrepared(mp)
            logger.debug("[{}][{}][{}] prepared", playerType(), videoName(), playingContext?.mediaId)
        }
        videoViewHandler.setOnInfoListener { mp, what, extra, info -> onInfoListener?.onInfo(mp, what, extra, info) ?: true }
        videoViewHandler.setOnCompletionListener { mp ->
            logger.debug("[{}][{}][{}] play complete", playerType(), videoName(), playingContext?.mediaId)
            onCompletionListener?.onCompletion(mp)
        }
        videoViewHandler.setOnSeekCompleteListener { mp ->
            try {
                logger.debug("[{}][{}][{}] seek complete[{}]", playerType(), videoName(), playingContext?.mediaId, mp.currentPosition)
                if (!mp.isPlaying) mp.start()
            } catch (t: Throwable) {
                logger.error("[{}][{}][{}] start play failure after seek complete", playerType(), videoName(), playingContext?.mediaId, t)
            }
            onSeekCompleteListener?.onSeekComplete(mp)
        }
        videoViewHandler.setOnErrorListener { mp, what, extra -> onPlayerError(mp, what, extra) }
    }
    private fun playerType() = playingContext?.playType

    // ------------------------------------------------------------------ API consumida por PlayerView
    private var isPause = false
    private var subtitleLang: String? = null
    private var subtitles: List<String>? = null
    private var onPreparedListener: IMediaPlayer.OnPreparedListener? = null
    private var onErrorListener: IMediaPlayer.OnErrorListener? = null
    private var onCompletionListener: IMediaPlayer.OnCompletionListener? = null
    private var onInfoListener: IMediaPlayer.OnInfoListener? = null
    private var onSeekCompleteListener: IMediaPlayer.OnSeekCompleteListener? = null

    /** Já preparou (`preparedTime > 0`)? Original: S0() */ fun canPause(): Boolean = videoViewHandler.preparedTime > 0
    /** Original: R0() */ open fun isPlaying(): Boolean = videoViewHandler.isPlaying()
    /** Só se pode andar no tempo se preparado e não for ao vivo. Original: U() / V() */
    fun canSeek(): Boolean = canPause() && playingContext?.playType != PlayType.LIVE && !isPlaying0()
    private fun isPlaying0() = false   // `Q0()` do original (retorna false neste build)
    /** Original: U() */ fun canSeekBackward(): Boolean = canSeek()
    /** Original: V() */ fun canSeekForward(): Boolean = canSeek()

    /** Pausa o player (com contexto); marca [isPause]. Original: a1() */
    fun pause(): Boolean {
        if (playingContext == null) return false
        if (!videoViewHandler.pause(StackTraceUtils.callerName(2))) return false
        isPause = true
        return true
    }

    /** Retoma: se o player está preparado só dá `start()`; senão recria o contexto. Original: D1() */
    fun start(): Boolean {
        isPause = false
        if (playingContext == null) return false
        return videoViewHandler.start()
    }

    /** Seek (ms), guardando a posição no contexto. Original: e1(long) */
    fun seekTo(position: Long) {
        playingContext?.preSetSeekPosition = position
        videoViewHandler.seekTo(position)
        logger.debug("[{}][{}][{}] seek_to [{}]", playingContext?.playType, videoName(), playingContext?.mediaId, position)
    }

    /** Reinicia a reprodução do contexto atual (ou do último), opcionalmente numa posição. Original: c1(String, f, Long) */
    fun restart(from: String, position: Long?): Boolean {
        val ctx = playingContext ?: lastPlayContext ?: return false
        if (position != null) ctx.preSetSeekPosition = position
        isPause = false
        // Original: k0(ctx) valida; depois corrotina c0$r relança startWithContext(ctx) e aguarda (CountDownLatch)
        return true
    }

    /** Original: m0() */ fun aspectRatioType(): Int = videoViewHandler.aspectRatioType
    /** Original: n0() */ fun decodeMode(): Int? = videoViewHandler.decodeMode()
    /** Original: o0() */ fun downloadThousand(): Int = videoViewHandler.downloadThousand()
    /** Original: p0() */ fun duration(): Long = videoViewHandler.duration()
    /** Original: t0() */ fun playType(): PlayType? = playingContext?.playType
    /** Original: u0() */ fun position(): Long = videoViewHandler.currentPosition()
    /** Sessão do vídeo (0 sem contexto). Original: v0() */ fun session(): Long = if (playingContext == null) 0L else videoViewHandler.mSession.get()
    /** Idioma da legenda: o escolhido ou o padrão do heartbeat. Original: x0() */
    fun subtitleLang(): String = subtitleLang ?: com.foxivid.baselib.heartbeat.HeartbeatManager.subtitleDftLang
    /** Original: z0() */ fun subtitles(): List<String>? = subtitles
    /** Original: A0() */ fun trackInfo() = videoViewHandler.trackInfo
    /** Original: B0() */ fun videoHeight(): Int = videoViewHandler.videoHeight()
    /** Original: D0() */ fun videoWidth(): Int = videoViewHandler.videoWidth()
    /** Original: C0() */ fun videoName(): String = playingContext?.videoName ?: ""
    /** Original: f1(int) */ fun setAspectRatioType(type: Int) { videoViewHandler.aspectRatioType = type }
    /** Original: r1(String) */ fun setSubtitle(lang: String?) { subtitleLang = lang }
    /** Original: w1(boolean) */ fun setZOrderOnTop(onTop: Boolean) {}

    /** Original: h1(p) */ fun setLoadingListener(l: ((Boolean, String) -> Unit)?) { videoViewHandler.loadingListener = l }
    /** Original: j1(p) */ fun setNoSignalListener(l: ((Int, String) -> Unit)?) { videoViewHandler.noSignalListener = l }
    /** Original: q1(a) */ fun setPlayCompleteListener(l: (() -> Unit)?) { videoViewHandler.playCompleteListener = l }
    /** Original: l1 / m1 / n1 / o1 / p1 */
    fun setOnCompletionListener(l: IMediaPlayer.OnCompletionListener?) { onCompletionListener = l }
    fun setOnErrorListener(l: IMediaPlayer.OnErrorListener?) { onErrorListener = l }
    fun setOnInfoListener(l: IMediaPlayer.OnInfoListener?) { onInfoListener = l }
    fun setOnPreparedListener(l: IMediaPlayer.OnPreparedListener?) { onPreparedListener = l }
    fun setOnSeekCompleteListener(l: IMediaPlayer.OnSeekCompleteListener?) { onSeekCompleteListener = l }
    /** Original: s0() */ fun onCompletionListener() = onCompletionListener

    /** Original: c0.OnEvent(nf.q) */
    fun onRestartEvent(eventSession: Long) {
        val cur = playingContext?.session
        if (cur == null) { /* j0(): força restart */ return }
        if (eventSession != 0L) {
            if (cur != eventSession) { logger.info("player current session[$cur] changed. ignored old session[$eventSession] restart event"); return }
        } else if (System.currentTimeMillis() - cur < 15000) return
        // Original: c0$b — reinicia a reprodução em IO
    }

    // Métodos abstratos implementados por PlayerView$b (UI)
    abstract fun g1(visibility: Int)        // loading
    abstract fun k1(visibility: Int)        // tip
    abstract fun r0(): Int?
    /** Reação a mudança de estado global da app (flow de InteractionUtils.O0()). Original: u1() */
    open fun onAppStateChanged() {}
    abstract fun v1(visibility: Int)        // trial
    abstract fun x1(url: String?)
    abstract fun y1()
    abstract fun z1(url: String?)
}

/** Original: qf/b.java — estado de teste/assinatura de uma mídia (usado por MediaPlayManager). */
enum class TrialStatus { SUBSCRIBED, FREE, NO_FREE_BUT_HAS_TRIAL_TIME, NO_FREE_NO_TRIAL_TIME }
