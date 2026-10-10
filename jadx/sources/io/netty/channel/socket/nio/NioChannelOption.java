package io.netty.channel.socket.nio;

import c8.a;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import java.io.IOException;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.Channel;
import java.nio.channels.NetworkChannel;
import java.nio.channels.ServerSocketChannel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class NioChannelOption<T> extends ChannelOption<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SocketOption<T> f11361a;

    static <T> T getOption(Channel channel, NioChannelOption<T> nioChannelOption) {
        NetworkChannel networkChannelA = a.a(channel);
        if (!networkChannelA.supportedOptions().contains(((NioChannelOption) nioChannelOption).f11361a)) {
            return null;
        }
        if (!(networkChannelA instanceof ServerSocketChannel) || ((NioChannelOption) nioChannelOption).f11361a != StandardSocketOptions.IP_TOS) {
            try {
                return (T) networkChannelA.getOption(((NioChannelOption) nioChannelOption).f11361a);
            } catch (IOException e10) {
                throw new ChannelException(e10);
            }
        }
        return null;
    }

    static <T> boolean setOption(Channel channel, NioChannelOption<T> nioChannelOption, T t10) {
        NetworkChannel networkChannelA = a.a(channel);
        if (!networkChannelA.supportedOptions().contains(((NioChannelOption) nioChannelOption).f11361a)) {
            return false;
        }
        if (!(networkChannelA instanceof ServerSocketChannel) || ((NioChannelOption) nioChannelOption).f11361a != StandardSocketOptions.IP_TOS) {
            try {
                networkChannelA.setOption(((NioChannelOption) nioChannelOption).f11361a, t10);
                return true;
            } catch (IOException e10) {
                throw new ChannelException(e10);
            }
        }
        return false;
    }
}
