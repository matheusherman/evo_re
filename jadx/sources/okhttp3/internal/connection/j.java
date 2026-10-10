package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.f0;
import okhttp3.r;
import okhttp3.v;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0002\u001a\u0014B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0013H\u0086\u0002¢\u0006\u0004\b\u001a\u0010\u0015J\u0010\u0010\u001c\u001a\u00020\u001bH\u0086\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010 R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010!R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010&R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020(0\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010#R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010#¨\u00060"}, d2 = {"Lokhttp3/internal/connection/j;", "", "Lokhttp3/a;", "address", "Lokhttp3/internal/connection/h;", "routeDatabase", "Lokhttp3/e;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/r;", "eventListener", "<init>", "(Lokhttp3/a;Lokhttp3/internal/connection/h;Lokhttp3/e;Lokhttp3/r;)V", "Lokhttp3/v;", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "Ljava/net/Proxy;", "proxy", "Lr8/z;", "f", "(Lokhttp3/v;Ljava/net/Proxy;)V", "", "b", "()Z", "d", "()Ljava/net/Proxy;", "e", "(Ljava/net/Proxy;)V", "a", "Lokhttp3/internal/connection/j$b;", "c", "()Lokhttp3/internal/connection/j$b;", "Lokhttp3/a;", "Lokhttp3/internal/connection/h;", "Lokhttp3/e;", "Lokhttp3/r;", "", "Ljava/util/List;", "proxies", "", "I", "nextProxyIndex", "Ljava/net/InetSocketAddress;", "g", "inetSocketAddresses", "", "Lokhttp3/f0;", "h", "postponedRoutes", "i", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final okhttp3.a address;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final h routeDatabase;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final okhttp3.e call;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final r eventListener;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<? extends Proxy> proxies;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int nextProxyIndex;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private List<? extends InetSocketAddress> inetSocketAddresses;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final List<f0> postponedRoutes;

    /* JADX INFO: renamed from: okhttp3.internal.connection.j$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lokhttp3/internal/connection/j$a;", "", "<init>", "()V", "Ljava/net/InetSocketAddress;", "", "a", "(Ljava/net/InetSocketAddress;)Ljava/lang/String;", "socketHost", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final String a(InetSocketAddress inetSocketAddress) {
            m.f(inetSocketAddress, "<this>");
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                String hostName = inetSocketAddress.getHostName();
                m.e(hostName, "hostName");
                return hostName;
            }
            String hostAddress = address.getHostAddress();
            m.e(hostAddress, "address.hostAddress");
            return hostAddress;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0010¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/connection/j$b;", "", "", "Lokhttp3/f0;", "routes", "<init>", "(Ljava/util/List;)V", "", "b", "()Z", "c", "()Lokhttp3/f0;", "a", "Ljava/util/List;", "()Ljava/util/List;", "", "I", "nextRouteIndex", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final List<f0> routes;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int nextRouteIndex;

        public b(List<f0> routes) {
            m.f(routes, "routes");
            this.routes = routes;
        }

        public final List<f0> a() {
            return this.routes;
        }

        public final boolean b() {
            return this.nextRouteIndex < this.routes.size();
        }

        public final f0 c() {
            if (b()) {
                List<f0> list = this.routes;
                int i10 = this.nextRouteIndex;
                this.nextRouteIndex = i10 + 1;
                return list.get(i10);
            }
            throw new NoSuchElementException();
        }
    }

    public j(okhttp3.a address, h routeDatabase, okhttp3.e call, r eventListener) {
        m.f(address, "address");
        m.f(routeDatabase, "routeDatabase");
        m.f(call, "call");
        m.f(eventListener, "eventListener");
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        this.eventListener = eventListener;
        this.proxies = kotlin.collections.r.l();
        this.inetSocketAddresses = kotlin.collections.r.l();
        this.postponedRoutes = new ArrayList();
        f(address.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String(), address.getProxy());
    }

    private final boolean b() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private final void e(Proxy proxy) throws SocketException, UnknownHostException {
        String host;
        int port;
        List<InetAddress> listA;
        ArrayList arrayList = new ArrayList();
        this.inetSocketAddresses = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            host = this.address.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String().getHost();
            port = this.address.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT java.lang.String();
        } else {
            SocketAddress proxyAddress = proxy.address();
            if (!(proxyAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + proxyAddress.getClass()).toString());
            }
            Companion companion = INSTANCE;
            m.e(proxyAddress, "proxyAddress");
            InetSocketAddress inetSocketAddress = (InetSocketAddress) proxyAddress;
            host = companion.a(inetSocketAddress);
            port = inetSocketAddress.getPort();
        }
        if (1 > port || port >= 65536) {
            throw new SocketException("No route to " + host + ':' + port + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(host, port));
            return;
        }
        if (hb.d.i(host)) {
            listA = kotlin.collections.r.e(InetAddress.getByName(host));
        } else {
            this.eventListener.m(this.call, host);
            listA = this.address.getDns().a(host);
            if (listA.isEmpty()) {
                throw new UnknownHostException(this.address.getDns() + " returned no addresses for " + host);
            }
            this.eventListener.l(this.call, host, listA);
        }
        Iterator<InetAddress> it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(new InetSocketAddress(it.next(), port));
        }
    }

    private final void f(v url, Proxy proxy) {
        this.eventListener.o(this.call, url);
        List<Proxy> listG = g(proxy, url, this);
        this.proxies = listG;
        this.nextProxyIndex = 0;
        this.eventListener.n(this.call, url, listG);
    }

    private static final List<Proxy> g(Proxy proxy, v vVar, j jVar) {
        if (proxy != null) {
            return kotlin.collections.r.e(proxy);
        }
        URI uriU = vVar.u();
        if (uriU.getHost() == null) {
            return hb.d.w(Proxy.NO_PROXY);
        }
        List<Proxy> proxiesOrNull = jVar.address.getProxySelector().select(uriU);
        List<Proxy> list = proxiesOrNull;
        if (list == null || list.isEmpty()) {
            return hb.d.w(Proxy.NO_PROXY);
        }
        m.e(proxiesOrNull, "proxiesOrNull");
        return hb.d.S(proxiesOrNull);
    }

    private final Proxy d() throws SocketException, UnknownHostException {
        if (b()) {
            List<? extends Proxy> list = this.proxies;
            int i10 = this.nextProxyIndex;
            this.nextProxyIndex = i10 + 1;
            Proxy proxy = list.get(i10);
            e(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.address.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String().getHost() + "; exhausted proxy configurations: " + this.proxies);
    }

    public final boolean a() {
        if (!b() && this.postponedRoutes.isEmpty()) {
            return false;
        }
        return true;
    }

    public final b c() {
        if (a()) {
            ArrayList arrayList = new ArrayList();
            while (b()) {
                Proxy proxyD = d();
                Iterator<? extends InetSocketAddress> it = this.inetSocketAddresses.iterator();
                while (it.hasNext()) {
                    f0 f0Var = new f0(this.address, proxyD, it.next());
                    if (this.routeDatabase.c(f0Var)) {
                        this.postponedRoutes.add(f0Var);
                    } else {
                        arrayList.add(f0Var);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                kotlin.collections.r.C(arrayList, this.postponedRoutes);
                this.postponedRoutes.clear();
            }
            return new b(arrayList);
        }
        throw new NoSuchElementException();
    }
}
