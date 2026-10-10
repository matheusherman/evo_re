package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class x extends z implements u9.v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<?> f13056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Collection<u9.a> f13057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f13058d;

    public x(Class<?> reflectType) {
        kotlin.jvm.internal.m.f(reflectType, "reflectType");
        this.f13056b = reflectType;
        this.f13057c = kotlin.collections.r.l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public Class<?> P() {
        return this.f13056b;
    }

    @Override // u9.d
    public Collection<u9.a> getAnnotations() {
        return this.f13057c;
    }

    @Override // u9.d
    public boolean l() {
        return this.f13058d;
    }

    @Override // u9.v
    public kotlin.reflect.jvm.internal.impl.builtins.i getType() {
        if (kotlin.jvm.internal.m.a(P(), Void.TYPE)) {
            return null;
        }
        return fa.e.f(P().getName()).l();
    }
}
