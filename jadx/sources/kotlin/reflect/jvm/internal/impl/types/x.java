package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class x {
    public static /* synthetic */ k1 b(x xVar, kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var, y yVar, j1 j1Var, g0 g0Var, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: computeProjection");
        }
        if ((i10 & 8) != 0) {
            g0Var = j1Var.c(f1Var, yVar);
        }
        return xVar.a(f1Var, yVar, j1Var, g0Var);
    }

    public k1 a(kotlin.reflect.jvm.internal.impl.descriptors.f1 parameter, y typeAttr, j1 typeParameterUpperBoundEraser, g0 erasedUpperBound) {
        kotlin.jvm.internal.m.f(parameter, "parameter");
        kotlin.jvm.internal.m.f(typeAttr, "typeAttr");
        kotlin.jvm.internal.m.f(typeParameterUpperBoundEraser, "typeParameterUpperBoundEraser");
        kotlin.jvm.internal.m.f(erasedUpperBound, "erasedUpperBound");
        return new m1(w1.OUT_VARIANCE, erasedUpperBound);
    }
}
