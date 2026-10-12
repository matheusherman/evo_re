package com.foxivid.baselib.media

import com.foxivid.baselib.cache.BaseCache
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.model.sports.Matches
import com.foxivid.baselib.model.sports.Sports
import com.foxivid.baselib.model.sports.Tournaments
import com.foxivid.baselib.util.ServerTime
import com.google.gson.reflect.TypeToken
import org.slf4j.LoggerFactory
import java.io.File
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Original: x1/f1/lb/media/j.java ("SportsManager.kt", ~2.750 linhas; a maior parte é máquina de estado de corrotina)
 *
 * Agenda esportiva (esportes -> torneios -> partidas por data), com cache em disco e versionamento:
 * - Verifica `dataVersion(lastVersion)` a cada `queryDataVersionInterval` (10 min; 30 s em debug; se a config
 *   da lib pedir mais que isso, usa o valor da config — `E()`).
 * - Quando a versão muda, rebaixa esportes/torneios/partidas e grava nos caches ([BaseCache]) em subpastas
 *   `s` (10 KiB), `t` (1 MiB), `m` (10 MiB) e
 *   `id` (mapa sportId->tournamentId->{matchIds}, 40 KiB).
 * - Chave de partidas: `sportId.tournamentId.date`; datas "yyyy-MM-dd" (Locale.UK, UTC).
 * - [getSubjectDateList]: hoje ±7 dias (`util.n.h(3, ...)`) quando não há mapa de partidas.
 * - [diff] / log de diferenças (x/y): compara listas antigas e novas por chave e devolve (removidos, novos, mantidos).
 * Consultas ([getSports], [getTournaments], [getMatches]) tentam rede ([com.foxivid.baselib.api.SportsApiClient]) e
 * caem no cache.
 */
object SportsManager {
    private val logger = LoggerFactory.getLogger(SportsManager::class.java)
    private var lastVersion = "1"
    private var queryDataVersionInterval = 600_000L
    private val isInUpdating = AtomicBoolean(false)
    private val utcSdf = SimpleDateFormat("yyyy-MM-dd", Locale.UK)
    private var matchIdsMap: Map<String, Map<String, Set<String>>> = emptyMap()
    private var enableSports = false
    private var today: Long? = null

    private var lastSports: BaseCache<Sports>? = null
    private var lastTournaments: BaseCache<Tournaments>? = null
    private var lastMatches: BaseCache<Matches>? = null
    private var lastSportIdMap: BaseCache<Map<String, Map<String, Set<String>>>>? = null

    /** Original: j.z() */
    fun enable() { enableSports = true }

    /** Original: j.A() */
    fun version() = lastVersion

    /** Original: j.D(sportId, tournamentId, date) */
    private fun matchKey(sportId: String, tournamentId: String, date: String) = "$sportId.$tournamentId.$date"

    /** Original: j.C(cacheDirectory, appVersion) — cria os 4 caches e dispara o carregamento inicial (j$i). */
    fun init(cacheDirectory: String, appVersion: Int) {
        val sep = File.separator
        lastSports = BaseCache(cacheDirectory + sep + "s", object : TypeToken<Sports>() {}.type, appVersion, 10_240L)
        lastTournaments = BaseCache(cacheDirectory + sep + "t", object : TypeToken<Tournaments>() {}.type, appVersion, 1_048_576L)
        lastMatches = BaseCache(cacheDirectory + sep + "m", object : TypeToken<Matches>() {}.type, appVersion, 10_485_760L)
        lastSportIdMap = BaseCache(cacheDirectory + sep + "id",
            object : TypeToken<Map<String, Map<String, Set<String>>>>() {}.type, appVersion, 40_960L)
        // Original: launch { j$i } — carrega versão/mapa do disco (corpo em corrotina não reconstruído).
        if (BaseLibConfig.isDebug) queryDataVersionInterval = 30_000L
    }

    /** Original: j.B() — datas disponíveis: chaves do mapa de partidas (ordenadas desc.) ou hoje −7..+7 dias. */
    fun getSubjectDateList(): List<String> {
        if (matchIdsMap.isNotEmpty()) return matchIdsMap.keys.sorted().reversed()
        val list = ArrayList<String>()
        try {
            val base = today ?: ServerTime.now()
            val fmt = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            for (i in -7 until 8) list.add(fmt.format(java.util.Date(i * 24L * 3_600_000L + base)))
        } catch (t: Throwable) {
            logger.error("get subject date list failure", t)
        }
        return list
    }

    /** Original: j.G() — esportes (rede → cache). Corpo não reconstruído (máquina de estados enorme). */
    suspend fun getSports(): Sports? = TODO("x1.f1.lb.media.j.G/J — consulta SportsApiClient.querySports e cacheia em lastSports")

    /** Original: j.H(sportId) / j.K — torneios. */
    suspend fun getTournaments(sportId: String): Tournaments? = TODO("x1.f1.lb.media.j.H/K — SportsApiClient.queryTournaments + cache")

    /** Original: j.F(sportId, tournamentId, date) / j.I — partidas; log "query matches null, matchIds empty [v...]". */
    suspend fun getMatches(sportId: String, tournamentId: String, date: String): Matches? =
        TODO("x1.f1.lb.media.j.F/I — SportsApiClient.queryMatches(tournamentId, date) + cache")

    /**
     * Original: j.x(old, new, keyFn) — compara duas listas por chave e devolve Triple(removidos, adicionados, comuns).
     * (assinatura jadx: `u<List<V>,List<V>,List<V>>`, ordem exata das posições não conferida)
     */
    fun <K, V> diff(old: List<V>, new: List<V>, key: (V) -> K): Triple<List<V>, List<V>, List<V>> {
        val oldKeys = old.map(key).toSet(); val newKeys = new.map(key).toSet()
        return Triple(old.filter { key(it) !in newKeys }, new.filter { key(it) !in oldKeys }, new.filter { key(it) in oldKeys })
    }

    /** Original: j.w() — dispara a checagem periódica de versão (j$... "update_cache_check_data_version[v.. -> v..]"). */
    fun checkDataVersion(): Unit = TODO("x1.f1.lb.media.j.w + j\$j — consulta dataVersion(lastVersion) e, se mudou, atualiza caches")
}
