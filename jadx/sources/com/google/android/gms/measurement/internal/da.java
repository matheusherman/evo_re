package com.google.android.gms.measurement.internal;

import androidx.annotation.BinderThread;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class da extends b2.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f3490a;

    da(x9 x9Var, AtomicReference atomicReference) {
        this.f3490a = atomicReference;
    }

    @Override // b2.h
    @BinderThread
    public final void z(List<zzow> list) {
        synchronized (this.f3490a) {
            this.f3490a.set(list);
            this.f3490a.notifyAll();
        }
    }
}
