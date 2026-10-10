package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.c0;
import kotlin.reflect.jvm.internal.impl.types.f1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import na.t;
import na.u;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class l implements kotlin.reflect.jvm.internal.impl.types.checker.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<g1, g1> f13953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.e.a f13954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.g f13955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.f f13956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c9.p<g0, g0, Boolean> f13957e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends f1 {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ l f13958k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z10, boolean z11, l lVar, kotlin.reflect.jvm.internal.impl.types.checker.f fVar, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            super(z10, z11, true, lVar, fVar, gVar);
            this.f13958k = lVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.f1
        public boolean f(na.i subType, na.i superType) {
            kotlin.jvm.internal.m.f(subType, "subType");
            kotlin.jvm.internal.m.f(superType, "superType");
            if (!(subType instanceof g0)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (superType instanceof g0) {
                return ((Boolean) this.f13958k.f13957e.invoke(subType, superType)).booleanValue();
            }
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(Map<g1, ? extends g1> map, kotlin.reflect.jvm.internal.impl.types.checker.e.a equalityAxioms, kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.checker.f kotlinTypePreparator, c9.p<? super g0, ? super g0, Boolean> pVar) {
        kotlin.jvm.internal.m.f(equalityAxioms, "equalityAxioms");
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        kotlin.jvm.internal.m.f(kotlinTypePreparator, "kotlinTypePreparator");
        this.f13953a = map;
        this.f13954b = equalityAxioms;
        this.f13955c = kotlinTypeRefiner;
        this.f13956d = kotlinTypePreparator;
        this.f13957e = pVar;
    }

    private final boolean H0(g1 g1Var, g1 g1Var2) {
        if (this.f13954b.a(g1Var, g1Var2)) {
            return true;
        }
        Map<g1, g1> map = this.f13953a;
        if (map == null) {
            return false;
        }
        g1 g1Var3 = map.get(g1Var);
        g1 g1Var4 = this.f13953a.get(g1Var2);
        return (g1Var3 != null && kotlin.jvm.internal.m.a(g1Var3, g1Var2)) || (g1Var4 != null && kotlin.jvm.internal.m.a(g1Var4, g1Var));
    }

    @Override // na.p
    public boolean B(na.k kVar) {
        kotlin.jvm.internal.m.f(kVar, "<this>");
        return I(f(kVar));
    }

    @Override // na.p
    public boolean C(na.i iVar) {
        kotlin.jvm.internal.m.f(iVar, "<this>");
        na.k kVarA = a(iVar);
        return (kVarA != null ? d(kVarA) : null) != null;
    }

    @Override // na.p
    public na.k F0(na.k kVar) {
        na.k kVarJ;
        kotlin.jvm.internal.m.f(kVar, "<this>");
        na.e eVarX0 = x0(kVar);
        return (eVarX0 == null || (kVarJ = J(eVarX0)) == null) ? kVar : kVarJ;
    }

    public f1 I0(boolean z10, boolean z11) {
        if (this.f13957e != null) {
            return new a(z10, z11, this, this.f13956d, this.f13955c);
        }
        return kotlin.reflect.jvm.internal.impl.types.checker.a.a(z10, z11, this, this.f13956d, this.f13955c);
    }

    @Override // na.p
    public boolean K(na.i iVar) {
        kotlin.jvm.internal.m.f(iVar, "<this>");
        na.g gVarR0 = r0(iVar);
        return (gVarR0 != null ? W(gVarR0) : null) != null;
    }

    @Override // na.p
    public na.k M(na.i iVar) {
        na.k kVarC;
        kotlin.jvm.internal.m.f(iVar, "<this>");
        na.g gVarR0 = r0(iVar);
        if (gVarR0 != null && (kVarC = c(gVarR0)) != null) {
            return kVarC;
        }
        na.k kVarA = a(iVar);
        kotlin.jvm.internal.m.c(kVarA);
        return kVarA;
    }

    @Override // na.p
    public boolean O(na.i iVar) {
        kotlin.jvm.internal.m.f(iVar, "<this>");
        return Z(y0(iVar)) && !l(iVar);
    }

    @Override // na.p
    public boolean S(na.n c10, na.n c11) {
        kotlin.jvm.internal.m.f(c10, "c1");
        kotlin.jvm.internal.m.f(c11, "c2");
        if (!(c10 instanceof g1)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (c11 instanceof g1) {
            return kotlin.reflect.jvm.internal.impl.types.checker.b.a.a(this, c10, c11) || H0((g1) c10, (g1) c11);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @Override // na.p
    public boolean U(na.i iVar) {
        kotlin.jvm.internal.m.f(iVar, "<this>");
        return (iVar instanceof na.k) && h0((na.k) iVar);
    }

    @Override // na.p
    public na.m V(na.k kVar, int i10) {
        kotlin.jvm.internal.m.f(kVar, "<this>");
        if (i10 < 0 || i10 >= D0(kVar)) {
            return null;
        }
        return P(kVar, i10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q1
    public na.i a0(na.i iVar) {
        na.k kVarG;
        kotlin.jvm.internal.m.f(iVar, "<this>");
        na.k kVarA = a(iVar);
        return (kVarA == null || (kVarG = g(kVarA, true)) == null) ? iVar : kVarG;
    }

    @Override // na.p
    public na.k d0(na.i iVar) {
        na.k kVarE;
        kotlin.jvm.internal.m.f(iVar, "<this>");
        na.g gVarR0 = r0(iVar);
        if (gVarR0 != null && (kVarE = e(gVarR0)) != null) {
            return kVarE;
        }
        na.k kVarA = a(iVar);
        kotlin.jvm.internal.m.c(kVarA);
        return kVarA;
    }

    @Override // na.p
    public int j0(na.l lVar) {
        kotlin.jvm.internal.m.f(lVar, "<this>");
        if (lVar instanceof na.k) {
            return D0((na.i) lVar);
        }
        if (lVar instanceof na.a) {
            return ((na.a) lVar).size();
        }
        throw new IllegalStateException(("unknown type argument list type: " + lVar + ", " + c0.b(lVar.getClass())).toString());
    }

    @Override // na.p
    public boolean n(na.i iVar) {
        kotlin.jvm.internal.m.f(iVar, "<this>");
        na.k kVarA = a(iVar);
        return (kVarA != null ? x0(kVarA) : null) != null;
    }

    @Override // na.p
    public List<na.k> o0(na.k kVar, na.n constructor) {
        kotlin.jvm.internal.m.f(kVar, "<this>");
        kotlin.jvm.internal.m.f(constructor, "constructor");
        return null;
    }

    @Override // na.p
    public boolean q(na.i iVar) {
        kotlin.jvm.internal.m.f(iVar, "<this>");
        return h0(M(iVar)) != h0(d0(iVar));
    }

    @Override // na.p
    public na.m s(na.l lVar, int i10) {
        kotlin.jvm.internal.m.f(lVar, "<this>");
        if (lVar instanceof na.k) {
            return P((na.i) lVar, i10);
        }
        if (lVar instanceof na.a) {
            na.m mVar = ((na.a) lVar).get(i10);
            kotlin.jvm.internal.m.e(mVar, "get(index)");
            return mVar;
        }
        throw new IllegalStateException(("unknown type argument list type: " + lVar + ", " + c0.b(lVar.getClass())).toString());
    }

    @Override // na.p
    public boolean u(na.k kVar) {
        kotlin.jvm.internal.m.f(kVar, "<this>");
        return p(f(kVar));
    }

    @Override // na.p
    public na.n y0(na.i iVar) {
        kotlin.jvm.internal.m.f(iVar, "<this>");
        na.k kVarA = a(iVar);
        if (kVarA == null) {
            kVarA = M(iVar);
        }
        return f(kVarA);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q1
    public kotlin.reflect.jvm.internal.impl.builtins.i A(na.n nVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.t(this, nVar);
    }

    @Override // na.p
    public na.i A0(na.d dVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.d0(this, dVar);
    }

    @Override // na.s
    public boolean B0(na.k kVar, na.k kVar2) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.E(this, kVar, kVar2);
    }

    @Override // na.p
    public boolean C0(na.n nVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.J(this, nVar);
    }

    @Override // na.p
    public boolean D(na.d dVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.S(this, dVar);
    }

    @Override // na.p
    public int D0(na.i iVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.b(this, iVar);
    }

    @Override // na.p
    public f1.c E(na.k kVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.k0(this, kVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q1
    public boolean E0(na.n nVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.b0(this, nVar);
    }

    @Override // na.p
    public na.i F(List<? extends na.i> list) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.F(this, list);
    }

    @Override // na.p
    public na.i G(na.i iVar, boolean z10) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.p0(this, iVar, z10);
    }

    @Override // na.p
    public u H(na.o oVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.B(this, oVar);
    }

    @Override // na.p
    public boolean I(na.n nVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.M(this, nVar);
    }

    @Override // na.p
    public na.k J(na.e eVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.g0(this, eVar);
    }

    @Override // na.p
    public na.k L(na.k kVar, na.b bVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.k(this, kVar, bVar);
    }

    @Override // na.p
    public Collection<na.i> N(na.k kVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.i0(this, kVar);
    }

    @Override // na.p
    public na.m P(na.i iVar, int i10) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.n(this, iVar, i10);
    }

    @Override // na.p
    public boolean Q(na.i iVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.P(this, iVar);
    }

    @Override // na.p
    public List<na.m> R(na.i iVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.o(this, iVar);
    }

    @Override // na.p
    public boolean T(na.k kVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.Y(this, kVar);
    }

    @Override // na.p
    public na.f W(na.g gVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.f(this, gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q1
    public na.i X(na.o oVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.u(this, oVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q1
    public ba.d Y(na.n nVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.p(this, nVar);
    }

    @Override // na.p
    public boolean Z(na.n nVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.Q(this, nVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, na.p
    public na.k a(na.i iVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.i(this, iVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, na.p
    public boolean b(na.k kVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.V(this, kVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b
    public na.i b0(na.k kVar, na.k kVar2) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.m(this, kVar, kVar2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, na.p
    public na.k c(na.g gVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.c0(this, gVar);
    }

    @Override // na.p
    public int c0(na.n nVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.h0(this, nVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, na.p
    public na.d d(na.k kVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.d(this, kVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, na.p
    public na.k e(na.g gVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.o0(this, gVar);
    }

    @Override // na.p
    public boolean e0(na.k kVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.T(this, kVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, na.p
    public na.n f(na.k kVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.n0(this, kVar);
    }

    @Override // na.p
    public boolean f0(na.i iVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.a0(this, iVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, na.p
    public na.k g(na.k kVar, boolean z10) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.q0(this, kVar, z10);
    }

    @Override // na.p
    public boolean g0(na.k kVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.Z(this, kVar);
    }

    @Override // na.p
    public u h(na.m mVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.A(this, mVar);
    }

    @Override // na.p
    public boolean h0(na.k kVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.O(this, kVar);
    }

    @Override // na.p
    public List<na.o> i(na.n nVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.r(this, nVar);
    }

    @Override // na.p
    public boolean i0(na.d dVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.U(this, dVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q1
    public boolean j(na.n nVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.L(this, nVar);
    }

    @Override // na.p
    public na.c k(na.d dVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.m0(this, dVar);
    }

    @Override // na.p
    public na.b k0(na.d dVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.l(this, dVar);
    }

    @Override // na.p
    public boolean l(na.i iVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.R(this, iVar);
    }

    @Override // na.p
    public na.o l0(na.n nVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.x(this, nVar);
    }

    @Override // na.p
    public na.i m(na.m mVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.v(this, mVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q1
    public na.i m0(na.i iVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.y(this, iVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q1
    public boolean n0(na.i iVar, ba.c cVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.C(this, iVar, cVar);
    }

    @Override // na.p
    public boolean o(na.m mVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.X(this, mVar);
    }

    @Override // na.p
    public boolean p(na.n nVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.H(this, nVar);
    }

    @Override // na.p
    public na.m p0(na.c cVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.j0(this, cVar);
    }

    @Override // na.p
    public Collection<na.i> q0(na.n nVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.l0(this, nVar);
    }

    @Override // na.p
    public boolean r(na.o oVar, na.n nVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.D(this, oVar, nVar);
    }

    @Override // na.p
    public na.g r0(na.i iVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.g(this, iVar);
    }

    @Override // na.p
    public na.i s0(na.i iVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.e0(this, iVar);
    }

    @Override // na.p
    public na.o t(t tVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.w(this, tVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q1
    public kotlin.reflect.jvm.internal.impl.builtins.i t0(na.n nVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.s(this, nVar);
    }

    @Override // na.p
    public na.o u0(na.n nVar, int i10) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.q(this, nVar, i10);
    }

    @Override // na.p
    public na.j v(na.g gVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.h(this, gVar);
    }

    @Override // na.p
    public boolean v0(na.i iVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.K(this, iVar);
    }

    @Override // na.p
    public na.m w(na.i iVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.j(this, iVar);
    }

    @Override // na.p
    public na.l w0(na.k kVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.c(this, kVar);
    }

    @Override // na.p
    public boolean x(na.n nVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.N(this, nVar);
    }

    @Override // na.p
    public na.e x0(na.k kVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.e(this, kVar);
    }

    @Override // na.p
    public boolean y(na.n nVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.I(this, nVar);
    }

    @Override // na.p
    public boolean z(na.n nVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.G(this, nVar);
    }

    @Override // na.p
    public List<na.i> z0(na.o oVar) {
        return kotlin.reflect.jvm.internal.impl.types.checker.b.a.z(this, oVar);
    }
}
