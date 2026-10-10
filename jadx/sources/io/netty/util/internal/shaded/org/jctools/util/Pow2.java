package io.netty.util.internal.shaded.org.jctools.util;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class Pow2 {
    public static boolean isPowerOfTwo(int i10) {
        return (i10 & (i10 + (-1))) == 0;
    }

    public static int roundToPowerOfTwo(int i10) {
        if (i10 > 1073741824) {
            throw new IllegalArgumentException("There is no larger power of 2 int for value:" + i10 + " since it exceeds 2^31.");
        }
        if (i10 >= 0) {
            return 1 << (32 - Integer.numberOfLeadingZeros(i10 - 1));
        }
        throw new IllegalArgumentException("Given value:" + i10 + ". Expecting value >= 0.");
    }

    public static long align(long j10, int i10) {
        if (isPowerOfTwo(i10)) {
            int i11 = i10 - 1;
            return (j10 + ((long) i11)) & ((long) (~i11));
        }
        throw new IllegalArgumentException("alignment must be a power of 2:" + i10);
    }
}
