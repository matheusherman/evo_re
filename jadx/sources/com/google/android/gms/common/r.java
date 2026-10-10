package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.stub.StubApp;
import java.security.MessageDigest;
import java.util.concurrent.Callable;
import m1.b0;
import m1.c0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile c0 f2409e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Context f2411g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final p f2405a = new j(n.g("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final p f2406b = new k(n.g("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final p f2407c = new l(n.g("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final p f2408d = new m(n.g("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f2410f = new Object();

    static w b(String str, boolean z10, boolean z11, boolean z12) {
        return g(str, z10, false, false, true);
    }

    static /* synthetic */ String c(boolean z10, String str, n nVar) {
        String str2 = (z10 || !f(str, nVar, true, false).f2481a) ? "not allowed" : "debug cert rejected";
        MessageDigest messageDigestB = com.google.android.gms.common.util.a.b("SHA-256");
        m1.g.k(messageDigestB);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, com.google.android.gms.common.util.i.a(messageDigestB.digest(nVar.W())), Boolean.valueOf(z10), "12451000.false");
    }

    static synchronized void d(Context context) {
        if (f2411g != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            f2411g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    private static w f(final String str, final n nVar, final boolean z10, boolean z11) {
        try {
            h();
            m1.g.k(f2411g);
            try {
                return f2409e.h(new zzs(str, nVar, z10, z11), u1.b.W(f2411g.getPackageManager())) ? w.b() : new v(new Callable() { // from class: com.google.android.gms.common.i
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return r.c(z10, str, nVar);
                    }
                }, null);
            } catch (RemoteException e10) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
                return w.d("module call", e10);
            }
        } catch (DynamiteModule.a e11) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e11);
            return w.d("module init: ".concat(String.valueOf(e11.getMessage())), e11);
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [android.os.IBinder, u1.a] */
    private static w g(String str, boolean z10, boolean z11, boolean z12, boolean z13) {
        w wVarD;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            m1.g.k(f2411g);
            try {
                h();
                zzo zzoVar = new zzo(str, z10, false, u1.b.W(f2411g), false, true);
                try {
                    zzq zzqVarC = z13 ? f2409e.C(zzoVar) : f2409e.I(zzoVar);
                    if (zzqVarC.M()) {
                        wVarD = w.f(zzqVarC.P());
                    } else {
                        String strJ = zzqVarC.J();
                        PackageManager.NameNotFoundException nameNotFoundException = zzqVarC.S() == 4 ? new PackageManager.NameNotFoundException() : null;
                        if (strJ == null) {
                            strJ = "error checking package certificate";
                        }
                        wVarD = w.g(zzqVarC.P(), zzqVarC.S(), strJ, nameNotFoundException);
                    }
                } catch (RemoteException e10) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
                    wVarD = w.d("module call", e10);
                }
            } catch (DynamiteModule.a e11) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e11);
                wVarD = w.d("module init: ".concat(String.valueOf(e11.getMessage())), e11);
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return wVarD;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    private static void h() {
        if (f2409e != null) {
            return;
        }
        m1.g.k(f2411g);
        synchronized (f2410f) {
            try {
                if (f2409e == null) {
                    f2409e = b0.f(DynamiteModule.d(f2411g, DynamiteModule.f2503f, "com.google.android.gms.googlecertificates").c("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static w a(String str, n nVar, boolean z10, boolean z11) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return f(str, nVar, z10, z11);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    static boolean e() {
        boolean zJ;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                h();
                zJ = f2409e.j();
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.a e10) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
            zJ = false;
        }
        return zJ;
    }
}
