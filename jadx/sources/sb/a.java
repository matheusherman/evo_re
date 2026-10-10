package sb;

import androidx.core.location.LocationRequestCompat;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.v0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import lb.e;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;
import okhttp3.e0;
import okhttp3.j;
import okhttp3.u;
import okhttp3.w;
import okhttp3.x;
import tb.d;
import tb.f;
import tb.k;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u0017\u000eB\u0013\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001cR*\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00108\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b\u001f\u0010#¨\u0006$"}, d2 = {"Lsb/a;", "Lokhttp3/w;", "Lsb/a$b;", "logger", "<init>", "(Lsb/a$b;)V", "Lokhttp3/u;", "headers", "", "i", "Lr8/z;", "d", "(Lokhttp3/u;I)V", "", "b", "(Lokhttp3/u;)Z", "Lsb/a$a;", "level", "e", "(Lsb/a$a;)Lsb/a;", "Lokhttp3/w$a;", "chain", "Lokhttp3/d0;", "a", "(Lokhttp3/w$a;)Lokhttp3/d0;", "Lsb/a$b;", "", "", "Ljava/util/Set;", "headersToRedact", "<set-?>", "c", "Lsb/a$a;", "getLevel", "()Lsb/a$a;", "(Lsb/a$a;)V", "okhttp-logging-interceptor"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b logger;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile Set<String> headersToRedact;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile EnumC0360a level;

    /* JADX INFO: renamed from: sb.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lsb/a$a;", "", "<init>", "(Ljava/lang/String;I)V", "a", "b", "c", "d", "okhttp-logging-interceptor"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum EnumC0360a {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lsb/a$b;", "", "", "message", "Lr8/z;", "a", "(Ljava/lang/String;)V", "okhttp-logging-interceptor"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = Companion.f18543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f18542b = new Companion.C0362a();

        void a(String message);

        /* JADX INFO: renamed from: sb.a$b$a, reason: collision with other inner class name and from kotlin metadata */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0001¨\u0006\b"}, d2 = {"Lsb/a$b$a;", "", "<init>", "()V", "Lsb/a$b;", "DEFAULT", "Lsb/a$b;", "a", "okhttp-logging-interceptor"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f18543a = new Companion();

            /* JADX INFO: renamed from: sb.a$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lsb/a$b$a$a;", "Lsb/a$b;", "<init>", "()V", "", "message", "Lr8/z;", "a", "(Ljava/lang/String;)V", "okhttp-logging-interceptor"}, k = 1, mv = {1, 8, 0}, xi = 48)
            private static final class C0362a implements b {
                @Override // sb.a.b
                public void a(String message) {
                    m.f(message, "message");
                    ob.m.k(ob.m.INSTANCE.g(), message, 0, null, 6, null);
                }
            }

            private Companion() {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // okhttp3.w
    public d0 a(w.a chain) throws Exception {
        String string;
        long j10;
        char c10;
        String string2;
        Charset UTF_8;
        Charset UTF_9;
        m.f(chain, "chain");
        EnumC0360a enumC0360a = this.level;
        b0 b0VarF = chain.getRequest();
        if (enumC0360a == EnumC0360a.NONE) {
            return chain.a(b0VarF);
        }
        boolean z10 = enumC0360a == EnumC0360a.BODY;
        boolean z11 = z10 || enumC0360a == EnumC0360a.HEADERS;
        c0 body = b0VarF.getBody();
        j jVarB = chain.b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("--> ");
        sb2.append(b0VarF.getMethod());
        sb2.append(' ');
        sb2.append(b0VarF.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String());
        if (jVarB != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(' ');
            sb3.append(jVarB.a());
            string = sb3.toString();
        } else {
            string = "";
        }
        sb2.append(string);
        String string3 = sb2.toString();
        if (!z11 && body != null) {
            string3 = string3 + " (" + body.a() + "-byte body)";
        }
        this.logger.a(string3);
        if (z11) {
            u headers = b0VarF.getHeaders();
            j10 = -1;
            if (body != null) {
                x contentType = body.getContentType();
                if (contentType != null && headers.e("Content-Type") == null) {
                    this.logger.a("Content-Type: " + contentType);
                }
                if (body.a() != -1 && headers.e("Content-Length") == null) {
                    this.logger.a("Content-Length: " + body.a());
                }
            }
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                d(headers, i10);
            }
            if (!z10 || body == null) {
                this.logger.a("--> END " + b0VarF.getMethod());
            } else if (b(b0VarF.getHeaders())) {
                this.logger.a("--> END " + b0VarF.getMethod() + " (encoded body omitted)");
            } else if (body.g()) {
                this.logger.a("--> END " + b0VarF.getMethod() + " (duplex request body omitted)");
            } else if (body.h()) {
                this.logger.a("--> END " + b0VarF.getMethod() + " (one-shot body omitted)");
            } else {
                d dVar = new d();
                body.i(dVar);
                x contentType2 = body.getContentType();
                if (contentType2 == null || (UTF_9 = contentType2.c(StandardCharsets.UTF_8)) == null) {
                    UTF_9 = StandardCharsets.UTF_8;
                    m.e(UTF_9, "UTF_8");
                }
                this.logger.a("");
                if (sb.b.a(dVar)) {
                    this.logger.a(dVar.U(UTF_9));
                    this.logger.a("--> END " + b0VarF.getMethod() + " (" + body.a() + "-byte body)");
                } else {
                    this.logger.a("--> END " + b0VarF.getMethod() + " (binary " + body.a() + "-byte body omitted)");
                }
            }
        } else {
            j10 = -1;
        }
        long jNanoTime = System.nanoTime();
        try {
            d0 d0VarA = chain.a(b0VarF);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            e0 body2 = d0VarA.getBody();
            m.c(body2);
            long contentLength = body2.getContentLength();
            String str = contentLength != j10 ? contentLength + "-byte" : "unknown-length";
            b bVar = this.logger;
            StringBuilder sb4 = new StringBuilder();
            boolean z12 = z11;
            sb4.append("<-- ");
            sb4.append(d0VarA.getCode());
            if (d0VarA.getMessage().length() == 0) {
                string2 = "";
                c10 = ' ';
            } else {
                String message = d0VarA.getMessage();
                StringBuilder sb5 = new StringBuilder();
                c10 = ' ';
                sb5.append(' ');
                sb5.append(message);
                string2 = sb5.toString();
            }
            sb4.append(string2);
            sb4.append(c10);
            sb4.append(d0VarA.getRequest().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String());
            sb4.append(" (");
            sb4.append(millis);
            sb4.append("ms");
            sb4.append(z12 ? "" : ", " + str + " body");
            sb4.append(')');
            bVar.a(sb4.toString());
            if (z12) {
                u headers2 = d0VarA.getHeaders();
                int size2 = headers2.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    d(headers2, i11);
                }
                if (z10 && e.b(d0VarA)) {
                    if (b(d0VarA.getHeaders())) {
                        this.logger.a("<-- END HTTP (encoded body omitted)");
                        return d0VarA;
                    }
                    f source = body2.getSource();
                    source.h(LocationRequestCompat.PASSIVE_INTERVAL);
                    d bufferField = source.getBufferField();
                    Long l10 = null;
                    if (n.w("gzip", headers2.e("Content-Encoding"), true)) {
                        Long lValueOf = Long.valueOf(bufferField.getSize());
                        k kVar = new k(bufferField.clone());
                        try {
                            bufferField = new d();
                            bufferField.H(kVar);
                            a9.a.a(kVar, null);
                            l10 = lValueOf;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                a9.a.a(kVar, th);
                                throw th2;
                            }
                        }
                    }
                    x f16696c = body2.getF16696c();
                    if (f16696c == null || (UTF_8 = f16696c.c(StandardCharsets.UTF_8)) == null) {
                        UTF_8 = StandardCharsets.UTF_8;
                        m.e(UTF_8, "UTF_8");
                    }
                    if (!sb.b.a(bufferField)) {
                        this.logger.a("");
                        this.logger.a("<-- END HTTP (binary " + bufferField.getSize() + "-byte body omitted)");
                        return d0VarA;
                    }
                    if (contentLength != 0) {
                        this.logger.a("");
                        this.logger.a(bufferField.clone().U(UTF_8));
                    }
                    if (l10 == null) {
                        this.logger.a("<-- END HTTP (" + bufferField.getSize() + "-byte body)");
                        return d0VarA;
                    }
                    this.logger.a("<-- END HTTP (" + bufferField.getSize() + "-byte, " + l10 + "-gzipped-byte body)");
                    return d0VarA;
                }
                this.logger.a("<-- END HTTP");
            }
            return d0VarA;
        } catch (Exception e10) {
            this.logger.a("<-- HTTP FAILED: " + e10);
            throw e10;
        }
    }

    public a(b logger) {
        m.f(logger, "logger");
        this.logger = logger;
        this.headersToRedact = v0.e();
        this.level = EnumC0360a.NONE;
    }

    private final boolean b(u headers) {
        String strE = headers.e("Content-Encoding");
        return (strE == null || n.w(strE, "identity", true) || n.w(strE, "gzip", true)) ? false : true;
    }

    private final void d(u headers, int i10) {
        String strK = this.headersToRedact.contains(headers.f(i10)) ? "██" : headers.k(i10);
        this.logger.a(headers.f(i10) + ": " + strK);
    }

    public final void c(EnumC0360a enumC0360a) {
        m.f(enumC0360a, "<set-?>");
        this.level = enumC0360a;
    }

    public final a e(EnumC0360a level) {
        m.f(level, "level");
        this.level = level;
        return this;
    }

    public /* synthetic */ a(b bVar, int i10, g gVar) {
        this((i10 & 1) != 0 ? b.f18542b : bVar);
    }
}
