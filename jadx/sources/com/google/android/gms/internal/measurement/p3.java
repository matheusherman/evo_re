package com.google.android.gms.internal.measurement;

import androidx.annotation.BinderThread;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class p3 extends y2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Runnable f2943a;

    p3(q3 q3Var, Runnable runnable) {
        this.f2943a = runnable;
    }

    @Override // com.google.android.gms.internal.measurement.v2
    @BinderThread
    public final void O() {
        this.f2943a.run();
    }
}
