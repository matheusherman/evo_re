package com.ta.utdid2.device;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.lang.reflect.Method;
import m7.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f8384e;

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public static boolean m94c(Context context) {
        try {
            String strE = e(context);
            String strC = c(context);
            f.e("", "curProcessName", strC);
            if (!TextUtils.isEmpty(strC) && !TextUtils.isEmpty(strE)) {
                return strC.equals(strE);
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String d(Context context) {
        try {
            int iMyPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static String o() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, null);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            f.d("", th, new Object[0]);
            return null;
        }
    }

    private static String n() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                return Application.getProcessName();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception e10) {
            f.d("", e10, new Object[0]);
            return null;
        }
    }

    private static String e(Context context) {
        PackageInfo packageInfoA = a(context);
        if (packageInfoA != null) {
            return packageInfoA.packageName;
        }
        return "";
    }

    private static String c(Context context) {
        if (!TextUtils.isEmpty(f8384e)) {
            return f8384e;
        }
        String strN = n();
        f8384e = strN;
        f.e("", "currentProcessName", strN);
        if (!TextUtils.isEmpty(f8384e)) {
            return f8384e;
        }
        String strO = o();
        f8384e = strO;
        f.e("", "currentProcessName2", strO);
        if (!TextUtils.isEmpty(f8384e)) {
            return f8384e;
        }
        String strD = d(context);
        f8384e = strD;
        f.e("", "currentProcessName3", strD);
        return f8384e;
    }
}
