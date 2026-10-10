package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class ha implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzq f3692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ x9 f3693b;

    ha(x9 x9Var, zzq zzqVar) {
        this.f3692a = zzqVar;
        this.f3693b = x9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b2.g gVar = this.f3693b.f4201d;
        if (gVar == null) {
            this.f3693b.l().H().a("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            m1.g.k(this.f3692a);
            gVar.R(this.f3692a);
        } catch (RemoteException e10) {
            this.f3693b.l().H().b("Failed to reset data on the service: remote exception", e10);
        }
        this.f3693b.r0();
    }
}
