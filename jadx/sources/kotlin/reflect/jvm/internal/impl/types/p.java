package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class p extends r implements n, na.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f14347d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o0 f14348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f14349c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public static /* synthetic */ p c(a aVar, v1 v1Var, boolean z10, boolean z11, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            if ((i10 & 4) != 0) {
                z11 = false;
            }
            return aVar.b(v1Var, z10, z11);
        }

        public final p b(v1 type, boolean z10, boolean z11) {
            kotlin.jvm.internal.m.f(type, "type");
            if (type instanceof p) {
                return (p) type;
            }
            kotlin.jvm.internal.g gVar = null;
            if (!z11 && !d(type, z10)) {
                return null;
            }
            if (type instanceof a0) {
                a0 a0Var = (a0) type;
                kotlin.jvm.internal.m.a(a0Var.R0().J0(), a0Var.S0().J0());
            }
            return new p(d0.c(type).N0(false), z10, gVar);
        }

        private final boolean a(v1 v1Var) {
            if (!(v1Var.J0() instanceof kotlin.reflect.jvm.internal.impl.types.checker.n) && !(v1Var.J0().d() instanceof kotlin.reflect.jvm.internal.impl.descriptors.f1) && !(v1Var instanceof kotlin.reflect.jvm.internal.impl.types.checker.i) && !(v1Var instanceof w0)) {
                return false;
            }
            return true;
        }

        private final boolean d(v1 v1Var, boolean z10) {
            kotlin.reflect.jvm.internal.impl.descriptors.impl.k0 k0Var;
            if (!a(v1Var)) {
                return false;
            }
            if (v1Var instanceof w0) {
                return s1.l(v1Var);
            }
            kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = v1Var.J0().d();
            if (hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.k0) {
                k0Var = (kotlin.reflect.jvm.internal.impl.descriptors.impl.k0) hVarD;
            } else {
                k0Var = null;
            }
            if (k0Var != null && !k0Var.P0()) {
                return true;
            }
            if (z10 && (v1Var.J0().d() instanceof kotlin.reflect.jvm.internal.impl.descriptors.f1)) {
                return s1.l(v1Var);
            }
            return !kotlin.reflect.jvm.internal.impl.types.checker.o.f14256a.a(v1Var);
        }
    }

    public /* synthetic */ p(o0 o0Var, boolean z10, kotlin.jvm.internal.g gVar) {
        this(o0Var, z10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.r, kotlin.reflect.jvm.internal.impl.types.g0
    public boolean K0() {
        return false;
    }

    private p(o0 o0Var, boolean z10) {
        this.f14348b = o0Var;
        this.f14349c = z10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n
    public g0 G(g0 replacement) {
        kotlin.jvm.internal.m.f(replacement, "replacement");
        return s0.e(replacement.M0(), this.f14349c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: Q0 */
    public o0 N0(boolean z10) {
        return z10 ? S0().N0(z10) : this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: R0 */
    public o0 P0(c1 newAttributes) {
        kotlin.jvm.internal.m.f(newAttributes, "newAttributes");
        return new p(S0().P0(newAttributes), this.f14349c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.r
    protected o0 S0() {
        return this.f14348b;
    }

    public final o0 V0() {
        return this.f14348b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.r
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public p U0(o0 delegate) {
        kotlin.jvm.internal.m.f(delegate, "delegate");
        return new p(delegate, this.f14349c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.o0
    public String toString() {
        return S0() + " & Any";
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n
    public boolean w0() {
        if (!(S0().J0() instanceof kotlin.reflect.jvm.internal.impl.types.checker.n) && !(S0().J0().d() instanceof kotlin.reflect.jvm.internal.impl.descriptors.f1)) {
            return false;
        }
        return true;
    }
}
