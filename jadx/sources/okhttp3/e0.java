package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u00142\u00020\u0001:\u0002\u000e\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u0003R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001e¨\u0006 "}, d2 = {"Lokhttp3/e0;", "Ljava/io/Closeable;", "<init>", "()V", "Ljava/nio/charset/Charset;", "d", "()Ljava/nio/charset/Charset;", "Lokhttp3/x;", "i", "()Lokhttp3/x;", "", "f", "()J", "Ljava/io/InputStream;", "a", "()Ljava/io/InputStream;", "Ltb/f;", "k", "()Ltb/f;", "", "b", "()[B", "Ljava/io/Reader;", "c", "()Ljava/io/Reader;", "", "l", "()Ljava/lang/String;", "Lr8/z;", "close", "Ljava/io/Reader;", "reader", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class e0 implements Closeable {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Reader reader;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lokhttp3/e0$a;", "Ljava/io/Reader;", "Ltb/f;", "source", "Ljava/nio/charset/Charset;", "charset", "<init>", "(Ltb/f;Ljava/nio/charset/Charset;)V", "", "cbuf", "", "off", "len", "read", "([CII)I", "Lr8/z;", "close", "()V", "a", "Ltb/f;", "b", "Ljava/nio/charset/Charset;", "", "c", "Z", "closed", "d", "Ljava/io/Reader;", "delegate", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a extends Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final tb.f source;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final Charset charset;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean closed;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private Reader delegate;

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            r8.z zVar;
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
                zVar = r8.z.f17874a;
            } else {
                zVar = null;
            }
            if (zVar == null) {
                this.source.close();
            }
        }

        public a(tb.f source, Charset charset) {
            kotlin.jvm.internal.m.f(source, "source");
            kotlin.jvm.internal.m.f(charset, "charset");
            this.source = source;
            this.charset = charset;
        }

        @Override // java.io.Reader
        public int read(char[] cbuf, int off, int len) throws IOException {
            kotlin.jvm.internal.m.f(cbuf, "cbuf");
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.delegate;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.source.h0(), hb.d.I(this.source, this.charset));
                this.delegate = inputStreamReader;
            }
            return inputStreamReader.read(cbuf, off, len);
        }
    }

    /* JADX INFO: renamed from: okhttp3.e0$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u0007*\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u0007*\u00020\n2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0010\u001a\u00020\u0007*\u00020\r2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0013\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lokhttp3/e0$b;", "", "<init>", "()V", "", "Lokhttp3/x;", "contentType", "Lokhttp3/e0;", "a", "(Ljava/lang/String;Lokhttp3/x;)Lokhttp3/e0;", "", "d", "([BLokhttp3/x;)Lokhttp3/e0;", "Ltb/f;", "", "contentLength", "c", "(Ltb/f;Lokhttp3/x;J)Lokhttp3/e0;", "content", "b", "(Lokhttp3/x;JLtb/f;)Lokhttp3/e0;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: renamed from: okhttp3.e0$b$a */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"okhttp3/e0$b$a", "Lokhttp3/e0;", "Lokhttp3/x;", "i", "()Lokhttp3/x;", "", "f", "()J", "Ltb/f;", "k", "()Ltb/f;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class a extends e0 {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ x f16696c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f16697d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ tb.f f16698e;

            a(x xVar, long j10, tb.f fVar) {
                this.f16696c = xVar;
                this.f16697d = j10;
                this.f16698e = fVar;
            }

            @Override // okhttp3.e0
            /* JADX INFO: renamed from: f, reason: from getter */
            public long getF16697d() {
                return this.f16697d;
            }

            @Override // okhttp3.e0
            /* JADX INFO: renamed from: i, reason: from getter */
            public x getF16696c() {
                return this.f16696c;
            }

            @Override // okhttp3.e0
            /* JADX INFO: renamed from: k, reason: from getter */
            public tb.f getF16698e() {
                return this.f16698e;
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ e0 e(Companion companion, byte[] bArr, x xVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                xVar = null;
            }
            return companion.d(bArr, xVar);
        }

        public final e0 a(String str, x xVar) {
            kotlin.jvm.internal.m.f(str, "<this>");
            Charset charset = ua.d.UTF_8;
            if (xVar != null) {
                Charset charsetD = x.d(xVar, null, 1, null);
                if (charsetD == null) {
                    xVar = x.INSTANCE.b(xVar + "; charset=utf-8");
                } else {
                    charset = charsetD;
                }
            }
            tb.d dVarL0 = new tb.d().l0(str, charset);
            return c(dVarL0, xVar, dVarL0.getSize());
        }

        public final e0 b(x contentType, long contentLength, tb.f content) {
            kotlin.jvm.internal.m.f(content, "content");
            return c(content, contentType, contentLength);
        }

        public final e0 c(tb.f fVar, x xVar, long j10) {
            kotlin.jvm.internal.m.f(fVar, "<this>");
            return new a(xVar, j10, fVar);
        }

        public final e0 d(byte[] bArr, x xVar) {
            kotlin.jvm.internal.m.f(bArr, "<this>");
            return c(new tb.d().write(bArr), xVar, bArr.length);
        }
    }

    /* JADX INFO: renamed from: f */
    public abstract long getF16697d();

    /* JADX INFO: renamed from: i */
    public abstract x getF16696c();

    /* JADX INFO: renamed from: k */
    public abstract tb.f getF16698e();

    public static final e0 j(x xVar, long j10, tb.f fVar) {
        return INSTANCE.b(xVar, j10, fVar);
    }

    public final Reader c() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        a aVar = new a(getF16698e(), d());
        this.reader = aVar;
        return aVar;
    }

    private final Charset d() {
        Charset charsetC;
        x f16696c = getF16696c();
        if (f16696c != null && (charsetC = f16696c.c(ua.d.UTF_8)) != null) {
            return charsetC;
        }
        return ua.d.UTF_8;
    }

    public final InputStream a() {
        return getF16698e().h0();
    }

    public final byte[] b() throws IOException {
        long f16697d = getF16697d();
        if (f16697d <= 2147483647L) {
            tb.f f16698e = getF16698e();
            try {
                byte[] bArrK = f16698e.K();
                a9.a.a(f16698e, null);
                int length = bArrK.length;
                if (f16697d != -1 && f16697d != length) {
                    throw new IOException("Content-Length (" + f16697d + ") and stream length (" + length + ") disagree");
                }
                return bArrK;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    a9.a.a(f16698e, th);
                    throw th2;
                }
            }
        }
        throw new IOException("Cannot buffer entire body for content length: " + f16697d);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        hb.d.m(getF16698e());
    }

    public final String l() throws IOException {
        tb.f f16698e = getF16698e();
        try {
            String strU = f16698e.U(hb.d.I(f16698e, d()));
            a9.a.a(f16698e, null);
            return strU;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                a9.a.a(f16698e, th);
                throw th2;
            }
        }
    }
}
