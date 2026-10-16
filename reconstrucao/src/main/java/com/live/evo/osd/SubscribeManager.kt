package com.live.evo.osd

import android.app.Activity
import android.os.Handler
import com.foxivid.baselib.media.ChannelManager
import com.live.evo.dialog.SubscribeSwitchDialog
import com.live.evo.event.SubscribeRemindEvent
import com.live.evo.model.ProgramBean
import com.live.evo.model.SubscribeBean
import com.live.evo.util.BrowserUtils
import com.live.evo.util.DateUtils
import com.live.evo.util.ModelHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import org.slf4j.LoggerFactory
import java.lang.ref.SoftReference
import java.util.Timer
import java.util.TimerTask

/**
 * Gerenciador dos lembretes ("agendar programa") da tela de live. Mantém a lista de [SubscribeBean] e um [Timer] que, 2 minutos
 * antes do início do programa mais próximo, posta [showPopupWindowRunnable] na main thread: se o usuário não está no canal do
 * lembrete (ou a Activity não está mais visível) dispara um [SubscribeRemindEvent] (tratado por `LiveNewActivity.onSubscribe`
 * com o `SubscribePopup`) e remove o lembrete; depois agenda o próximo.
 *
 * Original: com/live/evo/osd/u.java (nome real SubscribeManager)
 */
object SubscribeManager {
    private val logger = LoggerFactory.getLogger(SubscribeManager::class.java)
    private var liveActivityRef: SoftReference<Activity>? = null   // mLiveActivitySoftReference
    private var handler: Handler? = null                            // mHandler
    private var switchDialog: SubscribeSwitchDialog? = null
    private val subscribeList = ArrayList<SubscribeBean>()          // mSubscribeList
    private var currentBean: SubscribeBean? = null                  // mSubscribeBean
    private var timer: Timer? = null                                // mSubscribeTimer
    private var timerTask: TimerTask? = null                        // mTimerTask
    private var listener: Listener? = null                          // subscribeManagerListener
    private var playIndex = 0

    /** Listener vazio (interface `u.a`): implementado por `LiveNewActivity$m` sem métodos. Original: u.a */
    interface Listener

    private val showPopupWindowRunnable = Runnable {      // u.n()
        val activity = liveActivity()
        if (currentBean!!.channelIndex != playIndex || (activity != null && !BrowserUtils.isActivityAlive(activity, activity.javaClass.name))) {
            postRemindEvent()
        }
        removeCurrentAndScheduleNext()
    }

    /** Runnable de dispensa do popup: vazio no original (u.f()). */
    private val dismissPopupWindowRunnable = Runnable { }

    private fun liveActivity(): Activity? = liveActivityRef?.get()

    /** Guarda a Activity de live/handler/listener e cria o diálogo de troca. Original: h(Activity, Handler, a) */
    fun init(liveActivity: Activity, handler: Handler, listener: Listener) {
        liveActivityRef = SoftReference(liveActivity)
        this.handler = handler
        this.listener = listener
        switchDialog = SubscribeSwitchDialog(liveActivity)   // i()
    }

    /** Guarda o índice (global) do canal em reprodução. Original: l(int) */
    fun onChannelChanged(index: Int) { playIndex = index }

    /** Mostra o diálogo de troca de lembrete (se ainda não visível e Activity viva). Original: o(p, c0, x) */
    fun showSwitchDialog(newBean: ProgramBean, oldBean: SubscribeBean, listener: SubscribeSwitchDialog.Listener) {
        val dialog = switchDialog ?: return
        dialog.setPrograms(newBean, oldBean)
        if (!dialog.isShowing() && BrowserUtils.isActivityAlive(liveActivity(), "com.live.evo.activity.LiveNewActivity")) {
            dialog.setListener(listener)
            dialog.show()
        }
    }

    /** Atualiza (cancela/recria) o lembrete via [ModelHelper.updateSubscribeList]. Original: r(c0, int, SubscribeItem) */
    fun update(bean: SubscribeBean?, status: Int, item: com.foxivid.baselib.media.model.SubscribeItem?) {
        if (bean == null) return
        ModelHelper.updateSubscribeList(bean, item)
    }

    /** Agenda o programa e chama [listener] quando o banco for atualizado. Original: s(String, String, int, p, String, String, v, SubscribeItem) */
    fun subscribe(channelName: String?, icon: String?, inAllPos: Int, bean: ProgramBean?, channelId: String?, subscribeType: String,
                  listener: OnUpdateListener?, item: com.foxivid.baselib.media.model.SubscribeItem?) {
        if (bean == null || channelId == null) return
        // O tipo de origem enviado é sempre a constante `MessageOriginChannel.MESSAGE_ORIGIN_TYPE` (= "channel", constante da API de bots);
        // o parâmetro subscribeType é ignorado.
        ModelHelper.subscribeProgram(channelName ?: "", icon ?: "", inAllPos, bean, channelId, "channel",
            { listener?.onUpdate() }, item)
    }

    /** Remove o lembrete atual do SDK e agenda o próximo. Original: j() */
    private fun removeCurrentAndScheduleNext() {
        try { currentBean?.let { removeFromSdk(it) } } catch (e: Exception) { logger.error("removeSubscribeBean error", e) }
        scheduleNext()
    }

    /** Remove o lembrete do SDK (corrotina `SubscribeManager$removeSubscribeBean$1`). Original: k(c0) */
    private fun removeFromSdk(bean: SubscribeBean) {
        CoroutineScope(Dispatchers.IO).launch {
            ChannelManager.toggleSubscribe(bean.a()!!.toInt(), bean.h(), bean.d() ?: "", null)   // InteractionUtils.K0(key, start, epgId, null)
        }
    }

    /** Avisa a UI de que há um lembrete a mostrar. Original: m() */
    fun postRemindEvent() { EventBus.getDefault().post(SubscribeRemindEvent(currentBean!!)) }

    /** Cancela o timer atual. Original: q() */
    private fun cancelTimer() {
        try {
            timer?.let { it.cancel(); it.purge(); timer = null }
        } catch (_: Exception) {}
    }

    /**
     * Pega o primeiro lembrete da lista e agenda o disparo para 2 min antes do início (ou em 1 s se já passou do limite).
     * Original: p()
     */
    fun scheduleNext() {
        try {
            cancelTimer()
            if (subscribeList.isNotEmpty()) {
                currentBean = subscribeList[0]
                val start = currentBean!!.h()
                var delay = 1000L
                val untilStart = start - DateUtils.now()
                if (untilStart > 0) {
                    val d = untilStart - 120000L
                    if (d > 0) delay = d
                }
                timer = Timer()
                timerTask?.cancel()
                timerTask = object : TimerTask() {   // classe `u$c`
                    override fun run() { handler!!.post(showPopupWindowRunnable) }
                }
                timer!!.schedule(timerTask, delay)
            }
        } catch (_: Exception) {}
    }
}
