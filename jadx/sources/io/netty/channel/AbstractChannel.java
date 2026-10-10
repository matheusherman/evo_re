package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.socket.ChannelOutputShutdownEvent;
import io.netty.channel.socket.ChannelOutputShutdownException;
import io.netty.util.DefaultAttributeMap;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class AbstractChannel extends DefaultAttributeMap implements Channel {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractChannel.class);
    private final CloseFuture closeFuture;
    private boolean closeInitiated;
    private volatile EventLoop eventLoop;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final ChannelId f11360id;
    private Throwable initialCloseCause;
    private volatile SocketAddress localAddress;
    private final Channel parent;
    private final DefaultChannelPipeline pipeline;
    private volatile boolean registered;
    private volatile SocketAddress remoteAddress;
    private String strVal;
    private boolean strValActive;
    private final Channel.Unsafe unsafe;
    private final VoidChannelPromise unsafeVoidPromise;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public abstract class AbstractUnsafe implements Channel.Unsafe {
        private boolean inFlush0;
        private boolean neverRegistered = true;
        private volatile ChannelOutboundBuffer outboundBuffer;
        private RecvByteBufAllocator.Handle recvHandle;

        private void closeOutboundBufferForShutdown(ChannelPipeline channelPipeline, ChannelOutboundBuffer channelOutboundBuffer, Throwable th) {
            channelOutboundBuffer.failFlushed(th, false);
            channelOutboundBuffer.close(th, true);
            channelPipeline.fireUserEventTriggered(ChannelOutputShutdownEvent.INSTANCE);
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void close(ChannelPromise channelPromise) {
            assertEventLoop();
            ClosedChannelException closedChannelExceptionNewInstance = StacklessClosedChannelException.newInstance(AbstractChannel.class, "close(ChannelPromise)");
            close(channelPromise, closedChannelExceptionNewInstance, closedChannelExceptionNewInstance, false);
        }

        protected Executor prepareToClose() {
            return null;
        }

        protected AbstractUnsafe() {
            this.outboundBuffer = new ChannelOutboundBuffer(AbstractChannel.this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doClose0(ChannelPromise channelPromise) {
            try {
                AbstractChannel.this.doClose();
                AbstractChannel.this.closeFuture.setClosed();
                safeSetSuccess(channelPromise);
            } catch (Throwable th) {
                AbstractChannel.this.closeFuture.setClosed();
                safeSetFailure(channelPromise, th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void invokeLater(Runnable runnable) {
            try {
                AbstractChannel.this.eventLoop().execute(runnable);
            } catch (RejectedExecutionException e10) {
                AbstractChannel.logger.warn("Can't invoke task later as EventLoop rejected it", (Throwable) e10);
            }
        }

        private ClosedChannelException newClosedChannelException(Throwable th, String str) {
            StacklessClosedChannelException stacklessClosedChannelExceptionNewInstance = StacklessClosedChannelException.newInstance(AbstractUnsafe.class, str);
            if (th != null) {
                stacklessClosedChannelExceptionNewInstance.initCause(th);
            }
            return stacklessClosedChannelExceptionNewInstance;
        }

        protected final Throwable annotateConnectException(Throwable th, SocketAddress socketAddress) {
            if (th instanceof ConnectException) {
                return new AnnotatedConnectException((ConnectException) th, socketAddress);
            }
            if (th instanceof NoRouteToHostException) {
                return new AnnotatedNoRouteToHostException((NoRouteToHostException) th, socketAddress);
            }
            return th instanceof SocketException ? new AnnotatedSocketException((SocketException) th, socketAddress) : th;
        }

        protected final void closeIfClosed() {
            if (AbstractChannel.this.isOpen()) {
                return;
            }
            close(voidPromise());
        }

        protected final boolean ensureOpen(ChannelPromise channelPromise) {
            if (AbstractChannel.this.isOpen()) {
                return true;
            }
            safeSetFailure(channelPromise, newClosedChannelException(AbstractChannel.this.initialCloseCause, "ensureOpen(ChannelPromise)"));
            return false;
        }

        protected void flush0() {
            ChannelOutboundBuffer channelOutboundBuffer;
            if (this.inFlush0 || (channelOutboundBuffer = this.outboundBuffer) == null || channelOutboundBuffer.isEmpty()) {
                return;
            }
            this.inFlush0 = true;
            if (!AbstractChannel.this.isActive()) {
                try {
                    if (!channelOutboundBuffer.isEmpty()) {
                        if (AbstractChannel.this.isOpen()) {
                            channelOutboundBuffer.failFlushed(new NotYetConnectedException(), true);
                        } else {
                            channelOutboundBuffer.failFlushed(newClosedChannelException(AbstractChannel.this.initialCloseCause, "flush0()"), false);
                        }
                    }
                    return;
                } finally {
                    this.inFlush0 = false;
                }
            }
            try {
                AbstractChannel.this.doWrite(channelOutboundBuffer);
                this.inFlush0 = false;
            } catch (Throwable th) {
                try {
                    handleWriteError(th);
                } finally {
                    this.inFlush0 = false;
                }
            }
        }

        protected final void handleWriteError(Throwable th) {
            if ((th instanceof IOException) && AbstractChannel.this.config().isAutoClose()) {
                AbstractChannel.this.initialCloseCause = th;
                close(voidPromise(), th, newClosedChannelException(th, "flush0()"), false);
                return;
            }
            try {
                shutdownOutput(voidPromise(), th);
            } catch (Throwable th2) {
                AbstractChannel.this.initialCloseCause = th;
                close(voidPromise(), th2, newClosedChannelException(th, "flush0()"), false);
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final SocketAddress localAddress() {
            return AbstractChannel.this.localAddress0();
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final ChannelOutboundBuffer outboundBuffer() {
            return this.outboundBuffer;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public RecvByteBufAllocator.Handle recvBufAllocHandle() {
            if (this.recvHandle == null) {
                this.recvHandle = AbstractChannel.this.config().getRecvByteBufAllocator().newHandle();
            }
            return this.recvHandle;
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void register(EventLoop eventLoop, final ChannelPromise channelPromise) {
            ObjectUtil.checkNotNull(eventLoop, "eventLoop");
            if (AbstractChannel.this.isRegistered()) {
                channelPromise.setFailure(new IllegalStateException("registered to an event loop already"));
                return;
            }
            if (!AbstractChannel.this.isCompatible(eventLoop)) {
                channelPromise.setFailure(new IllegalStateException("incompatible event loop type: " + eventLoop.getClass().getName()));
                return;
            }
            AbstractChannel.this.eventLoop = eventLoop;
            if (eventLoop.inEventLoop()) {
                register0(channelPromise);
                return;
            }
            try {
                eventLoop.execute(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractUnsafe.this.register0(channelPromise);
                    }
                });
            } catch (Throwable th) {
                AbstractChannel.logger.warn("Force-closing a channel whose registration task was not accepted by an event loop: {}", AbstractChannel.this, th);
                closeForcibly();
                AbstractChannel.this.closeFuture.setClosed();
                safeSetFailure(channelPromise, th);
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final SocketAddress remoteAddress() {
            return AbstractChannel.this.remoteAddress0();
        }

        protected final void safeSetFailure(ChannelPromise channelPromise, Throwable th) {
            if ((channelPromise instanceof VoidChannelPromise) || channelPromise.tryFailure(th)) {
                return;
            }
            AbstractChannel.logger.warn("Failed to mark a promise as failure because it's done already: {}", channelPromise, th);
        }

        protected final void safeSetSuccess(ChannelPromise channelPromise) {
            if ((channelPromise instanceof VoidChannelPromise) || channelPromise.trySuccess()) {
                return;
            }
            AbstractChannel.logger.warn("Failed to mark a promise as success because it is done already: {}", channelPromise);
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void write(Object obj, ChannelPromise channelPromise) {
            assertEventLoop();
            ChannelOutboundBuffer channelOutboundBuffer = this.outboundBuffer;
            if (channelOutboundBuffer == null) {
                try {
                    ReferenceCountUtil.release(obj);
                    return;
                } finally {
                    safeSetFailure(channelPromise, newClosedChannelException(AbstractChannel.this.initialCloseCause, "write(Object, ChannelPromise)"));
                }
            }
            try {
                obj = AbstractChannel.this.filterOutboundMessage(obj);
                int size = AbstractChannel.this.pipeline.estimatorHandle().size(obj);
                if (size < 0) {
                    size = 0;
                }
                channelOutboundBuffer.addMessage(obj, size, channelPromise);
            } catch (Throwable th) {
                try {
                    ReferenceCountUtil.release(obj);
                } finally {
                    safeSetFailure(channelPromise, th);
                }
            }
        }

        private void deregister(final ChannelPromise channelPromise, final boolean z10) {
            if (!channelPromise.setUncancellable()) {
                return;
            }
            if (!AbstractChannel.this.registered) {
                safeSetSuccess(channelPromise);
            } else {
                invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.7
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AbstractChannel.this.doDeregister();
                            if (z10) {
                                AbstractChannel.this.pipeline.fireChannelInactive();
                            }
                            if (AbstractChannel.this.registered) {
                            }
                        } catch (Throwable th) {
                            try {
                                AbstractChannel.logger.warn("Unexpected exception occurred while deregistering a channel.", th);
                            } finally {
                                if (z10) {
                                    AbstractChannel.this.pipeline.fireChannelInactive();
                                }
                                if (AbstractChannel.this.registered) {
                                    AbstractChannel.this.registered = false;
                                    AbstractChannel.this.pipeline.fireChannelUnregistered();
                                }
                                AbstractUnsafe.this.safeSetSuccess(channelPromise);
                            }
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fireChannelInactiveAndDeregister(boolean z10) {
            boolean z11;
            ChannelPromise channelPromiseVoidPromise = voidPromise();
            if (z10 && !AbstractChannel.this.isActive()) {
                z11 = true;
            } else {
                z11 = false;
            }
            deregister(channelPromiseVoidPromise, z11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void register0(ChannelPromise channelPromise) {
            try {
                if (channelPromise.setUncancellable() && ensureOpen(channelPromise)) {
                    boolean z10 = this.neverRegistered;
                    AbstractChannel.this.doRegister();
                    this.neverRegistered = false;
                    AbstractChannel.this.registered = true;
                    AbstractChannel.this.pipeline.invokeHandlerAddedIfNeeded();
                    safeSetSuccess(channelPromise);
                    AbstractChannel.this.pipeline.fireChannelRegistered();
                    if (AbstractChannel.this.isActive()) {
                        if (z10) {
                            AbstractChannel.this.pipeline.fireChannelActive();
                        } else if (AbstractChannel.this.config().isAutoRead()) {
                            beginRead();
                        }
                    }
                }
            } catch (Throwable th) {
                closeForcibly();
                AbstractChannel.this.closeFuture.setClosed();
                safeSetFailure(channelPromise, th);
            }
        }

        private void shutdownOutput(ChannelPromise channelPromise, Throwable th) {
            ChannelOutputShutdownException channelOutputShutdownException;
            if (!channelPromise.setUncancellable()) {
                return;
            }
            ChannelOutboundBuffer channelOutboundBuffer = this.outboundBuffer;
            if (channelOutboundBuffer == null) {
                channelPromise.setFailure(new ClosedChannelException());
                return;
            }
            this.outboundBuffer = null;
            if (th == null) {
                channelOutputShutdownException = new ChannelOutputShutdownException("Channel output shutdown");
            } else {
                channelOutputShutdownException = new ChannelOutputShutdownException("Channel output shutdown", th);
            }
            try {
                AbstractChannel.this.doShutdownOutput();
                channelPromise.setSuccess();
                closeOutboundBufferForShutdown(AbstractChannel.this.pipeline, channelOutboundBuffer, channelOutputShutdownException);
            } catch (Throwable th2) {
                try {
                    channelPromise.setFailure(th2);
                } finally {
                    closeOutboundBufferForShutdown(AbstractChannel.this.pipeline, channelOutboundBuffer, channelOutputShutdownException);
                }
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void beginRead() {
            assertEventLoop();
            try {
                AbstractChannel.this.doBeginRead();
            } catch (Exception e10) {
                invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.8
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractChannel.this.pipeline.fireExceptionCaught(e10);
                    }
                });
                close(voidPromise());
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
            assertEventLoop();
            if (channelPromise.setUncancellable() && ensureOpen(channelPromise)) {
                if (Boolean.TRUE.equals(AbstractChannel.this.config().getOption(ChannelOption.SO_BROADCAST)) && (socketAddress instanceof InetSocketAddress) && !((InetSocketAddress) socketAddress).getAddress().isAnyLocalAddress() && !PlatformDependent.isWindows() && !PlatformDependent.maybeSuperUser()) {
                    AbstractChannel.logger.warn("A non-root user can't receive a broadcast packet if the socket is not bound to a wildcard address; binding to a non-wildcard address (" + socketAddress + ") anyway as requested.");
                }
                boolean zIsActive = AbstractChannel.this.isActive();
                try {
                    AbstractChannel.this.doBind(socketAddress);
                    if (!zIsActive && AbstractChannel.this.isActive()) {
                        invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AbstractChannel.this.pipeline.fireChannelActive();
                            }
                        });
                    }
                    safeSetSuccess(channelPromise);
                } catch (Throwable th) {
                    safeSetFailure(channelPromise, th);
                    closeIfClosed();
                }
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void closeForcibly() {
            assertEventLoop();
            try {
                AbstractChannel.this.doClose();
            } catch (Exception e10) {
                AbstractChannel.logger.warn("Failed to close a channel.", (Throwable) e10);
            }
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final void flush() {
            assertEventLoop();
            ChannelOutboundBuffer channelOutboundBuffer = this.outboundBuffer;
            if (channelOutboundBuffer == null) {
                return;
            }
            channelOutboundBuffer.addFlush();
            flush0();
        }

        @Override // io.netty.channel.Channel.Unsafe
        public final ChannelPromise voidPromise() {
            assertEventLoop();
            return AbstractChannel.this.unsafeVoidPromise;
        }

        private void close(final ChannelPromise channelPromise, final Throwable th, final ClosedChannelException closedChannelException, final boolean z10) {
            if (channelPromise.setUncancellable()) {
                if (AbstractChannel.this.closeInitiated) {
                    if (AbstractChannel.this.closeFuture.isDone()) {
                        safeSetSuccess(channelPromise);
                        return;
                    } else {
                        if (channelPromise instanceof VoidChannelPromise) {
                            return;
                        }
                        AbstractChannel.this.closeFuture.addListener2((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.4
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(ChannelFuture channelFuture) {
                                channelPromise.setSuccess();
                            }
                        });
                        return;
                    }
                }
                AbstractChannel.this.closeInitiated = true;
                final boolean zIsActive = AbstractChannel.this.isActive();
                final ChannelOutboundBuffer channelOutboundBuffer = this.outboundBuffer;
                this.outboundBuffer = null;
                Executor executorPrepareToClose = prepareToClose();
                if (executorPrepareToClose != null) {
                    executorPrepareToClose.execute(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.5
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AbstractUnsafe.this.doClose0(channelPromise);
                            } finally {
                                AbstractUnsafe.this.invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                        ChannelOutboundBuffer channelOutboundBuffer2 = channelOutboundBuffer;
                                        if (channelOutboundBuffer2 != null) {
                                            channelOutboundBuffer2.failFlushed(th, z10);
                                            AnonymousClass5 anonymousClass6 = AnonymousClass5.this;
                                            channelOutboundBuffer.close(closedChannelException);
                                        }
                                        AnonymousClass5 anonymousClass7 = AnonymousClass5.this;
                                        AbstractUnsafe.this.fireChannelInactiveAndDeregister(zIsActive);
                                    }
                                });
                            }
                        }
                    });
                    return;
                }
                try {
                    doClose0(channelPromise);
                    if (channelOutboundBuffer != null) {
                        channelOutboundBuffer.failFlushed(th, z10);
                        channelOutboundBuffer.close(closedChannelException);
                    }
                    if (this.inFlush0) {
                        invokeLater(new Runnable() { // from class: io.netty.channel.AbstractChannel.AbstractUnsafe.6
                            @Override // java.lang.Runnable
                            public void run() {
                                AbstractUnsafe.this.fireChannelInactiveAndDeregister(zIsActive);
                            }
                        });
                    } else {
                        fireChannelInactiveAndDeregister(zIsActive);
                    }
                } catch (Throwable th2) {
                    if (channelOutboundBuffer != null) {
                        channelOutboundBuffer.failFlushed(th, z10);
                        channelOutboundBuffer.close(closedChannelException);
                        throw th2;
                    }
                    throw th2;
                }
            }
        }

        private void assertEventLoop() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class AnnotatedConnectException extends ConnectException {
        private static final long serialVersionUID = 3901958112696433556L;

        AnnotatedConnectException(ConnectException connectException, SocketAddress socketAddress) {
            super(connectException.getMessage() + ": " + socketAddress);
            initCause(connectException);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class AnnotatedNoRouteToHostException extends NoRouteToHostException {
        private static final long serialVersionUID = -6801433937592080623L;

        AnnotatedNoRouteToHostException(NoRouteToHostException noRouteToHostException, SocketAddress socketAddress) {
            super(noRouteToHostException.getMessage() + ": " + socketAddress);
            initCause(noRouteToHostException);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class AnnotatedSocketException extends SocketException {
        private static final long serialVersionUID = 3896743275010454039L;

        AnnotatedSocketException(SocketException socketException, SocketAddress socketAddress) {
            super(socketException.getMessage() + ": " + socketAddress);
            initCause(socketException);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class CloseFuture extends DefaultChannelPromise {
        @Override // io.netty.channel.DefaultChannelPromise, io.netty.util.concurrent.DefaultPromise, io.netty.channel.ChannelPromise
        public ChannelPromise setFailure(Throwable th) {
            throw new IllegalStateException();
        }

        @Override // io.netty.channel.DefaultChannelPromise, io.netty.channel.ChannelPromise
        public ChannelPromise setSuccess() {
            throw new IllegalStateException();
        }

        @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
        public boolean tryFailure(Throwable th) {
            throw new IllegalStateException();
        }

        @Override // io.netty.channel.DefaultChannelPromise, io.netty.channel.ChannelPromise
        public boolean trySuccess() {
            throw new IllegalStateException();
        }

        CloseFuture(AbstractChannel abstractChannel) {
            super(abstractChannel);
        }

        boolean setClosed() {
            return super.trySuccess();
        }
    }

    protected AbstractChannel(Channel channel) {
        this.unsafeVoidPromise = new VoidChannelPromise(this, false);
        this.closeFuture = new CloseFuture(this);
        this.parent = channel;
        this.f11360id = newId();
        this.unsafe = newUnsafe();
        this.pipeline = newChannelPipeline();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close() {
        return this.pipeline.close();
    }

    protected abstract void doBeginRead();

    protected abstract void doBind(SocketAddress socketAddress);

    protected abstract void doClose();

    protected abstract void doWrite(ChannelOutboundBuffer channelOutboundBuffer);

    protected abstract boolean isCompatible(EventLoop eventLoop);

    protected abstract SocketAddress localAddress0();

    protected abstract AbstractUnsafe newUnsafe();

    protected abstract SocketAddress remoteAddress0();

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return this.pipeline.bind(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close(ChannelPromise channelPromise) {
        return this.pipeline.close(channelPromise);
    }

    @Override // io.netty.channel.Channel
    public ChannelFuture closeFuture() {
        return this.closeFuture;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Channel channel) {
        if (this == channel) {
            return 0;
        }
        return id().compareTo(channel.id());
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    @Override // io.netty.channel.Channel
    public EventLoop eventLoop() {
        EventLoop eventLoop = this.eventLoop;
        if (eventLoop != null) {
            return eventLoop;
        }
        throw new IllegalStateException("channel not registered to an event loop");
    }

    public Channel flush() {
        this.pipeline.flush();
        return this;
    }

    public final int hashCode() {
        return this.f11360id.hashCode();
    }

    @Override // io.netty.channel.Channel
    public final ChannelId id() {
        return this.f11360id;
    }

    @Override // io.netty.channel.Channel
    public boolean isRegistered() {
        return this.registered;
    }

    @Override // io.netty.channel.Channel
    public boolean isWritable() {
        ChannelOutboundBuffer channelOutboundBufferOutboundBuffer = this.unsafe.outboundBuffer();
        return channelOutboundBufferOutboundBuffer != null && channelOutboundBufferOutboundBuffer.isWritable();
    }

    public SocketAddress localAddress() {
        SocketAddress socketAddress = this.localAddress;
        if (socketAddress != null) {
            return socketAddress;
        }
        try {
            SocketAddress socketAddressLocalAddress = unsafe().localAddress();
            this.localAddress = socketAddressLocalAddress;
            return socketAddressLocalAddress;
        } catch (Error e10) {
            throw e10;
        } catch (Throwable unused) {
            return null;
        }
    }

    protected DefaultChannelPipeline newChannelPipeline() {
        return new DefaultChannelPipeline(this);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise newPromise() {
        return this.pipeline.newPromise();
    }

    @Override // io.netty.channel.Channel
    public ChannelPipeline pipeline() {
        return this.pipeline;
    }

    @Override // io.netty.channel.Channel
    public Channel read() {
        this.pipeline.read();
        return this;
    }

    public SocketAddress remoteAddress() {
        SocketAddress socketAddress = this.remoteAddress;
        if (socketAddress != null) {
            return socketAddress;
        }
        try {
            SocketAddress socketAddressRemoteAddress = unsafe().remoteAddress();
            this.remoteAddress = socketAddressRemoteAddress;
            return socketAddressRemoteAddress;
        } catch (Error e10) {
            throw e10;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // io.netty.channel.Channel
    public Channel.Unsafe unsafe() {
        return this.unsafe;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public final ChannelPromise voidPromise() {
        return this.pipeline.voidPromise();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object obj) {
        return this.pipeline.write(obj);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object obj) {
        return this.pipeline.writeAndFlush(obj);
    }

    public ByteBufAllocator alloc() {
        return config().getAllocator();
    }

    protected void doShutdownOutput() {
        doClose();
    }

    protected final int maxMessagesPerWrite() {
        ChannelConfig channelConfigConfig = config();
        if (channelConfigConfig instanceof DefaultChannelConfig) {
            return ((DefaultChannelConfig) channelConfigConfig).getMaxMessagesPerWrite();
        }
        Integer num = (Integer) channelConfigConfig.getOption(ChannelOption.MAX_MESSAGES_PER_WRITE);
        if (num == null) {
            return Integer.MAX_VALUE;
        }
        return num.intValue();
    }

    protected ChannelId newId() {
        return DefaultChannelId.newInstance();
    }

    public String toString() {
        String str;
        String str2;
        boolean zIsActive = isActive();
        if (this.strValActive == zIsActive && (str2 = this.strVal) != null) {
            return str2;
        }
        SocketAddress socketAddressRemoteAddress = remoteAddress();
        SocketAddress socketAddressLocalAddress = localAddress();
        if (socketAddressRemoteAddress != null) {
            StringBuilder sb2 = new StringBuilder(96);
            sb2.append("[id: 0x");
            sb2.append(this.f11360id.asShortText());
            sb2.append(", L:");
            sb2.append(socketAddressLocalAddress);
            if (zIsActive) {
                str = " - ";
            } else {
                str = " ! ";
            }
            sb2.append(str);
            sb2.append("R:");
            sb2.append(socketAddressRemoteAddress);
            sb2.append(']');
            this.strVal = sb2.toString();
        } else if (socketAddressLocalAddress != null) {
            StringBuilder sb3 = new StringBuilder(64);
            sb3.append("[id: 0x");
            sb3.append(this.f11360id.asShortText());
            sb3.append(", L:");
            sb3.append(socketAddressLocalAddress);
            sb3.append(']');
            this.strVal = sb3.toString();
        } else {
            StringBuilder sb4 = new StringBuilder(16);
            sb4.append("[id: 0x");
            sb4.append(this.f11360id.asShortText());
            sb4.append(']');
            this.strVal = sb4.toString();
        }
        this.strValActive = zIsActive;
        return this.strVal;
    }

    protected AbstractChannel(Channel channel, ChannelId channelId) {
        this.unsafeVoidPromise = new VoidChannelPromise(this, false);
        this.closeFuture = new CloseFuture(this);
        this.parent = channel;
        this.f11360id = channelId;
        this.unsafe = newUnsafe();
        this.pipeline = newChannelPipeline();
    }

    protected void doDeregister() {
    }

    protected void doRegister() {
    }

    protected Object filterOutboundMessage(Object obj) {
        return obj;
    }
}
