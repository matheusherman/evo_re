package com.live.evo.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.live.evo.R$styleable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class NetView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f7505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RectF f7506e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SweepGradient f7507f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RadialGradient f7508g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f7509h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f7510i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f7511j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ValueAnimator f7512k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f7513l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Matrix f7514m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Paint f7515n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Paint f7516o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Paint f7517p;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            NetView.this.f7513l = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            NetView.this.f7514m = new Matrix();
            Matrix matrix = NetView.this.f7514m;
            float f10 = NetView.this.f7513l;
            NetView netView = NetView.this;
            matrix.postRotate(f10, netView.f7509h, netView.f7510i);
            NetView.this.invalidate();
        }
    }

    public NetView(Context context) {
        this(context, null);
    }

    private void f() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.f7512k = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setRepeatCount(-1);
        this.f7512k.setDuration(1500L);
        this.f7512k.setInterpolator(new LinearInterpolator());
        this.f7512k.addUpdateListener(new a());
        this.f7512k.start();
    }

    public NetView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void e() {
        Paint paint = new Paint();
        this.f7505d = paint;
        paint.setAntiAlias(true);
        this.f7505d.setColor(ViewCompat.MEASURED_STATE_MASK);
        Paint paint2 = new Paint();
        this.f7515n = paint2;
        paint2.setAntiAlias(true);
        this.f7515n.setColor(this.f7503b);
        Paint paint3 = this.f7515n;
        Paint.Style style = Paint.Style.STROKE;
        paint3.setStyle(style);
        this.f7515n.setAlpha(100);
        Paint paint4 = new Paint();
        this.f7516o = paint4;
        paint4.setAntiAlias(true);
        this.f7516o.setColor(this.f7503b);
        this.f7516o.setAlpha(230);
        if (this.f7504c == 1) {
            this.f7516o.setStyle(style);
            this.f7516o.setStrokeWidth(3.0f);
        } else {
            this.f7516o.setStyle(Paint.Style.FILL);
        }
        Paint paint5 = new Paint();
        this.f7517p = paint5;
        paint5.setAntiAlias(true);
        this.f7517p.setColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public NetView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7509h = 0;
        this.f7510i = 0;
        this.f7511j = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NetViewStyle, 0, 0);
        this.f7502a = typedArrayObtainStyledAttributes.getColor(0, 0);
        this.f7503b = typedArrayObtainStyledAttributes.getColor(1, -16711936);
        this.f7504c = typedArrayObtainStyledAttributes.getInt(2, 0);
        typedArrayObtainStyledAttributes.recycle();
        e();
        f();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f7506e == null) {
            this.f7509h = getWidth() / 2;
            int height = getHeight() / 2;
            this.f7510i = height;
            this.f7511j = Math.min(this.f7509h, height);
            int i10 = this.f7511j;
            this.f7506e = new RectF(i10 / 4, i10 / 4, (i10 * 7) / 4, (i10 * 7) / 4);
            this.f7515n.setStrokeWidth(this.f7511j / 10);
        }
        canvas.concat(this.f7514m);
        if (this.f7504c == 1) {
            if (this.f7507f == null) {
                SweepGradient sweepGradient = new SweepGradient(this.f7509h, this.f7510i, new int[]{this.f7502a, this.f7503b}, new float[]{0.5f, 1.0f});
                this.f7507f = sweepGradient;
                this.f7516o.setShader(sweepGradient);
            }
            canvas.drawCircle(this.f7509h, this.f7510i, this.f7511j - 3, this.f7516o);
            return;
        }
        if (this.f7507f == null) {
            SweepGradient sweepGradient2 = new SweepGradient(this.f7509h, this.f7510i, new int[]{this.f7502a, this.f7503b}, new float[]{0.7f, 1.0f});
            this.f7507f = sweepGradient2;
            this.f7516o.setShader(sweepGradient2);
        }
        if (this.f7508g == null) {
            RadialGradient radialGradient = new RadialGradient(this.f7509h, this.f7510i, this.f7511j, ViewCompat.MEASURED_STATE_MASK, 0, Shader.TileMode.CLAMP);
            this.f7508g = radialGradient;
            this.f7517p.setShader(radialGradient);
        }
        canvas.drawCircle(this.f7509h, this.f7510i, this.f7511j, this.f7505d);
        canvas.drawCircle(this.f7509h, this.f7510i, this.f7511j * 0.75f, this.f7515n);
        canvas.drawCircle(this.f7509h, this.f7510i, this.f7511j, this.f7516o);
        canvas.drawCircle(this.f7509h, this.f7510i, this.f7511j, this.f7517p);
    }
}
