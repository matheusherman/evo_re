package mb;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import lb.d;
import lb.i;
import lb.k;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.u;
import okhttp3.v;
import okhttp3.z;
import tb.a0;
import tb.j;
import tb.x;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 Q2\u00020\u0001:\u00070'-:/+#B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010#\u001a\u00020\f2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0010H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u001dH\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00102\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00122\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u001dH\u0016¢\u0006\u0004\b/\u0010&J\u000f\u00100\u001a\u00020\u001dH\u0016¢\u0006\u0004\b0\u0010&J\u001d\u00105\u001a\u00020\u001d2\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\u0019\u0010:\u001a\u0004\u0018\u0001092\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b:\u0010;J\u0015\u0010<\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b<\u0010=R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010>R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010?\u001a\u0004\b@\u0010AR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010BR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010CR\u0016\u0010F\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010ER\u0014\u0010I\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010HR\u0018\u0010K\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010JR\u0018\u0010N\u001a\u000207*\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0018\u0010N\u001a\u000207*\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010P¨\u0006R"}, d2 = {"Lmb/b;", "Llb/d;", "Lokhttp3/z;", "client", "Lokhttp3/internal/connection/f;", "connection", "Ltb/f;", "source", "Ltb/e;", "sink", "<init>", "(Lokhttp3/z;Lokhttp3/internal/connection/f;Ltb/f;Ltb/e;)V", "Ltb/x;", "t", "()Ltb/x;", "w", "", "length", "Ltb/z;", "v", "(J)Ltb/z;", "Lokhttp3/v;", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "u", "(Lokhttp3/v;)Ltb/z;", "x", "()Ltb/z;", "Ltb/j;", "timeout", "Lr8/z;", "q", "(Ltb/j;)V", "Lokhttp3/b0;", "request", "contentLength", "g", "(Lokhttp3/b0;J)Ltb/x;", "cancel", "()V", "b", "(Lokhttp3/b0;)V", "Lokhttp3/d0;", "response", "f", "(Lokhttp3/d0;)J", "c", "(Lokhttp3/d0;)Ltb/z;", "e", "a", "Lokhttp3/u;", "headers", "", "requestLine", "z", "(Lokhttp3/u;Ljava/lang/String;)V", "", "expectContinue", "Lokhttp3/d0$a;", "d", "(Z)Lokhttp3/d0$a;", "y", "(Lokhttp3/d0;)V", "Lokhttp3/z;", "Lokhttp3/internal/connection/f;", "getConnection", "()Lokhttp3/internal/connection/f;", "Ltb/f;", "Ltb/e;", "", "I", "state", "Lmb/a;", "Lmb/a;", "headersReader", "Lokhttp3/u;", "trailers", "s", "(Lokhttp3/d0;)Z", "isChunked", "r", "(Lokhttp3/b0;)Z", "h", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final z client;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final okhttp3.internal.connection.f connection;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final tb.f source;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final tb.e sink;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int state;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final mb.a headersReader;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private u trailers;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b¢\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\u00108\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00168\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u0011\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lmb/b$a;", "Ltb/z;", "<init>", "(Lmb/b;)V", "Ltb/a0;", "g", "()Ltb/a0;", "Ltb/d;", "sink", "", "byteCount", "D", "(Ltb/d;J)J", "Lr8/z;", "b", "()V", "Ltb/j;", "a", "Ltb/j;", "getTimeout", "()Ltb/j;", "timeout", "", "Z", "()Z", "c", "(Z)V", "closed", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private abstract class a implements tb.z {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final j timeout;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean closed;

        public a() {
            this.timeout = new j(b.this.source.getTimeout());
        }

        @Override // tb.z
        public long D(tb.d sink, long byteCount) throws IOException {
            m.f(sink, "sink");
            try {
                return b.this.source.D(sink, byteCount);
            } catch (IOException e10) {
                b.this.getConnection().z();
                b();
                throw e10;
            }
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        protected final boolean getClosed() {
            return this.closed;
        }

        public final void b() {
            if (b.this.state == 6) {
                return;
            }
            if (b.this.state == 5) {
                b.this.q(this.timeout);
                b.this.state = 6;
            } else {
                throw new IllegalStateException("state: " + b.this.state);
            }
        }

        protected final void c(boolean z10) {
            this.closed = z10;
        }

        @Override // tb.z
        /* JADX INFO: renamed from: g */
        public a0 getTimeout() {
            return this.timeout;
        }
    }

    /* JADX INFO: renamed from: mb.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lmb/b$b;", "Ltb/x;", "<init>", "(Lmb/b;)V", "Ltb/a0;", "g", "()Ltb/a0;", "Ltb/d;", "source", "", "byteCount", "Lr8/z;", "N", "(Ltb/d;J)V", "flush", "()V", "close", "Ltb/j;", "a", "Ltb/j;", "timeout", "", "b", "Z", "closed", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class C0305b implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final j timeout;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean closed;

        @Override // tb.x, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            b.this.sink.T("0\r\n\r\n");
            b.this.q(this.timeout);
            b.this.state = 3;
        }

        @Override // tb.x, java.io.Flushable
        public synchronized void flush() {
            if (this.closed) {
                return;
            }
            b.this.sink.flush();
        }

        public C0305b() {
            this.timeout = new j(b.this.sink.getTimeout());
        }

        @Override // tb.x
        public void N(tb.d source, long byteCount) {
            m.f(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (byteCount == 0) {
                return;
            }
            b.this.sink.W(byteCount);
            b.this.sink.T("\r\n");
            b.this.sink.N(source, byteCount);
            b.this.sink.T("\r\n");
        }

        @Override // tb.x
        /* JADX INFO: renamed from: g */
        public a0 getTimeout() {
            return this.timeout;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\tR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lmb/b$c;", "Lmb/b$a;", "Lmb/b;", "Lokhttp3/v;", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "<init>", "(Lmb/b;Lokhttp3/v;)V", "Lr8/z;", "d", "()V", "Ltb/d;", "sink", "", "byteCount", "D", "(Ltb/d;J)J", "close", "Lokhttp3/v;", "e", "J", "bytesRemainingInChunk", "", "f", "Z", "hasMoreChunks", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class c extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final v url;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long bytesRemainingInChunk;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean hasMoreChunks;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f15715g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, v url) {
            super();
            m.f(url, "url");
            this.f15715g = bVar;
            this.url = url;
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
        }

        private final void d() throws ProtocolException {
            if (this.bytesRemainingInChunk != -1) {
                this.f15715g.source.Y();
            }
            try {
                this.bytesRemainingInChunk = this.f15715g.source.g0();
                String string = n.Q0(this.f15715g.source.Y()).toString();
                if (this.bytesRemainingInChunk < 0 || (string.length() > 0 && !n.I(string, ";", false, 2, null))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + string + '\"');
                }
                if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    b bVar = this.f15715g;
                    bVar.trailers = bVar.headersReader.a();
                    z zVar = this.f15715g.client;
                    m.c(zVar);
                    okhttp3.n cookieJar = zVar.getCookieJar();
                    v vVar = this.url;
                    u uVar = this.f15715g.trailers;
                    m.c(uVar);
                    lb.e.f(cookieJar, vVar, uVar);
                    b();
                }
            } catch (NumberFormatException e10) {
                throw new ProtocolException(e10.getMessage());
            }
        }

        @Override // mb.b.a, tb.z
        public long D(tb.d sink, long byteCount) throws IOException {
            m.f(sink, "sink");
            if (byteCount < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            if (getClosed()) {
                throw new IllegalStateException("closed");
            }
            if (!this.hasMoreChunks) {
                return -1L;
            }
            long j10 = this.bytesRemainingInChunk;
            if (j10 == 0 || j10 == -1) {
                d();
                if (!this.hasMoreChunks) {
                    return -1L;
                }
            }
            long jD = super.D(sink, Math.min(byteCount, this.bytesRemainingInChunk));
            if (jD != -1) {
                this.bytesRemainingInChunk -= jD;
                return jD;
            }
            this.f15715g.getConnection().z();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            b();
            throw protocolException;
        }

        @Override // tb.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.hasMoreChunks && !hb.d.s(this, 100, TimeUnit.MILLISECONDS)) {
                this.f15715g.getConnection().z();
                b();
            }
            c(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lmb/b$e;", "Lmb/b$a;", "Lmb/b;", "", "bytesRemaining", "<init>", "(Lmb/b;J)V", "Ltb/d;", "sink", "byteCount", "D", "(Ltb/d;J)J", "Lr8/z;", "close", "()V", "d", "J", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class e extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long bytesRemaining;

        public e(long j10) {
            super();
            this.bytesRemaining = j10;
            if (j10 == 0) {
                b();
            }
        }

        @Override // mb.b.a, tb.z
        public long D(tb.d sink, long byteCount) throws IOException {
            m.f(sink, "sink");
            if (byteCount < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            if (getClosed()) {
                throw new IllegalStateException("closed");
            }
            long j10 = this.bytesRemaining;
            if (j10 == 0) {
                return -1L;
            }
            long jD = super.D(sink, Math.min(j10, byteCount));
            if (jD == -1) {
                b.this.getConnection().z();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                b();
                throw protocolException;
            }
            long j11 = this.bytesRemaining - jD;
            this.bytesRemaining = j11;
            if (j11 == 0) {
                b();
            }
            return jD;
        }

        @Override // tb.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.bytesRemaining != 0 && !hb.d.s(this, 100, TimeUnit.MILLISECONDS)) {
                b.this.getConnection().z();
                b();
            }
            c(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lmb/b$f;", "Ltb/x;", "<init>", "(Lmb/b;)V", "Ltb/a0;", "g", "()Ltb/a0;", "Ltb/d;", "source", "", "byteCount", "Lr8/z;", "N", "(Ltb/d;J)V", "flush", "()V", "close", "Ltb/j;", "a", "Ltb/j;", "timeout", "", "b", "Z", "closed", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class f implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final j timeout;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean closed;

        public f() {
            this.timeout = new j(b.this.sink.getTimeout());
        }

        @Override // tb.x
        public void N(tb.d source, long byteCount) {
            m.f(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            hb.d.l(source.getSize(), 0L, byteCount);
            b.this.sink.N(source, byteCount);
        }

        @Override // tb.x, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            b.this.q(this.timeout);
            b.this.state = 3;
        }

        @Override // tb.x, java.io.Flushable
        public void flush() {
            if (this.closed) {
                return;
            }
            b.this.sink.flush();
        }

        @Override // tb.x
        /* JADX INFO: renamed from: g */
        public a0 getTimeout() {
            return this.timeout;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lmb/b$g;", "Lmb/b$a;", "Lmb/b;", "<init>", "(Lmb/b;)V", "Ltb/d;", "sink", "", "byteCount", "D", "(Ltb/d;J)J", "Lr8/z;", "close", "()V", "", "d", "Z", "inputExhausted", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class g extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean inputExhausted;

        public g() {
            super();
        }

        @Override // mb.b.a, tb.z
        public long D(tb.d sink, long byteCount) throws IOException {
            m.f(sink, "sink");
            if (byteCount < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            if (getClosed()) {
                throw new IllegalStateException("closed");
            }
            if (this.inputExhausted) {
                return -1L;
            }
            long jD = super.D(sink, byteCount);
            if (jD != -1) {
                return jD;
            }
            this.inputExhausted = true;
            b();
            return -1L;
        }

        @Override // tb.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (!this.inputExhausted) {
                b();
            }
            c(true);
        }
    }

    private final boolean s(d0 d0Var) {
        return n.w("chunked", d0.l(d0Var, "Transfer-Encoding", null, 2, null), true);
    }

    public b(z zVar, okhttp3.internal.connection.f connection, tb.f source, tb.e sink) {
        m.f(connection, "connection");
        m.f(source, "source");
        m.f(sink, "sink");
        this.client = zVar;
        this.connection = connection;
        this.source = source;
        this.sink = sink;
        this.headersReader = new mb.a(source);
    }

    private final boolean r(b0 b0Var) {
        return n.w("chunked", b0Var.d("Transfer-Encoding"), true);
    }

    private final x t() {
        if (this.state == 1) {
            this.state = 2;
            return new C0305b();
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final tb.z u(v url) {
        if (this.state == 4) {
            this.state = 5;
            return new c(this, url);
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final tb.z v(long length) {
        if (this.state == 4) {
            this.state = 5;
            return new e(length);
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final x w() {
        if (this.state == 1) {
            this.state = 2;
            return new f();
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final tb.z x() {
        if (this.state == 4) {
            this.state = 5;
            getConnection().z();
            return new g();
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    @Override // lb.d
    public void a() {
        this.sink.flush();
    }

    @Override // lb.d
    public void b(b0 request) {
        m.f(request, "request");
        i iVar = i.f15353a;
        Proxy.Type type = getConnection().getRoute().getProxy().type();
        m.e(type, "connection.route().proxy.type()");
        z(request.getHeaders(), iVar.a(request, type));
    }

    @Override // lb.d
    public tb.z c(d0 response) {
        m.f(response, "response");
        if (!lb.e.b(response)) {
            return v(0L);
        }
        if (s(response)) {
            return u(response.getRequest().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String());
        }
        long jV = hb.d.v(response);
        return jV != -1 ? v(jV) : x();
    }

    @Override // lb.d
    public d0.a d(boolean expectContinue) {
        int i10 = this.state;
        if (i10 != 1 && i10 != 2 && i10 != 3) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        try {
            k kVarA = k.INSTANCE.a(this.headersReader.b());
            d0.a aVarK = new d0.a().p(kVarA.protocol).g(kVarA.code).m(kVarA.message).k(this.headersReader.a());
            if (expectContinue && kVarA.code == 100) {
                return null;
            }
            int i11 = kVarA.code;
            if (i11 == 100) {
                this.state = 3;
                return aVarK;
            }
            if (102 > i11 || i11 >= 200) {
                this.state = 4;
                return aVarK;
            }
            this.state = 3;
            return aVarK;
        } catch (EOFException e10) {
            throw new IOException("unexpected end of stream on " + getConnection().getRoute().getAddress().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String().r(), e10);
        }
    }

    @Override // lb.d
    public void e() {
        this.sink.flush();
    }

    @Override // lb.d
    public long f(d0 response) {
        m.f(response, "response");
        if (!lb.e.b(response)) {
            return 0L;
        }
        if (s(response)) {
            return -1L;
        }
        return hb.d.v(response);
    }

    @Override // lb.d
    public x g(b0 request, long contentLength) throws ProtocolException {
        m.f(request, "request");
        if (request.getBody() != null && request.getBody().g()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (r(request)) {
            return t();
        }
        if (contentLength != -1) {
            return w();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // lb.d
    public okhttp3.internal.connection.f getConnection() {
        return this.connection;
    }

    public final void y(d0 response) {
        m.f(response, "response");
        long jV = hb.d.v(response);
        if (jV == -1) {
            return;
        }
        tb.z zVarV = v(jV);
        hb.d.L(zVarV, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        zVarV.close();
    }

    public final void z(u headers, String requestLine) {
        m.f(headers, "headers");
        m.f(requestLine, "requestLine");
        if (this.state != 0) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.sink.T(requestLine).T("\r\n");
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.sink.T(headers.f(i10)).T(": ").T(headers.k(i10)).T("\r\n");
        }
        this.sink.T("\r\n");
        this.state = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(j timeout) {
        a0 delegate = timeout.getDelegate();
        timeout.j(a0.f19021e);
        delegate.a();
        delegate.b();
    }

    @Override // lb.d
    public void cancel() {
        getConnection().e();
    }
}
