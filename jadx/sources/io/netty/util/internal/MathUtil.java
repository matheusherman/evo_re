package io.netty.util.internal;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class MathUtil {
    public static int findNextPositivePowerOfTwo(int i10) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i10 - 1));
    }

    public static boolean isOutOfBounds(int i10, int i11, int i12) {
        int i13 = i10 | i11 | i12;
        int i14 = i10 + i11;
        return ((i13 | i14) | (i12 - i14)) < 0;
    }

    public static int safeFindNextPositivePowerOfTwo(int i10) {
        if (i10 <= 0) {
            return 1;
        }
        return i10 >= 1073741824 ? BasicMeasure.EXACTLY : findNextPositivePowerOfTwo(i10);
    }
}
