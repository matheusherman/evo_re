package com.live.evo.fragment.channel

import android.content.Context
import android.text.AbsoluteSizeSpan
import android.text.SpannableString
import android.text.SpannedString
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.foxivid.ui.keyboard.KeyUtils
import com.foxivid.ui.keyboard.KeyboardContainer
import com.live.evo.AppUserManager
import com.live.evo.R
import com.live.evo.util.CommonUtils
import com.live.evo.util.ToastUtils
import com.live.evo.widget.ProgramListView
import com.foxivid.baselib.config.InteractionUtils
import org.slf4j.LoggerFactory
import java.util.Locale

/**
 * Bloqueio de categorias adultas ("private_group"/colunas com `isAdultColumn == 1`) por PIN de 4 dígitos.
 *
 * Fluxo (painel `programviewl_rl_adult` no lugar da lista de canais):
 * 1. Ao entrar numa categoria adulta que não é a que está tocando, [needsAdultKey] é true e a tela de senha aparece
 *    ([showLockScreen]); o texto muda se ainda não há PIN (cadastro: `adult_key_first_hint`) ou se já há (confirmação).
 * 2. O botão `adultkeyl_btn_go` chama [submitPassword]:
 *    - menos de 4 dígitos → toast `adult_key_not_map`;
 *    - sem PIN salvo: "2026" é rejeitado (`adult_key_invalid`); outro valor é salvo (`adult_key_saved`) e desbloqueia;
 *    - com PIN salvo: se bate com o PIN, desbloqueia; se for "2026" (código de reset) apaga o PIN
 *      (`adult_key_reset_hint`) e volta ao cadastro; senão `adult_key_not_map`.
 * 3. [onUnlocked] mostra a lista de canais e foca nela.
 * Há um teclado virtual de TV ([KeyboardContainer]) associado ao campo de senha ([initKeyboard]).
 *
 * Original: com/live/evo/fragment/x.java — `N1/O1/P1`, `R1`, `x2`, `y2`, `N2`, `b2`, `c2`, `d2`, `Z1`, `q2`
 */
class ChannelAdultLock(private val ctx: ChannelMenuContext) {
    private val logger = LoggerFactory.getLogger(ChannelAdultLock::class.java)
    private val views get() = ctx.views
    private val state get() = ctx.state

    /** Teclado virtual (`keyboardView`). */
    var keyboardView: KeyboardContainer? = null
        private set
    private var inputMethodManager: InputMethodManager? = null   // mIm

    /** A categoria selecionada é marcada como adulta? Original: `P1()` (`ModelHelper.t()[nome].g() == 1`). */
    fun isSelectedCategoryAdult(): Boolean {
        val names = ChannelMenuData.visibleCategories
        val name = if (state.categorySelect < names.size) names[state.categorySelect] else names[0]
        val info = ChannelMenuData.categoryInfo ?: ChannelSdkBridge.categoryInfo()
        return info[name]?.isAdultColumn == 1
    }

    /** A categoria do canal que está tocando é adulta? Original: `O1()`. */
    fun isPlayingCategoryAdult(): Boolean {
        val names = ChannelMenuData.visibleCategories
        if (state.playCategory >= names.size) return false
        val name = names[state.playCategory]
        val info = ChannelMenuData.categoryInfo ?: ChannelSdkBridge.categoryInfo()
        val isAdult = info[name]?.isAdultColumn == 1
        logger.debug("checkPlayingIsInAdultCategory:{},{},{}", state.playCategory, name, isAdult)
        return isAdult
    }

    /** Precisa pedir o PIN? (categoria adulta selecionada e não é a que está tocando). Original: `N1()`. */
    fun needsAdultKey(): Boolean = isSelectedCategoryAdult() && !isPlayingCategoryAdult()

    /** Liga o botão "go" ao envio da senha. Original: `b2()` + `c2(View)`. */
    fun bindGoButton() {
        views.goAhead?.setOnClickListener { submitPassword() }
    }

    /** Preenche os campos do painel de senha com as fontes corretas e o texto inicial. Original: `d2(View)`. */
    fun bind(activityContext: Context?) {
        inputMethodManager = activityContext?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        views.applyAdultFonts(com.live.evo.util.LoginConfig.get().flagA())
        showLockScreen()
    }

    /**
     * Título e dicas da tela de senha. Se já existe PIN (`AppUserManager.y()`) pede confirmação; senão pede o cadastro.
     * O título vai em caixa alta se a propriedade remota `category_is_upcase` (padrão true) estiver ligada.
     * Original: `x2()`
     */
    fun showLockScreen() {
        if (views.adultTitle == null) return
        val upcase = AppUserManager.get().getBoolean("category_is_upcase", true)
        var title = CommonUtils.string(R.string.adult_key_title)
        if (upcase) title = title.uppercase(Locale.getDefault())
        views.adultTitle.text = title
        if (InteractionUtils.flagQ0()) {   // AppUserManager.y(): já há PIN
            setHint(views.etPassword, CommonUtils.string(R.string.adult_key_pwd_hint2), 18)
            views.adultHint?.text = CommonUtils.string(R.string.adult_key_again_hint)
        } else {
            setHint(views.etPassword, CommonUtils.string(R.string.adult_key_pwd_hint), 18)
            views.adultHint?.setText(R.string.adult_key_first_hint)
        }
        views.etPassword?.setText("")
    }

    /** Define o hint do EditText com um tamanho de fonte (px/dp) específico. Original: `N2(EditText, String, int)` */
    private fun setHint(editText: EditText?, hint: String, textSize: Int) {
        val spannable = SpannableString(hint)
        spannable.setSpan(AbsoluteSizeSpan(textSize, true), 0, spannable.length, 33)
        editText?.hint = SpannedString(spannable)
    }

    /** Valida o PIN digitado. Original: `R1()` */
    fun submitPassword() {
        val text = views.etPassword?.text ?: return
        val activity = ctx.activity
        val user = AppUserManager.get()
        if (text.length < state.pinLength) {
            activity?.let { ToastUtils.show(it, R.string.adult_key_not_map, 0) }
            views.etPassword?.requestFocus()
            return
        }
        if (!ChannelSdkBridge.hasAdultPin()) {
            // primeiro uso: cadastra o PIN
            if (!TextUtils.equals(text, RESET_CODE)) {
                activity?.let { ToastUtils.show(it, CommonUtils.string(R.string.adult_key_saved, text.toString())) }
                user.setAdultKey(text.toString())     // l.O(String)
                user.setAdultAuth(true)               // l.N(boolean)
                views.etPassword?.setText("")
                onUnlocked()
                return
            }
            activity?.let { ToastUtils.show(it, R.string.adult_key_invalid, 0) }
            user.setAdultAuth(false)
            views.etPassword?.setText("")
            views.etPassword?.requestFocus()
            return
        }
        // já existe PIN
        if (ChannelSdkBridge.isAdultPinValid(text.toString())) {
            user.setAdultAuth(true)
            views.etPassword?.setText("")
            onUnlocked()
            return
        }
        if (TextUtils.equals(text, RESET_CODE)) {
            activity?.let { ToastUtils.show(it, R.string.adult_key_reset_hint, 0) }
            user.setAdultKey("")
            user.setAdultAuth(false)
            views.etPassword?.setText("")
            showLockScreen()
            return
        }
        activity?.let { ToastUtils.show(it, R.string.adult_key_not_map, 0) }
        user.setAdultAuth(false)
        views.etPassword?.setText("")
        views.etPassword?.requestFocus()
    }

    /**
     * PIN aceito: esconde o painel de senha, mostra a lista de canais e restaura a posição salva da categoria
     * (`mHistoryMap`: "posição,offsetY"). Original: `y2()`
     */
    fun onUnlocked() {
        views.programListView?.requestFocus()
        if (views.adultKeyParent?.visibility == View.VISIBLE) views.adultKeyParent.visibility = View.GONE
        if (views.channelParent?.visibility != View.VISIBLE) views.channelParent?.visibility = View.VISIBLE
        val list = state.channelsInCategory
        if (list != null && list.isNotEmpty()) {
            views.programListView?.visibility = View.VISIBLE
            logger.debug("onItemSelected: position={}  mclassifySelect={}", state.categorySelect, state.categorySelect)
            val name = ChannelMenuData.visibleCategories[state.categorySelect]
            val saved = state.scrollHistory!![name]
            val parts = saved!!.split(",").dropLastWhile { it.isEmpty() }
            val position = parts[0].toInt()
            val playingIdx = ctx.categories.indexOfPlayingChannel()
            if (playingIdx < 0 || !(state.hasChangeCategory || state.isChangeChannel)) {
                views.programListView?.setSelectionFromTop(position, parts[1].toInt())
            } else {
                views.programListView?.setSelection(playingIdx)
                state.scrollHistory!![name] = "$playingIdx,0"
            }
            val current = state.scrollHistory!![name]!!
            val head = current.substring(0, current.indexOf(','))
            val currentPos = (if (TextUtils.isEmpty(head)) "0" else head).toInt() + 1
            views.textCurrentPos?.text = currentPos.toString()
            views.programListView?.requestFocus()
            return
        }
        views.programListView?.visibility = View.GONE
        views.textCurrentPos?.text = "0"
    }

    /** Esconde o teclado virtual do sistema (IME) da caixa de senha. Original: `Z1()` */
    fun hideSoftInput() {
        if (views.etPassword == null || ctx.context == null) return
        inputMethodManager?.hideSoftInputFromWindow(views.etPassword.windowToken, 0)
    }

    /**
     * (Re)cria o teclado virtual de TV ligado ao campo de senha. Original: `q2()`
     * (`KeyUtils.u(window, context, view, lifecycle, false, false)` + `l(etPassword)`).
     */
    fun initKeyboard() {
        try {
            val context = ctx.context ?: return
            keyboardView?.clearEditTexts()
            val keyboard = KeyUtils.create(ChannelMenuData.window, context, views.root, ctx.fragment.lifecycle, false, false)
            keyboardView = keyboard
            if (keyboard != null && views.etPassword != null) keyboard.addEditText(views.etPassword)
        } catch (e: Exception) {
            logger.error("channel initKeyBoard error", e)
        }
    }

    /** Foco: ESQ sai do campo de senha para a lista de categorias. */
    fun focusCategories() {
        (views.categoryListView as ProgramListView?)?.requestFocus()
    }

    companion object {
        /** Código de reset do PIN adulto (hard-coded no original). */
        const val RESET_CODE = "2026"
    }
}
