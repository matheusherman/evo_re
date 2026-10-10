package b2;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import com.google.android.gms.measurement.internal.p5;
import com.google.android.gms.measurement.internal.s6;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f724a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {
        void a(Context context, Intent intent);
    }

    @MainThread
    public final void a(Context context, Intent intent) {
        p5 p5VarL = s6.d(context, null, null).l();
        if (intent == null) {
            p5VarL.M().a("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        p5VarL.L().b("Local receiver got", action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                p5VarL.M().a("Install Referrer Broadcasts are deprecated");
            }
        } else {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            p5VarL.L().a("Starting wakeful intent.");
            this.f724a.a(context, className);
        }
    }

    public u(a aVar) {
        m1.g.k(aVar);
        this.f724a = aVar;
    }
}
