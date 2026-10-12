package com.foxivid.ui.widget

import android.content.Context
import android.graphics.Canvas
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.foxivid.baselib.marquee.MarqueeManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Letreiro global: igual ao [MarqueeTextView], mas se registra no [MarqueeManager] como
 * `MarqueeListener` (anexado -> addListener; desanexado -> removeListener) para receber o texto
 * agendado. Quando fica invisível o handler se remove do manager e volta ao ficar visível.
 *
 * Original: t/v/c/widget/GlobalMarqueeTextView.java (enum a = Speed, c = handler, d/e = corrotinas
 * de start/stop executadas no Main)
 */
class GlobalMarqueeTextView : AppCompatTextView, MarqueeManager.MarqueeListener {

    enum class Speed(val step: Int) { VERY_SLOW(1), SLOW(3), MIDDLE(5), FAST(7), VERY_FAST(9) }

    private var stopMarquee = false
    private var restartOffset = 0f
    private var text = ""
    private var coordinateX = 0f
    private var textWidth = 0f
    private var step = 0
    private var widthPerStep = 0
    private var halfWidth = 0
    private var maxStep = 0
    private var y = 0f
    private var notInit = true
    private val isInDisplay = AtomicBoolean(false)
    private var displayCount = 0
    private var minSpeed = 1.0f
    private val handler: Handler = MarqueeHandler(Looper.getMainLooper())
    private val mainScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    /** Original: GlobalMarqueeTextView$c */
    private inner class MarqueeHandler(looper: Looper) : Handler(looper) {
        private var listenerRemoved = false

        override fun handleMessage(msg: Message) {
            if (msg.what == 0) {
                if (coordinateX < restartOffset) {
                    if (displayCount > 0) {
                        text = ""
                        isInDisplay.set(false)
                    } else {
                        coordinateX = width.toFloat()
                        displayCount++
                        invalidate()
                        if (!stopMarquee) sendEmptyMessageDelayed(0, 30L)
                    }
                } else if (isShown) {
                    if (listenerRemoved) {
                        MarqueeManager.addListener(this@GlobalMarqueeTextView)
                        listenerRemoved = false
                    }
                    if (step == 0) {
                        val right = coordinateX + textWidth
                        var delta: Float
                        if (right > 0f) {
                            delta = Math.abs(right - halfWidth) / widthPerStep
                            if (delta <= minSpeed) delta = minSpeed
                        } else {
                            delta = minSpeed
                        }
                        coordinateX -= delta
                    } else {
                        coordinateX -= step
                    }
                    invalidate()
                    if (!stopMarquee) sendEmptyMessageDelayed(0, 30L)
                } else {
                    if (!listenerRemoved) {
                        MarqueeManager.removeListener(this@GlobalMarqueeTextView)
                        listenerRemoved = true
                    }
                    if (!stopMarquee) sendEmptyMessageDelayed(0, 30L)
                }
            }
            super.handleMessage(msg)
        }
    }

    override fun onAttachedToWindow() {
        stopMarquee = false
        if (text.isNotEmpty()) handler.sendEmptyMessageDelayed(0, 2000L)
        MarqueeManager.addListener(this)
        super.onAttachedToWindow()
    }

    override fun onDetachedFromWindow() {
        stopMarquee = true
        if (handler.hasMessages(0)) handler.removeMessages(0)
        MarqueeManager.removeListener(this)
        super.onDetachedFromWindow()
    }

    /** MarqueeListener.start: aceita o conteúdo só se estiver livre e visível. Original: GlobalMarqueeTextView.a(String) */
    override fun start(content: String): Boolean {
        if (stopMarquee) return false
        if ((visibility == 0 && !isShown) || !isInDisplay.compareAndSet(false, true)) return false
        mainScope.launch {
            visibility = 0
            setText(content)
        }
        return true
    }

    override fun isRunning(): Boolean = isShown && isInDisplay.get() && !stopMarquee

    override fun stop(): Boolean {
        if (visibility != 8 && !isInDisplay.get()) {
            mainScope.launch {
                visibility = 8
                text = ""
                if (handler.hasMessages(0)) handler.removeMessages(0)
            }
            return true
        }
        return false
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (text.isEmpty()) return
        if (notInit) {
            y = ((height * 3) shr 2).toFloat()
            widthPerStep = (width shr 1) / maxStep
            if (widthPerStep < 1) widthPerStep = 1
            halfWidth = (width + textWidth.toInt()) shr 1
            minSpeed = Speed.SLOW.step.toFloat()
            notInit = false
        }
        canvas.drawText(text, coordinateX, y, paint)
    }

    fun setSpeed(speed: Speed) { step = speed.step }

    fun setText(text: String?) {
        this.text = text ?: ""
        if (handler.hasMessages(0)) handler.removeMessages(0)
        if (this.text.isNotEmpty()) {
            textWidth = paint.measureText(this.text)
            restartOffset = -(textWidth + 100)
            notInit = true
            displayCount = 0
            coordinateX = restartOffset
            maxStep = Speed.VERY_FAST.step
            handler.sendEmptyMessageDelayed(0, 2000L)
        }
    }
}
