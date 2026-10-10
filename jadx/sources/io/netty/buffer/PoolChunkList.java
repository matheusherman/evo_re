package io.netty.buffer;

import io.netty.util.internal.StringUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class PoolChunkList<T> implements PoolChunkListMetric {
    private static final Iterator<PoolChunkMetric> EMPTY_METRICS = Collections.EMPTY_LIST.iterator();
    private final PoolArena<T> arena;
    private final int freeMaxThreshold;
    private final int freeMinThreshold;
    private PoolChunk<T> head;
    private final int maxCapacity;
    private final int maxUsage;
    private final int minUsage;
    private final PoolChunkList<T> nextList;
    private PoolChunkList<T> prevList;

    private static int minUsage0(int i10) {
        return Math.max(1, i10);
    }

    private boolean move(PoolChunk<T> poolChunk) {
        if (poolChunk.freeBytes > this.freeMaxThreshold) {
            return move0(poolChunk);
        }
        add0(poolChunk);
        return true;
    }

    private boolean move0(PoolChunk<T> poolChunk) {
        PoolChunkList<T> poolChunkList = this.prevList;
        if (poolChunkList == null) {
            return false;
        }
        return poolChunkList.move(poolChunk);
    }

    private void remove(PoolChunk<T> poolChunk) {
        if (poolChunk == this.head) {
            PoolChunk<T> poolChunk2 = poolChunk.next;
            this.head = poolChunk2;
            if (poolChunk2 != null) {
                poolChunk2.prev = null;
                return;
            }
            return;
        }
        PoolChunk<T> poolChunk3 = poolChunk.next;
        PoolChunk<T> poolChunk4 = poolChunk.prev;
        poolChunk4.next = poolChunk3;
        if (poolChunk3 != null) {
            poolChunk3.prev = poolChunk4;
        }
    }

    void add(PoolChunk<T> poolChunk) {
        if (poolChunk.freeBytes <= this.freeMinThreshold) {
            this.nextList.add(poolChunk);
        } else {
            add0(poolChunk);
        }
    }

    void add0(PoolChunk<T> poolChunk) {
        poolChunk.parent = this;
        PoolChunk<T> poolChunk2 = this.head;
        if (poolChunk2 == null) {
            this.head = poolChunk;
            poolChunk.prev = null;
            poolChunk.next = null;
        } else {
            poolChunk.prev = null;
            poolChunk.next = poolChunk2;
            poolChunk2.prev = poolChunk;
            this.head = poolChunk;
        }
    }

    boolean allocate(PooledByteBuf<T> pooledByteBuf, int i10, int i11, PoolThreadCache poolThreadCache) {
        if (this.arena.sizeIdx2size(i11) > this.maxCapacity) {
            return false;
        }
        for (PoolChunk<T> poolChunk = this.head; poolChunk != null; poolChunk = poolChunk.next) {
            if (poolChunk.allocate(pooledByteBuf, i10, i11, poolThreadCache)) {
                if (poolChunk.freeBytes > this.freeMinThreshold) {
                    return true;
                }
                remove(poolChunk);
                this.nextList.add(poolChunk);
                return true;
            }
        }
        return false;
    }

    void destroy(PoolArena<T> poolArena) {
        for (PoolChunk<T> poolChunk = this.head; poolChunk != null; poolChunk = poolChunk.next) {
            poolArena.destroyChunk(poolChunk);
        }
        this.head = null;
    }

    @Override // java.lang.Iterable
    public Iterator<PoolChunkMetric> iterator() {
        Iterator<PoolChunkMetric> it;
        this.arena.lock();
        try {
            if (this.head == null) {
                it = EMPTY_METRICS;
            } else {
                ArrayList arrayList = new ArrayList();
                PoolChunk<T> poolChunk = this.head;
                do {
                    arrayList.add(poolChunk);
                    poolChunk = poolChunk.next;
                } while (poolChunk != null);
                it = arrayList.iterator();
            }
            return it;
        } finally {
            this.arena.unlock();
        }
    }

    void prevList(PoolChunkList<T> poolChunkList) {
        this.prevList = poolChunkList;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        this.arena.lock();
        try {
            PoolChunk<T> poolChunk = this.head;
            if (poolChunk == null) {
                this.arena.unlock();
                return "none";
            }
            while (true) {
                sb2.append(poolChunk);
                poolChunk = poolChunk.next;
                if (poolChunk == null) {
                    this.arena.unlock();
                    return sb2.toString();
                }
                sb2.append(StringUtil.NEWLINE);
            }
        } catch (Throwable th) {
            this.arena.unlock();
            throw th;
        }
    }

    PoolChunkList(PoolArena<T> poolArena, PoolChunkList<T> poolChunkList, int i10, int i11, int i12) {
        int i13;
        this.arena = poolArena;
        this.nextList = poolChunkList;
        this.minUsage = i10;
        this.maxUsage = i11;
        this.maxCapacity = calculateMaxCapacity(i10, i12);
        if (i11 == 100) {
            i13 = 0;
        } else {
            i13 = (int) ((((double) i12) * ((100.0d - ((double) i11)) + 0.99999999d)) / 100.0d);
        }
        this.freeMinThreshold = i13;
        this.freeMaxThreshold = i10 != 100 ? (int) ((((double) i12) * ((100.0d - ((double) i10)) + 0.99999999d)) / 100.0d) : 0;
    }

    private static int calculateMaxCapacity(int i10, int i11) {
        int iMinUsage0 = minUsage0(i10);
        if (iMinUsage0 == 100) {
            return 0;
        }
        return (int) ((((long) i11) * (100 - ((long) iMinUsage0))) / 100);
    }

    boolean free(PoolChunk<T> poolChunk, long j10, int i10, ByteBuffer byteBuffer) {
        poolChunk.free(j10, i10, byteBuffer);
        if (poolChunk.freeBytes > this.freeMaxThreshold) {
            remove(poolChunk);
            return move0(poolChunk);
        }
        return true;
    }
}
