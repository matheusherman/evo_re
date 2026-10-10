package nb;

import androidx.exifinterface.media.ExifInterface;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import kotlin.Metadata;
import okhttp3.u;
import r8.z;
import tb.a0;
import tb.x;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 T2\u00020\u0001:\u0004.*0\u001eB3\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b \u0010!J\u001d\u0010%\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0002¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b)\u0010!J\u000f\u0010*\u001a\u00020\u001dH\u0000¢\u0006\u0004\b*\u0010+J\u0015\u0010.\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u001dH\u0000¢\u0006\u0004\b0\u0010+J\u000f\u00101\u001a\u00020\u001dH\u0000¢\u0006\u0004\b1\u0010+R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b.\u00102\u001a\u0004\b3\u00104R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b*\u00105\u001a\u0004\b6\u00107R*\u0010=\u001a\u00020,2\u0006\u00108\u001a\u00020,8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010/R*\u0010@\u001a\u00020,2\u0006\u00108\u001a\u00020,8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u00109\u001a\u0004\b>\u0010;\"\u0004\b?\u0010/R*\u0010C\u001a\u00020,2\u0006\u00108\u001a\u00020,8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u00109\u001a\u0004\bA\u0010;\"\u0004\bB\u0010/R*\u0010F\u001a\u00020,2\u0006\u00108\u001a\u00020,8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b \u00109\u001a\u0004\bD\u0010;\"\u0004\bE\u0010/R\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\t0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010HR\u0016\u0010L\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u001e\u0010#\u001a\u00060MR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u001e\u0010V\u001a\u00060RR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b3\u0010S\u001a\u0004\bT\u0010UR\u001e\u0010[\u001a\u00060WR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b>\u0010X\u001a\u0004\bY\u0010ZR\u001e\u0010]\u001a\u00060WR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b:\u0010X\u001a\u0004\b\\\u0010ZR$\u0010\u000e\u001a\u0004\u0018\u00010\r8@@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bY\u0010^\u001a\u0004\bJ\u0010_\"\u0004\b`\u0010!R$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010a\u001a\u0004\bN\u0010b\"\u0004\bc\u0010dR\u0011\u0010g\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\be\u0010fR\u0011\u0010i\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bh\u0010f¨\u0006j"}, d2 = {"Lnb/i;", "", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "Lnb/f;", "connection", "", "outFinished", "inFinished", "Lokhttp3/u;", "headers", "<init>", "(ILnb/f;ZZLokhttp3/u;)V", "Lnb/b;", "errorCode", "Ljava/io/IOException;", "errorException", "e", "(Lnb/b;Ljava/io/IOException;)Z", "C", "()Lokhttp3/u;", "Ltb/a0;", "v", "()Ltb/a0;", ExifInterface.LONGITUDE_EAST, "Ltb/x;", "n", "()Ltb/x;", "rstStatusCode", "Lr8/z;", "d", "(Lnb/b;Ljava/io/IOException;)V", "f", "(Lnb/b;)V", "Ltb/f;", "source", "length", "w", "(Ltb/f;I)V", "x", "(Lokhttp3/u;Z)V", "y", "b", "()V", "", "delta", "a", "(J)V", "c", "D", "I", "j", "()I", "Lnb/f;", "g", "()Lnb/f;", "<set-?>", "J", "l", "()J", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "readBytesTotal", "k", "z", "readBytesAcknowledged", "r", "B", "writeBytesTotal", "q", "setWriteBytesMaximum$okhttp", "writeBytesMaximum", "Ljava/util/ArrayDeque;", "Ljava/util/ArrayDeque;", "headersQueue", "h", "Z", "hasResponseHeaders", "Lnb/i$c;", "i", "Lnb/i$c;", "p", "()Lnb/i$c;", "Lnb/i$b;", "Lnb/i$b;", "o", "()Lnb/i$b;", "sink", "Lnb/i$d;", "Lnb/i$d;", "m", "()Lnb/i$d;", "readTimeout", "s", "writeTimeout", "Lnb/b;", "()Lnb/b;", "setErrorCode$okhttp", "Ljava/io/IOException;", "()Ljava/io/IOException;", "setErrorException$okhttp", "(Ljava/io/IOException;)V", "u", "()Z", "isOpen", "t", "isLocallyInitiated", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int id;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final f connection;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long readBytesTotal;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long readBytesAcknowledged;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long writeBytesTotal;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long writeBytesMaximum;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final ArrayDeque<u> headersQueue;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasResponseHeaders;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final c source;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final b sink;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final d readTimeout;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final d writeTimeout;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private nb.b errorCode;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private IOException errorException;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\tR\u0014\u0010\u001c\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010#\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018\"\u0004\b%\u0010\t¨\u0006'"}, d2 = {"Lnb/i$b;", "Ltb/x;", "", "finished", "<init>", "(Lnb/i;Z)V", "outFinishedOnLastFrame", "Lr8/z;", "a", "(Z)V", "Ltb/d;", "source", "", "byteCount", "N", "(Ltb/d;J)V", "flush", "()V", "Ltb/a0;", "g", "()Ltb/a0;", "close", "Z", "c", "()Z", "setFinished", "b", "Ltb/d;", "sendBuffer", "Lokhttp3/u;", "Lokhttp3/u;", "getTrailers", "()Lokhttp3/u;", "setTrailers", "(Lokhttp3/u;)V", "trailers", "d", "setClosed", "closed", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class b implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean finished;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final tb.d sendBuffer = new tb.d();

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private u trailers;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean closed;

        public b(boolean z10) {
            this.finished = z10;
        }

        private final void a(boolean outFinishedOnLastFrame) throws IOException {
            long jMin;
            boolean z10;
            i iVar = i.this;
            synchronized (iVar) {
                try {
                    iVar.getWriteTimeout().v();
                    while (iVar.getWriteBytesTotal() >= iVar.getWriteBytesMaximum() && !this.finished && !this.closed && iVar.h() == null) {
                        try {
                            iVar.D();
                        } catch (Throwable th) {
                            iVar.getWriteTimeout().C();
                            throw th;
                        }
                    }
                    iVar.getWriteTimeout().C();
                    iVar.c();
                    jMin = Math.min(iVar.getWriteBytesMaximum() - iVar.getWriteBytesTotal(), this.sendBuffer.getSize());
                    iVar.B(iVar.getWriteBytesTotal() + jMin);
                    z10 = outFinishedOnLastFrame && jMin == this.sendBuffer.getSize();
                    z zVar = z.f17874a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            i.this.getWriteTimeout().v();
            try {
                i.this.getConnection().r0(i.this.getId(), z10, this.sendBuffer, jMin);
            } finally {
                i.this.getWriteTimeout().C();
            }
        }

        @Override // tb.x
        public void N(tb.d source, long byteCount) throws IOException {
            kotlin.jvm.internal.m.f(source, "source");
            i iVar = i.this;
            if (!hb.d.f10920h || !Thread.holdsLock(iVar)) {
                this.sendBuffer.N(source, byteCount);
                while (this.sendBuffer.getSize() >= 16384) {
                    a(false);
                }
            } else {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + iVar);
            }
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final boolean getClosed() {
            return this.closed;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final boolean getFinished() {
            return this.finished;
        }

        @Override // tb.x, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            i iVar = i.this;
            if (hb.d.f10920h && Thread.holdsLock(iVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + iVar);
            }
            i iVar2 = i.this;
            synchronized (iVar2) {
                if (this.closed) {
                    return;
                }
                boolean z10 = iVar2.h() == null;
                z zVar = z.f17874a;
                if (!i.this.getSink().finished) {
                    boolean z11 = this.sendBuffer.getSize() > 0;
                    if (this.trailers != null) {
                        while (this.sendBuffer.getSize() > 0) {
                            a(false);
                        }
                        f connection = i.this.getConnection();
                        int id2 = i.this.getId();
                        u uVar = this.trailers;
                        kotlin.jvm.internal.m.c(uVar);
                        connection.s0(id2, z10, hb.d.O(uVar));
                    } else if (z11) {
                        while (this.sendBuffer.getSize() > 0) {
                            a(true);
                        }
                    } else if (z10) {
                        i.this.getConnection().r0(i.this.getId(), true, null, 0L);
                    }
                }
                synchronized (i.this) {
                    this.closed = true;
                    z zVar2 = z.f17874a;
                }
                i.this.getConnection().flush();
                i.this.b();
            }
        }

        @Override // tb.x, java.io.Flushable
        public void flush() throws IOException {
            i iVar = i.this;
            if (hb.d.f10920h && Thread.holdsLock(iVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + iVar);
            }
            i iVar2 = i.this;
            synchronized (iVar2) {
                iVar2.c();
                z zVar = z.f17874a;
            }
            while (this.sendBuffer.getSize() > 0) {
                a(false);
                i.this.getConnection().flush();
            }
        }

        @Override // tb.x
        /* JADX INFO: renamed from: g */
        public a0 getTimeout() {
            return i.this.getWriteTimeout();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u0005\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u0017\u0010$\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010&\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u001f\u0010!\u001a\u0004\b%\u0010#R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00100\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001d\u001a\u0004\b\u001a\u0010\u001e\"\u0004\b/\u0010 ¨\u00061"}, d2 = {"Lnb/i$c;", "Ltb/z;", "", "maxByteCount", "", "finished", "<init>", "(Lnb/i;JZ)V", "read", "Lr8/z;", "i", "(J)V", "Ltb/d;", "sink", "byteCount", "D", "(Ltb/d;J)J", "Ltb/f;", "source", "c", "(Ltb/f;J)V", "Ltb/a0;", "g", "()Ltb/a0;", "close", "()V", "a", "J", "b", "Z", "()Z", "d", "(Z)V", "Ltb/d;", "getReceiveBuffer", "()Ltb/d;", "receiveBuffer", "getReadBuffer", "readBuffer", "Lokhttp3/u;", "e", "Lokhttp3/u;", "getTrailers", "()Lokhttp3/u;", "f", "(Lokhttp3/u;)V", "trailers", "setClosed$okhttp", "closed", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class c implements tb.z {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long maxByteCount;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean finished;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final tb.d receiveBuffer = new tb.d();

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final tb.d readBuffer = new tb.d();

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private u trailers;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean closed;

        public c(long j10, boolean z10) {
            this.maxByteCount = j10;
            this.finished = z10;
        }

        private final void i(long read) {
            i iVar = i.this;
            if (!hb.d.f10920h || !Thread.holdsLock(iVar)) {
                i.this.getConnection().q0(read);
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + iVar);
        }

        @Override // tb.z
        public long D(tb.d sink, long byteCount) throws IOException {
            IOException errorException;
            boolean z10;
            long jD;
            kotlin.jvm.internal.m.f(sink, "sink");
            long j10 = 0;
            if (byteCount < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            while (true) {
                i iVar = i.this;
                synchronized (iVar) {
                    iVar.getReadTimeout().v();
                    try {
                        if (iVar.h() == null || this.finished) {
                            errorException = null;
                        } else {
                            errorException = iVar.getErrorException();
                            if (errorException == null) {
                                nb.b bVarH = iVar.h();
                                kotlin.jvm.internal.m.c(bVarH);
                                errorException = new n(bVarH);
                            }
                        }
                        if (this.closed) {
                            throw new IOException("stream closed");
                        }
                        z10 = false;
                        if (this.readBuffer.getSize() > j10) {
                            tb.d dVar = this.readBuffer;
                            jD = dVar.D(sink, Math.min(byteCount, dVar.getSize()));
                            iVar.A(iVar.getReadBytesTotal() + jD);
                            long readBytesTotal = iVar.getReadBytesTotal() - iVar.getReadBytesAcknowledged();
                            if (errorException == null && readBytesTotal >= iVar.getConnection().getOkHttpSettings().c() / 2) {
                                iVar.getConnection().w0(iVar.getId(), readBytesTotal);
                                iVar.z(iVar.getReadBytesTotal());
                            }
                        } else {
                            if (!this.finished && errorException == null) {
                                iVar.D();
                                z10 = true;
                            }
                            jD = -1;
                        }
                        iVar.getReadTimeout().C();
                        z zVar = z.f17874a;
                    } catch (Throwable th) {
                        iVar.getReadTimeout().C();
                        throw th;
                    }
                    throw th;
                }
                if (!z10) {
                    if (jD != -1) {
                        return jD;
                    }
                    if (errorException == null) {
                        return -1L;
                    }
                    throw errorException;
                }
                j10 = 0;
            }
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final boolean getClosed() {
            return this.closed;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final boolean getFinished() {
            return this.finished;
        }

        public final void c(tb.f source, long byteCount) throws EOFException {
            boolean z10;
            boolean z11;
            kotlin.jvm.internal.m.f(source, "source");
            i iVar = i.this;
            if (hb.d.f10920h && Thread.holdsLock(iVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + iVar);
            }
            long j10 = byteCount;
            while (j10 > 0) {
                synchronized (i.this) {
                    z10 = this.finished;
                    z11 = this.readBuffer.getSize() + j10 > this.maxByteCount;
                    z zVar = z.f17874a;
                }
                if (z11) {
                    source.skip(j10);
                    i.this.f(nb.b.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z10) {
                    source.skip(j10);
                    return;
                }
                long jD = source.D(this.receiveBuffer, j10);
                if (jD == -1) {
                    throw new EOFException();
                }
                j10 -= jD;
                i iVar2 = i.this;
                synchronized (iVar2) {
                    try {
                        if (this.closed) {
                            this.receiveBuffer.a();
                        } else {
                            boolean z12 = this.readBuffer.getSize() == 0;
                            this.readBuffer.H(this.receiveBuffer);
                            if (z12) {
                                kotlin.jvm.internal.m.d(iVar2, "null cannot be cast to non-null type java.lang.Object");
                                iVar2.notifyAll();
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            i(byteCount);
        }

        @Override // tb.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long size;
            i iVar = i.this;
            synchronized (iVar) {
                this.closed = true;
                size = this.readBuffer.getSize();
                this.readBuffer.a();
                kotlin.jvm.internal.m.d(iVar, "null cannot be cast to non-null type java.lang.Object");
                iVar.notifyAll();
                z zVar = z.f17874a;
            }
            if (size > 0) {
                i(size);
            }
            i.this.b();
        }

        public final void d(boolean z10) {
            this.finished = z10;
        }

        public final void f(u uVar) {
            this.trailers = uVar;
        }

        @Override // tb.z
        /* JADX INFO: renamed from: g */
        public a0 getTimeout() {
            return i.this.getReadTimeout();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0006¨\u0006\f"}, d2 = {"Lnb/i$d;", "Ltb/c;", "<init>", "(Lnb/i;)V", "Lr8/z;", "B", "()V", "Ljava/io/IOException;", "cause", "x", "(Ljava/io/IOException;)Ljava/io/IOException;", "C", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class d extends tb.c {
        public d() {
        }

        @Override // tb.c
        protected void B() {
            i.this.f(nb.b.CANCEL);
            i.this.getConnection().k0();
        }

        @Override // tb.c
        protected IOException x(IOException cause) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (cause != null) {
                socketTimeoutException.initCause(cause);
            }
            return socketTimeoutException;
        }

        public final void C() throws IOException {
            if (!w()) {
            } else {
                throw x(null);
            }
        }
    }

    public final synchronized u C() {
        u uVarRemoveFirst;
        this.readTimeout.v();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            try {
                D();
            } catch (Throwable th) {
                this.readTimeout.C();
                throw th;
            }
        }
        this.readTimeout.C();
        if (this.headersQueue.isEmpty()) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            nb.b bVar = this.errorCode;
            kotlin.jvm.internal.m.c(bVar);
            throw new n(bVar);
        }
        uVarRemoveFirst = this.headersQueue.removeFirst();
        kotlin.jvm.internal.m.e(uVarRemoveFirst, "headersQueue.removeFirst()");
        return uVarRemoveFirst;
    }

    public final synchronized nb.b h() {
        return this.errorCode;
    }

    public final x n() {
        synchronized (this) {
            try {
                if (!this.hasResponseHeaders && !t()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
                z zVar = z.f17874a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.sink;
    }

    public final synchronized boolean u() {
        try {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.getFinished() || this.source.getClosed()) {
                if ((this.sink.getFinished() || this.sink.getClosed()) && this.hasResponseHeaders) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void y(nb.b errorCode) {
        kotlin.jvm.internal.m.f(errorCode, "errorCode");
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            kotlin.jvm.internal.m.d(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public i(int i10, f connection, boolean z10, boolean z11, u uVar) {
        kotlin.jvm.internal.m.f(connection, "connection");
        this.id = i10;
        this.connection = connection;
        this.writeBytesMaximum = connection.getPeerSettings().c();
        ArrayDeque<u> arrayDeque = new ArrayDeque<>();
        this.headersQueue = arrayDeque;
        this.source = new c(connection.getOkHttpSettings().c(), z11);
        this.sink = new b(z10);
        this.readTimeout = new d();
        this.writeTimeout = new d();
        if (uVar == null) {
            if (!t()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (t()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(uVar);
        }
    }

    private final boolean e(nb.b errorCode, IOException errorException) {
        if (hb.d.f10920h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            this.errorCode = errorCode;
            this.errorException = errorException;
            kotlin.jvm.internal.m.d(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            if (this.source.getFinished() && this.sink.getFinished()) {
                return false;
            }
            z zVar = z.f17874a;
            this.connection.j0(this.id);
            return true;
        }
    }

    public final void A(long j10) {
        this.readBytesTotal = j10;
    }

    public final void B(long j10) {
        this.writeBytesTotal = j10;
    }

    public final void D() throws InterruptedIOException {
        try {
            kotlin.jvm.internal.m.d(this, "null cannot be cast to non-null type java.lang.Object");
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final a0 E() {
        return this.writeTimeout;
    }

    public final void a(long delta) {
        this.writeBytesMaximum += delta;
        if (delta > 0) {
            kotlin.jvm.internal.m.d(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final void b() {
        boolean z10;
        boolean zU;
        if (hb.d.f10920h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                z10 = !this.source.getFinished() && this.source.getClosed() && (this.sink.getFinished() || this.sink.getClosed());
                zU = u();
                z zVar = z.f17874a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z10) {
            d(nb.b.CANCEL, null);
        } else {
            if (zU) {
                return;
            }
            this.connection.j0(this.id);
        }
    }

    public final void c() throws IOException {
        if (this.sink.getClosed()) {
            throw new IOException("stream closed");
        }
        if (this.sink.getFinished()) {
            throw new IOException("stream finished");
        }
        if (this.errorCode != null) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            nb.b bVar = this.errorCode;
            kotlin.jvm.internal.m.c(bVar);
            throw new n(bVar);
        }
    }

    public final void d(nb.b rstStatusCode, IOException errorException) {
        kotlin.jvm.internal.m.f(rstStatusCode, "rstStatusCode");
        if (e(rstStatusCode, errorException)) {
            this.connection.u0(this.id, rstStatusCode);
        }
    }

    public final void f(nb.b errorCode) {
        kotlin.jvm.internal.m.f(errorCode, "errorCode");
        if (e(errorCode, null)) {
            this.connection.v0(this.id, errorCode);
        }
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final f getConnection() {
        return this.connection;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final IOException getErrorException() {
        return this.errorException;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final d getReadTimeout() {
        return this.readTimeout;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final b getSink() {
        return this.sink;
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final c getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: q, reason: from getter */
    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    /* JADX INFO: renamed from: r, reason: from getter */
    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    /* JADX INFO: renamed from: s, reason: from getter */
    public final d getWriteTimeout() {
        return this.writeTimeout;
    }

    public final boolean t() {
        return this.connection.getClient() == ((this.id & 1) == 1);
    }

    public final a0 v() {
        return this.readTimeout;
    }

    public final void w(tb.f source, int length) {
        kotlin.jvm.internal.m.f(source, "source");
        if (!hb.d.f10920h || !Thread.holdsLock(this)) {
            this.source.c(source, length);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void x(u headers, boolean inFinished) {
        boolean zU;
        kotlin.jvm.internal.m.f(headers, "headers");
        if (hb.d.f10920h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                if (this.hasResponseHeaders && inFinished) {
                    this.source.f(headers);
                } else {
                    this.hasResponseHeaders = true;
                    this.headersQueue.add(headers);
                }
                if (inFinished) {
                    this.source.d(true);
                }
                zU = u();
                kotlin.jvm.internal.m.d(this, "null cannot be cast to non-null type java.lang.Object");
                notifyAll();
                z zVar = z.f17874a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zU) {
            return;
        }
        this.connection.j0(this.id);
    }

    public final void z(long j10) {
        this.readBytesAcknowledged = j10;
    }
}
