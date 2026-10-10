package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c0 extends z implements u9.c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WildcardType f13021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Collection<u9.a> f13022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f13023d;

    public c0(WildcardType reflectType) {
        kotlin.jvm.internal.m.f(reflectType, "reflectType");
        this.f13021b = reflectType;
        this.f13022c = kotlin.collections.r.l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public WildcardType P() {
        return this.f13021b;
    }

    @Override // u9.d
    public Collection<u9.a> getAnnotations() {
        return this.f13022c;
    }

    @Override // u9.d
    public boolean l() {
        return this.f13023d;
    }

    @Override // u9.c0
    public boolean H() {
        Type[] upperBounds = P().getUpperBounds();
        kotlin.jvm.internal.m.e(upperBounds, "reflectType.upperBounds");
        return !kotlin.jvm.internal.m.a(kotlin.collections.j.P(upperBounds), Object.class);
    }

    @Override // u9.c0
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public z z() {
        Type[] upperBounds = P().getUpperBounds();
        Type[] lowerBounds = P().getLowerBounds();
        if (upperBounds.length <= 1 && lowerBounds.length <= 1) {
            if (lowerBounds.length == 1) {
                z.a aVar = z.f13060a;
                kotlin.jvm.internal.m.e(lowerBounds, "lowerBounds");
                Object objN0 = kotlin.collections.j.n0(lowerBounds);
                kotlin.jvm.internal.m.e(objN0, "lowerBounds.single()");
                return aVar.a((Type) objN0);
            }
            if (upperBounds.length == 1) {
                kotlin.jvm.internal.m.e(upperBounds, "upperBounds");
                Type ub2 = (Type) kotlin.collections.j.n0(upperBounds);
                if (!kotlin.jvm.internal.m.a(ub2, Object.class)) {
                    z.a aVar2 = z.f13060a;
                    kotlin.jvm.internal.m.e(ub2, "ub");
                    return aVar2.a(ub2);
                }
            }
            return null;
        }
        throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + P());
    }
}
