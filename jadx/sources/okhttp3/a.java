package okhttp3;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0000H\u0000¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\t\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0007¢\u0006\f\n\u0004\b*\u00100\u001a\u0004\b1\u00102R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0007¢\u0006\f\n\u0004\b$\u00103\u001a\u0004\b4\u00105R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0007¢\u0006\f\n\u0004\b4\u00106\u001a\u0004\b(\u00107R\u0017\u0010\u0011\u001a\u00020\u00108\u0007¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0007¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b<\u0010>R\u0017\u0010\u001a\u001a\u00020\u00198\u0007¢\u0006\f\n\u0004\b:\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010F\u001a\u00020B8G¢\u0006\f\n\u0004\b@\u0010C\u001a\u0004\bD\u0010ER\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148G¢\u0006\f\n\u0004\b.\u0010G\u001a\u0004\b8\u0010HR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00148G¢\u0006\f\n\u0004\b1\u0010G\u001a\u0004\b,\u0010H¨\u0006I"}, d2 = {"Lokhttp3/a;", "", "", "uriHost", "", "uriPort", "Lokhttp3/q;", "dns", "Ljavax/net/SocketFactory;", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Lokhttp3/g;", "certificatePinner", "Lokhttp3/b;", "proxyAuthenticator", "Ljava/net/Proxy;", "proxy", "", "Lokhttp3/a0;", "protocols", "Lokhttp3/l;", "connectionSpecs", "Ljava/net/ProxySelector;", "proxySelector", "<init>", "(Ljava/lang/String;ILokhttp3/q;Ljavax/net/SocketFactory;Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/HostnameVerifier;Lokhttp3/g;Lokhttp3/b;Ljava/net/Proxy;Ljava/util/List;Ljava/util/List;Ljava/net/ProxySelector;)V", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "that", "d", "(Lokhttp3/a;)Z", "toString", "()Ljava/lang/String;", "a", "Lokhttp3/q;", "c", "()Lokhttp3/q;", "b", "Ljavax/net/SocketFactory;", "j", "()Ljavax/net/SocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "k", "()Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/ssl/HostnameVerifier;", "e", "()Ljavax/net/ssl/HostnameVerifier;", "Lokhttp3/g;", "()Lokhttp3/g;", "f", "Lokhttp3/b;", "h", "()Lokhttp3/b;", "g", "Ljava/net/Proxy;", "()Ljava/net/Proxy;", "Ljava/net/ProxySelector;", "i", "()Ljava/net/ProxySelector;", "Lokhttp3/v;", "Lokhttp3/v;", "l", "()Lokhttp3/v;", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "Ljava/util/List;", "()Ljava/util/List;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final q dns;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final SocketFactory socketFactory;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final SSLSocketFactory sslSocketFactory;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final HostnameVerifier hostnameVerifier;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final g certificatePinner;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final b proxyAuthenticator;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Proxy proxy;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ProxySelector proxySelector;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final v url;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final List<a0> protocols;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final List<l> connectionSpecs;

    public a(String uriHost, int i10, q dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, b proxyAuthenticator, Proxy proxy, List<? extends a0> protocols, List<l> connectionSpecs, ProxySelector proxySelector) {
        kotlin.jvm.internal.m.f(uriHost, "uriHost");
        kotlin.jvm.internal.m.f(dns, "dns");
        kotlin.jvm.internal.m.f(socketFactory, "socketFactory");
        kotlin.jvm.internal.m.f(proxyAuthenticator, "proxyAuthenticator");
        kotlin.jvm.internal.m.f(protocols, "protocols");
        kotlin.jvm.internal.m.f(connectionSpecs, "connectionSpecs");
        kotlin.jvm.internal.m.f(proxySelector, "proxySelector");
        this.dns = dns;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = gVar;
        this.proxyAuthenticator = proxyAuthenticator;
        this.proxy = proxy;
        this.proxySelector = proxySelector;
        this.url = new v.a().q(sSLSocketFactory != null ? "https" : "http").g(uriHost).m(i10).c();
        this.protocols = hb.d.S(protocols);
        this.connectionSpecs = hb.d.S(connectionSpecs);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final g getCertificatePinner() {
        return this.certificatePinner;
    }

    public final List<l> b() {
        return this.connectionSpecs;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final q getDns() {
        return this.dns;
    }

    public final boolean d(a that) {
        kotlin.jvm.internal.m.f(that, "that");
        return kotlin.jvm.internal.m.a(this.dns, that.dns) && kotlin.jvm.internal.m.a(this.proxyAuthenticator, that.proxyAuthenticator) && kotlin.jvm.internal.m.a(this.protocols, that.protocols) && kotlin.jvm.internal.m.a(this.connectionSpecs, that.connectionSpecs) && kotlin.jvm.internal.m.a(this.proxySelector, that.proxySelector) && kotlin.jvm.internal.m.a(this.proxy, that.proxy) && kotlin.jvm.internal.m.a(this.sslSocketFactory, that.sslSocketFactory) && kotlin.jvm.internal.m.a(this.hostnameVerifier, that.hostnameVerifier) && kotlin.jvm.internal.m.a(this.certificatePinner, that.certificatePinner) && this.url.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT java.lang.String() == that.url.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT java.lang.String();
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public boolean equals(Object other) {
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        return kotlin.jvm.internal.m.a(this.url, aVar.url) && d(aVar);
    }

    public final List<a0> f() {
        return this.protocols;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final Proxy getProxy() {
        return this.proxy;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final b getProxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.url.hashCode()) * 31) + this.dns.hashCode()) * 31) + this.proxyAuthenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode()) * 31) + Objects.hashCode(this.proxy)) * 31) + Objects.hashCode(this.sslSocketFactory)) * 31) + Objects.hashCode(this.hostnameVerifier)) * 31) + Objects.hashCode(this.certificatePinner);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final v getUrl() {
        return this.url;
    }

    public String toString() {
        StringBuilder sb2;
        Object obj;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Address{");
        sb3.append(this.url.getHost());
        sb3.append(':');
        sb3.append(this.url.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT java.lang.String());
        sb3.append(", ");
        if (this.proxy != null) {
            sb2 = new StringBuilder();
            sb2.append("proxy=");
            obj = this.proxy;
        } else {
            sb2 = new StringBuilder();
            sb2.append("proxySelector=");
            obj = this.proxySelector;
        }
        sb2.append(obj);
        sb3.append(sb2.toString());
        sb3.append('}');
        return sb3.toString();
    }
}
