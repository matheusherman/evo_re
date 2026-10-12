package com.foxivid.ui.mobile.widget.sloading

import android.content.Context
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PixelFormat
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable

/**
 * Drawable animado que encapsula um [SLoadingBuilder] (repassa invalidação/agendamento ao Drawable).
 * Original: com/tvc/lib/mobile/ui/widget/sloading/b.java
 */
class SLoadingDrawable(private val builder: SLoadingBuilder) : Drawable(), Animatable {

    init {
        builder.setCallback(object : Callback {
            override fun invalidateDrawable(who: Drawable) { invalidateSelf() }
            override fun scheduleDrawable(who: Drawable, what: Runnable, `when`: Long) { scheduleSelf(what, `when`) }
            override fun unscheduleDrawable(who: Drawable, what: Runnable) { unscheduleSelf(what) }
        })
    }

    @Deprecated("Deprecated in Java")
    override fun getOpacity(): Int = PixelFormat.TRANSLUCENT // -3

    /** Original: b.a(Context, int) */
    fun init(context: Context, extraColor: Int) {
        builder.init(context)
        builder.initParams(context, extraColor)
    }

    override fun getIntrinsicHeight(): Int = builder.getHeightPx().toInt()
    override fun getIntrinsicWidth(): Int = builder.getWidthPx().toInt()
    override fun isRunning(): Boolean = builder.isRunning()
    override fun setAlpha(alpha: Int) = builder.setAlpha(alpha)
    override fun setColorFilter(colorFilter: ColorFilter?) = builder.setColorFilter(colorFilter)
    override fun start() = builder.start()
    override fun stop() = builder.stop()

    override fun draw(canvas: Canvas) {
        if (!bounds.isEmpty) builder.drawTo(canvas)
    }
}
