package com.tvc.lib.mobile.ui.widget.flexbox;

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
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tvc.lib.mobile.ui.widget.flexbox.a f9467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean[] f9468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    int[] f9469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    long[] f9470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private long[] f9471e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f9474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9475b;

        /* synthetic */ b(d dVar) {
            this();
        }

        private b() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NonNull b bVar) {
            int i10 = this.f9475b;
            int i11 = bVar.f9475b;
            return i10 != i11 ? i10 - i11 : this.f9474a - bVar.f9474a;
        }

        @NonNull
        public String toString() {
            return "Order{order=" + this.f9475b + ", index=" + this.f9474a + '}';
        }
    }

    private boolean N(int i10, int i11, com.tvc.lib.mobile.ui.widget.flexbox.b bVar) {
        return i10 == i11 - 1 && bVar.c() != 0;
    }

    private List<com.tvc.lib.mobile.ui.widget.flexbox.b> k(List<com.tvc.lib.mobile.ui.widget.flexbox.b> list, int i10, int i11) {
        int i12 = (i10 - i11) / 2;
        ArrayList arrayList = new ArrayList();
        com.tvc.lib.mobile.ui.widget.flexbox.b bVar = new com.tvc.lib.mobile.ui.widget.flexbox.b();
        bVar.f9455g = i12;
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

    void c(a aVar, int i10, int i11) {
        b(aVar, i10, i11, Integer.MAX_VALUE, 0, -1, null);
    }

    void d(a aVar, int i10, int i11, int i12, int i13, @Nullable List<com.tvc.lib.mobile.ui.widget.flexbox.b> list) {
        b(aVar, i10, i11, i12, i13, -1, list);
    }

    void e(a aVar, int i10, int i11, int i12, int i13, List<com.tvc.lib.mobile.ui.widget.flexbox.b> list) {
        b(aVar, i10, i11, i12, 0, i13, list);
    }

    void f(a aVar, int i10, int i11) {
        b(aVar, i11, i10, Integer.MAX_VALUE, 0, -1, null);
    }

    void g(a aVar, int i10, int i11, int i12, int i13, @Nullable List<com.tvc.lib.mobile.ui.widget.flexbox.b> list) {
        b(aVar, i11, i10, i12, i13, -1, list);
    }

    void h(a aVar, int i10, int i11, int i12, int i13, List<com.tvc.lib.mobile.ui.widget.flexbox.b> list) {
        b(aVar, i11, i10, i12, 0, i13, list);
    }

    void p(int i10, int i11) {
        q(i10, i11, 0);
    }

    int y(long j10) {
        return (int) j10;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<com.tvc.lib.mobile.ui.widget.flexbox.b> f9472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9473b;

        void a() {
            this.f9472a = null;
            this.f9473b = 0;
        }

        a() {
        }
    }

    private int A(int i10, FlexItem flexItem, int i11) {
        com.tvc.lib.mobile.ui.widget.flexbox.a aVar = this.f9467a;
        int iB = aVar.b(i10, aVar.getPaddingLeft() + this.f9467a.getPaddingRight() + flexItem.q() + flexItem.x() + i11, flexItem.getWidth());
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
        return z10 ? this.f9467a.getPaddingBottom() : this.f9467a.getPaddingEnd();
    }

    private int I(boolean z10) {
        return z10 ? this.f9467a.getPaddingEnd() : this.f9467a.getPaddingBottom();
    }

    private int J(boolean z10) {
        return z10 ? this.f9467a.getPaddingTop() : this.f9467a.getPaddingStart();
    }

    private int K(boolean z10) {
        return z10 ? this.f9467a.getPaddingStart() : this.f9467a.getPaddingTop();
    }

    private int L(View view, boolean z10) {
        return z10 ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    private int M(View view, boolean z10) {
        return z10 ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private boolean P(View view, int i10, int i11, int i12, int i13, FlexItem flexItem, int i14, int i15, int i16) {
        if (this.f9467a.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.z()) {
            return true;
        }
        if (i10 == 0) {
            return false;
        }
        int maxLine = this.f9467a.getMaxLine();
        if (maxLine != -1 && maxLine <= i16 + 1) {
            return false;
        }
        int iE = this.f9467a.e(view, i14, i15);
        if (iE > 0) {
            i13 += iE;
        }
        return i11 < i12 + i13;
    }

    private void T(int i10, int i11, com.tvc.lib.mobile.ui.widget.flexbox.b bVar, int i12, int i13, boolean z10) {
        float f10;
        int iMax;
        int iM;
        int i14 = bVar.f9453e;
        float f11 = bVar.f9459k;
        if (f11 <= 0.0f || i12 > i14) {
            return;
        }
        float f12 = (i14 - i12) / f11;
        bVar.f9453e = i13 + bVar.f9454f;
        if (!z10) {
            bVar.f9455g = Integer.MIN_VALUE;
        }
        int i15 = 0;
        boolean z11 = false;
        int i16 = 0;
        float f13 = 0.0f;
        while (i15 < bVar.f9456h) {
            int i17 = bVar.f9463o + i15;
            View viewA = this.f9467a.a(i17);
            if (viewA == null || viewA.getVisibility() == 8) {
                f10 = f12;
            } else {
                FlexItem flexItem = (FlexItem) viewA.getLayoutParams();
                int flexDirection = this.f9467a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int measuredWidth = viewA.getMeasuredWidth();
                    long[] jArr = this.f9471e;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i17]);
                    }
                    int measuredHeight = viewA.getMeasuredHeight();
                    long[] jArr2 = this.f9471e;
                    f10 = f12;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i17]);
                    }
                    if (!this.f9468b[i17] && flexItem.k() > 0.0f) {
                        float fK = measuredWidth - (f10 * flexItem.k());
                        if (i15 == bVar.f9456h - 1) {
                            fK += f13;
                            f13 = 0.0f;
                        }
                        int iRound = Math.round(fK);
                        if (iRound < flexItem.m()) {
                            iM = flexItem.m();
                            this.f9468b[i17] = true;
                            bVar.f9459k -= flexItem.k();
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
                        int iZ = z(i11, flexItem, bVar.f9461m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iM, BasicMeasure.EXACTLY);
                        viewA.measure(iMakeMeasureSpec, iZ);
                        int measuredWidth2 = viewA.getMeasuredWidth();
                        int measuredHeight2 = viewA.getMeasuredHeight();
                        Z(i17, iMakeMeasureSpec, iZ, viewA);
                        this.f9467a.c(i17, viewA);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i16, measuredHeight + flexItem.s() + flexItem.o() + this.f9467a.h(viewA));
                    bVar.f9453e += measuredWidth + flexItem.q() + flexItem.x();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewA.getMeasuredHeight();
                    long[] jArr3 = this.f9471e;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i17]);
                    }
                    int measuredWidth3 = viewA.getMeasuredWidth();
                    long[] jArr4 = this.f9471e;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i17]);
                    }
                    if (!this.f9468b[i17] && flexItem.k() > 0.0f) {
                        float fK2 = measuredHeight3 - (flexItem.k() * f12);
                        if (i15 == bVar.f9456h - 1) {
                            fK2 += f13;
                            f13 = 0.0f;
                        }
                        int iRound2 = Math.round(fK2);
                        if (iRound2 < flexItem.y()) {
                            iRound2 = flexItem.y();
                            this.f9468b[i17] = true;
                            bVar.f9459k -= flexItem.k();
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
                        int iA = A(i10, flexItem, bVar.f9461m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, BasicMeasure.EXACTLY);
                        viewA.measure(iA, iMakeMeasureSpec2);
                        int measuredWidth4 = viewA.getMeasuredWidth();
                        int measuredHeight4 = viewA.getMeasuredHeight();
                        Z(i17, iA, iMakeMeasureSpec2, viewA);
                        this.f9467a.c(i17, viewA);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i16, measuredWidth3 + flexItem.q() + flexItem.x() + this.f9467a.h(viewA));
                    bVar.f9453e += measuredHeight3 + flexItem.s() + flexItem.o();
                    f10 = f12;
                }
                bVar.f9455g = Math.max(bVar.f9455g, iMax);
                i16 = iMax;
            }
            i15++;
            f12 = f10;
        }
        if (!z11 || i14 == bVar.f9453e) {
            return;
        }
        T(i10, i11, bVar, i12, i13, true);
    }

    private void Z(int i10, int i11, int i12, View view) {
        long[] jArr = this.f9470d;
        if (jArr != null) {
            jArr[i10] = S(i11, i12);
        }
        long[] jArr2 = this.f9471e;
        if (jArr2 != null) {
            jArr2[i10] = S(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private void a(List<com.tvc.lib.mobile.ui.widget.flexbox.b> list, com.tvc.lib.mobile.ui.widget.flexbox.b bVar, int i10, int i11) {
        bVar.f9461m = i11;
        this.f9467a.l(bVar);
        bVar.f9464p = i10;
        list.add(bVar);
    }

    @NonNull
    private List<b> l(int i10) {
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            FlexItem flexItem = (FlexItem) this.f9467a.d(i11).getLayoutParams();
            b bVar = new b(null);
            bVar.f9475b = flexItem.getOrder();
            bVar.f9474a = i11;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    private void r(int i10) {
        boolean[] zArr = this.f9468b;
        if (zArr == null) {
            this.f9468b = new boolean[Math.max(i10, 10)];
        } else if (zArr.length < i10) {
            this.f9468b = new boolean[Math.max(zArr.length * 2, i10)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void w(int i10, int i11, com.tvc.lib.mobile.ui.widget.flexbox.b bVar, int i12, int i13, boolean z10) {
        int i14;
        float f10;
        int iMax;
        double d10;
        double d11;
        float f11 = bVar.f9458j;
        if (f11 <= 0.0f || i12 < (i14 = bVar.f9453e)) {
            return;
        }
        float f12 = (i12 - i14) / f11;
        bVar.f9453e = i13 + bVar.f9454f;
        if (!z10) {
            bVar.f9455g = Integer.MIN_VALUE;
        }
        int i15 = 0;
        boolean z11 = false;
        int i16 = 0;
        float f13 = 0.0f;
        while (i15 < bVar.f9456h) {
            int i17 = bVar.f9463o + i15;
            View viewA = this.f9467a.a(i17);
            if (viewA == null || viewA.getVisibility() == 8) {
                f10 = f12;
                z11 = z11;
            } else {
                FlexItem flexItem = (FlexItem) viewA.getLayoutParams();
                int flexDirection = this.f9467a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    f10 = f12;
                    boolean z12 = z11;
                    int measuredWidth = viewA.getMeasuredWidth();
                    long[] jArr = this.f9471e;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i17]);
                    }
                    int measuredHeight = viewA.getMeasuredHeight();
                    long[] jArr2 = this.f9471e;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i17]);
                    }
                    if (this.f9468b[i17] || flexItem.u() <= 0.0f) {
                        z11 = z12;
                    } else {
                        float fU = measuredWidth + (flexItem.u() * f10);
                        if (i15 == bVar.f9456h - 1) {
                            fU += f13;
                            f13 = 0.0f;
                        }
                        int iRound = Math.round(fU);
                        if (iRound > flexItem.C()) {
                            iRound = flexItem.C();
                            this.f9468b[i17] = true;
                            bVar.f9458j -= flexItem.u();
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
                        int iZ = z(i11, flexItem, bVar.f9461m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, BasicMeasure.EXACTLY);
                        viewA.measure(iMakeMeasureSpec, iZ);
                        int measuredWidth2 = viewA.getMeasuredWidth();
                        int measuredHeight2 = viewA.getMeasuredHeight();
                        Z(i17, iMakeMeasureSpec, iZ, viewA);
                        this.f9467a.c(i17, viewA);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i16, measuredHeight + flexItem.s() + flexItem.o() + this.f9467a.h(viewA));
                    bVar.f9453e += measuredWidth + flexItem.q() + flexItem.x();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewA.getMeasuredHeight();
                    long[] jArr3 = this.f9471e;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i17]);
                    }
                    int measuredWidth3 = viewA.getMeasuredWidth();
                    long[] jArr4 = this.f9471e;
                    f10 = f12;
                    boolean z13 = z11;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i17]);
                    }
                    if (this.f9468b[i17] || flexItem.u() <= 0.0f) {
                        z11 = z13;
                    } else {
                        float fU2 = measuredHeight3 + (flexItem.u() * f10);
                        if (i15 == bVar.f9456h - 1) {
                            fU2 += f13;
                            f13 = 0.0f;
                        }
                        int iRound2 = Math.round(fU2);
                        if (iRound2 > flexItem.A()) {
                            iRound2 = flexItem.A();
                            this.f9468b[i17] = true;
                            bVar.f9458j -= flexItem.u();
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
                        int iA = A(i10, flexItem, bVar.f9461m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, BasicMeasure.EXACTLY);
                        viewA.measure(iA, iMakeMeasureSpec2);
                        int measuredWidth4 = viewA.getMeasuredWidth();
                        int measuredHeight4 = viewA.getMeasuredHeight();
                        Z(i17, iA, iMakeMeasureSpec2, viewA);
                        this.f9467a.c(i17, viewA);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i16, measuredWidth3 + flexItem.q() + flexItem.x() + this.f9467a.h(viewA));
                    bVar.f9453e += measuredHeight3 + flexItem.s() + flexItem.o();
                }
                bVar.f9455g = Math.max(bVar.f9455g, iMax);
                i16 = iMax;
            }
            i15++;
            f12 = f10;
        }
        if (!z11 || i14 == bVar.f9453e) {
            return;
        }
        w(i10, i11, bVar, i12, i13, true);
    }

    private int z(int i10, FlexItem flexItem, int i11) {
        com.tvc.lib.mobile.ui.widget.flexbox.a aVar = this.f9467a;
        int iF = aVar.f(i10, aVar.getPaddingTop() + this.f9467a.getPaddingBottom() + flexItem.s() + flexItem.o() + i11, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(iF);
        if (size > flexItem.A()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.A(), View.MeasureSpec.getMode(iF));
        }
        return size < flexItem.y() ? View.MeasureSpec.makeMeasureSpec(flexItem.y(), View.MeasureSpec.getMode(iF)) : iF;
    }

    boolean O(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f9467a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i10 = 0; i10 < flexItemCount; i10++) {
            View viewD = this.f9467a.d(i10);
            if (viewD != null && ((FlexItem) viewD.getLayoutParams()).getOrder() != sparseIntArray.get(i10)) {
                return true;
            }
        }
        return false;
    }

    void Y(int i10) {
        View viewA;
        if (i10 >= this.f9467a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f9467a.getFlexDirection();
        if (this.f9467a.getAlignItems() != 4) {
            for (com.tvc.lib.mobile.ui.widget.flexbox.b bVar : this.f9467a.getFlexLinesInternal()) {
                for (Integer num : bVar.f9462n) {
                    View viewA2 = this.f9467a.a(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        W(viewA2, bVar.f9455g, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                        }
                        V(viewA2, bVar.f9455g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.f9469c;
        List<com.tvc.lib.mobile.ui.widget.flexbox.b> flexLinesInternal = this.f9467a.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i11 = iArr != null ? iArr[i10] : 0; i11 < size; i11++) {
            if (i11 >= 0) {
                com.tvc.lib.mobile.ui.widget.flexbox.b bVar2 = flexLinesInternal.get(i11);
                int i12 = bVar2.f9456h;
                for (int i13 = 0; i13 < i12; i13++) {
                    int i14 = bVar2.f9463o + i13;
                    if (i13 < this.f9467a.getFlexItemCount() && (viewA = this.f9467a.a(i14)) != null && viewA.getVisibility() != 8) {
                        FlexItem flexItem = (FlexItem) viewA.getLayoutParams();
                        if (flexItem.i() == -1 || flexItem.i() == 4) {
                            if (flexDirection == 0 || flexDirection == 1) {
                                W(viewA, bVar2.f9455g, i14);
                            } else {
                                if (flexDirection != 2 && flexDirection != 3) {
                                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                                }
                                V(viewA, bVar2.f9455g, i14);
                            }
                        }
                    }
                }
            }
        }
    }

    void b(a aVar, int i10, int i11, int i12, int i13, int i14, @Nullable List<com.tvc.lib.mobile.ui.widget.flexbox.b> list) {
        int i15;
        int i16;
        int i17;
        int iB;
        int i18;
        int i19;
        int i20;
        com.tvc.lib.mobile.ui.widget.flexbox.b bVar;
        int i21;
        int i22;
        boolean z10;
        int i23;
        boolean z11;
        int i24;
        int i25 = i10;
        boolean zG = this.f9467a.g();
        int mode = View.MeasureSpec.getMode(i25);
        int size = View.MeasureSpec.getSize(i25);
        List<com.tvc.lib.mobile.ui.widget.flexbox.b> arrayList = list == null ? new ArrayList() : list;
        aVar.f9472a = arrayList;
        boolean z12 = i14 == -1;
        int iK = K(zG);
        int I = I(zG);
        int iJ = J(zG);
        int iH = H(zG);
        com.tvc.lib.mobile.ui.widget.flexbox.b bVar2 = new com.tvc.lib.mobile.ui.widget.flexbox.b();
        int i26 = i13;
        bVar2.f9463o = i26;
        int i27 = iK + I;
        bVar2.f9453e = i27;
        int flexItemCount = this.f9467a.getFlexItemCount();
        boolean z13 = z12;
        com.tvc.lib.mobile.ui.widget.flexbox.b bVar3 = bVar2;
        int i28 = 0;
        int iCombineMeasuredStates = 0;
        int i29 = 0;
        int i30 = Integer.MIN_VALUE;
        while (i26 < flexItemCount) {
            View viewA = this.f9467a.a(i26);
            if (viewA == null) {
                if (N(i26, flexItemCount, bVar3)) {
                    a(arrayList, bVar3, i26, i28);
                }
                i16 = i27;
            } else {
                i16 = i27;
                if (viewA.getVisibility() == 8) {
                    bVar3.f9457i++;
                    bVar3.f9456h++;
                    if (N(i26, flexItemCount, bVar3)) {
                        a(arrayList, bVar3, i26, i28);
                    }
                } else {
                    if (viewA instanceof CompoundButton) {
                        v((CompoundButton) viewA);
                    }
                    FlexItem flexItem = (FlexItem) viewA.getLayoutParams();
                    int i31 = flexItemCount;
                    if (flexItem.i() == 4) {
                        bVar3.f9462n.add(Integer.valueOf(i26));
                    }
                    int iG = G(flexItem, zG);
                    if (flexItem.v() != -1.0f && mode == 1073741824) {
                        iG = Math.round(size * flexItem.v());
                    }
                    if (zG) {
                        iB = this.f9467a.b(i25, i16 + E(flexItem, true) + C(flexItem, true), iG);
                        i17 = i28;
                        int iF = this.f9467a.f(i11, iJ + iH + D(flexItem, true) + B(flexItem, true) + i28, F(flexItem, true));
                        viewA.measure(iB, iF);
                        Z(i26, iB, iF, viewA);
                    } else {
                        i17 = i28;
                        int iB2 = this.f9467a.b(i11, iJ + iH + D(flexItem, false) + B(flexItem, false) + i17, F(flexItem, false));
                        int iF2 = this.f9467a.f(i25, i16 + E(flexItem, false) + C(flexItem, false), iG);
                        viewA.measure(iB2, iF2);
                        Z(i26, iB2, iF2, viewA);
                        iB = iF2;
                    }
                    this.f9467a.c(i26, viewA);
                    i(viewA, i26);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewA.getMeasuredState());
                    i18 = i26;
                    int i32 = iB;
                    com.tvc.lib.mobile.ui.widget.flexbox.b bVar4 = bVar3;
                    int i33 = i29;
                    i19 = i16;
                    i20 = i17;
                    boolean z14 = zG;
                    size = size;
                    if (P(viewA, mode, size, bVar3.f9453e, M(viewA, zG) + E(flexItem, zG) + C(flexItem, zG), flexItem, i18, i33, arrayList.size())) {
                        if (bVar4.c() > 0) {
                            a(arrayList, bVar4, i18 > 0 ? i18 - 1 : 0, i20);
                            i24 = i20 + bVar4.f9455g;
                        } else {
                            i24 = i20;
                        }
                        if (z14) {
                            if (flexItem.getHeight() == -1) {
                                com.tvc.lib.mobile.ui.widget.flexbox.a aVar2 = this.f9467a;
                                viewA.measure(i32, aVar2.f(i11, aVar2.getPaddingTop() + this.f9467a.getPaddingBottom() + flexItem.s() + flexItem.o() + i24, flexItem.getHeight()));
                                i(viewA, i18);
                            }
                        } else if (flexItem.getWidth() == -1) {
                            com.tvc.lib.mobile.ui.widget.flexbox.a aVar3 = this.f9467a;
                            viewA.measure(aVar3.b(i11, aVar3.getPaddingLeft() + this.f9467a.getPaddingRight() + flexItem.q() + flexItem.x() + i24, flexItem.getWidth()), i32);
                            i(viewA, i18);
                        }
                        com.tvc.lib.mobile.ui.widget.flexbox.b bVar5 = new com.tvc.lib.mobile.ui.widget.flexbox.b();
                        bVar5.f9456h = 1;
                        bVar5.f9453e = i19;
                        bVar5.f9463o = i18;
                        i20 = i24;
                        i21 = 0;
                        bVar = bVar5;
                        i22 = Integer.MIN_VALUE;
                    } else {
                        bVar = bVar4;
                        bVar.f9456h++;
                        i21 = i33 + 1;
                        i22 = i30;
                    }
                    bVar.f9465q |= flexItem.u() != 0.0f;
                    bVar.f9466r |= flexItem.k() != 0.0f;
                    int[] iArr = this.f9469c;
                    if (iArr != null) {
                        iArr[i18] = arrayList.size();
                    }
                    z10 = z14;
                    bVar.f9453e += M(viewA, z10) + E(flexItem, z10) + C(flexItem, z10);
                    bVar.f9458j += flexItem.u();
                    bVar.f9459k += flexItem.k();
                    this.f9467a.j(viewA, i18, i21, bVar);
                    int iMax = Math.max(i22, L(viewA, z10) + D(flexItem, z10) + B(flexItem, z10) + this.f9467a.h(viewA));
                    bVar.f9455g = Math.max(bVar.f9455g, iMax);
                    if (z10) {
                        if (this.f9467a.getFlexWrap() != 2) {
                            bVar.f9460l = Math.max(bVar.f9460l, viewA.getBaseline() + flexItem.s());
                        } else {
                            bVar.f9460l = Math.max(bVar.f9460l, (viewA.getMeasuredHeight() - viewA.getBaseline()) + flexItem.o());
                        }
                    }
                    i23 = i31;
                    if (N(i18, i23, bVar)) {
                        a(arrayList, bVar, i18, i20);
                        i20 += bVar.f9455g;
                    }
                    if (i14 != -1 && arrayList.size() > 0) {
                        if (arrayList.get(arrayList.size() - 1).f9464p >= i14 && i18 >= i14 && !z13) {
                            i20 = -bVar.a();
                            z11 = true;
                        }
                        if (i20 <= i12 && z11) {
                            i15 = iCombineMeasuredStates;
                            aVar.f9473b = i15;
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
                bVar3 = bVar;
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
            bVar = bVar3;
            int i35 = i18 + 1;
            zG = z10;
            bVar3 = bVar;
            i27 = i19;
            i28 = i20;
            i25 = i10;
            flexItemCount = i23;
            i26 = i35;
            mode = mode;
        }
        i15 = iCombineMeasuredStates;
        aVar.f9473b = i15;
    }

    void j(List<com.tvc.lib.mobile.ui.widget.flexbox.b> list, int i10) {
        int i11 = this.f9469c[i10];
        if (i11 == -1) {
            i11 = 0;
        }
        if (list.size() > i11) {
            list.subList(i11, list.size()).clear();
        }
        int[] iArr = this.f9469c;
        int length = iArr.length - 1;
        if (i10 > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i10, length, -1);
        }
        long[] jArr = this.f9470d;
        int length2 = jArr.length - 1;
        if (i10 > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i10, length2, 0L);
        }
    }

    int[] m(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f9467a.getFlexItemCount();
        return U(flexItemCount, l(flexItemCount), sparseIntArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    int[] n(View view, int i10, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.f9467a.getFlexItemCount();
        List<b> listL = l(flexItemCount);
        b bVar = new b(null);
        if (view == null || !(layoutParams instanceof FlexItem)) {
            bVar.f9475b = 1;
        } else {
            bVar.f9475b = ((FlexItem) layoutParams).getOrder();
        }
        if (i10 == -1 || i10 == flexItemCount || i10 >= this.f9467a.getFlexItemCount()) {
            bVar.f9474a = flexItemCount;
        } else {
            bVar.f9474a = i10;
            while (i10 < flexItemCount) {
                listL.get(i10).f9474a++;
                i10++;
            }
        }
        listL.add(bVar);
        return U(flexItemCount + 1, listL, sparseIntArray);
    }

    void o(int i10, int i11, int i12) {
        int mode;
        int size;
        int flexDirection = this.f9467a.getFlexDirection();
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
        List<com.tvc.lib.mobile.ui.widget.flexbox.b> flexLinesInternal = this.f9467a.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.f9467a.getSumOfCrossSize() + i12;
            int i13 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).f9455g = size - i12;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f9467a.getAlignContent();
                if (alignContent == 1) {
                    int i14 = size - sumOfCrossSize;
                    com.tvc.lib.mobile.ui.widget.flexbox.b bVar = new com.tvc.lib.mobile.ui.widget.flexbox.b();
                    bVar.f9455g = i14;
                    flexLinesInternal.add(0, bVar);
                    return;
                }
                if (alignContent == 2) {
                    this.f9467a.setFlexLines(k(flexLinesInternal, size, sumOfCrossSize));
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
                            com.tvc.lib.mobile.ui.widget.flexbox.b bVar2 = new com.tvc.lib.mobile.ui.widget.flexbox.b();
                            if (i13 == flexLinesInternal.size() - 2) {
                                bVar2.f9455g = Math.round(f10 + size3);
                                f10 = 0.0f;
                            } else {
                                bVar2.f9455g = Math.round(size3);
                            }
                            int i15 = bVar2.f9455g;
                            f10 += size3 - i15;
                            if (f10 > 1.0f) {
                                bVar2.f9455g = i15 + 1;
                                f10 -= 1.0f;
                            } else if (f10 < -1.0f) {
                                bVar2.f9455g = i15 - 1;
                                f10 += 1.0f;
                            }
                            arrayList.add(bVar2);
                        }
                        i13++;
                    }
                    this.f9467a.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.f9467a.setFlexLines(k(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    com.tvc.lib.mobile.ui.widget.flexbox.b bVar3 = new com.tvc.lib.mobile.ui.widget.flexbox.b();
                    bVar3.f9455g = size5;
                    for (com.tvc.lib.mobile.ui.widget.flexbox.b bVar4 : flexLinesInternal) {
                        arrayList2.add(bVar3);
                        arrayList2.add(bVar4);
                        arrayList2.add(bVar3);
                    }
                    this.f9467a.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f11 = 0.0f;
                    while (i13 < size7) {
                        com.tvc.lib.mobile.ui.widget.flexbox.b bVar5 = flexLinesInternal.get(i13);
                        float f12 = bVar5.f9455g + size6;
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
                        bVar5.f9455g = iRound;
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
        r(this.f9467a.getFlexItemCount());
        if (i12 >= this.f9467a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f9467a.getFlexDirection();
        int flexDirection2 = this.f9467a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i10);
            size = View.MeasureSpec.getSize(i10);
            int largestMainSize = this.f9467a.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.f9467a.getPaddingLeft();
            paddingRight = this.f9467a.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int mode2 = View.MeasureSpec.getMode(i11);
            size = View.MeasureSpec.getSize(i11);
            if (mode2 != 1073741824) {
                size = this.f9467a.getLargestMainSize();
            }
            paddingLeft = this.f9467a.getPaddingTop();
            paddingRight = this.f9467a.getPaddingBottom();
        }
        int i15 = paddingLeft + paddingRight;
        int i16 = size;
        int[] iArr = this.f9469c;
        int i17 = iArr != null ? iArr[i12] : 0;
        List<com.tvc.lib.mobile.ui.widget.flexbox.b> flexLinesInternal = this.f9467a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        while (i17 < size2) {
            if (i17 < 0) {
                i13 = i10;
                i14 = i11;
            } else {
                com.tvc.lib.mobile.ui.widget.flexbox.b bVar = flexLinesInternal.get(i17);
                int i18 = bVar.f9453e;
                if (i18 >= i16 || !bVar.f9465q) {
                    i13 = i10;
                    i14 = i11;
                    if (i18 > i16 && bVar.f9466r) {
                        T(i13, i14, bVar, i16, i15, false);
                    }
                } else {
                    i13 = i10;
                    i14 = i11;
                    w(i13, i14, bVar, i16, i15, false);
                }
            }
            i17++;
            i10 = i13;
            i11 = i14;
        }
    }

    void s(int i10) {
        int[] iArr = this.f9469c;
        if (iArr == null) {
            this.f9469c = new int[Math.max(i10, 10)];
        } else if (iArr.length < i10) {
            this.f9469c = Arrays.copyOf(this.f9469c, Math.max(iArr.length * 2, i10));
        }
    }

    void t(int i10) {
        long[] jArr = this.f9470d;
        if (jArr == null) {
            this.f9470d = new long[Math.max(i10, 10)];
        } else if (jArr.length < i10) {
            this.f9470d = Arrays.copyOf(this.f9470d, Math.max(jArr.length * 2, i10));
        }
    }

    void u(int i10) {
        long[] jArr = this.f9471e;
        if (jArr == null) {
            this.f9471e = new long[Math.max(i10, 10)];
        } else if (jArr.length < i10) {
            this.f9471e = Arrays.copyOf(this.f9471e, Math.max(jArr.length * 2, i10));
        }
    }

    int x(long j10) {
        return (int) (j10 >> 32);
    }

    c(com.tvc.lib.mobile.ui.widget.flexbox.a aVar) {
        this.f9467a = aVar;
    }

    private int[] U(int i10, List<b> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i10];
        int i11 = 0;
        for (b bVar : list) {
            int i12 = bVar.f9474a;
            iArr[i11] = i12;
            sparseIntArray.append(i12, bVar.f9475b);
            i11++;
        }
        return iArr;
    }

    private void V(View view, int i10, int i11) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i10 - flexItem.q()) - flexItem.x()) - this.f9467a.h(view), flexItem.m()), flexItem.C());
        long[] jArr = this.f9471e;
        if (jArr != null) {
            measuredHeight = x(jArr[i11]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, BasicMeasure.EXACTLY);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, BasicMeasure.EXACTLY);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        Z(i11, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.f9467a.c(i11, view);
    }

    private void W(View view, int i10, int i11) {
        int measuredWidth;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i10 - flexItem.s()) - flexItem.o()) - this.f9467a.h(view), flexItem.y()), flexItem.A());
        long[] jArr = this.f9471e;
        if (jArr != null) {
            measuredWidth = y(jArr[i11]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, BasicMeasure.EXACTLY);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, BasicMeasure.EXACTLY);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        Z(i11, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.f9467a.c(i11, view);
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
                this.f9467a.c(i10, view);
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
            this.f9467a.c(i10, view);
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

    void Q(View view, com.tvc.lib.mobile.ui.widget.flexbox.b bVar, int i10, int i11, int i12, int i13) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f9467a.getAlignItems();
        if (flexItem.i() != -1) {
            alignItems = flexItem.i();
        }
        int i14 = bVar.f9455g;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems != 2) {
                    if (alignItems != 3) {
                        if (alignItems != 4) {
                            return;
                        }
                    } else if (this.f9467a.getFlexWrap() != 2) {
                        int iMax = Math.max(bVar.f9460l - view.getBaseline(), flexItem.s());
                        view.layout(i10, i11 + iMax, i12, i13 + iMax);
                        return;
                    } else {
                        int iMax2 = Math.max((bVar.f9460l - view.getMeasuredHeight()) + view.getBaseline(), flexItem.o());
                        view.layout(i10, i11 - iMax2, i12, i13 - iMax2);
                        return;
                    }
                } else {
                    int measuredHeight = (((i14 - view.getMeasuredHeight()) + flexItem.s()) - flexItem.o()) / 2;
                    if (this.f9467a.getFlexWrap() != 2) {
                        int i15 = i11 + measuredHeight;
                        view.layout(i10, i15, i12, view.getMeasuredHeight() + i15);
                        return;
                    } else {
                        int i16 = i11 - measuredHeight;
                        view.layout(i10, i16, i12, view.getMeasuredHeight() + i16);
                        return;
                    }
                }
            } else if (this.f9467a.getFlexWrap() != 2) {
                int i17 = i11 + i14;
                view.layout(i10, (i17 - view.getMeasuredHeight()) - flexItem.o(), i12, i17 - flexItem.o());
                return;
            } else {
                view.layout(i10, (i11 - i14) + view.getMeasuredHeight() + flexItem.s(), i12, (i13 - i14) + view.getMeasuredHeight() + flexItem.s());
                return;
            }
        }
        if (this.f9467a.getFlexWrap() != 2) {
            view.layout(i10, i11 + flexItem.s(), i12, i13 + flexItem.s());
        } else {
            view.layout(i10, i11 - flexItem.o(), i12, i13 - flexItem.o());
        }
    }

    void R(View view, com.tvc.lib.mobile.ui.widget.flexbox.b bVar, boolean z10, int i10, int i11, int i12, int i13) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f9467a.getAlignItems();
        if (flexItem.i() != -1) {
            alignItems = flexItem.i();
        }
        int i14 = bVar.f9455g;
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
