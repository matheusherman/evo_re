package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f13496d = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final x f13497e = new x(v.b(null, 1, null), a.f13501a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z f13498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c9.l<ba.c, g0> f13499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f13500c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    /* synthetic */ class a extends kotlin.jvm.internal.j implements c9.l<ba.c, g0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13501a = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, i9.c
        public final String getName() {
            return "getDefaultReportLevelForAnnotation";
        }

        @Override // kotlin.jvm.internal.c
        public final i9.f getOwner() {
            return kotlin.jvm.internal.c0.d(v.class, "compiler.common.jvm");
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "getDefaultReportLevelForAnnotation(Lorg/jetbrains/kotlin/name/FqName;)Lorg/jetbrains/kotlin/load/java/ReportLevel;";
        }

        @Override // c9.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final g0 invoke(ba.c p10) {
            kotlin.jvm.internal.m.f(p10, "p0");
            return v.d(p10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        private b() {
        }

        public final x a() {
            return x.f13497e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(z jsr305, c9.l<? super ba.c, ? extends g0> getReportLevelForAnnotation) {
        kotlin.jvm.internal.m.f(jsr305, "jsr305");
        kotlin.jvm.internal.m.f(getReportLevelForAnnotation, "getReportLevelForAnnotation");
        this.f13498a = jsr305;
        this.f13499b = getReportLevelForAnnotation;
        this.f13500c = jsr305.d() || getReportLevelForAnnotation.invoke(v.e()) == g0.IGNORE;
    }

    public final boolean b() {
        return this.f13500c;
    }

    public final c9.l<ba.c, g0> c() {
        return this.f13499b;
    }

    public final z d() {
        return this.f13498a;
    }

    public String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.f13498a + ", getReportLevelForAnnotation=" + this.f13499b + ')';
    }
}
