package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class z6 implements Callable<List<tc>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ w6 f4251b;

    z6(w6 w6Var, String str) {
        this.f4250a = str;
        this.f4251b = w6Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<tc> call() {
        this.f4251b.f4143a.P0();
        return this.f4251b.f4143a.A0().i1(this.f4250a);
    }
}
