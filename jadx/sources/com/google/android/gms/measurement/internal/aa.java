package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class aa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f3399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzq f3400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ boolean f3401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.internal.measurement.u2 f3402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ x9 f3403f;

    aa(x9 x9Var, String str, String str2, zzq zzqVar, boolean z10, com.google.android.gms.internal.measurement.u2 u2Var) {
        this.f3398a = str;
        this.f3399b = str2;
        this.f3400c = zzqVar;
        this.f3401d = z10;
        this.f3402e = u2Var;
        this.f3403f = x9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle = new Bundle();
        try {
            try {
                b2.g gVar = this.f3403f.f4201d;
                if (gVar == null) {
                    this.f3403f.l().H().c("Failed to get user properties; not connected to service", this.f3398a, this.f3399b);
                    this.f3403f.j().S(this.f3402e, bundle);
                } else {
                    m1.g.k(this.f3400c);
                    Bundle bundleH = wc.H(gVar.V(this.f3398a, this.f3399b, this.f3401d, this.f3400c));
                    this.f3403f.r0();
                    this.f3403f.j().S(this.f3402e, bundleH);
                }
            } catch (RemoteException e10) {
                this.f3403f.l().H().c("Failed to get user properties; remote exception", this.f3398a, e10);
                this.f3403f.j().S(this.f3402e, bundle);
            }
        } catch (Throwable th) {
            this.f3403f.j().S(this.f3402e, bundle);
            throw th;
        }
    }
}
