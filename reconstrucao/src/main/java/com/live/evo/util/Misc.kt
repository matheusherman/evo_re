package com.live.evo.util

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.SystemClock
import android.text.TextUtils
import android.util.Pair
import android.view.View
import android.view.Window
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

/**
 * Cronômetro de etapas de carregamento ("Debug Loading"): [mark] registra pares (etapa, tempo) e [finish]
 * grava "Total". Só ativo quando um run foi iniciado (`f7276d`).
 * Original: com/live/evo/util/m.java (LoadingTimer)
 */
object LoadingTimer {
    private var running = false
    private var startTime = 0L
    private var lastTime = System.currentTimeMillis()
    private var name = ""
    private var steps: MutableList<Pair<String, Long>>? = null
    private val seen = mutableListOf<String>()
    private var lastSteps: MutableList<Pair<String, Long>> = mutableListOf()

    /** Registra valor numérico nomeado (ex.: remindType). Original: c(String,long) via LiveLoadActivity */
    fun set(name: String, value: Long) = mark(name, value)

    /** Registra erro de etapa. Original: m.a(int,String) */
    fun error(code: Int, label: String) = finish(code, label)

    /** Original: b(String) — marca etapa (uma vez por nome). */
    fun mark(step: String) {
        if (running && step !in seen) {
            seen.add(step)
            val t = SystemClock.elapsedRealtime()
            steps!!.add(Pair(step, t))
            lastTime = t
        }
    }
    /** Original: c(String, long) */
    fun mark(step: String, value: Long) { if (running) steps!!.add(Pair(step, value)) }
    /** Original: a(int, String) — encerra: adiciona "Total" e, se o nome é "Debug Loading", guarda o resultado. */
    fun finish(@Suppress("UNUSED_PARAMETER") code: Int, @Suppress("UNUSED_PARAMETER") label: String) {
        if (!running) return
        val now = SystemClock.elapsedRealtime()
        running = false
        steps!!.add(Pair("Total", now - startTime))
        if (TextUtils.equals(name, "Debug Loading")) lastSteps = steps!!
        steps = null
    }
}

/** Permissões de runtime (WRITE_EXTERNAL_STORAGE). Original: com/live/evo/util/x0.java */
object PermissionUtils {
    val STORAGE = arrayOf("android.permission.WRITE_EXTERNAL_STORAGE")
    /** true se todas as permissões já foram concedidas. Original: a(Context, String[]) */
    fun has(context: Context, perms: Array<String>): Boolean =
        perms.all { ContextCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED }
    /** Original: b(Activity, String[], int) */
    fun request(activity: Activity, perms: Array<String>, requestCode: Int) = ActivityCompat.requestPermissions(activity, perms, requestCode)
}

/**
 * Teclado virtual: abrir/fechar, ajustar a view quando o IME aparece, limpar foco em EditTexts.
 * Original: com/live/evo/util/a0.java (nome sugerido KeyboardUtils) e util/z.java (InputMethodManager)
 */
object KeyboardUtils {
    /** InputMethodManager do app. Original: util/z.a() */
    fun inputMethodManager() = com.live.evo.MyApplication.get().getSystemService("input_method") as android.view.inputmethod.InputMethodManager
    // TODO("parcial: i/j/k/l/m/n/p/q/r/s/t — listeners de layout global para subir a UI com o teclado (a0.java)")
    fun hide(view: View) { inputMethodManager().hideSoftInputFromWindow(view.windowToken, 0) }
}

/** Animações de view (translationY etc.). Original: com/live/evo/util/z0.java */
object AnimUtils {
    private var fadeIn: android.view.animation.AlphaAnimation? = null    // a
    private var fadeOut: android.view.animation.AlphaAnimation? = null   // b
    private var pulsingView: View? = null                                 // c

    /** Foco ganho: escala 1.1 em 200 ms. Original: d(View) */
    fun d(view: View?) { view?.animate()?.scaleX(1.1f)?.scaleY(1.1f)?.setInterpolator(android.view.animation.AccelerateInterpolator())?.setDuration(200L) }
    /** Foco perdido: volta a 1.0 em 200 ms. Original: g(View) */
    fun g(view: View?) { view?.animate()?.scaleX(1.0f)?.scaleY(1.0f)?.setInterpolator(android.view.animation.AccelerateInterpolator())?.setDuration(200L) }

    /** Pulsa o alpha (1.0 ↔ [minAlpha]) em loop alternando dois AlphaAnimation. Original: e(View, float, int) */
    private fun pulse(view: View, minAlpha: Float, durationMs: Int) {
        if (fadeIn == null) fadeIn = android.view.animation.AlphaAnimation(minAlpha, 1.0f)
        fadeIn!!.duration = durationMs.toLong()
        if (fadeOut == null) fadeOut = android.view.animation.AlphaAnimation(1.0f, minAlpha)
        fadeOut!!.duration = durationMs.toLong()
        fadeIn!!.setAnimationListener(object : android.view.animation.Animation.AnimationListener {
            override fun onAnimationEnd(a: android.view.animation.Animation?) { pulsingView?.startAnimation(fadeOut) }
            override fun onAnimationRepeat(a: android.view.animation.Animation?) {}
            override fun onAnimationStart(a: android.view.animation.Animation?) {}
        })
        fadeOut!!.setAnimationListener(object : android.view.animation.Animation.AnimationListener {
            override fun onAnimationEnd(a: android.view.animation.Animation?) { pulsingView?.startAnimation(fadeIn) }
            override fun onAnimationRepeat(a: android.view.animation.Animation?) {}
            override fun onAnimationStart(a: android.view.animation.Animation?) {}
        })
        pulsingView!!.startAnimation(fadeOut)
    }
    /** Inicia pulsação (alpha 0.5, 1500 ms) na view; ignora se já é a atual. Original: f(View) */
    fun f(view: View?) {
        pulsingView?.let { if (it == view) return else it.clearAnimation() }
        pulsingView = view
        if (view == null) return
        pulse(view, 0.5f, 1500)
    }
    /** Desce a view 0 → 500 px em 300 ms. Original: h(View) */
    fun h(view: View?) {
        if (view == null) return
        android.animation.ObjectAnimator.ofFloat(view, "translationY", 0.0f, 500.0f).apply { duration = 300L; interpolator = android.view.animation.AccelerateInterpolator() }.start()
    }
    /** Sobe a view 500 → 0 px em 300 ms. Original: i(View) */
    fun i(view: View?) {
        if (view == null) return
        android.animation.ObjectAnimator.ofFloat(view, "translationY", 500.0f, 0.0f).apply { duration = 300L; interpolator = android.view.animation.DecelerateInterpolator() }.start()
    }
}

/**
 * Cache de bitmaps em memória (LruCache) e retentor de fragment para sobreviver a mudanças de configuração;
 * decodifica bitmap de URL com amostragem. Log "ImageCache".
 * Original: com/live/evo/util/y.java
 */
class ImageCache {
    // TODO("parcial: LruCache<String,BitmapDrawable>, inBitmap reuse — adaptado de android.com 'DisplayingBitmaps'")
    fun get(key: String): android.graphics.drawable.BitmapDrawable? = null
    fun put(key: String, drawable: android.graphics.drawable.BitmapDrawable) {}
}

/**
 * Gera QR code a partir de texto. No original usa o encoder `e1.a(context).w(1).x(TEXT).t(text).a().a()` (wrapper do ZXing
 * android-embedded, `e1` não decompilou); aqui usa o ZXing `QRCodeWriter` (inferido: 512x512, margem 1, preto/branco).
 * Original: com/live/evo/util/w1.java (QrBitmapHelper)
 */
class QrBitmapHelper {
    fun create(text: String?): Bitmap? = if (text.isNullOrEmpty()) null else try {
        val size = 512
        val hints = mapOf(com.google.zxing.EncodeHintType.MARGIN to 1, com.google.zxing.EncodeHintType.CHARACTER_SET to "UTF-8")
        val matrix = com.google.zxing.qrcode.QRCodeWriter().encode(text, com.google.zxing.BarcodeFormat.QR_CODE, size, size, hints)
        val bmp = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
        for (x in 0 until size) for (y in 0 until size) bmp.setPixel(x, y, if (matrix[x, y]) android.graphics.Color.BLACK else android.graphics.Color.WHITE)
        bmp
    } catch (t: Throwable) { t.printStackTrace(); null }
}

/** Gson: formato de data "yyyy-MM-dd HH:mm:ss"; variante com desserializador de HashMap<String,Object>. Original: com/live/evo/util/w.java */
object GsonFactory {
    fun builder() = com.google.gson.GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
    fun gson(): com.google.gson.Gson = builder().create()
    fun gsonWithMapDeserializer(): com.google.gson.Gson = builder().create()
}

/**
 * Cliente OkHttp usado só para o relógio/servidor: interceptor adiciona headers "GetServerTime", "ClientTimeMS",
 * "VnoId", "BrandId", "AppId", "VersionCode"...; timeouts 15 s; CookieJar persistente; DNS próprio (mf.b).
 * Original: com/live/evo/util/u0.java (ServerTimeClient)
 */
class ServerTimeClient private constructor() {
    val client: okhttp3.OkHttpClient = TODO("construção em u0.<init>: interceptor + cookies + dns")
    fun baseUrl(): String = TODO("MediaRepository.Y()")
    companion object { /** Original: b() */ fun get() = ServerTimeClient() }
}

/**
 * Parsers de QR code/contatos (cópia do ZXing `client.result`): vCard, MECARD, texto/telefone, e-mail, URL.
 * Original: util/k.java (ResultParser base), p0.java (AddressBookDoCoMoResultParser, "MECARD:"),
 * y1.java (VCardResultParser), d1.java (ParsedResultType parser: company/postal/URL/NOTE), e1.java,
 * v0.java (ContactsContract fields), w0.java (padrões regex), z1.java/a2.java (Formatters),
 * g1.java (BitmapDrawable com recycle-count de cache; usado por [ImageCache]).
 * Não reconstruído linha a linha: é biblioteca de terceiros embutida no pacote util.
 */
object QrResultParsers
