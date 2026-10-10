package io.netty.buffer;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class UnpooledDirectByteBuf extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator alloc;
    ByteBuffer buffer;
    private int capacity;
    private boolean doNotFree;
    private ByteBuffer tmpNioBuf;

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.capacity;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkDstIndex(i10, i12, i11, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            getBytes(i10, byteBuf.array(), byteBuf.arrayOffset() + i11, i12);
            return this;
        }
        if (byteBuf.nioBufferCount() <= 0) {
            byteBuf.setBytes(i11, this, i10, i12);
            return this;
        }
        ByteBuffer[] byteBufferArrNioBuffers = byteBuf.nioBuffers(i11, i12);
        for (ByteBuffer byteBuffer : byteBufferArrNioBuffers) {
            int iRemaining = byteBuffer.remaining();
            getBytes(i10, byteBuffer);
            i10 += iRemaining;
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i10, int i11) {
        checkIndex(i10, i11);
        return (ByteBuffer) internalNioBuffer().clear().position(i10).limit(i10 + i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isContiguous() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return 1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkSrcIndex(i10, i12, i11, byteBuf.capacity());
        if (byteBuf.nioBufferCount() <= 0) {
            byteBuf.getBytes(i11, this, i10, i12);
            return this;
        }
        ByteBuffer[] byteBufferArrNioBuffers = byteBuf.nioBuffers(i11, i12);
        for (ByteBuffer byteBuffer : byteBufferArrNioBuffers) {
            int iRemaining = byteBuffer.remaining();
            setBytes(i10, byteBuffer);
            i10 += iRemaining;
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected byte _getByte(int i10) {
        return this.buffer.get(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getInt(int i10) {
        return this.buffer.getInt(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int _getIntLE(int i10) {
        return ByteBufUtil.swapInt(this.buffer.getInt(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected long _getLong(int i10) {
        return this.buffer.getLong(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShort(int i10) {
        return this.buffer.getShort(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected short _getShortLE(int i10) {
        return ByteBufUtil.swapShort(this.buffer.getShort(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setByte(int i10, int i11) {
        this.buffer.put(i10, (byte) i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setInt(int i10, int i11) {
        this.buffer.putInt(i10, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setMedium(int i10, int i11) {
        setByte(i10, (byte) (i11 >>> 16));
        setByte(i10 + 1, (byte) (i11 >>> 8));
        setByte(i10 + 2, (byte) i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected void _setShort(int i10, int i11) {
        this.buffer.putShort(i10, (short) i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i10) {
        checkNewCapacity(i10);
        int i11 = this.capacity;
        if (i10 == i11) {
            return this;
        }
        if (i10 <= i11) {
            trimIndicesToCapacity(i10);
            i11 = i10;
        }
        ByteBuffer byteBuffer = this.buffer;
        ByteBuffer byteBufferAllocateDirect = allocateDirect(i10);
        byteBuffer.position(0).limit(i11);
        byteBufferAllocateDirect.position(0).limit(i11);
        byteBufferAllocateDirect.put(byteBuffer).clear();
        setByteBuffer(byteBufferAllocateDirect, true);
        return this;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    protected void deallocate() {
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer == null) {
            return;
        }
        this.buffer = null;
        if (this.doNotFree) {
            return;
        }
        freeDirect(byteBuffer);
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    void setByteBuffer(ByteBuffer byteBuffer, boolean z10) {
        ByteBuffer byteBuffer2;
        if (z10 && (byteBuffer2 = this.buffer) != null) {
            if (this.doNotFree) {
                this.doNotFree = false;
            } else {
                freeDirect(byteBuffer2);
            }
        }
        this.buffer = byteBuffer;
        this.tmpNioBuf = null;
        this.capacity = byteBuffer.remaining();
    }

    public UnpooledDirectByteBuf(ByteBufAllocator byteBufAllocator, int i10, int i11) {
        super(i11);
        ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        ObjectUtil.checkPositiveOrZero(i10, "initialCapacity");
        ObjectUtil.checkPositiveOrZero(i11, "maxCapacity");
        if (i10 <= i11) {
            this.alloc = byteBufAllocator;
            setByteBuffer(allocateDirect(i10), false);
            return;
        }
        throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    private ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer != null) {
            return byteBuffer;
        }
        ByteBuffer byteBufferDuplicate = this.buffer.duplicate();
        this.tmpNioBuf = byteBufferDuplicate;
        return byteBufferDuplicate;
    }

    protected ByteBuffer allocateDirect(int i10) {
        return ByteBuffer.allocateDirect(i10);
    }

    protected void freeDirect(ByteBuffer byteBuffer) {
        PlatformDependent.freeDirectBuffer(byteBuffer);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        ensureAccessible();
        return _getByte(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i10) {
        ensureAccessible();
        return _getInt(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i10) {
        ensureAccessible();
        return _getLong(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i10) {
        ensureAccessible();
        return _getShort(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i10, int i11) {
        checkIndex(i10, i11);
        return ((ByteBuffer) this.buffer.duplicate().position(i10).limit(i10 + i11)).slice();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i10, int i11) {
        return new ByteBuffer[]{nioBuffer(i10, i11)};
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i10) {
        checkReadableBytes(i10);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i10, true);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i10, int i11) {
        ensureAccessible();
        _setByte(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i10, int i11) {
        ensureAccessible();
        _setInt(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i10, int i11) {
        ensureAccessible();
        _setMedium(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i10, int i11) {
        ensureAccessible();
        _setShort(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        checkSrcIndex(i10, i12, i11, bArr.length);
        ByteBuffer byteBufferInternalNioBuffer = internalNioBuffer();
        byteBufferInternalNioBuffer.clear().position(i10).limit(i10 + i12);
        byteBufferInternalNioBuffer.put(bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        getBytes(i10, bArr, i11, i12, false);
        return this;
    }

    void getBytes(int i10, byte[] bArr, int i11, int i12, boolean z10) {
        ByteBuffer byteBufferDuplicate;
        checkDstIndex(i10, i12, i11, bArr.length);
        if (z10) {
            byteBufferDuplicate = internalNioBuffer();
        } else {
            byteBufferDuplicate = this.buffer.duplicate();
        }
        byteBufferDuplicate.clear().position(i10).limit(i10 + i12);
        byteBufferDuplicate.get(bArr, i11, i12);
    }

    public ByteBuf setBytes(int i10, ByteBuffer byteBuffer) {
        ensureAccessible();
        ByteBuffer byteBufferInternalNioBuffer = internalNioBuffer();
        if (byteBuffer == byteBufferInternalNioBuffer) {
            byteBuffer = byteBuffer.duplicate();
        }
        byteBufferInternalNioBuffer.clear().position(i10).limit(i10 + byteBuffer.remaining());
        byteBufferInternalNioBuffer.put(byteBuffer);
        return this;
    }

    public ByteBuf getBytes(int i10, ByteBuffer byteBuffer) {
        getBytes(i10, byteBuffer, false);
        return this;
    }

    void getBytes(int i10, ByteBuffer byteBuffer, boolean z10) {
        ByteBuffer byteBufferDuplicate;
        checkIndex(i10, byteBuffer.remaining());
        if (z10) {
            byteBufferDuplicate = internalNioBuffer();
        } else {
            byteBufferDuplicate = this.buffer.duplicate();
        }
        byteBufferDuplicate.clear().position(i10).limit(i10 + byteBuffer.remaining());
        byteBuffer.put(byteBufferDuplicate);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, InputStream inputStream, int i11) throws IOException {
        ensureAccessible();
        if (this.buffer.hasArray()) {
            return inputStream.read(this.buffer.array(), this.buffer.arrayOffset() + i10, i11);
        }
        byte[] bArrThreadLocalTempArray = ByteBufUtil.threadLocalTempArray(i11);
        int i12 = inputStream.read(bArrThreadLocalTempArray, 0, i11);
        if (i12 <= 0) {
            return i12;
        }
        ByteBuffer byteBufferInternalNioBuffer = internalNioBuffer();
        byteBufferInternalNioBuffer.clear().position(i10);
        byteBufferInternalNioBuffer.put(bArrThreadLocalTempArray, 0, i12);
        return i12;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, GatheringByteChannel gatheringByteChannel, int i11) {
        return getBytes(i10, gatheringByteChannel, i11, false);
    }

    private int getBytes(int i10, GatheringByteChannel gatheringByteChannel, int i11, boolean z10) {
        ByteBuffer byteBufferDuplicate;
        ensureAccessible();
        if (i11 == 0) {
            return 0;
        }
        if (z10) {
            byteBufferDuplicate = internalNioBuffer();
        } else {
            byteBufferDuplicate = this.buffer.duplicate();
        }
        byteBufferDuplicate.clear().position(i10).limit(i10 + i11);
        return gatheringByteChannel.write(byteBufferDuplicate);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, ScatteringByteChannel scatteringByteChannel, int i11) {
        ensureAccessible();
        ByteBuffer byteBufferInternalNioBuffer = internalNioBuffer();
        byteBufferInternalNioBuffer.clear().position(i10).limit(i10 + i11);
        try {
            return scatteringByteChannel.read(byteBufferInternalNioBuffer);
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }
}
