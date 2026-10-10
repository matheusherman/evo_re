package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.location.LocationRequestCompat;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class DefaultTimeBar extends View implements a0 {
    private int A;
    private long B;
    private int C;
    private Rect D;
    private ValueAnimator E;
    private float F;
    private boolean G;
    private boolean H;
    private long I;
    private long J;
    private long K;
    private long L;
    private int M;

    @Nullable
    private long[] N;

    @Nullable
    private boolean[] O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f1677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f1678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f1679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f1680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Paint f1681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Paint f1682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f1683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Paint f1684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Paint f1685i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Paint f1686j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private final Drawable f1687k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f1688l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f1689m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f1690n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f1691o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f1692p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f1693q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f1694r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f1695s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f1696t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final StringBuilder f1697u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Formatter f1698v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Runnable f1699w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final CopyOnWriteArraySet<a0.a> f1700x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Point f1701y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final float f1702z;

    public DefaultTimeBar(Context context) {
        this(context, null);
    }

    private static int d(float f10, int i10) {
        return (int) ((i10 * f10) + 0.5f);
    }

    private static int k(float f10, int i10) {
        return (int) (i10 / f10);
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int paddingBottom;
        int iMax;
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i14 - getPaddingRight();
        int i16 = this.G ? 0 : this.f1695s;
        if (this.f1690n == 1) {
            paddingBottom = (i15 - getPaddingBottom()) - this.f1689m;
            int paddingBottom2 = i15 - getPaddingBottom();
            int i17 = this.f1688l;
            iMax = (paddingBottom2 - i17) - Math.max(i16 - (i17 / 2), 0);
        } else {
            paddingBottom = (i15 - this.f1689m) / 2;
            iMax = (i15 - this.f1688l) / 2;
        }
        this.f1677a.set(paddingLeft, paddingBottom, paddingRight, this.f1689m + paddingBottom);
        Rect rect = this.f1678b;
        Rect rect2 = this.f1677a;
        rect.set(rect2.left + i16, iMax, rect2.right - i16, this.f1688l + iMax);
        if (d1.k.f9577a >= 29) {
            p(i14, i15);
        }
        u();
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void e(Canvas canvas) {
        int i10;
        if (this.J <= 0) {
            return;
        }
        Rect rect = this.f1680d;
        int iC = d1.k.c(rect.right, rect.left, this.f1678b.right);
        int iCenterY = this.f1680d.centerY();
        Drawable drawable = this.f1687k;
        if (drawable == null) {
            if (this.H || isFocused()) {
                i10 = this.f1694r;
            } else {
                i10 = isEnabled() ? this.f1692p : this.f1693q;
            }
            canvas.drawCircle(iC, iCenterY, (int) ((i10 * this.F) / 2.0f), this.f1686j);
            return;
        }
        int intrinsicWidth = ((int) (drawable.getIntrinsicWidth() * this.F)) / 2;
        int intrinsicHeight = ((int) (this.f1687k.getIntrinsicHeight() * this.F)) / 2;
        this.f1687k.setBounds(iC - intrinsicWidth, iCenterY - intrinsicHeight, iC + intrinsicWidth, iCenterY + intrinsicHeight);
        this.f1687k.draw(canvas);
    }

    private void f(Canvas canvas) {
        int iHeight = this.f1678b.height();
        int iCenterY = this.f1678b.centerY() - (iHeight / 2);
        int i10 = iHeight + iCenterY;
        if (this.J <= 0) {
            Rect rect = this.f1678b;
            canvas.drawRect(rect.left, iCenterY, rect.right, i10, this.f1683g);
            return;
        }
        Rect rect2 = this.f1679c;
        int i11 = rect2.left;
        int i12 = rect2.right;
        int iMax = Math.max(Math.max(this.f1678b.left, i12), this.f1680d.right);
        int i13 = this.f1678b.right;
        if (iMax < i13) {
            canvas.drawRect(iMax, iCenterY, i13, i10, this.f1683g);
        }
        int iMax2 = Math.max(i11, this.f1680d.right);
        if (i12 > iMax2) {
            canvas.drawRect(iMax2, iCenterY, i12, i10, this.f1682f);
        }
        if (this.f1680d.width() > 0) {
            Rect rect3 = this.f1680d;
            canvas.drawRect(rect3.left, iCenterY, rect3.right, i10, this.f1681e);
        }
        if (this.M == 0) {
            return;
        }
        long[] jArr = (long[]) d1.a.b(this.N);
        boolean[] zArr = (boolean[]) d1.a.b(this.O);
        int i14 = this.f1691o / 2;
        for (int i15 = 0; i15 < this.M; i15++) {
            int iWidth = ((int) ((((long) this.f1678b.width()) * d1.k.d(jArr[i15], 0L, this.J)) / this.J)) - i14;
            Rect rect4 = this.f1678b;
            int iMin = rect4.left + Math.min(rect4.width() - this.f1691o, Math.max(0, iWidth));
            canvas.drawRect(iMin, iCenterY, iMin + this.f1691o, i10, zArr[i15] ? this.f1685i : this.f1684h);
        }
    }

    private long getPositionIncrement() {
        long j10 = this.B;
        if (j10 != -9223372036854775807L) {
            return j10;
        }
        long j11 = this.J;
        if (j11 == -9223372036854775807L) {
            return 0L;
        }
        return j11 / ((long) this.A);
    }

    private String getProgressText() {
        return d1.k.g(this.f1697u, this.f1698v, this.K);
    }

    private long getScrubberPosition() {
        if (this.f1678b.width() <= 0 || this.J == -9223372036854775807L) {
            return 0L;
        }
        return (((long) this.f1680d.width()) * this.J) / ((long) this.f1678b.width());
    }

    private boolean i(float f10, float f11) {
        return this.f1677a.contains((int) f10, (int) f11);
    }

    private void j(float f10) {
        Rect rect = this.f1680d;
        Rect rect2 = this.f1678b;
        rect.right = d1.k.c((int) f10, rect2.left, rect2.right);
    }

    private Point l(MotionEvent motionEvent) {
        this.f1701y.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.f1701y;
    }

    private boolean m(long j10) {
        long j11 = this.J;
        if (j11 <= 0) {
            return false;
        }
        long j12 = this.H ? this.I : this.K;
        long jD = d1.k.d(j12 + j10, 0L, j11);
        if (jD == j12) {
            return false;
        }
        if (this.H) {
            w(jD);
        } else {
            s(jD);
        }
        u();
        return true;
    }

    private boolean n(Drawable drawable) {
        return d1.k.f9577a >= 23 && o(drawable, getLayoutDirection());
    }

    private static boolean o(Drawable drawable, int i10) {
        return d1.k.f9577a >= 23 && drawable.setLayoutDirection(i10);
    }

    @RequiresApi(29)
    private void p(int i10, int i11) {
        Rect rect = this.D;
        if (rect != null && rect.width() == i10 && this.D.height() == i11) {
            return;
        }
        Rect rect2 = new Rect(0, 0, i10, i11);
        this.D = rect2;
        setSystemGestureExclusionRects(Collections.singletonList(rect2));
    }

    private void s(long j10) {
        this.I = j10;
        this.H = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<a0.a> it = this.f1700x.iterator();
        while (it.hasNext()) {
            it.next().c(this, j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z10) {
        removeCallbacks(this.f1699w);
        this.H = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<a0.a> it = this.f1700x.iterator();
        while (it.hasNext()) {
            it.next().b(this, this.I, z10);
        }
    }

    private void u() {
        this.f1679c.set(this.f1678b);
        this.f1680d.set(this.f1678b);
        long j10 = this.H ? this.I : this.K;
        if (this.J > 0) {
            int iWidth = (int) ((((long) this.f1678b.width()) * this.L) / this.J);
            Rect rect = this.f1679c;
            Rect rect2 = this.f1678b;
            rect.right = Math.min(rect2.left + iWidth, rect2.right);
            int iWidth2 = (int) ((((long) this.f1678b.width()) * j10) / this.J);
            Rect rect3 = this.f1680d;
            Rect rect4 = this.f1678b;
            rect3.right = Math.min(rect4.left + iWidth2, rect4.right);
        } else {
            Rect rect5 = this.f1679c;
            int i10 = this.f1678b.left;
            rect5.right = i10;
            this.f1680d.right = i10;
        }
        invalidate(this.f1677a);
    }

    private void v() {
        Drawable drawable = this.f1687k;
        if (drawable != null && drawable.isStateful() && this.f1687k.setState(getDrawableState())) {
            invalidate();
        }
    }

    private void w(long j10) {
        if (this.I == j10) {
            return;
        }
        this.I = j10;
        Iterator<a0.a> it = this.f1700x.iterator();
        while (it.hasNext()) {
            it.next().a(this, j10);
        }
    }

    public void g(long j10) {
        if (this.E.isStarted()) {
            this.E.cancel();
        }
        this.E.setFloatValues(this.F, 0.0f);
        this.E.setDuration(j10);
        this.E.start();
    }

    @Override // com.google.android.exoplayer2.ui.a0
    public long getPreferredUpdateDelay() {
        int iK = k(this.f1702z, this.f1678b.width());
        if (iK == 0) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        long j10 = this.J;
        return (j10 == 0 || j10 == -9223372036854775807L) ? LocationRequestCompat.PASSIVE_INTERVAL : j10 / ((long) iK);
    }

    public void h(boolean z10) {
        if (this.E.isStarted()) {
            this.E.cancel();
        }
        this.G = z10;
        this.F = 0.0f;
        invalidate(this.f1677a);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        Drawable drawable = this.f1687k;
        if (drawable == null || !o(drawable, i10)) {
            return;
        }
        invalidate();
    }

    public void q() {
        if (this.E.isStarted()) {
            this.E.cancel();
        }
        this.G = false;
        this.F = 1.0f;
        invalidate(this.f1677a);
    }

    public void r(long j10) {
        if (this.E.isStarted()) {
            this.E.cancel();
        }
        this.G = false;
        this.E.setFloatValues(this.F, 1.0f);
        this.E.setDuration(j10);
        this.E.start();
    }

    public void setAdMarkerColor(@ColorInt int i10) {
        this.f1684h.setColor(i10);
        invalidate(this.f1677a);
    }

    public void setBufferedColor(@ColorInt int i10) {
        this.f1682f.setColor(i10);
        invalidate(this.f1677a);
    }

    @Override // com.google.android.exoplayer2.ui.a0
    public void setBufferedPosition(long j10) {
        if (this.L == j10) {
            return;
        }
        this.L = j10;
        u();
    }

    public void setDuration(long j10) {
        if (this.J == j10) {
            return;
        }
        this.J = j10;
        if (this.H && j10 == -9223372036854775807L) {
            t(true);
        }
        u();
    }

    public void setKeyCountIncrement(int i10) {
        d1.a.a(i10 > 0);
        this.A = i10;
        this.B = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long j10) {
        d1.a.a(j10 > 0);
        this.A = -1;
        this.B = j10;
    }

    public void setPlayedAdMarkerColor(@ColorInt int i10) {
        this.f1685i.setColor(i10);
        invalidate(this.f1677a);
    }

    public void setPlayedColor(@ColorInt int i10) {
        this.f1681e.setColor(i10);
        invalidate(this.f1677a);
    }

    @Override // com.google.android.exoplayer2.ui.a0
    public void setPosition(long j10) {
        if (this.K == j10) {
            return;
        }
        this.K = j10;
        setContentDescription(getProgressText());
        u();
    }

    public void setScrubberColor(@ColorInt int i10) {
        this.f1686j.setColor(i10);
        invalidate(this.f1677a);
    }

    public void setUnplayedColor(@ColorInt int i10) {
        this.f1683g.setColor(i10);
        invalidate(this.f1677a);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, attributeSet);
    }

    public static /* synthetic */ void b(DefaultTimeBar defaultTimeBar, ValueAnimator valueAnimator) {
        defaultTimeBar.getClass();
        defaultTimeBar.F = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        defaultTimeBar.invalidate(defaultTimeBar.f1677a);
    }

    @Override // com.google.android.exoplayer2.ui.a0
    public void a(a0.a aVar) {
        d1.a.b(aVar);
        this.f1700x.add(aVar);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        v();
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1687k;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        f(canvas);
        e(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z10, int i10, @Nullable Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (this.H && !z10) {
            t(false);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.J <= 0) {
            return;
        }
        if (d1.k.f9577a >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x001a  */
    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:15:0x002b  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (isEnabled()) {
            long positionIncrement = getPositionIncrement();
            if (i10 != 66) {
                switch (i10) {
                    case 21:
                        positionIncrement = -positionIncrement;
                        if (m(positionIncrement)) {
                            removeCallbacks(this.f1699w);
                            postDelayed(this.f1699w, 1000L);
                            return true;
                        }
                        break;
                    case 22:
                        if (m(positionIncrement)) {
                            removeCallbacks(this.f1699w);
                            postDelayed(this.f1699w, 1000L);
                            return true;
                        }
                        break;
                    case 23:
                        if (this.H) {
                            t(false);
                            return true;
                        }
                        break;
                }
            } else if (this.H) {
                t(false);
                return true;
            }
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == 0) {
            size = this.f1689m;
        } else if (mode != 1073741824) {
            size = Math.min(this.f1689m, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i10), size);
        v();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004e  */
    /* JADX WARN: Code duplicated, block: B:25:0x0052  */
    /* JADX WARN: Code duplicated, block: B:27:0x0058  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10 = false;
        if (isEnabled() && this.J > 0) {
            Point pointL = l(motionEvent);
            int i10 = pointL.x;
            int i11 = pointL.y;
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action == 3) {
                            if (this.H) {
                                if (motionEvent.getAction() == 3) {
                                    z10 = true;
                                }
                                t(z10);
                                return true;
                            }
                        }
                    } else if (this.H) {
                        if (i11 < this.f1696t) {
                            int i12 = this.C;
                            j(i12 + ((i10 - i12) / 3));
                        } else {
                            this.C = i10;
                            j(i10);
                        }
                        w(getScrubberPosition());
                        u();
                        invalidate();
                        return true;
                    }
                } else if (this.H) {
                    if (motionEvent.getAction() == 3) {
                        z10 = true;
                    }
                    t(z10);
                    return true;
                }
            } else {
                float f10 = i10;
                if (i(f10, i11)) {
                    j(f10);
                    s(getScrubberPosition());
                    u();
                    invalidate();
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i10, @Nullable Bundle bundle) {
        if (super.performAccessibilityAction(i10, bundle)) {
            return true;
        }
        if (this.J <= 0) {
            return false;
        }
        if (i10 == 8192) {
            if (m(-getPositionIncrement())) {
                t(false);
            }
        } else {
            if (i10 != 4096) {
                return false;
            }
            if (m(getPositionIncrement())) {
                t(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.a0
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (this.H && !z10) {
            t(true);
        }
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i10, @Nullable AttributeSet attributeSet2) {
        this(context, attributeSet, i10, attributeSet2, 0);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i10, @Nullable AttributeSet attributeSet2, int i11) {
        super(context, attributeSet, i10);
        this.f1677a = new Rect();
        this.f1678b = new Rect();
        this.f1679c = new Rect();
        this.f1680d = new Rect();
        Paint paint = new Paint();
        this.f1681e = paint;
        Paint paint2 = new Paint();
        this.f1682f = paint2;
        Paint paint3 = new Paint();
        this.f1683g = paint3;
        Paint paint4 = new Paint();
        this.f1684h = paint4;
        Paint paint5 = new Paint();
        this.f1685i = paint5;
        Paint paint6 = new Paint();
        this.f1686j = paint6;
        paint6.setAntiAlias(true);
        this.f1700x = new CopyOnWriteArraySet<>();
        this.f1701y = new Point();
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f1702z = f10;
        this.f1696t = d(f10, -50);
        int iD = d(f10, 4);
        int iD2 = d(f10, 26);
        int iD3 = d(f10, 4);
        int iD4 = d(f10, 12);
        int iD5 = d(f10, 0);
        int iD6 = d(f10, 16);
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.DefaultTimeBar, i10, i11);
            try {
                Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.DefaultTimeBar_scrubber_drawable);
                this.f1687k = drawable;
                if (drawable != null) {
                    n(drawable);
                    iD2 = Math.max(drawable.getMinimumHeight(), iD2);
                }
                this.f1688l = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_bar_height, iD);
                this.f1689m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_touch_target_height, iD2);
                this.f1690n = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_bar_gravity, 0);
                this.f1691o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_ad_marker_width, iD3);
                this.f1692p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_enabled_size, iD4);
                this.f1693q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_disabled_size, iD5);
                this.f1694r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_dragged_size, iD6);
                int i12 = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_played_color, -1);
                int i13 = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_scrubber_color, -1);
                int i14 = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_buffered_color, -855638017);
                int i15 = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_unplayed_color, 872415231);
                int i16 = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_ad_marker_color, -1291845888);
                int i17 = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_played_ad_marker_color, 872414976);
                paint.setColor(i12);
                paint6.setColor(i13);
                paint2.setColor(i14);
                paint3.setColor(i15);
                paint4.setColor(i16);
                paint5.setColor(i17);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            this.f1688l = iD;
            this.f1689m = iD2;
            this.f1690n = 0;
            this.f1691o = iD3;
            this.f1692p = iD4;
            this.f1693q = iD5;
            this.f1694r = iD6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.f1687k = null;
        }
        StringBuilder sb2 = new StringBuilder();
        this.f1697u = sb2;
        this.f1698v = new Formatter(sb2, Locale.getDefault());
        this.f1699w = new Runnable() { // from class: b1.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f639a.t(false);
            }
        };
        Drawable drawable2 = this.f1687k;
        if (drawable2 != null) {
            this.f1695s = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.f1695s = (Math.max(this.f1693q, Math.max(this.f1692p, this.f1694r)) + 1) / 2;
        }
        this.F = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.E = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: b1.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                DefaultTimeBar.b(this.f640a, valueAnimator2);
            }
        });
        this.J = -9223372036854775807L;
        this.B = -9223372036854775807L;
        this.A = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }
}
