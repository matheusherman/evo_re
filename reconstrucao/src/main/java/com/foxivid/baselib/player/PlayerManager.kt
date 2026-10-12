package com.foxivid.baselib.player

import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.streaming.client.EngineHelper
import com.foxivid.baselib.streaming.engine.PlayType
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import tv.danmaku.ijk.media.player.AndroidMediaPlayer
import tv.danmaku.ijk.media.player.IMediaPlayer
import tv.danmaku.ijk.media.player.IjkMediaPlayer
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Original: x1/f1/lb/widget/videoview/k.java ("PlayerManager.kt") (+ k$a, k$b, k$b$a)
 *
 * Fábrica/gestor do IMediaPlayer. Só existe um player lógico ("main_player"). Ao criar um novo, o anterior
 * é parado/liberado e removido do proxy (`EngineHelper.removePlayer`); o novo é registrado com
 * `EngineHelper.addPlayer(session, player.hashCode())` — o proxy HLS só atende requisições cujo
 * parâmetro `player` bate com um id registrado.
 *
 * decodeMode 3 ⇒ `AndroidMediaPlayer` (MediaPlayer do sistema); qualquer outro ⇒ `IjkMediaPlayer`.
 * Opções ijk: [setLiveTsOptions] (ao vivo com proxy TS) ou [setDefaultOptions] (HLS/VoD/catch-up).
 */
object PlayerManager {

    private val logger = LoggerFactory.getLogger(PlayerManager::class.java)
    private const val MAIN_PLAYER = "main_player"
    private val playInfoMap = ConcurrentHashMap<String, PlayerInfo>()
    private val decodeModeMap = ConcurrentHashMap<String, Int>()
    private val isInCreating = AtomicBoolean(false)
    /** Original: k.playerArgsMap — último "playerArgs" (JSON vindo da lista de canais) válido. */
    private var playerArgsMap: HashMap<String, String> = HashMap()
    private var lastPlayType: PlayType? = null

    /** Original: k.c(int) */
    @Synchronized
    private fun newPlayer(decodeMode: Int): IMediaPlayer {
        return if (decodeMode == 3) {
            if (BaseLibConfig.isDebug) logger.debug("start player[{}], decodeMode[{}]", AndroidMediaPlayer::class.java.name, decodeMode)
            AndroidMediaPlayer()
        } else {
            if (BaseLibConfig.isDebug) logger.debug("start player[{}], decodeMode[{}]", IjkMediaPlayer::class.java.name, decodeMode)
            IjkMediaPlayer().also { it.reset() }
        }
    }

    /** Original: k.b(...) — cria o player principal. */
    fun create(playUri: String, decodeMode: Int, hardwareDecodeFlag: Long, playerArgs: String?, playType: PlayType, session: Long): PlayerInfo {
        lastPlayType = playType
        return create(MAIN_PLAYER, playUri, decodeMode, hardwareDecodeFlag, playerArgs, playType, session)
    }

    /** Original: k.h(...) */
    private fun create(name: String, playUri: String, decodeMode: Int, hardwareDecodeFlag: Long, playerArgs: String?,
                       playType: PlayType, session: Long): PlayerInfo {
        // espera ocupada (10 ms) por um "lock" que é liberado imediatamente — efeito prático quase nulo
        while (true) {
            if (isInCreating.compareAndSet(false, true)) { isInCreating.set(false); break }
            try { Thread.sleep(10) } catch (_: Exception) {}
        }
        val old = playInfoMap.remove(name)
        if (old != null) {
            stopPlayer(old, true)
            EngineHelper.removePlayer(old.session, old.playerId)
        }
        val player = newPlayer(decodeMode)
        if (player is IjkMediaPlayer) {
            if (playType == PlayType.LIVE && BaseLibConfig.proxyType == "TS") setLiveTsOptions(player, hardwareDecodeFlag, playerArgs)
            else setDefaultOptions(playType, player, hardwareDecodeFlag)
        }
        val info = PlayerInfo(player, playUri, decodeMode, hardwareDecodeFlag, session)
        playInfoMap[name] = info
        EngineHelper.addPlayer(session, info.playerId)
        return info
    }

    /**
     * Original: k.o(IjkMediaPlayer, long, String)
     * Opções para o stream TS contínuo (`http://127.0.0.1:<netty>/<liveTs>/<mediaId>.ts`).
     * Categoria 4 = OPT_CATEGORY_PLAYER, 1 = FORMAT, 2 = CODEC.
     * Curiosidades fiéis ao original: "reconnect" é setado 1 e depois 0 (vale 0);
     * "live-quick-start " tem um **espaço no fim** do nome (o ijk provavelmente ignora a opção).
     */
    private fun setLiveTsOptions(p: IjkMediaPlayer, hw: Long, playerArgs: String?) {
        val map: HashMap<String, String> = if (playerArgs.isNullOrEmpty()) playerArgsMap else try {
            Gson().fromJson<HashMap<String, String>>(playerArgs, object : TypeToken<HashMap<String, String>>() {}.type).also { playerArgsMap = it }
        } catch (t: Throwable) {
            logger.error("setPlayerOption failure", t); playerArgsMap
        }
        p.setOption(4, "mediacodec", hw)
        p.setOption(4, "mediacodec-hevc", hw)
        p.setOption(4, "mediacodec-avc", hw)
        p.setOption(4, "mediacodec-auto-rotate", hw)
        p.setOption(4, "mediacodec-all-videos", hw)
        p.setOption(4, "mediacodec-handle-resolution-change", hw)
        p.setOption(4, "overlay-format", 842225234L) // SDL_FCC_RV32
        p.setOption(4, "av-sync-type", 0L)
        p.setOption(4, "start-on-prepared", 0L)
        p.setOption(4, "framedrop", if (hw == 0L) 5L else 1L)
        p.setOption(1, "flush_packets", 1L)
        p.setOption(4, "packet-buffering", 1L)
        p.setOption(2, "skip_loop_filter", 48L)
        p.setOption(1, "dns_cache_clear", 1L)
        p.setOption(1, "http-detect-range-support", 0L)
        p.setOption(1, "reconnect_streamed", 1L)
        p.setOption(1, "reconnect", 1L)
        p.setOption(1, "reconnect_at_eof", 1L)
        p.setOption(1, "iformat", "mpegts")
        p.setOption(1, "reconnect", 0L)
        try {
            val enlarge = map["enlargeprobesize"]?.toLong() ?: 0L
            if (enlarge > 0) {
                p.setOption(1, "probesize", enlarge)
                p.setOption(1, "analyzeduration", 5000000L)
            } else {
                p.setOption(1, "probesize", map["probesize"]?.toLong() ?: 350000L)
            }
        } catch (_: Throwable) {}
        if (BaseLibConfig.isDebug) logger.debug("zapping_time_opt set_params_to_player player[{}]", p.hashCode())
        p.setOption(4, "opensles", 0L)
        p.setOption(4, "live-quick-start ", 1L)
    }

    /** Original: k.m(PlayType, IjkMediaPlayer, long) — opções para HLS local, VoD e catch-up. */
    private fun setDefaultOptions(playType: PlayType, p: IjkMediaPlayer, hw: Long) {
        p.setOption(4, "mediacodec", hw)
        p.setOption(4, "mediacodec-hevc", hw)
        p.setOption(4, "mediacodec-auto-rotate", hw)
        p.setOption(4, "mediacodec-handle-resolution-change", hw)
        p.setOption(4, "overlay-format", 842225234L)
        p.setOption(4, "start-on-prepared", 0L)
        p.setOption(4, "framedrop", if (hw == 0L) 5L else 1L)
        p.setOption(1, "flush_packets", 1L)
        p.setOption(4, "packet-buffering", 1L)
        p.setOption(2, "skip_loop_filter", 0L)
        p.setOption(1, "dns_cache_clear", 1L)
    }

    /**
     * Original: k.q(PlayerInfo, boolean) + k$b — para (e opcionalmente libera) o player em background.
     * Status do PlayerInfo: 1,2,3 = ativos; 5 = parado; 6 = liberado.
     */
    private fun stopPlayer(info: PlayerInfo, isRelease: Boolean) {
        try {
            val status = info.status
            if (status == 6) return
            // Original: marca fim do zapping em tf.d (metric.monitor.h.c()) ou f.n()
            info.withPlayer { player ->
                CoroutineScope(Dispatchers.IO).launch {
                    synchronized(PlayerManager) {
                        if (info.status == 6) return@launch
                        if (status == 1 || status == 2 || status == 3) {
                            info.status = 5
                            try {
                                player.stop()
                                if (!isRelease) player.reset()
                            } catch (t: Throwable) { logger.error("stop player failure", t) }
                        }
                        if (isRelease) {
                            try {
                                info.mediaPlayer = null
                                player.release()
                                info.status = 6
                            } catch (t: Throwable) { logger.error("release player failure", t) }
                        }
                    }
                }
            }
        } catch (e: Exception) {
            logger.error("stop player failure", e)
        }
    }

    /** Original: k.p(long) — libera todos os players da sessão. */
    fun releaseSession(session: Long) {
        for (key in playInfoMap.keys().toList()) {
            val info = playInfoMap[key]
            if (info != null && info.session == session) { stopPlayer(info, true); playInfoMap.remove(key) }
        }
    }

    /** Original: k.g() */
    fun mainPlayer(): PlayerInfo? = playInfoMap[MAIN_PLAYER]
    /** Original: k.f() — padrão 1. */
    fun decodeMode(): Int = decodeModeMap[MAIN_PLAYER] ?: 1
    /** Original: k.n(int) */
    fun setDecodeMode(mode: Int) { decodeModeMap[MAIN_PLAYER] = mode }
    /** Original: k.i() */
    fun playerArgs(): Map<String, String> = playerArgsMap
    /** Original: k.e() — "enlargeprobesize", padrão 5600000. */
    fun enlargeProbeSize(): Long = try { playerArgsMap["enlargeprobesize"]?.toLong() ?: 5600000L } catch (_: Throwable) { 5600000L }
    /** Original: k.l() — "probesize", padrão 350000. */
    fun probeSize(): Long = try { playerArgsMap["probesize"]?.toLong() ?: 350000L } catch (_: Throwable) { 350000L }
}

/**
 * Original: x1/f1/lb/widget/videoview/j.java — estado de um IMediaPlayer.
 * `playerId` = hashCode do player (enviado ao proxy como parâmetro `player`).
 */
class PlayerInfo(
    var mediaPlayer: IMediaPlayer?,
    val url: String,
    val decodeMode: Int,
    val hardwareDecodeFlag: Long,
    val session: Long,
) {
    val playerId: Int = mediaPlayer?.hashCode() ?: 0
    var videoInfo: VideoInfo? = null
    var status: Int = 0

    /** Original: j.a(j$a) — executa com o player se não for nulo, engolindo exceções. */
    fun withPlayer(callback: (IMediaPlayer) -> Unit) {
        val p = mediaPlayer ?: return
        try { callback(p) } catch (_: Throwable) {}
    }
}

/** Original: x1/f1/lb/widget/videoview/g0.java */
data class VideoInfo(val width: Int, val height: Int, val sarNum: Int, val sarDen: Int)
