package io.netty.buffer;

import io.netty.util.internal.LongCounter;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.ReentrantLock;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class PoolChunk<T> implements PoolChunkMetric {
    final PoolArena<T> arena;
    final Object base;
    private final Deque<ByteBuffer> cachedNioBuffers;
    private final int chunkSize;
    int freeBytes;
    final T memory;
    PoolChunk<T> next;
    private final int pageShifts;
    private final int pageSize;
    PoolChunkList<T> parent;
    private final LongCounter pinnedBytes;
    PoolChunk<T> prev;
    private final LongPriorityQueue[] runsAvail;
    private final ReentrantLock runsAvailLock;
    private final LongLongHashMap runsAvailMap;
    private final PoolSubpage<T>[] subpages;
    final boolean unpooled;

    PoolChunk(PoolArena<T> poolArena, Object obj, T t10, int i10, int i11, int i12, int i13) {
        this.pinnedBytes = PlatformDependent.newLongCounter();
        this.unpooled = false;
        this.arena = poolArena;
        this.base = obj;
        this.memory = t10;
        this.pageSize = i10;
        this.pageShifts = i11;
        this.chunkSize = i12;
        this.freeBytes = i12;
        this.runsAvail = newRunsAvailqueueArray(i13);
        this.runsAvailLock = new ReentrantLock();
        this.runsAvailMap = new LongLongHashMap(-1L);
        int i14 = i12 >> i11;
        this.subpages = new PoolSubpage[i14];
        insertAvailRun(0, i14, ((long) i14) << 34);
        this.cachedNioBuffers = new ArrayDeque(8);
    }

    static int bitmapIdx(long j10) {
        return (int) j10;
    }

    private static int lastPage(int i10, int i11) {
        return (i10 + i11) - 1;
    }

    private void removeAvailRun(long j10) {
        removeAvailRun(this.runsAvail[this.arena.pages2pageIdxFloor(runPages(j10))], j10);
    }

    private static long toRunHandle(int i10, int i11, int i12) {
        return (((long) i11) << 34) | (((long) i10) << 49) | (((long) i12) << 33);
    }

    private long allocateRun(int i10) {
        int i11 = i10 >> this.pageShifts;
        int iPages2pageIdx = this.arena.pages2pageIdx(i11);
        this.runsAvailLock.lock();
        try {
            int iRunFirstBestFit = runFirstBestFit(iPages2pageIdx);
            if (iRunFirstBestFit == -1) {
                return -1L;
            }
            LongPriorityQueue longPriorityQueue = this.runsAvail[iRunFirstBestFit];
            long jPoll = longPriorityQueue.poll();
            removeAvailRun(longPriorityQueue, jPoll);
            if (jPoll != -1) {
                jPoll = splitLargeRun(jPoll, i11);
            }
            this.freeBytes -= runSize(this.pageShifts, jPoll);
            return jPoll;
        } finally {
            this.runsAvailLock.unlock();
        }
    }

    private long allocateSubpage(int i10) throws Throwable {
        PoolSubpage<T> poolSubpageFindSubpagePoolHead = this.arena.findSubpagePoolHead(i10);
        poolSubpageFindSubpagePoolHead.lock();
        try {
            long jAllocateRun = allocateRun(calculateRunSize(i10));
            if (jAllocateRun < 0) {
                poolSubpageFindSubpagePoolHead.unlock();
                return -1L;
            }
            int iRunOffset = runOffset(jAllocateRun);
            int iSizeIdx2size = this.arena.sizeIdx2size(i10);
            int i11 = this.pageShifts;
            try {
                PoolSubpage<T> poolSubpage = new PoolSubpage<>(poolSubpageFindSubpagePoolHead, this, i11, iRunOffset, runSize(i11, jAllocateRun), iSizeIdx2size);
                this.subpages[iRunOffset] = poolSubpage;
                long jAllocate = poolSubpage.allocate();
                poolSubpageFindSubpagePoolHead.unlock();
                return jAllocate;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        Throwable th3 = th;
        poolSubpageFindSubpagePoolHead.unlock();
        throw th3;
    }

    private int calculateRunSize(int i10) {
        int i11;
        int i12 = 1 << (this.pageShifts - 4);
        int iSizeIdx2size = this.arena.sizeIdx2size(i10);
        int i13 = 0;
        do {
            i13 += this.pageSize;
            i11 = i13 / iSizeIdx2size;
            if (i11 >= i12) {
                break;
            }
        } while (i13 != i11 * iSizeIdx2size);
        while (i11 > i12) {
            i13 -= this.pageSize;
            i11 = i13 / iSizeIdx2size;
        }
        return i13;
    }

    private long getAvailRunByOffset(int i10) {
        return this.runsAvailMap.get(i10);
    }

    private void insertAvailRun(int i10, int i11, long j10) {
        this.runsAvail[this.arena.pages2pageIdxFloor(i11)].offer(j10);
        insertAvailRun0(i10, j10);
        if (i11 > 1) {
            insertAvailRun0(lastPage(i10, i11), j10);
        }
    }

    private void insertAvailRun0(int i10, long j10) {
        this.runsAvailMap.put(i10, j10);
    }

    static boolean isSubpage(long j10) {
        return ((j10 >> 32) & 1) == 1;
    }

    private static LongPriorityQueue[] newRunsAvailqueueArray(int i10) {
        LongPriorityQueue[] longPriorityQueueArr = new LongPriorityQueue[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            longPriorityQueueArr[i11] = new LongPriorityQueue();
        }
        return longPriorityQueueArr;
    }

    private int runFirstBestFit(int i10) {
        if (this.freeBytes == this.chunkSize) {
            return this.arena.nPSizes - 1;
        }
        while (i10 < this.arena.nPSizes) {
            LongPriorityQueue longPriorityQueue = this.runsAvail[i10];
            if (longPriorityQueue != null && !longPriorityQueue.isEmpty()) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    static int runOffset(long j10) {
        return (int) (j10 >> 49);
    }

    static int runPages(long j10) {
        return (int) ((j10 >> 34) & 32767);
    }

    private int usage(int i10) {
        if (i10 == 0) {
            return 100;
        }
        int i11 = (int) ((((long) i10) * 100) / ((long) this.chunkSize));
        if (i11 == 0) {
            return 99;
        }
        return 100 - i11;
    }

    boolean allocate(PooledByteBuf<T> pooledByteBuf, int i10, int i11, PoolThreadCache poolThreadCache) {
        long jAllocateRun;
        PoolArena<T> poolArena = this.arena;
        if (i11 <= poolArena.smallMaxSizeIdx) {
            jAllocateRun = allocateSubpage(i11);
            if (jAllocateRun < 0) {
                return false;
            }
        } else {
            jAllocateRun = allocateRun(poolArena.sizeIdx2size(i11));
            if (jAllocateRun < 0) {
                return false;
            }
        }
        long j10 = jAllocateRun;
        Deque<ByteBuffer> deque = this.cachedNioBuffers;
        initBuf(pooledByteBuf, deque != null ? deque.pollLast() : null, j10, i10, poolThreadCache);
        return true;
    }

    @Override // io.netty.buffer.PoolChunkMetric
    public int chunkSize() {
        return this.chunkSize;
    }

    void decrementPinnedMemory(int i10) {
        this.pinnedBytes.add(-i10);
    }

    void destroy() {
        this.arena.destroyChunk(this);
    }

    void free(long j10, int i10, ByteBuffer byteBuffer) {
        Deque<ByteBuffer> deque;
        int iRunSize = runSize(this.pageShifts, j10);
        if (isSubpage(j10)) {
            PoolSubpage<T> poolSubpageFindSubpagePoolHead = this.arena.findSubpagePoolHead(this.arena.size2SizeIdx(i10));
            int iRunOffset = runOffset(j10);
            PoolSubpage<T> poolSubpage = this.subpages[iRunOffset];
            poolSubpageFindSubpagePoolHead.lock();
            try {
                if (poolSubpage.free(poolSubpageFindSubpagePoolHead, bitmapIdx(j10))) {
                    poolSubpageFindSubpagePoolHead.unlock();
                    return;
                } else {
                    this.subpages[iRunOffset] = null;
                    poolSubpageFindSubpagePoolHead.unlock();
                }
            } catch (Throwable th) {
                poolSubpageFindSubpagePoolHead.unlock();
                throw th;
            }
        }
        this.runsAvailLock.lock();
        try {
            long jCollapseRuns = collapseRuns(j10) & (-12884901889L);
            insertAvailRun(runOffset(jCollapseRuns), runPages(jCollapseRuns), jCollapseRuns);
            this.freeBytes += iRunSize;
            this.runsAvailLock.unlock();
            if (byteBuffer == null || (deque = this.cachedNioBuffers) == null || deque.size() >= PooledByteBufAllocator.DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK) {
                return;
            }
            this.cachedNioBuffers.offer(byteBuffer);
        } catch (Throwable th2) {
            this.runsAvailLock.unlock();
            throw th2;
        }
    }

    void incrementPinnedMemory(int i10) {
        this.pinnedBytes.add(i10);
    }

    public String toString() {
        this.arena.lock();
        try {
            int i10 = this.freeBytes;
            this.arena.unlock();
            return "Chunk(" + Integer.toHexString(System.identityHashCode(this)) + ": " + usage(i10) + "%, " + (this.chunkSize - i10) + '/' + this.chunkSize + ')';
        } catch (Throwable th) {
            this.arena.unlock();
            throw th;
        }
    }

    private long collapseNext(long j10) {
        while (true) {
            int iRunOffset = runOffset(j10);
            int iRunPages = runPages(j10);
            int i10 = iRunOffset + iRunPages;
            long availRunByOffset = getAvailRunByOffset(i10);
            if (availRunByOffset == -1) {
                break;
            }
            int iRunOffset2 = runOffset(availRunByOffset);
            int iRunPages2 = runPages(availRunByOffset);
            if (availRunByOffset == j10 || i10 != iRunOffset2) {
                break;
            }
            removeAvailRun(availRunByOffset);
            j10 = toRunHandle(iRunOffset, iRunPages + iRunPages2, 0);
        }
        return j10;
    }

    private long collapsePast(long j10) {
        while (true) {
            int iRunOffset = runOffset(j10);
            int iRunPages = runPages(j10);
            long availRunByOffset = getAvailRunByOffset(iRunOffset - 1);
            if (availRunByOffset == -1) {
                break;
            }
            int iRunOffset2 = runOffset(availRunByOffset);
            int iRunPages2 = runPages(availRunByOffset);
            if (availRunByOffset == j10 || iRunOffset2 + iRunPages2 != iRunOffset) {
                break;
            }
            removeAvailRun(availRunByOffset);
            j10 = toRunHandle(iRunOffset2, iRunPages2 + iRunPages, 0);
        }
        return j10;
    }

    private long collapseRuns(long j10) {
        return collapseNext(collapsePast(j10));
    }

    static int runSize(int i10, long j10) {
        return runPages(j10) << i10;
    }

    private long splitLargeRun(long j10, int i10) {
        int iRunPages = runPages(j10) - i10;
        if (iRunPages > 0) {
            int iRunOffset = runOffset(j10);
            int i11 = iRunOffset + i10;
            insertAvailRun(i11, iRunPages, toRunHandle(i11, iRunPages, 0));
            return toRunHandle(iRunOffset, i10, 1);
        }
        return j10 | IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
    }

    void initBuf(PooledByteBuf<T> pooledByteBuf, ByteBuffer byteBuffer, long j10, int i10, PoolThreadCache poolThreadCache) {
        if (isSubpage(j10)) {
            initBufWithSubpage(pooledByteBuf, byteBuffer, j10, i10, poolThreadCache);
        } else {
            pooledByteBuf.init(this, byteBuffer, j10, runOffset(j10) << this.pageShifts, i10, runSize(this.pageShifts, j10), this.arena.parent.threadCache());
        }
    }

    void initBufWithSubpage(PooledByteBuf<T> pooledByteBuf, ByteBuffer byteBuffer, long j10, int i10, PoolThreadCache poolThreadCache) {
        int iRunOffset = runOffset(j10);
        int iBitmapIdx = bitmapIdx(j10);
        PoolSubpage<T> poolSubpage = this.subpages[iRunOffset];
        int i11 = iRunOffset << this.pageShifts;
        int i12 = poolSubpage.elemSize;
        pooledByteBuf.init(this, byteBuffer, j10, i11 + (iBitmapIdx * i12), i10, i12, poolThreadCache);
    }

    private void removeAvailRun(LongPriorityQueue longPriorityQueue, long j10) {
        longPriorityQueue.remove(j10);
        int iRunOffset = runOffset(j10);
        int iRunPages = runPages(j10);
        this.runsAvailMap.remove(iRunOffset);
        if (iRunPages > 1) {
            this.runsAvailMap.remove(lastPage(iRunOffset, iRunPages));
        }
    }

    PoolChunk(PoolArena<T> poolArena, Object obj, T t10, int i10) {
        this.pinnedBytes = PlatformDependent.newLongCounter();
        this.unpooled = true;
        this.arena = poolArena;
        this.base = obj;
        this.memory = t10;
        this.pageSize = 0;
        this.pageShifts = 0;
        this.runsAvailMap = null;
        this.runsAvail = null;
        this.runsAvailLock = null;
        this.subpages = null;
        this.chunkSize = i10;
        this.cachedNioBuffers = null;
    }
}
