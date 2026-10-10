package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.internal.MathUtil;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class AbstractUnpooledSlicedByteBuf extends AbstractDerivedByteBuf {
    private final int adjustment;
    private final ByteBuf buffer;

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

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i10) {
        throw new UnsupportedOperationException("sliced buffer");
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i10) {
        checkIndex0(i10, 8);
        return unwrap().getLong(idx(i10));
    }

    final int idx(int i10) {
        return i10 + this.adjustment;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return this.buffer;
    }

    AbstractUnpooledSlicedByteBuf(ByteBuf byteBuf, int i10, int i11) {
        super(i11);
        checkSliceOutOfBounds(i10, i11, byteBuf);
        if (byteBuf instanceof AbstractUnpooledSlicedByteBuf) {
            AbstractUnpooledSlicedByteBuf abstractUnpooledSlicedByteBuf = (AbstractUnpooledSlicedByteBuf) byteBuf;
            this.buffer = abstractUnpooledSlicedByteBuf.buffer;
            this.adjustment = abstractUnpooledSlicedByteBuf.adjustment + i10;
        } else if (byteBuf instanceof DuplicatedByteBuf) {
            this.buffer = byteBuf.unwrap();
            this.adjustment = i10;
        } else {
            this.buffer = byteBuf;
            this.adjustment = i10;
        }
        initLength(i11);
        writerIndex(i11);
    }

    static void checkSliceOutOfBounds(int i10, int i11, ByteBuf byteBuf) {
        if (!MathUtil.isOutOfBounds(i10, i11, byteBuf.capacity())) {
            return;
        }
        throw new IndexOutOfBoundsException(byteBuf + ".slice(" + i10 + ", " + i11 + ')');
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return unwrap().alloc();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        return unwrap().array();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return idx(unwrap().arrayOffset());
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return unwrap().duplicate().setIndex(idx(readerIndex()), idx(writerIndex()));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(int i10, int i11, ByteProcessor byteProcessor) {
        checkIndex0(i10, i11);
        int iForEachByte = unwrap().forEachByte(idx(i10), i11, byteProcessor);
        int i12 = this.adjustment;
        if (iForEachByte >= i12) {
            return iForEachByte - i12;
        }
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        checkIndex0(i10, i12);
        unwrap().getBytes(idx(i10), bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return unwrap().hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return unwrap().hasMemoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return unwrap().isDirect();
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return unwrap().memoryAddress() + ((long) this.adjustment);
    }

    @Override // io.netty.buffer.AbstractDerivedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i10, int i11) {
        checkIndex0(i10, i11);
        return unwrap().nioBuffer(idx(i10), i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return unwrap().nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i10, int i11) {
        checkIndex0(i10, i11);
        return unwrap().nioBuffers(idx(i10), i11);
    }

    @Override // io.netty.buffer.ByteBuf
    @Deprecated
    public ByteOrder order() {
        return unwrap().order();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkIndex0(i10, i12);
        unwrap().setBytes(idx(i10), byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i10, int i11) {
        checkIndex0(i10, i11);
        return unwrap().slice(idx(i10), i11);
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

    void initLength(int i10) {
    }
}
