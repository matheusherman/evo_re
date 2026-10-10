package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import com.google.android.gms.internal.measurement.ef;
import com.google.android.gms.internal.measurement.zzdz;
import com.stub.StubApp;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class s6 implements t7 {
    private static volatile s6 H;
    private long A;
    private volatile Boolean B;
    private volatile boolean C;
    private int D;
    private int E;

    @VisibleForTesting
    final long G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f4006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e f4007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i f4008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a6 f4009h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final p5 f4010i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final p6 f4011j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ib f4012k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final wc f4013l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final k5 f4014m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.gms.common.util.d f4015n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final s9 f4016o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final z7 f4017p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final w f4018q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final l9 f4019r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f4020s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private j5 f4021t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private x9 f4022u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private a0 f4023v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private h5 f4024w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private o9 f4025x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Boolean f4027z;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f4026y = false;
    private AtomicInteger F = new AtomicInteger(0);

    public static s6 d(Context context, zzdz zzdzVar, Long l10) {
        Bundle bundle;
        if (zzdzVar != null && (zzdzVar.f3342e == null || zzdzVar.f3343f == null)) {
            zzdzVar = new zzdz(zzdzVar.f3338a, zzdzVar.f3339b, zzdzVar.f3340c, zzdzVar.f3341d, null, null, zzdzVar.f3344g, null);
        }
        m1.g.k(context);
        m1.g.k(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        if (H == null) {
            synchronized (s6.class) {
                try {
                    if (H == null) {
                        H = new s6(new y7(context, zzdzVar, l10));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (zzdzVar != null && (bundle = zzdzVar.f3344g) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            m1.g.k(H);
            H.n(zzdzVar.f3344g.getBoolean("dataCollectionDefaultEnabled"));
        }
        m1.g.k(H);
        return H;
    }

    private static void g(v2 v2Var) {
        if (v2Var == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void h(m5 m5Var) {
        if (m5Var == null) {
            throw new IllegalStateException("Component not created");
        }
        if (m5Var.x()) {
            return;
        }
        throw new IllegalStateException("Component not initialized: " + String.valueOf(m5Var.getClass()));
    }

    public static /* synthetic */ void j(s6 s6Var, String str, int i10, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> listQueryIntentActivities;
        if ((i10 != 200 && i10 != 204 && i10 != 304) || th != null) {
            s6Var.l().M().c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i10), th);
            return;
        }
        s6Var.H().f3387v.a(true);
        if (bArr == null || bArr.length == 0) {
            s6Var.l().G().a("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String strOptString = jSONObject.optString("deeplink", "");
            if (TextUtils.isEmpty(strOptString)) {
                s6Var.l().G().a("Deferred Deep Link is empty.");
                return;
            }
            String strOptString2 = jSONObject.optString("gclid", "");
            String strOptString3 = jSONObject.optString("gbraid", "");
            String strOptString4 = jSONObject.optString("gad_source", "");
            double dOptDouble = jSONObject.optDouble("timestamp", 0.0d);
            Bundle bundle = new Bundle();
            wc wcVarP = s6Var.P();
            if (TextUtils.isEmpty(strOptString) || (listQueryIntentActivities = wcVarP.b().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(strOptString)), 0)) == null || listQueryIntentActivities.isEmpty()) {
                s6Var.l().M().d("Deferred Deep Link validation failed. gclid, gbraid, deep link", strOptString2, strOptString3, strOptString);
                return;
            }
            if (!TextUtils.isEmpty(strOptString3)) {
                bundle.putString("gbraid", strOptString3);
            }
            if (!TextUtils.isEmpty(strOptString4)) {
                bundle.putString("gad_source", strOptString4);
            }
            bundle.putString("gclid", strOptString2);
            bundle.putString("_cis", "ddp");
            s6Var.f4017p.h1("auto", "_cmp", bundle);
            s6Var.P().b0(strOptString, dOptDouble);
        } catch (JSONException e10) {
            s6Var.l().H().b("Failed to parse the Deferred Deep Link response. exception", e10);
        }
    }

    private static void k(r7 r7Var) {
        if (r7Var == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void m(u7 u7Var) {
        if (u7Var == null) {
            throw new IllegalStateException("Component not created");
        }
        if (u7Var.t()) {
            return;
        }
        throw new IllegalStateException("Component not initialized: " + String.valueOf(u7Var.getClass()));
    }

    public final w A() {
        g(this.f4018q);
        return this.f4018q;
    }

    public final i B() {
        return this.f4008g;
    }

    public final a0 C() {
        m(this.f4023v);
        return this.f4023v;
    }

    public final h5 D() {
        h(this.f4024w);
        return this.f4024w;
    }

    public final j5 E() {
        h(this.f4021t);
        return this.f4021t;
    }

    public final k5 F() {
        return this.f4014m;
    }

    public final p5 G() {
        p5 p5Var = this.f4010i;
        if (p5Var == null || !p5Var.t()) {
            return null;
        }
        return this.f4010i;
    }

    public final a6 H() {
        k(this.f4009h);
        return this.f4009h;
    }

    final p6 I() {
        return this.f4011j;
    }

    public final z7 J() {
        h(this.f4017p);
        return this.f4017p;
    }

    public final l9 K() {
        m(this.f4019r);
        return this.f4019r;
    }

    public final o9 L() {
        g(this.f4025x);
        return this.f4025x;
    }

    public final s9 M() {
        h(this.f4016o);
        return this.f4016o;
    }

    public final x9 N() {
        h(this.f4022u);
        return this.f4022u;
    }

    public final ib O() {
        h(this.f4012k);
        return this.f4012k;
    }

    public final wc P() {
        k(this.f4013l);
        return this.f4013l;
    }

    public final String Q() {
        return this.f4003b;
    }

    public final String R() {
        return this.f4004c;
    }

    public final String S() {
        return this.f4005d;
    }

    public final String T() {
        return this.f4020s;
    }

    @Override // com.google.android.gms.measurement.internal.t7
    public final p6 a() {
        m(this.f4011j);
        return this.f4011j;
    }

    @Override // com.google.android.gms.measurement.internal.t7
    public final Context b() {
        return this.f4002a;
    }

    @Override // com.google.android.gms.measurement.internal.t7
    public final com.google.android.gms.common.util.d c() {
        return this.f4015n;
    }

    @Override // com.google.android.gms.measurement.internal.t7
    public final e e() {
        return this.f4007f;
    }

    @Override // com.google.android.gms.measurement.internal.t7
    public final p5 l() {
        m(this.f4010i);
        return this.f4010i;
    }

    final void o() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    final void p() {
        this.F.incrementAndGet();
    }

    final void q() {
        this.D++;
    }

    @WorkerThread
    public final boolean r() {
        return this.B != null && this.B.booleanValue();
    }

    public final boolean u() {
        return TextUtils.isEmpty(this.f4003b);
    }

    @WorkerThread
    protected final boolean v() {
        if (!this.f4026y) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        a().n();
        Boolean bool = this.f4027z;
        if (bool == null || this.A == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.f4015n.b() - this.A) > 1000)) {
            this.A = this.f4015n.b();
            boolean z10 = true;
            Boolean boolValueOf = Boolean.valueOf(P().H0("android.permission.INTERNET") && P().H0("android.permission.ACCESS_NETWORK_STATE") && (t1.e.a(this.f4002a).e() || this.f4008g.a0() || (wc.f0(this.f4002a) && wc.g0(this.f4002a, false))));
            this.f4027z = boolValueOf;
            if (boolValueOf.booleanValue()) {
                if (!P().l0(D().J(), D().G()) && TextUtils.isEmpty(D().G())) {
                    z10 = false;
                }
                this.f4027z = Boolean.valueOf(z10);
            }
        }
        return this.f4027z.booleanValue();
    }

    public final boolean w() {
        return this.f4006e;
    }

    private s6(y7 y7Var) {
        long jA;
        boolean z10 = false;
        m1.g.k(y7Var);
        e eVar = new e(y7Var.f4222a);
        this.f4007f = eVar;
        d5.f3478a = eVar;
        Context context = y7Var.f4222a;
        this.f4002a = context;
        this.f4003b = y7Var.f4223b;
        this.f4004c = y7Var.f4224c;
        this.f4005d = y7Var.f4225d;
        this.f4006e = y7Var.f4229h;
        this.B = y7Var.f4226e;
        this.f4020s = y7Var.f4231j;
        this.C = true;
        com.google.android.gms.internal.measurement.s7.l(context);
        com.google.android.gms.common.util.d dVarD = com.google.android.gms.common.util.g.d();
        this.f4015n = dVarD;
        Long l10 = y7Var.f4230i;
        if (l10 != null) {
            jA = l10.longValue();
        } else {
            jA = dVarD.a();
        }
        this.G = jA;
        this.f4008g = new i(this);
        a6 a6Var = new a6(this);
        a6Var.r();
        this.f4009h = a6Var;
        p5 p5Var = new p5(this);
        p5Var.r();
        this.f4010i = p5Var;
        wc wcVar = new wc(this);
        wcVar.r();
        this.f4013l = wcVar;
        this.f4014m = new k5(new a8(y7Var, this));
        this.f4018q = new w(this);
        s9 s9Var = new s9(this);
        s9Var.A();
        this.f4016o = s9Var;
        z7 z7Var = new z7(this);
        z7Var.A();
        this.f4017p = z7Var;
        ib ibVar = new ib(this);
        ibVar.A();
        this.f4012k = ibVar;
        l9 l9Var = new l9(this);
        l9Var.r();
        this.f4019r = l9Var;
        p6 p6Var = new p6(this);
        p6Var.r();
        this.f4011j = p6Var;
        zzdz zzdzVar = y7Var.f4228g;
        if (zzdzVar != null && zzdzVar.f3339b != 0) {
            z10 = true;
        }
        boolean z11 = !z10;
        if (StubApp.getOrigApplicationContext(context.getApplicationContext()) instanceof Application) {
            J().c1(z11);
        } else {
            l().M().a("Application context is not an Application");
        }
        p6Var.E(new u6(this, y7Var));
    }

    static /* synthetic */ void i(s6 s6Var, y7 y7Var) {
        s6Var.a().n();
        a0 a0Var = new a0(s6Var);
        a0Var.r();
        s6Var.f4023v = a0Var;
        h5 h5Var = new h5(s6Var, y7Var.f4227f);
        h5Var.A();
        s6Var.f4024w = h5Var;
        j5 j5Var = new j5(s6Var);
        j5Var.A();
        s6Var.f4021t = j5Var;
        x9 x9Var = new x9(s6Var);
        x9Var.A();
        s6Var.f4022u = x9Var;
        s6Var.f4013l.s();
        s6Var.f4009h.s();
        s6Var.f4024w.B();
        o9 o9Var = new o9(s6Var);
        o9Var.A();
        s6Var.f4025x = o9Var;
        o9Var.B();
        s6Var.l().K().b("App measurement initialized, version", 118003L);
        s6Var.l().K().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String strH = h5Var.H();
        if (TextUtils.isEmpty(s6Var.f4003b)) {
            if (s6Var.P().G0(strH, s6Var.f4008g.W())) {
                s6Var.l().K().a("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                s6Var.l().K().a("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app " + strH);
            }
        }
        s6Var.l().G().a("Debug-level message logging enabled");
        if (s6Var.D != s6Var.F.get()) {
            s6Var.l().H().c("Not all components initialized", Integer.valueOf(s6Var.D), Integer.valueOf(s6Var.F.get()));
        }
        s6Var.f4026y = true;
    }

    @WorkerThread
    protected final void f(zzdz zzdzVar) {
        boolean z10;
        v7 v7VarG;
        Boolean boolE;
        boolean zBooleanValue;
        a().n();
        i iVar = this.f4008g;
        f5<Boolean> f5Var = g0.R0;
        if (iVar.u(f5Var) && L().E() == com.google.android.gms.internal.measurement.x5.b.CLIENT_UPLOAD_ELIGIBLE) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((ef.a() && this.f4008g.u(g0.W0) && P().W0()) || z10) {
            wc wcVarP = P();
            wcVarP.n();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            if (wcVarP.d().u(f5Var)) {
                intentFilter.addAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
            }
            ContextCompat.registerReceiver(wcVarP.b(), new zzs(wcVarP.f3965a), intentFilter, 2);
            wcVarP.l().G().a("Registered app receiver");
        }
        if (z10) {
            L().D(g0.C.a(null).longValue());
        }
        v7 v7VarO = H().O();
        int iB = v7VarO.b();
        b2.g0 g0VarE = this.f4008g.E("google_analytics_default_allow_ad_storage", false);
        b2.g0 g0VarE2 = this.f4008g.E("google_analytics_default_allow_analytics_storage", false);
        b2.g0 g0Var = b2.g0.UNINITIALIZED;
        if ((g0VarE != g0Var || g0VarE2 != g0Var) && H().y(-10)) {
            v7VarG = v7.g(g0VarE, g0VarE2, -10);
        } else {
            if (!TextUtils.isEmpty(D().J()) && (iB == 0 || iB == 30 || iB == 10 || iB == 30 || iB == 30 || iB == 40)) {
                J().V(new v7(null, null, -10), false);
            } else if (TextUtils.isEmpty(D().J()) && zzdzVar != null && zzdzVar.f3344g != null && H().y(30)) {
                v7VarG = v7.f(zzdzVar.f3344g, 30);
                if (!v7VarG.y()) {
                }
            }
            v7VarG = null;
        }
        if (v7VarG != null) {
            J().V(v7VarG, true);
            v7VarO = v7VarG;
        }
        J().U(v7VarO);
        int iA = H().N().a();
        b2.g0 g0VarE3 = this.f4008g.E("google_analytics_default_allow_ad_personalization_signals", true);
        if (g0VarE3 != g0Var) {
            l().L().b("Default ad personalization consent from Manifest", g0VarE3);
        }
        b2.g0 g0VarE4 = this.f4008g.E("google_analytics_default_allow_ad_user_data", true);
        if (g0VarE4 != g0Var && v7.l(-10, iA)) {
            J().T(y.c(g0VarE4, -10), true);
        } else if (!TextUtils.isEmpty(D().J()) && (iA == 0 || iA == 30)) {
            J().T(new y(null, -10), true);
        } else {
            if (TextUtils.isEmpty(D().J()) && zzdzVar != null && zzdzVar.f3344g != null && v7.l(30, iA)) {
                y yVarB = y.b(zzdzVar.f3344g, 30);
                if (yVarB.k()) {
                    J().T(yVarB, true);
                }
            }
            if (TextUtils.isEmpty(D().J()) && zzdzVar != null && zzdzVar.f3344g != null && H().f3380o.a() == null && (boolE = y.e(zzdzVar.f3344g)) != null) {
                J().s0(zzdzVar.f3342e, "allow_personalized_ads", boolE.toString(), false);
            }
        }
        Boolean boolH = this.f4008g.H("google_analytics_tcf_data_enabled");
        if (boolH == null) {
            zBooleanValue = true;
        } else {
            zBooleanValue = boolH.booleanValue();
        }
        if (zBooleanValue) {
            l().G().a("TCF client enabled.");
            J().O0();
            J().M0();
        }
        if (H().f3372g.a() == 0) {
            l().L().b("Persisting first open", Long.valueOf(this.G));
            H().f3372g.b(this.G);
        }
        J().f4267r.c();
        if (!v()) {
            if (s()) {
                if (!P().H0("android.permission.INTERNET")) {
                    l().H().a("App is missing INTERNET permission");
                }
                if (!P().H0("android.permission.ACCESS_NETWORK_STATE")) {
                    l().H().a("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!t1.e.a(this.f4002a).e() && !this.f4008g.a0()) {
                    if (!wc.f0(this.f4002a)) {
                        l().H().a("AppMeasurementReceiver not registered/enabled");
                    }
                    if (!wc.g0(this.f4002a, false)) {
                        l().H().a("AppMeasurementService not registered/enabled");
                    }
                }
                l().H().a("Uploading is not possible. App measurement disabled");
            }
        } else {
            if (!TextUtils.isEmpty(D().J()) || !TextUtils.isEmpty(D().G())) {
                P();
                if (wc.n0(D().J(), H().U(), D().G(), H().T())) {
                    l().K().a("Rechecking which service to use due to a GMP App Id change");
                    H().E();
                    E().K();
                    this.f4022u.h0();
                    this.f4022u.g0();
                    H().f3372g.b(this.G);
                    H().f3374i.b(null);
                }
                H().K(D().J());
                H().H(D().G());
            }
            if (!H().O().m(v7.a.ANALYTICS_STORAGE)) {
                H().f3374i.b(null);
            }
            J().Z0(H().f3374i.a());
            if (!P().X0() && !TextUtils.isEmpty(H().f3389x.a())) {
                l().M().a("Remote config removed with active feature rollouts");
                H().f3389x.b(null);
            }
            if (!TextUtils.isEmpty(D().J()) || !TextUtils.isEmpty(D().G())) {
                boolean zS = s();
                if (!H().F() && !this.f4008g.Z()) {
                    H().I(!zS);
                }
                if (zS) {
                    J().H0();
                }
                O().f3720e.a();
                N().W(new AtomicReference<>());
                N().E(H().A.a());
            }
        }
        if (ef.a() && this.f4008g.u(g0.W0) && P().W0()) {
            long jMax = Math.max(500L, ((((long) g0.f3608w0.a(null).intValue()) * 1000) + ((long) new Random().nextInt(5000))) - this.f4015n.b());
            if (jMax > 500) {
                l().L().b("Waiting to fetch trigger URIs until some time after boot. Delay in millis", Long.valueOf(jMax));
            }
            J().d1(jMax);
        }
        H().f3382q.a(true);
    }

    @WorkerThread
    final void n(boolean z10) {
        this.B = Boolean.valueOf(z10);
    }

    @WorkerThread
    public final boolean s() {
        if (z() == 0) {
            return true;
        }
        return false;
    }

    @WorkerThread
    public final boolean t() {
        a().n();
        return this.C;
    }

    @WorkerThread
    public final boolean x() {
        Bundle bundle;
        String str;
        a().n();
        m(K());
        String strH = D().H();
        boolean z10 = false;
        if (!this.f4008g.X()) {
            l().L().a("ADID collection is disabled from Manifest. Skipping");
            return false;
        }
        Pair<String, Boolean> pairV = H().v(strH);
        if (!((Boolean) pairV.second).booleanValue() && !TextUtils.isEmpty((CharSequence) pairV.first)) {
            if (!K().x()) {
                l().M().a("Network is not available for Deferred Deep Link request. Skipping");
                return false;
            }
            StringBuilder sb2 = new StringBuilder();
            x9 x9VarN = N();
            x9VarN.n();
            x9VarN.z();
            if (!x9VarN.p0() || x9VarN.j().J0() >= 234200) {
                zzan zzanVarU0 = J().u0();
                if (zzanVarU0 != null) {
                    bundle = zzanVarU0.f4297a;
                } else {
                    bundle = null;
                }
                if (bundle == null) {
                    int i10 = this.E;
                    this.E = i10 + 1;
                    if (i10 < 10) {
                        z10 = true;
                    }
                    r5 r5VarG = l().G();
                    if (z10) {
                        str = "Retrying.";
                    } else {
                        str = "Skipping.";
                    }
                    r5VarG.b("Failed to retrieve DMA consent from the service, " + str + " retryCount", Integer.valueOf(this.E));
                    return z10;
                }
                v7 v7VarF = v7.f(bundle, 100);
                sb2.append("&gcs=");
                sb2.append(v7VarF.u());
                y yVarB = y.b(bundle, 100);
                sb2.append("&dma=");
                sb2.append(!Objects.equals(yVarB.h(), Boolean.FALSE) ? 1 : 0);
                if (!TextUtils.isEmpty(yVarB.i())) {
                    sb2.append("&dma_cps=");
                    sb2.append(yVarB.i());
                }
                int i11 = !Objects.equals(y.e(bundle), Boolean.TRUE) ? 1 : 0;
                sb2.append("&npa=");
                sb2.append(i11);
                l().L().b("Consent query parameters to Bow", sb2);
            }
            wc wcVarP = P();
            D();
            URL urlL = wcVarP.L(118003L, strH, (String) pairV.first, H().f3388w.a() - 1, sb2.toString());
            if (urlL != null) {
                l9 l9VarK = K();
                j9 j9Var = new j9() { // from class: com.google.android.gms.measurement.internal.v6
                    @Override // com.google.android.gms.measurement.internal.j9
                    public final void a(String str2, int i12, Throwable th, byte[] bArr, Map map) {
                        s6.j(this.f4110a, str2, i12, th, bArr, map);
                    }
                };
                l9VarK.q();
                m1.g.k(urlL);
                m1.g.k(j9Var);
                l9VarK.a().A(new n9(l9VarK, strH, urlL, null, null, j9Var));
            }
            return false;
        }
        l().L().a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
        return false;
    }

    @WorkerThread
    public final void y(boolean z10) {
        a().n();
        this.C = z10;
    }

    @WorkerThread
    public final int z() {
        a().n();
        if (this.f4008g.Z()) {
            return 1;
        }
        if (!t()) {
            return 8;
        }
        Boolean boolR = H().R();
        if (boolR != null) {
            if (boolR.booleanValue()) {
                return 0;
            }
            return 3;
        }
        Boolean boolH = this.f4008g.H("firebase_analytics_collection_enabled");
        if (boolH != null) {
            if (boolH.booleanValue()) {
                return 0;
            }
            return 4;
        }
        if (this.B == null || this.B.booleanValue()) {
            return 0;
        }
        return 7;
    }
}
