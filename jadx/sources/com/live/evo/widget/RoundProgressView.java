package com.live.evo.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import java.text.SimpleDateFormat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class RoundProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f7539f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7540g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f7541h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7542i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f7543j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f7544k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f7545l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f7546m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private SimpleDateFormat f7547n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Paint f7548o;

    public RoundProgressView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7534a = Color.argb(60, 255, 255, 255);
        this.f7535b = Color.argb(255, 255, 255, 255);
        this.f7536c = Color.argb(255, 255, 255, 255);
        this.f7537d = Color.argb(100, 255, 255, 255);
        this.f7538e = 5;
        this.f7539f = new int[]{-1, SupportMenu.CATEGORY_MASK};
        this.f7540g = Color.rgb(118, 181, 66);
        this.f7541h = 12.0f;
        this.f7545l = 0.5f;
        this.f7546m = 1.0f;
        this.f7547n = new SimpleDateFormat("HH:mm:ss.S");
        this.f7548o = new Paint();
        a();
    }

    public float getMax() {
        return this.f7546m;
    }

    public float getProgress() {
        return this.f7545l;
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f7542i = getWidth();
        int height = getHeight();
        this.f7543j = height;
        int i10 = this.f7542i;
        if (i10 > height) {
            this.f7544k = (i10 - height) / 2;
            this.f7542i = height;
        }
        this.f7548o.setAntiAlias(true);
        Paint paint = this.f7548o;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.f7548o.setColor(this.f7534a);
        int i11 = this.f7544k;
        new RectF(new Rect(i11, 0, this.f7542i + i11, this.f7543j));
        int i12 = this.f7542i / 6;
        this.f7548o.setColor(this.f7537d);
        this.f7548o.setStrokeWidth(this.f7538e);
        this.f7548o.setStyle(Paint.Style.STROKE);
        int i13 = this.f7544k;
        int i14 = i12 * 5;
        RectF rectF = new RectF(new Rect(i12 + i13, i12, i13 + i14, i14));
        canvas.drawArc(rectF, 0.0f, 360.0f, false, this.f7548o);
        this.f7548o.setColor(this.f7536c);
        canvas.drawArc(rectF, 90.0f, (this.f7545l * 360.0f) / this.f7546m, false, this.f7548o);
        int i15 = this.f7542i / 4;
        this.f7548o.setStyle(style);
        this.f7548o.setColor(this.f7535b);
        int i16 = this.f7544k;
        int i17 = i15 * 3;
        canvas.drawArc(new RectF(new Rect(i15 + i16, i15, i16 + i17, i17)), 0.0f, 360.0f, false, this.f7548o);
        this.f7548o.reset();
        this.f7548o.setTextSize(this.f7541h);
        this.f7548o.setColor(this.f7540g);
        this.f7548o.setStyle(style);
        this.f7548o.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(ac.g.h(((int) ((this.f7545l * 100.0f) / this.f7546m)) + "", 2, "0"), (this.f7542i / 2) + this.f7544k, (this.f7543j / 2) + (this.f7541h / 3.0f), this.f7548o);
    }

    public void setMax(float f10) {
        this.f7546m = f10;
    }

    public void setProgress(float f10) {
        this.f7545l = f10;
        invalidate();
    }

    public RoundProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7534a = Color.argb(60, 255, 255, 255);
        this.f7535b = Color.argb(255, 255, 255, 255);
        this.f7536c = Color.argb(255, 255, 255, 255);
        this.f7537d = Color.argb(100, 255, 255, 255);
        this.f7538e = 5;
        this.f7539f = new int[]{-1, SupportMenu.CATEGORY_MASK};
        this.f7540g = Color.rgb(118, 181, 66);
        this.f7541h = 12.0f;
        this.f7545l = 0.5f;
        this.f7546m = 1.0f;
        this.f7547n = new SimpleDateFormat("HH:mm:ss.S");
        this.f7548o = new Paint();
        a();
    }

    public void a() {
    }

    public RoundProgressView(Context context) {
        super(context);
        this.f7534a = Color.argb(60, 255, 255, 255);
        this.f7535b = Color.argb(255, 255, 255, 255);
        this.f7536c = Color.argb(255, 255, 255, 255);
        this.f7537d = Color.argb(100, 255, 255, 255);
        this.f7538e = 5;
        this.f7539f = new int[]{-1, SupportMenu.CATEGORY_MASK};
        this.f7540g = Color.rgb(118, 181, 66);
        this.f7541h = 12.0f;
        this.f7545l = 0.5f;
        this.f7546m = 1.0f;
        this.f7547n = new SimpleDateFormat("HH:mm:ss.S");
        this.f7548o = new Paint();
        a();
    }
}
