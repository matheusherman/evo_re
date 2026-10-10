package s9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.l;
import kotlin.reflect.jvm.internal.impl.types.g0;
import r8.p;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class h {
    public static final List<j1> a(Collection<? extends g0> newValueParameterTypes, Collection<? extends j1> oldValueParameters, kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        m.f(newValueParameterTypes, "newValueParameterTypes");
        m.f(oldValueParameters, "oldValueParameters");
        kotlin.reflect.jvm.internal.impl.descriptors.a newOwner = aVar;
        m.f(newOwner, "newOwner");
        newValueParameterTypes.size();
        oldValueParameters.size();
        List<p> listW0 = r.W0(newValueParameterTypes, oldValueParameters);
        ArrayList arrayList = new ArrayList(r.w(listW0, 10));
        for (p pVar : listW0) {
            g0 g0Var = (g0) pVar.a();
            j1 j1Var = (j1) pVar.b();
            int index = j1Var.getIndex();
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = j1Var.getAnnotations();
            ba.f name = j1Var.getName();
            m.e(name, "oldParameter.name");
            boolean zQ0 = j1Var.q0();
            boolean zX = j1Var.X();
            boolean zT = j1Var.T();
            g0 g0VarK = j1Var.h0() != null ? ea.c.p(newOwner).l().k(g0Var) : null;
            a1 source = j1Var.getSource();
            m.e(source, "oldParameter.source");
            arrayList.add(new l0(newOwner, null, index, annotations, name, g0Var, zQ0, zX, zT, g0VarK, source));
            newOwner = aVar;
        }
        return arrayList;
    }

    public static final l b(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        m.f(eVar, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarT = ea.c.t(eVar);
        if (eVarT == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarN = eVarT.N();
        l lVar = hVarN instanceof l ? (l) hVarN : null;
        return lVar == null ? b(eVarT) : lVar;
    }
}
