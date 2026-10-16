package com.foxivid.ui.mobile.ext

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.StyleSpan
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.foxivid.baselib.config.BaseLibConfig
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.hjq.toast.Toaster
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import java.io.File

/*
 * Funções de extensão da biblioteca mobile (com.tvc.lib.mobile.ext). Cada arquivo original é
 * uma classe estática de funções top-level do Kotlin; aqui estão reunidas em um só arquivo.
 *
 * Original: com/tvc/lib/mobile/ext/a.java (ActivityExt.kt), d.java (ViewExt.kt: clique com
 * debounce), e.java (ContextExt.kt), f.java (EventBusExt.kt), g.java (ImageViewExt.kt),
 * h.java (ToastExt.kt/LogExt.kt), i.java (TabLayoutExt.kt), j.java (ViewVisible.kt),
 * l.java (ViewPager2Ext.kt)
 */

// ===== ActivityExt.kt (ext/a.java) =====

/**
 * Contagem regressiva em Flow: emite time, time-1, ..., 0 (aguardando 1 s entre emissões, exceto
 * antes da primeira). [start] roda no onStart (com o escopo), [end] no onCompletion, erros vão
 * para Log.e (mensagem "Unkown Error" se nula).
 * Original: ext/a.a(AppCompatActivity, int, l, l, a)  (corrotina ActivityExtKt$countDown$1)
 */
fun AppCompatActivity.countDown(
    time: Int,
    start: (CoroutineScope) -> Unit,
    next: (Int) -> Unit,
    end: () -> Unit
) {
    lifecycleScope.launch {
        val scope = this
        flow {
            for (i in time downTo 0) {
                if (i != time) delay(1000L)
                emit(i)
            }
        }
            .onStart { start(scope) }
            .onCompletion { end() }
            .catch { Log.e("", it.message ?: "Unkown Error") }
            .collect { next(it) }
    }
}

/** Liga/desliga ícones escuros da barra de status (SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = 8192). Original: ext/a.b */
fun Activity.setLightStatusBar(light: Boolean) {
    if (Build.VERSION.SDK_INT >= 23) {
        val flags = window.decorView.systemUiVisibility
        window.decorView.systemUiVisibility = if (light) flags or 8192 else flags and 8192.inv()
    }
}

/**
 * Janela transparente (status/navigation bar com cor 0) com drawable de fundo; opcionalmente
 * ajusta a barra clara. Original: ext/a.c
 */
fun Activity.setTransparentSystemBars(backgroundRes: Int, lightStatusBar: Boolean? = null) {
    val sdk = Build.VERSION.SDK_INT
    val w = window
    if (w != null) {
        w.clearFlags(67108864)   // FLAG_TRANSLUCENT_STATUS
        w.clearFlags(134217728)  // FLAG_TRANSLUCENT_NAVIGATION
        w.addFlags(Int.MIN_VALUE) // FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
        w.statusBarColor = 0
        w.navigationBarColor = 0
        val drawable: Drawable? = ResourcesCompat.getDrawable(resources, backgroundRes, null)
        if (drawable != null) {
            // original: new a8.a(drawable, drawable) — wrapper de Drawable; não reconstruído
            window.setBackgroundDrawable(drawable)
        }
        if (sdk >= 29) w.isNavigationBarContrastEnforced = false
        w.decorView.systemUiVisibility = 1280
    }
    if (lightStatusBar != null) setLightStatusBar(lightStatusBar)
}

// ===== ViewExt.kt (ext/d.java): clique com debounce global =====

private var lastClickTime = 0L

/** Clique com debounce (padrão 500 ms), compartilhado entre todas as views. Original: ext/d.c/d */
fun View.setOnClickDebounced(intervalMs: Long = 500, action: (View) -> Unit) {
    setOnClickListener { v ->
        val now = System.currentTimeMillis()
        if (lastClickTime != 0L && now - lastClickTime < intervalMs) return@setOnClickListener
        lastClickTime = now
        action(v)
    }
}

/** Original: ext/d.e */
fun setOnClickDebounced(views: Array<View?>, intervalMs: Long = 500, onClick: (View) -> Unit) {
    for (view in views) view?.setOnClickDebounced(intervalMs) { onClick(it) }
}

// ===== ContextExt.kt (ext/e.java) =====

/** true se o contexto é nulo ou a activity está finalizando/destruída. Original: ext/e.a */
fun isContextGone(context: Context?): Boolean {
    if (context == null) return true
    if (context is Activity) return context.isFinishing || context.isDestroyed
    if (context !is FragmentActivity) return false
    return context.isFinishing || context.isDestroyed
}

/** Baixa um arquivo com Glide (bloqueante); null em erro. Original: ext/e.b */
fun downloadFile(context: Context?, url: String): File? {
    if (isContextGone(context)) return null
    return try {
        Glide.with(context!!).downloadOnly().load(url).submit().get()
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

// ===== EventBusExt.kt (ext/f.java) =====

/** Original: ext/f.a */
fun postMessage(code: Int, msg: String? = null, data: Any? = null) {
    EventBus.getDefault().post(MessageEventData(code, msg, data))
}

/** Original: ext/f.c */
fun registerEventBus(subscriber: Any) {
    if (!EventBus.getDefault().isRegistered(subscriber)) EventBus.getDefault().register(subscriber)
}

/** Original: ext/f.d */
fun unregisterEventBus(subscriber: Any) {
    if (EventBus.getDefault().isRegistered(subscriber)) EventBus.getDefault().unregister(subscriber)
}

// ===== ImageViewExt.kt (ext/g.java) =====

private fun glideFor(view: AppCompatImageView): RequestManager? {
    val context = view.context
    if (context is AppCompatActivity && (context.isFinishing || context.isDestroyed)) return null
    return Glide.with(context)
}

private fun baseOptions(placeholder: Int): RequestOptions {
    val o = RequestOptions()
    if (placeholder > 0) {
        o.placeholder(placeholder)
        o.error(placeholder)
    }
    o.diskCacheStrategy(DiskCacheStrategy.ALL) // l.j.f15048a
    o.skipMemoryCache(false)                   // k0(false) -> useAnimationPool/skipMemory
    return o
}

private fun roundedOptions(radius: Int, placeholder: Int): RequestOptions =
    baseOptions(placeholder).transform(CenterCrop(), RoundedCorners(radius))

/** Carrega um recurso com cantos arredondados (padrão: placeholder brand_logo, raio 4). Original: ext/g.d */
fun AppCompatImageView.loadRes(resId: Int, placeholder: Int /* R.drawable.brand_logo */, radius: Int = 4) {
    glideFor(this)?.load(resId)?.apply(roundedOptions(radius, placeholder))?.into(this)
}

/** Carrega uma URL com cantos arredondados (padrão: placeholder brand_logo, raio 4). Original: ext/g.e */
fun AppCompatImageView.loadUrl(url: String?, placeholder: Int /* R.drawable.brand_logo */, radius: Int = 4) {
    glideFor(this)?.load(url)?.apply(roundedOptions(radius, placeholder))?.into(this)
}

// ===== ToastExt.kt / LogExt.kt (ext/h.java) =====

private fun isAppInForeground(context: Context): Boolean {
    val am = context.getSystemService("activity") as ActivityManager
    val processes = am.runningAppProcesses ?: return false
    for (p in processes) {
        if (p.processName == context.packageName && p.importance == 100) return true
    }
    return false
}

/** Log.d apenas se BaseLibConfig.isDebug (b.t()). Original: ext/h.b */
fun logDebug(message: String) {
    if (BaseLibConfig.isDebug) Log.d("LogExt", message)
}

/** Log.w. Original: ext/h.c */
fun logWarn(message: String) {
    Log.w("LogExt", message)
}

/** Toast de sucesso (ícone toast_img_success). Original: ext/h.e/f */
fun toastSuccess(text: String?, context: Context) = showToast(text, context)

/** Toast simples. Original: ext/h.g */
fun toastNormal(text: String?, context: Context) = showToast(text, context)

/** Toast curto via Toaster, só com o app em primeiro plano e activity viva. Original: ext/h.d */
private fun showToast(text: String?, context: Context) {
    if (TextUtils.isEmpty(text)) {
        toastNormal("The content of the toast must not be empty", context)
        return
    }
    if (!isAppInForeground(context)) return
    if (context is Activity && (context.isFinishing || context.isDestroyed)) {
        logWarn("activity" + context.javaClass.simpleName + " is finishing, toast of \"" + text + "\" won't be shown")
        return
    }
    Toaster.showShort(text as CharSequence)
}

// ===== TabLayoutExt.kt (ext/i.java) =====

/** Texto da aba selecionada em negrito. Original: ext/i.b */
fun TabLayout?.boldSelectedTab() {
    this?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab?) { setTabBold(tab, true) }
        override fun onTabUnselected(tab: TabLayout.Tab?) { setTabBold(tab, false) }
        override fun onTabReselected(tab: TabLayout.Tab?) {}
    })
}

/** Original: ext/i.c */
fun setTabBold(tab: TabLayout.Tab?, bold: Boolean) {
    if (tab == null || tab.text == null) return
    val text = tab.text.toString().trim()
    val span = SpannableString(text)
    span.setSpan(if (bold) StyleSpan(1) else StyleSpan(0), 0, text.length, 17)
    tab.text = span
}

// ===== ViewVisible.kt (ext/j.java) =====

/** VISIBLE/GONE. Original: ext/j.a */
fun View.setVisible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

// ===== ViewPager2Ext.kt (ext/l.java) =====

/** ViewPager2 sem swipe nem saveState, com lista de fragments. Original: ext/l.b (padrão offscreen -1) */
fun ViewPager2.setupFragments(fm: FragmentManager, lifecycle: Lifecycle, fragments: List<Fragment>, offscreenLimit: Int = -1) {
    adapter = object : FragmentStateAdapter(fm, lifecycle) {
        override fun createFragment(position: Int): Fragment = fragments[position]
        override fun getItemCount(): Int = fragments.size
    }
    isSaveEnabled = false
    isUserInputEnabled = false
    offscreenPageLimit = offscreenLimit
}

/** Liga um TabLayout ao ViewPager2 com os títulos. Original: ext/l.d */
fun ViewPager2.attachTabs(tabLayout: TabLayout?, titles: List<String>) {
    if (tabLayout == null) return
    val mediator = TabLayoutMediator(tabLayout, this) { tab, position -> tab.text = titles[position] }
    if (mediator.isAttached) return
    mediator.attach()
}
