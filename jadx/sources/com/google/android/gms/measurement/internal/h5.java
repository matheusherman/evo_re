package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.ef;
import com.google.android.gms.internal.measurement.eg;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class h5 extends m5 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f3668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f3671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f3672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f3673h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f3674i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<String> f3675j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f3676k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f3677l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f3678m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f3679n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f3680o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f3681p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f3682q;

    @Override // com.google.android.gms.measurement.internal.m5
    protected final boolean y() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0197  */
    /* JADX WARN: Code duplicated, block: B:49:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:50:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:54:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:56:0x0211  */
    @WorkerThread
    final zzq D(String str) {
        long j10;
        int iA0;
        int i10;
        long jQ0;
        int iB;
        n();
        String strH = H();
        String strJ = J();
        z();
        String str2 = this.f3669d;
        long jF = F();
        z();
        m1.g.k(this.f3671f);
        String str3 = this.f3671f;
        z();
        n();
        if (this.f3673h == 0) {
            this.f3673h = this.f3965a.P().A(b(), b().getPackageName());
        }
        long j11 = this.f3673h;
        boolean zS = this.f3965a.s();
        boolean z10 = !h().f3385t;
        n();
        String str4 = null;
        String strM = !this.f3965a.s() ? null : M();
        s6 s6Var = this.f3965a;
        String str5 = strM;
        long jA = s6Var.H().f3372g.a();
        long jMin = jA == 0 ? s6Var.G : Math.min(s6Var.G, jA);
        int iE = E();
        boolean zX = d().X();
        a6 a6VarH = h();
        a6VarH.n();
        boolean z11 = a6VarH.L().getBoolean("deferred_analytics_collection", false);
        String strG = G();
        Boolean boolValueOf = Boolean.valueOf(d().E("google_analytics_default_allow_ad_personalization_signals", true) != b2.g0.GRANTED);
        long j12 = this.f3674i;
        List<String> list = this.f3675j;
        String strV = h().O().v();
        if (this.f3676k == null) {
            this.f3676k = j().T0();
        }
        String str6 = this.f3676k;
        if (h().O().m(v7.a.ANALYTICS_STORAGE)) {
            n();
            if (this.f3681p != 0) {
                long jA2 = c().a() - this.f3681p;
                if (this.f3680o != null && jA2 > 86400000 && this.f3682q == null) {
                    L();
                }
            }
            if (this.f3680o == null) {
                L();
            }
            str4 = this.f3680o;
        }
        boolean zW = d().w();
        long jB0 = j().B0(H());
        int iB2 = h().O().b();
        String strJ2 = h().N().j();
        if (ef.a()) {
            j10 = jB0;
            if (d().u(g0.W0)) {
                j();
                iA0 = wc.A0();
            }
            if (ef.a()) {
                i10 = iA0;
                if (d().u(g0.W0)) {
                    jQ0 = j().Q0();
                }
                String strW = d().W();
                long j13 = jQ0;
                String strC = new w3(d().E("google_analytics_default_allow_ad_personalization_signals", true)).c();
                long j14 = this.f3965a.G;
                if (d().u(g0.R0)) {
                    iB = t().E().b();
                } else {
                    iB = 0;
                }
                return new zzq(strH, strJ, str2, jF, str3, 118003L, j11, str, zS, z10, str5, jMin, iE, zX, z11, strG, boolValueOf, j12, list, (String) null, strV, str6, str4, zW, j10, iB2, strJ2, i10, j13, strW, strC, j14, iB);
            }
            i10 = iA0;
            jQ0 = 0;
            String strW2 = d().W();
            long j15 = jQ0;
            String strC2 = new w3(d().E("google_analytics_default_allow_ad_personalization_signals", true)).c();
            long j16 = this.f3965a.G;
            if (d().u(g0.R0)) {
                iB = t().E().b();
            } else {
                iB = 0;
            }
            return new zzq(strH, strJ, str2, jF, str3, 118003L, j11, str, zS, z10, str5, jMin, iE, zX, z11, strG, boolValueOf, j12, list, (String) null, strV, str6, str4, zW, j10, iB2, strJ2, i10, j15, strW2, strC2, j16, iB);
        }
        j10 = jB0;
        iA0 = 0;
        if (ef.a()) {
            i10 = iA0;
            if (d().u(g0.W0)) {
                jQ0 = j().Q0();
            }
            String strW3 = d().W();
            long j17 = jQ0;
            String strC3 = new w3(d().E("google_analytics_default_allow_ad_personalization_signals", true)).c();
            long j18 = this.f3965a.G;
            if (d().u(g0.R0)) {
                iB = t().E().b();
            } else {
                iB = 0;
            }
            return new zzq(strH, strJ, str2, jF, str3, 118003L, j11, str, zS, z10, str5, jMin, iE, zX, z11, strG, boolValueOf, j12, list, (String) null, strV, str6, str4, zW, j10, iB2, strJ2, i10, j17, strW3, strC3, j18, iB);
        }
        i10 = iA0;
        jQ0 = 0;
        String strW4 = d().W();
        long j19 = jQ0;
        String strC4 = new w3(d().E("google_analytics_default_allow_ad_personalization_signals", true)).c();
        long j110 = this.f3965a.G;
        if (d().u(g0.R0)) {
            iB = t().E().b();
        } else {
            iB = 0;
        }
        return new zzq(strH, strJ, str2, jF, str3, 118003L, j11, str, zS, z10, str5, jMin, iE, zX, z11, strG, boolValueOf, j12, list, (String) null, strV, str6, str4, zW, j10, iB2, strJ2, i10, j19, strW4, strC4, j110, iB);
    }

    @WorkerThread
    final List<String> K() {
        return this.f3675j;
    }

    final boolean N(String str) {
        String str2 = this.f3682q;
        boolean z10 = (str2 == null || str2.equals(str)) ? false : true;
        this.f3682q = str;
        return z10;
    }

    h5(s6 s6Var, long j10) {
        super(s6Var);
        this.f3681p = 0L;
        this.f3682q = null;
        this.f3674i = j10;
    }

    @VisibleForTesting
    @WorkerThread
    private final String M() {
        if (eg.a() && d().u(g0.G0)) {
            l().L().a("Disabled IID for tests.");
            return null;
        }
        try {
            Class<?> clsLoadClass = b().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (clsLoadClass == null) {
                return null;
            }
            try {
                Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, b());
                if (objInvoke == null) {
                    return null;
                }
                try {
                    return (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", null).invoke(objInvoke, null);
                } catch (Exception unused) {
                    l().N().a("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                l().O().a("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0211 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:47:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:48:0x010b  */
    /* JADX WARN: Code duplicated, block: B:49:0x0119  */
    /* JADX WARN: Code duplicated, block: B:50:0x0127  */
    /* JADX WARN: Code duplicated, block: B:51:0x0135  */
    /* JADX WARN: Code duplicated, block: B:52:0x0143  */
    /* JADX WARN: Code duplicated, block: B:55:0x0153  */
    /* JADX WARN: Code duplicated, block: B:58:0x015a  */
    /* JADX WARN: Code duplicated, block: B:61:0x017d  */
    /* JADX WARN: Code duplicated, block: B:62:0x017e  */
    /* JADX WARN: Code duplicated, block: B:65:0x0187 A[Catch: IllegalStateException -> 0x019f, TryCatch #2 {IllegalStateException -> 0x019f, blocks: (B:59:0x0162, B:63:0x017f, B:65:0x0187, B:69:0x01a3, B:71:0x01b7, B:73:0x01bc, B:72:0x01ba), top: B:97:0x0162 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x01a3 A[Catch: IllegalStateException -> 0x019f, TryCatch #2 {IllegalStateException -> 0x019f, blocks: (B:59:0x0162, B:63:0x017f, B:65:0x0187, B:69:0x01a3, B:71:0x01b7, B:73:0x01bc, B:72:0x01ba), top: B:97:0x0162 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x01b7 A[Catch: IllegalStateException -> 0x019f, TryCatch #2 {IllegalStateException -> 0x019f, blocks: (B:59:0x0162, B:63:0x017f, B:65:0x0187, B:69:0x01a3, B:71:0x01b7, B:73:0x01bc, B:72:0x01ba), top: B:97:0x0162 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x01ba A[Catch: IllegalStateException -> 0x019f, TryCatch #2 {IllegalStateException -> 0x019f, blocks: (B:59:0x0162, B:63:0x017f, B:65:0x0187, B:69:0x01a3, B:71:0x01b7, B:73:0x01bc, B:72:0x01ba), top: B:97:0x0162 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:80:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:81:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:84:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:87:0x0211 A[EDGE_INSN: B:87:0x0211->B:88:0x0213 BREAK  A[LOOP:0: B:82:0x01f8->B:103:?]] */
    /* JADX WARN: Code duplicated, block: B:89:0x0215  */
    /* JADX WARN: Code duplicated, block: B:91:0x0220  */
    @Override // com.google.android.gms.measurement.internal.m5
    @WorkerThread
    protected final void C() {
        String str;
        String string;
        boolean z10;
        boolean z11;
        int iZ;
        List<String> listM;
        Iterator<String> it;
        String strB;
        String str2;
        String packageName = b().getPackageName();
        PackageManager packageManager = b().getPackageManager();
        String str3 = "";
        String installerPackageName = "unknown";
        String str4 = "Unknown";
        int i10 = Integer.MIN_VALUE;
        try {
            if (packageManager == null) {
                l().H().b("PackageManager is null, app identity information might be inaccurate. appId", p5.w(packageName));
            } else {
                try {
                    installerPackageName = packageManager.getInstallerPackageName(packageName);
                } catch (IllegalArgumentException unused) {
                    l().H().b("Error retrieving app installer package name. appId", p5.w(packageName));
                }
                if (installerPackageName == null) {
                    installerPackageName = "manual_install";
                } else if ("com.android.vending".equals(installerPackageName)) {
                    installerPackageName = "";
                }
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(b().getPackageName(), 0);
                    if (packageInfo != null) {
                        CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                        if (TextUtils.isEmpty(applicationLabel)) {
                            string = "Unknown";
                        } else {
                            string = applicationLabel.toString();
                        }
                        try {
                            str4 = packageInfo.versionName;
                            i10 = packageInfo.versionCode;
                        } catch (PackageManager.NameNotFoundException unused2) {
                            str = str4;
                            str4 = string;
                            l().H().c("Error retrieving package info. appId, appName", p5.w(packageName), str4);
                            string = str4;
                            str4 = str;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused3) {
                    str = "Unknown";
                }
                this.f3668c = packageName;
                this.f3671f = installerPackageName;
                this.f3669d = str4;
                this.f3670e = i10;
                this.f3672g = string;
                this.f3673h = 0L;
                z10 = true;
                if (TextUtils.isEmpty(this.f3965a.Q()) && "am".equals(this.f3965a.R())) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                iZ = this.f3965a.z();
                if (iZ != 0) {
                    if (iZ != 1) {
                        if (iZ != 3) {
                            if (iZ != 4) {
                                if (iZ != 6) {
                                    if (iZ != 7) {
                                        if (iZ != 8) {
                                            l().K().a("App measurement disabled");
                                            l().J().a("Invalid scion state in identity");
                                        } else {
                                            l().K().a("App measurement disabled due to denied storage consent");
                                        }
                                    } else {
                                        l().K().a("App measurement disabled via the global data collection setting");
                                    }
                                } else {
                                    l().N().a("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                                }
                            } else {
                                l().K().a("App measurement disabled via the manifest");
                            }
                        } else {
                            l().K().a("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                        }
                    } else {
                        l().K().a("App measurement deactivated via the manifest");
                    }
                } else {
                    l().L().a("App measurement collection enabled");
                }
                if (iZ != 0) {
                    z10 = false;
                }
                this.f3678m = "";
                this.f3679n = "";
                if (z11) {
                    this.f3679n = this.f3965a.Q();
                }
                strB = new b2.y(b(), this.f3965a.T()).b("google_app_id");
                if (TextUtils.isEmpty(strB)) {
                    str3 = strB;
                }
                this.f3678m = str3;
                if (!TextUtils.isEmpty(strB)) {
                    this.f3679n = new b2.y(b(), this.f3965a.T()).b("admob_app_id");
                }
                if (z10) {
                    r5 r5VarL = l().L();
                    String str5 = this.f3668c;
                    if (TextUtils.isEmpty(this.f3678m)) {
                        str2 = this.f3679n;
                    } else {
                        str2 = this.f3678m;
                    }
                    r5VarL.c("App measurement enabled for app package, google app id", str5, str2);
                }
                this.f3675j = null;
                listM = d().M("analytics.safelisted_events");
                if (listM == null) {
                    if (listM.isEmpty()) {
                        l().N().a("Safelisted event list is empty. Ignoring");
                    } else {
                        it = listM.iterator();
                        do {
                            if (it.hasNext()) {
                            } else {
                                this.f3675j = listM;
                                break;
                            }
                        } while (j().y0("safelisted event", it.next()));
                    }
                } else {
                    this.f3675j = listM;
                    break;
                }
                if (packageManager != null) {
                    this.f3677l = t1.b.a(b()) ? 1 : 0;
                } else {
                    this.f3677l = 0;
                }
            }
            strB = new b2.y(b(), this.f3965a.T()).b("google_app_id");
            if (TextUtils.isEmpty(strB)) {
                str3 = strB;
            }
            this.f3678m = str3;
            if (!TextUtils.isEmpty(strB)) {
                this.f3679n = new b2.y(b(), this.f3965a.T()).b("admob_app_id");
            }
            if (z10) {
                r5 r5VarL2 = l().L();
                String str6 = this.f3668c;
                if (TextUtils.isEmpty(this.f3678m)) {
                    str2 = this.f3679n;
                } else {
                    str2 = this.f3678m;
                }
                r5VarL2.c("App measurement enabled for app package, google app id", str6, str2);
            }
        } catch (IllegalStateException e10) {
            l().H().c("Fetching Google App Id failed with exception. appId", p5.w(packageName), e10);
        }
        string = "Unknown";
        this.f3668c = packageName;
        this.f3671f = installerPackageName;
        this.f3669d = str4;
        this.f3670e = i10;
        this.f3672g = string;
        this.f3673h = 0L;
        z10 = true;
        if (TextUtils.isEmpty(this.f3965a.Q())) {
            z11 = false;
        } else {
            z11 = false;
        }
        iZ = this.f3965a.z();
        if (iZ != 0) {
            if (iZ != 1) {
                if (iZ != 3) {
                    if (iZ != 4) {
                        if (iZ != 6) {
                            if (iZ != 7) {
                                if (iZ != 8) {
                                    l().K().a("App measurement disabled");
                                    l().J().a("Invalid scion state in identity");
                                } else {
                                    l().K().a("App measurement disabled due to denied storage consent");
                                }
                            } else {
                                l().K().a("App measurement disabled via the global data collection setting");
                            }
                        } else {
                            l().N().a("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                        }
                    } else {
                        l().K().a("App measurement disabled via the manifest");
                    }
                } else {
                    l().K().a("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                }
            } else {
                l().K().a("App measurement deactivated via the manifest");
            }
        } else {
            l().L().a("App measurement collection enabled");
        }
        if (iZ != 0) {
            z10 = false;
        }
        this.f3678m = "";
        this.f3679n = "";
        if (z11) {
            this.f3679n = this.f3965a.Q();
        }
        this.f3675j = null;
        listM = d().M("analytics.safelisted_events");
        if (listM == null) {
            if (listM.isEmpty()) {
                l().N().a("Safelisted event list is empty. Ignoring");
            } else {
                it = listM.iterator();
                do {
                    if (it.hasNext()) {
                    } else {
                        this.f3675j = listM;
                        break;
                    }
                } while (j().y0("safelisted event", it.next()));
            }
        } else {
            this.f3675j = listM;
            break;
        }
        if (packageManager != null) {
            this.f3677l = t1.b.a(b()) ? 1 : 0;
        } else {
            this.f3677l = 0;
        }
    }

    @WorkerThread
    final int E() {
        z();
        return this.f3677l;
    }

    @WorkerThread
    final int F() {
        z();
        return this.f3670e;
    }

    @WorkerThread
    final String G() {
        z();
        return this.f3679n;
    }

    @WorkerThread
    final String H() {
        z();
        m1.g.k(this.f3668c);
        return this.f3668c;
    }

    @WorkerThread
    final String I() {
        z();
        m1.g.k(this.f3672g);
        return this.f3672g;
    }

    @WorkerThread
    final String J() {
        n();
        z();
        m1.g.k(this.f3678m);
        return this.f3678m;
    }

    @WorkerThread
    final void L() {
        String str;
        String str2;
        n();
        if (!h().O().m(v7.a.ANALYTICS_STORAGE)) {
            l().G().a("Analytics Storage consent is not granted");
            str = null;
        } else {
            byte[] bArr = new byte[16];
            j().V0().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        r5 r5VarG = l().G();
        if (str == null) {
            str2 = Configurator.NULL;
        } else {
            str2 = "not null";
        }
        r5VarG.a(String.format("Resetting session stitching token to %s", str2));
        this.f3680o = str;
        this.f3681p = c().a();
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

    @Override // com.google.android.gms.measurement.internal.v2, com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p5 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.v2, com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void m() {
        super.m();
    }

    @Override // com.google.android.gms.measurement.internal.v2, com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void n() {
        super.n();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ w o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ h5 q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ j5 r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ z7 s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ o9 t() {
        return super.t();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ s9 u() {
        return super.u();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ x9 v() {
        return super.v();
    }

    @Override // com.google.android.gms.measurement.internal.v2
    public final /* bridge */ /* synthetic */ ib w() {
        return super.w();
    }
}
