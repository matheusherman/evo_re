package com.live.evo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.live.evo.R$styleable;
import com.taobao.sophix.PatchStatus;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class GaugeView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f7441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7445e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f7446f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7447g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Paint f7448h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RectF f7449i;

    public GaugeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7447g = 0;
        this.f7448h = null;
        this.f7449i = null;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.GaugeView, 0, 0);
        setStrokeWidth(typedArrayObtainStyledAttributes.getDimension(5, 10.0f));
        setBackgroundColor(typedArrayObtainStyledAttributes.getColor(1, -3355444));
        setFillColor(typedArrayObtainStyledAttributes.getColor(2, -1));
        setStartAngle(typedArrayObtainStyledAttributes.getInt(4, PatchStatus.CODE_LOAD_LIB_UNZIP));
        setAngles(typedArrayObtainStyledAttributes.getInt(0, 270));
        setMaxValue(typedArrayObtainStyledAttributes.getInt(3, 1000));
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setValue(int i10) {
        this.f7447g = i10;
        invalidate();
    }

    public int getAngles() {
        return this.f7445e;
    }

    public int getBackgroundColor() {
        return this.f7442b;
    }

    public int getFillColor() {
        return this.f7443c;
    }

    public int getMaxValue() {
        return this.f7446f;
    }

    public int getStartAngle() {
        return this.f7444d;
    }

    public float getStrokeWidth() {
        return this.f7441a;
    }

    public int getValue() {
        return this.f7447g;
    }

    public void setAngles(int i10) {
        this.f7445e = i10;
        invalidate();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.f7442b = i10;
        invalidate();
    }

    public void setFillColor(int i10) {
        this.f7443c = i10;
        invalidate();
    }

    public void setMaxValue(int i10) {
        this.f7446f = i10;
        invalidate();
    }

    public void setStartAngle(int i10) {
        this.f7444d = i10;
        invalidate();
    }

    public void setStrokeWidth(float f10) {
        this.f7441a = f10;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int height;
        float f10;
        super.onDraw(canvas);
        if (getWidth() < getHeight()) {
            height = getWidth();
        } else {
            height = getHeight();
        }
        float f11 = height;
        float f12 = this.f7441a;
        float f13 = f11 - (f12 * 2.0f);
        float f14 = f11 - (f12 * 2.0f);
        if (f13 < f14) {
            f10 = f13 / 2.0f;
        } else {
            f10 = f14 / 2.0f;
        }
        if (this.f7449i == null) {
            this.f7449i = new RectF();
        }
        RectF rectF = this.f7449i;
        float width = getWidth();
        float f15 = this.f7441a;
        float f16 = (((width - (f15 * 2.0f)) / 2.0f) - f10) + f15;
        float height2 = getHeight();
        float f17 = this.f7441a;
        float f18 = (((height2 - (f17 * 2.0f)) / 2.0f) - f10) + f17;
        float width2 = getWidth();
        float f19 = this.f7441a;
        float f20 = (((width2 - (f19 * 2.0f)) / 2.0f) - f10) + f19 + f13;
        float height3 = getHeight();
        float f21 = this.f7441a;
        rectF.set(f16, f18, f20, (((height3 - (f21 * 2.0f)) / 2.0f) - f10) + f21 + f14);
        if (this.f7448h == null) {
            this.f7448h = new Paint();
        }
        this.f7448h.setStrokeWidth(this.f7441a);
        this.f7448h.setAntiAlias(true);
        this.f7448h.setStyle(Paint.Style.STROKE);
        this.f7448h.setStrokeCap(Paint.Cap.ROUND);
        this.f7448h.setColor(this.f7442b);
        canvas.drawArc(this.f7449i, this.f7444d, this.f7445e, false, this.f7448h);
        this.f7448h.setColor(this.f7443c);
        double dAbs = ((double) this.f7447g) * (((double) Math.abs(this.f7445e)) / ((double) this.f7446f));
        int i10 = this.f7445e;
        if (dAbs > i10) {
            dAbs = i10;
        }
        canvas.drawArc(this.f7449i, this.f7444d, (float) dAbs, false, this.f7448h);
    }

    public void setValue(float f10) {
        this.f7447g = (int) f10;
        invalidate();
    }

    public GaugeView(Context context) {
        super(context);
        this.f7447g = 0;
        this.f7448h = null;
        this.f7449i = null;
    }
}
