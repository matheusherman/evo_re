package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class c9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f3457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ z7 f3458b;

    c9(z7 z7Var, AtomicReference atomicReference) {
        this.f3457a = atomicReference;
        this.f3458b = z7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f3457a) {
            try {
                try {
                    this.f3457a.set(Integer.valueOf(this.f3458b.d().z(this.f3458b.q().H(), g0.f3554c0)));
                    this.f3457a.notify();
                } catch (Throwable th) {
                    this.f3457a.notify();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
