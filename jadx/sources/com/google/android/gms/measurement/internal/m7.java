package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class m7 implements Callable<zzan> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzq f3807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ w6 f3808b;

    m7(w6 w6Var, zzq zzqVar) {
        this.f3807a = zzqVar;
        this.f3808b = w6Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzan call() {
        this.f3808b.f4143a.P0();
        return new zzan(this.f3808b.f4143a.g(this.f3807a.f4322a));
    }
}
