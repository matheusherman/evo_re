package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b extends g<List<? extends g<?>>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c9.l<h0, g0> f13895b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends g<?>> value, c9.l<? super h0, ? extends g0> computeType) {
        super(value);
        kotlin.jvm.internal.m.f(value, "value");
        kotlin.jvm.internal.m.f(computeType, "computeType");
        this.f13895b = computeType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    public g0 a(h0 module) {
        kotlin.jvm.internal.m.f(module, "module");
        g0 g0VarInvoke = this.f13895b.invoke(module);
        if (!kotlin.reflect.jvm.internal.impl.builtins.h.c0(g0VarInvoke) && !kotlin.reflect.jvm.internal.impl.builtins.h.q0(g0VarInvoke)) {
            kotlin.reflect.jvm.internal.impl.builtins.h.D0(g0VarInvoke);
        }
        return g0VarInvoke;
    }
}
