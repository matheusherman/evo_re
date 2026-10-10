package androidx.leanback.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ScaleFrameLayout extends FrameLayout {
    private static final int DEFAULT_CHILD_GRAVITY = 8388659;
    private float mChildScale;
    private float mLayoutScaleX;
    private float mLayoutScaleY;

    public ScaleFrameLayout(Context context) {
        this(context, null);
    }

    public ScaleFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private static int getScaledMeasureSpec(int i10, float f10) {
        return f10 == 1.0f ? i10 : View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(i10) / f10) + 0.5f), View.MeasureSpec.getMode(i10));
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:42:0x00de  */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int paddingLeft;
        int i14;
        int paddingRight;
        int paddingTop;
        int i15;
        int paddingBottom;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        ScaleFrameLayout scaleFrameLayout = this;
        int childCount = scaleFrameLayout.getChildCount();
        int layoutDirection = scaleFrameLayout.getLayoutDirection();
        float width = layoutDirection == 1 ? scaleFrameLayout.getWidth() - scaleFrameLayout.getPivotX() : scaleFrameLayout.getPivotX();
        if (scaleFrameLayout.mLayoutScaleX != 1.0f) {
            int paddingLeft2 = scaleFrameLayout.getPaddingLeft();
            float f10 = scaleFrameLayout.mLayoutScaleX;
            paddingLeft = paddingLeft2 + ((int) ((width - (width / f10)) + 0.5f));
            i14 = (int) ((((i12 - i10) - width) / f10) + width + 0.5f);
            paddingRight = scaleFrameLayout.getPaddingRight();
        } else {
            paddingLeft = scaleFrameLayout.getPaddingLeft();
            i14 = i12 - i10;
            paddingRight = scaleFrameLayout.getPaddingRight();
        }
        int i22 = i14 - paddingRight;
        float pivotY = scaleFrameLayout.getPivotY();
        if (scaleFrameLayout.mLayoutScaleY != 1.0f) {
            int paddingTop2 = scaleFrameLayout.getPaddingTop();
            float f11 = scaleFrameLayout.mLayoutScaleY;
            paddingTop = paddingTop2 + ((int) ((pivotY - (pivotY / f11)) + 0.5f));
            i15 = (int) ((((i13 - i11) - pivotY) / f11) + pivotY + 0.5f);
            paddingBottom = scaleFrameLayout.getPaddingBottom();
        } else {
            paddingTop = scaleFrameLayout.getPaddingTop();
            i15 = i13 - i11;
            paddingBottom = scaleFrameLayout.getPaddingBottom();
        }
        int i23 = i15 - paddingBottom;
        int i24 = 0;
        while (i24 < childCount) {
            View childAt = scaleFrameLayout.getChildAt(i24);
            if (childAt.getVisibility() != 8) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i25 = layoutParams.gravity;
                if (i25 == -1) {
                    i25 = 8388659;
                }
                int absoluteGravity = Gravity.getAbsoluteGravity(i25, layoutDirection);
                int i26 = i25 & 112;
                int i27 = absoluteGravity & 7;
                if (i27 != 1) {
                    if (i27 != 5) {
                        i18 = layoutParams.leftMargin + paddingLeft;
                    } else {
                        i16 = i22 - measuredWidth;
                        i17 = layoutParams.rightMargin;
                    }
                    if (i26 == 16) {
                        i19 = (((i23 - paddingTop) - measuredHeight) / 2) + paddingTop + layoutParams.topMargin;
                        i20 = layoutParams.bottomMargin;
                    } else if (i26 == 48 && i26 == 80) {
                        i19 = i23 - measuredHeight;
                        i20 = layoutParams.bottomMargin;
                    } else {
                        i21 = i + paddingTop;
                        childAt.layout(i18, i21, measuredWidth + i18, measuredHeight + i21);
                        childAt.setPivotX(width - i18);
                        childAt.setPivotY(pivotY - i21);
                    }
                    i21 = i19 - i20;
                    childAt.layout(i18, i21, measuredWidth + i18, measuredHeight + i21);
                    childAt.setPivotX(width - i18);
                    childAt.setPivotY(pivotY - i21);
                } else {
                    i16 = (((i22 - paddingLeft) - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    i17 = layoutParams.rightMargin;
                }
                i18 = i16 - i17;
                if (i26 == 16) {
                    int i28 = i26 == 48 ? layoutParams.topMargin : layoutParams.topMargin;
                    i21 = i28 + paddingTop;
                    childAt.layout(i18, i21, measuredWidth + i18, measuredHeight + i21);
                    childAt.setPivotX(width - i18);
                    childAt.setPivotY(pivotY - i21);
                } else {
                    i19 = (((i23 - paddingTop) - measuredHeight) / 2) + paddingTop + layoutParams.topMargin;
                    i20 = layoutParams.bottomMargin;
                }
                i21 = i19 - i20;
                childAt.layout(i18, i21, measuredWidth + i18, measuredHeight + i21);
                childAt.setPivotX(width - i18);
                childAt.setPivotY(pivotY - i21);
            }
            i24++;
            scaleFrameLayout = this;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        float f10 = this.mLayoutScaleX;
        if (f10 == 1.0f && this.mLayoutScaleY == 1.0f) {
            super.onMeasure(i10, i11);
        } else {
            super.onMeasure(getScaledMeasureSpec(i10, f10), getScaledMeasureSpec(i11, this.mLayoutScaleY));
            setMeasuredDimension((int) ((getMeasuredWidth() * this.mLayoutScaleX) + 0.5f), (int) ((getMeasuredHeight() * this.mLayoutScaleY) + 0.5f));
        }
    }

    public void setChildScale(float f10) {
        if (this.mChildScale != f10) {
            this.mChildScale = f10;
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                getChildAt(i10).setScaleX(f10);
                getChildAt(i10).setScaleY(f10);
            }
        }
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        throw new UnsupportedOperationException();
    }

    public void setLayoutScaleX(float f10) {
        if (f10 != this.mLayoutScaleX) {
            this.mLayoutScaleX = f10;
            requestLayout();
        }
    }

    public void setLayoutScaleY(float f10) {
        if (f10 != this.mLayoutScaleY) {
            this.mLayoutScaleY = f10;
            requestLayout();
        }
    }

    public ScaleFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mLayoutScaleX = 1.0f;
        this.mLayoutScaleY = 1.0f;
        this.mChildScale = 1.0f;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        view.setScaleX(this.mChildScale);
        view.setScaleY(this.mChildScale);
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        boolean zAddViewInLayout = super.addViewInLayout(view, i10, layoutParams, z10);
        if (zAddViewInLayout) {
            view.setScaleX(this.mChildScale);
            view.setScaleY(this.mChildScale);
        }
        return zAddViewInLayout;
    }
}
