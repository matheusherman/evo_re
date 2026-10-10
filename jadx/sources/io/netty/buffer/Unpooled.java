package io.netty.buffer;

import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class Unpooled {
    private static final ByteBufAllocator ALLOC;
    public static final ByteOrder BIG_ENDIAN;
    public static final ByteBuf EMPTY_BUFFER;
    public static final ByteOrder LITTLE_ENDIAN;

    public static ByteBuf wrappedBuffer(byte[] bArr) {
        return bArr.length == 0 ? EMPTY_BUFFER : new UnpooledHeapByteBuf(ALLOC, bArr, bArr.length);
    }

    static {
        UnpooledByteBufAllocator unpooledByteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
        ALLOC = unpooledByteBufAllocator;
        BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        EMPTY_BUFFER = unpooledByteBufAllocator.buffer(0, 0);
    }

    public static ByteBuf buffer(int i10) {
        return ALLOC.heapBuffer(i10);
    }

    public static ByteBuf directBuffer(int i10) {
        return ALLOC.directBuffer(i10);
    }

    public static ByteBuf unreleasableBuffer(ByteBuf byteBuf) {
        return new UnreleasableByteBuf(byteBuf);
    }

    @Deprecated
    public static ByteBuf unmodifiableBuffer(ByteBuf byteBuf) {
        ByteOrder byteOrderOrder = byteBuf.order();
        ByteOrder byteOrder = BIG_ENDIAN;
        if (byteOrderOrder == byteOrder) {
            return new ReadOnlyByteBuf(byteBuf);
        }
        return new ReadOnlyByteBuf(byteBuf.order(byteOrder)).order(LITTLE_ENDIAN);
    }

    public static ByteBuf wrappedBuffer(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return EMPTY_BUFFER;
        }
        if (i10 == 0 && i11 == bArr.length) {
            return wrappedBuffer(bArr);
        }
        return wrappedBuffer(bArr).slice(i10, i11);
    }
}
