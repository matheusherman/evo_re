package com.google.android.gms.internal.measurement;

import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class b4 extends f3.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ Intent f2550e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ f3 f2551f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    b4(f3 f3Var, Intent intent) {
        super(f3Var);
        this.f2550e = intent;
        this.f2551f = f3Var;
    }

    @Override // com.google.android.gms.internal.measurement.f3.a
    final void a() {
        ((p2) m1.g.k(this.f2551f.f2679i)).setSgtmDebugInfo(this.f2550e);
    }
}
