package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class u6 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ y7 f4089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ s6 f4090b;

    u6(s6 s6Var, y7 y7Var) {
        this.f4089a = y7Var;
        this.f4090b = s6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s6.i(this.f4090b, this.f4089a);
        this.f4090b.f(this.f4089a.f4228g);
    }
}
