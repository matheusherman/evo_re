package pa;

import c9.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.builtins.h;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.d;
import kotlin.reflect.jvm.internal.impl.types.d0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.m1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.o1;
import kotlin.reflect.jvm.internal.impl.types.p1;
import kotlin.reflect.jvm.internal.impl.types.s1;
import kotlin.reflect.jvm.internal.impl.types.u1;
import kotlin.reflect.jvm.internal.impl.types.v1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import r8.n;
import r8.p;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class b {

    /* JADX INFO: renamed from: pa.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0334b extends o implements l<v1, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0334b f17456a = new C0334b();

        C0334b() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(v1 it) {
            m.e(it, "it");
            return Boolean.valueOf(d.d(it));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class c extends h1 {
        @Override // kotlin.reflect.jvm.internal.impl.types.h1
        public k1 k(g1 key) {
            m.f(key, "key");
            kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b bVar = key instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b ? (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b) key : null;
            if (bVar == null) {
                return null;
            }
            return bVar.f().b() ? new m1(w1.OUT_VARIANCE, bVar.f().getType()) : bVar.f();
        }

        c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17455a;

        static {
            int[] iArr = new int[w1.values().length];
            try {
                iArr[w1.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[w1.IN_VARIANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[w1.OUT_VARIANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f17455a = iArr;
        }
    }

    public static final pa.a<g0> a(g0 type) {
        Object objE;
        m.f(type, "type");
        if (d0.b(type)) {
            pa.a<g0> aVarA = a(d0.c(type));
            pa.a<g0> aVarA2 = a(d0.d(type));
            return new pa.a<>(u1.b(h0.d(d0.c(aVarA.c()), d0.d(aVarA2.c())), type), u1.b(h0.d(d0.c(aVarA.d()), d0.d(aVarA2.d())), type));
        }
        g1 g1VarJ0 = type.J0();
        if (d.d(type)) {
            m.d(g1VarJ0, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
            k1 k1VarF = ((kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b) g1VarJ0).f();
            g0 type2 = k1VarF.getType();
            m.e(type2, "typeProjection.type");
            g0 g0VarB = b(type2, type);
            int i10 = a.f17455a[k1VarF.a().ordinal()];
            if (i10 == 2) {
                o0 o0VarI = oa.a.i(type).I();
                m.e(o0VarI, "type.builtIns.nullableAnyType");
                return new pa.a<>(g0VarB, o0VarI);
            }
            if (i10 == 3) {
                o0 o0VarH = oa.a.i(type).H();
                m.e(o0VarH, "type.builtIns.nothingType");
                return new pa.a<>(b(o0VarH, type), g0VarB);
            }
            throw new AssertionError("Only nontrivial projections should have been captured, not: " + k1VarF);
        }
        if (type.H0().isEmpty() || type.H0().size() != g1VarJ0.getParameters().size()) {
            return new pa.a<>(type, type);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<k1> listH0 = type.H0();
        List<f1> parameters = g1VarJ0.getParameters();
        m.e(parameters, "typeConstructor.parameters");
        for (p pVar : r.W0(listH0, parameters)) {
            k1 k1Var = (k1) pVar.a();
            f1 typeParameter = (f1) pVar.b();
            m.e(typeParameter, "typeParameter");
            pa.c cVarG = g(k1Var, typeParameter);
            if (k1Var.b()) {
                arrayList.add(cVarG);
                arrayList2.add(cVarG);
            } else {
                pa.a<pa.c> aVarD = d(cVarG);
                pa.c cVarA = aVarD.a();
                pa.c cVarB = aVarD.b();
                arrayList.add(cVarA);
                arrayList2.add(cVarB);
            }
        }
        boolean z10 = false;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!((pa.c) it.next()).d()) {
                    z10 = true;
                    break;
                }
            }
        }
        if (z10) {
            objE = oa.a.i(type).H();
            m.e(objE, "type.builtIns.nothingType");
        } else {
            objE = e(type, arrayList);
        }
        return new pa.a<>(objE, e(type, arrayList2));
    }

    public static final k1 c(k1 k1Var, boolean z10) {
        if (k1Var == null) {
            return null;
        }
        if (!k1Var.b()) {
            g0 type = k1Var.getType();
            m.e(type, "typeProjection.type");
            if (s1.c(type, C0334b.f17456a)) {
                w1 w1VarA = k1Var.a();
                m.e(w1VarA, "typeProjection.projectionKind");
                if (w1VarA == w1.OUT_VARIANCE) {
                    return new m1(w1VarA, a(type).d());
                }
                return z10 ? new m1(w1VarA, a(type).c()) : f(k1Var);
            }
        }
        return k1Var;
    }

    private static final k1 f(k1 k1Var) {
        p1 p1VarG = p1.g(new c());
        m.e(p1VarG, "create(object : TypeCons…ojection\n        }\n    })");
        return p1VarG.t(k1Var);
    }

    private static final g0 b(g0 g0Var, g0 g0Var2) {
        g0 g0VarQ = s1.q(g0Var, g0Var2.K0());
        m.e(g0VarQ, "makeNullableIfNeeded(this, type.isMarkedNullable)");
        return g0VarQ;
    }

    private static final pa.a<pa.c> d(pa.c cVar) {
        pa.a<g0> aVarA = a(cVar.a());
        g0 g0VarA = aVarA.a();
        g0 g0VarB = aVarA.b();
        pa.a<g0> aVarA2 = a(cVar.b());
        return new pa.a<>(new pa.c(cVar.c(), g0VarB, aVarA2.a()), new pa.c(cVar.c(), g0VarA, aVarA2.b()));
    }

    private static final g0 e(g0 g0Var, List<pa.c> list) {
        g0Var.H0().size();
        list.size();
        List<pa.c> list2 = list;
        ArrayList arrayList = new ArrayList(r.w(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(h((pa.c) it.next()));
        }
        return o1.e(g0Var, arrayList, null, null, 6, null);
    }

    private static final pa.c g(k1 k1Var, f1 f1Var) {
        int i10 = a.f17455a[p1.c(f1Var.j(), k1Var).ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    o0 o0VarH = ea.c.j(f1Var).H();
                    m.e(o0VarH, "typeParameter.builtIns.nothingType");
                    g0 type = k1Var.getType();
                    m.e(type, "type");
                    return new pa.c(f1Var, o0VarH, type);
                }
                throw new n();
            }
            g0 type2 = k1Var.getType();
            m.e(type2, "type");
            o0 o0VarI = ea.c.j(f1Var).I();
            m.e(o0VarI, "typeParameter.builtIns.nullableAnyType");
            return new pa.c(f1Var, type2, o0VarI);
        }
        g0 type3 = k1Var.getType();
        m.e(type3, "type");
        g0 type4 = k1Var.getType();
        m.e(type4, "type");
        return new pa.c(f1Var, type3, type4);
    }

    private static final k1 h(pa.c cVar) {
        cVar.d();
        if (!m.a(cVar.a(), cVar.b())) {
            w1 w1VarJ = cVar.c().j();
            w1 w1Var = w1.IN_VARIANCE;
            if (w1VarJ != w1Var) {
                if (h.n0(cVar.a()) && cVar.c().j() != w1Var) {
                    return new m1(i(cVar, w1.OUT_VARIANCE), cVar.b());
                }
                if (h.p0(cVar.b())) {
                    return new m1(i(cVar, w1Var), cVar.a());
                }
                return new m1(i(cVar, w1.OUT_VARIANCE), cVar.b());
            }
        }
        return new m1(cVar.a());
    }

    private static final w1 i(pa.c cVar, w1 w1Var) {
        if (w1Var == cVar.c().j()) {
            return w1.INVARIANT;
        }
        return w1Var;
    }
}
