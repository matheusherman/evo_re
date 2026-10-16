package com.live.evo.fragment.epg

import android.content.Context
import android.graphics.BlurMaskFilter
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Rect
import android.graphics.Typeface
import android.text.TextPaint
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Scroller
import com.live.evo.AppUserManager
import com.live.evo.R
import com.live.evo.catchup.CatchUpPlayInfoFactory
import com.live.evo.catchup.EpgDataStore
import com.live.evo.fragment.channel.ChannelSdkBridge
import com.live.evo.fragment.channel.EpgDateShims
import com.live.evo.model.ProgramBean
import com.live.evo.util.CommonUtils
import com.live.evo.util.DateUtils
import com.live.evo.util.FontUtils
import com.live.evo.util.ServerClock
import com.live.evo.util.ToastUtils
import org.slf4j.LoggerFactory
import java.util.Calendar
import java.util.Date
import java.util.Timer
import java.util.TimerTask
import java.util.concurrent.TimeUnit

/**
 * Grade de EPG desenhada manualmente em Canvas, estilo "TV Guide" (tela de catch-up):
 *
 * ```
 *  +--------------+---------------------------------------------+
 *  | "Grupo(3/80)"|  barra de datas (7 dias, mês, setas) + dicas |  <- cabeçalho (date_layout_height)
 *  +--------------+---------------------------------------------+
 *  | 001 Canal 1  |  [programa][programa][ programa ][programa] |  <- uma linha por canal
 *  | 002 Canal 2  |  [   programa    ][programa][programa]      |
 *  |   ...        |  barra de horas / linha do "agora"          |
 *  +--------------+---------------------------------------------+
 * ```
 *
 * - **Escala de tempo**: [msPerPixel] = 5 h / (largura da tela − coluna de canais − margem); [originTime] = hoje − 7 dias;
 *   a grade cobre 13,8 dias (`1191600000 ms`, [computeMaxScrollX]). `xToTime`/`timeToX` convertem px ↔ ms.
 * - **Scroll**: [Scroller] (atrito 0,2) + [GestureDetector] (arrasto/fling); setas movem a seleção e rolam a grade
 *   ([ensureChannelVisible], [pickProgramAfterVerticalMove], [pickProgramAtTime]).
 * - **Teclas** ([onKey]): CIMA/BAIXO mudam de canal; ESQ/DIR de programa (avisam `no_more_epg` nos extremos);
 *   `4` / `6` (KEYCODE_4/6) voltam/avançam um dia; DEL (67) volta ao canal e horário de agora; OK/ENTER (66/23) chamam o
 *   [EpgClickListener] — no APK esse listener foi removido (campo nunca atribuído), por isso o código original termina
 *   em `throw null` (NullPointerException) nesses dois ramos; mantido em [fireClick].
 * - **Carga preguiçosa**: ao soltar CIMA/BAIXO agenda (500 ms) uma tarefa que descarta a EPG dos canais mais antigos
 *   quando passa de `epg_cache_size` (padrão 20) e pede a dos visíveis ([requestVisibleEpgs], que no original não faz nada
 *   de útil: só monta um `SparseArray` e descarta).
 *
 * No original a classe nunca recebe o [EpgDataStore] (não há setter no APK); [setData] é inferido.
 *
 * Original: com/live/evo/catchup/EPG.java (1667 linhas; stub anterior em catchup/EpgViews.kt) + `EPG$a` (TimerTask) + `EPG$b` (gestos)
 */
open class EPG @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ViewGroup(context, attrs, defStyleAttr), View.OnKeyListener {

    private val logger = LoggerFactory.getLogger(EPG::class.java)

    /** Nome simples da classe (log). Original: `f5546b`. */
    val tag: String = javaClass.simpleName
    val weekMs = 604800000           // f5548c
    val weekMs2 = 604800000          // f5549d
    val visibleSpanMs = 18000000     // f5550e (5 h visíveis na largura)
    val halfHourMs = 1800000         // f5551f

    // --- retângulos/pintura reutilizados ---
    private val clipRect = Rect()    // f5552g
    private val bgRect = Rect()      // f5553h
    private val textBounds = Rect()  // f5554i
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)   // f5555j
    private val scroller = Scroller(context).also { it.setFriction(0.2f) }   // f5556k
    private val gestureDetector = GestureDetector(context, GridGestureListener())   // f5557l
    private val bitmaps = EpgBitmapCache()   // A

    // --- dimensões (R.dimen.epg_*) e cores ---
    protected val margin = resources.getDimensionPixelSize(R.dimen.epg_channel_layout_margin)          // f5558m
    private val padding = resources.getDimensionPixelSize(R.dimen.epg_channel_layout_padding)        // f5559n
    protected val rowHeight = resources.getDimensionPixelSize(R.dimen.epg_channel_layout_height)       // f5560o
    protected val channelWidth = resources.getDimensionPixelSize(R.dimen.epg_channel_layout_width)     // f5561p
    private val channelBg = resources.getColor(R.color.epg_channel_layout_background)               // f5562q
    private val eventBg = resources.getColor(R.color.epg_event_layout_background)                   // f5563r
    private val eventBgCurrent = resources.getColor(R.color.epg_event_layout_background_current)    // f5564s
    private val eventSelectedText = resources.getColor(R.color.epg_event_select_text)               // f5565t
    private val eventTextSize = resources.getDimensionPixelSize(R.dimen.epg_event_layout_text)      // f5566u
    private val timeLineWidth = resources.getDimensionPixelSize(R.dimen.epg_time_bar_line_width)    // f5567v
    private val timeLineColor = resources.getColor(R.color.epg_time_line)                           // f5568w
    private val timeBarHeight = resources.getDimensionPixelSize(R.dimen.epg_time_bar_height)        // f5569x
    private val timeBarTextSize = resources.getDimensionPixelSize(R.dimen.epg_time_bar_text)        // f5570y
    private val epgBackground = resources.getColor(R.color.epg_background)                          // f5571z
    private val dateHeaderHeight = resources.getDimensionPixelSize(R.dimen.date_layout_height)      // B
    private val dateTextSize = resources.getDimensionPixelSize(R.dimen.epg_time_bar_Date_text)      // C
    private val weekTextSize = resources.getDimensionPixelSize(R.dimen.epg_time_bar_week_text)      // D
    private val monthTextSize = resources.getDimensionPixelSize(R.dimen.epg_time_bar_Month_text)    // E
    private val eventDefaultText = resources.getColor(R.color.epg_event_default_text)               // F
    private val dateMargin = resources.getDimensionPixelSize(R.dimen.epg_date_margin)               // G
    private val spacingColor = resources.getColor(R.color.epg_spacing)                              // H
    private val dateSpace = resources.getDimensionPixelSize(R.dimen.date_space)                     // V
    private val currentChannelColor = resources.getColor(R.color.current_channel)                   // P1
    private val notDataText: String = resources.getString(R.string.not_data)                        // Q1

    // --- ícones ---
    private val icon4: Bitmap = bitmaps.get(context, R.drawable.catchup_4_icon)                     // D1
    private val icon6: Bitmap = bitmaps.get(context, R.drawable.catchup_6_icon)                     // f5547b1
    private val subscribeIcon: Bitmap = bitmaps.get(context, R.drawable.catchup_subscribe_icon)     // E1
    private val subscribeIconSmall: Bitmap = bitmaps.get(context, R.drawable.catchup_subscribe_icon_small)   // F1

    // --- rolagem e escala de tempo ---
    private var maxScrollX = 0       // I
    private var maxScrollY = 0       // J
    protected var msPerPixel = 0L      // K
    private var originTime = 0L      // L
    protected var visibleStart = 0L    // M
    protected var visibleEnd = 0L      // N

    // --- seleção ---
    /** Índice do canal que está tocando (padrão 10). Original: `O`. */
    protected var playingChannel = 10
    /** Canal selecionado. Original: `P`. */
    protected var selectedChannel = 0
    /** Programa selecionado dentro do canal. Original: `Q`. */
    protected var selectedProgram = 0
    /** Ao desenhar o próximo ciclo, reposiciona `selectedProgram` no programa de agora. Original: `R`. */
    private var selectPlayingPending = true
    /** Idem, mas escolhendo o programa mais próximo do meio da tela. Original: `W`. */
    protected var relocatePending = false
    protected var currentProgram: ProgramBean? = null   // T (último programa "no ar" desenhado/selecionado)
    protected var dataStore: EpgDataStore? = null       // S
    protected var groupTitle: String? = null            // U (texto do cabeçalho "Grupo(3/80)")

    // --- estado de desenho ---
    private var lastEventEnd = 0L                       // H1 (fim do programa anterior, para desenhar lacunas)
    protected var showInitReminder = true                 // I1 (setInitData): mostra "catchup_init_remind" em vez da grade
    protected var selectedDateTime = ServerClock.get().now()   // J1 (instante usado para destacar o dia na barra)
    protected val loadedChannels = ArrayList<Int>()       // K1 (ordem de uso dos canais com EPG carregada)
    protected val cacheSize: Int = AppUserManager.get().getInt("epg_cache_size", 20)   // L1
    private val twoLineHeader = false                   // M1 (nunca atribuído; false → cabeçalho de uma linha)
    protected var selectionVisible = true                 // N1
    protected var dateFollowsSelection = true             // O1 (true = J1 não segue o programa selecionado)
    private val showNumTip: Boolean = AppUserManager.get().getBoolean("epg_show_num_tip", true)   // R1
    private var loadTask: TimerTask? = null             // G1
    protected val timer = Timer()                         // S1

    /** Listener de clique (nunca atribuído no APK). Original: campo de `x4.f` removido pelo R8. */
    var clickListener: EpgClickListener? = null

    init {
        isFocusable = true
        requestFocus()
        setOnKeyListener(this)
        setWillNotDraw(false)
        recomputeTimeScale()
        setPlayingChannel(true, selectedChannel)
    }

    // ------------------------------------------------------------------ API pública

    /** Define os dados da grade (inferido: o APK não tem setter; o campo `S` é lido por todos os métodos). */
    fun setData(store: EpgDataStore?, title: String?) {
        dataStore = store
        groupTitle = title
    }

    /** Original: `setInitData(boolean)` — `true` mostra o aviso "catchup_init_remind" (EPG ainda carregando). */
    fun setInitData(flag: Boolean) { showInitReminder = flag }

    /** Original: `setEPGClickListener(x4.f)` — vazio no APK. */
    fun setEPGClickListener(listener: EpgClickListener?) { /* vazio no original; ver [clickListener] */ }

    /** Original: `P(boolean, int)` — marca o canal tocando e (se [select]) também o canal selecionado. */
    fun setPlayingChannel(select: Boolean, channelIndex: Int) {
        selectPlayingPending = select
        if (select) {
            playingChannel = channelIndex
            selectedChannel = channelIndex
        }
    }

    /** Primeiro canal (linha) visível. Original: `getFirstVisibleChannelPosition()` */
    fun getFirstVisibleChannelPosition(): Int {
        val i = ((scrollY - margin) - timeBarHeight) / (rowHeight + margin)
        return if (i < 0) 0 else i
    }

    /** Último canal (linha) visível (+1 se a linha seguinte aparece parcialmente). Original: `getLastVisibleChannelPosition()` */
    fun getLastVisibleChannelPosition(): Int {
        val count = dataStore!!.channelCount()
        val bottom = scrollY + height
        var last = ((timeBarHeight + bottom) - margin) / (margin + rowHeight)
        val max = count - 1
        if (last > max) last = max
        if (bottom > rowHeight * last && last < max) return last + 1
        return last
    }

    private fun getXPositionStart(): Int =
        timeToX(ServerClock.get().now()) - (((width - channelWidth) - margin) / 2)

    // ------------------------------------------------------------------ conversões de tempo/posição

    /** px → instante (ms). Original: `M(int)` */
    protected fun xToTime(x: Int): Long = x.toLong() * msPerPixel + originTime

    /** instante → px. Original: `O(long)` */
    protected fun timeToX(time: Long): Int = ((time - originTime) / msPerPixel).toInt() + channelWidth + margin * 2

    /** topo (px) da linha [channel]. Original: `N(int)` */
    private fun channelTop(channel: Int): Int = channel * (rowHeight + margin) + margin + timeBarHeight

    /** Índice do canal na coordenada Y [y] (-1 se não há canais). Original: `L(int)` */
    fun channelAtY(y: Int): Int {
        val relative = y - timeBarHeight
        val index = (relative + margin) / (rowHeight + margin)
        if (dataStore!!.channelCount() == 0) return -1
        return index
    }

    private fun isSelectedChannel(channel: Int): Boolean = channel == selectedChannel   // S(int)

    /** O instante está dentro da janela visível? Original: `c0(long)` */
    private fun isInVisibleWindow(time: Long): Boolean = time >= visibleStart && time < visibleEnd

    /** O programa [start, end] aparece (total ou parcialmente) na área de programas? Original: `T(long, long)` */
    protected fun isProgramVisible(start: Long, end: Long): Boolean {
        if (timeToX(start) < scrollX + channelWidth || start > visibleEnd) {
            if (timeToX(end) < scrollX + channelWidth || end > visibleEnd) {
                if (timeToX(start) <= scrollX + channelWidth && end >= visibleEnd) return true
                return false
            }
            return true
        }
        return true
    }

    /** O instante atual do servidor está dentro de [start, end]? Original: `Q(long, long)` */
    private fun isNowBetween(start: Long, end: Long): Boolean {
        val now = ServerClock.get().now()
        return now >= start && now <= end
    }

    /** O programa está no ar? Original: `R(ProgramBean)` */
    private fun isProgramNow(program: ProgramBean): Boolean = isNowBetween(program.f(), program.g())

    private fun msPerPixel(): Long =
        visibleSpanMs.toLong() / ((resources.displayMetrics.widthPixels - channelWidth) - margin)   // p()

    private fun originTime(): Long = EpgDateShims.addDays(DateUtils.today(), -7)                     // q()

    private fun computeMaxScrollX() { maxScrollX = (1191600000L / msPerPixel).toInt() }               // n()

    private fun computeMaxScrollY() {                                                                // o()
        val bottom = channelTop(dataStore!!.channelCount() - 2) + rowHeight
        maxScrollY = if (bottom < height) 0 else (bottom - height) + rowHeight + margin * 2
    }

    /** Recalcula escala e janela visível. Original: `Y()` */
    protected fun recomputeTimeScale() {
        msPerPixel = msPerPixel()
        originTime = originTime()
        visibleStart = xToTime(0)
        visibleEnd = xToTime(width)
    }

    /** Rola por (dx, dy) respeitando os limites [0, max]. Original: `Z(int, int)` */
    fun scrollWithinBounds(dx: Int, dy: Int) {
        var x = dx
        var y = dy
        val sx = scrollX
        val sy = scrollY
        if (sx + x < 0) x = 0 - sx
        if (sy + y < 0) y = 0 - sy
        if (sx + x > maxScrollX + channelWidth) x = (maxScrollX - sx) + channelWidth
        if (sy + y > maxScrollY) y = maxScrollY - sy
        scrollBy(x, y)
    }

    /** Invalida e re-layout. Original: `X()` */
    fun refresh() {
        invalidate()
        requestLayout()
    }

    /**
     * Anima (600 ms, ou 0) o scroll até o canal tocando e o horário atual. Original: `W(boolean)`
     */
    fun scrollToNow(animate: Boolean) {
        val store = dataStore
        if (store == null || !store.hasChannels()) return
        recomputeTimeScale()
        computeMaxScrollY()
        computeMaxScrollX()
        val target = playingChannel
        val duration = if (animate) 600 else 0
        if (playingChannel > store.channelCount() - ((height - timeBarHeight) / (rowHeight + margin))) {
            scroller.startScroll(scrollX, scrollY, (getXPositionStart() - scrollX) - channelWidth, maxScrollY - scrollY, duration)
        } else {
            scroller.startScroll(scrollX, scrollY, (getXPositionStart() - scrollX) - channelWidth, (channelTop(target) - timeBarHeight) - scrollY, duration)
        }
        refresh()
    }

    /** Garante que a linha do canal selecionado esteja visível ao mover CIMA ([direction]=0) / BAIXO (1). Original: `a0(int)` */
    protected fun ensureChannelVisible(direction: Int) {
        if (direction == 0) {
            if ((channelTop(selectedChannel + 1) - scrollY) - timeBarHeight < rowHeight) {
                scrollTo(scrollX, channelTop(selectedChannel) - timeBarHeight)
            }
            return
        }
        if (direction == 1) {
            val sy = scrollY
            val remaining = height - (channelTop(selectedChannel) - sy)
            if (remaining < rowHeight) scrollWithinBounds(0, (rowHeight + margin) - remaining)
        }
    }

    /**
     * Depois de mudar de canal (CIMA/BAIXO), escolhe o programa do novo canal mais próximo do que estava selecionado
     * (ou do meio da área visível). Original: `U(int)`
     */
    protected fun pickProgramAfterVerticalMove(direction: Int) {
        val list = dataStore!!.programsOf(selectedChannel)!!.first
        ensureChannelVisible(direction)
        if (list.isEmpty()) return
        val previous = currentProgram
        val size = list.size
        for (i in 0 until size) {
            val candidate = list[i]
            var reference = previous?.f()
                ?: xToTime(scrollX + channelWidth + (((width - channelWidth) - margin) / 2))
            if (reference < visibleStart) reference = visibleStart
            if (candidate.f() > visibleEnd) {
                selectedProgram = i
                selectionVisible = true
                return
            }
            if (reference >= candidate.f() && reference < candidate.g() && isProgramVisible(candidate.f(), candidate.g())) {
                selectedProgram = i
                if (previous != null && i < size - 1 && previous.f() > candidate.f()) {
                    val next = list[i + 1]
                    if (next.f() >= previous.f() && next.g() <= previous.g() && isProgramVisible(next.f(), next.g())) {
                        selectedProgram = i + 1
                    }
                    selectionVisible = true
                    return
                }
            }
        }
        selectionVisible = pickProgramAtTime(list, ((visibleStart + visibleEnd) - channelWidth.toLong() * msPerPixel) / 2)
    }

    /**
     * Seleciona em [list] o programa que cobre o instante [time]; se nenhum, escolhe entre os visíveis (o único / o
     * último de dois / o do meio) e devolve se achou algum. Original: `J(List, long)`
     */
    protected fun pickProgramAtTime(list: List<ProgramBean>, time: Long): Boolean {
        if (list.isEmpty()) return false
        for (i in list.indices) {
            val p = list[i]
            if (time >= p.f() && time <= p.g()) {
                selectedProgram = i
                return true
            }
        }
        var last = selectedProgram
        var visibleCount = 0
        for (i in list.indices) {
            val p = list[i]
            if (isProgramVisible(p.f(), p.g())) {
                visibleCount++
                last = i
            }
            if (p.f() > visibleEnd) break
        }
        if (visibleCount == 0) return false
        if (visibleCount <= 2) {
            selectedProgram = last
            return true
        }
        selectedProgram = (((last * 2) - visibleCount) + 1) / 2
        return true
    }

    /** Original: `V(int, int)` — reúne os canais visíveis sem EPG carregada (`SparseArray<epgId>`); resultado descartado. */
    fun requestVisibleEpgs(first: Int, last: Int) {
        if (first < last) {
            getFirstVisibleChannelPosition()
            getLastVisibleChannelPosition()
            val pending = android.util.SparseArray<String?>()
            var i = first
            while (i <= last) {
                if (!dataStore!!.programsOf(i)!!.second) pending.put(i, dataStore!!.channel(i).epgId)
                i++
            }
        }
    }

    // ------------------------------------------------------------------ teclas

    /**
     * D-pad e teclas numéricas (ver KDoc da classe). Retorna sempre `false`, exceto nos ramos de dia (4/6/DEL)
     * quando a seleção continua visível (também `false`) — o original só devolve `false`.
     *
     * Original: `onKey(View, int, KeyEvent)` — os ramos OK/ENTER terminavam em `throw null` (ver [fireClick]).
     */
    override fun onKey(view: View?, i10: Int, event: KeyEvent): Boolean {
        val store = dataStore
        if (store == null || store.channelCount() < selectedChannel) return false
        val keyCode = event.keyCode
        val oldChannel = selectedChannel
        val oldProgram = selectedProgram
        val channelCount = store.channelCount()
        val (list, loaded) = store.programsOf(selectedChannel)!!
        visibleStart = xToTime(scrollX)
        visibleEnd = xToTime(scrollX + width)
        if (keyCode != 23 && keyCode != 66 && keyCode != 4 && (keyCode != 22 || event.action != 1)) dateFollowsSelection = false

        if (event.action != 0) {
            // ACTION_UP: só o agendamento de carga abaixo
        } else if (keyCode != 11) {
            if (keyCode == 13) {                       // KEYCODE_6: avança um dia
                val dayStart = EpgDateShims.startOfDay(visibleStart)
                val day = TimeUnit.DAYS
                val limit = dayStart + day.toMillis(6L)
                val target = (((visibleStart + visibleEnd) + (channelWidth.toLong() * msPerPixel)) / 2) + day.toMillis(1L)
                if (visibleEnd > limit - day.toMillis(1L)) {
                    scrollTo((timeToX(limit) - margin) - channelWidth, scrollY)
                } else {
                    scrollWithinBounds((day.toMillis(1L) / msPerPixel).toInt(), 0)
                }
                selectedDateTime = target
                val current = store.program(selectedChannel, selectedProgram)
                if (current != null && isProgramVisible(current.f(), current.g())) {
                    selectionVisible = true
                    return false
                }
                val found = pickProgramAtTime(list, target)
                selectionVisible = found
                if (found) return false
            } else if (keyCode == 66) {                // ENTER
                if (!CommonUtils.isFastClick(1000L)) {
                    if (loaded && list.isEmpty()) {
                        fireClick(null, store.channel(selectedChannel))
                    } else {
                        fireClick(store.program(selectedChannel, selectedProgram), store.channel(selectedChannel))
                    }
                }
            } else if (keyCode != 67) {
                when (keyCode) {
                    19 -> if (oldChannel > 0) {        // CIMA
                        selectedChannel--
                        pickProgramAfterVerticalMove(0)
                    }
                    20 -> if (oldChannel < channelCount - 1) {   // BAIXO
                        selectedChannel++
                        pickProgramAfterVerticalMove(1)
                    }
                    21 -> if (loaded) moveProgramLeft(list, oldProgram)
                    22 -> if (loaded) moveProgramRight(list)
                    23 -> if (!CommonUtils.isFastClick(1000L)) {   // OK
                        if (loaded) fireClick(store.program(selectedChannel, selectedProgram), store.channel(selectedChannel))
                    }
                }
            } else {                                   // DEL (67): volta ao canal/horário atuais
                selectedChannel = playingChannel
                relocatePending = true
                scrollToNow(false)
            }
        } else {                                       // KEYCODE_4: volta um dia
            val todayStart = EpgDateShims.startOfDay(ServerClock.get().now())
            val day = TimeUnit.DAYS
            val limit = todayStart - day.toMillis(7L)
            var target = (((visibleStart + visibleEnd) + (channelWidth.toLong() * msPerPixel)) / 2) - day.toMillis(1L)
            if (visibleStart >= limit) {
                scrollWithinBounds(-((day.toMillis(1L) / msPerPixel).toInt()), 0)
            } else if (visibleStart < limit) {
                scrollTo(timeToX(limit) - (margin + channelWidth), scrollY)
                target = ((width.toLong() * msPerPixel) / 2) + (scrollX.toLong() * msPerPixel)
            }
            selectedDateTime = target
            val current = store.program(selectedChannel, selectedProgram)
            if (current != null && isProgramVisible(current.f(), current.g())) {
                selectionVisible = true
                return false
            }
            val found = pickProgramAtTime(list, target)
            selectionVisible = found
            if (found) return false
        }

        if (event.action == KeyEvent.ACTION_UP && (keyCode == 19 || keyCode == 20) && !showInitReminder) {
            loadTask?.cancel()
            val task = LoadTask(channelCount)
            loadTask = task
            timer.schedule(task, 500L)
        }
        invalidate()
        return false
    }

    /** Seta ESQUERDA: programa anterior (ou o visível mais próximo se a seleção saiu da tela). */
    private fun moveProgramLeft(list: List<ProgramBean>, oldProgram: Int) {
        if (list.isEmpty()) {
            ToastUtils.show(context, context.getString(R.string.current_channel_no_epg), 0)
            return
        }
        if (selectedProgram == 0) ToastUtils.show(context, context.getString(R.string.no_more_epg), 0)
        if (selectedProgram >= list.size || list[0].f() > visibleEnd || list[list.size - 1].g() < visibleStart) {
            val reference = ((visibleStart + visibleEnd) + (msPerPixel * channelWidth.toLong())) / 2
            for (i in list.indices) {
                val p = list[i]
                if (isProgramVisible(p.f(), p.g()) && reference >= p.f() && reference <= p.g()) {
                    selectedProgram = i
                } else if (isProgramVisible(p.f(), p.g()) && reference <= p.f()) {
                    selectedProgram = i
                }
            }
        } else if (oldProgram > 0) {
            selectedProgram--
        }
        if (selectedProgram >= list.size || list[0].f() > visibleEnd || list[list.size - 1].g() < visibleStart) {
            selectedProgram = if (list[0].f() > visibleEnd) 0 else list.size - 1
            scrollTo((timeToX(list[selectedProgram].f()) - margin) - channelWidth, scrollY)
        } else {
            val p = list[selectedProgram]
            val start = p.f()
            val end = p.g()
            if (start < visibleStart) {
                scrollWithinBounds(((start - visibleStart) / msPerPixel).toInt() + margin, 0)
            } else {
                val right = scrollX + width
                if (end > ((right - ((margin * 2) + channelWidth)).toLong() * msPerPixel) + originTime) {
                    scrollWithinBounds(((end - visibleEnd) / msPerPixel).toInt() + (margin * 2) + channelWidth, 0)
                }
            }
        }
        selectionVisible = true
    }

    /** Seta DIREITA: próximo programa (limitado a 7 dias à frente). */
    private fun moveProgramRight(list: List<ProgramBean>) {
        if (list.isEmpty()) {
            ToastUtils.show(context, context.getString(R.string.current_channel_no_epg), 0)
            return
        }
        if (selectedProgram == list.size - 1) ToastUtils.show(context, context.getString(R.string.no_more_epg), 0)
        if (selectedProgram >= list.size || list[0].f() > visibleEnd || list[list.size - 1].g() < visibleStart) {
            val reference = ((visibleStart + visibleEnd) + (channelWidth.toLong() * msPerPixel)) / 2
            for (i in list.indices) {
                val p = list[i]
                if (isProgramVisible(p.f(), p.g()) && reference >= p.f() && reference <= p.g()) {
                    selectedProgram = i
                } else if (isProgramVisible(p.f(), p.g()) && reference <= p.f()) {
                    selectedProgram = i
                }
            }
        } else if (selectedProgram < list.size && list[selectedProgram].g() < EpgDateShims.addDays(DateUtils.today(), 7) && selectedProgram < list.size - 1) {
            selectedProgram++
        }
        if (selectedProgram < list.size && list[0].f() <= visibleEnd && list[list.size - 1].g() >= visibleStart) {
            val p = list[selectedProgram]
            val end = p.g()
            val start = p.f()
            val right = scrollX + width
            if (end > ((right - ((margin * 2) + channelWidth)).toLong() * msPerPixel) + originTime) {
                scrollWithinBounds(((end - visibleEnd) / msPerPixel).toInt() + margin + channelWidth, 0)
            } else if (start < visibleStart) {
                scrollTo((timeToX(start) - channelWidth) + margin, scrollY)
            }
            selectionVisible = true
        } else {
            selectedProgram = if (list[0].f() > visibleEnd) 0 else list.size - 1
            scrollTo((timeToX(list[selectedProgram].f()) - margin) - channelWidth, scrollY)
            selectionVisible = true
        }
    }

    /**
     * Dispara o [EpgClickListener]. No APK o campo é sempre null e o código compilado faz `throw null`.
     * Reproduzido: sem listener lança [NullPointerException].
     */
    private fun fireClick(program: ProgramBean?, channel: com.live.evo.model.ChannelData) {
        val listener = clickListener ?: throw NullPointerException("EPG click listener removido pelo R8 (throw null no original)")
        if (program == null) listener.onEmptyChannelClick(channel) else listener.onProgramClick(program, channel)
    }

    // ------------------------------------------------------------------ desenho

    override fun onDraw(canvas: Canvas) {
        val store = dataStore
        if (store == null || !store.hasChannels()) return
        visibleStart = xToTime(scrollX)
        visibleEnd = xToTime(scrollX + width)
        val rect = bgRect
        rect.left = scrollX
        rect.top = scrollY
        rect.right = rect.left + width
        rect.bottom = rect.top + height
        paint.color = resources.getColor(R.color.catchup_bg_3)
        canvas.drawRect(rect, paint)
        if (showInitReminder) drawInitReminder(canvas, rect)
        rect.left = scrollX + channelWidth
        val sy = scrollY
        rect.top = sy
        rect.right = rect.left + margin
        rect.bottom = sy + height
        paint.color = spacingColor
        canvas.drawRect(rect, paint)
        drawChannels(canvas, rect)
        if (!showInitReminder) drawPrograms(canvas, rect)
        drawTimeBar(canvas, rect)
        drawChannelHeader(canvas, rect)
        if (!showInitReminder) {
            drawSelection(canvas, rect)
            drawNowLine(canvas, rect)
        }
        if (twoLineHeader) {
            drawHelpTop(canvas, rect)
            drawHelpBottom(canvas, rect)
        } else {
            drawHelpSingleLine(canvas, rect)
        }
        drawDateBar(canvas, rect)
        if (scroller.computeScrollOffset()) scrollTo(scroller.currX, scroller.currY)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean = gestureDetector.onTouchEvent(event)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        scrollToNow(false)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {}

    /** Aviso "catchup_init_remind" centralizado, enquanto a EPG inicial carrega. Original: `A(Canvas, Rect)` */
    private fun drawInitReminder(canvas: Canvas, rect: Rect) {
        clipRect.left = scrollX + channelWidth + margin
        clipRect.top = scrollY + timeBarHeight
        clipRect.right = clipRect.left + width
        clipRect.bottom = clipRect.top + height
        canvas.save()
        canvas.clipRect(clipRect)
        rect.left = scrollX + channelWidth + margin
        rect.top = scrollY + timeBarHeight
        rect.right = clipRect.left + width
        rect.bottom = clipRect.top + height
        paint.color = channelBg
        canvas.drawRect(rect, paint)
        paint.color = eventDefaultText
        paint.textSize = eventTextSize.toFloat()
        val measure = TextPaint().also { it.textSize = eventTextSize.toFloat() }
            .measureText(resources.getString(R.string.catchup_init_remind)).toInt()
        rect.top = scrollY + timeBarHeight + (((height - timeBarHeight) - eventTextSize) / 2)
        rect.left = scrollX + channelWidth + (((width - channelWidth) - measure) / 2)
        paint.typeface = FontUtils.typeface3
        canvas.drawText(resources.getString(R.string.catchup_init_remind), rect.left.toFloat(), rect.top.toFloat(), paint)
        canvas.restore()
    }

    /** Coluna de canais: uma linha por canal visível + divisória final. Original: `t(Canvas, Rect)` */
    private fun drawChannels(canvas: Canvas, rect: Rect) {
        val last = getLastVisibleChannelPosition()
        var channel = getFirstVisibleChannelPosition()
        while (channel <= last) {
            drawChannel(canvas, channel, rect)
            if (channel == last) {
                rect.left = scrollX
                rect.top = channelTop(channel + 1)
                rect.right = rect.left + width
                rect.bottom = rect.top + margin
                paint.color = spacingColor
                canvas.drawRect(rect, paint)
            }
            channel++
        }
    }

    /** Uma célula de canal: "001 Nome" + ícone de catch-up. Original: `s(Canvas, int, Rect)` */
    private fun drawChannel(canvas: Canvas, index: Int, rect: Rect) {
        rect.left = scrollX
        val top = channelTop(index)
        rect.top = top
        rect.right = rect.left + channelWidth
        rect.bottom = rowHeight + top
        paint.color = channelBg
        canvas.drawRect(rect, paint)
        if (isSelectedChannel(index)) {
            paint.color = currentChannelColor
            rect.bottom += margin
            canvas.drawRect(rect, paint)
        }
        val sx = scrollX
        rect.left = sx
        rect.top = top
        rect.right = sx + width
        rect.bottom = rect.top + margin
        paint.color = spacingColor
        canvas.drawRect(rect, paint)
        val channel = dataStore!!.channel(index)
        val number = channel.number + 1
        var numberText = number.toString()
        if (number < 10) numberText = "00$numberText" else if (number < 100) numberText = "0$numberText"
        val label = numberText + " " + channel.name
        paint.color = eventDefaultText
        if (index == selectedChannel) paint.color = eventSelectedText
        paint.textSize = resources.getDimensionPixelSize(R.dimen.catchup_channel_text_size).toFloat()
        rect.left += padding
        rect.top += (rowHeight / 2) + padding
        rect.right -= padding
        rect.bottom -= padding
        paint.typeface = FontUtils.typeface1
        canvas.drawText(label, rect.left.toFloat(), rect.top.toFloat(), paint)
        if (ChannelSdkBridge.isCatchUpAvailable(channel.epgId, channel.channelId, null)) {
            val iconLeft = scrollX + ((channelWidth * 8) / 9)
            rect.left = iconLeft
            val iconWidth = resources.getDimensionPixelSize(R.dimen.catchup_icon_width)
            rect.right = iconLeft + iconWidth
            val iconTop = top + ((rowHeight - iconWidth) / 2)
            rect.top = iconTop
            rect.bottom = iconTop + iconWidth
            canvas.drawBitmap(bitmaps.get(context, R.drawable.play_back), null, rect, paint)
        }
    }

    /** Programas de todas as linhas visíveis. Original: `z(Canvas, Rect)` */
    private fun drawPrograms(canvas: Canvas, rect: Rect) {
        val last = getLastVisibleChannelPosition()
        var channel = getFirstVisibleChannelPosition()
        while (channel <= last) {
            lastEventEnd = 0L
            clipRect.left = scrollX + channelWidth + margin
            val top = channelTop(channel)
            clipRect.top = margin + top
            clipRect.right = scrollX + width
            clipRect.bottom = clipRect.top + rowHeight
            canvas.save()
            canvas.clipRect(clipRect)
            val store = dataStore
            if (store != null && store.programsOf(channel) != null) {
                val entry = store.programsOf(channel)!!
                val list = entry.first
                val selected = isSelectedChannel(channel)
                if (list.isEmpty()) {
                    rect.left = scrollX + channelWidth + margin
                    rect.top = top
                    rect.right = scrollX + width
                    rect.bottom = rect.top + rowHeight + margin
                    paint.color = eventBg
                    canvas.drawRect(rect, paint)
                    if (selected) {
                        paint.color = currentChannelColor
                        rect.left = scrollX + channelWidth
                        rect.top = top
                        rect.right = scrollX + width
                        rect.bottom = rect.top + rowHeight + margin
                        canvas.drawRect(rect, paint)
                    }
                    paint.color = eventDefaultText
                    if (selected) paint.color = eventSelectedText
                    var text = notDataText
                    if (!entry.second) text = resources.getString(R.string.loading)   // 2131952317
                    paint.textSize = eventTextSize.toFloat()
                    val measure = TextPaint().also { it.textSize = timeBarTextSize.toFloat() }.measureText(text)
                    rect.top += (rowHeight / 2) + (timeBarTextSize / 2)
                    canvas.drawText(text, rect.left + ((((width - channelWidth) - margin) - measure) / 2.0f), rect.top.toFloat(), paint)
                } else {
                    for (i in list.indices) {
                        val program = list[i]
                        if (program.f() > visibleEnd) {
                            if (program.f() <= lastEventEnd) break
                            drawGap(canvas, channel, program, rect)
                            lastEventEnd = program.g()
                            break
                        }
                        if (i == selectedChannel && !relocatePending) {
                            val current = store.program(selectedChannel, selectedProgram)
                            if (current != null && !isProgramVisible(current.f(), current.g())) relocatePending = true
                        }
                        if (isProgramVisible(program.f(), program.g())) {
                            loadedChannels.remove(channel)
                            loadedChannels.add(channel)
                            drawProgram(canvas, channel, program, rect, i)
                        }
                        if (i == list.size - 1) {
                            val end = program.g()
                            if (end < visibleEnd) {
                                rect.left = if (end < visibleStart) timeToX(visibleStart) - margin else timeToX(end)
                                rect.top = margin + top
                                rect.right = timeToX(visibleEnd)
                                rect.bottom = rect.top + rowHeight
                                paint.color = eventBg
                                if (selected) paint.color = currentChannelColor
                                canvas.drawRect(rect, paint)
                                paint.color = eventDefaultText
                                paint.textSize = eventTextSize.toFloat()
                                rect.left += padding
                                rect.right -= padding
                                val y = rect.top + ((rect.bottom - rect.top) / 2) + (textBounds.height() / 2)
                                rect.top = y
                                canvas.drawText(notDataText, rect.left.toFloat(), y.toFloat(), paint)
                            }
                        }
                    }
                }
                val sx = scrollX
                rect.left = sx
                rect.top = top
                rect.right = sx + width
                rect.bottom = rect.top + margin
                paint.color = spacingColor
                canvas.drawRect(rect, paint)
                canvas.restore()
            }
            channel++
        }
    }

    /** Separador vertical + retângulo do programa [start, end] em [rect]. Original: `b0(int, long, long, Rect, Canvas)` */
    private fun layoutProgramRect(channel: Int, start: Long, end: Long, rect: Rect, canvas: Canvas) {
        rect.left = timeToX(end) - margin
        val top = channelTop(channel)
        val y = top + margin
        rect.top = y
        rect.right = rect.left + margin
        rect.bottom = y + rowHeight
        paint.color = spacingColor
        canvas.drawRect(rect, paint)
        rect.left = timeToX(start)
        rect.top = channelTop(channel) + margin
        rect.right = timeToX(end) - margin
        rect.bottom = rect.top + rowHeight
    }

    /** Um programa: fundo (normal/agora/tocando), nome truncado e ícone de lembrete. Original: `y(Canvas, int, p, Rect, int)` */
    private fun drawProgram(canvas: Canvas, channel: Int, program: ProgramBean, rect: Rect, index: Int) {
        if (program.f() > lastEventEnd) drawGap(canvas, channel, program, rect)
        lastEventEnd = program.g()
        val mid = ((visibleStart + visibleEnd) - (channelWidth.toLong() * msPerPixel)) / 2
        if (relocatePending && selectedChannel == channel && mid >= program.f() && mid < program.g()) {
            selectedProgram = index
            relocatePending = false
        }
        if (relocatePending && selectedChannel == channel && mid < program.f()) {
            selectedProgram = index
            relocatePending = false
        }
        layoutProgramRect(channel, program.f(), program.g(), rect, canvas)
        val isPlaying = playingChannel == channel && isProgramNow(program)
        var color = eventBg
        if (isPlaying) {
            if (selectPlayingPending) {
                selectedProgram = index
                selectPlayingPending = false
                relocatePending = false
            }
            color = resources.getColor(R.color.current_play)
        } else if (isProgramNow(program)) {
            color = eventBgCurrent
            if (currentProgram == null) currentProgram = program
        }
        if (index == 0) rect.left -= margin
        paint.color = color
        canvas.drawRect(rect, paint)
        val selected = isSelectedChannel(channel)
        if (selected) {
            paint.color = currentChannelColor
            canvas.drawRect(rect, paint)
        }
        rect.left += padding
        rect.right -= padding
        if (selected || (playingChannel == channel && isProgramNow(program)) || (selectedChannel == channel && selectedProgram == index)) {
            paint.color = eventSelectedText
        } else {
            paint.color = eventDefaultText
        }
        paint.textSize = eventTextSize.toFloat()
        val title = program.e()!!
        paint.getTextBounds(title, 0, title.length, textBounds)
        val top = rect.top
        rect.top = top + ((rect.bottom - top) / 2) + (textBounds.height() / 2)
        paint.typeface = FontUtils.typeface3
        val minLeft = timeToX(visibleStart)
        if (rect.left < minLeft) rect.left = minLeft + padding
        canvas.drawText(title.substring(0, paint.breakText(title, true, (rect.right - rect.left).toFloat(), null)), rect.left.toFloat(), rect.top.toFloat(), paint)
        if (twoLineHeader) {
            val channelData = dataStore!!.channel(channel)
            if (ChannelSdkBridge.isSubscribed(program, channelData.channelId)) {
                rect.top = channelTop(channel) + 5
                rect.right = (rect.left + resources.getDimensionPixelSize(R.dimen.catchup_icon_width2)) - margin
                rect.bottom = rect.top + resources.getDimensionPixelSize(R.dimen.catchup_icon_width2)
                canvas.drawBitmap(subscribeIconSmall, null, rect, paint)
            }
        }
    }

    /** Lacuna sem programa antes de [program]: bloco com "not_data". Original: `B(Canvas, int, p, Rect)` */
    private fun drawGap(canvas: Canvas, channel: Int, program: ProgramBean, rect: Rect) {
        val gapStart = lastEventEnd
        if (gapStart < visibleStart) lastEventEnd = visibleStart - (margin.toLong() * msPerPixel)
        layoutProgramRect(channel, lastEventEnd, program.f() - margin.toLong(), rect, canvas)
        paint.color = eventBg
        if (isNowBetween(lastEventEnd, program.f())) paint.color = eventBgCurrent
        canvas.drawRect(rect, paint)
        if (isSelectedChannel(channel)) {
            paint.color = currentChannelColor
            canvas.drawRect(rect, paint)
        }
        rect.left += padding
        paint.color = eventDefaultText
        paint.textSize = eventTextSize.toFloat()
        paint.getTextBounds(notDataText, 0, notDataText.length, textBounds)
        val top = rect.top
        rect.top = top + ((rect.bottom - top) / 2) + (textBounds.height() / 2)
        paint.typeface = FontUtils.typeface3
        val minLeft = timeToX(visibleStart)
        if (rect.left < minLeft) rect.left = minLeft
        canvas.drawText(notDataText.substring(0, paint.breakText(notDataText, true, (rect.right - rect.left).toFloat(), null)), rect.left.toFloat(), rect.top.toFloat(), paint)
    }

    /** Contorno do programa selecionado (ou da linha, se nenhum programa visível). Original: `u(Canvas, Rect)` */
    private fun drawSelection(canvas: Canvas, rect: Rect) {
        val current = dataStore!!.program(selectedChannel, selectedProgram)
        if (current != null) selectionVisible = isProgramVisible(current.f(), current.g())
        if (!selectionVisible) {
            drawSelectionBox(canvas, rect)
            return
        }
        val program = dataStore!!.program(selectedChannel, selectedProgram)
        paint.maskFilter = BlurMaskFilter(10.0f, BlurMaskFilter.Blur.SOLID)
        if (program == null) {
            drawSelectionBox(canvas, rect)
        } else if (isProgramVisible(program.f(), program.g())) {
            rect.left = Math.max(timeToX(program.f()), scrollX + channelWidth)
            rect.top = channelTop(selectedChannel)
            rect.right = Math.min(timeToX(program.g()) - margin, (scrollX + width) - margin)
            rect.bottom = rect.top + rowHeight
            paint.color = resources.getColor(R.color.event_select_color)
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = resources.getDimensionPixelSize(R.dimen.select_stroke_width).toFloat()
            canvas.drawRect(rect, paint)
            paint.style = Paint.Style.FILL
            currentProgram = program
        } else {
            val list = dataStore!!.programsOf(selectedChannel)?.first
            if (list != null && list.isNotEmpty()) {
                for (i in list.indices) {
                    val p = list[i]
                    val mid = ((visibleStart + visibleEnd) - (channelWidth.toLong() * msPerPixel)) / 2
                    if (mid < p.f() || mid >= p.g()) {
                        if (p.f() > visibleEnd) break
                    } else if (isProgramVisible(p.f(), p.g())) {
                        selectedProgram = i
                        drawSelection(canvas, rect)
                        return
                    }
                }
            }
        }
        paint.maskFilter = null
    }

    /** Moldura em volta da linha do canal selecionado (sem programa visível). Original: `C(Canvas, Rect)` */
    private fun drawSelectionBox(canvas: Canvas, rect: Rect) {
        rect.left = scrollX + channelWidth
        rect.top = channelTop(selectedChannel)
        rect.right = (scrollX + width) - (margin * 2)
        rect.bottom = rect.top + rowHeight
        paint.color = resources.getColor(R.color.event_select_color)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = resources.getDimensionPixelSize(R.dimen.select_stroke_width).toFloat()
        canvas.drawRect(rect, paint)
        paint.style = Paint.Style.FILL
    }

    /** Barra de horas ("HH:00" a cada hora cheia). Original: `G(Canvas, Rect)` */
    private fun drawTimeBar(canvas: Canvas, rect: Rect) {
        rect.left = scrollX + channelWidth + margin
        rect.top = scrollY + dateHeaderHeight
        rect.right = rect.left + width
        rect.bottom = scrollY + timeBarHeight
        clipRect.left = scrollX + channelWidth + margin
        clipRect.top = scrollY + dateHeaderHeight
        clipRect.right = scrollX + width
        clipRect.bottom = scrollY + timeBarHeight
        canvas.save()
        canvas.clipRect(clipRect)
        paint.color = resources.getColor(R.color.epg_time_bar_bg)
        canvas.drawRect(rect, paint)
        paint.color = resources.getColor(R.color.epg_time_bar_text_color)
        paint.textSize = timeBarTextSize.toFloat()
        for (i in 0 until 10) {
            val time = (((visibleStart + (halfHourMs * i).toLong()) + 900000L) / 1800000L) * 1800000L
            val text = CatchUpPlayInfoFactory.formatTime(time)
            if (text.endsWith("00")) {
                val x = timeToX(time).toFloat()
                val top = rect.top
                canvas.drawText(text, x, (top + ((rect.bottom - top) / 2) + (timeBarTextSize / 2)).toFloat(), paint)
            }
        }
        canvas.restore()
        drawSeparators(canvas, rect)
    }

    /** Linha vertical do instante atual, com bolinha no topo. Original: `H(Canvas, Rect)` */
    private fun drawNowLine(canvas: Canvas, rect: Rect) {
        val now = System.currentTimeMillis()
        if (isInVisibleWindow(now)) {
            rect.left = timeToX(now)
            val top = scrollY + timeBarHeight
            rect.top = top
            rect.right = rect.left + timeLineWidth
            rect.bottom = top + height
            paint.color = timeLineColor
            paint.maskFilter = BlurMaskFilter(5.0f, BlurMaskFilter.Blur.SOLID)
            val radius = resources.getDimensionPixelSize(R.dimen.line_radius)
            canvas.drawCircle(rect.centerX().toFloat(), rect.top.toFloat(), radius.toFloat(), paint)
            rect.top = scrollY + timeBarHeight + radius
            rect.bottom = scrollY + height
            canvas.drawRect(rect, paint)
            paint.maskFilter = null
        }
    }

    /** Duas faixas horizontais de separação (sob a barra de datas e sob a barra de horas). Original: `I(Canvas, Rect)` */
    private fun drawSeparators(canvas: Canvas, rect: Rect) {
        rect.left = scrollX
        rect.top = (scrollY + timeBarHeight) - (margin / 2)
        rect.right = rect.left + width
        rect.bottom = rect.top + margin
        paint.color = spacingColor
        canvas.drawRect(rect, paint)
        rect.left = scrollX
        rect.top = scrollY + dateHeaderHeight
        rect.right = rect.left + width
        rect.bottom = rect.top + margin
        canvas.drawRect(rect, paint)
    }

    /** Cabeçalho da coluna de canais: "Grupo(posição/total)". Original: `r(Canvas, Rect)` */
    private fun drawChannelHeader(canvas: Canvas, rect: Rect) {
        rect.left = scrollX
        rect.top = scrollY + dateHeaderHeight
        rect.right = rect.left + channelWidth
        rect.bottom = scrollY + timeBarHeight
        paint.color = channelBg
        canvas.drawRect(rect, paint)
        paint.color = eventDefaultText
        val size = resources.getDimensionPixelSize(R.dimen.catchup_channel_text_size)
        paint.textSize = size.toFloat()
        paint.typeface = FontUtils.typeface1
        val textPaint = TextPaint().also { it.textSize = size.toFloat() }
        val text = String.format("%s(%d/%d)", groupTitle, selectedChannel + 1, dataStore!!.channelCount())
        val x = rect.left + ((channelWidth - textPaint.measureText(text)) / 2.0f)
        val top = rect.top
        canvas.drawText(text, x, (top + ((rect.bottom - top) / 2) + (size / 2)).toFloat(), paint)
        rect.bottom = rect.top + margin
        paint.color = spacingColor
        canvas.drawRect(rect, paint)
    }

    /** Faixa de fundo do cabeçalho de datas. Original: `x(Canvas, Rect)` */
    private fun drawDateSeparator(canvas: Canvas, rect: Rect) {
        rect.left = scrollX
        rect.top = scrollY + dateHeaderHeight
        rect.right = rect.left + width
        rect.bottom = rect.top + margin
        paint.color = epgBackground
        canvas.drawRect(rect, paint)
    }

    /** Barra de datas: 7 dias (a partir de hoje, ou dos 7 passados), mês e as setas ◀ ▶. Original: `w(Canvas, Rect)` */
    private fun drawDateBar(canvas: Canvas, rect: Rect) {
        val program = dataStore!!.program(selectedChannel, selectedProgram)
        val reference: Long = if (dateFollowsSelection || program == null || !isProgramVisible(program.f(), program.g())) {
            selectedDateTime
        } else {
            selectedDateTime = program.f()
            program.f()
        }
        rect.left = scrollX + (channelWidth * 2)
        rect.top = scrollY
        rect.right = rect.left + width
        rect.bottom = rect.top + dateHeaderHeight
        clipRect.left = scrollX + channelWidth
        clipRect.top = scrollY
        clipRect.right = scrollX + width
        clipRect.bottom = clipRect.top + dateHeaderHeight
        canvas.save()
        canvas.clipRect(clipRect)
        paint.color = epgBackground
        canvas.drawRect(rect, paint)
        val today = DateUtils.today()
        val dateWide = resources.getDimensionPixelSize(R.dimen.date_wide)
        if (today > reference) {
            for (i in 0 until 7) drawDateCell(canvas, rect, dateWide, EpgDateShims.calendarInZone(today, i - 7), i)
        } else {
            for (i in 0 until 7) drawDateCell(canvas, rect, dateWide, EpgDateShims.calendarInZone(today, i), i)
        }
        paint.textSize = monthTextSize.toFloat()
        paint.typeface = FontUtils.typeface1
        val month = resources.getTextArray(R.array.month)[Date().month]
        rect.left = scrollX + (dateSpace / 2) + dateMargin + dateWide + resources.getDimensionPixelSize(R.dimen.date_move_right)
        val sy = scrollY
        rect.top = sy
        rect.right = rect.left + dateWide
        rect.bottom = sy + dateHeaderHeight
        canvas.drawText(month.toString(), (rect.left + (dateWide / 4)).toFloat(), (rect.centerY() + (monthTextSize / 2)).toFloat(), paint)
        drawDateSeparator(canvas, rect)
        canvas.restore()
    }

    /**
     * Célula de um dia: círculo (destacado se é o dia da seleção), número, dia da semana e, no 1º dia, os triângulos
     * de "dia anterior/seguinte" (cinza quando já está no limite ±7 dias). Original: `v(Canvas, Rect, int, Calendar, int)`
     */
    private fun drawDateCell(canvas: Canvas, rect: Rect, cellWidth: Int, calendar: Calendar, index: Int) {
        val program = dataStore!!.program(selectedChannel, selectedProgram)
        val reference: Long = if (dateFollowsSelection) {
            selectedDateTime
        } else if (!selectionVisible) {
            visibleStart
        } else if (program != null) {
            selectedDateTime = program.f()
            program.f()
        } else {
            selectedDateTime
        }
        val moveRight = resources.getDimensionPixelSize(R.dimen.date_move_right)
        rect.left = scrollX + ((dateSpace * 2) / 3) + dateMargin + ((index + 2) * cellWidth) + moveRight
        val sy = scrollY
        rect.top = sy
        rect.right = rect.left + cellWidth
        rect.bottom = sy + dateHeaderHeight
        val selectedCal = Calendar.getInstance()
        calendar.timeZone = com.live.evo.util.TimeZoneHelper.get().timeZone()
        selectedCal.timeInMillis = reference
        var color = resources.getColor(R.color.date_normal)
        val day = calendar.get(5)
        val minus7 = EpgDateShims.calendarInZone(DateUtils.today(), -7)
        val plus6 = EpgDateShims.calendarInZone(DateUtils.today(), 6)
        var textColor = eventDefaultText
        if (selectedCal.get(5) == day || (selectedCal.timeInMillis < minus7.timeInMillis && calendar.get(5) == minus7.get(5))) {
            color = resources.getColor(R.color.epg_date_bg)
            paint.setShadowLayer(3.0f, 5.0f, 5.0f, resources.getColor(R.color.black_10))
            textColor = eventSelectedText
        } else if (day == Date().date) {
            color = resources.getColor(R.color.current_today)
        }
        paint.color = color
        canvas.drawCircle(rect.centerX().toFloat(), rect.centerY().toFloat(), (cellWidth / 3).toFloat(), paint)
        paint.clearShadowLayer()
        val dayPaint = TextPaint().also { it.textSize = dateTextSize.toFloat() }
        val dayText = "$day"
        val dayWidth = dayPaint.measureText(dayText)
        val baseline = (dateHeaderHeight / 2) + resources.getDimensionPixelSize(R.dimen.catchup_date_padding).toFloat()
        val half = (cellWidth / 2).toFloat()
        paint.color = textColor
        paint.textSize = dateTextSize.toFloat()
        paint.typeface = Typeface.DEFAULT
        canvas.drawText(dayText, rect.left + (half - (dayWidth / 2.0f)), rect.top + baseline, paint)
        paint.typeface = FontUtils.typeface2
        paint.textSize = weekTextSize.toFloat()
        val weekPaint = TextPaint().also { it.textSize = weekTextSize.toFloat() }
        val weekText = EpgDateShims.weekdayName(calendar.timeInMillis)
        canvas.drawText(weekText, rect.left + (half - (weekPaint.measureText(weekText) / 2.0f)), rect.top + baseline + (dateTextSize / 2), paint)
        if (index == 0) {
            val triangle = resources.getDimensionPixelSize(R.dimen.catchup_triangle)
            rect.left = scrollX + ((dateSpace * 5) / 9) + dateMargin + (cellWidth * 2) + moveRight + resources.getDimensionPixelSize(R.dimen.catchup_left_triangle)
            rect.top = scrollY + ((dateHeaderHeight - triangle) / 2)
            val left = Path()
            left.moveTo(rect.left.toFloat(), (scrollY + (dateHeaderHeight / 2)).toFloat())
            val w = (triangle * 1.71f) / 2.0f
            val halfTri = triangle / 2
            left.lineTo(rect.left + w, ((scrollY + (dateHeaderHeight / 2)) - halfTri).toFloat())
            left.lineTo(rect.left + w, (scrollY + (dateHeaderHeight / 2) + halfTri).toFloat())
            left.lineTo(rect.left.toFloat(), (scrollY + (dateHeaderHeight / 2)).toFloat())
            val disabled = resources.getColor(R.color.unfocus_tri)
            paint.color = if (selectedCal.get(5) == minus7.get(5)) disabled else eventSelectedText
            canvas.drawPath(left, paint)
            val right = Path()
            rect.left = ((scrollX + ((dateSpace * 9) / 7) + dateMargin + (cellWidth * 8.2f)).toInt()) + moveRight + resources.getDimensionPixelSize(R.dimen.catchup_right_triangle)
            rect.top = scrollY
            right.moveTo(rect.left.toFloat(), ((scrollY + (dateHeaderHeight / 2)) - halfTri).toFloat())
            right.lineTo(rect.left.toFloat(), (scrollY + (dateHeaderHeight / 2) + halfTri).toFloat())
            right.lineTo(rect.left + w, (scrollY + (dateHeaderHeight / 2)).toFloat())
            paint.color = if (selectedCal.get(5) == plus6.get(5)) disabled else eventSelectedText
            canvas.drawPath(right, paint)
        }
    }

    /** Legenda de uma linha no canto superior esquerdo: "pressione 4 / 6 para mudar de dia". Original: `D(Canvas, Rect)` */
    private fun drawHelpSingleLine(canvas: Canvas, rect: Rect) {
        rect.left = scrollX
        rect.top = scrollY
        rect.right = rect.left + (channelWidth * 2)
        rect.bottom = scrollY + dateHeaderHeight
        paint.color = epgBackground
        canvas.drawRect(rect, paint)
        if (!showNumTip) return
        drawNumTip(canvas, rect, dateHeaderHeight)
    }

    /** Metade superior da legenda de duas linhas (`M1`; nunca usada). Original: `E(Canvas, Rect)` */
    private fun drawHelpTop(canvas: Canvas, rect: Rect) {
        rect.left = scrollX
        rect.top = scrollY
        rect.right = rect.left + (channelWidth * 2)
        rect.bottom = scrollY + (dateHeaderHeight / 2)
        paint.color = epgBackground
        canvas.drawRect(rect, paint)
        if (!showNumTip) return
        drawNumTip(canvas, rect, dateHeaderHeight / 2)
    }

    /** Texto "catchup_press" [4] [6] "catchup_remind2" (ícones 4 e 6). Parte comum de `D` e `E`. */
    private fun drawNumTip(canvas: Canvas, rect: Rect, areaHeight: Int) {
        rect.left = scrollX + padding
        paint.typeface = FontUtils.typeface1
        paint.color = eventDefaultText
        val textSize = resources.getDimensionPixelSize(R.dimen.catchup_remind_text_size)
        paint.textSize = textSize.toFloat()
        rect.top = scrollY
        rect.bottom = scrollY + areaHeight
        val press = resources.getString(R.string.catchup_press)
        val halfText = textSize / 2
        canvas.drawText(press, rect.left.toFloat(), (rect.centerY() + halfText).toFloat(), paint)
        val measure = TextPaint().also { it.textSize = textSize.toFloat() }.measureText(press)
        val numHeight = resources.getDimensionPixelSize(R.dimen.remind_num_height)
        rect.left = scrollX + measure.toInt() + ((padding * 6) / 4)
        val top = if (areaHeight == dateHeaderHeight) scrollY + ((dateHeaderHeight - numHeight) / 2)
                  else scrollY + (((rect.bottom - rect.top) - numHeight) / 2)
        rect.top = top
        val left = rect.left
        rect.right = left + numHeight
        rect.bottom = numHeight + top
        rect.left = left + (margin * 2)
        rect.top = top + resources.getDimensionPixelSize(R.dimen.line_radius)
        rect.bottom += resources.getDimensionPixelSize(R.dimen.line_radius2)
        canvas.drawBitmap(icon4, null, rect, paint)
        val right = rect.right
        rect.left = (margin * 2) + right
        rect.right = right + numHeight
        canvas.drawBitmap(icon6, null, rect, paint)
        rect.left = rect.right + (margin * 2)
        rect.bottom = scrollY + areaHeight
        rect.top = scrollY
        rect.left += margin * 2
        canvas.drawText(resources.getString(R.string.catchup_remind2), rect.left.toFloat(), (rect.centerY() + halfText).toFloat(), paint)
    }

    /** Metade inferior da legenda de duas linhas: ícone de lembrete + "subscribe_epg_tip". Original: `F(Canvas, Rect)` */
    private fun drawHelpBottom(canvas: Canvas, rect: Rect) {
        rect.left = scrollX
        rect.top = scrollY + (dateHeaderHeight / 2)
        rect.right = rect.left + (channelWidth * 2)
        rect.bottom = scrollY + dateHeaderHeight
        paint.color = epgBackground
        canvas.drawRect(rect, paint)
        val numHeight = resources.getDimensionPixelSize(R.dimen.remind_num_height)
        val left = scrollX + ((padding * 6) / 4)
        rect.right = numHeight + left
        val top = rect.top
        rect.bottom = numHeight + top
        rect.left = left + (margin * 2)
        rect.top = top + resources.getDimensionPixelSize(R.dimen.line_radius2)
        rect.bottom += resources.getDimensionPixelSize(R.dimen.line_radius4)
        canvas.drawBitmap(subscribeIcon, null, rect, paint)
        rect.left = rect.right + padding
        paint.typeface = FontUtils.typeface1
        paint.color = eventDefaultText
        val size = resources.getDimensionPixelSize(R.dimen.catchup_remind_text_size)
        paint.textSize = size.toFloat()
        rect.top = scrollY + (dateHeaderHeight / 2)
        rect.bottom = (scrollY + dateHeaderHeight) - padding
        canvas.drawText(resources.getString(R.string.subscribe_epg_tip), rect.left.toFloat(), (rect.centerY() + (size / 2)).toFloat(), paint)
    }

    // ------------------------------------------------------------------ classes internas

    /**
     * Tarefa (500 ms após soltar CIMA/BAIXO): descarta a EPG dos canais mais antigos da fila quando passam de
     * `cacheSize` e pede a EPG dos visíveis. Original: `EPG$a` (TimerTask)
     */
    private inner class LoadTask(private val channelCount: Int) : TimerTask() {
        override fun run() {
            while (loadedChannels.size > cacheSize) {
                val oldest = loadedChannels.removeAt(0)
                try {
                    if (oldest < dataStore!!.channelCount()) dataStore!!.clear(oldest)
                } catch (e: Exception) {
                    logger.error("EPG onKeyDown TimerTask Error", e)
                    return
                }
            }
            val first = getFirstVisibleChannelPosition()
            var last = getLastVisibleChannelPosition()
            val candidate = last - 3
            if (last <= channelCount - 3) last = candidate
            requestVisibleEpgs(first, last)
        }
    }

    /** Gestos de toque: arrastar rola, fling continua no [Scroller], toque simples (sem efeito no APK). Original: `EPG$b` */
    private inner class GridGestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent): Boolean {
            if (!scroller.isFinished) scroller.forceFinished(true)
            return true
        }

        override fun onFling(e1: MotionEvent?, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
            scroller.fling(scrollX, scrollY, -velocityX.toInt(), -velocityY.toInt(), 0, maxScrollX, 0, maxScrollY)
            refresh()
            return true
        }

        override fun onScroll(e1: MotionEvent?, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
            scrollWithinBounds(distanceX.toInt(), distanceY.toInt())
            return true
        }

        override fun onSingleTapUp(e: MotionEvent): Boolean {
            e.x
            if (channelAtY(scrollY + e.y.toInt()) != -1) {
                // EPG.d(EPG) devolvia o listener removido (null): nenhuma ação
                return true
            }
            return true
        }
    }
}
