package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class CleanerJava6 implements Cleaner {
    private static final Field CLEANER_FIELD;
    private static final long CLEANER_FIELD_OFFSET;
    private static final Method CLEAN_METHOD;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) CleanerJava6.class);

    static {
        Field field;
        Method declaredMethod;
        Object object;
        long jObjectFieldOffset;
        final ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(1);
        long j10 = -1;
        Throwable th = null;
        try {
            Object objDoPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.CleanerJava6.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        Field declaredField = byteBufferAllocateDirect.getClass().getDeclaredField("cleaner");
                        if (PlatformDependent.hasUnsafe()) {
                            return declaredField;
                        }
                        declaredField.setAccessible(true);
                        return declaredField;
                    } catch (Throwable th2) {
                        return th2;
                    }
                }
            });
            if (objDoPrivileged instanceof Throwable) {
                throw ((Throwable) objDoPrivileged);
            }
            field = (Field) objDoPrivileged;
            if (PlatformDependent.hasUnsafe()) {
                jObjectFieldOffset = PlatformDependent0.objectFieldOffset(field);
                object = PlatformDependent0.getObject(byteBufferAllocateDirect, jObjectFieldOffset);
            } else {
                object = field.get(byteBufferAllocateDirect);
                jObjectFieldOffset = -1;
            }
            declaredMethod = object.getClass().getDeclaredMethod("clean", null);
            declaredMethod.invoke(object, null);
            j10 = jObjectFieldOffset;
            if (th == null) {
                logger.debug("java.nio.ByteBuffer.cleaner(): available");
            } else {
                logger.debug("java.nio.ByteBuffer.cleaner(): unavailable", th);
            }
            CLEANER_FIELD = field;
            CLEANER_FIELD_OFFSET = j10;
            CLEAN_METHOD = declaredMethod;
        } catch (Throwable th2) {
            field = null;
            declaredMethod = null;
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void freeDirectBuffer0(ByteBuffer byteBuffer) throws IllegalAccessException, InvocationTargetException {
        long j10 = CLEANER_FIELD_OFFSET;
        Object object = j10 == -1 ? CLEANER_FIELD.get(byteBuffer) : PlatformDependent0.getObject(byteBuffer, j10);
        if (object != null) {
            CLEAN_METHOD.invoke(object, null);
        }
    }

    private static void freeDirectBufferPrivileged(final ByteBuffer byteBuffer) {
        Throwable th = (Throwable) AccessController.doPrivileged(new PrivilegedAction<Throwable>() { // from class: io.netty.util.internal.CleanerJava6.2
            @Override // java.security.PrivilegedAction
            public Throwable run() {
                try {
                    CleanerJava6.freeDirectBuffer0(byteBuffer);
                    return null;
                } catch (Throwable th2) {
                    return th2;
                }
            }
        });
        if (th != null) {
            PlatformDependent0.throwException(th);
        }
    }

    static boolean isSupported() {
        return (CLEANER_FIELD_OFFSET == -1 && CLEANER_FIELD == null) ? false : true;
    }

    CleanerJava6() {
    }

    @Override // io.netty.util.internal.Cleaner
    public void freeDirectBuffer(ByteBuffer byteBuffer) {
        if (!byteBuffer.isDirect()) {
            return;
        }
        if (System.getSecurityManager() == null) {
            try {
                freeDirectBuffer0(byteBuffer);
                return;
            } catch (Throwable th) {
                PlatformDependent0.throwException(th);
                return;
            }
        }
        freeDirectBufferPrivileged(byteBuffer);
    }
}
