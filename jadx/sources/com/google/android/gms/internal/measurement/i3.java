package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class i3 extends f3.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ String f2765e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f2766f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ Bundle f2767g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ f3 f2768h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    i3(f3 f3Var, String str, String str2, Bundle bundle) {
        super(f3Var);
        this.f2765e = str;
        this.f2766f = str2;
        this.f2767g = bundle;
        this.f2768h = f3Var;
    }

    @Override // com.google.android.gms.internal.measurement.f3.a
    final void a() {
        ((p2) m1.g.k(this.f2768h.f2679i)).clearConditionalUserProperty(this.f2765e, this.f2766f, this.f2767g);
    }
}
