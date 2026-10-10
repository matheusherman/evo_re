package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class r7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.google.common.base.l<Boolean> f2982a = com.google.common.base.l.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f2983b = new Object();

    private static boolean a(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) == 0) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean b(Context context, Uri uri) {
        int i10;
        String authority = uri.getAuthority();
        boolean z10 = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            Log.e("PhenotypeClientHelper", authority + " is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            return false;
        }
        if (f2982a.c()) {
            return f2982a.b().booleanValue();
        }
        synchronized (f2983b) {
            try {
                if (f2982a.c()) {
                    return f2982a.b().booleanValue();
                }
                if (!"com.google.android.gms".equals(context.getPackageName())) {
                    PackageManager packageManager = context.getPackageManager();
                    if (Build.VERSION.SDK_INT < 29) {
                        i10 = 0;
                    } else {
                        i10 = 268435456;
                    }
                    ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider("com.google.android.gms.phenotype", i10);
                    if (providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                    }
                    f2982a = com.google.common.base.l.d(Boolean.valueOf(z10));
                    return f2982a.b().booleanValue();
                }
                if (a(context)) {
                    z10 = true;
                }
                f2982a = com.google.common.base.l.d(Boolean.valueOf(z10));
                return f2982a.b().booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
