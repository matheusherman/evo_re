package com.live.evo.catchup

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup

/**
 * Grade de EPG desenhada manualmente em Canvas (estilo "TV Guide": coluna de canais à esquerda, linha do
 * tempo e blocos de programas), com navegação por D-pad (`onKey`), cálculo de posição ↔ tempo
 * (L(int), M(int), O(long)) e scroll horizontal por tempo. `V(int,int)` posiciona o foco.
 * Usa [EpgDataStore] e [com.live.evo.model.ProgramBean]; dispara [CatchUpClickListener] ao confirmar.
 *
 * Original: com/live/evo/catchup/EPG.java (1667 linhas) — não reconstruído linha a linha (rotina de desenho).
 */
class EPG @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : ViewGroup(context, attrs), View.OnKeyListener {
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {}
    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean = TODO("navegação D-pad na grade — ver EPG.onKey")
}

/**
 * Variante "D-style" da grade EPG (mesma ideia, layout diferente; usa `sync` em `o0()` e listas O/P de programas).
 * Original: com/live/evo/catchup/EPG_Dstyle.java (2223 linhas) — resumo.
 */
class EPG_Dstyle @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : ViewGroup(context, attrs), View.OnKeyListener {
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {}
    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean = TODO("ver EPG_Dstyle.onKey")
}

/** Base da "grande EPG". Original: com/live/evo/catchup/LargeEpg/a.java */
abstract class LargeEpgBase @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : ViewGroup(context, attrs)

/**
 * Grande EPG (categorias × canais × tempo); calcula primeira/última categoria/canal visíveis e posição X de início.
 * Original: com/live/evo/catchup/LargeEpg/EpgView.java
 */
class EpgView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : LargeEpgBase(context, attrs) {
    fun setInitData(flag: Boolean) {}
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {}
}
