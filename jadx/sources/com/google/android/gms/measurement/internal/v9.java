package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class v9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ q9 f4124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ long f4125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ s9 f4126c;

    v9(s9 s9Var, q9 q9Var, long j10) {
        this.f4124a = q9Var;
        this.f4125b = j10;
        this.f4126c = s9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4126c.K(this.f4124a, false, this.f4125b);
        s9 s9Var = this.f4126c;
        s9Var.f4034e = null;
        s9Var.v().O(null);
    }
}
