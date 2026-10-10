package com.taobao.sophix;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f8464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<a> f8465b = new ArrayList();

    public static void a(String str, int i10) {
        s.a("SupportUtils", "addModelToBlackList", "modelName", str, "sdkVersion", Integer.valueOf(i10));
        f8465b.add(new a(str, i10));
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f8466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f8467b;

        a(String str, int i10) {
            this.f8466a = str;
            this.f8467b = i10;
        }
    }

    private static boolean b() {
        String str = Build.MODEL;
        int i10 = Build.VERSION.SDK_INT;
        for (a aVar : f8465b) {
            int i11 = aVar.f8467b;
            if (i10 == i11 || i11 == 0) {
                if (str.equals(aVar.f8466a)) {
                    return true;
                }
            }
        }
        try {
            int i12 = SystemProperties.PROP_NAME_MAX;
            Method methodA = e0.a(SystemProperties.class, "get", String.class);
            String str2 = (String) methodA.invoke(null, "ro.yunos.version");
            if (!TextUtils.isEmpty(str2)) {
                s.c("SupportUtils", "isInBlackList", "yun os version", str2);
            }
            if (Build.VERSION.SDK_INT == 23 && !j.f8462f) {
                String str3 = (String) methodA.invoke(null, "dalvik.vm.usejit");
                if (!TextUtils.isEmpty(str3) && str3.equals("true")) {
                    s.b("SupportUtils", "isInBlackList", "don't support art device with jit enabled of low version");
                    return true;
                }
            }
        } catch (Exception e10) {
            s.a("SupportUtils", "isInBlackList", e10, new Object[0]);
        }
        return false;
    }

    public static boolean a() {
        return f8464a || !b();
    }
}
