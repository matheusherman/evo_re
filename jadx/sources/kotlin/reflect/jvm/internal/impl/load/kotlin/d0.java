package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.q1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d0 {
    public static final <T> T a(o<T> oVar, T possiblyPrimitiveType, boolean z10) {
        kotlin.jvm.internal.m.f(oVar, "<this>");
        kotlin.jvm.internal.m.f(possiblyPrimitiveType, "possiblyPrimitiveType");
        return z10 ? oVar.d(possiblyPrimitiveType) : possiblyPrimitiveType;
    }

    public static final <T> T b(q1 q1Var, na.i type, o<T> typeFactory, c0 mode) {
        kotlin.jvm.internal.m.f(q1Var, "<this>");
        kotlin.jvm.internal.m.f(type, "type");
        kotlin.jvm.internal.m.f(typeFactory, "typeFactory");
        kotlin.jvm.internal.m.f(mode, "mode");
        na.n nVarY0 = q1Var.y0(type);
        if (!q1Var.p(nVarY0)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.builtins.i iVarA = q1Var.A(nVarY0);
        if (iVarA != null) {
            return (T) a(typeFactory, typeFactory.f(iVarA), q1Var.l(type) || kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.s.c(q1Var, type));
        }
        kotlin.reflect.jvm.internal.impl.builtins.i iVarT0 = q1Var.t0(nVarY0);
        if (iVarT0 != null) {
            return typeFactory.b('[' + fa.e.i(iVarT0).j());
        }
        if (q1Var.E0(nVarY0)) {
            ba.d dVarY = q1Var.Y(nVarY0);
            ba.b bVarN = dVarY != null ? kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f12505a.n(dVarY) : null;
            if (bVarN != null) {
                if (!mode.a()) {
                    List<kotlin.reflect.jvm.internal.impl.builtins.jvm.c.a> listI = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f12505a.i();
                    if (!(listI instanceof Collection) || !listI.isEmpty()) {
                        Iterator<T> it = listI.iterator();
                        while (it.hasNext()) {
                            if (kotlin.jvm.internal.m.a(((kotlin.reflect.jvm.internal.impl.builtins.jvm.c.a) it.next()).d(), bVarN)) {
                                return null;
                            }
                        }
                    }
                }
                String strF = fa.d.b(bVarN).f();
                kotlin.jvm.internal.m.e(strF, "byClassId(classId).internalName");
                return typeFactory.c(strF);
            }
        }
        return null;
    }
}
