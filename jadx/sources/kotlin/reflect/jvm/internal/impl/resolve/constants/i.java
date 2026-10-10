package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i extends g<Double> {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public o0 a(h0 module) {
        kotlin.jvm.internal.m.f(module, "module");
        o0 o0VarZ = module.l().z();
        kotlin.jvm.internal.m.e(o0VarZ, "module.builtIns.doubleType");
        return o0VarZ;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    public String toString() {
        return b().doubleValue() + ".toDouble()";
    }

    public i(double d10) {
        super(Double.valueOf(d10));
    }
}
