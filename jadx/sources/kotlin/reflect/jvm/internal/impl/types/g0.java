package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class g0 implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.a, na.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14312a;

    public /* synthetic */ g0(kotlin.jvm.internal.g gVar) {
        this();
    }

    public abstract List<k1> H0();

    public abstract c1 I0();

    public abstract g1 J0();

    public abstract boolean K0();

    /* JADX INFO: renamed from: L0 */
    public abstract g0 O0(kotlin.reflect.jvm.internal.impl.types.checker.g gVar);

    public abstract v1 M0();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return K0() == g0Var.K0() && kotlin.reflect.jvm.internal.impl.types.checker.r.f14259a.a(M0(), g0Var.M0());
    }

    public abstract kotlin.reflect.jvm.internal.impl.resolve.scopes.h n();

    private g0() {
    }

    public final int hashCode() {
        int i10 = this.f14312a;
        if (i10 != 0) {
            return i10;
        }
        int iG0 = G0();
        this.f14312a = iG0;
        return iG0;
    }

    private final int G0() {
        if (i0.a(this)) {
            return super.hashCode();
        }
        return (((J0().hashCode() * 31) + H0().hashCode()) * 31) + (K0() ? 1 : 0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        return k.a(I0());
    }
}
