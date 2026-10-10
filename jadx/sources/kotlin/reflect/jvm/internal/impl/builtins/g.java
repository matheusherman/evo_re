package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.n0;
import kotlin.collections.r;
import kotlin.reflect.jvm.internal.impl.resolve.constants.v;
import kotlin.reflect.jvm.internal.impl.types.d1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class g {
    public static final int a(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVarJ = g0Var.getAnnotations().j(k.a.D);
        if (cVarJ == null) {
            return 0;
        }
        kotlin.reflect.jvm.internal.impl.resolve.constants.g gVar = (kotlin.reflect.jvm.internal.impl.resolve.constants.g) n0.j(cVarJ.a(), k.f12583l);
        kotlin.jvm.internal.m.d(gVar, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        return ((kotlin.reflect.jvm.internal.impl.resolve.constants.m) gVar).b().intValue();
    }

    public static final o0 b(h builtIns, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, g0 g0Var, List<? extends g0> contextReceiverTypes, List<? extends g0> parameterTypes, List<ba.f> list, g0 returnType, boolean z10) {
        kotlin.jvm.internal.m.f(builtIns, "builtIns");
        kotlin.jvm.internal.m.f(annotations, "annotations");
        kotlin.jvm.internal.m.f(contextReceiverTypes, "contextReceiverTypes");
        kotlin.jvm.internal.m.f(parameterTypes, "parameterTypes");
        kotlin.jvm.internal.m.f(returnType, "returnType");
        List<k1> listG = g(g0Var, contextReceiverTypes, parameterTypes, list, returnType, builtIns);
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarF = f(builtIns, parameterTypes.size() + contextReceiverTypes.size() + (g0Var == null ? 0 : 1), z10);
        if (g0Var != null) {
            annotations = t(annotations, builtIns);
        }
        if (!contextReceiverTypes.isEmpty()) {
            annotations = s(annotations, builtIns, contextReceiverTypes.size());
        }
        return h0.g(d1.b(annotations), eVarF, listG);
    }

    public static final ba.f d(g0 g0Var) {
        String strB;
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVarJ = g0Var.getAnnotations().j(k.a.E);
        if (cVarJ == null) {
            return null;
        }
        Object objG0 = r.G0(cVarJ.a().values());
        v vVar = objG0 instanceof v ? (v) objG0 : null;
        if (vVar != null && (strB = vVar.b()) != null) {
            if (!ba.f.n(strB)) {
                strB = null;
            }
            if (strB != null) {
                return ba.f.l(strB);
            }
        }
        return null;
    }

    public static final List<g0> e(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        o(g0Var);
        int iA = a(g0Var);
        if (iA == 0) {
            return r.l();
        }
        List<k1> listSubList = g0Var.H0().subList(0, iA);
        ArrayList arrayList = new ArrayList(r.w(listSubList, 10));
        Iterator<T> it = listSubList.iterator();
        while (it.hasNext()) {
            g0 type = ((k1) it.next()).getType();
            kotlin.jvm.internal.m.e(type, "it.type");
            arrayList.add(type);
        }
        return arrayList;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.e f(h builtIns, int i10, boolean z10) {
        kotlin.jvm.internal.m.f(builtIns, "builtIns");
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarX = z10 ? builtIns.X(i10) : builtIns.C(i10);
        kotlin.jvm.internal.m.e(eVarX, "if (isSuspendFunction) b…tFunction(parameterCount)");
        return eVarX;
    }

    public static final List<k1> g(g0 g0Var, List<? extends g0> contextReceiverTypes, List<? extends g0> parameterTypes, List<ba.f> list, g0 returnType, h builtIns) {
        ba.f fVar;
        kotlin.jvm.internal.m.f(contextReceiverTypes, "contextReceiverTypes");
        kotlin.jvm.internal.m.f(parameterTypes, "parameterTypes");
        kotlin.jvm.internal.m.f(returnType, "returnType");
        kotlin.jvm.internal.m.f(builtIns, "builtIns");
        int i10 = 0;
        ArrayList arrayList = new ArrayList(parameterTypes.size() + contextReceiverTypes.size() + (g0Var != null ? 1 : 0) + 1);
        List<? extends g0> list2 = contextReceiverTypes;
        ArrayList arrayList2 = new ArrayList(r.w(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(oa.a.a((g0) it.next()));
        }
        arrayList.addAll(arrayList2);
        sa.a.a(arrayList, g0Var != null ? oa.a.a(g0Var) : null);
        for (Object obj : parameterTypes) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                r.v();
            }
            g0 g0VarX = (g0) obj;
            if (list == null || (fVar = list.get(i10)) == null || fVar.m()) {
                fVar = null;
            }
            if (fVar != null) {
                ba.c cVar = k.a.E;
                ba.f fVarL = ba.f.l("name");
                String strF = fVar.f();
                kotlin.jvm.internal.m.e(strF, "name.asString()");
                g0VarX = oa.a.x(g0VarX, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.a(r.A0(g0VarX.getAnnotations(), new kotlin.reflect.jvm.internal.impl.descriptors.annotations.j(builtIns, cVar, n0.f(r8.v.a(fVarL, new v(strF)))))));
            }
            arrayList.add(oa.a.a(g0VarX));
            i10 = i11;
        }
        arrayList.add(oa.a.a(returnType));
        return arrayList;
    }

    public static final m9.c i(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        kotlin.jvm.internal.m.f(mVar, "<this>");
        if ((mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) && h.B0(mVar)) {
            return h(ea.c.m(mVar));
        }
        return null;
    }

    public static final g0 j(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        o(g0Var);
        if (!r(g0Var)) {
            return null;
        }
        return g0Var.H0().get(a(g0Var)).getType();
    }

    public static final g0 k(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        o(g0Var);
        g0 type = ((k1) r.s0(g0Var.H0())).getType();
        kotlin.jvm.internal.m.e(type, "arguments.last().type");
        return type;
    }

    public static final List<k1> l(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        o(g0Var);
        List<k1> listH0 = g0Var.H0();
        return listH0.subList(a(g0Var) + (m(g0Var) ? 1 : 0), listH0.size() - 1);
    }

    public static final boolean m(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        return o(g0Var) && r(g0Var);
    }

    public static final boolean n(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        kotlin.jvm.internal.m.f(mVar, "<this>");
        m9.c cVarI = i(mVar);
        return cVarI == m9.c.f15686b || cVarI == m9.c.f15687c;
    }

    public static final boolean o(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g0Var.J0().d();
        return hVarD != null && n(hVarD);
    }

    public static final boolean p(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g0Var.J0().d();
        return (hVarD != null ? i(hVarD) : null) == m9.c.f15686b;
    }

    public static final boolean q(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g0Var.J0().d();
        return (hVarD != null ? i(hVarD) : null) == m9.c.f15687c;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g s(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, h builtIns, int i10) {
        kotlin.jvm.internal.m.f(gVar, "<this>");
        kotlin.jvm.internal.m.f(builtIns, "builtIns");
        ba.c cVar = k.a.D;
        return gVar.F(cVar) ? gVar : kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.a(r.A0(gVar, new kotlin.reflect.jvm.internal.impl.descriptors.annotations.j(builtIns, cVar, n0.f(r8.v.a(k.f12583l, new kotlin.reflect.jvm.internal.impl.resolve.constants.m(i10))))));
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g t(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, h builtIns) {
        kotlin.jvm.internal.m.f(gVar, "<this>");
        kotlin.jvm.internal.m.f(builtIns, "builtIns");
        ba.c cVar = k.a.C;
        return gVar.F(cVar) ? gVar : kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.a(r.A0(gVar, new kotlin.reflect.jvm.internal.impl.descriptors.annotations.j(builtIns, cVar, n0.i())));
    }

    private static final m9.c h(ba.d dVar) {
        if (dVar.f() && !dVar.e()) {
            m9.c.a aVar = m9.c.f15685a;
            String strF = dVar.i().f();
            kotlin.jvm.internal.m.e(strF, "shortName().asString()");
            ba.c cVarE = dVar.l().e();
            kotlin.jvm.internal.m.e(cVarE, "toSafe().parent()");
            return aVar.b(strF, cVarE);
        }
        return null;
    }

    private static final boolean r(g0 g0Var) {
        if (g0Var.getAnnotations().j(k.a.C) != null) {
            return true;
        }
        return false;
    }
}
