package io.netty.util.concurrent;

import d8.b;
import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.PriorityQueueNode;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class ScheduledFutureTask<V> extends PromiseTask<V> implements b<V>, PriorityQueueNode {
    private long deadlineNanos;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f11367id;
    private final long periodNanos;
    private int queueIndex;

    ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Runnable runnable, long j10) {
        super(abstractScheduledEventExecutor, runnable);
        this.queueIndex = -1;
        this.deadlineNanos = j10;
        this.periodNanos = 0L;
    }

    public long delayNanos() {
        return delayNanos(scheduledExecutor().getCurrentTimeNanos());
    }

    @Override // io.netty.util.internal.PriorityQueueNode
    public int priorityQueueIndex(DefaultPriorityQueue<?> defaultPriorityQueue) {
        return this.queueIndex;
    }

    static long deadlineToDelayNanos(long j10, long j11) {
        if (j11 == 0) {
            return 0L;
        }
        return Math.max(0L, j11 - j10);
    }

    private static long validatePeriod(long j10) {
        if (j10 != 0) {
            return j10;
        }
        throw new IllegalArgumentException("period: 0 (expected: != 0)");
    }

    @Override // java.lang.Comparable
    public int compareTo(Delayed delayed) {
        if (this == delayed) {
            return 0;
        }
        ScheduledFutureTask scheduledFutureTask = (ScheduledFutureTask) delayed;
        long jDeadlineNanos = deadlineNanos() - scheduledFutureTask.deadlineNanos();
        if (jDeadlineNanos < 0) {
            return -1;
        }
        return (jDeadlineNanos <= 0 && this.f11367id < scheduledFutureTask.f11367id) ? -1 : 1;
    }

    public long deadlineNanos() {
        return this.deadlineNanos;
    }

    public long delayNanos(long j10) {
        return deadlineToDelayNanos(j10, this.deadlineNanos);
    }

    @Override // io.netty.util.internal.PriorityQueueNode
    public void priorityQueueIndex(DefaultPriorityQueue<?> defaultPriorityQueue, int i10) {
        this.queueIndex = i10;
    }

    void setConsumed() {
        if (this.periodNanos == 0) {
            this.deadlineNanos = 0L;
        }
    }

    ScheduledFutureTask<V> setId(long j10) {
        if (this.f11367id == 0) {
            this.f11367id = j10;
        }
        return this;
    }

    private AbstractScheduledEventExecutor scheduledExecutor() {
        return (AbstractScheduledEventExecutor) executor();
    }

    @Override // io.netty.util.concurrent.PromiseTask, io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        boolean zCancel = super.cancel(z10);
        if (zCancel) {
            scheduledExecutor().removeScheduled(this);
        }
        return zCancel;
    }

    boolean cancelWithoutRemove(boolean z10) {
        return super.cancel(z10);
    }

    @Override // io.netty.util.concurrent.DefaultPromise
    protected EventExecutor executor() {
        return super.executor();
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(delayNanos(), TimeUnit.NANOSECONDS);
    }

    @Override // io.netty.util.concurrent.PromiseTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        try {
            if (delayNanos() > 0) {
                if (isCancelled()) {
                    scheduledExecutor().scheduledTaskQueue().removeTyped(this);
                    return;
                } else {
                    scheduledExecutor().scheduleFromEventLoop(this);
                    return;
                }
            }
            if (this.periodNanos == 0) {
                if (setUncancellableInternal()) {
                    setSuccessInternal(runTask());
                }
            } else if (!isCancelled()) {
                runTask();
                if (!executor().isShutdown()) {
                    long j10 = this.periodNanos;
                    if (j10 > 0) {
                        this.deadlineNanos += j10;
                    } else {
                        this.deadlineNanos = scheduledExecutor().getCurrentTimeNanos() - this.periodNanos;
                    }
                    if (!isCancelled()) {
                        scheduledExecutor().scheduledTaskQueue().add(this);
                    }
                }
            }
        } catch (Throwable th) {
            setFailureInternal(th);
        }
    }

    @Override // io.netty.util.concurrent.PromiseTask, io.netty.util.concurrent.DefaultPromise
    protected StringBuilder toStringBuilder() {
        StringBuilder stringBuilder = super.toStringBuilder();
        stringBuilder.setCharAt(stringBuilder.length() - 1, ',');
        stringBuilder.append(" deadline: ");
        stringBuilder.append(this.deadlineNanos);
        stringBuilder.append(", period: ");
        stringBuilder.append(this.periodNanos);
        stringBuilder.append(')');
        return stringBuilder;
    }

    ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Runnable runnable, long j10, long j11) {
        super(abstractScheduledEventExecutor, runnable);
        this.queueIndex = -1;
        this.deadlineNanos = j10;
        this.periodNanos = validatePeriod(j11);
    }

    ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Callable<V> callable, long j10, long j11) {
        super(abstractScheduledEventExecutor, callable);
        this.queueIndex = -1;
        this.deadlineNanos = j10;
        this.periodNanos = validatePeriod(j11);
    }

    ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor, Callable<V> callable, long j10) {
        super(abstractScheduledEventExecutor, callable);
        this.queueIndex = -1;
        this.deadlineNanos = j10;
        this.periodNanos = 0L;
    }
}
