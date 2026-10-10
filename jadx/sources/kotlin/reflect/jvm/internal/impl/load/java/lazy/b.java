package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import ka.n;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.load.java.p;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.l;
import kotlin.reflect.jvm.internal.impl.load.java.u;
import kotlin.reflect.jvm.internal.impl.load.java.x;
import kotlin.reflect.jvm.internal.impl.load.kotlin.q;
import kotlin.reflect.jvm.internal.impl.load.kotlin.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f13244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p f13245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q f13246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.kotlin.i f13247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.components.j f13248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.q f13249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.components.g f13250g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.components.f f13251h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ga.a f13252i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final t9.b f13253j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final i f13254k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final y f13255l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final d1 f13256m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final r9.c f13257n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final h0 f13258o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.builtins.j f13259p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.d f13260q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final l f13261r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.q f13262s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final c f13263t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.l f13264u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final x f13265v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final u f13266w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final fa.f f13267x;

    public b(n storageManager, p finder, q kotlinClassFinder, kotlin.reflect.jvm.internal.impl.load.kotlin.i deserializedDescriptorResolver, kotlin.reflect.jvm.internal.impl.load.java.components.j signaturePropagator, kotlin.reflect.jvm.internal.impl.serialization.deserialization.q errorReporter, kotlin.reflect.jvm.internal.impl.load.java.components.g javaResolverCache, kotlin.reflect.jvm.internal.impl.load.java.components.f javaPropertyInitializerEvaluator, ga.a samConversionResolver, t9.b sourceElementFactory, i moduleClassResolver, y packagePartProvider, d1 supertypeLoopChecker, r9.c lookupTracker, h0 module, kotlin.reflect.jvm.internal.impl.builtins.j reflectionTypes, kotlin.reflect.jvm.internal.impl.load.java.d annotationTypeQualifierResolver, l signatureEnhancement, kotlin.reflect.jvm.internal.impl.load.java.q javaClassesTracker, c settings, kotlin.reflect.jvm.internal.impl.types.checker.l kotlinTypeChecker, x javaTypeEnhancementState, u javaModuleResolver, fa.f syntheticPartsProvider) {
        m.f(storageManager, "storageManager");
        m.f(finder, "finder");
        m.f(kotlinClassFinder, "kotlinClassFinder");
        m.f(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        m.f(signaturePropagator, "signaturePropagator");
        m.f(errorReporter, "errorReporter");
        m.f(javaResolverCache, "javaResolverCache");
        m.f(javaPropertyInitializerEvaluator, "javaPropertyInitializerEvaluator");
        m.f(samConversionResolver, "samConversionResolver");
        m.f(sourceElementFactory, "sourceElementFactory");
        m.f(moduleClassResolver, "moduleClassResolver");
        m.f(packagePartProvider, "packagePartProvider");
        m.f(supertypeLoopChecker, "supertypeLoopChecker");
        m.f(lookupTracker, "lookupTracker");
        m.f(module, "module");
        m.f(reflectionTypes, "reflectionTypes");
        m.f(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        m.f(signatureEnhancement, "signatureEnhancement");
        m.f(javaClassesTracker, "javaClassesTracker");
        m.f(settings, "settings");
        m.f(kotlinTypeChecker, "kotlinTypeChecker");
        m.f(javaTypeEnhancementState, "javaTypeEnhancementState");
        m.f(javaModuleResolver, "javaModuleResolver");
        m.f(syntheticPartsProvider, "syntheticPartsProvider");
        this.f13244a = storageManager;
        this.f13245b = finder;
        this.f13246c = kotlinClassFinder;
        this.f13247d = deserializedDescriptorResolver;
        this.f13248e = signaturePropagator;
        this.f13249f = errorReporter;
        this.f13250g = javaResolverCache;
        this.f13251h = javaPropertyInitializerEvaluator;
        this.f13252i = samConversionResolver;
        this.f13253j = sourceElementFactory;
        this.f13254k = moduleClassResolver;
        this.f13255l = packagePartProvider;
        this.f13256m = supertypeLoopChecker;
        this.f13257n = lookupTracker;
        this.f13258o = module;
        this.f13259p = reflectionTypes;
        this.f13260q = annotationTypeQualifierResolver;
        this.f13261r = signatureEnhancement;
        this.f13262s = javaClassesTracker;
        this.f13263t = settings;
        this.f13264u = kotlinTypeChecker;
        this.f13265v = javaTypeEnhancementState;
        this.f13266w = javaModuleResolver;
        this.f13267x = syntheticPartsProvider;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.d a() {
        return this.f13260q;
    }

    public final kotlin.reflect.jvm.internal.impl.load.kotlin.i b() {
        return this.f13247d;
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.q c() {
        return this.f13249f;
    }

    public final p d() {
        return this.f13245b;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.q e() {
        return this.f13262s;
    }

    public final u f() {
        return this.f13266w;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.components.f g() {
        return this.f13251h;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.components.g h() {
        return this.f13250g;
    }

    public final x i() {
        return this.f13265v;
    }

    public final q j() {
        return this.f13246c;
    }

    public final kotlin.reflect.jvm.internal.impl.types.checker.l k() {
        return this.f13264u;
    }

    public final r9.c l() {
        return this.f13257n;
    }

    public final h0 m() {
        return this.f13258o;
    }

    public final i n() {
        return this.f13254k;
    }

    public final y o() {
        return this.f13255l;
    }

    public final kotlin.reflect.jvm.internal.impl.builtins.j p() {
        return this.f13259p;
    }

    public final c q() {
        return this.f13263t;
    }

    public final l r() {
        return this.f13261r;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.components.j s() {
        return this.f13248e;
    }

    public final t9.b t() {
        return this.f13253j;
    }

    public final n u() {
        return this.f13244a;
    }

    public final d1 v() {
        return this.f13256m;
    }

    public final fa.f w() {
        return this.f13267x;
    }

    public final b x(kotlin.reflect.jvm.internal.impl.load.java.components.g javaResolverCache) {
        m.f(javaResolverCache, "javaResolverCache");
        return new b(this.f13244a, this.f13245b, this.f13246c, this.f13247d, this.f13248e, this.f13249f, javaResolverCache, this.f13251h, this.f13252i, this.f13253j, this.f13254k, this.f13255l, this.f13256m, this.f13257n, this.f13258o, this.f13259p, this.f13260q, this.f13261r, this.f13262s, this.f13263t, this.f13264u, this.f13265v, this.f13266w, null, 8388608, null);
    }

    public /* synthetic */ b(n nVar, p pVar, q qVar, kotlin.reflect.jvm.internal.impl.load.kotlin.i iVar, kotlin.reflect.jvm.internal.impl.load.java.components.j jVar, kotlin.reflect.jvm.internal.impl.serialization.deserialization.q qVar2, kotlin.reflect.jvm.internal.impl.load.java.components.g gVar, kotlin.reflect.jvm.internal.impl.load.java.components.f fVar, ga.a aVar, t9.b bVar, i iVar2, y yVar, d1 d1Var, r9.c cVar, h0 h0Var, kotlin.reflect.jvm.internal.impl.builtins.j jVar2, kotlin.reflect.jvm.internal.impl.load.java.d dVar, l lVar, kotlin.reflect.jvm.internal.impl.load.java.q qVar3, c cVar2, kotlin.reflect.jvm.internal.impl.types.checker.l lVar2, x xVar, u uVar, fa.f fVar2, int i10, kotlin.jvm.internal.g gVar2) {
        this(nVar, pVar, qVar, iVar, jVar, qVar2, gVar, fVar, aVar, bVar, iVar2, yVar, d1Var, cVar, h0Var, jVar2, dVar, lVar, qVar3, cVar2, lVar2, xVar, uVar, (i10 & 8388608) != 0 ? fa.f.f10101a.a() : fVar2);
    }
}
