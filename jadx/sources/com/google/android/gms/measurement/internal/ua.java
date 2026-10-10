package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class ua implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f4099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f4100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f4101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ String f4102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzq f4103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f4104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ x9 f4105g;

    ua(x9 x9Var, AtomicReference atomicReference, String str, String str2, String str3, zzq zzqVar, boolean z10) {
        this.f4099a = atomicReference;
        this.f4100b = str;
        this.f4101c = str2;
        this.f4102d = str3;
        this.f4103e = zzqVar;
        this.f4104f = z10;
        this.f4105g = x9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f4099a) {
            try {
                try {
                    b2.g gVar = this.f4105g.f4201d;
                    if (gVar == null) {
                        this.f4105g.l().H().d("(legacy) Failed to get user properties; not connected to service", p5.w(this.f4100b), this.f4101c, this.f4102d);
                        this.f4099a.set(Collections.EMPTY_LIST);
                        this.f4099a.notify();
                    } else {
                        if (TextUtils.isEmpty(this.f4100b)) {
                            m1.g.k(this.f4103e);
                            this.f4099a.set(gVar.V(this.f4101c, this.f4102d, this.f4104f, this.f4103e));
                        } else {
                            this.f4099a.set(gVar.r(this.f4100b, this.f4101c, this.f4102d, this.f4104f));
                        }
                        this.f4105g.r0();
                        this.f4099a.notify();
                    }
                } catch (RemoteException e10) {
                    this.f4105g.l().H().d("(legacy) Failed to get user properties; remote exception", p5.w(this.f4100b), this.f4101c, e10);
                    this.f4099a.set(Collections.EMPTY_LIST);
                    this.f4099a.notify();
                }
            } catch (Throwable th) {
                this.f4099a.notify();
                throw th;
            }
        }
    }
}
