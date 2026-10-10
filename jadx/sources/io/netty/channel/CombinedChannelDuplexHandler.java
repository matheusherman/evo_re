package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class CombinedChannelDuplexHandler<I extends ChannelInboundHandler, O extends ChannelOutboundHandler> extends ChannelDuplexHandler {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) CombinedChannelDuplexHandler.class);
    private volatile boolean handlerAdded;
    private DelegatingChannelHandlerContext inboundCtx;
    private I inboundHandler;
    private DelegatingChannelHandlerContext outboundCtx;
    private O outboundHandler;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class DelegatingChannelHandlerContext implements ChannelHandlerContext {
        private final ChannelHandlerContext ctx;
        private final ChannelHandler handler;
        boolean removed;

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture close() {
            return this.ctx.close();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture write(Object obj) {
            return this.ctx.write(obj);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture writeAndFlush(Object obj, ChannelPromise channelPromise) {
            return this.ctx.writeAndFlush(obj, channelPromise);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void remove0() {
            if (this.removed) {
                return;
            }
            this.removed = true;
            try {
                this.handler.handlerRemoved(this);
            } catch (Throwable th) {
                fireExceptionCaught(new ChannelPipelineException(this.handler.getClass().getName() + ".handlerRemoved() has thrown an exception.", th));
            }
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ByteBufAllocator alloc() {
            return this.ctx.alloc();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
            return this.ctx.bind(socketAddress, channelPromise);
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public Channel channel() {
            return this.ctx.channel();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture close(ChannelPromise channelPromise) {
            return this.ctx.close(channelPromise);
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public EventExecutor executor() {
            return this.ctx.executor();
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelActive() {
            this.ctx.fireChannelActive();
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelInactive() {
            this.ctx.fireChannelInactive();
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelRead(Object obj) {
            this.ctx.fireChannelRead(obj);
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelReadComplete() {
            this.ctx.fireChannelReadComplete();
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelRegistered() {
            this.ctx.fireChannelRegistered();
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelUnregistered() {
            this.ctx.fireChannelUnregistered();
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelWritabilityChanged() {
            this.ctx.fireChannelWritabilityChanged();
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireExceptionCaught(Throwable th) {
            this.ctx.fireExceptionCaught(th);
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireUserEventTriggered(Object obj) {
            this.ctx.fireUserEventTriggered(obj);
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext flush() {
            this.ctx.flush();
            return this;
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public boolean isRemoved() {
            return this.removed || this.ctx.isRemoved();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelPromise newPromise() {
            return this.ctx.newPromise();
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelPipeline pipeline() {
            return this.ctx.pipeline();
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext read() {
            this.ctx.read();
            return this;
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelPromise voidPromise() {
            return this.ctx.voidPromise();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture write(Object obj, ChannelPromise channelPromise) {
            return this.ctx.write(obj, channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture writeAndFlush(Object obj) {
            return this.ctx.writeAndFlush(obj);
        }

        DelegatingChannelHandlerContext(ChannelHandlerContext channelHandlerContext, ChannelHandler channelHandler) {
            this.ctx = channelHandlerContext;
            this.handler = channelHandler;
        }

        final void remove() {
            EventExecutor eventExecutorExecutor = executor();
            if (eventExecutorExecutor.inEventLoop()) {
                remove0();
            } else {
                eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.channel.CombinedChannelDuplexHandler.DelegatingChannelHandlerContext.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DelegatingChannelHandlerContext.this.remove0();
                    }
                });
            }
        }
    }

    private void validate(I i10, O o10) {
        if (this.inboundHandler != null) {
            throw new IllegalStateException("init() can not be invoked if " + CombinedChannelDuplexHandler.class.getSimpleName() + " was constructed with non-default constructor.");
        }
        ObjectUtil.checkNotNull(i10, "inboundHandler");
        ObjectUtil.checkNotNull(o10, "outboundHandler");
        if (i10 instanceof ChannelOutboundHandler) {
            throw new IllegalArgumentException("inboundHandler must not implement " + ChannelOutboundHandler.class.getSimpleName() + " to get combined.");
        }
        if (o10 instanceof ChannelInboundHandler) {
            throw new IllegalArgumentException("outboundHandler must not implement " + ChannelInboundHandler.class.getSimpleName() + " to get combined.");
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.bind(socketAddress, channelPromise);
        } else {
            this.outboundHandler.bind(delegatingChannelHandlerContext, socketAddress, channelPromise);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.fireChannelActive();
        } else {
            this.inboundHandler.channelActive(delegatingChannelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.fireChannelInactive();
        } else {
            this.inboundHandler.channelInactive(delegatingChannelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.fireChannelRead(obj);
        } else {
            this.inboundHandler.channelRead(delegatingChannelHandlerContext, obj);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.fireChannelReadComplete();
        } else {
            this.inboundHandler.channelReadComplete(delegatingChannelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.fireChannelRegistered();
        } else {
            this.inboundHandler.channelRegistered(delegatingChannelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelUnregistered(ChannelHandlerContext channelHandlerContext) {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.fireChannelUnregistered();
        } else {
            this.inboundHandler.channelUnregistered(delegatingChannelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.fireChannelWritabilityChanged();
        } else {
            this.inboundHandler.channelWritabilityChanged(delegatingChannelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.close(channelPromise);
        } else {
            this.outboundHandler.close(delegatingChannelHandlerContext, channelPromise);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.fireExceptionCaught(th);
        } else {
            this.inboundHandler.exceptionCaught(delegatingChannelHandlerContext, th);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.flush();
        } else {
            this.outboundHandler.flush(delegatingChannelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        if (this.inboundHandler != null) {
            this.outboundCtx = new DelegatingChannelHandlerContext(channelHandlerContext, this.outboundHandler);
            this.inboundCtx = new DelegatingChannelHandlerContext(channelHandlerContext, this.inboundHandler) { // from class: io.netty.channel.CombinedChannelDuplexHandler.1
                @Override // io.netty.channel.CombinedChannelDuplexHandler.DelegatingChannelHandlerContext, io.netty.channel.ChannelHandlerContext
                public ChannelHandlerContext fireExceptionCaught(Throwable th) {
                    if (CombinedChannelDuplexHandler.this.outboundCtx.removed) {
                        super.fireExceptionCaught(th);
                        return this;
                    }
                    try {
                        CombinedChannelDuplexHandler.this.outboundHandler.exceptionCaught(CombinedChannelDuplexHandler.this.outboundCtx, th);
                        return this;
                    } catch (Throwable th2) {
                        if (CombinedChannelDuplexHandler.logger.isDebugEnabled()) {
                            CombinedChannelDuplexHandler.logger.debug("An exception {}was thrown by a user handler's exceptionCaught() method while handling the following exception:", ThrowableUtil.stackTraceToString(th2), th);
                        } else if (CombinedChannelDuplexHandler.logger.isWarnEnabled()) {
                            CombinedChannelDuplexHandler.logger.warn("An exception '{}' [enable DEBUG level for full stacktrace] was thrown by a user handler's exceptionCaught() method while handling the following exception:", th2, th);
                        }
                        return this;
                    }
                }
            };
            this.handlerAdded = true;
            try {
                this.inboundHandler.handlerAdded(this.inboundCtx);
                return;
            } finally {
                this.outboundHandler.handlerAdded(this.outboundCtx);
            }
        }
        throw new IllegalStateException("init() must be invoked before being added to a " + ChannelPipeline.class.getSimpleName() + " if " + CombinedChannelDuplexHandler.class.getSimpleName() + " was constructed with the default constructor.");
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        try {
            this.inboundCtx.remove();
        } finally {
            this.outboundCtx.remove();
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.read();
        } else {
            this.outboundHandler.read(delegatingChannelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.fireUserEventTriggered(obj);
        } else {
            this.inboundHandler.userEventTriggered(delegatingChannelHandlerContext, obj);
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (delegatingChannelHandlerContext.removed) {
            delegatingChannelHandlerContext.write(obj, channelPromise);
        } else {
            this.outboundHandler.write(delegatingChannelHandlerContext, obj, channelPromise);
        }
    }

    protected CombinedChannelDuplexHandler() {
        ensureNotSharable();
    }

    protected final void init(I i10, O o10) {
        validate(i10, o10);
        this.inboundHandler = i10;
        this.outboundHandler = o10;
    }
}
