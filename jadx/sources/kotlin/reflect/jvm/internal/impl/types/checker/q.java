package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.c0;
import kotlin.reflect.jvm.internal.impl.types.f1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class q implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f14258a = new q();

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

    private q() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q1
    public kotlin.reflect.jvm.internal.impl.builtins.i A(na.n nVar) {
        return b.a.t(this, nVar);
    }

    @Override // na.p
    public na.i A0(na.d dVar) {
        return b.a.d0(this, dVar);
    }

    @Override // na.s
    public boolean B0(na.k kVar, na.k kVar2) {
        return b.a.E(this, kVar, kVar2);
    }

    @Override // na.p
    public boolean C0(na.n nVar) {
        return b.a.J(this, nVar);
    }

    @Override // na.p
    public boolean D(na.d dVar) {
        return b.a.S(this, dVar);
    }

    @Override // na.p
    public int D0(na.i iVar) {
        return b.a.b(this, iVar);
    }

    @Override // na.p
    public f1.c E(na.k kVar) {
        return b.a.k0(this, kVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q1
    public boolean E0(na.n nVar) {
        return b.a.b0(this, nVar);
    }

    @Override // na.p
    public na.i F(List<? extends na.i> list) {
        return b.a.F(this, list);
    }

    @Override // na.p
    public na.i G(na.i iVar, boolean z10) {
        return b.a.p0(this, iVar, z10);
    }

    public f1 G0(boolean z10, boolean z11) {
        return b.a.f0(this, z10, z11);
    }

    @Override // na.p
    public na.u H(na.o oVar) {
        return b.a.B(this, oVar);
    }

    @Override // na.p
    public boolean I(na.n nVar) {
        return b.a.M(this, nVar);
    }

    @Override // na.p
    public na.k J(na.e eVar) {
        return b.a.g0(this, eVar);
    }

    @Override // na.p
    public na.k L(na.k kVar, na.b bVar) {
        return b.a.k(this, kVar, bVar);
    }

    @Override // na.p
    public Collection<na.i> N(na.k kVar) {
        return b.a.i0(this, kVar);
    }

    @Override // na.p
    public na.m P(na.i iVar, int i10) {
        return b.a.n(this, iVar, i10);
    }

    @Override // na.p
    public boolean Q(na.i iVar) {
        return b.a.P(this, iVar);
    }

    @Override // na.p
    public List<na.m> R(na.i iVar) {
        return b.a.o(this, iVar);
    }

    @Override // na.p
    public boolean S(na.n nVar, na.n nVar2) {
        return b.a.a(this, nVar, nVar2);
    }

    @Override // na.p
    public boolean T(na.k kVar) {
        return b.a.Y(this, kVar);
    }

    @Override // na.p
    public na.f W(na.g gVar) {
        return b.a.f(this, gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q1
    public na.i X(na.o oVar) {
        return b.a.u(this, oVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q1
    public ba.d Y(na.n nVar) {
        return b.a.p(this, nVar);
    }

    @Override // na.p
    public boolean Z(na.n nVar) {
        return b.a.Q(this, nVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, na.p
    public na.k a(na.i iVar) {
        return b.a.i(this, iVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, na.p
    public boolean b(na.k kVar) {
        return b.a.V(this, kVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b
    public na.i b0(na.k kVar, na.k kVar2) {
        return b.a.m(this, kVar, kVar2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, na.p
    public na.k c(na.g gVar) {
        return b.a.c0(this, gVar);
    }

    @Override // na.p
    public int c0(na.n nVar) {
        return b.a.h0(this, nVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, na.p
    public na.d d(na.k kVar) {
        return b.a.d(this, kVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, na.p
    public na.k e(na.g gVar) {
        return b.a.o0(this, gVar);
    }

    @Override // na.p
    public boolean e0(na.k kVar) {
        return b.a.T(this, kVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, na.p
    public na.n f(na.k kVar) {
        return b.a.n0(this, kVar);
    }

    @Override // na.p
    public boolean f0(na.i iVar) {
        return b.a.a0(this, iVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b, na.p
    public na.k g(na.k kVar, boolean z10) {
        return b.a.q0(this, kVar, z10);
    }

    @Override // na.p
    public boolean g0(na.k kVar) {
        return b.a.Z(this, kVar);
    }

    @Override // na.p
    public na.u h(na.m mVar) {
        return b.a.A(this, mVar);
    }

    @Override // na.p
    public boolean h0(na.k kVar) {
        return b.a.O(this, kVar);
    }

    @Override // na.p
    public List<na.o> i(na.n nVar) {
        return b.a.r(this, nVar);
    }

    @Override // na.p
    public boolean i0(na.d dVar) {
        return b.a.U(this, dVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q1
    public boolean j(na.n nVar) {
        return b.a.L(this, nVar);
    }

    @Override // na.p
    public na.c k(na.d dVar) {
        return b.a.m0(this, dVar);
    }

    @Override // na.p
    public na.b k0(na.d dVar) {
        return b.a.l(this, dVar);
    }

    @Override // na.p
    public boolean l(na.i iVar) {
        return b.a.R(this, iVar);
    }

    @Override // na.p
    public na.o l0(na.n nVar) {
        return b.a.x(this, nVar);
    }

    @Override // na.p
    public na.i m(na.m mVar) {
        return b.a.v(this, mVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q1
    public na.i m0(na.i iVar) {
        return b.a.y(this, iVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q1
    public boolean n0(na.i iVar, ba.c cVar) {
        return b.a.C(this, iVar, cVar);
    }

    @Override // na.p
    public boolean o(na.m mVar) {
        return b.a.X(this, mVar);
    }

    @Override // na.p
    public boolean p(na.n nVar) {
        return b.a.H(this, nVar);
    }

    @Override // na.p
    public na.m p0(na.c cVar) {
        return b.a.j0(this, cVar);
    }

    @Override // na.p
    public Collection<na.i> q0(na.n nVar) {
        return b.a.l0(this, nVar);
    }

    @Override // na.p
    public boolean r(na.o oVar, na.n nVar) {
        return b.a.D(this, oVar, nVar);
    }

    @Override // na.p
    public na.g r0(na.i iVar) {
        return b.a.g(this, iVar);
    }

    @Override // na.p
    public na.i s0(na.i iVar) {
        return b.a.e0(this, iVar);
    }

    @Override // na.p
    public na.o t(na.t tVar) {
        return b.a.w(this, tVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q1
    public kotlin.reflect.jvm.internal.impl.builtins.i t0(na.n nVar) {
        return b.a.s(this, nVar);
    }

    @Override // na.p
    public na.o u0(na.n nVar, int i10) {
        return b.a.q(this, nVar, i10);
    }

    @Override // na.p
    public na.j v(na.g gVar) {
        return b.a.h(this, gVar);
    }

    @Override // na.p
    public boolean v0(na.i iVar) {
        return b.a.K(this, iVar);
    }

    @Override // na.p
    public na.m w(na.i iVar) {
        return b.a.j(this, iVar);
    }

    @Override // na.p
    public na.l w0(na.k kVar) {
        return b.a.c(this, kVar);
    }

    @Override // na.p
    public boolean x(na.n nVar) {
        return b.a.N(this, nVar);
    }

    @Override // na.p
    public na.e x0(na.k kVar) {
        return b.a.e(this, kVar);
    }

    @Override // na.p
    public boolean y(na.n nVar) {
        return b.a.I(this, nVar);
    }

    @Override // na.p
    public boolean z(na.n nVar) {
        return b.a.G(this, nVar);
    }

    @Override // na.p
    public List<na.i> z0(na.o oVar) {
        return b.a.z(this, oVar);
    }
}
