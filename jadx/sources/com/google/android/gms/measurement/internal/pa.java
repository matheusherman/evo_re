package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class pa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbj f3912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f3913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.internal.measurement.u2 f3914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ x9 f3915d;

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                b2.g gVar = this.f3915d.f4201d;
                if (gVar == null) {
                    this.f3915d.l().H().a("Discarding data. Failed to send event to service to bundle");
                    this.f3915d.j().W(this.f3914c, null);
                } else {
                    byte[] bArrW = gVar.w(this.f3912a, this.f3913b);
                    this.f3915d.r0();
                    this.f3915d.j().W(this.f3914c, bArrW);
                }
            } catch (RemoteException e10) {
                this.f3915d.l().H().b("Failed to send event to the service to bundle", e10);
                this.f3915d.j().W(this.f3914c, null);
            }
        } catch (Throwable th) {
            this.f3915d.j().W(this.f3914c, null);
            throw th;
        }
    }

    pa(x9 x9Var, zzbj zzbjVar, String str, com.google.android.gms.internal.measurement.u2 u2Var) {
        this.f3912a = zzbjVar;
        this.f3913b = str;
        this.f3914c = u2Var;
        this.f3915d = x9Var;
    }
}
