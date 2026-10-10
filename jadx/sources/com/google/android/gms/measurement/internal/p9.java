package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.rf;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class p9 extends bc {
    @Override // com.google.android.gms.measurement.internal.bc
    protected final boolean y() {
        return false;
    }

    private static String p(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    /* JADX WARN: Code duplicated, block: B:65:0x01c0  */
    @WorkerThread
    public final byte[] z(@NonNull zzbj zzbjVar, @Size(min = 1) String str) {
        v7 v7Var;
        tc next;
        com.google.android.gms.internal.measurement.s5.a aVar;
        x4 x4Var;
        com.google.android.gms.internal.measurement.t5.a aVar2;
        byte[] bArr;
        c0 c0VarA;
        long j10;
        n();
        this.f3965a.o();
        m1.g.k(zzbjVar);
        m1.g.e(str);
        if (!"_iap".equals(zzbjVar.f4299a) && !"_iapx".equals(zzbjVar.f4299a)) {
            l().G().c("Generating a payload for this event is not available. package_name, event_name", str, zzbjVar.f4299a);
            return null;
        }
        com.google.android.gms.internal.measurement.s5.a aVarR = com.google.android.gms.internal.measurement.s5.R();
        r().o1();
        try {
            x4 x4VarV0 = r().V0(str);
            if (x4VarV0 == null) {
                l().G().b("Log and bundle not available. package_name", str);
                byte[] bArr2 = new byte[0];
                r().r1();
                return bArr2;
            }
            if (!x4VarV0.A()) {
                l().G().b("Log and bundle disabled. package_name", str);
                byte[] bArr3 = new byte[0];
                r().r1();
                return bArr3;
            }
            com.google.android.gms.internal.measurement.t5.a aVarG1 = com.google.android.gms.internal.measurement.t5.J2().E0(1).g1("android");
            if (!TextUtils.isEmpty(x4VarV0.l())) {
                aVarG1.c0(x4VarV0.l());
            }
            if (!TextUtils.isEmpty(x4VarV0.n())) {
                aVarG1.o0((String) m1.g.k(x4VarV0.n()));
            }
            if (!TextUtils.isEmpty(x4VarV0.o())) {
                aVarG1.u0((String) m1.g.k(x4VarV0.o()));
            }
            if (x4VarV0.V() != -2147483648L) {
                aVarG1.r0((int) x4VarV0.V());
            }
            aVarG1.B0(x4VarV0.A0()).s0(x4VarV0.w0());
            String strQ = x4VarV0.q();
            String strJ = x4VarV0.j();
            if (!TextUtils.isEmpty(strQ)) {
                aVarG1.a1(strQ);
            } else if (!TextUtils.isEmpty(strJ)) {
                aVarG1.N(strJ);
            }
            aVarG1.Q0(x4VarV0.K0());
            v7 v7VarF0 = this.f4241b.f0(str);
            aVarG1.m0(x4VarV0.u0());
            if (this.f3965a.s() && d().Q(aVarG1.n1()) && v7VarF0.w() && !TextUtils.isEmpty(null)) {
                aVarG1.O0(null);
            }
            aVarG1.C0(v7VarF0.u());
            if (v7VarF0.w() && x4VarV0.z()) {
                Pair<String, Boolean> pairA = t().A(x4VarV0.l(), v7VarF0);
                if (!x4VarV0.z() || pairA == null || TextUtils.isEmpty((CharSequence) pairA.first)) {
                    v7Var = v7VarF0;
                } else {
                    try {
                        v7Var = v7VarF0;
                        aVarG1.i1(p((String) pairA.first, Long.toString(zzbjVar.f4302d)));
                        Object obj = pairA.second;
                        if (obj != null) {
                            aVarG1.j0(((Boolean) obj).booleanValue());
                        }
                    } catch (SecurityException e10) {
                        l().G().b("Resettable device id encryption failed", e10.getMessage());
                        byte[] bArr4 = new byte[0];
                        r().r1();
                        return bArr4;
                    }
                }
            } else {
                v7Var = v7VarF0;
            }
            f().q();
            com.google.android.gms.internal.measurement.t5.a aVarK0 = aVarG1.K0(Build.MODEL);
            f().q();
            aVarK0.e1(Build.VERSION.RELEASE).M0((int) f().v()).m1(f().w());
            try {
                if (v7Var.x() && x4VarV0.m() != null) {
                    aVarG1.i0(p((String) m1.g.k(x4VarV0.m()), Long.toString(zzbjVar.f4302d)));
                }
                if (!TextUtils.isEmpty(x4VarV0.p())) {
                    aVarG1.Y0((String) m1.g.k(x4VarV0.p()));
                }
                String strL = x4VarV0.l();
                List<tc> listI1 = r().i1(strL);
                Iterator<tc> it = listI1.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!"_lte".equals(next.f4077c));
                if (next == null || next.f4079e == null) {
                    tc tcVar = new tc(strL, "auto", "_lte", c().a(), 0L);
                    listI1.add(tcVar);
                    r().n0(tcVar);
                }
                com.google.android.gms.internal.measurement.y5[] y5VarArr = new com.google.android.gms.internal.measurement.y5[listI1.size()];
                for (int i10 = 0; i10 < listI1.size(); i10++) {
                    com.google.android.gms.internal.measurement.y5.a aVarC = com.google.android.gms.internal.measurement.y5.Y().z(listI1.get(i10).f4077c).C(listI1.get(i10).f4078d);
                    o().W(aVarC, listI1.get(i10).f4079e);
                    y5VarArr[i10] = (com.google.android.gms.internal.measurement.y5) ((com.google.android.gms.internal.measurement.ea) aVarC.w());
                }
                aVarG1.t0(Arrays.asList(y5VarArr));
                this.f4241b.B(x4VarV0, aVarG1);
                this.f4241b.n0(x4VarV0, aVarG1);
                t5 t5VarB = t5.b(zzbjVar);
                j().O(t5VarB.f4056d, r().R0(str));
                j().X(t5VarB, d().y(str));
                Bundle bundle = t5VarB.f4056d;
                bundle.putLong("_c", 1L);
                l().G().a("Marking in-app purchase as real-time");
                bundle.putLong("_r", 1L);
                bundle.putString("_o", zzbjVar.f4301c);
                if (j().G0(aVarG1.n1(), x4VarV0.v())) {
                    j().P(bundle, "_dbg", 1L);
                    j().P(bundle, "_r", 1L);
                }
                c0 c0VarU0 = r().U0(str, zzbjVar.f4299a);
                if (c0VarU0 == null) {
                    x4Var = x4VarV0;
                    aVar2 = aVarG1;
                    aVar = aVarR;
                    bArr = null;
                    c0VarA = new c0(str, zzbjVar.f4299a, 0L, 0L, zzbjVar.f4302d, 0L, null, null, null, null);
                    j10 = 0;
                } else {
                    aVar = aVarR;
                    x4Var = x4VarV0;
                    aVar2 = aVarG1;
                    bArr = null;
                    long j11 = c0VarU0.f3445f;
                    c0VarA = c0VarU0.a(zzbjVar.f4302d);
                    j10 = j11;
                }
                c0 c0Var = c0VarA;
                r().Z(c0Var);
                d0 d0Var = new d0(this.f3965a, zzbjVar.f4301c, str, zzbjVar.f4299a, zzbjVar.f4302d, j10, bundle);
                com.google.android.gms.internal.measurement.o5.a aVarA = com.google.android.gms.internal.measurement.o5.Y().H(d0Var.f3475d).F(d0Var.f3473b).A(d0Var.f3476e);
                for (String str2 : d0Var.f3477f) {
                    com.google.android.gms.internal.measurement.q5.a aVarC2 = com.google.android.gms.internal.measurement.q5.a0().C(str2);
                    Object objI0 = d0Var.f3477f.i0(str2);
                    if (objI0 != null) {
                        o().V(aVarC2, objI0);
                        aVarA.C(aVarC2);
                    }
                }
                com.google.android.gms.internal.measurement.t5.a aVar3 = aVar2;
                aVar3.F(aVarA).G(com.google.android.gms.internal.measurement.u5.K().v(com.google.android.gms.internal.measurement.p5.K().v(c0Var.f3442c).x(zzbjVar.f4299a)));
                aVar3.L(q().A(x4Var.l(), Collections.EMPTY_LIST, aVar3.T(), Long.valueOf(aVarA.K()), Long.valueOf(aVarA.K()), false));
                if (aVarA.Q()) {
                    aVar3.N0(aVarA.K()).x0(aVarA.K());
                }
                long jE0 = x4Var.E0();
                if (jE0 != 0) {
                    aVar3.F0(jE0);
                }
                long jI0 = x4Var.I0();
                if (jI0 != 0) {
                    aVar3.J0(jI0);
                } else if (jE0 != 0) {
                    aVar3.J0(jE0);
                }
                String strU = x4Var.u();
                if (rf.a() && d().I(str, g0.L0) && strU != null) {
                    aVar3.k1(strU);
                }
                x4Var.y();
                aVar3.w0((int) x4Var.G0()).X0(118003L).U0(c().a()).p0(true);
                this.f4241b.L(aVar3.n1(), aVar3);
                com.google.android.gms.internal.measurement.s5.a aVar4 = aVar;
                aVar4.y(aVar3);
                x4 x4Var2 = x4Var;
                x4Var2.D0(aVar3.v0());
                x4Var2.z0(aVar3.q0());
                r().a0(x4Var2, false, false);
                r().t1();
                r().r1();
                try {
                    return o().i0(((com.google.android.gms.internal.measurement.s5) ((com.google.android.gms.internal.measurement.ea) aVar4.w())).m());
                } catch (IOException e11) {
                    l().H().c("Data loss. Failed to bundle and serialize. appId", p5.w(str), e11);
                    return bArr;
                }
            } catch (SecurityException e12) {
                l().G().b("app instance id encryption failed", e12.getMessage());
                byte[] bArr5 = new byte[0];
                r().r1();
                return bArr5;
            }
        } catch (Throwable th) {
            r().r1();
            throw th;
        }
    }

    public p9(gc gcVar) {
        super(gcVar);
    }
}
