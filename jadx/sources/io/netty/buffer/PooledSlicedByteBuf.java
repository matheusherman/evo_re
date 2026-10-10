package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectPool;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class PooledSlicedByteBuf extends AbstractPooledDerivedByteBuf {
    private static final ObjectPool<PooledSlicedByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PooledSlicedByteBuf>() { // from class: io.netty.buffer.PooledSlicedByteBuf.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.internal.ObjectPool.ObjectCreator
        public PooledSlicedByteBuf newObject(ObjectPool.Handle<PooledSlicedByteBuf> handle) {
            return new PooledSlicedByteBuf(handle);
        }
    });
    int adjustment;

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return maxCapacity();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        checkIndex0(i10, 1);
        return unwrap().getByte(idx(i10));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkIndex0(i10, i12);
        unwrap().getBytes(idx(i10), byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i10) {
        checkIndex0(i10, 4);
        return unwrap().getInt(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i10) {
        checkIndex0(i10, 4);
        return unwrap().getIntLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i10) {
        checkIndex0(i10, 2);
        return unwrap().getShort(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i10) {
        checkIndex0(i10, 2);
        return unwrap().getShortLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i10, int i11) {
        checkIndex0(i10, 1);
        unwrap().setByte(idx(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        checkIndex0(i10, i12);
        unwrap().setBytes(idx(i10), bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i10, int i11) {
        checkIndex0(i10, 4);
        unwrap().setInt(idx(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i10, int i11) {
        checkIndex0(i10, 3);
        unwrap().setMedium(idx(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i10, int i11) {
        checkIndex0(i10, 2);
        unwrap().setShort(idx(i10), i11);
        return this;
    }

    private PooledSlicedByteBuf(ObjectPool.Handle<PooledSlicedByteBuf> handle) {
        super(handle);
    }

    private int idx(int i10) {
        return i10 + this.adjustment;
    }

    private static PooledSlicedByteBuf newInstance0(AbstractByteBuf abstractByteBuf, ByteBuf byteBuf, int i10, int i11) {
        PooledSlicedByteBuf pooledSlicedByteBuf = RECYCLER.get();
        pooledSlicedByteBuf.init(abstractByteBuf, byteBuf, 0, i11, i11);
        pooledSlicedByteBuf.discardMarks();
        pooledSlicedByteBuf.adjustment = i10;
        return pooledSlicedByteBuf;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i10) {
        throw new UnsupportedOperationException("sliced buffer");
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i10) {
        checkIndex0(i10, 8);
        return unwrap().getLong(idx(i10));
    }

    static PooledSlicedByteBuf newInstance(AbstractByteBuf abstractByteBuf, ByteBuf byteBuf, int i10, int i11) {
        AbstractUnpooledSlicedByteBuf.checkSliceOutOfBounds(i10, i11, abstractByteBuf);
        return newInstance0(abstractByteBuf, byteBuf, i10, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i10) {
        return unwrap()._getByte(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i10) {
        return unwrap()._getInt(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i10) {
        return unwrap()._getIntLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i10) {
        return unwrap()._getLong(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i10) {
        return unwrap()._getShort(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i10) {
        return unwrap()._getShortLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i10, int i11) {
        unwrap()._setByte(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i10, int i11) {
        unwrap()._setInt(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i10, int i11) {
        unwrap()._setMedium(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i10, int i11) {
        unwrap()._setShort(idx(i10), i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return idx(unwrap().arrayOffset());
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return duplicate0().setIndex(idx(readerIndex()), idx(writerIndex()));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(int i10, int i11, ByteProcessor byteProcessor) {
        checkIndex0(i10, i11);
        int iForEachByte = unwrap().forEachByte(idx(i10), i11, byteProcessor);
        int i12 = this.adjustment;
        if (iForEachByte < i12) {
            return -1;
        }
        return iForEachByte - i12;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        checkIndex0(i10, i12);
        unwrap().getBytes(idx(i10), bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return unwrap().memoryAddress() + ((long) this.adjustment);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i10, int i11) {
        checkIndex0(i10, i11);
        return unwrap().nioBuffer(idx(i10), i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i10, int i11) {
        checkIndex0(i10, i11);
        return unwrap().nioBuffers(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return PooledDuplicatedByteBuf.newInstance(unwrap(), this, idx(readerIndex()), idx(writerIndex()));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public ByteBuf retainedSlice(int i10, int i11) {
        checkIndex0(i10, i11);
        return newInstance0(unwrap(), this, idx(i10), i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkIndex0(i10, i12);
        unwrap().setBytes(idx(i10), byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.AbstractPooledDerivedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i10, int i11) {
        checkIndex0(i10, i11);
        return super.slice(idx(i10), i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, GatheringByteChannel gatheringByteChannel, int i11) {
        checkIndex0(i10, i11);
        return unwrap().getBytes(idx(i10), gatheringByteChannel, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, InputStream inputStream, int i11) {
        checkIndex0(i10, i11);
        return unwrap().setBytes(idx(i10), inputStream, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, ScatteringByteChannel scatteringByteChannel, int i11) {
        checkIndex0(i10, i11);
        return unwrap().setBytes(idx(i10), scatteringByteChannel, i11);
    }
}
