package com.live.evo.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Movie
import android.graphics.Paint
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.LayoutInflater
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
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
import com.live.evo.util.CommonUtils
import com.live.evo.util.RxUtils
import com.live.evo.util.TextStyleUtils
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

/**
 * Rótulo + [RemoveKeyCodeEnterEditText] (layout `label_removekeycode_edittext`). Atributos XML (sem namespace; recurso ou valor direto):
 * `labelPosition`, `labelText`, `labelFontSize` (padrão 18), `labelColor` (padrão `text_hint_color_normal`), `editLenght` (padrão 50),
 * `editInputType` (padrão 1 = TYPE_CLASS_TEXT), `editStyle` (padrão `LabelEditTextStyle`), `editHintText`. Sem `labelText` o rótulo some.
 * Original: com/live/evo/widget/LabelRemoveKeyCodeEnterEditText.java
 */
class LabelRemoveKeyCodeEnterEditText @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : LinearLayout(context, attrs, defStyle) {
    private var editText: RemoveKeyCodeEnterEditText? = null      // f7461a
    private var labelView: TextView? = null                       // f7462b
    private var labelText: String? = null
    private var labelPosition: String? = null
    private var labelFontSize = 18
    private var labelColor = R.color.text_hint_color_normal
    private var editLength = 50
    private var editInputType = 1
    private var editStyle = R.style.LabelEditTextStyle
    private var editHint: String? = null

    private fun stringAttr(attrs: AttributeSet?, name: String): String? {
        val res = attrs!!.getAttributeResourceValue(null, name, 0)
        return if (res != 0) resources.getString(res) else attrs.getAttributeValue(null, name)
    }
    private fun intAttr(attrs: AttributeSet?, name: String, dft: Int): Int {
        val res = attrs!!.getAttributeResourceValue(null, name, 0)
        return if (res != 0) resources.getInteger(res) else attrs.getAttributeIntValue(null, name, dft)
    }

    init {
        labelPosition = stringAttr(attrs, "labelPosition")
        labelText = stringAttr(attrs, "labelText")
        labelFontSize = intAttr(attrs, "labelFontSize", 18)
        labelColor = intAttr(attrs, "labelColor", R.color.text_hint_color_normal)
        editLength = intAttr(attrs, "editLenght", 50)
        editInputType = intAttr(attrs, "editInputType", 1)
        editStyle = intAttr(attrs, "editStyle", R.style.LabelEditTextStyle)
        editHint = stringAttr(attrs, "editHintText")
        (context.getSystemService("layout_inflater") as LayoutInflater).inflate(R.layout.label_removekeycode_edittext, this)
        labelView = findViewById(R.id.tv_label)
        TextStyleUtils.c(labelView)
        if (TextUtils.isEmpty(labelText)) labelView!!.visibility = View.GONE
        else {
            labelView!!.text = labelText
            labelView!!.textSize = labelFontSize.toFloat()
            labelView!!.setTextColor(CommonUtils.color(labelColor))
        }
        editText = findViewById(R.id.et_codetext)
        TextStyleUtils.c(editText)
        editText!!.inputType = editInputType
        editText!!.filters = arrayOf(android.text.InputFilter.LengthFilter(editLength))
        editText!!.setTextAppearance(context, editStyle)
        editText!!.hint = editHint
    }

    /** O EditText interno. Original: getRemoveKeyCodeEnterEditText() */
    fun getEditText(): RemoveKeyCodeEnterEditText = editText!!
    /** Troca o id do EditText interno. Original: setEditId(int) */
    fun setEditId(id: Int) { editText?.id = id }
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
class LoadView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : RelativeLayout(context, attrs, defStyle) {
    private val rotateImage: NetView
    private val trafficText: TextView      // pvodcache_tv_traffic
    private val trafficUnit: TextView      // pvodcache_tv_traffic_kbs
    init {
        val v = LayoutInflater.from(context).inflate(R.layout.p_vod_cache, this)
        rotateImage = v.findViewById(R.id.pvodcache_iv_rotate_image)
        trafficText = v.findViewById(R.id.pvodcache_tv_traffic)
        trafficUnit = v.findViewById(R.id.pvodcache_tv_traffic_kbs)
        TextStyleUtils.b(trafficText)
        TextStyleUtils.b(trafficUnit)
    }
    /** Mostra a velocidade e a unidade fixa " kb/s". Original: setText(String) */
    fun setText(text: String) { trafficText.text = text; trafficUnit.text = " kb/s" }
}

/** Animação de loading do VOD (layout `vod_load_anim`). Original: com/live/evo/widget/VodLoadAnimation.java */
class VodLoadAnimation @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : LinearLayout(context, attrs) {
    init { LayoutInflater.from(context).inflate(R.layout.vod_load_anim, this, true) }
}

/** Barra de abas horizontal dos menus (backgrounds `menu*_fragment_tab_bg_*`). Original: com/live/evo/widget/MenuTabLayout.java */
class MenuTabLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : HorizontalScrollView(context, attrs, defStyle) {
    /** Listener de seleção de aba. Original: MenuTabLayout.a (`a` = desmarcada, `b` = marcada) */
    interface OnTabSelectedListener {
        fun onTabUnselected(tab: Tab, position: Int)
        fun onTabSelected(tab: Tab, position: Int)
    }

    private val tabs = ArrayList<Tab>()                          // f7480b
    private var selectedTab: Tab? = null                         // f7481c
    private var selectedPosition = -1                            // f7482d
    private var tabsMargin = 0                                   // f7483e
    private var loopNavigation = false                           // f7484f: setas laterais circulam
    private val tabContainer: LinearLayout                       // f7485g
    private var mode = 1                                         // f7486h: 1 = peso igual (centro), 2 = rola centralizando, 3 = rola até aparecer
    private var dispatchKeyMode = 1                              // f7487i: 1 consome, 2 libera ESQ no início, 3 libera DIR no fim, 4 ambos
    private var tabIsSelected = true                             // f7488j
    private val listeners = ArrayList<OnTabSelectedListener>()   // f7489k
    private var viewPager: androidx.viewpager.widget.ViewPager? = null
    private var pageChangeListener: androidx.viewpager.widget.ViewPager.OnPageChangeListener? = null
    private var viewPagerListener: OnTabSelectedListener? = null
    private var checkShowText = false                            // f7493o
    private val tabBackgroundRes: Int                            // f7479a (atributo styleable MenuTabLayout[0])

    /** Sincroniza a aba com o ViewPager: ao trocar de página seleciona a aba. Original: MenuTabLayout.b */
    private class PageChangeListener(layout: MenuTabLayout) : androidx.viewpager.widget.ViewPager.OnPageChangeListener {
        private val ref = java.lang.ref.WeakReference(layout)
        private var previousState = 0; private var currentState = 0
        override fun onPageScrollStateChanged(state: Int) { previousState = currentState; currentState = state }
        override fun onPageSelected(position: Int) {
            val l = ref.get()
            if (l == null || l.selectedTabPosition == position || position >= l.tabCount) return
            l.setSelectTabView(position)
        }
        override fun onPageScrolled(position: Int, offset: Float, offsetPixels: Int) {}
    }

    /** Aba (FrameLayout) com fundo normal/selecionado/sem foco e conteúdo [customView]. Original: MenuTabLayout.c */
    inner class Tab(context: Context) : FrameLayout(context) {
        private var customView: View? = null
        init { if (tabBackgroundRes != 0) androidx.core.view.ViewCompat.setBackground(this, androidx.appcompat.content.res.AppCompatResources.getDrawable(context, tabBackgroundRes)) }
        /** Define o conteúdo (já com padding 4 e MATCH em altura). Original: a(View) + b() */
        fun setCustomView(view: View?): Tab {
            customView = view
            androidx.core.view.ViewCompat.setBackground(this, androidx.appcompat.content.res.AppCompatResources.getDrawable(context, R.drawable.menu_fragment_tab_bg_normal))
            if (customView != null) { setPadding(4, 4, 4, 4); addView(customView, LayoutParams(-2, -1)) }
            return this
        }
        fun getCustomView(): View? = customView
        override fun setSelected(selected: Boolean) {
            super.setSelected(selected)
            if (selected) {
                androidx.core.view.ViewCompat.setBackground(tabAt(selectedPosition), androidx.appcompat.content.res.AppCompatResources.getDrawable(context, R.drawable.menub_fragment_tab_bg_selected))
                findViewById<View>(R.id.tab_title).isSelected = selected
                findViewById<View>(R.id.tab_bottom_line).visibility = View.GONE
            } else {
                androidx.core.view.ViewCompat.setBackground(this, androidx.appcompat.content.res.AppCompatResources.getDrawable(context, R.drawable.menub_fragment_tab_bg_normal))
                findViewById<View>(R.id.tab_title).isEnabled = selected
                findViewById<View>(R.id.tab_title).isSelected = selected
                findViewById<View>(R.id.tab_bottom_line).visibility = View.GONE
            }
            customView?.isSelected = selected
        }
    }

    /** Listener que troca a página do ViewPager (via post) quando a aba é marcada. Original: MenuTabLayout.d */
    private class ViewPagerSelectedListener(private val pager: androidx.viewpager.widget.ViewPager?) : OnTabSelectedListener {
        override fun onTabSelected(tab: Tab, position: Int) {
            val p = pager
            if (p == null || p.currentItem == position) return
            try { p.post { p.currentItem = position } } catch (e: Exception) { e.printStackTrace() }
        }
        override fun onTabUnselected(tab: Tab, position: Int) {}
    }

    init {
        tabBackgroundRes = context.obtainStyledAttributes(attrs, R.styleable.MenuTabLayout, 0, 0).getResourceId(0, 0)
        isFocusable = true
        isFocusableInTouchMode = true
        isHorizontalScrollBarEnabled = false
        isFillViewport = true
        tabContainer = LinearLayout(context)
        tabContainer.orientation = LinearLayout.HORIZONTAL
        tabContainer.isFocusable = false
        tabContainer.isFocusableInTouchMode = false
        applyGravity()
        addView(tabContainer, FrameLayout.LayoutParams(-2, -1))
    }

    val tabCount: Int get() = tabs.size
    val selectedTabPosition: Int get() = selectedPosition
    fun getMode(): Int = mode

    /** Cria uma aba vazia (não focável). Original: l() */
    fun newTab(): Tab = Tab(context).also { it.isFocusable = false }
    /** Aba na posição ou null. Original: k(int) */
    fun tabAt(position: Int): Tab? = if (position < 0 || position >= tabCount) null else tabs[position]

    /** Adiciona a aba (não focável, título desmarcado); se for a selecionada, seleciona. Original: d(c) + e(c, int) */
    fun addTab(tab: Tab) {
        tab.isFocusable = false
        tab.isFocusableInTouchMode = false
        tab.findViewById<View>(R.id.tab_title).isEnabled = false
        tab.findViewById<View>(R.id.tab_title).isSelected = false
        tabs.add(tab)
        tabContainer.addView(tab, tabLayoutParams())
        if (selectedPosition == tabs.indexOf(tab)) setSelectTabView(selectedPosition)
    }

    /** Remove todas as abas. Original: g() */
    fun removeAllTabs() { if (tabs.isEmpty()) return; tabs.clear(); tabContainer.removeAllViews() }

    private fun applyGravity() { when (mode) { 1 -> tabContainer.gravity = android.view.Gravity.CENTER; 2, 3 -> tabContainer.gravity = android.view.Gravity.CENTER_VERTICAL } }   // f()

    private fun tabLayoutParams(): LinearLayout.LayoutParams {
        val lp = LinearLayout.LayoutParams(-2, -1)
        lp.leftMargin = tabsMargin
        if (mode == 1) { lp.width = 0; lp.weight = 1.0f } else { lp.width = -2; lp.weight = 0.0f }   // p(LayoutParams)
        return lp
    }

    private fun dispatchSelected(tab: Tab, position: Int) { for (i in listeners.size - 1 downTo 0) listeners[i].onTabSelected(tab, position) }       // i
    private fun dispatchUnselected(tab: Tab, position: Int) { for (i in listeners.size - 1 downTo 0) listeners[i].onTabUnselected(tab, position) }    // j

    /** Rola o HorizontalScrollView para mostrar a aba selecionada (modos 2 = centraliza, 3 = só até aparecer). Original: n() */
    private fun scrollToSelected() {
        val tab = selectedTab ?: return
        if (mode == 3 || mode == 2) {
            val width = measuredWidth
            val scrollX = scrollX
            val x = tab.x.toInt()
            val tabWidth = tab.measuredWidth
            val contentWidth = tabContainer.measuredWidth
            if (mode == 2) {
                val center = x + tabWidth / 2
                val half = width / 2
                if (center < half || center > contentWidth - half || center == scrollX + half) return
                smoothScrollTo(center - half, 0)
                return
            }
            val right = tabWidth + x
            if (right > width + scrollX) smoothScrollTo(right - width, 0)
            else if (scrollX > x) smoothScrollTo(x, 0)
        }
    }

    /** Troca a aba selecionada (desmarca a anterior; notifica; foca se o layout tem foco). Original: o(c, int) */
    internal fun select(tab: Tab?, position: Int) {
        val old = selectedTab
        val oldPos = selectedPosition
        if (old === tab) {
            if (old != null) { dispatchSelected(old, oldPos); if (hasFocus()) setFocusedTabView(oldPos) }
            return
        }
        if (old != null) { dispatchUnselected(old, oldPos); setUnFocusedTabView(oldPos) }
        selectedTab = tab
        selectedPosition = position
        if (tab != null) { dispatchSelected(tab, position); if (hasFocus()) setFocusedTabView(position) }
        scrollToSelected()
    }

    fun addOnTabSelectedListener(l: OnTabSelectedListener) { if (!listeners.contains(l)) listeners.add(l) }       // c
    fun removeOnTabSelectedListener(l: OnTabSelectedListener) { listeners.remove(l) }                              // m
    fun setTabSelectedListener(l: OnTabSelectedListener?) { if (l != null) addOnTabSelectedListener(l) }
    fun setDispatchKeyMode(m: Int) { if (m != dispatchKeyMode) dispatchKeyMode = m }
    fun setMode(m: Int) { if (m != mode) { mode = m; applyGravity() } }
    fun setTabCheckShowText(b: Boolean) { checkShowText = b }
    fun setTabIsSelected(b: Boolean) { tabIsSelected = b }
    fun setTabsMargin(m: Int) { tabsMargin = m }
    override fun setOnKeyListener(l: OnKeyListener?) { super.setOnKeyListener(l) }
    fun setSelectTabView(position: Int) { if (position < tabCount) select(tabAt(position), position) }
    protected fun setFocusedTabView(position: Int) { if (position < tabCount) tabAt(position)?.isSelected = true }
    protected fun setUnFocusedTabView(position: Int) { if (position < tabCount) tabAt(position)?.isSelected = false }

    /** Liga a um ViewPager (troca de página ↔ aba); null desfaz. Original: setupWithViewPager(ViewPager) */
    fun setupWithViewPager(pager: androidx.viewpager.widget.ViewPager?) {
        viewPager?.let { old ->
            pageChangeListener?.let { old.removeOnPageChangeListener(it) }
            viewPagerListener?.let { removeOnTabSelectedListener(it) }
        }
        if (pager == null) { viewPager = null; pageChangeListener = null; viewPagerListener = null; return }
        viewPager = pager
        pageChangeListener = PageChangeListener(this).also { pager.addOnPageChangeListener(it) }
        viewPagerListener = ViewPagerSelectedListener(pager).also { addOnTabSelectedListener(it) }
    }

    /**
     * Setas ESQ/DIR (só ACTION_DOWN) trocam de aba (circular se [loopNavigation]); no limite, conforme [dispatchKeyMode]
     * (2 = libera ESQ no início, 3 = libera DIR no fim, 4 = ambos) a aba é desmarcada e o evento segue adiante; senão é consumido.
     */
    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        if (event.action != KeyEvent.ACTION_DOWN) return super.dispatchKeyEvent(event)
        val key = event.keyCode
        if (key != KeyEvent.KEYCODE_DPAD_LEFT) {
            if (key != KeyEvent.KEYCODE_DPAD_RIGHT) return super.dispatchKeyEvent(event)
            val cur = selectedPosition
            if (loopNavigation) setSelectTabView(if (cur < tabCount - 1) cur + 1 else 0)
            else if (cur < tabCount - 1) setSelectTabView(cur + 1)
            else {
                if (dispatchKeyMode == 3 || dispatchKeyMode == 4) { selectedTab?.isSelected = false; return super.dispatchKeyEvent(event) }
            }
            return true
        }
        val cur = selectedPosition
        if (loopNavigation) setSelectTabView(if (cur > 0) cur - 1 else tabCount - 1)
        else if (cur > 0) setSelectTabView(cur - 1)
        else {
            if (dispatchKeyMode == 2 || dispatchKeyMode == 4) { selectedTab?.isSelected = false; return super.dispatchKeyEvent(event) }
        }
        return true
    }

    /** Ganhou foco: seleciona a aba atual (ou a 0); perdeu: aba atual fica "sem foco" (fundo `menub_fragment_tab_bg_unfocus`, linha inferior visível). */
    override fun onFocusChanged(gainFocus: Boolean, direction: Int, previouslyFocusedRect: android.graphics.Rect?) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect)
        if (gainFocus) { setSelectTabView(if (selectedPosition >= 0) selectedPosition else 0); return }
        val cur = tabAt(selectedPosition) ?: return
        androidx.core.view.ViewCompat.setBackground(cur, androidx.appcompat.content.res.AppCompatResources.getDrawable(context, R.drawable.menub_fragment_tab_bg_unfocus))
        cur.findViewById<View>(R.id.tab_title).isEnabled = true
        cur.findViewById<View>(R.id.tab_title).isSelected = gainFocus
        cur.findViewById<View>(R.id.tab_bottom_line).visibility = View.VISIBLE
    }

    /** No modo 1, se o conteúdo é mais largo que a view, divide a largura igualmente entre as abas. */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (childCount == 1) {
            val contentWidth = getChildAt(0).measuredWidth
            if (mode == 1 && contentWidth >= measuredWidth) {
                val n = tabContainer.childCount
                for (i in 0 until n) tabContainer.getChildAt(i).layoutParams.width = measuredWidth / n
            }
        }
    }
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
