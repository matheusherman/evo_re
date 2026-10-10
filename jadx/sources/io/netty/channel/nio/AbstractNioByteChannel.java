package io.netty.channel.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class AbstractNioByteChannel extends AbstractNioChannel {
    private final Runnable flushTask;
    private boolean inputClosedSeenErrorOnRead;
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) FileRegion.class) + ')';

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public class NioByteUnsafe extends AbstractNioChannel.AbstractNioUnsafe {
        protected NioByteUnsafe() {
            super();
        }

        private void closeOnRead(ChannelPipeline channelPipeline) {
            if (AbstractNioByteChannel.this.isInputShutdown0()) {
                AbstractNioByteChannel.this.inputClosedSeenErrorOnRead = true;
                channelPipeline.fireUserEventTriggered(ChannelInputShutdownReadComplete.INSTANCE);
            } else if (!AbstractNioByteChannel.isAllowHalfClosure(AbstractNioByteChannel.this.config())) {
                close(voidPromise());
            } else {
                AbstractNioByteChannel.this.shutdownInput();
                channelPipeline.fireUserEventTriggered(ChannelInputShutdownEvent.INSTANCE);
            }
        }

        private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z10, RecvByteBufAllocator.Handle handle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    AbstractNioByteChannel.this.readPending = false;
                    channelPipeline.fireChannelRead(byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            handle.readComplete();
            channelPipeline.fireChannelReadComplete();
            channelPipeline.fireExceptionCaught(th);
            if (z10 || (th instanceof OutOfMemoryError) || (th instanceof IOException)) {
                closeOnRead(channelPipeline);
            }
        }

        /* JADX WARN: Code duplicated, block: B:46:0x009a A[DONT_GENERATE] */
        /* JADX WARN: Code duplicated, block: B:48:0x00a0 A[DONT_GENERATE] */
        /* JADX WARN: Code duplicated, block: B:70:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:71:? A[RETURN, SYNTHETIC] */
        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public final void read() {
            boolean z10;
            ByteBuf byteBuf;
            boolean z11;
            Throwable th;
            ChannelConfig channelConfigConfig = AbstractNioByteChannel.this.config();
            if (AbstractNioByteChannel.this.shouldBreakReadReady(channelConfigConfig)) {
                AbstractNioByteChannel.this.clearReadPending();
                return;
            }
            ChannelPipeline channelPipelinePipeline = AbstractNioByteChannel.this.pipeline();
            ByteBufAllocator allocator = channelConfigConfig.getAllocator();
            RecvByteBufAllocator.Handle handleRecvBufAllocHandle = recvBufAllocHandle();
            handleRecvBufAllocHandle.reset(channelConfigConfig);
            do {
                z10 = false;
                byteBuf = null;
                try {
                    ByteBuf byteBufAllocate = handleRecvBufAllocHandle.allocate(allocator);
                    try {
                        handleRecvBufAllocHandle.lastBytesRead(AbstractNioByteChannel.this.doReadBytes(byteBufAllocate));
                        if (handleRecvBufAllocHandle.lastBytesRead() <= 0) {
                            byteBufAllocate.release();
                            boolean z12 = handleRecvBufAllocHandle.lastBytesRead() < 0;
                            if (z12) {
                                try {
                                    AbstractNioByteChannel.this.readPending = false;
                                } catch (Throwable th2) {
                                    this = this;
                                    th = th2;
                                    z11 = z12;
                                    try {
                                        this.handleReadException(channelPipelinePipeline, byteBuf, th, z11, handleRecvBufAllocHandle);
                                    } finally {
                                        if (!AbstractNioByteChannel.this.readPending && !channelConfigConfig.isAutoRead()) {
                                            removeReadOp();
                                        }
                                    }
                                }
                            }
                            z10 = z12;
                            break;
                        }
                        handleRecvBufAllocHandle.incMessagesRead(1);
                        AbstractNioByteChannel.this.readPending = false;
                        channelPipelinePipeline.fireChannelRead(byteBufAllocate);
                    } catch (Throwable th3) {
                        th = th3;
                        byteBuf = byteBufAllocate;
                        z11 = false;
                        th = th;
                        this.handleReadException(channelPipelinePipeline, byteBuf, th, z11, handleRecvBufAllocHandle);
                    }
                } catch (Throwable th4) {
                    th = th4;
                    z11 = false;
                }
            } while (handleRecvBufAllocHandle.continueReading());
            try {
                handleRecvBufAllocHandle.readComplete();
                channelPipelinePipeline.fireChannelReadComplete();
                if (z10) {
                    closeOnRead(channelPipelinePipeline);
                }
                if (AbstractNioByteChannel.this.readPending || channelConfigConfig.isAutoRead()) {
                    return;
                }
                removeReadOp();
            } catch (Throwable th5) {
                th = th5;
                z11 = z10;
                this = this;
                this.handleReadException(channelPipelinePipeline, byteBuf, th, z11, handleRecvBufAllocHandle);
            }
        }
    }

    protected AbstractNioByteChannel(Channel channel, SelectableChannel selectableChannel) {
        super(channel, selectableChannel, 1);
        this.flushTask = new Runnable() { // from class: io.netty.channel.nio.AbstractNioByteChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractNioChannel.AbstractNioUnsafe) AbstractNioByteChannel.this.unsafe()).flush0();
            }
        };
    }

    protected abstract int doReadBytes(ByteBuf byteBuf);

    protected abstract int doWriteBytes(ByteBuf byteBuf);

    protected abstract long doWriteFileRegion(FileRegion fileRegion);

    protected abstract boolean isInputShutdown0();

    protected abstract ChannelFuture shutdownInput();

    private int doWriteInternal(ChannelOutboundBuffer channelOutboundBuffer, Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            if (!byteBuf.isReadable()) {
                channelOutboundBuffer.remove();
                return 0;
            }
            int iDoWriteBytes = doWriteBytes(byteBuf);
            if (iDoWriteBytes <= 0) {
                return Integer.MAX_VALUE;
            }
            channelOutboundBuffer.progress(iDoWriteBytes);
            if (!byteBuf.isReadable()) {
                channelOutboundBuffer.remove();
            }
            return 1;
        }
        if (!(obj instanceof FileRegion)) {
            throw new Error();
        }
        FileRegion fileRegion = (FileRegion) obj;
        if (fileRegion.transferred() >= fileRegion.count()) {
            channelOutboundBuffer.remove();
            return 0;
        }
        long jDoWriteFileRegion = doWriteFileRegion(fileRegion);
        if (jDoWriteFileRegion <= 0) {
            return Integer.MAX_VALUE;
        }
        channelOutboundBuffer.progress(jDoWriteFileRegion);
        if (fileRegion.transferred() >= fileRegion.count()) {
            channelOutboundBuffer.remove();
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAllowHalfClosure(ChannelConfig channelConfig) {
        return (channelConfig instanceof SocketChannelConfig) && ((SocketChannelConfig) channelConfig).isAllowHalfClosure();
    }

    @Override // io.netty.channel.AbstractChannel
    protected final Object filterOutboundMessage(Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return byteBuf.isDirect() ? obj : newDirectBuffer(byteBuf);
        }
        if (obj instanceof FileRegion) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    protected final void incompleteWrite(boolean z10) {
        if (z10) {
            setOpWrite();
        } else {
            clearOpWrite();
            eventLoop().execute(this.flushTask);
        }
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    protected final void clearOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (selectionKey.isValid()) {
            int iInterestOps = selectionKey.interestOps();
            if ((iInterestOps & 4) != 0) {
                selectionKey.interestOps(iInterestOps & (-5));
            }
        }
    }

    protected final int doWrite0(ChannelOutboundBuffer channelOutboundBuffer) {
        if (channelOutboundBuffer.current() == null) {
            return 0;
        }
        return doWriteInternal(channelOutboundBuffer, channelOutboundBuffer.current());
    }

    protected final void setOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (selectionKey.isValid()) {
            int iInterestOps = selectionKey.interestOps();
            if ((iInterestOps & 4) == 0) {
                selectionKey.interestOps(iInterestOps | 4);
            }
        }
    }

    final boolean shouldBreakReadReady(ChannelConfig channelConfig) {
        if (isInputShutdown0()) {
            if (this.inputClosedSeenErrorOnRead || !isAllowHalfClosure(channelConfig)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
