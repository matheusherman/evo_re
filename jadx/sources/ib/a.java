package ib;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import okhttp3.b;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.f0;
import okhttp3.h;
import okhttp3.o;
import okhttp3.q;
import okhttp3.v;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u000b\u001a\u00020\n*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lib/a;", "Lokhttp3/b;", "Lokhttp3/q;", "defaultDns", "<init>", "(Lokhttp3/q;)V", "Ljava/net/Proxy;", "Lokhttp3/v;", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "dns", "Ljava/net/InetAddress;", "b", "(Ljava/net/Proxy;Lokhttp3/v;Lokhttp3/q;)Ljava/net/InetAddress;", "Lokhttp3/f0;", "route", "Lokhttp3/d0;", "response", "Lokhttp3/b0;", "a", "(Lokhttp3/f0;Lokhttp3/d0;)Lokhttp3/b0;", "d", "Lokhttp3/q;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class a implements b {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final q defaultDns;

    public a(q defaultDns) {
        m.f(defaultDns, "defaultDns");
        this.defaultDns = defaultDns;
    }

    /* JADX INFO: renamed from: ib.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class C0191a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11291a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f11291a = iArr;
        }
    }

    public /* synthetic */ a(q qVar, int i10, g gVar) {
        this((i10 & 1) != 0 ? q.f16943b : qVar);
    }

    @Override // okhttp3.b
    public b0 a(f0 route, d0 response) {
        Proxy proxy;
        q dns;
        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
        okhttp3.a address;
        m.f(response, "response");
        List<h> listD = response.d();
        b0 request = response.getRequest();
        v vVar = request.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String();
        boolean z10 = response.getCode() == 407;
        if (route == null || (proxy = route.getProxy()) == null) {
            proxy = Proxy.NO_PROXY;
        }
        for (h hVar : listD) {
            if (n.w("Basic", hVar.getScheme(), true)) {
                if (route == null || (address = route.getAddress()) == null || (dns = address.getDns()) == null) {
                    dns = this.defaultDns;
                }
                if (z10) {
                    SocketAddress socketAddressAddress = proxy.address();
                    m.d(socketAddressAddress, "null cannot be cast to non-null type java.net.InetSocketAddress");
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                    String hostName = inetSocketAddress.getHostName();
                    m.e(proxy, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName, b(proxy, vVar, dns), inetSocketAddress.getPort(), vVar.getScheme(), hVar.b(), hVar.getScheme(), vVar.v(), Authenticator.RequestorType.PROXY);
                } else {
                    String host = vVar.getHost();
                    m.e(proxy, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(host, b(proxy, vVar, dns), vVar.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT java.lang.String(), vVar.getScheme(), hVar.b(), hVar.getScheme(), vVar.v(), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthenticationRequestPasswordAuthentication != null) {
                    String str = z10 ? "Proxy-Authorization" : "Authorization";
                    String userName = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                    m.e(userName, "auth.userName");
                    char[] password = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                    m.e(password, "auth.password");
                    return request.h().e(str, o.a(userName, new String(password), hVar.a())).b();
                }
            }
        }
        return null;
    }

    private final InetAddress b(Proxy proxy, v vVar, q qVar) {
        int i10;
        Proxy.Type type = proxy.type();
        if (type == null) {
            i10 = -1;
        } else {
            i10 = C0191a.f11291a[type.ordinal()];
        }
        if (i10 == 1) {
            return (InetAddress) r.g0(qVar.a(vVar.getHost()));
        }
        SocketAddress socketAddressAddress = proxy.address();
        m.d(socketAddressAddress, "null cannot be cast to non-null type java.net.InetSocketAddress");
        InetAddress address = ((InetSocketAddress) socketAddressAddress).getAddress();
        m.e(address, "address() as InetSocketAddress).address");
        return address;
    }
}
