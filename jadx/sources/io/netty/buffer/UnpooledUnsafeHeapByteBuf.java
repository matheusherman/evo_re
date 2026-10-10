package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class UnpooledUnsafeHeapByteBuf extends UnpooledHeapByteBuf {
    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i10) {
        checkIndex(i10, 4);
        return _getInt(i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i10) {
        checkIndex(i10, 4);
        return _getIntLE(i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i10) {
        checkIndex(i10, 2);
        return _getShort(i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i10) {
        checkIndex(i10, 2);
        return _getShortLE(i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i10, int i11) {
        checkIndex(i10, 4);
        _setInt(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i10, int i11) {
        checkIndex(i10, 3);
        _setMedium(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i10, int i11) {
        checkIndex(i10, 2);
        _setShort(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i10) {
        return UnsafeByteBufUtil.getByte(this.array, i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i10) {
        return UnsafeByteBufUtil.getInt(this.array, i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i10) {
        return UnsafeByteBufUtil.getIntLE(this.array, i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i10) {
        return UnsafeByteBufUtil.getLong(this.array, i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i10) {
        return UnsafeByteBufUtil.getShort(this.array, i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i10) {
        return UnsafeByteBufUtil.getShortLE(this.array, i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i10, int i11) {
        UnsafeByteBufUtil.setByte(this.array, i10, i11);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i10, int i11) {
        UnsafeByteBufUtil.setInt(this.array, i10, i11);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i10, int i11) {
        UnsafeByteBufUtil.setMedium(this.array, i10, i11);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i10, int i11) {
        UnsafeByteBufUtil.setShort(this.array, i10, i11);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i10) {
        checkIndex(i10, 8);
        return _getLong(i10);
    }

    public UnpooledUnsafeHeapByteBuf(ByteBufAllocator byteBufAllocator, int i10, int i11) {
        super(byteBufAllocator, i10, i11);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf
    protected byte[] allocateArray(int i10) {
        return PlatformDependent.allocateUninitializedArray(i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        checkIndex(i10);
        return _getByte(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    @Deprecated
    protected SwappedByteBuf newSwappedByteBuf() {
        if (PlatformDependent.isUnaligned()) {
            return new UnsafeHeapSwappedByteBuf(this);
        }
        return super.newSwappedByteBuf();
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i10, int i11) {
        checkIndex(i10);
        _setByte(i10, i11);
        return this;
    }
}
