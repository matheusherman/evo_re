package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class na implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ q9 f3846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ x9 f3847b;

    na(x9 x9Var, q9 q9Var) {
        this.f3846a = q9Var;
        this.f3847b = x9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b2.g gVar = this.f3847b.f4201d;
        if (gVar == null) {
            this.f3847b.l().H().a("Failed to send current screen to service");
            return;
        }
        try {
            q9 q9Var = this.f3846a;
            if (q9Var == null) {
                gVar.B(0L, null, null, this.f3847b.b().getPackageName());
            } else {
                gVar.B(q9Var.f3944c, q9Var.f3942a, q9Var.f3943b, this.f3847b.b().getPackageName());
            }
            this.f3847b.r0();
        } catch (RemoteException e10) {
            this.f3847b.l().H().b("Failed to send current screen to the service", e10);
        }
    }
}
