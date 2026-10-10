package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class y extends b0<Integer> {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    public g0 a(h0 module) {
        kotlin.jvm.internal.m.f(module, "module");
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarA = kotlin.reflect.jvm.internal.impl.descriptors.x.a(module, kotlin.reflect.jvm.internal.impl.builtins.k.a.B0);
        o0 o0VarP = eVarA != null ? eVarA.p() : null;
        return o0VarP == null ? la.k.d(la.j.X1, "UInt") : o0VarP;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    public String toString() {
        return b().intValue() + ".toUInt()";
    }

    public y(int i10) {
        super(Integer.valueOf(i10));
    }
}
