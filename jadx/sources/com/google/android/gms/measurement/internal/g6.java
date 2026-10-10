package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import org.apache.log4j.spi.LocationInfo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class g6 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.internal.measurement.c1 f3615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ServiceConnection f3616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ h6 f3617c;

    g6(h6 h6Var, com.google.android.gms.internal.measurement.c1 c1Var, ServiceConnection serviceConnection) {
        this.f3615a = c1Var;
        this.f3616b = serviceConnection;
        this.f3617c = h6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h6 h6Var = this.f3617c;
        f6 f6Var = h6Var.f3684b;
        String str = h6Var.f3683a;
        com.google.android.gms.internal.measurement.c1 c1Var = this.f3615a;
        ServiceConnection serviceConnection = this.f3616b;
        Bundle bundleA = f6Var.a(str, c1Var);
        f6Var.f3533a.a().n();
        f6Var.f3533a.o();
        if (bundleA != null) {
            long j10 = bundleA.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j10 == 0) {
                f6Var.f3533a.l().M().a("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundleA.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    f6Var.f3533a.l().H().a("No referrer defined in Install Referrer response");
                } else {
                    f6Var.f3533a.l().L().b("InstallReferrer API result", string);
                    Bundle bundleD = f6Var.f3533a.P().D(Uri.parse(LocationInfo.NA + string));
                    if (bundleD == null) {
                        f6Var.f3533a.l().H().a("No campaign params defined in Install Referrer result");
                    } else {
                        if (bundleD.containsKey("gclid") || bundleD.containsKey("gbraid")) {
                            long j11 = bundleA.getLong("referrer_click_timestamp_server_seconds", 0L) * 1000;
                            if (j11 > 0) {
                                bundleD.putLong("click_timestamp", j11);
                            }
                        }
                        if (j10 == f6Var.f3533a.H().f3373h.a()) {
                            f6Var.f3533a.l().L().a("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (f6Var.f3533a.s()) {
                            f6Var.f3533a.H().f3373h.b(j10);
                            f6Var.f3533a.l().L().b("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            bundleD.putString("_cis", "referrer API v2");
                            f6Var.f3533a.J().p0("auto", "_cmp", bundleD, str);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            s1.b.b().c(f6Var.f3533a.b(), serviceConnection);
        }
    }
}
