package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class UnpooledUnsafeDirectByteBuf extends UnpooledDirectByteBuf {
    long memoryAddress;

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        UnsafeByteBufUtil.getBytes(this, addr(i10), i10, byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i10) {
        checkIndex(i10, 4);
        return _getInt(i10);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i10) {
        checkIndex(i10, 2);
        return _getShort(i10);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return true;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        UnsafeByteBufUtil.setBytes(this, addr(i10), i10, byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i10, int i11) {
        checkIndex(i10, 4);
        _setInt(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i10, int i11) {
        checkIndex(i10, 3);
        _setMedium(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i10, int i11) {
        checkIndex(i10, 2);
        _setShort(i10, i11);
        return this;
    }

    final long addr(int i10) {
        return this.memoryAddress + ((long) i10);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf
    void getBytes(int i10, byte[] bArr, int i11, int i12, boolean z10) {
        UnsafeByteBufUtil.getBytes(this, addr(i10), i10, bArr, i11, i12);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i10) {
        checkIndex(i10, 8);
        return _getLong(i10);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        UnsafeByteBufUtil.setBytes(this, addr(i10), i10, bArr, i11, i12);
        return this;
    }

    public UnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, int i10, int i11) {
        super(byteBufAllocator, i10, i11);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i10) {
        return UnsafeByteBufUtil.getByte(addr(i10));
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i10) {
        return UnsafeByteBufUtil.getInt(addr(i10));
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i10) {
        return UnsafeByteBufUtil.getIntLE(addr(i10));
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i10) {
        return UnsafeByteBufUtil.getLong(addr(i10));
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i10) {
        return UnsafeByteBufUtil.getShort(addr(i10));
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i10) {
        return UnsafeByteBufUtil.getShortLE(addr(i10));
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i10, int i11) {
        UnsafeByteBufUtil.setByte(addr(i10), i11);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i10, int i11) {
        UnsafeByteBufUtil.setInt(addr(i10), i11);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i10, int i11) {
        UnsafeByteBufUtil.setMedium(addr(i10), i11);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i10, int i11) {
        UnsafeByteBufUtil.setShort(addr(i10), i11);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        checkIndex(i10);
        return _getByte(i10);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf
    void getBytes(int i10, ByteBuffer byteBuffer, boolean z10) {
        UnsafeByteBufUtil.getBytes(this, addr(i10), i10, byteBuffer);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public long memoryAddress() {
        ensureAccessible();
        return this.memoryAddress;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected SwappedByteBuf newSwappedByteBuf() {
        if (PlatformDependent.isUnaligned()) {
            return new UnsafeDirectSwappedByteBuf(this);
        }
        return super.newSwappedByteBuf();
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i10, int i11) {
        checkIndex(i10);
        _setByte(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf
    final void setByteBuffer(ByteBuffer byteBuffer, boolean z10) {
        super.setByteBuffer(byteBuffer, z10);
        this.memoryAddress = PlatformDependent.directBufferAddress(byteBuffer);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf
    public ByteBuf setBytes(int i10, ByteBuffer byteBuffer) {
        UnsafeByteBufUtil.setBytes(this, addr(i10), i10, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public int setBytes(int i10, InputStream inputStream, int i11) {
        return UnsafeByteBufUtil.setBytes(this, addr(i10), i10, inputStream, i11);
    }
}
