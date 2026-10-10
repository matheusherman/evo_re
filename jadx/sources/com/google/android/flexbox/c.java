package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.widget.CompoundButtonCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.flexbox.a f2066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean[] f2067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    int[] f2068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    long[] f2069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private long[] f2070e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.google.android.flexbox.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class C0041c implements Comparable<C0041c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2074b;

        private C0041c() {
        }

        /* synthetic */ C0041c(a aVar) {
            this();
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NonNull C0041c c0041c) {
            int i10 = this.f2074b;
            int i11 = c0041c.f2074b;
            return i10 != i11 ? i10 - i11 : this.f2073a - c0041c.f2073a;
        }

        @NonNull
        public String toString() {
            return "Order{order=" + this.f2074b + ", index=" + this.f2073a + '}';
        }
    }

    private boolean N(int i10, int i11, com.google.android.flexbox.b bVar) {
        return i10 == i11 - 1 && bVar.c() != 0;
    }

    private List<com.google.android.flexbox.b> k(List<com.google.android.flexbox.b> list, int i10, int i11) {
        int i12 = (i10 - i11) / 2;
        ArrayList arrayList = new ArrayList();
        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
        bVar.f2054g = i12;
        int size = list.size();
        for (int i13 = 0; i13 < size; i13++) {
            if (i13 == 0) {
                arrayList.add(bVar);
            }
            arrayList.add(list.get(i13));
            if (i13 == list.size() - 1) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @VisibleForTesting
    long S(int i10, int i11) {
        return (((long) i10) & 4294967295L) | (((long) i11) << 32);
    }

    void X() {
        Y(0);
    }

    void c(b bVar, int i10, int i11) {
        b(bVar, i10, i11, Integer.MAX_VALUE, 0, -1, null);
    }

    void d(b bVar, int i10, int i11, int i12, int i13, @Nullable List<com.google.android.flexbox.b> list) {
        b(bVar, i10, i11, i12, i13, -1, list);
    }

    void e(b bVar, int i10, int i11, int i12, int i13, List<com.google.android.flexbox.b> list) {
        b(bVar, i10, i11, i12, 0, i13, list);
    }

    void f(b bVar, int i10, int i11) {
        b(bVar, i11, i10, Integer.MAX_VALUE, 0, -1, null);
    }

    void g(b bVar, int i10, int i11, int i12, int i13, @Nullable List<com.google.android.flexbox.b> list) {
        b(bVar, i11, i10, i12, i13, -1, list);
    }

    void h(b bVar, int i10, int i11, int i12, int i13, List<com.google.android.flexbox.b> list) {
        b(bVar, i11, i10, i12, 0, i13, list);
    }

    void p(int i10, int i11) {
        q(i10, i11, 0);
    }

    int y(long j10) {
        return (int) j10;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<com.google.android.flexbox.b> f2071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2072b;

        void a() {
            this.f2071a = null;
            this.f2072b = 0;
        }

        b() {
        }
    }

    private int A(int i10, FlexItem flexItem, int i11) {
        com.google.android.flexbox.a aVar = this.f2066a;
        int iB = aVar.b(i10, aVar.getPaddingLeft() + this.f2066a.getPaddingRight() + flexItem.q() + flexItem.x() + i11, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(iB);
        if (size > flexItem.C()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.C(), View.MeasureSpec.getMode(iB));
        }
        return size < flexItem.m() ? View.MeasureSpec.makeMeasureSpec(flexItem.m(), View.MeasureSpec.getMode(iB)) : iB;
    }

    private int B(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.o() : flexItem.x();
    }

    private int C(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.x() : flexItem.o();
    }

    private int D(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.s() : flexItem.q();
    }

    private int E(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.q() : flexItem.s();
    }

    private int F(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.getHeight() : flexItem.getWidth();
    }

    private int G(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.getWidth() : flexItem.getHeight();
    }

    private int H(boolean z10) {
        return z10 ? this.f2066a.getPaddingBottom() : this.f2066a.getPaddingEnd();
    }

    private int I(boolean z10) {
        return z10 ? this.f2066a.getPaddingEnd() : this.f2066a.getPaddingBottom();
    }

    private int J(boolean z10) {
        return z10 ? this.f2066a.getPaddingTop() : this.f2066a.getPaddingStart();
    }

    private int K(boolean z10) {
        return z10 ? this.f2066a.getPaddingStart() : this.f2066a.getPaddingTop();
    }

    private int L(View view, boolean z10) {
        return z10 ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    private int M(View view, boolean z10) {
        return z10 ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private boolean P(View view, int i10, int i11, int i12, int i13, FlexItem flexItem, int i14, int i15, int i16) {
        if (this.f2066a.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.z()) {
            return true;
        }
        if (i10 == 0) {
            return false;
        }
        int maxLine = this.f2066a.getMaxLine();
        if (maxLine != -1 && maxLine <= i16 + 1) {
            return false;
        }
        int iE = this.f2066a.e(view, i14, i15);
        if (iE > 0) {
            i13 += iE;
        }
        return i11 < i12 + i13;
    }

    private void T(int i10, int i11, com.google.android.flexbox.b bVar, int i12, int i13, boolean z10) {
        float f10;
        int iMax;
        int iM;
        int i14 = bVar.f2052e;
        float f11 = bVar.f2058k;
        if (f11 <= 0.0f || i12 > i14) {
            return;
        }
        float f12 = (i14 - i12) / f11;
        bVar.f2052e = i13 + bVar.f2053f;
        if (!z10) {
            bVar.f2054g = Integer.MIN_VALUE;
        }
        int i15 = 0;
        boolean z11 = false;
        int i16 = 0;
        float f13 = 0.0f;
        while (i15 < bVar.f2055h) {
            int i17 = bVar.f2062o + i15;
            View viewA = this.f2066a.a(i17);
            if (viewA == null || viewA.getVisibility() == 8) {
                f10 = f12;
            } else {
                FlexItem flexItem = (FlexItem) viewA.getLayoutParams();
                int flexDirection = this.f2066a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int measuredWidth = viewA.getMeasuredWidth();
                    long[] jArr = this.f2070e;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i17]);
                    }
                    int measuredHeight = viewA.getMeasuredHeight();
                    long[] jArr2 = this.f2070e;
                    f10 = f12;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i17]);
                    }
                    if (!this.f2067b[i17] && flexItem.k() > 0.0f) {
                        float fK = measuredWidth - (f10 * flexItem.k());
                        if (i15 == bVar.f2055h - 1) {
                            fK += f13;
                            f13 = 0.0f;
                        }
                        int iRound = Math.round(fK);
                        if (iRound < flexItem.m()) {
                            iM = flexItem.m();
                            this.f2067b[i17] = true;
                            bVar.f2058k -= flexItem.k();
                            z11 = true;
                        } else {
                            f13 += fK - iRound;
                            double d10 = f13;
                            if (d10 > 1.0d) {
                                iM = iRound + 1;
                                f13 -= 1.0f;
                            } else if (d10 < -1.0d) {
                                iM = iRound - 1;
                                f13 += 1.0f;
                            } else {
                                iM = iRound;
                            }
                        }
                        int iZ = z(i11, flexItem, bVar.f2060m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iM, BasicMeasure.EXACTLY);
                        viewA.measure(iMakeMeasureSpec, iZ);
                        int measuredWidth2 = viewA.getMeasuredWidth();
                        int measuredHeight2 = viewA.getMeasuredHeight();
                        Z(i17, iMakeMeasureSpec, iZ, viewA);
                        this.f2066a.c(i17, viewA);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i16, measuredHeight + flexItem.s() + flexItem.o() + this.f2066a.h(viewA));
                    bVar.f2052e += measuredWidth + flexItem.q() + flexItem.x();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewA.getMeasuredHeight();
                    long[] jArr3 = this.f2070e;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i17]);
                    }
                    int measuredWidth3 = viewA.getMeasuredWidth();
                    long[] jArr4 = this.f2070e;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i17]);
                    }
                    if (!this.f2067b[i17] && flexItem.k() > 0.0f) {
                        float fK2 = measuredHeight3 - (flexItem.k() * f12);
                        if (i15 == bVar.f2055h - 1) {
                            fK2 += f13;
                            f13 = 0.0f;
                        }
                        int iRound2 = Math.round(fK2);
                        if (iRound2 < flexItem.y()) {
                            iRound2 = flexItem.y();
                            this.f2067b[i17] = true;
                            bVar.f2058k -= flexItem.k();
                            z11 = true;
                        } else {
                            f13 += fK2 - iRound2;
                            double d11 = f13;
                            if (d11 > 1.0d) {
                                iRound2++;
                                f13 -= 1.0f;
                            } else if (d11 < -1.0d) {
                                iRound2--;
                                f13 += 1.0f;
                            }
                        }
                        int iA = A(i10, flexItem, bVar.f2060m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, BasicMeasure.EXACTLY);
                        viewA.measure(iA, iMakeMeasureSpec2);
                        int measuredWidth4 = viewA.getMeasuredWidth();
                        int measuredHeight4 = viewA.getMeasuredHeight();
                        Z(i17, iA, iMakeMeasureSpec2, viewA);
                        this.f2066a.c(i17, viewA);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i16, measuredWidth3 + flexItem.q() + flexItem.x() + this.f2066a.h(viewA));
                    bVar.f2052e += measuredHeight3 + flexItem.s() + flexItem.o();
                    f10 = f12;
                }
                bVar.f2054g = Math.max(bVar.f2054g, iMax);
                i16 = iMax;
            }
            i15++;
            f12 = f10;
        }
        if (!z11 || i14 == bVar.f2052e) {
            return;
        }
        T(i10, i11, bVar, i12, i13, true);
    }

    private void Z(int i10, int i11, int i12, View view) {
        long[] jArr = this.f2069d;
        if (jArr != null) {
            jArr[i10] = S(i11, i12);
        }
        long[] jArr2 = this.f2070e;
        if (jArr2 != null) {
            jArr2[i10] = S(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private void a(List<com.google.android.flexbox.b> list, com.google.android.flexbox.b bVar, int i10, int i11) {
        bVar.f2060m = i11;
        this.f2066a.k(bVar);
        bVar.f2063p = i10;
        list.add(bVar);
    }

    @NonNull
    private List<C0041c> l(int i10) {
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            FlexItem flexItem = (FlexItem) this.f2066a.d(i11).getLayoutParams();
            C0041c c0041c = new C0041c(null);
            c0041c.f2074b = flexItem.getOrder();
            c0041c.f2073a = i11;
            arrayList.add(c0041c);
        }
        return arrayList;
    }

    private void r(int i10) {
        boolean[] zArr = this.f2067b;
        if (zArr == null) {
            this.f2067b = new boolean[Math.max(i10, 10)];
        } else if (zArr.length < i10) {
            this.f2067b = new boolean[Math.max(zArr.length * 2, i10)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void w(int i10, int i11, com.google.android.flexbox.b bVar, int i12, int i13, boolean z10) {
        int i14;
        float f10;
        int iMax;
        double d10;
        double d11;
        float f11 = bVar.f2057j;
        if (f11 <= 0.0f || i12 < (i14 = bVar.f2052e)) {
            return;
        }
        float f12 = (i12 - i14) / f11;
        bVar.f2052e = i13 + bVar.f2053f;
        if (!z10) {
            bVar.f2054g = Integer.MIN_VALUE;
        }
        int i15 = 0;
        boolean z11 = false;
        int i16 = 0;
        float f13 = 0.0f;
        while (i15 < bVar.f2055h) {
            int i17 = bVar.f2062o + i15;
            View viewA = this.f2066a.a(i17);
            if (viewA == null || viewA.getVisibility() == 8) {
                f10 = f12;
                z11 = z11;
            } else {
                FlexItem flexItem = (FlexItem) viewA.getLayoutParams();
                int flexDirection = this.f2066a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    f10 = f12;
                    boolean z12 = z11;
                    int measuredWidth = viewA.getMeasuredWidth();
                    long[] jArr = this.f2070e;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i17]);
                    }
                    int measuredHeight = viewA.getMeasuredHeight();
                    long[] jArr2 = this.f2070e;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i17]);
                    }
                    if (this.f2067b[i17] || flexItem.u() <= 0.0f) {
                        z11 = z12;
                    } else {
                        float fU = measuredWidth + (flexItem.u() * f10);
                        if (i15 == bVar.f2055h - 1) {
                            fU += f13;
                            f13 = 0.0f;
                        }
                        int iRound = Math.round(fU);
                        if (iRound > flexItem.C()) {
                            iRound = flexItem.C();
                            this.f2067b[i17] = true;
                            bVar.f2057j -= flexItem.u();
                            z11 = true;
                        } else {
                            f13 += fU - iRound;
                            double d12 = f13;
                            if (d12 > 1.0d) {
                                iRound++;
                                d10 = d12 - 1.0d;
                            } else {
                                if (d12 < -1.0d) {
                                    iRound--;
                                    d10 = d12 + 1.0d;
                                }
                                z11 = z12;
                            }
                            f13 = (float) d10;
                            z11 = z12;
                        }
                        int iZ = z(i11, flexItem, bVar.f2060m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, BasicMeasure.EXACTLY);
                        viewA.measure(iMakeMeasureSpec, iZ);
                        int measuredWidth2 = viewA.getMeasuredWidth();
                        int measuredHeight2 = viewA.getMeasuredHeight();
                        Z(i17, iMakeMeasureSpec, iZ, viewA);
                        this.f2066a.c(i17, viewA);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i16, measuredHeight + flexItem.s() + flexItem.o() + this.f2066a.h(viewA));
                    bVar.f2052e += measuredWidth + flexItem.q() + flexItem.x();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewA.getMeasuredHeight();
                    long[] jArr3 = this.f2070e;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i17]);
                    }
                    int measuredWidth3 = viewA.getMeasuredWidth();
                    long[] jArr4 = this.f2070e;
                    f10 = f12;
                    boolean z13 = z11;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i17]);
                    }
                    if (this.f2067b[i17] || flexItem.u() <= 0.0f) {
                        z11 = z13;
                    } else {
                        float fU2 = measuredHeight3 + (flexItem.u() * f10);
                        if (i15 == bVar.f2055h - 1) {
                            fU2 += f13;
                            f13 = 0.0f;
                        }
                        int iRound2 = Math.round(fU2);
                        if (iRound2 > flexItem.A()) {
                            iRound2 = flexItem.A();
                            this.f2067b[i17] = true;
                            bVar.f2057j -= flexItem.u();
                            z11 = true;
                        } else {
                            f13 += fU2 - iRound2;
                            double d13 = f13;
                            if (d13 > 1.0d) {
                                iRound2++;
                                d11 = d13 - 1.0d;
                            } else {
                                if (d13 < -1.0d) {
                                    iRound2--;
                                    d11 = d13 + 1.0d;
                                }
                                z11 = z13;
                            }
                            f13 = (float) d11;
                            z11 = z13;
                        }
                        int iA = A(i10, flexItem, bVar.f2060m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, BasicMeasure.EXACTLY);
                        viewA.measure(iA, iMakeMeasureSpec2);
                        int measuredWidth4 = viewA.getMeasuredWidth();
                        int measuredHeight4 = viewA.getMeasuredHeight();
                        Z(i17, iA, iMakeMeasureSpec2, viewA);
                        this.f2066a.c(i17, viewA);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i16, measuredWidth3 + flexItem.q() + flexItem.x() + this.f2066a.h(viewA));
                    bVar.f2052e += measuredHeight3 + flexItem.s() + flexItem.o();
                }
                bVar.f2054g = Math.max(bVar.f2054g, iMax);
                i16 = iMax;
            }
            i15++;
            f12 = f10;
        }
        if (!z11 || i14 == bVar.f2052e) {
            return;
        }
        w(i10, i11, bVar, i12, i13, true);
    }

    private int z(int i10, FlexItem flexItem, int i11) {
        com.google.android.flexbox.a aVar = this.f2066a;
        int iF = aVar.f(i10, aVar.getPaddingTop() + this.f2066a.getPaddingBottom() + flexItem.s() + flexItem.o() + i11, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(iF);
        if (size > flexItem.A()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.A(), View.MeasureSpec.getMode(iF));
        }
        return size < flexItem.y() ? View.MeasureSpec.makeMeasureSpec(flexItem.y(), View.MeasureSpec.getMode(iF)) : iF;
    }

    boolean O(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f2066a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i10 = 0; i10 < flexItemCount; i10++) {
            View viewD = this.f2066a.d(i10);
            if (viewD != null && ((FlexItem) viewD.getLayoutParams()).getOrder() != sparseIntArray.get(i10)) {
                return true;
            }
        }
        return false;
    }

    void Y(int i10) {
        View viewA;
        if (i10 >= this.f2066a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f2066a.getFlexDirection();
        if (this.f2066a.getAlignItems() != 4) {
            for (com.google.android.flexbox.b bVar : this.f2066a.getFlexLinesInternal()) {
                for (Integer num : bVar.f2061n) {
                    View viewA2 = this.f2066a.a(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        W(viewA2, bVar.f2054g, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                        }
                        V(viewA2, bVar.f2054g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.f2068c;
        List<com.google.android.flexbox.b> flexLinesInternal = this.f2066a.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i11 = iArr != null ? iArr[i10] : 0; i11 < size; i11++) {
            com.google.android.flexbox.b bVar2 = flexLinesInternal.get(i11);
            int i12 = bVar2.f2055h;
            for (int i13 = 0; i13 < i12; i13++) {
                int i14 = bVar2.f2062o + i13;
                if (i13 < this.f2066a.getFlexItemCount() && (viewA = this.f2066a.a(i14)) != null && viewA.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) viewA.getLayoutParams();
                    if (flexItem.i() == -1 || flexItem.i() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            W(viewA, bVar2.f2054g, i14);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                            }
                            V(viewA, bVar2.f2054g, i14);
                        }
                    }
                }
            }
        }
    }

    void b(b bVar, int i10, int i11, int i12, int i13, int i14, @Nullable List<com.google.android.flexbox.b> list) {
        int i15;
        int i16;
        int i17;
        int iB;
        int i18;
        int i19;
        int i20;
        com.google.android.flexbox.b bVar2;
        int i21;
        int i22;
        boolean z10;
        int i23;
        boolean z11;
        int i24;
        int i25 = i10;
        boolean zG = this.f2066a.g();
        int mode = View.MeasureSpec.getMode(i25);
        int size = View.MeasureSpec.getSize(i25);
        List<com.google.android.flexbox.b> arrayList = list == null ? new ArrayList() : list;
        bVar.f2071a = arrayList;
        boolean z12 = i14 == -1;
        int iK = K(zG);
        int I = I(zG);
        int iJ = J(zG);
        int iH = H(zG);
        com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
        int i26 = i13;
        bVar3.f2062o = i26;
        int i27 = iK + I;
        bVar3.f2052e = i27;
        int flexItemCount = this.f2066a.getFlexItemCount();
        boolean z13 = z12;
        com.google.android.flexbox.b bVar4 = bVar3;
        int i28 = 0;
        int iCombineMeasuredStates = 0;
        int i29 = 0;
        int i30 = Integer.MIN_VALUE;
        while (i26 < flexItemCount) {
            View viewA = this.f2066a.a(i26);
            if (viewA == null) {
                if (N(i26, flexItemCount, bVar4)) {
                    a(arrayList, bVar4, i26, i28);
                }
                i16 = i27;
            } else {
                i16 = i27;
                if (viewA.getVisibility() == 8) {
                    bVar4.f2056i++;
                    bVar4.f2055h++;
                    if (N(i26, flexItemCount, bVar4)) {
                        a(arrayList, bVar4, i26, i28);
                    }
                } else {
                    if (viewA instanceof CompoundButton) {
                        v((CompoundButton) viewA);
                    }
                    FlexItem flexItem = (FlexItem) viewA.getLayoutParams();
                    int i31 = flexItemCount;
                    if (flexItem.i() == 4) {
                        bVar4.f2061n.add(Integer.valueOf(i26));
                    }
                    int iG = G(flexItem, zG);
                    if (flexItem.v() != -1.0f && mode == 1073741824) {
                        iG = Math.round(size * flexItem.v());
                    }
                    if (zG) {
                        iB = this.f2066a.b(i25, i16 + E(flexItem, true) + C(flexItem, true), iG);
                        i17 = i28;
                        int iF = this.f2066a.f(i11, iJ + iH + D(flexItem, true) + B(flexItem, true) + i28, F(flexItem, true));
                        viewA.measure(iB, iF);
                        Z(i26, iB, iF, viewA);
                    } else {
                        i17 = i28;
                        int iB2 = this.f2066a.b(i11, iJ + iH + D(flexItem, false) + B(flexItem, false) + i17, F(flexItem, false));
                        int iF2 = this.f2066a.f(i25, i16 + E(flexItem, false) + C(flexItem, false), iG);
                        viewA.measure(iB2, iF2);
                        Z(i26, iB2, iF2, viewA);
                        iB = iF2;
                    }
                    this.f2066a.c(i26, viewA);
                    i(viewA, i26);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewA.getMeasuredState());
                    i18 = i26;
                    int i32 = iB;
                    com.google.android.flexbox.b bVar5 = bVar4;
                    int i33 = i29;
                    i19 = i16;
                    i20 = i17;
                    boolean z14 = zG;
                    size = size;
                    if (P(viewA, mode, size, bVar4.f2052e, M(viewA, zG) + E(flexItem, zG) + C(flexItem, zG), flexItem, i18, i33, arrayList.size())) {
                        if (bVar5.c() > 0) {
                            a(arrayList, bVar5, i18 > 0 ? i18 - 1 : 0, i20);
                            i24 = i20 + bVar5.f2054g;
                        } else {
                            i24 = i20;
                        }
                        if (z14) {
                            if (flexItem.getHeight() == -1) {
                                com.google.android.flexbox.a aVar = this.f2066a;
                                viewA.measure(i32, aVar.f(i11, aVar.getPaddingTop() + this.f2066a.getPaddingBottom() + flexItem.s() + flexItem.o() + i24, flexItem.getHeight()));
                                i(viewA, i18);
                            }
                        } else if (flexItem.getWidth() == -1) {
                            com.google.android.flexbox.a aVar2 = this.f2066a;
                            viewA.measure(aVar2.b(i11, aVar2.getPaddingLeft() + this.f2066a.getPaddingRight() + flexItem.q() + flexItem.x() + i24, flexItem.getWidth()), i32);
                            i(viewA, i18);
                        }
                        com.google.android.flexbox.b bVar6 = new com.google.android.flexbox.b();
                        bVar6.f2055h = 1;
                        bVar6.f2052e = i19;
                        bVar6.f2062o = i18;
                        i20 = i24;
                        i21 = 0;
                        bVar2 = bVar6;
                        i22 = Integer.MIN_VALUE;
                    } else {
                        bVar2 = bVar5;
                        bVar2.f2055h++;
                        i21 = i33 + 1;
                        i22 = i30;
                    }
                    bVar2.f2064q |= flexItem.u() != 0.0f;
                    bVar2.f2065r |= flexItem.k() != 0.0f;
                    int[] iArr = this.f2068c;
                    if (iArr != null) {
                        iArr[i18] = arrayList.size();
                    }
                    z10 = z14;
                    bVar2.f2052e += M(viewA, z10) + E(flexItem, z10) + C(flexItem, z10);
                    bVar2.f2057j += flexItem.u();
                    bVar2.f2058k += flexItem.k();
                    this.f2066a.i(viewA, i18, i21, bVar2);
                    int iMax = Math.max(i22, L(viewA, z10) + D(flexItem, z10) + B(flexItem, z10) + this.f2066a.h(viewA));
                    bVar2.f2054g = Math.max(bVar2.f2054g, iMax);
                    if (z10) {
                        if (this.f2066a.getFlexWrap() != 2) {
                            bVar2.f2059l = Math.max(bVar2.f2059l, viewA.getBaseline() + flexItem.s());
                        } else {
                            bVar2.f2059l = Math.max(bVar2.f2059l, (viewA.getMeasuredHeight() - viewA.getBaseline()) + flexItem.o());
                        }
                    }
                    i23 = i31;
                    if (N(i18, i23, bVar2)) {
                        a(arrayList, bVar2, i18, i20);
                        i20 += bVar2.f2054g;
                    }
                    if (i14 != -1 && arrayList.size() > 0) {
                        if (arrayList.get(arrayList.size() - 1).f2063p >= i14 && i18 >= i14 && !z13) {
                            i20 = -bVar2.a();
                            z11 = true;
                        }
                        if (i20 <= i12 && z11) {
                            i15 = iCombineMeasuredStates;
                            bVar.f2072b = i15;
                        } else {
                            i30 = iMax;
                            z13 = z11;
                            i29 = i21;
                        }
                    }
                    z11 = z13;
                    if (i20 <= i12) {
                    }
                    i30 = iMax;
                    z13 = z11;
                    i29 = i21;
                }
                int i34 = i18 + 1;
                zG = z10;
                bVar4 = bVar2;
                i27 = i19;
                i28 = i20;
                i25 = i10;
                flexItemCount = i23;
                i26 = i34;
                mode = mode;
            }
            i18 = i26;
            mode = mode;
            i23 = flexItemCount;
            i20 = i28;
            z10 = zG;
            i19 = i16;
            bVar2 = bVar4;
            int i35 = i18 + 1;
            zG = z10;
            bVar4 = bVar2;
            i27 = i19;
            i28 = i20;
            i25 = i10;
            flexItemCount = i23;
            i26 = i35;
            mode = mode;
        }
        i15 = iCombineMeasuredStates;
        bVar.f2072b = i15;
    }

    void j(List<com.google.android.flexbox.b> list, int i10) {
        int i11 = this.f2068c[i10];
        if (i11 == -1) {
            i11 = 0;
        }
        if (list.size() > i11) {
            list.subList(i11, list.size()).clear();
        }
        int[] iArr = this.f2068c;
        int length = iArr.length - 1;
        if (i10 > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i10, length, -1);
        }
        long[] jArr = this.f2069d;
        int length2 = jArr.length - 1;
        if (i10 > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i10, length2, 0L);
        }
    }

    int[] m(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f2066a.getFlexItemCount();
        return U(flexItemCount, l(flexItemCount), sparseIntArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    int[] n(View view, int i10, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.f2066a.getFlexItemCount();
        List<C0041c> listL = l(flexItemCount);
        C0041c c0041c = new C0041c(null);
        if (view == null || !(layoutParams instanceof FlexItem)) {
            c0041c.f2074b = 1;
        } else {
            c0041c.f2074b = ((FlexItem) layoutParams).getOrder();
        }
        if (i10 == -1 || i10 == flexItemCount || i10 >= this.f2066a.getFlexItemCount()) {
            c0041c.f2073a = flexItemCount;
        } else {
            c0041c.f2073a = i10;
            while (i10 < flexItemCount) {
                listL.get(i10).f2073a++;
                i10++;
            }
        }
        listL.add(c0041c);
        return U(flexItemCount + 1, listL, sparseIntArray);
    }

    void o(int i10, int i11, int i12) {
        int mode;
        int size;
        int flexDirection = this.f2066a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(i11);
            int size2 = View.MeasureSpec.getSize(i11);
            mode = mode2;
            size = size2;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            mode = View.MeasureSpec.getMode(i10);
            size = View.MeasureSpec.getSize(i10);
        }
        List<com.google.android.flexbox.b> flexLinesInternal = this.f2066a.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.f2066a.getSumOfCrossSize() + i12;
            int i13 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).f2054g = size - i12;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f2066a.getAlignContent();
                if (alignContent == 1) {
                    int i14 = size - sumOfCrossSize;
                    com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
                    bVar.f2054g = i14;
                    flexLinesInternal.add(0, bVar);
                    return;
                }
                if (alignContent == 2) {
                    this.f2066a.setFlexLines(k(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize >= size) {
                        return;
                    }
                    float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size4 = flexLinesInternal.size();
                    float f10 = 0.0f;
                    while (i13 < size4) {
                        arrayList.add(flexLinesInternal.get(i13));
                        if (i13 != flexLinesInternal.size() - 1) {
                            com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
                            if (i13 == flexLinesInternal.size() - 2) {
                                bVar2.f2054g = Math.round(f10 + size3);
                                f10 = 0.0f;
                            } else {
                                bVar2.f2054g = Math.round(size3);
                            }
                            int i15 = bVar2.f2054g;
                            f10 += size3 - i15;
                            if (f10 > 1.0f) {
                                bVar2.f2054g = i15 + 1;
                                f10 -= 1.0f;
                            } else if (f10 < -1.0f) {
                                bVar2.f2054g = i15 - 1;
                                f10 += 1.0f;
                            }
                            arrayList.add(bVar2);
                        }
                        i13++;
                    }
                    this.f2066a.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.f2066a.setFlexLines(k(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                    bVar3.f2054g = size5;
                    for (com.google.android.flexbox.b bVar4 : flexLinesInternal) {
                        arrayList2.add(bVar3);
                        arrayList2.add(bVar4);
                        arrayList2.add(bVar3);
                    }
                    this.f2066a.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f11 = 0.0f;
                    while (i13 < size7) {
                        com.google.android.flexbox.b bVar5 = flexLinesInternal.get(i13);
                        float f12 = bVar5.f2054g + size6;
                        if (i13 == flexLinesInternal.size() - 1) {
                            f12 += f11;
                            f11 = 0.0f;
                        }
                        int iRound = Math.round(f12);
                        f11 += f12 - iRound;
                        if (f11 > 1.0f) {
                            iRound++;
                            f11 -= 1.0f;
                        } else if (f11 < -1.0f) {
                            iRound--;
                            f11 += 1.0f;
                        }
                        bVar5.f2054g = iRound;
                        i13++;
                    }
                }
            }
        }
    }

    void q(int i10, int i11, int i12) {
        int size;
        int paddingLeft;
        int paddingRight;
        int i13;
        int i14;
        r(this.f2066a.getFlexItemCount());
        if (i12 >= this.f2066a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f2066a.getFlexDirection();
        int flexDirection2 = this.f2066a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i10);
            size = View.MeasureSpec.getSize(i10);
            int largestMainSize = this.f2066a.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.f2066a.getPaddingLeft();
            paddingRight = this.f2066a.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int mode2 = View.MeasureSpec.getMode(i11);
            size = View.MeasureSpec.getSize(i11);
            if (mode2 != 1073741824) {
                size = this.f2066a.getLargestMainSize();
            }
            paddingLeft = this.f2066a.getPaddingTop();
            paddingRight = this.f2066a.getPaddingBottom();
        }
        int i15 = paddingLeft + paddingRight;
        int i16 = size;
        int[] iArr = this.f2068c;
        int i17 = iArr != null ? iArr[i12] : 0;
        List<com.google.android.flexbox.b> flexLinesInternal = this.f2066a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        while (i17 < size2) {
            com.google.android.flexbox.b bVar = flexLinesInternal.get(i17);
            int i18 = bVar.f2052e;
            if (i18 >= i16 || !bVar.f2064q) {
                i13 = i10;
                i14 = i11;
                if (i18 > i16 && bVar.f2065r) {
                    T(i13, i14, bVar, i16, i15, false);
                }
            } else {
                i13 = i10;
                i14 = i11;
                w(i13, i14, bVar, i16, i15, false);
            }
            i17++;
            i10 = i13;
            i11 = i14;
        }
    }

    void s(int i10) {
        int[] iArr = this.f2068c;
        if (iArr == null) {
            this.f2068c = new int[Math.max(i10, 10)];
        } else if (iArr.length < i10) {
            this.f2068c = Arrays.copyOf(this.f2068c, Math.max(iArr.length * 2, i10));
        }
    }

    void t(int i10) {
        long[] jArr = this.f2069d;
        if (jArr == null) {
            this.f2069d = new long[Math.max(i10, 10)];
        } else if (jArr.length < i10) {
            this.f2069d = Arrays.copyOf(this.f2069d, Math.max(jArr.length * 2, i10));
        }
    }

    void u(int i10) {
        long[] jArr = this.f2070e;
        if (jArr == null) {
            this.f2070e = new long[Math.max(i10, 10)];
        } else if (jArr.length < i10) {
            this.f2070e = Arrays.copyOf(this.f2070e, Math.max(jArr.length * 2, i10));
        }
    }

    int x(long j10) {
        return (int) (j10 >> 32);
    }

    c(com.google.android.flexbox.a aVar) {
        this.f2066a = aVar;
    }

    private int[] U(int i10, List<C0041c> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i10];
        int i11 = 0;
        for (C0041c c0041c : list) {
            int i12 = c0041c.f2073a;
            iArr[i11] = i12;
            sparseIntArray.append(i12, c0041c.f2074b);
            i11++;
        }
        return iArr;
    }

    private void V(View view, int i10, int i11) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i10 - flexItem.q()) - flexItem.x()) - this.f2066a.h(view), flexItem.m()), flexItem.C());
        long[] jArr = this.f2070e;
        if (jArr != null) {
            measuredHeight = x(jArr[i11]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, BasicMeasure.EXACTLY);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, BasicMeasure.EXACTLY);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        Z(i11, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.f2066a.c(i11, view);
    }

    private void W(View view, int i10, int i11) {
        int measuredWidth;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i10 - flexItem.s()) - flexItem.o()) - this.f2066a.h(view), flexItem.y()), flexItem.A());
        long[] jArr = this.f2070e;
        if (jArr != null) {
            measuredWidth = y(jArr[i11]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, BasicMeasure.EXACTLY);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, BasicMeasure.EXACTLY);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        Z(i11, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.f2066a.c(i11, view);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    /* JADX WARN: Code duplicated, block: B:16:0x003d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    private void i(View view, int i10) {
        boolean z10;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z11 = true;
        if (measuredWidth < flexItem.m()) {
            measuredWidth = flexItem.m();
        } else {
            if (measuredWidth > flexItem.C()) {
                measuredWidth = flexItem.C();
            } else {
                z10 = false;
            }
            if (measuredHeight < flexItem.y()) {
                measuredHeight = flexItem.y();
            } else if (measuredHeight > flexItem.A()) {
                measuredHeight = flexItem.A();
            } else {
                z11 = z10;
            }
            if (z11) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, BasicMeasure.EXACTLY);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, BasicMeasure.EXACTLY);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                Z(i10, iMakeMeasureSpec, iMakeMeasureSpec2, view);
                this.f2066a.c(i10, view);
            }
        }
        z10 = true;
        if (measuredHeight < flexItem.y()) {
            measuredHeight = flexItem.y();
        } else if (measuredHeight > flexItem.A()) {
            measuredHeight = flexItem.A();
        } else {
            z11 = z10;
        }
        if (z11) {
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, BasicMeasure.EXACTLY);
            int iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(measuredHeight, BasicMeasure.EXACTLY);
            view.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
            Z(i10, iMakeMeasureSpec3, iMakeMeasureSpec4, view);
            this.f2066a.c(i10, view);
        }
    }

    private void v(CompoundButton compoundButton) {
        int minimumWidth;
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int iM = flexItem.m();
        int iY = flexItem.y();
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(compoundButton);
        int minimumHeight = 0;
        if (buttonDrawable == null) {
            minimumWidth = 0;
        } else {
            minimumWidth = buttonDrawable.getMinimumWidth();
        }
        if (buttonDrawable != null) {
            minimumHeight = buttonDrawable.getMinimumHeight();
        }
        if (iM == -1) {
            iM = minimumWidth;
        }
        flexItem.n(iM);
        if (iY == -1) {
            iY = minimumHeight;
        }
        flexItem.t(iY);
    }

    void Q(View view, com.google.android.flexbox.b bVar, int i10, int i11, int i12, int i13) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f2066a.getAlignItems();
        if (flexItem.i() != -1) {
            alignItems = flexItem.i();
        }
        int i14 = bVar.f2054g;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems != 2) {
                    if (alignItems != 3) {
                        if (alignItems != 4) {
                            return;
                        }
                    } else if (this.f2066a.getFlexWrap() != 2) {
                        int iMax = Math.max(bVar.f2059l - view.getBaseline(), flexItem.s());
                        view.layout(i10, i11 + iMax, i12, i13 + iMax);
                        return;
                    } else {
                        int iMax2 = Math.max((bVar.f2059l - view.getMeasuredHeight()) + view.getBaseline(), flexItem.o());
                        view.layout(i10, i11 - iMax2, i12, i13 - iMax2);
                        return;
                    }
                } else {
                    int measuredHeight = (((i14 - view.getMeasuredHeight()) + flexItem.s()) - flexItem.o()) / 2;
                    if (this.f2066a.getFlexWrap() != 2) {
                        int i15 = i11 + measuredHeight;
                        view.layout(i10, i15, i12, view.getMeasuredHeight() + i15);
                        return;
                    } else {
                        int i16 = i11 - measuredHeight;
                        view.layout(i10, i16, i12, view.getMeasuredHeight() + i16);
                        return;
                    }
                }
            } else if (this.f2066a.getFlexWrap() != 2) {
                int i17 = i11 + i14;
                view.layout(i10, (i17 - view.getMeasuredHeight()) - flexItem.o(), i12, i17 - flexItem.o());
                return;
            } else {
                view.layout(i10, (i11 - i14) + view.getMeasuredHeight() + flexItem.s(), i12, (i13 - i14) + view.getMeasuredHeight() + flexItem.s());
                return;
            }
        }
        if (this.f2066a.getFlexWrap() != 2) {
            view.layout(i10, i11 + flexItem.s(), i12, i13 + flexItem.s());
        } else {
            view.layout(i10, i11 - flexItem.o(), i12, i13 - flexItem.o());
        }
    }

    void R(View view, com.google.android.flexbox.b bVar, boolean z10, int i10, int i11, int i12, int i13) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f2066a.getAlignItems();
        if (flexItem.i() != -1) {
            alignItems = flexItem.i();
        }
        int i14 = bVar.f2054g;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems != 2) {
                    if (alignItems != 3 && alignItems != 4) {
                        return;
                    }
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int measuredWidth = (((i14 - view.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams)) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                    if (!z10) {
                        view.layout(i10 + measuredWidth, i11, i12 + measuredWidth, i13);
                        return;
                    } else {
                        view.layout(i10 - measuredWidth, i11, i12 - measuredWidth, i13);
                        return;
                    }
                }
            } else if (!z10) {
                view.layout(((i10 + i14) - view.getMeasuredWidth()) - flexItem.x(), i11, ((i12 + i14) - view.getMeasuredWidth()) - flexItem.x(), i13);
                return;
            } else {
                view.layout((i10 - i14) + view.getMeasuredWidth() + flexItem.q(), i11, (i12 - i14) + view.getMeasuredWidth() + flexItem.q(), i13);
                return;
            }
        }
        if (!z10) {
            view.layout(i10 + flexItem.q(), i11, i12 + flexItem.q(), i13);
        } else {
            view.layout(i10 - flexItem.x(), i11, i12 - flexItem.x(), i13);
        }
    }
}
