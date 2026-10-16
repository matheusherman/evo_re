package com.live.evo.catchup

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup

/*
 * As grades `EPG` (com/live/evo/catchup/EPG.java) e `EPG_Dstyle` (EPG_Dstyle.java) estão reconstruídas por completo em
 * com.live.evo.fragment.epg (EPG.kt / EPG_Dstyle.kt); os stubs duplicados que ficavam aqui foram removidos.
 */

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
