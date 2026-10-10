package com.live.evo.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.ViewCompat;
import com.live.evo.R$styleable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class CircleProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f7410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f7411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f7412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f7415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7416g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f7417h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f7418i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private RectF f7419j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Point f7420k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Paint f7421l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Paint f7422m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Paint f7423n;

    public void setProgressWithAnimation(float f10) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "progress", f10);
        objectAnimatorOfFloat.setDuration(1500L);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfFloat.start();
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.f7419j = new RectF();
        this.f7420k = new Point();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.CircleProgressBar, 0, 0);
        try {
            this.f7410a = typedArrayObtainStyledAttributes.getDimension(3, this.f7410a);
            this.f7412c = typedArrayObtainStyledAttributes.getFloat(2, this.f7412c);
            this.f7416g = typedArrayObtainStyledAttributes.getInt(4, this.f7416g);
            this.f7413d = typedArrayObtainStyledAttributes.getInt(1, this.f7413d);
            this.f7414e = typedArrayObtainStyledAttributes.getInt(0, this.f7414e);
            this.f7418i = typedArrayObtainStyledAttributes.getBoolean(5, this.f7418i);
            this.f7417h = typedArrayObtainStyledAttributes.getColor(6, this.f7417h);
            this.f7411b = typedArrayObtainStyledAttributes.getDimension(7, this.f7411b);
            typedArrayObtainStyledAttributes.recycle();
            Paint paint = new Paint(1);
            this.f7421l = paint;
            paint.setColor(a(this.f7416g, 0.3f));
            Paint paint2 = this.f7421l;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            this.f7421l.setStrokeWidth(this.f7410a);
            Paint paint3 = new Paint(1);
            this.f7422m = paint3;
            paint3.setColor(this.f7416g);
            this.f7422m.setStyle(style);
            this.f7422m.setStrokeWidth(this.f7410a);
            Paint paint4 = new Paint(1);
            this.f7423n = paint4;
            paint4.setColor(this.f7416g);
            this.f7423n.setTextSize(this.f7411b);
            this.f7423n.setTextAlign(Paint.Align.CENTER);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public int getColor() {
        return this.f7416g;
    }

    public int getMax() {
        return this.f7414e;
    }

    public int getMin() {
        return this.f7413d;
    }

    public float getProgress() {
        return this.f7412c;
    }

    public float getStrokeWidth() {
        return this.f7410a;
    }

    public void setColor(int i10) {
        this.f7416g = i10;
        this.f7421l.setColor(a(i10, 0.3f));
        this.f7422m.setColor(i10);
        invalidate();
        requestLayout();
    }

    public void setMax(int i10) {
        this.f7414e = i10;
        invalidate();
    }

    public void setMin(int i10) {
        this.f7413d = i10;
        invalidate();
    }

    public void setProgress(float f10) {
        this.f7412c = f10;
        invalidate();
    }

    public void setShowText(boolean z10) {
        this.f7418i = z10;
        invalidate();
        requestLayout();
    }

    public void setStrokeWidth(float f10) {
        this.f7410a = f10;
        this.f7421l.setStrokeWidth(f10);
        this.f7422m.setStrokeWidth(f10);
        invalidate();
        requestLayout();
    }

    public void setTextColor(int i10) {
        this.f7417h = i10;
        this.f7423n.setColor(i10);
        invalidate();
        requestLayout();
    }

    public void setTextSize(float f10) {
        this.f7411b = f10;
        this.f7423n.setTextSize(f10);
        invalidate();
        requestLayout();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7410a = 4.0f;
        this.f7411b = 15.0f;
        this.f7412c = 0.0f;
        this.f7413d = 0;
        this.f7414e = 100;
        this.f7415f = -90;
        this.f7416g = -12303292;
        this.f7417h = ViewCompat.MEASURED_STATE_MASK;
        this.f7418i = true;
        b(context, attributeSet);
    }

    public int a(int i10, float f10) {
        return Color.argb(Math.round(Color.alpha(i10) * f10), Color.red(i10), Color.green(i10), Color.blue(i10));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(this.f7419j, this.f7421l);
        canvas.drawArc(this.f7419j, this.f7415f, (this.f7412c * 360.0f) / this.f7414e, false, this.f7422m);
        if (this.f7418i) {
            String str = "" + ((int) ((this.f7412c / this.f7414e) * 100.0f)) + "%";
            Rect rect = new Rect();
            this.f7423n.getTextBounds(str, 0, str.length(), rect);
            Point point = this.f7420k;
            canvas.drawText(str, point.x, point.y + ((rect.bottom - rect.top) / 2), this.f7423n);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int iMin = Math.min(View.getDefaultSize(getSuggestedMinimumWidth(), i10), View.getDefaultSize(getSuggestedMinimumHeight(), i11));
        setMeasuredDimension(iMin, iMin);
        RectF rectF = this.f7419j;
        float f10 = this.f7410a;
        float f11 = iMin;
        rectF.set((f10 / 2.0f) + 0.0f, (f10 / 2.0f) + 0.0f, f11 - (f10 / 2.0f), f11 - (f10 / 2.0f));
        Point point = this.f7420k;
        int i12 = iMin / 2;
        point.x = i12;
        point.y = i12;
    }
}
