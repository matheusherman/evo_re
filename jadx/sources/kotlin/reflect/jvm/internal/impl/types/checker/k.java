package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.k1;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.p1;
import kotlin.reflect.jvm.internal.impl.types.v1;
import kotlin.reflect.jvm.internal.impl.types.w1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class k {
    public static final o0 b(o0 type, na.b status) {
        kotlin.jvm.internal.m.f(type, "type");
        kotlin.jvm.internal.m.f(status, "status");
        List<k1> listA = a(type, status);
        if (listA != null) {
            return c(type, listA);
        }
        return null;
    }

    private static final List<k1> a(v1 v1Var, na.b bVar) {
        v1 v1VarM0;
        if (v1Var.H0().size() != v1Var.J0().getParameters().size()) {
            return null;
        }
        List<k1> listH0 = v1Var.H0();
        List<k1> list = listH0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((k1) it.next()).a() != w1.INVARIANT) {
                    List<f1> parameters = v1Var.J0().getParameters();
                    kotlin.jvm.internal.m.e(parameters, "type.constructor.parameters");
                    List<r8.p> listW0 = kotlin.collections.r.W0(list, parameters);
                    ArrayList arrayList = new ArrayList(kotlin.collections.r.w(listW0, 10));
                    for (r8.p pVar : listW0) {
                        k1 k1VarA = (k1) pVar.a();
                        f1 parameter = (f1) pVar.b();
                        if (k1VarA.a() != w1.INVARIANT) {
                            if (!k1VarA.b() && k1VarA.a() == w1.IN_VARIANCE) {
                                v1VarM0 = k1VarA.getType().M0();
                            } else {
                                v1VarM0 = null;
                            }
                            kotlin.jvm.internal.m.e(parameter, "parameter");
                            k1VarA = oa.a.a(new i(bVar, v1VarM0, k1VarA, parameter));
                        }
                        arrayList.add(k1VarA);
                    }
                    p1 p1VarC = h1.f14318c.b(v1Var.J0(), arrayList).c();
                    int size = listH0.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        k1 k1Var = listH0.get(i10);
                        k1 k1Var2 = (k1) arrayList.get(i10);
                        if (k1Var.a() != w1.INVARIANT) {
                            List<g0> upperBounds = v1Var.J0().getParameters().get(i10).getUpperBounds();
                            kotlin.jvm.internal.m.e(upperBounds, "type.constructor.parameters[index].upperBounds");
                            ArrayList arrayList2 = new ArrayList();
                            Iterator<T> it2 = upperBounds.iterator();
                            while (it2.hasNext()) {
                                arrayList2.add(f.a.f14236a.a(p1VarC.n((g0) it2.next(), w1.INVARIANT).M0()));
                            }
                            if (!k1Var.b() && k1Var.a() == w1.OUT_VARIANCE) {
                                arrayList2.add(f.a.f14236a.a(k1Var.getType().M0()));
                            }
                            g0 type = k1Var2.getType();
                            kotlin.jvm.internal.m.d(type, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
                            ((i) type).J0().j(arrayList2);
                        }
                    }
                    return arrayList;
                }
            }
        }
        return null;
    }

    private static final o0 c(v1 v1Var, List<? extends k1> list) {
        return h0.j(v1Var.I0(), v1Var.J0(), list, v1Var.K0(), null, 16, null);
    }
}
