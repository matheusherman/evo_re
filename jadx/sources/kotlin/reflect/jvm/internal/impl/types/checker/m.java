package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.f1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.v1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class m implements l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f14253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f14254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.k f14255e;

    public m(g kotlinTypeRefiner, f kotlinTypePreparator) {
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        kotlin.jvm.internal.m.f(kotlinTypePreparator, "kotlinTypePreparator");
        this.f14253c = kotlinTypeRefiner;
        this.f14254d = kotlinTypePreparator;
        kotlin.reflect.jvm.internal.impl.resolve.k kVarM = kotlin.reflect.jvm.internal.impl.resolve.k.m(c());
        kotlin.jvm.internal.m.e(kVarM, "createWithTypeRefiner(kotlinTypeRefiner)");
        this.f14255e = kVarM;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.l
    public kotlin.reflect.jvm.internal.impl.resolve.k a() {
        return this.f14255e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.e
    public boolean b(g0 a10, g0 b10) {
        kotlin.jvm.internal.m.f(a10, "a");
        kotlin.jvm.internal.m.f(b10, "b");
        return e(a.b(false, false, null, f(), c(), 6, null), a10.M0(), b10.M0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.l
    public g c() {
        return this.f14253c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.e
    public boolean d(g0 subtype, g0 supertype) {
        kotlin.jvm.internal.m.f(subtype, "subtype");
        kotlin.jvm.internal.m.f(supertype, "supertype");
        return g(a.b(true, false, null, f(), c(), 6, null), subtype.M0(), supertype.M0());
    }

    public final boolean e(f1 f1Var, v1 a10, v1 b10) {
        kotlin.jvm.internal.m.f(f1Var, "<this>");
        kotlin.jvm.internal.m.f(a10, "a");
        kotlin.jvm.internal.m.f(b10, "b");
        return kotlin.reflect.jvm.internal.impl.types.f.f14277a.k(f1Var, a10, b10);
    }

    public f f() {
        return this.f14254d;
    }

    public final boolean g(f1 f1Var, v1 subType, v1 superType) {
        kotlin.jvm.internal.m.f(f1Var, "<this>");
        kotlin.jvm.internal.m.f(subType, "subType");
        kotlin.jvm.internal.m.f(superType, "superType");
        return kotlin.reflect.jvm.internal.impl.types.f.t(kotlin.reflect.jvm.internal.impl.types.f.f14277a, f1Var, subType, superType, false, 8, null);
    }

    public /* synthetic */ m(g gVar, f fVar, int i10, kotlin.jvm.internal.g gVar2) {
        this(gVar, (i10 & 2) != 0 ? f.a.f14236a : fVar);
    }
}
