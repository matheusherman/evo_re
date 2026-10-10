package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class k7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzq f3755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ w6 f3756b;

    k7(w6 w6Var, zzq zzqVar) {
        this.f3755a = zzqVar;
        this.f3756b = w6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3756b.f4143a.P0();
        gc gcVar = this.f3756b.f4143a;
        zzq zzqVar = this.f3755a;
        gcVar.a().n();
        gcVar.Q0();
        m1.g.e(zzqVar.f4322a);
        gcVar.D0(zzqVar);
        gcVar.B0(zzqVar);
    }
}
