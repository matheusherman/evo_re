package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d1 {
    public static final c1 a(c1 c1Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g newAnnotations) {
        c1 c1VarQ;
        kotlin.jvm.internal.m.f(c1Var, "<this>");
        kotlin.jvm.internal.m.f(newAnnotations, "newAnnotations");
        if (k.a(c1Var) == newAnnotations) {
            return c1Var;
        }
        j jVarB = k.b(c1Var);
        if (jVarB != null && (c1VarQ = c1Var.q(jVarB)) != null) {
            c1Var = c1VarQ;
        }
        return (newAnnotations.iterator().hasNext() || !newAnnotations.isEmpty()) ? c1Var.o(new j(newAnnotations)) : c1Var;
    }

    public static final c1 b(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        kotlin.jvm.internal.m.f(gVar, "<this>");
        return b1.a.a(o.f14346a, gVar, null, null, 6, null);
    }
}
