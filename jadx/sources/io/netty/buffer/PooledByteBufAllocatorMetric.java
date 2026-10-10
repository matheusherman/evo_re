package io.netty.buffer;

import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class PooledByteBufAllocatorMetric {
    private final PooledByteBufAllocator allocator;

    public int chunkSize() {
        return this.allocator.chunkSize();
    }

    public int normalCacheSize() {
        return this.allocator.normalCacheSize();
    }

    public int numDirectArenas() {
        return this.allocator.numDirectArenas();
    }

    public int numHeapArenas() {
        return this.allocator.numHeapArenas();
    }

    public int numThreadLocalCaches() {
        return this.allocator.numThreadLocalCaches();
    }

    public int smallCacheSize() {
        return this.allocator.smallCacheSize();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(256);
        sb2.append(StringUtil.simpleClassName(this));
        sb2.append("(usedHeapMemory: ");
        sb2.append(usedHeapMemory());
        sb2.append("; usedDirectMemory: ");
        sb2.append(usedDirectMemory());
        sb2.append("; numHeapArenas: ");
        sb2.append(numHeapArenas());
        sb2.append("; numDirectArenas: ");
        sb2.append(numDirectArenas());
        sb2.append("; smallCacheSize: ");
        sb2.append(smallCacheSize());
        sb2.append("; normalCacheSize: ");
        sb2.append(normalCacheSize());
        sb2.append("; numThreadLocalCaches: ");
        sb2.append(numThreadLocalCaches());
        sb2.append("; chunkSize: ");
        sb2.append(chunkSize());
        sb2.append(')');
        return sb2.toString();
    }

    public long usedDirectMemory() {
        return this.allocator.usedDirectMemory();
    }

    public long usedHeapMemory() {
        return this.allocator.usedHeapMemory();
    }

    PooledByteBufAllocatorMetric(PooledByteBufAllocator pooledByteBufAllocator) {
        this.allocator = pooledByteBufAllocator;
    }
}
