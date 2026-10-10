package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class AtomicQueueUtil {
    static int calcCircularRefElementOffset(long j10, long j11) {
        return (int) (j10 & j11);
    }

    static int calcRefElementOffset(long j10) {
        return (int) j10;
    }

    static int modifiedCalcCircularRefElementOffset(long j10, long j11) {
        return ((int) (j10 & j11)) >> 1;
    }

    static <E> AtomicReferenceArray<E> allocateRefArray(int i10) {
        return new AtomicReferenceArray<>(i10);
    }

    static int length(AtomicReferenceArray<?> atomicReferenceArray) {
        return atomicReferenceArray.length();
    }

    static <E> E lvRefElement(AtomicReferenceArray<E> atomicReferenceArray, int i10) {
        return atomicReferenceArray.get(i10);
    }

    static void soRefElement(AtomicReferenceArray atomicReferenceArray, int i10, Object obj) {
        atomicReferenceArray.lazySet(i10, obj);
    }

    static <E> void spRefElement(AtomicReferenceArray<E> atomicReferenceArray, int i10, E e10) {
        atomicReferenceArray.lazySet(i10, e10);
    }
}
