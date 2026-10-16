package com.live.evo.util

import android.graphics.drawable.Drawable
import android.net.TrafficStats
import android.util.TypedValue
import androidx.core.content.ContextCompat
import com.live.evo.MyApplication
import com.live.evo.R
import java.util.Locale
import java.util.regex.Pattern

/**
 * Utilitários gerais: bytes de rede, mascaramento de contas/e-mails, resources, debounce.
 *
 * Original: com/live/evo/util/x1.java
 */
object CommonUtils {
    private val uid = MyApplication.get().applicationInfo.uid
    private var lastClickTime = 0L

    /** RX total em KB (0 se o uid não tem estatística). Original: i() — lido como `totalRxBytes()` em LiveNewActivity */
    fun totalRxBytes(): Long = try {
        if (TrafficStats.getUidRxBytes(uid) == -1L) 0L else TrafficStats.getTotalRxBytes() / 1024
    } catch (e: Exception) { 0L }

    /** TX em KB (uid, ou total se indisponível). Original: l() */
    fun totalTxBytes(): Long = try {
        val tx = TrafficStats.getUidTxBytes(uid)
        if (tx == -1L) TrafficStats.getTotalTxBytes() / 1024 else tx / 1024
    } catch (e: Exception) { 0L }

    /** Dp -> px. Original: b(float) */
    fun dp(value: Float): Int = TypedValue.applyDimension(1, value, MyApplication.get().resources.displayMetrics).toInt()

    /**
     * Mascara o meio de [text] com [mask]: mantém [edge] caracteres em cada ponta (ou length/3 se o texto
     * é curto). Original: c(String, int, int, String)
     */
    fun maskEdges(text: String?, edge: Int, minLength: Int, mask: String): String {
        if (text.isNullOrEmpty()) return "null"
        var n = edge
        if (text.length <= minLength) n = text.length / 3
        if (n > 0) {
            val tail = if (text.length >= n) text.substring(text.length - n) else ""
            return text.substring(0, n) + mask + tail
        }
        return text.substring(0, 1) + mask
    }

    /** Original: d(String, String) — substitui o miolo (1/3 em cada ponta) por [mask] repetido. */
    fun maskMiddle(text: String, mask: String): String {
        if (text.length < 3) {
            return when (text.length) {
                2 -> text.substring(0, 1) + mask + text.substring(1)
                1 -> text + mask + text
                else -> text
            }
        }
        val n = text.length / 3
        val sb = StringBuilder()
        for (i in 0 until text.length - n * 2) sb.append(mask)
        return text.substring(0, n) + sb + text.substring(text.length - n)
    }

    /** Resource color. Original: e(int) → com.blankj.utilcode.util.e.a(int) */
    fun color(id: Int): Int = ContextCompat.getColor(MyApplication.get(), id)

    /** Original: f(int) */
    fun drawable(id: Int): Drawable? = ContextCompat.getDrawable(MyApplication.get(), id)

    /**
     * Mascara conta para exibição: só dígitos -> [maskEdges] ("********") ou [maskMiddle] ("*");
     * e-mail -> mascara a parte local; telefone com + ou 00 -> [maskMiddle]. Original: g(String, boolean)
     */
    fun maskAccount(value: String?, strong: Boolean): String {
        if (value.isNullOrEmpty()) return "null"
        if (Pattern.compile("[0-9]*").matcher(value).matches()) {
            return if (strong) maskEdges(value, 4, 8, "********") else maskMiddle(value, "*")
        }
        val at = value.indexOf("@")
        if (at > 0) {
            val local = value.substring(0, at)
            val domain = value.substring(at)
            if (local.isNotEmpty()) return maskMiddle(local, "*") + domain
        } else if (value.indexOf("+") == 0 || value.indexOf("00") == 0) {
            return maskMiddle(value, "*")
        }
        return value
    }

    /** Idioma do app: "pt", "en" ou "es"; qualquer outro vira "pt". Original: h() */
    fun language(): String {
        val lang = Locale.getDefault().language
        return if (lang != "pt" && lang != "en" && lang != "es") "pt" else lang
    }

    /** Original: j(int) */ fun string(id: Int): String = MyApplication.get().getString(id)
    /** Original: k(int, String) */ fun string(id: Int, arg: String): String = String.format(MyApplication.get().getString(id), arg)

    /** Anti-duplo-clique: true se ainda dentro de [intervalMs] do último clique. Original: m(long) */
    fun isFastClick(intervalMs: Long): Boolean {
        val now = System.currentTimeMillis()
        if (Math.abs(now - lastClickTime) < intervalMs) return true
        lastClickTime = now
        return false
    }

    /** Alias usado por LiveLoadActivity/MyApplication. Original: a(boolean) */
    fun setFreeTrialMode(freeTrial: Boolean) = applyBranding(freeTrial)

    /**
     * Troca ícone/nome do app para o modo "free trial" (a.f5198r/f5199s, aqui [AppConstants.launcherIcon]/[AppConstants.appNameRes]). Original: a(boolean)
     */
    fun applyBranding(freeTrial: Boolean) {
        // Original (x1.a): ícone sempre R.mipmap.ic_launcher; nome = freetrial_app_name se freeTrial, senão o id literal 2131951743
        // (0x7f1300ff = R.string.chat_qr_tip no APK recuperado; o valor literal é mantido tal como no original).
        AppConstants.launcherIcon = R.mipmap.ic_launcher
        AppConstants.appNameRes = if (freeTrial) R.string.freetrial_app_name else 2131951743
    }
}
