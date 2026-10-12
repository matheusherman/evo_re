package com.live.evo.util

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.TextUtils
import com.live.evo.event.ChangeChannelEvent
import org.greenrobot.eventbus.EventBus

/**
 * Abre links/ações vindas do servidor e checa a Activity do topo.
 * - [openLink]: URLs "http://"/"https://" abrem no browser embutido (com.android.browser) ou no padrão;
 *   "apk:<pacote>" lança outro app via [AppLauncher].
 * Original: com/live/evo/util/b.java (nome sugerido BrowserUtils; também guarda lista de Activities f7179a)
 */
object BrowserUtils {
    @JvmField val activities: MutableList<Activity> = ArrayList()

    /** True se [className] é a Activity do topo (getRunningTasks); em exceção, true. Original: a(Context,String) */
    @Suppress("DEPRECATION")
    fun isTopActivity(context: Context?, className: String): Boolean {
        if (context == null) return false
        return try {
            val tasks = (context.getSystemService("activity") as ActivityManager).getRunningTasks(1)
            tasks != null && tasks.size > 0 && className == tasks[0].topActivity!!.className
        } catch (e: Exception) { true }
    }

    /** Alias usado pelas Activities. Original: a(Context,String) */
    fun isActivityAlive(context: Context?, className: String) = isTopActivity(context, className)

    /** Original: b(Context) — `a(context, "activity.LiveNewActivity")` (nome ofuscado/jadx; real: com.live.evo.activity.LiveNewActivity) */
    fun isLiveActivityOnTop(context: Context?): Boolean = isTopActivity(context, "com.live.evo.activity.LiveNewActivity")

    /** Original: c(Activity, String) */
    fun openLink(activity: Activity, url: String?) {
        if (url.isNullOrEmpty() || url.length < 8) return
        val scheme7 = url.substring(0, 7)
        val scheme4 = url.substring(0, 4)
        if ("http://,https://".contains(scheme7)) {
            val uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            try {
                try {
                    intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity")
                    activity.startActivity(intent)
                    return
                } catch (_: Exception) {
                    activity.startActivity(Intent(Intent.ACTION_VIEW, uri))
                    return
                }
            } catch (_: Exception) {
                com.foxivid.baselib.util.ToastHelper.show(activity.getString(com.live.evo.R.string.install_browser))
                return
            }
        }
        if (TextUtils.equals(scheme4, "apk:")) AppLauncher.launch(activity, url.substring(4))
    }
}

/** Abre outro app pelo pacote (launcher ou leanback launcher), flags 270532608. Original: com/live/evo/util/d.java */
object AppLauncher {
    fun launch(context: Context, packageName: String) {
        var intent = context.packageManager.getLaunchIntentForPackage(packageName)
            ?: context.packageManager.getLeanbackLaunchIntentForPackage(packageName)
        if (intent != null) {
            intent.flags = 270532608
            intent.addCategory("android.intent.category.LAUNCHER")
            context.startActivity(intent)
        }
    }
}

/**
 * Trata o "tipo de ação" de avisos/banners (`i5.v` bean): `channelId` (troca canal), `programId`,
 * `h5Link` (abre link), `appPageId` (navega para página do app: "footballPage" → "subject",
 * "accountPage" → "My Account", "renewPage" → "Renew"), via eventos do EventBus.
 * Original: com/live/evo/util/r0.java
 */
object NoticeActionHandler {
    fun isSupported(type: String?) = type == "channelId" || type == "h5Link"
    fun hasAction(type: String?) = !type.isNullOrEmpty()

    /** Original: c(Activity, i5.v) */
    fun handle(activity: Activity?, type: String?, value: String?, channelId: String?) {
        when (type) {
            "channelId" -> if (!value.isNullOrEmpty()) EventBus.getDefault().post(ChangeChannelEvent("", "", "", value))
            "programId" -> { /* h(programId, channelId, "message"): resolve o canal no mapa e (não implementado no corpo) */ }
            "h5Link" -> if (activity != null && !activity.isFinishing && !value.isNullOrEmpty()) BrowserUtils.openLink(activity, value)
            "appPageId" -> when (value) {
                "footballPage" -> EventBus.getDefault().post(ChangeChannelEvent("subject", "", "", ""))
                "accountPage" -> EventBus.getDefault().post(ChangeChannelEvent("My Account", "", "", ""))
                "renewPage" -> EventBus.getDefault().post(ChangeChannelEvent("Renew", "", "", ""))
            }
        }
    }
}

/**
 * Substitui placeholders em textos remotos: ${Email}, ${Website}, ${Whatsapp}, ${Phone}, ${Facebook}, ${Twitter},
 * ${AppName}, ${ValidTime} (horas até expirar, "hour"/"hours") e ${TrialDays} ("N day(s)").
 * Valores vêm de propriedades remotas ("contact_email", "web_site", "whatsapp", "phone", "facebook", "twitter",
 * "validTime", "TrialDays") com padrões do SDK.
 * Original: com/live/evo/util/p1.java (ContactTemplate)
 */
object ContactTemplate {
    // TODO("parcial: usa AppUserManager.n().i(chave, padrão) — ver util/p1.b(String)")
    fun apply(template: String): String = TODO("ver util/p1.b(String)")
}

/** Download de arquivo (OkHttp, buffer 2048, progresso 0..100). Original: com/live/evo/util/o.java */
object FileDownloader {
    interface Callback { fun onError(e: Exception); fun onDone(path: String); fun onProgress(percent: Int) }
    fun download(url: String, target: java.io.File, deleteFirst: Boolean, cb: Callback?) {
        // Original: okhttp3.z de ServerTimeClient.client(); stream -> FileOutputStream; erro apaga o arquivo parcial.
        TODO("não detalhado: ver util/o.a(String, File, boolean, b)")
    }
}
