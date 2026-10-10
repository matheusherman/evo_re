package io.netty.channel.socket.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.nio.AbstractNioByteChannel;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.socket.DefaultSocketChannelConfig;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.spi.SelectorProvider;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class NioSocketChannel extends AbstractNioByteChannel implements SocketChannel {
    private final SocketChannelConfig config;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NioSocketChannel.class);
    private static final SelectorProvider DEFAULT_SELECTOR_PROVIDER = SelectorProvider.provider();
    private static final Method OPEN_SOCKET_CHANNEL_WITH_FAMILY = SelectorProviderUtil.findOpenMethod("openSocketChannel");

    /* JADX INFO: renamed from: io.netty.channel.socket.nio.NioSocketChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class AnonymousClass1 implements Runnable {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class NioSocketChannelConfig extends DefaultSocketChannelConfig {
        private volatile int maxBytesPerGatheringWrite;

        /* synthetic */ NioSocketChannelConfig(NioSocketChannel nioSocketChannel, NioSocketChannel nioSocketChannel2, Socket socket, AnonymousClass1 anonymousClass1) {
            this(nioSocketChannel2, socket);
        }

        private NioSocketChannelConfig(NioSocketChannel nioSocketChannel, Socket socket) {
            super(nioSocketChannel, socket);
            this.maxBytesPerGatheringWrite = Integer.MAX_VALUE;
            calculateMaxBytesPerGatheringWrite();
        }

        private java.nio.channels.SocketChannel jdkChannel() {
            return ((NioSocketChannel) this.channel).javaChannel();
        }

        @Override // io.netty.channel.DefaultChannelConfig
        protected void autoReadCleared() {
            NioSocketChannel.this.clearReadPending();
        }

        int getMaxBytesPerGatheringWrite() {
            return this.maxBytesPerGatheringWrite;
        }

        void setMaxBytesPerGatheringWrite(int i10) {
            this.maxBytesPerGatheringWrite = i10;
        }

        @Override // io.netty.channel.socket.DefaultSocketChannelConfig
        public NioSocketChannelConfig setSendBufferSize(int i10) {
            super.setSendBufferSize(i10);
            calculateMaxBytesPerGatheringWrite();
            return this;
        }

        private void calculateMaxBytesPerGatheringWrite() {
            int sendBufferSize = getSendBufferSize() << 1;
            if (sendBufferSize > 0) {
                setMaxBytesPerGatheringWrite(sendBufferSize);
            }
        }

        @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
        public <T> T getOption(ChannelOption<T> channelOption) {
            if (PlatformDependent.javaVersion() >= 7 && (channelOption instanceof NioChannelOption)) {
                return (T) NioChannelOption.getOption(jdkChannel(), (NioChannelOption) channelOption);
            }
            return (T) super.getOption(channelOption);
        }

        @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
        public <T> boolean setOption(ChannelOption<T> channelOption, T t10) {
            if (PlatformDependent.javaVersion() >= 7 && (channelOption instanceof NioChannelOption)) {
                return NioChannelOption.setOption(jdkChannel(), (NioChannelOption) channelOption, t10);
            }
            return super.setOption(channelOption, t10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class NioSocketChannelUnsafe extends AbstractNioByteChannel.NioByteUnsafe {
        private NioSocketChannelUnsafe() {
            super();
        }

        /* synthetic */ NioSocketChannelUnsafe(NioSocketChannel nioSocketChannel, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe
        protected Executor prepareToClose() {
            try {
                if (!NioSocketChannel.this.javaChannel().isOpen() || NioSocketChannel.this.config().getSoLinger() <= 0) {
                    return null;
                }
                NioSocketChannel.this.doDeregister();
                return GlobalEventExecutor.INSTANCE;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public NioSocketChannel() {
        this(DEFAULT_SELECTOR_PROVIDER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownInput0(ChannelPromise channelPromise) {
        try {
            shutdownInput0();
            channelPromise.setSuccess();
        } catch (Throwable th) {
            channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel
    public ChannelFuture shutdownInput() {
        return shutdownInput(newPromise());
    }

    public NioSocketChannel(SelectorProvider selectorProvider) {
        this(selectorProvider, (InternetProtocolFamily) null);
    }

    private void adjustMaxBytesPerGatheringWrite(int i10, int i11, int i12) {
        int i13;
        if (i10 == i11) {
            int i14 = i10 << 1;
            if (i14 > i12) {
                ((NioSocketChannelConfig) this.config).setMaxBytesPerGatheringWrite(i14);
                return;
            }
            return;
        }
        if (i10 <= 4096 || i11 >= (i13 = i10 >>> 1)) {
            return;
        }
        ((NioSocketChannelConfig) this.config).setMaxBytesPerGatheringWrite(i13);
    }

    private static java.nio.channels.SocketChannel newChannel(SelectorProvider selectorProvider, InternetProtocolFamily internetProtocolFamily) {
        try {
            java.nio.channels.SocketChannel socketChannel = (java.nio.channels.SocketChannel) SelectorProviderUtil.newChannel(OPEN_SOCKET_CHANNEL_WITH_FAMILY, selectorProvider, internetProtocolFamily);
            return socketChannel == null ? selectorProvider.openSocketChannel() : socketChannel;
        } catch (IOException e10) {
            throw new ChannelException("Failed to open a socket.", e10);
        }
    }

    @Override // io.netty.channel.Channel
    public SocketChannelConfig config() {
        return this.config;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.nio.AbstractNioChannel
    public java.nio.channels.SocketChannel javaChannel() {
        return (java.nio.channels.SocketChannel) super.javaChannel();
    }

    @Override // io.netty.channel.AbstractChannel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioSocketChannelUnsafe(this, null);
    }

    @Override // io.netty.channel.AbstractChannel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    public ChannelFuture shutdownInput(final ChannelPromise channelPromise) {
        NioEventLoop nioEventLoopEventLoop = eventLoop();
        if (nioEventLoopEventLoop.inEventLoop()) {
            shutdownInput0(channelPromise);
            return channelPromise;
        }
        nioEventLoopEventLoop.execute(new Runnable() { // from class: io.netty.channel.socket.nio.NioSocketChannel.2
            @Override // java.lang.Runnable
            public void run() {
                NioSocketChannel.this.shutdownInput0(channelPromise);
            }
        });
        return channelPromise;
    }

    public NioSocketChannel(SelectorProvider selectorProvider, InternetProtocolFamily internetProtocolFamily) {
        this(newChannel(selectorProvider, internetProtocolFamily));
    }

    private void doBind0(SocketAddress socketAddress) throws IOException {
        if (PlatformDependent.javaVersion() >= 7) {
            SocketUtils.bind(javaChannel(), socketAddress);
        } else {
            SocketUtils.bind(javaChannel().socket(), socketAddress);
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws IOException {
        doBind0(socketAddress);
    }

    @Override // io.netty.channel.nio.AbstractNioChannel, io.netty.channel.AbstractChannel
    protected void doClose() throws IOException {
        super.doClose();
        javaChannel().close();
    }

    @Override // io.netty.channel.nio.AbstractNioChannel
    protected void doFinishConnect() {
        if (javaChannel().finishConnect()) {
        } else {
            throw new Error();
        }
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel
    protected int doReadBytes(ByteBuf byteBuf) {
        RecvByteBufAllocator.Handle handleRecvBufAllocHandle = unsafe().recvBufAllocHandle();
        handleRecvBufAllocHandle.attemptedBytesRead(byteBuf.writableBytes());
        return byteBuf.writeBytes(javaChannel(), handleRecvBufAllocHandle.attemptedBytesRead());
    }

    @Override // io.netty.channel.AbstractChannel
    protected final void doShutdownOutput() throws IOException {
        if (PlatformDependent.javaVersion() >= 7) {
            javaChannel().shutdownOutput();
        } else {
            javaChannel().socket().shutdownOutput();
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws IOException {
        java.nio.channels.SocketChannel socketChannelJavaChannel = javaChannel();
        int writeSpinCount = config().getWriteSpinCount();
        while (!channelOutboundBuffer.isEmpty()) {
            int maxBytesPerGatheringWrite = ((NioSocketChannelConfig) this.config).getMaxBytesPerGatheringWrite();
            ByteBuffer[] byteBufferArrNioBuffers = channelOutboundBuffer.nioBuffers(1024, maxBytesPerGatheringWrite);
            int iNioBufferCount = channelOutboundBuffer.nioBufferCount();
            boolean z10 = false;
            if (iNioBufferCount != 0) {
                if (iNioBufferCount != 1) {
                    long jNioBufferSize = channelOutboundBuffer.nioBufferSize();
                    long jWrite = socketChannelJavaChannel.write(byteBufferArrNioBuffers, 0, iNioBufferCount);
                    if (jWrite <= 0) {
                        incompleteWrite(true);
                        return;
                    } else {
                        adjustMaxBytesPerGatheringWrite((int) jNioBufferSize, (int) jWrite, maxBytesPerGatheringWrite);
                        channelOutboundBuffer.removeBytes(jWrite);
                    }
                } else {
                    ByteBuffer byteBuffer = byteBufferArrNioBuffers[0];
                    int iRemaining = byteBuffer.remaining();
                    int iWrite = socketChannelJavaChannel.write(byteBuffer);
                    if (iWrite <= 0) {
                        incompleteWrite(true);
                        return;
                    } else {
                        adjustMaxBytesPerGatheringWrite(iRemaining, iWrite, maxBytesPerGatheringWrite);
                        channelOutboundBuffer.removeBytes(iWrite);
                    }
                }
                writeSpinCount--;
            } else {
                writeSpinCount -= doWrite0(channelOutboundBuffer);
            }
            if (writeSpinCount <= 0) {
                if (writeSpinCount < 0) {
                    z10 = true;
                }
                incompleteWrite(z10);
                return;
            }
        }
        clearOpWrite();
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel
    protected int doWriteBytes(ByteBuf byteBuf) {
        return byteBuf.readBytes(javaChannel(), byteBuf.readableBytes());
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel
    protected long doWriteFileRegion(FileRegion fileRegion) {
        return fileRegion.transferTo(javaChannel(), fileRegion.transferred());
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        java.nio.channels.SocketChannel socketChannelJavaChannel = javaChannel();
        if (socketChannelJavaChannel.isOpen() && socketChannelJavaChannel.isConnected()) {
            return true;
        }
        return false;
    }

    public boolean isInputShutdown() {
        if (!javaChannel().socket().isInputShutdown() && isActive()) {
            return false;
        }
        return true;
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel
    protected boolean isInputShutdown0() {
        return isInputShutdown();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return javaChannel().socket().getLocalSocketAddress();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return javaChannel().socket().getRemoteSocketAddress();
    }

    public NioSocketChannel(java.nio.channels.SocketChannel socketChannel) {
        this((Channel) null, socketChannel);
    }

    private void shutdownInput0() throws IOException {
        if (PlatformDependent.javaVersion() >= 7) {
            javaChannel().shutdownInput();
        } else {
            javaChannel().socket().shutdownInput();
        }
    }

    public NioSocketChannel(Channel channel, java.nio.channels.SocketChannel socketChannel) {
        super(channel, socketChannel);
        this.config = new NioSocketChannelConfig(this, this, socketChannel.socket(), null);
    }
}
