package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class k6 extends LruCache<String, com.google.android.gms.internal.measurement.c0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ j6 f3754a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    k6(j6 j6Var, int i10) {
        super(20);
        this.f3754a = j6Var;
    }

    @Override // androidx.collection.LruCache
    protected final /* synthetic */ com.google.android.gms.internal.measurement.c0 create(String str) {
        String str2 = str;
        m1.g.e(str2);
        return this.f3754a.d().u(g0.f3591o1) ? j6.K(this.f3754a, str2) : j6.C(this.f3754a, str2);
    }
}
