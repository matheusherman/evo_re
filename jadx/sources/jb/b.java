package jb;

import hb.d;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import lb.c;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.u;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000e2\u00020\u0001:\u0002\b\nB\u001d\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\b\u0010\r¨\u0006\u000f"}, d2 = {"Ljb/b;", "", "Lokhttp3/b0;", "networkRequest", "Lokhttp3/d0;", "cacheResponse", "<init>", "(Lokhttp3/b0;Lokhttp3/d0;)V", "a", "Lokhttp3/b0;", "b", "()Lokhttp3/b0;", "Lokhttp3/d0;", "()Lokhttp3/d0;", "c", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b0 networkRequest;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final d0 cacheResponse;

    /* JADX INFO: renamed from: jb.b$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ljb/b$a;", "", "<init>", "()V", "Lokhttp3/d0;", "response", "Lokhttp3/b0;", "request", "", "a", "(Lokhttp3/d0;Lokhttp3/b0;)Z", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:24:0x003b  */
        public final boolean a(d0 response, b0 request) {
            m.f(response, "response");
            m.f(request, "request");
            int code = response.getCode();
            if (code != 200 && code != 410 && code != 414 && code != 501 && code != 203 && code != 204) {
                if (code == 307) {
                    if (d0.l(response, "Expires", null, 2, null) == null && response.b().getMaxAgeSeconds() == -1 && !response.b().getIsPublic() && !response.b().getIsPrivate()) {
                        return false;
                    }
                } else if (code != 308 && code != 404 && code != 405) {
                    switch (code) {
                        case 300:
                        case 301:
                            break;
                        case 302:
                            if (d0.l(response, "Expires", null, 2, null) == null) {
                                return false;
                            }
                            break;
                        default:
                            return false;
                    }
                }
            }
            return (response.b().getNoStore() || request.b().getNoStore()) ? false : true;
        }
    }

    /* JADX INFO: renamed from: jb.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\u0018\u0010#\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001fR\u0018\u0010%\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001cR\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\u0016R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\u0016R\u0018\u0010+\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\u001fR\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u00060"}, d2 = {"Ljb/b$b;", "", "", "nowMillis", "Lokhttp3/b0;", "request", "Lokhttp3/d0;", "cacheResponse", "<init>", "(JLokhttp3/b0;Lokhttp3/d0;)V", "", "f", "()Z", "Ljb/b;", "c", "()Ljb/b;", "d", "()J", "a", "e", "(Lokhttp3/b0;)Z", "b", "J", "Lokhttp3/b0;", "getRequest$okhttp", "()Lokhttp3/b0;", "Lokhttp3/d0;", "Ljava/util/Date;", "Ljava/util/Date;", "servedDate", "", "Ljava/lang/String;", "servedDateString", "lastModified", "g", "lastModifiedString", "h", "expires", "i", "sentRequestMillis", "j", "receivedResponseMillis", "k", "etag", "", "l", "I", "ageSeconds", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class C0199b {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long nowMillis;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final b0 request;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final d0 cacheResponse;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private Date servedDate;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private String servedDateString;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private Date lastModified;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        private String lastModifiedString;

        /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
        private Date expires;

        /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
        private long sentRequestMillis;

        /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
        private long receivedResponseMillis;

        /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
        private String etag;

        /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
        private int ageSeconds;

        public C0199b(long j10, b0 request, d0 d0Var) {
            m.f(request, "request");
            this.nowMillis = j10;
            this.request = request;
            this.cacheResponse = d0Var;
            this.ageSeconds = -1;
            if (d0Var != null) {
                this.sentRequestMillis = d0Var.getSentRequestAtMillis();
                this.receivedResponseMillis = d0Var.getReceivedResponseAtMillis();
                u headers = d0Var.getHeaders();
                int size = headers.size();
                for (int i10 = 0; i10 < size; i10++) {
                    String strF = headers.f(i10);
                    String strK = headers.k(i10);
                    if (n.w(strF, "Date", true)) {
                        this.servedDate = c.a(strK);
                        this.servedDateString = strK;
                    } else if (n.w(strF, "Expires", true)) {
                        this.expires = c.a(strK);
                    } else if (n.w(strF, "Last-Modified", true)) {
                        this.lastModified = c.a(strK);
                        this.lastModifiedString = strK;
                    } else if (n.w(strF, "ETag", true)) {
                        this.etag = strK;
                    } else if (n.w(strF, "Age", true)) {
                        this.ageSeconds = d.V(strK, -1);
                    }
                }
            }
        }

        private final long a() {
            Date date = this.servedDate;
            long jMax = date != null ? Math.max(0L, this.receivedResponseMillis - date.getTime()) : 0L;
            int i10 = this.ageSeconds;
            if (i10 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i10));
            }
            long j10 = this.receivedResponseMillis;
            return jMax + (j10 - this.sentRequestMillis) + (this.nowMillis - j10);
        }

        private final b c() {
            String str;
            if (this.cacheResponse == null) {
                return new b(this.request, null);
            }
            if (this.request.f() && this.cacheResponse.getHandshake() == null) {
                return new b(this.request, null);
            }
            if (!b.INSTANCE.a(this.cacheResponse, this.request)) {
                return new b(this.request, null);
            }
            okhttp3.d dVarB = this.request.b();
            if (dVarB.getNoCache() || e(this.request)) {
                return new b(this.request, null);
            }
            okhttp3.d dVarB2 = this.cacheResponse.b();
            long jA = a();
            long jD = d();
            if (dVarB.getMaxAgeSeconds() != -1) {
                jD = Math.min(jD, TimeUnit.SECONDS.toMillis(dVarB.getMaxAgeSeconds()));
            }
            long millis = 0;
            long millis2 = dVarB.getMinFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(dVarB.getMinFreshSeconds()) : 0L;
            if (!dVarB2.getMustRevalidate() && dVarB.getMaxStaleSeconds() != -1) {
                millis = TimeUnit.SECONDS.toMillis(dVarB.getMaxStaleSeconds());
            }
            if (!dVarB2.getNoCache()) {
                long j10 = millis2 + jA;
                if (j10 < millis + jD) {
                    d0.a aVarQ = this.cacheResponse.q();
                    if (j10 >= jD) {
                        aVarQ.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jA > 86400000 && f()) {
                        aVarQ.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new b(null, aVarQ.c());
                }
            }
            String str2 = this.etag;
            if (str2 != null) {
                str = "If-None-Match";
            } else {
                if (this.lastModified != null) {
                    str2 = this.lastModifiedString;
                } else {
                    if (this.servedDate == null) {
                        return new b(this.request, null);
                    }
                    str2 = this.servedDateString;
                }
                str = "If-Modified-Since";
            }
            u.a aVarH = this.request.getHeaders().h();
            m.c(str2);
            aVarH.d(str, str2);
            return new b(this.request.h().f(aVarH.f()).b(), this.cacheResponse);
        }

        private final long d() {
            d0 d0Var = this.cacheResponse;
            m.c(d0Var);
            okhttp3.d dVarB = d0Var.b();
            if (dVarB.getMaxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(dVarB.getMaxAgeSeconds());
            }
            Date date = this.expires;
            if (date != null) {
                Date date2 = this.servedDate;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.receivedResponseMillis);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.lastModified != null && this.cacheResponse.getRequest().getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String().o() == null) {
                Date date3 = this.servedDate;
                long time2 = date3 != null ? date3.getTime() : this.sentRequestMillis;
                Date date4 = this.lastModified;
                m.c(date4);
                long time3 = time2 - date4.getTime();
                if (time3 > 0) {
                    return time3 / ((long) 10);
                }
            }
            return 0L;
        }

        private final boolean e(b0 request) {
            return (request.d("If-Modified-Since") == null && request.d("If-None-Match") == null) ? false : true;
        }

        private final boolean f() {
            d0 d0Var = this.cacheResponse;
            m.c(d0Var);
            return d0Var.b().getMaxAgeSeconds() == -1 && this.expires == null;
        }

        public final b b() {
            b bVarC = c();
            if (bVarC.getNetworkRequest() != null && this.request.b().getOnlyIfCached()) {
                return new b(null, null);
            }
            return bVarC;
        }
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final d0 getCacheResponse() {
        return this.cacheResponse;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final b0 getNetworkRequest() {
        return this.networkRequest;
    }

    public b(b0 b0Var, d0 d0Var) {
        this.networkRequest = b0Var;
        this.cacheResponse = d0Var;
    }
}
