package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13599a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d f13600b = new d(fa.e.BOOLEAN);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d f13601c = new d(fa.e.CHAR);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final d f13602d = new d(fa.e.BYTE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final d f13603e = new d(fa.e.SHORT);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final d f13604f = new d(fa.e.INT);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final d f13605g = new d(fa.e.FLOAT);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final d f13606h = new d(fa.e.LONG);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final d f13607i = new d(fa.e.DOUBLE);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends n {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final n f13608j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n elementType) {
            super(null);
            kotlin.jvm.internal.m.f(elementType, "elementType");
            this.f13608j = elementType;
        }

        public final n i() {
            return this.f13608j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        private b() {
        }

        public final d a() {
            return n.f13600b;
        }

        public final d b() {
            return n.f13602d;
        }

        public final d c() {
            return n.f13601c;
        }

        public final d d() {
            return n.f13607i;
        }

        public final d e() {
            return n.f13605g;
        }

        public final d f() {
            return n.f13604f;
        }

        public final d g() {
            return n.f13606h;
        }

        public final d h() {
            return n.f13603e;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class c extends n {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String f13609j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String internalName) {
            super(null);
            kotlin.jvm.internal.m.f(internalName, "internalName");
            this.f13609j = internalName;
        }

        public final String i() {
            return this.f13609j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class d extends n {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final fa.e f13610j;

        public d(fa.e eVar) {
            super(null);
            this.f13610j = eVar;
        }

        public final fa.e i() {
            return this.f13610j;
        }
    }

    public /* synthetic */ n(kotlin.jvm.internal.g gVar) {
        this();
    }

    private n() {
    }

    public String toString() {
        return p.f13611a.a(this);
    }
}
