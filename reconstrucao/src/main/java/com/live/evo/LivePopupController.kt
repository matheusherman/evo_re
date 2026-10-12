package com.live.evo

import android.app.Activity
import android.os.Handler
import android.view.Gravity
import android.widget.PopupWindow
import com.live.evo.catchup.CatchUpClickListener
import com.live.evo.dialog.EpgDialog
import com.live.evo.dialog.ExitDialog
import com.live.evo.dialog.OnDialogActionListener
import com.live.evo.model.ChannelBean
import com.live.evo.util.BrowserUtils
import com.live.evo.widget.CurrentEpgPopup
import com.live.evo.widget.PopupMenuC
import com.live.evo.widget.TrialPopup
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit

/**
 * Controla os popups sobrepostos ao player em [com.live.evo.activity.LiveNewActivity]:
 * - [CurrentEpgPopup] (banner inferior com canal/programa atual, auto-fecha em 10 s);
 * - [PopupMenuC] (menu lateral direito aberto pela tecla MENU, auto-fecha em 1 min);
 * - [EpgDialog] (EPG do canal); [ExitDialog]; [TrialPopup] (canto superior esquerdo).
 *
 * Original: com/live/evo/g.java
 */
class LivePopupController private constructor(
    private val activity: Activity,
    private val handler: Handler,
    catchUpListener: CatchUpClickListener,
) {
    private val logger = LoggerFactory.getLogger(LivePopupController::class.java)
    private var epgDialog: EpgDialog? = null          // b
    private lateinit var currentEpgPopup: CurrentEpgPopup   // e
    private lateinit var exitDialog: ExitDialog       // f
    private lateinit var trialPopup: TrialPopup       // g
    private lateinit var menuPopup: PopupMenuC        // j
    private var favorite = 0                          // h
    private var isAdult = false                       // i
    private var notAdult = false                      // k
    private val bannerTimeout = 10_000                // a

    private val dismissMenu = Runnable { menuPopup.dismiss() }           // l
    private val dismissBanner = Runnable { currentEpgPopup.dismiss() }   // n

    init {
        menuPopup = PopupMenuC(activity).apply {
            animationStyle = R.style.showPopupAnimation
            setOnDismissListener { handler.removeCallbacks(dismissMenu) }
        }
        exitDialog = ExitDialog(activity)
        currentEpgPopup = CurrentEpgPopup(activity, handler)
        if (epgDialog == null) epgDialog = EpgDialog(activity, null, handler, catchUpListener)
        trialPopup = TrialPopup(activity).apply { animationStyle = R.style.showPopupAnimation }
    }

    /** Abre/fecha o EpgDialog do canal (não para canal adulto). Original: s(Object...) */
    fun showEpgDialog(channel: ChannelBean?) {
        val ch = channel ?: return
        if (epgDialog!!.isShowing()) epgDialog!!.dismiss()
        else if (!ch.isAdult() && BrowserUtils.isActivityAlive(activity)) epgDialog!!.show(ch)
    }

    /** Libera popups. Original: e() */
    fun release() {
        try { handler.removeCallbacks(dismissBanner) } catch (_: Exception) { }
        dismissSafely(currentEpgPopup); dismissSafely(null); dismissSafely(trialPopup)
    }

    /** Original: g() */
    fun dismissExitDialog() { if (exitDialog.isShowing()) exitDialog.dismiss() }

    /** Fecha o banner se aberto (consome o back). Original: h() */
    fun isAnyPopupShowing(): Boolean {
        if (!currentEpgPopup.isShowing) return false
        currentEpgPopup.dismiss()
        handler.removeCallbacks(dismissBanner)
        return true
    }

    /** Guarda estado do canal para o menu. Original: p(ChannelBean) */
    fun prepareMenu(ch: ChannelBean?) {
        if (ch == null) return
        favorite = ch.favorite
        notAdult = !ch.isAdult()
        isAdult = ch.isAdult()
    }

    /** Original: q(n) */
    fun showExitDialog(onExit: OnDialogActionListener) {
        if (exitDialog.isShowing()) return
        exitDialog.setOnExitListener(onExit)
        exitDialog.show()
    }

    /** Banner do canal (gravity BOTTOM), fecha após 10 s. Original: r(ChannelBean, int, int, int) */
    fun showChannelInfo(ch: ChannelBean?, inGroup: Int, group: Int, inputCode: Int) {
        if (!BrowserUtils.isActivityAlive(activity)) return
        if (currentEpgPopup.isShowing) handler.removeCallbacks(dismissBanner)
        if (ch == null) return
        currentEpgPopup.setData(ch, inputCode)
        currentEpgPopup.showAtLocation(activity.findViewById(android.R.id.content), Gravity.BOTTOM, 0, 1)
        currentEpgPopup.refresh()
        handler.postDelayed(dismissBanner, bannerTimeout.toLong())
    }

    /** Menu lateral (gravity RIGHT), fecha após 1 min. Original: t() */
    fun showMenu() {
        if (menuPopup.isShowing) { menuPopup.dismiss(); return }
        if (UiFunctionConfig.get().favoriteEnabled()) menuPopup.setState(favorite, notAdult, isAdult)
        menuPopup.showAtLocation(activity.findViewById(android.R.id.content), Gravity.END, 0, 0)
        handler.postDelayed(dismissMenu, TimeUnit.MINUTES.toMillis(1L))
    }

    /** Popup de trial (gravity TOP|LEFT). Original: u(boolean) */
    fun showTrial(show: Boolean) {
        if (!show) { if (trialPopup.isShowing) trialPopup.dismiss(); return }
        if (!BrowserUtils.isActivityAlive(activity) || trialPopup.isShowing) return
        trialPopup.showAtLocation(activity.findViewById(android.R.id.content), Gravity.TOP or Gravity.START, 0, 0)
    }

    private fun dismissSafely(p: PopupWindow?) {
        try { p?.dismiss() } catch (e: Exception) { logger.error(e.message, e) }
    }

    companion object {
        /** Original: o(Activity, Handler, x4.a) */
        fun create(activity: Activity, handler: Handler, l: CatchUpClickListener) = LivePopupController(activity, handler, l)
    }
}
