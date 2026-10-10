package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class s3 extends f3.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ q2 f3024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ f3 f3025f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    s3(f3 f3Var, q2 q2Var) {
        super(f3Var);
        this.f3024e = q2Var;
        this.f3025f = f3Var;
    }

    @Override // com.google.android.gms.internal.measurement.f3.a
    final void a() {
        ((p2) m1.g.k(this.f3025f.f2679i)).getGmpAppId(this.f3024e);
    }

    @Override // com.google.android.gms.internal.measurement.f3.a
    protected final void b() {
        this.f3024e.m(null);
    }
}
