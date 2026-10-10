package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class a7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    @GuardedBy("DirectBootUtils.class")
    private static UserManager f2536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f2537b = !a();

    @RequiresApi(24)
    @TargetApi(24)
    @GuardedBy("DirectBootUtils.class")
    private static boolean e(Context context) {
        boolean z10;
        boolean z11 = true;
        int i10 = 1;
        while (true) {
            z10 = false;
            if (i10 > 2) {
                break;
            }
            if (f2536a == null) {
                f2536a = (UserManager) context.getSystemService(UserManager.class);
            }
            UserManager userManager = f2536a;
            if (userManager == null) {
                return true;
            }
            try {
                if (!userManager.isUserUnlocked() && userManager.isUserRunning(Process.myUserHandle())) {
                    z11 = false;
                }
                z10 = z11;
                break;
            } catch (NullPointerException e10) {
                Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e10);
                f2536a = null;
                i10++;
            }
        }
        if (z10) {
            f2536a = null;
        }
        return z10;
    }

    @ChecksSdkIntAtLeast(api = 24)
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @RequiresApi(24)
    @TargetApi(24)
    private static boolean d(Context context) {
        if (f2537b) {
            return true;
        }
        synchronized (a7.class) {
            try {
                if (f2537b) {
                    return true;
                }
                boolean zE = e(context);
                if (zE) {
                    f2537b = zE;
                }
                return zE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private a7() {
    }

    public static boolean b(Context context) {
        if (a() && !d(context)) {
            return true;
        }
        return false;
    }

    public static boolean c(Context context) {
        if (a() && !d(context)) {
            return false;
        }
        return true;
    }
}
