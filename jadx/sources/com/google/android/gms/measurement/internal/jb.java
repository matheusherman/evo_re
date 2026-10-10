package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private mb f3747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ib f3748b;

    jb(ib ibVar) {
        this.f3748b = ibVar;
    }

    @WorkerThread
    final void a() {
        this.f3748b.n();
        if (this.f3747a != null) {
            this.f3748b.f3718c.removeCallbacks(this.f3747a);
        }
        this.f3748b.h().f3386u.a(false);
        this.f3748b.F(false);
        if (this.f3748b.d().u(g0.Z0) && this.f3748b.s().P0()) {
            this.f3748b.l().L().a("Retrying trigger URI registration in foreground");
            this.f3748b.s().N0();
        }
    }

    @WorkerThread
    final void b(long j10) {
        this.f3747a = new mb(this, this.f3748b.c().a(), j10);
        this.f3748b.f3718c.postDelayed(this.f3747a, 2000L);
    }
}
