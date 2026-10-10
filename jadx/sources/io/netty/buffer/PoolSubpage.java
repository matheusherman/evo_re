package io.netty.buffer;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class PoolSubpage<T> {
    private final long[] bitmap;
    private int bitmapLength;
    final PoolChunk<T> chunk;
    boolean doNotDestroy;
    final int elemSize;
    private final ReentrantLock lock;
    private int maxNumElems;
    PoolSubpage<T> next;
    private int nextAvail;
    private int numAvail;
    private final int pageShifts;
    PoolSubpage<T> prev;
    private final int runOffset;
    private final int runSize;

    PoolSubpage() {
        this.lock = new ReentrantLock();
        this.chunk = null;
        this.pageShifts = -1;
        this.runOffset = -1;
        this.elemSize = -1;
        this.runSize = -1;
        this.bitmap = null;
    }

    private void addToPool(PoolSubpage<T> poolSubpage) {
        this.prev = poolSubpage;
        PoolSubpage<T> poolSubpage2 = poolSubpage.next;
        this.next = poolSubpage2;
        poolSubpage2.prev = this;
        poolSubpage.next = this;
    }

    private int findNextAvail() {
        long[] jArr = this.bitmap;
        int i10 = this.bitmapLength;
        for (int i11 = 0; i11 < i10; i11++) {
            long j10 = jArr[i11];
            if ((~j10) != 0) {
                return findNextAvail0(i11, j10);
            }
        }
        return -1;
    }

    private int findNextAvail0(int i10, long j10) {
        int i11 = this.maxNumElems;
        int i12 = i10 << 6;
        for (int i13 = 0; i13 < 64; i13++) {
            if ((1 & j10) == 0) {
                int i14 = i12 | i13;
                if (i14 < i11) {
                    return i14;
                }
                return -1;
            }
            j10 >>>= 1;
        }
        return -1;
    }

    private int getNextAvail() {
        int i10 = this.nextAvail;
        if (i10 < 0) {
            return findNextAvail();
        }
        this.nextAvail = -1;
        return i10;
    }

    private void removeFromPool() {
        PoolSubpage<T> poolSubpage = this.prev;
        poolSubpage.next = this.next;
        this.next.prev = poolSubpage;
        this.next = null;
        this.prev = null;
    }

    private void setNextAvail(int i10) {
        this.nextAvail = i10;
    }

    private long toHandle(int i10) {
        return (((long) this.runOffset) << 49) | (((long) (this.runSize >> this.pageShifts)) << 34) | 12884901888L | ((long) i10);
    }

    long allocate() {
        if (this.numAvail == 0 || !this.doNotDestroy) {
            return -1L;
        }
        int nextAvail = getNextAvail();
        if (nextAvail >= 0) {
            int i10 = nextAvail >>> 6;
            long[] jArr = this.bitmap;
            jArr[i10] = jArr[i10] | (1 << (nextAvail & 63));
            int i11 = this.numAvail - 1;
            this.numAvail = i11;
            if (i11 == 0) {
                removeFromPool();
            }
            return toHandle(nextAvail);
        }
        removeFromPool();
        throw new AssertionError("No next available bitmap index found (bitmapIdx = " + nextAvail + "), even though there are supposed to be (numAvail = " + this.numAvail + ") out of (maxNumElems = " + this.maxNumElems + ") available indexes.");
    }

    void destroy() {
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk != null) {
            poolChunk.destroy();
        }
    }

    boolean free(PoolSubpage<T> poolSubpage, int i10) {
        if (this.elemSize == 0) {
            return true;
        }
        int i11 = i10 >>> 6;
        long[] jArr = this.bitmap;
        jArr[i11] = jArr[i11] ^ (1 << (i10 & 63));
        setNextAvail(i10);
        int i12 = this.numAvail;
        this.numAvail = i12 + 1;
        if (i12 == 0) {
            addToPool(poolSubpage);
            if (this.maxNumElems > 1) {
                return true;
            }
        }
        if (this.numAvail != this.maxNumElems || this.prev == this.next) {
            return true;
        }
        this.doNotDestroy = false;
        removeFromPool();
        return false;
    }

    void lock() {
        this.lock.lock();
    }

    public String toString() {
        int i10;
        int i11;
        PoolChunk<T> poolChunk = this.chunk;
        int i12 = -1;
        boolean z10 = true;
        int i13 = 0;
        if (poolChunk == null) {
            i10 = 0;
        } else {
            poolChunk.arena.lock();
            try {
                if (this.doNotDestroy) {
                    i12 = this.maxNumElems;
                    i10 = this.numAvail;
                    i11 = this.elemSize;
                } else {
                    i10 = -1;
                    z10 = false;
                    i11 = -1;
                }
                this.chunk.arena.unlock();
                int i14 = i11;
                i13 = i12;
                i12 = i14;
            } catch (Throwable th) {
                this.chunk.arena.unlock();
                throw th;
            }
        }
        if (!z10) {
            return "(" + this.runOffset + ": not in use)";
        }
        return "(" + this.runOffset + ": " + (i13 - i10) + '/' + i13 + ", offset: " + this.runOffset + ", length: " + this.runSize + ", elemSize: " + i12 + ')';
    }

    void unlock() {
        this.lock.unlock();
    }

    PoolSubpage(PoolSubpage<T> poolSubpage, PoolChunk<T> poolChunk, int i10, int i11, int i12, int i13) {
        this.lock = new ReentrantLock();
        this.chunk = poolChunk;
        this.pageShifts = i10;
        this.runOffset = i11;
        this.runSize = i12;
        this.elemSize = i13;
        this.bitmap = new long[i12 >>> 10];
        this.doNotDestroy = true;
        if (i13 != 0) {
            int i14 = i12 / i13;
            this.numAvail = i14;
            this.maxNumElems = i14;
            this.nextAvail = 0;
            int i15 = i14 >>> 6;
            this.bitmapLength = i15;
            if ((i14 & 63) != 0) {
                this.bitmapLength = i15 + 1;
            }
            for (int i16 = 0; i16 < this.bitmapLength; i16++) {
                this.bitmap[i16] = 0;
            }
        }
        addToPool(poolSubpage);
    }
}
