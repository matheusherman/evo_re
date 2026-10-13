package com.live.evo.fragment.channel

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.foxivid.baselib.model.meta.EPGProgramme
import com.live.evo.R
import com.live.evo.model.ChannelData
import com.live.evo.util.GlideImageLoader
import com.live.evo.util.LoginConfig
import com.live.evo.util.ServerClock
import com.live.evo.util.TextStyleUtils
import com.live.evo.widget.GifView
import org.slf4j.LoggerFactory
import java.io.File

/**
 * Adapter da lista de canais da categoria (coluna 2 do menu; item `program_list_item`): número do canal
 * ("001"), nome, ícone, selo de favorito, ícone de catch-up (`iv_play_back`), GIF "tocando agora"
 * (`channel_play`) e, se `LoginConfig.flagF`, o título do programa atual (mini-EPG).
 *
 * Original: n5/o.java (referenciado no ChannelFragment como `mProgramAdapter`)
 */
class ChannelListAdapter(private val context: Context, initial: List<ChannelData>?) : BaseAdapter() {
    private val logger = LoggerFactory.getLogger(ChannelListAdapter::class.java)
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    /** Lista original recebida no construtor (`f16035b`) e a lista exibida (`f16040g`). */
    private val source: List<ChannelData>? = initial
    private val items: MutableList<ChannelData> = ArrayList()

    /** Índice global (`ChannelData.number`) do canal tocando. Original: `f16038e`. */
    private var playingIndex = 0
    /** Cópia do índice tocando guardada por [setItems] (`f16039f`, sem uso). */
    private var initialPlayingIndex = 0
    private var animator: ObjectAnimator? = null   // f16041h (nunca atribuído)

    init {
        if (!initial.isNullOrEmpty()) items.addAll(initial)
    }

    private class Holder(view: View) {
        val channelId: TextView = view.findViewById(R.id.programlistitem_tv_channel_id)
        val favorite: ImageView = view.findViewById(R.id.programlistitem_iv_fav)
        val playImage: ImageView? = view.findViewById(R.id.programlistitem_iv_play_image)
        val icon: ImageView = view.findViewById(R.id.programlistitem_iv_icons)
        val adminText: TextView = view.findViewById(R.id.programlistitem_tv_admin_text)
        val itemName: TextView = view.findViewById(R.id.programlistitem_tv_item_name)
        val smallEpg: TextView = view.findViewById(R.id.programlistitem_mtv_smallepg)
        val playBack: ImageView = view.findViewById(R.id.programlistitem_iv_play_back)
        val newImg: ImageView = view.findViewById(R.id.programlistitem_iv_newimg)
        val playGif: GifView = view.findViewById(R.id.programlistitem_iv_play)

        init {
            if (LoginConfig.get().flagA()) {
                TextStyleUtils.b(channelId); TextStyleUtils.b(itemName); TextStyleUtils.b(adminText); TextStyleUtils.b(smallEpg)
            } else {
                TextStyleUtils.c(channelId); TextStyleUtils.a(itemName); TextStyleUtils.a(adminText); TextStyleUtils.b(smallEpg)
            }
        }
    }

    override fun getItemId(position: Int): Long = position.toLong()
    override fun getItem(position: Int): Any = items[position]
    override fun getCount(): Int = items.size

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: Holder
        if (convertView == null) {
            view = inflater.inflate(R.layout.program_list_item, null)
            view.isEnabled = false
            holder = Holder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as Holder
        }
        val channel = items[position]

        // selo de favorito: usa a imagem da skin, se existir; muda o tamanho do número
        if (ChannelSdkBridge.isFavorite(channel.channelId!!.toInt())) {
            val path = ChannelModelShims.favoriteImagePath()
            if (!path.isNullOrEmpty() && File(path).exists()) {
                holder.favorite.background = Drawable.createFromPath(path)
            }
            holder.channelId.setTextSize(TypedValue.COMPLEX_UNIT_SP, context.resources.getDimension(R.dimen.channelid_favorite_size))
            holder.favorite.visibility = View.VISIBLE
        } else {
            holder.channelId.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14.0f)
            holder.favorite.visibility = View.GONE
        }

        // número com zeros à esquerda: 1 -> "001", 12 -> "012"
        var number = (channel.number + 1).toString()
        if (number.length <= 1) number = "00$number" else if (number.length <= 2) number = "0$number"
        holder.channelId.text = number
        holder.itemName.text = channel.name
        if (holder.adminText.visibility == View.VISIBLE) holder.adminText.visibility = View.GONE

        val hasCatchUp = ChannelSdkBridge.isCatchUpAvailable(channel.epgId, channel.channelId, null)
        val index = channel.number
        holder.playBack.visibility = if (hasCatchUp) View.VISIBLE else View.INVISIBLE
        GlideImageLoader.load(context, channel.iconUrl, R.color.transparent, holder.icon)

        if (playingIndex == index) {
            holder.playGif.visibility = View.VISIBLE
            holder.playGif.setMovieResource(R.drawable.channel_play)
        } else {
            holder.playGif.visibility = View.GONE
        }
        // `h.m()` é sempre null no original; o selo "novo" nunca aparece
        holder.newImg.visibility = View.GONE

        if (LoginConfig.get().flagF()) {
            try {
                ChannelModelShims.getChannelProgramName(channel.epgId, ServerClock.get().now()) { programme ->
                    showSmallEpg(holder, programme)
                }
                return view
            } catch (e: Exception) {
                holder.smallEpg.text = ""
                holder.smallEpg.visibility = View.GONE
            }
        }
        return view
    }

    /** Preenche (ou esconde) o título do programa no ar. Original: `o.a(a, EPGProgramme)` */
    private fun showSmallEpg(holder: Holder, programme: EPGProgramme?) {
        val title = programme?.title
        if (programme == null || TextUtils.isEmpty(title)) {
            holder.smallEpg.text = ""
            holder.smallEpg.visibility = View.GONE
            return
        }
        holder.smallEpg.text = title
        holder.smallEpg.visibility = View.VISIBLE
    }

    /** Cancela a animação (se houver). Original: b() */
    fun cancelAnimation() {
        animator?.cancel()
        animator = null
    }

    /** Troca a lista exibida e o índice do canal tocando. Original: c(List, int) */
    fun setItems(list: List<ChannelData>?, playingIndex: Int) {
        this.playingIndex = playingIndex
        initialPlayingIndex = playingIndex
        items.clear()
        if (!list.isNullOrEmpty()) items.addAll(list)
        notifyDataSetChanged()
    }

    /** Atualiza só o índice do canal tocando. Original: d(int) */
    fun setPlayingIndex(index: Int) {
        playingIndex = index
        notifyDataSetChanged()
    }

    /**
     * Marca/desmarca o item [view] como "sem foco" (`parent.isEnabled = !unfocused`) — controla o estado visual
     * do item selecionado quando o foco sai da coluna. Original: e(View, boolean)
     */
    fun setItemUnfocused(view: View?, unfocused: Boolean) {
        if (view == null) return
        try {
            val holder = view.tag as? Holder
            if (holder != null) (holder.channelId.parent as View).isEnabled = !unfocused
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
