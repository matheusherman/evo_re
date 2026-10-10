package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class ba implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f3424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzq f3425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ Bundle f3426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ x9 f3427d;

    ba(x9 x9Var, AtomicReference atomicReference, zzq zzqVar, Bundle bundle) {
        this.f3424a = atomicReference;
        this.f3425b = zzqVar;
        this.f3426c = bundle;
        this.f3427d = x9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f3424a) {
            try {
                try {
                    b2.g gVar = this.f3427d.f4201d;
                    if (gVar == null) {
                        this.f3427d.l().H().a("Failed to get trigger URIs; not connected to service");
                        this.f3424a.notify();
                    } else {
                        m1.g.k(this.f3425b);
                        this.f3424a.set(gVar.l(this.f3425b, this.f3426c));
                        this.f3427d.r0();
                        this.f3424a.notify();
                    }
                } catch (RemoteException e10) {
                    this.f3427d.l().H().b("Failed to get trigger URIs; remote exception", e10);
                    this.f3424a.notify();
                }
            } catch (Throwable th) {
                this.f3424a.notify();
                throw th;
            }
        }
    }
}
