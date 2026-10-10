package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class l7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbj f3783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzq f3784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ w6 f3785c;

    l7(w6 w6Var, zzbj zzbjVar, zzq zzqVar) {
        this.f3783a = zzbjVar;
        this.f3784b = zzqVar;
        this.f3785c = w6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3785c.g0(this.f3785c.c0(this.f3783a, this.f3784b), this.f3784b);
    }
}
