package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a implements kotlin.reflect.jvm.internal.impl.load.java.u {
        @Override // kotlin.reflect.jvm.internal.impl.load.java.u
        public List<u9.a> a(ba.b classId) {
            kotlin.jvm.internal.m.f(classId, "classId");
            return null;
        }

        a() {
        }
    }

    public static final g a(h0 module, ka.n storageManager, k0 notFoundClasses, kotlin.reflect.jvm.internal.impl.load.java.lazy.f lazyJavaPackageFragmentProvider, q reflectKotlinClassFinder, i deserializedDescriptorResolver, kotlin.reflect.jvm.internal.impl.serialization.deserialization.q errorReporter, aa.e jvmMetadataVersion) {
        kotlin.jvm.internal.m.f(module, "module");
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.m.f(lazyJavaPackageFragmentProvider, "lazyJavaPackageFragmentProvider");
        kotlin.jvm.internal.m.f(reflectKotlinClassFinder, "reflectKotlinClassFinder");
        kotlin.jvm.internal.m.f(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        kotlin.jvm.internal.m.f(errorReporter, "errorReporter");
        kotlin.jvm.internal.m.f(jvmMetadataVersion, "jvmMetadataVersion");
        return new g(storageManager, module, kotlin.reflect.jvm.internal.impl.serialization.deserialization.l.a.f14170a, new j(reflectKotlinClassFinder, deserializedDescriptorResolver), e.a(module, notFoundClasses, storageManager, reflectKotlinClassFinder, jvmMetadataVersion), lazyJavaPackageFragmentProvider, notFoundClasses, errorReporter, r9.c.a.f17875a, kotlin.reflect.jvm.internal.impl.serialization.deserialization.j.f14146a.a(), kotlin.reflect.jvm.internal.impl.types.checker.l.f14250b.a(), new ma.a(kotlin.collections.r.e(kotlin.reflect.jvm.internal.impl.types.o.f14346a)));
    }

    public static final kotlin.reflect.jvm.internal.impl.load.java.lazy.f b(kotlin.reflect.jvm.internal.impl.load.java.p javaClassFinder, h0 module, ka.n storageManager, k0 notFoundClasses, q reflectKotlinClassFinder, i deserializedDescriptorResolver, kotlin.reflect.jvm.internal.impl.serialization.deserialization.q errorReporter, t9.b javaSourceElementFactory, kotlin.reflect.jvm.internal.impl.load.java.lazy.i singleModuleClassResolver, y packagePartProvider) {
        kotlin.jvm.internal.m.f(javaClassFinder, "javaClassFinder");
        kotlin.jvm.internal.m.f(module, "module");
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.m.f(reflectKotlinClassFinder, "reflectKotlinClassFinder");
        kotlin.jvm.internal.m.f(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        kotlin.jvm.internal.m.f(errorReporter, "errorReporter");
        kotlin.jvm.internal.m.f(javaSourceElementFactory, "javaSourceElementFactory");
        kotlin.jvm.internal.m.f(singleModuleClassResolver, "singleModuleClassResolver");
        kotlin.jvm.internal.m.f(packagePartProvider, "packagePartProvider");
        kotlin.reflect.jvm.internal.impl.load.java.components.j DO_NOTHING = kotlin.reflect.jvm.internal.impl.load.java.components.j.f13185a;
        kotlin.jvm.internal.m.e(DO_NOTHING, "DO_NOTHING");
        kotlin.reflect.jvm.internal.impl.load.java.components.g EMPTY = kotlin.reflect.jvm.internal.impl.load.java.components.g.f13180a;
        kotlin.jvm.internal.m.e(EMPTY, "EMPTY");
        kotlin.reflect.jvm.internal.impl.load.java.components.f.a aVar = kotlin.reflect.jvm.internal.impl.load.java.components.f.a.f13179a;
        ga.b bVar = new ga.b(storageManager, kotlin.collections.r.l());
        d1.a aVar2 = d1.a.f12742a;
        r9.c.a aVar3 = r9.c.a.f17875a;
        kotlin.reflect.jvm.internal.impl.builtins.j jVar = new kotlin.reflect.jvm.internal.impl.builtins.j(module, notFoundClasses);
        kotlin.reflect.jvm.internal.impl.load.java.x.b bVar2 = kotlin.reflect.jvm.internal.impl.load.java.x.f13496d;
        kotlin.reflect.jvm.internal.impl.load.java.d dVar = new kotlin.reflect.jvm.internal.impl.load.java.d(bVar2.a());
        kotlin.reflect.jvm.internal.impl.load.java.lazy.c.a aVar4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.c.a.f13268a;
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.f(new kotlin.reflect.jvm.internal.impl.load.java.lazy.b(storageManager, javaClassFinder, reflectKotlinClassFinder, deserializedDescriptorResolver, DO_NOTHING, errorReporter, EMPTY, aVar, bVar, javaSourceElementFactory, singleModuleClassResolver, packagePartProvider, aVar2, aVar3, module, jVar, dVar, new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.l(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d(aVar4)), kotlin.reflect.jvm.internal.impl.load.java.q.a.f13416a, aVar4, kotlin.reflect.jvm.internal.impl.types.checker.l.f14250b.a(), bVar2.a(), new a(), null, 8388608, null));
    }
}
