package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o0 f14221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o0 f14222c;

    public a(o0 delegate, o0 abbreviation) {
        kotlin.jvm.internal.m.f(delegate, "delegate");
        kotlin.jvm.internal.m.f(abbreviation, "abbreviation");
        this.f14221b = delegate;
        this.f14222c = abbreviation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: R0 */
    public o0 P0(c1 newAttributes) {
        kotlin.jvm.internal.m.f(newAttributes, "newAttributes");
        return new a(S0().P0(newAttributes), this.f14222c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.r
    protected o0 S0() {
        return this.f14221b;
    }

    public final o0 V0() {
        return this.f14222c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.o0
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public a N0(boolean z10) {
        return new a(S0().N0(z10), this.f14222c.N0(z10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.r
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public a T0(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        g0 g0VarA = kotlinTypeRefiner.a(S0());
        kotlin.jvm.internal.m.d(g0VarA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        g0 g0VarA2 = kotlinTypeRefiner.a(this.f14222c);
        kotlin.jvm.internal.m.d(g0VarA2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new a((o0) g0VarA, (o0) g0VarA2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.r
    /* JADX INFO: renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public a U0(o0 delegate) {
        kotlin.jvm.internal.m.f(delegate, "delegate");
        return new a(delegate, this.f14222c);
    }

    public final o0 R() {
        return S0();
    }
}
