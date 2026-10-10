package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f13577b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.k f13578a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class C0241a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final g f13579a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final i f13580b;

            public C0241a(g deserializationComponentsForJava, i deserializedDescriptorResolver) {
                kotlin.jvm.internal.m.f(deserializationComponentsForJava, "deserializationComponentsForJava");
                kotlin.jvm.internal.m.f(deserializedDescriptorResolver, "deserializedDescriptorResolver");
                this.f13579a = deserializationComponentsForJava;
                this.f13580b = deserializedDescriptorResolver;
            }

            public final g a() {
                return this.f13579a;
            }

            public final i b() {
                return this.f13580b;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final C0241a a(q kotlinClassFinder, q jvmBuiltInsKotlinClassFinder, kotlin.reflect.jvm.internal.impl.load.java.p javaClassFinder, String moduleName, kotlin.reflect.jvm.internal.impl.serialization.deserialization.q errorReporter, t9.b javaSourceElementFactory) {
            kotlin.jvm.internal.m.f(kotlinClassFinder, "kotlinClassFinder");
            kotlin.jvm.internal.m.f(jvmBuiltInsKotlinClassFinder, "jvmBuiltInsKotlinClassFinder");
            kotlin.jvm.internal.m.f(javaClassFinder, "javaClassFinder");
            kotlin.jvm.internal.m.f(moduleName, "moduleName");
            kotlin.jvm.internal.m.f(errorReporter, "errorReporter");
            kotlin.jvm.internal.m.f(javaSourceElementFactory, "javaSourceElementFactory");
            ka.f fVar = new ka.f("DeserializationComponentsForJava.ModuleData");
            kotlin.reflect.jvm.internal.impl.builtins.jvm.f fVar2 = new kotlin.reflect.jvm.internal.impl.builtins.jvm.f(fVar, kotlin.reflect.jvm.internal.impl.builtins.jvm.f.a.FROM_DEPENDENCIES);
            ba.f fVarO = ba.f.o('<' + moduleName + '>');
            kotlin.jvm.internal.m.e(fVarO, "special(\"<$moduleName>\")");
            kotlin.reflect.jvm.internal.impl.descriptors.impl.x xVar = new kotlin.reflect.jvm.internal.impl.descriptors.impl.x(fVarO, fVar, fVar2, null, null, null, 56, null);
            fVar2.E0(xVar);
            fVar2.J0(xVar, true);
            i iVar = new i();
            kotlin.reflect.jvm.internal.impl.load.java.lazy.j jVar = new kotlin.reflect.jvm.internal.impl.load.java.lazy.j();
            k0 k0Var = new k0(fVar, xVar);
            kotlin.reflect.jvm.internal.impl.load.java.lazy.f fVarB = h.b(javaClassFinder, xVar, fVar, k0Var, kotlinClassFinder, iVar, errorReporter, javaSourceElementFactory, jVar, (512 & 512) != 0 ? y.a.f13622a : null);
            g gVarA = h.a(xVar, fVar, k0Var, fVarB, kotlinClassFinder, iVar, errorReporter, aa.e.f177i);
            iVar.m(gVarA);
            kotlin.reflect.jvm.internal.impl.load.java.components.g EMPTY = kotlin.reflect.jvm.internal.impl.load.java.components.g.f13180a;
            kotlin.jvm.internal.m.e(EMPTY, "EMPTY");
            fa.c cVar = new fa.c(fVarB, EMPTY);
            jVar.c(cVar);
            kotlin.reflect.jvm.internal.impl.builtins.jvm.j jVar2 = new kotlin.reflect.jvm.internal.impl.builtins.jvm.j(fVar, jvmBuiltInsKotlinClassFinder, xVar, k0Var, fVar2.I0(), fVar2.I0(), kotlin.reflect.jvm.internal.impl.serialization.deserialization.l.a.f14170a, kotlin.reflect.jvm.internal.impl.types.checker.l.f14250b.a(), new ga.b(fVar, kotlin.collections.r.l()));
            xVar.U0(xVar);
            xVar.O0(new kotlin.reflect.jvm.internal.impl.descriptors.impl.i(kotlin.collections.r.o(cVar.a(), jVar2), "CompositeProvider@RuntimeModuleData for " + xVar));
            return new C0241a(gVarA, iVar);
        }
    }

    public g(ka.n storageManager, h0 moduleDescriptor, kotlin.reflect.jvm.internal.impl.serialization.deserialization.l configuration, j classDataFinder, d annotationAndConstantLoader, kotlin.reflect.jvm.internal.impl.load.java.lazy.f packageFragmentProvider, k0 notFoundClasses, kotlin.reflect.jvm.internal.impl.serialization.deserialization.q errorReporter, r9.c lookupTracker, kotlin.reflect.jvm.internal.impl.serialization.deserialization.j contractDeserializer, kotlin.reflect.jvm.internal.impl.types.checker.l kotlinTypeChecker, ma.a typeAttributeTranslators) {
        n9.c cVarI0;
        n9.a aVarI0;
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.m.f(configuration, "configuration");
        kotlin.jvm.internal.m.f(classDataFinder, "classDataFinder");
        kotlin.jvm.internal.m.f(annotationAndConstantLoader, "annotationAndConstantLoader");
        kotlin.jvm.internal.m.f(packageFragmentProvider, "packageFragmentProvider");
        kotlin.jvm.internal.m.f(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.m.f(errorReporter, "errorReporter");
        kotlin.jvm.internal.m.f(lookupTracker, "lookupTracker");
        kotlin.jvm.internal.m.f(contractDeserializer, "contractDeserializer");
        kotlin.jvm.internal.m.f(kotlinTypeChecker, "kotlinTypeChecker");
        kotlin.jvm.internal.m.f(typeAttributeTranslators, "typeAttributeTranslators");
        kotlin.reflect.jvm.internal.impl.builtins.h hVarL = moduleDescriptor.l();
        kotlin.reflect.jvm.internal.impl.builtins.jvm.f fVar = hVarL instanceof kotlin.reflect.jvm.internal.impl.builtins.jvm.f ? (kotlin.reflect.jvm.internal.impl.builtins.jvm.f) hVarL : null;
        this.f13578a = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.k(storageManager, moduleDescriptor, configuration, classDataFinder, annotationAndConstantLoader, packageFragmentProvider, kotlin.reflect.jvm.internal.impl.serialization.deserialization.u.a.f14196a, errorReporter, lookupTracker, k.f13591a, kotlin.collections.r.l(), notFoundClasses, contractDeserializer, (fVar == null || (aVarI0 = fVar.I0()) == null) ? n9.a.C0311a.f16095a : aVarI0, (fVar == null || (cVarI0 = fVar.I0()) == null) ? n9.c.b.f16097a : cVarI0, aa.i.f190a.a(), kotlinTypeChecker, new ga.b(storageManager, kotlin.collections.r.l()), null, typeAttributeTranslators.a(), 262144, null);
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.k a() {
        return this.f13578a;
    }
}
