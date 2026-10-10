package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class q7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzpy f3937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzq f3938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ w6 f3939c;

    q7(w6 w6Var, zzpy zzpyVar, zzq zzqVar) {
        this.f3937a = zzpyVar;
        this.f3938b = zzqVar;
        this.f3939c = w6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3939c.f4143a.P0();
        if (this.f3937a.J() == null) {
            this.f3939c.f4143a.P(this.f3937a.f4316b, this.f3938b);
        } else {
            this.f3939c.f4143a.F(this.f3937a, this.f3938b);
        }
    }
}
