package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class p0 extends o0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g1 f14350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<k1> f14351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f14352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.h f14353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c9.l<kotlin.reflect.jvm.internal.impl.types.checker.g, o0> f14354f;

    /* JADX WARN: Multi-variable type inference failed */
    public p0(g1 constructor, List<? extends k1> arguments, boolean z10, kotlin.reflect.jvm.internal.impl.resolve.scopes.h memberScope, c9.l<? super kotlin.reflect.jvm.internal.impl.types.checker.g, ? extends o0> refinedTypeFactory) {
        kotlin.jvm.internal.m.f(constructor, "constructor");
        kotlin.jvm.internal.m.f(arguments, "arguments");
        kotlin.jvm.internal.m.f(memberScope, "memberScope");
        kotlin.jvm.internal.m.f(refinedTypeFactory, "refinedTypeFactory");
        this.f14350b = constructor;
        this.f14351c = arguments;
        this.f14352d = z10;
        this.f14353e = memberScope;
        this.f14354f = refinedTypeFactory;
        if (!(n() instanceof la.f) || (n() instanceof la.l)) {
            return;
        }
        throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + n() + '\n' + J0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public List<k1> H0() {
        return this.f14351c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public c1 I0() {
        return c1.f14231b.h();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public g1 J0() {
        return this.f14350b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public boolean K0() {
        return this.f14352d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: R0 */
    public o0 P0(c1 newAttributes) {
        kotlin.jvm.internal.m.f(newAttributes, "newAttributes");
        return newAttributes.isEmpty() ? this : new q0(this, newAttributes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: S0, reason: merged with bridge method [inline-methods] */
    public o0 T0(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        o0 o0VarInvoke = this.f14354f.invoke(kotlinTypeRefiner);
        return o0VarInvoke == null ? this : o0VarInvoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h n() {
        return this.f14353e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: Q0 */
    public o0 N0(boolean z10) {
        if (z10 == K0()) {
            return this;
        }
        if (z10) {
            return new m0(this);
        }
        return new k0(this);
    }
}
