package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class z3 extends f3.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ String f3312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ q2 f3313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ f3 f3314g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    z3(f3 f3Var, String str, q2 q2Var) {
        super(f3Var);
        this.f3312e = str;
        this.f3313f = q2Var;
        this.f3314g = f3Var;
    }

    @Override // com.google.android.gms.internal.measurement.f3.a
    final void a() {
        ((p2) m1.g.k(this.f3314g.f2679i)).getMaxUserProperties(this.f3312e, this.f3313f);
    }

    @Override // com.google.android.gms.internal.measurement.f3.a
    protected final void b() {
        this.f3313f.m(null);
    }
}
