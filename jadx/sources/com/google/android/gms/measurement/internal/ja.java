package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class ja implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzq f3744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.internal.measurement.u2 f3745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ x9 f3746c;

    ja(x9 x9Var, zzq zzqVar, com.google.android.gms.internal.measurement.u2 u2Var) {
        this.f3744a = zzqVar;
        this.f3745b = u2Var;
        this.f3746c = x9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                if (!this.f3746c.h().O().x()) {
                    this.f3746c.l().N().a("Analytics storage consent denied; will not get app instance id");
                    this.f3746c.s().Z0(null);
                    this.f3746c.h().f3374i.b(null);
                    this.f3746c.j().T(this.f3745b, null);
                    return;
                }
                b2.g gVar = this.f3746c.f4201d;
                if (gVar == null) {
                    this.f3746c.l().H().a("Failed to get app instance id");
                    this.f3746c.j().T(this.f3745b, null);
                    return;
                }
                m1.g.k(this.f3744a);
                String strI = gVar.i(this.f3744a);
                if (strI != null) {
                    this.f3746c.s().Z0(strI);
                    this.f3746c.h().f3374i.b(strI);
                }
                this.f3746c.r0();
                this.f3746c.j().T(this.f3745b, strI);
            } catch (RemoteException e10) {
                this.f3746c.l().H().b("Failed to get app instance id", e10);
                this.f3746c.j().T(this.f3745b, null);
            }
        } catch (Throwable th) {
            this.f3746c.j().T(this.f3745b, null);
            throw th;
        }
    }
}
