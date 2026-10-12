package com.live.evo.util

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Point
import android.graphics.Typeface
import android.net.ConnectivityManager
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.live.evo.MyApplication
import java.io.File
import java.util.Locale

/**
 * Toasts do app, via `com.foxivid.baselib.util.ToastHelper` (original `x1.f1.lb.util.g1`):
 * tipo 1 = toast curto (`c`), qualquer outro = `e` (longo).
 * Original: com/live/evo/util/r1.java (ToastUtils); s1.java (ToastUtils2: show(Context,String))
 */
object ToastUtils {
    /** Original: b(Context, int resId, int type) */
    fun show(context: Context, resId: Int, type: Int) { try { show(context, context.getString(resId), type) } catch (_: Throwable) {} }
    /** Original: c(Context, String) */
    fun show(context: Context, text: String) = show(context, text, 0)
    /** Original: d(Context, String, int) */
    fun show(context: Context, text: String, type: Int) {
        try { if (type == 1) ToastHelperProxy.short(text) else ToastHelperProxy.long(text) } catch (_: Throwable) {}
    }
    /** Mostra só se a view estiver parcialmente fora da tela (altura da tela via [ScreenUtils]). Original: e/f */
    fun showIfOffscreen(view: View?, context: Context, resId: Int, type: Int) {
        if (view == null) return
        val loc = IntArray(2); view.getLocationOnScreen(loc)
        if (loc[1] + view.height > ScreenUtils.size().y) show(context, resId, type)
    }
}

/** Ponte para `x1.f1.lb.util.g1` (ToastHelper). */
private object ToastHelperProxy {
    fun short(s: String) = com.foxivid.baselib.util.ToastHelper.show(s)
    fun long(s: String) = com.foxivid.baselib.util.ToastHelper.showLong(s)
}

/** Tamanho de tela via WindowManager. Original: com/live/evo/util/n.java */
object ScreenUtils {
    /** dp->px (density do sistema). Original: a(int) */
    fun dp(value: Int): Int = (value * Resources.getSystem().displayMetrics.density).toInt()
    @Suppress("DEPRECATION") fun height(): Int = (MyApplication.get().getSystemService("window") as android.view.WindowManager).defaultDisplay.height
    @Suppress("DEPRECATION") fun width(): Int = (MyApplication.get().getSystemService("window") as android.view.WindowManager).defaultDisplay.width
    /** Original: c() */
    @Suppress("DEPRECATION")
    fun size(): Point = Point().also { (MyApplication.get().getSystemService("window") as android.view.WindowManager).defaultDisplay.getSize(it) }
}

/**
 * Typefaces do app (campos estáticos preenchidos na inicialização). Original: com/live/evo/util/s.java
 */
object FontUtils {
    @JvmField var typeface0: Typeface? = null   // f7338a  → a()
    @JvmField var typeface1: Typeface? = null   // f7339b  → d()
    @JvmField var typeface2: Typeface? = null   // f7340c  → b()
    @JvmField var typeface3: Typeface? = null   // f7341d  → c()
    /** Inferido (nomes usados em LiveLoadActivity): regular = typeface3, medium = typeface2 */
    fun applyRegular(t: TextView?) { t?.typeface = typeface3 }
    fun applyMedium(t: TextView?) { t?.typeface = typeface2 }
}

/** Atalhos inferidos usados por LiveLoadActivity: applyRegular = c, applyMedium = b. */
object FontShortcuts

/** Aplica fonte ao TextView (null-safe). Original: com/live/evo/util/t.java (a→typeface0, b→typeface2, c→typeface3, d→typeface1) */
object TextStyleUtils {
    fun a(t: TextView?) { t?.typeface = FontUtils.typeface0 }
    fun b(t: TextView?) { t?.typeface = FontUtils.typeface2 }
    fun c(t: TextView?) { t?.typeface = FontUtils.typeface3 }
    fun d(t: TextView?) { t?.typeface = FontUtils.typeface1 }
}

/**
 * Carregamento de imagens com Glide (sem cache de disco, `DiskCacheStrategy.NONE` = `l.j.f15048a`),
 * placeholder padrão 2131102158 (R.drawable/color padrão) se [placeholder] <= 0.
 * Original: com/live/evo/util/v.java
 */
object GlideImageLoader {
    private const val DEFAULT_PLACEHOLDER = 2131102158
    fun load(context: Context, resId: Int, placeholder: Int, view: ImageView) = try {
        Glide.with(context).load(resId).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(if (placeholder <= 0) DEFAULT_PLACEHOLDER else placeholder).into(view); Unit
    } catch (_: Exception) {}
    fun load(context: Context, bitmap: Bitmap, placeholder: Int, view: ImageView) = try {
        Glide.with(context).load(bitmap).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(if (placeholder <= 0) DEFAULT_PLACEHOLDER else placeholder).into(view); Unit
    } catch (_: Exception) {}
    fun load(context: Context, url: String?, placeholder: Int, view: ImageView) = try {
        Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(if (placeholder <= 0) DEFAULT_PLACEHOLDER else placeholder).into(view); Unit
    } catch (_: Exception) {}
    fun load(context: Context, url: String?, view: ImageView) = load(context, url, DEFAULT_PLACEHOLDER, view)
}

/** Conectividade simples. Original: com/live/evo/util/t0.java */
object NetworkUtils {
    @Suppress("DEPRECATION")
    fun isConnected(context: Context): Boolean = try {
        (context.getSystemService("connectivity") as ConnectivityManager?)?.activeNetworkInfo?.isConnected == true
    } catch (e: Exception) { false }
}

/** SharedPreferences "tvcinema" (usado por LogInit). Original: com/live/evo/util/y0.java */
object LogInit {
    private var prefs: android.content.SharedPreferences? = null
    /** Original: a(Context) */ fun init(context: Context) { prefs = context.getSharedPreferences("tvcinema", 0) }
    /** Original: b(String,String) */ fun put(key: String, value: String) { prefs!!.edit().putString(key, value).apply() }
}

/** Parser de pares "k=v,k2" (a fonte `a()` retorna null nesta build). Original: com/live/evo/util/b0.java (DebugPropsParser) */
object DebugPropsParser {
    fun source(): String? = null
    fun parse(): Map<String, String> {
        val map = HashMap<String, String>()
        source()?.split(",")?.forEach { item ->
            if (item.contains("=")) { val kv = item.split("="); map[kv[0]] = kv[1] } else map[item] = "true"
        }
        return map
    }
}

/** Instala APK via FileProvider (`<pkg>.fileProvider`). Original: com/live/evo/util/v1.java (ApkInstaller) */
object ApkInstallIntent {
    fun install(context: Context, path: String) {
        val uri = FileProvider.getUriForFile(context, context.packageName + ".fileProvider", File(path))
        context.startActivity(Intent().apply { flags = 268435457; setDataAndType(uri, "application/vnd.android.package-archive"); action = Intent.ACTION_VIEW })
    }
}

/**
 * Força contexto em espanhol quando idioma resolvido = "es" mas o idioma base pt (condição na prática
 * sempre falsa: `TextUtils.equals("pt","es")`). Original: com/live/evo/util/j.java (LocaleContextWrapper)
 */
object LocaleContextWrapper {
    private var applied = false
    fun wrap(context: Context?): Context? {
        if (context == null) return context
        val lang = Locale.getDefault().language
        val resolved = if (lang == "pt" || lang == "en" || lang == "es") lang else "pt"
        if ((resolved == lang && !applied) || resolved != "es" || "pt" != "es") return context
        applied = true
        val cfg = Configuration(context.resources.configuration)
        val locale = Locale("es", "ES")
        cfg.setLocale(locale)
        if (Build.VERSION.SDK_INT >= 24) cfg.setLocales(android.os.LocaleList(locale))
        return context.createConfigurationContext(cfg)
    }
}
