package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class k3 extends f3.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ String f2797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f2798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ q2 f2799g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ f3 f2800h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    k3(f3 f3Var, String str, String str2, q2 q2Var) {
        super(f3Var);
        this.f2797e = str;
        this.f2798f = str2;
        this.f2799g = q2Var;
        this.f2800h = f3Var;
    }

    @Override // com.google.android.gms.internal.measurement.f3.a
    final void a() {
        ((p2) m1.g.k(this.f2800h.f2679i)).getConditionalUserProperties(this.f2797e, this.f2798f, this.f2799g);
    }

    @Override // com.google.android.gms.internal.measurement.f3.a
    protected final void b() {
        this.f2799g.m(null);
    }
}
