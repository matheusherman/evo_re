package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class ob {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    private long f3874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    protected long f3875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v f3876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ib f3877d;

    public ob(ib ibVar) {
        this.f3877d = ibVar;
        this.f3876c = new nb(this, ibVar.f3965a);
        long jB = ibVar.c().b();
        this.f3874a = jB;
        this.f3875b = jB;
    }

    static /* synthetic */ void c(ob obVar) {
        obVar.f3877d.n();
        obVar.d(false, false, obVar.f3877d.c().b());
        obVar.f3877d.o().x(obVar.f3877d.c().b());
    }

    @VisibleForTesting
    @WorkerThread
    final long a(long j10) {
        long j11 = j10 - this.f3875b;
        this.f3875b = j10;
        return j11;
    }

    final void b() {
        this.f3876c.a();
        if (this.f3877d.d().u(g0.f3555c1)) {
            this.f3874a = this.f3877d.c().b();
        } else {
            this.f3874a = 0L;
        }
        this.f3875b = this.f3874a;
    }

    @WorkerThread
    public final boolean d(boolean z10, boolean z11, long j10) {
        this.f3877d.n();
        this.f3877d.z();
        if (this.f3877d.f3965a.s()) {
            this.f3877d.h().f3383r.b(this.f3877d.c().a());
        }
        long jA = j10 - this.f3874a;
        if (!z10 && jA < 1000) {
            this.f3877d.l().L().b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(jA));
            return false;
        }
        if (!z11) {
            jA = a(j10);
        }
        this.f3877d.l().L().b("Recording user engagement, ms", Long.valueOf(jA));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", jA);
        wc.Y(this.f3877d.u().E(!this.f3877d.d().Y()), bundle, true);
        if (!z11) {
            this.f3877d.s().h1("auto", "_e", bundle);
        }
        this.f3874a = j10;
        this.f3876c.a();
        this.f3876c.b(g0.f3593p0.a(null).longValue());
        return true;
    }

    @WorkerThread
    final void e(long j10) {
        this.f3876c.a();
    }

    @WorkerThread
    final void f(long j10) {
        this.f3877d.n();
        this.f3876c.a();
        this.f3874a = j10;
        this.f3875b = j10;
    }
}
