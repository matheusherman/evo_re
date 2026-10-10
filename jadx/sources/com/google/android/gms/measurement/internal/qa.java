package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class qa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f3948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzq f3949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ boolean f3950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzbj f3951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ String f3952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ x9 f3953f;

    qa(x9 x9Var, boolean z10, zzq zzqVar, boolean z11, zzbj zzbjVar, String str) {
        this.f3948a = z10;
        this.f3949b = zzqVar;
        this.f3950c = z11;
        this.f3951d = zzbjVar;
        this.f3952e = str;
        this.f3953f = x9Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        long j10;
        long jB;
        b2.g gVar = this.f3953f.f4201d;
        if (gVar == null) {
            this.f3953f.l().H().a("Discarding data. Failed to send event to service");
            return;
        }
        if (this.f3948a) {
            m1.g.k(this.f3949b);
            this.f3953f.G(gVar, this.f3950c ? null : this.f3951d, this.f3949b);
        } else {
            boolean zU = this.f3953f.d().u(g0.U0);
            try {
                if (TextUtils.isEmpty(this.f3952e)) {
                    m1.g.k(this.f3949b);
                    if (zU) {
                        long jA = this.f3953f.f3965a.c().a();
                        try {
                            jB = this.f3953f.f3965a.c().b();
                            j10 = jA;
                        } catch (RemoteException e10) {
                            e = e10;
                            jB = 0;
                            j10 = jA;
                            this.f3953f.l().H().b("Failed to send event to the service", e);
                            if (zU && j10 != 0) {
                                n5.a(this.f3953f.f3965a).b(36301, 13, j10, this.f3953f.f3965a.c().a(), (int) (this.f3953f.f3965a.c().b() - jB));
                            }
                            this.f3953f.r0();
                        }
                    } else {
                        j10 = 0;
                        jB = 0;
                    }
                    try {
                        gVar.N(this.f3951d, this.f3949b);
                        if (zU) {
                            this.f3953f.l().L().a("Logging telemetry for logEvent");
                            n5.a(this.f3953f.f3965a).b(36301, 0, j10, this.f3953f.f3965a.c().a(), (int) (this.f3953f.f3965a.c().b() - jB));
                        }
                    } catch (RemoteException e11) {
                        e = e11;
                        this.f3953f.l().H().b("Failed to send event to the service", e);
                        if (zU) {
                            n5.a(this.f3953f.f3965a).b(36301, 13, j10, this.f3953f.f3965a.c().a(), (int) (this.f3953f.f3965a.c().b() - jB));
                        }
                    }
                } else {
                    gVar.T(this.f3951d, this.f3952e, this.f3953f.l().P());
                }
            } catch (RemoteException e12) {
                e = e12;
                j10 = 0;
                jB = 0;
            }
        }
        this.f3953f.r0();
    }
}
