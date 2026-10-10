package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class o implements b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f14346a = new o();

    @Override // kotlin.reflect.jvm.internal.impl.types.b1
    public c1 a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, g1 g1Var, kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        kotlin.jvm.internal.m.f(annotations, "annotations");
        return annotations.isEmpty() ? c1.f14231b.h() : c1.f14231b.g(kotlin.collections.r.e(new j(annotations)));
    }

    private o() {
    }
}
