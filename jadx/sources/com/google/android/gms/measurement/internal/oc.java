package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class oc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f3879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ Bundle f3880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ lc f3881d;

    oc(lc lcVar, String str, String str2, Bundle bundle) {
        this.f3878a = str;
        this.f3879b = str2;
        this.f3880c = bundle;
        this.f3881d = lcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3881d.f3790a.A((zzbj) m1.g.k(this.f3881d.f3790a.N0().I(this.f3878a, this.f3879b, this.f3880c, "auto", this.f3881d.f3790a.c().a(), false, true)), this.f3878a);
    }
}
