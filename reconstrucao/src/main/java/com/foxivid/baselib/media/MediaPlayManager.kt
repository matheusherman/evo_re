package com.foxivid.baselib.media

import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.player.TrialStatus
import com.foxivid.baselib.user.UserManager
import com.foxivid.baselib.util.Preferences
import com.foxivid.baselib.util.ServerTime
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import java.util.concurrent.atomic.AtomicLong

/**
 * Original: x1/f1/lb/media/e.java ("MediaPlayManager.kt") (+ e$a, TypeToken e$a$a)
 *
 * Controle do tempo de teste ("trial") por canal/mídia: acumula o tempo assistido (ms) por `streamId`, persiste
 * em `channel_played_time` (JSON `Map<String, Long>`) no máx. a cada 30 s e zera a cada 24 h
 * (`channel_played_date`). [trialOf] decide se um conteúdo pode ser exibido:
 * - assinante com plano válido e não "free" ⇒ [TrialStatus.SUBSCRIBED];
 * - mídia com privilégio 2 ou 3 ⇒ [TrialStatus.FREE];
 * - senão, tempo assistido < tempo grátis (`UserManager.n0()`) ⇒ [TrialStatus.NO_FREE_BUT_HAS_TRIAL_TIME],
 *   senão [TrialStatus.NO_FREE_NO_TRIAL_TIME].
 */
object MediaPlayManager {
    private val logger = LoggerFactory.getLogger(MediaPlayManager::class.java)
    private val gson = Gson()
    private var playedTimeMap: MutableMap<String, AtomicLong> = HashMap()
    private val playedTimeSavedTimeMap: MutableMap<String, AtomicLong> = HashMap()

    init { loadMediaPlayedTime() }

    /** Original: e.g() / e$a ("loadMediaPlayedTime$1"). */
    private fun loadMediaPlayedTime() {
        CoroutineScope(SupervisorJob() + Dispatchers.IO).launch {
            try {
                val lastDate = Preferences.getLong("channel_played_date", 0L)
                val now = ServerTime.now()
                if (now - lastDate > 86_400_000L) {
                    // passou 24 h: começa um novo dia de trial (não carrega o mapa antigo)
                    Preferences.putLong("channel_played_date", now)
                    return@launch
                }
                val json = Preferences.getString("channel_played_time", "")
                if (json.isEmpty()) return@launch
                playedTimeMap = gson.fromJson(json, object : TypeToken<MutableMap<String, AtomicLong>>() {}.type)
            } catch (e: Exception) {
                logger.error("load subscribed channels failure", e)
            }
        }
    }

    /** Original: e.h() */
    private fun savePlayedTime() {
        try {
            Preferences.putString("channel_played_time", gson.toJson(playedTimeMap))
        } catch (e: Exception) {
            logger.error("save played time failure", e)
        }
    }

    /** Original: e.d(streamId, timeMs) — soma ao acumulado e grava no máx. a cada 30 s por canal. */
    fun addPlayedTime(streamId: String, timeMs: Long) {
        val acc = playedTimeMap[streamId]
        if (acc == null) playedTimeMap[streamId] = AtomicLong(timeMs) else acc.addAndGet(timeMs)
        val saved = playedTimeSavedTimeMap[streamId]
        val now = ServerTime.elapsedNow()
        if (now - (saved?.get() ?: 0L) < 30_000L) return
        if (saved == null) playedTimeSavedTimeMap[streamId] = AtomicLong(now) else saved.set(now)
        savePlayedTime()
    }

    /** Original: e.e(mediaId, mediaPrivilegeType) ("trialOf") */
    fun trialOf(mediaId: String?, mediaPrivilegeType: Int?): TrialStatus {
        if (mediaId == null) return TrialStatus.NO_FREE_NO_TRIAL_TIME
        val hasPlan = UserManager.hasValidPlan()   // Original: user.f.G0()
        val isFree = UserManager.isGuestOrFree()         // Original: user.f.N0()
        val played = playedTime(mediaId)
        val trialLimit = UserManager.getRemainingMs()   // Original: user.f.n0()
        if (BaseLibConfig.isDebug) logger.debug("trialOf [$mediaId] detail: [$hasPlan, $isFree, $played / $trialLimit]")
        if (hasPlan && !isFree) return TrialStatus.SUBSCRIBED
        if (mediaPrivilegeType == 3 || mediaPrivilegeType == 2) return TrialStatus.FREE
        return if (!(isFree && hasPlan) && played >= trialLimit) TrialStatus.NO_FREE_NO_TRIAL_TIME
        else TrialStatus.NO_FREE_BUT_HAS_TRIAL_TIME
    }

    /** Original: e.f(streamId) — ms assistidos hoje. */
    fun playedTime(streamId: String): Long = playedTimeMap[streamId]?.get() ?: 0L
}
