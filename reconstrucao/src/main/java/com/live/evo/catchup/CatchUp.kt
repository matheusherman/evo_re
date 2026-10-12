package com.live.evo.catchup

import android.content.Context
import com.live.evo.activity.CatchUpPlayerActivity
import com.live.evo.model.ProgramBean
import com.live.evo.util.DateFormatFactory
import com.live.evo.util.DateUtils
import com.live.evo.util.ModelHelper
import com.live.evo.util.ToastUtils
import kotlinx.coroutines.flow.Flow
import org.slf4j.LoggerFactory
import java.util.Date

/**
 * Contrato "clicou em um programa passado": inicia o catch-up e chama [callback] com sucesso/falha.
 * Original: x4/a.java
 */
interface CatchUpClickListener {
    /** Original: a(String catchupType, p epgBean, String channelId, m<Boolean> callback) */
    fun onCatchUpClick(catchupType: String, program: ProgramBean?, channelId: String?, callback: (Boolean) -> Unit)
}

/**
 * Implementação padrão: valida o programa (fim > início e fim <= agora), checa suporte
 * ([ModelHelper.isCatchUpAvailable]; senão toast `playback_not_supported`) e abre [CatchUpPlayerActivity]
 * com [CatchUpPlayInfo] montado por [CatchUpPlayInfoFactory].
 * Original: x4/d.java (nome sugerido LiveCatchUpClickHandler)
 */
class LiveCatchUpClickHandler(private val context: Context) : CatchUpClickListener {
    override fun onCatchUpClick(catchupType: String, program: ProgramBean?, channelId: String?, callback: (Boolean) -> Unit) {
        if (program == null || program.endTime <= program.startTime || program.endTime > DateUtils.now()) {
            callback(false)
            return
        }
        if (!ModelHelper.isCatchUpAvailable(program.epgId, channelId, program.startTime)) {
            ToastUtils.show(context, com.live.evo.R.string.playback_not_supported, 0)
            callback(false)
            return
        }
        CatchUpPlayerActivity.start(
            context, channelId, catchupType,
            CatchUpPlayInfoFactory.create(program, channelId),
            CatchUpPlayInfoFactory.provider(channelId),
        )
        callback(true)
    }
}

/**
 * Dados de reprodução de um catch-up (início/fim em ms, título, descrição, canal, ícone, número...).
 * Original: x4/c.java (campos f21810a..f21832w; setters k..t)
 */
class CatchUpPlayInfo {
    var startTime: Long = 0     // k(long) / a()
    var endTime: Long = 0       // r(long) / g()
    var title: String? = null   // q(String)
    var description: String? = null // p(String)
    var channelId: String? = null   // l(String) / m(String)
    var channelName: String? = null // s(String)
    var channelIcon: String? = null // n(String)
    var channelNumber: Int = 0      // o(int) / d()
    var catchupType: String? = null // t(String)
}

/** Fábrica de [CatchUpPlayInfo] e formatação "HH:mm". Original: x4/g.java */
object CatchUpPlayInfoFactory {
    private val sdf = DateFormatFactory.create("HH:mm")
    private val logger = LoggerFactory.getLogger(CatchUpPlayInfoFactory::class.java)

    /** Monta o info a partir do programa e do canal (via [ModelHelper] / MediaRepository). Original: a(p, String) */
    fun create(program: ProgramBean?, channelId: String?): CatchUpPlayInfo? {
        if (program == null) return null
        return CatchUpPlayInfo().apply {
            startTime = program.startTime; endTime = program.endTime
            title = program.title; description = program.description
            // canal: ModelHelper.s(channelId) -> nome/ícone/número (setters l, m, n, o, s, t)
            this.channelId = channelId
        }
    }

    /** Provider assíncrono (Flow) do info (`u.c<Flow<c>, c>` do SDK). Original: b(String) */
    fun provider(channelId: String?): Any? = TODO("u.c<Flow<CatchUpPlayInfo>, CatchUpPlayInfo> — fornecido pelo SDK de reprodução")

    /** Original: c(long) */
    fun formatTime(millis: Long): String = sdf.format(Date(millis))
}

/**
 * Armazém de canais + listas de programas (EPG grande): [channels] e, para cada canal, um par
 * (lista de programas, carregado?). `getProgram(i, j)` devolve o j-ésimo (ou o último se j>=size).
 * Original: x4/b.java
 */
class EpgDataStore(
    val channels: List<com.live.evo.model.ChannelData>,
    val programs: MutableList<Pair<List<ProgramBean>, Boolean>>,
) {
    fun channel(i: Int) = channels[i]
    fun channelCount() = channels.size
    fun program(channelIndex: Int, programIndex: Int): ProgramBean? {
        val list = programs.getOrNull(channelIndex)?.first
        if (programs.size <= channelIndex || programIndex < 0 || list.isNullOrEmpty()) return null
        return if (list.size > programIndex) list[programIndex] else list.last()
    }
    fun programsOf(channelIndex: Int) = programs.getOrNull(channelIndex)
    fun programCount(channelIndex: Int) = programs.getOrNull(channelIndex)?.first?.size ?: 0
    fun hasChannels() = channels.isNotEmpty()
    fun clear(channelIndex: Int) { programs[channelIndex] = Pair(ArrayList(), false) }
}
