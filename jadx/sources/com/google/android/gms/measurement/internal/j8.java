package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class j8 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f3742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ z7 f3743b;

    j8(z7 z7Var, boolean z10) {
        this.f3742a = z10;
        this.f3743b = z7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zS = this.f3743b.f3965a.s();
        boolean zR = this.f3743b.f3965a.r();
        this.f3743b.f3965a.n(this.f3742a);
        if (zR == this.f3742a) {
            this.f3743b.f3965a.l().L().b("Default data collection state already set to", Boolean.valueOf(this.f3742a));
        }
        if (this.f3743b.f3965a.s() == zS || this.f3743b.f3965a.s() != this.f3743b.f3965a.r()) {
            this.f3743b.f3965a.l().N().c("Default data collection is different than actual status", Boolean.valueOf(this.f3742a), Boolean.valueOf(zS));
        }
        this.f3743b.Q0();
    }
}
