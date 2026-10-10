package io.netty.buffer;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.location.LocationRequestCompat;
import io.netty.util.NettyRuntime;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThreadExecutorMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class PooledByteBufAllocator extends AbstractByteBufAllocator {
    public static final PooledByteBufAllocator DEFAULT;
    private static final int DEFAULT_CACHE_TRIM_INTERVAL;
    private static final long DEFAULT_CACHE_TRIM_INTERVAL_MILLIS;
    private static final int DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT;
    static final int DEFAULT_MAX_CACHED_BUFFER_CAPACITY;
    static final int DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK;
    private static final int DEFAULT_MAX_ORDER;
    private static final int DEFAULT_NORMAL_CACHE_SIZE;
    private static final int DEFAULT_NUM_DIRECT_ARENA;
    private static final int DEFAULT_NUM_HEAP_ARENA;
    private static final int DEFAULT_PAGE_SIZE;
    private static final int DEFAULT_SMALL_CACHE_SIZE;
    private static final boolean DEFAULT_USE_CACHE_FOR_ALL_THREADS;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PooledByteBufAllocator.class);
    private final int chunkSize;
    private final List<Object> directArenaMetrics;
    private final PoolArena<ByteBuffer>[] directArenas;
    private final List<Object> heapArenaMetrics;
    private final PoolArena<byte[]>[] heapArenas;
    private final PooledByteBufAllocatorMetric metric;
    private final int normalCacheSize;
    private final int smallCacheSize;
    private final PoolThreadLocalCache threadCache;
    private final Runnable trimTask;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class PoolThreadLocalCache extends FastThreadLocal<PoolThreadCache> {
        private final boolean useCacheForAllThreads;

        PoolThreadLocalCache(boolean z10) {
            this.useCacheForAllThreads = z10;
        }

        private <T> PoolArena<T> leastUsedArena(PoolArena<T>[] poolArenaArr) {
            if (poolArenaArr == null || poolArenaArr.length == 0) {
                return null;
            }
            PoolArena<T> poolArena = poolArenaArr[0];
            if (poolArena.numThreadCaches.get() == 0) {
                return poolArena;
            }
            for (int i10 = 1; i10 < poolArenaArr.length; i10++) {
                PoolArena<T> poolArena2 = poolArenaArr[i10];
                if (poolArena2.numThreadCaches.get() < poolArena.numThreadCaches.get()) {
                    poolArena = poolArena2;
                }
            }
            return poolArena;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public synchronized PoolThreadCache initialValue() {
            PoolArena poolArenaLeastUsedArena = leastUsedArena(PooledByteBufAllocator.this.heapArenas);
            PoolArena poolArenaLeastUsedArena2 = leastUsedArena(PooledByteBufAllocator.this.directArenas);
            Thread threadCurrentThread = Thread.currentThread();
            EventExecutor eventExecutorCurrentExecutor = ThreadExecutorMap.currentExecutor();
            if (!this.useCacheForAllThreads && !(threadCurrentThread instanceof FastThreadLocalThread) && eventExecutorCurrentExecutor == null) {
                return new PoolThreadCache(poolArenaLeastUsedArena, poolArenaLeastUsedArena2, 0, 0, 0, 0);
            }
            PoolThreadCache poolThreadCache = new PoolThreadCache(poolArenaLeastUsedArena, poolArenaLeastUsedArena2, PooledByteBufAllocator.this.smallCacheSize, PooledByteBufAllocator.this.normalCacheSize, PooledByteBufAllocator.DEFAULT_MAX_CACHED_BUFFER_CAPACITY, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL);
            if (PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS > 0 && eventExecutorCurrentExecutor != null) {
                eventExecutorCurrentExecutor.scheduleAtFixedRate(PooledByteBufAllocator.this.trimTask, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS, TimeUnit.MILLISECONDS);
            }
            return poolThreadCache;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public void onRemoval(PoolThreadCache poolThreadCache) {
            poolThreadCache.free(false);
        }
    }

    public PooledByteBufAllocator() {
        this(false);
    }

    static {
        Object obj;
        int i10;
        int i11 = SystemPropertyUtil.getInt("io.netty.allocator.directMemoryCacheAlignment", 0);
        int i12 = SystemPropertyUtil.getInt("io.netty.allocator.pageSize", 8192);
        Object obj2 = null;
        try {
            validateAndCalculatePageShifts(i12, i11);
            i10 = i12;
            obj = null;
        } catch (Throwable th) {
            obj = th;
            i11 = 0;
            i10 = 8192;
        }
        DEFAULT_PAGE_SIZE = i10;
        DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT = i11;
        int i13 = 9;
        int i14 = SystemPropertyUtil.getInt("io.netty.allocator.maxOrder", 9);
        try {
            validateAndCalculateChunkSize(i10, i14);
            i13 = i14;
        } catch (Throwable th2) {
            obj2 = th2;
        }
        DEFAULT_MAX_ORDER = i13;
        Runtime runtime = Runtime.getRuntime();
        int iAvailableProcessors = NettyRuntime.availableProcessors() * 2;
        int i15 = DEFAULT_PAGE_SIZE;
        long j10 = iAvailableProcessors;
        long j11 = i15 << i13;
        int iMax = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numHeapArenas", (int) Math.min(j10, ((runtime.maxMemory() / j11) / 2) / 3)));
        DEFAULT_NUM_HEAP_ARENA = iMax;
        int iMax2 = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numDirectArenas", (int) Math.min(j10, ((PlatformDependent.maxDirectMemory() / j11) / 2) / 3)));
        DEFAULT_NUM_DIRECT_ARENA = iMax2;
        int i16 = SystemPropertyUtil.getInt("io.netty.allocator.smallCacheSize", 256);
        DEFAULT_SMALL_CACHE_SIZE = i16;
        int i17 = SystemPropertyUtil.getInt("io.netty.allocator.normalCacheSize", 64);
        DEFAULT_NORMAL_CACHE_SIZE = i17;
        int i18 = SystemPropertyUtil.getInt("io.netty.allocator.maxCachedBufferCapacity", 32768);
        DEFAULT_MAX_CACHED_BUFFER_CAPACITY = i18;
        int i19 = SystemPropertyUtil.getInt("io.netty.allocator.cacheTrimInterval", 8192);
        DEFAULT_CACHE_TRIM_INTERVAL = i19;
        if (SystemPropertyUtil.contains("io.netty.allocation.cacheTrimIntervalMillis")) {
            logger.warn("-Dio.netty.allocation.cacheTrimIntervalMillis is deprecated, use -Dio.netty.allocator.cacheTrimIntervalMillis");
            if (SystemPropertyUtil.contains("io.netty.allocator.cacheTrimIntervalMillis")) {
                DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("io.netty.allocator.cacheTrimIntervalMillis", 0L);
            } else {
                DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("io.netty.allocation.cacheTrimIntervalMillis", 0L);
            }
        } else {
            DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("io.netty.allocator.cacheTrimIntervalMillis", 0L);
        }
        boolean z10 = SystemPropertyUtil.getBoolean("io.netty.allocator.useCacheForAllThreads", false);
        DEFAULT_USE_CACHE_FOR_ALL_THREADS = z10;
        int i20 = SystemPropertyUtil.getInt("io.netty.allocator.maxCachedByteBuffersPerChunk", 1023);
        DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK = i20;
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("-Dio.netty.allocator.numHeapArenas: {}", Integer.valueOf(iMax));
            internalLogger.debug("-Dio.netty.allocator.numDirectArenas: {}", Integer.valueOf(iMax2));
            if (obj == null) {
                internalLogger.debug("-Dio.netty.allocator.pageSize: {}", Integer.valueOf(i15));
            } else {
                internalLogger.debug("-Dio.netty.allocator.pageSize: {}", Integer.valueOf(i15), obj);
            }
            if (obj2 == null) {
                internalLogger.debug("-Dio.netty.allocator.maxOrder: {}", Integer.valueOf(i13));
            } else {
                internalLogger.debug("-Dio.netty.allocator.maxOrder: {}", Integer.valueOf(i13), obj2);
            }
            internalLogger.debug("-Dio.netty.allocator.chunkSize: {}", Integer.valueOf(i15 << i13));
            internalLogger.debug("-Dio.netty.allocator.smallCacheSize: {}", Integer.valueOf(i16));
            internalLogger.debug("-Dio.netty.allocator.normalCacheSize: {}", Integer.valueOf(i17));
            internalLogger.debug("-Dio.netty.allocator.maxCachedBufferCapacity: {}", Integer.valueOf(i18));
            internalLogger.debug("-Dio.netty.allocator.cacheTrimInterval: {}", Integer.valueOf(i19));
            internalLogger.debug("-Dio.netty.allocator.cacheTrimIntervalMillis: {}", Long.valueOf(DEFAULT_CACHE_TRIM_INTERVAL_MILLIS));
            internalLogger.debug("-Dio.netty.allocator.useCacheForAllThreads: {}", Boolean.valueOf(z10));
            internalLogger.debug("-Dio.netty.allocator.maxCachedByteBuffersPerChunk: {}", Integer.valueOf(i20));
        }
        DEFAULT = new PooledByteBufAllocator(PlatformDependent.directBufferPreferred());
    }

    public PooledByteBufAllocator(boolean z10) {
        this(z10, DEFAULT_NUM_HEAP_ARENA, DEFAULT_NUM_DIRECT_ARENA, DEFAULT_PAGE_SIZE, DEFAULT_MAX_ORDER);
    }

    private static <T> PoolArena<T>[] newArenaArray(int i10) {
        return new PoolArena[i10];
    }

    private static long usedMemory(PoolArena<?>[] poolArenaArr) {
        if (poolArenaArr == null) {
            return -1L;
        }
        long jNumActiveBytes = 0;
        for (PoolArena<?> poolArena : poolArenaArr) {
            jNumActiveBytes += poolArena.numActiveBytes();
            if (jNumActiveBytes < 0) {
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
        }
        return jNumActiveBytes;
    }

    private static int validateAndCalculateChunkSize(int i10, int i11) {
        if (i11 > 14) {
            throw new IllegalArgumentException("maxOrder: " + i11 + " (expected: 0-14)");
        }
        int i12 = i10;
        for (int i13 = i11; i13 > 0; i13--) {
            if (i12 > 536870912) {
                throw new IllegalArgumentException(String.format("pageSize (%d) << maxOrder (%d) must not exceed %d", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(BasicMeasure.EXACTLY)));
            }
            i12 <<= 1;
        }
        return i12;
    }

    private static int validateAndCalculatePageShifts(int i10, int i11) {
        if (i10 < 4096) {
            throw new IllegalArgumentException("pageSize: " + i10 + " (expected: 4096)");
        }
        if (((i10 - 1) & i10) != 0) {
            throw new IllegalArgumentException("pageSize: " + i10 + " (expected: power of 2)");
        }
        if (i10 >= i11) {
            return 31 - Integer.numberOfLeadingZeros(i10);
        }
        throw new IllegalArgumentException("Alignment cannot be greater than page size. Alignment: " + i11 + ", page size: " + i10 + '.');
    }

    @Deprecated
    public final int chunkSize() {
        return this.chunkSize;
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public boolean isDirectBufferPooled() {
        return this.directArenas != null;
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newDirectBuffer(int i10, int i11) {
        ByteBuf byteBufNewUnsafeDirectByteBuf;
        PoolThreadCache poolThreadCache = this.threadCache.get();
        PoolArena<ByteBuffer> poolArena = poolThreadCache.directArena;
        if (poolArena != null) {
            byteBufNewUnsafeDirectByteBuf = poolArena.allocate(poolThreadCache, i10, i11);
        } else {
            byteBufNewUnsafeDirectByteBuf = PlatformDependent.hasUnsafe() ? UnsafeByteBufUtil.newUnsafeDirectByteBuf(this, i10, i11) : new UnpooledDirectByteBuf(this, i10, i11);
        }
        return AbstractByteBufAllocator.toLeakAwareBuffer(byteBufNewUnsafeDirectByteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newHeapBuffer(int i10, int i11) {
        ByteBuf unpooledUnsafeHeapByteBuf;
        PoolThreadCache poolThreadCache = this.threadCache.get();
        PoolArena<byte[]> poolArena = poolThreadCache.heapArena;
        if (poolArena != null) {
            unpooledUnsafeHeapByteBuf = poolArena.allocate(poolThreadCache, i10, i11);
        } else {
            unpooledUnsafeHeapByteBuf = PlatformDependent.hasUnsafe() ? new UnpooledUnsafeHeapByteBuf(this, i10, i11) : new UnpooledHeapByteBuf(this, i10, i11);
        }
        return AbstractByteBufAllocator.toLeakAwareBuffer(unpooledUnsafeHeapByteBuf);
    }

    @Deprecated
    public int normalCacheSize() {
        return this.normalCacheSize;
    }

    @Deprecated
    public int numDirectArenas() {
        return this.directArenaMetrics.size();
    }

    @Deprecated
    public int numHeapArenas() {
        return this.heapArenaMetrics.size();
    }

    @Deprecated
    public int numThreadLocalCaches() {
        PoolArena[] poolArenaArr = this.heapArenas;
        if (poolArenaArr == null) {
            poolArenaArr = this.directArenas;
        }
        if (poolArenaArr == null) {
            return 0;
        }
        int i10 = 0;
        for (PoolArena poolArena : poolArenaArr) {
            i10 += poolArena.numThreadCaches.get();
        }
        return i10;
    }

    @Deprecated
    public int smallCacheSize() {
        return this.smallCacheSize;
    }

    final PoolThreadCache threadCache() {
        return this.threadCache.get();
    }

    public boolean trimCurrentThreadCache() {
        PoolThreadCache ifExists = this.threadCache.getIfExists();
        if (ifExists == null) {
            return false;
        }
        ifExists.trim();
        return true;
    }

    final long usedDirectMemory() {
        return usedMemory(this.directArenas);
    }

    final long usedHeapMemory() {
        return usedMemory(this.heapArenas);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z10, int i10, int i11, int i12, int i13) {
        this(z10, i10, i11, i12, i13, 0, DEFAULT_SMALL_CACHE_SIZE, DEFAULT_NORMAL_CACHE_SIZE);
    }

    public static boolean isDirectMemoryCacheAlignmentSupported() {
        return PlatformDependent.hasUnsafe();
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z10, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this(z10, i10, i11, i12, i13, i15, i16, DEFAULT_USE_CACHE_FOR_ALL_THREADS, DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
    }

    public PooledByteBufAllocator(boolean z10, int i10, int i11, int i12, int i13, int i14, int i15, boolean z11, int i16) {
        PooledByteBufAllocator pooledByteBufAllocator;
        super(z10);
        this.trimTask = new Runnable() { // from class: io.netty.buffer.PooledByteBufAllocator.1
            @Override // java.lang.Runnable
            public void run() {
                PooledByteBufAllocator.this.trimCurrentThreadCache();
            }
        };
        this.threadCache = new PoolThreadLocalCache(z11);
        this.smallCacheSize = i14;
        this.normalCacheSize = i15;
        if (i16 != 0) {
            if (PlatformDependent.hasAlignDirectByteBuffer()) {
                i12 = (int) PlatformDependent.align(i12, i16);
            } else {
                throw new UnsupportedOperationException("Buffer alignment is not supported. Either Unsafe or ByteBuffer.alignSlice() must be available.");
            }
        }
        this.chunkSize = validateAndCalculateChunkSize(i12, i13);
        ObjectUtil.checkPositiveOrZero(i10, "nHeapArena");
        ObjectUtil.checkPositiveOrZero(i11, "nDirectArena");
        ObjectUtil.checkPositiveOrZero(i16, "directMemoryCacheAlignment");
        if (i16 > 0 && !isDirectMemoryCacheAlignmentSupported()) {
            throw new IllegalArgumentException("directMemoryCacheAlignment is not supported");
        }
        if (((-i16) & i16) == i16) {
            int iValidateAndCalculatePageShifts = validateAndCalculatePageShifts(i12, i16);
            if (i10 > 0) {
                PoolArena<byte[]>[] poolArenaArrNewArenaArray = newArenaArray(i10);
                this.heapArenas = poolArenaArrNewArenaArray;
                ArrayList arrayList = new ArrayList(poolArenaArrNewArenaArray.length);
                for (int i17 = 0; i17 < this.heapArenas.length; i17++) {
                    PoolArena.HeapArena heapArena = new PoolArena.HeapArena(this, i12, iValidateAndCalculatePageShifts, this.chunkSize);
                    this.heapArenas[i17] = heapArena;
                    arrayList.add(heapArena);
                }
                this.heapArenaMetrics = Collections.unmodifiableList(arrayList);
            } else {
                this.heapArenas = null;
                this.heapArenaMetrics = Collections.EMPTY_LIST;
            }
            if (i11 > 0) {
                PoolArena<ByteBuffer>[] poolArenaArrNewArenaArray2 = newArenaArray(i11);
                this.directArenas = poolArenaArrNewArenaArray2;
                ArrayList arrayList2 = new ArrayList(poolArenaArrNewArenaArray2.length);
                int i18 = 0;
                while (i18 < this.directArenas.length) {
                    int i19 = i12;
                    PoolArena.DirectArena directArena = new PoolArena.DirectArena(this, i19, iValidateAndCalculatePageShifts, this.chunkSize, i16);
                    this.directArenas[i18] = directArena;
                    arrayList2.add(directArena);
                    i18++;
                    i12 = i19;
                }
                pooledByteBufAllocator = this;
                pooledByteBufAllocator.directArenaMetrics = Collections.unmodifiableList(arrayList2);
            } else {
                pooledByteBufAllocator = this;
                pooledByteBufAllocator.directArenas = null;
                pooledByteBufAllocator.directArenaMetrics = Collections.EMPTY_LIST;
            }
            pooledByteBufAllocator.metric = new PooledByteBufAllocatorMetric(this);
            return;
        }
        throw new IllegalArgumentException("directMemoryCacheAlignment: " + i16 + " (expected: power of two)");
    }
}
