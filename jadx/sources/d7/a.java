package d7;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static q6.b f9646c = q6.c.d(a.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DatagramChannel f9647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f9648b;

    public void a(ByteBuffer byteBuffer, InetSocketAddress inetSocketAddress) {
        if (this.f9648b) {
            return;
        }
        try {
            this.f9647a.send(byteBuffer, inetSocketAddress);
        } catch (Exception e10) {
            f9646c.error("socket Send error.", e10);
        }
    }

    public a() throws IOException {
        this.f9648b = true;
        DatagramChannel datagramChannelOpen = DatagramChannel.open();
        datagramChannelOpen.configureBlocking(false);
        datagramChannelOpen.socket().setSoTimeout(a7.b.f148b);
        datagramChannelOpen.socket().setSendBufferSize(a7.b.f150d);
        this.f9647a = datagramChannelOpen;
        this.f9648b = false;
    }
}
