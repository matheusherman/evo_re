package com.foxivid.baselib.media

import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.model.meta.ChannelEPGIndexResponse
import com.foxivid.baselib.model.meta.EPGProgramme
import com.foxivid.baselib.model.meta.EpgIndex
import com.foxivid.baselib.util.AppPaths
import com.foxivid.baselib.util.DownloadUtils
import com.foxivid.baselib.util.Preferences
import com.foxivid.baselib.util.ServerTime
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.greenrobot.eventbus.EventBus
import org.slf4j.LoggerFactory
import java.io.File
import java.io.FileReader
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentSkipListMap

/** Original: x1/f1/lb/media/c$a — parser externo (injetado pela app) que lê um arquivo EPG e devolve a lista. */
fun interface EpgFileParser {
    suspend fun parse(channelId: String, file: File): List<EPGProgramme>?
}

/** Original: nf/e — evento de EventBus "EPG atualizado" (postado por [EpgManager] ao concluir a atualização do índice). */
class EpgUpdatedEvent

/**
 * Original: x1/f1/lb/media/c.java ("EpgManager.kt") (+ c$a..c$q, c$b/c$d/... = continuações de corrotina)
 *
 * Guia de programação (EPG) — índice + arquivos por canal/data, com checksum.
 *
 * Fluxo:
 * 1. [ChannelManager] recebe `ChannelListResponse.channelEPGIndexResponse` (`indexAddress` + `checksum`) e chama [update].
 * 2. [startUpdate] só baixa depois que o player está pronto ([allowStart], chamado quando a 1ª URL de play fica pronta).
 * 3. [saveAndUpdate] baixa `epg-index.json` (dir `AppPaths.epgCachePath()`) — o arquivo é reaproveitado se o MD5
 *    bater com o checksum do último índice (pref `epg_index_last_checksum`); em seguida [parseEpgIndex] lê o
 *    mapa `data(yyyyMMdd) -> List<EpgIndex>` (ordenado: hoje, amanhã, ontem, depois alfabético) e
 *    [updateAll] sincroniza os arquivos.
 * 4. Cada [EpgIndex] aponta para `file` (URL) com `checksum` (MD5) e `channelId`. O arquivo local chama-se
 *    `<channelId sem espaços>.<pos>` ([fileName]), onde `pos` é a posição da data em [posMap].
 *    [downloadEpg] baixa/valida e já faz o parse ([loadProgrammes] com `forceRefresh=true`).
 * 5. Consulta: [getProgrammeAt], [getTwoProgrammesAt] (atual + próximo), [getProgrammes]/[getDateList]/[getChannelIds].
 *
 * Cache em memória: `cacheItemMap[pos][caminhoDoArquivo]` com política LRU de 30 entradas ([epgCacheMap], ordenado
 * por hora de acesso).
 * Intervalo de atualização: 6 h (`epgUpdateInterval = 21600000`); primeira rodada sempre atualiza.
 */
object EpgManager {

    private val logger = LoggerFactory.getLogger(EpgManager::class.java)
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    private var isInUpdating = false
    private var nextUpdateUrl: String? = null
    private var nextUpdateChecksum: String? = null
    private var epgResponse: ChannelEPGIndexResponse? = null
    private var canStart = false
    private var isEpgUpdateComplete = false
    private var epgFileParser: EpgFileParser? = null

    /** data (yyyyMMdd) -> posição (parte do nome do arquivo local). */
    private val posMap = ConcurrentHashMap<String, Int>()
    private var epgHost = ""
    private var epgUpdateInterval = 21_600_000L
    private var nextUpdateTime = ServerTime.elapsedNow()
    private var isFirstRoundEPG = true
    private var isEnable = true

    /** hora de acesso -> (pos, caminho do arquivo) — ordem LRU. */
    private val epgCacheMap = ConcurrentSkipListMap<Long, Pair<Int, String>>()
    private val cacheItemMap = ConcurrentHashMap<Int, ConcurrentHashMap<String, List<EPGProgramme>>>()

    /** Original: c.E(parser) */
    fun setListener(parser: EpgFileParser) { epgFileParser = parser }

    /** Original: c.F() */
    fun isUpdateComplete() = isEpgUpdateComplete

    /** Original: c.P() — libera o início das atualizações (chamado por StreamHelper quando a URL de play fica pronta). */
    fun allowStart() { if (!canStart) canStart = true }

    /** Original: c.s(isEnable) */
    fun setEnable(enable: Boolean) { isEnable = enable }

    /** Original: c.S(response) — recebe o índice do `channel/list`. */
    fun update(response: ChannelEPGIndexResponse?) {
        if (!isEnable) { logger.debug("epg: disable"); return }
        val indexAddress = response?.indexAddress
        if (indexAddress == null) {
            logger.warn("epg: updateEpg response url is null")
        } else {
            epgResponse = response
            startUpdate(indexAddress, response.checksum)
        }
    }

    /** Original: c.q(now) — chamado periodicamente: reatualiza na 1ª rodada ou quando `now >= nextUpdateTime`. */
    fun checkUpdate(now: Long) {
        if (!isEnable || isInUpdating) return
        val url = nextUpdateUrl ?: epgResponse?.indexAddress
        val checksum = nextUpdateChecksum ?: epgResponse?.checksum
        if (url == null) return
        if (isFirstRoundEPG || now >= nextUpdateTime) startUpdate(url, checksum)
    }

    /** Original: c.R(url, checksum) ("updateEpg") */
    private fun startUpdate(url: String, checksum: String?) {
        if (!canStart && BaseLibConfig.isDebug) {
            logger.debug("epg: wait for player is ready first, then updateEpg url[{}], checksum[{}], host[{}]", url, checksum, epgHost)
            return
        }
        // Original: ac.g.q(url, 0, ac.g.e(url, "/", 8)) — esquema + host até a 3ª '/' (ocorrência a partir do índice 8)
        epgHost = url.substring(0, url.indexOf('/', 8).let { if (it < 0) url.length else it })
        if (BaseLibConfig.isDebug) logger.debug("epg: updateEpg url[{}], checksum[{}], host[{}]", url, checksum, epgHost)
        if (url.isEmpty()) {
            logger.warn("epg: updateEpg index url is empty or checksum is empty")
            return
        }
        if (isInUpdating) return
        synchronized(this) {
            if (isInUpdating) return
            isInUpdating = true
            // Original: c$q ("updateEpg$2")
            scope.launch {
                try {
                    if (saveAndUpdate(url, checksum)) {
                        isEpgUpdateComplete = true
                        EventBus.getDefault().post(EpgUpdatedEvent()) // nf.e
                    }
                    isFirstRoundEPG = false
                } catch (e: Exception) {
                    logger.error("epg: updateEpg failure", e)
                } finally {
                    isInUpdating = false
                }
            }
        }
    }

    /**
     * Original: c.O(url, checksum) ("saveAndUpdate") + c$o (contexto `epg-index.json`) + c$p.
     * Baixa o índice (arquivo `epg-index.json`, sem zip). `isExistingValid` = MD5 do arquivo bate com `""`/
     * [lastChecksum] == checksum pedido. Se baixou: lê o índice novo e chama [updateAll] (antigo, novo). Se não baixou
     * (já válido): usa o índice local para ambos. Em sucesso guarda `nextUpdateUrl/Checksum`, persiste
     * `epg_index_last_checksum` e agenda a próxima rodada em `now + 6 h`.
     */
    private suspend fun saveAndUpdate(url: String, checksum: String?): Boolean {
        val lastChecksum = Preferences.getString("epg_index_last_checksum", "")
        val ctx = object : DownloadUtils.PlainDownloadContext(url, AppPaths.epgCachePath(), "epg-index.json") {
            override fun isExistingValid(file: File): Boolean {
                // Original: c$o.f — NOTE: a comparação de MD5 usa checksum "" (b0.n(file, "", 0)) e a de strings
                // compara o checksum salvo com o pedido.
                val ok = DownloadUtils.checkMd5(file, "") && lastChecksum == checksum
                if (!ok) logger.debug("epg: saveAndUpdate, exists index file[{}] checksum mismatch with url[{}] checksum[{}]", file.absolutePath, url, checksum)
                return ok
            }
            override fun verify(file: File): Boolean {
                val ok = DownloadUtils.checkMd5(file, "")
                if (!ok) logger.warn("epg: saveAndUpdate, download index file[{}] from url[{} checksum mismatch[{}]", file.absolutePath, url, checksum)
                return ok
            }
        }
        if (BaseLibConfig.isDebug) logger.debug("epg: save and update [{}] -> [{}]", url, ctx.file.absolutePath)
        var oldIndex: Map<String, List<EpgIndex>> = HashMap()
        // Original: o `b0.g(ctx, false, c$p)` — c$p lê o índice ANTIGO antes de sobrescrever.
        val downloaded = DownloadUtils.download(ctx, false) { oldIndex = parseEpgIndex(it) }
        var ok = false
        if (downloaded) {
            try {
                val newIndex = parseEpgIndex(ctx.file)
                if (BaseLibConfig.isDebug) logger.debug("epg: download epg index complete url[{}] -> file[{}], index[{}]", url, ctx.file.absolutePath, newIndex)
                updateAll(oldIndex, newIndex)
                ok = true
            } catch (e: Exception) {
                logger.error("epg: parse epg index failure", e)
            }
        } else {
            if (!ctx.file.exists()) {
                logger.error("epg index file not exists, not epg update")
                return false
            }
            val index = parseEpgIndex(ctx.file)
            if (BaseLibConfig.isDebug) logger.debug("epg: epg index no update url[{}] -> file[{}], index[{}]", url, ctx.file.absolutePath, index)
            updateAll(index, index)
            ok = true
        }
        if (ok) {
            nextUpdateUrl = url
            nextUpdateChecksum = checksum
            Preferences.putString("epg_index_last_checksum", checksum ?: "")
            nextUpdateTime = ServerTime.elapsedNow() + epgUpdateInterval
        }
        return ok
    }

    /**
     * Original: c.G(file) ("parseEpgIndex") — lê `Map<data, List<EpgIndex>>` via Gson e ordena as chaves:
     * hoje, amanhã, ontem (nessa ordem, segundo [compareDates]) e depois ordem alfabética.
     * Datas baseadas em `ServerTime.now()` (formato yyyyMMdd, locale padrão).
     */
    private fun parseEpgIndex(file: File): Map<String, List<EpgIndex>> {
        try {
            val map: Map<String, List<EpgIndex>> = FileReader(file).use {
                Gson().fromJson(it, object : TypeToken<Map<String, List<EpgIndex>>>() {}.type)
            }
            if (map.isNotEmpty()) {
                val sdf = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
                val cal = Calendar.getInstance().apply { time = Date(ServerTime.now()) }
                val today = sdf.format(cal.time)
                cal.add(Calendar.DATE, 1)
                val tomorrow = sdf.format(cal.time)
                cal.add(Calendar.DATE, -2)
                val yesterday = sdf.format(cal.time)
                // Original: n0.h(map, Comparator) — mapa ordenado (TreeMap com comparador)
                return java.util.TreeMap<String, List<EpgIndex>> { a, b -> compareDates(today, tomorrow, yesterday, a, b) }
                    .also { it.putAll(map) }
            }
        } catch (e: Exception) {
            logger.error("load epg index file failure", e)
        }
        return HashMap()
    }

    /** Original: c.H(today, tomorrow, yesterday, a, b) — hoje < amanhã < ontem < demais (alfabético). */
    internal fun compareDates(today: String, tomorrow: String, yesterday: String, a: String, b: String?): Int {
        if (a == today && b != today) return -1
        if (a == tomorrow && b != today && b != tomorrow) return -1
        if (a == yesterday && b != today && b != tomorrow && b != yesterday) return -1
        if (b == today && a != today) return 1
        if (b == tomorrow && a != today && a != tomorrow) return 1
        if (b == yesterday && a != today && a != tomorrow && a != yesterday) return 1
        return a.compareTo(b!!)
    }

    /**
     * Original: c.K(oldIndex, newIndex) ("saveAndUpdate"/sincronização) — NÃO decompilado (JadxOverflowException).
     * Pelo uso: reconstrói [posMap] (data -> pos) a partir do novo índice e, para cada [EpgIndex], chama
     * [checkAndUpdateEpg] com a pos antiga (do índice anterior) para renomear/baixar o arquivo.
     */
    private suspend fun updateAll(oldIndex: Map<String, List<EpgIndex>>, newIndex: Map<String, List<EpgIndex>>): Unit =
        TODO("nativo/não decompilado: x1.f1.lb.media.c.K(Map, Map) — popula posMap e chama checkAndUpdateEpg por canal")

    /**
     * Original: c.p(epgIndex, newPos, oldPos) ("checkAndUpdateEpg") — decompilação incompleta; reconstruído do que
     * há: se não há `oldPos` ⇒ [downloadEpg]. Senão, se o arquivo antigo (`<canal>.<oldPos>`) já bate com o checksum:
     * mesma pos ⇒ nada; pos diferente ⇒ apaga o destino, renomeia/copia o arquivo e atualiza o cache
     * (reparse com `forceRefresh`); se não bate ⇒ [downloadEpg].
     */
    @Suppress("unused")
    private suspend fun checkAndUpdateEpg(epgIndex: EpgIndex, pos: Int, oldPos: Int?) {
        try {
            if (oldPos == null) { downloadEpg(pos, epgIndex); return }
            val dir = AppPaths.epgCachePath()
            val old = File(dir, fileName(oldPos, epgIndex.channelId!!))
            if (!DownloadUtils.checkMd5(old, epgIndex.checksum)) { downloadEpg(pos, epgIndex); return }
            if (pos == oldPos) return
            val dest = File(dir, fileName(pos, epgIndex.channelId!!))
            if (dest.exists()) {
                if (BaseLibConfig.isDebug) logger.debug("checkAndUpdateEPG remove exits epg file [{}]", dest.absolutePath)
                dest.delete()
            }
            old.copyTo(dest, overwrite = true) // Original: yb.c.n(file, file2)
            loadProgrammes(epgIndex.channelId!!, pos, dest, true)
        } catch (e: Exception) {
            logger.error("checkAndUpdateEPG  failure", e)
        }
    }

    /**
     * Original: c.r(pos, epgIndex) + c$c ("downloadEpg$2", Dispatchers.IO) + c$c$a.
     * Baixa `epgIndex.file` para `epgCachePath/<canal>.<pos>`; válido se MD5 == `epgIndex.checksum`.
     * Se baixou ⇒ faz parse e atualiza o cache em memória.
     */
    private suspend fun downloadEpg(pos: Int, epgIndex: EpgIndex) = withContext(Dispatchers.IO) {
        val url = epgIndex.file!!
        val ctx = object : DownloadUtils.PlainDownloadContext(url, AppPaths.epgCachePath(), fileName(pos, epgIndex.channelId!!), true) {
            override fun isExistingValid(file: File): Boolean {
                val ok = DownloadUtils.checkMd5(file, epgIndex.checksum)
                if (!ok && BaseLibConfig.isDebug) logger.debug("epg: downloadEpg checksum of exists file [{}] mismatch with checksum[{}] of url[{}]", file.absolutePath, epgIndex.checksum, url)
                return ok
            }
            override fun verify(file: File): Boolean {
                val ok = DownloadUtils.checkMd5(file, epgIndex.checksum)
                if (!ok) logger.warn("epg: downloadEpg checksum mismatch url[{}] -> file[{}] checksum[{}]", url, file.absolutePath, epgIndex.checksum)
                return ok
            }
        }
        if (BaseLibConfig.isDebug) logger.debug("epg: downloadEpg url[{}] -> file[{}]", url, ctx.file.absolutePath)
        if (DownloadUtils.download(ctx, false)) loadProgrammes(epgIndex.channelId!!, pos, ctx.file, true)
    }

    /** Original: c.t(pos, channel) — `<canal sem espaços>.<pos>`. */
    private fun fileName(pos: Int, channel: String) = channel.replace(" ", "") + "." + pos

    /**
     * Original: c.I(channelId, pos, file, forceRefresh) ("parseEpg") — usa o cache em memória (se não forçado);
     * senão chama o [EpgFileParser] injetado (lista vazia se nulo), e grava no cache
     * (forçado ⇒ substitui entrada existente; não forçado ⇒ insere/evicta LRU).
     */
    private suspend fun loadProgrammes(channelId: String, pos: Int, file: File, forceRefresh: Boolean = false): List<EPGProgramme> {
        if (!forceRefresh) {
            val cached = cacheGet(pos, file)
            if (BaseLibConfig.isDebug) logger.debug("getCache epg[{}]", cached)
            if (cached != null) return cached
        }
        val list = epgFileParser?.parse(channelId, file) ?: ArrayList()
        if (BaseLibConfig.isDebug) logger.debug("epg: parseEpg pos[{}], channel[{}], epg list.size[{}]", pos, channelId, list.size)
        if (channelId != "" && list.isNotEmpty()) {
            if (forceRefresh) cacheReplace(pos, file, list) else cacheAdd(pos, file, list)
        }
        return list
    }

    /** Original: c.N(pos, fileName) — remove a entrada LRU correspondente. */
    private fun removeLru(pos: Int, fileName: String): Boolean {
        val key = epgCacheMap.entries.firstOrNull { it.value.first == pos && it.value.second == fileName }?.key ?: return false
        epgCacheMap.remove(key)
        return true
    }

    /** Original: c.o(pos, file, list) ("addEPGCache") — LRU de 30 entradas. */
    private fun cacheAdd(pos: Int, file: File, list: List<EPGProgramme>) {
        if (epgCacheMap.size > 30) {
            try {
                val removed = epgCacheMap.remove(epgCacheMap.firstKey())
                if (removed != null) cacheItemMap[removed.first]?.remove(removed.second)
            } catch (t: Throwable) {
                logger.warn("remove epg cache failure", t)
            }
        }
        val path = file.absolutePath
        cacheItemMap.getOrPut(pos) { ConcurrentHashMap() }[path] = list
        epgCacheMap[ServerTime.elapsedNow()] = Pair(pos, path)
    }

    /** Original: c.Q(pos, file, list) ("updateEPGCache") — só substitui se já havia entrada. */
    private fun cacheReplace(pos: Int, file: File, list: List<EPGProgramme>) {
        val path = file.absolutePath
        val old = cacheItemMap[pos]?.get(path)
        if (old != null) {
            cacheItemMap[pos]?.put(path, list)
            removeLru(pos, path)
            epgCacheMap[ServerTime.elapsedNow()] = Pair(pos, path)
        }
    }

    /** Original: c.v(pos, file) ("getEPGCache") — acesso renova a posição LRU. */
    private fun cacheGet(pos: Int, file: File): List<EPGProgramme>? {
        val path = file.absolutePath
        val list = cacheItemMap[pos]?.get(path)
        if (list != null) {
            removeLru(pos, path)
            epgCacheMap[ServerTime.elapsedNow()] = Pair(pos, path)
        }
        return list
    }

    /** Original: c.x(channelId, yyyyMMdd) ("getEPGProgramme") — lista do dia; `null` se a data não está em [posMap]; vazia se sem arquivo. */
    private suspend fun loadEpg(channelId: String, date: String): List<EPGProgramme>? {
        try {
            val pos = posMap[date] ?: return null
            val file = File(AppPaths.epgCachePath(), fileName(pos, channelId))
            if (!file.exists()) return ArrayList()
            return loadProgrammes(channelId, pos, file, false)
        } catch (t: Throwable) {
            logger.error("epg: loadEpg failure", t)
            return null
        }
    }

    /**
     * Original: c.A(list, time, returnNextIfNotFound) — índice do item com `start <= time < stop`; se
     * [returnNextIfNotFound] e `start > time` devolve o primeiro item futuro.
     */
    fun indexAt(list: List<EPGProgramme>?, time: Long, returnNextIfNotFound: Boolean): Int? {
        if (list == null) return null
        for ((i, p) in list.withIndex()) {
            val hit = if (p.start <= time) time < p.end else returnNextIfNotFound
            if (hit) return i
        }
        return null
    }

    /**
     * Original: c.B(channelId, time, returnNext) ("getEpgItemByTime") — procura no arquivo do dia de `time`; se
     * não achar, tenta o dia vizinho: com a hora local H do instante, `H > 12` ⇒ instante + (25-H) h (dia seguinte);
     * senão instante − (H+1) h (dia anterior).
     */
    suspend fun getProgrammeAt(channelId: String, time: Long, returnNext: Boolean = false): EPGProgramme? {
        try {
            val first = loadEpg(channelId, formatDate(2, time))
            indexAt(first, time, returnNext)?.let { return first!![it] }
            val hour = formatDate(7, time).toInt()
            val other = formatDate(2, if (hour > 12) (25 - hour) * 3_600_000L + time else time - (hour + 1) * 3_600_000L)
            val list = loadEpg(channelId, other)
            val idx = indexAt(list, time, returnNext)
            return if (idx != null && list != null) list[idx] else null
        } catch (_: Throwable) {
            return null
        }
    }

    /** Original: c.D(channelId, time) ("getTowEpgItemsByTime") — (atual, seguinte: busca em `stop + 1` com returnNext=true). */
    suspend fun getTwoProgrammesAt(channelId: String, time: Long): Pair<EPGProgramme?, EPGProgramme?> {
        val current = getProgrammeAt(channelId, time, false)
        val nextTime = if (current != null) current.end + 1 else time
        return Pair(current, getProgrammeAt(channelId, nextTime, true))
    }

    /**
     * Original: c.w(channelId) ("getEPGDateList") — datas (chaves de [posMap]) para as quais existe arquivo local do
     * canal; sem canal ⇒ todas as datas, ordenadas.
     */
    suspend fun getDateList(channelId: String?): List<String> {
        if (channelId.isNullOrEmpty()) return posMap.keys.toMutableList().sorted()
        val list = ArrayList<String>()
        withContext(Dispatchers.IO) {
            val dir = AppPaths.epgCachePath()
            for ((date, pos) in posMap) if (File(dir, fileName(pos, channelId)).exists()) list.add(date)
        }
        return list
    }

    /** Original: c.y(epgId, yyyyMMdd) ("getEPGProgrammeFlow$1" — corpo NÃO decompilado). */
    fun programmesFlow(epgId: String, yyyyMMdd: String): Flow<List<EPGProgramme>> = flow {
        TODO("nativo/não decompilado: x1.f1.lb.media.c\$g.invokeSuspend — provavelmente emite loadEpg(epgId, yyyyMMdd) em 2 passos (cache e arquivo)")
    }

    /** Original: c.z(epgId) ("getEPGProgrammes$1" — corpo NÃO decompilado): programação do canal (todos os dias). */
    fun programmesFlow(epgId: String): Flow<List<EPGProgramme>> = flow {
        TODO("nativo/não decompilado: x1.f1.lb.media.c\$h.invokeSuspend")
    }

    /**
     * Original: c.L(timestampStr) — converte "yyyyMMddHHmmss [+zzzz]" em ms: soma de duas partes convertidas por
     * `dc.a.c` (parser de data/offset de outro módulo).
     */
    fun parseTimestamp(timestampStr: String): Long =
        TODO("depende de dc.a.c(String) (parser de timestamp XMLTV) — outro módulo")

    private fun formatDate(type: Int, millis: Long): String = when (type) {
        2 -> SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Date(millis))
        7 -> SimpleDateFormat("HH", Locale.getDefault()).format(Date(millis))
        else -> throw IllegalArgumentException("tipo não usado: $type")
    } // Original: x1.f1.lb.util.n.h(type, millis)
}
