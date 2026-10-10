package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class l8 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ long f3786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ z7 f3787b;

    l8(z7 z7Var, long j10) {
        this.f3786a = j10;
        this.f3787b = z7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3787b.h().f3378m.b(this.f3786a);
        this.f3787b.l().G().b("Session timeout duration set", Long.valueOf(this.f3786a));
    }
}
