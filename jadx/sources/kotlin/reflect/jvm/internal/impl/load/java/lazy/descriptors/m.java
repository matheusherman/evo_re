package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import u9.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class m extends j {
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected x0 z() {
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public m(kotlin.reflect.jvm.internal.impl.load.java.lazy.g c10) {
        super(c10, null, 2, 0 == true ? 1 : 0);
        kotlin.jvm.internal.m.f(c10, "c");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected j.a H(r method, List<? extends f1> methodTypeParameters, g0 returnType, List<? extends j1> valueParameters) {
        kotlin.jvm.internal.m.f(method, "method");
        kotlin.jvm.internal.m.f(methodTypeParameters, "methodTypeParameters");
        kotlin.jvm.internal.m.f(returnType, "returnType");
        kotlin.jvm.internal.m.f(valueParameters, "valueParameters");
        return new j.a(returnType, null, valueParameters, methodTypeParameters, false, kotlin.collections.r.l());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j
    protected void s(ba.f name, Collection<u0> result) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(result, "result");
    }
}
