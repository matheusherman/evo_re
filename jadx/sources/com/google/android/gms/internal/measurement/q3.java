package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class q3 extends f3.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ Runnable f2953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ f3 f2954f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    q3(f3 f3Var, Runnable runnable) {
        super(f3Var);
        this.f2953e = runnable;
        this.f2954f = f3Var;
    }

    @Override // com.google.android.gms.internal.measurement.f3.a
    final void a() {
        ((p2) m1.g.k(this.f2954f.f2679i)).retrieveAndUploadBatches(new p3(this, this.f2953e));
    }
}
