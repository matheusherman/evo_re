package com.google.android.gms.internal.measurement;

import android.app.Activity;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class h4 extends f3.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ Activity f2748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ f3.b f2749f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    h4(f3.b bVar, Activity activity) {
        super(f3.this);
        this.f2748e = activity;
        this.f2749f = bVar;
    }

    @Override // com.google.android.gms.internal.measurement.f3.a
    final void a() {
        ((p2) m1.g.k(f3.this.f2679i)).onActivityPausedByScionActivityInfo(zzeb.J(this.f2748e), this.f2681b);
    }
}
