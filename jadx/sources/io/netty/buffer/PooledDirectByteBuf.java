package io.netty.buffer;

import io.netty.util.internal.ObjectPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class PooledDirectByteBuf extends PooledByteBuf<ByteBuffer> {
    private static final ObjectPool<PooledDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PooledDirectByteBuf>() { // from class: io.netty.buffer.PooledDirectByteBuf.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.internal.ObjectPool.ObjectCreator
        public PooledDirectByteBuf newObject(ObjectPool.Handle<PooledDirectByteBuf> handle) {
            return new PooledDirectByteBuf(handle, 0);
        }
    });

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkDstIndex(i10, i12, i11, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            getBytes(i10, byteBuf.array(), byteBuf.arrayOffset() + i11, i12);
            return this;
        }
        if (byteBuf.nioBufferCount() <= 0) {
            byteBuf.setBytes(i11, this, i10, i12);
            return this;
        }
        ByteBuffer[] byteBufferArrNioBuffers = byteBuf.nioBuffers(i11, i12);
        for (ByteBuffer byteBuffer : byteBufferArrNioBuffers) {
            int iRemaining = byteBuffer.remaining();
            getBytes(i10, byteBuffer);
            i10 += iRemaining;
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkSrcIndex(i10, i12, i11, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            setBytes(i10, byteBuf.array(), byteBuf.arrayOffset() + i11, i12);
            return this;
        }
        if (byteBuf.nioBufferCount() <= 0) {
            byteBuf.getBytes(i11, this, i10, i12);
            return this;
        }
        ByteBuffer[] byteBufferArrNioBuffers = byteBuf.nioBuffers(i11, i12);
        for (ByteBuffer byteBuffer : byteBufferArrNioBuffers) {
            int iRemaining = byteBuffer.remaining();
            setBytes(i10, byteBuffer);
            i10 += iRemaining;
        }
        return this;
    }

    private PooledDirectByteBuf(ObjectPool.Handle<PooledDirectByteBuf> handle, int i10) {
        super(handle, i10);
    }

    static PooledDirectByteBuf newInstance(int i10) {
        PooledDirectByteBuf pooledDirectByteBuf = RECYCLER.get();
        pooledDirectByteBuf.reuse(i10);
        return pooledDirectByteBuf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i10) {
        return ((ByteBuffer) this.memory).get(idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i10) {
        return ((ByteBuffer) this.memory).getInt(idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i10) {
        return ((ByteBuffer) this.memory).getLong(idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i10) {
        return ((ByteBuffer) this.memory).getShort(idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i10, int i11) {
        ((ByteBuffer) this.memory).put(idx(i10), (byte) i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i10, int i11) {
        ((ByteBuffer) this.memory).putInt(idx(i10), i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i10, int i11) {
        ((ByteBuffer) this.memory).putShort(idx(i10), (short) i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.PooledByteBuf
    public ByteBuffer newInternalNioBuffer(ByteBuffer byteBuffer) {
        return byteBuffer.duplicate();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i10) {
        return ByteBufUtil.swapInt(_getInt(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i10) {
        return ByteBufUtil.swapShort(_getShort(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i10, int i11) {
        int iIdx = idx(i10);
        ((ByteBuffer) this.memory).put(iIdx, (byte) (i11 >>> 16));
        ((ByteBuffer) this.memory).put(iIdx + 1, (byte) (i11 >>> 8));
        ((ByteBuffer) this.memory).put(iIdx + 2, (byte) i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        checkDstIndex(i10, i12, i11, bArr.length);
        _internalNioBuffer(i10, i12, true).get(bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        checkSrcIndex(i10, i12, i11, bArr.length);
        _internalNioBuffer(i10, i12, false).put(bArr, i11, i12);
        return this;
    }

    public ByteBuf getBytes(int i10, ByteBuffer byteBuffer) {
        byteBuffer.put(duplicateInternalNioBuffer(i10, byteBuffer.remaining()));
        return this;
    }

    public ByteBuf setBytes(int i10, ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        checkIndex(i10, iRemaining);
        ByteBuffer byteBufferInternalNioBuffer = internalNioBuffer();
        if (byteBuffer == byteBufferInternalNioBuffer) {
            byteBuffer = byteBuffer.duplicate();
        }
        int iIdx = idx(i10);
        byteBufferInternalNioBuffer.limit(iRemaining + iIdx).position(iIdx);
        byteBufferInternalNioBuffer.put(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, InputStream inputStream, int i11) throws IOException {
        checkIndex(i10, i11);
        byte[] bArrThreadLocalTempArray = ByteBufUtil.threadLocalTempArray(i11);
        int i12 = inputStream.read(bArrThreadLocalTempArray, 0, i11);
        if (i12 <= 0) {
            return i12;
        }
        ByteBuffer byteBufferInternalNioBuffer = internalNioBuffer();
        byteBufferInternalNioBuffer.position(idx(i10));
        byteBufferInternalNioBuffer.put(bArrThreadLocalTempArray, 0, i12);
        return i12;
    }
}
