package com.foxivid.ui.mobile.base

import androidx.databinding.ViewDataBinding
import com.foxivid.baselib.config.InteractionUtils
import com.foxivid.baselib.model.meta.ChannelStreamResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
        result: (List<Any /* u7.StoryListData */>, Int) -> Unit
    ) {
        CoroutineScope(Dispatchers.Default).launch {
            // O corpo da corrotina (invokeSuspend, ~531 unidades de código) não foi decompilado pelo jadx
            // (JadxOverflowException: "Regions stack size limit reached"). Do que se vê:
            //  - noEPG = context?.getString(R.string.no_epg) ?: ""   (corrotina $noEPG$1)
            //  - noProgramme = context?.getString(R.string.no_epg_program) ?: ""   ($noProgramme$1)
            //  - o resultado final é entregue no Main: result(mStoryList, playingPosition) ($1$1)
            TODO("nativo/não decompilado: BaseChannelListFragment.coverStoryList$1.invokeSuspend (JadxOverflowException)")
        }
    }

    /** Lista de canais da coluna. Original: d0(String) */
    fun getChannels(column: String): List<ChannelStreamResponse> {
        TODO("InteractionUtils (t/v/c/i/a).n(column, d0(column)) — fora deste módulo")
    }

    companion object {
        /** Coluna atual. Original: BaseChannelListFragment.Companion.a()/b(String) */
        @JvmStatic var currentColumn: String = ""
    }
}
