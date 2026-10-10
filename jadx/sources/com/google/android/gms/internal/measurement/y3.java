package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class y3 extends f3.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f3272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ Object f3273g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ f3 f3276j;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ int f3271e = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ Object f3274h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ Object f3275i = null;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    y3(f3 f3Var, boolean z10, int i10, String str, Object obj, Object obj2, Object obj3) {
        super(false);
        this.f3272f = str;
        this.f3273g = obj;
        this.f3276j = f3Var;
    }

    @Override // com.google.android.gms.internal.measurement.f3.a
    final void a() {
        ((p2) m1.g.k(this.f3276j.f2679i)).logHealthData(this.f3271e, this.f3272f, u1.b.W(this.f3273g), u1.b.W(null), u1.b.W(null));
    }
}
