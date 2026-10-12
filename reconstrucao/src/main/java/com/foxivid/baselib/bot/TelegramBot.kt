package com.foxivid.baselib.bot

import com.foxivid.baselib.log.RemoteLogger
import com.foxivid.baselib.util.AppInfo
import com.foxivid.baselib.util.Clock
import com.foxivid.baselib.util.DateFormats
import com.foxivid.baselib.util.LoggerFactory
import com.foxivid.baselib.util.Preferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicLong

/**
 * "Bot do Telegram": monta mensagens de evento (novo cliente, troca de conta, falha de upgrade,
 * zapping lento...) com número de sequência persistido.
 *
 * Original: x1/f1/lb/bot/a.java (nome Kotlin original `TelegramBot.kt`)
 *
 * **Não envia nada**: o destino é `RemoteLogger.g(String)` ([RemoteLogger.botMessage]), que é um
 * método vazio no APK analisado. A biblioteca `com.pengrad.telegrambot` está empacotada (há import
 * de `MessageOriginChannel` em uf/c só como constante "channel"), mas nenhum envio é feito aqui.
 *
 * Formato da mensagem:
 * ```
 * \n<tag>\n#<seq>: [v<appVersionName>] <yyyy-MM-dd HH:mm:ss> [    last msg: <data>(<duração> ago)]\n<msg>
 * ```
 */
object TelegramBot {
    private val logger = LoggerFactory.getLogger(TelegramBot::class.java)

    private val msgSeq = AtomicLong(0L)
    private val errSeq = AtomicLong(0L)
    private val feedbackSeq = AtomicLong(0L)
    private val warnSeq = AtomicLong(0L)
    private val infoSeq = AtomicLong(0L)
    private var lastSentTime = 0L
    private var lastFeedbackTime = 0L
    /** Original: a.botEnable (default true; propriedade remota is_telegram_bot_enable) */
    private var botEnable = true

    /**
     * Carrega sequências persistidas. (Não carrega `t_bot_msg_last_feedback_sent_time_key`.)
     *
     * Original: a.j() + a$a
     */
    fun init() {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                feedbackSeq.set(Preferences.getLong("t_bot_usr_feedback_seq_key", feedbackSeq.get()))
                msgSeq.set(Preferences.getLong("t_bot_msg_seq_key", msgSeq.get()))
                errSeq.set(Preferences.getLong("t_bot_sys_err_seq_key", errSeq.get()))
                warnSeq.set(Preferences.getLong("t_bot_sys_warn_seq_key", warnSeq.get()))
                infoSeq.set(Preferences.getLong("t_bot_sys_info_seq_key", infoSeq.get()))
                lastSentTime = Preferences.getLong("t_bot_msg_last_sent_time_key", lastSentTime)
            }
        } catch (t: Throwable) {
            logger.error("init telegram bot failure", t)
        }
    }

    /** Original: a.h(...) — versão com "last msg". Retorna o novo instante de envio. */
    private fun sendWithLast(msg: String, tag: String, seqKey: String, seq: AtomicLong, lastKey: String, last: Long): Long {
        if (!botEnable) return last
        val now = Clock.now()
        var time = DateFormats.format(16, now)
        val delta = now - last
        if (delta in 1 until now) {
            time += "    last msg: " + DateFormats.format(16, last) + "(" + DateFormats.durationText(delta) + " ago)"
        }
        RemoteLogger.botMessage("\n$tag\n#${seq.incrementAndGet()}: [v${AppInfo.appVersionName()}] $time\n$msg")
        Preferences.putLong(seqKey, seq.get())
        Preferences.putLong(lastKey, now)
        return now
    }

    /** Original: a.i(...) */
    private fun send(msg: String, tag: String, seqKey: String, seq: AtomicLong) {
        if (!botEnable) return
        val time = DateFormats.format(16, Clock.now())
        RemoteLogger.botMessage("\n$tag\n#${seq.incrementAndGet()}: [v${AppInfo.appVersionName()}] $time\n$msg")
        Preferences.putLong(seqKey, seq.get())
    }

    /** Mensagem de negócio. Original: a.k(String) */
    fun sendBiz(msg: String) {
        lastSentTime = sendWithLast(msg, "[biz]", "t_bot_msg_seq_key", msgSeq, "t_bot_msg_last_sent_time_key", lastSentTime)
    }

    /** Original: a.l(String) */
    fun sendSysError(msg: String) = send(msg, "[sys][E]", "t_bot_sys_err_seq_key", errSeq)

    /** Original: a.m(String) */
    fun sendSysInfo(msg: String) = send(msg, "[sys][I]", "t_bot_sys_info_seq_key", infoSeq)

    /** Original: a.n(String) */
    fun sendSysWarn(msg: String) = send(msg, "[sys][W]", "t_bot_sys_warn_seq_key", warnSeq)

    /** Original: a.o(String) */
    fun sendFeedback(msg: String) {
        lastFeedbackTime = sendWithLast(msg, "[feedback]", "t_bot_usr_feedback_seq_key", feedbackSeq,
            "t_bot_msg_last_feedback_sent_time_key", lastFeedbackTime)
    }

    /** Original: a.p(boolean) */
    fun setEnable(isEnable: Boolean) { botEnable = isEnable }
}
