package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class u1 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final g0 a(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        if (g0Var instanceof t1) {
            return ((t1) g0Var).C();
        }
        return null;
    }

    public static final v1 b(v1 v1Var, g0 origin) {
        kotlin.jvm.internal.m.f(v1Var, "<this>");
        kotlin.jvm.internal.m.f(origin, "origin");
        return d(v1Var, a(origin));
    }

    public static final v1 c(v1 v1Var, g0 origin, c9.l<? super g0, ? extends g0> transform) {
        kotlin.jvm.internal.m.f(v1Var, "<this>");
        kotlin.jvm.internal.m.f(origin, "origin");
        kotlin.jvm.internal.m.f(transform, "transform");
        g0 g0VarA = a(origin);
        return d(v1Var, g0VarA != null ? transform.invoke(g0VarA) : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final v1 d(v1 v1Var, g0 g0Var) {
        kotlin.jvm.internal.m.f(v1Var, "<this>");
        if (v1Var instanceof t1) {
            return d(((t1) v1Var).B0(), g0Var);
        }
        if (g0Var == null || kotlin.jvm.internal.m.a(g0Var, v1Var)) {
            return v1Var;
        }
        if (v1Var instanceof o0) {
            return new r0((o0) v1Var, g0Var);
        }
        if (v1Var instanceof a0) {
            return new c0((a0) v1Var, g0Var);
        }
        throw new r8.n();
    }
}
