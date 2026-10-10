package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class SeekBar extends View {
    private AccessibilitySeekListener mAccessibilitySeekListener;
    private int mActiveBarHeight;
    private int mActiveRadius;
    private final Paint mBackgroundPaint;
    private final RectF mBackgroundRect;
    private int mBarHeight;
    private final Paint mKnobPaint;
    private int mKnobx;
    private int mMax;
    private int mProgress;
    private final Paint mProgressPaint;
    private final RectF mProgressRect;
    private int mSecondProgress;
    private final Paint mSecondProgressPaint;
    private final RectF mSecondProgressRect;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class AccessibilitySeekListener {
        public abstract boolean onAccessibilitySeekBackward();

        public abstract boolean onAccessibilitySeekForward();
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return android.widget.SeekBar.class.getName();
    }

    public int getMax() {
        return this.mMax;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getSecondProgress() {
        return this.mSecondProgress;
    }

    public int getSecondaryProgressColor() {
        return this.mSecondProgressPaint.getColor();
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i10, Bundle bundle) {
        AccessibilitySeekListener accessibilitySeekListener = this.mAccessibilitySeekListener;
        if (accessibilitySeekListener != null) {
            if (i10 == 4096) {
                return accessibilitySeekListener.onAccessibilitySeekForward();
            }
            if (i10 == 8192) {
                return accessibilitySeekListener.onAccessibilitySeekBackward();
            }
        }
        return super.performAccessibilityAction(i10, bundle);
    }

    public void setAccessibilitySeekListener(AccessibilitySeekListener accessibilitySeekListener) {
        this.mAccessibilitySeekListener = accessibilitySeekListener;
    }

    public void setActiveBarHeight(int i10) {
        this.mActiveBarHeight = i10;
        calculate();
    }

    public void setActiveRadius(int i10) {
        this.mActiveRadius = i10;
        calculate();
    }

    public void setBarHeight(int i10) {
        this.mBarHeight = i10;
        calculate();
    }

    public void setMax(int i10) {
        this.mMax = i10;
        calculate();
    }

    public void setProgress(int i10) {
        int i11 = this.mMax;
        if (i10 > i11) {
            i10 = i11;
        } else if (i10 < 0) {
            i10 = 0;
        }
        this.mProgress = i10;
        calculate();
    }

    public void setProgressColor(int i10) {
        this.mProgressPaint.setColor(i10);
    }

    public void setSecondaryProgress(int i10) {
        int i11 = this.mMax;
        if (i10 > i11) {
            i10 = i11;
        } else if (i10 < 0) {
            i10 = 0;
        }
        this.mSecondProgress = i10;
        calculate();
    }

    public void setSecondaryProgressColor(int i10) {
        this.mSecondProgressPaint.setColor(i10);
    }

    public SeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgressRect = new RectF();
        this.mSecondProgressRect = new RectF();
        this.mBackgroundRect = new RectF();
        Paint paint = new Paint(1);
        this.mSecondProgressPaint = paint;
        Paint paint2 = new Paint(1);
        this.mProgressPaint = paint2;
        Paint paint3 = new Paint(1);
        this.mBackgroundPaint = paint3;
        Paint paint4 = new Paint(1);
        this.mKnobPaint = paint4;
        setWillNotDraw(false);
        paint3.setColor(-7829368);
        paint.setColor(-3355444);
        paint2.setColor(SupportMenu.CATEGORY_MASK);
        paint4.setColor(-1);
        this.mBarHeight = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_progressbar_bar_height);
        this.mActiveBarHeight = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_progressbar_active_bar_height);
        this.mActiveRadius = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_progressbar_active_radius);
    }

    private void calculate() {
        int i10;
        int i11;
        if (isFocused()) {
            i10 = this.mActiveBarHeight;
        } else {
            i10 = this.mBarHeight;
        }
        int width = getWidth();
        int height = getHeight();
        int i12 = (height - i10) / 2;
        RectF rectF = this.mBackgroundRect;
        int i13 = this.mBarHeight;
        float f10 = i12;
        float f11 = height - i12;
        rectF.set(i13 / 2, f10, width - (i13 / 2), f11);
        if (isFocused()) {
            i11 = this.mActiveRadius;
        } else {
            i11 = this.mBarHeight / 2;
        }
        float f12 = width - (i11 * 2);
        float f13 = (this.mProgress / this.mMax) * f12;
        RectF rectF2 = this.mProgressRect;
        int i14 = this.mBarHeight;
        rectF2.set(i14 / 2, f10, (i14 / 2) + f13, f11);
        this.mSecondProgressRect.set(this.mProgressRect.right, f10, (this.mBarHeight / 2) + ((this.mSecondProgress / this.mMax) * f12), f11);
        this.mKnobx = i11 + ((int) f13);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i10;
        super.onDraw(canvas);
        if (isFocused()) {
            i10 = this.mActiveRadius;
        } else {
            i10 = this.mBarHeight / 2;
        }
        float f10 = i10;
        canvas.drawRoundRect(this.mBackgroundRect, f10, f10, this.mBackgroundPaint);
        RectF rectF = this.mSecondProgressRect;
        if (rectF.right > rectF.left) {
            canvas.drawRoundRect(rectF, f10, f10, this.mSecondProgressPaint);
        }
        canvas.drawRoundRect(this.mProgressRect, f10, f10, this.mProgressPaint);
        canvas.drawCircle(this.mKnobx, getHeight() / 2, f10, this.mKnobPaint);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        calculate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        calculate();
    }
}
