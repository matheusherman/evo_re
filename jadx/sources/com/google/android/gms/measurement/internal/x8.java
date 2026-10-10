package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class x8 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.internal.measurement.u2 f4198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ z7 f4199b;

    x8(z7 z7Var, com.google.android.gms.internal.measurement.u2 u2Var) {
        this.f4198a = u2Var;
        this.f4199b = z7Var;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0057  */
    /* JADX WARN: Code duplicated, block: B:20:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() {
        Long lValueOf;
        ib ibVarW = this.f4199b.w();
        if (ibVarW.h().O().x()) {
            if (!ibVarW.h().z(ibVarW.c().a()) && ibVarW.h().f3384s.a() != 0) {
                lValueOf = Long.valueOf(ibVarW.h().f3384s.a());
            }
            if (lValueOf != null) {
                this.f4199b.f3965a.P().R(this.f4198a, lValueOf.longValue());
            }
            try {
                this.f4198a.m(null);
            } catch (RemoteException e10) {
                this.f4199b.f3965a.l().H().b("getSessionId failed with exception", e10);
                return;
            }
        }
        ibVarW.l().N().a("Analytics storage consent denied; will not get session id");
        lValueOf = null;
        if (lValueOf != null) {
            this.f4199b.f3965a.P().R(this.f4198a, lValueOf.longValue());
        } else {
            this.f4198a.m(null);
        }
    }
}
