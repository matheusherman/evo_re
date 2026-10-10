package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class db implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.internal.measurement.u2 f3491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f3492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f3493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f3494d;

    db(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.u2 u2Var, String str, String str2) {
        this.f3491a = u2Var;
        this.f3492b = str;
        this.f3493c = str2;
        this.f3494d = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3494d.f3357a.N().J(this.f3491a, this.f3492b, this.f3493c);
    }
}
