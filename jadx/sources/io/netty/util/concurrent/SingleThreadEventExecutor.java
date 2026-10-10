package io.netty.util.concurrent;

import d8.a;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.PriorityQueue;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThreadExecutorMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class SingleThreadEventExecutor extends AbstractScheduledEventExecutor implements a {
    private final boolean addTaskWakesUp;
    private final Executor executor;
    private volatile long gracefulShutdownQuietPeriod;
    private long gracefulShutdownStartTime;
    private volatile long gracefulShutdownTimeout;
    private volatile boolean interrupted;
    private long lastExecutionTime;
    private final int maxPendingTasks;
    private final RejectedExecutionHandler rejectedExecutionHandler;
    private final Set<Runnable> shutdownHooks;
    private volatile int state;
    private final Queue<Runnable> taskQueue;
    private final Promise<?> terminationFuture;
    private volatile Thread thread;
    private final CountDownLatch threadLock;
    private volatile ThreadProperties threadProperties;
    static final int DEFAULT_MAX_PENDING_EXECUTOR_TASKS = Math.max(16, SystemPropertyUtil.getInt("io.netty.eventexecutor.maxPendingTasks", Integer.MAX_VALUE));
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SingleThreadEventExecutor.class);
    private static final Runnable NOOP_TASK = new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.1
        @Override // java.lang.Runnable
        public void run() {
        }
    };
    private static final AtomicIntegerFieldUpdater<SingleThreadEventExecutor> STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(SingleThreadEventExecutor.class, "state");
    private static final AtomicReferenceFieldUpdater<SingleThreadEventExecutor, ThreadProperties> PROPERTIES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(SingleThreadEventExecutor.class, ThreadProperties.class, "threadProperties");
    private static final long SCHEDULE_PURGE_INTERVAL = TimeUnit.SECONDS.toNanos(1);

    private boolean ensureThreadStarted(int i10) {
        if (i10 != 1) {
            return false;
        }
        try {
            doStartThread();
            return false;
        } catch (Throwable th) {
            STATE_UPDATER.set(this, 5);
            this.terminationFuture.tryFailure(th);
            if (!(th instanceof Exception)) {
                PlatformDependent.throwException(th);
            }
            return true;
        }
    }

    protected static void reject() {
        throw new RejectedExecutionException("event executor terminated");
    }

    private boolean runShutdownHooks() {
        boolean z10 = false;
        while (!this.shutdownHooks.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.shutdownHooks);
            this.shutdownHooks.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    AbstractEventExecutor.runTask((Runnable) it.next());
                } catch (Throwable th) {
                    logger.warn("Shutdown hook raised an exception.", th);
                }
                z10 = true;
            }
        }
        if (z10) {
            this.lastExecutionTime = getCurrentTimeNanos();
        }
        return z10;
    }

    final int drainTasks() {
        int i10 = 0;
        while (true) {
            Runnable runnablePoll = this.taskQueue.poll();
            if (runnablePoll == null) {
                return i10;
            }
            if (AbstractScheduledEventExecutor.WAKEUP_TASK != runnablePoll) {
                i10++;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        execute0(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        throwIfInEventLoop("invokeAll");
        return super.invokeAll(collection);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        throwIfInEventLoop("invokeAny");
        return (T) super.invokeAny(collection);
    }

    protected abstract void run();

    protected boolean runAllTasks() {
        boolean zFetchFromScheduledTaskQueue;
        boolean z10 = false;
        do {
            zFetchFromScheduledTaskQueue = fetchFromScheduledTaskQueue();
            if (runAllTasksFrom(this.taskQueue)) {
                z10 = true;
            }
        } while (!zFetchFromScheduledTaskQueue);
        if (z10) {
            this.lastExecutionTime = getCurrentTimeNanos();
        }
        afterRunningAllTasks();
        return z10;
    }

    protected boolean wakesUpForTask(Runnable runnable) {
        return true;
    }

    private void doStartThread() {
        this.executor.execute(new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.4
            @Override // java.lang.Runnable
            public void run() {
                int i10;
                int i11;
                int i12;
                int i13;
                int iDrainTasks;
                boolean zIsWarnEnabled;
                InternalLogger internalLogger;
                StringBuilder sb2;
                int i14;
                int i15;
                boolean zIsWarnEnabled2;
                SingleThreadEventExecutor.this.thread = Thread.currentThread();
                if (SingleThreadEventExecutor.this.interrupted) {
                    SingleThreadEventExecutor.this.thread.interrupt();
                }
                SingleThreadEventExecutor.this.updateLastExecutionTime();
                try {
                    SingleThreadEventExecutor.this.run();
                    do {
                        i14 = SingleThreadEventExecutor.this.state;
                        if (i14 >= 3) {
                            break;
                        }
                    } while (!SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(SingleThreadEventExecutor.this, i14, 3));
                    if (SingleThreadEventExecutor.this.gracefulShutdownStartTime == 0 && SingleThreadEventExecutor.logger.isErrorEnabled()) {
                        SingleThreadEventExecutor.logger.error("Buggy " + EventExecutor.class.getSimpleName() + " implementation; " + SingleThreadEventExecutor.class.getSimpleName() + ".confirmShutdown() must be called before run() implementation terminates.");
                    }
                    do {
                        try {
                        } catch (Throwable th) {
                            try {
                                SingleThreadEventExecutor.this.cleanup();
                                throw th;
                            } finally {
                                FastThreadLocal.removeAll();
                                SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                                SingleThreadEventExecutor.this.threadLock.countDown();
                                int iDrainTasks2 = SingleThreadEventExecutor.this.drainTasks();
                                if (iDrainTasks2 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                                    SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + iDrainTasks2 + ')');
                                }
                                SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                            }
                        }
                    } while (!SingleThreadEventExecutor.this.confirmShutdown());
                    do {
                        i15 = SingleThreadEventExecutor.this.state;
                        if (i15 >= 4) {
                            break;
                        }
                    } while (!SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(SingleThreadEventExecutor.this, i15, 4));
                    SingleThreadEventExecutor.this.confirmShutdown();
                    try {
                        SingleThreadEventExecutor.this.cleanup();
                        FastThreadLocal.removeAll();
                        SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                        SingleThreadEventExecutor.this.threadLock.countDown();
                        iDrainTasks = SingleThreadEventExecutor.this.drainTasks();
                        if (iDrainTasks > 0) {
                            if (zIsWarnEnabled2) {
                                internalLogger = SingleThreadEventExecutor.logger;
                                sb2 = new StringBuilder();
                                sb2.append("An event executor terminated with non-empty task queue (");
                                sb2.append(iDrainTasks);
                                sb2.append(')');
                                internalLogger.warn(sb2.toString());
                            }
                        }
                    } finally {
                        FastThreadLocal.removeAll();
                        SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                        SingleThreadEventExecutor.this.threadLock.countDown();
                        int iDrainTasks3 = SingleThreadEventExecutor.this.drainTasks();
                        if (iDrainTasks3 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                            SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + iDrainTasks3 + ')');
                        }
                        SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                    }
                } catch (Throwable th2) {
                    try {
                        SingleThreadEventExecutor.logger.warn("Unexpected exception from an event executor: ", th2);
                        do {
                            i12 = SingleThreadEventExecutor.this.state;
                            if (i12 >= 3) {
                                break;
                            }
                        } while (!SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(SingleThreadEventExecutor.this, i12, 3));
                        do {
                            try {
                            } catch (Throwable th3) {
                                try {
                                    SingleThreadEventExecutor.this.cleanup();
                                    throw th3;
                                } finally {
                                    FastThreadLocal.removeAll();
                                    SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                                    SingleThreadEventExecutor.this.threadLock.countDown();
                                    int iDrainTasks4 = SingleThreadEventExecutor.this.drainTasks();
                                    if (iDrainTasks4 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                                        SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + iDrainTasks4 + ')');
                                    }
                                    SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                                }
                            }
                        } while (!SingleThreadEventExecutor.this.confirmShutdown());
                        do {
                            i13 = SingleThreadEventExecutor.this.state;
                            if (i13 >= 4) {
                                break;
                            }
                        } while (!SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(SingleThreadEventExecutor.this, i13, 4));
                        SingleThreadEventExecutor.this.confirmShutdown();
                        try {
                            SingleThreadEventExecutor.this.cleanup();
                            FastThreadLocal.removeAll();
                            SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                            SingleThreadEventExecutor.this.threadLock.countDown();
                            iDrainTasks = SingleThreadEventExecutor.this.drainTasks();
                            if (iDrainTasks > 0) {
                                if (zIsWarnEnabled) {
                                    internalLogger = SingleThreadEventExecutor.logger;
                                    sb2 = new StringBuilder();
                                }
                            }
                        } finally {
                            FastThreadLocal.removeAll();
                            SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                            SingleThreadEventExecutor.this.threadLock.countDown();
                            int iDrainTasks5 = SingleThreadEventExecutor.this.drainTasks();
                            if (iDrainTasks5 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                                SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + iDrainTasks5 + ')');
                            }
                            SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                        }
                    } catch (Throwable th4) {
                        do {
                            i10 = SingleThreadEventExecutor.this.state;
                            if (i10 >= 3) {
                                break;
                            }
                        } while (!SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(SingleThreadEventExecutor.this, i10, 3));
                        do {
                            try {
                            } catch (Throwable th5) {
                                try {
                                    SingleThreadEventExecutor.this.cleanup();
                                    throw th5;
                                } finally {
                                    FastThreadLocal.removeAll();
                                    SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                                    SingleThreadEventExecutor.this.threadLock.countDown();
                                    int iDrainTasks6 = SingleThreadEventExecutor.this.drainTasks();
                                    if (iDrainTasks6 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                                        SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + iDrainTasks6 + ')');
                                    }
                                    SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                                }
                            }
                        } while (!SingleThreadEventExecutor.this.confirmShutdown());
                        do {
                            i11 = SingleThreadEventExecutor.this.state;
                            if (i11 >= 4) {
                                break;
                            }
                        } while (!SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(SingleThreadEventExecutor.this, i11, 4));
                        SingleThreadEventExecutor.this.confirmShutdown();
                        try {
                            SingleThreadEventExecutor.this.cleanup();
                            throw th4;
                        } finally {
                            FastThreadLocal.removeAll();
                            SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                            SingleThreadEventExecutor.this.threadLock.countDown();
                            int iDrainTasks7 = SingleThreadEventExecutor.this.drainTasks();
                            if (iDrainTasks7 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                                SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + iDrainTasks7 + ')');
                            }
                            SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                        }
                    }
                }
            }
        });
    }

    private void execute(Runnable runnable, boolean z10) {
        boolean zRemoveTask;
        boolean zInEventLoop = inEventLoop();
        addTask(runnable);
        if (!zInEventLoop) {
            startThread();
            if (isShutdown()) {
                try {
                    zRemoveTask = removeTask(runnable);
                } catch (UnsupportedOperationException unused) {
                    zRemoveTask = false;
                }
                if (zRemoveTask) {
                    reject();
                }
            }
        }
        if (this.addTaskWakesUp || !z10) {
            return;
        }
        wakeup(zInEventLoop);
    }

    private void execute0(Runnable runnable) {
        ObjectUtil.checkNotNull(runnable, "task");
        execute(runnable, wakesUpForTask(runnable));
    }

    private boolean fetchFromScheduledTaskQueue() {
        Runnable runnablePollScheduledTask;
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        if (priorityQueue == null || priorityQueue.isEmpty()) {
            return true;
        }
        long currentTimeNanos = getCurrentTimeNanos();
        do {
            runnablePollScheduledTask = pollScheduledTask(currentTimeNanos);
            if (runnablePollScheduledTask == null) {
                return true;
            }
        } while (this.taskQueue.offer(runnablePollScheduledTask));
        this.scheduledTaskQueue.add((ScheduledFutureTask) runnablePollScheduledTask);
        return false;
    }

    private void lazyExecute0(Runnable runnable) {
        execute((Runnable) ObjectUtil.checkNotNull(runnable, "task"), false);
    }

    private void startThread() {
        if (this.state == 1 && STATE_UPDATER.compareAndSet(this, 1, 2)) {
            try {
                doStartThread();
            } catch (Throwable th) {
                STATE_UPDATER.compareAndSet(this, 2, 1);
                throw th;
            }
        }
    }

    protected void addTask(Runnable runnable) {
        ObjectUtil.checkNotNull(runnable, "task");
        if (offerTask(runnable)) {
            return;
        }
        reject(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (inEventLoop()) {
            throw new IllegalStateException("cannot await termination of the current thread");
        }
        this.threadLock.await(j10, timeUnit);
        return isTerminated();
    }

    protected boolean hasTasks() {
        return !this.taskQueue.isEmpty();
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread) {
        return thread == this.thread;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.state >= 4;
    }

    public boolean isShuttingDown() {
        return this.state >= 3;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.state == 5;
    }

    protected Runnable pollTask() {
        return pollTaskFrom(this.taskQueue);
    }

    protected final void reject(Runnable runnable) {
        this.rejectedExecutionHandler.rejected(runnable, this);
    }

    protected boolean removeTask(Runnable runnable) {
        return this.taskQueue.remove(ObjectUtil.checkNotNull(runnable, "task"));
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j10, long j11, TimeUnit timeUnit) {
        ObjectUtil.checkPositiveOrZero(j10, "quietPeriod");
        if (j11 < j10) {
            throw new IllegalArgumentException("timeout: " + j11 + " (expected >= quietPeriod (" + j10 + "))");
        }
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (isShuttingDown()) {
            return terminationFuture();
        }
        boolean zInEventLoop = inEventLoop();
        while (!isShuttingDown()) {
            int i10 = this.state;
            int i11 = 3;
            boolean z10 = true;
            if (!zInEventLoop && i10 != 1 && i10 != 2) {
                z10 = false;
                i11 = i10;
            }
            if (STATE_UPDATER.compareAndSet(this, i10, i11)) {
                this.gracefulShutdownQuietPeriod = timeUnit.toNanos(j10);
                this.gracefulShutdownTimeout = timeUnit.toNanos(j11);
                if (ensureThreadStarted(i10)) {
                    return this.terminationFuture;
                }
                if (z10) {
                    this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
                    if (!this.addTaskWakesUp) {
                        wakeup(zInEventLoop);
                    }
                }
                return terminationFuture();
            }
        }
        return terminationFuture();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    protected void wakeup(boolean z10) {
        if (z10) {
            return;
        }
        this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
    }

    protected SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, Executor executor, boolean z10, Queue<Runnable> queue, RejectedExecutionHandler rejectedExecutionHandler) {
        super(eventExecutorGroup);
        this.threadLock = new CountDownLatch(1);
        this.shutdownHooks = new LinkedHashSet();
        this.state = 1;
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        this.addTaskWakesUp = z10;
        this.maxPendingTasks = DEFAULT_MAX_PENDING_EXECUTOR_TASKS;
        this.executor = ThreadExecutorMap.apply(executor, this);
        this.taskQueue = (Queue) ObjectUtil.checkNotNull(queue, "taskQueue");
        this.rejectedExecutionHandler = (RejectedExecutionHandler) ObjectUtil.checkNotNull(rejectedExecutionHandler, "rejectedHandler");
    }

    protected static Runnable pollTaskFrom(Queue<Runnable> queue) {
        Runnable runnablePoll;
        do {
            runnablePoll = queue.poll();
        } while (runnablePoll == AbstractScheduledEventExecutor.WAKEUP_TASK);
        return runnablePoll;
    }

    private void throwIfInEventLoop(String str) {
        if (!inEventLoop()) {
            return;
        }
        throw new RejectedExecutionException("Calling " + str + " from within the EventLoop is not allowed");
    }

    protected boolean confirmShutdown() {
        if (!isShuttingDown()) {
            return false;
        }
        if (inEventLoop()) {
            cancelScheduledTasks();
            if (this.gracefulShutdownStartTime == 0) {
                this.gracefulShutdownStartTime = getCurrentTimeNanos();
            }
            if (!runAllTasks() && !runShutdownHooks()) {
                long currentTimeNanos = getCurrentTimeNanos();
                if (isShutdown() || currentTimeNanos - this.gracefulShutdownStartTime > this.gracefulShutdownTimeout || currentTimeNanos - this.lastExecutionTime > this.gracefulShutdownQuietPeriod) {
                    return true;
                }
                this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException unused) {
                }
                return false;
            }
            if (isShutdown() || this.gracefulShutdownQuietPeriod == 0) {
                return true;
            }
            this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
            return false;
        }
        throw new IllegalStateException("must be invoked from an event loop");
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) {
        throwIfInEventLoop("invokeAll");
        return super.invokeAll(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) {
        throwIfInEventLoop("invokeAny");
        return (T) super.invokeAny(collection, j10, timeUnit);
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor
    public void lazyExecute(Runnable runnable) {
        lazyExecute0(runnable);
    }

    final boolean offerTask(Runnable runnable) {
        if (isShutdown()) {
            reject();
        }
        return this.taskQueue.offer(runnable);
    }

    protected final boolean runAllTasksFrom(Queue<Runnable> queue) {
        Runnable runnablePollTaskFrom = pollTaskFrom(queue);
        if (runnablePollTaskFrom == null) {
            return false;
        }
        do {
            AbstractEventExecutor.safeExecute(runnablePollTaskFrom);
            runnablePollTaskFrom = pollTaskFrom(queue);
        } while (runnablePollTaskFrom != null);
        return true;
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public void shutdown() {
        if (!isShutdown()) {
            boolean zInEventLoop = inEventLoop();
            while (!isShuttingDown()) {
                int i10 = this.state;
                int i11 = 4;
                boolean z10 = true;
                if (!zInEventLoop && i10 != 1 && i10 != 2 && i10 != 3) {
                    z10 = false;
                    i11 = i10;
                }
                if (STATE_UPDATER.compareAndSet(this, i10, i11)) {
                    if (!ensureThreadStarted(i10) && z10) {
                        this.taskQueue.offer(AbstractScheduledEventExecutor.WAKEUP_TASK);
                        if (!this.addTaskWakesUp) {
                            wakeup(zInEventLoop);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }

    protected void updateLastExecutionTime() {
        this.lastExecutionTime = getCurrentTimeNanos();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0032  */
    protected boolean runAllTasks(long j10) {
        long currentTimeNanos;
        fetchFromScheduledTaskQueue();
        Runnable runnablePollTask = pollTask();
        if (runnablePollTask == null) {
            afterRunningAllTasks();
            return false;
        }
        long currentTimeNanos2 = j10 > 0 ? getCurrentTimeNanos() + j10 : 0L;
        long j11 = 0;
        do {
            AbstractEventExecutor.safeExecute(runnablePollTask);
            j11++;
            if ((63 & j11) == 0) {
                currentTimeNanos = getCurrentTimeNanos();
                if (currentTimeNanos < currentTimeNanos2) {
                    runnablePollTask = pollTask();
                }
            } else {
                runnablePollTask = pollTask();
            }
            afterRunningAllTasks();
            this.lastExecutionTime = currentTimeNanos;
            return true;
        } while (runnablePollTask != null);
        currentTimeNanos = getCurrentTimeNanos();
        afterRunningAllTasks();
        this.lastExecutionTime = currentTimeNanos;
        return true;
    }

    protected void afterRunningAllTasks() {
    }

    protected void cleanup() {
    }
}
