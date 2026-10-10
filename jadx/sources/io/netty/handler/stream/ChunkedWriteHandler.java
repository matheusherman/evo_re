package io.netty.handler.stream;

import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelProgressivePromise;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChunkedWriteHandler extends ChannelDuplexHandler {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ChunkedWriteHandler.class);
    private volatile ChannelHandlerContext ctx;
    private final Queue<PendingWrite> queue = new ArrayDeque();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class PendingWrite {
        final Object msg;
        final ChannelPromise promise;

        void fail(Throwable th) {
            ReferenceCountUtil.release(this.msg);
            this.promise.tryFailure(th);
        }

        void progress(long j10, long j11) {
            ChannelPromise channelPromise = this.promise;
            if (channelPromise instanceof ChannelProgressivePromise) {
                ((ChannelProgressivePromise) channelPromise).tryProgress(j10, j11);
            }
        }

        void success(long j10) {
            if (this.promise.isDone()) {
                return;
            }
            progress(j10, j10);
            this.promise.trySuccess();
        }

        PendingWrite(Object obj, ChannelPromise channelPromise) {
            this.msg = obj;
            this.promise = channelPromise;
        }
    }

    private void discard(Throwable th) {
        while (true) {
            PendingWrite pendingWritePoll = this.queue.poll();
            if (pendingWritePoll == null) {
                return;
            }
            Object obj = pendingWritePoll.msg;
            if (obj instanceof ChunkedInput) {
                ChunkedInput chunkedInput = (ChunkedInput) obj;
                try {
                    boolean zIsEndOfInput = chunkedInput.isEndOfInput();
                    long length = chunkedInput.length();
                    closeInput(chunkedInput);
                    if (zIsEndOfInput) {
                        pendingWritePoll.success(length);
                    } else {
                        if (th == null) {
                            th = new ClosedChannelException();
                        }
                        pendingWritePoll.fail(th);
                    }
                } catch (Exception e10) {
                    closeInput(chunkedInput);
                    pendingWritePoll.fail(e10);
                    InternalLogger internalLogger = logger;
                    if (internalLogger.isWarnEnabled()) {
                        internalLogger.warn(ChunkedInput.class.getSimpleName() + " failed", (Throwable) e10);
                    }
                }
            } else {
                if (th == null) {
                    th = new ClosedChannelException();
                }
                pendingWritePoll.fail(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleEndOfInputFuture(ChannelFuture channelFuture, PendingWrite pendingWrite) {
        ChunkedInput chunkedInput = (ChunkedInput) pendingWrite.msg;
        if (!channelFuture.isSuccess()) {
            closeInput(chunkedInput);
            pendingWrite.fail(channelFuture.cause());
            return;
        }
        long jProgress = chunkedInput.progress();
        long length = chunkedInput.length();
        closeInput(chunkedInput);
        pendingWrite.progress(jProgress, length);
        pendingWrite.success(length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFuture(ChannelFuture channelFuture, PendingWrite pendingWrite, boolean z10) {
        ChunkedInput chunkedInput = (ChunkedInput) pendingWrite.msg;
        if (!channelFuture.isSuccess()) {
            closeInput(chunkedInput);
            pendingWrite.fail(channelFuture.cause());
            return;
        }
        pendingWrite.progress(chunkedInput.progress(), chunkedInput.length());
        if (z10 && channelFuture.channel().isWritable()) {
            resumeTransfer();
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        this.ctx = channelHandlerContext;
    }

    public void resumeTransfer() {
        final ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext == null) {
            return;
        }
        if (channelHandlerContext.executor().inEventLoop()) {
            resumeTransfer0(channelHandlerContext);
        } else {
            channelHandlerContext.executor().execute(new Runnable() { // from class: io.netty.handler.stream.ChunkedWriteHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    ChunkedWriteHandler.this.resumeTransfer0(channelHandlerContext);
                }
            });
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        this.queue.add(new PendingWrite(obj, channelPromise));
    }

    private static void closeInput(ChunkedInput<?> chunkedInput) {
        try {
            chunkedInput.close();
        } catch (Throwable th) {
            if (logger.isWarnEnabled()) {
                logger.warn("Failed to close a chunked input.", th);
            }
        }
    }

    private void doFlush(ChannelHandlerContext channelHandlerContext) {
        final PendingWrite pendingWritePeek;
        boolean z10;
        Channel channel = channelHandlerContext.channel();
        Object obj = null;
        if (!channel.isActive()) {
            discard(null);
            return;
        }
        ByteBufAllocator byteBufAllocatorAlloc = channelHandlerContext.alloc();
        boolean z11 = true;
        while (channel.isWritable() && (pendingWritePeek = this.queue.peek()) != null) {
            if (pendingWritePeek.promise.isDone()) {
                this.queue.remove();
            } else {
                Object obj2 = pendingWritePeek.msg;
                if (obj2 instanceof ChunkedInput) {
                    ChunkedInput chunkedInput = (ChunkedInput) obj2;
                    try {
                        Object chunk = chunkedInput.readChunk(byteBufAllocatorAlloc);
                        try {
                            boolean zIsEndOfInput = chunkedInput.isEndOfInput();
                            if (chunk == null) {
                                z10 = !zIsEndOfInput;
                            } else {
                                z10 = false;
                            }
                            if (z10) {
                                break;
                            }
                            if (chunk == null) {
                                chunk = Unpooled.EMPTY_BUFFER;
                            }
                            if (zIsEndOfInput) {
                                this.queue.remove();
                            }
                            ChannelFuture channelFutureWriteAndFlush = channelHandlerContext.writeAndFlush(chunk);
                            if (zIsEndOfInput) {
                                if (channelFutureWriteAndFlush.isDone()) {
                                    handleEndOfInputFuture(channelFutureWriteAndFlush, pendingWritePeek);
                                } else {
                                    channelFutureWriteAndFlush.addListener2((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.stream.ChunkedWriteHandler.2
                                        @Override // io.netty.util.concurrent.GenericFutureListener
                                        public void operationComplete(ChannelFuture channelFuture) {
                                            ChunkedWriteHandler.handleEndOfInputFuture(channelFuture, pendingWritePeek);
                                        }
                                    });
                                }
                            } else {
                                final boolean z12 = !channel.isWritable();
                                if (channelFutureWriteAndFlush.isDone()) {
                                    handleFuture(channelFutureWriteAndFlush, pendingWritePeek, z12);
                                } else {
                                    channelFutureWriteAndFlush.addListener2((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.stream.ChunkedWriteHandler.3
                                        @Override // io.netty.util.concurrent.GenericFutureListener
                                        public void operationComplete(ChannelFuture channelFuture) {
                                            ChunkedWriteHandler.this.handleFuture(channelFuture, pendingWritePeek, z12);
                                        }
                                    });
                                }
                            }
                            z11 = false;
                        } catch (Throwable th) {
                            th = th;
                            obj = chunk;
                            this.queue.remove();
                            if (obj != null) {
                                ReferenceCountUtil.release(obj);
                            }
                            closeInput(chunkedInput);
                            pendingWritePeek.fail(th);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    this.queue.remove();
                    channelHandlerContext.write(obj2, pendingWritePeek.promise);
                    z11 = true;
                }
                if (!channel.isActive()) {
                    discard(new ClosedChannelException());
                    break;
                }
            }
        }
        if (z11) {
            channelHandlerContext.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeTransfer0(ChannelHandlerContext channelHandlerContext) {
        try {
            doFlush(channelHandlerContext);
        } catch (Exception e10) {
            logger.warn("Unexpected exception while sending chunks.", (Throwable) e10);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        doFlush(channelHandlerContext);
        channelHandlerContext.fireChannelInactive();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.channel().isWritable()) {
            doFlush(channelHandlerContext);
        }
        channelHandlerContext.fireChannelWritabilityChanged();
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) {
        doFlush(channelHandlerContext);
    }
}
