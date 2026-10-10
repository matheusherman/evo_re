package m7;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f15669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f15670b;

    private static StackTraceElement a() {
        try {
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(f.class.getName())) {
                    return stackTraceElement;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static String b(Object obj, Object obj2) {
        if (obj == null) {
            obj = "";
        }
        if (obj2 == null) {
            obj2 = "";
        }
        return String.format("%s:%s", obj, obj2);
    }

    private static String c(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        if (str == null) {
            str = "-";
        }
        int i10 = 0;
        sb2.append(String.format("[%s] ", str));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i11 = i10 + 1;
                if (i11 >= objArr.length) {
                    break;
                }
                sb2.append(b(objArr[i10], objArr[i11]));
                if (i11 < length - 1) {
                    sb2.append(",");
                }
                i10 += 2;
            }
            if (i10 == objArr.length - 1) {
                sb2.append(objArr[i10]);
            }
        }
        return sb2.toString();
    }

    public static void d(String str, Throwable th, Object... objArr) {
        if (f15669a) {
            Log.e(j(), c(str, objArr), th);
        }
    }

    public static void e(String str, Object... objArr) {
        if (f15669a) {
            Log.d(j(), c(str, objArr));
        }
    }

    public static boolean f() {
        return f15669a;
    }

    public static void g(String str, Throwable th, Object... objArr) {
        if (f15670b) {
            Log.e(j(), c(str, objArr), th);
        }
    }

    public static void h(String str, Object... objArr) {
        if (f15670b) {
            Log.d(j(), c(str, objArr));
        }
    }

    public static void i() {
        if (f15669a) {
            Log.d(j(), c(null, new Object[0]));
        }
    }

    private static String j() {
        String methodName;
        String strSubstring;
        StackTraceElement stackTraceElementA = a();
        if (stackTraceElementA == null) {
            methodName = "";
            strSubstring = methodName;
        } else {
            String className = stackTraceElementA.getClassName();
            if (TextUtils.isEmpty(className)) {
                strSubstring = "";
            } else {
                strSubstring = className.substring(className.lastIndexOf(46) + 1);
            }
            methodName = stackTraceElementA.getMethodName();
        }
        return "Utdid." + strSubstring + "." + methodName + "." + String.valueOf(Process.myPid()) + "." + (Thread.currentThread().getId() + "");
    }
}
