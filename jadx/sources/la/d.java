package la;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.r;
import kotlin.collections.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f15260a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ba.f f15261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<h0> f15262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<h0> f15263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set<h0> f15264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.builtins.h f15265f;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public m b() {
        return null;
    }

    static {
        ba.f fVarO = ba.f.o(b.ERROR_MODULE.f());
        kotlin.jvm.internal.m.e(fVarO, "special(ErrorEntity.ERROR_MODULE.debugText)");
        f15261b = fVarO;
        f15262c = r.l();
        f15263d = r.l();
        f15264e = v0.e();
        f15265f = kotlin.reflect.jvm.internal.impl.builtins.e.f12460h.a();
    }

    public ba.f C() {
        return f15261b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    public <T> T D0(g0<T> capability) {
        kotlin.jvm.internal.m.f(capability, "capability");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R H(o<R, D> visitor, D d10) {
        kotlin.jvm.internal.m.f(visitor, "visitor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    public q0 U(ba.c fqName) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        throw new IllegalStateException("Should not be called!");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    public boolean a0(h0 targetModule) {
        kotlin.jvm.internal.m.f(targetModule, "targetModule");
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f12688i0.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    public kotlin.reflect.jvm.internal.impl.builtins.h l() {
        return f15265f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    public Collection<ba.c> m(ba.c fqName, c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        return r.l();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    public List<h0> p0() {
        return f15263d;
    }

    private d() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j0
    public ba.f getName() {
        return C();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public m a() {
        return this;
    }
}
