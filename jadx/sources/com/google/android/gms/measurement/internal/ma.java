package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class ma implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f3816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzq f3817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ boolean f3818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzbi f3819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ Bundle f3820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ x9 f3821f;

    ma(x9 x9Var, boolean z10, zzq zzqVar, boolean z11, zzbi zzbiVar, Bundle bundle) {
        this.f3816a = z10;
        this.f3817b = zzqVar;
        this.f3818c = z11;
        this.f3819d = zzbiVar;
        this.f3820e = bundle;
        this.f3821f = x9Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        b2.g gVar = this.f3821f.f4201d;
        if (gVar == null) {
            this.f3821f.l().H().a("Failed to send default event parameters to service");
            return;
        }
        if (this.f3821f.d().u(g0.f3588n1) && this.f3816a) {
            m1.g.k(this.f3817b);
            this.f3821f.G(gVar, this.f3818c ? null : this.f3819d, this.f3817b);
            return;
        }
        try {
            m1.g.k(this.f3817b);
            gVar.F(this.f3820e, this.f3817b);
            this.f3821f.r0();
        } catch (RemoteException e10) {
            this.f3821f.l().H().b("Failed to send default event parameters to service", e10);
        }
    }
}
