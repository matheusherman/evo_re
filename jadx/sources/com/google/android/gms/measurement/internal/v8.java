package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class v8 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f4119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f4120b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f4121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ String f4122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ z7 f4123e;

    v8(z7 z7Var, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f4119a = atomicReference;
        this.f4121c = str2;
        this.f4122d = str3;
        this.f4123e = z7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4123e.f3965a.N().Z(this.f4119a, null, this.f4121c, this.f4122d);
    }
}
