package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class ic implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ qc f3723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ gc f3724b;

    ic(gc gcVar, qc qcVar) {
        this.f3723a = qcVar;
        this.f3724b = gcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        gc.D(this.f3724b, this.f3723a);
        this.f3724b.T0();
    }
}
