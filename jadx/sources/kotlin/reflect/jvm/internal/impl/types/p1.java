package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class p1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p1 f14355b = g(n1.f14344b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n1 f14356a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a implements c9.l<ba.c, Boolean> {
        private static /* synthetic */ void a(int i10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
        }

        @Override // c9.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(ba.c cVar) {
            if (cVar == null) {
                a(0);
            }
            return Boolean.valueOf(!cVar.equals(kotlin.reflect.jvm.internal.impl.builtins.k.a.Q));
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private enum d {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14357a;

        static {
            int[] iArr = new int[d.values().length];
            f14357a = iArr;
            try {
                iArr[d.OUT_IN_IN_POSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14357a[d.IN_IN_OUT_POSITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14357a[d.NO_CONFLICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class c extends Exception {
        public c(String str) {
            super(str);
        }
    }

    protected p1(n1 n1Var) {
        if (n1Var == null) {
            a(7);
        }
        this.f14356a = n1Var;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0021 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:24:0x003b A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:56:0x00b8  */
    private static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        if (i10 != 1 && i10 != 2 && i10 != 8 && i10 != 34 && i10 != 37) {
            switch (i10) {
                default:
                    switch (i10) {
                        default:
                            switch (i10) {
                                default:
                                    switch (i10) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            str = "@NotNull method %s.%s must not return null";
                            break;
                    }
                case 11:
                case 12:
                case 13:
                    str = "@NotNull method %s.%s must not return null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i10 != 1 && i10 != 2 && i10 != 8 && i10 != 34 && i10 != 37) {
            switch (i10) {
                default:
                    switch (i10) {
                        default:
                            switch (i10) {
                                default:
                                    switch (i10) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            break;
                                        default:
                                            i11 = 3;
                                            break;
                                    }
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    i11 = 2;
                                    break;
                            }
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            i11 = 2;
                            break;
                    }
                case 11:
                case 12:
                case 13:
                    i11 = 2;
                    break;
            }
        } else {
            i11 = 2;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 2:
            case 8:
            case 11:
            case 12:
            case 13:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 29:
            case 30:
            case 31:
            case 32:
            case 34:
            case 37:
            case 40:
            case 41:
            case 42:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                break;
            case 3:
                objArr[0] = "first";
                break;
            case 4:
                objArr[0] = "second";
                break;
            case 5:
                objArr[0] = "substitutionContext";
                break;
            case 6:
                objArr[0] = "context";
                break;
            case 7:
            default:
                objArr[0] = "substitution";
                break;
            case 9:
            case 14:
                objArr[0] = IjkMediaMeta.IJKM_KEY_TYPE;
                break;
            case 10:
            case 15:
                objArr[0] = "howThisTypeIsUsed";
                break;
            case 16:
            case 17:
            case 36:
                objArr[0] = "typeProjection";
                break;
            case 18:
            case 28:
                objArr[0] = "originalProjection";
                break;
            case 26:
                objArr[0] = "originalType";
                break;
            case 27:
                objArr[0] = "substituted";
                break;
            case 33:
                objArr[0] = "annotations";
                break;
            case 35:
            case 38:
                objArr[0] = "typeParameterVariance";
                break;
            case 39:
                objArr[0] = "projectionKind";
                break;
        }
        if (i10 == 1) {
            objArr[1] = "replaceWithNonApproximatingSubstitution";
        } else if (i10 == 2) {
            objArr[1] = "replaceWithContravariantApproximatingSubstitution";
        } else if (i10 == 8) {
            objArr[1] = "getSubstitution";
        } else if (i10 == 34) {
            objArr[1] = "filterOutUnsafeVariance";
        } else if (i10 != 37) {
            switch (i10) {
                case 11:
                case 12:
                case 13:
                    objArr[1] = "safeSubstitute";
                    break;
                default:
                    switch (i10) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            objArr[1] = "unsafeSubstitute";
                            break;
                        default:
                            switch (i10) {
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    objArr[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                                    break;
                                default:
                                    switch (i10) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            objArr[1] = "combine";
                                            break;
                                        default:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            objArr[1] = "combine";
        }
        switch (i10) {
            case 1:
            case 2:
            case 8:
            case 11:
            case 12:
            case 13:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 29:
            case 30:
            case 31:
            case 32:
            case 34:
            case 37:
            case 40:
            case 41:
            case 42:
                break;
            case 3:
            case 4:
                objArr[2] = "createChainedSubstitutor";
                break;
            case 5:
            case 6:
            default:
                objArr[2] = "create";
                break;
            case 7:
                objArr[2] = "<init>";
                break;
            case 9:
            case 10:
                objArr[2] = "safeSubstitute";
                break;
            case 14:
            case 15:
            case 16:
                objArr[2] = "substitute";
                break;
            case 17:
                objArr[2] = "substituteWithoutApproximation";
                break;
            case 18:
                objArr[2] = "unsafeSubstitute";
                break;
            case 26:
            case 27:
            case 28:
                objArr[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                break;
            case 33:
                objArr[2] = "filterOutUnsafeVariance";
                break;
            case 35:
            case 36:
            case 38:
            case 39:
                objArr[2] = "combine";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 1 && i10 != 2 && i10 != 8 && i10 != 34 && i10 != 37) {
            switch (i10) {
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    switch (i10) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            break;
                        default:
                            switch (i10) {
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    break;
                                default:
                                    switch (i10) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            break;
                                        default:
                                            throw new IllegalArgumentException(str2);
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        throw new IllegalStateException(str2);
    }

    private static void b(int i10, k1 k1Var, n1 n1Var) {
        if (i10 <= 100) {
            return;
        }
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + o(k1Var) + "; substitution: " + o(n1Var));
    }

    public static w1 c(w1 w1Var, k1 k1Var) {
        if (w1Var == null) {
            a(35);
        }
        if (k1Var == null) {
            a(36);
        }
        if (!k1Var.b()) {
            return d(w1Var, k1Var.a());
        }
        w1 w1Var2 = w1.OUT_VARIANCE;
        if (w1Var2 == null) {
            a(37);
        }
        return w1Var2;
    }

    public static w1 d(w1 w1Var, w1 w1Var2) {
        if (w1Var == null) {
            a(38);
        }
        if (w1Var2 == null) {
            a(39);
        }
        w1 w1Var3 = w1.INVARIANT;
        if (w1Var == w1Var3) {
            if (w1Var2 == null) {
                a(40);
            }
            return w1Var2;
        }
        if (w1Var2 == w1Var3) {
            if (w1Var == null) {
                a(41);
            }
            return w1Var;
        }
        if (w1Var == w1Var2) {
            if (w1Var2 == null) {
                a(42);
            }
            return w1Var2;
        }
        throw new AssertionError("Variance conflict: type parameter variance '" + w1Var + "' and projection kind '" + w1Var2 + "' cannot be combined");
    }

    private static d e(w1 w1Var, w1 w1Var2) {
        w1 w1Var3 = w1.IN_VARIANCE;
        if (w1Var == w1Var3 && w1Var2 == w1.OUT_VARIANCE) {
            return d.OUT_IN_IN_POSITION;
        }
        return (w1Var == w1.OUT_VARIANCE && w1Var2 == w1Var3) ? d.IN_IN_OUT_POSITION : d.NO_CONFLICT;
    }

    public static p1 f(g0 g0Var) {
        if (g0Var == null) {
            a(6);
        }
        return g(h1.i(g0Var.J0(), g0Var.H0()));
    }

    public static p1 g(n1 n1Var) {
        if (n1Var == null) {
            a(0);
        }
        return new p1(n1Var);
    }

    public static p1 h(n1 n1Var, n1 n1Var2) {
        if (n1Var == null) {
            a(3);
        }
        if (n1Var2 == null) {
            a(4);
        }
        return g(u.i(n1Var, n1Var2));
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.annotations.g i(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        if (gVar == null) {
            a(33);
        }
        return !gVar.F(kotlin.reflect.jvm.internal.impl.builtins.k.a.Q) ? gVar : new kotlin.reflect.jvm.internal.impl.descriptors.annotations.l(gVar, new a());
    }

    private static k1 l(g0 g0Var, k1 k1Var, kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var, k1 k1Var2) {
        if (g0Var == null) {
            a(26);
        }
        if (k1Var == null) {
            a(27);
        }
        if (k1Var2 == null) {
            a(28);
        }
        if (!g0Var.getAnnotations().F(kotlin.reflect.jvm.internal.impl.builtins.k.a.Q)) {
            if (k1Var == null) {
                a(29);
            }
            return k1Var;
        }
        g1 g1VarJ0 = k1Var.getType().J0();
        if (!(g1VarJ0 instanceof kotlin.reflect.jvm.internal.impl.types.checker.j)) {
            return k1Var;
        }
        k1 k1VarF = ((kotlin.reflect.jvm.internal.impl.types.checker.j) g1VarJ0).f();
        w1 w1VarA = k1VarF.a();
        d dVarE = e(k1Var2.a(), w1VarA);
        d dVar = d.OUT_IN_IN_POSITION;
        if (dVarE == dVar) {
            return new m1(k1VarF.getType());
        }
        return (f1Var != null && e(f1Var.j(), w1VarA) == dVar) ? new m1(k1VarF.getType()) : k1Var;
    }

    private List<k1> s(List<kotlin.reflect.jvm.internal.impl.descriptors.f1> list, List<k1> list2, int i10) throws c {
        ArrayList arrayList = new ArrayList(list.size());
        boolean z10 = false;
        for (int i11 = 0; i11 < list.size(); i11++) {
            kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var = list.get(i11);
            k1 k1Var = list2.get(i11);
            k1 k1VarU = u(k1Var, f1Var, i10 + 1);
            int i12 = b.f14357a[e(f1Var.j(), k1VarU.a()).ordinal()];
            if (i12 == 1 || i12 == 2) {
                k1VarU = s1.s(f1Var);
            } else if (i12 == 3) {
                w1 w1VarJ = f1Var.j();
                w1 w1Var = w1.INVARIANT;
                if (w1VarJ != w1Var && !k1VarU.b()) {
                    k1VarU = new m1(w1Var, k1VarU.getType());
                }
            }
            if (k1VarU != k1Var) {
                z10 = true;
            }
            arrayList.add(k1VarU);
        }
        return !z10 ? list2 : arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private k1 u(k1 k1Var, kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var, int i10) throws c {
        if (k1Var == null) {
            a(18);
        }
        b(i10, k1Var, this.f14356a);
        if (!k1Var.b()) {
            g0 type = k1Var.getType();
            if (type instanceof t1) {
                t1 t1Var = (t1) type;
                v1 v1VarB0 = t1Var.B0();
                g0 g0VarC = t1Var.C();
                k1 k1VarU = u(new m1(k1Var.a(), v1VarB0), f1Var, i10 + 1);
                return k1VarU.b() ? k1VarU : new m1(k1VarU.a(), u1.d(k1VarU.getType().M0(), p(g0VarC, k1Var.a())));
            }
            if (!w.a(type) && !(type.M0() instanceof n0)) {
                k1 k1VarE = this.f14356a.e(type);
                k1 k1VarL = k1VarE != null ? l(type, k1VarE, f1Var, k1Var) : null;
                w1 w1VarA = k1Var.a();
                if (k1VarL == null && d0.b(type) && !e1.b(type)) {
                    a0 a0VarA = d0.a(type);
                    int i11 = i10 + 1;
                    k1 k1VarU2 = u(new m1(w1VarA, a0VarA.R0()), f1Var, i11);
                    k1 k1VarU3 = u(new m1(w1VarA, a0VarA.S0()), f1Var, i11);
                    w1 w1VarA2 = k1VarU2.a();
                    if (k1VarU2.getType() != a0VarA.R0() || k1VarU3.getType() != a0VarA.S0()) {
                        return new m1(w1VarA2, h0.d(o1.a(k1VarU2.getType()), o1.a(k1VarU3.getType())));
                    }
                } else if (!kotlin.reflect.jvm.internal.impl.builtins.h.n0(type) && !i0.a(type)) {
                    if (k1VarL != null) {
                        d dVarE = e(w1VarA, k1VarL.a());
                        if (!kotlin.reflect.jvm.internal.impl.resolve.calls.inference.d.d(type)) {
                            int i12 = b.f14357a[dVarE.ordinal()];
                            if (i12 == 1) {
                                throw new c("Out-projection in in-position");
                            }
                            if (i12 == 2) {
                                return new m1(w1.OUT_VARIANCE, type.J0().l().I());
                            }
                        }
                        n nVarA = e1.a(type);
                        if (k1VarL.b()) {
                            return k1VarL;
                        }
                        g0 g0VarG = nVarA != null ? nVarA.G(k1VarL.getType()) : s1.q(k1VarL.getType(), type.K0());
                        if (!type.getAnnotations().isEmpty()) {
                            g0VarG = oa.a.x(g0VarG, new kotlin.reflect.jvm.internal.impl.descriptors.annotations.k(g0VarG.getAnnotations(), i(this.f14356a.d(type.getAnnotations()))));
                        }
                        if (dVarE == d.NO_CONFLICT) {
                            w1VarA = d(w1VarA, k1VarL.a());
                        }
                        return new m1(w1VarA, g0VarG);
                    }
                    k1Var = r(k1Var, i10);
                    if (k1Var == null) {
                        a(25);
                    }
                }
            }
        }
        return k1Var;
    }

    public n1 j() {
        n1 n1Var = this.f14356a;
        if (n1Var == null) {
            a(8);
        }
        return n1Var;
    }

    public boolean k() {
        return this.f14356a.f();
    }

    public p1 m() {
        n1 n1Var = this.f14356a;
        return ((n1Var instanceof e0) && n1Var.b()) ? new p1(new e0(((e0) this.f14356a).j(), ((e0) this.f14356a).i(), false)) : this;
    }

    public g0 n(g0 g0Var, w1 w1Var) {
        if (g0Var == null) {
            a(9);
        }
        if (w1Var == null) {
            a(10);
        }
        if (k()) {
            if (g0Var == null) {
                a(11);
            }
            return g0Var;
        }
        try {
            g0 type = u(new m1(w1Var, g0Var), null, 0).getType();
            if (type == null) {
                a(12);
            }
            return type;
        } catch (c e10) {
            la.h hVarD = la.k.d(la.j.B, e10.getMessage());
            if (hVarD == null) {
                a(13);
            }
            return hVarD;
        }
    }

    public g0 p(g0 g0Var, w1 w1Var) {
        if (g0Var == null) {
            a(14);
        }
        if (w1Var == null) {
            a(15);
        }
        k1 k1VarQ = q(new m1(w1Var, j().g(g0Var, w1Var)));
        if (k1VarQ == null) {
            return null;
        }
        return k1VarQ.getType();
    }

    public k1 q(k1 k1Var) {
        if (k1Var == null) {
            a(16);
        }
        k1 k1VarT = t(k1Var);
        return (this.f14356a.a() || this.f14356a.b()) ? pa.b.c(k1VarT, this.f14356a.b()) : k1VarT;
    }

    public k1 t(k1 k1Var) {
        if (k1Var == null) {
            a(17);
        }
        if (k()) {
            return k1Var;
        }
        try {
            return u(k1Var, null, 0);
        } catch (c unused) {
            return null;
        }
    }

    private static String o(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (!sa.d.a(th)) {
                return "[Exception while computing toString(): " + th + "]";
            }
            throw th;
        }
    }

    private k1 r(k1 k1Var, int i10) {
        g0 g0VarP;
        g0 type = k1Var.getType();
        w1 w1VarA = k1Var.a();
        if (type.J0().d() instanceof kotlin.reflect.jvm.internal.impl.descriptors.f1) {
            return k1Var;
        }
        o0 o0VarB = s0.b(type);
        if (o0VarB != null) {
            g0VarP = m().p(o0VarB, w1.INVARIANT);
        } else {
            g0VarP = null;
        }
        g0 g0VarB = o1.b(type, s(type.J0().getParameters(), type.H0(), i10), this.f14356a.d(type.getAnnotations()));
        if ((g0VarB instanceof o0) && (g0VarP instanceof o0)) {
            g0VarB = s0.j((o0) g0VarB, (o0) g0VarP);
        }
        return new m1(w1VarA, g0VarB);
    }
}
