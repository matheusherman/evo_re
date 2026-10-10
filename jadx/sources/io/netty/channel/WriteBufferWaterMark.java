package io.netty.channel;

import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class WriteBufferWaterMark {
    public static final WriteBufferWaterMark DEFAULT = new WriteBufferWaterMark(32768, 65536, false);
    private final int high;
    private final int low;

    public int high() {
        return this.high;
    }

    public int low() {
        return this.low;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("WriteBufferWaterMark(low: ");
        sb2.append(this.low);
        sb2.append(", high: ");
        sb2.append(this.high);
        sb2.append(")");
        return sb2.toString();
    }

    WriteBufferWaterMark(int i10, int i11, boolean z10) {
        if (z10) {
            ObjectUtil.checkPositiveOrZero(i10, "low");
            if (i11 < i10) {
                throw new IllegalArgumentException("write buffer's high water mark cannot be less than  low water mark (" + i10 + "): " + i11);
            }
        }
        this.low = i10;
        this.high = i11;
    }
}
