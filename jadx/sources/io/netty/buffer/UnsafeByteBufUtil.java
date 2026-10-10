package io.netty.buffer;

import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class UnsafeByteBufUtil {
    private static final boolean UNALIGNED = PlatformDependent.isUnaligned();

    static byte getByte(long j10) {
        return PlatformDependent.getByte(j10);
    }

    static void getBytes(AbstractByteBuf abstractByteBuf, long j10, int i10, ByteBuf byteBuf, int i11, int i12) {
        abstractByteBuf.checkIndex(i10, i12);
        ObjectUtil.checkNotNull(byteBuf, "dst");
        if (MathUtil.isOutOfBounds(i11, i12, byteBuf.capacity())) {
            throw new IndexOutOfBoundsException("dstIndex: " + i11);
        }
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(j10, byteBuf.memoryAddress() + ((long) i11), i12);
        } else if (byteBuf.hasArray()) {
            PlatformDependent.copyMemory(j10, byteBuf.array(), byteBuf.arrayOffset() + i11, i12);
        } else {
            byteBuf.setBytes(i11, abstractByteBuf, i10, i12);
        }
    }

    static int getInt(long j10) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(j10 + 3) & 255) | (PlatformDependent.getByte(j10) << 24) | ((PlatformDependent.getByte(1 + j10) & 255) << 16) | ((PlatformDependent.getByte(2 + j10) & 255) << 8);
        }
        int i10 = PlatformDependent.getInt(j10);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? i10 : Integer.reverseBytes(i10);
    }

    static int getIntLE(long j10) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(j10 + 3) << 24) | (PlatformDependent.getByte(j10) & 255) | ((PlatformDependent.getByte(1 + j10) & 255) << 8) | ((PlatformDependent.getByte(2 + j10) & 255) << 16);
        }
        int i10 = PlatformDependent.getInt(j10);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(i10) : i10;
    }

    static long getLong(long j10) {
        if (!UNALIGNED) {
            return (((long) PlatformDependent.getByte(j10 + 7)) & 255) | (((long) PlatformDependent.getByte(j10)) << 56) | ((((long) PlatformDependent.getByte(1 + j10)) & 255) << 48) | ((((long) PlatformDependent.getByte(2 + j10)) & 255) << 40) | ((((long) PlatformDependent.getByte(3 + j10)) & 255) << 32) | ((((long) PlatformDependent.getByte(4 + j10)) & 255) << 24) | ((((long) PlatformDependent.getByte(5 + j10)) & 255) << 16) | ((((long) PlatformDependent.getByte(6 + j10)) & 255) << 8);
        }
        long j11 = PlatformDependent.getLong(j10);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? j11 : Long.reverseBytes(j11);
    }

    static short getShort(long j10) {
        if (!UNALIGNED) {
            return (short) ((PlatformDependent.getByte(j10 + 1) & 255) | (PlatformDependent.getByte(j10) << 8));
        }
        short s10 = PlatformDependent.getShort(j10);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? s10 : Short.reverseBytes(s10);
    }

    static short getShortLE(long j10) {
        if (!UNALIGNED) {
            return (short) ((PlatformDependent.getByte(j10 + 1) << 8) | (PlatformDependent.getByte(j10) & 255));
        }
        short s10 = PlatformDependent.getShort(j10);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(s10) : s10;
    }

    static void setByte(long j10, int i10) {
        PlatformDependent.putByte(j10, (byte) i10);
    }

    static int setBytes(AbstractByteBuf abstractByteBuf, long j10, int i10, InputStream inputStream, int i11) {
        abstractByteBuf.checkIndex(i10, i11);
        ByteBuf byteBufHeapBuffer = abstractByteBuf.alloc().heapBuffer(i11);
        try {
            byte[] bArrArray = byteBufHeapBuffer.array();
            int iArrayOffset = byteBufHeapBuffer.arrayOffset();
            int i12 = inputStream.read(bArrArray, iArrayOffset, i11);
            if (i12 > 0) {
                PlatformDependent.copyMemory(bArrArray, iArrayOffset, j10, i12);
            }
            return i12;
        } finally {
            byteBufHeapBuffer.release();
        }
    }

    static void setInt(long j10, int i10) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i10 = Integer.reverseBytes(i10);
            }
            PlatformDependent.putInt(j10, i10);
        } else {
            PlatformDependent.putByte(j10, (byte) (i10 >>> 24));
            PlatformDependent.putByte(1 + j10, (byte) (i10 >>> 16));
            PlatformDependent.putByte(2 + j10, (byte) (i10 >>> 8));
            PlatformDependent.putByte(j10 + 3, (byte) i10);
        }
    }

    static void setMedium(long j10, int i10) {
        PlatformDependent.putByte(j10, (byte) (i10 >>> 16));
        if (!UNALIGNED) {
            PlatformDependent.putByte(1 + j10, (byte) (i10 >>> 8));
            PlatformDependent.putByte(j10 + 2, (byte) i10);
            return;
        }
        long j11 = j10 + 1;
        short sReverseBytes = (short) i10;
        if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
            sReverseBytes = Short.reverseBytes(sReverseBytes);
        }
        PlatformDependent.putShort(j11, sReverseBytes);
    }

    static void setShort(long j10, int i10) {
        if (!UNALIGNED) {
            PlatformDependent.putByte(j10, (byte) (i10 >>> 8));
            PlatformDependent.putByte(j10 + 1, (byte) i10);
        } else {
            short sReverseBytes = (short) i10;
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                sReverseBytes = Short.reverseBytes(sReverseBytes);
            }
            PlatformDependent.putShort(j10, sReverseBytes);
        }
    }

    static byte getByte(byte[] bArr, int i10) {
        return PlatformDependent.getByte(bArr, i10);
    }

    static void setByte(byte[] bArr, int i10, int i11) {
        PlatformDependent.putByte(bArr, i10, (byte) i11);
    }

    static UnpooledUnsafeDirectByteBuf newUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, int i10, int i11) {
        if (PlatformDependent.useDirectBufferNoCleaner()) {
            return new UnpooledUnsafeNoCleanerDirectByteBuf(byteBufAllocator, i10, i11);
        }
        return new UnpooledUnsafeDirectByteBuf(byteBufAllocator, i10, i11);
    }

    private static void setSingleBytes(AbstractByteBuf abstractByteBuf, long j10, int i10, ByteBuffer byteBuffer, int i11) {
        abstractByteBuf.checkIndex(i10, i11);
        int iLimit = byteBuffer.limit();
        for (int iPosition = byteBuffer.position(); iPosition < iLimit; iPosition++) {
            PlatformDependent.putByte(j10, byteBuffer.get(iPosition));
            j10++;
        }
        byteBuffer.position(iLimit);
    }

    static short getShort(byte[] bArr, int i10) {
        if (UNALIGNED) {
            short s10 = PlatformDependent.getShort(bArr, i10);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? s10 : Short.reverseBytes(s10);
        }
        return (short) ((PlatformDependent.getByte(bArr, i10 + 1) & 255) | (PlatformDependent.getByte(bArr, i10) << 8));
    }

    static short getShortLE(byte[] bArr, int i10) {
        if (UNALIGNED) {
            short s10 = PlatformDependent.getShort(bArr, i10);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(s10) : s10;
        }
        return (short) ((PlatformDependent.getByte(bArr, i10 + 1) << 8) | (PlatformDependent.getByte(bArr, i10) & 255));
    }

    static void setInt(byte[] bArr, int i10, int i11) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i11 = Integer.reverseBytes(i11);
            }
            PlatformDependent.putInt(bArr, i10, i11);
        } else {
            PlatformDependent.putByte(bArr, i10, (byte) (i11 >>> 24));
            PlatformDependent.putByte(bArr, i10 + 1, (byte) (i11 >>> 16));
            PlatformDependent.putByte(bArr, i10 + 2, (byte) (i11 >>> 8));
            PlatformDependent.putByte(bArr, i10 + 3, (byte) i11);
        }
    }

    static void setShort(byte[] bArr, int i10, int i11) {
        if (UNALIGNED) {
            short sReverseBytes = (short) i11;
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                sReverseBytes = Short.reverseBytes(sReverseBytes);
            }
            PlatformDependent.putShort(bArr, i10, sReverseBytes);
            return;
        }
        PlatformDependent.putByte(bArr, i10, (byte) (i11 >>> 8));
        PlatformDependent.putByte(bArr, i10 + 1, (byte) i11);
    }

    static int getInt(byte[] bArr, int i10) {
        if (UNALIGNED) {
            int i11 = PlatformDependent.getInt(bArr, i10);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? i11 : Integer.reverseBytes(i11);
        }
        return (PlatformDependent.getByte(bArr, i10 + 3) & 255) | (PlatformDependent.getByte(bArr, i10) << 24) | ((PlatformDependent.getByte(bArr, i10 + 1) & 255) << 16) | ((PlatformDependent.getByte(bArr, i10 + 2) & 255) << 8);
    }

    static int getIntLE(byte[] bArr, int i10) {
        if (UNALIGNED) {
            int i11 = PlatformDependent.getInt(bArr, i10);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(i11) : i11;
        }
        return (PlatformDependent.getByte(bArr, i10 + 3) << 24) | (PlatformDependent.getByte(bArr, i10) & 255) | ((PlatformDependent.getByte(bArr, i10 + 1) & 255) << 8) | ((PlatformDependent.getByte(bArr, i10 + 2) & 255) << 16);
    }

    static void setMedium(byte[] bArr, int i10, int i11) {
        PlatformDependent.putByte(bArr, i10, (byte) (i11 >>> 16));
        if (UNALIGNED) {
            int i12 = i10 + 1;
            short sReverseBytes = (short) i11;
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                sReverseBytes = Short.reverseBytes(sReverseBytes);
            }
            PlatformDependent.putShort(bArr, i12, sReverseBytes);
            return;
        }
        PlatformDependent.putByte(bArr, i10 + 1, (byte) (i11 >>> 8));
        PlatformDependent.putByte(bArr, i10 + 2, (byte) i11);
    }

    static void setBytes(AbstractByteBuf abstractByteBuf, long j10, int i10, ByteBuf byteBuf, int i11, int i12) {
        abstractByteBuf.checkIndex(i10, i12);
        ObjectUtil.checkNotNull(byteBuf, "src");
        if (MathUtil.isOutOfBounds(i11, i12, byteBuf.capacity())) {
            throw new IndexOutOfBoundsException("srcIndex: " + i11);
        }
        if (i12 != 0) {
            if (byteBuf.hasMemoryAddress()) {
                PlatformDependent.copyMemory(byteBuf.memoryAddress() + ((long) i11), j10, i12);
            } else if (byteBuf.hasArray()) {
                PlatformDependent.copyMemory(byteBuf.array(), byteBuf.arrayOffset() + i11, j10, i12);
            } else {
                byteBuf.getBytes(i11, abstractByteBuf, i10, i12);
            }
        }
    }

    static void getBytes(AbstractByteBuf abstractByteBuf, long j10, int i10, byte[] bArr, int i11, int i12) {
        abstractByteBuf.checkIndex(i10, i12);
        ObjectUtil.checkNotNull(bArr, "dst");
        if (MathUtil.isOutOfBounds(i11, i12, bArr.length)) {
            throw new IndexOutOfBoundsException("dstIndex: " + i11);
        }
        if (i12 != 0) {
            PlatformDependent.copyMemory(j10, bArr, i11, i12);
        }
    }

    static long getLong(byte[] bArr, int i10) {
        if (UNALIGNED) {
            long j10 = PlatformDependent.getLong(bArr, i10);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? j10 : Long.reverseBytes(j10);
        }
        return (((long) PlatformDependent.getByte(bArr, i10 + 7)) & 255) | (((long) PlatformDependent.getByte(bArr, i10)) << 56) | ((((long) PlatformDependent.getByte(bArr, i10 + 1)) & 255) << 48) | ((((long) PlatformDependent.getByte(bArr, i10 + 2)) & 255) << 40) | ((((long) PlatformDependent.getByte(bArr, i10 + 3)) & 255) << 32) | ((((long) PlatformDependent.getByte(bArr, i10 + 4)) & 255) << 24) | ((((long) PlatformDependent.getByte(bArr, i10 + 5)) & 255) << 16) | ((((long) PlatformDependent.getByte(bArr, i10 + 6)) & 255) << 8);
    }

    static void getBytes(AbstractByteBuf abstractByteBuf, long j10, int i10, ByteBuffer byteBuffer) {
        abstractByteBuf.checkIndex(i10, byteBuffer.remaining());
        if (byteBuffer.remaining() == 0) {
            return;
        }
        if (byteBuffer.isDirect()) {
            if (!byteBuffer.isReadOnly()) {
                PlatformDependent.copyMemory(j10, PlatformDependent.directBufferAddress(byteBuffer) + ((long) byteBuffer.position()), byteBuffer.remaining());
                byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
                return;
            }
            throw new ReadOnlyBufferException();
        }
        if (byteBuffer.hasArray()) {
            PlatformDependent.copyMemory(j10, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
        } else {
            byteBuffer.put(abstractByteBuf.nioBuffer());
        }
    }

    static void setBytes(AbstractByteBuf abstractByteBuf, long j10, int i10, byte[] bArr, int i11, int i12) {
        abstractByteBuf.checkIndex(i10, i12);
        ObjectUtil.checkNotNull(bArr, "src");
        if (MathUtil.isOutOfBounds(i11, i12, bArr.length)) {
            throw new IndexOutOfBoundsException("srcIndex: " + i11);
        }
        if (i12 != 0) {
            PlatformDependent.copyMemory(bArr, i11, j10, i12);
        }
    }

    static void setBytes(AbstractByteBuf abstractByteBuf, long j10, int i10, ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        if (iRemaining == 0) {
            return;
        }
        if (byteBuffer.isDirect()) {
            abstractByteBuf.checkIndex(i10, iRemaining);
            PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(byteBuffer) + ((long) byteBuffer.position()), j10, iRemaining);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        } else if (byteBuffer.hasArray()) {
            abstractByteBuf.checkIndex(i10, iRemaining);
            PlatformDependent.copyMemory(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), j10, iRemaining);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        } else if (iRemaining < 8) {
            setSingleBytes(abstractByteBuf, j10, i10, byteBuffer, iRemaining);
        } else {
            abstractByteBuf.internalNioBuffer(i10, iRemaining).put(byteBuffer);
        }
    }
}
