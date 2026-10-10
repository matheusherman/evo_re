package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class va implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f4128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzq f4129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.internal.measurement.u2 f4130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ x9 f4131e;

    va(x9 x9Var, String str, String str2, zzq zzqVar, com.google.android.gms.internal.measurement.u2 u2Var) {
        this.f4127a = str;
        this.f4128b = str2;
        this.f4129c = zzqVar;
        this.f4130d = u2Var;
        this.f4131e = x9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            try {
                b2.g gVar = this.f4131e.f4201d;
                if (gVar == null) {
                    this.f4131e.l().H().c("Failed to get conditional properties; not connected to service", this.f4127a, this.f4128b);
                    this.f4131e.j().U(this.f4130d, arrayList);
                } else {
                    m1.g.k(this.f4129c);
                    ArrayList<Bundle> arrayListU0 = wc.u0(gVar.Q(this.f4127a, this.f4128b, this.f4129c));
                    this.f4131e.r0();
                    this.f4131e.j().U(this.f4130d, arrayListU0);
                }
            } catch (RemoteException e10) {
                this.f4131e.l().H().d("Failed to get conditional properties; remote exception", this.f4127a, this.f4128b, e10);
                this.f4131e.j().U(this.f4130d, arrayList);
            }
        } catch (Throwable th) {
            this.f4131e.j().U(this.f4130d, arrayList);
            throw th;
        }
    }
}
