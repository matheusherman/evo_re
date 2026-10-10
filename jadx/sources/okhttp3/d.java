package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0019\u0018\u0000 (2\u00020\u0001:\u0002\u0016\u001aBs\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b\u0007\u0010\u001eR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u0017\u001a\u0004\b\u0016\u0010\u0019R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b!\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u001b\u0010\u001d\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010\f\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b \u0010\u001eR\u0017\u0010\r\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b\"\u0010\u0019R\u0017\u0010\u000e\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b$\u0010\u0017\u001a\u0004\b\u000e\u0010\u0019R\u0017\u0010\u000f\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b%\u0010\u0017\u001a\u0004\b\u000f\u0010\u0019R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lokhttp3/d;", "", "", "noCache", "noStore", "", "maxAgeSeconds", "sMaxAgeSeconds", "isPrivate", "isPublic", "mustRevalidate", "maxStaleSeconds", "minFreshSeconds", "onlyIfCached", "noTransform", "immutable", "", "headerValue", "<init>", "(ZZIIZZZIIZZZLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "a", "Z", "g", "()Z", "b", "h", "c", "I", "()I", "d", "e", "f", "i", "j", "k", "l", "m", "Ljava/lang/String;", "n", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d f16640o = new a().d().a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d f16641p = new a().e().c(Integer.MAX_VALUE, TimeUnit.SECONDS).a();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean noCache;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean noStore;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int maxAgeSeconds;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int sMaxAgeSeconds;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isPrivate;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isPublic;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean mustRevalidate;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int maxStaleSeconds;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int minFreshSeconds;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final boolean onlyIfCached;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final boolean noTransform;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final boolean immutable;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String headerValue;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0000¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\tJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0016\u0010\u001e\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0016\u0010 \u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0014¨\u0006!"}, d2 = {"Lokhttp3/d$a;", "", "<init>", "()V", "", "", "b", "(J)I", "d", "()Lokhttp3/d$a;", "maxStale", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "c", "(ILjava/util/concurrent/TimeUnit;)Lokhttp3/d$a;", "e", "Lokhttp3/d;", "a", "()Lokhttp3/d;", "", "Z", "noCache", "noStore", "I", "maxAgeSeconds", "maxStaleSeconds", "minFreshSeconds", "f", "onlyIfCached", "g", "noTransform", "h", "immutable", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean noCache;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean noStore;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int maxAgeSeconds = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int maxStaleSeconds = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int minFreshSeconds = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean onlyIfCached;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        private boolean noTransform;

        /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
        private boolean immutable;

        public final a d() {
            this.noCache = true;
            return this;
        }

        public final a e() {
            this.onlyIfCached = true;
            return this;
        }

        public final d a() {
            return new d(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }

        public final a c(int maxStale, TimeUnit timeUnit) {
            kotlin.jvm.internal.m.f(timeUnit, "timeUnit");
            if (maxStale >= 0) {
                this.maxStaleSeconds = b(timeUnit.toSeconds(maxStale));
                return this;
            }
            throw new IllegalArgumentException(("maxStale < 0: " + maxStale).toString());
        }

        private final int b(long j10) {
            if (j10 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) j10;
        }
    }

    /* JADX INFO: renamed from: okhttp3.d$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lokhttp3/d$b;", "", "<init>", "()V", "", "characters", "", "startIndex", "a", "(Ljava/lang/String;Ljava/lang/String;I)I", "Lokhttp3/u;", "headers", "Lokhttp3/d;", "b", "(Lokhttp3/u;)Lokhttp3/d;", "FORCE_CACHE", "Lokhttp3/d;", "FORCE_NETWORK", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:15:0x004b  */
        /* JADX WARN: Code duplicated, block: B:17:0x006a  */
        /* JADX WARN: Code duplicated, block: B:28:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:40:0x010d  */
        /* JADX WARN: Code duplicated, block: B:43:0x011b  */
        /* JADX WARN: Code duplicated, block: B:55:0x0162  */
        /* JADX WARN: Code duplicated, block: B:58:0x0170  */
        /* JADX WARN: Code duplicated, block: B:76:0x00e5 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:77:0x00f7 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:78:0x00db A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:79:0x019f A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:80:0x00ed A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:81:0x0123 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:82:0x0135 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:83:0x0147 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:84:0x0179 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:85:0x018c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:86:0x0104 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:87:0x00ff A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:88:0x0115 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:89:0x015a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:90:0x016a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:91:0x0197 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:92:0x0184 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:93:0x0152 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:94:0x013f A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:95:0x012d A[SYNTHETIC] */
        public final d b(u headers) {
            int iA;
            int iA2;
            String string;
            String string2;
            u headers2 = headers;
            kotlin.jvm.internal.m.f(headers2, "headers");
            int size = headers2.size();
            boolean z10 = true;
            int i10 = 0;
            boolean z11 = true;
            String str = null;
            boolean z12 = false;
            boolean z13 = false;
            int iV = -1;
            int iV2 = -1;
            boolean z14 = false;
            boolean z15 = false;
            boolean z16 = false;
            int iV3 = -1;
            int iV4 = -1;
            boolean z17 = false;
            boolean z18 = false;
            boolean z19 = false;
            while (i10 < size) {
                String strF = headers2.f(i10);
                String strK = headers2.k(i10);
                if (ua.n.w(strF, "Cache-Control", z10)) {
                    if (str == null) {
                        str = strK;
                    }
                    iA = 0;
                    while (iA < strK.length()) {
                        iA2 = a(strK, "=,;", iA);
                        String strSubstring = strK.substring(iA, iA2);
                        kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        string = ua.n.Q0(strSubstring).toString();
                        if (iA2 != strK.length()) {
                            size = size;
                            if (strK.charAt(iA2) == ',' && strK.charAt(iA2) != ';') {
                                int iD = hb.d.D(strK, iA2 + 1);
                                if (iD >= strK.length() || strK.charAt(iD) != '\"') {
                                    strK = strK;
                                    iA = a(strK, ",;", iD);
                                    String strSubstring2 = strK.substring(iD, iA);
                                    kotlin.jvm.internal.m.e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                                    string2 = ua.n.Q0(strSubstring2).toString();
                                } else {
                                    int i11 = iD + 1;
                                    String str2 = strK;
                                    int iA0 = ua.n.a0(str2, '\"', i11, false, 4, null);
                                    strK = str2;
                                    String strSubstring3 = strK.substring(i11, iA0);
                                    kotlin.jvm.internal.m.e(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                                    iA = iA0 + 1;
                                    string2 = strSubstring3;
                                }
                            }
                            if (ua.n.w("no-cache", string, true)) {
                                z12 = true;
                            } else if (ua.n.w("no-store", string, true)) {
                                z13 = true;
                            } else if (ua.n.w("max-age", string, true)) {
                                iV = hb.d.V(string2, -1);
                            } else if (ua.n.w("s-maxage", string, true)) {
                                iV2 = hb.d.V(string2, -1);
                            } else if (ua.n.w("private", string, true)) {
                                z14 = true;
                            } else if (ua.n.w("public", string, true)) {
                                z15 = true;
                            } else if (ua.n.w("must-revalidate", string, true)) {
                                z16 = true;
                            } else if (ua.n.w("max-stale", string, true)) {
                                iV3 = hb.d.V(string2, Integer.MAX_VALUE);
                            } else if (ua.n.w("min-fresh", string, true)) {
                                iV4 = hb.d.V(string2, -1);
                            } else if (ua.n.w("only-if-cached", string, true)) {
                                z17 = true;
                            } else if (ua.n.w("no-transform", string, true)) {
                                z18 = true;
                            } else if (ua.n.w("immutable", string, true)) {
                                z19 = true;
                            }
                        } else {
                            size = size;
                        }
                        strK = strK;
                        iA = iA2 + 1;
                        string2 = null;
                        if (ua.n.w("no-cache", string, true)) {
                            z12 = true;
                        } else if (ua.n.w("no-store", string, true)) {
                            z13 = true;
                        } else if (ua.n.w("max-age", string, true)) {
                            iV = hb.d.V(string2, -1);
                        } else if (ua.n.w("s-maxage", string, true)) {
                            iV2 = hb.d.V(string2, -1);
                        } else if (ua.n.w("private", string, true)) {
                            z14 = true;
                        } else if (ua.n.w("public", string, true)) {
                            z15 = true;
                        } else if (ua.n.w("must-revalidate", string, true)) {
                            z16 = true;
                        } else if (ua.n.w("max-stale", string, true)) {
                            iV3 = hb.d.V(string2, Integer.MAX_VALUE);
                        } else if (ua.n.w("min-fresh", string, true)) {
                            iV4 = hb.d.V(string2, -1);
                        } else if (ua.n.w("only-if-cached", string, true)) {
                            z17 = true;
                        } else if (ua.n.w("no-transform", string, true)) {
                            z18 = true;
                        } else if (ua.n.w("immutable", string, true)) {
                            z19 = true;
                        }
                    }
                    i10++;
                    headers2 = headers;
                    size = size;
                    z10 = true;
                } else {
                    if (ua.n.w(strF, "Pragma", z10)) {
                    }
                    i10++;
                    headers2 = headers;
                    size = size;
                    z10 = true;
                }
                z11 = false;
                iA = 0;
                while (iA < strK.length()) {
                    iA2 = a(strK, "=,;", iA);
                    String strSubstring4 = strK.substring(iA, iA2);
                    kotlin.jvm.internal.m.e(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
                    string = ua.n.Q0(strSubstring4).toString();
                    if (iA2 != strK.length()) {
                        size = size;
                        if (strK.charAt(iA2) == ',') {
                        }
                        if (ua.n.w("no-cache", string, true)) {
                            z12 = true;
                        } else if (ua.n.w("no-store", string, true)) {
                            z13 = true;
                        } else if (ua.n.w("max-age", string, true)) {
                            iV = hb.d.V(string2, -1);
                        } else if (ua.n.w("s-maxage", string, true)) {
                            iV2 = hb.d.V(string2, -1);
                        } else if (ua.n.w("private", string, true)) {
                            z14 = true;
                        } else if (ua.n.w("public", string, true)) {
                            z15 = true;
                        } else if (ua.n.w("must-revalidate", string, true)) {
                            z16 = true;
                        } else if (ua.n.w("max-stale", string, true)) {
                            iV3 = hb.d.V(string2, Integer.MAX_VALUE);
                        } else if (ua.n.w("min-fresh", string, true)) {
                            iV4 = hb.d.V(string2, -1);
                        } else if (ua.n.w("only-if-cached", string, true)) {
                            z17 = true;
                        } else if (ua.n.w("no-transform", string, true)) {
                            z18 = true;
                        } else if (ua.n.w("immutable", string, true)) {
                            z19 = true;
                        }
                    } else {
                        size = size;
                    }
                    strK = strK;
                    iA = iA2 + 1;
                    string2 = null;
                    if (ua.n.w("no-cache", string, true)) {
                        z12 = true;
                    } else if (ua.n.w("no-store", string, true)) {
                        z13 = true;
                    } else if (ua.n.w("max-age", string, true)) {
                        iV = hb.d.V(string2, -1);
                    } else if (ua.n.w("s-maxage", string, true)) {
                        iV2 = hb.d.V(string2, -1);
                    } else if (ua.n.w("private", string, true)) {
                        z14 = true;
                    } else if (ua.n.w("public", string, true)) {
                        z15 = true;
                    } else if (ua.n.w("must-revalidate", string, true)) {
                        z16 = true;
                    } else if (ua.n.w("max-stale", string, true)) {
                        iV3 = hb.d.V(string2, Integer.MAX_VALUE);
                    } else if (ua.n.w("min-fresh", string, true)) {
                        iV4 = hb.d.V(string2, -1);
                    } else if (ua.n.w("only-if-cached", string, true)) {
                        z17 = true;
                    } else if (ua.n.w("no-transform", string, true)) {
                        z18 = true;
                    } else if (ua.n.w("immutable", string, true)) {
                        z19 = true;
                    }
                }
                i10++;
                headers2 = headers;
                size = size;
                z10 = true;
            }
            return new d(z12, z13, iV, iV2, z14, z15, z16, iV3, iV4, z17, z18, z19, !z11 ? null : str, null);
        }

        private final int a(String str, String str2, int i10) {
            int length = str.length();
            while (i10 < length) {
                if (ua.n.N(str2, str.charAt(i10), false, 2, null)) {
                    return i10;
                }
                i10++;
            }
            return str.length();
        }
    }

    public /* synthetic */ d(boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, int i12, int i13, boolean z15, boolean z16, boolean z17, String str, kotlin.jvm.internal.g gVar) {
        this(z10, z11, i10, i11, z12, z13, z14, i12, i13, z15, z16, z17, str);
    }

    private d(boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, int i12, int i13, boolean z15, boolean z16, boolean z17, String str) {
        this.noCache = z10;
        this.noStore = z11;
        this.maxAgeSeconds = i10;
        this.sMaxAgeSeconds = i11;
        this.isPrivate = z12;
        this.isPublic = z13;
        this.mustRevalidate = z14;
        this.maxStaleSeconds = i12;
        this.minFreshSeconds = i13;
        this.onlyIfCached = z15;
        this.noTransform = z16;
        this.immutable = z17;
        this.headerValue = str;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getIsPrivate() {
        return this.isPrivate;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getIsPublic() {
        return this.isPublic;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getMaxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getMinFreshSeconds() {
        return this.minFreshSeconds;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final boolean getMustRevalidate() {
        return this.mustRevalidate;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final boolean getNoCache() {
        return this.noCache;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final boolean getNoStore() {
        return this.noStore;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final boolean getOnlyIfCached() {
        return this.onlyIfCached;
    }

    public String toString() {
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.noCache) {
            sb2.append("no-cache, ");
        }
        if (this.noStore) {
            sb2.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            sb2.append("max-age=");
            sb2.append(this.maxAgeSeconds);
            sb2.append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            sb2.append("s-maxage=");
            sb2.append(this.sMaxAgeSeconds);
            sb2.append(", ");
        }
        if (this.isPrivate) {
            sb2.append("private, ");
        }
        if (this.isPublic) {
            sb2.append("public, ");
        }
        if (this.mustRevalidate) {
            sb2.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            sb2.append("max-stale=");
            sb2.append(this.maxStaleSeconds);
            sb2.append(", ");
        }
        if (this.minFreshSeconds != -1) {
            sb2.append("min-fresh=");
            sb2.append(this.minFreshSeconds);
            sb2.append(", ");
        }
        if (this.onlyIfCached) {
            sb2.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb2.append("no-transform, ");
        }
        if (this.immutable) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        this.headerValue = string;
        return string;
    }
}
