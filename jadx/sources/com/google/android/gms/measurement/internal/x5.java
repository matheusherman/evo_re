package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class x5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f4192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ y5 f4193b;

    x5(y5 y5Var, boolean z10) {
        this.f4192a = z10;
        this.f4193b = y5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4193b.f4217a.S(this.f4192a);
    }
}
