package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface d1 {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a implements d1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12742a = new a();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d1
        public Collection<kotlin.reflect.jvm.internal.impl.types.g0> a(kotlin.reflect.jvm.internal.impl.types.g1 currentTypeConstructor, Collection<? extends kotlin.reflect.jvm.internal.impl.types.g0> superTypes, c9.l<? super kotlin.reflect.jvm.internal.impl.types.g1, ? extends Iterable<? extends kotlin.reflect.jvm.internal.impl.types.g0>> neighbors, c9.l<? super kotlin.reflect.jvm.internal.impl.types.g0, r8.z> reportLoop) {
            kotlin.jvm.internal.m.f(currentTypeConstructor, "currentTypeConstructor");
            kotlin.jvm.internal.m.f(superTypes, "superTypes");
            kotlin.jvm.internal.m.f(neighbors, "neighbors");
            kotlin.jvm.internal.m.f(reportLoop, "reportLoop");
            return superTypes;
        }

        private a() {
        }
    }

    Collection<kotlin.reflect.jvm.internal.impl.types.g0> a(kotlin.reflect.jvm.internal.impl.types.g1 g1Var, Collection<? extends kotlin.reflect.jvm.internal.impl.types.g0> collection, c9.l<? super kotlin.reflect.jvm.internal.impl.types.g1, ? extends Iterable<? extends kotlin.reflect.jvm.internal.impl.types.g0>> lVar, c9.l<? super kotlin.reflect.jvm.internal.impl.types.g0, r8.z> lVar2);
}
