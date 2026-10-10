package k1;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class c0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ConnectionResult f11990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ d0 f11991b;

    c0(d0 d0Var, ConnectionResult connectionResult) {
        this.f11991b = d0Var;
        this.f11990a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d0 d0Var = this.f11991b;
        z zVar = (z) d0Var.f12000f.f12017j.get(d0Var.f11996b);
        if (zVar == null) {
            return;
        }
        if (!this.f11990a.V()) {
            zVar.I(this.f11990a, null);
            return;
        }
        this.f11991b.f11999e = true;
        if (this.f11991b.f11995a.m()) {
            this.f11991b.i();
            return;
        }
        try {
            d0 d0Var2 = this.f11991b;
            d0Var2.f11995a.b(null, d0Var2.f11995a.a());
        } catch (SecurityException e10) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e10);
            this.f11991b.f11995a.c("Failed to get service from broker.");
            zVar.I(new ConnectionResult(10), null);
        }
    }
}
