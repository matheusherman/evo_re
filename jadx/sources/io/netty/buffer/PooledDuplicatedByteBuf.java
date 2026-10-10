package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectPool;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class PooledDuplicatedByteBuf extends AbstractPooledDerivedByteBuf {
    private static final ObjectPool<PooledDuplicatedByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PooledDuplicatedByteBuf>() { // from class: io.netty.buffer.PooledDuplicatedByteBuf.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.internal.ObjectPool.ObjectCreator
        public PooledDuplicatedByteBuf newObject(ObjectPool.Handle<PooledDuplicatedByteBuf> handle) {
            return new PooledDuplicatedByteBuf(handle);
        }
    });

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return unwrap().capacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        unwrap().getBytes(i10, byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        unwrap().setBytes(i10, bArr, i11, i12);
        return this;
    }

    private PooledDuplicatedByteBuf(ObjectPool.Handle<PooledDuplicatedByteBuf> handle) {
        super(handle);
    }

    static PooledDuplicatedByteBuf newInstance(AbstractByteBuf abstractByteBuf, ByteBuf byteBuf, int i10, int i11) {
        PooledDuplicatedByteBuf pooledDuplicatedByteBuf = RECYCLER.get();
        pooledDuplicatedByteBuf.init(abstractByteBuf, byteBuf, i10, i11, abstractByteBuf.maxCapacity());
        pooledDuplicatedByteBuf.markReaderIndex();
        pooledDuplicatedByteBuf.markWriterIndex();
        return pooledDuplicatedByteBuf;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i10) {
        unwrap().capacity(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        unwrap().getBytes(i10, bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        unwrap().setBytes(i10, byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i10) {
        return unwrap()._getByte(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i10) {
        return unwrap()._getInt(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i10) {
        return unwrap()._getIntLE(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i10) {
        return unwrap()._getLong(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i10) {
        return unwrap()._getShort(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i10) {
        return unwrap()._getShortLE(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i10, int i11) {
        unwrap()._setByte(i10, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i10, int i11) {
        unwrap()._setInt(i10, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i10, int i11) {
        unwrap()._setMedium(i10, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i10, int i11) {
        unwrap()._setShort(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return unwrap().arrayOffset();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return duplicate0().setIndex(readerIndex(), writerIndex());
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(int i10, int i11, ByteProcessor byteProcessor) {
        return unwrap().forEachByte(i10, i11, byteProcessor);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        return unwrap().getByte(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, GatheringByteChannel gatheringByteChannel, int i11) {
        return unwrap().getBytes(i10, gatheringByteChannel, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i10) {
        return unwrap().getInt(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i10) {
        return unwrap().getIntLE(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i10) {
        return unwrap().getLong(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i10) {
        return unwrap().getShort(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i10) {
        return unwrap().getShortLE(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return unwrap().memoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i10, int i11) {
        return unwrap().nioBuffer(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i10, int i11) {
        return unwrap().nioBuffers(i10, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return newInstance(unwrap(), this, readerIndex(), writerIndex());
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public ByteBuf retainedSlice(int i10, int i11) {
        return PooledSlicedByteBuf.newInstance(unwrap(), this, i10, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i10, int i11) {
        unwrap().setByte(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, InputStream inputStream, int i11) {
        return unwrap().setBytes(i10, inputStream, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i10, int i11) {
        unwrap().setInt(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i10, int i11) {
        unwrap().setMedium(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i10, int i11) {
        unwrap().setShort(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, ScatteringByteChannel scatteringByteChannel, int i11) {
        return unwrap().setBytes(i10, scatteringByteChannel, i11);
    }
}
