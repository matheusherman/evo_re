package com.live.evo.fragment.epg

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.SparseArray
import androidx.core.content.ContextCompat
import com.live.evo.model.ChannelData
import com.live.evo.model.ProgramBean

/**
 * Listener de clique da grade de EPG. No original (`x4/f.java`) a interface é **vazia** e o campo do listener nunca é
 * atribuído, então o R8 transformou os cliques em `throw null`. Os métodos abaixo são inferidos a partir dos
 * argumentos usados em `onKey` (canal `S.a(P)` e programa `S.d(P, Q)`).
 *
 * Original: x4/f.java (inferido)
 */
interface EpgClickListener {
    /** ENTER/OK sobre um canal cuja EPG já foi carregada e está vazia. */
    fun onEmptyChannelClick(channel: ChannelData)

    /** ENTER/OK sobre um programa de um canal. */
    fun onProgramClick(program: ProgramBean?, channel: ChannelData)
}

/**
 * Cache de bitmaps de ícones (drawable → Bitmap), compartilhado pelas duas grades.
 * Original: `EPG.K(Context, int)` / `EPG_Dstyle.K(...)` (campo `SparseArray<Bitmap> A`)
 */
class EpgBitmapCache {
    private val cache = SparseArray<Bitmap>()

    /** Desenha o drawable [resId] num Bitmap ARGB_8888 do tamanho intrínseco e guarda no cache. */
    fun get(context: Context, resId: Int): Bitmap {
        cache.get(resId)?.let { return it }
        val drawable: Drawable = ContextCompat.getDrawable(context, resId)!!
        val bitmap = Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        cache.put(resId, bitmap)
        return bitmap
    }
}
