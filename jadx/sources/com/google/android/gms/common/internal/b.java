package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import m1.j0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class b<T extends IInterface> {
    private boolean A;

    @Nullable
    private volatile zzk B;

    @NonNull
    @VisibleForTesting
    protected AtomicInteger C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f2303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f2304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f2306e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private volatile String f2307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @VisibleForTesting
    b0 f2308g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Context f2309h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Looper f2310i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.google.android.gms.common.internal.d f2311j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.google.android.gms.common.b f2312k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final Handler f2313l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Object f2314m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Object f2315n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private m1.e f2316o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    @VisibleForTesting
    protected c f2317p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private IInterface f2318q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final ArrayList f2319r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private s f2320s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f2321t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private final a f2322u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private final InterfaceC0045b f2323v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f2324w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    private final String f2325x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    private volatile String f2326y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    private ConnectionResult f2327z;
    private static final Feature[] E = new Feature[0];

    @NonNull
    public static final String[] D = {"service_esmobile", "service_googleme"};

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {
        void a(int i10);

        void g(@Nullable Bundle bundle);
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface InterfaceC0045b {
        void f(@NonNull ConnectionResult connectionResult);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface c {
        void a(@NonNull ConnectionResult connectionResult);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    protected class d implements c {
        public d() {
        }

        @Override // com.google.android.gms.common.internal.b.c
        public final void a(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.V()) {
                b bVar = b.this;
                bVar.b(null, bVar.A());
            } else if (b.this.f2323v != null) {
                b.this.f2323v.f(connectionResult);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface e {
        void a();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    protected b(@NonNull Context context, @NonNull Looper looper, int i10, @Nullable a aVar, @Nullable InterfaceC0045b interfaceC0045b, @Nullable String str) {
        com.google.android.gms.common.internal.d dVarA = com.google.android.gms.common.internal.d.a(context);
        com.google.android.gms.common.b bVarF = com.google.android.gms.common.b.f();
        m1.g.k(aVar);
        m1.g.k(interfaceC0045b);
        this(context, looper, dVarA, bVarF, i10, aVar, interfaceC0045b, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(int i10, @Nullable IInterface iInterface) {
        b0 b0Var;
        m1.g.a((i10 == 4) == (iInterface != null));
        synchronized (this.f2314m) {
            try {
                this.f2321t = i10;
                this.f2318q = iInterface;
                Bundle bundle = null;
                if (i10 == 1) {
                    s sVar = this.f2320s;
                    if (sVar != null) {
                        com.google.android.gms.common.internal.d dVar = this.f2311j;
                        String strB = this.f2308g.b();
                        m1.g.k(strB);
                        dVar.e(strB, this.f2308g.a(), 4225, sVar, V(), this.f2308g.c());
                        this.f2320s = null;
                    }
                } else if (i10 == 2 || i10 == 3) {
                    s sVar2 = this.f2320s;
                    if (sVar2 != null && (b0Var = this.f2308g) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + b0Var.b() + " on " + b0Var.a());
                        com.google.android.gms.common.internal.d dVar2 = this.f2311j;
                        String strB2 = this.f2308g.b();
                        m1.g.k(strB2);
                        dVar2.e(strB2, this.f2308g.a(), 4225, sVar2, V(), this.f2308g.c());
                        this.C.incrementAndGet();
                    }
                    s sVar3 = new s(this, this.C.get());
                    this.f2320s = sVar3;
                    b0 b0Var2 = (this.f2321t != 3 || z() == null) ? new b0(E(), D(), false, 4225, G()) : new b0(w().getPackageName(), z(), true, 4225, false);
                    this.f2308g = b0Var2;
                    if (b0Var2.c() && j() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f2308g.b())));
                    }
                    com.google.android.gms.common.internal.d dVar3 = this.f2311j;
                    String strB3 = this.f2308g.b();
                    m1.g.k(strB3);
                    ConnectionResult connectionResultC = dVar3.c(new j0(strB3, this.f2308g.a(), 4225, this.f2308g.c()), sVar3, V(), u());
                    if (!connectionResultC.V()) {
                        Log.w("GmsClient", "unable to connect to service: " + this.f2308g.b() + " on " + this.f2308g.a());
                        int iJ = connectionResultC.J() == -1 ? 16 : connectionResultC.J();
                        if (connectionResultC.P() != null) {
                            bundle = new Bundle();
                            bundle.putParcelable("pendingIntent", connectionResultC.P());
                        }
                        c0(iJ, bundle, this.C.get());
                    }
                } else if (i10 == 4) {
                    m1.g.k(iInterface);
                    I(iInterface);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    protected abstract String C();

    @NonNull
    protected abstract String D();

    public boolean M() {
        return false;
    }

    public boolean Q() {
        return false;
    }

    public boolean i() {
        return true;
    }

    public boolean m() {
        return false;
    }

    @Nullable
    protected abstract T q(@NonNull IBinder iBinder);

    protected boolean r() {
        return false;
    }

    @Nullable
    public Account s() {
        return null;
    }

    @Nullable
    protected Executor u() {
        return null;
    }

    @Nullable
    public Bundle v() {
        return null;
    }

    @Nullable
    protected String z() {
        return null;
    }

    static /* bridge */ /* synthetic */ void a0(b bVar, zzk zzkVar) {
        bVar.B = zzkVar;
        if (bVar.Q()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzkVar.f2381d;
            m1.h.b().c(connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.i0());
        }
    }

    static /* bridge */ /* synthetic */ void b0(b bVar, int i10) {
        int i11;
        int i12;
        synchronized (bVar.f2314m) {
            i11 = bVar.f2321t;
        }
        if (i11 == 3) {
            bVar.A = true;
            i12 = 5;
        } else {
            i12 = 4;
        }
        Handler handler = bVar.f2313l;
        handler.sendMessage(handler.obtainMessage(i12, bVar.C.get(), 16));
    }

    static /* bridge */ /* synthetic */ boolean e0(b bVar, int i10, int i11, IInterface iInterface) {
        synchronized (bVar.f2314m) {
            try {
                if (bVar.f2321t != i10) {
                    return false;
                }
                bVar.g0(i11, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean f0(b bVar) {
        if (bVar.A || TextUtils.isEmpty(bVar.C()) || TextUtils.isEmpty(bVar.z())) {
            return false;
        }
        try {
            Class.forName(bVar.C());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @NonNull
    protected Set<Scope> A() {
        return Collections.EMPTY_SET;
    }

    @NonNull
    public final T B() {
        T t10;
        synchronized (this.f2314m) {
            try {
                if (this.f2321t == 5) {
                    throw new DeadObjectException();
                }
                p();
                IInterface iInterface = this.f2318q;
                m1.g.l(iInterface, "Client is connected but service is null");
                t10 = (T) iInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        return t10;
    }

    @NonNull
    protected String E() {
        return "com.google.android.gms";
    }

    @Nullable
    public ConnectionTelemetryConfiguration F() {
        zzk zzkVar = this.B;
        if (zzkVar == null) {
            return null;
        }
        return zzkVar.f2381d;
    }

    public boolean H() {
        return this.B != null;
    }

    @CallSuper
    protected void K(int i10) {
        this.f2302a = i10;
        this.f2303b = System.currentTimeMillis();
    }

    protected void L(int i10, @Nullable IBinder iBinder, @Nullable Bundle bundle, int i11) {
        this.f2313l.sendMessage(this.f2313l.obtainMessage(1, i11, -1, new t(this, i10, iBinder, bundle)));
    }

    public void N(@NonNull String str) {
        this.f2326y = str;
    }

    public void O(int i10) {
        this.f2313l.sendMessage(this.f2313l.obtainMessage(6, this.C.get(), i10));
    }

    @VisibleForTesting
    protected void P(@NonNull c cVar, int i10, @Nullable PendingIntent pendingIntent) {
        m1.g.l(cVar, "Connection progress callbacks cannot be null.");
        this.f2317p = cVar;
        this.f2313l.sendMessage(this.f2313l.obtainMessage(3, this.C.get(), i10, pendingIntent));
    }

    @NonNull
    protected final String V() {
        String str = this.f2325x;
        return str == null ? this.f2309h.getClass().getName() : str;
    }

    @WorkerThread
    public void b(@Nullable com.google.android.gms.common.internal.e eVar, @NonNull Set<Scope> set) {
        Bundle bundleY = y();
        String str = Build.VERSION.SDK_INT < 31 ? this.f2326y : this.f2326y;
        int i10 = this.f2324w;
        int i11 = com.google.android.gms.common.b.f2201a;
        Scope[] scopeArr = GetServiceRequest.f2262o;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.f2263p;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i10, i11, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.f2267d = this.f2309h.getPackageName();
        getServiceRequest.f2270g = bundleY;
        if (set != null) {
            getServiceRequest.f2269f = (Scope[]) set.toArray(new Scope[0]);
        }
        if (m()) {
            Account accountS = s();
            if (accountS == null) {
                accountS = new Account("<<default account>>", "com.google");
            }
            getServiceRequest.f2271h = accountS;
            if (eVar != null) {
                getServiceRequest.f2268e = eVar.asBinder();
            }
        } else if (M()) {
            getServiceRequest.f2271h = s();
        }
        getServiceRequest.f2272i = E;
        getServiceRequest.f2273j = t();
        if (Q()) {
            getServiceRequest.f2276m = true;
        }
        try {
            synchronized (this.f2315n) {
                try {
                    m1.e eVar2 = this.f2316o;
                    if (eVar2 != null) {
                        eVar2.L(new r(this, this.C.get()), getServiceRequest);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (DeadObjectException e10) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e10);
            O(3);
        } catch (RemoteException e11) {
            e = e11;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            L(8, null, null, this.C.get());
        } catch (SecurityException e12) {
            throw e12;
        } catch (RuntimeException e13) {
            e = e13;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            L(8, null, null, this.C.get());
        }
    }

    public void c(@NonNull String str) {
        this.f2307f = str;
        disconnect();
    }

    protected final void c0(int i10, @Nullable Bundle bundle, int i11) {
        this.f2313l.sendMessage(this.f2313l.obtainMessage(7, i11, -1, new u(this, i10, bundle)));
    }

    public boolean d() {
        boolean z10;
        synchronized (this.f2314m) {
            int i10 = this.f2321t;
            z10 = true;
            if (i10 != 2 && i10 != 3) {
                z10 = false;
            }
        }
        return z10;
    }

    public void disconnect() {
        this.C.incrementAndGet();
        synchronized (this.f2319r) {
            try {
                int size = this.f2319r.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((q) this.f2319r.get(i10)).d();
                }
                this.f2319r.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f2315n) {
            this.f2316o = null;
        }
        g0(1, null);
    }

    public void f(@NonNull c cVar) {
        m1.g.l(cVar, "Connection progress callbacks cannot be null.");
        this.f2317p = cVar;
        g0(2, null);
    }

    public boolean isConnected() {
        boolean z10;
        synchronized (this.f2314m) {
            z10 = this.f2321t == 4;
        }
        return z10;
    }

    public int j() {
        return com.google.android.gms.common.b.f2201a;
    }

    @Nullable
    public final Feature[] k() {
        zzk zzkVar = this.B;
        if (zzkVar == null) {
            return null;
        }
        return zzkVar.f2379b;
    }

    @Nullable
    public String l() {
        return this.f2307f;
    }

    public void o() {
        int iH = this.f2312k.h(this.f2309h, j());
        if (iH == 0) {
            f(new d());
        } else {
            g0(1, null);
            P(new d(), iH, null);
        }
    }

    @NonNull
    public Feature[] t() {
        return E;
    }

    @NonNull
    public final Context w() {
        return this.f2309h;
    }

    public int x() {
        return this.f2324w;
    }

    @NonNull
    protected Bundle y() {
        return new Bundle();
    }

    protected boolean G() {
        if (j() >= 211700000) {
            return true;
        }
        return false;
    }

    @CallSuper
    protected void I(@NonNull T t10) {
        this.f2304c = System.currentTimeMillis();
    }

    @CallSuper
    protected void J(@NonNull ConnectionResult connectionResult) {
        this.f2305d = connectionResult.J();
        this.f2306e = System.currentTimeMillis();
    }

    @NonNull
    public String e() {
        b0 b0Var;
        if (isConnected() && (b0Var = this.f2308g) != null) {
            return b0Var.a();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    public void g(@NonNull e eVar) {
        eVar.a();
    }

    protected final void p() {
        if (isConnected()) {
        } else {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @VisibleForTesting
    protected b(@NonNull Context context, @NonNull Looper looper, @NonNull com.google.android.gms.common.internal.d dVar, @NonNull com.google.android.gms.common.b bVar, int i10, @Nullable a aVar, @Nullable InterfaceC0045b interfaceC0045b, @Nullable String str) {
        this.f2307f = null;
        this.f2314m = new Object();
        this.f2315n = new Object();
        this.f2319r = new ArrayList();
        this.f2321t = 1;
        this.f2327z = null;
        this.A = false;
        this.B = null;
        this.C = new AtomicInteger(0);
        m1.g.l(context, "Context must not be null");
        this.f2309h = context;
        m1.g.l(looper, "Looper must not be null");
        this.f2310i = looper;
        m1.g.l(dVar, "Supervisor must not be null");
        this.f2311j = dVar;
        m1.g.l(bVar, "API availability must not be null");
        this.f2312k = bVar;
        this.f2313l = new p(this, looper);
        this.f2324w = i10;
        this.f2322u = aVar;
        this.f2323v = interfaceC0045b;
        this.f2325x = str;
    }
}
