package com.youth.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.p000lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.config.BannerConfig;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.Indicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.listener.OnPageChangeListener;
import com.youth.banner.transformer.MZScaleInTransformer;
import com.youth.banner.transformer.ScaleInTransformer;
import com.youth.banner.util.BannerLifecycleObserver;
import com.youth.banner.util.BannerLifecycleObserverAdapter;
import com.youth.banner.util.BannerUtils;
import com.youth.banner.util.ScrollSpeedManger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Banner<T, BA extends BannerAdapter<T, ? extends RecyclerView.ViewHolder>> extends FrameLayout implements BannerLifecycleObserver {
    public static final int HORIZONTAL = 0;
    public static final int INVALID_VALUE = -1;
    public static final int VERTICAL = 1;
    private int indicatorGravity;
    private int indicatorHeight;
    private int indicatorMargin;
    private int indicatorMarginBottom;
    private int indicatorMarginLeft;
    private int indicatorMarginRight;
    private int indicatorMarginTop;
    private int indicatorRadius;
    private int indicatorSpace;
    private boolean isIntercept;
    private BA mAdapter;
    private final RecyclerView.AdapterDataObserver mAdapterDataObserver;
    private float mBannerRadius;
    private CompositePageTransformer mCompositePageTransformer;
    private Paint mImagePaint;
    private Indicator mIndicator;
    private boolean mIsAutoLoop;
    private boolean mIsInfiniteLoop;
    private boolean mIsViewPager2Drag;
    private AutoLoopTask mLoopTask;
    private long mLoopTime;
    private OnPageChangeListener mOnPageChangeListener;
    private int mOrientation;
    private Banner<T, BA>.BannerOnPageChangeCallback mPageChangeCallback;
    private boolean mRoundBottomLeft;
    private boolean mRoundBottomRight;
    private Paint mRoundPaint;
    private boolean mRoundTopLeft;
    private boolean mRoundTopRight;
    private int mScrollTime;
    private int mStartPosition;
    private float mStartX;
    private float mStartY;
    private int mTouchSlop;
    private ViewPager2 mViewPager2;
    private int normalColor;
    private int normalWidth;
    private int selectedColor;
    private int selectedWidth;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class AutoLoopTask implements Runnable {
        private final WeakReference<Banner> reference;

        @Override // java.lang.Runnable
        public void run() {
            int itemCount;
            Banner banner = this.reference.get();
            if (banner == null || !banner.mIsAutoLoop || (itemCount = banner.getItemCount()) == 0) {
                return;
            }
            banner.setCurrentItem((banner.getCurrentItem() + 1) % itemCount);
            banner.postDelayed(banner.mLoopTask, banner.mLoopTime);
        }

        AutoLoopTask(Banner banner) {
            this.reference = new WeakReference<>(banner);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class BannerOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        private boolean isScrolled;
        private int mTempPosition = -1;

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i10) {
            if (i10 == 1 || i10 == 2) {
                this.isScrolled = true;
            } else if (i10 == 0) {
                this.isScrolled = false;
                if (this.mTempPosition != -1 && Banner.this.mIsInfiniteLoop) {
                    int i11 = this.mTempPosition;
                    if (i11 == 0) {
                        Banner banner = Banner.this;
                        banner.setCurrentItem(banner.getRealCount(), false);
                    } else if (i11 == Banner.this.getItemCount() - 1) {
                        Banner.this.setCurrentItem(1, false);
                    }
                }
            }
            if (Banner.this.mOnPageChangeListener != null) {
                Banner.this.mOnPageChangeListener.onPageScrollStateChanged(i10);
            }
            if (Banner.this.getIndicator() != null) {
                Banner.this.getIndicator().onPageScrollStateChanged(i10);
            }
        }

        BannerOnPageChangeCallback() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i10, float f10, int i11) {
            int realPosition = BannerUtils.getRealPosition(Banner.this.isInfiniteLoop(), i10, Banner.this.getRealCount());
            if (Banner.this.mOnPageChangeListener != null && realPosition == Banner.this.getCurrentItem() - 1) {
                Banner.this.mOnPageChangeListener.onPageScrolled(realPosition, f10, i11);
            }
            if (Banner.this.getIndicator() == null || realPosition != Banner.this.getCurrentItem() - 1) {
                return;
            }
            Banner.this.getIndicator().onPageScrolled(realPosition, f10, i11);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i10) {
            if (this.isScrolled) {
                this.mTempPosition = i10;
                int realPosition = BannerUtils.getRealPosition(Banner.this.isInfiniteLoop(), i10, Banner.this.getRealCount());
                if (Banner.this.mOnPageChangeListener != null) {
                    Banner.this.mOnPageChangeListener.onPageSelected(realPosition);
                }
                if (Banner.this.getIndicator() != null) {
                    Banner.this.getIndicator().onPageSelected(realPosition);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public Banner(Context context) {
        this(context, null);
    }

    private void setRecyclerViewPadding(int i10) {
        setRecyclerViewPadding(i10, i10);
    }

    public Banner addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        getViewPager2().addItemDecoration(itemDecoration);
        return this;
    }

    public Banner setAdapter(BA ba2) {
        if (ba2 == null) {
            throw new NullPointerException(getContext().getString(R.string.banner_adapter_null_error));
        }
        this.mAdapter = ba2;
        if (!isInfiniteLoop()) {
            getAdapter().setIncreaseCount(0);
        }
        getAdapter().registerAdapterDataObserver(this.mAdapterDataObserver);
        this.mViewPager2.setAdapter(ba2);
        setCurrentItem(this.mStartPosition, false);
        initIndicator();
        return this;
    }

    public Banner setBannerGalleryEffect(int i10, int i11) {
        return setBannerGalleryEffect(i10, i11, 0.85f);
    }

    public Banner setBannerGalleryMZ(int i10) {
        return setBannerGalleryMZ(i10, 0.88f);
    }

    public Banner setCurrentItem(int i10) {
        return setCurrentItem(i10, true);
    }

    public Banner setIndicator(Indicator indicator) {
        return setIndicator(indicator, true);
    }

    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void drawTopLeft(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0.0f, this.mBannerRadius);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(this.mBannerRadius, 0.0f);
        float f10 = this.mBannerRadius;
        path.arcTo(new RectF(0.0f, 0.0f, f10 * 2.0f, f10 * 2.0f), -90.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.mRoundPaint);
    }

    private void initIndicatorAttr() {
        int i10 = this.indicatorMargin;
        if (i10 != 0) {
            setIndicatorMargins(new IndicatorConfig.Margins(i10));
        } else {
            int i11 = this.indicatorMarginLeft;
            if (i11 != 0 || this.indicatorMarginTop != 0 || this.indicatorMarginRight != 0 || this.indicatorMarginBottom != 0) {
                setIndicatorMargins(new IndicatorConfig.Margins(i11, this.indicatorMarginTop, this.indicatorMarginRight, this.indicatorMarginBottom));
            }
        }
        int i12 = this.indicatorSpace;
        if (i12 > 0) {
            setIndicatorSpace(i12);
        }
        int i13 = this.indicatorGravity;
        if (i13 != 1) {
            setIndicatorGravity(i13);
        }
        int i14 = this.normalWidth;
        if (i14 > 0) {
            setIndicatorNormalWidth(i14);
        }
        int i15 = this.selectedWidth;
        if (i15 > 0) {
            setIndicatorSelectedWidth(i15);
        }
        int i16 = this.indicatorHeight;
        if (i16 > 0) {
            setIndicatorHeight(i16);
        }
        int i17 = this.indicatorRadius;
        if (i17 > 0) {
            setIndicatorRadius(i17);
        }
        setIndicatorNormalColor(this.normalColor);
        setIndicatorSelectedColor(this.selectedColor);
    }

    private void initTypedArray(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Banner);
            this.mBannerRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_radius, 0);
            this.mLoopTime = typedArrayObtainStyledAttributes.getInt(R.styleable.Banner_banner_loop_time, 3000);
            this.mIsAutoLoop = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Banner_banner_auto_loop, true);
            this.mIsInfiniteLoop = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Banner_banner_infinite_loop, true);
            this.normalWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_normal_width, BannerConfig.INDICATOR_NORMAL_WIDTH);
            this.selectedWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_selected_width, BannerConfig.INDICATOR_SELECTED_WIDTH);
            this.normalColor = typedArrayObtainStyledAttributes.getColor(R.styleable.Banner_banner_indicator_normal_color, BannerConfig.INDICATOR_NORMAL_COLOR);
            this.selectedColor = typedArrayObtainStyledAttributes.getColor(R.styleable.Banner_banner_indicator_selected_color, BannerConfig.INDICATOR_SELECTED_COLOR);
            this.indicatorGravity = typedArrayObtainStyledAttributes.getInt(R.styleable.Banner_banner_indicator_gravity, 1);
            this.indicatorSpace = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_space, 0);
            this.indicatorMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_margin, 0);
            this.indicatorMarginLeft = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginLeft, 0);
            this.indicatorMarginTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginTop, 0);
            this.indicatorMarginRight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginRight, 0);
            this.indicatorMarginBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginBottom, 0);
            this.indicatorHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_height, BannerConfig.INDICATOR_HEIGHT);
            this.indicatorRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_radius, BannerConfig.INDICATOR_RADIUS);
            this.mOrientation = typedArrayObtainStyledAttributes.getInt(R.styleable.Banner_banner_orientation, 0);
            this.mRoundTopLeft = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Banner_banner_round_top_left, false);
            this.mRoundTopRight = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Banner_banner_round_top_right, false);
            this.mRoundBottomLeft = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Banner_banner_round_bottom_left, false);
            this.mRoundBottomRight = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Banner_banner_round_bottom_right, false);
            typedArrayObtainStyledAttributes.recycle();
        }
        setOrientation(this.mOrientation);
        setInfiniteLoop();
    }

    private void setRecyclerViewPadding(int i10, int i11) {
        RecyclerView recyclerView = (RecyclerView) getViewPager2().getChildAt(0);
        if (getViewPager2().getOrientation() == 1) {
            recyclerView.setPadding(this.mViewPager2.getPaddingLeft(), i10, this.mViewPager2.getPaddingRight(), i11);
        } else {
            recyclerView.setPadding(i10, this.mViewPager2.getPaddingTop(), i11, this.mViewPager2.getPaddingBottom());
        }
        recyclerView.setClipToPadding(false);
    }

    public Banner addBannerLifecycleObserver(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            lifecycleOwner.getLifecycle().addObserver(new BannerLifecycleObserverAdapter(lifecycleOwner, this));
        }
        return this;
    }

    public Banner addItemDecoration(RecyclerView.ItemDecoration itemDecoration, int i10) {
        getViewPager2().addItemDecoration(itemDecoration, i10);
        return this;
    }

    public Banner addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        return this;
    }

    public Banner addPageTransformer(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.mCompositePageTransformer.addTransformer(pageTransformer);
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mBannerRadius <= 0.0f) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.mImagePaint, 31);
        super.dispatchDraw(canvas);
        if (!this.mRoundTopRight && !this.mRoundTopLeft && !this.mRoundBottomRight && !this.mRoundBottomLeft) {
            drawTopLeft(canvas);
            drawTopRight(canvas);
            drawBottomLeft(canvas);
            drawBottomRight(canvas);
            canvas.restore();
            return;
        }
        if (this.mRoundTopLeft) {
            drawTopLeft(canvas);
        }
        if (this.mRoundTopRight) {
            drawTopRight(canvas);
        }
        if (this.mRoundBottomLeft) {
            drawBottomLeft(canvas);
        }
        if (this.mRoundBottomRight) {
            drawBottomRight(canvas);
        }
        canvas.restore();
    }

    public BannerAdapter getAdapter() {
        return this.mAdapter;
    }

    public Indicator getIndicator() {
        return this.mIndicator;
    }

    public int getScrollTime() {
        return this.mScrollTime;
    }

    public int getStartPosition() {
        return this.mStartPosition;
    }

    public ViewPager2 getViewPager2() {
        return this.mViewPager2;
    }

    public Banner isAutoLoop(boolean z10) {
        this.mIsAutoLoop = z10;
        return this;
    }

    public boolean isInfiniteLoop() {
        return this.mIsInfiniteLoop;
    }

    public Banner removeTransformer(ViewPager2.PageTransformer pageTransformer) {
        this.mCompositePageTransformer.removeTransformer(pageTransformer);
        return this;
    }

    public Banner setBannerGalleryEffect(int i10, int i11, int i12) {
        return setBannerGalleryEffect(i10, i11, i12, 0.85f);
    }

    public Banner setBannerGalleryMZ(int i10, float f10) {
        if (f10 < 1.0f && f10 > 0.0f) {
            addPageTransformer(new MZScaleInTransformer(f10));
        }
        setRecyclerViewPadding(BannerUtils.dp2px(i10));
        return this;
    }

    public Banner setBannerRound(float f10) {
        this.mBannerRadius = f10;
        return this;
    }

    public Banner setCurrentItem(int i10, boolean z10) {
        getViewPager2().setCurrentItem(i10, z10);
        return this;
    }

    public Banner setIndicator(Indicator indicator, boolean z10) {
        removeIndicator();
        indicator.getIndicatorConfig().setAttachToBanner(z10);
        this.mIndicator = indicator;
        initIndicator();
        return this;
    }

    public Banner setIntercept(boolean z10) {
        this.isIntercept = z10;
        return this;
    }

    public Banner setLoopTime(long j10) {
        this.mLoopTime = j10;
        return this;
    }

    public Banner setScrollTime(int i10) {
        this.mScrollTime = i10;
        return this;
    }

    public Banner setStartPosition(int i10) {
        this.mStartPosition = i10;
        return this;
    }

    public Banner setTouchSlop(int i10) {
        this.mTouchSlop = i10;
        return this;
    }

    public Banner start() {
        if (this.mIsAutoLoop) {
            stop();
            postDelayed(this.mLoopTask, this.mLoopTime);
        }
        return this;
    }

    public Banner stop() {
        if (this.mIsAutoLoop) {
            removeCallbacks(this.mLoopTask);
        }
        return this;
    }

    public Banner(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mIsInfiniteLoop = true;
        this.mIsAutoLoop = true;
        this.mLoopTime = 3000L;
        this.mScrollTime = 600;
        this.mStartPosition = 1;
        this.mBannerRadius = 0.0f;
        this.normalWidth = BannerConfig.INDICATOR_NORMAL_WIDTH;
        this.selectedWidth = BannerConfig.INDICATOR_SELECTED_WIDTH;
        this.normalColor = BannerConfig.INDICATOR_NORMAL_COLOR;
        this.selectedColor = BannerConfig.INDICATOR_SELECTED_COLOR;
        this.indicatorGravity = 1;
        this.indicatorHeight = BannerConfig.INDICATOR_HEIGHT;
        this.indicatorRadius = BannerConfig.INDICATOR_RADIUS;
        this.mOrientation = 0;
        this.isIntercept = true;
        this.mAdapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: com.youth.banner.Banner.1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                if (Banner.this.getItemCount() <= 1) {
                    Banner.this.stop();
                } else {
                    Banner.this.start();
                }
                Banner.this.setIndicatorPageChange();
            }
        };
        init(context);
        initTypedArray(context, attributeSet);
    }

    private void drawBottomLeft(Canvas canvas) {
        int height = getHeight();
        Path path = new Path();
        float f10 = height;
        path.moveTo(0.0f, f10 - this.mBannerRadius);
        path.lineTo(0.0f, f10);
        path.lineTo(this.mBannerRadius, f10);
        float f11 = this.mBannerRadius;
        path.arcTo(new RectF(0.0f, f10 - (f11 * 2.0f), f11 * 2.0f, f10), 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.mRoundPaint);
    }

    private void drawBottomRight(Canvas canvas) {
        int height = getHeight();
        int width = getWidth();
        Path path = new Path();
        float f10 = width;
        float f11 = height;
        path.moveTo(f10 - this.mBannerRadius, f11);
        path.lineTo(f10, f11);
        path.lineTo(f10, f11 - this.mBannerRadius);
        float f12 = this.mBannerRadius;
        path.arcTo(new RectF(f10 - (f12 * 2.0f), f11 - (f12 * 2.0f), f10, f11), 0.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.mRoundPaint);
    }

    private void drawTopRight(Canvas canvas) {
        int width = getWidth();
        Path path = new Path();
        float f10 = width;
        path.moveTo(f10 - this.mBannerRadius, 0.0f);
        path.lineTo(f10, 0.0f);
        path.lineTo(f10, this.mBannerRadius);
        float f11 = this.mBannerRadius;
        path.arcTo(new RectF(f10 - (f11 * 2.0f), 0.0f, f10, f11 * 2.0f), 0.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.mRoundPaint);
    }

    private void init(Context context) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() / 2;
        this.mCompositePageTransformer = new CompositePageTransformer();
        this.mPageChangeCallback = new BannerOnPageChangeCallback();
        this.mLoopTask = new AutoLoopTask(this);
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.mViewPager2 = viewPager2;
        viewPager2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mViewPager2.setOffscreenPageLimit(2);
        this.mViewPager2.registerOnPageChangeCallback(this.mPageChangeCallback);
        this.mViewPager2.setPageTransformer(this.mCompositePageTransformer);
        ScrollSpeedManger.reflectLayoutManager(this);
        addView(this.mViewPager2);
        Paint paint = new Paint();
        this.mRoundPaint = paint;
        paint.setColor(-1);
        this.mRoundPaint.setAntiAlias(true);
        this.mRoundPaint.setStyle(Paint.Style.FILL);
        this.mRoundPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.mImagePaint = paint2;
        paint2.setXfermode(null);
    }

    private void initIndicator() {
        if (getIndicator() != null && getAdapter() != null) {
            if (getIndicator().getIndicatorConfig().isAttachToBanner()) {
                removeIndicator();
                addView(getIndicator().getIndicatorView());
            }
            initIndicatorAttr();
            setIndicatorPageChange();
        }
    }

    private void setInfiniteLoop() {
        int i10 = 0;
        if (!isInfiniteLoop()) {
            isAutoLoop(false);
        }
        if (isInfiniteLoop()) {
            i10 = this.mStartPosition;
        }
        setStartPosition(i10);
    }

    public void destroy() {
        if (getViewPager2() != null && this.mPageChangeCallback != null) {
            getViewPager2().unregisterOnPageChangeCallback(this.mPageChangeCallback);
            this.mPageChangeCallback = null;
        }
        stop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!getViewPager2().isUserInputEnabled()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1 && actionMasked != 3 && actionMasked != 4) {
            if (actionMasked == 0) {
                stop();
            }
        } else {
            start();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public IndicatorConfig getIndicatorConfig() {
        if (getIndicator() != null) {
            return getIndicator().getIndicatorConfig();
        }
        return null;
    }

    public int getItemCount() {
        if (getAdapter() != null) {
            return getAdapter().getItemCount();
        }
        return 0;
    }

    public int getRealCount() {
        if (getAdapter() != null) {
            return getAdapter().getRealCount();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        start();
    }

    @Override // com.youth.banner.util.BannerLifecycleObserver
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        destroy();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x006a  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getViewPager2().isUserInputEnabled() && this.isIntercept) {
            int action = motionEvent.getAction();
            boolean z10 = true;
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action == 3) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    } else {
                        float x10 = motionEvent.getX();
                        float y10 = motionEvent.getY();
                        float fAbs = Math.abs(x10 - this.mStartX);
                        float fAbs2 = Math.abs(y10 - this.mStartY);
                        if (getViewPager2().getOrientation() == 0) {
                            if (fAbs <= this.mTouchSlop || fAbs <= fAbs2) {
                                z10 = false;
                            }
                            this.mIsViewPager2Drag = z10;
                        } else {
                            if (fAbs2 <= this.mTouchSlop || fAbs2 <= fAbs) {
                                z10 = false;
                            }
                            this.mIsViewPager2Drag = z10;
                        }
                        getParent().requestDisallowInterceptTouchEvent(this.mIsViewPager2Drag);
                    }
                } else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            } else {
                this.mStartX = motionEvent.getX();
                this.mStartY = motionEvent.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.youth.banner.util.BannerLifecycleObserver
    public void onStart(LifecycleOwner lifecycleOwner) {
        start();
    }

    @Override // com.youth.banner.util.BannerLifecycleObserver
    public void onStop(LifecycleOwner lifecycleOwner) {
        stop();
    }

    public Banner removeIndicator() {
        if (getIndicator() != null) {
            removeView(getIndicator().getIndicatorView());
        }
        return this;
    }

    public Banner setBannerGalleryEffect(int i10, int i11, float f10) {
        return setBannerGalleryEffect(i10, i10, i11, f10);
    }

    @RequiresApi(api = 21)
    public Banner setBannerRound2(float f10) {
        BannerUtils.setBannerRound(this, f10);
        return this;
    }

    public Banner setDatas(List<T> list) {
        if (getAdapter() != null) {
            getAdapter().setDatas(list);
            setCurrentItem(this.mStartPosition, false);
            setIndicatorPageChange();
            start();
        }
        return this;
    }

    public Banner setIndicatorGravity(int i10) {
        if (getIndicatorConfig() != null && getIndicatorConfig().isAttachToBanner()) {
            getIndicatorConfig().setGravity(i10);
            getIndicator().getIndicatorView().postInvalidate();
        }
        return this;
    }

    public Banner setIndicatorHeight(int i10) {
        if (getIndicatorConfig() != null) {
            getIndicatorConfig().setHeight(i10);
        }
        return this;
    }

    public Banner setIndicatorMargins(IndicatorConfig.Margins margins) {
        if (getIndicatorConfig() != null && getIndicatorConfig().isAttachToBanner()) {
            getIndicatorConfig().setMargins(margins);
            getIndicator().getIndicatorView().requestLayout();
        }
        return this;
    }

    public Banner setIndicatorNormalColor(@ColorInt int i10) {
        if (getIndicatorConfig() != null) {
            getIndicatorConfig().setNormalColor(i10);
        }
        return this;
    }

    public Banner setIndicatorNormalColorRes(@ColorRes int i10) {
        setIndicatorNormalColor(ContextCompat.getColor(getContext(), i10));
        return this;
    }

    public Banner setIndicatorNormalWidth(int i10) {
        if (getIndicatorConfig() != null) {
            getIndicatorConfig().setNormalWidth(i10);
        }
        return this;
    }

    public Banner setIndicatorPageChange() {
        if (getIndicator() != null) {
            getIndicator().onPageChanged(getRealCount(), BannerUtils.getRealPosition(isInfiniteLoop(), getCurrentItem(), getRealCount()));
        }
        return this;
    }

    public Banner setIndicatorRadius(int i10) {
        if (getIndicatorConfig() != null) {
            getIndicatorConfig().setRadius(i10);
        }
        return this;
    }

    public Banner setIndicatorSelectedColor(@ColorInt int i10) {
        if (getIndicatorConfig() != null) {
            getIndicatorConfig().setSelectedColor(i10);
        }
        return this;
    }

    public Banner setIndicatorSelectedColorRes(@ColorRes int i10) {
        setIndicatorSelectedColor(ContextCompat.getColor(getContext(), i10));
        return this;
    }

    public Banner setIndicatorSelectedWidth(int i10) {
        if (getIndicatorConfig() != null) {
            getIndicatorConfig().setSelectedWidth(i10);
        }
        return this;
    }

    public Banner setIndicatorSpace(int i10) {
        if (getIndicatorConfig() != null) {
            getIndicatorConfig().setIndicatorSpace(i10);
        }
        return this;
    }

    public Banner setIndicatorWidth(int i10, int i11) {
        if (getIndicatorConfig() != null) {
            getIndicatorConfig().setNormalWidth(i10);
            getIndicatorConfig().setSelectedWidth(i11);
        }
        return this;
    }

    public Banner setOnBannerListener(OnBannerListener<T> onBannerListener) {
        if (getAdapter() != null) {
            getAdapter().setOnBannerListener(onBannerListener);
        }
        return this;
    }

    public Banner setOrientation(int i10) {
        getViewPager2().setOrientation(i10);
        return this;
    }

    public Banner setPageTransformer(@Nullable ViewPager2.PageTransformer pageTransformer) {
        getViewPager2().setPageTransformer(pageTransformer);
        return this;
    }

    public Banner setUserInputEnabled(boolean z10) {
        getViewPager2().setUserInputEnabled(z10);
        return this;
    }

    public Banner setBannerGalleryEffect(int i10, int i11, int i12, float f10) {
        if (i12 > 0) {
            addPageTransformer(new MarginPageTransformer(BannerUtils.dp2px(i12)));
        }
        if (f10 < 1.0f && f10 > 0.0f) {
            addPageTransformer(new ScaleInTransformer(f10));
        }
        setRecyclerViewPadding(i10 > 0 ? BannerUtils.dp2px(i10 + i12) : 0, i11 > 0 ? BannerUtils.dp2px(i11 + i12) : 0);
        return this;
    }

    public Banner setAdapter(BA ba2, boolean z10) {
        this.mIsInfiniteLoop = z10;
        setInfiniteLoop();
        setAdapter(ba2);
        return this;
    }
}
