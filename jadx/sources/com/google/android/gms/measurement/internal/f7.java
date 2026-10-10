package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class f7 implements Callable<List<tc>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f3535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f3536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ w6 f3537d;

    f7(w6 w6Var, String str, String str2, String str3) {
        this.f3534a = str;
        this.f3535b = str2;
        this.f3536c = str3;
        this.f3537d = w6Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<tc> call() {
        this.f3537d.f4143a.P0();
        return this.f3537d.f4143a.A0().N0(this.f3534a, this.f3535b, this.f3536c);
    }
}
