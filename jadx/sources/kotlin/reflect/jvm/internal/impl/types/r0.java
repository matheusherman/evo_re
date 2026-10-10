package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class r0 extends r implements t1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o0 f14364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g0 f14365c;

    public r0(o0 delegate, g0 enhancement) {
        kotlin.jvm.internal.m.f(delegate, "delegate");
        kotlin.jvm.internal.m.f(enhancement, "enhancement");
        this.f14364b = delegate;
        this.f14365c = enhancement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t1
    public g0 C() {
        return this.f14365c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: R0 */
    public o0 P0(c1 newAttributes) {
        kotlin.jvm.internal.m.f(newAttributes, "newAttributes");
        v1 v1VarD = u1.d(B0().P0(newAttributes), C());
        kotlin.jvm.internal.m.d(v1VarD, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (o0) v1VarD;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.r
    protected o0 S0() {
        return this.f14364b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.r
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public r0 T0(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        g0 g0VarA = kotlinTypeRefiner.a(S0());
        kotlin.jvm.internal.m.d(g0VarA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new r0((o0) g0VarA, kotlinTypeRefiner.a(C()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.r
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public r0 U0(o0 delegate) {
        kotlin.jvm.internal.m.f(delegate, "delegate");
        return new r0(delegate, C());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.o0
    public String toString() {
        return "[@EnhancedForWarnings(" + C() + ")] " + B0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: Q0 */
    public o0 N0(boolean z10) {
        v1 v1VarD = u1.d(B0().N0(z10), C().M0().N0(z10));
        kotlin.jvm.internal.m.d(v1VarD, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (o0) v1VarD;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t1
    /* JADX INFO: renamed from: V0, reason: merged with bridge method [inline-methods] */
    public o0 B0() {
        return S0();
    }
}
