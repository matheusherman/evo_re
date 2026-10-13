package com.live.evo.fragment.epg

import android.content.Context
import android.util.AttributeSet
import android.util.SparseArray
import android.view.KeyEvent
import android.view.View
import com.live.evo.R
import com.live.evo.catchup.EpgDataStore
import com.live.evo.fragment.channel.ChannelSdkBridge
import com.live.evo.fragment.channel.EpgDateShims
import com.live.evo.model.CategoryBean
import com.live.evo.model.ChannelData
import com.live.evo.model.ProgramBean
import com.live.evo.util.CommonUtils
import com.live.evo.util.DateUtils
import com.live.evo.util.ToastUtils
import java.util.TimerTask
import java.util.concurrent.TimeUnit

/**
 * Variante "D-style" da grade de EPG: igual à [EPG] (mesma escala de tempo, mesmo desenho de programas, datas e
 * barra de horas) **mais uma coluna de categorias** à esquerda. O foco tem três "zonas":
 *
 * - grade de programas (padrão);
 * - **coluna de categorias** (`categoryFocused`, entra com ESQUERDA mantida; CIMA/BAIXO trocam de categoria e
 *   recarregam os canais via [switchCategory]);
 * - **barra de datas** (`dateBarFocused`, entra com CIMA mantida; ESQ/DIR andam um dia por vez; BAIXO volta à grade).
 *
 * Os dados são um [EpgDataStore] por categoria (`stores`), criados fora da classe; [loadedFlags] diz se a EPG da
 * categoria já foi carregada (a tarefa de 500 ms ao soltar CIMA/BAIXO descarta/pede EPG enquanto não carregou).
 * As categorias são as colunas do SDK, sem "favorite", vazias ou adultas ([initCategories]).
 *
 * O desenho específico (coluna de categorias, ícones de canal via `ModelHelper.y`) não foi reconstruído
 * linha a linha: reaproveita o `onDraw` da [EPG]. Pontos não reconstruídos estão marcados com TODO.
 *
 * Original: com/live/evo/catchup/EPG_Dstyle.java (2223 linhas; classes internas `a`/`b` = TimerTask de carga,
 * `c` = gestos; stub anterior em catchup/EpgViews.kt)
 */
class EPG_Dstyle @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : EPG(context, attrs, defStyleAttr) {

    /** Ids das categorias exibidas na coluna (`O1`) e seus metadados (`P1`). */
    private var categoryIds: MutableList<String> = ArrayList()
    private var categoryInfo: MutableMap<String, CategoryBean?> = HashMap()

    /** Dados por categoria (`T1`) e "EPG já carregada?" por categoria (`U1`). */
    @Volatile private var stores: MutableMap<String, EpgDataStore> = HashMap()
    private var loadedFlags: MutableMap<String, Boolean> = HashMap()

    /** Categoria atual (`S1` = id) e índice focado na coluna (`R`). */
    private var currentCategory: String? = null
    private var focusedCategory = 0

    private var categoryFocused = false   // Q1
    private var dateBarFocused = false    // R1
    private var longPress = false         // X1 (repeatCount >= 1)
    private var rightKeyDown = false      // Z1
    private var datePointer = 0L          // F1 (instante destacado na barra de datas)
    private var loadTask2: TimerTask? = null   // D1

    init { initCategories() }

    /**
     * Monta a lista de categorias: colunas do SDK (`u(true)`) exceto "favorite", sem canais ou adultas.
     * Original: `Y()`
     */
    private fun initCategories() {
        categoryIds = ArrayList()
        categoryInfo = HashMap()
        stores = HashMap()
        loadedFlags = HashMap()
        val info = ChannelSdkBridge.categoryInfo()
        val channels = ChannelSdkBridge.channelsByCategory()
        for (id in ChannelSdkBridge.columns(true)) {
            if (id != "favorite" && channels[id] != null && channels[id]!!.isNotEmpty() && !isAdultCategory(id)) {
                categoryIds.add(id)
                categoryInfo[id] = info[id]
            }
        }
    }

    /** Categoria adulta (`CategoryBean.g() == 1`). Original: `s(String)` */
    private fun isAdultCategory(id: String): Boolean = ChannelSdkBridge.categoryInfo()[id]?.isAdultColumn == 1

    /** Id da categoria focada na coluna (ou null). Original: `getCurFocusCategoryId()` */
    fun getCurFocusCategoryId(): String? = categoryIds.getOrNull(focusedCategory)

    /** Original: `getCatchUpdata()` */
    fun getCatchUpData(): EpgDataStore? = dataStore

    /** Original: `getChannels()` */
    fun getChannels(): List<ChannelData>? = dataStore?.channels

    /** Registra os dados (e se já foram carregados) de uma categoria (inferido: o APK não tem setter). */
    fun putCategoryData(id: String, store: EpgDataStore, loaded: Boolean) {
        stores[id] = store
        loadedFlags[id] = loaded
    }

    /** Original: `p0(List<Integer>)` — canais com EPG carregada (fila de cache). */
    fun addLoadedChannels(list: List<Int>?) { if (list != null) loadedChannels.addAll(list) }

    /**
     * Troca a categoria: usa o `EpgDataStore` dela, zera seleção/fila de cache, marca como carregados os canais de
     * `-4..+8` ao redor do canal 0 e rola para "agora". Original: `o0()` (synchronized)
     */
    @Synchronized
    private fun switchCategory() {
        try {
            dataStore = stores[currentCategory]
            loadedChannels.clear()
            selectedProgram = 0
            selectedChannel = 0
            playingChannel = 0
            val store = dataStore
            if (store != null) {
                loadChannelIcons()
                var from = selectedChannel - 4
                var to = selectedChannel + 8
                if (from < 0) from = 0
                val channels = store.channels
                val flags = store.programs
                val queue = ArrayList<Int>()
                var last = channels.size - 1
                if (to >= last) to = last
                while (from <= to) {
                    if (flags.size > from) flags[from] = Pair(flags[from].first, true)
                    queue.add(from)
                    from++
                }
                addLoadedChannels(queue)
            }
            scrollToNow(false)
        } catch (t: Throwable) {
            throw t
        }
    }

    /**
     * Pré-carrega os ícones dos canais visíveis (`ModelHelper.y(...)` em IO). Original: `getChannelIconBitmap()` / `S(List)`
     */
    fun loadChannelIcons() {
        TODO("s0.y(canais, imageCache, resources, callback): carrega bitmaps dos ícones dos canais visíveis (ModelHelper.prefetch)")
    }

    // ------------------------------------------------------------------ teclas

    /**
     * Teclas. ACTION_DOWN: `startTracking`; CIMA/ESQ mantidos (repeatCount >= 1) mudam a zona de foco; ENTER (66) /
     * OK (23) clicam (listener removido → `throw null`, ver [EPG]); DEL (67) volta ao canal tocando; MENU (82) ignorado.
     * ACTION_UP: executa o movimento (CIMA/BAIXO/ESQ/DIR) conforme a zona; ao soltar CIMA/BAIXO agenda a tarefa de carga.
     * Original: `onKey(View, int, KeyEvent)`
     */
    override fun onKey(view: View?, i10: Int, event: KeyEvent): Boolean {
        val store = dataStore
        if (store == null || store.channelCount() < selectedChannel) return false
        val keyCode = event.keyCode
        val oldChannel = selectedChannel
        val oldProgram = selectedProgram
        val channelCount = store.channelCount()
        val categoryCount = categoryIds.size
        val (list, loaded) = store.programsOf(selectedChannel)!!
        visibleStart = xToTime(scrollX)
        visibleEnd = xToTime(scrollX + width)
        if (keyCode != 23 && keyCode != 66 && keyCode != 4 && (keyCode != 22 || event.action != 1)) dateFollowsSelection = false

        if (event.action == KeyEvent.ACTION_DOWN) {
            event.startTracking()
            if (keyCode != 19) {
                if (keyCode != 82) {
                    if (keyCode == 66) {
                        if (!categoryFocused && !dateBarFocused && !CommonUtils.isFastClick(1000L)) {
                            clickProgram(if (loaded && list.isEmpty()) null else store.program(selectedChannel, selectedProgram), store)
                        }
                    } else if (keyCode != 67) {
                        when (keyCode) {
                            21 -> if (event.repeatCount < 1) {
                                longPress = false
                            } else {
                                longPress = true
                                if (!categoryFocused && !dateBarFocused) { categoryFocused = true; invalidate() }
                            }
                            22 -> rightKeyDown = true
                            23 -> if (!categoryFocused && loaded) clickProgram(store.program(selectedChannel, selectedProgram), store)
                        }
                    } else {
                        selectedChannel = playingChannel
                        relocatePending = true
                        scrollToNow(false)
                    }
                }
            } else if (event.repeatCount < 1) {
                longPress = false
            } else {
                longPress = true
                if (!dateBarFocused && !categoryFocused) { dateBarFocused = true; invalidate() }
            }
        }

        if (event.action == KeyEvent.ACTION_UP) {
            when (keyCode) {
                19 -> {
                    if (!longPress && !dateBarFocused) {
                        if (categoryFocused) {
                            if (focusedCategory > 0) {
                                focusedCategory--
                                currentCategory = categoryInfo[categoryIds[focusedCategory]]?.id
                                switchCategory()
                            }
                        } else if (oldChannel > 0) {
                            selectedChannel--
                            moveVertical(0)
                        }
                    }
                    scheduleLoadIfNeeded(channelCount)
                    invalidate()
                }
                20 -> {
                    if (dateBarFocused) {
                        dateBarFocused = false
                        categoryFocused = false
                        val first = store.program(selectedChannel, 0)
                        if (first != null && first.f() > visibleEnd) {
                            selectedProgram = 0
                            scrollToProgram(store.programsOf(selectedChannel)!!.first, 0)
                            datePointer = first.f()
                            selectionVisible = true
                            invalidate()
                            return true
                        }
                        val last = store.program(selectedChannel, store.programCount(selectedChannel) - 1)
                        if (last != null && ((visibleStart + visibleEnd) - channelWidth.toLong() * msPerPixel) / 2 > last.f() && store.programsOf(selectedChannel) != null) {
                            selectedProgram = store.programCount(selectedChannel) - 1
                            scrollToProgram(store.programsOf(selectedChannel)!!.first, 0)
                            datePointer = last.f()
                            selectionVisible = true
                        }
                    } else if (categoryFocused) {
                        if (focusedCategory < categoryCount - 1) {
                            focusedCategory++
                            currentCategory = categoryInfo[categoryIds[focusedCategory]]?.id
                            switchCategory()
                        }
                    } else if (oldChannel < channelCount - 1) {
                        selectedChannel++
                        moveVertical(1)
                    }
                    scheduleLoadIfNeeded(channelCount)
                    invalidate()
                }
                21 -> {
                    if (dateBarFocused) {
                        // um dia para trás (limite: hoje - 7 dias)
                        val limit = EpgDateShims.startOfDay(com.live.evo.util.ServerClock.get().now()) - TimeUnit.DAYS.toMillis(7L)
                        var target = (((visibleStart + visibleEnd) - channelWidth.toLong() * msPerPixel) / 2) - TimeUnit.DAYS.toMillis(1L)
                        if (target >= limit) {
                            scrollWithinBounds(-((TimeUnit.DAYS.toMillis(1L) / msPerPixel).toInt()), 0)
                            val limit2 = target
                            target = limit2
                        } else {
                            scrollTo(timeToX(limit) - (margin + channelWidth), scrollY)
                            target = limit
                        }
                        datePointer = target
                        val current = store.program(selectedChannel, selectedProgram)
                        if (current != null && isProgramVisible(current.f(), current.g())) {
                            selectionVisible = true
                            invalidate()
                            return false
                        }
                        val found = pickProgramAtTime(list, target)
                        selectionVisible = found
                        if (found) { invalidate(); return false }
                    } else if (longPress || categoryFocused) {
                        if (longPress && !categoryFocused) categoryFocused = true
                    } else if (loaded) {
                        moveProgramLeft(list, oldProgram)
                    }
                    invalidate()
                }
                22 -> {
                    if (rightKeyDown) {
                        rightKeyDown = false
                        if (dateBarFocused) {
                            // um dia para frente (limite: hoje + 6 dias)
                            var limit = EpgDateShims.calendarInZone(DateUtils.today(), 6).timeInMillis
                            val next = ((visibleStart + visibleEnd) - channelWidth.toLong() * msPerPixel) / 2 + TimeUnit.DAYS.toMillis(1L)
                            if (next <= limit) {
                                scrollWithinBounds((TimeUnit.DAYS.toMillis(1L) / msPerPixel).toInt(), 0)
                                limit = next
                            } else {
                                scrollTo(timeToX(limit) - (margin + channelWidth), scrollY)
                            }
                            datePointer = limit
                            val current = store.program(selectedChannel, selectedProgram)
                            if (current != null && isProgramVisible(current.f(), current.g())) {
                                selectionVisible = true
                                invalidate()
                                return false
                            }
                            val found = pickProgramAtTime(list, limit)
                            selectionVisible = found
                            if (found) { invalidate(); return false }
                        } else if (categoryFocused) {
                            if (loadedFlags[currentCategory] == false) {
                                categoryFocused = false
                                invalidate()
                                return true
                            }
                        } else if (loaded) {
                            moveProgramRight(list)
                        }
                    }
                    invalidate()
                }
                else -> invalidate()
            }
        }
        if (keyCode != 4 && keyCode == 111) invalidate()
        return false
    }

    /** Agenda (500 ms) a tarefa de carga/limpeza se a EPG da categoria ainda não terminou de carregar. */
    private fun scheduleLoadIfNeeded(channelCount: Int) {
        val flags = loadedFlags
        if (flags[currentCategory] != null && flags[currentCategory] == false) {
            loadTask2?.cancel()
            val task = object : TimerTask() {
                override fun run() {
                    while (loadedChannels.size > cacheSize) {
                        val oldest = loadedChannels.removeAt(0)
                        if (oldest < dataStore!!.channelCount()) dataStore!!.clear(oldest)
                    }
                    val first = getFirstVisibleChannelPosition()
                    var last = getLastVisibleChannelPosition()
                    val candidate = last - 3
                    if (last <= channelCount - 3) last = candidate
                    requestVisibleEpgs(first, last)
                }
            }
            loadTask2 = task
            timer.schedule(task, 500L)
        }
    }

    /** Move a seleção para o canal novo (CIMA=0/BAIXO=1) e escolhe o programa. Original: `e0(int)` */
    private fun moveVertical(direction: Int) {
        val list = dataStore!!.programsOf(selectedChannel)!!.first
        ensureChannelVisible(direction)
        if (list.isEmpty()) return
        val previous = currentProgram
        val size = list.size
        val mid = ((visibleStart + visibleEnd) - channelWidth.toLong() * msPerPixel) / 2
        for (i in 0 until size) {
            val candidate = list[i]
            if (candidate.f() > mid) {
                selectedProgram = i
                scrollToProgram(list, 0)
                selectionVisible = true
                return
            }
            if (mid >= candidate.f() && mid < candidate.g() && isProgramVisible(candidate.f(), candidate.g())) {
                selectedProgram = i
                if (previous != null && i < size - 1 && previous.f() > candidate.f()) {
                    val next = list[i + 1]
                    if (next.f() >= previous.f() && next.g() <= previous.g() && isProgramVisible(next.f(), next.g())) selectedProgram = i + 1
                }
                selectionVisible = true
                return
            }
        }
        selectionVisible = pickProgramAtTime(list, mid)
    }

    /**
     * Rola horizontalmente para centralizar o programa selecionado (modo 0 = centraliza; 1 = só se estiver à direita;
     * 2 = só se estiver à esquerda e o 1º programa não está visível). Original: `O(List, int)` (e `P(List, int)`, que
     * usa `start` nos dois lados)
     */
    private fun scrollToProgram(list: List<ProgramBean>?, mode: Int) {
        if (list == null || selectedProgram < 0 || selectedProgram >= list.size) return
        val p = list[selectedProgram]
        val dx = ((timeToX(p.f()) + timeToX(p.g())) / 2) - timeToX(((visibleStart + visibleEnd) - channelWidth.toLong() * msPerPixel) / 2)
        if (mode == 0) { scrollWithinBounds(dx, 0); return }
        if (mode != 1) { if (mode != 2) return } else if (dx > 0) scrollWithinBounds(dx, 0)
        val first = list[0]
        if (dx >= 0 || (timeToX(first.f()) >= scrollX + channelWidth && first.f() <= visibleEnd)) return
        scrollWithinBounds(dx, 0)
    }

    /** ESQUERDA na grade: programa anterior (toast nos extremos). */
    private fun moveProgramLeft(list: List<ProgramBean>, oldProgram: Int) {
        if (list.isEmpty()) {
            ToastUtils.show(context, context.getString(R.string.current_channel_no_epg))
            return
        }
        if (selectedProgram == 0) ToastUtils.show(context, context.getString(R.string.no_more_epg))
        if (selectedProgram >= list.size || list[0].f() > visibleEnd || list[list.size - 1].g() < visibleStart) {
            val ref = ((visibleStart + visibleEnd) - msPerPixel * channelWidth.toLong()) / 2
            for (i in list.indices) {
                val p = list[i]
                if (isProgramVisible(p.f(), p.g()) && ref >= p.f() && ref <= p.g()) selectedProgram = i
                else if (isProgramVisible(p.f(), p.g()) && ref <= p.f()) selectedProgram = i
            }
        } else if (oldProgram > 0) {
            selectedProgram--
            scrollToProgram(list, 2)
        }
        if (selectedProgram >= list.size || list[0].f() > visibleEnd || list[list.size - 1].g() < visibleStart) {
            selectedProgram = if (list[0].f() > visibleEnd) 0 else list.size - 1
            scrollTo((timeToX(list[selectedProgram].f()) - margin) - channelWidth, scrollY)
        } else {
            val p = list[selectedProgram]
            val start = p.f()
            val end = p.g()
            val first = list[0]
            if (start >= visibleStart || !(timeToX(first.f()) >= scrollX + channelWidth && first.f() <= visibleEnd)) {
                if (end > ((scrollX + width - (margin * 2 + channelWidth)).toLong() * msPerPixel) + originTimeOf()) {
                    scrollWithinBounds(((end - visibleEnd) / msPerPixel).toInt() + margin * 2 + channelWidth, 0)
                }
            } else {
                scrollWithinBounds(((start - visibleStart) / msPerPixel).toInt() + margin, 0)
            }
        }
        selectionVisible = true
    }

    /** DIREITA na grade: próximo programa (até 7 dias à frente). */
    private fun moveProgramRight(list: List<ProgramBean>) {
        if (list.isEmpty()) {
            ToastUtils.show(context, context.getString(R.string.current_channel_no_epg))
            return
        }
        if (selectedProgram == list.size - 1) ToastUtils.show(context, context.getString(R.string.no_more_epg))
        if (selectedProgram >= list.size || list[0].f() > visibleEnd || list[list.size - 1].g() < visibleStart) {
            val ref = ((visibleStart + visibleEnd) - channelWidth.toLong() * msPerPixel) / 2
            for (i in list.indices) {
                val p = list[i]
                if (isProgramVisible(p.f(), p.g()) && ref >= p.f() && ref <= p.g()) { selectedProgram = i; selectionVisible = true }
                else if (isProgramVisible(p.f(), p.g()) && ref <= p.f()) { selectedProgram = i; selectionVisible = true }
            }
        } else if (selectedProgram < list.size && list[selectedProgram].g() < EpgDateShims.addDays(DateUtils.today(), 7) && selectedProgram < list.size - 1) {
            selectedProgram++
            scrollToProgram(list, 1)
        }
        if (selectedProgram >= list.size || list[0].f() > visibleEnd || list[list.size - 1].g() < visibleStart) {
            selectedProgram = if (list[0].f() > visibleEnd) 0 else list.size - 1
            scrollTo((timeToX(list[selectedProgram].f()) - margin) - channelWidth, scrollY)
        } else {
            val p = list[selectedProgram]
            val end = p.g()
            val start = p.f()
            if (end > ((scrollX + width - (margin * 2 + channelWidth)).toLong() * msPerPixel) + originTimeOf()) {
                scrollWithinBounds(((end - visibleEnd) / msPerPixel).toInt() + margin + channelWidth, 0)
            } else if (start < visibleStart) {
                scrollTo((timeToX(start) - channelWidth) + margin, scrollY)
            }
        }
        selectionVisible = true
    }

    /** `originTime` (hoje - 7 dias) — recalculado pois o campo da [EPG] é privado. Original: `q()` */
    private fun originTimeOf(): Long = EpgDateShims.addDays(DateUtils.today(), -7)

    /** ENTER/OK: o listener foi removido no APK → `throw null` (ver [EPG]). */
    private fun clickProgram(program: ProgramBean?, store: EpgDataStore) {
        val listener = clickListener ?: throw NullPointerException("EPG click listener removido pelo R8 (throw null no original)")
        val channel = store.channel(selectedChannel)
        if (program == null) listener.onEmptyChannelClick(channel) else listener.onProgramClick(program, channel)
    }
}
