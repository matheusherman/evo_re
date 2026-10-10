package n9;

import ba.f;
import java.util.Collection;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public interface a {

    /* JADX INFO: renamed from: n9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class C0311a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0311a f16095a = new C0311a();

        @Override // n9.a
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> a(kotlin.reflect.jvm.internal.impl.descriptors.e classDescriptor) {
            m.f(classDescriptor, "classDescriptor");
            return r.l();
        }

        @Override // n9.a
        public Collection<g0> c(kotlin.reflect.jvm.internal.impl.descriptors.e classDescriptor) {
            m.f(classDescriptor, "classDescriptor");
            return r.l();
        }

        @Override // n9.a
        public Collection<z0> d(f name, kotlin.reflect.jvm.internal.impl.descriptors.e classDescriptor) {
            m.f(name, "name");
            m.f(classDescriptor, "classDescriptor");
            return r.l();
        }

        @Override // n9.a
        public Collection<f> e(kotlin.reflect.jvm.internal.impl.descriptors.e classDescriptor) {
            m.f(classDescriptor, "classDescriptor");
            return r.l();
        }

        private C0311a() {
        }
    }

    Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> a(kotlin.reflect.jvm.internal.impl.descriptors.e eVar);

    Collection<g0> c(kotlin.reflect.jvm.internal.impl.descriptors.e eVar);

    Collection<z0> d(f fVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar);

    Collection<f> e(kotlin.reflect.jvm.internal.impl.descriptors.e eVar);
}
