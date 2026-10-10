package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class g extends kotlin.reflect.jvm.internal.impl.types.i {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14237a = new a();

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        public kotlin.reflect.jvm.internal.impl.descriptors.e b(ba.b classId) {
            kotlin.jvm.internal.m.f(classId, "classId");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        public <S extends kotlin.reflect.jvm.internal.impl.resolve.scopes.h> S c(kotlin.reflect.jvm.internal.impl.descriptors.e classDescriptor, c9.a<? extends S> compute) {
            kotlin.jvm.internal.m.f(classDescriptor, "classDescriptor");
            kotlin.jvm.internal.m.f(compute, "compute");
            return compute.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        public boolean d(h0 moduleDescriptor) {
            kotlin.jvm.internal.m.f(moduleDescriptor, "moduleDescriptor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        public boolean e(g1 typeConstructor) {
            kotlin.jvm.internal.m.f(typeConstructor, "typeConstructor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        public Collection<g0> g(kotlin.reflect.jvm.internal.impl.descriptors.e classDescriptor) {
            kotlin.jvm.internal.m.f(classDescriptor, "classDescriptor");
            Collection<g0> collectionB = classDescriptor.h().b();
            kotlin.jvm.internal.m.e(collectionB, "classDescriptor.typeConstructor.supertypes");
            return collectionB;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.i
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public g0 a(na.i type) {
            kotlin.jvm.internal.m.f(type, "type");
            return (g0) type;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.descriptors.e f(kotlin.reflect.jvm.internal.impl.descriptors.m descriptor) {
            kotlin.jvm.internal.m.f(descriptor, "descriptor");
            return null;
        }

        private a() {
        }
    }

    public abstract kotlin.reflect.jvm.internal.impl.descriptors.e b(ba.b bVar);

    public abstract <S extends kotlin.reflect.jvm.internal.impl.resolve.scopes.h> S c(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, c9.a<? extends S> aVar);

    public abstract boolean d(h0 h0Var);

    public abstract boolean e(g1 g1Var);

    public abstract kotlin.reflect.jvm.internal.impl.descriptors.h f(kotlin.reflect.jvm.internal.impl.descriptors.m mVar);

    public abstract Collection<g0> g(kotlin.reflect.jvm.internal.impl.descriptors.e eVar);

    /* JADX INFO: renamed from: h */
    public abstract g0 a(na.i iVar);
}
