package com.live.evo.dialog

import android.animation.ObjectAnimator
import android.app.Dialog
import android.content.Context
import android.os.Handler
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.leanback.widget.HorizontalGridView
import com.live.evo.R
import com.live.evo.catchup.CatchUpClickListener
import com.live.evo.model.ChannelData
import com.live.evo.model.ProgramBean
import com.live.evo.osd.EpgDayAdapter
import com.live.evo.osd.EpgItemListener
import com.live.evo.util.CommonUtils
import com.live.evo.util.DateFormatFactory
import com.live.evo.util.DateUtils
import com.live.evo.util.ModelHelper
import com.live.evo.util.ServerClock
import com.live.evo.util.ToastUtils
import org.slf4j.LoggerFactory
import java.text.SimpleDateFormat
import java.util.Date

/**
 * "Grande EPG" em diálogo (layout `epg_dialog`) aberto pelo D-pad direito na live. Mostra, para o canal atual,
 * um [HorizontalGridView] com um [EpgDayAdapter] (um item por dia) e, abaixo, o painel de descrição do programa
 * focado (hora, nome, descrição) com setas de rolagem (esq./dir.) e relógio do servidor (1 s).
 *
 * Fluxo de dados (`fetchData`): se `ModelHelper.isEpgNotReady()` mostra "epg init"; senão mostra loading e
 * coleta `MediaRepository.D(epgId)` (Flow<List<EPGProgramme>>) → `ModelHelper.k(channelId, epgId, list)` →
 * UI na main: adapter.setData(lista); em erro grava log "get epgId data error". Guarda (channelId, sucesso) para
 * evitar rebuscar ([markLoaded]/[isLoaded]).
 *
 * Seleção de programa ([SelectListener], implementa [EpgItemListener]):
 * - `a(time, program, desc)` atualiza textos do painel (via Handler);
 * - `b(bean)`: true se programa já terminou (início ≤ agora, fim ≤ agora) e há catch-up para o canal;
 * - `c(bean)`: se início ≤ agora e catch-up disponível → `catchupListener.a("bigEpg", bean, channelId, cb)`;
 *   senão se fim < agora → toast `not_supported_playback`;
 * - `d(focused)`: atualiza visibilidade das setas.
 *
 * Original: com/live/evo/dialog/f.java (nome real: EpgDialog, de EpgDialog.kt)
 */
class EpgDialog(
    val context: Context,
    private val channelData: ChannelData?,
    val handler: Handler,
    private val catchupListener: CatchUpClickListener,
) {
    private val logger = LoggerFactory.getLogger(EpgDialog::class.java)
    private var dialog: Dialog? = null
    private var epgAdapter: EpgDayAdapter? = null
    private var currentChannel: ChannelData? = channelData
    private var lastChannelId: String? = null
    private var lastSuccess = false
    private var isStop = false
    private var formatter: SimpleDateFormat? = null
    private lateinit var currentTime: TextView
    private var rvParent: HorizontalGridView? = null
    private var arrowLeft: ImageView? = null
    private var arrowRight: ImageView? = null
    private var loadingParent: View? = null
    private var loadAnim: ObjectAnimator? = null
    private var epgInit: TextView? = null
    private var epgDataParent: View? = null
    private var mainView: LinearLayout? = null

    /** Atualiza o relógio a cada 1 s (`yyyyMMddHHmmss`). Original: EpgDialog$c (refreshRunnable) */
    private val refreshRunnable = object : Runnable {
        override fun run() {
            if (formatter == null) formatter = DateFormatFactory.create(CommonUtils.string(R.string.yyyyMMddHHmmss))
            currentTime.text = formatter?.format(Date(ServerClock.get().now())) ?: ""
            handler.postDelayed(this, 1000L)
        }
    }

    /** Selecionou/clicou programa. Original: EpgDialog$a */
    inner class SelectListener : EpgItemListener {
        override fun onCatchUp(type: String, a: String, b: String) { /* f(): setText nos TextViews mEpgTime/mEpgProgramName/mEpgDesc + atualizar setas */ }
        override fun isCatchUpAvailable(program: ProgramBean): Boolean {
            val now = DateUtils.now()
            if (program.startTime > now || program.endTime > now) return false
            return ModelHelper.isCatchUpAvailable(program.epgId, currentChannel?.channelId, program.startTime)
        }
        override fun onProgramSelected(program: ProgramBean) {
            val now = DateUtils.now()
            if (program.startTime <= now) {
                if (ModelHelper.isCatchUpAvailable(program.epgId, currentChannel?.channelId, program.startTime)) {
                    catchupListener.onCatchUpClick("bigEpg", program, currentChannel?.channelId) { /* C0072a: callback */ }
                    if (program.endTime < now) ToastUtils.show(context, CommonUtils.string(R.string.not_supported_playback))
                }
            }
        }
        override fun onFocusChanged(focused: Boolean) { if (arrowRight != null && focused) updateArrows() }
    }

    /** Mostra/oculta setas conforme posição selecionada e itens visíveis (>=5 ou primeiro > 1). Original: E() */
    fun updateArrows() {
        // TODO("parcial: cálculo com getChildAt(0)/getChildAt(last).tag (índice+1 como String) — ver dialog/f.E")
    }

    /** Original: s(String, boolean) */ fun markLoaded(channelId: String?, success: Boolean) { lastChannelId = channelId; lastSuccess = success }
    /** Original: r(String) */ private fun isLoaded(channelId: String?) = TextUtils.equals(lastChannelId, channelId) && lastSuccess

    /** Original: u() — decide entre cache/"epg init"/buscar dados. */
    private fun loadOrShow() {
        val id = currentChannel?.epgId
        if (isLoaded(id)) { mainView?.visibility = View.VISIBLE; return }
        if (ModelHelper.isEpgNotReady()) { epgInit?.visibility = View.VISIBLE; epgDataParent?.visibility = View.INVISIBLE; return }
        epgInit?.visibility = View.INVISIBLE; epgDataParent?.visibility = View.VISIBLE
        showLoading(); mainView?.visibility = View.INVISIBLE
        if (id != null) fetchData(id)
    }

    private fun showLoading() { loadingParent?.visibility = View.VISIBLE; loadAnim?.start() }
    /** Original: y() */ fun hideLoading() { loadAnim?.cancel(); loadingParent?.visibility = View.INVISIBLE }

    /** Corrotina `EpgDialog$fetchData$1`: coleta Flow de EPG do SDK. Original: u()→b */
    private fun fetchData(epgId: String) {
        TODO("kotlinx.coroutines: MediaRepository.D(epgId).catch{log}.collect{ ModelHelper.k(...) -> withContext(Main){ adapter.setData } }")
    }

    /** Cria o diálogo, adapter e mostra. Original: z()/C()/E()/A() — ver layout `epg_dialog` (epgdlg_*) */
    fun show() { TODO("inflar R.layout.epg_dialog, ligar views epgdlg_*, new EpgDayAdapter(context, SelectListener(), rvParent), dialog.show(), loadOrShow(), handler.post(refreshRunnable)") }
    fun dismiss() { isStop = true; handler.removeCallbacks(refreshRunnable); dialog?.dismiss() }
}
