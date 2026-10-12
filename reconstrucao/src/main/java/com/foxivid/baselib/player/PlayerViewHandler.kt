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
 * TODO: UI (loading, trial overlay, legendas, aspect ratio, contadores de tempo de teste).
 */
abstract class PlayerViewHandler {

    private val logger = LoggerFactory.getLogger(javaClass)
    private val mutex = Mutex()
    private val lastStartPlayTime = AtomicLong(0)
    private val isPlayerInStarting = AtomicBoolean(false)
    private var playingContext: PlayContext? = null
    private var lastPlayContext: PlayContext? = null
    private val invalidSession = -1L // TODO: valor real do campo c0.invalidSession não confirmado
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
        if (!UserManager.isMember() || UserManager.expireTime() < needUntil) { // user.f.K0(), m0()
            // Original: EventBus nf.x(name, CATCHUP, 0); noSignalListener(1, R.string.no_stream_notice_message_no_free)
            logger.info("[${PlayType.CATCHUP}][$name][$mediaId] start, but ${if (UserManager.isMember()) "not enough time left" else "guest"}")
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
            val uid = UserManager.uid(); val loginTime = UserManager.loginTime() // user.f.B0(), o0()
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
        // Original: c0$e0 → para StreamHelper/VideoViewHandler
    }

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
    abstract fun v1(visibility: Int)        // trial
    abstract fun x1(url: String)
    abstract fun y1()
    abstract fun z1(url: String)
}

/** Original: qf/b.java — estado de teste/assinatura de uma mídia (usado por MediaPlayManager). */
enum class TrialStatus { SUBSCRIBED, FREE, NO_FREE_BUT_HAS_TRIAL_TIME, NO_FREE_NO_TRIAL_TIME }
