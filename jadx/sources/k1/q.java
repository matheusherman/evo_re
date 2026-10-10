package k1;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class q extends z0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArraySet f12066f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e f12067g;

    private final void v() {
        if (this.f12066f.isEmpty()) {
            return;
        }
        this.f12067g.a(this);
    }

    @Override // k1.z0
    protected final void m(ConnectionResult connectionResult, int i10) {
        this.f12067g.B(connectionResult, i10);
    }

    @Override // k1.z0
    protected final void n() {
        this.f12067g.C();
    }

    final ArraySet t() {
        return this.f12066f;
    }

    @VisibleForTesting
    q(h hVar, e eVar, com.google.android.gms.common.a aVar) {
        super(hVar, aVar);
        this.f12066f = new ArraySet();
        this.f12067g = eVar;
        this.f12027a.B("ConnectionlessLifecycleHelper", this);
    }

    @MainThread
    public static void u(Activity activity, e eVar, b bVar) {
        h hVarC = g.c(activity);
        q qVar = (q) hVarC.w("ConnectionlessLifecycleHelper", q.class);
        if (qVar == null) {
            qVar = new q(hVarC, eVar, com.google.android.gms.common.a.m());
        }
        m1.g.l(bVar, "ApiKey cannot be null");
        qVar.f12066f.add(bVar);
        eVar.a(qVar);
    }

    @Override // k1.g
    public final void h() {
        super.h();
        v();
    }

    @Override // k1.z0, k1.g
    public final void j() {
        super.j();
        v();
    }

    @Override // k1.z0, k1.g
    public final void k() {
        super.k();
        this.f12067g.b(this);
    }
}
