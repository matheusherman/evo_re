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
 * EditText para D-pad: BAIXO não é tratado (retorna false p/ navegação de foco); CIMA com campo vazio/cursor no início,
 * ESQUERDA no início e DIREITA no fim também deixam o foco sair; ENTER (66) vira DPAD_CENTER (23) em down/up.
 * [onEditorAction] move o foco (5 = next, 7 = previous) ou esconde o teclado (6 = done).
 * Original: com/live/evo/widget/RemoveKeyCodeEnterEditText.java
 */
open class RemoveKeyCodeEnterEditText @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = androidx.appcompat.R.attr.editTextStyle) :
    AppCompatEditText(context, attrs, defStyle) {
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        var code = keyCode
        if (code == 20) return false
        val length = text?.length ?: 0
        val sel = selectionStart
        if ((length == 0 || sel == 0) && code == 19) return false
        if (code == 21 && sel <= 0) return false
        if (code == 22 && sel >= length) return false
        if (code == 66) code = 23
        return super.onKeyDown(code, event)
    }
    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean = super.onKeyUp(if (keyCode == 66) 23 else keyCode, event)
    override fun onEditorAction(actionCode: Int) {
        val imm = com.live.evo.util.KeyboardUtils.inputMethodManager()
        when {
            actionCode == 5 -> focusSearch(2)?.let { if (!it.requestFocus(2)) throw IllegalStateException("focus search returned a view that wasn't able to take focus!") }
            actionCode == 7 -> focusSearch(1)?.let { if (!it.requestFocus(1)) throw IllegalStateException("focus search returned a view that wasn't able to take focus!") }
            actionCode == 6 && imm.isActive(this) -> imm.hideSoftInputFromWindow(windowToken, 0)
        }
    }
}

/**
 * EditText de código de recarga: só dígitos, '*' e espaço; formata em grupos de 4 separados por espaço enquanto digita
 * (preservando o cursor). Original: com/live/evo/widget/RechargeEditText.java (`g()` = configuração; watcher interno `a`)
 */
class RechargeEditText @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = androidx.appcompat.R.attr.editTextStyle) :
    RemoveKeyCodeEnterEditText(context, attrs, defStyle) {
    private var lastFormatted = ""
    private var changeBefore = 0   // f7531d: caracteres removidos
    init {
        inputType = 2
        if (inputType == 3 || inputType == 2) keyListener = android.text.method.DigitsKeyListener.getInstance("0123456789* ")
        addTextChangedListener(object : android.text.TextWatcher {
            override fun afterTextChanged(editable: android.text.Editable) {
                removeTextChangedListener(this)
                try {
                    val raw = editable.toString().replace(" ", "")
                    var out = ""
                    var i = 0
                    while (i + 4 < raw.length) { out += raw.substring(i, i + 4) + " "; i += 4 }
                    out += raw.substring(i, raw.length)
                    val sel = selectionStart
                    if (lastFormatted.isEmpty() || out != lastFormatted) {
                        lastFormatted = out
                        editable.replace(0, editable.length, out)
                        if (sel % 5 == 0 && changeBefore == 0) { if (sel + 1 <= lastFormatted.length) setSelection(sel + 1) else setSelection(lastFormatted.length) }
                        else if (changeBefore == 1 && sel < lastFormatted.length) setSelection(sel)
                        else if (changeBefore != 0 || sel >= lastFormatted.length) setSelection(lastFormatted.length)
                        else setSelection(sel)
                    }
                } catch (_: Exception) {
                } finally { addTextChangedListener(this) }
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { changeBefore = before }
            override fun beforeTextChanged(s: CharSequence?, a: Int, b: Int, c: Int) {}
        })
    }
}

/** Rótulo + RemoveKeyCodeEnterEditText (layout `label_removekeycode_edittext`). Original: com/live/evo/widget/LabelRemoveKeyCodeEnterEditText.java */
class LabelRemoveKeyCodeEnterEditText @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : LinearLayout(context, attrs) {
    init { LayoutInflater.from(context).inflate(R.layout.label_removekeycode_edittext, this, true) }
    fun getEditText(): RemoveKeyCodeEnterEditText = TODO("findViewById do EditText interno")
}

/**
 * AutoComplete de e-mail: após digitar "@" sugere os domínios configurados (padrão
 * "gmail.com,hotmail.com,outlook.com,yahoo.com,yahoo.com.br"; configurável por [setDomains] — chave remota `email_domains`).
 * BAIXO/CIMA navegam na lista (CIMA no primeiro item fecha o popup); OK abre o teclado; BACK fecha o popup; ação "next" move o foco.
 * Original: com/live/evo/widget/EmailAutoCompleteTextView.java (adapter interno `a` com Filter)
 */
class EmailAutoCompleteTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    AppCompatAutoCompleteTextView(context, attrs), TextView.OnEditorActionListener {
    private val imm = context.getSystemService("input_method") as android.view.inputmethod.InputMethodManager
    private var showingKeyboardFromKey = false
    private var domains: List<String> = ArrayList()
    private val suggestions = ArrayList<String>()
    init { setOnEditorActionListener(this) }

    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId != 5) return false
        focusSearch(130)?.requestFocus()
        return true
    }

    /** Define os domínios (CSV) e reconstrói o adapter. Original: c(String, boolean) */
    fun setDomains(csv: String?, @Suppress("UNUSED_PARAMETER") flag: Boolean) {
        if (csv.isNullOrEmpty()) return
        val arr = csv.trim().split(",").map { it }.toTypedArray()
        if (arr.isEmpty()) return
        domains = arr.toList()
        dropDownHeight = Math.min(domains.size, 5) * resources.getDimension(com.live.evo.R.dimen.sm_50).toInt()
        dropDownVerticalOffset = 10
        setDropDownBackgroundResource(2131099811)
        threshold = 1
        setAdapter(EmailAdapter())
    }

    private inner class EmailAdapter : android.widget.BaseAdapter(), android.widget.Filterable {
        private val at = "@"
        override fun getItemId(position: Int) = position.toLong()
        override fun getCount() = suggestions.size
        override fun getItem(position: Int): Any = suggestions[position]
        override fun getView(position: Int, convertView: View?, parent: android.view.ViewGroup): View {
            val v = convertView ?: LayoutInflater.from(parent.context).inflate(R.layout.v_item_email, parent, false)
            (v as TextView).text = getItem(position) as CharSequence
            return v
        }
        override fun getFilter() = object : android.widget.Filter() {
            override fun performFiltering(cs: CharSequence?): FilterResults? {
                if (cs.isNullOrEmpty()) return null
                val s = cs.toString()
                // conta ocorrências de "@" (o original usa um Matcher; só filtra quando há exatamente uma)
                val count = java.util.regex.Pattern.compile(java.util.regex.Pattern.quote(at)).matcher(cs).let { m -> var n = 0; while (m.find()) n++; n }
                if (count != 1) return null
                val out = ArrayList<String>()
                val atIdx = s.indexOf(at)
                if (s.length - atIdx == 1) {
                    for (d in domains) {
                        if (d.indexOf(s) >= 0) out.add(d.trim()) else if (d.indexOf(at) < 0) out.add(cs.toString() + d.trim())
                    }
                } else {
                    val typed = s.substring(atIdx).replace("@", "")
                    for (d in domains) {
                        if (d.indexOf(s) >= 0) out.add(d.trim())
                        else if (d.startsWith(typed) && typed != d.trim() && d.indexOf(at) < 0) out.add(cs.toString() + d.replace(typed, ""))
                    }
                }
                return FilterResults().also { it.values = out; it.count = out.size }
            }
            @Suppress("UNCHECKED_CAST")
            override fun publishResults(cs: CharSequence?, results: FilterResults?) {
                suggestions.clear()
                suggestions.addAll((results?.values as? Collection<String>) ?: emptyList())
                notifyDataSetChanged()
            }
        }
    }

    override fun onKeyPreIme(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode != 19) return false
        if (event.action == KeyEvent.ACTION_UP) return true
        val sel = listSelection
        if (sel > 0) { listSelection = sel - 1; return true }
        if (sel != 0) return false
        dismissDropDown()
        return true
    }
    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        if ((keyCode == 23 || keyCode == 66) && listSelection == -1) {
            if (requestFocus()) { showingKeyboardFromKey = true; imm.showSoftInput(this, 0); return true }
        } else if (isPopupShowing && (keyCode == 4 || keyCode == 111)) { dismissDropDown(); return true }
        return try { super.onKeyUp(keyCode, event) } catch (e: Exception) { true }
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean = try { super.onKeyDown(keyCode, event) } catch (e: Exception) { true }
    override fun performLongClick(): Boolean {
        if (!showingKeyboardFromKey) return super.performLongClick()
        showingKeyboardFromKey = false
        return true
    }
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
