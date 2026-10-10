package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class AbstractUnsafeSwappedByteBuf extends SwappedByteBuf {
    private final boolean nativeByteOrder;
    private final AbstractByteBuf wrapped;

    protected abstract int _getInt(AbstractByteBuf abstractByteBuf, int i10);

    protected abstract long _getLong(AbstractByteBuf abstractByteBuf, int i10);

    protected abstract short _getShort(AbstractByteBuf abstractByteBuf, int i10);

    protected abstract void _setInt(AbstractByteBuf abstractByteBuf, int i10, int i11);

    protected abstract void _setShort(AbstractByteBuf abstractByteBuf, int i10, short s10);

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final int getInt(int i10) {
        this.wrapped.checkIndex(i10, 4);
        int i_getInt = _getInt(this.wrapped, i10);
        return this.nativeByteOrder ? i_getInt : Integer.reverseBytes(i_getInt);
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final long getLong(int i10) {
        this.wrapped.checkIndex(i10, 8);
        long j_getLong = _getLong(this.wrapped, i10);
        return this.nativeByteOrder ? j_getLong : Long.reverseBytes(j_getLong);
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final short getShort(int i10) {
        this.wrapped.checkIndex(i10, 2);
        short s_getShort = _getShort(this.wrapped, i10);
        return this.nativeByteOrder ? s_getShort : Short.reverseBytes(s_getShort);
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setInt(int i10, int i11) {
        this.wrapped.checkIndex(i10, 4);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        if (!this.nativeByteOrder) {
            i11 = Integer.reverseBytes(i11);
        }
        _setInt(abstractByteBuf, i10, i11);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf setShort(int i10, int i11) {
        this.wrapped.checkIndex(i10, 2);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        short sReverseBytes = (short) i11;
        if (!this.nativeByteOrder) {
            sReverseBytes = Short.reverseBytes(sReverseBytes);
        }
        _setShort(abstractByteBuf, i10, sReverseBytes);
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeInt(int i10) {
        this.wrapped.ensureWritable0(4);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int i11 = abstractByteBuf.writerIndex;
        if (!this.nativeByteOrder) {
            i10 = Integer.reverseBytes(i10);
        }
        _setInt(abstractByteBuf, i11, i10);
        this.wrapped.writerIndex += 4;
        return this;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final ByteBuf writeShort(int i10) {
        this.wrapped.ensureWritable0(2);
        AbstractByteBuf abstractByteBuf = this.wrapped;
        int i11 = abstractByteBuf.writerIndex;
        short sReverseBytes = (short) i10;
        if (!this.nativeByteOrder) {
            sReverseBytes = Short.reverseBytes(sReverseBytes);
        }
        _setShort(abstractByteBuf, i11, sReverseBytes);
        this.wrapped.writerIndex += 2;
        return this;
    }

    AbstractUnsafeSwappedByteBuf(AbstractByteBuf abstractByteBuf) {
        boolean z10;
        super(abstractByteBuf);
        this.wrapped = abstractByteBuf;
        boolean z11 = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER;
        if (order() == ByteOrder.BIG_ENDIAN) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.nativeByteOrder = z11 == z10;
    }

    @Override // io.netty.buffer.SwappedByteBuf, io.netty.buffer.ByteBuf
    public final long getUnsignedInt(int i10) {
        return ((long) getInt(i10)) & 4294967295L;
    }
}
