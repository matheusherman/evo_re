package io.netty.util.internal.shaded.org.jctools.queues;

import androidx.core.location.LocationRequestCompat;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class BaseMpscLinkedArrayQueue<E> extends BaseMpscLinkedArrayQueueColdProducerFields<E> implements MessagePassingQueue<E> {
    private static final Object JUMP = new Object();
    private static final Object BUFFER_CONSUMED = new Object();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class WeakIterator<E> implements Iterator<E> {
        private E[] currentBuffer;
        private int mask;
        private E nextElement;
        private long nextIndex;
        private final long pIndex;

        /* JADX WARN: Multi-variable type inference failed */
        private E getNext() {
            while (true) {
                long j10 = this.nextIndex;
                if (j10 >= this.pIndex) {
                    break;
                }
                this.nextIndex = 1 + j10;
                E e10 = (E) UnsafeRefArrayAccess.lvRefElement(this.currentBuffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(j10, this.mask));
                if (e10 != null) {
                    if (e10 != BaseMpscLinkedArrayQueue.JUMP) {
                        return e10;
                    }
                    Object objLvRefElement = UnsafeRefArrayAccess.lvRefElement(this.currentBuffer, UnsafeRefArrayAccess.calcRefElementOffset(this.mask + 1));
                    if (objLvRefElement == BaseMpscLinkedArrayQueue.BUFFER_CONSUMED || objLvRefElement == null) {
                        break;
                    }
                    setBuffer((Object[]) objLvRefElement);
                    E e11 = (E) UnsafeRefArrayAccess.lvRefElement(this.currentBuffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(j10, this.mask));
                    if (e11 != null) {
                        return e11;
                    }
                }
            }
            return null;
        }

        private void setBuffer(E[] eArr) {
            this.currentBuffer = eArr;
            this.mask = LinkedArrayQueueUtil.length(eArr) - 2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextElement != null;
        }

        @Override // java.util.Iterator
        public E next() {
            E e10 = this.nextElement;
            if (e10 == null) {
                throw new NoSuchElementException();
            }
            this.nextElement = getNext();
            return e10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        WeakIterator(E[] eArr, long j10, long j11) {
            this.pIndex = j11 >> 1;
            this.nextIndex = j10 >> 1;
            setBuffer(eArr);
            this.nextElement = getNext();
        }
    }

    protected abstract long availableInQueue(long j10, long j11);

    protected abstract long getCurrentBufferCapacity(long j10);

    protected abstract int getNextBufferSize(E[] eArr);

    private E newBufferPeek(E[] eArr, long j10) {
        E e10 = (E) UnsafeRefArrayAccess.lvRefElement(eArr, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(j10, this.consumerMask));
        if (e10 != null) {
            return e10;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private E newBufferPoll(E[] eArr, long j10) {
        long jModifiedCalcCircularRefElementOffset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(j10, this.consumerMask);
        E e10 = (E) UnsafeRefArrayAccess.lvRefElement(eArr, jModifiedCalcCircularRefElementOffset);
        if (e10 == null) {
            throw new IllegalStateException("new buffer must have at least one element");
        }
        UnsafeRefArrayAccess.soRefElement(eArr, jModifiedCalcCircularRefElementOffset, null);
        soConsumerIndex(j10 + 2);
        return e10;
    }

    private static long nextArrayOffset(long j10) {
        return LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(j10 + 2, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new WeakIterator(this.consumerBuffer, lvConsumerIndex(), lvProducerIndex());
    }

    @Override // java.util.Queue
    public boolean offer(E e10) {
        if (e10 == null) {
            throw null;
        }
        while (true) {
            long jLvProducerLimit = lvProducerLimit();
            long jLvProducerIndex = lvProducerIndex();
            if ((jLvProducerIndex & 1) != 1) {
                long j10 = this.producerMask;
                E[] eArr = this.producerBuffer;
                if (jLvProducerLimit <= jLvProducerIndex) {
                    int iOfferSlowPath = offerSlowPath(j10, jLvProducerIndex, jLvProducerLimit);
                    if (iOfferSlowPath == 1) {
                        continue;
                    } else {
                        if (iOfferSlowPath == 2) {
                            return false;
                        }
                        if (iOfferSlowPath == 3) {
                            resize(j10, eArr, jLvProducerIndex, e10, null);
                            return true;
                        }
                    }
                }
                if (casProducerIndex(jLvProducerIndex, 2 + jLvProducerIndex)) {
                    UnsafeRefArrayAccess.soRefElement(eArr, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(jLvProducerIndex, j10), e10);
                    return true;
                }
            }
        }
    }

    @Override // java.util.Queue
    public E peek() {
        E[] eArr = this.consumerBuffer;
        long jLpConsumerIndex = lpConsumerIndex();
        long j10 = this.consumerMask;
        long jModifiedCalcCircularRefElementOffset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(jLpConsumerIndex, j10);
        E e10 = (E) UnsafeRefArrayAccess.lvRefElement(eArr, jModifiedCalcCircularRefElementOffset);
        if (e10 == null && jLpConsumerIndex != lvProducerIndex()) {
            do {
                e10 = (E) UnsafeRefArrayAccess.lvRefElement(eArr, jModifiedCalcCircularRefElementOffset);
            } while (e10 == null);
        }
        return e10 == JUMP ? newBufferPeek(nextBuffer(eArr, j10), jLpConsumerIndex) : e10;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E poll() {
        E[] eArr = this.consumerBuffer;
        long jLpConsumerIndex = lpConsumerIndex();
        long j10 = this.consumerMask;
        long jModifiedCalcCircularRefElementOffset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(jLpConsumerIndex, j10);
        E e10 = (E) UnsafeRefArrayAccess.lvRefElement(eArr, jModifiedCalcCircularRefElementOffset);
        if (e10 == null) {
            if (jLpConsumerIndex == lvProducerIndex()) {
                return null;
            }
            do {
                e10 = (E) UnsafeRefArrayAccess.lvRefElement(eArr, jModifiedCalcCircularRefElementOffset);
            } while (e10 == null);
        }
        if (e10 == JUMP) {
            return newBufferPoll(nextBuffer(eArr, j10), jLpConsumerIndex);
        }
        UnsafeRefArrayAccess.soRefElement(eArr, jModifiedCalcCircularRefElementOffset, null);
        soConsumerIndex(jLpConsumerIndex + 2);
        return e10;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        E[] eArr = this.consumerBuffer;
        long jLpConsumerIndex = lpConsumerIndex();
        long j10 = this.consumerMask;
        long jModifiedCalcCircularRefElementOffset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(jLpConsumerIndex, j10);
        E e10 = (E) UnsafeRefArrayAccess.lvRefElement(eArr, jModifiedCalcCircularRefElementOffset);
        if (e10 == null) {
            return null;
        }
        if (e10 == JUMP) {
            return newBufferPoll(nextBuffer(eArr, j10), jLpConsumerIndex);
        }
        UnsafeRefArrayAccess.soRefElement(eArr, jModifiedCalcCircularRefElementOffset, null);
        soConsumerIndex(jLpConsumerIndex + 2);
        return e10;
    }

    public BaseMpscLinkedArrayQueue(int i10) {
        RangeUtil.checkGreaterThanOrEqual(i10, 2, "initialCapacity");
        int iRoundToPowerOfTwo = Pow2.roundToPowerOfTwo(i10);
        long j10 = (iRoundToPowerOfTwo - 1) << 1;
        E[] eArr = (E[]) UnsafeRefArrayAccess.allocateRefArray(iRoundToPowerOfTwo + 1);
        this.producerBuffer = eArr;
        this.producerMask = j10;
        this.consumerBuffer = eArr;
        this.consumerMask = j10;
        soProducerLimit(j10);
    }

    private E[] nextBuffer(E[] eArr, long j10) {
        long jNextArrayOffset = nextArrayOffset(j10);
        E[] eArr2 = (E[]) ((Object[]) UnsafeRefArrayAccess.lvRefElement(eArr, jNextArrayOffset));
        this.consumerBuffer = eArr2;
        this.consumerMask = (LinkedArrayQueueUtil.length(eArr2) - 2) << 1;
        UnsafeRefArrayAccess.soRefElement(eArr, jNextArrayOffset, BUFFER_CONSUMED);
        return eArr2;
    }

    private int offerSlowPath(long j10, long j11, long j12) {
        long jLvConsumerIndex = lvConsumerIndex();
        long currentBufferCapacity = getCurrentBufferCapacity(j10) + jLvConsumerIndex;
        if (currentBufferCapacity > j11) {
            if (!casProducerLimit(j12, currentBufferCapacity)) {
                return 1;
            }
            return 0;
        }
        if (availableInQueue(j11, jLvConsumerIndex) <= 0) {
            return 2;
        }
        if (!casProducerIndex(j11, 1 + j11)) {
            return 1;
        }
        return 3;
    }

    private void resize(long j10, E[] eArr, long j11, E e10, MessagePassingQueue.Supplier<E> supplier) {
        int nextBufferSize = getNextBufferSize(eArr);
        try {
            E[] eArr2 = (E[]) UnsafeRefArrayAccess.allocateRefArray(nextBufferSize);
            this.producerBuffer = eArr2;
            long j12 = (nextBufferSize - 2) << 1;
            this.producerMask = j12;
            long jModifiedCalcCircularRefElementOffset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(j11, j10);
            long jModifiedCalcCircularRefElementOffset2 = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(j11, j12);
            if (e10 == null) {
                e10 = supplier.get();
            }
            UnsafeRefArrayAccess.soRefElement(eArr2, jModifiedCalcCircularRefElementOffset2, e10);
            UnsafeRefArrayAccess.soRefElement(eArr, nextArrayOffset(j10), eArr2);
            long jAvailableInQueue = availableInQueue(j11, lvConsumerIndex());
            RangeUtil.checkPositive(jAvailableInQueue, "availableInQueue");
            soProducerLimit(Math.min(j12, jAvailableInQueue) + j11);
            soProducerIndex(j11 + 2);
            UnsafeRefArrayAccess.soRefElement(eArr, jModifiedCalcCircularRefElementOffset, JUMP);
        } catch (OutOfMemoryError e11) {
            soProducerIndex(j11);
            throw e11;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        if (lvConsumerIndex() == lvProducerIndex()) {
            return true;
        }
        return false;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e10) {
        return offer(e10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long jLvProducerIndex;
        long jLvConsumerIndex;
        long jLvConsumerIndex2 = lvConsumerIndex();
        while (true) {
            jLvProducerIndex = lvProducerIndex();
            jLvConsumerIndex = lvConsumerIndex();
            if (jLvConsumerIndex2 == jLvConsumerIndex) {
                break;
            }
            jLvConsumerIndex2 = jLvConsumerIndex;
        }
        long j10 = (jLvProducerIndex - jLvConsumerIndex) >> 1;
        if (j10 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j10;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return getClass().getName();
    }
}
