package io.netty.buffer;

import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.PlatformDependent;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class PooledHeapByteBuf extends PooledByteBuf<byte[]> {
    private static final ObjectPool<PooledHeapByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PooledHeapByteBuf>() { // from class: io.netty.buffer.PooledHeapByteBuf.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.internal.ObjectPool.ObjectCreator
        public PooledHeapByteBuf newObject(ObjectPool.Handle<PooledHeapByteBuf> handle) {
            return new PooledHeapByteBuf(handle, 0);
        }
    });

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkDstIndex(i10, i12, i11, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory((byte[]) this.memory, idx(i10), ((long) i11) + byteBuf.memoryAddress(), i12);
            return this;
        }
        if (byteBuf.hasArray()) {
            getBytes(i10, byteBuf.array(), byteBuf.arrayOffset() + i11, i12);
            return this;
        }
        byteBuf.setBytes(i11, (byte[]) this.memory, idx(i10), i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasArray() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasMemoryAddress() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkSrcIndex(i10, i12, i11, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(byteBuf.memoryAddress() + ((long) i11), (byte[]) this.memory, idx(i10), i12);
            return this;
        }
        if (byteBuf.hasArray()) {
            setBytes(i10, byteBuf.array(), byteBuf.arrayOffset() + i11, i12);
            return this;
        }
        byteBuf.getBytes(i11, (byte[]) this.memory, idx(i10), i12);
        return this;
    }

    static PooledHeapByteBuf newInstance(int i10) {
        PooledHeapByteBuf pooledHeapByteBuf = RECYCLER.get();
        pooledHeapByteBuf.reuse(i10);
        return pooledHeapByteBuf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i10) {
        return HeapByteBufUtil.getByte((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i10) {
        return HeapByteBufUtil.getInt((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i10) {
        return HeapByteBufUtil.getIntLE((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i10) {
        return HeapByteBufUtil.getLong((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i10) {
        return HeapByteBufUtil.getShort((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i10) {
        return HeapByteBufUtil.getShortLE((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i10, int i11) {
        HeapByteBufUtil.setByte((byte[]) this.memory, idx(i10), i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i10, int i11) {
        HeapByteBufUtil.setInt((byte[]) this.memory, idx(i10), i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i10, int i11) {
        HeapByteBufUtil.setMedium((byte[]) this.memory, idx(i10), i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i10, int i11) {
        HeapByteBufUtil.setShort((byte[]) this.memory, idx(i10), i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int arrayOffset() {
        return this.offset;
    }

    @Override // io.netty.buffer.ByteBuf
    public final long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledByteBuf
    public final ByteBuffer newInternalNioBuffer(byte[] bArr) {
        return ByteBuffer.wrap(bArr);
    }

    PooledHeapByteBuf(ObjectPool.Handle<? extends PooledHeapByteBuf> handle, int i10) {
        super(handle, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final byte[] array() {
        ensureAccessible();
        return (byte[]) this.memory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledByteBuf
    final ByteBuffer duplicateInternalNioBuffer(int i10, int i11) {
        checkIndex(i10, i11);
        return ByteBuffer.wrap((byte[]) this.memory, idx(i10), i11).slice();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        checkDstIndex(i10, i12, i11, bArr.length);
        System.arraycopy(this.memory, idx(i10), bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        checkSrcIndex(i10, i12, i11, bArr.length);
        System.arraycopy(bArr, i11, this.memory, idx(i10), i12);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final int setBytes(int i10, InputStream inputStream, int i11) {
        checkIndex(i10, i11);
        return inputStream.read((byte[]) this.memory, idx(i10), i11);
    }
}
