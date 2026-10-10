package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
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
public abstract class AbstractByteBuf extends ByteBuf {
    static final boolean checkAccessible;
    private static final boolean checkBounds;
    static final ResourceLeakDetector<ByteBuf> leakDetector;
    private static final InternalLogger logger;
    private int markedReaderIndex;
    private int markedWriterIndex;
    private int maxCapacity;
    int readerIndex;
    int writerIndex;

    protected abstract byte _getByte(int i10);

    protected abstract int _getInt(int i10);

    protected abstract int _getIntLE(int i10);

    protected abstract long _getLong(int i10);

    protected abstract short _getShort(int i10);

    protected abstract short _getShortLE(int i10);

    protected abstract void _setByte(int i10, int i11);

    protected abstract void _setInt(int i10, int i11);

    protected abstract void _setMedium(int i10, int i11);

    protected abstract void _setShort(int i10, int i11);

    protected final void checkIndex(int i10) {
        checkIndex(i10, 1);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf clear() {
        this.writerIndex = 0;
        this.readerIndex = 0;
        return this;
    }

    final void discardMarks() {
        this.markedWriterIndex = 0;
        this.markedReaderIndex = 0;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor) {
        ensureAccessible();
        try {
            return forEachByteAsc0(this.readerIndex, this.writerIndex, byteProcessor);
        } catch (Exception e10) {
            PlatformDependent.throwException(e10);
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr) {
        getBytes(i10, bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getInt(int i10) {
        checkIndex(i10, 4);
        return _getInt(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getIntLE(int i10) {
        checkIndex(i10, 4);
        return _getIntLE(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShort(int i10) {
        checkIndex(i10, 2);
        return _getShort(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShortLE(int i10) {
        checkIndex(i10, 2);
        return _getShortLE(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable() {
        return this.writerIndex > this.readerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return this.maxCapacity;
    }

    public byte readByte() {
        checkReadableBytes0(1);
        int i10 = this.readerIndex;
        byte b_getByte = _getByte(i10);
        this.readerIndex = i10 + 1;
        return b_getByte;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int i10) {
        checkReadableBytes(i10);
        if (i10 == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBuf byteBufBuffer = alloc().buffer(i10, this.maxCapacity);
        byteBufBuffer.writeBytes(this, this.readerIndex, i10);
        this.readerIndex += i10;
        return byteBufBuffer;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readInt() {
        checkReadableBytes0(4);
        int i_getInt = _getInt(this.readerIndex);
        this.readerIndex += 4;
        return i_getInt;
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShort() {
        checkReadableBytes0(2);
        short s_getShort = _getShort(this.readerIndex);
        this.readerIndex += 2;
        return s_getShort;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readerIndex() {
        return this.readerIndex;
    }

    public ByteBuf setBytes(int i10, byte[] bArr) {
        setBytes(i10, bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setCharSequence(int i10, CharSequence charSequence, Charset charset) {
        return setCharSequence0(i10, charSequence, charset, false);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i10, int i11) {
        checkIndex(i10, 4);
        _setInt(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i10, int i11) {
        checkIndex(i10, 3);
        _setMedium(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i10, int i11) {
        checkIndex(i10, 2);
        _setShort(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(int i10, int i11, Charset charset) {
        return ByteBufUtil.decodeString(this, i10, i11, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int i10) {
        ensureWritable0(1);
        int i11 = this.writerIndex;
        this.writerIndex = i11 + 1;
        _setByte(i11, i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr, int i10, int i11) {
        ensureWritable(i11);
        setBytes(this.writerIndex, bArr, i10, i11);
        this.writerIndex += i11;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int i10) {
        ensureWritable0(4);
        _setInt(this.writerIndex, i10);
        this.writerIndex += 4;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int i10) {
        ensureWritable0(3);
        _setMedium(this.writerIndex, i10);
        this.writerIndex += 3;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int i10) {
        ensureWritable0(2);
        _setShort(this.writerIndex, i10);
        this.writerIndex += 2;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writerIndex() {
        return this.writerIndex;
    }

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) AbstractByteBuf.class);
        logger = internalLoggerFactory;
        if (SystemPropertyUtil.contains("io.netty.buffer.checkAccessible")) {
            checkAccessible = SystemPropertyUtil.getBoolean("io.netty.buffer.checkAccessible", true);
        } else {
            checkAccessible = SystemPropertyUtil.getBoolean("io.netty.buffer.bytebuf.checkAccessible", true);
        }
        boolean z10 = SystemPropertyUtil.getBoolean("io.netty.buffer.checkBounds", true);
        checkBounds = z10;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-D{}: {}", "io.netty.buffer.checkAccessible", Boolean.valueOf(checkAccessible));
            internalLoggerFactory.debug("-D{}: {}", "io.netty.buffer.checkBounds", Boolean.valueOf(z10));
        }
        leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ByteBuf.class);
    }

    private static void checkIndexBounds(int i10, int i11, int i12) {
        if (i10 < 0 || i10 > i11 || i11 > i12) {
            throw new IndexOutOfBoundsException(String.format("readerIndex: %d, writerIndex: %d (expected: 0 <= readerIndex <= writerIndex <= capacity(%d))", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12)));
        }
    }

    private int setCharSequence0(int i10, CharSequence charSequence, Charset charset, boolean z10) {
        if (charset.equals(CharsetUtil.UTF_8)) {
            int iUtf8MaxBytes = ByteBufUtil.utf8MaxBytes(charSequence);
            if (z10) {
                ensureWritable0(iUtf8MaxBytes);
                checkIndex0(i10, iUtf8MaxBytes);
            } else {
                checkIndex(i10, iUtf8MaxBytes);
            }
            return ByteBufUtil.writeUtf8(this, i10, iUtf8MaxBytes, charSequence, charSequence.length());
        }
        if (!charset.equals(CharsetUtil.US_ASCII) && !charset.equals(CharsetUtil.ISO_8859_1)) {
            byte[] bytes = charSequence.toString().getBytes(charset);
            if (z10) {
                ensureWritable0(bytes.length);
            }
            setBytes(i10, bytes);
            return bytes.length;
        }
        int length = charSequence.length();
        if (z10) {
            ensureWritable0(length);
            checkIndex0(i10, length);
        } else {
            checkIndex(i10, length);
        }
        return ByteBufUtil.writeAscii(this, i10, charSequence, length);
    }

    protected final void adjustMarkers(int i10) {
        int i11 = this.markedReaderIndex;
        if (i11 > i10) {
            this.markedReaderIndex = i11 - i10;
            this.markedWriterIndex -= i10;
            return;
        }
        this.markedReaderIndex = 0;
        int i12 = this.markedWriterIndex;
        if (i12 <= i10) {
            this.markedWriterIndex = 0;
        } else {
            this.markedWriterIndex = i12 - i10;
        }
    }

    protected final void checkIndex(int i10, int i11) {
        ensureAccessible();
        checkIndex0(i10, i11);
    }

    final void checkIndex0(int i10, int i11) {
        if (checkBounds) {
            checkRangeBounds("index", i10, i11, capacity());
        }
    }

    protected final void checkReadableBytes(int i10) {
        checkReadableBytes0(ObjectUtil.checkPositiveOrZero(i10, "minimumReadableBytes"));
    }

    @Override // io.netty.buffer.ByteBuf, java.lang.Comparable
    public int compareTo(ByteBuf byteBuf) {
        return ByteBufUtil.compare(this, byteBuf);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        int i10 = this.readerIndex;
        if (i10 > 0) {
            if (i10 == this.writerIndex) {
                ensureAccessible();
                adjustMarkers(this.readerIndex);
                this.readerIndex = 0;
                this.writerIndex = 0;
                return this;
            }
            if (i10 >= (capacity() >>> 1)) {
                int i11 = this.readerIndex;
                setBytes(0, this, i11, this.writerIndex - i11);
                int i12 = this.writerIndex;
                int i13 = this.readerIndex;
                this.writerIndex = i12 - i13;
                adjustMarkers(i13);
                this.readerIndex = 0;
                return this;
            }
        }
        ensureAccessible();
        return this;
    }

    protected final void ensureAccessible() {
        if (checkAccessible && !isAccessible()) {
            throw new IllegalReferenceCountException(0);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int i10) {
        ensureWritable0(ObjectUtil.checkPositiveOrZero(i10, "minWritableBytes"));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean equals(Object obj) {
        return (obj instanceof ByteBuf) && ByteBufUtil.equals(this, (ByteBuf) obj);
    }

    int forEachByteAsc0(int i10, int i11, ByteProcessor byteProcessor) {
        while (i10 < i11) {
            if (!byteProcessor.process(_getByte(i10))) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLong(int i10) {
        checkIndex(i10, 8);
        return _getLong(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadable(int i10) {
        return this.writerIndex - this.readerIndex >= i10;
    }

    public ByteBuf markReaderIndex() {
        this.markedReaderIndex = this.readerIndex;
        return this;
    }

    public ByteBuf markWriterIndex() {
        this.markedWriterIndex = this.writerIndex;
        return this;
    }

    protected final void maxCapacity(int i10) {
        this.maxCapacity = i10;
    }

    protected SwappedByteBuf newSwappedByteBuf() {
        return new SwappedByteBuf(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        return nioBuffer(this.readerIndex, readableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return nioBuffers(this.readerIndex, readableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public int readableBytes() {
        return this.writerIndex - this.readerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readerIndex(int i10) {
        if (checkBounds) {
            checkIndexBounds(i10, this.writerIndex, capacity());
        }
        this.readerIndex = i10;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIndex(int i10, int i11) {
        if (checkBounds) {
            checkIndexBounds(i10, i11, capacity());
        }
        setIndex0(i10, i11);
        return this;
    }

    final void setIndex0(int i10, int i11) {
        this.readerIndex = i10;
        this.writerIndex = i11;
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString() {
        if (refCnt() == 0) {
            return StringUtil.simpleClassName(this) + "(freed)";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(StringUtil.simpleClassName(this));
        sb2.append("(ridx: ");
        sb2.append(this.readerIndex);
        sb2.append(", widx: ");
        sb2.append(this.writerIndex);
        sb2.append(", cap: ");
        sb2.append(capacity());
        if (this.maxCapacity != Integer.MAX_VALUE) {
            sb2.append('/');
            sb2.append(this.maxCapacity);
        }
        ByteBuf byteBufUnwrap = unwrap();
        if (byteBufUnwrap != null) {
            sb2.append(", unwrapped: ");
            sb2.append(byteBufUnwrap);
        }
        sb2.append(')');
        return sb2.toString();
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        int charSequence0 = setCharSequence0(this.writerIndex, charSequence, charset, true);
        this.writerIndex += charSequence0;
        return charSequence0;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writerIndex(int i10) {
        if (checkBounds) {
            checkIndexBounds(this.readerIndex, i10, capacity());
        }
        this.writerIndex = i10;
        return this;
    }

    protected AbstractByteBuf(int i10) {
        ObjectUtil.checkPositiveOrZero(i10, "maxCapacity");
        this.maxCapacity = i10;
    }

    private static void checkRangeBounds(String str, int i10, int i11, int i12) {
        if (!MathUtil.isOutOfBounds(i10, i11, i12)) {
        } else {
            throw new IndexOutOfBoundsException(String.format("%s: %d, length: %d (expected: range(0, %d))", str, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12)));
        }
    }

    private static void checkReadableBounds(ByteBuf byteBuf, int i10) {
        if (i10 <= byteBuf.readableBytes()) {
        } else {
            throw new IndexOutOfBoundsException(String.format("length(%d) exceeds src.readableBytes(%d) where src is: %s", Integer.valueOf(i10), Integer.valueOf(byteBuf.readableBytes()), byteBuf));
        }
    }

    private void checkReadableBytes0(int i10) {
        ensureAccessible();
        if (checkBounds && this.readerIndex > this.writerIndex - i10) {
            throw new IndexOutOfBoundsException(String.format("readerIndex(%d) + length(%d) exceeds writerIndex(%d): %s", Integer.valueOf(this.readerIndex), Integer.valueOf(i10), Integer.valueOf(this.writerIndex), this));
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        if (isReadOnly()) {
            return this;
        }
        return Unpooled.unmodifiableBuffer(this);
    }

    protected final void checkDstIndex(int i10, int i11, int i12, int i13) {
        checkIndex(i10, i11);
        if (checkBounds) {
            checkRangeBounds("dstIndex", i12, i11, i13);
        }
    }

    protected final void checkNewCapacity(int i10) {
        ensureAccessible();
        if (checkBounds) {
            if (i10 < 0 || i10 > maxCapacity()) {
                throw new IllegalArgumentException("newCapacity: " + i10 + " (expected: 0-" + maxCapacity() + ')');
            }
        }
    }

    protected final void checkSrcIndex(int i10, int i11, int i12, int i13) {
        checkIndex(i10, i11);
        if (checkBounds) {
            checkRangeBounds("srcIndex", i12, i11, i13);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        ensureAccessible();
        return new UnpooledDuplicatedByteBuf(this);
    }

    final void ensureWritable0(int i10) {
        boolean z10;
        boolean z11;
        int iCalculateNewCapacity;
        int iWriterIndex = writerIndex();
        int i11 = iWriterIndex + i10;
        if (i11 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (i11 <= capacity()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 & z11) {
            ensureAccessible();
            return;
        }
        if (checkBounds && (i11 < 0 || i11 > this.maxCapacity)) {
            ensureAccessible();
            throw new IndexOutOfBoundsException(String.format("writerIndex(%d) + minWritableBytes(%d) exceeds maxCapacity(%d): %s", Integer.valueOf(iWriterIndex), Integer.valueOf(i10), Integer.valueOf(this.maxCapacity), this));
        }
        int iMaxFastWritableBytes = maxFastWritableBytes();
        if (iMaxFastWritableBytes >= i10) {
            iCalculateNewCapacity = iWriterIndex + iMaxFastWritableBytes;
        } else {
            iCalculateNewCapacity = alloc().calculateNewCapacity(i11, this.maxCapacity);
        }
        capacity(iCalculateNewCapacity);
    }

    @Override // io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        checkIndex(i10);
        return _getByte(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getUnsignedByte(int i10) {
        return (short) (getByte(i10) & 255);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedInt(int i10) {
        return ((long) getInt(i10)) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int i10) {
        return ((long) getIntLE(i10)) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public int hashCode() {
        return ByteBufUtil.hashCode(this);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isWritable() {
        if (capacity() > this.writerIndex) {
            return true;
        }
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxWritableBytes() {
        return maxCapacity() - this.writerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        if (byteOrder == order()) {
            return this;
        }
        ObjectUtil.checkNotNull(byteOrder, "endianness");
        return newSwappedByteBuf();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i10) {
        checkReadableBytes(i10);
        ByteBuf byteBufRetainedSlice = retainedSlice(this.readerIndex, i10);
        this.readerIndex += i10;
        return byteBufRetainedSlice;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i10) {
        checkReadableBytes(i10);
        ByteBuf byteBufSlice = slice(this.readerIndex, i10);
        this.readerIndex += i10;
        return byteBufSlice;
    }

    @Override // io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        return (short) (readByte() & 255);
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        return ((long) readInt()) & 4294967295L;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        return readShort() & 65535;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return duplicate().retain();
    }

    public ByteBuf retainedSlice(int i10, int i11) {
        return slice(i10, i11).retain();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i10, int i11) {
        checkIndex(i10);
        _setByte(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int i10) {
        checkReadableBytes(i10);
        this.readerIndex += i10;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice(int i10, int i11) {
        ensureAccessible();
        return new UnpooledSlicedByteBuf(this, i10, i11);
    }

    protected final void trimIndicesToCapacity(int i10) {
        if (writerIndex() > i10) {
            setIndex0(Math.min(readerIndex(), i10), i10);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int writableBytes() {
        return capacity() - this.writerIndex;
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(int i10, int i11, ByteProcessor byteProcessor) {
        checkIndex(i10, i11);
        try {
            return forEachByteAsc0(i10, i11 + i10, byteProcessor);
        } catch (Exception e10) {
            PlatformDependent.throwException(e10);
            return -1;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr) {
        writeBytes(bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf) {
        writeBytes(byteBuf, byteBuf.readableBytes());
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i10) {
        if (checkBounds && i10 > byteBuf.writableBytes()) {
            throw new IndexOutOfBoundsException(String.format("length(%d) exceeds dst.writableBytes(%d) where dst is: %s", Integer.valueOf(i10), Integer.valueOf(byteBuf.writableBytes()), byteBuf));
        }
        readBytes(byteBuf, byteBuf.writerIndex(), i10);
        byteBuf.writerIndex(byteBuf.writerIndex() + i10);
        return this;
    }

    public ByteBuf writeBytes(ByteBuf byteBuf, int i10) {
        if (checkBounds) {
            checkReadableBounds(byteBuf, i10);
        }
        writeBytes(byteBuf, byteBuf.readerIndex(), i10);
        byteBuf.readerIndex(byteBuf.readerIndex() + i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i10, int i11) {
        ensureWritable(i11);
        setBytes(this.writerIndex, byteBuf, i10, i11);
        this.writerIndex += i11;
        return this;
    }

    public ByteBuf readBytes(ByteBuf byteBuf, int i10, int i11) {
        checkReadableBytes(i11);
        getBytes(this.readerIndex, byteBuf, i10, i11);
        this.readerIndex += i11;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(InputStream inputStream, int i10) {
        ensureWritable(i10);
        int bytes = setBytes(this.writerIndex, inputStream, i10);
        if (bytes > 0) {
            this.writerIndex += bytes;
        }
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i10) {
        checkReadableBytes(i10);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i10);
        this.readerIndex += bytes;
        return bytes;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i10) {
        ensureWritable(i10);
        int bytes = setBytes(this.writerIndex, scatteringByteChannel, i10);
        if (bytes > 0) {
            this.writerIndex += bytes;
        }
        return bytes;
    }
}
