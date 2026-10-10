package io.netty.channel;

import androidx.concurrent.futures.a;
import com.pengrad.telegrambot.model.message.origin.MessageOriginChannel;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class DefaultChannelPipeline implements ChannelPipeline {
    private final Channel channel;
    private Map<EventExecutorGroup, EventExecutor> childExecutors;
    private volatile MessageSizeEstimator.Handle estimatorHandle;
    final AbstractChannelHandlerContext head;
    private PendingHandlerCallback pendingHandlerCallbackHead;
    private boolean registered;
    private final ChannelFuture succeededFuture;
    final AbstractChannelHandlerContext tail;
    private final VoidChannelPromise voidPromise;
    static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultChannelPipeline.class);
    private static final String HEAD_NAME = generateName0(HeadContext.class);
    private static final String TAIL_NAME = generateName0(TailContext.class);
    private static final FastThreadLocal<Map<Class<?>, String>> nameCaches = new FastThreadLocal<Map<Class<?>, String>>() { // from class: io.netty.channel.DefaultChannelPipeline.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public Map<Class<?>, String> initialValue() {
            return new WeakHashMap();
        }
    };
    private static final AtomicReferenceFieldUpdater<DefaultChannelPipeline, MessageSizeEstimator.Handle> ESTIMATOR = AtomicReferenceFieldUpdater.newUpdater(DefaultChannelPipeline.class, MessageSizeEstimator.Handle.class, "estimatorHandle");
    private final boolean touch = ResourceLeakDetector.isEnabled();
    private boolean firstRegistration = true;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class HeadContext extends AbstractChannelHandlerContext implements ChannelOutboundHandler, ChannelInboundHandler {
        private final Channel.Unsafe unsafe;

        HeadContext(DefaultChannelPipeline defaultChannelPipeline) {
            super(defaultChannelPipeline, null, DefaultChannelPipeline.HEAD_NAME, HeadContext.class);
            this.unsafe = defaultChannelPipeline.channel().unsafe();
            setAddComplete();
        }

        private void readIfIsAutoRead() {
            if (DefaultChannelPipeline.this.channel.config().isAutoRead()) {
                DefaultChannelPipeline.this.channel.read();
            }
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) {
            this.unsafe.bind(socketAddress, channelPromise);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelRegistered(ChannelHandlerContext channelHandlerContext) {
            DefaultChannelPipeline.this.invokeHandlerAddedIfNeeded();
            channelHandlerContext.fireChannelRegistered();
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
            this.unsafe.close(channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void flush(ChannelHandlerContext channelHandlerContext) {
            this.unsafe.flush();
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void read(ChannelHandlerContext channelHandlerContext) {
            this.unsafe.beginRead();
        }

        @Override // io.netty.channel.ChannelOutboundHandler
        public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
            this.unsafe.write(obj, channelPromise);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelActive(ChannelHandlerContext channelHandlerContext) {
            channelHandlerContext.fireChannelActive();
            readIfIsAutoRead();
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelInactive(ChannelHandlerContext channelHandlerContext) {
            channelHandlerContext.fireChannelInactive();
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
            channelHandlerContext.fireChannelRead(obj);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
            channelHandlerContext.fireChannelReadComplete();
            readIfIsAutoRead();
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelUnregistered(ChannelHandlerContext channelHandlerContext) {
            channelHandlerContext.fireChannelUnregistered();
            if (!DefaultChannelPipeline.this.channel.isOpen()) {
                DefaultChannelPipeline.this.destroy();
            }
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) {
            channelHandlerContext.fireChannelWritabilityChanged();
        }

        @Override // io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
            channelHandlerContext.fireExceptionCaught(th);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
            channelHandlerContext.fireUserEventTriggered(obj);
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandler handler() {
            return this;
        }

        @Override // io.netty.channel.ChannelHandler
        public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        }

        @Override // io.netty.channel.ChannelHandler
        public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class PendingHandlerAddedTask extends PendingHandlerCallback {
        PendingHandlerAddedTask(AbstractChannelHandlerContext abstractChannelHandlerContext) {
            super(abstractChannelHandlerContext);
        }

        @Override // io.netty.channel.DefaultChannelPipeline.PendingHandlerCallback
        void execute() {
            EventExecutor eventExecutorExecutor = this.ctx.executor();
            if (eventExecutorExecutor.inEventLoop()) {
                DefaultChannelPipeline.this.callHandlerAdded0(this.ctx);
                return;
            }
            try {
                eventExecutorExecutor.execute(this);
            } catch (RejectedExecutionException e10) {
                if (DefaultChannelPipeline.logger.isWarnEnabled()) {
                    DefaultChannelPipeline.logger.warn("Can't invoke handlerAdded() as the EventExecutor {} rejected it, removing handler {}.", eventExecutorExecutor, this.ctx.name(), e10);
                }
                DefaultChannelPipeline.this.atomicRemoveFromHandlerList(this.ctx);
                this.ctx.setRemoved();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            DefaultChannelPipeline.this.callHandlerAdded0(this.ctx);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class PendingHandlerRemovedTask extends PendingHandlerCallback {
        PendingHandlerRemovedTask(AbstractChannelHandlerContext abstractChannelHandlerContext) {
            super(abstractChannelHandlerContext);
        }

        @Override // io.netty.channel.DefaultChannelPipeline.PendingHandlerCallback
        void execute() {
            EventExecutor eventExecutorExecutor = this.ctx.executor();
            if (eventExecutorExecutor.inEventLoop()) {
                DefaultChannelPipeline.this.callHandlerRemoved0(this.ctx);
                return;
            }
            try {
                eventExecutorExecutor.execute(this);
            } catch (RejectedExecutionException e10) {
                if (DefaultChannelPipeline.logger.isWarnEnabled()) {
                    DefaultChannelPipeline.logger.warn("Can't invoke handlerRemoved() as the EventExecutor {} rejected it, removing handler {}.", eventExecutorExecutor, this.ctx.name(), e10);
                }
                this.ctx.setRemoved();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            DefaultChannelPipeline.this.callHandlerRemoved0(this.ctx);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class TailContext extends AbstractChannelHandlerContext implements ChannelInboundHandler {
        TailContext(DefaultChannelPipeline defaultChannelPipeline) {
            super(defaultChannelPipeline, null, DefaultChannelPipeline.TAIL_NAME, TailContext.class);
            setAddComplete();
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelActive(ChannelHandlerContext channelHandlerContext) {
            DefaultChannelPipeline.this.onUnhandledInboundChannelActive();
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelInactive(ChannelHandlerContext channelHandlerContext) {
            DefaultChannelPipeline.this.onUnhandledInboundChannelInactive();
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
            DefaultChannelPipeline.this.onUnhandledInboundMessage(channelHandlerContext, obj);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
            DefaultChannelPipeline.this.onUnhandledInboundChannelReadComplete();
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) {
            DefaultChannelPipeline.this.onUnhandledChannelWritabilityChanged();
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
            DefaultChannelPipeline.this.onUnhandledInboundException(th);
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
            DefaultChannelPipeline.this.onUnhandledInboundUserEventTriggered(obj);
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandler handler() {
            return this;
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelRegistered(ChannelHandlerContext channelHandlerContext) {
        }

        @Override // io.netty.channel.ChannelInboundHandler
        public void channelUnregistered(ChannelHandlerContext channelHandlerContext) {
        }

        @Override // io.netty.channel.ChannelHandler
        public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        }

        @Override // io.netty.channel.ChannelHandler
        public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void atomicRemoveFromHandlerList(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = abstractChannelHandlerContext.prev;
        AbstractChannelHandlerContext abstractChannelHandlerContext3 = abstractChannelHandlerContext.next;
        abstractChannelHandlerContext2.next = abstractChannelHandlerContext3;
        abstractChannelHandlerContext3.prev = abstractChannelHandlerContext2;
    }

    private void callHandlerAddedForAllHandlers() {
        PendingHandlerCallback pendingHandlerCallback;
        synchronized (this) {
            this.registered = true;
            this.pendingHandlerCallbackHead = null;
        }
        for (pendingHandlerCallback = this.pendingHandlerCallbackHead; pendingHandlerCallback != null; pendingHandlerCallback = pendingHandlerCallback.next) {
            pendingHandlerCallback.execute();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void destroy() {
        destroyUp(this.head.next, false);
    }

    public final ChannelPipeline addLast(EventExecutorGroup eventExecutorGroup, String str, ChannelHandler channelHandler) {
        synchronized (this) {
            try {
                checkMultiplicity(channelHandler);
                AbstractChannelHandlerContext abstractChannelHandlerContextNewContext = newContext(eventExecutorGroup, filterName(str, channelHandler), channelHandler);
                addLast0(abstractChannelHandlerContextNewContext);
                if (!this.registered) {
                    abstractChannelHandlerContextNewContext.setAddPending();
                    callHandlerCallbackLater(abstractChannelHandlerContextNewContext, true);
                    return this;
                }
                EventExecutor eventExecutorExecutor = abstractChannelHandlerContextNewContext.executor();
                if (eventExecutorExecutor.inEventLoop()) {
                    callHandlerAdded0(abstractChannelHandlerContextNewContext);
                    return this;
                }
                callHandlerAddedInEventLoop(abstractChannelHandlerContextNewContext, eventExecutorExecutor);
                return this;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture close() {
        return this.tail.close();
    }

    protected void onUnhandledInboundMessage(Object obj) {
        try {
            logger.debug("Discarded inbound message {} that reached at the tail of the pipeline. Please check your pipeline configuration.", obj);
        } finally {
            ReferenceCountUtil.release(obj);
        }
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline remove(ChannelHandler channelHandler) {
        remove(getContextOrDie(channelHandler));
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static abstract class PendingHandlerCallback implements Runnable {
        final AbstractChannelHandlerContext ctx;
        PendingHandlerCallback next;

        abstract void execute();

        PendingHandlerCallback(AbstractChannelHandlerContext abstractChannelHandlerContext) {
            this.ctx = abstractChannelHandlerContext;
        }
    }

    private void addLast0(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = this.tail.prev;
        abstractChannelHandlerContext.prev = abstractChannelHandlerContext2;
        abstractChannelHandlerContext.next = this.tail;
        abstractChannelHandlerContext2.next = abstractChannelHandlerContext;
        this.tail.prev = abstractChannelHandlerContext;
    }

    private void callHandlerCallbackLater(AbstractChannelHandlerContext abstractChannelHandlerContext, boolean z10) {
        PendingHandlerCallback pendingHandlerAddedTask = z10 ? new PendingHandlerAddedTask(abstractChannelHandlerContext) : new PendingHandlerRemovedTask(abstractChannelHandlerContext);
        PendingHandlerCallback pendingHandlerCallback = this.pendingHandlerCallbackHead;
        if (pendingHandlerCallback == null) {
            this.pendingHandlerCallbackHead = pendingHandlerAddedTask;
            return;
        }
        while (true) {
            PendingHandlerCallback pendingHandlerCallback2 = pendingHandlerCallback.next;
            if (pendingHandlerCallback2 == null) {
                pendingHandlerCallback.next = pendingHandlerAddedTask;
                return;
            }
            pendingHandlerCallback = pendingHandlerCallback2;
        }
    }

    private static void checkMultiplicity(ChannelHandler channelHandler) {
        if (channelHandler instanceof ChannelHandlerAdapter) {
            ChannelHandlerAdapter channelHandlerAdapter = (ChannelHandlerAdapter) channelHandler;
            if (channelHandlerAdapter.isSharable() || !channelHandlerAdapter.added) {
                channelHandlerAdapter.added = true;
                return;
            }
            throw new ChannelPipelineException(channelHandlerAdapter.getClass().getName() + " is not a @Sharable handler, so can't be added or removed multiple times.");
        }
    }

    private EventExecutor childExecutor(EventExecutorGroup eventExecutorGroup) {
        if (eventExecutorGroup == null) {
            return null;
        }
        Boolean bool = (Boolean) this.channel.config().getOption(ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP);
        if (bool != null && !bool.booleanValue()) {
            return eventExecutorGroup.next();
        }
        Map identityHashMap = this.childExecutors;
        if (identityHashMap == null) {
            identityHashMap = new IdentityHashMap(4);
            this.childExecutors = identityHashMap;
        }
        EventExecutor eventExecutor = (EventExecutor) identityHashMap.get(eventExecutorGroup);
        if (eventExecutor != null) {
            return eventExecutor;
        }
        EventExecutor next = eventExecutorGroup.next();
        identityHashMap.put(eventExecutorGroup, next);
        return next;
    }

    private AbstractChannelHandlerContext context0(String str) {
        for (AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next; abstractChannelHandlerContext != this.tail; abstractChannelHandlerContext = abstractChannelHandlerContext.next) {
            if (abstractChannelHandlerContext.name().equals(str)) {
                return abstractChannelHandlerContext;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyDown(Thread thread, final AbstractChannelHandlerContext abstractChannelHandlerContext, boolean z10) {
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = this.head;
        while (abstractChannelHandlerContext != abstractChannelHandlerContext2) {
            EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
            if (!z10 && !eventExecutorExecutor.inEventLoop(thread)) {
                eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.channel.DefaultChannelPipeline.5
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultChannelPipeline.this.destroyDown(Thread.currentThread(), abstractChannelHandlerContext, true);
                    }
                });
                return;
            }
            atomicRemoveFromHandlerList(abstractChannelHandlerContext);
            callHandlerRemoved0(abstractChannelHandlerContext);
            abstractChannelHandlerContext = abstractChannelHandlerContext.prev;
            z10 = false;
        }
    }

    private String filterName(String str, ChannelHandler channelHandler) {
        if (str == null) {
            return generateName(channelHandler);
        }
        checkDuplicateName(str);
        return str;
    }

    private String generateName(ChannelHandler channelHandler) {
        Map<Class<?>, String> map = nameCaches.get();
        Class<?> cls = channelHandler.getClass();
        String strGenerateName0 = map.get(cls);
        if (strGenerateName0 == null) {
            strGenerateName0 = generateName0(cls);
            map.put(cls, strGenerateName0);
        }
        if (context0(strGenerateName0) == null) {
            return strGenerateName0;
        }
        int i10 = 1;
        String strSubstring = strGenerateName0.substring(0, strGenerateName0.length() - 1);
        while (true) {
            String str = strSubstring + i10;
            if (context0(str) == null) {
                return str;
            }
            i10++;
        }
    }

    private static String generateName0(Class<?> cls) {
        return StringUtil.simpleClassName(cls) + "#0";
    }

    private AbstractChannelHandlerContext newContext(EventExecutorGroup eventExecutorGroup, String str, ChannelHandler channelHandler) {
        return new DefaultChannelHandlerContext(this, childExecutor(eventExecutorGroup), str, channelHandler);
    }

    private AbstractChannelHandlerContext remove(final AbstractChannelHandlerContext abstractChannelHandlerContext) {
        synchronized (this) {
            try {
                atomicRemoveFromHandlerList(abstractChannelHandlerContext);
                if (!this.registered) {
                    callHandlerCallbackLater(abstractChannelHandlerContext, false);
                    return abstractChannelHandlerContext;
                }
                EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
                if (eventExecutorExecutor.inEventLoop()) {
                    callHandlerRemoved0(abstractChannelHandlerContext);
                    return abstractChannelHandlerContext;
                }
                eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.channel.DefaultChannelPipeline.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultChannelPipeline.this.callHandlerRemoved0(abstractChannelHandlerContext);
                    }
                });
                return abstractChannelHandlerContext;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return this.tail.bind(socketAddress, channelPromise);
    }

    public final Channel channel() {
        return this.channel;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture close(ChannelPromise channelPromise) {
        return this.tail.close(channelPromise);
    }

    public final ChannelHandlerContext context(ChannelHandler channelHandler) {
        ObjectUtil.checkNotNull(channelHandler, "handler");
        for (AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next; abstractChannelHandlerContext != null; abstractChannelHandlerContext = abstractChannelHandlerContext.next) {
            if (abstractChannelHandlerContext.handler() == channelHandler) {
                return abstractChannelHandlerContext;
            }
        }
        return null;
    }

    protected void decrementPendingOutboundBytes(long j10) {
        ChannelOutboundBuffer channelOutboundBufferOutboundBuffer = this.channel.unsafe().outboundBuffer();
        if (channelOutboundBufferOutboundBuffer != null) {
            channelOutboundBufferOutboundBuffer.decrementPendingOutboundBytes(j10);
        }
    }

    final MessageSizeEstimator.Handle estimatorHandle() {
        MessageSizeEstimator.Handle handle = this.estimatorHandle;
        if (handle != null) {
            return handle;
        }
        MessageSizeEstimator.Handle handleNewHandle = this.channel.config().getMessageSizeEstimator().newHandle();
        return !a.a(ESTIMATOR, this, null, handleNewHandle) ? this.estimatorHandle : handleNewHandle;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireChannelActive() {
        AbstractChannelHandlerContext.invokeChannelActive(this.head);
        return this;
    }

    public final ChannelPipeline fireChannelInactive() {
        AbstractChannelHandlerContext.invokeChannelInactive(this.head);
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireChannelRead(Object obj) {
        AbstractChannelHandlerContext.invokeChannelRead(this.head, obj);
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireChannelReadComplete() {
        AbstractChannelHandlerContext.invokeChannelReadComplete(this.head);
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireChannelRegistered() {
        AbstractChannelHandlerContext.invokeChannelRegistered(this.head);
        return this;
    }

    public final ChannelPipeline fireChannelUnregistered() {
        AbstractChannelHandlerContext.invokeChannelUnregistered(this.head);
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireChannelWritabilityChanged() {
        AbstractChannelHandlerContext.invokeChannelWritabilityChanged(this.head);
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireExceptionCaught(Throwable th) {
        AbstractChannelHandlerContext.invokeExceptionCaught(this.head, th);
        return this;
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireUserEventTriggered(Object obj) {
        AbstractChannelHandlerContext.invokeUserEventTriggered(this.head, obj);
        return this;
    }

    public final ChannelPipeline flush() {
        this.tail.flush();
        return this;
    }

    protected void incrementPendingOutboundBytes(long j10) {
        ChannelOutboundBuffer channelOutboundBufferOutboundBuffer = this.channel.unsafe().outboundBuffer();
        if (channelOutboundBufferOutboundBuffer != null) {
            channelOutboundBufferOutboundBuffer.incrementPendingOutboundBytes(j10);
        }
    }

    final void invokeHandlerAddedIfNeeded() {
        if (this.firstRegistration) {
            this.firstRegistration = false;
            callHandlerAddedForAllHandlers();
        }
    }

    @Override // io.netty.channel.ChannelPipeline
    public final List<String> names() {
        ArrayList arrayList = new ArrayList();
        for (AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next; abstractChannelHandlerContext != null; abstractChannelHandlerContext = abstractChannelHandlerContext.next) {
            arrayList.add(abstractChannelHandlerContext.name());
        }
        return arrayList;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelPromise newPromise() {
        return new DefaultChannelPromise(this.channel);
    }

    protected void onUnhandledInboundException(Throwable th) {
        try {
            logger.warn("An exceptionCaught() event was fired, and it reached at the tail of the pipeline. It usually means the last handler in the pipeline did not handle the exception.", th);
        } finally {
            ReferenceCountUtil.release(th);
        }
    }

    public final ChannelPipeline read() {
        this.tail.read();
        return this;
    }

    public final Map<String, ChannelHandler> toMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next; abstractChannelHandlerContext != this.tail; abstractChannelHandlerContext = abstractChannelHandlerContext.next) {
            linkedHashMap.put(abstractChannelHandlerContext.name(), abstractChannelHandlerContext.handler());
        }
        return linkedHashMap;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(StringUtil.simpleClassName(this));
        sb2.append('{');
        AbstractChannelHandlerContext abstractChannelHandlerContext = this.head.next;
        while (abstractChannelHandlerContext != this.tail) {
            sb2.append('(');
            sb2.append(abstractChannelHandlerContext.name());
            sb2.append(" = ");
            sb2.append(abstractChannelHandlerContext.handler().getClass().getName());
            sb2.append(')');
            abstractChannelHandlerContext = abstractChannelHandlerContext.next;
            if (abstractChannelHandlerContext == this.tail) {
                break;
            }
            sb2.append(", ");
        }
        sb2.append('}');
        return sb2.toString();
    }

    final Object touch(Object obj, AbstractChannelHandlerContext abstractChannelHandlerContext) {
        return this.touch ? ReferenceCountUtil.touch(obj, abstractChannelHandlerContext) : obj;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelPromise voidPromise() {
        return this.voidPromise;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture write(Object obj) {
        return this.tail.write(obj);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture writeAndFlush(Object obj) {
        return this.tail.writeAndFlush(obj);
    }

    protected DefaultChannelPipeline(Channel channel) {
        this.channel = (Channel) ObjectUtil.checkNotNull(channel, MessageOriginChannel.MESSAGE_ORIGIN_TYPE);
        this.succeededFuture = new SucceededChannelFuture(channel, null);
        this.voidPromise = new VoidChannelPromise(channel, true);
        TailContext tailContext = new TailContext(this);
        this.tail = tailContext;
        HeadContext headContext = new HeadContext(this);
        this.head = headContext;
        headContext.next = tailContext;
        tailContext.prev = headContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callHandlerAdded0(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        try {
            abstractChannelHandlerContext.callHandlerAdded();
        } catch (Throwable th) {
            try {
                atomicRemoveFromHandlerList(abstractChannelHandlerContext);
                abstractChannelHandlerContext.callHandlerRemoved();
                fireExceptionCaught(new ChannelPipelineException(abstractChannelHandlerContext.handler().getClass().getName() + ".handlerAdded() has thrown an exception; removed.", th));
            } catch (Throwable th2) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isWarnEnabled()) {
                    internalLogger.warn("Failed to remove a handler: " + abstractChannelHandlerContext.name(), th2);
                }
                fireExceptionCaught(new ChannelPipelineException(abstractChannelHandlerContext.handler().getClass().getName() + ".handlerAdded() has thrown an exception; also failed to remove.", th));
            }
        }
    }

    private void callHandlerAddedInEventLoop(final AbstractChannelHandlerContext abstractChannelHandlerContext, EventExecutor eventExecutor) {
        abstractChannelHandlerContext.setAddPending();
        eventExecutor.execute(new Runnable() { // from class: io.netty.channel.DefaultChannelPipeline.6
            @Override // java.lang.Runnable
            public void run() {
                DefaultChannelPipeline.this.callHandlerAdded0(abstractChannelHandlerContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callHandlerRemoved0(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        try {
            abstractChannelHandlerContext.callHandlerRemoved();
        } catch (Throwable th) {
            fireExceptionCaught(new ChannelPipelineException(abstractChannelHandlerContext.handler().getClass().getName() + ".handlerRemoved() has thrown an exception.", th));
        }
    }

    private void checkDuplicateName(String str) {
        if (context0(str) == null) {
            return;
        }
        throw new IllegalArgumentException("Duplicate handler name: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyUp(final AbstractChannelHandlerContext abstractChannelHandlerContext, boolean z10) {
        Thread threadCurrentThread = Thread.currentThread();
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = this.tail;
        while (abstractChannelHandlerContext != abstractChannelHandlerContext2) {
            EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
            if (!z10 && !eventExecutorExecutor.inEventLoop(threadCurrentThread)) {
                eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.channel.DefaultChannelPipeline.4
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultChannelPipeline.this.destroyUp(abstractChannelHandlerContext, true);
                    }
                });
                return;
            } else {
                abstractChannelHandlerContext = abstractChannelHandlerContext.next;
                z10 = false;
            }
        }
        destroyDown(threadCurrentThread, abstractChannelHandlerContext2.prev, z10);
    }

    private AbstractChannelHandlerContext getContextOrDie(ChannelHandler channelHandler) {
        AbstractChannelHandlerContext abstractChannelHandlerContext = (AbstractChannelHandlerContext) context(channelHandler);
        if (abstractChannelHandlerContext != null) {
            return abstractChannelHandlerContext;
        }
        throw new NoSuchElementException(channelHandler.getClass().getName());
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<String, ChannelHandler>> iterator() {
        return toMap().entrySet().iterator();
    }

    protected void onUnhandledInboundUserEventTriggered(Object obj) {
        ReferenceCountUtil.release(obj);
    }

    protected void onUnhandledInboundMessage(ChannelHandlerContext channelHandlerContext, Object obj) {
        onUnhandledInboundMessage(obj);
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("Discarded message pipeline : {}. Channel : {}.", channelHandlerContext.pipeline().names(), channelHandlerContext.channel());
        }
    }

    @Override // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addLast(ChannelHandler... channelHandlerArr) {
        return addLast(null, channelHandlerArr);
    }

    public final ChannelPipeline addLast(EventExecutorGroup eventExecutorGroup, ChannelHandler... channelHandlerArr) {
        ObjectUtil.checkNotNull(channelHandlerArr, "handlers");
        for (ChannelHandler channelHandler : channelHandlerArr) {
            if (channelHandler == null) {
                break;
            }
            addLast(eventExecutorGroup, null, channelHandler);
        }
        return this;
    }

    protected void onUnhandledChannelWritabilityChanged() {
    }

    protected void onUnhandledInboundChannelActive() {
    }

    protected void onUnhandledInboundChannelInactive() {
    }

    protected void onUnhandledInboundChannelReadComplete() {
    }
}
