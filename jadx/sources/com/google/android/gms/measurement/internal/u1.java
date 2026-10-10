package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class u1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ long f4081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ w f4082c;

    u1(w wVar, String str, long j10) {
        this.f4080a = str;
        this.f4081b = j10;
        this.f4082c = wVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w.E(this.f4082c, this.f4080a, this.f4081b);
    }
}
