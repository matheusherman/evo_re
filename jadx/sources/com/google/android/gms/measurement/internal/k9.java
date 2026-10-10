package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class k9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.internal.measurement.u2 f3758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f3759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f3760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ boolean f3761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f3762e;

    k9(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.u2 u2Var, String str, String str2, boolean z10) {
        this.f3758a = u2Var;
        this.f3759b = str;
        this.f3760c = str2;
        this.f3761d = z10;
        this.f3762e = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3762e.f3357a.N().K(this.f3758a, this.f3759b, this.f3760c, this.f3761d);
    }
}
