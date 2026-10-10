package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class bb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ xa f3428a;

    bb(xa xaVar) {
        this.f3428a = xaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x9.P(this.f3428a.f4209c, new ComponentName(this.f3428a.f4209c.b(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
