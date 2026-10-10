package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class f9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ v7 f3539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ long f3540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ boolean f3541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ z7 f3542d;

    f9(z7 z7Var, v7 v7Var, long j10, boolean z10) {
        this.f3539a = v7Var;
        this.f3540b = j10;
        this.f3541c = z10;
        this.f3542d = z7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3542d.U(this.f3539a);
        z7.a0(this.f3542d, this.f3539a, this.f3540b, false, this.f3541c);
    }
}
