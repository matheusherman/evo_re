package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class ea implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzq f3515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ boolean f3516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzpy f3517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ x9 f3518d;

    ea(x9 x9Var, zzq zzqVar, boolean z10, zzpy zzpyVar) {
        this.f3515a = zzqVar;
        this.f3516b = z10;
        this.f3517c = zzpyVar;
        this.f3518d = x9Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        b2.g gVar = this.f3518d.f4201d;
        if (gVar == null) {
            this.f3518d.l().H().a("Discarding data. Failed to set user property");
            return;
        }
        m1.g.k(this.f3515a);
        this.f3518d.G(gVar, this.f3516b ? null : this.f3517c, this.f3515a);
        this.f3518d.r0();
    }
}
