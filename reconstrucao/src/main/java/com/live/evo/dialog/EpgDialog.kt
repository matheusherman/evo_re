package com.live.evo.dialog

import android.animation.ObjectAnimator
import android.app.Dialog
import android.content.Context
import android.os.Handler
import android.text.TextUtils
import android.view.KeyEvent
import android.view.LayoutInflater
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
import com.live.evo.util.LoginConfig
import com.live.evo.util.TextStyleUtils
import com.live.evo.util.ToastUtils
import com.live.evo.osd.EpgChildAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

    /**
     * Seta esquerda: visível (INVISIBLE caso contrário) se a posição selecionada >= 5 ou o 1º item visível não é o dia 1; seta direita:
     * visível (GONE caso contrário) enquanto ainda há mais dias à frente (último visível < total ou faltam > 5 até ele). Usa a tag de
     * cada item (índice+1 como String). Sem filhos, esconde ambas. Original: E()
     */
    fun updateArrows() {
        val grid = rvParent
        val selected = grid?.selectedPosition ?: 0
        val childCount = grid?.childCount ?: 0
        var showLeft = false
        var showRight = false
        if (childCount > 0) {
            val first = (grid!!.getChildAt(0).tag as String).toInt()
            val last = (grid.getChildAt(childCount - 1).tag as String).toInt()
            val itemCount = epgAdapter?.itemCount ?: 0
            showLeft = selected >= 5 || first > 1
            showRight = !(last >= itemCount && last - selected <= 5)
        }
        arrowLeft?.visibility = if (showLeft) View.VISIBLE else View.INVISIBLE
        arrowRight?.visibility = if (showRight) View.VISIBLE else View.GONE
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

    /**
     * Corrotina `EpgDialog$fetchData$1`: coleta `EpgManager` do canal (Flow<List<EPGProgramme>>), converte para [ProgramBean]
     * (`ModelHelper.k(channelId, epgId, list)`) e atualiza o [EpgDayAdapter] na main thread (scroll até o dia central + seleção do
     * programa atual; painel visível). Em erro: log "get epgId data error", esconde loading, limpa o painel, adapter vazio,
     * [markLoaded](epgId, false).
     */
    private fun fetchData(epgId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            ModelHelper.epgFlowFor(epgId)
                .catch { t ->
                    logger.error("get epgId data error", t)
                    withContext(Dispatchers.Main) {
                        hideLoading()
                        selectListener?.onCatchUp("", "", "")
                        mainView?.visibility = View.VISIBLE
                        epgAdapter?.setData(null)
                        rvParent?.post { epgAdapter?.notifyDataSetChanged() }
                        markLoaded(epgId, false)
                    }
                }
                .collect { list ->
                    val beans = ModelHelper.toProgramBeans(currentChannel?.channelId, epgId, list)
                    logger.debug("fetchEpgData query success size = {}", beans.size)
                    withContext(Dispatchers.Main) {
                        hideLoading()
                        markLoaded(epgId, true)
                        epgAdapter?.setData(beans)
                        rvParent?.post {
                            epgAdapter?.notifyDataSetChanged()
                            handler.post {
                                val center = epgAdapter?.centerIndex() ?: 0
                                rvParent?.scrollToPosition(center)
                                handler.post {
                                    try {
                                        rvParent?.setSelectedPosition(center, androidx.leanback.widget.ViewHolderTask { vh ->
                                            val grid = (vh as EpgDayAdapter.DayHolder).grid
                                            val child = grid.adapter as? EpgChildAdapter
                                            val pos = child?.playingPosition() ?: 0
                                            grid.scrollToPosition(pos)
                                            grid.setSelectedPosition(pos)
                                        })
                                    } catch (e: Exception) { logger.error("EpgDialog", e) }
                                }
                            }
                        }
                        if (beans.isEmpty()) selectListener?.onCatchUp("", "", "")
                        handler.post { mainView?.visibility = View.VISIBLE }
                    }
                }
        }
    }

    private var selectListener: SelectListener? = null
    private var tvProgram: TextView? = null
    private var icon: ImageView? = null
    private var epgTime: TextView? = null
    private var epgProgramName: TextView? = null
    private var epgDesc: TextView? = null
    private var loadingView: View? = null

    init {
        // C(): infla e liga as views `epgdlg_*`
        val root = LayoutInflater.from(context).inflate(R.layout.epg_dialog, null, false)
        val id = R.id
        arrowLeft = root.findViewById(id.epgdlg_iv_epg_arrow_left)
        arrowRight = root.findViewById(id.epgdlg_iv_epg_arrow_right)
        tvProgram = root.findViewById(id.epgdlg_tv_program)
        rvParent = root.findViewById(id.epgdlg_hgv_parent)
        icon = root.findViewById(id.epgdlg_iv_icon)
        currentTime = root.findViewById(id.epgdlg_tv_curtime)
        epgTime = root.findViewById(id.epgdlg_tv_epg_time)
        epgProgramName = root.findViewById(id.epgdlg_tv_epg_channel_name)
        epgDesc = root.findViewById(id.epgdlg_tv_epg_desc)
        mainView = root.findViewById(id.epgdlg_ll_epg_main_view)
        loadingView = root.findViewById(id.epgdlg_view_loading)
        loadingParent = root.findViewById(id.epgdlg_rl_loading)
        epgInit = root.findViewById(id.epgdlg_tv_epg_init)
        epgDataParent = root.findViewById(id.epgdlg_ll_epg_data_parent)
        if (LoginConfig.get().flagA()) TextStyleUtils.c(tvProgram) else TextStyleUtils.d(tvProgram)
        TextStyleUtils.b(currentTime); TextStyleUtils.b(root.findViewById(id.epgdlg_tv_time)); TextStyleUtils.b(epgTime)
        TextStyleUtils.b(root.findViewById(id.epgdlg_tv_name)); TextStyleUtils.b(epgProgramName)
        TextStyleUtils.b(root.findViewById(id.epgdlg_tv_epg_desc2)); TextStyleUtils.b(epgDesc)
        // z(): adapter, animação de loading (rotação 360→0, 1 s, linear, infinita) e Dialog `EPGDialog` (gravity BOTTOM, MATCH_PARENT)
        selectListener = SelectListener()
        epgAdapter = EpgDayAdapter(context, selectListener, rvParent).also { rvParent?.adapter = it }
        loadAnim = ObjectAnimator.ofFloat(loadingView, "rotation", 360.0f, 0.0f).apply {
            duration = 1000L; repeatMode = ObjectAnimator.RESTART; interpolator = android.view.animation.LinearInterpolator(); repeatCount = -1
        }
        dialog = com.live.evo.widget.BaseDialog(context, R.style.EPGDialog).also { d ->
            d.setContentView(root)
            val attrs = d.window?.attributes
            attrs?.gravity = android.view.Gravity.BOTTOM
            attrs?.width = -1; attrs?.height = -1
            d.window?.decorView?.setPadding(0, 0, 0, 0)
            d.window?.attributes = attrs
            // A()/B(): MENU fecha o diálogo (t()); BACK/ESC param o relógio e a animação de loading
            d.setOnKeyListener { _, keyCode, event ->
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_MENU) { dismiss(); true }
                else {
                    if (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_ESCAPE) { stopClock(); loadAnim?.cancel() }
                    false
                }
            }
        }
    }

    private fun startClock() { isStop = false; handler.post(refreshRunnable) }       // H()
    private fun stopClock() { isStop = true; handler.removeCallbacks(refreshRunnable) }   // I()

    /** O diálogo está aberto? Original: D() */ fun isShowing(): Boolean = dialog?.isShowing == true

    /** Mostra a EPG do canal [channel]: título, ícone, relógio e carga de dados. Original: F(i5.h) */
    fun show(channel: ChannelData) {
        currentChannel = channel
        tvProgram?.text = channel.name
        icon?.let { com.live.evo.util.GlideImageLoader.load(context, channel.iconUrl, it) }
        dialog?.show()
        startClock()
        loadOrShow()
    }

    /** Fecha o diálogo (se aberto), esconde loading e para o relógio. Original: t() */
    fun dismiss() {
        if (isShowing()) dialog?.cancel()
        hideLoading()
        stopClock()
    }
}
