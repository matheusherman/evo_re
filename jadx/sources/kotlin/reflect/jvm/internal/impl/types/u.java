package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class u extends n1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f14376e = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n1 f14377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final n1 f14378d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final n1 a(n1 first, n1 second) {
            kotlin.jvm.internal.m.f(first, "first");
            kotlin.jvm.internal.m.f(second, "second");
            if (first.f()) {
                return second;
            }
            return second.f() ? first : new u(first, second, null);
        }
    }

    public /* synthetic */ u(n1 n1Var, n1 n1Var2, kotlin.jvm.internal.g gVar) {
        this(n1Var, n1Var2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n1
    public boolean f() {
        return false;
    }

    private u(n1 n1Var, n1 n1Var2) {
        this.f14377c = n1Var;
        this.f14378d = n1Var2;
    }

    public static final n1 i(n1 n1Var, n1 n1Var2) {
        return f14376e.a(n1Var, n1Var2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n1
    public boolean a() {
        return this.f14377c.a() || this.f14378d.a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n1
    public boolean b() {
        return this.f14377c.b() || this.f14378d.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n1
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g d(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations) {
        kotlin.jvm.internal.m.f(annotations, "annotations");
        return this.f14378d.d(this.f14377c.d(annotations));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n1
    public k1 e(g0 key) {
        kotlin.jvm.internal.m.f(key, "key");
        k1 k1VarE = this.f14377c.e(key);
        return k1VarE == null ? this.f14378d.e(key) : k1VarE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n1
    public g0 g(g0 topLevelType, w1 position) {
        kotlin.jvm.internal.m.f(topLevelType, "topLevelType");
        kotlin.jvm.internal.m.f(position, "position");
        return this.f14378d.g(this.f14377c.g(topLevelType, position), position);
    }
}
