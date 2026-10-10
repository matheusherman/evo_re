package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class y8 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f4232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f4233b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f4234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ String f4235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ boolean f4236e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ z7 f4237f;

    y8(z7 z7Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z10) {
        this.f4232a = atomicReference;
        this.f4234c = str2;
        this.f4235d = str3;
        this.f4236e = z10;
        this.f4237f = z7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4237f.f3965a.N().a0(this.f4232a, null, this.f4234c, this.f4235d, this.f4236e);
    }
}
