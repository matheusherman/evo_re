package o6;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.codec.dns.DatagramDnsQueryEncoder;
import io.netty.handler.codec.dns.DatagramDnsResponseDecoder;
import io.netty.handler.codec.dns.DnsQuery;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static q6.b f16494e = q6.c.d(k.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Channel f16496b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f16498d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16497c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private EventLoopGroup f16495a = new NioEventLoopGroup();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends ChannelInitializer<NioDatagramChannel> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.channel.ChannelInitializer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void initChannel(NioDatagramChannel nioDatagramChannel) {
            nioDatagramChannel.pipeline().addLast(new DatagramDnsQueryEncoder());
            nioDatagramChannel.pipeline().addLast(new DatagramDnsResponseDecoder());
            nioDatagramChannel.pipeline().addLast(new d(k.this.f16498d));
            k.f16494e.a("[DNS]DNS UDP ChannelHandler initChannel ok", new Object[0]);
        }
    }

    public boolean c() {
        return this.f16497c;
    }

    public void d(DnsQuery dnsQuery) {
        this.f16496b.writeAndFlush(dnsQuery);
    }

    public void e() {
        try {
            try {
                Bootstrap bootstrap = new Bootstrap();
                bootstrap.group(this.f16495a).channel(NioDatagramChannel.class).handler(new a());
                ChannelFuture channelFutureSync = bootstrap.bind(0).sync();
                this.f16496b = channelFutureSync.channel();
                this.f16497c = true;
                channelFutureSync.channel().closeFuture().sync();
                this.f16495a.shutdownGracefully();
                f16494e.warn("[DNS]Socket stop", new Object[0]);
            } catch (Exception e10) {
                f16494e.error("[DNS]Socket error.", e10);
                this.f16495a.shutdownGracefully();
                f16494e.warn("[DNS]Socket stop", new Object[0]);
            }
        } catch (Throwable th) {
            this.f16495a.shutdownGracefully();
            f16494e.warn("[DNS]Socket stop", new Object[0]);
            throw th;
        }
    }

    public k(e eVar) {
        this.f16498d = eVar;
        new Thread(new Runnable() { // from class: o6.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f16493a.e();
            }
        }).start();
    }
}
