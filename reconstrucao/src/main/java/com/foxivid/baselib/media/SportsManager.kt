package com.foxivid.baselib.media

import com.foxivid.baselib.cache.BaseCache
import com.foxivid.baselib.api.SportsApiClient
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.model.sports.Match
import com.foxivid.baselib.model.sports.Sport
import com.foxivid.baselib.model.sports.Tournament
import com.foxivid.baselib.util.Preferences
import com.foxivid.baselib.util.SandwichErrors
import com.google.gson.Gson
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
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
    private var nextQueryTime = 0L // Original: j.d (f20848d)
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

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
        // Original: j$i ("init$5") — restaura a última versão persistida em `sports_data_version_<env>`
        // (o flow de Preferences ignora erros: `.catch {}`).
        scope.launch {
            Preferences.get("sports_data_version_" + BaseLibConfig.env, lastVersion)
                .catch { }
                .collect { lastVersion = it }
        }
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

    /** Original: j.E() — intervalo entre consultas de versão: o maior entre a config e o padrão. */
    private fun queryInterval(): Long =
        if (BaseLibConfig.refreshSportsEventInterval > queryDataVersionInterval) BaseLibConfig.refreshSportsEventInterval
        else queryDataVersionInterval

    /**
     * Original: j.G() — esportes: lê o cache `sports` (+ mapa `sports_id_map`, se ainda não carregado). Se faltar
     * algum dos dois, relê o cache; sem dados reseta a versão para "1" (persistindo), dispara [checkDataVersion],
     * espera (polling de 500 ms) o fim da atualização e devolve o cache recarregado.
     * (Reconstruído do fallback do jadx; o fluxo "cache vazio" foi inferido pela sequência de chamadas.)
     */
    suspend fun getSports(): Sports? {
        var sports = lastSports?.get("sports")
        if (matchIdsMap.isEmpty()) lastSportIdMap?.get("sports_id_map")?.let { matchIdsMap = it }
        if (sports == null || matchIdsMap.isEmpty()) {
            sports = lastSports?.get("sports")
            if (sports != null) return sports
            if (lastVersion != "1") {
                lastVersion = "1"
                Preferences.putString("sports_data_version_" + BaseLibConfig.env, "1")
            }
            checkDataVersion()
            while (isInUpdating.get()) delay(500)
            lastSportIdMap?.get("sports_id_map")?.let { matchIdsMap = it }
            return lastSports?.get("sports")
        }
        return sports
    }

    /** Original: j.H(sportId) — cache `lastTournaments[sportId]` ou rede ([queryTournaments]). */
    suspend fun getTournaments(sportId: String): Tournaments? =
        lastTournaments?.get(sportId) ?: queryTournaments(sportId)

    /**
     * Original: j.F(sportId, tournamentId, date) — só responde se o mapa de ids ([matchIdsMap], `data -> torneio ->
     * {esportes}`) contém a combinação; então usa o cache `sportId.tournamentId.date` ou a rede ([queryMatches]).
     * Mapa vazio ⇒ log de erro "query matches null, matchIds empty [v..]" e `null`.
     */
    suspend fun getMatches(sportId: String, tournamentId: String, date: String): Matches? {
        if (matchIdsMap.isEmpty()) {
            logger.error("query matches null, matchIds empty [v$lastVersion][$sportId][$tournamentId]$[$date]")
            return null
        }
        if (matchIdsMap[date]?.get(tournamentId)?.contains(sportId) != true) return null
        return lastMatches?.get(matchKey(sportId, tournamentId, date)) ?: queryMatches(sportId, tournamentId, date)
    }

    /** Original: j.I(sportId, tournamentId, date) ("queryMatches") — rede; erros são logados; guarda em cache ([cacheMatches]). */
    private suspend fun queryMatches(sportId: String, tournamentId: String, date: String): Matches? {
        val rsp = SportsApiClient.queryMatches(tournamentId, date)
        var result: Matches? = null
        if (rsp is ApiResponse.Success) result = rsp.data
        if (rsp is ApiResponse.Failure) logger.error("get matches failure:" + SandwichErrors.describe(rsp))
        if (rsp is ApiResponse.Failure.Exception) logger.error("get matches exception: " + SandwichErrors.describe(rsp))
        if (rsp is ApiResponse.Failure.Error) logger.error("get matches error: " + SandwichErrors.describe(rsp))
        cacheMatches(sportId, tournamentId, date, result)
        return result
    }

    /** Original: j.J(version) ("querySports") — rede; erros logados; guarda em cache ([cacheSports]). */
    private suspend fun querySports(version: String): Sports? {
        val rsp = SportsApiClient.querySports()
        var result: Sports? = null
        if (rsp is ApiResponse.Success) result = rsp.data
        if (rsp is ApiResponse.Failure) logger.error("get sports failure:" + SandwichErrors.describe(rsp))
        if (rsp is ApiResponse.Failure.Exception) logger.error("get sports exception: " + SandwichErrors.describe(rsp))
        if (rsp is ApiResponse.Failure.Error) logger.error("get sports error: " + SandwichErrors.describe(rsp))
        cacheSports(version, result)
        return result
    }

    /** Original: j.K(sportId) ("queryTournaments") — rede; erros logados; guarda em cache ([cacheTournaments]). */
    private suspend fun queryTournaments(sportId: String): Tournaments? {
        val rsp = SportsApiClient.queryTournaments(sportId)
        var result: Tournaments? = null
        if (rsp is ApiResponse.Success) result = rsp.data
        if (rsp is ApiResponse.Failure) logger.error("get tournaments failure:" + SandwichErrors.describe(rsp))
        if (rsp is ApiResponse.Failure.Exception) logger.error("get tournaments exception: " + SandwichErrors.describe(rsp))
        if (rsp is ApiResponse.Failure.Error) logger.error("get tournaments error: " + SandwichErrors.describe(rsp))
        cacheTournaments(sportId, result)
        return result
    }

    /** Original: j.q(sportId, tournamentId, date, matches) ("cacheMatches") — em debug loga a diferença com o cache anterior. */
    private suspend fun cacheMatches(sportId: String, tournamentId: String, date: String, matches: Matches?) {
        if (matches == null) return
        val key = matchKey(sportId, tournamentId, date)
        if (BaseLibConfig.isDebug) {
            val old = lastMatches?.get(key)?.matches
            diffLog("update_cache_matches[${matches.tournamentId}][${matches.date}]", diff(old, matches.matches) { it.matchId })
        }
        lastMatches?.put(key, matches)
    }

    /** Original: j.u(sportId, tournaments) ("cacheTournaments") — chave do cache = sportId; diff por `tournamentId`. */
    private suspend fun cacheTournaments(sportId: String, tournaments: Tournaments?) {
        if (tournaments == null) return
        if (BaseLibConfig.isDebug) {
            val old = lastTournaments?.get(sportId)?.tournaments
            diffLog("update_cache_tournaments[$sportId]", diff(old, tournaments.tournaments) { it.tournamentId })
        }
        lastTournaments?.put(sportId, tournaments)
    }

    /**
     * Original: j.s(version, sports) ("cacheSports") — decompõe a resposta `sports/home` em caches separados:
     * 1. `sports` = lista "magra" de esportes (sem torneios);
     * 2. para cada esporte um [Tournaments] magro (sem partidas) via [cacheTournaments];
     * 3. as partidas de cada torneio são agrupadas por data (`yyyy-MM-dd` do `startAt`) e gravadas por
     *    [cacheMatches] (`sportId.tournamentId.date`);
     * 4. monta o mapa de ids `data -> tournamentId -> {sportId}` (`sports_id_map`).
     * Ao final grava `sports` e `sports_id_map`, atualiza [lastVersion] (`sports.version` ou a versão recebida) e a
     * preferência `sports_data_version_<env>`, publica [matchIdsMap] e agenda a próxima consulta (`now + intervalo`).
     * Falha ao processar uma partida é logada ("parse match start[..] failure") e ignorada.
     */
    private suspend fun cacheSports(version: String, sports: Sports?) {
        if (sports == null) return
        val newVersion = sports.version?.toString() ?: version
        val ids = LinkedHashMap<String, MutableMap<String, MutableSet<String>>>()
        val slimSports = ArrayList<Sport>()
        val slim = Sports(sports.defaultSportId, sports.defaultTournamentId, sports.todayDate, slimSports, sports.version)
        val fmt = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()) // util/n.h(3, ms)
        for (sport in sports.sports ?: emptyList()) {
            slimSports.add(Sport(sport.sportId, sport.slug, sport.name, sport.iconUrl, emptyList(), sport.default))
            val slimTournaments = ArrayList<Tournament>()
            val tournaments = Tournaments(sport.sportId, slimTournaments)
            val sportId = sport.sportId?.toString() ?: ""
            for (t in sport.tournaments ?: emptyList()) {
                slimTournaments.add(Tournament(t.tournamentId, t.name, t.seasonCode, emptyList(), t.default))
                val tournamentId = t.tournamentId?.toString() ?: ""
                val byDate = LinkedHashMap<String, MutableList<Match>>()
                for (m in t.matchList ?: emptyList()) {
                    try {
                        val date = fmt.format(java.util.Date(m.startAt!!))
                        ids.getOrPut(date) { LinkedHashMap() }.getOrPut(tournamentId) { LinkedHashSet() }.add(sportId)
                        byDate.getOrPut(date) { ArrayList() }.add(m)
                    } catch (e: Throwable) {
                        logger.error("parse match start[${m.startAt}] failure: [${t.tournamentId}.${m.matchId}.${m.tournamentId}]", e)
                    }
                }
                for ((date, list) in byDate) cacheMatches(sportId, tournamentId, date, Matches(t.tournamentId, date, list))
            }
            cacheTournaments(sportId, tournaments)
        }
        if (BaseLibConfig.isDebug) {
            val old = lastSports?.get("sports")?.sports
            diffLog("update_cache_sports[v$lastVersion -> v$newVersion]", diff(old, sports.sports) { it.sportId })
        }
        if (ids.isEmpty()) logger.warn("got new version[$newVersion], but data is empty[${Gson().toJson(sports)}]")
        lastSports?.put("sports", slim)
        lastSportIdMap?.put("sports_id_map", ids)
        lastVersion = newVersion
        Preferences.putString("sports_data_version_" + BaseLibConfig.env, newVersion)
        matchIdsMap = ids
        nextQueryTime = ServerTime.now() + queryInterval()
    }

    /**
     * Original: j.x(old, new, key) — compara duas listas por chave e devolve Triple(adicionados, removidos,
     * alterados): adicionados = itens novos sem chave na lista antiga; removidos = itens antigos sem chave na nova;
     * alterados = itens novos cuja chave existe na antiga mas com valor diferente (`!=`).
     */
    fun <K, V> diff(old: List<V>?, new: List<V>?, key: (V) -> K): Triple<List<V>, List<V>, List<V>> {
        val oldMap = LinkedHashMap<K, V>()
        val newMap = LinkedHashMap<K, V>()
        val added = ArrayList<V>(); val removed = ArrayList<V>(); val changed = ArrayList<V>()
        for (v in old ?: emptyList()) oldMap[key(v)] = v
        for (v in new ?: emptyList()) {
            newMap[key(v)] = v
            val prev = oldMap[key(v)]
            if (prev == null) added.add(v) else if (prev != v) changed.add(v)
        }
        for (v in old ?: emptyList()) if (newMap[key(v)] == null) removed.add(v)
        return Triple(added, removed, changed)
    }

    /** Original: j.y(title, triple) — log (debug) de "title: add[n] remove[n] update[n]" e de cada item em JSON. */
    fun <V> diffLog(title: String, triple: Triple<List<V>, List<V>, List<V>>) {
        val (added, removed, changed) = triple
        if (added.isEmpty() && removed.isEmpty() && changed.isEmpty()) return
        val gson = Gson()
        logger.debug("$title: add[${added.size}] remove[${removed.size}] update[${changed.size}]")
        added.forEach { logger.debug("$title add: ${gson.toJson(it)}") }
        removed.forEach { logger.debug("$title remove: ${gson.toJson(it)}") }
        changed.forEach { logger.debug("$title update: ${gson.toJson(it)}") }
    }

    /**
     * Original: j.w() + j$d ("checkAndUpdateSports$1") — se habilitado, não há atualização em andamento e
     * `now >= nextQueryTime`, marca [isInUpdating] e consulta `dataVersion(lastVersion)`; erros (error/failure/
     * exception) são logados ("query data version error/failure/exception:..."). Se `changed == true` chama
     * [querySports] com a nova versão (ou `null`); em debug loga "update_cache_check_data_version[v.. -> v..]
     * changed[..]". Sempre (finally) agenda `nextQueryTime = nextQueryTime + intervalo` e libera [isInUpdating].
     * (Note: o original soma o intervalo ao valor ANTERIOR de `nextQueryTime`, não a `now`.)
     */
    fun checkDataVersion() {
        if (!enableSports) return
        if (isInUpdating.get()) return
        if (ServerTime.now() < nextQueryTime) return
        if (!isInUpdating.compareAndSet(false, true)) return
        scope.launch {
            try {
                var dataVersion: com.foxivid.baselib.model.sports.DataVersion? = null
                val rsp = SportsApiClient.queryDataVersion(lastVersion)
                if (rsp is ApiResponse.Success) dataVersion = rsp.data
                if (rsp is ApiResponse.Failure.Error) logger.error("query data version error:" + SandwichErrors.describe(rsp))
                if (rsp is ApiResponse.Failure) logger.error("query data version failure:" + SandwichErrors.describe(rsp))
                if (rsp is ApiResponse.Failure.Exception) logger.error("query data version exception:" + SandwichErrors.describe(rsp))
                if (dataVersion == null) return@launch
                if (BaseLibConfig.isDebug) {
                    logger.debug("update_cache_check_data_version[v$lastVersion -> v${dataVersion.version}] changed[${dataVersion.changed}]")
                }
                if (dataVersion.changed != true) return@launch
                try {
                    querySports(dataVersion.version?.toString() ?: lastVersion)
                } catch (t: Throwable) {
                    logger.error("update sports failure", t)
                }
            } catch (t: Throwable) {
                logger.error("query data version failure", t)
            } finally {
                nextQueryTime += queryInterval()
                isInUpdating.set(false)
            }
        }
    }
}
