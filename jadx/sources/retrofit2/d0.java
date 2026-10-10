package retrofit2;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class d0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final char[] f17949l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Pattern f17950m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f17951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final okhttp3.v f17952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f17953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private okhttp3.v.a f17954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final okhttp3.b0.a f17955e = new okhttp3.b0.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final okhttp3.u.a f17956f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private okhttp3.x f17957g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f17958h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private okhttp3.y.a f17959i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private okhttp3.s.a f17960j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private okhttp3.c0 f17961k;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class a extends okhttp3.c0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final okhttp3.c0 f17962b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final okhttp3.x f17963c;

        @Override // okhttp3.c0
        public long a() {
            return this.f17962b.a();
        }

        @Override // okhttp3.c0
        /* JADX INFO: renamed from: b */
        public okhttp3.x getContentType() {
            return this.f17963c;
        }

        @Override // okhttp3.c0
        public void i(tb.e eVar) {
            this.f17962b.i(eVar);
        }

        a(okhttp3.c0 c0Var, okhttp3.x xVar) {
            this.f17962b = c0Var;
            this.f17963c = xVar;
        }
    }

    private static void j(tb.d dVar, String str, int i10, int i11, boolean z10) {
        tb.d dVar2 = null;
        while (i10 < i11) {
            int iCodePointAt = str.codePointAt(i10);
            if (!z10 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z10 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                    if (dVar2 == null) {
                        dVar2 = new tb.d();
                    }
                    dVar2.o0(iCodePointAt);
                    while (!dVar2.L()) {
                        byte b10 = dVar2.readByte();
                        dVar.writeByte(37);
                        char[] cArr = f17949l;
                        dVar.writeByte(cArr[((b10 & 255) >> 4) & 15]);
                        dVar.writeByte(cArr[b10 & 15]);
                    }
                } else {
                    dVar.o0(iCodePointAt);
                }
            }
            i10 += Character.charCount(iCodePointAt);
        }
    }

    void a(String str, String str2, boolean z10) {
        if (z10) {
            this.f17960j.b(str, str2);
        } else {
            this.f17960j.a(str, str2);
        }
    }

    void b(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.f17956f.a(str, str2);
            return;
        }
        try {
            this.f17957g = okhttp3.x.e(str2);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException("Malformed content type: " + str2, e10);
        }
    }

    void c(okhttp3.u uVar) {
        this.f17956f.b(uVar);
    }

    void d(okhttp3.u uVar, okhttp3.c0 c0Var) {
        this.f17959i.c(uVar, c0Var);
    }

    void e(okhttp3.y.c cVar) {
        this.f17959i.d(cVar);
    }

    void f(String str, String str2, boolean z10) {
        if (this.f17953c == null) {
            throw new AssertionError();
        }
        String strI = i(str2, z10);
        String strReplace = this.f17953c.replace("{" + str + "}", strI);
        if (!f17950m.matcher(strReplace).matches()) {
            this.f17953c = strReplace;
            return;
        }
        throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
    }

    void g(String str, String str2, boolean z10) {
        String str3 = this.f17953c;
        if (str3 != null) {
            okhttp3.v.a aVarL = this.f17952b.l(str3);
            this.f17954d = aVarL;
            if (aVarL == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f17952b + ", Relative: " + this.f17953c);
            }
            this.f17953c = null;
        }
        if (z10) {
            this.f17954d.a(str, str2);
        } else {
            this.f17954d.b(str, str2);
        }
    }

    <T> void h(Class<T> cls, T t10) {
        this.f17955e.j(cls, t10);
    }

    okhttp3.b0.a k() {
        okhttp3.v vVarS;
        okhttp3.v.a aVar = this.f17954d;
        if (aVar != null) {
            vVarS = aVar.c();
        } else {
            vVarS = this.f17952b.s(this.f17953c);
            if (vVarS == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f17952b + ", Relative: " + this.f17953c);
            }
        }
        okhttp3.c0 aVar2 = this.f17961k;
        if (aVar2 == null) {
            okhttp3.s.a aVar3 = this.f17960j;
            if (aVar3 != null) {
                aVar2 = aVar3.c();
            } else {
                okhttp3.y.a aVar4 = this.f17959i;
                if (aVar4 != null) {
                    aVar2 = aVar4.e();
                } else if (this.f17958h) {
                    aVar2 = okhttp3.c0.e(null, new byte[0]);
                }
            }
        }
        okhttp3.x xVar = this.f17957g;
        if (xVar != null) {
            if (aVar2 != null) {
                aVar2 = new a(aVar2, xVar);
            } else {
                this.f17956f.a("Content-Type", xVar.getMediaType());
            }
        }
        return this.f17955e.l(vVarS).f(this.f17956f.f()).g(this.f17951a, aVar2);
    }

    void l(okhttp3.c0 c0Var) {
        this.f17961k = c0Var;
    }

    d0(String str, okhttp3.v vVar, String str2, okhttp3.u uVar, okhttp3.x xVar, boolean z10, boolean z11, boolean z12) {
        this.f17951a = str;
        this.f17952b = vVar;
        this.f17953c = str2;
        this.f17957g = xVar;
        this.f17958h = z10;
        if (uVar != null) {
            this.f17956f = uVar.h();
        } else {
            this.f17956f = new okhttp3.u.a();
        }
        if (z11) {
            this.f17960j = new okhttp3.s.a();
        } else if (z12) {
            okhttp3.y.a aVar = new okhttp3.y.a();
            this.f17959i = aVar;
            aVar.f(okhttp3.y.f16995l);
        }
    }

    private static String i(String str, boolean z10) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt < 127 && " \"<>^`{}|\\?#".indexOf(iCodePointAt) == -1 && (z10 || (iCodePointAt != 47 && iCodePointAt != 37))) {
                iCharCount += Character.charCount(iCodePointAt);
            } else {
                tb.d dVar = new tb.d();
                dVar.n0(str, 0, iCharCount);
                j(dVar, str, iCharCount, length, z10);
                return dVar.v();
            }
        }
        return str;
    }

    void m(Object obj) {
        this.f17953c = obj.toString();
    }
}
