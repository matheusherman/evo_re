package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.r;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class i implements h {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> f() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<? extends u0> a(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        return r.l();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> b() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> collectionG = g(d.f13985v, sa.e.a());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : collectionG) {
            if (obj instanceof z0) {
                ba.f name = ((z0) obj).getName();
                kotlin.jvm.internal.m.e(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Collection<? extends z0> c(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        return r.l();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    public Set<ba.f> d() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> collectionG = g(d.f13986w, sa.e.a());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : collectionG) {
            if (obj instanceof z0) {
                ba.f name = ((z0) obj).getName();
                kotlin.jvm.internal.m.e(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public kotlin.reflect.jvm.internal.impl.descriptors.h e(ba.f name, r9.b location) {
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(location, "location");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(d kindFilter, c9.l<? super ba.f, Boolean> nameFilter) {
        kotlin.jvm.internal.m.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.m.f(nameFilter, "nameFilter");
        return r.l();
    }
}
