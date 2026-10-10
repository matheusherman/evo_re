package okhttp3;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 K2\u00020\u0001:\u0002IEB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\bJ!\u0010\"\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J1\u0010&\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J9\u0010*\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u001f\u0010.\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b0\u0010/J\u0017\u00101\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b1\u0010\bJ\u001f\u00104\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b6\u0010\bJ\u001f\u00109\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b9\u0010:J\u001f\u0010;\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b=\u0010\bJ\u001f\u0010@\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\bB\u0010\bJ\u001f\u0010C\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\bC\u0010:J\u001f\u0010D\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\bD\u0010<J\u0017\u0010E\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\bE\u0010\bJ\u001f\u0010F\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\bF\u0010<J\u0017\u0010G\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\bG\u0010\bJ\u001f\u0010H\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\bH\u0010AJ\u001f\u0010I\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\bI\u0010AJ\u001f\u0010K\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010J\u001a\u00020>H\u0016¢\u0006\u0004\bK\u0010A¨\u0006L"}, d2 = {"Lokhttp3/r;", "", "<init>", "()V", "Lokhttp3/e;", NotificationCompat.CATEGORY_CALL, "Lr8/z;", "e", "(Lokhttp3/e;)V", "Lokhttp3/v;", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "o", "(Lokhttp3/e;Lokhttp3/v;)V", "", "Ljava/net/Proxy;", "proxies", "n", "(Lokhttp3/e;Lokhttp3/v;Ljava/util/List;)V", "", "domainName", "m", "(Lokhttp3/e;Ljava/lang/String;)V", "Ljava/net/InetAddress;", "inetAddressList", "l", "(Lokhttp3/e;Ljava/lang/String;Ljava/util/List;)V", "Ljava/net/InetSocketAddress;", "inetSocketAddress", "proxy", "i", "(Lokhttp3/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;)V", "B", "Lokhttp3/t;", "handshake", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lokhttp3/e;Lokhttp3/t;)V", "Lokhttp3/a0;", "protocol", "g", "(Lokhttp3/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/a0;)V", "Ljava/io/IOException;", "ioe", "h", "(Lokhttp3/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/a0;Ljava/io/IOException;)V", "Lokhttp3/j;", "connection", "j", "(Lokhttp3/e;Lokhttp3/j;)V", "k", "t", "Lokhttp3/b0;", "request", "s", "(Lokhttp3/e;Lokhttp3/b0;)V", "q", "", "byteCount", "p", "(Lokhttp3/e;J)V", "r", "(Lokhttp3/e;Ljava/io/IOException;)V", "y", "Lokhttp3/d0;", "response", "x", "(Lokhttp3/e;Lokhttp3/d0;)V", "v", "u", "w", "c", "d", "f", "z", "b", "cachedResponse", "a", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f16946b = new a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/r$c;", "", "Lokhttp3/e;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/r;", "a", "(Lokhttp3/e;)Lokhttp3/r;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface c {
        r a(e call);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"okhttp3/r$a", "Lokhttp3/r;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a extends r {
        a() {
        }
    }

    public void A(e call, t handshake) {
        kotlin.jvm.internal.m.f(call, "call");
    }

    public void B(e call) {
        kotlin.jvm.internal.m.f(call, "call");
    }

    public void a(e call, d0 cachedResponse) {
        kotlin.jvm.internal.m.f(call, "call");
        kotlin.jvm.internal.m.f(cachedResponse, "cachedResponse");
    }

    public void b(e call, d0 response) {
        kotlin.jvm.internal.m.f(call, "call");
        kotlin.jvm.internal.m.f(response, "response");
    }

    public void c(e call) {
        kotlin.jvm.internal.m.f(call, "call");
    }

    public void d(e call, IOException ioe) {
        kotlin.jvm.internal.m.f(call, "call");
        kotlin.jvm.internal.m.f(ioe, "ioe");
    }

    public void e(e call) {
        kotlin.jvm.internal.m.f(call, "call");
    }

    public void f(e call) {
        kotlin.jvm.internal.m.f(call, "call");
    }

    public void g(e call, InetSocketAddress inetSocketAddress, Proxy proxy, a0 protocol) {
        kotlin.jvm.internal.m.f(call, "call");
        kotlin.jvm.internal.m.f(inetSocketAddress, "inetSocketAddress");
        kotlin.jvm.internal.m.f(proxy, "proxy");
    }

    public void h(e call, InetSocketAddress inetSocketAddress, Proxy proxy, a0 protocol, IOException ioe) {
        kotlin.jvm.internal.m.f(call, "call");
        kotlin.jvm.internal.m.f(inetSocketAddress, "inetSocketAddress");
        kotlin.jvm.internal.m.f(proxy, "proxy");
        kotlin.jvm.internal.m.f(ioe, "ioe");
    }

    public void i(e call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        kotlin.jvm.internal.m.f(call, "call");
        kotlin.jvm.internal.m.f(inetSocketAddress, "inetSocketAddress");
        kotlin.jvm.internal.m.f(proxy, "proxy");
    }

    public void j(e call, j connection) {
        kotlin.jvm.internal.m.f(call, "call");
        kotlin.jvm.internal.m.f(connection, "connection");
    }

    public void k(e call, j connection) {
        kotlin.jvm.internal.m.f(call, "call");
        kotlin.jvm.internal.m.f(connection, "connection");
    }

    public void l(e call, String domainName, List<InetAddress> inetAddressList) {
        kotlin.jvm.internal.m.f(call, "call");
        kotlin.jvm.internal.m.f(domainName, "domainName");
        kotlin.jvm.internal.m.f(inetAddressList, "inetAddressList");
    }

    public void m(e call, String domainName) {
        kotlin.jvm.internal.m.f(call, "call");
        kotlin.jvm.internal.m.f(domainName, "domainName");
    }

    public void n(e call, v url, List<Proxy> proxies) {
        kotlin.jvm.internal.m.f(call, "call");
        kotlin.jvm.internal.m.f(url, "url");
        kotlin.jvm.internal.m.f(proxies, "proxies");
    }

    public void o(e call, v url) {
        kotlin.jvm.internal.m.f(call, "call");
        kotlin.jvm.internal.m.f(url, "url");
    }

    public void p(e call, long byteCount) {
        kotlin.jvm.internal.m.f(call, "call");
    }

    public void q(e call) {
        kotlin.jvm.internal.m.f(call, "call");
    }

    public void r(e call, IOException ioe) {
        kotlin.jvm.internal.m.f(call, "call");
        kotlin.jvm.internal.m.f(ioe, "ioe");
    }

    public void s(e call, b0 request) {
        kotlin.jvm.internal.m.f(call, "call");
        kotlin.jvm.internal.m.f(request, "request");
    }

    public void t(e call) {
        kotlin.jvm.internal.m.f(call, "call");
    }

    public void u(e call, long byteCount) {
        kotlin.jvm.internal.m.f(call, "call");
    }

    public void v(e call) {
        kotlin.jvm.internal.m.f(call, "call");
    }

    public void w(e call, IOException ioe) {
        kotlin.jvm.internal.m.f(call, "call");
        kotlin.jvm.internal.m.f(ioe, "ioe");
    }

    public void x(e call, d0 response) {
        kotlin.jvm.internal.m.f(call, "call");
        kotlin.jvm.internal.m.f(response, "response");
    }

    public void y(e call) {
        kotlin.jvm.internal.m.f(call, "call");
    }

    public void z(e call, d0 response) {
        kotlin.jvm.internal.m.f(call, "call");
        kotlin.jvm.internal.m.f(response, "response");
    }
}
