package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.apps.common.proguard.SideEffectFree;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private static Boolean f2467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private static Boolean f2468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private static Boolean f2469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private static Boolean f2470d;

    public static boolean b() {
        int i10 = com.google.android.gms.common.d.f2204a;
        return "user".equals(Build.TYPE);
    }

    @TargetApi(21)
    public static boolean e(@NonNull Context context) {
        if (f2468b == null) {
            f2468b = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f2468b.booleanValue();
    }

    public static boolean f(@NonNull Context context) {
        if (f2469c == null) {
            boolean z10 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z10 = false;
            }
            f2469c = Boolean.valueOf(z10);
        }
        return f2469c.booleanValue();
    }

    @SideEffectFree
    @TargetApi(20)
    public static boolean g(@NonNull PackageManager packageManager) {
        if (f2467a == null) {
            f2467a = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f2467a.booleanValue();
    }

    public static boolean a(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f2470d == null) {
            boolean z10 = false;
            if (m.d() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z10 = true;
            }
            f2470d = Boolean.valueOf(z10);
        }
        return f2470d.booleanValue();
    }

    @SideEffectFree
    @TargetApi(20)
    public static boolean c(@NonNull Context context) {
        return g(context.getPackageManager());
    }

    @TargetApi(26)
    public static boolean d(@NonNull Context context) {
        if (!c(context) || m.c()) {
            if (e(context)) {
                if (!m.d() || m.g()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return true;
    }
}
