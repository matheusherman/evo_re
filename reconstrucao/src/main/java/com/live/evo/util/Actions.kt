package com.live.evo.util

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.TextUtils
import com.live.evo.MyApplication
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
    /** Original: d(Activity, i5.x) — corpo vazio no APK (o método existe mas não faz nada). */
    fun onNotice(activity: Activity?, item: Any? /* i5.x: item de aviso */) {}

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
    private var email = ""; private var website = ""; private var whatsapp = ""; private var phone = ""
    private var facebook = ""; private var twitter = ""; private var validTime = ""; private var trialDays = ""

    /** Busca a propriedade remota [key] (padrão [def]) e aplica os placeholders. Original: a(String, String) */
    fun a(key: String, def: String): String = apply(AppUserManager.get().getString(key, def))

    private fun appVersionName(): String = try {
        val ctx = MyApplication.get(); ctx.packageManager.getPackageInfo(ctx.packageName, 0).versionName ?: ""
    } catch (e: Exception) { "" }

    /** Original: b(String) — valores em cache nos campos estáticos (preenchidos uma vez). */
    fun apply(template: String): String {
        val um = AppUserManager.get()
        if (email.isEmpty()) email = um.getString("contact_email", com.foxivid.baselib.heartbeat.HeartbeatManager.customerServiceEmail)
        if (website.isEmpty()) website = um.getString("web_site", com.foxivid.baselib.user.UserManager.getMembershipUrl())
        if (whatsapp.isEmpty()) whatsapp = um.getString("whatsapp", com.foxivid.baselib.heartbeat.HeartbeatManager.customerServiceGroupWhatsappLink)
        if (phone.isEmpty()) phone = um.getString("phone", "")
        if (facebook.isEmpty()) facebook = um.getString("facebook", "")
        if (twitter.isEmpty()) twitter = um.getString("twitter", "")
        if (template.contains("\${ValidTime}")) {
            var t = um.expiryTime()
            if (t <= 0) t = um.getLong("validTime", -1L)
            if (t >= 0) {
                val h = DateUtils.hoursBetween(DateUtils.now(), t)
                validTime = h.toString() + " " + CommonUtils.string(if (h <= 1) com.live.evo.R.string.hour else com.live.evo.R.string.hours)
            }
        }
        if (trialDays.isEmpty()) {
            val d = um.getInt("TrialDays", 0)
            trialDays = d.toString() + " " + CommonUtils.string(if (d > 1) com.live.evo.R.string.days else com.live.evo.R.string.day)
        }
        var appName = CommonUtils.string(com.live.evo.R.string.freetrial_app_name)
        if (appName.isEmpty()) appName = appVersionName()   // k.t(): AppAttrUtils.appVersionName (privado no port; lido do PackageManager)
        return template.replace("\${Email}", email).replace("\${Website}", website).replace("\${Whatsapp}", whatsapp)
            .replace("\${Phone}", phone).replace("\${Facebook}", facebook).replace("\${Twitter}", twitter).replace("\${NewLine}", "<br/>")
            .replace("\${AppName}", appName).replace("\${ValidTime}", validTime).replace("\${TrialDays}", trialDays)
    }
}

/** Download de arquivo (OkHttp, buffer 2048, progresso 0..100). Original: com/live/evo/util/o.java */
object FileDownloader {
    interface Callback { fun onError(e: Exception); fun onDone(path: String); fun onProgress(percent: Int) }
    /**
     * Baixa [url] para [target] (flag `async`: enfileira no OkHttp; senão executa na thread corrente). Escreve em blocos de
     * 2048 bytes apagando o arquivo anterior, notifica o progresso (0..100, só se o tamanho for conhecido); em erro apaga o
     * arquivo parcial e chama onError; ao fim chama onDone(caminho absoluto).
     * Original: o.a(String, File, boolean, b) + o$a (okhttp3.f)
     */
    fun download(url: String, target: java.io.File, async: Boolean, cb: Callback?) {
        val client = ServerTimeClient.get().client
        val request = okhttp3.Request.Builder().url(url).build()
        val handler = object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: java.io.IOException) { cb?.onError(e) }
            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                val buffer = ByteArray(2048)
                var input: java.io.InputStream? = null
                var output: java.io.FileOutputStream? = null
                try {
                    input = response.body!!.byteStream()
                    val contentLength = response.body!!.contentLength()
                    target.delete()
                    output = java.io.FileOutputStream(target)
                    var written = 0L
                    while (true) {
                        val n = input.read(buffer)
                        if (n == -1) break
                        output.write(buffer, 0, n)
                        written += n
                        if (contentLength > 0) cb?.onProgress((((written * 1.0f) / contentLength) * 100.0f).toInt())
                    }
                    output.flush()
                    cb?.onDone(target.absolutePath)
                } catch (e: Exception) {
                    cb?.onError(e)
                    target.delete()
                } finally {
                    try { input?.close() } catch (_: Exception) {}
                    try { output?.close() } catch (_: Exception) {}
                }
            }
        }
        val call = client.newCall(request)
        if (async) {
            call.enqueue(handler)
            return
        }
        try { handler.onResponse(call, call.execute()) } catch (e: java.io.IOException) { handler.onFailure(call, e) }
    }
}
