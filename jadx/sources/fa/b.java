package fa;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.k;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.resolve.g;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b {
    public static final boolean b(m mVar) {
        kotlin.jvm.internal.m.f(mVar, "<this>");
        return g.b(mVar) && !a((kotlin.reflect.jvm.internal.impl.descriptors.e) mVar);
    }

    public static final boolean c(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        h hVarD = g0Var.J0().d();
        return hVarD != null && b(hVarD);
    }

    public static final boolean f(kotlin.reflect.jvm.internal.impl.descriptors.b descriptor) {
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) descriptor : null;
        if (dVar == null || t.g(dVar.getVisibility())) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarW = dVar.w();
        kotlin.jvm.internal.m.e(eVarW, "constructorDescriptor.constructedClass");
        if (g.b(eVarW) || kotlin.reflect.jvm.internal.impl.resolve.e.G(dVar.w())) {
            return false;
        }
        List<j1> listF = dVar.f();
        kotlin.jvm.internal.m.e(listF, "constructorDescriptor.valueParameters");
        List<j1> list = listF;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            g0 type = ((j1) it.next()).getType();
            kotlin.jvm.internal.m.e(type, "it.type");
            if (e(type)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean a(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        return kotlin.jvm.internal.m.a(ea.c.l(eVar), k.f12589r);
    }

    private static final boolean d(g0 g0Var) {
        f1 f1Var;
        h hVarD = g0Var.J0().d();
        if (hVarD instanceof f1) {
            f1Var = (f1) hVarD;
        } else {
            f1Var = null;
        }
        if (f1Var == null) {
            return false;
        }
        return e(oa.a.j(f1Var));
    }

    private static final boolean e(g0 g0Var) {
        if (!c(g0Var) && !d(g0Var)) {
            return false;
        }
        return true;
    }
}
