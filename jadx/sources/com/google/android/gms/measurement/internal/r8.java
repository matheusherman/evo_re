package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class r8 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f3967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ Object f3968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ long f3969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ z7 f3970e;

    r8(z7 z7Var, String str, String str2, Object obj, long j10) {
        this.f3966a = str;
        this.f3967b = str2;
        this.f3968c = obj;
        this.f3969d = j10;
        this.f3970e = z7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3970e.r0(this.f3966a, this.f3967b, this.f3968c, this.f3969d);
    }
}
