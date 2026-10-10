package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class z {
    public static final na.i a(q1 q1Var, na.i inlineClassType) {
        kotlin.jvm.internal.m.f(q1Var, "<this>");
        kotlin.jvm.internal.m.f(inlineClassType, "inlineClassType");
        return b(q1Var, inlineClassType, new HashSet());
    }

    private static final na.i b(q1 q1Var, na.i iVar, HashSet<na.n> hashSet) {
        na.i iVarB;
        boolean z10;
        na.n nVarY0 = q1Var.y0(iVar);
        if (!hashSet.add(nVarY0)) {
            return null;
        }
        na.o oVarL0 = q1Var.l0(nVarY0);
        if (oVarL0 != null) {
            na.i iVarX = q1Var.X(oVarL0);
            na.i iVarB2 = b(q1Var, iVarX, hashSet);
            if (iVarB2 == null) {
                return null;
            }
            if (!q1Var.j(q1Var.y0(iVarX)) && (!(iVarX instanceof na.k) || !q1Var.e0((na.k) iVarX))) {
                z10 = false;
            } else {
                z10 = true;
            }
            if ((iVarB2 instanceof na.k) && q1Var.e0((na.k) iVarB2) && q1Var.l(iVar) && z10) {
                return q1Var.a0(iVarX);
            }
            if (!q1Var.l(iVarB2) && q1Var.U(iVar)) {
                return q1Var.a0(iVarB2);
            }
            return iVarB2;
        }
        if (q1Var.j(nVarY0)) {
            na.i iVarM0 = q1Var.m0(iVar);
            if (iVarM0 == null || (iVarB = b(q1Var, iVarM0, hashSet)) == null) {
                return null;
            }
            if (!q1Var.l(iVar)) {
                return iVarB;
            }
            if (!q1Var.l(iVarB) && (!(iVarB instanceof na.k) || !q1Var.e0((na.k) iVarB))) {
                return q1Var.a0(iVarB);
            }
        }
        return iVar;
    }
}
