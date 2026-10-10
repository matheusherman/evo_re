package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class i7 implements Callable<List<zzai>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f3707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f3708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ w6 f3709d;

    i7(w6 w6Var, String str, String str2, String str3) {
        this.f3706a = str;
        this.f3707b = str2;
        this.f3708c = str3;
        this.f3709d = w6Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzai> call() {
        this.f3709d.f4143a.P0();
        return this.f3709d.f4143a.A0().W(this.f3706a, this.f3707b, this.f3708c);
    }
}
