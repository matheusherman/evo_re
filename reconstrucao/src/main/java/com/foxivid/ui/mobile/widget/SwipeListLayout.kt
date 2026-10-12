package com.foxivid.ui.mobile.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.ViewCompat
import androidx.customview.widget.ViewDragHelper

/**
 * Item de lista deslizável (swipe para a esquerda revela o 1º filho "hidden" por trás do 2º filho
 * "item"), baseado em [ViewDragHelper]. O 1º filho (índice 0) é o menu escondido e o 2º (índice 1)
 * o conteúdo.
 *
 * Original: com/tvc/lib/mobile/ui/widget/SwipeListLayout.java (enum b = [Status], interface a = listener
 * de status, sem uso; classe c = [DragCallback])
 */
class SwipeListLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    enum class Status { Open, Close }

    /** Original: SwipeListLayout$a — listener de status; vazio/sem uso no original. */
    interface OnSwipeStatusListener

    private var hiddenView: View? = null
    private var itemView: View? = null
    private var hiddenViewWidth = 0
    private var hiddenViewHeight = 0
    private var itemWidth = 0
    private var itemHeight = 0
    private var status = Status.Close
    private var smooth = true
    private var preStatus = Status.Close
    var callback: ViewDragHelper.Callback = DragCallback()
    private val dragHelper: ViewDragHelper = ViewDragHelper.create(this, callback)

    /** Original: SwipeListLayout$c */
    private inner class DragCallback : ViewDragHelper.Callback() {
        override fun clampViewPositionHorizontal(child: View, left: Int, dx: Int): Int {
            if (child != itemView || left > 0) return 0
            return Math.max(left, -getSwipWidth())
        }

        override fun getViewHorizontalDragRange(child: View): Int = getSwipWidth()

        override fun onViewPositionChanged(changedView: View, left: Int, top: Int, dx: Int, dy: Int) {
            if (itemView === changedView) hiddenView?.offsetLeftAndRight(dx)
            invalidate()
        }

        override fun onViewReleased(releasedChild: View, xvel: Float, yvel: Float) {
            if (releasedChild === itemView) {
                if (xvel == 0.0f) {
                    if (Math.abs(itemView?.left ?: 0) > getSwipWidth() / 2.0f) {
                        open(smooth)
                        return
                    }
                }
                if (xvel < 0.0f) open(smooth) else close(smooth)
            }
        }

        override fun tryCaptureView(child: View, pointerId: Int): Boolean = child === itemView
    }

    fun setSmooth(smooth: Boolean) { this.smooth = smooth }

    fun setOnSwipeStatusListener(listener: OnSwipeStatusListener?) {}

    /** Largura do menu escondido (0 se invisível). Original: getSwipWidth() */
    fun getSwipWidth(): Int {
        var measured = 0
        val hidden = hiddenView
        if (hidden != null && hidden.visibility == View.VISIBLE) {
            if (hiddenViewWidth > 0) return hiddenViewWidth
            measured = hidden.measuredWidth
            hiddenViewWidth = measured
        }
        return measured
    }

    /** Fecha o item. Original: g(boolean) */
    fun close(smooth: Boolean) {
        preStatus = status
        status = Status.Close
        if (!smooth) {
            layoutFor(Status.Close)
            return
        }
        if (dragHelper.smoothSlideViewTo(itemView!!, 0, 0)) ViewCompat.postInvalidateOnAnimation(this)
    }

    /** Abre o item. Original: i(boolean) */
    fun open(smooth: Boolean) {
        preStatus = status
        status = Status.Open
        if (!smooth) {
            layoutFor(Status.Open)
            return
        }
        if (dragHelper.smoothSlideViewTo(itemView!!, -getSwipWidth(), 0)) ViewCompat.postInvalidateOnAnimation(this)
    }

    /** Posiciona os dois filhos conforme o status. Original: h(b) */
    private fun layoutFor(status: Status) {
        val swipe = getSwipWidth()
        if (status == Status.Close) {
            hiddenView!!.layout(itemWidth, 0, swipe + itemWidth, itemHeight)
            itemView!!.layout(0, 0, itemWidth, itemHeight)
            return
        }
        hiddenView!!.layout(itemWidth - swipe, 0, itemWidth, itemHeight)
        itemView!!.layout(-swipe, 0, itemWidth - swipe, itemHeight)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action != 3) return dragHelper.shouldInterceptTouchEvent(ev)
        dragHelper.cancel()
        return false
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        layoutFor(Status.Close)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        dragHelper.processTouchEvent(event)
        return true
    }

    override fun computeScroll() {
        super.computeScroll()
        if (dragHelper.continueSettling(true)) ViewCompat.postInvalidateOnAnimation(this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        hiddenView = getChildAt(0)
        itemView = getChildAt(1)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        itemWidth = itemView?.measuredWidth ?: 0
        itemHeight = itemView?.measuredHeight ?: 0
        hiddenViewWidth = hiddenView?.measuredWidth ?: 0
        hiddenViewHeight = hiddenView?.measuredHeight ?: 0
    }
}
