package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import androidx.core.location.LocationRequestCompat;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class BaseMpscLinkedAtomicArrayQueue<E> extends BaseMpscLinkedAtomicArrayQueueColdProducerFields<E> implements MessagePassingQueue<E> {
    private static final Object JUMP = new Object();
    private static final Object BUFFER_CONSUMED = new Object();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class WeakIterator<E> implements Iterator<E> {
        private AtomicReferenceArray<E> currentBuffer;
        private int mask;
        private E nextElement;
        private long nextIndex;
        private final long pIndex;

        private E getNext() {
            while (true) {
                long j10 = this.nextIndex;
                if (j10 >= this.pIndex) {
                    break;
                }
                this.nextIndex = 1 + j10;
                E e10 = (E) AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcCircularRefElementOffset(j10, this.mask));
                if (e10 != null) {
                    if (e10 != BaseMpscLinkedAtomicArrayQueue.JUMP) {
                        return e10;
                    }
                    Object objLvRefElement = AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcRefElementOffset(this.mask + 1));
                    if (objLvRefElement == BaseMpscLinkedAtomicArrayQueue.BUFFER_CONSUMED || objLvRefElement == null) {
                        break;
                    }
                    setBuffer((AtomicReferenceArray) objLvRefElement);
                    E e11 = (E) AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcCircularRefElementOffset(j10, this.mask));
                    if (e11 != null) {
                        return e11;
                    }
                }
            }
            return null;
        }

        private void setBuffer(AtomicReferenceArray<E> atomicReferenceArray) {
            this.currentBuffer = atomicReferenceArray;
            this.mask = AtomicQueueUtil.length(atomicReferenceArray) - 2;
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

        WeakIterator(AtomicReferenceArray<E> atomicReferenceArray, long j10, long j11) {
            this.pIndex = j11 >> 1;
            this.nextIndex = j10 >> 1;
            setBuffer(atomicReferenceArray);
            this.nextElement = getNext();
        }
    }

    protected abstract long availableInQueue(long j10, long j11);

    protected abstract long getCurrentBufferCapacity(long j10);

    protected abstract int getNextBufferSize(AtomicReferenceArray<E> atomicReferenceArray);

    private E newBufferPeek(AtomicReferenceArray<E> atomicReferenceArray, long j10) {
        E e10 = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(j10, this.consumerMask));
        if (e10 != null) {
            return e10;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private E newBufferPoll(AtomicReferenceArray<E> atomicReferenceArray, long j10) {
        int iModifiedCalcCircularRefElementOffset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(j10, this.consumerMask);
        E e10 = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, iModifiedCalcCircularRefElementOffset);
        if (e10 == null) {
            throw new IllegalStateException("new buffer must have at least one element");
        }
        AtomicQueueUtil.soRefElement(atomicReferenceArray, iModifiedCalcCircularRefElementOffset, null);
        soConsumerIndex(j10 + 2);
        return e10;
    }

    private static int nextArrayOffset(long j10) {
        return AtomicQueueUtil.modifiedCalcCircularRefElementOffset(j10 + 2, LocationRequestCompat.PASSIVE_INTERVAL);
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
                AtomicReferenceArray<E> atomicReferenceArray = this.producerBuffer;
                if (jLvProducerLimit <= jLvProducerIndex) {
                    int iOfferSlowPath = offerSlowPath(j10, jLvProducerIndex, jLvProducerLimit);
                    if (iOfferSlowPath == 1) {
                        continue;
                    } else {
                        if (iOfferSlowPath == 2) {
                            return false;
                        }
                        if (iOfferSlowPath == 3) {
                            resize(j10, atomicReferenceArray, jLvProducerIndex, e10, null);
                            return true;
                        }
                    }
                }
                if (casProducerIndex(jLvProducerIndex, 2 + jLvProducerIndex)) {
                    AtomicQueueUtil.soRefElement(atomicReferenceArray, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(jLvProducerIndex, j10), e10);
                    return true;
                }
            }
        }
    }

    @Override // java.util.Queue
    public E peek() {
        AtomicReferenceArray<E> atomicReferenceArray = this.consumerBuffer;
        long jLpConsumerIndex = lpConsumerIndex();
        long j10 = this.consumerMask;
        int iModifiedCalcCircularRefElementOffset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(jLpConsumerIndex, j10);
        E e10 = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, iModifiedCalcCircularRefElementOffset);
        if (e10 == null && jLpConsumerIndex != lvProducerIndex()) {
            do {
                e10 = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, iModifiedCalcCircularRefElementOffset);
            } while (e10 == null);
        }
        return e10 == JUMP ? newBufferPeek(nextBuffer(atomicReferenceArray, j10), jLpConsumerIndex) : e10;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E poll() {
        AtomicReferenceArray<E> atomicReferenceArray = this.consumerBuffer;
        long jLpConsumerIndex = lpConsumerIndex();
        long j10 = this.consumerMask;
        int iModifiedCalcCircularRefElementOffset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(jLpConsumerIndex, j10);
        E e10 = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, iModifiedCalcCircularRefElementOffset);
        if (e10 == null) {
            if (jLpConsumerIndex == lvProducerIndex()) {
                return null;
            }
            do {
                e10 = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, iModifiedCalcCircularRefElementOffset);
            } while (e10 == null);
        }
        if (e10 == JUMP) {
            return newBufferPoll(nextBuffer(atomicReferenceArray, j10), jLpConsumerIndex);
        }
        AtomicQueueUtil.soRefElement(atomicReferenceArray, iModifiedCalcCircularRefElementOffset, null);
        soConsumerIndex(jLpConsumerIndex + 2);
        return e10;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        AtomicReferenceArray<E> atomicReferenceArray = this.consumerBuffer;
        long jLpConsumerIndex = lpConsumerIndex();
        long j10 = this.consumerMask;
        int iModifiedCalcCircularRefElementOffset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(jLpConsumerIndex, j10);
        E e10 = (E) AtomicQueueUtil.lvRefElement(atomicReferenceArray, iModifiedCalcCircularRefElementOffset);
        if (e10 == null) {
            return null;
        }
        if (e10 == JUMP) {
            return newBufferPoll(nextBuffer(atomicReferenceArray, j10), jLpConsumerIndex);
        }
        AtomicQueueUtil.soRefElement(atomicReferenceArray, iModifiedCalcCircularRefElementOffset, null);
        soConsumerIndex(jLpConsumerIndex + 2);
        return e10;
    }

    public BaseMpscLinkedAtomicArrayQueue(int i10) {
        RangeUtil.checkGreaterThanOrEqual(i10, 2, "initialCapacity");
        int iRoundToPowerOfTwo = Pow2.roundToPowerOfTwo(i10);
        long j10 = (iRoundToPowerOfTwo - 1) << 1;
        AtomicReferenceArray<E> atomicReferenceArrayAllocateRefArray = AtomicQueueUtil.allocateRefArray(iRoundToPowerOfTwo + 1);
        this.producerBuffer = atomicReferenceArrayAllocateRefArray;
        this.producerMask = j10;
        this.consumerBuffer = atomicReferenceArrayAllocateRefArray;
        this.consumerMask = j10;
        soProducerLimit(j10);
    }

    private AtomicReferenceArray<E> nextBuffer(AtomicReferenceArray<E> atomicReferenceArray, long j10) {
        int iNextArrayOffset = nextArrayOffset(j10);
        AtomicReferenceArray<E> atomicReferenceArray2 = (AtomicReferenceArray) AtomicQueueUtil.lvRefElement(atomicReferenceArray, iNextArrayOffset);
        this.consumerBuffer = atomicReferenceArray2;
        this.consumerMask = (AtomicQueueUtil.length(atomicReferenceArray2) - 2) << 1;
        AtomicQueueUtil.soRefElement(atomicReferenceArray, iNextArrayOffset, BUFFER_CONSUMED);
        return atomicReferenceArray2;
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

    private void resize(long j10, AtomicReferenceArray<E> atomicReferenceArray, long j11, E e10, MessagePassingQueue.Supplier<E> supplier) {
        int nextBufferSize = getNextBufferSize(atomicReferenceArray);
        try {
            AtomicReferenceArray<E> atomicReferenceArrayAllocateRefArray = AtomicQueueUtil.allocateRefArray(nextBufferSize);
            this.producerBuffer = atomicReferenceArrayAllocateRefArray;
            long j12 = (nextBufferSize - 2) << 1;
            this.producerMask = j12;
            int iModifiedCalcCircularRefElementOffset = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(j11, j10);
            int iModifiedCalcCircularRefElementOffset2 = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(j11, j12);
            if (e10 == null) {
                e10 = supplier.get();
            }
            AtomicQueueUtil.soRefElement(atomicReferenceArrayAllocateRefArray, iModifiedCalcCircularRefElementOffset2, e10);
            AtomicQueueUtil.soRefElement(atomicReferenceArray, nextArrayOffset(j10), atomicReferenceArrayAllocateRefArray);
            long jAvailableInQueue = availableInQueue(j11, lvConsumerIndex());
            RangeUtil.checkPositive(jAvailableInQueue, "availableInQueue");
            soProducerLimit(Math.min(j12, jAvailableInQueue) + j11);
            soProducerIndex(j11 + 2);
            AtomicQueueUtil.soRefElement(atomicReferenceArray, iModifiedCalcCircularRefElementOffset, JUMP);
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
