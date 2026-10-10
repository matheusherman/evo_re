package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.ke;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class c extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.google.android.gms.internal.measurement.p4 f3438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zc f3439h;

    @Override // com.google.android.gms.measurement.internal.d
    final boolean i() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.d
    final boolean j() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    c(zc zcVar, String str, int i10, com.google.android.gms.internal.measurement.p4 p4Var) {
        super(str, i10);
        this.f3439h = zcVar;
        this.f3438g = p4Var;
    }

    @Override // com.google.android.gms.measurement.internal.d
    final int a() {
        return this.f3438g.n();
    }

    final boolean k(Long l10, Long l11, com.google.android.gms.internal.measurement.y5 y5Var, boolean z10) {
        boolean z11;
        boolean z12;
        Object obj;
        if (ke.a() && this.f3439h.d().K(this.f3466a, g0.C0)) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean zQ = this.f3438g.Q();
        boolean zR = this.f3438g.R();
        boolean zS = this.f3438g.S();
        if (!zQ && !zR && !zS) {
            z12 = false;
        } else {
            z12 = true;
        }
        Boolean boolD = null;
        Integer numValueOf = null;
        boolD = null;
        boolD = null;
        boolD = null;
        boolD = null;
        if (z10 && !z12) {
            r5 r5VarL = this.f3439h.l().L();
            Integer numValueOf2 = Integer.valueOf(this.f3467b);
            if (this.f3438g.T()) {
                numValueOf = Integer.valueOf(this.f3438g.n());
            }
            r5VarL.c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", numValueOf2, numValueOf);
            return true;
        }
        com.google.android.gms.internal.measurement.n4 n4VarL = this.f3438g.L();
        boolean zR2 = n4VarL.R();
        if (y5Var.e0()) {
            if (!n4VarL.T()) {
                this.f3439h.l().M().b("No number filter for long property. property", this.f3439h.g().g(y5Var.a0()));
            } else {
                boolD = d.d(d.c(y5Var.U(), n4VarL.N()), zR2);
            }
        } else if (y5Var.c0()) {
            if (!n4VarL.T()) {
                this.f3439h.l().M().b("No number filter for double property. property", this.f3439h.g().g(y5Var.a0()));
            } else {
                boolD = d.d(d.b(y5Var.K(), n4VarL.N()), zR2);
            }
        } else if (y5Var.g0()) {
            if (!n4VarL.W()) {
                if (!n4VarL.T()) {
                    this.f3439h.l().M().b("No string or number filter defined. property", this.f3439h.g().g(y5Var.a0()));
                } else if (sc.h0(y5Var.b0())) {
                    boolD = d.d(d.e(y5Var.b0(), n4VarL.N()), zR2);
                } else {
                    this.f3439h.l().M().c("Invalid user property value for Numeric number filter. property, value", this.f3439h.g().g(y5Var.a0()), y5Var.b0());
                }
            } else {
                boolD = d.d(d.g(y5Var.b0(), n4VarL.O(), this.f3439h.l()), zR2);
            }
        } else {
            this.f3439h.l().M().b("User property has no value, property", this.f3439h.g().g(y5Var.a0()));
        }
        r5 r5VarL2 = this.f3439h.l().L();
        if (boolD == null) {
            obj = Configurator.NULL;
        } else {
            obj = boolD;
        }
        r5VarL2.b("Property filter result", obj);
        if (boolD == null) {
            return false;
        }
        this.f3468c = Boolean.TRUE;
        if (zS && !boolD.booleanValue()) {
            return true;
        }
        if (!z10 || this.f3438g.Q()) {
            this.f3469d = boolD;
        }
        if (boolD.booleanValue() && z12 && y5Var.f0()) {
            long jX = y5Var.X();
            if (l10 != null) {
                jX = l10.longValue();
            }
            if (z11 && this.f3438g.Q() && !this.f3438g.R() && l11 != null) {
                jX = l11.longValue();
            }
            if (this.f3438g.R()) {
                this.f3471f = Long.valueOf(jX);
            } else {
                this.f3470e = Long.valueOf(jX);
            }
        }
        return true;
    }
}
