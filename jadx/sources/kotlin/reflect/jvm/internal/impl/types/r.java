package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class r extends o0 {
    protected abstract o0 S0();

    public abstract r U0(o0 o0Var);

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    public o0 T0(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.m.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        g0 g0VarA = kotlinTypeRefiner.a(S0());
        kotlin.jvm.internal.m.d(g0VarA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return U0((o0) g0VarA);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public List<k1> H0() {
        return S0().H0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public c1 I0() {
        return S0().I0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public g1 J0() {
        return S0().J0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public boolean K0() {
        return S0().K0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h n() {
        return S0().n();
    }
}
