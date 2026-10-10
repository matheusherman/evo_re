package com.taobao.sophix;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f8480a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f8481b = a.I;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum a {
        V,
        D,
        I,
        W,
        E
    }

    public static void a(boolean z10) {
        f8480a = z10;
    }

    public static void b(a aVar) {
        if (aVar != null) {
            f8481b = aVar;
            if (f8480a) {
                c("LogLevel", "set", "value", aVar);
            }
        }
    }

    public static int e(String str, String str2, Object... objArr) {
        return b(str, str2, null, objArr);
    }

    public static int a(String str, String str2, Object... objArr) {
        if (f8480a && a(a.D)) {
            return Log.d(a(str), a(str2, objArr));
        }
        return 0;
    }

    public static int c(String str, String str2, Object... objArr) {
        if (f8480a && a(a.I)) {
            return Log.i(a(str), a(str2, objArr));
        }
        return 0;
    }

    public static int d(String str, String str2, Object... objArr) {
        if (f8480a && a(a.V)) {
            return Log.v(a(str), a(str2, objArr));
        }
        return 0;
    }

    public static int a(String str, String str2, Throwable th, Object... objArr) {
        if (f8480a && a(a.E)) {
            return Log.e(a(str), a(str2, objArr), th);
        }
        return 0;
    }

    public static int b(String str, String str2, Throwable th, Object... objArr) {
        if (f8480a && a(a.W)) {
            return Log.w(a(str), a(str2, objArr), th);
        }
        return 0;
    }

    private static boolean a(a aVar) {
        return aVar.ordinal() >= f8481b.ordinal();
    }

    public static int b(String str, String str2, Object... objArr) {
        return a(str, str2, null, objArr);
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return "Sophix." + str;
    }

    private static String a(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        if (str != null) {
            sb2.append(" ");
            sb2.append(str);
        }
        if (objArr != null) {
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                if (i11 >= objArr.length) {
                    break;
                }
                sb2.append(" ");
                sb2.append(a(objArr[i10], objArr[i11]));
                i10 += 2;
            }
            if (i10 == objArr.length - 1) {
                sb2.append(" ");
                sb2.append(objArr[i10]);
            }
        }
        return sb2.toString();
    }

    private static String a(Object obj, Object obj2) {
        StringBuilder sb2 = new StringBuilder();
        if (obj == null) {
            obj = "";
        }
        sb2.append(obj);
        sb2.append(": ");
        if (obj2 == null) {
            obj2 = "";
        }
        sb2.append(obj2);
        return sb2.toString();
    }
}
