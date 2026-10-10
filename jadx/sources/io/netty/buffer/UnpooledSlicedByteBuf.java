package io.netty.buffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class UnpooledSlicedByteBuf extends AbstractUnpooledSlicedByteBuf {
    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public AbstractByteBuf unwrap() {
        return (AbstractByteBuf) super.unwrap();
    }

    UnpooledSlicedByteBuf(AbstractByteBuf abstractByteBuf, int i10, int i11) {
        super(abstractByteBuf, i10, i11);
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
    public int capacity() {
        return maxCapacity();
    }
}
