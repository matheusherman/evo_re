package io.netty.util.internal.shaded.org.jctools.queues;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class IndexedQueueSizeUtil {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface IndexedQueue {
        int capacity();

        long lvConsumerIndex();

        long lvProducerIndex();
    }

    public static boolean isEmpty(IndexedQueue indexedQueue) {
        if (indexedQueue.lvConsumerIndex() >= indexedQueue.lvProducerIndex()) {
            return true;
        }
        return false;
    }

    public static int size(IndexedQueue indexedQueue) {
        long jLvProducerIndex;
        long jLvConsumerIndex;
        long jLvConsumerIndex2 = indexedQueue.lvConsumerIndex();
        while (true) {
            jLvProducerIndex = indexedQueue.lvProducerIndex();
            jLvConsumerIndex = indexedQueue.lvConsumerIndex();
            if (jLvConsumerIndex2 == jLvConsumerIndex) {
                break;
            }
            jLvConsumerIndex2 = jLvConsumerIndex;
        }
        long j10 = jLvProducerIndex - jLvConsumerIndex;
        if (j10 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j10 < 0) {
            return 0;
        }
        if (indexedQueue.capacity() != -1 && j10 > indexedQueue.capacity()) {
            return indexedQueue.capacity();
        }
        return (int) j10;
    }
}
