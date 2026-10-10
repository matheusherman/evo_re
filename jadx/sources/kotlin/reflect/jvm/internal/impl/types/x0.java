package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class x0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f14387c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final x0 f14388d = new x0(z0.a.f14399a, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z0 f14389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f14390b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i10, kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var) {
            if (i10 <= 100) {
                return;
            }
            throw new AssertionError("Too deep recursion while expanding type alias " + e1Var.getName());
        }
    }

    public x0(z0 reportStrategy, boolean z10) {
        kotlin.jvm.internal.m.f(reportStrategy, "reportStrategy");
        this.f14389a = reportStrategy;
        this.f14390b = z10;
    }

    private final void a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2) {
        HashSet hashSet = new HashSet();
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> it = gVar.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().d());
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar : gVar2) {
            if (hashSet.contains(cVar.d())) {
                this.f14389a.a(cVar);
            }
        }
    }

    private final o0 k(y0 y0Var, c1 c1Var, boolean z10, int i10, boolean z11) {
        k1 k1VarL = l(new m1(w1.INVARIANT, y0Var.b().c0()), y0Var, null, i10);
        g0 type = k1VarL.getType();
        kotlin.jvm.internal.m.e(type, "expandedProjection.type");
        o0 o0VarA = o1.a(type);
        if (i0.a(o0VarA)) {
            return o0VarA;
        }
        k1VarL.a();
        a(o0VarA.getAnnotations(), k.a(c1Var));
        o0 o0VarR = s1.r(d(o0VarA, c1Var), z10);
        kotlin.jvm.internal.m.e(o0VarR, "expandedType.combineAttr…fNeeded(it, isNullable) }");
        return z11 ? s0.j(o0VarR, g(y0Var, c1Var, z10)) : o0VarR;
    }

    private final k1 l(k1 k1Var, y0 y0Var, kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var, int i10) {
        w1 w1VarJ;
        w1 w1Var;
        w1 w1Var2;
        f14387c.b(i10, y0Var.b());
        if (k1Var.b()) {
            kotlin.jvm.internal.m.c(f1Var);
            k1 k1VarS = s1.s(f1Var);
            kotlin.jvm.internal.m.e(k1VarS, "makeStarProjection(typeParameterDescriptor!!)");
            return k1VarS;
        }
        g0 type = k1Var.getType();
        kotlin.jvm.internal.m.e(type, "underlyingProjection.type");
        k1 k1VarC = y0Var.c(type.J0());
        if (k1VarC == null) {
            return j(k1Var, y0Var, i10);
        }
        if (k1VarC.b()) {
            kotlin.jvm.internal.m.c(f1Var);
            k1 k1VarS2 = s1.s(f1Var);
            kotlin.jvm.internal.m.e(k1VarS2, "makeStarProjection(typeParameterDescriptor!!)");
            return k1VarS2;
        }
        v1 v1VarM0 = k1VarC.getType().M0();
        w1 w1VarA = k1VarC.a();
        kotlin.jvm.internal.m.e(w1VarA, "argument.projectionKind");
        w1 w1VarA2 = k1Var.a();
        kotlin.jvm.internal.m.e(w1VarA2, "underlyingProjection.projectionKind");
        if (w1VarA2 != w1VarA && w1VarA2 != (w1Var2 = w1.INVARIANT)) {
            if (w1VarA == w1Var2) {
                w1VarA = w1VarA2;
            } else {
                this.f14389a.b(y0Var.b(), f1Var, v1VarM0);
            }
        }
        if (f1Var == null || (w1VarJ = f1Var.j()) == null) {
            w1VarJ = w1.INVARIANT;
        }
        kotlin.jvm.internal.m.e(w1VarJ, "typeParameterDescriptor?…nce ?: Variance.INVARIANT");
        if (w1VarJ != w1VarA && w1VarJ != (w1Var = w1.INVARIANT)) {
            if (w1VarA == w1Var) {
                w1VarA = w1Var;
            } else {
                this.f14389a.b(y0Var.b(), f1Var, v1VarM0);
            }
        }
        a(type.getAnnotations(), v1VarM0.getAnnotations());
        return new m1(w1VarA, v1VarM0 instanceof v ? c((v) v1VarM0, type.I0()) : f(o1.a(v1VarM0), type));
    }

    public final o0 i(y0 typeAliasExpansion, c1 attributes) {
        kotlin.jvm.internal.m.f(typeAliasExpansion, "typeAliasExpansion");
        kotlin.jvm.internal.m.f(attributes, "attributes");
        return k(typeAliasExpansion, attributes, false, 0, true);
    }

    private final void b(g0 g0Var, g0 g0Var2) {
        p1 p1VarF = p1.f(g0Var2);
        kotlin.jvm.internal.m.e(p1VarF, "create(substitutedType)");
        int i10 = 0;
        for (Object obj : g0Var2.H0()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.r.v();
            }
            k1 k1Var = (k1) obj;
            if (!k1Var.b()) {
                g0 type = k1Var.getType();
                kotlin.jvm.internal.m.e(type, "substitutedArgument.type");
                if (!oa.a.d(type)) {
                    k1 k1Var2 = g0Var.H0().get(i10);
                    kotlin.reflect.jvm.internal.impl.descriptors.f1 typeParameter = g0Var.J0().getParameters().get(i10);
                    if (this.f14390b) {
                        z0 z0Var = this.f14389a;
                        g0 type2 = k1Var2.getType();
                        kotlin.jvm.internal.m.e(type2, "unsubstitutedArgument.type");
                        g0 type3 = k1Var.getType();
                        kotlin.jvm.internal.m.e(type3, "substitutedArgument.type");
                        kotlin.jvm.internal.m.e(typeParameter, "typeParameter");
                        z0Var.c(p1VarF, type2, type3, typeParameter);
                    }
                }
            }
            i10 = i11;
        }
    }

    private final v c(v vVar, c1 c1Var) {
        return vVar.P0(h(vVar, c1Var));
    }

    private final o0 d(o0 o0Var, c1 c1Var) {
        if (i0.a(o0Var)) {
            return o0Var;
        }
        return o1.f(o0Var, null, h(o0Var, c1Var), 1, null);
    }

    private final o0 e(o0 o0Var, g0 g0Var) {
        o0 o0VarR = s1.r(o0Var, g0Var.K0());
        kotlin.jvm.internal.m.e(o0VarR, "makeNullableIfNeeded(thi…romType.isMarkedNullable)");
        return o0VarR;
    }

    private final o0 f(o0 o0Var, g0 g0Var) {
        return d(e(o0Var, g0Var), g0Var.I0());
    }

    private final o0 g(y0 y0Var, c1 c1Var, boolean z10) {
        g1 g1VarH = y0Var.b().h();
        kotlin.jvm.internal.m.e(g1VarH, "descriptor.typeConstructor");
        return h0.k(c1Var, g1VarH, y0Var.a(), z10, kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b.f14005b);
    }

    private final c1 h(g0 g0Var, c1 c1Var) {
        if (i0.a(g0Var)) {
            return g0Var.I0();
        }
        return c1Var.k(g0Var.I0());
    }

    private final k1 j(k1 k1Var, y0 y0Var, int i10) {
        v1 v1VarM0 = k1Var.getType().M0();
        if (!w.a(v1VarM0)) {
            o0 o0VarA = o1.a(v1VarM0);
            if (!i0.a(o0VarA) && oa.a.z(o0VarA)) {
                g1 g1VarJ0 = o0VarA.J0();
                kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g1VarJ0.d();
                g1VarJ0.getParameters().size();
                o0VarA.H0().size();
                if (!(hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.f1)) {
                    if (hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e1) {
                        kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var = (kotlin.reflect.jvm.internal.impl.descriptors.e1) hVarD;
                        if (y0Var.d(e1Var)) {
                            this.f14389a.d(e1Var);
                            w1 w1Var = w1.INVARIANT;
                            la.j jVar = la.j.f15316q;
                            String string = e1Var.getName().toString();
                            kotlin.jvm.internal.m.e(string, "typeDescriptor.name.toString()");
                            return new m1(w1Var, la.k.d(jVar, string));
                        }
                        List<k1> listH0 = o0VarA.H0();
                        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(listH0, 10));
                        int i11 = 0;
                        for (Object obj : listH0) {
                            int i12 = i11 + 1;
                            if (i11 < 0) {
                                kotlin.collections.r.v();
                            }
                            arrayList.add(l((k1) obj, y0Var, g1VarJ0.getParameters().get(i11), i10 + 1));
                            i11 = i12;
                        }
                        o0 o0VarK = k(y0.f14394e.a(y0Var, e1Var, arrayList), o0VarA.I0(), o0VarA.K0(), i10 + 1, false);
                        o0 o0VarM = m(o0VarA, y0Var, i10);
                        if (!w.a(o0VarK)) {
                            o0VarK = s0.j(o0VarK, o0VarM);
                        }
                        return new m1(k1Var.a(), o0VarK);
                    }
                    o0 o0VarM2 = m(o0VarA, y0Var, i10);
                    b(o0VarA, o0VarM2);
                    return new m1(k1Var.a(), o0VarM2);
                }
            }
        }
        return k1Var;
    }

    private final o0 m(o0 o0Var, y0 y0Var, int i10) {
        g1 g1VarJ0 = o0Var.J0();
        List<k1> listH0 = o0Var.H0();
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(listH0, 10));
        int i11 = 0;
        for (Object obj : listH0) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.r.v();
            }
            k1 k1Var = (k1) obj;
            k1 k1VarL = l(k1Var, y0Var, g1VarJ0.getParameters().get(i11), i10 + 1);
            if (!k1VarL.b()) {
                k1VarL = new m1(k1VarL.a(), s1.q(k1VarL.getType(), k1Var.getType().K0()));
            }
            arrayList.add(k1VarL);
            i11 = i12;
        }
        return o1.f(o0Var, arrayList, null, 2, null);
    }
}
