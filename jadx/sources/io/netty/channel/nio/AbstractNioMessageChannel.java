package io.netty.channel.nio;

import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.RecvByteBufAllocator;
import java.io.IOException;
import java.net.PortUnreachableException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class AbstractNioMessageChannel extends AbstractNioChannel {
    boolean inputShutdown;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class NioMessageUnsafe extends AbstractNioChannel.AbstractNioUnsafe {
        private final List<Object> readBuf;

        private NioMessageUnsafe() {
            super();
            this.readBuf = new ArrayList();
        }

        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public void read() {
            Throwable th;
            boolean zCloseOnReadError;
            boolean z10;
            ChannelConfig channelConfigConfig = AbstractNioMessageChannel.this.config();
            ChannelPipeline channelPipelinePipeline = AbstractNioMessageChannel.this.pipeline();
            RecvByteBufAllocator.Handle handleRecvBufAllocHandle = AbstractNioMessageChannel.this.unsafe().recvBufAllocHandle();
            handleRecvBufAllocHandle.reset(channelConfigConfig);
            while (true) {
                try {
                    int iDoReadMessages = AbstractNioMessageChannel.this.doReadMessages(this.readBuf);
                    if (iDoReadMessages != 0) {
                        if (iDoReadMessages < 0) {
                            zCloseOnReadError = true;
                            break;
                        } else {
                            handleRecvBufAllocHandle.incMessagesRead(iDoReadMessages);
                            if (!AbstractNioMessageChannel.this.continueReading(handleRecvBufAllocHandle)) {
                            }
                        }
                    }
                    zCloseOnReadError = false;
                    break;
                } catch (Throwable th2) {
                    th = th2;
                    zCloseOnReadError = false;
                }
            }
            th = null;
            try {
                int size = this.readBuf.size();
                for (int i10 = 0; i10 < size; i10++) {
                    AbstractNioMessageChannel.this.readPending = false;
                    channelPipelinePipeline.fireChannelRead(this.readBuf.get(i10));
                }
                this.readBuf.clear();
                handleRecvBufAllocHandle.readComplete();
                channelPipelinePipeline.fireChannelReadComplete();
                if (th != null) {
                    zCloseOnReadError = AbstractNioMessageChannel.this.closeOnReadError(th);
                    channelPipelinePipeline.fireExceptionCaught(th);
                }
                if (zCloseOnReadError) {
                    AbstractNioMessageChannel abstractNioMessageChannel = AbstractNioMessageChannel.this;
                    abstractNioMessageChannel.inputShutdown = true;
                    if (abstractNioMessageChannel.isOpen()) {
                        close(voidPromise());
                    }
                }
                if (z10) {
                    return;
                }
            } finally {
                if (!AbstractNioMessageChannel.this.readPending && !channelConfigConfig.isAutoRead()) {
                    removeReadOp();
                }
            }
        }

        /* synthetic */ NioMessageUnsafe(AbstractNioMessageChannel abstractNioMessageChannel, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    protected boolean continueOnWriteError() {
        return false;
    }

    protected abstract int doReadMessages(List<Object> list);

    protected abstract boolean doWriteMessage(Object obj, ChannelOutboundBuffer channelOutboundBuffer);

    @Override // io.netty.channel.nio.AbstractNioChannel, io.netty.channel.AbstractChannel
    protected void doBeginRead() {
        if (this.inputShutdown) {
            return;
        }
        super.doBeginRead();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioMessageUnsafe(this, null);
    }

    protected AbstractNioMessageChannel(Channel channel, SelectableChannel selectableChannel, int i10) {
        super(channel, selectableChannel, i10);
    }

    protected boolean closeOnReadError(Throwable th) {
        if (!isActive()) {
            return true;
        }
        if (th instanceof PortUnreachableException) {
            return false;
        }
        if (!(th instanceof IOException)) {
            return true;
        }
        return !(this instanceof b8.a);
    }

    protected boolean continueReading(RecvByteBufAllocator.Handle handle) {
        return handle.continueReading();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        SelectionKey selectionKey = selectionKey();
        int iInterestOps = selectionKey.interestOps();
        int iMaxMessagesPerWrite = maxMessagesPerWrite();
        loop0: while (iMaxMessagesPerWrite > 0) {
            Object objCurrent = channelOutboundBuffer.current();
            if (objCurrent == null) {
                break;
            }
            try {
                int writeSpinCount = config().getWriteSpinCount() - 1;
                while (true) {
                    if (writeSpinCount < 0) {
                        break loop0;
                    }
                    if (doWriteMessage(objCurrent, channelOutboundBuffer)) {
                        iMaxMessagesPerWrite--;
                        channelOutboundBuffer.remove();
                        break;
                    }
                    writeSpinCount--;
                }
            } catch (Exception e10) {
                if (continueOnWriteError()) {
                    iMaxMessagesPerWrite--;
                    channelOutboundBuffer.remove(e10);
                } else {
                    throw e10;
                }
            }
        }
        if (channelOutboundBuffer.isEmpty()) {
            if ((iInterestOps & 4) != 0) {
                selectionKey.interestOps(iInterestOps & (-5));
            }
        } else if ((iInterestOps & 4) == 0) {
            selectionKey.interestOps(iInterestOps | 4);
        }
    }
}
