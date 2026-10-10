package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class PromiseCombiner {
    private Promise<Void> aggregatePromise;
    private Throwable cause;
    private int doneCount;
    private final EventExecutor executor;
    private int expectedCount;
    private final GenericFutureListener<Future<?>> listener = new GenericFutureListener<Future<?>>() { // from class: io.netty.util.concurrent.PromiseCombiner.1
        /* JADX INFO: Access modifiers changed from: private */
        public void operationComplete0(Future<?> future) {
            PromiseCombiner.access$204(PromiseCombiner.this);
            if (!future.isSuccess() && PromiseCombiner.this.cause == null) {
                PromiseCombiner.this.cause = future.cause();
            }
            if (PromiseCombiner.this.doneCount != PromiseCombiner.this.expectedCount || PromiseCombiner.this.aggregatePromise == null) {
                return;
            }
            PromiseCombiner.this.tryPromise();
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(final Future<?> future) {
            if (PromiseCombiner.this.executor.inEventLoop()) {
                operationComplete0(future);
            } else {
                PromiseCombiner.this.executor.execute(new Runnable() { // from class: io.netty.util.concurrent.PromiseCombiner.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        operationComplete0(future);
                    }
                });
            }
        }
    };

    static /* synthetic */ int access$204(PromiseCombiner promiseCombiner) {
        int i10 = promiseCombiner.doneCount + 1;
        promiseCombiner.doneCount = i10;
        return i10;
    }

    private void checkAddAllowed() {
        if (this.aggregatePromise != null) {
            throw new IllegalStateException("Adding promises is not allowed after finished adding");
        }
    }

    private void checkInEventLoop() {
        if (!this.executor.inEventLoop()) {
            throw new IllegalStateException("Must be called from EventExecutor thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tryPromise() {
        Throwable th = this.cause;
        return th == null ? this.aggregatePromise.trySuccess(null) : this.aggregatePromise.tryFailure(th);
    }

    public void finish(Promise<Void> promise) {
        ObjectUtil.checkNotNull(promise, "aggregatePromise");
        checkInEventLoop();
        if (this.aggregatePromise != null) {
            throw new IllegalStateException("Already finished");
        }
        this.aggregatePromise = promise;
        if (this.doneCount == this.expectedCount) {
            tryPromise();
        }
    }

    public PromiseCombiner(EventExecutor eventExecutor) {
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "executor");
    }

    public void add(Future future) {
        checkAddAllowed();
        checkInEventLoop();
        this.expectedCount++;
        future.addListener(this.listener);
    }
}
