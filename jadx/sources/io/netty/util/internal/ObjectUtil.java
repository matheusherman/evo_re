package io.netty.util.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class ObjectUtil {
    public static char[] checkNonEmpty(char[] cArr, String str) {
        if (((char[]) checkNotNull(cArr, str)).length != 0) {
            return cArr;
        }
        throw new IllegalArgumentException("Param '" + str + "' must not be empty");
    }

    public static int checkPositive(int i10, String str) {
        if (i10 > 0) {
            return i10;
        }
        throw new IllegalArgumentException(str + " : " + i10 + " (expected: > 0)");
    }

    public static int checkPositiveOrZero(int i10, String str) {
        if (i10 >= 0) {
            return i10;
        }
        throw new IllegalArgumentException(str + " : " + i10 + " (expected: >= 0)");
    }

    public static int checkInRange(int i10, int i11, int i12, String str) {
        if (i10 >= i11 && i10 <= i12) {
            return i10;
        }
        throw new IllegalArgumentException(str + ": " + i10 + " (expected: " + i11 + "-" + i12 + ")");
    }

    public static <T> T checkNotNull(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }

    public static long checkPositive(long j10, String str) {
        if (j10 > 0) {
            return j10;
        }
        throw new IllegalArgumentException(str + " : " + j10 + " (expected: > 0)");
    }

    public static long checkPositiveOrZero(long j10, String str) {
        if (j10 >= 0) {
            return j10;
        }
        throw new IllegalArgumentException(str + " : " + j10 + " (expected: >= 0)");
    }

    public static String checkNonEmpty(String str, String str2) {
        if (!((String) checkNotNull(str, str2)).isEmpty()) {
            return str;
        }
        throw new IllegalArgumentException("Param '" + str2 + "' must not be empty");
    }

    public static String checkNonEmptyAfterTrim(String str, String str2) {
        return checkNonEmpty(((String) checkNotNull(str, str2)).trim(), str2);
    }

    public static double checkPositive(double d10, String str) {
        if (d10 > 0.0d) {
            return d10;
        }
        throw new IllegalArgumentException(str + " : " + d10 + " (expected: > 0)");
    }
}
