package com.live.evo.fragment.subject

import android.text.TextUtils
import com.live.evo.util.DateUtils
import com.live.evo.model.SubjectClassification
import com.live.evo.model.SubjectMatch
import com.live.evo.model.SubjectMatchResponse
import com.live.evo.model.SubjectType
import com.live.evo.model.SubjectTypeResponse
import com.live.evo.util.CommonUtils
import com.live.evo.util.ModelHelper
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Cache dos dados de "Subject" (esportes/futebol: partidas por liga e por dia).
 * - [refresh] (original `e()`): se o recurso está habilitado (`ModelHelper.N()`), pede ao SDK a lista de subjects
 *   (`ModelHelper.I`) uma vez por vez (AtomicBoolean) e guarda em [subjects] (`List<j5.g>`).
 * - [groupMatches] (original `h(List<j5.b>)`): agrupa partidas (`j5.c`) por tipo, ordena por data/hora, e por dia
 *   (`yyyyMMdd`) preservando ordem de inserção; categoria "-1" ("all", [ALL]) agrega todas. Usa catch-up check
 *   [ModelHelper.isCatchUpAvailable] para partidas passadas.
 * - Constantes de status: "0", "1", "2", "-1".
 *
 * Original: com/live/evo/fragment/subjuect/b.java (nome real SubjectDataHelper — usado em LiveLoadActivity/LiveNewActivity)
 */
class SubjectDataHelper private constructor() {
    private val startTimes = HashMap<String, Long>()    // f6642a (lido por [startTimeOf])
    private val loading = AtomicBoolean(false)
    var subjects: List<SubjectType> = ArrayList()       // f6644c
        private set
    private val subjectList = ArrayList<SubjectType>()

    /** Callback de [ModelHelper.loadSubjectTypes]: guarda os tipos e libera o "loading". Original: k(j5.h) */
    private fun onTypesLoaded(response: SubjectTypeResponse?) {
        if (response != null) storeTypes(response)
        loading.set(false)
    }

    /** Datas disponíveis (`yyyymmdd`) da resposta. Original: d(j5.a) */
    fun datesOf(response: SubjectMatchResponse): List<String> {
        val list = ArrayList<String>()
        response.dates?.let { if (it.isNotEmpty()) { list.clear(); list.addAll(it) } }
        return list
    }

    /** Original: e() */
    fun refresh() {
        if (ModelHelper.isConfigFlagN()) {
            com.foxivid.baselib.media.SportsManager.enable()      // x1/f1/lb/media/j.z(): enableSports = true
            if (loading.compareAndSet(false, true)) ModelHelper.loadSubjectTypes { onTypesLoaded(it) }
        }
    }

    /** Original: f() */ fun list() = subjects
    /** Original: j() */ fun hasData() = ModelHelper.isConfigFlagN()

    /**
     * Mapa {id do tipo -> [classificação "all" (id "-1"), classificações de cada dia]}. Original: g(j5.a, String)
     */
    fun classificationsByType(response: SubjectMatchResponse?, typeId: String): Map<String, List<SubjectClassification>>? {
        if (response == null) return null
        val map = HashMap<String, List<SubjectClassification>>()
        val all = SubjectClassification().also { it.id = ALL; it.name = CommonUtils.string(com.live.evo.R.string.all) }
        val list = ArrayList<SubjectClassification>()
        list.add(0, all)
        response.days?.forEach { day -> day?.classifications?.let { list.addAll(it) } }
        map[typeId] = list
        return map
    }

    /**
     * Agrupa partidas por classificação (mais uma entrada "-1" com todas, ordenada pelo início) e por dia (`yyyymmdd`),
     * preservando a ordem de inserção. Classificações sem partidas são removidas de [groups] e do resultado.
     * (O filtro por "modo numérico" `a5.b` usa um mapa que está sempre vazio neste build: com o modo ligado nenhuma partida entra.)
     * Original: h(List<j5.b>)
     */
    fun groupMatches(groups: MutableList<SubjectClassification>?): Map<String, Map<String, List<SubjectMatch>>>? {
        if (groups.isNullOrEmpty()) return null
        val result = HashMap<String, Map<String, List<SubjectMatch>>>()
        var byClass = HashMap<String, List<SubjectMatch>>()
        val all = ArrayList<SubjectMatch>()
        for (g in groups) {
            if (g != null && !g.id.isNullOrEmpty() && !g.matches.isNullOrEmpty() && g.id != ALL) {
                byClass[g.id!!] = g.matches!!
                all.addAll(g.matches!!)
            }
        }
        all.sortWith { a, b -> java.util.Date(a.startTime).compareTo(java.util.Date(b.startTime)) }
        byClass[ALL] = all
        val now = DateUtils.now()
        val numericMode = com.live.evo.config.ChannelNumberMode.get().isEnabled()    // a5.b.a().b()
        val allowedChannels = HashMap<String, Any>()                                  // map4: nunca preenchido no original
        for (key in byClass.keys.toList()) {
            val byDay = LinkedHashMap<String, List<SubjectMatch>>()
            for (m in byClass[key]!!) {
                val day = DateUtils.format(m.startTime, CommonUtils.string(com.live.evo.R.string.yyyymmdd))
                if (TextUtils.isEmpty(day)) continue
                if (m.endTime < now) ModelHelper.isCatchUpAvailable(m.epgId, m.channelId, m.startTime)   // resultado não usado
                val dayList = ArrayList<SubjectMatch>()
                byDay[day]?.let { dayList.addAll(it) }
                if ((numericMode && allowedChannels.containsKey(m.channelId)) || !numericMode) dayList.add(m)
                byDay[day] = dayList
            }
            val flat = ArrayList<SubjectMatch>()
            for (day in byDay.keys) { if (!TextUtils.isEmpty(day) && byDay[day] != null) flat.addAll(byDay[day]!!) }
            if (key != ALL && flat.isEmpty()) {
                result.remove(key)
                val it = groups.iterator()
                while (it.hasNext()) { val g = it.next(); if (g != null && g.id == key) { it.remove(); break } }
            } else result[key] = byDay
        }
        return result
    }

    /** Guarda a lista de tipos recebida. Original: i(j5.h) */
    fun storeTypes(response: SubjectTypeResponse?): List<SubjectType>? {
        if (response == null || response.types.isNullOrEmpty()) return null
        subjectList.clear(); subjectList.addAll(response.types!!)
        subjects = subjectList
        return subjects
    }

    /** Início (ms) registrado para o tipo [typeId]; 0 se desconhecido. Original: b(String) */
    fun startTimeOf(typeId: String?): Long {
        if (typeId.isNullOrEmpty()) return 0L
        return startTimes[typeId] ?: 0L
    }

    companion object {
        const val STATUS_0 = "0"; const val STATUS_1 = "1"; const val STATUS_2 = "2"; const val ALL = "-1"
        /** Original: f6641l — "voltar para Subject" após assistir (LiveNewActivity.returnToSubject). */
        @JvmField var returnToSubject = false
        private var instance: SubjectDataHelper? = null
        /** Original: c() */ @JvmStatic fun get(): SubjectDataHelper = instance ?: SubjectDataHelper().also { instance = it }
    }
}
