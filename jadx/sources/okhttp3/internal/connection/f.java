package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import androidx.core.location.LocationRequestCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import nb.n;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.f0;
import okhttp3.l;
import okhttp3.t;
import okhttp3.v;
import okhttp3.z;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 52\u00020\u00012\u00020\u0002:\u0001cB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ7\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0014\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ1\u0010#\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u001fH\u0002¢\u0006\u0004\b%\u0010&J\u001d\u0010*\u001a\u00020)2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050'H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020)2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b,\u0010-J\u001f\u00100\u001a\u00020)2\u0006\u0010\"\u001a\u00020!2\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0011H\u0000¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0011H\u0000¢\u0006\u0004\b4\u00103J\u000f\u00105\u001a\u00020\u0011H\u0000¢\u0006\u0004\b5\u00103JE\u00107\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u00106\u001a\u00020)2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b7\u00108J'\u0010<\u001a\u00020)2\u0006\u0010:\u001a\u0002092\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010'H\u0000¢\u0006\u0004\b<\u0010=J\u001f\u0010C\u001a\u00020B2\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@H\u0000¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0005H\u0016¢\u0006\u0004\bE\u0010FJ\r\u0010G\u001a\u00020\u0011¢\u0006\u0004\bG\u00103J\u000f\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bI\u0010JJ\u0015\u0010L\u001a\u00020)2\u0006\u0010K\u001a\u00020)¢\u0006\u0004\bL\u0010MJ\u0017\u0010P\u001a\u00020\u00112\u0006\u0010O\u001a\u00020NH\u0016¢\u0006\u0004\bP\u0010QJ\u001f\u0010V\u001a\u00020\u00112\u0006\u0010S\u001a\u00020R2\u0006\u0010U\u001a\u00020TH\u0016¢\u0006\u0004\bV\u0010WJ\u0011\u0010X\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0004\bX\u0010YJ'\u0010]\u001a\u00020\u00112\u0006\u0010?\u001a\u00020>2\u0006\u0010Z\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020[H\u0000¢\u0006\u0004\b]\u0010^J!\u0010`\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020_2\b\u0010G\u001a\u0004\u0018\u00010[H\u0000¢\u0006\u0004\b`\u0010aJ\u000f\u0010c\u001a\u00020bH\u0016¢\u0006\u0004\bc\u0010dJ\u000f\u0010f\u001a\u00020eH\u0016¢\u0006\u0004\bf\u0010gR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\bP\u0010h\u001a\u0004\bi\u0010jR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010n\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010mR\u0018\u0010o\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010mR\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010pR\u0018\u0010r\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010qR\u0018\u0010t\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010sR\u0018\u0010w\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010vR\u0018\u0010z\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010yR#\u0010\u0080\u0001\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\u0017\u0010\u0081\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010{R'\u0010\u0086\u0001\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0005\b\u0019\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0005\b\u0085\u0001\u0010\u001cR\u0019\u0010\u0088\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0082\u0001R\u0019\u0010\u008a\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0082\u0001R\u0018\u0010\u008b\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b|\u0010\u0082\u0001R*\u0010\u0090\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020_0\u008d\u00010\u008c\u00018\u0006¢\u0006\u0010\n\u0006\b\u0083\u0001\u0010\u008e\u0001\u001a\u0006\b\u0087\u0001\u0010\u008f\u0001R)\u0010\u0096\u0001\u001a\u00030\u0091\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bX\u0010\u0092\u0001\u001a\u0006\b\u0089\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0016\u0010\u0098\u0001\u001a\u00020)8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0097\u0001\u0010}¨\u0006\u0099\u0001"}, d2 = {"Lokhttp3/internal/connection/f;", "Lnb/f$c;", "Lokhttp3/j;", "Lokhttp3/internal/connection/g;", "connectionPool", "Lokhttp3/f0;", "route", "<init>", "(Lokhttp3/internal/connection/g;Lokhttp3/f0;)V", "", "connectTimeout", "readTimeout", "writeTimeout", "Lokhttp3/e;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/r;", "eventListener", "Lr8/z;", "k", "(IIILokhttp3/e;Lokhttp3/r;)V", "i", "(IILokhttp3/e;Lokhttp3/r;)V", "Lokhttp3/internal/connection/b;", "connectionSpecSelector", "pingIntervalMillis", "n", "(Lokhttp3/internal/connection/b;ILokhttp3/e;Lokhttp3/r;)V", "F", "(I)V", "j", "(Lokhttp3/internal/connection/b;)V", "Lokhttp3/b0;", "tunnelRequest", "Lokhttp3/v;", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "l", "(IILokhttp3/b0;Lokhttp3/v;)Lokhttp3/b0;", "m", "()Lokhttp3/b0;", "", "candidates", "", "B", "(Ljava/util/List;)Z", "G", "(Lokhttp3/v;)Z", "Lokhttp3/t;", "handshake", "f", "(Lokhttp3/v;Lokhttp3/t;)Z", "z", "()V", "y", "t", "connectionRetryEnabled", "g", "(IIIIZLokhttp3/e;Lokhttp3/r;)V", "Lokhttp3/a;", "address", "routes", "u", "(Lokhttp3/a;Ljava/util/List;)Z", "Lokhttp3/z;", "client", "Llb/g;", "chain", "Llb/d;", "x", "(Lokhttp3/z;Llb/g;)Llb/d;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lokhttp3/f0;", "e", "Ljava/net/Socket;", ExifInterface.LONGITUDE_EAST, "()Ljava/net/Socket;", "doExtensiveChecks", "v", "(Z)Z", "Lnb/i;", "stream", "c", "(Lnb/i;)V", "Lnb/f;", "connection", "Lnb/m;", "settings", "b", "(Lnb/f;Lnb/m;)V", "s", "()Lokhttp3/t;", "failedRoute", "Ljava/io/IOException;", "failure", "h", "(Lokhttp3/z;Lokhttp3/f0;Ljava/io/IOException;)V", "Lokhttp3/internal/connection/e;", "H", "(Lokhttp3/internal/connection/e;Ljava/io/IOException;)V", "Lokhttp3/a0;", "a", "()Lokhttp3/a0;", "", "toString", "()Ljava/lang/String;", "Lokhttp3/internal/connection/g;", "getConnectionPool", "()Lokhttp3/internal/connection/g;", "d", "Lokhttp3/f0;", "Ljava/net/Socket;", "rawSocket", "socket", "Lokhttp3/t;", "Lokhttp3/a0;", "protocol", "Lnb/f;", "http2Connection", "Ltb/f;", "Ltb/f;", "source", "Ltb/e;", "Ltb/e;", "sink", "Z", "q", "()Z", "D", "(Z)V", "noNewExchanges", "noCoalescedConnections", "I", "r", "()I", "setRouteFailureCount$okhttp", "routeFailureCount", "o", "successCount", "p", "refusedStreamCount", "allocationLimit", "", "Ljava/lang/ref/Reference;", "Ljava/util/List;", "()Ljava/util/List;", "calls", "", "J", "()J", "C", "(J)V", "idleAtNs", "w", "isMultiplexed", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class f extends nb.f.c implements okhttp3.j {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final g connectionPool;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final f0 route;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Socket rawSocket;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Socket socket;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private t handshake;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private a0 protocol;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private nb.f http2Connection;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private tb.f source;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private tb.e sink;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean noNewExchanges;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean noCoalescedConnections;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int routeFailureCount;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int successCount;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int refusedStreamCount;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int allocationLimit;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final List<Reference<e>> calls;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private long idleAtNs;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ljava/security/cert/Certificate;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class c extends o implements c9.a<List<? extends Certificate>> {
        final /* synthetic */ okhttp3.a $address;
        final /* synthetic */ okhttp3.g $certificatePinner;
        final /* synthetic */ t $unverifiedHandshake;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(okhttp3.g gVar, t tVar, okhttp3.a aVar) {
            super(0);
            this.$certificatePinner = gVar;
            this.$unverifiedHandshake = tVar;
            this.$address = aVar;
        }

        @Override // c9.a
        public final List<? extends Certificate> invoke() {
            rb.c cVarD = this.$certificatePinner.getCertificateChainCleaner();
            m.c(cVarD);
            return cVarD.a(this.$unverifiedHandshake.d(), this.$address.getUrl().getHost());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ljava/security/cert/X509Certificate;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class d extends o implements c9.a<List<? extends X509Certificate>> {
        d() {
            super(0);
        }

        @Override // c9.a
        public final List<? extends X509Certificate> invoke() {
            t tVar = f.this.handshake;
            m.c(tVar);
            List<Certificate> listD = tVar.d();
            ArrayList arrayList = new ArrayList(r.w(listD, 10));
            for (Certificate certificate : listD) {
                m.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public final synchronized void H(e call, IOException e10) {
        try {
            m.f(call, "call");
            if (e10 instanceof n) {
                if (((n) e10).errorCode == nb.b.REFUSED_STREAM) {
                    int i10 = this.refusedStreamCount + 1;
                    this.refusedStreamCount = i10;
                    if (i10 > 1) {
                        this.noNewExchanges = true;
                        this.routeFailureCount++;
                    }
                } else if (((n) e10).errorCode != nb.b.CANCEL || !call.getCanceled()) {
                    this.noNewExchanges = true;
                    this.routeFailureCount++;
                }
            } else if (!w() || (e10 instanceof nb.a)) {
                this.noNewExchanges = true;
                if (this.successCount == 0) {
                    if (e10 != null) {
                        h(call.getClient(), this.route, e10);
                    }
                    this.routeFailureCount++;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // nb.f.c
    public synchronized void b(nb.f connection, nb.m settings) {
        m.f(connection, "connection");
        m.f(settings, "settings");
        this.allocationLimit = settings.d();
    }

    public final synchronized void t() {
        this.successCount++;
    }

    public final synchronized void y() {
        this.noCoalescedConnections = true;
    }

    public final synchronized void z() {
        this.noNewExchanges = true;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16864a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f16864a = iArr;
        }
    }

    public f(g connectionPool, f0 route) {
        m.f(connectionPool, "connectionPool");
        m.f(route, "route");
        this.connectionPool = connectionPool;
        this.route = route;
        this.allocationLimit = 1;
        this.calls = new ArrayList();
        this.idleAtNs = LocationRequestCompat.PASSIVE_INTERVAL;
    }

    private final boolean B(List<f0> candidates) {
        List<f0> list = candidates;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (f0 f0Var : list) {
            Proxy.Type type = f0Var.getProxy().type();
            Proxy.Type type2 = Proxy.Type.DIRECT;
            if (type == type2 && this.route.getProxy().type() == type2 && m.a(this.route.getSocketAddress(), f0Var.getSocketAddress())) {
                return true;
            }
        }
        return false;
    }

    private final void F(int pingIntervalMillis) throws SocketException {
        Socket socket = this.socket;
        m.c(socket);
        tb.f fVar = this.source;
        m.c(fVar);
        tb.e eVar = this.sink;
        m.c(eVar);
        socket.setSoTimeout(0);
        nb.f fVarA = new nb.f.a(true, kb.e.f12223i).q(socket, this.route.getAddress().getUrl().getHost(), fVar, eVar).k(this).l(pingIntervalMillis).a();
        this.http2Connection = fVarA;
        this.allocationLimit = nb.f.INSTANCE.a().d();
        nb.f.p0(fVarA, false, null, 3, null);
    }

    private final boolean G(v url) {
        t tVar;
        if (hb.d.f10920h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        v url2 = this.route.getAddress().getUrl();
        if (url.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT java.lang.String() != url2.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT java.lang.String()) {
            return false;
        }
        if (m.a(url.getHost(), url2.getHost())) {
            return true;
        }
        if (!this.noCoalescedConnections && (tVar = this.handshake) != null) {
            m.c(tVar);
            if (f(url, tVar)) {
                return true;
            }
        }
        return false;
    }

    private final void i(int connectTimeout, int readTimeout, okhttp3.e call, okhttp3.r eventListener) throws IOException {
        Socket socketCreateSocket;
        Proxy proxy = this.route.getProxy();
        okhttp3.a address = this.route.getAddress();
        Proxy.Type type = proxy.type();
        int i10 = type == null ? -1 : b.f16864a[type.ordinal()];
        if (i10 == 1 || i10 == 2) {
            socketCreateSocket = address.getSocketFactory().createSocket();
            m.c(socketCreateSocket);
        } else {
            socketCreateSocket = new Socket(proxy);
        }
        this.rawSocket = socketCreateSocket;
        eventListener.i(call, this.route.getSocketAddress(), proxy);
        socketCreateSocket.setSoTimeout(readTimeout);
        try {
            ob.m.INSTANCE.g().f(socketCreateSocket, this.route.getSocketAddress(), connectTimeout);
            try {
                this.source = tb.n.b(tb.n.g(socketCreateSocket));
                this.sink = tb.n.a(tb.n.d(socketCreateSocket));
            } catch (NullPointerException e10) {
                if (m.a(e10.getMessage(), "throw with null exception")) {
                    throw new IOException(e10);
                }
            }
        } catch (ConnectException e11) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.route.getSocketAddress());
            connectException.initCause(e11);
            throw connectException;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void j(okhttp3.internal.connection.b connectionSpecSelector) throws Throwable {
        okhttp3.a address = this.route.getAddress();
        SSLSocketFactory sslSocketFactory = address.getSslSocketFactory();
        SSLSocket sSLSocket = null;
        try {
            m.c(sslSocketFactory);
            Socket socketCreateSocket = sslSocketFactory.createSocket(this.rawSocket, address.getUrl().getHost(), address.getUrl().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT java.lang.String(), true);
            m.d(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                l lVarA = connectionSpecSelector.a(sSLSocket2);
                if (lVarA.getSupportsTlsExtensions()) {
                    ob.m.INSTANCE.g().e(sSLSocket2, address.getUrl().getHost(), address.f());
                }
                sSLSocket2.startHandshake();
                SSLSession sslSocketSession = sSLSocket2.getSession();
                t.Companion companion = t.INSTANCE;
                m.e(sslSocketSession, "sslSocketSession");
                t tVarA = companion.a(sslSocketSession);
                HostnameVerifier hostnameVerifier = address.getHostnameVerifier();
                m.c(hostnameVerifier);
                if (hostnameVerifier.verify(address.getUrl().getHost(), sslSocketSession)) {
                    okhttp3.g certificatePinner = address.getCertificatePinner();
                    m.c(certificatePinner);
                    this.handshake = new t(tVarA.getTlsVersion(), tVarA.getCipherSuite(), tVarA.c(), new c(certificatePinner, tVarA, address));
                    certificatePinner.b(address.getUrl().getHost(), new d());
                    String strG = lVarA.getSupportsTlsExtensions() ? ob.m.INSTANCE.g().g(sSLSocket2) : null;
                    this.socket = sSLSocket2;
                    this.source = tb.n.b(tb.n.g(sSLSocket2));
                    this.sink = tb.n.a(tb.n.d(sSLSocket2));
                    this.protocol = strG != null ? a0.INSTANCE.a(strG) : a0.HTTP_1_1;
                    ob.m.INSTANCE.g().b(sSLSocket2);
                    return;
                }
                List<Certificate> listD = tVarA.d();
                if (listD.isEmpty()) {
                    throw new SSLPeerUnverifiedException("Hostname " + address.getUrl().getHost() + " not verified (no certificates)");
                }
                Certificate certificate = listD.get(0);
                m.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                X509Certificate x509Certificate = (X509Certificate) certificate;
                throw new SSLPeerUnverifiedException(ua.n.l("\n              |Hostname " + address.getUrl().getHost() + " not verified:\n              |    certificate: " + okhttp3.g.INSTANCE.a(x509Certificate) + "\n              |    DN: " + x509Certificate.getSubjectDN().getName() + "\n              |    subjectAltNames: " + rb.d.f17904a.a(x509Certificate) + "\n              ", null, 1, null));
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    ob.m.INSTANCE.g().b(sSLSocket);
                }
                if (sSLSocket != null) {
                    hb.d.n(sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final b0 l(int readTimeout, int writeTimeout, b0 tunnelRequest, v url) throws IOException {
        String str = "CONNECT " + hb.d.Q(url, true) + " HTTP/1.1";
        while (true) {
            tb.f fVar = this.source;
            m.c(fVar);
            tb.e eVar = this.sink;
            m.c(eVar);
            mb.b bVar = new mb.b(null, this, fVar, eVar);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            fVar.getTimeout().g(readTimeout, timeUnit);
            eVar.getTimeout().g(writeTimeout, timeUnit);
            bVar.z(tunnelRequest.getHeaders(), str);
            bVar.a();
            d0.a aVarD = bVar.d(false);
            m.c(aVarD);
            d0 d0VarC = aVarD.r(tunnelRequest).c();
            bVar.y(d0VarC);
            int code = d0VarC.getCode();
            if (code == 200) {
                if (fVar.getBufferField().L() && eVar.getBufferField().L()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (code != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + d0VarC.getCode());
            }
            b0 b0VarA = this.route.getAddress().getProxyAuthenticator().a(this.route, d0VarC);
            if (b0VarA == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if (ua.n.w("close", d0.l(d0VarC, "Connection", null, 2, null), true)) {
                return b0VarA;
            }
            tunnelRequest = b0VarA;
        }
    }

    private final b0 m() {
        b0 b0VarB = new b0.a().l(this.route.getAddress().getUrl()).g("CONNECT", null).e("Host", hb.d.Q(this.route.getAddress().getUrl(), true)).e("Proxy-Connection", "Keep-Alive").e("User-Agent", "okhttp/4.12.0").b();
        b0 b0VarA = this.route.getAddress().getProxyAuthenticator().a(this.route, new d0.a().r(b0VarB).p(a0.HTTP_1_1).g(407).m("Preemptive Authenticate").b(hb.d.f10915c).s(-1L).q(-1L).j("Proxy-Authenticate", "OkHttp-Preemptive").c());
        return b0VarA == null ? b0VarB : b0VarA;
    }

    private final void n(okhttp3.internal.connection.b connectionSpecSelector, int pingIntervalMillis, okhttp3.e call, okhttp3.r eventListener) throws Throwable {
        if (this.route.getAddress().getSslSocketFactory() != null) {
            eventListener.B(call);
            j(connectionSpecSelector);
            eventListener.A(call, this.handshake);
            if (this.protocol == a0.HTTP_2) {
                F(pingIntervalMillis);
                return;
            }
            return;
        }
        List<a0> listF = this.route.getAddress().f();
        a0 a0Var = a0.H2_PRIOR_KNOWLEDGE;
        if (!listF.contains(a0Var)) {
            this.socket = this.rawSocket;
            this.protocol = a0.HTTP_1_1;
        } else {
            this.socket = this.rawSocket;
            this.protocol = a0Var;
            F(pingIntervalMillis);
        }
    }

    /* JADX INFO: renamed from: A, reason: from getter */
    public f0 getRoute() {
        return this.route;
    }

    public final void C(long j10) {
        this.idleAtNs = j10;
    }

    public final void D(boolean z10) {
        this.noNewExchanges = z10;
    }

    public Socket E() {
        Socket socket = this.socket;
        m.c(socket);
        return socket;
    }

    @Override // okhttp3.j
    public a0 a() {
        a0 a0Var = this.protocol;
        m.c(a0Var);
        return a0Var;
    }

    @Override // nb.f.c
    public void c(nb.i stream) {
        m.f(stream, "stream");
        stream.d(nb.b.REFUSED_STREAM, null);
    }

    public final void e() {
        Socket socket = this.rawSocket;
        if (socket != null) {
            hb.d.n(socket);
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:53:0x0102  */
    /* JADX WARN: Code duplicated, block: B:56:0x0128  */
    /* JADX WARN: Code duplicated, block: B:57:0x012e  */
    /* JADX WARN: Code duplicated, block: B:59:0x0133  */
    /* JADX WARN: Code duplicated, block: B:61:0x0139 A[LOOP:0: B:69:0x0092->B:61:0x0139, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x013f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x013f A[SYNTHETIC] */
    public final void g(int connectTimeout, int readTimeout, int writeTimeout, int pingIntervalMillis, boolean connectionRetryEnabled, okhttp3.e call, okhttp3.r eventListener) throws Throwable {
        IOException iOException;
        Socket socket;
        Socket socket2;
        okhttp3.e call2 = call;
        okhttp3.r eventListener2 = eventListener;
        m.f(call2, "call");
        m.f(eventListener2, "eventListener");
        if (this.protocol != null) {
            throw new IllegalStateException("already connected");
        }
        List<l> listB = this.route.getAddress().b();
        okhttp3.internal.connection.b bVar = new okhttp3.internal.connection.b(listB);
        if (this.route.getAddress().getSslSocketFactory() == null) {
            if (!listB.contains(l.f16899k)) {
                throw new i(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String host = this.route.getAddress().getUrl().getHost();
            if (!ob.m.INSTANCE.g().i(host)) {
                throw new i(new UnknownServiceException("CLEARTEXT communication to " + host + " not permitted by network security policy"));
            }
        } else if (this.route.getAddress().f().contains(a0.H2_PRIOR_KNOWLEDGE)) {
            throw new i(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        i iVar = null;
        while (true) {
            try {
                if (this.route.c()) {
                    okhttp3.r rVar = eventListener2;
                    okhttp3.e eVar = call2;
                    try {
                        k(connectTimeout, readTimeout, writeTimeout, eVar, rVar);
                        call2 = eVar;
                        eventListener2 = rVar;
                        try {
                            if (this.rawSocket != null) {
                                break;
                            } else {
                                break;
                            }
                        } catch (IOException e10) {
                            e = e10;
                            iOException = e;
                            socket = this.socket;
                            if (socket != null) {
                                hb.d.n(socket);
                            }
                            socket2 = this.rawSocket;
                            if (socket2 != null) {
                                hb.d.n(socket2);
                            }
                            this.socket = null;
                            this.rawSocket = null;
                            this.source = null;
                            this.sink = null;
                            this.handshake = null;
                            this.protocol = null;
                            this.http2Connection = null;
                            this.allocationLimit = 1;
                            eventListener2.h(call2, this.route.getSocketAddress(), this.route.getProxy(), null, iOException);
                            if (iVar == null) {
                                iVar = new i(iOException);
                            } else {
                                iVar.a(iOException);
                            }
                            if (connectionRetryEnabled) {
                                throw iVar;
                            }
                            if (bVar.b(iOException)) {
                                throw iVar;
                            }
                            call2 = call;
                            eventListener2 = eventListener;
                        }
                    } catch (IOException e11) {
                        e = e11;
                        call2 = eVar;
                        eventListener2 = rVar;
                    }
                } else {
                    i(connectTimeout, readTimeout, call2, eventListener2);
                }
                try {
                    n(bVar, pingIntervalMillis, call2, eventListener2);
                    eventListener2.g(call2, this.route.getSocketAddress(), this.route.getProxy(), this.protocol);
                    break;
                } catch (IOException e12) {
                    e = e12;
                    iOException = e;
                    socket = this.socket;
                    if (socket != null) {
                        hb.d.n(socket);
                    }
                    socket2 = this.rawSocket;
                    if (socket2 != null) {
                        hb.d.n(socket2);
                    }
                    this.socket = null;
                    this.rawSocket = null;
                    this.source = null;
                    this.sink = null;
                    this.handshake = null;
                    this.protocol = null;
                    this.http2Connection = null;
                    this.allocationLimit = 1;
                    eventListener2.h(call2, this.route.getSocketAddress(), this.route.getProxy(), null, iOException);
                    if (iVar == null) {
                        iVar = new i(iOException);
                    } else {
                        iVar.a(iOException);
                    }
                    if (connectionRetryEnabled) {
                        throw iVar;
                    }
                    if (bVar.b(iOException)) {
                        throw iVar;
                    }
                    call2 = call;
                    eventListener2 = eventListener;
                }
            } catch (IOException e13) {
                e = e13;
            }
            call2 = call;
            eventListener2 = eventListener;
        }
        if (this.route.c() && this.rawSocket == null) {
            throw new i(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        this.idleAtNs = System.nanoTime();
    }

    public final void h(z client, f0 failedRoute, IOException failure) {
        m.f(client, "client");
        m.f(failedRoute, "failedRoute");
        m.f(failure, "failure");
        if (failedRoute.getProxy().type() != Proxy.Type.DIRECT) {
            okhttp3.a address = failedRoute.getAddress();
            address.getProxySelector().connectFailed(address.getUrl().u(), failedRoute.getProxy().address(), failure);
        }
        client.getRouteDatabase().b(failedRoute);
    }

    public final List<Reference<e>> o() {
        return this.calls;
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final long getIdleAtNs() {
        return this.idleAtNs;
    }

    /* JADX INFO: renamed from: q, reason: from getter */
    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    /* JADX INFO: renamed from: r, reason: from getter */
    public final int getRouteFailureCount() {
        return this.routeFailureCount;
    }

    /* JADX INFO: renamed from: s, reason: from getter */
    public t getHandshake() {
        return this.handshake;
    }

    public String toString() {
        Object cipherSuite;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection{");
        sb2.append(this.route.getAddress().getUrl().getHost());
        sb2.append(':');
        sb2.append(this.route.getAddress().getUrl().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT java.lang.String());
        sb2.append(", proxy=");
        sb2.append(this.route.getProxy());
        sb2.append(" hostAddress=");
        sb2.append(this.route.getSocketAddress());
        sb2.append(" cipherSuite=");
        t tVar = this.handshake;
        if (tVar == null || (cipherSuite = tVar.getCipherSuite()) == null) {
            cipherSuite = "none";
        }
        sb2.append(cipherSuite);
        sb2.append(" protocol=");
        sb2.append(this.protocol);
        sb2.append('}');
        return sb2.toString();
    }

    public final boolean u(okhttp3.a address, List<f0> routes) {
        m.f(address, "address");
        if (hb.d.f10920h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (this.calls.size() >= this.allocationLimit || this.noNewExchanges || !this.route.getAddress().d(address)) {
            return false;
        }
        if (m.a(address.getUrl().getHost(), getRoute().getAddress().getUrl().getHost())) {
            return true;
        }
        if (this.http2Connection == null || routes == null || !B(routes) || address.getHostnameVerifier() != rb.d.f17904a || !G(address.getUrl())) {
            return false;
        }
        try {
            okhttp3.g certificatePinner = address.getCertificatePinner();
            m.c(certificatePinner);
            String host = address.getUrl().getHost();
            t handshake = getHandshake();
            m.c(handshake);
            certificatePinner.a(host, handshake.d());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final boolean v(boolean doExtensiveChecks) {
        long j10;
        if (hb.d.f10920h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        long jNanoTime = System.nanoTime();
        Socket socket = this.rawSocket;
        m.c(socket);
        Socket socket2 = this.socket;
        m.c(socket2);
        tb.f fVar = this.source;
        m.c(fVar);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        nb.f fVar2 = this.http2Connection;
        if (fVar2 != null) {
            return fVar2.R(jNanoTime);
        }
        synchronized (this) {
            j10 = jNanoTime - this.idleAtNs;
        }
        if (j10 < 10000000000L || !doExtensiveChecks) {
            return true;
        }
        return hb.d.F(socket2, fVar);
    }

    public final boolean w() {
        return this.http2Connection != null;
    }

    public final lb.d x(z client, lb.g chain) throws SocketException {
        m.f(client, "client");
        m.f(chain, "chain");
        Socket socket = this.socket;
        m.c(socket);
        tb.f fVar = this.source;
        m.c(fVar);
        tb.e eVar = this.sink;
        m.c(eVar);
        nb.f fVar2 = this.http2Connection;
        if (fVar2 != null) {
            return new nb.g(client, this, chain, fVar2);
        }
        socket.setSoTimeout(chain.l());
        tb.a0 a0VarG = fVar.getTimeout();
        long jI = chain.getReadTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a0VarG.g(jI, timeUnit);
        eVar.getTimeout().g(chain.getWriteTimeoutMillis(), timeUnit);
        return new mb.b(client, this, fVar, eVar);
    }

    private final boolean f(v url, t handshake) {
        List<Certificate> listD = handshake.d();
        if (!listD.isEmpty()) {
            rb.d dVar = rb.d.f17904a;
            String host = url.getHost();
            Certificate certificate = listD.get(0);
            m.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            if (dVar.e(host, (X509Certificate) certificate)) {
                return true;
            }
        }
        return false;
    }

    private final void k(int connectTimeout, int readTimeout, int writeTimeout, okhttp3.e call, okhttp3.r eventListener) throws IOException {
        b0 b0VarM = m();
        v vVar = b0VarM.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String();
        for (int i10 = 0; i10 < 21; i10++) {
            i(connectTimeout, readTimeout, call, eventListener);
            b0VarM = l(readTimeout, writeTimeout, b0VarM, vVar);
            if (b0VarM != null) {
                Socket socket = this.rawSocket;
                if (socket != null) {
                    hb.d.n(socket);
                }
                this.rawSocket = null;
                this.sink = null;
                this.source = null;
                eventListener.g(call, this.route.getSocketAddress(), this.route.getProxy(), null);
            } else {
                return;
            }
        }
    }
}
