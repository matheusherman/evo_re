package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c0 extends a0 implements t1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a0 f14229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final g0 f14230e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(a0 origin, g0 enhancement) {
        super(origin.R0(), origin.S0());
        kotlin.jvm.internal.m.f(origin, "origin");
        kotlin.jvm.internal.m.f(enhancement, "enhancement");
        this.f14229d = origin;
        this.f14230e = enhancement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t1
    public g0 C() {
        return this.f14230e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    public v1 P0(c1 newAttributes) {
        kotlin.jvm.internal.m.f(newAttributes, "newAttributes");
        return u1.d(B0().P0(newAttributes), C());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a0
    public String T0(kotlin.reflect.jvm.internal.impl.renderer.c renderer, kotlin.reflect.jvm.internal.impl.renderer.f options) {
        kotlin.jvm.internal.m.f(renderer, "renderer");
        kotlin.jvm.internal.m.f(options, "options");
        return options.f() ? renderer.w(C()) : B0().T0(renderer, options);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t1
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public a0 B0() {
        return this.f14229d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: V0, reason: merged with bridge method [inline-methods] */
    public c0 T0(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        g0 g0VarA = kotlinTypeRefiner.a(B0());
        kotlin.jvm.internal.m.d(g0VarA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return new c0((a0) g0VarA, kotlinTypeRefiner.a(C()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a0
    public String toString() {
        return "[@EnhancedForWarnings(" + C() + ")] " + B0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    public v1 N0(boolean z10) {
        return u1.d(B0().N0(z10), C().M0().N0(z10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.a0
    public o0 Q0() {
        return B0().Q0();
    }
}
