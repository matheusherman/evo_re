package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class o1 {
    public static final o0 a(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        v1 v1VarM0 = g0Var.M0();
        o0 o0Var = v1VarM0 instanceof o0 ? (o0) v1VarM0 : null;
        if (o0Var != null) {
            return o0Var;
        }
        throw new IllegalStateException(("This is should be simple type: " + g0Var).toString());
    }

    public static final g0 b(g0 g0Var, List<? extends k1> newArguments, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g newAnnotations) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        kotlin.jvm.internal.m.f(newArguments, "newArguments");
        kotlin.jvm.internal.m.f(newAnnotations, "newAnnotations");
        return e(g0Var, newArguments, newAnnotations, null, 4, null);
    }

    public static final g0 c(g0 g0Var, List<? extends k1> newArguments, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g newAnnotations, List<? extends k1> newArgumentsForUpperBound) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        kotlin.jvm.internal.m.f(newArguments, "newArguments");
        kotlin.jvm.internal.m.f(newAnnotations, "newAnnotations");
        kotlin.jvm.internal.m.f(newArgumentsForUpperBound, "newArgumentsForUpperBound");
        if ((newArguments.isEmpty() || newArguments == g0Var.H0()) && newAnnotations == g0Var.getAnnotations()) {
            return g0Var;
        }
        c1 c1VarI0 = g0Var.I0();
        if ((newAnnotations instanceof kotlin.reflect.jvm.internal.impl.descriptors.annotations.l) && newAnnotations.isEmpty()) {
            newAnnotations = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b();
        }
        c1 c1VarA = d1.a(c1VarI0, newAnnotations);
        v1 v1VarM0 = g0Var.M0();
        if (v1VarM0 instanceof a0) {
            a0 a0Var = (a0) v1VarM0;
            return h0.d(d(a0Var.R0(), newArguments, c1VarA), d(a0Var.S0(), newArgumentsForUpperBound, c1VarA));
        }
        if (v1VarM0 instanceof o0) {
            return d((o0) v1VarM0, newArguments, c1VarA);
        }
        throw new r8.n();
    }

    public static final o0 d(o0 o0Var, List<? extends k1> newArguments, c1 newAttributes) {
        kotlin.jvm.internal.m.f(o0Var, "<this>");
        kotlin.jvm.internal.m.f(newArguments, "newArguments");
        kotlin.jvm.internal.m.f(newAttributes, "newAttributes");
        if (newArguments.isEmpty() && newAttributes == o0Var.I0()) {
            return o0Var;
        }
        if (newArguments.isEmpty()) {
            return o0Var.P0(newAttributes);
        }
        return o0Var instanceof la.h ? ((la.h) o0Var).V0(newArguments) : h0.j(newAttributes, o0Var.J0(), newArguments, o0Var.K0(), null, 16, null);
    }

    public static /* synthetic */ g0 e(g0 g0Var, List list, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = g0Var.H0();
        }
        if ((i10 & 2) != 0) {
            gVar = g0Var.getAnnotations();
        }
        if ((i10 & 4) != 0) {
            list2 = list;
        }
        return c(g0Var, list, gVar, list2);
    }

    public static /* synthetic */ o0 f(o0 o0Var, List list, c1 c1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = o0Var.H0();
        }
        if ((i10 & 2) != 0) {
            c1Var = o0Var.I0();
        }
        return d(o0Var, list, c1Var);
    }
}
