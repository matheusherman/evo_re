package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f8761a = "CrashReportInfo";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f8762b = "CrashReport";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f8763c;

    private static boolean a(int i10, String str, Object... objArr) {
        if (!f8763c) {
            return false;
        }
        if (str == null) {
            str = Configurator.NULL;
        } else if (objArr != null && objArr.length != 0) {
            str = String.format(Locale.US, str, objArr);
        }
        if (i10 == 0) {
            Log.i(f8762b, str);
            return true;
        }
        if (i10 == 1) {
            Log.d(f8762b, str);
            return true;
        }
        if (i10 == 2) {
            Log.w(f8762b, str);
            return true;
        }
        if (i10 == 3) {
            Log.e(f8762b, str);
            return true;
        }
        if (i10 != 5) {
            return false;
        }
        Log.i(f8761a, str);
        return true;
    }

    public static boolean b(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public static boolean c(String str, Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean d(String str, Object... objArr) {
        return a(2, str, objArr);
    }

    public static boolean e(String str, Object... objArr) {
        return a(3, str, objArr);
    }

    public static boolean b(Throwable th) {
        return a(3, th);
    }

    private static boolean a(int i10, Throwable th) {
        if (f8763c) {
            return a(i10, ap.a(th), new Object[0]);
        }
        return false;
    }

    public static boolean a(String str, Object... objArr) {
        return a(0, str, objArr);
    }

    public static boolean a(Class cls, String str, Object... objArr) {
        return a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean a(Throwable th) {
        return a(2, th);
    }
}
