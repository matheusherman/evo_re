package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class x1 extends g0 {
    public x1() {
        super(null);
    }

    protected abstract g0 N0();

    public abstract boolean O0();

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public List<k1> H0() {
        return N0().H0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public c1 I0() {
        return N0().I0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public g1 J0() {
        return N0().J0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public boolean K0() {
        return N0().K0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public final v1 M0() {
        g0 g0VarN0 = N0();
        while (g0VarN0 instanceof x1) {
            g0VarN0 = ((x1) g0VarN0).N0();
        }
        kotlin.jvm.internal.m.d(g0VarN0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
        return (v1) g0VarN0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h n() {
        return N0().n();
    }

    public String toString() {
        if (O0()) {
            return N0().toString();
        }
        return "<Not computed yet>";
    }
}
