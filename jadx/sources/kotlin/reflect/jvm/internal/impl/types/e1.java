package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e1 {
    public static final n a(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVarM0 = g0Var.M0();
        n nVar = aVarM0 instanceof n ? (n) aVarM0 : null;
        if (nVar == null || !nVar.w0()) {
            return null;
        }
        return nVar;
    }

    public static final boolean b(g0 g0Var) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVarM0 = g0Var.M0();
        n nVar = aVarM0 instanceof n ? (n) aVarM0 : null;
        if (nVar != null) {
            return nVar.w0();
        }
        return false;
    }
}
