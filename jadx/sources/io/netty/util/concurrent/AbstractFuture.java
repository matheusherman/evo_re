package io.netty.util.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class AbstractFuture<V> implements Future<V> {
    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException {
        await();
        Throwable thCause = cause();
        if (thCause == null) {
            return getNow();
        }
        if (thCause instanceof CancellationException) {
            throw ((CancellationException) thCause);
        }
        throw new ExecutionException(thCause);
    }

    @Override // java.util.concurrent.Future
    public V get(long j10, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        if (await(j10, timeUnit)) {
            Throwable thCause = cause();
            if (thCause == null) {
                return getNow();
            }
            if (thCause instanceof CancellationException) {
                throw ((CancellationException) thCause);
            }
            throw new ExecutionException(thCause);
        }
        throw new TimeoutException();
    }
}
