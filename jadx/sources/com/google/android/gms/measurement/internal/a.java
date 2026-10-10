package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ long f3364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ w f3365c;

    a(w wVar, String str, long j10) {
        this.f3363a = str;
        this.f3364b = j10;
        this.f3365c = wVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w.A(this.f3365c, this.f3363a, this.f3364b);
    }
}
