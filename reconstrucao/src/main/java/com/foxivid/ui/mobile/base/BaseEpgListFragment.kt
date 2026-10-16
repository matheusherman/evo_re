package com.foxivid.ui.mobile.base

import androidx.databinding.ViewDataBinding
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.model.meta.ChannelStreamResponse
import com.foxivid.baselib.model.meta.EPGProgramme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Base de fragments de EPG: converte [EPGProgramme] em `EpgData` (u7/EpgData: title, stop, category,
 * channel, desc, start, iconSrc, flag catch-up) e entrega no Main. Em modo de teste
 * (`BaseLibConfig.u()` = isRenewAutoRefresh), se a lista estiver vazia, gera 3 programas fictícios.
 *
 * Original: com/tvc/lib/mobile/ui/base/e.java (BaseEpgListFragment)
 */
abstract class BaseEpgListFragment<DB : ViewDataBinding> : BaseDataBindFragment<DB>() {

    /**
     * Original: a0(String yyyyMMdd, ChannelStreamResponse, List<EPGProgramme>, l) — corrotina
     * BaseEpgListFragment$coverEpgList$1
     */
    fun coverEpgList(
        yyyyMMdd: String,
        response: ChannelStreamResponse?,
        epgList: List<EPGProgramme>,
        result: (List<Any /* u7.EpgData */>) -> Unit
    ) {
        CoroutineScope(Dispatchers.Default).launch {
            val list = ArrayList<EpgDataRef>()
            for (p in epgList) {
                val d = EpgDataRef()
                d.title = p.title; d.stop = p.stop; d.category = p.category; d.channel = p.channel
                d.desc = p.desc; d.start = p.start; d.iconSrc = p.iconSrc
                // BaseLibConfig.h() = displayMemberSite (nome original; usado como flag de catch-up)
                d.isCatchup = if (BaseLibConfig.displayMemberSite && response != null) response.isCatchup else false
                list.add(d)
            }
            if (BaseLibConfig.isRenewAutoRefresh && list.isEmpty()) {
                // dia base (yyyyMMdd) em ms; programas fictícios das 06-07, 11-12... (offsets em ms)
                val base = com.foxivid.baselib.util.LegacyTvUtils.getInstance().parse(yyyyMMdd, "yyyyMMdd") // n.n().d(yyyyMMdd, "yyyyMMdd")
                val offsets = listOf(
                    Triple("test programme1", 21600000L, 25200000L),
                    Triple("test programme2", 39600000L, 46800000L),
                    Triple("test programme3", 61200000L, 64800000L)
                )
                for ((title, start, stop) in offsets) {
                    val d = EpgDataRef()
                    d.title = title
                    d.stop = stop + base
                    d.category = ""
                    d.channel = response?.epgId ?: ""
                    d.desc = "auto generated test programme"
                    d.start = start + base
                    d.iconSrc = ""
                    d.isCatchup = response?.isCatchup ?: false
                    list.add(d)
                }
            }
            withContext(Dispatchers.Main) { result(list) }
        }
    }
}

/** Forma de `u7/EpgData` usada acima (campos mutáveis); classe real fora deste módulo. */
class EpgDataRef {
    var title: String? = null
    var stop: Long = 0
    var category: String? = null
    var channel: String? = null
    var desc: String? = null
    var start: Long = 0
    var iconSrc: String? = null
    var isCatchup: Boolean = false
}
