package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class o7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbj f3859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f3860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ w6 f3861c;

    o7(w6 w6Var, zzbj zzbjVar, String str) {
        this.f3859a = zzbjVar;
        this.f3860b = str;
        this.f3861c = w6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3861c.f4143a.P0();
        this.f3861c.f4143a.A(this.f3859a, this.f3860b);
    }
}
