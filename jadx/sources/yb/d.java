package yb;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f22560a = Character.toString('.');

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char f22561b = File.separatorChar;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char f22562c;

    public static int e(String str) {
        int iLastIndexOf;
        if (str != null && f(str) <= (iLastIndexOf = str.lastIndexOf(46))) {
            return iLastIndexOf;
        }
        return -1;
    }

    static {
        if (g()) {
            f22562c = '/';
        } else {
            f22562c = '\\';
        }
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        int iE = e(str);
        return iE == -1 ? "" : str.substring(iE + 1);
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        a(str);
        return str.substring(f(str) + 1);
    }

    public static int f(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    static boolean g() {
        return f22561b == '\\';
    }

    public static String h(String str) {
        if (str == null) {
            return null;
        }
        a(str);
        int iE = e(str);
        return iE == -1 ? str : str.substring(0, iE);
    }

    private static void a(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (str.charAt(i10) == 0) {
                throw new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
            }
        }
    }

    public static String b(String str) {
        return h(d(str));
    }
}
