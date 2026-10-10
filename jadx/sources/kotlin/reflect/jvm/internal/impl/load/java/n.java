package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class n implements kotlin.reflect.jvm.internal.impl.resolve.f {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.f
    public kotlin.reflect.jvm.internal.impl.resolve.f.a a() {
        return kotlin.reflect.jvm.internal.impl.resolve.f.a.BOTH;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.f
    public kotlin.reflect.jvm.internal.impl.resolve.f.b b(kotlin.reflect.jvm.internal.impl.descriptors.a superDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a subDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        kotlin.jvm.internal.m.f(superDescriptor, "superDescriptor");
        kotlin.jvm.internal.m.f(subDescriptor, "subDescriptor");
        if (!(subDescriptor instanceof u0) || !(superDescriptor instanceof u0)) {
            return kotlin.reflect.jvm.internal.impl.resolve.f.b.UNKNOWN;
        }
        u0 u0Var = (u0) subDescriptor;
        u0 u0Var2 = (u0) superDescriptor;
        if (!kotlin.jvm.internal.m.a(u0Var.getName(), u0Var2.getName())) {
            return kotlin.reflect.jvm.internal.impl.resolve.f.b.UNKNOWN;
        }
        if (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c.a(u0Var) && kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c.a(u0Var2)) {
            return kotlin.reflect.jvm.internal.impl.resolve.f.b.OVERRIDABLE;
        }
        return (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c.a(u0Var) || kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c.a(u0Var2)) ? kotlin.reflect.jvm.internal.impl.resolve.f.b.INCOMPATIBLE : kotlin.reflect.jvm.internal.impl.resolve.f.b.UNKNOWN;
    }
}
