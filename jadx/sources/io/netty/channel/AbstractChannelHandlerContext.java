package io.netty.channel;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import d8.a;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ResourceLeakHint;
import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class AbstractChannelHandlerContext implements ChannelHandlerContext, ResourceLeakHint {
    private final int executionMask;
    final EventExecutor executor;
    private volatile int handlerState = 0;
    private Tasks invokeTasks;
    private final String name;
    volatile AbstractChannelHandlerContext next;
    private final boolean ordered;
    private final DefaultChannelPipeline pipeline;
    volatile AbstractChannelHandlerContext prev;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractChannelHandlerContext.class);
    private static final AtomicIntegerFieldUpdater<AbstractChannelHandlerContext> HANDLER_STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AbstractChannelHandlerContext.class, "handlerState");

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class Tasks {
        private final AbstractChannelHandlerContext next;
        private final Runnable invokeChannelReadCompleteTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.1
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeChannelReadComplete();
            }
        };
        private final Runnable invokeReadTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.2
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeRead();
            }
        };
        private final Runnable invokeChannelWritableStateChangedTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.3
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeChannelWritabilityChanged();
            }
        };
        private final Runnable invokeFlushTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.4
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeFlush();
            }
        };

        Tasks(AbstractChannelHandlerContext abstractChannelHandlerContext) {
            this.next = abstractChannelHandlerContext;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class WriteTask implements Runnable {
        private AbstractChannelHandlerContext ctx;
        private final ObjectPool.Handle<WriteTask> handle;
        private Object msg;
        private ChannelPromise promise;
        private int size;
        private static final ObjectPool<WriteTask> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<WriteTask>() { // from class: io.netty.channel.AbstractChannelHandlerContext.WriteTask.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.internal.ObjectPool.ObjectCreator
            public WriteTask newObject(ObjectPool.Handle<WriteTask> handle) {
                return new WriteTask(handle);
            }
        });
        private static final boolean ESTIMATE_TASK_SIZE_ON_SUBMIT = SystemPropertyUtil.getBoolean("io.netty.transport.estimateSizeOnSubmit", true);
        private static final int WRITE_TASK_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.writeTaskSizeOverhead", 32);

        private void recycle() {
            this.ctx = null;
            this.msg = null;
            this.promise = null;
            this.handle.recycle(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private WriteTask(ObjectPool.Handle<? extends WriteTask> handle) {
            this.handle = handle;
        }

        private void decrementPendingOutboundBytes() {
            if (ESTIMATE_TASK_SIZE_ON_SUBMIT) {
                this.ctx.pipeline.decrementPendingOutboundBytes(this.size & Integer.MAX_VALUE);
            }
        }

        protected static void init(WriteTask writeTask, AbstractChannelHandlerContext abstractChannelHandlerContext, Object obj, ChannelPromise channelPromise, boolean z10) {
            writeTask.ctx = abstractChannelHandlerContext;
            writeTask.msg = obj;
            writeTask.promise = channelPromise;
            if (ESTIMATE_TASK_SIZE_ON_SUBMIT) {
                writeTask.size = abstractChannelHandlerContext.pipeline.estimatorHandle().size(obj) + WRITE_TASK_OVERHEAD;
                abstractChannelHandlerContext.pipeline.incrementPendingOutboundBytes(writeTask.size);
            } else {
                writeTask.size = 0;
            }
            if (z10) {
                writeTask.size |= Integer.MIN_VALUE;
            }
        }

        static WriteTask newInstance(AbstractChannelHandlerContext abstractChannelHandlerContext, Object obj, ChannelPromise channelPromise, boolean z10) {
            WriteTask writeTask = RECYCLER.get();
            init(writeTask, abstractChannelHandlerContext, obj, channelPromise, z10);
            return writeTask;
        }

        void cancel() {
            try {
                decrementPendingOutboundBytes();
            } finally {
                recycle();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                decrementPendingOutboundBytes();
                if (this.size >= 0) {
                    this.ctx.invokeWrite(this.msg, this.promise);
                } else {
                    this.ctx.invokeWriteAndFlush(this.msg, this.promise);
                }
            } finally {
                recycle();
            }
        }
    }

    static void invokeChannelActive(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelActive();
        } else {
            eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.3
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelActive();
                }
            });
        }
    }

    static void invokeChannelInactive(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelInactive();
        } else {
            eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.4
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelInactive();
                }
            });
        }
    }

    static void invokeChannelRead(AbstractChannelHandlerContext abstractChannelHandlerContext, Object obj) {
        final Object obj2 = abstractChannelHandlerContext.pipeline.touch(ObjectUtil.checkNotNull(obj, NotificationCompat.CATEGORY_MESSAGE), abstractChannelHandlerContext);
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelRead(obj2);
        } else {
            eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.7
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelRead(obj2);
                }
            });
        }
    }

    static void invokeChannelReadComplete(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelReadComplete();
            return;
        }
        Tasks tasks = abstractChannelHandlerContext.invokeTasks;
        if (tasks == null) {
            tasks = new Tasks(abstractChannelHandlerContext);
            abstractChannelHandlerContext.invokeTasks = tasks;
        }
        eventExecutorExecutor.execute(tasks.invokeChannelReadCompleteTask);
    }

    static void invokeChannelRegistered(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelRegistered();
        } else {
            eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelRegistered();
                }
            });
        }
    }

    static void invokeChannelUnregistered(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelUnregistered();
        } else {
            eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelUnregistered();
                }
            });
        }
    }

    static void invokeChannelWritabilityChanged(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelWritabilityChanged();
            return;
        }
        Tasks tasks = abstractChannelHandlerContext.invokeTasks;
        if (tasks == null) {
            tasks = new Tasks(abstractChannelHandlerContext);
            abstractChannelHandlerContext.invokeTasks = tasks;
        }
        eventExecutorExecutor.execute(tasks.invokeChannelWritableStateChangedTask);
    }

    static void invokeExceptionCaught(AbstractChannelHandlerContext abstractChannelHandlerContext, final Throwable th) {
        ObjectUtil.checkNotNull(th, "cause");
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContext.invokeExceptionCaught(th);
            return;
        }
        try {
            eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.5
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeExceptionCaught(th);
                }
            });
        } catch (Throwable th2) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isWarnEnabled()) {
                internalLogger.warn("Failed to submit an exceptionCaught() event.", th2);
                internalLogger.warn("The exceptionCaught() event that was failed to submit was:", th);
            }
        }
    }

    static void invokeUserEventTriggered(AbstractChannelHandlerContext abstractChannelHandlerContext, final Object obj) {
        ObjectUtil.checkNotNull(obj, NotificationCompat.CATEGORY_EVENT);
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContext.invokeUserEventTriggered(obj);
        } else {
            eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.6
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeUserEventTriggered(obj);
                }
            });
        }
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close() {
        return close(newPromise());
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelRegistered() {
        invokeChannelRegistered(findContextInbound(2));
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelUnregistered() {
        invokeChannelUnregistered(findContextInbound(4));
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireExceptionCaught(Throwable th) {
        invokeExceptionCaught(findContextInbound(1), th);
        return this;
    }

    final void setRemoved() {
        this.handlerState = 3;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object obj) {
        return write(obj, newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object obj, ChannelPromise channelPromise) {
        write(obj, true, channelPromise);
        return channelPromise;
    }

    private boolean invokeHandler() {
        int i10 = this.handlerState;
        return i10 == 2 || (!this.ordered && i10 == 1);
    }

    private boolean isNotValidPromise(ChannelPromise channelPromise, boolean z10) {
        ObjectUtil.checkNotNull(channelPromise, "promise");
        if (channelPromise.isDone()) {
            if (channelPromise.isCancelled()) {
                return true;
            }
            throw new IllegalArgumentException("promise already done: " + channelPromise);
        }
        if (channelPromise.channel() != channel()) {
            throw new IllegalArgumentException(String.format("promise.channel does not match: %s (expected: %s)", channelPromise.channel(), channel()));
        }
        if (channelPromise.getClass() == DefaultChannelPromise.class) {
            return false;
        }
        if (!z10 && (channelPromise instanceof VoidChannelPromise)) {
            throw new IllegalArgumentException(StringUtil.simpleClassName((Class<?>) VoidChannelPromise.class) + " not allowed for this operation");
        }
        if (!(channelPromise instanceof AbstractChannel.CloseFuture)) {
            return false;
        }
        throw new IllegalArgumentException(StringUtil.simpleClassName((Class<?>) AbstractChannel.CloseFuture.class) + " not allowed in a pipeline");
    }

    private static void notifyOutboundHandlerException(Throwable th, ChannelPromise channelPromise) {
        PromiseNotificationUtil.tryFailure(channelPromise, th, channelPromise instanceof VoidChannelPromise ? null : logger);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x000c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean safeExecute(EventExecutor eventExecutor, Runnable runnable, ChannelPromise channelPromise, Object obj, boolean z10) {
        if (!z10) {
            eventExecutor.execute(runnable);
            return true;
        }
        if (eventExecutor instanceof AbstractEventExecutor) {
            ((AbstractEventExecutor) eventExecutor).lazyExecute(runnable);
            return true;
        }
        eventExecutor.execute(runnable);
        return true;
        if (obj != null) {
            try {
                ReferenceCountUtil.release(obj);
            } finally {
                channelPromise.setFailure(th);
            }
        }
        return false;
    }

    private static boolean skipContext(AbstractChannelHandlerContext abstractChannelHandlerContext, EventExecutor eventExecutor, int i10, int i11) {
        if (((i11 | i10) & abstractChannelHandlerContext.executionMask) != 0) {
            return abstractChannelHandlerContext.executor() == eventExecutor && (abstractChannelHandlerContext.executionMask & i10) == 0;
        }
        return true;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(final SocketAddress socketAddress, final ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(socketAddress, "localAddress");
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound(512);
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContextFindContextOutbound.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContextFindContextOutbound.invokeBind(socketAddress, channelPromise);
            return channelPromise;
        }
        safeExecute(eventExecutorExecutor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.8
            @Override // java.lang.Runnable
            public void run() {
                abstractChannelHandlerContextFindContextOutbound.invokeBind(socketAddress, channelPromise);
            }
        }, channelPromise, null, false);
        return channelPromise;
    }

    final void callHandlerRemoved() {
        try {
            if (this.handlerState == 2) {
                handler().handlerRemoved(this);
            }
        } finally {
            setRemoved();
        }
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public Channel channel() {
        return this.pipeline.channel();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close(final ChannelPromise channelPromise) {
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound(4096);
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContextFindContextOutbound.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContextFindContextOutbound.invokeClose(channelPromise);
            return channelPromise;
        }
        safeExecute(eventExecutorExecutor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.11
            @Override // java.lang.Runnable
            public void run() {
                abstractChannelHandlerContextFindContextOutbound.invokeClose(channelPromise);
            }
        }, channelPromise, null, false);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public EventExecutor executor() {
        EventExecutor eventExecutor = this.executor;
        return eventExecutor == null ? channel().eventLoop() : eventExecutor;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelActive() {
        invokeChannelActive(findContextInbound(8));
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelInactive() {
        invokeChannelInactive(findContextInbound(16));
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelRead(Object obj) {
        invokeChannelRead(findContextInbound(32), obj);
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelReadComplete() {
        invokeChannelReadComplete(findContextInbound(64));
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelWritabilityChanged() {
        invokeChannelWritabilityChanged(findContextInbound(256));
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireUserEventTriggered(Object obj) {
        invokeUserEventTriggered(findContextInbound(128), obj);
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext flush() {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound(65536);
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContextFindContextOutbound.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContextFindContextOutbound.invokeFlush();
            return this;
        }
        Tasks tasks = abstractChannelHandlerContextFindContextOutbound.invokeTasks;
        if (tasks == null) {
            tasks = new Tasks(abstractChannelHandlerContextFindContextOutbound);
            abstractChannelHandlerContextFindContextOutbound.invokeTasks = tasks;
        }
        safeExecute(eventExecutorExecutor, tasks.invokeFlushTask, channel().voidPromise(), null, false);
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public boolean isRemoved() {
        return this.handlerState == 3;
    }

    public String name() {
        return this.name;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise newPromise() {
        return new DefaultChannelPromise(channel(), executor());
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelPipeline pipeline() {
        return this.pipeline;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext read() {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound(16384);
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContextFindContextOutbound.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContextFindContextOutbound.invokeRead();
            return this;
        }
        Tasks tasks = abstractChannelHandlerContextFindContextOutbound.invokeTasks;
        if (tasks == null) {
            tasks = new Tasks(abstractChannelHandlerContextFindContextOutbound);
            abstractChannelHandlerContextFindContextOutbound.invokeTasks = tasks;
        }
        eventExecutorExecutor.execute(tasks.invokeReadTask);
        return this;
    }

    final boolean setAddComplete() {
        int i10;
        do {
            i10 = this.handlerState;
            if (i10 == 3) {
                return false;
            }
        } while (!HANDLER_STATE_UPDATER.compareAndSet(this, i10, 2));
        return true;
    }

    final void setAddPending() {
        HANDLER_STATE_UPDATER.compareAndSet(this, 0, 1);
    }

    @Override // io.netty.util.ResourceLeakHint
    public String toHintString() {
        return '\'' + this.name + "' will handle the message from this point.";
    }

    public String toString() {
        return StringUtil.simpleClassName((Class<?>) ChannelHandlerContext.class) + '(' + this.name + ", " + channel() + ')';
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object obj, ChannelPromise channelPromise) {
        write(obj, false, channelPromise);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object obj) {
        return writeAndFlush(obj, newPromise());
    }

    AbstractChannelHandlerContext(DefaultChannelPipeline defaultChannelPipeline, EventExecutor eventExecutor, String str, Class<? extends ChannelHandler> cls) {
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
        this.pipeline = defaultChannelPipeline;
        this.executor = eventExecutor;
        this.executionMask = ChannelHandlerMask.mask(cls);
        this.ordered = eventExecutor == null || (eventExecutor instanceof a);
    }

    private AbstractChannelHandlerContext findContextInbound(int i10) {
        EventExecutor eventExecutorExecutor = executor();
        AbstractChannelHandlerContext abstractChannelHandlerContext = this;
        do {
            abstractChannelHandlerContext = abstractChannelHandlerContext.next;
        } while (skipContext(abstractChannelHandlerContext, eventExecutorExecutor, i10, TypedValues.PositionType.TYPE_POSITION_TYPE));
        return abstractChannelHandlerContext;
    }

    private AbstractChannelHandlerContext findContextOutbound(int i10) {
        EventExecutor eventExecutorExecutor = executor();
        AbstractChannelHandlerContext abstractChannelHandlerContext = this;
        do {
            abstractChannelHandlerContext = abstractChannelHandlerContext.prev;
        } while (skipContext(abstractChannelHandlerContext, eventExecutorExecutor, i10, 130560));
        return abstractChannelHandlerContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeBind(SocketAddress socketAddress, ChannelPromise channelPromise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).bind(this, socketAddress, channelPromise);
                return;
            } catch (Throwable th) {
                notifyOutboundHandlerException(th, channelPromise);
                return;
            }
        }
        bind(socketAddress, channelPromise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeClose(ChannelPromise channelPromise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).close(this, channelPromise);
                return;
            } catch (Throwable th) {
                notifyOutboundHandlerException(th, channelPromise);
                return;
            }
        }
        close(channelPromise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeFlush() {
        if (invokeHandler()) {
            invokeFlush0();
        } else {
            flush();
        }
    }

    private void invokeFlush0() {
        try {
            ((ChannelOutboundHandler) handler()).flush(this);
        } catch (Throwable th) {
            invokeExceptionCaught(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeRead() {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).read(this);
                return;
            } catch (Throwable th) {
                invokeExceptionCaught(th);
                return;
            }
        }
        read();
    }

    private void invokeWrite0(Object obj, ChannelPromise channelPromise) {
        try {
            ((ChannelOutboundHandler) handler()).write(this, obj, channelPromise);
        } catch (Throwable th) {
            notifyOutboundHandlerException(th, channelPromise);
        }
    }

    private void write(Object obj, boolean z10, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(obj, NotificationCompat.CATEGORY_MESSAGE);
        try {
            if (isNotValidPromise(channelPromise, true)) {
                ReferenceCountUtil.release(obj);
                return;
            }
            AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound(z10 ? 98304 : 32768);
            Object obj2 = this.pipeline.touch(obj, abstractChannelHandlerContextFindContextOutbound);
            EventExecutor eventExecutorExecutor = abstractChannelHandlerContextFindContextOutbound.executor();
            if (eventExecutorExecutor.inEventLoop()) {
                if (z10) {
                    abstractChannelHandlerContextFindContextOutbound.invokeWriteAndFlush(obj2, channelPromise);
                    return;
                } else {
                    abstractChannelHandlerContextFindContextOutbound.invokeWrite(obj2, channelPromise);
                    return;
                }
            }
            WriteTask writeTaskNewInstance = WriteTask.newInstance(abstractChannelHandlerContextFindContextOutbound, obj2, channelPromise, z10);
            if (safeExecute(eventExecutorExecutor, writeTaskNewInstance, channelPromise, obj2, !z10)) {
                return;
            }
            writeTaskNewInstance.cancel();
        } catch (RuntimeException e10) {
            ReferenceCountUtil.release(obj);
            throw e10;
        }
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ByteBufAllocator alloc() {
        return channel().config().getAllocator();
    }

    final void callHandlerAdded() {
        if (setAddComplete()) {
            handler().handlerAdded(this);
        }
    }

    void invokeWrite(Object obj, ChannelPromise channelPromise) {
        if (invokeHandler()) {
            invokeWrite0(obj, channelPromise);
        } else {
            write(obj, channelPromise);
        }
    }

    void invokeWriteAndFlush(Object obj, ChannelPromise channelPromise) {
        if (invokeHandler()) {
            invokeWrite0(obj, channelPromise);
            invokeFlush0();
        } else {
            writeAndFlush(obj, channelPromise);
        }
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise voidPromise() {
        return channel().voidPromise();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelActive() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelActive(this);
                return;
            } catch (Throwable th) {
                invokeExceptionCaught(th);
                return;
            }
        }
        fireChannelActive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelInactive() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelInactive(this);
                return;
            } catch (Throwable th) {
                invokeExceptionCaught(th);
                return;
            }
        }
        fireChannelInactive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelRegistered() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelRegistered(this);
                return;
            } catch (Throwable th) {
                invokeExceptionCaught(th);
                return;
            }
        }
        fireChannelRegistered();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelUnregistered() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelUnregistered(this);
                return;
            } catch (Throwable th) {
                invokeExceptionCaught(th);
                return;
            }
        }
        fireChannelUnregistered();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelRead(Object obj) {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelRead(this, obj);
                return;
            } catch (Throwable th) {
                invokeExceptionCaught(th);
                return;
            }
        }
        fireChannelRead(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeUserEventTriggered(Object obj) {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).userEventTriggered(this, obj);
                return;
            } catch (Throwable th) {
                invokeExceptionCaught(th);
                return;
            }
        }
        fireUserEventTriggered(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelReadComplete() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelReadComplete(this);
                return;
            } catch (Throwable th) {
                invokeExceptionCaught(th);
                return;
            }
        }
        fireChannelReadComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelWritabilityChanged() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelWritabilityChanged(this);
                return;
            } catch (Throwable th) {
                invokeExceptionCaught(th);
                return;
            }
        }
        fireChannelWritabilityChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeExceptionCaught(Throwable th) {
        if (invokeHandler()) {
            try {
                handler().exceptionCaught(this, th);
                return;
            } catch (Throwable th2) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("An exception {}was thrown by a user handler's exceptionCaught() method while handling the following exception:", ThrowableUtil.stackTraceToString(th2), th);
                    return;
                } else {
                    if (internalLogger.isWarnEnabled()) {
                        internalLogger.warn("An exception '{}' [enable DEBUG level for full stacktrace] was thrown by a user handler's exceptionCaught() method while handling the following exception:", th2, th);
                        return;
                    }
                    return;
                }
            }
        }
        fireExceptionCaught(th);
    }
}
