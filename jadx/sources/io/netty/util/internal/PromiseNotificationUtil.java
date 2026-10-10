package io.netty.util.internal;

import io.netty.util.concurrent.Promise;
import io.netty.util.internal.logging.InternalLogger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class PromiseNotificationUtil {
    public static void tryFailure(Promise<?> promise, Throwable th, InternalLogger internalLogger) {
        if (!promise.tryFailure(th) && internalLogger != null) {
            Throwable thCause = promise.cause();
            if (thCause == null) {
                internalLogger.warn("Failed to mark a promise as failure because it has succeeded already: {}", promise, th);
            } else if (internalLogger.isWarnEnabled()) {
                internalLogger.warn("Failed to mark a promise as failure because it has failed already: {}, unnotified cause: {}", promise, ThrowableUtil.stackTraceToString(thCause), th);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> void trySuccess(Promise<? super V> promise, V v10, InternalLogger internalLogger) {
        if (!promise.trySuccess(v10) && internalLogger != null) {
            Throwable thCause = promise.cause();
            if (thCause == null) {
                internalLogger.warn("Failed to mark a promise as success because it has succeeded already: {}", promise);
            } else {
                internalLogger.warn("Failed to mark a promise as success because it has failed already: {}, unnotified cause:", promise, thCause);
            }
        }
    }
}
