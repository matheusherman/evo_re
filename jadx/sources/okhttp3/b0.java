package okhttp3;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.n0;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001bBC\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00122\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0007¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b\u001b\u0010'R*\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u00010\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b$\u0010(\u001a\u0004\b\"\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0011\u00100\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b+\u0010/R\u0011\u00102\u001a\u00020*8G¢\u0006\u0006\u001a\u0004\b\u001f\u00101¨\u00063"}, d2 = {"Lokhttp3/b0;", "", "Lokhttp3/v;", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "", "method", "Lokhttp3/u;", "headers", "Lokhttp3/c0;", "body", "", "Ljava/lang/Class;", "tags", "<init>", "(Lokhttp3/v;Ljava/lang/String;Lokhttp3/u;Lokhttp3/c0;Ljava/util/Map;)V", "name", "d", "(Ljava/lang/String;)Ljava/lang/String;", ExifInterface.GPS_DIRECTION_TRUE, IjkMediaMeta.IJKM_KEY_TYPE, "i", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lokhttp3/b0$a;", "h", "()Lokhttp3/b0$a;", "toString", "()Ljava/lang/String;", "a", "Lokhttp3/v;", "j", "()Lokhttp3/v;", "b", "Ljava/lang/String;", "g", "c", "Lokhttp3/u;", "e", "()Lokhttp3/u;", "Lokhttp3/c0;", "()Lokhttp3/c0;", "Ljava/util/Map;", "()Ljava/util/Map;", "Lokhttp3/d;", "f", "Lokhttp3/d;", "lazyCacheControl", "", "()Z", "isHttps", "()Lokhttp3/d;", "cacheControl", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final v url;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String method;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final u headers;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final c0 body;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Map<Class<?>, Object> tags;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private d lazyCacheControl;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\rJ\u0017\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b \u0010!J/\u0010&\u001a\u00020\u0000\"\u0004\b\u0000\u0010\"2\u000e\u0010$\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000#2\b\u0010%\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0004H\u0016¢\u0006\u0004\b(\u0010)R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010\u001f\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010\u0015\u001a\u0002048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R2\u0010E\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030#\u0012\u0004\u0012\u00020\u00010?8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lokhttp3/b0$a;", "", "<init>", "()V", "Lokhttp3/b0;", "request", "(Lokhttp3/b0;)V", "Lokhttp3/v;", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "l", "(Lokhttp3/v;)Lokhttp3/b0$a;", "", "k", "(Ljava/lang/String;)Lokhttp3/b0$a;", "name", "value", "e", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/b0$a;", "a", "i", "Lokhttp3/u;", "headers", "f", "(Lokhttp3/u;)Lokhttp3/b0$a;", "c", "()Lokhttp3/b0$a;", "d", "Lokhttp3/c0;", "body", "h", "(Lokhttp3/c0;)Lokhttp3/b0$a;", "method", "g", "(Ljava/lang/String;Lokhttp3/c0;)Lokhttp3/b0$a;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", IjkMediaMeta.IJKM_KEY_TYPE, "tag", "j", "(Ljava/lang/Class;Ljava/lang/Object;)Lokhttp3/b0$a;", "b", "()Lokhttp3/b0;", "Lokhttp3/v;", "getUrl$okhttp", "()Lokhttp3/v;", "setUrl$okhttp", "(Lokhttp3/v;)V", "Ljava/lang/String;", "getMethod$okhttp", "()Ljava/lang/String;", "setMethod$okhttp", "(Ljava/lang/String;)V", "Lokhttp3/u$a;", "Lokhttp3/u$a;", "getHeaders$okhttp", "()Lokhttp3/u$a;", "setHeaders$okhttp", "(Lokhttp3/u$a;)V", "Lokhttp3/c0;", "getBody$okhttp", "()Lokhttp3/c0;", "setBody$okhttp", "(Lokhttp3/c0;)V", "", "Ljava/util/Map;", "getTags$okhttp", "()Ljava/util/Map;", "setTags$okhttp", "(Ljava/util/Map;)V", "tags", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private v url;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private String method;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private u.a headers;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private c0 body;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private Map<Class<?>, Object> tags;

        public a() {
            this.tags = new LinkedHashMap();
            this.method = IMediaPlayer.DRM_REQ_GET;
            this.headers = new u.a();
        }

        public a a(String name, String value) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(value, "value");
            this.headers.a(name, value);
            return this;
        }

        public b0 b() {
            v vVar = this.url;
            if (vVar != null) {
                return new b0(vVar, this.method, this.headers.f(), this.body, hb.d.T(this.tags));
            }
            throw new IllegalStateException("url == null");
        }

        public a c() {
            return g(IMediaPlayer.DRM_REQ_GET, null);
        }

        public a d() {
            return g("HEAD", null);
        }

        public a e(String name, String value) {
            kotlin.jvm.internal.m.f(name, "name");
            kotlin.jvm.internal.m.f(value, "value");
            this.headers.i(name, value);
            return this;
        }

        public a f(u headers) {
            kotlin.jvm.internal.m.f(headers, "headers");
            this.headers = headers.h();
            return this;
        }

        public a g(String method, c0 body) {
            kotlin.jvm.internal.m.f(method, "method");
            if (method.length() <= 0) {
                throw new IllegalArgumentException("method.isEmpty() == true");
            }
            if (body == null) {
                if (lb.f.d(method)) {
                    throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
                }
            } else if (!lb.f.a(method)) {
                throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
            }
            this.method = method;
            this.body = body;
            return this;
        }

        public a h(c0 body) {
            kotlin.jvm.internal.m.f(body, "body");
            return g(IMediaPlayer.DRM_REQ_POST, body);
        }

        public a i(String name) {
            kotlin.jvm.internal.m.f(name, "name");
            this.headers.h(name);
            return this;
        }

        public <T> a j(Class<? super T> type, T tag) {
            kotlin.jvm.internal.m.f(type, "type");
            if (tag == null) {
                this.tags.remove(type);
                return this;
            }
            if (this.tags.isEmpty()) {
                this.tags = new LinkedHashMap();
            }
            Map<Class<?>, Object> map = this.tags;
            T tCast = type.cast(tag);
            kotlin.jvm.internal.m.c(tCast);
            map.put(type, tCast);
            return this;
        }

        public a k(String url) {
            kotlin.jvm.internal.m.f(url, "url");
            if (ua.n.G(url, "ws:", true)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("http:");
                String strSubstring = url.substring(3);
                kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String).substring(startIndex)");
                sb2.append(strSubstring);
                url = sb2.toString();
            } else if (ua.n.G(url, "wss:", true)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("https:");
                String strSubstring2 = url.substring(4);
                kotlin.jvm.internal.m.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
                sb3.append(strSubstring2);
                url = sb3.toString();
            }
            return l(v.INSTANCE.d(url));
        }

        public a l(v url) {
            kotlin.jvm.internal.m.f(url, "url");
            this.url = url;
            return this;
        }

        public a(b0 request) {
            Map<Class<?>, Object> mapU;
            kotlin.jvm.internal.m.f(request, "request");
            this.tags = new LinkedHashMap();
            this.url = request.getUrl();
            this.method = request.getMethod();
            this.body = request.getBody();
            if (request.c().isEmpty()) {
                mapU = new LinkedHashMap<>();
            } else {
                mapU = n0.u(request.c());
            }
            this.tags = mapU;
            this.headers = request.getHeaders().h();
        }
    }

    public b0(v url, String method, u headers, c0 c0Var, Map<Class<?>, ? extends Object> tags) {
        kotlin.jvm.internal.m.f(url, "url");
        kotlin.jvm.internal.m.f(method, "method");
        kotlin.jvm.internal.m.f(headers, "headers");
        kotlin.jvm.internal.m.f(tags, "tags");
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.body = c0Var;
        this.tags = tags;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final c0 getBody() {
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

    public final Map<Class<?>, Object> c() {
        return this.tags;
    }

    public final String d(String name) {
        kotlin.jvm.internal.m.f(name, "name");
        return this.headers.e(name);
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final u getHeaders() {
        return this.headers;
    }

    public final boolean f() {
        return this.url.getIsHttps();
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    public final a h() {
        return new a(this);
    }

    public final <T> T i(Class<? extends T> type) {
        kotlin.jvm.internal.m.f(type, "type");
        return type.cast(this.tags.get(type));
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final v getUrl() {
        return this.url;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Request{method=");
        sb2.append(this.method);
        sb2.append(", url=");
        sb2.append(this.url);
        if (this.headers.size() != 0) {
            sb2.append(", headers=[");
            int i10 = 0;
            for (r8.p<? extends String, ? extends String> pVar : this.headers) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.r.v();
                }
                r8.p<? extends String, ? extends String> pVar2 = pVar;
                String strA = pVar2.a();
                String strB = pVar2.b();
                if (i10 > 0) {
                    sb2.append(", ");
                }
                sb2.append(strA);
                sb2.append(':');
                sb2.append(strB);
                i10 = i11;
            }
            sb2.append(']');
        }
        if (!this.tags.isEmpty()) {
            sb2.append(", tags=");
            sb2.append(this.tags);
        }
        sb2.append('}');
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
