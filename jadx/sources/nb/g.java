package nb;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.u;
import okhttp3.z;
import tb.x;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0018B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0013H\u0016¢\u0006\u0004\b%\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b'\u0010(R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010)R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010/R\u0016\u00102\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u00101¨\u00063"}, d2 = {"Lnb/g;", "Llb/d;", "Lokhttp3/z;", "client", "Lokhttp3/internal/connection/f;", "connection", "Llb/g;", "chain", "Lnb/f;", "http2Connection", "<init>", "(Lokhttp3/z;Lokhttp3/internal/connection/f;Llb/g;Lnb/f;)V", "Lokhttp3/b0;", "request", "", "contentLength", "Ltb/x;", "g", "(Lokhttp3/b0;J)Ltb/x;", "Lr8/z;", "b", "(Lokhttp3/b0;)V", "e", "()V", "a", "", "expectContinue", "Lokhttp3/d0$a;", "d", "(Z)Lokhttp3/d0$a;", "Lokhttp3/d0;", "response", "f", "(Lokhttp3/d0;)J", "Ltb/z;", "c", "(Lokhttp3/d0;)Ltb/z;", "cancel", "Lokhttp3/internal/connection/f;", "getConnection", "()Lokhttp3/internal/connection/f;", "Llb/g;", "Lnb/f;", "Lnb/i;", "Lnb/i;", "stream", "Lokhttp3/a0;", "Lokhttp3/a0;", "protocol", "Z", "canceled", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class g implements lb.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final List<String> f16235h = hb.d.w("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final List<String> f16236i = hb.d.w("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final okhttp3.internal.connection.f connection;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final lb.g chain;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final f http2Connection;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile i stream;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final a0 protocol;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile boolean canceled;

    /* JADX INFO: renamed from: nb.g$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0013R\u0014\u0010\u001b\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0013R\u0014\u0010\u001d\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0013¨\u0006\u001e"}, d2 = {"Lnb/g$a;", "", "<init>", "()V", "Lokhttp3/b0;", "request", "", "Lnb/c;", "a", "(Lokhttp3/b0;)Ljava/util/List;", "Lokhttp3/u;", "headerBlock", "Lokhttp3/a0;", "protocol", "Lokhttp3/d0$a;", "b", "(Lokhttp3/u;Lokhttp3/a0;)Lokhttp3/d0$a;", "", "CONNECTION", "Ljava/lang/String;", "ENCODING", "HOST", "HTTP_2_SKIPPED_REQUEST_HEADERS", "Ljava/util/List;", "HTTP_2_SKIPPED_RESPONSE_HEADERS", "KEEP_ALIVE", "PROXY_CONNECTION", "TE", "TRANSFER_ENCODING", "UPGRADE", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final List<c> a(b0 request) {
            kotlin.jvm.internal.m.f(request, "request");
            u headers = request.getHeaders();
            ArrayList arrayList = new ArrayList(headers.size() + 4);
            arrayList.add(new c(c.f16128g, request.getMethod()));
            arrayList.add(new c(c.f16129h, lb.i.f15353a.c(request.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String())));
            String strD = request.d("Host");
            if (strD != null) {
                arrayList.add(new c(c.f16131j, strD));
            }
            arrayList.add(new c(c.f16130i, request.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String().getScheme()));
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                String strF = headers.f(i10);
                Locale US = Locale.US;
                kotlin.jvm.internal.m.e(US, "US");
                String lowerCase = strF.toLowerCase(US);
                kotlin.jvm.internal.m.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (!g.f16235h.contains(lowerCase) || (kotlin.jvm.internal.m.a(lowerCase, "te") && kotlin.jvm.internal.m.a(headers.k(i10), "trailers"))) {
                    arrayList.add(new c(lowerCase, headers.k(i10)));
                }
            }
            return arrayList;
        }

        public final d0.a b(u headerBlock, a0 protocol) throws ProtocolException {
            kotlin.jvm.internal.m.f(headerBlock, "headerBlock");
            kotlin.jvm.internal.m.f(protocol, "protocol");
            u.a aVar = new u.a();
            int size = headerBlock.size();
            lb.k kVarA = null;
            for (int i10 = 0; i10 < size; i10++) {
                String strF = headerBlock.f(i10);
                String strK = headerBlock.k(i10);
                if (kotlin.jvm.internal.m.a(strF, ":status")) {
                    kVarA = lb.k.INSTANCE.a("HTTP/1.1 " + strK);
                } else if (!g.f16236i.contains(strF)) {
                    aVar.d(strF, strK);
                }
            }
            if (kVarA != null) {
                return new d0.a().p(protocol).g(kVarA.code).m(kVarA.message).k(aVar.f());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
    }

    @Override // lb.d
    public void cancel() {
        this.canceled = true;
        i iVar = this.stream;
        if (iVar != null) {
            iVar.f(b.CANCEL);
        }
    }

    public g(z client, okhttp3.internal.connection.f connection, lb.g chain, f http2Connection) {
        kotlin.jvm.internal.m.f(client, "client");
        kotlin.jvm.internal.m.f(connection, "connection");
        kotlin.jvm.internal.m.f(chain, "chain");
        kotlin.jvm.internal.m.f(http2Connection, "http2Connection");
        this.connection = connection;
        this.chain = chain;
        this.http2Connection = http2Connection;
        List<a0> listE = client.E();
        a0 a0Var = a0.H2_PRIOR_KNOWLEDGE;
        this.protocol = listE.contains(a0Var) ? a0Var : a0.HTTP_2;
    }

    @Override // lb.d
    public void a() {
        i iVar = this.stream;
        kotlin.jvm.internal.m.c(iVar);
        iVar.n().close();
    }

    @Override // lb.d
    public void b(b0 request) throws IOException {
        kotlin.jvm.internal.m.f(request, "request");
        if (this.stream != null) {
            return;
        }
        this.stream = this.http2Connection.V(INSTANCE.a(request), request.getBody() != null);
        if (this.canceled) {
            i iVar = this.stream;
            kotlin.jvm.internal.m.c(iVar);
            iVar.f(b.CANCEL);
            throw new IOException("Canceled");
        }
        i iVar2 = this.stream;
        kotlin.jvm.internal.m.c(iVar2);
        tb.a0 a0VarV = iVar2.v();
        long readTimeoutMillis = this.chain.getReadTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a0VarV.g(readTimeoutMillis, timeUnit);
        i iVar3 = this.stream;
        kotlin.jvm.internal.m.c(iVar3);
        iVar3.E().g(this.chain.getWriteTimeoutMillis(), timeUnit);
    }

    @Override // lb.d
    public tb.z c(d0 response) {
        kotlin.jvm.internal.m.f(response, "response");
        i iVar = this.stream;
        kotlin.jvm.internal.m.c(iVar);
        return iVar.getSource();
    }

    @Override // lb.d
    public d0.a d(boolean expectContinue) throws IOException {
        i iVar = this.stream;
        if (iVar == null) {
            throw new IOException("stream wasn't created");
        }
        d0.a aVarB = INSTANCE.b(iVar.C(), this.protocol);
        if (expectContinue && aVarB.getCode() == 100) {
            return null;
        }
        return aVarB;
    }

    @Override // lb.d
    public void e() {
        this.http2Connection.flush();
    }

    @Override // lb.d
    public long f(d0 response) {
        kotlin.jvm.internal.m.f(response, "response");
        if (lb.e.b(response)) {
            return hb.d.v(response);
        }
        return 0L;
    }

    @Override // lb.d
    public x g(b0 request, long contentLength) {
        kotlin.jvm.internal.m.f(request, "request");
        i iVar = this.stream;
        kotlin.jvm.internal.m.c(iVar);
        return iVar.n();
    }

    @Override // lb.d
    public okhttp3.internal.connection.f getConnection() {
        return this.connection;
    }
}
