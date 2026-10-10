package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class mc implements Callable<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzq f3825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ gc f3826b;

    mc(gc gcVar, zzq zzqVar) {
        this.f3825a = zzqVar;
        this.f3826b = gcVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() {
        if (!this.f3826b.f0((String) m1.g.k(this.f3825a.f4322a)).x() || !v7.p(this.f3825a.f4342u).x()) {
            this.f3826b.l().L().a("Analytics storage consent denied. Returning null app instance id");
            return null;
        }
        x4 x4VarJ = this.f3826b.j(this.f3825a);
        if (x4VarJ != null) {
            return x4VarJ.m();
        }
        this.f3826b.l().M().a("App info was null when attempting to get app instance id");
        return null;
    }
}
