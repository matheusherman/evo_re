package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.WorkerThread;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class a6 extends u7 {
    static final Pair<String, Long> B = new Pair<>("", 0L);
    public final c6 A;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences f3368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f3369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SharedPreferences f3370e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e6 f3371f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b6 f3372g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b6 f3373h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d6 f3374i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f3375j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f3376k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f3377l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b6 f3378m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final z5 f3379n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final d6 f3380o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c6 f3381p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final z5 f3382q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b6 f3383r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b6 f3384s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f3385t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public z5 f3386u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public z5 f3387v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public b6 f3388w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final d6 f3389x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final d6 f3390y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final b6 f3391z;

    @Override // com.google.android.gms.measurement.internal.u7
    protected final boolean u() {
        return true;
    }

    @WorkerThread
    final boolean F() {
        SharedPreferences sharedPreferences = this.f3368c;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    final SparseArray<Long> M() {
        Bundle bundleA = this.f3381p.a();
        if (bundleA == null) {
            return new SparseArray<>();
        }
        int[] intArray = bundleA.getIntArray("uriSources");
        long[] longArray = bundleA.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray<>();
        }
        if (intArray.length != longArray.length) {
            l().H().a("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray<>();
        }
        SparseArray<Long> sparseArray = new SparseArray<>();
        for (int i10 = 0; i10 < intArray.length; i10++) {
            sparseArray.put(intArray[i10], Long.valueOf(longArray[i10]));
        }
        return sparseArray;
    }

    final boolean z(long j10) {
        return j10 - this.f3378m.a() > this.f3383r.a();
    }

    a6(s6 s6Var) {
        super(s6Var);
        this.f3369d = new Object();
        this.f3378m = new b6(this, "session_timeout", 1800000L);
        this.f3379n = new z5(this, "start_new_session", true);
        this.f3383r = new b6(this, "last_pause_time", 0L);
        this.f3384s = new b6(this, "session_id", 0L);
        this.f3380o = new d6(this, "non_personalized_ads", null);
        this.f3381p = new c6(this, "last_received_uri_timestamps_by_source", null);
        this.f3382q = new z5(this, "allow_remote_dynamite", false);
        this.f3372g = new b6(this, "first_open_time", 0L);
        this.f3373h = new b6(this, "app_install_time", 0L);
        this.f3374i = new d6(this, "app_instance_id", null);
        this.f3386u = new z5(this, "app_backgrounded", false);
        this.f3387v = new z5(this, "deep_link_retrieval_complete", false);
        this.f3388w = new b6(this, "deep_link_retrieval_attempts", 0L);
        this.f3389x = new d6(this, "firebase_feature_rollouts", null);
        this.f3390y = new d6(this, "deferred_attribution_cache", null);
        this.f3391z = new b6(this, "deferred_attribution_cache_timestamp", 0L);
        this.A = new c6(this, "default_event_parameters", null);
    }

    @WorkerThread
    final boolean A(y yVar) {
        n();
        if (v7.l(yVar.a(), N().a())) {
            SharedPreferences.Editor editorEdit = L().edit();
            editorEdit.putString("dma_consent_settings", yVar.j());
            editorEdit.apply();
            return true;
        }
        return false;
    }

    @WorkerThread
    final boolean B(v7 v7Var) {
        n();
        int iB = v7Var.b();
        if (y(iB)) {
            SharedPreferences.Editor editorEdit = L().edit();
            editorEdit.putString("consent_settings", v7Var.v());
            editorEdit.putInt("consent_source", iB);
            editorEdit.apply();
            return true;
        }
        return false;
    }

    @WorkerThread
    protected final boolean C(pb pbVar) {
        n();
        String string = L().getString("stored_tcf_param", "");
        String strE = pbVar.e();
        if (!strE.equals(string)) {
            SharedPreferences.Editor editorEdit = L().edit();
            editorEdit.putString("stored_tcf_param", strE);
            editorEdit.apply();
            return true;
        }
        return false;
    }

    @WorkerThread
    protected final String D() {
        n();
        return L().getString("stored_tcf_param", "");
    }

    @WorkerThread
    final void E() {
        n();
        Boolean boolR = R();
        SharedPreferences.Editor editorEdit = L().edit();
        editorEdit.clear();
        editorEdit.apply();
        if (boolR != null) {
            w(boolR);
        }
    }

    @WorkerThread
    final void G(Boolean bool) {
        n();
        SharedPreferences.Editor editorEdit = L().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled_from_api");
        }
        editorEdit.apply();
    }

    @WorkerThread
    final void H(String str) {
        n();
        SharedPreferences.Editor editorEdit = L().edit();
        editorEdit.putString("admob_app_id", str);
        editorEdit.apply();
    }

    @WorkerThread
    final void I(boolean z10) {
        n();
        l().L().b("App measurement setting deferred collection", Boolean.valueOf(z10));
        SharedPreferences.Editor editorEdit = L().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z10);
        editorEdit.apply();
    }

    @WorkerThread
    protected final SharedPreferences J() {
        n();
        q();
        if (this.f3370e == null) {
            synchronized (this.f3369d) {
                try {
                    if (this.f3370e == null) {
                        String str = b().getPackageName() + "_preferences";
                        l().L().b("Default prefs file", str);
                        this.f3370e = b().getSharedPreferences(str, 0);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f3370e;
    }

    @WorkerThread
    final void K(String str) {
        n();
        SharedPreferences.Editor editorEdit = L().edit();
        editorEdit.putString("gmp_app_id", str);
        editorEdit.apply();
    }

    @WorkerThread
    protected final SharedPreferences L() {
        n();
        q();
        m1.g.k(this.f3368c);
        return this.f3368c;
    }

    @WorkerThread
    final y N() {
        n();
        return y.d(L().getString("dma_consent_settings", null));
    }

    @WorkerThread
    final v7 O() {
        n();
        return v7.i(L().getString("consent_settings", "G1"), L().getInt("consent_source", 100));
    }

    @WorkerThread
    final Boolean P() {
        n();
        if (!L().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(L().getBoolean("use_service", false));
    }

    @WorkerThread
    final Boolean Q() {
        n();
        if (L().contains("measurement_enabled_from_api")) {
            return Boolean.valueOf(L().getBoolean("measurement_enabled_from_api", true));
        }
        return null;
    }

    @WorkerThread
    final Boolean R() {
        n();
        if (L().contains("measurement_enabled")) {
            return Boolean.valueOf(L().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    @WorkerThread
    protected final String S() {
        n();
        String string = L().getString("previous_os_version", null);
        f().q();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor editorEdit = L().edit();
            editorEdit.putString("previous_os_version", str);
            editorEdit.apply();
        }
        return string;
    }

    @WorkerThread
    final String T() {
        n();
        return L().getString("admob_app_id", null);
    }

    @WorkerThread
    final String U() {
        n();
        return L().getString("gmp_app_id", null);
    }

    @Override // com.google.android.gms.measurement.internal.u7
    @WorkerThread
    protected final void o() {
        SharedPreferences sharedPreferences = b().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f3368c = sharedPreferences;
        boolean z10 = sharedPreferences.getBoolean("has_been_opened", false);
        this.f3385t = z10;
        if (!z10) {
            SharedPreferences.Editor editorEdit = this.f3368c.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        this.f3371f = new e6(this, "health_monitor", Math.max(0L, g0.f3556d.a(null).longValue()), null);
    }

    @WorkerThread
    final Pair<String, Boolean> v(String str) {
        n();
        if (!O().m(v7.a.AD_STORAGE)) {
            return new Pair<>("", Boolean.FALSE);
        }
        long jB = c().b();
        if (this.f3375j != null && jB < this.f3377l) {
            return new Pair<>(this.f3375j, Boolean.valueOf(this.f3376k));
        }
        this.f3377l = jB + d().F(str);
        g1.a.b(true);
        try {
            g1.a.C0182a c0182aA = g1.a.a(b());
            this.f3375j = "";
            String strA = c0182aA.a();
            if (strA != null) {
                this.f3375j = strA;
            }
            this.f3376k = c0182aA.b();
        } catch (Exception e10) {
            l().G().b("Unable to get advertising id", e10);
            this.f3375j = "";
        }
        g1.a.b(false);
        return new Pair<>(this.f3375j, Boolean.valueOf(this.f3376k));
    }

    @WorkerThread
    final void w(Boolean bool) {
        n();
        SharedPreferences.Editor editorEdit = L().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
    }

    @WorkerThread
    final void x(boolean z10) {
        n();
        SharedPreferences.Editor editorEdit = L().edit();
        editorEdit.putBoolean("use_service", z10);
        editorEdit.apply();
    }

    @WorkerThread
    final boolean y(int i10) {
        return v7.l(i10, L().getInt("consent_source", 100));
    }
}
