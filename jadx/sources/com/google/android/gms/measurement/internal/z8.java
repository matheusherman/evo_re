package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class z8 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f4273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ z7 f4274b;

    z8(z7 z7Var, AtomicReference atomicReference) {
        this.f4273a = atomicReference;
        this.f4274b = z7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f4273a) {
            try {
                try {
                    this.f4273a.set(Long.valueOf(this.f4274b.d().D(this.f4274b.q().H(), g0.f3551b0)));
                    this.f4273a.notify();
                } catch (Throwable th) {
                    this.f4273a.notify();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
