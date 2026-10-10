package io.netty.buffer;

import io.netty.util.ByteProcessor;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Deprecated
public class DuplicatedByteBuf extends AbstractDerivedByteBuf {
    private final ByteBuf buffer;

    public DuplicatedByteBuf(ByteBuf byteBuf) {
        this(byteBuf, byteBuf.readerIndex(), byteBuf.writerIndex());
    }

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

    DuplicatedByteBuf(ByteBuf byteBuf, int i10, int i11) {
        super(byteBuf.maxCapacity());
        if (byteBuf instanceof DuplicatedByteBuf) {
            this.buffer = ((DuplicatedByteBuf) byteBuf).buffer;
        } else if (byteBuf instanceof AbstractPooledDerivedByteBuf) {
            this.buffer = byteBuf.unwrap();
        } else {
            this.buffer = byteBuf;
        }
        setIndex(i10, i11);
        markReaderIndex();
        markWriterIndex();
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

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return this.buffer;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i10) {
        return unwrap().getByte(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i10) {
        return unwrap().getInt(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i10) {
        return unwrap().getIntLE(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i10) {
        return unwrap().getLong(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i10) {
        return unwrap().getShort(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i10) {
        return unwrap().getShortLE(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i10, int i11) {
        unwrap().setByte(i10, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i10, int i11) {
        unwrap().setInt(i10, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i10, int i11) {
        unwrap().setMedium(i10, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i10, int i11) {
        unwrap().setShort(i10, i11);
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
        return unwrap().arrayOffset();
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
        return unwrap().memoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return unwrap().nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i10, int i11) {
        return unwrap().nioBuffers(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    @Deprecated
    public ByteOrder order() {
        return unwrap().order();
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

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i10, int i11) {
        return unwrap().slice(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, ScatteringByteChannel scatteringByteChannel, int i11) {
        return unwrap().setBytes(i10, scatteringByteChannel, i11);
    }
}
