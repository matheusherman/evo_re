package com.live.evo.fragment.channel

import android.os.Handler
import android.os.Looper
import android.os.Message
import com.live.evo.AppUserManager

/**
 * Handler da thread principal do painel de canais. Mensagens:
 *
 * - [MSG_PREVIEW] (1): abre o preview (PIP) do canal selecionado — se existe e não é adulto, chama
 *   `presenter.onTagIndex("ChannelFragment", numeroDoCanal)` (`F2`);
 * - [MSG_EPG] (8194): pede a EPG do canal ([ChannelEpgPanel.requestEpg]);
 * - [MSG_CATEGORY] (8195): carrega a categoria selecionada ([ChannelCategoryController.onCategoryChanged]).
 *
 * Original: com/live/evo/fragment/x.java — classe interna `x$i` (Handler)
 */
class ChannelHandler(private val ctx: ChannelMenuContext) : Handler(Looper.getMainLooper()) {
    override fun handleMessage(msg: Message) {
        when (msg.what) {
            MSG_PREVIEW -> {
                val names = ChannelMenuData.visibleCategories
                if (names.size > ctx.state.categorySelect) {
                    val list = ChannelMenuData.channelsByCategory!![names[ctx.state.categorySelect]]
                    if (list == null || list.size <= ctx.state.programSelect) return
                    val channel = list[ctx.state.programSelect]
                    if (channel.isAdult) return
                    ChannelMenuData.presenter?.onTagIndex("ChannelFragment", channel.number)   // F2(data)
                }
            }
            MSG_EPG -> ctx.epg.requestEpg()
            MSG_CATEGORY -> ctx.categories.onCategoryChanged()
        }
    }

    /**
     * Alterna a dica no rodapé do painel (a cada 10 s): "pip_menu_tipwatch" → "tipclose" (se o PIP está ligado) ou
     * "tipopen"; marca `isSelected` para ativar a marquee.
     * Original: `x$j` (Runnable `mPipTipRunnable`)
     */
    inner class PipTipRunnable : Runnable {
        override fun run() {
            val tip = ctx.views.textPipTip
            if (tip != null) {
                if (!android.text.TextUtils.equals(tip.text.toString(), ctx.state.tipSwitch)) {
                    tip.text = ctx.state.tipSwitch
                } else if (AppUserManager.get().isPipOn()) {
                    tip.text = ctx.state.tipClosePip
                } else {
                    tip.text = ctx.state.tipOpenPip
                }
                tip.isSelected = true
            }
            ctx.handler.postDelayed(this, 10000L)
        }
    }

    /**
     * Runnable `mSetPreviewRunnable` (`x.w2`): se o canal selecionado não é adulto nem tem sub-fontes, manda o
     * presenter abrir o preview (`a(0, número)`). No original está declarado mas nunca é agendado.
     */
    fun setPreview() {
        val names = ChannelMenuData.visibleCategories
        val list = ChannelMenuData.channelsByCategory!![names[ctx.state.categorySelect]] ?: return
        if (list.size > ctx.state.programSelect) {
            val channel = list[ctx.state.programSelect]
            if (!channel.isAdult && !channel.hasSubSources) ChannelMenuData.presenter?.onTypeIndex(0, channel.number)
        }
    }

    companion object {
        const val MSG_PREVIEW = 1
        const val MSG_EPG = 8194
        const val MSG_CATEGORY = 8195
    }
}
