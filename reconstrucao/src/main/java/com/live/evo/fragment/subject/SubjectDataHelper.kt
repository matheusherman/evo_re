package com.live.evo.fragment.subject

import android.text.TextUtils
import com.live.evo.util.DateUtils
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
    private val loading = AtomicBoolean(false)
    var subjects: List<Any> = emptyList()      // f6644c: List<j5.g>
        private set

    /** Original: e() */
    fun refresh() {
        if (ModelHelper.isConfigFlagN()) {
            if (loading.compareAndSet(false, true)) {
                ModelHelper.loadSubjectTypes { _ -> loading.set(false) } // TODO("callback preenche subjects (j5.h)")
            }
        }
    }

    /** Original: f() */ fun list() = subjects
    /** Original: j() */ fun hasData() = subjects.isNotEmpty()

    /** Agrupa partidas por tipo e dia. Original: h(List<j5.b>) — corpo longo resumido */
    fun groupMatches(groups: List<Any>?): Map<String, Map<String, List<Any>>> {
        TODO("ver subjuect/b.h: map3[tipo]=partidas; ordena (comparator a); formata dia com R.string.yyyymmdd; filtra por a5.b flag")
    }

    companion object {
        const val STATUS_0 = "0"; const val STATUS_1 = "1"; const val STATUS_2 = "2"; const val ALL = "-1"
        /** Original: f6641l — "voltar para Subject" após assistir (LiveNewActivity.returnToSubject). */
        @JvmField var returnToSubject = false
        private var instance: SubjectDataHelper? = null
        /** Original: c() */ @JvmStatic fun get(): SubjectDataHelper = instance ?: SubjectDataHelper().also { instance = it }
    }
}
