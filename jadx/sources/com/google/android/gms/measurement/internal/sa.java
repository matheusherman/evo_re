package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class sa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f4042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f4043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f4044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ String f4045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzq f4046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ x9 f4047f;

    sa(x9 x9Var, AtomicReference atomicReference, String str, String str2, String str3, zzq zzqVar) {
        this.f4042a = atomicReference;
        this.f4043b = str;
        this.f4044c = str2;
        this.f4045d = str3;
        this.f4046e = zzqVar;
        this.f4047f = x9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f4042a) {
            try {
                try {
                    b2.g gVar = this.f4047f.f4201d;
                    if (gVar == null) {
                        this.f4047f.l().H().d("(legacy) Failed to get conditional properties; not connected to service", p5.w(this.f4043b), this.f4044c, this.f4045d);
                        this.f4042a.set(Collections.EMPTY_LIST);
                        this.f4042a.notify();
                    } else {
                        if (TextUtils.isEmpty(this.f4043b)) {
                            m1.g.k(this.f4046e);
                            this.f4042a.set(gVar.Q(this.f4044c, this.f4045d, this.f4046e));
                        } else {
                            this.f4042a.set(gVar.E(this.f4043b, this.f4044c, this.f4045d));
                        }
                        this.f4047f.r0();
                        this.f4042a.notify();
                    }
                } catch (RemoteException e10) {
                    this.f4047f.l().H().d("(legacy) Failed to get conditional properties; remote exception", p5.w(this.f4043b), this.f4044c, e10);
                    this.f4042a.set(Collections.EMPTY_LIST);
                    this.f4042a.notify();
                }
            } catch (Throwable th) {
                this.f4042a.notify();
                throw th;
            }
        }
    }
}
