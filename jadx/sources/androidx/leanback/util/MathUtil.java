package androidx.leanback.util;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class MathUtil {
    public static int safeLongToInt(long j10) {
        int i10 = (int) j10;
        if (i10 == j10) {
            return i10;
        }
        throw new ArithmeticException("Input overflows int.\n");
    }

    private MathUtil() {
    }
}
