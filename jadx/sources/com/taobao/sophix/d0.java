package com.taobao.sophix;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f8440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f8441b;

    private static void a(Application application) {
        if (TextUtils.isEmpty(f8441b)) {
            b();
            if (TextUtils.isEmpty(f8441b)) {
                a();
            }
        }
    }

    public static boolean b(Application application) {
        try {
            a(application);
            if (TextUtils.isEmpty(f8440a)) {
                f8440a = application.getPackageManager().getPackageInfo(application.getBaseContext().getPackageName(), 0).applicationInfo.processName;
            }
        } catch (Throwable unused) {
        }
        return !TextUtils.isEmpty(f8440a) && f8440a.equals(f8441b);
    }

    private static void a() {
        if (TextUtils.isEmpty(f8441b)) {
            try {
                Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, null);
                if (objInvoke instanceof String) {
                    String str = (String) objInvoke;
                    f8441b = str;
                    s.d("ProcessUtils", "process name at", str);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void b() {
        if (TextUtils.isEmpty(f8441b) && Build.VERSION.SDK_INT >= 28) {
            String processName = Application.getProcessName();
            f8441b = processName;
            s.d("ProcessUtils", "process name ap", processName);
        }
    }
}
