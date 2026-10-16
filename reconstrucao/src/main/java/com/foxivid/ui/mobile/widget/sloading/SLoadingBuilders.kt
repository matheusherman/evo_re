package com.foxivid.ui.mobile.widget.sloading

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PathMeasure
import android.graphics.PointF
import android.graphics.RectF
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.LinearInterpolator
import java.util.LinkedList

/*
 * Implementações concretas de [SLoadingBuilder] (animações de loading). Os nomes originais estão ofuscados no pacote `x7`
 * (x7/a..x7/r); os nomes abaixo seguem o valor de [SLoadingType] que instancia cada classe.
 * Convenção dos mapeamentos para a base (com/tvc/lib/mobile/ui/widget/sloading/a.java): d() = [strokeSize], e()/f() = altura/largura,
 * g()/h() = [centerX]/[centerY], b(ctx, dp) = [dp]; k = initParams, n = draw, a = onAnimationFrame, o = onStop, p = onStart,
 * q = setAlpha, t = setColorFilter, s = setExtraColor.
 */

/**
 * Base dos loaders feitos de círculos Bézier (12 pontos de controle com deslocamento animável).
 * Original: x7/a.java (+ x7/a$a = ponto)
 */
internal abstract class BezierCircleBuilder : SLoadingBuilder() {
    protected val points = LinkedList<BezierPoint>()   // i
    protected var paint: Paint? = null                 // j

    /** Ponto de controle: posição fixa + deslocamento animado; pode ser ocultado. Original: x7/a$a */
    internal class BezierPoint(private val baseX: Float, private val baseY: Float) {
        private var offsetX = 0.0f
        private var offsetY = 0.0f
        private var visible = true
        fun draw(canvas: Canvas, radius: Float, paint: Paint) { if (visible) canvas.drawCircle(x(), y(), radius, paint) }
        fun x(): Float = baseX + offsetX
        fun y(): Float = baseY + offsetY
        fun setVisible(v: Boolean) { visible = v }
        fun setOffsetX(v: Float) { offsetX = v }
        fun setOffsetY(v: Float) { offsetY = v }
    }

    override fun setAlpha(alpha: Int) { paint!!.alpha = alpha }
    override fun setColorFilter(filter: ColorFilter?) { paint!!.colorFilter = filter }

    /** Pincel de preenchimento+traço, redondo. Original: a.z(float) */
    protected fun initPaint(strokeWidth: Float) {
        paint = Paint(Paint.ANTI_ALIAS_FLAG).also {
            it.style = Paint.Style.FILL_AND_STROKE
            it.strokeWidth = strokeWidth
            it.color = Color.BLACK
            it.isDither = true
            it.isAntiAlias = true
            it.isFilterBitmap = true
            it.strokeCap = Paint.Cap.ROUND
            it.strokeJoin = Paint.Join.ROUND
        }
    }

    /** Gera os 12 pontos de um círculo de raio [r] aproximado por 4 curvas cúbicas (kappa 0.55191505). Original: a.A(float) */
    protected fun buildCirclePoints(r: Float) {
        val cx = centerX()
        val cy = centerY()
        val left = cx - r
        val k = 0.55191505f * r
        val below = cy + k
        val leftK = cx - k
        val bottom = cy + r
        points.add(BezierPoint(left, cy))
        points.add(BezierPoint(left, below))
        points.add(BezierPoint(leftK, bottom))
        points.add(BezierPoint(cx, bottom))
        val rightK = cx + k
        points.add(BezierPoint(rightK, bottom))
        val right = cx + r
        points.add(BezierPoint(right, below))
        points.add(BezierPoint(right, cy))
        val above = cy - k
        points.add(BezierPoint(right, above))
        val top = cy - r
        points.add(BezierPoint(rightK, top))
        points.add(BezierPoint(cx, top))
        points.add(BezierPoint(leftK, top))
        points.add(BezierPoint(left, above))
    }

    /** Desenha o contorno fechado pelos 12 pontos. Original: a.y(canvas, path, paint) */
    protected fun drawBezierPath(canvas: Canvas, path: Path, paint: Paint) {
        path.reset()
        val p = points
        path.moveTo(p[0].x(), p[0].y())
        path.cubicTo(p[1].x(), p[1].y(), p[2].x(), p[2].y(), p[3].x(), p[3].y())
        path.cubicTo(p[4].x(), p[4].y(), p[5].x(), p[5].y(), p[6].x(), p[6].y())
        path.cubicTo(p[7].x(), p[7].y(), p[8].x(), p[8].y(), p[9].x(), p[9].y())
        path.cubicTo(p[10].x(), p[10].y(), p[11].x(), p[11].y(), p[0].x(), p[0].y())
        canvas.drawPath(path, paint)
    }
}

/**
 * CIRCLE: fatia (pizza) que cresce de -90° até 360° e depois "esvazia" (alternando a cada repetição).
 * Original: x7/b.java
 */
internal open class CircleLoadingBuilder : SLoadingBuilder() {
    private var oval: RectF? = null          // i
    private var piePaint: Paint? = null      // j
    private var startAngle = 0f              // k
    private var endAngle = 0f                // l
    private var growing = true               // m

    override fun onAnimationFrame(animator: ValueAnimator, fraction: Float) {
        if (growing) endAngle = fraction * 360.0f - 90.0f else startAngle = fraction * 360.0f - 90.0f
    }

    override fun initParams(context: Context, color: Int) {
        piePaint = Paint(Paint.ANTI_ALIAS_FLAG).also { it.color = Color.BLACK }
        initOval(context)
    }

    override fun onAnimationCancel(animation: Animator) { startAngle = -90.0f; endAngle = -90.0f }
    override fun onAnimationEnd(animation: Animator) { startAngle = -90.0f; endAngle = -90.0f }

    override fun onAnimationRepeat(animation: Animator) {
        val was = growing
        growing = !was
        if (was) { startAngle = -90.0f; endAngle = 270.0f } else { startAngle = -90.0f; endAngle = -90.0f }
    }

    override fun onAnimationStart(animation: Animator) { startAngle = -90.0f; endAngle = -90.0f }

    override fun setAlpha(alpha: Int) { piePaint!!.alpha = alpha }
    override fun setColorFilter(filter: ColorFilter?) { piePaint!!.colorFilter = filter }

    /** Original: b.y(Context) */
    private fun initOval(context: Context) {
        val r = strokeSize - dp(context, 3.0f)
        oval = RectF()
        startAngle = -90.0f
        endAngle = -90.0f
        val cx = centerX()
        val cy = centerY()
        oval!!.set(cx - r, cy - r, cx + r, cy + r)
    }

    override fun draw(canvas: Canvas) {
        canvas.save()
        canvas.drawArc(oval!!, startAngle, endAngle - startAngle, true, piePaint!!)
        canvas.restore()
    }

    override fun onStop() {}
    override fun onStart(animator: ValueAnimator) {}
}

/**
 * CIRCLE_CLOCK: o CIRCLE com um aro externo e "pino" de relógio no topo.
 * Original: x7/c.java
 */
internal class CircleClockLoadingBuilder : CircleLoadingBuilder() {
    private var ringRadius = 0f          // n
    private var ringStroke = 0f          // o
    private var ringPaint: Paint? = null // p
    private var pinPaint: Paint? = null  // q
    private var pinTop: RectF? = null    // r
    private var pinBase: RectF? = null   // s

    private fun initRingPaint() {
        ringPaint = Paint(Paint.ANTI_ALIAS_FLAG).also {
            it.style = Paint.Style.STROKE
            it.strokeWidth = ringStroke
            it.color = Color.BLACK
        }
    }

    private fun initPinPaint() {
        pinPaint = Paint(Paint.ANTI_ALIAS_FLAG).also {
            it.style = Paint.Style.FILL_AND_STROKE
            it.color = Color.BLACK
        }
    }

    private fun initShapes(context: Context) {
        val r = strokeSize
        ringStroke = 4.0f
        ringRadius = r - 4.0f
        val w1 = dp(context, 8.0f)
        val h1 = dp(context, 3.0f)
        val w2 = dp(context, 3.0f)
        val gap = dp(context, 2.0f)
        val half1 = w1 / 2.0f
        pinTop = RectF(centerX() - half1, ((centerY() - r) - gap) - h1, centerX() + half1, (centerY() - r) - gap)
        val half2 = w2 / 2.0f
        pinBase = RectF(centerX() - half2, (centerY() - r) - gap, centerX() + half2, centerY() - r)
    }

    override fun initParams(context: Context, color: Int) {
        super.initParams(context, color)
        initShapes(context)
        initRingPaint()
        initPinPaint()
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.drawCircle(centerX(), centerY(), ringRadius, ringPaint!!)
        canvas.drawRect(pinTop!!, pinPaint!!)
        canvas.drawRect(pinBase!!, pinPaint!!)
        canvas.save()
        canvas.rotate(45.0f, centerX(), centerY())
        canvas.drawRect(pinBase!!, pinPaint!!)
        canvas.restore()
        canvas.translate(0.0f, 20.0f)
    }

    override fun setAlpha(alpha: Int) {
        super.setAlpha(alpha)
        ringPaint!!.alpha = alpha
        pinPaint!!.alpha = alpha
    }

    override fun setColorFilter(filter: ColorFilter?) {
        super.setColorFilter(filter)
        ringPaint!!.colorFilter = filter
        pinPaint!!.colorFilter = filter
    }
}

/**
 * DOUBLE_CIRCLE: dois arcos concêntricos girando em sentidos opostos.
 * Original: x7/d.java
 */
internal class DoubleCircleLoadingBuilder : SLoadingBuilder() {
    private var arcPaint: Paint? = null    // i
    private var outerOval: RectF? = null   // j
    private var innerOval: RectF? = null   // k
    private var angle = 0                  // l

    private fun initPaint(strokeWidth: Float) {
        arcPaint = Paint(Paint.ANTI_ALIAS_FLAG).also {
            it.style = Paint.Style.STROKE
            it.strokeWidth = strokeWidth
            it.color = -1
            it.isDither = true
            it.isAntiAlias = true
            it.isFilterBitmap = true
            it.strokeCap = Paint.Cap.ROUND
            it.strokeJoin = Paint.Join.ROUND
        }
    }

    override fun onAnimationFrame(animator: ValueAnimator, fraction: Float) { angle = (fraction * 360.0f).toInt() }
    override fun setAlpha(alpha: Int) { arcPaint!!.alpha = alpha }
    override fun setColorFilter(filter: ColorFilter?) { arcPaint!!.colorFilter = filter }

    override fun initParams(context: Context, color: Int) {
        val r = strokeSize
        val inner = 0.6f * r
        initPaint(0.3f * inner)
        angle = 0
        outerOval = RectF().also { it.set(centerX() - r, centerY() - r, centerX() + r, centerY() + r) }
        innerOval = RectF().also { it.set(centerX() - inner, centerY() - inner, centerX() + inner, centerY() + inner) }
    }

    override fun draw(canvas: Canvas) {
        canvas.save()
        canvas.drawArc(outerOval!!, (angle % 360).toFloat(), 270.0f, false, arcPaint!!)
        canvas.drawArc(innerOval!!, (270 - (angle % 360)).toFloat(), 90.0f, false, arcPaint!!)
        canvas.restore()
    }

    override fun onStop() {}
    override fun onStart(animator: ValueAnimator) {}
}

/**
 * ELASTIC_BALL: bola elástica que se deforma (3 fases de deslocamento com interpoladores diferentes) e "anda" por 5 posições,
 * indo e voltando.
 * Original: x7/e.java
 */
internal class ElasticBallLoadingBuilder : BezierCircleBuilder() {
    private val slots = LinkedList<BezierPoint>()   // k: 5 pontos de destino (círculos vazados)
    private var ballRadius = 0f                     // l
    private var path: Path? = null                  // m
    private var phase = 0                           // n (0..2)
    private var returning = false                   // p
    private var position = 0                        // q
    private var step = 0f                           // o

    override fun onAnimationFrame(animator: ValueAnimator, fraction: Float) {
        val d = step
        val stage = if (returning) phase + 3 else phase
        when (stage) {
            0 -> {
                animator.duration = 120L
                animator.interpolator = android.view.animation.AccelerateInterpolator()
                val v = d * fraction
                points[5].setOffsetX(v); points[6].setOffsetX(v); points[7].setOffsetX(v)
            }
            1 -> {
                animator.duration = 160L
                animator.interpolator = android.view.animation.DecelerateInterpolator()
                val v = d * fraction
                for (i in intArrayOf(2, 3, 4, 8, 9, 10)) points[i].setOffsetX(v)
            }
            2 -> {
                animator.duration = 240L
                animator.interpolator = android.view.animation.BounceInterpolator()
                val v = d * fraction
                points[0].setOffsetX(v); points[1].setOffsetX(v); points[11].setOffsetX(v)
            }
            3 -> {
                animator.duration = 120L
                animator.interpolator = android.view.animation.AccelerateInterpolator()
                val v = d * (1.0f - fraction)
                points[0].setOffsetX(v); points[1].setOffsetX(v); points[11].setOffsetX(v)
            }
            4 -> {
                animator.duration = 160L
                animator.interpolator = android.view.animation.DecelerateInterpolator()
                val v = d * (1.0f - fraction)
                for (i in intArrayOf(2, 3, 4, 8, 9, 10)) points[i].setOffsetX(v)
            }
            5 -> {
                animator.duration = 240L
                animator.interpolator = android.view.animation.BounceInterpolator()
                val v = d * (1.0f - fraction)
                points[5].setOffsetX(v); points[6].setOffsetX(v); points[7].setOffsetX(v)
            }
        }
    }

    override fun onAnimationRepeat(animation: Animator) {
        phase++
        if (phase > 2) {
            phase = 0
            if (returning) position-- else position++
            if (position >= 4) {
                returning = true
                position = 3
                for (i in slots.indices) slots[i].setVisible(i == slots.size - 1)
            } else if (position < 0) {
                returning = false
                position = 0
                for (i in slots.indices) slots[i].setVisible(i != 0)
            }
            if (returning) {
                points.forEach { it.setOffsetX(step) }
                slots[position + 1].setVisible(true)
                return
            }
            points.forEach { it.setOffsetX(0.0f) }
            slots[position].setVisible(false)
        }
    }

    override fun onStart(animator: ValueAnimator) { animator.duration = 120L }

    /** Círculos vazados dos 5 destinos. Original: e.B */
    private fun drawSlots(canvas: Canvas) {
        canvas.save()
        paint!!.style = Paint.Style.STROKE
        slots.forEach { it.draw(canvas, ballRadius, paint!!) }
        canvas.restore()
    }

    /** Bola elástica deslocada para a posição atual. Original: e.C */
    private fun drawBall(canvas: Canvas) {
        canvas.save()
        paint!!.style = Paint.Style.FILL_AND_STROKE
        val half = (slots.size / 2).toFloat()
        canvas.translate(-(half * step) + step * position, 0.0f)
        drawBezierPath(canvas, path!!, paint!!)
        canvas.restore()
    }

    /** Original: e.D */
    private fun buildSlots() {
        val cx = centerX()
        val cy = centerY()
        val first = BezierPoint(cx - step * 2.0f, cy)
        val second = BezierPoint(cx - step, cy)
        val third = BezierPoint(cx, cy)
        val fourth = BezierPoint(step + cx, cy)
        val fifth = BezierPoint(cx + step * 2.0f, cy)
        first.setVisible(false)
        slots.add(first); slots.add(second); slots.add(third); slots.add(fourth); slots.add(fifth)
    }

    override fun initParams(context: Context, color: Int) {
        ballRadius = strokeSize / 5.0f
        step = getWidth() / 5.0f
        path = Path()
        initPaint(5.0f)
        buildCirclePoints(ballRadius)
        buildSlots()
    }

    override fun draw(canvas: Canvas) {
        drawSlots(canvas)
        drawBall(canvas)
    }

    override fun onStop() {}
}

/**
 * FADING_CIRCLE: 10 pontinhos em círculo, com transparência crescente, que giram; opcionalmente mostra um texto no centro.
 * Original: x7/f.java
 */
internal class FadingCircleLoadingBuilder : SLoadingBuilder() {
    private var dotPaint: Paint? = null       // i
    private var ringRadius = 0f               // j
    private var dotRadius = 0f                // k
    private var angle = 0                     // l
    private val dotCount = 10                 // m
    private var textPaint: android.text.TextPaint? = null   // n
    private var label: String = ""            // o
    private var textSizePx = 0f               // p
    private var showText = false              // q

    private fun drawDots(canvas: Canvas) {
        var i = 0
        while (i < dotCount) {
            val a = (360 / dotCount) * i
            val x = (Math.cos((angle + a) * Math.PI / 180.0).toFloat() * ringRadius) + centerX()
            val y = (Math.sin((angle + a) * Math.PI / 180.0).toFloat() * ringRadius) + centerY()
            i++
            dotPaint!!.alpha = (i * 255) / dotCount
            canvas.drawCircle(x, y, dotRadius, dotPaint!!)
        }
        if (showText) {
            dotPaint!!.alpha = 255
            dotPaint!!.textSize = textSizePx
            dotPaint!!.textAlign = Paint.Align.CENTER
            val fm = dotPaint!!.fontMetrics
            val bottom = fm.bottom
            canvas.drawText(label, centerX(), centerY() + (((bottom - fm.top) / 2.0f) - bottom), dotPaint!!)
        }
    }

    private fun initPaint() {
        dotPaint = Paint(Paint.ANTI_ALIAS_FLAG).also {
            it.style = Paint.Style.FILL
            it.color = -1
            it.isDither = true
            it.isFilterBitmap = true
            it.strokeCap = Paint.Cap.ROUND
            it.strokeJoin = Paint.Join.ROUND
        }
        textPaint = android.text.TextPaint()
    }

    override fun onAnimationFrame(animator: ValueAnimator, fraction: Float) { angle = (fraction * 360.0f).toInt() }
    override fun setAlpha(alpha: Int) { dotPaint!!.alpha = alpha }
    override fun setColorFilter(filter: ColorFilter?) { dotPaint!!.colorFilter = filter }
    override fun setText(text: String?) { label = text ?: "" }
    override fun setTextVisible(visible: Boolean) { showText = visible }

    override fun initParams(context: Context, color: Int) {
        initPaint()
        val r = strokeSize
        ringRadius = r
        dotRadius = dp(context, r / 10.0f)
        textSizePx = dp(context, ringRadius / 4.0f)
    }

    override fun draw(canvas: Canvas) = drawDots(canvas)
    override fun onStop() {}
    override fun onStart(animator: ValueAnimator) {}
    override fun setExtraColor(color: Int) {}
}

/**
 * INFECTION_BALL: bola que "pinga", alonga-se para baixo (5 fases: cai, espalha, sobe, desfaz e some em fade).
 * Original: x7/g.java
 */
internal class InfectionBallLoadingBuilder : BezierCircleBuilder() {
    private var radius = 0f          // k
    private var path: Path? = null   // l
    private var phase = 0            // m (0..4)
    private var span = 0f            // n

    override fun onAnimationFrame(animator: ValueAnimator, fraction: Float) {
        val d = span
        when (phase) {
            0 -> {
                animator.duration = 888L
                animator.interpolator = android.view.animation.AccelerateInterpolator()
                val v = fraction * d
                points[2].setOffsetY(v); points[3].setOffsetY(v); points[4].setOffsetY(v)
            }
            1 -> {
                animator.duration = 222L
                animator.interpolator = LinearInterpolator()
                val v = fraction * d
                for (i in intArrayOf(5, 6, 7, 1, 0, 11)) points[i].setOffsetY(v)
            }
            2 -> {
                animator.duration = 333L
                animator.interpolator = android.view.animation.AccelerateInterpolator()
                for (i in points.indices) {
                    if (i > 10 || i < 8) points[i].setOffsetY((fraction * d) + d) else points[i].setOffsetY(fraction * d)
                }
            }
            3 -> {
                animator.duration = 1333L
                animator.interpolator = android.view.animation.DecelerateInterpolator()
                val v = fraction * d
                val v2 = v + d
                points[8].setOffsetY(v2); points[9].setOffsetY(v2); points[10].setOffsetY(v2)
                points[5].setOffsetX(v); points[6].setOffsetX(v); points[7].setOffsetX(v)
                val neg = (-fraction) * d
                points[1].setOffsetX(neg); points[0].setOffsetX(neg); points[11].setOffsetX(neg)
            }
            4 -> {
                animator.duration = 1333L
                paint!!.alpha = ((1.0f - fraction) * 255.0f).toInt()
            }
        }
    }

    override fun onAnimationRepeat(animation: Animator) {
        phase++
        if (phase > 4) {
            phase = 0
            for (p in points) { p.setOffsetY(0.0f); p.setOffsetX(0.0f) }
            paint!!.alpha = 255
        }
    }

    private fun drawBall(canvas: Canvas) {
        canvas.save()
        paint!!.style = Paint.Style.FILL_AND_STROKE
        canvas.translate(0.0f, -span)
        drawBezierPath(canvas, path!!, paint!!)
        canvas.restore()
    }

    override fun initParams(context: Context, color: Int) {
        radius = strokeSize / 3.0f
        span = getWidth() / 3.0f
        path = Path()
        initPaint(5.0f)
        buildCirclePoints(radius)
    }

    override fun draw(canvas: Canvas) = drawBall(canvas)
    override fun onStop() {}
    override fun onStart(animator: ValueAnimator) {}
}

/**
 * INTERTWINE: círculo Bézier cujos pontos se afastam/aproximam em diagonal (2 fases, repetindo), dando efeito de entrelaçar.
 * Original: x7/h.java
 */
internal class IntertwineLoadingBuilder : BezierCircleBuilder() {
    private var radius = 0f          // k
    private var path: Path? = null   // l
    private var phase = 0            // m

    override fun onAnimationFrame(animator: ValueAnimator, fraction: Float) {
        when (phase) {
            0 -> {
                animator.interpolator = android.view.animation.AccelerateInterpolator()
                for (i in points.indices) {
                    val p = points[i]
                    if (i in 2..7) { p.setOffsetX(-radius * fraction); p.setOffsetY(-radius * fraction) }
                    else { p.setOffsetX(radius * fraction); p.setOffsetY(radius * fraction) }
                }
            }
            1 -> {
                animator.interpolator = android.view.animation.AccelerateInterpolator()
                for (i in points.indices) {
                    val p = points[i]
                    val rest = 1.0f - fraction
                    if (i in 2..7) { p.setOffsetX(-radius * rest); p.setOffsetY(-radius * rest) }
                    else { p.setOffsetX(radius * rest); p.setOffsetY(radius * rest) }
                }
            }
        }
    }

    override fun onAnimationRepeat(animation: Animator) {
        phase++
        if (phase > 1) {
            phase = 0
            for (p in points) { p.setOffsetY(0.0f); p.setOffsetX(0.0f) }
        }
    }

    private fun drawShape(canvas: Canvas) {
        canvas.save()
        paint!!.style = Paint.Style.FILL_AND_STROKE
        drawBezierPath(canvas, path!!, paint!!)
        canvas.restore()
    }

    override fun initParams(context: Context, color: Int) {
        radius = strokeSize
        path = Path()
        initPaint(5.0f)
        buildCirclePoints(radius)
    }

    override fun draw(canvas: Canvas) = drawShape(canvas)
    override fun onStop() {}
    override fun onStart(animator: ValueAnimator) {}
}

/**
 * LEAF_ROTATE: forma de "flor/estrela" de 5 pétalas (curvas quadráticas) com um furo central, que cresce, gira e encolhe.
 * Original: x7/i.java
 */
internal class LeafRotateLoadingBuilder : SLoadingBuilder() {
    private var fillPaint: Paint? = null   // i
    private var outerCtrl = 0f             // j
    private var innerR = 0f                // k
    private var outerR = 0f                // l (raio externo animado)
    private var innerCtrl = 0f             // m
    private var holeRadius = 0f            // n
    private var rotation = 0               // o
    private var phase = 0                  // p
    private var path: Path? = null         // q

    private fun sin(deg: Int): Float = Math.sin(deg * Math.PI / 180.0).toFloat()   // B
    private fun cos(deg: Int): Float = Math.cos(deg * Math.PI / 180.0).toFloat()   // y

    private fun initPaint() {
        fillPaint = Paint(Paint.ANTI_ALIAS_FLAG).also {
            it.style = Paint.Style.FILL
            it.strokeWidth = 2.0f
            it.color = -1
            it.isDither = true
            it.isFilterBitmap = true
        }
    }

    override fun onAnimationFrame(animator: ValueAnimator, fraction: Float) {
        when (phase) {
            0 -> { outerR = strokeSize * fraction; rotation = (fraction * 360.0f).toInt() }
            1 -> rotation = ((1.0f - fraction) * 360.0f).toInt()
            2 -> outerR = strokeSize * (1.0f - fraction)
        }
    }

    override fun onAnimationRepeat(animation: Animator) {
        phase++
        if (phase > 2) phase = 0
    }

    override fun onStart(animator: ValueAnimator) { animator.interpolator = android.view.animation.DecelerateInterpolator() }
    override fun setAlpha(alpha: Int) { fillPaint!!.alpha = alpha }
    override fun setColorFilter(filter: ColorFilter?) { fillPaint!!.colorFilter = filter }

    /** Monta o contorno com [petals] pétalas, a partir do ângulo [start]. Original: i.z(path, n, a) */
    private fun buildPath(path: Path, petals: Int, start: Int) {
        path.reset()
        val step = 360 / petals
        val half = step / 2
        val a0 = start - 5
        path.moveTo(centerX() + (outerR * cos(a0)), centerY() + (outerR * sin(a0)))
        for (i in 0 until petals) {
            val a = (step * i) + start
            val before = a - 5
            path.lineTo(centerX() + (outerR * cos(before)), centerY() + (outerR * sin(before)))
            val after = a + 5
            path.quadTo(centerX() + (outerCtrl * cos(a)), centerY() + (outerCtrl * sin(a)), centerX() + (outerR * cos(after)), centerY() + (outerR * sin(after)))
            val mid = a + half
            val midBefore = mid - 5
            path.lineTo(centerX() + (innerR * cos(midBefore)), centerY() + (innerR * sin(midBefore)))
            val cx = centerX() + (innerCtrl * cos(mid))
            val cy = centerY() + (innerCtrl * sin(mid))
            val midAfter = mid + 5
            path.quadTo(cx, cy, centerX() + (innerR * cos(midAfter)), centerY() + (innerR * sin(midAfter)))
        }
        path.close()
    }

    override fun initParams(context: Context, color: Int) {
        initPaint()
        val r = strokeSize
        outerCtrl = r
        outerR = 0.9f * r
        innerR = 0.7f * r
        innerCtrl = r * 0.3f
        holeRadius = dp(context, 3.0f)
        rotation = 0
        path = Path()
    }

    override fun draw(canvas: Canvas) {
        canvas.save()
        canvas.rotate(rotation.toFloat(), centerX(), centerY())
        buildPath(path!!, 5, -18)
        path!!.addCircle(centerX(), centerY(), holeRadius, Path.Direction.CW)
        path!!.fillType = Path.FillType.EVEN_ODD
        canvas.drawPath(path!!, fillPaint!!)
        canvas.restore()
    }

    override fun onStop() {}
}

/**
 * PAC_MAN: "pac-man" (arco com boca) que anda da esquerda para a direita abrindo/fechando a boca e depois volta virado.
 * Original: x7/j.java
 */
internal class PacManLoadingBuilder : SLoadingBuilder() {
    private var pacPaint: Paint? = null     // i
    private var oval: RectF? = null         // j
    private var mouth = 0                   // k (ângulo da boca em graus)
    private var offset = 0f                 // l (deslocamento atual)
    private var step = 0                    // m (0..9)
    private var heading = 0                 // n (0 ou 180: sentido)
    private var travel = 0f                 // o (percurso total)
    private var base = 0f                   // p (início do trecho)
    private var originX = 0f                // q

    private fun initPaint() {
        pacPaint = Paint(Paint.ANTI_ALIAS_FLAG).also {
            it.style = Paint.Style.FILL
            it.color = -1
            it.isDither = true
            it.isFilterBitmap = true
            it.strokeCap = Paint.Cap.ROUND
            it.strokeJoin = Paint.Join.ROUND
        }
    }

    override fun onAnimationFrame(animator: ValueAnimator, fraction: Float) {
        val seg = travel / 5
        if (step < 5) {
            heading = 0
            offset = base + (seg * fraction)
        } else {
            heading = 180
            offset = base - (seg * fraction)
        }
        mouth = if (step % 2 == 0) ((fraction * 45.0f).toInt()) + 5 else (((1.0f - fraction) * 45.0f).toInt()) + 5
    }

    override fun onAnimationRepeat(animation: Animator) {
        step++
        if (step > 9) step = 0
        val seg = travel / 5
        base = if (step < 5) seg * step else seg * (5 - (step % 5))
    }

    override fun onStart(animator: ValueAnimator) { animator.duration = 333L }
    override fun setAlpha(alpha: Int) { pacPaint!!.alpha = alpha }
    override fun setColorFilter(filter: ColorFilter?) { pacPaint!!.colorFilter = filter }

    override fun initParams(context: Context, color: Int) {
        val r = strokeSize * 0.7f
        travel = getWidth() + (2.0f * r)
        initPaint()
        mouth = 45
        heading = 0
        originX = (-travel) * 0.5f
        offset = 0.0f
        oval = RectF(centerX() - r, centerY() - r, centerX() + r, centerY() + r)
    }

    override fun draw(canvas: Canvas) {
        canvas.save()
        canvas.translate(originX + offset, 0.0f)
        canvas.rotate(heading.toFloat(), centerX(), centerY())
        canvas.drawArc(oval!!, mouth.toFloat(), (360 - (mouth * 2)).toFloat(), true, pacPaint!!)
        canvas.restore()
    }

    override fun onStop() {}
}

/**
 * ROTATE_CIRCLE: 10 pontos em círculo, de tamanho/alfa crescentes, girando.
 * Original: x7/k.java
 */
internal class RotateCircleLoadingBuilder : SLoadingBuilder() {
    private var dotPaint: Paint? = null   // i
    private var ringRadius = 0f           // j
    private var angle = 0f                // k
    private var baseDot = 0f              // l

    private fun cos(deg: Int): Float = Math.cos(deg * Math.PI / 180.0).toFloat()   // y
    private fun sin(deg: Int): Float = Math.sin(deg * Math.PI / 180.0).toFloat()   // B

    private fun drawDots(canvas: Canvas) {
        for (i in 0 until 10) {
            val a = ((36 * i) + angle).toInt()
            val x = centerX() + (ringRadius * cos(a))
            val y = centerY() + (ringRadius * sin(a))
            dotPaint!!.alpha = 25 * i
            canvas.drawCircle(x, y, (i + baseDot) / 2.0f, dotPaint!!)
        }
    }

    private fun initPaint() {
        dotPaint = Paint(Paint.ANTI_ALIAS_FLAG).also {
            it.style = Paint.Style.FILL
            it.color = Color.BLACK
            it.isDither = true
            it.isFilterBitmap = true
            it.strokeCap = Paint.Cap.ROUND
            it.strokeJoin = Paint.Join.ROUND
        }
    }

    override fun onAnimationFrame(animator: ValueAnimator, fraction: Float) { angle = fraction * 360.0f }
    override fun setAlpha(alpha: Int) { dotPaint!!.alpha = alpha }
    override fun setColorFilter(filter: ColorFilter?) { dotPaint!!.colorFilter = filter }

    override fun initParams(context: Context, color: Int) {
        ringRadius = strokeSize
        initPaint()
        baseDot = dp(context, 2.0f)
    }

    override fun draw(canvas: Canvas) = drawDots(canvas)
    override fun onStop() {}
    override fun onStart(animator: ValueAnimator) {}
}

/**
 * ROTATE_SAMECIRCLE: 12 pontos do mesmo tamanho em círculo, com alfa crescente, girando.
 * Original: x7/l.java
 */
internal class RotateSameCircleLoadingBuilder : SLoadingBuilder() {
    private var dotPaint: Paint? = null   // i
    private var ringRadius = 0f           // j
    private var angle = 0f                // k
    private var dotSize = 0f              // l

    private fun cos(deg: Int): Float = Math.cos(deg * Math.PI / 180.0).toFloat()   // y
    private fun sin(deg: Int): Float = Math.sin(deg * Math.PI / 180.0).toFloat()   // B

    private fun drawDots(canvas: Canvas) {
        for (i in 0 until 12) {
            val a = ((30 * i) + angle).toInt()
            val x = centerX() + (ringRadius * cos(a))
            val y = centerY() + (ringRadius * sin(a))
            dotPaint!!.alpha = (16 * i) + 50
            canvas.drawCircle(x, y, dotSize / 2.0f, dotPaint!!)
        }
    }

    private fun initPaint() {
        dotPaint = Paint(Paint.ANTI_ALIAS_FLAG).also {
            it.style = Paint.Style.FILL
            it.color = Color.BLACK
            it.isDither = true
            it.isFilterBitmap = true
            it.strokeCap = Paint.Cap.ROUND
            it.strokeJoin = Paint.Join.ROUND
        }
    }

    override fun onAnimationFrame(animator: ValueAnimator, fraction: Float) { angle = fraction * 360.0f }
    override fun setAlpha(alpha: Int) { dotPaint!!.alpha = alpha }
    override fun setColorFilter(filter: ColorFilter?) { dotPaint!!.colorFilter = filter }

    override fun initParams(context: Context, color: Int) {
        ringRadius = strokeSize
        initPaint()
        dotSize = dp(context, 5.0f)
    }

    override fun draw(canvas: Canvas) = drawDots(canvas)
    override fun onStop() {}
    override fun onStart(animator: ValueAnimator) {}
}

/**
 * SEARCH_PATH: lupa desenhada por traço: o aro "corre" (cabo + círculo), depois o segmento é apagado e o círculo interno é recolhido.
 * Original: x7/m.java
 */
internal class SearchPathLoadingBuilder : SLoadingBuilder() {
    private var phase = 0                       // i (0..3)
    private var radius = 0f                     // j
    private var strokePaint: Paint? = null      // k
    private var outerPath: Path? = null         // l (aro externo)
    private var innerPath: Path? = null         // m (aro interno + cabo)
    private var measure: PathMeasure? = null    // n
    private var dst: Path? = null               // o (trecho a desenhar)

    private fun buildPaths() {
        val inner = radius * 0.4f
        outerPath = Path().also {
            it.addArc(RectF(centerX() - radius, centerY() - radius, centerX() + radius, centerY() + radius), 45.0f, 359.9f)
        }
        measure!!.setPath(outerPath, false)
        val pos = FloatArray(2)
        measure!!.getPosTan(0.0f, pos, null)
        innerPath = Path().also {
            it.addArc(RectF(centerX() - inner, centerY() - inner, centerX() + inner, centerY() + inner), 45.0f, 359.9f)
            it.lineTo(pos[0], pos[1])
        }
    }

    private fun resetDst() {
        dst!!.reset()
        dst!!.lineTo(0.0f, 0.0f)
    }

    private fun initPaint() {
        strokePaint = Paint(Paint.ANTI_ALIAS_FLAG).also {
            it.style = Paint.Style.STROKE
            it.strokeWidth = 15.0f
            it.color = Color.BLACK
            it.isDither = true
            it.isFilterBitmap = true
            it.strokeCap = Paint.Cap.ROUND
            it.strokeJoin = Paint.Join.ROUND
        }
    }

    private fun initPathObjects() {
        dst = Path()
        measure = PathMeasure()
    }

    override fun onAnimationFrame(animator: ValueAnimator, fraction: Float) {
        when (phase) {
            0, 1 -> {
                resetDst()
                measure!!.setPath(outerPath, false)
                val end = measure!!.length * fraction
                measure!!.getSegment((end.toDouble() - ((0.5 - Math.abs(fraction.toDouble() - 0.5)) * 200.0)).toFloat(), end, dst, true)
            }
            2 -> {
                resetDst()
                measure!!.setPath(outerPath, false)
                measure!!.getSegment(0.0f, measure!!.length * fraction, dst, true)
            }
            3 -> {
                measure!!.setPath(innerPath, false)
                val len = measure!!.length
                measure!!.getSegment((1.0f - fraction) * len, len, dst, true)
            }
        }
    }

    override fun draw(canvas: Canvas) { canvas.drawPath(dst!!, strokePaint!!) }

    override fun onAnimationRepeat(animation: Animator) {
        phase++
        if (phase > 3) phase = 0
    }

    override fun onStart(animator: ValueAnimator) { animator.interpolator = android.view.animation.DecelerateInterpolator() }
    override fun setAlpha(alpha: Int) { strokePaint!!.alpha = alpha }
    override fun setColorFilter(filter: ColorFilter?) { strokePaint!!.colorFilter = filter }

    override fun initParams(context: Context, color: Int) {
        radius = strokeSize
        initPaint()
        initPathObjects()
        buildPaths()
    }

    override fun onStop() {}
}

/**
 * SINGLE_CIRCLE: um arco que gira e cresce/encolhe (até 320°).
 * Original: x7/n.java
 */
internal class SingleCircleLoadingBuilder : SLoadingBuilder() {
    private var phase = 0                // i
    private var arcPaint: Paint? = null  // j
    private var oval: RectF? = null      // k
    private var start = 0                // l
    private var sweep = 0                // m

    private fun initPaint(strokeWidth: Float) {
        arcPaint = Paint(Paint.ANTI_ALIAS_FLAG).also {
            it.style = Paint.Style.STROKE
            it.strokeWidth = strokeWidth
            it.color = -1
            it.isDither = true
            it.isFilterBitmap = true
            it.strokeCap = Paint.Cap.ROUND
            it.strokeJoin = Paint.Join.ROUND
        }
    }

    override fun onAnimationFrame(animator: ValueAnimator, fraction: Float) {
        start = (360.0f * fraction).toInt()
        when (phase) {
            0 -> sweep = (fraction * 320.0f).toInt()
            1 -> sweep = 320 - ((fraction * 320.0f).toInt())
        }
    }

    override fun onAnimationRepeat(animation: Animator) {
        phase++
        if (phase > 2) phase = 0
    }

    override fun setAlpha(alpha: Int) { arcPaint!!.alpha = alpha }
    override fun setColorFilter(filter: ColorFilter?) { arcPaint!!.colorFilter = filter }

    override fun initParams(context: Context, color: Int) {
        val r = strokeSize
        initPaint(0.6f * r * 0.3f)
        start = 0
        oval = RectF().also { it.set(centerX() - r, centerY() - r, centerX() + r, centerY() + r) }
    }

    override fun draw(canvas: Canvas) {
        canvas.save()
        canvas.drawArc(oval!!, (start % 360).toFloat(), (sweep % 360).toFloat(), false, arcPaint!!)
        canvas.restore()
    }

    override fun onStop() {}
    override fun onStart(animator: ValueAnimator) {}
}

/**
 * SNAKE_CIRCLE: dois círculos concêntricos fixos, dois pares de arcos girando em sentidos opostos e um traço em zigue-zague
 * (batimento) que é desenhado e depois apagado.
 * Original: x7/o.java
 */
internal class SnakeCircleLoadingBuilder : SLoadingBuilder() {
    private var phase = 0                        // i
    private var linePaint: Paint? = null         // j
    private var outerR = 0f                      // k
    private var innerR = 0f                      // l
    private var outerOval: RectF? = null         // m
    private var innerOval: RectF? = null         // n
    private var alphaValue = 255                 // o
    private var angleA = 0f                      // p (0 -> 360)
    private var angleB = 0f                      // q (360 -> 0)
    private var beatPath: Path? = null           // r
    private var measure: PathMeasure? = null     // s
    private var dst: Path? = null                // t

    private fun buildBeatPath() {
        beatPath = Path().also {
            val a = outerR * 0.3f
            val b = outerR * 0.3f * 0.5f
            it.moveTo(centerX() - (outerR * 0.8f), centerY())
            it.lineTo(centerX() - a, centerY())
            it.lineTo(centerX() - b, centerY() + b)
            it.lineTo(centerX() + b, centerY() - b)
            it.lineTo(centerX() + a, centerY())
            it.lineTo(centerX() + (outerR * 0.8f), centerY())
        }
    }

    private fun resetDst() {
        dst!!.reset()
        dst!!.lineTo(0.0f, 0.0f)
    }

    private fun initPaint(strokeWidth: Float) {
        linePaint = Paint(Paint.ANTI_ALIAS_FLAG).also {
            it.style = Paint.Style.STROKE
            it.strokeWidth = strokeWidth
            it.color = -1
            it.isDither = true
            it.isFilterBitmap = true
            it.strokeCap = Paint.Cap.ROUND
            it.strokeJoin = Paint.Join.ROUND
        }
    }

    private fun initPathObjects() {
        dst = Path()
        measure = PathMeasure()
    }

    override fun onAnimationFrame(animator: ValueAnimator, fraction: Float) {
        angleA = fraction * 360.0f
        angleB = (1.0f - fraction) * 360.0f
        when (phase) {
            0 -> {
                resetDst()
                measure!!.setPath(beatPath, false)
                measure!!.getSegment(0.0f, measure!!.length * fraction, dst, true)
            }
            1 -> {
                resetDst()
                measure!!.setPath(beatPath, false)
                val len = measure!!.length
                measure!!.getSegment(measure!!.length * fraction, len, dst, true)
            }
        }
    }

    override fun onAnimationRepeat(animation: Animator) {
        phase++
        if (phase > 1) phase = 0
    }

    // Original: q(int) só guarda o alfa (aplicado a cada desenho com 0.6 ou 1.0 de escala)
    override fun setAlpha(alpha: Int) { alphaValue = alpha }
    override fun setColorFilter(filter: ColorFilter?) { linePaint!!.colorFilter = filter }

    override fun initParams(context: Context, color: Int) {
        val r = strokeSize * 1.0f
        outerR = r
        val inner = r * 0.7f
        innerR = inner
        initPaint(inner * 0.4f)
        angleA = 0.0f
        outerOval = RectF().also { it.set(centerX() - outerR, centerY() - outerR, centerX() + outerR, centerY() + outerR) }
        innerOval = RectF().also { it.set(centerX() - innerR, centerY() - innerR, centerX() + innerR, centerY() + innerR) }
        initPathObjects()
        buildBeatPath()
    }

    override fun draw(canvas: Canvas) {
        val p = linePaint!!
        canvas.save()
        p.strokeWidth = outerR * 0.05f
        p.alpha = (alphaValue * 0.6f).toInt()
        canvas.drawCircle(centerX(), centerY(), outerR, p)
        canvas.drawCircle(centerX(), centerY(), innerR, p)
        canvas.restore()
        canvas.save()
        p.strokeWidth = outerR * 0.1f
        p.alpha = alphaValue
        canvas.rotate(angleA, centerX(), centerY())
        canvas.drawArc(outerOval!!, 0.0f, 120.0f, false, p)
        canvas.drawArc(outerOval!!, 180.0f, 120.0f, false, p)
        canvas.restore()
        canvas.save()
        p.alpha = (alphaValue * 0.6f).toInt()
        canvas.drawPath(dst!!, p)
        canvas.restore()
        canvas.save()
        p.strokeWidth = outerR * 0.1f
        p.alpha = alphaValue
        canvas.rotate(angleB, centerX(), centerY())
        canvas.drawArc(innerOval!!, 60.0f, 60.0f, false, p)
        canvas.drawArc(innerOval!!, 180.0f, 180.0f, false, p)
        canvas.restore()
    }

    override fun onStop() {}
    override fun onStart(animator: ValueAnimator) {}
}

/**
 * STAR_LOADING: estrela de 5 pontas girando que "quica" na vertical, com uma sombra oval embaixo que acompanha o salto.
 * Um segundo ValueAnimator (0 -> 1 -> 0) controla a altura do salto e o tamanho da sombra.
 * Original: x7/p.java (+ x7/p$a)
 */
internal class StarLoadingBuilder : SLoadingBuilder() {
    private var starPaint: Paint? = null     // i
    private var outerCtrl = 0f               // j
    private var innerR = 0f                  // k
    private var outerR = 0f                  // l
    private var innerCtrl = 0f               // m
    private var rotation = 0                 // n
    private var starPath: Path? = null       // o
    private var jump = 0f                    // p (deslocamento vertical)
    private var shadowRect: RectF? = null    // q
    private var shadowHalfWidth = 0f         // r
    private var jumpAnimator: ValueAnimator? = null   // s
    private val jumpListener = ValueAnimator.AnimatorUpdateListener { va ->          // t (p$a)
        val v = va.animatedValue as Float
        jump = centerY() * 0.4f * v
        shadowHalfWidth = (jump + 10.0f) * 0.9f
    }

    private fun initJumpAnimator() {
        jumpAnimator = ValueAnimator.ofFloat(0.0f, 1.0f, 0.0f).also {
            it.repeatCount = -1
            it.duration = 1333L
            it.startDelay = 333L
            it.interpolator = AccelerateDecelerateInterpolator()
        }
    }

    private fun cos(deg: Int): Float = Math.cos(deg * Math.PI / 180.0).toFloat()   // C
    private fun sin(deg: Int): Float = Math.sin(deg * Math.PI / 180.0).toFloat()   // G

    /** Contorno da estrela de [petals] pontas. Original: p.D(n, a) */
    private fun buildStar(petals: Int, start: Int): Path {
        val path = Path()
        val step = 360 / petals
        val half = step / 2
        val a0 = start - 5
        path.moveTo(centerX() + (outerR * cos(a0)), centerY() + (outerR * sin(a0)))
        for (i in 0 until petals) {
            val a = (step * i) + start
            val before = a - 5
            path.lineTo(centerX() + (outerR * cos(before)), centerY() + (outerR * sin(before)))
            val after = a + 5
            path.quadTo(centerX() + (outerCtrl * cos(a)), centerY() + (outerCtrl * sin(a)), centerX() + (outerR * cos(after)), centerY() + (outerR * sin(after)))
            val mid = a + half
            val midBefore = mid - 5
            path.lineTo(centerX() + (innerR * cos(midBefore)), centerY() + (innerR * sin(midBefore)))
            val cx = centerX() + (innerCtrl * cos(mid))
            val cy = centerY() + (innerCtrl * sin(mid))
            val midAfter = mid + 5
            path.quadTo(cx, cy, centerX() + (innerR * cos(midAfter)), centerY() + (innerR * sin(midAfter)))
        }
        path.close()
        return path
    }

    override fun onAnimationFrame(animator: ValueAnimator, fraction: Float) { rotation = (fraction * 360.0f).toInt() }

    override fun initParams(context: Context, color: Int) {
        starPaint = Paint(Paint.ANTI_ALIAS_FLAG).also {
            it.style = Paint.Style.FILL_AND_STROKE
            it.strokeWidth = 2.0f
            it.color = Color.BLACK
            it.isDither = true
            it.isFilterBitmap = true
        }
        initStar(context)
        initJumpAnimator()
    }

    override fun onStop() {
        jumpAnimator!!.removeAllUpdateListeners()
        jumpAnimator!!.removeAllListeners()
        jumpAnimator!!.repeatCount = 0
        jumpAnimator!!.duration = 0L
        jumpAnimator!!.end()
    }

    override fun onStart(animator: ValueAnimator) {
        animator.interpolator = android.view.animation.DecelerateInterpolator()
        jumpAnimator!!.repeatCount = -1
        jumpAnimator!!.duration = 1333L
        jumpAnimator!!.startDelay = 333L
        jumpAnimator!!.addUpdateListener(jumpListener)
        jumpAnimator!!.start()
    }

    override fun setAlpha(alpha: Int) { starPaint!!.alpha = alpha }
    override fun setColorFilter(filter: ColorFilter?) { starPaint!!.colorFilter = filter }

    /** Original: p.F(Context) */
    private fun initStar(context: Context) {
        val r = strokeSize - dp(context, 5.0f)
        outerCtrl = r
        val outer = r * 0.9f
        outerR = outer
        val inner = outer * 0.6f
        innerR = inner
        innerCtrl = inner * 0.9f
        rotation = 0
        jump = 0.0f
        starPath = buildStar(5, -18)
        shadowHalfWidth = outerCtrl
        shadowRect = RectF()
    }

    override fun draw(canvas: Canvas) {
        canvas.save()
        canvas.translate(0.0f, jump)
        canvas.rotate(rotation.toFloat(), centerX(), centerY())
        canvas.drawPath(starPath!!, starPaint!!)
        canvas.restore()
        shadowRect!!.set(centerX() - shadowHalfWidth, getHeight() - 20.0f, centerX() + shadowHalfWidth, getHeight() - 10.0f)
        canvas.drawOval(shadowRect!!, starPaint!!)
    }
}

/**
 * TEXT: texto (padrão "Zyao89") que vai sendo "preenchido" letra a letra sobre uma cópia esmaecida.
 * Original: x7/q.java
 */
internal class TextLoadingBuilder : SLoadingBuilder() {
    private var textPaint: Paint? = null     // i
    private var content: String? = null      // j
    private var visibleChars = 0             // k

    private fun hasText(): Boolean = !content.isNullOrEmpty()   // y

    override fun onAnimationFrame(animator: ValueAnimator, fraction: Float) { textPaint!!.alpha = ((fraction * 155.0f).toInt()) + 100 }

    override fun initParams(context: Context, color: Int) {
        textPaint = Paint(Paint.ANTI_ALIAS_FLAG).also {
            it.color = Color.BLACK
            it.isDither = true
            it.isFilterBitmap = true
            it.textSize = 56.0f
            it.style = Paint.Style.FILL
            it.textAlign = Paint.Align.LEFT
        }
        content = "Zyao89"
    }

    override fun draw(canvas: Canvas) {
        if (hasText()) {
            val s = content!!
            val len = s.toCharArray().size
            val w = textPaint!!.measureText(s, 0, len)
            val ghost = Paint(textPaint)
            ghost.alpha = 100
            val half = w / 2.0f
            canvas.drawText(s, 0, len, centerX() - half, centerY(), ghost)
            canvas.drawText(s, 0, visibleChars, centerX() - half, centerY(), textPaint!!)
        }
    }

    override fun onStart(animator: ValueAnimator) {
        animator.duration = 333L
        animator.interpolator = android.view.animation.AccelerateInterpolator()
    }

    override fun setAlpha(alpha: Int) { textPaint!!.alpha = alpha }
    override fun setColorFilter(filter: ColorFilter?) { textPaint!!.colorFilter = filter }

    override fun onAnimationRepeat(animation: Animator) {
        if (hasText()) {
            visibleChars++
            if (visibleChars > content!!.toCharArray().size) visibleChars = 0
        }
    }

    /** Define o texto, reduzindo o tamanho da fonte se não couber na largura. Original: q.z(String) */
    fun setLabel(str: String?) {
        if (android.text.TextUtils.isEmpty(str)) return
        val w = textPaint!!.measureText(str)
        if (w >= getWidth()) textPaint!!.textSize = getWidth() / (w / 56.0f)
        content = str
    }

    override fun onStop() {}
}

/**
 * TRANSLATE_CIRCLE: duas bolinhas que se cruzam horizontalmente (uma na cor do tema, outra na cor extra, padrão #999999).
 * Original: x7/r.java
 */
internal class TranslateCircleLoadingBuilder : SLoadingBuilder() {
    private val logger = org.slf4j.LoggerFactory.getLogger(TranslateCircleLoadingBuilder::class.java)
    private var mainPaint: Paint? = null     // j
    private var dotSize = 0f                 // k
    private var travel = 0f                  // l (percurso)
    private var progress = 0f                // m (deslocamento atual)
    private var extraPaint: Paint? = null    // n
    private var extraColor = Color.parseColor("#999999")   // o

    private fun drawDots(canvas: Canvas) {
        val r = dotSize / 2.0f
        val y = centerY()
        val x = progress + dotSize
        canvas.drawCircle(x, y, r, mainPaint!!)
        canvas.drawCircle((travel - x) + (dotSize * 2.0f), y, r, extraPaint!!)
    }

    private fun initPaints() {
        mainPaint = Paint(Paint.ANTI_ALIAS_FLAG).also {
            it.style = Paint.Style.FILL
            it.color = -1
            it.isDither = true
            it.isFilterBitmap = true
            it.strokeCap = Paint.Cap.ROUND
            it.strokeJoin = Paint.Join.ROUND
        }
        extraPaint = Paint(Paint.ANTI_ALIAS_FLAG).also {
            it.style = Paint.Style.FILL
            it.color = extraColor
            it.isDither = true
            it.isFilterBitmap = true
            it.strokeCap = Paint.Cap.ROUND
            it.strokeJoin = Paint.Join.ROUND
        }
    }

    override fun onAnimationFrame(animator: ValueAnimator, fraction: Float) {
        progress = if (fraction <= 0.5f) travel * fraction * 2.0f else travel * (1.0f - fraction) * 2.0f
    }

    override fun initParams(context: Context, color: Int) {
        extraColor = color
        initPaints()
        travel = dp(context, 36.0f)
        dotSize = dp(context, 13.0f)
        logger.debug("color extra = $context")
    }

    override fun setAlpha(alpha: Int) { mainPaint!!.alpha = alpha }

    override fun setExtraColor(color: Int) {
        extraColor = color
        logger.debug("color extra = $color")
        extraPaint!!.color = color
    }

    override fun setColorFilter(filter: ColorFilter?) { mainPaint!!.colorFilter = filter }
    override fun draw(canvas: Canvas) = drawDots(canvas)
    override fun onStop() {}
    override fun onStart(animator: ValueAnimator) {}
}
