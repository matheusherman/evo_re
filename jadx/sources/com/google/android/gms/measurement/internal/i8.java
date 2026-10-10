package com.google.android.gms.measurement.internal;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class i8 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ z7 f3710a;

    i8(z7 z7Var) {
        this.f3710a = z7Var;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f3710a.a().E(runnable);
    }
}
