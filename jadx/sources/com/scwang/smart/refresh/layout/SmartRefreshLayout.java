package com.scwang.smart.refresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.scwang.smart.refresh.layout.kernel.R$id;
import com.scwang.smart.refresh.layout.kernel.R$string;
import com.scwang.smart.refresh.layout.kernel.R$styleable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@SuppressLint({"RestrictedApi"})
public class SmartRefreshLayout extends ViewGroup implements e6.f, NestedScrollingParent {

    /* JADX INFO: renamed from: n2, reason: collision with root package name */
    protected static ViewGroup.MarginLayoutParams f8248n2 = new ViewGroup.MarginLayoutParams(-1, -1);
    protected int[] A;
    protected boolean B;
    protected boolean C;
    protected boolean D;
    protected g6.f D1;
    protected boolean E;
    protected int E1;
    protected boolean F;
    protected boolean F1;
    protected boolean G;
    protected int[] G1;
    protected boolean H;
    protected NestedScrollingChildHelper H1;
    protected boolean I;
    protected NestedScrollingParentHelper I1;
    protected boolean J;
    protected int J1;
    protected boolean K;
    protected f6.a K1;
    protected boolean L;
    protected int L1;
    protected boolean M;
    protected f6.a M1;
    protected boolean N;
    protected int N1;
    protected boolean O;
    protected int O1;
    protected boolean P;
    protected float P1;
    protected boolean Q;
    protected float Q1;
    protected boolean R;
    protected float R1;
    protected boolean S;
    protected float S1;
    protected boolean T;
    protected float T1;
    protected boolean U;
    protected e6.a U1;
    protected boolean V;
    protected e6.a V1;
    protected boolean W;
    protected e6.b W1;
    protected Paint X1;
    protected Handler Y1;
    protected e6.e Z1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f8249a;

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    protected f6.b f8250a2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f8251b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    protected boolean f8252b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    protected f6.b f8253b2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f8254c;

    /* JADX INFO: renamed from: c2, reason: collision with root package name */
    protected long f8255c2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f8256d;

    /* JADX INFO: renamed from: d2, reason: collision with root package name */
    protected int f8257d2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f8258e;

    /* JADX INFO: renamed from: e2, reason: collision with root package name */
    protected int f8259e2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f8260f;

    /* JADX INFO: renamed from: f2, reason: collision with root package name */
    protected boolean f8261f2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f8262g;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    protected boolean f8263g2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected float f8264h;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    protected boolean f8265h2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected float f8266i;

    /* JADX INFO: renamed from: i2, reason: collision with root package name */
    protected boolean f8267i2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected float f8268j;

    /* JADX INFO: renamed from: j2, reason: collision with root package name */
    protected boolean f8269j2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected float f8270k;

    /* JADX INFO: renamed from: k2, reason: collision with root package name */
    protected MotionEvent f8271k2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected float f8272l;

    /* JADX INFO: renamed from: l2, reason: collision with root package name */
    protected Runnable f8273l2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected char f8274m;

    /* JADX INFO: renamed from: m2, reason: collision with root package name */
    protected ValueAnimator f8275m2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected boolean f8276n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected boolean f8277o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected boolean f8278p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected int f8279q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected int f8280r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected int f8281s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected int f8282t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected int f8283u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected int f8284v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected int f8285w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected Scroller f8286x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected VelocityTracker f8287y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected Interpolator f8288z;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f8290a;

        b(boolean z10) {
            this.f8290a = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == null || animator.getDuration() != 0) {
                SmartRefreshLayout.this.setStateDirectLoading(this.f8290a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f8292a;

        c(boolean z10) {
            this.f8292a = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == null || animator.getDuration() != 0) {
                SmartRefreshLayout.this.f8255c2 = System.currentTimeMillis();
                SmartRefreshLayout.this.t(f6.b.Refreshing);
                SmartRefreshLayout.this.getClass();
                SmartRefreshLayout.this.getClass();
                SmartRefreshLayout.this.m(3000);
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                e6.a aVar = smartRefreshLayout.U1;
                if (aVar != null) {
                    float f10 = smartRefreshLayout.P1;
                    if (f10 < 10.0f) {
                        f10 *= smartRefreshLayout.J1;
                    }
                    aVar.g(smartRefreshLayout, smartRefreshLayout.J1, (int) f10);
                }
                SmartRefreshLayout.this.getClass();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f6.b bVar;
            f6.b bVar2;
            if (animator == null || animator.getDuration() != 0) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.f8275m2 = null;
                if (smartRefreshLayout.f8251b == 0 && (bVar = smartRefreshLayout.f8250a2) != (bVar2 = f6.b.None) && !bVar.isOpening && !bVar.isDragging) {
                    smartRefreshLayout.t(bVar2);
                    return;
                }
                f6.b bVar3 = smartRefreshLayout.f8250a2;
                if (bVar3 != smartRefreshLayout.f8253b2) {
                    smartRefreshLayout.setViceState(bVar3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmartRefreshLayout.this.Z1.f(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout.this.getClass();
            SmartRefreshLayout.this.getClass();
            SmartRefreshLayout.this.j(2000);
            SmartRefreshLayout.this.getClass();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f8297a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8298b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Boolean f8299c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f8300d;

        g(int i10, Boolean bool, boolean z10) {
            this.f8298b = i10;
            this.f8299c = bool;
            this.f8300d = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = this.f8297a;
            if (i10 == 0) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                f6.b bVar = smartRefreshLayout.f8250a2;
                f6.b bVar2 = f6.b.None;
                if (bVar == bVar2 && smartRefreshLayout.f8253b2 == f6.b.Refreshing) {
                    smartRefreshLayout.f8253b2 = bVar2;
                } else {
                    ValueAnimator valueAnimator = smartRefreshLayout.f8275m2;
                    if (valueAnimator != null && bVar.isHeader && (bVar.isDragging || bVar == f6.b.RefreshReleased)) {
                        valueAnimator.setDuration(0L);
                        SmartRefreshLayout.this.f8275m2.cancel();
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        smartRefreshLayout2.f8275m2 = null;
                        if (smartRefreshLayout2.Z1.d(0) == null) {
                            SmartRefreshLayout.this.t(bVar2);
                        } else {
                            SmartRefreshLayout.this.t(f6.b.PullDownCanceled);
                        }
                    } else if (bVar == f6.b.Refreshing && smartRefreshLayout.U1 != null && smartRefreshLayout.W1 != null) {
                        this.f8297a = i10 + 1;
                        smartRefreshLayout.Y1.postDelayed(this, this.f8298b);
                        SmartRefreshLayout.this.t(f6.b.RefreshFinish);
                        if (this.f8299c == Boolean.FALSE) {
                            SmartRefreshLayout.this.v(false);
                        }
                    }
                }
                if (this.f8299c == Boolean.TRUE) {
                    SmartRefreshLayout.this.v(true);
                    return;
                }
                return;
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            int iD = smartRefreshLayout3.U1.d(smartRefreshLayout3, this.f8300d);
            SmartRefreshLayout.this.getClass();
            if (iD < Integer.MAX_VALUE) {
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                if (smartRefreshLayout4.f8276n || smartRefreshLayout4.F1) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (smartRefreshLayout5.f8276n) {
                        float f10 = smartRefreshLayout5.f8270k;
                        smartRefreshLayout5.f8266i = f10;
                        smartRefreshLayout5.f8256d = 0;
                        smartRefreshLayout5.f8276n = false;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, smartRefreshLayout5.f8268j, (f10 + smartRefreshLayout5.f8251b) - (smartRefreshLayout5.f8249a * 2), 0));
                        SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 2, smartRefreshLayout6.f8268j, smartRefreshLayout6.f8270k + smartRefreshLayout6.f8251b, 0));
                    }
                    SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                    if (smartRefreshLayout7.F1) {
                        smartRefreshLayout7.E1 = 0;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 1, smartRefreshLayout7.f8268j, smartRefreshLayout7.f8270k, 0));
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        smartRefreshLayout8.F1 = false;
                        smartRefreshLayout8.f8256d = 0;
                    }
                }
                SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                int i11 = smartRefreshLayout9.f8251b;
                if (i11 <= 0) {
                    if (i11 < 0) {
                        smartRefreshLayout9.h(0, iD, smartRefreshLayout9.f8288z, smartRefreshLayout9.f8260f);
                        return;
                    } else {
                        smartRefreshLayout9.Z1.f(0, false);
                        SmartRefreshLayout.this.Z1.b(f6.b.None);
                        return;
                    }
                }
                ValueAnimator valueAnimatorH = smartRefreshLayout9.h(0, iD, smartRefreshLayout9.f8288z, smartRefreshLayout9.f8260f);
                SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                ValueAnimator.AnimatorUpdateListener animatorUpdateListenerF = smartRefreshLayout10.O ? smartRefreshLayout10.W1.f(smartRefreshLayout10.f8251b) : null;
                if (valueAnimatorH == null || animatorUpdateListenerF == null) {
                    return;
                }
                valueAnimatorH.addUpdateListener(animatorUpdateListenerF);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f8302a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f8304c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f8305d;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f8307a;

            /* JADX INFO: renamed from: com.scwang.smart.refresh.layout.SmartRefreshLayout$h$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            class C0148a extends AnimatorListenerAdapter {
                C0148a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (animator == null || animator.getDuration() != 0) {
                        h hVar = h.this;
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        smartRefreshLayout.f8267i2 = false;
                        if (hVar.f8304c) {
                            smartRefreshLayout.v(true);
                        }
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        if (smartRefreshLayout2.f8250a2 == f6.b.LoadFinish) {
                            smartRefreshLayout2.t(f6.b.None);
                        }
                    }
                }
            }

            a(int i10) {
                this.f8307a = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                ValueAnimator.AnimatorUpdateListener animatorUpdateListenerF;
                ValueAnimator valueAnimatorD;
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (!smartRefreshLayout.N || this.f8307a >= 0) {
                    animatorUpdateListenerF = null;
                } else {
                    animatorUpdateListenerF = smartRefreshLayout.W1.f(smartRefreshLayout.f8251b);
                    if (animatorUpdateListenerF != null) {
                        animatorUpdateListenerF.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                    }
                }
                C0148a c0148a = new C0148a();
                h hVar = h.this;
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                int i10 = smartRefreshLayout2.f8251b;
                if (i10 > 0) {
                    valueAnimatorD = smartRefreshLayout2.Z1.d(0);
                } else {
                    if (animatorUpdateListenerF != null || i10 == 0) {
                        ValueAnimator valueAnimator = smartRefreshLayout2.f8275m2;
                        if (valueAnimator != null) {
                            valueAnimator.setDuration(0L);
                            SmartRefreshLayout.this.f8275m2.cancel();
                            SmartRefreshLayout.this.f8275m2 = null;
                        }
                        SmartRefreshLayout.this.Z1.f(0, false);
                        SmartRefreshLayout.this.Z1.b(f6.b.None);
                    } else if (hVar.f8304c && smartRefreshLayout2.H) {
                        int i11 = smartRefreshLayout2.L1;
                        if (i10 >= (-i11)) {
                            smartRefreshLayout2.t(f6.b.None);
                        } else {
                            valueAnimatorD = smartRefreshLayout2.Z1.d(-i11);
                        }
                    } else {
                        valueAnimatorD = smartRefreshLayout2.Z1.d(0);
                    }
                    valueAnimatorD = null;
                }
                if (valueAnimatorD != null) {
                    valueAnimatorD.addListener(c0148a);
                } else {
                    c0148a.onAnimationEnd(null);
                }
            }
        }

        h(int i10, boolean z10, boolean z11) {
            this.f8303b = i10;
            this.f8304c = z10;
            this.f8305d = z11;
        }

        /* JADX WARN: Code duplicated, block: B:44:0x00a4  */
        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            int i10 = this.f8302a;
            if (i10 == 0) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                f6.b bVar = smartRefreshLayout.f8250a2;
                f6.b bVar2 = f6.b.None;
                if (bVar == bVar2 && smartRefreshLayout.f8253b2 == f6.b.Loading) {
                    smartRefreshLayout.f8253b2 = bVar2;
                } else {
                    ValueAnimator valueAnimator = smartRefreshLayout.f8275m2;
                    if (valueAnimator != null && ((bVar.isDragging || bVar == f6.b.LoadReleased) && bVar.isFooter)) {
                        valueAnimator.setDuration(0L);
                        SmartRefreshLayout.this.f8275m2.cancel();
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        smartRefreshLayout2.f8275m2 = null;
                        if (smartRefreshLayout2.Z1.d(0) == null) {
                            SmartRefreshLayout.this.t(bVar2);
                        } else {
                            SmartRefreshLayout.this.t(f6.b.PullUpCanceled);
                        }
                    } else if (bVar == f6.b.Loading && smartRefreshLayout.V1 != null && smartRefreshLayout.W1 != null) {
                        this.f8302a = i10 + 1;
                        smartRefreshLayout.Y1.postDelayed(this, this.f8303b);
                        SmartRefreshLayout.this.t(f6.b.LoadFinish);
                        return;
                    }
                }
                if (this.f8304c) {
                    SmartRefreshLayout.this.v(true);
                    return;
                }
                return;
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            int iD = smartRefreshLayout3.V1.d(smartRefreshLayout3, this.f8305d);
            SmartRefreshLayout.this.getClass();
            if (iD < Integer.MAX_VALUE) {
                if (this.f8304c) {
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    z10 = smartRefreshLayout4.H && smartRefreshLayout4.f8251b < 0 && smartRefreshLayout4.W1.h();
                }
                SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                int i11 = smartRefreshLayout5.f8251b;
                int iMax = i11 - (z10 ? Math.max(i11, -smartRefreshLayout5.L1) : 0);
                SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                if (smartRefreshLayout6.f8276n || smartRefreshLayout6.F1) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                    if (smartRefreshLayout7.f8276n) {
                        float f10 = smartRefreshLayout7.f8270k;
                        smartRefreshLayout7.f8266i = f10;
                        smartRefreshLayout7.f8256d = smartRefreshLayout7.f8251b - iMax;
                        smartRefreshLayout7.f8276n = false;
                        float f11 = smartRefreshLayout7.G ? iMax : 0;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, smartRefreshLayout7.f8268j, f10 + f11 + (smartRefreshLayout7.f8249a * 2), 0));
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 2, smartRefreshLayout8.f8268j, smartRefreshLayout8.f8270k + f11, 0));
                    }
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    if (smartRefreshLayout9.F1) {
                        smartRefreshLayout9.E1 = 0;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 1, smartRefreshLayout9.f8268j, smartRefreshLayout9.f8270k, 0));
                        SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                        smartRefreshLayout10.F1 = false;
                        smartRefreshLayout10.f8256d = 0;
                    }
                }
                SmartRefreshLayout.this.Y1.postDelayed(new a(iMax), SmartRefreshLayout.this.f8251b < 0 ? iD : 0L);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    protected class i implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f8312c;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        float f8315f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f8310a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f8311b = 10;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f8314e = 0.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f8313d = AnimationUtils.currentAnimationTimeMillis();

        i(float f10, int i10) {
            this.f8315f = f10;
            this.f8312c = i10;
            SmartRefreshLayout.this.Y1.postDelayed(this, this.f8311b);
            if (f10 > 0.0f) {
                SmartRefreshLayout.this.Z1.b(f6.b.PullDownToRefresh);
            } else {
                SmartRefreshLayout.this.Z1.b(f6.b.PullUpToLoad);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f8273l2 != this || smartRefreshLayout.f8250a2.isFinishing) {
                return;
            }
            if (Math.abs(smartRefreshLayout.f8251b) < Math.abs(this.f8312c)) {
                double d10 = this.f8315f;
                int i10 = this.f8310a + 1;
                this.f8310a = i10;
                this.f8315f = (float) (d10 * Math.pow(0.949999988079071d, i10 * 2));
            } else if (this.f8312c != 0) {
                double d11 = this.f8315f;
                int i11 = this.f8310a + 1;
                this.f8310a = i11;
                this.f8315f = (float) (d11 * Math.pow(0.44999998807907104d, i11 * 2));
            } else {
                double d12 = this.f8315f;
                int i12 = this.f8310a + 1;
                this.f8310a = i12;
                this.f8315f = (float) (d12 * Math.pow(0.8500000238418579d, i12 * 2));
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f10 = this.f8315f * (((jCurrentAnimationTimeMillis - this.f8313d) * 1.0f) / 1000.0f);
            if (Math.abs(f10) >= 1.0f) {
                this.f8313d = jCurrentAnimationTimeMillis;
                float f11 = this.f8314e + f10;
                this.f8314e = f11;
                SmartRefreshLayout.this.s(f11);
                SmartRefreshLayout.this.Y1.postDelayed(this, this.f8311b);
                return;
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            f6.b bVar = smartRefreshLayout2.f8253b2;
            boolean z10 = bVar.isDragging;
            if (z10 && bVar.isHeader) {
                smartRefreshLayout2.Z1.b(f6.b.PullDownCanceled);
            } else if (z10 && bVar.isFooter) {
                smartRefreshLayout2.Z1.b(f6.b.PullUpCanceled);
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            smartRefreshLayout3.f8273l2 = null;
            if (Math.abs(smartRefreshLayout3.f8251b) >= Math.abs(this.f8312c)) {
                int iMin = Math.min(Math.max((int) i6.b.i(Math.abs(SmartRefreshLayout.this.f8251b - this.f8312c)), 30), 100) * 10;
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                smartRefreshLayout4.h(this.f8312c, 0, smartRefreshLayout4.f8288z, iMin);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    protected class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f8317a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f8320d;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f8318b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f8319c = 10;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f8321e = 0.98f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f8322f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f8323g = AnimationUtils.currentAnimationTimeMillis();

        j(float f10) {
            this.f8320d = f10;
            this.f8317a = SmartRefreshLayout.this.f8251b;
        }

        /* JADX WARN: Code duplicated, block: B:29:0x004b  */
        /* JADX WARN: Code duplicated, block: B:33:0x0059  */
        /* JADX WARN: Code duplicated, block: B:36:0x0065  */
        /* JADX WARN: Code duplicated, block: B:40:0x0097  */
        /* JADX WARN: Code duplicated, block: B:48:0x00a7 A[LOOP:0: B:34:0x0061->B:48:0x00a7, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:52:0x008f A[SYNTHETIC] */
        public Runnable a() {
            SmartRefreshLayout smartRefreshLayout;
            int i10;
            float fPow;
            int i11;
            int i12;
            float f10;
            f6.b bVar;
            f6.b bVar2;
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            f6.b bVar3 = smartRefreshLayout2.f8250a2;
            if (bVar3.isFinishing) {
                return null;
            }
            if (smartRefreshLayout2.f8251b != 0) {
                if (bVar3.isOpening || (smartRefreshLayout2.T && smartRefreshLayout2.H && smartRefreshLayout2.U && smartRefreshLayout2.q(smartRefreshLayout2.C))) {
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.f8250a2 == f6.b.Loading || (smartRefreshLayout3.T && smartRefreshLayout3.H && smartRefreshLayout3.U && smartRefreshLayout3.q(smartRefreshLayout3.C))) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        if (smartRefreshLayout4.f8251b >= (-smartRefreshLayout4.L1)) {
                            smartRefreshLayout = SmartRefreshLayout.this;
                            if (smartRefreshLayout.f8250a2 == f6.b.Refreshing && smartRefreshLayout.f8251b > smartRefreshLayout.J1) {
                                i10 = SmartRefreshLayout.this.f8251b;
                                fPow = this.f8320d;
                                i11 = 0;
                                i12 = i10;
                                while (i10 * i12 > 0) {
                                    i11++;
                                    fPow = (float) (((double) fPow) * Math.pow(this.f8321e, (this.f8319c * i11) / 10.0f));
                                    f10 = ((this.f8319c * 1.0f) / 1000.0f) * fPow;
                                    if (Math.abs(f10) < 1.0f) {
                                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                                        bVar = smartRefreshLayout5.f8250a2;
                                        if (!bVar.isOpening && ((bVar != (bVar2 = f6.b.Refreshing) || i12 <= smartRefreshLayout5.J1) && (bVar == bVar2 || i12 >= (-smartRefreshLayout5.L1)))) {
                                            break;
                                            break;
                                        }
                                        return null;
                                    }
                                    i12 = (int) (i12 + f10);
                                }
                            }
                        } else {
                            i10 = SmartRefreshLayout.this.f8251b;
                            fPow = this.f8320d;
                            i11 = 0;
                            i12 = i10;
                            while (i10 * i12 > 0) {
                                i11++;
                                fPow = (float) (((double) fPow) * Math.pow(this.f8321e, (this.f8319c * i11) / 10.0f));
                                f10 = ((this.f8319c * 1.0f) / 1000.0f) * fPow;
                                if (Math.abs(f10) < 1.0f) {
                                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                                    bVar = smartRefreshLayout6.f8250a2;
                                    if (!bVar.isOpening) {
                                    }
                                    return null;
                                }
                                i12 = (int) (i12 + f10);
                            }
                        }
                    } else {
                        smartRefreshLayout = SmartRefreshLayout.this;
                        if (smartRefreshLayout.f8250a2 == f6.b.Refreshing) {
                            i10 = SmartRefreshLayout.this.f8251b;
                            fPow = this.f8320d;
                            i11 = 0;
                            i12 = i10;
                            while (i10 * i12 > 0) {
                                i11++;
                                fPow = (float) (((double) fPow) * Math.pow(this.f8321e, (this.f8319c * i11) / 10.0f));
                                f10 = ((this.f8319c * 1.0f) / 1000.0f) * fPow;
                                if (Math.abs(f10) < 1.0f) {
                                    SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                                    bVar = smartRefreshLayout7.f8250a2;
                                    if (!bVar.isOpening) {
                                    }
                                    return null;
                                }
                                i12 = (int) (i12 + f10);
                            }
                        }
                    }
                } else {
                    i10 = SmartRefreshLayout.this.f8251b;
                    fPow = this.f8320d;
                    i11 = 0;
                    i12 = i10;
                    while (i10 * i12 > 0) {
                        i11++;
                        fPow = (float) (((double) fPow) * Math.pow(this.f8321e, (this.f8319c * i11) / 10.0f));
                        f10 = ((this.f8319c * 1.0f) / 1000.0f) * fPow;
                        if (Math.abs(f10) < 1.0f) {
                            SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                            bVar = smartRefreshLayout8.f8250a2;
                            if (!bVar.isOpening) {
                            }
                            return null;
                        }
                        i12 = (int) (i12 + f10);
                    }
                }
            }
            this.f8322f = AnimationUtils.currentAnimationTimeMillis();
            SmartRefreshLayout.this.Y1.postDelayed(this, this.f8319c);
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f8273l2 != this || smartRefreshLayout.f8250a2.isFinishing) {
                return;
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            long j10 = jCurrentAnimationTimeMillis - this.f8323g;
            float fPow = (float) (((double) this.f8320d) * Math.pow(this.f8321e, (jCurrentAnimationTimeMillis - this.f8322f) / (1000.0f / this.f8319c)));
            this.f8320d = fPow;
            float f10 = fPow * ((j10 * 1.0f) / 1000.0f);
            if (Math.abs(f10) <= 1.0f) {
                SmartRefreshLayout.this.f8273l2 = null;
                return;
            }
            this.f8323g = jCurrentAnimationTimeMillis;
            int i10 = (int) (this.f8317a + f10);
            this.f8317a = i10;
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            if (smartRefreshLayout2.f8251b * i10 > 0) {
                smartRefreshLayout2.Z1.f(i10, true);
                SmartRefreshLayout.this.Y1.postDelayed(this, this.f8319c);
                return;
            }
            smartRefreshLayout2.f8273l2 = null;
            smartRefreshLayout2.Z1.f(0, true);
            i6.b.d(SmartRefreshLayout.this.W1.j(), (int) (-this.f8320d));
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            if (!smartRefreshLayout3.f8267i2 || f10 <= 0.0f) {
                return;
            }
            smartRefreshLayout3.f8267i2 = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public class l implements e6.e {
        public l() {
        }

        @Override // e6.e
        public e6.e a(@NonNull e6.a aVar, int i10) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.X1 == null && i10 != 0) {
                smartRefreshLayout.X1 = new Paint();
            }
            if (aVar.equals(SmartRefreshLayout.this.U1)) {
                SmartRefreshLayout.this.f8257d2 = i10;
                return this;
            }
            if (aVar.equals(SmartRefreshLayout.this.V1)) {
                SmartRefreshLayout.this.f8259e2 = i10;
            }
            return this;
        }

        @Override // e6.e
        public e6.e b(@NonNull f6.b bVar) {
            switch (a.f8289a[bVar.ordinal()]) {
                case 1:
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    f6.b bVar2 = smartRefreshLayout.f8250a2;
                    f6.b bVar3 = f6.b.None;
                    if (bVar2 != bVar3 && smartRefreshLayout.f8251b == 0) {
                        smartRefreshLayout.t(bVar3);
                    } else if (smartRefreshLayout.f8251b != 0) {
                        d(0);
                    }
                    break;
                case 2:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout2.f8250a2.isOpening && smartRefreshLayout2.q(smartRefreshLayout2.B)) {
                        SmartRefreshLayout.this.t(f6.b.PullDownToRefresh);
                    } else {
                        SmartRefreshLayout.this.setViceState(f6.b.PullDownToRefresh);
                    }
                    break;
                case 3:
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.q(smartRefreshLayout3.C)) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        f6.b bVar4 = smartRefreshLayout4.f8250a2;
                        if (!bVar4.isOpening && !bVar4.isFinishing && (!smartRefreshLayout4.T || !smartRefreshLayout4.H || !smartRefreshLayout4.U)) {
                            smartRefreshLayout4.t(f6.b.PullUpToLoad);
                        }
                    }
                    SmartRefreshLayout.this.setViceState(f6.b.PullUpToLoad);
                    break;
                case 4:
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout5.f8250a2.isOpening && smartRefreshLayout5.q(smartRefreshLayout5.B)) {
                        SmartRefreshLayout.this.t(f6.b.PullDownCanceled);
                        b(f6.b.None);
                    } else {
                        SmartRefreshLayout.this.setViceState(f6.b.PullDownCanceled);
                    }
                    break;
                case 5:
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.q(smartRefreshLayout6.C)) {
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (!smartRefreshLayout7.f8250a2.isOpening && (!smartRefreshLayout7.T || !smartRefreshLayout7.H || !smartRefreshLayout7.U)) {
                            smartRefreshLayout7.t(f6.b.PullUpCanceled);
                            b(f6.b.None);
                        }
                    }
                    SmartRefreshLayout.this.setViceState(f6.b.PullUpCanceled);
                    break;
                case 6:
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout8.f8250a2.isOpening && smartRefreshLayout8.q(smartRefreshLayout8.B)) {
                        SmartRefreshLayout.this.t(f6.b.ReleaseToRefresh);
                    } else {
                        SmartRefreshLayout.this.setViceState(f6.b.ReleaseToRefresh);
                    }
                    break;
                case 7:
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    if (smartRefreshLayout9.q(smartRefreshLayout9.C)) {
                        SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                        f6.b bVar5 = smartRefreshLayout10.f8250a2;
                        if (!bVar5.isOpening && !bVar5.isFinishing && (!smartRefreshLayout10.T || !smartRefreshLayout10.H || !smartRefreshLayout10.U)) {
                            smartRefreshLayout10.t(f6.b.ReleaseToLoad);
                        }
                    }
                    SmartRefreshLayout.this.setViceState(f6.b.ReleaseToLoad);
                    break;
                case 8:
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout11.f8250a2.isOpening && smartRefreshLayout11.q(smartRefreshLayout11.B)) {
                        SmartRefreshLayout.this.t(f6.b.ReleaseToTwoLevel);
                    } else {
                        SmartRefreshLayout.this.setViceState(f6.b.ReleaseToTwoLevel);
                    }
                    break;
                case 9:
                    SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout12.f8250a2.isOpening && smartRefreshLayout12.q(smartRefreshLayout12.B)) {
                        SmartRefreshLayout.this.t(f6.b.RefreshReleased);
                    } else {
                        SmartRefreshLayout.this.setViceState(f6.b.RefreshReleased);
                    }
                    break;
                case 10:
                    SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout13.f8250a2.isOpening && smartRefreshLayout13.q(smartRefreshLayout13.C)) {
                        SmartRefreshLayout.this.t(f6.b.LoadReleased);
                    } else {
                        SmartRefreshLayout.this.setViceState(f6.b.LoadReleased);
                    }
                    break;
                case 11:
                    SmartRefreshLayout.this.setStateRefreshing(true);
                    break;
                case 12:
                    SmartRefreshLayout.this.setStateLoading(true);
                    break;
                default:
                    SmartRefreshLayout.this.t(bVar);
                    break;
            }
            return null;
        }

        @Override // e6.e
        public e6.e c() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f8250a2 == f6.b.TwoLevel) {
                smartRefreshLayout.Z1.b(f6.b.TwoLevelFinish);
                if (SmartRefreshLayout.this.f8251b == 0) {
                    f(0, false);
                    SmartRefreshLayout.this.t(f6.b.None);
                    return this;
                }
                d(0).setDuration(SmartRefreshLayout.this.f8258e);
            }
            return this;
        }

        @Override // e6.e
        public ValueAnimator d(int i10) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.h(i10, 0, smartRefreshLayout.f8288z, smartRefreshLayout.f8260f);
        }

        @Override // e6.e
        @NonNull
        public e6.f e() {
            return SmartRefreshLayout.this;
        }

        /* JADX WARN: Code duplicated, block: B:50:0x00a3  */
        @Override // e6.e
        public e6.e f(int i10, boolean z10) {
            float f10;
            float f11;
            int i11;
            boolean z11;
            e6.a aVar;
            e6.a aVar2;
            e6.a aVar3;
            e6.a aVar4;
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f8251b != i10 || (((aVar3 = smartRefreshLayout.U1) != null && aVar3.f()) || ((aVar4 = SmartRefreshLayout.this.V1) != null && aVar4.f()))) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                int i12 = smartRefreshLayout2.f8251b;
                smartRefreshLayout2.f8251b = i10;
                if (z10) {
                    f6.b bVar = smartRefreshLayout2.f8253b2;
                    if (bVar.isDragging || bVar.isOpening) {
                        float f12 = i10;
                        float f13 = smartRefreshLayout2.R1;
                        if (f13 < 10.0f) {
                            f13 *= smartRefreshLayout2.J1;
                        }
                        if (f12 <= f13) {
                            float f14 = -i10;
                            float f15 = smartRefreshLayout2.S1;
                            if (f15 < 10.0f) {
                                f15 *= smartRefreshLayout2.L1;
                            }
                            if (f14 > f15 && !smartRefreshLayout2.T) {
                                smartRefreshLayout2.Z1.b(f6.b.ReleaseToLoad);
                            } else if (i10 < 0 && !smartRefreshLayout2.T) {
                                smartRefreshLayout2.Z1.b(f6.b.PullUpToLoad);
                            } else if (i10 > 0) {
                                smartRefreshLayout2.Z1.b(f6.b.PullDownToRefresh);
                            }
                        } else if (smartRefreshLayout2.f8250a2 != f6.b.ReleaseToTwoLevel) {
                            smartRefreshLayout2.Z1.b(f6.b.ReleaseToRefresh);
                        }
                    }
                }
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                if (smartRefreshLayout3.W1 != null) {
                    if (i10 < 0) {
                        i11 = 0;
                        z11 = false;
                    } else {
                        if (smartRefreshLayout3.r(smartRefreshLayout3.F, smartRefreshLayout3.U1)) {
                            i11 = i10;
                        } else if (i12 < 0) {
                            i11 = 0;
                        } else {
                            i11 = 0;
                            z11 = false;
                        }
                        z11 = true;
                    }
                    if (i10 <= 0) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        if (smartRefreshLayout4.r(smartRefreshLayout4.G, smartRefreshLayout4.V1)) {
                            i11 = i10;
                        } else if (i12 > 0) {
                            i11 = 0;
                        }
                        z11 = true;
                    }
                    if (z11) {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        smartRefreshLayout5.W1.c(i11, smartRefreshLayout5.f8281s, smartRefreshLayout5.f8282t);
                        SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                        if (smartRefreshLayout6.T && smartRefreshLayout6.U && smartRefreshLayout6.H) {
                            e6.a aVar5 = smartRefreshLayout6.V1;
                            if ((aVar5 instanceof e6.c) && aVar5.getSpinnerStyle() == f6.c.f10060d) {
                                SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                                if (smartRefreshLayout7.q(smartRefreshLayout7.C)) {
                                    SmartRefreshLayout.this.V1.getView().setTranslationY(Math.max(0, i11));
                                }
                            }
                        }
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        boolean z12 = (smartRefreshLayout8.D && (aVar2 = smartRefreshLayout8.U1) != null && aVar2.getSpinnerStyle() == f6.c.f10062f) || SmartRefreshLayout.this.f8257d2 != 0;
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        boolean z13 = (smartRefreshLayout9.E && (aVar = smartRefreshLayout9.V1) != null && aVar.getSpinnerStyle() == f6.c.f10062f) || SmartRefreshLayout.this.f8259e2 != 0;
                        if ((z12 && (i11 >= 0 || i12 > 0)) || (z13 && (i11 <= 0 || i12 < 0))) {
                            smartRefreshLayout2.invalidate();
                        }
                    }
                }
                if ((i10 >= 0 || i12 > 0) && SmartRefreshLayout.this.U1 != null) {
                    int iMax = Math.max(i10, 0);
                    SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                    int i13 = smartRefreshLayout10.J1;
                    float f16 = smartRefreshLayout10.P1;
                    if (f16 < 10.0f) {
                        f16 *= i13;
                    }
                    int i14 = (int) f16;
                    float f17 = iMax * 1.0f;
                    float f18 = smartRefreshLayout10.R1;
                    if (f18 < 10.0f) {
                        f18 *= i13;
                    }
                    float f19 = f17 / f18;
                    if (smartRefreshLayout10.q(smartRefreshLayout10.B) || (SmartRefreshLayout.this.f8250a2 == f6.b.RefreshFinish && !z10)) {
                        SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                        if (i12 != smartRefreshLayout11.f8251b) {
                            if (smartRefreshLayout11.U1.getSpinnerStyle() == f6.c.f10060d) {
                                SmartRefreshLayout.this.U1.getView().setTranslationY(SmartRefreshLayout.this.f8251b);
                                SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                                if (smartRefreshLayout12.f8257d2 != 0 && smartRefreshLayout12.X1 != null && !smartRefreshLayout12.r(smartRefreshLayout12.F, smartRefreshLayout12.U1)) {
                                    smartRefreshLayout2.invalidate();
                                }
                            } else {
                                if (SmartRefreshLayout.this.U1.getSpinnerStyle().f10068c) {
                                    View view = SmartRefreshLayout.this.U1.getView();
                                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : SmartRefreshLayout.f8248n2;
                                    f10 = 10.0f;
                                    f11 = 1.0f;
                                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(Math.max((SmartRefreshLayout.this.f8251b - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), BasicMeasure.EXACTLY));
                                    int i15 = marginLayoutParams.leftMargin;
                                    int i16 = marginLayoutParams.topMargin + SmartRefreshLayout.this.N1;
                                    view.layout(i15, i16, view.getMeasuredWidth() + i15, view.getMeasuredHeight() + i16);
                                }
                                SmartRefreshLayout.this.U1.i(z10, f19, iMax, i13, i14);
                            }
                            f10 = 10.0f;
                            f11 = 1.0f;
                            SmartRefreshLayout.this.U1.i(z10, f19, iMax, i13, i14);
                        } else {
                            f10 = 10.0f;
                            f11 = 1.0f;
                        }
                        if (z10 && SmartRefreshLayout.this.U1.f()) {
                            int i17 = (int) SmartRefreshLayout.this.f8268j;
                            int width = smartRefreshLayout2.getWidth();
                            SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                            smartRefreshLayout13.U1.c(smartRefreshLayout13.f8268j / (width == 0 ? 1 : width), i17, width);
                        }
                    } else {
                        f10 = 10.0f;
                        f11 = 1.0f;
                    }
                    SmartRefreshLayout smartRefreshLayout14 = SmartRefreshLayout.this;
                    if (i12 != smartRefreshLayout14.f8251b) {
                        smartRefreshLayout14.getClass();
                    }
                } else {
                    f10 = 10.0f;
                    f11 = 1.0f;
                }
                if ((i10 <= 0 || i12 < 0) && SmartRefreshLayout.this.V1 != null) {
                    int i18 = -Math.min(i10, 0);
                    SmartRefreshLayout smartRefreshLayout15 = SmartRefreshLayout.this;
                    int i19 = smartRefreshLayout15.L1;
                    float f20 = smartRefreshLayout15.Q1;
                    if (f20 < f10) {
                        f20 *= i19;
                    }
                    int i20 = (int) f20;
                    float f21 = i18 * f11;
                    float f22 = smartRefreshLayout15.S1;
                    if (f22 < f10) {
                        f22 *= i19;
                    }
                    float f23 = f21 / f22;
                    if (smartRefreshLayout15.q(smartRefreshLayout15.C) || (SmartRefreshLayout.this.f8250a2 == f6.b.LoadFinish && !z10)) {
                        SmartRefreshLayout smartRefreshLayout16 = SmartRefreshLayout.this;
                        if (i12 != smartRefreshLayout16.f8251b) {
                            if (smartRefreshLayout16.V1.getSpinnerStyle() == f6.c.f10060d) {
                                SmartRefreshLayout.this.V1.getView().setTranslationY(SmartRefreshLayout.this.f8251b);
                                SmartRefreshLayout smartRefreshLayout17 = SmartRefreshLayout.this;
                                if (smartRefreshLayout17.f8259e2 != 0 && smartRefreshLayout17.X1 != null && !smartRefreshLayout17.r(smartRefreshLayout17.G, smartRefreshLayout17.V1)) {
                                    smartRefreshLayout2.invalidate();
                                }
                            } else if (SmartRefreshLayout.this.V1.getSpinnerStyle().f10068c) {
                                View view2 = SmartRefreshLayout.this.V1.getView();
                                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                                ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : SmartRefreshLayout.f8248n2;
                                view2.measure(View.MeasureSpec.makeMeasureSpec(view2.getMeasuredWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(Math.max(((-SmartRefreshLayout.this.f8251b) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0), BasicMeasure.EXACTLY));
                                int i21 = marginLayoutParams2.leftMargin;
                                int measuredHeight = (marginLayoutParams2.topMargin + smartRefreshLayout2.getMeasuredHeight()) - SmartRefreshLayout.this.O1;
                                view2.layout(i21, measuredHeight - view2.getMeasuredHeight(), view2.getMeasuredWidth() + i21, measuredHeight);
                            }
                            SmartRefreshLayout.this.V1.i(z10, f23, i18, i19, i20);
                        }
                        if (z10 && SmartRefreshLayout.this.V1.f()) {
                            int i22 = (int) SmartRefreshLayout.this.f8268j;
                            int width2 = smartRefreshLayout2.getWidth();
                            SmartRefreshLayout smartRefreshLayout18 = SmartRefreshLayout.this;
                            smartRefreshLayout18.V1.c(smartRefreshLayout18.f8268j / (width2 != 0 ? width2 : 1), i22, width2);
                        }
                    }
                    SmartRefreshLayout smartRefreshLayout19 = SmartRefreshLayout.this;
                    if (i12 != smartRefreshLayout19.f8251b) {
                        smartRefreshLayout19.getClass();
                    }
                }
            }
            return this;
        }
    }

    public SmartRefreshLayout(Context context) {
        this(context, null);
    }

    public e6.f j(int i10) {
        return k(i10, true, false);
    }

    public e6.f m(int i10) {
        return n(i10, true, Boolean.FALSE);
    }

    protected boolean p(int i10) {
        if (i10 == 0) {
            if (this.f8275m2 != null) {
                f6.b bVar = this.f8250a2;
                if (bVar.isFinishing || bVar == f6.b.TwoLevelReleased || bVar == f6.b.RefreshReleased || bVar == f6.b.LoadReleased) {
                    return true;
                }
                if (bVar == f6.b.PullDownCanceled) {
                    this.Z1.b(f6.b.PullDownToRefresh);
                } else if (bVar == f6.b.PullUpCanceled) {
                    this.Z1.b(f6.b.PullUpToLoad);
                }
                this.f8275m2.setDuration(0L);
                this.f8275m2.cancel();
                this.f8275m2 = null;
            }
            this.f8273l2 = null;
        }
        return this.f8275m2 != null;
    }

    protected boolean w(float f10) {
        if (f10 == 0.0f) {
            f10 = this.f8285w;
        }
        if (Build.VERSION.SDK_INT > 27 && this.W1 != null) {
            getScaleY();
            View view = this.W1.getView();
            if (getScaleY() == -1.0f && view.getScaleY() == -1.0f) {
                f10 = -f10;
            }
        }
        if (Math.abs(f10) > this.f8283u) {
            int i10 = this.f8251b;
            if (i10 * f10 < 0.0f) {
                f6.b bVar = this.f8250a2;
                if (bVar == f6.b.Refreshing || bVar == f6.b.Loading || (i10 < 0 && this.T)) {
                    this.f8273l2 = new j(f10).a();
                    return true;
                }
                if (bVar.isReleaseToOpening) {
                    return true;
                }
            }
            if ((f10 < 0.0f && ((this.J && (this.C || this.K)) || ((this.f8250a2 == f6.b.Loading && i10 >= 0) || (this.L && q(this.C))))) || (f10 > 0.0f && ((this.J && this.B) || this.K || (this.f8250a2 == f6.b.Refreshing && this.f8251b <= 0)))) {
                this.f8269j2 = false;
                this.f8286x.fling(0, 0, 0, (int) (-f10), 0, 0, -2147483647, Integer.MAX_VALUE);
                this.f8286x.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8289a;

        static {
            int[] iArr = new int[f6.b.values().length];
            f8289a = iArr;
            try {
                iArr[f6.b.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8289a[f6.b.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8289a[f6.b.PullUpToLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8289a[f6.b.PullDownCanceled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8289a[f6.b.PullUpCanceled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8289a[f6.b.ReleaseToRefresh.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8289a[f6.b.ReleaseToLoad.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8289a[f6.b.ReleaseToTwoLevel.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8289a[f6.b.RefreshReleased.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8289a[f6.b.LoadReleased.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8289a[f6.b.Refreshing.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f8289a[f6.b.Loading.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8258e = 300;
        this.f8260f = 300;
        this.f8272l = 0.5f;
        this.f8274m = 'n';
        this.f8279q = -1;
        this.f8280r = -1;
        this.f8281s = -1;
        this.f8282t = -1;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = false;
        this.L = true;
        this.M = false;
        this.N = true;
        this.O = true;
        this.P = true;
        this.Q = true;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.f8252b1 = false;
        this.G1 = new int[2];
        this.H1 = new NestedScrollingChildHelper(this);
        this.I1 = new NestedScrollingParentHelper(this);
        f6.a aVar = f6.a.f10027c;
        this.K1 = aVar;
        this.M1 = aVar;
        this.P1 = 2.5f;
        this.Q1 = 2.5f;
        this.R1 = 1.0f;
        this.S1 = 1.0f;
        this.T1 = 0.16666667f;
        this.Z1 = new l();
        f6.b bVar = f6.b.None;
        this.f8250a2 = bVar;
        this.f8253b2 = bVar;
        this.f8255c2 = 0L;
        this.f8257d2 = 0;
        this.f8259e2 = 0;
        this.f8267i2 = false;
        this.f8269j2 = false;
        this.f8271k2 = null;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.Y1 = new Handler(Looper.getMainLooper());
        this.f8286x = new Scroller(context);
        this.f8287y = VelocityTracker.obtain();
        this.f8262g = context.getResources().getDisplayMetrics().heightPixels;
        this.f8288z = new i6.b(i6.b.f11231b);
        this.f8249a = viewConfiguration.getScaledTouchSlop();
        this.f8283u = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f8284v = viewConfiguration.getScaledMaximumFlingVelocity();
        this.L1 = i6.b.c(60.0f);
        this.J1 = i6.b.c(100.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SmartRefreshLayout);
        if (!typedArrayObtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_android_clipToPadding)) {
            super.setClipToPadding(false);
        }
        if (!typedArrayObtainStyledAttributes.hasValue(R$styleable.SmartRefreshLayout_android_clipChildren)) {
            super.setClipChildren(false);
        }
        this.f8272l = typedArrayObtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlDragRate, this.f8272l);
        this.P1 = typedArrayObtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.P1);
        this.Q1 = typedArrayObtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.Q1);
        this.R1 = typedArrayObtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.R1);
        this.S1 = typedArrayObtainStyledAttributes.getFloat(R$styleable.SmartRefreshLayout_srlFooterTriggerRate, this.S1);
        this.B = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableRefresh, this.B);
        this.f8260f = typedArrayObtainStyledAttributes.getInt(R$styleable.SmartRefreshLayout_srlReboundDuration, this.f8260f);
        int i10 = R$styleable.SmartRefreshLayout_srlEnableLoadMore;
        this.C = typedArrayObtainStyledAttributes.getBoolean(i10, this.C);
        int i11 = R$styleable.SmartRefreshLayout_srlHeaderHeight;
        this.J1 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i11, this.J1);
        int i12 = R$styleable.SmartRefreshLayout_srlFooterHeight;
        this.L1 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i12, this.L1);
        this.N1 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.SmartRefreshLayout_srlHeaderInsetStart, this.N1);
        this.O1 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.SmartRefreshLayout_srlFooterInsetStart, this.O1);
        this.R = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.R);
        this.S = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.S);
        int i13 = R$styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent;
        this.F = typedArrayObtainStyledAttributes.getBoolean(i13, this.F);
        int i14 = R$styleable.SmartRefreshLayout_srlEnableFooterTranslationContent;
        this.G = typedArrayObtainStyledAttributes.getBoolean(i14, this.G);
        this.I = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.I);
        this.L = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.L);
        this.J = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.J);
        this.M = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.M);
        this.N = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.N);
        this.O = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.O);
        this.P = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.P);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.H);
        this.H = z10;
        this.H = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, z10);
        this.D = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.D);
        this.E = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.E);
        this.K = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.K);
        this.f8279q = typedArrayObtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFixedHeaderViewId, this.f8279q);
        this.f8280r = typedArrayObtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFixedFooterViewId, this.f8280r);
        this.f8281s = typedArrayObtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlHeaderTranslationViewId, this.f8281s);
        this.f8282t = typedArrayObtainStyledAttributes.getResourceId(R$styleable.SmartRefreshLayout_srlFooterTranslationViewId, this.f8282t);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SmartRefreshLayout_srlEnableNestedScrolling, this.Q);
        this.Q = z11;
        this.H1.setNestedScrollingEnabled(z11);
        this.V = this.V || typedArrayObtainStyledAttributes.hasValue(i10);
        this.W = this.W || typedArrayObtainStyledAttributes.hasValue(i13);
        this.f8252b1 = this.f8252b1 || typedArrayObtainStyledAttributes.hasValue(i14);
        this.K1 = typedArrayObtainStyledAttributes.hasValue(i11) ? f6.a.f10033i : this.K1;
        this.M1 = typedArrayObtainStyledAttributes.hasValue(i12) ? f6.a.f10033i : this.M1;
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = typedArrayObtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.A = new int[]{color2, color};
            } else {
                this.A = new int[]{color2};
            }
        } else if (color != 0) {
            this.A = new int[]{0, color};
        }
        if (this.M && !this.V && !this.C) {
            this.C = true;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f8286x.getCurrY();
        if (this.f8286x.computeScrollOffset()) {
            int finalY = this.f8286x.getFinalY();
            if ((finalY >= 0 || !((this.B || this.K) && this.W1.a())) && (finalY <= 0 || !((this.C || this.K) && this.W1.h()))) {
                this.f8269j2 = true;
                invalidate();
            } else {
                if (this.f8269j2) {
                    i(finalY > 0 ? -this.f8286x.getCurrVelocity() : this.f8286x.getCurrVelocity());
                }
                this.f8286x.forceFinished(true);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x010c  */
    /* JADX WARN: Code duplicated, block: B:122:0x0163  */
    /* JADX WARN: Code duplicated, block: B:124:0x0169  */
    /* JADX WARN: Code duplicated, block: B:133:0x0187  */
    /* JADX WARN: Code duplicated, block: B:135:0x018b  */
    /* JADX WARN: Code duplicated, block: B:150:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:152:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:155:0x01c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:160:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:163:0x01de  */
    /* JADX WARN: Code duplicated, block: B:166:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:178:0x020b  */
    /* JADX WARN: Code duplicated, block: B:181:0x023a  */
    /* JADX WARN: Code duplicated, block: B:187:0x0249  */
    /* JADX WARN: Code duplicated, block: B:194:0x0267 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:195:0x0269  */
    /* JADX WARN: Code duplicated, block: B:202:0x0287  */
    /* JADX WARN: Code duplicated, block: B:205:0x028e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:206:0x0290  */
    /* JADX WARN: Code duplicated, block: B:211:0x029a  */
    /* JADX WARN: Code duplicated, block: B:215:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:219:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:226:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:229:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:232:0x030b  */
    /* JADX WARN: Code duplicated, block: B:236:0x0313  */
    /* JADX WARN: Code duplicated, block: B:244:0x0354  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:76:0x00da  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:94:0x0102  */
    /* JADX WARN: Code duplicated, block: B:96:0x0105  */
    /* JADX WARN: Code duplicated, block: B:98:0x0108 A[DONT_INVERT] */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00dc, code lost:
    
        if (r2.isFooter != false) goto L247;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        f6.b bVar;
        f6.b bVar2;
        e6.b bVar3;
        MotionEvent motionEvent2;
        float f10;
        float f11;
        int i10;
        f6.b bVar4;
        long eventTime;
        MotionEvent motionEventObtain;
        f6.b bVar5;
        char c10;
        int i11;
        f6.b bVar6;
        ViewParent parent;
        f6.b bVar7;
        e6.a aVar;
        e6.a aVar2;
        int actionMasked = motionEvent.getActionMasked();
        int i12 = 0;
        boolean z10 = actionMasked == 6;
        int actionIndex = z10 ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float x10 = 0.0f;
        float y10 = 0.0f;
        for (int i13 = 0; i13 < pointerCount; i13++) {
            if (actionIndex != i13) {
                x10 += motionEvent.getX(i13);
                y10 += motionEvent.getY(i13);
            }
        }
        if (z10) {
            pointerCount--;
        }
        float f12 = pointerCount;
        float f13 = x10 / f12;
        float f14 = y10 / f12;
        if ((actionMasked == 6 || actionMasked == 5) && this.f8276n) {
            this.f8266i += f14 - this.f8270k;
        }
        this.f8268j = f13;
        this.f8270k = f14;
        if (this.F1) {
            int i14 = this.E1;
            boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (actionMasked == 2 && i14 == this.E1) {
                int i15 = (int) this.f8268j;
                int width = getWidth();
                float f15 = this.f8268j / (width != 0 ? width : 1);
                if (q(this.B) && this.f8251b > 0 && (aVar2 = this.U1) != null && aVar2.f()) {
                    this.U1.c(f15, i15, width);
                    return zDispatchTouchEvent;
                }
                if (q(this.C) && this.f8251b < 0 && (aVar = this.V1) != null && aVar.f()) {
                    this.V1.c(f15, i15, width);
                }
            }
            return zDispatchTouchEvent;
        }
        if (isEnabled() && (this.B || this.C || this.K)) {
            if (!this.f8261f2) {
                if (this.f8263g2) {
                    bVar7 = this.f8250a2;
                    if (bVar7.isOpening) {
                        if (bVar7.isFinishing) {
                        }
                    }
                }
                if (!p(actionMasked)) {
                    bVar = this.f8250a2;
                    if (!bVar.isFinishing) {
                        if (actionMasked != 0) {
                            this.f8285w = 0;
                            this.f8287y.addMovement(motionEvent);
                            this.f8286x.forceFinished(true);
                            this.f8264h = f13;
                            this.f8266i = f14;
                            this.f8254c = 0;
                            this.f8256d = this.f8251b;
                            this.f8276n = false;
                            this.f8278p = false;
                            this.f8277o = super.dispatchTouchEvent(motionEvent);
                            if (this.f8250a2 != f6.b.TwoLevel) {
                            }
                            bVar3 = this.W1;
                            if (bVar3 != null) {
                                bVar3.b(motionEvent);
                            }
                            return true;
                        }
                        if (actionMasked != 1) {
                            if (actionMasked != 2) {
                                f10 = f13 - this.f8264h;
                                f11 = f14 - this.f8266i;
                                this.f8287y.addMovement(motionEvent);
                                if (!this.f8276n) {
                                    if (c10 != 'v') {
                                        this.f8274m = 'v';
                                        if (f11 <= 0.0f) {
                                            if (f11 < 0.0f) {
                                                this.f8276n = true;
                                                this.f8266i = this.f8249a + f14;
                                            }
                                        } else if (f11 < 0.0f) {
                                            this.f8276n = true;
                                            this.f8266i = this.f8249a + f14;
                                        }
                                        if (this.f8276n) {
                                            f11 = f14 - this.f8266i;
                                            if (this.f8277o) {
                                                motionEvent.setAction(3);
                                                super.dispatchTouchEvent(motionEvent);
                                            }
                                            e6.e eVar = this.Z1;
                                            i11 = this.f8251b;
                                            if (i11 <= 0) {
                                                bVar6 = f6.b.PullDownToRefresh;
                                            } else {
                                                bVar6 = f6.b.PullDownToRefresh;
                                            }
                                            eVar.b(bVar6);
                                            parent = getParent();
                                            if (parent instanceof ViewGroup) {
                                                ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                                            }
                                        }
                                    } else {
                                        this.f8274m = 'v';
                                        if (f11 <= 0.0f) {
                                            if (f11 < 0.0f) {
                                                this.f8276n = true;
                                                this.f8266i = this.f8249a + f14;
                                            }
                                        } else if (f11 < 0.0f) {
                                            this.f8276n = true;
                                            this.f8266i = this.f8249a + f14;
                                        }
                                        if (this.f8276n) {
                                            f11 = f14 - this.f8266i;
                                            if (this.f8277o) {
                                                motionEvent.setAction(3);
                                                super.dispatchTouchEvent(motionEvent);
                                            }
                                            e6.e eVar2 = this.Z1;
                                            i11 = this.f8251b;
                                            if (i11 <= 0) {
                                                bVar6 = f6.b.PullDownToRefresh;
                                            } else {
                                                bVar6 = f6.b.PullDownToRefresh;
                                            }
                                            eVar2.b(bVar6);
                                            parent = getParent();
                                            if (parent instanceof ViewGroup) {
                                                ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                                            }
                                        }
                                    }
                                }
                                if (this.f8276n) {
                                    i10 = ((int) f11) + this.f8256d;
                                    bVar4 = this.f8253b2;
                                    if (bVar4.isHeader) {
                                        this.f8254c = i10;
                                        eventTime = motionEvent.getEventTime();
                                        if (this.f8271k2 == null) {
                                            MotionEvent motionEventObtain2 = MotionEvent.obtain(eventTime, eventTime, 0, this.f8264h + f10, this.f8266i, 0);
                                            this.f8271k2 = motionEventObtain2;
                                            super.dispatchTouchEvent(motionEventObtain2);
                                        }
                                        motionEventObtain = MotionEvent.obtain(eventTime, eventTime, 2, this.f8264h + f10, this.f8266i + i10, 0);
                                        super.dispatchTouchEvent(motionEventObtain);
                                        if (this.f8267i2) {
                                            this.f8267i2 = false;
                                        }
                                        if (i10 <= 0) {
                                            if (i10 < 0) {
                                                i12 = i10;
                                            } else {
                                                i12 = i10;
                                            }
                                        } else if (i10 < 0) {
                                            i12 = i10;
                                        } else {
                                            i12 = i10;
                                        }
                                        bVar5 = this.f8253b2;
                                        if (!bVar5.isHeader) {
                                            if (this.f8271k2 != null) {
                                                this.f8271k2 = null;
                                                motionEventObtain.setAction(3);
                                                super.dispatchTouchEvent(motionEventObtain);
                                            }
                                            motionEventObtain.recycle();
                                            i10 = i12;
                                        } else {
                                            if (this.f8271k2 != null) {
                                                this.f8271k2 = null;
                                                motionEventObtain.setAction(3);
                                                super.dispatchTouchEvent(motionEventObtain);
                                            }
                                            motionEventObtain.recycle();
                                            i10 = i12;
                                        }
                                        if (this.f8251b != 0) {
                                            s(0.0f);
                                        }
                                        return true;
                                    }
                                    this.f8254c = i10;
                                    eventTime = motionEvent.getEventTime();
                                    if (this.f8271k2 == null) {
                                        MotionEvent motionEventObtain3 = MotionEvent.obtain(eventTime, eventTime, 0, this.f8264h + f10, this.f8266i, 0);
                                        this.f8271k2 = motionEventObtain3;
                                        super.dispatchTouchEvent(motionEventObtain3);
                                    }
                                    motionEventObtain = MotionEvent.obtain(eventTime, eventTime, 2, this.f8264h + f10, this.f8266i + i10, 0);
                                    super.dispatchTouchEvent(motionEventObtain);
                                    if (this.f8267i2) {
                                        this.f8267i2 = false;
                                    }
                                    if (i10 <= 0) {
                                        if (i10 < 0) {
                                            i12 = i10;
                                        } else {
                                            i12 = i10;
                                        }
                                    } else if (i10 < 0) {
                                        i12 = i10;
                                    } else {
                                        i12 = i10;
                                    }
                                    bVar5 = this.f8253b2;
                                    if (!bVar5.isHeader) {
                                        if (this.f8271k2 != null) {
                                            this.f8271k2 = null;
                                            motionEventObtain.setAction(3);
                                            super.dispatchTouchEvent(motionEventObtain);
                                        }
                                        motionEventObtain.recycle();
                                        i10 = i12;
                                    } else {
                                        if (this.f8271k2 != null) {
                                            this.f8271k2 = null;
                                            motionEventObtain.setAction(3);
                                            super.dispatchTouchEvent(motionEventObtain);
                                        }
                                        motionEventObtain.recycle();
                                        i10 = i12;
                                    }
                                    if (this.f8251b != 0) {
                                        s(0.0f);
                                    }
                                    return true;
                                    s(i10);
                                    return true;
                                }
                                if (this.f8267i2) {
                                    this.f8267i2 = false;
                                }
                            } else if (actionMasked == 3) {
                            }
                            return super.dispatchTouchEvent(motionEvent);
                        }
                        this.f8287y.addMovement(motionEvent);
                        this.f8287y.computeCurrentVelocity(1000, this.f8284v);
                        this.f8285w = (int) this.f8287y.getYVelocity();
                        w(0.0f);
                        this.f8287y.clear();
                        this.f8274m = 'n';
                        motionEvent2 = this.f8271k2;
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                            this.f8271k2 = null;
                            long eventTime2 = motionEvent.getEventTime();
                            MotionEvent motionEventObtain4 = MotionEvent.obtain(eventTime2, eventTime2, actionMasked, this.f8264h, f14, 0);
                            super.dispatchTouchEvent(motionEventObtain4);
                            motionEventObtain4.recycle();
                        }
                        u();
                        if (this.f8276n) {
                            this.f8276n = false;
                            return true;
                        }
                        return super.dispatchTouchEvent(motionEvent);
                    }
                }
                return false;
            }
            f6.b bVar8 = this.f8250a2;
            if ((!bVar8.isOpening && !bVar8.isFinishing) || !bVar8.isHeader) {
                if (this.f8263g2) {
                    bVar7 = this.f8250a2;
                    if (bVar7.isOpening) {
                        if (bVar7.isFinishing) {
                        }
                    }
                }
                if (!p(actionMasked)) {
                    bVar = this.f8250a2;
                    if (!bVar.isFinishing && ((bVar != (bVar2 = f6.b.Loading) || !this.S) && (bVar != f6.b.Refreshing || !this.R))) {
                        if (actionMasked != 0) {
                            this.f8285w = 0;
                            this.f8287y.addMovement(motionEvent);
                            this.f8286x.forceFinished(true);
                            this.f8264h = f13;
                            this.f8266i = f14;
                            this.f8254c = 0;
                            this.f8256d = this.f8251b;
                            this.f8276n = false;
                            this.f8278p = false;
                            this.f8277o = super.dispatchTouchEvent(motionEvent);
                            if (this.f8250a2 != f6.b.TwoLevel && this.f8266i < getMeasuredHeight() * (1.0f - this.T1)) {
                                this.f8274m = 'h';
                                return this.f8277o;
                            }
                            bVar3 = this.W1;
                            if (bVar3 != null) {
                                bVar3.b(motionEvent);
                            }
                            return true;
                        }
                        if (actionMasked != 1) {
                            if (actionMasked != 2) {
                                f10 = f13 - this.f8264h;
                                f11 = f14 - this.f8266i;
                                this.f8287y.addMovement(motionEvent);
                                if (!this.f8276n && !this.f8278p && (c10 = this.f8274m) != 'h' && this.W1 != null) {
                                    if (c10 != 'v' || (Math.abs(f11) >= this.f8249a && Math.abs(f10) < Math.abs(f11))) {
                                        this.f8274m = 'v';
                                        if (f11 <= 0.0f && (this.f8251b < 0 || ((this.K || this.B) && this.W1.a()))) {
                                            this.f8276n = true;
                                            this.f8266i = f14 - this.f8249a;
                                        } else if (f11 < 0.0f && (this.f8251b > 0 || ((this.K || this.C) && ((this.f8250a2 == bVar2 && this.f8267i2) || this.W1.h())))) {
                                            this.f8276n = true;
                                            this.f8266i = this.f8249a + f14;
                                        }
                                        if (this.f8276n) {
                                            f11 = f14 - this.f8266i;
                                            if (this.f8277o) {
                                                motionEvent.setAction(3);
                                                super.dispatchTouchEvent(motionEvent);
                                            }
                                            e6.e eVar3 = this.Z1;
                                            i11 = this.f8251b;
                                            if (i11 <= 0 || (i11 == 0 && f11 > 0.0f)) {
                                                bVar6 = f6.b.PullDownToRefresh;
                                            } else {
                                                bVar6 = f6.b.PullUpToLoad;
                                            }
                                            eVar3.b(bVar6);
                                            parent = getParent();
                                            if (parent instanceof ViewGroup) {
                                                ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                                            }
                                        }
                                    } else if (Math.abs(f10) >= this.f8249a && Math.abs(f10) > Math.abs(f11) && this.f8274m != 'v') {
                                        this.f8274m = 'h';
                                    }
                                }
                                if (this.f8276n) {
                                    i10 = ((int) f11) + this.f8256d;
                                    bVar4 = this.f8253b2;
                                    if ((bVar4.isHeader && (i10 < 0 || this.f8254c < 0)) || (bVar4.isFooter && (i10 > 0 || this.f8254c > 0))) {
                                        this.f8254c = i10;
                                        eventTime = motionEvent.getEventTime();
                                        if (this.f8271k2 == null) {
                                            MotionEvent motionEventObtain5 = MotionEvent.obtain(eventTime, eventTime, 0, this.f8264h + f10, this.f8266i, 0);
                                            this.f8271k2 = motionEventObtain5;
                                            super.dispatchTouchEvent(motionEventObtain5);
                                        }
                                        motionEventObtain = MotionEvent.obtain(eventTime, eventTime, 2, this.f8264h + f10, this.f8266i + i10, 0);
                                        super.dispatchTouchEvent(motionEventObtain);
                                        if (this.f8267i2 && f11 > this.f8249a && this.f8251b < 0) {
                                            this.f8267i2 = false;
                                        }
                                        if (i10 <= 0 && ((this.K || this.B) && this.W1.a())) {
                                            this.f8270k = f14;
                                            this.f8266i = f14;
                                            this.f8256d = 0;
                                            this.Z1.b(f6.b.PullDownToRefresh);
                                        } else if (i10 < 0 || !((this.K || this.C) && this.W1.h())) {
                                            i12 = i10;
                                        } else {
                                            this.f8270k = f14;
                                            this.f8266i = f14;
                                            this.f8256d = 0;
                                            this.Z1.b(f6.b.PullUpToLoad);
                                        }
                                        bVar5 = this.f8253b2;
                                        if ((!bVar5.isHeader && i12 < 0) || (bVar5.isFooter && i12 > 0)) {
                                            if (this.f8251b != 0) {
                                                s(0.0f);
                                            }
                                            return true;
                                        }
                                        if (this.f8271k2 != null) {
                                            this.f8271k2 = null;
                                            motionEventObtain.setAction(3);
                                            super.dispatchTouchEvent(motionEventObtain);
                                        }
                                        motionEventObtain.recycle();
                                        i10 = i12;
                                    }
                                    s(i10);
                                    return true;
                                }
                                if (this.f8267i2 && f11 > this.f8249a && this.f8251b < 0) {
                                    this.f8267i2 = false;
                                }
                            } else if (actionMasked == 3) {
                            }
                            return super.dispatchTouchEvent(motionEvent);
                        }
                        this.f8287y.addMovement(motionEvent);
                        this.f8287y.computeCurrentVelocity(1000, this.f8284v);
                        this.f8285w = (int) this.f8287y.getYVelocity();
                        w(0.0f);
                        this.f8287y.clear();
                        this.f8274m = 'n';
                        motionEvent2 = this.f8271k2;
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                            this.f8271k2 = null;
                            long eventTime3 = motionEvent.getEventTime();
                            MotionEvent motionEventObtain6 = MotionEvent.obtain(eventTime3, eventTime3, actionMasked, this.f8264h, f14, 0);
                            super.dispatchTouchEvent(motionEventObtain6);
                            motionEventObtain6.recycle();
                        }
                        u();
                        if (this.f8276n) {
                            this.f8276n = false;
                            return true;
                        }
                        return super.dispatchTouchEvent(motionEvent);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j10) {
        Paint paint;
        Paint paint2;
        e6.b bVar = this.W1;
        View view2 = bVar != null ? bVar.getView() : null;
        e6.a aVar = this.U1;
        if (aVar != null && aVar.getView() == view) {
            if (!q(this.B) || (!this.I && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int iMax = Math.max(view2.getTop() + view2.getPaddingTop() + this.f8251b, view.getTop());
                int i10 = this.f8257d2;
                if (i10 != 0 && (paint2 = this.X1) != null) {
                    paint2.setColor(i10);
                    if (this.U1.getSpinnerStyle().f10068c) {
                        iMax = view.getBottom();
                    } else if (this.U1.getSpinnerStyle() == f6.c.f10060d) {
                        iMax = view.getBottom() + this.f8251b;
                    }
                    int i11 = iMax;
                    canvas.drawRect(0.0f, view.getTop(), getWidth(), i11, this.X1);
                    iMax = i11;
                }
                if ((this.D && this.U1.getSpinnerStyle() == f6.c.f10062f) || this.U1.getSpinnerStyle().f10068c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), iMax);
                    boolean zDrawChild = super.drawChild(canvas, view, j10);
                    canvas.restore();
                    return zDrawChild;
                }
            }
        }
        e6.a aVar2 = this.V1;
        if (aVar2 != null && aVar2.getView() == view) {
            if (!q(this.C) || (!this.I && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int iMin = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.f8251b, view.getBottom());
                int i12 = this.f8259e2;
                if (i12 != 0 && (paint = this.X1) != null) {
                    paint.setColor(i12);
                    if (this.V1.getSpinnerStyle().f10068c) {
                        iMin = view.getTop();
                    } else if (this.V1.getSpinnerStyle() == f6.c.f10060d) {
                        iMin = view.getTop() + this.f8251b;
                    }
                    int i13 = iMin;
                    canvas.drawRect(0.0f, i13, getWidth(), view.getBottom(), this.X1);
                    iMin = i13;
                }
                if ((this.E && this.V1.getSpinnerStyle() == f6.c.f10062f) || this.V1.getSpinnerStyle().f10068c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), iMin, view.getRight(), view.getBottom());
                    boolean zDrawChild2 = super.drawChild(canvas, view, j10);
                    canvas.restore();
                    return zDrawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j10);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new k(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.I1.getNestedScrollAxes();
    }

    @Nullable
    public e6.c getRefreshFooter() {
        e6.a aVar = this.V1;
        if (aVar instanceof e6.c) {
            return (e6.c) aVar;
        }
        return null;
    }

    @Nullable
    public e6.d getRefreshHeader() {
        e6.a aVar = this.U1;
        if (aVar instanceof e6.d) {
            return (e6.d) aVar;
        }
        return null;
    }

    @NonNull
    public f6.b getState() {
        return this.f8250a2;
    }

    protected ValueAnimator h(int i10, int i11, Interpolator interpolator, int i12) {
        if (this.f8251b == i10) {
            return null;
        }
        ValueAnimator valueAnimator = this.f8275m2;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            this.f8275m2.cancel();
            this.f8275m2 = null;
        }
        this.f8273l2 = null;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.f8251b, i10);
        this.f8275m2 = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(i12);
        this.f8275m2.setInterpolator(interpolator);
        this.f8275m2.addListener(new d());
        this.f8275m2.addUpdateListener(new e());
        this.f8275m2.setStartDelay(i11);
        this.f8275m2.start();
        return this.f8275m2;
    }

    protected void i(float f10) {
        f6.b bVar;
        if (this.f8275m2 == null) {
            if (f10 > 0.0f && ((bVar = this.f8250a2) == f6.b.Refreshing || bVar == f6.b.TwoLevel)) {
                this.f8273l2 = new i(f10, this.J1);
                return;
            }
            if (f10 < 0.0f && (this.f8250a2 == f6.b.Loading || ((this.H && this.T && this.U && q(this.C)) || (this.L && !this.T && q(this.C) && this.f8250a2 != f6.b.Refreshing)))) {
                this.f8273l2 = new i(f10, -this.L1);
            } else if (this.f8251b == 0 && this.J) {
                this.f8273l2 = new i(f10, 0);
            }
        }
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        if (this.Q) {
            return this.K || this.B || this.C;
        }
        return false;
    }

    public e6.f k(int i10, boolean z10, boolean z11) {
        int i11 = i10 >> 16;
        int i12 = (i10 << 16) >> 16;
        h hVar = new h(i11, z11, z10);
        if (i12 > 0) {
            this.Y1.postDelayed(hVar, i12);
            return this;
        }
        hVar.run();
        return this;
    }

    public e6.f n(int i10, boolean z10, Boolean bool) {
        int i11 = i10 >> 16;
        int i12 = (i10 << 16) >> 16;
        g gVar = new g(i11, bool, z10);
        if (i12 > 0) {
            this.Y1.postDelayed(gVar, i12);
            return this;
        }
        gVar.run();
        return this;
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        boolean z10;
        float f10;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z11 = isInEditMode() && this.I;
        int childCount = super.getChildCount();
        int i16 = 0;
        int measuredWidth = 0;
        int measuredHeight = 0;
        while (i16 < childCount) {
            View childAt = super.getChildAt(i16);
            if (childAt.getVisibility() == 8 || "GONE".equals(childAt.getTag(R$id.srl_tag))) {
                z10 = z11;
            } else {
                e6.a aVar = this.U1;
                if (aVar == null || aVar.getView() != childAt) {
                    z10 = z11;
                    f10 = 10.0f;
                } else {
                    View view = this.U1.getView();
                    f10 = 10.0f;
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f8248n2;
                    int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, layoutParams.width);
                    int iMax = this.J1;
                    f6.a aVar2 = this.K1;
                    z10 = z11;
                    if (aVar2.f10040a < f6.a.f10033i.f10040a) {
                        int i17 = layoutParams.height;
                        if (i17 > 0) {
                            int i18 = i17 + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                            f6.a aVar3 = f6.a.f10031g;
                            if (aVar2.a(aVar3)) {
                                this.J1 = layoutParams.height + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                                this.K1 = aVar3;
                            }
                            iMax = i18;
                        } else if (i17 == -2 && (this.U1.getSpinnerStyle() != f6.c.f10064h || !this.K1.f10041b)) {
                            int iMax2 = Math.max((View.MeasureSpec.getSize(i11) - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0);
                            view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(iMax2, Integer.MIN_VALUE));
                            int measuredHeight2 = view.getMeasuredHeight();
                            if (measuredHeight2 > 0) {
                                if (measuredHeight2 != iMax2) {
                                    f6.a aVar4 = this.K1;
                                    f6.a aVar5 = f6.a.f10029e;
                                    if (aVar4.a(aVar5)) {
                                        this.J1 = measuredHeight2 + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                                        this.K1 = aVar5;
                                    }
                                }
                                iMax = -1;
                            }
                        }
                    }
                    if (this.U1.getSpinnerStyle() == f6.c.f10064h) {
                        iMax = View.MeasureSpec.getSize(i11);
                        i15 = -1;
                        i14 = 0;
                    } else {
                        if (!this.U1.getSpinnerStyle().f10068c || z10) {
                            i14 = 0;
                        } else {
                            i14 = 0;
                            iMax = Math.max(0, q(this.B) ? this.f8251b : 0);
                        }
                        i15 = -1;
                    }
                    if (iMax != i15) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((iMax - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, i14), BasicMeasure.EXACTLY));
                    }
                    f6.a aVar6 = this.K1;
                    if (!aVar6.f10041b) {
                        float f11 = this.P1;
                        if (f11 < 10.0f) {
                            f11 *= this.J1;
                        }
                        this.K1 = aVar6.b();
                        this.U1.a(this.Z1, this.J1, (int) f11);
                    }
                    if (z10 && q(this.B)) {
                        measuredWidth += view.getMeasuredWidth();
                        measuredHeight += view.getMeasuredHeight();
                    }
                }
                e6.a aVar7 = this.V1;
                if (aVar7 != null && aVar7.getView() == childAt) {
                    View view2 = this.V1.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : f8248n2;
                    int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i10, marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin, layoutParams2.width);
                    int iMax3 = this.L1;
                    f6.a aVar8 = this.M1;
                    if (aVar8.f10040a < f6.a.f10033i.f10040a) {
                        int i19 = layoutParams2.height;
                        if (i19 > 0) {
                            iMax3 = marginLayoutParams2.bottomMargin + i19 + marginLayoutParams2.topMargin;
                            f6.a aVar9 = f6.a.f10031g;
                            if (aVar8.a(aVar9)) {
                                this.L1 = layoutParams2.height + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                this.M1 = aVar9;
                            }
                        } else if (i19 == -2 && (this.V1.getSpinnerStyle() != f6.c.f10064h || !this.M1.f10041b)) {
                            int iMax4 = Math.max((View.MeasureSpec.getSize(i11) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0);
                            view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(iMax4, Integer.MIN_VALUE));
                            int measuredHeight3 = view2.getMeasuredHeight();
                            if (measuredHeight3 > 0) {
                                if (measuredHeight3 != iMax4) {
                                    f6.a aVar10 = this.M1;
                                    f6.a aVar11 = f6.a.f10029e;
                                    if (aVar10.a(aVar11)) {
                                        this.L1 = measuredHeight3 + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                        this.M1 = aVar11;
                                    }
                                }
                                iMax3 = -1;
                            }
                        }
                    }
                    if (this.V1.getSpinnerStyle() == f6.c.f10064h) {
                        iMax3 = View.MeasureSpec.getSize(i11);
                        i13 = -1;
                        i12 = 0;
                    } else {
                        if (!this.V1.getSpinnerStyle().f10068c || z10) {
                            i12 = 0;
                        } else {
                            i12 = 0;
                            iMax3 = Math.max(0, q(this.C) ? -this.f8251b : 0);
                        }
                        i13 = -1;
                    }
                    if (iMax3 != i13) {
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((iMax3 - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, i12), BasicMeasure.EXACTLY));
                    }
                    f6.a aVar12 = this.M1;
                    if (!aVar12.f10041b) {
                        float f12 = this.Q1;
                        if (f12 < f10) {
                            f12 *= this.L1;
                        }
                        this.M1 = aVar12.b();
                        this.V1.a(this.Z1, this.L1, (int) f12);
                    }
                    if (z10 && q(this.C)) {
                        measuredWidth += view2.getMeasuredWidth();
                        measuredHeight += view2.getMeasuredHeight();
                    }
                }
                e6.b bVar = this.W1;
                if (bVar != null && bVar.getView() == childAt) {
                    View view3 = this.W1.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : f8248n2;
                    view3.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams3.leftMargin + marginLayoutParams3.rightMargin, layoutParams3.width), ViewGroup.getChildMeasureSpec(i11, getPaddingTop() + getPaddingBottom() + marginLayoutParams3.topMargin + marginLayoutParams3.bottomMargin + ((z10 && (this.U1 != null && q(this.B) && r(this.F, this.U1))) ? this.J1 : 0) + ((z10 && (this.V1 != null && q(this.C) && r(this.G, this.V1))) ? this.L1 : 0), layoutParams3.height));
                    measuredWidth += view3.getMeasuredWidth() + marginLayoutParams3.leftMargin + marginLayoutParams3.rightMargin;
                    measuredHeight += view3.getMeasuredHeight() + marginLayoutParams3.topMargin + marginLayoutParams3.bottomMargin;
                }
            }
            i16++;
            z11 = z10;
        }
        super.setMeasuredDimension(View.resolveSize(Math.max(measuredWidth + getPaddingLeft() + getPaddingRight(), super.getSuggestedMinimumWidth()), i10), View.resolveSize(Math.max(measuredHeight + getPaddingTop() + getPaddingBottom(), super.getSuggestedMinimumHeight()), i11));
        this.f8268j = getMeasuredWidth() / 2.0f;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f10, float f11, boolean z10) {
        return this.H1.dispatchNestedFling(f10, f11, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f10, float f11) {
        return (this.f8267i2 && f11 > 0.0f) || w(-f11) || this.H1.dispatchNestedPreFling(f10, f11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i10, int i11, @NonNull int[] iArr) {
        int i12 = this.E1;
        int i13 = 0;
        if (i11 * i12 > 0) {
            if (Math.abs(i11) > Math.abs(this.E1)) {
                int i14 = this.E1;
                this.E1 = 0;
                i13 = i14;
            } else {
                this.E1 -= i11;
                i13 = i11;
            }
            s(this.E1);
        } else if (i11 > 0 && this.f8267i2) {
            int i15 = i12 - i11;
            this.E1 = i15;
            s(i15);
            i13 = i11;
        }
        this.H1.dispatchNestedPreScroll(i10, i11 - i13, iArr, null);
        iArr[1] = iArr[1] + i13;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i10, int i11, int i12, int i13) {
        g6.f fVar;
        ViewParent parent;
        g6.f fVar2;
        boolean zDispatchNestedScroll = this.H1.dispatchNestedScroll(i10, i11, i12, i13, this.G1);
        int i14 = i13 + this.G1[1];
        if ((i14 < 0 && ((this.B || this.K) && (this.E1 != 0 || (fVar2 = this.D1) == null || fVar2.a(this.W1.getView())))) || (i14 > 0 && ((this.C || this.K) && (this.E1 != 0 || (fVar = this.D1) == null || fVar.b(this.W1.getView()))))) {
            f6.b bVar = this.f8253b2;
            if (bVar == f6.b.None || bVar.isOpening) {
                this.Z1.b(i14 > 0 ? f6.b.PullUpToLoad : f6.b.PullDownToRefresh);
                if (!zDispatchNestedScroll && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
            int i15 = this.E1 - i14;
            this.E1 = i15;
            s(i15);
        }
        if (!this.f8267i2 || i11 >= 0) {
            return;
        }
        this.f8267i2 = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i10) {
        this.I1.onNestedScrollAccepted(view, view2, i10);
        this.H1.startNestedScroll(i10 & 2);
        this.E1 = this.f8251b;
        this.F1 = true;
        p(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        this.I1.onStopNestedScroll(view);
        this.F1 = false;
        this.E1 = 0;
        u();
        this.H1.stopNestedScroll();
    }

    protected boolean q(boolean z10) {
        return z10 && !this.M;
    }

    protected boolean r(boolean z10, @Nullable e6.a aVar) {
        return z10 || this.M || aVar == null || aVar.getSpinnerStyle() == f6.c.f10062f;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (ViewCompat.isNestedScrollingEnabled(this.W1.j())) {
            this.f8278p = z10;
            super.requestDisallowInterceptTouchEvent(z10);
        }
    }

    protected void s(float f10) {
        f6.b bVar;
        float f11 = (!this.F1 || this.P || f10 >= 0.0f || this.W1.h()) ? f10 : 0.0f;
        if (f11 > this.f8262g * 5 && getTag() == null) {
            int i10 = R$id.srl_tag;
            if (getTag(i10) == null) {
                float f12 = this.f8270k;
                int i11 = this.f8262g;
                if (f12 < i11 / 6.0f && this.f8268j < i11 / 16.0f) {
                    Toast.makeText(getContext(), "你这么死拉，臣妾做不到啊！", 0).show();
                    setTag(i10, "你这么死拉，臣妾做不到啊！");
                }
            }
        }
        f6.b bVar2 = this.f8250a2;
        if (bVar2 == f6.b.TwoLevel && f11 > 0.0f) {
            this.Z1.f(Math.min((int) f11, getMeasuredHeight()), true);
        } else if (bVar2 == f6.b.Refreshing && f11 >= 0.0f) {
            int i12 = this.J1;
            if (f11 < i12) {
                this.Z1.f((int) f11, true);
            } else {
                float f13 = this.P1;
                if (f13 < 10.0f) {
                    f13 *= i12;
                }
                double d10 = f13 - i12;
                int iMax = Math.max((this.f8262g * 4) / 3, getHeight());
                int i13 = this.J1;
                double d11 = iMax - i13;
                double dMax = Math.max(0.0f, (f11 - i13) * this.f8272l);
                double d12 = -dMax;
                if (d11 == 0.0d) {
                    d11 = 1.0d;
                }
                this.Z1.f(((int) Math.min(d10 * (1.0d - Math.pow(100.0d, d12 / d11)), dMax)) + this.J1, true);
            }
        } else if (f11 < 0.0f && (bVar2 == f6.b.Loading || ((this.H && this.T && this.U && q(this.C)) || (this.L && !this.T && q(this.C))))) {
            int i14 = this.L1;
            if (f11 > (-i14)) {
                this.Z1.f((int) f11, true);
            } else {
                float f14 = this.Q1;
                if (f14 < 10.0f) {
                    f14 *= i14;
                }
                double d13 = f14 - i14;
                int iMax2 = Math.max((this.f8262g * 4) / 3, getHeight());
                int i15 = this.L1;
                double d14 = iMax2 - i15;
                double d15 = -Math.min(0.0f, (i15 + f11) * this.f8272l);
                double d16 = -d15;
                if (d14 == 0.0d) {
                    d14 = 1.0d;
                }
                this.Z1.f(((int) (-Math.min(d13 * (1.0d - Math.pow(100.0d, d16 / d14)), d15))) - this.L1, true);
            }
        } else if (f11 >= 0.0f) {
            float f15 = this.P1;
            double d17 = f15 < 10.0f ? this.J1 * f15 : f15;
            double dMax2 = Math.max(this.f8262g / 2, getHeight());
            double dMax3 = Math.max(0.0f, this.f8272l * f11);
            double d18 = -dMax3;
            if (dMax2 == 0.0d) {
                dMax2 = 1.0d;
            }
            this.Z1.f((int) Math.min(d17 * (1.0d - Math.pow(100.0d, d18 / dMax2)), dMax3), true);
        } else {
            float f16 = this.Q1;
            double d19 = f16 < 10.0f ? this.L1 * f16 : f16;
            double dMax4 = Math.max(this.f8262g / 2, getHeight());
            double d20 = -Math.min(0.0f, this.f8272l * f11);
            double d21 = -d20;
            if (dMax4 == 0.0d) {
                dMax4 = 1.0d;
            }
            this.Z1.f((int) (-Math.min(d19 * (1.0d - Math.pow(100.0d, d21 / dMax4)), d20)), true);
        }
        if (!this.L || this.T || !q(this.C) || f11 >= 0.0f || (bVar = this.f8250a2) == f6.b.Refreshing || bVar == f6.b.Loading || bVar == f6.b.LoadFinish) {
            return;
        }
        if (this.S) {
            this.f8273l2 = null;
            this.Z1.d(-this.L1);
        }
        setStateDirectLoading(false);
        this.Y1.postDelayed(new f(), this.f8260f);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        this.Q = z10;
        this.H1.setNestedScrollingEnabled(z10);
    }

    protected void setStateDirectLoading(boolean z10) {
        f6.b bVar = this.f8250a2;
        f6.b bVar2 = f6.b.Loading;
        if (bVar != bVar2) {
            this.f8255c2 = System.currentTimeMillis();
            this.f8267i2 = true;
            t(bVar2);
            j(2000);
            e6.a aVar = this.V1;
            if (aVar != null) {
                float f10 = this.Q1;
                if (f10 < 10.0f) {
                    f10 *= this.L1;
                }
                aVar.g(this, this.L1, (int) f10);
            }
        }
    }

    protected void setStateLoading(boolean z10) {
        b bVar = new b(z10);
        t(f6.b.LoadReleased);
        ValueAnimator valueAnimatorD = this.Z1.d(-this.L1);
        if (valueAnimatorD != null) {
            valueAnimatorD.addListener(bVar);
        }
        e6.a aVar = this.V1;
        if (aVar != null) {
            float f10 = this.Q1;
            if (f10 < 10.0f) {
                f10 *= this.L1;
            }
            aVar.e(this, this.L1, (int) f10);
        }
        if (valueAnimatorD == null) {
            bVar.onAnimationEnd(null);
        }
    }

    protected void setStateRefreshing(boolean z10) {
        c cVar = new c(z10);
        t(f6.b.RefreshReleased);
        ValueAnimator valueAnimatorD = this.Z1.d(this.J1);
        if (valueAnimatorD != null) {
            valueAnimatorD.addListener(cVar);
        }
        e6.a aVar = this.U1;
        if (aVar != null) {
            float f10 = this.P1;
            if (f10 < 10.0f) {
                f10 *= this.J1;
            }
            aVar.e(this, this.J1, (int) f10);
        }
        if (valueAnimatorD == null) {
            cVar.onAnimationEnd(null);
        }
    }

    protected void setViceState(f6.b bVar) {
        f6.b bVar2 = this.f8250a2;
        if (bVar2.isDragging && bVar2.isHeader != bVar.isHeader) {
            t(f6.b.None);
        }
        if (this.f8253b2 != bVar) {
            this.f8253b2 = bVar;
        }
    }

    protected void t(f6.b bVar) {
        f6.b bVar2 = this.f8250a2;
        if (bVar2 == bVar) {
            if (this.f8253b2 != bVar2) {
                this.f8253b2 = bVar2;
                return;
            }
            return;
        }
        this.f8250a2 = bVar;
        this.f8253b2 = bVar;
        e6.a aVar = this.U1;
        e6.a aVar2 = this.V1;
        if (aVar != null) {
            aVar.h(this, bVar2, bVar);
        }
        if (aVar2 != null) {
            aVar2.h(this, bVar2, bVar);
        }
        if (bVar == f6.b.LoadFinish) {
            this.f8267i2 = false;
        }
    }

    protected void u() {
        f6.b bVar = this.f8250a2;
        if (bVar == f6.b.TwoLevel) {
            if (this.f8285w <= -1000 || this.f8251b <= getHeight() / 2) {
                if (this.f8276n) {
                    this.Z1.c();
                    return;
                }
                return;
            } else {
                ValueAnimator valueAnimatorD = this.Z1.d(getHeight());
                if (valueAnimatorD != null) {
                    valueAnimatorD.setDuration(this.f8258e);
                    return;
                }
                return;
            }
        }
        f6.b bVar2 = f6.b.Loading;
        if (bVar == bVar2 || (this.H && this.T && this.U && this.f8251b < 0 && q(this.C))) {
            int i10 = this.f8251b;
            int i11 = this.L1;
            if (i10 < (-i11)) {
                this.Z1.d(-i11);
                return;
            } else {
                if (i10 > 0) {
                    this.Z1.d(0);
                    return;
                }
                return;
            }
        }
        f6.b bVar3 = this.f8250a2;
        f6.b bVar4 = f6.b.Refreshing;
        if (bVar3 == bVar4) {
            int i12 = this.f8251b;
            int i13 = this.J1;
            if (i12 > i13) {
                this.Z1.d(i13);
                return;
            } else {
                if (i12 < 0) {
                    this.Z1.d(0);
                    return;
                }
                return;
            }
        }
        if (bVar3 == f6.b.PullDownToRefresh) {
            this.Z1.b(f6.b.PullDownCanceled);
            return;
        }
        if (bVar3 == f6.b.PullUpToLoad) {
            this.Z1.b(f6.b.PullUpCanceled);
            return;
        }
        if (bVar3 == f6.b.ReleaseToRefresh) {
            this.Z1.b(bVar4);
            return;
        }
        if (bVar3 == f6.b.ReleaseToLoad) {
            this.Z1.b(bVar2);
            return;
        }
        if (bVar3 == f6.b.ReleaseToTwoLevel) {
            this.Z1.b(f6.b.TwoLevelReleased);
            return;
        }
        if (bVar3 == f6.b.RefreshReleased) {
            if (this.f8275m2 == null) {
                this.Z1.d(this.J1);
            }
        } else if (bVar3 == f6.b.LoadReleased) {
            if (this.f8275m2 == null) {
                this.Z1.d(-this.L1);
            }
        } else {
            if (bVar3 == f6.b.LoadFinish || this.f8251b == 0) {
                return;
            }
            this.Z1.d(0);
        }
    }

    public e6.f v(boolean z10) {
        f6.b bVar = this.f8250a2;
        if (bVar == f6.b.Refreshing && z10) {
            o();
            return this;
        }
        if (bVar == f6.b.Loading && z10) {
            l();
            return this;
        }
        if (this.T != z10) {
            this.T = z10;
            e6.a aVar = this.V1;
            if (aVar instanceof e6.c) {
                if (((e6.c) aVar).b(z10)) {
                    this.U = true;
                    if (this.T && this.H && this.f8251b > 0 && this.V1.getSpinnerStyle() == f6.c.f10060d && q(this.C) && r(this.B, this.U1)) {
                        this.V1.getView().setTranslationY(this.f8251b);
                        return this;
                    }
                } else {
                    this.U = false;
                    new RuntimeException("Footer:" + this.V1 + " NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])").printStackTrace();
                }
            }
        }
        return this;
    }

    @Override // e6.f
    public e6.f a(boolean z10) {
        setNestedScrollingEnabled(z10);
        return this;
    }

    public e6.f l() {
        return k(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f8255c2))), 300) << 16, true, true);
    }

    public e6.f o() {
        return n(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f8255c2))), 300) << 16, true, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        e6.a aVar;
        super.onAttachedToWindow();
        boolean z10 = true;
        this.f8265h2 = true;
        if (!isInEditMode()) {
            if (this.V1 != null) {
                if (!this.C && this.V) {
                    z10 = false;
                }
                this.C = z10;
            }
            if (this.W1 == null) {
                int childCount = getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = getChildAt(i10);
                    e6.a aVar2 = this.U1;
                    if ((aVar2 == null || childAt != aVar2.getView()) && ((aVar = this.V1) == null || childAt != aVar.getView())) {
                        this.W1 = new j6.a(childAt);
                    }
                }
            }
            if (this.W1 == null) {
                int iC = i6.b.c(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R$string.srl_content_empty);
                super.addView(textView, 0, new k(-1, -1));
                j6.a aVar3 = new j6.a(textView);
                this.W1 = aVar3;
                aVar3.getView().setPadding(iC, iC, iC, iC);
            }
            View viewFindViewById = findViewById(this.f8279q);
            View viewFindViewById2 = findViewById(this.f8280r);
            this.W1.d(this.D1);
            this.W1.e(this.P);
            this.W1.g(this.Z1, viewFindViewById, viewFindViewById2);
            if (this.f8251b != 0) {
                t(f6.b.None);
                e6.b bVar = this.W1;
                this.f8251b = 0;
                bVar.c(0, this.f8281s, this.f8282t);
            }
        }
        int[] iArr = this.A;
        if (iArr != null) {
            e6.a aVar4 = this.U1;
            if (aVar4 != null) {
                aVar4.setPrimaryColors(iArr);
            }
            e6.a aVar5 = this.V1;
            if (aVar5 != null) {
                aVar5.setPrimaryColors(this.A);
            }
        }
        e6.b bVar2 = this.W1;
        if (bVar2 != null) {
            super.bringChildToFront(bVar2.getView());
        }
        e6.a aVar6 = this.U1;
        if (aVar6 != null && aVar6.getSpinnerStyle().f10067b) {
            super.bringChildToFront(this.U1.getView());
        }
        e6.a aVar7 = this.V1;
        if (aVar7 != null && aVar7.getSpinnerStyle().f10067b) {
            super.bringChildToFront(this.V1.getView());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8265h2 = false;
        this.V = true;
        this.f8273l2 = null;
        ValueAnimator valueAnimator = this.f8275m2;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f8275m2.removeAllUpdateListeners();
            this.f8275m2.setDuration(0L);
            this.f8275m2.cancel();
            this.f8275m2 = null;
        }
        e6.a aVar = this.U1;
        if (aVar != null && this.f8250a2 == f6.b.Refreshing) {
            aVar.d(this, false);
        }
        e6.a aVar2 = this.V1;
        if (aVar2 != null && this.f8250a2 == f6.b.Loading) {
            aVar2.d(this, false);
        }
        if (this.f8251b != 0) {
            this.Z1.f(0, true);
        }
        f6.b bVar = this.f8250a2;
        f6.b bVar2 = f6.b.None;
        if (bVar != bVar2) {
            t(bVar2);
        }
        Handler handler = this.Y1;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f8267i2 = false;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x004e  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    protected void onFinishInflate() {
        int i10;
        int i11;
        e6.d cVar;
        boolean z10;
        e6.c bVar;
        super.onFinishInflate();
        int childCount = super.getChildCount();
        if (childCount <= 3) {
            int i12 = 0;
            int i13 = -1;
            char c10 = 0;
            while (true) {
                i10 = 2;
                if (i12 >= childCount) {
                    break;
                }
                View childAt = super.getChildAt(i12);
                if (i6.b.e(childAt) && (c10 < 2 || i12 == 1)) {
                    i13 = i12;
                    c10 = 2;
                } else if (!(childAt instanceof e6.a) && c10 < 1) {
                    if (i12 > 0) {
                        c10 = 1;
                    } else {
                        c10 = 0;
                    }
                    i13 = i12;
                }
                i12++;
            }
            if (i13 >= 0) {
                this.W1 = new j6.a(super.getChildAt(i13));
                if (i13 == 1) {
                    if (childCount == 3) {
                        i11 = 0;
                    } else {
                        i11 = 0;
                        i10 = -1;
                    }
                } else if (childCount == 2) {
                    i11 = -1;
                    i10 = 1;
                } else {
                    i11 = -1;
                    i10 = -1;
                }
            } else {
                i11 = -1;
                i10 = -1;
            }
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt2 = super.getChildAt(i14);
                if (i14 != i11 && (i14 == i10 || i11 != -1 || this.U1 != null || !(childAt2 instanceof e6.d))) {
                    if (i14 == i10 || (i10 == -1 && (childAt2 instanceof e6.c))) {
                        if (!this.C && this.V) {
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        this.C = z10;
                        if (childAt2 instanceof e6.c) {
                            bVar = (e6.c) childAt2;
                        } else {
                            bVar = new j6.b(childAt2);
                        }
                        this.V1 = bVar;
                    }
                } else {
                    if (childAt2 instanceof e6.d) {
                        cVar = (e6.d) childAt2;
                    } else {
                        cVar = new j6.c(childAt2);
                    }
                    this.U1 = cVar;
                }
            }
            return;
        }
        throw new RuntimeException("最多只支持3个子View，Most only support three sub view");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int iMax;
        int i14;
        int i15;
        boolean z11;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        boolean z12;
        ViewGroup.MarginLayoutParams marginLayoutParams3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = super.getChildAt(i16);
            if (childAt.getVisibility() != 8 && !"GONE".equals(childAt.getTag(R$id.srl_tag))) {
                e6.b bVar = this.W1;
                boolean z13 = true;
                if (bVar != null && bVar.getView() == childAt) {
                    if (isInEditMode() && this.I && q(this.B) && this.U1 != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    View view = this.W1.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams;
                    } else {
                        marginLayoutParams3 = f8248n2;
                    }
                    int i17 = marginLayoutParams3.leftMargin + paddingLeft;
                    int i18 = marginLayoutParams3.topMargin + paddingTop;
                    int measuredWidth = view.getMeasuredWidth() + i17;
                    int measuredHeight = view.getMeasuredHeight() + i18;
                    if (z12 && r(this.F, this.U1)) {
                        int i19 = this.J1;
                        i18 += i19;
                        measuredHeight += i19;
                    }
                    view.layout(i17, i18, measuredWidth, measuredHeight);
                }
                e6.a aVar = this.U1;
                if (aVar != null && aVar.getView() == childAt) {
                    if (isInEditMode() && this.I && q(this.B)) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    View view2 = this.U1.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    } else {
                        marginLayoutParams2 = f8248n2;
                    }
                    int i20 = marginLayoutParams2.leftMargin;
                    int i21 = marginLayoutParams2.topMargin + this.N1;
                    int measuredWidth2 = view2.getMeasuredWidth() + i20;
                    int measuredHeight2 = view2.getMeasuredHeight() + i21;
                    if (!z11 && this.U1.getSpinnerStyle() == f6.c.f10060d) {
                        int i22 = this.J1;
                        i21 -= i22;
                        measuredHeight2 -= i22;
                    }
                    view2.layout(i20, i21, measuredWidth2, measuredHeight2);
                }
                e6.a aVar2 = this.V1;
                if (aVar2 != null && aVar2.getView() == childAt) {
                    if (!isInEditMode() || !this.I || !q(this.C)) {
                        z13 = false;
                    }
                    View view3 = this.V1.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
                    } else {
                        marginLayoutParams = f8248n2;
                    }
                    f6.c spinnerStyle = this.V1.getSpinnerStyle();
                    int i23 = marginLayoutParams.leftMargin;
                    int measuredHeight3 = (marginLayoutParams.topMargin + getMeasuredHeight()) - this.O1;
                    if (this.T && this.U && this.H && this.W1 != null && this.V1.getSpinnerStyle() == f6.c.f10060d && q(this.C)) {
                        View view4 = this.W1.getView();
                        ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                        if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                            i15 = ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin;
                        } else {
                            i15 = 0;
                        }
                        measuredHeight3 = view4.getMeasuredHeight() + paddingTop + paddingTop + i15;
                    }
                    if (spinnerStyle == f6.c.f10064h) {
                        measuredHeight3 = marginLayoutParams.topMargin - this.O1;
                    } else {
                        if (!z13 && spinnerStyle != f6.c.f10063g && spinnerStyle != f6.c.f10062f) {
                            if (spinnerStyle.f10068c && this.f8251b < 0) {
                                if (q(this.C)) {
                                    i14 = -this.f8251b;
                                } else {
                                    i14 = 0;
                                }
                                iMax = Math.max(i14, 0);
                            }
                        } else {
                            iMax = this.L1;
                        }
                        measuredHeight3 -= iMax;
                    }
                    view3.layout(i23, measuredHeight3, view3.getMeasuredWidth() + i23, view3.getMeasuredHeight() + measuredHeight3);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i10) {
        if (isEnabled() && isNestedScrollingEnabled() && (i10 & 2) != 0) {
            if (this.K || this.B || this.C) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class k extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f6.c f8326b;

        public k(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8325a = 0;
            this.f8326b = null;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SmartRefreshLayout_Layout);
            this.f8325a = typedArrayObtainStyledAttributes.getColor(R$styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.f8325a);
            int i10 = R$styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle;
            if (typedArrayObtainStyledAttributes.hasValue(i10)) {
                this.f8326b = f6.c.f10065i[typedArrayObtainStyledAttributes.getInt(i10, f6.c.f10060d.f10066a)];
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public k(int i10, int i11) {
            super(i10, i11);
            this.f8325a = 0;
            this.f8326b = null;
        }
    }

    @Override // e6.f
    @NonNull
    public ViewGroup getLayout() {
        return this;
    }

    public static void setDefaultRefreshFooterCreator(@NonNull g6.b bVar) {
    }

    public static void setDefaultRefreshHeaderCreator(@NonNull g6.c cVar) {
    }

    public static void setDefaultRefreshInitializer(@NonNull g6.d dVar) {
    }
}
