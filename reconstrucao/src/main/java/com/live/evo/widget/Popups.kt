package com.live.evo.widget

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.ProgressBar
import android.widget.TextView
import androidx.leanback.widget.BaseGridView
import androidx.leanback.widget.VerticalGridView
import androidx.recyclerview.widget.RecyclerView
import com.live.evo.R
import com.live.evo.model.ChannelData
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
        // findViewById de currentepgl_* (iv_icon, tv_channel_pos, tv_channel_name, mtv_current_epg_name, ...) omitido por brevidade
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
                // corrotina: EpgBeanDaoUtils.getTwoEpg(epgId).collect { lista -> handler.post { render(lista) } }
                // render: programa em curso = primeiro com start < agora (progress = (agora-start)*100/(fim-início));
                //         próximo = o seguinte; vazios -> R.string.epg_none
                TODO("coletar Flow e renderizar (ver widget/q.b.C0119b.d)")
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
        // TODO("parcial: offsets conforme layout manager — ver widget/v.java")
        outRect.set(space, space, space, space)
    }
}

/** Base dos diálogos do app (estilo `RechargeAlertialog`): Dialog sem comportamento extra. Original: com/live/evo/widget/o.java */
open class BaseDialog(context: Context, theme: Int) : android.app.Dialog(context, theme)
