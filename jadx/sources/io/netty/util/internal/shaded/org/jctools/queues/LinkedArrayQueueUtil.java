package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class LinkedArrayQueueUtil {
    static int length(Object[] objArr) {
        return objArr.length;
    }

    static long modifiedCalcCircularRefElementOffset(long j10, long j11) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((j10 & j11) << (UnsafeRefArrayAccess.REF_ELEMENT_SHIFT - 1));
    }
}
