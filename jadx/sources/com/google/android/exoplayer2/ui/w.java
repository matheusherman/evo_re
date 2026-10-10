package com.google.android.exoplayer2.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class w {
    private int A;
    private int B;
    private int C;
    private int D;
    private StaticLayout E;
    private StaticLayout F;
    private int G;
    private int H;
    private int I;
    private Rect J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f1940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f1941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f1942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f1943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f1944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextPaint f1945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f1946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Paint f1947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private CharSequence f1948i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private Layout.Alignment f1949j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private Bitmap f1950k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f1951l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f1952m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f1953n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f1954o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f1955p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f1956q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f1957r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f1958s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f1959t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f1960u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f1961v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f1962w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f1963x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f1964y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f1965z;

    private static boolean a(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if (charSequence != charSequence2) {
            return charSequence != null && charSequence.equals(charSequence2);
        }
        return true;
    }

    private void c(Canvas canvas) {
        canvas.drawBitmap(this.f1950k, (Rect) null, this.J, this.f1947h);
    }

    private void d(Canvas canvas, boolean z10) {
        if (z10) {
            e(canvas);
            return;
        }
        d1.a.b(this.J);
        d1.a.b(this.f1950k);
        c(canvas);
    }

    private void e(Canvas canvas) {
        Canvas canvas2;
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.f1960u) > 0) {
            this.f1946g.setColor(this.f1960u);
            canvas2 = canvas;
            canvas2.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), this.f1946g);
        } else {
            canvas2 = canvas;
        }
        int i10 = this.f1962w;
        if (i10 == 1) {
            this.f1945f.setStrokeJoin(Paint.Join.ROUND);
            this.f1945f.setStrokeWidth(this.f1940a);
            this.f1945f.setColor(this.f1961v);
            this.f1945f.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas2);
        } else if (i10 == 2) {
            TextPaint textPaint = this.f1945f;
            float f10 = this.f1941b;
            float f11 = this.f1942c;
            textPaint.setShadowLayer(f10, f11, f11, this.f1961v);
        } else if (i10 == 3 || i10 == 4) {
            boolean z10 = i10 == 3;
            int i11 = z10 ? -1 : this.f1961v;
            int i12 = z10 ? this.f1961v : -1;
            float f12 = this.f1941b / 2.0f;
            this.f1945f.setColor(this.f1958s);
            this.f1945f.setStyle(Paint.Style.FILL);
            float f13 = -f12;
            this.f1945f.setShadowLayer(this.f1941b, f13, f13, i11);
            staticLayout2.draw(canvas2);
            this.f1945f.setShadowLayer(this.f1941b, f12, f12, i12);
        }
        this.f1945f.setColor(this.f1958s);
        this.f1945f.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas2);
        this.f1945f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas2.restoreToCount(iSave);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x005b  */
    /* JADX WARN: Code duplicated, block: B:16:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0060  */
    private void f() {
        float f10;
        int i10;
        float f11;
        Bitmap bitmap = this.f1950k;
        int i11 = this.C;
        int i12 = this.A;
        int i13 = this.D;
        int i14 = this.B;
        float f12 = i11 - i12;
        float f13 = i12 + (this.f1954o * f12);
        float f14 = i13 - i14;
        float f15 = i14 + (this.f1951l * f14);
        int iRound = Math.round(f12 * this.f1956q);
        float f16 = this.f1957r;
        int iRound2 = f16 != -3.4028235E38f ? Math.round(f14 * f16) : Math.round(iRound * (bitmap.getHeight() / bitmap.getWidth()));
        int i15 = this.f1955p;
        if (i15 != 2) {
            if (i15 == 1) {
                f10 = iRound / 2;
            }
            int iRound3 = Math.round(f13);
            i10 = this.f1953n;
            if (i10 == 2) {
                if (i10 == 1) {
                    f11 = iRound2 / 2;
                }
                int iRound4 = Math.round(f15);
                this.J = new Rect(iRound3, iRound4, iRound + iRound3, iRound2 + iRound4);
            }
            f11 = iRound2;
            f15 -= f11;
            int iRound5 = Math.round(f15);
            this.J = new Rect(iRound3, iRound5, iRound + iRound3, iRound2 + iRound5);
        }
        f10 = iRound;
        f13 -= f10;
        int iRound6 = Math.round(f13);
        i10 = this.f1953n;
        if (i10 == 2) {
            if (i10 == 1) {
                f11 = iRound2 / 2;
            }
            int iRound7 = Math.round(f15);
            this.J = new Rect(iRound6, iRound7, iRound + iRound6, iRound2 + iRound7);
        }
        f11 = iRound2;
        f15 -= f11;
        int iRound8 = Math.round(f15);
        this.J = new Rect(iRound6, iRound8, iRound + iRound6, iRound2 + iRound8);
    }

    private void g() {
        int iMax;
        int iMin;
        int iRound;
        CharSequence charSequence = this.f1948i;
        SpannableStringBuilder spannableStringBuilder = charSequence instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence : new SpannableStringBuilder(this.f1948i);
        int i10 = this.C - this.A;
        int i11 = this.D - this.B;
        this.f1945f.setTextSize(this.f1963x);
        int i12 = (int) ((this.f1963x * 0.125f) + 0.5f);
        int i13 = i12 * 2;
        int i14 = i10 - i13;
        float f10 = this.f1956q;
        if (f10 != -3.4028235E38f) {
            i14 = (int) (i14 * f10);
        }
        int i15 = i14;
        String str = "SubtitlePainter";
        if (i15 <= 0) {
            d1.d.f("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.f1964y > 0.0f) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) this.f1964y), 0, spannableStringBuilder.length(), 16711680);
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
        if (this.f1962w == 1) {
            for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(0, spannableStringBuilder2.length(), ForegroundColorSpan.class)) {
                spannableStringBuilder2.removeSpan(foregroundColorSpan);
            }
        }
        if (Color.alpha(this.f1959t) > 0) {
            int i16 = this.f1962w;
            if (i16 == 0 || i16 == 2) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f1959t), 0, spannableStringBuilder.length(), 16711680);
            } else {
                spannableStringBuilder2.setSpan(new BackgroundColorSpan(this.f1959t), 0, spannableStringBuilder2.length(), 16711680);
            }
        }
        Layout.Alignment alignment = this.f1949j;
        if (alignment == null) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        }
        Layout.Alignment alignment2 = alignment;
        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, this.f1945f, i15, alignment2, this.f1943d, this.f1944e, true);
        this.E = staticLayout;
        int height = staticLayout.getHeight();
        int lineCount = this.E.getLineCount();
        int iMax2 = 0;
        int i17 = 0;
        while (i17 < lineCount) {
            iMax2 = Math.max((int) Math.ceil(this.E.getLineWidth(i17)), iMax2);
            i17++;
            str = str;
        }
        String str2 = str;
        if (this.f1956q == -3.4028235E38f || iMax2 >= i15) {
            i15 = iMax2;
        }
        int i18 = i15 + i13;
        float f11 = this.f1954o;
        if (f11 != -3.4028235E38f) {
            int iRound2 = Math.round(i10 * f11);
            int i19 = this.A;
            int i20 = iRound2 + i19;
            int i21 = this.f1955p;
            if (i21 == 1) {
                i20 = ((i20 * 2) - i18) / 2;
            } else if (i21 == 2) {
                i20 -= i18;
            }
            iMax = Math.max(i20, i19);
            iMin = Math.min(i18 + iMax, this.C);
        } else {
            iMax = ((i10 - i18) / 2) + this.A;
            iMin = iMax + i18;
        }
        int i22 = iMin - iMax;
        if (i22 <= 0) {
            d1.d.f(str2, "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
        }
        float f12 = this.f1951l;
        if (f12 != -3.4028235E38f) {
            if (this.f1952m == 0) {
                iRound = Math.round(i11 * f12) + this.B;
                int i23 = this.f1953n;
                if (i23 == 2) {
                    iRound -= height;
                } else if (i23 == 1) {
                    iRound = ((iRound * 2) - height) / 2;
                }
            } else {
                int lineBottom = this.E.getLineBottom(0) - this.E.getLineTop(0);
                float f13 = this.f1951l;
                if (f13 >= 0.0f) {
                    iRound = Math.round(f13 * lineBottom) + this.B;
                } else {
                    iRound = Math.round((f13 + 1.0f) * lineBottom) + this.D;
                    iRound -= height;
                }
            }
            int i24 = iRound + height;
            int i25 = this.D;
            if (i24 > i25) {
                iRound = i25 - height;
            } else {
                int i26 = this.B;
                if (iRound < i26) {
                    iRound = i26;
                }
            }
        } else {
            iRound = (this.D - height) - ((int) (i11 * this.f1965z));
        }
        this.E = new StaticLayout(spannableStringBuilder, this.f1945f, i22, alignment2, this.f1943d, this.f1944e, true);
        this.F = new StaticLayout(spannableStringBuilder2, this.f1945f, i22, alignment2, this.f1943d, this.f1944e, true);
        this.G = iMax;
        this.H = iRound;
        this.I = i12;
    }

    public void b(y0.a aVar, b1.b bVar, float f10, float f11, float f12, Canvas canvas, int i10, int i11, int i12, int i13) {
        int i14;
        boolean z10 = aVar.f22276d == null;
        if (!z10) {
            i14 = ViewCompat.MEASURED_STATE_MASK;
        } else if (TextUtils.isEmpty(aVar.f22273a)) {
            return;
        } else {
            i14 = aVar.f22284l ? aVar.f22285m : bVar.f635c;
        }
        if (a(this.f1948i, aVar.f22273a) && d1.k.a(this.f1949j, aVar.f22274b) && this.f1950k == aVar.f22276d && this.f1951l == aVar.f22277e && this.f1952m == aVar.f22278f && d1.k.a(Integer.valueOf(this.f1953n), Integer.valueOf(aVar.f22279g)) && this.f1954o == aVar.f22280h && d1.k.a(Integer.valueOf(this.f1955p), Integer.valueOf(aVar.f22281i)) && this.f1956q == aVar.f22282j && this.f1957r == aVar.f22283k && this.f1958s == bVar.f633a && this.f1959t == bVar.f634b && this.f1960u == i14 && this.f1962w == bVar.f636d && this.f1961v == bVar.f637e && d1.k.a(this.f1945f.getTypeface(), bVar.f638f) && this.f1963x == f10 && this.f1964y == f11 && this.f1965z == f12 && this.A == i10 && this.B == i11 && this.C == i12 && this.D == i13) {
            d(canvas, z10);
            return;
        }
        this.f1948i = aVar.f22273a;
        this.f1949j = aVar.f22274b;
        this.f1950k = aVar.f22276d;
        this.f1951l = aVar.f22277e;
        this.f1952m = aVar.f22278f;
        this.f1953n = aVar.f22279g;
        this.f1954o = aVar.f22280h;
        this.f1955p = aVar.f22281i;
        this.f1956q = aVar.f22282j;
        this.f1957r = aVar.f22283k;
        this.f1958s = bVar.f633a;
        this.f1959t = bVar.f634b;
        this.f1960u = i14;
        this.f1962w = bVar.f636d;
        this.f1961v = bVar.f637e;
        this.f1945f.setTypeface(bVar.f638f);
        this.f1963x = f10;
        this.f1964y = f11;
        this.f1965z = f12;
        this.A = i10;
        this.B = i11;
        this.C = i12;
        this.D = i13;
        if (z10) {
            d1.a.b(this.f1948i);
            g();
        } else {
            d1.a.b(this.f1950k);
            f();
        }
        d(canvas, z10);
    }

    public w(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.f1944e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f1943d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        float fRound = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f1940a = fRound;
        this.f1941b = fRound;
        this.f1942c = fRound;
        TextPaint textPaint = new TextPaint();
        this.f1945f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f1946g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f1947h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }
}
