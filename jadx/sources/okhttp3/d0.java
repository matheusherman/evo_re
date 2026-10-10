package okhttp3;

import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001*B}\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010)R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u0005\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010)R\u0017\u0010\t\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b#\u00105\u001a\u0004\b6\u00107R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0007¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0017\u0010\r\u001a\u00020\f8\u0007¢\u0006\f\n\u0004\b6\u0010<\u001a\u0004\b=\u0010>R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0007¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\b*\u0010AR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\bF\u0010C\u001a\u0004\b2\u0010ER\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\b:\u0010C\u001a\u0004\bG\u0010ER\u0017\u0010\u0014\u001a\u00020\u00138\u0007¢\u0006\f\n\u0004\b\u001c\u0010H\u001a\u0004\bI\u0010JR\u0017\u0010\u0015\u001a\u00020\u00138\u0007¢\u0006\f\n\u0004\bK\u0010H\u001a\u0004\bL\u0010JR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0001X\u0080\u0004¢\u0006\f\n\u0004\b=\u0010M\u001a\u0004\bF\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0011\u0010U\u001a\u00020S8F¢\u0006\u0006\u001a\u0004\bP\u0010TR\u0011\u0010W\u001a\u00020O8G¢\u0006\u0006\u001a\u0004\b.\u0010V¨\u0006X"}, d2 = {"Lokhttp3/d0;", "Ljava/io/Closeable;", "Lokhttp3/b0;", "request", "Lokhttp3/a0;", "protocol", "", "message", "", "code", "Lokhttp3/t;", "handshake", "Lokhttp3/u;", "headers", "Lokhttp3/e0;", "body", "networkResponse", "cacheResponse", "priorResponse", "", "sentRequestAtMillis", "receivedResponseAtMillis", "Lokhttp3/internal/connection/c;", "exchange", "<init>", "(Lokhttp3/b0;Lokhttp3/a0;Ljava/lang/String;ILokhttp3/t;Lokhttp3/u;Lokhttp3/e0;Lokhttp3/d0;Lokhttp3/d0;Lokhttp3/d0;JJLokhttp3/internal/connection/c;)V", "name", "defaultValue", "k", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lokhttp3/d0$a;", "q", "()Lokhttp3/d0$a;", "", "Lokhttp3/h;", "d", "()Ljava/util/List;", "Lr8/z;", "close", "()V", "toString", "()Ljava/lang/String;", "a", "Lokhttp3/b0;", "u", "()Lokhttp3/b0;", "b", "Lokhttp3/a0;", "s", "()Lokhttp3/a0;", "c", "Ljava/lang/String;", "o", "I", "f", "()I", "e", "Lokhttp3/t;", "j", "()Lokhttp3/t;", "Lokhttp3/u;", "m", "()Lokhttp3/u;", "g", "Lokhttp3/e0;", "()Lokhttp3/e0;", "h", "Lokhttp3/d0;", "p", "()Lokhttp3/d0;", "i", "r", "J", "v", "()J", "l", "t", "Lokhttp3/internal/connection/c;", "()Lokhttp3/internal/connection/c;", "Lokhttp3/d;", "n", "Lokhttp3/d;", "lazyCacheControl", "", "()Z", "isSuccessful", "()Lokhttp3/d;", "cacheControl", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class d0 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b0 request;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final a0 protocol;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String message;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int code;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final t handshake;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final u headers;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final e0 body;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final d0 networkResponse;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final d0 cacheResponse;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final d0 priorResponse;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final long sentRequestAtMillis;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final long receivedResponseAtMillis;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final okhttp3.internal.connection.c exchange;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private d lazyCacheControl;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J!\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b#\u0010\"J\u0017\u0010&\u001a\u00020\u00002\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u0019\u0010*\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b*\u0010+J\u0019\u0010-\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b-\u0010.J\u0019\u00100\u001a\u00020\u00002\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b0\u0010.J\u0019\u00102\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b2\u0010.J\u0017\u00105\u001a\u00020\u00002\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\u00002\u0006\u00107\u001a\u000203H\u0016¢\u0006\u0004\b8\u00106J\u0017\u0010;\u001a\u00020\t2\u0006\u0010:\u001a\u000209H\u0000¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0004H\u0016¢\u0006\u0004\b=\u0010>R$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b#\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b*\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010\u0016\u001a\u00020\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b=\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\f\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010%\u001a\u00020X8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\n\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R$\u0010)\u001a\u0004\u0018\u00010(8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010,\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bJ\u0010c\u001a\u0004\bd\u0010>\"\u0004\be\u0010\u0006R$\u0010/\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010c\u001a\u0004\bf\u0010>\"\u0004\bg\u0010\u0006R$\u00101\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b!\u0010c\u001a\u0004\bh\u0010>\"\u0004\bi\u0010\u0006R\"\u00104\u001a\u0002038\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b&\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\"\u00107\u001a\u0002038\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b;\u0010j\u001a\u0004\bo\u0010l\"\u0004\bp\u0010nR$\u0010u\u001a\u0004\u0018\u0001098\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010<¨\u0006v"}, d2 = {"Lokhttp3/d0$a;", "", "<init>", "()V", "Lokhttp3/d0;", "response", "(Lokhttp3/d0;)V", "", "name", "Lr8/z;", "f", "(Ljava/lang/String;Lokhttp3/d0;)V", "e", "Lokhttp3/b0;", "request", "r", "(Lokhttp3/b0;)Lokhttp3/d0$a;", "Lokhttp3/a0;", "protocol", "p", "(Lokhttp3/a0;)Lokhttp3/d0$a;", "", "code", "g", "(I)Lokhttp3/d0$a;", "message", "m", "(Ljava/lang/String;)Lokhttp3/d0$a;", "Lokhttp3/t;", "handshake", "i", "(Lokhttp3/t;)Lokhttp3/d0$a;", "value", "j", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/d0$a;", "a", "Lokhttp3/u;", "headers", "k", "(Lokhttp3/u;)Lokhttp3/d0$a;", "Lokhttp3/e0;", "body", "b", "(Lokhttp3/e0;)Lokhttp3/d0$a;", "networkResponse", "n", "(Lokhttp3/d0;)Lokhttp3/d0$a;", "cacheResponse", "d", "priorResponse", "o", "", "sentRequestAtMillis", "s", "(J)Lokhttp3/d0$a;", "receivedResponseAtMillis", "q", "Lokhttp3/internal/connection/c;", "deferredTrailers", "l", "(Lokhttp3/internal/connection/c;)V", "c", "()Lokhttp3/d0;", "Lokhttp3/b0;", "getRequest$okhttp", "()Lokhttp3/b0;", "setRequest$okhttp", "(Lokhttp3/b0;)V", "Lokhttp3/a0;", "getProtocol$okhttp", "()Lokhttp3/a0;", "setProtocol$okhttp", "(Lokhttp3/a0;)V", "I", "h", "()I", "setCode$okhttp", "(I)V", "Ljava/lang/String;", "getMessage$okhttp", "()Ljava/lang/String;", "setMessage$okhttp", "(Ljava/lang/String;)V", "Lokhttp3/t;", "getHandshake$okhttp", "()Lokhttp3/t;", "setHandshake$okhttp", "(Lokhttp3/t;)V", "Lokhttp3/u$a;", "Lokhttp3/u$a;", "getHeaders$okhttp", "()Lokhttp3/u$a;", "setHeaders$okhttp", "(Lokhttp3/u$a;)V", "Lokhttp3/e0;", "getBody$okhttp", "()Lokhttp3/e0;", "setBody$okhttp", "(Lokhttp3/e0;)V", "Lokhttp3/d0;", "getNetworkResponse$okhttp", "setNetworkResponse$okhttp", "getCacheResponse$okhttp", "setCacheResponse$okhttp", "getPriorResponse$okhttp", "setPriorResponse$okhttp", "J", "getSentRequestAtMillis$okhttp", "()J", "setSentRequestAtMillis$okhttp", "(J)V", "getReceivedResponseAtMillis$okhttp", "setReceivedResponseAtMillis$okhttp", "Lokhttp3/internal/connection/c;", "getExchange$okhttp", "()Lokhttp3/internal/connection/c;", "setExchange$okhttp", "exchange", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private b0 request;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private a0 protocol;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int code;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private String message;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private t handshake;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private u.a headers;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        private e0 body;

        /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
        private d0 networkResponse;

        /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
        private d0 cacheResponse;

        /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
        private d0 priorResponse;

        /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
        private long sentRequestAtMillis;

        /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
        private long receivedResponseAtMillis;

        /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
        private okhttp3.internal.connection.c exchange;

        public a() {
            this.code = -1;
            this.headers = new u.a();
        }

        private final void e(d0 response) {
            if (response != null && response.getBody() != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private final void f(String name, d0 response) {
            if (response != null) {
                if (response.getBody() != null) {
                    throw new IllegalArgumentException((name + ".body != null").toString());
                }
                if (response.getNetworkResponse() != null) {
                    throw new IllegalArgumentException((name + ".networkResponse != null").toString());
                }
                if (response.getCacheResponse() != null) {
                    throw new IllegalArgumentException((name + ".cacheResponse != null").toString());
                }
                if (response.getPriorResponse() == null) {
                    return;
                }
                throw new IllegalArgumentException((name + ".priorResponse != null").toString());
            }
        }

        public a a(String name, String value) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(value, "value");
            this.headers.a(name, value);
            return this;
        }

        public a b(e0 body) {
            this.body = body;
            return this;
        }

        public d0 c() {
            int i10 = this.code;
            if (i10 < 0) {
                throw new IllegalStateException(("code < 0: " + this.code).toString());
            }
            b0 b0Var = this.request;
            if (b0Var == null) {
                throw new IllegalStateException("request == null");
            }
            a0 a0Var = this.protocol;
            if (a0Var == null) {
                throw new IllegalStateException("protocol == null");
            }
            String str = this.message;
            if (str != null) {
                return new d0(b0Var, a0Var, str, i10, this.handshake, this.headers.f(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
            }
            throw new IllegalStateException("message == null");
        }

        public a d(d0 cacheResponse) {
            f("cacheResponse", cacheResponse);
            this.cacheResponse = cacheResponse;
            return this;
        }

        public a g(int code) {
            this.code = code;
            return this;
        }

        /* JADX INFO: renamed from: h, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        public a i(t handshake) {
            this.handshake = handshake;
            return this;
        }

        public a j(String name, String value) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(value, "value");
            this.headers.i(name, value);
            return this;
        }

        public a k(u headers) {
            kotlin.jvm.internal.m.f(headers, "headers");
            this.headers = headers.h();
            return this;
        }

        public final void l(okhttp3.internal.connection.c deferredTrailers) {
            kotlin.jvm.internal.m.f(deferredTrailers, "deferredTrailers");
            this.exchange = deferredTrailers;
        }

        public a m(String message) {
            kotlin.jvm.internal.m.f(message, "message");
            this.message = message;
            return this;
        }

        public a n(d0 networkResponse) {
            f("networkResponse", networkResponse);
            this.networkResponse = networkResponse;
            return this;
        }

        public a p(a0 protocol) {
            kotlin.jvm.internal.m.f(protocol, "protocol");
            this.protocol = protocol;
            return this;
        }

        public a q(long receivedResponseAtMillis) {
            this.receivedResponseAtMillis = receivedResponseAtMillis;
            return this;
        }

        public a r(b0 request) {
            kotlin.jvm.internal.m.f(request, "request");
            this.request = request;
            return this;
        }

        public a s(long sentRequestAtMillis) {
            this.sentRequestAtMillis = sentRequestAtMillis;
            return this;
        }

        public a o(d0 priorResponse) {
            e(priorResponse);
            this.priorResponse = priorResponse;
            return this;
        }

        public a(d0 response) {
            kotlin.jvm.internal.m.f(response, "response");
            this.code = -1;
            this.request = response.getRequest();
            this.protocol = response.getProtocol();
            this.code = response.getCode();
            this.message = response.getMessage();
            this.handshake = response.getHandshake();
            this.headers = response.getHeaders().h();
            this.body = response.getBody();
            this.networkResponse = response.getNetworkResponse();
            this.cacheResponse = response.getCacheResponse();
            this.priorResponse = response.getPriorResponse();
            this.sentRequestAtMillis = response.getSentRequestAtMillis();
            this.receivedResponseAtMillis = response.getReceivedResponseAtMillis();
            this.exchange = response.getExchange();
        }
    }

    public d0(b0 request, a0 protocol, String message, int i10, t tVar, u headers, e0 e0Var, d0 d0Var, d0 d0Var2, d0 d0Var3, long j10, long j11, okhttp3.internal.connection.c cVar) {
        kotlin.jvm.internal.m.f(request, "request");
        kotlin.jvm.internal.m.f(protocol, "protocol");
        kotlin.jvm.internal.m.f(message, "message");
        kotlin.jvm.internal.m.f(headers, "headers");
        this.request = request;
        this.protocol = protocol;
        this.message = message;
        this.code = i10;
        this.handshake = tVar;
        this.headers = headers;
        this.body = e0Var;
        this.networkResponse = d0Var;
        this.cacheResponse = d0Var2;
        this.priorResponse = d0Var3;
        this.sentRequestAtMillis = j10;
        this.receivedResponseAtMillis = j11;
        this.exchange = cVar;
    }

    public static /* synthetic */ String l(d0 d0Var, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return d0Var.k(str, str2);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final e0 getBody() {
        return this.body;
    }

    public final d b() {
        d dVar = this.lazyCacheControl;
        if (dVar != null) {
            return dVar;
        }
        d dVarB = d.INSTANCE.b(this.headers);
        this.lazyCacheControl = dVarB;
        return dVarB;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final d0 getCacheResponse() {
        return this.cacheResponse;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        e0 e0Var = this.body;
        if (e0Var == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        e0Var.close();
    }

    public final List<h> d() {
        String str;
        u uVar = this.headers;
        int i10 = this.code;
        if (i10 == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i10 != 407) {
                return kotlin.collections.r.l();
            }
            str = "Proxy-Authenticate";
        }
        return lb.e.a(uVar, str);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final okhttp3.internal.connection.c getExchange() {
        return this.exchange;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final t getHandshake() {
        return this.handshake;
    }

    public final String k(String name, String defaultValue) {
        kotlin.jvm.internal.m.f(name, "name");
        String strE = this.headers.e(name);
        return strE == null ? defaultValue : strE;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final u getHeaders() {
        return this.headers;
    }

    public final boolean n() {
        int i10 = this.code;
        return 200 <= i10 && i10 < 300;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final d0 getNetworkResponse() {
        return this.networkResponse;
    }

    public final a q() {
        return new a(this);
    }

    /* JADX INFO: renamed from: r, reason: from getter */
    public final d0 getPriorResponse() {
        return this.priorResponse;
    }

    /* JADX INFO: renamed from: s, reason: from getter */
    public final a0 getProtocol() {
        return this.protocol;
    }

    /* JADX INFO: renamed from: t, reason: from getter */
    public final long getReceivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.getUrl() + '}';
    }

    /* JADX INFO: renamed from: u, reason: from getter */
    public final b0 getRequest() {
        return this.request;
    }

    /* JADX INFO: renamed from: v, reason: from getter */
    public final long getSentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }
}
