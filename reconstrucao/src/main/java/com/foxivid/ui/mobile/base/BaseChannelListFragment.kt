package com.foxivid.ui.mobile.base

import androidx.databinding.ViewDataBinding
import com.foxivid.baselib.config.InteractionUtils
import com.foxivid.baselib.model.meta.ChannelStreamResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.text.TextUtils
import com.foxivid.baselib.util.ServerTime
import com.foxivid.ui.mobile.R
import com.foxivid.ui.mobile.ext.StoryListData

/**
 * Base de fragments de lista de canais: guarda a coluna atual (companion) e converte uma lista de
 * [ChannelStreamResponse] em `StoryListData` (modelo `u7/StoryListData`) com "sem EPG" /
 * "sem programa" (strings `no_epg` / `no_epg_program`) e a posição em reprodução.
 *
 * Original: com/tvc/lib/mobile/ui/base/a.java (BaseChannelListFragment)
 */
abstract class BaseChannelListFragment<DB : ViewDataBinding> : BaseDataBindFragment<DB>() {

    /**
     * Converte os canais em itens de história (stories) e entrega (lista, posição em reprodução)
     * no thread principal.
     * Original: c0(String, List, p) — corrotina BaseChannelListFragment$coverStoryList$1
     */
    fun coverStoryList(
        column: String,
        channelList: List<ChannelStreamResponse>,
        result: (List<StoryListData>, Int?) -> Unit
    ) {
        CoroutineScope(Dispatchers.Default).launch {
            // strings lidas no Main (corrotinas $noEPG$1 / $noProgramme$1)
            val noEPG = withContext(Dispatchers.Main) { context?.getString(R.string.no_epg) ?: "" }
            val noProgramme = withContext(Dispatchers.Main) { context?.getString(R.string.no_epg_program) ?: "" }
            val mStoryList = ArrayList<StoryListData>()
            var playingPosition: Int? = null
            val now = ServerTime.now()   // x1.f1.lb.util.d1.d()
            for (i in channelList.indices) {
                val channel = channelList[i]
                if (channel.streamId == currentColumn) playingPosition = i   // a.f9214e.a(): id do canal em reprodução
                val epgId = channel.epgId
                val title = InteractionUtils.b(channel) + " " + channel.streamName
                val dates = InteractionUtils.C()
                if (!TextUtils.isEmpty(epgId) && dates.isNotEmpty()) {
                    val programme = InteractionUtils.G(epgId!!, now)
                    mStoryList.add(StoryListData(column, title, programme?.title ?: noProgramme, channel, i == 0))
                } else {
                    mStoryList.add(StoryListData(column, title, noEPG, channel, i == 0))
                }
            }
            withContext(Dispatchers.Main) { result(mStoryList, playingPosition)   // null se nenhum canal coincide (b0<Integer>.element) }
        }
    }

    /** Lista de canais da coluna. Original: d0(String) */
    fun getChannels(column: String): List<ChannelStreamResponse> {
        return InteractionUtils.n(column, InteractionUtils.d0(column))
    }

    companion object {
        /** Coluna atual. Original: BaseChannelListFragment.Companion.a()/b(String) */
        @JvmStatic var currentColumn: String = ""
    }
}
