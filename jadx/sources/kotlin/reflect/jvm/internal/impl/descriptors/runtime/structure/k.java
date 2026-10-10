package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class k extends z implements u9.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f13035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final z f13036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Collection<u9.a> f13037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f13038e;

    public k(Type reflectType) {
        z zVarA;
        kotlin.jvm.internal.m.f(reflectType, "reflectType");
        this.f13035b = reflectType;
        Type typeP = P();
        if (!(typeP instanceof GenericArrayType)) {
            if (typeP instanceof Class) {
                Class cls = (Class) typeP;
                if (cls.isArray()) {
                    z.a aVar = z.f13060a;
                    Class<?> componentType = cls.getComponentType();
                    kotlin.jvm.internal.m.e(componentType, "getComponentType()");
                    zVarA = aVar.a(componentType);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + P().getClass() + "): " + P());
        }
        z.a aVar2 = z.f13060a;
        Type genericComponentType = ((GenericArrayType) typeP).getGenericComponentType();
        kotlin.jvm.internal.m.e(genericComponentType, "genericComponentType");
        zVarA = aVar2.a(genericComponentType);
        this.f13036c = zVarA;
        this.f13037d = kotlin.collections.r.l();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z
    protected Type P() {
        return this.f13035b;
    }

    @Override // u9.f
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public z m() {
        return this.f13036c;
    }

    @Override // u9.d
    public Collection<u9.a> getAnnotations() {
        return this.f13037d;
    }

    @Override // u9.d
    public boolean l() {
        return this.f13038e;
    }
}
