package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class ShadowOverlayContainer extends FrameLayout {
    public static final int SHADOW_DYNAMIC = 3;
    public static final int SHADOW_NONE = 1;
    public static final int SHADOW_STATIC = 2;
    private static final Rect sTempRect = new Rect();
    private float mFocusedZ;
    private boolean mInitialized;
    int mOverlayColor;
    private Paint mOverlayPaint;
    private int mRoundedCornerRadius;
    private boolean mRoundedCorners;
    private Object mShadowImpl;
    private int mShadowType;
    private float mUnfocusedZ;
    private View mWrappedView;

    public ShadowOverlayContainer(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Deprecated
    public void initialize(boolean z10, boolean z11) {
        initialize(z10, z11, true);
    }

    public void useDynamicShadow() {
        useDynamicShadow(getResources().getDimension(androidx.leanback.R.dimen.lb_material_shadow_normal_z), getResources().getDimension(androidx.leanback.R.dimen.lb_material_shadow_focused_z));
    }

    public ShadowOverlayContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getShadowType() {
        return this.mShadowType;
    }

    public View getWrappedView() {
        return this.mWrappedView;
    }

    @Deprecated
    public void initialize(boolean z10, boolean z11, boolean z12) {
        initialize(!z10 ? 1 : this.mShadowType, z11, z12 ? getContext().getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_rounded_rect_corner_radius) : 0);
    }

    public void setOverlayColor(@ColorInt int i10) {
        Paint paint = this.mOverlayPaint;
        if (paint == null || i10 == this.mOverlayColor) {
            return;
        }
        this.mOverlayColor = i10;
        paint.setColor(i10);
        invalidate();
    }

    public void setShadowFocusLevel(float f10) {
        Object obj = this.mShadowImpl;
        if (obj != null) {
            ShadowOverlayHelper.setShadowFocusLevel(obj, this.mShadowType, f10);
        }
    }

    public void useStaticShadow() {
        if (this.mInitialized) {
            throw new IllegalStateException("Already initialized");
        }
        if (supportsShadow()) {
            this.mShadowType = 2;
        }
    }

    public void wrap(View view) {
        if (!this.mInitialized || this.mWrappedView != null) {
            throw new IllegalStateException();
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
            layoutParams.width = layoutParams.width == -1 ? -1 : -2;
            layoutParams.height = layoutParams.height == -1 ? -1 : -2;
            setLayoutParams(layoutParams);
            addView(view, layoutParams2);
        } else {
            addView(view);
        }
        if (this.mRoundedCorners && this.mShadowType != 3) {
            RoundedRectHelper.setClipToRoundedOutline(this, true);
        }
        this.mWrappedView = view;
    }

    public ShadowOverlayContainer(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mShadowType = 1;
        useStaticShadow();
        useDynamicShadow();
    }

    public static void prepareParentForShadow(ViewGroup viewGroup) {
        StaticShadowHelper.prepareParent(viewGroup);
    }

    public static boolean supportsDynamicShadow() {
        return ShadowHelper.supportsDynamicShadow();
    }

    public static boolean supportsShadow() {
        return StaticShadowHelper.supportsShadow();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mOverlayPaint != null && this.mOverlayColor != 0) {
            canvas.drawRect(this.mWrappedView.getLeft(), this.mWrappedView.getTop(), this.mWrappedView.getRight(), this.mWrappedView.getBottom(), this.mOverlayPaint);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View view;
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10 && (view = this.mWrappedView) != null) {
            Rect rect = sTempRect;
            rect.left = (int) view.getPivotX();
            rect.top = (int) this.mWrappedView.getPivotY();
            offsetDescendantRectToMyCoords(this.mWrappedView, rect);
            setPivotX(rect.left);
            setPivotY(rect.top);
        }
    }

    public void useDynamicShadow(float f10, float f11) {
        if (!this.mInitialized) {
            if (supportsDynamicShadow()) {
                this.mShadowType = 3;
                this.mUnfocusedZ = f10;
                this.mFocusedZ = f11;
                return;
            }
            return;
        }
        throw new IllegalStateException("Already initialized");
    }

    void initialize(int i10, boolean z10, int i11) {
        if (!this.mInitialized) {
            this.mInitialized = true;
            this.mRoundedCornerRadius = i11;
            this.mRoundedCorners = i11 > 0;
            this.mShadowType = i10;
            if (i10 == 2) {
                this.mShadowImpl = StaticShadowHelper.addStaticShadow(this);
            } else if (i10 == 3) {
                this.mShadowImpl = ShadowHelper.addDynamicShadow(this, this.mUnfocusedZ, this.mFocusedZ, i11);
            }
            if (z10) {
                setWillNotDraw(false);
                this.mOverlayColor = 0;
                Paint paint = new Paint();
                this.mOverlayPaint = paint;
                paint.setColor(this.mOverlayColor);
                this.mOverlayPaint.setStyle(Paint.Style.FILL);
                return;
            }
            setWillNotDraw(true);
            this.mOverlayPaint = null;
            return;
        }
        throw new IllegalStateException();
    }

    ShadowOverlayContainer(Context context, int i10, boolean z10, float f10, float f11, int i11) {
        super(context);
        this.mShadowType = 1;
        this.mUnfocusedZ = f10;
        this.mFocusedZ = f11;
        initialize(i10, z10, i11);
    }
}
