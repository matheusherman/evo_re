package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ t7 f4243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ v f4244b;

    z(v vVar, t7 t7Var) {
        this.f4243a = t7Var;
        this.f4244b = vVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4243a.e();
        if (e.a()) {
            this.f4243a.a().E(this);
            return;
        }
        boolean zE = this.f4244b.e();
        this.f4244b.f4109c = 0L;
        if (zE) {
            this.f4244b.d();
        }
    }
}
