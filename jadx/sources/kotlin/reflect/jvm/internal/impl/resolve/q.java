package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.t;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class q {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.b a(Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> descriptors) {
        Integer numD;
        kotlin.jvm.internal.m.f(descriptors, "descriptors");
        descriptors.isEmpty();
        kotlin.reflect.jvm.internal.impl.descriptors.b bVar = null;
        for (kotlin.reflect.jvm.internal.impl.descriptors.b bVar2 : descriptors) {
            if (bVar == null || ((numD = t.d(bVar.getVisibility(), bVar2.getVisibility())) != null && numD.intValue() < 0)) {
                bVar = bVar2;
            }
        }
        kotlin.jvm.internal.m.c(bVar);
        return bVar;
    }
}
