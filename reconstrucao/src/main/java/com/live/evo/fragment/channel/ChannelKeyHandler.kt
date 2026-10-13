package com.live.evo.fragment.channel

import android.view.KeyEvent
import android.view.View
import com.live.evo.AppConstants
import com.live.evo.AppUserManager
import com.live.evo.R
import com.live.evo.UiFunctionConfig
import com.live.evo.util.CommonUtils
import com.live.evo.util.LoginConfig
import com.live.evo.util.SecretKeySequence
import com.live.evo.util.ToastUtils
import org.slf4j.LoggerFactory

/**
 * Tratamento das teclas do controle remoto (D-pad) nas listas do painel de canais. É o `OnKeyListener` de
 * `mCategoryListView`, `mProgramListView`, `mEpgListView`, `mLvEpgDate`, `etPassword` e `mTvNotData`.
 *
 * Regras gerais ([onKey]):
 * 1. só reage a `ACTION_DOWN`; ENTER/OK solto sobre o campo de senha é consumido se há teclado virtual;
 * 2. ESQ/DIR têm debounce de 100 ms ([CommonUtils.isFastClick]);
 * 3. MENU (82) sobre um canal (com `UiFunctionConfig.l()`): abre o PIP (`presenter.onTypeIndex(1, número)`) se o PIP
 *    está ligado e o canal não é adulto/sem sub-fontes; senão toast `pip_not_open`;
 * 4. cada lista tem seu ramo (ver `onKeyXxx` abaixo);
 * 5. depois: teclas 16/15/13/14 mantidas pressionadas (repeatCount == 5) acionam menu (`onMenu`), seleção
 *    (`onItemSelected`), "outro" (`onOther`) e o teste de velocidade ([ChannelMenuContext.fragment]`.startSpeedTest`);
 * 6. por fim a sequência secreta "5188" ([SecretKeySequence]) e as estratégias de tecla numérica.
 *
 * Original: com/live/evo/fragment/x.java — `onKey(View, int, KeyEvent)` (jadx marcou "decompiled incorrectly";
 * os ramos `adultkeyl_*` foram conferidos no decompile alternativo)
 */
class ChannelKeyHandler(private val ctx: ChannelMenuContext) : View.OnKeyListener {
    private val logger = LoggerFactory.getLogger(ChannelKeyHandler::class.java)
    private val views get() = ctx.views
    private val state get() = ctx.state
    private val animator get() = ctx.animator

    /** Estratégias de tecla numérica (nunca preenchida no original). Original: `numberStrategies`. */
    val numberStrategies: MutableList<NumberKeyStrategy> = ArrayList()

    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        // ENTER/OK solto sobre o campo de senha com teclado virtual: consome
        if (ctx.adult.keyboardView != null && event.action == KeyEvent.ACTION_UP &&
            (keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) && v.id == R.id.adultkeyl_et_pwd
        ) return true
        if (event.action != KeyEvent.ACTION_DOWN) return false
        val id = v.id
        if ((KeyEvent.KEYCODE_DPAD_LEFT == keyCode || KeyEvent.KEYCODE_DPAD_RIGHT == keyCode) && CommonUtils.isFastClick(100L)) return true

        // MENU: preview PIP
        if (UiFunctionConfig.get().l() && keyCode == KeyEvent.KEYCODE_MENU) {
            if (AppUserManager.get().isPipOn()) {
                val list = ChannelMenuData.channelsByCategory!![ChannelMenuData.visibleCategories[state.categorySelect]]
                if (list != null && list.size > state.programSelect) {
                    val channel = list[state.programSelect]
                    if (channel != null && !channel.isAdult && !channel.hasSubSources) {
                        ChannelMenuData.presenter!!.onTypeIndex(1, channel.number)
                    }
                }
            } else {
                ToastUtils.show(ctx.activity!!, R.string.pip_not_open, 1)
            }
            return true
        }

        if (id != R.id.programviewl_tv_not_data) {
            when (id) {
                R.id.adultkeyl_btn_go -> onKeyGoButton(keyCode)?.let { return it }
                R.id.adultkeyl_et_pwd -> onKeyPassword(keyCode)?.let { return it }
                R.id.programviewl_lv_epg_date -> onKeyEpgDate(keyCode)?.let { return it }
                R.id.programviewl_lv_epg_listview -> onKeyEpgList(keyCode)?.let { return it }
                R.id.programviewl_lv_main_program_listview -> onKeyChannelList(keyCode)?.let { return it }
                R.id.programviewl_lv_main_program_listview_classify -> onKeyCategoryList(keyCode)?.let { return it }
            }
        } else {
            // sem dados de EPG (TextView `programviewl_tv_not_data` focado): CIMA/BAIXO mudam o dia
            val dates = ctx.epgDateAdapter
            if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
                if ((dates?.selectedIndex() ?: 0) > 0) views.lvEpgDate?.setSelection((dates?.selectedIndex() ?: 0) - 1)
                return true
            }
            if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
                if ((dates?.selectedIndex() ?: 0) < (dates?.dayCount() ?: 0)) views.lvEpgDate?.setSelection((dates?.selectedIndex() ?: 0) + 1)
                return true
            }
        }

        // teclas mantidas (5 repetições)
        val presenter = ChannelMenuData.presenter
        if (keyCode == KeyEvent.KEYCODE_9 && event.repeatCount == 5) { presenter!!.onMenu(); return true }          // 16 -> m()
        if (keyCode == KeyEvent.KEYCODE_8 && event.repeatCount == 5) {                                               // 15 -> k(pos)
            presenter!!.onItemSelected(views.programListView?.selectedItemPosition ?: 0)
            return true
        }
        if (keyCode == KeyEvent.KEYCODE_6 && event.repeatCount == 5) { presenter!!.onOther(); return true }         // 13 -> w()
        if (keyCode == KeyEvent.KEYCODE_7 && event.repeatCount == 5) { ctx.fragment.startSpeedTest(); return true }  // 14 -> Y2()
        if (SecretKeySequence.get().onKey(null, keyCode, event)) {
            ctx.programAdapter?.notifyDataSetChanged()
            return true
        }
        if (keyCode >= KeyEvent.KEYCODE_0 && keyCode <= KeyEvent.KEYCODE_9 && SecretKeySequence.get().isActivated()) {
            for (strategy in numberStrategies) {
                if (strategy.onNumberKey(keyCode, event)) return true
            }
        }
        return false
    }

    // ------------------------------------------------------------------ painel de senha

    /** Botão "go": CIMA/DIREITA/BAIXO consumidos; ESQUERDA volta o foco às categorias (também consumido). */
    private fun onKeyGoButton(keyCode: Int): Boolean? = when (keyCode) {
        KeyEvent.KEYCODE_DPAD_LEFT -> { views.categoryListView?.requestFocus(); true }
        KeyEvent.KEYCODE_DPAD_DOWN, KeyEvent.KEYCODE_DPAD_RIGHT -> true
        else -> null
    }

    /** Campo de senha: CIMA/DIREITA consumidos; ESQ → categorias; OK/ENTER mostram o teclado virtual se oculto. */
    private fun onKeyPassword(keyCode: Int): Boolean? {
        when (keyCode) {
            KeyEvent.KEYCODE_DPAD_UP, KeyEvent.KEYCODE_DPAD_RIGHT -> return true
            KeyEvent.KEYCODE_DPAD_LEFT -> { views.categoryListView?.requestFocus(); return true }
            KeyEvent.KEYCODE_ENTER, KeyEvent.KEYCODE_DPAD_CENTER -> {
                val keyboard = ctx.adult.keyboardView
                if (keyboard != null && keyboard.visibility != View.VISIBLE) {
                    keyboard.toggle()   // m0(): mostra (ou esconde, se visível)
                    return true
                }
            }
        }
        return null
    }

    // ------------------------------------------------------------------ lista de datas da EPG

    private fun onKeyEpgDate(keyCode: Int): Boolean? {
        val dates = ctx.epgDateAdapter
        if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
            // volta para a lista de canais
            animator.cancelIfRunning(animator.epgAnimOpen)
            dates?.select(dates.todayIndex(), false)
            val index = ctx.epg.loadDay(dates?.todayIndex() ?: 0)
            if (index >= 0) views.epgListView?.setSelection(index)
            ctx.rememberFocus(views.programListView)
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            if ((ctx.epgAdapter?.count ?: 0) <= 0) {
                ctx.fragment.shakeView(views.lvEpgDate)
                return true
            }
            if (dates?.selectedIndex() != dates?.todayIndex()) {
                // dia diferente de hoje: foca a lista de programas no primeiro item
                ctx.rememberFocus(views.epgListView)
                ctx.epgAdapter?.setSelected(-1)
                ctx.epgAdapter?.setSelected(0)
                views.epgListView?.setSelection(0)
            } else {
                ctx.rememberFocus(views.epgListView)
                val now = state.nowPlayingIndex
                if (now <= 0) {
                    ctx.epgAdapter?.setSelected(-1)
                    ctx.epgAdapter?.setSelected(0)
                    views.epgListView?.setSelection(0)
                } else {
                    ctx.epgAdapter?.setSelected(now)
                    views.epgListView?.setSelection(now)
                }
            }
        }
        return null
    }

    // ------------------------------------------------------------------ lista de programas da EPG

    private fun onKeyEpgList(keyCode: Int): Boolean? {
        val dates = ctx.epgDateAdapter
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            ctx.epg.onProgramConfirmed(requireNonAdult = false)
            return null
        }
        when (keyCode) {
            KeyEvent.KEYCODE_DPAD_UP -> {
                // primeiro programa do dia: sobe para o dia anterior
                if ((views.epgListView?.selectedItemPosition ?: 0) == 0 && (dates?.selectedIndex() ?: 0) > 0) {
                    val previous = (dates?.selectedIndex() ?: 0) - 1
                    views.lvEpgDate?.setSelection(previous)
                    dates?.select(previous, false)
                    state.isKeyCodeUp = true
                }
                state.isKeyCodeDown = false
            }
            KeyEvent.KEYCODE_DPAD_DOWN -> {
                // último programa do dia: desce para o dia seguinte (se há programas lá)
                if ((views.epgListView?.selectedItemPosition ?: 0) == state.tempEpgList.size - 1) {
                    if ((dates?.selectedIndex() ?: 0) >= (dates?.dayCount() ?: 0)) return true
                    val next = (dates?.selectedIndex() ?: 0) + 1
                    if (ctx.epg.countProgramsOfDay(next) <= 0) return true
                    state.isKeyCodeDown = true
                    views.lvEpgDate?.setSelection(next)
                    dates?.select(next, false)
                }
                state.isKeyCodeUp = false
            }
            KeyEvent.KEYCODE_DPAD_LEFT -> {
                dates?.select(dates.selectedIndex(), true)
                views.lvEpgDate?.setSelection(dates?.selectedIndex() ?: 0)
                ctx.rememberFocus(views.lvEpgDate)
            }
            KeyEvent.KEYCODE_DPAD_RIGHT -> {
                ctx.fragment.shakeView(views.epgListParent)
                return true
            }
            KeyEvent.KEYCODE_DPAD_CENTER -> ctx.epg.onProgramConfirmed(requireNonAdult = true)
        }
        return null
    }

    // ------------------------------------------------------------------ lista de canais

    private fun onKeyChannelList(keyCode: Int): Boolean? {
        when (keyCode) {
            KeyEvent.KEYCODE_DPAD_UP -> {
                val size = state.channelsInCategory!!.size
                val selected = views.programListView?.selectedItemPosition ?: 0
                state.hasChangeCategory = false
                state.isChangeChannel = false
                if (selected == 0 && size > 0) {       // dá a volta: do primeiro vai ao último
                    views.programListView?.setSelection(size - 1)
                    return true
                }
            }
            KeyEvent.KEYCODE_DPAD_DOWN -> {
                val size = state.channelsInCategory!!.size
                state.hasChangeCategory = false
                state.isChangeChannel = false
                if ((views.programListView?.selectedItemPosition ?: 0) == size - 1) {   // do último vai ao primeiro
                    views.programListView?.setSelection(0)
                    return true
                }
            }
            KeyEvent.KEYCODE_DPAD_LEFT -> goToCategories()
            KeyEvent.KEYCODE_DPAD_RIGHT -> return goToEpg()
        }
        return null
    }

    /** ESQUERDA na lista de canais: volta o foco à coluna de categorias (abrindo-a se estava fechada). */
    private fun goToCategories() {
        state.postMetricFromCategory = false
        if (!AppConstants.flagA) return
        views.categoryParent?.visibility = View.VISIBLE
        if (views.categoryListView?.visibility == View.VISIBLE) {
            views.categoryListView?.requestFocus()
            ctx.rememberFocus(views.categoryListView)
            views.categoryListView?.setSelection(state.categorySelect)
            logger.debug("onkey: mCategorySelect = {}", state.categorySelect)
        }
        if (!state.isInitOpen) {
            animator.cancelIfRunning(animator.categoryAnimClose)
            if (!state.isCategoryOpen) animator.openCategories()
        }
        state.isInitOpen = false
        val epgShown = animator.isEpgColumnShown()
        if (ctx.categories.isEpgEnabled() && epgShown) {
            animator.epgAnimClose?.start()
            if (!state.isCategoryOpen) {
                if (views.categoryParent?.visibility != View.VISIBLE) views.categoryParent?.visibility = View.VISIBLE
                animator.openCategories()
            }
        }
        views.ivRightLayout?.visibility = if (!ctx.adult.isSelectedCategoryAdult()) View.VISIBLE else View.GONE
    }

    /**
     * DIREITA na lista de canais: abre a coluna de EPG (fecha a de categorias) e foca a lista de programas — ou a
     * de datas, se o dia não tem programas. Retorna `true`/`false` para consumir/não consumir a tecla.
     */
    private fun goToEpg(): Boolean? {
        if (!ctx.categories.isEpgEnabled()) {
            if (AppUserManager.get().needAdultWarning()) return true     // l.n().E()
            ctx.fragment.shakeView(views.channelParent)
            return false
        }
        if (ctx.categories.isSelectedChannelLockedOrMissing()) return true
        state.postMetricFromCategory = false
        views.ivRightLayout?.visibility = View.GONE
        animator.cancelIfRunning(animator.epgAnimClose)
        val epgVisible = views.epgParent?.visibility == View.VISIBLE
        if (state.isCategoryOpen || !epgVisible) {
            animator.epgAnimOpen?.start()
            ctx.epg.requestEpg()
        }
        if (state.isInitOpen) animator.cancelIfRunning(animator.categoryAnimOpen)
        if (state.isCategoryOpen || !epgVisible) {
            animator.categoryAnimClose?.start()
            state.isCategoryOpen = false
            state.epgShowFirst = false
        }
        state.isInitOpen = false
        val dates = ctx.epgDateAdapter
        if ((ctx.epgAdapter?.count ?: 0) <= 0) {
            // sem programas: foca a lista de datas
            views.lvEpgDate?.requestFocus()
            ctx.rememberFocus(views.lvEpgDate)
            views.lvEpgDate?.setSelection(dates?.selectedIndex() ?: 0)
            dates?.setFocusedIndex(dates.selectedIndex())
            ctx.fragment.shakeView(views.lvEpgDate)
            state.epgShowFirst = false
            return true
        }
        views.epgListView?.requestFocus()
        ctx.rememberFocus(views.epgListView)
        if (dates?.selectedIndex() != dates?.todayIndex()) {
            dates?.select(dates.selectedIndex(), false)
        } else {
            dates?.select(dates.todayIndex(), false)
            val now = state.nowPlayingIndex
            if (now > 0) {
                ctx.epgAdapter?.setSelected(now)
                views.epgListView?.setSelection(now)
            } else {
                ctx.epgAdapter?.setSelected(-1)
                ctx.epgAdapter?.setSelected(0)
                views.epgListView?.setSelection(0)
            }
        }
        return true
    }

    // ------------------------------------------------------------------ lista de categorias

    private fun onKeyCategoryList(keyCode: Int): Boolean? {
        when (keyCode) {
            KeyEvent.KEYCODE_DPAD_UP -> {
                state.hasChangeCategory = true
                if ((views.categoryListView?.selectedItemPosition ?: 0) == 0) {
                    ChannelMenuData.eventListener?.focusTabs(1)      // y1.a(1): foco na barra de abas
                    return true
                }
            }
            KeyEvent.KEYCODE_DPAD_DOWN -> {
                state.hasChangeCategory = true
                val size = ChannelMenuData.visibleCategories.size
                if ((views.categoryListView?.selectedItemPosition ?: 0) == size - 1) {
                    views.programListView?.setSelection(0)
                    return true
                }
            }
            KeyEvent.KEYCODE_DPAD_RIGHT -> {
                if (ctx.adult.needsAdultKey()) {
                    if (views.adultKeyParent?.visibility == View.VISIBLE) {
                        views.adultKeyParent.requestFocus()
                    } else {
                        state.postMetricFromCategory = true
                        views.programListView?.requestFocus()
                    }
                    return true
                }
                if (AppConstants.flagA) {
                    val list = state.channelsInCategory ?: return true
                    if (list.isNotEmpty()) {
                        state.postMetricFromCategory = true
                        val (position, offset) = ctx.categories.savedScroll(ChannelMenuData.visibleCategories[state.categorySelect])
                        val playingIdx = ctx.categories.indexOfPlayingChannel()
                        ctx.rememberFocus(views.programListView)
                        if (playingIdx >= 0 && state.hasChangeCategory) {
                            views.programListView?.setSelection(playingIdx)
                        } else if (playingIdx < 0 || !state.isChangeChannel) {
                            views.programListView?.setSelectionFromTop(position, offset)
                        } else {
                            views.programListView?.setSelection(playingIdx)
                        }
                        animator.cancelIfRunning(animator.categoryAnimOpen)
                    }
                }
            }
        }
        return null
    }

    /** Mantém a referência (evita aviso de import não usado quando a flag de fonte não é lida aqui). */
    @Suppress("unused") private fun usesAlternateFont() = LoginConfig.get().flagA()
}
