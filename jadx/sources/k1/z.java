package k1;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.p000lifecycle.CoroutineLiveDataKt;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class z implements com.google.android.gms.common.api.g.a, com.google.android.gms.common.api.g.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.gms.common.api.a.f f12096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f12097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final p f12098d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f12101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final o0 f12102h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f12103i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ e f12107m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue f12095a = new LinkedList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f12099e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f12100f = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f12104j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private ConnectionResult f12105k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f12106l = 0;

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    @WorkerThread
    private final Feature d(@Nullable Feature[] featureArr) {
        if (featureArr != null && featureArr.length != 0) {
            Feature[] featureArrK = this.f12096b.k();
            if (featureArrK == null) {
                featureArrK = new Feature[0];
            }
            ArrayMap arrayMap = new ArrayMap(featureArrK.length);
            for (Feature feature : featureArrK) {
                arrayMap.put(feature.J(), Long.valueOf(feature.M()));
            }
            for (Feature feature2 : featureArr) {
                Long l10 = (Long) arrayMap.get(feature2.J());
                if (l10 == null || l10.longValue() < feature2.M()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    @ResultIgnorabilityUnspecified
    @WorkerThread
    public final boolean c() {
        return r(true);
    }

    @Override // k1.k
    @WorkerThread
    public final void f(@NonNull ConnectionResult connectionResult) {
        I(connectionResult, null);
    }

    @WorkerThread
    public z(e eVar, com.google.android.gms.common.api.f fVar) {
        this.f12107m = eVar;
        com.google.android.gms.common.api.a.f fVarH = fVar.h(eVar.f12021n.getLooper(), this);
        this.f12096b = fVarH;
        this.f12097c = fVar.e();
        this.f12098d = new p();
        this.f12101g = fVar.g();
        if (fVarH.m()) {
            this.f12102h = fVar.i(eVar.f12012e, eVar.f12021n);
        } else {
            this.f12102h = null;
        }
    }

    static /* bridge */ /* synthetic */ void C(z zVar, b0 b0Var) {
        if (zVar.f12104j.contains(b0Var) && !zVar.f12103i) {
            if (zVar.f12096b.isConnected()) {
                zVar.j();
            } else {
                zVar.F();
            }
        }
    }

    static /* bridge */ /* synthetic */ void D(z zVar, b0 b0Var) {
        Feature[] featureArrG;
        if (zVar.f12104j.remove(b0Var)) {
            zVar.f12107m.f12021n.removeMessages(15, b0Var);
            zVar.f12107m.f12021n.removeMessages(16, b0Var);
            Feature feature = b0Var.f11982b;
            ArrayList arrayList = new ArrayList(zVar.f12095a.size());
            for (u0 u0Var : zVar.f12095a) {
                if ((u0Var instanceof g0) && (featureArrG = ((g0) u0Var).g(zVar)) != null && com.google.android.gms.common.util.b.b(featureArrG, feature)) {
                    arrayList.add(u0Var);
                }
            }
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                u0 u0Var2 = (u0) arrayList.get(i10);
                zVar.f12095a.remove(u0Var2);
                u0Var2.b(new com.google.android.gms.common.api.m(feature));
            }
        }
    }

    @WorkerThread
    private final void e(ConnectionResult connectionResult) {
        Iterator it = this.f12099e.iterator();
        while (it.hasNext()) {
            ((v0) it.next()).b(this.f12097c, connectionResult, m1.f.a(connectionResult, ConnectionResult.f2120e) ? this.f12096b.e() : null);
        }
        this.f12099e.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void h(Status status) {
        m1.g.c(this.f12107m.f12021n);
        i(status, null, false);
    }

    @WorkerThread
    private final void i(@Nullable Status status, @Nullable Exception exc, boolean z10) {
        m1.g.c(this.f12107m.f12021n);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f12095a.iterator();
        while (it.hasNext()) {
            u0 u0Var = (u0) it.next();
            if (!z10 || u0Var.f12078a == 2) {
                if (status != null) {
                    u0Var.a(status);
                } else {
                    u0Var.b(exc);
                }
                it.remove();
            }
        }
    }

    @WorkerThread
    private final void j() {
        ArrayList arrayList = new ArrayList(this.f12095a);
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            u0 u0Var = (u0) arrayList.get(i10);
            if (!this.f12096b.isConnected()) {
                return;
            }
            if (p(u0Var)) {
                this.f12095a.remove(u0Var);
            }
        }
    }

    private final void m() {
        this.f12107m.f12021n.removeMessages(12, this.f12097c);
        b bVar = this.f12097c;
        e eVar = this.f12107m;
        eVar.f12021n.sendMessageDelayed(eVar.f12021n.obtainMessage(12, bVar), this.f12107m.f12008a);
    }

    @WorkerThread
    private final void n(u0 u0Var) {
        u0Var.d(this.f12098d, b());
        try {
            u0Var.c(this);
        } catch (DeadObjectException unused) {
            a(1);
            this.f12096b.c("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    @WorkerThread
    private final void o() {
        if (this.f12103i) {
            e eVar = this.f12107m;
            eVar.f12021n.removeMessages(11, this.f12097c);
            e eVar2 = this.f12107m;
            eVar2.f12021n.removeMessages(9, this.f12097c);
            this.f12103i = false;
        }
    }

    @WorkerThread
    private final boolean p(u0 u0Var) {
        if (!(u0Var instanceof g0)) {
            n(u0Var);
            return true;
        }
        g0 g0Var = (g0) u0Var;
        Feature featureD = d(g0Var.g(this));
        if (featureD == null) {
            n(u0Var);
            return true;
        }
        Log.w("GoogleApiManager", this.f12096b.getClass().getName() + " could not execute call because it requires feature (" + featureD.J() + ", " + featureD.M() + ").");
        if (!this.f12107m.f12022o || !g0Var.f(this)) {
            g0Var.b(new com.google.android.gms.common.api.m(featureD));
            return true;
        }
        b0 b0Var = new b0(this.f12097c, featureD, null);
        int iIndexOf = this.f12104j.indexOf(b0Var);
        if (iIndexOf >= 0) {
            b0 b0Var2 = (b0) this.f12104j.get(iIndexOf);
            this.f12107m.f12021n.removeMessages(15, b0Var2);
            e eVar = this.f12107m;
            eVar.f12021n.sendMessageDelayed(Message.obtain(eVar.f12021n, 15, b0Var2), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
            return false;
        }
        this.f12104j.add(b0Var);
        e eVar2 = this.f12107m;
        eVar2.f12021n.sendMessageDelayed(Message.obtain(eVar2.f12021n, 15, b0Var), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        e eVar3 = this.f12107m;
        eVar3.f12021n.sendMessageDelayed(Message.obtain(eVar3.f12021n, 16, b0Var), 120000L);
        ConnectionResult connectionResult = new ConnectionResult(2, null);
        if (q(connectionResult)) {
            return false;
        }
        this.f12107m.e(connectionResult, this.f12101g);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final boolean r(boolean z10) {
        m1.g.c(this.f12107m.f12021n);
        if (!this.f12096b.isConnected() || !this.f12100f.isEmpty()) {
            return false;
        }
        if (!this.f12098d.e()) {
            this.f12096b.c("Timing out service connection.");
            return true;
        }
        if (!z10) {
            return false;
        }
        m();
        return false;
    }

    @WorkerThread
    public final void E() {
        m1.g.c(this.f12107m.f12021n);
        this.f12105k = null;
    }

    @WorkerThread
    public final void F() {
        m1.g.c(this.f12107m.f12021n);
        if (this.f12096b.isConnected() || this.f12096b.d()) {
            return;
        }
        try {
            e eVar = this.f12107m;
            int iB = eVar.f12014g.b(eVar.f12012e, this.f12096b);
            if (iB == 0) {
                e eVar2 = this.f12107m;
                com.google.android.gms.common.api.a.f fVar = this.f12096b;
                d0 d0Var = new d0(eVar2, fVar, this.f12097c);
                if (fVar.m()) {
                    ((o0) m1.g.k(this.f12102h)).Z(d0Var);
                }
                try {
                    this.f12096b.f(d0Var);
                    return;
                } catch (SecurityException e10) {
                    I(new ConnectionResult(10), e10);
                    return;
                }
            }
            ConnectionResult connectionResult = new ConnectionResult(iB, null);
            Log.w("GoogleApiManager", "The service for " + this.f12096b.getClass().getName() + " is not available: " + connectionResult.toString());
            I(connectionResult, null);
        } catch (IllegalStateException e11) {
            I(new ConnectionResult(10), e11);
        }
    }

    @WorkerThread
    public final void G(u0 u0Var) {
        m1.g.c(this.f12107m.f12021n);
        if (this.f12096b.isConnected()) {
            if (p(u0Var)) {
                m();
                return;
            } else {
                this.f12095a.add(u0Var);
                return;
            }
        }
        this.f12095a.add(u0Var);
        ConnectionResult connectionResult = this.f12105k;
        if (connectionResult == null || !connectionResult.S()) {
            F();
        } else {
            I(this.f12105k, null);
        }
    }

    @WorkerThread
    final void H() {
        this.f12106l++;
    }

    @WorkerThread
    public final void I(@NonNull ConnectionResult connectionResult, @Nullable Exception exc) {
        m1.g.c(this.f12107m.f12021n);
        o0 o0Var = this.f12102h;
        if (o0Var != null) {
            o0Var.a0();
        }
        E();
        this.f12107m.f12014g.c();
        e(connectionResult);
        if ((this.f12096b instanceof o1.e) && connectionResult.J() != 24) {
            this.f12107m.f12009b = true;
            e eVar = this.f12107m;
            eVar.f12021n.sendMessageDelayed(eVar.f12021n.obtainMessage(19), 300000L);
        }
        if (connectionResult.J() == 4) {
            h(e.f12005q);
            return;
        }
        if (this.f12095a.isEmpty()) {
            this.f12105k = connectionResult;
            return;
        }
        if (exc != null) {
            m1.g.c(this.f12107m.f12021n);
            i(null, exc, false);
            return;
        }
        if (!this.f12107m.f12022o) {
            h(e.f(this.f12097c, connectionResult));
            return;
        }
        i(e.f(this.f12097c, connectionResult), null, true);
        if (this.f12095a.isEmpty() || q(connectionResult) || this.f12107m.e(connectionResult, this.f12101g)) {
            return;
        }
        if (connectionResult.J() == 18) {
            this.f12103i = true;
        }
        if (!this.f12103i) {
            h(e.f(this.f12097c, connectionResult));
            return;
        }
        e eVar2 = this.f12107m;
        eVar2.f12021n.sendMessageDelayed(Message.obtain(eVar2.f12021n, 9, this.f12097c), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
    }

    @WorkerThread
    public final void J(@NonNull ConnectionResult connectionResult) {
        m1.g.c(this.f12107m.f12021n);
        com.google.android.gms.common.api.a.f fVar = this.f12096b;
        fVar.c("onSignInFailed for " + fVar.getClass().getName() + " with " + String.valueOf(connectionResult));
        I(connectionResult, null);
    }

    @WorkerThread
    public final void K(v0 v0Var) {
        m1.g.c(this.f12107m.f12021n);
        this.f12099e.add(v0Var);
    }

    @WorkerThread
    public final void L() {
        m1.g.c(this.f12107m.f12021n);
        if (this.f12103i) {
            F();
        }
    }

    @WorkerThread
    public final void M() {
        m1.g.c(this.f12107m.f12021n);
        h(e.f12004p);
        this.f12098d.d();
        for (i iVar : (i[]) this.f12100f.keySet().toArray(new i[0])) {
            G(new t0(iVar, new e2.h()));
        }
        e(new ConnectionResult(4));
        if (this.f12096b.isConnected()) {
            this.f12096b.g(new y(this));
        }
    }

    @WorkerThread
    public final void N() {
        m1.g.c(this.f12107m.f12021n);
        if (this.f12103i) {
            o();
            e eVar = this.f12107m;
            h(eVar.f12013f.g(eVar.f12012e) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.f12096b.c("Timing out connection while resuming.");
        }
    }

    final boolean Q() {
        return this.f12096b.isConnected();
    }

    @Override // k1.d
    public final void a(int i10) {
        if (Looper.myLooper() == this.f12107m.f12021n.getLooper()) {
            l(i10);
        } else {
            this.f12107m.f12021n.post(new w(this, i10));
        }
    }

    public final boolean b() {
        return this.f12096b.m();
    }

    @Override // k1.d
    public final void g(@Nullable Bundle bundle) {
        if (Looper.myLooper() == this.f12107m.f12021n.getLooper()) {
            k();
        } else {
            this.f12107m.f12021n.post(new v(this));
        }
    }

    public final int s() {
        return this.f12101g;
    }

    @WorkerThread
    final int t() {
        return this.f12106l;
    }

    @Nullable
    @WorkerThread
    public final ConnectionResult u() {
        m1.g.c(this.f12107m.f12021n);
        return this.f12105k;
    }

    public final com.google.android.gms.common.api.a.f w() {
        return this.f12096b;
    }

    public final Map y() {
        return this.f12100f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void k() {
        E();
        e(ConnectionResult.f2120e);
        o();
        Iterator it = this.f12100f.values().iterator();
        if (!it.hasNext()) {
            j();
            m();
        } else {
            ((k0) it.next()).getClass();
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void l(int i10) {
        E();
        this.f12103i = true;
        this.f12098d.c(i10, this.f12096b.l());
        b bVar = this.f12097c;
        e eVar = this.f12107m;
        eVar.f12021n.sendMessageDelayed(Message.obtain(eVar.f12021n, 9, bVar), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        b bVar2 = this.f12097c;
        e eVar2 = this.f12107m;
        eVar2.f12021n.sendMessageDelayed(Message.obtain(eVar2.f12021n, 11, bVar2), 120000L);
        this.f12107m.f12014g.c();
        Iterator it = this.f12100f.values().iterator();
        while (it.hasNext()) {
            ((k0) it.next()).f12042a.run();
        }
    }

    @WorkerThread
    private final boolean q(@NonNull ConnectionResult connectionResult) {
        synchronized (e.f12006r) {
            try {
                e eVar = this.f12107m;
                if (eVar.f12018k != null && eVar.f12019l.contains(this.f12097c)) {
                    this.f12107m.f12018k.s(connectionResult, this.f12101g);
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
