package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.m0;
import kotlin.reflect.jvm.internal.impl.types.b1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ka.n f14149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h0 f14150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l f14151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h f14152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> f14153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final m0 f14154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final u f14155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final q f14156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final r9.c f14157i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final r f14158j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Iterable<n9.b> f14159k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final k0 f14160l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final j f14161m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final n9.a f14162n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final n9.c f14163o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.g f14164p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.l f14165q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final ga.a f14166r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final n9.e f14167s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final List<b1> f14168t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final i f14169u;

    /* JADX WARN: Multi-variable type inference failed */
    public k(ka.n storageManager, h0 moduleDescriptor, l configuration, h classDataFinder, c<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> annotationAndConstantLoader, m0 packageFragmentProvider, u localClassifierTypeSettings, q errorReporter, r9.c lookupTracker, r flexibleTypeDeserializer, Iterable<? extends n9.b> fictitiousClassDescriptorFactories, k0 notFoundClasses, j contractDeserializer, n9.a additionalClassPartsProvider, n9.c platformDependentDeclarationFilter, kotlin.reflect.jvm.internal.impl.protobuf.g extensionRegistryLite, kotlin.reflect.jvm.internal.impl.types.checker.l kotlinTypeChecker, ga.a samConversionResolver, n9.e platformDependentTypeTransformer, List<? extends b1> typeAttributeTranslators) {
        kotlin.jvm.internal.m.f(storageManager, "storageManager");
        kotlin.jvm.internal.m.f(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.m.f(configuration, "configuration");
        kotlin.jvm.internal.m.f(classDataFinder, "classDataFinder");
        kotlin.jvm.internal.m.f(annotationAndConstantLoader, "annotationAndConstantLoader");
        kotlin.jvm.internal.m.f(packageFragmentProvider, "packageFragmentProvider");
        kotlin.jvm.internal.m.f(localClassifierTypeSettings, "localClassifierTypeSettings");
        kotlin.jvm.internal.m.f(errorReporter, "errorReporter");
        kotlin.jvm.internal.m.f(lookupTracker, "lookupTracker");
        kotlin.jvm.internal.m.f(flexibleTypeDeserializer, "flexibleTypeDeserializer");
        kotlin.jvm.internal.m.f(fictitiousClassDescriptorFactories, "fictitiousClassDescriptorFactories");
        kotlin.jvm.internal.m.f(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.m.f(contractDeserializer, "contractDeserializer");
        kotlin.jvm.internal.m.f(additionalClassPartsProvider, "additionalClassPartsProvider");
        kotlin.jvm.internal.m.f(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        kotlin.jvm.internal.m.f(extensionRegistryLite, "extensionRegistryLite");
        kotlin.jvm.internal.m.f(kotlinTypeChecker, "kotlinTypeChecker");
        kotlin.jvm.internal.m.f(samConversionResolver, "samConversionResolver");
        kotlin.jvm.internal.m.f(platformDependentTypeTransformer, "platformDependentTypeTransformer");
        kotlin.jvm.internal.m.f(typeAttributeTranslators, "typeAttributeTranslators");
        this.f14149a = storageManager;
        this.f14150b = moduleDescriptor;
        this.f14151c = configuration;
        this.f14152d = classDataFinder;
        this.f14153e = annotationAndConstantLoader;
        this.f14154f = packageFragmentProvider;
        this.f14155g = localClassifierTypeSettings;
        this.f14156h = errorReporter;
        this.f14157i = lookupTracker;
        this.f14158j = flexibleTypeDeserializer;
        this.f14159k = fictitiousClassDescriptorFactories;
        this.f14160l = notFoundClasses;
        this.f14161m = contractDeserializer;
        this.f14162n = additionalClassPartsProvider;
        this.f14163o = platformDependentDeclarationFilter;
        this.f14164p = extensionRegistryLite;
        this.f14165q = kotlinTypeChecker;
        this.f14166r = samConversionResolver;
        this.f14167s = platformDependentTypeTransformer;
        this.f14168t = typeAttributeTranslators;
        this.f14169u = new i(this);
    }

    public final m a(l0 descriptor, y9.c nameResolver, y9.g typeTable, y9.h versionRequirementTable, y9.a metadataVersion, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f fVar) {
        kotlin.jvm.internal.m.f(descriptor, "descriptor");
        kotlin.jvm.internal.m.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.m.f(typeTable, "typeTable");
        kotlin.jvm.internal.m.f(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.m.f(metadataVersion, "metadataVersion");
        return new m(this, nameResolver, descriptor, typeTable, versionRequirementTable, metadataVersion, fVar, null, kotlin.collections.r.l());
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.e b(ba.b classId) {
        kotlin.jvm.internal.m.f(classId, "classId");
        return i.e(this.f14169u, classId, null, 2, null);
    }

    public final n9.a c() {
        return this.f14162n;
    }

    public final c<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> d() {
        return this.f14153e;
    }

    public final h e() {
        return this.f14152d;
    }

    public final i f() {
        return this.f14169u;
    }

    public final l g() {
        return this.f14151c;
    }

    public final j h() {
        return this.f14161m;
    }

    public final q i() {
        return this.f14156h;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.g j() {
        return this.f14164p;
    }

    public final Iterable<n9.b> k() {
        return this.f14159k;
    }

    public final r l() {
        return this.f14158j;
    }

    public final kotlin.reflect.jvm.internal.impl.types.checker.l m() {
        return this.f14165q;
    }

    public final u n() {
        return this.f14155g;
    }

    public final r9.c o() {
        return this.f14157i;
    }

    public final h0 p() {
        return this.f14150b;
    }

    public final k0 q() {
        return this.f14160l;
    }

    public final m0 r() {
        return this.f14154f;
    }

    public final n9.c s() {
        return this.f14163o;
    }

    public final n9.e t() {
        return this.f14167s;
    }

    public final ka.n u() {
        return this.f14149a;
    }

    public final List<b1> v() {
        return this.f14168t;
    }

    public /* synthetic */ k(ka.n nVar, h0 h0Var, l lVar, h hVar, c cVar, m0 m0Var, u uVar, q qVar, r9.c cVar2, r rVar, Iterable iterable, k0 k0Var, j jVar, n9.a aVar, n9.c cVar3, kotlin.reflect.jvm.internal.impl.protobuf.g gVar, kotlin.reflect.jvm.internal.impl.types.checker.l lVar2, ga.a aVar2, n9.e eVar, List list, int i10, kotlin.jvm.internal.g gVar2) {
        this(nVar, h0Var, lVar, hVar, cVar, m0Var, uVar, qVar, cVar2, rVar, iterable, k0Var, jVar, (i10 & 8192) != 0 ? n9.a.C0311a.f16095a : aVar, (i10 & 16384) != 0 ? n9.c.a.f16096a : cVar3, gVar, (65536 & i10) != 0 ? kotlin.reflect.jvm.internal.impl.types.checker.l.f14250b.a() : lVar2, aVar2, (262144 & i10) != 0 ? n9.e.a.f16099a : eVar, (i10 & 524288) != 0 ? kotlin.collections.r.e(kotlin.reflect.jvm.internal.impl.types.o.f14346a) : list);
    }
}
