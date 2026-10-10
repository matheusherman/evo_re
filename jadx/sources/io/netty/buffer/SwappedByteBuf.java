package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Deprecated
public class SwappedByteBuf extends ByteBuf {
    private final ByteBuf buf;
    private final ByteOrder order;

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.buf.capacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor) {
        return this.buf.forEachByte(byteProcessor);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        this.buf.getBytes(i10, byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable() {
        return this.buf.isReadable();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        return this.buf.nioBuffer().order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        ByteBuffer[] byteBufferArrNioBuffers = this.buf.nioBuffers();
        for (int i10 = 0; i10 < byteBufferArrNioBuffers.length; i10++) {
            byteBufferArrNioBuffers[i10] = byteBufferArrNioBuffers[i10].order(this.order);
        }
        return byteBufferArrNioBuffers;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return this.order;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int i10) {
        return this.buf.readBytes(i10).order(order());
    }

    @Override // io.netty.buffer.ByteBuf
    public int readerIndex() {
        return this.buf.readerIndex();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        this.buf.setBytes(i10, byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(int i10, int i11, Charset charset) {
        return this.buf.toString(i10, i11, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf) {
        this.buf.writeBytes(byteBuf);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writerIndex() {
        return this.buf.writerIndex();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.buf.alloc();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        return this.buf.array();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return this.buf.arrayOffset();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i10) {
        this.buf.capacity(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf clear() {
        this.buf.clear();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, java.lang.Comparable
    public int compareTo(ByteBuf byteBuf) {
        return ByteBufUtil.compare(this, byteBuf);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        this.buf.discardSomeReadBytes();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return this.buf.duplicate().order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int i10) {
        this.buf.ensureWritable(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean equals(Object obj) {
        if (obj instanceof ByteBuf) {
            return ByteBufUtil.equals(this, (ByteBuf) obj);
        }
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(int i10, int i11, ByteProcessor byteProcessor) {
        return this.buf.forEachByte(i10, i11, byteProcessor);
    }

    @Override // io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        return this.buf.getByte(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr) {
        this.buf.getBytes(i10, bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getInt(int i10) {
        return ByteBufUtil.swapInt(this.buf.getInt(i10));
    }

    @Override // io.netty.buffer.ByteBuf
    public int getIntLE(int i10) {
        return this.buf.getIntLE(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLong(int i10) {
        return ByteBufUtil.swapLong(this.buf.getLong(i10));
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShort(int i10) {
        return ByteBufUtil.swapShort(this.buf.getShort(i10));
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShortLE(int i10) {
        return this.buf.getShortLE(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getUnsignedByte(int i10) {
        return this.buf.getUnsignedByte(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return this.buf.hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return this.buf.hasMemoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public int hashCode() {
        return this.buf.hashCode();
    }

    @Override // io.netty.buffer.ByteBuf
    final boolean isAccessible() {
        return this.buf.isAccessible();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isContiguous() {
        return this.buf.isContiguous();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return this.buf.isDirect();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return this.buf.isReadOnly();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable(int i10) {
        return this.buf.isReadable(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable() {
        return this.buf.isWritable();
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return this.buf.maxCapacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxFastWritableBytes() {
        return this.buf.maxFastWritableBytes();
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxWritableBytes() {
        return this.buf.maxWritableBytes();
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return this.buf.memoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i10, int i11) {
        return this.buf.nioBuffer(i10, i11).order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.buf.nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        return ObjectUtil.checkNotNull(byteOrder, "endianness") == this.order ? this : this.buf;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i10) {
        this.buf.readBytes(byteBuf, i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readInt() {
        return ByteBufUtil.swapInt(this.buf.readInt());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i10) {
        return this.buf.readRetainedSlice(i10).order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShort() {
        return ByteBufUtil.swapShort(this.buf.readShort());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i10) {
        return this.buf.readSlice(i10).order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        return this.buf.readUnsignedByte();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readableBytes() {
        return this.buf.readableBytes();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readerIndex(int i10) {
        this.buf.readerIndex(i10);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.buf.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.buf.release();
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        this.buf.retain();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return this.buf.retainedDuplicate().order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i10, int i11) {
        this.buf.setByte(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        this.buf.setBytes(i10, bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setCharSequence(int i10, CharSequence charSequence, Charset charset) {
        return this.buf.setCharSequence(i10, charSequence, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIndex(int i10, int i11) {
        this.buf.setIndex(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i10, int i11) {
        this.buf.setInt(i10, ByteBufUtil.swapInt(i11));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i10, int i11) {
        this.buf.setMedium(i10, ByteBufUtil.swapMedium(i11));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i10, int i11) {
        this.buf.setShort(i10, ByteBufUtil.swapShort((short) i11));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int i10) {
        this.buf.skipBytes(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice(int i10, int i11) {
        return this.buf.slice(i10, i11).order(this.order);
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString() {
        return "Swapped(" + this.buf + ')';
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch(Object obj) {
        this.buf.touch(obj);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return this.buf;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writableBytes() {
        return this.buf.writableBytes();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int i10) {
        this.buf.writeByte(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i10, int i11) {
        this.buf.writeBytes(byteBuf, i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        return this.buf.writeCharSequence(charSequence, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int i10) {
        this.buf.writeInt(ByteBufUtil.swapInt(i10));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int i10) {
        this.buf.writeMedium(ByteBufUtil.swapMedium(i10));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int i10) {
        this.buf.writeShort(ByteBufUtil.swapShort((short) i10));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writerIndex(int i10) {
        this.buf.writerIndex(i10);
        return this;
    }

    public SwappedByteBuf(ByteBuf byteBuf) {
        this.buf = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "buf");
        ByteOrder byteOrderOrder = byteBuf.order();
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        if (byteOrderOrder == byteOrder) {
            this.order = ByteOrder.LITTLE_ENDIAN;
        } else {
            this.order = byteOrder;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return Unpooled.unmodifiableBuffer(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        this.buf.getBytes(i10, bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedInt(int i10) {
        return ((long) getInt(i10)) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int i10) {
        return ((long) getIntLE(i10)) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i10, int i11) {
        return nioBuffer(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i10) {
        return this.buf.readBytes(gatheringByteChannel, i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        return ((long) readInt()) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        return readShort() & 65535;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, InputStream inputStream, int i11) {
        return this.buf.setBytes(i10, inputStream, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr) {
        this.buf.writeBytes(bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, GatheringByteChannel gatheringByteChannel, int i11) {
        return this.buf.getBytes(i10, gatheringByteChannel, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i10, int i11) {
        ByteBuffer[] byteBufferArrNioBuffers = this.buf.nioBuffers(i10, i11);
        for (int i12 = 0; i12 < byteBufferArrNioBuffers.length; i12++) {
            byteBufferArrNioBuffers[i12] = byteBufferArrNioBuffers[i12].order(this.order);
        }
        return byteBufferArrNioBuffers;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, ScatteringByteChannel scatteringByteChannel, int i11) {
        return this.buf.setBytes(i10, scatteringByteChannel, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr, int i10, int i11) {
        this.buf.writeBytes(bArr, i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(InputStream inputStream, int i10) {
        return this.buf.writeBytes(inputStream, i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i10) {
        return this.buf.writeBytes(scatteringByteChannel, i10);
    }
}
