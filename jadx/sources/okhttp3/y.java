package okhttp3;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0003\u0014\u0012\u001aB'\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0005\u0010\u0013R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0007¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\b\u0010\u001eR\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0016\u0010#\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0011\u0010'\u001a\u00020$8G¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lokhttp3/y;", "Lokhttp3/c0;", "Ltb/g;", "boundaryByteString", "Lokhttp3/x;", IjkMediaMeta.IJKM_KEY_TYPE, "", "Lokhttp3/y$c;", "parts", "<init>", "(Ltb/g;Lokhttp3/x;Ljava/util/List;)V", "Ltb/e;", "sink", "", "countBytes", "", "k", "(Ltb/e;Z)J", "b", "()Lokhttp3/x;", "a", "()J", "Lr8/z;", "i", "(Ltb/e;)V", "Ltb/g;", "c", "Lokhttp3/x;", "d", "Ljava/util/List;", "()Ljava/util/List;", "e", "contentType", "f", "J", "contentLength", "", "j", "()Ljava/lang/String;", "boundary", "g", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class y extends c0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final x f16991h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final x f16992i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final x f16993j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final x f16994k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final x f16995l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final byte[] f16996m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final byte[] f16997n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final byte[] f16998o;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final tb.g boundaryByteString;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final x type;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<c> parts;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final x contentType;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long contentLength;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001fR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010 R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\"¨\u0006$"}, d2 = {"Lokhttp3/y$a;", "", "", "boundary", "<init>", "(Ljava/lang/String;)V", "Lokhttp3/x;", IjkMediaMeta.IJKM_KEY_TYPE, "f", "(Lokhttp3/x;)Lokhttp3/y$a;", "Lokhttp3/u;", "headers", "Lokhttp3/c0;", "body", "c", "(Lokhttp3/u;Lokhttp3/c0;)Lokhttp3/y$a;", "name", "value", "a", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/y$a;", "filename", "b", "(Ljava/lang/String;Ljava/lang/String;Lokhttp3/c0;)Lokhttp3/y$a;", "Lokhttp3/y$c;", "part", "d", "(Lokhttp3/y$c;)Lokhttp3/y$a;", "Lokhttp3/y;", "e", "()Lokhttp3/y;", "Ltb/g;", "Ltb/g;", "Lokhttp3/x;", "", "Ljava/util/List;", "parts", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final tb.g boundary;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private x type;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final List<c> parts;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public a(String boundary) {
            kotlin.jvm.internal.m.f(boundary, "boundary");
            this.boundary = tb.g.INSTANCE.c(boundary);
            this.type = y.f16991h;
            this.parts = new ArrayList();
        }

        public final a a(String name, String value) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(value, "value");
            d(c.INSTANCE.b(name, value));
            return this;
        }

        public final a b(String name, String filename, c0 body) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(body, "body");
            d(c.INSTANCE.c(name, filename, body));
            return this;
        }

        public final a c(u headers, c0 body) {
            kotlin.jvm.internal.m.f(body, "body");
            d(c.INSTANCE.a(headers, body));
            return this;
        }

        public final a d(c part) {
            kotlin.jvm.internal.m.f(part, "part");
            this.parts.add(part);
            return this;
        }

        public final y e() {
            if (this.parts.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new y(this.boundary, this.type, hb.d.S(this.parts));
        }

        public final a f(x type) {
            kotlin.jvm.internal.m.f(type, "type");
            if (kotlin.jvm.internal.m.a(type.getTv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TYPE java.lang.String(), "multipart")) {
                this.type = type;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + type).toString());
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ a(String str, int i10, kotlin.jvm.internal.g gVar) {
            if ((i10 & 1) != 0) {
                str = UUID.randomUUID().toString();
                kotlin.jvm.internal.m.e(str, "randomUUID().toString()");
            }
            this(str);
        }
    }

    /* JADX INFO: renamed from: okhttp3.y$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b*\u00060\u0004j\u0002`\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0014\u0010\u0016\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\r¨\u0006\u0017"}, d2 = {"Lokhttp3/y$b;", "", "<init>", "()V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "key", "Lr8/z;", "a", "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "Lokhttp3/x;", "ALTERNATIVE", "Lokhttp3/x;", "", "COLONSPACE", "[B", "CRLF", "DASHDASH", "DIGEST", "FORM", "MIXED", "PARALLEL", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final void a(StringBuilder sb2, String key) {
            kotlin.jvm.internal.m.f(sb2, "<this>");
            kotlin.jvm.internal.m.f(key, "key");
            sb2.append('\"');
            int length = key.length();
            for (int i10 = 0; i10 < length; i10++) {
                char cCharAt = key.charAt(i10);
                if (cCharAt == '\n') {
                    sb2.append("%0A");
                } else if (cCharAt == '\r') {
                    sb2.append("%0D");
                } else if (cCharAt == '\"') {
                    sb2.append("%22");
                } else {
                    sb2.append(cCharAt);
                }
            }
            sb2.append('\"');
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000e2\u00020\u0001:\u0001\bB\u001b\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\b\u0010\r¨\u0006\u000f"}, d2 = {"Lokhttp3/y$c;", "", "Lokhttp3/u;", "headers", "Lokhttp3/c0;", "body", "<init>", "(Lokhttp3/u;Lokhttp3/c0;)V", "a", "Lokhttp3/u;", "b", "()Lokhttp3/u;", "Lokhttp3/c0;", "()Lokhttp3/c0;", "c", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final u headers;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final c0 body;

        /* JADX INFO: renamed from: okhttp3.y$c$a, reason: from kotlin metadata */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lokhttp3/y$c$a;", "", "<init>", "()V", "Lokhttp3/u;", "headers", "Lokhttp3/c0;", "body", "Lokhttp3/y$c;", "a", "(Lokhttp3/u;Lokhttp3/c0;)Lokhttp3/y$c;", "", "name", "value", "b", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/y$c;", "filename", "c", "(Ljava/lang/String;Ljava/lang/String;Lokhttp3/c0;)Lokhttp3/y$c;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
                this();
            }

            private Companion() {
            }

            public final c a(u headers, c0 body) {
                kotlin.jvm.internal.m.f(body, "body");
                kotlin.jvm.internal.g gVar = null;
                if ((headers != null ? headers.e("Content-Type") : null) != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type");
                }
                if ((headers != null ? headers.e("Content-Length") : null) == null) {
                    return new c(headers, body, gVar);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }

            public final c b(String name, String value) {
                kotlin.jvm.internal.m.f(name, "name");
                kotlin.jvm.internal.m.f(value, "value");
                return c(name, null, c0.Companion.i(c0.INSTANCE, value, null, 1, null));
            }

            public final c c(String name, String filename, c0 body) {
                kotlin.jvm.internal.m.f(name, "name");
                kotlin.jvm.internal.m.f(body, "body");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("form-data; name=");
                Companion companion = y.INSTANCE;
                companion.a(sb2, name);
                if (filename != null) {
                    sb2.append("; filename=");
                    companion.a(sb2, filename);
                }
                String string = sb2.toString();
                kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
                return a(new u.a().e("Content-Disposition", string).f(), body);
            }
        }

        public /* synthetic */ c(u uVar, c0 c0Var, kotlin.jvm.internal.g gVar) {
            this(uVar, c0Var);
        }

        private c(u uVar, c0 c0Var) {
            this.headers = uVar;
            this.body = c0Var;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final c0 getBody() {
            return this.body;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final u getHeaders() {
            return this.headers;
        }
    }

    static {
        x.Companion companion = x.INSTANCE;
        f16991h = companion.a("multipart/mixed");
        f16992i = companion.a("multipart/alternative");
        f16993j = companion.a("multipart/digest");
        f16994k = companion.a("multipart/parallel");
        f16995l = companion.a("multipart/form-data");
        f16996m = new byte[]{58, 32};
        f16997n = new byte[]{13, 10};
        f16998o = new byte[]{45, 45};
    }

    public y(tb.g boundaryByteString, x type, List<c> parts) {
        kotlin.jvm.internal.m.f(boundaryByteString, "boundaryByteString");
        kotlin.jvm.internal.m.f(type, "type");
        kotlin.jvm.internal.m.f(parts, "parts");
        this.boundaryByteString = boundaryByteString;
        this.type = type;
        this.parts = parts;
        this.contentType = x.INSTANCE.a(type + "; boundary=" + j());
        this.contentLength = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long k(tb.e sink, boolean countBytes) throws EOFException {
        tb.d dVar;
        if (countBytes) {
            sink = new tb.d();
            dVar = sink;
        } else {
            dVar = 0;
        }
        int size = this.parts.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            c cVar = this.parts.get(i10);
            u headers = cVar.getHeaders();
            c0 body = cVar.getBody();
            kotlin.jvm.internal.m.c(sink);
            sink.write(f16998o);
            sink.Q(this.boundaryByteString);
            sink.write(f16997n);
            if (headers != null) {
                int size2 = headers.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    sink.T(headers.f(i11)).write(f16996m).T(headers.k(i11)).write(f16997n);
                }
            }
            x contentType = body.getContentType();
            if (contentType != null) {
                sink.T("Content-Type: ").T(contentType.getMediaType()).write(f16997n);
            }
            long jA = body.a();
            if (jA != -1) {
                sink.T("Content-Length: ").f0(jA).write(f16997n);
            } else if (countBytes) {
                kotlin.jvm.internal.m.c(dVar);
                dVar.a();
                return -1L;
            }
            byte[] bArr = f16997n;
            sink.write(bArr);
            if (countBytes) {
                j10 += jA;
            } else {
                body.i(sink);
            }
            sink.write(bArr);
        }
        kotlin.jvm.internal.m.c(sink);
        byte[] bArr2 = f16998o;
        sink.write(bArr2);
        sink.Q(this.boundaryByteString);
        sink.write(bArr2);
        sink.write(f16997n);
        if (!countBytes) {
            return j10;
        }
        kotlin.jvm.internal.m.c(dVar);
        long size3 = j10 + dVar.getSize();
        dVar.a();
        return size3;
    }

    @Override // okhttp3.c0
    public long a() throws EOFException {
        long j10 = this.contentLength;
        if (j10 != -1) {
            return j10;
        }
        long jK = k(null, true);
        this.contentLength = jK;
        return jK;
    }

    @Override // okhttp3.c0
    /* JADX INFO: renamed from: b, reason: from getter */
    public x getContentType() {
        return this.contentType;
    }

    @Override // okhttp3.c0
    public void i(tb.e sink) throws EOFException {
        kotlin.jvm.internal.m.f(sink, "sink");
        k(sink, false);
    }

    public final String j() {
        return this.boundaryByteString.A();
    }
}
