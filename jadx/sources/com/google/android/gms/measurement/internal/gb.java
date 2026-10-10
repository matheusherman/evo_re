package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class gb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ gc f3630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Runnable f3631b;

    gb(fb fbVar, gc gcVar, Runnable runnable) {
        this.f3630a = gcVar;
        this.f3631b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3630a.P0();
        this.f3630a.G(this.f3631b);
        this.f3630a.U0();
    }
}
