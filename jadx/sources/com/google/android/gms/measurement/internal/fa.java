package com.google.android.gms.measurement.internal;

import androidx.annotation.BinderThread;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class fa extends b2.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f3543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ x9 f3544b;

    fa(x9 x9Var, AtomicReference atomicReference) {
        this.f3543a = atomicReference;
        this.f3544b = x9Var;
    }

    @Override // b2.l
    @BinderThread
    public final void o(zzpd zzpdVar) {
        synchronized (this.f3543a) {
            this.f3544b.l().L().b("[sgtm] Got upload batches from service. count", Integer.valueOf(zzpdVar.f4314a.size()));
            this.f3543a.set(zzpdVar);
            this.f3543a.notifyAll();
        }
    }
}
