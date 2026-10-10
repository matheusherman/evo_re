package k1;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class d0 implements com.google.android.gms.common.internal.b.c, n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.common.api.a.f f11995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f11996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private com.google.android.gms.common.internal.e f11997c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private Set f11998d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f11999e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ e f12000f;

    public d0(e eVar, com.google.android.gms.common.api.a.f fVar, b bVar) {
        this.f12000f = eVar;
        this.f11995a = fVar;
        this.f11996b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void i() {
        com.google.android.gms.common.internal.e eVar;
        if (!this.f11999e || (eVar = this.f11997c) == null) {
            return;
        }
        this.f11995a.b(eVar, this.f11998d);
    }

    @Override // com.google.android.gms.common.internal.b.c
    public final void a(@NonNull ConnectionResult connectionResult) {
        this.f12000f.f12021n.post(new c0(this, connectionResult));
    }

    @Override // k1.n0
    @WorkerThread
    public final void b(ConnectionResult connectionResult) {
        z zVar = (z) this.f12000f.f12017j.get(this.f11996b);
        if (zVar != null) {
            zVar.J(connectionResult);
        }
    }

    @Override // k1.n0
    @WorkerThread
    public final void c(@Nullable com.google.android.gms.common.internal.e eVar, @Nullable Set set) {
        if (eVar == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            b(new ConnectionResult(4));
        } else {
            this.f11997c = eVar;
            this.f11998d = set;
            i();
        }
    }

    @Override // k1.n0
    @WorkerThread
    public final void d(int i10) {
        z zVar = (z) this.f12000f.f12017j.get(this.f11996b);
        if (zVar != null) {
            if (zVar.f12103i) {
                zVar.J(new ConnectionResult(17));
            } else {
                zVar.a(i10);
            }
        }
    }
}
