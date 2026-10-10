package io.netty.channel;

import io.netty.util.AttributeMap;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface Channel extends AttributeMap, ChannelOutboundInvoker, Comparable<Channel> {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface Unsafe {
        void beginRead();

        void bind(SocketAddress socketAddress, ChannelPromise channelPromise);

        void close(ChannelPromise channelPromise);

        void closeForcibly();

        void flush();

        SocketAddress localAddress();

        ChannelOutboundBuffer outboundBuffer();

        RecvByteBufAllocator.Handle recvBufAllocHandle();

        void register(EventLoop eventLoop, ChannelPromise channelPromise);

        SocketAddress remoteAddress();

        ChannelPromise voidPromise();

        void write(Object obj, ChannelPromise channelPromise);
    }

    ChannelFuture closeFuture();

    ChannelConfig config();

    EventLoop eventLoop();

    ChannelId id();

    boolean isActive();

    boolean isOpen();

    boolean isRegistered();

    boolean isWritable();

    ChannelMetadata metadata();

    ChannelPipeline pipeline();

    Channel read();

    Unsafe unsafe();
}
