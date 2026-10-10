package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.reflect.jvm.internal.impl.types.a0;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.h0;
import kotlin.reflect.jvm.internal.impl.types.l0;
import kotlin.reflect.jvm.internal.impl.types.o0;
import kotlin.reflect.jvm.internal.impl.types.s1;
import kotlin.reflect.jvm.internal.impl.types.u1;
import kotlin.reflect.jvm.internal.impl.types.v1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class g extends kotlin.reflect.jvm.internal.impl.types.r implements l0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o0 f13445b;

    private final o0 V0(o0 o0Var) {
        o0 o0VarN0 = o0Var.N0(false);
        return !oa.a.t(o0Var) ? o0VarN0 : new g(o0VarN0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.r, kotlin.reflect.jvm.internal.impl.types.g0
    public boolean K0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n
    public boolean w0() {
        return true;
    }

    public g(o0 delegate) {
        kotlin.jvm.internal.m.f(delegate, "delegate");
        this.f13445b = delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.n
    public g0 G(g0 replacement) {
        kotlin.jvm.internal.m.f(replacement, "replacement");
        v1 v1VarM0 = replacement.M0();
        if (!oa.a.t(v1VarM0) && !s1.l(v1VarM0)) {
            return v1VarM0;
        }
        if (v1VarM0 instanceof o0) {
            return V0((o0) v1VarM0);
        }
        if (v1VarM0 instanceof a0) {
            a0 a0Var = (a0) v1VarM0;
            return u1.d(h0.d(V0(a0Var.R0()), V0(a0Var.S0())), u1.a(v1VarM0));
        }
        throw new IllegalStateException(("Incorrect type: " + v1VarM0).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.v1
    /* JADX INFO: renamed from: Q0 */
    public o0 N0(boolean z10) {
        return z10 ? S0().N0(true) : this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.r
    protected o0 S0() {
        return this.f13445b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.o0
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public g P0(c1 newAttributes) {
        kotlin.jvm.internal.m.f(newAttributes, "newAttributes");
        return new g(S0().P0(newAttributes));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.r
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public g U0(o0 delegate) {
        kotlin.jvm.internal.m.f(delegate, "delegate");
        return new g(delegate);
    }
}
