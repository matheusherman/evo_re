package io.netty.buffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface ByteBufAllocator {
    public static final ByteBufAllocator DEFAULT = ByteBufUtil.DEFAULT_ALLOCATOR;

    ByteBuf buffer(int i10);

    ByteBuf buffer(int i10, int i11);

    int calculateNewCapacity(int i10, int i11);

    CompositeByteBuf compositeBuffer(int i10);

    ByteBuf directBuffer(int i10);

    ByteBuf heapBuffer();

    ByteBuf heapBuffer(int i10);

    ByteBuf heapBuffer(int i10, int i11);

    ByteBuf ioBuffer();

    ByteBuf ioBuffer(int i10);

    boolean isDirectBufferPooled();
}
