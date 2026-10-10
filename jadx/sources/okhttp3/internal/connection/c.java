package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;
import okhttp3.e0;
import okhttp3.r;
import tb.n;
import tb.x;
import tb.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00020)B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\r\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u000e¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001d\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010#\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020%2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u000e¢\u0006\u0004\b(\u0010\u001bJ\r\u0010)\u001a\u00020\u000e¢\u0006\u0004\b)\u0010\u001bJ\r\u0010*\u001a\u00020\u000e¢\u0006\u0004\b*\u0010\u001bJ9\u00100\u001a\u00028\u0000\"\n\b\u0000\u0010+*\u0004\u0018\u00010\f2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00152\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020\u000e¢\u0006\u0004\b2\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b0\u00103\u001a\u0004\b4\u00105R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b)\u00106\u001a\u0004\b7\u00108R\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u00109\u001a\u0004\b:\u0010;R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010<R$\u0010A\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u00158\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\r\u0010>\u001a\u0004\b?\u0010@R$\u0010C\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u00158\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u001a\u0010>\u001a\u0004\bB\u0010@R\u001a\u0010H\u001a\u00020D8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b4\u0010E\u001a\u0004\bF\u0010GR\u0014\u0010J\u001a\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u0010@¨\u0006K"}, d2 = {"Lokhttp3/internal/connection/c;", "", "Lokhttp3/internal/connection/e;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/r;", "eventListener", "Lokhttp3/internal/connection/d;", "finder", "Llb/d;", "codec", "<init>", "(Lokhttp3/internal/connection/e;Lokhttp3/r;Lokhttp3/internal/connection/d;Llb/d;)V", "Ljava/io/IOException;", "e", "Lr8/z;", "t", "(Ljava/io/IOException;)V", "Lokhttp3/b0;", "request", "u", "(Lokhttp3/b0;)V", "", "duplex", "Ltb/x;", "c", "(Lokhttp3/b0;Z)Ltb/x;", "f", "()V", "s", "expectContinue", "Lokhttp3/d0$a;", "q", "(Z)Lokhttp3/d0$a;", "Lokhttp3/d0;", "response", "r", "(Lokhttp3/d0;)V", "Lokhttp3/e0;", "p", "(Lokhttp3/d0;)Lokhttp3/e0;", "n", "b", "d", ExifInterface.LONGITUDE_EAST, "", "bytesRead", "responseDone", "requestDone", "a", "(JZZLjava/io/IOException;)Ljava/io/IOException;", "o", "Lokhttp3/internal/connection/e;", "g", "()Lokhttp3/internal/connection/e;", "Lokhttp3/r;", "i", "()Lokhttp3/r;", "Lokhttp3/internal/connection/d;", "j", "()Lokhttp3/internal/connection/d;", "Llb/d;", "<set-?>", "Z", "m", "()Z", "isDuplex", "k", "hasFailure", "Lokhttp3/internal/connection/f;", "Lokhttp3/internal/connection/f;", "h", "()Lokhttp3/internal/connection/f;", "connection", "l", "isCoalescedConnection", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final e call;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final r eventListener;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final d finder;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final lb.d codec;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isDuplex;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasFailure;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final f connection;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u00028\u0000\"\n\b\u0000\u0010\t*\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u001a¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/connection/c$a;", "Ltb/h;", "Ltb/x;", "delegate", "", "contentLength", "<init>", "(Lokhttp3/internal/connection/c;Ltb/x;J)V", "Ljava/io/IOException;", ExifInterface.LONGITUDE_EAST, "e", "a", "(Ljava/io/IOException;)Ljava/io/IOException;", "Ltb/d;", "source", "byteCount", "Lr8/z;", "N", "(Ltb/d;J)V", "flush", "()V", "close", "b", "J", "", "c", "Z", "completed", "d", "bytesReceived", "closed", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class a extends tb.h {

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long contentLength;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean completed;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long bytesReceived;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean closed;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f16806f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, x delegate, long j10) {
            super(delegate);
            m.f(delegate, "delegate");
            this.f16806f = cVar;
            this.contentLength = j10;
        }

        private final <E extends IOException> E a(E e10) {
            if (this.completed) {
                return e10;
            }
            this.completed = true;
            return (E) this.f16806f.a(this.bytesReceived, false, true, e10);
        }

        @Override // tb.h, tb.x
        public void N(tb.d source, long byteCount) throws IOException {
            m.f(source, "source");
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            long j10 = this.contentLength;
            if (j10 == -1 || this.bytesReceived + byteCount <= j10) {
                try {
                    super.N(source, byteCount);
                    this.bytesReceived += byteCount;
                    return;
                } catch (IOException e10) {
                    throw a(e10);
                }
            }
            throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + byteCount));
        }

        @Override // tb.h, tb.x, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            long j10 = this.contentLength;
            if (j10 != -1 && this.bytesReceived != j10) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                a(null);
            } catch (IOException e10) {
                throw a(e10);
            }
        }

        @Override // tb.h, tb.x, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e10) {
                throw a(e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00028\u0000\"\n\b\u0000\u0010\u0011*\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001a¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/connection/c$b;", "Ltb/i;", "Ltb/z;", "delegate", "", "contentLength", "<init>", "(Lokhttp3/internal/connection/c;Ltb/z;J)V", "Ltb/d;", "sink", "byteCount", "D", "(Ltb/d;J)J", "Lr8/z;", "close", "()V", "Ljava/io/IOException;", ExifInterface.LONGITUDE_EAST, "e", "b", "(Ljava/io/IOException;)Ljava/io/IOException;", "J", "c", "bytesReceived", "", "d", "Z", "invokeStartEvent", "completed", "f", "closed", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class b extends tb.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long contentLength;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private long bytesReceived;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean invokeStartEvent;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean completed;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean closed;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f16812g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, z delegate, long j10) {
            super(delegate);
            m.f(delegate, "delegate");
            this.f16812g = cVar;
            this.contentLength = j10;
            this.invokeStartEvent = true;
            if (j10 == 0) {
                b(null);
            }
        }

        @Override // tb.i, tb.z
        public long D(tb.d sink, long byteCount) throws IOException {
            m.f(sink, "sink");
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            try {
                long jD = getDelegate().D(sink, byteCount);
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    this.f16812g.getEventListener().v(this.f16812g.getCall());
                }
                if (jD == -1) {
                    b(null);
                    return -1L;
                }
                long j10 = this.bytesReceived + jD;
                long j11 = this.contentLength;
                if (j11 != -1 && j10 > j11) {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j10);
                }
                this.bytesReceived = j10;
                if (j10 == j11) {
                    b(null);
                }
                return jD;
            } catch (IOException e10) {
                throw b(e10);
            }
        }

        public final <E extends IOException> E b(E e10) {
            if (this.completed) {
                return e10;
            }
            this.completed = true;
            if (e10 == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                this.f16812g.getEventListener().v(this.f16812g.getCall());
            }
            return (E) this.f16812g.a(this.bytesReceived, true, false, e10);
        }

        @Override // tb.i, tb.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                b(null);
            } catch (IOException e10) {
                throw b(e10);
            }
        }
    }

    private final void t(IOException e10) {
        this.hasFailure = true;
        this.finder.h(e10);
        this.codec.getConnection().H(this.call, e10);
    }

    public c(e call, r eventListener, d finder, lb.d codec) {
        m.f(call, "call");
        m.f(eventListener, "eventListener");
        m.f(finder, "finder");
        m.f(codec, "codec");
        this.call = call;
        this.eventListener = eventListener;
        this.finder = finder;
        this.codec = codec;
        this.connection = codec.getConnection();
    }

    public final <E extends IOException> E a(long bytesRead, boolean responseDone, boolean requestDone, E e10) {
        if (e10 != null) {
            t(e10);
        }
        if (requestDone) {
            if (e10 != null) {
                this.eventListener.r(this.call, e10);
            } else {
                this.eventListener.p(this.call, bytesRead);
            }
        }
        if (responseDone) {
            if (e10 != null) {
                this.eventListener.w(this.call, e10);
            } else {
                this.eventListener.u(this.call, bytesRead);
            }
        }
        return (E) this.call.u(this, requestDone, responseDone, e10);
    }

    public final void b() {
        this.codec.cancel();
    }

    public final x c(b0 request, boolean duplex) {
        m.f(request, "request");
        this.isDuplex = duplex;
        c0 body = request.getBody();
        m.c(body);
        long jA = body.a();
        this.eventListener.q(this.call);
        return new a(this, this.codec.g(request, jA), jA);
    }

    public final void d() {
        this.codec.cancel();
        this.call.u(this, true, true, null);
    }

    public final void e() {
        try {
            this.codec.a();
        } catch (IOException e10) {
            this.eventListener.r(this.call, e10);
            t(e10);
            throw e10;
        }
    }

    public final void f() {
        try {
            this.codec.e();
        } catch (IOException e10) {
            this.eventListener.r(this.call, e10);
            t(e10);
            throw e10;
        }
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final e getCall() {
        return this.call;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final f getConnection() {
        return this.connection;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final r getEventListener() {
        return this.eventListener;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final d getFinder() {
        return this.finder;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final boolean getHasFailure() {
        return this.hasFailure;
    }

    public final boolean l() {
        return !m.a(this.finder.getAddress().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String().getHost(), this.connection.getRoute().getAddress().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String().getHost());
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final boolean getIsDuplex() {
        return this.isDuplex;
    }

    public final void n() {
        this.codec.getConnection().z();
    }

    public final void o() {
        this.call.u(this, true, false, null);
    }

    public final e0 p(d0 response) throws IOException {
        m.f(response, "response");
        try {
            String strL = d0.l(response, "Content-Type", null, 2, null);
            long jF = this.codec.f(response);
            return new lb.h(strL, jF, n.b(new b(this, this.codec.c(response), jF)));
        } catch (IOException e10) {
            this.eventListener.w(this.call, e10);
            t(e10);
            throw e10;
        }
    }

    public final d0.a q(boolean expectContinue) {
        try {
            d0.a aVarD = this.codec.d(expectContinue);
            if (aVarD == null) {
                return aVarD;
            }
            aVarD.l(this);
            return aVarD;
        } catch (IOException e10) {
            this.eventListener.w(this.call, e10);
            t(e10);
            throw e10;
        }
    }

    public final void r(d0 response) {
        m.f(response, "response");
        this.eventListener.x(this.call, response);
    }

    public final void s() {
        this.eventListener.y(this.call);
    }

    public final void u(b0 request) {
        m.f(request, "request");
        try {
            this.eventListener.t(this.call);
            this.codec.b(request);
            this.eventListener.s(this.call, request);
        } catch (IOException e10) {
            this.eventListener.r(this.call, e10);
            t(e10);
            throw e10;
        }
    }
}
