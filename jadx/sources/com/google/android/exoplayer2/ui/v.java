package com.google.android.exoplayer2.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class v {
    private boolean A;
    private boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StyledPlayerControlView f1902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final View f1903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final ViewGroup f1904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final ViewGroup f1905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final ViewGroup f1906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final ViewGroup f1907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final ViewGroup f1908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final ViewGroup f1909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private final ViewGroup f1910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private final View f1911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private final View f1912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AnimatorSet f1913l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AnimatorSet f1914m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AnimatorSet f1915n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AnimatorSet f1916o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final AnimatorSet f1917p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ValueAnimator f1918q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final ValueAnimator f1919r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Runnable f1920s = new Runnable() { // from class: com.google.android.exoplayer2.ui.i
        @Override // java.lang.Runnable
        public final void run() {
            this.f1889a.Y();
        }
    };

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Runnable f1921t = new Runnable() { // from class: com.google.android.exoplayer2.ui.o
        @Override // java.lang.Runnable
        public final void run() {
            this.f1895a.D();
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Runnable f1922u = new Runnable() { // from class: com.google.android.exoplayer2.ui.p
        @Override // java.lang.Runnable
        public final void run() {
            this.f1896a.H();
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Runnable f1923v = new Runnable() { // from class: com.google.android.exoplayer2.ui.q
        @Override // java.lang.Runnable
        public final void run() {
            this.f1897a.G();
        }
    };

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Runnable f1924w = new Runnable() { // from class: com.google.android.exoplayer2.ui.r
        @Override // java.lang.Runnable
        public final void run() {
            this.f1898a.E();
        }
    };

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final View.OnLayoutChangeListener f1925x = new View.OnLayoutChangeListener() { // from class: com.google.android.exoplayer2.ui.s
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.f1899a.N(view, i10, i11, i12, i13, i14, i15, i16, i17);
        }
    };
    private boolean C = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f1927z = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final List<View> f1926y = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (v.this.f1903b != null) {
                v.this.f1903b.setVisibility(4);
            }
            if (v.this.f1904c != null) {
                v.this.f1904c.setVisibility(4);
            }
            if (v.this.f1906e != null) {
                v.this.f1906e.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (!(v.this.f1911j instanceof DefaultTimeBar) || v.this.A) {
                return;
            }
            ((DefaultTimeBar) v.this.f1911j).g(250L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (v.this.f1903b != null) {
                v.this.f1903b.setVisibility(0);
            }
            if (v.this.f1904c != null) {
                v.this.f1904c.setVisibility(0);
            }
            if (v.this.f1906e != null) {
                v.this.f1906e.setVisibility(v.this.A ? 0 : 4);
            }
            if (!(v.this.f1911j instanceof DefaultTimeBar) || v.this.A) {
                return;
            }
            ((DefaultTimeBar) v.this.f1911j).r(250L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ StyledPlayerControlView f1930a;

        c(StyledPlayerControlView styledPlayerControlView) {
            this.f1930a = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            v.this.V(1);
            if (v.this.B) {
                this.f1930a.post(v.this.f1920s);
                v.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            v.this.V(3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ StyledPlayerControlView f1932a;

        d(StyledPlayerControlView styledPlayerControlView) {
            this.f1932a = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            v.this.V(2);
            if (v.this.B) {
                this.f1932a.post(v.this.f1920s);
                v.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            v.this.V(3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ StyledPlayerControlView f1934a;

        e(StyledPlayerControlView styledPlayerControlView) {
            this.f1934a = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            v.this.V(2);
            if (v.this.B) {
                this.f1934a.post(v.this.f1920s);
                v.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            v.this.V(3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            v.this.V(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            v.this.V(4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            v.this.V(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            v.this.V(4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class h extends AnimatorListenerAdapter {
        h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (v.this.f1907f != null) {
                v.this.f1907f.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (v.this.f1909h != null) {
                v.this.f1909h.setVisibility(0);
                v.this.f1909h.setTranslationX(v.this.f1909h.getWidth());
                v.this.f1909h.scrollTo(v.this.f1909h.getWidth(), 0);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class i extends AnimatorListenerAdapter {
        i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (v.this.f1909h != null) {
                v.this.f1909h.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (v.this.f1907f != null) {
                v.this.f1907f.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        V(2);
    }

    private static ObjectAnimator J(float f10, float f11, View view) {
        return ObjectAnimator.ofFloat(view, "translationY", f10, f11);
    }

    private static int B(@Nullable View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return width + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        this.f1915n.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        this.f1913l.start();
        Q(this.f1922u, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.f1914m.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        int i10;
        if (this.f1907f == null || this.f1908g == null) {
            return;
        }
        int width = (this.f1902a.getWidth() - this.f1902a.getPaddingLeft()) - this.f1902a.getPaddingRight();
        while (true) {
            if (this.f1908g.getChildCount() <= 1) {
                break;
            }
            int childCount = this.f1908g.getChildCount() - 2;
            View childAt = this.f1908g.getChildAt(childCount);
            this.f1908g.removeViewAt(childCount);
            this.f1907f.addView(childAt, 0);
        }
        View view = this.f1912k;
        if (view != null) {
            view.setVisibility(8);
        }
        int iB = B(this.f1910i);
        int childCount2 = this.f1907f.getChildCount() - 1;
        for (int i11 = 0; i11 < childCount2; i11++) {
            iB += B(this.f1907f.getChildAt(i11));
        }
        if (iB <= width) {
            ViewGroup viewGroup = this.f1909h;
            if (viewGroup == null || viewGroup.getVisibility() != 0 || this.f1919r.isStarted()) {
                return;
            }
            this.f1918q.cancel();
            this.f1919r.start();
            return;
        }
        View view2 = this.f1912k;
        if (view2 != null) {
            view2.setVisibility(0);
            iB += B(this.f1912k);
        }
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = this.f1907f.getChildAt(i12);
            iB -= B(childAt2);
            arrayList.add(childAt2);
            if (iB <= width) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f1907f.removeViews(0, arrayList.size());
        for (i10 = 0; i10 < arrayList.size(); i10++) {
            this.f1908g.addView((View) arrayList.get(i10), this.f1908g.getChildCount() - 1);
        }
    }

    private void Q(Runnable runnable, long j10) {
        if (j10 >= 0) {
            this.f1902a.postDelayed(runnable, j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i10) {
        int i11 = this.f1927z;
        this.f1927z = i10;
        if (i10 == 2) {
            this.f1902a.setVisibility(8);
        } else if (i11 == 2) {
            this.f1902a.setVisibility(0);
        }
        if (i11 != i10) {
            this.f1902a.a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        if (!this.C) {
            V(0);
            S();
            return;
        }
        int i10 = this.f1927z;
        if (i10 == 1) {
            this.f1916o.start();
        } else if (i10 == 2) {
            this.f1917p.start();
        } else if (i10 == 3) {
            this.B = true;
        } else if (i10 == 4) {
            return;
        }
        S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        ViewGroup viewGroup = this.f1906e;
        if (viewGroup != null) {
            viewGroup.setVisibility(this.A ? 0 : 4);
        }
        View view = this.f1911j;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.f1902a.getResources().getDimensionPixelSize(R$dimen.exo_styled_progress_margin_bottom);
            if (this.A) {
                dimensionPixelSize = 0;
            }
            marginLayoutParams.bottomMargin = dimensionPixelSize;
            this.f1911j.setLayoutParams(marginLayoutParams);
            View view2 = this.f1911j;
            if (view2 instanceof DefaultTimeBar) {
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view2;
                if (this.A) {
                    defaultTimeBar.h(true);
                } else {
                    int i10 = this.f1927z;
                    if (i10 == 1) {
                        defaultTimeBar.h(false);
                    } else if (i10 != 3) {
                        defaultTimeBar.q();
                    }
                }
            }
        }
        for (View view3 : this.f1926y) {
            view3.setVisibility((this.A && W(view3)) ? 4 : 0);
        }
    }

    private boolean a0() {
        int width = (this.f1902a.getWidth() - this.f1902a.getPaddingLeft()) - this.f1902a.getPaddingRight();
        int height = (this.f1902a.getHeight() - this.f1902a.getPaddingBottom()) - this.f1902a.getPaddingTop();
        int iB = B(this.f1904c);
        ViewGroup viewGroup = this.f1904c;
        int paddingLeft = iB - (viewGroup != null ? viewGroup.getPaddingLeft() + this.f1904c.getPaddingRight() : 0);
        int iZ = z(this.f1904c);
        ViewGroup viewGroup2 = this.f1904c;
        return width <= Math.max(paddingLeft, B(this.f1910i) + B(this.f1912k)) || height <= (iZ - (viewGroup2 != null ? viewGroup2.getPaddingTop() + this.f1904c.getPaddingBottom() : 0)) + (z(this.f1905d) * 2);
    }

    private void y(float f10) {
        ViewGroup viewGroup = this.f1909h;
        if (viewGroup != null) {
            this.f1909h.setTranslationX((int) (viewGroup.getWidth() * (1.0f - f10)));
        }
        ViewGroup viewGroup2 = this.f1910i;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f10);
        }
        ViewGroup viewGroup3 = this.f1907f;
        if (viewGroup3 != null) {
            viewGroup3.setAlpha(1.0f - f10);
        }
    }

    private static int z(@Nullable View view) {
        if (view == null) {
            return 0;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return height;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return height + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public boolean A(@Nullable View view) {
        return view != null && this.f1926y.contains(view);
    }

    public void C() {
        int i10 = this.f1927z;
        if (i10 == 3 || i10 == 2) {
            return;
        }
        R();
        if (!this.C) {
            E();
        } else if (this.f1927z == 1) {
            H();
        } else {
            D();
        }
    }

    public void F() {
        int i10 = this.f1927z;
        if (i10 == 3 || i10 == 2) {
            return;
        }
        R();
        E();
    }

    public boolean I() {
        return this.f1927z == 0 && this.f1902a.Z();
    }

    public void K() {
        this.f1902a.addOnLayoutChangeListener(this.f1925x);
    }

    public void L() {
        this.f1902a.removeOnLayoutChangeListener(this.f1925x);
    }

    public void M(boolean z10, int i10, int i11, int i12, int i13) {
        View view = this.f1903b;
        if (view != null) {
            view.layout(0, 0, i12 - i10, i13 - i11);
        }
    }

    public void R() {
        this.f1902a.removeCallbacks(this.f1924w);
        this.f1902a.removeCallbacks(this.f1921t);
        this.f1902a.removeCallbacks(this.f1923v);
        this.f1902a.removeCallbacks(this.f1922u);
    }

    public void S() {
        if (this.f1927z == 3) {
            return;
        }
        R();
        int showTimeoutMs = this.f1902a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.C) {
                Q(this.f1924w, showTimeoutMs);
            } else if (this.f1927z == 1) {
                Q(this.f1922u, 2000L);
            } else {
                Q(this.f1923v, showTimeoutMs);
            }
        }
    }

    public void T(boolean z10) {
        this.C = z10;
    }

    public void U(@Nullable View view, boolean z10) {
        if (view == null) {
            return;
        }
        if (!z10) {
            view.setVisibility(8);
            this.f1926y.remove(view);
            return;
        }
        if (this.A && W(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        this.f1926y.add(view);
    }

    public void X() {
        if (!this.f1902a.Z()) {
            this.f1902a.setVisibility(0);
            this.f1902a.k0();
            this.f1902a.f0();
        }
        Y();
    }

    public v(StyledPlayerControlView styledPlayerControlView) {
        this.f1902a = styledPlayerControlView;
        this.f1903b = styledPlayerControlView.findViewById(R$id.exo_controls_background);
        this.f1904c = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_center_controls);
        this.f1906e = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_bottom_bar);
        this.f1905d = viewGroup;
        this.f1910i = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_time);
        View viewFindViewById = styledPlayerControlView.findViewById(R$id.exo_progress);
        this.f1911j = viewFindViewById;
        this.f1907f = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_basic_controls);
        this.f1908g = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_extra_controls);
        this.f1909h = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_extra_controls_scroll_view);
        View viewFindViewById2 = styledPlayerControlView.findViewById(R$id.exo_overflow_show);
        this.f1912k = viewFindViewById2;
        View viewFindViewById3 = styledPlayerControlView.findViewById(R$id.exo_overflow_hide);
        if (viewFindViewById2 != null && viewFindViewById3 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f1900a.P(view);
                }
            });
            viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f1900a.P(view);
                }
            });
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.u
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                v.d(this.f1901a, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new a());
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                v.g(this.f1890a, valueAnimator);
            }
        });
        valueAnimatorOfFloat2.addListener(new b());
        Resources resources = styledPlayerControlView.getResources();
        int i10 = R$dimen.exo_styled_bottom_bar_height;
        float dimension = resources.getDimension(i10) - resources.getDimension(R$dimen.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(i10);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f1913l = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new c(styledPlayerControlView));
        animatorSet.play(valueAnimatorOfFloat).with(J(0.0f, dimension, viewFindViewById)).with(J(0.0f, dimension, viewGroup));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f1914m = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new d(styledPlayerControlView));
        animatorSet2.play(J(dimension, dimension2, viewFindViewById)).with(J(dimension, dimension2, viewGroup));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f1915n = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new e(styledPlayerControlView));
        animatorSet3.play(valueAnimatorOfFloat).with(J(0.0f, dimension2, viewFindViewById)).with(J(0.0f, dimension2, viewGroup));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f1916o = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new f());
        animatorSet4.play(valueAnimatorOfFloat2).with(J(dimension, 0.0f, viewFindViewById)).with(J(dimension, 0.0f, viewGroup));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.f1917p = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new g());
        animatorSet5.play(valueAnimatorOfFloat2).with(J(dimension2, 0.0f, viewFindViewById)).with(J(dimension2, 0.0f, viewGroup));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f1918q = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.setDuration(250L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.m
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                v.b(this.f1893a, valueAnimator);
            }
        });
        valueAnimatorOfFloat3.addListener(new h());
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f1919r = valueAnimatorOfFloat4;
        valueAnimatorOfFloat4.setDuration(250L);
        valueAnimatorOfFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.n
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                v.m(this.f1894a, valueAnimator);
            }
        });
        valueAnimatorOfFloat4.addListener(new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        boolean z10;
        boolean zA0 = a0();
        if (this.A != zA0) {
            this.A = zA0;
            view.post(new Runnable() { // from class: com.google.android.exoplayer2.ui.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1891a.Z();
                }
            });
        }
        if (i12 - i10 != i16 - i14) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!this.A && z10) {
            view.post(new Runnable() { // from class: com.google.android.exoplayer2.ui.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1892a.O();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(View view) {
        S();
        if (view.getId() == R$id.exo_overflow_show) {
            this.f1918q.start();
        } else if (view.getId() == R$id.exo_overflow_hide) {
            this.f1919r.start();
        }
    }

    private boolean W(View view) {
        int id2 = view.getId();
        if (id2 != R$id.exo_bottom_bar && id2 != R$id.exo_prev && id2 != R$id.exo_next && id2 != R$id.exo_rew && id2 != R$id.exo_rew_with_amount && id2 != R$id.exo_ffwd && id2 != R$id.exo_ffwd_with_amount) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void b(v vVar, ValueAnimator valueAnimator) {
        vVar.getClass();
        vVar.y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static /* synthetic */ void d(v vVar, ValueAnimator valueAnimator) {
        vVar.getClass();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = vVar.f1903b;
        if (view != null) {
            view.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup = vVar.f1904c;
        if (viewGroup != null) {
            viewGroup.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup2 = vVar.f1906e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(fFloatValue);
        }
    }

    public static /* synthetic */ void g(v vVar, ValueAnimator valueAnimator) {
        vVar.getClass();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = vVar.f1903b;
        if (view != null) {
            view.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup = vVar.f1904c;
        if (viewGroup != null) {
            viewGroup.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup2 = vVar.f1906e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(fFloatValue);
        }
    }

    public static /* synthetic */ void m(v vVar, ValueAnimator valueAnimator) {
        vVar.getClass();
        vVar.y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
