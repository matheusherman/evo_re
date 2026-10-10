package io.netty.util.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.collection.ScatterMapKt;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class PlatformDependent0 {
    private static final long ADDRESS_FIELD_OFFSET;
    private static final Method ALIGN_SLICE;
    private static final Method ALLOCATE_ARRAY_METHOD;
    private static final long BYTE_ARRAY_BASE_OFFSET;
    private static final Constructor<?> DIRECT_BUFFER_CONSTRUCTOR;
    private static final Throwable EXPLICIT_NO_UNSAFE_CAUSE;
    private static final Object INTERNAL_UNSAFE;
    private static final long INT_ARRAY_BASE_OFFSET;
    private static final long INT_ARRAY_INDEX_SCALE;
    private static final boolean IS_ANDROID;
    private static final boolean IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE;
    private static final int JAVA_VERSION;
    private static final long LONG_ARRAY_BASE_OFFSET;
    private static final long LONG_ARRAY_INDEX_SCALE;
    private static final boolean RUNNING_IN_NATIVE_IMAGE;
    private static final boolean STORE_FENCE_AVAILABLE;
    private static final boolean UNALIGNED;
    static final Unsafe UNSAFE;
    private static final Throwable UNSAFE_UNAVAILABILITY_CAUSE;
    private static final InternalLogger logger;

    static void copyMemory(long j10, long j11, long j12) {
        if (javaVersion() <= 8) {
            copyMemoryWithSafePointPolling(j10, j11, j12);
        } else {
            UNSAFE.copyMemory(j10, j11, j12);
        }
    }

    private static void copyMemoryWithSafePointPolling(long j10, long j11, long j12) {
        long j13 = j10;
        long j14 = j11;
        while (j12 > 0) {
            long jMin = Math.min(j12, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            UNSAFE.copyMemory(j13, j14, jMin);
            j12 -= jMin;
            j13 += jMin;
            j14 += jMin;
        }
    }

    static byte getByte(long j10) {
        return UNSAFE.getByte(j10);
    }

    static int getInt(Object obj, long j10) {
        return UNSAFE.getInt(obj, j10);
    }

    private static long getLong(Object obj, long j10) {
        return UNSAFE.getLong(obj, j10);
    }

    static short getShort(long j10) {
        return UNSAFE.getShort(j10);
    }

    static int hashCodeAsciiSanitize(byte b10) {
        return b10 & 31;
    }

    static void putByte(long j10, byte b10) {
        UNSAFE.putByte(j10, b10);
    }

    static void putInt(long j10, int i10) {
        UNSAFE.putInt(j10, i10);
    }

    static void putShort(long j10, short s10) {
        UNSAFE.putShort(j10, s10);
    }

    static {
        final ByteBuffer byteBufferAllocateDirect;
        final Unsafe unsafe;
        boolean z10;
        Field field;
        long jAllocateMemory;
        char c10;
        Constructor<?> constructor;
        boolean zMatches;
        Object obj;
        Method method;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) PlatformDependent0.class);
        logger = internalLoggerFactory;
        Throwable thExplicitNoUnsafeCause0 = explicitNoUnsafeCause0();
        EXPLICIT_NO_UNSAFE_CAUSE = thExplicitNoUnsafeCause0;
        JAVA_VERSION = javaVersion0();
        IS_ANDROID = isAndroid0();
        RUNNING_IN_NATIVE_IMAGE = SystemPropertyUtil.contains("org.graalvm.nativeimage.imagecode");
        IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE = explicitTryReflectionSetAccessible0();
        if (thExplicitNoUnsafeCause0 != null) {
            byteBufferAllocateDirect = null;
            unsafe = null;
            field = null;
            z10 = false;
        } else {
            byteBufferAllocateDirect = ByteBuffer.allocateDirect(1);
            Object objDoPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
                        Throwable thTrySetAccessible = ReflectionUtil.trySetAccessible(declaredField, false);
                        return thTrySetAccessible != null ? thTrySetAccessible : declaredField.get(null);
                    } catch (IllegalAccessException | NoClassDefFoundError | NoSuchFieldException | SecurityException e10) {
                        return e10;
                    }
                }
            });
            if (objDoPrivileged instanceof Throwable) {
                thExplicitNoUnsafeCause0 = (Throwable) objDoPrivileged;
                if (internalLoggerFactory.isTraceEnabled()) {
                    internalLoggerFactory.debug("sun.misc.Unsafe.theUnsafe: unavailable", thExplicitNoUnsafeCause0);
                } else {
                    internalLoggerFactory.debug("sun.misc.Unsafe.theUnsafe: unavailable: {}", thExplicitNoUnsafeCause0.getMessage());
                }
                unsafe = null;
            } else {
                unsafe = (Unsafe) objDoPrivileged;
                internalLoggerFactory.debug("sun.misc.Unsafe.theUnsafe: available");
            }
            if (unsafe != null) {
                Object objDoPrivileged2 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.2
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            Class<?> cls = unsafe.getClass();
                            Class<?> cls2 = Long.TYPE;
                            cls.getDeclaredMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                            return null;
                        } catch (NoSuchMethodException | SecurityException e10) {
                            return e10;
                        }
                    }
                });
                if (objDoPrivileged2 == null) {
                    internalLoggerFactory.debug("sun.misc.Unsafe.copyMemory: available");
                } else {
                    thExplicitNoUnsafeCause0 = (Throwable) objDoPrivileged2;
                    if (internalLoggerFactory.isTraceEnabled()) {
                        internalLoggerFactory.debug("sun.misc.Unsafe.copyMemory: unavailable", thExplicitNoUnsafeCause0);
                    } else {
                        internalLoggerFactory.debug("sun.misc.Unsafe.copyMemory: unavailable: {}", thExplicitNoUnsafeCause0.getMessage());
                    }
                    unsafe = null;
                }
            }
            if (unsafe == null) {
                z10 = false;
            } else {
                Object objDoPrivileged3 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.3
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            unsafe.getClass().getDeclaredMethod("storeFence", null);
                            return null;
                        } catch (NoSuchMethodException | SecurityException e10) {
                            return e10;
                        }
                    }
                });
                if (objDoPrivileged3 == null) {
                    internalLoggerFactory.debug("sun.misc.Unsafe.storeFence: available");
                    z10 = true;
                } else {
                    if (internalLoggerFactory.isTraceEnabled()) {
                        internalLoggerFactory.debug("sun.misc.Unsafe.storeFence: unavailable", (Throwable) objDoPrivileged3);
                    } else {
                        internalLoggerFactory.debug("sun.misc.Unsafe.storeFence: unavailable: {}", ((Throwable) objDoPrivileged3).getMessage());
                    }
                    z10 = false;
                }
            }
            if (unsafe != null) {
                Object objDoPrivileged4 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.4
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            Field declaredField = Buffer.class.getDeclaredField("address");
                            if (unsafe.getLong(byteBufferAllocateDirect, unsafe.objectFieldOffset(declaredField)) == 0) {
                                return null;
                            }
                            return declaredField;
                        } catch (NoSuchFieldException | SecurityException e10) {
                            return e10;
                        }
                    }
                });
                if (objDoPrivileged4 instanceof Field) {
                    field = (Field) objDoPrivileged4;
                    internalLoggerFactory.debug("java.nio.Buffer.address: available");
                } else {
                    Throwable th = (Throwable) objDoPrivileged4;
                    if (internalLoggerFactory.isTraceEnabled()) {
                        internalLoggerFactory.debug("java.nio.Buffer.address: unavailable", th);
                    } else {
                        internalLoggerFactory.debug("java.nio.Buffer.address: unavailable: {}", th.getMessage());
                    }
                    unsafe = null;
                    thExplicitNoUnsafeCause0 = th;
                    field = null;
                }
            } else {
                field = null;
            }
            if (unsafe != null) {
                long jArrayIndexScale = unsafe.arrayIndexScale(byte[].class);
                if (jArrayIndexScale != 1) {
                    internalLoggerFactory.debug("unsafe.arrayIndexScale is {} (expected: 1). Not using unsafe.", Long.valueOf(jArrayIndexScale));
                    thExplicitNoUnsafeCause0 = new UnsupportedOperationException("Unexpected unsafe.arrayIndexScale");
                    unsafe = null;
                }
            }
        }
        UNSAFE_UNAVAILABILITY_CAUSE = thExplicitNoUnsafeCause0;
        UNSAFE = unsafe;
        if (unsafe == null) {
            ADDRESS_FIELD_OFFSET = -1L;
            BYTE_ARRAY_BASE_OFFSET = -1L;
            LONG_ARRAY_BASE_OFFSET = -1L;
            LONG_ARRAY_INDEX_SCALE = -1L;
            INT_ARRAY_BASE_OFFSET = -1L;
            INT_ARRAY_INDEX_SCALE = -1L;
            UNALIGNED = false;
            DIRECT_BUFFER_CONSTRUCTOR = null;
            ALLOCATE_ARRAY_METHOD = null;
            STORE_FENCE_AVAILABLE = false;
            obj = null;
        } else {
            try {
                Object objDoPrivileged5 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.5
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            Constructor<?> declaredConstructor = byteBufferAllocateDirect.getClass().getDeclaredConstructor(Long.TYPE, Integer.TYPE);
                            Throwable thTrySetAccessible = ReflectionUtil.trySetAccessible(declaredConstructor, true);
                            return thTrySetAccessible != null ? thTrySetAccessible : declaredConstructor;
                        } catch (NoSuchMethodException | SecurityException e10) {
                            return e10;
                        }
                    }
                });
                if (objDoPrivileged5 instanceof Constructor) {
                    jAllocateMemory = unsafe.allocateMemory(1L);
                    try {
                        try {
                            c10 = 1;
                            try {
                                ((Constructor) objDoPrivileged5).newInstance(Long.valueOf(jAllocateMemory), 1);
                                constructor = (Constructor) objDoPrivileged5;
                                internalLoggerFactory.debug("direct buffer constructor: available");
                            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                                constructor = null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (jAllocateMemory != -1) {
                                UNSAFE.freeMemory(jAllocateMemory);
                            }
                            throw th;
                        }
                    } catch (IllegalAccessException unused2) {
                        c10 = 1;
                    } catch (InstantiationException unused3) {
                        c10 = 1;
                    } catch (InvocationTargetException unused4) {
                        c10 = 1;
                    }
                } else {
                    c10 = 1;
                    if (internalLoggerFactory.isTraceEnabled()) {
                        internalLoggerFactory.debug("direct buffer constructor: unavailable", (Throwable) objDoPrivileged5);
                    } else {
                        internalLoggerFactory.debug("direct buffer constructor: unavailable: {}", ((Throwable) objDoPrivileged5).getMessage());
                    }
                    constructor = null;
                    jAllocateMemory = -1;
                }
                if (jAllocateMemory != -1) {
                    UNSAFE.freeMemory(jAllocateMemory);
                }
                DIRECT_BUFFER_CONSTRUCTOR = constructor;
                ADDRESS_FIELD_OFFSET = objectFieldOffset(field);
                Unsafe unsafe2 = UNSAFE;
                BYTE_ARRAY_BASE_OFFSET = unsafe2.arrayBaseOffset(byte[].class);
                INT_ARRAY_BASE_OFFSET = unsafe2.arrayBaseOffset(int[].class);
                INT_ARRAY_INDEX_SCALE = unsafe2.arrayIndexScale(int[].class);
                LONG_ARRAY_BASE_OFFSET = unsafe2.arrayBaseOffset(long[].class);
                LONG_ARRAY_INDEX_SCALE = unsafe2.arrayIndexScale(long[].class);
                Object objDoPrivileged6 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.6
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            Class<?> cls = Class.forName("java.nio.Bits", false, PlatformDependent0.getSystemClassLoader());
                            int iJavaVersion = PlatformDependent0.javaVersion();
                            if (PlatformDependent0.unsafeStaticFieldOffsetSupported() && iJavaVersion >= 9) {
                                try {
                                    Field declaredField = cls.getDeclaredField(iJavaVersion >= 11 ? "UNALIGNED" : "unaligned");
                                    if (declaredField.getType() == Boolean.TYPE) {
                                        Unsafe unsafe3 = PlatformDependent0.UNSAFE;
                                        return Boolean.valueOf(unsafe3.getBoolean(unsafe3.staticFieldBase(declaredField), unsafe3.staticFieldOffset(declaredField)));
                                    }
                                } catch (NoSuchFieldException unused5) {
                                }
                            }
                            Method declaredMethod = cls.getDeclaredMethod("unaligned", null);
                            Throwable thTrySetAccessible = ReflectionUtil.trySetAccessible(declaredMethod, true);
                            return thTrySetAccessible != null ? thTrySetAccessible : declaredMethod.invoke(null, null);
                        } catch (ClassNotFoundException e10) {
                            return e10;
                        } catch (IllegalAccessException e11) {
                            return e11;
                        } catch (NoSuchMethodException e12) {
                            return e12;
                        } catch (SecurityException e13) {
                            return e13;
                        } catch (InvocationTargetException e14) {
                            return e14;
                        }
                    }
                });
                if (objDoPrivileged6 instanceof Boolean) {
                    Boolean bool = (Boolean) objDoPrivileged6;
                    zMatches = bool.booleanValue();
                    logger.debug("java.nio.Bits.unaligned: available, {}", bool);
                } else {
                    zMatches = SystemPropertyUtil.get("os.arch", "").matches("^(i[3-6]86|x86(_64)?|x64|amd64)$");
                    Throwable th3 = (Throwable) objDoPrivileged6;
                    InternalLogger internalLogger = logger;
                    if (internalLogger.isTraceEnabled()) {
                        internalLogger.debug("java.nio.Bits.unaligned: unavailable, {}", Boolean.valueOf(zMatches), th3);
                    } else {
                        internalLogger.debug("java.nio.Bits.unaligned: unavailable, {}, {}", Boolean.valueOf(zMatches), th3.getMessage());
                    }
                }
                UNALIGNED = zMatches;
                if (javaVersion() >= 9) {
                    final Object objDoPrivileged7 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.7
                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            try {
                                return PlatformDependent0.getClassLoader(PlatformDependent0.class).loadClass("jdk.internal.misc.Unsafe").getDeclaredMethod("getUnsafe", null).invoke(null, null);
                            } catch (Throwable th4) {
                                return th4;
                            }
                        }
                    });
                    if (objDoPrivileged7 instanceof Throwable) {
                        obj = null;
                        method = null;
                    } else {
                        Object e10 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.8
                            @Override // java.security.PrivilegedAction
                            public Object run() {
                                try {
                                    return objDoPrivileged7.getClass().getDeclaredMethod("allocateUninitializedArray", Class.class, Integer.TYPE);
                                } catch (NoSuchMethodException | SecurityException e11) {
                                    return e11;
                                }
                            }
                        });
                        if (e10 instanceof Method) {
                            try {
                                method = (Method) e10;
                                Object[] objArr = new Object[2];
                                objArr[0] = Byte.TYPE;
                                objArr[c10] = 8;
                                objDoPrivileged7 = e10;
                                obj = objDoPrivileged7;
                            } catch (IllegalAccessException e11) {
                                e10 = e11;
                                objDoPrivileged7 = e10;
                                obj = objDoPrivileged7;
                                method = null;
                            } catch (InvocationTargetException e12) {
                                e10 = e12;
                                objDoPrivileged7 = e10;
                                obj = objDoPrivileged7;
                                method = null;
                            }
                        } else {
                            objDoPrivileged7 = e10;
                            obj = objDoPrivileged7;
                            method = null;
                        }
                    }
                    if (objDoPrivileged7 instanceof Throwable) {
                        InternalLogger internalLogger2 = logger;
                        if (internalLogger2.isTraceEnabled()) {
                            internalLogger2.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable", (Throwable) objDoPrivileged7);
                        } else {
                            internalLogger2.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable: {}", ((Throwable) objDoPrivileged7).getMessage());
                        }
                    } else {
                        logger.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): available");
                    }
                } else {
                    logger.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable prior to Java9");
                    obj = null;
                    method = null;
                }
                ALLOCATE_ARRAY_METHOD = method;
                STORE_FENCE_AVAILABLE = z10;
            } catch (Throwable th4) {
                th = th4;
                jAllocateMemory = -1;
            }
        }
        if (javaVersion() > 9) {
            ALIGN_SLICE = (Method) AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.PlatformDependent0.9
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        return ByteBuffer.class.getDeclaredMethod("alignedSlice", Integer.TYPE);
                    } catch (Exception unused5) {
                        return null;
                    }
                }
            });
        } else {
            ALIGN_SLICE = null;
        }
        INTERNAL_UNSAFE = obj;
        logger.debug("java.nio.DirectByteBuffer.<init>(long, int): {}", DIRECT_BUFFER_CONSTRUCTOR != null ? "available" : "unavailable");
    }

    static int addressSize() {
        return UNSAFE.addressSize();
    }

    static ByteBuffer alignSlice(ByteBuffer byteBuffer, int i10) {
        try {
            return (ByteBuffer) ALIGN_SLICE.invoke(byteBuffer, Integer.valueOf(i10));
        } catch (IllegalAccessException e10) {
            throw new Error(e10);
        } catch (InvocationTargetException e11) {
            throw new Error(e11);
        }
    }

    static ByteBuffer allocateDirectNoCleaner(int i10) {
        return newDirectBuffer(UNSAFE.allocateMemory(Math.max(1, i10)), i10);
    }

    static byte[] allocateUninitializedArray(int i10) {
        try {
            return (byte[]) ALLOCATE_ARRAY_METHOD.invoke(INTERNAL_UNSAFE, Byte.TYPE, Integer.valueOf(i10));
        } catch (IllegalAccessException e10) {
            throw new Error(e10);
        } catch (InvocationTargetException e11) {
            throw new Error(e11);
        }
    }

    static long byteArrayBaseOffset() {
        return BYTE_ARRAY_BASE_OFFSET;
    }

    static long directBufferAddress(ByteBuffer byteBuffer) {
        return getLong(byteBuffer, ADDRESS_FIELD_OFFSET);
    }

    static boolean equals(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        boolean z10;
        int i13 = i12 & 7;
        long j10 = BYTE_ARRAY_BASE_OFFSET + ((long) i10);
        long j11 = i11 - i10;
        if (i12 >= 8) {
            long j12 = ((long) i13) + j10;
            long j13 = 8;
            z10 = false;
            long j14 = (j10 - 8) + ((long) i12);
            while (j14 >= j12) {
                Unsafe unsafe = UNSAFE;
                long j15 = j13;
                if (unsafe.getLong(bArr, j14) != unsafe.getLong(bArr2, j14 + j11)) {
                    return false;
                }
                j14 -= j15;
                j13 = j15;
            }
        } else {
            z10 = false;
        }
        if (i13 >= 4) {
            i13 -= 4;
            long j16 = ((long) i13) + j10;
            Unsafe unsafe2 = UNSAFE;
            if (unsafe2.getInt(bArr, j16) != unsafe2.getInt(bArr2, j16 + j11)) {
                return z10;
            }
        }
        long j17 = j11 + j10;
        if (i13 < 2) {
            if (i13 != 0) {
                Unsafe unsafe3 = UNSAFE;
                if (unsafe3.getByte(bArr, j10) != unsafe3.getByte(bArr2, j17)) {
                    return z10;
                }
            }
            return true;
        }
        Unsafe unsafe4 = UNSAFE;
        if (unsafe4.getChar(bArr, j10) == unsafe4.getChar(bArr2, j17) && (i13 == 2 || unsafe4.getByte(bArr, j10 + 2) == unsafe4.getByte(bArr2, j17 + 2))) {
            return true;
        }
        return z10;
    }

    private static Throwable explicitNoUnsafeCause0() {
        boolean z10 = SystemPropertyUtil.getBoolean("io.netty.noUnsafe", false);
        InternalLogger internalLogger = logger;
        internalLogger.debug("-Dio.netty.noUnsafe: {}", Boolean.valueOf(z10));
        if (z10) {
            internalLogger.debug("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
            return new UnsupportedOperationException("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
        }
        String str = SystemPropertyUtil.contains("io.netty.tryUnsafe") ? "io.netty.tryUnsafe" : "org.jboss.netty.tryUnsafe";
        if (SystemPropertyUtil.getBoolean(str, true)) {
            return null;
        }
        String str2 = "sun.misc.Unsafe: unavailable (" + str + ")";
        internalLogger.debug(str2);
        return new UnsupportedOperationException(str2);
    }

    static void freeMemory(long j10) {
        UNSAFE.freeMemory(j10);
    }

    static byte getByte(byte[] bArr, int i10) {
        return UNSAFE.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i10));
    }

    static int getInt(long j10) {
        return UNSAFE.getInt(j10);
    }

    static long getLong(long j10) {
        return UNSAFE.getLong(j10);
    }

    static Object getObject(Object obj, long j10) {
        return UNSAFE.getObject(obj, j10);
    }

    static short getShort(byte[] bArr, int i10) {
        return UNSAFE.getShort(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i10));
    }

    static Throwable getUnsafeUnavailabilityCause() {
        return UNSAFE_UNAVAILABILITY_CAUSE;
    }

    static boolean hasAlignSliceMethod() {
        return ALIGN_SLICE != null;
    }

    static boolean hasAllocateArrayMethod() {
        return ALLOCATE_ARRAY_METHOD != null;
    }

    static boolean hasDirectBufferNoCleanerConstructor() {
        return DIRECT_BUFFER_CONSTRUCTOR != null;
    }

    static boolean hasUnsafe() {
        return UNSAFE != null;
    }

    static int hashCodeAscii(byte[] bArr, int i10, int i11) {
        int i12;
        long j10 = BYTE_ARRAY_BASE_OFFSET + ((long) i10);
        int i13 = i11 & 7;
        long j11 = ((long) i13) + j10;
        int iHashCodeAsciiSanitize = -1028477387;
        for (long j12 = (j10 - 8) + ((long) i11); j12 >= j11; j12 -= 8) {
            iHashCodeAsciiSanitize = hashCodeAsciiCompute(UNSAFE.getLong(bArr, j12), iHashCodeAsciiSanitize);
        }
        if (i13 == 0) {
            return iHashCodeAsciiSanitize;
        }
        if (((i13 != 2) && (i13 != 4)) && (i13 != 6)) {
            iHashCodeAsciiSanitize = (iHashCodeAsciiSanitize * ScatterMapKt.MurmurHashC1) + hashCodeAsciiSanitize(UNSAFE.getByte(bArr, j10));
            j10++;
            i12 = 461845907;
        } else {
            i12 = ScatterMapKt.MurmurHashC1;
        }
        if ((i13 != 5) & (i13 != 1) & (i13 != 4)) {
            iHashCodeAsciiSanitize = (iHashCodeAsciiSanitize * i12) + hashCodeAsciiSanitize(UNSAFE.getShort(bArr, j10));
            j10 += 2;
            i12 = i12 != -862048943 ? ScatterMapKt.MurmurHashC1 : 461845907;
        }
        return i13 >= 4 ? (iHashCodeAsciiSanitize * i12) + hashCodeAsciiSanitize(UNSAFE.getInt(bArr, j10)) : iHashCodeAsciiSanitize;
    }

    static int hashCodeAsciiSanitize(int i10) {
        return i10 & 522133279;
    }

    static boolean isAndroid() {
        return IS_ANDROID;
    }

    private static boolean isAndroid0() {
        boolean zEquals = "Dalvik".equals(SystemPropertyUtil.get("java.vm.name"));
        if (zEquals) {
            logger.debug("Platform: Android");
        }
        return zEquals;
    }

    static boolean isExplicitNoUnsafe() {
        return EXPLICIT_NO_UNSAFE_CAUSE != null;
    }

    static boolean isExplicitTryReflectionSetAccessible() {
        return IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE;
    }

    static boolean isUnaligned() {
        return UNALIGNED;
    }

    static int javaVersion() {
        return JAVA_VERSION;
    }

    static int majorVersion(String str) {
        String[] strArrSplit = str.split("\\.");
        int[] iArr = new int[strArrSplit.length];
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            iArr[i10] = Integer.parseInt(strArrSplit[i10]);
        }
        int i11 = iArr[0];
        return i11 == 1 ? iArr[1] : i11;
    }

    static int majorVersionFromJavaSpecificationVersion() {
        return majorVersion(SystemPropertyUtil.get("java.specification.version", "1.6"));
    }

    static ByteBuffer newDirectBuffer(long j10, int i10) {
        ObjectUtil.checkPositiveOrZero(i10, "capacity");
        try {
            return (ByteBuffer) DIRECT_BUFFER_CONSTRUCTOR.newInstance(Long.valueOf(j10), Integer.valueOf(i10));
        } catch (Throwable th) {
            if (th instanceof Error) {
                throw th;
            }
            throw new Error(th);
        }
    }

    static long objectFieldOffset(Field field) {
        return UNSAFE.objectFieldOffset(field);
    }

    static void putByte(byte[] bArr, int i10, byte b10) {
        UNSAFE.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i10), b10);
    }

    static void putInt(byte[] bArr, int i10, int i11) {
        UNSAFE.putInt(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i10), i11);
    }

    static void putObject(Object obj, long j10, Object obj2) {
        UNSAFE.putObject(obj, j10, obj2);
    }

    static void putShort(byte[] bArr, int i10, short s10) {
        UNSAFE.putShort(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i10), s10);
    }

    static ByteBuffer reallocateDirectNoCleaner(ByteBuffer byteBuffer, int i10) {
        return newDirectBuffer(UNSAFE.reallocateMemory(directBufferAddress(byteBuffer), i10), i10);
    }

    static void safeConstructPutInt(Object obj, long j10, int i10) {
        if (!STORE_FENCE_AVAILABLE) {
            UNSAFE.putIntVolatile(obj, j10, i10);
            return;
        }
        Unsafe unsafe = UNSAFE;
        unsafe.putInt(obj, j10, i10);
        unsafe.storeFence();
    }

    static void throwException(Throwable th) {
        UNSAFE.throwException((Throwable) ObjectUtil.checkNotNull(th, "cause"));
    }

    static boolean unalignedAccess() {
        return UNALIGNED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean unsafeStaticFieldOffsetSupported() {
        return !RUNNING_IN_NATIVE_IMAGE;
    }

    private PlatformDependent0() {
    }

    private static void copyMemoryWithSafePointPolling(Object obj, long j10, Object obj2, long j11, long j12) {
        long j13 = j10;
        long j14 = j11;
        long j15 = j12;
        while (j15 > 0) {
            long jMin = Math.min(j15, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            UNSAFE.copyMemory(obj, j13, obj2, j14, jMin);
            j15 -= jMin;
            j13 += jMin;
            j14 += jMin;
        }
    }

    private static boolean explicitTryReflectionSetAccessible0() {
        boolean z10;
        if (javaVersion() >= 9 && !RUNNING_IN_NATIVE_IMAGE) {
            z10 = false;
        } else {
            z10 = true;
        }
        return SystemPropertyUtil.getBoolean("io.netty.tryReflectionSetAccessible", z10);
    }

    static ClassLoader getClassLoader(final Class<?> cls) {
        if (System.getSecurityManager() == null) {
            return cls.getClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return cls.getClassLoader();
            }
        });
    }

    static int getInt(byte[] bArr, int i10) {
        return UNSAFE.getInt(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i10));
    }

    static long getLong(byte[] bArr, int i10) {
        return UNSAFE.getLong(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i10));
    }

    static ClassLoader getSystemClassLoader() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }

    static int hashCodeAsciiCompute(long j10, int i10) {
        return (i10 * ScatterMapKt.MurmurHashC1) + (hashCodeAsciiSanitize((int) j10) * 461845907) + ((int) ((j10 & 2242545357458243584L) >>> 32));
    }

    static int hashCodeAsciiSanitize(short s10) {
        return s10 & 7967;
    }

    private static int javaVersion0() {
        int iMajorVersionFromJavaSpecificationVersion;
        if (isAndroid0()) {
            iMajorVersionFromJavaSpecificationVersion = 6;
        } else {
            iMajorVersionFromJavaSpecificationVersion = majorVersionFromJavaSpecificationVersion();
        }
        logger.debug("Java version: {}", Integer.valueOf(iMajorVersionFromJavaSpecificationVersion));
        return iMajorVersionFromJavaSpecificationVersion;
    }

    static void putByte(Object obj, long j10, byte b10) {
        UNSAFE.putByte(obj, j10, b10);
    }

    static void copyMemory(Object obj, long j10, Object obj2, long j11, long j12) {
        if (javaVersion() <= 8) {
            copyMemoryWithSafePointPolling(obj, j10, obj2, j11, j12);
        } else {
            UNSAFE.copyMemory(obj, j10, obj2, j11, j12);
        }
    }
}
