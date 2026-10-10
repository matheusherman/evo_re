package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class ga implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f3627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzq f3628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ x9 f3629c;

    ga(x9 x9Var, AtomicReference atomicReference, zzq zzqVar) {
        this.f3627a = atomicReference;
        this.f3628b = zzqVar;
        this.f3629c = x9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f3627a) {
            try {
                try {
                    if (!this.f3629c.h().O().x()) {
                        this.f3629c.l().N().a("Analytics storage consent denied; will not get app instance id");
                        this.f3629c.s().Z0(null);
                        this.f3629c.h().f3374i.b(null);
                        this.f3627a.set(null);
                        this.f3627a.notify();
                        return;
                    }
                    b2.g gVar = this.f3629c.f4201d;
                    if (gVar == null) {
                        this.f3629c.l().H().a("Failed to get app instance id");
                        this.f3627a.notify();
                        return;
                    }
                    m1.g.k(this.f3628b);
                    this.f3627a.set(gVar.i(this.f3628b));
                    String str = (String) this.f3627a.get();
                    if (str != null) {
                        this.f3629c.s().Z0(str);
                        this.f3629c.h().f3374i.b(str);
                    }
                    this.f3629c.r0();
                    this.f3627a.notify();
                } catch (RemoteException e10) {
                    this.f3629c.l().H().b("Failed to get app instance id", e10);
                    this.f3627a.notify();
                }
            } catch (Throwable th) {
                this.f3627a.notify();
                throw th;
            }
        }
    }
}
