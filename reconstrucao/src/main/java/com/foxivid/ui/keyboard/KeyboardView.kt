package com.foxivid.ui.keyboard

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import android.widget.LinearLayout

/**
 * Versão mais antiga/simples do teclado virtual de TV: um LinearLayout vertical (em vez de
 * FrameLayout) com a mesma construção de linhas, mesmas teclas e mesmas ações de [KeyboardContainer],
 * mas sem navegação D-pad própria nem deslocamento do conteúdo da tela. Não é referenciada por nenhuma
 * outra classe do app (código morto/legado); o teclado efetivamente usado é [KeyboardContainer].
 *
 * Diferenças observadas em relação a [KeyboardContainer]:
 *  - `onTouchListener` do EditText chama `requestFocus()` antes de abrir (b.d);
 *  - clique longo (OK, repeatCount 5) no EditText abre o teclado (listener f);
 *  - `J(EditText)` esconde o teclado se `inputType == 0`;
 *  - "Next" (h): foca o próximo EditText chamando `J(next)` diretamente;
 *  - cores/backgrounds de tecla são campos da própria view (setKeyTextColor/setKeyNextColor/
 *    setFunctionKeyBackground/setNextKeyBackground/setNormalKeyBackground) e não estáticos de [KeyUtils];
 *  - expõe setters de listeners (KeyDown k, Keyboard l, CreateKey m) sem corpo decompilado.
 * O restante (modo de arrastar, animação de pulso, backspace, inserção de texto, alternância de tipos)
 * é idêntico ao de [KeyboardContainer].
 *
 * Original: ziyi/kit/keyboard/KeyboardView.java (classes internas a..j = listeners/animações anônimos)
 */
class KeyboardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var keyboardType: String? = null
    private var normalKeyBackground = 0       // f23316i/f23318k...
    private var upperCase = false             // B
    private var showNumbers = true            // C

    /** Implementação delegada (aproximação do legado; ver KDoc da classe). */
    private val delegate: KeyboardContainer by lazy { KeyboardContainer(context).also { addView(it) } }

    fun getKeyboardType(): String? = keyboardType

    /** Original: KeyboardView.J(EditText) — mostra o teclado para o EditText. */
    fun showFor(editText: EditText) {
        if (editText.inputType == 0) {
            visibility = GONE
            return
        }
        // INFERIDO (legado, não usado): o original (J, ~1150 linhas) é quase cópia de KeyboardContainer.showFor; delega-se a ele.
        delegate.showFor(editText)
        visibility = VISIBLE
    }

    /** Original: KeyboardView.l() — reconstrói as linhas (igual a KeyboardContainer.rebuild). */
    fun rebuild() {
        // INFERIDO (legado, não usado): mesma construção de linhas de KeyboardContainer.rebuild.
        delegate.rebuild()
    }
}
