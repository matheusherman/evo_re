package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.collections.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d {
    public static final boolean a(c cVar, kotlin.reflect.jvm.internal.impl.descriptors.e classDescriptor) {
        kotlin.jvm.internal.m.f(cVar, "<this>");
        kotlin.jvm.internal.m.f(classDescriptor, "classDescriptor");
        if (!kotlin.reflect.jvm.internal.impl.resolve.e.x(classDescriptor)) {
            return false;
        }
        Set<ba.b> setB = cVar.b();
        ba.b bVarK = ea.c.k(classDescriptor);
        return r.a0(setB, bVarK != null ? bVarK.g() : null);
    }
}
