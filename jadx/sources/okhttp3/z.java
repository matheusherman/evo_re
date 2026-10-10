package okhttp3;

import androidx.exifinterface.media.ExifInterface;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u0083\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u000e\u0018B\u0011\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00128G¢\u0006\f\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178G¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8G¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8G¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"R\u0017\u0010,\u001a\u00020'8G¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u00102\u001a\u00020-8G¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00107\u001a\u0002038G¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b4\u00106R\u0017\u0010:\u001a\u00020-8G¢\u0006\f\n\u0004\b8\u0010/\u001a\u0004\b9\u00101R\u0017\u0010=\u001a\u00020-8G¢\u0006\f\n\u0004\b;\u0010/\u001a\u0004\b<\u00101R\u0017\u0010C\u001a\u00020>8G¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0017\u0010I\u001a\u00020D8G¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0019\u0010O\u001a\u0004\u0018\u00010J8G¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0017\u0010T\u001a\u00020P8G¢\u0006\f\n\u0004\b\u001a\u0010Q\u001a\u0004\bR\u0010SR\u0017\u0010W\u001a\u0002038G¢\u0006\f\n\u0004\bU\u00105\u001a\u0004\bV\u00106R\u0017\u0010\\\u001a\u00020X8G¢\u0006\f\n\u0004\bA\u0010Y\u001a\u0004\bZ\u0010[R\u0016\u0010_\u001a\u0004\u0018\u00010]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010^R\u0019\u0010d\u001a\u0004\u0018\u00010`8G¢\u0006\f\n\u0004\bG\u0010a\u001a\u0004\bb\u0010cR\u001d\u0010g\u001a\b\u0012\u0004\u0012\u00020e0\u001d8G¢\u0006\f\n\u0004\bf\u0010 \u001a\u0004\bU\u0010\"R\u001d\u0010j\u001a\b\u0012\u0004\u0012\u00020h0\u001d8G¢\u0006\f\n\u0004\b*\u0010 \u001a\u0004\bi\u0010\"R\u0017\u0010o\u001a\u00020k8G¢\u0006\f\n\u0004\b9\u0010l\u001a\u0004\bm\u0010nR\u0017\u0010s\u001a\u00020p8G¢\u0006\f\n\u0004\b<\u0010q\u001a\u0004\bE\u0010rR\u0019\u0010x\u001a\u0004\u0018\u00010t8G¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\b?\u0010wR\u0017\u0010}\u001a\u00020y8G¢\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b;\u0010|R\u0017\u0010~\u001a\u00020y8G¢\u0006\f\n\u0004\bm\u0010{\u001a\u0004\bK\u0010|R\u0017\u0010\u007f\u001a\u00020y8G¢\u0006\f\n\u0004\b!\u0010{\u001a\u0004\b{\u0010|R\u001a\u0010\u0082\u0001\u001a\u00020y8G¢\u0006\u000e\n\u0005\b\u0080\u0001\u0010{\u001a\u0005\b\u0081\u0001\u0010|R\u0019\u0010\u0084\u0001\u001a\u00020y8G¢\u0006\r\n\u0004\b%\u0010{\u001a\u0005\b\u0083\u0001\u0010|R\u001d\u0010\u0089\u0001\u001a\u00030\u0085\u00018G¢\u0006\u0010\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0080\u0001\u0010\u0088\u0001R\u001b\u0010\u008d\u0001\u001a\u00030\u008a\u00018\u0006¢\u0006\u000e\n\u0005\b\u0010\u0010\u008b\u0001\u001a\u0005\bu\u0010\u008c\u0001R\u001e\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u00018G¢\u0006\u000f\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0005\b8\u0010\u0091\u0001R\u0014\u0010\u0094\u0001\u001a\u00020]8G¢\u0006\b\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001¨\u0006\u0095\u0001"}, d2 = {"Lokhttp3/z;", "", "Lokhttp3/e$a;", "", "Lokhttp3/z$a;", "builder", "<init>", "(Lokhttp3/z$a;)V", "()V", "Lr8/z;", "O", "Lokhttp3/b0;", "request", "Lokhttp3/e;", "a", "(Lokhttp3/b0;)Lokhttp3/e;", "C", "()Lokhttp3/z$a;", "Lokhttp3/p;", "Lokhttp3/p;", "p", "()Lokhttp3/p;", "dispatcher", "Lokhttp3/k;", "b", "Lokhttp3/k;", "m", "()Lokhttp3/k;", "connectionPool", "", "Lokhttp3/w;", "c", "Ljava/util/List;", "y", "()Ljava/util/List;", "interceptors", "d", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "networkInterceptors", "Lokhttp3/r$c;", "e", "Lokhttp3/r$c;", "s", "()Lokhttp3/r$c;", "eventListenerFactory", "", "f", "Z", "K", "()Z", "retryOnConnectionFailure", "Lokhttp3/b;", "g", "Lokhttp3/b;", "()Lokhttp3/b;", "authenticator", "h", "t", "followRedirects", "i", "u", "followSslRedirects", "Lokhttp3/n;", "j", "Lokhttp3/n;", "o", "()Lokhttp3/n;", "cookieJar", "Lokhttp3/q;", "k", "Lokhttp3/q;", "q", "()Lokhttp3/q;", "dns", "Ljava/net/Proxy;", "l", "Ljava/net/Proxy;", "F", "()Ljava/net/Proxy;", "proxy", "Ljava/net/ProxySelector;", "Ljava/net/ProxySelector;", "H", "()Ljava/net/ProxySelector;", "proxySelector", "n", "G", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "Ljavax/net/SocketFactory;", "L", "()Ljavax/net/SocketFactory;", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactoryOrNull", "Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/X509TrustManager;", "R", "()Ljavax/net/ssl/X509TrustManager;", "x509TrustManager", "Lokhttp3/l;", "r", "connectionSpecs", "Lokhttp3/a0;", ExifInterface.LONGITUDE_EAST, "protocols", "Ljavax/net/ssl/HostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "x", "()Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Lokhttp3/g;", "Lokhttp3/g;", "()Lokhttp3/g;", "certificatePinner", "Lrb/c;", "v", "Lrb/c;", "()Lrb/c;", "certificateChainCleaner", "", "w", "I", "()I", "callTimeoutMillis", "connectTimeoutMillis", "readTimeoutMillis", "z", "Q", "writeTimeoutMillis", "D", "pingIntervalMillis", "", "B", "J", "()J", "minWebSocketMessageToCompress", "Lokhttp3/internal/connection/h;", "Lokhttp3/internal/connection/h;", "()Lokhttp3/internal/connection/h;", "routeDatabase", "Lokhttp3/c;", "cache", "Lokhttp3/c;", "()Lokhttp3/c;", "N", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class z implements Cloneable, e.a {

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<a0> E = hb.d.w(a0.HTTP_2, a0.HTTP_1_1);
    private static final List<l> F = hb.d.w(l.f16897i, l.f16899k);

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private final int pingIntervalMillis;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private final long minWebSocketMessageToCompress;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private final okhttp3.internal.connection.h routeDatabase;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final p dispatcher;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final k connectionPool;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final List<w> interceptors;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<w> networkInterceptors;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final r.c eventListenerFactory;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean retryOnConnectionFailure;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final b authenticator;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean followRedirects;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean followSslRedirects;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final n cookieJar;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final q dns;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final Proxy proxy;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ProxySelector proxySelector;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final b proxyAuthenticator;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final SocketFactory socketFactory;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final SSLSocketFactory sslSocketFactoryOrNull;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final X509TrustManager x509TrustManager;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final List<l> connectionSpecs;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final List<a0> protocols;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final HostnameVerifier hostnameVerifier;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final g certificatePinner;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final rb.c certificateChainCleaner;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private final int callTimeoutMillis;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final int connectTimeoutMillis;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private final int readTimeoutMillis;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private final int writeTimeoutMillis;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u0017J\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u001d\u0010&\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0015\u0010*\u001a\u00020\u00002\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u001d\u00100\u001a\u00020\u00002\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u001d\u00102\u001a\u00020\u00002\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b2\u00101J\u001d\u00103\u001a\u00020\u00002\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b3\u00101J\u001d\u00105\u001a\u00020\u00002\u0006\u00104\u001a\u00020,2\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b5\u00101J\r\u00106\u001a\u00020\u0004¢\u0006\u0004\b6\u00107R\"\u0010>\u001a\u0002088\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\r\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010\b\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR \u0010H\u001a\b\u0012\u0004\u0012\u00020\u000b0D8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b6\u0010E\u001a\u0004\bF\u0010GR \u0010J\u001a\b\u0012\u0004\u0012\u00020\u000b0D8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b0\u0010E\u001a\u0004\bI\u0010GR\"\u0010\u0011\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\t\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010\u0015\u001a\u00020\u00148\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010[\u001a\u00020U8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b \u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010\u0018\u001a\u00020\u00148\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010P\u001a\u0004\b\\\u0010R\"\u0004\b]\u0010TR\"\u0010`\u001a\u00020\u00148\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010P\u001a\u0004\b^\u0010R\"\u0004\b_\u0010TR\"\u0010\u001b\u001a\u00020\u001a8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bW\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010\u001f\u001a\u00020\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR$\u0010s\u001a\u0004\u0018\u00010l8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR$\u0010{\u001a\u0004\u0018\u00010t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\"\u0010\u007f\u001a\u00020U8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b|\u0010V\u001a\u0004\b}\u0010X\"\u0004\b~\u0010ZR*\u0010\u0087\u0001\u001a\u00030\u0080\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R*\u0010\u008d\u0001\u001a\u0004\u0018\u00010\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b@\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R+\u0010\u0094\u0001\u001a\u0004\u0018\u00010$8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R.\u0010\u0099\u0001\u001a\n\u0012\u0005\u0012\u00030\u0096\u00010\u0095\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0004\bb\u0010E\u001a\u0005\b\u008e\u0001\u0010G\"\u0006\b\u0097\u0001\u0010\u0098\u0001R.\u0010\u009d\u0001\u001a\n\u0012\u0005\u0012\u00030\u009a\u00010\u0095\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0004\b:\u0010E\u001a\u0005\b\u009b\u0001\u0010G\"\u0006\b\u009c\u0001\u0010\u0098\u0001R'\u0010)\u001a\u00020(8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bh\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R(\u0010¨\u0001\u001a\u00030£\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0005\bL\u0010¤\u0001\u001a\u0005\b|\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R*\u0010®\u0001\u001a\u0005\u0018\u00010©\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0005\b\\\u0010ª\u0001\u001a\u0005\bu\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R(\u0010´\u0001\u001a\u00030¯\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0005\b^\u0010°\u0001\u001a\u0005\bm\u0010±\u0001\"\u0006\b²\u0001\u0010³\u0001R*\u0010¶\u0001\u001a\u00030¯\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u009f\u0001\u0010°\u0001\u001a\u0006\b\u0081\u0001\u0010±\u0001\"\u0006\bµ\u0001\u0010³\u0001R)\u0010¹\u0001\u001a\u00030¯\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bF\u0010°\u0001\u001a\u0006\b·\u0001\u0010±\u0001\"\u0006\b¸\u0001\u0010³\u0001R*\u0010½\u0001\u001a\u00030¯\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bº\u0001\u0010°\u0001\u001a\u0006\b»\u0001\u0010±\u0001\"\u0006\b¼\u0001\u0010³\u0001R)\u0010À\u0001\u001a\u00030¯\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bI\u0010°\u0001\u001a\u0006\b¾\u0001\u0010±\u0001\"\u0006\b¿\u0001\u0010³\u0001R)\u0010Ä\u0001\u001a\u00020,8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¾\u0001\u0010\u0083\u0001\u001a\u0006\bº\u0001\u0010Á\u0001\"\u0006\bÂ\u0001\u0010Ã\u0001R,\u0010Ê\u0001\u001a\u0005\u0018\u00010Å\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u009b\u0001\u0010Æ\u0001\u001a\u0006\b°\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R+\u0010Ì\u0001\u001a\u0005\u0018\u00010Ë\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\bÌ\u0001\u0010Í\u0001\u001a\u0005\bf\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001¨\u0006Ñ\u0001"}, d2 = {"Lokhttp3/z$a;", "", "<init>", "()V", "Lokhttp3/z;", "okHttpClient", "(Lokhttp3/z;)V", "Lokhttp3/k;", "connectionPool", "e", "(Lokhttp3/k;)Lokhttp3/z$a;", "Lokhttp3/w;", "interceptor", "a", "(Lokhttp3/w;)Lokhttp3/z$a;", "b", "Lokhttp3/r$c;", "eventListenerFactory", "h", "(Lokhttp3/r$c;)Lokhttp3/z$a;", "", "retryOnConnectionFailure", "Q", "(Z)Lokhttp3/z$a;", "followRedirects", "i", "Lokhttp3/n;", "cookieJar", "f", "(Lokhttp3/n;)Lokhttp3/z$a;", "Lokhttp3/q;", "dns", "g", "(Lokhttp3/q;)Lokhttp3/z$a;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "R", "(Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/X509TrustManager;)Lokhttp3/z$a;", "Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "N", "(Ljavax/net/ssl/HostnameVerifier;)Lokhttp3/z$a;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "d", "(JLjava/util/concurrent/TimeUnit;)Lokhttp3/z$a;", "P", ExifInterface.LATITUDE_SOUTH, "interval", "O", "c", "()Lokhttp3/z;", "Lokhttp3/p;", "Lokhttp3/p;", "s", "()Lokhttp3/p;", "setDispatcher$okhttp", "(Lokhttp3/p;)V", "dispatcher", "Lokhttp3/k;", "p", "()Lokhttp3/k;", "setConnectionPool$okhttp", "(Lokhttp3/k;)V", "", "Ljava/util/List;", "y", "()Ljava/util/List;", "interceptors", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "networkInterceptors", "Lokhttp3/r$c;", "u", "()Lokhttp3/r$c;", "setEventListenerFactory$okhttp", "(Lokhttp3/r$c;)V", "Z", "H", "()Z", "setRetryOnConnectionFailure$okhttp", "(Z)V", "Lokhttp3/b;", "Lokhttp3/b;", "j", "()Lokhttp3/b;", "setAuthenticator$okhttp", "(Lokhttp3/b;)V", "authenticator", "v", "setFollowRedirects$okhttp", "w", "setFollowSslRedirects$okhttp", "followSslRedirects", "Lokhttp3/n;", "r", "()Lokhttp3/n;", "setCookieJar$okhttp", "(Lokhttp3/n;)V", "k", "Lokhttp3/q;", "t", "()Lokhttp3/q;", "setDns$okhttp", "(Lokhttp3/q;)V", "Ljava/net/Proxy;", "l", "Ljava/net/Proxy;", "D", "()Ljava/net/Proxy;", "setProxy$okhttp", "(Ljava/net/Proxy;)V", "proxy", "Ljava/net/ProxySelector;", "m", "Ljava/net/ProxySelector;", "F", "()Ljava/net/ProxySelector;", "setProxySelector$okhttp", "(Ljava/net/ProxySelector;)V", "proxySelector", "n", ExifInterface.LONGITUDE_EAST, "setProxyAuthenticator$okhttp", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "o", "Ljavax/net/SocketFactory;", "J", "()Ljavax/net/SocketFactory;", "setSocketFactory$okhttp", "(Ljavax/net/SocketFactory;)V", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "K", "()Ljavax/net/ssl/SSLSocketFactory;", "setSslSocketFactoryOrNull$okhttp", "(Ljavax/net/ssl/SSLSocketFactory;)V", "sslSocketFactoryOrNull", "q", "Ljavax/net/ssl/X509TrustManager;", "M", "()Ljavax/net/ssl/X509TrustManager;", "setX509TrustManagerOrNull$okhttp", "(Ljavax/net/ssl/X509TrustManager;)V", "x509TrustManagerOrNull", "", "Lokhttp3/l;", "setConnectionSpecs$okhttp", "(Ljava/util/List;)V", "connectionSpecs", "Lokhttp3/a0;", "C", "setProtocols$okhttp", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "x", "()Ljavax/net/ssl/HostnameVerifier;", "setHostnameVerifier$okhttp", "(Ljavax/net/ssl/HostnameVerifier;)V", "Lokhttp3/g;", "Lokhttp3/g;", "()Lokhttp3/g;", "setCertificatePinner$okhttp", "(Lokhttp3/g;)V", "certificatePinner", "Lrb/c;", "Lrb/c;", "()Lrb/c;", "setCertificateChainCleaner$okhttp", "(Lrb/c;)V", "certificateChainCleaner", "", "I", "()I", "setCallTimeout$okhttp", "(I)V", "callTimeout", "setConnectTimeout$okhttp", "connectTimeout", "G", "setReadTimeout$okhttp", "readTimeout", "z", "L", "setWriteTimeout$okhttp", "writeTimeout", "B", "setPingInterval$okhttp", "pingInterval", "()J", "setMinWebSocketMessageToCompress$okhttp", "(J)V", "minWebSocketMessageToCompress", "Lokhttp3/internal/connection/h;", "Lokhttp3/internal/connection/h;", "()Lokhttp3/internal/connection/h;", "setRouteDatabase$okhttp", "(Lokhttp3/internal/connection/h;)V", "routeDatabase", "Lokhttp3/c;", "cache", "Lokhttp3/c;", "()Lokhttp3/c;", "setCache$okhttp", "(Lokhttp3/c;)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: A, reason: from kotlin metadata */
        private int pingInterval;

        /* JADX INFO: renamed from: B, reason: from kotlin metadata */
        private long minWebSocketMessageToCompress;

        /* JADX INFO: renamed from: C, reason: from kotlin metadata */
        private okhttp3.internal.connection.h routeDatabase;

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private p dispatcher;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private k connectionPool;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final List<w> interceptors;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final List<w> networkInterceptors;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private r.c eventListenerFactory;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean retryOnConnectionFailure;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        private b authenticator;

        /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
        private boolean followRedirects;

        /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
        private boolean followSslRedirects;

        /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
        private n cookieJar;

        /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
        private q dns;

        /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
        private Proxy proxy;

        /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
        private ProxySelector proxySelector;

        /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
        private b proxyAuthenticator;

        /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
        private SocketFactory socketFactory;

        /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
        private SSLSocketFactory sslSocketFactoryOrNull;

        /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
        private X509TrustManager x509TrustManagerOrNull;

        /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
        private List<l> connectionSpecs;

        /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
        private List<? extends a0> protocols;

        /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
        private HostnameVerifier hostnameVerifier;

        /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
        private g certificatePinner;

        /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
        private rb.c certificateChainCleaner;

        /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
        private int callTimeout;

        /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
        private int connectTimeout;

        /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
        private int readTimeout;

        /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
        private int writeTimeout;

        public a() {
            this.dispatcher = new p();
            this.connectionPool = new k();
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.eventListenerFactory = hb.d.g(r.f16946b);
            this.retryOnConnectionFailure = true;
            b bVar = b.f16616b;
            this.authenticator = bVar;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = n.f16932b;
            this.dns = q.f16943b;
            this.proxyAuthenticator = bVar;
            SocketFactory socketFactory = SocketFactory.getDefault();
            kotlin.jvm.internal.m.e(socketFactory, "getDefault()");
            this.socketFactory = socketFactory;
            Companion companion = z.INSTANCE;
            this.connectionSpecs = companion.a();
            this.protocols = companion.b();
            this.hostnameVerifier = rb.d.f17904a;
            this.certificatePinner = g.f16703d;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.minWebSocketMessageToCompress = 1024L;
        }

        public final c k() {
            return null;
        }

        public final List<w> A() {
            return this.networkInterceptors;
        }

        /* JADX INFO: renamed from: B, reason: from getter */
        public final int getPingInterval() {
            return this.pingInterval;
        }

        public final List<a0> C() {
            return this.protocols;
        }

        /* JADX INFO: renamed from: D, reason: from getter */
        public final Proxy getProxy() {
            return this.proxy;
        }

        /* JADX INFO: renamed from: E, reason: from getter */
        public final b getProxyAuthenticator() {
            return this.proxyAuthenticator;
        }

        /* JADX INFO: renamed from: F, reason: from getter */
        public final ProxySelector getProxySelector() {
            return this.proxySelector;
        }

        /* JADX INFO: renamed from: G, reason: from getter */
        public final int getReadTimeout() {
            return this.readTimeout;
        }

        /* JADX INFO: renamed from: H, reason: from getter */
        public final boolean getRetryOnConnectionFailure() {
            return this.retryOnConnectionFailure;
        }

        /* JADX INFO: renamed from: I, reason: from getter */
        public final okhttp3.internal.connection.h getRouteDatabase() {
            return this.routeDatabase;
        }

        /* JADX INFO: renamed from: J, reason: from getter */
        public final SocketFactory getSocketFactory() {
            return this.socketFactory;
        }

        /* JADX INFO: renamed from: K, reason: from getter */
        public final SSLSocketFactory getSslSocketFactoryOrNull() {
            return this.sslSocketFactoryOrNull;
        }

        /* JADX INFO: renamed from: L, reason: from getter */
        public final int getWriteTimeout() {
            return this.writeTimeout;
        }

        /* JADX INFO: renamed from: M, reason: from getter */
        public final X509TrustManager getX509TrustManagerOrNull() {
            return this.x509TrustManagerOrNull;
        }

        public final a N(HostnameVerifier hostnameVerifier) {
            kotlin.jvm.internal.m.f(hostnameVerifier, "hostnameVerifier");
            if (!kotlin.jvm.internal.m.a(hostnameVerifier, this.hostnameVerifier)) {
                this.routeDatabase = null;
            }
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public final a O(long interval, TimeUnit unit) {
            kotlin.jvm.internal.m.f(unit, "unit");
            this.pingInterval = hb.d.k("interval", interval, unit);
            return this;
        }

        public final a P(long timeout, TimeUnit unit) {
            kotlin.jvm.internal.m.f(unit, "unit");
            this.readTimeout = hb.d.k("timeout", timeout, unit);
            return this;
        }

        public final a Q(boolean retryOnConnectionFailure) {
            this.retryOnConnectionFailure = retryOnConnectionFailure;
            return this;
        }

        public final a R(SSLSocketFactory sslSocketFactory, X509TrustManager trustManager) {
            kotlin.jvm.internal.m.f(sslSocketFactory, "sslSocketFactory");
            kotlin.jvm.internal.m.f(trustManager, "trustManager");
            if (!kotlin.jvm.internal.m.a(sslSocketFactory, this.sslSocketFactoryOrNull) || !kotlin.jvm.internal.m.a(trustManager, this.x509TrustManagerOrNull)) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sslSocketFactory;
            this.certificateChainCleaner = rb.c.INSTANCE.a(trustManager);
            this.x509TrustManagerOrNull = trustManager;
            return this;
        }

        public final a S(long timeout, TimeUnit unit) {
            kotlin.jvm.internal.m.f(unit, "unit");
            this.writeTimeout = hb.d.k("timeout", timeout, unit);
            return this;
        }

        public final a a(w interceptor) {
            kotlin.jvm.internal.m.f(interceptor, "interceptor");
            this.interceptors.add(interceptor);
            return this;
        }

        public final a b(w interceptor) {
            kotlin.jvm.internal.m.f(interceptor, "interceptor");
            this.networkInterceptors.add(interceptor);
            return this;
        }

        public final z c() {
            return new z(this);
        }

        public final a d(long timeout, TimeUnit unit) {
            kotlin.jvm.internal.m.f(unit, "unit");
            this.connectTimeout = hb.d.k("timeout", timeout, unit);
            return this;
        }

        public final a e(k connectionPool) {
            kotlin.jvm.internal.m.f(connectionPool, "connectionPool");
            this.connectionPool = connectionPool;
            return this;
        }

        public final a f(n cookieJar) {
            kotlin.jvm.internal.m.f(cookieJar, "cookieJar");
            this.cookieJar = cookieJar;
            return this;
        }

        public final a g(q dns) {
            kotlin.jvm.internal.m.f(dns, "dns");
            if (!kotlin.jvm.internal.m.a(dns, this.dns)) {
                this.routeDatabase = null;
            }
            this.dns = dns;
            return this;
        }

        public final a h(r.c eventListenerFactory) {
            kotlin.jvm.internal.m.f(eventListenerFactory, "eventListenerFactory");
            this.eventListenerFactory = eventListenerFactory;
            return this;
        }

        public final a i(boolean followRedirects) {
            this.followRedirects = followRedirects;
            return this;
        }

        /* JADX INFO: renamed from: j, reason: from getter */
        public final b getAuthenticator() {
            return this.authenticator;
        }

        /* JADX INFO: renamed from: l, reason: from getter */
        public final int getCallTimeout() {
            return this.callTimeout;
        }

        /* JADX INFO: renamed from: m, reason: from getter */
        public final rb.c getCertificateChainCleaner() {
            return this.certificateChainCleaner;
        }

        /* JADX INFO: renamed from: n, reason: from getter */
        public final g getCertificatePinner() {
            return this.certificatePinner;
        }

        /* JADX INFO: renamed from: o, reason: from getter */
        public final int getConnectTimeout() {
            return this.connectTimeout;
        }

        /* JADX INFO: renamed from: p, reason: from getter */
        public final k getConnectionPool() {
            return this.connectionPool;
        }

        public final List<l> q() {
            return this.connectionSpecs;
        }

        /* JADX INFO: renamed from: r, reason: from getter */
        public final n getCookieJar() {
            return this.cookieJar;
        }

        /* JADX INFO: renamed from: s, reason: from getter */
        public final p getDispatcher() {
            return this.dispatcher;
        }

        /* JADX INFO: renamed from: t, reason: from getter */
        public final q getDns() {
            return this.dns;
        }

        /* JADX INFO: renamed from: u, reason: from getter */
        public final r.c getEventListenerFactory() {
            return this.eventListenerFactory;
        }

        /* JADX INFO: renamed from: v, reason: from getter */
        public final boolean getFollowRedirects() {
            return this.followRedirects;
        }

        /* JADX INFO: renamed from: w, reason: from getter */
        public final boolean getFollowSslRedirects() {
            return this.followSslRedirects;
        }

        /* JADX INFO: renamed from: x, reason: from getter */
        public final HostnameVerifier getHostnameVerifier() {
            return this.hostnameVerifier;
        }

        public final List<w> y() {
            return this.interceptors;
        }

        /* JADX INFO: renamed from: z, reason: from getter */
        public final long getMinWebSocketMessageToCompress() {
            return this.minWebSocketMessageToCompress;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(z okHttpClient) {
            this();
            kotlin.jvm.internal.m.f(okHttpClient, "okHttpClient");
            this.dispatcher = okHttpClient.getDispatcher();
            this.connectionPool = okHttpClient.getConnectionPool();
            kotlin.collections.r.C(this.interceptors, okHttpClient.y());
            kotlin.collections.r.C(this.networkInterceptors, okHttpClient.A());
            this.eventListenerFactory = okHttpClient.getEventListenerFactory();
            this.retryOnConnectionFailure = okHttpClient.getRetryOnConnectionFailure();
            this.authenticator = okHttpClient.getAuthenticator();
            this.followRedirects = okHttpClient.getFollowRedirects();
            this.followSslRedirects = okHttpClient.getFollowSslRedirects();
            this.cookieJar = okHttpClient.getCookieJar();
            okHttpClient.h();
            this.dns = okHttpClient.getDns();
            this.proxy = okHttpClient.getProxy();
            this.proxySelector = okHttpClient.getProxySelector();
            this.proxyAuthenticator = okHttpClient.getProxyAuthenticator();
            this.socketFactory = okHttpClient.getSocketFactory();
            this.sslSocketFactoryOrNull = okHttpClient.sslSocketFactoryOrNull;
            this.x509TrustManagerOrNull = okHttpClient.getX509TrustManager();
            this.connectionSpecs = okHttpClient.n();
            this.protocols = okHttpClient.E();
            this.hostnameVerifier = okHttpClient.getHostnameVerifier();
            this.certificatePinner = okHttpClient.getCertificatePinner();
            this.certificateChainCleaner = okHttpClient.getCertificateChainCleaner();
            this.callTimeout = okHttpClient.getCallTimeoutMillis();
            this.connectTimeout = okHttpClient.getConnectTimeoutMillis();
            this.readTimeout = okHttpClient.getReadTimeoutMillis();
            this.writeTimeout = okHttpClient.getWriteTimeoutMillis();
            this.pingInterval = okHttpClient.getPingIntervalMillis();
            this.minWebSocketMessageToCompress = okHttpClient.getMinWebSocketMessageToCompress();
            this.routeDatabase = okHttpClient.getRouteDatabase();
        }
    }

    /* JADX INFO: renamed from: okhttp3.z$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lokhttp3/z$b;", "", "<init>", "()V", "", "Lokhttp3/a0;", "DEFAULT_PROTOCOLS", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lokhttp3/l;", "DEFAULT_CONNECTION_SPECS", "a", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final List<l> a() {
            return z.F;
        }

        public final List<a0> b() {
            return z.E;
        }
    }

    public z(a builder) throws NoSuchAlgorithmException, KeyStoreException {
        ProxySelector proxySelector;
        kotlin.jvm.internal.m.f(builder, "builder");
        this.dispatcher = builder.getDispatcher();
        this.connectionPool = builder.getConnectionPool();
        this.interceptors = hb.d.S(builder.y());
        this.networkInterceptors = hb.d.S(builder.A());
        this.eventListenerFactory = builder.getEventListenerFactory();
        this.retryOnConnectionFailure = builder.getRetryOnConnectionFailure();
        this.authenticator = builder.getAuthenticator();
        this.followRedirects = builder.getFollowRedirects();
        this.followSslRedirects = builder.getFollowSslRedirects();
        this.cookieJar = builder.getCookieJar();
        builder.k();
        this.dns = builder.getDns();
        this.proxy = builder.getProxy();
        if (builder.getProxy() != null) {
            proxySelector = qb.a.f17686a;
        } else {
            proxySelector = builder.getProxySelector();
            proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
            if (proxySelector == null) {
                proxySelector = qb.a.f17686a;
            }
        }
        this.proxySelector = proxySelector;
        this.proxyAuthenticator = builder.getProxyAuthenticator();
        this.socketFactory = builder.getSocketFactory();
        List<l> listQ = builder.q();
        this.connectionSpecs = listQ;
        this.protocols = builder.C();
        this.hostnameVerifier = builder.getHostnameVerifier();
        this.callTimeoutMillis = builder.getCallTimeout();
        this.connectTimeoutMillis = builder.getConnectTimeout();
        this.readTimeoutMillis = builder.getReadTimeout();
        this.writeTimeoutMillis = builder.getWriteTimeout();
        this.pingIntervalMillis = builder.getPingInterval();
        this.minWebSocketMessageToCompress = builder.getMinWebSocketMessageToCompress();
        okhttp3.internal.connection.h routeDatabase = builder.getRouteDatabase();
        this.routeDatabase = routeDatabase == null ? new okhttp3.internal.connection.h() : routeDatabase;
        List<l> list = listQ;
        if ((list instanceof Collection) && list.isEmpty()) {
            this.sslSocketFactoryOrNull = null;
            this.certificateChainCleaner = null;
            this.x509TrustManager = null;
            this.certificatePinner = g.f16703d;
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((l) it.next()).getIsTls()) {
                    if (builder.getSslSocketFactoryOrNull() != null) {
                        this.sslSocketFactoryOrNull = builder.getSslSocketFactoryOrNull();
                        rb.c certificateChainCleaner = builder.getCertificateChainCleaner();
                        kotlin.jvm.internal.m.c(certificateChainCleaner);
                        this.certificateChainCleaner = certificateChainCleaner;
                        X509TrustManager x509TrustManagerOrNull = builder.getX509TrustManagerOrNull();
                        kotlin.jvm.internal.m.c(x509TrustManagerOrNull);
                        this.x509TrustManager = x509TrustManagerOrNull;
                        g certificatePinner = builder.getCertificatePinner();
                        kotlin.jvm.internal.m.c(certificateChainCleaner);
                        this.certificatePinner = certificatePinner.e(certificateChainCleaner);
                    } else {
                        ob.m.Companion companion = ob.m.INSTANCE;
                        X509TrustManager x509TrustManagerO = companion.g().o();
                        this.x509TrustManager = x509TrustManagerO;
                        ob.m mVarG = companion.g();
                        kotlin.jvm.internal.m.c(x509TrustManagerO);
                        this.sslSocketFactoryOrNull = mVarG.n(x509TrustManagerO);
                        rb.c.Companion companion2 = rb.c.INSTANCE;
                        kotlin.jvm.internal.m.c(x509TrustManagerO);
                        rb.c cVarA = companion2.a(x509TrustManagerO);
                        this.certificateChainCleaner = cVarA;
                        g certificatePinner2 = builder.getCertificatePinner();
                        kotlin.jvm.internal.m.c(cVarA);
                        this.certificatePinner = certificatePinner2.e(cVarA);
                    }
                }
            }
            this.sslSocketFactoryOrNull = null;
            this.certificateChainCleaner = null;
            this.x509TrustManager = null;
            this.certificatePinner = g.f16703d;
        }
        O();
    }

    public final c h() {
        return null;
    }

    private final void O() {
        List<w> list = this.interceptors;
        kotlin.jvm.internal.m.d(list, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list.contains(null)) {
            throw new IllegalStateException(("Null interceptor: " + this.interceptors).toString());
        }
        List<w> list2 = this.networkInterceptors;
        kotlin.jvm.internal.m.d(list2, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list2.contains(null)) {
            throw new IllegalStateException(("Null network interceptor: " + this.networkInterceptors).toString());
        }
        List<l> list3 = this.connectionSpecs;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                if (((l) it.next()).getIsTls()) {
                    if (this.sslSocketFactoryOrNull == null) {
                        throw new IllegalStateException("sslSocketFactory == null");
                    }
                    if (this.certificateChainCleaner == null) {
                        throw new IllegalStateException("certificateChainCleaner == null");
                    }
                    if (this.x509TrustManager == null) {
                        throw new IllegalStateException("x509TrustManager == null");
                    }
                    return;
                }
            }
        }
        if (this.sslSocketFactoryOrNull != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.certificateChainCleaner != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.x509TrustManager != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (!kotlin.jvm.internal.m.a(this.certificatePinner, g.f16703d)) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final List<w> A() {
        return this.networkInterceptors;
    }

    public a C() {
        return new a(this);
    }

    /* JADX INFO: renamed from: D, reason: from getter */
    public final int getPingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    public final List<a0> E() {
        return this.protocols;
    }

    /* JADX INFO: renamed from: F, reason: from getter */
    public final Proxy getProxy() {
        return this.proxy;
    }

    /* JADX INFO: renamed from: G, reason: from getter */
    public final b getProxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    /* JADX INFO: renamed from: H, reason: from getter */
    public final ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    /* JADX INFO: renamed from: I, reason: from getter */
    public final int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    /* JADX INFO: renamed from: K, reason: from getter */
    public final boolean getRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    /* JADX INFO: renamed from: L, reason: from getter */
    public final SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory N() {
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactoryOrNull;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    /* JADX INFO: renamed from: Q, reason: from getter */
    public final int getWriteTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    /* JADX INFO: renamed from: R, reason: from getter */
    public final X509TrustManager getX509TrustManager() {
        return this.x509TrustManager;
    }

    @Override // okhttp3.e.a
    public e a(b0 request) {
        kotlin.jvm.internal.m.f(request, "request");
        return new okhttp3.internal.connection.e(this, request, false);
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final b getAuthenticator() {
        return this.authenticator;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final int getCallTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final rb.c getCertificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final g getCertificatePinner() {
        return this.certificatePinner;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final k getConnectionPool() {
        return this.connectionPool;
    }

    public final List<l> n() {
        return this.connectionSpecs;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final n getCookieJar() {
        return this.cookieJar;
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final p getDispatcher() {
        return this.dispatcher;
    }

    /* JADX INFO: renamed from: q, reason: from getter */
    public final q getDns() {
        return this.dns;
    }

    /* JADX INFO: renamed from: s, reason: from getter */
    public final r.c getEventListenerFactory() {
        return this.eventListenerFactory;
    }

    /* JADX INFO: renamed from: t, reason: from getter */
    public final boolean getFollowRedirects() {
        return this.followRedirects;
    }

    /* JADX INFO: renamed from: u, reason: from getter */
    public final boolean getFollowSslRedirects() {
        return this.followSslRedirects;
    }

    /* JADX INFO: renamed from: v, reason: from getter */
    public final okhttp3.internal.connection.h getRouteDatabase() {
        return this.routeDatabase;
    }

    /* JADX INFO: renamed from: x, reason: from getter */
    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<w> y() {
        return this.interceptors;
    }

    /* JADX INFO: renamed from: z, reason: from getter */
    public final long getMinWebSocketMessageToCompress() {
        return this.minWebSocketMessageToCompress;
    }

    public Object clone() {
        return super.clone();
    }

    public z() {
        this(new a());
    }
}
