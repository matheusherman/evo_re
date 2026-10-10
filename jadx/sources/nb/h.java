package nb;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import tb.a0;
import tb.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 02\u00020\u0001:\u0003'# B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0010J/\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0010J\u001f\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u0010J/\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u0010J/\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\u0010J/\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u0010J/\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u0010J/\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010\u0010J\u0015\u0010 \u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b \u0010!J\u001d\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u000eH\u0016¢\u0006\u0004\b%\u0010&R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010)R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010.¨\u00061"}, d2 = {"Lnb/h;", "Ljava/io/Closeable;", "Ltb/f;", "source", "", "client", "<init>", "(Ltb/f;Z)V", "Lnb/h$c;", "handler", "", "length", "flags", "streamId", "Lr8/z;", "j", "(Lnb/h$c;III)V", "padding", "", "Lnb/c;", "i", "(IIII)Ljava/util/List;", "d", "m", "l", "(Lnb/h$c;I)V", "o", "p", "n", "k", "f", "q", "c", "(Lnb/h$c;)V", "requireSettings", "b", "(ZLnb/h$c;)Z", "close", "()V", "a", "Ltb/f;", "Z", "Lnb/h$b;", "Lnb/h$b;", "continuation", "Lnb/d$a;", "Lnb/d$a;", "hpackReader", "e", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class h implements Closeable {

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Logger f16244f;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final tb.f source;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean client;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final b continuation;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final d.a hpackReader;

    /* JADX INFO: renamed from: nb.h$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lnb/h$a;", "", "<init>", "()V", "", "length", "flags", "padding", "b", "(III)I", "Ljava/util/logging/Logger;", "logger", "Ljava/util/logging/Logger;", "a", "()Ljava/util/logging/Logger;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final int b(int length, int flags, int padding) throws IOException {
            if ((flags & 8) != 0) {
                length--;
            }
            if (padding <= length) {
                return length - padding;
            }
            throw new IOException("PROTOCOL_ERROR padding " + padding + " > remaining length " + length);
        }

        public final Logger a() {
            return h.f16244f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001e\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\"\u0010\"\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\"\u0010$\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0016\u001a\u0004\b\u0013\u0010\u0018\"\u0004\b\u001f\u0010\u001aR\"\u0010'\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001a¨\u0006("}, d2 = {"Lnb/h$b;", "Ltb/z;", "Ltb/f;", "source", "<init>", "(Ltb/f;)V", "Lr8/z;", "b", "()V", "Ltb/d;", "sink", "", "byteCount", "D", "(Ltb/d;J)J", "Ltb/a0;", "g", "()Ltb/a0;", "close", "a", "Ltb/f;", "", "I", "getLength", "()I", "f", "(I)V", "length", "c", "getFlags", "flags", "d", "getStreamId", "j", "streamId", "e", "left", "getPadding", "i", "padding", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class b implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final tb.f source;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int length;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int flags;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int streamId;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int left;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int padding;

        public b(tb.f source) {
            kotlin.jvm.internal.m.f(source, "source");
            this.source = source;
        }

        private final void b() throws IOException {
            int i10 = this.streamId;
            int iJ = hb.d.J(this.source);
            this.left = iJ;
            this.length = iJ;
            int iD = hb.d.d(this.source.readByte(), 255);
            this.flags = hb.d.d(this.source.readByte(), 255);
            Companion companion = h.INSTANCE;
            if (companion.a().isLoggable(Level.FINE)) {
                companion.a().fine(e.f16156a.c(true, this.streamId, this.length, iD, this.flags));
            }
            int i11 = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = i11;
            if (iD == 9) {
                if (i11 != i10) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(iD + " != TYPE_CONTINUATION");
            }
        }

        @Override // tb.z
        public long D(tb.d sink, long byteCount) throws IOException {
            kotlin.jvm.internal.m.f(sink, "sink");
            while (true) {
                int i10 = this.left;
                if (i10 != 0) {
                    long jD = this.source.D(sink, Math.min(byteCount, i10));
                    if (jD == -1) {
                        return -1L;
                    }
                    this.left -= (int) jD;
                    return jD;
                }
                this.source.skip(this.padding);
                this.padding = 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                b();
            }
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final int getLeft() {
            return this.left;
        }

        public final void c(int i10) {
            this.flags = i10;
        }

        public final void d(int i10) {
            this.left = i10;
        }

        public final void f(int i10) {
            this.length = i10;
        }

        @Override // tb.z
        /* JADX INFO: renamed from: g */
        public a0 getTimeout() {
            return this.source.getTimeout();
        }

        public final void i(int i10) {
            this.padding = i10;
        }

        public final void j(int i10) {
            this.streamId = i10;
        }

        @Override // tb.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\tH&¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010 \u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H&¢\u0006\u0004\b \u0010!J'\u0010%\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010$\u001a\u00020#H&¢\u0006\u0004\b%\u0010&J\u001f\u0010)\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H&¢\u0006\u0004\b)\u0010*J/\u0010.\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0002H&¢\u0006\u0004\b.\u0010/J-\u00102\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00042\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b2\u00103¨\u00064"}, d2 = {"Lnb/h$c;", "", "", "inFinished", "", "streamId", "Ltb/f;", "source", "length", "Lr8/z;", "j", "(ZILtb/f;I)V", "associatedStreamId", "", "Lnb/c;", "headerBlock", "c", "(ZIILjava/util/List;)V", "Lnb/b;", "errorCode", "f", "(ILnb/b;)V", "clearPrevious", "Lnb/m;", "settings", "a", "(ZLnb/m;)V", "b", "()V", "ack", "payload1", "payload2", "g", "(ZII)V", "lastGoodStreamId", "Ltb/g;", "debugData", "k", "(ILnb/b;Ltb/g;)V", "", "windowSizeIncrement", "e", "(IJ)V", "streamDependency", "weight", "exclusive", "h", "(IIIZ)V", "promisedStreamId", "requestHeaders", "l", "(IILjava/util/List;)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface c {
        void a(boolean clearPrevious, m settings);

        void b();

        void c(boolean inFinished, int streamId, int associatedStreamId, List<nb.c> headerBlock);

        void e(int streamId, long windowSizeIncrement);

        void f(int streamId, nb.b errorCode);

        void g(boolean ack, int payload1, int payload2);

        void h(int streamId, int streamDependency, int weight, boolean exclusive);

        void j(boolean inFinished, int streamId, tb.f source, int length);

        void k(int lastGoodStreamId, nb.b errorCode, tb.g debugData);

        void l(int streamId, int promisedStreamId, List<nb.c> requestHeaders);
    }

    private final void m(c handler, int length, int flags, int streamId) throws IOException {
        if (length == 5) {
            if (streamId == 0) {
                throw new IOException("TYPE_PRIORITY streamId == 0");
            }
            l(handler, streamId);
        } else {
            throw new IOException("TYPE_PRIORITY length: " + length + " != 5");
        }
    }

    private final void o(c handler, int length, int flags, int streamId) throws IOException {
        if (length != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + length + " != 4");
        }
        if (streamId == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int i10 = this.source.readInt();
        nb.b bVarA = nb.b.INSTANCE.a(i10);
        if (bVarA != null) {
            handler.f(streamId, bVarA);
            return;
        }
        throw new IOException("TYPE_RST_STREAM unexpected error code: " + i10);
    }

    private final void q(c handler, int length, int flags, int streamId) throws IOException {
        if (length != 4) {
            throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + length);
        }
        long jF = hb.d.f(this.source.readInt(), 2147483647L);
        if (jF == 0) {
            throw new IOException("windowSizeIncrement was 0");
        }
        handler.e(streamId, jF);
    }

    static {
        Logger logger = Logger.getLogger(e.class.getName());
        kotlin.jvm.internal.m.e(logger, "getLogger(Http2::class.java.name)");
        f16244f = logger;
    }

    public h(tb.f source, boolean z10) {
        kotlin.jvm.internal.m.f(source, "source");
        this.source = source;
        this.client = z10;
        b bVar = new b(source);
        this.continuation = bVar;
        this.hpackReader = new d.a(bVar, 4096, 0, 4, null);
    }

    private final void d(c handler, int length, int flags, int streamId) throws IOException {
        if (streamId == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z10 = (flags & 1) != 0;
        if ((flags & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int iD = (flags & 8) != 0 ? hb.d.d(this.source.readByte(), 255) : 0;
        handler.j(z10, streamId, this.source, INSTANCE.b(length, flags, iD));
        this.source.skip(iD);
    }

    private final void f(c handler, int length, int flags, int streamId) throws IOException {
        if (length < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + length);
        }
        if (streamId != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int i10 = this.source.readInt();
        int i11 = this.source.readInt();
        int i12 = length - 8;
        nb.b bVarA = nb.b.INSTANCE.a(i11);
        if (bVarA == null) {
            throw new IOException("TYPE_GOAWAY unexpected error code: " + i11);
        }
        tb.g gVarE = tb.g.f19051d;
        if (i12 > 0) {
            gVarE = this.source.E(i12);
        }
        handler.k(i10, bVarA, gVarE);
    }

    private final List<nb.c> i(int length, int padding, int flags, int streamId) throws IOException {
        this.continuation.d(length);
        b bVar = this.continuation;
        bVar.f(bVar.getLeft());
        this.continuation.i(padding);
        this.continuation.c(flags);
        this.continuation.j(streamId);
        this.hpackReader.k();
        return this.hpackReader.e();
    }

    private final void j(c handler, int length, int flags, int streamId) throws IOException {
        if (streamId == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z10 = (flags & 1) != 0;
        int iD = (flags & 8) != 0 ? hb.d.d(this.source.readByte(), 255) : 0;
        if ((flags & 32) != 0) {
            l(handler, streamId);
            length -= 5;
        }
        handler.c(z10, streamId, -1, i(INSTANCE.b(length, flags, iD), iD, flags, streamId));
    }

    private final void k(c handler, int length, int flags, int streamId) throws IOException {
        if (length != 8) {
            throw new IOException("TYPE_PING length != 8: " + length);
        }
        if (streamId != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        handler.g((flags & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private final void l(c handler, int streamId) {
        int i10 = this.source.readInt();
        handler.h(streamId, i10 & Integer.MAX_VALUE, hb.d.d(this.source.readByte(), 255) + 1, (Integer.MIN_VALUE & i10) != 0);
    }

    private final void n(c handler, int length, int flags, int streamId) throws IOException {
        if (streamId == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int iD = (flags & 8) != 0 ? hb.d.d(this.source.readByte(), 255) : 0;
        handler.l(streamId, this.source.readInt() & Integer.MAX_VALUE, i(INSTANCE.b(length - 4, flags, iD), iD, flags, streamId));
    }

    private final void p(c handler, int length, int flags, int streamId) throws IOException {
        if (streamId != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((flags & 1) != 0) {
            if (length != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            handler.b();
            return;
        }
        if (length % 6 != 0) {
            throw new IOException("TYPE_SETTINGS length % 6 != 0: " + length);
        }
        m mVar = new m();
        h9.c cVarL = h9.f.l(h9.f.m(0, length), 6);
        int first = cVarL.getFirst();
        int last = cVarL.getLast();
        int step = cVarL.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                int iE = hb.d.e(this.source.readShort(), 65535);
                int i10 = this.source.readInt();
                if (iE != 2) {
                    if (iE == 3) {
                        iE = 4;
                    } else if (iE != 4) {
                        if (iE == 5 && (i10 < 16384 || i10 > 16777215)) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + i10);
                        }
                    } else {
                        if (i10 < 0) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                        iE = 7;
                    }
                } else if (i10 != 0 && i10 != 1) {
                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                }
                mVar.h(iE, i10);
                if (first != last) {
                    first += step;
                }
            }
        }
        handler.a(false, mVar);
    }

    public final boolean b(boolean requireSettings, c handler) throws IOException {
        kotlin.jvm.internal.m.f(handler, "handler");
        try {
            this.source.d0(9L);
            int iJ = hb.d.J(this.source);
            if (iJ > 16384) {
                throw new IOException("FRAME_SIZE_ERROR: " + iJ);
            }
            int iD = hb.d.d(this.source.readByte(), 255);
            int iD2 = hb.d.d(this.source.readByte(), 255);
            int i10 = this.source.readInt() & Integer.MAX_VALUE;
            Logger logger = f16244f;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.f16156a.c(true, i10, iJ, iD, iD2));
            }
            if (requireSettings && iD != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + e.f16156a.b(iD));
            }
            switch (iD) {
                case 0:
                    d(handler, iJ, iD2, i10);
                    return true;
                case 1:
                    j(handler, iJ, iD2, i10);
                    return true;
                case 2:
                    m(handler, iJ, iD2, i10);
                    return true;
                case 3:
                    o(handler, iJ, iD2, i10);
                    return true;
                case 4:
                    p(handler, iJ, iD2, i10);
                    return true;
                case 5:
                    n(handler, iJ, iD2, i10);
                    return true;
                case 6:
                    k(handler, iJ, iD2, i10);
                    return true;
                case 7:
                    f(handler, iJ, iD2, i10);
                    return true;
                case 8:
                    q(handler, iJ, iD2, i10);
                    return true;
                default:
                    this.source.skip(iJ);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void c(c handler) throws IOException {
        kotlin.jvm.internal.m.f(handler, "handler");
        if (this.client) {
            if (!b(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        tb.f fVar = this.source;
        tb.g gVar = e.CONNECTION_PREFACE;
        tb.g gVarE = fVar.E(gVar.x());
        Logger logger = f16244f;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(hb.d.t("<< CONNECTION " + gVarE.o(), new Object[0]));
        }
        if (kotlin.jvm.internal.m.a(gVar, gVarE)) {
            return;
        }
        throw new IOException("Expected a connection header but was " + gVarE.A());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.source.close();
    }
}
