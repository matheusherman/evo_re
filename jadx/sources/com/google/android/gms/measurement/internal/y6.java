package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class y6 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzq f4220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ w6 f4221b;

    y6(w6 w6Var, zzq zzqVar) {
        this.f4220a = zzqVar;
        this.f4221b = w6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4221b.f4143a.P0();
        this.f4221b.f4143a.w0(this.f4220a);
    }
}
