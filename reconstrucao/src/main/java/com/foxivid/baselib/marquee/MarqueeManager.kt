package com.foxivid.baselib.marquee

import com.foxivid.baselib.config.BaseLibConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import z1.b1.lb.m.extra.marquee.MarqueeInfo
import java.util.Collections
import java.util.TreeMap
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger

/**
 * Gerenciador do letreiro global (marquee) — avisos/mensagens que rolam na tela.
 *
 * Original: x1/f1/lb/marquee/a.java (nome Kotlin original `MarqueeManager`, arquivo
 * `MarqueeManager.kt`).
 *
 * Fonte das mensagens: NÃO há chamada de rede aqui. A "consulta" ([queryMarqueeInfo]) apenas
 * emite a lista local [list], que é preenchida por [setContents] a partir da propriedade de
 * heartbeat `marquee_display_contents` (textos separados por `$$`). Outras propriedades de
 * heartbeat configuram o comportamento (ver `AppPropertyHandlers`, original x1/f1/lb/heartbeat/f):
 *  - `marquee_display_interval` → [displayInterval] (aceito se > 1000 ms);
 *  - `marquee_display_times` → [displayTimes] (aceito se > 0);
 *  - `marquee_update_interval_minutes` → [setUpdateInterval] (minutos, 0 < v < 14400);
 *  - `marquee_alternately_display` → [setAlternatelyDisplay].
 *
 * O ciclo é dirigido pelo heartbeat (`HeartbeatManager.s0()` chama [checkAndUpdate] com o
 * horário do servidor a cada batida). As views (ex.: `GlobalMarqueeTextView`) se registram como
 * [MarqueeListener].
 *
 * Log: o original usa `q6` (fachada de log mínima estilo SLF4J embutida no app: `{}` como
 * placeholder, níveis debug=0, info=1, warn=2, error=3); aqui representada pela API SLF4J.
 */
object MarqueeManager {

    private val logger: Logger = LoggerFactory.getLogger(MarqueeManager::class.java)

    /** Último instante (ms, relógio do servidor) em que a lista foi "consultada" com sucesso. */
    private var updateTime: Long = 0

    /** Intervalo entre consultas: 12 h por padrão (43200000 ms). */
    private var updateInterval: Long = 43_200_000L

    /**
     * Exibição alternada: quando `true`, prioriza as mensagens exibidas menos vezes
     * (agrupando por contagem de exibição e depois por `seq`); quando `false`, só por `seq`.
     */
    private var isAlternatelyDisplay: Boolean = true

    /** Instante da última tentativa de consulta. */
    private var requestTime: Long = 0

    /** Intervalo mínimo entre tentativas de consulta: 30000 ms (jadx mostrou `Priority.WARN_INT`). */
    private var retryInterval: Int = 30_000

    /** Mensagens a exibir: id → (info, quantas vezes já foi exibida). */
    private var toDisplayMarqueeMap: MutableMap<Long, Pair<MarqueeInfo, AtomicInteger>> = HashMap()

    /** id → (instante da última exibição, hashCodes dos listeners que a exibiram). */
    private val marqueeLastDisplayTime: MutableMap<Long, Pair<Long, Set<Int>>> = HashMap()

    private val marqueeListeners: MutableList<MarqueeListener> =
        Collections.synchronizedList(ArrayList())

    /** Evita execuções concorrentes de [checkAndUpdate]. */
    private val isInDoing = AtomicBoolean(false)

    /** Lista "remota" (na prática, local) de mensagens, montada por [setContents]. */
    private var list: List<MarqueeInfo> = emptyList()

    /** Campo existente no original (getter/setter), sem uso observado nesta classe. */
    var content: String = ""

    /** Intervalo entre repetições da mesma mensagem (ms). Padrão 6000. Original: `u(int)`. */
    var displayInterval: Int = 6000

    /** Quantas vezes cada mensagem deve ser exibida. Padrão 3. Original: `v(int)`. */
    var displayTimes: Int = 3

    /**
     * Contrato das views que exibem o letreiro.
     *
     * Original: x1/f1/lb/marquee/a$a (InterfaceC0417a).
     */
    interface MarqueeListener {
        /** Começa a exibir [content]; retorna `true` se aceitou. Original: `a(String)`. */
        fun start(content: String): Boolean

        /** Se a view ainda está rolando um texto. */
        fun isRunning(): Boolean

        /** Para a exibição; retorna `true` se havia algo a parar. */
        fun stop(): Boolean
    }

    /**
     * Executado a cada heartbeat: tenta exibir a próxima mensagem e, se o intervalo de
     * atualização venceu (e o de retry também), "consulta" a lista e funde com o mapa de
     * exibição.
     *
     * Na fusão: ids novos entram com contador 0; ids que sumiram da lista são removidos
     * somente se já atingiram `displayTimes`.
     *
     * Original: `a.o(long)` (corrotina `MarqueeManager$checkAndUpdate$1`).
     */
    fun checkAndUpdate(now: Long) {
        if (!isInDoing.compareAndSet(false, true)) return
        CoroutineScope(Dispatchers.IO).launch {
            var shown: Boolean? = null
            try {
                if (marqueeListeners.isNotEmpty()) {
                    shown = tryDisplay(now)
                }
                if (updateTime + updateInterval < now) {
                    if (requestTime + retryInterval > now) {
                        return@launch
                    }
                    requestTime = now
                    queryMarqueeInfo()
                        .catch { e ->
                            logger.info(
                                "global_marquee, query marquee info failure, will retry after $retryInterval ms",
                                e,
                            )
                        }
                        .collect { infos ->
                            updateTime = now
                            val stillPresent = HashSet<Long>()
                            var added = 0
                            for (info in infos) {
                                if (toDisplayMarqueeMap.containsKey(info.id)) {
                                    stillPresent.add(info.id)
                                } else {
                                    toDisplayMarqueeMap[info.id] = Pair(info, AtomicInteger(0))
                                    added++
                                }
                            }
                            var deleted = 0
                            val it = toDisplayMarqueeMap.keys.iterator()
                            while (it.hasNext()) {
                                val id = it.next()
                                if (stillPresent.contains(id)) continue
                                val info = toDisplayMarqueeMap[id]?.first ?: continue
                                val count = toDisplayMarqueeMap[id]?.second?.get() ?: 0
                                if (count >= info.displayTimes) {
                                    // Fiel ao original: remove do mapa durante a iteração das chaves.
                                    toDisplayMarqueeMap.remove(info.id)
                                    deleted++
                                }
                            }
                            if (BaseLibConfig.isDebug) {
                                logger.debug("global_marquee query complete, got $added, del $deleted")
                            }
                            if (added > 0 || deleted > 0) {
                                shown = null
                            }
                        }
                }
            } finally {
                // O original avalia `shown == true` aqui e descarta o resultado (resquício de
                // código otimizado pelo R8); só o flag de execução é efetivamente liberado.
                isInDoing.compareAndSet(true, false)
            }
        }
    }

    /**
     * Escolhe e dispara a próxima mensagem nos listeners registrados.
     *
     * Regras:
     *  1. Mensagens que já atingiram `displayTimes` são contadas como encerradas.
     *  2. Se uma mensagem foi exibida há menos de `displayInterval` ms:
     *     - se algum listener que a exibiu ainda está rolando, nada é feito (retorna `true`);
     *     - senão, é reexibida ("restart") sem incrementar o contador.
     *  3. Caso contrário, entra na fila de candidatas: com exibição alternada, agrupada por
     *     contagem de exibição (menor primeiro) e depois por `seq`; sem alternância, só por `seq`.
     *  4. Se todas estão encerradas, chama `stop()` em todos os listeners e retorna `false`.
     *  5. Exibe a primeira candidata e incrementa seu contador ("start").
     *
     * Original: `a.q(long)` (synchronized).
     */
    @Synchronized
    private fun tryDisplay(now: Long): Boolean {
        var finishedCount = 0
        var bySeq: TreeMap<Int, MutableList<MarqueeInfo>>? = null
        var byCountThenSeq: TreeMap<Int, TreeMap<Int, MutableList<MarqueeInfo>>>? = null

        for ((id, pair) in toDisplayMarqueeMap) {
            val info = pair.first
            val count = pair.second.get()
            if (count >= info.displayTimes) {
                finishedCount++
                continue
            }
            val last = marqueeLastDisplayTime[id]
            if ((last?.first ?: 0L) + info.displayInterval > now) {
                val displayedBy = last?.second
                val current = ArrayList<Int>()
                if (displayedBy != null) {
                    for (listener in marqueeListeners) {
                        val hash = listener.hashCode()
                        current.add(hash)
                        if (displayedBy.contains(hash) && listener.isRunning()) {
                            if (BaseLibConfig.isDebug) {
                                logger.debug(
                                    "global_marquee in running$displayedBy current$current \"${info.content}\" $count/${info.displayTimes}",
                                )
                            }
                            // TODO("não decompilado com clareza: o jadx gerou um `while(true)` sem
                            //  saída após este log; o retorno abaixo é a leitura mais provável.")
                            return true
                        }
                    }
                }
                val restartedBy = HashSet<Int>()
                for (listener in marqueeListeners) {
                    if (listener.start(info.content)) restartedBy.add(listener.hashCode())
                }
                if (restartedBy.isNotEmpty()) {
                    marqueeLastDisplayTime[info.id] = Pair(now, restartedBy)
                    if (BaseLibConfig.isDebug) {
                        logger.debug("global_marquee restart $restartedBy \"${info.content}\" $count/${info.displayTimes}")
                    }
                    return true
                }
            }
            val target: TreeMap<Int, MutableList<MarqueeInfo>> = if (isAlternatelyDisplay) {
                val outer = byCountThenSeq ?: TreeMap<Int, TreeMap<Int, MutableList<MarqueeInfo>>>()
                    .also { byCountThenSeq = it }
                outer.getOrPut(count) { TreeMap() }
            } else {
                bySeq ?: TreeMap<Int, MutableList<MarqueeInfo>>().also { bySeq = it }
            }
            target.getOrPut(info.seq) { ArrayList() }.add(info)
        }

        if (finishedCount >= toDisplayMarqueeMap.size) {
            for (listener in marqueeListeners) {
                if (listener.stop() && BaseLibConfig.isDebug) {
                    logger.debug("global_marquee stop[${listener.javaClass.simpleName}]")
                }
            }
            return false
        }

        val candidates: List<MarqueeInfo> = (
            if (isAlternatelyDisplay) byCountThenSeq?.firstEntry()?.value?.firstEntry()?.value
            else bySeq?.firstEntry()?.value
            ) ?: return false

        val info = candidates[0]
        val startedBy = HashSet<Int>()
        for (listener in marqueeListeners) {
            if (listener.start(info.content)) startedBy.add(listener.hashCode())
        }
        if (startedBy.isEmpty()) return false
        marqueeLastDisplayTime[info.id] = Pair(now, startedBy)
        val newCount = toDisplayMarqueeMap[info.id]?.second?.incrementAndGet() ?: 0
        if (BaseLibConfig.isDebug) {
            logger.debug("global_marquee start $startedBy \"${info.content}\" $newCount/${info.displayTimes}")
        }
        return true
    }

    /** Registra uma view de letreiro (ignora null/duplicado). Original: `a.n(a$a)`. */
    fun addListener(listener: MarqueeListener?): Boolean {
        if (listener == null) return false
        if (marqueeListeners.contains(listener)) return false
        synchronized(this) { return marqueeListeners.add(listener) }
    }

    /** Remove uma view de letreiro. Original: `a.s(a$a)`. */
    fun removeListener(listener: MarqueeListener?): Boolean {
        synchronized(this) { return marqueeListeners.remove(listener) }
    }

    /** Cria um [MarqueeInfo] local com os padrões atuais e idioma fixo `"pt"`. Original: `a.p(long,int,String)`. */
    private fun createMarqueeInfo(id: Long, seq: Int, content: String): MarqueeInfo =
        MarqueeInfo().apply {
            displayTimes = this@MarqueeManager.displayTimes
            this.seq = seq
            this.id = id
            displayInterval = this@MarqueeManager.displayInterval
            lang = "pt"
            this.content = content
        }

    /** "Consulta" das mensagens: apenas emite [list]. Original: `a.r()` (`MarqueeManager$queryMarqueeInfo$1`). */
    fun queryMarqueeInfo(): Flow<List<MarqueeInfo>> = flow { emit(list) }

    /** Original: `a.t(boolean)`. */
    fun setAlternatelyDisplay(b: Boolean) {
        isAlternatelyDisplay = b
    }

    /**
     * Define as mensagens (ids e seq sequenciais a partir de 0).
     * Original: `a.w(List<String>)`.
     */
    fun setContents(contents: List<String>) {
        val result = ArrayList<MarqueeInfo>()
        var id = 0L
        var seq = 0
        for (c in contents) {
            result.add(createMarqueeInfo(id, seq, c))
            seq++
            id++
        }
        list = result
    }

    /** Altera o intervalo de atualização; só aceita valores > 60000 ms. Original: `a.x(long)`. */
    fun setUpdateInterval(intervalMS: Long) {
        if (intervalMS > 60_000L) updateInterval = intervalMS
    }
}
