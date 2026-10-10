package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f13491d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final w f13492e = new w(g0.STRICT, null, null, 6, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g0 f13493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final r8.g f13494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g0 f13495c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final w a() {
            return w.f13492e;
        }
    }

    public w(g0 reportLevelBefore, r8.g gVar, g0 reportLevelAfter) {
        kotlin.jvm.internal.m.f(reportLevelBefore, "reportLevelBefore");
        kotlin.jvm.internal.m.f(reportLevelAfter, "reportLevelAfter");
        this.f13493a = reportLevelBefore;
        this.f13494b = gVar;
        this.f13495c = reportLevelAfter;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f13493a == wVar.f13493a && kotlin.jvm.internal.m.a(this.f13494b, wVar.f13494b) && this.f13495c == wVar.f13495c;
    }

    public final g0 b() {
        return this.f13495c;
    }

    public final g0 c() {
        return this.f13493a;
    }

    public final r8.g d() {
        return this.f13494b;
    }

    public int hashCode() {
        int iHashCode = this.f13493a.hashCode() * 31;
        r8.g gVar = this.f13494b;
        return ((iHashCode + (gVar == null ? 0 : gVar.getVersion())) * 31) + this.f13495c.hashCode();
    }

    public String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.f13493a + ", sinceVersion=" + this.f13494b + ", reportLevelAfter=" + this.f13495c + ')';
    }

    public /* synthetic */ w(g0 g0Var, r8.g gVar, g0 g0Var2, int i10, kotlin.jvm.internal.g gVar2) {
        this(g0Var, (i10 & 2) != 0 ? new r8.g(1, 0) : gVar, (i10 & 4) != 0 ? g0Var : g0Var2);
    }
}
