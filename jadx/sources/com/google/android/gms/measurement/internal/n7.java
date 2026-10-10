package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class n7 implements Callable<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbj f3836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f3837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ w6 f3838c;

    n7(w6 w6Var, zzbj zzbjVar, String str) {
        this.f3836a = zzbjVar;
        this.f3837b = str;
        this.f3838c = w6Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() {
        this.f3838c.f4143a.P0();
        return this.f3838c.f4143a.J0().z(this.f3836a, this.f3837b);
    }
}
