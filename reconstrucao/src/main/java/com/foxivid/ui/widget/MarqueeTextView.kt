package com.foxivid.ui.widget

import android.content.Context
import android.graphics.Canvas
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.text.TextUtils
import android.util.AttributeSet
import java.util.concurrent.atomic.AtomicBoolean

/**
 * TextView de letreiro desenhado manualmente (canvas.drawText) que rola da direita para a esquerda
 * uma vez e depois limpa o texto. Velocidade fixa via [setSpeed] ou, com step == 0, desacelera
 * conforme o texto se aproxima do centro (mínimo [minSpeed]).
 *
 * Original: t/v/c/widget/MarqueeTextView.java (enum a = Speed, classe interna c = MarqueeHandler)
 */
class MarqueeTextView : TextView {

    /** Original: MarqueeTextView$a. Passo em px por quadro de 30 ms: 1, 3, 5, 7, 9. */
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

    constructor(context: Context) : super(context) { init() }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) { init() }
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) { init() }

    /** Original: MarqueeTextView$c — avança a posição a cada 30 ms enquanto visível. */
    private inner class MarqueeHandler(looper: Looper) : Handler(looper) {
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
                } else if (!stopMarquee) {
                    sendEmptyMessageDelayed(0, 30L)
                }
            }
            super.handleMessage(msg)
        }
    }

    private fun init() {
        setSingleLine()
        ellipsize = TextUtils.TruncateAt.MARQUEE
        marqueeRepeatLimit = -1
    }

    override fun onAttachedToWindow() {
        stopMarquee = false
        if (text.isNotEmpty()) handler.sendEmptyMessageDelayed(0, 2000L)
        super.onAttachedToWindow()
    }

    override fun onDetachedFromWindow() {
        stopMarquee = true
        if (handler.hasMessages(0)) handler.removeMessages(0)
        super.onDetachedFromWindow()
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

    /** Reinicia o letreiro com o novo texto (começa fora da tela à esquerda, após 2 s). */
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
