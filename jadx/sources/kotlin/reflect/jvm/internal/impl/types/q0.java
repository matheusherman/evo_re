package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class q0 extends s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c1 f14363c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(o0 delegate, c1 attributes) {
        super(delegate);
        kotlin.jvm.internal.m.f(delegate, "delegate");
        kotlin.jvm.internal.m.f(attributes, "attributes");
        this.f14363c = attributes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.r, kotlin.reflect.jvm.internal.impl.types.g0
    public c1 I0() {
        return this.f14363c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.r
    /* JADX INFO: renamed from: V0, reason: merged with bridge method [inline-methods] */
    public q0 U0(o0 delegate) {
        kotlin.jvm.internal.m.f(delegate, "delegate");
        return new q0(delegate, I0());
    }
}
