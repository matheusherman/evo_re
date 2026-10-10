package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.descriptors.n1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j0 {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c a(kotlin.reflect.jvm.internal.impl.load.java.lazy.g c10, u9.c0 wildcardType) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c next;
        kotlin.jvm.internal.m.f(c10, "c");
        kotlin.jvm.internal.m.f(wildcardType, "wildcardType");
        if (wildcardType.z() == null) {
            throw new IllegalArgumentException("Nullability annotations on unbounded wildcards aren't supported");
        }
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> it = new kotlin.reflect.jvm.internal.impl.load.java.lazy.d(c10, wildcardType, false, 4, null).iterator();
        while (it.hasNext()) {
            next = it.next();
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar = next;
            for (ba.c cVar2 : v.f()) {
                if (kotlin.jvm.internal.m.a(cVar.d(), cVar2)) {
                    return next;
                }
            }
        }
        next = null;
        return next;
    }

    public static final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.b memberDescriptor) {
        kotlin.jvm.internal.m.f(memberDescriptor, "memberDescriptor");
        return (memberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.y) && kotlin.jvm.internal.m.a(memberDescriptor.e0(s9.e.H), Boolean.TRUE);
    }

    public static final boolean c(x javaTypeEnhancementState) {
        kotlin.jvm.internal.m.f(javaTypeEnhancementState, "javaTypeEnhancementState");
        return javaTypeEnhancementState.c().invoke(v.e()) == g0.STRICT;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.u d(n1 n1Var) {
        kotlin.jvm.internal.m.f(n1Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.u uVarG = s.g(n1Var);
        kotlin.jvm.internal.m.e(uVarG, "toDescriptorVisibility(this)");
        return uVarG;
    }
}
