package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.IndexedValue;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.builtins.i;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.k;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.d1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.j0;
import kotlin.reflect.jvm.internal.impl.types.j1;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.m1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.r1;
import kotlin.reflect.jvm.internal.impl.types.s1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import u9.a0;
import u9.c0;
import u9.j;
import u9.v;
import u9.x;
import u9.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.g f13398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f13399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f13400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j1 f13401d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.a<g0> {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a $attr;
        final /* synthetic */ g1 $constructor;
        final /* synthetic */ j $javaType;
        final /* synthetic */ f1 $parameter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(f1 f1Var, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar, g1 g1Var, j jVar) {
            super(0);
            this.$parameter = f1Var;
            this.$attr = aVar;
            this.$constructor = g1Var;
            this.$javaType = jVar;
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g0 invoke() {
            j1 j1Var = d.this.f13401d;
            f1 f1Var = this.$parameter;
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar = this.$attr;
            kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = this.$constructor.d();
            return j1Var.c(f1Var, aVar.k(hVarD != null ? hVarD.p() : null).j(this.$javaType.u()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(kotlin.reflect.jvm.internal.impl.load.java.lazy.g c10, k typeParameterResolver) {
        m.f(c10, "c");
        m.f(typeParameterResolver, "typeParameterResolver");
        this.f13398a = c10;
        this.f13399b = typeParameterResolver;
        f fVar = new f();
        this.f13400c = fVar;
        this.f13401d = new j1(fVar, null, 2, 0 == true ? 1 : 0);
    }

    private final List<k1> d(j jVar, List<? extends f1> list, g1 g1Var, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar) {
        j jVar2;
        g1 g1Var2;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar2;
        k1 k1VarA;
        List<? extends f1> list2 = list;
        ArrayList arrayList = new ArrayList(r.w(list2, 10));
        for (f1 f1Var : list2) {
            if (oa.a.l(f1Var, null, aVar.c())) {
                k1VarA = s1.t(f1Var, aVar);
                jVar2 = jVar;
                g1Var2 = g1Var;
                aVar2 = aVar;
            } else {
                jVar2 = jVar;
                g1Var2 = g1Var;
                aVar2 = aVar;
                k1VarA = this.f13400c.a(f1Var, aVar2.j(jVar2.u()), this.f13401d, new j0(this.f13398a.e(), new a(f1Var, aVar2, g1Var2, jVar2)));
            }
            arrayList.add(k1VarA);
            aVar = aVar2;
            g1Var = g1Var2;
            jVar = jVar2;
        }
        return arrayList;
    }

    private final o0 e(j jVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar, o0 o0Var) {
        j jVar2;
        c1 c1VarB;
        if (o0Var == null || (c1VarB = o0Var.I0()) == null) {
            jVar2 = jVar;
            c1VarB = d1.b(new kotlin.reflect.jvm.internal.impl.load.java.lazy.d(this.f13398a, jVar2, false, 4, null));
        } else {
            jVar2 = jVar;
        }
        c1 c1Var = c1VarB;
        g1 g1VarF = f(jVar2, aVar);
        if (g1VarF == null) {
            return null;
        }
        boolean zI = i(aVar);
        return (m.a(o0Var != null ? o0Var.J0() : null, g1VarF) && !jVar2.u() && zI) ? o0Var.N0(true) : h0.j(c1Var, g1VarF, c(jVar2, aVar, g1VarF), zI, null, 16, null);
    }

    private final g1 g(j jVar) {
        ba.b bVarM = ba.b.m(new ba.c(jVar.v()));
        m.e(bVarM, "topLevel(FqName(javaType.classifierQualifiedName))");
        g1 g1VarH = this.f13398a.a().b().d().q().d(bVarM, r.e(0)).h();
        m.e(g1VarH, "c.components.deserialize…istOf(0)).typeConstructor");
        return g1VarH;
    }

    public static /* synthetic */ g0 l(d dVar, u9.f fVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return dVar.k(fVar, aVar, z10);
    }

    private static final la.h n(j jVar) {
        return la.k.d(la.j.f15297d, jVar.n());
    }

    private final k1 p(x xVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar, f1 f1Var) {
        k1 k1VarT;
        if (!(xVar instanceof c0)) {
            return new m1(w1.INVARIANT, o(xVar, aVar));
        }
        c0 c0Var = (c0) xVar;
        x xVarZ = c0Var.z();
        w1 w1Var = c0Var.H() ? w1.OUT_VARIANCE : w1.IN_VARIANCE;
        if (xVarZ == null || h(w1Var, f1Var)) {
            k1VarT = s1.t(f1Var, aVar);
        } else {
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVarA = kotlin.reflect.jvm.internal.impl.load.java.j0.a(this.f13398a, c0Var);
            g0 g0VarO = o(xVarZ, b.b(r1.COMMON, false, false, null, 7, null));
            if (cVarA != null) {
                g0VarO = oa.a.x(g0VarO, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.a(r.A0(g0VarO.getAnnotations(), cVarA)));
            }
            k1VarT = oa.a.f(g0VarO, w1Var, f1Var);
        }
        m.e(k1VarT, "{\n                val bo…          }\n            }");
        return k1VarT;
    }

    public final g0 k(u9.f arrayType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a attr, boolean z10) {
        m.f(arrayType, "arrayType");
        m.f(attr, "attr");
        x xVarM = arrayType.m();
        v vVar = xVarM instanceof v ? (v) xVarM : null;
        i type = vVar != null ? vVar.getType() : null;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.d dVar = new kotlin.reflect.jvm.internal.impl.load.java.lazy.d(this.f13398a, arrayType, true);
        if (type != null) {
            o0 it = this.f13398a.d().l().O(type);
            m.e(it, "it");
            g0 g0VarX = oa.a.x(it, new kotlin.reflect.jvm.internal.impl.descriptors.annotations.k(it.getAnnotations(), dVar));
            m.d(g0VarX, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            o0 o0Var = (o0) g0VarX;
            return attr.h() ? o0Var : h0.d(o0Var, o0Var.N0(true));
        }
        g0 g0VarO = o(xVarM, b.b(r1.COMMON, attr.h(), false, null, 6, null));
        if (attr.h()) {
            o0 o0VarM = this.f13398a.d().l().m(z10 ? w1.OUT_VARIANCE : w1.INVARIANT, g0VarO, dVar);
            m.e(o0VarM, "c.module.builtIns.getArr…mponentType, annotations)");
            return o0VarM;
        }
        o0 o0VarM2 = this.f13398a.d().l().m(w1.INVARIANT, g0VarO, dVar);
        m.e(o0VarM2, "c.module.builtIns.getArr…mponentType, annotations)");
        return h0.d(o0VarM2, this.f13398a.d().l().m(w1.OUT_VARIANCE, g0VarO, dVar).N0(true));
    }

    public final g0 o(x xVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a attr) {
        g0 g0VarO;
        m.f(attr, "attr");
        if (xVar instanceof v) {
            i type = ((v) xVar).getType();
            o0 o0VarR = type != null ? this.f13398a.d().l().R(type) : this.f13398a.d().l().Z();
            m.e(o0VarR, "{\n                val pr…ns.unitType\n            }");
            return o0VarR;
        }
        if (xVar instanceof j) {
            return m((j) xVar, attr);
        }
        if (xVar instanceof u9.f) {
            return l(this, (u9.f) xVar, attr, false, 4, null);
        }
        if (xVar instanceof c0) {
            x xVarZ = ((c0) xVar).z();
            if (xVarZ != null && (g0VarO = o(xVarZ, attr)) != null) {
                return g0VarO;
            }
            o0 o0VarY = this.f13398a.d().l().y();
            m.e(o0VarY, "c.module.builtIns.defaultBound");
            return o0VarY;
        }
        if (xVar == null) {
            o0 o0VarY2 = this.f13398a.d().l().y();
            m.e(o0VarY2, "c.module.builtIns.defaultBound");
            return o0VarY2;
        }
        throw new UnsupportedOperationException("Unsupported type: " + xVar);
    }

    private final boolean b(j jVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        w1 w1VarJ;
        if (!a0.a((x) r.u0(jVar.C()))) {
            return false;
        }
        List<f1> parameters = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f12525a.b(eVar).h().getParameters();
        m.e(parameters, "JavaToKotlinClassMapper.…ypeConstructor.parameters");
        f1 f1Var = (f1) r.u0(parameters);
        if (f1Var == null || (w1VarJ = f1Var.j()) == null || w1VarJ == w1.OUT_VARIANCE) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    private final List<k1> c(j jVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar, g1 g1Var) {
        boolean z10;
        if (!jVar.u()) {
            if (jVar.C().isEmpty()) {
                List<f1> parameters = g1Var.getParameters();
                m.e(parameters, "constructor.parameters");
                if (!parameters.isEmpty()) {
                    z10 = true;
                }
            }
            z10 = false;
        } else {
            z10 = true;
        }
        List<f1> parameters2 = g1Var.getParameters();
        m.e(parameters2, "constructor.parameters");
        if (z10) {
            return d(jVar, parameters2, g1Var, aVar);
        }
        if (parameters2.size() != jVar.C().size()) {
            List<f1> list = parameters2;
            ArrayList arrayList = new ArrayList(r.w(list, 10));
            for (f1 f1Var : list) {
                la.j jVar2 = la.j.U;
                String strF = f1Var.getName().f();
                m.e(strF, "p.name.asString()");
                arrayList.add(new m1(la.k.d(jVar2, strF)));
            }
            return r.O0(arrayList);
        }
        Iterable<IndexedValue> iterableU0 = r.U0(jVar.C());
        ArrayList arrayList2 = new ArrayList(r.w(iterableU0, 10));
        for (IndexedValue indexedValue : iterableU0) {
            int index = indexedValue.getIndex();
            x xVar = (x) indexedValue.b();
            parameters2.size();
            f1 parameter = parameters2.get(index);
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVarB = b.b(r1.COMMON, false, false, null, 7, null);
            m.e(parameter, "parameter");
            arrayList2.add(p(xVar, aVarB, parameter));
        }
        return r.O0(arrayList2);
    }

    private final g1 f(j jVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar) {
        g1 g1VarH;
        u9.i iVarC = jVar.c();
        if (iVarC == null) {
            return g(jVar);
        }
        if (iVarC instanceof u9.g) {
            u9.g gVar = (u9.g) iVarC;
            ba.c cVarD = gVar.d();
            if (cVarD != null) {
                kotlin.reflect.jvm.internal.impl.descriptors.e eVarJ = j(jVar, aVar, cVarD);
                if (eVarJ == null) {
                    eVarJ = this.f13398a.a().n().a(gVar);
                }
                if (eVarJ != null && (g1VarH = eVarJ.h()) != null) {
                    return g1VarH;
                }
                return g(jVar);
            }
            throw new AssertionError("Class type should have a FQ name: " + iVarC);
        }
        if (iVarC instanceof y) {
            f1 f1VarA = this.f13399b.a((y) iVarC);
            if (f1VarA != null) {
                return f1VarA.h();
            }
            return null;
        }
        throw new IllegalStateException("Unknown classifier kind: " + iVarC);
    }

    private final boolean h(w1 w1Var, f1 f1Var) {
        if (f1Var.j() == w1.INVARIANT || w1Var == f1Var.j()) {
            return false;
        }
        return true;
    }

    private final boolean i(kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar) {
        if (aVar.g() == c.FLEXIBLE_LOWER_BOUND || aVar.h() || aVar.b() == r1.SUPERTYPE) {
            return false;
        }
        return true;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.e j(j jVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar, ba.c cVar) {
        if (aVar.h() && m.a(cVar, e.f13402a)) {
            return this.f13398a.a().p().c();
        }
        kotlin.reflect.jvm.internal.impl.builtins.jvm.d dVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f12525a;
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarF = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f(dVar, cVar, this.f13398a.d().l(), null, 4, null);
        if (eVarF == null) {
            return null;
        }
        if (dVar.d(eVarF) && (aVar.g() == c.FLEXIBLE_LOWER_BOUND || aVar.b() == r1.SUPERTYPE || b(jVar, eVarF))) {
            return dVar.b(eVarF);
        }
        return eVarF;
    }

    private final g0 m(j jVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a aVar) {
        boolean z10;
        if (!aVar.h() && aVar.b() != r1.SUPERTYPE) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean zU = jVar.u();
        if (!zU && !z10) {
            o0 o0VarE = e(jVar, aVar, null);
            if (o0VarE != null) {
                return o0VarE;
            }
            return n(jVar);
        }
        o0 o0VarE2 = e(jVar, aVar.l(c.FLEXIBLE_LOWER_BOUND), null);
        if (o0VarE2 == null) {
            return n(jVar);
        }
        o0 o0VarE3 = e(jVar, aVar.l(c.FLEXIBLE_UPPER_BOUND), o0VarE2);
        if (o0VarE3 == null) {
            return n(jVar);
        }
        if (zU) {
            return new h(o0VarE2, o0VarE3);
        }
        return h0.d(o0VarE2, o0VarE3);
    }
}
