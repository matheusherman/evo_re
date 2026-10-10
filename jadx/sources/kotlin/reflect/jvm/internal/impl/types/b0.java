package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b0 extends a0 implements n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f14225e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f14226f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14227d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(o0 lowerBound, o0 upperBound) {
        super(lowerBound, upperBound);
        kotlin.jvm.internal.m.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.m.f(upperBound, "upperBound");
    }

    private final void V0() {
        if (!f14226f || this.f14227d) {
            return;
        }
        this.f14227d = true;
        d0.b(R0());
        d0.b(S0());
        kotlin.jvm.internal.m.a(R0(), S0());
        kotlin.reflect.jvm.internal.impl.types.checker.e.f14235a.d(R0(), S0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n
    public g0 G(g0 replacement) {
        v1 v1VarD;
        kotlin.jvm.internal.m.f(replacement, "replacement");
        v1 v1VarM0 = replacement.M0();
        if (v1VarM0 instanceof a0) {
            v1VarD = v1VarM0;
        } else {
            if (!(v1VarM0 instanceof o0)) {
                throw new r8.n();
            }
            o0 o0Var = (o0) v1VarM0;
            v1VarD = h0.d(o0Var, o0Var.N0(true));
        }
        return u1.b(v1VarD, v1VarM0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    public v1 P0(c1 newAttributes) {
        kotlin.jvm.internal.m.f(newAttributes, "newAttributes");
        return h0.d(R0().P0(newAttributes), S0().P0(newAttributes));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a0
    public String T0(kotlin.reflect.jvm.internal.impl.renderer.c renderer, kotlin.reflect.jvm.internal.impl.renderer.f options) {
        kotlin.jvm.internal.m.f(renderer, "renderer");
        kotlin.jvm.internal.m.f(options, "options");
        if (!options.n()) {
            return renderer.t(renderer.w(R0()), renderer.w(S0()), oa.a.i(this));
        }
        return '(' + renderer.w(R0()) + ".." + renderer.w(S0()) + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public a0 T0(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        g0 g0VarA = kotlinTypeRefiner.a(R0());
        kotlin.jvm.internal.m.d(g0VarA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        g0 g0VarA2 = kotlinTypeRefiner.a(S0());
        kotlin.jvm.internal.m.d(g0VarA2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new b0((o0) g0VarA, (o0) g0VarA2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a0
    public String toString() {
        return '(' + R0() + ".." + S0() + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    public v1 N0(boolean z10) {
        return h0.d(R0().N0(z10), S0().N0(z10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a0
    public o0 Q0() {
        V0();
        return R0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n
    public boolean w0() {
        if ((R0().J0().d() instanceof kotlin.reflect.jvm.internal.impl.descriptors.f1) && kotlin.jvm.internal.m.a(R0().J0(), S0().J0())) {
            return true;
        }
        return false;
    }
}
