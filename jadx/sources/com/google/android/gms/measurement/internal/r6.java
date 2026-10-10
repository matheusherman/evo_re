package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class r6 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ p6 f3964b;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f3964b.l().H().b(this.f3963a, th);
    }

    public r6(p6 p6Var, String str) {
        this.f3964b = p6Var;
        m1.g.k(str);
        this.f3963a = str;
    }
}
