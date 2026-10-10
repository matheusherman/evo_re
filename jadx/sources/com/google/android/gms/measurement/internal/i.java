package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemProperties;
import android.text.TextUtils;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class i extends r7 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f3699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f3700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private k f3701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Boolean f3702e;

    @VisibleForTesting
    private final Bundle x() {
        try {
            if (b().getPackageManager() == null) {
                l().H().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfoB = t1.e.a(b()).b(b().getPackageName(), 128);
            if (applicationInfoB != null) {
                return applicationInfoB.metaData;
            }
            l().H().a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            l().H().b("Failed to load metadata: Package name not found", e10);
            return null;
        }
    }

    public final boolean u(f5<Boolean> f5Var) {
        return K(null, f5Var);
    }

    public static long L() {
        return g0.f3559e.a(null).longValue();
    }

    public static long N() {
        return g0.f3580l.a(null).intValue();
    }

    public static long S() {
        return g0.R.a(null).longValue();
    }

    public static long T() {
        return g0.M.a(null).longValue();
    }

    private final String p(String str, String str2) {
        try {
            int i10 = SystemProperties.PROP_NAME_MAX;
            String str3 = (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(null, str, str2);
            m1.g.k(str3);
            return str3;
        } catch (ClassNotFoundException e10) {
            l().H().b("Could not find SystemProperties class", e10);
            return str2;
        } catch (IllegalAccessException e11) {
            l().H().b("Could not access SystemProperties.get()", e11);
            return str2;
        } catch (NoSuchMethodException e12) {
            l().H().b("Could not find SystemProperties.get() method", e12);
            return str2;
        } catch (InvocationTargetException e13) {
            l().H().b("SystemProperties.get() threw an exception", e13);
            return str2;
        }
    }

    @WorkerThread
    public final int C(@Size(min = 1) String str) {
        return z(str, g0.f3592p);
    }

    @WorkerThread
    final long F(String str) {
        return D(str, g0.f3550b);
    }

    @WorkerThread
    final String J(String str) {
        return G(str, g0.f3548a0);
    }

    public final void O(String str) {
        this.f3700c = str;
    }

    @WorkerThread
    final boolean P(String str) {
        return K(str, g0.Z);
    }

    public final boolean Q(String str) {
        return "1".equals(this.f3701d.p(str, "gaia_collection_enabled"));
    }

    public final boolean R(String str) {
        return "1".equals(this.f3701d.p(str, "measurement.event_sampling_enabled"));
    }

    public final String U() {
        return p("debug.firebase.analytics.app", "");
    }

    public final String V() {
        return p("debug.deferred.deeplink", "");
    }

    public final String W() {
        return this.f3700c;
    }

    public final boolean X() {
        Boolean boolH = H("google_analytics_adid_collection_enabled");
        return boolH == null || boolH.booleanValue();
    }

    public final boolean Y() {
        Boolean boolH = H("google_analytics_automatic_screen_reporting_enabled");
        return boolH == null || boolH.booleanValue();
    }

    public final boolean Z() {
        Boolean boolH = H("firebase_analytics_collection_deactivated");
        return boolH != null && boolH.booleanValue();
    }

    @WorkerThread
    final boolean a0() {
        if (this.f3699b == null) {
            Boolean boolH = H("app_measurement_lite");
            this.f3699b = boolH;
            if (boolH == null) {
                this.f3699b = Boolean.FALSE;
            }
        }
        return this.f3699b.booleanValue() || !this.f3965a.w();
    }

    final int q(@Size(min = 1) String str) {
        return r(str, g0.W, 500, 2000);
    }

    final int s(String str, boolean z10) {
        if (z10) {
            return r(str, g0.f3566g0, 100, 500);
        }
        return 500;
    }

    final void t(k kVar) {
        this.f3701d = kVar;
    }

    public final boolean v() {
        if (this.f3702e == null) {
            synchronized (this) {
                try {
                    if (this.f3702e == null) {
                        ApplicationInfo applicationInfo = b().getApplicationInfo();
                        String strA = com.google.android.gms.common.util.p.a();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            this.f3702e = Boolean.valueOf(str != null && str.equals(strA));
                        }
                        if (this.f3702e == null) {
                            this.f3702e = Boolean.TRUE;
                            l().H().a("My process not in the list of running processes");
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f3702e.booleanValue();
    }

    public final boolean w() {
        Boolean boolH = H("google_analytics_sgtm_upload_enabled");
        if (boolH == null) {
            return false;
        }
        return boolH.booleanValue();
    }

    public final int y(@Size(min = 1) String str) {
        return r(str, g0.X, 25, 100);
    }

    i(s6 s6Var) {
        super(s6Var);
        this.f3701d = new k() { // from class: com.google.android.gms.measurement.internal.h
            @Override // com.google.android.gms.measurement.internal.k
            public final String p(String str, String str2) {
                return null;
            }
        };
    }

    final int A(String str, boolean z10) {
        return Math.max(s(str, z10), 256);
    }

    public final int B() {
        if (j().e0(201500000, true)) {
            return 100;
        }
        return 25;
    }

    @WorkerThread
    public final long D(String str, f5<Long> f5Var) {
        if (TextUtils.isEmpty(str)) {
            return f5Var.a(null).longValue();
        }
        String strP = this.f3701d.p(str, f5Var.b());
        if (TextUtils.isEmpty(strP)) {
            return f5Var.a(null).longValue();
        }
        try {
            return f5Var.a(Long.valueOf(Long.parseLong(strP))).longValue();
        } catch (NumberFormatException unused) {
            return f5Var.a(null).longValue();
        }
    }

    public final b2.g0 E(String str, boolean z10) {
        Object obj;
        m1.g.e(str);
        Bundle bundleX = x();
        if (bundleX == null) {
            l().H().a("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = bundleX.get(str);
        }
        if (obj == null) {
            return b2.g0.UNINITIALIZED;
        }
        if (Boolean.TRUE.equals(obj)) {
            return b2.g0.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return b2.g0.DENIED;
        }
        if (z10 && "eu_consent_policy".equals(obj)) {
            return b2.g0.POLICY;
        }
        l().M().b("Invalid manifest metadata for", str);
        return b2.g0.UNINITIALIZED;
    }

    @WorkerThread
    public final String G(String str, f5<String> f5Var) {
        if (TextUtils.isEmpty(str)) {
            return f5Var.a(null);
        }
        return f5Var.a(this.f3701d.p(str, f5Var.b()));
    }

    final Boolean H(@Size(min = 1) String str) {
        m1.g.e(str);
        Bundle bundleX = x();
        if (bundleX == null) {
            l().H().a("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (!bundleX.containsKey(str)) {
            return null;
        }
        return Boolean.valueOf(bundleX.getBoolean(str));
    }

    public final boolean I(String str, f5<Boolean> f5Var) {
        return K(str, f5Var);
    }

    @WorkerThread
    public final boolean K(String str, f5<Boolean> f5Var) {
        if (TextUtils.isEmpty(str)) {
            return f5Var.a(null).booleanValue();
        }
        String strP = this.f3701d.p(str, f5Var.b());
        if (TextUtils.isEmpty(strP)) {
            return f5Var.a(null).booleanValue();
        }
        return f5Var.a(Boolean.valueOf("1".equals(strP))).booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x003d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x003e A[Catch: NotFoundException -> 0x0043, TRY_LEAVE, TryCatch #0 {NotFoundException -> 0x0043, blocks: (B:12:0x002b, B:15:0x003e), top: B:20:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:20:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    final List<String> M(@Size(min = 1) String str) {
        Integer numValueOf;
        String[] stringArray;
        m1.g.e(str);
        Bundle bundleX = x();
        if (bundleX == null) {
            l().H().a("Failed to load metadata: Metadata bundle is null");
        } else {
            if (bundleX.containsKey(str)) {
                numValueOf = Integer.valueOf(bundleX.getInt(str));
            }
            if (numValueOf == null) {
                return null;
            }
            try {
                stringArray = b().getResources().getStringArray(numValueOf.intValue());
                if (stringArray == null) {
                    return null;
                }
                return Arrays.asList(stringArray);
            } catch (Resources.NotFoundException e10) {
                l().H().b("Failed to load string array from metadata: resource not found", e10);
                return null;
            }
        }
        numValueOf = null;
        if (numValueOf == null) {
            return null;
        }
        stringArray = b().getResources().getStringArray(numValueOf.intValue());
        if (stringArray == null) {
            return null;
        }
        return Arrays.asList(stringArray);
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p6 a() {
        return super.a();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ Context b() {
        return super.b();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.d c() {
        return super.c();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ i d() {
        return super.d();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ e e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ a0 f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ k5 g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ a6 h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ l9 i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ wc j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p5 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void m() {
        super.m();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void n() {
        super.n();
    }

    @WorkerThread
    public final double o(String str, f5<Double> f5Var) {
        if (TextUtils.isEmpty(str)) {
            return f5Var.a(null).doubleValue();
        }
        String strP = this.f3701d.p(str, f5Var.b());
        if (TextUtils.isEmpty(strP)) {
            return f5Var.a(null).doubleValue();
        }
        try {
            return f5Var.a(Double.valueOf(Double.parseDouble(strP))).doubleValue();
        } catch (NumberFormatException unused) {
            return f5Var.a(null).doubleValue();
        }
    }

    @WorkerThread
    public final int r(String str, f5<Integer> f5Var, int i10, int i11) {
        return Math.max(Math.min(z(str, f5Var), i11), i10);
    }

    @WorkerThread
    public final int z(String str, f5<Integer> f5Var) {
        if (TextUtils.isEmpty(str)) {
            return f5Var.a(null).intValue();
        }
        String strP = this.f3701d.p(str, f5Var.b());
        if (TextUtils.isEmpty(strP)) {
            return f5Var.a(null).intValue();
        }
        try {
            return f5Var.a(Integer.valueOf(Integer.parseInt(strP))).intValue();
        } catch (NumberFormatException unused) {
            return f5Var.a(null).intValue();
        }
    }
}
