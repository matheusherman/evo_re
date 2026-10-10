package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class b7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f3418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f3419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ long f3420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ w6 f3421e;

    b7(w6 w6Var, String str, String str2, String str3, long j10) {
        this.f3417a = str;
        this.f3418b = str2;
        this.f3419c = str3;
        this.f3420d = j10;
        this.f3421e = w6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.f3417a;
        if (str == null) {
            this.f3421e.f4143a.O(this.f3418b, null);
        } else {
            this.f3421e.f4143a.O(this.f3418b, new q9(this.f3419c, str, this.f3420d));
        }
    }
}
