package n9;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public interface c {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f16096a = new a();

        @Override // n9.c
        public boolean b(kotlin.reflect.jvm.internal.impl.descriptors.e classDescriptor, z0 functionDescriptor) {
            m.f(classDescriptor, "classDescriptor");
            m.f(functionDescriptor, "functionDescriptor");
            return true;
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f16097a = new b();

        @Override // n9.c
        public boolean b(kotlin.reflect.jvm.internal.impl.descriptors.e classDescriptor, z0 functionDescriptor) {
            m.f(classDescriptor, "classDescriptor");
            m.f(functionDescriptor, "functionDescriptor");
            return !functionDescriptor.getAnnotations().F(d.a());
        }

        private b() {
        }
    }

    boolean b(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, z0 z0Var);
}
