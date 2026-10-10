package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class a0 extends v1 implements na.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o0 f14223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o0 f14224c;

    public abstract o0 Q0();

    public abstract String T0(kotlin.reflect.jvm.internal.impl.renderer.c cVar, kotlin.reflect.jvm.internal.impl.renderer.f fVar);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(o0 lowerBound, o0 upperBound) {
        super(null);
        kotlin.jvm.internal.m.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.m.f(upperBound, "upperBound");
        this.f14223b = lowerBound;
        this.f14224c = upperBound;
    }

    public final o0 R0() {
        return this.f14223b;
    }

    public final o0 S0() {
        return this.f14224c;
    }

    public String toString() {
        return kotlin.reflect.jvm.internal.impl.renderer.c.f13793j.w(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public List<k1> H0() {
        return Q0().H0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public c1 I0() {
        return Q0().I0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public g1 J0() {
        return Q0().J0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public boolean K0() {
        return Q0().K0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g0
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h n() {
        return Q0().n();
    }
}
