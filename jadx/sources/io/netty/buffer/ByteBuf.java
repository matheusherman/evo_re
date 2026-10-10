package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.ReferenceCounted;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class ByteBuf implements ReferenceCounted, Comparable<ByteBuf> {
    public abstract ByteBufAllocator alloc();

    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract ByteBuf asReadOnly();

    public abstract int capacity();

    public abstract ByteBuf capacity(int i10);

    public abstract ByteBuf clear();

    @Override // java.lang.Comparable
    public abstract int compareTo(ByteBuf byteBuf);

    public abstract ByteBuf discardSomeReadBytes();

    public abstract ByteBuf duplicate();

    public abstract ByteBuf ensureWritable(int i10);

    public abstract boolean equals(Object obj);

    public abstract int forEachByte(int i10, int i11, ByteProcessor byteProcessor);

    public abstract int forEachByte(ByteProcessor byteProcessor);

    public abstract byte getByte(int i10);

    public abstract int getBytes(int i10, GatheringByteChannel gatheringByteChannel, int i11);

    public abstract ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12);

    public abstract ByteBuf getBytes(int i10, byte[] bArr);

    public abstract ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12);

    public abstract int getInt(int i10);

    public abstract int getIntLE(int i10);

    public abstract long getLong(int i10);

    public abstract short getShort(int i10);

    public abstract short getShortLE(int i10);

    public abstract short getUnsignedByte(int i10);

    public abstract long getUnsignedInt(int i10);

    public abstract long getUnsignedIntLE(int i10);

    public abstract boolean hasArray();

    public abstract boolean hasMemoryAddress();

    public abstract int hashCode();

    public abstract ByteBuffer internalNioBuffer(int i10, int i11);

    public boolean isContiguous() {
        return false;
    }

    public abstract boolean isDirect();

    public abstract boolean isReadOnly();

    public abstract boolean isReadable();

    public abstract boolean isReadable(int i10);

    public abstract boolean isWritable();

    public abstract int maxCapacity();

    public abstract int maxWritableBytes();

    public abstract long memoryAddress();

    public abstract ByteBuffer nioBuffer();

    public abstract ByteBuffer nioBuffer(int i10, int i11);

    public abstract int nioBufferCount();

    public abstract ByteBuffer[] nioBuffers();

    public abstract ByteBuffer[] nioBuffers(int i10, int i11);

    @Deprecated
    public abstract ByteBuf order(ByteOrder byteOrder);

    @Deprecated
    public abstract ByteOrder order();

    public abstract int readBytes(GatheringByteChannel gatheringByteChannel, int i10);

    public abstract ByteBuf readBytes(int i10);

    public abstract ByteBuf readBytes(ByteBuf byteBuf, int i10);

    public abstract int readInt();

    public abstract ByteBuf readRetainedSlice(int i10);

    public abstract short readShort();

    public abstract ByteBuf readSlice(int i10);

    public abstract short readUnsignedByte();

    public abstract long readUnsignedInt();

    public abstract int readUnsignedShort();

    public abstract int readableBytes();

    public abstract int readerIndex();

    public abstract ByteBuf readerIndex(int i10);

    @Override // io.netty.util.ReferenceCounted
    public abstract ByteBuf retain();

    public abstract ByteBuf retainedDuplicate();

    public abstract ByteBuf setByte(int i10, int i11);

    public abstract int setBytes(int i10, InputStream inputStream, int i11);

    public abstract int setBytes(int i10, ScatteringByteChannel scatteringByteChannel, int i11);

    public abstract ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12);

    public abstract ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12);

    public abstract int setCharSequence(int i10, CharSequence charSequence, Charset charset);

    public abstract ByteBuf setIndex(int i10, int i11);

    public abstract ByteBuf setInt(int i10, int i11);

    public abstract ByteBuf setMedium(int i10, int i11);

    public abstract ByteBuf setShort(int i10, int i11);

    public abstract ByteBuf skipBytes(int i10);

    public abstract ByteBuf slice(int i10, int i11);

    public abstract String toString();

    public abstract String toString(int i10, int i11, Charset charset);

    @Override // io.netty.util.ReferenceCounted
    public abstract ByteBuf touch(Object obj);

    public abstract ByteBuf unwrap();

    public abstract int writableBytes();

    public abstract ByteBuf writeByte(int i10);

    public abstract int writeBytes(InputStream inputStream, int i10);

    public abstract int writeBytes(ScatteringByteChannel scatteringByteChannel, int i10);

    public abstract ByteBuf writeBytes(ByteBuf byteBuf);

    public abstract ByteBuf writeBytes(ByteBuf byteBuf, int i10, int i11);

    public abstract ByteBuf writeBytes(byte[] bArr);

    public abstract ByteBuf writeBytes(byte[] bArr, int i10, int i11);

    public abstract int writeCharSequence(CharSequence charSequence, Charset charset);

    public abstract ByteBuf writeInt(int i10);

    public abstract ByteBuf writeMedium(int i10);

    public abstract ByteBuf writeShort(int i10);

    public abstract int writerIndex();

    public abstract ByteBuf writerIndex(int i10);

    boolean isAccessible() {
        if (refCnt() != 0) {
            return true;
        }
        return false;
    }

    public int maxFastWritableBytes() {
        return writableBytes();
    }
}
