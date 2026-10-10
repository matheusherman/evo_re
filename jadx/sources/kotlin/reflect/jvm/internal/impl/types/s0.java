package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class s0 {
    public static final a a(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        v1 v1VarM0 = g0Var.M0();
        if (v1VarM0 instanceof a) {
            return (a) v1VarM0;
        }
        return null;
    }

    public static final o0 b(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        a aVarA = a(g0Var);
        if (aVarA != null) {
            return aVarA.V0();
        }
        return null;
    }

    public static final boolean c(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        return g0Var.M0() instanceof p;
    }

    public static final v1 e(v1 v1Var, boolean z10) {
        kotlin.jvm.internal.m.f(v1Var, "<this>");
        p pVarC = p.a.c(p.f14347d, v1Var, z10, false, 4, null);
        if (pVarC != null) {
            return pVarC;
        }
        o0 o0VarG = g(v1Var);
        return o0VarG != null ? o0VarG : v1Var.N0(false);
    }

    public static /* synthetic */ v1 f(v1 v1Var, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return e(v1Var, z10);
    }

    public static final o0 h(o0 o0Var, boolean z10) {
        kotlin.jvm.internal.m.f(o0Var, "<this>");
        p pVarC = p.a.c(p.f14347d, o0Var, z10, false, 4, null);
        if (pVarC != null) {
            return pVarC;
        }
        o0 o0VarG = g(o0Var);
        return o0VarG == null ? o0Var.N0(false) : o0VarG;
    }

    public static /* synthetic */ o0 i(o0 o0Var, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return h(o0Var, z10);
    }

    public static final o0 j(o0 o0Var, o0 abbreviatedType) {
        kotlin.jvm.internal.m.f(o0Var, "<this>");
        kotlin.jvm.internal.m.f(abbreviatedType, "abbreviatedType");
        return i0.a(o0Var) ? o0Var : new a(o0Var, abbreviatedType);
    }

    public static final kotlin.reflect.jvm.internal.impl.types.checker.i k(kotlin.reflect.jvm.internal.impl.types.checker.i iVar) {
        kotlin.jvm.internal.m.f(iVar, "<this>");
        return new kotlin.reflect.jvm.internal.impl.types.checker.i(iVar.S0(), iVar.J0(), iVar.U0(), iVar.I0(), iVar.K0(), true);
    }

    private static final f0 d(f0 f0Var) {
        g0 g0Var;
        Collection<g0> collectionB = f0Var.b();
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(collectionB, 10));
        Iterator<T> it = collectionB.iterator();
        boolean z10 = false;
        while (true) {
            g0Var = null;
            if (!it.hasNext()) {
                break;
            }
            g0 g0VarF = (g0) it.next();
            if (s1.l(g0VarF)) {
                g0VarF = f(g0VarF.M0(), false, 1, null);
                z10 = true;
            }
            arrayList.add(g0VarF);
        }
        if (!z10) {
            return null;
        }
        g0 g0VarI = f0Var.i();
        if (g0VarI != null) {
            if (s1.l(g0VarI)) {
                g0VarI = f(g0VarI.M0(), false, 1, null);
            }
            g0Var = g0VarI;
        }
        return new f0(arrayList).n(g0Var);
    }

    private static final o0 g(g0 g0Var) {
        f0 f0Var;
        f0 f0VarD;
        g1 g1VarJ0 = g0Var.J0();
        if (g1VarJ0 instanceof f0) {
            f0Var = (f0) g1VarJ0;
        } else {
            f0Var = null;
        }
        if (f0Var == null || (f0VarD = d(f0Var)) == null) {
            return null;
        }
        return f0VarD.h();
    }
}
