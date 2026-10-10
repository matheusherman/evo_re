package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.NonNull;
import com.stub.StubApp;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static e f2229c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile String f2231b;

    public static final boolean e(@NonNull PackageInfo packageInfo, boolean z10) {
        PackageInfo packageInfo2;
        if (!z10) {
            packageInfo2 = packageInfo;
        } else if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z10 = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z10 ? d(packageInfo2, q.f2404a) : d(packageInfo2, q.f2404a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean b(@NonNull PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (e(packageInfo, false)) {
            return true;
        }
        if (e(packageInfo, true)) {
            if (d.e(this.f2230a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    static final n d(PackageInfo packageInfo, n... nVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            o oVar = new o(packageInfo.signatures[0].toByteArray());
            for (int i10 = 0; i10 < nVarArr.length; i10++) {
                if (nVarArr[i10].equals(oVar)) {
                    return nVarArr[i10];
                }
            }
        }
        return null;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private final w f(String str, boolean z10, boolean z11) {
        w wVarC;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return w.c("null pkg");
        }
        if (str.equals(this.f2231b)) {
            return w.b();
        }
        if (r.e()) {
            wVarC = r.b(str, d.e(this.f2230a), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.f2230a.getPackageManager().getPackageInfo(str, 64);
                boolean zE = d.e(this.f2230a);
                if (packageInfo == null) {
                    wVarC = w.c("null pkg");
                } else {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        wVarC = w.c("single cert required");
                    } else {
                        o oVar = new o(packageInfo.signatures[0].toByteArray());
                        String str2 = packageInfo.packageName;
                        w wVarA = r.a(str2, oVar, zE, false);
                        wVarC = (!wVarA.f2481a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !r.a(str2, oVar, false, true).f2481a) ? wVarA : w.c("debuggable release cert app rejected");
                    }
                }
            } catch (PackageManager.NameNotFoundException e10) {
                return w.d("no pkg ".concat(str), e10);
            }
        }
        if (wVarC.f2481a) {
            this.f2231b = str;
        }
        return wVarC;
    }

    public boolean c(int i10) {
        w wVarC;
        String[] packagesForUid = this.f2230a.getPackageManager().getPackagesForUid(i10);
        if (packagesForUid == null || (packagesForUid.length) == 0) {
            wVarC = w.c("no pkgs");
        } else {
            wVarC = null;
            for (String str : packagesForUid) {
                wVarC = f(str, false, false);
                if (!wVarC.f2481a) {
                }
            }
            m1.g.k(wVarC);
        }
        wVarC.e();
        return wVarC.f2481a;
    }

    public e(@NonNull Context context) {
        this.f2230a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @NonNull
    public static e a(@NonNull Context context) {
        m1.g.k(context);
        synchronized (e.class) {
            try {
                if (f2229c == null) {
                    r.d(context);
                    f2229c = new e(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f2229c;
    }
}
