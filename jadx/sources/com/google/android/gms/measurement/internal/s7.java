package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class s7 implements Callable<List<zzow>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzq f4028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Bundle f4029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ w6 f4030c;

    s7(w6 w6Var, zzq zzqVar, Bundle bundle) {
        this.f4028a = zzqVar;
        this.f4029b = bundle;
        this.f4030c = w6Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzow> call() {
        this.f4030c.f4143a.P0();
        return this.f4030c.f4143a.s(this.f4028a, this.f4029b);
    }
}
