package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b0 implements a0<n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f13531a = new b0();

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.a0
    public String b(kotlin.reflect.jvm.internal.impl.descriptors.e classDescriptor) {
        kotlin.jvm.internal.m.f(classDescriptor, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.a0
    public g0 c(Collection<? extends g0> types) {
        kotlin.jvm.internal.m.f(types, "types");
        throw new AssertionError("There should be no intersection type in existing descriptors, but found: " + kotlin.collections.r.q0(types, null, null, null, 0, null, null, 63, null));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.a0
    public String d(kotlin.reflect.jvm.internal.impl.descriptors.e classDescriptor) {
        kotlin.jvm.internal.m.f(classDescriptor, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.a0
    public g0 e(g0 kotlinType) {
        kotlin.jvm.internal.m.f(kotlinType, "kotlinType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.a0
    public void f(g0 kotlinType, kotlin.reflect.jvm.internal.impl.descriptors.e descriptor) {
        kotlin.jvm.internal.m.f(kotlinType, "kotlinType");
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.a0
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public n a(kotlin.reflect.jvm.internal.impl.descriptors.e classDescriptor) {
        kotlin.jvm.internal.m.f(classDescriptor, "classDescriptor");
        return null;
    }

    private b0() {
    }
}
