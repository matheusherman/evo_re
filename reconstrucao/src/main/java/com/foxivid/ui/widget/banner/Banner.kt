package com.foxivid.ui.widget.banner

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewConfiguration
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.foxivid.ui.widget.FrameLayout
import com.foxivid.ui.widget.banner.indicator.Indicator
import com.foxivid.ui.widget.banner.util.ScrollSpeedManger
import com.youth.banner.config.BannerConfig
import com.youth.banner.config.IndicatorConfig
import com.youth.banner.listener.OnPageChangeListener
import com.youth.banner.adapter.BannerAdapter
import com.youth.banner.util.BannerUtils
import java.lang.ref.WeakReference

/**
 * Cópia reduzida do `com.youth.banner.Banner` (biblioteca youth banner) sobre [FrameLayout] com
 * auto-layout, baseada em ViewPager2 com loop infinito/automático e cantos arredondados.
 *
 * Particularidade do original: `getAdapter()` devolve sempre `null`, `getItemCount()` e
 * `getRealCount()` sempre 0 (a parte de adapter foi removida pelo R8 por não ser usada). O mesmo
 * é reproduzido aqui.
 *
 * Constantes padrão (bg.a: f1074a normalWidth, f1075b selectedWidth, f1078e height, f1079f radius) aparecem como
 * `IndicatorConfig.Defaults.*` (nome legível; valores vêm da biblioteca youth banner).
 *
 * Original: t/v/c/widget/banner/Banner.java (classes internas a = LoopTask, c = PageChangeCallback,
 * d = AdapterDataObserver)
 */
class Banner<T, BA : BannerAdapter<T, out RecyclerView.ViewHolder>> :
    FrameLayout, DefaultLifecycleObserver {

    private var indicatorMarginLeft = 0
    private var indicatorMarginTop = 0
    private var indicatorMarginRight = 0
    private var indicatorMarginBottom = 0
    private var indicatorHeight = IndicatorConfig.Defaults.HEIGHT
    private var indicatorRadius = IndicatorConfig.Defaults.RADIUS
    private var orientation = 0
    private var touchSlop = 0
    private var startX = 0f
    private var startY = 0f
    private var isViewPager2Drag = false
    private var isIntercept = true
    private var roundPaint: Paint? = null
    private var imagePaint: Paint? = null
    private val adapterDataObserver: RecyclerView.AdapterDataObserver = AdapterObserver()

    var viewPager2: ViewPager2? = null
        private set
    private var loopTask: LoopTask? = null
    private var onPageChangeListener: OnPageChangeListener? = null
    var indicator: Indicator? = null
        private set
    private var compositePageTransformer: CompositePageTransformer? = null
    private var pageChangeCallback: ViewPager2.OnPageChangeCallback? = null

    var isInfiniteLoop = true
        private set
    private var isAutoLoop = true
    private var loopTime = 3000L
    var scrollTime = 600
        private set
    var startPosition = 1
        private set
    private var bannerRadius = 0f
    private var roundTopLeft = false
    private var roundTopRight = false
    private var roundBottomLeft = false
    private var roundBottomRight = false
    private var normalWidth = IndicatorConfig.Defaults.NORMAL_WIDTH
    private var selectedWidth = IndicatorConfig.Defaults.SELECTED_WIDTH
    private var normalColor = BannerConfig.INDICATOR_NORMAL_COLOR
    private var selectedColor = BannerConfig.INDICATOR_SELECTED_COLOR
    private var indicatorGravity = 1
    private var indicatorSpace = 0
    private var indicatorMargin = 0

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
        readAttributes(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(context)
        readAttributes(context, attrs)
    }

    /** Runnable de auto-loop: avança para a próxima página e reagenda. Original: Banner$a */
    class LoopTask(banner: Banner<*, *>) : Runnable {
        private val reference = WeakReference(banner)

        override fun run() {
            val banner = reference.get() ?: return
            if (!banner.isAutoLoop) return
            val itemCount = banner.getItemCount()
            if (itemCount == 0) return
            val current = banner.getCurrentItem() ?: return
            banner.setCurrentItem((current + 1) % itemCount)
            banner.postDelayed(banner.loopTask, banner.loopTime)
        }
    }

    /** Callback de página: recoloca o loop infinito e repassa eventos ao listener/indicador. Original: Banner$c */
    private inner class PageChangeCallback : ViewPager2.OnPageChangeCallback() {
        private var tempPosition = -1
        private var isScrolled = false

        override fun onPageScrollStateChanged(state: Int) {
            if (state == 0) {
                isScrolled = false
                if (tempPosition != -1 && isInfiniteLoop) {
                    if (tempPosition == 0) {
                        setCurrentItem(getRealCount(), false)
                    } else if (tempPosition == getItemCount() - 1) {
                        setCurrentItem(1, false)
                    }
                }
            } else if (state == 1 || state == 2) {
                isScrolled = true
            }
            onPageChangeListener?.onPageScrollStateChanged(state)
            indicator?.onPageScrollStateChanged(state)
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            val real = BannerUtils.getRealPosition(isInfiniteLoop, position, getRealCount())
            val current = getCurrentItem() ?: return
            if (real == current - 1) {
                onPageChangeListener?.onPageScrolled(real, positionOffset, positionOffsetPixels)
                indicator?.onPageScrolled(real, positionOffset, positionOffsetPixels)
            }
        }

        override fun onPageSelected(position: Int) {
            if (isScrolled) {
                tempPosition = position
                val real = BannerUtils.getRealPosition(isInfiniteLoop, position, getRealCount())
                onPageChangeListener?.onPageSelected(real)
                indicator?.onPageSelected(real)
            }
        }
    }

    /** Observa mudanças do adapter: reinicia/para o loop e atualiza o indicador. Original: Banner$d */
    private inner class AdapterObserver : RecyclerView.AdapterDataObserver() {
        override fun onChanged() {
            if (getItemCount() <= 1) stopLoop() else startLoop()
            updateIndicator()
        }
    }

    /** Original: Banner.getAdapter() — sempre null no original. */
    fun getAdapter(): BannerAdapter<T, out RecyclerView.ViewHolder>? = null

    /** Original: Banner.getItemCount() — sempre 0 (adapter removido). */
    fun getItemCount(): Int = 0

    /** Original: Banner.getRealCount() — sempre 0 (adapter removido). */
    fun getRealCount(): Int = 0

    /** Original: Banner.C(position) */
    fun setCurrentItem(position: Int): Banner<T, BA> = setCurrentItem(position, true)

    /** Original: Banner.D(position, smoothScroll) */
    fun setCurrentItem(position: Int, smoothScroll: Boolean): Banner<T, BA> {
        viewPager2?.setCurrentItem(position, smoothScroll)
        return this
    }

    fun getCurrentItem(): Int? = viewPager2?.currentItem

    /** Original: Banner.A(isAutoLoop) */
    fun setAutoLoop(isAutoLoop: Boolean): Banner<T, BA> {
        this.isAutoLoop = isAutoLoop
        return this
    }

    /** Original: Banner.I(startPosition) */
    fun setStartPosition(startPosition: Int): Banner<T, BA> {
        this.startPosition = startPosition
        return this
    }

    /** Original: Banner.G(orientation) */
    fun setOrientation(orientation: Int): Banner<T, BA> {
        viewPager2?.orientation = orientation
        return this
    }

    /** Original: Banner.J() — (re)agenda o auto-loop. */
    fun startLoop(): Banner<T, BA> {
        if (isAutoLoop) {
            stopLoop()
            postDelayed(loopTask, loopTime)
        }
        return this
    }

    /** Original: Banner.K() — cancela o auto-loop. */
    fun stopLoop(): Banner<T, BA> {
        if (isAutoLoop) removeCallbacks(loopTask)
        return this
    }

    /** Original: Banner.E() */
    fun updateIndicator(): Banner<T, BA> {
        val ind = indicator
        val cur = getCurrentItem()
        if (ind != null && cur != null) {
            ind.onPageChanged(getRealCount(), BannerUtils.getRealPosition(isInfiniteLoop, cur, getRealCount()))
        }
        return this
    }

    fun getIndicatorConfig(): IndicatorConfig? = indicator?.indicatorConfig

    /** Original: Banner.t() — desregistra o callback de página e para o loop. */
    fun destroy() {
        val vp = viewPager2
        val cb = pageChangeCallback
        if (vp != null && cb != null) {
            vp.unregisterOnPageChangeCallback(cb)
            pageChangeCallback = null
        }
        stopLoop()
    }

    private fun setRecyclerViewPadding(itemPadding: Int) = setRecyclerViewPadding(itemPadding, itemPadding)

    /** Original: Banner.H(left, right) */
    private fun setRecyclerViewPadding(leftItemPadding: Int, rightItemPadding: Int) {
        val recyclerView = viewPager2?.getChildAt(0) as RecyclerView
        val vp = viewPager2!!
        if (vp.orientation == 1) {
            recyclerView.setPadding(vp.paddingLeft, leftItemPadding, vp.paddingRight, rightItemPadding)
        } else {
            recyclerView.setPadding(leftItemPadding, vp.paddingTop, rightItemPadding, vp.paddingBottom)
        }
        recyclerView.clipToPadding = false
    }

    /** Original: Banner.F() */
    private fun applyLoopRules() {
        if (!isInfiniteLoop) setAutoLoop(false)
        setStartPosition(if (isInfiniteLoop) startPosition else 0)
    }

    /** Original: Banner.y(Context) */
    private fun init(context: Context) {
        touchSlop = ViewConfiguration.get(context).scaledTouchSlop / 2
        compositePageTransformer = CompositePageTransformer()
        pageChangeCallback = PageChangeCallback()
        loopTask = LoopTask(this)
        val vp = ViewPager2(context)
        viewPager2 = vp
        vp.layoutParams = android.widget.FrameLayout.LayoutParams(-1, -1)
        vp.offscreenPageLimit = 2
        vp.registerOnPageChangeCallback(pageChangeCallback!!)
        vp.setPageTransformer(compositePageTransformer)
        ScrollSpeedManger.reflectLayoutManager(this)
        addView(vp)
        roundPaint = Paint().apply {
            color = -1
            isAntiAlias = true
            style = Paint.Style.FILL
            xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
        }
        imagePaint = Paint().apply { xfermode = null }
    }

    /** Lê os atributos `Banner_banner_*` (R.styleable.Banner). Original: Banner.z(Context, AttributeSet) */
    private fun readAttributes(context: Context, attrs: AttributeSet) {
        val a = context.obtainStyledAttributes(attrs, com.foxivid.ui.R.styleable.Banner)
        bannerRadius = a.getDimensionPixelSize(com.foxivid.ui.R.styleable.Banner_banner_radius, 0).toFloat()
        loopTime = a.getInt(com.foxivid.ui.R.styleable.Banner_banner_loop_time, 3000).toLong()
        isAutoLoop = a.getBoolean(com.foxivid.ui.R.styleable.Banner_banner_auto_loop, true)
        isInfiniteLoop = a.getBoolean(com.foxivid.ui.R.styleable.Banner_banner_infinite_loop, true)
        normalWidth = a.getDimensionPixelSize(com.foxivid.ui.R.styleable.Banner_banner_indicator_normal_width, IndicatorConfig.Defaults.NORMAL_WIDTH)
        selectedWidth = a.getDimensionPixelSize(com.foxivid.ui.R.styleable.Banner_banner_indicator_selected_width, IndicatorConfig.Defaults.SELECTED_WIDTH)
        normalColor = a.getColor(com.foxivid.ui.R.styleable.Banner_banner_indicator_normal_color, BannerConfig.INDICATOR_NORMAL_COLOR)
        selectedColor = a.getColor(com.foxivid.ui.R.styleable.Banner_banner_indicator_selected_color, BannerConfig.INDICATOR_SELECTED_COLOR)
        indicatorGravity = a.getInt(com.foxivid.ui.R.styleable.Banner_banner_indicator_gravity, 1)
        indicatorSpace = a.getDimensionPixelSize(com.foxivid.ui.R.styleable.Banner_banner_indicator_space, 0)
        indicatorMargin = a.getDimensionPixelSize(com.foxivid.ui.R.styleable.Banner_banner_indicator_margin, 0)
        indicatorMarginLeft = a.getDimensionPixelSize(com.foxivid.ui.R.styleable.Banner_banner_indicator_marginLeft, 0)
        indicatorMarginTop = a.getDimensionPixelSize(com.foxivid.ui.R.styleable.Banner_banner_indicator_marginTop, 0)
        indicatorMarginRight = a.getDimensionPixelSize(com.foxivid.ui.R.styleable.Banner_banner_indicator_marginRight, 0)
        indicatorMarginBottom = a.getDimensionPixelSize(com.foxivid.ui.R.styleable.Banner_banner_indicator_marginBottom, 0)
        indicatorHeight = a.getDimensionPixelSize(com.foxivid.ui.R.styleable.Banner_banner_indicator_height, IndicatorConfig.Defaults.HEIGHT)
        indicatorRadius = a.getDimensionPixelSize(com.foxivid.ui.R.styleable.Banner_banner_indicator_radius, IndicatorConfig.Defaults.RADIUS)
        orientation = a.getInt(com.foxivid.ui.R.styleable.Banner_banner_orientation, 0)
        roundTopLeft = a.getBoolean(com.foxivid.ui.R.styleable.Banner_banner_round_top_left, false)
        roundTopRight = a.getBoolean(com.foxivid.ui.R.styleable.Banner_banner_round_top_right, false)
        roundBottomLeft = a.getBoolean(com.foxivid.ui.R.styleable.Banner_banner_round_bottom_left, false)
        roundBottomRight = a.getBoolean(com.foxivid.ui.R.styleable.Banner_banner_round_bottom_right, false)
        a.recycle()
        setOrientation(orientation)
        applyLoopRules()
    }

    // --- cantos arredondados: cada canto recorta com um "path" + DST_OUT ---

    /** Original: Banner.w */
    private fun drawTopLeft(canvas: Canvas) {
        val r = bannerRadius
        val path = Path()
        path.moveTo(0f, r)
        path.lineTo(0f, 0f)
        path.lineTo(r, 0f)
        path.arcTo(RectF(0f, 0f, r * 2, r * 2), -90f, -90f)
        path.close()
        canvas.drawPath(path, roundPaint!!)
    }

    /** Original: Banner.x */
    private fun drawTopRight(canvas: Canvas) {
        val w = width.toFloat()
        val r = bannerRadius
        val path = Path()
        path.moveTo(w - r, 0f)
        path.lineTo(w, 0f)
        path.lineTo(w, r)
        path.arcTo(RectF(w - r * 2, 0f, w, r * 2), 0f, -90f)
        path.close()
        canvas.drawPath(path, roundPaint!!)
    }

    /** Original: Banner.u */
    private fun drawBottomLeft(canvas: Canvas) {
        val h = height.toFloat()
        val r = bannerRadius
        val path = Path()
        path.moveTo(0f, h - r)
        path.lineTo(0f, h)
        path.lineTo(r, h)
        path.arcTo(RectF(0f, h - r * 2, r * 2, h), 90f, 90f)
        path.close()
        canvas.drawPath(path, roundPaint!!)
    }

    /** Original: Banner.v */
    private fun drawBottomRight(canvas: Canvas) {
        val h = height.toFloat()
        val w = width.toFloat()
        val r = bannerRadius
        val path = Path()
        path.moveTo(w - r, h)
        path.lineTo(w, h)
        path.lineTo(w, h - r)
        path.arcTo(RectF(w - r * 2, h - r * 2, w, h), 0f, 90f)
        path.close()
        canvas.drawPath(path, roundPaint!!)
    }

    override fun dispatchDraw(canvas: Canvas) {
        if (bannerRadius <= 0f) {
            super.dispatchDraw(canvas)
            return
        }
        canvas.saveLayer(RectF(0f, 0f, canvas.width.toFloat(), canvas.height.toFloat()), imagePaint, 31)
        super.dispatchDraw(canvas)
        if (!roundTopRight && !roundTopLeft && !roundBottomRight && !roundBottomLeft) {
            drawTopLeft(canvas); drawTopRight(canvas); drawBottomLeft(canvas); drawBottomRight(canvas)
            canvas.restore()
            return
        }
        if (roundTopLeft) drawTopLeft(canvas)
        if (roundTopRight) drawTopRight(canvas)
        if (roundBottomLeft) drawBottomLeft(canvas)
        if (roundBottomRight) drawBottomRight(canvas)
        canvas.restore()
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (!viewPager2!!.isUserInputEnabled) return super.dispatchTouchEvent(ev)
        when (ev.actionMasked) {
            0 -> stopLoop()
            1, 3, 4 -> startLoop()
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        if (!viewPager2!!.isUserInputEnabled || !isIntercept) return super.onInterceptTouchEvent(event)
        when (event.action) {
            0 -> {
                startX = event.x
                startY = event.y
                parent.requestDisallowInterceptTouchEvent(true)
            }
            1 -> parent.requestDisallowInterceptTouchEvent(false)
            2 -> {
                val dx = Math.abs(event.x - startX)
                val dy = Math.abs(event.y - startY)
                val drag = if (viewPager2!!.orientation != 0) {
                    !(dy <= touchSlop || dy <= dx)
                } else {
                    !(dx <= touchSlop || dx <= dy)
                }
                isViewPager2Drag = drag
                parent.requestDisallowInterceptTouchEvent(isViewPager2Drag)
            }
            3 -> parent.requestDisallowInterceptTouchEvent(false)
        }
        return super.onInterceptTouchEvent(event)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        startLoop()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        stopLoop()
    }
}
