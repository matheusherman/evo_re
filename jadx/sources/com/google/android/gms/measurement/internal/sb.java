package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class sb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.common.util.d f4048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f4049b;

    public final void a() {
        this.f4049b = 0L;
    }

    public final boolean b(long j10) {
        return this.f4049b == 0 || this.f4048a.b() - this.f4049b >= 3600000;
    }

    public final void c() {
        this.f4049b = this.f4048a.b();
    }

    public sb(com.google.android.gms.common.util.d dVar) {
        m1.g.k(dVar);
        this.f4048a = dVar;
    }
}
