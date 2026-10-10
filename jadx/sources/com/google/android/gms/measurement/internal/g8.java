package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class g8 extends v {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ z7 f3622e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    g8(z7 z7Var, t7 t7Var) {
        super(t7Var);
        this.f3622e = z7Var;
    }

    @Override // com.google.android.gms.measurement.internal.v
    @WorkerThread
    public final void d() {
        final z7 z7VarS = this.f3622e.s();
        Objects.requireNonNull(z7VarS);
        new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.f8
            @Override // java.lang.Runnable
            public final void run() {
                z7VarS.K0();
            }
        }).start();
    }
}
