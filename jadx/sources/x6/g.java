package x6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static q6.b f21882e = q6.c.d(g.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DatagramChannel f21883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Selector f21884b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f21886d = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayBlockingQueue<ec.a<InetSocketAddress, ByteBuffer>> f21885c = new ArrayBlockingQueue<>(a7.b.f151e);

    public void e() {
        try {
            this.f21886d = true;
            this.f21884b.close();
            this.f21883a.close();
        } catch (Exception e10) {
            f21882e.error("Socket close error", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        while (!this.f21886d) {
            try {
                this.f21884b.select();
                Iterator<SelectionKey> it = this.f21884b.selectedKeys().iterator();
                while (it.hasNext()) {
                    try {
                        SelectionKey next = it.next();
                        it.remove();
                        if (next.isValid() && next.isReadable()) {
                            ByteBuffer byteBufferOrder = ByteBuffer.allocate(1500).order(ByteOrder.BIG_ENDIAN);
                            InetSocketAddress inetSocketAddress = (InetSocketAddress) this.f21883a.receive(byteBufferOrder);
                            if (inetSocketAddress != null && !this.f21885c.offer(new ec.a<>(inetSocketAddress, byteBufferOrder))) {
                                f21882e.error("receive buffer queue is full", new Object[0]);
                            }
                        }
                    } catch (Exception e10) {
                        if (e10 instanceof ClosedSelectorException) {
                            return;
                        } else {
                            f21882e.error("glitch, continuing...", e10);
                        }
                    }
                }
            } catch (Exception e11) {
                if (e11 instanceof ClosedSelectorException) {
                    return;
                } else {
                    f21882e.error("glitch, continuing... ", e11);
                }
            }
        }
    }

    public ec.c<InetSocketAddress, ByteBuffer> b(int i10) {
        try {
            return this.f21885c.poll(i10, TimeUnit.MILLISECONDS);
        } catch (Exception e10) {
            f21882e.error("Receive from buffer error", e10);
            return null;
        }
    }

    public g() throws IOException {
        DatagramChannel datagramChannelOpen = DatagramChannel.open();
        datagramChannelOpen.configureBlocking(false);
        datagramChannelOpen.socket().setSoTimeout(a7.b.f148b);
        datagramChannelOpen.socket().setReceiveBufferSize(a7.b.f149c);
        datagramChannelOpen.socket().setSendBufferSize(a7.b.f150d);
        Selector selectorOpen = Selector.open();
        this.f21884b = selectorOpen;
        datagramChannelOpen.register(selectorOpen, 1);
        this.f21883a = datagramChannelOpen;
        Thread thread = new Thread(new Runnable() { // from class: x6.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f21881a.c();
            }
        }, "Socket-Receive");
        thread.setPriority(10);
        thread.start();
    }

    public void d(ByteBuffer byteBuffer, InetSocketAddress inetSocketAddress) {
        try {
            this.f21883a.send(byteBuffer, inetSocketAddress);
        } catch (Exception e10) {
            f21882e.error("socket Send error.", e10);
        }
    }
}
