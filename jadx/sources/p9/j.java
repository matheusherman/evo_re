package p9;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.q;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class j implements q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f17446b = new j();

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.q
    public void a(kotlin.reflect.jvm.internal.impl.descriptors.b descriptor) {
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        throw new IllegalStateException("Cannot infer visibility for " + descriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.q
    public void b(kotlin.reflect.jvm.internal.impl.descriptors.e descriptor, List<String> unresolvedSuperClasses) {
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        kotlin.jvm.internal.m.f(unresolvedSuperClasses, "unresolvedSuperClasses");
        throw new IllegalStateException("Incomplete hierarchy for class " + descriptor.getName() + ", unresolved classes " + unresolvedSuperClasses);
    }

    private j() {
    }
}
