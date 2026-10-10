package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d0 {
    public static final a0 a(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        v1 v1VarM0 = g0Var.M0();
        kotlin.jvm.internal.m.d(v1VarM0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return (a0) v1VarM0;
    }

    public static final boolean b(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        return g0Var.M0() instanceof a0;
    }

    public static final o0 c(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        v1 v1VarM0 = g0Var.M0();
        if (v1VarM0 instanceof a0) {
            return ((a0) v1VarM0).R0();
        }
        if (v1VarM0 instanceof o0) {
            return (o0) v1VarM0;
        }
        throw new r8.n();
    }

    public static final o0 d(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        v1 v1VarM0 = g0Var.M0();
        if (v1VarM0 instanceof a0) {
            return ((a0) v1VarM0).S0();
        }
        if (v1VarM0 instanceof o0) {
            return (o0) v1VarM0;
        }
        throw new r8.n();
    }
}
