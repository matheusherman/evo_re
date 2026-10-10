package k1;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e implements Handler.Callback {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public static final Status f12004p = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Status f12005q = new Status(4, "The user must be signed in to make this API call.");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Object f12006r = new Object();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private static e f12007s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private TelemetryData f12010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private m1.k f12011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f12012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.android.gms.common.a f12013f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m1.w f12014g;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Handler f12021n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private volatile boolean f12022o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f12008a = 10000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12009b = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicInteger f12015h = new AtomicInteger(1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicInteger f12016i = new AtomicInteger(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f12017j = new ConcurrentHashMap(5, 0.75f, 1);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private q f12018k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Set f12019l = new ArraySet();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Set f12020m = new ArraySet();

    /* JADX INFO: Access modifiers changed from: private */
    public static Status f(b bVar, ConnectionResult connectionResult) {
        return new Status(connectionResult, "API: " + bVar.b() + " is not available on this device. Connection failed with: " + String.valueOf(connectionResult));
    }

    @ResultIgnorabilityUnspecified
    @WorkerThread
    private final z g(com.google.android.gms.common.api.f fVar) {
        Map map = this.f12017j;
        b bVarE = fVar.e();
        z zVar = (z) map.get(bVarE);
        if (zVar == null) {
            zVar = new z(this, fVar);
            this.f12017j.put(bVarE, zVar);
        }
        if (zVar.b()) {
            this.f12020m.add(bVarE);
        }
        zVar.F();
        return zVar;
    }

    @WorkerThread
    private final m1.k h() {
        if (this.f12011d == null) {
            this.f12011d = m1.j.a(this.f12012e);
        }
        return this.f12011d;
    }

    @WorkerThread
    private final void i() {
        TelemetryData telemetryData = this.f12010c;
        if (telemetryData != null) {
            if (telemetryData.J() > 0 || d()) {
                h().a(telemetryData);
            }
            this.f12010c = null;
        }
    }

    private final void j(e2.h hVar, int i10, com.google.android.gms.common.api.f fVar) {
        h0 h0VarB;
        if (i10 == 0 || (h0VarB = h0.b(this, i10, fVar.e())) == null) {
            return;
        }
        e2.g gVarA = hVar.a();
        final Handler handler = this.f12021n;
        handler.getClass();
        gVarA.c(new Executor() { // from class: k1.t
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, h0VarB);
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    public static e t(@NonNull Context context) {
        e eVar;
        synchronized (f12006r) {
            try {
                if (f12007s == null) {
                    f12007s = new e(StubApp.getOrigApplicationContext(context.getApplicationContext()), com.google.android.gms.common.internal.d.b().getLooper(), com.google.android.gms.common.a.m());
                }
                eVar = f12007s;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    final void A(MethodInvocation methodInvocation, int i10, long j10, int i11) {
        this.f12021n.sendMessage(this.f12021n.obtainMessage(18, new i0(methodInvocation, i10, j10, i11)));
    }

    public final void C() {
        Handler handler = this.f12021n;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void D(@NonNull com.google.android.gms.common.api.f fVar) {
        Handler handler = this.f12021n;
        handler.sendMessage(handler.obtainMessage(7, fVar));
    }

    public final void a(@NonNull q qVar) {
        synchronized (f12006r) {
            try {
                if (this.f12018k != qVar) {
                    this.f12018k = qVar;
                    this.f12019l.clear();
                }
                this.f12019l.addAll(qVar.t());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final void b(@NonNull q qVar) {
        synchronized (f12006r) {
            try {
                if (this.f12018k == qVar) {
                    this.f12018k = null;
                    this.f12019l.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @WorkerThread
    final boolean d() {
        if (this.f12009b) {
            return false;
        }
        RootTelemetryConfiguration rootTelemetryConfigurationA = m1.h.b().a();
        if (rootTelemetryConfigurationA != null && !rootTelemetryConfigurationA.P()) {
            return false;
        }
        int iA = this.f12014g.a(this.f12012e, 203400000);
        return iA == -1 || iA == 0;
    }

    @ResultIgnorabilityUnspecified
    final boolean e(ConnectionResult connectionResult, int i10) {
        return this.f12013f.w(this.f12012e, connectionResult, i10);
    }

    /* JADX WARN: Code duplicated, block: B:63:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:65:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:66:0x0228  */
    /* JADX WARN: Code duplicated, block: B:67:0x0235  */
    /* JADX WARN: Instruction removed from duplicated block: B:65:0x01f7, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:67:0x0235, please report this as an issue */
    @Override // android.os.Handler.Callback
    @WorkerThread
    public final boolean handleMessage(@NonNull Message message) {
        int i10 = message.what;
        z zVar = null;
        switch (i10) {
            case 1:
                this.f12008a = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.f12021n.removeMessages(12);
                for (b bVar : this.f12017j.keySet()) {
                    Handler handler = this.f12021n;
                    handler.sendMessageDelayed(handler.obtainMessage(12, bVar), this.f12008a);
                }
                return true;
            case 2:
                v0 v0Var = (v0) message.obj;
                for (b bVar2 : v0Var.a()) {
                    z zVar2 = (z) this.f12017j.get(bVar2);
                    if (zVar2 == null) {
                        v0Var.b(bVar2, new ConnectionResult(13), null);
                        return true;
                    }
                    if (zVar2.Q()) {
                        v0Var.b(bVar2, ConnectionResult.f2120e, zVar2.w().e());
                    } else {
                        ConnectionResult connectionResultU = zVar2.u();
                        if (connectionResultU != null) {
                            v0Var.b(bVar2, connectionResultU, null);
                        } else {
                            zVar2.K(v0Var);
                            zVar2.F();
                        }
                    }
                }
                return true;
            case 3:
                for (z zVar3 : this.f12017j.values()) {
                    zVar3.E();
                    zVar3.F();
                }
                return true;
            case 4:
            case 8:
            case 13:
                j0 j0Var = (j0) message.obj;
                z zVarG = (z) this.f12017j.get(j0Var.f12041c.e());
                if (zVarG == null) {
                    zVarG = g(j0Var.f12041c);
                }
                if (!zVarG.b() || this.f12016i.get() == j0Var.f12040b) {
                    zVarG.G(j0Var.f12039a);
                } else {
                    j0Var.f12039a.a(f12004p);
                    zVarG.M();
                }
                return true;
            case 5:
                int i11 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                for (z zVar4 : this.f12017j.values()) {
                    if (zVar4.s() == i11) {
                        zVar = zVar4;
                        if (zVar != null) {
                            Log.wtf("GoogleApiManager", "Could not find API instance " + i11 + " while trying to fail enqueued calls.", new Exception());
                        } else if (connectionResult.J() == 13) {
                            zVar.h(new Status(17, "Error resolution was canceled by the user, original error message: " + this.f12013f.e(connectionResult.J()) + ": " + connectionResult.M()));
                        } else {
                            zVar.h(f(zVar.f12097c, connectionResult));
                        }
                        return true;
                    }
                }
                if (zVar != null) {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i11 + " while trying to fail enqueued calls.", new Exception());
                } else if (connectionResult.J() == 13) {
                    zVar.h(new Status(17, "Error resolution was canceled by the user, original error message: " + this.f12013f.e(connectionResult.J()) + ": " + connectionResult.M()));
                } else {
                    zVar.h(f(zVar.f12097c, connectionResult));
                }
                return true;
            case 6:
                if (StubApp.getOrigApplicationContext(this.f12012e.getApplicationContext()) instanceof Application) {
                    c.c((Application) StubApp.getOrigApplicationContext(this.f12012e.getApplicationContext()));
                    c.b().a(new u(this));
                    if (!c.b().e(true)) {
                        this.f12008a = 300000L;
                    }
                }
                return true;
            case 7:
                g((com.google.android.gms.common.api.f) message.obj);
                return true;
            case 9:
                if (this.f12017j.containsKey(message.obj)) {
                    ((z) this.f12017j.get(message.obj)).L();
                }
                return true;
            case 10:
                Iterator it = this.f12020m.iterator();
                while (it.hasNext()) {
                    z zVar5 = (z) this.f12017j.remove((b) it.next());
                    if (zVar5 != null) {
                        zVar5.M();
                    }
                }
                this.f12020m.clear();
                return true;
            case 11:
                if (this.f12017j.containsKey(message.obj)) {
                    ((z) this.f12017j.get(message.obj)).N();
                }
                return true;
            case 12:
                if (this.f12017j.containsKey(message.obj)) {
                    ((z) this.f12017j.get(message.obj)).c();
                }
                return true;
            case 14:
                r rVar = (r) message.obj;
                b bVarA = rVar.a();
                if (this.f12017j.containsKey(bVarA)) {
                    rVar.b().c(Boolean.valueOf(((z) this.f12017j.get(bVarA)).r(false)));
                } else {
                    rVar.b().c(Boolean.FALSE);
                }
                return true;
            case 15:
                b0 b0Var = (b0) message.obj;
                if (this.f12017j.containsKey(b0Var.f11981a)) {
                    z.C((z) this.f12017j.get(b0Var.f11981a), b0Var);
                }
                return true;
            case 16:
                b0 b0Var2 = (b0) message.obj;
                if (this.f12017j.containsKey(b0Var2.f11981a)) {
                    z.D((z) this.f12017j.get(b0Var2.f11981a), b0Var2);
                }
                return true;
            case 17:
                i();
                return true;
            case 18:
                i0 i0Var = (i0) message.obj;
                if (i0Var.f12037c == 0) {
                    h().a(new TelemetryData(i0Var.f12036b, Arrays.asList(i0Var.f12035a)));
                } else {
                    TelemetryData telemetryData = this.f12010c;
                    if (telemetryData != null) {
                        List listM = telemetryData.M();
                        if (telemetryData.J() != i0Var.f12036b || (listM != null && listM.size() >= i0Var.f12038d)) {
                            this.f12021n.removeMessages(17);
                            i();
                        } else {
                            this.f12010c.P(i0Var.f12035a);
                        }
                    }
                    if (this.f12010c == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(i0Var.f12035a);
                        this.f12010c = new TelemetryData(i0Var.f12036b, arrayList);
                        Handler handler2 = this.f12021n;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), i0Var.f12037c);
                    }
                }
                return true;
            case 19:
                this.f12009b = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i10);
                return false;
        }
    }

    public final int k() {
        return this.f12015h.getAndIncrement();
    }

    @Nullable
    final z s(b bVar) {
        return (z) this.f12017j.get(bVar);
    }

    private e(Context context, Looper looper, com.google.android.gms.common.a aVar) {
        this.f12022o = true;
        this.f12012e = context;
        x1.l lVar = new x1.l(looper, this);
        this.f12021n = lVar;
        this.f12013f = aVar;
        this.f12014g = new m1.w(aVar);
        if (com.google.android.gms.common.util.h.a(context)) {
            this.f12022o = false;
        }
        lVar.sendMessage(lVar.obtainMessage(6));
    }

    public final void B(@NonNull ConnectionResult connectionResult, int i10) {
        if (!e(connectionResult, i10)) {
            Handler handler = this.f12021n;
            handler.sendMessage(handler.obtainMessage(5, i10, 0, connectionResult));
        }
    }

    public final void z(@NonNull com.google.android.gms.common.api.f fVar, int i10, @NonNull n nVar, @NonNull e2.h hVar, @NonNull m mVar) {
        j(hVar, nVar.d(), fVar);
        this.f12021n.sendMessage(this.f12021n.obtainMessage(4, new j0(new s0(i10, nVar, hVar, mVar), this.f12016i.get(), fVar)));
    }
}
