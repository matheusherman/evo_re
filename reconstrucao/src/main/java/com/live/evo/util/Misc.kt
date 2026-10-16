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
    fun hide(view: View) { inputMethodManager().hideSoftInputFromWindow(view.windowToken, 0) }

    /** Callback de mudança de visibilidade do teclado: (visível, altura ocupada). Original: a0.d */
    fun interface KeyboardListener { fun onChanged(visible: Boolean, height: Int) }

    private val listeners = HashMap<Int, KeyboardListener>()                                               // f7169a (por id da view)
    private val layoutListeners = HashMap<Int, android.view.ViewTreeObserver.OnGlobalLayoutListener>()     // f7170b
    private var keyboardVisible = false                                                                    // f7171c
    private var originalTop = 0                                                                            // f7172d
    private var decorHeight = 0                                                                            // f7173e
    private var shiftY = 0                                                                                 // f7174f (deslocamento negativo aplicado)

    /** Coleta recursivamente os EditText de [view] (sem entrar no teclado virtual). Original: i(View, List) */
    private fun collectEditTexts(view: View?, out: MutableList<android.widget.EditText>) {
        if (view == null || view is com.foxivid.ui.keyboard.KeyboardContainer) return
        if (view is android.widget.EditText) { out.add(view); return }
        if (view is android.view.ViewGroup) for (i in 0 until view.childCount) collectEditTexts(view.getChildAt(i), out)
    }

    /** EditText com foco dentro de [view]. Original: l(View) + m(List) */
    fun focusedEditText(view: View?): android.widget.EditText? {
        val list = ArrayList<android.widget.EditText>()
        collectEditTexts(view, list)
        return list.firstOrNull { it.hasFocus() }
    }

    /** Listener de layout global: considera o teclado aberto se ocupa mais de 1/4 da janela e avisa todos os [listeners]. Original: n(Window) + a0$a */
    private fun createLayoutListener(window: Window): android.view.ViewTreeObserver.OnGlobalLayoutListener =
        android.view.ViewTreeObserver.OnGlobalLayoutListener {
            val rect = android.graphics.Rect()
            window.decorView.getWindowVisibleDisplayFrame(rect)
            decorHeight = window.decorView.height
            val covered = decorHeight - (rect.bottom - rect.top)
            val open = covered > decorHeight / 4
            if ((!keyboardVisible || open) && (keyboardVisible || !open)) return@OnGlobalLayoutListener
            keyboardVisible = open
            for (l in listeners.values.toList()) l.onChanged(keyboardVisible, covered)
        }

    /** Registra o listener de layout da janela uma vez por [id]. Original: j(Window, int) */
    fun addLayoutListener(window: Window?, id: Int) {
        if (layoutListeners.containsKey(id) || window == null) return
        val l = createLayoutListener(window)
        window.decorView.viewTreeObserver.addOnGlobalLayoutListener(l)
        layoutListeners[id] = l
    }

    /** Remove o listener de layout de [id]. Original: p(Window, int) */
    fun removeLayoutListener(window: Window?, id: Int) {
        if (window == null) return
        layoutListeners[id]?.let { window.decorView.viewTreeObserver.removeOnGlobalLayoutListener(it) }
    }

    /** Sobe [view] quando o teclado cobre o EditText focado (só dentro de um fragment filho e sem teclado virtual global). Original: k(Fragment, View) */
    fun attachShiftOnKeyboard(fragment: androidx.fragment.app.Fragment, view: View?) {
        val window = fragment.requireActivity().window
        if (com.foxivid.ui.keyboard.KeyUtils.getCurrentKeyboard() == null && fragment.parentFragment != null && view != null) {
            addLayoutListener(window, view.id)
            listeners[view.id] = KeyboardListener { visible, height ->
                if (focusedEditText(view) != null) { if (visible) shiftForKeyboard(view, height) else restoreAfterKeyboard(view) }
            }
        }
    }

    /** Desfaz o registro feito por [attachShiftOnKeyboard]. Original: q(Fragment, View) */
    fun detachShiftOnKeyboard(fragment: androidx.fragment.app.Fragment, view: View) {
        val window = fragment.requireActivity().window
        listeners.remove(view.id)
        removeLayoutListener(window, view.id)
    }

    /** Estilo do teclado virtual do app (fundo, foco, cores, tipo de plataforma "C"/"B"). Original: o() */
    fun applyKeyboardStyle() {
        com.foxivid.ui.keyboard.KeyUtils.setKeyboardBackground(com.live.evo.R.drawable.key_bg)
        com.foxivid.ui.keyboard.KeyUtils.setFocusKeyBackground(com.live.evo.R.drawable.key_normal_focus)
        com.foxivid.ui.keyboard.KeyUtils.setNormalKeyBackground(com.live.evo.R.drawable.key_normal_unfocus)
        com.foxivid.ui.keyboard.KeyUtils.setKeyTextColor(com.live.evo.R.color.keyboard_key_textcolor)
        com.foxivid.ui.keyboard.KeyUtils.setPlatformType("C")
        com.foxivid.ui.keyboard.KeyUtils.setPlatformSubType("B")
    }

    /** Anima [view] para cima (Overshoot) o quanto falta para o EditText focado ficar acima do teclado. Original: t(View, int) */
    fun shiftForKeyboard(view: View, keyboardHeight: Int) {
        val edit = focusedEditText(view) ?: return
        val visibleBottom = decorHeight - keyboardHeight
        val loc = intArrayOf(0, 0)
        edit.getLocationInWindow(loc)
        if (loc[1] + edit.height > visibleBottom) shiftY = (visibleBottom - loc[1]) - edit.height
        if (shiftY < 0) {
            val anim = android.view.animation.TranslateAnimation(0f, 0f, 0f, shiftY.toFloat())
            anim.interpolator = android.view.animation.OvershootInterpolator()
            anim.setAnimationListener(object : android.view.animation.Animation.AnimationListener {   // a0$c
                override fun onAnimationEnd(a: android.view.animation.Animation?) {
                    view.clearAnimation()
                    val left = view.left
                    originalTop = view.top
                    setBounds(view, left, view.top + shiftY, view.width, view.height * 2)
                    view.requestLayout()
                }
                override fun onAnimationRepeat(a: android.view.animation.Animation?) {}
                override fun onAnimationStart(a: android.view.animation.Animation?) {}
            })
            view.startAnimation(anim)
        }
    }

    /** Volta [view] à posição original depois que o teclado fecha. Original: r(View) */
    fun restoreAfterKeyboard(view: View) {
        if (shiftY < 0) {
            val left = view.left
            val top = originalTop
            val width = view.width
            val height = view.height * 2
            view.layout(left, top, left + width, top + height)
            shiftY = 0
            setBounds(view, left, top, width, height)
        }
    }

    /** Aplica margem esquerda/superior e tamanho conforme o tipo de LayoutParams (Linear/Relative/Frame). Original: s(View,int,int,int,int) */
    fun setBounds(view: View, left: Int, top: Int, width: Int, height: Int) {
        when (val lp = view.layoutParams) {
            is android.widget.LinearLayout.LayoutParams -> { lp.setMargins(left, top, 0, 0); lp.width = width; lp.height = height; view.layoutParams = lp }
            is android.widget.RelativeLayout.LayoutParams -> { lp.setMargins(left, top, 0, 0); lp.width = width; lp.height = height; view.layoutParams = lp }
            is android.widget.FrameLayout.LayoutParams -> { lp.setMargins(left, top, 0, 0); lp.width = width; lp.height = height; view.layoutParams = lp }
        }
    }
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
class ImageCache private constructor(private val params: Params) {
    /** Parâmetros: tamanho do cache em KB (padrão 5 MB), qualidade de compressão (70), cache em memória ligado, cache em disco desligado. Original: y$b */
    class Params {
        @JvmField var memCacheSize = 5120
        @JvmField var compressQuality = 70
        @JvmField var memoryCacheEnabled = true
        @JvmField var diskCacheEnabled = false
    }

    private var memoryCache: android.util.LruCache<String, android.graphics.drawable.BitmapDrawable>? = null   // f7380a
    private var reusableBitmaps: MutableSet<java.lang.ref.SoftReference<Bitmap>>? = null                        // f7382c

    init {
        if (params.memoryCacheEnabled) {
            reusableBitmaps = java.util.Collections.synchronizedSet(HashSet())
            memoryCache = object : android.util.LruCache<String, android.graphics.drawable.BitmapDrawable>(params.memCacheSize) {
                /** Bitmaps removidos viram candidatos a reaproveitamento (`inBitmap`). */
                override fun entryRemoved(evicted: Boolean, key: String, oldValue: android.graphics.drawable.BitmapDrawable, newValue: android.graphics.drawable.BitmapDrawable?) {
                    reusableBitmaps!!.add(java.lang.ref.SoftReference(oldValue.bitmap))
                }
                /** Tamanho em KB (mínimo 1). */
                override fun sizeOf(key: String, value: android.graphics.drawable.BitmapDrawable): Int {
                    val kb = byteCountOf(value) / 1024
                    return if (kb == 0) 1 else kb
                }
            }
        }
    }

    /** Guarda o drawable na memória. Original: b(String, BitmapDrawable) */
    fun put(key: String?, drawable: android.graphics.drawable.BitmapDrawable?) {
        if (key == null || drawable == null || memoryCache == null) return
        memoryCache!!.put(key, drawable)
    }
    /** Original: b(String, BitmapDrawable) (alias de [put] usado por ModelHelper) */
    fun b(key: String?, drawable: android.graphics.drawable.BitmapDrawable?) = put(key, drawable)

    /** Drawable em cache ou null. Original: h(String) */
    fun get(key: String): android.graphics.drawable.BitmapDrawable? = memoryCache?.get(key)

    /** Bitmap mutável reaproveitável cujo tamanho comporta o decode de [options]. Original: i(Options) */
    protected fun reusableBitmapFor(options: android.graphics.BitmapFactory.Options): Bitmap? {
        val set = reusableBitmaps
        if (set == null || set.isEmpty()) return null
        var found: Bitmap? = null
        synchronized(set) {
            val it = set.iterator()
            while (it.hasNext()) {
                val bm = it.next().get()
                if (bm == null || !bm.isMutable) it.remove()
                else if (canUseForInBitmap(bm, options)) { it.remove(); found = bm; break }
            }
        }
        return found
    }

    /** Fragment sem UI que retém o [ImageCache] entre mudanças de configuração. Original: y$c */
    class RetainFragment : Fragment() {
        var cache: Any? = null
        override fun onCreate(savedInstanceState: android.os.Bundle?) { super.onCreate(savedInstanceState); retainInstance = true }
    }

    companion object {
        /** Bytes do bitmap. Original: j(BitmapDrawable) */
        fun byteCountOf(d: android.graphics.drawable.BitmapDrawable): Int = d.bitmap.byteCount

        /** Bytes por pixel da config. Original: k(Bitmap.Config) */
        private fun bytesPerPixel(config: Bitmap.Config?): Int = when (config) {
            Bitmap.Config.ARGB_8888 -> 4
            Bitmap.Config.RGB_565, Bitmap.Config.ARGB_4444 -> 2
            else -> 1
        }

        /** O bitmap [bitmap] comporta a imagem decodificada com [options] (inBitmap)? Original: e(Bitmap, Options) */
        private fun canUseForInBitmap(bitmap: Bitmap, options: android.graphics.BitmapFactory.Options): Boolean {
            val w = options.outWidth / options.inSampleSize
            val h = options.outHeight / options.inSampleSize
            return w * h * bytesPerPixel(bitmap.config) <= bitmap.byteCount
        }

        /** Marca inMutable e, se houver bitmap reaproveitável, define `inBitmap`. Original: c(Options, y) */
        private fun addInBitmapOptions(options: android.graphics.BitmapFactory.Options, cache: ImageCache?) {
            if (cache != null) {
                options.inMutable = true
                cache.reusableBitmapFor(options)?.let { options.inBitmap = it }
            }
        }

        /** inSampleSize (potência de 2) para caber em [reqWidth]x[reqHeight]. Original: d(Options, int, int) */
        fun calculateInSampleSize(options: android.graphics.BitmapFactory.Options, reqWidth: Int, reqHeight: Int): Int {
            val height = options.outHeight
            val width = options.outWidth
            var sample = 1
            if (height <= reqHeight && width <= reqWidth) return 1
            val halfHeight = height / 2
            val halfWidth = width / 2
            while (halfHeight / sample > reqHeight && halfWidth / sample > reqWidth) sample *= 2
            var totalPixels = ((width / sample) * (height / sample)).toLong()
            while (totalPixels > reqWidth.toLong() * reqHeight * 4) { sample *= 2; totalPixels /= 2 }
            return sample
        }

        /** Baixa a imagem em dois passos (limites, depois amostrada) via HTTP GET; null se falhar. Original: f(URL, int, int, y) */
        @Synchronized
        fun decodeSampledBitmapFromUrl(url: java.net.URL, reqWidth: Int, reqHeight: Int, cache: ImageCache? = null): Bitmap? {
            var result: Bitmap? = null
            try {
                val c1 = url.openConnection() as java.net.HttpURLConnection
                c1.connectTimeout = 3000
                c1.requestMethod = "GET"
                if (c1.responseCode == 200) {
                    val input = c1.inputStream
                    val options = android.graphics.BitmapFactory.Options()
                    options.inJustDecodeBounds = true
                    val bounds = android.graphics.BitmapFactory.decodeStream(input, null, options)
                    try {
                        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight)
                        options.inPreferredConfig = Bitmap.Config.ARGB_8888
                        input.close()
                        if (bounds != null && !bounds.isRecycled) bounds.recycle()
                        addInBitmapOptions(options, cache)
                        options.inJustDecodeBounds = false
                        val c2 = url.openConnection() as java.net.HttpURLConnection
                        c2.connectTimeout = 2000
                        c2.requestMethod = "GET"
                        val input2 = c2.inputStream
                        result = if (c2.responseCode == 200) android.graphics.BitmapFactory.decodeStream(input2, null, options) else bounds
                        input2.close()
                    } catch (_: Throwable) { result = bounds }
                }
            } catch (_: Throwable) {}
            return result
        }

        /** Obtém (ou cria, guardando num [RetainFragment] de tag "ImageCache") o cache do fragment manager. Original: l(FragmentManager, b) + g(...) */
        fun create(fragmentManager: androidx.fragment.app.FragmentManager, params: Params): ImageCache {
            var retain = fragmentManager.findFragmentByTag("ImageCache") as RetainFragment?
            if (retain == null) {
                retain = RetainFragment()
                fragmentManager.beginTransaction().add(retain, "ImageCache").commitAllowingStateLoss()
            }
            var cache = retain.cache as ImageCache?
            if (cache == null) { cache = ImageCache(params); retain.cache = cache }
            return cache
        }
    }
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
    /**
     * OkHttp: interceptor de headers (abaixo), eventListenerFactory de log de chamadas (h5.a, não reconstruído), timeouts de 15 s,
     * interceptor de rede que pede gzip em requests com corpo (f5.a), DNS próprio (mf.b = AppDns: resolve pelo resolvedor do app com timeout de 30 s e
     * cai no DNS do sistema) e `PersistentCookieJar` em SharedPreferences.
     */
    val client: okhttp3.OkHttpClient = okhttp3.OkHttpClient.Builder()
        .addInterceptor { chain ->
            val h = com.foxivid.baselib.network.HeaderInterceptor
            val req = chain.request().newBuilder()
                .addHeader("GetServerTime", "true")
                .addHeader("ClientTimeMS", java.lang.Long.toString(com.foxivid.baselib.util.ServerTime.now()))
                .addHeader("VnoId", h.tenantId().toString())
                .addHeader("BrandId", h.brandId().toString())
                .addHeader("AppId", h.appId().toString())
                .addHeader("VersionCode", h.appVersion().toString())
                .addHeader("MAC", h.mac())
                .addHeader("CPUSerial", h.serialNumber())
                .addHeader("UserId", baseUrl())
                .build()
            chain.proceed(req)
        }
        .readTimeout(15000L, java.util.concurrent.TimeUnit.MILLISECONDS)
        .connectTimeout(15000L, java.util.concurrent.TimeUnit.MILLISECONDS)
        .addNetworkInterceptor { chain ->
            val r = chain.request()
            if (r.body != null && r.header("Content-Encoding") == null) chain.proceed(r.newBuilder().header("Accept-Encoding", "gzip").build()) else chain.proceed(r)
        }
        .dns(com.foxivid.baselib.network.AppDns())   // mf.b
        .cookieJar(com.franmontiel.persistentcookiejar.PersistentCookieJar(
            com.franmontiel.persistentcookiejar.cache.SetCookieCache(),
            com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor(com.live.evo.MyApplication.get())))
        .build()

    /** Valor do header "UserId": id da conta do SDK (`InteractionUtils.Y()` = UserManager.C0()). Original: d() */
    fun baseUrl(): String = com.foxivid.baselib.user.UserManager.getAccountIdString()
    companion object {
        private var instance: ServerTimeClient? = null
        /** Original: b() */ fun get(): ServerTimeClient = instance ?: synchronized(this) { instance ?: ServerTimeClient().also { instance = it } }
    }
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
