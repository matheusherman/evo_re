package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class n extends z implements u9.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f13048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u9.i f13049c;

    @Override // u9.d
    public boolean l() {
        return false;
    }

    public n(Type reflectType) {
        u9.i lVar;
        kotlin.jvm.internal.m.f(reflectType, "reflectType");
        this.f13048b = reflectType;
        Type typeP = P();
        if (typeP instanceof Class) {
            lVar = new l((Class) typeP);
        } else if (typeP instanceof TypeVariable) {
            lVar = new a0((TypeVariable) typeP);
        } else {
            if (!(typeP instanceof ParameterizedType)) {
                throw new IllegalStateException("Not a classifier type (" + typeP.getClass() + "): " + typeP);
            }
            Type rawType = ((ParameterizedType) typeP).getRawType();
            kotlin.jvm.internal.m.d(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            lVar = new l((Class) rawType);
        }
        this.f13049c = lVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z
    public Type P() {
        return this.f13048b;
    }

    @Override // u9.j
    public u9.i c() {
        return this.f13049c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z, u9.d
    public u9.a j(ba.c fqName) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        return null;
    }

    @Override // u9.j
    public String v() {
        throw new UnsupportedOperationException("Type not found: " + P());
    }

    @Override // u9.j
    public List<u9.x> C() {
        List<Type> listC = d.c(P());
        z.a aVar = z.f13060a;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(listC, 10));
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(aVar.a((Type) it.next()));
        }
        return arrayList;
    }

    @Override // u9.d
    public Collection<u9.a> getAnnotations() {
        return kotlin.collections.r.l();
    }

    @Override // u9.j
    public String n() {
        return P().toString();
    }

    @Override // u9.j
    public boolean u() {
        boolean z10;
        Type typeP = P();
        if (typeP instanceof Class) {
            TypeVariable[] typeParameters = ((Class) typeP).getTypeParameters();
            kotlin.jvm.internal.m.e(typeParameters, "getTypeParameters()");
            if (typeParameters.length == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                return true;
            }
        }
        return false;
    }
}
