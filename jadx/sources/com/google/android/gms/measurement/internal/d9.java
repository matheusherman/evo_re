package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class d9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ y f3488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ z7 f3489b;

    d9(z7 z7Var, y yVar) {
        this.f3488a = yVar;
        this.f3489b = z7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f3489b.h().A(this.f3488a)) {
            this.f3489b.l().K().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(this.f3488a.a()));
            return;
        }
        this.f3489b.l().L().b("Setting DMA consent(FE)", this.f3488a);
        if (this.f3489b.v().o0()) {
            this.f3489b.v().j0();
        } else {
            this.f3489b.v().b0(false);
        }
    }
}
