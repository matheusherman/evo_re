package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class r9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Bundle f3971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ q9 f3972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ q9 f3973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ long f3974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ s9 f3975e;

    r9(s9 s9Var, Bundle bundle, q9 q9Var, q9 q9Var2, long j10) {
        this.f3971a = bundle;
        this.f3972b = q9Var;
        this.f3973c = q9Var2;
        this.f3974d = j10;
        this.f3975e = s9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s9.L(this.f3975e, this.f3971a, this.f3972b, this.f3973c, this.f3974d);
    }
}
