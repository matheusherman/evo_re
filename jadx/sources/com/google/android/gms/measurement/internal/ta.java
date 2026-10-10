package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class ta implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f4064a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzq f4065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ boolean f4066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzai f4067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzai f4068e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ x9 f4069f;

    ta(x9 x9Var, boolean z10, zzq zzqVar, boolean z11, zzai zzaiVar, zzai zzaiVar2) {
        this.f4065b = zzqVar;
        this.f4066c = z11;
        this.f4067d = zzaiVar;
        this.f4068e = zzaiVar2;
        this.f4069f = x9Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        b2.g gVar = this.f4069f.f4201d;
        if (gVar == null) {
            this.f4069f.l().H().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.f4064a) {
            m1.g.k(this.f4065b);
            this.f4069f.G(gVar, this.f4066c ? null : this.f4067d, this.f4065b);
        } else {
            try {
                if (TextUtils.isEmpty(this.f4068e.f4286a)) {
                    m1.g.k(this.f4065b);
                    gVar.n(this.f4067d, this.f4065b);
                } else {
                    gVar.k(this.f4067d);
                }
            } catch (RemoteException e10) {
                this.f4069f.l().H().b("Failed to send conditional user property to the service", e10);
            }
        }
        this.f4069f.r0();
    }
}
