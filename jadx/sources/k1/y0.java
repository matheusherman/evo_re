package k1;

import android.app.Dialog;
import android.app.PendingIntent;
import androidx.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.stub.StubApp;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class y0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w0 f12093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ z0 f12094b;

    y0(z0 z0Var, w0 w0Var) {
        this.f12094b = z0Var;
        this.f12093a = w0Var;
    }

    @Override // java.lang.Runnable
    @MainThread
    public final void run() {
        if (this.f12094b.f12108b) {
            ConnectionResult connectionResultB = this.f12093a.b();
            if (connectionResultB.S()) {
                z0 z0Var = this.f12094b;
                z0Var.f12027a.startActivityForResult(GoogleApiActivity.a(z0Var.b(), (PendingIntent) m1.g.k(connectionResultB.P()), this.f12093a.a(), false), 1);
                return;
            }
            z0 z0Var2 = this.f12094b;
            if (z0Var2.f12111e.b(z0Var2.b(), connectionResultB.J(), null) != null) {
                z0 z0Var3 = this.f12094b;
                z0Var3.f12111e.v(z0Var3.b(), z0Var3.f12027a, connectionResultB.J(), 2, this.f12094b);
                return;
            }
            if (connectionResultB.J() != 18) {
                this.f12094b.l(connectionResultB, this.f12093a.a());
                return;
            }
            z0 z0Var4 = this.f12094b;
            Dialog dialogQ = z0Var4.f12111e.q(z0Var4.b(), z0Var4);
            z0 z0Var5 = this.f12094b;
            z0Var5.f12111e.r(StubApp.getOrigApplicationContext(z0Var5.b().getApplicationContext()), new x0(this, dialogQ));
        }
    }
}
