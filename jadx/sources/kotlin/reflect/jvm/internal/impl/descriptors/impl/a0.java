package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.q0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12770a = a.f12771a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f12771a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final kotlin.reflect.jvm.internal.impl.descriptors.g0<a0> f12772b = new kotlin.reflect.jvm.internal.impl.descriptors.g0<>("PackageViewDescriptorFactory");

        public final kotlin.reflect.jvm.internal.impl.descriptors.g0<a0> a() {
            return f12772b;
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b implements a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f12773b = new b();

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a0
        public q0 a(x module, ba.c fqName, ka.n storageManager) {
            kotlin.jvm.internal.m.f(module, "module");
            kotlin.jvm.internal.m.f(fqName, "fqName");
            kotlin.jvm.internal.m.f(storageManager, "storageManager");
            return new r(module, fqName, storageManager);
        }

        private b() {
        }
    }

    q0 a(x xVar, ba.c cVar, ka.n nVar);
}
