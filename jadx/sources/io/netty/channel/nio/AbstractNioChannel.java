package io.netty.channel.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class AbstractNioChannel extends AbstractChannel {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractNioChannel.class);
    private final SelectableChannel ch;
    private final Runnable clearReadPendingRunnable;
    private ChannelPromise connectPromise;
    private Future<?> connectTimeoutFuture;
    protected final int readInterestOp;
    boolean readPending;
    private SocketAddress requestedRemoteAddress;
    volatile SelectionKey selectionKey;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    protected abstract class AbstractNioUnsafe extends AbstractChannel.AbstractUnsafe implements NioUnsafe {
        private void fulfillConnectPromise(ChannelPromise channelPromise, boolean z10) {
            if (channelPromise == null) {
                return;
            }
            boolean zIsActive = AbstractNioChannel.this.isActive();
            boolean zTrySuccess = channelPromise.trySuccess();
            if (!z10 && zIsActive) {
                AbstractNioChannel.this.pipeline().fireChannelActive();
            }
            if (zTrySuccess) {
                return;
            }
            close(voidPromise());
        }

        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public final void finishConnect() {
            try {
                boolean zIsActive = AbstractNioChannel.this.isActive();
                AbstractNioChannel.this.doFinishConnect();
                fulfillConnectPromise(AbstractNioChannel.this.connectPromise, zIsActive);
                if (AbstractNioChannel.this.connectTimeoutFuture != null) {
                }
            } catch (Throwable th) {
                try {
                    fulfillConnectPromise(AbstractNioChannel.this.connectPromise, annotateConnectException(th, AbstractNioChannel.this.requestedRemoteAddress));
                } finally {
                    if (AbstractNioChannel.this.connectTimeoutFuture != null) {
                        AbstractNioChannel.this.connectTimeoutFuture.cancel(false);
                    }
                    AbstractNioChannel.this.connectPromise = null;
                }
            }
        }

        protected AbstractNioUnsafe() {
            super();
        }

        private boolean isFlushPending() {
            SelectionKey selectionKey = AbstractNioChannel.this.selectionKey();
            return selectionKey.isValid() && (selectionKey.interestOps() & 4) != 0;
        }

        protected final void removeReadOp() {
            SelectionKey selectionKey = AbstractNioChannel.this.selectionKey();
            if (selectionKey.isValid()) {
                int iInterestOps = selectionKey.interestOps();
                int i10 = AbstractNioChannel.this.readInterestOp;
                if ((iInterestOps & i10) != 0) {
                    selectionKey.interestOps(iInterestOps & (~i10));
                }
            }
        }

        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe
        protected final void flush0() {
            if (!isFlushPending()) {
                super.flush0();
            }
        }

        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public final void forceFlush() {
            super.flush0();
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise, Throwable th) {
            if (channelPromise == null) {
                return;
            }
            channelPromise.tryFailure(th);
            closeIfClosed();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface NioUnsafe extends Channel.Unsafe {
        void finishConnect();

        void forceFlush();

        void read();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReadPending0() {
        this.readPending = false;
        ((AbstractNioUnsafe) unsafe()).removeReadOp();
    }

    protected abstract void doFinishConnect();

    @Override // io.netty.channel.AbstractChannel
    protected void doRegister() {
        boolean z10 = false;
        while (true) {
            try {
                this.selectionKey = javaChannel().register(eventLoop().unwrappedSelector(), 0, this);
                return;
            } catch (CancelledKeyException e10) {
                if (z10) {
                    throw e10;
                }
                eventLoop().selectNow();
                z10 = true;
            }
        }
    }

    protected final ByteBuf newDirectBuffer(ByteBuf byteBuf) {
        int i10 = byteBuf.readableBytes();
        if (i10 == 0) {
            ReferenceCountUtil.safeRelease(byteBuf);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator byteBufAllocatorAlloc = alloc();
        if (byteBufAllocatorAlloc.isDirectBufferPooled()) {
            ByteBuf byteBufDirectBuffer = byteBufAllocatorAlloc.directBuffer(i10);
            byteBufDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i10);
            ReferenceCountUtil.safeRelease(byteBuf);
            return byteBufDirectBuffer;
        }
        ByteBuf byteBufThreadLocalDirectBuffer = ByteBufUtil.threadLocalDirectBuffer();
        if (byteBufThreadLocalDirectBuffer == null) {
            return byteBuf;
        }
        byteBufThreadLocalDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i10);
        ReferenceCountUtil.safeRelease(byteBuf);
        return byteBufThreadLocalDirectBuffer;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBeginRead() {
        SelectionKey selectionKey = this.selectionKey;
        if (selectionKey.isValid()) {
            this.readPending = true;
            int iInterestOps = selectionKey.interestOps();
            int i10 = this.readInterestOp;
            if ((iInterestOps & i10) == 0) {
                selectionKey.interestOps(iInterestOps | i10);
            }
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doClose() {
        ChannelPromise channelPromise = this.connectPromise;
        if (channelPromise != null) {
            channelPromise.tryFailure(new ClosedChannelException());
            this.connectPromise = null;
        }
        Future<?> future = this.connectTimeoutFuture;
        if (future != null) {
            future.cancel(false);
            this.connectTimeoutFuture = null;
        }
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public NioEventLoop eventLoop() {
        return (NioEventLoop) super.eventLoop();
    }

    @Override // io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof NioEventLoop;
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return this.ch.isOpen();
    }

    protected SelectableChannel javaChannel() {
        return this.ch;
    }

    protected SelectionKey selectionKey() {
        return this.selectionKey;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public NioUnsafe unsafe() {
        return (NioUnsafe) super.unsafe();
    }

    protected AbstractNioChannel(Channel channel, SelectableChannel selectableChannel, int i10) {
        super(channel);
        this.clearReadPendingRunnable = new Runnable() { // from class: io.netty.channel.nio.AbstractNioChannel.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractNioChannel.this.clearReadPending0();
            }
        };
        this.ch = selectableChannel;
        this.readInterestOp = i10;
        try {
            selectableChannel.configureBlocking(false);
        } catch (IOException e10) {
            try {
                selectableChannel.close();
            } catch (IOException e11) {
                logger.warn("Failed to close a partially initialized socket.", (Throwable) e11);
            }
            throw new ChannelException("Failed to enter non-blocking mode.", e10);
        }
    }

    protected final void clearReadPending() {
        if (isRegistered()) {
            NioEventLoop nioEventLoopEventLoop = eventLoop();
            if (nioEventLoopEventLoop.inEventLoop()) {
                clearReadPending0();
                return;
            } else {
                nioEventLoopEventLoop.execute(this.clearReadPendingRunnable);
                return;
            }
        }
        this.readPending = false;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDeregister() {
        eventLoop().cancel(selectionKey());
    }

    protected final ByteBuf newDirectBuffer(ReferenceCounted referenceCounted, ByteBuf byteBuf) {
        int i10 = byteBuf.readableBytes();
        if (i10 == 0) {
            ReferenceCountUtil.safeRelease(referenceCounted);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator byteBufAllocatorAlloc = alloc();
        if (byteBufAllocatorAlloc.isDirectBufferPooled()) {
            ByteBuf byteBufDirectBuffer = byteBufAllocatorAlloc.directBuffer(i10);
            byteBufDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i10);
            ReferenceCountUtil.safeRelease(referenceCounted);
            return byteBufDirectBuffer;
        }
        ByteBuf byteBufThreadLocalDirectBuffer = ByteBufUtil.threadLocalDirectBuffer();
        if (byteBufThreadLocalDirectBuffer != null) {
            byteBufThreadLocalDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i10);
            ReferenceCountUtil.safeRelease(referenceCounted);
            return byteBufThreadLocalDirectBuffer;
        }
        if (referenceCounted != byteBuf) {
            byteBuf.retain();
            ReferenceCountUtil.safeRelease(referenceCounted);
        }
        return byteBuf;
    }
}
