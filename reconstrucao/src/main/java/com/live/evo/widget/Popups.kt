package com.live.evo.widget

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.graphics.Color
import android.graphics.drawable.ClipDrawable
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.ProgressBar
import android.widget.TextView
import androidx.leanback.widget.BaseGridView
import androidx.leanback.widget.VerticalGridView
import androidx.recyclerview.widget.RecyclerView
import com.live.evo.R
import com.live.evo.model.ChannelData
import com.live.evo.model.ProgramBean
import com.live.evo.util.EpgBeanDaoUtils
import com.live.evo.util.SkinConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import com.live.evo.util.CommonUtils
import com.live.evo.util.DateUtils
import com.live.evo.util.GlideImageLoader
import com.live.evo.util.ScreenUtils
import com.live.evo.util.ServerClock
import com.live.evo.util.TextStyleUtils
import com.live.evo.util.WorkHandler
import org.slf4j.LoggerFactory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone

/**
 * Banner inferior "canal atual" (layout `current_epg_layout`): número do canal (3 dígitos, ex. "007"),
 * nome, ícone, programa atual com barra de progresso (início/fim HH:mm) e próximo programa,
 * hora do servidor atualizada a cada 1 s e dicas de teclas (OK/←/→/DEL/MENU).
 * `satData` (= [show]) busca EPG via [com.live.evo.util.EpgBeanDaoUtils.getTwoEpg]; só repete a consulta se o
 * canal mudou ou passaram >= 2 s. Cor da barra vem de SkinConfig `epg_current_progress_color`.
 *
 * Original: com/live/evo/widget/q.java (nome real, do metadata: PopupCurrentEpgWindow)
 */
class PopupCurrentEpgWindow(private val context: Context, private val handler: Handler) : PopupWindow(context) {
    private val logger = LoggerFactory.getLogger(PopupCurrentEpgWindow::class.java)
    private val inflater = LayoutInflater.from(context)
    private var formatter: SimpleDateFormat? = null
    private var currentEpgId: String? = null
    private var lastChannelId: String = ""
    private var lastTime = 0L
    private var isStop = false
    private lateinit var root: View
    private lateinit var tvPos: TextView; private lateinit var tvName: TextView
    private lateinit var tvCurrentName: TextView; private lateinit var tvNextName: TextView
    private lateinit var tvStart: TextView; private lateinit var tvStop: TextView
    private lateinit var tvTime: TextView; private lateinit var progress: ProgressBar
    private lateinit var icon: ImageView
    private lateinit var tvCurrentTitle: TextView; private lateinit var imgPlayBack: ImageView
    private lateinit var tvNextTitle: TextView; private lateinit var layoutKey: LinearLayout
    private lateinit var tvEpgOk: TextView; private lateinit var tvEpgLeft: TextView; private lateinit var tvEpgRight: TextView
    private lateinit var tvEpgDel: TextView; private lateinit var tvEpgMenu: TextView; private lateinit var tvSession: TextView

    /** Atualiza o relógio a cada 1 s (formato `yyyyMMddHHmmss` do recurso, fuso default). Original: a (Runnable) */
    private val refreshRunnable = object : Runnable {
        override fun run() {
            try {
                if (formatter == null) formatter = SimpleDateFormat(CommonUtils.string(R.string.yyyyMMddHHmmss)).apply { timeZone = TimeZone.getDefault() }
                tvTime.text = formatter!!.format(Date(ServerClock.get().now()))
            } catch (e: Exception) { logger.error(e.message, e) }
            finally { if (!isStop) handler.postDelayed(this, 1000L) }
        }
    }

    init {
        root = inflater.inflate(R.layout.current_epg_layout, null)
        contentView = root
        isFocusable = false
        setBackgroundDrawable(CommonUtils.drawable(R.drawable.bg_popup_menu))
        isOutsideTouchable = false
        width = -1; height = -2
        icon = root.findViewById(R.id.currentepgl_iv_icon)
        tvPos = root.findViewById(R.id.currentepgl_tv_channel_pos)
        tvName = root.findViewById(R.id.currentepgl_tv_channel_name)
        tvCurrentTitle = root.findViewById(R.id.currentepgl_tv_current_epg_title)
        tvCurrentName = root.findViewById(R.id.currentepgl_mtv_current_epg_name)
        imgPlayBack = root.findViewById(R.id.currentepgl_playback)
        tvTime = root.findViewById(R.id.currentepgl_tv_current_time)
        tvStart = root.findViewById(R.id.currentepgl_tv_current_epg_start)
        progress = root.findViewById(R.id.currentepgl_pb_progress)
        tvStop = root.findViewById(R.id.currentepgl_tv_current_epg_stop)
        tvNextTitle = root.findViewById(R.id.currentepgl_tv_next_epg_title)
        tvNextName = root.findViewById(R.id.currentepgl_mtv_next_epg_name)
        layoutKey = root.findViewById(R.id.currentepgl_layout_keyimag)
        tvEpgOk = root.findViewById(R.id.currentepgl_tv_epg_ok)
        tvEpgLeft = root.findViewById(R.id.currentepgl_tv_epg_left)
        tvEpgRight = root.findViewById(R.id.currentepgl_tv_epg_right)
        tvEpgDel = root.findViewById(R.id.currentepgl_tv_epg_del)
        tvEpgMenu = root.findViewById(R.id.currentepgl_tv_epg_menu)
        tvSession = root.findViewById(R.id.currentepgl_tv_sessionid)
        // Cor da barra de progresso: SkinConfig `epg_current_progress_color` (#RRGGBB / #AARRGGBB, vírgulas removidas)
        val skinColor = SkinConfig.get().epgCurrentProgressColor()
        if (!TextUtils.isEmpty(skinColor)) {
            val hex = skinColor!!.replace(",", "")
            if (Pattern.matches("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})$", hex)) {
                progress.progressDrawable = ClipDrawable(ColorDrawable(Color.parseColor(hex)), 19, 1)
                progress.setBackgroundColor(context.resources.getColor(R.color.progressbar_play_background))
            }
        }
        // fontes: typeface2 (TextStyleUtils.b) nos textos/horas, typeface3 (TextStyleUtils.c) no nome do canal e dicas de tecla
        listOf(tvTime, tvStart, tvStop, tvCurrentTitle, tvCurrentName, tvNextTitle, tvNextName, tvSession, tvPos).forEach { TextStyleUtils.b(it) }
        listOf(tvName, tvEpgOk, tvEpgLeft, tvEpgRight, tvEpgDel, tvEpgMenu).forEach { TextStyleUtils.c(it) }
    }

    /** Limpa os campos de programa. Original: r() */
    fun clearPrograms() { tvCurrentName.text = ""; tvNextName.text = ""; tvStart.text = ""; tvStop.text = ""; progress.progress = 0 }

    /** Ativa marquee. Original: q() */
    fun enableMarquee() { tvCurrentName.isSelected = true; tvNextName.isSelected = true }

    /**
     * Preenche o banner com o canal. Original: s(i5.h dataBean, int inputCode)
     * Número exibido = índice+1 com zero-padding (001, 010...). Sem canal: "no_program".
     */
    fun show(data: ChannelData?, inputCode: Int) {
        val n = if (data != null) data.number + 1 else inputCode + 1
        val pos = if (n < 10) "00$n" else if (n < 100) "0$n" else n.toString()
        tvPos.text = pos
        tvName.text = data?.name ?: CommonUtils.string(R.string.no_program)
        GlideImageLoader.load(context, data?.iconUrl ?: "", 2131102158, icon)
        val epgId = data?.epgId ?: ""
        if (lastChannelId != epgId || ServerClock.get().now() - lastTime >= 2000) {
            currentEpgId = epgId
            if (data == null) {
                clearPrograms()
                tvCurrentName.setText(R.string.epg_none); tvNextName.setText(R.string.epg_none)
            } else {
                // Original: corrotina `satData$1` (Dispatchers.Default): getTwoEpg(epgId).catch{log}.collect { handler.post { render } }
                val finalEpgId = epgId
                CoroutineScope(Dispatchers.Default).launch {
                    EpgBeanDaoUtils.getTwoEpg(finalEpgId)
                        .catch { logger.error("PopupCurrentEpgWindow", it) }
                        .collect { list -> handler.post { render(list, finalEpgId) } }
                }
            }
            if (data != null) imgPlayBack.visibility = View.GONE      // Original: v(dataBean)
        }
    }

    /**
     * Preenche programa atual (primeiro com início < agora; barra de progresso em %) e o próximo. Lista vazia ou canal já trocado
     * => "sem EPG" nos dois. Original: q$b$b.d(q, list, epgId)
     */
    private fun render(list: List<ProgramBean>, epgId: String) {
        clearPrograms()
        if (list.isEmpty() || !TextUtils.equals(epgId, currentEpgId)) {
            tvCurrentName.text = CommonUtils.string(R.string.epg_none)
            tvNextName.text = CommonUtils.string(R.string.epg_none)
            return
        }
        lastChannelId = currentEpgId ?: ""
        lastTime = ServerClock.get().now()
        val now = ServerClock.get().now()
        var currentDone = false
        var nextDone = false
        for (program in list) {
            val start = program.f()
            if (start < now && !currentDone) {
                val stop = program.g()
                val startText = DateUtils.format(start, CommonUtils.string(R.string.HHmm))
                val stopText = DateUtils.format(stop, CommonUtils.string(R.string.HHmm))
                var title = program.e()
                if (TextUtils.isEmpty(title)) title = CommonUtils.string(R.string.epg_none)
                tvCurrentName.text = title
                tvStart.text = startText
                tvStop.text = stopText
                val total = stop - start
                progress.progress = if (total <= 0) 0 else (((ServerClock.get().now() - start) * 100) / total).toInt()
                currentDone = true
            } else if (!nextDone) {
                var title = program.e()
                if (TextUtils.isEmpty(title)) title = CommonUtils.string(R.string.epg_none)
                tvNextName.text = title
                nextDone = true
            }
        }
    }

    override fun dismiss() { isStop = true; handler.removeCallbacks(refreshRunnable); super.dismiss() }
    override fun showAtLocation(parent: View?, gravity: Int, x: Int, y: Int) {
        super.showAtLocation(parent, gravity, x, y)
        isStop = false
        handler.post(refreshRunnable)
    }
}
typealias CurrentEpgPopup = PopupCurrentEpgWindow

/**
 * Menu lateral direito (tecla MENU) com `VerticalGridView`: item "E P G" (broadcast `com.bb.action.EPG`) e item
 * de versão/atualização (broadcast `com.bb.action.update`, debounce 1 s). Largura 270 dp, altura total,
 * fecha ao pressionar MENU (keycode 82).
 * Original: com/live/evo/widget/s.java
 */
class PopupMenuC(private val context: Context) : PopupWindow(context) {
    private val grid: VerticalGridView
    private var mode = 0

    init {
        val v = LayoutInflater.from(context).inflate(R.layout.popup_menu_c, null)
        contentView = v
        isFocusable = true
        setBackgroundDrawable(context.resources.getDrawable(R.drawable.bg_popup_menu))
        isOutsideTouchable = false
        height = -1
        width = ScreenUtils.dp(270)
        isClippingEnabled = false
        animationStyle = R.style.AnimationFade
        grid = v.findViewById(R.id.menu_view)
        grid.setOnKeyInterceptListener(BaseGridView.OnKeyInterceptListener { e ->
            if (e.keyCode == KeyEvent.KEYCODE_MENU && e.action == KeyEvent.ACTION_DOWN) { dismiss(); true } else false
        })
        populate(0, true, false)
    }

    /** Monta os itens: EPG (se !hideEpg) + versão. Original: c(int,boolean,boolean) / e(...) */
    fun populate(mode: Int, unused: Boolean, hideEpg: Boolean) {
        grid.removeAllViews()
        this.mode = mode
        val items = ArrayList<MenuItem>()
        if (!hideEpg) items += MenuItem(R.drawable.epg_icon, "E P G") { context.sendBroadcast(Intent("com.bb.action.EPG")) }
        items += MenuItem(R.drawable.update_icon, context.getString(R.string.version) + "" + "<app version>") {
            if (!CommonUtils.isFastClick(1000L)) context.sendBroadcast(Intent("com.bb.action.update"))
        }
        grid.adapter = PopupMenuAdapter(context, items, false)
    }
}

/** Item de menu (ícone, texto, ação). Original: i5/y.java */
class MenuItem(val icon: Int, val text: String, val onClick: Runnable?) {
    constructor(icon: Int, text: String, action: () -> Unit) : this(icon, text, Runnable { action() })
}

/**
 * Adapter dos itens de menu (`popup_menu_item2` ou `popup_menu_item_pip` se [pip]): ícone (oculto se -1) + nome.
 * Original: com/live/evo/widget/p.java
 */
class PopupMenuAdapter(private val context: Context, private val items: List<MenuItem>, private val pip: Boolean) :
    RecyclerView.Adapter<PopupMenuAdapter.Holder>() {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.menu_icon)
        val name: TextView = view.findViewById(R.id.menu_name)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(
        LayoutInflater.from(context).inflate(if (pip) R.layout.popup_menu_item_pip else R.layout.popup_menu_item2, parent, false))
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]
        if (item.icon == -1) holder.icon.visibility = View.GONE else { holder.icon.visibility = View.VISIBLE; holder.icon.setImageResource(item.icon) }
        holder.name.text = item.text
        holder.itemView.setOnClickListener { item.onClick?.run() }
    }
    override fun getItemCount() = items.size
}

/**
 * Popup "trial" (layout `popup_trial`, 150x150 dp, fundo transparente `icon_transport`, animação fade),
 * mostrado no canto superior esquerdo durante o período de teste.
 * Original: com/live/evo/widget/u.java
 */
class TrialPopup(context: Context) : PopupWindow(context) {
    init {
        contentView = LayoutInflater.from(context).inflate(R.layout.popup_trial, null)
        isFocusable = false
        setBackgroundDrawable(CommonUtils.drawable(R.drawable.icon_transport))
        isOutsideTouchable = true
        height = ScreenUtils.dp(150); width = ScreenUtils.dp(150)
        animationStyle = R.style.AnimationFade
    }
}

/** ItemDecoration com espaçamento fixo. Original: com/live/evo/widget/v.java */
class SpaceItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: android.graphics.Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.bottom = space
        if (parent.getChildPosition(view) != 0) outRect.top = space   // Original: v.getItemOffsets
    }
}

/** Base dos diálogos do app (estilo `RechargeAlertialog`): Dialog sem comportamento extra. Original: com/live/evo/widget/o.java */
open class BaseDialog(context: Context, theme: Int) : android.app.Dialog(context, theme)
