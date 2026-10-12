package com.foxivid.ui.keyboard

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.graphics.Rect
import android.graphics.Typeface
import android.text.TextUtils
import android.util.AttributeSet
import android.util.SparseArray
import android.util.TypedValue
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.OvershootInterpolator
import android.view.animation.TranslateAnimation
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatAutoCompleteTextView

/**
 * Teclado virtual para TV (controle remoto/D-pad) que flutua sobre a janela. Constrói as linhas de
 * [KeyView] a partir de [KeyUtils.layoutFor], navega com D-pad (cada tipo de teclado tem um mapa de
 * navegação próprio), insere/apaga texto no EditText focado, alterna tipos (letter, letterNumber,
 * symbol, ninePalaceNumber, ninePalaceNumberWithABC), tem modo de arrastar (vertical/all/horizontal/none)
 * e reposiciona o conteúdo da tela para não ficar coberto.
 *
 * Original: ziyi/kit/keyboard/b.java (classes internas: a..k = listeners/animações anônimos, l = animação
 * de "pulso" da tecla; interfaces m/n/o = KeyDown/Keyboard/CreateKey listeners, sem uso no corpo decompilado)
 */
class KeyboardContainer @JvmOverloads constructor(
    context: Context,
    private val editMode: Boolean,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    /** Container de conteúdo a ser deslocado quando o teclado cobre o EditText. Original: f23356a */
    private var contentView: View? = null
    private var rowCount = 0                                              // f23357b
    private val rowSizes = HashMap<Int, Int>()                            // f23358c
    private var tabTag = 0                                                // f23359d
    private var maxContentBottom = 0                                      // f23360e
    private var contentShift = 0                                          // f23361f
    private val keyViews = SparseArray<KeyView>()                         // f23362g (só teclas "reais")
    private val allKeyViews = SparseArray<KeyView>()                      // f23363h
    private val pulseAnimators = SparseArray<Animator>()                  // f23364i
    private var moveAnimator: Animator? = null                            // f23365j
    private val editTexts = ArrayList<EditText>(20)                       // f23366k
    private val originalKeyListeners = HashMap<EditText, View.OnKeyListener>() // f23368m
    private var focusedEditText: EditText? = null                         // f23369n
    private var contentTop = -1                                           // f23370o
    private var typeface: Typeface? = null                                // f23375t
    private var dragMode = "vertical"                                     // f23376u
    private var downX = 0f                                                // f23377v
    private var downY = 0f                                                // f23378w
    private var dragging = false                                          // f23379x
    private var dragPointerId = -1                                        // f23380y
    private val hitRect = Rect()                                          // f23381z
    private var keyWidth = 0                                              // A
    private var keyHeight = 0                                             // B
    private var keyHSpace = 0                                             // C
    private var keyVSpace = 0                                             // D
    private val keyboardSize = IntArray(2)                                // E
    private var keyboardType: String? = null                              // F
    private var focusKey: KeyView? = null                                 // G
    private var upperCase = false                                         // H
    private var showNumbers = true                                        // I (letterNumber vs letter)
    private var inEditModeFlag = editMode                                 // J
    private var focusRow = 0                                              // K
    private var focusCol = 0                                              // L

    private val touchListener = View.OnTouchListener { v, _ ->
        if (v is EditText) showFor(v)
        false
    }
    private val longClickListener = View.OnLongClickListener { v ->
        if (v is EditText) { showFor(v); true } else false
    }
    /** O EditText encaminha as teclas ao teclado. Original: classe f */
    private val editKeyListener = View.OnKeyListener { _, _, event -> dispatchKeyEvent(event); true }
    private val keyClickListener = View.OnClickListener { v -> onKeyPressed(v as KeyView) }
    private val focusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
        if (!inEditModeFlag && visibility == View.VISIBLE && v is EditText && focusedEditText != null) {
            v.isSelected = !hasFocus
        }
    }

    constructor(context: Context, content: View, editMode: Boolean) : this(context, editMode, null, 0) {
        this.contentView = content
    }

    init {
        setBackgroundResource(KeyUtils.keyboardBackground)
        val dm = context.resources.displayMetrics
        val defaultKeyWidth = TypedValue.applyDimension(1, if (dm.widthPixels <= dm.heightPixels) 42f else 67f, dm).toInt()
        val defaultSpace = TypedValue.applyDimension(1, 2.0f, dm).toInt()
        val a = context.obtainStyledAttributes(attrs, R.styleable.KeyboardView, defStyle, 0)
        val kw = a.getDimensionPixelSize(R.styleable.KeyboardView_keyWidth, defaultKeyWidth)
        val kh = a.getDimensionPixelSize(R.styleable.KeyboardView_keyHeight, 0)
        val hs = a.getDimensionPixelSize(R.styleable.KeyboardView_keyHorizontalSpace, defaultSpace)
        val vs = a.getDimensionPixelSize(R.styleable.KeyboardView_keyVerticalSpace, defaultSpace)
        val type = a.getInt(R.styleable.KeyboardView_keyboardType, 0)
        a.recycle()
        setKeySize(kw, if (kh <= 0) kw * 3 / 5 else kh)
        setKeySpace(hs, vs)
        if (isInEditMode) {
            when (type) {
                0 -> switchType("ninePalaceNumber")
                1 -> { showNumbers = false; switchType("letter") }
                2 -> { showNumbers = true; switchType("letterNumber") }
                3 -> switchType("symbol")
            }
        }
        setPadding(20, 20, 20, 20)
    }

    fun setKeySize(width: Int, height: Int) { keyWidth = width; keyHeight = height }   // L
    fun setKeySpace(h: Int, v: Int) { keyHSpace = h; keyVSpace = v }                   // M
    fun setDefaultUpperCase(upper: Boolean) { upperCase = upper }
    fun setDragSupportModel(mode: String) { dragMode = mode }
    fun setNormalKeyBackground(res: Int) { if (res > 0) KeyUtils.normalKeyBackground = res }
    fun setTabTag(tag: Int) { tabTag = tag }
    fun getTabTag(): Int = tabTag
    fun getKeyboardSize(): IntArray = keyboardSize
    fun getKeyboardType(): String? = keyboardType

    // ---------------------------------------------------------------- registro de EditText

    /** Registra um EditText para ser controlado pelo teclado. Original: b.l(EditText) / m(EditText) */
    fun addEditText(editText: EditText?) {
        if (editText != null && !editTexts.contains(editText)) editTexts.add(editText)
    }

    /** Original: b.W() */
    fun clearEditTexts() = editTexts.clear()

    /** Remove o teclado do pai e limpa EditTexts. Original: b.S() */
    fun destroy() {
        clearEditTexts()
        (parent as? ViewGroup)?.removeView(this)
    }

    /** Activity pausada: fecha. Original: b.T() */
    fun onPause() = hideOrDismissPopup()

    /** Activity retomada: reabre para o EditText focado. Original: b.U() */
    fun onResume() {
        val et = getFocusedEditText()
        if (et != null) {
            et.requestFocus()
            showFor(et)
            installEditTextHooks()
        }
    }

    /** Retorna o EditText com foco (ou o último lembrado), ajustando listeners. Original: b.getFocusedEditText() */
    fun getFocusedEditText(): EditText? {
        val current = focusedEditText
        if (current == null || !current.hasFocus()) {
            for (et in editTexts) {
                if (et.hasFocus()) { focusedEditText = et; break }
            }
        }
        focusedEditText?.let {
            it.setSelectAllOnFocus(false)
            it.onFocusChangeListener = focusChangeListener
        }
        return focusedEditText
    }

    /**
     * Desabilita o IME do sistema nos EditTexts e instala os listeners do teclado; guarda por
     * reflexão (View.mListenerInfo.mOnKeyListener) o OnKeyListener original de cada um.
     * Original: b.Z()
     */
    private fun installEditTextHooks() {
        if (editTexts.isEmpty()) return
        for (et in editTexts) {
            et.showSoftInputOnFocus = false
            try {
                val infoField = View::class.java.getDeclaredField("mListenerInfo")
                infoField.isAccessible = true
                val info = infoField.get(et)
                val keyField = Class.forName("android.view.View\$ListenerInfo").getDeclaredField("mOnKeyListener")
                keyField.isAccessible = true
                if (originalKeyListeners[et] == null && info != null && keyField.get(info) != null) {
                    originalKeyListeners[et] = keyField.get(info) as View.OnKeyListener
                }
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: NoSuchFieldException) {
                e.printStackTrace()
            }
            et.setOnTouchListener(touchListener)
            et.setOnLongClickListener(longClickListener)
            et.setOnKeyListener(editKeyListener)
        }
    }

    // ---------------------------------------------------------------- mostrar / ocultar

    private fun isPopupShowing(et: EditText?) = et is AppCompatAutoCompleteTextView && et.isPopupShowing

    /** Fecha o popup de autocomplete ou o teclado. Original: b.p() */
    fun hideOrDismissPopup() {
        val et = getFocusedEditText()
        if (et is AppCompatAutoCompleteTextView && et.isPopupShowing) {
            et.dismissDropDown()
            return
        }
        if (visibility == View.VISIBLE) hideKeyboard()
    }

    /** Igual a [hideOrDismissPopup] mas devolve se fechou algo. Original: b.q() */
    fun dismiss(): Boolean {
        val et = getFocusedEditText()
        if (et is AppCompatAutoCompleteTextView && et.isPopupShowing) {
            et.dismissDropDown()
            return true
        }
        if (visibility == View.VISIBLE) {
            hideKeyboard()
            return true
        }
        return false
    }

    /** Esconde, zera foco e restaura listeners originais. Original: b.K() */
    private fun hideKeyboard() {
        visibility = View.GONE
        setKeyboardType(null)
        focusRow = 0
        focusCol = 0
        setFocusKeyBackground(KeyUtils.normalKeyBackground)
        for (et in editTexts) {
            et.setOnKeyListener(originalKeyListeners[et])
        }
    }

    /** Original: b.k0() */
    fun show() {
        if (visibility != View.VISIBLE) prepareForFocused()
        val et = getFocusedEditText()
        if (et != null && et.text != null && et is AppCompatAutoCompleteTextView) {
            val s = et.text.toString()
            if (s.endsWith("@") && s.indexOf("@") == s.length - 1) et.showDropDown()
        }
    }

    /** Original: b.m0() */
    fun toggle() { if (visibility == View.VISIBLE) hideOrDismissPopup() else show() }

    /** Original: b.j0() */
    private fun prepareForFocused() {
        focusedEditText = getFocusedEditText()
        val et = focusedEditText
        if (et != null && et.visibility == View.VISIBLE) {
            showFor(et)
            installEditTextHooks()
        }
    }

    private fun makeVisible() {
        visibility = View.VISIBLE
        setBackgroundResource(KeyUtils.keyboardBackground)
    }

    /** Torna visível e traz para frente. Original: b.f0() */
    fun bringUp() {
        if (visibility != View.VISIBLE) makeVisible()
        bringToFront()
    }

    /**
     * Escolhe o layout conforme o inputType do EditText (numérico -> ninePalaceNumber) e ajusta o texto
     * da tecla 148 ("Next"/"Done" conforme seja o último campo ou ime action DONE (6)).
     * Original: b.g0(EditText)
     */
    fun showFor(editText: EditText) {
        val inputType = editText.inputType
        val imeOptions = editText.imeOptions
        val cls = inputType and 15
        if (cls != 2 && cls != 3 && cls != 4) {
            var type = getKeyboardType()
            if (TextUtils.isEmpty(type) || "ninePalaceNumber" == type) {
                type = if (showNumbers) "letterNumber" else "letter"
            }
            switchType(type!!)
        } else {
            switchType("ninePalaceNumber")
        }
        if (!isLastEditText(editText) && (imeOptions and 255) != 6) {
            keyViews.get(148).setLabel("Next")
        } else {
            keyViews.get(148).setLabel("Done")
        }
        focusedEditText = editText
    }

    private fun isLastEditText(editText: EditText): Boolean {
        if (editTexts.isEmpty()) return false
        return editText === editTexts[editTexts.size - 1]
    }

    // ---------------------------------------------------------------- tipo de teclado / construção

    private fun setKeyboardType(type: String?) {
        keyboardType = type
        if (TextUtils.isEmpty(type)) return
        if (type == "letterNumber") showNumbers = true
        else if (type == "letter") showNumbers = false
    }

    /** Alterna o tipo e reconstrói quando mudou; ajusta o foco inicial. Original: b.e0(String) */
    private fun switchType(type: String) {
        val previous = getKeyboardType()
        if (type != previous) {
            setKeyboardType(type)
            if ((previous != "ninePalaceNumber" && type != "ninePalaceNumber") || (translationX == 0f && translationY == 0f)) {
                rebuild()
            } else {
                animateBackToOrigin(object : Animator.AnimatorListener {
                    override fun onAnimationEnd(animation: Animator) { rebuild() }
                    override fun onAnimationCancel(animation: Animator) {}
                    override fun onAnimationRepeat(animation: Animator) {}
                    override fun onAnimationStart(animation: Animator) {}
                })
            }
        }
        bringUp()
        when (type) {
            "ninePalaceNumberWithABC" -> if (previous == "letterNumber") focusKeyByCode(146)
            "letter" -> if (previous == "letterNumber") focusKeyByCode(151)
            "symbol" -> if (previous == "letterNumber") focusKeyByCode(256)
            "letterNumber" -> {
                if (previous == "ninePalaceNumberWithABC") focusKeyByCode(149)
                else if (previous == "symbol") focusKeyByCode(153)
                else if (previous == "letter") focusKeyByCode(151)
            }
        }
    }

    private fun isPortrait() = resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    private fun maxRowWeight(rows: List<List<KeyBean>>): Float {
        var max = 0f
        for (row in rows) {
            var sum = 0f
            for (key in row) sum += key.weight
            max = Math.max(max, sum)
        }
        return max
    }

    private fun keyTextColor(code: Int): Int =
        resources.getColor(if (code == 148) KeyUtils.keyNextColor else KeyUtils.keyTextColor)

    /** Remove todas as views das linhas. Original: b.X() */
    private fun clearRows() {
        keyboardSize[0] = 0
        keyboardSize[1] = 0
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            if (child is ViewGroup) {
                for (j in 0 until child.childCount) {
                    (child.getChildAt(i) as ViewGroup).removeAllViews()
                }
                child.removeAllViews()
            }
        }
        removeAllViews()
    }

    /** Constrói as linhas/teclas para o tipo atual. Original: b.s() */
    fun rebuild() {
        clearRows()
        val rows = KeyUtils.layoutFor(getKeyboardType()!!, isPortrait())!!
        var maxWeight = maxRowWeight(rows)
        val size = rows.size
        rowCount = size
        var cols = maxWeight.toInt()
        if (maxWeight > cols) {
            cols++
            maxWeight = cols.toFloat()
        }
        keyboardSize[0] = PADDING + (keyWidth + keyHSpace * 2) * cols + PADDING
        if (keyboardSize[0] > resources.displayMetrics.widthPixels) {
            keyWidth = (resources.displayMetrics.widthPixels - PADDING - PADDING - keyHSpace * 2 * cols) / cols
            keyboardSize[0] = PADDING + (keyWidth + keyHSpace * 2) * cols + PADDING
        }
        keyboardSize[1] = PADDING + (keyHeight + keyVSpace * 2) * size + PADDING
        val column = LinearLayout(context)
        column.orientation = LinearLayout.VERTICAL
        for (r in 0 until size) {
            val row = rows[r]
            rowSizes[r] = row.size
            val rowLayout = LinearLayout(column.context)
            rowLayout.orientation = LinearLayout.HORIZONTAL
            rowLayout.weightSum = maxWeight
            column.addView(rowLayout, LayoutParams(keyboardSize[0], -2))
            for (c in row.indices) addKey(rowLayout, r, c, row[c], keyHeight)
        }
        var reset = false
        if (focusRow >= rowCount) { focusRow = 0; reset = true }
        if (focusCol >= rowSizes[focusRow]!!) { focusCol = 0; reset = true }
        if (reset) {
            setFocusKeyBackground(KeyUtils.normalKeyBackground)
            focusKey = keyViews.get(rows[focusRow][focusCol].code)
            setFocusKeyBackground(KeyUtils.focusKeyBackground)
        }
        addView(column)
        applyUpperCase(upperCase)
        updateShowHideLabel()
        val side = (resources.displayMetrics.widthPixels - keyboardSize[0]) / 2
        val pad = if (side > 0) side else 0
        setPadding(pad, 20, pad, 20)
        column.bringToFront()
        requestLayout()
        column.invalidate()
    }

    /** Cria/reaproveita a KeyView e a adiciona na linha. Original: b.r(...) */
    private fun addKey(row: LinearLayout, rowIndex: Int, colIndex: Int, bean: KeyBean, height: Int) {
        val code = bean.code
        var keyView = keyViews.get(code)
        if (keyView == null) {
            keyView = KeyView(context)
            keyView.setTypeface(typeface)
            keyView.textKeyView.setTextColor(keyTextColor(code))
            keyView.textKeyView.setTextSize(1, 20.0f)
            keyView.setOnClickListener(keyClickListener)
            // tecla Delete (147): clique longo apaga tudo antes do cursor
            keyView.setOnLongClickListener(if (code == 147) View.OnLongClickListener { deleteAllBefore(); true } else null)
            keyView.isEnabled = KeyUtils.isEnabledKey(code)
            keyView.visibility = if (code == 294) View.INVISIBLE else View.VISIBLE
            keyView.setBackgroundResource(KeyUtils.normalKeyBackground)
            keyView.setBean(bean)
            allKeyViews.put(code, keyView)
            if (!KeyUtils.isHiddenKey(bean.code)) keyViews.put(code, keyView)
        } else if (keyView.parent != null) {
            (keyView.parent as ViewGroup).removeView(keyView)
        }
        // impede sair da grade pela esquerda (col 0) e por cima (linha 0)
        keyView.setOnKeyListener { _, _, event ->
            if (event.keyCode != 21 || colIndex != 0) {
                event.keyCode == 19 && rowIndex == 0
            } else true
        }
        if (rowIndex == focusRow && colIndex == focusCol) {
            setFocusKeyBackground(KeyUtils.normalKeyBackground)
            focusKey = keyView
            setFocusKeyBackground(KeyUtils.focusKeyBackground)
        }
        val lp = (keyView.layoutParams as? LinearLayout.LayoutParams) ?: LinearLayout.LayoutParams(0, height)
        lp.weight = bean.weight
        lp.leftMargin = keyHSpace
        lp.rightMargin = keyHSpace
        lp.topMargin = keyVSpace
        lp.bottomMargin = keyVSpace
        row.addView(keyView, lp)
    }

    private fun setFocusKeyBackground(res: Int) { focusKey?.setBackgroundResource(res) }

    /** Atualiza o rótulo da tecla 151 ("Hide"/"Show"). Original: b.n0() */
    private fun updateShowHideLabel() {
        keyViews.get(151)?.setLabel(if (showNumbers) "Hide" else "Show")
    }

    /** Aplica maiúsculas às letras (códigos 16..53) e troca o ícone da tecla 150. Original: b.l0(boolean) */
    private fun applyUpperCase(upper: Boolean) {
        // Original: D() — exige que o teclado já tenha sido anexado ao decorView
        check(isInEditMode || parent != null) { "Initialize first." }
        upperCase = upper
        for (code in 16..53) keyViews.get(code)?.setUpperCase(upper)
        keyViews.get(150)?.setIcon(if (upper) R.drawable.key_icon_upper_case else R.drawable.key_icon_lower_case)
    }

    /** Move o foco visual para a tecla de código dado, procurando no layout atual. Original: b.setKeyFocus(int) */
    private fun focusKeyByCode(code: Int) {
        val rows = KeyUtils.layoutFor(getKeyboardType()!!, isPortrait())!!
        for (r in rows.indices) {
            for (c in rows[r].indices) {
                val bean = rows[r][c]
                if (bean.code == code) {
                    setFocusKeyBackground(KeyUtils.normalKeyBackground)
                    focusKey = keyViews.get(bean.code)
                    focusRow = r
                    focusCol = c
                    setFocusKeyBackground(KeyUtils.focusKeyBackground)
                    return
                }
            }
        }
    }

    /** Foco na primeira tecla do layout. Original: b.a0() */
    private fun focusFirstKey() {
        val rows = KeyUtils.layoutFor(getKeyboardType()!!, isPortrait())
        if (rows != null && rows.isNotEmpty()) {
            val first = rows[0][0]
            setFocusKeyBackground(KeyUtils.normalKeyBackground)
            focusKey = keyViews.get(first.code)
            focusRow = 0
            focusCol = 0
            setFocusKeyBackground(KeyUtils.focusKeyBackground)
        }
    }

    /** Atualiza o foco visual para (focusRow, focusCol). Original: b.b0() */
    private fun updateFocus() {
        if (focusKey != null) setFocusKeyBackground(KeyUtils.normalKeyBackground)
        if (getKeyboardType() != null) {
            val code = KeyUtils.layoutFor(getKeyboardType()!!, isPortrait())!![focusRow][focusCol].code
            focusKey = allKeyViews.get(code)
            if (focusKey != null) setFocusKeyBackground(KeyUtils.focusKeyBackground)
        }
    }

    // ---------------------------------------------------------------- ações de tecla

    /** Trata clique/OK em uma tecla (códigos de função 144..153 e 256). Original: b.v(KeyView) */
    fun onKeyPressed(keyView: KeyView?) {
        if (keyView == null) return
        pulse(keyView)
        val bean = keyView.bean!!
        val code = bean.code
        if (code == 256) {
            switchType(if (showNumbers) "letterNumber" else "letter")
            return
        }
        when (code) {
            144 -> hideOrDismissPopup()
            145 -> insertKey(bean)
            146 -> switchType(if (showNumbers) "letterNumber" else "letter")
            147 -> deleteBackward()
            148 -> nextOrDone(bean)
            149 -> switchType("ninePalaceNumberWithABC")
            150 -> applyUpperCase(!upperCase)
            151 -> { toggleNumberRow(); updateShowHideLabel() }
            152 -> {}
            153 -> switchType("symbol")
            else -> insertKey(bean)
        }
    }

    /** Alterna letter <-> letterNumber. Original: b.i0() */
    fun toggleNumberRow() {
        if ("letterNumber" == getKeyboardType()) {
            showNumbers = false
            switchType("letter")
        } else if ("letter" == getKeyboardType()) {
            showNumbers = true
            switchType("letterNumber")
        }
    }

    /** Insere o texto da tecla (substitui seleção); pares "()" deixam o cursor entre os dois. Original: b.N(KeyBean) */
    fun insertKey(bean: KeyBean) {
        val et = getFocusedEditText() ?: return
        val text = et.text
        val start = et.selectionStart
        val end = et.selectionEnd
        val input = bean.input
        if (end > start) text.replace(start, end, input) else text.insert(start, input)
        if (KeyUtils.isPairKey(bean.code)) {
            val pos = et.selectionStart
            if (pos - start == 2) et.setSelection(pos - 1)
        }
    }

    /** Insere texto (usado pelas teclas numéricas físicas). Original: b.O(CharSequence) */
    fun insertText(chars: CharSequence) {
        val et = getFocusedEditText() ?: return
        val text = et.text
        val start = et.selectionStart
        val end = et.selectionEnd
        if (end > start) text.replace(start, end, chars) else text.insert(start, chars)
        val pos = et.selectionStart
        if (pos - start == 2) et.setSelection(pos - 1)
    }

    /** Backspace. Original: b.u() */
    fun deleteBackward() {
        val et = getFocusedEditText() ?: return
        val text = et.text
        val start = et.selectionStart
        val end = et.selectionEnd
        if (end > start) {
            text.delete(start, end)
            return
        }
        var from = start - 1
        if (from < 0) from = 0
        text.delete(from, start)
        et.setSelection(if (from > text.length) text.length else from)
    }

    /** Clique longo em Delete: apaga a seleção ou tudo antes do cursor. Original: b.t() */
    fun deleteAllBefore() {
        val et = getFocusedEditText() ?: return
        val text = et.text
        val start = et.selectionStart
        val end = et.selectionEnd
        if (end > start) {
            text.delete(start, end)
        } else {
            text.delete(0, start)
            et.setSelection(0)
        }
    }

    /** "Next": foca o próximo EditText (ou fecha se for o último / "Done"). Original: b.n(KeyBean) */
    fun nextOrDone(bean: KeyBean) {
        val et = getFocusedEditText()
        if (et != null && "Done" != bean.label.toString()) {
            focusedEditText = null
            var index = -1
            for (i in editTexts.indices) {
                if (et === editTexts[i]) { index = i; break }
            }
            val next = index + 1
            if (next >= editTexts.size) {
                hideKeyboard()
                return
            }
            editTexts[next].requestFocus()
            editTexts[next].moveCursorToVisibleOffset()
            setFocusKeyBackground(KeyUtils.normalKeyBackground)
            showFor(editTexts[next])
            focusFirstKey()
            postDelayed({
                val h = KeyUtils.decorHeight
                if (h != 0) moveContentAboveKeyboard(h) else moveContentAboveKeyboard(contentView!!.height)
            }, 100L)
            return
        }
        hideKeyboard()
    }

    /** Animação de "pulso" (escala 1.2x, 200 ms) ao pressionar uma tecla normal. Original: b.V(KeyView) */
    private fun pulse(keyView: KeyView) {
        val code = keyView.bean!!.code
        if (!KeyUtils.isFunctionKey(code) && !KeyUtils.isHiddenKey(code) && code != 112) {
            pulseAnimators.get(code)?.cancel()
            val sx = keyView.scaleX
            val sy = keyView.scaleY
            val anim = ObjectAnimator.ofPropertyValuesHolder(
                keyView,
                PropertyValuesHolder.ofFloat(View.SCALE_X, sx, sx * 1.2f, sx),
                PropertyValuesHolder.ofFloat(View.SCALE_Y, sy, 1.2f * sy, sy)
            ).setDuration(200L)
            anim.addListener(PulseListener(code, sx, sy))
            pulseAnimators.put(code, anim)
            anim.start()
        }
    }

    /** Original: b$l */
    private inner class PulseListener(private val code: Int, private val sx: Float, private val sy: Float) :
        Animator.AnimatorListener {
        override fun onAnimationCancel(animation: Animator) {
            pulseAnimators.remove(code)
            keyViews.get(code)?.let { it.scaleX = sx; it.scaleY = sy }
        }
        override fun onAnimationEnd(animation: Animator) { pulseAnimators.remove(code) }
        override fun onAnimationRepeat(animation: Animator) {}
        override fun onAnimationStart(animation: Animator) {}
    }

    // ---------------------------------------------------------------- deslocamento do conteúdo

    private fun setContentLayout(left: Int, top: Int, width: Int, height: Int) {
        val content = contentView ?: return
        when (val lp = content.layoutParams) {
            is LinearLayout.LayoutParams -> { lp.setMargins(left, top, 0, 0); lp.width = width; lp.height = height; content.layoutParams = lp }
            is RelativeLayout.LayoutParams -> { lp.setMargins(left, top, 0, 0); lp.width = width; lp.height = height; content.layoutParams = lp }
            is FrameLayout.LayoutParams -> { lp.setMargins(left, top, 0, 0); lp.width = width; lp.height = height; content.layoutParams = lp }
        }
        content.requestLayout()
    }

    /**
     * Sobe o conteúdo (com animação OvershootInterpolator de 200 ms) quando o EditText ficaria sob o
     * teclado. Original: b.h0(int windowHeight)
     */
    fun moveContentAboveKeyboard(windowHeight: Int) {
        val content = contentView ?: return
        if (contentTop != -1) contentTop = content.top
        val et = getFocusedEditText() ?: return
        val loc = intArrayOf(0, 0)
        et.getLocationInWindow(loc)
        maxContentBottom = windowHeight - height
        val etBottom = loc[1] + et.height
        if (etBottom > maxContentBottom) {
            contentShift = (maxContentBottom - loc[1]) - et.height
        }
        if (contentShift >= 0 || (-contentShift) >= windowHeight / 2) {
            contentShift = 0
            return
        }
        val anim = TranslateAnimation(0f, 0f, 0f, contentShift.toFloat())
        anim.interpolator = OvershootInterpolator()
        anim.duration = 200L
        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(animation: Animation) {
                content.clearAnimation()
                setContentLayout(content.left, content.top + contentShift, content.width, content.height * 2)
            }
            override fun onAnimationRepeat(animation: Animation) {}
            override fun onAnimationStart(animation: Animation) {}
        })
        content.startAnimation(anim)
    }

    /** Devolve o conteúdo à posição original. Original: b.Y() */
    fun restoreContent() {
        val content = contentView
        if (content == null || contentShift >= 0) return
        val left = content.left
        val top = contentTop
        val width = content.width
        val height = content.height * 2
        contentShift = 0
        setContentLayout(left, top, width, height)
    }

    private fun animateBackToOrigin(listener: Animator.AnimatorListener) {
        val anim = ObjectAnimator.ofPropertyValuesHolder(
            this,
            PropertyValuesHolder.ofFloat(View.TRANSLATION_X, translationX, 0f),
            PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, translationX, 0f) // sic: original usa getTranslationX() como valor inicial
        ).setDuration(300L)
        anim.addListener(listener)
        anim.start()
    }

    // ---------------------------------------------------------------- arrastar (touch)

    private fun isDragEnabled() = !TextUtils.equals(dragMode, "none")   // P()
    private fun isScaledDown() = scaleX < 1.0f                           // R()

    private fun setEnabledAllKeys(enabled: Boolean) {
        for (i in 0 until keyViews.size()) keyViews.get(keyViews.keyAt(i)).isEnabled = enabled
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        moveAnimator?.cancel()
        when (event.actionMasked) {
            0 -> if (isDragEnabled() && !dragging) {
                dragPointerId = event.getPointerId(0)
                downX = event.x
                downY = event.y
            }
            1 -> if (isDragEnabled() && !dragging) snapToRows()
            2 -> if (isDragEnabled() && !dragging && dragPointerId == event.getPointerId(0)) {
                val x = event.x
                val y = event.y
                val dx = downX - x
                val dy = downY - y
                if (Math.abs(dx) < 8.0f && Math.abs(dy) < 8.0f) {
                    downX = x
                    downY = y
                } else if (!isScaledDown()) {
                    dragging = true
                    setEnabledAllKeys(false)
                }
            }
            3 -> if (isDragEnabled()) snapToRows()
        }
        return dragging
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (!isScaledDown() && isDragEnabled()) {
            when (event.actionMasked) {
                0 -> if (dragPointerId == event.getPointerId(0)) {
                    downX = event.x
                    downY = event.y
                }
                1 -> if (dragging && dragPointerId == event.getPointerId(0)) {
                    snapToRows()
                    dragging = false
                    setEnabledAllKeys(true)
                }
                2 -> if (dragPointerId == event.getPointerId(0)) {
                    dragBy(-(downX - event.x), -(downY - event.y))
                }
                3 -> if (dragging) {
                    snapToRows()
                    dragging = false
                    setEnabledAllKeys(true)
                }
            }
            return true
        }
        return super.onTouchEvent(event)
    }

    /** Move o teclado dentro dos limites do pai conforme o modo (vertical/all/horizontal). Original: b.E(float,float) */
    private fun dragBy(dxIn: Float, dyIn: Float) {
        var dx = dxIn
        var dy = dyIn
        val parentView = parent as ViewGroup
        val left = parentView.paddingLeft
        val right = parentView.width - parentView.paddingRight
        val top = parentView.paddingTop
        val bottom = parentView.height - parentView.paddingBottom
        val rowHeight = keyHeight + keyVSpace * 2
        getHitRect(hitRect)
        if (hitRect.left + dx < left) dx = (left - hitRect.left).toFloat()
        if (hitRect.right + dx > right) dx = (right - hitRect.right).toFloat()
        if (hitRect.top + dy < top - ((keyboardSize[1] - rowHeight) - paddingBottom)) {
            dy = ((top - ((keyboardSize[1] - rowHeight) - paddingBottom)) - hitRect.top).toFloat()
        }
        if (hitRect.bottom + dy > ((keyboardSize[1] + bottom) - rowHeight) - paddingTop) {
            dy = ((((bottom + keyboardSize[1]) - rowHeight) - paddingTop) - hitRect.bottom).toFloat()
        }
        when (dragMode) {
            "vertical" -> translationY = translationY + dy
            "all" -> { translationX = translationX + dx; translationY = translationY + dy }
            "horizontal" -> translationX = translationX + dx
        }
    }

    /** Ao soltar, encaixa o teclado em múltiplos da altura de linha. Original: b.o() */
    private fun snapToRows() {
        val parentView = parent as ViewGroup
        val bottom = parentView.height - parentView.paddingBottom
        val rowHeight = keyHeight + keyVSpace * 2
        getHitRect(hitRect)
        val distance = bottom - hitRect.top
        val twoRows = rowHeight * 2
        if (distance <= keyboardSize[1] + twoRows + paddingBottom) {
            val half = rowHeight / 2
            val target: Int
            if (distance >= (keyboardSize[1] - half) - paddingBottom) {
                target = keyboardSize[1]
            } else if (distance >= paddingTop + rowHeight) {
                val inner = distance - paddingTop
                var rows = inner / rowHeight
                if (inner % rowHeight >= half) rows++
                target = paddingTop + rows * rowHeight
            } else {
                target = rowHeight + paddingTop
            }
            val delta = (bottom - target) - hitRect.top
            if (Math.abs(delta) <= twoRows + paddingTop) {
                val anim = ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, translationY, translationY + delta)
                    .setDuration(Math.abs(delta).toLong())
                anim.addListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator) { moveAnimator = animation }
                    override fun onAnimationEnd(animation: Animator) { moveAnimator = null }
                    override fun onAnimationCancel(animation: Animator) { moveAnimator = null }
                    override fun onAnimationRepeat(animation: Animator) {}
                })
                anim.start()
            }
        }
    }

    // ---------------------------------------------------------------- teclas físicas / D-pad

    /** Teclas numéricas físicas (KEYCODE_0..9) inserem o dígito; DEL apaga. Original: b.x(KeyEvent) */
    fun handleDigitKey(event: KeyEvent) {
        val code = event.keyCode
        if (code != 67) {
            if (code in 7..16) insertText(((code - 7)).toString())
            return
        }
        deleteBackward()
    }

    /** Move foco entre colunas/linhas comum a todos os mapas; null = sem tratar. */
    private fun commonEnterOrHorizontal(code: Int): Boolean {
        when (code) {
            21 -> if (focusCol > 0) { focusCol--; updateFocus() }
            22 -> if (focusCol < rowSizes[focusRow]!! - 1) { focusCol++; updateFocus() }
            23 -> onKeyPressed(focusKey)
            else -> return false
        }
        return true
    }

    /** Navegação do tipo "ninePalaceNumberWithABC". Original: b.A(KeyEvent) */
    fun navigateNinePalaceWithAbc(event: KeyEvent): Boolean {
        val code = event.keyCode
        if (code == 66) { onKeyPressed(focusKey); return true }
        when (code) {
            19 -> if (focusRow > 0) { focusRow--; updateFocus() }
            20 -> if (focusRow < rowCount - 1) { focusRow++; updateFocus() }
            else -> if (!commonEnterOrHorizontal(code)) handleDigitKey(event)
        }
        return true
    }

    /** Navegação do tipo "ninePalaceNumber". Original: b.z(KeyEvent) */
    fun navigateNinePalace(event: KeyEvent): Boolean {
        val code = event.keyCode
        if (code == 66) { onKeyPressed(focusKey); return true }
        when (code) {
            19 -> if (focusRow > 0) {
                if (focusRow == 3 && focusCol == 2) focusCol = 3
                focusRow--
                updateFocus()
            }
            20 -> if (focusRow < rowCount - 1) {
                if (focusRow == 2 && focusCol == 3) focusCol = 2
                focusRow++
                updateFocus()
            }
            else -> if (!commonEnterOrHorizontal(code)) handleDigitKey(event)
        }
        return true
    }

    /** Navegação do tipo "letterNumber" (5 linhas). Original: b.w(KeyEvent) */
    fun navigateLetterNumber(event: KeyEvent): Boolean {
        val code = event.keyCode
        if (code == 66) { onKeyPressed(focusKey); return true }
        when (code) {
            19 -> if (focusRow > 0) {
                if (focusRow != 2) {
                    if (focusRow != 4) {
                        focusRow--
                        updateFocus()
                    } else {
                        val c = focusCol
                        if (c == 0) focusCol = 0
                        else if (c != 1 && c != 2) focusCol = if (c == 3) 6 else 9
                        else focusCol = c + 1
                        focusRow--
                        updateFocus()
                    }
                } else {
                    if (focusCol == 9) focusCol = 10
                    focusRow--
                    updateFocus()
                }
            }
            20 -> if (focusRow < rowCount - 1) {
                if (focusRow != 1) {
                    if (focusRow == 3 && focusCol > 1) {
                        val c = focusCol
                        focusCol = if (c > 1 && c < 4) c - 1 else if (c in 4..7) 3 else 4
                    }
                    focusRow++
                    updateFocus()
                } else {
                    if (focusCol == 9 || focusCol == 10) focusCol = 9
                    focusRow++
                    updateFocus()
                }
            }
            else -> if (!commonEnterOrHorizontal(code)) handleDigitKey(event)
        }
        return true
    }

    /** Navegação do tipo "letter" (4/5 linhas). Original: b.y(KeyEvent) */
    fun navigateLetter(event: KeyEvent): Boolean {
        val code = event.keyCode
        if (code == 66) { onKeyPressed(focusKey); return true }
        when (code) {
            19 -> if (focusRow > 0) {
                if (focusRow != 1) {
                    if (focusRow != 2) {
                        if (focusRow == 3) {
                            val c = focusCol
                            if (c == 0) focusCol = 0
                            else if (c != 1 && c != 2) focusCol = if (c == 3) 6 else 9
                            else focusCol = c + 1
                            focusRow--
                            updateFocus()
                        }
                    } else {
                        focusRow--
                        updateFocus()
                    }
                } else {
                    if (focusCol == 9) focusCol = 10
                    focusRow--
                    updateFocus()
                }
            }
            20 -> if (focusRow < rowCount - 1) {
                if (focusRow != 0) {
                    if (focusRow != 1) {
                        if (focusRow == 2) {
                            val c = focusCol
                            if (c > 1) {
                                focusCol = if (c > 1 && c < 4) c - 1 else if (c in 4..7) 3 else 4
                            }
                            focusRow++
                            updateFocus()
                        }
                    } else {
                        focusRow++
                        updateFocus()
                    }
                } else {
                    if (focusCol == 9 || focusCol == 10) focusCol = 9
                    focusRow++
                    updateFocus()
                }
            }
            else -> commonEnterOrHorizontal(code)
        }
        return true
    }

    /** Navegação do tipo "symbol". Original: b.B(KeyEvent) */
    fun navigateSymbol(event: KeyEvent): Boolean {
        val code = event.keyCode
        if (code == 66) { onKeyPressed(focusKey); return true }
        when (code) {
            19 -> if (focusRow > 0) {
                if (focusRow != 1) {
                    if (focusRow != 2) {
                        focusRow--
                        updateFocus()
                    } else {
                        val c = focusCol
                        if (c in 2..5) focusCol = c - 1 else if (c > 5) focusCol = c - 2
                        focusRow--
                        updateFocus()
                    }
                } else {
                    val c = focusCol
                    if (c in 2..3) focusCol = c + 1 else if (c > 3) focusCol = c + 2
                    focusRow--
                    updateFocus()
                }
            }
            20 -> if (focusRow < rowCount - 1) {
                if (focusRow != 0) {
                    if (focusRow != 1) {
                        focusRow++
                        updateFocus()
                    } else {
                        val c = focusCol
                        if (c in 2..3) focusCol = c + 1 else if (c > 3) focusCol = c + 2
                        focusRow++
                        updateFocus()
                    }
                } else {
                    val c = focusCol
                    if (c in 2..4) focusCol = c - 1 else if (c > 4) focusCol = c - 2
                    focusRow++
                    updateFocus()
                }
            }
            else -> commonEnterOrHorizontal(code)
        }
        return true
    }

    /**
     * Despacho das teclas: BACK(4)/ESCAPE(111) fecham; DEL(67) apaga; com popup de autocomplete aberto
     * repassa ao EditText; senão delega ao mapa do tipo atual. Sempre consome (return true).
     * Original: b.dispatchKeyEvent(KeyEvent)
     */
    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        if (event.action == 0) {
            if (visibility == View.VISIBLE) {
                if (event.keyCode != 4 && event.keyCode != 111) {
                    if (event.keyCode == 67) {
                        deleteBackward()
                        return true
                    }
                    val et = getFocusedEditText()
                    if (et is AppCompatAutoCompleteTextView && et.isPopupShowing &&
                        ((event.keyCode != 23 && event.keyCode != 66) || et.listSelection != -1)
                    ) {
                        return et.onKeyDown(event.keyCode, event)
                    }
                    when (getKeyboardType()) {
                        "ninePalaceNumberWithABC" -> navigateNinePalaceWithAbc(event)
                        "ninePalaceNumber" -> navigateNinePalace(event)
                        "letter" -> navigateLetter(event)
                        "symbol" -> navigateSymbol(event)
                        "letterNumber" -> navigateLetterNumber(event)
                    }
                    return true
                }
                hideOrDismissPopup()
                return true
            }
        } else if (event.action == 1) {
            val et = getFocusedEditText()
            if (et is AppCompatAutoCompleteTextView && et.isPopupShowing) {
                return et.onKeyUp(event.keyCode, event)
            }
        }
        return true
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    /** Dimensão da barra de status. Original: b.getStatusBarHeight() */
    private fun getStatusBarHeight(): Int {
        val id = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        return if (id > 0) context.resources.getDimensionPixelSize(id) else 0
    }

    companion object {
        /** Padding externo do teclado. Original: b.getPadding() */
        private const val PADDING = 20
    }
}
