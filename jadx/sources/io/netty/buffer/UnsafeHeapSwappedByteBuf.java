package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class UnsafeHeapSwappedByteBuf extends AbstractUnsafeSwappedByteBuf {
    UnsafeHeapSwappedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
    }

    private static int idx(ByteBuf byteBuf, int i10) {
        return byteBuf.arrayOffset() + i10;
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected int _getInt(AbstractByteBuf abstractByteBuf, int i10) {
        return PlatformDependent.getInt(abstractByteBuf.array(), idx(abstractByteBuf, i10));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected long _getLong(AbstractByteBuf abstractByteBuf, int i10) {
        return PlatformDependent.getLong(abstractByteBuf.array(), idx(abstractByteBuf, i10));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected short _getShort(AbstractByteBuf abstractByteBuf, int i10) {
        return PlatformDependent.getShort(abstractByteBuf.array(), idx(abstractByteBuf, i10));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setInt(AbstractByteBuf abstractByteBuf, int i10, int i11) {
        PlatformDependent.putInt(abstractByteBuf.array(), idx(abstractByteBuf, i10), i11);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    protected void _setShort(AbstractByteBuf abstractByteBuf, int i10, short s10) {
        PlatformDependent.putShort(abstractByteBuf.array(), idx(abstractByteBuf, i10), s10);
    }
}
