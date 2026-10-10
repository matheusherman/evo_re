package io.netty.buffer;

import io.netty.util.internal.ObjectPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class PooledByteBuf<T> extends AbstractReferenceCountedByteBuf {
    private ByteBufAllocator allocator;
    PoolThreadCache cache;
    protected PoolChunk<T> chunk;
    protected long handle;
    protected int length;
    int maxLength;
    protected T memory;
    protected int offset;
    private final ObjectPool.Handle<PooledByteBuf<T>> recyclerHandle;
    ByteBuffer tmpNioBuf;

    @Override // io.netty.buffer.ByteBuf
    public final int capacity() {
        return this.length;
    }

    void initUnpooled(PoolChunk<T> poolChunk, int i10) {
        init0(poolChunk, null, 0L, 0, i10, i10, null);
    }

    protected final ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer != null) {
            byteBuffer.clear();
            return byteBuffer;
        }
        ByteBuffer byteBufferNewInternalNioBuffer = newInternalNioBuffer(this.memory);
        this.tmpNioBuf = byteBufferNewInternalNioBuffer;
        return byteBufferNewInternalNioBuffer;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isContiguous() {
        return true;
    }

    protected abstract ByteBuffer newInternalNioBuffer(T t10);

    @Override // io.netty.buffer.ByteBuf
    public final int nioBufferCount() {
        return 1;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf unwrap() {
        return null;
    }

    private void recycle() {
        this.recyclerHandle.recycle(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBufAllocator alloc() {
        return this.allocator;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf capacity(int i10) {
        if (i10 == this.length) {
            ensureAccessible();
            return this;
        }
        checkNewCapacity(i10);
        PoolChunk<T> poolChunk = this.chunk;
        if (!poolChunk.unpooled) {
            if (i10 <= this.length) {
                int i11 = this.maxLength;
                if (i10 > (i11 >>> 1) && (i11 > 512 || i10 > i11 - 16)) {
                    this.length = i10;
                    trimIndicesToCapacity(i10);
                    return this;
                }
            } else if (i10 <= this.maxLength) {
                this.length = i10;
                return this;
            }
        }
        poolChunk.decrementPinnedMemory(this.maxLength);
        this.chunk.arena.reallocate(this, i10, true);
        return this;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    protected final void deallocate() {
        long j10 = this.handle;
        if (j10 >= 0) {
            this.handle = -1L;
            this.memory = null;
            this.chunk.decrementPinnedMemory(this.maxLength);
            PoolChunk<T> poolChunk = this.chunk;
            poolChunk.arena.free(poolChunk, this.tmpNioBuf, j10, this.maxLength, this.cache);
            this.tmpNioBuf = null;
            this.chunk = null;
            recycle();
        }
    }

    protected final int idx(int i10) {
        return this.offset + i10;
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxFastWritableBytes() {
        return Math.min(this.maxLength, maxCapacity()) - this.writerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected PooledByteBuf(ObjectPool.Handle<? extends PooledByteBuf<T>> handle, int i10) {
        super(i10);
        this.recyclerHandle = handle;
    }

    private void init0(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j10, int i10, int i11, int i12, PoolThreadCache poolThreadCache) {
        poolChunk.incrementPinnedMemory(i12);
        this.chunk = poolChunk;
        this.memory = poolChunk.memory;
        this.tmpNioBuf = byteBuffer;
        this.allocator = poolChunk.arena.parent;
        this.cache = poolThreadCache;
        this.handle = j10;
        this.offset = i10;
        this.length = i11;
        this.maxLength = i12;
    }

    final ByteBuffer _internalNioBuffer(int i10, int i11, boolean z10) {
        ByteBuffer byteBufferInternalNioBuffer;
        int iIdx = idx(i10);
        if (z10) {
            byteBufferInternalNioBuffer = newInternalNioBuffer(this.memory);
        } else {
            byteBufferInternalNioBuffer = internalNioBuffer();
        }
        byteBufferInternalNioBuffer.limit(i11 + iIdx).position(iIdx);
        return byteBufferInternalNioBuffer;
    }

    ByteBuffer duplicateInternalNioBuffer(int i10, int i11) {
        checkIndex(i10, i11);
        return _internalNioBuffer(i10, i11, true);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int getBytes(int i10, GatheringByteChannel gatheringByteChannel, int i11) {
        return gatheringByteChannel.write(duplicateInternalNioBuffer(i10, i11));
    }

    void init(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j10, int i10, int i11, int i12, PoolThreadCache poolThreadCache) {
        init0(poolChunk, byteBuffer, j10, i10, i11, i12, poolThreadCache);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer nioBuffer(int i10, int i11) {
        return duplicateInternalNioBuffer(i10, i11).slice();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer[] nioBuffers(int i10, int i11) {
        return new ByteBuffer[]{nioBuffer(i10, i11)};
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final int readBytes(GatheringByteChannel gatheringByteChannel, int i10) throws IOException {
        checkReadableBytes(i10);
        int iWrite = gatheringByteChannel.write(_internalNioBuffer(this.readerIndex, i10, false));
        this.readerIndex += iWrite;
        return iWrite;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf retainedDuplicate() {
        return PooledDuplicatedByteBuf.newInstance(this, this, readerIndex(), writerIndex());
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public final ByteBuf retainedSlice(int i10, int i11) {
        return PooledSlicedByteBuf.newInstance(this, this, i10, i11);
    }

    final void reuse(int i10) {
        maxCapacity(i10);
        resetRefCnt();
        setIndex0(0, 0);
        discardMarks();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int setBytes(int i10, ScatteringByteChannel scatteringByteChannel, int i11) {
        try {
            return scatteringByteChannel.read(internalNioBuffer(i10, i11));
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuffer internalNioBuffer(int i10, int i11) {
        checkIndex(i10, i11);
        return _internalNioBuffer(i10, i11, false);
    }
}
