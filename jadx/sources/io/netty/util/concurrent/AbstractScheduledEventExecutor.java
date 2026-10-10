package io.netty.util.concurrent;

import androidx.core.location.LocationRequestCompat;
import d8.b;
import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PriorityQueue;
import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class AbstractScheduledEventExecutor extends AbstractEventExecutor {
    private static final Comparator<ScheduledFutureTask<?>> SCHEDULED_FUTURE_TASK_COMPARATOR = new Comparator<ScheduledFutureTask<?>>() { // from class: io.netty.util.concurrent.AbstractScheduledEventExecutor.1
        @Override // java.util.Comparator
        public int compare(ScheduledFutureTask<?> scheduledFutureTask, ScheduledFutureTask<?> scheduledFutureTask2) {
            return scheduledFutureTask.compareTo((Delayed) scheduledFutureTask2);
        }
    };
    private static final long START_TIME = System.nanoTime();
    static final Runnable WAKEUP_TASK = new Runnable() { // from class: io.netty.util.concurrent.AbstractScheduledEventExecutor.2
        @Override // java.lang.Runnable
        public void run() {
        }
    };
    long nextTaskId;
    PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue;

    protected AbstractScheduledEventExecutor() {
    }

    static long deadlineNanos(long j10, long j11) {
        long j12 = j10 + j11;
        return j12 < 0 ? LocationRequestCompat.PASSIVE_INTERVAL : j12;
    }

    protected boolean afterScheduledTaskSubmitted(long j10) {
        return true;
    }

    protected boolean beforeScheduledTaskSubmitted(long j10) {
        return true;
    }

    protected AbstractScheduledEventExecutor(EventExecutorGroup eventExecutorGroup) {
        super(eventExecutorGroup);
    }

    protected static long initialNanoTime() {
        return START_TIME;
    }

    private static boolean isNullOrEmpty(Queue<ScheduledFutureTask<?>> queue) {
        return queue == null || queue.isEmpty();
    }

    protected void cancelScheduledTasks() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        if (isNullOrEmpty(priorityQueue)) {
            return;
        }
        for (ScheduledFutureTask scheduledFutureTask : (ScheduledFutureTask[]) priorityQueue.toArray(new ScheduledFutureTask[0])) {
            scheduledFutureTask.cancelWithoutRemove(false);
        }
        priorityQueue.clearIgnoringIndexes();
    }

    final ScheduledFutureTask<?> peekScheduledTask() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        if (priorityQueue != null) {
            return priorityQueue.peek();
        }
        return null;
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public b<?> scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j10 < 0) {
            throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", Long.valueOf(j10)));
        }
        if (j11 <= 0) {
            throw new IllegalArgumentException(String.format("period: %d (expected: > 0)", Long.valueOf(j11)));
        }
        validateScheduled0(j10, timeUnit);
        validateScheduled0(j11, timeUnit);
        return schedule(new ScheduledFutureTask(this, runnable, deadlineNanos(getCurrentTimeNanos(), timeUnit.toNanos(j10)), timeUnit.toNanos(j11)));
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public b<?> scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j10 < 0) {
            throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", Long.valueOf(j10)));
        }
        if (j11 <= 0) {
            throw new IllegalArgumentException(String.format("delay: %d (expected: > 0)", Long.valueOf(j11)));
        }
        validateScheduled0(j10, timeUnit);
        validateScheduled0(j11, timeUnit);
        return schedule(new ScheduledFutureTask(this, runnable, deadlineNanos(getCurrentTimeNanos(), timeUnit.toNanos(j10)), -timeUnit.toNanos(j11)));
    }

    PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue() {
        if (this.scheduledTaskQueue == null) {
            this.scheduledTaskQueue = new DefaultPriorityQueue(SCHEDULED_FUTURE_TASK_COMPARATOR, 11);
        }
        return this.scheduledTaskQueue;
    }

    protected static long deadlineToDelayNanos(long j10) {
        return ScheduledFutureTask.deadlineToDelayNanos(defaultCurrentTimeNanos(), j10);
    }

    static long defaultCurrentTimeNanos() {
        return System.nanoTime() - START_TIME;
    }

    private void validateScheduled0(long j10, TimeUnit timeUnit) {
        validateScheduled(j10, timeUnit);
    }

    protected long getCurrentTimeNanos() {
        return defaultCurrentTimeNanos();
    }

    protected final long nextScheduledTaskDeadlineNanos() {
        ScheduledFutureTask<?> scheduledFutureTaskPeekScheduledTask = peekScheduledTask();
        if (scheduledFutureTaskPeekScheduledTask != null) {
            return scheduledFutureTaskPeekScheduledTask.deadlineNanos();
        }
        return -1L;
    }

    protected final long nextScheduledTaskNano() {
        ScheduledFutureTask<?> scheduledFutureTaskPeekScheduledTask = peekScheduledTask();
        if (scheduledFutureTaskPeekScheduledTask != null) {
            return scheduledFutureTaskPeekScheduledTask.delayNanos();
        }
        return -1L;
    }

    protected final Runnable pollScheduledTask(long j10) {
        ScheduledFutureTask<?> scheduledFutureTaskPeekScheduledTask = peekScheduledTask();
        if (scheduledFutureTaskPeekScheduledTask != null && scheduledFutureTaskPeekScheduledTask.deadlineNanos() - j10 <= 0) {
            this.scheduledTaskQueue.remove();
            scheduledFutureTaskPeekScheduledTask.setConsumed();
            return scheduledFutureTaskPeekScheduledTask;
        }
        return null;
    }

    final void removeScheduled(ScheduledFutureTask<?> scheduledFutureTask) {
        if (inEventLoop()) {
            scheduledTaskQueue().removeTyped(scheduledFutureTask);
        } else {
            lazyExecute(scheduledFutureTask);
        }
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public b<?> schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j10 < 0) {
            j10 = 0;
        }
        validateScheduled0(j10, timeUnit);
        return schedule(new ScheduledFutureTask(this, runnable, deadlineNanos(getCurrentTimeNanos(), timeUnit.toNanos(j10))));
    }

    final void scheduleFromEventLoop(ScheduledFutureTask<?> scheduledFutureTask) {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueueScheduledTaskQueue = scheduledTaskQueue();
        long j10 = this.nextTaskId + 1;
        this.nextTaskId = j10;
        priorityQueueScheduledTaskQueue.add(scheduledFutureTask.setId(j10));
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ScheduledExecutorService
    public <V> b<V> schedule(Callable<V> callable, long j10, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(callable, "callable");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j10 < 0) {
            j10 = 0;
        }
        validateScheduled0(j10, timeUnit);
        return schedule(new ScheduledFutureTask<>(this, callable, deadlineNanos(getCurrentTimeNanos(), timeUnit.toNanos(j10))));
    }

    private <V> b<V> schedule(ScheduledFutureTask<V> scheduledFutureTask) {
        if (inEventLoop()) {
            scheduleFromEventLoop(scheduledFutureTask);
            return scheduledFutureTask;
        }
        long jDeadlineNanos = scheduledFutureTask.deadlineNanos();
        if (beforeScheduledTaskSubmitted(jDeadlineNanos)) {
            execute(scheduledFutureTask);
            return scheduledFutureTask;
        }
        lazyExecute(scheduledFutureTask);
        if (afterScheduledTaskSubmitted(jDeadlineNanos)) {
            execute(WAKEUP_TASK);
        }
        return scheduledFutureTask;
    }

    @Deprecated
    protected void validateScheduled(long j10, TimeUnit timeUnit) {
    }
}
