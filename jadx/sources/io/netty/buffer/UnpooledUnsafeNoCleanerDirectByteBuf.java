package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class UnpooledUnsafeNoCleanerDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
    UnpooledUnsafeNoCleanerDirectByteBuf(ByteBufAllocator byteBufAllocator, int i10, int i11) {
        super(byteBufAllocator, i10, i11);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf
    protected ByteBuffer allocateDirect(int i10) {
        return PlatformDependent.allocateDirectNoCleaner(i10);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i10) {
        checkNewCapacity(i10);
        if (i10 == capacity()) {
            return this;
        }
        trimIndicesToCapacity(i10);
        setByteBuffer(reallocateDirect(this.buffer, i10), false);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf
    protected void freeDirect(ByteBuffer byteBuffer) {
        PlatformDependent.freeDirectNoCleaner(byteBuffer);
    }

    ByteBuffer reallocateDirect(ByteBuffer byteBuffer, int i10) {
        return PlatformDependent.reallocateDirectNoCleaner(byteBuffer, i10);
    }
}
