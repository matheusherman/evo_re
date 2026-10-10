package io.netty.buffer;

import io.netty.util.internal.LongCounter;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class PoolArena<T> extends SizeClasses {
    static final boolean HAS_UNSAFE = PlatformDependent.hasUnsafe();
    private final LongCounter activeBytesHuge;
    private final LongCounter allocationsHuge;
    private long allocationsNormal;
    private final LongCounter allocationsSmall;
    private final List<PoolChunkListMetric> chunkListMetrics;
    private final LongCounter deallocationsHuge;
    private long deallocationsNormal;
    private long deallocationsSmall;
    final int directMemoryCacheAlignment;
    private final ReentrantLock lock;
    final int numSmallSubpagePools;
    final AtomicInteger numThreadCaches;
    final PooledByteBufAllocator parent;
    private final PoolChunkList<T> q000;
    private final PoolChunkList<T> q025;
    private final PoolChunkList<T> q050;
    private final PoolChunkList<T> q075;
    private final PoolChunkList<T> q100;
    private final PoolChunkList<T> qInit;
    private final PoolSubpage<T>[] smallSubpagePools;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class DirectArena extends PoolArena<ByteBuffer> {
        @Override // io.netty.buffer.PoolArena
        boolean isDirect() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.buffer.PoolArena
        public void memoryCopy(ByteBuffer byteBuffer, int i10, PooledByteBuf<ByteBuffer> pooledByteBuf, int i11) {
            if (i11 == 0) {
                return;
            }
            if (PoolArena.HAS_UNSAFE) {
                PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(byteBuffer) + ((long) i10), PlatformDependent.directBufferAddress(pooledByteBuf.memory) + ((long) pooledByteBuf.offset), i11);
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            ByteBuffer byteBufferInternalNioBuffer = pooledByteBuf.internalNioBuffer();
            byteBufferDuplicate.position(i10).limit(i10 + i11);
            byteBufferInternalNioBuffer.position(pooledByteBuf.offset);
            byteBufferInternalNioBuffer.put(byteBufferDuplicate);
        }

        @Override // io.netty.buffer.PoolArena
        protected PooledByteBuf<ByteBuffer> newByteBuf(int i10) {
            return PoolArena.HAS_UNSAFE ? PooledUnsafeDirectByteBuf.newInstance(i10) : PooledDirectByteBuf.newInstance(i10);
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<ByteBuffer> newChunk(int i10, int i11, int i12, int i13) {
            int i14 = ((PoolArena) this).directMemoryCacheAlignment;
            if (i14 == 0) {
                ByteBuffer byteBufferAllocateDirect = allocateDirect(i13);
                return new PoolChunk<>(this, byteBufferAllocateDirect, byteBufferAllocateDirect, i10, i12, i13, i11);
            }
            ByteBuffer byteBufferAllocateDirect2 = allocateDirect(i14 + i13);
            return new PoolChunk<>(this, byteBufferAllocateDirect2, PlatformDependent.alignDirectBuffer(byteBufferAllocateDirect2, ((PoolArena) this).directMemoryCacheAlignment), i10, i12, i13, i11);
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<ByteBuffer> newUnpooledChunk(int i10) {
            int i11 = ((PoolArena) this).directMemoryCacheAlignment;
            if (i11 == 0) {
                ByteBuffer byteBufferAllocateDirect = allocateDirect(i10);
                return new PoolChunk<>(this, byteBufferAllocateDirect, byteBufferAllocateDirect, i10);
            }
            ByteBuffer byteBufferAllocateDirect2 = allocateDirect(i11 + i10);
            return new PoolChunk<>(this, byteBufferAllocateDirect2, PlatformDependent.alignDirectBuffer(byteBufferAllocateDirect2, ((PoolArena) this).directMemoryCacheAlignment), i10);
        }

        DirectArena(PooledByteBufAllocator pooledByteBufAllocator, int i10, int i11, int i12, int i13) {
            super(pooledByteBufAllocator, i10, i11, i12, i13);
        }

        private static ByteBuffer allocateDirect(int i10) {
            if (PlatformDependent.useDirectBufferNoCleaner()) {
                return PlatformDependent.allocateDirectNoCleaner(i10);
            }
            return ByteBuffer.allocateDirect(i10);
        }

        @Override // io.netty.buffer.PoolArena
        protected void destroyChunk(PoolChunk<ByteBuffer> poolChunk) {
            if (PlatformDependent.useDirectBufferNoCleaner()) {
                PlatformDependent.freeDirectNoCleaner((ByteBuffer) poolChunk.base);
            } else {
                PlatformDependent.freeDirectBuffer((ByteBuffer) poolChunk.base);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class HeapArena extends PoolArena<byte[]> {
        HeapArena(PooledByteBufAllocator pooledByteBufAllocator, int i10, int i11, int i12) {
            super(pooledByteBufAllocator, i10, i11, i12, 0);
        }

        @Override // io.netty.buffer.PoolArena
        boolean isDirect() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.buffer.PoolArena
        public void memoryCopy(byte[] bArr, int i10, PooledByteBuf<byte[]> pooledByteBuf, int i11) {
            if (i11 == 0) {
                return;
            }
            System.arraycopy(bArr, i10, pooledByteBuf.memory, pooledByteBuf.offset, i11);
        }

        @Override // io.netty.buffer.PoolArena
        protected PooledByteBuf<byte[]> newByteBuf(int i10) {
            return PoolArena.HAS_UNSAFE ? PooledUnsafeHeapByteBuf.newUnsafeInstance(i10) : PooledHeapByteBuf.newInstance(i10);
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<byte[]> newChunk(int i10, int i11, int i12, int i13) {
            return new PoolChunk<>(this, null, newByteArray(i13), i10, i12, i13, i11);
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<byte[]> newUnpooledChunk(int i10) {
            return new PoolChunk<>(this, null, newByteArray(i10), i10);
        }

        private static byte[] newByteArray(int i10) {
            return PlatformDependent.allocateUninitializedArray(i10);
        }

        @Override // io.netty.buffer.PoolArena
        protected void destroyChunk(PoolChunk<byte[]> poolChunk) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    enum SizeClass {
        Small,
        Normal
    }

    private static void appendPoolSubPages(StringBuilder sb2, PoolSubpage<?>[] poolSubpageArr) {
        for (int i10 = 0; i10 < poolSubpageArr.length; i10++) {
            PoolSubpage<?> poolSubpage = poolSubpageArr[i10];
            if (poolSubpage.next != poolSubpage) {
                sb2.append(StringUtil.NEWLINE);
                sb2.append(i10);
                sb2.append(": ");
                PoolSubpage poolSubpage2 = poolSubpage.next;
                do {
                    sb2.append(poolSubpage2);
                    poolSubpage2 = poolSubpage2.next;
                } while (poolSubpage2 != poolSubpage);
            }
        }
    }

    private void destroyPoolChunkLists(PoolChunkList<T>... poolChunkListArr) {
        for (PoolChunkList<T> poolChunkList : poolChunkListArr) {
            poolChunkList.destroy(this);
        }
    }

    private static void destroyPoolSubPages(PoolSubpage<?>[] poolSubpageArr) {
        for (PoolSubpage<?> poolSubpage : poolSubpageArr) {
            poolSubpage.destroy();
        }
    }

    PooledByteBuf<T> allocate(PoolThreadCache poolThreadCache, int i10, int i11) {
        PooledByteBuf<T> pooledByteBufNewByteBuf = newByteBuf(i11);
        allocate(poolThreadCache, pooledByteBufNewByteBuf, i10);
        return pooledByteBufNewByteBuf;
    }

    protected abstract void destroyChunk(PoolChunk<T> poolChunk);

    protected final void finalize() {
        try {
            super.finalize();
            destroyPoolSubPages(this.smallSubpagePools);
            destroyPoolChunkLists(this.qInit, this.q000, this.q025, this.q050, this.q075, this.q100);
        } catch (Throwable th) {
            destroyPoolSubPages(this.smallSubpagePools);
            destroyPoolChunkLists(this.qInit, this.q000, this.q025, this.q050, this.q075, this.q100);
            throw th;
        }
    }

    abstract boolean isDirect();

    protected abstract void memoryCopy(T t10, int i10, PooledByteBuf<T> pooledByteBuf, int i11);

    protected abstract PooledByteBuf<T> newByteBuf(int i10);

    protected abstract PoolChunk<T> newChunk(int i10, int i11, int i12, int i13);

    protected abstract PoolChunk<T> newUnpooledChunk(int i10);

    /* JADX INFO: renamed from: io.netty.buffer.PoolArena$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$buffer$PoolArena$SizeClass;

        static {
            int[] iArr = new int[SizeClass.values().length];
            $SwitchMap$io$netty$buffer$PoolArena$SizeClass = iArr;
            try {
                iArr[SizeClass.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[SizeClass.Small.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    protected PoolArena(PooledByteBufAllocator pooledByteBufAllocator, int i10, int i11, int i12, int i13) {
        super(i10, i11, i12, i13);
        this.allocationsSmall = PlatformDependent.newLongCounter();
        this.allocationsHuge = PlatformDependent.newLongCounter();
        this.activeBytesHuge = PlatformDependent.newLongCounter();
        this.deallocationsHuge = PlatformDependent.newLongCounter();
        this.numThreadCaches = new AtomicInteger();
        this.lock = new ReentrantLock();
        this.parent = pooledByteBufAllocator;
        this.directMemoryCacheAlignment = i13;
        int i14 = this.nSubpages;
        this.numSmallSubpagePools = i14;
        this.smallSubpagePools = newSubpagePoolArray(i14);
        int i15 = 0;
        while (true) {
            PoolSubpage<T>[] poolSubpageArr = this.smallSubpagePools;
            if (i15 >= poolSubpageArr.length) {
                PoolChunkList<T> poolChunkList = new PoolChunkList<>(this, null, 100, Integer.MAX_VALUE, i12);
                this.q100 = poolChunkList;
                PoolChunkList<T> poolChunkList2 = new PoolChunkList<>(this, poolChunkList, 75, 100, i12);
                this.q075 = poolChunkList2;
                PoolChunkList<T> poolChunkList3 = new PoolChunkList<>(this, poolChunkList2, 50, 100, i12);
                this.q050 = poolChunkList3;
                PoolChunkList<T> poolChunkList4 = new PoolChunkList<>(this, poolChunkList3, 25, 75, i12);
                this.q025 = poolChunkList4;
                PoolChunkList<T> poolChunkList5 = new PoolChunkList<>(this, poolChunkList4, 1, 50, i12);
                this.q000 = poolChunkList5;
                PoolChunkList<T> poolChunkList6 = new PoolChunkList<>(this, poolChunkList5, Integer.MIN_VALUE, 25, i12);
                this.qInit = poolChunkList6;
                poolChunkList.prevList(poolChunkList2);
                poolChunkList2.prevList(poolChunkList3);
                poolChunkList3.prevList(poolChunkList4);
                poolChunkList4.prevList(poolChunkList5);
                poolChunkList5.prevList(null);
                poolChunkList6.prevList(poolChunkList6);
                ArrayList arrayList = new ArrayList(6);
                arrayList.add(poolChunkList6);
                arrayList.add(poolChunkList5);
                arrayList.add(poolChunkList4);
                arrayList.add(poolChunkList3);
                arrayList.add(poolChunkList2);
                arrayList.add(poolChunkList);
                this.chunkListMetrics = Collections.unmodifiableList(arrayList);
                return;
            }
            poolSubpageArr[i15] = newSubpagePoolHead();
            i15++;
        }
    }

    private void allocateNormal(PooledByteBuf<T> pooledByteBuf, int i10, int i11, PoolThreadCache poolThreadCache) {
        if (this.q050.allocate(pooledByteBuf, i10, i11, poolThreadCache) || this.q025.allocate(pooledByteBuf, i10, i11, poolThreadCache) || this.q000.allocate(pooledByteBuf, i10, i11, poolThreadCache) || this.qInit.allocate(pooledByteBuf, i10, i11, poolThreadCache) || this.q075.allocate(pooledByteBuf, i10, i11, poolThreadCache)) {
            return;
        }
        PoolChunk<T> poolChunkNewChunk = newChunk(this.pageSize, this.nPSizes, this.pageShifts, this.chunkSize);
        poolChunkNewChunk.allocate(pooledByteBuf, i10, i11, poolThreadCache);
        this.qInit.add(poolChunkNewChunk);
    }

    private void incSmallAllocation() {
        this.allocationsSmall.increment();
    }

    private PoolSubpage<T>[] newSubpagePoolArray(int i10) {
        return new PoolSubpage[i10];
    }

    private PoolSubpage<T> newSubpagePoolHead() {
        PoolSubpage<T> poolSubpage = new PoolSubpage<>();
        poolSubpage.prev = poolSubpage;
        poolSubpage.next = poolSubpage;
        return poolSubpage;
    }

    PoolSubpage<T> findSubpagePoolHead(int i10) {
        return this.smallSubpagePools[i10];
    }

    void free(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j10, int i10, PoolThreadCache poolThreadCache) {
        PoolChunk<T> poolChunk2;
        ByteBuffer byteBuffer2;
        long j11;
        int i11;
        if (poolChunk.unpooled) {
            int iChunkSize = poolChunk.chunkSize();
            destroyChunk(poolChunk);
            this.activeBytesHuge.add(-iChunkSize);
            this.deallocationsHuge.increment();
            return;
        }
        SizeClass sizeClass = sizeClass(j10);
        if (poolThreadCache != null) {
            poolChunk2 = poolChunk;
            if (poolThreadCache.add(this, poolChunk, byteBuffer, j10, i10, sizeClass)) {
                return;
            }
            byteBuffer2 = byteBuffer;
            j11 = j10;
            i11 = i10;
            sizeClass = sizeClass;
        } else {
            poolChunk2 = poolChunk;
            byteBuffer2 = byteBuffer;
            j11 = j10;
            i11 = i10;
        }
        freeChunk(poolChunk2, j11, i11, sizeClass, byteBuffer2, false);
    }

    void lock() {
        this.lock.lock();
    }

    public long numActiveBytes() {
        long jValue = this.activeBytesHuge.value();
        lock();
        for (int i10 = 0; i10 < this.chunkListMetrics.size(); i10++) {
            try {
                Iterator<PoolChunkMetric> it = this.chunkListMetrics.get(i10).iterator();
                while (it.hasNext()) {
                    jValue += (long) it.next().chunkSize();
                }
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        }
        unlock();
        return Math.max(0L, jValue);
    }

    void reallocate(PooledByteBuf<T> pooledByteBuf, int i10, boolean z10) {
        int i11 = pooledByteBuf.length;
        if (i11 == i10) {
            return;
        }
        PoolChunk<T> poolChunk = pooledByteBuf.chunk;
        ByteBuffer byteBuffer = pooledByteBuf.tmpNioBuf;
        long j10 = pooledByteBuf.handle;
        T t10 = pooledByteBuf.memory;
        int i12 = pooledByteBuf.offset;
        int i13 = pooledByteBuf.maxLength;
        allocate(this.parent.threadCache(), pooledByteBuf, i10);
        if (i10 > i11) {
            i10 = i11;
        } else {
            pooledByteBuf.trimIndicesToCapacity(i10);
        }
        memoryCopy(t10, i12, pooledByteBuf, i10);
        if (z10) {
            free(poolChunk, byteBuffer, j10, i13, pooledByteBuf.cache);
        }
    }

    void unlock() {
        this.lock.unlock();
    }

    private void allocate(PoolThreadCache poolThreadCache, PooledByteBuf<T> pooledByteBuf, int i10) {
        int iSize2SizeIdx = size2SizeIdx(i10);
        if (iSize2SizeIdx <= this.smallMaxSizeIdx) {
            tcacheAllocateSmall(poolThreadCache, pooledByteBuf, i10, iSize2SizeIdx);
        } else {
            if (iSize2SizeIdx < this.nSizes) {
                tcacheAllocateNormal(poolThreadCache, pooledByteBuf, i10, iSize2SizeIdx);
                return;
            }
            if (this.directMemoryCacheAlignment > 0) {
                i10 = normalizeSize(i10);
            }
            allocateHuge(pooledByteBuf, i10);
        }
    }

    private void allocateHuge(PooledByteBuf<T> pooledByteBuf, int i10) {
        PoolChunk<T> poolChunkNewUnpooledChunk = newUnpooledChunk(i10);
        this.activeBytesHuge.add(poolChunkNewUnpooledChunk.chunkSize());
        pooledByteBuf.initUnpooled(poolChunkNewUnpooledChunk, i10);
        this.allocationsHuge.increment();
    }

    private static SizeClass sizeClass(long j10) {
        if (PoolChunk.isSubpage(j10)) {
            return SizeClass.Small;
        }
        return SizeClass.Normal;
    }

    private void tcacheAllocateNormal(PoolThreadCache poolThreadCache, PooledByteBuf<T> pooledByteBuf, int i10, int i11) {
        if (poolThreadCache.allocateNormal(this, pooledByteBuf, i10, i11)) {
            return;
        }
        lock();
        try {
            allocateNormal(pooledByteBuf, i10, i11, poolThreadCache);
            this.allocationsNormal++;
        } finally {
            unlock();
        }
    }

    private void tcacheAllocateSmall(PoolThreadCache poolThreadCache, PooledByteBuf<T> pooledByteBuf, int i10, int i11) {
        boolean z10;
        PoolThreadCache poolThreadCache2;
        PooledByteBuf<T> pooledByteBuf2;
        int i12;
        if (poolThreadCache.allocateSmall(this, pooledByteBuf, i10, i11)) {
            return;
        }
        PoolSubpage<T> poolSubpageFindSubpagePoolHead = findSubpagePoolHead(i11);
        poolSubpageFindSubpagePoolHead.lock();
        try {
            PoolSubpage<T> poolSubpage = poolSubpageFindSubpagePoolHead.next;
            if (poolSubpage == poolSubpageFindSubpagePoolHead) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                poolThreadCache2 = poolThreadCache;
                pooledByteBuf2 = pooledByteBuf;
                i12 = i10;
                poolSubpage.chunk.initBufWithSubpage(pooledByteBuf2, null, poolSubpage.allocate(), i12, poolThreadCache2);
            } else {
                poolThreadCache2 = poolThreadCache;
                pooledByteBuf2 = pooledByteBuf;
                i12 = i10;
            }
            poolSubpageFindSubpagePoolHead.unlock();
            if (z10) {
                lock();
                try {
                    allocateNormal(pooledByteBuf2, i12, i11, poolThreadCache2);
                    unlock();
                } catch (Throwable th) {
                    unlock();
                    throw th;
                }
            }
            incSmallAllocation();
        } catch (Throwable th2) {
            poolSubpageFindSubpagePoolHead.unlock();
            throw th2;
        }
    }

    void freeChunk(PoolChunk<T> poolChunk, long j10, int i10, SizeClass sizeClass, ByteBuffer byteBuffer, boolean z10) {
        lock();
        if (!z10) {
            try {
                int i11 = AnonymousClass1.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[sizeClass.ordinal()];
                if (i11 != 1) {
                    if (i11 == 2) {
                        this.deallocationsSmall++;
                    } else {
                        throw new Error();
                    }
                } else {
                    this.deallocationsNormal++;
                }
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        }
        boolean zFree = poolChunk.parent.free(poolChunk, j10, i10, byteBuffer);
        unlock();
        if (!zFree) {
            destroyChunk(poolChunk);
        }
    }

    public String toString() {
        lock();
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Chunk(s) at 0~25%:");
            String str = StringUtil.NEWLINE;
            sb2.append(str);
            sb2.append(this.qInit);
            sb2.append(str);
            sb2.append("Chunk(s) at 0~50%:");
            sb2.append(str);
            sb2.append(this.q000);
            sb2.append(str);
            sb2.append("Chunk(s) at 25~75%:");
            sb2.append(str);
            sb2.append(this.q025);
            sb2.append(str);
            sb2.append("Chunk(s) at 50~100%:");
            sb2.append(str);
            sb2.append(this.q050);
            sb2.append(str);
            sb2.append("Chunk(s) at 75~100%:");
            sb2.append(str);
            sb2.append(this.q075);
            sb2.append(str);
            sb2.append("Chunk(s) at 100%:");
            sb2.append(str);
            sb2.append(this.q100);
            sb2.append(str);
            sb2.append("small subpages:");
            appendPoolSubPages(sb2, this.smallSubpagePools);
            sb2.append(str);
            return sb2.toString();
        } finally {
            unlock();
        }
    }
}
