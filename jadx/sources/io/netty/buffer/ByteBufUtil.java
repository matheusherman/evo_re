package io.netty.buffer;

import androidx.core.view.ViewCompat;
import com.pengrad.telegrambot.passport.decrypt.RsaOaep;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class ByteBufUtil {
    private static final FastThreadLocal<byte[]> BYTE_ARRAYS;
    static final ByteBufAllocator DEFAULT_ALLOCATOR;
    private static final ByteProcessor FIND_NON_ASCII;
    private static final int MAX_BYTES_PER_CHAR_UTF8;
    private static final int MAX_CHAR_BUFFER_SIZE;
    private static final int THREAD_LOCAL_BUFFER_SIZE;
    private static final InternalLogger logger;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class HexUtil {
        private static final char[] BYTE2CHAR = new char[256];
        private static final char[] HEXDUMP_TABLE = new char[1024];
        private static final String[] HEXPADDING = new String[16];
        private static final String[] HEXDUMP_ROWPREFIXES = new String[4096];
        private static final String[] BYTE2HEX = new String[256];
        private static final String[] BYTEPADDING = new String[16];

        static {
            char[] charArray = "0123456789abcdef".toCharArray();
            int i10 = 0;
            for (int i11 = 0; i11 < 256; i11++) {
                char[] cArr = HEXDUMP_TABLE;
                int i12 = i11 << 1;
                cArr[i12] = charArray[(i11 >>> 4) & 15];
                cArr[i12 + 1] = charArray[i11 & 15];
            }
            int i13 = 0;
            while (true) {
                String[] strArr = HEXPADDING;
                if (i13 >= strArr.length) {
                    break;
                }
                int length = strArr.length - i13;
                StringBuilder sb2 = new StringBuilder(length * 3);
                for (int i14 = 0; i14 < length; i14++) {
                    sb2.append("   ");
                }
                HEXPADDING[i13] = sb2.toString();
                i13++;
            }
            int i15 = 0;
            while (true) {
                String[] strArr2 = HEXDUMP_ROWPREFIXES;
                if (i15 >= strArr2.length) {
                    break;
                }
                StringBuilder sb3 = new StringBuilder(12);
                sb3.append(StringUtil.NEWLINE);
                sb3.append(Long.toHexString((((long) (i15 << 4)) & 4294967295L) | IjkMediaMeta.AV_CH_WIDE_RIGHT));
                sb3.setCharAt(sb3.length() - 9, '|');
                sb3.append('|');
                strArr2[i15] = sb3.toString();
                i15++;
            }
            int i16 = 0;
            while (true) {
                String[] strArr3 = BYTE2HEX;
                if (i16 >= strArr3.length) {
                    break;
                }
                strArr3[i16] = ' ' + StringUtil.byteToHexStringPadded(i16);
                i16++;
            }
            int i17 = 0;
            while (true) {
                String[] strArr4 = BYTEPADDING;
                if (i17 >= strArr4.length) {
                    break;
                }
                int length2 = strArr4.length - i17;
                StringBuilder sb4 = new StringBuilder(length2);
                for (int i18 = 0; i18 < length2; i18++) {
                    sb4.append(' ');
                }
                BYTEPADDING[i17] = sb4.toString();
                i17++;
            }
            while (true) {
                char[] cArr2 = BYTE2CHAR;
                if (i10 >= cArr2.length) {
                    return;
                }
                if (i10 <= 31 || i10 >= 127) {
                    cArr2[i10] = '.';
                } else {
                    cArr2[i10] = (char) i10;
                }
                i10++;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String hexDump(byte[] bArr, int i10, int i11) {
            ObjectUtil.checkPositiveOrZero(i11, "length");
            if (i11 == 0) {
                return "";
            }
            int i12 = i10 + i11;
            char[] cArr = new char[i11 << 1];
            int i13 = 0;
            while (i10 < i12) {
                System.arraycopy(HEXDUMP_TABLE, (bArr[i10] & 255) << 1, cArr, i13, 2);
                i10++;
                i13 += 2;
            }
            return new String(cArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class ThreadLocalDirectByteBuf extends UnpooledDirectByteBuf {
        private static final ObjectPool<ThreadLocalDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<ThreadLocalDirectByteBuf>() { // from class: io.netty.buffer.ByteBufUtil.ThreadLocalDirectByteBuf.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.internal.ObjectPool.ObjectCreator
            public ThreadLocalDirectByteBuf newObject(ObjectPool.Handle<ThreadLocalDirectByteBuf> handle) {
                return new ThreadLocalDirectByteBuf(handle);
            }
        });
        private final ObjectPool.Handle<ThreadLocalDirectByteBuf> handle;

        private ThreadLocalDirectByteBuf(ObjectPool.Handle<ThreadLocalDirectByteBuf> handle) {
            super(UnpooledByteBufAllocator.DEFAULT, 256, Integer.MAX_VALUE);
            this.handle = handle;
        }

        static ThreadLocalDirectByteBuf newInstance() {
            ThreadLocalDirectByteBuf threadLocalDirectByteBuf = RECYCLER.get();
            threadLocalDirectByteBuf.resetRefCnt();
            return threadLocalDirectByteBuf;
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf
        protected void deallocate() {
            if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                super.deallocate();
            } else {
                clear();
                this.handle.recycle(this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class ThreadLocalUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
        private static final ObjectPool<ThreadLocalUnsafeDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<ThreadLocalUnsafeDirectByteBuf>() { // from class: io.netty.buffer.ByteBufUtil.ThreadLocalUnsafeDirectByteBuf.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.internal.ObjectPool.ObjectCreator
            public ThreadLocalUnsafeDirectByteBuf newObject(ObjectPool.Handle<ThreadLocalUnsafeDirectByteBuf> handle) {
                return new ThreadLocalUnsafeDirectByteBuf(handle);
            }
        });
        private final ObjectPool.Handle<ThreadLocalUnsafeDirectByteBuf> handle;

        private ThreadLocalUnsafeDirectByteBuf(ObjectPool.Handle<ThreadLocalUnsafeDirectByteBuf> handle) {
            super(UnpooledByteBufAllocator.DEFAULT, 256, Integer.MAX_VALUE);
            this.handle = handle;
        }

        static ThreadLocalUnsafeDirectByteBuf newInstance() {
            ThreadLocalUnsafeDirectByteBuf threadLocalUnsafeDirectByteBuf = RECYCLER.get();
            threadLocalUnsafeDirectByteBuf.resetRefCnt();
            return threadLocalUnsafeDirectByteBuf;
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf
        protected void deallocate() {
            if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                super.deallocate();
            } else {
                clear();
                this.handle.recycle(this);
            }
        }
    }

    public static int compare(ByteBuf byteBuf, ByteBuf byteBuf2) {
        long jCompareUintBigEndianA;
        if (byteBuf == byteBuf2) {
            return 0;
        }
        int i10 = byteBuf.readableBytes();
        int i11 = byteBuf2.readableBytes();
        int iMin = Math.min(i10, i11);
        int i12 = iMin >>> 2;
        int i13 = iMin & 3;
        int i14 = byteBuf.readerIndex();
        int i15 = byteBuf2.readerIndex();
        if (i12 > 0) {
            boolean z10 = byteBuf.order() == ByteOrder.BIG_ENDIAN;
            int i16 = i12 << 2;
            if (byteBuf.order() == byteBuf2.order()) {
                jCompareUintBigEndianA = z10 ? compareUintBigEndian(byteBuf, byteBuf2, i14, i15, i16) : compareUintLittleEndian(byteBuf, byteBuf2, i14, i15, i16);
            } else {
                jCompareUintBigEndianA = z10 ? compareUintBigEndianA(byteBuf, byteBuf2, i14, i15, i16) : compareUintBigEndianB(byteBuf, byteBuf2, i14, i15, i16);
            }
            if (jCompareUintBigEndianA != 0) {
                return (int) Math.min(2147483647L, Math.max(-2147483648L, jCompareUintBigEndianA));
            }
            i14 += i16;
            i15 += i16;
        }
        int i17 = i13 + i14;
        while (i14 < i17) {
            int unsignedByte = byteBuf.getUnsignedByte(i14) - byteBuf2.getUnsignedByte(i15);
            if (unsignedByte != 0) {
                return unsignedByte;
            }
            i14++;
            i15++;
        }
        return i10 - i11;
    }

    private static long compareUintBigEndian(ByteBuf byteBuf, ByteBuf byteBuf2, int i10, int i11, int i12) {
        int i13 = i12 + i10;
        while (i10 < i13) {
            long unsignedInt = byteBuf.getUnsignedInt(i10) - byteBuf2.getUnsignedInt(i11);
            if (unsignedInt != 0) {
                return unsignedInt;
            }
            i10 += 4;
            i11 += 4;
        }
        return 0L;
    }

    private static long compareUintBigEndianA(ByteBuf byteBuf, ByteBuf byteBuf2, int i10, int i11, int i12) {
        int i13 = i12 + i10;
        while (i10 < i13) {
            long unsignedInt = byteBuf.getUnsignedInt(i10) - uintFromLE(byteBuf2.getUnsignedIntLE(i11));
            if (unsignedInt != 0) {
                return unsignedInt;
            }
            i10 += 4;
            i11 += 4;
        }
        return 0L;
    }

    private static long compareUintBigEndianB(ByteBuf byteBuf, ByteBuf byteBuf2, int i10, int i11, int i12) {
        int i13 = i12 + i10;
        while (i10 < i13) {
            long jUintFromLE = uintFromLE(byteBuf.getUnsignedIntLE(i10)) - byteBuf2.getUnsignedInt(i11);
            if (jUintFromLE != 0) {
                return jUintFromLE;
            }
            i10 += 4;
            i11 += 4;
        }
        return 0L;
    }

    private static long compareUintLittleEndian(ByteBuf byteBuf, ByteBuf byteBuf2, int i10, int i11, int i12) {
        int i13 = i12 + i10;
        while (i10 < i13) {
            long jUintFromLE = uintFromLE(byteBuf.getUnsignedIntLE(i10)) - uintFromLE(byteBuf2.getUnsignedIntLE(i11));
            if (jUintFromLE != 0) {
                return jUintFromLE;
            }
            i10 += 4;
            i11 += 4;
        }
        return 0L;
    }

    public static void copy(AsciiString asciiString, ByteBuf byteBuf) {
        copy(asciiString, 0, byteBuf, asciiString.length());
    }

    public static boolean equals(ByteBuf byteBuf, int i10, ByteBuf byteBuf2, int i11, int i12) {
        ObjectUtil.checkNotNull(byteBuf, "a");
        ObjectUtil.checkNotNull(byteBuf2, "b");
        ObjectUtil.checkPositiveOrZero(i10, "aStartIndex");
        ObjectUtil.checkPositiveOrZero(i11, "bStartIndex");
        ObjectUtil.checkPositiveOrZero(i12, "length");
        if (byteBuf.writerIndex() - i12 < i10 || byteBuf2.writerIndex() - i12 < i11) {
            return false;
        }
        int i13 = i12 >>> 3;
        if (byteBuf.order() == byteBuf2.order()) {
            while (i13 > 0) {
                if (byteBuf.getLong(i10) != byteBuf2.getLong(i11)) {
                    return false;
                }
                i10 += 8;
                i11 += 8;
                i13--;
            }
        } else {
            while (i13 > 0) {
                if (byteBuf.getLong(i10) != swapLong(byteBuf2.getLong(i11))) {
                    return false;
                }
                i10 += 8;
                i11 += 8;
                i13--;
            }
        }
        for (int i14 = i12 & 7; i14 > 0; i14--) {
            if (byteBuf.getByte(i10) != byteBuf2.getByte(i11)) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    public static byte[] getBytes(ByteBuf byteBuf) {
        return getBytes(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    private static int safeArrayWriteUtf8(byte[] bArr, int i10, CharSequence charSequence, int i11, int i12) {
        int i13 = i10;
        while (i11 < i12) {
            char cCharAt = charSequence.charAt(i11);
            if (cCharAt < 128) {
                bArr[i13] = (byte) cCharAt;
                i13++;
            } else if (cCharAt < 2048) {
                int i14 = i13 + 1;
                bArr[i13] = (byte) ((cCharAt >> 6) | RsaOaep.DerParser.PRIVATE);
                i13 += 2;
                bArr[i14] = (byte) ((cCharAt & '?') | 128);
            } else {
                if (!StringUtil.isSurrogate(cCharAt)) {
                    bArr[i13] = (byte) ((cCharAt >> '\f') | 224);
                    int i15 = i13 + 2;
                    bArr[i13 + 1] = (byte) ((63 & (cCharAt >> 6)) | 128);
                    i13 += 3;
                    bArr[i15] = (byte) ((cCharAt & '?') | 128);
                } else if (Character.isHighSurrogate(cCharAt)) {
                    i11++;
                    if (i11 == i12) {
                        bArr[i13] = 63;
                        i13++;
                        break;
                    }
                    char cCharAt2 = charSequence.charAt(i11);
                    if (Character.isLowSurrogate(cCharAt2)) {
                        int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                        bArr[i13] = (byte) ((codePoint >> 18) | 240);
                        bArr[i13 + 1] = (byte) (((codePoint >> 12) & 63) | 128);
                        int i16 = i13 + 3;
                        bArr[i13 + 2] = (byte) (((codePoint >> 6) & 63) | 128);
                        i13 += 4;
                        bArr[i16] = (byte) ((codePoint & 63) | 128);
                    } else {
                        int i17 = i13 + 1;
                        bArr[i13] = 63;
                        i13 += 2;
                        bArr[i17] = (byte) (Character.isHighSurrogate(cCharAt2) ? '?' : cCharAt2);
                    }
                } else {
                    bArr[i13] = 63;
                    i13++;
                }
            }
            i11++;
        }
        return i13 - i10;
    }

    private static int safeDirectWriteUtf8(ByteBuffer byteBuffer, int i10, CharSequence charSequence, int i11, int i12) {
        int i13 = i10;
        while (i11 < i12) {
            char cCharAt = charSequence.charAt(i11);
            if (cCharAt < 128) {
                byteBuffer.put(i13, (byte) cCharAt);
                i13++;
            } else if (cCharAt < 2048) {
                int i14 = i13 + 1;
                byteBuffer.put(i13, (byte) ((cCharAt >> 6) | RsaOaep.DerParser.PRIVATE));
                i13 += 2;
                byteBuffer.put(i14, (byte) ((cCharAt & '?') | 128));
            } else {
                if (!StringUtil.isSurrogate(cCharAt)) {
                    byteBuffer.put(i13, (byte) ((cCharAt >> '\f') | 224));
                    int i15 = i13 + 2;
                    byteBuffer.put(i13 + 1, (byte) ((63 & (cCharAt >> 6)) | 128));
                    i13 += 3;
                    byteBuffer.put(i15, (byte) ((cCharAt & '?') | 128));
                } else if (Character.isHighSurrogate(cCharAt)) {
                    i11++;
                    if (i11 == i12) {
                        byteBuffer.put(i13, (byte) 63);
                        i13++;
                        break;
                    }
                    char cCharAt2 = charSequence.charAt(i11);
                    if (Character.isLowSurrogate(cCharAt2)) {
                        int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                        byteBuffer.put(i13, (byte) ((codePoint >> 18) | 240));
                        byteBuffer.put(i13 + 1, (byte) (((codePoint >> 12) & 63) | 128));
                        int i16 = i13 + 3;
                        byteBuffer.put(i13 + 2, (byte) (((codePoint >> 6) & 63) | 128));
                        i13 += 4;
                        byteBuffer.put(i16, (byte) ((codePoint & 63) | 128));
                    } else {
                        int i17 = i13 + 1;
                        byteBuffer.put(i13, (byte) 63);
                        i13 += 2;
                        byteBuffer.put(i17, Character.isHighSurrogate(cCharAt2) ? (byte) 63 : (byte) cCharAt2);
                    }
                } else {
                    byteBuffer.put(i13, (byte) 63);
                    i13++;
                }
            }
            i11++;
        }
        return i13 - i10;
    }

    private static int safeWriteUtf8(AbstractByteBuf abstractByteBuf, int i10, CharSequence charSequence, int i11, int i12) {
        int i13 = i10;
        while (i11 < i12) {
            char cCharAt = charSequence.charAt(i11);
            if (cCharAt < 128) {
                abstractByteBuf._setByte(i13, (byte) cCharAt);
                i13++;
            } else if (cCharAt < 2048) {
                int i14 = i13 + 1;
                abstractByteBuf._setByte(i13, (byte) ((cCharAt >> 6) | RsaOaep.DerParser.PRIVATE));
                i13 += 2;
                abstractByteBuf._setByte(i14, (byte) ((cCharAt & '?') | 128));
            } else {
                if (!StringUtil.isSurrogate(cCharAt)) {
                    abstractByteBuf._setByte(i13, (byte) ((cCharAt >> '\f') | 224));
                    int i15 = i13 + 2;
                    abstractByteBuf._setByte(i13 + 1, (byte) ((63 & (cCharAt >> 6)) | 128));
                    i13 += 3;
                    abstractByteBuf._setByte(i15, (byte) ((cCharAt & '?') | 128));
                } else if (Character.isHighSurrogate(cCharAt)) {
                    i11++;
                    if (i11 == i12) {
                        abstractByteBuf._setByte(i13, 63);
                        i13++;
                        break;
                    }
                    char cCharAt2 = charSequence.charAt(i11);
                    if (Character.isLowSurrogate(cCharAt2)) {
                        int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                        abstractByteBuf._setByte(i13, (byte) ((codePoint >> 18) | 240));
                        abstractByteBuf._setByte(i13 + 1, (byte) (((codePoint >> 12) & 63) | 128));
                        int i16 = i13 + 3;
                        abstractByteBuf._setByte(i13 + 2, (byte) (((codePoint >> 6) & 63) | 128));
                        i13 += 4;
                        abstractByteBuf._setByte(i16, (byte) ((codePoint & 63) | 128));
                    } else {
                        int i17 = i13 + 1;
                        abstractByteBuf._setByte(i13, 63);
                        i13 += 2;
                        abstractByteBuf._setByte(i17, Character.isHighSurrogate(cCharAt2) ? '?' : cCharAt2);
                    }
                } else {
                    abstractByteBuf._setByte(i13, 63);
                    i13++;
                }
            }
            i11++;
        }
        return i13 - i10;
    }

    public static int utf8MaxBytes(int i10) {
        return i10 * MAX_BYTES_PER_CHAR_UTF8;
    }

    public static int writeAscii(ByteBuf byteBuf, CharSequence charSequence) {
        while (true) {
            if (byteBuf instanceof WrappedCompositeByteBuf) {
                byteBuf = byteBuf.unwrap();
            } else {
                if (byteBuf instanceof AbstractByteBuf) {
                    int length = charSequence.length();
                    AbstractByteBuf abstractByteBuf = (AbstractByteBuf) byteBuf;
                    abstractByteBuf.ensureWritable0(length);
                    if (charSequence instanceof AsciiString) {
                        writeAsciiString(abstractByteBuf, abstractByteBuf.writerIndex, (AsciiString) charSequence, 0, length);
                    } else {
                        writeAscii(abstractByteBuf, abstractByteBuf.writerIndex, charSequence, length);
                    }
                    abstractByteBuf.writerIndex += length;
                    return length;
                }
                if (!(byteBuf instanceof WrappedByteBuf)) {
                    byte[] bytes = charSequence.toString().getBytes(CharsetUtil.US_ASCII);
                    byteBuf.writeBytes(bytes);
                    return bytes.length;
                }
                byteBuf = byteBuf.unwrap();
            }
        }
    }

    static int writeUtf8(AbstractByteBuf abstractByteBuf, int i10, int i11, CharSequence charSequence, int i12) {
        return writeUtf8(abstractByteBuf, i10, i11, charSequence, 0, i12);
    }

    static {
        ByteBufAllocator byteBufAllocator;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) ByteBufUtil.class);
        logger = internalLoggerFactory;
        BYTE_ARRAYS = new FastThreadLocal<byte[]>() { // from class: io.netty.buffer.ByteBufUtil.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public byte[] initialValue() {
                return PlatformDependent.allocateUninitializedArray(1024);
            }
        };
        MAX_BYTES_PER_CHAR_UTF8 = (int) CharsetUtil.encoder(CharsetUtil.UTF_8).maxBytesPerChar();
        String strTrim = SystemPropertyUtil.get("io.netty.allocator.type", PlatformDependent.isAndroid() ? "unpooled" : "pooled").toLowerCase(Locale.US).trim();
        if ("unpooled".equals(strTrim)) {
            byteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
            internalLoggerFactory.debug("-Dio.netty.allocator.type: {}", strTrim);
        } else if ("pooled".equals(strTrim)) {
            byteBufAllocator = PooledByteBufAllocator.DEFAULT;
            internalLoggerFactory.debug("-Dio.netty.allocator.type: {}", strTrim);
        } else {
            byteBufAllocator = PooledByteBufAllocator.DEFAULT;
            internalLoggerFactory.debug("-Dio.netty.allocator.type: pooled (unknown: {})", strTrim);
        }
        DEFAULT_ALLOCATOR = byteBufAllocator;
        int i10 = SystemPropertyUtil.getInt("io.netty.threadLocalDirectBufferSize", 0);
        THREAD_LOCAL_BUFFER_SIZE = i10;
        internalLoggerFactory.debug("-Dio.netty.threadLocalDirectBufferSize: {}", Integer.valueOf(i10));
        int i11 = SystemPropertyUtil.getInt("io.netty.maxThreadLocalCharBufferSize", 16384);
        MAX_CHAR_BUFFER_SIZE = i11;
        internalLoggerFactory.debug("-Dio.netty.maxThreadLocalCharBufferSize: {}", Integer.valueOf(i11));
        FIND_NON_ASCII = new ByteProcessor() { // from class: io.netty.buffer.ByteBufUtil.2
            @Override // io.netty.util.ByteProcessor
            public boolean process(byte b10) {
                return b10 >= 0;
            }
        };
    }

    public static void copy(AsciiString asciiString, int i10, ByteBuf byteBuf, int i11, int i12) {
        if (!MathUtil.isOutOfBounds(i10, i12, asciiString.length())) {
            ((ByteBuf) ObjectUtil.checkNotNull(byteBuf, "dst")).setBytes(i11, asciiString.array(), i10 + asciiString.arrayOffset(), i12);
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + i10 + ") <= srcIdx + length(" + i12 + ") <= srcLen(" + asciiString.length() + ')');
    }

    static String decodeString(ByteBuf byteBuf, int i10, int i11, Charset charset) {
        byte[] bArrThreadLocalTempArray;
        int iArrayOffset;
        if (i11 == 0) {
            return "";
        }
        if (byteBuf.hasArray()) {
            bArrThreadLocalTempArray = byteBuf.array();
            iArrayOffset = byteBuf.arrayOffset() + i10;
        } else {
            bArrThreadLocalTempArray = threadLocalTempArray(i11);
            byteBuf.getBytes(i10, bArrThreadLocalTempArray, 0, i11);
            iArrayOffset = 0;
        }
        return CharsetUtil.US_ASCII.equals(charset) ? new String(bArrThreadLocalTempArray, 0, iArrayOffset, i11) : new String(bArrThreadLocalTempArray, iArrayOffset, i11, charset);
    }

    public static byte[] getBytes(ByteBuf byteBuf, int i10, int i11) {
        return getBytes(byteBuf, i10, i11, true);
    }

    public static int swapMedium(int i10) {
        int i11 = ((i10 >>> 16) & 255) | ((i10 << 16) & 16711680) | (65280 & i10);
        return (8388608 & i11) != 0 ? i11 | ViewCompat.MEASURED_STATE_MASK : i11;
    }

    public static ByteBuf threadLocalDirectBuffer() {
        if (THREAD_LOCAL_BUFFER_SIZE <= 0) {
            return null;
        }
        return PlatformDependent.hasUnsafe() ? ThreadLocalUnsafeDirectByteBuf.newInstance() : ThreadLocalDirectByteBuf.newInstance();
    }

    static byte[] threadLocalTempArray(int i10) {
        return i10 <= 1024 ? BYTE_ARRAYS.get() : PlatformDependent.allocateUninitializedArray(i10);
    }

    private static int unsafeWriteUtf8(byte[] bArr, long j10, int i10, CharSequence charSequence, int i11, int i12) {
        long j11 = j10 + ((long) i10);
        int i13 = i11;
        long j12 = j11;
        while (i13 < i12) {
            char cCharAt = charSequence.charAt(i13);
            if (cCharAt < 128) {
                PlatformDependent.putByte(bArr, j12, (byte) cCharAt);
                j12 = 1 + j12;
            } else if (cCharAt < 2048) {
                long j13 = 1 + j12;
                PlatformDependent.putByte(bArr, j12, (byte) ((cCharAt >> 6) | RsaOaep.DerParser.PRIVATE));
                j12 += 2;
                PlatformDependent.putByte(bArr, j13, (byte) ((cCharAt & '?') | 128));
            } else {
                if (!StringUtil.isSurrogate(cCharAt)) {
                    PlatformDependent.putByte(bArr, j12, (byte) ((cCharAt >> '\f') | 224));
                    long j14 = 2 + j12;
                    PlatformDependent.putByte(bArr, j12 + 1, (byte) (((cCharAt >> 6) & 63) | 128));
                    j12 += 3;
                    PlatformDependent.putByte(bArr, j14, (byte) ((cCharAt & '?') | 128));
                } else if (Character.isHighSurrogate(cCharAt)) {
                    i13++;
                    if (i13 == i12) {
                        PlatformDependent.putByte(bArr, j12, (byte) 63);
                        j12++;
                        break;
                    }
                    char cCharAt2 = charSequence.charAt(i13);
                    if (Character.isLowSurrogate(cCharAt2)) {
                        int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                        PlatformDependent.putByte(bArr, j12, (byte) ((codePoint >> 18) | 240));
                        PlatformDependent.putByte(bArr, j12 + 1, (byte) (((codePoint >> 12) & 63) | 128));
                        long j15 = j12 + 3;
                        PlatformDependent.putByte(bArr, 2 + j12, (byte) (((codePoint >> 6) & 63) | 128));
                        j12 += 4;
                        PlatformDependent.putByte(bArr, j15, (byte) ((codePoint & 63) | 128));
                    } else {
                        long j16 = j12 + 1;
                        PlatformDependent.putByte(bArr, j12, (byte) 63);
                        j12 += 2;
                        PlatformDependent.putByte(bArr, j16, (byte) (Character.isHighSurrogate(cCharAt2) ? '?' : cCharAt2));
                    }
                } else {
                    PlatformDependent.putByte(bArr, j12, (byte) 63);
                    j12++;
                }
            }
            i13++;
        }
        return (int) (j12 - j11);
    }

    public static int utf8MaxBytes(CharSequence charSequence) {
        return utf8MaxBytes(charSequence.length());
    }

    static int writeUtf8(AbstractByteBuf abstractByteBuf, int i10, int i11, CharSequence charSequence, int i12, int i13) {
        int i14;
        CharSequence charSequence2;
        int i15;
        int i16;
        if (charSequence instanceof AsciiString) {
            writeAsciiString(abstractByteBuf, i10, (AsciiString) charSequence, i12, i13);
            return i13 - i12;
        }
        if (!PlatformDependent.hasUnsafe()) {
            i14 = i10;
            charSequence2 = charSequence;
            i15 = i12;
            i16 = i13;
            if (abstractByteBuf.hasArray()) {
                return safeArrayWriteUtf8(abstractByteBuf.array(), abstractByteBuf.arrayOffset() + i14, charSequence2, i15, i16);
            }
            if (abstractByteBuf.isDirect()) {
                ByteBuffer byteBufferInternalNioBuffer = abstractByteBuf.internalNioBuffer(i14, i11);
                return safeDirectWriteUtf8(byteBufferInternalNioBuffer, byteBufferInternalNioBuffer.position(), charSequence2, i15, i16);
            }
        } else {
            if (abstractByteBuf.hasArray()) {
                return unsafeWriteUtf8(abstractByteBuf.array(), PlatformDependent.byteArrayBaseOffset(), abstractByteBuf.arrayOffset() + i10, charSequence, i12, i13);
            }
            charSequence2 = charSequence;
            i15 = i12;
            i16 = i13;
            if (abstractByteBuf.hasMemoryAddress()) {
                return unsafeWriteUtf8(null, abstractByteBuf.memoryAddress(), i10, charSequence2, i15, i16);
            }
            i14 = i10;
        }
        return safeWriteUtf8(abstractByteBuf, i14, charSequence2, i15, i16);
    }

    private ByteBufUtil() {
    }

    public static byte[] getBytes(ByteBuf byteBuf, int i10, int i11, boolean z10) {
        int iCapacity = byteBuf.capacity();
        if (!MathUtil.isOutOfBounds(i10, i11, iCapacity)) {
            if (byteBuf.hasArray()) {
                int iArrayOffset = byteBuf.arrayOffset() + i10;
                byte[] bArrArray = byteBuf.array();
                return (!z10 && iArrayOffset == 0 && i11 == bArrArray.length) ? bArrArray : Arrays.copyOfRange(bArrArray, iArrayOffset, i11 + iArrayOffset);
            }
            byte[] bArrAllocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i11);
            byteBuf.getBytes(i10, bArrAllocateUninitializedArray);
            return bArrAllocateUninitializedArray;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i10 + ") <= start + length(" + i11 + ") <= buf.capacity(" + iCapacity + ')');
    }

    public static int hashCode(ByteBuf byteBuf) {
        int iSwapInt;
        int i10 = byteBuf.readableBytes();
        int i11 = i10 >>> 2;
        int i12 = i10 & 3;
        int i13 = byteBuf.readerIndex();
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            iSwapInt = 1;
            while (i11 > 0) {
                iSwapInt = (iSwapInt * 31) + byteBuf.getInt(i13);
                i13 += 4;
                i11--;
            }
        } else {
            iSwapInt = 1;
            while (i11 > 0) {
                iSwapInt = (iSwapInt * 31) + swapInt(byteBuf.getInt(i13));
                i13 += 4;
                i11--;
            }
        }
        while (i12 > 0) {
            iSwapInt = (iSwapInt * 31) + byteBuf.getByte(i13);
            i12--;
            i13++;
        }
        if (iSwapInt == 0) {
            return 1;
        }
        return iSwapInt;
    }

    public static String hexDump(byte[] bArr, int i10, int i11) {
        return HexUtil.hexDump(bArr, i10, i11);
    }

    public static boolean isAccessible(ByteBuf byteBuf) {
        return byteBuf.isAccessible();
    }

    public static ByteBuf setShortBE(ByteBuf byteBuf, int i10, int i11) {
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            return byteBuf.setShort(i10, i11);
        }
        return byteBuf.setShort(i10, swapShort((short) i11));
    }

    public static int swapInt(int i10) {
        return Integer.reverseBytes(i10);
    }

    public static long swapLong(long j10) {
        return Long.reverseBytes(j10);
    }

    public static short swapShort(short s10) {
        return Short.reverseBytes(s10);
    }

    private static long uintFromLE(long j10) {
        return Long.reverseBytes(j10) >>> 32;
    }

    static void writeAsciiString(AbstractByteBuf abstractByteBuf, int i10, AsciiString asciiString, int i11, int i12) {
        int iArrayOffset = asciiString.arrayOffset() + i11;
        int i13 = i12 - i11;
        if (PlatformDependent.hasUnsafe()) {
            if (abstractByteBuf.hasArray()) {
                PlatformDependent.copyMemory(asciiString.array(), iArrayOffset, abstractByteBuf.array(), abstractByteBuf.arrayOffset() + i10, i13);
                return;
            } else if (abstractByteBuf.hasMemoryAddress()) {
                PlatformDependent.copyMemory(asciiString.array(), iArrayOffset, abstractByteBuf.memoryAddress() + ((long) i10), i13);
                return;
            }
        }
        if (abstractByteBuf.hasArray()) {
            System.arraycopy(asciiString.array(), iArrayOffset, abstractByteBuf.array(), abstractByteBuf.arrayOffset() + i10, i13);
        } else {
            abstractByteBuf.setBytes(i10, asciiString.array(), iArrayOffset, i13);
        }
    }

    public static ByteBuf writeMediumBE(ByteBuf byteBuf, int i10) {
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            return byteBuf.writeMedium(i10);
        }
        return byteBuf.writeMedium(swapMedium(i10));
    }

    public static ByteBuf writeShortBE(ByteBuf byteBuf, int i10) {
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            return byteBuf.writeShort(i10);
        }
        return byteBuf.writeShort(swapShort((short) i10));
    }

    public static void copy(AsciiString asciiString, int i10, ByteBuf byteBuf, int i11) {
        if (!MathUtil.isOutOfBounds(i10, i11, asciiString.length())) {
            ((ByteBuf) ObjectUtil.checkNotNull(byteBuf, "dst")).writeBytes(asciiString.array(), i10 + asciiString.arrayOffset(), i11);
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + i10 + ") <= srcIdx + length(" + i11 + ") <= srcLen(" + asciiString.length() + ')');
    }

    public static boolean equals(ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (byteBuf == byteBuf2) {
            return true;
        }
        int i10 = byteBuf.readableBytes();
        if (i10 != byteBuf2.readableBytes()) {
            return false;
        }
        return equals(byteBuf, byteBuf.readerIndex(), byteBuf2, byteBuf2.readerIndex(), i10);
    }

    static int writeAscii(AbstractByteBuf abstractByteBuf, int i10, CharSequence charSequence, int i11) {
        int i12 = 0;
        while (i12 < i11) {
            abstractByteBuf._setByte(i10, AsciiString.c2b(charSequence.charAt(i12)));
            i12++;
            i10++;
        }
        return i11;
    }
}
