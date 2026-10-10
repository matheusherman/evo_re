package x1.f1.lb.streaming.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import java.net.BindException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0003R\u001c\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\n\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lx1/f1/lb/streaming/server/m;", "", "<init>", "()V", "Lr8/z;", "e", "c", "f", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "Lio/netty/channel/EventLoopGroup;", "Lio/netty/channel/EventLoopGroup;", "bossGroup", "d", "workerGroup", "Lio/netty/channel/ChannelFuture;", "Lio/netty/channel/ChannelFuture;", "channelFuture", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInInitializing", "", "g", "I", "()I", "setPort", "(I)V", IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT, "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static EventLoopGroup bossGroup;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static EventLoopGroup workerGroup;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static ChannelFuture channelFuture;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f21123a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger = q6.c.d(m.class);

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean isInInitializing = new AtomicBoolean(false);

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static int port = r.f21132a.x();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/streaming/server/m$a", "Lio/netty/channel/ChannelInitializer;", "Lio/netty/channel/socket/SocketChannel;", "ch", "Lr8/z;", "a", "(Lio/netty/channel/socket/SocketChannel;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends ChannelInitializer<SocketChannel> {
        @Override // io.netty.channel.ChannelInitializer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void initChannel(SocketChannel ch) {
            kotlin.jvm.internal.m.f(ch, "ch");
            ch.pipeline().addLast(new HttpServerCodec());
            ch.pipeline().addLast(new HttpContentCompressor());
            ch.pipeline().addLast(new ChunkedWriteHandler());
            ch.pipeline().addLast(new k());
        }

        a() {
        }
    }

    public final void f() {
        synchronized (this) {
            ChannelFuture channelFuture2 = channelFuture;
            if (channelFuture2 == null) {
                return;
            }
            if (channelFuture2 == null) {
                logger.a("HTTP Server stop listening on port :{}", Integer.valueOf(port));
                channelFuture = null;
                z zVar = z.f17874a;
                return;
            }
            try {
                Channel channel = channelFuture2.channel();
                if (channel != null) {
                    channel.close();
                }
                logger.a("HTTP Server stop listening on port :{}", Integer.valueOf(port));
                channelFuture = null;
            } catch (Throwable th) {
                logger.error("HTTP Server stop listening on port :" + port, th);
            }
            z zVar2 = z.f17874a;
            return;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        f21123a.e();
    }

    private final void e() {
        AtomicBoolean atomicBoolean;
        Channel channel;
        ChannelFuture channelFutureCloseFuture;
        if (!isInInitializing.compareAndSet(false, true)) {
            logger.warn("HTTP Server another thread in initializing", new Object[0]);
            return;
        }
        f();
        bossGroup = new NioEventLoopGroup(1);
        workerGroup = new NioEventLoopGroup();
        try {
            try {
                ServerBootstrap serverBootstrap = new ServerBootstrap();
                serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new a()).childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE);
                while (true) {
                    try {
                        channelFuture = serverBootstrap.bind(port).sync();
                        logger.a("HTTP Server started and listening on port :{}", Integer.valueOf(port));
                        atomicBoolean = isInInitializing;
                        atomicBoolean.set(false);
                        ChannelFuture channelFuture2 = channelFuture;
                        if (channelFuture2 != null && (channel = channelFuture2.channel()) != null && (channelFutureCloseFuture = channel.closeFuture()) != null) {
                            channelFutureCloseFuture.sync();
                            break;
                        }
                        break;
                    } catch (BindException e10) {
                        logger.warn("HTTP Server try to bind port[" + port + "], but already in use", e10);
                        port = port + 1;
                    }
                }
                EventLoopGroup eventLoopGroup = workerGroup;
                if (eventLoopGroup != null) {
                    eventLoopGroup.shutdownGracefully();
                }
                EventLoopGroup eventLoopGroup2 = bossGroup;
                if (eventLoopGroup2 != null) {
                    eventLoopGroup2.shutdownGracefully();
                }
                atomicBoolean.set(false);
            } catch (Throwable th) {
                EventLoopGroup eventLoopGroup3 = workerGroup;
                if (eventLoopGroup3 != null) {
                    eventLoopGroup3.shutdownGracefully();
                }
                EventLoopGroup eventLoopGroup4 = bossGroup;
                if (eventLoopGroup4 != null) {
                    eventLoopGroup4.shutdownGracefully();
                }
                isInInitializing.set(false);
                throw th;
            }
        } catch (Exception e11) {
            if (!(e11 instanceof InterruptedException)) {
                logger.error("NettyHttpServer run error", e11);
            }
            EventLoopGroup eventLoopGroup5 = workerGroup;
            if (eventLoopGroup5 != null) {
                eventLoopGroup5.shutdownGracefully();
            }
            EventLoopGroup eventLoopGroup6 = bossGroup;
            if (eventLoopGroup6 != null) {
                eventLoopGroup6.shutdownGracefully();
            }
            isInInitializing.set(false);
        }
    }

    public final int b() {
        return port;
    }

    public final void c() {
        new Thread(new Runnable() { // from class: x1.f1.lb.streaming.server.l
            @Override // java.lang.Runnable
            public final void run() {
                m.d();
            }
        }).start();
    }

    private m() {
    }
}
