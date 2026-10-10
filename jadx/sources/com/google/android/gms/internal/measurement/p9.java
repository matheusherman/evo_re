package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class p9 implements nd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m9 f2947a;

    @Override // com.google.android.gms.internal.measurement.nd
    public final void E(int i10, List<?> list, fc fcVar) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            f(i10, list.get(i11), fcVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void O(int i10, List<v8> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f2947a.p(i10, list.get(i11));
        }
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final int b() {
        return 1;
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void o(int i10, List<?> list, fc fcVar) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            x(i10, list.get(i11), fcVar);
        }
    }

    public static p9 P(m9 m9Var) {
        p9 p9Var = m9Var.f2869a;
        return p9Var != null ? p9Var : new p9(m9Var);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void A(int i10, List<Long> list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof za)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f2947a.o(i10, list.get(i11).longValue());
                    i11++;
                }
                return;
            }
            this.f2947a.Z(i10, 2);
            int iW = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iW += m9.W(list.get(i12).longValue());
            }
            this.f2947a.Y(iW);
            while (i11 < list.size()) {
                this.f2947a.u(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        za zaVar = (za) list;
        if (!z10) {
            while (i11 < zaVar.size()) {
                this.f2947a.o(i10, zaVar.l(i11));
                i11++;
            }
            return;
        }
        this.f2947a.Z(i10, 2);
        int iW2 = 0;
        for (int i13 = 0; i13 < zaVar.size(); i13++) {
            iW2 += m9.W(zaVar.l(i13));
        }
        this.f2947a.Y(iW2);
        while (i11 < zaVar.size()) {
            this.f2947a.u(zaVar.l(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void B(int i10, int i11) {
        this.f2947a.f0(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void C(int i10, List<Long> list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof za)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f2947a.P(i10, list.get(i11).longValue());
                    i11++;
                }
                return;
            }
            this.f2947a.Z(i10, 2);
            int iR0 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iR0 += m9.r0(list.get(i12).longValue());
            }
            this.f2947a.Y(iR0);
            while (i11 < list.size()) {
                this.f2947a.R(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        za zaVar = (za) list;
        if (!z10) {
            while (i11 < zaVar.size()) {
                this.f2947a.P(i10, zaVar.l(i11));
                i11++;
            }
            return;
        }
        this.f2947a.Z(i10, 2);
        int iR1 = 0;
        for (int i13 = 0; i13 < zaVar.size(); i13++) {
            iR1 += m9.r0(zaVar.l(i13));
        }
        this.f2947a.Y(iR1);
        while (i11 < zaVar.size()) {
            this.f2947a.R(zaVar.l(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void D(int i10, List<Integer> list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof ha)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f2947a.n(i10, list.get(i11).intValue());
                    i11++;
                }
                return;
            }
            this.f2947a.Z(i10, 2);
            int iG0 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iG0 += m9.g0(list.get(i12).intValue());
            }
            this.f2947a.Y(iG0);
            while (i11 < list.size()) {
                this.f2947a.m(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        ha haVar = (ha) list;
        if (!z10) {
            while (i11 < haVar.size()) {
                this.f2947a.n(i10, haVar.f(i11));
                i11++;
            }
            return;
        }
        this.f2947a.Z(i10, 2);
        int iG1 = 0;
        for (int i13 = 0; i13 < haVar.size(); i13++) {
            iG1 += m9.g0(haVar.f(i13));
        }
        this.f2947a.Y(iG1);
        while (i11 < haVar.size()) {
            this.f2947a.m(haVar.f(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void F(int i10, List<Integer> list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof ha)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f2947a.f0(i10, list.get(i11).intValue());
                    i11++;
                }
                return;
            }
            this.f2947a.Z(i10, 2);
            int iZ0 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZ0 += m9.z0(list.get(i12).intValue());
            }
            this.f2947a.Y(iZ0);
            while (i11 < list.size()) {
                this.f2947a.Y(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        ha haVar = (ha) list;
        if (!z10) {
            while (i11 < haVar.size()) {
                this.f2947a.f0(i10, haVar.f(i11));
                i11++;
            }
            return;
        }
        this.f2947a.Z(i10, 2);
        int iZ1 = 0;
        for (int i13 = 0; i13 < haVar.size(); i13++) {
            iZ1 += m9.z0(haVar.f(i13));
        }
        this.f2947a.Y(iZ1);
        while (i11 < haVar.size()) {
            this.f2947a.Y(haVar.f(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void G(int i10, List<Integer> list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof ha)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f2947a.O(i10, list.get(i11).intValue());
                    i11++;
                }
                return;
            }
            this.f2947a.Z(i10, 2);
            int iK0 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iK0 += m9.k0(list.get(i12).intValue());
            }
            this.f2947a.Y(iK0);
            while (i11 < list.size()) {
                this.f2947a.L(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        ha haVar = (ha) list;
        if (!z10) {
            while (i11 < haVar.size()) {
                this.f2947a.O(i10, haVar.f(i11));
                i11++;
            }
            return;
        }
        this.f2947a.Z(i10, 2);
        int iK1 = 0;
        for (int i13 = 0; i13 < haVar.size(); i13++) {
            iK1 += m9.k0(haVar.f(i13));
        }
        this.f2947a.Y(iK1);
        while (i11 < haVar.size()) {
            this.f2947a.L(haVar.f(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void H(int i10, List<String> list) {
        int i11 = 0;
        if (!(list instanceof ua)) {
            while (i11 < list.size()) {
                this.f2947a.s(i10, list.get(i11));
                i11++;
            }
            return;
        }
        ua uaVar = (ua) list;
        while (i11 < list.size()) {
            Object objA = uaVar.a(i11);
            if (objA instanceof String) {
                this.f2947a.s(i10, (String) objA);
            } else {
                this.f2947a.p(i10, (v8) objA);
            }
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void I(int i10, int i11) {
        this.f2947a.n(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void J(int i10, long j10) {
        this.f2947a.u0(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void K(int i10, v8 v8Var) {
        this.f2947a.p(i10, v8Var);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void L(int i10, List<Float> list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof da)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f2947a.N(i10, list.get(i11).floatValue());
                    i11++;
                }
                return;
            }
            this.f2947a.Z(i10, 2);
            int iD = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iD += m9.d(list.get(i12).floatValue());
            }
            this.f2947a.Y(iD);
            while (i11 < list.size()) {
                this.f2947a.K(list.get(i11).floatValue());
                i11++;
            }
            return;
        }
        da daVar = (da) list;
        if (!z10) {
            while (i11 < daVar.size()) {
                this.f2947a.N(i10, daVar.g(i11));
                i11++;
            }
            return;
        }
        this.f2947a.Z(i10, 2);
        int iD2 = 0;
        for (int i13 = 0; i13 < daVar.size(); i13++) {
            iD2 += m9.d(daVar.g(i13));
        }
        this.f2947a.Y(iD2);
        while (i11 < daVar.size()) {
            this.f2947a.K(daVar.g(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void M(int i10, int i11) {
        this.f2947a.C0(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void N(int i10, long j10) {
        this.f2947a.P(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    @Deprecated
    public final void a(int i10) {
        this.f2947a.Z(i10, 4);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void c(int i10, boolean z10) {
        this.f2947a.t(i10, z10);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void d(int i10, List<Integer> list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof ha)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f2947a.n(i10, list.get(i11).intValue());
                    i11++;
                }
                return;
            }
            this.f2947a.Z(i10, 2);
            int iO0 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iO0 += m9.o0(list.get(i12).intValue());
            }
            this.f2947a.Y(iO0);
            while (i11 < list.size()) {
                this.f2947a.m(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        ha haVar = (ha) list;
        if (!z10) {
            while (i11 < haVar.size()) {
                this.f2947a.n(i10, haVar.f(i11));
                i11++;
            }
            return;
        }
        this.f2947a.Z(i10, 2);
        int iO1 = 0;
        for (int i13 = 0; i13 < haVar.size(); i13++) {
            iO1 += m9.o0(haVar.f(i13));
        }
        this.f2947a.Y(iO1);
        while (i11 < haVar.size()) {
            this.f2947a.m(haVar.f(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void e(int i10, long j10) {
        this.f2947a.P(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void f(int i10, Object obj, fc fcVar) {
        this.f2947a.r(i10, (ob) obj, fcVar);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void g(int i10, int i11) {
        this.f2947a.n(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void h(int i10, List<Boolean> list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof t8)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f2947a.t(i10, list.get(i11).booleanValue());
                    i11++;
                }
                return;
            }
            this.f2947a.Z(i10, 2);
            int iJ = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iJ += m9.j(list.get(i12).booleanValue());
            }
            this.f2947a.Y(iJ);
            while (i11 < list.size()) {
                this.f2947a.S(list.get(i11).booleanValue());
                i11++;
            }
            return;
        }
        t8 t8Var = (t8) list;
        if (!z10) {
            while (i11 < t8Var.size()) {
                this.f2947a.t(i10, t8Var.g(i11));
                i11++;
            }
            return;
        }
        this.f2947a.Z(i10, 2);
        int iJ2 = 0;
        for (int i13 = 0; i13 < t8Var.size(); i13++) {
            iJ2 += m9.j(t8Var.g(i13));
        }
        this.f2947a.Y(iJ2);
        while (i11 < t8Var.size()) {
            this.f2947a.S(t8Var.g(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void i(int i10, List<Long> list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof za)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f2947a.P(i10, list.get(i11).longValue());
                    i11++;
                }
                return;
            }
            this.f2947a.Z(i10, 2);
            int iE0 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iE0 += m9.e0(list.get(i12).longValue());
            }
            this.f2947a.Y(iE0);
            while (i11 < list.size()) {
                this.f2947a.R(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        za zaVar = (za) list;
        if (!z10) {
            while (i11 < zaVar.size()) {
                this.f2947a.P(i10, zaVar.l(i11));
                i11++;
            }
            return;
        }
        this.f2947a.Z(i10, 2);
        int iE1 = 0;
        for (int i13 = 0; i13 < zaVar.size(); i13++) {
            iE1 += m9.e0(zaVar.l(i13));
        }
        this.f2947a.Y(iE1);
        while (i11 < zaVar.size()) {
            this.f2947a.R(zaVar.l(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void j(int i10, int i11) {
        this.f2947a.O(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void k(int i10, long j10) {
        this.f2947a.o(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    @Deprecated
    public final void l(int i10) {
        this.f2947a.Z(i10, 3);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void m(int i10, Object obj) {
        if (obj instanceof v8) {
            this.f2947a.Q(i10, (v8) obj);
        } else {
            this.f2947a.q(i10, (ob) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void n(int i10, List<Integer> list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof ha)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f2947a.O(i10, list.get(i11).intValue());
                    i11++;
                }
                return;
            }
            this.f2947a.Z(i10, 2);
            int iB0 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iB0 += m9.b0(list.get(i12).intValue());
            }
            this.f2947a.Y(iB0);
            while (i11 < list.size()) {
                this.f2947a.L(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        ha haVar = (ha) list;
        if (!z10) {
            while (i11 < haVar.size()) {
                this.f2947a.O(i10, haVar.f(i11));
                i11++;
            }
            return;
        }
        this.f2947a.Z(i10, 2);
        int iB1 = 0;
        for (int i13 = 0; i13 < haVar.size(); i13++) {
            iB1 += m9.b0(haVar.f(i13));
        }
        this.f2947a.Y(iB1);
        while (i11 < haVar.size()) {
            this.f2947a.L(haVar.f(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void p(int i10, List<Long> list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof za)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f2947a.u0(i10, list.get(i11).longValue());
                    i11++;
                }
                return;
            }
            this.f2947a.Z(i10, 2);
            int iN0 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iN0 += m9.n0(list.get(i12).longValue());
            }
            this.f2947a.Y(iN0);
            while (i11 < list.size()) {
                this.f2947a.v0(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        za zaVar = (za) list;
        if (!z10) {
            while (i11 < zaVar.size()) {
                this.f2947a.u0(i10, zaVar.l(i11));
                i11++;
            }
            return;
        }
        this.f2947a.Z(i10, 2);
        int iN1 = 0;
        for (int i13 = 0; i13 < zaVar.size(); i13++) {
            iN1 += m9.n0(zaVar.l(i13));
        }
        this.f2947a.Y(iN1);
        while (i11 < zaVar.size()) {
            this.f2947a.v0(zaVar.l(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void q(int i10, List<Double> list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof o9)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f2947a.M(i10, list.get(i11).doubleValue());
                    i11++;
                }
                return;
            }
            this.f2947a.Z(i10, 2);
            int iC = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iC += m9.c(list.get(i12).doubleValue());
            }
            this.f2947a.Y(iC);
            while (i11 < list.size()) {
                this.f2947a.J(list.get(i11).doubleValue());
                i11++;
            }
            return;
        }
        o9 o9Var = (o9) list;
        if (!z10) {
            while (i11 < o9Var.size()) {
                this.f2947a.M(i10, o9Var.g(i11));
                i11++;
            }
            return;
        }
        this.f2947a.Z(i10, 2);
        int iC2 = 0;
        for (int i13 = 0; i13 < o9Var.size(); i13++) {
            iC2 += m9.c(o9Var.g(i13));
        }
        this.f2947a.Y(iC2);
        while (i11 < o9Var.size()) {
            this.f2947a.J(o9Var.g(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void s(int i10, String str) {
        this.f2947a.s(i10, str);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void t(int i10, List<Long> list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof za)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f2947a.o(i10, list.get(i11).longValue());
                    i11++;
                }
                return;
            }
            this.f2947a.Z(i10, 2);
            int iJ0 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iJ0 += m9.j0(list.get(i12).longValue());
            }
            this.f2947a.Y(iJ0);
            while (i11 < list.size()) {
                this.f2947a.u(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        za zaVar = (za) list;
        if (!z10) {
            while (i11 < zaVar.size()) {
                this.f2947a.o(i10, zaVar.l(i11));
                i11++;
            }
            return;
        }
        this.f2947a.Z(i10, 2);
        int iJ1 = 0;
        for (int i13 = 0; i13 < zaVar.size(); i13++) {
            iJ1 += m9.j0(zaVar.l(i13));
        }
        this.f2947a.Y(iJ1);
        while (i11 < zaVar.size()) {
            this.f2947a.u(zaVar.l(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void u(int i10, List<Integer> list, boolean z10) {
        int i11 = 0;
        if (!(list instanceof ha)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f2947a.C0(i10, list.get(i11).intValue());
                    i11++;
                }
                return;
            }
            this.f2947a.Z(i10, 2);
            int iS0 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iS0 += m9.s0(list.get(i12).intValue());
            }
            this.f2947a.Y(iS0);
            while (i11 < list.size()) {
                this.f2947a.B0(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        ha haVar = (ha) list;
        if (!z10) {
            while (i11 < haVar.size()) {
                this.f2947a.C0(i10, haVar.f(i11));
                i11++;
            }
            return;
        }
        this.f2947a.Z(i10, 2);
        int iS1 = 0;
        for (int i13 = 0; i13 < haVar.size(); i13++) {
            iS1 += m9.s0(haVar.f(i13));
        }
        this.f2947a.Y(iS1);
        while (i11 < haVar.size()) {
            this.f2947a.B0(haVar.f(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void v(int i10, int i11) {
        this.f2947a.O(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void w(int i10, long j10) {
        this.f2947a.o(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void x(int i10, Object obj, fc fcVar) {
        m9 m9Var = this.f2947a;
        m9Var.Z(i10, 3);
        fcVar.g((ob) obj, m9Var.f2869a);
        m9Var.Z(i10, 4);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void y(int i10, double d10) {
        this.f2947a.M(i10, d10);
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final void z(int i10, float f10) {
        this.f2947a.N(i10, f10);
    }

    private p9(m9 m9Var) {
        m9 m9Var2 = (m9) ga.f(m9Var, "output");
        this.f2947a = m9Var2;
        m9Var2.f2869a = this;
    }

    @Override // com.google.android.gms.internal.measurement.nd
    public final <K, V> void r(int i10, fb<K, V> fbVar, Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f2947a.Z(i10, 2);
            this.f2947a.Y(gb.a(fbVar, entry.getKey(), entry.getValue()));
            gb.b(this.f2947a, fbVar, entry.getKey(), entry.getValue());
        }
    }
}
