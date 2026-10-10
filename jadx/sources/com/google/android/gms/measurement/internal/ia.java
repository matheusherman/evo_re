package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class ia implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzq f3716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ x9 f3717b;

    ia(x9 x9Var, zzq zzqVar) {
        this.f3716a = zzqVar;
        this.f3717b = x9Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        b2.g gVar = this.f3717b.f4201d;
        if (gVar == null) {
            this.f3717b.l().H().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            m1.g.k(this.f3716a);
            gVar.u(this.f3716a);
            this.f3717b.r().M();
            this.f3717b.G(gVar, null, this.f3716a);
            this.f3717b.r0();
        } catch (RemoteException e10) {
            this.f3717b.l().H().b("Failed to send app launch to the service", e10);
        }
    }
}
