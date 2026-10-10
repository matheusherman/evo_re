package io.netty.channel.nio;

import androidx.core.location.LocationRequestCompat;
import io.netty.channel.ChannelException;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.util.IntSupplier;
import io.netty.util.concurrent.AbstractScheduledEventExecutor;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ReflectionUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class NioEventLoop extends SingleThreadEventLoop {
    private static final int SELECTOR_AUTO_REBUILD_THRESHOLD;
    private int cancelledKeys;
    private volatile int ioRatio;
    private boolean needsToSelectAgain;
    private final AtomicLong nextWakeupNanos;
    private final SelectorProvider provider;
    private final IntSupplier selectNowSupplier;
    private final SelectStrategy selectStrategy;
    private SelectedSelectionKeySet selectedKeys;
    private Selector selector;
    private Selector unwrappedSelector;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NioEventLoop.class);
    private static final boolean DISABLE_KEY_SET_OPTIMIZATION = SystemPropertyUtil.getBoolean("io.netty.noKeySetOptimization", false);

    private void processSelectedKey(SelectionKey selectionKey, AbstractNioChannel abstractNioChannel) {
        AbstractNioChannel.NioUnsafe nioUnsafeUnsafe = abstractNioChannel.unsafe();
        if (!selectionKey.isValid()) {
            try {
                if (abstractNioChannel.eventLoop() == this) {
                    nioUnsafeUnsafe.close(nioUnsafeUnsafe.voidPromise());
                    return;
                }
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        try {
            int i10 = selectionKey.readyOps();
            if ((i10 & 8) != 0) {
                selectionKey.interestOps(selectionKey.interestOps() & (-9));
                nioUnsafeUnsafe.finishConnect();
            }
            if ((i10 & 4) != 0) {
                abstractNioChannel.unsafe().forceFlush();
            }
            if ((i10 & 17) == 0 && i10 != 0) {
                return;
            }
            nioUnsafeUnsafe.read();
        } catch (CancelledKeyException unused2) {
            nioUnsafeUnsafe.close(nioUnsafeUnsafe.voidPromise());
        }
    }

    private void processSelectedKeysOptimized() {
        int i10 = 0;
        while (true) {
            SelectedSelectionKeySet selectedSelectionKeySet = this.selectedKeys;
            if (i10 >= selectedSelectionKeySet.size) {
                return;
            }
            SelectionKey[] selectionKeyArr = selectedSelectionKeySet.keys;
            SelectionKey selectionKey = selectionKeyArr[i10];
            selectionKeyArr[i10] = null;
            Object objAttachment = selectionKey.attachment();
            if (objAttachment instanceof AbstractNioChannel) {
                processSelectedKey(selectionKey, (AbstractNioChannel) objAttachment);
            } else {
                processSelectedKey(selectionKey, (NioTask<SelectableChannel>) objAttachment);
            }
            if (this.needsToSelectAgain) {
                this.selectedKeys.reset(i10 + 1);
                selectAgain();
                i10 = -1;
            }
            i10++;
        }
    }

    private void selectAgain() {
        this.needsToSelectAgain = false;
        try {
            this.selector.selectNow();
        } catch (Throwable th) {
            logger.warn("Failed to update SelectionKeys.", th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:111:0x012f A[Catch: all -> 0x0139, Error -> 0x013b, TRY_LEAVE, TryCatch #16 {Error -> 0x013b, all -> 0x0139, blocks: (B:109:0x0129, B:111:0x012f), top: B:168:0x0129 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x0148 A[Catch: all -> 0x013d, TRY_LEAVE, TryCatch #21 {all -> 0x013d, blocks: (B:108:0x0126, B:121:0x0140, B:123:0x0148, B:120:0x013f, B:4:0x0002, B:35:0x005b, B:50:0x0079, B:62:0x00b4, B:67:0x00bf, B:69:0x00c7, B:42:0x006c, B:43:0x006f, B:52:0x0080, B:54:0x0087, B:56:0x0099, B:57:0x00a8, B:58:0x00a9, B:23:0x0032, B:26:0x0041, B:33:0x0054, B:89:0x00f9, B:90:0x00fe, B:91:0x00ff, B:92:0x0102), top: B:153:0x0126, inners: #23 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x016a A[Catch: all -> 0x0174, Error -> 0x0177, TRY_LEAVE, TryCatch #18 {Error -> 0x0177, all -> 0x0174, blocks: (B:124:0x0164, B:126:0x016a), top: B:164:0x0164 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x0188 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x010b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:0x0188 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:175:0x0188 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:176:0x0188 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x0001 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x0001 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0065 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x007e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x0080 A[Catch: all -> 0x0070, Error -> 0x0073, CancelledKeyException -> 0x0076, TRY_LEAVE, TryCatch #23 {Error -> 0x0073, blocks: (B:4:0x0002, B:35:0x005b, B:50:0x0079, B:62:0x00b4, B:67:0x00bf, B:69:0x00c7, B:42:0x006c, B:43:0x006f, B:52:0x0080, B:54:0x0087, B:56:0x0099, B:57:0x00a8, B:58:0x00a9, B:23:0x0032, B:26:0x0041, B:33:0x0054, B:89:0x00f9, B:90:0x00fe, B:91:0x00ff, B:92:0x0102), top: B:145:0x0002, outer: #21 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00a9 A[Catch: all -> 0x0070, Error -> 0x0073, CancelledKeyException -> 0x0076, TryCatch #23 {Error -> 0x0073, blocks: (B:4:0x0002, B:35:0x005b, B:50:0x0079, B:62:0x00b4, B:67:0x00bf, B:69:0x00c7, B:42:0x006c, B:43:0x006f, B:52:0x0080, B:54:0x0087, B:56:0x0099, B:57:0x00a8, B:58:0x00a9, B:23:0x0032, B:26:0x0041, B:33:0x0054, B:89:0x00f9, B:90:0x00fe, B:91:0x00ff, B:92:0x0102), top: B:145:0x0002, outer: #21 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bf A[Catch: all -> 0x0070, Error -> 0x0073, CancelledKeyException -> 0x0076, TryCatch #23 {Error -> 0x0073, blocks: (B:4:0x0002, B:35:0x005b, B:50:0x0079, B:62:0x00b4, B:67:0x00bf, B:69:0x00c7, B:42:0x006c, B:43:0x006f, B:52:0x0080, B:54:0x0087, B:56:0x0099, B:57:0x00a8, B:58:0x00a9, B:23:0x0032, B:26:0x0041, B:33:0x0054, B:89:0x00f9, B:90:0x00fe, B:91:0x00ff, B:92:0x0102), top: B:145:0x0002, outer: #21 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x00c7 A[Catch: all -> 0x0070, Error -> 0x0073, CancelledKeyException -> 0x0076, TRY_LEAVE, TryCatch #23 {Error -> 0x0073, blocks: (B:4:0x0002, B:35:0x005b, B:50:0x0079, B:62:0x00b4, B:67:0x00bf, B:69:0x00c7, B:42:0x006c, B:43:0x006f, B:52:0x0080, B:54:0x0087, B:56:0x0099, B:57:0x00a8, B:58:0x00a9, B:23:0x0032, B:26:0x0041, B:33:0x0054, B:89:0x00f9, B:90:0x00fe, B:91:0x00ff, B:92:0x0102), top: B:145:0x0002, outer: #21 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x00d9 A[Catch: all -> 0x00e4, Error -> 0x00e6, TRY_LEAVE, TryCatch #23 {Error -> 0x00e6, all -> 0x00e4, blocks: (B:71:0x00d3, B:73:0x00d9), top: B:156:0x00d3 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:123:0x0148, please report this as an issue */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void run() {
        int i10;
        Throwable th;
        CancelledKeyException e10;
        InternalLogger internalLogger;
        int i11;
        boolean zRunAllTasks;
        long jNanoTime;
        InternalLogger internalLogger2;
        long jNextScheduledTaskDeadlineNanos;
        while (true) {
            int i12 = 0;
            while (true) {
                try {
                    try {
                        try {
                            int iCalculateStrategy = this.selectStrategy.calculateStrategy(this.selectNowSupplier, hasTasks());
                            try {
                                try {
                                    try {
                                        if (iCalculateStrategy != -3) {
                                            if (iCalculateStrategy != -2) {
                                                if (iCalculateStrategy == -1) {
                                                }
                                                i10 = i12 + 1;
                                                this.cancelledKeys = 0;
                                                this.needsToSelectAgain = false;
                                                i11 = this.ioRatio;
                                                if (i11 == 100) {
                                                    if (iCalculateStrategy > 0) {
                                                        try {
                                                            processSelectedKeys();
                                                        } catch (Throwable th2) {
                                                            runAllTasks();
                                                            throw th2;
                                                        }
                                                    }
                                                    zRunAllTasks = runAllTasks();
                                                } else if (iCalculateStrategy > 0) {
                                                    jNanoTime = System.nanoTime();
                                                    try {
                                                        processSelectedKeys();
                                                        zRunAllTasks = runAllTasks(((System.nanoTime() - jNanoTime) * ((long) (100 - i11))) / ((long) i11));
                                                    } catch (Throwable th3) {
                                                        runAllTasks(((System.nanoTime() - jNanoTime) * ((long) (100 - i11))) / ((long) i11));
                                                        throw th3;
                                                    }
                                                } else {
                                                    zRunAllTasks = runAllTasks(0L);
                                                }
                                                if (zRunAllTasks && iCalculateStrategy <= 0) {
                                                    if (unexpectedSelectorWakeup(i10)) {
                                                    }
                                                    if (isShuttingDown()) {
                                                        closeAll();
                                                        if (confirmShutdown()) {
                                                            return;
                                                        }
                                                    }
                                                    i12 = i10;
                                                } else if (i10 > 3) {
                                                    internalLogger2 = logger;
                                                    if (internalLogger2.isDebugEnabled()) {
                                                        internalLogger2.debug("Selector.select() returned prematurely {} times in a row for Selector {}.", Integer.valueOf(i12), this.selector);
                                                    }
                                                }
                                                i10 = 0;
                                                if (isShuttingDown()) {
                                                    closeAll();
                                                    if (confirmShutdown()) {
                                                        return;
                                                    }
                                                }
                                                i12 = i10;
                                            } else {
                                                try {
                                                    if (isShuttingDown()) {
                                                        closeAll();
                                                        if (confirmShutdown()) {
                                                            return;
                                                        }
                                                    } else {
                                                        continue;
                                                    }
                                                } catch (Error e11) {
                                                    throw e11;
                                                } catch (Throwable th4) {
                                                    handleLoopException(th4);
                                                }
                                            }
                                        }
                                        if (isShuttingDown()) {
                                            closeAll();
                                            if (confirmShutdown()) {
                                                return;
                                            }
                                        }
                                    } catch (Error e12) {
                                        throw e12;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        handleLoopException(th);
                                    }
                                    this.cancelledKeys = 0;
                                    this.needsToSelectAgain = false;
                                    i11 = this.ioRatio;
                                    if (i11 == 100) {
                                        if (iCalculateStrategy > 0) {
                                            processSelectedKeys();
                                        }
                                        zRunAllTasks = runAllTasks();
                                    } else if (iCalculateStrategy > 0) {
                                        jNanoTime = System.nanoTime();
                                        processSelectedKeys();
                                        zRunAllTasks = runAllTasks(((System.nanoTime() - jNanoTime) * ((long) (100 - i11))) / ((long) i11));
                                    } else {
                                        zRunAllTasks = runAllTasks(0L);
                                    }
                                    if (zRunAllTasks) {
                                        if (i10 > 3) {
                                            internalLogger2 = logger;
                                            if (internalLogger2.isDebugEnabled()) {
                                                internalLogger2.debug("Selector.select() returned prematurely {} times in a row for Selector {}.", Integer.valueOf(i12), this.selector);
                                            }
                                        }
                                        i10 = 0;
                                    } else {
                                        if (i10 > 3) {
                                            internalLogger2 = logger;
                                            if (internalLogger2.isDebugEnabled()) {
                                                internalLogger2.debug("Selector.select() returned prematurely {} times in a row for Selector {}.", Integer.valueOf(i12), this.selector);
                                            }
                                        }
                                        i10 = 0;
                                    }
                                } catch (CancelledKeyException e13) {
                                    e10 = e13;
                                    internalLogger = logger;
                                    if (internalLogger.isDebugEnabled()) {
                                        internalLogger.debug(CancelledKeyException.class.getSimpleName() + " raised by a Selector {} - JDK bug?", this.selector, e10);
                                    }
                                    try {
                                        if (isShuttingDown()) {
                                            closeAll();
                                            if (confirmShutdown()) {
                                                return;
                                            }
                                        }
                                    } catch (Error e14) {
                                        throw e14;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        handleLoopException(th);
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    try {
                                        handleLoopException(th);
                                        try {
                                            if (isShuttingDown()) {
                                                closeAll();
                                                if (confirmShutdown()) {
                                                    return;
                                                }
                                            }
                                        } catch (Error e15) {
                                            throw e15;
                                        } catch (Throwable th8) {
                                            th = th8;
                                            handleLoopException(th);
                                        }
                                    } catch (Throwable th9) {
                                        try {
                                            if (isShuttingDown()) {
                                                closeAll();
                                                if (confirmShutdown()) {
                                                    return;
                                                }
                                            }
                                        } catch (Error e16) {
                                            throw e16;
                                        } catch (Throwable th10) {
                                            handleLoopException(th10);
                                        }
                                        throw th9;
                                    }
                                }
                                if (!hasTasks()) {
                                    iCalculateStrategy = select(jNextScheduledTaskDeadlineNanos);
                                }
                                this.nextWakeupNanos.lazySet(-1L);
                                i10 = i12 + 1;
                            } catch (Throwable th11) {
                                this.nextWakeupNanos.lazySet(-1L);
                                throw th11;
                            }
                            jNextScheduledTaskDeadlineNanos = nextScheduledTaskDeadlineNanos();
                            if (jNextScheduledTaskDeadlineNanos == -1) {
                                jNextScheduledTaskDeadlineNanos = LocationRequestCompat.PASSIVE_INTERVAL;
                            }
                            this.nextWakeupNanos.set(jNextScheduledTaskDeadlineNanos);
                        } catch (IOException e17) {
                            rebuildSelector0();
                            try {
                                handleLoopException(e17);
                                if (isShuttingDown()) {
                                    closeAll();
                                    if (confirmShutdown()) {
                                        return;
                                    }
                                } else {
                                    continue;
                                }
                            } catch (CancelledKeyException e18) {
                                e10 = e18;
                                i10 = 0;
                                internalLogger = logger;
                                if (internalLogger.isDebugEnabled()) {
                                    internalLogger.debug(CancelledKeyException.class.getSimpleName() + " raised by a Selector {} - JDK bug?", this.selector, e10);
                                }
                                if (isShuttingDown()) {
                                    closeAll();
                                    if (confirmShutdown()) {
                                        return;
                                    }
                                }
                                i12 = i10;
                            } catch (Throwable th12) {
                                th = th12;
                                i10 = 0;
                                handleLoopException(th);
                                if (isShuttingDown()) {
                                    closeAll();
                                    if (confirmShutdown()) {
                                        return;
                                    }
                                }
                                i12 = i10;
                            }
                        }
                    } catch (Error e19) {
                        throw e19;
                    }
                } catch (CancelledKeyException e20) {
                    i10 = i12;
                    e10 = e20;
                } catch (Throwable th13) {
                    i10 = i12;
                    th = th13;
                }
                i12 = i10;
            }
            try {
                if (isShuttingDown()) {
                    closeAll();
                    if (confirmShutdown()) {
                        return;
                    }
                } else {
                    continue;
                }
            } catch (Error e21) {
                throw e21;
            } catch (Throwable th14) {
                handleLoopException(th14);
            }
        }
    }

    static {
        if (PlatformDependent.javaVersion() < 7 && SystemPropertyUtil.get("sun.nio.ch.bugLevel") == null) {
            try {
                AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: io.netty.channel.nio.NioEventLoop.2
                    @Override // java.security.PrivilegedAction
                    public Void run() {
                        System.setProperty("sun.nio.ch.bugLevel", "");
                        return null;
                    }
                });
            } catch (SecurityException e10) {
                logger.debug("Unable to get/set System Property: sun.nio.ch.bugLevel", (Throwable) e10);
            }
        }
        int i10 = SystemPropertyUtil.getInt("io.netty.selectorAutoRebuildThreshold", 512);
        int i11 = i10 >= 3 ? i10 : 0;
        SELECTOR_AUTO_REBUILD_THRESHOLD = i11;
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("-Dio.netty.noKeySetOptimization: {}", Boolean.valueOf(DISABLE_KEY_SET_OPTIMIZATION));
            internalLogger.debug("-Dio.netty.selectorAutoRebuildThreshold: {}", Integer.valueOf(i11));
        }
    }

    private static void handleLoopException(Throwable th) {
        logger.warn("Unexpected exception in the selector loop.", th);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException unused) {
        }
    }

    private static Queue<Runnable> newTaskQueue(EventLoopTaskQueueFactory eventLoopTaskQueueFactory) {
        return eventLoopTaskQueueFactory == null ? newTaskQueue0(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS) : eventLoopTaskQueueFactory.newTaskQueue(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS);
    }

    private SelectorTuple openSelector() {
        try {
            final AbstractSelector abstractSelectorOpenSelector = this.provider.openSelector();
            if (DISABLE_KEY_SET_OPTIMIZATION) {
                return new SelectorTuple(abstractSelectorOpenSelector);
            }
            Object objDoPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.channel.nio.NioEventLoop.3
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        return Class.forName("sun.nio.ch.SelectorImpl", false, PlatformDependent.getSystemClassLoader());
                    } catch (Throwable th) {
                        return th;
                    }
                }
            });
            if (objDoPrivileged instanceof Class) {
                final Class cls = (Class) objDoPrivileged;
                if (cls.isAssignableFrom(abstractSelectorOpenSelector.getClass())) {
                    final SelectedSelectionKeySet selectedSelectionKeySet = new SelectedSelectionKeySet();
                    Object objDoPrivileged2 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.channel.nio.NioEventLoop.4
                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            try {
                                Field declaredField = cls.getDeclaredField("selectedKeys");
                                Field declaredField2 = cls.getDeclaredField("publicSelectedKeys");
                                if (PlatformDependent.javaVersion() >= 9 && PlatformDependent.hasUnsafe()) {
                                    long jObjectFieldOffset = PlatformDependent.objectFieldOffset(declaredField);
                                    long jObjectFieldOffset2 = PlatformDependent.objectFieldOffset(declaredField2);
                                    if (jObjectFieldOffset != -1 && jObjectFieldOffset2 != -1) {
                                        PlatformDependent.putObject(abstractSelectorOpenSelector, jObjectFieldOffset, selectedSelectionKeySet);
                                        PlatformDependent.putObject(abstractSelectorOpenSelector, jObjectFieldOffset2, selectedSelectionKeySet);
                                        return null;
                                    }
                                }
                                Throwable thTrySetAccessible = ReflectionUtil.trySetAccessible(declaredField, true);
                                if (thTrySetAccessible != null) {
                                    return thTrySetAccessible;
                                }
                                Throwable thTrySetAccessible2 = ReflectionUtil.trySetAccessible(declaredField2, true);
                                if (thTrySetAccessible2 != null) {
                                    return thTrySetAccessible2;
                                }
                                declaredField.set(abstractSelectorOpenSelector, selectedSelectionKeySet);
                                declaredField2.set(abstractSelectorOpenSelector, selectedSelectionKeySet);
                                return null;
                            } catch (IllegalAccessException e10) {
                                e = e10;
                                return e;
                            } catch (NoSuchFieldException e11) {
                                e = e11;
                                return e;
                            }
                        }
                    });
                    if (!(objDoPrivileged2 instanceof Exception)) {
                        this.selectedKeys = selectedSelectionKeySet;
                        logger.trace("instrumented a special java.util.Set into: {}", abstractSelectorOpenSelector);
                        return new SelectorTuple(abstractSelectorOpenSelector, new SelectedSelectionKeySetSelector(abstractSelectorOpenSelector, selectedSelectionKeySet));
                    }
                    this.selectedKeys = null;
                    logger.trace("failed to instrument a special java.util.Set into: {}", abstractSelectorOpenSelector, (Exception) objDoPrivileged2);
                    return new SelectorTuple(abstractSelectorOpenSelector);
                }
            }
            if (objDoPrivileged instanceof Throwable) {
                logger.trace("failed to instrument a special java.util.Set into: {}", abstractSelectorOpenSelector, (Throwable) objDoPrivileged);
            }
            return new SelectorTuple(abstractSelectorOpenSelector);
        } catch (IOException e10) {
            throw new ChannelException("failed to open a new selector", e10);
        }
    }

    private void processSelectedKeys() {
        if (this.selectedKeys != null) {
            processSelectedKeysOptimized();
        } else {
            processSelectedKeysPlain(this.selector.selectedKeys());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rebuildSelector0() {
        Selector selector = this.selector;
        if (selector == null) {
            return;
        }
        try {
            SelectorTuple selectorTupleOpenSelector = openSelector();
            int i10 = 0;
            for (SelectionKey selectionKey : selector.keys()) {
                Object objAttachment = selectionKey.attachment();
                try {
                    if (selectionKey.isValid() && selectionKey.channel().keyFor(selectorTupleOpenSelector.unwrappedSelector) == null) {
                        int iInterestOps = selectionKey.interestOps();
                        selectionKey.cancel();
                        SelectionKey selectionKeyRegister = selectionKey.channel().register(selectorTupleOpenSelector.unwrappedSelector, iInterestOps, objAttachment);
                        if (objAttachment instanceof AbstractNioChannel) {
                            ((AbstractNioChannel) objAttachment).selectionKey = selectionKeyRegister;
                        }
                        i10++;
                    }
                } catch (Exception e10) {
                    logger.warn("Failed to re-register a Channel to the new Selector.", (Throwable) e10);
                    if (objAttachment instanceof AbstractNioChannel) {
                        AbstractNioChannel abstractNioChannel = (AbstractNioChannel) objAttachment;
                        abstractNioChannel.unsafe().close(abstractNioChannel.unsafe().voidPromise());
                    } else {
                        invokeChannelUnregistered((NioTask) objAttachment, selectionKey, e10);
                    }
                }
            }
            this.selector = selectorTupleOpenSelector.selector;
            this.unwrappedSelector = selectorTupleOpenSelector.unwrappedSelector;
            try {
                selector.close();
            } catch (Throwable th) {
                if (logger.isWarnEnabled()) {
                    logger.warn("Failed to close the old Selector.", th);
                }
            }
            InternalLogger internalLogger = logger;
            if (internalLogger.isInfoEnabled()) {
                internalLogger.info("Migrated " + i10 + " channel(s) to the new Selector.");
            }
        } catch (Exception e11) {
            logger.warn("Failed to create a new Selector.", (Throwable) e11);
        }
    }

    @Override // io.netty.util.concurrent.AbstractScheduledEventExecutor
    protected boolean afterScheduledTaskSubmitted(long j10) {
        return j10 < this.nextWakeupNanos.get();
    }

    @Override // io.netty.util.concurrent.AbstractScheduledEventExecutor
    protected boolean beforeScheduledTaskSubmitted(long j10) {
        return j10 < this.nextWakeupNanos.get();
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void cleanup() {
        try {
            this.selector.close();
        } catch (IOException e10) {
            logger.warn("Failed to close a selector.", (Throwable) e10);
        }
    }

    int selectNow() {
        return this.selector.selectNow();
    }

    Selector unwrappedSelector() {
        return this.unwrappedSelector;
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    protected void wakeup(boolean z10) {
        if (z10 || this.nextWakeupNanos.getAndSet(-1L) == -1) {
            return;
        }
        this.selector.wakeup();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class SelectorTuple {
        final Selector selector;
        final Selector unwrappedSelector;

        SelectorTuple(Selector selector) {
            this.unwrappedSelector = selector;
            this.selector = selector;
        }

        SelectorTuple(Selector selector, Selector selector2) {
            this.unwrappedSelector = selector;
            this.selector = selector2;
        }
    }

    NioEventLoop(NioEventLoopGroup nioEventLoopGroup, Executor executor, SelectorProvider selectorProvider, SelectStrategy selectStrategy, RejectedExecutionHandler rejectedExecutionHandler, EventLoopTaskQueueFactory eventLoopTaskQueueFactory, EventLoopTaskQueueFactory eventLoopTaskQueueFactory2) {
        super(nioEventLoopGroup, executor, false, newTaskQueue(eventLoopTaskQueueFactory), newTaskQueue(eventLoopTaskQueueFactory2), rejectedExecutionHandler);
        this.selectNowSupplier = new IntSupplier() { // from class: io.netty.channel.nio.NioEventLoop.1
            @Override // io.netty.util.IntSupplier
            public int get() {
                return NioEventLoop.this.selectNow();
            }
        };
        this.nextWakeupNanos = new AtomicLong(-1L);
        this.ioRatio = 50;
        this.provider = (SelectorProvider) ObjectUtil.checkNotNull(selectorProvider, "selectorProvider");
        this.selectStrategy = (SelectStrategy) ObjectUtil.checkNotNull(selectStrategy, "selectStrategy");
        SelectorTuple selectorTupleOpenSelector = openSelector();
        this.selector = selectorTupleOpenSelector.selector;
        this.unwrappedSelector = selectorTupleOpenSelector.unwrappedSelector;
    }

    private void closeAll() {
        selectAgain();
        Set<SelectionKey> setKeys = this.selector.keys();
        ArrayList<AbstractNioChannel> arrayList = new ArrayList(setKeys.size());
        for (SelectionKey selectionKey : setKeys) {
            Object objAttachment = selectionKey.attachment();
            if (objAttachment instanceof AbstractNioChannel) {
                arrayList.add((AbstractNioChannel) objAttachment);
            } else {
                selectionKey.cancel();
                invokeChannelUnregistered((NioTask) objAttachment, selectionKey, null);
            }
        }
        for (AbstractNioChannel abstractNioChannel : arrayList) {
            abstractNioChannel.unsafe().close(abstractNioChannel.unsafe().voidPromise());
        }
    }

    private static void invokeChannelUnregistered(NioTask<SelectableChannel> nioTask, SelectionKey selectionKey, Throwable th) {
        try {
            nioTask.channelUnregistered(selectionKey.channel(), th);
        } catch (Exception e10) {
            logger.warn("Unexpected exception while running NioTask.channelUnregistered()", (Throwable) e10);
        }
    }

    private static Queue<Runnable> newTaskQueue0(int i10) {
        if (i10 == Integer.MAX_VALUE) {
            return PlatformDependent.newMpscQueue();
        }
        return PlatformDependent.newMpscQueue(i10);
    }

    private void processSelectedKeysPlain(Set<SelectionKey> set) {
        if (!set.isEmpty()) {
            Iterator<SelectionKey> it = set.iterator();
            while (true) {
                SelectionKey next = it.next();
                Object objAttachment = next.attachment();
                it.remove();
                if (objAttachment instanceof AbstractNioChannel) {
                    processSelectedKey(next, (AbstractNioChannel) objAttachment);
                } else {
                    processSelectedKey(next, (NioTask<SelectableChannel>) objAttachment);
                }
                if (it.hasNext()) {
                    if (this.needsToSelectAgain) {
                        selectAgain();
                        Set<SelectionKey> setSelectedKeys = this.selector.selectedKeys();
                        if (setSelectedKeys.isEmpty()) {
                            return;
                        } else {
                            it = setSelectedKeys.iterator();
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    private boolean unexpectedSelectorWakeup(int i10) {
        if (Thread.interrupted()) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Selector.select() returned prematurely because Thread.currentThread().interrupt() was called. Use NioEventLoop.shutdownGracefully() to shutdown the NioEventLoop.");
            }
            return true;
        }
        int i11 = SELECTOR_AUTO_REBUILD_THRESHOLD;
        if (i11 > 0 && i10 >= i11) {
            logger.warn("Selector.select() returned prematurely {} times in a row; rebuilding Selector {}.", Integer.valueOf(i10), this.selector);
            rebuildSelector();
            return true;
        }
        return false;
    }

    void cancel(SelectionKey selectionKey) {
        selectionKey.cancel();
        int i10 = this.cancelledKeys + 1;
        this.cancelledKeys = i10;
        if (i10 >= 256) {
            this.cancelledKeys = 0;
            this.needsToSelectAgain = true;
        }
    }

    public void rebuildSelector() {
        if (!inEventLoop()) {
            execute(new Runnable() { // from class: io.netty.channel.nio.NioEventLoop.6
                @Override // java.lang.Runnable
                public void run() {
                    NioEventLoop.this.rebuildSelector0();
                }
            });
        } else {
            rebuildSelector0();
        }
    }

    private int select(long j10) {
        if (j10 == LocationRequestCompat.PASSIVE_INTERVAL) {
            return this.selector.select();
        }
        long jDeadlineToDelayNanos = AbstractScheduledEventExecutor.deadlineToDelayNanos(j10 + 995000) / 1000000;
        if (jDeadlineToDelayNanos <= 0) {
            return this.selector.selectNow();
        }
        return this.selector.select(jDeadlineToDelayNanos);
    }

    private static void processSelectedKey(SelectionKey selectionKey, NioTask<SelectableChannel> nioTask) {
        try {
            try {
                nioTask.channelReady(selectionKey.channel(), selectionKey);
                if (selectionKey.isValid()) {
                    return;
                }
                invokeChannelUnregistered(nioTask, selectionKey, null);
            } catch (Exception e10) {
                selectionKey.cancel();
                invokeChannelUnregistered(nioTask, selectionKey, e10);
            }
        } catch (Throwable th) {
            selectionKey.cancel();
            invokeChannelUnregistered(nioTask, selectionKey, null);
            throw th;
        }
    }
}
