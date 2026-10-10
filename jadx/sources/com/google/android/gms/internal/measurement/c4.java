package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class c4 extends f3.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ Long f2575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f2576f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f2577g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ Bundle f2578h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ boolean f2579i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ boolean f2580j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ f3 f2581k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    c4(f3 f3Var, Long l10, String str, String str2, Bundle bundle, boolean z10, boolean z11) {
        super(f3Var);
        this.f2575e = l10;
        this.f2576f = str;
        this.f2577g = str2;
        this.f2578h = bundle;
        this.f2579i = z10;
        this.f2580j = z11;
        this.f2581k = f3Var;
    }

    @Override // com.google.android.gms.internal.measurement.f3.a
    final void a() {
        Long l10 = this.f2575e;
        ((p2) m1.g.k(this.f2581k.f2679i)).logEvent(this.f2576f, this.f2577g, this.f2578h, this.f2579i, this.f2580j, l10 == null ? this.f2680a : l10.longValue());
    }
}
