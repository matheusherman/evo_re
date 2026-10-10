package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class qb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ib f3954a;

    qb(ib ibVar) {
        this.f3954a = ibVar;
    }

    @VisibleForTesting
    @WorkerThread
    private final void c(long j10, boolean z10) {
        this.f3954a.n();
        if (this.f3954a.f3965a.s()) {
            this.f3954a.h().f3383r.b(j10);
            this.f3954a.l().L().b("Session started, time", Long.valueOf(this.f3954a.c().b()));
            long j11 = j10 / 1000;
            this.f3954a.s().r0("auto", "_sid", Long.valueOf(j11), j10);
            this.f3954a.h().f3384s.b(j11);
            this.f3954a.h().f3379n.a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j11);
            this.f3954a.s().l0("auto", "_s", j10, bundle);
            String strA = this.f3954a.h().f3389x.a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", strA);
            this.f3954a.s().l0("auto", "_ssr", j10, bundle2);
        }
    }

    @WorkerThread
    final void a() {
        this.f3954a.n();
        if (this.f3954a.h().z(this.f3954a.c().a())) {
            this.f3954a.h().f3379n.a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.f3954a.l().L().a("Detected application was in foreground");
                c(this.f3954a.c().a(), false);
            }
        }
    }

    @WorkerThread
    final void b(long j10, boolean z10) {
        this.f3954a.n();
        this.f3954a.I();
        if (this.f3954a.h().z(j10)) {
            this.f3954a.h().f3379n.a(true);
            this.f3954a.q().L();
        }
        this.f3954a.h().f3383r.b(j10);
        if (this.f3954a.h().f3379n.b()) {
            c(j10, z10);
        }
    }
}
