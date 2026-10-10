package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class AdvancedLeakAwareByteBuf extends SimpleLeakAwareByteBuf {
    private static final boolean ACQUIRE_AND_RELEASE_ONLY;
    private static final InternalLogger logger;

    AdvancedLeakAwareByteBuf(ByteBuf byteBuf, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        super(byteBuf, resourceLeakTracker);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByte(byteProcessor);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i10, byteBuf, i11, i12);
    }

    @Override // io.netty.buffer.SimpleLeakAwareByteBuf
    protected /* bridge */ /* synthetic */ SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf, ByteBuf byteBuf2, ResourceLeakTracker resourceLeakTracker) {
        return newLeakAwareByteBuf(byteBuf, byteBuf2, (ResourceLeakTracker<ByteBuf>) resourceLeakTracker);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffer();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffers();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i10, byteBuf, i11, i12);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf);
    }

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) AdvancedLeakAwareByteBuf.class);
        logger = internalLoggerFactory;
        boolean z10 = SystemPropertyUtil.getBoolean("io.netty.leakDetection.acquireAndReleaseOnly", false);
        ACQUIRE_AND_RELEASE_ONLY = z10;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-D{}: {}", "io.netty.leakDetection.acquireAndReleaseOnly", Boolean.valueOf(z10));
        }
        ResourceLeakDetector.addExclusions(AdvancedLeakAwareByteBuf.class, "touch", "recordLeakNonRefCountingOperation");
    }

    AdvancedLeakAwareByteBuf(ByteBuf byteBuf, ByteBuf byteBuf2, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        super(byteBuf, byteBuf2, resourceLeakTracker);
    }

    static void recordLeakNonRefCountingOperation(ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        if (ACQUIRE_AND_RELEASE_ONLY) {
            return;
        }
        resourceLeakTracker.record();
    }

    @Override // io.netty.buffer.SimpleLeakAwareByteBuf, io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.asReadOnly();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.capacity(i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.discardSomeReadBytes();
    }

    @Override // io.netty.buffer.SimpleLeakAwareByteBuf, io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.duplicate();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.ensureWritable(i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getByte(i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getInt(i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getIntLE(i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getLong(i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getShort(i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getShortLE(i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public short getUnsignedByte(int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedByte(i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public long getUnsignedInt(int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedInt(i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedIntLE(i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i10, int i11) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.internalNioBuffer(i10, i11);
    }

    @Override // io.netty.buffer.SimpleLeakAwareByteBuf
    protected AdvancedLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf, ByteBuf byteBuf2, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        return new AdvancedLeakAwareByteBuf(byteBuf, byteBuf2, resourceLeakTracker);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.nioBufferCount();
    }

    @Override // io.netty.buffer.SimpleLeakAwareByteBuf, io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.order(byteOrder);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int readInt() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readInt();
    }

    @Override // io.netty.buffer.SimpleLeakAwareByteBuf, io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readRetainedSlice(i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public short readShort() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readShort();
    }

    @Override // io.netty.buffer.SimpleLeakAwareByteBuf, io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readSlice(i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedByte();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedInt();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedShort();
    }

    @Override // io.netty.buffer.SimpleLeakAwareByteBuf, io.netty.buffer.WrappedByteBuf, io.netty.util.ReferenceCounted
    public boolean release() {
        this.leak.record();
        return super.release();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        this.leak.record();
        return super.retain();
    }

    @Override // io.netty.buffer.SimpleLeakAwareByteBuf, io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.retainedDuplicate();
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i10, int i11) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setByte(i10, i11);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int setCharSequence(int i10, CharSequence charSequence, Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setCharSequence(i10, charSequence, charset);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i10, int i11) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setInt(i10, i11);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i10, int i11) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setMedium(i10, i11);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i10, int i11) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setShort(i10, i11);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.skipBytes(i10);
    }

    @Override // io.netty.buffer.SimpleLeakAwareByteBuf, io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i10, int i11) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.slice(i10, i11);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public String toString(int i10, int i11, Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.toString(i10, i11, charset);
    }

    @Override // io.netty.buffer.SimpleLeakAwareByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch(Object obj) {
        this.leak.record(obj);
        return this;
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeByte(i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeCharSequence(charSequence, charset);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeInt(i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeMedium(i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeShort(i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(int i10, int i11, ByteProcessor byteProcessor) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByte(i10, i11, byteProcessor);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i10, bArr);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i10, int i11) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffer(i10, i11);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i10, int i11) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffers(i10, i11);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf, i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i10, bArr, i11, i12);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i10, int i11) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf, i10, i11);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i10, bArr, i11, i12);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(gatheringByteChannel, i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int setBytes(int i10, InputStream inputStream, int i11) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i10, inputStream, i11);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(bArr);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int getBytes(int i10, GatheringByteChannel gatheringByteChannel, int i11) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i10, gatheringByteChannel, i11);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int setBytes(int i10, ScatteringByteChannel scatteringByteChannel, int i11) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i10, scatteringByteChannel, i11);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr, int i10, int i11) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(bArr, i10, i11);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int writeBytes(InputStream inputStream, int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(inputStream, i10);
    }

    @Override // io.netty.buffer.WrappedByteBuf, io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i10) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(scatteringByteChannel, i10);
    }
}
