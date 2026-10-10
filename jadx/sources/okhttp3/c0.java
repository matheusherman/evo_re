package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lokhttp3/c0;", "", "<init>", "()V", "Lokhttp3/x;", "b", "()Lokhttp3/x;", "", "a", "()J", "Ltb/e;", "sink", "Lr8/z;", "i", "(Ltb/e;)V", "", "g", "()Z", "h", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: okhttp3.c0$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u0007*\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u0007*\u00020\n2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0011\u001a\u00020\u0007*\u00020\r2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u0007*\u00020\u00132\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0017\u0010\u0018J5\u0010\u0019\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lokhttp3/c0$a;", "", "<init>", "()V", "", "Lokhttp3/x;", "contentType", "Lokhttp3/c0;", "b", "(Ljava/lang/String;Lokhttp3/x;)Lokhttp3/c0;", "Ltb/g;", "f", "(Ltb/g;Lokhttp3/x;)Lokhttp3/c0;", "", "", "offset", "byteCount", "h", "([BLokhttp3/x;II)Lokhttp3/c0;", "Ljava/io/File;", "a", "(Ljava/io/File;Lokhttp3/x;)Lokhttp3/c0;", "content", "c", "(Lokhttp3/x;Ltb/g;)Lokhttp3/c0;", "e", "(Lokhttp3/x;[BII)Lokhttp3/c0;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: renamed from: okhttp3.c0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"okhttp3/c0$a$a", "Lokhttp3/c0;", "Lokhttp3/x;", "b", "()Lokhttp3/x;", "", "a", "()J", "Ltb/e;", "sink", "Lr8/z;", "i", "(Ltb/e;)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class C0323a extends c0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ x f16631b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ File f16632c;

            C0323a(x xVar, File file) {
                this.f16631b = xVar;
                this.f16632c = file;
            }

            @Override // okhttp3.c0
            public long a() {
                return this.f16632c.length();
            }

            @Override // okhttp3.c0
            /* JADX INFO: renamed from: b, reason: from getter */
            public x getF16635b() {
                return this.f16631b;
            }

            @Override // okhttp3.c0
            public void i(tb.e sink) throws IOException {
                kotlin.jvm.internal.m.f(sink, "sink");
                tb.z zVarE = tb.n.e(this.f16632c);
                try {
                    sink.H(zVarE);
                    a9.a.a(zVarE, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        a9.a.a(zVarE, th);
                        throw th2;
                    }
                }
            }
        }

        /* JADX INFO: renamed from: okhttp3.c0$a$b */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"okhttp3/c0$a$b", "Lokhttp3/c0;", "Lokhttp3/x;", "b", "()Lokhttp3/x;", "", "a", "()J", "Ltb/e;", "sink", "Lr8/z;", "i", "(Ltb/e;)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class b extends c0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ x f16633b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ tb.g f16634c;

            b(x xVar, tb.g gVar) {
                this.f16633b = xVar;
                this.f16634c = gVar;
            }

            @Override // okhttp3.c0
            public long a() {
                return this.f16634c.x();
            }

            @Override // okhttp3.c0
            /* JADX INFO: renamed from: b, reason: from getter */
            public x getF16635b() {
                return this.f16633b;
            }

            @Override // okhttp3.c0
            public void i(tb.e sink) {
                kotlin.jvm.internal.m.f(sink, "sink");
                sink.Q(this.f16634c);
            }
        }

        /* JADX INFO: renamed from: okhttp3.c0$a$c */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"okhttp3/c0$a$c", "Lokhttp3/c0;", "Lokhttp3/x;", "b", "()Lokhttp3/x;", "", "a", "()J", "Ltb/e;", "sink", "Lr8/z;", "i", "(Ltb/e;)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class c extends c0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ x f16635b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f16636c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ byte[] f16637d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f16638e;

            c(x xVar, int i10, byte[] bArr, int i11) {
                this.f16635b = xVar;
                this.f16636c = i10;
                this.f16637d = bArr;
                this.f16638e = i11;
            }

            @Override // okhttp3.c0
            public long a() {
                return this.f16636c;
            }

            @Override // okhttp3.c0
            /* JADX INFO: renamed from: b, reason: from getter */
            public x getF16635b() {
                return this.f16635b;
            }

            @Override // okhttp3.c0
            public void i(tb.e sink) {
                kotlin.jvm.internal.m.f(sink, "sink");
                sink.write(this.f16637d, this.f16638e, this.f16636c);
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ c0 i(Companion companion, String str, x xVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                xVar = null;
            }
            return companion.b(str, xVar);
        }

        public static /* synthetic */ c0 j(Companion companion, x xVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                i10 = 0;
            }
            if ((i12 & 8) != 0) {
                i11 = bArr.length;
            }
            return companion.e(xVar, bArr, i10, i11);
        }

        public static /* synthetic */ c0 k(Companion companion, byte[] bArr, x xVar, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                xVar = null;
            }
            if ((i12 & 2) != 0) {
                i10 = 0;
            }
            if ((i12 & 4) != 0) {
                i11 = bArr.length;
            }
            return companion.h(bArr, xVar, i10, i11);
        }

        public final c0 a(File file, x xVar) {
            kotlin.jvm.internal.m.f(file, "<this>");
            return new C0323a(xVar, file);
        }

        public final c0 b(String str, x xVar) {
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
            byte[] bytes = str.getBytes(charset);
            kotlin.jvm.internal.m.e(bytes, "this as java.lang.String).getBytes(charset)");
            return h(bytes, xVar, 0, bytes.length);
        }

        public final c0 c(x contentType, tb.g content) {
            kotlin.jvm.internal.m.f(content, "content");
            return f(content, contentType);
        }

        public final c0 d(x xVar, byte[] content) {
            kotlin.jvm.internal.m.f(content, "content");
            return j(this, xVar, content, 0, 0, 12, null);
        }

        public final c0 e(x contentType, byte[] content, int offset, int byteCount) {
            kotlin.jvm.internal.m.f(content, "content");
            return h(content, contentType, offset, byteCount);
        }

        public final c0 f(tb.g gVar, x xVar) {
            kotlin.jvm.internal.m.f(gVar, "<this>");
            return new b(xVar, gVar);
        }

        public final c0 g(byte[] bArr, x xVar) {
            kotlin.jvm.internal.m.f(bArr, "<this>");
            return k(this, bArr, xVar, 0, 0, 6, null);
        }

        public final c0 h(byte[] bArr, x xVar, int i10, int i11) {
            kotlin.jvm.internal.m.f(bArr, "<this>");
            hb.d.l(bArr.length, i10, i11);
            return new c(xVar, i11, bArr, i10);
        }
    }

    /* JADX INFO: renamed from: b */
    public abstract x getF16635b();

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public abstract void i(tb.e sink);

    public static final c0 c(File file, x xVar) {
        return INSTANCE.a(file, xVar);
    }

    public static final c0 d(x xVar, tb.g gVar) {
        return INSTANCE.c(xVar, gVar);
    }

    public static final c0 e(x xVar, byte[] bArr) {
        return INSTANCE.d(xVar, bArr);
    }

    public static final c0 f(byte[] bArr, x xVar) {
        return INSTANCE.g(bArr, xVar);
    }

    public long a() {
        return -1L;
    }
}
