package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class u9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ q9 f4094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ q9 f4095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ long f4096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ boolean f4097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ s9 f4098e;

    u9(s9 s9Var, q9 q9Var, q9 q9Var2, long j10, boolean z10) {
        this.f4094a = q9Var;
        this.f4095b = q9Var2;
        this.f4096c = j10;
        this.f4097d = z10;
        this.f4098e = s9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4098e.J(this.f4094a, this.f4095b, this.f4096c, this.f4097d, null);
    }
}
