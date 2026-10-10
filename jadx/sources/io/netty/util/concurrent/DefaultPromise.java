package io.netty.util.concurrent;

import androidx.concurrent.futures.a;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class DefaultPromise<V> extends AbstractFuture<V> implements Promise<V> {
    private static final CauseHolder CANCELLATION_CAUSE_HOLDER;
    private static final StackTraceElement[] CANCELLATION_STACK;
    private final EventExecutor executor;
    private Object listeners;
    private boolean notifyingListeners;
    private volatile Object result;
    private short waiters;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultPromise.class);
    private static final InternalLogger rejectedExecutionLogger = InternalLoggerFactory.getInstance(DefaultPromise.class.getName() + ".rejectedExecution");
    private static final int MAX_LISTENER_STACK_DEPTH = Math.min(8, SystemPropertyUtil.getInt("io.netty.defaultPromise.maxListenerStackDepth", 8));
    private static final AtomicReferenceFieldUpdater<DefaultPromise, Object> RESULT_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultPromise.class, Object.class, "result");
    private static final Object SUCCESS = new Object();
    private static final Object UNCANCELLABLE = new Object();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class LeanCancellationException extends CancellationException {
        private static final long serialVersionUID = 2794674970981187807L;

        private LeanCancellationException() {
        }

        @Override // java.lang.Throwable
        public String toString() {
            return CancellationException.class.getName();
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            setStackTrace(DefaultPromise.CANCELLATION_STACK);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class StacklessCancellationException extends CancellationException {
        private static final long serialVersionUID = -2974906711413716191L;

        static StacklessCancellationException newInstance(Class<?> cls, String str) {
            return (StacklessCancellationException) ThrowableUtil.unknownStackTrace(new StacklessCancellationException(), cls, str);
        }

        private StacklessCancellationException() {
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public DefaultPromise(EventExecutor eventExecutor) {
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "executor");
    }

    private synchronized boolean checkNotifyWaiters() {
        try {
            if (this.waiters > 0) {
                notifyAll();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.listeners != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListenersNow() {
        Object obj;
        synchronized (this) {
            if (!this.notifyingListeners && (obj = this.listeners) != null) {
                this.notifyingListeners = true;
                this.listeners = null;
                while (true) {
                    if (obj instanceof DefaultFutureListeners) {
                        notifyListeners0((DefaultFutureListeners) obj);
                    } else {
                        notifyListener0(this, (GenericFutureListener) obj);
                    }
                    synchronized (this) {
                        try {
                            obj = this.listeners;
                            if (obj == null) {
                                this.notifyingListeners = false;
                                return;
                            }
                            this.listeners = null;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
        }
    }

    @Override // io.netty.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        V v10 = (V) this.result;
        if (!isDone0(v10)) {
            await2();
            v10 = (V) this.result;
        }
        if (v10 == SUCCESS || v10 == UNCANCELLABLE) {
            return null;
        }
        Throwable thCause0 = cause0(v10);
        if (thCause0 == null) {
            return v10;
        }
        if (thCause0 instanceof CancellationException) {
            throw ((CancellationException) thCause0);
        }
        throw new ExecutionException(thCause0);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class CauseHolder {
        final Throwable cause;

        CauseHolder(Throwable th) {
            this.cause = th;
        }
    }

    static {
        CauseHolder causeHolder = new CauseHolder(StacklessCancellationException.newInstance(DefaultPromise.class, "cancel(...)"));
        CANCELLATION_CAUSE_HOLDER = causeHolder;
        CANCELLATION_STACK = causeHolder.cause.getStackTrace();
    }

    private void addListener0(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        Object obj = this.listeners;
        if (obj == null) {
            this.listeners = genericFutureListener;
        } else if (obj instanceof DefaultFutureListeners) {
            ((DefaultFutureListeners) obj).add(genericFutureListener);
        } else {
            this.listeners = new DefaultFutureListeners((GenericFutureListener) obj, genericFutureListener);
        }
    }

    private Throwable cause0(Object obj) {
        if (!(obj instanceof CauseHolder)) {
            return null;
        }
        CauseHolder causeHolder = CANCELLATION_CAUSE_HOLDER;
        if (obj == causeHolder) {
            LeanCancellationException leanCancellationException = new LeanCancellationException();
            if (a.a(RESULT_UPDATER, this, causeHolder, new CauseHolder(leanCancellationException))) {
                return leanCancellationException;
            }
            obj = this.result;
        }
        return ((CauseHolder) obj).cause;
    }

    private void decWaiters() {
        this.waiters = (short) (this.waiters - 1);
    }

    private void incWaiters() {
        short s10 = this.waiters;
        if (s10 != Short.MAX_VALUE) {
            this.waiters = (short) (s10 + 1);
            return;
        }
        throw new IllegalStateException("too many waiters: " + this);
    }

    private static boolean isCancelled0(Object obj) {
        return (obj instanceof CauseHolder) && (((CauseHolder) obj).cause instanceof CancellationException);
    }

    private static boolean isDone0(Object obj) {
        return (obj == null || obj == UNCANCELLABLE) ? false : true;
    }

    protected static void notifyListener(EventExecutor eventExecutor, Future<?> future, GenericFutureListener<?> genericFutureListener) {
        notifyListenerWithStackOverFlowProtection((EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "eventExecutor"), (Future) ObjectUtil.checkNotNull(future, "future"), (GenericFutureListener) ObjectUtil.checkNotNull(genericFutureListener, "listener"));
    }

    private void removeListener0(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        Object obj = this.listeners;
        if (obj instanceof DefaultFutureListeners) {
            ((DefaultFutureListeners) obj).remove(genericFutureListener);
        } else if (obj == genericFutureListener) {
            this.listeners = null;
        }
    }

    private boolean setFailure0(Throwable th) {
        return setValue0(new CauseHolder((Throwable) ObjectUtil.checkNotNull(th, "cause")));
    }

    private boolean setSuccess0(V v10) {
        if (v10 == null) {
            v10 = (V) SUCCESS;
        }
        return setValue0(v10);
    }

    private boolean setValue0(Object obj) {
        AtomicReferenceFieldUpdater<DefaultPromise, Object> atomicReferenceFieldUpdater = RESULT_UPDATER;
        if (!a.a(atomicReferenceFieldUpdater, this, null, obj) && !a.a(atomicReferenceFieldUpdater, this, UNCANCELLABLE, obj)) {
            return false;
        }
        if (!checkNotifyWaiters()) {
            return true;
        }
        notifyListeners();
        return true;
    }

    @Override // io.netty.util.concurrent.Future
    /* JADX INFO: renamed from: addListener */
    public Promise<V> addListener2(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        ObjectUtil.checkNotNull(genericFutureListener, "listener");
        synchronized (this) {
            addListener0(genericFutureListener);
        }
        if (isDone()) {
            notifyListeners();
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    /* JADX INFO: renamed from: await */
    public Promise<V> await2() throws InterruptedException {
        if (isDone()) {
            return this;
        }
        if (Thread.interrupted()) {
            throw new InterruptedException(toString());
        }
        checkDeadLock();
        synchronized (this) {
            while (!isDone()) {
                try {
                    incWaiters();
                    try {
                        wait();
                        decWaiters();
                    } catch (Throwable th) {
                        decWaiters();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        if (!a.a(RESULT_UPDATER, this, null, CANCELLATION_CAUSE_HOLDER)) {
            return false;
        }
        if (!checkNotifyWaiters()) {
            return true;
        }
        notifyListeners();
        return true;
    }

    @Override // io.netty.util.concurrent.Future
    public Throwable cause() {
        return cause0(this.result);
    }

    protected EventExecutor executor() {
        return this.executor;
    }

    @Override // io.netty.util.concurrent.Future
    public V getNow() {
        V v10 = (V) this.result;
        if ((v10 instanceof CauseHolder) || v10 == SUCCESS || v10 == UNCANCELLABLE) {
            return null;
        }
        return v10;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return isCancelled0(this.result);
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return isDone0(this.result);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        Object obj = this.result;
        return (obj == null || obj == UNCANCELLABLE || (obj instanceof CauseHolder)) ? false : true;
    }

    @Override // io.netty.util.concurrent.Future
    /* JADX INFO: renamed from: removeListener */
    public Promise<V> removeListener2(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        ObjectUtil.checkNotNull(genericFutureListener, "listener");
        synchronized (this) {
            removeListener0(genericFutureListener);
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Promise
    public boolean setUncancellable() {
        if (a.a(RESULT_UPDATER, this, null, UNCANCELLABLE)) {
            return true;
        }
        Object obj = this.result;
        return (isDone0(obj) && isCancelled0(obj)) ? false : true;
    }

    protected StringBuilder toStringBuilder() {
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append(StringUtil.simpleClassName(this));
        sb2.append('@');
        sb2.append(Integer.toHexString(hashCode()));
        Object obj = this.result;
        if (obj == SUCCESS) {
            sb2.append("(success)");
            return sb2;
        }
        if (obj == UNCANCELLABLE) {
            sb2.append("(uncancellable)");
            return sb2;
        }
        if (obj instanceof CauseHolder) {
            sb2.append("(failure: ");
            sb2.append(((CauseHolder) obj).cause);
            sb2.append(')');
            return sb2;
        }
        if (obj == null) {
            sb2.append("(incomplete)");
            return sb2;
        }
        sb2.append("(success: ");
        sb2.append(obj);
        sb2.append(')');
        return sb2;
    }

    protected DefaultPromise() {
        this.executor = null;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x008b A[Catch: all -> 0x0067, TryCatch #2 {all -> 0x0067, blocks: (B:38:0x005f, B:41:0x0069, B:56:0x008b, B:57:0x0092, B:52:0x0080, B:53:0x0087), top: B:64:0x0030 }] */
    private boolean await0(long j10, boolean z10) throws InterruptedException {
        boolean z11 = true;
        if (isDone()) {
            return true;
        }
        if (j10 <= 0) {
            return isDone();
        }
        if (z10 && Thread.interrupted()) {
            throw new InterruptedException(toString());
        }
        checkDeadLock();
        long jNanoTime = System.nanoTime();
        synchronized (this) {
            boolean z12 = false;
            long jNanoTime2 = j10;
            while (!isDone() && jNanoTime2 > 0) {
                try {
                    try {
                        incWaiters();
                        try {
                            try {
                                wait(jNanoTime2 / 1000000, (int) (jNanoTime2 % 1000000));
                                decWaiters();
                            } catch (InterruptedException e10) {
                                if (!z10) {
                                    try {
                                        decWaiters();
                                        z12 = true;
                                    } catch (Throwable th) {
                                        th = th;
                                        if (z11) {
                                            Thread.currentThread().interrupt();
                                        }
                                        throw th;
                                    }
                                } else {
                                    throw e10;
                                }
                            }
                            if (isDone()) {
                                if (z12) {
                                    Thread.currentThread().interrupt();
                                }
                                return true;
                            }
                            jNanoTime2 = j10 - (System.nanoTime() - jNanoTime);
                        } catch (Throwable th2) {
                            decWaiters();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    z11 = z12;
                    if (z11) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            boolean zIsDone = isDone();
            if (z12) {
                Thread.currentThread().interrupt();
            }
            return zIsDone;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyListener0(Future future, GenericFutureListener genericFutureListener) {
        try {
            genericFutureListener.operationComplete(future);
        } catch (Throwable th) {
            if (logger.isWarnEnabled()) {
                logger.warn("An exception was thrown by " + genericFutureListener.getClass().getName() + ".operationComplete()", th);
            }
        }
    }

    private static void notifyListenerWithStackOverFlowProtection(EventExecutor eventExecutor, final Future<?> future, final GenericFutureListener<?> genericFutureListener) {
        InternalThreadLocalMap internalThreadLocalMap;
        int iFutureListenerStackDepth;
        if (eventExecutor.inEventLoop() && (iFutureListenerStackDepth = (internalThreadLocalMap = InternalThreadLocalMap.get()).futureListenerStackDepth()) < MAX_LISTENER_STACK_DEPTH) {
            internalThreadLocalMap.setFutureListenerStackDepth(iFutureListenerStackDepth + 1);
            try {
                notifyListener0(future, genericFutureListener);
                return;
            } finally {
                internalThreadLocalMap.setFutureListenerStackDepth(iFutureListenerStackDepth);
            }
        }
        safeExecute(eventExecutor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.2
            @Override // java.lang.Runnable
            public void run() {
                DefaultPromise.notifyListener0(future, genericFutureListener);
            }
        });
    }

    private void notifyListeners() {
        InternalThreadLocalMap internalThreadLocalMap;
        int iFutureListenerStackDepth;
        EventExecutor eventExecutorExecutor = executor();
        if (eventExecutorExecutor.inEventLoop() && (iFutureListenerStackDepth = (internalThreadLocalMap = InternalThreadLocalMap.get()).futureListenerStackDepth()) < MAX_LISTENER_STACK_DEPTH) {
            internalThreadLocalMap.setFutureListenerStackDepth(iFutureListenerStackDepth + 1);
            try {
                notifyListenersNow();
                return;
            } finally {
                internalThreadLocalMap.setFutureListenerStackDepth(iFutureListenerStackDepth);
            }
        }
        safeExecute(eventExecutorExecutor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.1
            @Override // java.lang.Runnable
            public void run() {
                DefaultPromise.this.notifyListenersNow();
            }
        });
    }

    private void notifyListeners0(DefaultFutureListeners defaultFutureListeners) {
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArrListeners = defaultFutureListeners.listeners();
        int size = defaultFutureListeners.size();
        for (int i10 = 0; i10 < size; i10++) {
            notifyListener0(this, genericFutureListenerArrListeners[i10]);
        }
    }

    private void rethrowIfFailed() {
        Throwable thCause = cause();
        if (thCause == null) {
            return;
        }
        PlatformDependent.throwException(thCause);
    }

    private static void safeExecute(EventExecutor eventExecutor, Runnable runnable) {
        try {
            eventExecutor.execute(runnable);
        } catch (Throwable th) {
            rejectedExecutionLogger.error("Failed to submit a listener notification task. Event loop shut down?", th);
        }
    }

    protected void checkDeadLock() {
        EventExecutor eventExecutorExecutor = executor();
        if (eventExecutorExecutor != null && eventExecutorExecutor.inEventLoop()) {
            throw new BlockingOperationException(toString());
        }
    }

    public Promise<V> setFailure(Throwable th) {
        if (setFailure0(th)) {
            return this;
        }
        throw new IllegalStateException("complete already: " + this, th);
    }

    public Promise<V> setSuccess(V v10) {
        if (setSuccess0(v10)) {
            return this;
        }
        throw new IllegalStateException("complete already: " + this);
    }

    public Promise<V> sync() throws InterruptedException {
        await2();
        rethrowIfFailed();
        return this;
    }

    public String toString() {
        return toStringBuilder().toString();
    }

    public boolean tryFailure(Throwable th) {
        return setFailure0(th);
    }

    @Override // io.netty.util.concurrent.Promise
    public boolean trySuccess(V v10) {
        return setSuccess0(v10);
    }

    @Override // io.netty.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public V get(long j10, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        V v10 = (V) this.result;
        if (!isDone0(v10)) {
            if (await(j10, timeUnit)) {
                v10 = (V) this.result;
            } else {
                throw new TimeoutException();
            }
        }
        if (v10 == SUCCESS || v10 == UNCANCELLABLE) {
            return null;
        }
        Throwable thCause0 = cause0(v10);
        if (thCause0 == null) {
            return v10;
        }
        if (thCause0 instanceof CancellationException) {
            throw ((CancellationException) thCause0);
        }
        throw new ExecutionException(thCause0);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j10, TimeUnit timeUnit) {
        return await0(timeUnit.toNanos(j10), true);
    }
}
