package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class ab implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ConnectionResult f3404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ xa f3405b;

    ab(xa xaVar, ConnectionResult connectionResult) {
        this.f3404a = connectionResult;
        this.f3405b = xaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3405b.f4209c.f4201d = null;
        if (this.f3405b.f4209c.d().u(g0.f3594p1) && this.f3404a.J() == 7777) {
            return;
        }
        this.f3405b.f4209c.q0();
    }
}
