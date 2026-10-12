package com.live.evo.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Movie
import android.graphics.Paint
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.leanback.widget.VerticalGridView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.live.evo.R
import com.live.evo.util.RxUtils
import java.util.Timer
import java.util.TimerTask

/*
 * Views customizadas simples do app. Resumo (lógica de desenho omitida quando puramente visual).
 */

/** Button base do app (só herda). Original: com/live/evo/widget/BaseButton.java */
open class BaseButton @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : Button(context, attrs)

/** TextView "light" (fonte leve). Original: com/live/evo/widget/LightTextView.java */
class LightTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : AppCompatTextView(context, attrs)

/** TextView que sempre se considera focada (marquee). Original: com/live/evo/widget/MarqueeTextView.java */
class MarqueeTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : AppCompatTextView(context, attrs) {
    override fun isFocused(): Boolean = true
}

/**
 * EditText que consome ENTER para não disparar ação padrão (onKeyDown/onKeyUp ignoram DPAD_CENTER/ENTER e
 * expõem `onEditorAction`). Original: com/live/evo/widget/RemoveKeyCodeEnterEditText.java
 */
open class RemoveKeyCodeEnterEditText @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : AppCompatEditText(context, attrs) {
    // TODO("parcial: onKeyDown/onKeyUp — ver widget/RemoveKeyCodeEnterEditText.java (79 linhas)")
}

/** EditText de código de recarga (formatação, `g()`). Original: com/live/evo/widget/RechargeEditText.java */
class RechargeEditText @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : RemoveKeyCodeEnterEditText(context, attrs)

/** Rótulo + RemoveKeyCodeEnterEditText (layout `label_removekeycode_edittext`). Original: com/live/evo/widget/LabelRemoveKeyCodeEnterEditText.java */
class LabelRemoveKeyCodeEnterEditText @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : LinearLayout(context, attrs) {
    init { LayoutInflater.from(context).inflate(R.layout.label_removekeycode_edittext, this, true) }
    fun getEditText(): RemoveKeyCodeEnterEditText = TODO("findViewById do EditText interno")
}

/** AutoComplete de e-mail com sugestões de domínios (layout de item `v_item_email`). Original: com/live/evo/widget/EmailAutoCompleteTextView.java */
class EmailAutoCompleteTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    AppCompatAutoCompleteTextView(context, attrs), TextView.OnEditorActionListener {
    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean = false // TODO("ver original")
}

/** ViewPager sem animação de troca e que repassa `executeKeyEvent`. Original: com/live/evo/widget/NoAnimationViewPager.java */
class NoAnimationViewPager @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : ViewPager(context, attrs) {
    override fun setCurrentItem(item: Int) = super.setCurrentItem(item, false)
    override fun setCurrentItem(item: Int, smoothScroll: Boolean) = super.setCurrentItem(item, false)
}

/** ListView sem over-scroll. Original: com/live/evo/widget/ProgramListView.java */
class ProgramListView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : ListView(context, attrs) {
    override fun setOverScrollMode(mode: Int) = super.setOverScrollMode(OVER_SCROLL_NEVER)
}

/** Lista vertical (leanback) de programas/canais com listeners de seleção/click. Original: com/live/evo/widget/ProgramRecycleView.java */
class ProgramRecycleView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : VerticalGridView(context, attrs)

/** RecyclerView com "empty view" e scroll vertical opcional. Original: com/live/evo/widget/EmptyRecyclerView.java */
class EmptyRecyclerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : RecyclerView(context, attrs) {
    var canVerticalScroll = true
    private var emptyView: View? = null
    fun setEmptyView(v: View?) { emptyView = v }
    override fun canScrollVertically(direction: Int): Boolean = canVerticalScroll && super.canScrollVertically(direction)
}

/** Layout de "carregando VOD" (`p_vod_cache`) com texto. Original: com/live/evo/widget/LoadView.java */
class LoadView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : RelativeLayout(context, attrs) {
    fun setText(text: String) { TODO("TextView do layout p_vod_cache") }
}

/** Animação de loading do VOD (layout `vod_load_anim`). Original: com/live/evo/widget/VodLoadAnimation.java */
class VodLoadAnimation @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : LinearLayout(context, attrs) {
    init { LayoutInflater.from(context).inflate(R.layout.vod_load_anim, this, true) }
}

/** Barra de abas horizontal dos menus (backgrounds `menu*_fragment_tab_bg_*`). Original: com/live/evo/widget/MenuTabLayout.java */
class MenuTabLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : HorizontalScrollView(context, attrs) {
    // TODO("parcial: abas selecionável/foco — 586 linhas de View customizada")
}

/**
 * Texto rolante (marquee de anúncios): desloca o texto a `speed` px/frame (padrão 4) via Timer + invalidate
 * (usando [RxUtils.runOnUiThread]); repete `displayTimes` vezes. Clique reinicia.
 * Original: com/live/evo/widget/SpeedTextView.java
 */
class SpeedTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : AppCompatTextView(context, attrs), View.OnClickListener {
    var running = false
    private var paint: Paint? = null
    private var timer: Timer? = null
    private var task: TimerTask? = null
    private var displayTimes = 0
    override fun isFocused(): Boolean = true
    fun setDisplayTimes(times: Int) { displayTimes = times }
    fun stop() { running = false; task?.cancel(); invalidate() }
    fun start() { if (running) return; running = true; invalidate() }
    override fun onClick(v: View?) { if (running) { stop(); start() } }
    companion object { @JvmStatic fun getSpeed() = 4 }
}

/** Barra de progresso circular. Original: com/live/evo/widget/CircleProgressBar.java (+ `RoundProgressView`, `GaugeView`: medidores desenhados em Canvas) */
class CircleProgressBar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {
    var progress = 0f
    fun setProgressWithAnimation(value: Float) { progress = value; invalidate() }
}

/** Medidor semicircular (value, angles, cores). Original: com/live/evo/widget/GaugeView.java */
class GaugeView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {
    var value = 0
    fun setValue(v: Int) { value = v; invalidate() }
}

/** Progresso redondo. Original: com/live/evo/widget/RoundProgressView.java */
class RoundProgressView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {
    var max = 100f; var progress = 0f
}

/** GIF desenhado via android.graphics.Movie. Original: com/live/evo/widget/GifView.java */
class GifView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {
    var movie: Movie? = null
    fun setMovieResource(id: Int) { movie = Movie.decodeStream(resources.openRawResource(id)) }
}

/** View de teste de rede / medidor (sem lógica relevante). Original: com/live/evo/widget/NetView.java; FreeTrialView.java (selo de teste) */
class NetView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : View(context, attrs)
class FreeTrialView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : View(context, attrs)

/** Banner de anúncios (youth.banner.Banner) com click listener `w4.a`. Original: com/live/evo/widget/AdBannerView.java */
class AdBannerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : com.youth.banner.Banner<Any, com.youth.banner.adapter.BannerAdapter<Any, RecyclerView.ViewHolder>>(context, attrs)
