package nb;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0012\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 N2\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0019\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u0010J\u001d\u0010\u001e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\b¢\u0006\u0004\b \u0010!J/\u0010%\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b%\u0010&J/\u0010)\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010#2\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b)\u0010*J\u0015\u0010,\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0011¢\u0006\u0004\b,\u0010\u0014J%\u00100\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b¢\u0006\u0004\b0\u00101J%\u00105\u001a\u00020\f2\u0006\u00102\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\u001d\u00108\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u00107\u001a\u00020\n¢\u0006\u0004\b8\u0010\u000eJ-\u0010;\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\fH\u0016¢\u0006\u0004\b=\u0010\u0010J+\u0010?\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b?\u0010@R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010AR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010BR\u0014\u0010D\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010CR\u0016\u0010F\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010ER\u0016\u0010H\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010BR\u0017\u0010M\u001a\u00020I8\u0006¢\u0006\f\n\u0004\b;\u0010J\u001a\u0004\bK\u0010L¨\u0006O"}, d2 = {"Lnb/j;", "Ljava/io/Closeable;", "Ltb/e;", "sink", "", "client", "<init>", "(Ltb/e;Z)V", "", "streamId", "", "byteCount", "Lr8/z;", "q", "(IJ)V", "b", "()V", "Lnb/m;", "peerSettings", "a", "(Lnb/m;)V", "promisedStreamId", "", "Lnb/c;", "requestHeaders", "m", "(IILjava/util/List;)V", "flush", "Lnb/b;", "errorCode", "n", "(ILnb/b;)V", "k", "()I", "outFinished", "Ltb/d;", "source", "c", "(ZILtb/d;I)V", "flags", "buffer", "d", "(IILtb/d;I)V", "settings", "o", "ack", "payload1", "payload2", "l", "(ZII)V", "lastGoodStreamId", "", "debugData", "i", "(ILnb/b;[B)V", "windowSizeIncrement", "p", "length", IjkMediaMeta.IJKM_KEY_TYPE, "f", "(IIII)V", "close", "headerBlock", "j", "(ZILjava/util/List;)V", "Ltb/e;", "Z", "Ltb/d;", "hpackBuffer", "I", "maxFrameSize", "e", "closed", "Lnb/d$b;", "Lnb/d$b;", "getHpackWriter", "()Lnb/d$b;", "hpackWriter", "g", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class j implements Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Logger f16284h = Logger.getLogger(e.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final tb.e sink;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean client;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final tb.d hpackBuffer;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int maxFrameSize;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean closed;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final d.b hpackWriter;

    public final synchronized void a(m peerSettings) {
        try {
            kotlin.jvm.internal.m.f(peerSettings, "peerSettings");
            if (this.closed) {
                throw new IOException("closed");
            }
            this.maxFrameSize = peerSettings.e(this.maxFrameSize);
            if (peerSettings.b() != -1) {
                this.hpackWriter.e(peerSettings.b());
            }
            f(0, 0, 4, 1);
            this.sink.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b() {
        try {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (this.client) {
                Logger logger = f16284h;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(hb.d.t(">> CONNECTION " + e.CONNECTION_PREFACE.o(), new Object[0]));
                }
                this.sink.Q(e.CONNECTION_PREFACE);
                this.sink.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c(boolean outFinished, int streamId, tb.d source, int byteCount) {
        if (this.closed) {
            throw new IOException("closed");
        }
        d(streamId, outFinished ? 1 : 0, source, byteCount);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.closed = true;
        this.sink.close();
    }

    public final void d(int streamId, int flags, tb.d buffer, int byteCount) {
        f(streamId, byteCount, 0, flags);
        if (byteCount > 0) {
            tb.e eVar = this.sink;
            kotlin.jvm.internal.m.c(buffer);
            eVar.N(buffer, byteCount);
        }
    }

    public final synchronized void flush() {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.sink.flush();
    }

    public final synchronized void i(int lastGoodStreamId, b errorCode, byte[] debugData) {
        try {
            kotlin.jvm.internal.m.f(errorCode, "errorCode");
            kotlin.jvm.internal.m.f(debugData, "debugData");
            if (this.closed) {
                throw new IOException("closed");
            }
            if (errorCode.getHttpCode() == -1) {
                throw new IllegalArgumentException("errorCode.httpCode == -1");
            }
            f(0, debugData.length + 8, 7, 0);
            this.sink.writeInt(lastGoodStreamId);
            this.sink.writeInt(errorCode.getHttpCode());
            if (!(debugData.length == 0)) {
                this.sink.write(debugData);
            }
            this.sink.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void j(boolean outFinished, int streamId, List<c> headerBlock) {
        kotlin.jvm.internal.m.f(headerBlock, "headerBlock");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.g(headerBlock);
        long size = this.hpackBuffer.getSize();
        long jMin = Math.min(this.maxFrameSize, size);
        int i10 = size == jMin ? 4 : 0;
        if (outFinished) {
            i10 |= 1;
        }
        f(streamId, (int) jMin, 1, i10);
        this.sink.N(this.hpackBuffer, jMin);
        if (size > jMin) {
            q(streamId, size - jMin);
        }
    }

    public final synchronized void l(boolean ack, int payload1, int payload2) {
        if (this.closed) {
            throw new IOException("closed");
        }
        f(0, 8, 6, ack ? 1 : 0);
        this.sink.writeInt(payload1);
        this.sink.writeInt(payload2);
        this.sink.flush();
    }

    public final synchronized void m(int streamId, int promisedStreamId, List<c> requestHeaders) {
        kotlin.jvm.internal.m.f(requestHeaders, "requestHeaders");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.g(requestHeaders);
        long size = this.hpackBuffer.getSize();
        int iMin = (int) Math.min(((long) this.maxFrameSize) - 4, size);
        long j10 = iMin;
        f(streamId, iMin + 4, 5, size == j10 ? 4 : 0);
        this.sink.writeInt(promisedStreamId & Integer.MAX_VALUE);
        this.sink.N(this.hpackBuffer, j10);
        if (size > j10) {
            q(streamId, size - j10);
        }
    }

    public final synchronized void n(int streamId, b errorCode) {
        kotlin.jvm.internal.m.f(errorCode, "errorCode");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (errorCode.getHttpCode() == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        f(streamId, 4, 3, 0);
        this.sink.writeInt(errorCode.getHttpCode());
        this.sink.flush();
    }

    public final synchronized void o(m settings) {
        int i10;
        try {
            kotlin.jvm.internal.m.f(settings, "settings");
            if (this.closed) {
                throw new IOException("closed");
            }
            int i11 = 0;
            f(0, settings.i() * 6, 4, 0);
            while (i11 < 10) {
                if (settings.f(i11)) {
                    if (i11 != 4) {
                        i10 = i11 != 7 ? i11 : 4;
                    } else {
                        i10 = 3;
                    }
                    this.sink.writeShort(i10);
                    this.sink.writeInt(settings.a(i11));
                }
                i11++;
            }
            this.sink.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void p(int streamId, long windowSizeIncrement) {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (windowSizeIncrement == 0 || windowSizeIncrement > 2147483647L) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + windowSizeIncrement).toString());
        }
        f(streamId, 4, 8, 0);
        this.sink.writeInt((int) windowSizeIncrement);
        this.sink.flush();
    }

    public j(tb.e sink, boolean z10) {
        kotlin.jvm.internal.m.f(sink, "sink");
        this.sink = sink;
        this.client = z10;
        tb.d dVar = new tb.d();
        this.hpackBuffer = dVar;
        this.maxFrameSize = 16384;
        this.hpackWriter = new d.b(0, false, dVar, 3, null);
    }

    private final void q(int streamId, long byteCount) {
        while (byteCount > 0) {
            long jMin = Math.min(this.maxFrameSize, byteCount);
            byteCount -= jMin;
            f(streamId, (int) jMin, 9, byteCount == 0 ? 4 : 0);
            this.sink.N(this.hpackBuffer, jMin);
        }
    }

    public final void f(int streamId, int length, int type, int flags) {
        int i10;
        int i11;
        int i12;
        int i13;
        Logger logger = f16284h;
        if (logger.isLoggable(Level.FINE)) {
            i10 = streamId;
            i11 = length;
            i12 = type;
            i13 = flags;
            logger.fine(e.f16156a.c(false, i10, i11, i12, i13));
        } else {
            i10 = streamId;
            i11 = length;
            i12 = type;
            i13 = flags;
        }
        if (i11 > this.maxFrameSize) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + i11).toString());
        }
        if ((Integer.MIN_VALUE & i10) != 0) {
            throw new IllegalArgumentException(("reserved bit set: " + i10).toString());
        }
        hb.d.Z(this.sink, i11);
        this.sink.writeByte(i12 & 255);
        this.sink.writeByte(i13 & 255);
        this.sink.writeInt(Integer.MAX_VALUE & i10);
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final int getMaxFrameSize() {
        return this.maxFrameSize;
    }
}
