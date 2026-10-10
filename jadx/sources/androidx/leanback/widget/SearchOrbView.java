package androidx.leanback.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class SearchOrbView extends FrameLayout implements View.OnClickListener {
    private boolean mAttachedToWindow;
    private boolean mColorAnimationEnabled;
    private ValueAnimator mColorAnimator;
    private final ArgbEvaluator mColorEvaluator;
    private Colors mColors;
    private final ValueAnimator.AnimatorUpdateListener mFocusUpdateListener;
    private final float mFocusedZ;
    private final float mFocusedZoom;
    private final ImageView mIcon;
    private Drawable mIconDrawable;
    private View.OnClickListener mListener;
    private final int mPulseDurationMs;
    private final View mRootView;
    private final int mScaleDurationMs;
    private final View mSearchOrbView;
    private ValueAnimator mShadowFocusAnimator;
    private final float mUnfocusedZ;
    private final ValueAnimator.AnimatorUpdateListener mUpdateListener;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class Colors {
        private static final float BRIGHTNESS_ALPHA = 0.15f;

        @ColorInt
        public int brightColor;

        @ColorInt
        public int color;

        @ColorInt
        public int iconColor;

        public Colors(@ColorInt int i10) {
            this(i10, i10);
        }

        public Colors(@ColorInt int i10, @ColorInt int i11) {
            this(i10, i11, 0);
        }

        public Colors(@ColorInt int i10, @ColorInt int i11, @ColorInt int i12) {
            this.color = i10;
            this.brightColor = i11 == i10 ? getBrightColor(i10) : i11;
            this.iconColor = i12;
        }

        public static int getBrightColor(int i10) {
            return Color.argb((int) ((Color.alpha(i10) * 0.85f) + 38.25f), (int) ((Color.red(i10) * 0.85f) + 38.25f), (int) ((Color.green(i10) * 0.85f) + 38.25f), (int) ((Color.blue(i10) * 0.85f) + 38.25f));
        }
    }

    public SearchOrbView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.mAttachedToWindow = false;
        updateColorAnimator();
        super.onDetachedFromWindow();
    }

    public void setOrbColor(int i10) {
        setOrbColors(new Colors(i10, i10, 0));
    }

    public SearchOrbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.leanback.R.attr.searchOrbViewStyle);
    }

    private void startShadowFocusAnimation(boolean z10, int i10) {
        if (this.mShadowFocusAnimator == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mShadowFocusAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(this.mFocusUpdateListener);
        }
        if (z10) {
            this.mShadowFocusAnimator.start();
        } else {
            this.mShadowFocusAnimator.reverse();
        }
        this.mShadowFocusAnimator.setDuration(i10);
    }

    private void updateColorAnimator() {
        ValueAnimator valueAnimator = this.mColorAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.mColorAnimator = null;
        }
        if (this.mColorAnimationEnabled && this.mAttachedToWindow) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(this.mColorEvaluator, Integer.valueOf(this.mColors.color), Integer.valueOf(this.mColors.brightColor), Integer.valueOf(this.mColors.color));
            this.mColorAnimator = valueAnimatorOfObject;
            valueAnimatorOfObject.setRepeatCount(-1);
            this.mColorAnimator.setDuration(this.mPulseDurationMs * 2);
            this.mColorAnimator.addUpdateListener(this.mUpdateListener);
            this.mColorAnimator.start();
        }
    }

    void animateOnFocus(boolean z10) {
        float f10 = z10 ? this.mFocusedZoom : 1.0f;
        this.mRootView.animate().scaleX(f10).scaleY(f10).setDuration(this.mScaleDurationMs).start();
        startShadowFocusAnimation(z10, this.mScaleDurationMs);
        enableOrbColorAnimation(z10);
    }

    public void enableOrbColorAnimation(boolean z10) {
        this.mColorAnimationEnabled = z10;
        updateColorAnimator();
    }

    float getFocusedZoom() {
        return this.mFocusedZoom;
    }

    int getLayoutResourceId() {
        return androidx.leanback.R.layout.lb_search_orb;
    }

    @ColorInt
    public int getOrbColor() {
        return this.mColors.color;
    }

    public Colors getOrbColors() {
        return this.mColors;
    }

    public Drawable getOrbIcon() {
        return this.mIconDrawable;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.mListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    void scaleOrbViewOnly(float f10) {
        this.mSearchOrbView.setScaleX(f10);
        this.mSearchOrbView.setScaleY(f10);
    }

    public void setOnOrbClickedListener(View.OnClickListener onClickListener) {
        this.mListener = onClickListener;
    }

    @Deprecated
    public void setOrbColor(@ColorInt int i10, @ColorInt int i11) {
        setOrbColors(new Colors(i10, i11, 0));
    }

    public void setOrbColors(Colors colors) {
        this.mColors = colors;
        this.mIcon.setColorFilter(colors.iconColor);
        if (this.mColorAnimator == null) {
            setOrbViewColor(this.mColors.color);
        } else {
            enableOrbColorAnimation(true);
        }
    }

    public void setOrbIcon(Drawable drawable) {
        this.mIconDrawable = drawable;
        this.mIcon.setImageDrawable(drawable);
    }

    void setOrbViewColor(int i10) {
        if (this.mSearchOrbView.getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) this.mSearchOrbView.getBackground()).setColor(i10);
        }
    }

    void setSearchOrbZ(float f10) {
        View view = this.mSearchOrbView;
        float f11 = this.mUnfocusedZ;
        ViewCompat.setZ(view, f11 + (f10 * (this.mFocusedZ - f11)));
    }

    @SuppressLint({"CustomViewStyleable"})
    public SearchOrbView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mColorEvaluator = new ArgbEvaluator();
        this.mUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.leanback.widget.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SearchOrbView.b(this.f491a, valueAnimator);
            }
        };
        this.mFocusUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.leanback.widget.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SearchOrbView.a(this.f492a, valueAnimator);
            }
        };
        Resources resources = context.getResources();
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(getLayoutResourceId(), (ViewGroup) this, true);
        this.mRootView = viewInflate;
        this.mSearchOrbView = viewInflate.findViewById(androidx.leanback.R.id.search_orb);
        ImageView imageView = (ImageView) viewInflate.findViewById(androidx.leanback.R.id.icon);
        this.mIcon = imageView;
        this.mFocusedZoom = context.getResources().getFraction(androidx.leanback.R.fraction.lb_search_orb_focused_zoom, 1, 1);
        this.mPulseDurationMs = context.getResources().getInteger(androidx.leanback.R.integer.lb_search_orb_pulse_duration_ms);
        this.mScaleDurationMs = context.getResources().getInteger(androidx.leanback.R.integer.lb_search_orb_scale_duration_ms);
        float dimensionPixelSize = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_search_orb_focused_z);
        this.mFocusedZ = dimensionPixelSize;
        this.mUnfocusedZ = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_search_orb_unfocused_z);
        int[] iArr = androidx.leanback.R.styleable.lbSearchOrbView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(androidx.leanback.R.styleable.lbSearchOrbView_searchOrbIcon);
        setOrbIcon(drawable == null ? resources.getDrawable(androidx.leanback.R.drawable.lb_ic_in_app_search) : drawable);
        int color = typedArrayObtainStyledAttributes.getColor(androidx.leanback.R.styleable.lbSearchOrbView_searchOrbColor, resources.getColor(androidx.leanback.R.color.lb_default_search_color));
        setOrbColors(new Colors(color, typedArrayObtainStyledAttributes.getColor(androidx.leanback.R.styleable.lbSearchOrbView_searchOrbBrightColor, color), typedArrayObtainStyledAttributes.getColor(androidx.leanback.R.styleable.lbSearchOrbView_searchOrbIconColor, 0)));
        typedArrayObtainStyledAttributes.recycle();
        setFocusable(true);
        setClipChildren(false);
        setOnClickListener(this);
        setSoundEffectsEnabled(false);
        setSearchOrbZ(0.0f);
        ViewCompat.setZ(imageView, dimensionPixelSize);
    }

    public static /* synthetic */ void a(SearchOrbView searchOrbView, ValueAnimator valueAnimator) {
        searchOrbView.getClass();
        searchOrbView.setSearchOrbZ(valueAnimator.getAnimatedFraction());
    }

    public static /* synthetic */ void b(SearchOrbView searchOrbView, ValueAnimator valueAnimator) {
        searchOrbView.getClass();
        searchOrbView.setOrbViewColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttachedToWindow = true;
        updateColorAnimator();
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        animateOnFocus(z10);
    }
}
