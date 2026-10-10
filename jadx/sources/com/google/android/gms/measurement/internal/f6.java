package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class f6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final s6 f3533a;

    @VisibleForTesting
    final boolean b() {
        try {
            t1.d dVarA = t1.e.a(this.f3533a.b());
            if (dVarA != null) {
                return dVarA.d("com.android.vending", 128).versionCode >= 80837300;
            }
            this.f3533a.l().L().a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e10) {
            this.f3533a.l().L().b("Failed to retrieve Play Store version for Install Referrer", e10);
            return false;
        }
    }

    @VisibleForTesting
    @WorkerThread
    final Bundle a(String str, com.google.android.gms.internal.measurement.c1 c1Var) {
        this.f3533a.a().n();
        if (c1Var == null) {
            this.f3533a.l().M().a("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle bundleM = c1Var.m(bundle);
            if (bundleM != null) {
                return bundleM;
            }
            this.f3533a.l().H().a("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e10) {
            this.f3533a.l().H().b("Exception occurred while retrieving the Install Referrer", e10.getMessage());
            return null;
        }
    }

    f6(gc gcVar) {
        this.f3533a = gcVar.I0();
    }
}
