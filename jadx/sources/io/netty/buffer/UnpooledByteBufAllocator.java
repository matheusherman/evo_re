package io.netty.buffer;

import io.netty.util.internal.LongCounter;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class UnpooledByteBufAllocator extends AbstractByteBufAllocator {
    public static final UnpooledByteBufAllocator DEFAULT = new UnpooledByteBufAllocator(PlatformDependent.directBufferPreferred());
    private final boolean disableLeakDetector;
    private final UnpooledByteBufAllocatorMetric metric;
    private final boolean noCleaner;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class UnpooledByteBufAllocatorMetric {
        final LongCounter directCounter;
        final LongCounter heapCounter;

        private UnpooledByteBufAllocatorMetric() {
            this.directCounter = PlatformDependent.newLongCounter();
            this.heapCounter = PlatformDependent.newLongCounter();
        }

        public String toString() {
            return StringUtil.simpleClassName(this) + "(usedHeapMemory: " + usedHeapMemory() + "; usedDirectMemory: " + usedDirectMemory() + ')';
        }

        public long usedDirectMemory() {
            return this.directCounter.value();
        }

        public long usedHeapMemory() {
            return this.heapCounter.value();
        }

        /* synthetic */ UnpooledByteBufAllocatorMetric(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    public UnpooledByteBufAllocator(boolean z10) {
        this(z10, false);
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public boolean isDirectBufferPooled() {
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class InstrumentedUnpooledDirectByteBuf extends UnpooledDirectByteBuf {
        InstrumentedUnpooledDirectByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i10, int i11) {
            super(unpooledByteBufAllocator, i10, i11);
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf
        protected ByteBuffer allocateDirect(int i10) {
            ByteBuffer byteBufferAllocateDirect = super.allocateDirect(i10);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(byteBufferAllocateDirect.capacity());
            return byteBufferAllocateDirect;
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf
        protected void freeDirect(ByteBuffer byteBuffer) {
            int iCapacity = byteBuffer.capacity();
            super.freeDirect(byteBuffer);
            ((UnpooledByteBufAllocator) alloc()).decrementDirect(iCapacity);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class InstrumentedUnpooledHeapByteBuf extends UnpooledHeapByteBuf {
        @Override // io.netty.buffer.UnpooledHeapByteBuf
        protected void freeArray(byte[] bArr) {
            int length = bArr.length;
            super.freeArray(bArr);
            ((UnpooledByteBufAllocator) alloc()).decrementHeap(length);
        }

        InstrumentedUnpooledHeapByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i10, int i11) {
            super(unpooledByteBufAllocator, i10, i11);
        }

        @Override // io.netty.buffer.UnpooledHeapByteBuf
        protected byte[] allocateArray(int i10) {
            byte[] bArrAllocateArray = super.allocateArray(i10);
            ((UnpooledByteBufAllocator) alloc()).incrementHeap(bArrAllocateArray.length);
            return bArrAllocateArray;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class InstrumentedUnpooledUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
        InstrumentedUnpooledUnsafeDirectByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i10, int i11) {
            super(unpooledByteBufAllocator, i10, i11);
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf
        protected ByteBuffer allocateDirect(int i10) {
            ByteBuffer byteBufferAllocateDirect = super.allocateDirect(i10);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(byteBufferAllocateDirect.capacity());
            return byteBufferAllocateDirect;
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf
        protected void freeDirect(ByteBuffer byteBuffer) {
            int iCapacity = byteBuffer.capacity();
            super.freeDirect(byteBuffer);
            ((UnpooledByteBufAllocator) alloc()).decrementDirect(iCapacity);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class InstrumentedUnpooledUnsafeHeapByteBuf extends UnpooledUnsafeHeapByteBuf {
        @Override // io.netty.buffer.UnpooledHeapByteBuf
        protected void freeArray(byte[] bArr) {
            int length = bArr.length;
            super.freeArray(bArr);
            ((UnpooledByteBufAllocator) alloc()).decrementHeap(length);
        }

        InstrumentedUnpooledUnsafeHeapByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i10, int i11) {
            super(unpooledByteBufAllocator, i10, i11);
        }

        @Override // io.netty.buffer.UnpooledUnsafeHeapByteBuf, io.netty.buffer.UnpooledHeapByteBuf
        protected byte[] allocateArray(int i10) {
            byte[] bArrAllocateArray = super.allocateArray(i10);
            ((UnpooledByteBufAllocator) alloc()).incrementHeap(bArrAllocateArray.length);
            return bArrAllocateArray;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf extends UnpooledUnsafeNoCleanerDirectByteBuf {
        InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator, int i10, int i11) {
            super(unpooledByteBufAllocator, i10, i11);
        }

        @Override // io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf, io.netty.buffer.UnpooledDirectByteBuf
        protected ByteBuffer allocateDirect(int i10) {
            ByteBuffer byteBufferAllocateDirect = super.allocateDirect(i10);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(byteBufferAllocateDirect.capacity());
            return byteBufferAllocateDirect;
        }

        @Override // io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf, io.netty.buffer.UnpooledDirectByteBuf
        protected void freeDirect(ByteBuffer byteBuffer) {
            int iCapacity = byteBuffer.capacity();
            super.freeDirect(byteBuffer);
            ((UnpooledByteBufAllocator) alloc()).decrementDirect(iCapacity);
        }

        @Override // io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf
        ByteBuffer reallocateDirect(ByteBuffer byteBuffer, int i10) {
            int iCapacity = byteBuffer.capacity();
            ByteBuffer byteBufferReallocateDirect = super.reallocateDirect(byteBuffer, i10);
            ((UnpooledByteBufAllocator) alloc()).incrementDirect(byteBufferReallocateDirect.capacity() - iCapacity);
            return byteBufferReallocateDirect;
        }
    }

    public UnpooledByteBufAllocator(boolean z10, boolean z11) {
        this(z10, z11, PlatformDependent.useDirectBufferNoCleaner());
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer(int i10) {
        CompositeByteBuf compositeByteBuf = new CompositeByteBuf(this, true, i10);
        return this.disableLeakDetector ? compositeByteBuf : AbstractByteBufAllocator.toLeakAwareBuffer(compositeByteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer(int i10) {
        CompositeByteBuf compositeByteBuf = new CompositeByteBuf(this, false, i10);
        return this.disableLeakDetector ? compositeByteBuf : AbstractByteBufAllocator.toLeakAwareBuffer(compositeByteBuf);
    }

    void decrementDirect(int i10) {
        this.metric.directCounter.add(-i10);
    }

    void decrementHeap(int i10) {
        this.metric.heapCounter.add(-i10);
    }

    void incrementDirect(int i10) {
        this.metric.directCounter.add(i10);
    }

    void incrementHeap(int i10) {
        this.metric.heapCounter.add(i10);
    }

    public UnpooledByteBufAllocator(boolean z10, boolean z11, boolean z12) {
        super(z10);
        this.metric = new UnpooledByteBufAllocatorMetric(null);
        this.disableLeakDetector = z11;
        this.noCleaner = z12 && PlatformDependent.hasUnsafe() && PlatformDependent.hasDirectBufferNoCleanerConstructor();
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newDirectBuffer(int i10, int i11) {
        ByteBuf instrumentedUnpooledDirectByteBuf;
        if (PlatformDependent.hasUnsafe()) {
            if (this.noCleaner) {
                instrumentedUnpooledDirectByteBuf = new InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf(this, i10, i11);
            } else {
                instrumentedUnpooledDirectByteBuf = new InstrumentedUnpooledUnsafeDirectByteBuf(this, i10, i11);
            }
        } else {
            instrumentedUnpooledDirectByteBuf = new InstrumentedUnpooledDirectByteBuf(this, i10, i11);
        }
        if (this.disableLeakDetector) {
            return instrumentedUnpooledDirectByteBuf;
        }
        return AbstractByteBufAllocator.toLeakAwareBuffer(instrumentedUnpooledDirectByteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newHeapBuffer(int i10, int i11) {
        if (PlatformDependent.hasUnsafe()) {
            return new InstrumentedUnpooledUnsafeHeapByteBuf(this, i10, i11);
        }
        return new InstrumentedUnpooledHeapByteBuf(this, i10, i11);
    }
}
