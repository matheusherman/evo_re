package com.foxivid.baselib.player

import android.util.LruCache
import com.foxivid.baselib.cache.BaseCache
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.network.HeaderInterceptor
import com.foxivid.baselib.streaming.PlayUrlReadyEvent
import com.foxivid.baselib.streaming.engine.PlayType
import com.foxivid.baselib.user.UserManager
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory
import java.io.IOException
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Original: x1/f1/lb/widget/videoview/f.java — contexto de uma reprodução pedida pela UI.
 * `flowCreator` produz o fluxo de [PlayUrlReadyEvent] (ao vivo: StreamHelper.createLivePlayFlow;
 * catch-up: StreamHelper.createCatchupPlayFlow).
 */
class PlayContext(
    var uid: String,
    var loginTime: Long,
    val videoName: String,
    val playType: PlayType,
    val playPositionPersistenceKey: String,
    val playerArgs: String?,
    val mediaId: String,
    val routeId: String,
    val mediaMode: Int,
    val isFree: Boolean,
    val subtitleMediaId: String,
    val forceToStart: AtomicBoolean,
    val flowCreator: FlowCreator,
) {
    var session: Long = 0
    var preSetSeekPosition: Long? = null

    /** Original: c0$d */
    fun interface FlowCreator {
        suspend fun create(forceToStart: AtomicBoolean): Flow<PlayUrlReadyEvent>
    }
}

/** Original: x1/f1/lb/widget/videoview/h.java — sessão de play (evento + legenda). */
data class PlaySession(val event: PlayUrlReadyEvent, val subtitleMediaId: String, val subtitleCdnUrl: String)

/**
 * Original: x1/f1/lb/widget/videoview/i.java ("PlaySessionCache.kt")
 * LRU (10) de [PlaySession] por session; ao inserir, remove sessões antigas do mesmo mediaId.
 */
object PlaySessionCache {
    private val cache = LruCache<Long, PlaySession>(10)

    /** Original: i.b(long) */
    suspend fun get(session: Long): PlaySession? = withContext(Dispatchers.IO) { cache.get(session) }

    /** Original: i.c(h) */
    fun put(session: PlaySession) {
        val values = cache.snapshot()?.values
        if (!values.isNullOrEmpty()) {
            for (s in values) {
                if (s.event.mediaId == session.event.mediaId && s.event.session != session.event.session) cache.remove(s.event.session)
            }
        }
        cache.put(session.event.session, session)
    }

    /** Original: i.d(long) */
    suspend fun remove(session: Long): PlaySession? = withContext(Dispatchers.IO) { cache.remove(session) }
}

/**
 * Original: x1/f1/lb/widget/videoview/g.java ("PlayPositionCache.kt")
 * Posição de reprodução (VoD/catch-up) persistida em disco. Chave = util.o.e(<usuário>, videoName),
 * onde <usuário> = id do dispositivo (of.a.k()) para convidado/sem login, senão of.a.b() (uid).
 */
object PlayPositionCache {
    private val logger = LoggerFactory.getLogger(PlayPositionCache::class.java)
    private var diskLruCache: BaseCache<Long>? = null

    /** Original: g.g() */
    private fun owner(): String = 
        if ((UserManager.getAccountType() == "guest" || UserManager.getUsername().isEmpty())) HeaderInterceptor.deviceId() else HeaderInterceptor.accountId() // user.f.c0()=="guest" || D0().isEmpty()

    private fun key(videoName: String): String = TODO("x1.f1.lb.util.o.e(owner(), videoName) — util")

    /** Original: g.e(dir, appVersion, maxSize) */
    fun init(cacheDirectory: String, appVersion: Int, maxSize: Long) {
        try { diskLruCache = BaseCache(cacheDirectory, object : TypeToken<Long>() {}.type, appVersion, maxSize) }
        catch (e: IOException) { logger.error("create play position cache failure", e) }
    }

    /** Original: g.d(videoName) — emite a posição (0 se ausente/erro). */
    fun get(videoName: String): Flow<Long> = flow {
        val c = diskLruCache
        if (c == null) { emit(0L); return@flow }
        try { emit(c.get(key(videoName)) ?: 0L) }
        catch (t: Throwable) { emit(0L); logger.error("load play_position failure[${owner()}.$videoName]", t) }
    }.flowOn(Dispatchers.IO)

    /** Original: g.f(videoName, position) */
    fun put(videoName: String, position: Long) {
        val c = diskLruCache ?: return
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val ok = c.put(key(videoName), position)
                if (BaseLibConfig.isDebug) logger.debug("cache play_position [${owner()}.$videoName] position[$position] [$ok]")
            } catch (t: Throwable) {
                logger.error("cache play_position failure[${owner()}.$videoName] position[$position]", t)
            }
        }
    }
}
