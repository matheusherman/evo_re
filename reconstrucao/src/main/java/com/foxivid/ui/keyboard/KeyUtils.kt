package com.foxivid.ui.keyboard

import android.content.Context
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.Window
import android.widget.FrameLayout
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

/**
 * Registro estático do teclado virtual de TV: tabela de teclas, layouts por tipo de teclado,
 * cores/backgrounds globais, e ciclo de vida (por id de view) que mostra/oculta o teclado e
 * reposiciona a tela quando o teclado aparece.
 *
 * Tipos de teclado (string): "letter", "letterNumber", "symbol", "ninePalaceNumber",
 * "ninePalaceNumberWithABC".
 *
 * Original: ziyi/kit/keyboard/KeyUtils.java (a = OnGlobalLayoutListener de altura,
 * c = interface [KeyboardVisibilityListener], b = implementação que desloca o container)
 */
object KeyUtils {

    /** Altura do decorView da última medição. Original: f23286h */
    @JvmField var decorHeight = 0
    private var currentKeyboard: KeyboardContainer? = null            // f23287i
    private var showOnResume = false                                  // f23288j
    private val keyboards = HashMap<Int, KeyboardContainer>()          // f23297s
    private val visibilityBeforePause = HashMap<Int, Int>()            // f23298t
    private val visibilityListeners = HashMap<Int, KeyboardVisibilityListener>() // f23299u
    private val layoutListeners = HashMap<Int, ViewTreeObserver.OnGlobalLayoutListener>() // f23300v
    private val lifecycles = HashMap<Int, Lifecycle>()                 // f23301w
    private val lifecycleObservers = HashMap<Int, MyLifecycleObserver>() // f23302x
    private val windows = HashMap<Int, Window>()                       // f23303y

    @JvmField var keyboardBackground = R.drawable.key_keyboard_background_shape // f23279a
    @JvmField var focusKeyBackground = R.drawable.key_normal_focus              // f23280b
    @JvmField var normalKeyBackground = R.drawable.key_normal_unfocus           // f23281c
    @JvmField var keyTextColor = R.color.keyTextColor                           // f23282d
    @JvmField var keyNextColor = R.color.keyNextColor                           // f23283e
    private var platformType = ""     // f23284f (setado por H(String))
    private var platformSubType = ""  // f23285g (setado por I(String))

    private val keys = SparseArray<KeyBean>()                          // f23289k
    private val letterLandscape = ArrayList<List<KeyBean>>()           // f23292n  (m())
    private val letterNumberLandscape = ArrayList<List<KeyBean>>()     // f23293o  (n())
    private val ninePalaceNumber = ArrayList<List<KeyBean>>()          // f23290l  (o())
    private val ninePalaceNumberWithAbc = ArrayList<List<KeyBean>>()   // f23291m  (p())
    private val letterPortrait = ArrayList<List<KeyBean>>()            // f23295q  (q())
    private val symbolPortrait = ArrayList<List<KeyBean>>()            // f23296r  (r())
    private val symbolLandscape = ArrayList<List<KeyBean>>()           // f23294p  (s())

    /** Notificado quando o teclado muda de visibilidade. Original: KeyUtils$c.a(height, visible, id) */
    fun interface KeyboardVisibilityListener {
        fun onVisibilityChanged(height: Int, visible: Boolean, id: Int)
    }

    init {
        fun add(b: KeyBean) { keys.put(b.code, b) }
        add(KeyBean(0, "0"))
        add(KeyBean(1, "1", true))
        for (d in 2..9) add(KeyBean(d, d.toString()))
        // letras: códigos 16-25 (a-j), 32-41 (k-t), 48-53 (u-z)
        val letters = "abcdefghijklmnopqrstuvwxyz"
        val letterCodes = (16..25) + (32..41) + (48..53)
        letterCodes.forEachIndexed { i, code ->
            add(if (letters[i] == 't') KeyBean(code, "t", true) else KeyBean(code, letters[i].toString()))
        }
        add(KeyBean(64, "!"))
        add(KeyBean(65, "@", true))
        add(KeyBean(66, "#"))
        add(KeyBean(67, "$"))
        add(KeyBean(68, "%"))
        add(KeyBean(69, "^"))
        add(KeyBean(70, "&"))
        add(KeyBean(71, "*"))
        add(KeyBean(72, "(　)", "()"))
        add(KeyBean(73, "[　]", "[]"))
        add(KeyBean(80, "{　}", "{}"))
        add(KeyBean(81, "<　>", "<>"))
        add(KeyBean(82, "\"", "\"\""))
        add(KeyBean(83, "'", "''"))
        add(KeyBean(84, "|"))
        add(KeyBean(85, "\\"))
        add(KeyBean(86, "?"))
        add(KeyBean(87, "/"))
        add(KeyBean(88, ":"))
        add(KeyBean(89, ";"))
        add(KeyBean(96, ","))
        add(KeyBean(97, "•", "."))
        add(KeyBean(98, ","))
        add(KeyBean(99, "`", "``"))
        add(KeyBean(100, "~"))
        add(KeyBean(101, "+"))
        add(KeyBean(102, "="))
        add(KeyBean(103, "-"))
        add(KeyBean(104, "_"))
        add(KeyBean(112, "Space", " "))
        add(KeyBean(146, "ABC"))
        add(KeyBean(145, "@", "@"))
        add(KeyBean(144, "Close", "", R.drawable.key_icon_close))
        add(KeyBean(147, "Delete", "", R.drawable.key_icon_del))
        add(KeyBean(148, "Next", ""))
        add(KeyBean(149, "123?", ""))
        add(KeyBean(150, "Aa", "", R.drawable.key_icon_lower_case))
        add(KeyBean(151, "Show", ""))
        add(KeyBean(152, "Enter", "\r"))
        add(KeyBean(153, "Sym", ""))
        add(KeyBean(256, "Back", ""))
    }

    private fun row(vararg codes: Int): List<KeyBean> = codes.map { keys.get(it) }

    private fun setWeight(code: Int, weight: Float) { keys.get(code).weight = weight }

    /** Listener global de layout: detecta mudança de visibilidade do teclado. Original: KeyUtils$a */
    private class HeightListener(private val window: Window) : KeyboardLayoutListener() {
        override fun onGlobalLayout() {
            val kb = keyboards[id]
            val visible = kb != null && kb.visibility == View.VISIBLE
            decorHeight = window.decorView.height
            val wasShown = keyboardShown
            if ((wasShown && !visible) || (!wasShown && visible)) {
                keyboardShown = visible
                visibilityListeners[id]!!.onVisibilityChanged(decorHeight, keyboardShown, id)
            }
        }
    }

    /** Implementação padrão: sobe a tela quando o teclado cobre o EditText. Original: KeyUtils$b */
    private class DefaultVisibilityListener : KeyboardVisibilityListener {
        override fun onVisibilityChanged(height: Int, visible: Boolean, id: Int) {
            val kb = keyboards[id]
            if (kb != null && kb.getFocusedEditText() != null) {
                if (visible) kb.moveContentAboveKeyboard(height) else kb.restoreContent()
            }
        }
    }

    /** Observa o Lifecycle da activity pelo id do teclado. Original: KeyUtils.B(Lifecycle, int) */
    private fun observeLifecycle(lifecycle: Lifecycle, id: Int) {
        if (lifecycles.containsKey(id) || lifecycleObservers.containsKey(id)) return
        val observer = object : MyLifecycleObserver() {
            override fun onDestroy(owner: LifecycleOwner) {
                keyboards[this.id]?.destroy()
                removeLayoutListener(this.id)
                removeVisibilityListener(this.id)
                windows.remove(this.id)
                keyboards.remove(this.id)
                removeLifecycleObserver(this.id)
            }

            override fun onPause(owner: LifecycleOwner) {
                val kb = keyboards[this.id]
                if (kb != null) {
                    if (!showOnResume) visibilityBeforePause[this.id] = kb.visibility
                    kb.onPause()
                }
            }

            override fun onResume(owner: LifecycleOwner) {
                if (showOnResume || (visibilityBeforePause.containsKey(this.id) && visibilityBeforePause[this.id] == 0)) {
                    val kb = keyboards[this.id] ?: return
                    if (kb.parent == null) {
                        val window = windows[this.id]
                        if (window != null) attach(window, kb, 81)
                    }
                    kb.onResume()
                    currentKeyboard = kb
                }
            }
        }
        observer.id = id
        lifecycle.addObserver(observer)
        lifecycleObservers[id] = observer
        lifecycles[id] = lifecycle
    }

    @JvmStatic fun removeLayoutListener(id: Int) {
        val listener = layoutListeners[id]
        val window = windows[id]
        if (listener == null || window == null) return
        window.decorView.viewTreeObserver.removeOnGlobalLayoutListener(listener)
    }

    @JvmStatic fun removeLifecycleObserver(id: Int) {
        val lifecycle = lifecycles[id]
        val observer = lifecycleObservers[id]
        if (lifecycle == null || observer == null) return
        lifecycle.removeObserver(observer)
        lifecycles.remove(id)
        lifecycleObservers.remove(id)
    }

    @JvmStatic fun removeVisibilityListener(id: Int) { visibilityListeners.remove(id) }

    @JvmStatic fun setKeyboardBackground(res: Int) { keyboardBackground = res }       // G
    @JvmStatic fun setPlatformType(type: String) { platformType = type }              // H
    @JvmStatic fun setPlatformSubType(type: String) { platformSubType = type }        // I
    @JvmStatic fun setFocusKeyBackground(res: Int) { focusKeyBackground = res }       // J
    @JvmStatic fun setKeyTextColor(res: Int) { keyTextColor = res; keyNextColor = res } // K
    @JvmStatic fun setNormalKeyBackground(res: Int) { normalKeyBackground = res }     // L

    /** Registra o OnGlobalLayoutListener no decorView. Original: KeyUtils.h(Window, int) */
    @JvmStatic fun addLayoutListener(window: Window?, id: Int) {
        if (layoutListeners.containsKey(id)) return
        val listener = createLayoutListener(window, id) ?: return
        if (window == null) return
        window.decorView.viewTreeObserver.addOnGlobalLayoutListener(listener)
        layoutListeners[id] = listener
    }

    /** Original: KeyUtils.i(int) */
    @JvmStatic fun addVisibilityListener(id: Int) {
        if (visibilityListeners.containsKey(id)) return
        visibilityListeners[id] = DefaultVisibilityListener()
    }

    /** Fecha popup/teclado do teclado atual; true se algo foi fechado. Original: KeyUtils.j() */
    @JvmStatic @Synchronized fun dismissCurrent(): Boolean =
        currentKeyboard?.dismiss() ?: false

    /** Original: KeyUtils.k() */
    @JvmStatic fun getCurrentKeyboard(): KeyboardContainer? = currentKeyboard

    /** Original: KeyUtils.l(Window, int) */
    @JvmStatic fun createLayoutListener(window: Window?, id: Int): ViewTreeObserver.OnGlobalLayoutListener? {
        val l = HeightListener(window ?: return null)
        l.id = id
        return l
    }

    /** Letras, paisagem (4 linhas). Original: KeyUtils.m() */
    @JvmStatic fun letterLandscape(): List<List<KeyBean>> {
        if (letterLandscape.isEmpty()) {
            letterLandscape.add(row(38, 50, 20, 39, 41, 52, 48, 24, 36, 37, 144))
            letterLandscape.add(row(16, 40, 19, 21, 22, 23, 25, 32, 33, 151))
            letterLandscape.add(row(103, 53, 51, 18, 49, 17, 35, 34, 97, 147))
            letterLandscape.add(row(150, 149, 153, 112, 148))
        }
        for (c in intArrayOf(72, 73, 80, 81, 97)) setWeight(c, 1.0f)
        setWeight(16, 1.25f); setWeight(103, 1.25f); setWeight(112, 5.0f)
        setWeight(151, 1.75f); setWeight(150, 1.75f); setWeight(147, 1.75f); setWeight(148, 2.25f)
        return letterLandscape
    }

    /** Letras+números, paisagem (5 linhas). Original: KeyUtils.n() */
    @JvmStatic fun letterNumberLandscape(): List<List<KeyBean>> {
        if (letterNumberLandscape.isEmpty()) {
            letterNumberLandscape.add(row(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 144))
            letterNumberLandscape.add(row(38, 50, 20, 39, 41, 52, 48, 24, 36, 37, 145))
            letterNumberLandscape.add(row(16, 40, 19, 21, 22, 23, 25, 32, 33, 151))
            letterNumberLandscape.add(row(103, 53, 51, 18, 49, 17, 35, 34, 97, 147))
            letterNumberLandscape.add(row(150, 149, 153, 112, 148))
        }
        for (c in intArrayOf(72, 73, 80, 81, 97)) setWeight(c, 1.0f)
        setWeight(103, 1.25f); setWeight(112, 5.0f); setWeight(151, 1.75f); setWeight(150, 1.75f)
        setWeight(16, 1.25f); setWeight(147, 1.75f); setWeight(148, 2.25f)
        return letterNumberLandscape
    }

    /** Teclado numérico "nine palace". Original: KeyUtils.o() */
    @JvmStatic fun ninePalaceNumber(): List<List<KeyBean>> {
        if (ninePalaceNumber.isEmpty()) {
            ninePalaceNumber.add(row(1, 2, 3, 144))
            ninePalaceNumber.add(row(4, 5, 6, 103))
            ninePalaceNumber.add(row(7, 8, 9, 147))
            ninePalaceNumber.add(row(97, 0, 148))
        }
        for (c in intArrayOf(72, 73, 80, 81, 97, 103, 112, 151, 150, 147)) setWeight(c, 1.0f)
        setWeight(148, 2.0f)
        return ninePalaceNumber
    }

    /** Teclado numérico com tecla "ABC". Original: KeyUtils.p() */
    @JvmStatic fun ninePalaceNumberWithAbc(): List<List<KeyBean>> {
        if (ninePalaceNumberWithAbc.isEmpty()) {
            ninePalaceNumberWithAbc.add(row(1, 2, 3, 144))
            ninePalaceNumberWithAbc.add(row(4, 5, 6, 103))
            ninePalaceNumberWithAbc.add(row(7, 8, 9, 147))
            ninePalaceNumberWithAbc.add(row(146, 0, 97, 148))
        }
        for (c in intArrayOf(72, 73, 80, 81, 97, 103, 112, 151, 150, 147, 148)) setWeight(c, 1.0f)
        return ninePalaceNumberWithAbc
    }

    /** Letras (e letras+números), retrato (6 linhas). Original: KeyUtils.q() */
    @JvmStatic fun letterPortrait(): List<List<KeyBean>> {
        if (letterPortrait.isEmpty()) {
            letterPortrait.add(row(38, 50, 20, 39, 41, 144))
            letterPortrait.add(row(52, 48, 24, 36, 37, 16))
            letterPortrait.add(row(40, 19, 21, 22, 23, 25))
            letterPortrait.add(row(32, 33, 53, 51, 18, 49))
            letterPortrait.add(row(17, 35, 34, 103, 97, 147))
            letterPortrait.add(row(150, 149, 153, 112, 148))
        }
        for (c in intArrayOf(72, 73, 80, 81)) setWeight(c, 1.0f)
        setWeight(97, 0.75f); setWeight(103, 0.75f); setWeight(112, 1.5f)
        setWeight(151, 1.0f); setWeight(150, 1.0f); setWeight(147, 1.5f); setWeight(148, 1.5f)
        return letterPortrait
    }

    /** Símbolos, retrato. Original: KeyUtils.r() */
    @JvmStatic fun symbolPortrait(): List<List<KeyBean>> {
        if (symbolPortrait.isEmpty()) {
            symbolPortrait.add(row(64, 65, 66, 67, 68, 144))
            symbolPortrait.add(row(69, 70, 100, 99, 103, 104))
            symbolPortrait.add(row(84, 85, 87, 86, 88, 89))
            symbolPortrait.add(row(82, 83, 72, 73, 80, 81))
            symbolPortrait.add(row(256, 97, 98, 101, 102, 147))
        }
        for (c in intArrayOf(72, 73, 80, 81, 97, 103, 112, 151, 150, 147, 148)) setWeight(c, 1.0f)
        return symbolPortrait
    }

    /** Símbolos, paisagem. Original: KeyUtils.s() */
    @JvmStatic fun symbolLandscape(): List<List<KeyBean>> {
        if (symbolLandscape.isEmpty()) {
            symbolLandscape.add(row(64, 65, 66, 67, 68, 69, 70, 144))
            symbolLandscape.add(row(82, 72, 73, 80, 81, 83))
            symbolLandscape.add(row(84, 85, 87, 86, 88, 89, 104, 99))
            symbolLandscape.add(row(256, 97, 98, 100, 101, 102, 103, 147))
        }
        for (c in intArrayOf(72, 73, 80, 81)) setWeight(c, 1.5f)
        for (c in intArrayOf(97, 103, 112, 151, 150, 147, 148)) setWeight(c, 1.0f)
        return symbolLandscape
    }

    /**
     * Cria o teclado, registra window/listeners/lifecycle e o anexa ao decorView.
     * Retorna null (teclado desativado) quando platformType == "A" ou (platformType == "C" e
     * platformSubType == "A"). Original: KeyUtils.t(Window, Context, View, Lifecycle, boolean)
     */
    @JvmStatic
    fun create(window: Window?, context: Context, view: View?, lifecycle: Lifecycle, z: Boolean): KeyboardContainer? =
        create(window, context, view, lifecycle, z, true, addAdjustFlag = true)

    /** Original: KeyUtils.u(..., boolean showOnResume) — igual a t() mas sem addFlags(131072) */
    @JvmStatic
    fun create(window: Window?, context: Context, view: View?, lifecycle: Lifecycle, z: Boolean, showOnResume: Boolean): KeyboardContainer? =
        create(window, context, view, lifecycle, z, showOnResume, addAdjustFlag = false)

    private fun create(
        window: Window?, context: Context, view: View?, lifecycle: Lifecycle,
        z: Boolean, showOnResume: Boolean, addAdjustFlag: Boolean
    ): KeyboardContainer? {
        var kb: KeyboardContainer? = null
        if (platformType != "A" && (platformType != "C" || platformSubType != "A")) {
            if (window != null && view != null) {
                kb = KeyboardContainer(context, view, false)
                window.setSoftInputMode(3)
                if (addAdjustFlag) window.addFlags(131072) // FLAG_ALT_FOCUSABLE_IM
                addLayoutListener(window, view.id)
                addVisibilityListener(view.id)
                windows[view.id] = window
                keyboards[view.id] = kb
                attach(window, kb, 81)
                observeLifecycle(lifecycle, view.id)
            }
            currentKeyboard = kb
            this.showOnResume = if (addAdjustFlag) true else showOnResume
        }
        return kb
    }

    /** Adiciona o teclado (invisível) ao decorView. Original: KeyUtils.v(Window, ViewGroup, int gravity) */
    @JvmStatic
    fun attach(window: Window?, keyboard: ViewGroup, gravity: Int) {
        if (window == null) return
        check(keyboard.parent == null) { "Initialized already." }
        val decor = window.decorView
        if (decor is FrameLayout) {
            val lp = FrameLayout.LayoutParams(-2, -2)
            lp.gravity = gravity
            decor.addView(keyboard, 0, lp)
            keyboard.visibility = View.GONE
        }
    }

    /** Teclas de função (144..256). Original: KeyUtils.x */
    @JvmStatic fun isFunctionKey(code: Int) = code in 144..256

    /** Teclas de par de colchetes/aspas (o cursor fica entre os dois caracteres). Original: KeyUtils.y */
    @JvmStatic fun isPairKey(code: Int) =
        code == 72 || code == 73 || code == 80 || code == 81 || code == 82 || code == 83 || code == 99

    /** Teclas invisíveis 294..295. Original: KeyUtils.z */
    @JvmStatic fun isHiddenKey(code: Int) = code in 294..295

    /** Original: KeyUtils.w */
    @JvmStatic fun isEnabledKey(code: Int) = !isHiddenKey(code)

    /** Linhas de teclas para o tipo de teclado e orientação. Original: KeyUtils.A(String, boolean portrait) */
    @JvmStatic
    fun layoutFor(type: String, portrait: Boolean): List<List<KeyBean>>? = when (type) {
        "ninePalaceNumberWithABC" -> ninePalaceNumberWithAbc()
        "ninePalaceNumber" -> ninePalaceNumber()
        "letter" -> if (portrait) letterPortrait() else letterLandscape()
        "symbol" -> if (portrait) symbolPortrait() else symbolLandscape()
        "letterNumber" -> if (portrait) letterPortrait() else letterNumberLandscape()
        else -> null
    }

    /** Pesos das teclas (usado por [KeyboardContainer]). Original: KeyUtils.M(int, float) */
    @JvmStatic fun setKeyWeight(code: Int, weight: Float) = setWeight(code, weight)
}
