package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class j7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzq f3740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ w6 f3741b;

    j7(w6 w6Var, zzq zzqVar) {
        this.f3740a = zzqVar;
        this.f3741b = w6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3741b.f4143a.P0();
        this.f3741b.f4143a.y0(this.f3740a);
    }
}
