package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class q extends n1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n1 f14362c;

    public q(n1 substitution) {
        kotlin.jvm.internal.m.f(substitution, "substitution");
        this.f14362c = substitution;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n1
    public boolean a() {
        return this.f14362c.a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n1
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g d(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations) {
        kotlin.jvm.internal.m.f(annotations, "annotations");
        return this.f14362c.d(annotations);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n1
    public k1 e(g0 key) {
        kotlin.jvm.internal.m.f(key, "key");
        return this.f14362c.e(key);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n1
    public boolean f() {
        return this.f14362c.f();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n1
    public g0 g(g0 topLevelType, w1 position) {
        kotlin.jvm.internal.m.f(topLevelType, "topLevelType");
        kotlin.jvm.internal.m.f(position, "position");
        return this.f14362c.g(topLevelType, position);
    }
}
