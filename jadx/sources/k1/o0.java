package k1;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zak;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class o0 extends d2.a implements com.google.android.gms.common.api.g.a, com.google.android.gms.common.api.g.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final com.google.android.gms.common.api.a.AbstractC0042a f12055h = c2.e.f1111c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f12057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.gms.common.api.a.AbstractC0042a f12058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f12059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final m1.c f12060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c2.f f12061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private n0 f12062g;

    @WorkerThread
    public o0(Context context, Handler handler, @NonNull m1.c cVar) {
        com.google.android.gms.common.api.a.AbstractC0042a abstractC0042a = f12055h;
        this.f12056a = context;
        this.f12057b = handler;
        this.f12060e = (m1.c) m1.g.l(cVar, "ClientSettings must not be null");
        this.f12059d = cVar.e();
        this.f12058c = abstractC0042a;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [c2.f, com.google.android.gms.common.api.a$f] */
    @WorkerThread
    public final void Z(n0 n0Var) {
        c2.f fVar = this.f12061f;
        if (fVar != null) {
            fVar.disconnect();
        }
        this.f12060e.i(Integer.valueOf(System.identityHashCode(this)));
        com.google.android.gms.common.api.a.AbstractC0042a abstractC0042a = this.f12058c;
        Context context = this.f12056a;
        Handler handler = this.f12057b;
        m1.c cVar = this.f12060e;
        this.f12061f = abstractC0042a.a(context, handler.getLooper(), cVar, cVar.f(), this, this);
        this.f12062g = n0Var;
        Set set = this.f12059d;
        if (set == null || set.isEmpty()) {
            this.f12057b.post(new l0(this));
        } else {
            this.f12061f.n();
        }
    }

    @Override // k1.d
    @WorkerThread
    public final void a(int i10) {
        this.f12062g.d(i10);
    }

    public final void a0() {
        c2.f fVar = this.f12061f;
        if (fVar != null) {
            fVar.disconnect();
        }
    }

    @Override // k1.k
    @WorkerThread
    public final void f(@NonNull ConnectionResult connectionResult) {
        this.f12062g.b(connectionResult);
    }

    @Override // k1.d
    @WorkerThread
    public final void g(@Nullable Bundle bundle) {
        this.f12061f.h(this);
    }

    @Override // d2.c
    @BinderThread
    public final void v(zak zakVar) {
        this.f12057b.post(new m0(this, zakVar));
    }

    static /* bridge */ /* synthetic */ void Y(o0 o0Var, zak zakVar) {
        ConnectionResult connectionResultJ = zakVar.J();
        if (connectionResultJ.V()) {
            zav zavVar = (zav) m1.g.k(zakVar.M());
            ConnectionResult connectionResultJ2 = zavVar.J();
            if (!connectionResultJ2.V()) {
                String strValueOf = String.valueOf(connectionResultJ2);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(strValueOf), new Exception());
                o0Var.f12062g.b(connectionResultJ2);
                o0Var.f12061f.disconnect();
                return;
            }
            o0Var.f12062g.c(zavVar.M(), o0Var.f12059d);
        } else {
            o0Var.f12062g.b(connectionResultJ);
        }
        o0Var.f12061f.disconnect();
    }
}
